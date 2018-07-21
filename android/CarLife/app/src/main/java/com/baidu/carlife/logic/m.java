package com.baidu.carlife.logic;

import android.os.Bundle;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;

public class m
{
  private static m a = null;
  private static Object b = new Object();
  
  public static m a()
  {
    if (a == null) {}
    synchronized (b)
    {
      if (a == null) {
        a = new m();
      }
      return a;
    }
  }
  
  private int b(int paramInt)
  {
    return 5;
  }
  
  private int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4155: 
      return 4;
    case 4154: 
      return 3;
    case 4152: 
      return 5;
    }
    return 6;
  }
  
  public void a(int paramInt)
  {
    BNVoiceCommandController.getInstance().handleVoiceCommandMsg(b(paramInt), c(paramInt), 0, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("poiname", paramString);
    BNVoiceCommandController.getInstance().handleVoiceCommandMsg(b(paramInt), c(paramInt), 0, localBundle);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */