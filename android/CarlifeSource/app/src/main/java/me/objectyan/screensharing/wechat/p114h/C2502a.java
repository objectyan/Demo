package com.baidu.carlife.wechat.p114h;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.wechat.p108b.C2376b;
import com.baidu.carlife.wechat.p110e.C2436c;
import com.baidu.carlife.wechat.p113g.C2499c;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: NewMsgTips */
/* renamed from: com.baidu.carlife.wechat.h.a */
public class C2502a {
    /* renamed from: a */
    private View f8143a;
    /* renamed from: b */
    private SimpleDraweeView f8144b;
    /* renamed from: c */
    private TextView f8145c;
    /* renamed from: d */
    private TextView f8146d;
    /* renamed from: e */
    private Button f8147e;
    /* renamed from: f */
    private Button f8148f;
    /* renamed from: g */
    private C2501a f8149g;

    /* compiled from: NewMsgTips */
    /* renamed from: com.baidu.carlife.wechat.h.a$a */
    public enum C2501a {
        Play,
        Reply,
        Navi
    }

    public C2502a(Context context, ViewGroup parent) {
        this.f8143a = LayoutInflater.from(context).inflate(C0965R.layout.layout_new_msg, parent, false);
        LayoutParams lp = this.f8143a.getLayoutParams();
        lp.width = C2499c.m9489a(context) / 2;
        lp.height = -2;
        m9503e();
    }

    /* renamed from: a */
    public View m9504a() {
        this.f8143a.setVisibility(8);
        return this.f8143a;
    }

    /* renamed from: a */
    public void m9505a(C2376b contact, String content, C2501a type) {
        m9506a(type);
        this.f8143a.setVisibility(0);
        this.f8144b.setImageURI(C2436c.m9320i() + contact.m9060e());
        this.f8145c.setText(Html.fromHtml(contact.m9054b()));
        this.f8146d.setText(Html.fromHtml(content));
    }

    /* renamed from: e */
    private void m9503e() {
        this.f8144b = (SimpleDraweeView) this.f8143a.findViewById(C0965R.id.new_msg_icon);
        this.f8145c = (TextView) this.f8143a.findViewById(C0965R.id.new_msg_name);
        this.f8146d = (TextView) this.f8143a.findViewById(C0965R.id.new_msg_content);
        this.f8147e = (Button) this.f8143a.findViewById(C0965R.id.new_msg_btn_ok);
        this.f8148f = (Button) this.f8143a.findViewById(C0965R.id.new_msg_btn_close);
    }

    /* renamed from: b */
    public Button m9507b() {
        return this.f8148f;
    }

    /* renamed from: c */
    public Button m9508c() {
        return this.f8147e;
    }

    /* renamed from: a */
    public void m9506a(C2501a type) {
        this.f8149g = type;
        switch (type) {
            case Play:
                this.f8147e.setText("播报");
                return;
            case Reply:
                this.f8147e.setText("回复");
                return;
            case Navi:
                this.f8147e.setText("发起导航");
                return;
            default:
                this.f8147e.setText("确定");
                return;
        }
    }

    /* renamed from: d */
    public C2501a m9509d() {
        return this.f8149g;
    }
}
