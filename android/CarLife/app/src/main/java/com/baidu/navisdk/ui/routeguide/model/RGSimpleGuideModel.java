package com.baidu.navisdk.ui.routeguide.model;

import android.content.res.Resources;
import android.os.Bundle;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.subview.BNavR;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.DateTimeUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class RGSimpleGuideModel
{
  public static final int UPDATE_TYPE_NEXTINFO = 1;
  public static final int UPDATE_TYPE_TOTALINFO = 2;
  public static int mCalcRouteType = 0;
  private static RGSimpleGuideModel mInstance = null;
  public static boolean mIsOfflineToOnline;
  public static boolean mIsRPPrefer;
  public static boolean mIsSafetyShareGuideShow;
  public static boolean mIsSatellite;
  public static boolean mIsUgcOfficialEvent;
  public static Bundle sSimpleGuideBundle = new Bundle();
  private final String TAG = "RouteGuide";
  public boolean canSilentIconShow = false;
  public boolean isCalcRouteFail = false;
  public boolean isFirstDataOk = false;
  private long mArriveTime = 0L;
  private String mArriveTimeS = "";
  public double mCompletePercentage = 0.0D;
  private String mCurIconName = new String();
  private String mCurRoadName = "";
  private int mDistCur2NextGP = 1000;
  private int mFirstGuideMatchMode;
  private boolean mIsGPSFixed = false;
  private boolean mIsGarlogoFree = false;
  private boolean mIsHighwayExCur2NextGP = false;
  private boolean mIsStraight = false;
  private boolean mIsYawing = false;
  private String mLastIconName = new String();
  private Bundle mNextGuideInfoBundle = new Bundle();
  private int mNextTurnKind = 0;
  private int mSatelliteNum = 0;
  private String mTTSText = null;
  private Bundle mTotalInfoBundle = new Bundle();
  private String mTotalRemainDistS = "";
  private String mTotalRemainTime = "";
  public HashMap<String, Integer> mTurnIconMap = new HashMap();
  HashMap<String, String> mTurnNameMap = new HashMap();
  
  static
  {
    mIsOfflineToOnline = false;
    mIsRPPrefer = false;
    mIsSatellite = false;
    mIsUgcOfficialEvent = false;
    mIsSafetyShareGuideShow = false;
  }
  
  public RGSimpleGuideModel()
  {
    int j = RouteGuideParams.gTurnIconName.length;
    int i = 0;
    while (i < j)
    {
      this.mTurnIconMap.put(RouteGuideParams.gTurnIconName[i], Integer.valueOf(BNavR.gTurnIconID[i]));
      this.mTurnNameMap.put(RouteGuideParams.gTurnIconName[i], RouteGuideParams.gTurnTypeDesc[i]);
      i += 1;
    }
    this.mLastIconName = "";
    this.mCurIconName = "";
  }
  
  private void calculateArriveTime(int paramInt)
  {
    this.mArriveTime = System.currentTimeMillis();
    Object localObject = new Date(this.mArriveTime);
    this.mArriveTime += paramInt * 1000;
    Date localDate = new Date(this.mArriveTime);
    this.mArriveTimeS = new SimpleDateFormat("HH:mm").format(localDate);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    localGregorianCalendar1.setTime((Date)localObject);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTime(localDate);
    if (localGregorianCalendar1.get(5) == localGregorianCalendar2.get(5))
    {
      this.mArriveTimeS = String.format(BNStyleManager.getString(1711669855), new Object[] { this.mArriveTimeS });
      return;
    }
    paramInt = getIntervalDays((Date)localObject, localDate);
    if (paramInt == 1)
    {
      this.mArriveTimeS = String.format(BNStyleManager.getString(1711669858), new Object[] { this.mArriveTimeS });
      return;
    }
    if (paramInt > 1)
    {
      localObject = DateTimeUtils.getWeek(localDate);
      this.mArriveTimeS = String.format(BNStyleManager.getString(1711669860), new Object[] { localObject, this.mArriveTimeS });
      return;
    }
    this.mArriveTimeS = String.format(BNStyleManager.getString(1711669855), new Object[] { this.mArriveTimeS });
  }
  
  private void calculateCompletePercentage(int paramInt)
  {
    int i = BNNaviResultModel.getInstance().getEstimatedRemainDist();
    if (i == 0)
    {
      this.mCompletePercentage = 0.0D;
      return;
    }
    this.mCompletePercentage = ((i - paramInt) / i);
  }
  
  private void calculateTotalRemainDistString(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer("剩余");
    StringUtils.formatDistance(paramInt, StringUtils.UnitLangEnum.ZH, localStringBuffer);
    this.mTotalRemainDistS = localStringBuffer.toString();
  }
  
  private void calculateTotalRemainTimeString(int paramInt)
  {
    this.mTotalRemainTime = StringUtils.getFormatTime(paramInt);
  }
  
  public static RGSimpleGuideModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGSimpleGuideModel();
    }
    return mInstance;
  }
  
  private static int getIntervalDays(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 == null) || (paramDate2 == null)) {
      return 0;
    }
    long l1 = paramDate2.getTime() - paramDate1.getTime();
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      paramDate1 = localSimpleDateFormat.parse(localSimpleDateFormat.format(paramDate1));
      long l2 = localSimpleDateFormat.parse(localSimpleDateFormat.format(paramDate2)).getTime();
      long l3 = paramDate1.getTime();
      l1 = l2 - l3;
    }
    catch (Exception paramDate1)
    {
      for (;;) {}
    }
    return (int)(l1 / 86400000L);
  }
  
  private void viaPointProcess(String paramString)
  {
    this.mLastIconName = this.mCurIconName;
    this.mCurIconName = paramString;
    LogUtil.e("RouteGuide", "mLastIconName = " + this.mLastIconName + ", mCurIconName = " + this.mCurIconName);
  }
  
  public String getArriveTimeChineseString()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String[] arrayOfString;
    if (this.mArriveTimeS != null)
    {
      localObject1 = localObject2;
      if (this.mArriveTimeS.length() > 0)
      {
        arrayOfString = this.mArriveTimeS.substring(0, 5).split(":");
        localObject1 = localObject2;
        if (arrayOfString != null)
        {
          localObject1 = localObject2;
          if (arrayOfString.length < 2) {}
        }
      }
    }
    try
    {
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append(StringUtils.doubleNumberToChineseWord(Integer.parseInt(arrayOfString[0])));
      ((StringBuffer)localObject1).append("点");
      ((StringBuffer)localObject1).append(StringUtils.doubleNumberToChineseWord(Integer.parseInt(arrayOfString[1])));
      ((StringBuffer)localObject1).append("分到达");
      localObject1 = ((StringBuffer)localObject1).toString();
      return (String)localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getArriveTimeString()
  {
    return this.mArriveTimeS;
  }
  
  public String getCurRoadName()
  {
    if ((this.mCurRoadName == null) || (this.mCurRoadName.length() == 0)) {
      return BNStyleManager.getString(1711669440);
    }
    return this.mCurRoadName;
  }
  
  public Bundle getDataFromRouteResult(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      try
      {
        this.mNextGuideInfoBundle.putInt("updatetype", 1);
        int i = BNavR.gTurnIconID[1];
        if (paramInt1 < BNavR.gTurnIconID.length - 1) {
          i = BNavR.gTurnIconID[paramInt1];
        }
        this.mNextGuideInfoBundle.putInt("resid", i);
        if (paramInt1 < RouteGuideParams.gTurnIconName.length)
        {
          String str = RouteGuideParams.gTurnIconName[paramInt1];
          this.mNextGuideInfoBundle.putString("icon_name", str);
        }
        this.mNextGuideInfoBundle.putInt("remain_dist", paramInt2);
        if (paramString != null) {
          continue;
        }
        this.mNextGuideInfoBundle.putString("road_name", "");
        updateTotalRemainDistAndTime(paramInt3, paramInt4);
        sSimpleGuideBundle.putAll(this.mTotalInfoBundle);
        sSimpleGuideBundle.putAll(this.mNextGuideInfoBundle);
      }
      catch (Exception paramString)
      {
        LogUtil.e("RouteGuide", "getDataFromRouteResult err:" + paramString.getMessage());
        continue;
      }
      return sSimpleGuideBundle;
      this.mNextGuideInfoBundle.putString("road_name", paramString);
    }
  }
  
  public String getDistEnd(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.endsWith("米")) {
        return "米";
      }
      if (paramString.endsWith("公里")) {
        return "公里";
      }
    }
    return null;
  }
  
  public String getDistStart(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.endsWith("米")) {
        return paramString.substring(0, paramString.length() - 1);
      }
      if (paramString.endsWith("公里")) {
        return paramString.substring(0, paramString.length() - 2);
      }
    }
    return null;
  }
  
  public int getFollowIcon()
  {
    if ((this.mNextTurnKind > 0) && (this.mNextTurnKind < BNavR.gTurnIconID.length)) {
      return BNavR.gTurnIconID[this.mNextTurnKind];
    }
    return -1;
  }
  
  public String getFollowInfo()
  {
    if ((this.mNextTurnKind > 0) && (this.mNextTurnKind < RouteGuideParams.gTurnTypeDescForFollowInfo.length)) {
      return "随后" + RouteGuideParams.gTurnTypeDescForFollowInfo[this.mNextTurnKind];
    }
    return "";
  }
  
  public String getFormatAfterMeters(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringUtils.formatDistance(paramInt, StringUtils.UnitLangEnum.ZH, localStringBuffer);
    return JarUtils.getResources().getString(1711669433, new Object[] { localStringBuffer });
  }
  
  public String getFormatGoNextRoad(String paramString)
  {
    return JarUtils.getResources().getString(1711669434, new Object[] { paramString });
  }
  
  public String getFormatNextRoadInfo(int paramInt, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringUtils.formatDistance(paramInt, StringUtils.UnitLangEnum.ZH, localStringBuffer);
    return JarUtils.getResources().getString(1711669435, new Object[] { localStringBuffer, paramString });
  }
  
  public String getFuzzyTV()
  {
    Bundle localBundle = new Bundle();
    JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(localBundle);
    return localBundle.getString("planar_name");
  }
  
  public String getNextGuidanceChineseWord()
  {
    Object localObject = new StringBuffer();
    if (this.mNextGuideInfoBundle != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int i = this.mNextGuideInfoBundle.getInt("remain_dist", 0);
      if (i >= 0) {
        localStringBuffer.append(StringUtils.formatDistanceToChineseString(i));
      }
      String str = this.mNextGuideInfoBundle.getString("road_name");
      localObject = localStringBuffer;
      if (str != null)
      {
        localStringBuffer.append("后进入");
        localStringBuffer.append(str);
        localObject = localStringBuffer;
      }
    }
    if (((StringBuffer)localObject).length() > 0) {
      return ((StringBuffer)localObject).toString();
    }
    return "没有下一路口数据";
  }
  
  public Bundle getNextGuideInfo()
  {
    return this.mNextGuideInfoBundle;
  }
  
  public int getSatelliteNum()
  {
    if (!this.mIsGPSFixed) {
      return 0;
    }
    return this.mSatelliteNum;
  }
  
  public String getTTSText()
  {
    return this.mTTSText;
  }
  
  public Bundle getTotalInfo()
  {
    return this.mTotalInfoBundle;
  }
  
  public int getTotalRemainDist()
  {
    try
    {
      if ((this.mTotalInfoBundle != null) && (this.mTotalInfoBundle.containsKey("totaldist")))
      {
        int i = this.mTotalInfoBundle.getInt("totaldist");
        return i;
      }
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public String getTotalRemainDistString()
  {
    return this.mTotalRemainDistS;
  }
  
  public String getTotalRemainTimeString()
  {
    return this.mTotalRemainTime;
  }
  
  public int getTurnIconRes(String paramString)
  {
    int j = -1;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (this.mTurnIconMap.containsKey(paramString)) {
        i = ((Integer)this.mTurnIconMap.get(paramString)).intValue();
      }
    }
    LogUtil.e("RouteGuide", "getTurnIconRes() in=" + paramString + ", id=" + i);
    return i;
  }
  
  public String getTurnNameFromTurnIcon(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (String)this.mTurnNameMap.get(paramString);
  }
  
  public boolean isCarlogoFree()
  {
    if (BNavConfig.pRGLocateMode == 2) {
      return false;
    }
    return this.mIsGarlogoFree;
  }
  
  public boolean isFirstGuideFuzzy()
  {
    return this.mFirstGuideMatchMode == 1;
  }
  
  public boolean isGPSFixed()
  {
    if (BNavConfig.pRGLocateMode == 2) {
      return true;
    }
    return this.mIsGPSFixed;
  }
  
  public boolean isGPSOpened()
  {
    return BNSysLocationManager.getInstance().isGpsEnabled();
  }
  
  public boolean isShowFollowInfo()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((this.mNextGuideInfoBundle == null) || (!this.mNextGuideInfoBundle.containsKey("remain_dist"))) {}
    int i;
    do
    {
      do
      {
        return false;
      } while ((this.mNextTurnKind <= 0) || (this.mNextTurnKind >= RouteGuideParams.gTurnTypeDescForFollowInfo.length));
      i = this.mNextGuideInfoBundle.getInt("remain_dist");
      LogUtil.e("RouteGuide", "isShowFollowInfo() remainDist=" + i + ", mIsHighwayExCur2NextGP=" + this.mIsHighwayExCur2NextGP + ", mDistCur2NextGP=" + this.mDistCur2NextGP);
    } while (i > 2000);
    if (this.mIsHighwayExCur2NextGP)
    {
      if ((this.mDistCur2NextGP >= 0) && (this.mDistCur2NextGP <= 200)) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
    if ((this.mDistCur2NextGP >= 0) && (this.mDistCur2NextGP <= 100)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean isStraight()
  {
    return this.mIsStraight;
  }
  
  public boolean isYawing()
  {
    return this.mIsYawing;
  }
  
  public void reset()
  {
    LogUtil.e("RouteGuide", "reset");
    this.mIsStraight = false;
    this.mIsYawing = false;
    this.mTTSText = null;
    this.mIsGPSFixed = false;
    this.mSatelliteNum = 0;
    this.mIsGarlogoFree = false;
    this.mLastIconName = "";
    this.mCurIconName = "";
    mIsOfflineToOnline = false;
    mIsRPPrefer = false;
    mIsUgcOfficialEvent = false;
    mIsSatellite = false;
    this.mNextTurnKind = 0;
    this.mDistCur2NextGP = 1000;
    this.mIsHighwayExCur2NextGP = false;
    mIsSafetyShareGuideShow = false;
    this.isFirstDataOk = false;
    this.isCalcRouteFail = false;
    this.mTotalRemainDistS = "";
    this.mTotalRemainTime = "";
    this.mCompletePercentage = 0.0D;
    if (sSimpleGuideBundle != null) {
      sSimpleGuideBundle.clear();
    }
    if (this.mNextGuideInfoBundle != null) {
      this.mNextGuideInfoBundle.clear();
    }
    if (this.mTotalInfoBundle != null) {
      this.mTotalInfoBundle.clear();
    }
    mCalcRouteType = 0;
  }
  
  public void setFirstRGInfo(Bundle paramBundle)
  {
    LogUtil.e("RouteGuide", "setFirstRGInfo=" + paramBundle.toString());
    this.mFirstGuideMatchMode = 0;
    int i = paramBundle.getInt("totaltime", 0);
    int j = paramBundle.getInt("totaldist", 0);
    int k = paramBundle.getInt("remain_dist", 0);
    int m = paramBundle.getInt("resid", 0);
    String str = paramBundle.getString("road_name");
    this.mFirstGuideMatchMode = paramBundle.getInt("resid", 0);
    if (((m > 0) && (i > 0)) || (isFirstGuideFuzzy()))
    {
      getDataFromRouteResult(m, k, str, j, i);
      this.isFirstDataOk = true;
    }
  }
  
  public void setIsYawing(boolean paramBoolean)
  {
    LogUtil.e("RouteGuide", "setIsYawing :" + paramBoolean);
    this.mIsYawing = paramBoolean;
  }
  
  public void updateCarlogoFree(boolean paramBoolean)
  {
    this.mIsGarlogoFree = paramBoolean;
  }
  
  public void updateCurRoadName(String paramString)
  {
    LogUtil.e("RouteGuide", "engine updateRoadName --> " + paramString);
    this.mCurRoadName = paramString;
  }
  
  public void updateGPSFixed(boolean paramBoolean)
  {
    this.mIsGPSFixed = paramBoolean;
    BNEventManager localBNEventManager = BNEventManager.getInstance();
    if (this.mIsGPSFixed) {}
    for (int i = 5;; i = 6)
    {
      localBNEventManager.onOtherAction(i, 0, 0, null);
      return;
    }
  }
  
  public Bundle updateNextGuideInfo()
  {
    boolean bool2 = true;
    this.mNextGuideInfoBundle.putInt("updatetype", 1);
    String str1 = sSimpleGuideBundle.getString("road_name");
    String str2 = sSimpleGuideBundle.getString("icon_name");
    int i = sSimpleGuideBundle.getInt("remain_dist");
    int j = sSimpleGuideBundle.getInt("start_dist");
    if (sSimpleGuideBundle.getInt("straight", 0) > 0)
    {
      bool1 = true;
      this.mIsStraight = bool1;
      this.mNextGuideInfoBundle.putBoolean("straight", this.mIsStraight);
      LogUtil.e("test", "nextRoad = " + str1);
      ((Integer)this.mTurnIconMap.get(RouteGuideParams.gTurnIconName[0])).intValue();
      if ((str2 != null) && (this.mTurnIconMap.containsKey(str2)))
      {
        LogUtil.e("RouteGuide", "updateGuideInfo==   iconName=" + str2);
        int k = ((Integer)this.mTurnIconMap.get(str2)).intValue();
        this.mNextGuideInfoBundle.putInt("resid", k);
        this.mNextGuideInfoBundle.putString("icon_name", str2);
        viaPointProcess(str2);
      }
      if (str1 != null) {
        this.mNextGuideInfoBundle.putString("road_name", str1);
      }
      str1 = sSimpleGuideBundle.getString("cur_road_name");
      if (str1 != null) {
        this.mNextGuideInfoBundle.putString("cur_road_name", str1);
      }
      this.mNextGuideInfoBundle.putInt("remain_dist", i);
      this.mNextGuideInfoBundle.putInt("start_dist", j);
      this.mNextTurnKind = 0;
      if (sSimpleGuideBundle.containsKey("NextTurnKind")) {
        this.mNextTurnKind = sSimpleGuideBundle.getInt("NextTurnKind");
      }
      this.mDistCur2NextGP = 1000;
      if (sSimpleGuideBundle.containsKey("DistCur2NextGP")) {
        this.mDistCur2NextGP = sSimpleGuideBundle.getInt("DistCur2NextGP");
      }
      this.mIsHighwayExCur2NextGP = false;
      if (sSimpleGuideBundle.containsKey("HighwayExCur2NextGP")) {
        if (sSimpleGuideBundle.getInt("HighwayExCur2NextGP") <= 0) {
          break label459;
        }
      }
    }
    label459:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mIsHighwayExCur2NextGP = bool1;
      LogUtil.e("RouteGuide", "RGSimpleGuideModel.updateNextGuideInfo() mNextTurnKind=" + this.mNextTurnKind + ", mDistCur2NextGP=" + this.mDistCur2NextGP + ", mIsHighwayExCur2NextGP=" + this.mIsHighwayExCur2NextGP);
      return this.mNextGuideInfoBundle;
      bool1 = false;
      break;
    }
  }
  
  public Bundle updateNextGuideInfo(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      try
      {
        this.mNextGuideInfoBundle.putInt("updatetype", 1);
        int i = BNavR.gTurnIconID[1];
        if (paramInt1 < BNavR.gTurnIconID.length - 1) {
          i = BNavR.gTurnIconID[paramInt1];
        }
        this.mNextGuideInfoBundle.putInt("resid", i);
        if (paramInt1 < RouteGuideParams.gTurnIconName.length)
        {
          String str = RouteGuideParams.gTurnIconName[paramInt1];
          this.mNextGuideInfoBundle.putString("icon_name", str);
        }
        this.mNextGuideInfoBundle.putInt("remain_dist", paramInt2);
        if (paramString != null) {
          continue;
        }
        this.mNextGuideInfoBundle.putString("road_name", "");
        sSimpleGuideBundle.putAll(this.mNextGuideInfoBundle);
      }
      catch (Exception paramString)
      {
        LogUtil.e("RouteGuide", "updateNextGuiInfoOnly err:" + paramString.getMessage());
        continue;
      }
      return this.mNextGuideInfoBundle;
      this.mNextGuideInfoBundle.putString("road_name", paramString);
    }
  }
  
  public void updateSatelliteNum(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i > 15) {
      paramInt = 15;
    }
    this.mSatelliteNum = paramInt;
  }
  
  public String updateTTSText(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    this.mTTSText = paramString;
    if (paramString.startsWith("嘀嘀嘀")) {
      this.mTTSText = paramString.substring("嘀嘀嘀".length());
    }
    return this.mTTSText;
  }
  
  public Bundle updateTotalRemainDistAndTime(int paramInt1, int paramInt2)
  {
    LogUtil.e("RouteGuide", "updateTotalRemainDistAndTime() nDist=" + paramInt1 + ", nTime=" + paramInt2);
    this.mTotalInfoBundle.putInt("updatetype", 2);
    this.mTotalInfoBundle.putInt("totaldist", paramInt1);
    this.mTotalInfoBundle.putInt("totaltime", paramInt2);
    NaviStatItem.getInstance().mDistToDest = paramInt1;
    calculateCompletePercentage(paramInt1);
    calculateTotalRemainDistString(paramInt1);
    calculateArriveTime(paramInt2);
    calculateTotalRemainTimeString(paramInt2);
    return this.mTotalInfoBundle;
  }
  
  public static abstract interface CalcRouteTypeInNav
  {
    public static final int TYPE_ADD_VIA = 1;
    public static final int TYPE_CAR_PLATE = 3;
    public static final int TYPE_END_CAR_PARK = 4;
    public static final int TYPE_INVALID = 0;
    public static final int TYPE_ROUTE_SORT = 2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGSimpleGuideModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */