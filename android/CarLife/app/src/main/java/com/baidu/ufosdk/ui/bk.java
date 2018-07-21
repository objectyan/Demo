package com.baidu.ufosdk.ui;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import java.net.URL;

final class bk
  implements Html.ImageGetter
{
  bk(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final Drawable getDrawable(String paramString)
  {
    try
    {
      paramString = Drawable.createFromStream(new URL(paramString).openStream(), "");
      paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */