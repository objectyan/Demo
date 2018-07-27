package me.objectyan.screensharing.core.screen.presentation;

import android.content.Context;
import android.view.Display;

import me.objectyan.screensharing.core.screen.OnSurfaceListener;

//import android.support.v4.app.OnFragmentListener;
//import com.baidu.navi.util.StatisticConstants;
//import com.baidu.navi.util.StatisticManager;

public class CarlifeActivityService extends AbsCarlifeActivityService {

    public void mo1462a(String lable) {
//        StatisticManager.onEvent(StatisticConstants.CONNECT_0007, lable);
    }


    public AbsCarlifePresentation mo1460a(AbsCarlifeActivityService outerContext, Display display) {
        return new CarlifePresentation(this, display);
    }


    public AbsCarlifeFakePresentation mo1459a(Context outerContext, Display display, OnSurfaceListener listener) {
        return new CarlifeFakePresentation(this, display, this);
    }


//    public void mo1461a(OnFragmentListener listener) {
//        FragmentManagerCallbackProxy.m4757a().m4761a(listener);
//    }
}
