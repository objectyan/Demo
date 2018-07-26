package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.datastruct.SearchParkPoi.SearchParkKindEnum;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.drawable.DrawableUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.OnTapListener;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.OverlayItem;

public class RGMMParkPointView extends BNBaseView {
    public static final int POINT_VIEW_OFFSET = 20;
    private static final int POPUP_LEFT_AREA = 0;
    private static final int POPUP_RIGHT_AREA = 1;
    public static final int SCREEN_Y_OFFSET = 58;
    private static String TAG = RGMMParkPointView.class.getName();
    private LinearLayout mParkInfoLL = null;
    private TextView mPickPointAddr = null;
    private View mPickPointLayout = null;
    private TextView mPickPointName = null;
    private View mPickPointPanel = null;
    private TextView mSetParkView = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMParkPointView$1 */
    class C44121 implements OnTapListener {
        C44121() {
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
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_PARK_STOP, NaviStatConstants.NAVI_PARK_STOP);
                    SearchParkPoi poi = RGParkPointModel.getInstance().getParkPoi();
                    if (poi != null) {
                        GeoPoint point = poi.mGuidePoint;
                        BNRoutePlaner.getInstance().setGuideSceneType(4);
                        RGSimpleGuideModel.getInstance();
                        RGSimpleGuideModel.mCalcRouteType = 4;
                        RGEngineControl.getInstance().setEndPtToCalcRoute(point);
                        break;
                    }
                    break;
            }
            return false;
        }
    }

    public RGMMParkPointView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            ViewStub stub = (ViewStub) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_park_layout_stub);
            if (stub != null) {
                stub.inflate();
            }
            this.mPickPointLayout = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_park_layout);
            this.mPickPointPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_park_panel);
            this.mParkInfoLL = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.ll_park_info);
            this.mPickPointName = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_park_name);
            this.mPickPointAddr = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_park_addr);
            this.mSetParkView = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_park_parkhere);
        }
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
    }

    public void updateDataByLastest() {
        updateData(null);
    }

    public void updateData(Bundle b) {
        LogUtil.m15791e(TAG, "updateData()");
        SearchParkPoi poi = RGParkPointModel.getInstance().getParkPoi();
        if (poi == null || poi.mName.length() <= 0 || this.mPickPointName == null || this.mPickPointAddr == null || this.mPickPointLayout == null) {
            hide();
            return;
        }
        CharSequence string;
        this.mPickPointName.setText(poi.mName);
        TextView textView = this.mPickPointAddr;
        if (poi.mLeftCnt > 0) {
            string = JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_park_navi_tips_style1, new Object[]{Integer.valueOf(poi.mLeftCnt), Integer.valueOf(poi.mDistance)});
        } else {
            string = JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_park_navi_tips_style2, new Object[]{Integer.valueOf(poi.mDistance)});
        }
        textView.setText(string);
        LogUtil.m15791e("parkpoiinformation", "poi.mName = " + poi.mName + " || poi.mDistance = " + poi.mDistance + " || lat = " + poi.mViewPoint.getLatitudeE6() + "long = " + poi.mViewPoint.getLongitudeE6());
        MapStatus mapstatus = BNMapController.getInstance().getMapStatus();
        Bundle bLoc = CoordinateTransformUtil.LL2MC(((double) poi.mViewPoint.getLongitudeE6()) / 100000.0d, ((double) poi.mViewPoint.getLatitudeE6()) / 100000.0d);
        mapstatus._CenterPtX = bLoc.getInt("MCx");
        mapstatus._CenterPtY = bLoc.getInt("MCy");
        GeoPoint pointMc = new GeoPoint(mapstatus._CenterPtX, mapstatus._CenterPtY);
        mapstatus._Level = 18.0f;
        BNMapController.getInstance().setMapStatus(mapstatus, AnimationType.eAnimationAll);
        ItemizedOverlayUtil.getInstance().removeAllItems();
        OverlayItem overlayItem = ItemizedOverlayUtil.getInstance().getOverlayItem(pointMc, DrawableUtils.getDrawableFromView(this.mPickPointLayout));
        overlayItem.addClickRect(getLeftContentSizeBundle());
        overlayItem.addClickRect(getRightContentSizeBundle());
        ItemizedOverlayUtil.getInstance().addMapItem(overlayItem);
        ItemizedOverlayUtil.getInstance().show();
        ItemizedOverlayUtil.getInstance().refresh();
        ItemizedOverlayUtil.getInstance().setOnTapListener(new C44121());
    }

    private boolean getHasDetailInfo(SearchParkPoi poi) {
        if (poi == null) {
            return false;
        }
        if (poi.mLeftCnt > 0) {
            return true;
        }
        if (poi.mParkKind != SearchParkKindEnum.Search_ParkKind_Unknown) {
            return true;
        }
        if (StringUtils.isEmpty(poi.mOpenTime)) {
            return false;
        }
        return true;
    }

    public void show() {
        super.show();
    }

    public void hide() {
        super.hide();
        RGParkPointModel.getInstance().updateParkPoi(null);
        ItemizedOverlayUtil.getInstance().removeAllItems();
        ItemizedOverlayUtil.getInstance().hide();
        ItemizedOverlayUtil.getInstance().setOnTapListener(null);
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.mPickPointPanel != null) {
            this.mPickPointPanel.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_pickpoint_bg));
        }
        if (this.mPickPointName != null) {
            this.mPickPointName.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
        }
        if (this.mPickPointAddr != null) {
            this.mPickPointAddr.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_a));
        }
        if (this.mSetParkView != null) {
            this.mSetParkView.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_e));
            this.mSetParkView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_pickpoint_btn_right));
        }
    }

    private int getLeftWidth() {
        if (this.mParkInfoLL == null) {
            return 0;
        }
        return this.mParkInfoLL.getMeasuredWidth();
    }

    private int getLeftHeight() {
        if (this.mParkInfoLL == null) {
            return 0;
        }
        return this.mParkInfoLL.getMeasuredHeight();
    }

    private int getRightWidth() {
        if (this.mSetParkView == null) {
            return 0;
        }
        return this.mSetParkView.getMeasuredWidth();
    }

    private int getRightHeight() {
        if (this.mSetParkView == null) {
            return 0;
        }
        return this.mSetParkView.getMeasuredHeight();
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
}
