package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.widget.NLPWeatherView;

/* compiled from: NlpWeatherItem */
/* renamed from: com.baidu.che.codriver.ui.c.i */
public class C2685i extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_NLP_WEATHER;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.item_conversation_nlp_weathwer, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        ((NLPWeatherView) convertView).m10905a(m10072b());
    }
}
