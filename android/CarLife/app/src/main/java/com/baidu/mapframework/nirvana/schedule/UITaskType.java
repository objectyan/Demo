package com.baidu.mapframework.nirvana.schedule;

public class UITaskType
  implements TaskType
{
  private final UIType a;
  private final String b;
  
  private UITaskType(UIType paramUIType, String paramString)
  {
    this.a = paramUIType;
    this.b = paramString;
  }
  
  public static UITaskType forActivity(String paramString)
  {
    return new UITaskType(UIType.ACTIVITY, paramString);
  }
  
  public static UITaskType forPage(String paramString)
  {
    return new UITaskType(UIType.PAGE, paramString);
  }
  
  public static UITaskType forScene(String paramString)
  {
    return new UITaskType(UIType.SCENE, paramString);
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public UIType getType()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "UITaskType{type=" + this.a + ", name='" + this.b + '\'' + '}';
  }
  
  public static enum UIType
  {
    private UIType() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/schedule/UITaskType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */