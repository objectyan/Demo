package com.baidu.carlife.logic.p082b.p089a;

import com.baidu.carlife.R;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.logic.p082b.p090b.C1717a;
import com.baidu.carlife.logic.p082b.p090b.C1717a.C1716a;
import com.baidu.carlife.p059c.p062b.C1100a;
import com.baidu.carlife.p059c.p064d.C1115c;
import com.baidu.carlife.p059c.p067g.C1145a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HomeHelpSource */
/* renamed from: com.baidu.carlife.logic.b.a.a */
public class C1713a extends C1100a<C1717a> {
    /* renamed from: c */
    public List<C1717a> mo1620c() {
        List<C1717a> helpItems = new ArrayList();
        for (String title : AppContext.m3876a().getResources().getStringArray(R.array.home_help_items)) {
            helpItems.add(C1145a.m3846a(m6262a(title), "SettingItem should not be null!"));
        }
        return helpItems;
    }

    /* renamed from: a */
    private C1717a m6262a(String content) {
        C1115c<String> title = new C1115c();
        title.mo1419b(content);
        C1115c<Integer> layoutId = new C1115c();
        layoutId.mo1419b(Integer.valueOf(R.layout.item_setting_single_text));
        return C1716a.m6266a().m6267a(layoutId).m6270c(title).m6273e(C1145a.m3845a(Boolean.valueOf(false))).m6271c();
    }
}
