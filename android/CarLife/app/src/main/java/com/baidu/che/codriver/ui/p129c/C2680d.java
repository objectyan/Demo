package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.widget.CardMovieView;

/* compiled from: MovieItem */
/* renamed from: com.baidu.che.codriver.ui.c.d */
public class C2680d extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_CARD_MOVIE;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.item_conversation_card_movie, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        ((CardMovieView) convertView).m10846a(m10072b());
    }
}
