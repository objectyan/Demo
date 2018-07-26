package com.baidu.che.codriver.ui.p127a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData;
import com.baidu.che.codriver.protocol.data.nlp.CinemaData.CinemaBean;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.widget.CinemaBillView;
import com.baidu.che.codriver.widget.CinemaBillView.C2866a;

/* compiled from: MultiMovieAdapter */
/* renamed from: com.baidu.che.codriver.ui.a.c */
public class C2652c implements C2651h {
    /* renamed from: a */
    public static final int f8718a = 3;
    /* renamed from: b */
    private CinemaData f8719b;
    /* renamed from: c */
    private Context f8720c;

    public C2652c(Context mContext) {
        this.f8720c = mContext;
    }

    /* renamed from: a */
    public void m9923a(CinemaData data) {
        this.f8719b = data;
    }

    /* renamed from: a */
    public int mo1919a() {
        return (int) Math.ceil((double) (((float) this.f8719b.list.size()) / 3.0f));
    }

    /* renamed from: a */
    public View mo1920a(int position) {
        int count;
        int i;
        if (position == mo1919a() - 1) {
            count = this.f8719b.list.size() - (position * 3);
        } else {
            count = 3;
        }
        LinearLayout ll = new LinearLayout(this.f8720c);
        ll.setOrientation(0);
        LayoutParams lp = new LayoutParams(-1, -2, 0.0f);
        ll.setLayoutParams(lp);
        for (i = 0; i < count; i++) {
            CinemaBillView cbv = new CinemaBillView(this.f8720c);
            lp = new LayoutParams(0, -2, 1.0f);
            lp.setMargins(0, C2716c.m10140a(this.f8720c, 15.0f), 0, 0);
            cbv.setLayoutParams(lp);
            CinemaBean bean = (CinemaBean) this.f8719b.list.get((position * 3) + i);
            C2866a viewHolder = (C2866a) cbv.getTag(C0965R.string.key_cinema_holder);
            if (viewHolder != null) {
                viewHolder.m10848a(bean.name);
                viewHolder.m10849b(bean.score);
                viewHolder.m10850c(bean.post);
            }
            ll.addView(cbv);
        }
        int emptyCount = 3 - count;
        if (emptyCount > 0) {
            for (i = 0; i < emptyCount; i++) {
                View emptyView = new View(this.f8720c);
                emptyView.setLayoutParams(lp);
                ll.addView(emptyView);
            }
        }
        ll.setBackgroundColor(Color.parseColor("#0FFFFFFF"));
        return ll;
    }

    /* renamed from: b */
    public void mo1922b(int position) {
        this.f8719b.curPage = position;
    }

    /* renamed from: b */
    public int mo1921b() {
        return this.f8719b.curPage;
    }
}
