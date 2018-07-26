package com.baidu.navi;

import android.os.AsyncTask;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.util.NaviAccountUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavoritePoiManager {
    private static final String TAG = FavoritePoiManager.class.getSimpleName();
    private static FavoritePoiManager instance;
    public List<FavorItem> dbFavorItems = new ArrayList();
    private FavoritePois favoritePois = FavoritePois.getPoiInstance();
    private GetFavInfoTask task;

    public interface FavCallBack {
        void callUpdate();
    }

    public class FavorItem {
        public String address;
        public String key;
        public String name;
    }

    private class GetFavInfoTask extends AsyncTask<String, Integer, String> {
        private FavCallBack callBack;
        private boolean isCancel = false;
        private String key;

        public GetFavInfoTask(String key, FavCallBack callBack) {
            this.key = key;
            this.callBack = callBack;
        }

        protected String doInBackground(String... strings) {
            if (!this.isCancel) {
                FavoritePoiManager.this.getFavDataFromDB(this.key);
            }
            return null;
        }

        protected void onPostExecute(String s) {
            if (!this.isCancel) {
                this.callBack.callUpdate();
            }
        }
    }

    private FavoritePoiManager() {
    }

    public static FavoritePoiManager getInstance() {
        if (instance == null) {
            synchronized (FavoritePoiManager.class) {
                instance = new FavoritePoiManager();
            }
        }
        return instance;
    }

    public synchronized void startGetTask(String key, FavCallBack callBack) {
        if (this.task != null) {
            this.task.isCancel = true;
            this.task = null;
        }
        this.task = new GetFavInfoTask(key, callBack);
        this.task.execute(new String[0]);
    }

    public void cancelTask() {
        if (this.task != null) {
            this.task.isCancel = true;
            this.task = null;
        }
        this.dbFavorItems.clear();
    }

    private List<FavorItem> getFavDataFromDB(String key) {
        String bduid;
        String time = "9999999999999";
        if (NaviAccountUtils.getInstance().getUid() == null) {
            bduid = "";
        } else {
            bduid = NaviAccountUtils.getInstance().getUid();
        }
        if (bduid == null) {
            bduid = "";
        }
        this.dbFavorItems.clear();
        if (this.favoritePois == null) {
            return this.dbFavorItems;
        }
        int index = 0;
        ArrayList<String> maryKey = this.favoritePois.getFavPoiValidGenInfo(bduid);
        if (maryKey != null && maryKey.size() > 0) {
            Iterator it = maryKey.iterator();
            while (it.hasNext()) {
                String tmpkey = (String) it.next();
                if (tmpkey.compareTo(time) < 0) {
                    if (index >= 500) {
                        break;
                    }
                    FavSyncPoi favPoi = this.favoritePois.getFavPoiInfo(tmpkey);
                    if (favPoi != null && favPoi.poiName.contains(key)) {
                        FavorItem favItem = new FavorItem();
                        favItem.address = favPoi.content;
                        favItem.name = favPoi.poiName;
                        favItem.key = key;
                        this.dbFavorItems.add(favItem);
                        index++;
                        C1260i.b(TAG, favItem.toString() + " bduid:" + favPoi.bduid);
                    }
                }
            }
        }
        return this.dbFavorItems;
    }
}
