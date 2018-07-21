package com.baidu.carlife.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.baidu.carlife.adpter.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.b;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.k.m;
import com.baidu.carlife.logic.t;
import com.baidu.carlife.logic.t.b;
import com.baidu.carlife.model.l;
import com.baidu.carlife.util.w;
import com.baidu.navi.fragment.ContentFragment;
import java.util.ArrayList;
import java.util.List;

public class HomeMySkinFragment
  extends ContentFragment
  implements e.a, t.b
{
  private static final int a = 100;
  private f b;
  private m c;
  private List<l> d;
  private t e;
  private g f;
  private b g;
  
  private void a()
  {
    String[] arrayOfString = getResources().getStringArray(2131230729);
    this.d = new ArrayList();
    l locall1 = new l();
    locall1.d = arrayOfString[0];
    locall1.j = 0;
    locall1.k = 2130838595;
    locall1.h = "DefaultSkin";
    l locall2 = new l();
    locall2.j = 1;
    locall2.d = arrayOfString[1];
    locall2.h = "CLS_Blue.cls";
    locall2.k = 2130838596;
    locall2.e = 3;
    this.d.add(locall1);
    this.d.add(locall2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onUpdateSkin();
      return;
    }
    w.a(2131296533, 0);
  }
  
  public void driving()
  {
    i.b("yftech", "HomeMySkinFragment driving");
    back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    onUpdateSkin();
    this.e.a(this);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968839, null);
    setCommonTitleBar(paramLayoutInflater, getString(2131296532));
    GridView localGridView = (GridView)paramLayoutInflater.findViewById(2131625262);
    localGridView.setOverScrollMode(2);
    this.e = t.a();
    this.e.a(this);
    a();
    this.b = new f(getContext(), this.d);
    localGridView.setAdapter(this.b);
    localGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        i.b("Framework", "position = " + paramAnonymousInt + ", id = " + paramAnonymousLong);
        paramAnonymousView.performClick();
      }
    });
    paramLayoutInflater.findViewById(2131624059).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.e.b(this);
  }
  
  public void onInitFocusAreas()
  {
    if (this.f == null)
    {
      this.f = new g(this.mContentView.findViewById(2131624259), 2);
      this.f.d(this.mContentView.findViewById(2131624258));
    }
    if (this.g == null) {
      this.g = new b((GridView)this.mContentView.findViewById(2131625262), 6);
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.f, this.g });
    d.a().h(this.f);
  }
  
  protected void onInitView() {}
  
  public void onNetWorkResponse(int paramInt)
  {
    if (!isAdded()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.d.addAll(this.c.a());
    this.b.notifyDataSetChanged();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
    this.b.notifyDataSetChanged();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving()
  {
    i.b("yftech", "HomeMySkinFragment stopDriving");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeMySkinFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */