package com.baidu.navisdk.ui.search;

import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import java.util.ArrayList;

public interface IBNSearchResultListener {
    void asynSearchCityList(SearchPoiPager searchPoiPager, SearchPoi searchPoi);

    String getDistance(SearchPoi searchPoi);

    void goChildPoiDetailFragment(boolean z, int i, boolean z2, int i2, int i3, int i4, int[] iArr, int[] iArr2, int[] iArr3);

    void goPoiDetailFragment(boolean z, int i, boolean z2, int[] iArr, int[] iArr2, int[] iArr3);

    void onCountrywideOnlineSearch();

    void onLoadMore();

    void onNormalOnlineSearch();

    void onRefresh();

    void pressleftTitleBack();

    void setFocusMadianIndex(SearchPoi searchPoi, boolean z, int i);

    void startGoNavi(boolean z, SearchPoi searchPoi);

    void updateAppMapView(int i, int i2);

    void updateResultPoiBkgLayer(ArrayList<SearchPoi> arrayList);
}
