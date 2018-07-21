package com.baidu.navi.controller;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.RouteCustomUtil;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.db.model.RouteCustomModel;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RouteCustomController
{
  public static final String ALARM_BROADCAST = "com.baidu.navi.alarm";
  public static final String REPEAT_DATES_SPLIT = ",";
  public static final String ROUTE_CUSTOM_CALC_ROUTE_RESULT_KEY = "calc_route_result_key";
  private static RouteCustomController mInstance;
  private Calendar mCalendar = Calendar.getInstance();
  private boolean mIsModifiedName;
  private boolean mIsModifiedRepeatDate;
  private int mIsOpen;
  private int mIsRepeat;
  private boolean mIsUpdatePushTime;
  private ContentFragmentManager mNaviFragmentManager;
  private int mNewRouteHisDBId = -1;
  private ArrayList<RoutePlanNode> mNewRouteNodesList = null;
  private int mNewRouteType = -1;
  private int mPushTimeHour;
  private long mPushTimeMills;
  private int mPushTimeMinute;
  private String mRCName;
  private Handler mRPHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      default: 
        return;
      case 4: 
        BNRoutePlaner.getInstance().removeRouteResultHandler(RouteCustomController.this.mRPHandler);
        paramAnonymousMessage = new Bundle();
        paramAnonymousMessage.putBoolean("calc_route_result_key", true);
        RouteCustomController.this.mNaviFragmentManager.showFragment(294, paramAnonymousMessage);
        return;
      case 7: 
        BNRoutePlaner.getInstance().removeRouteResultHandler(RouteCustomController.this.mRPHandler);
        paramAnonymousMessage = new Bundle();
        paramAnonymousMessage.putBoolean("calc_route_result_key", false);
        RouteCustomController.this.mNaviFragmentManager.showFragment(294, paramAnonymousMessage);
        return;
      }
      BNRoutePlaner.getInstance().removeRouteResultHandler(RouteCustomController.this.mRPHandler);
    }
  };
  private String mRepeatDate;
  private int mSelRouteCustomPos;
  private int mUserCurAction = 2;
  
  private RouteCustomController()
  {
    clear();
  }
  
  public static RouteCustomController getInstance()
  {
    if (mInstance == null) {
      mInstance = new RouteCustomController();
    }
    return mInstance;
  }
  
  private String getRCRealNameByRPNodes(ArrayList<RoutePlanNode> paramArrayList, int paramInt)
  {
    String str2 = "";
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
    RoutePlanNode localRoutePlanNode;
    if ((paramInt != 1) && (paramInt != 2))
    {
      str1 = str2;
      if (paramArrayList.size() != 1) {}
    }
    else
    {
      localRoutePlanNode = BNLocationManagerProxy.getInstance().getCurLocationNode();
      str1 = str2;
      if (localRoutePlanNode != null) {
        if (!StringUtils.isEmpty(localRoutePlanNode.mName)) {
          break label115;
        }
      }
    }
    label115:
    for (String str1 = StyleManager.getString(2131296903);; str1 = localRoutePlanNode.mName)
    {
      str1 = str1 + "-";
      return str1 + produceRouteNameByRPNodesList(paramArrayList);
    }
  }
  
  private String getRoutePlanNodeName(RoutePlanNode paramRoutePlanNode)
  {
    String str = "";
    if (paramRoutePlanNode == null) {
      str = StyleManager.getString(2131296709);
    }
    if (paramRoutePlanNode.isNodeSettedData())
    {
      if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {
        str = StyleManager.getString(2131296709);
      }
    }
    else {
      return str;
    }
    return paramRoutePlanNode.mName;
  }
  
  private int[] parseRepeatDateStr(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!StringUtils.isEmpty(paramString))
    {
      if (paramString != "") {
        break label27;
      }
      localObject1 = localObject2;
    }
    label27:
    String[] arrayOfString;
    do
    {
      do
      {
        return (int[])localObject1;
        arrayOfString = paramString.split(",");
        localObject1 = localObject2;
      } while (arrayOfString == null);
      localObject1 = localObject2;
    } while (arrayOfString.length == 0);
    int j = arrayOfString.length;
    paramString = new int[j];
    int i = 0;
    for (;;)
    {
      localObject1 = paramString;
      if (i >= j) {
        break;
      }
      try
      {
        paramString[i] = Integer.valueOf(arrayOfString[i]).intValue();
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramString[i] = -1;
        }
      }
    }
  }
  
  private String produceRouteNameByRPNodesList(List<RoutePlanNode> paramList)
  {
    String str = "";
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    int j = paramList.size();
    int i = 0;
    while (i < j - 1)
    {
      str = str + getRoutePlanNodeName((RoutePlanNode)paramList.get(i)) + " - ";
      i += 1;
    }
    return str + getRoutePlanNodeName((RoutePlanNode)paramList.get(j - 1));
  }
  
  public void addAlarmNotify(Context paramContext, long paramLong, int paramInt)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    Intent localIntent = new Intent("com.baidu.navi.alarm");
    localIntent.putExtra("id", paramInt);
    localAlarmManager.set(1, paramLong, PendingIntent.getBroadcast(paramContext, paramInt, localIntent, 0));
  }
  
  public void addNewRCPushTimeToAlarm(Context paramContext)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(this.mSelRouteCustomPos);
    if (localRouteCustomDBObject == null) {}
    for (;;)
    {
      return;
      if ((this.mIsOpen != 0) && (this.mIsUpdatePushTime))
      {
        this.mPushTimeMills = RouteCustomUtil.getInstance().calcPushTime(this.mPushTimeHour, this.mPushTimeMinute, this.mIsRepeat);
        if (this.mIsRepeat == 0) {}
        for (long l = this.mPushTimeMills; l != -1L; l = getFirstPushTimeMills(this.mSelRouteCustomPos))
        {
          deleteAlarmNotify(paramContext, localRouteCustomDBObject.getId());
          addAlarmNotify(paramContext, l, localRouteCustomDBObject.getId());
          localRouteCustomDBObject.setPushTimeMills(l);
          RouteCustomModel.getInstance().updateRouteCustomInfo(this.mSelRouteCustomPos);
          return;
        }
      }
    }
  }
  
  public void asyncGetRouteCustomCondInfo(Handler paramHandler)
  {
    int j = RouteCustomModel.getInstance().getRouteCustomSize();
    if (j == 0) {}
    for (;;)
    {
      return;
      paramHandler = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        Bundle localBundle = RouteCustomModel.getInstance().getNodesListBundle(i);
        if (localBundle != null) {
          paramHandler.add(localBundle);
        }
        i += 1;
      }
    }
  }
  
  public void calcExtendRouteResult(ArrayList<RoutePlanNode> paramArrayList, NaviFragmentManager paramNaviFragmentManager)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    this.mNaviFragmentManager = paramNaviFragmentManager;
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    BNRoutePlaner.getInstance().calcRouteToRouteCustom(paramArrayList);
  }
  
  public void calcPushTimeAndAddAlarmByRCList(Context paramContext)
  {
    ArrayList localArrayList = RouteCustomModel.getInstance().getRouteCustomList();
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    int j = localArrayList.size();
    int i = 0;
    label30:
    RouteCustomDBObject localRouteCustomDBObject;
    if (i < j)
    {
      localRouteCustomDBObject = (RouteCustomDBObject)localArrayList.get(i);
      if (localRouteCustomDBObject != null) {
        break label58;
      }
    }
    label58:
    long l;
    do
    {
      do
      {
        i += 1;
        break label30;
        break;
      } while (localRouteCustomDBObject.getOpen() != 1);
      if (localRouteCustomDBObject.getIsRepeat() != 0) {
        break label116;
      }
      l = localRouteCustomDBObject.getPushTimeMills();
    } while (l < System.currentTimeMillis());
    for (;;)
    {
      deleteAlarmNotify(paramContext, localRouteCustomDBObject.getId());
      addAlarmNotify(paramContext, l, localRouteCustomDBObject.getId());
      break;
      label116:
      l = getFirstPushTimeMills(i);
    }
  }
  
  public void clear()
  {
    this.mSelRouteCustomPos = -1;
    this.mIsOpen = 0;
    this.mIsUpdatePushTime = false;
    this.mPushTimeMills = -1L;
    this.mPushTimeHour = -1;
    this.mPushTimeMinute = -1;
    this.mIsModifiedName = false;
    this.mRCName = "";
    this.mIsRepeat = 0;
    this.mIsModifiedRepeatDate = false;
    this.mRepeatDate = "";
  }
  
  public void deleteAlarmNotify(Context paramContext, int paramInt)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    Intent localIntent = new Intent("com.baidu.navi.alarm");
    localIntent.putExtra("id", paramInt);
    localAlarmManager.cancel(PendingIntent.getBroadcast(paramContext, paramInt, localIntent, 0));
  }
  
  public long getFirstPushTimeMills(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt);
    if (localRouteCustomDBObject == null) {}
    int[] arrayOfInt;
    do
    {
      return -1L;
      arrayOfInt = parseRepeatDateStr(localRouteCustomDBObject.getRepeatDate());
    } while ((arrayOfInt == null) || (arrayOfInt.length == 0));
    int i = arrayOfInt.length;
    long l1 = RouteCustomUtil.getInstance().getWeekByTimeMillis(System.currentTimeMillis());
    paramInt = 0;
    if ((paramInt >= i) || (arrayOfInt[paramInt] >= l1))
    {
      if (paramInt >= i) {
        break label180;
      }
      if (arrayOfInt[paramInt] != l1) {
        break label156;
      }
      long l2 = RouteCustomUtil.getInstance().calcPushTime(localRouteCustomDBObject.getPushTimeHour(), localRouteCustomDBObject.getPushTimeMinute(), localRouteCustomDBObject.getIsRepeat());
      l1 = l2;
      if (l2 < System.currentTimeMillis()) {
        l1 = RouteCustomUtil.getInstance().getPushTimeMillsByWeek(arrayOfInt[((paramInt + 1) % i)], localRouteCustomDBObject.getPushTimeHour(), localRouteCustomDBObject.getPushTimeMinute());
      }
    }
    for (;;)
    {
      return l1;
      paramInt += 1;
      break;
      label156:
      l1 = RouteCustomUtil.getInstance().getPushTimeMillsByWeek(arrayOfInt[paramInt], localRouteCustomDBObject.getPushTimeHour(), localRouteCustomDBObject.getPushTimeMinute());
      continue;
      label180:
      l1 = RouteCustomUtil.getInstance().getPushTimeMillsByWeek(arrayOfInt[0], localRouteCustomDBObject.getPushTimeHour(), localRouteCustomDBObject.getPushTimeMinute());
    }
  }
  
  public String getNewRCPushTImeStr()
  {
    this.mCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = this.mCalendar.get(11);
    int j = this.mCalendar.get(12);
    return RouteCustomUtil.getInstance().getTimeStr(i, j);
  }
  
  public String getNewRCRealName(Context paramContext)
  {
    ArrayList localArrayList;
    if (this.mNewRouteType != 3)
    {
      localArrayList = new ArrayList();
      if (this.mNewRouteType == 1)
      {
        paramContext = AddressSettingModel.getHomeAddrNode(paramContext);
        localArrayList.add(paramContext);
      }
    }
    for (paramContext = localArrayList;; paramContext = this.mNewRouteNodesList)
    {
      return getRCRealNameByRPNodes(paramContext, this.mNewRouteType);
      paramContext = AddressSettingModel.getCompAddrNode(paramContext);
      break;
    }
  }
  
  public long getNextPushTimeMillsByRCId(int paramInt)
  {
    long l = 0L;
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoById(paramInt);
    int[] arrayOfInt;
    int j;
    int i;
    if (localRouteCustomDBObject != null)
    {
      arrayOfInt = parseRepeatDateStr(localRouteCustomDBObject.getRepeatDate());
      if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
        return -1L;
      }
      j = arrayOfInt.length;
      i = RouteCustomUtil.getInstance().getWeekByTimeMillis(System.currentTimeMillis());
      paramInt = 0;
    }
    for (;;)
    {
      if ((paramInt >= j) || (arrayOfInt[paramInt] > i))
      {
        i = paramInt;
        if (paramInt == j) {
          i = 0;
        }
        l = RouteCustomUtil.getInstance().getPushTimeMillsByWeek(arrayOfInt[i], localRouteCustomDBObject.getPushTimeHour(), localRouteCustomDBObject.getPushTimeMinute());
        return l;
      }
      paramInt += 1;
    }
  }
  
  public String getRCName()
  {
    return this.mRCName;
  }
  
  public int getRCPushIsRepeat()
  {
    return this.mIsRepeat;
  }
  
  public int[] getRCPushRepeatDateByPos(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt);
    if (localRouteCustomDBObject == null) {
      return null;
    }
    return parseRepeatDateStr(localRouteCustomDBObject.getRepeatDate());
  }
  
  public String getRCPushRepeatDateStrByPos(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt);
    if (localRouteCustomDBObject == null) {
      return "";
    }
    return localRouteCustomDBObject.getRepeatDate();
  }
  
  public int getRCPushStatus(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt);
    if (localRouteCustomDBObject == null) {
      return 0;
    }
    return localRouteCustomDBObject.getOpen();
  }
  
  public int getRCPushTimeHour()
  {
    return this.mPushTimeHour;
  }
  
  public String getRCPushTimeStrByPos(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt);
    if (localRouteCustomDBObject == null) {
      return "";
    }
    int i = localRouteCustomDBObject.getPushTimeHour();
    int j = localRouteCustomDBObject.getPushTimeMinute();
    if (i != -1)
    {
      paramInt = j;
      if (j != -1) {}
    }
    else
    {
      this.mCalendar.setTimeInMillis(System.currentTimeMillis());
      i = this.mCalendar.get(11);
      paramInt = this.mCalendar.get(12);
    }
    return RouteCustomUtil.getInstance().getTimeStr(i, paramInt);
  }
  
  public String getRCRealNameByPos(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt);
    if (localRouteCustomDBObject == null) {
      return "";
    }
    return getRCRealNameByRPNodes(localRouteCustomDBObject.getRoutePlanNodes(), localRouteCustomDBObject.getDestType());
  }
  
  public String getRCRemakNameByPos(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt);
    if (localRouteCustomDBObject == null) {
      return "";
    }
    return localRouteCustomDBObject.getName();
  }
  
  public String getRCShowNameByDBId(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoById(paramInt);
    Object localObject;
    if (localRouteCustomDBObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return (String)localObject;
      str = localRouteCustomDBObject.getName();
      localObject = str;
    } while (!StringUtils.isEmpty(str));
    return getRCRealNameByRPNodes(localRouteCustomDBObject.getRoutePlanNodes(), localRouteCustomDBObject.getDestType());
  }
  
  public String getRCShowNameByPos(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt);
    Object localObject;
    if (localRouteCustomDBObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return (String)localObject;
      str = localRouteCustomDBObject.getName();
      localObject = str;
    } while (!StringUtils.isEmpty(str));
    return getRCRealNameByRPNodes(localRouteCustomDBObject.getRoutePlanNodes(), localRouteCustomDBObject.getDestType());
  }
  
  public int getSelRouteCustomPos()
  {
    return this.mSelRouteCustomPos;
  }
  
  public int getUserCurAction()
  {
    return this.mUserCurAction;
  }
  
  public void openOrCloseRCAlarmByPos(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(paramInt1);
    if (localRouteCustomDBObject == null) {
      return;
    }
    localRouteCustomDBObject.setOpen(paramInt2);
    if ((paramInt2 == 1) && (localRouteCustomDBObject.getPushTimeHour() == -1))
    {
      localRouteCustomDBObject.setPushTimeHour(paramInt3);
      localRouteCustomDBObject.setPushTimeMinute(paramInt4);
    }
    if (paramInt2 == 0) {
      deleteAlarmNotify(paramContext, localRouteCustomDBObject.getId());
    }
    for (;;)
    {
      RouteCustomModel.getInstance().updateRouteCustomInfo(paramInt1);
      return;
      long l = RouteCustomUtil.getInstance().calcPushTime(localRouteCustomDBObject.getPushTimeHour(), localRouteCustomDBObject.getPushTimeMinute(), localRouteCustomDBObject.getIsRepeat());
      if (localRouteCustomDBObject.getIsRepeat() == 1) {
        l = getFirstPushTimeMills(paramInt1);
      }
      if (l == -1L) {
        break;
      }
      localRouteCustomDBObject.setPushTimeMills(l);
      deleteAlarmNotify(paramContext, localRouteCustomDBObject.getId());
      addAlarmNotify(paramContext, l, localRouteCustomDBObject.getId());
      localRouteCustomDBObject.setPushTimeMills(l);
    }
  }
  
  public int[] parsePushTimeStr(String paramString)
  {
    int[] arrayOfInt = new int[2];
    if (StringUtils.isEmpty(paramString))
    {
      this.mCalendar.setTimeInMillis(System.currentTimeMillis());
      arrayOfInt[0] = this.mCalendar.get(11);
      arrayOfInt[1] = this.mCalendar.get(12);
    }
    do
    {
      return arrayOfInt;
      paramString = paramString.split(":");
    } while ((paramString == null) && (paramString.length <= 1));
    try
    {
      arrayOfInt[0] = Integer.valueOf(paramString[0]).intValue();
      try
      {
        arrayOfInt[1] = Integer.valueOf(paramString[1]).intValue();
        return arrayOfInt;
      }
      catch (Exception paramString)
      {
        arrayOfInt[1] = this.mCalendar.get(12);
        return arrayOfInt;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arrayOfInt[0] = this.mCalendar.get(11);
      }
    }
  }
  
  public void resetCurRouteInfo()
  {
    this.mUserCurAction = 2;
    this.mNewRouteNodesList = null;
    this.mNewRouteType = -1;
    this.mNewRouteHisDBId = -1;
  }
  
  public void setCurRouteInfoByRouteSubcribeResult(ArrayList<RoutePlanNode> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 3) {
      paramInt2 = -1;
    }
    int i = RouteCustomModel.getInstance().getCurRouteIndex(paramInt1, paramInt2, paramArrayList);
    if (i >= 0)
    {
      setSelRouteCustomPos(i);
      this.mUserCurAction = 2;
      return;
    }
    this.mUserCurAction = 1;
    this.mNewRouteNodesList = paramArrayList;
    this.mNewRouteType = paramInt1;
    this.mNewRouteHisDBId = paramInt2;
  }
  
  public void setRCName(String paramString)
  {
    this.mRCName = paramString;
    this.mIsModifiedName = true;
  }
  
  public void setRCPushIsRepeat()
  {
    if ((this.mRepeatDate != "") && (this.mRepeatDate != null))
    {
      this.mIsRepeat = 1;
      return;
    }
    this.mIsRepeat = 0;
  }
  
  public void setRCPushRepeatDate(String paramString)
  {
    this.mRepeatDate = paramString;
    this.mIsUpdatePushTime = true;
    this.mIsModifiedRepeatDate = true;
  }
  
  public void setRCPushTimeHourAndMinute(int paramInt1, int paramInt2)
  {
    this.mPushTimeHour = paramInt1;
    this.mPushTimeMinute = paramInt2;
    this.mIsUpdatePushTime = true;
  }
  
  public void setRCPushTimeMills(long paramLong)
  {
    this.mPushTimeMills = paramLong;
  }
  
  public void setSelRouteCustomPos(int paramInt)
  {
    clear();
    this.mSelRouteCustomPos = paramInt;
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(this.mSelRouteCustomPos);
    if (localRouteCustomDBObject == null) {
      return;
    }
    this.mIsOpen = localRouteCustomDBObject.getOpen();
    this.mIsRepeat = localRouteCustomDBObject.getIsRepeat();
    this.mIsUpdatePushTime = false;
  }
  
  public void setUserCurAction(int paramInt)
  {
    this.mUserCurAction = paramInt;
  }
  
  public int subcribeNewRouteAndAddToDB(Context paramContext)
  {
    if (this.mNewRouteType != 3) {
      this.mNewRouteHisDBId = -1;
    }
    if ((this.mNewRouteType == 3) && ((this.mNewRouteHisDBId == -1) || (this.mNewRouteNodesList == null))) {
      return -1;
    }
    int i = RouteCustomModel.getInstance().addNewCustomRoute(this.mNewRouteHisDBId, this.mNewRouteNodesList, this.mNewRouteType);
    if (i < 0) {
      if (i == -2) {
        TipTool.onCreateToastDialog(paramContext, 2131296887);
      }
    }
    for (;;)
    {
      return i;
      setSelRouteCustomPos(i);
    }
  }
  
  public void updateRCSettingsInfo(boolean paramBoolean)
  {
    RouteCustomDBObject localRouteCustomDBObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(this.mSelRouteCustomPos);
    if (localRouteCustomDBObject == null) {
      return;
    }
    localRouteCustomDBObject.setOpen(this.mIsOpen);
    if (!paramBoolean)
    {
      if (this.mIsModifiedName) {
        localRouteCustomDBObject.setName(this.mRCName);
      }
      if (this.mPushTimeHour != -1)
      {
        localRouteCustomDBObject.setPushTimeHour(this.mPushTimeHour);
        localRouteCustomDBObject.setPushTimeMinute(this.mPushTimeMinute);
        localRouteCustomDBObject.setPushTimeMills(this.mPushTimeMills);
      }
      if (this.mIsModifiedRepeatDate)
      {
        localRouteCustomDBObject.setRepeatDate(this.mRepeatDate);
        localRouteCustomDBObject.setIsRepeat(this.mIsRepeat);
      }
    }
    RouteCustomModel.getInstance().updateRouteCustomInfo(this.mSelRouteCustomPos);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/RouteCustomController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */