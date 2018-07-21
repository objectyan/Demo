package b;

import b.a.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;

public final class r
  extends ac
{
  private static final w a = w.a("application/x-www-form-urlencoded");
  private final List<String> b;
  private final List<String> c;
  
  r(List<String> paramList1, List<String> paramList2)
  {
    this.b = c.a(paramList1);
    this.c = c.a(paramList2);
  }
  
  private long a(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    long l = 0L;
    if (paramBoolean) {}
    for (paramBufferedSink = new Buffer();; paramBufferedSink = paramBufferedSink.buffer())
    {
      int i = 0;
      int j = this.b.size();
      while (i < j)
      {
        if (i > 0) {
          paramBufferedSink.writeByte(38);
        }
        paramBufferedSink.writeUtf8((String)this.b.get(i));
        paramBufferedSink.writeByte(61);
        paramBufferedSink.writeUtf8((String)this.c.get(i));
        i += 1;
      }
    }
    if (paramBoolean)
    {
      l = paramBufferedSink.size();
      paramBufferedSink.clear();
    }
    return l;
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public String a(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
  
  public void a(BufferedSink paramBufferedSink)
    throws IOException
  {
    a(paramBufferedSink, false);
  }
  
  public w b()
  {
    return a;
  }
  
  public String b(int paramInt)
  {
    return u.a(a(paramInt), true);
  }
  
  public long c()
  {
    return a(null, true);
  }
  
  public String c(int paramInt)
  {
    return (String)this.c.get(paramInt);
  }
  
  public String d(int paramInt)
  {
    return u.a(c(paramInt), true);
  }
  
  public static final class a
  {
    private final List<String> a = new ArrayList();
    private final List<String> b = new ArrayList();
    
    public a a(String paramString1, String paramString2)
    {
      this.a.add(u.a(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
      this.b.add(u.a(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
      return this;
    }
    
    public r a()
    {
      return new r(this.a, this.b);
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.a.add(u.a(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
      this.b.add(u.a(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */