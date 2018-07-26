package com.baidu.carlife.p078f;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.carmode.CarModeMapFragment;
import com.baidu.navi.view.ZoomButtonView.OnZoomBtnClickListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.util.ArrayList;

/* compiled from: FocusMapView */
/* renamed from: com.baidu.carlife.f.e */
public class C1441e extends C1436a implements OnFocusChangeListener {
    /* renamed from: v */
    private ArrayList<View> f4221v = new ArrayList();
    /* renamed from: w */
    private View f4222w;
    /* renamed from: x */
    private View f4223x;
    /* renamed from: y */
    private OnZoomBtnClickListener f4224y;

    /* renamed from: a */
    public void m5283a(OnZoomBtnClickListener zoomBtnClickListener) {
        this.f4224y = zoomBtnClickListener;
    }

    public C1441e(View view, int position) {
        super(view, position);
        view.setOnFocusChangeListener(this);
    }

    /* renamed from: a */
    public boolean mo1554a() {
        View view = null;
        if (this.f4223x != null) {
            if (m5273e(this.f4223x)) {
                return true;
            }
            this.f4223x = null;
        }
        if (this.f4222w == null) {
            if (this.f4221v.size() > 0) {
                view = (View) this.f4221v.get(0);
            }
            this.f4222w = view;
        }
        return m5273e(this.f4222w);
    }

    /* renamed from: e */
    public ArrayList<View> m5288e() {
        return this.f4221v;
    }

    /* renamed from: f */
    public View m5289f() {
        return this.f4222w;
    }

    /* renamed from: g */
    public View m5290g() {
        return this.f4223x;
    }

    /* renamed from: b */
    public C1441e m5285b(View view) {
        this.f4222w = view;
        return this;
    }

    /* renamed from: c */
    public C1441e m5286c(View view) {
        view.setOnKeyListener(this);
        this.f4221v.add(view);
        return this;
    }

    /* renamed from: d */
    public boolean m5287d(View view) {
        View view2 = null;
        boolean removed = this.f4221v.remove(view);
        if (this.f4223x == view) {
            this.f4223x = this.f4221v.size() == 0 ? null : (View) this.f4221v.get(0);
        }
        if (this.f4222w == view) {
            if (this.f4221v.size() != 0) {
                view2 = (View) this.f4221v.get(0);
            }
            this.f4222w = view2;
        }
        return removed;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        C1260i.m4435b("FocusManager", "onFocusChange v=" + v + " hasFocus=" + hasFocus);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        C1260i.m4435b("FocusManager", "onKey keyCode=" + keyCode + " v=" + v + " action=" + (event.getAction() == 0 ? "ACTION_DOWN" : "ACTION_UP"));
        if (event != null && event.getAction() == 0) {
            switch (keyCode) {
                case 19:
                    C1441e.m5278l();
                    return true;
                case 20:
                    C1441e.m5277k();
                    return true;
                case 21:
                    C1441e.m5276j();
                    return true;
                case 22:
                    C1441e.m5275i();
                    return true;
                case 23:
                    C1441e.m5274h();
                    return true;
                case 300:
                    if (this.f4224y != null) {
                        this.f4224y.onZoomInBtnClick();
                    }
                    return true;
                case 301:
                    if (this.f4224y != null) {
                        this.f4224y.onZoomOutBtnClick();
                    }
                    return true;
                case 302:
                    C1441e.m5280n();
                    return true;
                case 303:
                    C1441e.m5282p();
                    return true;
                case 304:
                    C1441e.m5279m();
                    return true;
                case 305:
                    C1441e.m5281o();
                    return true;
            }
        }
        return super.onKey(v, keyCode, event);
    }

    /* renamed from: e */
    private boolean m5273e(View view) {
        if (view != null && this.f4221v.contains(view)) {
            if (view.requestFocus()) {
                m5243a(view);
                C1260i.m4435b("FocusManager", "requestFocusForView view=" + view);
                this.f4223x = view;
                return true;
            }
            C1260i.m4443d("FocusManager", "requestFocusForView view=" + view + " failed");
        }
        return false;
    }

    /* renamed from: h */
    public static void m5274h() {
        GeoPoint screenCenter = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getHeightPixels() / 2, (ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(56)) / 2);
        if (screenCenter != null) {
            ContentFragment fragment = C1328h.m4757a().getCurrentFragment();
            if (fragment instanceof CarModeMapFragment) {
                ((CarModeMapFragment) fragment).handleLongPress(screenCenter);
            }
        }
    }

    /* renamed from: i */
    public static boolean m5275i() {
        return C1441e.m5272a(BNMapController.getInstance().getScreenWidth() / 3, 0);
    }

    /* renamed from: j */
    public static boolean m5276j() {
        return C1441e.m5272a((-BNMapController.getInstance().getScreenWidth()) / 3, 0);
    }

    /* renamed from: k */
    public static boolean m5277k() {
        return C1441e.m5272a(0, BNMapController.getInstance().getScreenHeight() / 3);
    }

    /* renamed from: l */
    public static boolean m5278l() {
        return C1441e.m5272a(0, (-BNMapController.getInstance().getScreenHeight()) / 3);
    }

    /* renamed from: m */
    public static boolean m5279m() {
        return C1441e.m5272a(BNMapController.getInstance().getScreenWidth() / 3, (-BNMapController.getInstance().getScreenHeight()) / 3);
    }

    /* renamed from: n */
    public static boolean m5280n() {
        return C1441e.m5272a((-BNMapController.getInstance().getScreenWidth()) / 3, (-BNMapController.getInstance().getScreenHeight()) / 3);
    }

    /* renamed from: o */
    public static boolean m5281o() {
        return C1441e.m5272a(BNMapController.getInstance().getScreenWidth() / 3, BNMapController.getInstance().getScreenHeight() / 3);
    }

    /* renamed from: p */
    public static boolean m5282p() {
        return C1441e.m5272a((-BNMapController.getInstance().getScreenWidth()) / 3, BNMapController.getInstance().getScreenHeight() / 3);
    }

    /* renamed from: a */
    private static boolean m5272a(int x, int y) {
        MapStatus st = BNMapController.getInstance().getMapStatus();
        if (st == null) {
            return false;
        }
        Bundle bd = CoordinateTransformUtil.MC2LLE6(st._CenterPtX, st._CenterPtY);
        Point pt = BNMapController.getInstance().getScreenPosByGeoPos(new GeoPoint(bd.getInt("LLx"), bd.getInt("LLy")));
        pt.f19727x += x;
        pt.f19728y += y;
        GeoPoint newGP = BNMapController.getInstance().getGeoPosByScreenPos(pt.f19727x, pt.f19728y);
        Bundle b = CoordinateTransformUtil.LL2MC(((double) newGP.getLongitudeE6()) / 100000.0d, ((double) newGP.getLatitudeE6()) / 100000.0d);
        st._CenterPtX = b.getInt("MCx");
        st._CenterPtY = b.getInt("MCy");
        NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationPos);
        return true;
    }
}
