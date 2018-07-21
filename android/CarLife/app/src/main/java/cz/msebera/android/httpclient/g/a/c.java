package cz.msebera.android.httpclient.g.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class c
  implements Iterable<i>
{
  private final List<i> a = new LinkedList();
  private final Map<String, List<i>> b = new HashMap();
  
  public i a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.toLowerCase(Locale.ENGLISH);
      paramString = (List)this.b.get(paramString);
    } while ((paramString == null) || (paramString.isEmpty()));
    return (i)paramString.get(0);
  }
  
  public List<i> a()
  {
    return new ArrayList(this.a);
  }
  
  public void a(i parami)
  {
    if (parami == null) {
      return;
    }
    String str = parami.a().toLowerCase(Locale.ENGLISH);
    List localList = (List)this.b.get(str);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.b.put(str, localObject);
    }
    ((List)localObject).add(parami);
    this.a.add(parami);
  }
  
  public List<i> b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.ENGLISH);
    paramString = (List)this.b.get(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return Collections.emptyList();
    }
    return new ArrayList(paramString);
  }
  
  public void b(i parami)
  {
    if (parami == null) {
      return;
    }
    Object localObject = parami.a().toLowerCase(Locale.ENGLISH);
    localObject = (List)this.b.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      a(parami);
      return;
    }
    ((List)localObject).clear();
    ((List)localObject).add(parami);
    int j = -1;
    int i = 0;
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      int k = j;
      if (((i)((Iterator)localObject).next()).a().equalsIgnoreCase(parami.a()))
      {
        ((Iterator)localObject).remove();
        k = j;
        if (j == -1) {
          k = i;
        }
      }
      i += 1;
      j = k;
    }
    this.a.add(j, parami);
  }
  
  public int c(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      paramString = paramString.toLowerCase(Locale.ENGLISH);
      paramString = (List)this.b.remove(paramString);
    } while ((paramString == null) || (paramString.isEmpty()));
    this.a.removeAll(paramString);
    return paramString.size();
  }
  
  public Iterator<i> iterator()
  {
    return Collections.unmodifiableList(this.a).iterator();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */