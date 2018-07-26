package com.baidu.navisdk.comapi.mapcontrol;

import com.baidu.navisdk.comapi.base.BNObserver;

public interface BNMapObserver extends BNObserver {
    public static final int TYPE_GESTURE = 2;
    public static final int TYPE_MAP_VIEW = 1;

    public static class EventMapView {
        public static final int EVENT_CLICKED_BACKGROUD = 272;
        public static final int EVENT_CLICKED_BASE_LAYER = 261;
        public static final int EVENT_CLICKED_BASE_POI_LAYER = 264;
        public static final int EVENT_CLICKED_COMPASS_LAYER = 262;
        public static final int EVENT_CLICKED_CUSTOM_LAYER = 512;
        public static final int EVENT_CLICKED_END_LAYER = 513;
        public static final int EVENT_CLICKED_FAV_POI_LAYER = 276;
        public static final int EVENT_CLICKED_POI_BKG_LAYER = 265;
        public static final int EVENT_CLICKED_POI_LAYER = 277;
        public static final int EVENT_CLICKED_POPUP_LAYER = 263;
        public static final int EVENT_CLICKED_ROUTE = 514;
        public static final int EVENT_CLICKED_ROUTE_SPEC_LAYER = 278;
        public static final int EVENT_CLICKED_ROUTE_UGC_ITEM = 515;
        public static final int EVENT_CLICKED_START_LAYER = 516;
        public static final int EVENT_CLICKED_STREET_ARROW = 273;
        public static final int EVENT_CLICKED_THROUGH_NODE_LAYER = 517;
        public static final int EVENT_CLICKED_UGC_ITEM = 515;
        public static final int EVENT_MAP_ANIMATION_FINISHED = 257;
        public static final int EVENT_MAP_GLRENDER = 275;
        public static final int EVENT_MAP_NETWORKING_CHANGED = 258;
        public static final int EVENT_MAP_RESIZE = 256;
        public static final int EVENT_MAP_SAVE_SCREEN = 259;
        public static final int EVENT_MAP_SAVE_SCREEN_BUFFER = 260;
        public static final int EVENT_MAP_ZOOM_UPDATE = 274;
    }
}
