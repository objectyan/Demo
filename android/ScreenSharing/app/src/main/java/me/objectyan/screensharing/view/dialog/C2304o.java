package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.carlife.R;
import com.baidu.carlife.view.dialog.C2286m.C2302a;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;

@Deprecated
/* compiled from: NaviMessageDialog */
/* renamed from: com.baidu.carlife.view.dialog.o */
public class C2304o extends C2286m {
    /* renamed from: e */
    private TextView f7558e;

    /* renamed from: a */
    public /* synthetic */ C2286m mo1803a(int i) {
        return m8765i(i);
    }

    /* renamed from: a */
    public /* synthetic */ C2286m mo1804a(View view) {
        return m8750c(view);
    }

    /* renamed from: a */
    public /* synthetic */ C2286m mo1805a(C2302a c2302a) {
        return m8751c(c2302a);
    }

    /* renamed from: a */
    public /* synthetic */ C2286m mo1806a(boolean z) {
        return m8752c(z);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1807b(int i) {
        return m8768j(i);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1809b(C2302a c2302a) {
        return m8755d(c2302a);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1810b(String str) {
        return m8761g(str);
    }

    /* renamed from: b */
    public /* synthetic */ C2286m mo1811b(boolean z) {
        return m8756d(z);
    }

    /* renamed from: c */
    public /* synthetic */ C2286m mo1812c(int i) {
        return m8769k(i);
    }

    /* renamed from: c */
    public /* synthetic */ C2286m mo1813c(String str) {
        return m8763h(str);
    }

    /* renamed from: d */
    public /* synthetic */ C2286m mo1814d(int i) {
        return m8771l(i);
    }

    /* renamed from: d */
    public /* synthetic */ C2286m mo1815d(String str) {
        return m8766i(str);
    }

    /* renamed from: e */
    public /* synthetic */ C2286m mo1816e(int i) {
        return m8773m(i);
    }

    /* renamed from: i */
    public /* synthetic */ C2286m mo1630i() {
        return mo1821l();
    }

    /* renamed from: j */
    public /* synthetic */ C2286m mo1820j() {
        return m8772m();
    }

    public C2304o(Context activity) {
        super(activity);
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(R.layout.navi_message_dialog, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7558e = (TextView) findViewById(R.id.text_view);
        this.f7558e.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_string_rg_comment_dialog_title));
    }

    /* renamed from: f */
    public C2304o m8759f(String text) {
        this.f7558e.setText(text, BufferType.SPANNABLE);
        return this;
    }

    /* renamed from: f */
    public C2304o m8758f(int resId) {
        return m8759f(getContext().getString(resId));
    }

    /* renamed from: g */
    public C2304o m8760g(int width) {
        LayoutParams params = (LayoutParams) this.f7558e.getLayoutParams();
        params.width = width;
        this.f7558e.setLayoutParams(params);
        return this;
    }

    /* renamed from: h */
    public C2304o m8762h(int height) {
        LayoutParams params = (LayoutParams) this.f7558e.getLayoutParams();
        params.height = height;
        this.f7558e.setLayoutParams(params);
        return this;
    }

    /* renamed from: g */
    public C2304o m8761g(String text) {
        super.mo1810b(text);
        return this;
    }

    /* renamed from: i */
    public C2304o m8765i(int resId) {
        super.mo1803a(resId);
        return this;
    }

    /* renamed from: h */
    public C2304o m8763h(String text) {
        super.mo1813c(text);
        return this;
    }

    /* renamed from: j */
    public C2304o m8768j(int resId) {
        super.mo1807b(resId);
        return this;
    }

    /* renamed from: i */
    public C2304o m8766i(String text) {
        super.mo1815d(text);
        return this;
    }

    /* renamed from: k */
    public C2304o m8769k(int resId) {
        super.mo1812c(resId);
        return this;
    }

    /* renamed from: c */
    public C2304o m8750c(View content) {
        super.mo1804a(content);
        return this;
    }

    /* renamed from: c */
    public C2304o m8751c(C2302a listener) {
        super.mo1805a(listener);
        return this;
    }

    /* renamed from: d */
    public C2304o m8755d(C2302a listener) {
        super.mo1809b(listener);
        return this;
    }

    /* renamed from: l */
    public C2304o m8771l(int width) {
        super.mo1814d(width);
        return this;
    }

    /* renamed from: m */
    public C2304o m8773m(int height) {
        super.mo1816e(height);
        return this;
    }

    /* renamed from: c */
    public C2304o m8752c(boolean enabled) {
        super.mo1806a(enabled);
        return this;
    }

    /* renamed from: d */
    public C2304o m8756d(boolean enabled) {
        super.mo1811b(enabled);
        return this;
    }

    /* renamed from: l */
    public C2304o mo1821l() {
        super.mo1630i();
        return this;
    }

    /* renamed from: m */
    public C2304o m8772m() {
        super.mo1820j();
        return this;
    }
}
