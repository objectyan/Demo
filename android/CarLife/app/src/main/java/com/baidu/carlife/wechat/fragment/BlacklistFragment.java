package com.baidu.carlife.wechat.fragment;

import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlacklistFragment
  extends a
{
  private ImageButton b;
  private ListView c;
  private TextView d;
  private a e;
  private List<com.baidu.carlife.wechat.b.b> f = null;
  private Set<String> g = new HashSet();
  
  private void a()
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
    this.g = com.baidu.carlife.wechat.g.b.d();
    com.baidu.carlife.wechat.a.b.c.c("blacklistSet = " + this.g.toString());
    this.e.notifyDataSetChanged();
  }
  
  private void a(View paramView)
  {
    this.b = ((ImageButton)paramView.findViewById(2131625210));
    this.b.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BlacklistFragment.this.back();
      }
    });
    this.c = ((ListView)paramView.findViewById(2131625211));
    this.d = ((TextView)paramView.findViewById(2131625212));
    this.c.setEmptyView(this.d);
    this.e = new a();
    this.c.setAdapter(this.e);
  }
  
  private boolean a(com.baidu.carlife.wechat.b.b paramb)
  {
    String str2 = paramb.g();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramb.b();
    }
    return this.g.contains(str1);
  }
  
  private void b()
  {
    com.baidu.carlife.wechat.a.b.c.c("blacklistSet = " + this.g.toString());
    com.baidu.carlife.wechat.g.b.a(this.g);
  }
  
  private void b(com.baidu.carlife.wechat.b.b paramb)
  {
    String str2 = paramb.g();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramb.b();
    }
    this.g.add(str1);
  }
  
  private void c(com.baidu.carlife.wechat.b.b paramb)
  {
    String str2 = paramb.g();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramb.b();
    }
    this.g.remove(str1);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968821, null);
    paramLayoutInflater.setOnClickListener(null);
    a(paramLayoutInflater);
    a();
    return paramLayoutInflater;
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
  }
  
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
      if (BlacklistFragment.a(BlacklistFragment.this) == null) {
        return null;
      }
      return (com.baidu.carlife.wechat.b.b)BlacklistFragment.a(BlacklistFragment.this).get(paramInt);
    }
    
    public int getCount()
    {
      if (BlacklistFragment.a(BlacklistFragment.this) == null) {
        return 0;
      }
      return BlacklistFragment.a(BlacklistFragment.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      final Object localObject;
      if (paramView == null)
      {
        localObject = new a();
        paramView = LayoutInflater.from(BlacklistFragment.this.getContext()).inflate(2130968894, paramViewGroup, false);
        ((a)localObject).b = ((TextView)paramView.findViewById(2131625523));
        ((a)localObject).a = ((SimpleDraweeView)paramView.findViewById(2131625522));
        ((a)localObject).c = ((TextView)paramView.findViewById(2131625521));
        ((a)localObject).d = ((CheckBox)paramView.findViewById(2131625524));
        paramView.setTag(localObject);
        paramViewGroup = (ViewGroup)localObject;
        localObject = a(paramInt);
        if ((paramInt != 0) && (TextUtils.equals(a((com.baidu.carlife.wechat.b.b)localObject), a(a(paramInt - 1))))) {
          break label283;
        }
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText(a((com.baidu.carlife.wechat.b.b)localObject));
      }
      for (;;)
      {
        String str = ((com.baidu.carlife.wechat.b.b)localObject).b();
        paramViewGroup.b.setText(Html.fromHtml(str));
        str = com.baidu.carlife.wechat.e.c.i() + ((com.baidu.carlife.wechat.b.b)localObject).e();
        paramViewGroup.a.setImageURI(str);
        paramViewGroup.d.setChecked(BlacklistFragment.a(BlacklistFragment.this, (com.baidu.carlife.wechat.b.b)localObject));
        paramViewGroup.d.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (BlacklistFragment.a(BlacklistFragment.this, localObject)) {
              BlacklistFragment.b(BlacklistFragment.this, localObject);
            }
            for (;;)
            {
              BlacklistFragment.b(BlacklistFragment.this);
              return;
              BlacklistFragment.c(BlacklistFragment.this, localObject);
            }
          }
        });
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (BlacklistFragment.a(BlacklistFragment.this, localObject)) {
              BlacklistFragment.b(BlacklistFragment.this, localObject);
            }
            for (;;)
            {
              paramViewGroup.d.setChecked(BlacklistFragment.a(BlacklistFragment.this, localObject));
              BlacklistFragment.b(BlacklistFragment.this);
              return;
              BlacklistFragment.c(BlacklistFragment.this, localObject);
            }
          }
        });
        paramView.setBackground(BlacklistFragment.this.getResources().getDrawable(2130838223));
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label283:
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.c.setText("");
      }
    }
    
    class a
    {
      public SimpleDraweeView a;
      public TextView b;
      public TextView c;
      public CheckBox d;
      
      a() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/BlacklistFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */