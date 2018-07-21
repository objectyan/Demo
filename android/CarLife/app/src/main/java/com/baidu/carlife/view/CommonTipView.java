package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;

public class CommonTipView
  extends RelativeLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private final int d = 0;
  private final int e = 1;
  private final int f = 2;
  private String g;
  private int h;
  private int i;
  private TextView j;
  private ImageView k;
  private Button l;
  private a m;
  
  public CommonTipView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968715, this, true);
    this.j = ((TextView)findViewById(2131624655));
    this.k = ((ImageView)findViewById(2131624654));
    this.l = ((Button)findViewById(2131624656));
    this.l.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (CommonTipView.a(CommonTipView.this) != null) {
          CommonTipView.a(CommonTipView.this).a();
        }
      }
    });
  }
  
  private int c(int paramInt)
  {
    if (paramInt != 0) {
      try
      {
        String str = BaiduNaviApplication.getInstance().getResources().getResourceTypeName(paramInt);
        if ("string".equals(str)) {
          return 1;
        }
        boolean bool = "drawable".equals(str);
        if (bool) {
          return 2;
        }
      }
      catch (Resources.NotFoundException localNotFoundException) {}
    }
    return 0;
  }
  
  private void setDefaultTextView()
  {
    if (TextUtils.isEmpty(this.g))
    {
      this.j.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296383));
      return;
    }
    this.j.setText(this.g);
  }
  
  public void a()
  {
    a(0, false);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(BaiduNaviApplication.getInstance().getString(paramInt1), paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.k.setVisibility(8);
      this.l.setVisibility(0);
      if (paramInt == 1) {
        this.j.setText(2131296385);
      }
      while (this.i == 0)
      {
        this.l.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296386));
        return;
        if (paramInt == 2) {
          this.j.setText(2131296384);
        } else {
          setDefaultTextView();
        }
      }
      this.l.setText(this.i);
      return;
    }
    this.k.setVisibility(0);
    this.l.setVisibility(8);
    if (paramInt == 1)
    {
      this.j.setText(2131296385);
      this.k.setImageResource(2130838304);
      return;
    }
    if (paramInt == 2)
    {
      this.j.setText(2131296384);
      this.k.setImageResource(2130838293);
      return;
    }
    setDefaultTextView();
    if (this.h == 0)
    {
      this.k.setImageResource(2130838267);
      return;
    }
    this.k.setImageResource(this.h);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.g = paramString;
    int n = c(paramInt);
    if (n == 1)
    {
      this.i = paramInt;
      return;
    }
    if (n == 2)
    {
      this.h = paramInt;
      return;
    }
    this.h = 0;
    this.i = 0;
  }
  
  public void a(boolean paramBoolean)
  {
    a(0, paramBoolean);
  }
  
  public void b()
  {
    this.l.performClick();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public View getFocusView()
  {
    return this.l;
  }
  
  public void setCommonTipCallBack(a parama)
  {
    this.m = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/CommonTipView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */