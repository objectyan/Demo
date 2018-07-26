package com.baidu.navisdk.ui.cruise.view;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseResHelper {
    public static final String[] BLINDBEND_NAMES = JarUtils.getResources().getStringArray(C4048R.array.nsdk_cruise_camera_blindbend_names);
    public static final String[] CAMERA_NAMES = JarUtils.getResources().getStringArray(C4048R.array.nsdk_cruise_camera_names);
    public static final String[] JOINT_NAMES = JarUtils.getResources().getStringArray(C4048R.array.nsdk_cruise_camera_joint_names);
    public static final String[] NARROW_NAMES = JarUtils.getResources().getStringArray(C4048R.array.nsdk_cruise_camera_narrow_names);
    public static final String[] ROCKFALL_NAMES = JarUtils.getResources().getStringArray(C4048R.array.nsdk_cruise_camera_rockfall_names);
    public static final String[] SLOP_NAMES = JarUtils.getResources().getStringArray(C4048R.array.nsdk_cruise_camera_slop_names);

    public static int getCameraIconResIdByTypes(int assistType, int subType) {
        if (subType >= 0) {
            if (assistType == 0 && BCruiserR.JointTypeIResID.length > subType) {
                return BCruiserR.JointTypeIResID[subType];
            }
            if (assistType == 4 && BCruiserR.BlindBendTypeIResID.length > subType) {
                return BCruiserR.BlindBendTypeIResID[subType];
            }
            if (assistType == 5 && BCruiserR.SlopTypeIResID.length > subType) {
                return BCruiserR.SlopTypeIResID[subType];
            }
            if (assistType == 6 && BCruiserR.RockFallTypeIResID.length > subType) {
                return BCruiserR.RockFallTypeIResID[subType];
            }
            if (assistType == 14 && BCruiserR.NarrowTypeIResID.length > subType) {
                return BCruiserR.NarrowTypeIResID[subType];
            }
            if (assistType == 3 && BCruiserR.RailwayTypeIResID.length > subType) {
                return BCruiserR.RailwayTypeIResID[subType];
            }
            if (assistType >= 0 && BCruiserR.CAMERA_ICON_ID.length > assistType) {
                return BCruiserR.CAMERA_ICON_ID[assistType];
            }
        }
        return 0;
    }

    public static String getCameraNameByTypes(int assistType, int subType) {
        if (assistType == 0) {
            if (subType != 0) {
                return JOINT_NAMES[subType];
            }
        } else if (assistType == 4) {
            if (subType != 0) {
                return BLINDBEND_NAMES[subType];
            }
        } else if (assistType == 5) {
            if (subType != 0) {
                return SLOP_NAMES[subType];
            }
        } else if (assistType == 6) {
            if (subType != 0) {
                return ROCKFALL_NAMES[subType];
            }
        } else if (assistType == 14 && subType != 0) {
            return NARROW_NAMES[subType];
        }
        return CAMERA_NAMES[assistType];
    }
}
