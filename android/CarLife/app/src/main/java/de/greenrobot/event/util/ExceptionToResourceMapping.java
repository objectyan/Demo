package de.greenrobot.event.util;

import android.util.Log;
import de.greenrobot.event.EventBus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExceptionToResourceMapping
{
  public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap();
  
  public ExceptionToResourceMapping addMapping(Class<? extends Throwable> paramClass, int paramInt)
  {
    this.throwableToMsgIdMap.put(paramClass, Integer.valueOf(paramInt));
    return this;
  }
  
  public Integer mapThrowable(Throwable paramThrowable)
  {
    Object localObject1 = paramThrowable;
    int i = 20;
    Object localObject2;
    do
    {
      localObject2 = mapThrowableFlat((Throwable)localObject1);
      if (localObject2 != null) {
        return (Integer)localObject2;
      }
      localObject2 = ((Throwable)localObject1).getCause();
      i -= 1;
      if ((i <= 0) || (localObject2 == paramThrowable)) {
        break;
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    Log.d(EventBus.TAG, "No specific message ressource ID found for " + paramThrowable);
    return null;
  }
  
  protected Integer mapThrowableFlat(Throwable paramThrowable)
  {
    Class localClass = paramThrowable.getClass();
    paramThrowable = (Integer)this.throwableToMsgIdMap.get(localClass);
    Object localObject2 = paramThrowable;
    if (paramThrowable == null)
    {
      Object localObject1 = null;
      Iterator localIterator = this.throwableToMsgIdMap.entrySet().iterator();
      for (;;)
      {
        localObject2 = paramThrowable;
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localObject2 = (Class)localEntry.getKey();
        if ((((Class)localObject2).isAssignableFrom(localClass)) && ((localObject1 == null) || (((Class)localObject1).isAssignableFrom((Class)localObject2))))
        {
          localObject1 = localObject2;
          paramThrowable = (Integer)localEntry.getValue();
        }
      }
    }
    return (Integer)localObject2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/de/greenrobot/event/util/ExceptionToResourceMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */