package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2708j;
import com.baidu.che.codriver.ui.p127a.C2659g;
import com.baidu.che.codriver.widget.SwitchPageLayout;

/* compiled from: RouteItem */
/* renamed from: com.baidu.che.codriver.ui.c.n */
public class C2690n extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_ROUTE;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.switch_page_layout, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        SwitchPageLayout routeLayout = (SwitchPageLayout) convertView;
        C2708j routeModel = (C2708j) m10072b();
        C2659g routeAdapter = new C2659g(convertView.getContext(), routeModel.m10132b());
        routeAdapter.m9948a(routeModel);
        routeLayout.setAdapter(routeAdapter);
        routeLayout.setTitle(routeModel.g);
    }
}
