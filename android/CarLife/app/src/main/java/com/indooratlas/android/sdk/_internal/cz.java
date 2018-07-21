package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cz
{
  public static String a = ee.a(cz.class);
  private static cz c;
  public final ArrayList<db> b = new ArrayList();
  
  private cz(Context paramContext)
  {
    this.b.add(new dm(paramContext));
    this.b.add(new eb(paramContext));
    this.b.add(new dg(paramContext));
    this.b.add(new dr(paramContext));
  }
  
  public static cz a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new cz(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(@NonNull String paramString)
  {
    a = eg.a(paramString, "log tag must be non null", new Object[0]);
  }
  
  private db b(cw paramcw)
  {
    ArrayList localArrayList = this.b;
    Object localObject = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          db localdb = (db)localIterator.next();
          if (localdb.a(paramcw.a()) != null) {
            localObject = localdb;
          }
        }
        else
        {
          return (db)localObject;
        }
      }
      finally {}
    }
  }
  
  private db c(cw paramcw)
  {
    return (db)eg.a(b(paramcw), "no provider found for sensor: " + paramcw, new Object[0]);
  }
  
  public final cw a(int paramInt)
  {
    ArrayList localArrayList = this.b;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          cw localcw = ((db)localIterator.next()).a(paramInt);
          if (localcw != null) {
            localObject1 = localcw;
          }
        }
        else
        {
          return (cw)localObject1;
        }
      }
      finally {}
    }
  }
  
  public final List<cw> a()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        localArrayList2.addAll(((db)localIterator.next()).a());
      }
    }
    return localList;
  }
  
  @NonNull
  public final List<cx> a(cw paramcw)
  {
    List localList = c(paramcw).a(paramcw);
    paramcw = localList;
    if (localList == null) {
      paramcw = new ArrayList(0);
    }
    return paramcw;
  }
  
  public final void a(@NonNull cy paramcy, @NonNull cw paramcw)
  {
    c(paramcw).a(paramcy, paramcw);
  }
  
  public final void a(@NonNull cy paramcy, @NonNull cw paramcw, @NonNull da paramda)
  {
    c(paramcw).a(paramcy, paramcw, paramda);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */