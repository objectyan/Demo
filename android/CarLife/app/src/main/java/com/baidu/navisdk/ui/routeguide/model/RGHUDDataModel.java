package com.baidu.navisdk.ui.routeguide.model;

import android.content.res.Resources;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Locale;

public class RGHUDDataModel
{
  public static final int DEFAULT_UPDATE_TYPE = -1;
  private static final int[] DIRECTION_RES_ARRAY = { 1711669375, 1711669376, 1711669377, 1711669378, 1711669379, 1711669380, 1711669381, 1711669382 };
  public static final int HIGHWAY_UPDATE = 2;
  public static final int MAX_CAR_SPEED = 240;
  public static final int NORMAL_ROAD_UPDATE = 1;
  public static final String TAG = "RGHUDDataModel";
  private static boolean isHighWayModel;
  public static int latestUpdateType = -1;
  private static RGHUDDataModel mInstance = null;
  public static int totalDistance;
  private boolean hasExitCode = false;
  private boolean isSimpleGuideAlong = false;
  private boolean mIsYaw = false;
  private Bundle mLastestHUDData = null;
  
  static
  {
    isHighWayModel = false;
    totalDistance = 0;
  }
  
  public static String getFormatDistance(int paramInt)
  {
    if (paramInt >= 1000) {
      return String.valueOf(paramInt / 1000);
    }
    if (paramInt < 50) {
      return String.valueOf(0);
    }
    if (paramInt >= 950) {
      return String.valueOf(1);
    }
    int i = paramInt;
    if ((paramInt + 100) % 100 >= 50) {
      i = paramInt + 50;
    }
    return String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(i / 1000.0F) });
  }
  
  public static RGHUDDataModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGHUDDataModel();
    }
    return mInstance;
  }
  
  public static int getProgress(int paramInt1, int paramInt2)
  {
    int i = 100;
    if (paramInt2 <= 0) {}
    do
    {
      do
      {
        return i;
        if (paramInt1 <= 0) {
          return 0;
        }
      } while (paramInt1 >= paramInt2);
      paramInt1 = paramInt1 * 100 / paramInt2;
      i = paramInt1;
    } while (paramInt1 != 0);
    return 1;
  }
  
  public static boolean isHighWayModel()
  {
    return isHighWayModel;
  }
  
  public static void setHighWayModel(boolean paramBoolean)
  {
    isHighWayModel = paramBoolean;
  }
  
  private int simpleGuideResToHUDRes(int paramInt)
  {
    int i;
    if (paramInt == 1711407698) {
      i = 1711407633;
    }
    do
    {
      return i;
      if (paramInt == 1711407699) {
        return 1711407634;
      }
      if (paramInt == 1711407700) {
        return 1711407635;
      }
      if (paramInt == 1711407702) {
        return 1711407637;
      }
      if (paramInt == 1711407704) {
        return 1711407639;
      }
      if (paramInt == 1711407706) {
        return 1711407640;
      }
      if (paramInt == 1711407713) {
        return 1711407641;
      }
      if (paramInt == 1711407719) {
        return 1711407647;
      }
      if (paramInt == 1711407720) {
        return 1711407640;
      }
      if (paramInt == 1711407721) {
        return 1711407648;
      }
      if (paramInt == 1711407722) {
        return 1711407649;
      }
      if (paramInt == 1711407723) {
        return 1711407650;
      }
      if (paramInt == 1711407728) {
        return 1711407655;
      }
      if (paramInt == 1711407736) {
        return 1711407663;
      }
      if (paramInt == 1711407734) {
        return 1711407661;
      }
      if (paramInt == 1711407735) {
        return 1711407662;
      }
      if (paramInt == 1711407737) {
        return 1711407664;
      }
      if (paramInt == 1711407738) {
        return 1711407665;
      }
      if (paramInt == 1711407701) {
        return 1711407636;
      }
      if (paramInt == 1711407703) {
        return 1711407638;
      }
      if (paramInt == 1711407750) {
        return 1711407666;
      }
      if (paramInt == 1711407714) {
        return 1711407642;
      }
      if (paramInt == 1711407715) {
        return 1711407643;
      }
      if (paramInt == 1711407716) {
        return 1711407644;
      }
      if (paramInt == 1711407717) {
        return 1711407645;
      }
      if (paramInt == 1711407718) {
        return 1711407646;
      }
      if (paramInt == 1711407729) {
        return 1711407656;
      }
      if (paramInt == 1711407730) {
        return 1711407657;
      }
      if (paramInt == 1711407731) {
        return 1711407658;
      }
      if (paramInt == 1711407732) {
        return 1711407659;
      }
      if (paramInt == 1711407733) {
        return 1711407660;
      }
      if (paramInt == 1711407707) {
        return 1711407648;
      }
      if (paramInt == 1711407708) {
        return 1711407663;
      }
      if (paramInt == 1711407709) {
        return 1711407635;
      }
      if (paramInt == 1711407710) {
        return 1711407634;
      }
      if (paramInt == 1711407711) {
        return 1711407637;
      }
      if (paramInt == 1711407724) {
        return 1711407651;
      }
      if (paramInt == 1711407725) {
        return 1711407652;
      }
      if (paramInt == 1711407726) {
        return 1711407653;
      }
      i = paramInt;
    } while (paramInt != 1711407727);
    return 1711407654;
  }
  
  public Bundle getData()
  {
    Bundle localBundle1 = new Bundle();
    BNRouteGuider.getInstance().getHUDData(localBundle1);
    Bundle localBundle2 = new Bundle();
    if (localBundle1 != null)
    {
      int i = localBundle1.getInt("hud_head_angle");
      if ((i > -1) && (i < DIRECTION_RES_ARRAY.length)) {
        localBundle2.putString("hud_head_angle", JarUtils.getResources().getString(DIRECTION_RES_ARRAY[i]));
      }
    }
    return localBundle2;
  }
  
  public Bundle highWayDataToHUD(Bundle paramBundle)
  {
    LogUtil.e("RGHUDDataModel", "highWayDataToHUD");
    Bundle localBundle = new Bundle();
    int i = paramBundle.getInt("highway_exit_direction", -1);
    if (i != -1) {
      localBundle.putInt("hud_highway_exitdirection", i);
    }
    i = paramBundle.getInt("highway_exit_remain_dist");
    if (i >= 0)
    {
      LogUtil.e("hud", "containKey ExitRemainDist");
      localBundle.putInt("hud_exitremaindistance", i);
    }
    String str = paramBundle.getString("highway_exit_nextroadname");
    if (str != null)
    {
      LogUtil.e("hud", "containKey ExitNextRoad");
      localBundle.putString("hud_exitnextroad", str);
    }
    str = paramBundle.getString("highway_exit_iccode");
    if (!StringUtils.isEmpty(str)) {
      localBundle.putString("hud_highway_exiticcode", str);
    }
    str = paramBundle.getString("highway_exit_directionname");
    if (!StringUtils.isEmpty(str))
    {
      LogUtil.e("hud", "containKey ExitDirectionName");
      localBundle.putString("hud_highway_directionname", str);
    }
    localBundle.putBoolean("hud_along", paramBundle.getBoolean("highway_hide_info"));
    localBundle.putInt("hud_updatetype", 2);
    latestUpdateType = 2;
    return localBundle;
  }
  
  public boolean isHasExitCode()
  {
    return this.hasExitCode;
  }
  
  public boolean isSimpleGuideAlong()
  {
    return this.isSimpleGuideAlong;
  }
  
  public boolean isYaw()
  {
    return this.mIsYaw;
  }
  
  public void setHasExitCode(boolean paramBoolean)
  {
    this.hasExitCode = paramBoolean;
  }
  
  public void setIsYaw(boolean paramBoolean)
  {
    this.mIsYaw = paramBoolean;
  }
  
  public void setSimpleGuideAlong(boolean paramBoolean)
  {
    this.isSimpleGuideAlong = paramBoolean;
  }
  
  public Bundle simpleGuideToHUD(Bundle paramBundle)
  {
    LogUtil.e("RGHUDDataModel", "simpleGuideToHUD");
    Bundle localBundle = new Bundle();
    int i = paramBundle.getInt("remain_dist");
    if (i >= 0)
    {
      LogUtil.e("hud", "containKey RemainDist");
      localBundle.putInt("hud_remaindist", i);
    }
    if (paramBundle.containsKey("resid"))
    {
      LogUtil.e("hud", "containKey ResId");
      localBundle.putInt("hud_resid", simpleGuideResToHUDRes(paramBundle.getInt("resid")));
    }
    if (paramBundle.containsKey("road_name"))
    {
      LogUtil.e("hud", "containKey RoadName");
      localBundle.putString("hud_nextroad", paramBundle.getString("road_name"));
    }
    localBundle.putString("hud_head_angle", getInstance().getData().getString("hud_head_angle"));
    if (paramBundle.containsKey("cur_road_name"))
    {
      LogUtil.e("hud", "containKey CurRoadName");
      localBundle.putString("hud_currentroad", paramBundle.getString("cur_road_name"));
    }
    if (paramBundle.containsKey("straight"))
    {
      LogUtil.e("hud", "containKey Straight");
      localBundle.putBoolean("hud_straight", paramBundle.getBoolean("straight"));
    }
    localBundle.putInt("hud_updatetype", 1);
    latestUpdateType = 1;
    return localBundle;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGHUDDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */