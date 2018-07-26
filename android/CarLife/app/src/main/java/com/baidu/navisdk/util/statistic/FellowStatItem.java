package com.baidu.navisdk.util.statistic;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FellowStatItem {
    private static final boolean FELLOW_DEBUG = BNSettingManager.isShowJavaLog();
    private static final String STAT_LOG_FILE = "fellowStatLog.txt";
    private static final String TAG = FellowStatItem.class.getSimpleName();
    private static FellowStatItem mInstance = null;
    private long mVoiceDataDownloadEndTime;
    private long mVoiceDataDownloadStartTime;
    private long mVoiceDataRecordId;
    private long mVoiceDataUploadEndTime;
    private long mVoiceDataUploadStartTime;
    private long mVoiceDescDownloadEndTime;
    private long mVoiceDescDownloadStartTime;
    private long mVoiceDescUploadEndTime;
    private long mVoiceDescUploadStartTime;
    private long mVoicePullEndTime;
    private long mVoicePullStartTime;

    public static synchronized FellowStatItem getInstance() {
        FellowStatItem fellowStatItem;
        synchronized (FellowStatItem.class) {
            if (mInstance == null) {
                mInstance = new FellowStatItem();
            }
            fellowStatItem = mInstance;
        }
        return fellowStatItem;
    }

    public long getmVoiceDataRecordId() {
        return this.mVoiceDataRecordId;
    }

    public void setmVoiceDataRecordId(long mVoiceDataRecordId) {
        this.mVoiceDataRecordId = mVoiceDataRecordId;
    }

    public long getmVoiceDataUploadStartTime() {
        return this.mVoiceDataUploadStartTime;
    }

    public void setmVoiceDataUploadStartTime(long mVoiceDataUploadStartTime) {
        this.mVoiceDataUploadStartTime = mVoiceDataUploadStartTime;
    }

    public long getmVoiceDataUploadEndTime() {
        return this.mVoiceDataUploadEndTime;
    }

    public void setmVoiceDataUploadEndTime(long mVoiceDataUploadEndTime) {
        this.mVoiceDataUploadEndTime = mVoiceDataUploadEndTime;
        writeStringToFile("语音id:" + String.valueOf(getmVoiceDataRecordId()) + ",数据上传时间：" + String.valueOf(this.mVoiceDataUploadEndTime - getmVoiceDataUploadStartTime()) + "ms");
    }

    public long getmVoiceDescUploadStartTime() {
        return this.mVoiceDescUploadStartTime;
    }

    public void setmVoiceDescUploadStartTime(long mVoiceDescUploadStartTime) {
        this.mVoiceDescUploadStartTime = mVoiceDescUploadStartTime;
    }

    public long getmVoiceDescUploadEndTime() {
        return this.mVoiceDescUploadEndTime;
    }

    public void setmVoiceDescUploadEndTime(long mVoiceDescUploadEndTime) {
        this.mVoiceDescUploadEndTime = mVoiceDescUploadEndTime;
        writeStringToFile("语音id:" + String.valueOf(getmVoiceDataRecordId()) + ",描述上传时间：" + String.valueOf(this.mVoiceDescUploadEndTime - getmVoiceDescUploadStartTime()) + "ms");
    }

    public long getmVoiceDataDownloadStartTime() {
        return this.mVoiceDataDownloadStartTime;
    }

    public void setmVoiceDataDownloadStartTime(long mVoiceDataDownloadStartTime) {
        this.mVoiceDataDownloadStartTime = mVoiceDataDownloadStartTime;
    }

    public long getmVoiceDataDownloadEndTime() {
        return this.mVoiceDataDownloadEndTime;
    }

    public void setmVoiceDataDownloadEndTime(long mVoiceDataDownloadEndTime) {
        this.mVoiceDataDownloadEndTime = mVoiceDataDownloadEndTime;
        writeStringToFile("语音id:" + String.valueOf(getmVoiceDataRecordId()) + ",数据下载时间：" + String.valueOf(this.mVoiceDataDownloadEndTime - getmVoiceDataDownloadStartTime()) + "ms");
    }

    public long getmVoiceDescDownloadStartTime() {
        return this.mVoiceDescDownloadStartTime;
    }

    public void setmVoiceDescDownloadStartTime(long mVoiceDescDownloadStartTime) {
        this.mVoiceDescDownloadStartTime = mVoiceDescDownloadStartTime;
    }

    public long getmVoiceDescDownloadEndTime() {
        return this.mVoiceDescDownloadEndTime;
    }

    public void setmVoiceDescDownloadEndTime(long mVoiceDescDownloadEndTime) {
        this.mVoiceDescDownloadEndTime = mVoiceDescDownloadEndTime;
    }

    public long getmVoicePullStartTime() {
        return this.mVoicePullStartTime;
    }

    public void setmVoicePullStartTime(long mVoicePullStartTime) {
        this.mVoicePullStartTime = mVoicePullStartTime;
    }

    public long getmVoicePullEndTime() {
        return this.mVoicePullEndTime;
    }

    public void setmVoicePullEndTime(long mVoicePullEndTime) {
        this.mVoicePullEndTime = mVoicePullEndTime;
        writeStringToFile("消息拉取时间：" + String.valueOf(this.mVoicePullEndTime - getmVoicePullStartTime()) + "ms");
    }

    public void writeStringToFile(String param) {
        Exception e;
        Throwable th;
        if (param != null && !"".equals(param) && FELLOW_DEBUG) {
            FileOutputStream fos = null;
            try {
                FileOutputStream fos2 = new FileOutputStream(getFellowStatLogFile(), true);
                try {
                    String newLine = System.getProperty("line.separator");
                    fos2.write(param.getBytes("utf-8"));
                    fos2.write(newLine.getBytes());
                    fos2.flush();
                    LogUtil.m15791e(TAG, "writeStringToFile");
                    if (fos2 != null) {
                        try {
                            fos2.close();
                        } catch (IOException e2) {
                            LogUtil.m15791e(TAG, e2.getMessage());
                        }
                        return;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fos = fos2;
                    try {
                        LogUtil.m15791e(TAG, e.getMessage());
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e22) {
                                LogUtil.m15791e(TAG, e22.getMessage());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e222) {
                                LogUtil.m15791e(TAG, e222.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fos = fos2;
                    if (fos != null) {
                        fos.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                LogUtil.m15791e(TAG, e.getMessage());
                if (fos != null) {
                    fos.close();
                }
            }
        }
    }

    private File getFellowStatLogFile() {
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + STAT_LOG_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
