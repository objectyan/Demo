package com.baidu.navi.protocol.model;

import android.text.TextUtils;

public class DataStructFactory
{
  public static DataStruct createDataStruct(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!"route".equals(paramString)) {
        break label30;
      }
      localObject1 = new RoutePlanDataStruct();
    }
    label30:
    do
    {
      return (DataStruct)localObject1;
      if ("stopNavi".equals(paramString)) {
        return new StopNaviDataStruct();
      }
      if ("reRoute".equals(paramString)) {
        return new RerouteDataStruct();
      }
      if ("notifyGuideNodeInfo".equals(paramString)) {
        return new HUDGuideDataStruct();
      }
      if ("notifyMapImageUpdate".equals(paramString)) {
        return new MapImageUpdateDataStruct();
      }
      if ("startNavi".equals(paramString)) {
        return new StartNaviDataStruct();
      }
      if ("getHomeAndCompany".equals(paramString)) {
        return new GetAddressDataStruct();
      }
      if ("getFavorite".equals(paramString)) {
        return new GetFavoriteDataStruct();
      }
      if ("setImageSize".equals(paramString)) {
        return new SetImageSizeDataStruct();
      }
      if ("getMapImage".equals(paramString)) {
        return new GetMapImageDataStruct();
      }
      if ("keywordSuggest".equals(paramString)) {
        return new KeywordSuggestDataStruct();
      }
      if ("searchByKeyword".equals(paramString)) {
        return new SearchByKeywordDataStruct();
      }
      if ("searchByType".equals(paramString)) {
        return new SearchByTypeDataStruct();
      }
      if ("voiceRecognise".equals(paramString)) {
        return new VoiceRecogniseDataStruct();
      }
      if ("getMapScale".equals(paramString)) {
        return new GetMapScaleDataStruct();
      }
      if ("mapZoomIn".equals(paramString)) {
        return new MapZoomInDataStruct();
      }
      if ("mapZoomOut".equals(paramString)) {
        return new MapZoomOutDataStruct();
      }
      if ("routeGuideFinishNotify".equals(paramString)) {
        return new RouteGuideFinishDataStruct();
      }
      if ("getStatus".equals(paramString)) {
        return new GetStatusDataStruct();
      }
      if ("getPluginInfo".equals(paramString)) {
        return new GetPluginInfoDataStruct();
      }
      if ("routeGuideBackgroundNotify".equals(paramString)) {
        return new BackgroundNotifyDataStruct();
      }
      if ("routeGuideForegroundNotify".equals(paramString)) {
        return new ForegroundNotifyDataStruct();
      }
      if ("updateDeviceStatus".equals(paramString)) {
        return new UpdateDeviceStatusDataStruct();
      }
      if ("updateLocation".equals(paramString)) {
        return new UpdateLocationDataStruct();
      }
      if ("addFavoriteByFile".equals(paramString)) {
        return new AddFavoriteByFileDataStruct();
      }
      localObject1 = localObject2;
    } while (!"getFavoriteAsFile".equals(paramString));
    return new GetFavoriteAsFileDataStruct();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/DataStructFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */