package com.baidu.navi.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.carlife.C0965R;

public class AnimationFactory {
    public static final int ANIM_DOWN_IN = 21;
    public static final int ANIM_DOWN_OUT = 22;
    public static final int ANIM_ECLIPSE_UP = 28;
    public static final int ANIM_EMPTY = 0;
    public static final int ANIM_ENTER_HOME_FROM_LAUNCH = 257;
    public static final int ANIM_EXPAND_DOWN = 27;
    public static final int ANIM_FADE_IN = 1;
    public static final int ANIM_FADE_OUT = 2;
    public static final int ANIM_LEFT_IN = 23;
    public static final int ANIM_LEFT_OUT = 24;
    public static final int ANIM_POP_IN = 17;
    public static final int ANIM_POP_OUT = 18;
    public static final int ANIM_RIGHT_IN = 25;
    public static final int ANIM_RIGHT_OUT = 26;
    public static final int ANIM_SLIDE_IN_LEFT = 3;
    public static final int ANIM_SLIDE_IN_RIGHT = 5;
    public static final int ANIM_SLIDE_OUT_LEFT = 4;
    public static final int ANIM_SLIDE_OUT_RIGHT = 6;
    public static final int ANIM_UP_IN = 19;
    public static final int ANIM_UP_OUT = 20;

    /* renamed from: com.baidu.navi.animation.AnimationFactory$1 */
    static class C36711 extends Animation {
        C36711() {
        }
    }

    public static Animation getAnimation(Context context, int type) {
        if (context == null) {
            return null;
        }
        Animation anim;
        switch (type) {
            case 1:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.fade_in);
                break;
            case 2:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.fade_out);
                break;
            case 3:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.slide_in_left);
                break;
            case 4:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.slide_out_left);
                break;
            case 5:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.slide_in_right);
                break;
            case 6:
                break;
            case 17:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.pop_in);
                break;
            case 18:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.pop_out);
                break;
            case 19:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.up_in);
                break;
            case 20:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.up_out);
                break;
            case 21:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.down_in);
                break;
            case 22:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.down_out);
                break;
            case 23:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.left_in);
                break;
            case 24:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.left_out);
                break;
            case 25:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.right_in);
                break;
            case 26:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.right_out);
                break;
            case 27:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.expand_down);
                break;
            case 28:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.eclipse_up);
                break;
            case 257:
                anim = AnimationUtils.loadAnimation(context, C0965R.anim.enter_home_from_launch);
                break;
            default:
                anim = new C36711();
                break;
        }
        anim = AnimationUtils.loadAnimation(context, C0965R.anim.slide_out_right);
        anim.setFillAfter(true);
        return anim;
    }

    public static Animation getAnimation(Context context, int type, long startOffset, long duration) {
        Animation anim = getAnimation(context, type);
        if (anim != null && startOffset >= 0) {
            anim.setStartOffset(startOffset);
        }
        if (anim != null && duration >= 0) {
            anim.setDuration(duration);
        }
        return anim;
    }
}
