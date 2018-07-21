package com.a.a;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.lang.model.SourceVersion;

public final class i
  implements Cloneable
{
  private final Set<String> a;
  private final Map<Object, String> b;
  
  public i()
  {
    this(new LinkedHashSet(), new LinkedHashMap());
  }
  
  private i(LinkedHashSet<String> paramLinkedHashSet, LinkedHashMap<Object, String> paramLinkedHashMap)
  {
    this.a = paramLinkedHashSet;
    this.b = paramLinkedHashMap;
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      int k = paramString.codePointAt(i);
      if ((i == 0) && (!Character.isJavaIdentifierStart(k)) && (Character.isJavaIdentifierPart(k))) {
        localStringBuilder.append("_");
      }
      if (Character.isJavaIdentifierPart(k)) {}
      for (int j = k;; j = 95)
      {
        localStringBuilder.appendCodePoint(j);
        i += Character.charCount(k);
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public i a()
  {
    return new i(new LinkedHashSet(this.a), new LinkedHashMap(this.b));
  }
  
  public String a(Object paramObject)
  {
    String str = (String)this.b.get(paramObject);
    if (str == null) {
      throw new IllegalArgumentException("unknown tag: " + paramObject);
    }
    return str;
  }
  
  public String a(String paramString)
  {
    return a(paramString, UUID.randomUUID().toString());
  }
  
  public String a(String paramString, Object paramObject)
  {
    o.a(paramString, "suggestion", new Object[0]);
    o.a(paramObject, "tag", new Object[0]);
    for (paramString = b(paramString); (SourceVersion.isKeyword(paramString)) || (!this.a.add(paramString)); paramString = paramString + "_") {}
    String str = (String)this.b.put(paramObject, paramString);
    if (str != null)
    {
      this.b.put(paramObject, str);
      throw new IllegalArgumentException("tag " + paramObject + " cannot be used for both '" + str + "' and '" + paramString + "'");
    }
    return paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */