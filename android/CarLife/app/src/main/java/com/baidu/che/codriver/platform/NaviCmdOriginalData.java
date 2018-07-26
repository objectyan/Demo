package com.baidu.che.codriver.platform;

import com.baidu.che.codriver.util.INoProguard;

public class NaviCmdOriginalData implements INoProguard {
    public String domain;
    public String intent;
    public ExtInfo object;

    public static class ExtInfo implements INoProguard {
        public String arrival;
        public String centre;
        public String item;
        public String lat;
        public String lng;
        public String poiName;
        public String poiRegion;
    }
}
