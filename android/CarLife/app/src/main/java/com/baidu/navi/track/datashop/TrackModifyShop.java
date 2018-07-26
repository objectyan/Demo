package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import com.baidu.carlife.core.C1157a;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;

public class TrackModifyShop {
    private static final String TAG = TrackModifyShop.class.getSimpleName();

    public void updateNotLoginTracksBduis(String bduid) {
        Context context = C1157a.a();
        Intent intent = new Intent(context, DataService.class);
        intent.putExtra(DataService.EXTRA_BDUID, bduid);
        intent.setAction(Action.ACTION_UPDATE_NOT_LOGIN_TRAKS_BDUID.toString());
        context.startService(intent);
    }
}
