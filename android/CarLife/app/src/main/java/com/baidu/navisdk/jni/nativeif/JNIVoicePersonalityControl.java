package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.ui.voice.model.OrgVoiceItem;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class JNIVoicePersonalityControl {
    public static JNIVoicePersonalityControl sInstance = new JNIVoicePersonalityControl();

    public native boolean CopyMaiDouPath(String str);

    public native boolean appendTaskToTaskArray(String str, boolean z);

    public native boolean getDownloadVoiceTask(ArrayList<Bundle> arrayList);

    public native boolean getRecommendVoiceTask(ArrayList<Bundle> arrayList);

    public native boolean getRecordVoiceItems(String str, ArrayList<Bundle> arrayList);

    public native String getTaskFilePath(String str, boolean z);

    public native String getTaskFilePathWithWord(String str, String str2);

    public native boolean getVoiceInfo(String str, Bundle bundle);

    public native boolean isTaskDowned(String str, VoiceDataStatus voiceDataStatus);

    public native boolean pauseTask(String str);

    public native boolean recordVoiceData(ArrayList<OrgVoiceItem> arrayList, int i, String str);

    public native boolean removeTask(String str, int i);

    public native boolean resumeTask(String str);

    public native boolean saveRecordVoiceData(boolean z, Bundle bundle);

    public native boolean updateTaskToServer(String str, String str2);

    private JNIVoicePersonalityControl() {
    }

    public boolean removeTask(String taskId) {
        return removeTask(taskId, 0);
    }

    public boolean removeUpdateTask(String taskId) {
        return removeTask(taskId, 1);
    }

    public ArrayList<VoiceInfo> parseVoiceInfoListBundle(ArrayList<Bundle> bundleList) {
        LogUtil.m15791e("JNIVoicePersonalityControl", "parseVoiceInfoListBundle size = " + bundleList.size());
        ArrayList<VoiceInfo> voiceInfoList = new ArrayList();
        if (!(bundleList == null || bundleList.isEmpty())) {
            Iterator it = bundleList.iterator();
            while (it.hasNext()) {
                VoiceInfo voiceInfo = VoiceInfo.getVoiceInfo((Bundle) it.next());
                LogUtil.m15791e("JNIVoicePersonalityControl", "parse info:" + voiceInfo.toString());
                voiceInfoList.add(voiceInfo);
            }
        }
        return voiceInfoList;
    }
}
