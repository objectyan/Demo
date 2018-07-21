package com.baidu.carlife.view.softinputphonekey;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.R.p;
import com.baidu.carlife.view.a.b;
import com.baidu.carlife.view.f;

public class SoftInputPhoneKey
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private f c;
  private String d;
  
  public SoftInputPhoneKey(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SoftInputPhoneKey(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SoftInputPhoneKey(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130969018, this, true);
    this.a = ((TextView)findViewById(2131624906));
    this.b = ((TextView)findViewById(2131626080));
    if (paramAttributeSet == null) {}
    do
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.p.SoftInputPhoneKey);
      this.d = paramContext.getString(0);
      paramAttributeSet = paramContext.getString(1);
      paramContext.recycle();
      if (!TextUtils.isEmpty(this.d))
      {
        this.a.setText(this.d);
        this.a.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (SoftInputPhoneKey.a(SoftInputPhoneKey.this) != null) {
              SoftInputPhoneKey.a(SoftInputPhoneKey.this).a(SoftInputPhoneKey.b(SoftInputPhoneKey.this));
            }
          }
        });
        this.a.setOnLongClickListener(new View.OnLongClickListener()
        {
          public boolean onLongClick(View paramAnonymousView)
          {
            if (SoftInputPhoneKey.a(SoftInputPhoneKey.this) != null)
            {
              if (!SoftInputPhoneKey.b(SoftInputPhoneKey.this).equals("0")) {
                break label41;
              }
              SoftInputPhoneKey.a(SoftInputPhoneKey.this).a("+");
            }
            for (;;)
            {
              return true;
              label41:
              SoftInputPhoneKey.a(SoftInputPhoneKey.this).a(SoftInputPhoneKey.b(SoftInputPhoneKey.this));
            }
          }
        });
        this.a.setBackground(b.c(getContext()));
      }
    } while (TextUtils.isEmpty(paramAttributeSet));
    this.b.setText(paramAttributeSet);
  }
  
  public View getFocusView()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.a.getText().toString();
  }
  
  public void setDesc(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.b.setText("");
      return;
    }
    this.b.setText(paramString);
  }
  
  public void setSoftInputKeyListener(f paramf)
  {
    this.c = paramf;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/softinputphonekey/SoftInputPhoneKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */