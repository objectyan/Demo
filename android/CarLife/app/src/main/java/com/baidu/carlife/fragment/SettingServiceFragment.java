package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

public class SettingServiceFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private ImageButton a;
  private WebView b;
  private TextView c;
  private g d;
  private com.baidu.carlife.f.i e;
  
  public void driving()
  {
    com.baidu.carlife.core.i.b("yftech", "SettingServiceFragment driving");
    getNaviFragmentManager().back();
    getNaviFragmentManager().back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    back(null);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968812, null);
    setCommonTitleBar(this.mContentView, getString(2131297137));
    this.b = ((WebView)this.mContentView.findViewById(2131625081));
    this.b.removeJavascriptInterface("searchBoxJavaBridge_");
    this.b.removeJavascriptInterface("accessibility");
    this.b.removeJavascriptInterface("accessibilityTraversal");
    this.b.setBackgroundColor(0);
    this.b.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    this.b.getSettings().setSupportZoom(true);
    this.b.getSettings().setBuiltInZoomControls(true);
    this.b.getSettings().setLoadWithOverviewMode(true);
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.getSettings().setAppCacheEnabled(false);
    this.b.loadUrl("file:///android_asset/carlifeDisclaimer.html");
    return this.mContentView;
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.d == null)
    {
      this.d = new g(this.mContentView.findViewById(2131624146), 2);
      this.d.d(this.mContentView.findViewById(2131624258));
    }
    if (this.e == null) {
      this.e = new com.baidu.carlife.f.i(this.b, 4);
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.d, this.e });
    d.a().h(this.d);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/SettingServiceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */