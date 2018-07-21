package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class CmdSearchWithPager
  extends CommandBase
  implements JNISearchConst
{
  SearchPoiPager mSearchPoiPager;
  
  private Bundle getNameSearchByKeyBundle(SearchPoiPager paramSearchPoiPager)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("Name", paramSearchPoiPager.getSearchKey().toUpperCase(Locale.getDefault()));
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramSearchPoiPager.getDistrct()));
    int i = paramSearchPoiPager.getCountPerPager();
    if (paramSearchPoiPager.getNetMode() == 1) {}
    for (i = Math.min(i, 20);; i = Math.min(i, 100))
    {
      localBundle.putInt("PoiCount", i);
      localBundle.putInt("PoiPagerNum", paramSearchPoiPager.getPagerNum());
      return localBundle;
    }
  }
  
  private Bundle getNameSearchByKeyWithRouteBundle(SearchPoiPager paramSearchPoiPager)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("Name", paramSearchPoiPager.getSearchKey().toUpperCase(Locale.getDefault()));
    localBundle.putInt("Mode", paramSearchPoiPager.getSearchMode());
    localBundle.putInt("Range", paramSearchPoiPager.getSearchRange());
    int j = paramSearchPoiPager.getSortType();
    if (j >= 1)
    {
      i = j;
      if (j <= 3) {}
    }
    else
    {
      i = 1;
    }
    localBundle.putInt("Sort", i);
    int i = paramSearchPoiPager.getCountPerPager();
    if (paramSearchPoiPager.getNetMode() == 1) {}
    for (i = Math.min(i, 30);; i = Math.min(i, 100))
    {
      localBundle.putInt("PoiCount", i);
      localBundle.putInt("PoiPagerNum", paramSearchPoiPager.getPagerNum());
      return localBundle;
    }
  }
  
  private Bundle getSpaceSearchByCatalogBundle(SearchPoiPager paramSearchPoiPager)
  {
    SearchCircle localSearchCircle = paramSearchPoiPager.getSearchCircle();
    int i = paramSearchPoiPager.getNetMode();
    DistrictInfo localDistrictInfo = JNISearchControl.sInstance.getDistrictByPoint(localSearchCircle.mCenter, i);
    if ((localDistrictInfo == null) || ((localDistrictInfo.mType != 2) && (localDistrictInfo.mType != 3))) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("CatalogId", paramSearchPoiPager.getCatalogId());
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(localDistrictInfo));
    localBundle.putInt("HasCircle", 1);
    localBundle.putInt("CenterX", localSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", localSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", localSearchCircle.mRadius);
    int j = paramSearchPoiPager.getCountPerPager();
    if (i == 1) {}
    for (i = Math.min(j, 20);; i = Math.min(j, 100))
    {
      localBundle.putInt("PoiCount", i);
      localBundle.putInt("PoiPagerNum", paramSearchPoiPager.getPagerNum());
      return localBundle;
    }
  }
  
  private Bundle getSpaceSearchByCatalogWithDistrictIdBundle(SearchPoiPager paramSearchPoiPager)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("CatalogId", paramSearchPoiPager.getCatalogId());
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramSearchPoiPager.getDistrct()));
    localBundle.putInt("HasCircle", 1);
    SearchCircle localSearchCircle = paramSearchPoiPager.getSearchCircle();
    localBundle.putInt("CenterX", localSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", localSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", localSearchCircle.mRadius);
    int i = paramSearchPoiPager.getCountPerPager();
    if (paramSearchPoiPager.getNetMode() == 1) {}
    for (i = Math.min(i, 20);; i = Math.min(i, 100))
    {
      localBundle.putInt("PoiCount", i);
      localBundle.putInt("PoiPagerNum", paramSearchPoiPager.getPagerNum());
      return localBundle;
    }
  }
  
  private Bundle getSpaceSearchByKeyBundle(SearchPoiPager paramSearchPoiPager)
  {
    Bundle localBundle = new Bundle();
    SearchCircle localSearchCircle = paramSearchPoiPager.getSearchCircle();
    int i = paramSearchPoiPager.getNetMode();
    DistrictInfo localDistrictInfo = JNISearchControl.sInstance.getDistrictByPoint(localSearchCircle.mCenter, i);
    if ((localDistrictInfo == null) || ((localDistrictInfo.mType != 2) && (localDistrictInfo.mType != 3))) {
      return null;
    }
    localBundle.putString("Name", paramSearchPoiPager.getSearchKey().toUpperCase(Locale.getDefault()));
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(localDistrictInfo));
    localBundle.putInt("HasCircle", 1);
    localBundle.putInt("CenterX", localSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", localSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", localSearchCircle.mRadius);
    int j = paramSearchPoiPager.getCountPerPager();
    if (i == 1) {}
    for (i = Math.min(j, 20);; i = Math.min(j, 100))
    {
      localBundle.putInt("PoiCount", i);
      localBundle.putInt("PoiPagerNum", paramSearchPoiPager.getPagerNum());
      return localBundle;
    }
  }
  
  private Bundle getSpaceSearchByKeyWithDistrictIdBundle(SearchPoiPager paramSearchPoiPager)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("Name", paramSearchPoiPager.getSearchKey().toUpperCase(Locale.getDefault()));
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramSearchPoiPager.getDistrct()));
    localBundle.putInt("HasCircle", 1);
    SearchCircle localSearchCircle = paramSearchPoiPager.getSearchCircle();
    localBundle.putInt("CenterX", localSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", localSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", localSearchCircle.mRadius);
    int i = paramSearchPoiPager.getCountPerPager();
    if (paramSearchPoiPager.getNetMode() == 1) {}
    for (i = Math.min(i, 20);; i = Math.min(i, 100))
    {
      localBundle.putInt("PoiCount", i);
      localBundle.putInt("PoiPagerNum", paramSearchPoiPager.getPagerNum());
      return localBundle;
    }
  }
  
  public static void packetParams(ReqData paramReqData, SearchPoiPager paramSearchPoiPager)
  {
    paramReqData.mParams.put("param.search.pager", paramSearchPoiPager);
  }
  
  protected CommandResult exec()
  {
    boolean bool2 = true;
    Object localObject = SearchStatItem.getInstance();
    ((SearchStatItem)localObject).init();
    long l = SystemClock.elapsedRealtime();
    int i = searchWithPager(this.mSearchPoiPager);
    label44:
    int j;
    if (i >= 0)
    {
      this.mRet.setSuccess();
      if (i < 0) {
        break label114;
      }
      bool1 = true;
      ((SearchStatItem)localObject).mSearchSucc = bool1;
      j = BNPoiSearcher.getInstance().getSearchNetworkMode();
      ((SearchStatItem)localObject).setSearchType(j);
      ((SearchStatItem)localObject).setResponseTime(SystemClock.elapsedRealtime() - l);
      ((SearchStatItem)localObject).onEvent();
      localObject = BNPoiSearcher.getInstance();
      if (i < 0) {
        break label119;
      }
    }
    label114:
    label119:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((BNPoiSearcher)localObject).mtjStatSearch(j, bool1);
      return this.mRet;
      this.mRet.set(i);
      break;
      bool1 = false;
      break label44;
    }
  }
  
  protected void handleSuccess()
  {
    Object localObject = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
    ArrayList localArrayList = this.mSearchPoiPager.getPoiList();
    if ((localObject != null) && (localArrayList != null) && (localArrayList.size() > 0)) {
      ((PoiSearchModel)localObject).addSearchPoiPager(this.mSearchPoiPager);
    }
    for (;;)
    {
      if (!this.mReqData.mHasMsgSent)
      {
        localObject = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
        ((Message)localObject).arg1 = 0;
        ((Message)localObject).obj = new RspData(this.mReqData, this.mSearchPoiPager);
        ((Message)localObject).sendToTarget();
        this.mReqData.mHasMsgSent = true;
      }
      return;
    }
  }
  
  public int searchWithPager(SearchPoiPager paramSearchPoiPager)
  {
    if ((paramSearchPoiPager == null) || (!paramSearchPoiPager.isVail())) {
      return -1;
    }
    Object localObject = null;
    switch (paramSearchPoiPager.getSearchType())
    {
    }
    while (localObject == null)
    {
      return -3;
      localObject = getNameSearchByKeyBundle(paramSearchPoiPager);
      continue;
      localObject = getSpaceSearchByKeyBundle(paramSearchPoiPager);
      continue;
      localObject = getSpaceSearchByKeyWithDistrictIdBundle(paramSearchPoiPager);
      continue;
      localObject = getSpaceSearchByCatalogBundle(paramSearchPoiPager);
      continue;
      localObject = getSpaceSearchByCatalogWithDistrictIdBundle(paramSearchPoiPager);
      continue;
      localObject = getNameSearchByKeyWithRouteBundle(paramSearchPoiPager);
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    switch (paramSearchPoiPager.getSearchType())
    {
    }
    for (;;)
    {
      LogUtil.e("", "searchByName() ret: " + i);
      LogUtil.e("", "outputList count: " + localArrayList.size());
      if (i >= 0) {
        break;
      }
      return -4;
      i = JNISearchControl.sInstance.searchByNameWithPager((Bundle)localObject, localArrayList);
      continue;
      i = JNISearchControl.sInstance.searchByNameWithPager((Bundle)localObject, localArrayList);
      continue;
      i = JNISearchControl.sInstance.searchByNameWithPager((Bundle)localObject, localArrayList);
      continue;
      i = JNISearchControl.sInstance.searchByCircleWithPager((Bundle)localObject, localArrayList);
      continue;
      i = JNISearchControl.sInstance.searchByCircleWithPager((Bundle)localObject, localArrayList);
      continue;
      i = JNISearchControl.sInstance.searchByKeyInRouteWithPager((Bundle)localObject, localArrayList);
    }
    int j = localArrayList.size();
    i = 0;
    if (i < j)
    {
      localObject = (Bundle)localArrayList.get(i);
      localObject = JNISearchControl.sInstance.parsePoiBundle((Bundle)localObject);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        paramSearchPoiPager.addSearchPoi(localObject);
      }
    }
    boolean bool = false;
    if (j > 0) {
      if (((Bundle)localArrayList.get(0)).getInt("IsLastPager", 0) <= 0) {
        break label419;
      }
    }
    label419:
    for (bool = true;; bool = false)
    {
      paramSearchPoiPager.setLastPager(bool);
      return j;
    }
  }
  
  public int spaceSearchByCatalogWith(int paramInt1, int paramInt2, SearchCircle paramSearchCircle, int paramInt3, int paramInt4, ArrayList<SearchPoi> paramArrayList, int paramInt5)
  {
    if ((paramSearchCircle == null) || (paramArrayList == null))
    {
      paramInt1 = -1;
      return paramInt1;
    }
    if (paramSearchCircle.mCenter == null) {
      return -2;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("CatalogId", paramInt1);
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramInt2));
    localBundle.putInt("HasCircle", 1);
    localBundle.putInt("CenterX", paramSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", paramSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", paramSearchCircle.mRadius);
    if (paramInt4 == 1) {}
    for (paramInt1 = Math.min(paramInt3, 20);; paramInt1 = Math.min(paramInt3, 100))
    {
      localBundle.putInt("PoiCount", paramInt1);
      localBundle.putInt("PoiPagerNum", paramInt5);
      paramSearchCircle = new ArrayList();
      paramInt1 = JNISearchControl.sInstance.searchByCircle(localBundle, paramSearchCircle);
      LogUtil.e("", "searchByCircle() ret: " + paramInt1);
      LogUtil.e("", "outputList count: " + paramSearchCircle.size());
      if (paramInt1 >= 0) {
        break;
      }
      return -4;
    }
    paramInt3 = paramSearchCircle.size();
    paramInt2 = 0;
    for (;;)
    {
      paramInt1 = paramInt3;
      if (paramInt2 >= paramInt3) {
        break;
      }
      localBundle = (Bundle)paramSearchCircle.get(paramInt2);
      paramArrayList.add(JNISearchControl.sInstance.parsePoiBundle(localBundle));
      paramInt2 += 1;
    }
  }
  
  public int spaceSearchByKeyWithPager(String paramString, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3, SearchPoiPager paramSearchPoiPager, int paramInt4)
  {
    if ((paramString == null) || (paramSearchCircle == null) || (paramSearchPoiPager == null)) {
      return -1;
    }
    if (paramString.length() <= 0) {
      return -2;
    }
    if (paramSearchCircle.mCenter == null) {
      return -3;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("Name", paramString.toUpperCase(Locale.getDefault()));
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramInt1));
    localBundle.putInt("HasCircle", 1);
    localBundle.putInt("CenterX", paramSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", paramSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", paramSearchCircle.mRadius);
    if (paramInt3 == 1) {}
    for (paramInt1 = Math.min(paramInt2, 20);; paramInt1 = Math.min(paramInt2, 100))
    {
      localBundle.putInt("PoiCount", paramInt1);
      localBundle.putInt("PoiPagerNum", paramInt4);
      paramString = new ArrayList();
      paramInt1 = JNISearchControl.sInstance.searchByNameWithPager(localBundle, paramString);
      LogUtil.e("", "searchByName() ret: " + paramInt1);
      LogUtil.e("", "outputList count: " + paramString.size());
      if (paramInt1 >= 0) {
        break;
      }
      return -5;
    }
    paramInt2 = paramString.size();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      paramSearchCircle = (Bundle)paramString.get(paramInt1);
      paramSearchCircle = JNISearchControl.sInstance.parsePoiBundle(paramSearchCircle);
      if (paramSearchCircle == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramSearchPoiPager.addSearchPoi(paramSearchCircle);
      }
    }
    boolean bool = false;
    if (paramInt2 > 0) {
      if (((Bundle)paramString.get(0)).getInt("IsLastPager", 0) <= 0) {
        break label331;
      }
    }
    label331:
    for (bool = true;; bool = false)
    {
      paramSearchPoiPager.setLastPager(bool);
      return paramInt2;
    }
  }
  
  public int spaceSearchByKeyWithPager(String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2, SearchPoiPager paramSearchPoiPager, int paramInt3)
  {
    if ((paramString == null) || (paramSearchCircle == null) || (paramSearchPoiPager == null)) {
      return -1;
    }
    if (paramString.length() <= 0) {
      return -2;
    }
    if (paramSearchCircle.mCenter == null) {
      return -3;
    }
    DistrictInfo localDistrictInfo = JNISearchControl.sInstance.getDistrictByPoint(paramSearchCircle.mCenter, paramInt2);
    if ((localDistrictInfo == null) || ((localDistrictInfo.mType != 2) && (localDistrictInfo.mType != 3))) {
      return -5;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("Name", paramString.toUpperCase(Locale.getDefault()));
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(localDistrictInfo.mId));
    localBundle.putInt("HasCircle", 1);
    localBundle.putInt("CenterX", paramSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", paramSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", paramSearchCircle.mRadius);
    if (paramInt2 == 1) {}
    for (paramInt1 = Math.min(paramInt1, 20);; paramInt1 = Math.min(paramInt1, 100))
    {
      localBundle.putInt("PoiCount", paramInt1);
      localBundle.putInt("PoiPagerNum", paramInt3);
      paramString = new ArrayList();
      paramInt1 = JNISearchControl.sInstance.searchByNameWithPager(localBundle, paramString);
      LogUtil.e("", "searchByName() ret: " + paramInt1);
      LogUtil.e("", "outputList count: " + paramString.size());
      if (paramInt1 >= 0) {
        break;
      }
      return -6;
    }
    paramInt2 = paramString.size();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      paramSearchCircle = (Bundle)paramString.get(paramInt1);
      paramSearchCircle = JNISearchControl.sInstance.parsePoiBundle(paramSearchCircle);
      if (paramSearchCircle == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramSearchPoiPager.addSearchPoi(paramSearchCircle);
      }
    }
    boolean bool = false;
    if (paramInt2 > 0) {
      if (((Bundle)paramString.get(0)).getInt("IsLastPager", 0) <= 0) {
        break label373;
      }
    }
    label373:
    for (bool = true;; bool = false)
    {
      paramSearchPoiPager.setLastPager(bool);
      return paramInt2;
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mSearchPoiPager = ((SearchPoiPager)paramReqData.mParams.get("param.search.pager"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSearchWithPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */