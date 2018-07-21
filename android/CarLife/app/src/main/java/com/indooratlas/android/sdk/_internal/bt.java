package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk.IALocation;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bt
  implements bs.a, bx.a
{
  public static final boolean a = false;
  public static final o b = new o();
  private static final boolean m = false;
  public int c;
  public int d = 0;
  public long e;
  public long f;
  public int g;
  public long h;
  public cr i;
  public int j = 0;
  public br.a k;
  public br.a l;
  private bx n;
  private a o;
  private int p;
  private bs q;
  
  public bt(cr paramcr, a parama)
  {
    this.o = parama;
    this.i = paramcr;
    this.h = this.i.a();
  }
  
  public static long a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong1 > paramLong2)) {
      ee.a("IAWire", String.format(Locale.US, "trackNode clientTime traveling backwards, lastSeen: %d, current: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }), new Object[0]);
    }
    return paramLong2;
  }
  
  public static fg.e a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = (fg.e)m.a(new fg.e(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (j paramArrayOfByte) {}
    return null;
  }
  
  private void b(el.a parama)
  {
    try
    {
      if (this.k != null) {
        this.k.a();
      }
      this.n.a(m.a(parama));
      this.p += 1;
      return;
    }
    catch (Throwable parama)
    {
      ee.a("IAWire", parama, "error sending, message lost", new Object[0]);
    }
  }
  
  public final void a()
  {
    b();
    Iterator localIterator = this.q.c.iterator();
    while (localIterator.hasNext()) {
      b((el.a)localIterator.next());
    }
    this.q.c.clear();
  }
  
  public final void a(int paramInt)
  {
    this.o.a(paramInt);
  }
  
  public final void a(int paramInt, m paramm)
  {
    el.a locala = new el.a();
    locala.b = 1;
    locala.d = paramInt;
    locala.e = m.a(paramm);
    if (ee.a("IAWire", 2))
    {
      double d1 = (this.i.a() - this.h) / 1000.0D;
      cp.a(locala.b);
      cp.a(locala.b, locala.d);
      paramInt = locala.e.length;
      paramInt = this.c;
      paramInt = this.d;
      paramInt = this.j;
      paramInt = this.p;
      double d2 = this.p / d1;
      paramInt = this.g;
      d1 = this.g / d1;
    }
    paramm = b();
    if ((paramm.d) && (paramm.b > 0))
    {
      paramm.c.size();
      paramInt = paramm.b;
      paramm.c.add(locala);
      if (paramm.c.size() > paramm.b)
      {
        paramm.a.a();
        if (!paramm.c.isEmpty()) {
          paramm.c.remove(0);
        }
      }
      return;
    }
    boolean bool = paramm.d;
    cp.a(locala.b);
    cp.a(locala.b, locala.d);
    paramm.a.a(locala);
  }
  
  public final void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.o.a(paramInt, paramString, paramBoolean);
  }
  
  public final void a(bx parambx)
  {
    this.n = parambx;
    this.n.a(this);
  }
  
  public final void a(el.a parama)
  {
    b(parama);
  }
  
  public final void a(ByteBuffer paramByteBuffer)
  {
    this.g += 1;
    int i2;
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramByteBuffer.array();
        localObject = (el.a)m.a(new el.a(), (byte[])localObject, localObject.length);
        if (this.l != null) {
          this.l.a();
        }
        int i1 = ((el.a)localObject).b;
        i2 = ((el.a)localObject).d;
        cp.a(i1);
        cp.a(i1, i2);
        paramByteBuffer.capacity();
        switch (i1)
        {
        default: 
          ee.a("IAWire", "unhandled message, component: %d, type: %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
          return;
        }
      }
      catch (j paramByteBuffer)
      {
        ee.a("IAWire", paramByteBuffer, "parsing message failed", new Object[0]);
        return;
      }
      paramByteBuffer = ((el.a)localObject).e;
      paramByteBuffer = (ez.a)m.a(new ez.a(), paramByteBuffer, paramByteBuffer.length);
      this.c = paramByteBuffer.b;
      this.o.a(paramByteBuffer);
      return;
      paramByteBuffer = ((el.a)localObject).e;
      paramByteBuffer = (fa.a)m.a(new fa.a(), paramByteBuffer, paramByteBuffer.length);
      this.o.a(paramByteBuffer);
      return;
      paramByteBuffer = ((el.a)localObject).e;
      paramByteBuffer = (fc.c)m.a(new fc.c(), paramByteBuffer, paramByteBuffer.length);
      this.o.a(paramByteBuffer);
      return;
      paramByteBuffer = ((el.a)localObject).e;
      paramByteBuffer = (eu.c)m.a(new eu.c(), paramByteBuffer, paramByteBuffer.length);
      this.o.a(paramByteBuffer);
      return;
      paramByteBuffer = ((el.a)localObject).e;
      m.a(new fm.a(), paramByteBuffer, paramByteBuffer.length);
      return;
    }
    return;
    switch (i2)
    {
    }
    return;
    switch (i2)
    {
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    bs localbs = b();
    localbs.d = paramBoolean;
    if ((!localbs.d) && (!localbs.c.isEmpty())) {
      localbs.a.a();
    }
  }
  
  public final void a(IALocation... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    try
    {
      fb.c localc = e();
      fb.b localb = new fb.b();
      IALocation localIALocation = paramVarArgs[0];
      if (localIALocation.getRegion() != null) {
        localb.d = cp.a(localIALocation.getRegion());
      }
      localb.b = cp.a(paramVarArgs);
      localc.d = localb;
      a(2, localc);
      return;
    }
    catch (Throwable paramVarArgs) {}
  }
  
  public final bs b()
  {
    if (this.q == null) {
      this.q = new bs(this);
    }
    return this.q;
  }
  
  public final void c()
  {
    this.o.b();
  }
  
  public final void d()
  {
    this.o.a();
  }
  
  public final fb.c e()
  {
    fb.c localc = new fb.c();
    int i1 = this.j;
    this.j = (i1 + 1);
    localc.j = i1;
    localc.b = this.c;
    return localc;
  }
  
  public static abstract class a
  {
    public void a() {}
    
    public abstract void a(int paramInt, String paramString, boolean paramBoolean);
    
    public abstract void a(long paramLong);
    
    public abstract void a(eu.c paramc);
    
    public void a(ez.a parama)
    {
      if ((parama.d != null) && (parama.d.b != null))
      {
        Iterator localIterator = parama.d.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          parama = (Map.Entry)localIterator.next();
          parama.getKey();
          parama = (r)parama.getValue();
          if (parama.b == 3) {}
          for (parama = (String)parama.d;; parama = "") {
            break;
          }
        }
      }
    }
    
    public abstract void a(fa.a parama);
    
    public abstract void a(fc.c paramc);
    
    public abstract void b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */