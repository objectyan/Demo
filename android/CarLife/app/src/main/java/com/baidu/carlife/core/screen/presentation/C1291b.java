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
import com.baidu.carlife.core.C0689h;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C1286o;
import com.baidu.carlife.core.screen.p053b.C1276f;
import com.baidu.carlife.core.screen.presentation.p071a.C1299b;

@TargetApi(19)
/* compiled from: AbsCarlifePresentation */
/* renamed from: com.baidu.carlife.core.screen.presentation.b */
public abstract class C1291b extends Presentation implements C0689h, C1286o {
    /* renamed from: b */
    public static String f3714b = "CarlifeTouchManager#Presentation";

    /* renamed from: a */
    public abstract C1289c mo1452a(Window window);

    public C1291b(AbsCarlifeActivityService outerContext, Display display) {
        super(outerContext, display);
        m4589a();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = C1299b.m4626b().m4637e();
        if (decorView != null) {
            m4590a(decorView);
            setContentView(decorView);
            return;
        }
        C1260i.m4435b(f3714b, "decorView must be not null.");
    }

    /* renamed from: a */
    private void m4590a(View decorView) {
        ViewParent decorViewParent = decorView.getParent();
        if (decorViewParent == null || !(decorViewParent instanceof ViewGroup)) {
            C1260i.m4435b(f3714b, "decorViewParent is null or not is ViewGroup.");
            return;
        }
        ((ViewGroup) decorViewParent).removeView(decorView);
        m4591a((ViewGroup) decorViewParent);
    }

    /* renamed from: a */
    private void m4591a(ViewGroup decorViewParent) {
        if (C1299b.m4626b().m4636d() != null) {
            View maskView = C1299b.m4626b().m4636d().m4743b();
            if (maskView != null) {
                if (maskView.getParent() != null) {
                    ((ViewGroup) maskView.getParent()).removeView(maskView);
                }
                decorViewParent.addView(maskView);
                decorViewParent.invalidate();
                return;
            }
            C1260i.m4435b(f3714b, "maskView is null.");
            return;
        }
        C1260i.m4435b(f3714b, "carlifeMaskView is null.");
    }

    /* renamed from: a */
    public void mo1451a(InputEvent event, boolean inTouchMode) {
        m4594b(event, inTouchMode);
    }

    /* renamed from: b */
    public void m4594b(InputEvent event, boolean inTouchMode) {
        Window window = getWindow();
        C1260i.m4435b(f3714b, "injectInputEvent event:" + event);
        window.setLocalFocus(true, inTouchMode);
        window.injectInputEvent(event);
    }

    /* renamed from: a */
    private void m4589a() {
        Window window = getWindow();
        window.setType(C1253f.fW);
        window.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        window.addFlags(16777216);
        window.addFlags(1024);
        window.setCallback(mo1452a(window));
    }

    public void show() {
        super.show();
        C1260i.m4435b(f3714b, "CarlifePresentation. show()");
        C1276f.m4515a().m4539a((C1286o) this);
    }
}
