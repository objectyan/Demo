package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.WalkSearch;
import com.baidu.platform.comapi.map.provider.WalkSearchProvider;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache$Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;

public class WalkSearchOverlay extends InnerOverlay {
    byte[] pbData = null;

    public WalkSearchOverlay() {
        super(39);
    }

    public WalkSearchOverlay(AppBaseMap baseMap) {
        super(39, baseMap);
    }

    public void setPbData(byte[] pb) {
        this.pbData = pb;
    }

    public Bundle getParam() {
        return null;
    }

    public String getData() {
        if (this.pbData != null) {
            WalkSearch walkSearch = null;
            try {
                walkSearch = WalkSearch.parseFrom(this.pbData);
            } catch (InvalidProtocolBufferMicroException e) {
            }
            if (walkSearch == null) {
                return null;
            }
            setType(-1);
            return handlePBResult(walkSearch);
        }
        ResultCache$Item item = ResultCache.getInstance().get(this.strJsonData);
        if (item == null || !(item.messageLite instanceof WalkSearch)) {
            setType(39);
            return this.strJsonData;
        }
        setType(-1);
        return handlePBResult((WalkSearch) item.messageLite);
    }

    private String handlePBResult(WalkSearch protoMessage) {
        return new WalkSearchProvider(protoMessage).getRenderData();
    }
}
