package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;

@Immutable
public class l
  implements w
{
  @Deprecated
  public static final l a = new l();
  public static final l b = new l();
  protected final ak c;
  
  public l()
  {
    this(null);
  }
  
  public l(ak paramak)
  {
    if (paramak != null) {}
    for (;;)
    {
      this.c = paramak;
      return;
      paramak = ac.d;
    }
  }
  
  public static ak a(String paramString, w paramw)
    throws ai
  {
    a.a(paramString, "Value");
    d locald = new d(paramString.length());
    locald.a(paramString);
    paramString = new x(0, paramString.length());
    if (paramw != null) {}
    for (;;)
    {
      return paramw.a(locald, paramString);
      paramw = b;
    }
  }
  
  public static am b(String paramString, w paramw)
    throws ai
  {
    a.a(paramString, "Value");
    d locald = new d(paramString.length());
    locald.a(paramString);
    paramString = new x(0, paramString.length());
    if (paramw != null) {}
    for (;;)
    {
      return paramw.c(locald, paramString);
      paramw = b;
    }
  }
  
  public static an c(String paramString, w paramw)
    throws ai
  {
    a.a(paramString, "Value");
    d locald = new d(paramString.length());
    locald.a(paramString);
    paramString = new x(0, paramString.length());
    if (paramw != null) {}
    for (;;)
    {
      return paramw.d(locald, paramString);
      paramw = b;
    }
  }
  
  public static cz.msebera.android.httpclient.f d(String paramString, w paramw)
    throws ai
  {
    a.a(paramString, "Value");
    d locald = new d(paramString.length());
    locald.a(paramString);
    if (paramw != null) {}
    for (;;)
    {
      return paramw.a(locald);
      paramw = b;
    }
  }
  
  protected ak a(int paramInt1, int paramInt2)
  {
    return this.c.a(paramInt1, paramInt2);
  }
  
  /* Error */
  public ak a(d paramd, x paramx)
    throws ai
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 89
    //   3: invokestatic 45	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: ldc 91
    //   10: invokestatic 45	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   13: pop
    //   14: aload_0
    //   15: getfield 29	cz/msebera/android/httpclient/k/l:c	Lcz/msebera/android/httpclient/ak;
    //   18: invokevirtual 94	cz/msebera/android/httpclient/ak:a	()Ljava/lang/String;
    //   21: astore 9
    //   23: aload 9
    //   25: invokevirtual 53	java/lang/String:length	()I
    //   28: istore 7
    //   30: aload_2
    //   31: invokevirtual 96	cz/msebera/android/httpclient/k/x:c	()I
    //   34: istore 6
    //   36: aload_2
    //   37: invokevirtual 98	cz/msebera/android/httpclient/k/x:b	()I
    //   40: istore 5
    //   42: aload_0
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 102	cz/msebera/android/httpclient/k/l:e	(Lcz/msebera/android/httpclient/o/d;Lcz/msebera/android/httpclient/k/x;)V
    //   48: aload_2
    //   49: invokevirtual 96	cz/msebera/android/httpclient/k/x:c	()I
    //   52: istore 8
    //   54: iload 8
    //   56: iload 7
    //   58: iadd
    //   59: iconst_4
    //   60: iadd
    //   61: iload 5
    //   63: if_icmple +37 -> 100
    //   66: new 38	cz/msebera/android/httpclient/ai
    //   69: dup
    //   70: new 104	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   77: ldc 107
    //   79: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: iload 6
    //   85: iload 5
    //   87: invokevirtual 114	cz/msebera/android/httpclient/o/d:a	(II)Ljava/lang/String;
    //   90: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 119	cz/msebera/android/httpclient/ai:<init>	(Ljava/lang/String;)V
    //   99: athrow
    //   100: iconst_1
    //   101: istore_3
    //   102: iconst_0
    //   103: istore 4
    //   105: iload_3
    //   106: ifeq +45 -> 151
    //   109: iload 4
    //   111: iload 7
    //   113: if_icmpge +38 -> 151
    //   116: aload_1
    //   117: iload 8
    //   119: iload 4
    //   121: iadd
    //   122: invokevirtual 122	cz/msebera/android/httpclient/o/d:a	(I)C
    //   125: aload 9
    //   127: iload 4
    //   129: invokevirtual 125	java/lang/String:charAt	(I)C
    //   132: if_icmpne +14 -> 146
    //   135: iconst_1
    //   136: istore_3
    //   137: iload 4
    //   139: iconst_1
    //   140: iadd
    //   141: istore 4
    //   143: goto -38 -> 105
    //   146: iconst_0
    //   147: istore_3
    //   148: goto -11 -> 137
    //   151: iload_3
    //   152: istore 4
    //   154: iload_3
    //   155: ifeq +20 -> 175
    //   158: aload_1
    //   159: iload 8
    //   161: iload 7
    //   163: iadd
    //   164: invokevirtual 122	cz/msebera/android/httpclient/o/d:a	(I)C
    //   167: bipush 47
    //   169: if_icmpne +45 -> 214
    //   172: iconst_1
    //   173: istore 4
    //   175: iload 4
    //   177: ifne +43 -> 220
    //   180: new 38	cz/msebera/android/httpclient/ai
    //   183: dup
    //   184: new 104	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   191: ldc 107
    //   193: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_1
    //   197: iload 6
    //   199: iload 5
    //   201: invokevirtual 114	cz/msebera/android/httpclient/o/d:a	(II)Ljava/lang/String;
    //   204: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokespecial 119	cz/msebera/android/httpclient/ai:<init>	(Ljava/lang/String;)V
    //   213: athrow
    //   214: iconst_0
    //   215: istore 4
    //   217: goto -42 -> 175
    //   220: iload 8
    //   222: iload 7
    //   224: iconst_1
    //   225: iadd
    //   226: iadd
    //   227: istore 4
    //   229: aload_1
    //   230: bipush 46
    //   232: iload 4
    //   234: iload 5
    //   236: invokevirtual 128	cz/msebera/android/httpclient/o/d:a	(III)I
    //   239: istore_3
    //   240: iload_3
    //   241: iconst_m1
    //   242: if_icmpne +37 -> 279
    //   245: new 38	cz/msebera/android/httpclient/ai
    //   248: dup
    //   249: new 104	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   256: ldc -126
    //   258: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_1
    //   262: iload 6
    //   264: iload 5
    //   266: invokevirtual 114	cz/msebera/android/httpclient/o/d:a	(II)Ljava/lang/String;
    //   269: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokespecial 119	cz/msebera/android/httpclient/ai:<init>	(Ljava/lang/String;)V
    //   278: athrow
    //   279: aload_1
    //   280: iload 4
    //   282: iload_3
    //   283: invokevirtual 132	cz/msebera/android/httpclient/o/d:b	(II)Ljava/lang/String;
    //   286: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: istore 7
    //   291: iload_3
    //   292: iconst_1
    //   293: iadd
    //   294: istore 8
    //   296: aload_1
    //   297: bipush 32
    //   299: iload 8
    //   301: iload 5
    //   303: invokevirtual 128	cz/msebera/android/httpclient/o/d:a	(III)I
    //   306: istore 4
    //   308: iload 4
    //   310: istore_3
    //   311: iload 4
    //   313: iconst_m1
    //   314: if_icmpne +6 -> 320
    //   317: iload 5
    //   319: istore_3
    //   320: aload_1
    //   321: iload 8
    //   323: iload_3
    //   324: invokevirtual 132	cz/msebera/android/httpclient/o/d:b	(II)Ljava/lang/String;
    //   327: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   330: istore 4
    //   332: aload_2
    //   333: iload_3
    //   334: invokevirtual 140	cz/msebera/android/httpclient/k/x:a	(I)V
    //   337: aload_0
    //   338: iload 7
    //   340: iload 4
    //   342: invokevirtual 141	cz/msebera/android/httpclient/k/l:a	(II)Lcz/msebera/android/httpclient/ak;
    //   345: areturn
    //   346: astore_2
    //   347: new 38	cz/msebera/android/httpclient/ai
    //   350: dup
    //   351: new 104	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   358: ldc -113
    //   360: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_1
    //   364: iload 6
    //   366: iload 5
    //   368: invokevirtual 114	cz/msebera/android/httpclient/o/d:a	(II)Ljava/lang/String;
    //   371: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokespecial 119	cz/msebera/android/httpclient/ai:<init>	(Ljava/lang/String;)V
    //   380: athrow
    //   381: astore_2
    //   382: new 38	cz/msebera/android/httpclient/ai
    //   385: dup
    //   386: new 104	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   393: ldc -111
    //   395: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_1
    //   399: iload 6
    //   401: iload 5
    //   403: invokevirtual 114	cz/msebera/android/httpclient/o/d:a	(II)Ljava/lang/String;
    //   406: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokespecial 119	cz/msebera/android/httpclient/ai:<init>	(Ljava/lang/String;)V
    //   415: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	l
    //   0	416	1	paramd	d
    //   0	416	2	paramx	x
    //   101	233	3	i	int
    //   103	238	4	j	int
    //   40	362	5	k	int
    //   34	366	6	m	int
    //   28	311	7	n	int
    //   52	270	8	i1	int
    //   21	105	9	str	String
    // Exception table:
    //   from	to	target	type
    //   279	291	346	java/lang/NumberFormatException
    //   320	332	381	java/lang/NumberFormatException
  }
  
  protected am a(String paramString1, String paramString2, ak paramak)
  {
    return new o(paramString1, paramString2, paramak);
  }
  
  protected an a(ak paramak, int paramInt, String paramString)
  {
    return new p(paramak, paramInt, paramString);
  }
  
  public cz.msebera.android.httpclient.f a(d paramd)
    throws ai
  {
    return new r(paramd);
  }
  
  public boolean b(d paramd, x paramx)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramx, "Parser cursor");
    int j = paramx.c();
    paramx = this.c.a();
    int k = paramx.length();
    if (paramd.e() < k + 4) {
      break label62;
    }
    int i;
    label62:
    while (i + k + 4 > paramd.e())
    {
      return false;
      if (j >= 0) {
        break;
      }
      i = paramd.e() - 4 - k;
    }
    boolean bool1 = true;
    j = 0;
    label81:
    if ((bool1) && (j < k))
    {
      if (paramd.a(i + j) == paramx.charAt(j)) {}
      for (bool1 = true;; bool1 = false)
      {
        j += 1;
        break label81;
        i = j;
        if (j != 0) {
          break;
        }
        for (;;)
        {
          i = j;
          if (j >= paramd.e()) {
            break;
          }
          i = j;
          if (!cz.msebera.android.httpclient.n.f.a(paramd.a(j))) {
            break;
          }
          j += 1;
        }
      }
    }
    boolean bool2 = bool1;
    if (bool1) {
      if (paramd.a(i + k) != '/') {
        break label200;
      }
    }
    label200:
    for (bool2 = true;; bool2 = false) {
      return bool2;
    }
  }
  
  public am c(d paramd, x paramx)
    throws ai
  {
    a.a(paramd, "Char array buffer");
    a.a(paramx, "Parser cursor");
    int i = paramx.c();
    int j = paramx.b();
    try
    {
      e(paramd, paramx);
      k = paramx.c();
      m = paramd.a(32, k, j);
      if (m < 0) {
        throw new ai("Invalid request line: " + paramd.a(i, j));
      }
    }
    catch (IndexOutOfBoundsException paramx)
    {
      throw new ai("Invalid request line: " + paramd.a(i, j));
    }
    String str1 = paramd.b(k, m);
    paramx.a(m);
    e(paramd, paramx);
    int k = paramx.c();
    int m = paramd.a(32, k, j);
    if (m < 0) {
      throw new ai("Invalid request line: " + paramd.a(i, j));
    }
    String str2 = paramd.b(k, m);
    paramx.a(m);
    ak localak = a(paramd, paramx);
    e(paramd, paramx);
    if (!paramx.d()) {
      throw new ai("Invalid request line: " + paramd.a(i, j));
    }
    paramx = a(str1, str2, localak);
    return paramx;
  }
  
  public an d(d paramd, x paramx)
    throws ai
  {
    a.a(paramd, "Char array buffer");
    a.a(paramx, "Parser cursor");
    int m = paramx.c();
    int k = paramx.b();
    ak localak;
    int j;
    int i;
    for (;;)
    {
      try
      {
        localak = a(paramd, paramx);
        e(paramd, paramx);
        int n = paramx.c();
        j = paramd.a(32, n, k);
        i = j;
        if (j < 0) {
          i = k;
        }
        paramx = paramd.b(n, i);
        j = 0;
        if (j >= paramx.length()) {
          break;
        }
        if (!Character.isDigit(paramx.charAt(j))) {
          throw new ai("Status line contains invalid status code: " + paramd.a(m, k));
        }
      }
      catch (IndexOutOfBoundsException paramx)
      {
        throw new ai("Invalid status line: " + paramd.a(m, k));
      }
      j += 1;
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(paramx);
        if (i < k)
        {
          paramx = paramd.b(i, k);
          return a(localak, j, paramx);
        }
      }
      catch (NumberFormatException paramx)
      {
        throw new ai("Status line contains invalid status code: " + paramd.a(m, k));
      }
      paramx = "";
    }
  }
  
  protected void e(d paramd, x paramx)
  {
    int i = paramx.c();
    int j = paramx.b();
    while ((i < j) && (cz.msebera.android.httpclient.n.f.a(paramd.a(i)))) {
      i += 1;
    }
    paramx.a(i);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/k/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */