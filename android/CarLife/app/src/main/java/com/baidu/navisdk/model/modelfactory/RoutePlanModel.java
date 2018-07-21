package com.baidu.navisdk.model.modelfactory;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
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
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoutePlanModel
  extends BaseModel
{
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
  public List<RGRouteItemModel.RouteItem> mNavingBrowseRoutItems = null;
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
  
  private void cancelDistrictThread()
  {
    BNWorkerCenter.getInstance().cancelTask(this.mDistrictTask, true);
    this.mDistrictTask = null;
  }
  
  public static RoutePlanNode changeToRoutePlanNode(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return new RoutePlanNode();
    }
    return new RoutePlanNode(paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
  }
  
  public static String htmlRemoveTag(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace("font", "null");
  }
  
  private String parserLableId(int paramInt)
  {
    if (paramInt <= 1) {
      return "";
    }
    switch (paramInt)
    {
    default: 
      return "推荐";
    case 2: 
      return "高速优先";
    case 4: 
      return "不走高速";
    case 8: 
      return "少收费";
    }
    return "躲避拥堵";
  }
  
  public void clearPointPoiDetail()
  {
    this.bIsPoiDetail = false;
    this.mPointByPoiDetail.mName = "";
    this.mPointByPoiDetail.mDescription = "";
    this.mPointByPoiDetail.mGeoPoint = new GeoPoint();
    this.mPointByPoiDetail.mFrom = 0;
    this.mPointByPoiDetail.mViewPoint = null;
    this.mPointByPoiDetail.clearSubPoiList();
  }
  
  public void clearRouteInput()
  {
    cancelDistrictThread();
    this.mRoutePlanNodeList.clear();
  }
  
  public void clearRouteOutLineResult()
  {
    this.mRouteOutlineItemList.clear();
  }
  
  public void clearRouteResult()
  {
    LogUtil.e("wangyang", "clearRouteResult");
    this.mAllRoutePlanInfo.clear();
    this.mRouteOutlineItemList.clear();
    this.mCurRouteIndex = 0;
  }
  
  public void clearSelectNode()
  {
    this.sIsSelectNode = false;
    this.mPointSelectNode.clearSelectNode();
  }
  
  public boolean getAvoidTrafficjamEnable()
  {
    final ArrayList localArrayList1 = getRouteInput();
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      ArrayList localArrayList2 = new ArrayList();
      int j = localArrayList1.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (RoutePlanNode)localArrayList1.get(i);
        if ((localObject != null) && (((RoutePlanNode)localObject).isNodeSettedData()))
        {
          localObject = BNPoiSearcher.getInstance().getDistrictByPoint(((RoutePlanNode)localObject).mGeoPoint, 0);
          if ((localObject != null) && (((DistrictInfo)localObject).mType == 3) && (!localArrayList2.contains(Integer.valueOf(((DistrictInfo)localObject).mId)))) {
            localArrayList2.add(Integer.valueOf(((DistrictInfo)localObject).mId));
          }
        }
        i += 1;
      }
      if (1 == localArrayList2.size())
      {
        i = ((Integer)localArrayList2.get(0)).intValue();
        LogUtil.e("RoutePlan", "cityinfo.cityID = " + i);
        if (BNMapController.getInstance().checkRoadConditionSupport(i)) {
          return true;
        }
      }
    }
    else
    {
      cancelDistrictThread();
      this.mDistrictTask = new BNWorkerNormalTask("CarNavi-DistrictTask", null)
      {
        protected String execute()
        {
          ArrayList localArrayList = new ArrayList();
          int j = localArrayList1.size();
          int i = 0;
          while (i < j)
          {
            Object localObject = (RoutePlanNode)localArrayList1.get(i);
            if ((localObject != null) && (((RoutePlanNode)localObject).isNodeSettedData()))
            {
              localObject = BNPoiSearcher.getInstance().getDistrictByPoint(((RoutePlanNode)localObject).mGeoPoint, 1);
              if ((localObject != null) && (((DistrictInfo)localObject).mType == 3) && (!localArrayList.contains(Integer.valueOf(((DistrictInfo)localObject).mId)))) {
                localArrayList.add(Integer.valueOf(((DistrictInfo)localObject).mId));
              }
            }
            i += 1;
          }
          if (1 == localArrayList.size())
          {
            i = ((Integer)localArrayList.get(0)).intValue();
            LogUtil.e(TAG, "mDistrictThread cityinfo.cityID = " + i);
            if (!BNMapController.getInstance().checkRoadConditionSupport(i)) {}
          }
          return null;
        }
      };
      BNWorkerCenter.getInstance().submitNormalTask(this.mDistrictTask, new BNWorkerConfig(101, 0));
    }
    return false;
  }
  
  public int getCurIndex()
  {
    return this.mCurRouteIndex;
  }
  
  public String getDistance()
  {
    if (hasParseRouteDetail(this.mCurRouteIndex))
    {
      localObject = new StringBuffer();
      StringUtils.formatDistance(((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance, StringUtils.UnitLangEnum.ZH, (StringBuffer)localObject);
      return ((StringBuffer)localObject).toString();
    }
    Object localObject = getRoutePlanBundle();
    if (localObject != null)
    {
      parseRouteResult(BNaviModuleManager.getContext(), (Bundle)localObject);
      if (hasParseRouteDetail(this.mCurRouteIndex))
      {
        localObject = new StringBuffer();
        StringUtils.formatDistance(((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance, StringUtils.UnitLangEnum.ZH, (StringBuffer)localObject);
        return ((StringBuffer)localObject).toString();
      }
      return "";
    }
    return "";
  }
  
  public int getEnComfrom()
  {
    return this.enComfrom;
  }
  
  public int getEnNaviType()
  {
    return this.enNaviType;
  }
  
  public String getEndName(Context paramContext, boolean paramBoolean)
  {
    if (this.mRoutePlanNodeList.size() <= 1) {
      return "";
    }
    return getNodeName(paramContext, (RoutePlanNode)this.mRoutePlanNodeList.get(this.mRoutePlanNodeList.size() - 1), paramBoolean);
  }
  
  public RoutePlanNode getEndNode()
  {
    if (this.mRoutePlanNodeList.size() <= 1) {
      return null;
    }
    return (RoutePlanNode)this.mRoutePlanNodeList.get(this.mRoutePlanNodeList.size() - 1);
  }
  
  public int getFirstRemainDist()
  {
    int j = 0;
    int i;
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      i = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstRemainDist;
    }
    do
    {
      Bundle localBundle;
      do
      {
        return i;
        localBundle = getRoutePlanBundle();
        i = j;
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      i = j;
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstRemainDist;
  }
  
  public String getFirstRoadName()
  {
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstRoadName;
    }
    Bundle localBundle = getRoutePlanBundle();
    if (localBundle != null)
    {
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      if (hasParseRouteDetail(this.mCurRouteIndex)) {
        return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstRoadName;
      }
      return "";
    }
    return "";
  }
  
  public int getFirstTurnType()
  {
    int j = 0;
    int i;
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      i = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstTurnType;
    }
    do
    {
      Bundle localBundle;
      do
      {
        return i;
        localBundle = getRoutePlanBundle();
        i = j;
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      i = j;
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mFirstTurnType;
  }
  
  public int getGasMoney()
  {
    int j = 0;
    int i;
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      i = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mGasMoney;
    }
    do
    {
      Bundle localBundle;
      do
      {
        return i;
        localBundle = getRoutePlanBundle();
        i = j;
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      i = j;
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mGasMoney;
  }
  
  public String getMainRoads()
  {
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mMainRoads;
    }
    Bundle localBundle = getRoutePlanBundle();
    if (localBundle != null)
    {
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      if (hasParseRouteDetail(this.mCurRouteIndex)) {
        return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mMainRoads;
      }
      return "";
    }
    return "";
  }
  
  public String getMultiRouteCurrentMSRL()
  {
    return this.mCurrentMRSL;
  }
  
  public String getNodeName(Context paramContext, RoutePlanNode paramRoutePlanNode, boolean paramBoolean)
  {
    String str = "";
    if ((paramRoutePlanNode == null) || (paramContext == null) || (!paramRoutePlanNode.isNodeSettedData())) {
      return "";
    }
    try
    {
      switch (paramRoutePlanNode.mFrom)
      {
      case 2: 
        if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {
          paramContext = JarUtils.getResources().getString(1711669365);
        }
      case 3: 
      case 4: 
      case 5: 
      case 1: 
        for (;;)
        {
          paramRoutePlanNode = paramContext;
          if (paramBoolean)
          {
            paramRoutePlanNode = paramContext;
            if (paramContext.length() > 6) {
              paramRoutePlanNode = paramContext.substring(0, 6) + "...";
            }
          }
          return paramRoutePlanNode;
          if (StringUtils.isEmpty(paramRoutePlanNode.mName))
          {
            paramContext = JarUtils.getResources().getString(1711669559);
            break;
          }
          paramContext = paramRoutePlanNode.mName;
          break;
          paramContext = JarUtils.getResources().getString(1711669557);
          continue;
          paramContext = JarUtils.getResources().getString(1711669558);
          continue;
          if (StringUtils.isEmpty(paramRoutePlanNode.mName))
          {
            paramContext = JarUtils.getResources().getString(1711669560);
            break label244;
          }
          paramContext = paramRoutePlanNode.mName;
          break label244;
          paramContext = paramRoutePlanNode.mName;
        }
      }
    }
    catch (Exception paramContext)
    {
      label244:
      for (;;)
      {
        LogUtil.e("RoutePlan", paramContext.toString());
        paramContext = str;
        continue;
        continue;
      }
    }
  }
  
  public int getNodeNum()
  {
    int j = 0;
    int i;
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      i = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum;
    }
    do
    {
      Bundle localBundle;
      do
      {
        return i;
        localBundle = getRoutePlanBundle();
        i = j;
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      i = j;
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum;
  }
  
  public RoutePlanNode getPointPoiDetail()
  {
    return this.mPointByPoiDetail;
  }
  
  public PointSelectNode getPointSelectNode()
  {
    return this.mPointSelectNode;
  }
  
  public int[] getPrefId()
  {
    return this.mPrefId;
  }
  
  public String[] getPrefStr()
  {
    return this.mPrefStr;
  }
  
  public int getRouteCnt()
  {
    return this.mRouteCnt;
  }
  
  public ArrayList<RoutePlanNode> getRouteInput()
  {
    return (ArrayList)this.mRoutePlanNodeList.clone();
  }
  
  public ArrayList<RoutePlanResultItem> getRouteNodeData()
  {
    if ((this.mAllRoutePlanInfo != null) && (this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex)) != null))
    {
      ArrayList localArrayList2 = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems;
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2.size() == 0) {
        localArrayList1 = null;
      }
      return localArrayList1;
    }
    return null;
  }
  
  public ArrayList<RoutePlanOutlineItem> getRouteOutlineData()
  {
    return this.mRouteOutlineItemList;
  }
  
  public Bundle getRoutePlanBundle()
  {
    LogUtil.e("wangyang", "getRoutePlanBundle start");
    Bundle localBundle = new Bundle();
    if (BNRoutePlaner.getInstance().getRouteInfo(this.mCurRouteIndex, localBundle) == 2)
    {
      LogUtil.e("wangyang", "getRoutePlanBundle: full");
      return localBundle;
    }
    return null;
  }
  
  public int getRoutePlanMode()
  {
    return this.mRoutePlanMode;
  }
  
  public int getRoutePlanNetMode()
  {
    return this.routePlanNetMode;
  }
  
  public RoutePlanNode getRoutePlanNode()
  {
    return this.mPointSelectNode.getRoutePlanNode();
  }
  
  public int getRoutePlanNodeSize()
  {
    if (this.mRoutePlanNodeList != null) {
      return this.mRoutePlanNodeList.size();
    }
    return 0;
  }
  
  public ArrayList<RoutePlanResultItem> getRouteTwoNodeData(int paramInt)
  {
    if ((this.mAllRoutePlanInfo != null) && (this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex)) != null))
    {
      ArrayList localArrayList1 = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems;
      if ((localArrayList1.size() == 0) || (localArrayList1.size() <= paramInt - 1)) {
        return null;
      }
      try
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(localArrayList1.get(paramInt));
        localArrayList2.add(localArrayList1.get(paramInt + 1));
        return localArrayList2;
      }
      catch (Exception localException)
      {
        return null;
      }
    }
    return null;
  }
  
  public String getStartName(Context paramContext, boolean paramBoolean)
  {
    if (this.mRoutePlanNodeList.size() <= 0) {
      return "";
    }
    return getNodeName(paramContext, (RoutePlanNode)this.mRoutePlanNodeList.get(0), paramBoolean);
  }
  
  public RoutePlanNode getStartNode()
  {
    if (this.mRoutePlanNodeList.size() <= 0) {
      return null;
    }
    return (RoutePlanNode)this.mRoutePlanNodeList.get(0);
  }
  
  public int getTollFees()
  {
    int j = 0;
    int i;
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      i = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTollFees;
    }
    do
    {
      Bundle localBundle;
      do
      {
        return i;
        localBundle = getRoutePlanBundle();
        i = j;
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      i = j;
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTollFees;
  }
  
  public String getTotalDistance()
  {
    if (hasParseRouteDetail(this.mCurRouteIndex))
    {
      localObject = new StringBuffer();
      StringUtils.formatDistance(((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance, StringUtils.UnitLangEnum.ZH, (StringBuffer)localObject);
      return ((StringBuffer)localObject).toString();
    }
    Object localObject = getRoutePlanBundle();
    if (localObject != null)
    {
      parseRouteResult(BNaviModuleManager.getContext(), (Bundle)localObject);
      if (hasParseRouteDetail(this.mCurRouteIndex))
      {
        localObject = new StringBuffer();
        StringUtils.formatDistance(((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance, StringUtils.UnitLangEnum.ZH, (StringBuffer)localObject);
        return ((StringBuffer)localObject).toString();
      }
      return "";
    }
    return "";
  }
  
  public int getTotalDistanceInt()
  {
    int j = 0;
    int i;
    if (hasParseRouteDetail(this.mCurRouteIndex))
    {
      LogUtil.e("wangyang", "getTotalDistanceInt Parse");
      i = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance;
    }
    do
    {
      Bundle localBundle;
      do
      {
        return i;
        localBundle = getRoutePlanBundle();
        i = j;
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      i = j;
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mDistance;
  }
  
  public String getTotalTime()
  {
    if (hasParseRouteDetail(this.mCurRouteIndex))
    {
      LogUtil.e("RoutePlan", "remain time before format = " + "");
      localObject = StringUtils.formatTime2(((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTime, 2);
      LogUtil.e("RoutePlan", "remain time after format = " + (String)localObject);
      return (String)localObject;
    }
    Object localObject = getRoutePlanBundle();
    if (localObject != null)
    {
      parseRouteResult(BNaviModuleManager.getContext(), (Bundle)localObject);
      if (hasParseRouteDetail(this.mCurRouteIndex))
      {
        LogUtil.e("RoutePlan", "remain time before format = " + "");
        localObject = StringUtils.formatTime2(((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTime, 2);
        LogUtil.e("RoutePlan", "remain time after format = " + (String)localObject);
        return (String)localObject;
      }
      return "";
    }
    return "";
  }
  
  public int getTotalTimeInt()
  {
    int j = 0;
    int i;
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      i = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTime;
    }
    do
    {
      Bundle localBundle;
      do
      {
        return i;
        localBundle = getRoutePlanBundle();
        i = j;
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      i = j;
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTime;
  }
  
  public int getTrafficLightCnt()
  {
    int j = 0;
    int i;
    if (hasParseRouteDetail(this.mCurRouteIndex)) {
      i = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTrafficLightCnt;
    }
    do
    {
      Bundle localBundle;
      do
      {
        return i;
        localBundle = getRoutePlanBundle();
        i = j;
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
      i = j;
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    return ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mTrafficLightCnt;
  }
  
  public ArrayList<RoutePlanNode> getViaNodeList()
  {
    Object localObject;
    if (this.mRoutePlanNodeList.size() <= 2)
    {
      localObject = null;
      return (ArrayList<RoutePlanNode>)localObject;
    }
    ArrayList localArrayList2 = this.mRoutePlanNodeList;
    int j = localArrayList2.size();
    ArrayList localArrayList1 = new ArrayList();
    int i = 1;
    for (;;)
    {
      localObject = localArrayList1;
      if (i >= j - 1) {
        break;
      }
      localArrayList1.add(localArrayList2.get(i));
      i += 1;
    }
  }
  
  public boolean hasParseRouteDetail(int paramInt)
  {
    return (RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(paramInt)) != null;
  }
  
  public boolean isAvoidTrafficLable()
  {
    if (this.mRouteOutlineItemList.size() <= 0) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = (RoutePlanOutlineItem)this.mRouteOutlineItemList.get(this.mCurRouteIndex);
      } while (localObject == null);
      localObject = ((RoutePlanOutlineItem)localObject).getPusLabelName();
    } while ((localObject == null) || (!"躲避拥堵".equals(localObject)));
    return true;
  }
  
  public boolean isSelectNode()
  {
    return this.sIsSelectNode;
  }
  
  public void parseRouteResult(Context paramContext, Bundle paramBundle)
  {
    RoutePlanResultInfo localRoutePlanResultInfo = new RoutePlanResultInfo();
    String[] arrayOfString;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int[] arrayOfInt3;
    int[] arrayOfInt4;
    int[] arrayOfInt5;
    int[] arrayOfInt6;
    int i;
    String str3;
    ArrayList localArrayList;
    if (paramContext != null)
    {
      localRoutePlanResultInfo.mDistance = paramBundle.getInt("totaldistance");
      localRoutePlanResultInfo.mTime = paramBundle.getInt("totaltime");
      localRoutePlanResultInfo.mNodeNum = paramBundle.getInt("nodenum");
      LogUtil.e("wangyang", "parseRouteResult mDistance = " + localRoutePlanResultInfo.mDistance + " mTime = " + localRoutePlanResultInfo.mTime + " mNodeNum = " + localRoutePlanResultInfo.mNodeNum);
      if (localRoutePlanResultInfo.mNodeNum <= 0) {
        LogUtil.e("wangyang", "route plan not finished ");
      }
      arrayOfString = paramBundle.getStringArray("nextroadname");
      arrayOfInt1 = paramBundle.getIntArray("distance");
      arrayOfInt2 = paramBundle.getIntArray("turntype");
      arrayOfInt3 = paramBundle.getIntArray("ptX");
      arrayOfInt4 = paramBundle.getIntArray("ptY");
      arrayOfInt5 = paramBundle.getIntArray("roadCond");
      arrayOfInt6 = paramBundle.getIntArray("linkAngle");
      localRoutePlanResultInfo.mMainRoads = paramBundle.getString("mainroads");
      localRoutePlanResultInfo.mTrafficLightCnt = paramBundle.getInt("trafficlightcnt");
      localRoutePlanResultInfo.mTollFees = paramBundle.getInt("tollfees");
      localRoutePlanResultInfo.mGasMoney = paramBundle.getInt("gasmoney");
      localRoutePlanResultInfo.mPusDirection = paramBundle.getString("pusDirection");
      localRoutePlanResultInfo.mPusDetectRoad = paramBundle.getString("pusDetectedRoad");
      if (arrayOfString != null)
      {
        if (arrayOfString.length >= 1)
        {
          i = 1;
          if (i < arrayOfString.length)
          {
            if (StringUtils.isEmpty(arrayOfString[i])) {
              break label1144;
            }
            localRoutePlanResultInfo.mFirstRoadName = arrayOfString[i];
          }
        }
        if (arrayOfInt2.length >= 2) {
          localRoutePlanResultInfo.mFirstTurnType = arrayOfInt2[1];
        }
        if (arrayOfInt1.length >= 2) {
          localRoutePlanResultInfo.mFirstRemainDist = arrayOfInt1[0];
        }
      }
      str3 = getEndName(paramContext, false);
      localArrayList = new ArrayList();
      if (arrayOfInt2 == null) {
        break label1128;
      }
    }
    for (;;)
    {
      int j;
      Object localObject;
      try
      {
        if (arrayOfInt2.length <= 0) {
          break label1128;
        }
        i = 0;
        if (i >= localRoutePlanResultInfo.mNodeNum) {
          break label1064;
        }
        j = arrayOfInt2[i];
        if (j >= RoutePlanParams.gTurnIconIDSmall.length)
        {
          LogUtil.e("RoutePlan", "parseRouteResult out of arry! turnTypeIndex=" + j);
        }
        else
        {
          localObject = com.baidu.navisdk.comapi.routeguide.RouteGuideParams.gTurnTypeDesc[j];
          int k = RoutePlanParams.gTurnIconIDSmall[j];
          if (("起始地".equals(localObject)) || (((String)localObject).startsWith("途经点")))
          {
            str2 = JarUtils.getResources().getString(1711669534);
            str1 = JarUtils.getResources().getString(1711669535);
            paramBundle = JarUtils.getResources().getString(1711669546);
            paramContext = null;
            if ((localRoutePlanResultInfo.mNodeNum <= 1) || (i <= 0)) {
              break label892;
            }
            if (!"起始地".equals(localObject)) {
              break label757;
            }
            paramContext = new RGRouteItemModel.RouteItem(j, arrayOfInt1[(i - 1)], "起始地", arrayOfInt3[(i - 1)], arrayOfInt4[(i - 1)]);
            paramContext.type = 1;
            if (paramContext != null) {
              localArrayList.add(paramContext);
            }
            if (!"目的地".equals(localObject)) {
              break label934;
            }
            paramContext = "nodeEnd";
            paramBundle = "nodeEnd";
            str1 = JarUtils.getResources().getString(1711669548, new Object[] { com.baidu.navisdk.comapi.routeguide.RouteGuideParams.gTurnTypeDesc[j], str3 });
            if ((i >= arrayOfInt3.length) || (i >= arrayOfInt4.length)) {
              break label1137;
            }
            int m = arrayOfInt3[i];
            int n = arrayOfInt4[i];
            if (arrayOfInt5 == null) {
              break label1151;
            }
            j = arrayOfInt5[i];
            paramContext = new RoutePlanResultItem(k, paramContext, paramBundle, str1, m, n, j);
            if ((arrayOfInt6 != null) && (i < arrayOfInt6.length)) {
              paramContext.angle = arrayOfInt6[i];
            }
            if (i < arrayOfString.length) {
              paramContext.roadName = arrayOfString[i];
            }
            localRoutePlanResultInfo.mRouteItems.add(paramContext);
          }
        }
      }
      catch (Exception paramContext)
      {
        LogUtil.e("RoutePlan", paramContext.toString());
      }
      return;
      String str2 = JarUtils.getResources().getString(1711669532);
      String str1 = JarUtils.getResources().getString(1711669533);
      paramBundle = JarUtils.getResources().getString(1711669545);
      continue;
      label757:
      if (((String)localObject).startsWith("途经点"))
      {
        paramContext = new RGRouteItemModel.RouteItem(j, arrayOfInt1[(i - 1)], "途经点", arrayOfInt3[(i - 1)], arrayOfInt4[(i - 1)]);
        paramContext.type = 2;
      }
      else if (((String)localObject).startsWith("目的地"))
      {
        paramContext = new RGRouteItemModel.RouteItem(j, arrayOfInt1[(i - 1)], "目的地", arrayOfInt3[(i - 1)], arrayOfInt4[(i - 1)]);
        paramContext.type = 3;
      }
      else
      {
        paramContext = new RGRouteItemModel.RouteItem(j, arrayOfInt1[(i - 1)], arrayOfString[i], arrayOfInt3[(i - 1)], arrayOfInt4[(i - 1)]);
        continue;
        label892:
        if (localRoutePlanResultInfo.mNodeNum == 1)
        {
          paramContext = new RGRouteItemModel.RouteItem(j, arrayOfInt1[0], "目的地", arrayOfInt3[0], arrayOfInt4[0]);
          paramContext.type = 3;
          continue;
          label934:
          if (arrayOfString[i].length() == 0) {
            arrayOfString[i] = JarUtils.getResources().getString(1711669540);
          }
          localObject = new StringBuffer();
          StringUtils.formatDistance(arrayOfInt1[i], StringUtils.UnitLangEnum.ZH, (StringBuffer)localObject);
          paramContext = String.format(str2, new Object[] { arrayOfString[i], localObject });
          str1 = String.format(str1, new Object[] { arrayOfString[i], localObject });
          str2 = String.format(paramBundle, new Object[] { com.baidu.navisdk.comapi.routeguide.RouteGuideParams.gTurnTypeDesc[j], arrayOfString[i], localObject });
          paramBundle = str1;
          str1 = str2;
          continue;
          label1064:
          this.mAllRoutePlanInfo.put(Integer.valueOf(this.mCurRouteIndex), localRoutePlanResultInfo);
          LogUtil.e("wangyang", "mAllRoutePlanInfo.put  done mCurRouteIndex = " + this.mCurRouteIndex);
          RGRouteItemModel.getInstance().updateRouteItems(localArrayList);
          LogUtil.e("wangyang", "parseRouteResult done");
          return;
          label1128:
          LogUtil.e("RoutePlan", "turnType null");
          return;
          label1137:
          i += 1;
          continue;
          label1144:
          i += 1;
          break;
          label1151:
          j = 0;
        }
      }
    }
  }
  
  public void parseRouteResultMainInfo(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while ((paramBundle.isEmpty()) || ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex)) != null)) {
      return;
    }
    RoutePlanResultInfo localRoutePlanResultInfo = new RoutePlanResultInfo();
    localRoutePlanResultInfo.mDistance = paramBundle.getInt("totaldistance");
    localRoutePlanResultInfo.mTime = paramBundle.getInt("totaltime");
    localRoutePlanResultInfo.mNodeNum = paramBundle.getInt("nodenum");
    localRoutePlanResultInfo.mMainRoads = paramBundle.getString("mainroads");
    localRoutePlanResultInfo.mTrafficLightCnt = paramBundle.getInt("trafficlightcnt");
    localRoutePlanResultInfo.mTollFees = paramBundle.getInt("tollfees");
    localRoutePlanResultInfo.mGasMoney = paramBundle.getInt("gasmoney");
    this.mAllRoutePlanInfo.put(Integer.valueOf(this.mCurRouteIndex), localRoutePlanResultInfo);
  }
  
  public void parseRouteResultOutline(ArrayList<Bundle> paramArrayList)
  {
    clearRouteOutLineResult();
    if (paramArrayList == null) {}
    while (paramArrayList.isEmpty()) {
      return;
    }
    clearRouteOutLineResult();
    this.mRouteCnt = paramArrayList.size();
    int i = 0;
    if (i < this.mRouteCnt)
    {
      Bundle localBundle = (Bundle)paramArrayList.get(i);
      int j = localBundle.getInt("totaldistance");
      int k = localBundle.getInt("totaltime");
      int m = localBundle.getInt("trafficlightcnt");
      int n = localBundle.getInt("tollfees");
      String str = localBundle.getString("pusLabelName");
      int i1 = BNRoutePlaner.getInstance().getCalcPreference();
      int i2 = localBundle.getInt("pusLabelID");
      Object localObject = str;
      if ("".equals(str))
      {
        localObject = str;
        if (i1 != 1)
        {
          if (i != 0) {
            break label206;
          }
          localObject = parserLableId(i1);
        }
      }
      for (;;)
      {
        str = localBundle.getString("pusLabelTips");
        localObject = new RoutePlanOutlineItem(i, "", n, m, 0, j, k, (String)localObject, str, i2);
        this.mRouteOutlineItemList.add(localObject);
        i += 1;
        break;
        label206:
        localObject = str;
        if (i == 1) {
          localObject = "方案二";
        }
        if (i == 2) {
          localObject = "方案三";
        }
      }
    }
    paramArrayList = (Bundle)paramArrayList.get(0);
    this.mPrefId = paramArrayList.getIntArray("prefId");
    this.mPrefStr = paramArrayList.getStringArray("prefStr");
  }
  
  public void restoreCurRouteNaviBrowseInfo()
  {
    LogUtil.e("RoutePlan", "sunhao.routeitem.restoreCurRouteNaviBrowseInfo()");
    ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum = this.mNodeNumBackup;
    if (this.mNavingBrowseRoutItems != null) {
      RGRouteItemModel.getInstance().updateRouteItems(this.mNavingBrowseRoutItems);
    }
    if ((this.mRouteListBackup != null) && (hasParseRouteDetail(this.mCurRouteIndex)))
    {
      ArrayList localArrayList = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems;
      localArrayList.clear();
      localArrayList.addAll(this.mRouteListBackup);
    }
  }
  
  public void saveCurRouteNaviBrowseInfo()
  {
    LogUtil.e("RoutePlan", "sunhao.routeitem.saveCurRouteNaviBrowseInfo()");
    label44:
    List localList;
    if (this.mNavingBrowseRoutItems == null)
    {
      this.mNavingBrowseRoutItems = new ArrayList();
      if (this.mRouteListBackup != null) {
        break label77;
      }
      this.mRouteListBackup = new ArrayList();
      localList = RGRouteItemModel.getInstance().getRouteItems();
      if ((localList != null) && (localList.size() != 0)) {
        break label87;
      }
    }
    label77:
    label87:
    do
    {
      Bundle localBundle;
      do
      {
        return;
        this.mNavingBrowseRoutItems.clear();
        break;
        this.mRouteListBackup.clear();
        break label44;
        if (hasParseRouteDetail(this.mCurRouteIndex))
        {
          this.mNodeNumBackup = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum;
          this.mRouteListBackup.addAll(((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems);
          this.mNavingBrowseRoutItems.addAll(localList);
          return;
        }
        localBundle = getRoutePlanBundle();
      } while (localBundle == null);
      parseRouteResult(BNaviModuleManager.getContext(), localBundle);
    } while (!hasParseRouteDetail(this.mCurRouteIndex));
    this.mNodeNumBackup = ((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mNodeNum;
    this.mRouteListBackup.addAll(((RoutePlanResultInfo)this.mAllRoutePlanInfo.get(Integer.valueOf(this.mCurRouteIndex))).mRouteItems);
    this.mNavingBrowseRoutItems.addAll(localList);
  }
  
  public void setAvoidTrafficjamEnableListener(IAvoidTrafficjamEnableListener paramIAvoidTrafficjamEnableListener)
  {
    this.mAvoidTrafficjamEnableListener = paramIAvoidTrafficjamEnableListener;
  }
  
  public void setCurIndex(int paramInt)
  {
    this.mCurRouteIndex = paramInt;
  }
  
  public void setEnComfrom(int paramInt)
  {
    this.enComfrom = paramInt;
  }
  
  public void setEnNaviType(int paramInt)
  {
    this.enNaviType = paramInt;
  }
  
  public void setPointPoiDetail(RoutePlanNode paramRoutePlanNode)
  {
    this.bIsPoiDetail = true;
    this.mPointByPoiDetail.copy(paramRoutePlanNode);
  }
  
  public void setPointSelectNode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setPointIndex(paramInt1);
    this.mPointSelectNode.setRoutePlanNode(paramInt2, paramInt3, paramInt4, paramString1, paramString2);
    this.mPointSelectNode.setUID(null);
  }
  
  public void setPointSelectNode(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramInt1, paramInt2, paramInt3, paramString1, paramString2);
    this.mPointSelectNode.setUID(null);
  }
  
  public void setPointSelectNode(int paramInt, SearchPoi paramSearchPoi)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramInt, paramSearchPoi);
  }
  
  public void setPointSelectNode(int paramInt, SearchPoi paramSearchPoi, ArrayList<SearchPoi> paramArrayList)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramInt, paramSearchPoi, paramArrayList);
  }
  
  public void setPointSelectNode(int paramInt1, GeoPoint paramGeoPoint, int paramInt2, String paramString1, String paramString2)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setPointIndex(paramInt1);
    this.mPointSelectNode.setRoutePlanNode(paramGeoPoint, paramInt2, paramString1, paramString2);
    this.mPointSelectNode.setUID(null);
  }
  
  public void setPointSelectNode(PointSelectNode paramPointSelectNode)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode = paramPointSelectNode;
  }
  
  public void setPointSelectNode(RoutePlanNode paramRoutePlanNode)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramRoutePlanNode);
  }
  
  public void setPointSelectNode(RoutePlanNode paramRoutePlanNode, int paramInt)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramRoutePlanNode);
    this.mPointSelectNode.setFrom(paramInt);
  }
  
  public void setPointSelectNode(SearchPoi paramSearchPoi)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramSearchPoi);
  }
  
  public void setPointSelectNode(GeoPoint paramGeoPoint)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramGeoPoint);
    this.mPointSelectNode.setUID(null);
  }
  
  public void setPointSelectNode(GeoPoint paramGeoPoint, int paramInt, String paramString1, String paramString2)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramGeoPoint, paramGeoPoint, paramInt, paramString1, paramString2);
    this.mPointSelectNode.setUID(null);
  }
  
  public void setPointSelectNode(ArrayList<SearchPoi> paramArrayList, SearchPoi paramSearchPoi)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setRoutePlanNode(paramSearchPoi, paramArrayList);
  }
  
  public void setPointSelectNodeInfo(int paramInt, String paramString)
  {
    this.sIsSelectNode = true;
    this.mPointSelectNode.setPointIndex(paramInt);
    this.mPointSelectNode.setPointDescription(paramString);
    this.mPointSelectNode.setUID(null);
  }
  
  public void setRouteInput(ArrayList<RoutePlanNode> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      clearRouteInput();
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        this.mRoutePlanNodeList.add(new RoutePlanNode((RoutePlanNode)paramArrayList.get(i)));
        i += 1;
      }
    }
  }
  
  public void setRoutePlanNetMode(int paramInt)
  {
    this.routePlanNetMode = paramInt;
  }
  
  public static abstract interface IAvoidTrafficjamEnableListener
  {
    public abstract void onAvoidTrafficjamEnable(boolean paramBoolean);
  }
  
  public class RoutePlanResultInfo
  {
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
    
    public RoutePlanResultInfo() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/modelfactory/RoutePlanModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */