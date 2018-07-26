package com.baidu.navisdk.lightnavi.listener;

public interface LightNaviListener {
    public static final int PAGE_JUMP_LIGHT_NAVI = 2;
    public static final int PAGE_JUMP_NORMAL_NAVI = 3;
    public static final int PAGE_JUMP_SLIGHT_END = 4;
    public static final int PAGE_JUMP_TO_BACK = 1;
    public static final String SWITCH_FLAG = "switch";

    void onPageJump(int i, Object obj);
}
