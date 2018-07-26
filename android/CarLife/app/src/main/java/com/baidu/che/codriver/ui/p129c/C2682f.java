package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2699f;
import com.baidu.che.codriver.ui.p127a.C2653d;
import com.baidu.che.codriver.widget.SwitchPageLayout;

/* compiled from: MusicListItem */
/* renamed from: com.baidu.che.codriver.ui.c.f */
public class C2682f extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_MUSIC_LIST;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.switch_page_layout, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        SwitchPageLayout musicListLayout = (SwitchPageLayout) convertView;
        C2653d musicListAdapter = new C2653d(convertView.getContext());
        musicListAdapter.m9928a((C2699f) m10072b());
        musicListLayout.setAdapter(musicListAdapter);
        musicListLayout.setTitle(m10072b().f8465g);
    }
}
