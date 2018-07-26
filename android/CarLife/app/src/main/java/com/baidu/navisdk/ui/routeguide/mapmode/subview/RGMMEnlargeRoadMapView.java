package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.ExpandMap;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RasterType;
import com.baidu.navisdk.ui.routeguide.control.RGLaneLineController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.map.ColladaGLSurfaceView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RGMMEnlargeRoadMapView extends BNBaseView {
    public static final String TAG = RGMMEnlargeRoadMapView.class.getSimpleName();
    private AnimationListener animationListener = new C43767();
    private View bnav_rg_enlarge_image_mask;
    private AnimationListener colladaAnimationListener = new C43778();
    private ImageView mCarPosImgView;
    private View mCarPosLayout;
    private int mCarPosX = 0;
    private int mCarPosY = 0;
    private int mCarRotate;
    private View mColladaCloseImage = null;
    private ColladaGLSurfaceView mColladaGLSurfaceView;
    private LinearLayout mColladaLayout = null;
    private View mColladaRl = null;
    private View mEnlargeGuideInfoBackground = null;
    private ImageView mEnlargeImageView = null;
    private View mEnlargeRoadMapView = null;
    private TextView mEnterNextRoadTV = null;
    private boolean mForceRefreshImage = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    Animation mInAnimation = null;
    private AnimationListener mInListener = new C43756();
    private TextView mNextRoadTV = null;
    Animation mOutAnimation = null;
    private int mProgress;
    private ProgressBar mProgressBar = null;
    private int mRemDist;
    private TextView mRemainDistTV = null;
    private TextView mRemainDistUnitTV = null;
    private String mRoadName;
    private Matrix mRotateMatrix;
    private FrameLayout mStreetLayout;
    private ImageView mSwitchView = null;
    private int mTotalDist;
    private ImageView mTurnIcon = null;
    private int mTurnIconId = 0;
    private boolean mbUpdateRasterInfo;
    private String rasterType;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMEnlargeRoadMapView$1 */
    class C43701 implements OnClickListener {
        C43701() {
        }

        public void onClick(View v) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, null, "99", null);
            RGMapModeViewController.getInstance().setmIsShowColladaView(false);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_COLLADA_HIDE);
            RGMMEnlargeRoadMapView.this.resetColladaView();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMEnlargeRoadMapView$2 */
    class C43712 implements OnClickListener {
        C43712() {
        }

        public void onClick(View v) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, null, "99", null);
            RGMapModeViewController.getInstance().setmIsShowColladaView(false);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_COLLADA_HIDE);
            RGMMEnlargeRoadMapView.this.resetColladaView();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMEnlargeRoadMapView$3 */
    class C43723 implements OnClickListener {
        C43723() {
        }

        public void onClick(View arg0) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, null, String.valueOf(RGEnlargeRoadMapModel.getInstance().getEnlargeMapTypeForStatisitcs()), null);
            RGEnlargeRoadMapModel.getInstance().setEnlargeMapTypeForStatisitcs(0);
            RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMEnlargeRoadMapView$4 */
    class C43734 implements OnClickListener {
        C43734() {
        }

        public void onClick(View arg0) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, null, String.valueOf(RGEnlargeRoadMapModel.getInstance().getEnlargeMapTypeForStatisitcs()), null);
            RGEnlargeRoadMapModel.getInstance().setEnlargeMapTypeForStatisitcs(0);
            RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMEnlargeRoadMapView$6 */
    class C43756 implements AnimationListener {
        C43756() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (RGLaneLineController.getInstance().isNormalEnlargeShow) {
                LogUtil.m15791e(RGLaneInfoModel.TAG, "enlagre onAnimationEnd");
                RGMapModeViewController.getInstance().handleLaneEnlargeShow(true);
            }
            BNScreentShotManager.getInstance().rootScreenByMsg();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMEnlargeRoadMapView$7 */
    class C43767 implements AnimationListener {
        C43767() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (RGMMEnlargeRoadMapView.this.mEnlargeRoadMapView != null) {
                RGMMEnlargeRoadMapView.this.mEnlargeRoadMapView.setVisibility(8);
            }
            RGMapModeViewController.getInstance().setIsShowEnlargeRoadMap(false);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMEnlargeRoadMapView$8 */
    class C43778 implements AnimationListener {
        C43778() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            RGMMEnlargeRoadMapView.this.showColladaWithoutAnimation(false);
        }
    }

    public RGMMEnlargeRoadMapView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            ViewStub stub = (ViewStub) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_road_map_stub);
            if (stub != null) {
                this.mEnlargeRoadMapView = stub.inflate();
            }
            this.mEnlargeGuideInfoBackground = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_vector_enlarge_guide_info_background);
            this.mEnlargeImageView = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_image);
            this.mRemainDistTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_remain_dist);
            this.mRemainDistUnitTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_remain_dist_unit);
            this.mNextRoadTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_next_road);
            this.mEnterNextRoadTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enter_enlarge_next_road);
            this.mTurnIcon = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_turn_icon);
            this.mProgressBar = (ProgressBar) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_progress);
            this.mSwitchView = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_open_close);
            this.mRotateMatrix = new Matrix();
            this.mCarPosLayout = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_carpos_layout);
            this.mCarPosImgView = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_carpos_image);
            this.mStreetLayout = (FrameLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_street_layout);
            this.bnav_rg_enlarge_image_mask = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_enlarge_image_mask);
            this.mColladaCloseImage = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_collada_open_close);
            this.mColladaRl = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_collada_view_rl);
            this.mColladaLayout = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_collada_view);
            if (this.mColladaLayout != null) {
                this.mColladaLayout.setOnClickListener(new C43701());
            }
            this.mColladaCloseImage.setOnClickListener(new C43712());
            this.mSwitchView.setOnClickListener(new C43723());
            this.mEnlargeRoadMapView.setOnClickListener(new C43734());
            LayoutParams p;
            LayoutParams pp;
            if (RGViewController.getInstance().getOrientation() == 2) {
                this.mInAnimation = JarUtils.loadAnimation(this.mContext, C4048R.anim.nsdk_anim_rg_slide_in_left);
                this.mOutAnimation = JarUtils.loadAnimation(this.mContext, C4048R.anim.nsdk_anim_rg_slide_out_left);
                p = this.mEnlargeRoadMapView.getLayoutParams();
                p.width = ScreenUtil.getInstance().getHeightPixels() / 2;
                p.height = ScreenUtil.getInstance().getWidthPixels();
                this.mEnlargeRoadMapView.requestLayout();
                pp = this.mColladaRl.getLayoutParams();
                pp.width = ScreenUtil.getInstance().getHeightPixels() / 2;
                pp.height = ScreenUtil.getInstance().getWidthPixels();
                this.mColladaRl.requestLayout();
            } else {
                this.mInAnimation = JarUtils.loadAnimation(this.mContext, C4048R.anim.nsdk_anim_rg_slide_in_top);
                this.mOutAnimation = JarUtils.loadAnimation(this.mContext, C4048R.anim.nsdk_anim_rg_slide_out_top);
                p = this.mEnlargeRoadMapView.getLayoutParams();
                p.width = ScreenUtil.getInstance().getWidthPixels();
                p.height = ScreenUtil.getInstance().getHeightPixels() / 2;
                this.mEnlargeRoadMapView.requestLayout();
                pp = this.mColladaRl.getLayoutParams();
                pp.width = ScreenUtil.getInstance().getWidthPixels();
                pp.height = ScreenUtil.getInstance().getHeightPixels() / 2;
                this.mColladaRl.requestLayout();
            }
            resetColladaView();
            updateDataByLastest();
        }
    }

    public void resetColladaView() {
        if (this.mColladaLayout != null) {
            this.mColladaLayout.removeAllViews();
        }
        this.mColladaGLSurfaceView = null;
    }

    public void updateDataByLastest() {
        if (FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            this.mForceRefreshImage = true;
            updateData(RGEnlargeRoadMapModel.getInstance().getLastestData());
        }
    }

    public void updateData(Bundle b) {
        if (b == null) {
            LogUtil.m15791e(TAG, "b == null");
        } else if (this.mEnlargeRoadMapView != null) {
            updateRasterMapInfo(b.getBoolean(ExpandMap.UpdateProgress), b, null);
        } else {
            LogUtil.m15791e(TAG, "mEnlargeRoadMapView == null");
        }
    }

    public void updateData(Bundle b, boolean isShowMsg) {
        if (b != null && this.mEnlargeRoadMapView != null) {
            boolean isUpdateProgress = b.getBoolean(ExpandMap.UpdateProgress);
            if (isShowMsg) {
                updateRasterMapInfo(!isShowMsg, b, new Object());
            } else {
                updateRasterMapInfo(isUpdateProgress, b, null);
            }
        }
    }

    public void updateRasterMapInfo(boolean updateProgress, Bundle b, Object obj) {
        int nPos;
        String roadName = b.getString("road_name");
        int totalDist = b.getInt(ExpandMap.TotalDist);
        int remDist = b.getInt(ExpandMap.RemainDist);
        String type = b.getString(ExpandMap.RasterType);
        if (!TextUtils.isEmpty(roadName)) {
            this.mRoadName = roadName;
        }
        this.rasterType = type;
        this.mTotalDist = totalDist;
        this.mRemDist = remDist;
        this.mbUpdateRasterInfo = !updateProgress;
        if (remDist <= 0 || totalDist <= 0) {
            nPos = 100;
        } else {
            nPos = ((totalDist - remDist) * 100) / totalDist;
        }
        LogUtil.m15791e(TAG, "!# mRoadName=" + this.mRoadName + ", " + this.rasterType + ", updateRaster=" + this.mbUpdateRasterInfo);
        LogUtil.m15791e(TAG, "!# Raster Pos = " + nPos + " Total = " + this.mTotalDist + " Rem = " + this.mRemDist);
        this.mProgress = nPos;
        if (RasterType.VECTOR.equals(this.rasterType) || RasterType.DIRECT_BOARD.equals(this.rasterType) || RasterType.GRID.equals(this.rasterType)) {
            this.mTurnIconId = b.getInt("resid", 0);
        }
        if (RasterType.VECTOR.equals(this.rasterType)) {
            this.mCarPosX = b.getInt(ExpandMap.CarPosX, 0);
            this.mCarPosY = b.getInt(ExpandMap.CarPosY, 0);
            this.mCarRotate = b.getInt(ExpandMap.CarRotate, 0);
            this.mCarRotate = -this.mCarRotate;
        } else if (this.mCarPosImgView != null) {
            this.mCarPosImgView.setVisibility(4);
        }
        if (!RasterType.STREET.equals(this.rasterType)) {
            if (this.mStreetLayout != null) {
                this.mStreetLayout.setVisibility(4);
            }
            if (this.bnav_rg_enlarge_image_mask != null) {
                this.bnav_rg_enlarge_image_mask.setVisibility(4);
            }
        }
        final Object obj2 = obj;
        final boolean z = updateProgress;
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("UpdateRasterMapInfo-" + getClass().getSimpleName(), null) {
            protected String execute() {
                if (obj2 == null) {
                    RGMMEnlargeRoadMapView.this.progressRun();
                } else {
                    RGMMEnlargeRoadMapView.this.progressRun(!z);
                }
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    private void progressRun(boolean isShow) {
        LogUtil.m15791e(TAG, "update raster, raster type=" + this.rasterType + "show," + isShow + "," + this.mForceRefreshImage);
        if (isShow || this.mForceRefreshImage) {
            this.mForceRefreshImage = false;
            if (RasterType.DIRECT_BOARD.equals(this.rasterType)) {
                updateDirectBoardView();
            } else if (RasterType.GRID.equals(this.rasterType)) {
                updateSimpleModelView();
            } else if (RasterType.VECTOR.equals(this.rasterType)) {
                updateVectorMapView();
            } else if (RasterType.STREET.equals(this.rasterType)) {
                updateStreetView();
            }
        }
        updateProgress();
        updateRoadInfo();
        updateTurnIcon();
    }

    private void progressRun() {
        LogUtil.m15791e(TAG, "update raster, raster type=" + this.rasterType + "," + this.mbUpdateRasterInfo + "," + this.mForceRefreshImage);
        if (this.mbUpdateRasterInfo || this.mForceRefreshImage) {
            this.mForceRefreshImage = false;
            if (RasterType.DIRECT_BOARD.equals(this.rasterType)) {
                updateDirectBoardView();
            } else if (RasterType.GRID.equals(this.rasterType)) {
                updateSimpleModelView();
            } else if (RasterType.VECTOR.equals(this.rasterType)) {
                updateVectorMapView();
            } else if (RasterType.STREET.equals(this.rasterType)) {
                updateStreetView();
            }
        }
        updateProgress();
        updateRoadInfo();
        updateTurnIcon();
    }

    private synchronized void updateDirectBoardView() {
        if (!(this.mEnlargeImageView == null || this.mEnlargeGuideInfoBackground == null)) {
            UIUtils.releaseImageView(this.mEnlargeImageView);
            if (!(RGEnlargeRoadMapModel.getInstance().getArrowBitmap() == null || RGEnlargeRoadMapModel.getInstance().getBGBitmap() == null)) {
                this.mEnlargeImageView.setImageBitmap(RGEnlargeRoadMapModel.getInstance().getArrowBitmap());
                this.mEnlargeImageView.setBackgroundDrawable(new BitmapDrawable(RGEnlargeRoadMapModel.getInstance().getBGBitmap()));
            }
            this.mEnlargeGuideInfoBackground.setVisibility(0);
            this.mEnlargeImageView.setVisibility(0);
        }
    }

    private void updateSimpleModelView() {
        if (this.mEnlargeImageView != null && this.mEnlargeGuideInfoBackground != null) {
            UIUtils.releaseImageView(this.mEnlargeImageView);
            if (!(RGEnlargeRoadMapModel.getInstance().getArrowBitmap() == null || RGEnlargeRoadMapModel.getInstance().getBGBitmap() == null)) {
                this.mEnlargeImageView.setImageBitmap(RGEnlargeRoadMapModel.getInstance().getArrowBitmap());
                this.mEnlargeImageView.setBackgroundDrawable(new BitmapDrawable(RGEnlargeRoadMapModel.getInstance().getBGBitmap()));
            }
            this.mEnlargeGuideInfoBackground.setVisibility(0);
            this.mEnlargeImageView.setVisibility(0);
        }
    }

    private void updateVectorMapView() {
        if (this.mEnlargeImageView != null && this.mEnlargeGuideInfoBackground != null) {
            UIUtils.releaseImageView(this.mEnlargeImageView);
            LogUtil.m15791e(TAG, "!# updateVectorMapView:");
            if (RGEnlargeRoadMapModel.getInstance().getBGBitmap() != null) {
                LogUtil.m15791e(TAG, "!# updateVectorMapView: set bitmap");
                this.mEnlargeImageView.setImageBitmap(RGEnlargeRoadMapModel.getInstance().getBGBitmap());
                this.mEnlargeImageView.setBackgroundResource(17170445);
            }
            this.mEnlargeGuideInfoBackground.setVisibility(0);
            this.mEnlargeImageView.setVisibility(0);
        }
    }

    private void updateStreetView() {
        if (this.mEnlargeImageView != null && this.mEnlargeGuideInfoBackground != null) {
            LogUtil.m15791e(TAG, "updateStreetView, roadName=" + this.mRoadName);
            UIUtils.releaseImageView(this.mEnlargeImageView);
            if (RGEnlargeRoadMapModel.getInstance().getBGBitmap() != null) {
                LogUtil.m15791e(TAG, "!# updateVectorMapView: set bitmap");
                this.mEnlargeImageView.setImageBitmap(RGEnlargeRoadMapModel.getInstance().getBGBitmap());
                this.mEnlargeImageView.setBackgroundResource(17170445);
            }
            this.mEnlargeGuideInfoBackground.setVisibility(0);
            this.mEnlargeImageView.setVisibility(0);
            if (this.bnav_rg_enlarge_image_mask != null && !BNStyleManager.getDayStyle()) {
                this.bnav_rg_enlarge_image_mask.setVisibility(0);
            }
        }
    }

    private void updateRoadInfo() {
        if (this.mNextRoadTV == null || this.mEnterNextRoadTV == null) {
            LogUtil.m15791e(TAG, "updateRoadInfo fail view is null");
            return;
        }
        LogUtil.m15791e(TAG, "updateRoadInfo, roadName=" + this.mRoadName);
        if (RasterType.VECTOR.equals(this.rasterType) || RasterType.DIRECT_BOARD.equals(this.rasterType) || RasterType.GRID.equals(this.rasterType)) {
            this.mNextRoadTV.setVisibility(0);
            this.mEnterNextRoadTV.setVisibility(0);
            this.mEnterNextRoadTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_enter));
            if (TextUtils.isEmpty(this.mRoadName)) {
                this.mNextRoadTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_no_name_road));
            } else {
                this.mNextRoadTV.setText(this.mRoadName);
            }
        } else if (RasterType.STREET.equals(this.rasterType)) {
            this.mEnterNextRoadTV.setVisibility(0);
            this.mEnterNextRoadTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_arrive));
            if (TextUtils.isEmpty(this.mRoadName)) {
                this.mNextRoadTV.setVisibility(8);
                return;
            }
            this.mNextRoadTV.setVisibility(0);
            this.mNextRoadTV.setText(this.mRoadName);
        } else {
            this.mNextRoadTV.setVisibility(8);
            this.mEnterNextRoadTV.setVisibility(8);
        }
    }

    private void updateTurnIcon() {
        if (this.mTurnIcon != null) {
            if (!RasterType.VECTOR.equals(this.rasterType) && !RasterType.DIRECT_BOARD.equals(this.rasterType) && !RasterType.GRID.equals(this.rasterType)) {
                this.mTurnIcon.setVisibility(8);
            } else if (this.mTurnIconId == 0 || this.mTurnIconId == C4048R.drawable.nsdk_drawable_rg_ic_turn_via_1) {
                this.mTurnIcon.setVisibility(8);
            } else {
                this.mTurnIcon.setVisibility(0);
                try {
                    if (RightHandResourcesProvider.getEnNaviType() == 0) {
                        this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(this.mTurnIconId));
                    } else {
                        this.mTurnIcon.setImageDrawable(RightHandResourcesProvider.getDrawableIncludeRightHandIcon(this.mTurnIconId));
                    }
                } catch (Throwable th) {
                    LogUtil.m15791e(TAG, "updateTurnIcon setImageDrawable throwable");
                }
                this.mTurnIconId = 0;
            }
        }
    }

    private void updateProgress() {
        if (this.mRemainDistTV == null || this.mProgressBar == null || this.mStreetLayout == null || this.mRemainDistUnitTV == null) {
            LogUtil.m15791e(TAG, "updateProgress fail has null view");
            return;
        }
        StringBuffer distance = new StringBuffer();
        StringUtils.formatDistance(this.mRemDist, UnitLangEnum.ZH, distance);
        String distanceValue = "";
        String distanceUnit = "";
        try {
            Matcher matcher = Pattern.compile("\\d+").matcher(distance);
            if (matcher.find()) {
                int index = matcher.end();
                if (index >= 0 && index < distance.length()) {
                    distanceValue = distance.substring(0, index);
                    distanceUnit = distance.substring(index);
                }
            }
        } catch (Exception e) {
        }
        LogUtil.m15791e(TAG, "updateProgress distance = " + distance + ", distanceValue = " + distanceValue + ", distanceUnit = " + distanceUnit);
        if (RasterType.VECTOR.equals(this.rasterType) || RasterType.STREET.equals(this.rasterType) || RasterType.DIRECT_BOARD.equals(this.rasterType) || RasterType.GRID.equals(this.rasterType)) {
            if (TextUtils.isEmpty(distanceValue) || TextUtils.isEmpty(distanceUnit)) {
                this.mRemainDistTV.setVisibility(8);
                this.mRemainDistUnitTV.setVisibility(8);
            } else {
                this.mRemainDistTV.setVisibility(0);
                this.mRemainDistUnitTV.setVisibility(0);
                if (this.mRemDist < 10) {
                    this.mRemainDistTV.setText("现在");
                    this.mRemainDistUnitTV.setText("");
                } else {
                    this.mRemainDistTV.setText(distanceValue);
                    this.mRemainDistUnitTV.setText(distanceUnit + "后");
                }
            }
        } else if (TextUtils.isEmpty(distanceValue) || TextUtils.isEmpty(distanceUnit)) {
            this.mRemainDistTV.setVisibility(8);
            this.mRemainDistUnitTV.setVisibility(8);
        } else {
            this.mRemainDistTV.setVisibility(0);
            this.mRemainDistUnitTV.setVisibility(0);
            if (this.mRemDist < 10) {
                this.mRemainDistTV.setText("现在");
                this.mRemainDistUnitTV.setText("");
            } else {
                this.mRemainDistTV.setText(distanceValue);
                this.mRemainDistUnitTV.setText(distanceUnit + "后");
            }
        }
        this.mProgressBar.setProgress(this.mProgress);
        if (!RasterType.VECTOR.equals(this.rasterType)) {
            if (RasterType.STREET.equals(this.rasterType)) {
                this.mStreetLayout.setVisibility(0);
                if (this.mCarPosImgView != null) {
                    this.mCarPosImgView.setVisibility(4);
                }
            } else if (this.mCarPosImgView != null) {
                this.mCarPosImgView.setVisibility(4);
            }
        }
    }

    private void updateVectorMapCarPos() {
        if (RGEnlargeRoadMapModel.getInstance().getBGBitmap() == null) {
            LogUtil.m15791e(TAG, "!# %%%%%%%%% No vector expand map!! %%%%%%%%%");
        } else if (RGEnlargeRoadMapModel.getInstance().getVectorImgWidth() == 0 || RGEnlargeRoadMapModel.getInstance().getVectorImgHeight() == 0) {
            LogUtil.m15791e(TAG, "!# %%%%%%%%% Unkown vector map width or height!!");
        } else {
            double xScale = ((double) this.mCarPosLayout.getWidth()) / ((double) RGEnlargeRoadMapModel.getInstance().getVectorImgWidth());
            double yScale = ((double) this.mCarPosLayout.getHeight()) / ((double) RGEnlargeRoadMapModel.getInstance().getVectorImgHeight());
            this.mCarPosX -= ScreenUtil.getInstance().dip2px(42) / 2;
            this.mCarPosY -= ScreenUtil.getInstance().dip2px(46) / 2;
            LogUtil.m15791e(TAG, "!# adjust car pos X=" + this.mCarPosX + ", Y=" + this.mCarPosY + String.format(", xScale=%1$.2f, yScale=%2$.2f", new Object[]{Double.valueOf(xScale), Double.valueOf(yScale)}) + ", layout W=" + this.mCarPosLayout.getWidth() + ", H=" + this.mCarPosLayout.getHeight());
            if (this.mCarPosX > this.mCarPosLayout.getWidth() || this.mCarPosY > this.mCarPosLayout.getHeight()) {
                LogUtil.m15791e(TAG, "!# out of vector map, W=" + this.mCarPosLayout.getWidth() + ", H=" + this.mCarPosLayout.getHeight());
                if (this.mCarPosImgView != null) {
                    this.mCarPosImgView.setVisibility(8);
                    this.mCarPosImgView.setImageBitmap(null);
                    this.mCarPosImgView.setBackgroundResource(17170445);
                    this.mCarPosImgView.setBackgroundDrawable(null);
                    return;
                }
                return;
            }
            Bitmap bitmap = ((BitmapDrawable) BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_vector_map_car)).getBitmap();
            this.mRotateMatrix.setRotate((float) this.mCarRotate);
            this.mCarPosImgView.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), this.mRotateMatrix, true));
            this.mCarPosImgView.setLayoutParams(new AbsoluteLayout.LayoutParams(ScreenUtil.getInstance().dip2px(42), ScreenUtil.getInstance().dip2px(46), this.mCarPosX, this.mCarPosY));
            this.mCarPosImgView.setVisibility(0);
            this.mCarPosImgView.invalidate();
            RGEnlargeRoadMapModel.getInstance().updateLastCarPos(this.mCarPosX, this.mCarPosY, this.mCarRotate);
        }
    }

    public void show() {
        super.show();
        if (this.mEnlargeRoadMapView != null) {
            RGLaneLineController.getInstance().isNormalEnlargeShow = true;
            this.mInAnimation.setAnimationListener(this.mInListener);
            this.mEnlargeRoadMapView.startAnimation(this.mInAnimation);
            this.mEnlargeRoadMapView.setVisibility(0);
        }
        if (this.mSwitchView != null) {
            this.mSwitchView.setVisibility(0);
        }
        if (!RasterType.VECTOR.equals(this.rasterType) && RasterType.STREET.equals(this.rasterType)) {
            this.mStreetLayout.setVisibility(0);
        }
        RGMapModeViewController.getInstance().setIsShowEnlargeRoadMap(true);
    }

    public void hide() {
        if (RGEnlargeRoadMapModel.getInstance().canEnlargeViewHide()) {
            super.hide();
            if (this.mEnlargeRoadMapView != null) {
                RGLaneLineController.getInstance().isNormalEnlargeShow = false;
                this.mInAnimation.setAnimationListener(null);
                this.mOutAnimation.setAnimationListener(this.animationListener);
                this.mEnlargeRoadMapView.startAnimation(this.mOutAnimation);
            }
            if (this.mSwitchView != null) {
                this.mSwitchView.setVisibility(4);
            }
            if (this.mCarPosLayout != null) {
                this.mCarPosLayout.setVisibility(8);
            }
            if (this.mCarPosImgView != null) {
                this.mCarPosImgView.setVisibility(4);
            }
            if (this.mStreetLayout != null) {
                this.mStreetLayout.setVisibility(4);
            }
            if (this.bnav_rg_enlarge_image_mask != null) {
                this.bnav_rg_enlarge_image_mask.setVisibility(4);
            }
        }
    }

    public void showColladaView(boolean show) {
        if (show) {
            showColladaWithoutAnimation(true);
        } else {
            showColladaWithoutAnimation(false);
        }
    }

    private void showColladaWithoutAnimation(boolean show) {
        if (this.mColladaRl != null) {
            LogUtil.m15791e(RGLaneInfoModel.TAG, "showColladaWithoutAnimation " + show);
            RGMapModeViewController.getInstance().handleLaneEnlargeShow(show);
            if (show) {
                this.mColladaGLSurfaceView = new ColladaGLSurfaceView(this.mContext);
                LayoutParams lp = new LayoutParams(-1, -1);
                if (this.mColladaLayout != null) {
                    this.mColladaLayout.removeAllViews();
                    this.mColladaLayout.addView(this.mColladaGLSurfaceView, lp);
                    this.mColladaLayout.requestLayout();
                }
                RGMapModeViewController.getInstance().handleAssistHighwayShow(false);
                this.mColladaRl.setVisibility(0);
                this.mColladaGLSurfaceView.setVisibility(0);
                return;
            }
            RGMapModeViewController.getInstance().handleAssistHighwayShow(true);
            this.mColladaRl.setVisibility(8);
            if (this.mColladaGLSurfaceView != null) {
                this.mColladaGLSurfaceView.setVisibility(8);
            }
        }
    }

    public void hideWithoutAnimation() {
        if (this.mEnlargeRoadMapView != null) {
            RGLaneLineController.getInstance().isNormalEnlargeShow = false;
            this.mEnlargeRoadMapView.setVisibility(8);
        }
        if (this.mCarPosLayout != null) {
            this.mCarPosLayout.setVisibility(8);
        }
        if (this.mCarPosImgView != null) {
            this.mCarPosImgView.setVisibility(4);
        }
        if (this.mStreetLayout != null) {
            this.mStreetLayout.setVisibility(4);
        }
        if (this.bnav_rg_enlarge_image_mask != null) {
            this.bnav_rg_enlarge_image_mask.setVisibility(4);
        }
        RGMapModeViewController.getInstance().setIsShowEnlargeRoadMap(false);
    }

    public void dispose() {
        super.dispose();
        LogUtil.m15791e(TAG, "onDispose start.");
        UIUtils.releaseImageView(this.mEnlargeImageView);
        UIUtils.releaseImageView(this.mCarPosImgView);
        LogUtil.m15791e(TAG, "onDispose end.");
    }

    public void reset() {
        UIUtils.releaseImageViewWithoutNull(this.mEnlargeImageView);
        UIUtils.releaseImageViewWithoutNull(this.mCarPosImgView);
    }

    public Bitmap getEnlargeViewBitmap() {
        this.mEnlargeRoadMapView.setDrawingCacheEnabled(true);
        return this.mEnlargeRoadMapView.getDrawingCache();
    }

    public Bitmap getEnlargeBitmap() {
        try {
            if (RGEnlargeRoadMapModel.getInstance().getBGBitmap() == null) {
                return null;
            }
            Bitmap result = Bitmap.createBitmap(RGEnlargeRoadMapModel.getInstance().getBGBitmap().getWidth(), RGEnlargeRoadMapModel.getInstance().getBGBitmap().getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            Matrix matrix = new Matrix();
            canvas.drawBitmap(RGEnlargeRoadMapModel.getInstance().getBGBitmap(), matrix, paint);
            if ((!RasterType.DIRECT_BOARD.equals(this.rasterType) && !RasterType.GRID.equals(this.rasterType)) || RGEnlargeRoadMapModel.getInstance().getArrowBitmap() == null) {
                return result;
            }
            canvas.drawBitmap(RGEnlargeRoadMapModel.getInstance().getArrowBitmap(), matrix, paint);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isEnlargeOrColladaShow() {
        boolean z = false;
        if (this.mEnlargeRoadMapView != null) {
            if (this.mEnlargeRoadMapView.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return z;
            }
        }
        if (this.mColladaRl != null) {
            if (this.mColladaRl.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return z;
            }
        }
        return z;
    }
}
