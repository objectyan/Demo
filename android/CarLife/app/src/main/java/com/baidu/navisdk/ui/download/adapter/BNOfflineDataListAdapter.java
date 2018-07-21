package com.baidu.navisdk.ui.download.adapter;

import android.widget.BaseAdapter;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;

public abstract class BNOfflineDataListAdapter
  extends BaseAdapter
{
  public abstract void checkToStartDownloadRequest(OfflineDataInfo paramOfflineDataInfo, boolean paramBoolean);
  
  public abstract void chooseDownloadStrategy(OfflineDataInfo paramOfflineDataInfo, boolean paramBoolean);
  
  public abstract void chooseUpdateStrategy(OfflineDataInfo paramOfflineDataInfo);
  
  public abstract OfflineDataInfo getDownloadedListModelByPosition(int paramInt);
  
  public abstract long getmDiskSpace();
  
  public abstract long getmTotalDownloadSize();
  
  public abstract void startCheckNetStatus(int paramInt, boolean paramBoolean);
  
  public abstract void updateData();
  
  public abstract void updateDiskSpace();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/download/adapter/BNOfflineDataListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */