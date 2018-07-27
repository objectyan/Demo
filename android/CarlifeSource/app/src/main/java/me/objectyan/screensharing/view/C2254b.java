package com.baidu.carlife.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.R;
import java.util.List;

/* compiled from: KeyboardResultAdapter */
/* renamed from: com.baidu.carlife.view.b */
public class C2254b extends BaseAdapter {
    /* renamed from: a */
    private LayoutInflater f7362a;
    /* renamed from: b */
    private List<String> f7363b;

    /* compiled from: KeyboardResultAdapter */
    /* renamed from: com.baidu.carlife.view.b$a */
    static class C2253a {
        /* renamed from: a */
        TextView f7361a;

        C2253a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m8568a(i);
    }

    public C2254b(Context context) {
        this.f7362a = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void m8569a(List<String> list) {
        this.f7363b = list;
    }

    public int getCount() {
        if (this.f7363b == null) {
            return 0;
        }
        return this.f7363b.size();
    }

    /* renamed from: a */
    public String m8568a(int position) {
        if (this.f7363b == null) {
            return null;
        }
        return (String) this.f7363b.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.f7362a.inflate(R.layout.keyboard_result_item, parent, false);
            convertView.setFocusable(true);
        }
        TextView textview = (TextView) convertView;
        String text = m8568a(position);
        if (!TextUtils.isEmpty(text)) {
            textview.setText(text);
        }
        return textview;
    }
}
