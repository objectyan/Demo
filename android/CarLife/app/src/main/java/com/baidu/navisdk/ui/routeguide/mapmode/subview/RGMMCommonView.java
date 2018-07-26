package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGOffScreenModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMCommonView extends BNBaseView {
    private static final int DEFAULT_SOURCE = -1;
    public static final int EXPEND_VIEW_COUNT = 12;
    public static final int EXPEND_VIEW_TYPE_FOLLOW = 7;
    public static final int EXPEND_VIEW_TYPE_OFFLINE_TO_ONLINE = 10;
    public static final int EXPEND_VIEW_TYPE_OFF_SCREEN = 1;
    public static final int EXPEND_VIEW_TYPE_PARK = 2;
    public static final int EXPEND_VIEW_TYPE_ROAD_CONDITON_FAIL = 3;
    public static final int EXPEND_VIEW_TYPE_RP_PREFER = 6;
    public static final int EXPEND_VIEW_TYPE_SATELLITE = 9;
    public static final int EXPEND_VIEW_TYPE_UGC_OFFICIAL_EVENT = 8;
    private static final int FSM_SOURCE = 4;
    public static final int INTERVENE_TYPE_MSG = 100;
    public static final int INTERVENE_VIEW_COUNT = 3;
    private static final int MESSAGE_SOURCE = 0;
    public static final int NO_INTERVENE_TYPE_MSG = 101;
    private static final String TAG = RGMMCommonView.class.getSimpleName();
    private boolean isFellowShow = false;
    private View mCommonView = null;
    private int[] mCurrentSourceFlags = new int[12];
    private int mDefaultSource = -1;
    private boolean[] mExpendViewShowFlags = new boolean[12];
    private View mFollowLaneContainer = null;
    private View mFollowView = null;

    public RGMMCommonView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initView();
    }

    private void initView() {
        if (this.mRootViewGroup != null) {
            this.mCommonView = this.mRootViewGroup.findViewById(C4048R.id.bnav_extends_info_panel);
            this.mFollowView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_consecutive_point);
            this.mFollowLaneContainer = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_consecutive_lane_ll);
        }
        for (int i = 0; i < 12; i++) {
            this.mExpendViewShowFlags[i] = false;
            this.mCurrentSourceFlags[i] = -1;
        }
    }

    public void orientationChanged(ViewGroup view, int orien) {
        super.orientationChanged(view, orien);
        initView();
    }

    public void handleFollowLaneOrientation(int orientation, boolean isShow) {
        LogUtil.m15791e(RGLaneInfoModel.TAG, "handleFollowLaneOrientation " + orientation + "," + isShow);
        if (isShow && RGMapModeViewController.getInstance().isEnlargeOrColladaShow()) {
            isShow = true;
        } else {
            isShow = false;
        }
        ViewGroup v = (ViewGroup) this.mFollowLaneContainer.getParent();
        MarginLayoutParams lp = (MarginLayoutParams) this.mFollowLaneContainer.getLayoutParams();
        if (orientation == 2) {
            if (isShow) {
                lp.leftMargin = ScreenUtil.getInstance().getGuidePanelWidth();
                setFollowLaneLayout(lp);
            } else {
                lp.leftMargin = 0;
                setFollowLaneLayout(lp);
            }
            RGMapModeViewController.getInstance().hanldleLandScapeLaneShow(isShow);
            return;
        }
        if (isShow) {
            lp.topMargin = (ScreenUtil.getInstance().getHeightPixels() / 2) - ScreenUtil.getInstance().dip2px(108);
            setFollowLaneLayout(lp);
        } else {
            lp.topMargin = 0;
            setFollowLaneLayout(lp);
        }
        RGMapModeViewController.getInstance().handlePortraitLargeLaneViewShow(isShow);
    }

    private void setFollowLaneLayout(MarginLayoutParams lp) {
        if (this.mFollowLaneContainer != null) {
            if (!this.mExpendViewShowFlags[6] && this.mExpendViewShowFlags[7]) {
                this.mFollowLaneContainer.setVisibility(0);
            }
            this.mFollowLaneContainer.setLayoutParams(lp);
        }
    }

    public void showCommonView(boolean show) {
        LogUtil.m15791e(RGLaneInfoModel.TAG, "showCommonView tag are " + show);
        if (!show || !RGViewController.getInstance().isEnlargeOrColladaShow()) {
            boolean noIntervene;
            if (show && hasActualShow(100)) {
                showOrHideView(true, 100);
                noIntervene = showOrHideView(this.isFellowShow, 101);
            } else if (show && hasActualShow(101)) {
                showOrHideView(false, 100);
                noIntervene = showOrHideView(true, 101);
            } else {
                showOrHideView(false, 100);
                noIntervene = showOrHideView(false, 101);
            }
        }
    }

    private boolean showOrHideView(boolean show, int type) {
        switch (type) {
            case 100:
                return showInterveneView(show);
            case 101:
                this.mCurrentSourceFlags[7] = 4;
                return showNoInterveneView(show);
            default:
                return false;
        }
    }

    private boolean showNoInterveneView(boolean show) {
        int dimensionPixelOffset;
        int i = 0;
        boolean hasShow = false;
        if (show) {
            for (int i2 = 6; i2 <= 10; i2++) {
                if (hasShow) {
                    showExpendViewInner(i2, false);
                } else if (this.mExpendViewShowFlags[i2]) {
                    showExpendViewInner(i2, true);
                    hasShow = true;
                } else {
                    showExpendViewInner(i2, false);
                }
            }
        } else {
            if (this.mFollowView != null) {
                this.mFollowView.setVisibility(8);
            }
            if (this.mFollowLaneContainer != null) {
                LogUtil.m15791e(RGLaneInfoModel.TAG, "mFollowLaneContainer dismiss it");
                this.mFollowLaneContainer.setVisibility(8);
            }
            RGViewController.getInstance().handleLaneLineViewShow(false);
            RGViewController.getInstance().showOfflineToOnlineView(false);
            RGViewController.getInstance().showRPPreferView(false);
            RGViewController.getInstance().showSatelliteView(false);
            RGViewController.getInstance().showUgcOfficialEventView(false);
        }
        if (hasShow) {
            dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_not_intervene_height);
        } else {
            dimensionPixelOffset = 0;
        }
        if (1 == RGViewController.getInstance().getOrientation()) {
            i = JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_top_panel_height);
        }
        int carDiff = dimensionPixelOffset + i;
        LogUtil.m15791e(TAG, "RGCommonView.showCommonView()  carDiff  " + carDiff);
        BNMapController.getInstance().setTranslucentHeight(carDiff);
        return hasShow;
    }

    private boolean showInterveneView(boolean show) {
        int i = 0;
        boolean ret = false;
        if (show) {
            boolean hasShow = false;
            int i2 = 0;
            while (i2 <= 3) {
                if (hasShow) {
                    showExpendViewInner(i2, false);
                } else if (this.mExpendViewShowFlags[i2]) {
                    showExpendViewInner(i2, true);
                    hasShow = true;
                    if (i2 == 2 || i2 == 3 || i2 == 1) {
                        ret = true;
                    }
                } else {
                    showExpendViewInner(i2, false);
                }
                i2++;
            }
            if (this.mCommonView != null) {
                View view = this.mCommonView;
                if (!hasShow) {
                    i = 8;
                }
                view.setVisibility(i);
            }
        } else if (this.mCommonView != null) {
            this.mCommonView.setVisibility(8);
        }
        return ret;
    }

    private boolean hasActualShow(int type) {
        switch (type) {
            case 100:
                if (this.mExpendViewShowFlags[0] || this.mExpendViewShowFlags[1] || this.mExpendViewShowFlags[2]) {
                    return true;
                }
                if (this.mExpendViewShowFlags[3]) {
                    return true;
                }
                break;
            case 101:
                if (this.mExpendViewShowFlags[7] || this.mExpendViewShowFlags[10] || this.mExpendViewShowFlags[6] || this.mExpendViewShowFlags[9]) {
                    return true;
                }
                if (this.mExpendViewShowFlags[8]) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean requestShowExpendView(int expendViewType, boolean show, int source) {
        if (expendViewType < 0 || expendViewType >= 12) {
            return false;
        }
        this.mCurrentSourceFlags[expendViewType] = source;
        setShowFlags(expendViewType, show);
        LogUtil.m15791e(TAG, "RGMMCommonView.requestShowExpendView() type=" + expendViewType + ", show=" + show + ", actShow=" + this.mExpendViewShowFlags[expendViewType]);
        boolean hasShow = false;
        if (RGViewController.getInstance().isEnlargeOrColladaShow()) {
            handleEnlargeCanShowView(expendViewType, show, source);
            hasShow = true;
        }
        if (!(hasShow || !NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState()) || RGViewController.getInstance().isEnlargeOrColladaShow() || showInterveneView(true))) {
            showNoInterveneView(true);
        }
        if (expendViewType != -1) {
            return false;
        }
        return true;
    }

    private void handleEnlargeCanShowView(int expendViewType, boolean show, int source) {
        LogUtil.m15791e(RGLaneInfoModel.TAG, "handleEnlargeCanShowView " + expendViewType + "," + show + "," + source);
        if (expendViewType == 7) {
            if (source == 2) {
                LogUtil.m15791e(RGLaneInfoModel.TAG, "handleEnlargeCanShowView visible " + this.mFollowLaneContainer.getVisibility());
                RGMapModeViewController.getInstance().handleLaneLineViewShow(show);
            } else if (source == 1 && this.mFollowView != null) {
                if (show) {
                    this.mFollowView.setVisibility(0);
                } else {
                    this.mFollowView.setVisibility(8);
                }
            }
        }
    }

    public boolean requestShowExpendView(int expendViewType, boolean show) {
        if (expendViewType < 0 || expendViewType >= 12) {
            return false;
        }
        this.mCurrentSourceFlags[7] = 0;
        setShowFlags(expendViewType, show);
        LogUtil.m15791e(TAG, "RGMMCommonView.requestShowExpendView() type=" + expendViewType + ", show=" + show + ", actShow=" + this.mExpendViewShowFlags[expendViewType]);
        boolean hasShow = false;
        if (RGViewController.getInstance().isEnlargeOrColladaShow()) {
            hasShow = true;
        }
        if (!(hasShow || !NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState()) || RGViewController.getInstance().isEnlargeOrColladaShow() || showInterveneView(true))) {
            showNoInterveneView(true);
        }
        if (expendViewType != -1) {
            return false;
        }
        return true;
    }

    private void setShowFlags(int expendViewType, boolean show) {
        if (expendViewType >= 0 && expendViewType < 12) {
            switch (expendViewType) {
                case 1:
                    if (show && RGOffScreenModel.getInstance().isCurrentLocationActive && RGOffScreenModel.getInstance().canEnterOffScreenShow()) {
                        this.mExpendViewShowFlags[expendViewType] = true;
                        return;
                    } else {
                        this.mExpendViewShowFlags[expendViewType] = false;
                        return;
                    }
                case 2:
                    if (show && BNavigator.getInstance().getCanParkShow()) {
                        this.mExpendViewShowFlags[expendViewType] = true;
                        return;
                    } else {
                        this.mExpendViewShowFlags[expendViewType] = false;
                        return;
                    }
                case 3:
                    if (show && RGUpdateRCFailModel.getInstance().isRCUpdateFialCanShow()) {
                        this.mExpendViewShowFlags[expendViewType] = true;
                        return;
                    } else {
                        this.mExpendViewShowFlags[expendViewType] = false;
                        return;
                    }
                case 6:
                    if (show && RGSimpleGuideModel.mIsRPPrefer) {
                        this.mExpendViewShowFlags[expendViewType] = true;
                        return;
                    } else {
                        this.mExpendViewShowFlags[expendViewType] = false;
                        return;
                    }
                case 7:
                    if (this.mFollowView == null) {
                        return;
                    }
                    if ((show || this.mExpendViewShowFlags[expendViewType]) && (RGSimpleGuideModel.getInstance().isShowFollowInfo() || RGLaneInfoModel.getModel(false).isShowLaneLineView())) {
                        this.mExpendViewShowFlags[expendViewType] = true;
                        return;
                    } else {
                        this.mExpendViewShowFlags[expendViewType] = false;
                        return;
                    }
                case 8:
                    if (show && RGSimpleGuideModel.mIsUgcOfficialEvent) {
                        this.mExpendViewShowFlags[expendViewType] = true;
                        return;
                    } else {
                        this.mExpendViewShowFlags[expendViewType] = false;
                        return;
                    }
                case 9:
                    if (show && RGSimpleGuideModel.mIsSatellite) {
                        this.mExpendViewShowFlags[expendViewType] = true;
                        return;
                    } else {
                        this.mExpendViewShowFlags[expendViewType] = false;
                        return;
                    }
                case 10:
                    if (show && RGSimpleGuideModel.mIsOfflineToOnline) {
                        this.mExpendViewShowFlags[expendViewType] = true;
                        return;
                    } else {
                        this.mExpendViewShowFlags[expendViewType] = false;
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void showExpendViewInner(int expendViewType, boolean show) {
        if (expendViewType >= 0 && expendViewType < 12) {
            LogUtil.m15791e(TAG, "RGMMCommonView.showExpendViewInner() type=" + expendViewType + ", show=" + show + ", sOrientation=" + RGCacheStatus.sOrientation);
            switch (expendViewType) {
                case 1:
                    if (show) {
                        RGViewController.getInstance().showOffScreenView();
                        return;
                    } else {
                        RGViewController.getInstance().hideOffScreenView();
                        return;
                    }
                case 2:
                    if (show) {
                        RGViewController.getInstance().showParkView();
                        return;
                    } else {
                        RGViewController.getInstance().hideParkView();
                        return;
                    }
                case 3:
                    if (show) {
                        RGViewController.getInstance().showRoadConditionUpdateFail();
                        return;
                    } else {
                        RGViewController.getInstance().hideRoadConditonUpdateFail();
                        return;
                    }
                case 6:
                    RGViewController.getInstance().showRPPreferView(show);
                    return;
                case 7:
                    if (this.mFollowView != null && this.mFollowLaneContainer != null) {
                        LogUtil.m15791e(RGLaneInfoModel.TAG, "source is " + this.mCurrentSourceFlags[7] + "," + show);
                        if (show) {
                            if (RGSimpleGuideModel.getInstance().isShowFollowInfo()) {
                                this.mFollowView.setVisibility(0);
                            } else {
                                this.mFollowView.setVisibility(8);
                            }
                            RGMapModeViewController.getInstance().handleLaneLineViewShow(RGLaneInfoModel.getModel(false).isShowLaneLineView());
                        } else {
                            LogUtil.m15791e(RGLaneInfoModel.TAG, "false hide source is " + this.mCurrentSourceFlags[7]);
                            if (this.mCurrentSourceFlags[7] == 1) {
                                this.mFollowView.setVisibility(8);
                            } else if (this.mCurrentSourceFlags[7] == 2) {
                                RGMapModeViewController.getInstance().handleLaneLineViewShow(false);
                            } else if (this.mCurrentSourceFlags[7] == 0 || this.mCurrentSourceFlags[7] == 4) {
                                this.mFollowView.setVisibility(8);
                                RGMapModeViewController.getInstance().handleLaneLineViewShow(false);
                            } else {
                                LogUtil.m15791e(RGLaneInfoModel.TAG, "anther source is " + this.mCurrentSourceFlags[7]);
                            }
                            this.mCurrentSourceFlags[7] = -1;
                        }
                        handleFollowLaneContinaerShow();
                        return;
                    }
                    return;
                case 8:
                    RGViewController.getInstance().showUgcOfficialEventView(show);
                    return;
                case 9:
                    RGViewController.getInstance().showSatelliteView(show);
                    return;
                case 10:
                    RGViewController.getInstance().showOfflineToOnlineView(show);
                    return;
                default:
                    return;
            }
        }
    }

    private void handleFollowLaneContinaerShow() {
        int followVisibility = this.mFollowView.getVisibility();
        int laneVisibility = RGMapModeViewController.getInstance().getFellowLineVisibility();
        if (followVisibility == 8 && laneVisibility == 8) {
            handleFollowLaneShow(false);
        } else {
            handleFollowLaneShow(true);
        }
    }

    private void handleFollowLaneShow(boolean isShow) {
        if (isShow) {
            LogUtil.m15791e(RGLaneInfoModel.TAG, "handleFollowLaneShow true show");
        } else {
            LogUtil.m15791e(RGLaneInfoModel.TAG, "handleFollowLaneShow flase gone");
        }
        if (this.mFollowLaneContainer != null) {
            this.mFollowLaneContainer.setVisibility(isShow ? 0 : 8);
        }
    }

    public boolean isCommonViewShow() {
        if (this.mCommonView == null || this.mCommonView.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
