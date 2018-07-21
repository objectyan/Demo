package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.DialogReplaceToastUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNTiptoolDialog
  extends Dialog
{
  private static final int START_MSG = 2;
  private static final int STOP_MSG = 1;
  private TextView mShowText = null;
  private Handler uiHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      try
      {
        switch (paramAnonymousMessage.what)
        {
        case 1: 
          LogUtil.e(DialogReplaceToastUtils.TAG, "showToastMessage STOP_MSG");
          BNTiptoolDialog.this.dismiss();
          return;
        case 2: 
          LogUtil.e(DialogReplaceToastUtils.TAG, "showToastMessage START_MSG");
          String str = (String)paramAnonymousMessage.obj;
          int i = paramAnonymousMessage.arg2;
          BNTiptoolDialog.this.mShowText.setText(str);
          if ((BNaviModuleManager.getActivity() != null) && (!BNaviModuleManager.getActivity().isFinishing()))
          {
            BNTiptoolDialog.this.show();
            if (BNTiptoolDialog.this.uiHandler != null)
            {
              BNTiptoolDialog.this.uiHandler.sendEmptyMessageDelayed(1, i);
              return;
            }
          }
          break;
        }
        return;
      }
      catch (Exception paramAnonymousMessage) {}
    }
  };
  
  public BNTiptoolDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public BNTiptoolDialog(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    JarUtils.getResources().newTheme().applyStyle(1711996966, true);
    requestWindowFeature(1);
    setContentView(JarUtils.inflate((Activity)paramContext, 1711472752, null));
    this.mShowText = ((TextView)findViewById(1711867050));
    paramContext = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramContext.getAttributes();
    paramContext.setBackgroundDrawableResource(17170445);
    paramInt = paramString.length();
    LogUtil.e(DialogReplaceToastUtils.TAG, "dialog lenght is " + paramInt);
    localLayoutParams.width = getPixel(paramInt, paramString);
    localLayoutParams.height = ScreenUtil.getInstance().dip2px(44);
    localLayoutParams.y = ScreenUtil.getInstance().dip2px(64);
    paramContext.setAttributes(localLayoutParams);
    paramContext.setGravity(80);
  }
  
  private void clearMessage()
  {
    if (this.uiHandler != null) {
      this.uiHandler.removeMessages(1);
    }
  }
  
  private int getPixel(int paramInt, String paramString)
  {
    int i = getVacabularyNumber(paramString);
    return ScreenUtil.getInstance().dip2px((paramInt - 1 - i) * 14 + 38 + i * 8);
  }
  
  private int getVacabularyNumber(String paramString)
  {
    int k = 0;
    int j = 0;
    if (j < paramString.length())
    {
      int m = paramString.charAt(j);
      int i;
      if ((m >= 48) && (m <= 57)) {
        i = k + 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if ((m < 97) || (m > 122))
        {
          i = k;
          if (m >= 65)
          {
            i = k;
            if (m > 90) {}
          }
        }
        else
        {
          i = k + 1;
        }
      }
    }
    return k;
  }
  
  public void release()
  {
    if (this.uiHandler != null)
    {
      this.uiHandler.removeMessages(1);
      this.uiHandler.removeMessages(2);
    }
    this.uiHandler = null;
  }
  
  public void showToastMsg(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    clearMessage();
    Message localMessage = this.uiHandler.obtainMessage();
    localMessage.what = 2;
    localMessage.arg2 = paramInt;
    localMessage.obj = paramString;
    this.uiHandler.sendMessage(localMessage);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNTiptoolDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */