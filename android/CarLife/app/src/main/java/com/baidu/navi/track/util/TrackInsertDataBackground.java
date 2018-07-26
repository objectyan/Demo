package com.baidu.navi.track.util;

import com.baidu.navi.track.TrackCarDataSolveModel;

public class TrackInsertDataBackground {
    public static void createCarNaviData() {
        new TrackCarDataSolveModel().process();
    }
}
