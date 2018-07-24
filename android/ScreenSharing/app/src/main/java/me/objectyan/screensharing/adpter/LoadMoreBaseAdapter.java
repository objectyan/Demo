package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.R;

/* compiled from: LoadMoreBaseAdapter */
/* renamed from: com.baidu.carlife.adpter.h */
public abstract class LoadMoreBaseAdapter extends BaseAdapter {
    /* renamed from: a */
    public static final int f2511a = 0;
    /* renamed from: b */
    public static final int f2512b = 1;
    /* renamed from: c */
    public static final int f2513c = 2;
    /* renamed from: d */
    public static final int f2514d = 0;
    /* renamed from: e */
    public static final int f2515e = 1;
    /* renamed from: f */
    protected View f2516f;
    /* renamed from: g */
    protected Context f2517g;
    /* renamed from: h */
    private TextView f2518h;
    /* renamed from: i */
    private View f2519i;
    /* renamed from: j */
    private int f2520j = 0;
    /* renamed from: k */
    private boolean f2521k = false;
    /* renamed from: l */
    private C0985a f2522l;

    /* compiled from: LoadMoreBaseAdapter */
    /* renamed from: com.baidu.carlife.adpter.h$a */
    public interface C0985a {
        /* renamed from: a */
        void mo1591a();
    }

    /* renamed from: a */
    public abstract View mo1362a(int i, View view, ViewGroup viewGroup);

    /* renamed from: d */
    public abstract int mo1363d();

    /* renamed from: a */
    public int m3196a() {
        return this.f2520j;
    }

    public LoadMoreBaseAdapter(Context context) {
        this.f2517g = context;
        this.f2516f = LayoutInflater.from(this.f2517g).inflate(R.layout.listview_load_more, null);
        this.f2518h = (TextView) this.f2516f.findViewById(R.id.btn_load_more);
        this.f2519i = this.f2516f.findViewById(R.id.view_loading);
    }

    public int getCount() {
        if (this.f2521k) {
            return mo1363d() + 1;
        }
        return mo1363d();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case 0:
                return mo1362a(position, convertView, parent);
            case 1:
                return this.f2516f;
            default:
                return convertView;
        }
    }

    public int getItemViewType(int position) {
        if (this.f2521k && position >= getCount() - 1) {
            return 1;
        }
        return 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    /* renamed from: a */
    public void m3198a(int status) {
        this.f2520j = status;
        switch (status) {
            case 0:
                this.f2516f.setVisibility(8);
                this.f2519i.setVisibility(8);
                this.f2518h.setVisibility(8);
                return;
            case 1:
                this.f2516f.setVisibility(0);
                this.f2519i.setVisibility(8);
                this.f2518h.setVisibility(0);
                return;
            case 2:
                this.f2516f.setVisibility(0);
                this.f2519i.setVisibility(0);
                this.f2518h.setVisibility(8);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m3200a(boolean enable) {
        this.f2521k = enable;
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public boolean m3201b() {
        return this.f2521k;
    }

    /* renamed from: a */
    public void m3199a(C0985a loadInterface) {
        this.f2522l = loadInterface;
    }

    /* renamed from: c */
    public void m3202c() {
        if (this.f2522l != null) {
            this.f2522l.mo1591a();
        }
    }
}
