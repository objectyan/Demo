package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;

public class RouteNodeObj {
    public Point geoPt;
    public int nIndex;
    public String strText;
    public String strUid;

    public RouteNodeObj() {
        this.strUid = "";
        this.nIndex = 0;
        this.strText = "";
        this.geoPt = new Point();
    }

    public RouteNodeObj(MapObj obj) {
        this.strUid = obj.strUid;
        this.nIndex = obj.nIndex;
        this.strText = obj.strText;
        this.geoPt = obj.geoPt;
    }
}
