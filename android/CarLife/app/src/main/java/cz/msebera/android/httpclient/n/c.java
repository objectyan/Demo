package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@NotThreadSafe
final class c<E>
{
  private final LinkedList<E> a = new LinkedList();
  private final Map<Class<?>, E> b = new HashMap();
  
  private void c(E paramE)
  {
    Object localObject = this.b.remove(paramE.getClass());
    if (localObject != null) {
      this.a.remove(localObject);
    }
    this.b.put(paramE.getClass(), paramE);
  }
  
  public c<E> a(E paramE)
  {
    if (paramE == null) {
      return this;
    }
    c(paramE);
    this.a.addFirst(paramE);
    return this;
  }
  
  public c<E> a(Collection<E> paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return this;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next());
      }
    }
  }
  
  public c<E> a(E... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return this;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        a(paramVarArgs[i]);
        i += 1;
      }
    }
  }
  
  public LinkedList<E> a()
  {
    return new LinkedList(this.a);
  }
  
  public c<E> b(E paramE)
  {
    if (paramE == null) {
      return this;
    }
    c(paramE);
    this.a.addLast(paramE);
    return this;
  }
  
  public c<E> b(Collection<E> paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return this;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        b(paramCollection.next());
      }
    }
  }
  
  public c<E> b(E... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return this;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        b(paramVarArgs[i]);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */