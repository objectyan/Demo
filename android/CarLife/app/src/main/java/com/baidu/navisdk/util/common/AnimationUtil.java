package com.baidu.navisdk.util.common;

import android.view.animation.Animation;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;

public class AnimationUtil {

    public enum AnimationType {
        ANIM_LEFT_IN,
        ANIM_RIGHT_IN,
        ANIM_LEFT_OUT,
        ANIM_RIGHT_OUT,
        ANIM_DOWN_IN,
        ANIM_DOWN_OUT
    }

    public static Animation getAnimation(AnimationType type, long startOffset, long duration) {
        Animation anim = getAnimation(type);
        if (anim != null && startOffset >= 0) {
            anim.setStartOffset(startOffset);
        }
        if (anim != null && duration >= 0) {
            anim.setDuration(duration);
        }
        return anim;
    }

    public static Animation getAnimation(AnimationType type) {
        switch (type) {
            case ANIM_LEFT_IN:
                return JarUtils.loadAnimation(BNaviModuleManager.getContext(), C4048R.anim.nsdk_anim_left_in);
            case ANIM_RIGHT_IN:
                return JarUtils.loadAnimation(BNaviModuleManager.getContext(), C4048R.anim.nsdk_anim_right_in);
            case ANIM_LEFT_OUT:
                return JarUtils.loadAnimation(BNaviModuleManager.getContext(), C4048R.anim.nsdk_anim_left_out);
            case ANIM_RIGHT_OUT:
                return JarUtils.loadAnimation(BNaviModuleManager.getContext(), C4048R.anim.nsdk_anim_right_out);
            case ANIM_DOWN_IN:
                return JarUtils.loadAnimation(BNaviModuleManager.getContext(), C4048R.anim.nsdk_anim_down_in);
            case ANIM_DOWN_OUT:
                return JarUtils.loadAnimation(BNaviModuleManager.getContext(), C4048R.anim.nsdk_anim_down_out);
            default:
                return null;
        }
    }
}
