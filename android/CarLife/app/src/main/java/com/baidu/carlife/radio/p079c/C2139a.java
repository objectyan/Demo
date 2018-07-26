package com.baidu.carlife.radio.p079c;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0772c;
import com.baidu.carlife.core.screen.C1277e;
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
    public void m8066a(C1277e onDialogListener, final C1491a listener) {
        if (C2142b.m8067a().m8075b() && C1251e.m4381s() == 1) {
            final C1953c dialog = new C1953c(this.f6815a);
            dialog.m7442b((int) C0965R.string.net_tips).m7435a((int) C0965R.string.net_msg).m7447c((int) C0965R.string.net_ok).m7458q().m7438a(new C0672b(this) {
                /* renamed from: b */
                final /* synthetic */ C2139a f6814b;

                public void onClick() {
                    C2142b.m8067a().m8072a(false);
                    listener.mo1562a();
                }
            }).m7450d((int) C0965R.string.net_cancel).m7436a(1, 8).m7439a(new C0772c(this) {
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
