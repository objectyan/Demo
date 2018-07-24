package com.baidu.carlife.core.screen.presentation;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.os.Bundle;
import android.view.Display;
import android.view.InputEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnTouchListener;
import com.baidu.carlife.core.screen.operation.CarlifeTouchManager;
import com.baidu.carlife.core.screen.presentation.view.CarLifePresentationController;

@TargetApi(19)
/* compiled from: AbsCarlifePresentation */
/* renamed from: com.baidu.carlife.core.screen.presentation.b */
public abstract class AbsCarlifePresentation extends Presentation implements KeepClass, OnTouchListener {
    /* renamed from: b */
    public static String f3714b = "CarlifeTouchManager#Presentation";

    /* renamed from: a */
    public abstract AbsCarlifeWindowCallback mo1452a(Window window);

    public AbsCarlifePresentation(AbsCarlifeActivityService outerContext, Display display) {
        super(outerContext, display);
        m4589a();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = CarLifePresentationController.m4626b().m4637e();
        if (decorView != null) {
            m4590a(decorView);
            setContentView(decorView);
            return;
        }
        LogUtil.d(f3714b, "decorView must be not null.");
    }

    /* renamed from: a */
    private void m4590a(View decorView) {
        ViewParent decorViewParent = decorView.getParent();
        if (decorViewParent == null || !(decorViewParent instanceof ViewGroup)) {
            LogUtil.d(f3714b, "decorViewParent is null or not is ViewGroup.");
            return;
        }
        ((ViewGroup) decorViewParent).removeView(decorView);
        m4591a((ViewGroup) decorViewParent);
    }

    /* renamed from: a */
    private void m4591a(ViewGroup decorViewParent) {
        if (CarLifePresentationController.m4626b().m4636d() != null) {
            View maskView = CarLifePresentationController.m4626b().m4636d().m4743b();
            if (maskView != null) {
                if (maskView.getParent() != null) {
                    ((ViewGroup) maskView.getParent()).removeView(maskView);
                }
                decorViewParent.addView(maskView);
                decorViewParent.invalidate();
                return;
            }
            LogUtil.d(f3714b, "maskView is null.");
            return;
        }
        LogUtil.d(f3714b, "carlifeMaskView is null.");
    }

    /* renamed from: a */
    public void mo1451a(InputEvent event, boolean inTouchMode) {
        m4594b(event, inTouchMode);
    }

    /* renamed from: b */
    public void m4594b(InputEvent event, boolean inTouchMode) {
        Window window = getWindow();
        LogUtil.d(f3714b, "injectInputEvent event:" + event);
        window.setLocalFocus(true, inTouchMode);
        window.injectInputEvent(event);
    }

    /* renamed from: a */
    private void m4589a() {
        Window window = getWindow();
        window.setType(CommonParams.fW);
        window.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        window.addFlags(16777216);
        window.addFlags(1024);
        window.setCallback(mo1452a(window));
    }

    public void show() {
        super.show();
        LogUtil.d(f3714b, "CarlifePresentation. show()");
        CarlifeTouchManager.m4515a().m4539a((OnTouchListener) this);
    }
}
