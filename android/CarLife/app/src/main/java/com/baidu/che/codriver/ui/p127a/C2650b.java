package com.baidu.che.codriver.ui.p127a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p129c.C2676b;
import com.baidu.che.codriver.widget.C2880e;
import com.baidu.che.codriver.widget.C2886d;
import com.baidu.che.codriver.widget.SwitchPageLayout;
import com.baidu.sapi2.SapiWebView;
import java.util.List;

/* compiled from: ConversationAdapter */
/* renamed from: com.baidu.che.codriver.ui.a.b */
public class C2650b extends BaseAdapter {
    /* renamed from: a */
    private static final String f8714a = "ConversationAdapter";
    /* renamed from: b */
    private List<C2549b> f8715b;
    /* renamed from: c */
    private C2880e f8716c = C2886d.m10926a();
    /* renamed from: d */
    private int f8717d;

    /* compiled from: ConversationAdapter */
    /* renamed from: com.baidu.che.codriver.ui.a.b$d */
    public static class C2646d {
    }

    /* compiled from: ConversationAdapter */
    /* renamed from: com.baidu.che.codriver.ui.a.b$a */
    public static class C2647a extends C2646d {
        /* renamed from: a */
        TextView f8704a;
        /* renamed from: b */
        TextView f8705b;
        /* renamed from: c */
        TextView f8706c;
        /* renamed from: d */
        TextView f8707d;
        /* renamed from: e */
        TextView f8708e;
        /* renamed from: f */
        NetworkImageView f8709f;
    }

    /* compiled from: ConversationAdapter */
    /* renamed from: com.baidu.che.codriver.ui.a.b$b */
    public static class C2648b extends C2646d {
        /* renamed from: a */
        public TextView f8710a;
        /* renamed from: b */
        public SapiWebView f8711b;
        /* renamed from: c */
        public ImageView f8712c;
    }

    /* compiled from: ConversationAdapter */
    /* renamed from: com.baidu.che.codriver.ui.a.b$c */
    public static class C2649c extends C2646d {
        /* renamed from: a */
        public TextView f8713a;
    }

    public C2650b(Context context, List<C2549b> list) {
        this.f8715b = list;
    }

    public int getCount() {
        if (this.f8715b != null) {
            return this.f8715b.size();
        }
        return 0;
    }

    public Object getItem(int position) {
        if (this.f8715b != null) {
            return this.f8715b.get(position);
        }
        return null;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public int getItemViewType(int position) {
        if (this.f8715b != null) {
            return ((C2549b) this.f8715b.get(position)).f8464f.ordinal();
        }
        return 0;
    }

    public int getViewTypeCount() {
        return C2695a.values().length;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C2549b model = (C2549b) getItem(position);
        C2676b conversationItem = C2676b.m10066a(((C2549b) this.f8715b.get(position)).f8464f);
        conversationItem.m10070a(model);
        View itemView = conversationItem.m10067a(parent, convertView);
        if (itemView instanceof SwitchPageLayout) {
            m9915a((SwitchPageLayout) itemView);
            m9914a(position);
        }
        return itemView;
    }

    /* renamed from: a */
    public C2880e m9913a() {
        return this.f8716c;
    }

    /* renamed from: b */
    public int m9916b() {
        return this.f8717d;
    }

    /* renamed from: a */
    public void m9914a(int lastSwitchAblePagePosition) {
        this.f8717d = lastSwitchAblePagePosition;
    }

    /* renamed from: a */
    public void m9915a(C2880e switchablePage) {
        this.f8716c = switchablePage;
    }
}
