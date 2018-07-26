package com.baidu.carlife.view.recyclingviewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class RecyclingPagerAdapter extends PagerAdapter {
    /* renamed from: a */
    static final int f6830a = -1;
    /* renamed from: b */
    private final C2353a f6831b;

    /* renamed from: a */
    public abstract View mo1782a(int i, View view, ViewGroup viewGroup);

    public RecyclingPagerAdapter() {
        this(new C2353a());
    }

    RecyclingPagerAdapter(C2353a recycleBin) {
        this.f6831b = recycleBin;
        recycleBin.m8949a(m8086b());
    }

    public void notifyDataSetChanged() {
        this.f6831b.m8948a();
        super.notifyDataSetChanged();
    }

    public final Object instantiateItem(ViewGroup container, int position) {
        int viewType = m8087b(position);
        View view = null;
        if (viewType != -1) {
            view = this.f6831b.m8947a(position, viewType);
        }
        view = mo1782a(position, view, container);
        container.addView(view);
        return view;
    }

    public final void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
        int viewType = m8087b(position);
        if (viewType != -1) {
            this.f6831b.m8950a(view, position, viewType);
        }
    }

    public final boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /* renamed from: b */
    public int m8086b() {
        return 1;
    }

    /* renamed from: b */
    public int m8087b(int position) {
        return 0;
    }
}
