package com.baidu.sapi2.result;

import java.util.List;

public class GetPopularPortraitsInfoResult extends SapiResult {
    public List<PopularPortraitsInfo> popularPortraitsInfoList;

    public static class PopularPortraitsInfo {
        public int myItem;
        public int num;
        public String series;
        public String url;
    }
}
