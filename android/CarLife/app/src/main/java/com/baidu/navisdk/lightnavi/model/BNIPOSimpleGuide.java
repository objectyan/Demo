package com.baidu.navisdk.lightnavi.model;

import com.baidu.navisdk.C4048R;
import java.util.HashMap;

public class BNIPOSimpleGuide {
    public static final int[] gTurnIconID = new int[]{C4048R.drawable.nsdk_ipo_turn_along, C4048R.drawable.nsdk_ipo_turn_back, C4048R.drawable.nsdk_ipo_turn_branch_center, C4048R.drawable.nsdk_ipo_turn_branch_left, C4048R.drawable.nsdk_ipo_turn_branch_left_straight, C4048R.drawable.nsdk_ipo_turn_branch_right, C4048R.drawable.nsdk_ipo_turn_branch_right_straight, C4048R.drawable.nsdk_ipo_turn_dest, C4048R.drawable.nsdk_ipo_turn_front, C4048R.drawable.nsdk_ipo_turn_inferry, C4048R.drawable.nsdk_ipo_turn_left, C4048R.drawable.nsdk_ipo_turn_left_back, C4048R.drawable.nsdk_ipo_turn_left_front, C4048R.drawable.nsdk_ipo_turn_left_side, C4048R.drawable.nsdk_ipo_turn_left_side_ic, C4048R.drawable.nsdk_ipo_turn_left_side_main, C4048R.drawable.nsdk_ipo_turn_lf_2branch_left, C4048R.drawable.nsdk_ipo_turn_lf_2branch_right, C4048R.drawable.nsdk_ipo_turn_rf_2branch_left, C4048R.drawable.nsdk_ipo_turn_rf_2branch_right, C4048R.drawable.nsdk_ipo_turn_right, C4048R.drawable.nsdk_ipo_turn_right_back, C4048R.drawable.nsdk_ipo_turn_right_front, C4048R.drawable.nsdk_ipo_turn_right_side, C4048R.drawable.nsdk_ipo_turn_right_side_ic, C4048R.drawable.nsdk_ipo_turn_right_side_main, C4048R.drawable.nsdk_ipo_turn_ring, C4048R.drawable.nsdk_ipo_turn_ring_back, C4048R.drawable.nsdk_ipo_turn_ring_front, C4048R.drawable.nsdk_ipo_turn_ring_left, C4048R.drawable.nsdk_ipo_turn_ring_leftback, C4048R.drawable.nsdk_ipo_turn_ring_leftfront, C4048R.drawable.nsdk_ipo_turn_ring_right, C4048R.drawable.nsdk_ipo_turn_ring_rightback, C4048R.drawable.nsdk_ipo_turn_ring_rightfront, C4048R.drawable.nsdk_ipo_turn_tollgate};
    public static final String[] gTurnIconName = new String[]{"turn_along.png", "turn_back.png", "turn_branch_center.png", "turn_branch_left.png", "turn_branch_left_straight.png", "turn_branch_right.png", "turn_branch_right_straight.png", "turn_dest.png", "turn_front.png", "turn_inferry.png", "turn_left.png", "turn_left_back.png", "turn_left_front.png", "turn_left_side.png", "turn_left_side_ic.png", "turn_left_side_main.png", "turn_lf_2branch_left.png", "turn_lf_2branch_right.png", "turn_rf_2branch_left.png", "turn_rf_2branch_right.png", "turn_right.png", "turn_right_back.png", "turn_right_front.png", "turn_right_side.png", "turn_right_side_ic.png", "turn_right_side_main.png", "turn_ring.png", "turn_ring_back.png", "turn_ring_front.png", "turn_ring_left.png", "turn_ring_leftback.png", "turn_ring_leftfront.png", "turn_ring_right.png", "turn_ring_rightback.png", "turn_ring_rightfront.png", "turn_tollgate.png"};
    public HashMap<String, Integer> mTurnIconMap = new HashMap();

    public BNIPOSimpleGuide() {
        for (int i = 0; i < gTurnIconID.length; i++) {
            this.mTurnIconMap.put(gTurnIconName[i], Integer.valueOf(gTurnIconID[i]));
        }
    }

    public int getResIdByIconName(String iconName) {
        if (iconName == null || this.mTurnIconMap == null || !this.mTurnIconMap.containsKey(iconName)) {
            return -1;
        }
        return ((Integer) this.mTurnIconMap.get(iconName)).intValue();
    }
}
