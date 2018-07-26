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
    public static String Tag = "CarlifeTouchManager#Presentation";

    /* renamed from: a */
    public abstract AbsCarlifeWindowCallback mo1452a(Window window);

    public AbsCarlifePresentation(AbsCarlifeActivityService context, AbsCarlifeActivityService outerContext, Display display) {
        super(outerContext, display);
        m4589a();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = CarLifePresentationController.newInstance().getView();
        if (decorView != null) {
            m4590a(decorView);
            setContentView(decorView);
            return;
        }
        LogUtil.d(Tag, "decorView must be not null.");
    }

    /* renamed from: a */
    private void m4590a(View decorView) {
        ViewParent decorViewParent = decorView.getParent();
        if (decorViewParent == null || !(decorViewParent instanceof ViewGroup)) {
            LogUtil.d(Tag, "decorViewParent is null or not is ViewGroup.");
            return;
        }
        ((ViewGroup) decorViewParent).removeView(decorView);
        m4591a((ViewGroup) decorViewParent);
    }

    /* renamed from: a */
    private void m4591a(ViewGroup decorViewParent) {
        if (CarLifePresentationController.newInstance().getCarlifeMaskView() != null) {
            View maskView = CarLifePresentationController.newInstance().getCarlifeMaskView().getFrameLayout();
            if (maskView != null) {
                if (maskView.getParent() != null) {
                    ((ViewGroup) maskView.getParent()).removeView(maskView);
                }
                decorViewParent.addView(maskView);
                decorViewParent.invalidate();
                return;
            }
            LogUtil.d(Tag, "maskView is null.");
            return;
        }
        LogUtil.d(Tag, "carlifeMaskView is null.");
    }

    /* renamed from: a */
    public void mo1451a(InputEvent event, boolean inTouchMode) {
        m4594b(event, inTouchMode);
    }

    /* renamed from: b */
    public void m4594b(InputEvent event, boolean inTouchMode) {
        Window window = getWindow();
        LogUtil.d(Tag, "injectInputEvent event:" + event);
        window.setLocalFocus(true, inTouchMode);
        window.injectInputEvent(event);
    }

    /* renamed from: a */
    private void m4589a() {
        Window window = getWindow();
        window.setType(CommonParams.fW);
        window.addFlags(268435456);
        window.addFlags(16777216);
        window.addFlags(1024);
        window.setCallback(mo1452a(window));
    }

    public void show() {
        super.show();
        LogUtil.d(Tag, "CarlifePresentation. show()");
        CarlifeTouchManager.newInstance().initOnTouchListener((OnTouchListener) this);
    }
}
