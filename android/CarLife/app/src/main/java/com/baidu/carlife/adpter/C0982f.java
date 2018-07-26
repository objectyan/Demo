package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.carlife.model.C1934l;
import com.baidu.carlife.view.SkinItemView;
import java.util.List;

/* compiled from: HomeMySkinAdapter */
/* renamed from: com.baidu.carlife.adpter.f */
public class C0982f extends BaseAdapter {
    /* renamed from: a */
    private Context f2500a;
    /* renamed from: b */
    private List<C1934l> f2501b;

    public /* synthetic */ Object getItem(int i) {
        return m3187a(i);
    }

    public C0982f(Context context, List skinList) {
        this.f2501b = skinList;
        this.f2500a = context;
    }

    public int getCount() {
        return this.f2501b.size();
    }

    /* renamed from: a */
    public C1934l m3187a(int position) {
        return (C1934l) this.f2501b.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C1934l model = m3187a(position);
        if (convertView == null) {
            convertView = new SkinItemView(this.f2500a);
        }
        ((SkinItemView) convertView).setData(model);
        return convertView;
    }
}
