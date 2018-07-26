package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1442f;
import com.baidu.carlife.p078f.C1443g;

public class FullScreenNoticeDialog extends BaseDialog {
    /* renamed from: e */
    private TextView f7371e;
    /* renamed from: f */
    private ScrollView f7372f;
    /* renamed from: g */
    private C1443g f7373g;
    /* renamed from: h */
    private C1442f f7374h;

    /* renamed from: com.baidu.carlife.view.dialog.FullScreenNoticeDialog$1 */
    class C22581 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ FullScreenNoticeDialog f7370a;

        C22581(FullScreenNoticeDialog this$0) {
            this.f7370a = this$0;
        }

        public void onClick(View v) {
            this.f7370a.mo1526d();
        }
    }

    public FullScreenNoticeDialog(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FullScreenNoticeDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.c = context;
    }

    public FullScreenNoticeDialog(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(C0965R.layout.frag_fullscreen_notice, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7371e = (TextView) findViewById(C0965R.id.agree_btn);
        this.f7372f = (ScrollView) findViewById(C0965R.id.scroll_view);
        this.f7372f.setOverScrollMode(2);
        this.f7371e.setOnClickListener(new C22581(this));
    }

    /* renamed from: f */
    public void mo1530f() {
        C1440d focusManager = C1440d.m5251a();
        if (this.f7374h == null) {
            this.f7374h = new C1442f(this.f7372f, 4);
        }
        if (this.f7373g == null) {
            this.f7373g = new C1443g(getRootView(), 6);
            this.f7373g.m5300d(this.f7371e);
        }
        focusManager.m5256b(this.f7374h, this.f7373g);
        focusManager.m5268h(this.f7373g);
    }
}
