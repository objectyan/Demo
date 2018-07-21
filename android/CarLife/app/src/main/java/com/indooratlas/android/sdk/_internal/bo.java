package com.indooratlas.android.sdk._internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IAOrientationRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public abstract class bo
{
  protected Messenger c = new Messenger(this.d);
  protected Handler d = new b(this);
  protected String e = UUID.randomUUID().toString();
  
  static <T> T a(Message paramMessage, String paramString)
  {
    paramMessage = paramMessage.getData();
    paramMessage.setClassLoader(bo.class.getClassLoader());
    return paramMessage.getParcelable(paramString);
  }
  
  public static String e(Message paramMessage)
  {
    return paramMessage.getData().getString("_uuid");
  }
  
  public final IBinder a()
  {
    return this.c.getBinder();
  }
  
  public final Message a(int paramInt)
  {
    Message localMessage = Message.obtain(null, paramInt);
    String str = this.e;
    localMessage.getData().putString("_uuid", str);
    return localMessage;
  }
  
  public final Message a(int paramInt, Object paramObject)
  {
    Message localMessage = a(paramInt);
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  public final Handler b()
  {
    return this.d;
  }
  
  public void c(Message paramMessage)
  {
    int i = paramMessage.what;
  }
  
  protected abstract void d(Message paramMessage);
  
  public static abstract class a
    extends bo
  {
    private Messenger a;
    private final Queue<Message> b = new LinkedList();
    
    protected void a(Bundle paramBundle) {}
    
    public final void a(Message paramMessage)
      throws RemoteException
    {
      if (this.a == null)
      {
        i = paramMessage.what;
        localObject = paramMessage.obj;
        this.b.offer(paramMessage);
        return;
      }
      int i = paramMessage.what;
      Object localObject = paramMessage.obj;
      this.a.send(paramMessage);
    }
    
    public final void a(@NonNull Messenger paramMessenger, @Nullable Bundle paramBundle)
      throws RemoteException
    {
      if (this.a != null) {
        throw new AssertionError("register called when mService already set");
      }
      this.a = paramMessenger;
      Object localObject = a(1);
      ((Message)localObject).replyTo = this.c;
      if (paramBundle != null) {
        ((Message)localObject).getData().putParcelable("_extras", paramBundle);
      }
      paramMessenger.send((Message)localObject);
      while (!this.b.isEmpty())
      {
        paramBundle = (Message)this.b.poll();
        int i = paramBundle.what;
        localObject = paramBundle.obj;
        paramMessenger.send(paramBundle);
      }
    }
    
    protected void a(IALocation paramIALocation) {}
    
    public final void a(IAOrientationRequest paramIAOrientationRequest)
      throws RemoteException
    {
      Message localMessage = a(6);
      localMessage.getData().putParcelable("request", paramIAOrientationRequest);
      a(localMessage);
    }
    
    protected void a(ax paramax) {}
    
    protected void a(bp parambp) {}
    
    protected void b(Bundle paramBundle) {}
    
    public final void c()
    {
      this.b.clear();
      this.a = null;
    }
    
    protected final void d(Message paramMessage)
    {
      int i = paramMessage.what;
      Object localObject = paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        c(paramMessage);
        return;
      case 103: 
        a((IALocation)paramMessage.obj);
        return;
      case 21: 
        a((bp)a(paramMessage, "state"));
        return;
      case 22: 
        a((Bundle)paramMessage.obj);
        return;
      case 25: 
        b((Bundle)paramMessage.obj);
        return;
      case 101: 
        i = paramMessage.arg1;
        return;
      }
      a((ax)paramMessage.obj);
    }
  }
  
  static final class b
    extends ek<bo>
  {
    b(bo parambo)
    {
      super();
    }
  }
  
  public static abstract class c
    extends bo
  {
    public abstract void a(PendingIntent paramPendingIntent);
    
    public abstract void a(Message paramMessage);
    
    public abstract void a(Message paramMessage, Messenger paramMessenger);
    
    public abstract void a(Message paramMessage, IALocationRequest paramIALocationRequest);
    
    public abstract void a(IALocation paramIALocation);
    
    public abstract void a(IALocationRequest paramIALocationRequest, PendingIntent paramPendingIntent);
    
    public abstract void a(IAOrientationRequest paramIAOrientationRequest);
    
    public abstract void a(ay paramay);
    
    public abstract void a(ArrayList<String> paramArrayList);
    
    public abstract void b(PendingIntent paramPendingIntent);
    
    public abstract void b(Message paramMessage);
    
    public abstract void c(PendingIntent paramPendingIntent);
    
    protected final void d(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        c(paramMessage);
        return;
      case 1: 
        a(paramMessage, paramMessage.replyTo);
        return;
      case 2: 
        a(paramMessage);
        return;
      case 3: 
        a(paramMessage, (IALocationRequest)a(paramMessage, "request"));
        return;
      case 7: 
        a((IALocationRequest)a(paramMessage, "request"), (PendingIntent)a(paramMessage, "pendingIntent"));
        return;
      case 4: 
        b(paramMessage);
        return;
      case 8: 
        a((PendingIntent)a(paramMessage, "pendingIntent"));
        return;
      case 5: 
        a((IALocation)a(paramMessage, "location"));
        return;
      case 6: 
        a((IAOrientationRequest)a(paramMessage, "request"));
        return;
      case 14: 
        a((ay)a(paramMessage, "request"));
        return;
      case 15: 
        a(paramMessage.getData().getStringArrayList("requestIds"));
        return;
      case 16: 
        b((PendingIntent)a(paramMessage, "pendingIntent"));
        return;
      }
      c((PendingIntent)a(paramMessage, "pendingIntent"));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */