package com.baidu.navi.controller;

import android.os.AsyncTask;
import com.baidu.navi.favorite.util.FavoritePoiUtils;
import com.baidu.navisdk.model.datastruct.SearchPoi;

public class PoiDetailViewController
{
  private IPoiDetailViewCallBack mCallBack;
  private SearchPoi mCurrentPoi;
  
  public void addOrDelFav()
  {
    new BacksyncFavTask(null).execute(new Void[0]);
  }
  
  public void init(SearchPoi paramSearchPoi)
  {
    this.mCurrentPoi = paramSearchPoi;
  }
  
  public boolean isHaveFav()
  {
    return (this.mCurrentPoi != null) && (FavoritePoiUtils.isHaveFav(this.mCurrentPoi));
  }
  
  public void setCallBack(IPoiDetailViewCallBack paramIPoiDetailViewCallBack)
  {
    this.mCallBack = paramIPoiDetailViewCallBack;
  }
  
  private class BacksyncFavTask
    extends AsyncTask<Void, Void, String>
  {
    private BacksyncFavTask() {}
    
    protected String doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = FavoritePoiUtils.addOrDelFav(PoiDetailViewController.this.mCurrentPoi);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs) {}
      return "";
    }
    
    protected void onPostExecute(String paramString)
    {
      if (PoiDetailViewController.this.mCallBack != null) {
        PoiDetailViewController.this.mCallBack.onFavSyncDone(paramString);
      }
    }
  }
  
  public static abstract interface IPoiDetailViewCallBack
  {
    public abstract void onFavSyncDone(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/PoiDetailViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */