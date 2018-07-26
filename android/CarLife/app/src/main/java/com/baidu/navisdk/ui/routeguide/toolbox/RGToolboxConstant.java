package com.baidu.navisdk.ui.routeguide.toolbox;

import com.baidu.navisdk.C4048R;

public class RGToolboxConstant {
    public static final int[] CLICK_ViewIndex = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    public static final int[] DIVIDER_H = new int[]{C4048R.id.bnav_rg_toolbox_divider_h1, C4048R.id.bnav_rg_toolbox_divider_h2};
    public static final int[] DIVIDER_V = new int[]{C4048R.id.bnav_rg_toolbox_quit_divider, C4048R.id.bnav_rg_toolbox_open_close_divider, C4048R.id.bnav_rg_toolbox_resume_switch_line_divider};
    public static final int RP_PROGRESS_BAR_ID = 1711866945;
    public static final int[] VIEW_BG_ID = new int[]{C4048R.id.sub_scroll_layout, C4048R.id.bnav_rg_toolbox_toolbar, C4048R.id.bnav_rg_toolbox_clear_poi_tv, C4048R.id.bnav_rg_toolbox_resume_switch_layout};
    public static final int[] VIEW_CLICK_IDS = new int[]{C4048R.id.bnav_rg_toolbox_route_sort, C4048R.id.bnav_rg_toolbox_along_way_search, C4048R.id.bnav_rg_toolbox_ugc_report, C4048R.id.bnav_rg_toolbox_route_share, C4048R.id.bnav_rg_toolbox_car3d_mode, C4048R.id.bnav_rg_toolbox_silent_mode, C4048R.id.bnav_rg_toolbox_mapmini_mode, C4048R.id.bnav_rg_toolbox_cat_plate_setting, C4048R.id.bnav_rg_toolbox_quit_ly, C4048R.id.bnav_rg_toolbox_open_close_ly, C4048R.id.bnav_rg_menu_more_setting_tv, C4048R.id.bnav_rg_toolbox_continue_nav, C4048R.id.bnav_rg_toolbox_resume_tv, C4048R.id.bnav_rg_toolbox_switch_route_tv, C4048R.id.bnav_rg_toolbox_rp_watting_cancle, C4048R.id.bnav_rg_toolbox_clear_poi_tv, C4048R.id.bnav_rg_toolbox_time_and_dist_ly};
    public static final int[] VIEW_SETTINGS_ITEM = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    public static final int[] VIEW_TEXT_A = new int[]{C4048R.id.bnav_rg_toolbox_arrive_time};
    public static final int[] VIEW_TEXT_B = new int[]{C4048R.id.bnav_rg_toolbox_quit_tv, C4048R.id.bnav_rg_toolbox_open_close_tv, C4048R.id.bnav_rg_menu_more_setting_tv};
    public static final int[] VIEW_TEXT_B_SINGLE = new int[]{C4048R.id.bnav_rg_toolbox_rp_watting_tv, C4048R.id.bnav_rg_toolbox_resume_tv};
    public static final int[] VIEW_TEXT_B_TITLE = new int[]{C4048R.id.bnav_rg_toolbox_remain_time_and_dist, C4048R.id.bnav_rg_toolbox_loading_no_progress};

    public interface ViewIndex {
        public static final int CARD3D_MODE = 4;
        public static final int CAR_PLATE_MODE = 7;
        public static final int CLEAR_POI_TV = 15;
        public static final int CONTINUE_NAV = 11;
        public static final int MEMU_MORE = 10;
        public static final int MINIMAP_MODE = 6;
        public static final int OPEN_CLOSE_VIEW = 9;
        public static final int QUIT_VIEW = 8;
        public static final int RESUME_TV = 12;
        public static final int ROUTE_SEARCH = 1;
        public static final int ROUTE_SHARE = 3;
        public static final int ROUTE_SORT = 0;
        public static final int RP_WATTING_CANCEL = 14;
        public static final int SILENT_MODE = 5;
        public static final int SWITCH_ROUTE_TV = 13;
        public static final int TIME_AND_DIST_LY = 16;
        public static final int UGC_REPORT = 2;
    }
}
