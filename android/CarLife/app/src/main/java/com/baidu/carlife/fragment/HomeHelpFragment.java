package com.baidu.carlife.fragment;

import android.annotation.SuppressLint;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.p082b.p089a.C1713a;
import com.baidu.carlife.logic.p082b.p090b.C1717a;
import com.baidu.carlife.logic.p082b.p091c.p093b.C1734a;
import com.baidu.carlife.p059c.p062b.C1100a;
import com.baidu.carlife.p059c.p066e.C1135b;

@SuppressLint({"ValidFragment"})
public class HomeHelpFragment extends BaseSettingFragment<C1717a> {
    /* renamed from: a */
    protected String mo1568a() {
        return getString(C0965R.string.carlife_person_ctrl_help);
    }

    /* renamed from: b */
    protected C1100a<C1717a> mo1569b() {
        return new C1713a();
    }

    /* renamed from: c */
    protected C1135b<C1717a> mo1570c() {
        return new C1734a(this);
    }

    public void onResume() {
        super.onResume();
        setBottomBarStatus(true);
    }

    public void driving() {
        C1260i.m4435b("yftech", "HomeHelpFragment driving");
        if (C1343b.m4932a().m4935b()) {
            dismissDialog();
            back();
        }
    }
}
