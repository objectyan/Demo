package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drawable.DrawableUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.OnTapListener;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.OverlayItem;

public class RGMMPickPointView extends BNBaseView {
    public static final int POINT_VIEW_OFFSET = 20;
    private static final int POPUP_LEFT_AREA = 0;
    private static final int POPUP_RIGHT_AREA = 1;
    public static final int SCREEN_Y_OFFSET = 58;
    private TextView mPickPointAddr = null;
    private View mPickPointLayout = null;
    private View mPickPointMainText = null;
    private TextView mPickPointName = null;
    private View mPickPointPanel = null;
    private ImageView mPointIV = null;
    private View mSetViaView = null;
    private BNDialog mViaComfirmDialog = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMPickPointView$1 */
    class C44151 implements OnTapListener {
        C44151() {
        }

        public boolean onTap(int index) {
            return false;
        }

        public boolean onTap(GeoPoint p) {
            return false;
        }

        public boolean onTap(int index, int clickIndex, GeoPoint p) {
            switch (clickIndex) {
                case 1:
                    RGMMPickPointView.this.showViaComfirmDialog();
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMPickPointView$2 */
    class C44162 implements OnNaviClickListener {
        C44162() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMPickPointView$3 */
    class C44173 implements OnNaviClickListener {
        C44173() {
        }

        public void onClick() {
            BNRoutePlaner.getInstance().setGuideEndType(1);
            if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                RGRouteSearchModel.getInstance().setRouteSearchMode(false);
                BNPoiSearcher.getInstance().clearBkgCache();
                BNMapController.getInstance().updateLayer(4);
                BNMapController.getInstance().showLayer(4, false);
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_ROUTE_SEARCH_VIA, NaviStatConstants.NAVI_ROUTE_SEARCH_VIA);
            }
            RGEngineControl.getInstance().addViaPtToCalcRoute(RGPickPointModel.getInstance().getPickPoint(), RGPickPointModel.getInstance().getAntiSearchPoi() != null ? RGPickPointModel.getInstance().getAntiSearchPoi().mName : "");
        }
    }

    public RGMMPickPointView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateDataByLastest();
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            if (this.mPickPointLayout == null) {
                this.mPickPointLayout = ((ViewStub) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_pp_layout_stub)).inflate();
            }
            this.mPickPointPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_pp_panel);
            this.mPickPointName = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_pp_name);
            this.mPickPointAddr = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_pp_addr);
            this.mSetViaView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_pp_set_to_via);
            this.mPickPointMainText = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_pp_main_text);
            this.mPointIV = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_pp_point);
        }
    }

    public void updateDataByLastest() {
        updateData(null);
    }

    public void updateData(Bundle b) {
        SearchPoi poi = RGPickPointModel.getInstance().getAntiSearchPoi();
        if (poi == null || poi.mName.length() <= 0 || this.mPickPointName == null || this.mPickPointAddr == null || this.mPickPointLayout == null || this.mPickPointPanel == null) {
            hide();
            return;
        }
        ItemizedOverlayUtil.getInstance().removeAllItems();
        Bundle mBundle = CoordinateTransformUtil.LL2MC(((double) poi.mViewPoint.getLongitudeE6()) / 100000.0d, ((double) poi.mViewPoint.getLatitudeE6()) / 100000.0d);
        GeoPoint pointMc = null;
        MapStatus mapstatus = BNMapController.getInstance().getMapStatus();
        if (!(mBundle == null || mapstatus == null)) {
            pointMc = new GeoPoint(mBundle.getInt("MCx"), mBundle.getInt("MCy"));
            mapstatus._Level = -1.0f;
            mapstatus._CenterPtX = pointMc.getLongitudeE6();
            mapstatus._CenterPtY = pointMc.getLatitudeE6();
        }
        BNMapController.getInstance().setMapStatus(mapstatus, AnimationType.eAnimationAll);
        this.mPickPointName.setText(poi.mName);
        this.mPickPointAddr.setText(poi.mAddress);
        if (this.mPointIV != null) {
            if (RGViewController.getInstance().mIsPickPointDripShow) {
                this.mPointIV.setVisibility(0);
            } else {
                this.mPointIV.setVisibility(4);
            }
        }
        OverlayItem overlayItem = ItemizedOverlayUtil.getInstance().getOverlayItem(pointMc, DrawableUtils.getDrawableFromView(this.mPickPointLayout));
        overlayItem.addClickRect(getLeftContentSizeBundle());
        overlayItem.addClickRect(getRightContentSizeBundle());
        ItemizedOverlayUtil.getInstance().addMapItem(overlayItem);
        ItemizedOverlayUtil.getInstance().show();
        ItemizedOverlayUtil.getInstance().refresh();
        ItemizedOverlayUtil.getInstance().setOnTapListener(new C44151());
    }

    private int getLeftWidth() {
        if (this.mPickPointMainText == null) {
            return 0;
        }
        return this.mPickPointMainText.getMeasuredWidth();
    }

    private int getLeftHeight() {
        if (this.mPickPointMainText == null) {
            return 0;
        }
        return this.mPickPointMainText.getMeasuredHeight();
    }

    private int getRightWidth() {
        if (this.mSetViaView == null) {
            return 0;
        }
        return this.mSetViaView.getMeasuredWidth();
    }

    private int getRightHeight() {
        if (this.mSetViaView == null) {
            return 0;
        }
        return this.mSetViaView.getMeasuredHeight();
    }

    private Bundle getLeftContentSizeBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", getLeftWidth());
        bundle.putInt("t", getLeftHeight() + ScreenUtil.getInstance().dip2px(40));
        bundle.putInt("b", ScreenUtil.getInstance().dip2px(40));
        return bundle;
    }

    private Bundle getRightContentSizeBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", getLeftWidth());
        bundle.putInt("r", getLeftWidth() + getRightWidth());
        bundle.putInt("t", getRightHeight() + ScreenUtil.getInstance().dip2px(40));
        bundle.putInt("b", ScreenUtil.getInstance().dip2px(40));
        return bundle;
    }

    public void show() {
        super.show();
    }

    public void hide() {
        super.hide();
        RGPickPointModel.getInstance().updateAntiSearchPoi(null);
        ItemizedOverlayUtil.getInstance().removeAllItems();
        ItemizedOverlayUtil.getInstance().hide();
        ItemizedOverlayUtil.getInstance().setOnTapListener(null);
    }

    public void showViaComfirmDialog() {
        if (this.mContext != null) {
            hideViaComfirmDialog();
            try {
                this.mViaComfirmDialog = new BNDialog((Activity) this.mContext).enableBackKey(true).setTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(BNStyleManager.getString(C4048R.string.nsdk_string_rg_pp_set_via_tips)).setSecondBtnText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_exit_check)).setSecondBtnTextColorHighLight().setOnSecondBtnClickListener(new C44173()).setFirstBtnText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).setOnFirstBtnClickListener(new C44162());
                if (!this.mViaComfirmDialog.isShowing() && this.mContext != null && !((Activity) this.mContext).isFinishing()) {
                    this.mViaComfirmDialog.show();
                }
            } catch (Exception e) {
            }
        }
    }

    public void hideViaComfirmDialog() {
        if (this.mViaComfirmDialog != null && this.mContext != null && !((Activity) this.mContext).isFinishing()) {
            if (this.mViaComfirmDialog.isShowing()) {
                this.mViaComfirmDialog.dismiss();
            }
            this.mViaComfirmDialog = null;
        }
    }
}
