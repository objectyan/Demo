package com.baidu.carlife.view.pinnedheaderlistview;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.carlife.view.pinnedheaderlistview.PinnedHeaderListView.C1005b;

/* compiled from: SectionedBaseAdapter */
/* renamed from: com.baidu.carlife.view.pinnedheaderlistview.b */
public abstract class C1006b extends BaseAdapter implements C1005b {
    /* renamed from: a */
    private static int f2559a = 0;
    /* renamed from: b */
    private static int f2560b = 0;
    /* renamed from: c */
    private SparseArray<Integer> f2561c = new SparseArray();
    /* renamed from: d */
    private SparseArray<Integer> f2562d = new SparseArray();
    /* renamed from: e */
    private SparseArray<Integer> f2563e = new SparseArray();
    /* renamed from: f */
    private int f2564f = -1;
    /* renamed from: g */
    private int f2565g = -1;

    /* renamed from: a */
    public abstract int mo1371a();

    /* renamed from: a */
    public abstract View mo1373a(int i, int i2, View view, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract View mo1366a(int i, View view, ViewGroup viewGroup);

    /* renamed from: b */
    public abstract int mo1374b(int i);

    /* renamed from: b */
    public abstract long mo1375b(int i, int i2);

    /* renamed from: c */
    public abstract Object mo1376c(int i, int i2);

    public void notifyDataSetChanged() {
        this.f2562d.clear();
        this.f2561c.clear();
        this.f2563e.clear();
        this.f2564f = -1;
        this.f2565g = -1;
        super.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        this.f2562d.clear();
        this.f2561c.clear();
        this.f2563e.clear();
        this.f2564f = -1;
        this.f2565g = -1;
        super.notifyDataSetInvalidated();
    }

    public final int getCount() {
        if (this.f2564f >= 0) {
            return this.f2564f;
        }
        int count = 0;
        for (int i = 0; i < m3226d(); i++) {
            count = (count + mo1372a(i)) + 1;
        }
        this.f2564f = count;
        return count;
    }

    public final Object getItem(int position) {
        return mo1376c(mo1368d(position), m3239f(position));
    }

    public final long getItemId(int position) {
        return mo1375b(mo1368d(position), m3239f(position));
    }

    public final View getView(int position, View convertView, ViewGroup parent) {
        if (mo1367c(position)) {
            return mo1366a(mo1368d(position), convertView, parent);
        }
        return mo1373a(mo1368d(position), m3239f(position), convertView, parent);
    }

    public final int getItemViewType(int position) {
        if (mo1367c(position)) {
            return m3230b() + mo1369e(mo1368d(position));
        }
        return m3237d(mo1368d(position), m3239f(position));
    }

    public final int getViewTypeCount() {
        return m3230b() + m3233c();
    }

    /* renamed from: d */
    public final int mo1368d(int position) {
        Integer cachedSection = (Integer) this.f2562d.get(position);
        if (cachedSection != null) {
            return cachedSection.intValue();
        }
        int sectionStart = 0;
        int i = 0;
        while (i < m3226d()) {
            int sectionEnd = (sectionStart + mo1372a(i)) + 1;
            if (position < sectionStart || position >= sectionEnd) {
                sectionStart = sectionEnd;
                i++;
            } else {
                this.f2562d.put(position, Integer.valueOf(i));
                return i;
            }
        }
        return 0;
    }

    /* renamed from: f */
    public int m3239f(int position) {
        Integer cachedPosition = (Integer) this.f2561c.get(position);
        if (cachedPosition != null) {
            return cachedPosition.intValue();
        }
        int sectionStart = 0;
        int i = 0;
        while (i < m3226d()) {
            int sectionEnd = (sectionStart + mo1372a(i)) + 1;
            if (position < sectionStart || position >= sectionEnd) {
                sectionStart = sectionEnd;
                i++;
            } else {
                int positionInSection = (position - sectionStart) - 1;
                this.f2561c.put(position, Integer.valueOf(positionInSection));
                return positionInSection;
            }
        }
        return 0;
    }

    /* renamed from: c */
    public final boolean mo1367c(int position) {
        int sectionStart = 0;
        for (int i = 0; i < m3226d(); i++) {
            if (position == sectionStart) {
                return true;
            }
            if (position < sectionStart) {
                return false;
            }
            sectionStart += mo1372a(i) + 1;
        }
        return false;
    }

    /* renamed from: d */
    public int m3237d(int section, int position) {
        return f2560b;
    }

    /* renamed from: b */
    public int m3230b() {
        return 1;
    }

    /* renamed from: e */
    public int mo1369e(int section) {
        return f2559a;
    }

    /* renamed from: c */
    public int m3233c() {
        return 1;
    }

    /* renamed from: a */
    private int mo1372a(int section) {
        Integer cachedSectionCount = (Integer) this.f2563e.get(section);
        if (cachedSectionCount != null) {
            return cachedSectionCount.intValue();
        }
        int sectionCount = mo1374b(section);
        this.f2563e.put(section, Integer.valueOf(sectionCount));
        return sectionCount;
    }

    /* renamed from: d */
    private int m3226d() {
        if (this.f2565g >= 0) {
            return this.f2565g;
        }
        this.f2565g = mo1371a();
        return this.f2565g;
    }
}
