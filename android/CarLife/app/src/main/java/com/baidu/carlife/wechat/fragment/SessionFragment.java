package com.baidu.carlife.wechat.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.wechat.b.k;
import com.baidu.carlife.wechat.b.k.b;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SessionFragment
  extends a
  implements k.b
{
  private ListView b;
  private TextView c;
  private ImageButton d;
  private a e;
  
  private void a(View paramView)
  {
    this.d = ((ImageButton)paramView.findViewById(2131625230));
    this.d.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SessionFragment.this.back();
      }
    });
    this.b = ((ListView)paramView.findViewById(2131625231));
    this.c = ((TextView)paramView.findViewById(2131625232));
    this.b.setEmptyView(this.c);
    this.e = new a();
    this.b.setAdapter(this.e);
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        boolean bool2 = false;
        paramAnonymousAdapterView = SessionFragment.a(SessionFragment.this).a(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("user_name", paramAnonymousAdapterView.a().a());
          paramAnonymousView.putString("show_name", paramAnonymousAdapterView.a().b());
          boolean bool1 = bool2;
          if (paramAnonymousAdapterView.a().k())
          {
            bool1 = bool2;
            if (paramAnonymousAdapterView.a().f() == 0) {
              bool1 = true;
            }
          }
          paramAnonymousView.putBoolean("no_disturb_flag", bool1);
          SessionFragment.this.showFragment(587, paramAnonymousView);
          return;
        }
        Toast.makeText(SessionFragment.this.getActivity(), "聊天数据出错", 0).show();
      }
    });
    this.e.a();
  }
  
  public void a()
  {
    this.e.a();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968827, null);
    paramLayoutInflater.setOnClickListener(null);
    a(paramLayoutInflater);
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
    private List<com.baidu.carlife.wechat.b.a> b = null;
    private float c = com.baidu.carlife.wechat.g.c.c();
    
    public a() {}
    
    public com.baidu.carlife.wechat.b.a a(int paramInt)
    {
      if (this.b == null) {
        return null;
      }
      return (com.baidu.carlife.wechat.b.a)this.b.get(paramInt);
    }
    
    public void a()
    {
      this.b = k.a().c();
      Collections.sort(this.b, new Comparator()
      {
        public int a(com.baidu.carlife.wechat.b.a paramAnonymousa1, com.baidu.carlife.wechat.b.a paramAnonymousa2)
        {
          int i = paramAnonymousa1.c() - paramAnonymousa2.c();
          if (i != 0) {
            return i;
          }
          if (((paramAnonymousa1.b() > 0L) && (paramAnonymousa2.b() > 0L)) || ((paramAnonymousa1.b() < 0L) && (paramAnonymousa2.b() < 0L))) {
            return (int)(paramAnonymousa2.b() - paramAnonymousa1.b());
          }
          if (paramAnonymousa1.b() > 0L) {
            return -1;
          }
          return 1;
        }
      });
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      label113:
      Object localObject2;
      if (paramView == null)
      {
        localObject1 = new a();
        paramView = LayoutInflater.from(SessionFragment.this.getContext()).inflate(2130968900, paramViewGroup, false);
        ((a)localObject1).a = ((SimpleDraweeView)paramView.findViewById(2131625535));
        ((a)localObject1).c = ((TextView)paramView.findViewById(2131625536));
        ((a)localObject1).b = ((TextView)paramView.findViewById(2131625537));
        paramView.setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        localObject1 = a(paramInt);
        if (!TextUtils.isEmpty(((com.baidu.carlife.wechat.b.a)localObject1).a().e())) {
          break label306;
        }
        paramViewGroup.a.setImageResource(2130903073);
        paramViewGroup.c.setText(Html.fromHtml(((com.baidu.carlife.wechat.b.a)localObject1).a().b()));
        paramInt = k.a().d(((com.baidu.carlife.wechat.b.a)localObject1).a().a());
        if (paramInt <= 0) {
          break label371;
        }
        paramViewGroup.b.setVisibility(0);
        localObject2 = (RelativeLayout.LayoutParams)paramViewGroup.b.getLayoutParams();
        if (paramInt >= 10) {
          break label347;
        }
        ((RelativeLayout.LayoutParams)localObject2).width = ((int)(18.0F * this.c));
        label189:
        paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (paramInt <= 99) {
          break label357;
        }
        paramViewGroup.b.setText("...");
        label213:
        if ((!((com.baidu.carlife.wechat.b.a)localObject1).a().k()) || (((com.baidu.carlife.wechat.b.a)localObject1).a().f() != 0)) {
          break label392;
        }
        paramViewGroup.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130903107, 0);
        paramViewGroup.c.setCompoundDrawablePadding((int)(8.0F * com.baidu.carlife.wechat.g.c.c()));
      }
      for (;;)
      {
        paramInt = 2130838223;
        if (((com.baidu.carlife.wechat.b.a)localObject1).a().l()) {
          paramInt = 2130838820;
        }
        paramView.setBackground(SessionFragment.this.getResources().getDrawable(paramInt));
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label306:
        localObject2 = com.baidu.carlife.wechat.e.c.i() + ((com.baidu.carlife.wechat.b.a)localObject1).a().e();
        paramViewGroup.a.setImageURI((String)localObject2);
        break label113;
        label347:
        ((RelativeLayout.LayoutParams)localObject2).width = -2;
        break label189;
        label357:
        paramViewGroup.b.setText(String.valueOf(paramInt));
        break label213;
        label371:
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.b.setText("");
        break label213;
        label392:
        paramViewGroup.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        paramViewGroup.c.setCompoundDrawablePadding(0);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/SessionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */