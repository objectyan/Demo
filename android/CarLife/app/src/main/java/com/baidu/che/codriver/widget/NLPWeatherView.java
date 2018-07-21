package com.baidu.che.codriver.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.che.codriver.protocol.data.nlp.WeatherData;
import com.baidu.che.codriver.protocol.data.nlp.WeatherData.WeatherDetail;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.l;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.util.r;
import java.util.List;

public class NLPWeatherView
  extends LinearLayout
{
  public static final String a = NLPWeatherView.class.getSimpleName();
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private Context n;
  
  public NLPWeatherView(Context paramContext)
  {
    super(paramContext, null);
    this.n = paramContext;
  }
  
  public NLPWeatherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.n = paramContext;
  }
  
  public NLPWeatherView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.n = paramContext;
  }
  
  private int a(String paramString)
  {
    String[] arrayOfString = paramString.split("/");
    int i1;
    int i2;
    if (arrayOfString.length == 1)
    {
      paramString = paramString.split("~");
      if (paramString.length > 1)
      {
        i1 = Integer.parseInt(paramString[0].substring(0, paramString[0].length() - 1));
        i2 = Integer.parseInt(paramString[1].substring(0, paramString[1].length() - 1));
      }
    }
    for (;;)
    {
      return (i1 + i2) / 2;
      i1 = 0;
      i2 = 40;
      continue;
      i2 = Integer.parseInt(arrayOfString[0].substring(0, arrayOfString[0].length() - 1));
      i1 = Integer.parseInt(arrayOfString[1].substring(0, arrayOfString[1].length() - 1));
    }
  }
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131625303));
    this.c = ((TextView)findViewById(2131625310));
    this.d = ((TextView)findViewById(2131625307));
    this.e = ((TextView)findViewById(2131625304));
    this.f = ((TextView)findViewById(2131625309));
    this.k = ((ImageView)findViewById(2131625308));
    this.g = ((TextView)findViewById(2131625312));
    this.h = ((TextView)findViewById(2131625313));
    this.l = ((ImageView)findViewById(2131625311));
    this.m = ((ImageView)findViewById(2131625314));
    this.i = ((TextView)findViewById(2131625315));
    this.j = ((TextView)findViewById(2131625316));
  }
  
  private void setWeatherPic(String paramString, ImageView paramImageView)
  {
    int i1 = r.a(paramString);
    if (i1 == 1) {
      paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839554));
    }
    do
    {
      return;
      if ((i1 == 2) || (i1 == 3))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839543));
        return;
      }
      if (((i1 >= 4) && (i1 <= 13)) || (i1 == 20) || ((i1 >= 22) && (i1 <= 26)))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839548));
        return;
      }
      if (((i1 >= 14) && (i1 <= 18)) || ((i1 >= 27) && (i1 <= 29)))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839552));
        return;
      }
      if ((i1 == 19) || (i1 == 33))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839545));
        return;
      }
      if ((i1 == 21) || ((i1 >= 30) && (i1 <= 32)))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839550));
        return;
      }
      if ((paramString != null) && (paramString.contains("雨")))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839548));
        return;
      }
    } while ((paramString == null) || (!paramString.contains("雪")));
    paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839552));
  }
  
  private void setWeatherPicB(String paramString, ImageView paramImageView)
  {
    int i1 = r.a(paramString);
    if (i1 == 1) {
      paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839555));
    }
    do
    {
      return;
      if ((i1 == 2) || (i1 == 3))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839544));
        return;
      }
      if (((i1 >= 4) && (i1 <= 13)) || (i1 == 20) || ((i1 >= 22) && (i1 <= 26)))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839549));
        return;
      }
      if (((i1 >= 14) && (i1 <= 18)) || ((i1 >= 27) && (i1 <= 29)))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839553));
        return;
      }
      if ((i1 == 19) || (i1 == 33))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839546));
        return;
      }
      if ((i1 == 21) || ((i1 >= 30) && (i1 <= 32)))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839551));
        return;
      }
      if ((paramString != null) && (paramString.contains("雨")))
      {
        paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839549));
        return;
      }
    } while ((paramString == null) || (!paramString.contains("雪")));
    paramImageView.setImageDrawable(this.n.getResources().getDrawable(2130839553));
  }
  
  public void a(b paramb)
  {
    h.b(a, "updateWeatherInfo");
    for (;;)
    {
      int i1;
      GradientDrawable localGradientDrawable;
      try
      {
        paramb = ((l)paramb).a;
        if (paramb.currentTemp != null)
        {
          paramb.currentTemp = paramb.currentTemp.replace("℃", "°");
          this.b.setText(paramb.currentTemp);
          if (paramb.city == null) {
            break label736;
          }
          this.c.setText(paramb.city);
          if ((paramb.pm25Level == null) || (paramb.pm25 == null)) {
            break label723;
          }
          i1 = Integer.parseInt(paramb.pm25);
          localGradientDrawable = (GradientDrawable)this.d.getBackground();
          if (i1 <= 50)
          {
            localGradientDrawable.setColor(this.n.getResources().getColor(2131558831));
            this.d.setText(paramb.pm25Level);
            if ((paramb.list == null) || (paramb.list.size() < 0)) {
              break;
            }
            this.f.setText(((WeatherData.WeatherDetail)paramb.list.get(0)).weather);
            setWeatherPic(((WeatherData.WeatherDetail)paramb.list.get(0)).weather, this.k);
            ((WeatherData.WeatherDetail)paramb.list.get(0)).temp = ((WeatherData.WeatherDetail)paramb.list.get(0)).temp.replace("℃", "°");
            this.e.setText("今天：" + ((WeatherData.WeatherDetail)paramb.list.get(0)).temp);
            if (paramb.list.size() < 2) {
              return;
            }
            ((WeatherData.WeatherDetail)paramb.list.get(1)).temp = ((WeatherData.WeatherDetail)paramb.list.get(1)).temp.replace("℃", "°");
            this.g.setText(((WeatherData.WeatherDetail)paramb.list.get(1)).temp);
            this.h.setText(((WeatherData.WeatherDetail)paramb.list.get(1)).weather);
            setWeatherPicB(((WeatherData.WeatherDetail)paramb.list.get(1)).weather, this.l);
            ((WeatherData.WeatherDetail)paramb.list.get(2)).temp = ((WeatherData.WeatherDetail)paramb.list.get(2)).temp.replace("℃", "°");
            this.i.setText(((WeatherData.WeatherDetail)paramb.list.get(2)).temp);
            this.j.setText(((WeatherData.WeatherDetail)paramb.list.get(2)).weather);
            setWeatherPicB(((WeatherData.WeatherDetail)paramb.list.get(2)).weather, this.m);
          }
        }
        else
        {
          this.b.setText(a(((WeatherData.WeatherDetail)paramb.list.get(0)).temp) + "°");
          continue;
        }
        if (i1 > 100) {
          break label622;
        }
      }
      catch (Exception paramb)
      {
        paramb.printStackTrace();
        h.e(a, 9 + paramb.getMessage().toString());
        return;
      }
      localGradientDrawable.setColor(this.n.getResources().getColor(2131558832));
      continue;
      label622:
      if (i1 <= 150)
      {
        localGradientDrawable.setColor(this.n.getResources().getColor(2131558833));
      }
      else if (i1 <= 200)
      {
        localGradientDrawable.setColor(this.n.getResources().getColor(2131558834));
      }
      else if (i1 <= 300)
      {
        localGradientDrawable.setColor(this.n.getResources().getColor(2131558835));
      }
      else
      {
        localGradientDrawable.setColor(this.n.getResources().getColor(2131558836));
        continue;
        label723:
        this.d.setText("暂无");
        continue;
        label736:
        this.c.setText("暂无数据");
        this.d.setText("暂无");
      }
    }
    this.f.setText("暂无数据");
    this.e.setText("今天：暂无数据");
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/NLPWeatherView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */