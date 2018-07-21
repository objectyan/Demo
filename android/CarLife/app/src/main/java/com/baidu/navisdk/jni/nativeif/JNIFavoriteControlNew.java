package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import java.util.ArrayList;

public class JNIFavoriteControlNew
{
  public native int addFavoritePOI(Bundle paramBundle1, Bundle paramBundle2);
  
  public native int cancelSyncFavoritePOI();
  
  public native int clearAllFavoritePOI();
  
  public native int createFavSubSystem();
  
  public native int getAllFavoritePOIS(int paramInt, ArrayList<Bundle> paramArrayList);
  
  public native int getFavPoiKeyByPoint(Bundle paramBundle1, Bundle paramBundle2);
  
  public native int getFavoritePOIByKey(String paramString, Bundle paramBundle);
  
  public native int getFavoritePOIByPoint(Bundle paramBundle1, Bundle paramBundle2);
  
  public native int getFavoritePoiCnt(Bundle paramBundle);
  
  public native int loadAllFavoritePOISFromDB();
  
  public native int removeFavoritePOI(String paramString);
  
  public native int startSyncFavoritePOI();
  
  public native int updateFavoritePOI(Bundle paramBundle);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNIFavoriteControlNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */