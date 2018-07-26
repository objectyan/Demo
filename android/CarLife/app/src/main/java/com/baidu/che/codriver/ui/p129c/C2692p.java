package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.widget.StockCardView;

/* compiled from: StockItem */
/* renamed from: com.baidu.che.codriver.ui.c.p */
public class C2692p extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_NLP_STOCK;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.stock_card_item, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        ((StockCardView) convertView).m10907a(m10072b());
    }
}
