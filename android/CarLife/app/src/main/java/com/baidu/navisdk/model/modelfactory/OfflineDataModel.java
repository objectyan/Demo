package com.baidu.navisdk.model.modelfactory;

import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import java.util.ArrayList;

public class OfflineDataModel extends BaseModel {
    private ArrayList<OfflineDataInfo> mDownloadedList = new ArrayList();
    private ArrayList<OfflineDataInfo> mUnDownloadList = new ArrayList();

    public synchronized void initUnDownloadInfo(ArrayList<OfflineDataInfo> unDownloadMap) {
        this.mUnDownloadList.clear();
        if (unDownloadMap != null) {
            this.mUnDownloadList.addAll(unDownloadMap);
        }
    }

    public synchronized void initDownloadedInfo(ArrayList<OfflineDataInfo> downloadedMap) {
        this.mDownloadedList.clear();
        if (downloadedMap != null) {
            this.mDownloadedList.addAll(downloadedMap);
        }
    }

    public ArrayList<OfflineDataInfo> getUndowloadInfo() {
        return this.mUnDownloadList;
    }

    public OfflineDataInfo getDowloadedInfo(int provinceId) {
        int index = 0;
        while (this.mDownloadedList != null && index < this.mDownloadedList.size()) {
            OfflineDataInfo model = (OfflineDataInfo) this.mDownloadedList.get(index);
            if (model != null && model.mProvinceId == provinceId) {
                return model;
            }
            index++;
        }
        return null;
    }

    public OfflineDataInfo getUndowloadInfo(int provinceId) {
        int index = 0;
        while (this.mUnDownloadList != null && index < this.mUnDownloadList.size()) {
            try {
                OfflineDataInfo model = (OfflineDataInfo) this.mUnDownloadList.get(index);
                if (model != null && model.mProvinceId == provinceId) {
                    return model;
                }
                index++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return null;
    }

    public ArrayList<OfflineDataInfo> getDowloadedInfo() {
        return this.mDownloadedList;
    }

    public synchronized void addDataInUnDownload(OfflineDataInfo data) {
        this.mUnDownloadList.add(data);
    }

    public synchronized void removeDataInUndownload(int provinceId) {
        int index = 0;
        while (this.mUnDownloadList != null && index < this.mUnDownloadList.size()) {
            if (((OfflineDataInfo) this.mUnDownloadList.get(index)).mProvinceId == provinceId) {
                this.mUnDownloadList.remove(index);
            }
            index++;
        }
    }

    public synchronized void addDataInDownloaded(OfflineDataInfo data) {
        this.mDownloadedList.add(data);
    }

    public synchronized void removeDataInDownloaded(int provinceId) {
        int index = 0;
        while (this.mDownloadedList != null && index < this.mDownloadedList.size()) {
            if (((OfflineDataInfo) this.mDownloadedList.get(index)).mProvinceId == provinceId) {
                this.mDownloadedList.remove(index);
            }
            index++;
        }
    }

    public int getMergeStartID() {
        int index = 0;
        while (this.mDownloadedList != null && index < this.mDownloadedList.size()) {
            if (((OfflineDataInfo) this.mDownloadedList.get(index)).mTaskStatus == 16) {
                return ((OfflineDataInfo) this.mDownloadedList.get(index)).mProvinceId;
            }
            index++;
        }
        return -1;
    }
}
