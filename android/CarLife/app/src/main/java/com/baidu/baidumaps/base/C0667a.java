package com.baidu.baidumaps.base;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.widget.ListAdapter;

/* compiled from: SimpleListAdapter */
/* renamed from: com.baidu.baidumaps.base.a */
public abstract class C0667a implements ListAdapter {
    /* renamed from: a */
    private final DataSetObservable f2124a = new DataSetObservable();

    public void registerDataSetObserver(DataSetObserver observer) {
        this.f2124a.registerObserver(observer);
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        this.f2124a.unregisterObserver(observer);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public boolean hasStableIds() {
        return true;
    }

    public int getItemViewType(int position) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public boolean isEnabled(int position) {
        return true;
    }

    /* renamed from: a */
    public void m2849a() {
        this.f2124a.notifyChanged();
    }
}
