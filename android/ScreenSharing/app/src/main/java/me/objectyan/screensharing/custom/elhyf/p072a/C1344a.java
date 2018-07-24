package com.baidu.carlife.custom.elhyf.p072a;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.view.dialog.BaseDialog;

/* compiled from: CMProgressDialog */
/* renamed from: com.baidu.carlife.custom.elhyf.a.a */
public class C1344a extends BaseDialog {
    /* renamed from: e */
    TextView f3942e;
    /* renamed from: f */
    ProgressBar f3943f;

    public C1344a(Context context) {
        super(context);
    }

    public void setTitle(String title) {
        this.f3942e.setText(title);
    }

    public void setProgress(int progress) {
        this.f3943f.setProgress(progress);
    }

    /* renamed from: a */
    protected View mo1528a() {
        return View.inflate(getContext(), R.layout.yf_common_progress_dialog, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f3942e = (TextView) findViewById(R.id.dialog_title);
        this.f3943f = (ProgressBar) findViewById(R.id.progress_bar);
        setCanceledOnTouchOutside(false);
    }

    /* renamed from: f */
    public void mo1530f() {
    }
}
