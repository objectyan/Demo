package com.baidu.navisdk.module.routereport;

import android.os.Bundle;
import android.util.SparseIntArray;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BNRouteReportModel {
    private static final int SUBTYPE_CAR_FORBIDDEN = 112;
    private static final int SUBTYPE_CONJUNCTION = 142;
    private static final int SUBTYPE_CONSTRUCTION = 131;
    private static final int SUBTYPE_DEST_CAN_NOT_FIND = 111;
    private static final int SUBTYPE_DETOUR = 141;
    private static final int SUBTYPE_DIFFICULT_ROAD = 143;
    private static final int SUBTYPE_ROAD_NOT_EXIST = 134;
    private static final int SUBTYPE_SINGLE_DIRECTION = 132;
    private static final int SUBTYPE_TURNAROUND_FORBIDDEN = 133;
    private static final int SUBTYPE_VOICE_TOO_LATE = 121;
    private static final int SUBTYPE_VOICE_WRONG = 122;
    private static final String TAG = BNRouteReportModel.class.getSimpleName();
    public static final int TYPE_DEST_PROBLEM = 11;
    public static final int TYPE_ROUTE_COMPLAIN = 14;
    public static final int TYPE_ROUTE_ERROR = 13;
    public static final int TYPE_VOICE_PROBLEM = 12;
    private ArrayList<RouteReportItem> afterNaviItemsList;
    public ArrayList<RouteReportItem> afterNaviItemsListDefault;
    private ArrayList<RouteReportItem> beforeNaviItemsList;
    public ArrayList<RouteReportItem> beforeNaviItemsListDefault;
    private CurrentRouteReportModel currentRouteReportModel;
    private Bundle mAddrResult;
    private RouteReportItem mCurrentFlevelItem;
    private SparseIntArray mResIdMap;
    private String uploadingImgFilePath;
    private String uploadingVoiceFilePath;

    public class CurrentRouteReportModel {
        public String content;
        public boolean isIntentBeforeNavi;
        public String parentType;
        public String photoPicPath;
        public String point;
        public String roadName;
        public String subType;
        public String userPoint;
        public int voiceLength;
        public String voicePath;
    }

    private static class LazyLoader {
        private static BNRouteReportModel instance = new BNRouteReportModel();

        private LazyLoader() {
        }
    }

    public class RouteReportItem {
        public String mIconUrl = null;
        public boolean mIsSubType = false;
        public String mTitle = null;
        public int mType = -1;
        public ArrayList<RouteReportItem> subItemsList = null;

        public RouteReportItem(boolean mIsSubType, String mTitle, int mType) {
            this.mIsSubType = mIsSubType;
            this.mTitle = mTitle;
            this.mType = mType;
        }

        public void addSubItem(RouteReportItem subItem) {
            if (subItem != null) {
                if (this.subItemsList == null) {
                    this.subItemsList = new ArrayList();
                }
                this.subItemsList.add(subItem);
            }
        }

        public String toString() {
            int i;
            StringBuilder append = new StringBuilder().append("title: ").append(this.mTitle).append(", type: ").append(this.mType).append(", isSubType: ").append(this.mIsSubType).append(", subItemsSize: ");
            if (this.subItemsList == null) {
                i = 0;
            } else {
                i = this.subItemsList.size();
            }
            return append.append(i).append(", iconUrl: ").append(this.mIconUrl).toString();
        }
    }

    private BNRouteReportModel() {
        this.beforeNaviItemsList = null;
        this.afterNaviItemsList = null;
        this.beforeNaviItemsListDefault = null;
        this.afterNaviItemsListDefault = null;
        this.mResIdMap = null;
        this.mCurrentFlevelItem = null;
        this.currentRouteReportModel = new CurrentRouteReportModel();
        this.mAddrResult = null;
        this.uploadingVoiceFilePath = null;
        this.uploadingImgFilePath = null;
    }

    public static BNRouteReportModel getInstance() {
        return LazyLoader.instance;
    }

    public void reset() {
        if (this.beforeNaviItemsList != null) {
            this.beforeNaviItemsList.clear();
            this.beforeNaviItemsList = null;
        }
        if (this.afterNaviItemsList != null) {
            this.afterNaviItemsList.clear();
            this.afterNaviItemsList = null;
        }
        if (this.beforeNaviItemsListDefault != null) {
            this.beforeNaviItemsListDefault.clear();
            this.beforeNaviItemsListDefault = null;
        }
        if (this.afterNaviItemsListDefault != null) {
            this.afterNaviItemsListDefault.clear();
            this.afterNaviItemsListDefault = null;
        }
        this.mResIdMap = null;
        this.uploadingVoiceFilePath = null;
        this.uploadingImgFilePath = null;
    }

    public void resetCurrentReportModel() {
        LogUtil.m15791e(TAG, "resetCurrentReportModel: --> ");
        this.currentRouteReportModel = new CurrentRouteReportModel();
    }

    public void parseRouteReportItemJson(JSONArray jsonArray, int intentType) {
        if (jsonArray != null) {
            LogUtil.m15791e(TAG, "parseRouteReportItemJson: intentType --> " + intentType + ", json: " + jsonArray);
            ArrayList<RouteReportItem> itemsList = new ArrayList();
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    RouteReportItem item = parseSingleItem(false, jsonArray.getJSONObject(i));
                    if (item != null) {
                        itemsList.add(item);
                    }
                } catch (Exception e) {
                }
            }
            if (intentType == 1) {
                this.beforeNaviItemsList = itemsList;
            } else {
                this.afterNaviItemsList = itemsList;
            }
        }
    }

    private RouteReportItem parseSingleItem(boolean isSubType, JSONObject data) {
        if (data == null) {
            return null;
        }
        RouteReportItem result = new RouteReportItem();
        try {
            result.mIsSubType = isSubType;
            result.mTitle = data.getString("title");
            result.mType = data.getInt("type");
            if (data.has(HUDGuideDataStruct.KEY_ICON_NAME)) {
                result.mIconUrl = data.getString(HUDGuideDataStruct.KEY_ICON_NAME);
            }
            if (!isSubType) {
                JSONArray subTypeArray = data.getJSONArray("subtype");
                if (subTypeArray != null && subTypeArray.length() > 0) {
                    result.subItemsList = new ArrayList();
                    for (int i = 0; i < subTypeArray.length(); i++) {
                        try {
                            RouteReportItem subItem = parseSingleItem(true, subTypeArray.getJSONObject(i));
                            LogUtil.m15791e(TAG, "parseSingleItem: subItem --> " + subItem.toString());
                            result.subItemsList.add(subItem);
                        } catch (Exception e) {
                        }
                    }
                }
            }
            if (isSubType) {
                return result;
            }
            LogUtil.m15791e(TAG, "parseSingleItem: parentItem --> " + result.toString());
            return result;
        } catch (Exception e2) {
            LogUtil.m15791e(TAG, "parseSingleItem: Exception --> ");
            return null;
        }
    }

    public ArrayList<RouteReportItem> getIntendedItemsList(int intentType) {
        LogUtil.m15791e(TAG, "getIntendedItemsList: intentType --> " + intentType);
        if (intentType == 1) {
            if (this.beforeNaviItemsList != null) {
                return this.beforeNaviItemsList;
            }
            initIntendedItemsListDefault(intentType);
            return this.beforeNaviItemsListDefault;
        } else if (this.afterNaviItemsList != null) {
            return this.afterNaviItemsList;
        } else {
            initIntendedItemsListDefault(intentType);
            return this.afterNaviItemsListDefault;
        }
    }

    private void initIntendedItemsListDefault(int intentType) {
        LogUtil.m15791e(TAG, "initIntendedItemsListDefault: intentType --> " + intentType);
        if (intentType == 1) {
            if (this.beforeNaviItemsListDefault == null) {
                this.beforeNaviItemsListDefault = new ArrayList();
                this.beforeNaviItemsListDefault.add(getDefaultRouteReportItem(14));
                this.beforeNaviItemsListDefault.add(getDefaultRouteReportItem(13));
            }
        } else if (this.afterNaviItemsListDefault == null) {
            this.afterNaviItemsListDefault = new ArrayList();
            this.afterNaviItemsListDefault.add(getDefaultRouteReportItem(11));
            this.afterNaviItemsListDefault.add(getDefaultRouteReportItem(12));
            this.afterNaviItemsListDefault.add(getDefaultRouteReportItem(14));
            this.afterNaviItemsListDefault.add(getDefaultRouteReportItem(13));
        }
    }

    public int getDefaultResId(int type) {
        if (this.mResIdMap == null) {
            this.mResIdMap = new SparseIntArray();
            this.mResIdMap.put(11, C4048R.drawable.route_report_icon_parent_3);
            this.mResIdMap.put(12, C4048R.drawable.route_report_icon_parent_4);
            this.mResIdMap.put(13, C4048R.drawable.route_report_icon_parent_1);
            this.mResIdMap.put(14, C4048R.drawable.route_report_icon_parent_2);
        }
        return this.mResIdMap.get(type, -1);
    }

    private RouteReportItem getDefaultRouteReportItem(int type) {
        RouteReportItem result;
        switch (type) {
            case 11:
                result = new RouteReportItem(false, "终点有误", 11);
                result.addSubItem(getDefaultRouteReportItem(111));
                result.addSubItem(getDefaultRouteReportItem(112));
                return result;
            case 12:
                result = new RouteReportItem(false, "播报错误", 12);
                result.addSubItem(getDefaultRouteReportItem(121));
                result.addSubItem(getDefaultRouteReportItem(122));
                return result;
            case 13:
                result = new RouteReportItem(false, "道路不通", 13);
                result.addSubItem(getDefaultRouteReportItem(131));
                result.addSubItem(getDefaultRouteReportItem(132));
                result.addSubItem(getDefaultRouteReportItem(SUBTYPE_TURNAROUND_FORBIDDEN));
                result.addSubItem(getDefaultRouteReportItem(SUBTYPE_ROAD_NOT_EXIST));
                return result;
            case 14:
                result = new RouteReportItem(false, "吐槽路线", 14);
                result.addSubItem(getDefaultRouteReportItem(SUBTYPE_DETOUR));
                result.addSubItem(getDefaultRouteReportItem(SUBTYPE_CONJUNCTION));
                result.addSubItem(getDefaultRouteReportItem(143));
                return result;
            case 111:
                return new RouteReportItem(true, "找不到终点", 111);
            case 112:
                return new RouteReportItem(true, "车辆无法通行", 112);
            case 121:
                return new RouteReportItem(true, "播报延迟错过路口", 121);
            case 122:
                return new RouteReportItem(true, "播报内容错误", 122);
            case 131:
                return new RouteReportItem(true, "施工封路", 131);
            case 132:
                return new RouteReportItem(true, "单向通行", 132);
            case SUBTYPE_TURNAROUND_FORBIDDEN /*133*/:
                return new RouteReportItem(true, "禁止转向", SUBTYPE_TURNAROUND_FORBIDDEN);
            case SUBTYPE_ROAD_NOT_EXIST /*134*/:
                return new RouteReportItem(true, "路不存在", SUBTYPE_ROAD_NOT_EXIST);
            case SUBTYPE_DETOUR /*141*/:
                return new RouteReportItem(true, "绕路", SUBTYPE_DETOUR);
            case SUBTYPE_CONJUNCTION /*142*/:
                return new RouteReportItem(true, "拥堵", SUBTYPE_CONJUNCTION);
            case 143:
                return new RouteReportItem(true, "路不好走", 143);
            default:
                return null;
        }
    }

    public CurrentRouteReportModel getCurrentRouteReportModel() {
        return this.currentRouteReportModel;
    }

    public RouteReportItem getCurrentFlevelItem() {
        return this.mCurrentFlevelItem;
    }

    public void setCurrentFlevelItem(RouteReportItem mCurrentFlevelItem) {
        this.mCurrentFlevelItem = mCurrentFlevelItem;
    }

    public Bundle getAddrResult() {
        return this.mAddrResult;
    }

    public void setAddrResult(Bundle mAddrResult) {
        this.mAddrResult = mAddrResult;
    }

    public static boolean needsProjection(int type) {
        switch (type) {
            case 11:
            case 14:
                return false;
            case 12:
            case 13:
                return true;
            default:
                return false;
        }
    }

    public void setUploadingVoiceFilePath(String path) {
        this.uploadingVoiceFilePath = path;
    }

    public String getUploadingVoiceFilePath() {
        return this.uploadingVoiceFilePath;
    }

    public void setUploadingImgFilePath(String path) {
        this.uploadingImgFilePath = path;
    }

    public String getUploadingImgFilePath() {
        return this.uploadingImgFilePath;
    }
}
