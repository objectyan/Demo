package com.baidu.che.codriver.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.che.codriver.util.a;

public class CinemaBillView
  extends LinearLayout
{
  View a;
  a b;
  
  public CinemaBillView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CinemaBillView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CinemaBillView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    removeAllViews();
    this.a = inflate(getContext(), 2130968931, this);
    if (this.b == null) {
      this.b = new a();
    }
    this.b.a = ((NetworkImageView)this.a.findViewById(2131625647));
    this.b.b = ((TextView)this.a.findViewById(2131625648));
    this.b.c = ((RatingBar)this.a.findViewById(2131625649));
    this.b.d = ((TextView)this.a.findViewById(2131625650));
    setTag(2131296544, this.b);
  }
  
  public static class a
  {
    public NetworkImageView a;
    public TextView b;
    public RatingBar c;
    public TextView d;
    
    public void a()
    {
      this.a.setVisibility(4);
      this.c.setVisibility(4);
      this.b.setText("");
      this.d.setText("");
    }
    
    public void a(String paramString)
    {
      this.b.setVisibility(0);
      this.b.setText(paramString);
    }
    
    public void b(String paramString)
    {
      this.c.setVisibility(8);
      TextView localTextView = this.d;
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "暂无评分";
      }
      localTextView.setText(str);
    }
    
    public void c(String paramString)
    {
      this.a.setImageUrl(paramString, a.a());
      if (this.a.getVisibility() != 0) {
        this.a.setVisibility(0);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/CinemaBillView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */