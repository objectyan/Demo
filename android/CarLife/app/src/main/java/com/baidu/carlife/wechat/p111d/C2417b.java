package com.baidu.carlife.wechat.p111d;

import com.baidu.carlife.C0965R;

/* compiled from: MenuItem */
/* renamed from: com.baidu.carlife.wechat.d.b */
public enum C2417b {
    Session("最近会话", C0965R.mipmap.wx_ic_session),
    Contact("微信好友", C0965R.mipmap.wx_ic_contacts),
    Mute("微信静音", C0965R.mipmap.wx_ic_mute_off),
    Setting("微信设置", C0965R.mipmap.wx_ic_setting);
    
    /* renamed from: e */
    private String f7969e;
    /* renamed from: f */
    private int f7970f;

    private C2417b(String title, int iconId) {
        this.f7969e = title;
        this.f7970f = iconId;
    }

    /* renamed from: a */
    public String m9249a() {
        return this.f7969e;
    }

    /* renamed from: b */
    public int m9250b() {
        return this.f7970f;
    }
}
