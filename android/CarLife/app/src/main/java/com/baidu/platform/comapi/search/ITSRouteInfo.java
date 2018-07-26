package com.baidu.platform.comapi.search;

import java.util.ArrayList;

public class ITSRouteInfo {
    public String digest;
    public boolean isHaveITS;
    public ArrayList<ITStep> steps;

    public static class ITStep {
        public int[] end;
        public int[] status;
    }
}
