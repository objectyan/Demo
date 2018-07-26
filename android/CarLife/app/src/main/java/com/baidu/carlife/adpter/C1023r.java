package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;

/* compiled from: SimpleRightDialogAdapter */
/* renamed from: com.baidu.carlife.adpter.r */
public class C1023r extends BaseAdapter {
    /* renamed from: a */
    public static final int f2611a = -1;
    /* renamed from: b */
    private LayoutInflater f2612b;
    /* renamed from: c */
    private String[] f2613c;
    /* renamed from: d */
    private int f2614d = -1;

    /* compiled from: SimpleRightDialogAdapter */
    /* renamed from: com.baidu.carlife.adpter.r$a */
    private class C1022a {
        /* renamed from: a */
        TextView f2608a;
        /* renamed from: b */
        ImageView f2609b;
        /* renamed from: c */
        final /* synthetic */ C1023r f2610c;

        private C1022a(C1023r c1023r) {
            this.f2610c = c1023r;
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m3262b(i);
    }

    public C1023r(Context context, String[] list) {
        this.f2612b = LayoutInflater.from(context);
        this.f2613c = list;
    }

    /* renamed from: a */
    public void m3261a(int selected) {
        this.f2614d = selected;
    }

    public int getCount() {
        if (this.f2613c == null) {
            return 0;
        }
        return this.f2613c.length;
    }

    /* renamed from: b */
    public String m3262b(int position) {
        if (position < 0 || position >= this.f2613c.length) {
            return "";
        }
        return this.f2613c[position];
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C1022a holder;
        if (convertView == null) {
            convertView = this.f2612b.inflate(C0965R.layout.item_simple_dialog, parent, false);
            holder = new C1022a();
            holder.f2608a = (TextView) convertView.findViewById(C0965R.id.textview);
            holder.f2609b = (ImageView) convertView.findViewById(C0965R.id.imageview);
            convertView.setTag(holder);
        }
        holder = (C1022a) convertView.getTag();
        holder.f2608a.setText(m3262b(position));
        if (this.f2614d == position) {
            holder.f2609b.setVisibility(0);
            holder.f2608a.setSelected(true);
        } else {
            holder.f2609b.setVisibility(8);
            holder.f2608a.setSelected(false);
        }
        return convertView;
    }
}
