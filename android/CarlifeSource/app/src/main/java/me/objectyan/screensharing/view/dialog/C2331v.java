package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;

/* compiled from: VoiceDialog */
/* renamed from: com.baidu.carlife.view.dialog.v */
public class C2331v extends BaseDialog {
    /* renamed from: e */
    private FrameLayout f7644e;
    /* renamed from: f */
    private int f7645f;
    /* renamed from: g */
    private int f7646g;
    /* renamed from: h */
    private OnKeyListener f7647h;
    /* renamed from: i */
    private C1443g f7648i;
    /* renamed from: j */
    private C1438c f7649j;

    /* compiled from: VoiceDialog */
    /* renamed from: com.baidu.carlife.view.dialog.v$1 */
    class C23301 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2331v f7643a;

        C23301(C2331v this$0) {
            this.f7643a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0 || keyCode != 21) {
                return false;
            }
            this.f7643a.mo1526d();
            return true;
        }
    }

    public C2331v(Context context, View view, int styleId) {
        super(context, null, R.style.CommonRightListDialog);
        this.f7645f = -1;
        this.f7646g = 0;
        this.f7647h = new C23301(this);
        this.b.removeMsg(CommonParams.hb);
    }

    public C2331v(Context context, View view, int styleId, int width, int gravity) {
        this(context, view, R.style.CommonRightListDialog);
        this.f7645f = width;
        this.f7646g = gravity;
        LayoutParams layoutParams = (LayoutParams) this.f7644e.getLayoutParams();
        layoutParams.gravity = this.f7646g;
        this.f7644e.setLayoutParams(layoutParams);
        this.f7644e.addView(view);
        ViewGroup.LayoutParams viewParams = view.getLayoutParams();
        viewParams.width = this.f7645f;
        view.setLayoutParams(viewParams);
    }

    /* renamed from: a */
    protected View mo1528a() {
        this.f7644e = new FrameLayout(this.c);
        return this.f7644e;
    }

    /* renamed from: b */
    protected void mo1529b() {
        setCanceledOnTouchOutside(true);
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7648i == null) {
            this.f7648i = new C1443g(this.f7644e.findViewById(R.id.rl_top), 7);
            this.f7648i.m5300d(this.f7644e.findViewById(R.id.iv_voice_close)).m5300d(this.f7644e.findViewById(R.id.iv_voice_help));
        }
        if (this.f7649j == null) {
            this.f7649j = new C1438c((ListView) this.f7644e.findViewById(R.id.lv_multi_result), 11);
        }
        this.f7648i.m5295a(this.f7647h);
        this.f7649j.m5249a(this.f7647h);
        this.f7648i.m5244a(true);
        this.f7649j.m5244a(true);
        C1440d.m5251a().m5253a(this.f7648i, this.f7649j);
    }

    /* renamed from: i */
    public void mo1630i() {
        C1440d.m5251a().m5253a(this.f7648i, this.f7649j);
        C1440d.m5251a().m5268h(this.f7648i);
    }
}
