package com.baidu.navisdk.util.cache;

import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.FileUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CacheManagerImpl
  implements CacheManager
{
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
  
  public CacheManagerImpl(String paramString)
  {
    this.mCachePath = paramString;
    paramString = new File(this.mCachePath);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    this.mCache = new HashMap();
    this.mApproximateDiskCacheSize = -1;
  }
  
  public void clear()
  {
    this.mCache.clear();
    File[] arrayOfFile = new File(this.mCachePath).listFiles();
    if (arrayOfFile == null) {}
    for (;;)
    {
      return;
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public void delete(Cacheable paramCacheable)
  {
    synchronized (lock)
    {
      deleteFromMemory(paramCacheable);
      deleteFromDisk(paramCacheable);
      return;
    }
  }
  
  void deleteFromDisk(Cacheable paramCacheable)
  {
    getDiskCacheFile(paramCacheable).deleteOnExit();
  }
  
  void deleteFromMemory(Cacheable paramCacheable)
  {
    paramCacheable = paramCacheable.getCacheKey();
    this.mCache.remove(paramCacheable);
  }
  
  void ensureDiskCapacity()
  {
    File[] arrayOfFile;
    if ((this.mApproximateDiskCacheSize < 0) || (this.mApproximateDiskCacheSize > 100))
    {
      arrayOfFile = new File(this.mCachePath).listFiles(sCacheFilenameFilter);
      if (arrayOfFile != null) {
        break label39;
      }
    }
    for (;;)
    {
      return;
      label39:
      int j = arrayOfFile.length;
      this.mApproximateDiskCacheSize = j;
      if (j >= 100)
      {
        Arrays.sort(arrayOfFile, sCacheFileComparator);
        int i = 0;
        while ((i < j) && (this.mApproximateDiskCacheSize > 75))
        {
          if (arrayOfFile[i].delete()) {
            this.mApproximateDiskCacheSize -= 1;
          }
          i += 1;
        }
      }
    }
  }
  
  public CacheManager.CacheResult get(Cacheable paramCacheable)
  {
    return get(paramCacheable, 0L);
  }
  
  public CacheManager.CacheResult get(Cacheable paramCacheable, long paramLong)
  {
    CacheEntry localCacheEntry1;
    synchronized (lock)
    {
      CacheEntry localCacheEntry2 = readFromMemory(paramCacheable);
      localCacheEntry1 = localCacheEntry2;
      if (localCacheEntry2 == null) {
        localCacheEntry1 = readFromDisk(paramCacheable);
      }
      if (localCacheEntry1 == null) {
        break label109;
      }
      paramCacheable = new CacheManager.CacheResult();
      long l = System.currentTimeMillis();
      if ((paramLong > 0L) && (l - localCacheEntry1.createTime > paramLong))
      {
        paramCacheable.isExpired = true;
        return paramCacheable;
      }
    }
    paramCacheable.isExpired = false;
    paramCacheable.msg = localCacheEntry1.msg;
    paramCacheable.extraData = localCacheEntry1.extraData;
    return paramCacheable;
    label109:
    return null;
  }
  
  File getDiskCacheFile(Cacheable paramCacheable)
  {
    paramCacheable = FileUtils.sanitizeFilename(paramCacheable.getCacheKey());
    return new File(new File(this.mCachePath), "PLUGIN_" + paramCacheable);
  }
  
  public void put(Cacheable paramCacheable, RspData paramRspData, Serializable paramSerializable)
  {
    synchronized (lock)
    {
      CacheEntry localCacheEntry = new CacheEntry();
      localCacheEntry.msg = paramRspData;
      localCacheEntry.extraData = paramSerializable;
      localCacheEntry.createTime = System.currentTimeMillis();
      writeToMemory(paramCacheable, localCacheEntry);
      writeToDisk(paramCacheable, localCacheEntry);
      return;
    }
  }
  
  /* Error */
  CacheEntry readFromDisk(Cacheable paramCacheable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 101	com/baidu/navisdk/util/cache/CacheManagerImpl:getDiskCacheFile	(Lcom/baidu/navisdk/util/cache/Cacheable;)Ljava/io/File;
    //   5: astore_3
    //   6: aload_3
    //   7: invokevirtual 68	java/io/File:exists	()Z
    //   10: ifne +7 -> 17
    //   13: aconst_null
    //   14: astore_1
    //   15: aload_1
    //   16: areturn
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 6
    //   23: aconst_null
    //   24: astore 7
    //   26: aconst_null
    //   27: astore_2
    //   28: aconst_null
    //   29: astore 4
    //   31: new 203	java/io/ObjectInputStream
    //   34: dup
    //   35: new 205	java/io/FileInputStream
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 208	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 211	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore_3
    //   47: aload_3
    //   48: invokevirtual 215	java/io/ObjectInputStream:readInt	()I
    //   51: pop
    //   52: new 8	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 186	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:<init>	(Lcom/baidu/navisdk/util/cache/CacheManagerImpl;)V
    //   60: astore_2
    //   61: aload_2
    //   62: aload_3
    //   63: invokevirtual 218	java/io/ObjectInputStream:readLong	()J
    //   66: putfield 149	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:createTime	J
    //   69: aload_3
    //   70: invokevirtual 221	java/io/ObjectInputStream:readBoolean	()Z
    //   73: ifeq +20 -> 93
    //   76: aload_2
    //   77: aload_1
    //   78: aload_3
    //   79: invokevirtual 225	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   82: checkcast 227	java/io/Serializable
    //   85: invokeinterface 231 2 0
    //   90: putfield 156	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:msg	Lcom/baidu/navisdk/logic/RspData;
    //   93: aload_3
    //   94: invokevirtual 221	java/io/ObjectInputStream:readBoolean	()Z
    //   97: ifeq +14 -> 111
    //   100: aload_2
    //   101: aload_3
    //   102: invokevirtual 225	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   105: checkcast 227	java/io/Serializable
    //   108: putfield 161	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:extraData	Ljava/io/Serializable;
    //   111: aload_2
    //   112: astore_1
    //   113: aload_3
    //   114: ifnull -99 -> 15
    //   117: aload_3
    //   118: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   121: aload_2
    //   122: areturn
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   128: aload_2
    //   129: areturn
    //   130: astore_3
    //   131: aload 4
    //   133: astore_1
    //   134: aload_1
    //   135: astore_2
    //   136: aload_3
    //   137: invokevirtual 238	java/io/StreamCorruptedException:printStackTrace	()V
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   155: goto -7 -> 148
    //   158: astore_3
    //   159: aload 5
    //   161: astore_1
    //   162: aload_1
    //   163: astore_2
    //   164: aload_3
    //   165: invokevirtual 239	java/io/FileNotFoundException:printStackTrace	()V
    //   168: aload_1
    //   169: ifnull -21 -> 148
    //   172: aload_1
    //   173: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   176: goto -28 -> 148
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   184: goto -36 -> 148
    //   187: astore_3
    //   188: aload 6
    //   190: astore_1
    //   191: aload_1
    //   192: astore_2
    //   193: aload_3
    //   194: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   197: aload_1
    //   198: ifnull -50 -> 148
    //   201: aload_1
    //   202: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   205: goto -57 -> 148
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   213: goto -65 -> 148
    //   216: astore_3
    //   217: aload 7
    //   219: astore_1
    //   220: aload_1
    //   221: astore_2
    //   222: aload_3
    //   223: invokevirtual 240	java/lang/ClassNotFoundException:printStackTrace	()V
    //   226: aload_1
    //   227: ifnull -79 -> 148
    //   230: aload_1
    //   231: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   234: goto -86 -> 148
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   242: goto -94 -> 148
    //   245: astore_1
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   254: aload_1
    //   255: athrow
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   261: goto -7 -> 254
    //   264: astore_1
    //   265: aload_3
    //   266: astore_2
    //   267: goto -21 -> 246
    //   270: astore_2
    //   271: aload_3
    //   272: astore_1
    //   273: aload_2
    //   274: astore_3
    //   275: goto -55 -> 220
    //   278: astore_2
    //   279: aload_3
    //   280: astore_1
    //   281: aload_2
    //   282: astore_3
    //   283: goto -92 -> 191
    //   286: astore_2
    //   287: aload_3
    //   288: astore_1
    //   289: aload_2
    //   290: astore_3
    //   291: goto -129 -> 162
    //   294: astore_2
    //   295: aload_3
    //   296: astore_1
    //   297: aload_2
    //   298: astore_3
    //   299: goto -165 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	CacheManagerImpl
    //   0	302	1	paramCacheable	Cacheable
    //   27	224	2	localObject1	Object
    //   256	2	2	localIOException1	java.io.IOException
    //   266	1	2	localClassNotFoundException1	ClassNotFoundException
    //   270	4	2	localClassNotFoundException2	ClassNotFoundException
    //   278	4	2	localIOException2	java.io.IOException
    //   286	4	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   294	4	2	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   5	113	3	localObject2	Object
    //   130	7	3	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   158	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   187	7	3	localIOException3	java.io.IOException
    //   216	56	3	localClassNotFoundException3	ClassNotFoundException
    //   274	25	3	localObject3	Object
    //   29	103	4	localObject4	Object
    //   18	142	5	localObject5	Object
    //   21	168	6	localObject6	Object
    //   24	194	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   117	121	123	java/io/IOException
    //   31	47	130	java/io/StreamCorruptedException
    //   144	148	150	java/io/IOException
    //   31	47	158	java/io/FileNotFoundException
    //   172	176	179	java/io/IOException
    //   31	47	187	java/io/IOException
    //   201	205	208	java/io/IOException
    //   31	47	216	java/lang/ClassNotFoundException
    //   230	234	237	java/io/IOException
    //   31	47	245	finally
    //   136	140	245	finally
    //   164	168	245	finally
    //   193	197	245	finally
    //   222	226	245	finally
    //   250	254	256	java/io/IOException
    //   47	93	264	finally
    //   93	111	264	finally
    //   47	93	270	java/lang/ClassNotFoundException
    //   93	111	270	java/lang/ClassNotFoundException
    //   47	93	278	java/io/IOException
    //   93	111	278	java/io/IOException
    //   47	93	286	java/io/FileNotFoundException
    //   93	111	286	java/io/FileNotFoundException
    //   47	93	294	java/io/StreamCorruptedException
    //   93	111	294	java/io/StreamCorruptedException
  }
  
  CacheEntry readFromMemory(Cacheable paramCacheable)
  {
    String str = paramCacheable.getCacheKey();
    Object localObject = (SoftReference)this.mCache.get(str);
    paramCacheable = null;
    if (localObject != null)
    {
      localObject = (CacheEntry)((SoftReference)localObject).get();
      paramCacheable = (Cacheable)localObject;
      if (localObject == null)
      {
        this.mCache.remove(str);
        paramCacheable = (Cacheable)localObject;
      }
    }
    return paramCacheable;
  }
  
  /* Error */
  void writeToDisk(Cacheable paramCacheable, CacheEntry paramCacheEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 248	com/baidu/navisdk/util/cache/CacheManagerImpl:ensureDiskCapacity	()V
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 101	com/baidu/navisdk/util/cache/CacheManagerImpl:getDiskCacheFile	(Lcom/baidu/navisdk/util/cache/Cacheable;)Ljava/io/File;
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: new 250	java/io/ObjectOutputStream
    //   22: dup
    //   23: new 252	java/io/FileOutputStream
    //   26: dup
    //   27: aload 7
    //   29: invokespecial 253	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: invokespecial 256	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 4
    //   37: aload 4
    //   39: iconst_1
    //   40: invokevirtual 260	java/io/ObjectOutputStream:writeInt	(I)V
    //   43: aload 4
    //   45: aload_2
    //   46: getfield 149	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:createTime	J
    //   49: invokevirtual 264	java/io/ObjectOutputStream:writeLong	(J)V
    //   52: aload_2
    //   53: getfield 156	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:msg	Lcom/baidu/navisdk/logic/RspData;
    //   56: ifnull +102 -> 158
    //   59: aload_1
    //   60: aload_2
    //   61: getfield 156	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:msg	Lcom/baidu/navisdk/logic/RspData;
    //   64: invokeinterface 268 2 0
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +53 -> 124
    //   74: aload 4
    //   76: iconst_1
    //   77: invokevirtual 272	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 276	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   86: aload_2
    //   87: getfield 161	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:extraData	Ljava/io/Serializable;
    //   90: ifnull +110 -> 200
    //   93: aload 4
    //   95: iconst_1
    //   96: invokevirtual 272	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   99: aload 4
    //   101: aload_2
    //   102: getfield 161	com/baidu/navisdk/util/cache/CacheManagerImpl$CacheEntry:extraData	Ljava/io/Serializable;
    //   105: invokevirtual 276	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   108: aload 4
    //   110: invokevirtual 279	java/io/ObjectOutputStream:flush	()V
    //   113: aload 4
    //   115: ifnull +140 -> 255
    //   118: aload 4
    //   120: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   123: return
    //   124: aload 4
    //   126: iconst_0
    //   127: invokevirtual 272	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   130: goto -44 -> 86
    //   133: astore_2
    //   134: aload 4
    //   136: astore_1
    //   137: aload_1
    //   138: astore_3
    //   139: aload_2
    //   140: invokevirtual 239	java/io/FileNotFoundException:printStackTrace	()V
    //   143: aload_1
    //   144: ifnull -21 -> 123
    //   147: aload_1
    //   148: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   151: return
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   157: return
    //   158: aload 4
    //   160: iconst_0
    //   161: invokevirtual 272	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   164: goto -78 -> 86
    //   167: astore_2
    //   168: aload 4
    //   170: astore_1
    //   171: aload_1
    //   172: astore_3
    //   173: aload_2
    //   174: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   177: aload_1
    //   178: astore_3
    //   179: aload 7
    //   181: invokevirtual 90	java/io/File:delete	()Z
    //   184: pop
    //   185: aload_1
    //   186: ifnull -63 -> 123
    //   189: aload_1
    //   190: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   193: return
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   199: return
    //   200: aload 4
    //   202: iconst_0
    //   203: invokevirtual 272	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   206: goto -98 -> 108
    //   209: astore_1
    //   210: aload 4
    //   212: astore_3
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   228: return
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   234: goto -13 -> 221
    //   237: astore_1
    //   238: goto -25 -> 213
    //   241: astore_2
    //   242: aload 6
    //   244: astore_1
    //   245: goto -74 -> 171
    //   248: astore_2
    //   249: aload 5
    //   251: astore_1
    //   252: goto -115 -> 137
    //   255: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	CacheManagerImpl
    //   0	256	1	paramCacheable	Cacheable
    //   0	256	2	paramCacheEntry	CacheEntry
    //   15	203	3	localObject1	Object
    //   35	176	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   17	233	5	localObject2	Object
    //   12	231	6	localObject3	Object
    //   9	171	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	70	133	java/io/FileNotFoundException
    //   74	86	133	java/io/FileNotFoundException
    //   86	108	133	java/io/FileNotFoundException
    //   108	113	133	java/io/FileNotFoundException
    //   124	130	133	java/io/FileNotFoundException
    //   158	164	133	java/io/FileNotFoundException
    //   200	206	133	java/io/FileNotFoundException
    //   147	151	152	java/io/IOException
    //   37	70	167	java/io/IOException
    //   74	86	167	java/io/IOException
    //   86	108	167	java/io/IOException
    //   108	113	167	java/io/IOException
    //   124	130	167	java/io/IOException
    //   158	164	167	java/io/IOException
    //   200	206	167	java/io/IOException
    //   189	193	194	java/io/IOException
    //   37	70	209	finally
    //   74	86	209	finally
    //   86	108	209	finally
    //   108	113	209	finally
    //   124	130	209	finally
    //   158	164	209	finally
    //   200	206	209	finally
    //   118	123	223	java/io/IOException
    //   217	221	229	java/io/IOException
    //   19	37	237	finally
    //   139	143	237	finally
    //   173	177	237	finally
    //   179	185	237	finally
    //   19	37	241	java/io/IOException
    //   19	37	248	java/io/FileNotFoundException
  }
  
  void writeToMemory(Cacheable paramCacheable, CacheEntry paramCacheEntry)
  {
    paramCacheable = paramCacheable.getCacheKey();
    paramCacheEntry = new SoftReference(paramCacheEntry);
    this.mCache.put(paramCacheable, paramCacheEntry);
  }
  
  class CacheEntry
  {
    public long createTime;
    public Serializable extraData;
    public RspData msg;
    
    CacheEntry() {}
  }
  
  static class CacheFileComparator
    implements Comparator<File>
  {
    public int compare(File paramFile1, File paramFile2)
    {
      if (paramFile1.lastModified() > paramFile2.lastModified()) {
        return -1;
      }
      return 1;
    }
  }
  
  static class CacheFilenameFilter
    implements FilenameFilter
  {
    public boolean accept(File paramFile, String paramString)
    {
      return paramString.startsWith("PLUGIN_");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/cache/CacheManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */