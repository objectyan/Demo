package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import java.util.ArrayList;

public class JNIFavoriteControlNew {
    public native int addFavoritePOI(Bundle bundle, Bundle bundle2);

    public native int cancelSyncFavoritePOI();

    public native int clearAllFavoritePOI();

    public native int createFavSubSystem();

    public native int getAllFavoritePOIS(int i, ArrayList<Bundle> arrayList);

    public native int getFavPoiKeyByPoint(Bundle bundle, Bundle bundle2);

    public native int getFavoritePOIByKey(String str, Bundle bundle);

    public native int getFavoritePOIByPoint(Bundle bundle, Bundle bundle2);

    public native int getFavoritePoiCnt(Bundle bundle);

    public native int loadAllFavoritePOISFromDB();

    public native int removeFavoritePOI(String str);

    public native int startSyncFavoritePOI();

    public native int updateFavoritePOI(Bundle bundle);
}
