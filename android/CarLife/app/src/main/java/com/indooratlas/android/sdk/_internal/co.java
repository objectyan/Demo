package com.indooratlas.android.sdk._internal;

import android.support.annotation.NonNull;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;
import com.indooratlas.android.sdk.IARegion;
import java.util.Collection;
import java.util.Comparator;

public final class co
{
  public static Comparator<a> g = new Comparator() {};
  public fc.c a = null;
  public IARegion b = null;
  public IARegion c = null;
  public IARegion d = null;
  public IARegion e = null;
  public IALocation f = null;
  private final bi h;
  
  public co(@NonNull bi parambi)
  {
    eg.a(parambi, "listener cannot be null", new Object[0]);
    this.h = parambi;
  }
  
  public static void a(IARegion paramIARegion1, IARegion paramIARegion2, Collection<a> paramCollection, boolean paramBoolean)
  {
    if (paramIARegion1 == null) {
      if (paramIARegion2 != null) {
        paramCollection.add(new a(paramBoolean, paramIARegion2));
      }
    }
    do
    {
      return;
      if (paramIARegion2 == null)
      {
        paramCollection.add(new a(paramBoolean, null));
        return;
      }
    } while (paramIARegion1.equals(paramIARegion2));
    paramCollection.add(new a(paramBoolean, null));
    paramCollection.add(new a(paramBoolean, paramIARegion2));
  }
  
  public final void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    float f1 = (float)paramDouble4;
    Object localObject1;
    if (this.e != null) {
      localObject1 = this.e;
    }
    for (;;)
    {
      Object localObject2 = this.a;
      long l = System.currentTimeMillis();
      localObject1 = new IALocation.Builder("IndoorAtlas").withLatitude(paramDouble1).withLongitude(paramDouble2).withAccuracy(f1).withRegion((IARegion)localObject1).withTime(l);
      if (paramDouble3 != 0.0D) {
        ((IALocation.Builder)localObject1).withBearing((float)paramDouble3);
      }
      if (cp.a((fc.c)localObject2))
      {
        localObject2 = ((fc.c)localObject2).b.b;
        if (((ex.a)localObject2).g != null) {
          ((IALocation.Builder)localObject1).withFloorLevel(((ex.a)localObject2).g.b);
        }
        if (((ex.a)localObject2).l != null) {
          ((IALocation.Builder)localObject1).withFloorCertainty(((ex.a)localObject2).l.b);
        }
        if (((ex.a)localObject2).f != null) {
          ((IALocation.Builder)localObject1).withAltitude(((ex.a)localObject2).f.b);
        }
      }
      localObject1 = ((IALocation.Builder)localObject1).build();
      this.f = ((IALocation)localObject1);
      this.h.a((IALocation)localObject1);
      return;
      if (this.d != null) {
        localObject1 = this.d;
      } else {
        localObject1 = null;
      }
    }
  }
  
  public static final class a
  {
    public boolean a;
    public IARegion b;
    final int c;
    
    a(boolean paramBoolean, IARegion paramIARegion)
    {
      this.a = paramBoolean;
      this.b = paramIARegion;
      if (this.b == null)
      {
        if (!this.a)
        {
          this.c = 1;
          return;
        }
        this.c = 2;
        return;
      }
      if (this.a)
      {
        this.c = 3;
        return;
      }
      this.c = 4;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */