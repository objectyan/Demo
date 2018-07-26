package com.baidu.navisdk.ui.voice.controller;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.SDCardListener;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.util.ArrayList;
import java.util.Iterator;

public class VoiceDownloadController {
    private static Object mCallbackListLock = new Object();
    private ArrayList<Handler> mCallbackHandlerList;
    private MsgHandler mHandler;
    private ArrayList<VoiceInfo> mSharedVoiceInfo;

    private static class LazyHolder {
        private static final VoiceDownloadController INSTANCE = new VoiceDownloadController();

        private LazyHolder() {
        }
    }

    public void addSharedVoiceInfo(VoiceInfo info) {
        if (!this.mSharedVoiceInfo.contains(info)) {
            this.mSharedVoiceInfo.add(info);
        }
    }

    public void removeSharedVoieInfo(String taskId) {
        for (int id = 0; id < this.mSharedVoiceInfo.size(); id++) {
            if (((VoiceInfo) this.mSharedVoiceInfo.get(id)).equals(taskId)) {
                this.mSharedVoiceInfo.remove(id);
                return;
            }
        }
    }

    public boolean hasInSharedVoice(String taskId) {
        Iterator it = this.mSharedVoiceInfo.iterator();
        while (it.hasNext()) {
            if (((VoiceInfo) it.next()).equals(taskId)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<VoiceInfo> getSharedVoiceInfos() {
        return this.mSharedVoiceInfo;
    }

    public static VoiceDownloadController getInstance() {
        return LazyHolder.INSTANCE;
    }

    private VoiceDownloadController() {
        this.mSharedVoiceInfo = new ArrayList();
        this.mHandler = new MsgHandler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                String curId = VoiceDownloadStatus.getInstance().getCurrentDownTaskId();
                switch (msg.what) {
                    case 4163:
                        int downloadSize = msg.arg2;
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "down handleMessage update downloadsize = " + downloadSize);
                        VoiceDownloadStatus.getInstance().updateDownload(downloadSize);
                        return;
                    case 4164:
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "down handleMessage failed ");
                        VoiceDownloadStatus.getInstance().pauseDownload();
                        VoiceDownloadController.this.sendDownloadStatusChange(3, -1, -1, curId);
                        return;
                    case 4165:
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "down handleMessage finish ");
                        VoiceDownloadStatus.getInstance().finishDownload();
                        VoiceDownloadController.this.sendDownloadStatusChange(4, -1, -1, curId);
                        return;
                    case MsgDefine.MSG_NAVI_VoiceDataDownloadStart /*4166*/:
                        int totalSize = msg.arg2;
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "down handleMessage start totalSize = " + totalSize);
                        if (VoiceDownloadController.this.checkSDCardStatus(totalSize)) {
                            VoiceDownloadStatus.getInstance().setSizeinfo(totalSize);
                            return;
                        } else {
                            VoiceDownloadStatus.getInstance().pauseDownload();
                            return;
                        }
                    case MsgDefine.MSG_NAVI_VoiceDataDownloadMD5Error /*4167*/:
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "down handleMessage md5error ");
                        VoiceDownloadStatus.getInstance().failDownload(18);
                        VoiceDownloadController.this.sendDownloadStatusChange(3, -1, -1, curId);
                        return;
                    case MsgDefine.MSG_NAVI_VoiceData_UploadMsg /*4176*/:
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "Voice MSG_NAVI_VoiceData_UploadMsg arg1 = " + msg.arg1);
                        BNVoice.getInstance().notifyObservers(4, msg.arg1, null);
                        return;
                    case MsgDefine.MSG_NAVI_VoiceData_BuildTTS /*4177*/:
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "Voice BuildTTS arg1 = " + msg.arg1);
                        BNVoice.getInstance().notifyObservers(5, msg.arg1, null);
                        return;
                    case MsgDefine.MSG_NAVI_VoiceData_NewRecommend /*4178*/:
                        BNVoice.getInstance().notifyObservers(3, 0, null);
                        return;
                    case MsgDefine.MSG_NAVI_VoiceData_NewTaskInfo /*4183*/:
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "Voice NewTaskInfo arg1 = " + msg.arg1);
                        BNVoice.getInstance().notifyObservers(6, msg.arg1, null);
                        VoiceDownloadStatus.getInstance().addJinShaToSharedVoiceInfo();
                        return;
                    case NetworkListener.MSG_TYPE_NET_WORK_CHANGE /*5555*/:
                        int wifiStatus = msg.arg1;
                        int connectStatus = msg.arg2;
                        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, " voice download in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE wifiStatus " + wifiStatus + " connectStatus = " + connectStatus);
                        if (connectStatus != 1) {
                            VoiceDownloadStatus.getInstance().pauseAllDownload(261);
                        } else if (wifiStatus != 1) {
                            VoiceDownloadStatus.getInstance().pauseFullDoseDownload(262);
                        }
                        BNVoice.getInstance().notifyObservers(7, msg.arg2, null);
                        return;
                    case SDCardListener.MSG_TYPE_SDCARD_CHANGE /*5565*/:
                        LogUtil.m15791e("Handler", " in case SDCardListener.MSG_TYPE_SDCARD_CHANGE");
                        return;
                    default:
                        return;
                }
            }

            public void careAbout() {
                observe(4164);
                observe(4165);
                observe((int) MsgDefine.MSG_NAVI_VoiceDataDownloadMD5Error);
                observe((int) MsgDefine.MSG_NAVI_VoiceDataDownloadStart);
                observe(4163);
                observe((int) MsgDefine.MSG_NAVI_VoiceData_UploadMsg);
                observe((int) MsgDefine.MSG_NAVI_VoiceData_BuildTTS);
                observe((int) MsgDefine.MSG_NAVI_VoiceData_NewRecommend);
                observe((int) MsgDefine.MSG_NAVI_VoiceData_NewTaskInfo);
            }
        };
        this.mCallbackHandlerList = new ArrayList();
        VMsgDispatcher.registerMsgHandler(this.mHandler);
        NetworkListener.registerMessageHandler(this.mHandler);
        SDCardListener.registerMessageHandler(this.mHandler);
    }

    public void dipose() {
        VMsgDispatcher.unregisterMsgHandler(this.mHandler);
        NetworkListener.unRegisterMessageHandler(this.mHandler);
        SDCardListener.unRegisterMessageHandler(this.mHandler);
    }

    public void registCallbackHandler(Handler handler) {
        synchronized (mCallbackListLock) {
            if (!this.mCallbackHandlerList.contains(handler)) {
                this.mCallbackHandlerList.add(handler);
            }
        }
    }

    public void unregistCallbackHandler(Handler handler) {
        synchronized (mCallbackListLock) {
            if (this.mCallbackHandlerList.contains(handler)) {
                this.mCallbackHandlerList.remove(handler);
            }
        }
    }

    private void sendDownloadStatusChange(int what, int arg1, int arg2, String id) {
        synchronized (mCallbackListLock) {
            ArrayList<Handler> callbackList = new ArrayList(this.mCallbackHandlerList);
        }
        try {
            Iterator it = callbackList.iterator();
            while (it.hasNext()) {
                ((Handler) it.next()).obtainMessage(what, arg1, arg2, id).sendToTarget();
            }
        } catch (Exception e) {
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "sendMsgChange:" + e.getMessage());
        }
    }

    public boolean startDownload(String taskId) {
        return VoiceDownloadStatus.getInstance().startDownload(taskId);
    }

    public void removeDownload(String taskId) {
        VoiceDownloadStatus.getInstance().removeDownload(taskId);
    }

    public void pauseDownload(String taskId) {
        VoiceDownloadStatus.getInstance().pauseDownload(taskId);
    }

    public void pauseAllDownload() {
        VoiceDownloadStatus.getInstance().pauseAllDownload(0);
    }

    public VoiceDataStatus getTaskDownStausFromEngine(String taskId) {
        VoiceDataStatus status = new VoiceDataStatus();
        JNIVoicePersonalityControl.sInstance.isTaskDowned(taskId, status);
        return status;
    }

    public ArrayList<VoiceInfo> getDownloadVoiceTask() {
        ArrayList<Bundle> voiceInfoBundleList = new ArrayList();
        try {
            JNIVoicePersonalityControl.sInstance.getDownloadVoiceTask(voiceInfoBundleList);
            return JNIVoicePersonalityControl.sInstance.parseVoiceInfoListBundle(voiceInfoBundleList);
        } catch (Throwable th) {
            return new ArrayList();
        }
    }

    public ArrayList<VoiceInfo> getRecommendVoiceTask() {
        ArrayList<Bundle> voiceInfoBundleList = new ArrayList();
        JNIVoicePersonalityControl.sInstance.getRecommendVoiceTask(voiceInfoBundleList);
        return JNIVoicePersonalityControl.sInstance.parseVoiceInfoListBundle(voiceInfoBundleList);
    }

    private boolean checkSDCardStatus(int size) {
        boolean z = true;
        if (size < 0) {
            return false;
        }
        if (SDCardUtils.handleSdcardError((long) size, true) != 0) {
            z = false;
        }
        return z;
    }
}
