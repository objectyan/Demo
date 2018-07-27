package com.baidu.carlife.view;

import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.screen.OnDialogCancelListener;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.view.dialog.C2291j;
import com.baidu.carlife.view.dialog.C2305p;

/* compiled from: NewFeatureIntroWindow */
/* renamed from: com.baidu.carlife.view.c */
public class C2256c {
    /* renamed from: a */
    private static volatile C2256c f7365a = null;
    /* renamed from: b */
    private C2291j f7366b;
    /* renamed from: c */
    private C2305p f7367c;
    /* renamed from: d */
    private OnDialogListener f7368d;

    /* compiled from: NewFeatureIntroWindow */
    /* renamed from: com.baidu.carlife.view.c$1 */
    class C22551 implements OnDialogCancelListener {
        /* renamed from: a */
        final /* synthetic */ C2256c f7364a;

        C22551(C2256c this$0) {
            this.f7364a = this$0;
        }

        public void onCancel() {
            C2186p.m8304a().m8323c(CommonParams.f3570if, false);
        }
    }

    /* renamed from: a */
    public static C2256c m8570a() {
        if (f7365a == null) {
            f7365a = new C2256c();
        }
        return f7365a;
    }

    /* renamed from: a */
    public void m8572a(CarlifeActivity activity, OnDialogListener listener) {
        this.f7368d = listener;
        this.f7366b = new C2291j(activity);
        this.f7366b.setOnDialogCancelListener(new C22551(this));
    }

    /* renamed from: a */
    public void m8573a(int[] pos, int iconId, int hintId) {
        this.f7367c.m8776a(pos, iconId, hintId);
        this.f7368d.showDialog(this.f7367c);
    }

    /* renamed from: a */
    public void m8574a(int[] posNaviCard, int[] posRadioCard) {
        this.f7366b.m8714a(posNaviCard, posRadioCard);
        this.f7368d.showDialog(this.f7366b);
    }

    /* renamed from: a */
    public void m8571a(int iconId, int hintId) {
        if (this.f7367c != null && this.f7368d != null) {
            this.f7367c.m8775a(iconId, hintId);
            this.f7368d.showDialog(this.f7367c);
        }
    }
}
