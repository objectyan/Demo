package com.baidu.navi.favorite.model;

import java.util.ArrayList;

public class FavoriteSyncRequestModel
{
  public String bduid;
  public String bduss;
  public String datas;
  public String lastver;
  public String limit;
  private ArrayList<FavSyncPoi> syncPois = new ArrayList();
  
  public void addSyncPoi(FavSyncPoi paramFavSyncPoi)
  {
    this.syncPois.add(paramFavSyncPoi);
  }
  
  public void clean()
  {
    this.syncPois.clear();
  }
  
  public ArrayList<FavSyncPoi> getSyncPois()
  {
    return this.syncPois;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/model/FavoriteSyncRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */