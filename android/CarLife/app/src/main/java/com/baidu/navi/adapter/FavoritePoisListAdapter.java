package com.baidu.navi.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.util.C2188r;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.favorite.util.FavoritePoiUtils;
import com.baidu.navi.fragment.carmode.CarModeFavoriteFragment;
import com.baidu.navi.interfaces.IFavoriteFragStatusListener;
import com.baidu.navi.interfaces.IFavoriteFragUiUpdateHandler;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavoritePoisListAdapter extends BaseAdapter {
    public static final long FIXED_ITEM_ID = 100;
    private static final int MAX_LOAD_NUM = 20;
    public static final String TAG = FavoritePoisListAdapter.class.getSimpleName();
    private ViewHolder holder;
    private String mBduid = "";
    private IFavoriteFragStatusListener mFavoriteFragStatusListener;
    private IFavoriteFragUiUpdateHandler mFavoriteFragUiUpdateHandler;
    private FavoritePois mFavoritePois = FavoritePois.getPoiInstance();
    private List<FavItem> mFavoritesRecordList = new ArrayList();
    private boolean mHasNewData = true;
    private LayoutInflater mInflater;
    private boolean mIsEditable = false;
    private CarModeFavoriteFragment modeFavoriteFragment;

    /* renamed from: com.baidu.navi.adapter.FavoritePoisListAdapter$1 */
    class C36281 implements IFavoriteFragStatusListener {
        C36281() {
        }

        public void editEnable() {
            FavoritePoisListAdapter.this.mIsEditable = true;
            FavoritePoisListAdapter.this.notifyDataSetChanged();
        }

        public void editDisable() {
            FavoritePoisListAdapter.this.mIsEditable = false;
            FavoritePoisListAdapter.this.notifyDataSetChanged();
        }

        public void clearListViewData() {
            FavoritePoisListAdapter.this.mFavoritesRecordList.clear();
        }
    }

    private class DeleteFavInfoTask extends AsyncTask<Integer, Void, Integer> {
        private int index;

        private DeleteFavInfoTask() {
        }

        protected Integer doInBackground(Integer... params) {
            this.index = params[0].intValue();
            int sucFlag = FavoritePoisListAdapter.this.deleteFavItemByIndex(this.index);
            if (sucFlag == 1) {
                FavoritePoisListAdapter.this.removeItemByIndex(this.index);
            }
            return Integer.valueOf(sucFlag);
        }

        protected void onPostExecute(Integer integer) {
            FavoritePoisListAdapter.this.notifyDataSetChanged();
        }
    }

    private class FavItem {
        public String mAddr;
        public GeoPoint mGuidePoint;
        public String mKey;
        public String mName;
        public String mOriginUID;

        private FavItem() {
        }

        public String toString() {
            return "FavItem[key:" + this.mKey + ", name:" + this.mName + ", addr:" + this.mAddr + ", originUID:" + this.mOriginUID + ", guidePoint:" + this.mGuidePoint + "]";
        }
    }

    private class GetFavInfoTask extends AsyncTask<Integer, Void, Integer> {
        private GetFavInfoTask() {
        }

        protected Integer doInBackground(Integer... params) {
            FavoritePoisListAdapter.this.selectFavDataFromDB();
            return Integer.valueOf(0);
        }

        protected void onPostExecute(Integer integer) {
            if (FavoritePoisListAdapter.this.mHasNewData) {
                if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null) {
                    FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.footerShowLoadMore();
                }
            } else if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null) {
                FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.footerShowNoMore();
            }
            if (FavoritePoisListAdapter.this.mFavoritesRecordList.isEmpty()) {
                if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null) {
                    FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.hideEditBtn();
                    FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.hideLoadMoreFooter();
                }
            } else if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null) {
                FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.showEditBtn();
                FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.showLoadMoreFooter();
            }
            FavoritePoisListAdapter.this.notifyDataSetChanged();
            if (FavoritePoisListAdapter.this.modeFavoriteFragment != null) {
                FavoritePoisListAdapter.this.modeFavoriteFragment.onInitFocusAreas();
            }
            if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null) {
                FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.syncEnd();
            }
        }
    }

    public static class ViewHolder {
        public ImageView deleteIcon;
        public LinearLayout deleteLayout;
        public LinearLayout poiInfoLayout;
        public TextView pointDescription;
        public TextView pointName;
        public ImageView rightArrowIcon;
    }

    public FavoritePoisListAdapter(Context context, CarModeFavoriteFragment carModeFavoriteFragment) {
        this.mInflater = LayoutInflater.from(context);
        this.mFavoritesRecordList = new ArrayList();
        this.modeFavoriteFragment = carModeFavoriteFragment;
        this.mFavoriteFragStatusListener = new C36281();
    }

    public void setFavoriteFragUiUpdateHandler(IFavoriteFragUiUpdateHandler handler) {
        this.mFavoriteFragUiUpdateHandler = handler;
    }

    public IFavoriteFragStatusListener getFavoriteFragStatusListener() {
        return this.mFavoriteFragStatusListener;
    }

    public int getCount() {
        if (this.mFavoritesRecordList != null) {
            return this.mFavoritesRecordList.size();
        }
        return 0;
    }

    public Object getItem(int position) {
        if (this.mFavoritesRecordList == null || position >= this.mFavoritesRecordList.size()) {
            return null;
        }
        return this.mFavoritesRecordList.get(position);
    }

    public long getItemId(int position) {
        return 100;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = getItemView(convertView, position);
        setItemContent(position);
        return convertView;
    }

    private View getItemView(View convertView, int position) {
        if (convertView == null || convertView.getTag() == null) {
            this.holder = new ViewHolder();
            convertView = this.mInflater.inflate(C0965R.layout.navi_favorite_item, null);
            this.holder.poiInfoLayout = (LinearLayout) convertView.findViewById(C0965R.id.dest_info_layout);
            this.holder.pointName = (TextView) convertView.findViewById(C0965R.id.dest_name);
            this.holder.pointDescription = (TextView) convertView.findViewById(C0965R.id.dest_description);
            this.holder.rightArrowIcon = (ImageView) convertView.findViewById(C0965R.id.iv_direction_icon);
            this.holder.deleteIcon = (ImageView) convertView.findViewById(C0965R.id.btn_dest_delete);
            this.holder.deleteLayout = (LinearLayout) convertView.findViewById(C0965R.id.dest_delete_layout);
            convertView.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) convertView.getTag();
        }
        FavItem item = (FavItem) getItem(position);
        if (item != null) {
            if (TextUtils.isEmpty(item.mName) || TextUtils.isEmpty(item.mAddr)) {
                this.holder.pointDescription.setVisibility(8);
                this.holder.poiInfoLayout.setLayoutParams(new LayoutParams(-2, ScreenUtil.getInstance().dip2px(60), 1.0f));
            } else {
                this.holder.pointDescription.setVisibility(0);
                this.holder.poiInfoLayout.setLayoutParams(new LayoutParams(-2, ScreenUtil.getInstance().dip2px(80), 1.0f));
            }
            setupSkin();
        }
        return convertView;
    }

    private void setupSkin() {
        this.holder.pointName.setTextColor(C2188r.a(C0965R.color.cl_text_a5_content));
        this.holder.pointDescription.setTextColor(C2188r.a(C0965R.color.cl_text_a2_content));
    }

    private void setItemContent(final int position) {
        FavItem item = (FavItem) getItem(position);
        if (item != null) {
            if (!TextUtils.isEmpty(item.mName)) {
                this.holder.pointName.setText(item.mName);
                if (TextUtils.isEmpty(item.mAddr)) {
                    this.holder.pointDescription.setText("");
                } else {
                    this.holder.pointDescription.setText(item.mAddr);
                }
            } else if (TextUtils.isEmpty(item.mAddr)) {
                this.holder.pointName.setText("");
                this.holder.pointDescription.setText("");
            } else {
                this.holder.pointName.setText(item.mAddr);
                this.holder.pointDescription.setText("");
            }
            this.holder.deleteLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    FavoritePoisListAdapter.this.deleteFavItemBackgroud(position);
                }
            });
            if (this.mIsEditable) {
                this.holder.rightArrowIcon.setVisibility(8);
                this.holder.deleteIcon.setVisibility(0);
                this.holder.deleteLayout.setClickable(true);
                this.holder.deleteLayout.setBackgroundResource(C0965R.drawable.carlife_list_icon_bg_press_selector);
                return;
            }
            this.holder.deleteIcon.setVisibility(8);
            this.holder.rightArrowIcon.setVisibility(0);
            this.holder.deleteLayout.setClickable(false);
            this.holder.deleteLayout.setBackground(null);
        }
    }

    public void startCalcRoute(int index) {
        FavItem item = (FavItem) getItem(index);
        if (item != null) {
            StatisticManager.onEvent(StatisticConstants.NAVI_0019, StatisticConstants.NAVI_0019);
            SearchPoi searchPoi = new SearchPoi();
            searchPoi.mGuidePoint = item.mGuidePoint;
            searchPoi.mViewPoint = item.mGuidePoint;
            searchPoi.mAddress = item.mAddr;
            searchPoi.mName = item.mName;
            searchPoi.mOriginUID = item.mOriginUID;
            NavPoiController.getInstance().startCalcRoute(searchPoi);
        }
    }

    private synchronized void removeItemByIndex(int index) {
        if (index >= 0) {
            if (this.mFavoritesRecordList != null && index < this.mFavoritesRecordList.size()) {
                this.mFavoritesRecordList.remove(index);
            }
        }
    }

    public void deleteFavItemBackgroud(int index) {
        new DeleteFavInfoTask().execute(new Integer[]{Integer.valueOf(index)});
    }

    public void updateData() {
        new GetFavInfoTask().execute(new Integer[0]);
    }

    public void cleanData() {
        if (this.mFavoritesRecordList != null) {
            this.mFavoritesRecordList.clear();
        }
    }

    private synchronized int deleteFavItemByIndex(int index) {
        boolean flag;
        flag = false;
        if (index >= 0) {
            if (this.mFavoritesRecordList != null && index < this.mFavoritesRecordList.size()) {
                flag = this.mFavoritePois.deleteFavPoi(((FavItem) this.mFavoritesRecordList.get(index)).mKey);
            }
        }
        return flag ? 1 : 0;
    }

    private ArrayList<FavItem> getFavDataFromDB(String time, int limit, String bduid) {
        if (time == null) {
            time = "9999999999999";
        }
        if (bduid == null) {
            bduid = "";
        }
        if (limit <= 0 || limit > 100) {
            limit = 20;
        }
        ArrayList<FavItem> datas = new ArrayList();
        if (this.mFavoritePois != null) {
            int index = 0;
            FavoritePois favoritePois = this.mFavoritePois;
            if (bduid == null) {
                bduid = "";
            }
            ArrayList<String> maryKey = favoritePois.getFavPoiValidGenInfo(bduid);
            if (maryKey != null && maryKey.size() > 0) {
                Iterator it = maryKey.iterator();
                while (it.hasNext()) {
                    String tmpkey = (String) it.next();
                    if (tmpkey.compareTo(time) < 0) {
                        if (index >= limit) {
                            break;
                        }
                        FavSyncPoi favPoi = this.mFavoritePois.getFavPoiInfo(tmpkey);
                        if (favPoi != null) {
                            FavItem favItem = new FavItem();
                            favItem.mKey = tmpkey;
                            favItem.mName = favPoi.poiName;
                            favItem.mAddr = favPoi.content;
                            favItem.mOriginUID = favPoi.poiId;
                            if (!TextUtils.isEmpty(favItem.mAddr) || !TextUtils.isEmpty(favItem.mName)) {
                                if (favPoi.pt != null) {
                                    favItem.mGuidePoint = FavoritePoiUtils.mcTogcjPoint(favPoi.pt);
                                }
                                if (!TextUtils.isEmpty(favPoi.poiId)) {
                                    favItem.mOriginUID = favPoi.poiId;
                                } else if (favPoi.pt == null) {
                                }
                                datas.add(favItem);
                                index++;
                                C1260i.b(TAG, favItem.toString() + " bduid:" + favPoi.bduid);
                            }
                        }
                    }
                }
            }
        }
        return datas;
    }

    private synchronized void selectFavDataFromDB() {
        if (this.mFavoritePois != null) {
            String bduid;
            if (NaviAccountUtils.getInstance().getUid() == null) {
                bduid = "";
            } else {
                bduid = NaviAccountUtils.getInstance().getUid();
            }
            if (!this.mBduid.equals(bduid)) {
                this.mBduid = bduid;
                cleanData();
            }
            String time = "9999999999999";
            if (this.mFavoritesRecordList.size() > 0) {
                time = ((FavItem) this.mFavoritesRecordList.get(this.mFavoritesRecordList.size() - 1)).mKey;
            }
            ArrayList<FavItem> datas = getFavDataFromDB(time, 20, bduid);
            this.mFavoritesRecordList.addAll(datas);
            if (datas.size() < 20) {
                this.mHasNewData = false;
                C1260i.b(TAG, "没有更多数据");
            } else {
                this.mHasNewData = true;
                C1260i.b(TAG, "还有数据");
            }
        }
    }
}
