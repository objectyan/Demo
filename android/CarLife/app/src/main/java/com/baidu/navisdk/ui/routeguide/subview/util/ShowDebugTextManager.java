package com.baidu.navisdk.ui.routeguide.subview.util;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ShowDebugTextManager
{
  private static final int MaxNum = 20;
  private static Object mSyncObj = new Object();
  private static ShowDebugTextManager sInstance = null;
  private LinearLayout mDebugLayout = null;
  private ArrayList<String> mDebugText = new ArrayList();
  private TextView mDebugTextView = null;
  private SimpleDateFormat mLiteSDF = null;
  private SimpleDateFormat mSDF = null;
  
  public static ShowDebugTextManager getInstance()
  {
    if (sInstance == null) {}
    synchronized (mSyncObj)
    {
      if (sInstance == null) {
        sInstance = new ShowDebugTextManager();
      }
      return sInstance;
    }
  }
  
  private void printText(String paramString)
  {
    this.mDebugLayout = RGMapModeViewController.getInstance().getDebugLinearLayout();
    this.mDebugTextView = RGMapModeViewController.getInstance().getDebugText();
    if ((this.mDebugLayout == null) || (this.mDebugTextView == null)) {
      return;
    }
    if ((this.mDebugText != null) && (this.mDebugText.size() < 20)) {
      this.mDebugText.add(0, paramString);
    }
    String str;
    for (;;)
    {
      paramString = "";
      str = paramString;
      if (this.mDebugText == null) {
        break;
      }
      int i = 0;
      for (;;)
      {
        str = paramString;
        if (i >= this.mDebugText.size()) {
          break;
        }
        paramString = paramString + "\n" + (String)this.mDebugText.get(i);
        i += 1;
      }
      if ((this.mDebugText != null) && (this.mDebugText.size() >= 20))
      {
        this.mDebugText.remove(this.mDebugText.size() - 1);
        this.mDebugText.add(0, paramString);
      }
    }
    this.mDebugLayout.setVisibility(0);
    this.mDebugTextView.setText(str);
  }
  
  public void addDebugText(String paramString)
  {
    printText(this.mSDF.format(new Date()) + " ### " + paramString);
  }
  
  public void addLiteDebugText(String paramString)
  {
    printText(this.mLiteSDF.format(new Date()) + " # " + paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/util/ShowDebugTextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */