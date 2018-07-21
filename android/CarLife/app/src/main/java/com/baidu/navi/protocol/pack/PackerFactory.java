package com.baidu.navi.protocol.pack;

import android.text.TextUtils;

public class PackerFactory
{
  public static BasePacker getPacker(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!"route".equals(paramString)) {
        break label30;
      }
      localObject1 = new RoutePlanPacker();
    }
    label30:
    do
    {
      return (BasePacker)localObject1;
      if ("stopNavi".equals(paramString)) {
        return new StopNaviPacker();
      }
      if ("reRoute".equals(paramString)) {
        return new ReroutePacker();
      }
      if ("notifyGuideNodeInfo".equals(paramString)) {
        return new HUDPacker();
      }
      if ("notifyMapImageUpdate".equals(paramString)) {
        return new MapImagePacker();
      }
      if ("startNavi".equals(paramString)) {
        return new StartNaviPacker();
      }
      if ("getHomeAndCompany".equals(paramString)) {
        return new GetAddressPacker();
      }
      if ("getFavorite".equals(paramString)) {
        return new GetFavoritePacker();
      }
      if ("setImageSize".equals(paramString)) {
        return new SetImageSizePacker();
      }
      if ("getMapImage".equals(paramString)) {
        return new GetMapImagePacker();
      }
      if ("keywordSuggest".equals(paramString)) {
        return new KeywordSuggestPacker();
      }
      if ("searchByKeyword".equals(paramString)) {
        return new SearchByKeywordPacker();
      }
      if ("searchByType".equals(paramString)) {
        return new SearchByTypePacker();
      }
      if ("voiceRecognise".equals(paramString)) {
        return new VoiceRecognisePacker();
      }
      if ("getMapScale".equals(paramString)) {
        return new GetMapScalePacker();
      }
      if ("mapZoomIn".equals(paramString)) {
        return new MapZoomInPacker();
      }
      if ("mapZoomOut".equals(paramString)) {
        return new MapZoomOutpacker();
      }
      if ("routeGuideFinishNotify".equals(paramString)) {
        return new MapZoomOutpacker();
      }
      if ("getStatus".equals(paramString)) {
        return new GetStatusPacker();
      }
      if ("getPluginInfo".equals(paramString)) {
        return new GetPluginInfoPacker();
      }
      if ("routeGuideBackgroundNotify".equals(paramString)) {
        return new BackgroundNotifyPacker();
      }
      if ("routeGuideForegroundNotify".equals(paramString)) {
        return new ForegroundNotifyPacker();
      }
      if ("updateDeviceStatus".equals(paramString)) {
        return new UpdateDeviceStatusPacker();
      }
      if ("updateLocation".equals(paramString)) {
        return new UpdateLocationPacker();
      }
      if ("getFavoriteAsFile".equals(paramString)) {
        return new GetFavoriteAsFilePacker();
      }
      localObject1 = localObject2;
    } while (!"addFavoriteByFile".equals(paramString));
    return new AddFavoriteByFilePacker();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/pack/PackerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */