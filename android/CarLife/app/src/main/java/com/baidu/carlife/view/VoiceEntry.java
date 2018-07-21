package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.util.r;

public class VoiceEntry
  extends ImageView
{
  public VoiceEntry(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoiceEntry(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoiceEntry(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.a().f();
      }
    });
    a();
  }
  
  public void a()
  {
    setBackground(r.b(2130838216));
    setImageDrawable(r.b(2130838337));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/VoiceEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */