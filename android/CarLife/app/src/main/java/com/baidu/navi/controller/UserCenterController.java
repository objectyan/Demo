package com.baidu.navi.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.baidu.navi.logic.AppCommandConst;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.ShareTools;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.trajectory.MileageInfo;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.modelfactory.FavoriteModel;
import com.baidu.navisdk.util.common.HttpUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class UserCenterController
  implements AppCommandConst
{
  private static final int K_TIMEOUT = 100000;
  private int mFavCount = 0;
  private String mMileageRank = "";
  private ShareTools mShareTool = null;
  private int mTrackCount = 0;
  private int mUnReadNewsCount = 0;
  private boolean mUpdate = false;
  
  public static UserCenterController getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public void cancelGetUserData(String paramString) {}
  
  public int getFavCount()
  {
    int j = FavoriteModel.getInstance().getFavCount();
    int i = j;
    if (j == 0)
    {
      i = BNFavoriteManager.getInstance().getAllFavPoiCnt();
      FavoriteModel.getInstance().setFavCount(i);
    }
    return i;
  }
  
  public String getMileageDecritpion()
  {
    return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString("sp_mileage_description_text", "");
  }
  
  public String getMileageRank()
  {
    return this.mMileageRank;
  }
  
  public String getScoreShopAddr()
  {
    return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString("score_shop_addr", "");
  }
  
  public int getTotalNoSyncMileage(ArrayList<MileageInfo> paramArrayList)
  {
    int i = 0;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return 0;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      i += ((MileageInfo)paramArrayList.next()).mDistance;
    }
    return i;
  }
  
  public int getTrackCount()
  {
    String str2 = "";
    String str1 = "";
    if (NaviAccountUtils.getInstance().isLogin())
    {
      str2 = NaviAccountUtils.getInstance().getUid();
      str1 = NaviAccountUtils.getInstance().syncGetBduss();
    }
    return JNITrajectoryControl.sInstance.getTrajectoryCnt(str1, str2);
  }
  
  public int getUnReadNewsSum()
  {
    return this.mUnReadNewsCount;
  }
  
  public String getUserMileageText(int paramInt)
  {
    return String.valueOf(paramInt) + "km";
  }
  
  public int getUserMileageValue()
  {
    return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt("sp_mileage_key", 0);
  }
  
  public String getUserName()
  {
    if (NaviAccountUtils.getInstance().isLogin()) {
      return NaviAccountUtils.getInstance().getUserName();
    }
    return null;
  }
  
  public String getUserScoreText(int paramInt)
  {
    return String.valueOf(paramInt) + "分";
  }
  
  public int getUserScoreValue()
  {
    return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt("sp_score_key", 0);
  }
  
  public void handleSinaCallback(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mShareTool == null) {
      this.mShareTool = new ShareTools(paramContext, 9);
    }
    this.mShareTool.onSinaAuthorizeCallback(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean hasNewNews()
  {
    int i = this.mUnReadNewsCount;
    boolean bool = BNOfflineDataManager.getInstance().isNewUpdateData();
    return (i != 0) || (bool);
  }
  
  public boolean isOfflineDataUpdate()
  {
    return BNOfflineDataManager.getInstance().isNewUpdateData();
  }
  
  public String produceUsercenteHeadUrl()
  {
    int i = GeoLocateModel.getInstance().getCurrentDistrict().mId;
    if (NaviAccountUtils.getInstance().isLogin()) {}
    for (String str = NaviAccountUtils.getInstance().syncGetBduss();; str = "-1")
    {
      Object localObject = new ArrayList();
      ((List)localObject).add(new BasicNameValuePair("bduss", str));
      ((List)localObject).add(new BasicNameValuePair("cityID", String.valueOf(i)));
      localObject = HttpUtils.calcUrlSign((List)localObject);
      return "http://usercenter.navi.baidu.com/usercenter/view" + "?bduss=" + str + "&cityID=" + String.valueOf(i) + "&sign=" + (String)localObject;
    }
  }
  
  public void resetMileageRank()
  {
    this.mMileageRank = "";
  }
  
  public void setDataUpdate(Handler paramHandler) {}
  
  public void setMileageDecription(String paramString)
  {
    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString("sp_mileage_description_text", paramString);
  }
  
  public void setMileageRank(String paramString)
  {
    this.mMileageRank = paramString;
  }
  
  public void setScoreShopAddr(String paramString)
  {
    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString("score_shop_addr", paramString);
  }
  
  public void setShareTools(ShareTools paramShareTools)
  {
    this.mShareTool = paramShareTools;
  }
  
  public void setUnReadNewsSum(int paramInt)
  {
    this.mUnReadNewsCount = paramInt;
  }
  
  public void setUserMileageValue(int paramInt)
  {
    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt("sp_mileage_key", paramInt);
  }
  
  public void setUserScoreValue(int paramInt)
  {
    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt("sp_score_key", paramInt);
  }
  
  public void startGetUserData(Handler paramHandler)
  {
    if ((NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) && (NaviAccountUtils.getInstance().isLogin())) {
      return;
    }
    this.mMileageRank = "";
  }
  
  public void startUpdateUserInfo(int paramInt, Handler paramHandler) {}
  
  private static class LazyHolder
  {
    private static UserCenterController sInstance = new UserCenterController(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/UserCenterController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */