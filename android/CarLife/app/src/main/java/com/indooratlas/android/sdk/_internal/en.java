package com.indooratlas.android.sdk._internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class en<K, V>
{
  public HashMap<et, Collection<a<V>>> a = new HashMap();
  public HashMap<K, Collection<a<V>>> b = new HashMap();
  
  private static Collection<et> a(em paramem)
  {
    Object localObject2 = paramem.a.b;
    paramem = null;
    int i = 19;
    while (i >= 15)
    {
      localObject1 = new es.a((er)localObject2, i);
      paramem = (em)localObject1;
      if ((((es.a)localObject1).b - ((es.a)localObject1).a + 1) * (((es.a)localObject1).d - ((es.a)localObject1).c + 1) <= 4L) {
        break;
      }
      i -= 1;
      paramem = (em)localObject1;
    }
    Object localObject1 = new ArrayList();
    i = paramem.a;
    while (i < paramem.b + 1)
    {
      int j = paramem.c;
      while (j < paramem.d + 1)
      {
        localObject2 = new et((paramem.f + i) % paramem.f, j, paramem.e);
        if (!((ArrayList)localObject1).contains(localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
        j += 1;
      }
      i += 1;
    }
    return (Collection<et>)localObject1;
  }
  
  public final Collection<V> a(ep paramep)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 15;
    while (i <= 19)
    {
      Object localObject = et.a(paramep.a, paramep.b, i);
      localObject = (Collection)this.a.get(localObject);
      if (localObject != null)
      {
        localObject = ((Collection)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          if (locala.a.a(paramep)) {
            localArrayList.add(locala.b);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public final void a(K paramK, em paramem, V paramV)
  {
    a locala = new a(paramem, paramV);
    Iterator localIterator = a(paramem).iterator();
    while (localIterator.hasNext())
    {
      et localet = (et)localIterator.next();
      paramV = (Collection)this.a.get(localet);
      paramem = paramV;
      if (paramV == null)
      {
        paramem = new ArrayList();
        this.a.put(localet, paramem);
      }
      paramem.add(locala);
    }
    paramV = (Collection)this.b.get(paramK);
    paramem = paramV;
    if (paramV == null)
    {
      paramem = new ArrayList();
      this.b.put(paramK, paramem);
    }
    paramem.add(locala);
  }
  
  public final boolean a(K paramK)
  {
    paramK = (Collection)this.b.remove(paramK);
    if (paramK == null) {
      return false;
    }
    paramK = paramK.iterator();
    while (paramK.hasNext())
    {
      a locala = (a)paramK.next();
      Iterator localIterator = a(locala.a).iterator();
      while (localIterator.hasNext())
      {
        et localet = (et)localIterator.next();
        Collection localCollection = (Collection)this.a.get(localet);
        localCollection.remove(locala);
        if (localCollection.isEmpty()) {
          this.a.remove(localet);
        }
      }
    }
    return true;
  }
  
  public static final class a<V>
  {
    final em a;
    final V b;
    
    public a(em paramem, V paramV)
    {
      this.a = paramem;
      this.b = paramV;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */