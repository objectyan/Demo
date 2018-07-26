package com.baidu.navisdk.module.ugc.data.datarepository;

import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class UgcDataRepository {
    private static final String TAG = UgcDataRepository.class.getName();
    private static UgcDataRepository instance;
    ArrayList<UgcBaseDataModel> detailModelList1 = null;
    ArrayList<UgcBaseDataModel> detailModelList2 = null;
    ArrayList<UgcBaseDataModel> detailModelList3 = null;
    ArrayList<UgcBaseDataModel> detailModelList4 = null;
    ArrayList<UgcBaseDataModel> detailModelList5 = null;
    ArrayList<UgcBaseDataModel> elecEyeModelList = null;
    ArrayList<UgcBaseDataModel> laneModelList = null;
    ArrayList<UgcBaseDataModel> laneModelList1 = null;
    private ActBaseDataModel mActBaseDataModel = null;
    private CommonBaseDataModel mCommonBaseDataModel = null;
    private ArrayList<UgcBaseDataModel> mMapFeedBackDataList = null;
    private ArrayList<UgcBaseDataModel> mMapUgcDataList = null;
    private ArrayList<UgcBaseDataModel> mNaviUgcDataList = null;
    private ArrayList<UgcBaseDataModel> mNaviUgcDynamicDataList = null;
    ArrayList<UgcBaseDataModel> newRoadModelList = null;
    ArrayList<UgcBaseDataModel> speedLimitedModelList = null;
    ArrayList<UgcBaseDataModel> trafficRuleModelList = null;

    public static class ActBaseDataModel {
        public String bannerIconUrl = null;
        public String bannerTips = null;
        public String bottonTips = null;
        public String camaraIconUrl = null;
        public String camraTips = null;
        public String entryIconUrl = null;
        public String entryTips = null;

        public ActBaseDataModel(String entryIconUrl, String bannerIconUrl, String camaraIconUrl, String entryTips, String bannerTips, String camraTips, String bottonTips) {
            this.entryIconUrl = entryIconUrl;
            this.bannerIconUrl = bannerIconUrl;
            this.camaraIconUrl = camaraIconUrl;
            this.entryTips = entryTips;
            this.bannerTips = bannerTips;
            this.camraTips = camraTips;
            this.bottonTips = bottonTips;
        }
    }

    public static class CommonBaseDataModel {
        public String caramaIconUrl = null;
        public String caramaTitle = null;
        public String mapPointIconUrl = null;
        public String mapPointTitle = null;
        public String textLeft = null;
        public String textNew = null;
        public String textRight = null;

        public CommonBaseDataModel(String caramaTitle, String caramaIconUrl, String mapPointTitle, String mapPointIconUrl) {
            this.caramaTitle = caramaTitle;
            this.caramaIconUrl = caramaIconUrl;
            this.mapPointTitle = mapPointTitle;
            this.mapPointIconUrl = mapPointIconUrl;
        }

        public void setFeedbackStyle(String textLeft, String textRight, String textNew) {
            this.textLeft = textLeft;
            this.textRight = textRight;
            this.textNew = textNew;
        }
    }

    public static class UgcBaseDataModel {
        public String iconUrl;
        public String link = "";
        public String title;
        public int type;
        public ArrayList<UgcBaseDataModel> ugcSubDataDetail = null;
        public ArrayList<UgcBaseDataModel> ugcSubDataLane = null;
        public ArrayList<UgcBaseDataModel> ugcSubDataPosition = null;
        public ArrayList<UgcBaseDataModel> ugcSubDataSec = null;

        public UgcBaseDataModel(String title, int type, String iconUrl) {
            this.title = title;
            this.type = type;
            this.iconUrl = iconUrl;
        }
    }

    public static UgcDataRepository getInstance() {
        if (instance == null) {
            instance = new UgcDataRepository();
        }
        return instance;
    }

    public void initRepository() {
        initLayoutRepository();
        initCustomLayout();
    }

    private synchronized void initCustomLayout() {
        UgcBaseDataModel mainNewRoadModel = new UgcBaseDataModel("缺路", 1, null);
        mainNewRoadModel.ugcSubDataPosition = this.newRoadModelList;
        UgcBaseDataModel mainTrafficRuleModel = new UgcBaseDataModel("禁行", 2, null);
        mainTrafficRuleModel.ugcSubDataPosition = this.trafficRuleModelList;
        new UgcBaseDataModel("电子眼", 3, null).ugcSubDataPosition = this.elecEyeModelList;
        UgcBaseDataModel mainTrafficJamModel = new UgcBaseDataModel("拥堵", 4, null);
        mainTrafficJamModel.ugcSubDataLane = this.laneModelList1;
        mainTrafficJamModel.ugcSubDataDetail = this.detailModelList1;
        UgcBaseDataModel mainTrafficAccidentModel = new UgcBaseDataModel("事故", 5, null);
        mainTrafficAccidentModel.ugcSubDataDetail = this.detailModelList2;
        mainTrafficAccidentModel.ugcSubDataLane = this.laneModelList;
        UgcBaseDataModel mainRoadBuildModel = new UgcBaseDataModel("施工", 6, null);
        mainRoadBuildModel.ugcSubDataDetail = this.detailModelList3;
        mainRoadBuildModel.ugcSubDataLane = this.laneModelList;
        UgcBaseDataModel mainRoadClosedModel = new UgcBaseDataModel("封路", 7, null);
        mainRoadClosedModel.ugcSubDataDetail = this.detailModelList4;
        mainRoadClosedModel.ugcSubDataLane = this.laneModelList1;
        UgcBaseDataModel mainTrafficRegulateModel = new UgcBaseDataModel("管制", 8, null);
        UgcBaseDataModel mainPoliceModel = new UgcBaseDataModel("警察", 9, null);
        mainPoliceModel.ugcSubDataLane = this.laneModelList1;
        UgcBaseDataModel mainDangerousModel = new UgcBaseDataModel("危险", 10, null);
        mainDangerousModel.ugcSubDataDetail = this.detailModelList5;
        mainDangerousModel.ugcSubDataLane = this.laneModelList;
        new UgcBaseDataModel("限速", 15, null).ugcSubDataPosition = this.speedLimitedModelList;
        this.mMapUgcDataList = new ArrayList();
        this.mMapUgcDataList.add(mainTrafficAccidentModel);
        this.mMapUgcDataList.add(mainTrafficJamModel);
        this.mMapUgcDataList.add(mainPoliceModel);
        this.mMapUgcDataList.add(mainDangerousModel);
        this.mMapUgcDataList.add(mainRoadBuildModel);
        this.mMapUgcDataList.add(mainRoadClosedModel);
        this.mNaviUgcDataList = new ArrayList();
        this.mNaviUgcDataList.add(mainTrafficAccidentModel);
        this.mNaviUgcDataList.add(mainTrafficJamModel);
        this.mNaviUgcDataList.add(mainPoliceModel);
        this.mNaviUgcDataList.add(mainDangerousModel);
        this.mNaviUgcDataList.add(mainRoadBuildModel);
        this.mNaviUgcDataList.add(mainRoadClosedModel);
        this.mNaviUgcDynamicDataList = new ArrayList();
        this.mNaviUgcDynamicDataList.add(mainNewRoadModel);
        this.mNaviUgcDynamicDataList.add(mainTrafficRuleModel);
        createDefaultUgcSubData();
    }

    private void createDefaultUgcSubData() {
        this.mMapFeedBackDataList = new ArrayList();
        UgcBaseDataModel item = new UgcBaseDataModel("新增", 91, "");
        item.ugcSubDataSec = new ArrayList();
        item.ugcSubDataSec.add(new UgcBaseDataModel("新增地点", 91, "https://i.map.baidu.com/api/page/poicorrect/addpoi?business_trigger=28"));
        this.mMapFeedBackDataList.add(item);
        UgcBaseDataModel item1 = new UgcBaseDataModel("报错", 91, "");
        item1.ugcSubDataSec = new ArrayList();
        item1.ugcSubDataSec.add(new UgcBaseDataModel("地点报错", 92, "https://i.map.baidu.com/api/page/poicorrect/selectpoint?business_trigger=29"));
        item1.ugcSubDataSec.add(new UgcBaseDataModel("定位报错", 96, "http://loc.map.baidu.com/webroot/static/locationreport/index.html"));
        this.mMapFeedBackDataList.add(item1);
        UgcBaseDataModel feedback = new UgcBaseDataModel("建议", 93, "");
        feedback.link = "baidumap://map/showfeedback?";
        this.mMapFeedBackDataList.add(feedback);
    }

    private void initLayoutRepository() {
        this.newRoadModelList = new ArrayList();
        this.newRoadModelList.add(new UgcBaseDataModel("左侧缺路", 33, null));
        this.newRoadModelList.add(new UgcBaseDataModel("前方缺路", 34, null));
        this.newRoadModelList.add(new UgcBaseDataModel("右侧缺路", 35, null));
        this.trafficRuleModelList = new ArrayList();
        this.trafficRuleModelList.add(new UgcBaseDataModel("禁左转", 21, null));
        this.trafficRuleModelList.add(new UgcBaseDataModel("禁掉头", 22, null));
        this.trafficRuleModelList.add(new UgcBaseDataModel("禁右转", 23, null));
        this.trafficRuleModelList.add(new UgcBaseDataModel("单行线", 36, null));
        this.elecEyeModelList = new ArrayList();
        this.elecEyeModelList.add(new UgcBaseDataModel("缺失", 37, null));
        this.elecEyeModelList.add(new UgcBaseDataModel("多报", 38, null));
        this.elecEyeModelList.add(new UgcBaseDataModel("错误", 39, null));
        this.speedLimitedModelList = new ArrayList();
        this.speedLimitedModelList.add(new UgcBaseDataModel("60", 60, null));
        this.speedLimitedModelList.add(new UgcBaseDataModel("70", 70, null));
        this.speedLimitedModelList.add(new UgcBaseDataModel("80", 80, null));
        this.speedLimitedModelList.add(new UgcBaseDataModel("100", 100, null));
        this.laneModelList = new ArrayList();
        this.laneModelList.add(new UgcBaseDataModel("左侧车道", 32, null));
        this.laneModelList.add(new UgcBaseDataModel("中间车道", 31, null));
        this.laneModelList.add(new UgcBaseDataModel("右侧车道", 30, null));
        this.laneModelList.add(new UgcBaseDataModel("对向车道", 27, null));
        this.laneModelList1 = new ArrayList();
        this.laneModelList1.add(new UgcBaseDataModel("同向车道", 28, null));
        this.laneModelList1.add(new UgcBaseDataModel("对向车道", 27, null));
        this.detailModelList1 = new ArrayList();
        this.detailModelList1.add(new UgcBaseDataModel("轻微拥堵", 41, null));
        this.detailModelList1.add(new UgcBaseDataModel("缓慢行驶", 42, null));
        this.detailModelList1.add(new UgcBaseDataModel("堵住不动", 43, null));
        this.detailModelList2 = new ArrayList();
        this.detailModelList2.add(new UgcBaseDataModel("追尾", 44, null));
        this.detailModelList2.add(new UgcBaseDataModel("剐蹭", 45, null));
        this.detailModelList2.add(new UgcBaseDataModel("故障", 46, null));
        this.detailModelList2.add(new UgcBaseDataModel("严重事故", 47, null));
        this.detailModelList3 = new ArrayList();
        this.detailModelList3.add(new UgcBaseDataModel("可以通行", 48, null));
        this.detailModelList3.add(new UgcBaseDataModel("不能通行", 49, null));
        this.detailModelList4 = new ArrayList();
        this.detailModelList4.add(new UgcBaseDataModel("临时封路", 56, null));
        this.detailModelList4.add(new UgcBaseDataModel("长期封路", 57, null));
        this.detailModelList4.add(new UgcBaseDataModel("分时段封路", 58, null));
        this.detailModelList5 = new ArrayList();
        this.detailModelList5.add(new UgcBaseDataModel("积水", 53, null));
        this.detailModelList5.add(new UgcBaseDataModel("路坑", 54, null));
        this.detailModelList5.add(new UgcBaseDataModel("障碍物", 55, null));
    }

    public void addMapUgcBaseDataModel(UgcBaseDataModel mUgcBaseDataModel) {
        if (this.mMapUgcDataList == null) {
            this.mMapUgcDataList = new ArrayList();
        }
        if (this.mMapUgcDataList != null) {
            this.mMapUgcDataList.add(mUgcBaseDataModel);
        }
    }

    public void addNaviUgcBaseDataModel(UgcBaseDataModel mUgcBaseDataModel) {
        if (this.mNaviUgcDataList == null) {
            this.mNaviUgcDataList = new ArrayList();
        }
        if (this.mNaviUgcDataList != null) {
            this.mNaviUgcDataList.add(mUgcBaseDataModel);
        }
    }

    public CommonBaseDataModel getCommonBaseDataModel() {
        return this.mCommonBaseDataModel;
    }

    public void setCommonBaseDataModel(CommonBaseDataModel mCommonBaseDataModel) {
        this.mCommonBaseDataModel = mCommonBaseDataModel;
    }

    public ActBaseDataModel getActBaseDataModel() {
        return this.mActBaseDataModel;
    }

    public void setActBaseDataModel(ActBaseDataModel mActBaseDataModel) {
        this.mActBaseDataModel = mActBaseDataModel;
    }

    public void setmMapUgcDataList(ArrayList<UgcBaseDataModel> mMapUgcDataList) {
        this.mMapUgcDataList = mMapUgcDataList;
    }

    public void setmNaviUgcDataList(ArrayList<UgcBaseDataModel> mNaviUgcDataList) {
        this.mNaviUgcDataList = mNaviUgcDataList;
    }

    public ArrayList<UgcBaseDataModel> obtainMapUgcDataList() {
        if (this.mMapUgcDataList == null) {
            initRepository();
        }
        return this.mMapUgcDataList;
    }

    public ArrayList<UgcBaseDataModel> obtainNaviUgcDataList() {
        if (this.mNaviUgcDataList == null) {
            initRepository();
        }
        return this.mNaviUgcDataList;
    }

    public ArrayList<UgcBaseDataModel> obtainNaviDynamicUgcDataList() {
        if (this.mNaviUgcDynamicDataList == null) {
            initRepository();
        }
        return this.mNaviUgcDynamicDataList;
    }

    public ArrayList<UgcBaseDataModel> obtainMapFeedBackDataList() {
        if (this.mMapFeedBackDataList == null) {
            initRepository();
        }
        return this.mMapFeedBackDataList;
    }

    public synchronized boolean parseCloudJson(JSONObject data) {
        boolean z;
        try {
            int i;
            JSONObject mJSONObject;
            JSONArray ugcMapJsonArr = data.getJSONArray("ugc_map");
            JSONArray ugcNaviJsonArr = data.getJSONArray("ugc_navi");
            JSONArray ugcNaviRoadJsonArr = data.getJSONArray("ugc_navi_road");
            this.mMapUgcDataList = new ArrayList();
            this.mNaviUgcDataList = new ArrayList();
            this.mNaviUgcDynamicDataList = new ArrayList();
            this.mMapFeedBackDataList = new ArrayList();
            if (ugcMapJsonArr != null) {
                for (i = 0; i < ugcMapJsonArr.length(); i++) {
                    mJSONObject = ugcMapJsonArr.getJSONObject(i);
                    this.mMapUgcDataList.add(new UgcBaseDataModel(mJSONObject.getString("title"), mJSONObject.getInt("type"), mJSONObject.getString(HUDGuideDataStruct.KEY_ICON_NAME)));
                }
            }
            if (ugcNaviJsonArr != null) {
                for (i = 0; i < ugcNaviJsonArr.length(); i++) {
                    mJSONObject = ugcNaviJsonArr.getJSONObject(i);
                    this.mNaviUgcDataList.add(new UgcBaseDataModel(mJSONObject.getString("title"), mJSONObject.getInt("type"), mJSONObject.getString(HUDGuideDataStruct.KEY_ICON_NAME)));
                }
            }
            if (ugcNaviRoadJsonArr != null) {
                for (i = 0; i < ugcNaviRoadJsonArr.length(); i++) {
                    mJSONObject = ugcNaviRoadJsonArr.getJSONObject(i);
                    this.mNaviUgcDynamicDataList.add(new UgcBaseDataModel(mJSONObject.getString("title"), mJSONObject.getInt("type"), mJSONObject.getString(HUDGuideDataStruct.KEY_ICON_NAME)));
                }
            }
            parseMainFeedBackData(data);
            JSONObject ugcActJson = data.optJSONObject("ugc_act");
            if (ugcActJson != null) {
                this.mActBaseDataModel = new ActBaseDataModel(ugcActJson.getString("entry_icon"), null, null, null, null, null, ugcActJson.getString("botton_tips"));
            }
            z = true;
        } catch (Exception e) {
            this.mMapUgcDataList = null;
            this.mNaviUgcDataList = null;
            this.mNaviUgcDynamicDataList = null;
            this.mMapFeedBackDataList = null;
            z = false;
        }
        return z;
    }

    private void parseMainFeedBackData(JSONObject data) {
        try {
            JSONArray ugcMapFeedBackJsonArr = data.getJSONArray("map_feedback_new");
            if (ugcMapFeedBackJsonArr != null) {
                for (int i = 0; i < ugcMapFeedBackJsonArr.length(); i++) {
                    JSONObject mJSONObject = ugcMapFeedBackJsonArr.getJSONObject(i);
                    UgcBaseDataModel item = new UgcBaseDataModel(mJSONObject.getString("title"), mJSONObject.optInt("type"), mJSONObject.getString(HUDGuideDataStruct.KEY_ICON_NAME));
                    item.ugcSubDataSec = new ArrayList();
                    JSONArray subitems = mJSONObject.optJSONArray("sheetContent");
                    if (subitems != null && subitems.length() > 0) {
                        for (int j = 0; j < subitems.length(); j++) {
                            JSONObject subitem = subitems.getJSONObject(j);
                            item.ugcSubDataSec.add(new UgcBaseDataModel(subitem.getString("title"), mJSONObject.optInt("type"), subitem.getString("link")));
                        }
                    }
                    item.link = mJSONObject.optString("link");
                    this.mMapFeedBackDataList.add(item);
                }
            }
        } catch (Exception e) {
            this.mMapFeedBackDataList = null;
        }
    }

    public void update() {
        if (this.mMapUgcDataList != null && this.mNaviUgcDataList != null && this.mNaviUgcDynamicDataList != null) {
            initLayoutRepository();
            initCloudLayout();
        }
    }

    private void initCloudLayout() {
        if (this.mMapUgcDataList != null && this.mNaviUgcDataList != null && this.mNaviUgcDynamicDataList != null) {
            int i;
            for (i = 0; i < this.mMapUgcDataList.size(); i++) {
                initUgcBaseDataModel((UgcBaseDataModel) this.mMapUgcDataList.get(i));
            }
            for (i = 0; i < this.mNaviUgcDataList.size(); i++) {
                initUgcBaseDataModel((UgcBaseDataModel) this.mNaviUgcDataList.get(i));
            }
            for (i = 0; i < this.mNaviUgcDynamicDataList.size(); i++) {
                initUgcBaseDataModel((UgcBaseDataModel) this.mNaviUgcDynamicDataList.get(i));
            }
        }
    }

    private void initUgcBaseDataModel(UgcBaseDataModel mUgcBaseDataModel) {
        if (mUgcBaseDataModel != null) {
            switch (mUgcBaseDataModel.type) {
                case 1:
                    mUgcBaseDataModel.ugcSubDataPosition = this.newRoadModelList;
                    return;
                case 2:
                    mUgcBaseDataModel.ugcSubDataPosition = this.trafficRuleModelList;
                    return;
                case 3:
                    mUgcBaseDataModel.ugcSubDataPosition = this.elecEyeModelList;
                    return;
                case 4:
                    mUgcBaseDataModel.ugcSubDataLane = this.laneModelList1;
                    mUgcBaseDataModel.ugcSubDataDetail = this.detailModelList1;
                    return;
                case 5:
                    mUgcBaseDataModel.ugcSubDataDetail = this.detailModelList2;
                    mUgcBaseDataModel.ugcSubDataLane = this.laneModelList;
                    return;
                case 6:
                    mUgcBaseDataModel.ugcSubDataLane = this.laneModelList;
                    mUgcBaseDataModel.ugcSubDataDetail = this.detailModelList3;
                    return;
                case 7:
                    mUgcBaseDataModel.ugcSubDataLane = this.laneModelList1;
                    mUgcBaseDataModel.ugcSubDataDetail = this.detailModelList4;
                    return;
                case 8:
                    return;
                case 9:
                    mUgcBaseDataModel.ugcSubDataLane = this.laneModelList1;
                    return;
                case 10:
                    mUgcBaseDataModel.ugcSubDataDetail = this.detailModelList5;
                    mUgcBaseDataModel.ugcSubDataLane = this.laneModelList;
                    return;
                case 15:
                    mUgcBaseDataModel.ugcSubDataPosition = this.speedLimitedModelList;
                    return;
                default:
                    return;
            }
        }
    }
}
