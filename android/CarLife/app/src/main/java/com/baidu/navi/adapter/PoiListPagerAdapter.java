package com.baidu.navi.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.view.PoiDetailView;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import java.util.List;

public class PoiListPagerAdapter extends PagerAdapter {
    private static final String TAG = "PoiSearch";
    private boolean isViewDragonOut = false;
    private Context mContext;
    private View mCurrentView;
    private OnClickListener mDragonOnClickListener;
    private OnTouchListener mDragonOnTouchListener;
    private C1277e mOnDialogListener;
    private PoiController mPoiController;
    private PoiDetailView[] mPoiDetailViews;
    private List<SearchPoi> mPoiList;
    private int mSelectIndex = -1;

    public PoiListPagerAdapter(Context mContext, List<SearchPoi> mPoiList, PoiController controller, C1277e listener) {
        this.mPoiList = mPoiList;
        this.mContext = mContext;
        this.mPoiController = controller;
        this.mPoiDetailViews = new PoiDetailView[getCount()];
        this.mOnDialogListener = listener;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        if (position >= getCount()) {
            return null;
        }
        Object view = this.mPoiDetailViews[position];
        if (view == null) {
            view = new PoiDetailView(this.mContext);
            view.setOnDialogListener(this.mOnDialogListener);
            view.setController(this.mPoiController);
            view.setSearchPoi((SearchPoi) this.mPoiList.get(position));
            view.setSearchPoiIndex(position, ((SearchPoi) this.mPoiList.get(position)).mFCType);
            view.setTag(Integer.valueOf(position));
            view.setId(position);
            this.mPoiDetailViews[position] = view;
            if (this.mSelectIndex == position) {
                view.checkStreetId();
            }
            view.setIsGragonOut(this.isViewDragonOut);
            view.updateStyle();
        }
        view.setDragonOnClickListener(this.mDragonOnClickListener);
        view.setDragonOnTouchListener(this.mDragonOnTouchListener);
        container.addView(view);
        return view;
    }

    public void setDragonOnClickListener(OnClickListener listener) {
        this.mDragonOnClickListener = listener;
    }

    public void setDragonOnTouchListener(OnTouchListener listener) {
        this.mDragonOnTouchListener = listener;
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
        if (this.mSelectIndex >= 0 && this.mSelectIndex < this.mPoiDetailViews.length) {
            PoiDetailView detailView = this.mPoiDetailViews[this.mSelectIndex];
            if (detailView != null) {
                this.mSelectIndex = -1;
                detailView.checkStreetId();
            }
        }
    }

    public void updateStyle() {
        for (int i = 0; i < this.mPoiDetailViews.length; i++) {
            if (this.mPoiDetailViews[i] != null) {
                this.mPoiDetailViews[i].updateStyle();
            }
        }
    }

    public void setIsDragonOut(boolean isDragonOut) {
        this.isViewDragonOut = isDragonOut;
        for (PoiDetailView poiDetailView : this.mPoiDetailViews) {
            if (poiDetailView != null) {
                poiDetailView.setIsGragonOut(this.isViewDragonOut);
            }
        }
    }
}
