package com.indooratlas.android.sdk._internal;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gg
{
  private static final Pattern b = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private static final Pattern c = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  final String a;
  private final String d;
  private final String e;
  private final String f;
  
  private gg(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.a = paramString4;
  }
  
  public static gg a(String paramString)
  {
    Object localObject1 = b.matcher(paramString);
    if (!((Matcher)localObject1).lookingAt()) {
      return null;
    }
    String str2 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
    String str3 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
    Matcher localMatcher = c.matcher(paramString);
    int i = ((Matcher)localObject1).end();
    Object localObject2;
    for (localObject1 = null;; localObject1 = localObject2)
    {
      if (i >= paramString.length()) {
        break label189;
      }
      localMatcher.region(i, paramString.length());
      if (!localMatcher.lookingAt()) {
        break;
      }
      String str1 = localMatcher.group(1);
      if ((str1 != null) && (str1.equalsIgnoreCase("charset")))
      {
        if (localMatcher.group(2) != null) {}
        for (str1 = localMatcher.group(2);; str1 = localMatcher.group(3))
        {
          localObject2 = str1;
          if (localObject1 == null) {
            break;
          }
          localObject2 = str1;
          if (str1.equalsIgnoreCase((String)localObject1)) {
            break;
          }
          throw new IllegalArgumentException("Multiple different charsets: " + paramString);
        }
      }
      localObject2 = localObject1;
      i = localMatcher.end();
    }
    label189:
    return new gg(paramString, str2, str3, (String)localObject1);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof gg)) && (((gg)paramObject).d.equals(this.d));
  }
  
  public final int hashCode()
  {
    return this.d.hashCode();
  }
  
  public final String toString()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */