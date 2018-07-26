package com.baidu.che.codriver.ui.p129c;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2698e;
import com.baidu.che.codriver.ui.p127a.C2652c;
import com.baidu.che.codriver.widget.SwitchPageLayout;

/* compiled from: NlpMultiMovieItem */
/* renamed from: com.baidu.che.codriver.ui.c.h */
public class C2684h extends C2676b {
    /* renamed from: a */
    C2695a mo1948a() {
        return C2695a.TYPE_NLP_MULTIMOVIE;
    }

    /* renamed from: b */
    View mo1950b(View parent) {
        return LayoutInflater.from(parent.getContext()).inflate(C0965R.layout.switch_page_layout, null);
    }

    /* renamed from: a */
    void mo1949a(View convertView) {
        SwitchPageLayout multiMovieLayout = (SwitchPageLayout) convertView;
        C2652c adapter = new C2652c(convertView.getContext());
        CinemaData cinemaData = ((C2698e) m10072b()).f8834a;
        adapter.m9923a(cinemaData);
        multiMovieLayout.setAdapter(adapter);
        if (cinemaData.list.size() > 3) {
            multiMovieLayout.setTitle(convertView.getContext().getString(C0965R.string.multi_movie_title, new Object[]{Integer.valueOf(cinemaData.list.size())}));
            return;
        }
        multiMovieLayout.setTitle(convertView.getContext().getString(C0965R.string.get_these_results));
    }
}
