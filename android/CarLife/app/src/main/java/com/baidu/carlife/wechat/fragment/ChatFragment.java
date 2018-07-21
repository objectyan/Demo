package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.wechat.b.d;
import com.baidu.carlife.wechat.b.g;
import com.baidu.carlife.wechat.b.i;
import com.baidu.carlife.wechat.b.k;
import com.baidu.carlife.wechat.b.k.b;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChatFragment
  extends a
  implements k.b
{
  private ImageButton b;
  private TextView c;
  private ListView d;
  private a e;
  private String f = null;
  private String g = null;
  private boolean h = false;
  private List<d> i = new ArrayList();
  
  private void a(View paramView)
  {
    this.c = ((TextView)paramView.findViewById(2131625214));
    this.b = ((ImageButton)paramView.findViewById(2131625213));
    this.b.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ChatFragment.this.back();
      }
    });
    this.d = ((ListView)paramView.findViewById(2131625215));
    this.e = new a();
    this.d.setAdapter(this.e);
    this.d.setOnItemClickListener(null);
    paramView.findViewById(2131625216).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = com.baidu.carlife.wechat.b.c.a().b(ChatFragment.a(ChatFragment.this));
        com.baidu.carlife.wechat.f.b.d().a(paramAnonymousView);
      }
    });
  }
  
  private void b()
  {
    this.c.setText(this.g);
    if (!this.h)
    {
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.c.setCompoundDrawablePadding(0);
    }
    this.i.clear();
    this.i.addAll(k.a().c(this.f));
    Collections.sort(this.i, new Comparator()
    {
      public int a(d paramAnonymousd1, d paramAnonymousd2)
      {
        return (int)(paramAnonymousd1.k() - paramAnonymousd2.k());
      }
    });
    this.e.notifyDataSetChanged();
    this.d.setTranscriptMode(2);
    this.d.setSelection(this.e.getCount());
  }
  
  public void a()
  {
    b();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968822, null);
    paramLayoutInflater.setOnClickListener(null);
    a(paramLayoutInflater);
    if (this.mShowBundle != null)
    {
      this.f = this.mShowBundle.getString("user_name");
      this.g = this.mShowBundle.getString("show_name");
      this.h = this.mShowBundle.getBoolean("no_disturb_flag");
    }
    b();
    return paramLayoutInflater;
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    k.a().b(this);
  }
  
  public void onResume()
  {
    super.onResume();
    k.a().a(this);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  private class a
    extends BaseAdapter
  {
    public a() {}
    
    public d a(int paramInt)
    {
      if (ChatFragment.b(ChatFragment.this) == null) {
        return null;
      }
      return (d)ChatFragment.b(ChatFragment.this).get(paramInt);
    }
    
    public int getCount()
    {
      if (ChatFragment.b(ChatFragment.this) == null) {
        return 0;
      }
      return ChatFragment.b(ChatFragment.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (a(paramInt) == null) {}
      for (String str = ""; com.baidu.carlife.wechat.b.c.a().a(str); str = a(paramInt).d()) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2;
      if (getItemViewType(paramInt) == 0) {
        if (paramView == null)
        {
          localObject1 = new a();
          paramView = LayoutInflater.from(ChatFragment.this.getContext()).inflate(2130968895, paramViewGroup, false);
          ((a)localObject1).a = ((SimpleDraweeView)paramView.findViewById(2131625525));
          ((a)localObject1).b = ((TextView)paramView.findViewById(2131625526));
          paramView.setTag(localObject1);
          paramViewGroup = (ViewGroup)localObject1;
          localObject1 = a(paramInt);
          if (getItemViewType(paramInt) != 1) {
            break label254;
          }
          localObject2 = com.baidu.carlife.wechat.e.c.i() + com.baidu.carlife.wechat.b.c.a().f().d();
          paramViewGroup.a.setImageURI((String)localObject2);
        }
      }
      for (;;)
      {
        localObject1 = com.baidu.carlife.wechat.g.c.a((d)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label389;
        }
        paramViewGroup.b.setText("");
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        if (paramView == null)
        {
          paramView = new a();
          localObject1 = LayoutInflater.from(ChatFragment.this.getContext()).inflate(2130968896, paramViewGroup, false);
          paramView.a = ((SimpleDraweeView)((View)localObject1).findViewById(2131625528));
          paramView.b = ((TextView)((View)localObject1).findViewById(2131625527));
          ((View)localObject1).setTag(paramView);
          paramViewGroup = paramView;
          paramView = (View)localObject1;
          break;
        }
        paramViewGroup = (a)paramView.getTag();
        break;
        label254:
        if (((d)localObject1).g().k())
        {
          localObject2 = ((d)localObject1).g().d(((d)localObject1).m());
          if ((localObject2 != null) && (!TextUtils.isEmpty(((g)localObject2).d())))
          {
            localObject2 = com.baidu.carlife.wechat.e.c.i() + ((g)localObject2).d();
            paramViewGroup.a.setImageURI((String)localObject2);
          }
        }
        else if (!TextUtils.isEmpty(((d)localObject1).g().e()))
        {
          localObject2 = com.baidu.carlife.wechat.e.c.i() + ((d)localObject1).g().e();
          paramViewGroup.a.setImageURI((String)localObject2);
        }
      }
      label389:
      Object localObject1 = ((String)localObject1).trim();
      paramViewGroup.b.setText(Html.fromHtml((String)localObject1));
      return paramView;
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    class a
    {
      public SimpleDraweeView a;
      public TextView b;
      
      a() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/ChatFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */