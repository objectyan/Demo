package com.baidu.navisdk.ui.voice.controller;

import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.UserTask;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceDownloadStatus {
    private boolean mAutoDownload;
    private int mCurrentDownloadSize;
    private String mCurrentTaskId;
    private int mCurrentTaskStatus;
    private int mCurrentTotalSize;
    private NaviTaskListener mNaviTaskListener;
    private String mSlienceDownloadTaskId;
    private String mSlienceJson;
    private LinkedList<String> mTaskQueue;
    private HashMap<String, Integer> mTaskStatus;

    private class HTTPGetTask extends UserTask<Integer, Integer, Integer> {

        /* renamed from: com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus$HTTPGetTask$1 */
        class C45271 extends BNHttpTextResponseHandler {
            C45271() {
            }

            public void onSuccess(int statusCode, String responseString) {
                VoiceDownloadStatus.this.mSlienceJson = responseString;
            }

            public void onFailure(int statusCode, String responseString, Throwable throwable) {
            }
        }

        private HTTPGetTask() {
        }

        public void onPostExecute(Integer result) {
            if (VoiceDownloadStatus.this.mSlienceJson != null) {
                try {
                    JSONObject obj = new JSONObject(VoiceDownloadStatus.this.mSlienceJson);
                    if (!(obj == null || obj.getInt(C2125n.f6745M) != 0 || obj.getString(C2125n.f6746N) == null || !obj.getString(C2125n.f6746N).equals("success") || obj.getString("data") == null)) {
                        JSONObject dataObj = new JSONObject(obj.getString("data"));
                        if (!(dataObj == null || dataObj.getString("items") == null)) {
                            JSONObject itemsObj = new JSONObject(dataObj.getString("items"));
                            if (!(itemsObj == null || itemsObj.getString("tts_default") == null)) {
                                VoiceDownloadStatus.this.mSlienceDownloadTaskId = itemsObj.getString("tts_default");
                            }
                        }
                    }
                    if (NetworkUtils.isWifiConnected() && VoiceDownloadStatus.this.mSlienceDownloadTaskId != null && VoiceDownloadStatus.this.mSlienceDownloadTaskId.length() > 0) {
                        VoiceInfo realData = VoiceHelper.getInstance().getVoiceInfo(VoiceDownloadStatus.this.mSlienceDownloadTaskId);
                        if (realData != null) {
                            ArrayList<VoiceInfo> sharedVoiceInfos = VoiceDownloadController.getInstance().getSharedVoiceInfos();
                            if (BNSettingManager.getAutoDownloadJinShaTTS() && sharedVoiceInfos != null && !sharedVoiceInfos.contains(realData)) {
                                VoiceDownloadController.getInstance().addSharedVoiceInfo(realData);
                                VoiceDownloadController.getInstance().startDownload(VoiceDownloadStatus.this.mSlienceDownloadTaskId);
                            }
                        }
                    }
                } catch (JSONException e) {
                }
            }
        }

        public Integer doInBackground(Integer... params) {
            String appVersionStr = PackageUtil.getVersionName();
            String cuid = PackageUtil.getCuid();
            String cityCode = Integer.toString(VoiceDownloadStatus.this.getCurrentCityId());
            HashMap<String, String> getParams = new HashMap();
            if ("1" != null) {
                getParams.put("sid", "1");
            }
            if (appVersionStr != null) {
                getParams.put("app_version", appVersionStr);
            }
            if ("0" != null) {
                getParams.put("os", "0");
            }
            if (cuid != null) {
                try {
                    getParams.put("cuid", URLEncoder.encode(cuid, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
            }
            if (cityCode != null) {
                getParams.put(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYCODE, "" + cityCode);
            }
            BNHttpCenter.getInstance().get(BNVoiceParams.VOICE_SILENCE_DOWNLOAD_URL, getParams, new C45271(), null);
            return null;
        }
    }

    private static class LazyHolder {
        public static final VoiceDownloadStatus sStatus = new VoiceDownloadStatus();

        private LazyHolder() {
        }
    }

    public interface NaviTaskListener {
        boolean onCheckNaviTask();
    }

    public static class VoiceDownObj {
        public int arg1;
        public String taskId;

        public VoiceDownObj(String id, int arg) {
            this.taskId = id;
            this.arg1 = arg;
        }
    }

    public void setAutoDownload(boolean auto) {
        this.mAutoDownload = auto;
    }

    public String getCurrentDownTaskId() {
        return this.mCurrentTaskId;
    }

    public int getDownTaskStatus(String taskId) {
        if (this.mTaskStatus.containsKey(taskId)) {
            return ((Integer) this.mTaskStatus.get(taskId)).intValue();
        }
        return 0;
    }

    private VoiceDownloadStatus() {
        this.mCurrentTaskStatus = 0;
        this.mCurrentTotalSize = 0;
        this.mCurrentDownloadSize = 0;
        this.mCurrentTaskId = null;
        this.mTaskQueue = new LinkedList();
        this.mTaskStatus = new HashMap();
        this.mAutoDownload = true;
        this.mSlienceJson = null;
        this.mSlienceDownloadTaskId = null;
        this.mNaviTaskListener = null;
    }

    public static VoiceDownloadStatus getInstance() {
        return LazyHolder.sStatus;
    }

    public int getTaskDownloadStatus(String taskId) {
        return this.mCurrentTaskStatus;
    }

    private void setCurrentDownloadState(String taskId, int status, int progressOrPauseCauseOrErrorType) {
        if (taskId != null) {
            this.mTaskStatus.put(taskId, Integer.valueOf(status));
            BNVoice.getInstance().notifyObservers(1, status, new VoiceDownObj(taskId, progressOrPauseCauseOrErrorType));
        }
    }

    private boolean addToTaskQueue(String taskId) {
        if (this.mTaskQueue.isEmpty() || !(this.mTaskQueue.contains(taskId) || taskId.equals(this.mCurrentTaskId))) {
            this.mTaskQueue.add(taskId);
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "addToTaskQueue taskId :" + taskId);
            int progress = VoiceHelper.getInstance().getDownloadProgress(taskId);
            setCurrentDownloadState(taskId, 8, progress);
            setCurrentDownloadState(taskId, 1, progress);
            return true;
        }
        setCurrentDownloadState(taskId, 8, VoiceHelper.getInstance().getDownloadProgress(taskId));
        return false;
    }

    public LinkedList<String> getTaskQueue() {
        return this.mTaskQueue;
    }

    public boolean hasInTaskQueue(String taskId) {
        if (taskId == null) {
            return false;
        }
        if (this.mTaskQueue.contains(taskId) || taskId.equals(this.mCurrentTaskId)) {
            return true;
        }
        return false;
    }

    private void autoDownloadTask() {
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "autoDownloadTask mCurrentTaskId " + this.mCurrentTaskId + " mCurrentTaskStatus = " + this.mCurrentTaskStatus);
        if (this.mCurrentTaskId != null || !this.mAutoDownload) {
            return;
        }
        if (this.mTaskQueue.isEmpty()) {
            this.mCurrentTaskId = null;
            return;
        }
        this.mCurrentTaskId = (String) this.mTaskQueue.remove();
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "autoDownloadTask taskId =  " + this.mCurrentTaskId);
        if (this.mCurrentTaskId != null) {
            this.mCurrentTotalSize = 0;
            this.mCurrentDownloadSize = 0;
            this.mCurrentTaskStatus = 0;
            startDownloadImpl();
        }
    }

    public boolean startDownload(String taskId) {
        UserOPController.getInstance().add(UserOPParams.VOICE_5_1, taskId, null, null);
        boolean ret = false;
        if (VoiceDownloadController.getInstance().getTaskDownStausFromEngine(taskId).status != VoiceDataStatus.VOICE_DATA_DOWN_END) {
            ret = addToTaskQueue(taskId);
        }
        if (!ret) {
            return ret;
        }
        autoDownloadTask();
        return true;
    }

    private void startDownloadImpl() {
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "startDownloadImpl taskId =  " + this.mCurrentTaskId);
        switch (this.mCurrentTaskStatus) {
            case 0:
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "appendTaskToTaskArray taskId =  " + this.mCurrentTaskId);
                JNIVoicePersonalityControl.sInstance.appendTaskToTaskArray(this.mCurrentTaskId, "9999".equals(this.mCurrentTaskId));
                this.mCurrentTaskStatus = 5;
                setCurrentDownloadState(this.mCurrentTaskId, 5, VoiceHelper.getInstance().getDownloadProgress(this.mCurrentTaskId));
                return;
            case 1:
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "appendTaskToTaskArray taskId =  " + this.mCurrentTaskId);
                JNIVoicePersonalityControl.sInstance.appendTaskToTaskArray(this.mCurrentTaskId, "9999".equals(this.mCurrentTaskId));
                this.mCurrentTaskStatus = 1;
                setCurrentDownloadState(this.mCurrentTaskId, 1, VoiceHelper.getInstance().getDownloadProgress(this.mCurrentTaskId));
                return;
            case 2:
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "resumeTask taskId =  " + this.mCurrentTaskId);
                JNIVoicePersonalityControl.sInstance.resumeTask(this.mCurrentTaskId);
                int progress = VoiceHelper.getInstance().getDownloadProgress(this.mCurrentTaskId);
                this.mCurrentTaskStatus = 1;
                setCurrentDownloadState(this.mCurrentTaskId, 1, progress);
                return;
            default:
                return;
        }
    }

    public void updateDownload(int downSize) {
        this.mCurrentTaskStatus = 1;
        this.mCurrentDownloadSize = downSize;
        setCurrentDownloadState(this.mCurrentTaskId, 1, getInstance().getDownloadProgress(downSize));
    }

    public void removeDownload(String taskId) {
        if (taskId != null) {
            if (taskId.equals(this.mCurrentTaskId)) {
                JNIVoicePersonalityControl.sInstance.removeTask(taskId);
                this.mCurrentTaskStatus = 0;
                setCurrentDownloadState(this.mCurrentTaskId, 0, 0);
                this.mTaskStatus.remove(this.mCurrentTaskId);
                this.mCurrentTaskId = null;
                autoDownloadTask();
            } else if (this.mTaskQueue.contains(taskId)) {
                this.mTaskQueue.remove(taskId);
                setCurrentDownloadState(taskId, 0, 0);
                this.mTaskStatus.remove(taskId);
                JNIVoicePersonalityControl.sInstance.removeTask(taskId);
            } else {
                JNIVoicePersonalityControl.sInstance.removeTask(taskId);
                this.mTaskStatus.remove(taskId);
            }
        }
    }

    public void pauseDownload(String taskId) {
        if (taskId.equals(this.mCurrentTaskId)) {
            if (this.mCurrentTaskStatus != 1) {
                return;
            }
            if (this.mCurrentTotalSize - this.mCurrentDownloadSize < 30000) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "voice pause download fail progress < 30k");
                return;
            }
            JNIVoicePersonalityControl.sInstance.pauseTask(this.mCurrentTaskId);
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "voice pause download taskId :" + this.mCurrentTaskId + " cause :" + 260);
            this.mCurrentTaskStatus = 2;
            setCurrentDownloadState(this.mCurrentTaskId, 2, 260);
            this.mCurrentTaskId = null;
            autoDownloadTask();
        } else if (this.mTaskQueue.contains(taskId)) {
            this.mTaskQueue.remove(taskId);
            setCurrentDownloadState(taskId, 2, 260);
        }
    }

    public void pauseDownload() {
        if (this.mCurrentTaskId != null) {
            JNIVoicePersonalityControl.sInstance.pauseTask(this.mCurrentTaskId);
            this.mCurrentTaskStatus = 2;
            setCurrentDownloadState(this.mCurrentTaskId, 2, 260);
            this.mCurrentTaskId = null;
        }
    }

    public void pauseAllDownload(int cause) {
        if (this.mCurrentTaskId != null && this.mCurrentTaskStatus == 1) {
            JNIVoicePersonalityControl.sInstance.pauseTask(this.mCurrentTaskId);
            if (this.mCurrentTaskId.equals(BNVoiceParams.JIN_SHA) && VoiceHelper.getInstance().getVoiceInfo(this.mCurrentTaskId) == null) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "voice pause download taskId :" + this.mCurrentTaskId + " cause :" + cause);
                this.mCurrentTaskStatus = 2;
                setCurrentDownloadState(this.mCurrentTaskId, 2, cause);
            } else {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "voice pause download taskId :" + this.mCurrentTaskId + " cause :" + cause);
                this.mCurrentTaskStatus = 2;
                setCurrentDownloadState(this.mCurrentTaskId, 2, cause);
            }
        }
        if (!this.mTaskQueue.isEmpty()) {
            Iterator<String> iterator = this.mTaskQueue.iterator();
            while (iterator.hasNext()) {
                setCurrentDownloadState((String) iterator.next(), 2, cause);
            }
            this.mTaskQueue.clear();
        }
        this.mCurrentTaskId = null;
    }

    public void pauseFullDoseDownload(int cause) {
        if (("9999".equals(this.mCurrentTaskId) || BNVoiceParams.JIN_SHA.equals(this.mCurrentTaskId)) && this.mCurrentTaskStatus == 1) {
            JNIVoicePersonalityControl.sInstance.pauseTask(this.mCurrentTaskId);
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "voice pause download taskId :" + this.mCurrentTaskId + " cause :" + cause);
            this.mCurrentTaskStatus = 2;
            setCurrentDownloadState(this.mCurrentTaskId, 2, cause);
            this.mCurrentTaskId = null;
            autoDownloadTask();
        }
        if (this.mTaskQueue.contains("9999")) {
            this.mTaskQueue.remove("9999");
            setCurrentDownloadState("9999", 2, cause);
        }
        if (this.mTaskQueue.contains(BNVoiceParams.JIN_SHA)) {
            if (this.mCurrentTaskId != null && this.mCurrentTaskId.equals(BNVoiceParams.JIN_SHA) && VoiceHelper.getInstance().getVoiceInfo(this.mCurrentTaskId) == null) {
                this.mTaskQueue.remove(BNVoiceParams.JIN_SHA);
                setCurrentDownloadState(BNVoiceParams.JIN_SHA, 2, cause);
            } else {
                this.mTaskQueue.remove(BNVoiceParams.JIN_SHA);
                setCurrentDownloadState(BNVoiceParams.JIN_SHA, 2, cause);
            }
        }
    }

    public void finishDownload() {
        UserOPController.getInstance().add(UserOPParams.VOICE_5_1, this.mCurrentTaskId, "1", null);
        this.mCurrentTaskStatus = 0;
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "mCurrentTaskId: " + this.mCurrentTaskId);
        if (this.mCurrentTaskId != null && this.mCurrentTaskId.equals(BNVoiceParams.JIN_SHA)) {
            BNSettingManager.setHasDownloadJinShaTTS(true);
        }
        setCurrentDownloadState(this.mCurrentTaskId, 4, 100);
        this.mTaskStatus.remove(this.mCurrentTaskId);
        this.mCurrentTaskId = null;
        autoDownloadTask();
    }

    public void failDownload(int errorType) {
        UserOPController.getInstance().add(UserOPParams.VOICE_5_1, this.mCurrentTaskId, "0", null);
        setCurrentDownloadState(this.mCurrentTaskId, 3, errorType);
        removeDownload(this.mCurrentTaskId);
    }

    public void setSizeinfo(int totalSize) {
        this.mCurrentTotalSize = totalSize;
    }

    public void createToast(int state, VoiceInfo info) {
        if (info == null) {
            return;
        }
        if (state == 5) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "检测到Wi-Fi网络，为您自动下载\"" + info.name + '\"' + "导航语音");
        } else if (state == 262) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "未检测到Wi-Fi网络，暂停下载\"" + info.name + '\"' + "导航语音");
        } else if (state == 261) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "网络连接中断，暂停下载\"" + info.name + '\"' + "导航语音");
        } else if (state == 6) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "切换为\"" + info.name + '\"' + "导航语音");
        } else if (state == 7) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "切换\"" + info.name + '\"' + "导航语音失败");
        }
    }

    public int getDownloadProgress(int downloadSize) {
        if (this.mCurrentTotalSize != 0) {
            return (int) ((((double) downloadSize) / ((double) this.mCurrentTotalSize)) * 100.0d);
        }
        return 0;
    }

    public void silenceDownloadVoice() {
        ArrayList<VoiceInfo> downsInfos = VoiceDownloadController.getInstance().getDownloadVoiceTask();
        VoiceInfo voiceInfo = new VoiceInfo();
        voiceInfo.taskId = BNVoiceParams.JIN_SHA;
        if (!downsInfos.contains(voiceInfo)) {
            new HTTPGetTask().execute(new Integer[0]);
        }
    }

    private int getCurrentCityId() {
        DistrictInfo district = GeoLocateModel.getInstance().getCurrentDistrict();
        if (district != null) {
            return district.mId;
        }
        return -1;
    }

    public void addJinShaToSharedVoiceInfo() {
        if (this.mSlienceDownloadTaskId != null) {
            VoiceInfo realData = VoiceHelper.getInstance().getVoiceInfo(BNVoiceParams.JIN_SHA);
            if (realData != null) {
                ArrayList<VoiceInfo> sharedVoiceInfos = VoiceDownloadController.getInstance().getSharedVoiceInfos();
                ArrayList<VoiceInfo> downsInfos = VoiceDownloadController.getInstance().getDownloadVoiceTask();
                if (BNSettingManager.getAutoDownloadJinShaTTS() && sharedVoiceInfos != null && downsInfos != null && !sharedVoiceInfos.contains(realData) && !downsInfos.contains(realData)) {
                    VoiceDownloadController.getInstance().addSharedVoiceInfo(realData);
                    VoiceDownloadController.getInstance().startDownload(this.mSlienceDownloadTaskId);
                }
            }
        }
    }

    public void handleSwitchVoiceData(boolean success, String taskId) {
        VoiceInfo realData = VoiceHelper.getInstance().getVoiceInfo(taskId);
        if (realData != null && success) {
            BNSettingManager.setAutoSwitchJinShaTTS(false);
            createToast(6, realData);
        }
    }

    public void setNaviTaskListener(NaviTaskListener listener) {
        this.mNaviTaskListener = listener;
    }
}
