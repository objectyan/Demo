package com.baidu.mapframework.nirvana.module;

public enum Module
{
  private final ModuleType a;
  
  static
  {
    BASE_FRAMEWORK_MODULE = new Module("BASE_FRAMEWORK_MODULE", 2, ModuleType.DATA_MODULE);
    QA_FRAMEWORK_MODULE = new Module("QA_FRAMEWORK_MODULE", 3, ModuleType.DATA_MODULE);
    EVENTBUS_MODULE = new Module("EVENTBUS_MODULE", 4, ModuleType.DATA_MODULE);
    COM_PLATFORM_MODULE = new Module("COM_PLATFORM_MODULE", 5, ModuleType.DATA_MODULE);
    SAND_BOX_MODULE = new Module("SAND_BOX_MODULE", 6, ModuleType.DATA_MODULE);
    MAP_ENGINE = new Module("MAP_ENGINE", 7, ModuleType.UI_MODULE);
    NAV_MODULE = new Module("NAV_MODULE", 8, ModuleType.UI_MODULE);
    NAV_TTS_MODULE = new Module("NAV_TTS_MODULE", 9, ModuleType.UI_MODULE);
    POI_DETAIL_MODULE = new Module("POI_DETAIL_MODULE", 10, ModuleType.UI_MODULE);
    POI_LIST_MODULE = new Module("POI_LIST_MODULE", 11, ModuleType.UI_MODULE);
    POI_SEARCH_MODULE = new Module("POI_SEARCH_MODULE", 12, ModuleType.UI_MODULE);
    SUBWAY_STATION_DETAIL_MODULE = new Module("SUBWAY_STATION_DETAIL_MODULE", 13, ModuleType.UI_MODULE);
    MAP_APPLICARION_MODULE = new Module("MAP_APPLICARION_MODULE", 14, ModuleType.UI_MODULE);
    MAP_ACTIVITY_MODULE = new Module("MAP_ACTIVITY_MODULE", 15, ModuleType.UI_MODULE);
    ENTRY_CONTROLLER_MODULE = new Module("ENTRY_CONTROLLER_MODULE", 16, ModuleType.UI_MODULE);
    MAP_FRAME_MODULE = new Module("MAP_FRAME_MODULE", 17, ModuleType.UI_MODULE);
    NEARBY_MODULE = new Module("NEARBY_MODULE", 18, ModuleType.UI_MODULE);
    USER_CENTER_MODULE = new Module("USER_CENTER_MODULE", 19, ModuleType.UI_MODULE);
    MESSAGE_MODULE = new Module("MESSAGE_MODULE", 20, ModuleType.UI_MODULE);
    ROUTE_CAR_MODULE = new Module("ROUTE_CAR_MODULE", 21, ModuleType.UI_MODULE);
    ROUTE_BUS_MODULE = new Module("ROUTE_BUS_MODULE", 22, ModuleType.UI_MODULE);
    ROUTE_REALTIME_MODULE = new Module("ROUTE_REALTIME_MODULE", 23, ModuleType.UI_MODULE);
    ROUTE_BIKE_WALK_MODULE = new Module("ROUTE_BIKE_WALK_MODULE", 24, ModuleType.UI_MODULE);
    FAVORITE_MODULE = new Module("FAVORITE_MODULE", 25, ModuleType.UI_MODULE);
    LOCAL_MAP_MODULE = new Module("LOCAL_MAP_MODULE", 26, ModuleType.UI_MODULE);
    GLIDE_MODULE = new Module("GLIDE_MODULE", 27, ModuleType.UI_MODULE);
    DEFAULT_MAP_LAYOUT_MODULE = new Module("DEFAULT_MAP_LAYOUT_MODULE", 28, ModuleType.UI_MODULE);
    BASE_MAPVIEW_MODULE = new Module("BASE_MAPVIEW_MODULE", 29, ModuleType.UI_MODULE);
    SIRI_MODULE = new Module("SIRI_MODULE", 30, ModuleType.UI_MODULE);
    VERSION_UPDATE_MODULE = new Module("VERSION_UPDATE_MODULE", 31, ModuleType.UI_MODULE);
    OPENPI_MODULE = new Module("OPENPI_MODULE", 32, ModuleType.UI_MODULE);
    SETTING_MODULE = new Module("SETTING_MODULE", 33, ModuleType.UI_MODULE);
    ROAD_CONDITION_VIDEO_MODULE = new Module("ROAD_CONDITION_VIDEO_MODULE", 34, ModuleType.UI_MODULE);
    COMMON_WIDGET_MODULE = new Module("COMMON_WIDGET_MODULE", 35, ModuleType.UI_MODULE);
    LOCATION_MODULE = new Module("LOCATION_MODULE", 36, ModuleType.DATA_MODULE);
    HOT_WORD_MODULE = new Module("HOT_WORD_MODULE", 37, ModuleType.DATA_MODULE);
    NEARBY_HOT_WORD_MODULE = new Module("NEARBY_HOT_WORD_MODULE", 38, ModuleType.DATA_MODULE);
    LOG_STATISTICS_MODULE = new Module("LOG_STATISTICS_MODULE", 39, ModuleType.DATA_MODULE);
    MATERIAL_CENTER_MODULE = new Module("MATERIAL_CENTER_MODULE", 40, ModuleType.DATA_MODULE);
    SKIN_MODULE = new Module("SKIN_MODULE", 41, ModuleType.DATA_MODULE);
    YELLOW_BANNER_MODULE = new Module("YELLOW_BANNER_MODULE", 42, ModuleType.DATA_MODULE);
    PUSH_MODULE = new Module("PUSH_MODULE", 43, ModuleType.DATA_MODULE);
    ROAM_INFO_MODULE = new Module("ROAM_INFO_MODULE", 44, ModuleType.DATA_MODULE);
    VOICE_MODULE = new Module("VOICE_MODULE", 45, ModuleType.DATA_MODULE);
    VOICE_COMPONENT_MODULE = new Module("VOICE_COMPONENT_MODULE", 46, ModuleType.COMPONENT);
    ADVERT_CTRL_MODULE = new Module("ADVERT_CTRL_MODULE", 47, ModuleType.COMPONENT);
    INDOOR_MODULE = new Module("INDOOR_MODULE", 48, ModuleType.UI_MODULE);
    LAYER_ACTION_MODULE = new Module("LAYER_ACTION_MODULE", 49, ModuleType.UI_MODULE);
    UGC_REPORT_MODULE = new Module("UGC_REPORT_MODULE", 50, ModuleType.DATA_MODULE);
    VIDEO_UPLOAD_MODULE = new Module("VIDEO_UPLOAD_MODULE", 51, ModuleType.DATA_MODULE);
    ACCOUNT_MODULE = new Module("ACCOUNT_MODULE", 52, ModuleType.DATA_MODULE);
    NA_CRASH_MODULE = new Module("NA_CRASH_MODULE", 53, ModuleType.DATA_MODULE);
    SENSOR_MODULE = new Module("SENSOR_MODULE", 54, ModuleType.DATA_MODULE);
    CLOUD_CONTROL_MODULE = new Module("CLOUD_CONTROL_MODULE", 55, ModuleType.DATA_MODULE);
    MYLOCATION_MODULE = new Module("MYLOCATION_MODULE", 56, ModuleType.DATA_MODULE);
    BUS_SCREENSHOT_MODULE = new Module("BUS_SCREENSHOT_MODULE", 57, ModuleType.DATA_MODULE);
    SECURE_MODULE = new Module("SECURE_MODULE", 58, ModuleType.DATA_MODULE);
    SYNC_MODULE = new Module("SYNC_MODULE", 59, ModuleType.DATA_MODULE);
    BMES_MODULE = new Module("BMES_MODULE", 60, ModuleType.DATA_MODULE);
    WEATHER_MODULE = new Module("WEATHER_MODULE", 61, ModuleType.DATA_MODULE);
    UPLOAD_PIC_MODULE = new Module("UPLOAD_PIC_MODULE", 62, ModuleType.DATA_MODULE);
    POI_PLACE_MODULE = new Module("POI_PLACE_MODULE", 63, ModuleType.UI_MODULE);
    RECOMMEND_MODULE = new Module("RECOMMEND_MODULE", 64, ModuleType.DATA_MODULE);
    SEARCH_FRAMEWORK_MODULE = new Module("SEARCH_FRAMEWORK_MODULE", 65, ModuleType.DATA_MODULE);
    PATCH_MODULE = new Module("PATCH_MODULE", 66, ModuleType.DATA_MODULE);
    LOC_SHARE_MODULE = new Module("LOC_SHARE_MODULE", 67, ModuleType.COMPONENT);
    TRACK_MODULE = new Module("TRACK_MODULE", 68, ModuleType.COMPONENT);
    TRAVEL_EXPLORER_MODULE = new Module("TRAVEL_EXPLORER_MODULE", 69, ModuleType.UI_MODULE);
    STREET_SCAPE_MODULE = new Module("STREET_SCAPE_MODULE", 70, ModuleType.UI_MODULE);
    ZOOM_ACTION_MODULE = new Module("ZOOM_ACTION_MODULE", 71, ModuleType.UI_MODULE);
    LIVE_ROOM_MODULE = new Module("LIVE_ROOM_MODULE", 72, ModuleType.COMPONENT);
    TRAVEL_ASSISTANT_MODULE = new Module("TRAVEL_ASSISTANT_MODULE", 73, ModuleType.COMPONENT);
    OPERATION_MODULE = new Module("OPERATION_MODULE", 74, ModuleType.COMPONENT);
    WIFI_MODULE = new Module("WIFI_MODULE", 75, ModuleType.COMPONENT);
    PANO_MODULE = new Module("PANO_MODULE", 76, ModuleType.COMPONENT);
    SCENERY_MODULE = new Module("SCENERY_MODULE", 77, ModuleType.COMPONENT);
    INDOOR_GUARD_MODULE = new Module("INDOOR_GUARD_MODULE", 78, ModuleType.COMPONENT);
    BRAND_MODULE = new Module("BRAND_MODULE", 79, ModuleType.COMPONENT);
    DRIVE_MODULE = new Module("DRIVE_MODULE", 80, ModuleType.COMPONENT);
    CAR_OWNER = new Module("CAR_OWNER", 81, ModuleType.COMPONENT);
    RENT_CAR = new Module("RENT_CAR", 82, ModuleType.COMPONENT);
    SHARE_BIKE = new Module("SHARE_BIKE", 83, ModuleType.COMPONENT);
    BRAAVOS_MODULE = new Module("BRAAVOS_MODULE", 84, ModuleType.COMPONENT);
    INTERNATIONAL_MODULE = new Module("INTERNATIONAL_MODULE", 85, ModuleType.COMPONENT);
    WALLET_MODULE = new Module("WALLET_MODULE", 86, ModuleType.THIRD_SDK);
    WEB_SDK_MODULE = new Module("WEB_SDK_MODULE", 87, ModuleType.THIRD_SDK);
    SAPI_MODULE = new Module("SAPI_MODULE", 88, ModuleType.THIRD_SDK);
    ROUTE_MODULE = new Module("ROUTE_MODULE", 89, ModuleType.UI_MODULE);
    ROUTE_DEFAULT_MAP_LAYOUT_MODULE = new Module("ROUTE_DEFAULT_MAP_LAYOUT_MODULE", 90, ModuleType.UI_MODULE);
    SHARE_MODULE = new Module("SHARE_MODULE", 91, ModuleType.UI_MODULE);
    ROAD_CONDITION_MODULE = new Module("ROAD_CONDITION_MODULE", 92, ModuleType.UI_MODULE);
    SELECT_POINT_MODULE = new Module("SELECT_POINT_MODULE", 93, ModuleType.UI_MODULE);
    OPERATION_MAP_MODULE = new Module("OPERATION_MAP_MODULE", 94, ModuleType.UI_MODULE);
    MY_MAP_MODULE = new Module("MY_MAP_MODULE", 95, ModuleType.UI_MODULE);
    NUOMI_HYBRID_MODULE = new Module("NUOMI_HYBRID_MODULE", 96, ModuleType.THIRD_SDK);
    VOICE_INIT_MODULE = new Module("VOICE_INIT_MODULE", 97, ModuleType.THIRD_SDK);
  }
  
  private Module(ModuleType paramModuleType)
  {
    this.a = paramModuleType;
  }
  
  public ModuleType getType()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/module/Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */