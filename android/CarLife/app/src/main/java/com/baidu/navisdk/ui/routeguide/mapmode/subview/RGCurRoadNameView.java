package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGCurRoadNameView extends BNBaseView {
    private static String TAG = ModuleName.ROUTEGUIDE;
    private boolean isMove = false;
    private ViewGroup mCurRoadContainer;
    private RelativeLayout mCurRoadContanerBg;
    private TextView mCurRoadNameTv;

    public RGCurRoadNameView(Context c, ViewGroup p) {
        super(c, p);
        initView();
    }

    private void initView() {
        if (this.mRootViewGroup != null) {
            try {
                this.mCurRoadContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cur_road_name_container);
                if (this.mCurRoadContainer != null) {
                    if (this.mCurRoadContainer.getChildCount() > 0) {
                        this.mCurRoadContainer.removeAllViews();
                    }
                    this.mCurRoadContanerBg = (RelativeLayout) JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_cur_road_name, null);
                    if (this.mCurRoadContanerBg != null) {
                        LayoutParams lp = new LayoutParams(-2, ScreenUtil.getInstance().dip2px(32));
                        lp.addRule(12);
                        lp.addRule(14);
                        lp.bottomMargin = ScreenUtil.getInstance().dip2px(67);
                        this.mCurRoadContainer.addView(this.mCurRoadContanerBg, lp);
                        this.mCurRoadNameTv = (TextView) this.mCurRoadContanerBg.findViewById(C4048R.id.bnav_rg_road_name_tv);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateStyle(BNStyleManager.getDayStyle());
            updateRoadName(RGSimpleGuideModel.getInstance().getCurRoadName());
        }
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        initView();
    }

    public void show() {
        super.show();
        if (this.mCurRoadContanerBg != null) {
            this.mCurRoadContanerBg.setVisibility(0);
            updateRoadName(RGSimpleGuideModel.getInstance().getCurRoadName());
        }
    }

    public void hide() {
        super.hide();
        if (this.mCurRoadContanerBg != null) {
            this.mCurRoadContanerBg.setVisibility(8);
        }
    }

    private void setDayMode() {
        if (this.mCurRoadContanerBg != null && this.mCurRoadNameTv != null) {
            this.mCurRoadContanerBg.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_rg_route_name_bg));
            this.mCurRoadNameTv.setTextColor(Color.parseColor("#333333"));
        }
    }

    private void setNightMode() {
        if (this.mCurRoadContanerBg != null && this.mCurRoadNameTv != null) {
            this.mCurRoadContanerBg.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_rg_route_name_night_bg));
            this.mCurRoadNameTv.setTextColor(-1);
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (day) {
            setDayMode();
        } else {
            setNightMode();
        }
    }

    public void updateRoadName(String roadName) {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "updateRoadName --> " + roadName);
        if (this.mCurRoadContanerBg != null && this.mCurRoadNameTv != null && roadName != null && !roadName.equals(this.mCurRoadNameTv.getText().toString())) {
            if (StringUtils.isEmpty(roadName) || TrackDataShop.SPECIAL_ADDR_IN_TRACK.equals(roadName) || "当前道路".equals(roadName) || "无数据道路".equals(roadName)) {
                this.mCurRoadNameTv.setText("");
                this.mCurRoadContanerBg.setVisibility(8);
                return;
            }
            autoAdaptTextSize(16, roadName);
            this.mCurRoadNameTv.setText(roadName);
            this.mCurRoadContanerBg.setVisibility(0);
        }
    }

    private void autoAdaptTextSize(int textSize, String text) {
        if (this.mCurRoadNameTv != null) {
            this.mCurRoadNameTv.setTextSize(1, (float) textSize);
            if (!UIUtils.isTextFullDisplay(this.mCurRoadNameTv, JarUtils.getResources().getDimensionPixelSize(C4048R.dimen.nsdk_rg_cur_road_name_width), text)) {
                autoAdaptTextSize(textSize - 2, text);
            }
        }
    }

    public void moveRightView() {
        if (RGMapModeViewController.getInstance().getOrientation() == 2 && this.mCurRoadContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCurRoadContainer.getLayoutParams();
            layoutParams.width = ScreenUtil.getInstance().getHeightPixels() / 2;
            layoutParams.gravity = 5;
            this.mCurRoadContainer.setLayoutParams(layoutParams);
        }
    }

    public void resetViewPosition() {
        if (RGMapModeViewController.getInstance().getOrientation() == 2 && this.mCurRoadContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCurRoadContainer.getLayoutParams();
            layoutParams.width = ScreenUtil.getInstance().getGuidePanelWidth() * 3;
            layoutParams.gravity = 5;
            this.mCurRoadContainer.setLayoutParams(layoutParams);
        }
    }
}
