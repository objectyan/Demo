package com.baidu.che.codriver.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.che.codriver.protocol.data.nlp.StockData;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.k;
import com.baidu.che.codriver.util.a;
import com.baidu.che.codriver.util.h;

public class StockCardView
  extends LinearLayout
{
  public static final String a = StockCardView.class.getSimpleName();
  private TextView b;
  private NetworkImageView c;
  private Context d;
  
  public StockCardView(Context paramContext)
  {
    super(paramContext, null);
    this.d = paramContext;
  }
  
  public StockCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.d = paramContext;
  }
  
  public StockCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
  }
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131626088));
    this.c = ((NetworkImageView)findViewById(2131626089));
  }
  
  public void a(b paramb)
  {
    h.b(a, "updateQrCodeInfo");
    StockData localStockData = ((k)paramb).a;
    try
    {
      this.b.setText(paramb.g);
      if (!TextUtils.isEmpty(localStockData.kurl)) {
        this.c.setImageUrl(localStockData.kurl, a.a());
      }
      return;
    }
    catch (NullPointerException paramb)
    {
      h.e("ConversationAdapter", paramb.getMessage().toString());
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/StockCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */