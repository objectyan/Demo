package com.baidu.sapi2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.WebviewUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;

public class RegisterActivity
  extends Activity
{
  private SapiWebView sapiWebView;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.sapiWebView.onAuthorizedResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.sapiWebView = new SapiWebView(this);
    setContentView(this.sapiWebView);
    setupViews();
  }
  
  protected void onPause()
  {
    super.onPause();
    WebviewUtils.pauseWebview(this.sapiWebView);
  }
  
  protected void onResume()
  {
    super.onResume();
    WebviewUtils.resumeWebview(this.sapiWebView);
  }
  
  protected void setupViews()
  {
    SapiWebViewUtil.addCustomView(this, this.sapiWebView);
    this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback()
    {
      public void onFinish()
      {
        RegisterActivity.this.finish();
      }
    });
    this.sapiWebView.setAuthorizationListener(new AuthorizationListener()
    {
      public void onFailed(int paramAnonymousInt, String paramAnonymousString)
      {
        TipTool.onCreateToastDialog(RegisterActivity.this, RegisterActivity.this.getString(2131296561));
        RegisterActivity.this.finish();
      }
      
      public void onSuccess()
      {
        TipTool.onCreateToastDialog(RegisterActivity.this, RegisterActivity.this.getString(2131296562));
        RegisterActivity.this.finish();
      }
    });
    this.sapiWebView.loadRegist();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/RegisterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */