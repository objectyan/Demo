package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.core.i;

public class u
  extends c
{
  private ProgressBar e = null;
  private TextView f = null;
  private TextView g = null;
  private TextView h = null;
  private String i = "已完成: %dM/%dM";
  private String j = "%d%%";
  
  public u(Context paramContext)
  {
    super(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969052, null);
    this.e = ((ProgressBar)paramContext.findViewById(2131624277));
    this.f = ((TextView)paramContext.findViewById(2131624275));
    this.g = ((TextView)paramContext.findViewById(2131624276));
    this.h = ((TextView)paramContext.findViewById(2131626167));
    a(paramContext);
  }
  
  public void setHasFinished(int paramInt1, int paramInt2)
  {
    this.f.setText(String.format(this.i, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public void setPercent(int paramInt)
  {
    this.g.setText(String.format(this.j, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public void setProgress(int paramInt)
  {
    this.e.setProgress(paramInt);
  }
  
  public void setTitle(int paramInt)
  {
    if (this.h != null) {
      setTitle(this.c.getString(paramInt));
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.h != null)
    {
      i.b("BaseDialog", "Set UpdateProgressDialog Title: " + paramString);
      this.h.setText(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */