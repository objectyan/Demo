package com.baidu.carlife.fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.util.r;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.UserCenterController;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;

public class HomeMyDetailFragment
  extends ContentFragment
{
  private g a;
  private g b;
  
  private void a()
  {
    AccountController.getInstance().logout();
    UserCenterController.getInstance().startUpdateUserInfo(0, new Handler());
  }
  
  public void driving()
  {
    i.b("yftech", "HomeMyDetailFragment driving");
    back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968769, null);
    setCommonTitleBar(paramLayoutInflater, getString(2131296530));
    TextView localTextView = (TextView)paramLayoutInflater.findViewById(2131624919);
    if (NaviAccountUtils.getInstance().isLogin())
    {
      String str = NaviAccountUtils.getInstance().getUserName();
      if (!TextUtils.isEmpty(str)) {
        localTextView.setText(str);
      }
    }
    paramLayoutInflater.findViewById(2131624920).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HomeMyDetailFragment.a(HomeMyDetailFragment.this);
        HomeMyDetailFragment.this.back();
        StatisticManager.onEvent("1057", "1057");
      }
    });
    return paramLayoutInflater;
  }
  
  public void onInitFocusAreas()
  {
    if (this.a == null)
    {
      this.a = new g(this.mContentView.findViewById(2131624259), 2);
      this.a.d(this.mContentView.findViewById(2131624258));
    }
    if (this.b == null)
    {
      this.b = new g(this.mContentView.findViewById(2131624918), 6);
      this.b.d(this.mContentView.findViewById(2131624920));
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.a, this.b });
    d.a().h(this.b);
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
    ((TextView)this.mContentView.findViewById(2131623980)).setTextColor(r.a(2131558702));
    ((TextView)this.mContentView.findViewById(2131624919)).setTextColor(r.a(2131558692));
    ((Button)this.mContentView.findViewById(2131624920)).setTextColor(r.a(2131558701));
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeMyDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */