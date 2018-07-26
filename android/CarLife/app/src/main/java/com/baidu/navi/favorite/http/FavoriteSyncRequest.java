package com.baidu.navi.favorite.http;

import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavoriteSyncRequestModel;
import com.baidu.navi.track.database.DataService;
import org.json.JSONException;

public class FavoriteSyncRequest extends C1626e {
    private FavoriteSyncRequestModel requestModel;

    public FavoriteSyncRequest() {
        this.tag = FavoriteSyncRequest.class.getSimpleName();
    }

    public void setParamsModel(FavoriteSyncRequestModel model) {
        this.requestModel = model;
    }

    protected String getUrl() {
        return "http://client.map.baidu.com/sync/";
    }

    protected C1622d getUrlParams() {
        C1622d params = new C1622d();
        params.put("type", "sync");
        params.put(PlatformConstants.CONNECT_EXTRA_KEY, C2848p.f9316q);
        params.put("key", "2");
        params.put("qt", "sync");
        params.put(DataService.EXTRA_LIMIT, this.requestModel.limit);
        params.put("lastver", this.requestModel.lastver);
        params.put("bduss", this.requestModel.bduss);
        params.put("datas", this.requestModel.datas);
        params.sortParams();
        String sign = RequestParamsSignUtil.calcUrlSign(params.getUrlParams());
        if (C1253f.jp < 6) {
            C1260i.b(this.tag, params.getUrlParams().toString());
        }
        C1622d urlParams = new C1622d();
        urlParams.put("type", "sync");
        urlParams.put(PlatformConstants.CONNECT_EXTRA_KEY, C2848p.f9316q);
        urlParams.put("key", "2");
        urlParams.put("qt", "sync");
        urlParams.put(DataService.EXTRA_LIMIT, this.requestModel.limit);
        urlParams.put("lastver", this.requestModel.lastver);
        urlParams.put("sign", sign);
        if (C1253f.jp < 6) {
            C1260i.b(this.tag, urlParams.getUrlParams().toString());
        }
        return urlParams;
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C1622d();
        params.put("bduss", this.requestModel.bduss);
        params.put("datas", this.requestModel.datas);
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        if (C1253f.jp < 6) {
            C1260i.b(this.tag, data);
        }
        return FavoritePois.getPoiInstance().handleSyncResult(data, this.requestModel.bduid);
    }
}
