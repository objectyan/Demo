package com.baidu.navisdk.ui.routeguide.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGHighwayModel
{
  public static final int PANER_MODEL_DEFAULT = 0;
  public static final int PANER_MODEL_MINI = 1;
  private static final String TAG = "RGHighwayModel";
  public static final int TYPE_SIMPLE_BOARD_ENTRY = 0;
  public static final int TYPE_SIMPLE_BOARD_EXIT = 4;
  public static final int TYPE_SIMPLE_BOARD_EXIT_FASTWAY = 5;
  public static final int TYPE_SIMPLE_BOARD_GATE = 1;
  public static final int TYPE_SIMPLE_BOARD_SERVICE = 2;
  public static final int TYPE_SIMPLE_BOARD_SERVICE2 = 3;
  private static RGHighwayModel mInstance = null;
  private String curRoadName = null;
  private String entryName = null;
  private int entryRemainDist = -1;
  private String exitCode = null;
  private String[] exitDirections = null;
  private String exitFastwayId = null;
  private String exitFastwayName = null;
  private int exitFastwayRemainDist = -1;
  private String exitName = null;
  private String exitNextRoadName = null;
  private int exitRemainDist = -1;
  private int exitTotalDist = -1;
  private int exitTurnIconType = -1;
  private String gateName = "";
  private int gateRemainDist = -1;
  private int gateTotalDist = -1;
  private boolean isShowHighwayAlongInfo = true;
  private boolean mAutoShowMiniPanerAble = true;
  private int mCurrentPanerMode = 0;
  private int mDriveDistance;
  private boolean mIsExists = false;
  private boolean mMiniPanerDisplayable = false;
  private Bundle mNewHighWayData = new Bundle();
  private String[] nextExitDirections = null;
  private String nextExitName = null;
  private int nextExitRemainDist = -1;
  private int nextPointRemainDist = -1;
  private String optionalNextRoadName = null;
  private String service2Name = null;
  private int service2RemainDist = -1;
  private String serviceName = null;
  private int serviceRemainDist = -1;
  
  public static void destroy()
  {
    if (mInstance != null) {
      mInstance = null;
    }
  }
  
  public static RGHighwayModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGHighwayModel();
    }
    return mInstance;
  }
  
  private boolean isEntryShowInSimpleBoard()
  {
    if (TextUtils.isEmpty(this.entryName)) {}
    while ((this.entryRemainDist > 2000) || (this.entryRemainDist < 10)) {
      return false;
    }
    LogUtil.e("RGHighwayModel", "isEntryShowInSimpleBoard true entryName:" + this.entryName + " entryRemainDist:" + this.entryRemainDist);
    return true;
  }
  
  private boolean isExitFastwayShowInSimpleBoard()
  {
    if (this.exitFastwayRemainDist < 1) {}
    while ((TextUtils.isEmpty(this.exitFastwayName)) || (this.exitFastwayRemainDist > 3000)) {
      return false;
    }
    LogUtil.e("RGHighwayModel", "isExitFastwayShow exitFastwayName:" + this.exitFastwayName + " exitFastwayRemainDist:" + this.exitFastwayRemainDist);
    return true;
  }
  
  private boolean isExitShowInSimpleBoard()
  {
    if (this.exitRemainDist < 1) {}
    String[] arrayOfString;
    do
    {
      do
      {
        return false;
      } while (this.exitRemainDist > 3000);
      arrayOfString = getExitDirections();
    } while ((arrayOfString == null) || (arrayOfString.length < 1) || (TextUtils.isEmpty(arrayOfString[0])) || ("空".equals(arrayOfString[0])));
    LogUtil.e("RGHighwayModel", "isExitShow true");
    return true;
  }
  
  private boolean isGateShowInSimpleBoard()
  {
    if (TextUtils.isEmpty(this.gateName)) {}
    while (this.gateRemainDist < 1) {
      return false;
    }
    LogUtil.e("RGHighwayModel", "isGateShowInSimpleBoard true gateName:" + this.gateName + " gateRemainDist:" + this.gateRemainDist);
    return true;
  }
  
  private boolean isService1ShowInSimpleBoard()
  {
    if (TextUtils.isEmpty(this.serviceName)) {}
    while (this.serviceRemainDist < 1) {
      return false;
    }
    LogUtil.e("RGHighwayModel", "isService1Show true serviceName:" + this.serviceName + " serviceRemainDist:" + this.serviceRemainDist);
    return true;
  }
  
  private void miniPanerDisplayable()
  {
    if (!this.mMiniPanerDisplayable)
    {
      if ((this.mDriveDistance <= 0) && (this.exitRemainDist >= 20000))
      {
        this.mDriveDistance = this.exitRemainDist;
        LogUtil.e("Highway", "满足20公里，开始计算行驶路程");
      }
      if (this.mDriveDistance != 0)
      {
        if (this.mDriveDistance - this.exitRemainDist >= 2000)
        {
          this.mMiniPanerDisplayable = true;
          LogUtil.e("Highway", "满足条件，mini面板允许显示");
        }
        LogUtil.e("Highway", "已经行走" + (this.mDriveDistance - this.exitRemainDist) + "米");
      }
    }
    if ((this.mDriveDistance != 0) && (this.exitRemainDist < 18000))
    {
      this.mDriveDistance = 0;
      LogUtil.e("Highway", "离下一机动点路程小于18km mDriveDistance = 0");
    }
  }
  
  public String formatDirections()
  {
    String[] arrayOfString = getInstance().getExitDirections();
    if ((arrayOfString == null) || (arrayOfString.length < 1)) {}
    while (TextUtils.isEmpty(arrayOfString[0])) {
      return null;
    }
    int j = arrayOfString.length;
    StringBuilder localStringBuilder = new StringBuilder(arrayOfString[0]);
    int i = 1;
    while (i < j)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(arrayOfString[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String getCurRoadName()
  {
    return this.curRoadName;
  }
  
  public int getCurrentPanerMode()
  {
    return this.mCurrentPanerMode;
  }
  
  public int getDefaultTurnIconType()
  {
    return 1;
  }
  
  public String getExitCode()
  {
    if (this.exitCode == null) {
      return "";
    }
    return this.exitCode;
  }
  
  public String[] getExitDirections()
  {
    if ((this.exitDirections != null) && (this.exitDirections.length > 0)) {
      return this.exitDirections;
    }
    if (!TextUtils.isEmpty(this.exitNextRoadName)) {
      return new String[] { this.exitNextRoadName };
    }
    return null;
  }
  
  public String getExitFastwayId()
  {
    if (this.exitFastwayId == null) {
      return "";
    }
    return this.exitFastwayId;
  }
  
  public int getExitTurnIconType()
  {
    return this.exitTurnIconType;
  }
  
  public String getFormatExitRemainDist()
  {
    if (this.exitRemainDist >= 0)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      StringUtils.formatDistance(this.exitRemainDist, StringUtils.UnitLangEnum.ZH, localStringBuffer);
      return localStringBuffer.toString();
    }
    return "";
  }
  
  public boolean getMiniPanerDisplayable()
  {
    return this.mMiniPanerDisplayable;
  }
  
  public Bundle getNewHighWayData()
  {
    return this.mNewHighWayData;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public int getServiceRemainDist()
  {
    return this.serviceRemainDist;
  }
  
  public int[] getSimpleBoardShowType()
  {
    int[] arrayOfInt = new int[5];
    int j = -1;
    if (isExitFastwayShowInSimpleBoard())
    {
      j = -1 + 1;
      arrayOfInt[j] = 5;
    }
    int i = j;
    if (isExitShowInSimpleBoard())
    {
      i = j + 1;
      arrayOfInt[i] = 4;
    }
    int k;
    if (this.gateRemainDist <= this.serviceRemainDist)
    {
      j = i;
      if (isGateShowInSimpleBoard())
      {
        j = i + 1;
        arrayOfInt[j] = 1;
      }
      k = j;
      if (isService1ShowInSimpleBoard())
      {
        k = j + 1;
        arrayOfInt[k] = 2;
      }
      i = k;
      if (isService2ShowInSimpleBoard())
      {
        i = k + 1;
        arrayOfInt[i] = 3;
      }
    }
    while (i == 0)
    {
      return new int[] { arrayOfInt[0] };
      if (this.gateRemainDist <= this.service2RemainDist)
      {
        j = i;
        if (isService1ShowInSimpleBoard())
        {
          j = i + 1;
          arrayOfInt[j] = 2;
        }
        k = j;
        if (isGateShowInSimpleBoard())
        {
          k = j + 1;
          arrayOfInt[k] = 1;
        }
        i = k;
        if (isService2ShowInSimpleBoard())
        {
          i = k + 1;
          arrayOfInt[i] = 3;
        }
      }
      else
      {
        j = i;
        if (isService1ShowInSimpleBoard())
        {
          j = i + 1;
          arrayOfInt[j] = 2;
        }
        k = j;
        if (isService2ShowInSimpleBoard())
        {
          k = j + 1;
          arrayOfInt[k] = 3;
        }
        i = k;
        if (isGateShowInSimpleBoard())
        {
          i = k + 1;
          arrayOfInt[i] = 1;
        }
      }
    }
    if (i > 0) {
      return new int[] { arrayOfInt[0], arrayOfInt[1] };
    }
    return null;
  }
  
  public Drawable getTurnIconDrawable(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return BNStyleManager.getDrawable(1711407632);
    case 8: 
      return BNStyleManager.getDrawable(1711407630);
    }
    return BNStyleManager.getDrawable(1711407631);
  }
  
  public Drawable getTypeIcon(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return JarUtils.getResources().getDrawable(1711407672);
    case 1: 
      return JarUtils.getResources().getDrawable(1711407674);
    case 2: 
    case 3: 
      return JarUtils.getResources().getDrawable(1711407675);
    }
    return JarUtils.getResources().getDrawable(1711407673);
  }
  
  public String getTypeName(int paramInt)
  {
    Object localObject2;
    switch (paramInt)
    {
    default: 
      localObject2 = null;
      return (String)localObject2;
    case 0: 
      return this.entryName;
    case 1: 
      return this.gateName;
    case 2: 
      return this.serviceName;
    case 3: 
      return this.service2Name;
    case 4: 
      Object localObject1 = getExitDirections();
      if ((localObject1 == null) || (localObject1.length == 0)) {
        return this.exitNextRoadName;
      }
      localObject1 = getExitDirections()[0];
      paramInt = 1;
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt >= getExitDirections().length) {
          break;
        }
        localObject1 = (String)localObject1 + " " + getExitDirections()[paramInt];
        paramInt += 1;
      }
    }
    if (this.exitFastwayName != null) {
      return this.exitFastwayName.replace(",", " ");
    }
    return this.exitFastwayName;
  }
  
  public int getTypeRemainDist(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.entryRemainDist;
    case 1: 
      return this.gateRemainDist;
    case 2: 
      return this.serviceRemainDist;
    case 3: 
      return this.service2RemainDist;
    case 4: 
      return this.exitRemainDist;
    }
    return this.exitFastwayRemainDist;
  }
  
  public boolean hasExitCode()
  {
    return (this.exitCode != null) && (this.exitCode.length() > 0);
  }
  
  public boolean isAutoShowMiniPanerAble()
  {
    return this.mAutoShowMiniPanerAble;
  }
  
  public boolean isExists()
  {
    return this.mIsExists;
  }
  
  public boolean isNeedToShowGateInfo()
  {
    return (this.gateName != null) && (this.gateName.trim().length() > 0) && (this.gateRemainDist > 0) && (this.gateRemainDist <= this.exitRemainDist);
  }
  
  public boolean isService2ShowInSimpleBoard()
  {
    if (TextUtils.isEmpty(this.service2Name)) {}
    while (this.service2RemainDist < 1) {
      return false;
    }
    LogUtil.e("RGHighwayModel", "isService2Show true service2Name:" + this.service2Name + " service2RemainDist:" + this.service2RemainDist);
    return true;
  }
  
  public boolean isShowHighwayAlongInfo()
  {
    return this.isShowHighwayAlongInfo;
  }
  
  public boolean isSimpleBoardCanShow()
  {
    LogUtil.e("RGHighwayModel", "isSimpleBoardCanShow start");
    int[] arrayOfInt = getSimpleBoardShowType();
    if (arrayOfInt == null) {}
    while (arrayOfInt.length == 0) {
      return false;
    }
    LogUtil.e("RGHighwayModel", "isSimpleBoardCanShow true");
    return true;
  }
  
  public boolean isTurnIconTypeValid(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 2);
  }
  
  public void reset()
  {
    LogUtil.e("RGHighwayModel", "reset");
    this.entryName = null;
    this.entryRemainDist = -1;
    this.exitFastwayName = null;
    this.exitFastwayId = null;
    this.exitFastwayRemainDist = -1;
    this.exitName = null;
    this.exitCode = null;
    this.exitDirections = null;
    this.exitNextRoadName = null;
    this.exitRemainDist = -1;
    this.exitTotalDist = -1;
    this.exitTurnIconType = -1;
    this.optionalNextRoadName = null;
    this.serviceName = null;
    this.serviceRemainDist = -1;
    this.service2Name = null;
    this.service2RemainDist = -1;
    this.nextExitName = null;
    this.nextExitDirections = null;
    this.nextExitRemainDist = -1;
    this.gateName = "";
    this.gateRemainDist = -1;
    this.gateTotalDist = -1;
    this.mIsExists = false;
    this.mDriveDistance = 0;
    this.mMiniPanerDisplayable = false;
    this.mAutoShowMiniPanerAble = true;
    this.mCurrentPanerMode = 0;
  }
  
  public void setAutoShowMiniPanerAble(boolean paramBoolean)
  {
    this.mAutoShowMiniPanerAble = paramBoolean;
  }
  
  public void setCurRoadName(String paramString)
  {
    this.curRoadName = paramString;
  }
  
  public void setCurrentPanerMode(int paramInt)
  {
    this.mCurrentPanerMode = paramInt;
  }
  
  public void setMiniPanerDisplayable(boolean paramBoolean)
  {
    this.mMiniPanerDisplayable = paramBoolean;
  }
  
  public void setNextPointRemainDist(int paramInt)
  {
    this.nextPointRemainDist = paramInt;
  }
  
  public void updateData(Bundle paramBundle)
  {
    boolean bool = true;
    if (paramBundle == null)
    {
      LogUtil.e("RGHighwayModel", "updateData=null");
      return;
    }
    LogUtil.e("RGHighwayModel", "updateData=" + paramBundle.toString());
    this.exitName = paramBundle.getString("highway_exit_ic");
    this.exitCode = paramBundle.getString("highway_exit_iccode");
    if ((this.exitCode != null) && (this.exitCode.trim().length() == 0)) {
      this.exitCode = null;
    }
    if (this.exitCode != null) {
      this.mNewHighWayData.putString("highway_exit_iccode", this.exitCode);
    }
    String str = paramBundle.getString("highway_exit_directionname");
    if ((str != null) && (str.trim().length() > 0))
    {
      this.exitDirections = str.trim().split(",");
      if (this.exitDirections != null) {
        this.mNewHighWayData.putString("highway_exit_directionname", str);
      }
      this.exitNextRoadName = paramBundle.getString("highway_exit_nextroadname");
      if (this.exitNextRoadName != null) {
        this.mNewHighWayData.putString("highway_exit_nextroadname", this.exitNextRoadName);
      }
      this.exitRemainDist = paramBundle.getInt("highway_exit_remain_dist", -1);
      if (this.exitRemainDist >= 0) {
        this.mNewHighWayData.putInt("highway_exit_remain_dist", this.exitRemainDist);
      }
      this.exitTotalDist = paramBundle.getInt("highway_exit_total_dist", -1);
      this.exitTurnIconType = paramBundle.getInt("highway_exit_direction", -1);
      this.nextExitName = paramBundle.getString("highway_nextexit_ic");
      str = paramBundle.getString("highway_nextexit_direction_name");
      if ((str == null) || (str.trim().length() <= 0)) {
        break label496;
      }
    }
    label496:
    for (this.nextExitDirections = str.trim().split(",");; this.nextExitDirections = null)
    {
      this.nextExitRemainDist = paramBundle.getInt("highway_nextexit_remain_dist", -1);
      this.serviceName = null;
      if (paramBundle.containsKey("highway_service_name")) {
        this.serviceName = paramBundle.getString("highway_service_name");
      }
      this.serviceRemainDist = paramBundle.getInt("highway_service_remain_dist", -1);
      this.service2Name = null;
      if (paramBundle.containsKey("highway_nextservice_name")) {
        this.service2Name = paramBundle.getString("highway_nextservice_name");
      }
      this.service2RemainDist = paramBundle.getInt("highway_nextservice_remain_dist", -1);
      this.gateName = null;
      if (paramBundle.containsKey("highway_gate_name")) {
        this.gateName = paramBundle.getString("highway_gate_name");
      }
      this.gateRemainDist = paramBundle.getInt("highway_gate_remain_dist", -1);
      this.gateTotalDist = paramBundle.getInt("highway_gate_total_dist", -1);
      if (paramBundle.getInt("highway_hide_info", 1) == 1) {
        bool = false;
      }
      this.isShowHighwayAlongInfo = bool;
      this.mNewHighWayData.putBoolean("highway_hide_info", this.isShowHighwayAlongInfo);
      this.curRoadName = paramBundle.getString("highway_cur_road_name");
      miniPanerDisplayable();
      return;
      this.exitDirections = null;
      break;
    }
  }
  
  public void updateEntryData(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      LogUtil.e("RGHighwayModel", "updateEntryData=null");
      this.entryName = null;
      this.entryRemainDist = -1;
      return;
    }
    LogUtil.e("RGHighwayModel", "updateEntryData=" + paramBundle.toString());
    this.entryName = paramBundle.getString("highway_in_roadname");
    this.entryRemainDist = paramBundle.getInt("highway_in_remain_dist");
  }
  
  public void updateExists(boolean paramBoolean)
  {
    this.mIsExists = paramBoolean;
  }
  
  public void updateExitFastwayData(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      LogUtil.e("RGHighwayModel", "updateExitFastwayData=null");
      this.exitFastwayName = null;
      this.exitFastwayRemainDist = -1;
      return;
    }
    LogUtil.e("RGHighwayModel", "updateExitFastwayData=" + paramBundle.toString());
    this.exitFastwayName = paramBundle.getString("fastway_exit_roadname");
    this.exitFastwayRemainDist = paramBundle.getInt("fastway_exit_remain_dist");
    this.exitFastwayId = paramBundle.getString("fastway_exit_road_id");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGHighwayModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */