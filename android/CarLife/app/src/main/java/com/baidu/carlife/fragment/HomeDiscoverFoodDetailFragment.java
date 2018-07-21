package com.baidu.carlife.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.f.d;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.k.j;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.util.r;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.MultiImageView;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeDiscoverFoodDetailFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private com.baidu.carlife.k.i a;
  private com.baidu.carlife.k.g b;
  private j c;
  private com.baidu.carlife.k.f d;
  private com.baidu.carlife.model.e e;
  private com.baidu.carlife.model.f f;
  private int g;
  private int h;
  private com.baidu.carlife.view.dialog.f i;
  private c j;
  private c k;
  private c l;
  private CommonTipView m;
  private boolean n = false;
  private com.baidu.carlife.f.g o;
  private com.baidu.carlife.f.g p;
  private e.a q = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      com.baidu.carlife.core.screen.presentation.a.e.a().c();
      if (paramAnonymousInt == -2) {
        w.a(2131296385, 0);
      }
      do
      {
        return;
        if ((paramAnonymousInt == 0) && (HomeDiscoverFoodDetailFragment.this.isAdded()))
        {
          if (HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this) == null) {
            HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, new c(HomeDiscoverFoodDetailFragment.this.getContext()).b(2131297526).a(2131297525).q().c(2131296853).a(new b()
            {
              public void onClick()
              {
                HomeDiscoverFoodDetailFragment.this.back();
              }
            }));
          }
          HomeDiscoverFoodDetailFragment.this.showDialog(HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this));
          return;
        }
      } while (HomeDiscoverFoodDetailFragment.b(HomeDiscoverFoodDetailFragment.this) == null);
      String str = BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296385);
      if (!TextUtils.isEmpty(HomeDiscoverFoodDetailFragment.b(HomeDiscoverFoodDetailFragment.this).getErrMsg())) {
        str = HomeDiscoverFoodDetailFragment.b(HomeDiscoverFoodDetailFragment.this).getErrMsg();
      }
      w.a(str, 0);
    }
  };
  private e.a r = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      com.baidu.carlife.core.screen.presentation.a.e.a().c();
      if (paramAnonymousInt == -2) {
        w.a(2131296385, 0);
      }
      do
      {
        return;
        if (paramAnonymousInt == 0)
        {
          HomeDiscoverFoodDetailFragment.this.back();
          return;
        }
      } while (HomeDiscoverFoodDetailFragment.c(HomeDiscoverFoodDetailFragment.this) == null);
      String str = BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296385);
      if (!TextUtils.isEmpty(HomeDiscoverFoodDetailFragment.c(HomeDiscoverFoodDetailFragment.this).getErrMsg())) {
        str = HomeDiscoverFoodDetailFragment.c(HomeDiscoverFoodDetailFragment.this).getErrMsg();
      }
      w.a(str, 0);
    }
  };
  private e.a s = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      if (!HomeDiscoverFoodDetailFragment.this.isAdded()) {
        return;
      }
      HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, HomeDiscoverFoodDetailFragment.d(HomeDiscoverFoodDetailFragment.this).a());
      if (HomeDiscoverFoodDetailFragment.e(HomeDiscoverFoodDetailFragment.this) == 1)
      {
        com.baidu.carlife.core.screen.presentation.a.e.a().c();
        if (paramAnonymousInt == 0)
        {
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, HomeDiscoverFoodDetailFragment.f(HomeDiscoverFoodDetailFragment.this));
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, false);
        }
      }
      for (;;)
      {
        HomeDiscoverFoodDetailFragment.this.onInitFocusAreas();
        return;
        if (paramAnonymousInt == -2)
        {
          HomeDiscoverFoodDetailFragment.g(HomeDiscoverFoodDetailFragment.this).a(1);
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, true);
        }
        else
        {
          HomeDiscoverFoodDetailFragment.g(HomeDiscoverFoodDetailFragment.this).a(0);
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, true);
          continue;
          if (HomeDiscoverFoodDetailFragment.h(HomeDiscoverFoodDetailFragment.this) != null)
          {
            HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, new j());
            HomeDiscoverFoodDetailFragment.j(HomeDiscoverFoodDetailFragment.this).a(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).j, HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).k);
            HomeDiscoverFoodDetailFragment.j(HomeDiscoverFoodDetailFragment.this).registerResponseListener(HomeDiscoverFoodDetailFragment.k(HomeDiscoverFoodDetailFragment.this));
            HomeDiscoverFoodDetailFragment.j(HomeDiscoverFoodDetailFragment.this).toPostRequest();
            HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, false);
          }
          else if (paramAnonymousInt == -2)
          {
            com.baidu.carlife.core.screen.presentation.a.e.a().c();
            HomeDiscoverFoodDetailFragment.g(HomeDiscoverFoodDetailFragment.this).a(1);
            HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, true);
          }
          else
          {
            com.baidu.carlife.core.screen.presentation.a.e.a().c();
            HomeDiscoverFoodDetailFragment.g(HomeDiscoverFoodDetailFragment.this).a(0);
            HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, true);
          }
        }
      }
    }
  };
  private e.a t = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      if (!HomeDiscoverFoodDetailFragment.this.isAdded()) {
        return;
      }
      com.baidu.carlife.core.screen.presentation.a.e.a().c();
      Object localObject;
      label178:
      label248:
      TextView localTextView;
      if (paramAnonymousInt == 0)
      {
        HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, HomeDiscoverFoodDetailFragment.l(HomeDiscoverFoodDetailFragment.this));
        localObject = HomeDiscoverFoodDetailFragment.j(HomeDiscoverFoodDetailFragment.this).a();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, (com.baidu.carlife.model.f)HomeDiscoverFoodDetailFragment.j(HomeDiscoverFoodDetailFragment.this).a().get(0));
          localObject = (TextView)HomeDiscoverFoodDetailFragment.m(HomeDiscoverFoodDetailFragment.this).findViewById(2131624902);
          if (!TextUtils.isEmpty(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).m))
          {
            ((TextView)localObject).setText(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).m);
            localObject = (TextView)HomeDiscoverFoodDetailFragment.n(HomeDiscoverFoodDetailFragment.this).findViewById(2131624903);
            if (TextUtils.isEmpty(HomeDiscoverFoodDetailFragment.h(HomeDiscoverFoodDetailFragment.this).D)) {
              break label464;
            }
            ((TextView)localObject).setText(HomeDiscoverFoodDetailFragment.h(HomeDiscoverFoodDetailFragment.this).D);
            localObject = (Button)HomeDiscoverFoodDetailFragment.o(HomeDiscoverFoodDetailFragment.this).findViewById(2131624901);
            if (!com.baidu.carlife.model.f.a(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).l)) {
              break label473;
            }
            HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, 200);
            ((Button)localObject).setBackgroundResource(2130838208);
            ((Button)localObject).setEnabled(true);
            ((Button)localObject).setAlpha(1.0F);
            ((Button)localObject).setVisibility(0);
            ((Button)localObject).setText(2131297517);
            localObject = ((ViewStub)HomeDiscoverFoodDetailFragment.p(HomeDiscoverFoodDetailFragment.this).findViewById(2131624905)).inflate();
            localTextView = (TextView)((View)localObject).findViewById(2131625353);
            if (TextUtils.isEmpty(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).p)) {
              break label482;
            }
            localTextView.setText(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).p);
            label307:
            localTextView = (TextView)((View)localObject).findViewById(2131625354);
            if (!com.baidu.carlife.model.f.a(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).l)) {
              break label491;
            }
            localTextView.setText(HomeDiscoverFoodDetailFragment.this.getString(2131297540, new Object[] { Integer.valueOf(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).d) }));
            label366:
            localObject = (TextView)((View)localObject).findViewById(2131625355);
            if ((TextUtils.isEmpty(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).i)) || (!com.baidu.carlife.model.f.a(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).l))) {
              break label500;
            }
            ((TextView)localObject).setText(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).i);
            label422:
            HomeDiscoverFoodDetailFragment.q(HomeDiscoverFoodDetailFragment.this).findViewById(2131623980).setVisibility(0);
          }
        }
        else
        {
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, false);
        }
      }
      for (;;)
      {
        HomeDiscoverFoodDetailFragment.this.onInitFocusAreas();
        return;
        ((TextView)localObject).setText("");
        break;
        label464:
        ((TextView)localObject).setText("");
        break label178;
        label473:
        ((Button)localObject).setVisibility(8);
        break label248;
        label482:
        localTextView.setText(2131297531);
        break label307;
        label491:
        localTextView.setText(2131297531);
        break label366;
        label500:
        ((TextView)localObject).setText(2131297531);
        break label422;
        if (paramAnonymousInt == -2)
        {
          HomeDiscoverFoodDetailFragment.g(HomeDiscoverFoodDetailFragment.this).a(1);
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, true);
        }
        else
        {
          HomeDiscoverFoodDetailFragment.g(HomeDiscoverFoodDetailFragment.this).a(0);
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, true);
        }
      }
    }
  };
  
  private void a()
  {
    if (this.l == null) {
      this.l = new c(getContext()).a(2131297523).c(2131296853).d(2131296710).a(new b()
      {
        public void onClick()
        {
          com.baidu.carlife.core.screen.presentation.a.e.a().b(HomeDiscoverFoodDetailFragment.this.getString(2131296860));
          HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, new com.baidu.carlife.k.g(HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).j, HomeDiscoverFoodDetailFragment.i(HomeDiscoverFoodDetailFragment.this).k));
          HomeDiscoverFoodDetailFragment.c(HomeDiscoverFoodDetailFragment.this).registerResponseListener(HomeDiscoverFoodDetailFragment.r(HomeDiscoverFoodDetailFragment.this));
          HomeDiscoverFoodDetailFragment.c(HomeDiscoverFoodDetailFragment.this).toPostRequest();
        }
      });
    }
    showDialog(this.l);
  }
  
  private void a(View paramView)
  {
    if (this.e == null) {}
    Object localObject1;
    label449:
    label476:
    label623:
    label703:
    do
    {
      return;
      paramView.findViewById(2131624899).setVisibility(0);
      localObject1 = (MultiImageView)paramView.findViewById(2131624900);
      ((MultiImageView)localObject1).setDefaultDrawable(r.b(2130838560));
      ((MultiImageView)localObject1).setImageUrl(this.e.j);
      localObject1 = (TextView)paramView.findViewById(2131624902);
      if (this.e.n.intValue() > 0)
      {
        localObject2 = new SpannableString(String.format(getString(2131297522), new Object[] { com.baidu.carlife.model.e.a(this.e.n.intValue()) }));
        ((SpannableString)localObject2).setSpan(new RelativeSizeSpan(0.78F), 0, 2, 17);
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      localObject1 = (TextView)paramView.findViewById(2131624906);
      a(this.e.i, (TextView)localObject1);
      localObject1 = (TextView)paramView.findViewById(2131624907);
      if (!TextUtils.isEmpty(this.e.w)) {
        ((TextView)localObject1).setText(this.e.w);
      }
      localObject1 = (TextView)paramView.findViewById(2131624908);
      if (!TextUtils.isEmpty(this.e.z)) {
        ((TextView)localObject1).setText(String.format(getString(2131297529), new Object[] { this.e.z }));
      }
      localObject1 = (RatingBar)paramView.findViewById(2131624909);
      float f1 = 0.0F;
      try
      {
        float f2 = Float.parseFloat(this.e.B + "");
        f1 = f2;
      }
      catch (Exception localException)
      {
        View localView;
        TextView localTextView;
        for (;;) {}
      }
      if (f1 <= 0.0F) {
        break;
      }
      ((RatingBar)localObject1).setVisibility(0);
      ((RatingBar)localObject1).setRating(f1);
      localObject1 = (TextView)paramView.findViewById(2131624910);
      if (!TextUtils.isEmpty(this.e.x)) {
        ((TextView)localObject1).setText(this.e.x);
      }
      localObject1 = (TextView)paramView.findViewById(2131624911);
      if (this.e.A > 0) {
        ((TextView)localObject1).setText(String.format(getString(2131297530), new Object[] { Integer.valueOf(this.e.A) }));
      }
      localObject1 = (TextView)paramView.findViewById(2131624915);
      if (TextUtils.isEmpty(this.e.E)) {
        break label878;
      }
      ((TextView)localObject1).setText(this.e.E.replace("\t", "\n"));
      localObject1 = paramView.findViewById(2131624913);
      if (!com.baidu.carlife.core.f.jr) {
        break label900;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      paramView.findViewById(2131624914).setOnClickListener(this);
      localObject1 = (TextView)paramView.findViewById(2131624903);
      if (!TextUtils.isEmpty(this.e.l)) {
        ((TextView)localObject1).setText(this.e.l);
      }
      localObject2 = (Button)paramView.findViewById(2131624901);
      ((Button)localObject2).setOnClickListener(this);
      ((Button)localObject2).setBackgroundResource(2130838207);
      this.g = com.baidu.carlife.model.e.a(this.e);
      switch (this.g)
      {
      default: 
        ((Button)localObject2).setVisibility(8);
        if ((this.e.F == null) || (this.h != 1)) {
          break label1076;
        }
        if (!TextUtils.isEmpty(this.e.D)) {
          ((TextView)localObject1).setText(this.e.D);
        }
        paramView = (LinearLayout)((ViewStub)paramView.findViewById(2131624904)).inflate().findViewById(2131625466);
        localObject1 = this.e.F.iterator();
      }
    } while (!((Iterator)localObject1).hasNext());
    Object localObject2 = (com.baidu.carlife.model.f)((Iterator)localObject1).next();
    localView = View.inflate(getContext(), 2130968862, null);
    ((TextView)localView.findViewById(2131625353)).setText(((com.baidu.carlife.model.f)localObject2).b + "(" + ((com.baidu.carlife.model.f)localObject2).c + ")");
    ((TextView)localView.findViewById(2131625354)).setText(((com.baidu.carlife.model.f)localObject2).d + "桌");
    localTextView = (TextView)localView.findViewById(2131625355);
    if (TextUtils.isEmpty(((com.baidu.carlife.model.f)localObject2).i)) {
      localTextView.setText(2131297531);
    }
    for (;;)
    {
      paramView.addView(localView);
      break label703;
      ((RatingBar)localObject1).setVisibility(4);
      break;
      label878:
      ((TextView)localObject1).setVisibility(8);
      paramView.findViewById(2131624643).setVisibility(8);
      break label449;
      label900:
      ((View)localObject1).setVisibility(8);
      break label476;
      ((Button)localObject2).setEnabled(true);
      ((Button)localObject2).setAlpha(1.0F);
      ((Button)localObject2).setVisibility(0);
      ((Button)localObject2).setText(2131297516);
      break label623;
      ((Button)localObject2).setEnabled(false);
      ((Button)localObject2).setAlpha(0.2F);
      ((Button)localObject2).setVisibility(0);
      ((Button)localObject2).setText(2131297520);
      break label623;
      ((Button)localObject2).setEnabled(false);
      ((Button)localObject2).setAlpha(0.2F);
      ((Button)localObject2).setVisibility(0);
      ((Button)localObject2).setText(2131297519);
      break label623;
      ((Button)localObject2).setEnabled(false);
      ((Button)localObject2).setAlpha(0.2F);
      ((Button)localObject2).setVisibility(0);
      ((Button)localObject2).setText(2131297518);
      break label623;
      ((Button)localObject2).setEnabled(false);
      ((Button)localObject2).setAlpha(0.2F);
      ((Button)localObject2).setVisibility(0);
      ((Button)localObject2).setText(2131297521);
      break label623;
      localTextView.setText(((com.baidu.carlife.model.f)localObject2).i);
    }
    label1076:
    paramView.findViewById(2131623980).setVisibility(8);
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = paramString.indexOf("(");
      if (i1 >= 0)
      {
        SpannableString localSpannableString = new SpannableString(paramString);
        localSpannableString.setSpan(new RelativeSizeSpan(0.78F), i1, paramString.length(), 17);
        paramTextView.setText(localSpannableString);
        return;
      }
      paramTextView.setText(paramString);
      return;
    }
    paramTextView.setText("");
  }
  
  private void b()
  {
    if (this.i == null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = this.e.F.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.baidu.carlife.model.f localf = (com.baidu.carlife.model.f)((Iterator)localObject2).next();
        HashMap localHashMap = new HashMap();
        localHashMap.put("text", localf.b + "(" + localf.c + ")");
        ((List)localObject1).add(localHashMap);
      }
      localObject1 = new SimpleAdapter(getContext(), (List)localObject1, 2130968863, new String[] { "text" }, new int[] { 2131625357 });
      localObject2 = new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          HomeDiscoverFoodDetailFragment.this.dismissDialog(HomeDiscoverFoodDetailFragment.s(HomeDiscoverFoodDetailFragment.this));
          paramAnonymousAdapterView = NaviAccountUtils.getInstance().getSecurePhoneNum();
          paramAnonymousView = (com.baidu.carlife.model.f)HomeDiscoverFoodDetailFragment.h(HomeDiscoverFoodDetailFragment.this).F.get(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            com.baidu.carlife.core.screen.presentation.a.e.a().b(HomeDiscoverFoodDetailFragment.this.getString(2131296860));
            HomeDiscoverFoodDetailFragment.a(HomeDiscoverFoodDetailFragment.this, new com.baidu.carlife.k.i(paramAnonymousAdapterView, HomeDiscoverFoodDetailFragment.h(HomeDiscoverFoodDetailFragment.this).h, HomeDiscoverFoodDetailFragment.h(HomeDiscoverFoodDetailFragment.this).n.intValue(), paramAnonymousView.g, paramAnonymousView.e));
            HomeDiscoverFoodDetailFragment.b(HomeDiscoverFoodDetailFragment.this).registerResponseListener(HomeDiscoverFoodDetailFragment.t(HomeDiscoverFoodDetailFragment.this));
            HomeDiscoverFoodDetailFragment.b(HomeDiscoverFoodDetailFragment.this).toPostRequest();
          }
        }
      };
      this.i = new com.baidu.carlife.view.dialog.f(getContext(), 2131297524, (BaseAdapter)localObject1, (AdapterView.OnItemClickListener)localObject2);
    }
    if (NaviAccountUtils.getInstance().isLogin()) {
      showDialog(this.i, BaseDialog.a.b);
    }
    while (showConnectForbidDialog()) {
      return;
    }
    showFragment(548, null);
  }
  
  private void c()
  {
    if ((this.i != null) && (this.i.isShown())) {
      this.i.d();
    }
    if ((this.j != null) && (this.j.isShown())) {
      this.j.d();
    }
    if ((this.k != null) && (this.k.isShown())) {
      this.k.d();
    }
    if ((this.l != null) && (this.l.isShown())) {
      this.l.d();
    }
    dismissDialog();
  }
  
  public void driving()
  {
    com.baidu.carlife.core.i.b("yftech", "HomeDiscoverFoodDetailFragment driving");
    com.baidu.carlife.core.screen.presentation.a.e.a().c();
    c();
    back();
    back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (TextUtils.isEmpty(this.e.y))
          {
            w.a(2131297528, 0);
            return;
          }
          if (this.j == null)
          {
            this.j = new c(getContext()).g(17).b(this.e.y).q().c(2131296307).d(2131296710);
            this.j.a(new b()
            {
              public void onClick()
              {
                StatisticManager.onEvent("1042", "1042");
                q.f().a(HomeDiscoverFoodDetailFragment.this.getContext(), HomeDiscoverFoodDetailFragment.h(HomeDiscoverFoodDetailFragment.this).y);
              }
            });
          }
          showDialog(this.j);
          return;
          if (this.g != 0) {
            break;
          }
        } while (this.e.F == null);
        StatisticManager.onEvent("DISCOVER_ZMS_0002", "DISCOVER_ZMS_0002");
        b();
        return;
      } while (this.g != 200);
      StatisticManager.onEvent("1040", "1040");
      a();
      return;
    } while ((this.e == null) || (TextUtils.isEmpty(this.e.i)));
    StatisticManager.onEvent("DISCOVER_ZMS_0003", "DISCOVER_ZMS_0003");
    if (this.g == 200) {
      StatisticManager.onEvent("DISCOVER_ZMS_0004", "DISCOVER_ZMS_0004");
    }
    innerNameSearch(this.e.i);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968766, null);
    this.m = ((CommonTipView)paramLayoutInflater.findViewById(2131623981));
    Serializable localSerializable;
    if (this.mShowBundle != null)
    {
      localSerializable = this.mShowBundle.getSerializable("model");
      if (localSerializable != null) {}
    }
    else
    {
      this.m.a(0);
      setCommonTitleBar(paramLayoutInflater, null);
      return paramLayoutInflater;
    }
    if ((localSerializable instanceof com.baidu.carlife.model.f))
    {
      this.h = 0;
      this.f = ((com.baidu.carlife.model.f)localSerializable);
      setCommonTitleBar(paramLayoutInflater, this.f.q);
    }
    for (this.d = new com.baidu.carlife.k.f(this.f.r, null);; this.d = new com.baidu.carlife.k.f(this.e.h, this.e))
    {
      ((ScrollView)paramLayoutInflater.findViewById(2131624899)).setOverScrollMode(2);
      com.baidu.carlife.core.screen.presentation.a.e.a().b(getString(2131296859));
      this.d.registerResponseListener(this.s);
      this.d.toPostRequest();
      return paramLayoutInflater;
      this.h = 1;
      this.e = ((com.baidu.carlife.model.e)localSerializable);
      setCommonTitleBar(paramLayoutInflater, this.e.i);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      setBottomBarStatus(false);
    }
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onInitFocusAreas()
  {
    if (getCurrentFragmentType() != 560) {
      return;
    }
    if (this.o == null)
    {
      this.o = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131623936), 2);
      this.o.d(this.mContentView.findViewById(2131624258));
    }
    if (this.p == null)
    {
      this.p = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131624899), 6);
      if ((this.f != null) && (com.baidu.carlife.model.f.a(this.f.l))) {
        this.p.d(this.mContentView.findViewById(2131624901));
      }
      this.p.d(this.mContentView.findViewById(2131624913)).d(this.mContentView.findViewById(2131624914));
    }
    if (this.n)
    {
      d.a().b(new com.baidu.carlife.f.a[] { this.o });
      d.a().h(this.o);
      return;
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.o, this.p });
    d.a().h(this.p);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeDiscoverFoodDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */