package com.baidu.navisdk.ui.voice;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadController;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus.VoiceDownObj;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.voice.view.VoiceBaseView;
import com.baidu.navisdk.ui.voice.view.VoiceDetailView;
import com.baidu.navisdk.ui.voice.view.VoiceMainView;
import com.baidu.navisdk.ui.voice.view.VoiceSquareView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import java.util.ArrayList;
import java.util.HashMap;

public class BNVoice {
    private boolean isExternalCall;
    private String lastTaskId;
    private VoiceBaseView mCurrentView;
    private Bundle mExtra;
    private Handler mHandler;
    private String mHeadurl;
    private VoiceBaseView mLastView;
    private HashMap<Integer, VoiceBaseView> mViewMap;
    private BNVoice$VoiceAccountListener mVoiceAccountListener;
    private BNVoice$VoiceDataSwitchListener mVoiceDataSwitchListener;
    private BNVoice$OnVoiceEventListener mVoiceEventListener;
    private ArrayList<BNVoice$OnVoiceEventListener> mVoiceEventListenerList;
    private VoiceShareListener mVoiceShareListener;
    private ArrayList<VoiceShareListener> mVoiceShareListenerList;
    private BNVoice$VoiceSwitchData switchData;

    public void setExternalCall(boolean external, Bundle bundle) {
        this.isExternalCall = external;
        this.mExtra = bundle;
    }

    public void setInternalCall(Bundle bundle) {
        this.isExternalCall = false;
        this.mExtra = bundle;
    }

    public boolean isExternalCall() {
        return this.isExternalCall;
    }

    @Deprecated
    public Bundle getExternalCallBundle() {
        return this.mExtra;
    }

    public Bundle getCallBundle() {
        return this.mExtra;
    }

    private BNVoice() {
        this.mViewMap = new HashMap();
        this.mHandler = null;
        this.mVoiceShareListenerList = new ArrayList();
        this.mVoiceEventListenerList = new ArrayList();
        this.mVoiceShareListener = null;
        this.mVoiceDataSwitchListener = null;
        this.mVoiceAccountListener = null;
        this.isExternalCall = false;
        this.switchData = new BNVoice$VoiceSwitchData(this);
        this.mHeadurl = null;
        this.lastTaskId = null;
        this.mHandler = new BNVoice$1(this, Looper.getMainLooper());
    }

    public static BNVoice getInstance() {
        return BNVoice$LazyHodler.sInstance;
    }

    public void dispose() {
        this.mLastView = null;
        this.mCurrentView = null;
    }

    public View initView(Activity activity, BNVoice$OnVoicePageJumpListener listener, Bundle bundle, int page) {
        switch (page) {
            case 1:
                this.mViewMap.put(Integer.valueOf(page), new VoiceMainView());
                break;
            case 4:
                this.mViewMap.put(Integer.valueOf(page), new VoiceDetailView());
                break;
            case 5:
                this.mViewMap.put(Integer.valueOf(page), new VoiceSquareView());
                break;
        }
        VoiceBaseView baseView = (VoiceBaseView) this.mViewMap.get(Integer.valueOf(page));
        this.mCurrentView = baseView;
        if (baseView != null) {
            return baseView.initView(activity, listener, bundle);
        }
        return null;
    }

    public void onResume(int page) {
        LogUtil.e(BNVoiceParams.MODULE_TAG, "onResume:" + page);
        this.mLastView = this.mCurrentView;
        this.mCurrentView = (VoiceBaseView) this.mViewMap.get(Integer.valueOf(page));
        if (this.mCurrentView != null) {
            this.mCurrentView.hasPaused = false;
            this.mCurrentView.onResume();
        }
    }

    public void onPause(int page) {
        VoiceBaseView baseView = (VoiceBaseView) this.mViewMap.get(Integer.valueOf(page));
        if (baseView != null) {
            LogUtil.e(BNVoiceParams.MODULE_TAG, "onPause:" + page);
            baseView.hasPaused = true;
            baseView.onPause();
        }
    }

    public void updateValues(Bundle bundle, int page) {
        VoiceBaseView baseView = (VoiceBaseView) this.mViewMap.get(Integer.valueOf(page));
        if (baseView != null) {
            LogUtil.e(BNVoiceParams.MODULE_TAG, "onNewIntent" + page);
            baseView.initValues(bundle);
        }
    }

    public void onDestory(int page) {
        LogUtil.e(BNVoiceParams.MODULE_TAG, "onDestory:" + page);
        VoiceBaseView baseView = (VoiceBaseView) this.mViewMap.get(Integer.valueOf(page));
        if (baseView != null) {
            if (baseView.hasPaused) {
                this.mViewMap.remove(Integer.valueOf(page));
                if (baseView == this.mLastView) {
                    this.mLastView = null;
                }
                if (baseView == this.mCurrentView) {
                    this.mCurrentView = null;
                }
                baseView.onDestory();
                return;
            }
            LogUtil.e(BNVoiceParams.MODULE_TAG, "onDestory view is in use:" + page);
        }
    }

    public void updateStyle(boolean day) {
        if (this.mCurrentView != null) {
            this.mCurrentView.onUpdateStyle(day);
        }
    }

    public boolean onBackPressed(int page) {
        VoiceBaseView baseView = (VoiceBaseView) this.mViewMap.get(Integer.valueOf(page));
        if (baseView != null) {
            return baseView.onBackPressed();
        }
        return true;
    }

    public void onUpdateOrientation(int orientation, int page) {
        VoiceBaseView baseView = (VoiceBaseView) this.mViewMap.get(Integer.valueOf(page));
        if (baseView != null) {
            baseView.onUpdateOrientation(orientation);
        }
    }

    public void setVoiceShareListener(VoiceShareListener lis) {
        if (lis == null) {
            int len = this.mVoiceShareListenerList.size();
            if (len < 2) {
                this.mVoiceShareListenerList.clear();
                this.mVoiceShareListener = null;
                return;
            }
            this.mVoiceShareListenerList.remove(len - 1);
            this.mVoiceShareListener = (VoiceShareListener) this.mVoiceShareListenerList.get(len - 2);
        } else if (!this.mVoiceShareListenerList.contains(lis)) {
            this.mVoiceShareListenerList.add(lis);
            this.mVoiceShareListener = lis;
        }
    }

    public VoiceShareListener getVoiceShareListener() {
        return this.mVoiceShareListener;
    }

    public void setVoiceDataSwitchListener(BNVoice$VoiceDataSwitchListener listener) {
        this.mVoiceDataSwitchListener = listener;
    }

    public BNVoice$VoiceDataSwitchListener getVoiceDataSwitchListener() {
        return this.mVoiceDataSwitchListener;
    }

    public void setVoiceAccountListener(BNVoice$VoiceAccountListener listener) {
        this.mVoiceAccountListener = listener;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void notifyObservers(int what, int event, Object arg) {
        if (this.mHandler != null) {
            Message msg = this.mHandler.obtainMessage();
            msg.what = what;
            msg.arg1 = event;
            msg.obj = arg;
            this.mHandler.sendMessage(msg);
        }
    }

    public void handleVoiceMessage(int type, int event, Object arg) {
        switch (type) {
            case 1:
                handleVoiceDownEvent(event, arg);
                return;
            case 3:
                handleRecommendVoiceData();
                return;
            case 4:
                handleVoiceDataUpLoad(event);
                return;
            case 6:
                handleGetVoiceInfo(event == 0);
                return;
            case 7:
                handleSouareTouch(event);
                return;
            default:
                return;
        }
    }

    private void handleGetVoiceInfo(boolean success) {
        LogUtil.e(BNVoiceParams.MODULE_TAG, "handleGetVoiceInfo : " + success);
        if (this.mCurrentView == null) {
            return;
        }
        if (this.mCurrentView instanceof VoiceMainView) {
            ((VoiceMainView) this.mCurrentView).updateSharedVoiceInfo(success);
        } else if (this.mCurrentView instanceof VoiceSquareView) {
            ((VoiceSquareView) this.mCurrentView).updateSharedVoiceInfo(success);
        }
    }

    private void handleSouareTouch(int connectStatus) {
        if (this.mCurrentView != null && (this.mCurrentView instanceof VoiceSquareView)) {
            if (connectStatus == 1) {
                ((VoiceSquareView) this.mCurrentView).setWebViewClickableTrue();
            } else {
                ((VoiceSquareView) this.mCurrentView).setWebViewClickableFalse();
            }
        }
    }

    private void handleVoiceDownEvent(int event, Object arg) {
        if (arg != null && (arg instanceof VoiceDownObj)) {
            VoiceDownObj downObj = (VoiceDownObj) arg;
            if (downObj.taskId != null && (downObj.taskId.startsWith(BNVoiceParams.TTS_TEXT_ID) || downObj.taskId.startsWith("20-") || downObj.taskId.startsWith(BNVoiceParams.GLOBAL))) {
                return;
            }
            if (this.mCurrentView == null && event == 4) {
                if (!isSamsungDevice()) {
                    getInstance().switchVoice(downObj.taskId);
                }
                VoiceDownloadController.getInstance().removeSharedVoieInfo(downObj.taskId);
                return;
            }
            switch (event) {
                case 0:
                    LogUtil.e(BNVoiceParams.MODULE_TAG, "handleVoiceDownIdel taskId :" + downObj.taskId);
                    VoiceDownloadController.getInstance().removeSharedVoieInfo(downObj.taskId);
                    if (this.mCurrentView instanceof VoiceMainView) {
                        ((VoiceMainView) this.mCurrentView).refreshData();
                        return;
                    }
                    return;
                case 1:
                case 8:
                    LogUtil.e(BNVoiceParams.MODULE_TAG, "handleVoiceDownUpdate taskId :" + downObj.taskId + " progress :" + downObj.arg1);
                    if (this.mCurrentView instanceof VoiceMainView) {
                        ((VoiceMainView) this.mCurrentView).updateItemView(downObj.taskId, event, downObj.arg1);
                        return;
                    } else if (this.mCurrentView instanceof VoiceSquareView) {
                        ((VoiceSquareView) this.mCurrentView).updateItemView(downObj.taskId, event, downObj.arg1);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    LogUtil.e(BNVoiceParams.MODULE_TAG, "handleVoiceDownPause taskId :" + downObj.taskId + " pauseCause :" + downObj.arg1);
                    if (this.mCurrentView instanceof VoiceMainView) {
                        ((VoiceMainView) this.mCurrentView).updateItemView(downObj.taskId, event, downObj.arg1);
                        return;
                    } else if (this.mCurrentView instanceof VoiceSquareView) {
                        ((VoiceSquareView) this.mCurrentView).updateItemView(downObj.taskId, event, downObj.arg1);
                        return;
                    } else {
                        return;
                    }
                case 3:
                    LogUtil.e(BNVoiceParams.MODULE_TAG, "handleVoiceDownError taskId :" + downObj.taskId + " errorType :" + downObj.arg1);
                    VoiceDownloadController.getInstance().removeSharedVoieInfo(downObj.taskId);
                    if (this.mCurrentView instanceof VoiceMainView) {
                        ((VoiceMainView) this.mCurrentView).updateItemView(downObj.taskId, event, downObj.arg1);
                        return;
                    } else if (this.mCurrentView instanceof VoiceSquareView) {
                        ((VoiceSquareView) this.mCurrentView).updateItemView(downObj.taskId, event, downObj.arg1);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    if (this.mCurrentView instanceof VoiceMainView) {
                        ((VoiceMainView) this.mCurrentView).updateItemView(downObj.taskId, event, 100);
                        if (!isSamsungDevice()) {
                            ((VoiceMainView) this.mCurrentView).switchVoiceData(downObj.taskId);
                        }
                        ((VoiceMainView) this.mCurrentView).refreshData();
                    } else if (this.mCurrentView instanceof VoiceSquareView) {
                        ((VoiceSquareView) this.mCurrentView).updateItemView(downObj.taskId, event, downObj.arg1);
                        if (!isSamsungDevice()) {
                            ((VoiceSquareView) this.mCurrentView).switchVoiceData(downObj.taskId);
                        }
                    } else if (!isSamsungDevice()) {
                        getInstance().switchVoice(downObj.taskId);
                    }
                    VoiceDownloadController.getInstance().removeSharedVoieInfo(downObj.taskId);
                    return;
                case 5:
                    LogUtil.e(BNVoiceParams.MODULE_TAG, "handleVoiceDownStart taskId :" + downObj.taskId + " startType :" + downObj.arg1);
                    if (this.mCurrentView instanceof VoiceSquareView) {
                        ((VoiceSquareView) this.mCurrentView).updateItemView(downObj.taskId, event, downObj.arg1);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean isSamsungDevice() {
        return false;
    }

    private void handleRecommendVoiceData() {
        LogUtil.e(BNVoiceParams.MODULE_TAG, "handleRecommendVoiceData ");
        if (this.mCurrentView != null && (this.mCurrentView instanceof VoiceMainView)) {
            this.mCurrentView.refreshData();
        }
    }

    private void handleVoiceDataUpLoad(int state) {
        LogUtil.e(BNVoiceParams.MODULE_TAG, " ToServer state:" + state);
        if (this.mCurrentView != null && (this.mCurrentView instanceof VoiceDetailView)) {
            ((VoiceDetailView) this.mCurrentView).handleUpdateToServerState(state);
        }
    }

    public boolean switchVoice(String taskId) {
        LogUtil.e(BNVoiceParams.MODULE_TAG, "switchVoice taskId = " + taskId);
        UserOPController.getInstance().add(UserOPParams.VOICE_5_2, taskId, null, null);
        BNVoice$VoiceDataSwitchListener listener = getInstance().getVoiceDataSwitchListener();
        if (listener == null) {
            LogUtil.e(BNVoiceParams.MODULE_TAG, "switchVoice fail listener is null");
            return false;
        } else if (!listener.isCanSwitchVoice()) {
            LogUtil.e(BNVoiceParams.MODULE_TAG, "switchVoice fail can not switch");
            return false;
        } else if (taskId == null) {
            LogUtil.e(BNVoiceParams.MODULE_TAG, "switchVoice normal");
            this.switchData.taskId = null;
            this.switchData.type = 0;
            this.switchData.mainPath = null;
            this.switchData.subPath = null;
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_MANDARIN_USAGE, NaviStatConstants.NAVI_VOICE_MANDARIN_USAGE);
            return listener.onVoiceDataSwitch(this.switchData);
        } else {
            String path = VoiceHelper.getInstance().getVoiceSetPath(taskId, true);
            if (StringUtils.isEmpty(path)) {
                return false;
            }
            this.switchData.mainPath = path;
            this.switchData.taskId = taskId;
            if ("9999".equals(taskId)) {
                LogUtil.e(BNVoiceParams.MODULE_TAG, "switchVoice maidou ");
                this.switchData.type = 1;
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_MCDULL_USAGE, NaviStatConstants.NAVI_VOICE_MCDULL_USAGE);
                return listener.onVoiceDataSwitch(this.switchData);
            } else if ("2-".equals(taskId.substring(0, 2))) {
                this.switchData.subPath = VoiceHelper.getInstance().getVoiceSetPath(taskId, false);
                if (!TextUtils.isEmpty(this.switchData.subPath) || BNVoiceParams.ROBIN.equals(this.switchData.taskId)) {
                    String mixIds = CloudlConfigDataModel.getInstance().mCommonConfig.mixVoiceIds;
                    if (mixIds == null || !mixIds.contains(taskId)) {
                        LogUtil.e(BNVoiceParams.MODULE_TAG, "clound closed mixIds:" + mixIds);
                        this.switchData.type = 3;
                    } else {
                        this.switchData.type = 4;
                    }
                    if (BNVoiceParams.ROBIN.equals(this.switchData.taskId) && this.switchData.subPath == null) {
                        this.switchData.subPath = "/BaiduMap/baiduvoicedata/1-00001.dat.tmp";
                    }
                } else {
                    this.switchData.type = 3;
                }
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_OTHER_FULL_DOSE_USAGE, NaviStatConstants.NAVI_VOICE_OTHER_FULL_DOSE_USAGE);
                return listener.onVoiceDataSwitch(this.switchData);
            } else {
                this.switchData.type = 2;
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_RECORDED_USAGE, VoiceHelper.getInstance().getSuperStarById(taskId));
                return listener.onVoiceDataSwitch(this.switchData);
            }
        }
    }

    public void handleVoiceDataSwitchResult(boolean success) {
        String taskId = this.switchData.taskId;
        if (success) {
            LogUtil.e(BNVoiceParams.MODULE_TAG, "handleVoiceDataSwitchResult type:" + this.switchData.type + " taskId = " + taskId);
            switch (this.switchData.type) {
                case 0:
                    BNSettingManager.setVoicePersonality(0);
                    break;
                case 1:
                    BNSettingManager.setVoicePersonality(1);
                    BNSettingManager.setVoiceTaskId("9999");
                    break;
                case 2:
                    BNSettingManager.setVoicePersonality(2);
                    BNSettingManager.setVoiceTaskId(taskId);
                    break;
                case 3:
                    BNSettingManager.setVoicePersonality(3);
                    BNSettingManager.setVoiceTaskId(taskId);
                    break;
                case 4:
                    BNSettingManager.setVoicePersonality(4);
                    BNSettingManager.setVoiceTaskId(taskId);
                    break;
            }
            if (this.switchData.type == 4) {
                String str;
                BNRouteGuider instance = BNRouteGuider.getInstance();
                if (taskId == null) {
                    str = "0";
                } else {
                    str = taskId;
                }
                instance.setSpecVoiceTaskId(str, true);
            } else {
                BNRouteGuider.getInstance().setSpecVoiceTaskId(taskId == null ? "0" : taskId);
            }
        }
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNVoice$2(this, "handleVoiceDataSwitchResult-" + getClass().getSimpleName(), null, success, taskId), new BNWorkerConfig(100, 0));
    }

    private void showSwitchResultToast(boolean success, String taskId) {
        if (taskId != null) {
            VoiceInfo realData = VoiceHelper.getInstance().getVoiceInfo(taskId);
            if (realData == null) {
                return;
            }
            if (success) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "切换为\"" + realData.name + '\"' + "导航语音");
            } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "切换\"" + realData.name + '\"' + "导航语音失败");
            }
        } else if (success) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "切换为\"普通话\"导航语音");
        } else {
            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "切换\"普通话\"导航语音失败");
        }
    }

    public String getBduss() {
        if (this.mVoiceAccountListener != null) {
            return this.mVoiceAccountListener.onGetAccountBduss();
        }
        return null;
    }

    public String getUserHeadUrl() {
        if (this.mVoiceAccountListener != null) {
            this.mVoiceAccountListener.asynGetAccountHeadUrl();
        }
        return this.mHeadurl;
    }

    public void setUserHeadUrl(String url) {
        this.mHeadurl = url;
        LogUtil.e(BNVoiceParams.MODULE_TAG, "setUserHeadUrl url " + this.mHeadurl);
        if (this.mCurrentView == null) {
            return;
        }
        if (this.mCurrentView instanceof VoiceMainView) {
            ((VoiceMainView) this.mCurrentView).updateUserHeadUrl(this.mHeadurl);
        } else if (this.mCurrentView instanceof VoiceDetailView) {
            ((VoiceDetailView) this.mCurrentView).updateUserHeadUrl(this.mHeadurl);
        }
    }

    public String getLastTaskId() {
        return this.lastTaskId;
    }

    public void setLastTaskId(String lastTaskId) {
        this.lastTaskId = lastTaskId;
    }

    public void setVoiceEventListener(BNVoice$OnVoiceEventListener listener) {
        this.mVoiceEventListener = listener;
        if (listener == null) {
            int len = this.mVoiceEventListenerList.size();
            if (len < 2) {
                this.mVoiceEventListenerList.clear();
                this.mVoiceEventListener = null;
                return;
            }
            this.mVoiceEventListenerList.remove(len - 1);
            this.mVoiceEventListener = (BNVoice$OnVoiceEventListener) this.mVoiceEventListenerList.get(len - 2);
        } else if (!this.mVoiceEventListenerList.contains(listener)) {
            this.mVoiceEventListenerList.add(listener);
            this.mVoiceEventListener = listener;
        }
    }

    public void handleSwitchVoiceNeedRestart(String taskId) {
        if (this.mCurrentView != null && (this.mCurrentView instanceof VoiceMainView)) {
            ((VoiceMainView) this.mCurrentView).onSwitchVoiceNeedRestart(taskId);
        }
    }

    public void showVoiceNextRestartWork() {
        if (this.mVoiceEventListener != null) {
            this.mVoiceEventListener.onEvent(new BNVoice$VoiceEvent(1));
        }
    }

    public void showVoiceReStartDialog() {
        if (this.mVoiceEventListener != null) {
            this.mVoiceEventListener.onEvent(new BNVoice$VoiceEvent(0));
        }
    }

    public void checkCombineVoice() {
        String curId = VoiceHelper.getInstance().getCurrentUsedTTSId();
        if (!TextUtils.isEmpty(curId) && "2-".equals(curId.substring(0, 2))) {
            String mixIds = CloudlConfigDataModel.getInstance().mCommonConfig.mixVoiceIds;
            BNVoice$VoiceDataSwitchListener listener;
            if (mixIds == null || !mixIds.contains(curId)) {
                listener = getInstance().getVoiceDataSwitchListener();
                this.switchData.subPath = VoiceHelper.getInstance().getVoiceSetPath(curId, false);
                if (listener != null && listener.onFreeCustom(this.switchData)) {
                    BNSettingManager.setVoicePersonality(3);
                    return;
                }
                return;
            }
            listener = getInstance().getVoiceDataSwitchListener();
            this.switchData.taskId = curId;
            this.switchData.subPath = VoiceHelper.getInstance().getVoiceSetPath(curId, false);
            if (this.switchData.subPath == null && BNVoiceParams.ROBIN.equals(this.switchData.taskId)) {
                this.switchData.subPath = "/BaiduMap/baiduvoicedata/1-00001.dat.tmp";
            }
            if (this.switchData.subPath != null && listener != null && listener.onLoadCustom(this.switchData)) {
                BNSettingManager.setVoicePersonality(4);
                BNRouteGuider instance = BNRouteGuider.getInstance();
                if (curId == null) {
                    curId = "0";
                }
                instance.setSpecVoiceTaskId(curId, true);
            }
        }
    }
}
