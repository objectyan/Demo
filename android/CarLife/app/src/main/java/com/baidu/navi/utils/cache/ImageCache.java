package com.baidu.navi.utils.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.baidu.navisdk.util.common.MD5;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class ImageCache extends LinkedHashMap<String, Bitmap> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final long serialVersionUID = 1;
    private String mDiskCacheDirectory;
    protected Object mLock = new Object();
    private int mMaxEntries = 0;
    private boolean mNeedRecycle = true;

    public ImageCache(String dir, int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.mMaxEntries = maxCapacity;
        this.mDiskCacheDirectory = dir;
        File outFile = new File(this.mDiskCacheDirectory);
        if (!outFile.exists()) {
            outFile.mkdirs();
        }
    }

    public Bitmap get(Object key) {
        try {
            return (Bitmap) super.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        synchronized (this.mLock) {
            if (this.mNeedRecycle) {
                for (Entry<String, Bitmap> entry : entrySet()) {
                    Bitmap bmp = (Bitmap) entry.getValue();
                    if (!(bmp == null || bmp.isRecycled())) {
                        bmp.recycle();
                    }
                }
            }
            super.clear();
        }
    }

    protected boolean removeEldestEntry(Entry<String, Bitmap> entry) {
        if (size() <= this.mMaxEntries) {
            return false;
        }
        if (this.mNeedRecycle) {
            Bitmap bmp = (Bitmap) entry.getValue();
            if (!(bmp == null || bmp.isRecycled())) {
                bmp.recycle();
            }
        }
        return true;
    }

    public boolean removeFromDiskCache(String key) {
        File file = new File(key);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap readFromDiskCache(java.lang.String r16) {
        /*
        r15 = this;
        r1 = 0;
        r14 = r15.mLock;
        monitor-enter(r14);
        r2 = 0;
        r7 = 0;
        r6 = new java.io.File;	 Catch:{ StreamCorruptedException -> 0x0115, FileNotFoundException -> 0x0110, IOException -> 0x010b }
        r0 = r16;
        r6.<init>(r0);	 Catch:{ StreamCorruptedException -> 0x0115, FileNotFoundException -> 0x0110, IOException -> 0x010b }
        r13 = r6.exists();	 Catch:{ StreamCorruptedException -> 0x0115, FileNotFoundException -> 0x0110, IOException -> 0x010b }
        if (r13 != 0) goto L_0x0028;
    L_0x0013:
        r13 = 0;
        if (r2 == 0) goto L_0x0019;
    L_0x0016:
        r2.close();	 Catch:{ IOException -> 0x0020 }
    L_0x0019:
        if (r7 == 0) goto L_0x001e;
    L_0x001b:
        r7.close();	 Catch:{ IOException -> 0x0020 }
    L_0x001e:
        monitor-exit(r14);	 Catch:{ all -> 0x0025 }
    L_0x001f:
        return r13;
    L_0x0020:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0025 }
        goto L_0x001e;
    L_0x0025:
        r13 = move-exception;
    L_0x0026:
        monitor-exit(r14);	 Catch:{ all -> 0x0025 }
        throw r13;
    L_0x0028:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ StreamCorruptedException -> 0x0115, FileNotFoundException -> 0x0110, IOException -> 0x010b }
        r3.<init>();	 Catch:{ StreamCorruptedException -> 0x0115, FileNotFoundException -> 0x0110, IOException -> 0x010b }
        r8 = new java.io.FileInputStream;	 Catch:{ StreamCorruptedException -> 0x0118, FileNotFoundException -> 0x0112, IOException -> 0x010d, all -> 0x0108 }
        r8.<init>(r6);	 Catch:{ StreamCorruptedException -> 0x0118, FileNotFoundException -> 0x0112, IOException -> 0x010d, all -> 0x0108 }
        r13 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r13];	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
    L_0x0036:
        r12 = r8.read(r4);	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
        r13 = -1;
        if (r12 != r13) goto L_0x007a;
    L_0x003d:
        r4 = r3.toByteArray();	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
        r3.close();	 Catch:{ Exception -> 0x0095 }
        r8.close();	 Catch:{ Exception -> 0x0095 }
    L_0x0047:
        r1 = com.baidu.navi.utils.Tools.getBitmapFromByteArray(r4);	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
        if (r1 != 0) goto L_0x006b;
    L_0x004d:
        r10 = 0;
        r11 = new java.io.ObjectInputStream;	 Catch:{ Exception -> 0x00cb }
        r13 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00cb }
        r13.<init>(r6);	 Catch:{ Exception -> 0x00cb }
        r11.<init>(r13);	 Catch:{ Exception -> 0x00cb }
        r13 = r11.readObject();	 Catch:{ Exception -> 0x011f, all -> 0x011c }
        r13 = (byte[]) r13;	 Catch:{ Exception -> 0x011f, all -> 0x011c }
        r0 = r13;
        r0 = (byte[]) r0;	 Catch:{ Exception -> 0x011f, all -> 0x011c }
        r9 = r0;
        r1 = com.baidu.navi.utils.Tools.getBitmapFromByteArray(r9);	 Catch:{ Exception -> 0x011f, all -> 0x011c }
        if (r11 == 0) goto L_0x006b;
    L_0x0068:
        r11.close();	 Catch:{ IOException -> 0x00b0, StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, all -> 0x00da }
    L_0x006b:
        if (r3 == 0) goto L_0x0070;
    L_0x006d:
        r3.close();	 Catch:{ IOException -> 0x00f4 }
    L_0x0070:
        if (r8 == 0) goto L_0x0075;
    L_0x0072:
        r8.close();	 Catch:{ IOException -> 0x00f4 }
    L_0x0075:
        r7 = r8;
        r2 = r3;
    L_0x0077:
        monitor-exit(r14);	 Catch:{ all -> 0x0025 }
        r13 = r1;
        goto L_0x001f;
    L_0x007a:
        r13 = 0;
        r3.write(r4, r13, r12);	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
        goto L_0x0036;
    L_0x007f:
        r5 = move-exception;
        r7 = r8;
        r2 = r3;
    L_0x0082:
        r5.printStackTrace();	 Catch:{ all -> 0x0106 }
        if (r2 == 0) goto L_0x008a;
    L_0x0087:
        r2.close();	 Catch:{ IOException -> 0x0090 }
    L_0x008a:
        if (r7 == 0) goto L_0x0077;
    L_0x008c:
        r7.close();	 Catch:{ IOException -> 0x0090 }
        goto L_0x0077;
    L_0x0090:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0025 }
        goto L_0x0077;
    L_0x0095:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
        goto L_0x0047;
    L_0x009a:
        r5 = move-exception;
        r7 = r8;
        r2 = r3;
    L_0x009d:
        r5.printStackTrace();	 Catch:{ all -> 0x0106 }
        if (r2 == 0) goto L_0x00a5;
    L_0x00a2:
        r2.close();	 Catch:{ IOException -> 0x00ab }
    L_0x00a5:
        if (r7 == 0) goto L_0x0077;
    L_0x00a7:
        r7.close();	 Catch:{ IOException -> 0x00ab }
        goto L_0x0077;
    L_0x00ab:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0025 }
        goto L_0x0077;
    L_0x00b0:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
        goto L_0x006b;
    L_0x00b5:
        r5 = move-exception;
        r7 = r8;
        r2 = r3;
    L_0x00b8:
        r5.printStackTrace();	 Catch:{ all -> 0x0106 }
        if (r2 == 0) goto L_0x00c0;
    L_0x00bd:
        r2.close();	 Catch:{ IOException -> 0x00c6 }
    L_0x00c0:
        if (r7 == 0) goto L_0x0077;
    L_0x00c2:
        r7.close();	 Catch:{ IOException -> 0x00c6 }
        goto L_0x0077;
    L_0x00c6:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0025 }
        goto L_0x0077;
    L_0x00cb:
        r5 = move-exception;
    L_0x00cc:
        r5.printStackTrace();	 Catch:{ all -> 0x00e8 }
        if (r10 == 0) goto L_0x006b;
    L_0x00d1:
        r10.close();	 Catch:{ IOException -> 0x00d5, StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, all -> 0x00da }
        goto L_0x006b;
    L_0x00d5:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
        goto L_0x006b;
    L_0x00da:
        r13 = move-exception;
        r7 = r8;
        r2 = r3;
    L_0x00dd:
        if (r2 == 0) goto L_0x00e2;
    L_0x00df:
        r2.close();	 Catch:{ IOException -> 0x00fc }
    L_0x00e2:
        if (r7 == 0) goto L_0x00e7;
    L_0x00e4:
        r7.close();	 Catch:{ IOException -> 0x00fc }
    L_0x00e7:
        throw r13;	 Catch:{ all -> 0x0025 }
    L_0x00e8:
        r13 = move-exception;
    L_0x00e9:
        if (r10 == 0) goto L_0x00ee;
    L_0x00eb:
        r10.close();	 Catch:{ IOException -> 0x00ef, StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, all -> 0x00da }
    L_0x00ee:
        throw r13;	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
    L_0x00ef:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ StreamCorruptedException -> 0x007f, FileNotFoundException -> 0x009a, IOException -> 0x00b5, all -> 0x00da }
        goto L_0x00ee;
    L_0x00f4:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0101 }
        r7 = r8;
        r2 = r3;
        goto L_0x0077;
    L_0x00fc:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0025 }
        goto L_0x00e7;
    L_0x0101:
        r13 = move-exception;
        r7 = r8;
        r2 = r3;
        goto L_0x0026;
    L_0x0106:
        r13 = move-exception;
        goto L_0x00dd;
    L_0x0108:
        r13 = move-exception;
        r2 = r3;
        goto L_0x00dd;
    L_0x010b:
        r5 = move-exception;
        goto L_0x00b8;
    L_0x010d:
        r5 = move-exception;
        r2 = r3;
        goto L_0x00b8;
    L_0x0110:
        r5 = move-exception;
        goto L_0x009d;
    L_0x0112:
        r5 = move-exception;
        r2 = r3;
        goto L_0x009d;
    L_0x0115:
        r5 = move-exception;
        goto L_0x0082;
    L_0x0118:
        r5 = move-exception;
        r2 = r3;
        goto L_0x0082;
    L_0x011c:
        r13 = move-exception;
        r10 = r11;
        goto L_0x00e9;
    L_0x011f:
        r5 = move-exception;
        r10 = r11;
        goto L_0x00cc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navi.utils.cache.ImageCache.readFromDiskCache(java.lang.String):android.graphics.Bitmap");
    }

    public boolean cache2Disk(String keypath, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        synchronized (this.mLock) {
            File file = new File(keypath);
            if (!file.exists() || file.length() <= 0) {
                try {
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, baos);
                    baos.writeTo(fos);
                    try {
                        baos.close();
                        fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    return false;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return false;
                }
            }
            return true;
        }
    }

    public boolean cache2Disk(ByteArrayOutputStream baos, String keypath) {
        if (baos == null) {
            return false;
        }
        synchronized (this.mLock) {
            File file = new File(keypath);
            if (!file.exists() || file.length() <= 0) {
                try {
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    baos.writeTo(fos);
                    try {
                        baos.close();
                        fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    return false;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return false;
                }
            }
            return true;
        }
    }

    public Bitmap put(String key, Bitmap value) {
        Bitmap bitmap;
        synchronized (this.mLock) {
            bitmap = (Bitmap) super.put(key, value);
        }
        return bitmap;
    }

    public boolean cache2Disk(InputStream is, String keypath) {
        synchronized (this.mLock) {
            try {
                File f = new File(keypath);
                if (!f.exists() || f.length() <= 0) {
                    f.createNewFile();
                    FileOutputStream fos = new FileOutputStream(f);
                    byte[] buf = new byte[4096];
                    while (true) {
                        int len = is.read(buf);
                        if (len > 0) {
                            fos.write(buf, 0, len);
                        } else {
                            fos.flush();
                            fos.close();
                            return true;
                        }
                    }
                }
                return true;
            } catch (Throwable e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public String getCachePath(String url) {
        return this.mDiskCacheDirectory + File.separator + getFileNameForKey(url);
    }

    public String getFileNameForKey(String url) {
        return MD5.toMD5(url);
    }

    public String getDiskCacheDirectory() {
        return this.mDiskCacheDirectory;
    }
}
