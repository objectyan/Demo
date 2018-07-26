package com.baidu.navi.controller;

import android.os.AsyncTask;
import com.baidu.navi.favorite.util.FavoritePoiUtils;
import com.baidu.navisdk.model.datastruct.SearchPoi;

public class PoiDetailViewController {
    private IPoiDetailViewCallBack mCallBack;
    private SearchPoi mCurrentPoi;

    private class BacksyncFavTask extends AsyncTask<Void, Void, String> {
        private BacksyncFavTask() {
        }

        protected String doInBackground(Void... params) {
            String msg = "";
            try {
                return FavoritePoiUtils.addOrDelFav(PoiDetailViewController.this.mCurrentPoi);
            } catch (Exception e) {
                return "";
            }
        }

        protected void onPostExecute(String retmsg) {
            if (PoiDetailViewController.this.mCallBack != null) {
                PoiDetailViewController.this.mCallBack.onFavSyncDone(retmsg);
            }
        }
    }

    public interface IPoiDetailViewCallBack {
        void onFavSyncDone(String str);
    }

    public void setCallBack(IPoiDetailViewCallBack callBack) {
        this.mCallBack = callBack;
    }

    public void init(SearchPoi searchPoi) {
        this.mCurrentPoi = searchPoi;
    }

    public boolean isHaveFav() {
        return this.mCurrentPoi != null && FavoritePoiUtils.isHaveFav(this.mCurrentPoi);
    }

    public void addOrDelFav() {
        new BacksyncFavTask().execute(new Void[0]);
    }
}
