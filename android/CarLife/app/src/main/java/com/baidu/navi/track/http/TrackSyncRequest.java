package com.baidu.navi.track.http;

import android.text.TextUtils;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.navi.track.model.TrackSyncRequestModel;
import com.baidu.navi.track.model.TrackSyncResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackSyncRequest
  extends e
{
  private String guid;
  private boolean hasGuid;
  private int isResponse;
  private TrackSyncRequestModel requestModel;
  private TrackSyncResponseModel responseModel;
  
  public TrackSyncRequest()
  {
    this.tag = TrackSyncRequest.class.getSimpleName();
  }
  
  private int parseError(JSONObject paramJSONObject)
    throws JSONException
  {
    int i = 0;
    if (paramJSONObject.has("code"))
    {
      i = paramJSONObject.getInt("code");
      if (!paramJSONObject.has("errmsg")) {
        break label74;
      }
      paramJSONObject.getString("errmsg");
    }
    label74:
    while (!paramJSONObject.has("message"))
    {
      return i;
      if (paramJSONObject.has("errno"))
      {
        i = paramJSONObject.getInt("errno");
        break;
      }
      if (!paramJSONObject.has("status")) {
        break;
      }
      i = paramJSONObject.getInt("status");
      break;
    }
    paramJSONObject.getString("message");
    return i;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("actiontype", this.requestModel.actionType);
    locald.put("bduss", this.requestModel.bduss);
    locald.put("client_guids", this.requestModel.guidList);
    locald.put("guid", this.requestModel.guid);
    locald.put("is_response", this.requestModel.isResponse);
    locald.put("uid", this.requestModel.uid);
    if (("1".equals(this.requestModel.actionType)) || ("2".equals(this.requestModel.actionType)))
    {
      locald.put("appver", this.requestModel.appVer);
      locald.put("cuid", this.requestModel.cuid);
      locald.put("channel", this.requestModel.channel);
      locald.put("distance", this.requestModel.distance);
      locald.put("duration", this.requestModel.duration);
      locald.put("data_version", this.requestModel.dataVersion);
      locald.put("isconn", this.requestModel.isConn);
      locald.put("osversion", this.requestModel.osVersion);
      locald.put("os", this.requestModel.os);
      locald.put("mb", this.requestModel.mb);
      locald.put("mcuid", this.requestModel.mCuid);
      locald.put("loc", this.requestModel.loc);
      locald.put("imei", this.requestModel.imei);
      locald.put("max_speed", this.requestModel.maxSpeed);
      locald.put("name", this.requestModel.name);
      locald.put("start_time", this.requestModel.createTime);
      locald.put("start_end_coords", this.requestModel.startPosition + "_" + this.requestModel.endPosition);
      locald.put("speed", this.requestModel.speed);
      locald.put("type", this.requestModel.type);
      locald.put("version", this.requestModel.version);
    }
    locald.sortParams();
    locald.toSign();
    return locald;
  }
  
  public TrackSyncResponseModel getResponseModel()
  {
    return this.responseModel;
  }
  
  protected String getUrl()
  {
    return "https://vehicle.baidu.com/carlife/orbitsync";
  }
  
  public boolean hasGuid()
  {
    return this.hasGuid;
  }
  
  public int isResponse()
  {
    return this.isResponse;
  }
  
  protected int responseSuccessCallBack(String paramString)
  {
    int i = -1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      switch (parseError(localJSONObject))
      {
      case 0: 
        paramString = new JSONObject(paramString);
        this.isResponse = paramString.optInt("is_response");
        if (this.isResponse == 0)
        {
          this.guid = paramString.optString("guid");
          if (TextUtils.isEmpty(this.guid)) {
            break label177;
          }
          this.hasGuid = true;
        }
        else
        {
          if (this.isResponse != 1) {
            break label177;
          }
          this.responseModel = TrackSyncResponseModel.parseJson(paramString);
        }
        break;
      case 54: 
      case 56: 
        this.guid = localJSONObject.optString("data");
        if (TextUtils.isEmpty(this.guid)) {
          break label177;
        }
        this.hasGuid = true;
        break;
      case 51: 
        return 51;
      case 53: 
        return 53;
      }
      i = 0;
      label177:
      return i;
    }
    catch (JSONException paramString) {}
    return -1;
  }
  
  public void setParamsModel(TrackSyncRequestModel paramTrackSyncRequestModel)
  {
    this.requestModel = paramTrackSyncRequestModel;
    this.guid = "";
    this.hasGuid = false;
    this.isResponse = 0;
    this.responseModel = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/http/TrackSyncRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */