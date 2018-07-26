package com.baidu.navi.promote;

public interface TrackResultCallBack {
    void onNetFail(TrackScoreModel trackScoreModel);

    void onScore(TrackScoreModel trackScoreModel);
}
