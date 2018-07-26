package com.baidu.navisdk.model.datastruct;

public class RoadConditionItem {
    public static final int Color_Of_Pass_Road = -3158065;
    public static final int ROAD_CONDITION_MAX_TYPE = 4;
    public static final int ROAD_CONDITION_TYPE_Invalid = 0;
    public static final int ROAD_CONDITION_TYPE_Obstruction = 3;
    public static final int ROAD_CONDITION_TYPE_Slow = 2;
    public static final int ROAD_CONDITION_TYPE_Straightway = 1;
    public static final int ROAD_CONDITION_TYPE_Very_Obstruction = 4;
    private static final int[] Road_Condition_Color = new int[]{-10647319, -12202902, -20992, -43949, -4248030};
    public int curItemEndIndex;
    public int roadConditionType;

    public int getRoadConditionColor() {
        if (this.roadConditionType < 0 || this.roadConditionType > 4) {
            this.roadConditionType = 0;
        }
        return Road_Condition_Color[this.roadConditionType];
    }

    public static int getRoadConditionColor(int roadConditionType) {
        if (roadConditionType < 0 || roadConditionType > 4) {
            roadConditionType = 0;
        }
        return Road_Condition_Color[roadConditionType];
    }
}
