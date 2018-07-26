package com.baidu.navi.track.datashop;

import com.baidu.navi.track.util.TrackNaviCsvFileUtil;

public class TrackFileCleanThread extends Thread {
    public void run() {
        TrackNaviCsvFileUtil.cleanTrackFile();
    }
}
