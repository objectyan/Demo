package com.baidu.navi.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.util.f;
import java.io.File;

public final class StorageInformation
{
  private final String dataPath;
  private boolean isEnable = true;
  private final String label;
  private final String primaryCachePath;
  private final boolean removeable;
  private final String rootPath;
  private final String secondaryCachePath;
  
  StorageInformation()
  {
    this.removeable = false;
    this.rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    this.dataPath = (this.rootPath + File.separator + "BaiduCarlife");
    this.primaryCachePath = c.f().getCacheDir().getAbsolutePath();
    this.secondaryCachePath = "";
    this.label = "";
  }
  
  StorageInformation(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.removeable = paramBoolean;
    this.rootPath = paramString1;
    this.dataPath = (this.rootPath + File.separator + "BaiduCarlife");
    this.primaryCachePath = (this.dataPath + File.separator + "cache");
    this.secondaryCachePath = c.f().getCacheDir().getAbsolutePath();
    this.label = paramString2;
  }
  
  public StorageInformation(boolean paramBoolean, String paramString)
  {
    this.isEnable = paramBoolean;
    this.removeable = false;
    this.rootPath = paramString;
    this.dataPath = (this.rootPath + File.separator + "BaiduCarlife");
    this.primaryCachePath = (this.dataPath + File.separator + "cache");
    this.secondaryCachePath = c.f().getCacheDir().getAbsolutePath();
    this.label = "";
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!StorageInformation.class.isInstance(paramObject))) {
      return false;
    }
    paramObject = (StorageInformation)paramObject;
    return this.rootPath.equals(((StorageInformation)paramObject).rootPath);
  }
  
  @SuppressLint({"NewApi"})
  public long getAvailableBytes()
  {
    try
    {
      StatFs localStatFs = new StatFs(this.rootPath);
      if (Build.VERSION.SDK_INT >= 18) {
        return localStatFs.getAvailableBytes();
      }
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Exception localException)
    {
      f.a(StorageInformation.class.getSimpleName(), "exception", localException);
      return -1L;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return -1L;
  }
  
  public String getDataPath()
  {
    return this.rootPath + File.separator + "BaiduCarlife";
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public String getPrimaryCachePath()
  {
    return this.primaryCachePath;
  }
  
  public String getRootPath()
  {
    return this.rootPath;
  }
  
  public String getSecondaryCachePath()
  {
    return this.secondaryCachePath;
  }
  
  public boolean isEnable()
  {
    return this.isEnable;
  }
  
  public boolean isRemoveable()
  {
    return this.removeable;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/common/util/StorageInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */