package com.baidu.carlife.logic.p082b.p089a;

import com.baidu.carlife.R;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.logic.p082b.p090b.C1717a;
import com.baidu.carlife.logic.p082b.p090b.C1717a.C1716a;
import com.baidu.carlife.p059c.p062b.C1100a;
import com.baidu.carlife.p059c.p067g.C1145a;
import com.baidu.carlife.util.C2186p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MapSettingSource */
/* renamed from: com.baidu.carlife.logic.b.a.b */
public class C1714b extends C1100a<C1717a> {
    /* renamed from: c */
    public List<C1717a> mo1620c() {
        List<C1717a> mapSettingItem = new ArrayList();
        mapSettingItem.add(C1145a.m3846a(C1716a.m6266a().m6270c(C1145a.m3845a(AppContext.m3876a().getString(R.string.map_setting_offline_map))).m6273e(C1145a.m3845a(Boolean.valueOf(C2186p.m8304a().m8312a(CommonParams.jC, true)))).m6269b(C1145a.m3845a(AppContext.m3876a().getString(R.string.map_setting_description_offline_map))).m6267a(C1145a.m3845a(Integer.valueOf(R.layout.item_map_setting_with_description))).m6271c(), "SettingItem should not be null!"));
        mapSettingItem.add(C1145a.m3846a(C1716a.m6266a().m6270c(C1145a.m3845a(AppContext.m3876a().getString(R.string.map_setting_offline_route))).m6273e(C1145a.m3845a(Boolean.valueOf(false))).m6269b(C1145a.m3844a((int) R.string.map_setting_description_offline_route)).m6267a(C1145a.m3845a(Integer.valueOf(R.layout.item_map_setting_with_description))).m6271c(), "SettingItem should not be null!"));
        mapSettingItem.add(C1145a.m3846a(C1716a.m6266a().m6270c(C1145a.m3844a((int) R.string.map_setting_route_setting)).m6273e(C1145a.m3845a(Boolean.valueOf(C2186p.m8304a().m8312a(CommonParams.jD, true)))).m6267a(C1145a.m3845a(Integer.valueOf(R.layout.item_setting_single_text))).m6271c(), "SettingItem should not be null!"));
        return mapSettingItem;
    }
}
