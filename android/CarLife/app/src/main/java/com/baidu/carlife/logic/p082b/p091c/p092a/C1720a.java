package com.baidu.carlife.logic.p082b.p091c.p092a;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.logic.p082b.p090b.C1717a;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.C1141f;
import com.baidu.carlife.p059c.p060a.C1092a;
import com.baidu.carlife.p059c.p064d.C1116d;
import com.baidu.carlife.p059c.p066e.C1133a;
import com.baidu.carlife.view.SwitchButton;

/* compiled from: CheckSettingItemPresenter */
/* renamed from: com.baidu.carlife.logic.b.c.a.a */
public abstract class C1720a extends C1133a<C1717a> {

    /* compiled from: CheckSettingItemPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.a.a$1 */
    class C17181 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1720a f5243a;

        C17181(C1720a this$0) {
            this.f5243a = this$0;
        }

        public void onClick(View v) {
            C1141f.m3839a().m3841a(this.f5243a.m6290f(), Boolean.valueOf(((SwitchButton) this.f5243a.mo1429b().m3703a((int) C0965R.id.sw_voice_wakeup)).isChecked()), C1092a.m3696c());
        }
    }

    /* compiled from: CheckSettingItemPresenter */
    /* renamed from: com.baidu.carlife.logic.b.c.a.a$2 */
    class C17192 implements C1116d<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1720a f5244a;

        C17192(C1720a this$0) {
            this.f5244a = this$0;
        }

        /* renamed from: a */
        public void m6284a(@Nullable Boolean aBoolean) {
            this.f5244a.m6287a(aBoolean.booleanValue());
        }
    }

    /* renamed from: f */
    protected abstract C1105d<Boolean, Void> m6290f();

    /* renamed from: b */
    public /* synthetic */ void mo1623b(Object obj) {
        m6288a((C1717a) obj);
    }

    /* renamed from: a */
    public void m6288a(C1717a data) {
        mo1429b().m3702a().setOnClickListener(new C17181(this));
        mo1429b().m3703a((int) C0965R.id.sw_voice_wakeup).setClickable(false);
        m6287a(((Boolean) data.m6276b().m3762b()).booleanValue());
        mo1429b().m3705a((int) C0965R.id.tv_item_name, (String) data.m6282e().m3762b());
        mo1429b().m3703a((int) C0965R.id.iv_direction_icon).setVisibility(8);
        data.m6276b().m3760a(new C17192(this));
    }

    /* renamed from: a */
    private void m6287a(boolean isChecked) {
        ((SwitchButton) mo1429b().m3703a((int) C0965R.id.sw_voice_wakeup)).setChecked(isChecked);
    }
}
