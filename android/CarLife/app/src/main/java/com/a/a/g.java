package com.a.a;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;

public final class g
{
  private static final Appendable e = new Appendable()
  {
    public Appendable append(char paramAnonymousChar)
    {
      return this;
    }
    
    public Appendable append(CharSequence paramAnonymousCharSequence)
    {
      return this;
    }
    
    public Appendable append(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return this;
    }
  };
  public final d a;
  public final String b;
  public final m c;
  public final boolean d;
  private final Set<String> f;
  private final String g;
  
  private g(a parama)
  {
    this.a = a.a(parama).d();
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.f = o.b(a.e(parama));
    this.g = a.f(parama);
  }
  
  public static a a(String paramString, m paramm)
  {
    o.a(paramString, "packageName == null", new Object[0]);
    o.a(paramm, "typeSpec == null", new Object[0]);
    return new a(paramString, paramm, null);
  }
  
  private void a(e parame)
    throws IOException
  {
    parame.a(this.b);
    if (!this.a.a()) {
      parame.a(this.a);
    }
    if (!this.b.isEmpty())
    {
      parame.a("package $L;\n", new Object[] { this.b });
      parame.b("\n");
    }
    if (!this.f.isEmpty())
    {
      localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        parame.a("import static $L;\n", new Object[] { (String)localIterator.next() });
      }
      parame.b("\n");
    }
    int i = 0;
    Iterator localIterator = new TreeSet(parame.a().values()).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((!this.d) || (!localc.b().equals("java.lang")))
      {
        parame.a("import $L;\n", new Object[] { localc });
        i += 1;
      }
    }
    if (i > 0) {
      parame.b("\n");
    }
    this.c.a(parame, null, Collections.emptySet());
    parame.d();
  }
  
  public JavaFileObject a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.b.isEmpty()) {}
    for (String str = this.c.b;; str = this.b.replace('.', '/') + '/' + this.c.b) {
      new SimpleJavaFileObject(URI.create(str + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE)
      {
        private final long b = System.currentTimeMillis();
        
        public InputStream a()
          throws IOException
        {
          return new ByteArrayInputStream(a(true).getBytes());
        }
        
        public String a(boolean paramAnonymousBoolean)
        {
          return g.this.toString();
        }
        
        public long b()
        {
          return this.b;
        }
      };
    }
  }
  
  public void a(File paramFile)
    throws IOException
  {
    a(paramFile.toPath());
  }
  
  public void a(Appendable paramAppendable)
    throws IOException
  {
    Object localObject = new e(e, this.g, this.f);
    a((e)localObject);
    localObject = ((e)localObject).f();
    a(new e(paramAppendable, this.g, (Map)localObject, this.f));
  }
  
  public void a(Path paramPath)
    throws IOException
  {
    if ((Files.notExists(paramPath, new LinkOption[0])) || (Files.isDirectory(paramPath, new LinkOption[0]))) {}
    for (boolean bool = true;; bool = false)
    {
      o.a(bool, "path %s exists but is not a directory.", new Object[] { paramPath });
      localObject1 = paramPath;
      if (this.b.isEmpty()) {
        break label112;
      }
      localObject1 = this.b.split("\\.");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        paramPath = paramPath.resolve(localObject1[i]);
        i += 1;
      }
    }
    Files.createDirectories(paramPath, new FileAttribute[0]);
    Object localObject1 = paramPath;
    label112:
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(Files.newOutputStream(((Path)localObject1).resolve(this.c.b + ".java"), new OpenOption[0]));
    paramPath = null;
    try
    {
      a(localOutputStreamWriter);
      if ((localOutputStreamWriter == null) || (0 != 0)) {
        try
        {
          localOutputStreamWriter.close();
          return;
        }
        catch (Throwable paramPath)
        {
          throw new NullPointerException();
        }
      }
      localOutputStreamWriter.close();
      return;
    }
    catch (Throwable localThrowable1)
    {
      paramPath = localThrowable1;
      throw localThrowable1;
    }
    finally
    {
      if (localOutputStreamWriter != null) {
        if (paramPath == null) {
          break label237;
        }
      }
    }
    for (;;)
    {
      try
      {
        localOutputStreamWriter.close();
        throw ((Throwable)localObject2);
      }
      catch (Throwable localThrowable2)
      {
        paramPath.addSuppressed(localThrowable2);
        continue;
      }
      label237:
      localThrowable2.close();
    }
  }
  
  /* Error */
  public void a(javax.annotation.processing.Filer paramFiler)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/a/a/g:b	Ljava/lang/String;
    //   4: invokevirtual 108	java/lang/String:isEmpty	()Z
    //   7: ifeq +76 -> 83
    //   10: aload_0
    //   11: getfield 54	com/a/a/g:c	Lcom/a/a/m;
    //   14: getfield 183	com/a/a/m:b	Ljava/lang/String;
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 54	com/a/a/g:c	Lcom/a/a/m;
    //   22: getfield 306	com/a/a/m:p	Ljava/util/List;
    //   25: astore_3
    //   26: aload_1
    //   27: aload_2
    //   28: aload_3
    //   29: aload_3
    //   30: invokeinterface 312 1 0
    //   35: anewarray 314	javax/lang/model/element/Element
    //   38: invokeinterface 318 2 0
    //   43: checkcast 320	[Ljavax/lang/model/element/Element;
    //   46: invokeinterface 326 3 0
    //   51: astore_3
    //   52: aload_3
    //   53: invokeinterface 332 1 0
    //   58: astore 4
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_0
    //   63: aload 4
    //   65: invokevirtual 287	com/a/a/g:a	(Ljava/lang/Appendable;)V
    //   68: aload 4
    //   70: ifnull +12 -> 82
    //   73: iconst_0
    //   74: ifeq +65 -> 139
    //   77: aload 4
    //   79: invokevirtual 292	java/io/Writer:close	()V
    //   82: return
    //   83: new 181	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   90: aload_0
    //   91: getfield 49	com/a/a/g:b	Ljava/lang/String;
    //   94: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 334
    //   100: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 54	com/a/a/g:c	Lcom/a/a/m;
    //   107: getfield 183	com/a/a/m:b	Ljava/lang/String;
    //   110: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_2
    //   117: goto -99 -> 18
    //   120: astore_1
    //   121: new 294	java/lang/NullPointerException
    //   124: dup
    //   125: invokespecial 295	java/lang/NullPointerException:<init>	()V
    //   128: athrow
    //   129: astore_1
    //   130: aload_3
    //   131: invokeinterface 337 1 0
    //   136: pop
    //   137: aload_1
    //   138: athrow
    //   139: aload 4
    //   141: invokevirtual 292	java/io/Writer:close	()V
    //   144: return
    //   145: astore_2
    //   146: aload_2
    //   147: astore_1
    //   148: aload_2
    //   149: athrow
    //   150: astore_2
    //   151: aload 4
    //   153: ifnull +12 -> 165
    //   156: aload_1
    //   157: ifnull +21 -> 178
    //   160: aload 4
    //   162: invokevirtual 292	java/io/Writer:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: astore 4
    //   169: aload_1
    //   170: aload 4
    //   172: invokevirtual 299	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   175: goto -10 -> 165
    //   178: aload 4
    //   180: invokevirtual 292	java/io/Writer:close	()V
    //   183: goto -18 -> 165
    //   186: astore_2
    //   187: goto -50 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	g
    //   0	190	1	paramFiler	javax.annotation.processing.Filer
    //   17	100	2	str	String
    //   145	4	2	localThrowable1	Throwable
    //   150	16	2	localObject1	Object
    //   186	1	2	localException	Exception
    //   25	106	3	localObject2	Object
    //   58	103	4	localWriter	Writer
    //   167	12	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   77	82	120	java/lang/Throwable
    //   52	60	129	java/lang/Exception
    //   77	82	129	java/lang/Exception
    //   121	129	129	java/lang/Exception
    //   139	144	129	java/lang/Exception
    //   160	165	129	java/lang/Exception
    //   165	167	129	java/lang/Exception
    //   169	175	129	java/lang/Exception
    //   178	183	129	java/lang/Exception
    //   62	68	145	java/lang/Throwable
    //   62	68	150	finally
    //   148	150	150	finally
    //   160	165	167	java/lang/Throwable
    //   130	137	186	java/lang/Exception
  }
  
  public a b()
  {
    a locala = new a(this.b, this.c, null);
    a.a(locala).a(this.a);
    a.a(locala, this.d);
    a.a(locala, this.g);
    return locala;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    return toString().equals(paramObject.toString());
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringBuilder();
      a((Appendable)localObject);
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError();
    }
  }
  
  public static final class a
  {
    private final String a;
    private final m b;
    private final d.a c = d.b();
    private final Set<String> d = new TreeSet();
    private boolean e;
    private String f = "  ";
    
    private a(String paramString, m paramm)
    {
      this.a = paramString;
      this.b = paramm;
    }
    
    public a a(c paramc, String... paramVarArgs)
    {
      label25:
      label44:
      int i;
      label61:
      String str;
      if (paramc != null)
      {
        bool = true;
        o.a(bool, "className == null", new Object[0]);
        if (paramVarArgs == null) {
          break label148;
        }
        bool = true;
        o.a(bool, "names == null", new Object[0]);
        if (paramVarArgs.length <= 0) {
          break label154;
        }
        bool = true;
        o.a(bool, "names array is empty", new Object[0]);
        int j = paramVarArgs.length;
        i = 0;
        if (i >= j) {
          return this;
        }
        str = paramVarArgs[i];
        if (str == null) {
          break label160;
        }
      }
      label148:
      label154:
      label160:
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "null entry in names array: %s", new Object[] { Arrays.toString(paramVarArgs) });
        this.d.add(paramc.c + "." + str);
        i += 1;
        break label61;
        bool = false;
        break;
        bool = false;
        break label25;
        bool = false;
        break label44;
      }
      return this;
    }
    
    public a a(Class<?> paramClass, String... paramVarArgs)
    {
      return a(c.a(paramClass), paramVarArgs);
    }
    
    public a a(Enum<?> paramEnum)
    {
      return a(c.a(paramEnum.getDeclaringClass()), new String[] { paramEnum.name() });
    }
    
    public a a(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public a a(String paramString, Object... paramVarArgs)
    {
      this.c.a(paramString, paramVarArgs);
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }
    
    public g a()
    {
      return new g(this, null);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */