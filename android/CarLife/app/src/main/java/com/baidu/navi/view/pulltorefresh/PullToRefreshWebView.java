package com.baidu.navi.view.pulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class PullToRefreshWebView
  extends PullToRefreshBase<WebView>
{
  private static final PullToRefreshBase.OnRefreshListener<WebView> defaultOnRefreshListener = new PullToRefreshBase.OnRefreshListener()
  {
    public void onRefresh(PullToRefreshBase<WebView> paramAnonymousPullToRefreshBase)
    {
      ((WebView)paramAnonymousPullToRefreshBase.getRefreshableView()).reload();
    }
  };
  private final WebChromeClient defaultWebChromeClient = new WebChromeClient()
  {
    public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 100) {
        PullToRefreshWebView.this.onRefreshComplete();
      }
    }
  };
  
  public PullToRefreshWebView(Context paramContext)
  {
    super(paramContext);
    setOnRefreshListener(defaultOnRefreshListener);
    ((WebView)this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
  }
  
  public PullToRefreshWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnRefreshListener(defaultOnRefreshListener);
    ((WebView)this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
  }
  
  public PullToRefreshWebView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
    setOnRefreshListener(defaultOnRefreshListener);
    ((WebView)this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
  }
  
  public PullToRefreshWebView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
    setOnRefreshListener(defaultOnRefreshListener);
    ((WebView)this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
  }
  
  protected WebView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new InternalWebViewSDK9(paramContext, paramAttributeSet);; paramContext = new WebView(paramContext, paramAttributeSet))
    {
      paramContext.setId(2131623939);
      return paramContext;
    }
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected boolean isReadyForPullEnd()
  {
    float f = ((WebView)this.mRefreshableView).getContentHeight();
    f = FloatMath.floor(((WebView)this.mRefreshableView).getScale() * f);
    return ((WebView)this.mRefreshableView).getScrollY() >= f - ((WebView)this.mRefreshableView).getHeight();
  }
  
  protected boolean isReadyForPullStart()
  {
    return ((WebView)this.mRefreshableView).getScrollY() == 0;
  }
  
  protected void onPtrRestoreInstanceState(Bundle paramBundle)
  {
    super.onPtrRestoreInstanceState(paramBundle);
    ((WebView)this.mRefreshableView).restoreState(paramBundle);
  }
  
  protected void onPtrSaveInstanceState(Bundle paramBundle)
  {
    super.onPtrSaveInstanceState(paramBundle);
    ((WebView)this.mRefreshableView).saveState(paramBundle);
  }
  
  @TargetApi(9)
  final class InternalWebViewSDK9
    extends WebView
  {
    static final int OVERSCROLL_FUZZY_THRESHOLD = 2;
    static final float OVERSCROLL_SCALE_FACTOR = 1.5F;
    
    public InternalWebViewSDK9(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private int getScrollRange()
    {
      float f = ((WebView)PullToRefreshWebView.this.mRefreshableView).getContentHeight();
      return (int)Math.max(0.0F, FloatMath.floor(((WebView)PullToRefreshWebView.this.mRefreshableView).getScale() * f) - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      OverscrollHelper.overScrollBy(PullToRefreshWebView.this, paramInt1, paramInt3, paramInt2, paramInt4, getScrollRange(), 2, 1.5F, paramBoolean);
      return bool;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/PullToRefreshWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */