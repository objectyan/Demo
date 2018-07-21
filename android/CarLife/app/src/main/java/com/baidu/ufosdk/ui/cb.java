package com.baidu.ufosdk.ui;

import android.os.AsyncTask;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class cb
  extends AsyncTask
{
  cb(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  private static Integer a()
  {
    try
    {
      Thread.sleep(280L);
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  protected final void onPreExecute()
  {
    if ((this.a.getCurrentFocus() != null) && (this.a.getCurrentFocus().getWindowToken() != null)) {
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */