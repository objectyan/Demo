package com.baidu.navi;

import android.os.AsyncTask;
import com.baidu.carlife.core.i;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.util.NaviAccountUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavoritePoiManager
{
  private static final String TAG = FavoritePoiManager.class.getSimpleName();
  private static FavoritePoiManager instance;
  public List<FavorItem> dbFavorItems = new ArrayList();
  private FavoritePois favoritePois = FavoritePois.getPoiInstance();
  private GetFavInfoTask task;
  
  private List<FavorItem> getFavDataFromDB(String paramString)
  {
    if (NaviAccountUtils.getInstance().getUid() == null) {}
    Object localObject2;
    for (Object localObject1 = "";; localObject1 = NaviAccountUtils.getInstance().getUid())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      this.dbFavorItems.clear();
      if (this.favoritePois != null) {
        break;
      }
      return this.dbFavorItems;
    }
    int i = 0;
    localObject1 = this.favoritePois.getFavPoiValidGenInfo((String)localObject2);
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
      localObject1 = ((ArrayList)localObject1).iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).compareTo("9999999999999") >= 0) {
          continue;
        }
        if (i < 500) {}
      }
      else
      {
        return this.dbFavorItems;
      }
      localObject2 = this.favoritePois.getFavPoiInfo((String)localObject2);
      if ((localObject2 != null) && (((FavSyncPoi)localObject2).poiName.contains(paramString)))
      {
        FavorItem localFavorItem = new FavorItem();
        localFavorItem.address = ((FavSyncPoi)localObject2).content;
        localFavorItem.name = ((FavSyncPoi)localObject2).poiName;
        localFavorItem.key = paramString;
        this.dbFavorItems.add(localFavorItem);
        i += 1;
        i.b(TAG, localFavorItem.toString() + " bduid:" + ((FavSyncPoi)localObject2).bduid);
      }
    }
  }
  
  public static FavoritePoiManager getInstance()
  {
    if (instance == null) {}
    try
    {
      instance = new FavoritePoiManager();
      return instance;
    }
    finally {}
  }
  
  public void cancelTask()
  {
    if (this.task != null)
    {
      GetFavInfoTask.access$002(this.task, true);
      this.task = null;
    }
    this.dbFavorItems.clear();
  }
  
  public void startGetTask(String paramString, FavCallBack paramFavCallBack)
  {
    try
    {
      if (this.task != null)
      {
        GetFavInfoTask.access$002(this.task, true);
        this.task = null;
      }
      this.task = new GetFavInfoTask(paramString, paramFavCallBack);
      this.task.execute(new String[0]);
      return;
    }
    finally {}
  }
  
  public static abstract interface FavCallBack
  {
    public abstract void callUpdate();
  }
  
  public class FavorItem
  {
    public String address;
    public String key;
    public String name;
    
    public FavorItem() {}
  }
  
  private class GetFavInfoTask
    extends AsyncTask<String, Integer, String>
  {
    private FavoritePoiManager.FavCallBack callBack;
    private boolean isCancel = false;
    private String key;
    
    public GetFavInfoTask(String paramString, FavoritePoiManager.FavCallBack paramFavCallBack)
    {
      this.key = paramString;
      this.callBack = paramFavCallBack;
    }
    
    protected String doInBackground(String... paramVarArgs)
    {
      if (!this.isCancel) {
        FavoritePoiManager.this.getFavDataFromDB(this.key);
      }
      return null;
    }
    
    protected void onPostExecute(String paramString)
    {
      if (!this.isCancel) {
        this.callBack.callUpdate();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/FavoritePoiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */