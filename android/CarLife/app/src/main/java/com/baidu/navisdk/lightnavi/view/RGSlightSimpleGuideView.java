package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.lightnavi.model.BNIPOSimpleGuide;
import com.baidu.navisdk.lightnavi.utils.LightNaviCalculateUtils;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGSlightSimpleGuideView extends RGSlightBaseView {
    private TextView mArriveTime;
    private TextView mArriveTimeLock;
    private ImageView mIVNextTurn;
    private TextView mOverSpeed;
    private BNIPOSimpleGuide mSimpleGuide = new BNIPOSimpleGuide();
    private SimpleGuideMassageUpdateBean mSimpleGuideMassageUpdateBean;
    private TextView mTVNextRoadDis;
    private TextView mTVNextRoadName;
    private TextView mTotalDis;
    private TextView mTotalDisLock;

    public class SimpleGuideMassageUpdateBean {
        public int isStright = 0;
        public int mNextRoadDis = 0;
        public String mNextRoadName = "";
        public String mTurnPng = "";

        public boolean isEqaul(String nextRoadName, String turnPng, int isStright, int nextRoadDis) {
            if (RGSlightSimpleGuideView.this.mSimpleGuideMassageUpdateBean.mNextRoadName.equals(nextRoadName) && RGSlightSimpleGuideView.this.mSimpleGuideMassageUpdateBean.mTurnPng.equals(turnPng) && RGSlightSimpleGuideView.this.mSimpleGuideMassageUpdateBean.isStright == isStright && RGSlightSimpleGuideView.this.mSimpleGuideMassageUpdateBean.mNextRoadDis == nextRoadDis) {
                return true;
            }
            return false;
        }
    }

    public RGSlightSimpleGuideView(Context c, ViewGroup p) {
        super(c, p);
        initView();
        initListener();
    }

    public void initView() {
        this.mTotalDis = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_total_dist);
        this.mArriveTime = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_arrive_time);
        this.mTVNextRoadDis = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_next_dis);
        this.mTVNextRoadName = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_next_road_name);
        this.mOverSpeed = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_overspeed);
        this.mIVNextTurn = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_next_turn);
        this.mTotalDisLock = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_total_dist_lock);
        this.mArriveTimeLock = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_arrive_time_lock);
    }

    public void initListener() {
    }

    public void showBrightRemainTimeAndDis(int dis, int time) {
        this.mTotalDis.setText(LightNaviCalculateUtils.calculateTotalRemainDistString(dis));
        this.mArriveTime.setText(LightNaviCalculateUtils.calculateTotalRemainTimeString(time));
    }

    public void showRemainTimeAndDis(int dis, int time) {
        this.mTotalDis.setText(LightNaviCalculateUtils.calculateTotalRemainDistString(dis));
        this.mArriveTime.setText(LightNaviCalculateUtils.calculateTotalRemainTimeString(time));
        this.mTotalDisLock.setText(LightNaviCalculateUtils.calculateTotalRemainDistString(dis));
        this.mArriveTimeLock.setText(LightNaviCalculateUtils.calculateTotalRemainTimeString(time));
    }

    public void showOverSpeed(boolean flag) {
        if (this.mOverSpeed == null) {
            return;
        }
        if (flag) {
            this.mOverSpeed.setVisibility(0);
        } else {
            this.mOverSpeed.setVisibility(8);
        }
    }

    public void onUpdateSpeed(boolean isShow, Message msg) {
        if (isShow) {
            LogUtil.m15791e("wangyang", "onUpdateSpeed show");
            Bundle bundle = msg.obj;
            if (bundle.containsKey("description") && BNavigator.getInstance().getLocDataCache() != null) {
                float currentSpeed = BNavigator.getInstance().getLocDataCache().speed;
                int cameraSpeed = msg.arg2;
                String guideStr = null;
                if (bundle != null) {
                    guideStr = bundle.getString("description");
                }
                LogUtil.m15791e("wangyang", "onUpdateSpeed=" + guideStr + " cameraSpeed=" + cameraSpeed + " currentSpeed=" + currentSpeed);
                if (3600.0f * currentSpeed > ((float) cameraSpeed) && this.mOverSpeed != null && guideStr != null) {
                    this.mOverSpeed.setText(guideStr);
                    this.mOverSpeed.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mOverSpeed != null) {
            this.mOverSpeed.setVisibility(8);
        }
        LogUtil.m15791e("wangyang", "onUpdateSpeed hide ");
    }

    public void onUpdateSimpleGuide(Message msg, boolean isYawing) {
        LogUtil.m15791e("wangyang", "onUpdateSimpleGuide");
        if (!isYawing) {
            Bundle bundle = msg.obj;
            if (bundle != null) {
                String nextRoadName = bundle.getString("road_name");
                if (nextRoadName != null && !TextUtils.isEmpty(nextRoadName)) {
                    String turnPng = bundle.getString("icon_name");
                    int nextRoadDis = bundle.getInt(SimpleGuideInfo.RemainDist);
                    int isStright = bundle.getInt("straightIcon");
                    if (this.mSimpleGuideMassageUpdateBean == null) {
                        this.mSimpleGuideMassageUpdateBean = new SimpleGuideMassageUpdateBean();
                    }
                    if (!this.mSimpleGuideMassageUpdateBean.isEqaul(nextRoadName, turnPng, isStright, nextRoadDis)) {
                        this.mSimpleGuideMassageUpdateBean.mNextRoadName = nextRoadName;
                        this.mSimpleGuideMassageUpdateBean.mTurnPng = turnPng;
                        this.mSimpleGuideMassageUpdateBean.isStright = isStright;
                        this.mSimpleGuideMassageUpdateBean.mNextRoadDis = nextRoadDis;
                        if (!(this.mTVNextRoadName == null || TextUtils.isEmpty(nextRoadName) || TextUtils.isEmpty(turnPng))) {
                            if (turnPng.equals("turn_dest.png")) {
                                this.mTVNextRoadName.setText("到达" + nextRoadName + " ");
                            } else if (isStright == 1) {
                                this.mTVNextRoadName.setText("沿" + nextRoadName + " ");
                            } else {
                                this.mTVNextRoadName.setText("进入" + nextRoadName + " ");
                            }
                        }
                        if (turnPng != null && turnPng.length() > 0) {
                            int resId = this.mSimpleGuide.getResIdByIconName(turnPng);
                            if (resId > 0 && this.mIVNextTurn != null) {
                                this.mIVNextTurn.setImageDrawable(JarUtils.getResources().getDrawable(resId));
                            }
                        }
                        if (this.mTVNextRoadDis == null) {
                            return;
                        }
                        if (nextRoadDis < 10) {
                            this.mTVNextRoadDis.setText("现在");
                            return;
                        }
                        this.mTVNextRoadDis.setText(LightNaviCalculateUtils.calculateTotalRemainDistString(nextRoadDis) + "后");
                    }
                }
            }
        }
    }
}
