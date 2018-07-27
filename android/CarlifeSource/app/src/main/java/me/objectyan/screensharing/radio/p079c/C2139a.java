package com.baidu.carlife.radio.p079c;

import android.content.Context;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.OnCountDownListener;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.view.dialog.C1953c;

/* compiled from: MobileNetworkTipsDialog */
/* renamed from: com.baidu.carlife.radio.c.a */
public class C2139a {
    /* renamed from: a */
    private Context f6815a;

    /* compiled from: MobileNetworkTipsDialog */
    /* renamed from: com.baidu.carlife.radio.c.a$a */
    public interface C1491a {
        /* renamed from: a */
        void mo1562a();
    }

    public C2139a(Context context) {
        this.f6815a = context;
    }

    /* renamed from: a */
    public void m8066a(OnDialogListener onDialogListener, final C1491a listener) {
        if (C2142b.m8067a().m8075b() && CarlifeUtil.m4381s() == 1) {
            final C1953c dialog = new C1953c(this.f6815a);
            dialog.m7442b((int) R.string.net_tips).m7435a((int) R.string.net_msg).m7447c((int) R.string.net_ok).m7458q().m7438a(new OnBtnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2139a f6814b;

                public void onClick() {
                    C2142b.m8067a().m8072a(false);
                    listener.mo1562a();
                }
            }).m7450d((int) R.string.net_cancel).m7436a(1, 8).m7439a(new OnCountDownListener(this) {
                /* renamed from: c */
                final /* synthetic */ C2139a f6812c;

                public void onCountDown(int count) {
                    if (count <= 0) {
                        dialog.mo1526d();
                        C2142b.m8067a().m8072a(false);
                        listener.mo1562a();
                    }
                }
            });
            onDialogListener.showDialog(dialog);
            return;
        }
        listener.mo1562a();
    }
}
