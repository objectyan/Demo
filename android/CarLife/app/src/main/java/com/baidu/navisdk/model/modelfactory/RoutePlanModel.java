package com.baidu.navisdk.model.modelfactory;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.PointSelectNode;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanOutlineItem;
import com.baidu.navisdk.model.datastruct.RoutePlanResultItem;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.model.RGRouteItemModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteItemModel.RouteItem;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoutePlanModel extends BaseModel {
    private static final int MSG_AVOID_TRAFFICJAM_ENABLE = 1;
    public static final String SWITCH_OTHER_ROUTE_KEY = "isSwitch";
    private static final String TAG = "RoutePlan";
    public static ArrayList<RoutePlanNode> sNavNodeList = new ArrayList();
    private boolean bIsPoiDetail = false;
    private int enComfrom = 0;
    private int enNaviType = 0;
    public Map<Integer, RoutePlanResultInfo> mAllRoutePlanInfo = new HashMap();
    private IAvoidTrafficjamEnableListener mAvoidTrafficjamEnableListener;
    public int mCurRouteIndex = 0;
    private String mCurrentMRSL = null;
    private BNWorkerNormalTask<String, String> mDistrictTask = null;
    public List<RouteItem> mNavingBrowseRoutItems = null;
    private int mNodeNumBackup = 0;
    private RoutePlanNode mPointByPoiDetail = new RoutePlanNode();
    private PointSelectNode mPointSelectNode = new PointSelectNode();
    int[] mPrefId = null;
    String[] mPrefStr = null;
    private int mRouteCnt = 0;
    private ArrayList<RoutePlanResultItem> mRouteListBackup = null;
    public ArrayList<RoutePlanOutlineItem> mRouteOutlineItemList = new ArrayList();
    private int mRoutePlanMode = 1;
    private ArrayList<RoutePlanNode> mRoutePlanNodeList = new ArrayList();
    private int routePlanNetMode = -1;
    private boolean sIsSelectNode = false;

    public interface IAvoidTrafficjamEnableListener {
        void onAvoidTrafficjamEnable(boolean z);
    }

    public class RoutePlanResultInfo {
        public int mDistance;
        public int mFirstRemainDist;
        public String mFirstRoadName;
        public int mFirstTurnType;
        public int mGasMoney;
        public String mMainRoads;
        public int mNodeNum;
        public String mPusDetectRoad;
        public String mPusDirection;
        public String mPusLabelName;
        public String mPusLabelTips;
        public ArrayList<RoutePlanResultItem> mRouteItems = new ArrayList();
        public int mTime;
        public int mTollFees;
        public int mTrafficLightCnt;
    }

    public String getDistance() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            StringBuffer dist = new StringBuffer();
            StringUtils.formatDistance(((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance, UnitLangEnum.ZH, dist);
            return dist.toString();
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return "";
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (!hasParseRouteDetail(this.mCurRouteIndex)) {
            return "";
        }
        dist = new StringBuffer();
        StringUtils.formatDistance(((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance, UnitLangEnum.ZH, dist);
        return dist.toString();
    }

    public String getTotalTime() {
        String time = "";
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            LogUtil.m15791e("RoutePlan", "remain time before format = " + time);
            time = StringUtils.formatTime2(((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTime, 2);
            LogUtil.m15791e("RoutePlan", "remain time after format = " + time);
            return time;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return "";
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (!hasParseRouteDetail(this.mCurRouteIndex)) {
            return "";
        }
        LogUtil.m15791e("RoutePlan", "remain time before format = " + time);
        time = StringUtils.formatTime2(((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTime, 2);
        LogUtil.m15791e("RoutePlan", "remain time after format = " + time);
        return time;
    }

    public int getNodeNum() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return 0;
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum;
        }
        return 0;
    }

    public ArrayList<RoutePlanResultItem> getRouteNodeData() {
        if (this.mAllRoutePlanInfo == null || this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex)) == null) {
            return null;
        }
        ArrayList<RoutePlanResultItem> mRouteList = ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems;
        if (mRouteList.size() == 0) {
            return null;
        }
        return mRouteList;
    }

    public ArrayList<RoutePlanResultItem> getRouteTwoNodeData(int index) {
        if (this.mAllRoutePlanInfo == null || this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex)) == null) {
            return null;
        }
        ArrayList<RoutePlanResultItem> mRouteList = ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems;
        if (mRouteList.size() == 0 || mRouteList.size() <= index - 1) {
            return null;
        }
        try {
            ArrayList<RoutePlanResultItem> list = new ArrayList();
            list.add(mRouteList.get(index));
            list.add(mRouteList.get(index + 1));
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<RoutePlanOutlineItem> getRouteOutlineData() {
        return this.mRouteOutlineItemList;
    }

    public void saveCurRouteNaviBrowseInfo() {
        LogUtil.m15791e("RoutePlan", "sunhao.routeitem.saveCurRouteNaviBrowseInfo()");
        if (this.mNavingBrowseRoutItems == null) {
            this.mNavingBrowseRoutItems = new ArrayList();
        } else {
            this.mNavingBrowseRoutItems.clear();
        }
        if (this.mRouteListBackup == null) {
            this.mRouteListBackup = new ArrayList();
        } else {
            this.mRouteListBackup.clear();
        }
        List<RouteItem> tempRouteItemList = RGRouteItemModel.getInstance().getRouteItems();
        if (tempRouteItemList != null && tempRouteItemList.size() != 0) {
            if (hasParseRouteDetail(this.mCurRouteIndex)) {
                this.mNodeNumBackup = ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum;
                this.mRouteListBackup.addAll(((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems);
                this.mNavingBrowseRoutItems.addAll(tempRouteItemList);
                return;
            }
            Bundle bundle = getRoutePlanBundle();
            if (bundle != null) {
                parseRouteResult(BNaviModuleManager.getContext(), bundle);
                if (hasParseRouteDetail(this.mCurRouteIndex)) {
                    this.mNodeNumBackup = ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum;
                    this.mRouteListBackup.addAll(((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems);
                    this.mNavingBrowseRoutItems.addAll(tempRouteItemList);
                }
            }
        }
    }

    public void restoreCurRouteNaviBrowseInfo() {
        LogUtil.m15791e("RoutePlan", "sunhao.routeitem.restoreCurRouteNaviBrowseInfo()");
        ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum = this.mNodeNumBackup;
        if (this.mNavingBrowseRoutItems != null) {
            RGRouteItemModel.getInstance().updateRouteItems(this.mNavingBrowseRoutItems);
        }
        if (this.mRouteListBackup != null && hasParseRouteDetail(this.mCurRouteIndex)) {
            List<RoutePlanResultItem> mRouteList = ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems;
            mRouteList.clear();
            mRouteList.addAll(this.mRouteListBackup);
        }
    }

    public void clearRouteOutLineResult() {
        this.mRouteOutlineItemList.clear();
    }

    public void clearRouteResult() {
        LogUtil.m15791e("wangyang", "clearRouteResult");
        this.mAllRoutePlanInfo.clear();
        this.mRouteOutlineItemList.clear();
        this.mCurRouteIndex = 0;
    }

    public void parseRouteResultOutline(ArrayList<Bundle> routeResultBundle) {
        clearRouteOutLineResult();
        if (routeResultBundle != null && !routeResultBundle.isEmpty()) {
            clearRouteOutLineResult();
            this.mRouteCnt = routeResultBundle.size();
            for (int i = 0; i < this.mRouteCnt; i++) {
                Bundle bundle = (Bundle) routeResultBundle.get(i);
                int distance = bundle.getInt("totaldistance");
                int time = bundle.getInt(SimpleGuideInfo.TotalTime);
                int trafficLight = bundle.getInt("trafficlightcnt");
                int tollfees = bundle.getInt("tollfees");
                String pusLabelName = bundle.getString("pusLabelName");
                int preference = BNRoutePlaner.getInstance().getCalcPreference();
                int pusLabelID = bundle.getInt("pusLabelID");
                if ("".equals(pusLabelName) && preference != 1) {
                    if (i == 0) {
                        pusLabelName = parserLableId(preference);
                    } else {
                        if (i == 1) {
                            pusLabelName = "方案二";
                        }
                        if (i == 2) {
                            pusLabelName = "方案三";
                        }
                    }
                }
                this.mRouteOutlineItemList.add(new RoutePlanOutlineItem(i, "", tollfees, trafficLight, 0, (double) distance, (double) time, pusLabelName, bundle.getString("pusLabelTips"), pusLabelID));
            }
            Bundle prefBundle = (Bundle) routeResultBundle.get(0);
            this.mPrefId = prefBundle.getIntArray("prefId");
            this.mPrefStr = prefBundle.getStringArray("prefStr");
        }
    }

    public void parseRouteResultMainInfo(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty() && ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))) == null) {
            RoutePlanResultInfo tmp = new RoutePlanResultInfo();
            tmp.mDistance = bundle.getInt("totaldistance");
            tmp.mTime = bundle.getInt(SimpleGuideInfo.TotalTime);
            tmp.mNodeNum = bundle.getInt("nodenum");
            tmp.mMainRoads = bundle.getString("mainroads");
            tmp.mTrafficLightCnt = bundle.getInt("trafficlightcnt");
            tmp.mTollFees = bundle.getInt("tollfees");
            tmp.mGasMoney = bundle.getInt("gasmoney");
            this.mAllRoutePlanInfo.put(Integer.valueOf(this.mCurRouteIndex), tmp);
        }
    }

    public void parseRouteResult(Context context, Bundle bundle) {
        RoutePlanResultInfo routePlanResultInfo = new RoutePlanResultInfo();
        if (context != null) {
            int i;
            routePlanResultInfo.mDistance = bundle.getInt("totaldistance");
            routePlanResultInfo.mTime = bundle.getInt(SimpleGuideInfo.TotalTime);
            routePlanResultInfo.mNodeNum = bundle.getInt("nodenum");
            LogUtil.m15791e("wangyang", "parseRouteResult mDistance = " + routePlanResultInfo.mDistance + " mTime = " + routePlanResultInfo.mTime + " mNodeNum = " + routePlanResultInfo.mNodeNum);
            if (routePlanResultInfo.mNodeNum <= 0) {
                LogUtil.m15791e("wangyang", "route plan not finished ");
            }
            String[] nextRoadArr = bundle.getStringArray("nextroadname");
            int[] distArr = bundle.getIntArray("distance");
            int[] turnType = bundle.getIntArray("turntype");
            int[] geoPosX = bundle.getIntArray("ptX");
            int[] geoPosY = bundle.getIntArray("ptY");
            int[] roadCondition = bundle.getIntArray("roadCond");
            int[] linkAngle = bundle.getIntArray("linkAngle");
            routePlanResultInfo.mMainRoads = bundle.getString("mainroads");
            routePlanResultInfo.mTrafficLightCnt = bundle.getInt("trafficlightcnt");
            routePlanResultInfo.mTollFees = bundle.getInt("tollfees");
            routePlanResultInfo.mGasMoney = bundle.getInt("gasmoney");
            routePlanResultInfo.mPusDirection = bundle.getString("pusDirection");
            routePlanResultInfo.mPusDetectRoad = bundle.getString("pusDetectedRoad");
            if (nextRoadArr != null) {
                if (nextRoadArr.length >= 1) {
                    for (i = 1; i < nextRoadArr.length; i++) {
                        if (!StringUtils.isEmpty(nextRoadArr[i])) {
                            routePlanResultInfo.mFirstRoadName = nextRoadArr[i];
                            break;
                        }
                    }
                }
                if (turnType.length >= 2) {
                    routePlanResultInfo.mFirstTurnType = turnType[1];
                }
                if (distArr.length >= 2) {
                    routePlanResultInfo.mFirstRemainDist = distArr[0];
                }
            }
            String endName = getEndName(context, false);
            List<RouteItem> tNavingRoutItems = new ArrayList();
            if (turnType != null) {
                try {
                    if (turnType.length > 0) {
                        i = 0;
                        while (i < routePlanResultInfo.mNodeNum) {
                            int turnTypeIndex = turnType[i];
                            if (turnTypeIndex >= RoutePlanParams.gTurnIconIDSmall.length) {
                                LogUtil.m15791e("RoutePlan", "parseRouteResult out of arry! turnTypeIndex=" + turnTypeIndex);
                            } else {
                                String formatter;
                                String formatterNight;
                                String bubbleFromat;
                                RouteItem tNavingRI;
                                String nodeDesc;
                                String nodeDescNight;
                                String bubleDesc;
                                RoutePlanResultItem item;
                                String turnTypeStr = RouteGuideParams.gTurnTypeDesc[turnTypeIndex];
                                int turnTypeId = RoutePlanParams.gTurnIconIDSmall[turnTypeIndex];
                                if (!RoutePlanParams.TURN_TYPE_ID_START.equals(turnTypeStr)) {
                                    if (!turnTypeStr.startsWith(RoutePlanParams.TURN_TYPE_ID_VIA)) {
                                        formatter = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_route_node_desc_format);
                                        formatterNight = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_route_node_desc_format_night);
                                        bubbleFromat = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_route_node_bubble_format);
                                        tNavingRI = null;
                                        if (routePlanResultInfo.mNodeNum > 1 || i <= 0) {
                                            if (routePlanResultInfo.mNodeNum == 1) {
                                                tNavingRI = new RouteItem(turnTypeIndex, distArr[0], RoutePlanParams.TURN_TYPE_ID_END, geoPosX[0], geoPosY[0]);
                                                tNavingRI.type = 3;
                                            }
                                        } else if (RoutePlanParams.TURN_TYPE_ID_START.equals(turnTypeStr)) {
                                            tNavingRI = new RouteItem(turnTypeIndex, distArr[i - 1], RoutePlanParams.TURN_TYPE_ID_START, geoPosX[i - 1], geoPosY[i - 1]);
                                            tNavingRI.type = 1;
                                        } else {
                                            if (turnTypeStr.startsWith(RoutePlanParams.TURN_TYPE_ID_VIA)) {
                                                tNavingRI = new RouteItem(turnTypeIndex, distArr[i - 1], RoutePlanParams.TURN_TYPE_ID_VIA, geoPosX[i - 1], geoPosY[i - 1]);
                                                tNavingRI.type = 2;
                                            } else {
                                                if (turnTypeStr.startsWith(RoutePlanParams.TURN_TYPE_ID_END)) {
                                                    tNavingRI = new RouteItem(turnTypeIndex, distArr[i - 1], RoutePlanParams.TURN_TYPE_ID_END, geoPosX[i - 1], geoPosY[i - 1]);
                                                    tNavingRI.type = 3;
                                                } else {
                                                    tNavingRI = new RouteItem(turnTypeIndex, distArr[i - 1], nextRoadArr[i], geoPosX[i - 1], geoPosY[i - 1]);
                                                }
                                            }
                                        }
                                        if (tNavingRI != null) {
                                            tNavingRoutItems.add(tNavingRI);
                                        }
                                        if (RoutePlanParams.TURN_TYPE_ID_END.equals(turnTypeStr)) {
                                            if (nextRoadArr[i].length() == 0) {
                                                nextRoadArr[i] = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_no_name_road);
                                            }
                                            StringUtils.formatDistance(distArr[i], UnitLangEnum.ZH, new StringBuffer());
                                            nodeDesc = String.format(formatter, new Object[]{nextRoadArr[i], displayDistArr});
                                            nodeDescNight = String.format(formatterNight, new Object[]{nextRoadArr[i], displayDistArr});
                                            bubleDesc = String.format(bubbleFromat, new Object[]{RouteGuideParams.gTurnTypeDesc[turnTypeIndex], nextRoadArr[i], displayDistArr});
                                        } else {
                                            nodeDesc = "nodeEnd";
                                            nodeDescNight = "nodeEnd";
                                            bubleDesc = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_destination_bubble_format, new Object[]{RouteGuideParams.gTurnTypeDesc[turnTypeIndex], endName});
                                        }
                                        if (i < geoPosX.length && i < geoPosY.length) {
                                            item = new RoutePlanResultItem(turnTypeId, nodeDesc, nodeDescNight, bubleDesc, geoPosX[i], geoPosY[i], roadCondition == null ? roadCondition[i] : 0);
                                            if (linkAngle != null && i < linkAngle.length) {
                                                item.angle = linkAngle[i];
                                            }
                                            if (i < nextRoadArr.length) {
                                                item.roadName = nextRoadArr[i];
                                            }
                                            routePlanResultInfo.mRouteItems.add(item);
                                        }
                                    }
                                }
                                formatter = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_from_node_desc_format);
                                formatterNight = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_from_node_desc_format_night);
                                bubbleFromat = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_from_node_bubble_format);
                                tNavingRI = null;
                                if (routePlanResultInfo.mNodeNum > 1) {
                                }
                                if (routePlanResultInfo.mNodeNum == 1) {
                                    tNavingRI = new RouteItem(turnTypeIndex, distArr[0], RoutePlanParams.TURN_TYPE_ID_END, geoPosX[0], geoPosY[0]);
                                    tNavingRI.type = 3;
                                }
                                if (tNavingRI != null) {
                                    tNavingRoutItems.add(tNavingRI);
                                }
                                if (RoutePlanParams.TURN_TYPE_ID_END.equals(turnTypeStr)) {
                                    if (nextRoadArr[i].length() == 0) {
                                        nextRoadArr[i] = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_no_name_road);
                                    }
                                    StringUtils.formatDistance(distArr[i], UnitLangEnum.ZH, new StringBuffer());
                                    nodeDesc = String.format(formatter, new Object[]{nextRoadArr[i], displayDistArr});
                                    nodeDescNight = String.format(formatterNight, new Object[]{nextRoadArr[i], displayDistArr});
                                    bubleDesc = String.format(bubbleFromat, new Object[]{RouteGuideParams.gTurnTypeDesc[turnTypeIndex], nextRoadArr[i], displayDistArr});
                                } else {
                                    nodeDesc = "nodeEnd";
                                    nodeDescNight = "nodeEnd";
                                    bubleDesc = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_destination_bubble_format, new Object[]{RouteGuideParams.gTurnTypeDesc[turnTypeIndex], endName});
                                }
                                if (roadCondition == null) {
                                }
                                item = new RoutePlanResultItem(turnTypeId, nodeDesc, nodeDescNight, bubleDesc, geoPosX[i], geoPosY[i], roadCondition == null ? roadCondition[i] : 0);
                                item.angle = linkAngle[i];
                                if (i < nextRoadArr.length) {
                                    item.roadName = nextRoadArr[i];
                                }
                                routePlanResultInfo.mRouteItems.add(item);
                            }
                            i++;
                        }
                        this.mAllRoutePlanInfo.put(Integer.valueOf(this.mCurRouteIndex), routePlanResultInfo);
                        LogUtil.m15791e("wangyang", "mAllRoutePlanInfo.put  done mCurRouteIndex = " + this.mCurRouteIndex);
                        RGRouteItemModel.getInstance().updateRouteItems(tNavingRoutItems);
                        LogUtil.m15791e("wangyang", "parseRouteResult done");
                        return;
                    }
                } catch (Exception e) {
                    LogUtil.m15791e("RoutePlan", e.toString());
                    return;
                }
            }
            LogUtil.m15791e("RoutePlan", "turnType null");
        }
    }

    public boolean hasParseRouteDetail(int index) {
        if (((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(index))) != null) {
            return true;
        }
        return false;
    }

    public void clearRouteInput() {
        cancelDistrictThread();
        this.mRoutePlanNodeList.clear();
    }

    public int getRoutePlanNodeSize() {
        if (this.mRoutePlanNodeList != null) {
            return this.mRoutePlanNodeList.size();
        }
        return 0;
    }

    public void setRouteInput(ArrayList<RoutePlanNode> navNodeList) {
        if (navNodeList != null) {
            clearRouteInput();
            int nodeCount = navNodeList.size();
            for (int i = 0; i < nodeCount; i++) {
                this.mRoutePlanNodeList.add(new RoutePlanNode((RoutePlanNode) navNodeList.get(i)));
            }
        }
    }

    public ArrayList<RoutePlanNode> getRouteInput() {
        return (ArrayList) this.mRoutePlanNodeList.clone();
    }

    public int getRoutePlanMode() {
        return this.mRoutePlanMode;
    }

    public int getRouteCnt() {
        return this.mRouteCnt;
    }

    public String getStartName(Context context, boolean isSimple) {
        if (this.mRoutePlanNodeList.size() <= 0) {
            return "";
        }
        return getNodeName(context, (RoutePlanNode) this.mRoutePlanNodeList.get(0), isSimple);
    }

    public String getEndName(Context context, boolean isSimple) {
        if (this.mRoutePlanNodeList.size() <= 1) {
            return "";
        }
        return getNodeName(context, (RoutePlanNode) this.mRoutePlanNodeList.get(this.mRoutePlanNodeList.size() - 1), isSimple);
    }

    public RoutePlanNode getEndNode() {
        if (this.mRoutePlanNodeList.size() <= 1) {
            return null;
        }
        return (RoutePlanNode) this.mRoutePlanNodeList.get(this.mRoutePlanNodeList.size() - 1);
    }

    public ArrayList<RoutePlanNode> getViaNodeList() {
        if (this.mRoutePlanNodeList.size() <= 2) {
            return null;
        }
        ArrayList<RoutePlanNode> routePlanNodeArrayList = this.mRoutePlanNodeList;
        int size = routePlanNodeArrayList.size();
        ArrayList<RoutePlanNode> list = new ArrayList();
        for (int index = 1; index < size - 1; index++) {
            list.add(routePlanNodeArrayList.get(index));
        }
        return list;
    }

    public RoutePlanNode getStartNode() {
        if (this.mRoutePlanNodeList.size() <= 0) {
            return null;
        }
        return (RoutePlanNode) this.mRoutePlanNodeList.get(0);
    }

    public boolean getAvoidTrafficjamEnable() {
        final ArrayList<RoutePlanNode> navNodeList = getRouteInput();
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            ArrayList<Integer> cityidlist = new ArrayList();
            int nodeSize = navNodeList.size();
            for (int i = 0; i < nodeSize; i++) {
                RoutePlanNode node = (RoutePlanNode) navNodeList.get(i);
                if (node != null && node.isNodeSettedData()) {
                    DistrictInfo cityinfo = BNPoiSearcher.getInstance().getDistrictByPoint(node.mGeoPoint, 0);
                    if (!(cityinfo == null || cityinfo.mType != 3 || cityidlist.contains(Integer.valueOf(cityinfo.mId)))) {
                        cityidlist.add(Integer.valueOf(cityinfo.mId));
                    }
                }
            }
            if (1 == cityidlist.size()) {
                int cityID = ((Integer) cityidlist.get(0)).intValue();
                LogUtil.m15791e("RoutePlan", "cityinfo.cityID = " + cityID);
                if (BNMapController.getInstance().checkRoadConditionSupport(cityID)) {
                    return true;
                }
            }
        }
        cancelDistrictThread();
        this.mDistrictTask = new BNWorkerNormalTask<String, String>("CarNavi-DistrictTask", null) {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected java.lang.String execute() {
                /*
                r9 = this;
                r8 = 1;
                r2 = 0;
                r1 = new java.util.ArrayList;
                r1.<init>();
                r6 = r4;
                r5 = r6.size();
                r4 = 0;
                r3 = 0;
            L_0x000f:
                if (r3 >= r5) goto L_0x004a;
            L_0x0011:
                r6 = r4;
                r4 = r6.get(r3);
                r4 = (com.baidu.navisdk.model.datastruct.RoutePlanNode) r4;
                if (r4 == 0) goto L_0x0047;
            L_0x001b:
                r6 = r4.isNodeSettedData();
                if (r6 == 0) goto L_0x0047;
            L_0x0021:
                r6 = com.baidu.navisdk.comapi.poisearch.BNPoiSearcher.getInstance();
                r7 = r4.mGeoPoint;
                r2 = r6.getDistrictByPoint(r7, r8);
                if (r2 == 0) goto L_0x0047;
            L_0x002d:
                r6 = r2.mType;
                r7 = 3;
                if (r6 != r7) goto L_0x0047;
            L_0x0032:
                r6 = r2.mId;
                r6 = java.lang.Integer.valueOf(r6);
                r6 = r1.contains(r6);
                if (r6 != 0) goto L_0x0047;
            L_0x003e:
                r6 = r2.mId;
                r6 = java.lang.Integer.valueOf(r6);
                r1.add(r6);
            L_0x0047:
                r3 = r3 + 1;
                goto L_0x000f;
            L_0x004a:
                r6 = r1.size();
                if (r8 != r6) goto L_0x007e;
            L_0x0050:
                r6 = 0;
                r6 = r1.get(r6);
                r6 = (java.lang.Integer) r6;
                r0 = r6.intValue();
                r6 = TAG;
                r7 = new java.lang.StringBuilder;
                r7.<init>();
                r8 = "mDistrictThread cityinfo.cityID = ";
                r7 = r7.append(r8);
                r7 = r7.append(r0);
                r7 = r7.toString();
                com.baidu.navisdk.util.common.LogUtil.m15791e(r6, r7);
                r6 = com.baidu.navisdk.comapi.mapcontrol.BNMapController.getInstance();
                r6 = r6.checkRoadConditionSupport(r0);
                if (r6 == 0) goto L_0x007e;
            L_0x007e:
                r6 = 0;
                return r6;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.model.modelfactory.RoutePlanModel.1.execute():java.lang.String");
            }
        };
        BNWorkerCenter.getInstance().submitNormalTask(this.mDistrictTask, new BNWorkerConfig(101, 0));
        return false;
    }

    private void cancelDistrictThread() {
        BNWorkerCenter.getInstance().cancelTask(this.mDistrictTask, true);
        this.mDistrictTask = null;
    }

    public void setAvoidTrafficjamEnableListener(IAvoidTrafficjamEnableListener l) {
        this.mAvoidTrafficjamEnableListener = l;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getNodeName(android.content.Context r7, com.baidu.navisdk.model.datastruct.RoutePlanNode r8, boolean r9) {
        /*
        r6 = this;
        r5 = 6;
        r1 = "";
        if (r8 == 0) goto L_0x000e;
    L_0x0006:
        if (r7 == 0) goto L_0x000e;
    L_0x0008:
        r3 = r8.isNodeSettedData();
        if (r3 != 0) goto L_0x0010;
    L_0x000e:
        r2 = r1;
    L_0x000f:
        return r2;
    L_0x0010:
        r3 = r8.mFrom;	 Catch:{ Exception -> 0x0094 }
        switch(r3) {
            case 1: goto L_0x007a;
            case 2: goto L_0x0015;
            case 3: goto L_0x004b;
            case 4: goto L_0x0062;
            case 5: goto L_0x006e;
            default: goto L_0x0015;
        };	 Catch:{ Exception -> 0x0094 }
    L_0x0015:
        r3 = r8.mName;	 Catch:{ Exception -> 0x0094 }
        r3 = com.baidu.navisdk.util.common.StringUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0094 }
        if (r3 == 0) goto L_0x0091;
    L_0x001d:
        r3 = com.baidu.navisdk.util.jar.JarUtils.getResources();	 Catch:{ Exception -> 0x0094 }
        r4 = 1711669365; // 0x66060075 float:1.5820138E23 double:8.456770303E-315;
        r1 = r3.getString(r4);	 Catch:{ Exception -> 0x0094 }
    L_0x0028:
        if (r9 == 0) goto L_0x0049;
    L_0x002a:
        r3 = r1.length();
        if (r3 <= r5) goto L_0x0049;
    L_0x0030:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = 0;
        r4 = r1.substring(r4, r5);
        r3 = r3.append(r4);
        r4 = "...";
        r3 = r3.append(r4);
        r1 = r3.toString();
    L_0x0049:
        r2 = r1;
        goto L_0x000f;
    L_0x004b:
        r3 = r8.mName;	 Catch:{ Exception -> 0x0094 }
        r3 = com.baidu.navisdk.util.common.StringUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0094 }
        if (r3 == 0) goto L_0x005f;
    L_0x0053:
        r3 = com.baidu.navisdk.util.jar.JarUtils.getResources();	 Catch:{ Exception -> 0x0094 }
        r4 = 1711669559; // 0x66060137 float:1.5820488E23 double:8.45677126E-315;
        r1 = r3.getString(r4);	 Catch:{ Exception -> 0x0094 }
    L_0x005e:
        goto L_0x0028;
    L_0x005f:
        r1 = r8.mName;	 Catch:{ Exception -> 0x0094 }
        goto L_0x005e;
    L_0x0062:
        r3 = com.baidu.navisdk.util.jar.JarUtils.getResources();	 Catch:{ Exception -> 0x0094 }
        r4 = 1711669557; // 0x66060135 float:1.5820484E23 double:8.45677125E-315;
        r1 = r3.getString(r4);	 Catch:{ Exception -> 0x0094 }
        goto L_0x0028;
    L_0x006e:
        r3 = com.baidu.navisdk.util.jar.JarUtils.getResources();	 Catch:{ Exception -> 0x0094 }
        r4 = 1711669558; // 0x66060136 float:1.5820486E23 double:8.456771256E-315;
        r1 = r3.getString(r4);	 Catch:{ Exception -> 0x0094 }
        goto L_0x0028;
    L_0x007a:
        r3 = r8.mName;	 Catch:{ Exception -> 0x0094 }
        r3 = com.baidu.navisdk.util.common.StringUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0094 }
        if (r3 == 0) goto L_0x008e;
    L_0x0082:
        r3 = com.baidu.navisdk.util.jar.JarUtils.getResources();	 Catch:{ Exception -> 0x0094 }
        r4 = 1711669560; // 0x66060138 float:1.582049E23 double:8.456771266E-315;
        r1 = r3.getString(r4);	 Catch:{ Exception -> 0x0094 }
    L_0x008d:
        goto L_0x0028;
    L_0x008e:
        r1 = r8.mName;	 Catch:{ Exception -> 0x0094 }
        goto L_0x008d;
    L_0x0091:
        r1 = r8.mName;	 Catch:{ Exception -> 0x0094 }
        goto L_0x0028;
    L_0x0094:
        r0 = move-exception;
        r3 = "RoutePlan";
        r4 = r0.toString();
        com.baidu.navisdk.util.common.LogUtil.m15791e(r3, r4);
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.model.modelfactory.RoutePlanModel.getNodeName(android.content.Context, com.baidu.navisdk.model.datastruct.RoutePlanNode, boolean):java.lang.String");
    }

    public PointSelectNode getPointSelectNode() {
        return this.mPointSelectNode;
    }

    public RoutePlanNode getRoutePlanNode() {
        return this.mPointSelectNode.getRoutePlanNode();
    }

    public void setPointSelectNode(PointSelectNode pointSelectNode) {
        this.sIsSelectNode = true;
        this.mPointSelectNode = pointSelectNode;
    }

    public void setPointSelectNode(RoutePlanNode node) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(node);
    }

    public void setPointSelectNode(RoutePlanNode node, int from) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(node);
        this.mPointSelectNode.setFrom(from);
    }

    public void setPointSelectNode(GeoPoint geoPoint) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(geoPoint);
        this.mPointSelectNode.setUID(null);
    }

    public void setPointSelectNode(GeoPoint geoPoint, int from, String name, String description) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(geoPoint, geoPoint, from, name, description);
        this.mPointSelectNode.setUID(null);
    }

    public void setPointSelectNode(SearchPoi node) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(node);
    }

    public void setPointSelectNode(ArrayList<SearchPoi> list, SearchPoi node) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(node, (ArrayList) list);
    }

    public void setPointSelectNode(int index, SearchPoi node, ArrayList<SearchPoi> list) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(index, node, list);
    }

    public void setPointSelectNode(int index, SearchPoi node) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(index, node);
    }

    public void setPointSelectNode(int latitude, int longitude, int from, String name, String description) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setRoutePlanNode(latitude, longitude, from, name, description);
        this.mPointSelectNode.setUID(null);
    }

    public void setPointSelectNode(int pointIndex, GeoPoint geoPoint, int from, String name, String description) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setPointIndex(pointIndex);
        this.mPointSelectNode.setRoutePlanNode(geoPoint, from, name, description);
        this.mPointSelectNode.setUID(null);
    }

    public void setPointSelectNode(int pointIndex, int latitude, int longitude, int from, String name, String description) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setPointIndex(pointIndex);
        this.mPointSelectNode.setRoutePlanNode(latitude, longitude, from, name, description);
        this.mPointSelectNode.setUID(null);
    }

    public void setPointSelectNodeInfo(int pointIndex, String description) {
        this.sIsSelectNode = true;
        this.mPointSelectNode.setPointIndex(pointIndex);
        this.mPointSelectNode.setPointDescription(description);
        this.mPointSelectNode.setUID(null);
    }

    public boolean isSelectNode() {
        return this.sIsSelectNode;
    }

    public void clearSelectNode() {
        this.sIsSelectNode = false;
        this.mPointSelectNode.clearSelectNode();
    }

    public void setPointPoiDetail(RoutePlanNode node) {
        this.bIsPoiDetail = true;
        this.mPointByPoiDetail.copy(node);
    }

    public RoutePlanNode getPointPoiDetail() {
        return this.mPointByPoiDetail;
    }

    public void clearPointPoiDetail() {
        this.bIsPoiDetail = false;
        this.mPointByPoiDetail.mName = "";
        this.mPointByPoiDetail.mDescription = "";
        this.mPointByPoiDetail.mGeoPoint = new GeoPoint();
        this.mPointByPoiDetail.mFrom = 0;
        this.mPointByPoiDetail.mViewPoint = null;
        this.mPointByPoiDetail.clearSubPoiList();
    }

    public static RoutePlanNode changeToRoutePlanNode(SearchPoi node) {
        if (node == null) {
            return new RoutePlanNode();
        }
        return new RoutePlanNode(node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
    }

    public int getTotalDistanceInt() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            LogUtil.m15791e("wangyang", "getTotalDistanceInt Parse");
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return 0;
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance;
        }
        return 0;
    }

    public String getTotalDistance() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            StringBuffer dist = new StringBuffer();
            StringUtils.formatDistance(((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance, UnitLangEnum.ZH, dist);
            return dist.toString();
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return "";
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (!hasParseRouteDetail(this.mCurRouteIndex)) {
            return "";
        }
        dist = new StringBuffer();
        StringUtils.formatDistance(((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance, UnitLangEnum.ZH, dist);
        return dist.toString();
    }

    public int getTotalTimeInt() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTime;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return 0;
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTime;
        }
        return 0;
    }

    public int getFirstTurnType() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstTurnType;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return 0;
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstTurnType;
        }
        return 0;
    }

    public int getFirstRemainDist() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstRemainDist;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return 0;
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstRemainDist;
        }
        return 0;
    }

    public String getFirstRoadName() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstRoadName;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return "";
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstRoadName;
        }
        return "";
    }

    public String getMultiRouteCurrentMSRL() {
        return this.mCurrentMRSL;
    }

    public static String htmlRemoveTag(String inputString) {
        if (inputString == null) {
            return null;
        }
        String textStr = "";
        return inputString.replace("font", "null");
    }

    public String getMainRoads() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mMainRoads;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return "";
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mMainRoads;
        }
        return "";
    }

    public int getTrafficLightCnt() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTrafficLightCnt;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return 0;
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTrafficLightCnt;
        }
        return 0;
    }

    public int getGasMoney() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mGasMoney;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return 0;
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mGasMoney;
        }
        return 0;
    }

    public int getTollFees() {
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTollFees;
        }
        Bundle bundle = getRoutePlanBundle();
        if (bundle == null) {
            return 0;
        }
        parseRouteResult(BNaviModuleManager.getContext(), bundle);
        if (hasParseRouteDetail(this.mCurRouteIndex)) {
            return ((RoutePlanResultInfo) this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTollFees;
        }
        return 0;
    }

    public int[] getPrefId() {
        return this.mPrefId;
    }

    public String[] getPrefStr() {
        return this.mPrefStr;
    }

    public void setCurIndex(int index) {
        this.mCurRouteIndex = index;
    }

    public int getCurIndex() {
        return this.mCurRouteIndex;
    }

    public Bundle getRoutePlanBundle() {
        LogUtil.m15791e("wangyang", "getRoutePlanBundle start");
        Bundle bundle = new Bundle();
        if (BNRoutePlaner.getInstance().getRouteInfo(this.mCurRouteIndex, bundle) != 2) {
            return null;
        }
        LogUtil.m15791e("wangyang", "getRoutePlanBundle: full");
        return bundle;
    }

    public boolean isAvoidTrafficLable() {
        if (this.mRouteOutlineItemList.size() <= 0) {
            return false;
        }
        RoutePlanOutlineItem outlineitem = (RoutePlanOutlineItem) this.mRouteOutlineItemList.get(this.mCurRouteIndex);
        if (outlineitem == null) {
            return false;
        }
        String lableName = outlineitem.getPusLabelName();
        if (lableName == null || !"躲避拥堵".equals(lableName)) {
            return false;
        }
        return true;
    }

    private String parserLableId(int id) {
        if (id <= 1) {
            return "";
        }
        String str = "";
        switch (id) {
            case 2:
                return "高速优先";
            case 4:
                return "不走高速";
            case 8:
                return "少收费";
            case 16:
                return "躲避拥堵";
            default:
                return "推荐";
        }
    }

    public int getEnNaviType() {
        return this.enNaviType;
    }

    public void setEnNaviType(int enNaviType) {
        this.enNaviType = enNaviType;
    }

    public int getEnComfrom() {
        return this.enComfrom;
    }

    public void setEnComfrom(int enComfrom) {
        this.enComfrom = enComfrom;
    }

    public int getRoutePlanNetMode() {
        return this.routePlanNetMode;
    }

    public void setRoutePlanNetMode(int mNetMode) {
        this.routePlanNetMode = mNetMode;
    }
}
