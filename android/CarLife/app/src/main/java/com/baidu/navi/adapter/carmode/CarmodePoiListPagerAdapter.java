package com.baidu.navi.adapter.carmode;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.view.CarmodePoiDetailView;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import java.util.List;

public class CarmodePoiListPagerAdapter extends PagerAdapter {
    private static final String TAG = "PoiSearch";
    private boolean isOut;
    private Context mContext;
    private View mCurrentView;
    private C1277e mOnDialogListener;
    private PoiController mPoiController;
    private CarmodePoiDetailView[] mPoiDetailViews;
    private List<SearchPoi> mPoiList;
    private int mSelectIndex = -1;

    public CarmodePoiListPagerAdapter(Context mContext, List<SearchPoi> mPoiList, PoiController controller, C1277e listener) {
        this.mPoiList = mPoiList;
        this.mContext = mContext;
        this.mPoiController = controller;
        this.mPoiDetailViews = new CarmodePoiDetailView[getCount()];
        this.mOnDialogListener = listener;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object instantiateItem(android.view.ViewGroup r4, int r5) {
        /*
        r3 = this;
        r2 = r3.getCount();
        if (r5 < r2) goto L_0x0008;
    L_0x0006:
        r1 = 0;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = r3.mPoiDetailViews;
        r1 = r2[r5];
        if (r1 != 0) goto L_0x0049;
    L_0x000e:
        r1 = new com.baidu.navi.view.CarmodePoiDetailView;
        r2 = r3.mContext;
        r1.<init>(r2);
        r2 = r3.mOnDialogListener;
        r1.setOnDialogListener(r2);
        r2 = r3.mPoiController;
        r1.setController(r2);
        r2 = r3.mPoiList;
        r2 = r2.get(r5);
        r2 = (com.baidu.navisdk.model.datastruct.SearchPoi) r2;
        r1.setSearchPoi(r2);
        r2 = r3.mPoiList;
        r2 = r2.get(r5);
        r2 = (com.baidu.navisdk.model.datastruct.SearchPoi) r2;
        r0 = r2.mFCType;
        r1.setSearchPoiIndex(r5, r0);
        r2 = java.lang.Integer.valueOf(r5);
        r1.setTag(r2);
        r1.setId(r5);
        r2 = r3.mPoiDetailViews;
        r2[r5] = r1;
        r2 = r3.mSelectIndex;
        if (r2 != r5) goto L_0x0049;
    L_0x0049:
        r4.addView(r1);
        goto L_0x0007;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navi.adapter.carmode.CarmodePoiListPagerAdapter.instantiateItem(android.view.ViewGroup, int):java.lang.Object");
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public int getCount() {
        if (this.mPoiList == null) {
            return 0;
        }
        if (this.mPoiList.size() <= 10) {
            return this.mPoiList.size();
        }
        return 10;
    }

    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        this.mCurrentView = (View) object;
    }

    public View getPrimaryItem() {
        return this.mCurrentView;
    }

    public void selectIndex(int selectIndex) {
        this.mSelectIndex = selectIndex;
        if (this.mSelectIndex >= 0 && this.mSelectIndex < this.mPoiDetailViews.length && this.mPoiDetailViews[this.mSelectIndex] == null) {
        }
    }

    public void toggle(boolean isOut) {
        this.isOut = isOut;
        int i = 0;
        while (i < this.mPoiDetailViews.length) {
            i = this.mPoiDetailViews[i] != null ? i + 1 : i + 1;
        }
    }
}
