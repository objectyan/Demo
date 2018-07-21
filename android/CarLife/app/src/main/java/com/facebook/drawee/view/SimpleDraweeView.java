package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.k;
import com.facebook.common.internal.m;
import com.facebook.drawee.b.c;
import com.facebook.drawee.e.a;
import com.facebook.drawee.g.d;
import javax.annotation.Nullable;

public class SimpleDraweeView
  extends GenericDraweeView
{
  private static m<? extends d> a;
  private d b;
  
  public SimpleDraweeView(Context paramContext)
  {
    super(paramContext);
    b(paramContext, null);
  }
  
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }
  
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(paramContext, paramAttributeSet);
  }
  
  public SimpleDraweeView(Context paramContext, a parama)
  {
    super(paramContext, parama);
    b(paramContext, null);
  }
  
  public static void a(m<? extends d> paramm)
  {
    a = paramm;
  }
  
  private void b(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    if (isInEditMode()) {}
    do
    {
      return;
      k.a(a, "SimpleDraweeView was not initialized!");
      this.b = ((d)a.b());
    } while (paramAttributeSet == null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.c.SimpleDraweeView);
    try
    {
      if (paramContext.hasValue(b.c.SimpleDraweeView_actualImageUri)) {
        setImageURI(Uri.parse(paramContext.getString(b.c.SimpleDraweeView_actualImageUri)), null);
      }
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public static void g()
  {
    a = null;
  }
  
  protected d getControllerBuilder()
  {
    return this.b;
  }
  
  public void setImageURI(Uri paramUri)
  {
    setImageURI(paramUri, null);
  }
  
  public void setImageURI(Uri paramUri, @Nullable Object paramObject)
  {
    setController(this.b.e(paramObject).b(paramUri).b(getController()).w());
  }
  
  public void setImageURI(@Nullable String paramString)
  {
    setImageURI(paramString, null);
  }
  
  public void setImageURI(@Nullable String paramString, @Nullable Object paramObject)
  {
    if (paramString != null) {}
    for (paramString = Uri.parse(paramString);; paramString = null)
    {
      setImageURI(paramString, paramObject);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/view/SimpleDraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */