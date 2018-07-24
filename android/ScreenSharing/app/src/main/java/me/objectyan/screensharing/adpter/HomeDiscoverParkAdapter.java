package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.screen.CarLifeSearchPoi;
import com.baidu.carlife.model.C1927g;
import com.baidu.carlife.util.C2188r;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.model.datastruct.LocData;
import java.text.DecimalFormat;
import java.util.List;

/* compiled from: HomeDiscoverParkAdapter */
/* renamed from: com.baidu.carlife.adpter.e */
public class HomeDiscoverParkAdapter extends BaseAdapter {
    /* renamed from: a */
    private List<C1927g> f2496a;
    /* renamed from: b */
    private LayoutInflater f2497b;
    /* renamed from: c */
    private String f2498c;
    /* renamed from: d */
    private Context f2499d;

    /* compiled from: HomeDiscoverParkAdapter */
    /* renamed from: com.baidu.carlife.adpter.e$a */
    private class C0980a {
        /* renamed from: a */
        TextView f2489a;
        /* renamed from: b */
        TextView f2490b;
        /* renamed from: c */
        TextView f2491c;
        /* renamed from: d */
        TextView f2492d;
        /* renamed from: e */
        TextView f2493e;
        /* renamed from: f */
        View f2494f;
        /* renamed from: g */
        final /* synthetic */ HomeDiscoverParkAdapter f2495g;

        private C0980a(HomeDiscoverParkAdapter homeDiscoverParkAdapter) {
            this.f2495g = homeDiscoverParkAdapter;
        }
    }

    public HomeDiscoverParkAdapter(Context context) {
        this.f2499d = context;
        this.f2497b = LayoutInflater.from(context);
        this.f2498c = context.getString(R.string.home_discover_park_free);
    }

    /* renamed from: a */
    public void m3186a(List<C1927g> list) {
        this.f2496a = list;
    }

    public int getCount() {
        if (this.f2496a == null) {
            return 0;
        }
        return this.f2496a.size();
    }

    public Object getItem(int position) {
        if (this.f2496a == null) {
            return null;
        }
        return this.f2496a.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0980a viewHolder;
        if (convertView == null) {
            convertView = this.f2497b.inflate(R.layout.item_home_discover_park, parent, false);
            viewHolder = new C0980a();
            viewHolder.f2489a = (TextView) convertView.findViewById(R.id.tv_go);
            viewHolder.f2490b = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.f2491c = (TextView) convertView.findViewById(R.id.tv_addr);
            viewHolder.f2492d = (TextView) convertView.findViewById(R.id.tv_num);
            viewHolder.f2493e = (TextView) convertView.findViewById(R.id.tv_price);
            viewHolder.f2494f = convertView.findViewById(R.id.cl_line);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (C0980a) convertView.getTag();
        }
        if (position == getCount() - 1) {
            viewHolder.f2494f.setVisibility(8);
        } else {
            viewHolder.f2494f.setVisibility(0);
        }
        C1927g model = (C1927g) getItem(position);
        m3183a(viewHolder);
        m3185a(viewHolder, model);
        return convertView;
    }

    /* renamed from: a */
    private void m3183a(C0980a viewHolder) {
        viewHolder.f2490b.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
        viewHolder.f2489a.setTextColor(C2188r.m8328a((int) R.color.cl_text_a4_content));
        viewHolder.f2491c.setTextColor(C2188r.m8328a((int) R.color.cl_text_a4_content));
        viewHolder.f2492d.setTextColor(C2188r.m8328a((int) R.color.cl_text_a4_content));
        viewHolder.f2493e.setTextColor(C2188r.m8328a((int) R.color.cl_text_a4_content));
    }

    /* renamed from: a */
    public void m3185a(C0980a viewHolder, C1927g model) {
        if (model != null) {
            if (model.f6022l >= 0) {
                if (model.f6022l <= 1000) {
                    viewHolder.f2489a.setText(model.f6022l + Config.MODEL);
                } else {
                    viewHolder.f2489a.setText(new DecimalFormat(".00").format((double) (((float) model.f6022l) / 1000.0f)) + "km");
                }
            }
            if (!TextUtils.isEmpty(model.f6012b)) {
                viewHolder.f2490b.setText(model.f6012b);
            }
            if (!TextUtils.isEmpty(model.f6015e)) {
                viewHolder.f2491c.setText(model.f6015e);
            }
            if (model.f6021k > 0 && model.f6020j >= 0) {
                if (((double) (((float) model.f6020j) / ((float) model.f6021k))) <= 0.1d) {
                    viewHolder.f2492d.setText(Html.fromHtml("<font color=\"#ff1744\">" + model.f6020j + "</font>/" + model.f6021k));
                } else {
                    viewHolder.f2492d.setText(Html.fromHtml("<font color=\"#ccffffff\">" + model.f6020j + "</font>/" + model.f6021k));
                }
            }
            if (TextUtils.isEmpty(model.f6016f) || !model.f6016f.equals("0")) {
                viewHolder.f2493e.setText(model.f6016f + model.f6017g);
                viewHolder.f2493e.setTextColor(C2188r.m8328a((int) R.color.cl_text_a4_content));
                return;
            }
            viewHolder.f2493e.setText(this.f2498c);
            viewHolder.f2493e.setTextColor(C2188r.m8328a((int) R.color.cl_other_f_free));
        }
    }

    /* renamed from: a */
    public CarLifeSearchPoi m3184a(int position) {
        C1927g model = (C1927g) getItem(position);
        if (this.f2499d == null || model == null) {
            return null;
        }
        LocData locData = new LocData();
        locData.longitude = model.f6019i;
        locData.latitude = model.f6018h;
        return new CarLifeSearchPoi(model.f6019i, model.f6018h);
    }
}
