package com.baidu.navisdk.ui.cruise;

public class BCruiserConfig {
    public static final int CONFIG_VIEW_MODE_INFLATE_MAP = 0;
    public static final int CONFIG_VIEW_MODE_NOT_INFLATE_MAP = 1;
    public static final int INVALID_INT_VALUE = -1;
    public static final String KEY_CRUISER_VIEW_MODE = "cruiser_view_mode";
    public static int pRGViewMode = 1;

    public static void clear() {
        pRGViewMode = -1;
    }
}
