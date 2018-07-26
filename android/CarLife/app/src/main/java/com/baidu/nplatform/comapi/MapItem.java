package com.baidu.nplatform.comapi;

import java.io.Serializable;

public class MapItem implements Serializable {
    public static final String KEY_CLICK_TYPE = "eClickType";
    public static final String KEY_CUR_ROUTE_INDEX = "nCurRouteIdx";
    public static final String KEY_IS_MAP_ITEM = "navi";
    public static final String KEY_ITEM_ID = "in";
    public static final String KEY_ITEM_TYPE = "ty";
    public static final String KEY_LATITUDE = "fLatitude";
    public static final String KEY_LONGITUDE = "fLongitude";
    public static final String KEY_TITLE = "tx";
    public static final String KEY_UID = "ud";
    public static final int NE_Map_Item_Msg_Label = 0;
    public static final int NE_Map_Item_Msg_Route = 1;
    private static final long serialVersionUID = 1;
    public int mClickType = 1;
    public int mCurRouteIdx;
    public int mItemID;
    public int mItemType;
    public int mLatitude;
    public double mLatitudeMc;
    public int mLongitude;
    public double mLongitudeMc;
    public String mTitle;
    public String mUid;

    public String toString() {
        return "mItemID: " + this.mItemID + "\n mItemType: " + this.mItemType + "\n mUid: " + this.mUid + "\n mTitle: " + this.mTitle + "\n mLongitude: " + this.mLongitude + "\n mLatitude: " + this.mLatitude + "\n mCurRouteIdx: " + this.mCurRouteIdx + "\n mClickType: " + this.mClickType;
    }
}
