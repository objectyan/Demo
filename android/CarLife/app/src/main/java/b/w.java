package b;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class w
{
  private static final String a = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final String b = "\"([^\"]*)\"";
  private static final Pattern c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private static final Pattern d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  
  private w(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
  }
  
  public static w a(String paramString)
  {
    Object localObject1 = c.matcher(paramString);
    if (!((Matcher)localObject1).lookingAt()) {}
    String str1;
    String str2;
    Object localObject2;
    Matcher localMatcher;
    int i;
    do
    {
      return null;
      str1 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
      str2 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
      localObject2 = null;
      localMatcher = d.matcher(paramString);
      i = ((Matcher)localObject1).end();
      if (i >= paramString.length()) {
        break;
      }
      localMatcher.region(i, paramString.length());
    } while (!localMatcher.lookingAt());
    String str3 = localMatcher.group(1);
    localObject1 = localObject2;
    if (str3 != null)
    {
      if (str3.equalsIgnoreCase("charset")) {
        break label124;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      i = localMatcher.end();
      localObject2 = localObject1;
      break;
      label124:
      localObject1 = localMatcher.group(2);
      if (localObject1 != null) {
        if ((((String)localObject1).startsWith("'")) && (((String)localObject1).endsWith("'")) && (((String)localObject1).length() > 2)) {
          localObject1 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1);
        }
      }
      while ((localObject2 != null) && (!((String)localObject1).equalsIgnoreCase((String)localObject2)))
      {
        throw new IllegalArgumentException("Multiple different charsets: " + paramString);
        continue;
        localObject1 = localMatcher.group(3);
      }
    }
    return new w(paramString, str1, str2, (String)localObject2);
  }
  
  public String a()
  {
    return this.f;
  }
  
  public Charset a(Charset paramCharset)
  {
    if (this.h != null) {
      paramCharset = Charset.forName(this.h);
    }
    return paramCharset;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public Charset c()
  {
    if (this.h != null) {
      return Charset.forName(this.h);
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof w)) && (((w)paramObject).e.equals(this.e));
  }
  
  public int hashCode()
  {
    return this.e.hashCode();
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */