package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController;
import java.nio.ByteBuffer;

public class RGBubbleView
  implements View.OnClickListener
{
  private static final int BTN_MARGIN = 70;
  private static final int BTN_WIDTH = 80;
  private static final int mIconWidth = 88;
  private LinearLayout mBody;
  private FrameLayout.LayoutParams mBubbleLp = null;
  private GeoPoint mGeoPt = new GeoPoint();
  boolean mIsShow = false;
  private IBubbleClickListener mListener;
  private MapController mMapController;
  private View mRootView;
  private Point mScrPt = new Point(0, 0);
  private boolean mShowBtn = true;
  private TextView mTitle;
  
  public RGBubbleView(Context paramContext)
  {
    this.mRootView = JarUtils.inflate((Activity)paramContext, 1711472697, null);
    this.mBubbleLp = new FrameLayout.LayoutParams(-2, -2);
    this.mBubbleLp.gravity = 51;
    if (this.mRootView != null)
    {
      this.mBody = ((LinearLayout)this.mRootView.findViewById(1711866369));
      this.mTitle = ((TextView)this.mRootView.findViewById(1711866370));
      this.mBody.setOnClickListener(this);
      this.mRootView.setOnClickListener(this);
      this.mRootView.setVisibility(4);
    }
  }
  
  private void setPlaceBundle(Bundle paramBundle) {}
  
  private void setScrPos(int paramInt1, int paramInt2)
  {
    paramInt2 = ((View)this.mRootView.getParent()).getWidth();
    paramInt1 = paramInt2 - ScreenUtil.getInstance().dip2px(150);
    if (!this.mShowBtn) {
      paramInt1 = paramInt2 - ScreenUtil.getInstance().dip2px(70);
    }
    this.mTitle.setMaxWidth(paramInt1);
    this.mRootView.measure(0, 0);
  }
  
  public Bitmap getBubbleBmpCache(int paramInt)
  {
    if (paramInt == 1) {
      this.mRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407770));
    }
    for (;;)
    {
      this.mRootView.setDrawingCacheEnabled(true);
      this.mRootView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mRootView.layout(0, 0, this.mRootView.getMeasuredWidth(), this.mRootView.getMeasuredHeight());
      this.mRootView.buildDrawingCache();
      Bitmap localBitmap = this.mRootView.getDrawingCache();
      this.mRootView.setDrawingCacheEnabled(false);
      return localBitmap;
      this.mRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407770));
    }
  }
  
  public GeoPoint getGeoPt()
  {
    return this.mGeoPt;
  }
  
  public FrameLayout.LayoutParams getLayoutParams()
  {
    return this.mBubbleLp;
  }
  
  public byte[] getPopupBmpCacheData(int paramInt)
  {
    if (paramInt == 1) {
      this.mRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407770));
    }
    Bitmap localBitmap;
    for (;;)
    {
      this.mRootView.setDrawingCacheEnabled(true);
      this.mRootView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.mRootView.layout(0, 0, this.mRootView.getMeasuredWidth(), this.mRootView.getMeasuredHeight());
      this.mRootView.buildDrawingCache();
      localBitmap = this.mRootView.getDrawingCache();
      if (localBitmap != null) {
        break;
      }
      this.mRootView.setDrawingCacheEnabled(false);
      return null;
      this.mRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407770));
    }
    if (localBitmap.getConfig() == Bitmap.Config.ARGB_8888)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localBitmap.getWidth() * localBitmap.getHeight() * 4);
      localBitmap.copyPixelsToBuffer(localByteBuffer);
      this.mRootView.setDrawingCacheEnabled(false);
      return localByteBuffer.array();
    }
    this.mRootView.setDrawingCacheEnabled(false);
    return null;
  }
  
  public Point getScrPt()
  {
    return this.mScrPt;
  }
  
  public View getView()
  {
    return this.mRootView;
  }
  
  public void hide()
  {
    this.mIsShow = false;
    if (this.mMapController != null)
    {
      this.mMapController.clearLayer(11);
      this.mMapController.showLayer(11, false);
    }
  }
  
  public boolean isShow()
  {
    return this.mIsShow;
  }
  
  public void onClick(View paramView)
  {
    if (this.mListener == null) {}
    do
    {
      return;
      if (paramView == this.mBody)
      {
        this.mListener.onClickBody(paramView);
        return;
      }
    } while (paramView != this.mRootView);
    this.mListener.onClickBody(paramView);
  }
  
  public void setBtnShow(boolean paramBoolean)
  {
    this.mShowBtn = paramBoolean;
  }
  
  public void setClickListener(IBubbleClickListener paramIBubbleClickListener)
  {
    this.mListener = paramIBubbleClickListener;
  }
  
  public void setGeoPos(GeoPoint paramGeoPoint, int paramInt)
  {
    this.mGeoPt = paramGeoPoint;
    paramGeoPoint = this.mMapController.getScreenPosByGeoPos(this.mGeoPt);
    if (paramGeoPoint != null)
    {
      this.mScrPt = paramGeoPoint;
      setScrPos(this.mScrPt.x, this.mScrPt.y);
    }
  }
  
  public void setMapController(MapController paramMapController)
  {
    this.mMapController = paramMapController;
  }
  
  public void setTitle(String paramString, boolean paramBoolean)
  {
    this.mTitle.setSingleLine(paramBoolean);
    this.mTitle.setText(Html.fromHtml(paramString));
  }
  
  public void showBubble(GeoPoint paramGeoPoint, String paramString1, String paramString2, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramGeoPoint == null) {
      return;
    }
    setTitle(paramString1, paramBoolean);
    setGeoPos(paramGeoPoint, paramInt);
    setPlaceBundle(paramBundle);
    this.mIsShow = true;
    paramString1 = new Bundle();
    paramString2 = getBubbleBmpCache(0);
    paramString1.putInt("bshow", 1);
    paramString1.putInt("x", paramGeoPoint.getLongitudeE6());
    paramString1.putInt("y", paramGeoPoint.getLatitudeE6());
    paramString1.putInt("imgW", paramString2.getWidth());
    paramString1.putInt("imgH", paramString2.getHeight());
    if (this.mShowBtn) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString1.putInt("showLR", paramInt);
      paramString1.putInt("iconwidth", 88);
      paramString1.putInt("popname", (this.mTitle.getText().toString() + "0" + "place").hashCode());
      paramInt = 4;
      if (!this.mShowBtn) {
        paramInt = 2;
      }
      int i = 0;
      while (i < paramInt)
      {
        paramGeoPoint = getPopupBmpCacheData(i);
        paramString1.putByteArray("imgdata" + i, paramGeoPoint);
        i += 1;
      }
    }
    this.mMapController.addPopupData(paramString1);
    this.mMapController.showLayer(11, true);
    this.mMapController.updateLayer(11);
  }
  
  public void update()
  {
    Point localPoint = this.mMapController.getScreenPosByGeoPos(this.mGeoPt);
    if (localPoint != null)
    {
      this.mScrPt = localPoint;
      setScrPos(this.mScrPt.x, this.mScrPt.y);
      this.mRootView.getParent().requestLayout();
    }
  }
  
  public static abstract interface IBubbleClickListener
  {
    public abstract void onClickBody(View paramView);
    
    public abstract void onClickLeft(View paramView);
    
    public abstract void onClickRight(View paramView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/widget/RGBubbleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */