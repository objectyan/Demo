package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.b.g.b;
import cz.msebera.android.httpclient.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class at
{
  private static final String A = "\"(((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}))\"";
  private static final Pattern B = Pattern.compile("\"(((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}))\"");
  private static final String h = "\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?";
  private static final String i = "\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?";
  private static final String j = "(\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?";
  private static final String k = "\\d+\\.\\d+\\.\\d+\\.\\d+";
  private static final String l = "((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+)";
  private static final String m = "\\d*";
  private static final String n = "(((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+))(\\:\\d*)?";
  private static final Pattern o = Pattern.compile("(((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+))(\\:\\d*)?");
  private static final String p = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";
  private static final String q = "Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday";
  private static final String r = "Mon|Tue|Wed|Thu|Fri|Sat|Sun";
  private static final String s = "\\d{2}:\\d{2}:\\d{2}";
  private static final String t = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d";
  private static final String u = "\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}";
  private static final String v = "\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}";
  private static final String w = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}";
  private static final String x = "(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT";
  private static final String y = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT";
  private static final String z = "((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4})";
  private int a;
  private int b;
  private final String c;
  private int d;
  private String e;
  private String f;
  private Date g;
  
  at(String paramString)
  {
    this(paramString, 0);
  }
  
  at(String paramString, int paramInt)
  {
    this.b = paramInt;
    this.a = paramInt;
    this.c = paramString;
    h();
  }
  
  public static at[] a(f paramf)
  {
    ArrayList localArrayList = new ArrayList();
    paramf = paramf.d();
    int i1 = 0;
    for (;;)
    {
      if (i1 < paramf.length())
      {
        try
        {
          at localat = new at(paramf, i1);
          localArrayList.add(localat);
          int i2 = localat.a;
          i1 = i2;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          i1 = paramf.indexOf(',', i1);
          if (i1 != -1) {
            break label85;
          }
        }
      }
      else
      {
        return (at[])localArrayList.toArray(new at[0]);
        label85:
        i1 += 1;
      }
    }
  }
  
  private boolean b(char paramChar)
  {
    return (paramChar >= 0) && (paramChar <= '');
  }
  
  private boolean c(char paramChar)
  {
    return (paramChar == '') || ((paramChar >= 0) && (paramChar <= '\037'));
  }
  
  private boolean d(char paramChar)
  {
    return (paramChar == '(') || (paramChar == ')') || (paramChar == '<') || (paramChar == '>') || (paramChar == '@') || (paramChar == ',') || (paramChar == ';') || (paramChar == ':') || (paramChar == '\\') || (paramChar == '"') || (paramChar == '/') || (paramChar == '[') || (paramChar == ']') || (paramChar == '?') || (paramChar == '=') || (paramChar == '{') || (paramChar == '}') || (paramChar == ' ') || (paramChar == '\t');
  }
  
  private boolean e(char paramChar)
  {
    return (b(paramChar)) && (!c(paramChar)) && (!d(paramChar));
  }
  
  private void n()
  {
    String str = this.c.substring(this.b);
    throw new IllegalArgumentException("Bad warn code \"" + str + "\"");
  }
  
  protected void a()
  {
    for (;;)
    {
      if (this.a < this.c.length()) {}
      switch (this.c.charAt(this.a))
      {
      default: 
      case '\r': 
        do
        {
          return;
        } while ((this.a + 2 >= this.c.length()) || (this.c.charAt(this.a + 1) != '\n') || ((this.c.charAt(this.a + 2) != ' ') && (this.c.charAt(this.a + 2) != '\t')));
        this.a += 2;
      }
      this.a += 1;
    }
  }
  
  protected void a(char paramChar)
  {
    if ((this.a + 1 > this.c.length()) || (paramChar != this.c.charAt(this.a))) {
      n();
    }
    this.a += 1;
  }
  
  protected void b()
  {
    if (!e(this.c.charAt(this.a))) {
      n();
    }
    for (;;)
    {
      if ((this.a >= this.c.length()) || (!e(this.c.charAt(this.a)))) {
        return;
      }
      this.a += 1;
    }
  }
  
  protected void c()
  {
    Matcher localMatcher = o.matcher(this.c.substring(this.a));
    if (!localMatcher.find()) {
      n();
    }
    if (localMatcher.start() != 0) {
      n();
    }
    this.a += localMatcher.end();
  }
  
  protected void d()
  {
    int i1 = this.a;
    try
    {
      c();
      this.e = this.c.substring(i1, this.a);
      a(' ');
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.a = i1;
      b();
      this.e = this.c.substring(i1, this.a);
      a(' ');
    }
  }
  
  protected void e()
  {
    if (this.c.charAt(this.a) != '"') {
      n();
    }
    this.a += 1;
    int i1 = 0;
    while ((this.a < this.c.length()) && (i1 == 0))
    {
      char c1 = this.c.charAt(this.a);
      if ((this.a + 1 < this.c.length()) && (c1 == '\\') && (b(this.c.charAt(this.a + 1))))
      {
        this.a += 2;
      }
      else if (c1 == '"')
      {
        i1 = 1;
        this.a += 1;
      }
      else if ((c1 != '"') && (!c(c1)))
      {
        this.a += 1;
      }
      else
      {
        n();
      }
    }
    if (i1 == 0) {
      n();
    }
  }
  
  protected void f()
  {
    int i1 = this.a;
    e();
    this.f = this.c.substring(i1, this.a);
  }
  
  protected void g()
  {
    int i1 = this.a;
    Matcher localMatcher = B.matcher(this.c.substring(this.a));
    if (!localMatcher.lookingAt()) {
      n();
    }
    this.a += localMatcher.end();
    this.g = b.a(this.c.substring(i1 + 1, this.a - 1));
  }
  
  protected void h()
  {
    a();
    i();
    d();
    f();
    if ((this.a + 1 < this.c.length()) && (this.c.charAt(this.a) == ' ') && (this.c.charAt(this.a + 1) == '"'))
    {
      a(' ');
      g();
    }
    a();
    if (this.a != this.c.length()) {
      a(',');
    }
  }
  
  protected void i()
  {
    if ((this.a + 4 > this.c.length()) || (!Character.isDigit(this.c.charAt(this.a))) || (!Character.isDigit(this.c.charAt(this.a + 1))) || (!Character.isDigit(this.c.charAt(this.a + 2))) || (this.c.charAt(this.a + 3) != ' ')) {
      n();
    }
    this.d = Integer.parseInt(this.c.substring(this.a, this.a + 3));
    this.a += 4;
  }
  
  public int j()
  {
    return this.d;
  }
  
  public String k()
  {
    return this.e;
  }
  
  public String l()
  {
    return this.f;
  }
  
  public Date m()
  {
    return this.g;
  }
  
  public String toString()
  {
    if (this.g != null) {
      return String.format("%d %s %s \"%s\"", new Object[] { Integer.valueOf(this.d), this.e, this.f, b.a(this.g) });
    }
    return String.format("%d %s %s", new Object[] { Integer.valueOf(this.d), this.e, this.f });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */