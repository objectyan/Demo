package com.baidu.navisdk.ui.cruise.view;

import android.content.res.Resources;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseResHelper
{
  public static final String[] BLINDBEND_NAMES;
  public static final String[] CAMERA_NAMES = JarUtils.getResources().getStringArray(1711931394);
  public static final String[] JOINT_NAMES = JarUtils.getResources().getStringArray(1711931395);
  public static final String[] NARROW_NAMES;
  public static final String[] ROCKFALL_NAMES = JarUtils.getResources().getStringArray(1711931399);
  public static final String[] SLOP_NAMES;
  
  static
  {
    BLINDBEND_NAMES = JarUtils.getResources().getStringArray(1711931396);
    NARROW_NAMES = JarUtils.getResources().getStringArray(1711931397);
    SLOP_NAMES = JarUtils.getResources().getStringArray(1711931398);
  }
  
  public static int getCameraIconResIdByTypes(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      if ((paramInt1 == 0) && (BCruiserR.JointTypeIResID.length > paramInt2)) {
        return BCruiserR.JointTypeIResID[paramInt2];
      }
      if ((paramInt1 == 4) && (BCruiserR.BlindBendTypeIResID.length > paramInt2)) {
        return BCruiserR.BlindBendTypeIResID[paramInt2];
      }
      if ((paramInt1 == 5) && (BCruiserR.SlopTypeIResID.length > paramInt2)) {
        return BCruiserR.SlopTypeIResID[paramInt2];
      }
      if ((paramInt1 == 6) && (BCruiserR.RockFallTypeIResID.length > paramInt2)) {
        return BCruiserR.RockFallTypeIResID[paramInt2];
      }
      if ((paramInt1 == 14) && (BCruiserR.NarrowTypeIResID.length > paramInt2)) {
        return BCruiserR.NarrowTypeIResID[paramInt2];
      }
      if ((paramInt1 == 3) && (BCruiserR.RailwayTypeIResID.length > paramInt2)) {
        return BCruiserR.RailwayTypeIResID[paramInt2];
      }
      if ((paramInt1 >= 0) && (BCruiserR.CAMERA_ICON_ID.length > paramInt1)) {
        return BCruiserR.CAMERA_ICON_ID[paramInt1];
      }
    }
    return 0;
  }
  
  public static String getCameraNameByTypes(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 != 0) {
        return JOINT_NAMES[paramInt2];
      }
    }
    else if (paramInt1 == 4)
    {
      if (paramInt2 != 0) {
        return BLINDBEND_NAMES[paramInt2];
      }
    }
    else if (paramInt1 == 5)
    {
      if (paramInt2 != 0) {
        return SLOP_NAMES[paramInt2];
      }
    }
    else if (paramInt1 == 6)
    {
      if (paramInt2 != 0) {
        return ROCKFALL_NAMES[paramInt2];
      }
    }
    else if ((paramInt1 == 14) && (paramInt2 != 0)) {
      return NARROW_NAMES[paramInt2];
    }
    return CAMERA_NAMES[paramInt1];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/view/CruiseResHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */