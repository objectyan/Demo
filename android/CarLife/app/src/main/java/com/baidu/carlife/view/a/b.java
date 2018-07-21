package com.baidu.carlife.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import com.baidu.carlife.core.d;
import com.baidu.carlife.util.r;

public class b
{
  public static StateListDrawable a(Context paramContext)
  {
    a locala = new a(paramContext.getResources().getDimension(2131361847), paramContext.getResources().getDimension(2131361845), r.a(2131558677));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, locala);
    localStateListDrawable.addState(new int[] { 16842913 }, locala);
    paramContext = ContextCompat.getDrawable(paramContext, 2130838219);
    localStateListDrawable.addState(new int[] { 16842908 }, paramContext);
    paramContext = new ColorDrawable(0);
    localStateListDrawable.addState(new int[] { 16843161 }, paramContext);
    return localStateListDrawable;
  }
  
  public static StateListDrawable b(Context paramContext)
  {
    a locala = new a(paramContext.getResources().getDimension(2131361847), paramContext.getResources().getDimension(2131361845), r.a(2131558677));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, locala);
    localStateListDrawable.addState(new int[] { 16842913 }, locala);
    paramContext = ContextCompat.getDrawable(paramContext, 2130838219);
    localStateListDrawable.addState(new int[] { 16842908 }, paramContext);
    paramContext = new ColorDrawable(0);
    localStateListDrawable.addState(new int[] { 16843161 }, paramContext);
    return localStateListDrawable;
  }
  
  public static StateListDrawable c(Context paramContext)
  {
    float f1 = paramContext.getResources().getDimension(2131362100);
    float f2 = paramContext.getResources().getDimension(2131362098);
    float f3 = d.a().i();
    float f4 = paramContext.getResources().getDimension(2131362099);
    a locala = new a((f1 - f2 * 2.0F) / 3.0F, (f3 - f4 * 2.0F) / 4.0F, r.a(2131558677), 1);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, locala);
    localStateListDrawable.addState(new int[] { 16842913 }, locala);
    paramContext = ContextCompat.getDrawable(paramContext, 2130838219);
    localStateListDrawable.addState(new int[] { 16842908 }, paramContext);
    paramContext = new ColorDrawable(0);
    localStateListDrawable.addState(new int[] { 16843161 }, paramContext);
    return localStateListDrawable;
  }
  
  public static StateListDrawable d(Context paramContext)
  {
    a locala = new a(paramContext.getResources().getDimension(2131361864), paramContext.getResources().getDimension(2131361845), r.a(2131558677));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, locala);
    localStateListDrawable.addState(new int[] { 16842913 }, locala);
    paramContext = ContextCompat.getDrawable(paramContext, 2130838219);
    localStateListDrawable.addState(new int[] { 16842908 }, paramContext);
    paramContext = new ColorDrawable(0);
    localStateListDrawable.addState(new int[] { 16843161 }, paramContext);
    return localStateListDrawable;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */