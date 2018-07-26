package com.baidu.carlife.core.screen.presentation;

import android.content.Context;
import android.support.v4.app.OnFragmentListener;
import android.view.Display;
import com.baidu.carlife.core.screen.C1282k;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

public class CarlifeActivityService extends AbsCarlifeActivityService {
    /* renamed from: a */
    public void mo1462a(String lable) {
        StatisticManager.onEvent(StatisticConstants.CONNECT_0007, lable);
    }

    /* renamed from: a */
    public C1291b mo1460a(AbsCarlifeActivityService outerContext, Display display) {
        return new C1324e(this, display);
    }

    /* renamed from: a */
    public C1322a mo1459a(Context outerContext, Display display, C1282k listener) {
        return new C1323d(this, display, this);
    }

    /* renamed from: a */
    public void mo1461a(OnFragmentListener listener) {
        C1328h.m4757a().m4761a(listener);
    }
}
