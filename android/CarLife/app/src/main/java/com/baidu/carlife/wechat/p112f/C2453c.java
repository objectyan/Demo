package com.baidu.carlife.wechat.p112f;

import android.text.TextUtils;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.wechat.p108b.C2376b;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p109c.C2415a;
import com.baidu.che.codriver.sdk.p081a.C2452p;
import com.baidu.che.codriver.sdk.p126b.C2617a;
import com.baidu.navi.fragment.NaviFragmentManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WechatToolImpl */
/* renamed from: com.baidu.carlife.wechat.f.c */
public class C2453c implements C2452p {
    /* renamed from: a */
    public List<C2617a> mo1848a(String name) {
        List<C2376b> contacts = C2380c.m9070a().m9081c(name);
        List<C2617a> models = new ArrayList();
        for (C2376b contact : contacts) {
            models.add(new C2617a(contact.m9052a(), contact.m9054b()));
        }
        return models;
    }

    /* renamed from: a */
    public void mo1849a(C2617a model, String content) {
        C2376b contact = C2380c.m9070a().m9078b(model.m9837c());
        C2398k.m9160a().m9179a(true);
        C2415a.m9228a().m9238a(contact, content);
    }

    /* renamed from: a */
    public boolean mo1850a() {
        return !TextUtils.isEmpty(C2380c.m9070a().m9085f().m9135d());
    }

    /* renamed from: b */
    public boolean mo1851b() {
        return C1190a.m4067c();
    }

    /* renamed from: c */
    public void mo1852c() {
        C1328h.m4757a().showFragment(NaviFragmentManager.TYPE_WECHAT_LOGIN, null);
    }
}
