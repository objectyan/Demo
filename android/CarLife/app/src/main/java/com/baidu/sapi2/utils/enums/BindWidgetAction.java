package com.baidu.sapi2.utils.enums;

public enum BindWidgetAction
{
  private String a;
  private String b;
  
  static
  {
    BIND_EMAIL = new BindWidgetAction("BIND_EMAIL", 1, "/wp/bindwidget-bindemail", "绑定邮箱");
    REBIND_MOBILE = new BindWidgetAction("REBIND_MOBILE", 2, "/wp/bindwidget-rebindmobile", "换绑手机");
    REBIND_EMAIL = new BindWidgetAction("REBIND_EMAIL", 3, "/wp/bindwidget-rebindemail", "换绑邮箱");
    UNBIND_MOBILE = new BindWidgetAction("UNBIND_MOBILE", 4, "/wp/bindwidget-unbindmobile", "解绑手机");
  }
  
  private BindWidgetAction(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public String getUri()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/enums/BindWidgetAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */