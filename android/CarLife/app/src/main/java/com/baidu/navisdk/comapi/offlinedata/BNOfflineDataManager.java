package com.baidu.navisdk.comapi.offlinedata;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.Key;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.jni.nativeif.JNIOfflineDataControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralFunc.Callback;
import com.baidu.navisdk.model.datastruct.ApkInfo;
import com.baidu.navisdk.model.datastruct.CheckNewInfo;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.model.datastruct.OfflineUpdateInfo;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.OfflineDataMergeMsgModel;
import com.baidu.navisdk.model.modelfactory.OfflineDataMergeMsgModel.MergeMessage;
import com.baidu.navisdk.model.modelfactory.OfflineDataModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.module.car.BNYellowBannerTipsController;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.PhoneStatusReceiver;
import com.baidu.navisdk.util.listener.SDCardListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.facebook.common.p141m.C2924g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BNOfflineDataManager extends BNLogicController {
    private static long DOWNLOADING_UPDATE_UI_INTERVAL = 1000;
    public static final int SDCARD_ERROR = 2;
    private static final String TAG = "OffineData";
    private static boolean bHaveGetDownload = false;
    private static ArrayList<OfflineDataInfo> mDownloadProvince = new ArrayList();
    private static volatile BNOfflineDataManager mInstance;
    private static long mLastUpdateNotificationTime;
    private static long mLastUpdateUITime;
    private int curMd5ErrorProvince = -1;
    private Boolean isClickDownloadOnMobile = Boolean.valueOf(false);
    private int lastProvinceId = -1;
    private Activity mActivity = null;
    private int mCurDownloadID = -1;
    private OfflineDataInfo mCurDownloadingProvince = null;
    private MsgHandler mHandler = new MsgHandler(Looper.getMainLooper()) {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r14) {
            /*
            r13 = this;
            r12 = 0;
            r11 = 2;
            r9 = 1;
            r10 = -1;
            r4 = r14.arg1;
            r2 = r14.arg2;
            r7 = r14.what;
            switch(r7) {
                case 4118: goto L_0x0058;
                case 4119: goto L_0x00eb;
                case 4120: goto L_0x00b7;
                case 4121: goto L_0x0011;
                case 4122: goto L_0x0112;
                case 4124: goto L_0x013e;
                case 4125: goto L_0x017d;
                case 4126: goto L_0x01ab;
                case 4127: goto L_0x023a;
                case 4128: goto L_0x0241;
                case 4129: goto L_0x0251;
                case 4130: goto L_0x0261;
                case 4131: goto L_0x0271;
                case 4135: goto L_0x01e5;
                case 4136: goto L_0x01e5;
                case 4137: goto L_0x01e5;
                case 4168: goto L_0x0281;
                case 4184: goto L_0x0291;
                case 4185: goto L_0x02d3;
                case 4186: goto L_0x02a0;
                case 4187: goto L_0x02c4;
                case 4218: goto L_0x02e2;
                case 5555: goto L_0x020a;
                case 5556: goto L_0x01f3;
                case 5565: goto L_0x0223;
                default: goto L_0x000d;
            };
        L_0x000d:
            super.handleMessage(r14);
            return;
        L_0x0011:
            r7 = "OffineData";
            r8 = new java.lang.StringBuilder;
            r8.<init>();
            r9 = "**download province id:";
            r8 = r8.append(r9);
            r8 = r8.append(r4);
            r8 = r8.toString();
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r8 = r2 / 10;
            r7 = r7.handleDownloadStart(r4, r8, r2);
            if (r7 == 0) goto L_0x000d;
        L_0x0035:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.statistics(r4, r12);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mLastProgress = r10;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mCurDownloadID = r4;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.mOfflineDataModel;
            r1 = r7.getUndowloadInfo(r4);
            if (r1 == 0) goto L_0x0052;
        L_0x0050:
            r1.mTaskStatus = r11;
        L_0x0052:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x0058:
            r7 = "Handler";
            r8 = new java.lang.StringBuilder;
            r8.<init>();
            r9 = "**download province id:";
            r8 = r8.append(r9);
            r8 = r8.append(r4);
            r9 = " download mProgress:";
            r8 = r8.append(r9);
            r8 = r8.append(r2);
            r8 = r8.toString();
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.HandleDownloadOnMobile();
            r7 = r7.booleanValue();
            if (r7 == 0) goto L_0x000d;
        L_0x0089:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.lastProvinceId;
            if (r7 == r4) goto L_0x00a4;
        L_0x0091:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.checkSdcardError(r4);
            r7 = r7.booleanValue();
            if (r7 == 0) goto L_0x00a4;
        L_0x009d:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.suspendBatchDownload();
            goto L_0x000d;
        L_0x00a4:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.lastProvinceId = r4;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mCurDownloadID = r4;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r8 = r2 / 10;
            r7.handleDownloadProgress(r4, r8, r2);
            goto L_0x000d;
        L_0x00b7:
            r7 = "Handler";
            r8 = " in case  DOWNLOAD FINISH";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.statistics(r4, r9);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mCurDownloadID = r10;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.updateDownloadFinish(r4);
            if (r7 == 0) goto L_0x00e1;
        L_0x00d2:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mNewProvinceDownload = r9;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mLastProgress = r10;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
        L_0x00e1:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.mActivity;
            if (r7 == 0) goto L_0x000d;
        L_0x00e9:
            goto L_0x000d;
        L_0x00eb:
            r7 = "Handler";
            r8 = " in case MSG_NAVI_DOWNLOAD_ERROR";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = r14.arg2;
            if (r7 != r11) goto L_0x010c;
        L_0x00f8:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.handleSdcardError();
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.mActivity;
            if (r7 == 0) goto L_0x0105;
        L_0x0105:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x010c:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.handleNetWorkError();
            goto L_0x0105;
        L_0x0112:
            r7 = "Handler";
            r8 = new java.lang.StringBuilder;
            r8.<init>();
            r9 = " in case  MSG_NAVI_DOWNLOAD_MD5_ERROR mCurDownloadID ";
            r8 = r8.append(r9);
            r9 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r9 = r9.mCurDownloadID;
            r8 = r8.append(r9);
            r8 = r8.toString();
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mCurDownloadID = r4;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.handleMd5Error(r4);
            goto L_0x000d;
        L_0x013e:
            r7 = "Handler";
            r8 = new java.lang.StringBuilder;
            r8.<init>();
            r9 = "**update province id:";
            r8 = r8.append(r9);
            r8 = r8.append(r4);
            r9 = " update mProgress:";
            r8 = r8.append(r9);
            r8 = r8.append(r2);
            r8 = r8.toString();
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.HandleDownloadOnMobile();
            r7 = r7.booleanValue();
            if (r7 == 0) goto L_0x000d;
        L_0x016f:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mCurDownloadID = r4;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r8 = r2 / 10;
            r7.handleUpdateProgress(r4, r8, r2);
            goto L_0x000d;
        L_0x017d:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r8 = 3;
            r7.statistics(r4, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mCurDownloadID = r10;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r8 = r14.arg2;
            r7 = r7.updateUpdateFinish(r4, r8);
            if (r7 == 0) goto L_0x01a1;
        L_0x0192:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mLastProgress = r10;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mNewProvinceDownload = r9;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
        L_0x01a1:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.mActivity;
            if (r7 == 0) goto L_0x000d;
        L_0x01a9:
            goto L_0x000d;
        L_0x01ab:
            r7 = "Handler";
            r8 = new java.lang.StringBuilder;
            r8.<init>();
            r9 = "==== in case update province id ";
            r8 = r8.append(r9);
            r8 = r8.append(r4);
            r8 = r8.toString();
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r8 = r2 / 10;
            r7 = r7.handleUpdateStart(r4, r8, r2);
            if (r7 == 0) goto L_0x000d;
        L_0x01cf:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.statistics(r4, r11);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mLastProgress = r10;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mCurDownloadID = r4;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x01e5:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r8 = r14.what;
            r7.handleDownloadRequest(r4, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x01f3:
            r7 = "Handler";
            r8 = " in case PhoneStatusReceiver.MSG_TYPE_PHONE_CHANGE";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r3 = r14.arg1;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.handleTelphoneChange(r3);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x020a:
            r7 = "Handler";
            r8 = " in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r6 = r14.arg1;
            r0 = r14.arg2;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.handleNetWorkChange(r6, r0);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x0223:
            r7 = "Handler";
            r8 = " in case SDCardListener.MSG_TYPE_SDCARD_CHANGE";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r5 = r14.arg1;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.handleSDCardChange(r5);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x023a:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.downloadApkProgress(r2);
            goto L_0x000d;
        L_0x0241:
            r7 = "OffineData";
            r8 = "~recved DOWNLOAD_APK_SUCCESS";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.downloadApkSuccess();
            goto L_0x000d;
        L_0x0251:
            r7 = "OffineData";
            r8 = "~recved DOWNLOAD_APK_START";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.downloadApkStart(r2);
            goto L_0x000d;
        L_0x0261:
            r7 = "OffineData";
            r8 = "~recved DOWNLOAD_APK_FAIL";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.downloadApkFail();
            goto L_0x000d;
        L_0x0271:
            r7 = "OffineData";
            r8 = "~recved DOWNLOAD_APK_NET_ERROR";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.downloadApkNetError();
            goto L_0x000d;
        L_0x0281:
            r7 = "Handler";
            r8 = "==== MSG_NAVI_Check_Data_Ver_Fail ";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mIsDataVerNotMatch = r9;
            goto L_0x000d;
        L_0x0291:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.mergeStart(r4);
            if (r7 == 0) goto L_0x000d;
        L_0x0299:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x02a0:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mCurDownloadID = r10;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r8 = r14.arg2;
            r7 = r7.updateUpdateFinish(r4, r8);
            if (r7 == 0) goto L_0x000d;
        L_0x02af:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mLastProgress = r10;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mNewProvinceDownload = r9;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.mIsUpdateFinishNotProgress = r9;
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x02c4:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.mergeFail(r4);
            if (r7 == 0) goto L_0x000d;
        L_0x02cc:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x02d3:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7 = r7.mergeWait(r4);
            if (r7 == 0) goto L_0x000d;
        L_0x02db:
            r7 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.this;
            r7.updateUI();
            goto L_0x000d;
        L_0x02e2:
            r7 = "BNOfflineDataManager";
            r8 = "MSG_NAVI_DOWNLOAD_XIJIANG_SWITCH====";
            com.baidu.navisdk.util.common.LogUtil.m15791e(r7, r8);
            r7 = com.baidu.navisdk.util.worker.BNWorkerCenter.getInstance();
            r8 = new com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager$4$1;
            r9 = new java.lang.StringBuilder;
            r9.<init>();
            r10 = "NaviDownLoadSwitch-";
            r9 = r9.append(r10);
            r10 = r13.getClass();
            r10 = r10.getSimpleName();
            r9 = r9.append(r10);
            r9 = r9.toString();
            r10 = 0;
            r8.<init>(r9, r10);
            r9 = new com.baidu.navisdk.util.worker.BNWorkerConfig;
            r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
            r9.<init>(r10, r12);
            r7.submitMainThreadTask(r8, r9);
            goto L_0x000d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.4.handleMessage(android.os.Message):void");
        }

        public void careAbout() {
            observe(4118);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_ERROR);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_FINISH);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_START);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_MD5_ERROR);
            observe((int) MsgDefine.MSG_NAVI_UPDATE_PROGRESS);
            observe((int) MsgDefine.MSG_NAVI_UPDATE_SUCCESS);
            observe((int) MsgDefine.MSG_NAVI_UPDATE_START);
            observe((int) MsgDefine.MSG_NAVI_CHECK_DOWNLOAD_SUCCESS);
            observe((int) MsgDefine.MSG_NAVI_CHECK_DOWNLOAD_FAIL);
            observe((int) MsgDefine.MSG_NAVI_CHECK_DOWNLOAD_NET_ERROR);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_APK_PROGRESS);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_APK_SUCCESS);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_APK_START);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_APK_FAIL);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_APK_NET_ERROR);
            observe((int) MsgDefine.MSG_NAVI_Check_Data_Ver_Fail);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_START);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_SUCCESS);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_FAIL);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_WAIT);
            observe((int) MsgDefine.MSG_NAVI_DOWNLOAD_XIJIANG_SWITCH);
        }
    };
    private boolean mHaveInitDownloadInfo = false;
    private boolean mHaveValidData = false;
    private ImportNaviMapDataListener mImportListener = null;
    private boolean mIsDataVerNotMatch = false;
    public boolean mIsUpdateFinishNotProgress = false;
    private int mLastProgress = -1;
    private Object mLock = new Object();
    private boolean mNeedReload = false;
    private boolean mNeedReloadCfgFile = true;
    private boolean mNewProvinceDownload = false;
    private JNIOfflineDataControl mOfflineDataControl;
    private OfflineDataModel mOfflineDataModel = null;
    private SDCardListener mSdcardListener;
    private BNMessageDialog mXiJiangDeleteAlertDlg = null;
    private boolean mhasInit = false;
    private LinkedList<Integer> userOperStartList = new LinkedList();
    private LinkedList<Integer> userOperUpdateList = new LinkedList();

    public class ComparatorUtil implements Comparator<OfflineDataInfo> {
        public int compare(OfflineDataInfo lhs, OfflineDataInfo rhs) {
            return lhs.mProvinceId >= rhs.mProvinceId ? 1 : -1;
        }
    }

    public interface DOWNLOAD_STATISTICS_PARAMS {
        public static final int TYPE_DOWNLOAD_FINISH = 1;
        public static final int TYPE_UPDATE_FINISH = 3;
        public static final int TYPE_UPDATE_START = 2;
        public static final int YTPE_DOWNLOAD_START = 0;
    }

    public interface ImportNaviMapDataListener {
        boolean checkDataExitByProvinceId(int i);

        void onImportNaviMapData();

        void startDownLoadDataByProvinceId(int i);
    }

    private BNOfflineDataManager() {
        LogUtil.m15791e("OffineData", "~~~~~~~~~~~~~~~~~~~~~~~~~ BNOfflineDataManager constructor ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.mOfflineDataControl = JNIOfflineDataControl.getInstance();
        this.mOfflineDataModel = (OfflineDataModel) NaviDataEngine.getInstance().getModel(ModelName.OFFLINE_DATA);
        VMsgDispatcher.registerMsgHandler(this.mHandler);
        NetworkListener.registerMessageHandler(this.mHandler);
        PhoneStatusReceiver.registerMessageHandler(this.mHandler);
        SDCardListener.registerMessageHandler(this.mHandler);
    }

    public static BNOfflineDataManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNOfflineDataManager();
        }
        return mInstance;
    }

    public void initSDCardListener(Activity activity) {
        if (this.mSdcardListener == null && activity != null) {
            this.mSdcardListener = new SDCardListener();
            IntentFilter sdcardfilter = new IntentFilter();
            sdcardfilter.addAction("android.intent.action.MEDIA_REMOVED");
            sdcardfilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            sdcardfilter.addAction("android.intent.action.MEDIA_EJECT");
            sdcardfilter.addAction("android.intent.action.MEDIA_MOUNTED");
            sdcardfilter.addDataScheme(C2924g.f12889c);
            try {
                activity.registerReceiver(this.mSdcardListener, sdcardfilter);
            } catch (Exception e) {
            }
        }
    }

    public void UnInitSDCardListener(Activity activity) {
        if (activity != null && this.mSdcardListener != null) {
            try {
                activity.unregisterReceiver(this.mSdcardListener);
            } catch (Exception e) {
            }
            this.mSdcardListener = null;
        }
    }

    public void unregisterAllReceivers(Activity activity) {
        if (this.mHandler != null) {
            VMsgDispatcher.unregisterMsgHandler(this.mHandler);
        }
        if (!(activity == null || this.mSdcardListener == null)) {
            try {
                activity.unregisterReceiver(this.mSdcardListener);
            } catch (Exception e) {
            }
            this.mSdcardListener = null;
        }
        PhoneStatusReceiver.unRegisterMessageHandler(this.mHandler);
    }

    public synchronized boolean isDeleteCommonDataVailid() {
        boolean bRet;
        int index;
        bRet = true;
        if (this.mOfflineDataModel != null && this.mOfflineDataModel.getDowloadedInfo() != null) {
            for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                if (((OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index)).mProvinceId != 0) {
                    bRet = false;
                    break;
                }
            }
        }
        if (this.mOfflineDataModel != null && this.mOfflineDataModel.getUndowloadInfo() != null) {
            for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                OfflineDataInfo model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                if (model.mProvinceId != 0 && model.mTaskStatus != 1) {
                    bRet = false;
                    break;
                }
            }
        }
        return bRet;
    }

    public boolean isProvinceDataDownload(int provinceId) {
        if (this.mOfflineDataModel != null && this.mOfflineDataModel.getDowloadedInfo() != null && this.mOfflineDataModel.getDowloadedInfo().size() > 0) {
            ArrayList<OfflineDataInfo> array = new ArrayList();
            array.addAll(this.mOfflineDataModel.getDowloadedInfo());
            for (int index = 0; index < array.size(); index++) {
                OfflineDataInfo model = (OfflineDataInfo) array.get(index);
                if (model != null && model.mProvinceId == provinceId) {
                    return true;
                }
            }
            return false;
        } else if (this.mhasInit && this.mHaveInitDownloadInfo) {
            return false;
        } else {
            return isProvinceDownload(provinceId);
        }
    }

    public synchronized boolean isProvinceDownloadCommonNotDownload() {
        boolean z = false;
        synchronized (this) {
            boolean isCommonDownload = false;
            if (this.mOfflineDataModel != null && this.mOfflineDataModel.getDowloadedInfo() != null) {
                for (int index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                    OfflineDataInfo model = (OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index);
                    if (model != null && model.mProvinceId == 0) {
                        isCommonDownload = true;
                        break;
                    }
                }
            }
            if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null || isCommonDownload || this.mOfflineDataModel.getDowloadedInfo().size() < 2)) {
                z = true;
            }
        }
        return z;
    }

    public boolean isNewUpdateData() {
        ArrayList<OfflineDataInfo> array = new ArrayList();
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
            array.addAll(this.mOfflineDataModel.getDowloadedInfo());
            for (int index = 0; index < array.size(); index++) {
                OfflineDataInfo model = (OfflineDataInfo) array.get(index);
                if (model != null && model.mIsNewVer) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNewDataUpdating() {
        ArrayList<OfflineDataInfo> array = new ArrayList();
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
            array.addAll(this.mOfflineDataModel.getDowloadedInfo());
            for (int index = 0; index < array.size(); index++) {
                OfflineDataInfo model = (OfflineDataInfo) array.get(index);
                if (model != null && model.mIsNewVer && (model.mTaskStatus == 12 || model.mTaskStatus == 11)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNewProvinceDownload() {
        return this.mNewProvinceDownload;
    }

    public void clearNewProvinceDownload() {
        this.mNewProvinceDownload = false;
    }

    public synchronized boolean isCommonDataDownload() {
        boolean z = true;
        synchronized (this) {
            int index;
            if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
                for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                    if (((OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index)).mProvinceId == 0) {
                        break;
                    }
                }
            }
            if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
                for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                    OfflineDataInfo model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                    if (model.mProvinceId == 0 && (model.mTaskStatus == 2 || model.mTaskStatus == 3)) {
                        break;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    public synchronized void initDownloadInfo(boolean checkNewData) {
        ArrayList<OfflineDataInfo> tmpUnDownloadList;
        ArrayList<OfflineDataInfo> tmpDownloadingList;
        ArrayList<OfflineDataInfo> tmpDownloadedList;
        ArrayList<OfflineDataInfo> tmpNeedUpdateList;
        ArrayList<OfflineDataInfo> tmpUpdatingList;
        ArrayList<OfflineDataInfo> unDownloadMap;
        ArrayList<OfflineDataInfo> downloadedMap;
        int index;
        OfflineDataInfo model;
        boolean addToDownloaded;
        int index2;
        if (this.mhasInit) {
            tmpUnDownloadList = new ArrayList();
            tmpDownloadingList = new ArrayList();
            tmpDownloadedList = new ArrayList();
            tmpNeedUpdateList = new ArrayList();
            tmpUpdatingList = new ArrayList();
            getItemTable(0, tmpUnDownloadList);
            getItemTable(1, tmpDownloadingList);
            getItemTable(2, tmpDownloadedList);
            getItemTable(3, tmpNeedUpdateList);
            getItemTable(4, tmpUpdatingList);
            unDownloadMap = new ArrayList();
            downloadedMap = new ArrayList();
            index = 0;
            while (tmpUnDownloadList != null && index < tmpUnDownloadList.size()) {
                model = (OfflineDataInfo) tmpUnDownloadList.get(index);
                model.mTaskStatus = 1;
                model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                index++;
            }
            if (tmpUnDownloadList != null) {
                unDownloadMap.addAll(tmpUnDownloadList);
            }
            index = 0;
            while (tmpDownloadingList != null && index < tmpDownloadingList.size()) {
                model = (OfflineDataInfo) tmpDownloadingList.get(index);
                model.mTaskStatus = 4;
                model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                index++;
            }
            if (tmpDownloadingList != null) {
                unDownloadMap.addAll(tmpDownloadingList);
            }
            this.mHaveValidData = false;
            for (index = 0; index < tmpDownloadedList.size(); index++) {
                model = (OfflineDataInfo) tmpDownloadedList.get(index);
                model.mTaskStatus = 5;
                model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                if (model.mProvinceId == 0 && tmpDownloadedList.size() >= 2) {
                    this.mHaveValidData = true;
                }
                if (checkNewData) {
                    addToDownloaded = false;
                    for (index2 = 0; index2 < tmpNeedUpdateList.size(); index2++) {
                        if (model.mProvinceId == ((OfflineDataInfo) tmpNeedUpdateList.get(index2)).mProvinceId) {
                            model.mTaskStatus = 10;
                            model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                            model.mIsNewVer = true;
                            downloadedMap.add(model);
                            addToDownloaded = true;
                            break;
                        }
                    }
                    for (index2 = 0; index2 < tmpUpdatingList.size(); index2++) {
                        if (model.mProvinceId == ((OfflineDataInfo) tmpUpdatingList.get(index2)).mProvinceId) {
                            model.mTaskStatus = 13;
                            model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                            model.mIsNewVer = true;
                            downloadedMap.add(model);
                            addToDownloaded = true;
                            break;
                        }
                    }
                    if (OfflineDataMergeMsgModel.getInstance().getIsMergeNeedCache()) {
                        mergeMessageCheck(model);
                    }
                    if (!addToDownloaded) {
                        downloadedMap.add(model);
                    }
                } else {
                    if (OfflineDataMergeMsgModel.getInstance().getIsMergeNeedCache()) {
                        mergeMessageCheck(model);
                    }
                    downloadedMap.add(model);
                }
            }
            Collections.sort(unDownloadMap, new ComparatorUtil());
            if (this.mOfflineDataModel != null) {
                this.mOfflineDataModel.initUnDownloadInfo(unDownloadMap);
                this.mOfflineDataModel.initDownloadedInfo(downloadedMap);
            }
            OfflineDataMergeMsgModel.getInstance().setIsMergeNeedCache(false);
        } else {
            this.mhasInit = true;
            tmpUnDownloadList = new ArrayList();
            tmpDownloadingList = new ArrayList();
            tmpDownloadedList = new ArrayList();
            tmpNeedUpdateList = new ArrayList();
            tmpUpdatingList = new ArrayList();
            getItemTable(0, tmpUnDownloadList);
            getItemTable(1, tmpDownloadingList);
            getItemTable(2, tmpDownloadedList);
            getItemTable(3, tmpNeedUpdateList);
            getItemTable(4, tmpUpdatingList);
            unDownloadMap = new ArrayList();
            downloadedMap = new ArrayList();
            index = 0;
            while (tmpUnDownloadList != null && index < tmpUnDownloadList.size()) {
                model = (OfflineDataInfo) tmpUnDownloadList.get(index);
                model.mTaskStatus = 1;
                model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                index++;
            }
            if (tmpUnDownloadList != null) {
                unDownloadMap.addAll(tmpUnDownloadList);
            }
            index = 0;
            while (tmpDownloadingList != null && index < tmpDownloadingList.size()) {
                model = (OfflineDataInfo) tmpDownloadingList.get(index);
                model.mTaskStatus = 4;
                model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                index++;
            }
            if (tmpDownloadingList != null) {
                unDownloadMap.addAll(tmpDownloadingList);
            }
            this.mHaveValidData = false;
            for (index = 0; index < tmpDownloadedList.size(); index++) {
                model = (OfflineDataInfo) tmpDownloadedList.get(index);
                model.mTaskStatus = 5;
                model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                if (model.mProvinceId == 0 && tmpDownloadedList.size() >= 2) {
                    this.mHaveValidData = true;
                }
                if (checkNewData) {
                    addToDownloaded = false;
                    for (index2 = 0; index2 < tmpNeedUpdateList.size(); index2++) {
                        if (model.mProvinceId == ((OfflineDataInfo) tmpNeedUpdateList.get(index2)).mProvinceId) {
                            model.mTaskStatus = 10;
                            model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                            model.mIsNewVer = true;
                            downloadedMap.add(model);
                            addToDownloaded = true;
                            break;
                        }
                    }
                    for (index2 = 0; index2 < tmpUpdatingList.size(); index2++) {
                        if (model.mProvinceId == ((OfflineDataInfo) tmpUpdatingList.get(index2)).mProvinceId) {
                            model.mTaskStatus = 13;
                            model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
                            model.mIsNewVer = true;
                            downloadedMap.add(model);
                            addToDownloaded = true;
                            break;
                        }
                    }
                    if (!addToDownloaded) {
                        downloadedMap.add(model);
                    }
                } else {
                    downloadedMap.add(model);
                }
            }
            Collections.sort(unDownloadMap, new ComparatorUtil());
            if (this.mOfflineDataModel != null) {
                this.mOfflineDataModel.initUnDownloadInfo(unDownloadMap);
                this.mOfflineDataModel.initDownloadedInfo(downloadedMap);
            }
            this.mHaveInitDownloadInfo = true;
        }
    }

    public synchronized void initDownloadInfoForfirst() {
        ArrayList<OfflineDataInfo> tmpUnDownloadList = new ArrayList();
        ArrayList<OfflineDataInfo> tmpDownloadingList = new ArrayList();
        getItemTable(0, tmpUnDownloadList);
        getItemTable(1, tmpDownloadingList);
        ArrayList<OfflineDataInfo> unDownloadMap = new ArrayList();
        int index = 0;
        while (tmpUnDownloadList != null && index < tmpUnDownloadList.size()) {
            OfflineDataInfo model = (OfflineDataInfo) tmpUnDownloadList.get(index);
            model.mTaskStatus = 1;
            model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
            index++;
        }
        if (tmpUnDownloadList != null) {
            unDownloadMap.addAll(tmpUnDownloadList);
        }
        index = 0;
        while (tmpDownloadingList != null && index < tmpDownloadingList.size()) {
            model = (OfflineDataInfo) tmpDownloadingList.get(index);
            model.mTaskStatus = 4;
            model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
            index++;
        }
        if (tmpDownloadingList != null) {
            unDownloadMap.addAll(tmpDownloadingList);
        }
        Collections.sort(unDownloadMap, new ComparatorUtil());
        this.mOfflineDataModel.initUnDownloadInfo(unDownloadMap);
    }

    private void mergeMessageCheck(OfflineDataInfo model) {
        int i;
        int mergerMessageCacheSize = OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.size();
        int lastElementIndex = 0;
        if (OfflineDataMergeMsgModel.getInstance().mMergerMessageCache != null && mergerMessageCacheSize > 0) {
            i = mergerMessageCacheSize - 1;
            while (i >= 0) {
                MergeMessage msg = (MergeMessage) OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.get(i);
                if (msg.mProviceId == model.mProvinceId) {
                    model.mTaskStatus = msg.mMessageType;
                    if (model.mTaskStatus == 16) {
                        if (mergeStart(model.mProvinceId)) {
                            updateUI();
                        }
                    } else if (model.mTaskStatus == 17) {
                        if (mergeWait(model.mProvinceId)) {
                            updateUI();
                        }
                    } else if (model.mTaskStatus == 18) {
                        this.mCurDownloadID = -1;
                        if (updateUpdateFinish(model.mProvinceId, 0)) {
                            this.mLastProgress = -1;
                            this.mNewProvinceDownload = true;
                            this.mIsUpdateFinishNotProgress = true;
                            updateUI();
                        }
                    } else if (model.mTaskStatus == 19) {
                        if (mergeFail(model.mProvinceId)) {
                            updateUI();
                        }
                    }
                    OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.remove(i);
                    lastElementIndex = i - 1;
                } else {
                    i--;
                }
            }
        }
        if (OfflineDataMergeMsgModel.getInstance().mMergerMessageCache != null && lastElementIndex > 0) {
            for (i = 0; i <= lastElementIndex; i++) {
                if (((MergeMessage) OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.get(i)).mProviceId == model.mProvinceId) {
                    OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.remove(i);
                }
            }
        }
    }

    public ArrayList<OfflineDataInfo> getUndowloadList() {
        ArrayList<OfflineDataInfo> list = new ArrayList();
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
            list.addAll(this.mOfflineDataModel.getUndowloadInfo());
        }
        return list;
    }

    public ArrayList<OfflineDataInfo> getDownloadedList() {
        ArrayList<OfflineDataInfo> list = new ArrayList();
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
            list.addAll(this.mOfflineDataModel.getDowloadedInfo());
        }
        return list;
    }

    public synchronized OfflineDataInfo getDataInfoByProvinceId(int provinceId) {
        OfflineDataInfo model;
        model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
        if (model == null) {
            model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
        }
        return model;
    }

    public synchronized boolean haveValidData() {
        ArrayList<OfflineDataInfo> tmpDownloadedList = new ArrayList();
        getItemTable(2, tmpDownloadedList);
        int index = 0;
        while (tmpDownloadedList != null && index < tmpDownloadedList.size()) {
            OfflineDataInfo model = (OfflineDataInfo) tmpDownloadedList.get(index);
            model.mTaskStatus = 5;
            model.mStrSize = StringUtils.ByteSizeToString(model.mSize);
            if (model.mProvinceId == 0 && tmpDownloadedList.size() >= 2) {
                this.mHaveValidData = true;
                break;
            }
            index++;
        }
        return this.mHaveValidData;
    }

    public synchronized void startDownloadRequest(final int provinceId) {
        OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
        if (model != null) {
            model.mIsRequest = true;
            model.formatStatusTips();
            updateUI();
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.mOfflineDataControl.downloadDataRequest(provinceId);
                    return null;
                }
            }, new BNWorkerConfig(101, 0));
        }
    }

    public synchronized void downloadProvinceData(int provinceId) {
        OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
        if (model != null) {
            this.mOfflineDataControl.downloadData(provinceId);
            model.mTaskStatus = 3;
            updateUI();
        }
    }

    public synchronized void suspendDownloadProvinceData(int provinceId) {
        if (provinceId == 0) {
            suspendBatchDownload();
        } else {
            this.mOfflineDataControl.suspendDownloadData(provinceId);
            OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
            if (model != null) {
                model.mTaskStatus = 4;
            } else {
                model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
                model.mTaskStatus = 4;
            }
            updateUI();
            downloadSuspend(model.mName, model.mProgress);
        }
    }

    public synchronized void updateProvinceData(int provinceId) {
        this.mOfflineDataControl.updateData(provinceId);
        OfflineDataInfo model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
        if (model != null) {
            model.mTaskStatus = 11;
        }
        updateUI();
    }

    public synchronized void suspendUpdateProvinceData(int provinceId) {
        this.mOfflineDataControl.suspendDownloadData(provinceId);
        OfflineDataInfo model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
        if (model != null) {
            model.mTaskStatus = 13;
            updateSuspend(model.mName, model.mUpProgress);
        }
        updateUI();
    }

    public synchronized void cancelUpdateData(int provinceId) {
        OfflineDataInfo model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
        if (model != null && (model.mTaskStatus == 13 || model.mTaskStatus == 11 || model.mTaskStatus == 12 || model.mTaskStatus == 6 || model.mTaskStatus == 12 || model.mTaskStatus == 8 || model.mTaskStatus == 9)) {
            model.mTaskStatus = 10;
            model.mIsNewVer = true;
            model.mUpProgress = 0;
            model.mUpProgressBy10 = 0;
            if (this.mCurDownloadingProvince != null && this.mCurDownloadingProvince.mProvinceId == provinceId) {
                this.mCurDownloadingProvince.mTaskStatus = 10;
                this.mCurDownloadingProvince.mIsNewVer = true;
                this.mCurDownloadingProvince.mUpProgress = 0;
                this.mCurDownloadingProvince.mUpProgressBy10 = 0;
            }
            this.mOfflineDataControl.suspendDownloadData(provinceId);
            this.mOfflineDataControl.cancelUpdateData(provinceId);
            if (provinceId == this.mCurDownloadID) {
                this.mCurDownloadID = -1;
                deleteFinish(model.mName);
            }
            updateUI();
        }
    }

    public synchronized void removeProvinceData(int provinceId) {
        final int[] mDistrictID = new int[64];
        final int[] mDistrictCount = new int[1];
        boolean hasDownload = isProvinceDownload(provinceId);
        this.mOfflineDataControl.suspendDownloadData(provinceId);
        this.mOfflineDataControl.removeDownloadData(provinceId);
        this.mOfflineDataControl.getProvinceMapFileId(provinceId, mDistrictID, mDistrictCount);
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-" + getClass().getSimpleName() + "2", null) {
            protected String execute() {
                for (int i = 0; i < mDistrictCount[0]; i++) {
                    try {
                        new JNIBaseMap(Boolean.valueOf(true)).RemoveVmpMapRecord(mDistrictID[i]);
                    } catch (Exception e) {
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e2) {
                    }
                }
                return null;
            }
        }, new BNWorkerConfig(101, 0));
        OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
        if (model != null) {
            model.mTaskStatus = 1;
            model.mIsNewVer = false;
            model.mUpProgress = 0;
            model.mProgress = 0;
            model.mUpProgressBy10 = 0;
            model.mProgressBy10 = 0;
        } else {
            model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
            if (model != null) {
                model.mTaskStatus = 1;
                model.mIsNewVer = false;
                model.mUpProgress = 0;
                model.mProgress = 0;
                model.mUpProgressBy10 = 0;
                model.mProgressBy10 = 0;
                if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
                    this.mOfflineDataModel.removeDataInDownloaded(provinceId);
                    this.mOfflineDataModel.addDataInUnDownload(model);
                    Collections.sort(this.mOfflineDataModel.getUndowloadInfo(), new ComparatorUtil());
                }
            }
        }
        if (provinceId == this.mCurDownloadID) {
            this.mCurDownloadID = -1;
            if (model != null) {
                deleteFinish(model.mName);
            }
        }
        if (hasDownload) {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("RemoveProvinceData-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    if (!BNavigator.getInstance().isNaviBegin()) {
                        BNaviEngineManager.getInstance().reload();
                        BNaviEngineManager.getInstance().reloadSubSystem(2);
                    }
                    return null;
                }
            }, new BNWorkerConfig(101, 0));
        }
        updateUI();
    }

    public synchronized void suspendBatchDownload() {
        int index;
        OfflineDataInfo model;
        this.mOfflineDataControl.suspendDownloadData(-1);
        boolean hasDowning = false;
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
            for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                if (model.mTaskStatus == 2 || model.mTaskStatus == 3) {
                    model.mTaskStatus = 4;
                    hasDowning = true;
                }
            }
        }
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
            for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                model = (OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index);
                if (model.mTaskStatus == 12 || model.mTaskStatus == 11) {
                    model.mTaskStatus = 13;
                    hasDowning = true;
                }
            }
        }
        updateUI();
        if (hasDowning) {
            suspendAll();
        }
    }

    public boolean checkNewVer(CheckNewInfo checkInfo, ApkInfo apkInfo, int[] nDistrictID, boolean isCheckNewData) {
        boolean ret;
        boolean z = true;
        Bundle bundle = new Bundle();
        try {
            ret = this.mOfflineDataControl.checkNewVer(bundle, nDistrictID);
        } catch (Throwable th) {
            ret = false;
        }
        if (checkInfo != null) {
            boolean z2;
            if (bundle.getInt("newApp", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkInfo.mNewApp = z2;
            if (bundle.getInt("newData", 0) != 1) {
                z = false;
            }
            checkInfo.mNewData = z;
            checkInfo.mCount = bundle.getInt("count", 0);
            LogUtil.m15791e("OffineData", "checkModel: newApp " + checkInfo.mNewApp + ", newData " + checkInfo.mNewData);
        }
        if (apkInfo != null) {
            apkInfo.mUptime = StringUtils.charArrayToString(bundle.getCharArray("cUptime"));
            apkInfo.mApkVer = StringUtils.charArrayToString(bundle.getCharArray("cApkVer"));
            apkInfo.mInfo = StringUtils.shortArrayToString(bundle.getShortArray("usApkInfo"));
            apkInfo.mApkSize = bundle.getInt("unApkSize", 0);
            LogUtil.m15791e("OffineData", "apkModel: upTime " + apkInfo.mUptime + ", ver " + apkInfo.mApkVer + ", info " + apkInfo.mInfo + ", size " + apkInfo.mApkSize);
        }
        initDownloadInfo(isCheckNewData);
        return ret;
    }

    public synchronized boolean getNeedUpdateInfo(ArrayList<OfflineDataInfo> needUpdateList) {
        return getItemTable(3, needUpdateList);
    }

    public synchronized int checkVer(int[] nDistrictID, int[] nCount) {
        return this.mOfflineDataControl.checkVer(nDistrictID, nCount);
    }

    public synchronized boolean getItemTable(int status, ArrayList<OfflineDataInfo> list) {
        boolean z = true;
        synchronized (this) {
            Bundle[] bundles = new Bundle[36];
            try {
                int ret = this.mOfflineDataControl.getItemTable(status, bundles);
                for (Bundle bundle : bundles) {
                    if (bundle != null) {
                        OfflineDataInfo odi = new OfflineDataInfo();
                        odi.mName = bundle.getString("usDistrictName");
                        odi.mProvinceId = bundle.getInt("nDistrictID");
                        odi.mSize = bundle.getInt("unDataSize");
                        odi.mUpSize = bundle.getInt("unUpDataSize");
                        odi.mDownloadSize = bundle.getInt("unDownloadSize");
                        odi.mDownloadUpSize = bundle.getInt("unUpDownloadSize");
                        odi.mStatus = bundle.getInt("enDataStatus");
                        odi.mProgressBy10 = bundle.getInt("unProgress");
                        odi.mUpProgressBy10 = bundle.getInt("unUpProgress");
                        odi.mProgress = odi.mProgressBy10 / 10;
                        odi.mUpProgress = odi.mUpProgressBy10 / 10;
                        list.add(odi);
                        LogUtil.m15791e("OffineData", "GetItem: " + odi.mName + ", " + odi.mProvinceId + ", size " + odi.mSize + ", down " + odi.mDownloadSize + ", progress " + odi.mProgress);
                    }
                }
                if (!bHaveGetDownload && status == 2 && list != null && list.size() > 0) {
                    mDownloadProvince.addAll(list);
                    bHaveGetDownload = true;
                }
                if (ret == -1) {
                    z = false;
                }
            } catch (Throwable th) {
                z = false;
            }
        }
        return z;
    }

    public synchronized int downLoadAppData() {
        return this.mOfflineDataControl.downLoadAppData();
    }

    public synchronized int pauseAppDataDownLoad() {
        return this.mOfflineDataControl.pauseAppDataDownLoad();
    }

    public synchronized int removeAppData() {
        return this.mOfflineDataControl.removeAppData();
    }

    public synchronized int downLoadCityMapData(int provinceId) {
        int DownLoadCityMapData;
        if (NetworkUtils.isTypeNetworkAvailable(BNaviModuleManager.getContext(), 1)) {
            try {
                DownLoadCityMapData = JNIOfflineDataControl.getInstance().DownLoadCityMapData(provinceId);
            } catch (Throwable th) {
            }
        }
        DownLoadCityMapData = -1;
        return DownLoadCityMapData;
    }

    public Boolean getIsClickDownloadOnMobile() {
        return this.isClickDownloadOnMobile;
    }

    public void setIsClickDownloadOnMobile(Boolean isClickDownloadOnMobile) {
        this.isClickDownloadOnMobile = isClickDownloadOnMobile;
    }

    private Boolean HandleDownloadOnMobile() {
        if (getIsClickDownloadOnMobile().booleanValue() || NetworkUtils.isTypeNetworkAvailable(BNaviModuleManager.getContext(), 1)) {
            return Boolean.valueOf(true);
        }
        setIsClickDownloadOnMobile(Boolean.valueOf(false));
        suspendBatchDownload();
        return Boolean.valueOf(false);
    }

    private Boolean checkSdcardError(int provinceId) {
        OfflineDataInfo taskModel = null;
        if (this.mOfflineDataModel != null) {
            taskModel = this.mOfflineDataModel.getUndowloadInfo(provinceId);
        }
        if (taskModel != null) {
            if (SDCardUtils.handleOfflinePathError((long) (taskModel.mSize - ((int) (((double) taskModel.mSize) * (((double) taskModel.mProgress) / 100.0d)))), true) == 1) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    private synchronized boolean handleDownloadStart(int provinceId, int nProgress, int nProgressBy10) {
        boolean z = false;
        synchronized (this) {
            if (nProgress <= 100) {
                OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
                if (model != null && (model.mTaskStatus == 2 || model.mTaskStatus == 3)) {
                    model.mProgress = nProgress;
                    model.mProgressBy10 = nProgressBy10;
                    model.mTaskStatus = 2;
                    downloadStart(model.mName, nProgress);
                    this.mCurDownloadingProvince = model;
                    z = true;
                }
            }
        }
        return z;
    }

    private synchronized boolean handleDownloadProgress(int provinceId, int nProgress, int nProgressBy10) {
        boolean z = false;
        synchronized (this) {
            if (nProgressBy10 <= 1000 && nProgress >= 0 && nProgress <= 100) {
                if (this.mCurDownloadingProvince != null) {
                    if (this.mCurDownloadingProvince.mTaskStatus == 2) {
                        z = false;
                        long time = System.currentTimeMillis();
                        long timeD = Math.abs(time - mLastUpdateNotificationTime);
                        long timeU = Math.abs(time - mLastUpdateUITime);
                        if (nProgress - this.mCurDownloadingProvince.mProgress >= 1 && timeD >= DOWNLOADING_UPDATE_UI_INTERVAL) {
                            downloadProgress(this.mCurDownloadingProvince.mName, nProgress);
                            mLastUpdateNotificationTime = time;
                            z = true;
                        } else if (timeU >= DOWNLOADING_UPDATE_UI_INTERVAL) {
                            mLastUpdateUITime = time;
                            updateUI();
                        }
                        this.mCurDownloadingProvince.mProgress = nProgress;
                        this.mCurDownloadingProvince.mProgressBy10 = nProgressBy10;
                        this.mCurDownloadingProvince.formatStatusTips();
                    }
                }
            }
        }
        return z;
    }

    private synchronized boolean updateDownloadFinish(final int provinceId) {
        boolean z = false;
        synchronized (this) {
            LogUtil.m15791e("OffineData", "updateDownloadFinish enter");
            OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
            if (model != null) {
                if (model.mTaskStatus == 2 || model.mTaskStatus == 3) {
                    model.mTaskStatus = 5;
                    model.mProgress = 100;
                    this.mCurDownloadingProvince = null;
                    this.mOfflineDataModel.removeDataInUndownload(provinceId);
                    this.mOfflineDataModel.addDataInDownloaded(model);
                    ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_FUNC, 7, new Handler(), 1401, 10000);
                    CmdGeneralFunc.addFunc(reqdata, new Callback() {
                        public CommandResult exec() {
                            LogUtil.m15791e("OffineData", "updateDownloadFinish =");
                            BNOfflineDataManager.this.mOfflineDataControl.renameProvinceData(provinceId);
                            try {
                                new JNIBaseMap(Boolean.valueOf(true)).ImportVmpMapRecord();
                            } catch (Exception e) {
                            }
                            return null;
                        }
                    });
                    CommandCenter.getInstance().sendRequest(reqdata);
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("UpdateDownloadFinish-" + getClass().getSimpleName(), null) {
                        protected String execute() {
                            if (BNavigator.getInstance().isNaviBegin() || BCruiser.getInstance().isRouteCruiseBegin() || BNLightNaviManager.getInstance().isNaving() || BNaviModuleManager.isDrivingCar()) {
                                BNOfflineDataManager.this.mNeedReload = true;
                                LogUtil.m15791e(TAG, "UpdateDownloadFinish reset tag");
                            } else {
                                LogUtil.m15791e(TAG, "UpdateDownloadFinish RELOAD");
                                BNaviEngineManager.getInstance().reload();
                                BNOfflineDataManager.getInstance().resetNeedReload();
                            }
                            return null;
                        }
                    }, new BNWorkerConfig(101, 0));
                    downloadFinshed(model.mName);
                    z = true;
                } else {
                    LogUtil.m15791e("OffineData", "updateDownloadFinish return false" + model.mTaskStatus);
                }
            }
        }
        return z;
    }

    private synchronized boolean handleUpdateStart(int provinceId, int nProgress, int nProgressBy10) {
        boolean z = false;
        synchronized (this) {
            OfflineDataInfo model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
            if (model != null && nProgress <= 100) {
                if (model.mTaskStatus == 12 || model.mTaskStatus == 11 || model.mTaskStatus == 13 || model.mTaskStatus == 8 || model.mTaskStatus == 9 || model.mTaskStatus == 6) {
                    model.mUpProgress = nProgress;
                    model.mUpProgressBy10 = nProgressBy10;
                    model.mTaskStatus = 12;
                    model.mIsNewVer = true;
                    updateStart(model.mName, nProgress);
                    this.mCurDownloadingProvince = model;
                    z = true;
                }
            }
        }
        return z;
    }

    private synchronized boolean handleUpdateProgress(int provinceId, int nProgress, int nProgressBy10) {
        boolean z = false;
        synchronized (this) {
            if (nProgressBy10 <= 1000 && nProgress <= 100 && nProgress >= 0) {
                if (this.mCurDownloadingProvince == null) {
                    this.mCurDownloadingProvince = this.mOfflineDataModel.getDowloadedInfo(provinceId);
                    if (this.mCurDownloadingProvince == null) {
                        LogUtil.m15791e("OffineData", "handleUpdateProgress: !! no downloaded province was found by id " + provinceId);
                    }
                }
                if (this.mCurDownloadingProvince.mTaskStatus == 12 || this.mCurDownloadingProvince.mTaskStatus == 11) {
                    z = false;
                    long time = System.currentTimeMillis();
                    long timeD = Math.abs(time - mLastUpdateNotificationTime);
                    long timeU = Math.abs(time - mLastUpdateUITime);
                    if (nProgress - this.mCurDownloadingProvince.mUpProgress >= 1 && timeD >= DOWNLOADING_UPDATE_UI_INTERVAL) {
                        updateProgress(this.mCurDownloadingProvince.mName, nProgress);
                        mLastUpdateNotificationTime = time;
                        z = true;
                    } else if (timeU >= DOWNLOADING_UPDATE_UI_INTERVAL) {
                        mLastUpdateUITime = time;
                        updateUI();
                    }
                    this.mCurDownloadingProvince.mUpProgress = nProgress;
                    this.mCurDownloadingProvince.mUpProgressBy10 = nProgressBy10;
                    this.mCurDownloadingProvince.mTaskStatus = 12;
                    this.mCurDownloadingProvince.formatStatusTips();
                    this.mCurDownloadingProvince.mIsNewVer = true;
                }
            }
        }
        return z;
    }

    public synchronized boolean updateUpdateFinish(int provinceId, int updatePoiCount) {
        boolean z = true;
        synchronized (this) {
            LogUtil.m15791e("OffineData", "updateUpdateFinish ENTER LINE ");
            OfflineDataInfo model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
            if (model == null || !(model.mTaskStatus == 12 || model.mTaskStatus == 11 || model.mTaskStatus == 16)) {
                if (model != null) {
                    LogUtil.m15791e("OffineData", "updateUpdateFinish is " + model.mTaskStatus);
                }
                z = false;
            } else {
                model.mTaskStatus = 5;
                model.mIsNewVer = false;
                OfflineUpdateInfo updateInfo = new OfflineUpdateInfo();
                GetUpdatedInfo(provinceId, updateInfo);
                String updateDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                FileUtils.writeDataUpdateLogToFile(updateDate + "," + model.mName + "," + String.valueOf(updateInfo.mRouteUpCount) + "," + String.valueOf(updateInfo.mPOIUpCount));
                updateInfo.mUpdateDate = updateDate;
                updateFinshed(model.mName, updateInfo);
                this.mCurDownloadingProvince = null;
                this.mNeedReload = true;
                LogUtil.m15791e("OffineData", "SET TAG TURE ");
            }
        }
        return z;
    }

    private synchronized boolean handleDownloadRequest(int provinceId, int msgType) {
        boolean z = true;
        synchronized (this) {
            OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
            if (model != null && model.mTaskStatus == 1) {
                model.mIsRequest = false;
                switch (msgType) {
                    case MsgDefine.MSG_NAVI_CHECK_DOWNLOAD_SUCCESS /*4135*/:
                        downloadProvinceData(provinceId);
                        downloadRequestSuccess(provinceId);
                        break;
                    case MsgDefine.MSG_NAVI_CHECK_DOWNLOAD_FAIL /*4136*/:
                        downloadRequestFail();
                        break;
                    case MsgDefine.MSG_NAVI_CHECK_DOWNLOAD_NET_ERROR /*4137*/:
                        downloadRequestNetError();
                        break;
                    default:
                        break;
                }
            }
            z = false;
        }
        return z;
    }

    private synchronized void handleSdcardError() {
        int index;
        OfflineDataInfo model;
        this.mOfflineDataControl.suspendDownloadData(-1);
        int state = SDCardUtils.handleOfflinePathError(1048576, true);
        if (state == 1) {
            sdcardFull();
        } else if (state != 0) {
            sdcardError();
        }
        boolean z = false;
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
            for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                if (model.mTaskStatus == 2 || model.mTaskStatus == 3) {
                    model.mTaskStatus = 9;
                    model.formatStatusTips();
                    z = true;
                }
            }
        }
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
            for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                model = (OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index);
                if (model.mTaskStatus == 12 || model.mTaskStatus == 11) {
                    model.mTaskStatus = 9;
                    model.formatStatusTips();
                    z = true;
                }
            }
        }
        if (z) {
            suspendAll();
        }
    }

    private synchronized void handleTelphoneChange(int phoneState) {
        if (NetworkUtils.mWifiState != 1) {
            boolean z = false;
            int index;
            OfflineDataInfo model;
            switch (phoneState) {
                case 1:
                case 3:
                    LogUtil.m15791e("OffineData", "=======handle suspend download by telephone ");
                    this.mOfflineDataControl.suspendDownloadData(-1);
                    if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
                        for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                            model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                            if (model.mTaskStatus == 2 || model.mTaskStatus == 3) {
                                model.mIsSuspendByPhoneChange = true;
                                model.mTaskStatus = 4;
                                model.formatStatusTips();
                                z = true;
                            }
                        }
                    }
                    if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
                        for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                            model = (OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index);
                            if (model.mTaskStatus == 12 || model.mTaskStatus == 11) {
                                model.mIsSuspendByPhoneChange = true;
                                model.mTaskStatus = 13;
                                model.formatStatusTips();
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        suspendAll();
                        break;
                    }
                    break;
                case 4:
                    LogUtil.m15791e("OffineData", "=======handle resume download by telephone ");
                    if (this.mCurDownloadingProvince != null && this.mCurDownloadingProvince.mIsSuspendByPhoneChange) {
                        this.mOfflineDataControl.downloadData(this.mCurDownloadID);
                        this.mCurDownloadingProvince.mIsSuspendByPhoneChange = false;
                        if (this.mCurDownloadingProvince.mIsNewVer) {
                            this.mCurDownloadingProvince.mTaskStatus = 11;
                        } else {
                            this.mCurDownloadingProvince.mTaskStatus = 3;
                        }
                        this.mCurDownloadingProvince.formatStatusTips();
                    }
                    if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
                        for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                            model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                            if (model.mIsSuspendByPhoneChange && model.mTaskStatus == 4) {
                                this.mOfflineDataControl.downloadData(model.mProvinceId);
                                model.mIsSuspendByPhoneChange = false;
                                model.mTaskStatus = 3;
                                model.formatStatusTips();
                                z = true;
                            }
                        }
                    }
                    if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
                        for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                            model = (OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index);
                            if (model.mIsSuspendByPhoneChange && model.mTaskStatus == 13) {
                                this.mOfflineDataControl.updateData(model.mProvinceId);
                                model.mIsSuspendByPhoneChange = false;
                                model.mTaskStatus = 11;
                                model.formatStatusTips();
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        updateUI();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private synchronized void handleNetWorkError() {
        int index;
        OfflineDataInfo model;
        this.mOfflineDataControl.suspendDownloadData(-1);
        boolean bRunTask = false;
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
            for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                if (model.mTaskStatus == 2 || model.mTaskStatus == 3) {
                    model.mIsSuspendByNetChange = true;
                    model.mTaskStatus = 6;
                    model.formatStatusTips();
                    bRunTask = true;
                }
            }
        }
        if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
            for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                model = (OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index);
                if (model.mTaskStatus == 12 || model.mTaskStatus == 11) {
                    model.mIsSuspendByNetChange = true;
                    model.mTaskStatus = 6;
                    model.formatStatusTips();
                    bRunTask = true;
                }
            }
        }
        if (bRunTask) {
            suspendAll();
        }
    }

    private synchronized void handleNetWorkChange(int wifiStatus, int connectStatus) {
        if (connectStatus == 0 || wifiStatus == 0) {
            handleNetWorkError();
        } else if (wifiStatus == 1) {
            int index;
            OfflineDataInfo model;
            boolean z = false;
            if (this.mCurDownloadingProvince != null && this.mCurDownloadingProvince.mTaskStatus == 6) {
                this.mOfflineDataControl.downloadData(this.mCurDownloadID);
                this.mCurDownloadingProvince.mIsSuspendByNetChange = false;
                if (this.mCurDownloadingProvince.mIsNewVer) {
                    this.mCurDownloadingProvince.mTaskStatus = 11;
                } else {
                    this.mCurDownloadingProvince.mTaskStatus = 3;
                }
                this.mCurDownloadingProvince.formatStatusTips();
            }
            if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
                for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                    model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                    if (model.mIsSuspendByNetChange && model.mProvinceId != this.mCurDownloadID && model.mTaskStatus == 6) {
                        this.mOfflineDataControl.downloadData(model.mProvinceId);
                        model.mIsSuspendByNetChange = false;
                        model.mTaskStatus = 3;
                        model.formatStatusTips();
                        z = true;
                    }
                }
            }
            if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
                for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                    model = (OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index);
                    if (model.mIsSuspendByNetChange && model.mProvinceId != this.mCurDownloadID && model.mTaskStatus == 6) {
                        this.mOfflineDataControl.updateData(model.mProvinceId);
                        model.mIsSuspendByNetChange = false;
                        model.mTaskStatus = 11;
                        model.formatStatusTips();
                        z = true;
                    }
                }
            }
            if (z) {
                updateUI();
            }
        }
    }

    private synchronized void handleSDCardChange(int sdcardStatus) {
        if (sdcardStatus == 2 || sdcardStatus == 3 || sdcardStatus == 4) {
            int index;
            OfflineDataInfo model;
            this.mOfflineDataControl.suspendDownloadData(-1);
            boolean bRunTask = false;
            if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getUndowloadInfo() == null)) {
                for (index = 0; index < this.mOfflineDataModel.getUndowloadInfo().size(); index++) {
                    model = (OfflineDataInfo) this.mOfflineDataModel.getUndowloadInfo().get(index);
                    if (model.mTaskStatus == 2 || model.mTaskStatus == 3) {
                        model.mTaskStatus = 6;
                        model.formatStatusTips();
                        bRunTask = true;
                    }
                }
            }
            if (!(this.mOfflineDataModel == null || this.mOfflineDataModel.getDowloadedInfo() == null)) {
                for (index = 0; index < this.mOfflineDataModel.getDowloadedInfo().size(); index++) {
                    model = (OfflineDataInfo) this.mOfflineDataModel.getDowloadedInfo().get(index);
                    if (model.mTaskStatus == 12 || model.mTaskStatus == 11) {
                        model.mIsSuspendByNetChange = true;
                        model.mTaskStatus = 6;
                        model.formatStatusTips();
                        bRunTask = true;
                    }
                }
            }
            if (bRunTask) {
                suspendAll();
            }
        }
    }

    private void updateUI() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("UpdateUI-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(1, 0, null);
                    return null;
                }
            }, new BNWorkerConfig(7, 0), 0);
        }
    }

    private void downloadRequestSuccess(final int provinceId) {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadRequestSuccess-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mProgress = provinceId;
                    BNOfflineDataManager.this.notifyObservers(2, 257, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadRequestFail() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadRequestFail-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(2, 258, null);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadRequestNetError() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadRequestNetError-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(2, 259, null);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadStart(String mName, int mProgress) {
        synchronized (this.mLock) {
            final String str = mName;
            final int i = mProgress;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadStart-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = str;
                    arg.mProgress = i;
                    BNOfflineDataManager.this.notifyObservers(2, 260, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadProgress(String mName, int mProgress) {
        synchronized (this.mLock) {
            final String str = mName;
            final int i = mProgress;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadProgress-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = str;
                    arg.mProgress = i;
                    BNOfflineDataManager.this.notifyObservers(2, 261, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadSuspend(String mName, int mProgress) {
        synchronized (this.mLock) {
            final String str = mName;
            final int i = mProgress;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadSuspend-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = str;
                    arg.mProgress = i;
                    BNOfflineDataManager.this.notifyObservers(2, 263, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void suspendAll() {
        int i = 0;
        final String name = this.mCurDownloadingProvince != null ? this.mCurDownloadingProvince.mName : " ";
        if (this.mCurDownloadingProvince != null) {
            i = this.mCurDownloadingProvince.mProgress;
        }
        if (this.mCurDownloadingProvince != null && this.mCurDownloadingProvince.mIsNewVer) {
            i = this.mCurDownloadingProvince.mUpProgress;
        }
        final int progress = i;
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("SuspendAll-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = name;
                    arg.mProgress = progress;
                    BNOfflineDataManager.this.notifyObservers(2, 264, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    public void handleMd5ToRedownload() {
        int princeId = this.curMd5ErrorProvince;
        OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(princeId);
        if (model != null && model.mTaskStatus == 4) {
            removeProvinceData(princeId);
        }
        model = this.mOfflineDataModel.getDowloadedInfo(princeId);
        if (model != null && model.mTaskStatus == 13) {
            cancelUpdateData(princeId);
            removeProvinceData(princeId);
        }
        startDownloadRequest(princeId);
    }

    private void handleMd5Error(int provinceId) {
        this.curMd5ErrorProvince = provinceId;
        OfflineDataInfo model = this.mOfflineDataModel.getUndowloadInfo(provinceId);
        if (model != null && (model.mTaskStatus == 2 || model.mTaskStatus == 3)) {
            suspendDownloadProvinceData(provinceId);
        }
        model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
        if (model != null && (model.mTaskStatus == 12 || model.mTaskStatus == 11)) {
            suspendUpdateProvinceData(provinceId);
        }
        notifiMD5Error();
    }

    private void notifiMD5Error() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("NotifiMD5Error-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(3, 278, null);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadFinshed(final String mName) {
        LogUtil.m15791e("OffineData", "downloadFinshed name is " + mName);
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadFinshed-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    LogUtil.m15791e(TAG, "DownloadFinshed execute");
                    DownloadArg arg = new DownloadArg();
                    arg.mName = mName;
                    arg.mProgress = 100;
                    BNOfflineDataManager.this.notifyObservers(2, 262, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void updateStart(String mName, int mProgress) {
        synchronized (this.mLock) {
            final String str = mName;
            final int i = mProgress;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("UpdateStart-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = str;
                    arg.mProgress = i;
                    BNOfflineDataManager.this.notifyObservers(2, 265, arg);
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 0);
        }
    }

    private void updateProgress(String mName, int mProgress) {
        synchronized (this.mLock) {
            final String str = mName;
            final int i = mProgress;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("UpdateProgress-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = str;
                    arg.mProgress = i;
                    BNOfflineDataManager.this.notifyObservers(2, BNOfflineDataObserver.EVENT_UPDATE_PROGRESS, arg);
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 0);
        }
    }

    private void updateFinshed(String mName, OfflineUpdateInfo updateInfo) {
        synchronized (this.mLock) {
            final String str = mName;
            final OfflineUpdateInfo offlineUpdateInfo = updateInfo;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("UpdateFinshed-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = str;
                    arg.mUpdatePoiCount = offlineUpdateInfo.mPOIUpCount;
                    arg.mUpdateRouteCount = offlineUpdateInfo.mRouteUpCount;
                    arg.mUpdateDate = offlineUpdateInfo.mUpdateDate;
                    BNOfflineDataManager.this.notifyObservers(2, BNOfflineDataObserver.EVENT_UPDATE_FINISH, arg);
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 0);
        }
    }

    private void updateSuspend(String mName, int mProgress) {
        synchronized (this.mLock) {
            final String str = mName;
            final int i = mProgress;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("UpdateSuspend-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = str;
                    arg.mProgress = i;
                    BNOfflineDataManager.this.notifyObservers(2, BNOfflineDataObserver.EVENT_UPDATE_SUSPEND, arg);
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 0);
        }
    }

    private void deleteFinish(final String mName) {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DeleteFinish-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = mName;
                    BNOfflineDataManager.this.notifyObservers(2, BNOfflineDataObserver.EVENT_DELETE_FINISH, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void sdcardError() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("SdcardError-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(3, 270, null);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    public void sdcardFull() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("SdcardFull-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(3, BNOfflineDataObserver.EVENT_ERROR_SD_FULL, null);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadApkStart(final int mProgress) {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadApkStart-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mProgress = mProgress;
                    BNOfflineDataManager.this.notifyObservers(2, 272, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadApkProgress(final int mProgress) {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadApkProgress-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mProgress = mProgress;
                    BNOfflineDataManager.this.notifyObservers(2, 273, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadApkSuccess() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadApkSuccess-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(2, 274, null);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadApkFail() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadApkFail-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(3, 275, null);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void downloadApkNetError() {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("DownloadApkNetError-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNOfflineDataManager.this.notifyObservers(3, 276, null);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    public void checkDataVerNotMatch() {
        if (BNaviModuleManager.getActivity() != null) {
            LogUtil.m15791e("", "BNDownloadUIManager: isFirstShow checkDataVerNotMatch");
            PreferenceHelper.getInstance(BNaviModuleManager.getActivity()).putBoolean(Key.SP_KEY_SHOW_TOAST_FOR_LINKID, true);
            synchronized (this.mLock) {
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("CheckDataVerNotMatch-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        BNOfflineDataManager.this.notifyObservers(3, 277, null);
                        return null;
                    }
                }, new BNWorkerConfig(101, 0), 0);
            }
        }
    }

    public void setImportNaviMapDataListener(ImportNaviMapDataListener l) {
        this.mImportListener = l;
    }

    public boolean getNeedReload() {
        return this.mNeedReload;
    }

    public void setNeedReload(boolean isNeed) {
        this.mNeedReload = isNeed;
    }

    public void resetNeedReload() {
        this.mNeedReload = false;
        LogUtil.m15791e("OffineData", "resetNeedReload ");
    }

    public boolean hasSuspendDownloadDataInfo() {
        Iterator it = this.mOfflineDataModel.getUndowloadInfo().iterator();
        while (it.hasNext()) {
            if (((OfflineDataInfo) it.next()).mTaskStatus == 4) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getSuspendDownloadDataInfo() {
        ArrayList<OfflineDataInfo> models = this.mOfflineDataModel.getUndowloadInfo();
        List<Integer> retList = new ArrayList();
        BitSet provinceSet = BNSettingManager.getDownloadProvinceIdSet();
        Iterator it = models.iterator();
        while (it.hasNext()) {
            OfflineDataInfo model = (OfflineDataInfo) it.next();
            if (model.mTaskStatus == 4 && !provinceSet.get(model.mProvinceId)) {
                retList.add(Integer.valueOf(model.mProvinceId));
            }
        }
        for (int i = 0; i < provinceSet.size(); i++) {
            if (provinceSet.get(i)) {
                retList.add(Integer.valueOf(i));
            }
        }
        return retList;
    }

    private boolean isProvinceDownload(int nProvicneId) {
        boolean retProvince = false;
        boolean retBasePkg = false;
        if (!bHaveGetDownload) {
            getItemTable(2, mDownloadProvince);
            bHaveGetDownload = true;
        }
        int i = 0;
        while (i < mDownloadProvince.size()) {
            if (((OfflineDataInfo) mDownloadProvince.get(i)).mProvinceId == 0 && ((OfflineDataInfo) mDownloadProvince.get(i)).mStatus == 2) {
                retBasePkg = true;
            }
            if (((OfflineDataInfo) mDownloadProvince.get(i)).mProvinceId == nProvicneId && ((OfflineDataInfo) mDownloadProvince.get(i)).mStatus == 2) {
                retProvince = true;
            }
            i++;
        }
        return retBasePkg && retProvince;
    }

    private static boolean removeDownloadProvince(int nProvicneId) {
        if (mDownloadProvince == null) {
            return false;
        }
        int i = 0;
        while (i < mDownloadProvince.size()) {
            if (((OfflineDataInfo) mDownloadProvince.get(i)).mProvinceId == nProvicneId && ((OfflineDataInfo) mDownloadProvince.get(i)).mStatus == 2) {
                mDownloadProvince.remove(i);
            }
            i++;
        }
        return true;
    }

    public boolean GetUpdatedInfo(int provinceId, OfflineUpdateInfo updateInfo) {
        Bundle bundle = new Bundle();
        boolean ret = this.mOfflineDataControl.GetUpdatedInfo(provinceId, bundle);
        updateInfo.mPOIUpCount = bundle.getInt("unUpdatePoiCount");
        updateInfo.mRouteUpCount = bundle.getInt("unUpdateRpCount");
        LogUtil.m15791e("OffineData", "GetUpdatedInfo: POIUpCount " + updateInfo.mPOIUpCount + ", RouteUpCount " + updateInfo.mRouteUpCount);
        return ret;
    }

    private boolean mergeStart(int provinceId) {
        int id = this.mOfflineDataModel.getMergeStartID();
        if (id > 0 && id != provinceId) {
            return false;
        }
        OfflineDataInfo model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
        if (model == null) {
            return false;
        }
        model.mTaskStatus = 16;
        notifyMergeStart(model.mName);
        return true;
    }

    private boolean mergeFail(int provinceId) {
        OfflineDataInfo model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
        if (model == null) {
            return false;
        }
        model.mTaskStatus = 19;
        notifyMergeFail(model.mName);
        return true;
    }

    private boolean mergeWait(int provinceId) {
        OfflineDataInfo model = this.mOfflineDataModel.getDowloadedInfo(provinceId);
        if (model == null) {
            return false;
        }
        model.mTaskStatus = 17;
        notifyMergeWait(model.mName);
        return true;
    }

    private void notifyMergeStart(final String mName) {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("NotifyMergeStart-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = mName;
                    BNOfflineDataManager.this.notifyObservers(2, BNOfflineDataObserver.EVENT_UPDATE_MERGE_START, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void notifyMergeFail(final String mName) {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("NotifyMergeFail-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = mName;
                    BNOfflineDataManager.this.notifyObservers(2, 291, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void notifyMergeSuccess(final String mName) {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("NotifyMergeSuccess-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = mName;
                    BNOfflineDataManager.this.notifyObservers(2, 290, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    private void notifyMergeWait(final String mName) {
        synchronized (this.mLock) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("NotifyMergeWait-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    DownloadArg arg = new DownloadArg();
                    arg.mName = mName;
                    BNOfflineDataManager.this.notifyObservers(2, 289, arg);
                    return null;
                }
            }, new BNWorkerConfig(101, 0), 0);
        }
    }

    public static synchronized void initMergeMessageCache(int messageType, int proviceId) {
        synchronized (BNOfflineDataManager.class) {
            if (messageType == MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_START) {
                OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.add(new MergeMessage(proviceId, 16));
            } else if (messageType == MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_WAIT) {
                OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.add(new MergeMessage(proviceId, 17));
            } else if (messageType == MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_FAIL) {
                OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.add(new MergeMessage(proviceId, 19));
            } else if (messageType == MsgDefine.MSG_NAVI_DOWNLOAD_MERGE_SUCCESS) {
                OfflineDataMergeMsgModel.getInstance().mMergerMessageCache.add(new MergeMessage(proviceId, 18));
            }
        }
    }

    public void memoryUserOper(int provinceID, boolean click, int memoryType) {
        LinkedList<Integer> mList;
        if (this.userOperStartList == null) {
            this.userOperStartList = new LinkedList();
        }
        if (this.userOperUpdateList == null) {
            this.userOperUpdateList = new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        if (memoryType == 0) {
            mList = this.userOperStartList;
        } else if (memoryType == 1) {
            mList = this.userOperUpdateList;
        } else {
            return;
        }
        if (click) {
            if (!mList.contains(Integer.valueOf(provinceID))) {
                mList.add(Integer.valueOf(provinceID));
            }
        } else if (mList.contains(Integer.valueOf(provinceID))) {
            mList.remove(Integer.valueOf(provinceID));
        }
        LogUtil.m15791e("BNOfflineDataManager", "memoryUserOper type:" + memoryType + ",provinceID:" + provinceID + ",isByClick:" + click);
    }

    public void statistics(int provinceID, int type) {
        LinkedList<Integer> mList;
        String isWifi = "0";
        String isByClick = "1";
        if (BNaviModuleManager.getContext() == null) {
            isWifi = "1";
        }
        if (NetworkUtils.isTypeNetworkAvailable(BNaviModuleManager.getContext(), 1)) {
            isWifi = "1";
        }
        if (type == 0 || 1 == type) {
            mList = this.userOperStartList;
        } else {
            mList = this.userOperUpdateList;
        }
        if ((type == 0 || 2 == type) && mList != null && mList.contains(Integer.valueOf(provinceID))) {
            isByClick = "0";
            mList.remove(Integer.valueOf(provinceID));
        }
        LogUtil.m15791e("BNOfflineDataManager", "download type:" + type + ",iswifi:" + isWifi + ",isByClick:" + isByClick + "provinceID:" + provinceID);
        switch (type) {
            case 0:
                UserOPController.getInstance().add(UserOPParams.DATADOWNLOAD_a_1, provinceID + "", isWifi, isByClick);
                return;
            case 1:
                UserOPController.getInstance().add(UserOPParams.DATADOWNLOAD_a_2, provinceID + "", isWifi, null);
                return;
            case 2:
                UserOPController.getInstance().add(UserOPParams.DATADOWNLOAD_a_3, provinceID + "", isWifi, isByClick);
                return;
            case 3:
                UserOPController.getInstance().add(UserOPParams.DATADOWNLOAD_a_4, provinceID + "", isWifi, null);
                return;
            default:
                return;
        }
    }

    public boolean checkBaseMapDataExit(int cityId) {
        try {
            long start = System.currentTimeMillis();
            boolean ret = BNaviModuleManager.checkBaseMapDataExit(cityId);
            LogUtil.m15791e("testDelay:", "coast:" + (System.currentTimeMillis() - start));
            LogUtil.m15791e("DataOffLine:", "return :" + cityId + "__" + ret);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void updateMapDataStutas() {
        BNaviModuleManager.updateMapDataStutas();
    }

    public void startDownBaseMapData(int cityId) {
        BNYellowBannerTipsController.getInstance().setOfflineDataTipsFlag(BNaviModuleManager.getContext(), false);
        if (this.mImportListener != null) {
            this.mImportListener.startDownLoadDataByProvinceId(cityId);
        }
    }

    public boolean hasContainOfflineData() {
        if (OfflineDataParams.PROVINCE_NAME != null) {
            for (int provinceId = 0; provinceId < OfflineDataParams.PROVINCE_NAME.length; provinceId++) {
                if (isProvinceDataDownload(provinceId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void sendUpdateSucessMsg(int provinceId) {
        if (this.mHandler != null) {
            Message msg = this.mHandler.obtainMessage(MsgDefine.MSG_NAVI_UPDATE_SUCCESS);
            msg.arg1 = provinceId;
            msg.arg2 = 100;
            this.mHandler.sendMessage(msg);
        }
    }

    public void setNeedReloadCfgFile(boolean b) {
        this.mNeedReloadCfgFile = b;
    }

    public boolean isNeedReloadCfgFile() {
        return this.mNeedReloadCfgFile;
    }

    public boolean updateCountryInfoFromCfg() {
        return this.mOfflineDataControl.UpdateCountryInfoFromCfg();
    }
}
