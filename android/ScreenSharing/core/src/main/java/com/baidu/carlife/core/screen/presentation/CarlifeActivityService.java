package com.baidu.carlife.core.screen.presentation;

import android.content.Context;
//import android.support.v4.app.OnFragmentListener;
import android.view.Display;
import com.baidu.carlife.core.screen.OnSurfaceListener;
//import com.baidu.navi.util.StatisticConstants;
//import com.baidu.navi.util.StatisticManager;

public class CarlifeActivityService extends AbsCarlifeActivityService {
    /* renamed from: a */
    public void mo1462a(String lable) {
//        StatisticManager.onEvent(StatisticConstants.CONNECT_0007, lable);
    }

    /* renamed from: a */
    public AbsCarlifePresentation mo1460a(AbsCarlifeActivityService outerContext, Display display) {
        return new CarlifePresentation(this, display);
    }

    /* renamed from: a */
    public AbsCarlifeFakePresentation mo1459a(Context outerContext, Display display, OnSurfaceListener listener) {
        return new CarlifeFakePresentation(this, display, this);
    }

    /* renamed from: a */
//    public void mo1461a(OnFragmentListener listener) {
//        FragmentManagerCallbackProxy.m4757a().m4761a(listener);
//    }
}
