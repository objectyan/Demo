package com.baidu.che.codriver.ui.p127a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.ui.p124d.C2708j;
import com.baidu.che.codriver.vr.p130a.C2784s;
import com.baidu.che.codriver.widget.CompoundRelativeLayout;
import java.util.List;

/* compiled from: RouteAdapter */
/* renamed from: com.baidu.che.codriver.ui.a.g */
public class C2659g extends C2645a implements C2651h {
    /* renamed from: b */
    public static final int f8741b = 3;
    /* renamed from: c */
    private LayoutInflater f8742c;
    /* renamed from: d */
    private List<Result> f8743d;
    /* renamed from: e */
    private C2784s f8744e;
    /* renamed from: f */
    private C2708j f8745f;
    /* renamed from: g */
    private Context f8746g;

    public C2659g(Context mContext, C2784s mItemClickListener) {
        this.f8746g = mContext;
        this.f8744e = mItemClickListener;
        this.f8742c = LayoutInflater.from(mContext);
    }

    /* renamed from: a */
    public int mo1919a() {
        return (int) Math.ceil((double) (((float) this.f8743d.size()) / 3.0f));
    }

    /* renamed from: a */
    public View mo1920a(int position) {
        LinearLayout ll = new LinearLayout(this.f8746g);
        ll.setOrientation(1);
        ll.setLayoutParams(new LayoutParams(-1, -2, 0.0f));
        for (int i = 0; i < 3; i++) {
            View view = this.f8742c.inflate(C0965R.layout.route_layout_item, null);
            final int index = (position * 3) + i;
            TextView title = (TextView) view.findViewById(C0965R.id.route_layout_item_title);
            TextView content = (TextView) view.findViewById(C0965R.id.route_layout_item_subtitle);
            TextView distance = (TextView) view.findViewById(C0965R.id.route_layout_item_distance);
            View line = view.findViewById(C0965R.id.route_layout_item_line);
            if (index < this.f8743d.size()) {
                title.setText((index + 1) + ". " + ((Result) this.f8743d.get(index)).name);
                content.setText(((Result) this.f8743d.get(index)).address);
                distance.setText(this.f8742c.getContext().getResources().getString(C0965R.string.route_command_distance, new Object[]{((Result) this.f8743d.get(index)).distance + ""}));
                view.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2659g f8740b;

                    public void onClick(View paramView) {
                        if (this.f8740b.f8744e != null) {
                            this.f8740b.f8744e.mo1975a((Result) this.f8740b.f8743d.get(index));
                        }
                    }
                });
                super.m9912a(ll, (CompoundRelativeLayout) view, index);
            } else if (i > 0) {
                super.m9912a(ll, (CompoundRelativeLayout) view, index);
            }
            if (mo1919a() == 1) {
                ((RelativeLayout.LayoutParams) line.getLayoutParams()).rightMargin = 0;
            }
            if (i == 2) {
                line.setVisibility(4);
            } else {
                line.setVisibility(0);
            }
        }
        return ll;
    }

    /* renamed from: a */
    public void m9948a(C2708j data) {
        this.f8745f = data;
        this.f8743d = data.m10131a();
    }

    /* renamed from: b */
    public void mo1922b(int position) {
        this.f8745f.f8879l = position;
    }

    /* renamed from: b */
    public int mo1921b() {
        return this.f8745f.f8879l;
    }
}
