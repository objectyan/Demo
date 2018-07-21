package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class StatusButton
  extends LinearLayout
{
  private RadioGroup a;
  private RadioButton b;
  private RadioButton c;
  private RadioButton d;
  private View.OnClickListener e;
  private View.OnClickListener f;
  private View.OnClickListener g;
  private a h;
  private Context i;
  private int j;
  private boolean k = true;
  
  public StatusButton(Context paramContext)
  {
    super(paramContext);
    this.i = paramContext;
    e();
  }
  
  public StatusButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.i = paramContext;
    e();
  }
  
  private ColorStateList b(int paramInt1, int paramInt2, int paramInt3)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 16842912 }, new int[0] }, new int[] { paramInt2, paramInt3, paramInt1 });
  }
  
  private void e()
  {
    this.k = BNSettingManager.isUsingMapMode();
    if (this.k) {
      LayoutInflater.from(this.i).inflate(2130968976, this);
    }
    for (;;)
    {
      this.a = ((RadioGroup)findViewById(2131625956));
      this.b = ((RadioButton)this.a.getChildAt(0));
      this.c = ((RadioButton)this.a.getChildAt(1));
      this.d = ((RadioButton)this.a.getChildAt(2));
      if (!BNStyleManager.getDayStyle()) {
        d();
      }
      this.a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          if ((paramAnonymousInt == StatusButton.a(StatusButton.this).getId()) && (StatusButton.b(StatusButton.this) != 1))
          {
            StatusButton.a(StatusButton.this, 1);
            if (StatusButton.e(StatusButton.this) == null) {
              break label211;
            }
            switch (StatusButton.b(StatusButton.this))
            {
            }
          }
          label211:
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if ((paramAnonymousInt == StatusButton.c(StatusButton.this).getId()) && (StatusButton.b(StatusButton.this) != 2))
                  {
                    StatusButton.a(StatusButton.this, 2);
                    break;
                  }
                } while ((paramAnonymousInt != StatusButton.d(StatusButton.this).getId()) || (StatusButton.b(StatusButton.this) == 3));
                StatusButton.a(StatusButton.this, 3);
                break;
                StatusButton.e(StatusButton.this).a(StatusButton.this, StatusButton.b.a);
                return;
                StatusButton.e(StatusButton.this).a(StatusButton.this, StatusButton.b.b);
                return;
                StatusButton.e(StatusButton.this).a(StatusButton.this, StatusButton.b.c);
                return;
                switch (StatusButton.b(StatusButton.this))
                {
                default: 
                  return;
                }
              } while (StatusButton.f(StatusButton.this) == null);
              StatusButton.f(StatusButton.this).onClick(StatusButton.a(StatusButton.this));
              return;
            } while (StatusButton.g(StatusButton.this) == null);
            StatusButton.g(StatusButton.this).onClick(StatusButton.c(StatusButton.this));
            return;
          } while (StatusButton.h(StatusButton.this) == null);
          StatusButton.h(StatusButton.this).onClick(StatusButton.d(StatusButton.this));
        }
      });
      return;
      LayoutInflater.from(this.i).inflate(2130968977, this);
    }
  }
  
  public StatusButton a()
  {
    this.b.setChecked(true);
    this.j = 1;
    return this;
  }
  
  public StatusButton a(int paramInt)
  {
    this.b.setText(paramInt);
    return this;
  }
  
  public StatusButton a(int paramInt1, int paramInt2)
  {
    this.b.setText(paramInt1);
    this.c.setVisibility(8);
    this.d.setText(paramInt2);
    return this;
  }
  
  public StatusButton a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.setText(paramInt1);
    this.c.setText(paramInt2);
    this.d.setText(paramInt3);
    return this;
  }
  
  public StatusButton a(View.OnClickListener paramOnClickListener)
  {
    this.e = paramOnClickListener;
    return this;
  }
  
  public StatusButton a(a parama)
  {
    this.h = parama;
    return this;
  }
  
  public StatusButton a(String paramString)
  {
    this.b.setText(paramString);
    return this;
  }
  
  public StatusButton a(String paramString1, String paramString2)
  {
    this.b.setText(paramString1);
    this.c.setVisibility(8);
    this.d.setText(paramString2);
    return this;
  }
  
  public StatusButton a(String paramString1, String paramString2, String paramString3)
  {
    this.b.setText(paramString1);
    this.c.setText(paramString2);
    this.d.setText(paramString3);
    return this;
  }
  
  public StatusButton a(boolean paramBoolean)
  {
    this.c.setVisibility(8);
    return this;
  }
  
  public StatusButton b()
  {
    this.c.setChecked(true);
    this.j = 2;
    return this;
  }
  
  public StatusButton b(int paramInt)
  {
    this.c.setText(paramInt);
    return this;
  }
  
  public StatusButton b(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
    return this;
  }
  
  public StatusButton b(String paramString)
  {
    this.c.setText(paramString);
    return this;
  }
  
  public StatusButton c()
  {
    this.d.setChecked(true);
    this.j = 3;
    return this;
  }
  
  public StatusButton c(int paramInt)
  {
    this.d.setText(paramInt);
    return this;
  }
  
  public StatusButton c(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
    return this;
  }
  
  public StatusButton c(String paramString)
  {
    this.d.setText(paramString);
    return this;
  }
  
  public void d()
  {
    if (this.k)
    {
      ColorStateList localColorStateList = b(StyleManager.getColor(2131559070, false), StyleManager.getColor(2131559072, false), StyleManager.getColor(2131559072, false));
      this.b.setTextColor(localColorStateList);
      localColorStateList = b(StyleManager.getColor(2131559070, false), StyleManager.getColor(2131559072, false), StyleManager.getColor(2131559072, false));
      this.c.setTextColor(localColorStateList);
      localColorStateList = b(StyleManager.getColor(2131559070, false), StyleManager.getColor(2131559072, false), StyleManager.getColor(2131559072, false));
      this.d.setTextColor(localColorStateList);
      if (Build.VERSION.SDK_INT > 15)
      {
        this.b.setBackground(StyleManager.getDrawable(2130839231, false));
        this.c.setBackground(StyleManager.getDrawable(2130839234, false));
        this.d.setBackground(StyleManager.getDrawable(2130839237, false));
      }
    }
    else
    {
      return;
    }
    this.b.setBackgroundDrawable(StyleManager.getDrawable(2130839231, false));
    this.c.setBackgroundDrawable(StyleManager.getDrawable(2130839234, false));
    this.d.setBackgroundDrawable(StyleManager.getDrawable(2130839237, false));
  }
  
  public static abstract interface a
  {
    public abstract void a(StatusButton paramStatusButton, StatusButton.b paramb);
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/StatusButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */