package com.baidu.navisdk.comapi.userdata;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.jni.control.FavoriteControlBundle;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.FavoriteModel;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.Point;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class BNFavoriteManager
  extends BNLogicController
  implements Observer
{
  private static final String TAG = "Favorite";
  private int mFavPoiInfoSortBy;
  private IBNFavUpdateListener mFavUpdateListener;
  private FavoriteControlBundle mFavoriteControl = null;
  private MsgHandler mMsgHandler = new MsgHandler(Looper.getMainLooper())
  {
    public void careAbout()
    {
      observe(4203);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      BNFavoriteManager.this.handleSyncResult(paramAnonymousMessage.arg1);
      BNFavoriteManager.access$102(BNFavoriteManager.this, null);
    }
  };
  private IBNSyncDataListener mSyncDataListener;
  
  private BNFavoriteManager()
  {
    VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
    this.mFavPoiInfoSortBy = getFavSortTypeFromPref();
  }
  
  private Point gcjToMCPoint(GeoPoint paramGeoPoint)
  {
    Point localPoint = new Point();
    paramGeoPoint = CoordinateTransformUtil.LLE62MC(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    int i = paramGeoPoint.getInt("MCx");
    int j = paramGeoPoint.getInt("MCy");
    localPoint.setmPtx(i);
    localPoint.setmPty(j);
    return localPoint;
  }
  
  private int getFavSortTypeFromPref()
  {
    return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt("sp_sort_type_prefer_key", 2);
  }
  
  public static BNFavoriteManager getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private void handleSyncResult(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              loadAllFavPoisFromEngineDB();
            } while (this.mSyncDataListener == null);
            this.mSyncDataListener.onSyncFavPoiResult(2);
            return;
          } while (this.mSyncDataListener == null);
          this.mSyncDataListener.onSyncFavPoiResult(3);
          return;
        } while (this.mSyncDataListener == null);
        this.mSyncDataListener.onSyncFavPoiResult(4);
        return;
      } while (this.mSyncDataListener == null);
      this.mSyncDataListener.onSyncFavPoiResult(5);
      return;
    } while (this.mSyncDataListener == null);
    this.mSyncDataListener.onSyncFavPoiResult(5);
  }
  
  private void loadAllFavPoisFromEngineDB()
  {
    this.mFavoriteControl.loadAllFavPoisFromEngineDB();
    getAllFavPoisFromEngineCache();
  }
  
  private FavoritePoiInfo searchPoiToFavPoi(SearchPoi paramSearchPoi)
  {
    Object localObject;
    if (paramSearchPoi == null)
    {
      LogUtil.e("Favorite", "addFavorite searchPoi is null");
      localObject = null;
      return (FavoritePoiInfo)localObject;
    }
    FavoritePoiInfo localFavoritePoiInfo = new FavoritePoiInfo();
    if (paramSearchPoi.mOriginUID != null) {
      localFavoritePoiInfo.mPoiId = paramSearchPoi.mOriginUID;
    }
    if (StringUtils.isEmpty(paramSearchPoi.mName))
    {
      localFavoritePoiInfo.mFavName = StyleManager.getString(2131296852);
      label57:
      if (!StringUtils.isEmpty(paramSearchPoi.mAddress)) {
        break label141;
      }
    }
    label141:
    for (localFavoritePoiInfo.mFavAddr = StyleManager.getString(2131296851);; localFavoritePoiInfo.mFavAddr = paramSearchPoi.mAddress)
    {
      if (paramSearchPoi.mPhone != null) {
        localFavoritePoiInfo.mFavAlias = paramSearchPoi.mPhone;
      }
      localFavoritePoiInfo.mPoiType = paramSearchPoi.mType;
      localFavoritePoiInfo.mFavCityId = paramSearchPoi.mDistrictId;
      localObject = localFavoritePoiInfo;
      if (paramSearchPoi.mViewPoint == null) {
        break;
      }
      localFavoritePoiInfo.mViewPoint = gcjToMCPoint(paramSearchPoi.mViewPoint);
      return localFavoritePoiInfo;
      localFavoritePoiInfo.mFavName = paramSearchPoi.mName;
      break label57;
    }
  }
  
  public GeoPoint MCTogcjPoint(Point paramPoint)
  {
    paramPoint = CoordinateTransformUtil.MC2LLE6(paramPoint.x, paramPoint.y);
    return new GeoPoint(paramPoint.getInt("LLx"), paramPoint.getInt("LLy"));
  }
  
  public void addNewPoiListToFavorite(List<FavoritePoiInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramList.size()) {
          break;
        }
        FavoritePoiInfo localFavoritePoiInfo = (FavoritePoiInfo)paramList.get(i);
        if ((!isPoiExistInFavByPoint(localFavoritePoiInfo.mViewPoint)) && (this.mFavoriteControl.addPOI(localFavoritePoiInfo) == 1)) {
          FavoriteModel.getInstance().addNewFavPoiToMemList(localFavoritePoiInfo);
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public int addNewPoiToFavorite(SearchPoi paramSearchPoi)
  {
    try
    {
      int i = addNewPoiToFavorite(paramSearchPoi, new FavoritePoiInfo());
      return i;
    }
    finally
    {
      paramSearchPoi = finally;
      throw paramSearchPoi;
    }
  }
  
  /* Error */
  public int addNewPoiToFavorite(SearchPoi paramSearchPoi, FavoritePoiInfo paramFavoritePoiInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +20 -> 23
    //   6: aload_1
    //   7: getfield 209	com/baidu/navisdk/model/datastruct/SearchPoi:mViewPoint	Lcom/baidu/nplatform/comapi/basestruct/GeoPoint;
    //   10: ifnull +13 -> 23
    //   13: aload_1
    //   14: getfield 209	com/baidu/navisdk/model/datastruct/SearchPoi:mViewPoint	Lcom/baidu/nplatform/comapi/basestruct/GeoPoint;
    //   17: invokevirtual 271	com/baidu/nplatform/comapi/basestruct/GeoPoint:isValid	()Z
    //   20: ifne +16 -> 36
    //   23: ldc 15
    //   25: ldc -112
    //   27: invokestatic 150	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: iconst_0
    //   31: istore_3
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_3
    //   35: ireturn
    //   36: aload_0
    //   37: aload_1
    //   38: getfield 209	com/baidu/navisdk/model/datastruct/SearchPoi:mViewPoint	Lcom/baidu/nplatform/comapi/basestruct/GeoPoint;
    //   41: invokevirtual 274	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:isPoiExistInFavByPoint	(Lcom/baidu/nplatform/comapi/basestruct/GeoPoint;)Z
    //   44: ifeq +8 -> 52
    //   47: iconst_m1
    //   48: istore_3
    //   49: goto -17 -> 32
    //   52: new 152	com/baidu/navisdk/model/datastruct/FavoritePoiInfo
    //   55: dup
    //   56: invokespecial 153	com/baidu/navisdk/model/datastruct/FavoritePoiInfo:<init>	()V
    //   59: pop
    //   60: aload_0
    //   61: aload_1
    //   62: invokespecial 276	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:searchPoiToFavPoi	(Lcom/baidu/navisdk/model/datastruct/SearchPoi;)Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 31	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavoriteControl	Lcom/baidu/navisdk/jni/control/FavoriteControlBundle;
    //   70: aload_1
    //   71: invokevirtual 251	com/baidu/navisdk/jni/control/FavoriteControlBundle:addPOI	(Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;)I
    //   74: istore_3
    //   75: iload_3
    //   76: iconst_1
    //   77: if_icmpne +15 -> 92
    //   80: aload_2
    //   81: aload_1
    //   82: invokevirtual 279	com/baidu/navisdk/model/datastruct/FavoritePoiInfo:setValue	(Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;)V
    //   85: invokestatic 256	com/baidu/navisdk/model/modelfactory/FavoriteModel:getInstance	()Lcom/baidu/navisdk/model/modelfactory/FavoriteModel;
    //   88: aload_1
    //   89: invokevirtual 260	com/baidu/navisdk/model/modelfactory/FavoriteModel:addNewFavPoiToMemList	(Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;)V
    //   92: goto -60 -> 32
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	BNFavoriteManager
    //   0	100	1	paramSearchPoi	SearchPoi
    //   0	100	2	paramFavoritePoiInfo	FavoritePoiInfo
    //   31	47	3	i	int
    // Exception table:
    //   from	to	target	type
    //   6	23	95	finally
    //   23	30	95	finally
    //   36	47	95	finally
    //   52	75	95	finally
    //   80	92	95	finally
  }
  
  public void asyncLoadFavListData(IBNFavUpdateListener paramIBNFavUpdateListener) {}
  
  public boolean cancelDataSync()
  {
    try
    {
      this.mSyncDataListener = null;
      boolean bool = this.mFavoriteControl.cancelSyncFavoritePOI();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void cleanAllFavPois()
  {
    try
    {
      if (this.mFavoriteControl.clearAllFavPois())
      {
        FavoriteModel.getInstance().clearFavDataList();
        FavoriteModel.getInstance().setFavCount(0);
        if (this.mFavUpdateListener != null) {
          this.mFavUpdateListener.onFavUpdateComplete();
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void createFavSubSystem()
  {
    this.mFavoriteControl.createFavSubSystem();
  }
  
  public SearchPoi favPoiToSearchPoi(FavoritePoiInfo paramFavoritePoiInfo)
  {
    if (paramFavoritePoiInfo == null)
    {
      LogUtil.e("Favorite", "addFavorite searchPoi is null");
      return null;
    }
    SearchPoi localSearchPoi = new SearchPoi();
    if (paramFavoritePoiInfo.mPoiId != null) {
      localSearchPoi.mOriginUID = paramFavoritePoiInfo.mPoiId;
    }
    if (paramFavoritePoiInfo.mFavName != null) {
      localSearchPoi.mName = paramFavoritePoiInfo.mFavName;
    }
    if (paramFavoritePoiInfo.mFavAddr != null) {
      localSearchPoi.mAddress = paramFavoritePoiInfo.mFavAddr;
    }
    if (paramFavoritePoiInfo.mPhone != null) {
      localSearchPoi.mPhone = paramFavoritePoiInfo.mPhone;
    }
    localSearchPoi.mType = paramFavoritePoiInfo.mPoiType;
    localSearchPoi.mViewPoint = MCTogcjPoint(paramFavoritePoiInfo.mViewPoint);
    localSearchPoi.mGuidePoint = new GeoPoint(localSearchPoi.mViewPoint);
    localSearchPoi.mDistrictId = paramFavoritePoiInfo.mFavCityId;
    return localSearchPoi;
  }
  
  public int getAllFavPoiCnt()
  {
    try
    {
      int i = this.mFavoriteControl.getPOICnt();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void getAllFavPoisFromEngineCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavPoiInfoSortBy	I
    //   6: iconst_2
    //   7: if_icmpne +46 -> 53
    //   10: ldc_w 323
    //   13: ldc_w 323
    //   16: invokestatic 328	com/baidu/navi/util/StatisticManager:onEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 31	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavoriteControl	Lcom/baidu/navisdk/jni/control/FavoriteControlBundle;
    //   23: aload_0
    //   24: getfield 60	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavPoiInfoSortBy	I
    //   27: invokevirtual 331	com/baidu/navisdk/jni/control/FavoriteControlBundle:getAllFavPoisFromEngineCache	(I)Ljava/util/ArrayList;
    //   30: astore_2
    //   31: aload_0
    //   32: invokevirtual 333	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:getAllFavPoiCnt	()I
    //   35: istore_1
    //   36: invokestatic 256	com/baidu/navisdk/model/modelfactory/FavoriteModel:getInstance	()Lcom/baidu/navisdk/model/modelfactory/FavoriteModel;
    //   39: aload_2
    //   40: invokevirtual 337	com/baidu/navisdk/model/modelfactory/FavoriteModel:setFavDataList	(Ljava/util/ArrayList;)V
    //   43: invokestatic 256	com/baidu/navisdk/model/modelfactory/FavoriteModel:getInstance	()Lcom/baidu/navisdk/model/modelfactory/FavoriteModel;
    //   46: iload_1
    //   47: invokevirtual 295	com/baidu/navisdk/model/modelfactory/FavoriteModel:setFavCount	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: ldc_w 339
    //   56: ldc_w 339
    //   59: invokestatic 328	com/baidu/navi/util/StatisticManager:onEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: goto -43 -> 19
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	BNFavoriteManager
    //   35	12	1	i	int
    //   30	10	2	localArrayList	java.util.ArrayList
    //   65	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	65	finally
    //   19	50	65	finally
    //   53	62	65	finally
  }
  
  public int getCurFavSortType()
  {
    return this.mFavPoiInfoSortBy;
  }
  
  /* Error */
  public FavoritePoiInfo getFavPoiInfoByGeoPoint(GeoPoint paramGeoPoint)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_1
    //   7: invokevirtual 271	com/baidu/nplatform/comapi/basestruct/GeoPoint:isValid	()Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifne +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: aload_1
    //   23: invokespecial 211	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:gcjToMCPoint	(Lcom/baidu/nplatform/comapi/basestruct/GeoPoint;)Lcom/baidu/nplatform/comapi/basestruct/Point;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 31	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavoriteControl	Lcom/baidu/navisdk/jni/control/FavoriteControlBundle;
    //   31: aload_1
    //   32: invokevirtual 346	com/baidu/navisdk/jni/control/FavoriteControlBundle:getFavPoiInfoByPoint	(Lcom/baidu/nplatform/comapi/basestruct/Point;)Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;
    //   35: astore_1
    //   36: goto -19 -> 17
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	BNFavoriteManager
    //   0	44	1	paramGeoPoint	GeoPoint
    //   10	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	39	finally
    //   21	36	39	finally
  }
  
  public String getFavoriteKey(SearchPoi paramSearchPoi)
  {
    return null;
  }
  
  /* Error */
  public SearchPoi getSearchPoibyKey(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 170	com/baidu/navisdk/util/common/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 31	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavoriteControl	Lcom/baidu/navisdk/jni/control/FavoriteControlBundle;
    //   22: aload_1
    //   23: invokevirtual 354	com/baidu/navisdk/jni/control/FavoriteControlBundle:getFavPoiInfoByKey	(Ljava/lang/String;)Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;
    //   26: invokevirtual 356	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:favPoiToSearchPoi	(Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;)Lcom/baidu/navisdk/model/datastruct/SearchPoi;
    //   29: astore_1
    //   30: goto -17 -> 13
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	BNFavoriteManager
    //   0	38	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   17	30	33	finally
  }
  
  public boolean isPoiExistInFavByKey(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {}
    while (this.mFavoriteControl.getFavPoiInfoByKey(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public boolean isPoiExistInFavByPoint(SearchPoi paramSearchPoi)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramSearchPoi == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      try
      {
        if (paramSearchPoi.mViewPoint == null) {
          continue;
        }
        bool1 = bool2;
        if (!paramSearchPoi.mViewPoint.isValid()) {
          continue;
        }
        bool1 = isPoiExistInFavByPoint(paramSearchPoi.mViewPoint);
      }
      finally {}
    }
  }
  
  public boolean isPoiExistInFavByPoint(GeoPoint paramGeoPoint)
  {
    try
    {
      boolean bool = isPoiExistInFavByPoint(gcjToMCPoint(paramGeoPoint));
      return bool;
    }
    finally
    {
      paramGeoPoint = finally;
      throw paramGeoPoint;
    }
  }
  
  /* Error */
  public boolean isPoiExistInFavByPoint(Point paramPoint)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavoriteControl	Lcom/baidu/navisdk/jni/control/FavoriteControlBundle;
    //   6: aload_1
    //   7: invokevirtual 346	com/baidu/navisdk/jni/control/FavoriteControlBundle:getFavPoiInfoByPoint	(Lcom/baidu/nplatform/comapi/basestruct/Point;)Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +9 -> 21
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	BNFavoriteManager
    //   0	31	1	paramPoint	Point
    //   16	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
  
  public boolean removePoiFromFavorite(SearchPoi paramSearchPoi)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramSearchPoi == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        GeoPoint localGeoPoint = paramSearchPoi.mViewPoint;
        paramSearchPoi = null;
        bool1 = bool2;
        if (localGeoPoint == null) {
          continue;
        }
        if (localGeoPoint != null) {
          paramSearchPoi = gcjToMCPoint(localGeoPoint);
        }
        paramSearchPoi = this.mFavoriteControl.getFavPoiKeyByPoint(paramSearchPoi);
        bool1 = bool2;
        if (StringUtils.isEmpty(paramSearchPoi)) {
          continue;
        }
        bool1 = removePoiFromFavorite(paramSearchPoi);
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean removePoiFromFavorite(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokestatic 170	com/baidu/navisdk/util/common/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   8: istore_3
    //   9: iload_3
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_m1
    //   18: aload_0
    //   19: getfield 31	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavoriteControl	Lcom/baidu/navisdk/jni/control/FavoriteControlBundle;
    //   22: aload_1
    //   23: invokevirtual 368	com/baidu/navisdk/jni/control/FavoriteControlBundle:removePOI	(Ljava/lang/String;)I
    //   26: if_icmpeq -13 -> 13
    //   29: invokestatic 256	com/baidu/navisdk/model/modelfactory/FavoriteModel:getInstance	()Lcom/baidu/navisdk/model/modelfactory/FavoriteModel;
    //   32: aload_1
    //   33: invokevirtual 372	com/baidu/navisdk/model/modelfactory/FavoriteModel:removeFavPoiFromMemList	(Ljava/lang/String;)V
    //   36: iconst_1
    //   37: istore_2
    //   38: goto -25 -> 13
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	BNFavoriteManager
    //   0	46	1	paramString	String
    //   1	37	2	bool1	boolean
    //   8	2	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	9	41	finally
    //   17	36	41	finally
  }
  
  public void setFavSortType(int paramInt)
  {
    this.mFavPoiInfoSortBy = paramInt;
    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt("sp_sort_type_prefer_key", paramInt);
  }
  
  public void startSyncFavoritePoi(IBNSyncDataListener paramIBNSyncDataListener)
  {
    try
    {
      this.mSyncDataListener = paramIBNSyncDataListener;
      if (NaviAccountUtils.getInstance().isLogin())
      {
        paramIBNSyncDataListener = NaviAccountUtils.getInstance().syncGetBduss();
        String str = NaviAccountUtils.getInstance().getUid();
        JNITrajectoryControl.sInstance.updateUserInfo(paramIBNSyncDataListener, str, 1);
      }
      this.mFavoriteControl.startSyncFavoritePoi();
      return;
    }
    finally {}
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
  
  /* Error */
  public int updateFavoritePoi(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokestatic 415	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifeq +9 -> 22
    //   16: iconst_m1
    //   17: istore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_3
    //   21: ireturn
    //   22: iload 4
    //   24: istore_3
    //   25: aload_1
    //   26: invokestatic 415	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne -11 -> 18
    //   32: iload 4
    //   34: istore_3
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 417	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:isPoiExistInFavByKey	(Ljava/lang/String;)Z
    //   40: ifeq -22 -> 18
    //   43: invokestatic 256	com/baidu/navisdk/model/modelfactory/FavoriteModel:getInstance	()Lcom/baidu/navisdk/model/modelfactory/FavoriteModel;
    //   46: aload_1
    //   47: invokevirtual 420	com/baidu/navisdk/model/modelfactory/FavoriteModel:getFavPoiInfoFromMemListByKey	(Ljava/lang/String;)Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;
    //   50: astore_1
    //   51: iload 4
    //   53: istore_3
    //   54: aload_1
    //   55: ifnull -37 -> 18
    //   58: new 152	com/baidu/navisdk/model/datastruct/FavoritePoiInfo
    //   61: dup
    //   62: invokespecial 153	com/baidu/navisdk/model/datastruct/FavoritePoiInfo:<init>	()V
    //   65: astore 6
    //   67: aload 6
    //   69: aload_1
    //   70: invokevirtual 279	com/baidu/navisdk/model/datastruct/FavoritePoiInfo:setValue	(Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;)V
    //   73: aload 6
    //   75: aload_2
    //   76: putfield 180	com/baidu/navisdk/model/datastruct/FavoritePoiInfo:mFavName	Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 31	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavoriteControl	Lcom/baidu/navisdk/jni/control/FavoriteControlBundle;
    //   83: aload 6
    //   85: invokevirtual 423	com/baidu/navisdk/jni/control/FavoriteControlBundle:updatePOI	(Lcom/baidu/navisdk/model/datastruct/FavoritePoiInfo;)I
    //   88: istore 4
    //   90: iload 4
    //   92: istore_3
    //   93: iload 4
    //   95: iconst_1
    //   96: if_icmpne -78 -> 18
    //   99: aload_1
    //   100: aload_2
    //   101: putfield 180	com/baidu/navisdk/model/datastruct/FavoritePoiInfo:mFavName	Ljava/lang/String;
    //   104: iload 4
    //   106: istore_3
    //   107: aload_0
    //   108: getfield 297	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavUpdateListener	Lcom/baidu/navisdk/comapi/userdata/IBNFavUpdateListener;
    //   111: ifnull -93 -> 18
    //   114: aload_0
    //   115: getfield 297	com/baidu/navisdk/comapi/userdata/BNFavoriteManager:mFavUpdateListener	Lcom/baidu/navisdk/comapi/userdata/IBNFavUpdateListener;
    //   118: invokeinterface 302 1 0
    //   123: iload 4
    //   125: istore_3
    //   126: goto -108 -> 18
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	BNFavoriteManager
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   17	109	3	i	int
    //   1	123	4	j	int
    //   9	3	5	bool	boolean
    //   65	19	6	localFavoritePoiInfo	FavoritePoiInfo
    // Exception table:
    //   from	to	target	type
    //   5	11	129	finally
    //   25	32	129	finally
    //   35	51	129	finally
    //   58	90	129	finally
    //   99	104	129	finally
    //   107	123	129	finally
  }
  
  private static class LazyHolder
  {
    private static final BNFavoriteManager sInstance = new BNFavoriteManager(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/userdata/BNFavoriteManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */