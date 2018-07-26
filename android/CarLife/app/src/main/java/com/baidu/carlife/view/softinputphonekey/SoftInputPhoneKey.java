package com.baidu.carlife.view.softinputphonekey;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.C2322f;
import com.baidu.carlife.view.p104a.C2251b;

public class SoftInputPhoneKey extends RelativeLayout {
    /* renamed from: a */
    private TextView f7801a;
    /* renamed from: b */
    private TextView f7802b;
    /* renamed from: c */
    private C2322f f7803c;
    /* renamed from: d */
    private String f7804d;

    /* renamed from: com.baidu.carlife.view.softinputphonekey.SoftInputPhoneKey$1 */
    class C23551 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SoftInputPhoneKey f7799a;

        C23551(SoftInputPhoneKey this$0) {
            this.f7799a = this$0;
        }

        public void onClick(View v) {
            if (this.f7799a.f7803c != null) {
                this.f7799a.f7803c.mo1822a(this.f7799a.f7804d);
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.softinputphonekey.SoftInputPhoneKey$2 */
    class C23562 implements OnLongClickListener {
        /* renamed from: a */
        final /* synthetic */ SoftInputPhoneKey f7800a;

        C23562(SoftInputPhoneKey this$0) {
            this.f7800a = this$0;
        }

        public boolean onLongClick(View v) {
            if (this.f7800a.f7803c != null) {
                if (this.f7800a.f7804d.equals("0")) {
                    this.f7800a.f7803c.mo1822a("+");
                } else {
                    this.f7800a.f7803c.mo1822a(this.f7800a.f7804d);
                }
            }
            return true;
        }
    }

    public void setSoftInputKeyListener(C2322f softInputKeyListener) {
        this.f7803c = softInputKeyListener;
    }

    public SoftInputPhoneKey(Context context) {
        this(context, null);
    }

    public SoftInputPhoneKey(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SoftInputPhoneKey(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0965R.layout.soft_input_phone_key, this, true);
        this.f7801a = (TextView) findViewById(C0965R.id.tv_name);
        this.f7802b = (TextView) findViewById(C0965R.id.tv_desc);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, C0965R.C0963p.SoftInputPhoneKey);
            this.f7804d = a.getString(0);
            String desc = a.getString(1);
            a.recycle();
            if (!TextUtils.isEmpty(this.f7804d)) {
                this.f7801a.setText(this.f7804d);
                this.f7801a.setOnClickListener(new C23551(this));
                this.f7801a.setOnLongClickListener(new C23562(this));
                this.f7801a.setBackground(C2251b.m8529c(getContext()));
            }
            if (!TextUtils.isEmpty(desc)) {
                this.f7802b.setText(desc);
            }
        }
    }

    public String getName() {
        return this.f7801a.getText().toString();
    }

    public void setDesc(String desc) {
        if (TextUtils.isEmpty(desc)) {
            this.f7802b.setText("");
        } else {
            this.f7802b.setText(desc);
        }
    }

    public View getFocusView() {
        return this.f7801a;
    }
}
