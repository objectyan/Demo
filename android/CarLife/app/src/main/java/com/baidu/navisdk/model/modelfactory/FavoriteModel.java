package com.baidu.navisdk.model.modelfactory;

import android.os.Bundle;
import com.baidu.navisdk.jni.control.FavoriteControlBundle;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.Point;
import java.util.ArrayList;

public class FavoriteModel
  extends BaseModel
{
  private static final String TAG = "Favorite";
  private int mFavCount = 0;
  private ArrayList<FavoritePoiInfo> mFavDataList = new ArrayList();
  private SearchPoi mFavSearchPoi = null;
  
  public static FavoriteModel getInstance()
  {
    return LayerHolder.mInstance;
  }
  
  public void addNewFavPoiToMemList(FavoritePoiInfo paramFavoritePoiInfo)
  {
    if (this.mFavDataList == null) {
      this.mFavDataList = new ArrayList();
    }
    this.mFavDataList.add(paramFavoritePoiInfo);
    if (this.mFavCount == 0)
    {
      this.mFavCount = FavoriteControlBundle.getInstance().getPOICnt();
      return;
    }
    this.mFavCount += 1;
  }
  
  public void clearFavDataList()
  {
    if (this.mFavDataList != null) {
      this.mFavDataList.clear();
    }
  }
  
  public int getFavCount()
  {
    return this.mFavCount;
  }
  
  public ArrayList<FavoritePoiInfo> getFavDataList()
  {
    return this.mFavDataList;
  }
  
  public FavoritePoiInfo getFavPoiInfoFromMemListByKey(String paramString)
  {
    Object localObject;
    if (StringUtils.isEmpty(paramString))
    {
      localObject = null;
      return (FavoritePoiInfo)localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.mFavDataList.size()) {
        break label59;
      }
      FavoritePoiInfo localFavoritePoiInfo = (FavoritePoiInfo)this.mFavDataList.get(i);
      localObject = localFavoritePoiInfo;
      if (paramString.equals(localFavoritePoiInfo.mFavKey)) {
        break;
      }
      i += 1;
    }
    label59:
    return null;
  }
  
  public SearchPoi getFavoriteSearchPoi()
  {
    return this.mFavSearchPoi;
  }
  
  public boolean isPoiExistInMemListByGeoPoint(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return false;
    }
    int i = 0;
    label15:
    Object localObject;
    if (i < this.mFavDataList.size())
    {
      localObject = (FavoritePoiInfo)this.mFavDataList.get(i);
      if (localObject != null) {
        break label49;
      }
    }
    label49:
    do
    {
      i += 1;
      break label15;
      break;
      localObject = ((FavoritePoiInfo)localObject).mViewPoint;
      localObject = CoordinateTransformUtil.MC2LLE6(((Point)localObject).x, ((Point)localObject).y);
      localObject = new GeoPoint(((Bundle)localObject).getInt("LLx"), ((Bundle)localObject).getInt("LLy"));
    } while ((Math.abs(((GeoPoint)localObject).getLatitudeE6() - paramGeoPoint.getLatitudeE6()) > 5) || (Math.abs(((GeoPoint)localObject).getLongitudeE6() - paramGeoPoint.getLongitudeE6()) > 5));
    LogUtil.e("Favorite", "坐标相等");
    return true;
  }
  
  public void removeFavPoiFromMemList(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < this.mFavDataList.size())
      {
        if (paramString.equals(((FavoritePoiInfo)this.mFavDataList.get(i)).mFavKey)) {
          this.mFavDataList.remove(i);
        }
      }
      else
      {
        if (this.mFavCount <= 0) {
          break;
        }
        this.mFavCount -= 1;
        return;
      }
      i += 1;
    }
  }
  
  public void setFavCount(int paramInt)
  {
    this.mFavCount = paramInt;
  }
  
  public void setFavDataList(ArrayList<FavoritePoiInfo> paramArrayList)
  {
    try
    {
      clearFavDataList();
      this.mFavDataList.addAll(paramArrayList);
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public void setFavoriteSearchPoi(SearchPoi paramSearchPoi)
  {
    this.mFavSearchPoi = paramSearchPoi;
  }
  
  private static class LayerHolder
  {
    private static final FavoriteModel mInstance = new FavoriteModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/modelfactory/FavoriteModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */