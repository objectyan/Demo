package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.custom.b;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.navi.fragment.ContentFragment;

public class AuthorizationRequestHelpFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private g a;
  
  public void driving()
  {
    i.b("yftech", "CarModeOfflineDataFragment driving");
    if (b.a().b())
    {
      back();
      back();
      back();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131625185: 
      com.baidu.carlife.logic.a.a().a(false);
      return;
    }
    showFragment(540, null);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968737, null);
    setCommonTitleBar(this.mContentView, getResources().getString(2131296299));
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
    d locald = d.a();
    locald.b(new com.baidu.carlife.f.a[] { this.a });
    locald.h(this.a);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/AuthorizationRequestHelpFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */