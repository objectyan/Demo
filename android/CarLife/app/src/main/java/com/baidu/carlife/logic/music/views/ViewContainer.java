package com.baidu.carlife.logic.music.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.carlife.c.b.a;
import com.baidu.carlife.c.f.a.a;
import com.baidu.carlife.c.f.a.b;

public class ViewContainer
  extends FrameLayout
  implements a.b
{
  private a.a a;
  
  public ViewContainer(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ViewContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ViewContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    removeAllViews();
    addView(this.a.b().a());
    this.a.a();
  }
  
  public void a(a.a parama)
  {
    this.a = parama;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/views/ViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */