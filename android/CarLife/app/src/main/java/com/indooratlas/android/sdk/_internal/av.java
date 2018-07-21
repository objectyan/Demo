package com.indooratlas.android.sdk._internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class av
{
  String a;
  public c b;
  HandlerThread c;
  
  public av(String paramString)
  {
    this.c = new HandlerThread(paramString);
    this.c.start();
    a(paramString, this.c.getLooper());
  }
  
  public av(String paramString, Looper paramLooper)
  {
    a(paramString, paramLooper);
  }
  
  private void a(String paramString, Looper paramLooper)
  {
    this.a = paramString;
    this.b = new c(paramLooper, this, (byte)0);
  }
  
  public final Message a(int paramInt)
  {
    return Message.obtain(this.b, paramInt);
  }
  
  public final Message a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return Message.obtain(this.b, paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public final Message a(int paramInt, Object paramObject)
  {
    return Message.obtain(this.b, paramInt, paramObject);
  }
  
  public void a() {}
  
  public final void a(int paramInt, long paramLong)
  {
    this.b.sendMessageDelayed(a(paramInt), paramLong);
  }
  
  public final void a(at paramat)
  {
    c.a(this.b, paramat);
  }
  
  public final void a(au paramau)
  {
    c.a(this.b, paramau, null);
  }
  
  public final void a(au paramau1, au paramau2)
  {
    c.a(this.b, paramau1, paramau2);
  }
  
  public final void b(int paramInt)
  {
    this.b.sendMessage(a(paramInt));
  }
  
  public final void b(int paramInt, Object paramObject)
  {
    this.b.sendMessage(a(paramInt, paramObject));
  }
  
  public final void c(int paramInt)
  {
    this.b.removeMessages(paramInt);
  }
  
  public static final class a
  {
    private int a;
    private au b;
    private au c;
    
    a(Message paramMessage, au paramau1, au paramau2)
    {
      a(paramMessage, paramau1, paramau2);
    }
    
    private static String a(Object paramObject)
    {
      if (paramObject == null) {
        return "null";
      }
      paramObject = paramObject.getClass().getName();
      return ((String)paramObject).substring(((String)paramObject).lastIndexOf('$') + 1);
    }
    
    public final void a(Message paramMessage, au paramau1, au paramau2)
    {
      this.a = paramMessage.what;
      this.b = paramau1;
      this.c = paramau2;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("what=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" state=");
      localStringBuilder.append(a(this.b));
      localStringBuilder.append(" orgState=");
      localStringBuilder.append(a(this.c));
      return localStringBuilder.toString();
    }
  }
  
  static final class b
  {
    private Vector<av.a> a = new Vector();
    private int b = 20;
    private int c = 0;
    private int d = 0;
    
    final void a(Message paramMessage, au paramau1, au paramau2)
    {
      this.d += 1;
      if (this.a.size() < this.b)
      {
        this.a.add(new av.a(paramMessage, paramau1, paramau2));
        return;
      }
      av.a locala = (av.a)this.a.get(this.c);
      this.c += 1;
      if (this.c >= this.b) {
        this.c = 0;
      }
      locala.a(paramMessage, paramau1, paramau2);
    }
  }
  
  public static final class c
    extends Handler
  {
    private static final Object b = new Object();
    private boolean a = false;
    private Message c;
    private av.b d = new av.b();
    private boolean e;
    private c[] f;
    private int g = -1;
    private c[] h;
    private int i;
    private a j = new a((byte)0);
    private b k = new b((byte)0);
    private av l;
    private HashMap<au, c> m = new HashMap();
    private au n;
    private au o;
    private ArrayList<Message> p = new ArrayList();
    
    private c(Looper paramLooper, av paramav)
    {
      super();
      this.l = paramav;
      a(this.j, null);
      a(this.k, null);
    }
    
    private final c a(au paramau1, au paramau2)
    {
      c localc = null;
      Object localObject;
      if (this.a)
      {
        StringBuilder localStringBuilder = new StringBuilder("addStateInternal: E state=").append(paramau1.c()).append(",parent=");
        if (paramau2 == null)
        {
          localObject = "";
          Log.d("StateMachine", (String)localObject);
        }
      }
      else
      {
        localObject = localc;
        if (paramau2 != null)
        {
          localObject = (c)this.m.get(paramau2);
          if (localObject != null) {
            break label205;
          }
          localObject = a(paramau2, null);
        }
      }
      label205:
      for (;;)
      {
        localc = (c)this.m.get(paramau1);
        paramau2 = localc;
        if (localc == null)
        {
          paramau2 = new c((byte)0);
          this.m.put(paramau1, paramau2);
        }
        if ((paramau2.b != null) && (paramau2.b != localObject))
        {
          throw new RuntimeException("state already added");
          localObject = paramau2.c();
          break;
        }
        paramau2.a = paramau1;
        paramau2.b = ((c)localObject);
        paramau2.c = false;
        if (this.a) {
          Log.d("StateMachine", "addStateInternal: X stateInfo: " + paramau2);
        }
        return paramau2;
      }
    }
    
    private void a()
    {
      au localau;
      for (Object localObject1 = null; this.o != null; localObject1 = localau)
      {
        if (this.a) {
          Log.d("StateMachine", "handleMessage: new destination call exit");
        }
        localau = this.o;
        this.o = null;
        this.i = 0;
        localObject1 = (c)this.m.get(localau);
        Object localObject2;
        do
        {
          localObject2 = this.h;
          int i1 = this.i;
          this.i = (i1 + 1);
          localObject2[i1] = localObject1;
          localObject2 = ((c)localObject1).b;
          if (localObject2 == null) {
            break;
          }
          localObject1 = localObject2;
        } while (!((c)localObject2).c);
        if (this.a) {
          Log.d("StateMachine", "setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.i + ",curStateInfo: " + localObject2);
        }
        a((c)localObject2);
        a(c());
        b();
      }
      if ((localObject1 != null) && (localObject1 == this.k))
      {
        this.l.a();
        if (this.l.c != null)
        {
          getLooper().quit();
          this.l.c = null;
        }
      }
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
      c localc = this.f[this.g];
      Object localObject1 = localc;
      if (this.a)
      {
        Log.d("StateMachine", "processMsg: " + localc.a.c());
        localObject1 = localc;
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (!((c)localObject1).a.a(paramMessage))
        {
          localc = ((c)localObject1).b;
          if (localc != null) {
            break label206;
          }
          localObject1 = this.l;
          if (((av)localObject1).b.a) {
            Log.e("StateMachine", ((av)localObject1).a + " - unhandledMessage: msg.what=" + paramMessage.what);
          }
          if ((paramMessage.what != -1) || (paramMessage.obj != b)) {
            break label201;
          }
        }
        label201:
        for (int i1 = 1;; i1 = 0)
        {
          localObject2 = localc;
          if (i1 != 0)
          {
            a(this.k);
            localObject2 = localc;
          }
          if (localObject2 == null) {
            break;
          }
          localObject1 = this.f[this.g].a;
          this.d.a(paramMessage, ((c)localObject2).a, (au)localObject1);
          return;
        }
        label206:
        localObject1 = localc;
        if (this.a)
        {
          Log.d("StateMachine", "processMsg: " + localc.a.c());
          localObject1 = localc;
        }
      }
      this.d.a(paramMessage, null, null);
    }
    
    private final void a(at paramat)
    {
      this.o = ((au)paramat);
      if (this.a) {
        Log.d("StateMachine", "StateMachine.transitionTo EX destState" + this.o.c());
      }
    }
    
    private final void a(c paramc)
    {
      while ((this.g >= 0) && (this.f[this.g] != paramc))
      {
        au localau = this.f[this.g].a;
        if (this.a) {
          Log.d("StateMachine", "invokeExitMethods: " + localau.c());
        }
        localau.b();
        this.f[this.g].c = false;
        this.g -= 1;
      }
    }
    
    private final void b()
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
    
    private final int c()
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
    
    private final void d()
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
      c();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (this.a) {
        Log.d("StateMachine", "handleMessage: E msg.what=" + paramMessage.what);
      }
      this.c = paramMessage;
      if (!this.e) {
        Log.e("StateMachine", "The start method not called, ignore msg: " + paramMessage);
      }
      do
      {
        return;
        a(paramMessage);
        a();
      } while (!this.a);
      Log.d("StateMachine", "handleMessage: X");
    }
    
    final class a
      extends au
    {
      private a() {}
      
      public final boolean a(Message paramMessage)
      {
        return true;
      }
    }
    
    final class b
      extends au
    {
      private b() {}
      
      public final boolean a(Message paramMessage)
      {
        return false;
      }
    }
    
    final class c
    {
      au a;
      c b;
      boolean c;
      
      private c() {}
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("state=").append(this.a.c()).append(",active=").append(this.c).append(",parent=");
        if (this.b == null) {}
        for (String str = "null";; str = this.b.a.c()) {
          return str;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */