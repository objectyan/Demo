package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.carlife.R;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.logic.C1856o;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.PressTextView;

/* compiled from: HomeBigIconAdapter */
/* renamed from: com.baidu.carlife.adpter.d */
public class HomeBigIconAdapter extends BaseAdapter {
    /* renamed from: a */
    public static final int f2481a = 0;
    /* renamed from: b */
    public static final int f2482b = 1;
    /* renamed from: c */
    public static final int f2483c = 2;
    /* renamed from: d */
    public static final int f2484d = 3;
    /* renamed from: e */
    private Context f2485e;
    /* renamed from: f */
    private String[] f2486f;
    /* renamed from: g */
    private int[] f2487g;
    /* renamed from: h */
    private int f2488h;

    public HomeBigIconAdapter(Context context, String[] strings, int[] imageIds, int adapterType) {
        this.f2485e = context;
        this.f2486f = strings;
        this.f2487g = imageIds;
        this.f2488h = adapterType;
    }

    public HomeBigIconAdapter(Context context, int adapterType) {
        this.f2485e = context;
        this.f2488h = adapterType;
    }

    /* renamed from: a */
    public void m3181a(int[] imageIds) {
        this.f2487g = imageIds;
    }

    /* renamed from: a */
    public void m3182a(String[] strings) {
        this.f2486f = strings;
    }

    public int getCount() {
        if (this.f2486f == null || this.f2487g == null) {
            return 0;
        }
        return this.f2486f.length <= this.f2487g.length ? this.f2486f.length : this.f2487g.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        PressTextView itemTV;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f2485e).inflate(R.layout.home_big_icon_item, parent, false);
            itemTV = (PressTextView) convertView.findViewById(R.id.item_tv);
            convertView.setTag(itemTV);
        } else {
            itemTV = (PressTextView) convertView.getTag();
        }
        itemTV.setText(this.f2486f[position]);
        convertView.setBackground(C2188r.m8331b(R.drawable.home_bg_item_selector));
        itemTV.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_bgtext));
        itemTV.setCompoundDrawablesWithIntrinsicBounds(null, C2188r.m8331b(this.f2487g[position]), null, null);
        if (m3179a(position)) {
            convertView.setAlpha(1.0f);
            itemTV.setAlpha(1.0f);
        } else {
            convertView.setAlpha(0.5f);
            itemTV.setAlpha(0.5f);
        }
        if (this.f2488h == 2) {
            if (!CarlifeCoreSDK.m5979a().m5993N() && C1856o.m7042a().m7045b() && position == 0) {
                m3180a(itemTV, true);
            } else {
                m3180a(itemTV, false);
            }
        }
        return convertView;
    }

    /* renamed from: a */
    public void m3180a(PressTextView itemTV, boolean isNeed) {
        itemTV.setNeedRedPoint(isNeed);
        itemTV.setPageType(2);
        itemTV.requestLayout();
    }

    public boolean isEnabled(int position) {
        return m3179a(position);
    }

    /* renamed from: a */
    private boolean m3179a(int position) {
        if (FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving()) {
            if (this.f2488h == 0) {
                return false;
            }
            if (this.f2488h == 1 && (position == 1 || position == 2 || position == 3)) {
                return false;
            }
        }
        return true;
    }
}
