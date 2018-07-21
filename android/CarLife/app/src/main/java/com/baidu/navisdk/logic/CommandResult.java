package com.baidu.navisdk.logic;

import android.content.res.Resources;

public class CommandResult
{
  public int mErrCode;
  public String mErrDebug;
  public String mErrForUser;
  public Object mUserObject;
  
  public CommandResult()
  {
    reset();
  }
  
  public CommandResult(int paramInt)
  {
    this();
    set(paramInt);
  }
  
  public CommandResult(int paramInt, String paramString1, String paramString2)
  {
    this();
    set(paramInt, paramString1, paramString2);
  }
  
  public static boolean isNetworkErr(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt < NaviErrCode.getAppError(0)) || (paramInt > NaviErrCode.getAppError(2)))
    {
      bool1 = bool2;
      if (paramInt >= NaviErrCode.getSDKError(0))
      {
        bool1 = bool2;
        if (paramInt > NaviErrCode.getSDKError(2)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void mapErrInfo(Resources paramResources, CommandResult paramCommandResult)
  {
    if ((paramCommandResult.mErrForUser != null) && (paramCommandResult.mErrForUser.length() > 0)) {}
  }
  
  public boolean isNetworkErr()
  {
    return false;
  }
  
  public boolean isSuccess()
  {
    return this.mErrCode == 0;
  }
  
  public void reset()
  {
    this.mErrCode = 55536;
    this.mErrDebug = "";
    this.mErrForUser = "";
    this.mUserObject = null;
  }
  
  public void set(int paramInt)
  {
    set(paramInt, null, null);
  }
  
  public void set(int paramInt, String paramString)
  {
    set(paramInt, paramString, null);
  }
  
  public void set(int paramInt, String paramString1, String paramString2)
  {
    this.mErrCode = paramInt;
    if (paramString1 != null)
    {
      this.mErrDebug = paramString1;
      if (paramString2 == null) {
        break label30;
      }
    }
    for (;;)
    {
      this.mErrForUser = paramString2;
      return;
      paramString1 = "";
      break;
      label30:
      paramString2 = "";
    }
  }
  
  public void set(CommandResult paramCommandResult)
  {
    set(paramCommandResult.mErrCode, paramCommandResult.mErrDebug, paramCommandResult.mErrForUser);
  }
  
  public void setAppError(int paramInt)
  {
    set(paramInt + 6000, null, null);
  }
  
  public void setSDKError(int paramInt)
  {
    set(paramInt + 5000, null, null);
  }
  
  public void setSuccess()
  {
    this.mErrCode = 0;
  }
  
  public void setSuccess(String paramString)
  {
    setSuccess();
    this.mErrForUser = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/CommandResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */