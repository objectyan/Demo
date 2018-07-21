package com.a.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.lang.model.element.Modifier;

final class o
{
  static final Modifier a;
  
  static
  {
    Object localObject = null;
    try
    {
      Modifier localModifier = Modifier.valueOf("DEFAULT");
      localObject = localModifier;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    a = (Modifier)localObject;
  }
  
  static <T> T a(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(String.format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  static String a(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      if (Character.isISOControl(paramChar)) {
        return String.format("\\u%04x", new Object[] { Integer.valueOf(paramChar) });
      }
      break;
    case '\b': 
      return "\\b";
    case '\t': 
      return "\\t";
    case '\n': 
      return "\\n";
    case '\f': 
      return "\\f";
    case '\r': 
      return "\\r";
    case '"': 
      return "\"";
    case '\'': 
      return "\\'";
    case '\\': 
      return "\\\\";
    }
    return Character.toString(paramChar);
  }
  
  static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1.length() + 2);
    localStringBuilder.append('"');
    int i = 0;
    if (i < paramString1.length())
    {
      char c = paramString1.charAt(i);
      if (c == '\'') {
        localStringBuilder.append("'");
      }
      for (;;)
      {
        i += 1;
        break;
        if (c == '"')
        {
          localStringBuilder.append("\\\"");
        }
        else
        {
          localStringBuilder.append(a(c));
          if ((c == '\n') && (i + 1 < paramString1.length())) {
            localStringBuilder.append("\"\n").append(paramString2).append(paramString2).append("+ \"");
          }
        }
      }
    }
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }
  
  static String a(String paramString, List<String> paramList)
  {
    if (paramList.isEmpty()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)paramList.get(0));
    int i = 1;
    while (i < paramList.size())
    {
      localStringBuilder.append(paramString).append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  static <T> List<T> a(Collection<T> paramCollection)
  {
    return Collections.unmodifiableList(new ArrayList(paramCollection));
  }
  
  static <K, V> Map<K, List<V>> a(Map<K, List<V>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!((List)localEntry.getValue()).isEmpty()) {
        localLinkedHashMap.put(localEntry.getKey(), a((Collection)localEntry.getValue()));
      }
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static <T> Set<T> a(Set<T> paramSet1, Set<T> paramSet2)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.addAll(paramSet1);
    localLinkedHashSet.addAll(paramSet2);
    return localLinkedHashSet;
  }
  
  static void a(Set<Modifier> paramSet, Modifier... paramVarArgs)
  {
    int j = 0;
    int m = paramVarArgs.length;
    int i = 0;
    if (i < m)
    {
      Modifier localModifier = paramVarArgs[i];
      int k;
      if ((localModifier == null) && (a == null)) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j;
        if (paramSet.contains(localModifier)) {
          k = j + 1;
        }
      }
    }
    if (j == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, "modifiers %s must contain one of %s", new Object[] { paramSet, Arrays.toString(paramVarArgs) });
      return;
    }
  }
  
  static void a(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  static <K, V> Map<K, V> b(Map<K, V> paramMap)
  {
    return Collections.unmodifiableMap(new LinkedHashMap(paramMap));
  }
  
  static <T> Set<T> b(Collection<T> paramCollection)
  {
    return Collections.unmodifiableSet(new LinkedHashSet(paramCollection));
  }
  
  static void b(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.format(paramString, paramVarArgs));
    }
  }
  
  static boolean c(Collection<Modifier> paramCollection)
  {
    return (a != null) && (paramCollection.contains(a));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */