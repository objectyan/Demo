package com.baidu.che.codriver.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p127a.C2651h;
import com.baidu.che.codriver.util.C2714a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.ImageSearchData.ImageDetail;
import com.baidu.che.codriver.vr.p130a.C2766g;

/* compiled from: ImageSearchAdapter */
/* renamed from: com.baidu.che.codriver.widget.c */
public class C2883c implements OnClickListener, C2651h {
    /* renamed from: a */
    private int f9510a = 1;
    /* renamed from: b */
    private C2766g f9511b;
    /* renamed from: c */
    private int f9512c = 0;
    /* renamed from: d */
    private Context f9513d;

    public C2883c(Context context) {
        this.f9513d = context;
    }

    /* renamed from: a */
    public void m10923a(C2766g data) {
        this.f9511b = data;
    }

    public void onClick(View view) {
    }

    /* renamed from: a */
    public int mo1919a() {
        return (int) Math.ceil((double) (((float) this.f9511b.f9081a.list.size()) / ((float) this.f9510a)));
    }

    /* renamed from: a */
    public View mo1920a(int position) {
        ViewGroup convertView = (ViewGroup) LayoutInflater.from(this.f9513d).inflate(C0965R.layout.item_imagesearch, null);
        ((NetworkImageView) convertView.findViewById(C0965R.id.imageView)).setImageUrl(((ImageDetail) this.f9511b.f9081a.list.get(position)).bigImage, C2714a.m10135a());
        C2725h.m10210c("sanba", "imagesearchurl:" + ((ImageDetail) this.f9511b.f9081a.list.get(position)).smailImage);
        m10920c();
        return convertView;
    }

    /* renamed from: c */
    private void m10920c() {
    }

    /* renamed from: b */
    public void mo1922b(int position) {
        this.f9512c = position;
    }

    /* renamed from: b */
    public int mo1921b() {
        return this.f9512c;
    }
}
