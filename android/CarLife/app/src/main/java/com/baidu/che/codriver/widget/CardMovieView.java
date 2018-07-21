package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.che.codriver.protocol.data.nlp.CardMovieData;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.util.h;
import java.util.List;

public class CardMovieView
  extends LinearLayout
{
  public static final String a = CardMovieView.class.getSimpleName();
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private NetworkImageView g;
  private Context h;
  
  public CardMovieView(Context paramContext)
  {
    super(paramContext, null);
    this.h = paramContext;
  }
  
  public CardMovieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.h = paramContext;
  }
  
  public CardMovieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.h = paramContext;
  }
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131625284));
    this.c = ((TextView)findViewById(2131625288));
    this.d = ((TextView)findViewById(2131625291));
    this.e = ((TextView)findViewById(2131625294));
    this.f = ((TextView)findViewById(2131625297));
    this.g = ((NetworkImageView)findViewById(2131625285));
  }
  
  public void a(b paramb)
  {
    h.b(a, "updateCardMovieInfo");
    CardMovieData localCardMovieData = ((com.baidu.che.codriver.ui.d.a)paramb).a;
    for (;;)
    {
      try
      {
        if (localCardMovieData.name != null) {
          this.b.setText(localCardMovieData.name);
        }
        if (localCardMovieData.showTime != null) {
          this.c.setText(localCardMovieData.showTime);
        }
        paramb = "";
        if (localCardMovieData.type != null)
        {
          int i = 0;
          localObject = paramb;
          if (i < localCardMovieData.type.size())
          {
            paramb = paramb + (String)localCardMovieData.type.get(i) + "/";
            i += 1;
            continue;
          }
          this.d.setText((CharSequence)localObject);
          if (localCardMovieData.director == null) {
            break label336;
          }
          paramb = "";
          i = 0;
          localObject = paramb;
          if (i < localCardMovieData.director.size())
          {
            paramb = paramb + (String)localCardMovieData.director.get(i) + "/";
            i += 1;
            continue;
          }
          this.e.setText((CharSequence)localObject);
          if (localCardMovieData.actor == null) {
            break label342;
          }
          paramb = "";
          i = 0;
          localObject = paramb;
          if (i < localCardMovieData.actor.size())
          {
            paramb = paramb + (String)localCardMovieData.actor.get(i) + "/";
            i += 1;
            continue;
          }
          this.f.setText((CharSequence)localObject);
          this.g.setImageUrl(localCardMovieData.post, com.baidu.che.codriver.util.a.a());
          return;
        }
      }
      catch (NullPointerException paramb)
      {
        h.e("ConversationAdapter", paramb.getMessage().toString());
        return;
      }
      Object localObject = "暂无数据";
      continue;
      label336:
      localObject = "暂无数据";
      continue;
      label342:
      localObject = "暂无数据";
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/CardMovieView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */