package com.baidu.carlife.core.screen.presentation;

import android.support.annotation.Nullable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.baidu.carlife.core.h;

public abstract class c
  implements Window.Callback, h
{
  private static final String a = "CarlifeTouchManager#CarlifeWindowCallback";
  private Window b;
  
  public c(Window paramWindow)
  {
    this.b = paramWindow;
  }
  
  public abstract void a();
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.b.superDispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      a();
      return true;
    }
    return this.b.superDispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.b.superDispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.b.superDispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.b.superDispatchTrackballEvent(paramMotionEvent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode) {}
  
  public void onActionModeStarted(ActionMode paramActionMode) {}
  
  public void onAttachedToWindow() {}
  
  public void onContentChanged() {}
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return false;
  }
  
  @Nullable
  public View onCreatePanelView(int paramInt)
  {
    return null;
  }
  
  public void onDetachedFromWindow() {}
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return false;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu) {}
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return false;
  }
  
  public boolean onSearchRequested()
  {
    return false;
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams) {}
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  @Nullable
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */