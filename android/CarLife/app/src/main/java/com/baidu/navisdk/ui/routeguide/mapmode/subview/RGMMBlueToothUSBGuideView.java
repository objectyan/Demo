package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMBlueToothUSBGuideView extends BNBaseView implements OnClickListener {
    public static final int PANEL_CONTENT_TYPE_BLUETOOTH = 1;
    public static final int PANEL_CONTENT_TYPE_USB = 2;
    private static final String TAG = RGMMBlueToothUSBGuideView.class.getSimpleName();
    public static int sPanelContentType = 0;
    private TextView mFixDiscriptionTV;
    private ViewGroup mGuideContainer;
    private ViewGroup mGuideInnerPanel;
    private ViewGroup mGuidePanel;
    private ViewGroup mGuideView;
    private TextView mProblemDiscriptionTV;
    private TextView mStillNoVolumDiscriptionTV;
    private LinearLayout mStillNoVolumLL;
    private BNCommonTitleBar mTitleBar = null;

    public RGMMBlueToothUSBGuideView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        initListener();
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            try {
                this.mGuidePanel = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bluetooth_usb_panel);
                this.mGuideContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bluetooth_usb_panel_container);
                if (this.mGuideContainer != null) {
                    this.mGuideContainer.removeAllViews();
                }
                this.mGuideView = (ViewGroup) JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_bluetooth_usb_guide, null);
                if (this.mGuideContainer != null && this.mGuideView != null) {
                    this.mGuideContainer.addView(this.mGuideView, new LayoutParams(-1, -1));
                    this.mTitleBar = (BNCommonTitleBar) this.mGuideView.findViewById(C4048R.id.title_bar);
                    if (this.mTitleBar != null) {
                        this.mTitleBar.setMiddleTextVisible(true);
                        this.mTitleBar.setMiddleTextSize(18.0f);
                        this.mTitleBar.setRightTextVisible(false);
                    }
                    this.mGuideInnerPanel = (ViewGroup) this.mGuideView.findViewById(C4048R.id.nav_view_bluetooth_usb_guide_panel);
                    this.mProblemDiscriptionTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bluetooth_usb_guide_problem_discription_tv);
                    this.mFixDiscriptionTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bluetooth_usb_guide_fix_discription_tv);
                    this.mStillNoVolumDiscriptionTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bluetooth_usb_guide_still_no_volum_discription_tv);
                    this.mStillNoVolumLL = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bluetooth_usb_guide_still_no_volum_ll);
                }
            } catch (Exception e) {
            }
        }
    }

    private void initListener() {
        if (this.mGuideInnerPanel != null) {
            this.mGuideInnerPanel.findViewById(C4048R.id.left_imageview).setOnClickListener(this);
        }
    }

    public void show() {
        super.show();
        updateContent();
        if (this.mGuideContainer != null) {
            this.mGuideContainer.setVisibility(0);
        }
        if (this.mGuidePanel != null) {
            this.mGuidePanel.setVisibility(0);
        }
        if (this.mGuideInnerPanel != null) {
            this.mGuideInnerPanel.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        if (this.mGuideContainer != null) {
            this.mGuideContainer.setVisibility(8);
        }
        if (this.mGuidePanel != null) {
            this.mGuidePanel.setVisibility(8);
        }
        if (this.mGuideInnerPanel != null) {
            this.mGuideInnerPanel.setVisibility(8);
        }
    }

    public void onClick(View v) {
        if (v != null) {
            try {
                switch (v.getId()) {
                    case C4048R.id.left_imageview /*1711865878*/:
                        RGViewController.getInstance().hideBlueToothUSBGuide();
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }

    private void updateContent() {
        if (this.mTitleBar != null && this.mProblemDiscriptionTV != null && this.mFixDiscriptionTV != null && this.mStillNoVolumDiscriptionTV != null) {
            if (sPanelContentType == 1) {
                this.mStillNoVolumLL.setVisibility(0);
                this.mStillNoVolumDiscriptionTV.setVisibility(0);
                this.mTitleBar.setMiddleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_bluetooth_guide));
                this.mProblemDiscriptionTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_bluetooth_guide_problem_discription));
                this.mFixDiscriptionTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_bluetooth_guide_fix_discription));
                this.mStillNoVolumDiscriptionTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_bluetooth_guide_still_no_volum_discription));
            } else if (sPanelContentType == 2) {
                this.mStillNoVolumLL.setVisibility(8);
                this.mStillNoVolumDiscriptionTV.setVisibility(8);
                this.mTitleBar.setMiddleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_usb_guide));
                this.mProblemDiscriptionTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_usb_guide_problem_discription));
                this.mFixDiscriptionTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_usb_guide_fix_discription));
            }
        }
    }
}
