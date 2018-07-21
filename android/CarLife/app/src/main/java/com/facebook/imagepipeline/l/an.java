package com.facebook.imagepipeline.l;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import com.facebook.common.m.f;
import com.facebook.f.b;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.memory.z;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class an
  implements ai<com.facebook.imagepipeline.i.d>
{
  @VisibleForTesting
  static final int a = 85;
  @VisibleForTesting
  static final int b = 8;
  @VisibleForTesting
  static final int c = 100;
  private static final String d = "ResizeAndRotateProducer";
  private static final String e = "Original size";
  private static final String f = "Requested size";
  private static final String g = "Fraction";
  private static final float h = 0.6666667F;
  private final Executor i;
  private final z j;
  private final ai<com.facebook.imagepipeline.i.d> k;
  
  public an(Executor paramExecutor, z paramz, ai<com.facebook.imagepipeline.i.d> paramai)
  {
    this.i = ((Executor)k.a(paramExecutor));
    this.j = ((z)k.a(paramz));
    this.k = ((ai)k.a(paramai));
  }
  
  @VisibleForTesting
  static float a(com.facebook.imagepipeline.e.d paramd, int paramInt1, int paramInt2)
  {
    float f2;
    if (paramd == null) {
      f2 = 1.0F;
    }
    float f1;
    do
    {
      return f2;
      f2 = Math.max(paramd.a / paramInt1, paramd.b / paramInt2);
      f1 = f2;
      if (paramInt1 * f2 > 2048.0F) {
        f1 = 2048.0F / paramInt1;
      }
      f2 = f1;
    } while (paramInt2 * f1 <= 2048.0F);
    return 2048.0F / paramInt2;
  }
  
  @VisibleForTesting
  static int a(float paramFloat)
  {
    return (int)(0.6666667F + 8.0F * paramFloat);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt < 8;
  }
  
  private static f d(c paramc, com.facebook.imagepipeline.i.d paramd)
  {
    if ((paramd == null) || (paramd.e() == b.j)) {
      return f.c;
    }
    if (paramd.e() != b.f) {
      return f.b;
    }
    if ((f(paramc, paramd) != 0) || (a(e(paramc, paramd)))) {}
    for (boolean bool = true;; bool = false) {
      return f.a(bool);
    }
  }
  
  private static int e(c paramc, com.facebook.imagepipeline.i.d paramd)
  {
    com.facebook.imagepipeline.e.d locald = paramc.e();
    int m;
    if (locald == null) {
      m = 8;
    }
    int n;
    label46:
    label80:
    label88:
    label96:
    do
    {
      return m;
      m = f(paramc, paramd);
      if ((m == 90) || (m == 270))
      {
        n = 1;
        if (n == 0) {
          break label80;
        }
        m = paramd.h();
        if (n == 0) {
          break label88;
        }
      }
      for (n = paramd.g();; n = paramd.h())
      {
        n = a(a(locald, m, n));
        if (n <= 8) {
          break label96;
        }
        return 8;
        n = 0;
        break;
        m = paramd.g();
        break label46;
      }
      m = n;
    } while (n >= 1);
    return 1;
  }
  
  private static int f(c paramc, com.facebook.imagepipeline.i.d paramd)
  {
    boolean bool = false;
    if (!paramc.g()) {
      return 0;
    }
    int m = paramd.f();
    if ((m == 0) || (m == 90) || (m == 180) || (m == 270)) {
      bool = true;
    }
    k.a(bool);
    return m;
  }
  
  public void a(j<com.facebook.imagepipeline.i.d> paramj, aj paramaj)
  {
    this.k.a(new a(paramj, paramaj), paramaj);
  }
  
  private class a
    extends m<com.facebook.imagepipeline.i.d, com.facebook.imagepipeline.i.d>
  {
    private final aj b;
    private boolean c = false;
    private final t d;
    
    public a(final aj paramaj)
    {
      super();
      this.b = local1;
      t.a local1 = new t.a()
      {
        public void a(com.facebook.imagepipeline.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          an.a.a(an.a.this, paramAnonymousd, paramAnonymousBoolean);
        }
      };
      this.d = new t(an.a(an.this), local1, 100);
      this.b.a(new e()
      {
        public void a()
        {
          an.a.b(an.a.this).a();
          an.a.a(an.a.this, true);
          paramaj.b();
        }
        
        public void c()
        {
          if (an.a.a(an.a.this).h()) {
            an.a.b(an.a.this).b();
          }
        }
      });
    }
    
    private Map<String, String> a(com.facebook.imagepipeline.i.d paramd, c paramc, int paramInt)
    {
      if (!this.b.c().b(this.b.b())) {
        return null;
      }
      String str = paramd.g() + "x" + paramd.h();
      if (paramc.e() != null)
      {
        paramd = paramc.e().a + "x" + paramc.e().b;
        if (paramInt <= 0) {
          break label158;
        }
      }
      label158:
      for (paramc = paramInt + "/8";; paramc = "")
      {
        return g.a("Original size", str, "Requested size", paramd, "Fraction", paramc, "queueTime", String.valueOf(this.d.c()));
        paramd = "Unspecified";
        break;
      }
    }
    
    /* Error */
    private void b(com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 30	com/facebook/imagepipeline/l/an$a:b	Lcom/facebook/imagepipeline/l/aj;
      //   4: invokeinterface 59 1 0
      //   9: aload_0
      //   10: getfield 30	com/facebook/imagepipeline/l/an$a:b	Lcom/facebook/imagepipeline/l/aj;
      //   13: invokeinterface 62 1 0
      //   18: ldc -111
      //   20: invokeinterface 148 3 0
      //   25: aload_0
      //   26: getfield 30	com/facebook/imagepipeline/l/an$a:b	Lcom/facebook/imagepipeline/l/aj;
      //   29: invokeinterface 151 1 0
      //   34: astore 11
      //   36: aload_0
      //   37: getfield 23	com/facebook/imagepipeline/l/an$a:a	Lcom/facebook/imagepipeline/l/an;
      //   40: invokestatic 154	com/facebook/imagepipeline/l/an:b	(Lcom/facebook/imagepipeline/l/an;)Lcom/facebook/imagepipeline/memory/z;
      //   43: invokeinterface 159 1 0
      //   48: astore 10
      //   50: aconst_null
      //   51: astore 8
      //   53: aconst_null
      //   54: astore 9
      //   56: aconst_null
      //   57: astore 4
      //   59: aload 8
      //   61: astore 6
      //   63: aload 4
      //   65: astore 7
      //   67: aload 9
      //   69: astore 5
      //   71: aload 11
      //   73: aload_1
      //   74: invokestatic 162	com/facebook/imagepipeline/l/an:b	(Lcom/facebook/imagepipeline/m/c;Lcom/facebook/imagepipeline/i/d;)I
      //   77: istore_3
      //   78: aload 8
      //   80: astore 6
      //   82: aload 4
      //   84: astore 7
      //   86: aload 9
      //   88: astore 5
      //   90: aload_0
      //   91: aload_1
      //   92: aload 11
      //   94: iload_3
      //   95: invokespecial 164	com/facebook/imagepipeline/l/an$a:a	(Lcom/facebook/imagepipeline/i/d;Lcom/facebook/imagepipeline/m/c;I)Ljava/util/Map;
      //   98: astore 8
      //   100: aload 8
      //   102: astore 6
      //   104: aload 4
      //   106: astore 7
      //   108: aload 9
      //   110: astore 5
      //   112: aload_1
      //   113: invokevirtual 167	com/facebook/imagepipeline/i/d:d	()Ljava/io/InputStream;
      //   116: astore 4
      //   118: aload 8
      //   120: astore 6
      //   122: aload 4
      //   124: astore 7
      //   126: aload 4
      //   128: astore 5
      //   130: aload 4
      //   132: aload 10
      //   134: aload 11
      //   136: aload_1
      //   137: invokestatic 169	com/facebook/imagepipeline/l/an:c	(Lcom/facebook/imagepipeline/m/c;Lcom/facebook/imagepipeline/i/d;)I
      //   140: iload_3
      //   141: bipush 85
      //   143: invokestatic 174	com/facebook/imagepipeline/nativecode/JpegTranscoder:a	(Ljava/io/InputStream;Ljava/io/OutputStream;III)V
      //   146: aload 8
      //   148: astore 6
      //   150: aload 4
      //   152: astore 7
      //   154: aload 4
      //   156: astore 5
      //   158: aload 10
      //   160: invokevirtual 179	com/facebook/imagepipeline/memory/ab:c	()Lcom/facebook/imagepipeline/memory/y;
      //   163: invokestatic 184	com/facebook/common/h/a:a	(Ljava/io/Closeable;)Lcom/facebook/common/h/a;
      //   166: astore 9
      //   168: new 74	com/facebook/imagepipeline/i/d
      //   171: dup
      //   172: aload 9
      //   174: invokespecial 187	com/facebook/imagepipeline/i/d:<init>	(Lcom/facebook/common/h/a;)V
      //   177: astore_1
      //   178: aload_1
      //   179: getstatic 193	com/facebook/f/b:f	Lcom/facebook/f/b;
      //   182: invokevirtual 196	com/facebook/imagepipeline/i/d:a	(Lcom/facebook/f/b;)V
      //   185: aload_1
      //   186: invokevirtual 199	com/facebook/imagepipeline/i/d:k	()V
      //   189: aload_0
      //   190: getfield 30	com/facebook/imagepipeline/l/an$a:b	Lcom/facebook/imagepipeline/l/aj;
      //   193: invokeinterface 59 1 0
      //   198: aload_0
      //   199: getfield 30	com/facebook/imagepipeline/l/an$a:b	Lcom/facebook/imagepipeline/l/aj;
      //   202: invokeinterface 62 1 0
      //   207: ldc -111
      //   209: aload 8
      //   211: invokeinterface 202 4 0
      //   216: aload_0
      //   217: invokevirtual 205	com/facebook/imagepipeline/l/an$a:d	()Lcom/facebook/imagepipeline/l/j;
      //   220: aload_1
      //   221: iload_2
      //   222: invokeinterface 210 3 0
      //   227: aload_1
      //   228: invokestatic 213	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
      //   231: aload 9
      //   233: invokestatic 215	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
      //   236: aload 4
      //   238: invokestatic 220	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
      //   241: aload 10
      //   243: invokevirtual 223	com/facebook/imagepipeline/memory/ab:close	()V
      //   246: return
      //   247: astore 5
      //   249: aload_1
      //   250: invokestatic 213	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
      //   253: aload 5
      //   255: athrow
      //   256: astore_1
      //   257: aload 8
      //   259: astore 6
      //   261: aload 4
      //   263: astore 7
      //   265: aload 4
      //   267: astore 5
      //   269: aload 9
      //   271: invokestatic 215	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
      //   274: aload 8
      //   276: astore 6
      //   278: aload 4
      //   280: astore 7
      //   282: aload 4
      //   284: astore 5
      //   286: aload_1
      //   287: athrow
      //   288: astore_1
      //   289: aload 7
      //   291: astore 4
      //   293: aload 4
      //   295: astore 5
      //   297: aload_0
      //   298: getfield 30	com/facebook/imagepipeline/l/an$a:b	Lcom/facebook/imagepipeline/l/aj;
      //   301: invokeinterface 59 1 0
      //   306: aload_0
      //   307: getfield 30	com/facebook/imagepipeline/l/an$a:b	Lcom/facebook/imagepipeline/l/aj;
      //   310: invokeinterface 62 1 0
      //   315: ldc -111
      //   317: aload_1
      //   318: aload 6
      //   320: invokeinterface 226 5 0
      //   325: aload 4
      //   327: astore 5
      //   329: aload_0
      //   330: invokevirtual 205	com/facebook/imagepipeline/l/an$a:d	()Lcom/facebook/imagepipeline/l/j;
      //   333: aload_1
      //   334: invokeinterface 229 2 0
      //   339: aload 4
      //   341: invokestatic 220	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
      //   344: aload 10
      //   346: invokevirtual 223	com/facebook/imagepipeline/memory/ab:close	()V
      //   349: return
      //   350: astore_1
      //   351: aload 5
      //   353: astore 4
      //   355: aload 4
      //   357: invokestatic 220	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
      //   360: aload 10
      //   362: invokevirtual 223	com/facebook/imagepipeline/memory/ab:close	()V
      //   365: aload_1
      //   366: athrow
      //   367: astore_1
      //   368: goto -13 -> 355
      //   371: astore_1
      //   372: aload 8
      //   374: astore 6
      //   376: goto -83 -> 293
      //   379: astore_1
      //   380: goto -123 -> 257
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	383	0	this	a
      //   0	383	1	paramd	com.facebook.imagepipeline.i.d
      //   0	383	2	paramBoolean	boolean
      //   77	64	3	i	int
      //   57	299	4	localObject1	Object
      //   69	88	5	localObject2	Object
      //   247	7	5	localObject3	Object
      //   267	85	5	localObject4	Object
      //   61	314	6	localMap1	Map
      //   65	225	7	localObject5	Object
      //   51	322	8	localMap2	Map
      //   54	216	9	locala	com.facebook.common.h.a
      //   48	313	10	localab	com.facebook.imagepipeline.memory.ab
      //   34	101	11	localc	c
      // Exception table:
      //   from	to	target	type
      //   185	227	247	finally
      //   178	185	256	finally
      //   227	231	256	finally
      //   249	256	256	finally
      //   71	78	288	java/lang/Exception
      //   90	100	288	java/lang/Exception
      //   112	118	288	java/lang/Exception
      //   130	146	288	java/lang/Exception
      //   158	168	288	java/lang/Exception
      //   269	274	288	java/lang/Exception
      //   286	288	288	java/lang/Exception
      //   71	78	350	finally
      //   90	100	350	finally
      //   112	118	350	finally
      //   130	146	350	finally
      //   158	168	350	finally
      //   269	274	350	finally
      //   286	288	350	finally
      //   297	325	350	finally
      //   329	339	350	finally
      //   231	236	367	finally
      //   231	236	371	java/lang/Exception
      //   168	178	379	finally
    }
    
    protected void a(@Nullable com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      if (this.c) {}
      do
      {
        f localf;
        do
        {
          do
          {
            return;
            if (paramd != null) {
              break;
            }
          } while (!paramBoolean);
          d().b(null, true);
          return;
          localf = an.a(this.b.a(), paramd);
        } while ((!paramBoolean) && (localf == f.c));
        if (localf != f.a)
        {
          d().b(paramd, paramBoolean);
          return;
        }
      } while ((!this.d.a(paramd, paramBoolean)) || ((!paramBoolean) && (!this.b.h())));
      this.d.b();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */