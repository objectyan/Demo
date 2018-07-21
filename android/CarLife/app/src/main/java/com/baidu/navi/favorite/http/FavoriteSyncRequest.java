package com.baidu.navi.favorite.http;

import com.baidu.carlife.core.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavoriteSyncRequestModel;
import org.json.JSONException;

public class FavoriteSyncRequest
  extends e
{
  private FavoriteSyncRequestModel requestModel;
  
  public FavoriteSyncRequest()
  {
    this.tag = FavoriteSyncRequest.class.getSimpleName();
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("bduss", this.requestModel.bduss);
    locald.put("datas", this.requestModel.datas);
    return locald;
  }
  
  protected String getUrl()
  {
    return "http://client.map.baidu.com/sync/";
  }
  
  protected d getUrlParams()
  {
    d locald = new d();
    locald.put("type", "sync");
    locald.put("from", "carlife");
    locald.put("key", "2");
    locald.put("qt", "sync");
    locald.put("limit", this.requestModel.limit);
    locald.put("lastver", this.requestModel.lastver);
    locald.put("bduss", this.requestModel.bduss);
    locald.put("datas", this.requestModel.datas);
    locald.sortParams();
    String str = RequestParamsSignUtil.calcUrlSign(locald.getUrlParams());
    if (f.jp < 6) {
      i.b(this.tag, locald.getUrlParams().toString());
    }
    locald = new d();
    locald.put("type", "sync");
    locald.put("from", "carlife");
    locald.put("key", "2");
    locald.put("qt", "sync");
    locald.put("limit", this.requestModel.limit);
    locald.put("lastver", this.requestModel.lastver);
    locald.put("sign", str);
    if (f.jp < 6) {
      i.b(this.tag, locald.getUrlParams().toString());
    }
    return locald;
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    if (f.jp < 6) {
      i.b(this.tag, paramString);
    }
    return FavoritePois.getPoiInstance().handleSyncResult(paramString, this.requestModel.bduid);
  }
  
  public void setParamsModel(FavoriteSyncRequestModel paramFavoriteSyncRequestModel)
  {
    this.requestModel = paramFavoriteSyncRequestModel;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/http/FavoriteSyncRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */