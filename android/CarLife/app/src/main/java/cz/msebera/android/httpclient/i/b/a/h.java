package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.a.m;
import cz.msebera.android.httpclient.b.g.b;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Immutable
class h
{
  private final m a;
  
  h()
  {
    this(new ac());
  }
  
  h(m paramm)
  {
    this.a = paramm;
  }
  
  private void a(List<f> paramList, d paramd)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if ("Warning".equals(((f)paramList.next()).c()))
      {
        f[] arrayOff = paramd.b("Warning");
        int j = arrayOff.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOff[i].d().startsWith("1")) {
            paramList.remove();
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(List<f> paramList, x paramx)
  {
    paramx = paramx.getAllHeaders();
    int j = paramx.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramx[i];
      ListIterator localListIterator = paramList.listIterator();
      while (localListIterator.hasNext()) {
        if (((f)localListIterator.next()).c().equals(((f)localObject).c())) {
          localListIterator.remove();
        }
      }
      i += 1;
    }
  }
  
  private boolean b(d paramd, x paramx)
  {
    paramd = b.a(paramd.a("Date").d());
    paramx = b.a(paramx.getFirstHeader("Date").d());
    if ((paramd == null) || (paramx == null)) {}
    while (!paramd.after(paramx)) {
      return false;
    }
    return true;
  }
  
  private boolean c(d paramd, x paramx)
  {
    return (paramd.a("Date") != null) && (paramx.getFirstHeader("Date") != null);
  }
  
  public d a(String paramString, d paramd, Date paramDate1, Date paramDate2, x paramx)
    throws IOException
  {
    if (paramx.a().b() == 304) {}
    for (boolean bool = true;; bool = false)
    {
      a.a(bool, "Response must have 304 status code");
      f[] arrayOff = a(paramd, paramx);
      paramx = null;
      if (paramd.i() != null) {
        paramx = this.a.a(paramString, paramd.i());
      }
      return new d(paramDate1, paramDate2, paramd.a(), arrayOff, paramx);
    }
  }
  
  protected f[] a(d paramd, x paramx)
  {
    if ((c(paramd, paramx)) && (b(paramd, paramx))) {
      return paramd.g();
    }
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramd.g()));
    a(localArrayList, paramx);
    a(localArrayList, paramd);
    localArrayList.addAll(Arrays.asList(paramx.getAllHeaders()));
    return (f[])localArrayList.toArray(new f[localArrayList.size()]);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */