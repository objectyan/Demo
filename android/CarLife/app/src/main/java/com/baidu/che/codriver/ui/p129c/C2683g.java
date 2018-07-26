package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2705h;
import com.baidu.che.codriver.ui.p127a.C2654e;
import com.baidu.che.codriver.widget.SwitchPageLayout;

/* compiled from: NearByItem */
/* renamed from: com.baidu.che.codriver.ui.c.g */
public class C2683g extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_NEARBY;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.switch_page_layout, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        SwitchPageLayout nearbyLayout = (SwitchPageLayout) convertView;
        C2654e nearbyAdapter = new C2654e(convertView.getContext());
        nearbyAdapter.m9934a((C2705h) m10072b());
        nearbyLayout.setAdapter(nearbyAdapter);
        nearbyLayout.setTitle(m10072b().f8465g);
    }
}
