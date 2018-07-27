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

/* compiled from: MapDescriptionItemPresenter */
/* renamed from: com.baidu.carlife.logic.b.c.a.b */
public abstract class C1723b extends C1133a<C1717a> {

    /* compiled from: MapDescriptionItemPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.a.b$1 */
    class C17211 implements C1116d<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1723b f5245a;

        C17211(C1723b this$0) {
            this.f5245a = this$0;
        }

        /* renamed from: a */
        public void m6291a(@Nullable Boolean aBoolean) {
            this.f5245a.m6294a(aBoolean.booleanValue());
        }
    }

    /* compiled from: MapDescriptionItemPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.a.b$2 */
    class C17222 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1723b f5246a;

        C17222(C1723b this$0) {
            this.f5246a = this$0;
        }

        public void onClick(View v) {
            C1141f.m3839a().m3841a(this.f5246a.mo1627f(), null, C1092a.m3696c());
        }
    }

    /* renamed from: f */
    protected abstract C1105d<Void, Void> mo1627f();

    /* renamed from: b */
    public /* synthetic */ void mo1623b(Object obj) {
        m6295a((C1717a) obj);
    }

    /* renamed from: a */
    public void m6295a(C1717a data) {
        data.m6278c().m3760a(new C17211(this));
        mo1429b().m3702a().setOnClickListener(new C17222(this));
        m6294a(((Boolean) data.m6278c().m3762b()).booleanValue());
        mo1429b().m3705a((int) R.id.title, (String) data.m6282e().m3762b());
        mo1429b().m3705a((int) R.id.description, (String) data.m6280d().m3762b());
    }

    /* renamed from: a */
    private void m6294a(boolean isShowRedPoint) {
        mo1429b().m3703a((int) R.id.red_point).setVisibility(isShowRedPoint ? 0 : 8);
    }
}
