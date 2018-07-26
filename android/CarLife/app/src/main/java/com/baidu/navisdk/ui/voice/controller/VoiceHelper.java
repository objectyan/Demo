package com.baidu.navisdk.ui.voice.controller;

import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.voice.model.VoiceShareData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceHelper {
    private VoiceInfo mShareVoiceInfo;

    private static class LazyHolder {
        public static final VoiceHelper sInstance = new VoiceHelper();

        private LazyHolder() {
        }
    }

    private VoiceHelper() {
        this.mShareVoiceInfo = null;
    }

    public static VoiceHelper getInstance() {
        return LazyHolder.sInstance;
    }

    public String generateRandTaskId() {
        return UUID.randomUUID().toString();
    }

    public boolean cancelUpdateToServer(String taskId) {
        return JNIVoicePersonalityControl.sInstance.removeUpdateTask(taskId);
    }

    public void shareTopic(String mTopicShareParam) throws JSONException {
        VoiceInfo shareInfo = new VoiceInfo();
        JSONObject obj = new JSONObject(mTopicShareParam);
        shareInfo.imageUrl = obj.optString("img");
        shareInfo.voiceUrl = obj.optString("url");
        shareInfo.name = obj.optString("title");
        shareInfo.status = 3;
        share(shareInfo);
    }

    public boolean share(VoiceInfo info) {
        if (info == null) {
            return false;
        }
        this.mShareVoiceInfo = info;
        if (info.status == 0) {
            return getInstance().updateTaskToServer(info.taskId, BNVoice.getInstance().getBduss());
        }
        shareWithoutUpload(info);
        return true;
    }

    public void shareWithoutUpload(VoiceInfo sharedInfo) {
        if (sharedInfo != null) {
            boolean isMyVoice;
            this.mShareVoiceInfo = sharedInfo;
            if (sharedInfo.status == 0 || sharedInfo.status == 1) {
                isMyVoice = true;
            } else {
                isMyVoice = false;
            }
            if (TextUtils.isEmpty(this.mShareVoiceInfo.imageUrl) || !this.mShareVoiceInfo.imageUrl.startsWith("http")) {
                this.mShareVoiceInfo.imageUrl = BNVoiceParams.VOICE_DEFUALT_IMAGE_URL;
            }
            String appname = BNStyleManager.getString(C4048R.string.nsdk_string_baidumap_name);
            String voiceName = this.mShareVoiceInfo.name;
            if (voiceName == null || voiceName.length() == 0) {
                voiceName = "";
            }
            String subject = String.format(BNStyleManager.getString(isMyVoice ? C4048R.string.nsdk_string_my_voice_share_subject : C4048R.string.nsdk_string_star_voice_share_subject), new Object[]{appname, voiceName});
            String content = String.format(BNStyleManager.getString(isMyVoice ? C4048R.string.nsdk_string_my_voice_share_weixin_content : C4048R.string.nsdk_string_star_voice_share_weixin_content), new Object[]{voiceName});
            ArrayList<VoiceShareData> list = new ArrayList();
            VoiceShareData shareData = new VoiceShareData();
            shareData.shareType = 0;
            shareData.subject = subject;
            shareData.content = content;
            shareData.shareUrl = this.mShareVoiceInfo.voiceUrl.replace("/voice_market_details/", "/voice_market_details_v2/");
            shareData.imageUrl = this.mShareVoiceInfo.imageUrl;
            list.add(shareData);
            shareData = new VoiceShareData();
            shareData.shareType = 1;
            shareData.subject = subject;
            shareData.content = content;
            shareData.shareUrl = this.mShareVoiceInfo.voiceUrl;
            shareData.imageUrl = this.mShareVoiceInfo.imageUrl;
            list.add(shareData);
            shareData = new VoiceShareData();
            shareData.shareType = 2;
            shareData.subject = content;
            shareData.content = content;
            shareData.shareUrl = this.mShareVoiceInfo.voiceUrl;
            shareData.imageUrl = this.mShareVoiceInfo.imageUrl;
            list.add(shareData);
            shareData = new VoiceShareData();
            shareData.shareType = 3;
            shareData.subject = subject;
            shareData.content = content + " " + this.mShareVoiceInfo.voiceUrl;
            shareData.shareUrl = this.mShareVoiceInfo.voiceUrl;
            shareData.imageUrl = null;
            list.add(shareData);
            if (BNVoice.getInstance().getVoiceShareListener() != null) {
                BNVoice.getInstance().getVoiceShareListener().share(list);
            }
        }
    }

    public void shareFromSquare() {
        String subject = BNStyleManager.getString(C4048R.string.nsdk_string_square_share_subject);
        String content = BNStyleManager.getString(C4048R.string.nsdk_string_square_share_content);
        ArrayList<VoiceShareData> list = new ArrayList();
        VoiceShareData shareData = new VoiceShareData();
        shareData.shareType = 0;
        shareData.subject = subject;
        shareData.content = content;
        shareData.shareUrl = HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_VOICE_SQUARE);
        shareData.imageUrl = BNVoiceParams.VOICE_SQUARE_DEFAULT_IMAGE_URL;
        list.add(shareData);
        shareData = new VoiceShareData();
        shareData.shareType = 1;
        shareData.subject = subject;
        shareData.content = content;
        shareData.shareUrl = HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_VOICE_SQUARE);
        shareData.imageUrl = BNVoiceParams.VOICE_SQUARE_DEFAULT_IMAGE_URL;
        list.add(shareData);
        shareData = new VoiceShareData();
        shareData.shareType = 2;
        shareData.subject = content;
        shareData.content = content;
        shareData.shareUrl = HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_VOICE_SQUARE);
        shareData.imageUrl = BNVoiceParams.VOICE_SQUARE_DEFAULT_IMAGE_URL;
        list.add(shareData);
        shareData = new VoiceShareData();
        shareData.shareType = 3;
        shareData.subject = subject;
        shareData.content = content + " " + HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_VOICE_SQUARE);
        shareData.shareUrl = HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_VOICE_SQUARE);
        shareData.imageUrl = null;
        list.add(shareData);
        if (BNVoice.getInstance().getVoiceShareListener() != null) {
            BNVoice.getInstance().getVoiceShareListener().share(list);
        }
    }

    public String getVoiceShowSize(long nSize) {
        DecimalFormat df = new DecimalFormat();
        String strSize = "未知大小";
        if (nSize < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return nSize + "B";
        }
        if (nSize < 1048576) {
            df.applyPattern("0");
            return df.format(((double) nSize) / 1024.0d) + "K";
        } else if (nSize < 1073741824) {
            df.applyPattern("0.0");
            return df.format(((double) nSize) / 1048576.0d) + "M";
        } else {
            df.applyPattern("0.0");
            return df.format(((double) nSize) / 1.073741824E9d) + "G";
        }
    }

    public String getVoiceShowDownCnt(int downloadCnt) {
        String strCnt = "";
        if (downloadCnt <= 10000) {
            return strCnt + downloadCnt + "次";
        }
        if (downloadCnt > 10000) {
            return strCnt + (downloadCnt / 10000) + "万次";
        }
        return strCnt + (downloadCnt / 100000000) + "亿次";
    }

    public int getDownloadProgress(String taskId) {
        VoiceDataStatus dataStatus = VoiceDownloadController.getInstance().getTaskDownStausFromEngine(taskId);
        if ("9999".equals(taskId)) {
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "getDownloadProgress status = " + dataStatus.status + " download = " + dataStatus.unDwonloadSize);
        }
        if (dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_DOWNING || dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_UNSTART) {
            int totalSize = (int) dataStatus.unTotalSize;
            int downSize = (int) dataStatus.unDwonloadSize;
            if (totalSize != 0) {
                return (int) ((((double) downSize) / ((double) totalSize)) * 100.0d);
            }
            return 0;
        } else if (dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_END) {
            return 100;
        } else {
            return 0;
        }
    }

    public String getCurrentUsedTTSId() {
        int mode = BNSettingManager.getVoicePersonality();
        if (mode == 0) {
            return null;
        }
        if (mode == 1) {
            return "9999";
        }
        return BNSettingManager.getVoiceTaskId();
    }

    public Map<String, String> getRecordVoiceDetailInfo(String taskId) {
        Map<String, String> voiceItem = new HashMap();
        ArrayList<Bundle> bundleList = new ArrayList();
        if (JNIVoicePersonalityControl.sInstance.getRecordVoiceItems(taskId, bundleList)) {
            Iterator it = bundleList.iterator();
            while (it.hasNext()) {
                Bundle bundle = (Bundle) it.next();
                if (bundle.containsKey("ORGWORD") && bundle.containsKey("VOICEPATH")) {
                    voiceItem.put(bundle.getString("ORGWORD"), bundle.getString("VOICEPATH"));
                }
            }
        }
        return voiceItem;
    }

    public String getVoiceSetPath(String taskId) {
        return JNIVoicePersonalityControl.sInstance.getTaskFilePath(taskId, true);
    }

    public String getVoiceSetPath(String taskId, boolean isMainPath) {
        return JNIVoicePersonalityControl.sInstance.getTaskFilePath(taskId, isMainPath);
    }

    public String getVoiceItemPath(String taskId, String orgWord) {
        return JNIVoicePersonalityControl.sInstance.getTaskFilePathWithWord(taskId, orgWord);
    }

    public boolean updateTaskToServer(String taskId, String bduss) {
        return JNIVoicePersonalityControl.sInstance.updateTaskToServer(taskId, bduss);
    }

    public boolean isTaskDownloadFinish(String taskId) {
        VoiceDataStatus status = new VoiceDataStatus();
        if (JNIVoicePersonalityControl.sInstance.isTaskDowned(taskId, status) && status.status == VoiceDataStatus.VOICE_DATA_DOWN_END) {
            return true;
        }
        return false;
    }

    public VoiceInfo getVoiceInfo(String taskId) {
        Bundle bundle = new Bundle();
        try {
            if (JNIVoicePersonalityControl.sInstance.getVoiceInfo(taskId, bundle)) {
                return VoiceInfo.getVoiceInfo(bundle);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public String getSuperStarById(String taskId) {
        String name = "未知";
        if ("9998".equals(taskId)) {
            return "鹿晗";
        }
        if (C2536a.f8300a.equals(taskId)) {
            return "陈楚生";
        }
        if (C2536a.f8304e.equals(taskId)) {
            return "何洁";
        }
        if ("10003".equals(taskId)) {
            return "吉克隽逸";
        }
        if ("10004".equals(taskId)) {
            return "金莎";
        }
        if ("10005".equals(taskId)) {
            return "谭维维";
        }
        if (C2536a.f8310k.equals(taskId)) {
            return "杨坤";
        }
        if (C2536a.f8311l.equals(taskId)) {
            return "牛奶咖啡";
        }
        return name;
    }
}
