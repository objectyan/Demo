package com.baidu.carlife.fragment;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.f.i;
import com.baidu.navi.fragment.ContentFragment;

public class PrivacyPolicyFragment
  extends ContentFragment
{
  private static final int a = 1;
  private g b;
  private i c;
  private WebView d;
  private String e;
  private String f;
  
  private void a()
  {
    this.d = ((WebView)this.mContentView.findViewById(2131625081));
    this.d.removeJavascriptInterface("searchBoxJavaBridge_");
    this.d.removeJavascriptInterface("accessibility");
    this.d.removeJavascriptInterface("accessibilityTraversal");
    this.d.setBackgroundColor(0);
    this.d.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    this.d.getSettings().setSupportZoom(true);
    this.d.getSettings().setBuiltInZoomControls(true);
    this.d.getSettings().setLoadWithOverviewMode(true);
    this.d.getSettings().setJavaScriptEnabled(true);
    this.d.getSettings().setAppCacheEnabled(false);
    this.d.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        PrivacyPolicyFragment.a(PrivacyPolicyFragment.this).loadUrl("javascript:" + "function addNewStyle(newStyle) {\n    var styleElement = document.getElementById('carlife_style');\n\n    if (!styleElement) {\n        styleElement = document.createElement('style');\n        styleElement.type = 'text/css';\n        styleElement.id = 'carlife_style';\n        document.getElementsByTagName('head')[0].appendChild(styleElement);\n    }\n\n    styleElement.appendChild(document.createTextNode(newStyle));\n}\n\naddNewStyle('\n                header,body,div,.baidu-attention {\n                    background: transparent !important;\n                    border-color:#111217 !important\n                }\n                body,div,header,.baidu-attention{\n                    color:white !important\n                }\n            ');");
      }
    });
    this.d.loadUrl(this.f);
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("firstEnter", true);
    localBundle.putInt("index", 1);
    showFragment(516, localBundle);
  }
  
  private void c()
  {
    if (this.d != null)
    {
      this.d.removeAllViews();
      if (this.d.getParent() != null) {
        ((ViewGroup)this.d.getParent()).removeView(this.d);
      }
      this.d.setTag(null);
      this.d.clearHistory();
      this.d.setVisibility(8);
      this.d.destroy();
      this.d = null;
    }
  }
  
  public boolean onBackPressed()
  {
    b();
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    setBottomBarStatus(false);
    this.mContentView = paramLayoutInflater.inflate(2130968812, null);
    if (this.mShowBundle != null)
    {
      this.e = this.mShowBundle.getString("bundle_title_key", "");
      this.f = this.mShowBundle.getString("bundle_url_key", "");
    }
    setCommonTitleBar(this.mContentView, this.e);
    paramLayoutInflater = (ImageButton)this.mContentView.findViewById(2131624258);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PrivacyPolicyFragment.this.onBackPressed();
        }
      });
    }
    a();
    return this.mContentView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    c();
    if (Build.VERSION.SDK_INT > 16)
    {
      if ((mActivity != null) && (!mActivity.isDestroyed())) {
        removeAllFragmentByType(517);
      }
      return;
    }
    removeAllFragmentByType(517);
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.b == null)
    {
      this.b = new g(this.mContentView.findViewById(2131624146), 2);
      this.b.d(this.mContentView.findViewById(2131624258));
    }
    if (this.c == null) {
      this.c = new i(this.d, 4);
    }
    d.a().b(new a[] { this.b, this.c });
    d.a().h(this.b);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/PrivacyPolicyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */