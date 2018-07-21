package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class b
  extends c
{
  private ProgressBar e = null;
  private TextView f = null;
  private TextView g = null;
  private String h = "已完成: %dM/%dM";
  private String i = "%d%%";
  
  public b(Context paramContext)
  {
    super(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(2130968633, null);
    this.e = ((ProgressBar)paramContext.findViewById(2131624277));
    this.f = ((TextView)paramContext.findViewById(2131624275));
    this.g = ((TextView)paramContext.findViewById(2131624276));
    a(paramContext);
  }
  
  public void setHasFinished(int paramInt1, int paramInt2)
  {
    this.f.setText(String.format(this.h, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public void setPercent(int paramInt)
  {
    this.g.setText(String.format(this.i, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public void setProgress(int paramInt)
  {
    this.e.setProgress(paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */