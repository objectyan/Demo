package de.greenrobot.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class SubscriberMethodFinder
{
  private static final Map<String, List<SubscriberMethod>> methodCache = new HashMap();
  private static final Map<Class<?>, Class<?>> skipMethodNameVerificationForClasses = new ConcurrentHashMap();
  
  static void clearCaches()
  {
    methodCache.clear();
  }
  
  public static void clearSkipMethodNameVerifications()
  {
    skipMethodNameVerificationForClasses.clear();
  }
  
  static void skipMethodNameVerificationFor(Class<?> paramClass)
  {
    if (!methodCache.isEmpty()) {
      throw new IllegalStateException("This method must be called before registering anything");
    }
    skipMethodNameVerificationForClasses.put(paramClass, paramClass);
  }
  
  List<SubscriberMethod> findSubscriberMethods(Class<?> arg1, String paramString)
  {
    String str1 = ???.getName() + "@" + ???.hashCode() + '.' + paramString;
    synchronized (methodCache)
    {
      localObject2 = (List)methodCache.get(str1);
      if (localObject2 != null) {
        return (List<SubscriberMethod>)localObject2;
      }
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ???;
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      if (localObject2 != null)
      {
        ??? = ((Class)localObject2).getName();
        if ((!((String)???).startsWith("java.")) && (!((String)???).startsWith("javax.")) && (!((String)???).startsWith("android."))) {}
      }
      else
      {
        if (!localArrayList.isEmpty()) {
          break;
        }
        throw new EventBusException("Subscriber " + ??? + " has no methods called " + paramString);
      }
      Method[] arrayOfMethod = ((Class)localObject2).getDeclaredMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      if (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        String str2 = localMethod.getName();
        if (str2.startsWith(paramString))
        {
          Object localObject3 = localMethod.getParameterTypes();
          if (localObject3.length == 1)
          {
            ??? = str2.substring(paramString.length());
            if (((String)???).length() != 0) {
              break label355;
            }
            ??? = ThreadMode.PostThread;
            label278:
            localObject3 = localObject3[0];
            localStringBuilder.setLength(0);
            localStringBuilder.append(str2);
            localStringBuilder.append('>').append(((Class)localObject3).getName());
            if (localHashSet.add(localStringBuilder.toString())) {
              localArrayList.add(new SubscriberMethod(localMethod, (ThreadMode)???, (Class)localObject3));
            }
          }
        }
        label355:
        do
        {
          i += 1;
          break;
          if (((String)???).equals("MainThread"))
          {
            ??? = ThreadMode.MainThread;
            break label278;
          }
          if (((String)???).equals("BackgroundThread"))
          {
            ??? = ThreadMode.BackgroundThread;
            break label278;
          }
          if (((String)???).equals("Async"))
          {
            ??? = ThreadMode.Async;
            break label278;
          }
        } while (skipMethodNameVerificationForClasses.containsKey(localObject2));
        throw new EventBusException("Illegal onEvent method, check for typos: " + localMethod);
      }
      localObject2 = ((Class)localObject2).getSuperclass();
    }
    synchronized (methodCache)
    {
      methodCache.put(str1, localArrayList);
      return localArrayList;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/de/greenrobot/event/SubscriberMethodFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */