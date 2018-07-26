package com.baidu.platform.comapi.search;

@Deprecated
public interface SearchListener {
    void onGetAddrListResult(String str);

    void onGetAddrResult(String str);

    void onGetBusDetailResult(String str);

    void onGetBusRouteResult(String str);

    void onGetCarRouteResult(String str);

    void onGetCityInfoResult(String str);

    void onGetCityListResult(String str);

    void onGetClientFuncResult(String str);

    void onGetErrorNoResult(int i, int i2);

    void onGetFootRouteResult(String str);

    void onGetMCarRouteResult(String str);

    void onGetPoiBKGResult(String str);

    void onGetPoiDetailResult(String str);

    void onGetPoiRGCDetailResult(String str);

    void onGetPoiResult(String str);

    void onGetShareUrlResult(String str);

    void onGetSpecialQueryResult(String str);

    void onGetSuggestionResult(String str);
}
