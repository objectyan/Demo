package com.baidu.che.codriver.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.che.codriver.model.BaiKeConversationModel;
import com.baidu.che.codriver.model.BaiKeConversationModel.BaiKe;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.util.a;
import java.util.ArrayList;

public class BaiKeCardView
  extends LinearLayout
{
  private TextView a;
  private NetworkImageView b;
  private TextView c;
  private TextView d;
  
  public BaiKeCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaiKeCardView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaiKeCardView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet == null)
    {
      LayoutInflater.from(paramContext).inflate(2130968844, this);
      a();
    }
  }
  
  private String a(String paramString)
  {
    int k = paramString.indexOf("。");
    int i = paramString.indexOf(";");
    int j = paramString.indexOf("；");
    int m = paramString.indexOf("!");
    int n = paramString.indexOf("！");
    Object localObject = new int[4];
    localObject[0] = i;
    localObject[1] = j;
    localObject[2] = m;
    localObject[3] = n;
    j = 0;
    if (j < localObject.length)
    {
      if (k <= 0) {
        i = localObject[j];
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (localObject[j] > 0)
        {
          i = k;
          if (localObject[j] < k) {
            i = localObject[j];
          }
        }
      }
    }
    if (k > 0) {
      localObject = paramString.substring(0, k);
    }
    do
    {
      return (String)localObject;
      i = paramString.indexOf(",");
      j = paramString.indexOf("，");
      if ((j > 0) && (i > 0))
      {
        if (j < i) {
          i = j;
        }
        for (;;)
        {
          return paramString.substring(0, i);
        }
      }
      if (j > 0) {
        return paramString.substring(0, j);
      }
      localObject = paramString;
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131625279));
    this.b = ((NetworkImageView)findViewById(2131625280));
    this.c = ((TextView)findViewById(2131625281));
    this.d = ((TextView)findViewById(2131625282));
  }
  
  public void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    Object localObject = ((BaiKeConversationModel)paramb).a;
    if (localObject != null)
    {
      this.b.setVisibility(0);
      if ((((BaiKeConversationModel.BaiKe)localObject).images != null) && (((BaiKeConversationModel.BaiKe)localObject).images.size() > 0))
      {
        this.b.setImageUrl((String)((BaiKeConversationModel.BaiKe)localObject).images.get(0), a.a());
        if (TextUtils.isEmpty(((BaiKeConversationModel.BaiKe)localObject).title)) {
          break label149;
        }
        this.c.setVisibility(0);
        this.c.setText(((BaiKeConversationModel.BaiKe)localObject).title);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramb.g)) {
          break label161;
        }
        this.a.setText(a(paramb.g));
        this.a.setVisibility(0);
        this.d.setText(paramb.g);
        return;
        this.b.setImageResource(2130838468);
        break;
        label149:
        this.c.setVisibility(8);
      }
      label161:
      this.d.setText("暂无介绍");
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(8);
    this.c.setVisibility(8);
    this.b.setVisibility(8);
    localObject = this.d;
    if (TextUtils.isEmpty(paramb.g)) {}
    for (paramb = "暂无介绍";; paramb = paramb.g)
    {
      ((TextView)localObject).setText(paramb);
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/BaiKeCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */