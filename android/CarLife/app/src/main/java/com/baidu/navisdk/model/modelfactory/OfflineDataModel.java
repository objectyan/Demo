package com.baidu.navisdk.model.modelfactory;

import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import java.util.ArrayList;

public class OfflineDataModel
  extends BaseModel
{
  private ArrayList<OfflineDataInfo> mDownloadedList = new ArrayList();
  private ArrayList<OfflineDataInfo> mUnDownloadList = new ArrayList();
  
  public void addDataInDownloaded(OfflineDataInfo paramOfflineDataInfo)
  {
    try
    {
      this.mDownloadedList.add(paramOfflineDataInfo);
      return;
    }
    finally
    {
      paramOfflineDataInfo = finally;
      throw paramOfflineDataInfo;
    }
  }
  
  public void addDataInUnDownload(OfflineDataInfo paramOfflineDataInfo)
  {
    try
    {
      this.mUnDownloadList.add(paramOfflineDataInfo);
      return;
    }
    finally
    {
      paramOfflineDataInfo = finally;
      throw paramOfflineDataInfo;
    }
  }
  
  public OfflineDataInfo getDowloadedInfo(int paramInt)
  {
    int i = 0;
    while ((this.mDownloadedList != null) && (i < this.mDownloadedList.size()))
    {
      OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)this.mDownloadedList.get(i);
      if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mProvinceId == paramInt)) {
        return localOfflineDataInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public ArrayList<OfflineDataInfo> getDowloadedInfo()
  {
    return this.mDownloadedList;
  }
  
  public int getMergeStartID()
  {
    int i = 0;
    while ((this.mDownloadedList != null) && (i < this.mDownloadedList.size()))
    {
      if (((OfflineDataInfo)this.mDownloadedList.get(i)).mTaskStatus == 16) {
        return ((OfflineDataInfo)this.mDownloadedList.get(i)).mProvinceId;
      }
      i += 1;
    }
    return -1;
  }
  
  public OfflineDataInfo getUndowloadInfo(int paramInt)
  {
    int i = 0;
    try
    {
      while ((this.mUnDownloadList != null) && (i < this.mUnDownloadList.size()))
      {
        OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)this.mUnDownloadList.get(i);
        if (localOfflineDataInfo != null)
        {
          int j = localOfflineDataInfo.mProvinceId;
          if (j == paramInt) {
            return localOfflineDataInfo;
          }
        }
        i += 1;
      }
      return null;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      return null;
    }
  }
  
  public ArrayList<OfflineDataInfo> getUndowloadInfo()
  {
    return this.mUnDownloadList;
  }
  
  public void initDownloadedInfo(ArrayList<OfflineDataInfo> paramArrayList)
  {
    try
    {
      this.mDownloadedList.clear();
      if (paramArrayList != null) {
        this.mDownloadedList.addAll(paramArrayList);
      }
      return;
    }
    finally {}
  }
  
  public void initUnDownloadInfo(ArrayList<OfflineDataInfo> paramArrayList)
  {
    try
    {
      this.mUnDownloadList.clear();
      if (paramArrayList != null) {
        this.mUnDownloadList.addAll(paramArrayList);
      }
      return;
    }
    finally {}
  }
  
  public void removeDataInDownloaded(int paramInt)
  {
    int i = 0;
    try
    {
      while ((this.mDownloadedList != null) && (i < this.mDownloadedList.size()))
      {
        if (((OfflineDataInfo)this.mDownloadedList.get(i)).mProvinceId == paramInt) {
          this.mDownloadedList.remove(i);
        }
        i += 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void removeDataInUndownload(int paramInt)
  {
    int i = 0;
    try
    {
      while ((this.mUnDownloadList != null) && (i < this.mUnDownloadList.size()))
      {
        if (((OfflineDataInfo)this.mUnDownloadList.get(i)).mProvinceId == paramInt) {
          this.mUnDownloadList.remove(i);
        }
        i += 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/modelfactory/OfflineDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */