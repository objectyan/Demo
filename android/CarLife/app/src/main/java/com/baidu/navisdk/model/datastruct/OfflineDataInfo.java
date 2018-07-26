package com.baidu.navisdk.model.datastruct;

import com.baidu.navisdk.comapi.offlinedata.OfflineDataParams.Const;
import com.baidu.navisdk.util.common.StringUtils;

public class OfflineDataInfo {
    public boolean isFakeUpdate = false;
    public String mDownloadRatio = "";
    public int mDownloadSize;
    public int mDownloadUpSize;
    public String mFistLetters;
    public boolean mIsChecked = false;
    public boolean mIsNewVer = false;
    public boolean mIsRequest = false;
    public boolean mIsSuspendByNetChange = false;
    public boolean mIsSuspendByPhoneChange = false;
    public String mName;
    public int mProgress;
    public int mProgressBy10;
    public int mProvinceId;
    public int mSize;
    public int mStatus;
    public int mStatusColor;
    public String mStatusTips;
    public String mStrSize;
    public int mTaskStatus;
    public int mUpProgress;
    public int mUpProgressBy10;
    public int mUpSize;
    public String mUpdateRatio = "";

    public OfflineDataInfo(OfflineDataInfo downloadinfo) {
        if (downloadinfo != null) {
            this.mName = downloadinfo.mName;
            this.mProvinceId = downloadinfo.mProvinceId;
            this.mStatus = downloadinfo.mStatus;
            this.mSize = downloadinfo.mSize;
            this.mProgress = downloadinfo.mProgress;
            this.mTaskStatus = downloadinfo.mTaskStatus;
            this.mStatusColor = downloadinfo.mStatusColor;
            this.mStatusTips = downloadinfo.mStatusTips;
            this.mStrSize = downloadinfo.mStrSize;
            this.mIsChecked = downloadinfo.mIsChecked;
            this.mIsNewVer = downloadinfo.mIsNewVer;
            this.mFistLetters = downloadinfo.mFistLetters;
            this.mUpSize = downloadinfo.mUpSize;
            this.mUpProgress = downloadinfo.mUpProgress;
            this.mIsRequest = downloadinfo.mIsRequest;
            this.mDownloadRatio = downloadinfo.mDownloadRatio;
            this.mUpdateRatio = downloadinfo.mUpdateRatio;
            this.mDownloadSize = downloadinfo.mDownloadSize;
            this.mDownloadUpSize = downloadinfo.mDownloadUpSize;
            this.mUpProgressBy10 = downloadinfo.mUpProgressBy10;
            this.mProgressBy10 = downloadinfo.mProgressBy10;
        }
    }

    public void copy(OfflineDataInfo model) {
        if (model != null) {
            this.mName = model.mName;
            this.mProvinceId = model.mProvinceId;
            this.mStatus = model.mStatus;
            this.mSize = model.mSize;
            this.mProgress = model.mProgress;
            this.mTaskStatus = model.mTaskStatus;
            this.mStatusColor = model.mStatusColor;
            this.mStatusTips = model.mStatusTips;
            this.mStrSize = model.mStrSize;
            this.mIsChecked = model.mIsChecked;
            this.mIsNewVer = model.mIsNewVer;
            this.mFistLetters = model.mFistLetters;
            this.mUpSize = model.mUpSize;
            this.mUpProgress = model.mUpProgress;
            this.mIsRequest = model.mIsRequest;
            this.mDownloadRatio = model.mDownloadRatio;
            this.mUpdateRatio = model.mUpdateRatio;
            this.mDownloadSize = model.mDownloadSize;
            this.mDownloadUpSize = model.mDownloadUpSize;
            this.mUpProgressBy10 = model.mUpProgressBy10;
            this.mProgressBy10 = model.mProgressBy10;
        }
    }

    public void formatStatusTips() {
        String tmp;
        this.mStatusColor = Const.COLOR_GREEN;
        this.mDownloadUpSize = (int) (((double) this.mUpSize) * (((double) this.mUpProgressBy10) / 1000.0d));
        String strUpDownloadSize = StringUtils.ByteSizeToString(this.mDownloadUpSize);
        String strUpSize = StringUtils.ByteSizeToString(this.mUpSize);
        this.mDownloadSize = (int) (((double) this.mSize) * (((double) this.mProgressBy10) / 1000.0d));
        String strDownloadSize = StringUtils.ByteSizeToString(this.mDownloadSize);
        String strSize = StringUtils.ByteSizeToString(this.mSize);
        this.mDownloadRatio = strDownloadSize + "/" + strSize;
        this.mUpdateRatio = strUpDownloadSize + "/" + strUpSize;
        if (this.mIsNewVer) {
            tmp = this.mUpdateRatio;
        } else {
            tmp = this.mDownloadRatio;
        }
        switch (this.mTaskStatus) {
            case 1:
                this.mStatusTips = strSize;
                this.mStatusColor = Const.COLOR_GRAY;
                break;
            case 2:
                this.mStatusTips = "下载中\r\n" + this.mDownloadRatio;
                this.mStatusColor = Const.COLOR_BLUE;
                break;
            case 3:
                this.mStatusTips = "等待下载\r\n" + this.mDownloadRatio;
                this.mStatusColor = Const.COLOR_BLUE;
                break;
            case 4:
                this.mStatusTips = "已暂停\r\n" + this.mDownloadRatio;
                this.mStatusColor = Const.COLOR_ORANGE;
                break;
            case 5:
                if (this.mUpProgress == 100) {
                    strSize = StringUtils.ByteSizeToString(this.mSize);
                }
                this.mStatusTips = strSize;
                this.mStatusColor = Const.COLOR_GRAY;
                this.mIsRequest = false;
                break;
            case 6:
                this.mStatusTips = "网络异常\r\n" + tmp;
                this.mStatusColor = Const.COLOR_ORANGE;
                break;
            case 8:
                this.mStatusTips = "WIFI断开\r\n" + tmp;
                this.mStatusColor = Const.COLOR_ORANGE;
                break;
            case 9:
                this.mStatusTips = "SD卡异常\r\n" + tmp;
                this.mStatusColor = Const.COLOR_ORANGE;
                break;
            case 10:
                String mStrSize = StringUtils.ByteSizeToString(this.mUpSize);
                if (this.isFakeUpdate) {
                    this.mStatusTips = "有更新\r\n";
                } else {
                    this.mStatusTips = "有更新\r\n" + mStrSize;
                }
                this.mStatusColor = Const.COLOR_GREEN;
                break;
            case 11:
                this.mStatusTips = "等待更新\r\n" + this.mUpdateRatio;
                this.mStatusColor = Const.COLOR_BLUE;
                break;
            case 12:
                this.mStatusTips = "更新中\r\n" + this.mUpdateRatio;
                this.mStatusColor = Const.COLOR_BLUE;
                break;
            case 13:
                this.mStatusTips = "暂停更新\r\n" + this.mUpdateRatio;
                this.mStatusColor = Const.COLOR_ORANGE;
                break;
            case 16:
                this.mStatusTips = "正在准备数据中";
                this.mStatusColor = Const.COLOR_BLUE;
                break;
            case 17:
                this.mStatusTips = "等待中";
                this.mStatusColor = Const.COLOR_BLUE;
                break;
            case 19:
                this.mStatusTips = "数据更新失败，请重启";
                this.mStatusColor = Const.COLOR_ORANGE;
                break;
            default:
                this.mStatusTips = "";
                break;
        }
        if (this.mIsRequest) {
            this.mStatusTips = "下载请求中...";
            this.mStatusColor = Const.COLOR_BLUE;
        }
    }
}
