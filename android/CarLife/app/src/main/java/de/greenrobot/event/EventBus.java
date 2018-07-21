package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventBus
{
  public static String TAG = "Event";
  private static volatile EventBus defaultInstance;
  private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
  static ExecutorService executorService = ;
  private boolean allowReRegister = true;
  private final AsyncPoster asyncPoster = new AsyncPoster(this);
  private final BackgroundPoster backgroundPoster = new BackgroundPoster(this);
  private final ThreadLocal<List<Object>> currentThreadEventQueue = new ThreadLocal()
  {
    protected List<Object> initialValue()
    {
      return new ArrayList();
    }
  };
  private final ThreadLocal<BooleanWrapper> currentThreadIsPosting = new ThreadLocal()
  {
    protected EventBus.BooleanWrapper initialValue()
    {
      return new EventBus.BooleanWrapper();
    }
  };
  private String defaultMethodName = "onEvent";
  private boolean logSubscriberExceptions = false;
  private final HandlerPoster mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);
  private final Map<Class<?>, Object> stickyEvents = new ConcurrentHashMap();
  private boolean subscribed;
  private final SubscriberMethodFinder subscriberMethodFinder = new SubscriberMethodFinder();
  private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType = new HashMap();
  private final Map<Object, List<Class<?>>> typesBySubscriber = new HashMap();
  private Handler uiHandler = new Handler(Looper.getMainLooper());
  
  static void addInterfaces(List<Class<?>> paramList, Class<?>[] paramArrayOfClass)
  {
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramArrayOfClass[i];
      if (!paramList.contains(localClass))
      {
        paramList.add(localClass);
        addInterfaces(paramList, localClass.getInterfaces());
      }
      i += 1;
    }
  }
  
  public static void clearCaches()
  {
    SubscriberMethodFinder.clearCaches();
    eventTypesCache.clear();
  }
  
  public static void clearSkipMethodNameVerifications() {}
  
  private List<Class<?>> findEventTypes(Class<?> paramClass)
  {
    synchronized (eventTypesCache)
    {
      Object localObject2 = (List)eventTypesCache.get(paramClass);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        for (localObject1 = paramClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass())
        {
          ((List)localObject2).add(localObject1);
          addInterfaces((List)localObject2, ((Class)localObject1).getInterfaces());
        }
        eventTypesCache.put(paramClass, localObject2);
        localObject1 = localObject2;
      }
      return (List<Class<?>>)localObject1;
    }
  }
  
  public static EventBus getDefault()
  {
    if (defaultInstance == null) {}
    try
    {
      if (defaultInstance == null) {
        defaultInstance = new EventBus();
      }
      return defaultInstance;
    }
    finally {}
  }
  
  private void postSingleEvent(Object paramObject, boolean paramBoolean)
    throws Error
  {
    Class localClass = paramObject.getClass();
    List localList = findEventTypes(localClass);
    int j = 0;
    int k = localList.size();
    int i = 0;
    while (i < k)
    {
      Object localObject = (Class)localList.get(i);
      try
      {
        localObject = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(localObject);
        if (localObject != null)
        {
          localObject = ((CopyOnWriteArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            postToSubscription((Subscription)((Iterator)localObject).next(), paramObject, paramBoolean);
          }
          j = 1;
        }
      }
      finally {}
      i += 1;
    }
    if (j == 0)
    {
      Log.d(TAG, "No subscripers registered for event " + localClass);
      if ((localClass != NoSubscriberEvent.class) && (localClass != SubscriberExceptionEvent.class)) {
        post(new NoSubscriberEvent(this, paramObject));
      }
    }
  }
  
  private void postToSubscription(Subscription paramSubscription, Object paramObject, boolean paramBoolean)
  {
    switch (paramSubscription.subscriberMethod.threadMode)
    {
    default: 
      throw new IllegalStateException("Unknown thread mode: " + paramSubscription.subscriberMethod.threadMode);
    case ???: 
      invokeSubscriber(paramSubscription, paramObject);
      return;
    case ???: 
      if (paramBoolean)
      {
        invokeSubscriber(paramSubscription, paramObject);
        return;
      }
      this.mainThreadPoster.enqueue(paramSubscription, paramObject);
      return;
    case ???: 
      if (paramBoolean)
      {
        this.backgroundPoster.enqueue(paramSubscription, paramObject);
        return;
      }
      invokeSubscriber(paramSubscription, paramObject);
      return;
    }
    this.asyncPoster.enqueue(paramSubscription, paramObject);
  }
  
  private void register(Object paramObject, String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = this.subscriberMethodFinder.findSubscriberMethods(paramObject.getClass(), paramString).iterator();
      while (paramString.hasNext()) {
        subscribe(paramObject, (SubscriberMethod)paramString.next(), paramBoolean);
      }
    }
    finally {}
  }
  
  private void register(Object paramObject, String paramString, boolean paramBoolean, Class<?> paramClass, Class<?>... paramVarArgs)
  {
    label121:
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramObject.getClass();
        paramString = this.subscriberMethodFinder.findSubscriberMethods((Class)localObject, paramString).iterator();
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (SubscriberMethod)paramString.next();
        if (paramClass == ((SubscriberMethod)localObject).eventType)
        {
          subscribe(paramObject, (SubscriberMethod)localObject, paramBoolean);
          continue;
        }
        if (paramVarArgs == null) {
          continue;
        }
      }
      finally {}
      int j = paramVarArgs.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label121;
        }
        if (paramVarArgs[i] == ((SubscriberMethod)localObject).eventType)
        {
          subscribe(paramObject, (SubscriberMethod)localObject, paramBoolean);
          break;
        }
        i += 1;
      }
    }
  }
  
  public static void skipMethodNameVerificationFor(Class<?> paramClass)
  {
    SubscriberMethodFinder.skipMethodNameVerificationFor(paramClass);
  }
  
  private void subscribe(Object arg1, SubscriberMethod paramSubscriberMethod, boolean paramBoolean)
  {
    boolean bool = true;
    this.subscribed = true;
    Class localClass = paramSubscriberMethod.eventType;
    CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(localClass);
    Subscription localSubscription = new Subscription(???, paramSubscriberMethod);
    Object localObject;
    if (localCopyOnWriteArrayList == null)
    {
      localObject = new CopyOnWriteArrayList();
      this.subscriptionsByEventType.put(localClass, localObject);
      paramSubscriberMethod.method.setAccessible(true);
      ((CopyOnWriteArrayList)localObject).add(localSubscription);
      localObject = (List)this.typesBySubscriber.get(???);
      paramSubscriberMethod = (SubscriberMethod)localObject;
      if (localObject == null)
      {
        paramSubscriberMethod = new ArrayList();
        this.typesBySubscriber.put(???, paramSubscriberMethod);
      }
      paramSubscriberMethod.add(localClass);
      if (!paramBoolean) {}
    }
    for (;;)
    {
      synchronized (this.stickyEvents)
      {
        paramSubscriberMethod = this.stickyEvents.get(localClass);
        if (paramSubscriberMethod != null)
        {
          if (Looper.getMainLooper() == Looper.myLooper())
          {
            paramBoolean = bool;
            postToSubscription(localSubscription, paramSubscriberMethod, paramBoolean);
          }
        }
        else
        {
          return;
          Iterator localIterator = localCopyOnWriteArrayList.iterator();
          localObject = localCopyOnWriteArrayList;
          if (!localIterator.hasNext()) {
            break;
          }
          if ((!((Subscription)localIterator.next()).equals(localSubscription)) || (this.allowReRegister)) {
            continue;
          }
          throw new EventBusException("Subscriber " + ???.getClass() + " already registered to event " + localClass);
        }
      }
      paramBoolean = false;
    }
  }
  
  private void unubscribeByEventType(Object paramObject, Class<?> paramClass)
  {
    paramClass = (List)this.subscriptionsByEventType.get(paramClass);
    if (paramClass != null)
    {
      int j = paramClass.size();
      int i = 0;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (((Subscription)paramClass.get(i)).subscriber == paramObject)
        {
          paramClass.remove(i);
          m = i - 1;
          k = j - 1;
        }
        i = m + 1;
        j = k;
      }
    }
  }
  
  public void configureLogSubscriberExceptions(boolean paramBoolean) {}
  
  public Object getStickyEvent(Class<?> paramClass)
  {
    synchronized (this.stickyEvents)
    {
      paramClass = this.stickyEvents.get(paramClass);
      return paramClass;
    }
  }
  
  void invokeSubscriber(PendingPost paramPendingPost)
  {
    Object localObject = paramPendingPost.event;
    Subscription localSubscription = paramPendingPost.subscription;
    PendingPost.releasePendingPost(paramPendingPost);
    invokeSubscriber(localSubscription, localObject);
  }
  
  void invokeSubscriber(Subscription paramSubscription, Object paramObject)
    throws Error
  {
    try
    {
      paramSubscription.subscriberMethod.method.invoke(paramSubscription.subscriber, new Object[] { paramObject });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((paramObject instanceof SubscriberExceptionEvent))
      {
        Log.e(TAG, "SubscriberExceptionEvent subscriber " + paramSubscription.subscriber.getClass() + " threw an exception", localThrowable);
        paramSubscription = (SubscriberExceptionEvent)paramObject;
        Log.e(TAG, "Initial event " + paramSubscription.causingEvent + " caused exception in " + paramSubscription.causingSubscriber, paramSubscription.throwable);
        return;
      }
      if (this.logSubscriberExceptions) {
        Log.e(TAG, "Could not dispatch event: " + paramObject.getClass() + " to subscribing class " + paramSubscription.subscriber.getClass(), localThrowable);
      }
      post(new SubscriberExceptionEvent(this, localThrowable, paramObject, paramSubscription.subscriber));
      return;
    }
    catch (IllegalAccessException paramSubscription)
    {
      throw new IllegalStateException("Unexpected exception", paramSubscription);
    }
  }
  
  /* Error */
  public void post(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	de/greenrobot/event/EventBus:currentThreadEventQueue	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 429	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 142	java/util/List
    //   10: astore_3
    //   11: aload_3
    //   12: aload_1
    //   13: invokeinterface 149 2 0
    //   18: pop
    //   19: aload_0
    //   20: getfield 86	de/greenrobot/event/EventBus:currentThreadIsPosting	Ljava/lang/ThreadLocal;
    //   23: invokevirtual 429	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   26: checkcast 16	de/greenrobot/event/EventBus$BooleanWrapper
    //   29: astore_1
    //   30: aload_1
    //   31: getfield 432	de/greenrobot/event/EventBus$BooleanWrapper:value	Z
    //   34: ifeq +4 -> 38
    //   37: return
    //   38: invokestatic 98	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   41: invokestatic 342	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   44: if_acmpne +42 -> 86
    //   47: iconst_1
    //   48: istore_2
    //   49: aload_1
    //   50: iconst_1
    //   51: putfield 432	de/greenrobot/event/EventBus$BooleanWrapper:value	Z
    //   54: aload_3
    //   55: invokeinterface 435 1 0
    //   60: ifne +31 -> 91
    //   63: aload_0
    //   64: aload_3
    //   65: iconst_0
    //   66: invokeinterface 361 2 0
    //   71: iload_2
    //   72: invokespecial 437	de/greenrobot/event/EventBus:postSingleEvent	(Ljava/lang/Object;Z)V
    //   75: goto -21 -> 54
    //   78: astore_3
    //   79: aload_1
    //   80: iconst_0
    //   81: putfield 432	de/greenrobot/event/EventBus$BooleanWrapper:value	Z
    //   84: aload_3
    //   85: athrow
    //   86: iconst_0
    //   87: istore_2
    //   88: goto -39 -> 49
    //   91: aload_1
    //   92: iconst_0
    //   93: putfield 432	de/greenrobot/event/EventBus$BooleanWrapper:value	Z
    //   96: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	EventBus
    //   0	97	1	paramObject	Object
    //   48	40	2	bool	boolean
    //   10	55	3	localList	List
    //   78	7	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	75	78	finally
  }
  
  public void postDelay(final Object paramObject, long paramLong)
  {
    this.uiHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        EventBus.this.post(paramObject);
      }
    }, paramLong);
  }
  
  public void postSticky(Object paramObject)
  {
    synchronized (this.stickyEvents)
    {
      this.stickyEvents.put(paramObject.getClass(), paramObject);
      post(paramObject);
      return;
    }
  }
  
  public void postStickyDelay(final Object paramObject, long paramLong)
  {
    this.uiHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        EventBus.this.postSticky(paramObject);
      }
    }, paramLong);
  }
  
  public void register(Object paramObject)
  {
    register(paramObject, this.defaultMethodName, false);
  }
  
  public void register(Object paramObject, Class<?> paramClass, Class<?>... paramVarArgs)
  {
    register(paramObject, this.defaultMethodName, false, paramClass, paramVarArgs);
  }
  
  public void register(Object paramObject, String paramString)
  {
    register(paramObject, paramString, false);
  }
  
  public void register(Object paramObject, String paramString, Class<?> paramClass, Class<?>... paramVarArgs)
  {
    try
    {
      register(paramObject, paramString, false, paramClass, paramVarArgs);
      return;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public void registerSticky(Object paramObject)
  {
    register(paramObject, this.defaultMethodName, true);
  }
  
  public void registerSticky(Object paramObject, Class<?> paramClass, Class<?>... paramVarArgs)
  {
    register(paramObject, this.defaultMethodName, true, paramClass, paramVarArgs);
  }
  
  public void registerSticky(Object paramObject, String paramString)
  {
    register(paramObject, paramString, true);
  }
  
  public void registerSticky(Object paramObject, String paramString, Class<?> paramClass, Class<?>... paramVarArgs)
  {
    try
    {
      register(paramObject, paramString, true, paramClass, paramVarArgs);
      return;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public Object removeStickyEvent(Class<?> paramClass)
  {
    synchronized (this.stickyEvents)
    {
      paramClass = this.stickyEvents.remove(paramClass);
      return paramClass;
    }
  }
  
  public boolean removeStickyEvent(Object paramObject)
  {
    synchronized (this.stickyEvents)
    {
      Class localClass = paramObject.getClass();
      if (paramObject.equals(this.stickyEvents.get(localClass)))
      {
        this.stickyEvents.remove(localClass);
        return true;
      }
      return false;
    }
  }
  
  public void setAllowReRegister(boolean paramBoolean) {}
  
  public void unregister(Object paramObject)
  {
    try
    {
      Object localObject = (List)this.typesBySubscriber.get(paramObject);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          unubscribeByEventType(paramObject, (Class)((Iterator)localObject).next());
        }
        this.typesBySubscriber.remove(paramObject);
      }
    }
    finally {}
    for (;;)
    {
      return;
      Log.w(TAG, "Subscriber to unregister was not registered before: " + paramObject.getClass());
    }
  }
  
  public void unregister(Object paramObject, Class<?>... paramVarArgs)
  {
    try
    {
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("Provide at least one event class");
      }
    }
    finally {}
    List localList = (List)this.typesBySubscriber.get(paramObject);
    if (localList != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Class<?> localClass = paramVarArgs[i];
        unubscribeByEventType(paramObject, localClass);
        localList.remove(localClass);
        i += 1;
      }
      if (localList.isEmpty()) {
        this.typesBySubscriber.remove(paramObject);
      }
    }
    for (;;)
    {
      return;
      Log.w(TAG, "Subscriber to unregister was not registered before: " + paramObject.getClass());
    }
  }
  
  static final class BooleanWrapper
  {
    boolean value;
  }
  
  static abstract interface PostCallback
  {
    public abstract void onPostCompleted(List<SubscriberExceptionEvent> paramList);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/de/greenrobot/event/EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */