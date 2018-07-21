package com.facebook.imagepipeline.l;

import com.facebook.b.a.d;
import com.facebook.common.h.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.d.f;
import com.facebook.imagepipeline.d.p;
import com.facebook.imagepipeline.i.b;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.m.c.b;
import java.util.Map;

public class h
  implements ai<a<b>>
{
  @VisibleForTesting
  static final String b = "BitmapMemoryCacheProducer";
  @VisibleForTesting
  static final String c = "cached_value_found";
  private final p<d, b> a;
  private final f d;
  private final ai<a<b>> e;
  
  public h(p<d, b> paramp, f paramf, ai<a<b>> paramai)
  {
    this.a = paramp;
    this.d = paramf;
    this.e = paramai;
  }
  
  protected j<a<b>> a(j<a<b>> paramj, final d paramd)
  {
    new m(paramj)
    {
      /* Error */
      public void a(a<b> paramAnonymousa, boolean paramAnonymousBoolean)
      {
        // Byte code:
        //   0: aload_1
        //   1: ifnonnull +19 -> 20
        //   4: iload_2
        //   5: ifeq +14 -> 19
        //   8: aload_0
        //   9: invokevirtual 28	com/facebook/imagepipeline/l/h$1:d	()Lcom/facebook/imagepipeline/l/j;
        //   12: aconst_null
        //   13: iconst_1
        //   14: invokeinterface 33 3 0
        //   19: return
        //   20: aload_1
        //   21: invokevirtual 38	com/facebook/common/h/a:a	()Ljava/lang/Object;
        //   24: checkcast 40	com/facebook/imagepipeline/i/b
        //   27: invokevirtual 44	com/facebook/imagepipeline/i/b:e	()Z
        //   30: ifeq +15 -> 45
        //   33: aload_0
        //   34: invokevirtual 28	com/facebook/imagepipeline/l/h$1:d	()Lcom/facebook/imagepipeline/l/j;
        //   37: aload_1
        //   38: iload_2
        //   39: invokeinterface 33 3 0
        //   44: return
        //   45: iload_2
        //   46: ifne +95 -> 141
        //   49: aload_0
        //   50: getfield 17	com/facebook/imagepipeline/l/h$1:b	Lcom/facebook/imagepipeline/l/h;
        //   53: invokestatic 47	com/facebook/imagepipeline/l/h:a	(Lcom/facebook/imagepipeline/l/h;)Lcom/facebook/imagepipeline/d/p;
        //   56: aload_0
        //   57: getfield 19	com/facebook/imagepipeline/l/h$1:a	Lcom/facebook/b/a/d;
        //   60: invokeinterface 52 2 0
        //   65: astore_3
        //   66: aload_3
        //   67: ifnull +74 -> 141
        //   70: aload_1
        //   71: invokevirtual 38	com/facebook/common/h/a:a	()Ljava/lang/Object;
        //   74: checkcast 40	com/facebook/imagepipeline/i/b
        //   77: invokevirtual 55	com/facebook/imagepipeline/i/b:d	()Lcom/facebook/imagepipeline/i/g;
        //   80: astore 4
        //   82: aload_3
        //   83: invokevirtual 38	com/facebook/common/h/a:a	()Ljava/lang/Object;
        //   86: checkcast 40	com/facebook/imagepipeline/i/b
        //   89: invokevirtual 55	com/facebook/imagepipeline/i/b:d	()Lcom/facebook/imagepipeline/i/g;
        //   92: astore 5
        //   94: aload 5
        //   96: invokeinterface 60 1 0
        //   101: ifne +20 -> 121
        //   104: aload 5
        //   106: invokeinterface 63 1 0
        //   111: aload 4
        //   113: invokeinterface 63 1 0
        //   118: if_icmplt +19 -> 137
        //   121: aload_0
        //   122: invokevirtual 28	com/facebook/imagepipeline/l/h$1:d	()Lcom/facebook/imagepipeline/l/j;
        //   125: aload_3
        //   126: iconst_0
        //   127: invokeinterface 33 3 0
        //   132: aload_3
        //   133: invokestatic 66	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
        //   136: return
        //   137: aload_3
        //   138: invokestatic 66	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
        //   141: aload_0
        //   142: getfield 17	com/facebook/imagepipeline/l/h$1:b	Lcom/facebook/imagepipeline/l/h;
        //   145: invokestatic 47	com/facebook/imagepipeline/l/h:a	(Lcom/facebook/imagepipeline/l/h;)Lcom/facebook/imagepipeline/d/p;
        //   148: aload_0
        //   149: getfield 19	com/facebook/imagepipeline/l/h$1:a	Lcom/facebook/b/a/d;
        //   152: aload_1
        //   153: invokeinterface 69 3 0
        //   158: astore_3
        //   159: iload_2
        //   160: ifeq +13 -> 173
        //   163: aload_0
        //   164: invokevirtual 28	com/facebook/imagepipeline/l/h$1:d	()Lcom/facebook/imagepipeline/l/j;
        //   167: fconst_1
        //   168: invokeinterface 72 2 0
        //   173: aload_0
        //   174: invokevirtual 28	com/facebook/imagepipeline/l/h$1:d	()Lcom/facebook/imagepipeline/l/j;
        //   177: astore 4
        //   179: aload_3
        //   180: ifnull +5 -> 185
        //   183: aload_3
        //   184: astore_1
        //   185: aload 4
        //   187: aload_1
        //   188: iload_2
        //   189: invokeinterface 33 3 0
        //   194: aload_3
        //   195: invokestatic 66	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
        //   198: return
        //   199: astore_1
        //   200: aload_3
        //   201: invokestatic 66	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
        //   204: aload_1
        //   205: athrow
        //   206: astore_1
        //   207: aload_3
        //   208: invokestatic 66	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
        //   211: aload_1
        //   212: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	213	0	this	1
        //   0	213	1	paramAnonymousa	a<b>
        //   0	213	2	paramAnonymousBoolean	boolean
        //   65	143	3	locala	a
        //   80	106	4	localObject	Object
        //   92	13	5	localg	com.facebook.imagepipeline.i.g
        // Exception table:
        //   from	to	target	type
        //   70	121	199	finally
        //   121	132	199	finally
        //   163	173	206	finally
        //   173	179	206	finally
        //   185	194	206	finally
      }
    };
  }
  
  protected String a()
  {
    return "BitmapMemoryCacheProducer";
  }
  
  public void a(j<a<b>> paramj, aj paramaj)
  {
    Object localObject2 = null;
    al localal = paramaj.c();
    String str1 = paramaj.b();
    localal.a(str1, a());
    Object localObject1 = paramaj.a();
    Object localObject3 = paramaj.d();
    localObject3 = this.d.a((c)localObject1, localObject3);
    a locala = this.a.a(localObject3);
    if (locala != null)
    {
      boolean bool = ((b)locala.a()).d().c();
      String str2;
      if (bool)
      {
        str2 = a();
        if (!localal.b(str1)) {
          break label168;
        }
      }
      label168:
      for (localObject1 = com.facebook.common.internal.g.a("cached_value_found", "true");; localObject1 = null)
      {
        localal.a(str1, str2, (Map)localObject1);
        paramj.b(1.0F);
        paramj.b(locala, bool);
        locala.close();
        if (!bool) {
          break;
        }
        return;
      }
    }
    if (paramaj.e().a() >= c.b.d.a())
    {
      localObject1 = a();
      if (localal.b(str1)) {}
      for (paramaj = com.facebook.common.internal.g.a("cached_value_found", "false");; paramaj = null)
      {
        localal.a(str1, (String)localObject1, paramaj);
        paramj.b(null, true);
        return;
      }
    }
    localObject1 = a(paramj, (d)localObject3);
    localObject3 = a();
    paramj = (j<a<b>>)localObject2;
    if (localal.b(str1)) {
      paramj = com.facebook.common.internal.g.a("cached_value_found", "false");
    }
    localal.a(str1, (String)localObject3, paramj);
    this.e.a((j)localObject1, paramaj);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */