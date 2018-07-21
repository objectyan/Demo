package com.baidu.carlife.radio.channel;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.view.recyclingviewpager.RecyclingPagerAdapter;
import com.baidu.carlife.view.recyclingviewpager.RecyclingViewPager;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

public class RadioChannelAdapter
  extends RecyclingPagerAdapter
{
  private static final int b = Integer.MAX_VALUE;
  private List<com.baidu.carlife.radio.a.a> c = new ArrayList();
  private String d = "";
  private Context e;
  private RecyclingViewPager f;
  
  public RadioChannelAdapter(Context paramContext, RecyclingViewPager paramRecyclingViewPager)
  {
    this.e = paramContext;
    this.f = paramRecyclingViewPager;
  }
  
  private String a(com.baidu.carlife.radio.a.a parama)
  {
    if (parama == null) {
      parama = "";
    }
    String str;
    do
    {
      do
      {
        return parama;
        str = parama.b();
        parama = str;
      } while (com.baidu.carlife.util.a.a());
      if ("每日随心".equals(str)) {
        return "Daily Audio";
      }
      if ("音乐".equals(str)) {
        return "Music";
      }
      if ("儿童".equals(str)) {
        return "Children";
      }
      if ("听书".equals(str)) {
        return "Audio Book";
      }
      if ("电台".equals(str)) {
        return "Radio";
      }
      if ("语音点播".equals(str)) {
        return "VOD";
      }
      if ("情感".equals(str)) {
        return "Emotion";
      }
      if ("学习".equals(str)) {
        return "Study";
      }
      if ("新闻".equals(str)) {
        return "News";
      }
      parama = str;
    } while (!"娱乐".equals(str));
    return "Recreation";
  }
  
  public int a()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public int a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.d;
    }
    int i = 0;
    int j = a();
    while (i < j)
    {
      if (TextUtils.equals(str, ((com.baidu.carlife.radio.a.a)this.c.get(i)).a())) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.baidu.carlife.radio.a.a locala;
    if (paramView == null)
    {
      localObject = new a();
      paramView = LayoutInflater.from(this.e).inflate(2130968995, paramViewGroup, false);
      ((a)localObject).a = ((SimpleDraweeView)paramView.findViewById(2131625999));
      ((a)localObject).b = ((TextView)paramView.findViewById(2131626000));
      ((a)localObject).c = ((ImageView)paramView.findViewById(2131626001));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      locala = a(paramInt);
      if (locala != null) {
        break label165;
      }
    }
    label165:
    for (Object localObject = "";; localObject = locala.c())
    {
      localObject = com.baidu.carlife.g.a.a(paramViewGroup.a, (String)localObject, 280, 280);
      paramViewGroup.a.setController((com.facebook.drawee.g.a)localObject);
      paramViewGroup.b.setText(a(locala));
      paramViewGroup.c.setVisibility(8);
      this.f.setChildrenView(paramInt, paramView);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  public com.baidu.carlife.radio.a.a a(int paramInt)
  {
    int i = 0;
    if (this.c.size() > 0) {
      i = paramInt % this.c.size();
    }
    if ((this.c == null) || (this.c.size() == 0)) {
      return null;
    }
    return (com.baidu.carlife.radio.a.a)this.c.get(i);
  }
  
  public void a(List<com.baidu.carlife.radio.a.a> paramList)
  {
    this.c.clear();
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      if (i == 0) {
        this.d = ((com.baidu.carlife.radio.a.a)paramList.get(i)).a();
      }
      if (i % 2 == 0) {
        this.c.add(paramList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        this.c.add(0, paramList.get(i));
      }
    }
  }
  
  public int getCount()
  {
    return Integer.MAX_VALUE;
  }
  
  public static class a
  {
    SimpleDraweeView a;
    TextView b;
    ImageView c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/channel/RadioChannelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */