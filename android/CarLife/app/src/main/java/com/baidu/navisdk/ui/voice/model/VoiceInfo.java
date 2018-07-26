package com.baidu.navisdk.ui.voice.model;

import android.os.Bundle;

public class VoiceInfo {
    private static final String BUNDLE_VOICEINFO_DOWNLOAD_CNT = "DOWNLOAD_CNT";
    private static final String BUNDLE_VOICEINFO_IMAGE_URL = "IMAGE_URL";
    private static final String BUNDLE_VOICEINFO_NAME = "NAME";
    private static final String BUNDLE_VOICEINFO_SIZE = "SIZE";
    private static final String BUNDLE_VOICEINFO_STATUS = "STATUS";
    private static final String BUNDLE_VOICEINFO_TAG = "TAG";
    private static final String BUNDLE_VOICEINFO_TASKID = "TASKID";
    private static final String BUNDLE_VOICEINFO_VOICE_URL = "VOICE_URL";
    public static final int VOICE_INFO_STATUS_CLOUD_CONFIG = 4;
    public static final int VOICE_INFO_STATUS_DOWNLOAD = 2;
    public static final int VOICE_INFO_STATUS_INVALID = -1;
    public static final int VOICE_INFO_STATUS_LOCAL = 0;
    public static final int VOICE_INFO_STATUS_SYNC = 1;
    public static final int VOICE_INFO_STATUS_UNDOWNLOAD = 3;
    public int downloadCnt = 0;
    public String imageUrl = null;
    public String name = null;
    public long size = 0;
    public int status = -1;
    public String tag = null;
    public String taskId = null;
    public String voiceUrl = null;

    public boolean equals(Object o) {
        if (o instanceof VoiceInfo) {
            VoiceInfo other = (VoiceInfo) o;
            if (!(this.taskId == null || other.taskId == null)) {
                return this.taskId.equals(other.taskId);
            }
        }
        return super.equals(o);
    }

    public boolean equals(String taskId) {
        if (taskId == null || this.taskId == null) {
            return false;
        }
        return this.taskId.equals(taskId);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_VOICEINFO_TASKID, this.taskId);
        bundle.putLong(BUNDLE_VOICEINFO_SIZE, this.size);
        bundle.putInt(BUNDLE_VOICEINFO_DOWNLOAD_CNT, this.downloadCnt);
        bundle.putInt(BUNDLE_VOICEINFO_STATUS, this.status);
        bundle.putString(BUNDLE_VOICEINFO_NAME, this.name);
        bundle.putString(BUNDLE_VOICEINFO_TAG, this.tag);
        bundle.putString(BUNDLE_VOICEINFO_VOICE_URL, this.voiceUrl);
        bundle.putString(BUNDLE_VOICEINFO_IMAGE_URL, this.imageUrl);
        return bundle;
    }

    public static VoiceInfo getVoiceInfo(Bundle bundle) {
        VoiceInfo voiceInfo = new VoiceInfo();
        voiceInfo.taskId = bundle.getString(BUNDLE_VOICEINFO_TASKID);
        voiceInfo.size = bundle.getLong(BUNDLE_VOICEINFO_SIZE);
        voiceInfo.downloadCnt = bundle.getInt(BUNDLE_VOICEINFO_DOWNLOAD_CNT);
        voiceInfo.status = bundle.getInt(BUNDLE_VOICEINFO_STATUS);
        voiceInfo.name = bundle.getString(BUNDLE_VOICEINFO_NAME);
        voiceInfo.tag = bundle.getString(BUNDLE_VOICEINFO_TAG);
        voiceInfo.voiceUrl = bundle.getString(BUNDLE_VOICEINFO_VOICE_URL);
        voiceInfo.imageUrl = bundle.getString(BUNDLE_VOICEINFO_IMAGE_URL);
        return voiceInfo;
    }

    public String toString() {
        return "[voiceInfo] taskId : " + this.taskId + " size : " + this.size + " downCnt : " + this.downloadCnt + " status : " + this.status + " name : " + this.name + " tag : " + this.tag + " voiceUrl : " + this.voiceUrl + " imageUrl : " + this.imageUrl;
    }
}
