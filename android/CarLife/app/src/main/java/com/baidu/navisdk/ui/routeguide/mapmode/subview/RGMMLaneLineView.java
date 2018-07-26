package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RGMMLaneLineView extends BNBaseView {
    public static final int SEPARATE_LINE_NUMBER = 9;
    private int containerId = C4048R.id.bnav_rg_lane_info_rr;
    private int layoutId = C4048R.layout.nsdk_layout_lane_line;
    private ImageView mLaneLine1 = null;
    private ImageView mLaneLine2 = null;
    private ImageView mLaneLine3 = null;
    private ImageView mLaneLine4 = null;
    private ImageView mLaneLine5 = null;
    private ImageView mLaneLine6 = null;
    private ImageView mLaneLine7 = null;
    private ImageView mLaneLine8 = null;
    private ImageView mLaneLine9 = null;
    private ViewGroup mLaneLineContainer = null;
    private ArrayList<ImageView> mLaneLineList = new ArrayList();
    private View mLaneLineView = null;
    private ImageView mSeparate0 = null;
    private ImageView mSeparate1 = null;
    private ImageView mSeparate2 = null;
    private ImageView mSeparate3 = null;
    private ImageView mSeparate4 = null;
    private ImageView mSeparate5 = null;
    private ImageView mSeparate6 = null;
    private ImageView mSeparate7 = null;
    private ImageView mSeparate8 = null;
    private ImageView mSeparate9 = null;
    private ArrayList<ImageView> mSeparateList = new ArrayList();

    public RGMMLaneLineView(Context c, ViewGroup p, OnRGSubViewListener lis, int type) {
        super(c, p, lis);
        initViews(type);
        updateStyle(BNStyleManager.getDayStyle());
    }

    public void orientationChanged(ViewGroup p, int orien, int type) {
        super.orientationChanged(p, orien);
        initViews(type);
        updateStyle(BNStyleManager.getDayStyle());
        if (RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
            LogUtil.m15791e(RGLaneInfoModel.TAG, "onOrientationChanged RGLaneInfoModel");
            RGMapModeViewController.getInstance().handleLaneEnlargeShow(RGMapModeViewController.getInstance().isEnlargeOrColladaShow());
            RGMapModeViewController.getInstance().updateLaneLineImage(RGLaneInfoModel.getModel(false).mImalgeIdList);
            RGMapModeViewController.getInstance().updateEnlargeLaneLineImage(RGLaneInfoModel.getModel(false).mImalgeIdList);
            RGMapModeViewController.getInstance().requestShowExpendView(7, true, 2);
        }
    }

    private void initViews(int type) {
        if (this.mRootViewGroup != null) {
            if (type == 100) {
                this.containerId = C4048R.id.enlarge_lane_container;
                this.layoutId = C4048R.layout.nsdk_layout_lane_line;
            } else {
                this.containerId = C4048R.id.bnav_rg_lane_info_rr;
                this.layoutId = C4048R.layout.nsdk_layout_lane_line;
            }
            this.mLaneLineContainer = (ViewGroup) this.mRootViewGroup.findViewById(this.containerId);
            if (this.mLaneLineContainer != null) {
                this.mLaneLineContainer.removeAllViews();
                this.mLaneLineView = JarUtils.inflate((Activity) this.mContext, this.layoutId, null);
                if (this.mLaneLineContainer != null && this.mLaneLineView != null) {
                    this.mLaneLineContainer.addView(this.mLaneLineView, new LayoutParams(-2, -1));
                    this.mSeparate0 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_0);
                    this.mSeparate1 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_1);
                    this.mSeparate2 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_2);
                    this.mSeparate3 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_3);
                    this.mSeparate4 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_4);
                    this.mSeparate5 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_5);
                    this.mSeparate6 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_6);
                    this.mSeparate7 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_7);
                    this.mSeparate8 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_8);
                    this.mSeparate9 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_bottom_9);
                    this.mSeparateList.clear();
                    this.mSeparateList.add(this.mSeparate0);
                    this.mSeparateList.add(this.mSeparate1);
                    this.mSeparateList.add(this.mSeparate2);
                    this.mSeparateList.add(this.mSeparate3);
                    this.mSeparateList.add(this.mSeparate4);
                    this.mSeparateList.add(this.mSeparate5);
                    this.mSeparateList.add(this.mSeparate6);
                    this.mSeparateList.add(this.mSeparate7);
                    this.mSeparateList.add(this.mSeparate8);
                    this.mSeparateList.add(this.mSeparate9);
                    this.mLaneLine1 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_1);
                    this.mLaneLine2 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_2);
                    this.mLaneLine3 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_3);
                    this.mLaneLine4 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_4);
                    this.mLaneLine5 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_5);
                    this.mLaneLine6 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_6);
                    this.mLaneLine7 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_7);
                    this.mLaneLine8 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_8);
                    this.mLaneLine9 = (ImageView) this.mLaneLineView.findViewById(C4048R.id.lane_line_9);
                    this.mLaneLineList.clear();
                    this.mLaneLineList.add(this.mLaneLine1);
                    this.mLaneLineList.add(this.mLaneLine2);
                    this.mLaneLineList.add(this.mLaneLine3);
                    this.mLaneLineList.add(this.mLaneLine4);
                    this.mLaneLineList.add(this.mLaneLine5);
                    this.mLaneLineList.add(this.mLaneLine6);
                    this.mLaneLineList.add(this.mLaneLine7);
                    this.mLaneLineList.add(this.mLaneLine8);
                    this.mLaneLineList.add(this.mLaneLine9);
                }
            }
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }

    public void updateImageView(ArrayList<Integer> list) {
        int i;
        int length = list.size();
        for (i = 0; i < length; i++) {
            ImageView view = (ImageView) this.mLaneLineList.get(i);
            view.setVisibility(0);
            if (view != null) {
                try {
                    view.setBackgroundDrawable(BNStyleManager.getDrawable(((Integer) list.get(i)).intValue()));
                } catch (Exception e) {
                    LogUtil.m15791e(RGLaneInfoModel.TAG, "e " + e.getCause());
                    view.setVisibility(8);
                }
            }
        }
        i = 0;
        while (true) {
            RGLaneInfoModel.getModel(false);
            if (i > 9) {
                break;
            }
            ((ImageView) this.mSeparateList.get(i)).setVisibility(0);
            i++;
        }
        LogUtil.m15791e(RGLaneInfoModel.TAG, this.layoutId + "lenght is " + length + "," + this.mLaneLineList.size() + "," + this.mSeparateList.size());
        if (9 - length > 0) {
            for (i = length; i < 9; i++) {
                view = (ImageView) this.mLaneLineList.get(i);
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        }
        if (length >= 1) {
            view = (ImageView) this.mSeparateList.get(0);
            if (view != null) {
                view.setVisibility(8);
            }
            for (i = length; i <= 9; i++) {
                view = (ImageView) this.mSeparateList.get(i);
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        }
    }

    public void show() {
        super.show();
        LogUtil.m15791e(RGLaneInfoModel.TAG, "RGMMLaneLineView show() ");
        if (this.mLaneLineContainer != null) {
            this.mLaneLineContainer.setVisibility(0);
        }
        if (this.mLaneLineView != null) {
            this.mLaneLineView.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        LogUtil.m15791e(RGLaneInfoModel.TAG, "RGMMLaneLineView hide() ");
        if (this.mLaneLineContainer != null) {
            this.mLaneLineContainer.setVisibility(8);
        }
        if (this.mLaneLineView != null) {
            this.mLaneLineView.setVisibility(8);
        }
    }

    public int getVisibility() {
        if (this.mLaneLineContainer != null) {
            return this.mLaneLineContainer.getVisibility();
        }
        return 8;
    }
}
