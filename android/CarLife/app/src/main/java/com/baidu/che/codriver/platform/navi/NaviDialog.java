package com.baidu.che.codriver.platform.navi;

import org.json.JSONException;
import org.json.JSONObject;

public class NaviDialog
{
  public static final String TAG = "NaviDialog";
  String mContent;
  String mDialogId;
  String mFirstBtn;
  String mSecondBtn;
  
  public static NaviDialog create(String paramString)
  {
    Object localObject = null;
    try
    {
      NaviDialog localNaviDialog = new NaviDialog();
      localJSONException1.printStackTrace();
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localNaviDialog.mDialogId = paramString.optString("dialogid");
        paramString = paramString.getJSONObject("value");
        localNaviDialog.mContent = paramString.optString("content");
        localNaviDialog.mFirstBtn = paramString.optString("firstbtn");
        localNaviDialog.mSecondBtn = paramString.optString("secondbtn");
        return localNaviDialog;
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          paramString = localJSONException1;
          JSONException localJSONException2 = localJSONException3;
        }
      }
      localJSONException1 = localJSONException1;
      paramString = (String)localObject;
    }
    return paramString;
  }
  
  public static NaviDialog create(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    NaviDialog localNaviDialog = new NaviDialog();
    localNaviDialog.mDialogId = paramString4;
    localNaviDialog.mContent = paramString1;
    localNaviDialog.mFirstBtn = paramString2;
    localNaviDialog.mSecondBtn = paramString3;
    return localNaviDialog;
  }
  
  public void notifyBtnClick(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("dialogid", this.mDialogId);
      if (paramBoolean)
      {
        localJSONObject.put("order", "-1");
        return;
      }
      localJSONObject.put("order", "-2");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/platform/navi/NaviDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */