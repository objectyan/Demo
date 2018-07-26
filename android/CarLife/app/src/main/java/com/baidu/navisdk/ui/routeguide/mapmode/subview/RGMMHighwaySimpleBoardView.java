package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMHighwaySimpleBoardView extends BNBaseView {
    private static final String TAG = "RGMMHighwaySimpleBoardView";
    private View mRootView = null;
    private ImageView mServiceAreaBottomIcon = null;
    private TextView mServiceAreaBottomRemainDist = null;
    private TextView mServiceAreaBottomUnit = null;
    private View mServiceAreaBottomView = null;
    private TextView mServiceAreaExitCode = null;
    private LinearLayout mServiceAreaExitLayout = null;
    private TextView mServiceAreaExitName = null;
    private TextView mServiceAreaExitOrEnter = null;
    private View mServiceAreaExitSplitLine = null;
    private ImageView mServiceAreaTopIcon = null;
    private TextView mServiceAreaTopName = null;
    private TextView mServiceAreaTopRemainDist = null;
    private TextView mServiceAreaTopUnit = null;
    private View mServiceAreaTopView = null;
    private ViewGroup mViewContainer = null;

    public RGMMHighwaySimpleBoardView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
    }

    private void initViews() {
        this.mRootView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_hightway_new_service, null);
        if (this.mRootView == null) {
            LogUtil.m15791e(TAG, "initViews mRootView is null");
            return;
        }
        this.mServiceAreaTopView = this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_top);
        this.mServiceAreaTopIcon = (ImageView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_top_icon);
        this.mServiceAreaTopName = (TextView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_top_name);
        this.mServiceAreaTopRemainDist = (TextView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_top_remain_dist);
        this.mServiceAreaTopUnit = (TextView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_top_unit);
        this.mServiceAreaBottomView = this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_bottom);
        this.mServiceAreaBottomIcon = (ImageView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_bottom_icon);
        this.mServiceAreaBottomRemainDist = (TextView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_bottom_remain_dist);
        this.mServiceAreaBottomUnit = (TextView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_bottom_unit);
        this.mServiceAreaExitLayout = (LinearLayout) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_exit_code_ly);
        this.mServiceAreaExitOrEnter = (TextView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_exit_or_enter);
        this.mServiceAreaExitCode = (TextView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_exit_code);
        this.mServiceAreaExitSplitLine = this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_split_line);
        this.mServiceAreaExitName = (TextView) this.mRootView.findViewById(C4048R.id.bnavi_rg_hw_service_panel_exit_name);
        updateDataByLastest();
    }

    public void updateData(Bundle b) {
        updateServiceView();
    }

    public void updateDataByLastest() {
        updateData(null);
    }

    public void updateServiceView() {
        int[] canShowType = RGHighwayModel.getInstance().getSimpleBoardShowType();
        if (canShowType != null && canShowType.length != 0) {
            int dist;
            StringBuffer sb;
            String unit;
            if (this.mRootView != null) {
                this.mRootView.setVisibility(0);
            }
            if (canShowType.length > 0) {
                if (this.mServiceAreaTopView != null) {
                    this.mServiceAreaTopView.setVisibility(0);
                    if (canShowType[0] == 2) {
                        this.mServiceAreaTopView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_hw_bg_blue_top));
                    } else {
                        this.mServiceAreaTopView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_hw_bg_green_top));
                    }
                }
                if (canShowType[0] == 4 || canShowType[0] == 0 || canShowType[0] == 5) {
                    if (!(this.mServiceAreaExitLayout == null || this.mServiceAreaExitCode == null || this.mServiceAreaExitOrEnter == null || this.mServiceAreaExitSplitLine == null)) {
                        this.mServiceAreaExitLayout.setVisibility(0);
                        if (canShowType[0] == 4) {
                            this.mServiceAreaExitOrEnter.setText("出口");
                            if (TextUtils.isEmpty(RGHighwayModel.getInstance().getExitCode())) {
                                this.mServiceAreaExitCode.setVisibility(8);
                                this.mServiceAreaExitSplitLine.setVisibility(8);
                            } else {
                                this.mServiceAreaExitCode.setText(RGHighwayModel.getInstance().getExitCode());
                                this.mServiceAreaExitCode.setVisibility(0);
                                this.mServiceAreaExitSplitLine.setVisibility(0);
                            }
                        } else if (canShowType[0] == 5) {
                            this.mServiceAreaExitOrEnter.setText("出口");
                            if (TextUtils.isEmpty(RGHighwayModel.getInstance().getExitFastwayId())) {
                                this.mServiceAreaExitCode.setVisibility(8);
                                this.mServiceAreaExitSplitLine.setVisibility(8);
                            } else {
                                this.mServiceAreaExitCode.setText(RGHighwayModel.getInstance().getExitFastwayId());
                                this.mServiceAreaExitCode.setVisibility(0);
                                this.mServiceAreaExitSplitLine.setVisibility(0);
                            }
                        } else {
                            this.mServiceAreaExitOrEnter.setText("入口");
                            this.mServiceAreaExitSplitLine.setVisibility(8);
                            this.mServiceAreaExitCode.setVisibility(8);
                        }
                    }
                    if (this.mServiceAreaExitName != null) {
                        this.mServiceAreaExitName.setText(subExitName(ScreenUtil.getInstance().dip2px(NaviFragmentManager.TYPE_CAR_DRV_SETTING), RGHighwayModel.getInstance().getTypeName(canShowType[0])));
                        this.mServiceAreaExitName.setVisibility(0);
                    }
                    if (!(this.mServiceAreaTopRemainDist == null || this.mServiceAreaTopUnit == null)) {
                        this.mServiceAreaTopRemainDist.setVisibility(8);
                        this.mServiceAreaTopUnit.setVisibility(8);
                    }
                    if (this.mServiceAreaTopName != null) {
                        this.mServiceAreaTopName.setVisibility(8);
                    }
                    if (this.mServiceAreaTopIcon != null) {
                        this.mServiceAreaTopIcon.setVisibility(8);
                    }
                } else {
                    if (this.mServiceAreaExitLayout != null) {
                        this.mServiceAreaExitLayout.setVisibility(8);
                    }
                    if (this.mServiceAreaExitName != null) {
                        this.mServiceAreaExitName.setVisibility(8);
                    }
                    if (!(this.mServiceAreaTopRemainDist == null || this.mServiceAreaTopUnit == null)) {
                        dist = RGHighwayModel.getInstance().getTypeRemainDist(canShowType[0]);
                        sb = new StringBuffer();
                        unit = StringUtils.formatDistance(dist, sb);
                        this.mServiceAreaTopRemainDist.setText(sb.toString());
                        this.mServiceAreaTopUnit.setText(unit);
                        this.mServiceAreaTopRemainDist.setVisibility(0);
                        this.mServiceAreaTopUnit.setVisibility(0);
                    }
                    if (this.mServiceAreaTopName != null) {
                        this.mServiceAreaTopName.setText(RGHighwayModel.getInstance().getTypeName(canShowType[0]));
                        this.mServiceAreaTopName.setVisibility(0);
                    }
                    if (this.mServiceAreaTopIcon != null) {
                        this.mServiceAreaTopIcon.setImageDrawable(RGHighwayModel.getInstance().getTypeIcon(canShowType[0]));
                        this.mServiceAreaTopIcon.setVisibility(0);
                    }
                }
            }
            if (canShowType.length > 1) {
                if (this.mServiceAreaBottomView != null) {
                    this.mServiceAreaBottomView.setVisibility(0);
                    if (canShowType[1] == 2 || canShowType[1] == 3) {
                        this.mServiceAreaBottomView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_hw_bg_blue_bottom));
                    } else {
                        this.mServiceAreaBottomView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_hw_bg_green_bottom));
                    }
                }
                if (!(this.mServiceAreaBottomRemainDist == null || this.mServiceAreaBottomUnit == null)) {
                    dist = RGHighwayModel.getInstance().getTypeRemainDist(canShowType[1]);
                    sb = new StringBuffer();
                    unit = StringUtils.formatDistance(dist, sb);
                    this.mServiceAreaBottomRemainDist.setText(sb.toString());
                    this.mServiceAreaBottomUnit.setText(unit);
                }
                if (this.mServiceAreaBottomIcon != null) {
                    this.mServiceAreaBottomIcon.setImageDrawable(RGHighwayModel.getInstance().getTypeIcon(canShowType[1]));
                }
            } else if (this.mServiceAreaBottomView != null) {
                this.mServiceAreaBottomView.setVisibility(8);
            }
        } else if (this.mRootView != null) {
            this.mRootView.setVisibility(8);
        }
    }

    public void setViewMarginRight(boolean isRoadBarMode) {
        if (this.mViewContainer == null || this.mRootView == null) {
            LogUtil.m15791e(TAG, "");
            return;
        }
        int marginRight;
        LayoutParams serviceLp = new LayoutParams(-2, -2);
        serviceLp.addRule(11);
        int margin = ScreenUtil.getInstance().dip2px(4.7f);
        if (isRoadBarMode) {
            marginRight = JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_road_condition_bar_width) + ScreenUtil.getInstance().dip2px(2.0f);
        } else {
            marginRight = margin;
        }
        serviceLp.setMargins(margin, margin, marginRight, margin);
        this.mRootView.setLayoutParams(serviceLp);
        this.mViewContainer.invalidate();
    }

    private String subExitName(int viewWidth, String exitName) {
        if (this.mServiceAreaExitName == null || UIUtils.isTextFullDisplay(this.mServiceAreaExitName, viewWidth, exitName, 1)) {
            return exitName;
        }
        int lastSpace = exitName.lastIndexOf(" ");
        return lastSpace >= 0 ? subExitName(viewWidth, exitName.substring(0, lastSpace)) : exitName;
    }

    private void addToContainner() {
        this.mViewContainer = RGViewController.getInstance().getViewContails(C4048R.id.bnav_rg_highway_service_container);
        if (this.mViewContainer == null) {
            LogUtil.m15791e(TAG, "");
            return;
        }
        this.mViewContainer.removeAllViews();
        if (this.mRootView != null) {
            ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.mRootView);
            }
            if (isVisibility()) {
                int marginRight;
                boolean show;
                if (BNavConfig.pRGLocateMode == 2) {
                    show = false;
                } else {
                    show = true;
                }
                LayoutParams serviceLp = new LayoutParams(-2, -2);
                serviceLp.addRule(11);
                int margin = ScreenUtil.getInstance().dip2px(4.7f);
                if (BNSettingManager.getIsShowMapSwitch() == 1 && show) {
                    marginRight = ScreenUtil.getInstance().dip2px(30.0f);
                } else {
                    marginRight = margin;
                }
                serviceLp.setMargins(margin, margin, marginRight, margin);
                this.mViewContainer.addView(this.mRootView, serviceLp);
                this.mViewContainer.setVisibility(0);
                return;
            }
            this.mViewContainer.setVisibility(8);
        }
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        addToContainner();
    }

    public void show() {
        super.show();
        LogUtil.m15791e(TAG, "show");
        if (this.mViewContainer == null || this.mViewContainer.getChildCount() == 0) {
            addToContainner();
        }
        if (this.mViewContainer != null) {
            this.mViewContainer.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        LogUtil.m15791e(TAG, "hide");
        if (this.mViewContainer != null) {
            this.mViewContainer.setVisibility(8);
        }
    }
}
