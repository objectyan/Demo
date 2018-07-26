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
import com.baidu.che.codriver.p120e.C2529a;
import com.baidu.che.codriver.ui.p124d.C2707i;
import com.baidu.che.codriver.ui.p124d.C2707i.C2706a;
import com.baidu.che.codriver.widget.CompoundRelativeLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PhoneListAdapter */
/* renamed from: com.baidu.che.codriver.ui.a.f */
public class C2657f extends C2645a implements C2651h {
    /* renamed from: b */
    public static final int f8733b = 3;
    /* renamed from: c */
    private C2707i f8734c;
    /* renamed from: d */
    private List<C2529a> f8735d = new ArrayList();
    /* renamed from: e */
    private Context f8736e;
    /* renamed from: f */
    private C2706a f8737f;
    /* renamed from: g */
    private C2656a f8738g;

    /* compiled from: PhoneListAdapter */
    /* renamed from: com.baidu.che.codriver.ui.a.f$a */
    public interface C2656a {
        /* renamed from: a */
        void mo1963a(int i, C2529a c2529a, C2706a c2706a);
    }

    public C2657f(Context context, C2707i model) {
        this.f8736e = context;
        this.f8736e = context;
        this.f8734c = model;
        this.f8738g = model.m10130d();
        this.f8737f = model.m10125a();
        if (model.m10128b() != null) {
            this.f8735d.addAll(model.m10128b());
        }
    }

    /* renamed from: a */
    public int mo1919a() {
        return (int) Math.ceil((double) (((float) this.f8735d.size()) / 3.0f));
    }

    /* renamed from: a */
    public View mo1920a(int position) {
        LinearLayout ll = new LinearLayout(this.f8736e);
        if (this.f8737f == C2706a.TYPE_NUM_CONFIRM) {
            ll = (LinearLayout) LayoutInflater.from(this.f8736e).inflate(C0965R.layout.phone_confirm, null);
            TextView numText = (TextView) ll.findViewById(C0965R.id.phone_num);
            if (this.f8735d.size() > 0) {
                numText.setText(((C2529a) this.f8735d.get(0)).m9593b());
            }
        } else {
            ll.setOrientation(1);
            ll.setLayoutParams(new LayoutParams(-1, -2, 0.0f));
            for (int i = 0; i < 3; i++) {
                final int index = (position * 3) + i;
                RelativeLayout ll_item = (RelativeLayout) LayoutInflater.from(this.f8736e).inflate(C0965R.layout.phone_result_list_item, null);
                TextView textView = (TextView) ll_item.findViewById(C0965R.id.tv_result);
                View line = ll_item.findViewById(C0965R.id.route_layout_item_line);
                if (index < this.f8735d.size()) {
                    String nameOrNum;
                    final C2529a itemData = (C2529a) this.f8735d.get(index);
                    if (this.f8737f == C2706a.TYPE_CONTACT_NAME) {
                        nameOrNum = itemData.m9591a();
                    } else {
                        nameOrNum = itemData.m9593b();
                    }
                    textView.setText(String.valueOf(index + 1) + ". " + nameOrNum);
                    textView.setOnClickListener(new OnClickListener(this) {
                        /* renamed from: c */
                        final /* synthetic */ C2657f f8732c;

                        public void onClick(View v) {
                            if (this.f8732c.f8738g != null) {
                                this.f8732c.f8738g.mo1963a(index, itemData, this.f8732c.f8737f);
                            }
                        }
                    });
                    super.m9912a(ll, (CompoundRelativeLayout) ll_item, index);
                } else if (i > 0) {
                    super.m9912a(ll, (CompoundRelativeLayout) ll_item, index);
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
        }
        return ll;
    }

    /* renamed from: b */
    public void mo1922b(int position) {
        this.f8734c.m10126a(position);
    }

    /* renamed from: b */
    public int mo1921b() {
        return this.f8734c.m10129c();
    }
}
