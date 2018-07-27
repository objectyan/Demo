package com.baidu.carlife.view.pinnedheaderlistview;

import android.util.Log;
import android.widget.SectionIndexer;
import java.util.Arrays;

/* compiled from: ConcreteSectionIndexer */
/* renamed from: com.baidu.carlife.view.pinnedheaderlistview.a */
public class C2352a implements SectionIndexer {
    /* renamed from: a */
    private final String[] f7767a;
    /* renamed from: b */
    private final int[] f7768b;
    /* renamed from: c */
    private final int f7769c;

    public C2352a(String[] sections, int[] counts) {
        if (sections == null || counts == null) {
            throw new NullPointerException();
        } else if (sections.length != counts.length) {
            throw new IllegalArgumentException("The sections and counts arrays must have the same length");
        } else {
            this.f7767a = sections;
            this.f7768b = new int[counts.length];
            int position = 0;
            for (int i = 0; i < counts.length; i++) {
                if (this.f7767a[i] == null) {
                    this.f7767a[i] = "";
                } else {
                    this.f7767a[i] = this.f7767a[i].trim();
                }
                this.f7768b[i] = position;
                position += counts[i];
                Log.i("MySectionIndexer", "counts[" + i + "]:" + counts[i]);
            }
            this.f7769c = position;
        }
    }

    public Object[] getSections() {
        return this.f7767a;
    }

    public int getPositionForSection(int section) {
        if (section < 0 || section >= this.f7767a.length) {
            return -1;
        }
        return this.f7768b[section];
    }

    public int getSectionForPosition(int position) {
        if (position < 0 || position >= this.f7769c) {
            return -1;
        }
        int index = Arrays.binarySearch(this.f7768b, position);
        return index < 0 ? (-index) - 2 : index;
    }
}
