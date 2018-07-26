package com.baidu.navisdk.util.cache;

import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.cache.CacheManager.CacheResult;
import com.baidu.navisdk.util.common.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CacheManagerImpl implements CacheManager {
    private static final String CACHE_FILENAME_PREFIX = "PLUGIN_";
    private static final int DISK_CACHE_CAPACITY = 100;
    private static final int DISK_CACHE_TARGET_SIZE = 75;
    private static final int DISK_CACHE_VERSION = 1;
    private static final String TAG = "CacheManagerImpl";
    private static final boolean USE_MEMORY_CACHE = true;
    private static final Object lock = new Object();
    private static final Comparator<File> sCacheFileComparator = new CacheFileComparator();
    private static final FilenameFilter sCacheFilenameFilter = new CacheFilenameFilter();
    private int mApproximateDiskCacheSize;
    private final Map<String, SoftReference<CacheEntry>> mCache;
    private final String mCachePath;

    class CacheEntry {
        public long createTime;
        public Serializable extraData;
        public RspData msg;

        CacheEntry() {
        }
    }

    static class CacheFileComparator implements Comparator<File> {
        CacheFileComparator() {
        }

        public int compare(File f1, File f2) {
            if (f1.lastModified() > f2.lastModified()) {
                return -1;
            }
            return 1;
        }
    }

    static class CacheFilenameFilter implements FilenameFilter {
        CacheFilenameFilter() {
        }

        public boolean accept(File paramFile, String paramString) {
            return paramString.startsWith(CacheManagerImpl.CACHE_FILENAME_PREFIX);
        }
    }

    public CacheManagerImpl(String cachePath) {
        this.mCachePath = cachePath;
        File file = new File(this.mCachePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mCache = new HashMap();
        this.mApproximateDiskCacheSize = -1;
    }

    public void put(Cacheable cacheable, RspData msg, Serializable extraData) {
        synchronized (lock) {
            CacheEntry entry = new CacheEntry();
            entry.msg = msg;
            entry.extraData = extraData;
            entry.createTime = System.currentTimeMillis();
            writeToMemory(cacheable, entry);
            writeToDisk(cacheable, entry);
        }
    }

    public CacheResult get(Cacheable cacheable) {
        return get(cacheable, 0);
    }

    public CacheResult get(Cacheable cacheable, long duration) {
        synchronized (lock) {
            CacheEntry entry = readFromMemory(cacheable);
            if (entry == null) {
                entry = readFromDisk(cacheable);
            }
        }
        if (entry == null) {
            return null;
        }
        CacheResult cache = new CacheResult();
        long currTime = System.currentTimeMillis();
        if (duration <= 0 || currTime - entry.createTime <= duration) {
            cache.isExpired = false;
            cache.msg = entry.msg;
            cache.extraData = entry.extraData;
            return cache;
        }
        cache.isExpired = true;
        return cache;
    }

    public void delete(Cacheable cacheable) {
        synchronized (lock) {
            deleteFromMemory(cacheable);
            deleteFromDisk(cacheable);
        }
    }

    void writeToMemory(Cacheable cacheable, CacheEntry entry) {
        this.mCache.put(cacheable.getCacheKey(), new SoftReference(entry));
    }

    CacheEntry readFromMemory(Cacheable cacheable) {
        String key = cacheable.getCacheKey();
        SoftReference<CacheEntry> ref = (SoftReference) this.mCache.get(key);
        CacheEntry entry = null;
        if (ref != null) {
            entry = (CacheEntry) ref.get();
            if (entry == null) {
                this.mCache.remove(key);
            }
        }
        return entry;
    }

    void deleteFromMemory(Cacheable cacheable) {
        this.mCache.remove(cacheable.getCacheKey());
    }

    void writeToDisk(Cacheable cacheable, CacheEntry entry) {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        ensureDiskCapacity();
        File file = getDiskCacheFile(cacheable);
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            try {
                os.writeInt(1);
                os.writeLong(entry.createTime);
                if (entry.msg != null) {
                    Serializable data = cacheable.serializeCache(entry.msg);
                    if (data != null) {
                        os.writeBoolean(true);
                        os.writeObject(data);
                    } else {
                        os.writeBoolean(false);
                    }
                } else {
                    os.writeBoolean(false);
                }
                if (entry.extraData != null) {
                    os.writeBoolean(true);
                    os.writeObject(entry.extraData);
                } else {
                    os.writeBoolean(false);
                }
                os.flush();
                if (os != null) {
                    try {
                        os.close();
                        objectOutputStream = os;
                        return;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        objectOutputStream = os;
                        return;
                    }
                }
            } catch (FileNotFoundException e4) {
                e2 = e4;
                objectOutputStream = os;
                try {
                    e2.printStackTrace();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e322) {
                            e322.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e322 = e5;
                objectOutputStream = os;
                e322.printStackTrace();
                file.delete();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3222) {
                        e3222.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = os;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e2 = e6;
            e2.printStackTrace();
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (IOException e7) {
            e3222 = e7;
            e3222.printStackTrace();
            file.delete();
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
    }

    CacheEntry readFromDisk(Cacheable cacheable) {
        IOException e;
        StreamCorruptedException e2;
        Throwable th;
        FileNotFoundException e3;
        ClassNotFoundException e4;
        File file = getDiskCacheFile(cacheable);
        if (!file.exists()) {
            return null;
        }
        ObjectInputStream is = null;
        try {
            ObjectInputStream is2 = new ObjectInputStream(new FileInputStream(file));
            try {
                int ver = is2.readInt();
                CacheEntry entry = new CacheEntry();
                entry.createTime = is2.readLong();
                if (is2.readBoolean()) {
                    entry.msg = cacheable.deserializeCache((Serializable) is2.readObject());
                }
                if (is2.readBoolean()) {
                    entry.extraData = (Serializable) is2.readObject();
                }
                if (is2 == null) {
                    return entry;
                }
                try {
                    is2.close();
                    return entry;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return entry;
                }
            } catch (StreamCorruptedException e6) {
                e2 = e6;
                is = is2;
                try {
                    e2.printStackTrace();
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e52) {
                            e52.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e522) {
                            e522.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e3 = e7;
                is = is2;
                e3.printStackTrace();
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e5222) {
                        e5222.printStackTrace();
                    }
                }
                return null;
            } catch (IOException e8) {
                e5222 = e8;
                is = is2;
                e5222.printStackTrace();
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e52222) {
                        e52222.printStackTrace();
                    }
                }
                return null;
            } catch (ClassNotFoundException e9) {
                e4 = e9;
                is = is2;
                e4.printStackTrace();
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e522222) {
                        e522222.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                is = is2;
                if (is != null) {
                    is.close();
                }
                throw th;
            }
        } catch (StreamCorruptedException e10) {
            e2 = e10;
            e2.printStackTrace();
            if (is != null) {
                is.close();
            }
            return null;
        } catch (FileNotFoundException e11) {
            e3 = e11;
            e3.printStackTrace();
            if (is != null) {
                is.close();
            }
            return null;
        } catch (IOException e12) {
            e522222 = e12;
            e522222.printStackTrace();
            if (is != null) {
                is.close();
            }
            return null;
        } catch (ClassNotFoundException e13) {
            e4 = e13;
            e4.printStackTrace();
            if (is != null) {
                is.close();
            }
            return null;
        }
    }

    void deleteFromDisk(Cacheable cacheable) {
        getDiskCacheFile(cacheable).deleteOnExit();
    }

    void ensureDiskCapacity() {
        if (this.mApproximateDiskCacheSize < 0 || this.mApproximateDiskCacheSize > 100) {
            File[] files = new File(this.mCachePath).listFiles(sCacheFilenameFilter);
            if (files != null) {
                int len = files.length;
                this.mApproximateDiskCacheSize = len;
                if (len >= 100) {
                    Arrays.sort(files, sCacheFileComparator);
                    for (int i = 0; i < len && this.mApproximateDiskCacheSize > 75; i++) {
                        if (files[i].delete()) {
                            this.mApproximateDiskCacheSize--;
                        }
                    }
                }
            }
        }
    }

    File getDiskCacheFile(Cacheable cacheable) {
        return new File(new File(this.mCachePath), CACHE_FILENAME_PREFIX + FileUtils.sanitizeFilename(cacheable.getCacheKey()));
    }

    public void clear() {
        this.mCache.clear();
        File[] files = new File(this.mCachePath).listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.exists()) {
                    f.delete();
                }
            }
        }
    }
}
