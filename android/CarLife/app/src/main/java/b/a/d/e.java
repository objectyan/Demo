package b.a.d;

import b.a.c;
import b.ab;
import b.ad;
import b.h;
import b.m;
import b.n;
import b.t;
import b.t.a;
import b.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final String a = "([^ \"=]*)";
  private static final String b = "\"([^\"]*)\"";
  private static final Pattern c = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
  
  public static int a(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((i == 32) || (i == 9)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public static int a(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      if ((paramInt >= paramString1.length()) || (paramString2.indexOf(paramString1.charAt(paramInt)) != -1)) {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public static long a(ad paramad)
  {
    return a(paramad.g());
  }
  
  public static long a(t paramt)
  {
    return a(paramt.a("Content-Length"));
  }
  
  private static long a(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  public static t a(t paramt1, t paramt2)
  {
    paramt2 = c(paramt2);
    if (paramt2.isEmpty()) {
      return new t.a().a();
    }
    t.a locala = new t.a();
    int i = 0;
    int j = paramt1.a();
    while (i < j)
    {
      String str = paramt1.a(i);
      if (paramt2.contains(str)) {
        locala.a(str, paramt1.b(i));
      }
      i += 1;
    }
    return locala.a();
  }
  
  public static List<h> a(t paramt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramt = paramt.c(paramString).iterator();
    label139:
    while (paramt.hasNext())
    {
      paramString = (String)paramt.next();
      int j = paramString.indexOf(' ');
      if (j != -1)
      {
        Matcher localMatcher = c.matcher(paramString);
        for (int i = j;; i = localMatcher.end())
        {
          if (!localMatcher.find(i)) {
            break label139;
          }
          if (paramString.regionMatches(true, localMatcher.start(1), "realm", 0, 5))
          {
            String str1 = paramString.substring(0, j);
            String str2 = localMatcher.group(3);
            if (str2 != null)
            {
              localArrayList.add(new h(str1, str2));
              break;
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(n paramn, u paramu, t paramt)
  {
    if (paramn == n.b) {}
    do
    {
      return;
      paramt = m.a(paramu, paramt);
    } while (paramt.isEmpty());
    paramn.a(paramu, paramt);
  }
  
  public static boolean a(ad paramad, t paramt, ab paramab)
  {
    paramad = e(paramad).iterator();
    while (paramad.hasNext())
    {
      String str = (String)paramad.next();
      if (!c.a(paramt.c(str), paramab.b(str))) {
        return false;
      }
    }
    return true;
  }
  
  public static int b(String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 2147483647L) {
        return Integer.MAX_VALUE;
      }
      if (l < 0L) {
        return 0;
      }
      return (int)l;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static boolean b(ad paramad)
  {
    return b(paramad.g());
  }
  
  public static boolean b(t paramt)
  {
    return c(paramt).contains("*");
  }
  
  public static t c(ad paramad)
  {
    return a(paramad.k().a().c(), paramad.g());
  }
  
  public static Set<String> c(t paramt)
  {
    Object localObject2 = Collections.emptySet();
    int i = 0;
    int k = paramt.a();
    while (i < k) {
      if (!"Vary".equalsIgnoreCase(paramt.a(i)))
      {
        i += 1;
      }
      else
      {
        Object localObject3 = paramt.b(i);
        Object localObject1 = localObject2;
        if (((Set)localObject2).isEmpty()) {
          localObject1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        }
        localObject3 = ((String)localObject3).split(",");
        int m = localObject3.length;
        int j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= m) {
            break;
          }
          ((Set)localObject1).add(localObject3[j].trim());
          j += 1;
        }
      }
    }
    return (Set<String>)localObject2;
  }
  
  public static boolean d(ad paramad)
  {
    if (paramad.a().b().equals("HEAD")) {}
    do
    {
      return false;
      int i = paramad.c();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
        return true;
      }
    } while ((a(paramad) == -1L) && (!"chunked".equalsIgnoreCase(paramad.b("Transfer-Encoding"))));
    return true;
  }
  
  private static Set<String> e(ad paramad)
  {
    return c(paramad.g());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */