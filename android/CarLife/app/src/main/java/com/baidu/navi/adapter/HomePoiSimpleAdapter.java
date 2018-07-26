package com.baidu.navi.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.util.TipTool;
import java.util.ArrayList;

public class HomePoiSimpleAdapter extends PagerAdapter {
    private static final String TAG = "PoiSearch";
    private Context mContext;
    private View mCurrentView;
    private NaviFragmentManager mNaviFragmentManager;
    private ArrayList<SearchPoi> mPoiList;

    /* renamed from: com.baidu.navi.adapter.HomePoiSimpleAdapter$1 */
    class C36421 implements OnClickListener {
        C36421() {
        }

        public void onClick(View v) {
        }
    }

    private class OnFavBtnClickListener implements OnClickListener {
        private TextView mFavTV;
        private SearchPoi mPoi;

        public OnFavBtnClickListener(SearchPoi poi, TextView tv) {
            this.mPoi = poi;
            this.mFavTV = tv;
        }

        public void onClick(View v) {
            if (!BNFavoriteManager.getInstance().isPoiExistInFavByPoint(this.mPoi)) {
                switch (BNFavoriteManager.getInstance().addNewPoiToFavorite(this.mPoi)) {
                    case -2:
                        TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(C0965R.string.detail_fav_full));
                        return;
                    case -1:
                        TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(C0965R.string.detail_fav_add_duplicate_or_null));
                        return;
                    case 0:
                        TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(C0965R.string.detail_fav_fail));
                        return;
                    case 1:
                        this.mFavTV.setText(C0965R.string.detail_favorite);
                        BNMapController.getInstance().updateLayer(16);
                        TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(C0965R.string.detail_favorite));
                        return;
                    default:
                        return;
                }
            } else if (BNFavoriteManager.getInstance().removePoiFromFavorite(this.mPoi)) {
                BNMapController.getInstance().updateLayer(16);
                this.mFavTV.setText(C0965R.string.detail_add_favorite);
                TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(C0965R.string.detail_fav_cancle));
            } else {
                TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(C0965R.string.detail_fav_cancle_fail));
            }
        }
    }

    public HomePoiSimpleAdapter(Activity activity, ArrayList<SearchPoi> poiList, NaviFragmentManager fragManager) {
        this.mPoiList = poiList;
        this.mContext = activity;
        this.mNaviFragmentManager = fragManager;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        if (position >= this.mPoiList.size()) {
            return null;
        }
        View view = LayoutInflater.from(this.mContext).inflate(C0965R.layout.carmode_map_poi_panel, null);
        initPoiPanelView(view, (SearchPoi) this.mPoiList.get(position));
        view.setTag(Integer.valueOf(position));
        container.addView(view);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public int getCount() {
        if (this.mPoiList == null) {
            return 0;
        }
        return this.mPoiList.size();
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

    private void initPoiPanelView(View view, SearchPoi poi) {
        if (view != null && poi != null) {
            view.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg));
            TextView addrTV = (TextView) view.findViewById(C0965R.id.tv_poi_addr);
            TextView favTV = (TextView) view.findViewById(C0965R.id.tv_poi_fav);
            TextView detailTV = (TextView) view.findViewById(C0965R.id.tv_poi_detail);
            LinearLayout favBtn = (LinearLayout) view.findViewById(C0965R.id.btn_fav);
            ((TextView) view.findViewById(C0965R.id.tv_poi_title)).setText(poi.mName);
            if (poi.mAddress == null) {
                addrTV.setVisibility(4);
            } else {
                addrTV.setText(poi.mAddress);
            }
            if (BNFavoriteManager.getInstance().isPoiExistInFavByPoint(poi)) {
                favTV.setText(C0965R.string.detail_favorite);
            } else {
                favTV.setText(C0965R.string.detail_add_favorite);
            }
            favBtn.setOnClickListener(new OnFavBtnClickListener(poi, favTV));
            detailTV.setOnClickListener(new C36421());
        }
    }
}
