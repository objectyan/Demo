package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.f;
import com.baidu.carlife.f.g;

public class FullScreenNoticeDialog
  extends BaseDialog
{
  private TextView e;
  private ScrollView f;
  private g g;
  private f h;
  
  public FullScreenNoticeDialog(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FullScreenNoticeDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FullScreenNoticeDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968758, null);
  }
  
  protected void b()
  {
    this.e = ((TextView)findViewById(2131624770));
    this.f = ((ScrollView)findViewById(2131624757));
    this.f.setOverScrollMode(2);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FullScreenNoticeDialog.this.d();
      }
    });
  }
  
  public void f()
  {
    d locald = d.a();
    if (this.h == null) {
      this.h = new f(this.f, 4);
    }
    if (this.g == null)
    {
      this.g = new g(getRootView(), 6);
      this.g.d(this.e);
    }
    locald.b(new a[] { this.h, this.g });
    locald.h(this.g);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/FullScreenNoticeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */