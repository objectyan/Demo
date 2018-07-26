package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.MultiRoadConfig;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationClickListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions$Builder;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGRouteRecommendModel {
    public static final int MSG_AUTO_HIDE = 0;
    private static final String TAG = "RGRouteRecommendModel";
    public static final int TIME_AUTO_HIDE = 20000;
    private static RGRouteRecommendModel sInstance = null;
    private NotificationDisplayListener displayListener = new C44523();
    public boolean isViewCanShow = false;
    private String mContent = null;
    private int mDisplayDuration = 0;
    private int mIconId = 0;
    private String mInfoId = null;
    private int mPattern = 0;
    private int mPushType = -1;
    private int mRouteId = 0;
    private String mSubContent = null;
    private int mSubType = -1;
    public int mUpdateRouteSource = 0;
    private int mVoiceBroadType = -1;
    private String mVoiceContent = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel$1 */
    class C44501 implements NotificationClickListener {
        C44501() {
        }

        public void onConfirmBtnClick() {
            RGRouteRecommendModel.getInstance().isViewCanShow = false;
            BNavigator.getInstance().actionRouteRecommendClick(true, false);
        }

        public void onCancelBtnClick() {
            RGRouteRecommendModel.getInstance().isViewCanShow = false;
            BNavigator.getInstance().actionRouteRecommendClick(false, false);
        }

        public void onAutoHideWithoutClick() {
            RGRouteRecommendModel.getInstance().isViewCanShow = false;
            BNavigator.getInstance().actionRouteRecommendClick(false, false);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel$2 */
    class C44512 implements NotificationClickListener {
        C44512() {
        }

        public void onConfirmBtnClick() {
            RGRouteRecommendModel.this.isViewCanShow = false;
            BNavigator.getInstance().showUgcDetailViewSource(RGRouteRecommendModel.this.mInfoId, true, 4);
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_7, "" + RGRouteRecommendModel.this.mPushType, "5", "" + RGRouteRecommendModel.this.mUpdateRouteSource);
        }

        public void onCancelBtnClick() {
            RGRouteRecommendModel.this.isViewCanShow = false;
            RGNotificationController.getInstance().hideOperableView(103);
            BNavigator.getInstance().enterNavState();
            JNIGuidanceControl.getInstance().setShowRouteChoose(2);
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_7, "" + RGRouteRecommendModel.this.mPushType, "1", "" + RGRouteRecommendModel.this.mUpdateRouteSource);
        }

        public void onAutoHideWithoutClick() {
            RGRouteRecommendModel.this.isViewCanShow = false;
            RGNotificationController.getInstance().hideOperableView(103);
            BNavigator.getInstance().enterNavState();
            JNIGuidanceControl.getInstance().setShowRouteChoose(2);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel$3 */
    class C44523 implements NotificationDisplayListener {
        C44523() {
        }

        public void onShowWithAnim() {
            RGViewController.getInstance().hideHighWayServiceView();
            if (RGRouteRecommendModel.this.mVoiceBroadType == 1) {
                XDVoiceInstructManager.getInstance().onStart();
            }
        }

        public void onShowWithOutAnim() {
            RGViewController.getInstance().hideHighWayServiceView();
            if (RGRouteRecommendModel.this.mVoiceBroadType == 1) {
                XDVoiceInstructManager.getInstance().onStart();
            }
        }

        public void onHideWithAnim() {
            if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
                RGViewController.getInstance().showHighWayServiceView();
            }
            if (RGRouteRecommendModel.this.mVoiceBroadType == 1) {
                LogUtil.m15791e(ModuleName.XDVoice, "showRouteRecommend end , xdEnable(true)");
                XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                XDVoiceInstructManager.getInstance().resetLastInstrut();
                XDVoiceInstructManager.getInstance().onStop();
            }
        }

        public void onHideWithOutAnim() {
            if (RGRouteRecommendModel.this.mVoiceBroadType == 1) {
                XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                XDVoiceInstructManager.getInstance().resetLastInstrut();
                XDVoiceInstructManager.getInstance().onStop();
            }
        }
    }

    public static class RouteInfoType {
        public static final int TYPE_DYNAMIC_INFO = 1;
        public static final int TYPE_GET_START_BID = 2;
        public static final int TYPE_INVALID = 0;
    }

    public static class RouteVoiceBroadType {
        public static final int NE_VoiceBroad_ByClient = 1;
        public static final int NE_VoiceBroad_ByGuide = 2;
        public static final int NE_VoiceBroad_Invalid = -1;
        public static final int NE_VoiceBroad_NoVoice = 0;
    }

    public static class UpdateRouteSourceType {
        public static final int Invalid = 0;
        public static final int RefRouteByAtjVoice = 1;
        public static final int RefRouteByFastRouteVoice = 2;
        public static final int UpdateRouteByButton = 4;
        public static final int UpdateRouteByDetailPanel = 3;
        public static final int UpdateRouteCondition = 5;
    }

    private RGRouteRecommendModel() {
    }

    public static RGRouteRecommendModel getInstance() {
        if (sInstance == null) {
            sInstance = new RGRouteRecommendModel();
        }
        return sInstance;
    }

    public boolean isParamsCorrect() {
        boolean isCorrect = (TextUtils.isEmpty(this.mContent) && TextUtils.isEmpty(this.mSubContent)) ? false : true;
        if (!isCorrect) {
            LogUtil.m15791e(TAG, "isParamsCorrect: fail --> mContent: " + this.mContent + ", mSubContent: " + this.mSubContent);
        }
        return isCorrect;
    }

    public void updateEngineNotificationData() {
        LogUtil.m15791e(TAG, "updateEngineNotificationData: mSubType --> " + this.mSubType);
        int type = 0;
        switch (this.mSubType) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
            case 13:
            case 14:
                type = 1;
                break;
        }
        Bundle bundle = new Bundle();
        if (BNRouteGuider.getInstance().getRouteInfoInUniform(type, bundle)) {
            parseRouteInfo(bundle);
        } else {
            reset();
        }
    }

    private void parseRouteInfo(Bundle bundle) {
        LogUtil.m15791e(TAG, "parseRouteInfo: bundle --> " + (bundle == null ? "null" : bundle.toString()));
        if (bundle == null) {
            reset();
            return;
        }
        this.mIconId = bundle.getInt("nIconID");
        this.mPattern = bundle.getInt("nPattern");
        this.mDisplayDuration = bundle.getInt("nDisplayDuation");
        this.mContent = bundle.getString("usContent");
        this.mSubContent = bundle.getString("usSubContent");
        this.mVoiceContent = bundle.getString("usVoiceContent");
        this.mInfoId = bundle.getString("usInfoID");
        this.mVoiceBroadType = bundle.getInt("enVoiceBroadType");
        this.mPushType = bundle.getInt("enPushType");
        this.mUpdateRouteSource = bundle.getInt("enUpdateRouteSource");
    }

    public void reset() {
        LogUtil.m15791e(TAG, "reset:  --> ");
        this.mInfoId = null;
        this.mIconId = 0;
        this.mContent = null;
        this.mSubContent = null;
        this.mDisplayDuration = 0;
        this.mVoiceContent = null;
        this.mPattern = 0;
        this.mVoiceBroadType = -1;
        this.mPushType = -1;
    }

    public int getAutoHideTime() {
        MultiRoadConfig config = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
        if (config == null) {
            return 20000;
        }
        int time = config.getCardShowTime();
        if (time > 0) {
            return time * 1000;
        }
        return 20000;
    }

    public RGMMOperableNotificationView getNotificationView() {
        switch (this.mSubType) {
            case 7:
            case 13:
                return getRouteSwitchNotificationView();
            case 14:
                return getUGCEventNotificationView();
            default:
                return null;
        }
    }

    private RGMMOperableNotificationView getRouteSwitchNotificationView() {
        String titleName = this.mContent;
        if (titleName == null) {
            titleName = "";
        }
        String roadName = this.mSubContent;
        if (roadName == null) {
            roadName = "";
        }
        RGMMOperableNotificationView view = RGViewController.getInstance().newOperableNotification(103).setPriority(100).setAutoHideTime(getInstance().getAutoHideTime()).setSubTitleText(roadName).setConfirmText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_faster_route_btn_ok)).setCancelText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_faster_route_btn_cancle)).setShowMasking(true).setOnClick(new C44501()).setDisplayListener(this.displayListener);
        if (TextUtils.isEmpty(this.mSubContent)) {
            view.setMainTitleLine(2);
        }
        String castrolFastRouteIconURL = BusinessActivityManager.getInstance().getModel().mCastrolFastRouteIconURL;
        String castrolFastRouteText = BusinessActivityManager.getInstance().getModel().mCastrolFastRouteText;
        if (TextUtils.isEmpty(castrolFastRouteIconURL) || TextUtils.isEmpty(castrolFastRouteText)) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_6, "" + this.mPushType, "0", this.mUpdateRouteSource + "");
            view.setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_route_recommend)).setMainTitleText(titleName);
            ImageView imageview = view.getNotificationIcon();
            if (imageview != null) {
                imageview.setTag(Integer.valueOf(C4048R.drawable.nsdk_notification_route_recommend));
            }
        } else {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_6, "" + this.mPushType, "1", this.mUpdateRouteSource + "");
            view.setNotificationIcon(castrolFastRouteIconURL, new BNDisplayImageOptions$Builder().showImageOnLoading(C4048R.drawable.nsdk_notification_route_recommend).build(), null).setMainTitleText(castrolFastRouteText + titleName);
        }
        return view;
    }

    public RGMMOperableNotificationView getUGCEventNotificationView() {
        int iconID = -1;
        switch (this.mSubType) {
            case 14:
                int localType = -1;
                switch (this.mIconId) {
                    case 101:
                        localType = 4;
                        break;
                    case 102:
                        localType = 5;
                        break;
                    case 103:
                        localType = 8;
                        break;
                    case 104:
                        localType = 7;
                        break;
                    case 106:
                        localType = 9;
                        break;
                    case 107:
                        localType = 10;
                        break;
                    case 110:
                        localType = 6;
                        break;
                }
                if (localType != -1) {
                    iconID = UgcDataProvider.getDrawableIdByType(localType);
                    break;
                }
                break;
        }
        RGMMOperableNotificationView view = RGViewController.getInstance().newOperableNotification(107).setPriority(100).setAutoHideTime(getAutoHideTime()).setConfirmText("查看详情").setCancelText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_faster_route_btn_cancle)).setShowMasking(true).setOnClick(new C44512()).setDisplayListener(this.displayListener);
        if (iconID != -1) {
            view.setNotificationIcon(BNStyleManager.getDrawable(iconID));
            view.showNotificationIcon(true);
        } else {
            view.showNotificationIcon(false);
        }
        if (TextUtils.isEmpty(this.mSubContent)) {
            view.setMainTitleLine(2);
        }
        if (!TextUtils.isEmpty(this.mContent)) {
            view.setMainTitleText(this.mContent);
        }
        if (!TextUtils.isEmpty(this.mSubContent)) {
            view.setSubTitleText(this.mSubContent);
        }
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_6, "" + this.mPushType, "0", this.mUpdateRouteSource + "");
        return view;
    }

    public int getmRouteId() {
        return this.mRouteId;
    }

    public void setmRouteId(int mRouteId) {
        this.mRouteId = mRouteId;
    }

    public String getmContent() {
        return this.mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmSubContent() {
        return this.mSubContent;
    }

    public void setmSubContent(String mSubContent) {
        this.mSubContent = mSubContent;
    }

    public int getmPushType() {
        return this.mPushType;
    }

    public void setmPushType(int mPushType) {
        this.mPushType = mPushType;
    }

    public int getmSubType() {
        return this.mSubType;
    }

    public void setmSubType(int mSubType) {
        this.mSubType = mSubType;
    }

    public String getmInfoId() {
        return this.mInfoId;
    }

    public void setmInfoId(String mInfoId) {
        this.mInfoId = mInfoId;
    }

    public String getmVoiceContent() {
        return this.mVoiceContent;
    }

    public void setmVoiceContent(String mVoiceContent) {
        this.mVoiceContent = mVoiceContent;
    }

    public int getmDisplayDuration() {
        return this.mDisplayDuration;
    }

    public void setmDisplayDuration(int mDisplayDuration) {
        this.mDisplayDuration = mDisplayDuration;
    }

    public int getmIconId() {
        return this.mIconId;
    }

    public void setmIconId(int mIconId) {
        this.mIconId = mIconId;
    }

    public int getmPattern() {
        return this.mPattern;
    }

    public void setmPattern(int mPattern) {
        this.mPattern = mPattern;
    }

    public int getmVoiceBroadType() {
        return this.mVoiceBroadType;
    }

    public void setmVoiceBroadType(int mVoiceBroadType) {
        this.mVoiceBroadType = mVoiceBroadType;
    }
}
