package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.model.C1932k;
import java.util.List;

/* compiled from: RouteRecordListAdapter */
/* renamed from: com.baidu.carlife.adpter.p */
public class C1010p extends BaseAdapter {
    /* renamed from: a */
    private List<C1932k> f2585a;
    /* renamed from: b */
    private LayoutInflater f2586b;

    /* compiled from: RouteRecordListAdapter */
    /* renamed from: com.baidu.carlife.adpter.p$a */
    private class C1009a {
        /* renamed from: a */
        View f2575a;
        /* renamed from: b */
        TextView f2576b;
        /* renamed from: c */
        TextView f2577c;
        /* renamed from: d */
        TextView f2578d;
        /* renamed from: e */
        TextView f2579e;
        /* renamed from: f */
        TextView f2580f;
        /* renamed from: g */
        TextView f2581g;
        /* renamed from: h */
        TextView f2582h;
        /* renamed from: i */
        RelativeLayout f2583i;
        /* renamed from: j */
        final /* synthetic */ C1010p f2584j;

        private C1009a(C1010p c1010p) {
            this.f2584j = c1010p;
        }
    }

    public C1010p(Context context) {
        this.f2586b = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void m3254a(List<C1932k> routeRecordList) {
        this.f2585a = routeRecordList;
    }

    public int getCount() {
        if (this.f2585a != null) {
            return this.f2585a.size();
        }
        return 0;
    }

    public Object getItem(int position) {
        if (this.f2585a == null || position >= this.f2585a.size()) {
            return null;
        }
        return this.f2585a.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            C1009a holder = new C1009a();
            convertView = this.f2586b.inflate(C0965R.layout.item_route_record, parent, false);
            holder.f2575a = convertView;
            holder.f2576b = (TextView) convertView.findViewById(C0965R.id.tv_start_addr);
            holder.f2577c = (TextView) convertView.findViewById(C0965R.id.tv_des_addr);
            holder.f2578d = (TextView) convertView.findViewById(C0965R.id.tv_distance);
            holder.f2579e = (TextView) convertView.findViewById(C0965R.id.tv_duration);
            holder.f2580f = (TextView) convertView.findViewById(C0965R.id.tv_speed);
            holder.f2581g = (TextView) convertView.findViewById(C0965R.id.tv_date);
            holder.f2582h = (TextView) convertView.findViewById(C0965R.id.tv_time);
            holder.f2583i = (RelativeLayout) convertView.findViewById(C0965R.id.rl_delete_btn);
            convertView.setTag(holder);
        }
        m3253a(position, (C1009a) convertView.getTag(), (C1932k) getItem(position));
        return convertView;
    }

    /* renamed from: a */
    private void m3253a(final int position, C1009a holder, final C1932k model) {
        if (model.f6071a) {
            holder.f2583i.setVisibility(0);
            if (model.f6080j) {
                holder.f2583i.setClickable(false);
            } else {
                holder.f2583i.setClickable(true);
                holder.f2583i.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: c */
                    final /* synthetic */ C1010p f2574c;

                    public void onClick(View v) {
                        model.f6081k.deleteRecordItem(position);
                    }
                });
            }
        } else {
            holder.f2583i.setVisibility(8);
        }
        holder.f2576b.setText(model.f6072b);
        holder.f2577c.setText(model.f6073c);
        holder.f2578d.setText(model.f6074d);
        holder.f2579e.setText(model.f6075e);
        holder.f2580f.setText(model.f6076f);
        holder.f2581g.setText(model.f6077g);
        holder.f2582h.setText(model.f6078h);
    }
}
