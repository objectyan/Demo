package com.baidu.carlife.core.screen.presentation;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.os.Bundle;
import android.view.Display;
import android.view.InputEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.b.f;
import com.baidu.carlife.core.screen.o;
import com.baidu.carlife.core.screen.presentation.a.j;

@TargetApi(19)
public abstract class b
  extends Presentation
  implements h, o
{
  public static String b = "CarlifeTouchManager#Presentation";
  
  public b(AbsCarlifeActivityService paramAbsCarlifeActivityService, Display paramDisplay)
  {
    super(paramAbsCarlifeActivityService, paramDisplay);
    a();
  }
  
  private void a()
  {
    Window localWindow = getWindow();
    localWindow.setType(2030);
    localWindow.addFlags(268435456);
    localWindow.addFlags(16777216);
    localWindow.addFlags(1024);
    localWindow.setCallback(a(localWindow));
  }
  
  private void a(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      ((ViewGroup)localViewParent).removeView(paramView);
      a((ViewGroup)localViewParent);
      return;
    }
    i.b(b, "decorViewParent is null or not is ViewGroup.");
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (com.baidu.carlife.core.screen.presentation.a.b.b().d() != null)
    {
      View localView = com.baidu.carlife.core.screen.presentation.a.b.b().d().b();
      if (localView != null)
      {
        if (localView.getParent() != null) {
          ((ViewGroup)localView.getParent()).removeView(localView);
        }
        paramViewGroup.addView(localView);
        paramViewGroup.invalidate();
        return;
      }
      i.b(b, "maskView is null.");
      return;
    }
    i.b(b, "carlifeMaskView is null.");
  }
  
  public abstract c a(Window paramWindow);
  
  public void a(InputEvent paramInputEvent, boolean paramBoolean)
  {
    b(paramInputEvent, paramBoolean);
  }
  
  public void b(InputEvent paramInputEvent, boolean paramBoolean)
  {
    Window localWindow = getWindow();
    i.b(b, "injectInputEvent event:" + paramInputEvent);
    localWindow.setLocalFocus(true, paramBoolean);
    localWindow.injectInputEvent(paramInputEvent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = com.baidu.carlife.core.screen.presentation.a.b.b().e();
    if (paramBundle != null)
    {
      a(paramBundle);
      setContentView(paramBundle);
      return;
    }
    i.b(b, "decorView must be not null.");
  }
  
  public void show()
  {
    super.show();
    i.b(b, "CarlifePresentation. show()");
    f.a().a(this);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */