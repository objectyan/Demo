package com.baidu.mapframework.nirvana.schedule;

import android.text.TextUtils;
import com.baidu.mapframework.nirvana.b.a;
import java.util.HashMap;

public class LifecycleManager
{
  public static final String TAG = a.class.getSimpleName();
  private volatile long a = 0L;
  private String b;
  private UIState c;
  private volatile HashMap<String, UIState> d = new HashMap();
  
  Lifecycle a(UITaskType.UIType paramUIType, String paramString)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        int i = 1.a[paramUIType.ordinal()];
        switch (i)
        {
        default: 
          paramUIType = (UITaskType.UIType)localObject;
          return paramUIType;
        }
      }
      finally {}
      if (TextUtils.equals(paramString, this.b))
      {
        paramUIType = new PageLifecycle(this.a, null);
      }
      else
      {
        paramUIType = new PageLifecycle(-1L, null);
        continue;
        paramUIType = new SceneLifecycle(paramString, null);
      }
    }
  }
  
  /* Error */
  public void onUIStateChange(UITaskType.UIType paramUIType, String paramString, UIState paramUIState)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 40	com/baidu/mapframework/nirvana/schedule/LifecycleManager:TAG	Ljava/lang/String;
    //   5: new 83	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   12: ldc 86
    //   14: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: ldc 95
    //   23: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_2
    //   27: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 95
    //   32: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 103	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: getstatic 57	com/baidu/mapframework/nirvana/schedule/LifecycleManager$1:a	[I
    //   49: aload_1
    //   50: invokevirtual 63	com/baidu/mapframework/nirvana/schedule/UITaskType$UIType:ordinal	()I
    //   53: iaload
    //   54: istore 4
    //   56: iload 4
    //   58: tableswitch	default:+22->80, 1:+25->83, 2:+45->103
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: aload_2
    //   85: putfield 65	com/baidu/mapframework/nirvana/schedule/LifecycleManager:b	Ljava/lang/String;
    //   88: aload_0
    //   89: aload_3
    //   90: putfield 105	com/baidu/mapframework/nirvana/schedule/LifecycleManager:c	Lcom/baidu/mapframework/nirvana/schedule/LifecycleManager$UIState;
    //   93: aload_0
    //   94: aload_0
    //   95: getfield 46	com/baidu/mapframework/nirvana/schedule/LifecycleManager:a	J
    //   98: lconst_1
    //   99: ladd
    //   100: putfield 46	com/baidu/mapframework/nirvana/schedule/LifecycleManager:a	J
    //   103: aload_0
    //   104: getfield 51	com/baidu/mapframework/nirvana/schedule/LifecycleManager:d	Ljava/util/HashMap;
    //   107: aload_2
    //   108: aload_3
    //   109: invokevirtual 109	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: goto -33 -> 80
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	LifecycleManager
    //   0	121	1	paramUIType	UITaskType.UIType
    //   0	121	2	paramString	String
    //   0	121	3	paramUIState	UIState
    //   54	3	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	56	116	finally
    //   83	103	116	finally
    //   103	113	116	finally
  }
  
  static abstract interface Lifecycle
  {
    public abstract boolean isActive();
  }
  
  class PageLifecycle
    implements LifecycleManager.Lifecycle
  {
    private final long b;
    
    private PageLifecycle(long paramLong)
    {
      this.b = paramLong;
    }
    
    public boolean isActive()
    {
      return LifecycleManager.a(LifecycleManager.this) == this.b;
    }
  }
  
  class SceneLifecycle
    implements LifecycleManager.Lifecycle
  {
    private final String b;
    
    private SceneLifecycle(String paramString)
    {
      this.b = paramString;
    }
    
    public boolean isActive()
    {
      LifecycleManager.UIState localUIState = (LifecycleManager.UIState)LifecycleManager.b(LifecycleManager.this).get(this.b);
      return (localUIState != null) && (localUIState == LifecycleManager.UIState.ACTIVE);
    }
  }
  
  public static enum UIState
  {
    private UIState() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/schedule/LifecycleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */