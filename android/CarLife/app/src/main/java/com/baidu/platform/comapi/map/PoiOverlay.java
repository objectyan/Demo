package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.PoiResult.Contents;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.provider.PoiListProvider;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache$Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.List;

public class PoiOverlay extends InnerOverlay {
    int accFlag = 0;
    int centerFlag = 0;
    int centerPtX = 0;
    int centerPtY = 0;
    private boolean isSinglePoi;
    private int pageIndex;
    List<PoiResult> pbData = null;
    private int singleIndex;
    private List<Contents> uselessData;

    public PoiOverlay() {
        super(14);
    }

    public PoiOverlay(AppBaseMap baseMap) {
        super(14, baseMap);
    }

    public void setAccFlag(int flag) {
        this.accFlag = flag;
    }

    public void setCenterFlag(int flag) {
        this.centerFlag = flag;
    }

    public void setCenterPoint(Point pt) {
        this.centerPtX = pt.getIntX();
        this.centerPtY = pt.getIntY();
    }

    public void setPbData(List<PoiResult> pb) {
        this.pbData = pb;
    }

    public Bundle getParam() {
        Bundle param = new Bundle();
        param.putInt("accFlag", this.accFlag);
        param.putInt("centerFlag", this.centerFlag);
        if (hasCenterPoint()) {
            param.putInt("centerX", this.centerPtX);
            param.putInt("centerY", this.centerPtY);
        }
        return param;
    }

    private boolean hasCenterPoint() {
        return this.centerFlag == 1;
    }

    public String getData() {
        if (this.pbData == null) {
            ResultCache$Item item = ResultCache.getInstance().get(this.strJsonData);
            if (item == null || !(item.messageLite instanceof PoiResult)) {
                setType(14);
                return this.strJsonData;
            }
            setType(-1);
            this.pbData = new ArrayList();
            this.pbData.add((PoiResult) item.messageLite);
            return handlePBResult(this.pbData);
        } else if (this.pbData.size() <= 0) {
            return null;
        } else {
            setType(-1);
            return handlePBResult(this.pbData);
        }
    }

    private String handlePBResult(List<PoiResult> protoMessage) {
        PoiListProvider poiListProvider = new PoiListProvider(protoMessage, this.isSinglePoi, this.singleIndex, this.pageIndex);
        poiListProvider.setAccFlag(this.accFlag != 0);
        if (hasCenterPoint()) {
            poiListProvider.setCenterPoint(new Point((double) this.centerPtX, (double) this.centerPtY));
        }
        poiListProvider.setUseLessData(this.uselessData);
        return poiListProvider.getRenderData();
    }

    public void setSingPoi(boolean isSinglePoi) {
        this.isSinglePoi = isSinglePoi;
    }

    public void setSingPoiIndex(int singleIndex) {
        this.singleIndex = singleIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setUselessData(List<Contents> uselessData) {
        this.uselessData = uselessData;
    }
}
