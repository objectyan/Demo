package com.baidu.baidunavis.control;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavModelHelper;
import com.baidu.baidunavis.model.NavPerformanceModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.NavSearchCircle;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import java.util.HashMap;

public class NavSearchController {
    public static final String TAG = "NavSearchController";
    private static NavSearchController sInstance = null;
    private Handler mHandler = new C08451();
    public boolean mIsContainsOfflineData = false;
    private boolean mIsFromMap = true;
    private Handler mOutHandler = null;
    public boolean mSearchResultOK = false;
    private int mSearchRouteNodeType = -1;

    /* renamed from: com.baidu.baidunavis.control.NavSearchController$1 */
    class C08451 extends BNMainLooperHandler {
        C08451() {
        }

        public void onMessage(Message msg) {
            boolean z = false;
            NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", msg.arg1=" + msg.arg1 + ", mOutHandler=null?" + (NavSearchController.this.mOutHandler == null));
            if (msg.what == 1007) {
                NavSearchController.this.handleSearchByKeyForMapRPNodePoiResultPB(msg);
            } else if (msg.what == 1008 || msg.what == 1009 || msg.what == 1010) {
                if (msg.what == 1008) {
                    NavPerformanceModel.getInstance().endSearchByNameForMapPoiResultPB();
                } else if (msg.what == 1009) {
                    NavPerformanceModel.getInstance().endSearchByCircleForMapPoiResultPB();
                }
                if (NavSearchController.this.mOutHandler == null) {
                    return;
                }
                Bundle bd;
                NavSearchController navSearchController;
                if (msg.arg1 == 0) {
                    NavSearchController.this.mSearchResultOK = true;
                    Message outmsg = NavSearchController.this.mOutHandler.obtainMessage(1020);
                    if (msg.obj instanceof RspData) {
                        NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", RET_OK 0");
                        outmsg.obj = ((RspData) msg.obj).mData;
                        if (outmsg.obj == null || !(outmsg.obj instanceof Bundle)) {
                            NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", RET_OK 2");
                        } else {
                            NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", RET_OK 1");
                            bd = outmsg.obj;
                            if (bd.containsKey(BaiduNaviParams.KEY_HASOFFLINEDATA)) {
                                navSearchController = NavSearchController.this;
                                if (bd.getInt(BaiduNaviParams.KEY_HASOFFLINEDATA) != 0) {
                                    z = true;
                                }
                                navSearchController.mIsContainsOfflineData = z;
                                NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() contains mIsContainsOfflineData=" + NavSearchController.this.mIsContainsOfflineData);
                            } else {
                                NavSearchController.this.mIsContainsOfflineData = false;
                            }
                            if (bd.containsKey("pb_data")) {
                                NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", Search_PB_Data");
                                byte[] data = bd.getByteArray("pb_data");
                                if (data != null) {
                                    NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", Search_PB_Data ,data.len=" + data.length);
                                }
                            } else {
                                NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", Search_PB_Data is null");
                            }
                        }
                    }
                    outmsg.sendToTarget();
                    NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", RET_OK 3");
                    return;
                }
                NavSearchController.this.mSearchResultOK = false;
                if (msg.obj instanceof RspData) {
                    NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", RET_FAILED 0");
                    Object data2 = ((RspData) msg.obj).mData;
                    if (data2 != null && (data2 instanceof Bundle)) {
                        NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", RET_FAILED 1");
                        bd = (Bundle) data2;
                        if (bd.containsKey(BaiduNaviParams.KEY_HASOFFLINEDATA)) {
                            navSearchController = NavSearchController.this;
                            if (bd.getInt(BaiduNaviParams.KEY_HASOFFLINEDATA) != 0) {
                                z = true;
                            }
                            navSearchController.mIsContainsOfflineData = z;
                            NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() contains mIsContainsOfflineData=" + NavSearchController.this.mIsContainsOfflineData);
                        } else {
                            NavSearchController.this.mIsContainsOfflineData = false;
                        }
                    }
                }
                NavSearchController.this.mOutHandler.obtainMessage(1021).sendToTarget();
                NavLogUtils.m3003e(NavSearchController.TAG, "mHandler() msg.what=" + msg.what + ", RET_FAILED");
            }
        }
    }

    private NavSearchController() {
    }

    public static NavSearchController getInstance() {
        if (sInstance == null) {
            sInstance = new NavSearchController();
        }
        return sInstance;
    }

    public void setIsFromMap(boolean fromMap) {
        LogUtil.m3004e(TAG, " (NavSearchController) setIsFromMap (普通导航): fromMap --> " + fromMap);
        this.mIsFromMap = fromMap;
    }

    public boolean isFromMap() {
        return this.mIsFromMap;
    }

    public void setRpEntry(int entry) {
        int cacheEntry = BNRoutePlaner.getInstance().mEntryCache;
        if (cacheEntry != -1) {
            BNRoutePlaner.getInstance().setComeFrom(cacheEntry);
            BNRoutePlaner.getInstance().mEntryCache = -1;
            return;
        }
        BNRoutePlaner.getInstance().setComeFrom(entry);
    }

    public boolean cancelQuery() {
        BNPoiSearcher.getInstance().cancelQuery();
        return true;
    }

    public int getDistrictIdForKeySearch(int districtId) {
        DistrictInfo di;
        DistrictInfo pdi;
        NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch() districtId=" + districtId);
        boolean isDIOK = false;
        int newDistrictId = districtId;
        if (newDistrictId == -1 || newDistrictId == 1 || newDistrictId >= 9000 || newDistrictId >= 65536) {
            isDIOK = true;
        }
        if (!isDIOK) {
            di = BNPoiSearcher.getInstance().getDistrictById(districtId);
            if (di == null) {
                NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()1 district info is null. ");
            } else {
                NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()1 di.type=" + di.mType + ", di.id=" + di.mId + ", name=" + di.mName);
            }
            if (di != null && di.mType == 3) {
                isDIOK = true;
                newDistrictId = di.mId;
            } else if (di != null && di.mType == 4) {
                pdi = BNPoiSearcher.getInstance().getParentDistrict(di.mId);
                if (pdi != null && pdi.mType == 3) {
                    isDIOK = true;
                    newDistrictId = pdi.mId;
                }
            }
        }
        if (!isDIOK) {
            int roamID = NavMapAdapter.getInstance().getRoamCityId();
            di = BNPoiSearcher.getInstance().getDistrictById(roamID);
            if (di == null) {
                NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()2 district info is null. roamID=" + roamID);
            } else {
                NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()2 di.type=" + di.mType + ", di.id=" + di.mId + ", name=" + di.mName + ", roamID=" + roamID);
            }
            if (di != null && di.mType == 3) {
                isDIOK = true;
                newDistrictId = di.mId;
            }
        }
        if (!isDIOK) {
            int curLocalCityId = NavMapAdapter.getInstance().getCurrentLocalCityId();
            pdi = BNPoiSearcher.getInstance().getDistrictById(curLocalCityId);
            if (pdi == null) {
                NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()3 district info is null. curLocalCityId=" + curLocalCityId);
            } else {
                NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()3 di.type=" + pdi.mType + ", di.id=" + pdi.mId + ", name=" + pdi.mName + ", curLocalCityId=" + curLocalCityId);
            }
            if (pdi != null && pdi.mType == 3) {
                isDIOK = true;
                newDistrictId = pdi.mId;
            }
        }
        if (!isDIOK) {
            int locID = NavCommonFuncController.getInstance().getLocationCityIdByPoint();
            if (locID > 0) {
                pdi = BNPoiSearcher.getInstance().getDistrictById(locID);
                if (pdi == null) {
                    NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()4 district info is null. locID=" + locID);
                } else {
                    NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()4 di.type=" + pdi.mType + ", di.id=" + pdi.mId + ", name=" + pdi.mName + ", locID=" + locID);
                }
                if (pdi != null && pdi.mType == 3) {
                    isDIOK = true;
                    newDistrictId = pdi.mId;
                }
            } else {
                NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch()4 district info is null. locID=" + locID);
            }
        }
        if (!isDIOK) {
            newDistrictId = districtId;
        }
        NavLogUtils.m3003e(TAG, "getDistrictIdForKeySearch() newDistrictId=" + newDistrictId);
        return newDistrictId;
    }

    public void searchByKeyForPBData(String key, int districtId, int poiCount, int strategy, int rpNodeCount, int searchRouteNodeType, int viaRouteNodeIndex) {
        int netMode;
        this.mSearchRouteNodeType = searchRouteNodeType;
        this.mSearchResultOK = false;
        this.mIsContainsOfflineData = false;
        int newDistrictId = getDistrictIdForKeySearch(districtId);
        NavLogUtils.m3003e(TAG, "searchByKeyForPBData() oldID=" + districtId + ", newID=" + newDistrictId + " , key=" + key + ", searchRouteNodeType=" + searchRouteNodeType + ", strategy=" + strategy);
        switch (strategy) {
            case 1:
                netMode = 3;
                break;
            case 2:
                netMode = BNSettingManager.getPrefSearchMode();
                break;
            default:
                netMode = 3;
                break;
        }
        if (netMode == 3) {
            netMode = 1;
        } else if (netMode == 2) {
            netMode = 0;
        }
        if (!(netMode == 0 || NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))) {
            netMode = 0;
        }
        NavLogUtils.m3003e(TAG, "searchByKeyForPBData() districtId=" + districtId + ", netMode=" + netMode + ", routeNodeType=" + searchRouteNodeType + ", viaIndex=" + viaRouteNodeIndex);
        BNPoiSearcher.getInstance().asynSearchByKeyForMapRPNodePoiResultPB(key, newDistrictId, poiCount, netMode, rpNodeCount, searchRouteNodeType, viaRouteNodeIndex, this.mHandler);
        NavLogUtils.m3003e(TAG, "searchByKeyForPBData() end");
    }

    private void handleSearchByKeyForMapRPNodePoiResultPB(Message sdkmsg) {
        if (sdkmsg.what == 1007) {
            Bundle data = new Bundle();
            Message outmsg;
            if (sdkmsg.obj instanceof RspData) {
                HashMap<String, Object> arg = ((RspData) sdkmsg.obj).mData;
                if (arg != null && (arg instanceof HashMap)) {
                    HashMap<String, Object> retData = arg;
                    if (retData.containsKey("route_node_type")) {
                        data.putInt("route_node_type", ((Integer) retData.get("route_node_type")).intValue());
                        this.mSearchRouteNodeType = ((Integer) retData.get("route_node_type")).intValue();
                    }
                    int mViaRouteNodeIndex = -1;
                    if (retData.containsKey(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_VIA_ROUTE_NODE_INDEX)) {
                        data.putInt("route_node_type", ((Integer) retData.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_VIA_ROUTE_NODE_INDEX)).intValue());
                        mViaRouteNodeIndex = ((Integer) retData.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_VIA_ROUTE_NODE_INDEX)).intValue();
                    }
                    NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() nodeType=" + this.mSearchRouteNodeType + ", viaNodeIndex=" + mViaRouteNodeIndex);
                    byte[] routePB;
                    if (sdkmsg.arg1 == 0) {
                        NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB RET_OK");
                        if (retData.containsKey(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_JUMP_TO_RP)) {
                            if (((Boolean) retData.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_JUMP_TO_RP)).booleanValue()) {
                                NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_SUCCUSS() for SearchPoi");
                                if (retData.containsKey(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POI)) {
                                    SearchPoi sp = (SearchPoi) retData.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POI);
                                    if (!(this.mSearchRouteNodeType < 0 || sp == null || sp.mGuidePoint == null)) {
                                        RouteNode rn;
                                        if (this.mSearchRouteNodeType == 0) {
                                            rn = NavRoutePlanModel.getInstance().getStartRouteNode();
                                            rn.mFromType = 1;
                                            rn.mGeoPoint = NavModelHelper.convertGeoPoint(sp.mGuidePoint);
                                            rn.mName = sp.mName;
                                            rn.mAddr = sp.mAddress;
                                            rn.mProvinceID = sp.mDistrictId;
                                            rn.mCityID = sp.mDistrictId;
                                            rn.mUID = sp.mOriginUID;
                                            NavRoutePlanModel.getInstance().setStartRouteNode(rn);
                                        } else if (this.mSearchRouteNodeType == 5) {
                                            rn = NavRoutePlanModel.getInstance().getEndRouteNode();
                                            rn.mFromType = 1;
                                            rn.mGeoPoint = NavModelHelper.convertGeoPoint(sp.mGuidePoint);
                                            rn.mName = sp.mName;
                                            rn.mAddr = sp.mAddress;
                                            rn.mProvinceID = sp.mDistrictId;
                                            rn.mCityID = sp.mDistrictId;
                                            rn.mUID = sp.mOriginUID;
                                            NavRoutePlanModel.getInstance().setEndRouteNode(rn);
                                        } else if (this.mSearchRouteNodeType >= 1 && this.mSearchRouteNodeType <= 4 && mViaRouteNodeIndex >= 0 && NavRoutePlanModel.getInstance().getViaNodes() != null && mViaRouteNodeIndex < NavRoutePlanModel.getInstance().getViaNodes().size()) {
                                            rn = (RouteNode) NavRoutePlanModel.getInstance().getViaNodes().get(mViaRouteNodeIndex);
                                            rn.mFromType = 1;
                                            rn.mGeoPoint = NavModelHelper.convertGeoPoint(sp.mGuidePoint);
                                            rn.mName = sp.mName;
                                            rn.mAddr = sp.mAddress;
                                            rn.mProvinceID = sp.mDistrictId;
                                            rn.mCityID = sp.mDistrictId;
                                            rn.mUID = sp.mOriginUID;
                                            NavRoutePlanModel.getInstance().getViaNodes().set(mViaRouteNodeIndex, rn);
                                        }
                                        if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                                            NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_SUCCUSS()  dispatch msg to dimiss loadding...");
                                            BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1031).sendToTarget();
                                        }
                                        if (isFromMap()) {
                                            BaiduNaviManager.getInstance().calcRouteForPBData(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavRoutePlanModel.getInstance().getViaNodes(), NavRoutePlanModel.getInstance().getPreference(), NavRoutePlanModel.getInstance().getDriveRefTimeInterval(), NavRoutePlanModel.getInstance().getDriveRefTimeDuration(), NavRoutePlanModel.getInstance().getStrategy(), NavRoutePlanModel.getInstance().getRouteInfoStatus(), NavRoutePlanModel.getInstance().mCarPANumber, NavRoutePlanModel.getInstance().getEntry());
                                            return;
                                        } else {
                                            BaiduNaviManager.getInstance().calcRouteToNaviRoute(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavRoutePlanModel.getInstance().getViaNodes(), NavRoutePlanModel.getInstance().getPreference(), NavRoutePlanModel.getInstance().getDriveRefTimeInterval(), NavRoutePlanModel.getInstance().getDriveRefTimeDuration(), NavRoutePlanModel.getInstance().getStrategy(), NavRoutePlanModel.getInstance().getEntry());
                                            return;
                                        }
                                    }
                                }
                            }
                            NavLogUtils.m3003e(TAG, "search EVENT_SUCCUSS() for pb");
                            if (retData.containsKey("pb_data")) {
                                routePB = (byte[]) retData.get("pb_data");
                                if (routePB != null) {
                                    NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_SUCCUSS() routePB.len=" + routePB.length);
                                    data.putByteArray("pb_data", routePB);
                                }
                                if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                                    NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_SUCCUSS()  dispatch msg");
                                    outmsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1020);
                                    outmsg.obj = data;
                                    outmsg.sendToTarget();
                                    return;
                                }
                                return;
                            }
                        }
                        if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                            NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_FAIL()  dispatch msg");
                            outmsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1021);
                            outmsg.obj = data;
                            outmsg.sendToTarget();
                            return;
                        }
                        return;
                    }
                    NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_FAIL()");
                    routePB = null;
                    if (retData.containsKey("pb_data")) {
                        routePB = (byte[]) retData.get("pb_data");
                    }
                    if (routePB != null) {
                        NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_FAIL() routePB.len=" + routePB.length);
                        data.putByteArray("pb_data", routePB);
                    }
                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                        NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_FAIL()  dispatch msg");
                        outmsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1021);
                        outmsg.obj = data;
                        outmsg.sendToTarget();
                    }
                } else if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                    NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() data is null.");
                    outmsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1021);
                    outmsg.obj = data;
                    outmsg.sendToTarget();
                }
            } else if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                NavLogUtils.m3003e(TAG, "handleSearchByKeyForMapRPNodePoiResultPB() obj is null.");
                outmsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1021);
                outmsg.obj = data;
                outmsg.sendToTarget();
            }
        }
    }

    public boolean searchByNameForMapPoiResultPB(String name, int districtId, NavSearchCircle circle, int poiCount, int pageNumber, Handler handler) {
        this.mOutHandler = handler;
        this.mSearchResultOK = false;
        this.mIsContainsOfflineData = false;
        int newDistrictId = getDistrictIdForKeySearch(districtId);
        NavLogUtils.m3003e(TAG, "NavSearchController.SearchByNameForMapPoiResultPB() districtId=" + districtId + ", newID=" + newDistrictId);
        return BNPoiSearcher.getInstance().asynSearchByNameForMapPoiResultPB(name, newDistrictId, NavModelHelper.convertNavSearchCircle(circle), poiCount, pageNumber, this.mHandler);
    }

    public boolean searchByCircleForMapPoiResultPB(String name, int districtId, NavSearchCircle circle, int poiCount, int pageNumber, Handler handler) {
        this.mOutHandler = handler;
        this.mSearchResultOK = false;
        this.mIsContainsOfflineData = false;
        int newDistrictId = getDistrictIdForKeySearch(districtId);
        NavLogUtils.m3003e(TAG, "NavSearchController.SearchByCircleForMapPoiResultPB() districtId=" + districtId + ", newID=" + newDistrictId);
        return BNPoiSearcher.getInstance().asynSearchByCircleForMapPoiResultPB(name, newDistrictId, NavModelHelper.convertNavSearchCircle(circle), poiCount, pageNumber, this.mHandler);
    }

    public boolean routeSearchForMapPoiResultPB(int routeSearchMode, String searchWord, int searchRange, int sortType, String mrsl, int poiCount, int pageNumber, Handler handler) {
        this.mOutHandler = handler;
        this.mSearchResultOK = false;
        this.mIsContainsOfflineData = false;
        NavLogUtils.m3003e(TAG, "routeSearchForMapPoiResultPB() routeSearchMode=" + routeSearchMode + ", searchWord=" + searchWord + ", searchRange=" + searchRange + ", sortType=" + sortType + ", mrsl=" + mrsl);
        return BNPoiSearcher.getInstance().asynRouteSearchForMapPoiResultPB(routeSearchMode, searchWord, searchRange, sortType, mrsl, poiCount, pageNumber, this.mHandler);
    }

    public Bundle getSearchStatusInfo() {
        Bundle data = new Bundle();
        NavLogUtils.m3003e(TAG, "getSearchStatusInfo() result=" + this.mSearchResultOK + ", netmode=" + BNPoiSearcher.getInstance().getNetModeOfLastResult() + ", hasOfflineData=" + this.mIsContainsOfflineData);
        data.putBoolean("result", this.mSearchResultOK);
        data.putInt(BaiduNaviParams.KEY_NETMODE, BNPoiSearcher.getInstance().getNetModeOfLastResult());
        data.putBoolean(BaiduNaviParams.KEY_HASOFFLINEDATA, this.mIsContainsOfflineData);
        return data;
    }
}
