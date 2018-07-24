package com.baidu.carlife.logic.p082b.p091c.p092a;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.R;
import com.baidu.carlife.logic.p082b.p090b.C1717a;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.C1141f;
import com.baidu.carlife.p059c.p060a.C1092a;
import com.baidu.carlife.p059c.p064d.C1116d;
import com.baidu.carlife.p059c.p066e.C1133a;

/* compiled from: SingleTextItemPresenter */
/* renamed from: com.baidu.carlife.logic.b.c.a.c */
public abstract class C1726c extends C1133a<C1717a> {

    /* compiled from: SingleTextItemPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.a.c$1 */
    class C17241 implements C1116d<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1726c f5247a;

        C17241(C1726c this$0) {
            this.f5247a = this$0;
        }

        /* renamed from: a */
        public void m6298a(@Nullable Boolean aBoolean) {
            this.f5247a.m6301a(aBoolean.booleanValue());
        }
    }

    /* compiled from: SingleTextItemPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.a.c$2 */
    class C17252 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1726c f5248a;

        C17252(C1726c this$0) {
            this.f5248a = this$0;
        }

        public void onClick(View v) {
            C1141f.m3839a().m3841a(this.f5248a.mo1624f(), null, C1092a.m3696c());
        }
    }

    /* renamed from: f */
    protected abstract C1105d<Void, Void> mo1624f();

    /* renamed from: b */
    protected /* synthetic */ void mo1623b(Object obj) {
        m6302a((C1717a) obj);
    }

    /* renamed from: a */
    protected void m6302a(C1717a voiceSettingItem) {
        voiceSettingItem.m6278c().m3760a(new C17241(this));
        mo1429b().m3705a((int) R.id.title, (String) voiceSettingItem.m6282e().m3762b());
        m6301a(((Boolean) voiceSettingItem.m6278c().m3762b()).booleanValue());
        mo1429b().m3702a().setOnClickListener(new C17252(this));
    }

    /* renamed from: a */
    private void m6301a(boolean isShowRedPoint) {
        mo1429b().m3703a((int) R.id.red_point).setVisibility(isShowRedPoint ? 0 : 8);
    }
}
