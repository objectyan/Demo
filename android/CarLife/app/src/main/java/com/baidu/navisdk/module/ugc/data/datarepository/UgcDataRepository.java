package com.baidu.navisdk.module.ugc.data.datarepository;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class UgcDataRepository
{
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
  
  private void createDefaultUgcSubData()
  {
    this.mMapFeedBackDataList = new ArrayList();
    UgcBaseDataModel localUgcBaseDataModel = new UgcBaseDataModel("新增", 91, "");
    localUgcBaseDataModel.ugcSubDataSec = new ArrayList();
    localUgcBaseDataModel.ugcSubDataSec.add(new UgcBaseDataModel("新增地点", 91, "https://i.map.baidu.com/api/page/poicorrect/addpoi?business_trigger=28"));
    this.mMapFeedBackDataList.add(localUgcBaseDataModel);
    localUgcBaseDataModel = new UgcBaseDataModel("报错", 91, "");
    localUgcBaseDataModel.ugcSubDataSec = new ArrayList();
    localUgcBaseDataModel.ugcSubDataSec.add(new UgcBaseDataModel("地点报错", 92, "https://i.map.baidu.com/api/page/poicorrect/selectpoint?business_trigger=29"));
    localUgcBaseDataModel.ugcSubDataSec.add(new UgcBaseDataModel("定位报错", 96, "http://loc.map.baidu.com/webroot/static/locationreport/index.html"));
    this.mMapFeedBackDataList.add(localUgcBaseDataModel);
    localUgcBaseDataModel = new UgcBaseDataModel("建议", 93, "");
    localUgcBaseDataModel.link = "baidumap://map/showfeedback?";
    this.mMapFeedBackDataList.add(localUgcBaseDataModel);
  }
  
  public static UgcDataRepository getInstance()
  {
    if (instance == null) {
      instance = new UgcDataRepository();
    }
    return instance;
  }
  
  private void initCloudLayout()
  {
    if ((this.mMapUgcDataList == null) || (this.mNaviUgcDataList == null) || (this.mNaviUgcDynamicDataList == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mMapUgcDataList.size())
      {
        initUgcBaseDataModel((UgcBaseDataModel)this.mMapUgcDataList.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.mNaviUgcDataList.size())
      {
        initUgcBaseDataModel((UgcBaseDataModel)this.mNaviUgcDataList.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.mNaviUgcDynamicDataList.size())
      {
        initUgcBaseDataModel((UgcBaseDataModel)this.mNaviUgcDynamicDataList.get(i));
        i += 1;
      }
    }
  }
  
  private void initCustomLayout()
  {
    try
    {
      UgcBaseDataModel localUgcBaseDataModel1 = new UgcBaseDataModel("缺路", 1, null);
      localUgcBaseDataModel1.ugcSubDataPosition = this.newRoadModelList;
      UgcBaseDataModel localUgcBaseDataModel2 = new UgcBaseDataModel("禁行", 2, null);
      localUgcBaseDataModel2.ugcSubDataPosition = this.trafficRuleModelList;
      new UgcBaseDataModel("电子眼", 3, null).ugcSubDataPosition = this.elecEyeModelList;
      UgcBaseDataModel localUgcBaseDataModel3 = new UgcBaseDataModel("拥堵", 4, null);
      localUgcBaseDataModel3.ugcSubDataLane = this.laneModelList1;
      localUgcBaseDataModel3.ugcSubDataDetail = this.detailModelList1;
      UgcBaseDataModel localUgcBaseDataModel4 = new UgcBaseDataModel("事故", 5, null);
      localUgcBaseDataModel4.ugcSubDataDetail = this.detailModelList2;
      localUgcBaseDataModel4.ugcSubDataLane = this.laneModelList;
      UgcBaseDataModel localUgcBaseDataModel5 = new UgcBaseDataModel("施工", 6, null);
      localUgcBaseDataModel5.ugcSubDataDetail = this.detailModelList3;
      localUgcBaseDataModel5.ugcSubDataLane = this.laneModelList;
      UgcBaseDataModel localUgcBaseDataModel6 = new UgcBaseDataModel("封路", 7, null);
      localUgcBaseDataModel6.ugcSubDataDetail = this.detailModelList4;
      localUgcBaseDataModel6.ugcSubDataLane = this.laneModelList1;
      new UgcBaseDataModel("管制", 8, null);
      UgcBaseDataModel localUgcBaseDataModel7 = new UgcBaseDataModel("警察", 9, null);
      localUgcBaseDataModel7.ugcSubDataLane = this.laneModelList1;
      UgcBaseDataModel localUgcBaseDataModel8 = new UgcBaseDataModel("危险", 10, null);
      localUgcBaseDataModel8.ugcSubDataDetail = this.detailModelList5;
      localUgcBaseDataModel8.ugcSubDataLane = this.laneModelList;
      new UgcBaseDataModel("限速", 15, null).ugcSubDataPosition = this.speedLimitedModelList;
      this.mMapUgcDataList = new ArrayList();
      this.mMapUgcDataList.add(localUgcBaseDataModel4);
      this.mMapUgcDataList.add(localUgcBaseDataModel3);
      this.mMapUgcDataList.add(localUgcBaseDataModel7);
      this.mMapUgcDataList.add(localUgcBaseDataModel8);
      this.mMapUgcDataList.add(localUgcBaseDataModel5);
      this.mMapUgcDataList.add(localUgcBaseDataModel6);
      this.mNaviUgcDataList = new ArrayList();
      this.mNaviUgcDataList.add(localUgcBaseDataModel4);
      this.mNaviUgcDataList.add(localUgcBaseDataModel3);
      this.mNaviUgcDataList.add(localUgcBaseDataModel7);
      this.mNaviUgcDataList.add(localUgcBaseDataModel8);
      this.mNaviUgcDataList.add(localUgcBaseDataModel5);
      this.mNaviUgcDataList.add(localUgcBaseDataModel6);
      this.mNaviUgcDynamicDataList = new ArrayList();
      this.mNaviUgcDynamicDataList.add(localUgcBaseDataModel1);
      this.mNaviUgcDynamicDataList.add(localUgcBaseDataModel2);
      createDefaultUgcSubData();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void initLayoutRepository()
  {
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
  
  private void initUgcBaseDataModel(UgcBaseDataModel paramUgcBaseDataModel)
  {
    if (paramUgcBaseDataModel == null) {
      return;
    }
    switch (paramUgcBaseDataModel.type)
    {
    case 8: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      return;
    case 1: 
      paramUgcBaseDataModel.ugcSubDataPosition = this.newRoadModelList;
      return;
    case 2: 
      paramUgcBaseDataModel.ugcSubDataPosition = this.trafficRuleModelList;
      return;
    case 3: 
      paramUgcBaseDataModel.ugcSubDataPosition = this.elecEyeModelList;
      return;
    case 4: 
      paramUgcBaseDataModel.ugcSubDataLane = this.laneModelList1;
      paramUgcBaseDataModel.ugcSubDataDetail = this.detailModelList1;
      return;
    case 5: 
      paramUgcBaseDataModel.ugcSubDataDetail = this.detailModelList2;
      paramUgcBaseDataModel.ugcSubDataLane = this.laneModelList;
      return;
    case 6: 
      paramUgcBaseDataModel.ugcSubDataLane = this.laneModelList;
      paramUgcBaseDataModel.ugcSubDataDetail = this.detailModelList3;
      return;
    case 7: 
      paramUgcBaseDataModel.ugcSubDataLane = this.laneModelList1;
      paramUgcBaseDataModel.ugcSubDataDetail = this.detailModelList4;
      return;
    case 9: 
      paramUgcBaseDataModel.ugcSubDataLane = this.laneModelList1;
      return;
    case 10: 
      paramUgcBaseDataModel.ugcSubDataDetail = this.detailModelList5;
      paramUgcBaseDataModel.ugcSubDataLane = this.laneModelList;
      return;
    }
    paramUgcBaseDataModel.ugcSubDataPosition = this.speedLimitedModelList;
  }
  
  private void parseMainFeedBackData(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("map_feedback_new");
      if (paramJSONObject != null)
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
          UgcBaseDataModel localUgcBaseDataModel = new UgcBaseDataModel(localJSONObject1.getString("title"), localJSONObject1.optInt("type"), localJSONObject1.getString("icon"));
          localUgcBaseDataModel.ugcSubDataSec = new ArrayList();
          JSONArray localJSONArray = localJSONObject1.optJSONArray("sheetContent");
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            int j = 0;
            while (j < localJSONArray.length())
            {
              JSONObject localJSONObject2 = localJSONArray.getJSONObject(j);
              localUgcBaseDataModel.ugcSubDataSec.add(new UgcBaseDataModel(localJSONObject2.getString("title"), localJSONObject1.optInt("type"), localJSONObject2.getString("link")));
              j += 1;
            }
          }
          localUgcBaseDataModel.link = localJSONObject1.optString("link");
          this.mMapFeedBackDataList.add(localUgcBaseDataModel);
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      this.mMapFeedBackDataList = null;
    }
  }
  
  public void addMapUgcBaseDataModel(UgcBaseDataModel paramUgcBaseDataModel)
  {
    if (this.mMapUgcDataList == null) {
      this.mMapUgcDataList = new ArrayList();
    }
    if (this.mMapUgcDataList != null) {
      this.mMapUgcDataList.add(paramUgcBaseDataModel);
    }
  }
  
  public void addNaviUgcBaseDataModel(UgcBaseDataModel paramUgcBaseDataModel)
  {
    if (this.mNaviUgcDataList == null) {
      this.mNaviUgcDataList = new ArrayList();
    }
    if (this.mNaviUgcDataList != null) {
      this.mNaviUgcDataList.add(paramUgcBaseDataModel);
    }
  }
  
  public ActBaseDataModel getActBaseDataModel()
  {
    return this.mActBaseDataModel;
  }
  
  public CommonBaseDataModel getCommonBaseDataModel()
  {
    return this.mCommonBaseDataModel;
  }
  
  public void initRepository()
  {
    initLayoutRepository();
    initCustomLayout();
  }
  
  public ArrayList<UgcBaseDataModel> obtainMapFeedBackDataList()
  {
    if (this.mMapFeedBackDataList == null) {
      initRepository();
    }
    return this.mMapFeedBackDataList;
  }
  
  public ArrayList<UgcBaseDataModel> obtainMapUgcDataList()
  {
    if (this.mMapUgcDataList == null) {
      initRepository();
    }
    return this.mMapUgcDataList;
  }
  
  public ArrayList<UgcBaseDataModel> obtainNaviDynamicUgcDataList()
  {
    if (this.mNaviUgcDynamicDataList == null) {
      initRepository();
    }
    return this.mNaviUgcDynamicDataList;
  }
  
  public ArrayList<UgcBaseDataModel> obtainNaviUgcDataList()
  {
    if (this.mNaviUgcDataList == null) {
      initRepository();
    }
    return this.mNaviUgcDataList;
  }
  
  public boolean parseCloudJson(JSONObject paramJSONObject)
  {
    for (;;)
    {
      Object localObject1;
      JSONArray localJSONArray;
      int i;
      try
      {
        Object localObject2 = paramJSONObject.getJSONArray("ugc_map");
        localObject1 = paramJSONObject.getJSONArray("ugc_navi");
        localJSONArray = paramJSONObject.getJSONArray("ugc_navi_road");
        this.mMapUgcDataList = new ArrayList();
        this.mNaviUgcDataList = new ArrayList();
        this.mNaviUgcDynamicDataList = new ArrayList();
        this.mMapFeedBackDataList = new ArrayList();
        if (localObject2 == null) {
          break label353;
        }
        i = 0;
        if (i >= ((JSONArray)localObject2).length()) {
          break label353;
        }
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
        this.mMapUgcDataList.add(new UgcBaseDataModel(localJSONObject.getString("title"), localJSONObject.getInt("type"), localJSONObject.getString("icon")));
        i += 1;
        continue;
        if (i >= ((JSONArray)localObject1).length()) {
          break label363;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        this.mNaviUgcDataList.add(new UgcBaseDataModel(((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getInt("type"), ((JSONObject)localObject2).getString("icon")));
        i += 1;
        continue;
        if (i < localJSONArray.length())
        {
          localObject1 = localJSONArray.getJSONObject(i);
          this.mNaviUgcDynamicDataList.add(new UgcBaseDataModel(((JSONObject)localObject1).getString("title"), ((JSONObject)localObject1).getInt("type"), ((JSONObject)localObject1).getString("icon")));
          i += 1;
          continue;
        }
        parseMainFeedBackData(paramJSONObject);
        paramJSONObject = paramJSONObject.optJSONObject("ugc_act");
        if (paramJSONObject != null) {
          this.mActBaseDataModel = new ActBaseDataModel(paramJSONObject.getString("entry_icon"), null, null, null, null, null, paramJSONObject.getString("botton_tips"));
        }
        bool = true;
      }
      catch (Exception paramJSONObject)
      {
        this.mMapUgcDataList = null;
        this.mNaviUgcDataList = null;
        this.mNaviUgcDynamicDataList = null;
        this.mMapFeedBackDataList = null;
        boolean bool = false;
        continue;
      }
      finally {}
      return bool;
      label353:
      if (localObject1 != null) {
        i = 0;
      } else {
        label363:
        if (localJSONArray != null) {
          i = 0;
        }
      }
    }
  }
  
  public void setActBaseDataModel(ActBaseDataModel paramActBaseDataModel)
  {
    this.mActBaseDataModel = paramActBaseDataModel;
  }
  
  public void setCommonBaseDataModel(CommonBaseDataModel paramCommonBaseDataModel)
  {
    this.mCommonBaseDataModel = paramCommonBaseDataModel;
  }
  
  public void setmMapUgcDataList(ArrayList<UgcBaseDataModel> paramArrayList)
  {
    this.mMapUgcDataList = paramArrayList;
  }
  
  public void setmNaviUgcDataList(ArrayList<UgcBaseDataModel> paramArrayList)
  {
    this.mNaviUgcDataList = paramArrayList;
  }
  
  public void update()
  {
    if ((this.mMapUgcDataList == null) || (this.mNaviUgcDataList == null) || (this.mNaviUgcDynamicDataList == null)) {
      return;
    }
    initLayoutRepository();
    initCloudLayout();
  }
  
  public static class ActBaseDataModel
  {
    public String bannerIconUrl = null;
    public String bannerTips = null;
    public String bottonTips = null;
    public String camaraIconUrl = null;
    public String camraTips = null;
    public String entryIconUrl = null;
    public String entryTips = null;
    
    public ActBaseDataModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      this.entryIconUrl = paramString1;
      this.bannerIconUrl = paramString2;
      this.camaraIconUrl = paramString3;
      this.entryTips = paramString4;
      this.bannerTips = paramString5;
      this.camraTips = paramString6;
      this.bottonTips = paramString7;
    }
  }
  
  public static class CommonBaseDataModel
  {
    public String caramaIconUrl = null;
    public String caramaTitle = null;
    public String mapPointIconUrl = null;
    public String mapPointTitle = null;
    public String textLeft = null;
    public String textNew = null;
    public String textRight = null;
    
    public CommonBaseDataModel(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.caramaTitle = paramString1;
      this.caramaIconUrl = paramString2;
      this.mapPointTitle = paramString3;
      this.mapPointIconUrl = paramString4;
    }
    
    public void setFeedbackStyle(String paramString1, String paramString2, String paramString3)
    {
      this.textLeft = paramString1;
      this.textRight = paramString2;
      this.textNew = paramString3;
    }
  }
  
  public static class UgcBaseDataModel
  {
    public String iconUrl;
    public String link = "";
    public String title;
    public int type;
    public ArrayList<UgcBaseDataModel> ugcSubDataDetail = null;
    public ArrayList<UgcBaseDataModel> ugcSubDataLane = null;
    public ArrayList<UgcBaseDataModel> ugcSubDataPosition = null;
    public ArrayList<UgcBaseDataModel> ugcSubDataSec = null;
    
    public UgcBaseDataModel(String paramString1, int paramInt, String paramString2)
    {
      this.title = paramString1;
      this.type = paramInt;
      this.iconUrl = paramString2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/data/datarepository/UgcDataRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */