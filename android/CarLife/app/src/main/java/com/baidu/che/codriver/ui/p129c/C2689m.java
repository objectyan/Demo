package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2707i;
import com.baidu.che.codriver.ui.p124d.C2707i.C2706a;
import com.baidu.che.codriver.ui.p127a.C2657f;
import com.baidu.che.codriver.widget.SwitchPageLayout;

/* compiled from: PhoneItem */
/* renamed from: com.baidu.che.codriver.ui.c.m */
public class C2689m extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_PHONE;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.switch_page_layout, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        SwitchPageLayout phoneLayout = (SwitchPageLayout) convertView;
        C2707i mPhone = (C2707i) m10072b();
        C2706a mUIType = mPhone.m10125a();
        phoneLayout.setAdapter(new C2657f(convertView.getContext(), mPhone));
        if (mUIType == C2706a.TYPE_NUM_CONFIRM) {
            phoneLayout.setTitle("");
        } else {
            phoneLayout.setTitle(mPhone.g);
        }
    }
}
