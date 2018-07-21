package com.baidu.ufosdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.i;

public final class cx
  extends Dialog
{
  private final int a = 2131165185;
  private final int b = 2131165186;
  private final int c = 2131165187;
  private final int d = 2131165188;
  private final int e = 2131165189;
  private final int f = 2131165190;
  private final int g = 2131165191;
  private Context h;
  private da i;
  private EditText j;
  private String k = "";
  
  public cx(Context paramContext, String paramString)
  {
    super(paramContext);
    this.h = paramContext;
    this.k = paramString;
  }
  
  public final void a(da paramda)
  {
    this.i = paramda;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setCanceledOnTouchOutside(false);
    getWindow().setBackgroundDrawable(new BitmapDrawable());
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setColor(a.y);
    ((GradientDrawable)localObject1).setCornerRadius(i.a(this.h, 4.0F));
    paramBundle = new RelativeLayout(this.h);
    paramBundle.setId(2131165185);
    paramBundle.setBackgroundDrawable((Drawable)localObject1);
    Object localObject2 = new TextView(this.h);
    ((TextView)localObject2).setId(2131165191);
    ((TextView)localObject2).setTextColor(-16777216);
    ((TextView)localObject2).setTextSize(18.0F);
    ((TextView)localObject2).getPaint().setFakeBoldText(true);
    ((TextView)localObject2).setText("邮箱/手机/QQ号");
    ((TextView)localObject2).setGravity(17);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).setMargins(i.a(this.h, 10.0F), i.a(this.h, 20.0F), i.a(this.h, 10.0F), 0);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    paramBundle.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(this.h);
    ((TextView)localObject1).setId(2131165186);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setTextSize(15.0F);
    ((TextView)localObject1).setText("您的反馈将提交我们跟进，请留下您的联系方式。");
    ((TextView)localObject1).setGravity(17);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(i.a(this.h, 20.0F), i.a(this.h, 20.0F), i.a(this.h, 20.0F), 0);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((TextView)localObject2).getId());
    paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    int m = i.a(this.h, 4.0F);
    int n = Color.parseColor("#2E3135");
    int i1 = Color.parseColor("#DFDFE0");
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setColor(i1);
    ((GradientDrawable)localObject2).setCornerRadius(m);
    ((GradientDrawable)localObject2).setStroke(1, n);
    this.j = new EditText(this.h);
    this.j.setId(2131165187);
    this.j.setTextSize(15.0F);
    if (this.k.length() > 0)
    {
      this.j.setText(this.k);
      this.j.setSelection(this.k.length());
    }
    this.j.setHint("请输入您的联系方式");
    this.j.setBackgroundDrawable((Drawable)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((TextView)localObject1).getId());
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i.a(this.h, 25.0F), i.a(this.h, 20.0F), i.a(this.h, 25.0F), i.a(this.h, 10.0F));
    paramBundle.addView(this.j, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new LinearLayout(this.h);
    ((LinearLayout)localObject1).setId(2131165188);
    ((LinearLayout)localObject1).setOrientation(0);
    ((LinearLayout)localObject1).setBackgroundColor(0);
    ((LinearLayout)localObject1).setGravity(17);
    localObject2 = new TextView(this.h);
    ((TextView)localObject2).setId(2131165189);
    ((TextView)localObject2).setText("取消");
    ((TextView)localObject2).setTextColor(i.a(a.w, a.u, a.w, a.w));
    ((TextView)localObject2).setBackgroundColor(0);
    ((TextView)localObject2).setTextSize(17.0F);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setOnClickListener(new cz(this, (byte)0));
    localObject3 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new View(this.h);
    localObject3 = new LinearLayout.LayoutParams(i.a(this.h, 0.8F), -1);
    ((LinearLayout.LayoutParams)localObject3).setMargins(0, i.a(this.h, 10.0F), 0, 0);
    ((View)localObject2).setBackgroundColor(-6710887);
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new TextView(this.h);
    ((TextView)localObject2).setId(2131165190);
    ((TextView)localObject2).setText("提交");
    ((TextView)localObject2).setTextColor(i.a(a.w, a.u, a.w, a.w));
    ((TextView)localObject2).setBackgroundColor(0);
    ((TextView)localObject2).setTextSize(17.0F);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setOnClickListener(new cz(this, (byte)0));
    localObject3 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-1, i.a(this.h, 50.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.j.getId());
    paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -2));
    this.j.addTextChangedListener(new cy(this));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */