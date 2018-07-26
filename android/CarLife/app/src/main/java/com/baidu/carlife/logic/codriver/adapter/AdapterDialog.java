package com.baidu.carlife.logic.codriver.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.view.dialog.BaseDialog;
import com.baidu.carlife.view.dialog.C0770k;

public abstract class AdapterDialog extends BaseDialog {
    /* renamed from: e */
    protected RelativeLayout f5289e;
    /* renamed from: f */
    protected boolean f5290f = false;
    /* renamed from: g */
    private boolean f5291g = false;

    /* renamed from: com.baidu.carlife.logic.codriver.adapter.AdapterDialog$1 */
    class C17481 implements C0770k {
        /* renamed from: a */
        final /* synthetic */ AdapterDialog f5288a;

        C17481(AdapterDialog this$0) {
            this.f5288a = this$0;
        }

        public void onDismiss() {
            this.f5288a.mo1947k();
        }

        public void onShow() {
            this.f5288a.mo1946j();
        }
    }

    protected abstract int getLayoutId();

    public AdapterDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.b.removeMsg(C1253f.hb);
        setDialogShowHideListener(new C17481(this));
    }

    /* renamed from: a */
    protected View mo1528a() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c).inflate(getLayoutId(), null, false);
        this.f5289e = relativeLayout;
        return relativeLayout;
    }

    /* renamed from: i */
    public void mo1630i() {
        if (!this.f5291g) {
            mo1923a(null);
            this.f5291g = true;
        }
        C1309g.m4699a().showDialog(this);
    }

    /* renamed from: d */
    public void mo1526d() {
        if (this.f5290f) {
            super.mo1526d();
            this.f5290f = false;
            return;
        }
        this.f5290f = true;
        C1309g.m4699a().dismissDialog(this);
    }

    /* renamed from: c */
    public void mo1629c() {
        this.f5290f = true;
        mo1526d();
    }

    /* renamed from: a */
    protected void mo1923a(Bundle savedInstanceState) {
    }

    /* renamed from: j */
    protected void mo1946j() {
    }

    /* renamed from: k */
    protected void mo1947k() {
    }

    /* renamed from: l */
    public boolean m6351l() {
        return !m4478h();
    }

    /* renamed from: a */
    protected View m6344a(int id) {
        return this.f5289e.findViewById(id);
    }
}
