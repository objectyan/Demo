package com.baidu.navi.protocol.model;

import android.text.TextUtils;
import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class DataStructFactory {
    public static DataStruct createDataStruct(String cmd) {
        if (TextUtils.isEmpty(cmd)) {
            return null;
        }
        if ("route".equals(cmd)) {
            return new RoutePlanDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_STOP_NAVI.equals(cmd)) {
            return new StopNaviDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_REROUTE.equals(cmd)) {
            return new RerouteDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_NOTIFY_GUIDE_INFO.equals(cmd)) {
            return new HUDGuideDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_NOTIFY_MAP_UPDATE.equals(cmd)) {
            return new MapImageUpdateDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_START_NAVI.equals(cmd)) {
            return new StartNaviDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_GET_HOME_AND_COMPANY.equals(cmd)) {
            return new GetAddressDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_GET_FAVORITE.equals(cmd)) {
            return new GetFavoriteDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_SET_IMAGE_SIZE.equals(cmd)) {
            return new SetImageSizeDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_GET_MAP_IMAGE.equals(cmd)) {
            return new GetMapImageDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_KEYWORD_SUGGEST.equals(cmd)) {
            return new KeywordSuggestDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_SEARCH_BY_KEYWORD.equals(cmd)) {
            return new SearchByKeywordDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_SEARCH_BY_TYPE.equals(cmd)) {
            return new SearchByTypeDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_VOICE_RECOGNISE.equals(cmd)) {
            return new VoiceRecogniseDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_GET_MAP_SCALE.equals(cmd)) {
            return new GetMapScaleDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_MAP_ZOOM_IN.equals(cmd)) {
            return new MapZoomInDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_MAP_ZOOM_OUT.equals(cmd)) {
            return new MapZoomOutDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_ROUTE_GUIDE_FINIS_NOTIFY.equals(cmd)) {
            return new RouteGuideFinishDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_GET_STATUS.equals(cmd)) {
            return new GetStatusDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_GET_PLUGIN_INFO.equals(cmd)) {
            return new GetPluginInfoDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_ROUTE_GUIDE_BACKGROUND_NOTIFY.equals(cmd)) {
            return new BackgroundNotifyDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_ROUTE_GUIDE_FOREGROUND_NOTIFY.equals(cmd)) {
            return new ForegroundNotifyDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_UPDATE_DEVICE_STATUS.equals(cmd)) {
            return new UpdateDeviceStatusDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_UPDATE_LOCATION.equals(cmd)) {
            return new UpdateLocationDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_ADD_FAVORITE_BY_FILE.equals(cmd)) {
            return new AddFavoriteByFileDataStruct();
        }
        if (BNaviProtocolDef.COMMAND_GET_FAVORITE_AS_FILE.equals(cmd)) {
            return new GetFavoriteAsFileDataStruct();
        }
        return null;
    }
}
