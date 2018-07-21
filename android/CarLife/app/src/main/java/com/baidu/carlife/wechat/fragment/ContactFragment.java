package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.view.g;
import com.baidu.carlife.wechat.c.a.a;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactFragment
  extends a
{
  private ImageButton b;
  private ListView c;
  private TextView d;
  private a e;
  private List<com.baidu.carlife.wechat.b.b> f = null;
  
  private void a(View paramView)
  {
    this.b = ((ImageButton)paramView.findViewById(2131625217));
    this.b.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ContactFragment.this.back();
      }
    });
    this.c = ((ListView)paramView.findViewById(2131625218));
    this.d = ((TextView)paramView.findViewById(2131625219));
    this.c.setEmptyView(this.d);
    this.e = new a();
    this.c.setAdapter(this.e);
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = new com.baidu.carlife.wechat.b.a(ContactFragment.b(ContactFragment.this).a(paramAnonymousInt), 0L);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("user_name", paramAnonymousAdapterView.a().a());
        paramAnonymousView.putString("show_name", paramAnonymousAdapterView.a().b());
        if ((paramAnonymousAdapterView.a().k()) && (paramAnonymousAdapterView.a().f() == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.putBoolean("no_disturb_flag", bool);
          ContactFragment.this.showFragment(587, paramAnonymousView);
          return;
        }
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ContactFragment.a(ContactFragment.this, "正在加载微信好友。。。");
        com.baidu.carlife.wechat.c.a.a().a(new a.a()
        {
          public void a()
          {
            ContactFragment.a(ContactFragment.this);
            ContactFragment.this.b();
          }
        });
        if (com.baidu.carlife.wechat.c.a.a().d()) {
          return;
        }
        com.baidu.carlife.wechat.c.a.a().a("0");
      }
    });
  }
  
  private void a(String paramString)
  {
    g.e().a(paramString);
  }
  
  private void c()
  {
    g.e().f();
  }
  
  public void a()
  {
    this.f = null;
  }
  
  public void b()
  {
    if ((this.f == null) || (this.f.size() == 0))
    {
      this.f = com.baidu.carlife.wechat.b.c.a().h();
      Collections.sort(this.f, new Comparator()
      {
        public int a(com.baidu.carlife.wechat.b.b paramAnonymousb1, com.baidu.carlife.wechat.b.b paramAnonymousb2)
        {
          int j = paramAnonymousb1.n() - paramAnonymousb2.n();
          int i = j;
          if (j == 0) {
            i = paramAnonymousb1.c().compareTo(paramAnonymousb2.c());
          }
          return i;
        }
      });
      this.e.notifyDataSetChanged();
    }
    if (com.baidu.carlife.wechat.c.a.a().d())
    {
      com.baidu.carlife.wechat.c.a.a().a(new a.a()
      {
        public void a()
        {
          ContactFragment.a(ContactFragment.this);
          ContactFragment.this.b();
        }
      });
      a("正在加载微信好友。。。");
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968823, null);
    paramLayoutInflater.setOnClickListener(null);
    a(paramLayoutInflater);
    b();
    return paramLayoutInflater;
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  private class a
    extends BaseAdapter
  {
    public a() {}
    
    private String a(com.baidu.carlife.wechat.b.b paramb)
    {
      if (paramb.d() == 1) {
        return "星标朋友";
      }
      if (paramb.k()) {
        return "群聊";
      }
      char c = paramb.c().charAt(0);
      if ((c >= 'a') && (c <= 'z')) {
        return String.valueOf(c).toUpperCase();
      }
      return "#";
    }
    
    public com.baidu.carlife.wechat.b.b a(int paramInt)
    {
      if (ContactFragment.c(ContactFragment.this) == null) {
        return null;
      }
      return (com.baidu.carlife.wechat.b.b)ContactFragment.c(ContactFragment.this).get(paramInt);
    }
    
    public int getCount()
    {
      if (ContactFragment.c(ContactFragment.this) == null) {
        return 0;
      }
      return ContactFragment.c(ContactFragment.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      if (paramView == null)
      {
        localObject = new a();
        paramView = LayoutInflater.from(ContactFragment.this.getContext()).inflate(2130968897, paramViewGroup, false);
        ((a)localObject).b = ((TextView)paramView.findViewById(2131625531));
        ((a)localObject).a = ((SimpleDraweeView)paramView.findViewById(2131625530));
        ((a)localObject).c = ((TextView)paramView.findViewById(2131625529));
        paramView.setTag(localObject);
        paramViewGroup = (ViewGroup)localObject;
        localObject = a(paramInt);
        if ((paramInt != 0) && (TextUtils.equals(a((com.baidu.carlife.wechat.b.b)localObject), a(a(paramInt - 1))))) {
          break label205;
        }
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText(a((com.baidu.carlife.wechat.b.b)localObject));
      }
      for (;;)
      {
        String str = ((com.baidu.carlife.wechat.b.b)localObject).b();
        paramViewGroup.b.setText(Html.fromHtml(str));
        localObject = com.baidu.carlife.wechat.e.c.i() + ((com.baidu.carlife.wechat.b.b)localObject).e();
        paramViewGroup.a.setImageURI((String)localObject);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label205:
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.c.setText("");
      }
    }
    
    class a
    {
      public SimpleDraweeView a;
      public TextView b;
      public TextView c;
      
      a() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/ContactFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */