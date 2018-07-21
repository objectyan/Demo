package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class CmdSearchNearest
  extends CommandBase
  implements JNISearchConst
{
  Integer mCatalogId;
  SearchCircle mCircle;
  Integer mDistrictId;
  String mKey;
  Integer mNetMode;
  Integer mPoiCount;
  ArrayList<SearchPoi> mPoiList = new ArrayList();
  
  public static void packetParams(ReqData paramReqData, int paramInt1, int paramInt2, SearchCircle paramSearchCircle, int paramInt3, int paramInt4)
  {
    paramReqData.mParams.put("param.search.catalogid", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.districtid", Integer.valueOf(paramInt2));
    paramReqData.mParams.put("param.search.circle", paramSearchCircle);
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt3));
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt4));
  }
  
  public static void packetParams(ReqData paramReqData, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3)
  {
    paramReqData.mParams.put("param.search.catalogid", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.circle", paramSearchCircle);
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt2));
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt3));
  }
  
  public static void packetParams(ReqData paramReqData, String paramString, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3)
  {
    paramReqData.mParams.put("param.search.key", paramString);
    paramReqData.mParams.put("param.search.districtid", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.circle", paramSearchCircle);
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt2));
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt3));
  }
  
  public static void packetParams(ReqData paramReqData, String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2)
  {
    paramReqData.mParams.put("param.search.key", paramString);
    paramReqData.mParams.put("param.search.circle", paramSearchCircle);
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt2));
  }
  
  protected CommandResult exec()
  {
    int i;
    if (this.mKey != null) {
      if (this.mDistrictId != null)
      {
        i = spaceSearchByKey(this.mKey, this.mDistrictId.intValue(), this.mCircle, this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
        if (i < 0) {
          break label190;
        }
        this.mRet.setSuccess();
      }
    }
    for (;;)
    {
      return this.mRet;
      i = spaceSearchByKey(this.mKey, this.mCircle, this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
      break;
      if (this.mDistrictId != null)
      {
        i = spaceSearchByCatalog(this.mCatalogId.intValue(), this.mDistrictId.intValue(), this.mCircle, this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
        break;
      }
      i = spaceSearchByCatalog(this.mCatalogId.intValue(), this.mCircle, this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
      break;
      label190:
      this.mRet.set(i);
    }
  }
  
  protected void handleSuccess()
  {
    Object localObject = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
    if (localObject != null) {
      ((PoiSearchModel)localObject).setPoiList(this.mPoiList);
    }
    if (!this.mReqData.mHasMsgSent)
    {
      localObject = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).obj = new RspData(this.mReqData, this.mPoiList);
      ((Message)localObject).sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  public int spaceSearchByCatalog(int paramInt1, int paramInt2, SearchCircle paramSearchCircle, int paramInt3, int paramInt4, ArrayList<SearchPoi> paramArrayList)
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
  
  public int spaceSearchByCatalog(int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3, ArrayList<SearchPoi> paramArrayList)
  {
    if ((paramSearchCircle == null) || (paramArrayList == null))
    {
      paramInt1 = -1;
      return paramInt1;
    }
    if (paramSearchCircle.mCenter == null) {
      return -2;
    }
    DistrictInfo localDistrictInfo = JNISearchControl.sInstance.getDistrictByPoint(paramSearchCircle.mCenter, paramInt3);
    if ((localDistrictInfo == null) || ((localDistrictInfo.mType != 2) && (localDistrictInfo.mType != 3))) {
      return -4;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("CatalogId", paramInt1);
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(localDistrictInfo.mId));
    localBundle.putInt("HasCircle", 1);
    localBundle.putInt("CenterX", paramSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", paramSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", paramSearchCircle.mRadius);
    if (paramInt3 == 1) {}
    for (paramInt1 = Math.min(paramInt2, 20);; paramInt1 = Math.min(paramInt2, 100))
    {
      localBundle.putInt("PoiCount", paramInt1);
      paramSearchCircle = new ArrayList();
      paramInt1 = JNISearchControl.sInstance.searchByCircle(localBundle, paramSearchCircle);
      LogUtil.e("", "searchByCircle() ret: " + paramInt1);
      LogUtil.e("", "outputList count: " + paramSearchCircle.size());
      if (paramInt1 >= 0) {
        break;
      }
      return -5;
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
  
  public int spaceSearchByKey(String paramString, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3, ArrayList<SearchPoi> paramArrayList)
  {
    if ((paramString == null) || (paramSearchCircle == null) || (paramArrayList == null))
    {
      paramInt1 = -1;
      return paramInt1;
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
      paramString = new ArrayList();
      paramInt1 = JNISearchControl.sInstance.searchByName(localBundle, paramString);
      LogUtil.e("", "searchByName() ret: " + paramInt1);
      LogUtil.e("", "outputList count: " + paramString.size());
      if (paramInt1 >= 0) {
        break;
      }
      return -5;
    }
    paramInt3 = paramString.size();
    paramInt2 = 0;
    for (;;)
    {
      paramInt1 = paramInt3;
      if (paramInt2 >= paramInt3) {
        break;
      }
      paramSearchCircle = (Bundle)paramString.get(paramInt2);
      paramArrayList.add(JNISearchControl.sInstance.parsePoiBundle(paramSearchCircle));
      paramInt2 += 1;
    }
  }
  
  public int spaceSearchByKey(String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2, ArrayList<SearchPoi> paramArrayList)
  {
    if ((paramString == null) || (paramSearchCircle == null) || (paramArrayList == null))
    {
      paramInt1 = -1;
      return paramInt1;
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
      paramString = new ArrayList();
      paramInt1 = JNISearchControl.sInstance.searchByName(localBundle, paramString);
      LogUtil.e("", "searchByName() ret: " + paramInt1);
      LogUtil.e("", "outputList count: " + paramString.size());
      if (paramInt1 >= 0) {
        break;
      }
      return -6;
    }
    int i = paramString.size();
    paramInt2 = 0;
    for (;;)
    {
      paramInt1 = i;
      if (paramInt2 >= i) {
        break;
      }
      paramSearchCircle = (Bundle)paramString.get(paramInt2);
      paramArrayList.add(JNISearchControl.sInstance.parsePoiBundle(paramSearchCircle));
      paramInt2 += 1;
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mKey = ((String)paramReqData.mParams.get("param.search.key"));
    this.mCatalogId = ((Integer)paramReqData.mParams.get("param.search.catalogid"));
    this.mDistrictId = ((Integer)paramReqData.mParams.get("param.search.districtid"));
    this.mCircle = ((SearchCircle)paramReqData.mParams.get("param.search.circle"));
    this.mPoiCount = ((Integer)paramReqData.mParams.get("param.search.poicount"));
    this.mNetMode = ((Integer)paramReqData.mParams.get("param.search.netmode"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSearchNearest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */