package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.R;

/* compiled from: CustomCenterListAdapter */
/* renamed from: com.baidu.carlife.adpter.b */
public class CustomCenterListAdapter extends BaseAdapter {
    /* renamed from: a */
    private String[] f2457a = this.f2458b.getResources().getStringArray(R.array.custom_info_list);
    /* renamed from: b */
    private Context f2458b;

    /* compiled from: CustomCenterListAdapter */
    /* renamed from: com.baidu.carlife.adpter.b$a */
    private static class C0973a {
        /* renamed from: a */
        TextView f2456a;

        private C0973a() {
        }
    }

    public CustomCenterListAdapter(Context context) {
        this.f2458b = context;
    }

    public int getCount() {
        return this.f2457a.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f2458b).inflate(R.layout.custom_center_list_item, null);
            C0973a viewCache = new C0973a();
            viewCache.f2456a = (TextView) convertView.findViewById(R.id.tv_item_name);
            convertView.setTag(viewCache);
        }
        ((C0973a) convertView.getTag()).f2456a.setText(this.f2457a[position]);
        return convertView;
    }
}
