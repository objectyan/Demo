package com.baidu.navi.protocol.pack;

import android.text.TextUtils;
import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class PackerFactory {
    public static BasePacker getPacker(String cmd) {
        if (TextUtils.isEmpty(cmd)) {
            return null;
        }
        if ("route".equals(cmd)) {
            return new RoutePlanPacker();
        }
        if (BNaviProtocolDef.COMMAND_STOP_NAVI.equals(cmd)) {
            return new StopNaviPacker();
        }
        if (BNaviProtocolDef.COMMAND_REROUTE.equals(cmd)) {
            return new ReroutePacker();
        }
        if (BNaviProtocolDef.COMMAND_NOTIFY_GUIDE_INFO.equals(cmd)) {
            return new HUDPacker();
        }
        if (BNaviProtocolDef.COMMAND_NOTIFY_MAP_UPDATE.equals(cmd)) {
            return new MapImagePacker();
        }
        if (BNaviProtocolDef.COMMAND_START_NAVI.equals(cmd)) {
            return new StartNaviPacker();
        }
        if (BNaviProtocolDef.COMMAND_GET_HOME_AND_COMPANY.equals(cmd)) {
            return new GetAddressPacker();
        }
        if (BNaviProtocolDef.COMMAND_GET_FAVORITE.equals(cmd)) {
            return new GetFavoritePacker();
        }
        if (BNaviProtocolDef.COMMAND_SET_IMAGE_SIZE.equals(cmd)) {
            return new SetImageSizePacker();
        }
        if (BNaviProtocolDef.COMMAND_GET_MAP_IMAGE.equals(cmd)) {
            return new GetMapImagePacker();
        }
        if (BNaviProtocolDef.COMMAND_KEYWORD_SUGGEST.equals(cmd)) {
            return new KeywordSuggestPacker();
        }
        if (BNaviProtocolDef.COMMAND_SEARCH_BY_KEYWORD.equals(cmd)) {
            return new SearchByKeywordPacker();
        }
        if (BNaviProtocolDef.COMMAND_SEARCH_BY_TYPE.equals(cmd)) {
            return new SearchByTypePacker();
        }
        if (BNaviProtocolDef.COMMAND_VOICE_RECOGNISE.equals(cmd)) {
            return new VoiceRecognisePacker();
        }
        if (BNaviProtocolDef.COMMAND_GET_MAP_SCALE.equals(cmd)) {
            return new GetMapScalePacker();
        }
        if (BNaviProtocolDef.COMMAND_MAP_ZOOM_IN.equals(cmd)) {
            return new MapZoomInPacker();
        }
        if (BNaviProtocolDef.COMMAND_MAP_ZOOM_OUT.equals(cmd)) {
            return new MapZoomOutpacker();
        }
        if (BNaviProtocolDef.COMMAND_ROUTE_GUIDE_FINIS_NOTIFY.equals(cmd)) {
            return new MapZoomOutpacker();
        }
        if (BNaviProtocolDef.COMMAND_GET_STATUS.equals(cmd)) {
            return new GetStatusPacker();
        }
        if (BNaviProtocolDef.COMMAND_GET_PLUGIN_INFO.equals(cmd)) {
            return new GetPluginInfoPacker();
        }
        if (BNaviProtocolDef.COMMAND_ROUTE_GUIDE_BACKGROUND_NOTIFY.equals(cmd)) {
            return new BackgroundNotifyPacker();
        }
        if (BNaviProtocolDef.COMMAND_ROUTE_GUIDE_FOREGROUND_NOTIFY.equals(cmd)) {
            return new ForegroundNotifyPacker();
        }
        if (BNaviProtocolDef.COMMAND_UPDATE_DEVICE_STATUS.equals(cmd)) {
            return new UpdateDeviceStatusPacker();
        }
        if (BNaviProtocolDef.COMMAND_UPDATE_LOCATION.equals(cmd)) {
            return new UpdateLocationPacker();
        }
        if (BNaviProtocolDef.COMMAND_GET_FAVORITE_AS_FILE.equals(cmd)) {
            return new GetFavoriteAsFilePacker();
        }
        if (BNaviProtocolDef.COMMAND_ADD_FAVORITE_BY_FILE.equals(cmd)) {
            return new AddFavoriteByFilePacker();
        }
        return null;
    }
}
