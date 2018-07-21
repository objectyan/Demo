package com.baidu.mapframework.nirvana.looper;

public abstract class LooperTask
  extends BaseLooperTask
{
  private long delay = 0L;
  
  public LooperTask() {}
  
  public LooperTask(long paramLong)
  {
    this.delay = paramLong;
  }
  
  public LooperTask(String paramString)
  {
    appendDescription(paramString);
  }
  
  long getDelay()
  {
    return this.delay;
  }
  
  public void setDelay(long paramLong)
  {
    this.delay = paramLong;
  }
  
  public String toString()
  {
    return "LooperTask{description=" + getDescription() + ", delay=" + this.delay + ", isCancel=" + isCancel() + '}';
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/looper/LooperTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */