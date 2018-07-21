package com.baidu.carlife.custom.elhyf.a;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.view.dialog.BaseDialog;

public class a
  extends BaseDialog
{
  TextView e;
  ProgressBar f;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a()
  {
    return View.inflate(getContext(), 2130969069, null);
  }
  
  protected void b()
  {
    this.e = ((TextView)findViewById(2131624640));
    this.f = ((ProgressBar)findViewById(2131626083));
    setCanceledOnTouchOutside(false);
  }
  
  public void f() {}
  
  public void setProgress(int paramInt)
  {
    this.f.setProgress(paramInt);
  }
  
  public void setTitle(String paramString)
  {
    this.e.setText(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */