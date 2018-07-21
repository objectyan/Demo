package b;

import b.a.c;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okio.Buffer;

public final class u
{
  static final String a = " \"':;<=>@[]^`{}|/\\?#";
  static final String b = " \"':;<=>@[]^`{}|/\\?#";
  static final String c = " \"<>^`{}|/\\?#";
  static final String d = "[]";
  static final String e = " \"'<>#";
  static final String f = " \"'<>#&=";
  static final String g = "\\^`{|}";
  static final String h = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
  static final String i = "";
  static final String j = " \"#<>\\^`{|}";
  private static final char[] n = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  final String k;
  final String l;
  final int m;
  private final String o;
  private final String p;
  private final List<String> q;
  private final List<String> r;
  private final String s;
  private final String t;
  
  u(a parama)
  {
    this.k = parama.a;
    this.o = a(parama.b, false);
    this.p = a(parama.c, false);
    this.l = parama.d;
    this.m = parama.a();
    this.q = a(parama.f, false);
    if (parama.g != null) {}
    for (Object localObject1 = a(parama.g, true);; localObject1 = null)
    {
      this.r = ((List)localObject1);
      localObject1 = localObject2;
      if (parama.h != null) {
        localObject1 = a(parama.h, false);
      }
      this.s = ((String)localObject1);
      this.t = parama.toString();
      return;
    }
  }
  
  static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int a(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  public static u a(URI paramURI)
  {
    return g(paramURI.toString());
  }
  
  public static u a(URL paramURL)
  {
    return g(paramURL.toString());
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i1 = paramInt1;
    while (i1 < paramInt2)
    {
      int i2 = paramString1.codePointAt(i1);
      if ((i2 < 32) || (i2 == 127) || ((i2 >= 128) && (paramBoolean4)) || (paramString2.indexOf(i2) != -1) || ((i2 == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, i1, paramInt2))))) || ((i2 == 43) && (paramBoolean3)))
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString1, paramInt1, i1);
        a(localBuffer, paramString1, i1, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
        return localBuffer.readUtf8();
      }
      i1 += Character.charCount(i2);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = paramInt1;
    while (i1 < paramInt2)
    {
      int i2 = paramString.charAt(i1);
      if ((i2 == 37) || ((i2 == 43) && (paramBoolean)))
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString, paramInt1, i1);
        a(localBuffer, paramString, i1, paramInt2, paramBoolean);
        return localBuffer.readUtf8();
      }
      i1 += 1;
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List<String> a(List<String> paramList, boolean paramBoolean)
  {
    int i2 = paramList.size();
    ArrayList localArrayList = new ArrayList(i2);
    int i1 = 0;
    if (i1 < i2)
    {
      String str = (String)paramList.get(i1);
      if (str != null) {}
      for (str = a(str, paramBoolean);; str = null)
      {
        localArrayList.add(str);
        i1 += 1;
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void a(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int i1 = 0;
    int i2 = paramList.size();
    while (i1 < i2)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(i1));
      i1 += 1;
    }
  }
  
  static void a(Buffer paramBuffer, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1 = null;
    if (paramInt1 < paramInt2)
    {
      int i1 = paramString1.codePointAt(paramInt1);
      Object localObject3;
      if (paramBoolean1)
      {
        localObject3 = localObject1;
        if (i1 != 9)
        {
          localObject3 = localObject1;
          if (i1 != 10)
          {
            localObject3 = localObject1;
            if (i1 != 12)
            {
              if (i1 != 13) {
                break label79;
              }
              localObject3 = localObject1;
            }
          }
        }
      }
      for (;;)
      {
        paramInt1 += Character.charCount(i1);
        localObject1 = localObject3;
        break;
        label79:
        Object localObject2;
        if ((i1 == 43) && (paramBoolean3))
        {
          if (paramBoolean1) {}
          for (localObject2 = "+";; localObject2 = "%2B")
          {
            paramBuffer.writeUtf8((String)localObject2);
            localObject3 = localObject1;
            break;
          }
        }
        if ((i1 < 32) || (i1 == 127) || ((i1 >= 128) && (paramBoolean4)) || (paramString2.indexOf(i1) != -1) || ((i1 == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, paramInt1, paramInt2))))))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Buffer();
          }
          ((Buffer)localObject2).writeUtf8CodePoint(i1);
          for (;;)
          {
            localObject3 = localObject2;
            if (((Buffer)localObject2).exhausted()) {
              break;
            }
            int i2 = ((Buffer)localObject2).readByte() & 0xFF;
            paramBuffer.writeByte(37);
            paramBuffer.writeByte(n[(i2 >> 4 & 0xF)]);
            paramBuffer.writeByte(n[(i2 & 0xF)]);
          }
        }
        paramBuffer.writeUtf8CodePoint(i1);
        localObject3 = localObject1;
      }
    }
  }
  
  static void a(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < paramInt2)
    {
      int i1 = paramString.codePointAt(paramInt1);
      if ((i1 == 37) && (paramInt1 + 2 < paramInt2))
      {
        int i2 = a(paramString.charAt(paramInt1 + 1));
        int i3 = a(paramString.charAt(paramInt1 + 2));
        if ((i2 == -1) || (i3 == -1)) {
          break label111;
        }
        paramBuffer.writeByte((i2 << 4) + i3);
        paramInt1 += 2;
      }
      for (;;)
      {
        paramInt1 += Character.charCount(i1);
        break;
        if ((i1 == 43) && (paramBoolean)) {
          paramBuffer.writeByte(32);
        } else {
          label111:
          paramBuffer.writeUtf8CodePoint(i1);
        }
      }
    }
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    return (paramInt1 + 2 < paramInt2) && (paramString.charAt(paramInt1) == '%') && (a(paramString.charAt(paramInt1 + 1)) != -1) && (a(paramString.charAt(paramInt1 + 2)) != -1);
  }
  
  static List<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 <= paramString.length())
    {
      int i3 = paramString.indexOf('&', i1);
      int i2 = i3;
      if (i3 == -1) {
        i2 = paramString.length();
      }
      i3 = paramString.indexOf('=', i1);
      if ((i3 == -1) || (i3 > i2))
      {
        localArrayList.add(paramString.substring(i1, i2));
        localArrayList.add(null);
      }
      for (;;)
      {
        i1 = i2 + 1;
        break;
        localArrayList.add(paramString.substring(i1, i3));
        localArrayList.add(paramString.substring(i3 + 1, i2));
      }
    }
    return localArrayList;
  }
  
  static void b(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int i1 = 0;
    int i2 = paramList.size();
    while (i1 < i2)
    {
      String str1 = (String)paramList.get(i1);
      String str2 = (String)paramList.get(i1 + 1);
      if (i1 > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      i1 += 2;
    }
  }
  
  public static u g(String paramString)
  {
    u localu = null;
    a locala = new a();
    if (locala.a(null, paramString) == u.a.a.a) {
      localu = locala.c();
    }
    return localu;
  }
  
  static u h(String paramString)
    throws MalformedURLException, UnknownHostException
  {
    a locala = new a();
    u.a.a locala1 = locala.a(null, paramString);
    switch (1.a[locala1.ordinal()])
    {
    default: 
      throw new MalformedURLException("Invalid URL: " + locala1 + " for " + paramString);
    case 1: 
      return locala.c();
    }
    throw new UnknownHostException("Invalid host: " + paramString);
  }
  
  public String a(int paramInt)
  {
    if (this.r == null) {
      throw new IndexOutOfBoundsException();
    }
    return (String)this.r.get(paramInt * 2);
  }
  
  public URL a()
  {
    try
    {
      URL localURL = new URL(this.t);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException(localMalformedURLException);
    }
  }
  
  public String b(int paramInt)
  {
    if (this.r == null) {
      throw new IndexOutOfBoundsException();
    }
    return (String)this.r.get(paramInt * 2 + 1);
  }
  
  public URI b()
  {
    Object localObject = v().b().toString();
    try
    {
      URI localURI = new URI((String)localObject);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        localObject = URI.create(((String)localObject).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        return (URI)localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localURISyntaxException);
      }
    }
  }
  
  public String c()
  {
    return this.k;
  }
  
  public String c(String paramString)
  {
    if (this.r == null) {}
    for (;;)
    {
      return null;
      int i1 = 0;
      int i2 = this.r.size();
      while (i1 < i2)
      {
        if (paramString.equals(this.r.get(i1))) {
          return (String)this.r.get(i1 + 1);
        }
        i1 += 2;
      }
    }
  }
  
  public List<String> d(String paramString)
  {
    if (this.r == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    int i2 = this.r.size();
    while (i1 < i2)
    {
      if (paramString.equals(this.r.get(i1))) {
        localArrayList.add(this.r.get(i1 + 1));
      }
      i1 += 2;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public boolean d()
  {
    return this.k.equals("https");
  }
  
  public u e(String paramString)
  {
    paramString = f(paramString);
    if (paramString != null) {
      return paramString.c();
    }
    return null;
  }
  
  public String e()
  {
    if (this.o.isEmpty()) {
      return "";
    }
    int i1 = this.k.length() + 3;
    int i2 = c.a(this.t, i1, this.t.length(), ":@");
    return this.t.substring(i1, i2);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof u)) && (((u)paramObject).t.equals(this.t));
  }
  
  public a f(String paramString)
  {
    a locala = new a();
    if (locala.a(this, paramString) == u.a.a.a) {
      return locala;
    }
    return null;
  }
  
  public String f()
  {
    return this.o;
  }
  
  public String g()
  {
    if (this.p.isEmpty()) {
      return "";
    }
    int i1 = this.t.indexOf(':', this.k.length() + 3);
    int i2 = this.t.indexOf('@');
    return this.t.substring(i1 + 1, i2);
  }
  
  public String h()
  {
    return this.p;
  }
  
  public int hashCode()
  {
    return this.t.hashCode();
  }
  
  public String i()
  {
    return this.l;
  }
  
  public int j()
  {
    return this.m;
  }
  
  public int k()
  {
    return this.q.size();
  }
  
  public String l()
  {
    int i1 = this.t.indexOf('/', this.k.length() + 3);
    int i2 = c.a(this.t, i1, this.t.length(), "?#");
    return this.t.substring(i1, i2);
  }
  
  public List<String> m()
  {
    int i1 = this.t.indexOf('/', this.k.length() + 3);
    int i2 = c.a(this.t, i1, this.t.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (i1 < i2)
    {
      int i3 = i1 + 1;
      i1 = c.a(this.t, i3, i2, '/');
      localArrayList.add(this.t.substring(i3, i1));
    }
    return localArrayList;
  }
  
  public List<String> n()
  {
    return this.q;
  }
  
  public String o()
  {
    if (this.r == null) {
      return null;
    }
    int i1 = this.t.indexOf('?') + 1;
    int i2 = c.a(this.t, i1 + 1, this.t.length(), '#');
    return this.t.substring(i1, i2);
  }
  
  public String p()
  {
    if (this.r == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, this.r);
    return localStringBuilder.toString();
  }
  
  public int q()
  {
    if (this.r != null) {
      return this.r.size() / 2;
    }
    return 0;
  }
  
  public Set<String> r()
  {
    if (this.r == null) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i1 = 0;
    int i2 = this.r.size();
    while (i1 < i2)
    {
      localLinkedHashSet.add(this.r.get(i1));
      i1 += 2;
    }
    return Collections.unmodifiableSet(localLinkedHashSet);
  }
  
  public String s()
  {
    if (this.s == null) {
      return null;
    }
    int i1 = this.t.indexOf('#');
    return this.t.substring(i1 + 1);
  }
  
  public String t()
  {
    return this.s;
  }
  
  public String toString()
  {
    return this.t;
  }
  
  public String u()
  {
    return f("/...").b("").d("").c().toString();
  }
  
  public a v()
  {
    a locala = new a();
    locala.a = this.k;
    locala.b = e();
    locala.c = g();
    locala.d = this.l;
    if (this.m != a(this.k)) {}
    for (int i1 = this.m;; i1 = -1)
    {
      locala.e = i1;
      locala.f.clear();
      locala.f.addAll(m());
      locala.m(o());
      locala.h = s();
      return locala;
    }
  }
  
  public static final class a
  {
    String a;
    String b = "";
    String c = "";
    String d;
    int e = -1;
    final List<String> f = new ArrayList();
    List<String> g;
    String h;
    
    public a()
    {
      this.f.add("");
    }
    
    private a a(String paramString, boolean paramBoolean)
    {
      int i = 0;
      int j = c.a(paramString, i, paramString.length(), "/\\");
      if (j < paramString.length()) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramString, i, j, bool, paramBoolean);
        j += 1;
        i = j;
        if (j <= paramString.length()) {
          break;
        }
        return this;
      }
    }
    
    private static String a(byte[] paramArrayOfByte)
    {
      int m = -1;
      int k = 0;
      int i = 0;
      int j;
      while (i < paramArrayOfByte.length)
      {
        int n;
        for (j = i;; j = n + 2)
        {
          n = j;
          if ((n >= 16) || (paramArrayOfByte[n] != 0) || (paramArrayOfByte[(n + 1)] != 0)) {
            break;
          }
        }
        int i1 = n - i;
        j = k;
        if (i1 > k)
        {
          j = i1;
          m = i;
        }
        i = n + 2;
        k = j;
      }
      Buffer localBuffer = new Buffer();
      i = 0;
      while (i < paramArrayOfByte.length) {
        if (i == m)
        {
          localBuffer.writeByte(58);
          j = i + k;
          i = j;
          if (j == 16)
          {
            localBuffer.writeByte(58);
            i = j;
          }
        }
        else
        {
          if (i > 0) {
            localBuffer.writeByte(58);
          }
          localBuffer.writeHexadecimalUnsignedLong((paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[(i + 1)] & 0xFF);
          i += 2;
        }
      }
      return localBuffer.readUtf8();
    }
    
    private void a(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      int i = paramString.charAt(paramInt1);
      if ((i == 47) || (i == 92))
      {
        this.f.clear();
        this.f.add("");
        paramInt1 += 1;
        label52:
        if (paramInt1 >= paramInt2) {
          break label127;
        }
        i = c.a(paramString, paramInt1, paramInt2, "/\\");
        if (i >= paramInt2) {
          break label129;
        }
      }
      label127:
      label129:
      for (boolean bool = true;; bool = false)
      {
        a(paramString, paramInt1, i, bool, true);
        paramInt1 = i;
        if (!bool) {
          break label52;
        }
        paramInt1 = i + 1;
        break label52;
        this.f.set(this.f.size() - 1, "");
        break label52;
        break;
      }
    }
    
    private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramString = u.a(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, true);
      if (s(paramString)) {}
      for (;;)
      {
        return;
        if (t(paramString))
        {
          d();
          return;
        }
        if (((String)this.f.get(this.f.size() - 1)).isEmpty()) {
          this.f.set(this.f.size() - 1, paramString);
        }
        while (paramBoolean1)
        {
          this.f.add("");
          return;
          this.f.add(paramString);
        }
      }
    }
    
    private static boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
    {
      int j = paramInt3;
      int i = paramInt1;
      if (i < paramInt2) {
        if (j != paramArrayOfByte.length) {}
      }
      label20:
      while (j != paramInt3 + 4)
      {
        do
        {
          return false;
          paramInt1 = i;
          if (j == paramInt3) {
            break;
          }
        } while (paramString.charAt(i) != '.');
        paramInt1 = i + 1;
        int k = 0;
        i = paramInt1;
        for (;;)
        {
          int m;
          if (i < paramInt2)
          {
            m = paramString.charAt(i);
            if ((m >= 48) && (m <= 57)) {}
          }
          else
          {
            if (i - paramInt1 == 0) {
              break label20;
            }
            paramArrayOfByte[j] = ((byte)k);
            j += 1;
            break;
          }
          if ((k == 0) && (paramInt1 != i)) {
            break label20;
          }
          k = k * 10 + m - 48;
          if (k > 255) {
            break label20;
          }
          i += 1;
        }
      }
      return true;
    }
    
    private static int b(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 - paramInt1 < 2) {
        paramInt1 = -1;
      }
      int i;
      do
      {
        return paramInt1;
        i = paramString.charAt(paramInt1);
        if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90))) {
          return -1;
        }
        paramInt1 += 1;
        for (;;)
        {
          if (paramInt1 >= paramInt2) {
            break label127;
          }
          i = paramString.charAt(paramInt1);
          if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && ((i < 48) || (i > 57)) && (i != 43) && (i != 45) && (i != 46)) {
            break;
          }
          paramInt1 += 1;
        }
      } while (i == 58);
      return -1;
      label127:
      return -1;
    }
    
    private static int c(String paramString, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if ((j != 92) && (j != 47)) {
          break;
        }
        i += 1;
        paramInt1 += 1;
      }
      return i;
    }
    
    private static int d(String paramString, int paramInt1, int paramInt2)
    {
      int i;
      int j;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        j = paramInt1;
      }
      switch (paramString.charAt(paramInt1))
      {
      default: 
        i = paramInt1;
      case '[': 
        for (;;)
        {
          paramInt1 = i + 1;
          break;
          do
          {
            paramInt1 = i + 1;
            i = paramInt1;
            if (paramInt1 >= paramInt2) {
              break;
            }
            i = paramInt1;
          } while (paramString.charAt(paramInt1) != ']');
          i = paramInt1;
        }
        j = paramInt2;
      }
      return j;
    }
    
    private void d()
    {
      if ((((String)this.f.remove(this.f.size() - 1)).isEmpty()) && (!this.f.isEmpty()))
      {
        this.f.set(this.f.size() - 1, "");
        return;
      }
      this.f.add("");
    }
    
    private static String e(String paramString, int paramInt1, int paramInt2)
    {
      paramString = u.a(paramString, paramInt1, paramInt2, false);
      if (paramString.contains(":"))
      {
        if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {}
        for (paramString = f(paramString, 1, paramString.length() - 1); paramString == null; paramString = f(paramString, 0, paramString.length())) {
          return null;
        }
        paramString = paramString.getAddress();
        if (paramString.length == 16) {
          return a(paramString);
        }
        throw new AssertionError();
      }
      return c.b(paramString);
    }
    
    private static InetAddress f(String paramString, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = new byte[16];
      int i = 0;
      int j = -1;
      int i1 = -1;
      int m;
      for (int k = paramInt1;; k = paramInt1)
      {
        paramInt1 = i;
        m = j;
        if (k < paramInt2)
        {
          if (i == arrayOfByte.length) {
            return null;
          }
          if ((k + 2 <= paramInt2) && (paramString.regionMatches(k, "::", 0, 2)))
          {
            if (j != -1) {
              return null;
            }
            k += 2;
            i += 2;
            j = i;
            n = i;
            m = j;
            paramInt1 = k;
            if (k != paramInt2) {
              break label156;
            }
            m = j;
            paramInt1 = i;
          }
        }
        else
        {
          if (paramInt1 == arrayOfByte.length) {
            break label349;
          }
          if (m != -1) {
            break;
          }
          return null;
        }
        int n = i;
        m = j;
        paramInt1 = k;
        if (i != 0)
        {
          if (paramString.regionMatches(k, ":", 0, 1))
          {
            paramInt1 = k + 1;
            m = j;
            n = i;
          }
        }
        else
        {
          label156:
          i = 0;
          k = paramInt1;
        }
        for (;;)
        {
          if (paramInt1 < paramInt2)
          {
            j = u.a(paramString.charAt(paramInt1));
            if (j != -1) {}
          }
          else
          {
            j = paramInt1 - k;
            if ((j != 0) && (j <= 4)) {
              break label258;
            }
            return null;
            if (paramString.regionMatches(k, ".", 0, 1))
            {
              if (!a(paramString, i1, paramInt2, arrayOfByte, i - 2)) {
                return null;
              }
              paramInt1 = i + 2;
              m = j;
              break;
            }
            return null;
          }
          i = (i << 4) + j;
          paramInt1 += 1;
        }
        label258:
        i1 = n + 1;
        arrayOfByte[n] = ((byte)(i >>> 8 & 0xFF));
        j = i1 + 1;
        arrayOfByte[i1] = ((byte)(i & 0xFF));
        i = j;
        j = m;
        i1 = k;
      }
      System.arraycopy(arrayOfByte, m, arrayOfByte, arrayOfByte.length - (paramInt1 - m), paramInt1 - m);
      Arrays.fill(arrayOfByte, m, arrayOfByte.length - paramInt1 + m, (byte)0);
      try
      {
        label349:
        paramString = InetAddress.getByAddress(arrayOfByte);
        return paramString;
      }
      catch (UnknownHostException paramString)
      {
        throw new AssertionError();
      }
    }
    
    private static int g(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(u.a(paramString, paramInt1, paramInt2, "", false, false, false, true));
        if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
          return paramInt1;
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
      return -1;
    }
    
    private void r(String paramString)
    {
      int i = this.g.size() - 2;
      for (;;)
      {
        if (i >= 0)
        {
          if (paramString.equals(this.g.get(i)))
          {
            this.g.remove(i + 1);
            this.g.remove(i);
            if (this.g.isEmpty()) {
              this.g = null;
            }
          }
        }
        else {
          return;
        }
        i -= 2;
      }
    }
    
    private boolean s(String paramString)
    {
      return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
    }
    
    private boolean t(String paramString)
    {
      return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
    }
    
    int a()
    {
      if (this.e != -1) {
        return this.e;
      }
      return u.a(this.a);
    }
    
    a a(u paramu, String paramString)
    {
      int i = c.a(paramString, 0, paramString.length());
      int i1 = c.b(paramString, i, paramString.length());
      label60:
      int k;
      int n;
      if (b(paramString, i, i1) != -1) {
        if (paramString.regionMatches(true, i, "https:", 0, 6))
        {
          this.a = "https";
          i += "https:".length();
          k = 0;
          j = 0;
          m = c(paramString, i, i1);
          if ((m < 2) && (paramu != null) && (paramu.k.equals(this.a))) {
            break label636;
          }
          m = i + m;
          i = j;
          j = m;
          n = c.a(paramString, j, i1, "@/\\?#");
          if (n == i1) {
            break label310;
          }
        }
      }
      label310:
      for (int m = paramString.charAt(n);; m = -1) {
        switch (m)
        {
        default: 
          break;
        case -1: 
        case 35: 
        case 47: 
        case 63: 
        case 92: 
          i = d(paramString, j, n);
          if (i + 1 >= n) {
            break label481;
          }
          this.d = e(paramString, j, i);
          this.e = g(paramString, i + 1, n);
          if (this.e != -1) {
            break label503;
          }
          return a.d;
          if (paramString.regionMatches(true, i, "http:", 0, 5))
          {
            this.a = "http";
            i += "http:".length();
            break label60;
          }
          return a.c;
          if (paramu != null)
          {
            this.a = paramu.k;
            break label60;
          }
          return a.b;
        }
      }
      if (i == 0)
      {
        m = c.a(paramString, j, n, ':');
        String str = u.a(paramString, j, m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
        paramu = str;
        if (k != 0) {
          paramu = this.b + "%40" + str;
        }
        this.b = paramu;
        if (m != n)
        {
          i = 1;
          this.c = u.a(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
        }
        k = 1;
      }
      for (;;)
      {
        j = n + 1;
        break;
        this.c = (this.c + "%40" + u.a(paramString, j, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
      }
      label481:
      this.d = e(paramString, j, i);
      this.e = u.a(this.a);
      label503:
      if (this.d == null) {
        return a.e;
      }
      int j = n;
      for (;;)
      {
        i = c.a(paramString, j, i1, "?#");
        a(paramString, j, i);
        j = i;
        if (i < i1)
        {
          j = i;
          if (paramString.charAt(i) == '?')
          {
            j = c.a(paramString, i, i1, '#');
            this.g = u.b(u.a(paramString, i + 1, j, " \"'<>#", true, false, true, true));
          }
        }
        if ((j < i1) && (paramString.charAt(j) == '#')) {
          this.h = u.a(paramString, j + 1, i1, "", true, false, false, false);
        }
        return a.a;
        label636:
        this.b = paramu.e();
        this.c = paramu.g();
        this.d = paramu.l;
        this.e = paramu.m;
        this.f.clear();
        this.f.addAll(paramu.m());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {}
        }
        else
        {
          m(paramu.o());
          j = i;
        }
      }
    }
    
    public a a(int paramInt)
    {
      if ((paramInt <= 0) || (paramInt > 65535)) {
        throw new IllegalArgumentException("unexpected port: " + paramInt);
      }
      this.e = paramInt;
      return this;
    }
    
    public a a(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("pathSegment == null");
      }
      String str = u.a(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", false, false, false, true);
      if ((s(str)) || (t(str))) {
        throw new IllegalArgumentException("unexpected path segment: " + paramString);
      }
      this.f.set(paramInt, str);
      return this;
    }
    
    public a a(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("scheme == null");
      }
      if (paramString.equalsIgnoreCase("http"))
      {
        this.a = "http";
        return this;
      }
      if (paramString.equalsIgnoreCase("https"))
      {
        this.a = "https";
        return this;
      }
      throw new IllegalArgumentException("unexpected scheme: " + paramString);
    }
    
    public a a(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new NullPointerException("name == null");
      }
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(u.a(paramString1, " \"'<>#&=", false, false, true, true));
      List localList = this.g;
      if (paramString2 != null) {}
      for (paramString1 = u.a(paramString2, " \"'<>#&=", false, false, true, true);; paramString1 = null)
      {
        localList.add(paramString1);
        return this;
      }
    }
    
    a b()
    {
      int i = 0;
      int j = this.f.size();
      String str;
      while (i < j)
      {
        str = (String)this.f.get(i);
        this.f.set(i, u.a(str, "[]", true, true, false, true));
        i += 1;
      }
      if (this.g != null)
      {
        i = 0;
        j = this.g.size();
        while (i < j)
        {
          str = (String)this.g.get(i);
          if (str != null) {
            this.g.set(i, u.a(str, "\\^`{|}", true, true, true, true));
          }
          i += 1;
        }
      }
      if (this.h != null) {
        this.h = u.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
      }
      return this;
    }
    
    public a b(int paramInt)
    {
      this.f.remove(paramInt);
      if (this.f.isEmpty()) {
        this.f.add("");
      }
      return this;
    }
    
    public a b(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("encodedPathSegment == null");
      }
      String str = u.a(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", true, false, false, true);
      this.f.set(paramInt, str);
      if ((s(str)) || (t(str))) {
        throw new IllegalArgumentException("unexpected path segment: " + paramString);
      }
      return this;
    }
    
    public a b(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("username == null");
      }
      this.b = u.a(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new NullPointerException("encodedName == null");
      }
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(u.a(paramString1, " \"'<>#&=", true, false, true, true));
      List localList = this.g;
      if (paramString2 != null) {}
      for (paramString1 = u.a(paramString2, " \"'<>#&=", true, false, true, true);; paramString1 = null)
      {
        localList.add(paramString1);
        return this;
      }
    }
    
    public a c(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("encodedUsername == null");
      }
      this.b = u.a(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
      return this;
    }
    
    public a c(String paramString1, String paramString2)
    {
      n(paramString1);
      a(paramString1, paramString2);
      return this;
    }
    
    public u c()
    {
      if (this.a == null) {
        throw new IllegalStateException("scheme == null");
      }
      if (this.d == null) {
        throw new IllegalStateException("host == null");
      }
      return new u(this);
    }
    
    public a d(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("password == null");
      }
      this.c = u.a(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
      return this;
    }
    
    public a d(String paramString1, String paramString2)
    {
      o(paramString1);
      b(paramString1, paramString2);
      return this;
    }
    
    public a e(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("encodedPassword == null");
      }
      this.c = u.a(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
      return this;
    }
    
    public a f(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("host == null");
      }
      String str = e(paramString, 0, paramString.length());
      if (str == null) {
        throw new IllegalArgumentException("unexpected host: " + paramString);
      }
      this.d = str;
      return this;
    }
    
    public a g(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("pathSegment == null");
      }
      a(paramString, 0, paramString.length(), false, false);
      return this;
    }
    
    public a h(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("pathSegments == null");
      }
      return a(paramString, false);
    }
    
    public a i(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("encodedPathSegment == null");
      }
      a(paramString, 0, paramString.length(), false, true);
      return this;
    }
    
    public a j(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("encodedPathSegments == null");
      }
      return a(paramString, true);
    }
    
    public a k(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("encodedPath == null");
      }
      if (!paramString.startsWith("/")) {
        throw new IllegalArgumentException("unexpected encodedPath: " + paramString);
      }
      a(paramString, 0, paramString.length());
      return this;
    }
    
    public a l(String paramString)
    {
      if (paramString != null) {}
      for (paramString = u.b(u.a(paramString, " \"'<>#", false, false, true, true));; paramString = null)
      {
        this.g = paramString;
        return this;
      }
    }
    
    public a m(String paramString)
    {
      if (paramString != null) {}
      for (paramString = u.b(u.a(paramString, " \"'<>#", true, false, true, true));; paramString = null)
      {
        this.g = paramString;
        return this;
      }
    }
    
    public a n(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("name == null");
      }
      if (this.g == null) {
        return this;
      }
      r(u.a(paramString, " \"'<>#&=", false, false, true, true));
      return this;
    }
    
    public a o(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("encodedName == null");
      }
      if (this.g == null) {
        return this;
      }
      r(u.a(paramString, " \"'<>#&=", true, false, true, true));
      return this;
    }
    
    public a p(String paramString)
    {
      if (paramString != null) {}
      for (paramString = u.a(paramString, "", false, false, false, false);; paramString = null)
      {
        this.h = paramString;
        return this;
      }
    }
    
    public a q(String paramString)
    {
      if (paramString != null) {}
      for (paramString = u.a(paramString, "", true, false, false, false);; paramString = null)
      {
        this.h = paramString;
        return this;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("://");
      if ((!this.b.isEmpty()) || (!this.c.isEmpty()))
      {
        localStringBuilder.append(this.b);
        if (!this.c.isEmpty())
        {
          localStringBuilder.append(':');
          localStringBuilder.append(this.c);
        }
        localStringBuilder.append('@');
      }
      if (this.d.indexOf(':') != -1)
      {
        localStringBuilder.append('[');
        localStringBuilder.append(this.d);
        localStringBuilder.append(']');
      }
      for (;;)
      {
        int i = a();
        if (i != u.a(this.a))
        {
          localStringBuilder.append(':');
          localStringBuilder.append(i);
        }
        u.a(localStringBuilder, this.f);
        if (this.g != null)
        {
          localStringBuilder.append('?');
          u.b(localStringBuilder, this.g);
        }
        if (this.h != null)
        {
          localStringBuilder.append('#');
          localStringBuilder.append(this.h);
        }
        return localStringBuilder.toString();
        localStringBuilder.append(this.d);
      }
    }
    
    static enum a
    {
      private a() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */