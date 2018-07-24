package com.baidu.carlife.fragment;

import com.baidu.carlife.R;
import com.baidu.carlife.logic.p082b.p089a.C1714b;
import com.baidu.carlife.logic.p082b.p090b.C1717a;
import com.baidu.carlife.logic.p082b.p091c.p093b.C1741b;
import com.baidu.carlife.p059c.p062b.C1100a;
import com.baidu.carlife.p059c.p066e.C1135b;

public class MapSettingFragment extends BaseSettingFragment<C1717a> {
    /* renamed from: a */
    protected String mo1568a() {
        return getStringUtil(R.string.carlife_person_ctrl_map_setting);
    }

    /* renamed from: b */
    protected C1100a<C1717a> mo1569b() {
        return new C1714b();
    }

    /* renamed from: c */
    protected C1135b<C1717a> mo1570c() {
        return new C1741b();
    }

    public void onResume() {
        super.onResume();
        setBottomBarStatus(true);
    }
}
