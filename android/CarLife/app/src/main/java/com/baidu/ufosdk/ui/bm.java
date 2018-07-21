package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.d;
import com.baidu.ufosdk.util.i;

final class bm
  implements TextWatcher
{
  bm(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (!FeedbackInputActivity.K(this.a))
    {
      paramEditable = new d(this.a);
      paramEditable.b(paramEditable.b() + 1);
      FeedbackInputActivity.L(this.a);
    }
    switch (this.a.f)
    {
    }
    do
    {
      do
      {
        return;
      } while (FeedbackInputActivity.d(this.a).getText().toString().trim().length() <= 0);
      FeedbackInputActivity.j(this.a).setTextColor(i.a(a.w, a.x, a.w, a.w));
      return;
    } while (FeedbackInputActivity.d(this.a).getText().toString().trim().length() > 0);
    FeedbackInputActivity.j(this.a).setTextColor(a.x);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FeedbackInputActivity.d(this.a).getText().toString().trim().length() <= 0)
    {
      this.a.f = 0;
      return;
    }
    this.a.f = 1;
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */