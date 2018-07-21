package com.baidu.navisdk.module.routereport;

import android.os.Bundle;
import android.util.SparseIntArray;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;

public class BNRouteReportModel
{
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
  private ArrayList<RouteReportItem> afterNaviItemsList = null;
  public ArrayList<RouteReportItem> afterNaviItemsListDefault = null;
  private ArrayList<RouteReportItem> beforeNaviItemsList = null;
  public ArrayList<RouteReportItem> beforeNaviItemsListDefault = null;
  private CurrentRouteReportModel currentRouteReportModel = new CurrentRouteReportModel();
  private Bundle mAddrResult = null;
  private RouteReportItem mCurrentFlevelItem = null;
  private SparseIntArray mResIdMap = null;
  private String uploadingImgFilePath = null;
  private String uploadingVoiceFilePath = null;
  
  private RouteReportItem getDefaultRouteReportItem(int paramInt)
  {
    RouteReportItem localRouteReportItem;
    switch (paramInt)
    {
    default: 
      return null;
    case 13: 
      localRouteReportItem = new RouteReportItem(false, "道路不通", 13);
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(131));
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(132));
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(133));
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(134));
      return localRouteReportItem;
    case 14: 
      localRouteReportItem = new RouteReportItem(false, "吐槽路线", 14);
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(141));
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(142));
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(143));
      return localRouteReportItem;
    case 11: 
      localRouteReportItem = new RouteReportItem(false, "终点有误", 11);
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(111));
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(112));
      return localRouteReportItem;
    case 12: 
      localRouteReportItem = new RouteReportItem(false, "播报错误", 12);
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(121));
      localRouteReportItem.addSubItem(getDefaultRouteReportItem(122));
      return localRouteReportItem;
    case 131: 
      return new RouteReportItem(true, "施工封路", 131);
    case 132: 
      return new RouteReportItem(true, "单向通行", 132);
    case 133: 
      return new RouteReportItem(true, "禁止转向", 133);
    case 134: 
      return new RouteReportItem(true, "路不存在", 134);
    case 141: 
      return new RouteReportItem(true, "绕路", 141);
    case 142: 
      return new RouteReportItem(true, "拥堵", 142);
    case 143: 
      return new RouteReportItem(true, "路不好走", 143);
    case 111: 
      return new RouteReportItem(true, "找不到终点", 111);
    case 112: 
      return new RouteReportItem(true, "车辆无法通行", 112);
    case 121: 
      return new RouteReportItem(true, "播报延迟错过路口", 121);
    }
    return new RouteReportItem(true, "播报内容错误", 122);
  }
  
  public static BNRouteReportModel getInstance()
  {
    return LazyLoader.instance;
  }
  
  private void initIntendedItemsListDefault(int paramInt)
  {
    LogUtil.e(TAG, "initIntendedItemsListDefault: intentType --> " + paramInt);
    if (paramInt == 1) {
      if (this.beforeNaviItemsListDefault == null) {}
    }
    while (this.afterNaviItemsListDefault != null)
    {
      return;
      this.beforeNaviItemsListDefault = new ArrayList();
      this.beforeNaviItemsListDefault.add(getDefaultRouteReportItem(14));
      this.beforeNaviItemsListDefault.add(getDefaultRouteReportItem(13));
      return;
    }
    this.afterNaviItemsListDefault = new ArrayList();
    this.afterNaviItemsListDefault.add(getDefaultRouteReportItem(11));
    this.afterNaviItemsListDefault.add(getDefaultRouteReportItem(12));
    this.afterNaviItemsListDefault.add(getDefaultRouteReportItem(14));
    this.afterNaviItemsListDefault.add(getDefaultRouteReportItem(13));
  }
  
  public static boolean needsProjection(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 12: 
    case 13: 
      return true;
    }
    return false;
  }
  
  /* Error */
  private RouteReportItem parseSingleItem(boolean paramBoolean, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_2
    //   6: aload_2
    //   7: areturn
    //   8: new 14	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 186	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:<init>	(Lcom/baidu/navisdk/module/routereport/BNRouteReportModel;)V
    //   16: astore 5
    //   18: aload 5
    //   20: iload_1
    //   21: putfield 190	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:mIsSubType	Z
    //   24: aload 5
    //   26: aload_2
    //   27: ldc -64
    //   29: invokevirtual 198	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: putfield 201	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:mTitle	Ljava/lang/String;
    //   35: aload 5
    //   37: aload_2
    //   38: ldc -53
    //   40: invokevirtual 207	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   43: putfield 210	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:mType	I
    //   46: aload_2
    //   47: ldc -44
    //   49: invokevirtual 216	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   52: ifeq +14 -> 66
    //   55: aload 5
    //   57: aload_2
    //   58: ldc -44
    //   60: invokevirtual 198	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: putfield 219	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:mIconUrl	Ljava/lang/String;
    //   66: iload_1
    //   67: ifne +106 -> 173
    //   70: aload_2
    //   71: ldc -35
    //   73: invokevirtual 225	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +95 -> 173
    //   81: aload_2
    //   82: invokevirtual 231	org/json/JSONArray:length	()I
    //   85: ifle +88 -> 173
    //   88: aload 5
    //   90: new 174	java/util/ArrayList
    //   93: dup
    //   94: invokespecial 175	java/util/ArrayList:<init>	()V
    //   97: putfield 234	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:subItemsList	Ljava/util/ArrayList;
    //   100: iconst_0
    //   101: istore_3
    //   102: aload_2
    //   103: invokevirtual 231	org/json/JSONArray:length	()I
    //   106: istore 4
    //   108: iload_3
    //   109: iload 4
    //   111: if_icmpge +62 -> 173
    //   114: aload_0
    //   115: iconst_1
    //   116: aload_2
    //   117: iload_3
    //   118: invokevirtual 238	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   121: invokespecial 240	com/baidu/navisdk/module/routereport/BNRouteReportModel:parseSingleItem	(ZLorg/json/JSONObject;)Lcom/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem;
    //   124: astore 6
    //   126: getstatic 74	com/baidu/navisdk/module/routereport/BNRouteReportModel:TAG	Ljava/lang/String;
    //   129: new 153	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   136: ldc -14
    //   138: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 6
    //   143: invokevirtual 243	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:toString	()Ljava/lang/String;
    //   146: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 172	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 5
    //   157: getfield 234	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:subItemsList	Ljava/util/ArrayList;
    //   160: aload 6
    //   162: invokevirtual 179	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   165: pop
    //   166: iload_3
    //   167: iconst_1
    //   168: iadd
    //   169: istore_3
    //   170: goto -68 -> 102
    //   173: aload 5
    //   175: astore_2
    //   176: iload_1
    //   177: ifne -171 -> 6
    //   180: getstatic 74	com/baidu/navisdk/module/routereport/BNRouteReportModel:TAG	Ljava/lang/String;
    //   183: new 153	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   190: ldc -11
    //   192: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 5
    //   197: invokevirtual 243	com/baidu/navisdk/module/routereport/BNRouteReportModel$RouteReportItem:toString	()Ljava/lang/String;
    //   200: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 172	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload 5
    //   211: areturn
    //   212: astore_2
    //   213: getstatic 74	com/baidu/navisdk/module/routereport/BNRouteReportModel:TAG	Ljava/lang/String;
    //   216: ldc -9
    //   218: invokestatic 172	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aconst_null
    //   222: areturn
    //   223: astore 6
    //   225: goto -59 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	BNRouteReportModel
    //   0	228	1	paramBoolean	boolean
    //   0	228	2	paramJSONObject	org.json.JSONObject
    //   101	69	3	i	int
    //   106	6	4	j	int
    //   16	194	5	localRouteReportItem1	RouteReportItem
    //   124	37	6	localRouteReportItem2	RouteReportItem
    //   223	1	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   18	66	212	java/lang/Exception
    //   70	77	212	java/lang/Exception
    //   81	100	212	java/lang/Exception
    //   102	108	212	java/lang/Exception
    //   180	209	212	java/lang/Exception
    //   114	166	223	java/lang/Exception
  }
  
  public Bundle getAddrResult()
  {
    return this.mAddrResult;
  }
  
  public RouteReportItem getCurrentFlevelItem()
  {
    return this.mCurrentFlevelItem;
  }
  
  public CurrentRouteReportModel getCurrentRouteReportModel()
  {
    return this.currentRouteReportModel;
  }
  
  public int getDefaultResId(int paramInt)
  {
    if (this.mResIdMap == null)
    {
      this.mResIdMap = new SparseIntArray();
      this.mResIdMap.put(11, 1711408088);
      this.mResIdMap.put(12, 1711408089);
      this.mResIdMap.put(13, 1711408086);
      this.mResIdMap.put(14, 1711408087);
    }
    return this.mResIdMap.get(paramInt, -1);
  }
  
  public ArrayList<RouteReportItem> getIntendedItemsList(int paramInt)
  {
    LogUtil.e(TAG, "getIntendedItemsList: intentType --> " + paramInt);
    if (paramInt == 1)
    {
      if (this.beforeNaviItemsList != null) {
        return this.beforeNaviItemsList;
      }
      initIntendedItemsListDefault(paramInt);
      return this.beforeNaviItemsListDefault;
    }
    if (this.afterNaviItemsList != null) {
      return this.afterNaviItemsList;
    }
    initIntendedItemsListDefault(paramInt);
    return this.afterNaviItemsListDefault;
  }
  
  public String getUploadingImgFilePath()
  {
    return this.uploadingImgFilePath;
  }
  
  public String getUploadingVoiceFilePath()
  {
    return this.uploadingVoiceFilePath;
  }
  
  public void parseRouteReportItemJson(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {
      return;
    }
    LogUtil.e(TAG, "parseRouteReportItemJson: intentType --> " + paramInt + ", json: " + paramJSONArray);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      try
      {
        RouteReportItem localRouteReportItem = parseSingleItem(false, paramJSONArray.getJSONObject(i));
        if (localRouteReportItem != null) {
          localArrayList.add(localRouteReportItem);
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      i += 1;
    }
    if (paramInt == 1)
    {
      this.beforeNaviItemsList = localArrayList;
      return;
    }
    this.afterNaviItemsList = localArrayList;
  }
  
  public void reset()
  {
    if (this.beforeNaviItemsList != null)
    {
      this.beforeNaviItemsList.clear();
      this.beforeNaviItemsList = null;
    }
    if (this.afterNaviItemsList != null)
    {
      this.afterNaviItemsList.clear();
      this.afterNaviItemsList = null;
    }
    if (this.beforeNaviItemsListDefault != null)
    {
      this.beforeNaviItemsListDefault.clear();
      this.beforeNaviItemsListDefault = null;
    }
    if (this.afterNaviItemsListDefault != null)
    {
      this.afterNaviItemsListDefault.clear();
      this.afterNaviItemsListDefault = null;
    }
    this.mResIdMap = null;
    this.uploadingVoiceFilePath = null;
    this.uploadingImgFilePath = null;
  }
  
  public void resetCurrentReportModel()
  {
    LogUtil.e(TAG, "resetCurrentReportModel: --> ");
    this.currentRouteReportModel = new CurrentRouteReportModel();
  }
  
  public void setAddrResult(Bundle paramBundle)
  {
    this.mAddrResult = paramBundle;
  }
  
  public void setCurrentFlevelItem(RouteReportItem paramRouteReportItem)
  {
    this.mCurrentFlevelItem = paramRouteReportItem;
  }
  
  public void setUploadingImgFilePath(String paramString)
  {
    this.uploadingImgFilePath = paramString;
  }
  
  public void setUploadingVoiceFilePath(String paramString)
  {
    this.uploadingVoiceFilePath = paramString;
  }
  
  public class CurrentRouteReportModel
  {
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
    
    public CurrentRouteReportModel() {}
  }
  
  private static class LazyLoader
  {
    private static BNRouteReportModel instance = new BNRouteReportModel(null);
  }
  
  public class RouteReportItem
  {
    public String mIconUrl = null;
    public boolean mIsSubType = false;
    public String mTitle = null;
    public int mType = -1;
    public ArrayList<RouteReportItem> subItemsList = null;
    
    public RouteReportItem() {}
    
    public RouteReportItem(boolean paramBoolean, String paramString, int paramInt)
    {
      this.mIsSubType = paramBoolean;
      this.mTitle = paramString;
      this.mType = paramInt;
    }
    
    public void addSubItem(RouteReportItem paramRouteReportItem)
    {
      if (paramRouteReportItem == null) {
        return;
      }
      if (this.subItemsList == null) {
        this.subItemsList = new ArrayList();
      }
      this.subItemsList.add(paramRouteReportItem);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("title: ").append(this.mTitle).append(", type: ").append(this.mType).append(", isSubType: ").append(this.mIsSubType).append(", subItemsSize: ");
      if (this.subItemsList == null) {}
      for (int i = 0;; i = this.subItemsList.size()) {
        return i + ", iconUrl: " + this.mIconUrl;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/routereport/BNRouteReportModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */