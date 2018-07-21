package com.baidu.che.codriver.vr;

import com.baidu.che.codriver.util.h;

public class q
{
  private static final String a = "VrStateMachine";
  private a b = a.a;
  private a c = a.d;
  private a d = a.a;
  private boolean e = false;
  private o f = null;
  
  protected q(o paramo)
  {
    this.f = paramo;
  }
  
  private int a(a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      return -1;
    case 6: 
      return d();
    case 2: 
      return e();
    case 3: 
      return a(3);
    case 4: 
      return a(1);
    }
    return a(2);
  }
  
  private void a(String paramString)
  {
    RuntimeException localRuntimeException = new RuntimeException("stack");
    localRuntimeException.fillInStackTrace();
    h.e("VrStateMachine", paramString + ":", localRuntimeException);
  }
  
  private void j()
  {
    this.b = this.c;
    this.c = a.d;
  }
  
  private void k()
  {
    if (this.d != a.a)
    {
      h.b("VrStateMachine", "restartMode to " + this.d);
      this.e = false;
      a(this.d);
      this.d = a.a;
    }
  }
  
  protected int a(int paramInt)
  {
    int i = -1;
    for (;;)
    {
      try
      {
        h.b("VrStateMachine", "--enterWakeupSceneMode (" + paramInt + ") - mCurState = " + this.b + " , mNextState = " + this.c);
        if (this.e)
        {
          h.e("VrStateMachine", "in restarting mode");
          return i;
        }
        if (!this.f.j())
        {
          h.e("VrStateMachine", "--enterWakeupSceneMode (" + paramInt + ") not inited.");
          continue;
        }
        switch (paramInt)
        {
        }
      }
      finally {}
      h.e("VrStateMachine", "--enterWakeupSceneMode (" + paramInt + ") scenetype illegal.");
    }
    a locala = a.h;
    for (;;)
    {
      if (this.b != locala) {
        break label214;
      }
      this.c = a.d;
      i = 0;
      break;
      locala = a.f;
      continue;
      locala = a.g;
    }
    label214:
    switch (1.a[this.b.ordinal()])
    {
    }
    for (;;)
    {
      h.e("VrStateMachine", "--enterWakeupSceneMode (" + paramInt + ") exception.");
      break;
      this.f.f();
      this.b = a.d;
      this.c = locala;
      i = 0;
      break;
      if (this.f.b(paramInt) == -1) {
        break;
      }
      this.b = locala;
      this.c = a.d;
      i = 0;
      break;
      if (this.f.a(paramInt) == -1) {
        break;
      }
      this.b = locala;
      this.c = a.d;
      i = 0;
      break;
      if (this.c == a.a)
      {
        this.c = a.h;
        i = 0;
        break;
      }
    }
  }
  
  protected a a()
  {
    try
    {
      a locala = this.b;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected int b()
  {
    h.b("VrStateMachine", "--onWakeUpExit- mCurState = " + this.b + " , mNextState = " + this.c);
    if (!this.f.j()) {
      h.e("VrStateMachine", "onWakeUpExit not inited.");
    }
    do
    {
      return -1;
      switch (1.a[this.b.ordinal()])
      {
      default: 
      case 1: 
        do
        {
          h.e("VrStateMachine", "onWakeUpExit state error.");
          return -1;
          if (this.c == a.a)
          {
            j();
            if (this.e) {
              k();
            }
            return 0;
          }
        } while (this.c != a.h);
      }
    } while (this.f.a(3) == -1);
    this.b = a.h;
    this.c = a.d;
    return 0;
    this.b = a.a;
    this.c = a.d;
    if (this.e) {
      k();
    }
    h.b("VrStateMachine", "onWakeUpExit exception, to state VRSTATE_IDLE.");
    return -1;
    if (this.e) {
      k();
    }
    return 0;
    this.b = a.e;
    this.c = a.d;
    h.b("VrStateMachine", "onWakeUpExit exception , to state VRSTATE_BUSY_ASR.");
    return -1;
  }
  
  protected int c()
  {
    h.b("VrStateMachine", "--onAsrExit- mCurState = " + this.b + " , mNextState = " + this.c);
    if (!this.f.j()) {
      h.e("VrStateMachine", "onAsrExit not inited.");
    }
    do
    {
      return -1;
      switch (1.a[this.b.ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          h.e("VrStateMachine", "onAsrExit exception.");
          return -1;
          return 0;
          this.b = a.a;
          this.c = a.d;
          h.b("VrStateMachine", "onAsrExit, to state VRSTATE_IDLE.");
          return 0;
          this.b = a.b;
          this.c = a.d;
          h.b("VrStateMachine", "onAsrExit, to state VRSTATE_BUSY_WAKEUP.");
          return 0;
          switch (1.a[this.c.ordinal()])
          {
          }
        }
        j();
        return 0;
        this.f.i();
        j();
        if (!o.a().q()) {
          this.e = false;
        }
        return 0;
        if (this.f.b(3) == -1)
        {
          h.e("VrStateMachine", "onAsrExit openSceneCmd fail.");
          return -1;
        }
        j();
        return 0;
        if (this.f.b(1) == 0)
        {
          h.e("VrStateMachine", "onAsrExit openSceneCmd fail.");
          return -1;
        }
        j();
        return 0;
      } while (this.f.b(2) != 0);
      j();
      return 0;
    } while (this.f.e() == -1);
    this.b = this.c;
    this.c = a.d;
    return 0;
  }
  
  protected int d()
  {
    int i = -1;
    try
    {
      h.b("VrStateMachine", "--enterIdleMode- mCurState = " + this.b + " , mNextState = " + this.c);
      if (this.e) {
        h.e("VrStateMachine", "in restarting mode");
      }
      for (;;)
      {
        return i;
        if (this.f.j()) {
          break;
        }
        h.e("VrStateMachine", "enterIdleMode not inited.");
      }
      switch (1.a[this.b.ordinal()])
      {
      }
    }
    finally {}
    for (;;)
    {
      h.e("VrStateMachine", "enterIdleMode exception.");
      break;
      this.c = a.d;
      i = 0;
      break;
      this.f.i();
      this.b = a.d;
      this.c = a.a;
      i = 0;
      break;
      this.f.f();
      this.b = a.d;
      this.c = a.a;
      i = 0;
      break;
    }
  }
  
  protected int e()
  {
    int i = -1;
    try
    {
      h.b("VrStateMachine", "--enterWakeupMode- mCurState = " + this.b + " , mNextState = " + this.c);
      if (this.e) {
        h.e("VrStateMachine", "in restarting mode");
      }
      for (;;)
      {
        return i;
        if (this.f.j()) {
          break;
        }
        h.e("VrStateMachine", "enterWakeupMode not inited.");
      }
      switch (1.a[this.b.ordinal()])
      {
      }
    }
    finally {}
    for (;;)
    {
      h.e("VrStateMachine", "enterWakeupMode exception.");
      break;
      this.c = a.d;
      i = 0;
      break;
      if (this.f.h() == -1) {
        break;
      }
      this.b = a.b;
      this.c = a.d;
      i = 0;
      break;
      this.f.g();
      this.b = a.b;
      this.c = a.d;
      i = 0;
      break;
      this.f.f();
      this.b = a.d;
      this.c = a.b;
      i = 0;
      break;
    }
  }
  
  protected int f()
  {
    int i = -1;
    try
    {
      h.b("VrStateMachine", "--enterAsrWakeupMode- mCurState = " + this.b + " , mNextState = " + this.c);
      if (this.e) {
        h.e("VrStateMachine", "in restarting mode");
      }
      for (;;)
      {
        return i;
        if (this.f.j()) {
          break;
        }
        h.e("VrStateMachine", "enterAsrWakeupMode not inited.");
      }
      switch (1.a[this.b.ordinal()])
      {
      }
    }
    finally {}
    for (;;)
    {
      h.e("VrStateMachine", "enterAsrWakeupMode exception.");
      break;
      this.f.f();
      this.c = this.b;
      this.b = a.d;
      i = 0;
      break;
      if (this.f.e() == -1) {
        break;
      }
      this.b = a.c;
      this.c = a.d;
      i = 0;
      break;
      this.f.g();
      if (this.f.e() == -1) {
        break;
      }
      this.b = a.c;
      this.c = a.d;
      i = 0;
      break;
      if (this.f.e() == -1) {
        break;
      }
      this.b = a.e;
      this.c = a.d;
      i = 0;
      break;
    }
  }
  
  protected int g()
  {
    int i = -1;
    for (;;)
    {
      try
      {
        h.b("VrStateMachine", "--restartStateMachine- mCurState = " + this.b + " , mNextState = " + this.c);
        if (this.e)
        {
          h.e("VrStateMachine", "in restarting mode");
          return i;
        }
        if (!this.f.j())
        {
          h.e("VrStateMachine", "restartStateMachine not inited.");
          continue;
        }
        switch (1.a[this.b.ordinal()])
        {
        }
      }
      finally {}
      this.d = this.c;
      for (;;)
      {
        d();
        this.e = true;
        i = 0;
        break;
        this.d = this.b;
        continue;
        this.d = a.h;
        continue;
        this.d = a.b;
      }
      continue;
      i = 0;
    }
  }
  
  protected void h()
  {
    h.b("VrStateMachine", "new handleWakeupError mCurState = " + this.b + ";mNextState = " + this.c + ";mRestartState = " + this.d);
    if (this.e)
    {
      this.e = false;
      this.b = a.a;
      this.d = a.a;
      this.c = a.d;
      return;
    }
    this.d = a.a;
    this.b = a.a;
    this.c = a.d;
  }
  
  protected void i()
  {
    h.b("VrStateMachine", "handleAsrError mCurState = " + this.b + ";mNextState = " + this.c + ";mRestartState = " + this.d);
    if (this.e) {
      this.e = false;
    }
    this.d = a.a;
    this.b = a.a;
    this.c = a.d;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */