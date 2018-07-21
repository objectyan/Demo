package com.baidu.navisdk.comapi.base;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class MsgHandler
  extends Handler
{
  private Set<Integer> mInterests = new HashSet();
  
  public MsgHandler()
  {
    careAbout();
  }
  
  public MsgHandler(Looper paramLooper)
  {
    super(paramLooper);
    careAbout();
  }
  
  public abstract void careAbout();
  
  public Set<Integer> getInterests()
  {
    return this.mInterests;
  }
  
  public void ignore(Collection<Integer> paramCollection)
  {
    try
    {
      if ((this.mInterests != null) && (paramCollection != null)) {
        this.mInterests.removeAll(paramCollection);
      }
      return;
    }
    finally {}
  }
  
  public void ignore(Integer[] paramArrayOfInteger)
  {
    try
    {
      if ((this.mInterests != null) && (paramArrayOfInteger != null)) {
        this.mInterests.removeAll(Arrays.asList(paramArrayOfInteger));
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean ignore(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/baidu/navisdk/comapi/base/MsgHandler:mInterests	Ljava/util/Set;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 16	com/baidu/navisdk/comapi/base/MsgHandler:mInterests	Ljava/util/Set;
    //   13: iload_1
    //   14: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 54 2 0
    //   22: istore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_2
    //   29: goto -6 -> 23
    //   32: astore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	MsgHandler
    //   0	37	1	paramInt	int
    //   22	7	2	bool	boolean
    //   32	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  /* Error */
  public boolean isObserved(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/baidu/navisdk/comapi/base/MsgHandler:mInterests	Ljava/util/Set;
    //   6: ifnull +27 -> 33
    //   9: aload_0
    //   10: getfield 16	com/baidu/navisdk/comapi/base/MsgHandler:mInterests	Ljava/util/Set;
    //   13: iload_1
    //   14: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 58 2 0
    //   22: istore_2
    //   23: iload_2
    //   24: ifeq +9 -> 33
    //   27: iconst_1
    //   28: istore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -6 -> 29
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	MsgHandler
    //   0	43	1	paramInt	int
    //   22	13	2	bool	boolean
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	38	finally
  }
  
  public void observe(int paramInt)
  {
    try
    {
      if (this.mInterests != null) {
        this.mInterests.add(Integer.valueOf(paramInt));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void observe(Collection<Integer> paramCollection)
  {
    try
    {
      if ((this.mInterests != null) && (paramCollection != null)) {
        this.mInterests.addAll(paramCollection);
      }
      return;
    }
    finally {}
  }
  
  public void observe(int[] paramArrayOfInt)
  {
    try
    {
      if ((this.mInterests != null) && (paramArrayOfInt != null))
      {
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = paramArrayOfInt[i];
          this.mInterests.add(Integer.valueOf(k));
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/base/MsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */