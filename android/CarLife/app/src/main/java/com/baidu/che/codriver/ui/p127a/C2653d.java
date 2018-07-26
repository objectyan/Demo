package com.baidu.che.codriver.ui.p127a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.p117c.C2523a;
import com.baidu.che.codriver.ui.p124d.C2699f;

/* compiled from: MusicListAdapter */
/* renamed from: com.baidu.che.codriver.ui.a.d */
public class C2653d implements C2651h {
    /* renamed from: a */
    public static final int f8721a = 3;
    /* renamed from: b */
    private C2699f f8722b;
    /* renamed from: c */
    private Context f8723c;

    public C2653d(Context mContext) {
        this.f8723c = mContext;
    }

    /* renamed from: a */
    public void m9928a(C2699f data) {
        this.f8722b = data;
    }

    /* renamed from: a */
    public int mo1919a() {
        return (int) Math.ceil((double) (((float) this.f8722b.m10119a().size()) / 3.0f));
    }

    /* renamed from: a */
    public View mo1920a(int position) {
        LinearLayout ll = new LinearLayout(this.f8723c);
        ll.setOrientation(1);
        LayoutParams lp = new LayoutParams(-1, -2, 0.0f);
        ll.setLayoutParams(lp);
        for (int i = 0; i < 3; i++) {
            View view = LayoutInflater.from(this.f8723c).inflate(C0965R.layout.music_list_item, null);
            int index = (position * 3) + i;
            if (index < this.f8722b.m10119a().size()) {
                C2523a bean = (C2523a) this.f8722b.m10119a().get(index);
                TextView nameTextView = (TextView) view.findViewById(C0965R.id.text_name);
                TextView infoTextView = (TextView) view.findViewById(C0965R.id.text_info);
                nameTextView.setText((index + 1) + ". " + bean.f8255e);
                infoTextView.setText(bean.f8259i + " <" + bean.f8256f + ">");
            }
            view.setLayoutParams(lp);
            ll.addView(view);
            View line = new View(this.f8723c);
            line.setBackgroundColor(this.f8723c.getResources().getColor(C0965R.color.twenty_percent_white));
            line.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
            ll.addView(line);
        }
        return ll;
    }

    /* renamed from: b */
    public void mo1922b(int position) {
        this.f8722b.f8835a = position;
    }

    /* renamed from: b */
    public int mo1921b() {
        return this.f8722b.f8835a;
    }
}
