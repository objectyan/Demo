package com.baidu.navi.adapter;

import android.widget.BaseAdapter;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;

public abstract class OfflineDataListAdapter extends BaseAdapter {
    public abstract void checkToStartDownloadRequest(OfflineDataInfo offlineDataInfo, boolean z);

    public abstract void chooseDownloadStrategy(OfflineDataInfo offlineDataInfo, boolean z);

    public abstract void chooseUpdateStrategy(OfflineDataInfo offlineDataInfo);

    public abstract OfflineDataInfo getDownloadedListModelByPosition(int i);

    public abstract long getmDiskSpace();

    public abstract long getmTotalDownloadSize();

    public abstract void startCheckNetStatus(int i, boolean z);

    public abstract void updateData();

    public abstract void updateDiskSpace();
}
