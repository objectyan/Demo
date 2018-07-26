package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;

public class PoiObj {
    public Point geoPt;
    public int nIndex;
    public String strText;
    public String strUid;

    public PoiObj() {
        this.strUid = "";
        this.nIndex = 0;
        this.strText = "";
        this.geoPt = new Point();
    }

    public PoiObj(MapObj obj) {
        this.strUid = obj.strUid;
        this.nIndex = obj.nIndex;
        this.strText = obj.strText;
        this.geoPt = obj.geoPt;
    }
}
