package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.map.provider.ProviderUtils;

public class RtPopupOverlayItem
{
  public int bgresid = 131;
  public String id;
  public Drawable imgdata;
  public int imgindex;
  public int showLevelMax = 100;
  public int showLevelMin = 0;
  public int x;
  public int y;
  
  public static RtPopupOverlayItem getPoiDetailRtBusTipOverlayItem(double paramDouble1, double paramDouble2, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = c.f();
    RtPopupOverlayItem localRtPopupOverlayItem = new RtPopupOverlayItem();
    localRtPopupOverlayItem.bgresid = paramInt2;
    localRtPopupOverlayItem.x = ((int)paramDouble1);
    localRtPopupOverlayItem.y = ((int)paramDouble2);
    localRtPopupOverlayItem.showLevelMin = paramInt3;
    LinearLayout localLinearLayout = new LinearLayout((Context)localObject);
    localLinearLayout.setOrientation(1);
    localObject = new TextView((Context)localObject);
    ((TextView)localObject).setMaxWidth(ProviderUtils.dip2px(150));
    ((TextView)localObject).setSingleLine(true);
    ((TextView)localObject).setTextColor(paramInt1);
    ((TextView)localObject).setText(paramString);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    localLinearLayout.layout(0, 0, localLinearLayout.getMeasuredWidth(), localLinearLayout.getMeasuredHeight());
    localLinearLayout.buildDrawingCache();
    paramString = localLinearLayout.getDrawingCache();
    if (paramString != null)
    {
      paramString = new BitmapDrawable(paramString);
      localLinearLayout.setDrawingCacheEnabled(false);
      localRtPopupOverlayItem.imgdata = paramString;
      return localRtPopupOverlayItem;
    }
    return null;
  }
  
  public int getResId()
  {
    if (this.imgdata == null) {
      return -1;
    }
    return this.imgdata.hashCode();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/RtPopupOverlayItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */