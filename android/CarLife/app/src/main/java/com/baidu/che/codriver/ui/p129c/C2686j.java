package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p127a.C2650b.C2649c;

/* compiled from: NormalAskItem */
/* renamed from: com.baidu.che.codriver.ui.c.j */
public class C2686j extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_NORMAL_ASK;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.item_conversation_right, null);
        C2649c askTextHolder = new C2649c();
        askTextHolder.f8713a = (TextView) convertView.findViewById(C0965R.id.conversation_right_text);
        convertView.setTag(askTextHolder);
        return convertView;
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        ((C2649c) convertView.getTag()).f8713a.setText(m10072b().f8465g);
    }
}
