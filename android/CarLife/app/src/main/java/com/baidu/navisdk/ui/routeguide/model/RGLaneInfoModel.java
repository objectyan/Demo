package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.carlife.util.C2175f;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGLaneLineController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RGLaneInfoModel {
    public static final int AFTER_SOURCE = 1;
    private static final int BUS_IMAGE_ID = 1711407239;
    public static final int CURRENT_MAX_LINE = 9;
    public static final int ENLARGE_TYPE = 100;
    public static final int LANE_SOURCE = 2;
    public static final int MAX_LINE_NUMBER = 16;
    public static final int NORMAL_LANE = 101;
    public static final int PORTRAIT_ENLARGE = 200;
    public static final String TAG = RGLaneInfoModel.class.getName();
    public static RGLaneInfoModel mInstance = new RGLaneInfoModel();
    public boolean isLaneShow = false;
    public boolean isShow = false;
    public int mID = 0;
    private HashMap<String, Integer> mImageMap = new HashMap();
    public ArrayList<Integer> mImalgeIdList = new ArrayList();
    public RGLineItem[] mLaneLineList = new RGLineItem[16];
    public int mLineNumber = 0;
    public int mRemainDist = 0;
    public int mStartDist = 0;
    public double mX = 0.0d;
    public double mY = 0.0d;

    public boolean isShowLaneLineView() {
        return this.isShow && this.isLaneShow;
    }

    private void initMap() {
        if (this.mImageMap.size() <= 0) {
            if (this.mImageMap == null) {
                this.mImageMap = new HashMap();
            }
            this.mImageMap.put("11000000", Integer.valueOf(C4048R.drawable.ic_lane_turn_left_90));
            this.mImageMap.put("10000000", Integer.valueOf(C4048R.drawable.ic_lane_turn_left_90_gray));
            this.mImageMap.put("00110000", Integer.valueOf(C4048R.drawable.ic_lane_turn_right_90));
            this.mImageMap.put("00100000", Integer.valueOf(C4048R.drawable.ic_lane_turn_right_90_gray));
            this.mImageMap.put("00001100", Integer.valueOf(C4048R.drawable.ic_lane_straight));
            this.mImageMap.put("00001000", Integer.valueOf(C4048R.drawable.ic_lane_straight_gray));
            this.mImageMap.put("00000011", Integer.valueOf(C4048R.drawable.ic_lane_turn_around_left));
            this.mImageMap.put("00000010", Integer.valueOf(C4048R.drawable.ic_lane_turn_around_left_gray));
            this.mImageMap.put("10001000", Integer.valueOf(C4048R.drawable.ic_lane_2cross_left_straight_gray));
            this.mImageMap.put("11001000", Integer.valueOf(C4048R.drawable.ic_lane_2cross_turn_left));
            this.mImageMap.put("10001100", Integer.valueOf(C4048R.drawable.ic_lane_2cross_left_straight));
            this.mImageMap.put("00101000", Integer.valueOf(C4048R.drawable.ic_lane_2cross_right_straight_gray));
            this.mImageMap.put("00111000", Integer.valueOf(C4048R.drawable.ic_lane_2cross_turn_right));
            this.mImageMap.put("00101100", Integer.valueOf(C4048R.drawable.ic_lane_2cross_right_straight));
            this.mImageMap.put("10101000", Integer.valueOf(C4048R.drawable.ic_lane_3cross_gray));
            this.mImageMap.put("11101000", Integer.valueOf(C4048R.drawable.ic_lane_3cross_turn_left));
            this.mImageMap.put("10111000", Integer.valueOf(C4048R.drawable.ic_lane_3cross_turn_right));
            this.mImageMap.put("10101100", Integer.valueOf(C4048R.drawable.ic_lane_3cross_straight));
            this.mImageMap.put("10000010", Integer.valueOf(C4048R.drawable.ic_lane_around_and_left_gray));
            this.mImageMap.put("11000010", Integer.valueOf(C4048R.drawable.ic_lane_left_and_around));
            this.mImageMap.put("10000011", Integer.valueOf(C4048R.drawable.ic_lane_around_and_left));
            this.mImageMap.put(C2175f.f6941a, Integer.valueOf(C4048R.drawable.ic_lane_left_and_right_gray));
            this.mImageMap.put("11100000", Integer.valueOf(C4048R.drawable.ic_lane_left_and_right));
            this.mImageMap.put("10110000", Integer.valueOf(C4048R.drawable.ic_lane_right_and_left));
            this.mImageMap.put("00100010", Integer.valueOf(C4048R.drawable.ic_lane_around_and_right_gray));
            this.mImageMap.put("00110010", Integer.valueOf(C4048R.drawable.ic_lane_right_and_around));
            this.mImageMap.put("00100011", Integer.valueOf(C4048R.drawable.ic_lane_around_and_right));
            this.mImageMap.put("00001010", Integer.valueOf(C4048R.drawable.ic_lane_around_and_straight_gray));
            this.mImageMap.put("00001110", Integer.valueOf(C4048R.drawable.ic_lane_straight_and_around));
            this.mImageMap.put("00001011", Integer.valueOf(C4048R.drawable.ic_lane_around_and_straight));
            this.mImageMap.put("10100010", Integer.valueOf(C4048R.drawable.ic_lane_around_left_right_gray));
            this.mImageMap.put("11100010", Integer.valueOf(C4048R.drawable.ic_lane_left_around_right));
            this.mImageMap.put("10110010", Integer.valueOf(C4048R.drawable.ic_lane_right_around_left));
            this.mImageMap.put("10100011", Integer.valueOf(C4048R.drawable.ic_lane_around_left_right));
            this.mImageMap.put("10001010", Integer.valueOf(C4048R.drawable.ic_lane_around_left_straight_gray));
            this.mImageMap.put("11001010", Integer.valueOf(C4048R.drawable.ic_lane_left_around_straight));
            this.mImageMap.put("10001110", Integer.valueOf(C4048R.drawable.ic_lane_straight_left_around));
            this.mImageMap.put("10001011", Integer.valueOf(C4048R.drawable.ic_lane_around_left_straight));
            this.mImageMap.put("00101010", Integer.valueOf(C4048R.drawable.ic_lane_around_right_straight_gray));
            this.mImageMap.put("00111010", Integer.valueOf(C4048R.drawable.ic_lane_right_around_straight));
            this.mImageMap.put("00101110", Integer.valueOf(C4048R.drawable.ic_lane_straight_right_around));
            this.mImageMap.put("00101011", Integer.valueOf(C4048R.drawable.ic_lane_around_right_straight));
            this.mImageMap.put("10101010", Integer.valueOf(C4048R.drawable.ic_lane_around_left_right_straight_gray));
            this.mImageMap.put("11101010", Integer.valueOf(C4048R.drawable.ic_lane_left_around_right_straight));
            this.mImageMap.put("10111010", Integer.valueOf(C4048R.drawable.ic_lane_right_around_left_straight));
            this.mImageMap.put("10101110", Integer.valueOf(C4048R.drawable.ic_lane_straight_around_left_right));
            this.mImageMap.put("10101011", Integer.valueOf(C4048R.drawable.ic_lane_around_left_right_straight));
        }
    }

    public String parseItem(RGLineItem item) {
        int i = 1;
        if (item == null) {
            return "0";
        }
        int i2;
        StringBuffer buf = new StringBuffer();
        buf.append(item.isLeft ? 1 : 0);
        if (item.isLeftBright) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        buf.append(i2);
        if (item.isRight) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        buf.append(i2);
        if (item.isRightBright) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        buf.append(i2);
        if (item.isFront) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        buf.append(i2);
        if (item.isFrontBright) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        buf.append(i2);
        if (item.isBack) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        buf.append(i2);
        if (!item.isBackBright) {
            i = 0;
        }
        buf.append(i);
        LogUtil.m15791e(TAG, "parseItemToLong long is " + buf.toString());
        return buf.toString();
    }

    public int getImageIDFromItem(RGLineItem item) {
        if (item.isBusLine) {
            return 1711407239;
        }
        return getImageID(parseItem(item), item.isBusLine);
    }

    private int getImageID(String itemID, boolean isBusLine) {
        int imageID = 0;
        if (this.mImageMap != null && this.mImageMap.containsKey(itemID)) {
            imageID = ((Integer) this.mImageMap.get(itemID)).intValue();
        }
        LogUtil.m15791e(TAG, "getImageID id is " + imageID);
        return imageID;
    }

    public void cloneData(RGLineItem[] data) {
        if (data != null && data.length > 0) {
            for (int i = 0; i < data.length; i++) {
                this.mLaneLineList[i] = data[i];
                LogUtil.m15791e(TAG, "cloneData is " + this.mLaneLineList[i].toString());
            }
        }
    }

    public void handleShowMessage() {
        LogUtil.m15791e(TAG, "handleShowMessage");
        initMap();
        this.isShow = true;
        if (this.isLaneShow) {
            if (this.mLineNumber > 9) {
                this.mLineNumber = 9;
            }
            this.mImalgeIdList.clear();
            for (int i = 0; i < this.mLineNumber; i++) {
                this.mImalgeIdList.add(Integer.valueOf(getImageIDFromItem(this.mLaneLineList[i])));
            }
            if (isNewLaneShow()) {
                RGLaneLineController.getInstance().mLastImalgeIdList.clear();
                Iterator it = this.mImalgeIdList.iterator();
                while (it.hasNext()) {
                    RGLaneLineController.getInstance().mLastImalgeIdList.add((Integer) it.next());
                }
                RGMapModeViewController.getInstance().updateLaneLineImage(this.mImalgeIdList);
                RGMapModeViewController.getInstance().updateEnlargeLaneLineImage(this.mImalgeIdList);
                RGMapModeViewController.getInstance().requestShowExpendView(7, true, 2);
                return;
            }
            LogUtil.m15791e(TAG, "update, not show");
            return;
        }
        LogUtil.m15791e(TAG, "handleShowMessage isLaneShow " + this.isLaneShow);
    }

    private boolean isNewLaneShow() {
        if (RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()) {
            return true;
        }
        ArrayList<Integer> mLastImalgeIdList = RGLaneLineController.getInstance().mLastImalgeIdList;
        if (this.mImalgeIdList == null || mLastImalgeIdList == null || this.mImalgeIdList.size() != mLastImalgeIdList.size()) {
            return true;
        }
        for (int i = 0; i < this.mImalgeIdList.size(); i++) {
            if (((Integer) this.mImalgeIdList.get(i)).intValue() != ((Integer) mLastImalgeIdList.get(i)).intValue()) {
                return true;
            }
        }
        return false;
    }

    public static RGLaneInfoModel getModel(boolean isShowMessage) {
        if (isShowMessage || mInstance == null) {
            mInstance = new RGLaneInfoModel();
        }
        return mInstance;
    }

    public String toString() {
        return String.format("[%d,%d,%d,%b]", new Object[]{Integer.valueOf(this.mLineNumber), Integer.valueOf(this.mStartDist), Integer.valueOf(this.mID), Boolean.valueOf(this.isLaneShow)});
    }
}
