package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

final class cy
  implements TextWatcher
{
  cy(cx paramcx) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    paramEditable = cx.b(this.a).getText().toString();
    if (paramEditable.length() > 200)
    {
      paramEditable = paramEditable.substring(0, 200);
      cx.b(this.a).setText(paramEditable.substring(0, 200));
      cx.b(this.a).setSelection(paramEditable.length());
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */