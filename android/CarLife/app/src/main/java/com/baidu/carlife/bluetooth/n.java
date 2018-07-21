package com.baidu.carlife.bluetooth;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class n
{
  public static final boolean A = true;
  public static final boolean B = false;
  private static final String a = "StateMachine";
  public static final int y = -1;
  public static final int z = -2;
  private String b;
  private c c;
  private HandlerThread d;
  
  protected n(String paramString)
  {
    this.d = new HandlerThread(paramString);
    this.d.start();
    a(paramString, this.d.getLooper());
  }
  
  protected n(String paramString, Looper paramLooper)
  {
    a(paramString, paramLooper);
  }
  
  private void a(String paramString, Looper paramLooper)
  {
    this.b = paramString;
    this.c = new c(paramLooper, this, null);
  }
  
  public final void A()
  {
    if (this.c == null) {
      return;
    }
    c.h(this.c);
  }
  
  public boolean B()
  {
    if (this.c == null) {
      return false;
    }
    return c.i(this.c);
  }
  
  public void C()
  {
    if (this.c == null) {
      return;
    }
    c.j(this.c);
  }
  
  public final Message a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.c == null) {
      return null;
    }
    return Message.obtain(this.c, paramInt1, paramInt2, paramInt3);
  }
  
  public final Message a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (this.c == null) {
      return null;
    }
    return Message.obtain(this.c, paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public final Message a(int paramInt, Object paramObject)
  {
    if (this.c == null) {
      return null;
    }
    return Message.obtain(this.c, paramInt, paramObject);
  }
  
  public final void a(int paramInt)
  {
    c.a(this.c, paramInt);
  }
  
  public final void a(int paramInt, long paramLong)
  {
    if (this.c == null) {
      return;
    }
    this.c.sendMessageDelayed(c(paramInt), paramLong);
  }
  
  public final void a(int paramInt, Object paramObject, long paramLong)
  {
    if (this.c == null) {
      return;
    }
    this.c.sendMessageDelayed(a(paramInt, paramObject), paramLong);
  }
  
  protected final void a(Message paramMessage)
  {
    c.a(this.c, paramMessage);
  }
  
  public final void a(Message paramMessage, long paramLong)
  {
    if (this.c == null) {
      return;
    }
    this.c.sendMessageDelayed(paramMessage, paramLong);
  }
  
  protected final void a(k paramk)
  {
    c.a(this.c, paramk);
  }
  
  protected final void a(m paramm)
  {
    c.a(this.c, paramm, null);
  }
  
  protected final void a(m paramm1, m paramm2)
  {
    c.a(this.c, paramm1, paramm2);
  }
  
  public void a(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.println(v() + ":");
    paramPrintWriter.println(" total messages=" + x());
    int i = 0;
    while (i < w())
    {
      paramPrintWriter.printf(" msg[%d]: %s\n", new Object[] { Integer.valueOf(i), b(i) });
      paramPrintWriter.flush();
      i += 1;
    }
    paramPrintWriter.println("curState=" + s().c());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c == null) {
      return;
    }
    c.a(this.c, paramBoolean);
  }
  
  public final a b(int paramInt)
  {
    return c.b(this.c, paramInt);
  }
  
  public final void b(int paramInt, Object paramObject)
  {
    if (this.c == null) {
      return;
    }
    this.c.sendMessage(a(paramInt, paramObject));
  }
  
  protected void b(Message paramMessage)
  {
    if (c.e(this.c)) {
      Log.e("StateMachine", this.b + " - unhandledMessage: msg.what=" + paramMessage.what);
    }
  }
  
  protected final void b(m paramm)
  {
    c.a(this.c, paramm);
  }
  
  public final Message c(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return Message.obtain(this.c, paramInt);
  }
  
  protected final void c(int paramInt, Object paramObject)
  {
    this.c.sendMessageAtFrontOfQueue(a(paramInt, paramObject));
  }
  
  protected void c(Message paramMessage) {}
  
  public final void d(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    this.c.sendMessage(c(paramInt));
  }
  
  public final void d(Message paramMessage)
  {
    if (this.c == null) {
      return;
    }
    this.c.sendMessage(paramMessage);
  }
  
  protected final void e(int paramInt)
  {
    this.c.sendMessageAtFrontOfQueue(c(paramInt));
  }
  
  protected final void e(Message paramMessage)
  {
    this.c.sendMessageAtFrontOfQueue(paramMessage);
  }
  
  protected final void f(int paramInt)
  {
    this.c.removeMessages(paramInt);
  }
  
  protected final boolean f(Message paramMessage)
  {
    return c.b(this.c, paramMessage);
  }
  
  protected void g() {}
  
  protected boolean g(Message paramMessage)
  {
    return true;
  }
  
  protected String h(Message paramMessage)
  {
    return "";
  }
  
  protected final Message r()
  {
    return c.b(this.c);
  }
  
  protected final k s()
  {
    return c.c(this.c);
  }
  
  protected final void t()
  {
    c.a(this.c, c.d(this.c));
  }
  
  protected void u() {}
  
  public final String v()
  {
    return this.b;
  }
  
  public final int w()
  {
    return c.f(this.c);
  }
  
  public final int x()
  {
    return c.g(this.c);
  }
  
  public final Handler y()
  {
    return this.c;
  }
  
  public final Message z()
  {
    if (this.c == null) {
      return null;
    }
    return Message.obtain(this.c);
  }
  
  public static class a
  {
    private long a;
    private int b;
    private String c;
    private m d;
    private m e;
    
    a(Message paramMessage, String paramString, m paramm1, m paramm2)
    {
      a(paramMessage, paramString, paramm1, paramm2);
    }
    
    public long a()
    {
      return this.a;
    }
    
    public void a(Message paramMessage, String paramString, m paramm1, m paramm2)
    {
      this.a = System.currentTimeMillis();
      this.b = paramMessage.what;
      this.c = paramString;
      this.d = paramm1;
      this.e = paramm2;
    }
    
    public long b()
    {
      return this.b;
    }
    
    public String c()
    {
      return this.c;
    }
    
    public m d()
    {
      return this.d;
    }
    
    public m e()
    {
      return this.e;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time=");
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(this.a);
      localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
      localStringBuilder.append(" state=");
      if (this.d == null)
      {
        localObject = "<null>";
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" orgState=");
        if (this.e != null) {
          break label196;
        }
      }
      label196:
      for (localObject = "<null>";; localObject = this.e.c())
      {
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" what=");
        localStringBuilder.append(this.b);
        localStringBuilder.append("(0x");
        localStringBuilder.append(Integer.toHexString(this.b));
        localStringBuilder.append(")");
        if (!TextUtils.isEmpty(this.c))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(this.c);
        }
        return localStringBuilder.toString();
        localObject = this.d.c();
        break;
      }
    }
  }
  
  private static class b
  {
    private static final int a = 20;
    private Vector<n.a> b = new Vector();
    private int c = 20;
    private int d = 0;
    private int e = 0;
    
    int a()
    {
      return this.b.size();
    }
    
    void a(int paramInt)
    {
      this.c = paramInt;
      this.e = 0;
      this.b.clear();
    }
    
    void a(Message paramMessage, String paramString, m paramm1, m paramm2)
    {
      this.e += 1;
      if (this.b.size() < this.c)
      {
        this.b.add(new n.a(paramMessage, paramString, paramm1, paramm2));
        return;
      }
      n.a locala = (n.a)this.b.get(this.d);
      this.d += 1;
      if (this.d >= this.c) {
        this.d = 0;
      }
      locala.a(paramMessage, paramString, paramm1, paramm2);
    }
    
    int b()
    {
      return this.e;
    }
    
    n.a b(int paramInt)
    {
      int i = this.d + paramInt;
      paramInt = i;
      if (i >= this.c) {
        paramInt = i - this.c;
      }
      if (paramInt >= a()) {
        return null;
      }
      return (n.a)this.b.get(paramInt);
    }
    
    void c()
    {
      this.b.clear();
    }
  }
  
  private static class c
    extends Handler
  {
    private static final Object b = new Object();
    private boolean a = false;
    private Message c;
    private n.b d = new n.b(null);
    private boolean e;
    private c[] f;
    private int g = -1;
    private c[] h;
    private int i;
    private a j = new a(null);
    private b k = new b(null);
    private n l;
    private HashMap<m, c> m = new HashMap();
    private m n;
    private m o;
    private ArrayList<Message> p = new ArrayList();
    
    private c(Looper paramLooper, n paramn)
    {
      super();
      this.l = paramn;
      a(this.j, null);
      a(this.k, null);
    }
    
    private final c a(m paramm)
    {
      this.i = 0;
      paramm = (c)this.m.get(paramm);
      Object localObject;
      do
      {
        localObject = this.h;
        int i1 = this.i;
        this.i = (i1 + 1);
        localObject[i1] = paramm;
        localObject = paramm.b;
        if (localObject == null) {
          break;
        }
        paramm = (m)localObject;
      } while (!((c)localObject).c);
      if (this.a) {
        Log.d("StateMachine", "setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.i + ",curStateInfo: " + localObject);
      }
      return (c)localObject;
    }
    
    private final c a(m paramm1, m paramm2)
    {
      Object localObject2;
      if (this.a)
      {
        localObject2 = new StringBuilder().append("addStateInternal: E state=").append(paramm1.c()).append(",parent=");
        if (paramm2 != null) {
          break label155;
        }
      }
      label155:
      for (Object localObject1 = "";; localObject1 = paramm2.c())
      {
        Log.d("StateMachine", (String)localObject1);
        localObject1 = null;
        if (paramm2 != null)
        {
          localObject2 = (c)this.m.get(paramm2);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = a(paramm2, null);
          }
        }
        localObject2 = (c)this.m.get(paramm1);
        paramm2 = (m)localObject2;
        if (localObject2 == null)
        {
          paramm2 = new c(null);
          this.m.put(paramm1, paramm2);
        }
        if ((paramm2.b == null) || (paramm2.b == localObject1)) {
          break;
        }
        throw new RuntimeException("state already added");
      }
      paramm2.a = paramm1;
      paramm2.b = ((c)localObject1);
      paramm2.c = false;
      if (this.a) {
        Log.d("StateMachine", "addStateInternal: X stateInfo: " + paramm2);
      }
      return paramm2;
    }
    
    private void a()
    {
      m localm = null;
      while (this.o != null)
      {
        if (this.a) {
          Log.d("StateMachine", "handleMessage: new destination call exit");
        }
        localm = this.o;
        this.o = null;
        a(a(localm));
        a(e());
        d();
      }
      if (localm != null)
      {
        if (localm != this.k) {
          break label75;
        }
        b();
      }
      label75:
      while (localm != this.j) {
        return;
      }
      this.l.g();
    }
    
    private final void a(int paramInt)
    {
      while (paramInt <= this.g)
      {
        if (this.a) {
          Log.d("StateMachine", "invokeEnterMethods: " + this.f[paramInt].a.c());
        }
        this.f[paramInt].a.a();
        this.f[paramInt].c = true;
        paramInt += 1;
      }
    }
    
    private final void a(Message paramMessage)
    {
      Object localObject2 = this.f[this.g];
      Object localObject1 = localObject2;
      if (this.a)
      {
        Log.d("StateMachine", "processMsg: " + ((c)localObject2).a.c());
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject2 = localObject1;
        c localc;
        if (!((c)localObject1).a.a(paramMessage))
        {
          localc = ((c)localObject1).b;
          if (localc != null) {
            break label156;
          }
          this.l.b(paramMessage);
          localObject2 = localc;
          if (c(paramMessage))
          {
            a(this.k);
            localObject2 = localc;
          }
        }
        if (this.l.g(paramMessage))
        {
          if (localObject2 == null) {
            break;
          }
          localObject1 = this.f[this.g].a;
          this.d.a(paramMessage, this.l.h(paramMessage), ((c)localObject2).a, (m)localObject1);
        }
        return;
        label156:
        localObject1 = localc;
        if (this.a)
        {
          Log.d("StateMachine", "processMsg: " + localc.a.c());
          localObject1 = localc;
        }
      }
      this.d.a(paramMessage, this.l.h(paramMessage), null, null);
    }
    
    private final void a(k paramk)
    {
      this.o = ((m)paramk);
      if (this.a) {
        Log.d("StateMachine", "transitionTo: destState=" + this.o.c());
      }
    }
    
    private final void a(c paramc)
    {
      while ((this.g >= 0) && (this.f[this.g] != paramc))
      {
        m localm = this.f[this.g].a;
        if (this.a) {
          Log.d("StateMachine", "invokeExitMethods: " + localm.c());
        }
        localm.b();
        this.f[this.g].c = false;
        this.g -= 1;
      }
    }
    
    private final void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    private final void b()
    {
      this.l.u();
      if (n.a(this.l) != null)
      {
        getLooper().quit();
        n.a(this.l, null);
      }
      n.a(this.l, null);
      this.l = null;
      this.c = null;
      this.d.c();
      this.f = null;
      this.h = null;
      this.m.clear();
      this.n = null;
      this.o = null;
      this.p.clear();
    }
    
    private final void b(int paramInt)
    {
      this.d.a(paramInt);
    }
    
    private final void b(Message paramMessage)
    {
      if (this.a) {
        Log.d("StateMachine", "deferMessage: msg=" + paramMessage.what);
      }
      Message localMessage = obtainMessage();
      localMessage.copyFrom(paramMessage);
      this.p.add(localMessage);
    }
    
    private final void b(m paramm)
    {
      if (this.a) {
        Log.d("StateMachine", "setInitialState: initialState=" + paramm.c());
      }
      this.n = paramm;
    }
    
    private final n.a c(int paramInt)
    {
      return this.d.b(paramInt);
    }
    
    private final void c()
    {
      if (this.a) {
        Log.d("StateMachine", "completeConstruction: E");
      }
      int i2 = 0;
      Iterator localIterator = this.m.values().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        int i1 = 0;
        while (localc != null)
        {
          localc = localc.b;
          i1 += 1;
        }
        if (i2 < i1) {
          i2 = i1;
        }
      }
      if (this.a) {
        Log.d("StateMachine", "completeConstruction: maxDepth=" + i2);
      }
      this.f = new c[i2];
      this.h = new c[i2];
      f();
      sendMessageAtFrontOfQueue(obtainMessage(-2, b));
      if (this.a) {
        Log.d("StateMachine", "completeConstruction: X");
      }
    }
    
    private final boolean c(Message paramMessage)
    {
      return (paramMessage.what == -1) && (paramMessage.obj == b);
    }
    
    private final void d()
    {
      int i1 = this.p.size() - 1;
      while (i1 >= 0)
      {
        Message localMessage = (Message)this.p.get(i1);
        if (this.a) {
          Log.d("StateMachine", "moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
        }
        sendMessageAtFrontOfQueue(localMessage);
        i1 -= 1;
      }
      this.p.clear();
    }
    
    private final int e()
    {
      int i3 = this.g + 1;
      int i1 = this.i - 1;
      int i2 = i3;
      while (i1 >= 0)
      {
        if (this.a) {
          Log.d("StateMachine", "moveTempStackToStateStack: i=" + i1 + ",j=" + i2);
        }
        this.f[i2] = this.h[i1];
        i2 += 1;
        i1 -= 1;
      }
      this.g = (i2 - 1);
      if (this.a) {
        Log.d("StateMachine", "moveTempStackToStateStack: X mStateStackTop=" + this.g + ",startingIndex=" + i3 + ",Top=" + this.f[this.g].a.c());
      }
      return i3;
    }
    
    private final void f()
    {
      if (this.a) {
        Log.d("StateMachine", "setupInitialStateStack: E mInitialState=" + this.n.c());
      }
      c localc = (c)this.m.get(this.n);
      for (this.i = 0; localc != null; this.i += 1)
      {
        this.h[this.i] = localc;
        localc = localc.b;
      }
      this.g = -1;
      e();
    }
    
    private final Message g()
    {
      return this.c;
    }
    
    private final k h()
    {
      return this.f[this.g].a;
    }
    
    private final void i()
    {
      if (this.a) {
        Log.d("StateMachine", "quit:");
      }
      sendMessage(obtainMessage(-1, b));
    }
    
    private final boolean j()
    {
      return this.a;
    }
    
    private final int k()
    {
      return this.d.a();
    }
    
    private final int l()
    {
      return this.d.b();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (this.a) {
        Log.d("StateMachine", "handleMessage: E msg.what=" + paramMessage.what);
      }
      this.c = paramMessage;
      if (this.e) {
        a(paramMessage);
      }
      for (;;)
      {
        a();
        if (this.a) {
          Log.d("StateMachine", "handleMessage: X");
        }
        return;
        if ((this.e) || (this.c.what != -2) || (this.c.obj != b)) {
          break;
        }
        this.e = true;
        a(0);
      }
      throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + paramMessage);
    }
    
    private class a
      extends m
    {
      private a() {}
      
      public boolean a(Message paramMessage)
      {
        n.this.c(paramMessage);
        return true;
      }
    }
    
    private class b
      extends m
    {
      private b() {}
      
      public boolean a(Message paramMessage)
      {
        return false;
      }
    }
    
    private class c
    {
      m a;
      c b;
      boolean c;
      
      private c() {}
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder().append("state=").append(this.a.c()).append(",active=").append(this.c).append(",parent=");
        if (this.b == null) {}
        for (String str = "null";; str = this.b.a.c()) {
          return str;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */