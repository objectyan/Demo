package b;

import b.a.d.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class aa
  implements e
{
  final y a;
  final j b;
  final ab c;
  final boolean d;
  private boolean e;
  
  aa(y paramy, ab paramab, boolean paramBoolean)
  {
    this.a = paramy;
    this.c = paramab;
    this.d = paramBoolean;
    this.b = new j(paramy, paramBoolean);
  }
  
  private void l()
  {
    Object localObject = b.a.h.e.b().a("response.body().close()");
    this.b.a(localObject);
  }
  
  public ab a()
  {
    return this.c;
  }
  
  public void a(f paramf)
  {
    try
    {
      if (this.e) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.e = true;
    l();
    this.a.u().a(new a(paramf));
  }
  
  public ad b()
    throws IOException
  {
    try
    {
      if (this.e) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.e = true;
    l();
    try
    {
      this.a.u().a(this);
      ad localad1 = k();
      if (localad1 == null) {
        throw new IOException("Canceled");
      }
    }
    finally
    {
      this.a.u().b(this);
    }
    this.a.u().b(this);
    return localad2;
  }
  
  public void c()
  {
    this.b.a();
  }
  
  public boolean d()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean e()
  {
    return this.b.b();
  }
  
  public aa g()
  {
    return new aa(this.a, this.c, this.d);
  }
  
  b.a.c.g h()
  {
    return this.b.c();
  }
  
  String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (e())
    {
      str = "canceled ";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.d) {
        break label61;
      }
    }
    label61:
    for (String str = "web socket";; str = "call")
    {
      return str + " to " + j();
      str = "";
      break;
    }
  }
  
  String j()
  {
    return this.c.a().u();
  }
  
  ad k()
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a.x());
    localArrayList.add(this.b);
    localArrayList.add(new b.a.d.a(this.a.g()));
    localArrayList.add(new b.a.a.a(this.a.i()));
    localArrayList.add(new b.a.c.a(this.a));
    if (!this.d) {
      localArrayList.addAll(this.a.y());
    }
    localArrayList.add(new b.a.d.b(this.d));
    return new b.a.d.g(localArrayList, null, null, null, 0, this.c).a(this.c);
  }
  
  final class a
    extends b.a.b
  {
    private final f c;
    
    a(f paramf)
    {
      super(new Object[] { aa.this.j() });
      this.c = paramf;
    }
    
    String a()
    {
      return aa.this.c.a().i();
    }
    
    ab b()
    {
      return aa.this.c;
    }
    
    aa c()
    {
      return aa.this;
    }
    
    /* Error */
    protected void d()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: iload_2
      //   3: istore_1
      //   4: aload_0
      //   5: getfield 14	b/aa$a:a	Lb/aa;
      //   8: invokevirtual 52	b/aa:k	()Lb/ad;
      //   11: astore_3
      //   12: iload_2
      //   13: istore_1
      //   14: aload_0
      //   15: getfield 14	b/aa$a:a	Lb/aa;
      //   18: getfield 55	b/aa:b	Lb/a/d/j;
      //   21: invokevirtual 60	b/a/d/j:b	()Z
      //   24: ifeq +42 -> 66
      //   27: iconst_1
      //   28: istore_1
      //   29: aload_0
      //   30: getfield 27	b/aa$a:c	Lb/f;
      //   33: aload_0
      //   34: getfield 14	b/aa$a:a	Lb/aa;
      //   37: new 48	java/io/IOException
      //   40: dup
      //   41: ldc 62
      //   43: invokespecial 65	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   46: invokeinterface 70 3 0
      //   51: aload_0
      //   52: getfield 14	b/aa$a:a	Lb/aa;
      //   55: getfield 73	b/aa:a	Lb/y;
      //   58: invokevirtual 79	b/y:u	()Lb/p;
      //   61: aload_0
      //   62: invokevirtual 84	b/p:b	(Lb/aa$a;)V
      //   65: return
      //   66: iconst_1
      //   67: istore_1
      //   68: aload_0
      //   69: getfield 27	b/aa$a:c	Lb/f;
      //   72: aload_0
      //   73: getfield 14	b/aa$a:a	Lb/aa;
      //   76: aload_3
      //   77: invokeinterface 87 3 0
      //   82: goto -31 -> 51
      //   85: astore_3
      //   86: iload_1
      //   87: ifeq +51 -> 138
      //   90: invokestatic 92	b/a/h/e:b	()Lb/a/h/e;
      //   93: iconst_4
      //   94: new 94	java/lang/StringBuilder
      //   97: dup
      //   98: invokespecial 96	java/lang/StringBuilder:<init>	()V
      //   101: ldc 98
      //   103: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: aload_0
      //   107: getfield 14	b/aa$a:a	Lb/aa;
      //   110: invokevirtual 103	b/aa:i	()Ljava/lang/String;
      //   113: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: aload_3
      //   120: invokevirtual 109	b/a/h/e:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   123: aload_0
      //   124: getfield 14	b/aa$a:a	Lb/aa;
      //   127: getfield 73	b/aa:a	Lb/y;
      //   130: invokevirtual 79	b/y:u	()Lb/p;
      //   133: aload_0
      //   134: invokevirtual 84	b/p:b	(Lb/aa$a;)V
      //   137: return
      //   138: aload_0
      //   139: getfield 27	b/aa$a:c	Lb/f;
      //   142: aload_0
      //   143: getfield 14	b/aa$a:a	Lb/aa;
      //   146: aload_3
      //   147: invokeinterface 70 3 0
      //   152: goto -29 -> 123
      //   155: astore_3
      //   156: aload_0
      //   157: getfield 14	b/aa$a:a	Lb/aa;
      //   160: getfield 73	b/aa:a	Lb/y;
      //   163: invokevirtual 79	b/y:u	()Lb/p;
      //   166: aload_0
      //   167: invokevirtual 84	b/p:b	(Lb/aa$a;)V
      //   170: aload_3
      //   171: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	172	0	this	a
      //   3	84	1	i	int
      //   1	12	2	j	int
      //   11	66	3	localad	ad
      //   85	62	3	localIOException	IOException
      //   155	16	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	12	85	java/io/IOException
      //   14	27	85	java/io/IOException
      //   29	51	85	java/io/IOException
      //   68	82	85	java/io/IOException
      //   4	12	155	finally
      //   14	27	155	finally
      //   29	51	155	finally
      //   68	82	155	finally
      //   90	123	155	finally
      //   138	152	155	finally
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */