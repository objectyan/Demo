package com.baidu.sapi2.result;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class SapiResult
{
  public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
  public static final int ERROR_CODE_UNKNOWN = -202;
  public static final String ERROR_MSG_NETWORK_UNAVAILABLE = "网络连接不可用，请检查网络设置";
  public static final String ERROR_MSG_UNKNOWN = "网络连接失败，请检查网络设置";
  public static final int RESULT_CODE_SUCCESS = 0;
  public static final int RESULT_CODE_WAPPASS_SUCCESS = 110000;
  public static final String RESULT_MSG_SUCCESS = "成功";
  protected SparseArray<String> msgMap = new SparseArray();
  protected int resultCode = 65334;
  protected String resultMsg;
  
  public SapiResult()
  {
    this.msgMap.put(0, "成功");
    this.msgMap.put(110000, "成功");
    this.msgMap.put(65335, "网络连接不可用，请检查网络设置");
    this.msgMap.put(65334, "网络连接失败，请检查网络设置");
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
  
  public String getResultMsg()
  {
    if (!TextUtils.isEmpty(this.resultMsg)) {
      return this.resultMsg;
    }
    if (this.msgMap.get(this.resultCode) != null) {
      return (String)this.msgMap.get(this.resultCode);
    }
    return (String)this.msgMap.get(65334);
  }
  
  public void setResultCode(int paramInt)
  {
    this.resultCode = paramInt;
  }
  
  public void setResultMsg(String paramString)
  {
    this.resultMsg = paramString;
  }
  
  public static class Action
  {
    public SapiResult.ActionMode actionMode;
    public String actionTitle;
    public SapiResult.ActionType actionType;
    public String actionUrl;
  }
  
  public static enum ActionMode
  {
    private static final Map<String, ActionMode> a;
    private String b;
    
    static
    {
      a = new HashMap();
      ActionMode[] arrayOfActionMode = values();
      int j = arrayOfActionMode.length;
      int i = 0;
      while (i < j)
      {
        ActionMode localActionMode = arrayOfActionMode[i];
        a.put(localActionMode.toString(), localActionMode);
        i += 1;
      }
    }
    
    private ActionMode(String paramString)
    {
      this.b = paramString;
    }
    
    public static ActionMode fromString(String paramString)
    {
      return (ActionMode)a.get(paramString);
    }
    
    public String getValue()
    {
      return this.b;
    }
    
    public String toString()
    {
      return this.b;
    }
  }
  
  public static enum ActionType
  {
    private static final Map<String, ActionType> a;
    private String b;
    
    static
    {
      a = new HashMap();
      ActionType[] arrayOfActionType = values();
      int j = arrayOfActionType.length;
      int i = 0;
      while (i < j)
      {
        ActionType localActionType = arrayOfActionType[i];
        a.put(localActionType.toString(), localActionType);
        i += 1;
      }
    }
    
    private ActionType(String paramString)
    {
      this.b = paramString;
    }
    
    public static ActionType fromString(String paramString)
    {
      return (ActionType)a.get(paramString);
    }
    
    public String getValue()
    {
      return this.b;
    }
    
    public String toString()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/SapiResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */