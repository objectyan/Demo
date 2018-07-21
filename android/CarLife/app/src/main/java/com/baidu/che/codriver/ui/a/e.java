package com.baidu.che.codriver.ui.a;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RatingBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.che.codriver.protocol.data.Place.DetailInfo;
import com.baidu.che.codriver.protocol.data.Place.Location;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.ui.b.b;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.a.c;
import com.baidu.che.codriver.widget.CompoundRelativeLayout;
import java.math.BigDecimal;
import java.util.List;

public class e
  extends a
  implements View.OnClickListener, h
{
  public static final String b = "NearbyAdapter";
  public static final int c = 3;
  private LayoutInflater d;
  private List<Place.Result> e;
  private com.baidu.che.codriver.ui.d.h f;
  private Context g;
  
  public e(Context paramContext)
  {
    this.g = paramContext;
    this.d = LayoutInflater.from(paramContext);
  }
  
  private void c(int paramInt)
  {
    Place.Result localResult = (Place.Result)this.e.get(paramInt);
    if (localResult.location != null)
    {
      com.baidu.che.codriver.util.h.b("NearbyAdapter", "handleRoutClick: " + paramInt);
      String str1 = new BigDecimal(localResult.location.lat * 100000.0D).toString();
      String str2 = new BigDecimal(localResult.location.lng * 100000.0D).toString();
      boolean bool = c.a().a("map", "route", new Pair[] { new Pair("lat", str1), new Pair("lng", str2), new Pair("poiName", localResult.name), new Pair("poiRegion", localResult.address) });
      com.baidu.che.codriver.util.h.b("NearbyAdapter", "handle: " + bool);
      b.b().d();
      c.a().d();
      b.b().a();
    }
  }
  
  public int a()
  {
    return (int)Math.ceil(this.e.size() / 3.0F);
  }
  
  public View a(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.g);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 0.0F));
    int i = 0;
    Object localObject;
    View localView2;
    Place.Result localResult;
    Place.DetailInfo localDetailInfo;
    double d2;
    if (i < 3)
    {
      int j = paramInt * 3 + i;
      View localView1 = this.d.inflate(2130968962, null);
      TextView localTextView3 = (TextView)localView1.findViewById(2131625847);
      localObject = (TextView)localView1.findViewById(2131625851);
      TextView localTextView1 = (TextView)localView1.findViewById(2131625850);
      RatingBar localRatingBar = (RatingBar)localView1.findViewById(2131625848);
      TextView localTextView2 = (TextView)localView1.findViewById(2131625849);
      localView2 = localView1.findViewById(2131625852);
      if (j < this.e.size())
      {
        localResult = (Place.Result)this.e.get(j);
        localDetailInfo = localResult.detailInfo;
        localTextView3.setText(String.format("%d. %s", new Object[] { Integer.valueOf(j + 1), localResult.name }));
        d2 = 0.0D;
        double d1 = d2;
        if (localDetailInfo != null)
        {
          if (localDetailInfo.price != null) {
            break label445;
          }
          ((TextView)localObject).setVisibility(4);
          label227:
          if (localDetailInfo.overallRating != null)
          {
            localRatingBar.setVisibility(0);
            localRatingBar.setRating(Float.parseFloat(localDetailInfo.overallRating));
          }
          d1 = d2;
          if (localDetailInfo.distance > 0) {
            d1 = localDetailInfo.distance;
          }
        }
        d2 = d1;
        if (d1 <= 0.0D)
        {
          d2 = d1;
          if (localResult.location != null) {
            d2 = LocationUtil.getInstance().calculateDistance(localResult.location.lat, localResult.location.lng);
          }
        }
        if (d2 >= 1000.0D)
        {
          localObject = String.format("%.1fkm", new Object[] { Double.valueOf(d2 / 1000.0D) });
          label348:
          localTextView2.setText((CharSequence)localObject);
          if (localResult.address != null) {
            break label551;
          }
          localObject = "";
          label368:
          localTextView1.setText((CharSequence)localObject);
          localView1.setTag(Integer.valueOf(j));
          localView1.setOnClickListener(this);
          super.a(localLinearLayout, (CompoundRelativeLayout)localView1, j);
          label404:
          if (a() == 1) {
            ((RelativeLayout.LayoutParams)localView2.getLayoutParams()).rightMargin = 0;
          }
          if (i != 2) {
            break label569;
          }
          localView2.setVisibility(4);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      try
      {
        label445:
        int k = (int)Float.parseFloat(localDetailInfo.price);
        if (k <= 0) {
          break label518;
        }
        ((TextView)localObject).setText("¥" + k + "/人");
        ((TextView)localObject).setVisibility(0);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        ((TextView)localObject).setVisibility(4);
      }
      break label227;
      label518:
      ((TextView)localObject).setVisibility(4);
      break label227;
      localObject = String.format("%dm", new Object[] { Integer.valueOf((int)d2) });
      break label348;
      label551:
      localObject = localResult.address;
      break label368;
      if (i <= 0) {
        break label404;
      }
      return localLinearLayout;
      label569:
      localView2.setVisibility(0);
    }
  }
  
  public void a(com.baidu.che.codriver.ui.d.h paramh)
  {
    this.f = paramh;
    this.e = paramh.a();
    com.baidu.che.codriver.util.h.b("NearbyAdapter", this.e.toString());
  }
  
  public int b()
  {
    return this.f.l;
  }
  
  public void b(int paramInt)
  {
    this.f.l = paramInt;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView.getId();
    c(i);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */