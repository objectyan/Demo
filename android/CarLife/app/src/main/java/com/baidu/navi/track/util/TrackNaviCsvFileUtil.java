package com.baidu.navi.track.util;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.navi.common.util.StorageInformation;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.util.List;

public class TrackNaviCsvFileUtil
{
  private static final String APPDIR = "BaiduCarlife/bnav/trajectory";
  private static final String FILE_EXTENSION = ".bin.gz";
  private static final String TAG = TrackNaviCsvFileUtil.class.getSimpleName();
  
  public static void cleanTrackFile()
  {
    long l = System.currentTimeMillis();
    Object localObject = new File(getAppDir());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if (localObject != null) {
        break label39;
      }
    }
    for (;;)
    {
      return;
      label39:
      int i = 0;
      while (i < localObject.length)
      {
        if ((localObject[i].exists()) && (localObject[i].isFile()) && (localObject[i].lastModified() <= l + 1627869184L)) {
          i.b(TAG, "delete file " + localObject[i].getAbsolutePath() + " " + localObject[i].delete());
        }
        i += 1;
      }
    }
  }
  
  public static void deleteGuidsFile(String paramString)
  {
    List localList = StorageSettings.getInstance().getAllStorages();
    if (localList == null) {
      return;
    }
    int i = 0;
    label14:
    Object localObject;
    if (i < localList.size())
    {
      localObject = (StorageInformation)localList.get(i);
      if (localObject != null) {
        break label48;
      }
    }
    label48:
    File localFile;
    do
    {
      do
      {
        i += 1;
        break label14;
        break;
        localObject = getFilePath(paramString, ((StorageInformation)localObject).getRootPath());
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localFile = new File((String)localObject);
      localFile.lastModified();
    } while (!localFile.exists());
    boolean bool = localFile.delete();
    i.b(TAG, "delete file " + (String)localObject + " " + bool);
  }
  
  public static String getAppDir()
  {
    return SysOSAPIv2.getInstance().getSdcardPath() + File.separator + "BaiduCarlife/bnav/trajectory";
  }
  
  public static String getFilePath(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = "";
    }
    do
    {
      return paramString1;
      paramString2 = paramString2 + File.separator + "BaiduCarlife/bnav/trajectory" + File.separator + paramString1 + ".bin.gz";
      i.b(TAG, paramString2);
      paramString1 = paramString2;
    } while (new File(paramString2).exists());
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/util/TrackNaviCsvFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */