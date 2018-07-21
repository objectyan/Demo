package b;

import b.a.c;
import b.a.d.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class t
{
  private final String[] a;
  
  t(a parama)
  {
    this.a = ((String[])parama.a.toArray(new String[parama.a.size()]));
  }
  
  private t(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
  }
  
  public static t a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      throw new NullPointerException("headers == null");
    }
    String[] arrayOfString = new String[paramMap.size() * 2];
    int i = 0;
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      if ((((Map.Entry)localObject).getKey() == null) || (((Map.Entry)localObject).getValue() == null)) {
        throw new IllegalArgumentException("Headers cannot be null");
      }
      String str = ((String)((Map.Entry)localObject).getKey()).trim();
      localObject = ((String)((Map.Entry)localObject).getValue()).trim();
      if ((str.length() == 0) || (str.indexOf(0) != -1) || (((String)localObject).indexOf(0) != -1)) {
        throw new IllegalArgumentException("Unexpected header: " + str + ": " + (String)localObject);
      }
      arrayOfString[i] = str;
      arrayOfString[(i + 1)] = localObject;
      i += 2;
    }
    return new t(arrayOfString);
  }
  
  public static t a(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new NullPointerException("namesAndValues == null");
    }
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("Expected alternating header names and values");
    }
    paramVarArgs = (String[])paramVarArgs.clone();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] == null) {
        throw new IllegalArgumentException("Headers cannot be null");
      }
      paramVarArgs[i] = paramVarArgs[i].trim();
      i += 1;
    }
    i = 0;
    while (i < paramVarArgs.length)
    {
      String str1 = paramVarArgs[i];
      String str2 = paramVarArgs[(i + 1)];
      if ((str1.length() == 0) || (str1.indexOf(0) != -1) || (str2.indexOf(0) != -1)) {
        throw new IllegalArgumentException("Unexpected header: " + str1 + ": " + str2);
      }
      i += 2;
    }
    return new t(paramVarArgs);
  }
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
        return paramArrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public int a()
  {
    return this.a.length / 2;
  }
  
  public String a(int paramInt)
  {
    return this.a[(paramInt * 2)];
  }
  
  public String a(String paramString)
  {
    return a(this.a, paramString);
  }
  
  public String b(int paramInt)
  {
    return this.a[(paramInt * 2 + 1)];
  }
  
  public Date b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return d.a(paramString);
    }
    return null;
  }
  
  public Set<String> b()
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    int j = a();
    while (i < j)
    {
      localTreeSet.add(a(i));
      i += 1;
    }
    return Collections.unmodifiableSet(localTreeSet);
  }
  
  public a c()
  {
    a locala = new a();
    Collections.addAll(locala.a, this.a);
    return locala;
  }
  
  public List<String> c(String paramString)
  {
    Object localObject1 = null;
    int i = 0;
    int j = a();
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (paramString.equalsIgnoreCase(a(i)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(b(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      return Collections.unmodifiableList((List)localObject1);
    }
    return Collections.emptyList();
  }
  
  public Map<String, List<String>> d()
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    int j = a();
    while (i < j)
    {
      String str = a(i).toLowerCase(Locale.US);
      List localList = (List)localTreeMap.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(2);
        localTreeMap.put(str, localObject);
      }
      ((List)localObject).add(b(i));
      i += 1;
    }
    return localTreeMap;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof t)) && (Arrays.equals(((t)paramObject).a, this.a));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.a);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = a();
    while (i < j)
    {
      localStringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    final List<String> a = new ArrayList(20);
    
    private void d(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new NullPointerException("name == null");
      }
      if (paramString1.isEmpty()) {
        throw new IllegalArgumentException("name is empty");
      }
      int i = 0;
      int j = paramString1.length();
      int k;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
        }
        i += 1;
      }
      if (paramString2 == null) {
        throw new NullPointerException("value == null");
      }
      i = 0;
      j = paramString2.length();
      while (i < j)
      {
        k = paramString2.charAt(i);
        if (((k <= 31) && (k != 9)) || (k >= 127)) {
          throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1, paramString2 }));
        }
        i += 1;
      }
    }
    
    a a(String paramString)
    {
      int i = paramString.indexOf(":", 1);
      if (i != -1) {
        return b(paramString.substring(0, i), paramString.substring(i + 1));
      }
      if (paramString.startsWith(":")) {
        return b("", paramString.substring(1));
      }
      return b("", paramString);
    }
    
    public a a(String paramString1, String paramString2)
    {
      d(paramString1, paramString2);
      return b(paramString1, paramString2);
    }
    
    public t a()
    {
      return new t(this);
    }
    
    public a b(String paramString)
    {
      int i = paramString.indexOf(":");
      if (i == -1) {
        throw new IllegalArgumentException("Unexpected header: " + paramString);
      }
      return a(paramString.substring(0, i).trim(), paramString.substring(i + 1));
    }
    
    a b(String paramString1, String paramString2)
    {
      this.a.add(paramString1);
      this.a.add(paramString2.trim());
      return this;
    }
    
    public a c(String paramString)
    {
      int j;
      for (int i = 0; i < this.a.size(); i = j + 2)
      {
        j = i;
        if (paramString.equalsIgnoreCase((String)this.a.get(i)))
        {
          this.a.remove(i);
          this.a.remove(i);
          j = i - 2;
        }
      }
      return this;
    }
    
    public a c(String paramString1, String paramString2)
    {
      d(paramString1, paramString2);
      c(paramString1);
      b(paramString1, paramString2);
      return this;
    }
    
    public String d(String paramString)
    {
      int i = this.a.size() - 2;
      while (i >= 0)
      {
        if (paramString.equalsIgnoreCase((String)this.a.get(i))) {
          return (String)this.a.get(i + 1);
        }
        i -= 2;
      }
      return null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */