package de.greenrobot.event;

public class EventBusException
  extends RuntimeException
{
  private static final long serialVersionUID = -2912559384646531479L;
  
  public EventBusException(String paramString)
  {
    super(paramString);
  }
  
  public EventBusException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public EventBusException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/de/greenrobot/event/EventBusException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */