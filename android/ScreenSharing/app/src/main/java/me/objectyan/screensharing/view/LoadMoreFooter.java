package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.R;

public class LoadMoreFooter extends RelativeLayout {
    /* renamed from: a */
    public static final int f7182a = 0;
    /* renamed from: b */
    public static final int f7183b = 1;
    /* renamed from: c */
    public static final int f7184c = 2;
    /* renamed from: d */
    private TextView f7185d;
    /* renamed from: e */
    private View f7186e;
    /* renamed from: f */
    private int f7187f;

    public LoadMoreFooter(Context context) {
        this(context, null, 0);
    }

    public LoadMoreFooter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadMoreFooter(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7187f = 0;
        m8457a(context);
    }

    /* renamed from: a */
    private void m8457a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.load_more_footer, this, true);
        this.f7185d = (TextView) findViewById(R.id.btn_load_more);
        this.f7186e = findViewById(R.id.view_loading);
        setVisibility(8);
    }

    public void setStatus(int status) {
        this.f7187f = status;
        switch (status) {
            case 0:
                setVisibility(8);
                this.f7186e.setVisibility(8);
                this.f7185d.setVisibility(8);
                return;
            case 1:
                setVisibility(0);
                this.f7186e.setVisibility(8);
                this.f7185d.setVisibility(0);
                return;
            case 2:
                setVisibility(0);
                this.f7186e.setVisibility(0);
                this.f7185d.setVisibility(8);
                return;
            default:
                return;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        switch (this.f7187f) {
            case 0:
                setVisibility(8);
                this.f7186e.setVisibility(8);
                this.f7185d.setVisibility(8);
                return;
            default:
                this.f7187f = 1;
                setVisibility(0);
                this.f7186e.setVisibility(8);
                this.f7185d.setVisibility(0);
                return;
        }
    }

    /* renamed from: a */
    public boolean m8458a() {
        if (this.f7187f == 2) {
            return false;
        }
        setStatus(2);
        return true;
    }

    /* renamed from: b */
    public void m8459b() {
        if (this.f7187f != 1) {
            setStatus(1);
        }
    }

    public void setTextContent(String str) {
        this.f7185d.setText(str);
    }
}
