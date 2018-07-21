package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.ufosdk.util.u;
import java.util.ArrayList;

final class t
  implements TextWatcher
{
  t(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    paramEditable = FeedbackFacePageActivity.a(this.a).getText().toString();
    if (paramEditable.length() > 10)
    {
      paramEditable = paramEditable.substring(0, 10);
      FeedbackFacePageActivity.a(this.a).setText(paramEditable.substring(0, 10));
      FeedbackFacePageActivity.a(this.a).setSelection(paramEditable.length());
      paramEditable = Toast.makeText(this.a, u.a("32"), 0);
      paramEditable.setGravity(17, 0, 0);
      paramEditable.show();
    }
    while ((FeedbackFacePageActivity.t(this.a) == null) || (FeedbackFacePageActivity.t(this.a).size() == 0)) {
      return;
    }
    FeedbackFacePageActivity.o(this.a).post(this.a.a);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */