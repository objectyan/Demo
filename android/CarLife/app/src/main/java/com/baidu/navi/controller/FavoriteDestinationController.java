package com.baidu.navi.controller;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager.DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviFavoriteDestModel;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDestinationController
{
  private static final String TAG = FavoriteDestinationController.class.getSimpleName();
  private DBManager.DBOperateResultCallback mCallback = new DBManager.DBOperateResultCallback()
  {
    public void onAddOrDeleteSuccess()
    {
      FavoriteDestinationController.this.notifyHistoryDataSetChanged();
    }
    
    public void onQuerySuccess()
    {
      FavoriteDestinationController.this.notifyHistoryDataSetChanged();
    }
  };
  private List<RoutePlanNode> mDataList = new ArrayList();
  
  private double getDistance(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    double d1 = paramGeoPoint1.getLongitudeE6() - paramGeoPoint2.getLongitudeE6();
    double d2 = paramGeoPoint1.getLatitudeE6() - paramGeoPoint2.getLatitudeE6();
    return Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static FavoriteDestinationController getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  private void notifyHistoryDataSetChanged()
  {
    this.mDataList = NaviFavoriteDestModel.getInstance().getRoutePlanNode();
  }
  
  public void addFavoriteDestFromDB(RoutePlanNode paramRoutePlanNode, FavoriteDestResultCallBack paramFavoriteDestResultCallBack)
  {
    if (paramRoutePlanNode == null) {
      if (paramFavoriteDestResultCallBack != null) {
        paramFavoriteDestResultCallBack.onAddResult(false);
      }
    }
    do
    {
      return;
      DBManager.addFavoriteDestPointToDB(paramRoutePlanNode);
      DBManager.getAllFavoriteDestPoints(this.mCallback);
    } while (paramFavoriteDestResultCallBack == null);
    paramFavoriteDestResultCallBack.onAddResult(true);
  }
  
  public void checkFavoriteDest(final SearchPoi paramSearchPoi, final FavoriteDestResultCallBack paramFavoriteDestResultCallBack)
  {
    if ((this.mDataList == null) || (paramSearchPoi == null) || (paramFavoriteDestResultCallBack == null))
    {
      if (paramFavoriteDestResultCallBack != null) {
        paramFavoriteDestResultCallBack.onCheckResult(false);
      }
      return;
    }
    if ((paramSearchPoi == null) || (paramSearchPoi.mGuidePoint == null))
    {
      paramFavoriteDestResultCallBack.onCheckResult(false);
      return;
    }
    if ((paramSearchPoi == null) || (paramSearchPoi.mGuidePoint.getLatitudeE6() == Integer.MIN_VALUE) || (paramSearchPoi.mGuidePoint.getLongitudeE6() == Integer.MIN_VALUE))
    {
      paramFavoriteDestResultCallBack.onCheckResult(false);
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        if ((FavoriteDestinationController.this.mDataList == null) || (paramSearchPoi == null) || (paramFavoriteDestResultCallBack == null)) {
          i = 1;
        }
        if ((i != 0) || (paramSearchPoi == null) || (paramSearchPoi.mGuidePoint == null)) {
          i = 1;
        }
        if ((i != 0) || (paramSearchPoi == null) || (paramSearchPoi.mGuidePoint.getLatitudeE6() == Integer.MIN_VALUE) || (paramSearchPoi.mGuidePoint.getLongitudeE6() == Integer.MIN_VALUE)) {
          i = 1;
        }
        boolean bool2 = false;
        int j = 0;
        RoutePlanNode localRoutePlanNode;
        if (i == 0)
        {
          bool1 = bool2;
          if (j >= FavoriteDestinationController.this.mDataList.size()) {}
        }
        else
        {
          localRoutePlanNode = (RoutePlanNode)FavoriteDestinationController.this.mDataList.get(j);
          if (localRoutePlanNode.mGeoPoint == null) {}
          while ((localRoutePlanNode.mGeoPoint.getLatitudeE6() == Integer.MIN_VALUE) || (localRoutePlanNode.mGeoPoint.getLongitudeE6() == Integer.MIN_VALUE))
          {
            j += 1;
            break;
          }
          if ((localRoutePlanNode.mGeoPoint.getLatitudeE6() != paramSearchPoi.mGuidePoint.getLatitudeE6()) || (localRoutePlanNode.mGeoPoint.getLongitudeE6() != paramSearchPoi.mGuidePoint.getLongitudeE6())) {
            break label249;
          }
        }
        for (final boolean bool1 = true;; bool1 = true)
        {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              if (FavoriteDestinationController.2.this.val$callback != null) {
                FavoriteDestinationController.2.this.val$callback.onCheckResult(bool1);
              }
            }
          });
          return;
          label249:
          if ((TextUtils.isEmpty(localRoutePlanNode.mName)) || (TextUtils.isEmpty(paramSearchPoi.mName)) || (!localRoutePlanNode.mName.equals(paramSearchPoi.mName)) || (FavoriteDestinationController.this.getDistance(paramSearchPoi.mGuidePoint, localRoutePlanNode.mGeoPoint) > 5.0D)) {
            break;
          }
        }
      }
    }).start();
  }
  
  public boolean checkFavoriteDest(SearchPoi paramSearchPoi)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.mDataList == null) || (paramSearchPoi == null))
    {
      bool1 = false;
      return bool1;
    }
    if ((paramSearchPoi == null) || (paramSearchPoi.mGuidePoint == null)) {
      return false;
    }
    if ((paramSearchPoi == null) || (paramSearchPoi.mGuidePoint.getLatitudeE6() == Integer.MIN_VALUE) || (paramSearchPoi.mGuidePoint.getLongitudeE6() == Integer.MIN_VALUE)) {
      return false;
    }
    int i = 0;
    if (i < this.mDataList.size())
    {
      RoutePlanNode localRoutePlanNode = (RoutePlanNode)this.mDataList.get(i);
      if (localRoutePlanNode.mGeoPoint == null) {}
      do
      {
        do
        {
          i += 1;
          break;
        } while ((localRoutePlanNode.mGeoPoint.getLatitudeE6() == Integer.MIN_VALUE) || (localRoutePlanNode.mGeoPoint.getLongitudeE6() == Integer.MIN_VALUE));
        if (localRoutePlanNode.mGeoPoint.getLatitudeE6() == paramSearchPoi.mGuidePoint.getLatitudeE6())
        {
          bool1 = bool2;
          if (localRoutePlanNode.mGeoPoint.getLongitudeE6() == paramSearchPoi.mGuidePoint.getLongitudeE6()) {
            break;
          }
        }
      } while ((TextUtils.isEmpty(localRoutePlanNode.mName)) || (TextUtils.isEmpty(paramSearchPoi.mName)) || (!localRoutePlanNode.mName.equals(paramSearchPoi.mName)) || (getDistance(paramSearchPoi.mGuidePoint, localRoutePlanNode.mGeoPoint) > 5.0D));
      return true;
    }
    return false;
  }
  
  public void cleanAllFavoriteDest(final FavoriteDestResultCallBack paramFavoriteDestResultCallBack)
  {
    DBManager.clearFavoriteDestFromDB(new DBManager.DBOperateResultCallback()
    {
      public void onAddOrDeleteSuccess()
      {
        FavoriteDestinationController.this.notifyHistoryDataSetChanged();
        if (paramFavoriteDestResultCallBack != null) {
          paramFavoriteDestResultCallBack.onCleanResult(true);
        }
      }
      
      public void onQuerySuccess() {}
    });
  }
  
  public RoutePlanNode createRoutePlanNode(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return null;
    }
    return new RoutePlanNode(paramSearchPoi.mGuidePoint, paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
  }
  
  public void deleteFavoriteDestFromDB(RoutePlanNode paramRoutePlanNode, final FavoriteDestResultCallBack paramFavoriteDestResultCallBack)
  {
    if (paramRoutePlanNode == null)
    {
      if (paramFavoriteDestResultCallBack != null) {
        paramFavoriteDestResultCallBack.onRemoveResult(false);
      }
      return;
    }
    DBManager.deleteFavoriteDestFromDB(paramRoutePlanNode, new DBManager.DBOperateResultCallback()
    {
      public void onAddOrDeleteSuccess()
      {
        FavoriteDestinationController.this.notifyHistoryDataSetChanged();
        if (paramFavoriteDestResultCallBack != null) {
          paramFavoriteDestResultCallBack.onRemoveResult(true);
        }
      }
      
      public void onQuerySuccess() {}
    });
  }
  
  public List<RoutePlanNode> getFavoriteDestList()
  {
    return this.mDataList;
  }
  
  public void queryAllFavoriteDestFromDB(DBManager.DBOperateResultCallback paramDBOperateResultCallback)
  {
    if (!NaviFavoriteDestModel.getInstance().checkIsQueryDB())
    {
      if (paramDBOperateResultCallback == null) {
        DBManager.getAllFavoriteDestPoints(this.mCallback);
      }
    }
    else {
      return;
    }
    DBManager.getAllFavoriteDestPoints(paramDBOperateResultCallback);
  }
  
  public static abstract interface FavoriteDestResultCallBack
  {
    public abstract void onAddResult(boolean paramBoolean);
    
    public abstract void onCheckResult(boolean paramBoolean);
    
    public abstract void onCleanResult(boolean paramBoolean);
    
    public abstract void onRemoveResult(boolean paramBoolean);
  }
  
  static class InnerHolder
  {
    static FavoriteDestinationController mInstance = new FavoriteDestinationController(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/FavoriteDestinationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */