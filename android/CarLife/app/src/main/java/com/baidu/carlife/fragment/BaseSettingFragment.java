package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.util.r;
import com.baidu.navi.fragment.ContentFragment;

public abstract class BaseSettingFragment<T extends com.baidu.carlife.c.c.a>
  extends ContentFragment
{
  private g a;
  private c b;
  private ListView c;
  private com.baidu.carlife.c.b d;
  
  protected abstract String a();
  
  protected abstract com.baidu.carlife.c.b.a<T> b();
  
  protected abstract com.baidu.carlife.c.e.b<T> c();
  
  public void driving()
  {
    i.b("yftech", "BaseSettingFragment driving");
    if (com.baidu.carlife.custom.b.a().b()) {
      backTo(531, null);
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968809, null);
    setCommonTitleBar(this.mContentView, a());
    this.c = ((ListView)this.mContentView.findViewById(2131625180));
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousView.performClick();
      }
    });
    this.d = new com.baidu.carlife.c.b();
    paramLayoutInflater = c();
    paramLayoutInflater.a(this.d);
    paramLayoutInflater.a(b());
    this.d.a(paramLayoutInflater);
    this.c.setAdapter(this.d);
    paramLayoutInflater.a();
    return this.mContentView;
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.a == null)
    {
      this.a = new g(this.mContentView.findViewById(2131624146), 2);
      this.a.d(this.mContentView.findViewById(2131624258));
    }
    if (this.b == null) {
      this.b = new c(this.c, 4);
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.a, this.b });
    d.a().h(this.b);
    this.b.e();
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
    this.c.setSelector(r.b(2130838223));
    this.c.setDivider(r.b(2131558624));
    this.c.setDividerHeight(getResources().getDimensionPixelSize(2131361846));
    this.d.notifyDataSetChanged();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/BaseSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */