package com.indooratlas.android.sdk._internal;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ge
{
  private static final char[] d = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public final String a;
  public final String b;
  public final int c;
  private final String e;
  private final String f;
  private final List<String> g;
  private final List<String> h;
  private final String i;
  private final String j;
  
  private ge(a parama)
  {
    this.a = parama.a;
    this.e = a(parama.b, false);
    this.f = a(parama.c, false);
    this.b = parama.d;
    this.c = parama.a();
    this.g = a(parama.f, false);
    if (parama.g != null) {}
    for (Object localObject1 = a(parama.g, true);; localObject1 = null)
    {
      this.h = ((List)localObject1);
      localObject1 = localObject2;
      if (parama.h != null) {
        localObject1 = a(parama.h, false);
      }
      this.i = ((String)localObject1);
      this.j = parama.toString();
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
  
  public static ge a(URL paramURL)
  {
    return d(paramURL.toString());
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString1.codePointAt(k);
      if ((m < 32) || (m == 127) || ((m >= 128) && (paramBoolean4)) || (paramString2.indexOf(m) != -1) || ((m == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, k, paramInt2))))) || ((m == 43) && (paramBoolean3)))
      {
        in localin = new in();
        localin.a(paramString1, paramInt1, k);
        paramInt1 = k;
        Object localObject1 = null;
        if (paramInt1 < paramInt2)
        {
          k = paramString1.codePointAt(paramInt1);
          Object localObject3;
          Object localObject2;
          if (paramBoolean1)
          {
            localObject3 = localObject1;
            if (k != 9)
            {
              localObject3 = localObject1;
              if (k != 10)
              {
                localObject3 = localObject1;
                if (k != 12)
                {
                  localObject3 = localObject1;
                  if (k == 13) {}
                }
              }
            }
          }
          else
          {
            if ((k != 43) || (!paramBoolean3)) {
              break label234;
            }
            if (!paramBoolean1) {
              break label227;
            }
            localObject2 = "+";
            label200:
            localin.a((String)localObject2);
            localObject3 = localObject1;
          }
          for (;;)
          {
            paramInt1 = Character.charCount(k) + paramInt1;
            localObject1 = localObject3;
            break;
            label227:
            localObject2 = "%2B";
            break label200;
            label234:
            if ((k < 32) || (k == 127) || ((k >= 128) && (paramBoolean4)) || (paramString2.indexOf(k) != -1) || ((k == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, paramInt1, paramInt2))))))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new in();
              }
              ((in)localObject2).a(k);
              for (;;)
              {
                localObject3 = localObject2;
                if (((in)localObject2).d()) {
                  break;
                }
                m = ((in)localObject2).e() & 0xFF;
                localin.b(37);
                localin.b(d[(m >> 4 & 0xF)]);
                localin.b(d[(m & 0xF)]);
              }
            }
            localin.a(k);
            localObject3 = localObject1;
          }
        }
        return localin.l();
      }
      k += Character.charCount(m);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString.charAt(k);
      if ((m == 37) || ((m == 43) && (paramBoolean)))
      {
        in localin = new in();
        localin.a(paramString, paramInt1, k);
        paramInt1 = k;
        if (paramInt1 < paramInt2)
        {
          k = paramString.codePointAt(paramInt1);
          if ((k == 37) && (paramInt1 + 2 < paramInt2))
          {
            m = a(paramString.charAt(paramInt1 + 1));
            int n = a(paramString.charAt(paramInt1 + 2));
            if ((m == -1) || (n == -1)) {
              break label169;
            }
            localin.b((m << 4) + n);
            paramInt1 += 2;
          }
          for (;;)
          {
            paramInt1 += Character.charCount(k);
            break;
            if ((k == 43) && (paramBoolean)) {
              localin.b(32);
            } else {
              label169:
              localin.a(k);
            }
          }
        }
        return localin.l();
      }
      k += 1;
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, true, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private static List<String> a(List<String> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      if (paramList != null) {}
      for (paramList = a(paramList, paramBoolean);; paramList = null)
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void a(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(k));
      k += 1;
    }
  }
  
  private static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    return (paramInt1 + 2 < paramInt2) && (paramString.charAt(paramInt1) == '%') && (a(paramString.charAt(paramInt1 + 1)) != -1) && (a(paramString.charAt(paramInt1 + 2)) != -1);
  }
  
  static List<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    if (k <= paramString.length())
    {
      int n = paramString.indexOf('&', k);
      int m = n;
      if (n == -1) {
        m = paramString.length();
      }
      n = paramString.indexOf('=', k);
      if ((n == -1) || (n > m))
      {
        localArrayList.add(paramString.substring(k, m));
        localArrayList.add(null);
      }
      for (;;)
      {
        k = m + 1;
        break;
        localArrayList.add(paramString.substring(k, n));
        localArrayList.add(paramString.substring(n + 1, m));
      }
    }
    return localArrayList;
  }
  
  static void b(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      String str1 = (String)paramList.get(k);
      String str2 = (String)paramList.get(k + 1);
      if (k > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      k += 2;
    }
  }
  
  public static ge d(String paramString)
  {
    ge localge = null;
    a locala = new a();
    if (locala.a(null, paramString) == ge.a.a.a) {
      localge = locala.b();
    }
    return localge;
  }
  
  public final URI a()
  {
    Object localObject2 = new a();
    ((a)localObject2).a = this.a;
    ((a)localObject2).b = b();
    ((a)localObject2).c = c();
    ((a)localObject2).d = this.b;
    int k;
    if (this.c != a(this.a))
    {
      k = this.c;
      ((a)localObject2).e = k;
      ((a)localObject2).f.clear();
      ((a)localObject2).f.addAll(e());
      ((a)localObject2).a(f());
      if (this.i != null) {
        break label187;
      }
    }
    int m;
    for (Object localObject1 = null;; localObject1 = this.j.substring(k + 1))
    {
      ((a)localObject2).h = ((String)localObject1);
      m = ((a)localObject2).f.size();
      k = 0;
      while (k < m)
      {
        localObject1 = (String)((a)localObject2).f.get(k);
        ((a)localObject2).f.set(k, a((String)localObject1, "[]", true, false, true));
        k += 1;
      }
      k = -1;
      break;
      label187:
      k = this.j.indexOf('#');
    }
    if (((a)localObject2).g != null)
    {
      m = ((a)localObject2).g.size();
      k = 0;
      while (k < m)
      {
        localObject1 = (String)((a)localObject2).g.get(k);
        if (localObject1 != null) {
          ((a)localObject2).g.set(k, a((String)localObject1, "\\^`{|}", true, true, true));
        }
        k += 1;
      }
    }
    if (((a)localObject2).h != null) {
      ((a)localObject2).h = a(((a)localObject2).h, " \"#<>\\^`{|}", true, false, false);
    }
    localObject2 = ((a)localObject2).toString();
    try
    {
      localObject1 = new URI((String)localObject2);
      return (URI)localObject1;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        localObject2 = URI.create(((String)localObject2).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        return (URI)localObject2;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localURISyntaxException);
      }
    }
  }
  
  public final String b()
  {
    if (this.e.isEmpty()) {
      return "";
    }
    int k = this.a.length() + 3;
    int m = gy.a(this.j, k, this.j.length(), ":@");
    return this.j.substring(k, m);
  }
  
  public final ge c(String paramString)
  {
    ge localge = null;
    a locala = new a();
    if (locala.a(this, paramString) == ge.a.a.a) {}
    for (paramString = locala;; paramString = null)
    {
      if (paramString != null) {
        localge = paramString.b();
      }
      return localge;
    }
  }
  
  public final String c()
  {
    if (this.f.isEmpty()) {
      return "";
    }
    int k = this.j.indexOf(':', this.a.length() + 3);
    int m = this.j.indexOf('@');
    return this.j.substring(k + 1, m);
  }
  
  public final String d()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    int m = gy.a(this.j, k, this.j.length(), "?#");
    return this.j.substring(k, m);
  }
  
  public final List<String> e()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    int m = gy.a(this.j, k, this.j.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (k < m)
    {
      int n = k + 1;
      k = gy.a(this.j, n, m, '/');
      localArrayList.add(this.j.substring(n, k));
    }
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ge)) && (((ge)paramObject).j.equals(this.j));
  }
  
  public final String f()
  {
    if (this.h == null) {
      return null;
    }
    int k = this.j.indexOf('?') + 1;
    int m = gy.a(this.j, k + 1, this.j.length(), '#');
    return this.j.substring(k, m);
  }
  
  public final String g()
  {
    if (this.h == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, this.h);
    return localStringBuilder.toString();
  }
  
  public final int hashCode()
  {
    return this.j.hashCode();
  }
  
  public final String toString()
  {
    return this.j;
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
    
    static String a(String paramString, int paramInt1, int paramInt2)
    {
      int m = 0;
      paramString = ge.a(paramString, paramInt1, paramInt2, false);
      if ((paramString.startsWith("[")) && (paramString.endsWith("]")))
      {
        paramString = a(paramString, paramString.length() - 1);
        if (paramString == null) {
          return null;
        }
        paramString = paramString.getAddress();
        if (paramString.length == 16)
        {
          paramInt2 = 0;
          int i = -1;
          paramInt1 = 0;
          int j;
          while (paramInt1 < paramString.length)
          {
            j = paramInt1;
            while ((j < 16) && (paramString[j] == 0) && (paramString[(j + 1)] == 0)) {
              j += 2;
            }
            int n = j - paramInt1;
            int k = paramInt2;
            if (n > paramInt2)
            {
              k = n;
              i = paramInt1;
            }
            paramInt1 = j + 2;
            paramInt2 = k;
          }
          in localin = new in();
          paramInt1 = m;
          while (paramInt1 < paramString.length) {
            if (paramInt1 == i)
            {
              localin.b(58);
              j = paramInt1 + paramInt2;
              paramInt1 = j;
              if (j == 16)
              {
                localin.b(58);
                paramInt1 = j;
              }
            }
            else
            {
              if (paramInt1 > 0) {
                localin.b(58);
              }
              localin.h((paramString[paramInt1] & 0xFF) << 8 | paramString[(paramInt1 + 1)] & 0xFF);
              paramInt1 += 2;
            }
          }
          return localin.l();
        }
        throw new AssertionError();
      }
      return gy.a(paramString);
    }
    
    private static InetAddress a(String paramString, int paramInt)
    {
      byte[] arrayOfByte = new byte[16];
      int j = 0;
      int k = -1;
      int m = -1;
      int n = 1;
      int i1 = k;
      int i = j;
      if (n < paramInt)
      {
        if (j == 16) {
          return null;
        }
        if ((n + 2 <= paramInt) && (paramString.regionMatches(n, "::", 0, 2)))
        {
          if (k != -1) {
            return null;
          }
          i = n + 2;
          j += 2;
          if (i != paramInt) {
            break label525;
          }
          i = j;
          i1 = j;
        }
      }
      else
      {
        if (i == 16) {
          break label508;
        }
        if (i1 != -1) {
          break label473;
        }
        return null;
      }
      i = n;
      i1 = k;
      int i2 = j;
      if (j != 0)
      {
        if (!paramString.regionMatches(n, ":", 0, 1)) {
          break label180;
        }
        i = n + 1;
        i2 = j;
      }
      for (i1 = k;; i1 = j)
      {
        k = 0;
        j = i;
        for (;;)
        {
          if (j < paramInt)
          {
            m = ge.a(paramString.charAt(j));
            if (m != -1)
            {
              k = (k << 4) + m;
              j += 1;
              continue;
              label180:
              if (paramString.regionMatches(n, ".", 0, 1))
              {
                i2 = j - 2;
                n = i2;
                if (m < paramInt) {
                  if (n == 16) {
                    paramInt = 0;
                  }
                }
                for (;;)
                {
                  if (paramInt != 0) {
                    break label387;
                  }
                  return null;
                  i = m;
                  if (n != i2)
                  {
                    if (paramString.charAt(m) != '.') {
                      paramInt = 0;
                    } else {
                      i = m + 1;
                    }
                  }
                  else
                  {
                    i1 = 0;
                    m = i;
                    for (;;)
                    {
                      if (m >= paramInt) {
                        break label339;
                      }
                      int i3 = paramString.charAt(m);
                      if ((i3 < 48) || (i3 > 57)) {
                        break label339;
                      }
                      if ((i1 == 0) && (i != m))
                      {
                        paramInt = 0;
                        break;
                      }
                      i1 = i1 * 10 + i3 - 48;
                      if (i1 > 255)
                      {
                        paramInt = 0;
                        break;
                      }
                      m += 1;
                    }
                    label339:
                    if (m - i == 0)
                    {
                      paramInt = 0;
                    }
                    else
                    {
                      arrayOfByte[n] = ((byte)i1);
                      n += 1;
                      break;
                      if (n != i2 + 4) {
                        paramInt = 0;
                      } else {
                        paramInt = 1;
                      }
                    }
                  }
                }
                label387:
                i = j + 2;
                i1 = k;
                break;
              }
              return null;
            }
          }
        }
        m = j - i;
        if ((m == 0) || (m > 4)) {
          return null;
        }
        n = i2 + 1;
        arrayOfByte[i2] = ((byte)(k >>> 8 & 0xFF));
        m = n + 1;
        arrayOfByte[n] = ((byte)(k & 0xFF));
        n = j;
        k = i1;
        j = m;
        m = i;
        break;
        label473:
        System.arraycopy(arrayOfByte, i1, arrayOfByte, 16 - (i - i1), i - i1);
        Arrays.fill(arrayOfByte, i1, 16 - i + i1, (byte)0);
        try
        {
          label508:
          paramString = InetAddress.getByAddress(arrayOfByte);
          return paramString;
        }
        catch (UnknownHostException paramString)
        {
          throw new AssertionError();
        }
        label525:
        i2 = j;
      }
    }
    
    private void b(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      int i = paramString.charAt(paramInt1);
      label52:
      int j;
      label76:
      String str;
      if ((i == 47) || (i == 92))
      {
        this.f.clear();
        this.f.add("");
        paramInt1 += 1;
        if (paramInt1 >= paramInt2) {
          break label267;
        }
        j = gy.a(paramString, paramInt1, paramInt2, "/\\");
        if (j >= paramInt2) {
          break label269;
        }
        i = 1;
        str = ge.a(paramString, paramInt1, j, " \"<>^`{}|/\\?#", true, false, false, true);
        if ((!str.equals(".")) && (!str.equalsIgnoreCase("%2e"))) {
          break label275;
        }
        paramInt1 = 1;
        label113:
        if (paramInt1 == 0)
        {
          if ((!str.equals("..")) && (!str.equalsIgnoreCase("%2e.")) && (!str.equalsIgnoreCase(".%2e")) && (!str.equalsIgnoreCase("%2e%2e"))) {
            break label280;
          }
          paramInt1 = 1;
          label159:
          if (paramInt1 == 0) {
            break label300;
          }
          if ((!((String)this.f.remove(this.f.size() - 1)).isEmpty()) || (this.f.isEmpty())) {
            break label285;
          }
          this.f.set(this.f.size() - 1, "");
        }
      }
      label267:
      label269:
      label275:
      label280:
      label285:
      label300:
      label385:
      for (;;)
      {
        paramInt1 = j;
        if (i != 0) {
          paramInt1 = j + 1;
        }
        break label52;
        this.f.set(this.f.size() - 1, "");
        break label52;
        break;
        i = 0;
        break label76;
        paramInt1 = 0;
        break label113;
        paramInt1 = 0;
        break label159;
        this.f.add("");
        continue;
        if (((String)this.f.get(this.f.size() - 1)).isEmpty()) {
          this.f.set(this.f.size() - 1, str);
        }
        for (;;)
        {
          if (i == 0) {
            break label385;
          }
          this.f.add("");
          break;
          this.f.add(str);
        }
      }
    }
    
    private static int c(String paramString, int paramInt1, int paramInt2)
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
    
    private static int d(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(ge.a(paramString, paramInt1, paramInt2, "", false, false, false, true));
        if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
          return paramInt1;
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
      return -1;
    }
    
    final int a()
    {
      if (this.e != -1) {
        return this.e;
      }
      return ge.a(this.a);
    }
    
    final int a(ge paramge, String paramString)
    {
      int j = gy.a(paramString, 0, paramString.length());
      int i1 = gy.b(paramString, j, paramString.length());
      int i;
      if (i1 - j >= 2)
      {
        i = paramString.charAt(j);
        if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)))
        {
          i = -1;
          if (i == -1) {
            break label290;
          }
          if (!paramString.regionMatches(true, j, "https:", 0, 6)) {
            break label258;
          }
          this.a = "https";
          i = j + 6;
        }
      }
      int n;
      int m;
      int k;
      for (;;)
      {
        n = 0;
        m = 0;
        k = 0;
        j = i;
        while (j < i1)
        {
          int i2 = paramString.charAt(j);
          if ((i2 != 92) && (i2 != 47)) {
            break;
          }
          k += 1;
          j += 1;
        }
        i = j + 1;
        for (;;)
        {
          if (i >= i1) {
            break label253;
          }
          k = paramString.charAt(i);
          if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)) && ((k < 48) || (k > 57)) && (k != 43) && (k != 45) && (k != 46))
          {
            if (k == 58) {
              break;
            }
            i = -1;
            break;
          }
          i += 1;
        }
        label253:
        i = -1;
        break;
        label258:
        if (paramString.regionMatches(true, j, "http:", 0, 5))
        {
          this.a = "http";
          i = j + 5;
        }
        else
        {
          return a.c;
          label290:
          if (paramge == null) {
            break label308;
          }
          this.a = ge.a(paramge);
          i = j;
        }
      }
      label308:
      return a.b;
      if ((k >= 2) || (paramge == null) || (!ge.a(paramge).equals(this.a)))
      {
        k = i + k;
        j = n;
        i = m;
        n = gy.a(paramString, k, i1, "@/\\?#");
        if (n != i1) {}
        for (m = paramString.charAt(n);; m = -1) {
          switch (m)
          {
          default: 
            break;
          case -1: 
          case 35: 
          case 47: 
          case 63: 
          case 92: 
            i = c(paramString, k, n);
            if (i + 1 >= n) {
              break label680;
            }
            this.d = a(paramString, k, i);
            this.e = d(paramString, i + 1, n);
            if (this.e != -1) {
              break label702;
            }
            return a.d;
          }
        }
        if (i == 0)
        {
          m = gy.a(paramString, k, n, ':');
          String str = ge.a(paramString, k, m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
          paramge = str;
          if (j != 0) {
            paramge = this.b + "%40" + str;
          }
          this.b = paramge;
          if (m != n)
          {
            i = 1;
            this.c = ge.a(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
          }
          j = i;
        }
        for (i = 1;; i = k)
        {
          m = i;
          k = n + 1;
          i = j;
          j = m;
          break;
          this.c = (this.c + "%40" + ge.a(paramString, k, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
          k = j;
          j = i;
        }
        label680:
        this.d = a(paramString, k, i);
        this.e = ge.a(this.a);
        label702:
        if (this.d == null) {
          return a.e;
        }
        j = n;
        i = gy.a(paramString, j, i1, "?#");
        b(paramString, j, i);
        if ((i >= i1) || (paramString.charAt(i) != '?')) {
          break label916;
        }
        j = gy.a(paramString, i, i1, '#');
        this.g = ge.b(ge.a(paramString, i + 1, j, " \"'<>#", true, false, true, true));
        i = j;
      }
      label916:
      for (;;)
      {
        if ((i < i1) && (paramString.charAt(i) == '#')) {
          this.h = ge.a(paramString, i + 1, i1, "", true, false, false, false);
        }
        return a.a;
        this.b = paramge.b();
        this.c = paramge.c();
        this.d = ge.b(paramge);
        this.e = ge.c(paramge);
        this.f.clear();
        this.f.addAll(paramge.e());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {
            break;
          }
        }
        a(paramge.f());
        j = i;
        break;
      }
    }
    
    public final a a(String paramString)
    {
      if (paramString != null) {}
      for (paramString = ge.b(ge.a(paramString, " \"'<>#", false, true, true));; paramString = null)
      {
        this.g = paramString;
        return this;
      }
    }
    
    public final ge b()
    {
      if (this.a == null) {
        throw new IllegalStateException("scheme == null");
      }
      if (this.d == null) {
        throw new IllegalStateException("host == null");
      }
      return new ge(this, (byte)0);
    }
    
    public final String toString()
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
        if (i != ge.a(this.a))
        {
          localStringBuilder.append(':');
          localStringBuilder.append(i);
        }
        ge.a(localStringBuilder, this.f);
        if (this.g != null)
        {
          localStringBuilder.append('?');
          ge.b(localStringBuilder, this.g);
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
    
    static enum a {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */