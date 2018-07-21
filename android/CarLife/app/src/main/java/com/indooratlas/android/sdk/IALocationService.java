package com.indooratlas.android.sdk;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.indooratlas.android.sdk._internal.ax;
import com.indooratlas.android.sdk._internal.ay;
import com.indooratlas.android.sdk._internal.bf;
import com.indooratlas.android.sdk._internal.bf.b;
import com.indooratlas.android.sdk._internal.bh;
import com.indooratlas.android.sdk._internal.bj;
import com.indooratlas.android.sdk._internal.bo;
import com.indooratlas.android.sdk._internal.bo.c;
import com.indooratlas.android.sdk._internal.bp;
import com.indooratlas.android.sdk._internal.br;
import com.indooratlas.android.sdk._internal.cr;
import com.indooratlas.android.sdk._internal.dc;
import com.indooratlas.android.sdk._internal.ee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class IALocationService
  extends Service
{
  final HashSet<PendingIntent> a = new HashSet();
  private bf b;
  private final HashMap<String, a> c = new HashMap();
  private final HashSet<PendingIntent> d = new HashSet();
  private final bo.c e = new c();
  private IALocation f;
  private IARegion g;
  private IARegion h;
  private ax i;
  private boolean j = false;
  
  private void b(String paramString)
  {
    a(paramString);
  }
  
  private void d()
  {
    if (this.b != null)
    {
      this.b.a();
      this.b.b();
      this.b = null;
    }
  }
  
  final a a(String paramString, Messenger paramMessenger)
  {
    synchronized (this.c)
    {
      this.c.containsKey(paramString);
      a locala = new a(paramString, paramMessenger);
      try
      {
        paramMessenger.getBinder().linkToDeath(locala.d, 0);
        this.c.put(paramString, locala);
        c();
        return locala;
      }
      catch (RemoteException paramString)
      {
        return null;
      }
    }
  }
  
  final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          try
          {
            Message localMessage = this.e.a(paramInt1);
            localMessage.arg1 = paramInt2;
            localMessage.arg2 = -1;
            localMessage.obj = paramObject;
            locala.c.send(localMessage);
          }
          catch (RemoteException localRemoteException)
          {
            a(locala.a);
          }
        }
      }
    }
  }
  
  final void a(ax paramax)
  {
    LinkedList localLinkedList;
    for (;;)
    {
      synchronized (this.d)
      {
        localLinkedList = new LinkedList();
        if (this.d.size() <= 0) {
          break label153;
        }
        Intent localIntent = new Intent();
        if (paramax == null)
        {
          paramax = null;
          localIntent.putExtra("com.indooratlas.android.sdk.intent.extras.geofenceEvent", paramax);
          paramax = this.d.iterator();
          if (!paramax.hasNext()) {
            break;
          }
          localObject = (PendingIntent)paramax.next();
          try
          {
            ((PendingIntent)localObject).send(this, 0, localIntent);
          }
          catch (PendingIntent.CanceledException localCanceledException)
          {
            localLinkedList.add(localObject);
          }
        }
      }
      Object localObject = Parcel.obtain();
      paramax.writeToParcel((Parcel)localObject, 0);
      paramax = ((Parcel)localObject).marshall();
      ((Parcel)localObject).recycle();
    }
    if (!localLinkedList.isEmpty())
    {
      this.d.removeAll(localLinkedList);
      c();
    }
    label153:
  }
  
  final void a(String paramString)
  {
    synchronized (this.c)
    {
      boolean bool = a();
      paramString = (a)this.c.remove(paramString);
      if (paramString != null)
      {
        paramString.c.getBinder().unlinkToDeath(paramString.d, 0);
        c();
        a(bool);
        b();
        return;
      }
      return;
    }
  }
  
  final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!a()))
    {
      bf localbf = this.b;
      if (localbf.c()) {
        localbf.a.a(6).sendToTarget();
      }
    }
  }
  
  final boolean a()
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      if (((a)localIterator.next()).b) {
        return true;
      }
    }
    return !this.a.isEmpty();
  }
  
  final void b()
  {
    if ((!this.c.isEmpty()) || (!this.a.isEmpty())) {}
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        d();
        stopSelf();
      }
      return;
    }
  }
  
  final void c()
  {
    int m;
    int k;
    if (ee.a("IAService", 3))
    {
      m = this.c.size();
      Iterator localIterator = this.c.values().iterator();
      k = 0;
      if (localIterator.hasNext())
      {
        if (!((a)localIterator.next()).b) {
          break label131;
        }
        k += 1;
      }
    }
    label131:
    for (;;)
    {
      break;
      int n = this.a.size();
      int i1 = this.d.size();
      new StringBuilder("active connections = ").append(m).append(" (").append(k).append(" requesting position), pending intents for location updates = ").append(n).append(", pending intents for geofence events = ").append(i1);
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.e.a();
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    d();
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }
  
  final class a
  {
    final String a;
    boolean b;
    final Messenger c;
    final IBinder.DeathRecipient d;
    
    a(String paramString, Messenger paramMessenger)
    {
      this.a = paramString;
      this.c = paramMessenger;
      this.d = new a();
    }
    
    public final String toString()
    {
      return "ConnectionInfo{uuid=" + this.a + ", listeningPositions=" + this.b + '}';
    }
    
    final class a
      implements IBinder.DeathRecipient
    {
      a() {}
      
      public final void binderDied()
      {
        IALocationService.a(IALocationService.this, IALocationService.a.this.a);
      }
    }
  }
  
  final class b
    extends bj
  {
    b() {}
    
    public final void a(int paramInt)
    {
      IALocationService.this.a(102, paramInt, null);
    }
    
    public final void a(long paramLong, double paramDouble)
    {
      IALocationService.this.a(104, -1, new Object[] { Long.valueOf(paramLong), Double.valueOf(paramDouble) });
    }
    
    public final void a(long paramLong, double[] paramArrayOfDouble)
    {
      IALocationService.this.a(105, -1, new Object[] { Long.valueOf(paramLong), paramArrayOfDouble });
    }
    
    public final void a(Bundle paramBundle)
    {
      if (IALocationService.b(IALocationService.this)) {
        IALocationService.this.a(503, -1, paramBundle);
      }
    }
    
    public final void a(IALocation paramIALocation)
    {
      IALocationService.a(IALocationService.this, paramIALocation);
      IALocationService.this.a(103, -1, paramIALocation);
      IALocationService localIALocationService = IALocationService.this;
      LinkedList localLinkedList;
      for (;;)
      {
        synchronized (localIALocationService.a)
        {
          localLinkedList = new LinkedList();
          if (localIALocationService.a.size() <= 0) {
            break label190;
          }
          Intent localIntent = new Intent();
          if (paramIALocation == null)
          {
            paramIALocation = null;
            localIntent.putExtra("com.indooratlas.android.sdk.intent.extras.location", paramIALocation);
            paramIALocation = localIALocationService.a.iterator();
            if (!paramIALocation.hasNext()) {
              break;
            }
            localObject = (PendingIntent)paramIALocation.next();
            try
            {
              ((PendingIntent)localObject).send(localIALocationService, 0, localIntent);
            }
            catch (PendingIntent.CanceledException localCanceledException)
            {
              localLinkedList.add(localObject);
            }
          }
        }
        Object localObject = Parcel.obtain();
        paramIALocation.writeToParcel((Parcel)localObject, 0);
        paramIALocation = ((Parcel)localObject).marshall();
        ((Parcel)localObject).recycle();
      }
      if (!localLinkedList.isEmpty())
      {
        localIALocationService.a.removeAll(localLinkedList);
        localIALocationService.c();
        localIALocationService.a(true);
        localIALocationService.b();
      }
      label190:
    }
    
    public final void a(ax paramax)
    {
      IALocationService.a(IALocationService.this, paramax);
      IALocationService.this.a(106, -1, paramax);
      IALocationService.this.a(paramax);
    }
    
    public final void a(bh parambh)
    {
      new StringBuilder("onUnrecoverableError: ").append(parambh);
    }
    
    public final void a(bp parambp)
    {
      IALocationService.a(IALocationService.this).b().obtainMessage(1002, parambp).sendToTarget();
    }
    
    public final void a(String paramString)
    {
      if (IALocationService.b(IALocationService.this)) {
        IALocationService.this.a(501, -1, paramString);
      }
    }
    
    public final void a(JSONObject paramJSONObject)
    {
      Bundle localBundle = new Bundle(2);
      try
      {
        String str = paramJSONObject.getString("key");
        paramJSONObject = paramJSONObject.optString("id", null);
        localBundle.putString("idaKey", str);
        localBundle.putString("setupId", paramJSONObject);
        IALocationService.a(IALocationService.this).b().obtainMessage(1003, localBundle).sendToTarget();
        return;
      }
      catch (JSONException paramJSONObject) {}
    }
    
    public final void b(Bundle paramBundle)
    {
      if (IALocationService.b(IALocationService.this)) {
        IALocationService.this.a(504, -1, paramBundle);
      }
    }
    
    public final void b(String paramString)
    {
      if (IALocationService.b(IALocationService.this)) {
        IALocationService.this.a(502, -1, paramString);
      }
    }
  }
  
  final class c
    extends bo.c
  {
    c() {}
    
    protected final void a(PendingIntent paramPendingIntent)
    {
      synchronized (IALocationService.d(IALocationService.this))
      {
        boolean bool = IALocationService.this.a();
        IALocationService.d(IALocationService.this).remove(paramPendingIntent);
        IALocationService.c(IALocationService.this);
        IALocationService.a(IALocationService.this, bool);
        IALocationService.e(IALocationService.this);
        return;
      }
    }
    
    protected final void a(Message paramMessage)
    {
      IALocationService.this.a(bo.e(paramMessage));
    }
    
    protected final void a(Message paramMessage, Messenger paramMessenger)
    {
      IALocationService.a(IALocationService.this, paramMessage.getData().getBundle("_extras"));
      paramMessage = IALocationService.this.a(bo.e(paramMessage), paramMessenger);
      if (paramMessage != null) {
        IALocationService.a(IALocationService.this, paramMessage);
      }
    }
    
    protected final void a(Message paramMessage, IALocationRequest paramIALocationRequest)
    {
      IALocationService.a locala = IALocationService.a(IALocationService.this, paramMessage);
      if (locala == null)
      {
        ee.a("IAService", "no such ConnectionInfo: %s", new Object[] { bo.e(paramMessage) });
        return;
      }
      boolean bool = IALocationService.this.a();
      locala.b = true;
      IALocationService.c(IALocationService.this);
      IALocationService.a(IALocationService.this, bool, paramIALocationRequest);
    }
    
    protected final void a(IALocation paramIALocation)
    {
      bf localbf = IALocationService.f(IALocationService.this);
      if (localbf.c())
      {
        paramIALocation = paramIALocation.newBuilder().withLongExtra("com.indooratlas.android.sdk.intent.extras.clientTime", localbf.v.a()).build();
        localbf.a.a(7, paramIALocation).sendToTarget();
      }
    }
    
    protected final void a(IALocationRequest paramIALocationRequest, PendingIntent paramPendingIntent)
    {
      synchronized (IALocationService.d(IALocationService.this))
      {
        boolean bool = IALocationService.this.a();
        IALocationService.d(IALocationService.this).add(paramPendingIntent);
        IALocationService.c(IALocationService.this);
        IALocationService.a(IALocationService.this, bool, paramIALocationRequest);
        return;
      }
    }
    
    protected final void a(IAOrientationRequest paramIAOrientationRequest)
    {
      bf localbf = IALocationService.f(IALocationService.this);
      if (localbf.c()) {
        localbf.a.a(8, paramIAOrientationRequest).sendToTarget();
      }
    }
    
    protected final void a(ay paramay)
    {
      bf localbf = IALocationService.f(IALocationService.this);
      Log.d("IACore", "Adding " + paramay.a().size() + " geofences.");
      if (localbf.c()) {
        localbf.a.a(109, paramay).sendToTarget();
      }
    }
    
    protected final void a(ArrayList<String> paramArrayList)
    {
      bf localbf = IALocationService.f(IALocationService.this);
      if (localbf.c()) {
        localbf.a.a(110, paramArrayList).sendToTarget();
      }
    }
    
    protected final void b(PendingIntent paramPendingIntent)
    {
      synchronized (IALocationService.g(IALocationService.this))
      {
        if ((IALocationService.g(IALocationService.this).add(paramPendingIntent)) && (IALocationService.h(IALocationService.this) != null)) {
          IALocationService.this.a(IALocationService.h(IALocationService.this));
        }
        IALocationService.c(IALocationService.this);
        return;
      }
    }
    
    protected final void b(Message paramMessage)
    {
      IALocationService.a locala = IALocationService.a(IALocationService.this, paramMessage);
      if (locala == null)
      {
        ee.a("IAService", "no such ConnectionInfo: %s", new Object[] { bo.e(paramMessage) });
        return;
      }
      boolean bool = IALocationService.this.a();
      locala.b = false;
      IALocationService.c(IALocationService.this);
      IALocationService.a(IALocationService.this, bool);
    }
    
    protected final void c(PendingIntent paramPendingIntent)
    {
      synchronized (IALocationService.g(IALocationService.this))
      {
        IALocationService.g(IALocationService.this).remove(paramPendingIntent);
        IALocationService.c(IALocationService.this);
        return;
      }
    }
    
    protected final void c(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        super.c(paramMessage);
      case 1002: 
      case 1003: 
      case 10: 
      case 11: 
        bf localbf;
        do
        {
          do
          {
            return;
            IALocationService.a(IALocationService.this, (bp)paramMessage.obj);
            return;
            IALocationService.b(IALocationService.this, (Bundle)paramMessage.obj);
            return;
            paramMessage = (dc)paramMessage.obj;
            localbf = IALocationService.f(IALocationService.this);
          } while (!localbf.c());
          localbf.a.a(105, paramMessage).sendToTarget();
          return;
          paramMessage = (dc)paramMessage.obj;
          localbf = IALocationService.f(IALocationService.this);
        } while (!localbf.c());
        localbf.a.a(106, paramMessage).sendToTarget();
        return;
      case 13: 
        paramMessage = (br)paramMessage.obj;
        IALocationService.f(IALocationService.this).a(paramMessage, false);
        return;
      }
      paramMessage = (br)paramMessage.obj;
      IALocationService.f(IALocationService.this).a(paramMessage, true);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/IALocationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */