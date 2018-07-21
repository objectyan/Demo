package com.baidu.navi.view.pulltorefresh.internal;

import com.baidu.navisdk.util.common.LogUtil;

public class Utils
{
  static final String LOG_TAG = "PullToRefresh";
  
  public static void warnDeprecation(String paramString1, String paramString2)
  {
    LogUtil.e("PullToRefresh", "You're using the deprecated " + paramString1 + " attr, please switch over to " + paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/internal/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */