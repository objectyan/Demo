package com.baidu.navisdk.lightnavi.model;

import java.util.HashMap;

public class BNIPOSimpleGuide
{
  public static final int[] gTurnIconID = { 1711407935, 1711407936, 1711407937, 1711407938, 1711407939, 1711407940, 1711407941, 1711407942, 1711407943, 1711407944, 1711407945, 1711407946, 1711407947, 1711407948, 1711407949, 1711407950, 1711407951, 1711407952, 1711407953, 1711407954, 1711407955, 1711407956, 1711407957, 1711407958, 1711407959, 1711407960, 1711407961, 1711407962, 1711407963, 1711407964, 1711407965, 1711407966, 1711407967, 1711407968, 1711407969, 1711407970 };
  public static final String[] gTurnIconName = { "turn_along.png", "turn_back.png", "turn_branch_center.png", "turn_branch_left.png", "turn_branch_left_straight.png", "turn_branch_right.png", "turn_branch_right_straight.png", "turn_dest.png", "turn_front.png", "turn_inferry.png", "turn_left.png", "turn_left_back.png", "turn_left_front.png", "turn_left_side.png", "turn_left_side_ic.png", "turn_left_side_main.png", "turn_lf_2branch_left.png", "turn_lf_2branch_right.png", "turn_rf_2branch_left.png", "turn_rf_2branch_right.png", "turn_right.png", "turn_right_back.png", "turn_right_front.png", "turn_right_side.png", "turn_right_side_ic.png", "turn_right_side_main.png", "turn_ring.png", "turn_ring_back.png", "turn_ring_front.png", "turn_ring_left.png", "turn_ring_leftback.png", "turn_ring_leftfront.png", "turn_ring_right.png", "turn_ring_rightback.png", "turn_ring_rightfront.png", "turn_tollgate.png" };
  public HashMap<String, Integer> mTurnIconMap = new HashMap();
  
  public BNIPOSimpleGuide()
  {
    int i = 0;
    while (i < gTurnIconID.length)
    {
      this.mTurnIconMap.put(gTurnIconName[i], Integer.valueOf(gTurnIconID[i]));
      i += 1;
    }
  }
  
  public int getResIdByIconName(String paramString)
  {
    if ((paramString == null) || (this.mTurnIconMap == null) || (!this.mTurnIconMap.containsKey(paramString))) {
      return -1;
    }
    return ((Integer)this.mTurnIconMap.get(paramString)).intValue();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/model/BNIPOSimpleGuide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */