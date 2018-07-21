package com.baidu.navisdk.model.datastruct;

public class RoadConditionItem
{
  public static final int Color_Of_Pass_Road = -3158065;
  public static final int ROAD_CONDITION_MAX_TYPE = 4;
  public static final int ROAD_CONDITION_TYPE_Invalid = 0;
  public static final int ROAD_CONDITION_TYPE_Obstruction = 3;
  public static final int ROAD_CONDITION_TYPE_Slow = 2;
  public static final int ROAD_CONDITION_TYPE_Straightway = 1;
  public static final int ROAD_CONDITION_TYPE_Very_Obstruction = 4;
  private static final int[] Road_Condition_Color = { -10647319, -12202902, 44544, -43949, -4248030 };
  public int curItemEndIndex;
  public int roadConditionType;
  
  public static int getRoadConditionColor(int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 4) {}
    }
    else
    {
      i = 0;
    }
    return Road_Condition_Color[i];
  }
  
  public int getRoadConditionColor()
  {
    if ((this.roadConditionType < 0) || (this.roadConditionType > 4)) {
      this.roadConditionType = 0;
    }
    return Road_Condition_Color[this.roadConditionType];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/RoadConditionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */