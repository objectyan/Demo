package com.baidu.navisdk.util.common;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.IOException;

public class SDCardUtils
{
  public static final int MIN_CACHE_FREE_SIZE = 20971520;
  public static final int MIN_FREE_SIZE = 15728640;
  private static final double MIN_FREE_SPACE = 10.0D;
  public static final int SDCARD_ERROR = 2;
  public static final int SDCARD_FULL = 1;
  public static final int SDCARD_NORMAL = 0;
  public static final int SDCARD_NOTFOUND = 3;
  public static final String TAG = "StorageCheck";
  
  private static int checkOfflinePathAvailable()
  {
    File localFile = new File(SysOSAPI.getInstance().getOfflineDataPath());
    if ((localFile.exists()) && (localFile.canRead()) && (localFile.canWrite())) {
      return 0;
    }
    return 3;
  }
  
  public static File getExternalStorageFile()
  {
    return new File(SysOSAPI.getInstance().getSDcardRootPath());
  }
  
  public static String getExternalStoragePath()
  {
    return SysOSAPI.getInstance().getSDcardRootPath();
  }
  
  private static StatFs getOfflinePathSize()
  {
    return new StatFs(SysOSAPI.getInstance().getOfflineDataPath());
  }
  
  private static StatFs getSdcardSize()
  {
    if (StringUtils.isEmpty(SysOSAPI.getInstance().getSDcardRootPath())) {
      return new StatFs(Environment.getExternalStorageDirectory().getPath());
    }
    try
    {
      StatFs localStatFs = new StatFs(SysOSAPI.getInstance().getSDcardRootPath());
      return localStatFs;
    }
    catch (Exception localException) {}
    return new StatFs(Environment.getExternalStorageDirectory().getPath());
  }
  
  public static long getSdcardSpace()
  {
    localLong2 = Long.valueOf(0L);
    Object localObject = localLong2;
    try
    {
      if (getSdcardState() == 0)
      {
        localObject = getSdcardSize();
        long l1 = ((StatFs)localObject).getBlockSize();
        long l2 = ((StatFs)localObject).getFreeBlocks();
        localObject = Long.valueOf(l1 * l2);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Long localLong1 = localLong2;
      }
    }
    return ((Long)localObject).longValue();
  }
  
  public static int getSdcardState()
  {
    int j = 0;
    String str = Environment.getExternalStorageState();
    int i;
    if ((str == null) || ("bad_removal".equals(str))) {
      i = 2;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while ("checking".equals(str));
        i = j;
      } while ("mounted".equals(str));
      if ("mounted_ro".equals(str)) {
        return 2;
      }
      if ("nofs".equals(str)) {
        return 2;
      }
      if ("removed".equals(str)) {
        return 3;
      }
      if ("shared".equals(str)) {
        return 3;
      }
      if ("unmountable".equals(str)) {
        return 2;
      }
      i = j;
    } while (!"unmounted".equals(str));
    return 3;
  }
  
  public static int handleOfflinePathError(long paramLong, boolean paramBoolean)
  {
    int k = checkOfflinePathAvailable();
    int j = k;
    long l1;
    long l2;
    if (k == 0)
    {
      StatFs localStatFs = getOfflinePathSize();
      l1 = localStatFs.getBlockSize();
      l2 = localStatFs.getFreeBlocks();
      if (!paramBoolean) {
        break label65;
      }
    }
    label65:
    for (int i = 15728640;; i = 0)
    {
      j = k;
      if (l1 * l2 < i + paramLong) {
        j = 1;
      }
      return j;
    }
  }
  
  public static int handleSdcardError(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    try
    {
      int j = getSdcardState();
      int k = j;
      if (j == 0)
      {
        i = j;
        StatFs localStatFs = getSdcardSize();
        i = j;
        long l1 = localStatFs.getBlockSize();
        i = j;
        k = localStatFs.getFreeBlocks();
        long l2 = k;
        if (paramBoolean) {}
        for (i = 15728640;; i = 0)
        {
          k = j;
          if (l1 * l2 >= i + paramLong) {
            break;
          }
          return 1;
        }
      }
      return k;
    }
    catch (Exception localException)
    {
      k = i;
    }
  }
  
  public static boolean writeTestFileToSdcard(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      paramString = new File(paramString + "/test.0");
      bool1 = bool2;
      if (paramString.exists())
      {
        bool1 = bool2;
        paramString.delete();
      }
      bool1 = bool2;
      bool2 = paramString.createNewFile();
      bool1 = bool2;
      if (paramString.exists())
      {
        bool1 = bool2;
        paramString.delete();
      }
      return bool2;
    }
    catch (IOException paramString)
    {
      LogUtil.e("", paramString.toString());
    }
    return bool1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/SDCardUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */