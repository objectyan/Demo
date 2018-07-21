package com.indooratlas.android.sdk._internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;

public final class dw
{
  private final SparseArray<ArrayList<dv>> a = new SparseArray();
  
  private int b(int paramInt)
  {
    synchronized (this.a)
    {
      ArrayList localArrayList = (ArrayList)this.a.get(paramInt);
      if (localArrayList != null)
      {
        paramInt = localArrayList.size();
        return paramInt;
      }
      return 0;
    }
  }
  
  public final int a(int paramInt)
  {
    Object localObject = (ArrayList)this.a.get(paramInt);
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      i = -1;
      if (((Iterator)localObject).hasNext())
      {
        j = ((dv)((Iterator)localObject).next()).c.c;
        if (j == 0) {
          paramInt = 5000;
        }
        for (;;)
        {
          j = paramInt;
          if (i != -1)
          {
            if (paramInt >= i) {
              break label125;
            }
            j = paramInt;
          }
          i = j;
          break;
          if (j == 1)
          {
            paramInt = 20000;
          }
          else if (j == 2)
          {
            paramInt = 60000;
          }
          else
          {
            paramInt = j;
            if (j == 3) {
              paramInt = 200000;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        return i;
      }
      return 0;
      label125:
      j = i;
      break;
      i = -1;
    }
  }
  
  public final int a(cw paramcw)
  {
    synchronized (this.a)
    {
      int i = b(paramcw.a());
      return i;
    }
  }
  
  @Nullable
  public final dv a(@NonNull cy paramcy, @NonNull cw paramcw, @NonNull da paramda)
  {
    eg.a(paramcy, "listener cannot be null", new Object[0]);
    eg.a(paramcw, "sensor cannot be null", new Object[0]);
    eg.a(paramda, "params cannot be null", new Object[0]);
    for (;;)
    {
      synchronized (this.a)
      {
        ArrayList localArrayList = (ArrayList)this.a.get(paramcw.a());
        if (localArrayList == null)
        {
          localArrayList = new ArrayList(1);
          this.a.append(paramcw.a(), localArrayList);
          paramcy = new dv(paramcy, paramcw, paramda);
          localArrayList.add(paramcy);
          return paramcy;
        }
        Iterator localIterator = localArrayList.iterator();
        if (localIterator.hasNext()) {
          if (((dv)localIterator.next()).a == paramcy) {
            return null;
          }
        }
      }
    }
  }
  
  @NonNull
  public final ArrayList<dv> a(@NonNull cy paramcy)
  {
    eg.a(paramcy, "listener cannot be null", new Object[0]);
    ArrayList localArrayList1 = new ArrayList(1);
    SparseArray localSparseArray = this.a;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.a.size())
        {
          ArrayList localArrayList2 = (ArrayList)this.a.valueAt(i);
          Iterator localIterator = localArrayList2.iterator();
          if (localIterator.hasNext())
          {
            dv localdv = (dv)localIterator.next();
            if (localdv.a != paramcy) {
              continue;
            }
            localArrayList2.remove(localdv);
            localArrayList1.add(localdv);
          }
        }
        else
        {
          return localArrayList1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  @NonNull
  public final ArrayList<dv> a(@NonNull cy paramcy, @NonNull cw paramcw)
  {
    eg.a(paramcy, "listener cannot be null", new Object[0]);
    eg.a(paramcw, "sensor cannot be null", new Object[0]);
    ArrayList localArrayList = new ArrayList(1);
    synchronized (this.a)
    {
      paramcw = (ArrayList)this.a.get(paramcw.a());
      if (paramcw != null)
      {
        Iterator localIterator = paramcw.iterator();
        while (localIterator.hasNext())
        {
          dv localdv = (dv)localIterator.next();
          if (localdv.a == paramcy)
          {
            paramcw.remove(localdv);
            localArrayList.add(localdv);
            return localArrayList;
          }
        }
      }
      return localArrayList;
    }
  }
  
  public final void a(int paramInt, @NonNull cx paramcx)
  {
    eg.a(paramcx, "Sensor event cannot be null.", new Object[0]);
    synchronized (this.a)
    {
      Object localObject = (ArrayList)this.a.get(paramInt);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        if (((Iterator)localObject).hasNext()) {
          ((dv)((Iterator)localObject).next()).a(paramcx);
        }
      }
    }
  }
  
  public final void a(cx paramcx)
  {
    eg.a(paramcx, "Sensor event cannot be null.", new Object[0]);
    a(paramcx.a.a(), paramcx);
  }
  
  public final int b(cw paramcw)
  {
    return a(paramcw.a());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */