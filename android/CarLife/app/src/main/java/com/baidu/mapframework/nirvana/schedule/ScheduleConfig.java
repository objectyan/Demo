package com.baidu.mapframework.nirvana.schedule;

import com.baidu.mapframework.nirvana.e;

public class ScheduleConfig
{
  private static final ScheduleConfig d = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
  private static final ScheduleConfig e = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.SETUP);
  private static final ScheduleConfig f = new ScheduleConfig(DataTaskType.forStatictics(), ScheduleTag.NULL);
  private final TaskType a;
  private final ScheduleTag b;
  private LifecycleManager.Lifecycle c;
  
  public ScheduleConfig(TaskType paramTaskType, ScheduleTag paramScheduleTag)
  {
    this.a = paramTaskType;
    this.b = paramScheduleTag;
  }
  
  public static ScheduleConfig forData()
  {
    return d;
  }
  
  public static ScheduleConfig forSetupData()
  {
    return e;
  }
  
  public static ScheduleConfig forStatistics()
  {
    return f;
  }
  
  public static ScheduleConfig uiPage(String paramString)
  {
    return new ScheduleConfig(UITaskType.forPage(paramString), ScheduleTag.NULL);
  }
  
  public static ScheduleConfig uiScene(String paramString)
  {
    return new ScheduleConfig(UITaskType.forScene(paramString), ScheduleTag.NULL);
  }
  
  public void bindLifecycle()
  {
    if ((this.a instanceof UITaskType))
    {
      UITaskType localUITaskType = (UITaskType)this.a;
      this.c = e.d().a(localUITaskType.getType(), localUITaskType.getName());
    }
  }
  
  public ScheduleTag getTag()
  {
    return this.b;
  }
  
  public TaskType getType()
  {
    return this.a;
  }
  
  public boolean isLifecycleActive()
  {
    if (this.c != null) {
      return this.c.isActive();
    }
    return true;
  }
  
  public String toString()
  {
    return "ScheduleConfig{type=" + this.a + ", tag=" + this.b + '}';
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/schedule/ScheduleConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */