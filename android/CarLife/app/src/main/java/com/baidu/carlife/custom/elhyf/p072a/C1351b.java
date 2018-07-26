package com.baidu.carlife.custom.elhyf.p072a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.dialog.BaseDialog;

/* compiled from: ShareDialog */
/* renamed from: com.baidu.carlife.custom.elhyf.a.b */
public class C1351b extends BaseDialog {
    /* renamed from: e */
    private Context f3947e;
    /* renamed from: f */
    private TextView f3948f;
    /* renamed from: g */
    private RelativeLayout f3949g;
    /* renamed from: h */
    private RelativeLayout f3950h;
    /* renamed from: i */
    private C1348a f3951i;
    /* renamed from: j */
    private C1349b f3952j;
    /* renamed from: k */
    private C1350c f3953k;

    /* compiled from: ShareDialog */
    /* renamed from: com.baidu.carlife.custom.elhyf.a.b$1 */
    class C13451 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1351b f3944a;

        C13451(C1351b this$0) {
            this.f3944a = this$0;
        }

        public void onClick(View v) {
            if (this.f3944a.f3952j != null) {
                this.f3944a.f3952j.mo1545a();
            }
            this.f3944a.mo1526d();
        }
    }

    /* compiled from: ShareDialog */
    /* renamed from: com.baidu.carlife.custom.elhyf.a.b$2 */
    class C13462 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1351b f3945a;

        C13462(C1351b this$0) {
            this.f3945a = this$0;
        }

        public void onClick(View v) {
            if (this.f3945a.f3953k != null) {
                this.f3945a.f3953k.mo1546a();
            }
            this.f3945a.mo1526d();
        }
    }

    /* compiled from: ShareDialog */
    /* renamed from: com.baidu.carlife.custom.elhyf.a.b$3 */
    class C13473 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1351b f3946a;

        C13473(C1351b this$0) {
            this.f3946a = this$0;
        }

        public void onClick(View v) {
            if (this.f3946a.f3951i != null) {
                this.f3946a.f3951i.m4946a();
            }
            this.f3946a.mo1526d();
        }
    }

    /* compiled from: ShareDialog */
    /* renamed from: com.baidu.carlife.custom.elhyf.a.b$a */
    public interface C1348a {
        /* renamed from: a */
        void m4946a();
    }

    /* compiled from: ShareDialog */
    /* renamed from: com.baidu.carlife.custom.elhyf.a.b$b */
    public interface C1349b {
        /* renamed from: a */
        void mo1545a();
    }

    /* compiled from: ShareDialog */
    /* renamed from: com.baidu.carlife.custom.elhyf.a.b$c */
    public interface C1350c {
        /* renamed from: a */
        void mo1546a();
    }

    public C1351b(Context context) {
        super(context);
        this.f3947e = context;
    }

    /* renamed from: a */
    protected View mo1528a() {
        return View.inflate(getContext(), C0965R.layout.share_dialog, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f3948f = (TextView) findViewById(C0965R.id.btn_cancel);
        this.f3949g = (RelativeLayout) findViewById(C0965R.id.layout_friend);
        this.f3950h = (RelativeLayout) findViewById(C0965R.id.layout_moments);
        this.f3949g.setOnClickListener(new C13451(this));
        this.f3950h.setOnClickListener(new C13462(this));
        this.f3948f.setOnClickListener(new C13473(this));
    }

    /* renamed from: f */
    public void mo1530f() {
    }

    /* renamed from: a */
    public C1351b m4953a(C1348a listener) {
        this.f3951i = listener;
        return this;
    }

    /* renamed from: a */
    public C1351b m4954a(C1349b listener) {
        this.f3952j = listener;
        return this;
    }

    /* renamed from: a */
    public C1351b m4955a(C1350c listener) {
        this.f3953k = listener;
        return this;
    }
}
