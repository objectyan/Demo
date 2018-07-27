package me.objectyan.screensharing.util;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import me.objectyan.screensharing.core.CarlifeScreenUtil;
import me.objectyan.screensharing.core.screen.OnStatusChangeListener;
import me.objectyan.screensharing.core.screen.presentation.CarlifeServiceConnection;
import me.objectyan.screensharing.core.screen.presentation.view.CarLifePresentationController;
import me.objectyan.screensharing.core.screen.video.Recorder;


public class CarlifeCoreVideo {

    public static final int f5149a = 1;

    public static final int f5150b = 2;

    public static final int f5151c = 3;

    public static final int f5152d = 4353;

    private static final String f5153e = "CarlifeCoreVideo";

    private static me.objectyan.screensharing.util.CarlifeCoreVideo f5154g;

    private Recorder f5155f;

    private CarlifeCoreVideo() {
        this.f5155f = null;
        this.f5155f = Recorder.newInstance();
    }


    public static me.objectyan.screensharing.util.CarlifeCoreVideo m6102a() {
        if (f5154g == null) {
            f5154g = new me.objectyan.screensharing.util.CarlifeCoreVideo();
        }
        return f5154g;
    }


    public int m6106b() {
        Recorder recorder = this.f5155f;
        return Recorder.getContainerWidth();
    }


    public int m6108c() {
        Recorder recorder = this.f5155f;
        return Recorder.getContainerHeight();
    }


    public Bitmap m6110d() {
        return this.f5155f.mBitmap;
    }


    public boolean m6112e() {
        return this.f5155f.m4870e();
    }


    public void m6105a(boolean needCheckIDRCnt) {
        this.f5155f.setIsNeedCheckIDRCnt(needCheckIDRCnt);
    }


    public void m6113f() {
        this.f5155f.m4875h();
    }


    public void m6114g() {
        this.f5155f.m4877i();
    }


    public boolean m6115h() {
        return this.f5155f.getIsJPEGMode();
    }


    public void m6107b(boolean isJPEGMode) {
        this.f5155f.setIsJPEGMode(isJPEGMode);
    }


    public void m6109c(boolean isStart) {
        this.f5155f.m4866c(isStart);
    }


    public boolean m6116i() {
        return this.f5155f.m4880k();
    }


    public boolean m6117j() {
        return this.f5155f.m4881l();
    }


    public void m6111d(boolean isNeedChangeColor) {
        this.f5155f.m4868d(isNeedChangeColor);
    }


    public void m6118k() {
        this.f5155f.onActivityPause();
    }


    public void m6119l() {
        this.f5155f.m4885p();
        CarLifePresentationController.newInstance().clearAll();
    }


    public void m6103a(int requestCode, int resultCode, Intent data) {
        this.f5155f.m4856a(requestCode, resultCode, data);
    }


    public boolean m6120m() {
        return this.f5155f.m4883n();
    }


    public CarlifeServiceConnection m6121n() {
        return CarLifePresentationController.newInstance().getServiceConn();
    }


    public void m6104a(Activity activity, Class CarlifeActivityServiceClass, OnStatusChangeListener listener, Drawable maskDrawable, int launchIconId) {
        CarLifePresentationController.newInstance().init(activity, CarlifeActivityServiceClass, listener);
        CarLifePresentationController.newInstance().setMaskDrawable(maskDrawable);
        CarLifePresentationController.newInstance().setLaunchIconId(launchIconId);
        CarlifeScreenUtil.newInstance().initScreenInfo(activity);
    }
}
