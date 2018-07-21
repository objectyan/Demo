package com.baidu.carlife.custom.elhyf.mydvr;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.core.screen.presentation.a.f;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.custom.elhyf.a.b.b;
import com.baidu.carlife.custom.elhyf.a.b.c;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import java.util.ArrayList;

public class MyDvrFragment
  extends ContentFragment
{
  private static final String a = "video";
  private static final String b = "photo";
  private ImageButton c;
  private TextView d;
  private TextView e;
  private View f;
  private View g;
  private TextView h;
  private TextView i;
  private ListView j;
  private ListView k;
  private a l;
  private a m;
  private ArrayList<b> n;
  private ArrayList<b> o;
  private com.baidu.carlife.view.dialog.c p = null;
  private com.baidu.carlife.custom.elhyf.a.b q = null;
  
  private void a()
  {
    a.a().a(new a.a()
    {
      public void a(ArrayList<b> paramAnonymousArrayList)
      {
        if (MyDvrFragment.a(MyDvrFragment.this) != null)
        {
          MyDvrFragment.a(MyDvrFragment.this).notifyDataSetChanged();
          if (MyDvrFragment.b(MyDvrFragment.this).size() == 0) {
            MyDvrFragment.c(MyDvrFragment.this).setVisibility(0);
          }
        }
        else
        {
          return;
        }
        MyDvrFragment.c(MyDvrFragment.this).setVisibility(8);
      }
      
      public void b(ArrayList<b> paramAnonymousArrayList)
      {
        if (MyDvrFragment.d(MyDvrFragment.this) != null)
        {
          MyDvrFragment.d(MyDvrFragment.this).notifyDataSetChanged();
          if (MyDvrFragment.e(MyDvrFragment.this).size() == 0) {
            MyDvrFragment.f(MyDvrFragment.this).setVisibility(0);
          }
        }
        else
        {
          return;
        }
        MyDvrFragment.f(MyDvrFragment.this).setVisibility(8);
      }
    });
  }
  
  private void a(final b paramb)
  {
    if (this.q == null) {
      this.q = new com.baidu.carlife.custom.elhyf.a.b(getActivity());
    }
    this.q.a(new b.b()
    {
      public void a()
      {
        c.a().a(paramb.e(), c.a.a);
      }
    });
    this.q.a(new b.c()
    {
      public void a()
      {
        c.a().a(paramb.e(), c.a.b);
      }
    });
    if (this.q.isShown()) {
      this.q.d();
    }
    g.a().b().showDialog(this.q);
  }
  
  private void a(final b paramb, final String paramString)
  {
    if (this.p == null) {
      this.p = new com.baidu.carlife.view.dialog.c(getActivity()).b(2131298847).g(17).c(2131296264).q().d(2131296259);
    }
    this.p.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        if ("photo".equals(paramString))
        {
          a.a().b(paramb);
          return;
        }
        a.a().a(paramb);
      }
    });
    if (this.p.isShown()) {
      this.p.d();
    }
    if ("photo".equals(paramString)) {
      this.p.b(getString(2131298845));
    }
    for (;;)
    {
      g.a().b().showDialog(this.p);
      return;
      this.p.b(getString(2131298846));
    }
  }
  
  private void b()
  {
    this.c = ((ImageButton)this.mContentView.findViewById(2131624258));
    this.d = ((TextView)this.mContentView.findViewById(2131624921));
    this.e = ((TextView)this.mContentView.findViewById(2131624924));
    this.h = ((TextView)this.mContentView.findViewById(2131624926));
    this.i = ((TextView)this.mContentView.findViewById(2131624927));
    this.f = this.mContentView.findViewById(2131624922);
    this.g = this.mContentView.findViewById(2131624925);
    this.j = ((ListView)this.mContentView.findViewById(2131624929));
    this.k = ((ListView)this.mContentView.findViewById(2131624930));
  }
  
  private void c()
  {
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MyDvrFragment.this.getNaviFragmentManager().back();
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MyDvrFragment.g(MyDvrFragment.this);
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MyDvrFragment.h(MyDvrFragment.this);
      }
    });
  }
  
  private void d()
  {
    this.d.setTextColor(getActivity().getResources().getColor(2131558855));
    this.f.setVisibility(0);
    this.j.setVisibility(0);
    this.e.setTextColor(getActivity().getResources().getColor(2131558854));
    this.g.setVisibility(8);
    this.k.setVisibility(8);
    if (this.n.size() == 0) {
      this.h.setVisibility(0);
    }
    for (;;)
    {
      this.i.setVisibility(8);
      return;
      this.h.setVisibility(8);
    }
  }
  
  private void e()
  {
    this.e.setTextColor(getActivity().getResources().getColor(2131558855));
    this.g.setVisibility(0);
    this.k.setVisibility(0);
    this.d.setTextColor(getActivity().getResources().getColor(2131558854));
    this.f.setVisibility(8);
    this.j.setVisibility(8);
    if (this.o.size() == 0) {
      this.i.setVisibility(0);
    }
    for (;;)
    {
      this.h.setVisibility(8);
      return;
      this.i.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968770, null);
    setCommonTitleBar(paramLayoutInflater, getString(2131298844));
    return paramLayoutInflater;
  }
  
  protected void onInitView()
  {
    b();
    c();
    this.n = a.a().b();
    if (this.l == null)
    {
      if (this.n.size() != 0) {
        break label150;
      }
      this.h.setVisibility(0);
    }
    for (;;)
    {
      this.l = new a(getActivity(), this.n, "video");
      this.j.setAdapter(this.l);
      this.j.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          a.a().b(MyDvrFragment.this.getActivity(), ((b)MyDvrFragment.b(MyDvrFragment.this).get(paramAnonymousInt)).e());
        }
      });
      this.o = a.a().c();
      this.m = new a(getActivity(), this.o, "photo");
      this.k.setAdapter(this.m);
      this.k.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          a.a().a(MyDvrFragment.this.getActivity(), ((b)MyDvrFragment.e(MyDvrFragment.this).get(paramAnonymousInt)).e());
        }
      });
      return;
      label150:
      this.h.setVisibility(8);
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  private class a
    extends BaseAdapter
  {
    private ArrayList<b> b;
    private Context c;
    private String d;
    
    public a(ArrayList<b> paramArrayList, String paramString)
    {
      this.c = paramArrayList;
      this.b = paramString;
      String str;
      this.d = str;
    }
    
    public b a(int paramInt)
    {
      return null;
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = View.inflate(this.c, 2130968771, null);
      }
      paramView = (ImageView)paramViewGroup.findViewById(2131624931);
      TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131624934);
      TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131624933);
      Button localButton1 = (Button)paramViewGroup.findViewById(2131624937);
      Button localButton2 = (Button)paramViewGroup.findViewById(2131624936);
      ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131624932);
      TextView localTextView3 = (TextView)paramViewGroup.findViewById(2131624935);
      b localb = (b)this.b.get(paramInt);
      if (localb != null)
      {
        if (localb.a() == null) {
          break label224;
        }
        paramView.setImageBitmap(localb.a());
        localTextView1.setText(localb.f());
        localTextView2.setText(localb.c());
        if (localb.g() != b.a.b) {
          break label267;
        }
        localImageView.setImageResource(2130903091);
      }
      for (;;)
      {
        localTextView3.setText(localb.d() + "MB");
        localButton1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MyDvrFragment.a(MyDvrFragment.this, (b)MyDvrFragment.a.a(MyDvrFragment.a.this).get(paramInt), MyDvrFragment.a.b(MyDvrFragment.a.this));
          }
        });
        localButton2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MyDvrFragment.a(MyDvrFragment.this, (b)MyDvrFragment.a.a(MyDvrFragment.a.this).get(paramInt));
          }
        });
        return paramViewGroup;
        label224:
        if ("photo".equals(this.d))
        {
          paramView.setImageResource(2130903095);
          localButton2.setVisibility(0);
          break;
        }
        paramView.setImageResource(2130903096);
        localButton2.setVisibility(8);
        break;
        label267:
        localImageView.setImageResource(2130903092);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/mydvr/MyDvrFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */