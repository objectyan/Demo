package com.baidu.navi.favorite.util;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.favorite.model.FavoriteSyncRequestModel;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class FavoriteSyncUtils
{
  public static final String TAG = FavoriteSyncUtils.class.getSimpleName();
  
  private static JSONObject favSyncPoiToJsonObject(FavSyncPoi paramFavSyncPoi)
  {
    Object localObject = null;
    try
    {
      JSONObject localJSONObject1;
      if (paramFavSyncPoi.getActionType() == 2)
      {
        i.b(TAG, "delete");
        if ((TextUtils.isEmpty(paramFavSyncPoi.cId)) || (TextUtils.isEmpty(paramFavSyncPoi.sId)))
        {
          i.b(TAG, "delete cid || sid is null");
          return null;
        }
        localJSONObject1 = new JSONObject();
        localObject = localJSONObject1;
      }
      for (;;)
      {
        try
        {
          localJSONObject1.put("cid", paramFavSyncPoi.cId);
          localObject = localJSONObject1;
          localJSONObject1.put("sid", paramFavSyncPoi.sId);
          localObject = localJSONObject1;
          localJSONObject1.put("detail", "");
          localObject = localJSONObject1;
          localJSONObject1.put("action", "del");
          localObject = localJSONObject1;
          return (JSONObject)localObject;
        }
        catch (Exception paramFavSyncPoi)
        {
          JSONObject localJSONObject3;
          JSONObject localJSONObject2;
          return null;
        }
        if (paramFavSyncPoi.getActionType() == 0)
        {
          i.b(TAG, "add");
          localJSONObject1 = new JSONObject();
          localObject = localJSONObject1;
          localJSONObject1.put("action", "add");
          localObject = localJSONObject1;
          localJSONObject1.put("sid", "");
          localObject = localJSONObject1;
          localJSONObject1.put("cid", paramFavSyncPoi.addTimesec);
          localObject = localJSONObject1;
          localJSONObject3 = new JSONObject();
          localObject = localJSONObject1;
          localJSONObject3.put("name", paramFavSyncPoi.poiName);
          localObject = localJSONObject1;
          localJSONObject3.put("geoptx", paramFavSyncPoi.pt.getDoubleX());
          localObject = localJSONObject1;
          localJSONObject3.put("geopty", paramFavSyncPoi.pt.getDoubleY());
          localObject = localJSONObject1;
          localJSONObject2 = new JSONObject();
          localObject = localJSONObject1;
          localJSONObject2.put("fromapp", "CarLife");
          localObject = localJSONObject1;
          if (TextUtils.isEmpty(paramFavSyncPoi.poiId))
          {
            localObject = localJSONObject1;
            localJSONObject2.put("type", 11);
            localObject = localJSONObject1;
            localJSONObject2.put("sourceid", "");
          }
          for (;;)
          {
            localObject = localJSONObject1;
            localJSONObject2.put("plateform", "4");
            localObject = localJSONObject1;
            localJSONObject2.put("extdata", localJSONObject3);
            localObject = localJSONObject1;
            paramFavSyncPoi = new JSONObject();
            localObject = localJSONObject1;
            paramFavSyncPoi.put("data", localJSONObject2.toString());
            localObject = localJSONObject1;
            localJSONObject1.put("detail", paramFavSyncPoi.toString());
            localObject = localJSONObject1;
            break;
            localObject = localJSONObject1;
            localJSONObject2.put("type", 10);
            localObject = localJSONObject1;
            localJSONObject2.put("sourceid", paramFavSyncPoi.poiId);
          }
        }
      }
      return null;
    }
    catch (Exception paramFavSyncPoi) {}
  }
  
  public static String getDatasStr(FavoriteSyncRequestModel paramFavoriteSyncRequestModel)
  {
    FavoritePois localFavoritePois = FavoritePois.getPoiInstance();
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = localFavoritePois.getFavPoiGenInfo();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int i = 0;
      if (i < localArrayList.size())
      {
        FavSyncPoi localFavSyncPoi = localFavoritePois.getFavPoiInfo((String)localArrayList.get(i));
        if ((!TextUtils.isEmpty(localFavSyncPoi.bduid)) && (!localFavSyncPoi.bduid.equals(paramFavoriteSyncRequestModel.bduid))) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localFavSyncPoi != null) && (localFavSyncPoi.getActionType() != 3))
          {
            JSONObject localJSONObject = favSyncPoiToJsonObject(localFavSyncPoi);
            if (localJSONObject != null)
            {
              localJSONArray.put(localJSONObject);
              paramFavoriteSyncRequestModel.addSyncPoi(localFavSyncPoi);
            }
          }
        }
      }
    }
    return localJSONArray.toString();
  }
  
  public static FavoriteSyncRequestModel getSyncDataRequestParams()
  {
    FavoriteSyncRequestModel localFavoriteSyncRequestModel = new FavoriteSyncRequestModel();
    localFavoriteSyncRequestModel.bduss = NaviAccountUtils.getInstance().syncGetBduss();
    localFavoriteSyncRequestModel.bduid = NaviAccountUtils.getInstance().getUid();
    if (localFavoriteSyncRequestModel.bduid == null) {
      localFavoriteSyncRequestModel.bduid = "";
    }
    i.b(TAG, "model.bduid:" + localFavoriteSyncRequestModel.bduid);
    localFavoriteSyncRequestModel.limit = "50";
    localFavoriteSyncRequestModel.lastver = FavoritePois.getPoiInstance().getDataVersion();
    localFavoriteSyncRequestModel.datas = getDatasStr(localFavoriteSyncRequestModel);
    return localFavoriteSyncRequestModel;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/util/FavoriteSyncUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */