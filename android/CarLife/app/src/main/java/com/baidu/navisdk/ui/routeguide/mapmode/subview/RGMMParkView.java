package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class RGMMParkView extends BNBaseView {
    private static String TAG = RGMMParkView.class.getName();
    private View bgView;
    private TextView cancelBtn;
    private View dividerView;
    private TextView infoTv;
    private Handler mHandler = null;
    private ViewGroup mParkContainer = null;
    private SearchParkPoi nearPoi = null;
    private TextView stopBtn;
    private View view;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMParkView$1 */
    class C44131 implements OnClickListener {
        C44131() {
        }

        public void onClick(View v) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_PARK_STOP, NaviStatConstants.NAVI_PARK_STOP);
            BNavigator.getInstance().setmCanParkShow(false);
            GeoPoint point = RGMMParkView.this.nearPoi.mGuidePoint;
            BNRoutePlaner.getInstance().setGuideSceneType(4);
            RGSimpleGuideModel.getInstance();
            RGSimpleGuideModel.mCalcRouteType = 4;
            RGEngineControl.getInstance().setEndPtToCalcRoute(point);
            LogUtil.m15791e("asrpark", "stopBtn onClick");
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMParkView$2 */
    class C44142 implements OnClickListener {
        C44142() {
        }

        public void onClick(View v) {
            BNavigator.getInstance().setmCanParkShow(false);
            RGViewController.getInstance().requestShowExpendView(2, false);
            LogUtil.m15791e("asrpark", "cancelBtn onClick");
        }
    }

    public RGMMParkView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
    }

    private void initViews() {
        LogUtil.m15791e(TAG, "initViews()");
        if (this.mRootViewGroup != null) {
            this.mParkContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_park_container);
            if (this.mParkContainer != null) {
                this.nearPoi = getNearestParkPoi();
                if (this.nearPoi != null && BNaviModuleManager.getActivity() != null && this.view == null) {
                    this.mParkContainer.removeAllViewsInLayout();
                    this.view = JarUtils.inflate(BNaviModuleManager.getActivity(), C4048R.layout.nsdk_layout_rg_mapmode_park_view, null);
                    this.mParkContainer.addView(this.view, new LayoutParams(-1, -1));
                    this.bgView = this.view.findViewById(C4048R.id.ll_park_item);
                    this.dividerView = this.view.findViewById(C4048R.id.bnav_rg_common_divider_park);
                    this.infoTv = (TextView) this.view.findViewById(C4048R.id.tv_park_info);
                    String showText = "";
                    if (this.nearPoi.mLeftCnt > 0) {
                        showText = String.format("%1$d个空车位，距离终点%2$d米", new Object[]{Integer.valueOf(this.nearPoi.mLeftCnt), Integer.valueOf(this.nearPoi.mDistance)});
                    } else {
                        showText = String.format("停车场距终点%1$d米", new Object[]{Integer.valueOf(this.nearPoi.mDistance)});
                    }
                    this.infoTv.setText(showText);
                    this.stopBtn = (TextView) this.view.findViewById(C4048R.id.tv_park_btn);
                    this.stopBtn.setOnClickListener(new C44131());
                    this.cancelBtn = (TextView) this.view.findViewById(C4048R.id.tv_park_cannel);
                    this.cancelBtn.setOnClickListener(new C44142());
                }
            }
        }
    }

    private SearchParkPoi getNearestParkPoi() {
        ArrayList<SearchParkPoi> list = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchParkPoi();
        if (list == null || list.size() == 0) {
            return null;
        }
        int nearDistance = 10000;
        int nearItemIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            SearchParkPoi poi = (SearchParkPoi) list.get(i);
            if (poi != null && poi.mDistance < nearDistance) {
                nearDistance = poi.mDistance;
                nearItemIndex = i;
            }
        }
        if (nearItemIndex < list.size()) {
            return (SearchParkPoi) list.get(nearItemIndex);
        }
        return null;
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.bgView != null) {
            this.bgView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.dividerView != null) {
            this.dividerView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_b));
        }
        if (this.infoTv != null) {
            this.infoTv.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
        }
        if (this.stopBtn != null) {
            this.stopBtn.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_e));
            this.stopBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_button_selector));
        }
        if (this.cancelBtn != null) {
            this.cancelBtn.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
            this.cancelBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_lineframe_button_selector));
        }
    }

    public void show() {
        super.show();
        LogUtil.m15791e(TAG, "onShow()");
        if (!(this.mParkContainer == null || this.view == null)) {
            this.mParkContainer.setVisibility(0);
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
    }

    public void hide() {
        super.hide();
        LogUtil.m15791e(TAG, "onHide()");
        if (this.mParkContainer != null && this.view != null) {
            this.mParkContainer.setVisibility(8);
            this.view.setVisibility(8);
        }
    }
}
