package com.baidu.carlife.f;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.carmode.CarModeMapFragment;
import com.baidu.navi.view.ZoomButtonView.OnZoomBtnClickListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.util.ArrayList;

public class e
  extends a
  implements View.OnFocusChangeListener
{
  private ArrayList<View> v = new ArrayList();
  private View w;
  private View x;
  private ZoomButtonView.OnZoomBtnClickListener y;
  
  public e(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    paramView.setOnFocusChangeListener(this);
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    if (localMapStatus != null)
    {
      Object localObject = CoordinateTransformUtil.MC2LLE6(localMapStatus._CenterPtX, localMapStatus._CenterPtY);
      localObject = new GeoPoint(((Bundle)localObject).getInt("LLx"), ((Bundle)localObject).getInt("LLy"));
      localObject = BNMapController.getInstance().getScreenPosByGeoPos((GeoPoint)localObject);
      ((Point)localObject).x += paramInt1;
      ((Point)localObject).y += paramInt2;
      localObject = BNMapController.getInstance().getGeoPosByScreenPos(((Point)localObject).x, ((Point)localObject).y);
      localObject = CoordinateTransformUtil.LL2MC(((GeoPoint)localObject).getLongitudeE6() / 100000.0D, ((GeoPoint)localObject).getLatitudeE6() / 100000.0D);
      localMapStatus._CenterPtX = ((Bundle)localObject).getInt("MCx");
      localMapStatus._CenterPtY = ((Bundle)localObject).getInt("MCy");
      NMapControlProxy.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationPos);
      return true;
    }
    return false;
  }
  
  private boolean e(View paramView)
  {
    if ((paramView != null) && (this.v.contains(paramView)))
    {
      if (paramView.requestFocus())
      {
        a(paramView);
        i.b("FocusManager", "requestFocusForView view=" + paramView);
        this.x = paramView;
        return true;
      }
      i.d("FocusManager", "requestFocusForView view=" + paramView + " failed");
    }
    return false;
  }
  
  public static void h()
  {
    GeoPoint localGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getHeightPixels() / 2, (ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(56)) / 2);
    if (localGeoPoint != null)
    {
      ContentFragment localContentFragment = h.a().getCurrentFragment();
      if ((localContentFragment instanceof CarModeMapFragment)) {
        ((CarModeMapFragment)localContentFragment).handleLongPress(localGeoPoint);
      }
    }
  }
  
  public static boolean i()
  {
    return a(BNMapController.getInstance().getScreenWidth() / 3, 0);
  }
  
  public static boolean j()
  {
    return a(-BNMapController.getInstance().getScreenWidth() / 3, 0);
  }
  
  public static boolean k()
  {
    return a(0, BNMapController.getInstance().getScreenHeight() / 3);
  }
  
  public static boolean l()
  {
    return a(0, -BNMapController.getInstance().getScreenHeight() / 3);
  }
  
  public static boolean m()
  {
    int i = BNMapController.getInstance().getScreenHeight();
    return a(BNMapController.getInstance().getScreenWidth() / 3, -i / 3);
  }
  
  public static boolean n()
  {
    int i = BNMapController.getInstance().getScreenHeight();
    return a(-BNMapController.getInstance().getScreenWidth() / 3, -i / 3);
  }
  
  public static boolean o()
  {
    int i = BNMapController.getInstance().getScreenHeight();
    return a(BNMapController.getInstance().getScreenWidth() / 3, i / 3);
  }
  
  public static boolean p()
  {
    int i = BNMapController.getInstance().getScreenHeight();
    return a(-BNMapController.getInstance().getScreenWidth() / 3, i / 3);
  }
  
  public void a(ZoomButtonView.OnZoomBtnClickListener paramOnZoomBtnClickListener)
  {
    this.y = paramOnZoomBtnClickListener;
  }
  
  public boolean a()
  {
    View localView = null;
    if (this.x != null)
    {
      if (e(this.x)) {
        return true;
      }
      this.x = null;
    }
    if (this.w == null)
    {
      if (this.v.size() > 0) {
        localView = (View)this.v.get(0);
      }
      this.w = localView;
    }
    return e(this.w);
  }
  
  public e b(View paramView)
  {
    this.w = paramView;
    return this;
  }
  
  public e c(View paramView)
  {
    paramView.setOnKeyListener(this);
    this.v.add(paramView);
    return this;
  }
  
  public boolean d(View paramView)
  {
    Object localObject = null;
    boolean bool = this.v.remove(paramView);
    View localView;
    if (this.x == paramView)
    {
      if (this.v.size() == 0)
      {
        localView = null;
        this.x = localView;
      }
    }
    else if (this.w == paramView) {
      if (this.v.size() != 0) {
        break label80;
      }
    }
    label80:
    for (paramView = (View)localObject;; paramView = (View)this.v.get(0))
    {
      this.w = paramView;
      return bool;
      localView = (View)this.v.get(0);
      break;
    }
  }
  
  public ArrayList<View> e()
  {
    return this.v;
  }
  
  public View f()
  {
    return this.w;
  }
  
  public View g()
  {
    return this.x;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    i.b("FocusManager", "onFocusChange v=" + paramView + " hasFocus=" + paramBoolean);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onKey keyCode=").append(paramInt).append(" v=").append(paramView).append(" action=");
    if (paramKeyEvent.getAction() == 0) {}
    for (String str = "ACTION_DOWN";; str = "ACTION_UP")
    {
      i.b("FocusManager", str);
      if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0)) {}
      switch (paramInt)
      {
      default: 
        return super.onKey(paramView, paramInt, paramKeyEvent);
      }
    }
    if (this.y != null) {
      this.y.onZoomInBtnClick();
    }
    return true;
    if (this.y != null) {
      this.y.onZoomOutBtnClick();
    }
    return true;
    h();
    return true;
    k();
    return true;
    l();
    return true;
    i();
    return true;
    j();
    return true;
    n();
    return true;
    p();
    return true;
    o();
    return true;
    m();
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */