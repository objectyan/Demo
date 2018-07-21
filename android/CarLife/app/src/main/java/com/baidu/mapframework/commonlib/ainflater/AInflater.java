package com.baidu.mapframework.commonlib.ainflater;

import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentCallable;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comapi.util.n;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;

public final class AInflater
{
  private static final ConcurrentMap<Integer, View> a = new ConcurrentHashMap();
  
  public AInflater(ExecutorService paramExecutorService) {}
  
  public void clearCache()
  {
    a.clear();
  }
  
  public View getView(Context paramContext, int paramInt)
    throws ExecutionException, InterruptedException
  {
    if (a.get(Integer.valueOf(paramInt)) != null)
    {
      paramContext = (View)a.get(Integer.valueOf(paramInt));
      f.b("AInflater", "getView from map:" + paramContext);
      return paramContext;
    }
    return normalInflate(paramContext, paramInt);
  }
  
  public View normalInflate(Context paramContext, int paramInt)
  {
    n.b();
    f.e("AInflater", "normalInflate " + paramInt);
    Object localObject1 = LayoutInflater.from(paramContext);
    paramContext = null;
    try
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(paramInt, null);
      paramContext = (Context)localObject1;
      try
      {
        a.put(Integer.valueOf(paramInt), localObject1);
        f.b("AInflater", "put view to map:" + localObject1);
        return (View)localObject1;
      }
      finally
      {
        paramContext = (Context)localObject1;
      }
      return paramContext;
    }
    catch (InflateException localInflateException)
    {
      f.e("AInflater", "normalInflate error");
      localInflateException.printStackTrace();
    }
  }
  
  public void removeCacheView(int paramInt)
  {
    a.remove(Integer.valueOf(paramInt));
  }
  
  public Future<View> submitAInflaterTask(AInflaterTask paramAInflaterTask)
  {
    return ConcurrentManager.submitTask(Module.POI_DETAIL_MODULE, paramAInflaterTask, ScheduleConfig.forData());
  }
  
  public static class AInflaterTask
    extends ConcurrentCallable<View>
  {
    private final SoftReference<Context> a;
    private final int b;
    
    public AInflaterTask(@NotNull Context paramContext, int paramInt)
    {
      this.a = new SoftReference(paramContext);
      this.b = paramInt;
    }
    
    /* Error */
    public View call()
      throws java.lang.Exception
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: invokestatic 39	com/baidu/mapframework/commonlib/ainflater/AInflater:a	()Ljava/util/concurrent/ConcurrentMap;
      //   5: aload_0
      //   6: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   9: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   12: invokeinterface 51 2 0
      //   17: ifnull +48 -> 65
      //   20: invokestatic 39	com/baidu/mapframework/commonlib/ainflater/AInflater:a	()Ljava/util/concurrent/ConcurrentMap;
      //   23: aload_0
      //   24: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   27: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   30: invokeinterface 51 2 0
      //   35: checkcast 53	android/view/View
      //   38: astore_1
      //   39: ldc 55
      //   41: new 57	java/lang/StringBuilder
      //   44: dup
      //   45: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   48: ldc 60
      //   50: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   53: aload_1
      //   54: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   57: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   60: invokestatic 76	com/baidu/platform/comapi/util/f:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   63: aload_1
      //   64: areturn
      //   65: aload_2
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 26	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:a	Ljava/lang/ref/SoftReference;
      //   71: ifnull -8 -> 63
      //   74: aload_2
      //   75: astore_1
      //   76: aload_0
      //   77: getfield 26	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:a	Ljava/lang/ref/SoftReference;
      //   80: invokevirtual 79	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
      //   83: ifnull -20 -> 63
      //   86: aload_0
      //   87: getfield 26	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:a	Ljava/lang/ref/SoftReference;
      //   90: invokevirtual 79	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
      //   93: checkcast 81	android/content/Context
      //   96: invokestatic 87	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   99: astore_1
      //   100: aconst_null
      //   101: astore_2
      //   102: aload_1
      //   103: aload_0
      //   104: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   107: aconst_null
      //   108: invokevirtual 91	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
      //   111: astore_1
      //   112: aload_1
      //   113: astore_2
      //   114: aload_2
      //   115: astore_1
      //   116: aload_2
      //   117: ifnull +251 -> 368
      //   120: ldc 7
      //   122: monitorenter
      //   123: invokestatic 39	com/baidu/mapframework/commonlib/ainflater/AInflater:a	()Ljava/util/concurrent/ConcurrentMap;
      //   126: aload_0
      //   127: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   130: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   133: invokeinterface 95 2 0
      //   138: ifne +44 -> 182
      //   141: invokestatic 39	com/baidu/mapframework/commonlib/ainflater/AInflater:a	()Ljava/util/concurrent/ConcurrentMap;
      //   144: aload_0
      //   145: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   148: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   151: aload_2
      //   152: invokeinterface 99 3 0
      //   157: pop
      //   158: ldc 55
      //   160: new 57	java/lang/StringBuilder
      //   163: dup
      //   164: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   167: ldc 101
      //   169: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   172: aload_2
      //   173: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   176: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   179: invokestatic 76	com/baidu/platform/comapi/util/f:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   182: ldc 7
      //   184: monitorexit
      //   185: aload_2
      //   186: astore_1
      //   187: goto +181 -> 368
      //   190: astore_1
      //   191: ldc 7
      //   193: monitorexit
      //   194: aload_1
      //   195: athrow
      //   196: astore_1
      //   197: ldc 55
      //   199: ldc 103
      //   201: invokestatic 106	com/baidu/platform/comapi/util/f:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   204: aload_1
      //   205: invokevirtual 109	android/view/InflateException:printStackTrace	()V
      //   208: aload_2
      //   209: astore_1
      //   210: iconst_0
      //   211: ifeq +157 -> 368
      //   214: ldc 7
      //   216: monitorenter
      //   217: invokestatic 39	com/baidu/mapframework/commonlib/ainflater/AInflater:a	()Ljava/util/concurrent/ConcurrentMap;
      //   220: aload_0
      //   221: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   224: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   227: invokeinterface 95 2 0
      //   232: ifne +44 -> 276
      //   235: invokestatic 39	com/baidu/mapframework/commonlib/ainflater/AInflater:a	()Ljava/util/concurrent/ConcurrentMap;
      //   238: aload_0
      //   239: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   242: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   245: aconst_null
      //   246: invokeinterface 99 3 0
      //   251: pop
      //   252: ldc 55
      //   254: new 57	java/lang/StringBuilder
      //   257: dup
      //   258: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   261: ldc 101
      //   263: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   266: aconst_null
      //   267: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   270: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   273: invokestatic 76	com/baidu/platform/comapi/util/f:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   276: ldc 7
      //   278: monitorexit
      //   279: aload_2
      //   280: astore_1
      //   281: goto +87 -> 368
      //   284: astore_1
      //   285: ldc 7
      //   287: monitorexit
      //   288: aload_1
      //   289: athrow
      //   290: astore_1
      //   291: iconst_0
      //   292: ifeq +68 -> 360
      //   295: ldc 7
      //   297: monitorenter
      //   298: invokestatic 39	com/baidu/mapframework/commonlib/ainflater/AInflater:a	()Ljava/util/concurrent/ConcurrentMap;
      //   301: aload_0
      //   302: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   305: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   308: invokeinterface 95 2 0
      //   313: ifne +44 -> 357
      //   316: invokestatic 39	com/baidu/mapframework/commonlib/ainflater/AInflater:a	()Ljava/util/concurrent/ConcurrentMap;
      //   319: aload_0
      //   320: getfield 28	com/baidu/mapframework/commonlib/ainflater/AInflater$AInflaterTask:b	I
      //   323: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   326: aconst_null
      //   327: invokeinterface 99 3 0
      //   332: pop
      //   333: ldc 55
      //   335: new 57	java/lang/StringBuilder
      //   338: dup
      //   339: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   342: ldc 101
      //   344: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   347: aconst_null
      //   348: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   351: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   354: invokestatic 76	com/baidu/platform/comapi/util/f:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   357: ldc 7
      //   359: monitorexit
      //   360: aload_1
      //   361: athrow
      //   362: astore_1
      //   363: ldc 7
      //   365: monitorexit
      //   366: aload_1
      //   367: athrow
      //   368: aload_1
      //   369: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	370	0	this	AInflaterTask
      //   38	149	1	localObject1	Object
      //   190	5	1	localObject2	Object
      //   196	9	1	localInflateException	InflateException
      //   209	72	1	localObject3	Object
      //   284	5	1	localObject4	Object
      //   290	71	1	localObject5	Object
      //   362	7	1	localView	View
      //   1	279	2	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   123	182	190	finally
      //   182	185	190	finally
      //   191	194	190	finally
      //   102	112	196	android/view/InflateException
      //   217	276	284	finally
      //   276	279	284	finally
      //   285	288	284	finally
      //   102	112	290	finally
      //   197	208	290	finally
      //   298	357	362	finally
      //   357	360	362	finally
      //   363	366	362	finally
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/ainflater/AInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */