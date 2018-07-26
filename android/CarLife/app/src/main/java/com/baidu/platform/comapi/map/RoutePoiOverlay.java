package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comapi.map.provider.RoutePoiListProvider;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache$Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;

public class RoutePoiOverlay extends InnerOverlay {
    byte[] pbData = null;

    public RoutePoiOverlay() {
        super(38);
    }

    public RoutePoiOverlay(AppBaseMap baseMap) {
        super(38, baseMap);
    }

    public void setPbData(byte[] pb) {
        this.pbData = pb;
    }

    public Bundle getParam() {
        return null;
    }

    public String getData() {
        if (this.pbData != null) {
            PoiResult poiResult = null;
            try {
                poiResult = PoiResult.parseFrom(this.pbData);
            } catch (InvalidProtocolBufferMicroException e) {
            }
            if (poiResult == null) {
                return null;
            }
            setType(-1);
            return handlePBResult(poiResult);
        }
        ResultCache$Item item = ResultCache.getInstance().get(this.strJsonData);
        if (item == null || !(item.messageLite instanceof PoiResult)) {
            setType(38);
            return this.strJsonData;
        }
        setType(-1);
        return handlePBResult((PoiResult) item.messageLite);
    }

    private String handlePBResult(PoiResult protoMessage) {
        return new RoutePoiListProvider(protoMessage).getRenderData();
    }
}
