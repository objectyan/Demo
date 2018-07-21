package com.baidu.navisdk.ui.routeguide.model;

public class RGAsrModel
{
  private static RGAsrModel mInstance = null;
  private boolean isUserDismissed = false;
  private String mDefaultAsrContent = null;
  
  public static RGAsrModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGAsrModel();
    }
    return mInstance;
  }
  
  public String getmDefaultAsrContent()
  {
    return this.mDefaultAsrContent;
  }
  
  public boolean isUserDismissed()
  {
    return this.isUserDismissed;
  }
  
  public void setUserDismissed(boolean paramBoolean)
  {
    this.isUserDismissed = paramBoolean;
  }
  
  public void setmDefaultAsrContent(String paramString)
  {
    this.mDefaultAsrContent = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGAsrModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */