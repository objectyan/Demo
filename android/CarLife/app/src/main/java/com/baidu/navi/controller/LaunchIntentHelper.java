package com.baidu.navi.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.l;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class LaunchIntentHelper
  implements LocationChangeListener
{
  private static final int DEFAULT_SEARCH_RADIUS = 5000;
  private static final String KEY_SCREEN_ORIENTATION = "so";
  private static final String LOG_TAG = "LaunchIntentHelper";
  private static final int VIA_COUNT = 3;
  private int itemId;
  private CarlifeActivity mActivity;
  private String[] mCatalogIds;
  private String[] mCatalogNames;
  private Intent mIntent = null;
  private NaviFragmentManager mNaviFragmentManager;
  private com.baidu.carlife.core.screen.e mOnDialogListener;
  private Handler mRPHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 3: 
      case 6: 
      default: 
      case 4: 
        do
        {
          return;
          BNRoutePlaner.getInstance().removeRouteResultHandler(LaunchIntentHelper.this.mRPHandler);
        } while (LaunchIntentHelper.this.mNaviFragmentManager == null);
        LaunchIntentHelper.this.mNaviFragmentManager.showFragment(52, null);
        return;
      case 7: 
        BNRoutePlaner.getInstance().removeRouteResultHandler(LaunchIntentHelper.this.mRPHandler);
        return;
      }
      BNRoutePlaner.getInstance().removeRouteResultHandler(LaunchIntentHelper.this.mRPHandler);
    }
  };
  private Runnable mRunnable = null;
  private int mSearchRadius = 5000;
  private Uri mUri = null;
  
  public LaunchIntentHelper(CarlifeActivity paramCarlifeActivity, Intent paramIntent, com.baidu.carlife.core.screen.presentation.a.h paramh)
  {
    this.mActivity = paramCarlifeActivity;
    this.mOnDialogListener = paramh;
    this.mNaviFragmentManager = com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager();
    initCatalogItemHelper(this.mActivity);
    this.mIntent = new Intent(paramIntent);
    this.mUri = this.mIntent.getData();
  }
  
  private void calcRoute(GeoPoint paramGeoPoint, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.mActivity.getString(2131297183);
    }
    paramGeoPoint = new RoutePlanNode(paramGeoPoint, 1, str, "");
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    paramString = new ArrayList(2);
    paramString.add(getMypositionNode());
    paramString.add(paramGeoPoint);
    BNRoutePlaner.getInstance().setPointsToCalcRoute(paramString);
  }
  
  private void cancelProgressDialog()
  {
    l.a().post(new Runnable()
    {
      public void run()
      {
        com.baidu.carlife.core.screen.presentation.a.e.a().c();
      }
    });
  }
  
  private GeoPoint getMypositionGeoPoint()
  {
    GeoPoint localGeoPoint2 = GeoLocateModel.getInstance().getLastGeoPoint();
    GeoPoint localGeoPoint1;
    if (localGeoPoint2 != null)
    {
      localGeoPoint1 = localGeoPoint2;
      if (localGeoPoint2.isValid()) {}
    }
    else
    {
      LogUtil.e("LaunchIntentHelper", "Sys last known location is not valid!");
      localGeoPoint1 = BNLocationManagerProxy.getInstance().getLastValidLocation();
    }
    return localGeoPoint1;
  }
  
  private RoutePlanNode getMypositionNode()
  {
    GeoPoint localGeoPoint = getMypositionGeoPoint();
    if (localGeoPoint == null) {
      return null;
    }
    return new RoutePlanNode(localGeoPoint, 1, "我的位置", null);
  }
  
  private void handleBDNaviData()
  {
    this.mNaviFragmentManager.showFragment(554, null);
  }
  
  private void handleBDNaviGocompany()
  {
    final int i = AddressSettingModel.getCompLon(this.mActivity);
    final int j = AddressSettingModel.getCompLat(this.mActivity);
    final Object localObject = AddressSettingModel.getCompAddress(this.mActivity);
    final String str = AddressSettingModel.getCompName(this.mActivity);
    if ((i > 0) && (j > 0))
    {
      localGeoPoint = getMypositionGeoPoint();
      if ((localGeoPoint != null) && (localGeoPoint.isValid())) {
        planToCompany(i, j, (String)localObject, str);
      }
    }
    while (this.mActivity == null)
    {
      GeoPoint localGeoPoint;
      return;
      LocationManager.getInstance().addLocationChangeLister(this);
      showProgressDialog();
      this.mRunnable = new Runnable()
      {
        public void run()
        {
          LaunchIntentHelper.this.cancelProgressDialog();
          LaunchIntentHelper.this.planToCompany(i, j, localObject, str);
        }
      };
      return;
    }
    localObject = new c(this.mActivity).b(2131296284).a(2131297134).c(2131296291).q().a(new b()
    {
      public void onClick()
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("from_Fragment", 17);
        localBundle.putInt("select_point_action", 5);
        LaunchIntentHelper.this.mNaviFragmentManager.showFragment(51, localBundle);
      }
    }).d(2131296259);
    this.mOnDialogListener.showDialog((BaseDialog)localObject, BaseDialog.a.a);
  }
  
  private void handleBDNaviGohome()
  {
    final int i = AddressSettingModel.getHomeLon(this.mActivity);
    final int j = AddressSettingModel.getHomeLat(this.mActivity);
    final Object localObject = AddressSettingModel.getHomeAddress(this.mActivity);
    final String str = AddressSettingModel.getHomeName(this.mActivity);
    if ((i > 0) && (j > 0))
    {
      GeoPoint localGeoPoint = getMypositionGeoPoint();
      if ((localGeoPoint != null) && (localGeoPoint.isValid()))
      {
        planToHome(i, j, (String)localObject, str);
        return;
      }
      LocationManager.getInstance().addLocationChangeLister(this);
      showProgressDialog();
      this.mRunnable = new Runnable()
      {
        public void run()
        {
          LaunchIntentHelper.this.cancelProgressDialog();
          LaunchIntentHelper.this.planToHome(i, j, localObject, str);
        }
      };
      return;
    }
    localObject = new c(this.mActivity).b(2131296284).a(2131297135).c(2131296291).q().a(new b()
    {
      public void onClick()
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("from_Fragment", 17);
        localBundle.putInt("select_point_action", 4);
        LaunchIntentHelper.this.mNaviFragmentManager.showFragment(51, localBundle);
      }
    }).d(2131296259);
    this.mOnDialogListener.showDialog((BaseDialog)localObject);
  }
  
  private void handleBDNaviNearby(Uri paramUri)
  {
    if (paramUri == null) {}
    for (;;)
    {
      return;
      Object localObject = paramUri.getQueryParameter("radius");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        this.mSearchRadius = Integer.valueOf((String)localObject).intValue();
        if (this.mSearchRadius <= 0) {
          this.mSearchRadius = 5000;
        }
        localObject = paramUri.getQueryParameter("id");
        this.itemId = -1;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          try
          {
            this.itemId = Integer.valueOf((String)localObject).intValue();
            if ((this.itemId >= 1) && (this.itemId <= 8) && (this.mCatalogNames.length >= this.itemId) && (this.mCatalogNames.length >= this.itemId)) {
              break label151;
            }
            TipTool.onCreateToastDialog(this.mActivity, 2131298918);
            return;
          }
          catch (NumberFormatException paramUri)
          {
            TipTool.onCreateToastDialog(this.mActivity, 2131298918);
            return;
          }
        }
        else
        {
          TipTool.onCreateToastDialog(this.mActivity, 2131298918);
          return;
        }
        label151:
        paramUri = paramUri.getQueryParameter("loc");
        LogUtil.e("", "trySearchSpace locString  " + paramUri);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("incoming_type", 4);
        ((Bundle)localObject).putBoolean("poi_center_mode", true);
        ((Bundle)localObject).putString("voice_key", this.mCatalogIds[(this.itemId - 1)]);
        ((Bundle)localObject).putString("intent_api_point", paramUri);
        ((Bundle)localObject).putInt("intent_api_radius", this.mSearchRadius);
        if (this.mNaviFragmentManager == null) {
          continue;
        }
        this.mNaviFragmentManager.showFragment(34, (Bundle)localObject);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
  
  private void handleBDNaviPlan(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(2);
    boolean bool = true;
    Object localObject = paramUri.getQueryParameter("coordType");
    if ((localObject == null) || (((String)localObject).equals("bd09ll"))) {
      bool = true;
    }
    RoutePlanNode localRoutePlanNode2;
    for (;;)
    {
      localRoutePlanNode2 = parseNavNodeFromString(paramUri.getQueryParameter("dest"), bool);
      if (localRoutePlanNode2 != null) {
        break;
      }
      TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(2131296909));
      return;
      if (((String)localObject).equals("gcj02ll")) {
        bool = false;
      }
    }
    localObject = paramUri.getQueryParameter("name");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localRoutePlanNode2.mName = ((String)localObject);
    }
    RoutePlanNode localRoutePlanNode1 = parseNavNodeFromString(paramUri.getQueryParameter("start"), bool);
    localObject = localRoutePlanNode1;
    if (localRoutePlanNode1 == null) {
      localObject = getMypositionNode();
    }
    if (localObject == null)
    {
      TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(2131296908));
      return;
    }
    localArrayList.add(localObject);
    paramUri = paramUri.getQueryParameter("via");
    if (!TextUtils.isEmpty(paramUri))
    {
      paramUri = paramUri.split(":");
      if ((paramUri != null) && (paramUri.length > 0))
      {
        int j = paramUri.length;
        int i = j;
        if (j > 3) {
          i = 3;
        }
        j = 0;
        while (j < i)
        {
          localObject = parseNavNodeFromString(paramUri[j], bool);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
          j += 1;
        }
      }
    }
    localArrayList.add(localRoutePlanNode2);
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList);
  }
  
  private void handleBDNaviQuery(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    paramUri = paramUri.getQueryParameter("name");
    if (TextUtils.isEmpty(paramUri))
    {
      TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(2131298913));
      return;
    }
    handleNameSearch(paramUri);
  }
  
  private void handleBDNaviWhere()
  {
    this.mNaviFragmentManager.showFragment(17, null);
  }
  
  private void handleBaiduMapScheme(Uri paramUri)
  {
    String str = paramUri.getHost();
    if (StringUtils.isEmpty(str)) {}
    int i;
    do
    {
      do
      {
        return;
        if (str.equals("map"))
        {
          str = paramUri.getPath();
          if ((!StringUtils.isEmpty(str)) && (str.equals("/tts")))
          {
            handleTTSVoice(paramUri.getQueryParameter("action"), paramUri.getQueryParameter("ypid"));
            return;
          }
        }
        paramUri = paramUri.getQueryParameter("location");
      } while (StringUtils.isEmpty(paramUri));
      i = paramUri.indexOf(',');
    } while (i < 0);
    handleGeoLocation(paramUri.substring(0, i), paramUri.substring(i + 1), "bd09ll");
  }
  
  private void handleCustomRoute() {}
  
  private void handleGeoKeySearch(String paramString)
  {
    handleNameSearch(paramString);
  }
  
  private void handleGeoLocation(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      double d1;
      double d2;
      try
      {
        d1 = Double.parseDouble(paramString1);
        d2 = Double.parseDouble(paramString2);
        if ("bd09ll".equals(paramString3))
        {
          paramString1 = CoordinateTransformUtil.transferBD09ToGCJ02(d2, d1);
          paramString2 = new Bundle();
          paramString2.putInt("incoming_type", 87);
          paramString2.putInt("lat", paramString1.getLatitudeE6());
          paramString2.putInt("lon", paramString1.getLongitudeE6());
          this.mNaviFragmentManager.showFragment(33, paramString2);
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if ("wgs84".equals(paramString3)) {
        paramString1 = CoordinateTransformUtil.transferWGS84ToGCJ02(d2, d1);
      }
    }
  }
  
  private void handleGeoScheme(Uri paramUri)
  {
    String str2 = paramUri.toString();
    int i = str2.indexOf(',');
    int j = str2.indexOf('?');
    if ((i < 0) || (j < 0) || (i > j)) {}
    do
    {
      do
      {
        return;
        paramUri = str2.substring(4, i);
        String str1 = str2.substring(i + 1, j);
        str2 = str2.substring(j + 3);
        if ((!"0".equals(paramUri)) && (!"0".equals(str1)))
        {
          handleGeoLocation(paramUri, str1, "wgs84");
          return;
        }
      } while (StringUtils.isEmpty(str2));
      paramUri = StringUtils.getUrlDecodeString(str2);
    } while (StringUtils.isEmpty(paramUri));
    handleGeoKeySearch(paramUri);
  }
  
  private void handleNamePlan(Uri paramUri)
  {
    if (paramUri == null) {}
    Bundle localBundle;
    do
    {
      return;
      paramUri = paramUri.getQueryParameter("destname");
      if (TextUtils.isEmpty(paramUri))
      {
        TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(2131298913));
        return;
      }
      localBundle = new Bundle();
      localBundle.putInt("incoming_type", 4);
      localBundle.putBoolean("poi_center_mode", false);
      localBundle.putString("voice_key", paramUri);
    } while (this.mNaviFragmentManager == null);
    this.mNaviFragmentManager.showFragment(34, localBundle);
  }
  
  private void handleNameSearch(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("incoming_type", 4);
    localBundle.putBoolean("poi_center_mode", false);
    localBundle.putString("voice_key", paramString);
    if (this.mNaviFragmentManager != null) {
      this.mNaviFragmentManager.showFragment(34, localBundle);
    }
  }
  
  private void handleNavi(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    String[] arrayOfString = paramUri.toString().split(":");
    if ((paramUri != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[1])))
    {
      paramUri = parseGeoPointFromString(arrayOfString[1]);
      if (paramUri != null)
      {
        calcRoute(paramUri, null);
        return;
      }
      TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(2131296907));
      return;
    }
    TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getString(2131296907));
  }
  
  private void handleOpneNew(String paramString) {}
  
  private void handleShortUriScheme(Uri paramUri)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("incoming_type", 87);
    localBundle.putString("short_uri", paramUri.toString());
    this.mNaviFragmentManager.showFragment(33, localBundle);
  }
  
  private void handleTTSVoice(String paramString1, String paramString2)
  {
    Bundle localBundle;
    if (paramString1 != null)
    {
      localBundle = new Bundle();
      localBundle.putString("action", paramString1);
      if ((paramString1.equals("voicemain")) || (paramString1.equals("download")) || (paramString1.equals("record")))
      {
        if (paramString2 != null) {
          localBundle.putString("ypid", paramString2);
        }
        BNVoice.getInstance().setExternalCall(true, localBundle);
        if (this.mNaviFragmentManager.getCurrentFragmentType() != 320) {
          break label92;
        }
        BNVoice.getInstance().updateValues(localBundle, 1);
      }
    }
    return;
    label92:
    if (this.mNaviFragmentManager.findFragmentIndexInStack(320) != -1)
    {
      this.mNaviFragmentManager.backTo(320, localBundle);
      return;
    }
    this.mNaviFragmentManager.showFragment(320, localBundle);
  }
  
  private void initCatalogItemHelper(Activity paramActivity)
  {
    this.mCatalogIds = paramActivity.getResources().getStringArray(2131230766);
    this.mCatalogNames = paramActivity.getResources().getStringArray(2131230734);
  }
  
  private GeoPoint parseGeoPointFromString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.split(",");
    } while ((paramString == null) || (paramString.length != 2) || (TextUtils.isEmpty(paramString[0])) || (TextUtils.isEmpty(paramString[0])));
    try
    {
      double d = Double.valueOf(paramString[0]).doubleValue();
      paramString = new GeoPoint((int)(Double.valueOf(paramString[1]).doubleValue() * 100000.0D), (int)(100000.0D * d));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private RoutePlanNode parseNavNodeFromString(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split(",");
    if ((paramString != null) && (paramString.length >= 2) && (!TextUtils.isEmpty(paramString[0])) && (!TextUtils.isEmpty(paramString[0]))) {}
    try
    {
      double d1 = Double.valueOf(paramString[0]).doubleValue();
      double d2 = Double.valueOf(paramString[1]).doubleValue();
      if (paramBoolean)
      {
        localObject = new LocData();
        d1 = ((LocData)localObject).latitude;
        d2 = ((LocData)localObject).longitude;
      }
      Object localObject = new GeoPoint((int)(100000.0D * d2), (int)(100000.0D * d1));
      if (paramString.length > 2) {}
      for (paramString = paramString[2];; paramString = this.mActivity.getString(2131297183)) {
        return new RoutePlanNode((GeoPoint)localObject, 1, paramString, null);
      }
      return null;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private void planToCompany(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    new RoutePlanNode(paramInt2, paramInt1, 5, paramString2, paramString1);
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    paramString1 = new ArrayList(2);
    paramString1.add(getMypositionNode());
    paramString1.add(AddressSettingModel.getCompAddrNode(this.mActivity));
    BNRoutePlaner.getInstance().setPointsToCalcRoute(paramString1);
  }
  
  private void planToHome(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    paramString1 = new ArrayList(2);
    paramString1.add(getMypositionNode());
    paramString1.add(AddressSettingModel.getHomeAddrNode(this.mActivity));
    BNRoutePlaner.getInstance().setPointsToCalcRoute(paramString1);
  }
  
  private void preHandleLanuchIntent()
  {
    if (this.mNaviFragmentManager.getCurrentFragmentType() == 113)
    {
      BaiduNaviSDKManager.getInstance().quitNavi();
      this.mNaviFragmentManager.back(null);
    }
    while (this.mNaviFragmentManager.getCurrentFragmentType() != 52) {
      return;
    }
  }
  
  private void showProgressDialog()
  {
    l.a().post(new Runnable()
    {
      public void run()
      {
        com.baidu.carlife.core.screen.presentation.a.e.a().b("定位中，请稍候...");
      }
    });
  }
  
  public int getScreenOrientation()
  {
    if (this.mIntent == null) {}
    do
    {
      Object localObject;
      do
      {
        return 2;
        localObject = this.mIntent.getData();
      } while (localObject == null);
      try
      {
        localObject = ((Uri)localObject).getQueryParameter("so");
        if ("land".equals(localObject)) {
          return 0;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        return 2;
      }
    } while (!"port".equals(localUnsupportedOperationException));
    return 1;
  }
  
  public void handleLaunchIntent()
  {
    if (this.mIntent == null) {
      return;
    }
    Uri localUri = this.mIntent.getData();
    String str1;
    String str2;
    if (localUri != null)
    {
      str1 = localUri.getScheme();
      str2 = localUri.getHost();
      if (!"bdnavi".equals(str1)) {
        break label305;
      }
      if (!"query".equals(str2)) {
        break label65;
      }
      preHandleLanuchIntent();
      handleBDNaviQuery(localUri);
    }
    for (;;)
    {
      this.mIntent = null;
      return;
      label65:
      if ("plan".equals(str2))
      {
        preHandleLanuchIntent();
        handleBDNaviPlan(localUri);
      }
      else if ("nearby".equals(str2))
      {
        preHandleLanuchIntent();
        handleBDNaviNearby(localUri);
      }
      else if ("where".equals(str2))
      {
        preHandleLanuchIntent();
        handleBDNaviWhere();
      }
      else if ("gohome".equals(str2))
      {
        preHandleLanuchIntent();
        handleBDNaviGohome();
      }
      else if ("gocompany".equals(str2))
      {
        preHandleLanuchIntent();
        handleBDNaviGocompany();
      }
      else if ("data".equals(str2))
      {
        handleBDNaviData();
      }
      else if ("gohomebyshortcut".equals(str2))
      {
        preHandleLanuchIntent();
        handleBDNaviGohome();
      }
      else if ("gocompanybyshortcut".equals(str2))
      {
        preHandleLanuchIntent();
        handleBDNaviGocompany();
      }
      else if ("opennew".equals(str2))
      {
        preHandleLanuchIntent();
        handleOpneNew(this.mIntent.getStringExtra("link"));
      }
      else if ("nameplan".equals(str2))
      {
        preHandleLanuchIntent();
        handleNamePlan(localUri);
      }
      else if ("customroute".equals(str2))
      {
        preHandleLanuchIntent();
        handleCustomRoute();
        continue;
        label305:
        if ("NAVI".equals(str1))
        {
          preHandleLanuchIntent();
          handleNavi(localUri);
        }
        else if ("geo".equals(str1))
        {
          preHandleLanuchIntent();
          handleGeoScheme(localUri);
        }
        else if ("baidumap".equals(str1))
        {
          preHandleLanuchIntent();
          handleBaiduMapScheme(localUri);
        }
        else if ("http".equals(str1))
        {
          preHandleLanuchIntent();
          handleShortUriScheme(localUri);
        }
      }
    }
  }
  
  public void handleLaunchIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.mIntent = new Intent(paramIntent);
    handleLaunchIntent();
  }
  
  public Boolean isInnerIntent()
  {
    if (this.mUri == null) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public LocationChangeListener.CoordType onGetCoordType()
  {
    return LocationChangeListener.CoordType.CoordType_GCJ02;
  }
  
  public void onLocationChange(LocationManager.LocData paramLocData)
  {
    paramLocData = new Handler(Looper.getMainLooper());
    if (this.mRunnable != null)
    {
      paramLocData.post(this.mRunnable);
      this.mRunnable = null;
    }
    paramLocData.post(new Runnable()
    {
      public void run()
      {
        LocationManager.getInstance().addLocationChangeLister(LaunchIntentHelper.this);
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/LaunchIntentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */