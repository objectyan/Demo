package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.e.a;
import com.facebook.drawee.e.b;
import com.facebook.drawee.e.c;
import javax.annotation.Nullable;

public class GenericDraweeView
  extends DraweeView<a>
{
  public GenericDraweeView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  public GenericDraweeView(Context paramContext, a parama)
  {
    super(paramContext);
    setHierarchy(parama);
  }
  
  protected void a(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    paramContext = c.b(paramContext, paramAttributeSet);
    setAspectRatio(paramContext.d());
    setHierarchy(paramContext.u());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/view/GenericDraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */