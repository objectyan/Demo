package com.baidu.navisdk.comapi.routeguide;

import android.os.Message;

public interface IRGInfoListener {
    void onAssistInfoHide(Message message);

    void onAssistInfoShow(Message message);

    void onAssistInfoUpdate(Message message);

    void onCurRoadNameUpdate(Message message);

    void onDestStreetViewDownloadSuccess(Message message);

    void onDestStreetViewHide(Message message);

    void onDestStreetViewShow(Message message);

    void onDestStreetViewStartDownload(Message message);

    void onDestStreetViewUpdate(Message message);

    void onDirectBoardHide(Message message);

    void onDirectBoardShow(Message message);

    void onDirectBoardUpdate(Message message);

    void onHUDUpdate(Message message);

    void onHighwayInfoHide(Message message);

    void onHighwayInfoShow(Message message);

    void onHighwayInfoUpdate(Message message);

    void onRGSyncOperation(Message message);

    void onRasterExpandMapHide(Message message);

    void onRasterExpandMapShow(Message message);

    void onRasterExpandMapUpdate(Message message);

    void onRemainDistTimeUpdate(Message message);

    void onSimpleGuideInfoHide(Message message);

    void onSimpleGuideInfoShow(Message message);

    void onSimpleGuideInfoUpdate(Message message);

    void onVectorExpandMapHide(Message message);

    void onVectorExpandMapShow(Message message);

    void onVectorExpandMapUpdate(Message message);
}
