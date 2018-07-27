package com.baidu.carlife.view.recyclingviewpager;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;

/* compiled from: RecycleBin */
/* renamed from: com.baidu.carlife.view.recyclingviewpager.a */
class C2353a {
    /* renamed from: a */
    private View[] f7782a = new View[0];
    /* renamed from: b */
    private int[] f7783b = new int[0];
    /* renamed from: c */
    private SparseArray<View>[] f7784c;
    /* renamed from: d */
    private int f7785d;
    /* renamed from: e */
    private SparseArray<View> f7786e;

    C2353a() {
    }

    /* renamed from: a */
    public void m8949a(int viewTypeCount) {
        if (viewTypeCount < 1) {
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }
        SparseArray<View>[] scrapViews = new SparseArray[viewTypeCount];
        for (int i = 0; i < viewTypeCount; i++) {
            scrapViews[i] = new SparseArray();
        }
        this.f7785d = viewTypeCount;
        this.f7786e = scrapViews[0];
        this.f7784c = scrapViews;
    }

    /* renamed from: b */
    protected boolean m8951b(int viewType) {
        return viewType >= 0;
    }

    /* renamed from: a */
    View m8947a(int position, int viewType) {
        if (this.f7785d == 1) {
            return C2353a.m8945a(this.f7786e, position);
        }
        if (viewType < 0 || viewType >= this.f7784c.length) {
            return null;
        }
        return C2353a.m8945a(this.f7784c[viewType], position);
    }

    /* renamed from: a */
    void m8950a(View scrap, int position, int viewType) {
        if (this.f7785d == 1) {
            this.f7786e.put(position, scrap);
        } else {
            this.f7784c[viewType].put(position, scrap);
        }
        if (VERSION.SDK_INT >= 14) {
            scrap.setAccessibilityDelegate(null);
        }
    }

    /* renamed from: a */
    void m8948a() {
        boolean multipleScraps = true;
        View[] activeViews = this.f7782a;
        int[] activeViewTypes = this.f7783b;
        if (this.f7785d <= 1) {
            multipleScraps = false;
        }
        SparseArray<View> scrapViews = this.f7786e;
        for (int i = activeViews.length - 1; i >= 0; i--) {
            View victim = activeViews[i];
            if (victim != null) {
                int whichScrap = activeViewTypes[i];
                activeViews[i] = null;
                activeViewTypes[i] = -1;
                if (m8951b(whichScrap)) {
                    if (multipleScraps) {
                        scrapViews = this.f7784c[whichScrap];
                    }
                    scrapViews.put(i, victim);
                    if (VERSION.SDK_INT >= 14) {
                        victim.setAccessibilityDelegate(null);
                    }
                }
            }
        }
        m8946b();
    }

    /* renamed from: b */
    private void m8946b() {
        int maxViews = this.f7782a.length;
        int viewTypeCount = this.f7785d;
        SparseArray<View>[] scrapViews = this.f7784c;
        for (int i = 0; i < viewTypeCount; i++) {
            SparseArray<View> scrapPile = scrapViews[i];
            int size = scrapPile.size();
            int extras = size - maxViews;
            int j = 0;
            int size2 = size - 1;
            while (j < extras) {
                size = size2 - 1;
                scrapPile.remove(scrapPile.keyAt(size2));
                j++;
                size2 = size;
            }
        }
    }

    /* renamed from: a */
    static View m8945a(SparseArray<View> scrapViews, int position) {
        int size = scrapViews.size();
        if (size <= 0) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            int fromPosition = scrapViews.keyAt(i);
            View view = (View) scrapViews.get(fromPosition);
            if (fromPosition == position) {
                scrapViews.remove(fromPosition);
                return view;
            }
        }
        int index = size - 1;
        View r = (View) scrapViews.valueAt(index);
        scrapViews.remove(scrapViews.keyAt(index));
        return r;
    }
}
