package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.vr.p130a.C2766g;
import com.baidu.che.codriver.widget.C2883c;
import com.baidu.che.codriver.widget.SwitchPageLayout;

/* compiled from: SearchPicItem */
/* renamed from: com.baidu.che.codriver.ui.c.o */
public class C2691o extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_IMAGE_SEARCH;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.switch_page_layout, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        SwitchPageLayout imageSearchPage = (SwitchPageLayout) convertView;
        C2766g mModel = (C2766g) m10072b();
        C2883c mAdapter = new C2883c(convertView.getContext());
        mAdapter.m10923a(mModel);
        imageSearchPage.setAdapter(mAdapter);
        imageSearchPage.setTitle(mModel.g);
    }
}
