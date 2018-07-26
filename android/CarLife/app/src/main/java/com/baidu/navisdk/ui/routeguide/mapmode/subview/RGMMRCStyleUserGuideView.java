package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseOrientationView;
import com.baidu.navisdk.util.common.ScreenUtil;

public class RGMMRCStyleUserGuideView extends BNBaseOrientationView implements OnClickListener {
    private boolean isMiniMapSelected = true;
    private View mConfirmTv = null;
    private TextView mMiniMapTv = null;
    private TextView mRoadBarTv = null;

    public RGMMRCStyleUserGuideView(Context c, ViewGroup p) {
        super(c, p);
    }

    public RGMMRCStyleUserGuideView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
    }

    public void initViewById() {
        this.mMiniMapTv = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_rc_style_guide_minimap_tv);
        this.mRoadBarTv = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_rc_style_guide_road_bar_tv);
        this.mConfirmTv = this.mRootView.findViewById(C4048R.id.bnav_rg_rc_style_guide_confirm_tv);
    }

    public void initListener() {
        this.mMiniMapTv.setOnClickListener(this);
        this.mRoadBarTv.setOnClickListener(this);
        this.mConfirmTv.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
    }

    public int getPortraitLayoutId() {
        return C4048R.layout.nsdk_layout_rg_mapmode_rc_style_guide;
    }

    public int getLandscapeLayoutId() {
        return C4048R.layout.nsdk_layout_rg_mapmode_rc_style_guide;
    }

    public int getContainerViewId() {
        return C4048R.id.navi_rg_first_enter_guide;
    }

    public LayoutParams generalLayoutParams() {
        if (this.mCurOrientation == 1) {
            this.mRootView.setPadding(0, ScreenUtil.getInstance().dip2px(130), 0, ScreenUtil.getInstance().dip2px(80));
        } else {
            this.mRootView.setPadding(0, 0, 0, ScreenUtil.getInstance().dip2px(20));
        }
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    public void hide() {
        if (isVisibility()) {
            RGViewController.getInstance().updateToolBoxItem(6);
        }
        super.hide();
        if (this.isMiniMapSelected) {
            BNSettingManager.setIsShowMapSwitch(0);
        } else {
            BNSettingManager.setIsShowMapSwitch(1);
        }
        RGViewController.getInstance().showAssistMapSwitch();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C4048R.id.bnav_rg_rc_style_guide_minimap_tv /*1711866911*/:
                this.isMiniMapSelected = true;
                this.mMiniMapTv.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_rc_style_guide_checkbox_selected), null, null, null);
                this.mRoadBarTv.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_rc_style_guide_checkbox_normal), null, null, null);
                BNSettingManager.setIsShowMapSwitch(0);
                return;
            case C4048R.id.bnav_rg_rc_style_guide_road_bar_tv /*1711866912*/:
                this.isMiniMapSelected = false;
                this.mMiniMapTv.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_rc_style_guide_checkbox_normal), null, null, null);
                this.mRoadBarTv.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_rc_style_guide_checkbox_selected), null, null, null);
                BNSettingManager.setIsShowMapSwitch(1);
                return;
            case C4048R.id.bnav_rg_rc_style_guide_confirm_tv /*1711866913*/:
                hide();
                return;
            default:
                return;
        }
    }

    public void updateDataByLast() {
    }
}
