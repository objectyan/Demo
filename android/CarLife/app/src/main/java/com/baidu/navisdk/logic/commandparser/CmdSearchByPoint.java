package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.HashMap;

public class CmdSearchByPoint
  extends CommandBase
  implements JNISearchConst
{
  int mCityId = -1;
  DistrictInfo mDistrict;
  Integer mNetmode = Integer.valueOf(3);
  SearchPoi mPOI;
  GeoPoint mPoint;
  int mProviceId = -1;
  Integer mSubType;
  
  public static void packetParams(ReqData paramReqData, int paramInt, GeoPoint paramGeoPoint)
  {
    paramReqData.mParams.put("param.search.subtype", Integer.valueOf(paramInt));
    paramReqData.mParams.put("param.search.point", paramGeoPoint);
  }
  
  public static void packetParams(ReqData paramReqData, int paramInt1, GeoPoint paramGeoPoint, int paramInt2)
  {
    paramReqData.mParams.put("param.search.subtype", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.point", paramGeoPoint);
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt2));
  }
  
  protected CommandResult exec()
  {
    if (this.mSubType.intValue() == 1) {
      if (this.mNetmode != null)
      {
        this.mPOI = getPoiByPoint(this.mPoint, this.mNetmode.intValue());
        if (this.mPOI != null) {
          this.mRet.setSuccess();
        }
      }
    }
    for (;;)
    {
      return this.mRet;
      DistrictInfo[] arrayOfDistrictInfo = JNISearchControl.sInstance.getDistrictsByPoint(this.mPoint);
      if ((arrayOfDistrictInfo == null) || (arrayOfDistrictInfo.length <= 1)) {
        break;
      }
      DistrictInfo localDistrictInfo = arrayOfDistrictInfo[1];
      if ((localDistrictInfo == null) || ((localDistrictInfo.mType != 2) && (localDistrictInfo.mType != 3))) {
        return this.mRet;
      }
      int j = 1;
      int i = j;
      if (localDistrictInfo.mType == 2)
      {
        i = j;
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(localDistrictInfo.mId)) {
          i = 0;
        }
      }
      GeoLocateModel.getInstance().updateDistrict(this.mPoint, arrayOfDistrictInfo[0], arrayOfDistrictInfo[1]);
      this.mPOI = getPoiByPoint(this.mPoint, i, localDistrictInfo.mId);
      break;
      if (this.mSubType.intValue() == 2)
      {
        arrayOfDistrictInfo = JNISearchControl.sInstance.getDistrictsByPoint(this.mPoint);
        if ((arrayOfDistrictInfo != null) && (arrayOfDistrictInfo.length > 1))
        {
          i = 0;
          if (i < 2)
          {
            if (arrayOfDistrictInfo[i] == null) {
              return this.mRet;
            }
            if (arrayOfDistrictInfo[i].mType == 3) {
              this.mCityId = arrayOfDistrictInfo[i].mId;
            }
            for (;;)
            {
              i += 1;
              break;
              if (arrayOfDistrictInfo[i].mType == 2) {
                this.mProviceId = arrayOfDistrictInfo[i].mId;
              }
            }
          }
          GeoLocateModel.getInstance().updateDistrict(this.mPoint, arrayOfDistrictInfo[0], arrayOfDistrictInfo[1]);
          this.mRet.setSuccess();
        }
        else
        {
          this.mRet.set(55537);
        }
      }
    }
  }
  
  public SearchPoi getPoiByPoint(GeoPoint paramGeoPoint, int paramInt)
  {
    if (paramGeoPoint == null) {}
    DistrictInfo localDistrictInfo;
    do
    {
      return null;
      localDistrictInfo = JNISearchControl.sInstance.getDistrictByPoint(paramGeoPoint, paramInt);
    } while ((localDistrictInfo == null) || ((localDistrictInfo.mType != 2) && (localDistrictInfo.mType != 3)));
    return getPoiByPoint(paramGeoPoint, paramInt, localDistrictInfo.mId);
  }
  
  public SearchPoi getPoiByPoint(GeoPoint paramGeoPoint, int paramInt1, int paramInt2)
  {
    if ((paramGeoPoint == null) || (paramInt2 == 0)) {
      LogUtil.e("", "getPoiByPoint: invalid args!");
    }
    Bundle localBundle;
    do
    {
      return null;
      localBundle = new Bundle();
      localBundle.putInt("CenterX", paramGeoPoint.getLongitudeE6());
      localBundle.putInt("CenterY", paramGeoPoint.getLatitudeE6());
      localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramInt2));
      paramGeoPoint = new Bundle();
    } while (JNISearchControl.sInstance.getNearestPoiByPoint(localBundle, paramGeoPoint) != 0);
    if ((!paramGeoPoint.containsKey("DistrictId")) || (paramGeoPoint.getInt("DistrictId", 0) == 0)) {
      paramGeoPoint.putInt("DistrictId", paramInt2);
    }
    return JNISearchControl.sInstance.parsePoiBundle(paramGeoPoint);
  }
  
  protected void handleSuccess()
  {
    if (this.mSubType.intValue() == 2) {
      if (!this.mReqData.mHasMsgSent)
      {
        localObject = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
        ((Message)localObject).arg1 = 0;
        Bundle localBundle = new Bundle();
        localBundle.putInt("city", this.mCityId);
        localBundle.putInt("provice", this.mProviceId);
        localBundle.putInt("LatitudeE6", this.mPoint.getLatitudeE6());
        localBundle.putInt("LongitudeE6", this.mPoint.getLongitudeE6());
        ((Message)localObject).obj = new RspData(this.mReqData, localBundle);
        ((Message)localObject).sendToTarget();
        this.mReqData.mHasMsgSent = true;
      }
    }
    do
    {
      return;
      localObject = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
      if (localObject != null) {
        ((PoiSearchModel)localObject).setAntiGeoPoi(this.mPOI);
      }
    } while (this.mReqData.mHasMsgSent);
    Object localObject = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
    ((Message)localObject).arg1 = 0;
    ((Message)localObject).obj = new RspData(this.mReqData, this.mPOI);
    ((Message)localObject).sendToTarget();
    this.mReqData.mHasMsgSent = true;
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mPoint = ((GeoPoint)paramReqData.mParams.get("param.search.point"));
    this.mSubType = ((Integer)paramReqData.mParams.get("param.search.subtype"));
    this.mNetmode = ((Integer)paramReqData.mParams.get("param.search.netmode"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSearchByPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */