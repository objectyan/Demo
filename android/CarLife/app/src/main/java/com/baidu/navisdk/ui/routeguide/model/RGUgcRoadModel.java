package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.navisdk.jni.nativeif.JNIUgcRoadControl;
import com.baidu.navisdk.model.datastruct.UgcPointInfo;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RGUgcRoadModel
{
  private static final String BUNDLE_UGCINFO_DISTRICT = "BUNDLE_UGCINFO_DISTRICT";
  private static final String BUNDLE_UGCINFO_GEOPOINT = "BUNDLE_UGCINFO_GEOPOINT";
  private static final String BUNDLE_UGCINFO_ID = "BUNDLE_UGCINFO_ID";
  private static final String BUNDLE_UGCINFO_POINT_X = "BUNDLE_UGCINFO_POINT_X";
  private static final String BUNDLE_UGCINFO_POINT_Y = "BUNDLE_UGCINFO_POINT_Y";
  private static final String BUNDLE_UGCINFO_ROAD_NAME = "BUNDLE_UGCINFO_ROAD_NAME";
  private static final String BUNDLE_UGCINFO_SYNC_STATUS = "BUNDLE_UGCINFO_SYNC_STATUS";
  private static final String BUNDLE_UGCINFO_TIME = "BUNDLE_UGCINFO_TIME";
  private static final String BUNDLE_UGCINFO_TYPE = "BUNDLE_UGCINFO_TYPE";
  private static RGUgcRoadModel sInstance = null;
  private List<UgcPointInfo> mUgcYawItems = new ArrayList();
  private int ugcItemType = -1;
  
  public static RGUgcRoadModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new RGUgcRoadModel();
    }
    return sInstance;
  }
  
  public int getUgcItemType()
  {
    return this.ugcItemType;
  }
  
  public ArrayList<UgcPointInfo> getUgcManagerInfoList()
  {
    Object localObject = new ArrayList();
    JNIUgcRoadControl.sInstance.getAllItems((ArrayList)localObject, 0);
    LogUtil.e("RGUgcRoadModel", "getUgcManagerInfoList unYawPointCnt = " + 0);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bundle localBundle = (Bundle)((Iterator)localObject).next();
        UgcPointInfo localUgcPointInfo = new UgcPointInfo();
        localUgcPointInfo.mUgcId = localBundle.getString("BUNDLE_UGCINFO_ID");
        localUgcPointInfo.mUgcSyncStatus = localBundle.getInt("BUNDLE_UGCINFO_SYNC_STATUS");
        localUgcPointInfo.mUgcType = localBundle.getInt("BUNDLE_UGCINFO_TYPE");
        localUgcPointInfo.mUgcPointRoadName = localBundle.getString("BUNDLE_UGCINFO_ROAD_NAME");
        localUgcPointInfo.mUgcTime = localBundle.getString("BUNDLE_UGCINFO_TIME");
        localUgcPointInfo.mUgcDistrictName = localBundle.getString("BUNDLE_UGCINFO_DISTRICT");
        localBundle = localBundle.getBundle("BUNDLE_UGCINFO_GEOPOINT");
        if (localBundle != null)
        {
          LogUtil.e("RGUgcRoadModel", "getUgcManagerInfoList  viewPointBundle!=null:");
          localUgcPointInfo.longitude = localBundle.getInt("lon");
          localUgcPointInfo.latitude = localBundle.getInt("lat");
          localUgcPointInfo.setUgcViewPoint(localBundle.getInt("lon"), localBundle.getInt("lat"));
        }
        LogUtil.e("RGUgcRoadModel", "getUgcManagerInfoList  ugcPointInfo.mUgcId:" + localUgcPointInfo.mUgcId + "  ugcPointInfo.mUgcSyncStatus:" + localUgcPointInfo.mUgcSyncStatus + "  ugcPointInfo.mUgcType:" + localUgcPointInfo.mUgcType + "  ugcPointInfo.mUgcPointRoadName:" + localUgcPointInfo.mUgcPointRoadName + "  ugcPointInfo.mUgcTime:" + localUgcPointInfo.mUgcTime + "  ugcPointInfo.lon:" + localUgcPointInfo.longitude + "  ugcPointInfo.lat:" + localUgcPointInfo.latitude);
        localArrayList.add(localUgcPointInfo);
      }
    }
    return localArrayList;
  }
  
  public List<UgcPointInfo> getUgcYawItems()
  {
    return this.mUgcYawItems;
  }
  
  public int getUgcYawItemsNum()
  {
    int i = 0;
    if (this.mUgcYawItems != null) {
      i = this.mUgcYawItems.size();
    }
    return i;
  }
  
  public ArrayList<UgcPointInfo> getUgcYawPointList()
  {
    Object localObject = new ArrayList();
    JNIUgcRoadControl.sInstance.getCurYawPoint((ArrayList)localObject, 10);
    LogUtil.e("RGUgcRoadModel", "getUgcYawPointList unYawPointCnt = " + 10);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bundle localBundle = (Bundle)((Iterator)localObject).next();
        UgcPointInfo localUgcPointInfo = new UgcPointInfo();
        localUgcPointInfo.mUgcPointRoadName = localBundle.getString("BUNDLE_UGCINFO_ROAD_NAME");
        localUgcPointInfo.mUgPermitType = localBundle.getInt("BUNDLE_UGCINFO_TYPE");
        localBundle = localBundle.getBundle("BUNDLE_UGCINFO_GEOPOINT");
        if (localBundle != null)
        {
          LogUtil.e("RGUgcRoadModel", "getUgcYawPointList  viewPointBundle!=null:");
          localUgcPointInfo.longitude = localBundle.getInt("lon");
          localUgcPointInfo.latitude = localBundle.getInt("lat");
          localUgcPointInfo.setUgcViewPoint(localBundle.getInt("lon"), localBundle.getInt("lat"));
        }
        LogUtil.e("RGUgcRoadModel", "getUgcYawPointList  ugcPointInfo.mUgPermitType:" + localUgcPointInfo.mUgPermitType + "  ugcPointInfo.mUgcPointRoadName:" + localUgcPointInfo.mUgcPointRoadName + "  ugcPointInfo.lon:" + localUgcPointInfo.longitude + "  ugcPointInfo.lat:" + localUgcPointInfo.latitude);
        localArrayList.add(localUgcPointInfo);
      }
    }
    return localArrayList;
  }
  
  public void reset()
  {
    if (this.mUgcYawItems != null) {
      this.mUgcYawItems.clear();
    }
  }
  
  public void setUgcItemType(int paramInt)
  {
    this.ugcItemType = paramInt;
  }
  
  public void updateUgcYawItems(List<UgcPointInfo> paramList)
  {
    reset();
    if ((paramList == null) || (paramList.size() == 0)) {}
    while (this.mUgcYawItems == null) {
      return;
    }
    this.mUgcYawItems.clear();
    this.mUgcYawItems.addAll(paramList);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGUgcRoadModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */