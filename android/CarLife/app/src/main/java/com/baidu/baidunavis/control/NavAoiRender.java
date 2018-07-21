package com.baidu.baidunavis.control;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.entity.pb.RouteItem;
import com.baidu.entity.pb.RoutePoiRec;
import com.baidu.mapframework.common.mapview.MapInfo;
import com.baidu.mapframework.common.mapview.MapInfoProvider;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.http.center.BNHttpBinaryResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.PoiDynamicMapOverlay;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.google.protobuf.micro.ByteStringMicro;

public enum NavAoiRender
{
  INSTANCE;
  
  private static final String E_NODE_NAME = "enodename";
  private static final String E_NODE_UID = "enodeuid";
  private static final String HOST = "ps.map.baidu.com";
  private static final String HTTP_QT_KEY = "qt";
  private static final String HTTP_QT_VALUE = "navrec";
  private static final String PATH = "/orc/";
  private static final int PB_LENGTH_SIGN = 32;
  private static final String SCHEME = "http";
  private static final String SESSION_ID_KEY = "sessid";
  private static final String S_NODE_NAME = "snodename";
  private static final String S_NODE_UID = "snodeuid";
  private static final String TAG = "NavAoiRender";
  private String mBid;
  private PoiDynamicMapOverlay mOverlay;
  
  private NavAoiRender() {}
  
  private String buildUrl()
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("http");
    localBuilder.encodedAuthority("ps.map.baidu.com");
    localBuilder.encodedPath("/orc/");
    localBuilder.appendQueryParameter("qt", "navrec");
    localBuilder.appendQueryParameter("sessid", BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", ""));
    localBuilder.appendQueryParameter("snodeuid", this.mBid);
    localBuilder.appendQueryParameter("snodename", null);
    localBuilder.appendQueryParameter("enodeuid", null);
    localBuilder.appendQueryParameter("enodename", null);
    return Uri.parse(localBuilder.build().toString() + SysOSAPIv2.getInstance().getPhoneInfoUrl()).buildUpon().build().toString();
  }
  
  private void clearLayer()
  {
    if (this.mOverlay != null)
    {
      this.mOverlay.clear();
      this.mOverlay.SetOverlayShow(false);
      this.mOverlay.UpdateOverlay();
      this.mOverlay = null;
    }
  }
  
  private byte[] getExtData(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length >= 32) {
        break label25;
      }
      arrayOfByte1 = arrayOfByte2;
    }
    label25:
    int j;
    int k;
    int m;
    int n;
    do
    {
      return arrayOfByte1;
      i = paramArrayOfByte[0];
      j = paramArrayOfByte[1];
      k = paramArrayOfByte[2];
      m = paramArrayOfByte[3];
      n = paramArrayOfByte.length;
      arrayOfByte1 = arrayOfByte2;
    } while (((i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF) != n - 32);
    arrayOfByte2 = new byte[n - 32];
    int i = 0;
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (i >= arrayOfByte2.length) {
        break;
      }
      arrayOfByte2[i] = paramArrayOfByte[(i + 32)];
      i += 1;
    }
  }
  
  private void updateMapLayer(byte[] paramArrayOfByte)
  {
    NavLogUtils.e("NavAoiRender", "update Layer begin");
    if (!BNavigator.getInstance().isNaviBegin()) {
      NavLogUtils.e("NavAoiRender", "aoi render not in navi, and return");
    }
    do
    {
      return;
      this.mOverlay = ((PoiDynamicMapOverlay)MapViewFactory.getInstance().getMapView().getOverlay(PoiDynamicMapOverlay.class));
    } while (this.mOverlay == null);
    this.mOverlay.setRouteExtData(paramArrayOfByte);
    paramArrayOfByte = MapInfoProvider.getMapInfo().getMapStatus();
    this.mOverlay.setLevel(paramArrayOfByte.level);
    this.mOverlay.setX(paramArrayOfByte.centerPtX);
    this.mOverlay.setY(paramArrayOfByte.centerPtY);
    this.mOverlay.setPoiUid("");
    this.mOverlay.setScene(3);
    this.mOverlay.setIsAccShow(true);
    this.mOverlay.SetOverlayShow(true);
    this.mOverlay.UpdateOverlay();
    NavLogUtils.e("NavAoiRender", "update Layer end");
  }
  
  public void clear()
  {
    if (!TextUtils.isEmpty(this.mBid))
    {
      this.mBid = null;
      clearLayer();
    }
  }
  
  public void renderAoi(String paramString)
  {
    NavLogUtils.e("NavAoiRender", "render " + paramString);
    if (TextUtils.equals(paramString, this.mBid))
    {
      NavLogUtils.e("NavAoiRender", "bid is already rendering, return");
      return;
    }
    this.mBid = paramString;
    paramString = buildUrl();
    BNHttpCenter.getInstance().get(paramString, null, new BNHttpBinaryResponseHandler()new BNHttpParams
    {
      public void onFailure(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        NavLogUtils.e("NavAoiRender", "request mz poi render date onFailure " + paramAnonymousThrowable.getMessage());
      }
      
      public void onSuccess(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        try
        {
          NavLogUtils.e("NavAoiRender", "query success, bytes length = " + paramAnonymousArrayOfByte.length);
          paramAnonymousArrayOfByte = RoutePoiRec.parseFrom(NavAoiRender.this.getExtData(paramAnonymousArrayOfByte));
          NavAoiRender.this.updateMapLayer(paramAnonymousArrayOfByte.getRecommdata(0).getRecomdata().toByteArray());
          return;
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          NavLogUtils.e("NavAoiRender", "aoi info parsing error, not a RoutePoiRec");
        }
      }
    }, new BNHttpParams());
  }
  
  public void renderAoiByStartBid()
  {
    Object localObject = new Bundle();
    if (BNRouteGuider.getInstance().getRouteInfoInUniform(2, (Bundle)localObject))
    {
      localObject = ((Bundle)localObject).getString("usStartBid");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        NavLogUtils.e("NavAoiRender", "usStartBid is empty");
        clear();
        return;
      }
      renderAoi((String)localObject);
      return;
    }
    NavLogUtils.e("NavAoiRender", "get bid return false");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavAoiRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */