package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.facebook.common.h.a;
import com.facebook.common.h.c;
import com.facebook.common.internal.k;
import com.facebook.common.internal.o;
import com.facebook.imagepipeline.e.e;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public class b
{
  @GuardedBy("this")
  private int a;
  @GuardedBy("this")
  private long b;
  private final int c;
  private final int d;
  private final c<Bitmap> e;
  
  public b(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      bool1 = true;
      k.a(bool1);
      if (paramInt2 <= 0) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.a(bool1);
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = new c()
      {
        public void a(Bitmap paramAnonymousBitmap)
        {
          try
          {
            b.this.b(paramAnonymousBitmap);
            return;
          }
          finally
          {
            paramAnonymousBitmap.recycle();
          }
        }
      };
      return;
      bool1 = false;
      break;
    }
  }
  
  public int a()
  {
    try
    {
      int i = this.a;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public List<a<Bitmap>> a(List<Bitmap> paramList)
  {
    int i = 0;
    ArrayList localArrayList;
    try
    {
      if (i < paramList.size())
      {
        Bitmap localBitmap = (Bitmap)paramList.get(i);
        if (Build.VERSION.SDK_INT < 21) {
          Bitmaps.a(localBitmap);
        }
        if (!a(localBitmap)) {
          throw new e();
        }
      }
    }
    catch (Exception localException)
    {
      while (paramList != null)
      {
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            Object localObject = (Bitmap)paramList.next();
            if (i > 0) {
              b((Bitmap)localObject);
            }
            ((Bitmap)localObject).recycle();
            i -= 1;
            continue;
            i += 1;
            break;
            localArrayList = new ArrayList();
            localObject = paramList.iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add(a.a((Bitmap)((Iterator)localObject).next(), this.e));
            }
          }
        }
      }
      throw o.b(localArrayList);
    }
    return localArrayList;
  }
  
  /* Error */
  public boolean a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 114	com/facebook/h/a:a	(Landroid/graphics/Bitmap;)I
    //   6: istore_2
    //   7: aload_0
    //   8: getfield 41	com/facebook/imagepipeline/memory/b:a	I
    //   11: aload_0
    //   12: getfield 30	com/facebook/imagepipeline/memory/b:c	I
    //   15: if_icmpge +29 -> 44
    //   18: aload_0
    //   19: getfield 116	com/facebook/imagepipeline/memory/b:b	J
    //   22: lstore 4
    //   24: iload_2
    //   25: i2l
    //   26: lstore 6
    //   28: aload_0
    //   29: getfield 32	com/facebook/imagepipeline/memory/b:d	I
    //   32: istore_3
    //   33: lload 4
    //   35: lload 6
    //   37: ladd
    //   38: iload_3
    //   39: i2l
    //   40: lcmp
    //   41: ifle +11 -> 52
    //   44: iconst_0
    //   45: istore 8
    //   47: aload_0
    //   48: monitorexit
    //   49: iload 8
    //   51: ireturn
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 41	com/facebook/imagepipeline/memory/b:a	I
    //   57: iconst_1
    //   58: iadd
    //   59: putfield 41	com/facebook/imagepipeline/memory/b:a	I
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 116	com/facebook/imagepipeline/memory/b:b	J
    //   67: iload_2
    //   68: i2l
    //   69: ladd
    //   70: putfield 116	com/facebook/imagepipeline/memory/b:b	J
    //   73: iconst_1
    //   74: istore 8
    //   76: goto -29 -> 47
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	b
    //   0	84	1	paramBitmap	Bitmap
    //   6	62	2	i	int
    //   32	7	3	j	int
    //   22	12	4	l1	long
    //   26	10	6	l2	long
    //   45	30	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	79	finally
    //   28	33	79	finally
    //   52	73	79	finally
  }
  
  public long b()
  {
    try
    {
      long l = this.b;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void b(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: invokestatic 114	com/facebook/h/a:a	(Landroid/graphics/Bitmap;)I
    //   9: istore_2
    //   10: aload_0
    //   11: getfield 41	com/facebook/imagepipeline/memory/b:a	I
    //   14: ifle +75 -> 89
    //   17: iconst_1
    //   18: istore_3
    //   19: iload_3
    //   20: ldc 119
    //   22: invokestatic 122	com/facebook/common/internal/k:a	(ZLjava/lang/Object;)V
    //   25: iload_2
    //   26: i2l
    //   27: aload_0
    //   28: getfield 116	com/facebook/imagepipeline/memory/b:b	J
    //   31: lcmp
    //   32: ifgt +62 -> 94
    //   35: iload 4
    //   37: istore_3
    //   38: iload_3
    //   39: ldc 124
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload_2
    //   48: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: aload_0
    //   55: getfield 116	com/facebook/imagepipeline/memory/b:b	J
    //   58: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: aastore
    //   62: invokestatic 138	com/facebook/common/internal/k:a	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 116	com/facebook/imagepipeline/memory/b:b	J
    //   70: iload_2
    //   71: i2l
    //   72: lsub
    //   73: putfield 116	com/facebook/imagepipeline/memory/b:b	J
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 41	com/facebook/imagepipeline/memory/b:a	I
    //   81: iconst_1
    //   82: isub
    //   83: putfield 41	com/facebook/imagepipeline/memory/b:a	I
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: iconst_0
    //   90: istore_3
    //   91: goto -72 -> 19
    //   94: iconst_0
    //   95: istore_3
    //   96: goto -58 -> 38
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	b
    //   0	104	1	paramBitmap	Bitmap
    //   9	62	2	i	int
    //   18	78	3	bool1	boolean
    //   1	35	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	17	99	finally
    //   19	35	99	finally
    //   38	86	99	finally
  }
  
  public c<Bitmap> c()
  {
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */