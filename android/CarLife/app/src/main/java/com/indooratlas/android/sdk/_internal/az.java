package com.indooratlas.android.sdk._internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk.IAExtraInfo;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IALocationService;
import com.indooratlas.android.sdk.IAOrientationListener;
import com.indooratlas.android.sdk.IAOrientationRequest;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk.IARegion.Listener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class az
  extends IALocationManager
{
  boolean a = false;
  bo.a b;
  Messenger c;
  Context d;
  c e;
  IALocation f;
  IARegion g;
  IARegion h;
  ax i;
  final ConcurrentHashMap<IALocationListener, e> j;
  final ArrayList<f> k = new ArrayList();
  final HashMap<Object, d> l;
  private Bundle m;
  private String n;
  private String o;
  private bp p;
  private final HashMap<IAOrientationListener, IAOrientationRequest> q = new HashMap();
  private final cr r;
  
  az(@NonNull a parama)
  {
    d();
    this.b = new b();
    this.d = ((Context)eg.a(parama.a, "context must be non null", new Object[0]));
    this.j = new ConcurrentHashMap();
    this.m = parama.b;
    this.r = parama.c;
    this.l = new HashMap();
    c();
  }
  
  private static double a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble2 >= 0.0D) && ((paramDouble1 < 0.0D) || (paramDouble2 < paramDouble1))) {
      return paramDouble2;
    }
    return paramDouble1;
  }
  
  protected static Messenger a(IBinder paramIBinder)
  {
    return new Messenger(paramIBinder);
  }
  
  private void a()
  {
    if (this.a) {
      throw new IllegalStateException("using destroyed IALocationManager");
    }
  }
  
  private IAOrientationRequest b()
  {
    Iterator localIterator = this.q.values().iterator();
    double d1 = -1.0D;
    double d2 = -1.0D;
    while (localIterator.hasNext())
    {
      IAOrientationRequest localIAOrientationRequest = (IAOrientationRequest)localIterator.next();
      d2 = a(d2, localIAOrientationRequest.getHeadingSensitivity());
      d1 = a(d1, localIAOrientationRequest.getOrientationSensitivity());
    }
    return new IAOrientationRequest(d2, d1);
  }
  
  private boolean c()
  {
    if (this.e != null) {}
    Intent localIntent;
    do
    {
      return true;
      this.e = new c();
      localIntent = new Intent(this.d, IALocationService.class);
      this.d.startService(localIntent);
    } while (this.d.bindService(localIntent, this.e, 1));
    ee.a("IASDK", "failed to connect with location service. make sure you have declared service in your manifest.", new Object[0]);
    this.e = null;
    this.b.c();
    return false;
  }
  
  private static void d()
  {
    String str = IALocationManager.class.getSimpleName() + " must be called from main thread, %s <> %s";
    if ((Looper.getMainLooper() != Looper.myLooper()) && (!Looper.myLooper().getThread().getName().contains("Instr: android.test.InstrumentationTestRunner"))) {
      throw new RuntimeException(ei.a(str, new Object[] { Looper.myLooper(), Looper.getMainLooper() }));
    }
  }
  
  final void a(long paramLong, double paramDouble)
  {
    Iterator localIterator = this.q.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((IAOrientationRequest)localEntry.getValue()).getHeadingSensitivity() >= 0.0D) {
        ((IAOrientationListener)localEntry.getKey()).onHeadingChanged(paramLong, paramDouble);
      }
    }
  }
  
  final void a(long paramLong, double[] paramArrayOfDouble)
  {
    Iterator localIterator = this.q.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((IAOrientationRequest)localEntry.getValue()).getOrientationSensitivity() >= 0.0D) {
        ((IAOrientationListener)localEntry.getKey()).onOrientationChange(paramLong, paramArrayOfDouble);
      }
    }
  }
  
  public void destroy()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    if (this.e != null) {}
    try
    {
      if (this.c != null)
      {
        bo.a locala = this.b;
        this.c.send(locala.a(2));
        locala.c();
        this.d.unbindService(this.e);
      }
      this.j.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  @NonNull
  public IAExtraInfo getExtraInfo()
  {
    a();
    String str = null;
    if (this.o != null) {
      str = this.o + "." + this.r.b() + "." + this.r.a();
    }
    return new IAExtraInfo("2.4.2", str);
  }
  
  public boolean registerOrientationListener(@NonNull IAOrientationRequest paramIAOrientationRequest, @NonNull IAOrientationListener paramIAOrientationListener)
  {
    boolean bool = false;
    a();
    eg.a(paramIAOrientationRequest, "request must be non null", new Object[0]);
    eg.a(paramIAOrientationListener, "listener must be non null", new Object[0]);
    d();
    if (!this.q.containsKey(paramIAOrientationListener)) {
      bool = true;
    }
    this.q.put(paramIAOrientationListener, paramIAOrientationRequest);
    try
    {
      this.b.a(b());
      return bool;
    }
    catch (RemoteException paramIAOrientationRequest) {}
    return bool;
  }
  
  public boolean registerRegionListener(IARegion.Listener paramListener)
  {
    a();
    eg.a(paramListener, "listener must be non null", new Object[0]);
    d();
    paramListener = new f(paramListener, (byte)0);
    if (this.k.contains(paramListener)) {
      return false;
    }
    this.k.add(paramListener);
    if (this.g != null) {
      paramListener.a(this.g);
    }
    if (this.h != null) {
      paramListener.a(this.h);
    }
    return true;
  }
  
  public void removeLocationUpdates(@NonNull PendingIntent paramPendingIntent)
  {
    a();
    eg.a(paramPendingIntent, "pendingIntent must be non null", new Object[0]);
    d();
    try
    {
      bo.a locala = this.b;
      Message localMessage = locala.a(8);
      localMessage.getData().putParcelable("pendingIntent", paramPendingIntent);
      locala.a(localMessage);
      return;
    }
    catch (RemoteException paramPendingIntent) {}
  }
  
  public boolean removeLocationUpdates(@NonNull IALocationListener paramIALocationListener)
  {
    a();
    eg.a(paramIALocationListener, "listener must be non null", new Object[0]);
    d();
    synchronized (this.j)
    {
      if ((e)this.j.remove(paramIALocationListener) == null) {
        return false;
      }
      boolean bool = this.j.isEmpty();
      if (!bool) {}
    }
    try
    {
      paramIALocationListener = this.b;
      paramIALocationListener.a(paramIALocationListener.a(4));
      paramIALocationListener = this.k.iterator();
      while (paramIALocationListener.hasNext())
      {
        f localf = (f)paramIALocationListener.next();
        localf.b = null;
        localf.c = null;
        continue;
        paramIALocationListener = finally;
        throw paramIALocationListener;
      }
      this.f = null;
      this.g = null;
      this.h = null;
      this.i = null;
      this.j.size();
      return true;
    }
    catch (RemoteException paramIALocationListener)
    {
      for (;;) {}
    }
  }
  
  public void requestLocationUpdates(@NonNull IALocationRequest paramIALocationRequest, @NonNull PendingIntent paramPendingIntent)
  {
    a();
    eg.a(paramIALocationRequest, "request must be non null", new Object[0]);
    eg.a(paramPendingIntent, "pendingIntent must be non null", new Object[0]);
    d();
    try
    {
      if (!c()) {
        return;
      }
      bo.a locala = this.b;
      Message localMessage = locala.a(7);
      localMessage.getData().putParcelable("request", paramIALocationRequest);
      localMessage.getData().putParcelable("pendingIntent", paramPendingIntent);
      locala.a(localMessage);
      return;
    }
    catch (RemoteException paramIALocationRequest) {}
  }
  
  public boolean requestLocationUpdates(IALocationRequest paramIALocationRequest, IALocationListener paramIALocationListener)
  {
    return requestLocationUpdates(paramIALocationRequest, paramIALocationListener, null);
  }
  
  /* Error */
  public boolean requestLocationUpdates(@NonNull IALocationRequest paramIALocationRequest, @NonNull IALocationListener paramIALocationListener, @Nullable Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 326	com/indooratlas/android/sdk/_internal/az:a	()V
    //   4: aload_1
    //   5: ldc_w 350
    //   8: iconst_0
    //   9: anewarray 88	java/lang/Object
    //   12: invokestatic 93	com/indooratlas/android/sdk/_internal/eg:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_2
    //   17: ldc_w 352
    //   20: iconst_0
    //   21: anewarray 88	java/lang/Object
    //   24: invokestatic 93	com/indooratlas/android/sdk/_internal/eg:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: invokestatic 77	com/indooratlas/android/sdk/_internal/az:d	()V
    //   31: aload_0
    //   32: getfield 102	com/indooratlas/android/sdk/_internal/az:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: astore 5
    //   37: aload 5
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 102	com/indooratlas/android/sdk/_internal/az:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   44: aload_2
    //   45: invokevirtual 422	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   48: ifeq +8 -> 56
    //   51: aload 5
    //   53: monitorexit
    //   54: iconst_1
    //   55: ireturn
    //   56: new 20	com/indooratlas/android/sdk/_internal/az$e
    //   59: dup
    //   60: aload_0
    //   61: aload_1
    //   62: aload_2
    //   63: aload_3
    //   64: invokespecial 425	com/indooratlas/android/sdk/_internal/az$e:<init>	(Lcom/indooratlas/android/sdk/_internal/az;Lcom/indooratlas/android/sdk/IALocationRequest;Lcom/indooratlas/android/sdk/IALocationListener;Landroid/os/Looper;)V
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 102	com/indooratlas/android/sdk/_internal/az:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   72: aload_2
    //   73: aload_3
    //   74: invokevirtual 426	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload 5
    //   80: monitorexit
    //   81: aload_0
    //   82: invokespecial 115	com/indooratlas/android/sdk/_internal/az:c	()Z
    //   85: istore 4
    //   87: iload 4
    //   89: ifne +11 -> 100
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_1
    //   95: aload 5
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: aload_0
    //   101: getfield 82	com/indooratlas/android/sdk/_internal/az:b	Lcom/indooratlas/android/sdk/_internal/bo$a;
    //   104: astore_2
    //   105: aload_2
    //   106: iconst_3
    //   107: invokevirtual 311	com/indooratlas/android/sdk/_internal/bo$a:a	(I)Landroid/os/Message;
    //   110: astore 5
    //   112: aload 5
    //   114: invokevirtual 388	android/os/Message:getData	()Landroid/os/Bundle;
    //   117: ldc_w 416
    //   120: aload_1
    //   121: invokevirtual 396	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   124: aload_2
    //   125: aload 5
    //   127: invokevirtual 398	com/indooratlas/android/sdk/_internal/bo$a:a	(Landroid/os/Message;)V
    //   130: aload_0
    //   131: getfield 137	com/indooratlas/android/sdk/_internal/az:p	Lcom/indooratlas/android/sdk/_internal/bp;
    //   134: ifnull +21 -> 155
    //   137: aload_3
    //   138: aload_0
    //   139: getfield 137	com/indooratlas/android/sdk/_internal/az:p	Lcom/indooratlas/android/sdk/_internal/bp;
    //   142: getfield 431	com/indooratlas/android/sdk/_internal/bp:b	I
    //   145: aload_0
    //   146: getfield 137	com/indooratlas/android/sdk/_internal/az:p	Lcom/indooratlas/android/sdk/_internal/bp;
    //   149: getfield 433	com/indooratlas/android/sdk/_internal/bp:c	Landroid/os/Bundle;
    //   152: invokevirtual 173	com/indooratlas/android/sdk/_internal/az$e:a	(ILandroid/os/Bundle;)V
    //   155: aload_0
    //   156: getfield 128	com/indooratlas/android/sdk/_internal/az:f	Lcom/indooratlas/android/sdk/IALocation;
    //   159: ifnull +20 -> 179
    //   162: aload_3
    //   163: aload_0
    //   164: getfield 128	com/indooratlas/android/sdk/_internal/az:f	Lcom/indooratlas/android/sdk/IALocation;
    //   167: invokevirtual 436	com/indooratlas/android/sdk/_internal/az$e:a	(Lcom/indooratlas/android/sdk/IALocation;)V
    //   170: iconst_1
    //   171: ireturn
    //   172: astore_1
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_1
    //   176: goto -81 -> 95
    //   179: iconst_1
    //   180: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	az
    //   0	181	1	paramIALocationRequest	IALocationRequest
    //   0	181	2	paramIALocationListener	IALocationListener
    //   0	181	3	paramLooper	Looper
    //   85	3	4	bool	boolean
    //   35	91	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	54	94	finally
    //   56	81	94	finally
    //   81	87	172	android/os/RemoteException
    //   100	155	172	android/os/RemoteException
    //   155	170	172	android/os/RemoteException
    //   95	98	175	finally
  }
  
  public void setLocation(@NonNull IALocation paramIALocation)
  {
    a();
    eg.a(paramIALocation, "location must be non empty", new Object[0]);
    d();
    try
    {
      bo.a locala = this.b;
      Object localObject = paramIALocation.toLocation();
      paramIALocation = paramIALocation.getRegion();
      if (!"com.indooratlas.android.sdk.intent.extras.groundTruth".equals(((Location)localObject).getProvider())) {
        ((Location)localObject).setProvider("com.indooratlas.android.sdk.intent.extras.userInput");
      }
      paramIALocation = new IALocation.Builder().withLocation((Location)localObject).withRegion(paramIALocation).build();
      localObject = locala.a(5);
      ((Message)localObject).getData().putParcelable("location", paramIALocation);
      locala.a((Message)localObject);
      return;
    }
    catch (RemoteException paramIALocation)
    {
      ee.a("IASDK", "service died, location not sent", new Object[0]);
    }
  }
  
  public boolean unregisterOrientationListener(@NonNull IAOrientationListener paramIAOrientationListener)
  {
    boolean bool = false;
    a();
    eg.a(paramIAOrientationListener, "listener must be non null", new Object[0]);
    d();
    if (this.q.containsKey(paramIAOrientationListener)) {
      this.q.remove(paramIAOrientationListener);
    }
    try
    {
      this.b.a(b());
      bool = true;
      return bool;
    }
    catch (RemoteException paramIAOrientationListener)
    {
      for (;;) {}
    }
  }
  
  public boolean unregisterRegionListener(IARegion.Listener paramListener)
  {
    a();
    eg.a(paramListener, "listener must be non null", new Object[0]);
    d();
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (localf.a == paramListener)
      {
        this.k.remove(localf);
        return true;
      }
    }
    return false;
  }
  
  public static final class a
  {
    final Context a;
    public Bundle b;
    cr c;
    
    public a(Context paramContext)
    {
      new bk();
      this.c = bk.b();
      this.a = paramContext;
    }
    
    public final az a()
    {
      return new az(this);
    }
  }
  
  final class b
    extends bo.a
  {
    static
    {
      if (!az.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    b() {}
    
    protected final void a(Bundle paramBundle)
    {
      if ((!a) && (paramBundle == null)) {
        throw new AssertionError("argument to onSdkInitialized cannot be null");
      }
      az.a(az.this, paramBundle.getString("idaKey"));
      az.b(az.this, paramBundle.getString("setupId"));
    }
    
    protected final void a(IALocation paramIALocation)
    {
      Object localObject1 = az.this;
      ((az)localObject1).f = paramIALocation;
      Object localObject2 = paramIALocation.getRegion();
      if (localObject2 == null)
      {
        ((az)localObject1).g = null;
        ((az)localObject1).h = null;
        localObject2 = ((az)localObject1).k.iterator();
      }
      for (;;)
      {
        label37:
        if (!((Iterator)localObject2).hasNext()) {
          break label193;
        }
        az.f localf = (az.f)((Iterator)localObject2).next();
        if (((az)localObject1).g == null)
        {
          if (localf.b != null) {
            localf.a.onExitRegion(localf.b);
          }
          localf.b = null;
        }
        for (;;)
        {
          if (((az)localObject1).h != null) {
            break label181;
          }
          if (localf.c != null) {
            localf.a.onExitRegion(localf.c);
          }
          localf.c = null;
          break label37;
          if (((IARegion)localObject2).getType() == 2)
          {
            ((az)localObject1).g = ((IARegion)localObject2);
            ((az)localObject1).h = null;
            break;
          }
          if (((IARegion)localObject2).getType() != 1) {
            break;
          }
          ((az)localObject1).h = ((IARegion)localObject2);
          break;
          localf.a(((az)localObject1).g);
        }
        label181:
        localf.a(((az)localObject1).h);
      }
      label193:
      if (!((az)localObject1).j.isEmpty())
      {
        ((az)localObject1).j.size();
        localObject1 = ((az)localObject1).j.entrySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((az.e)((Map.Entry)((Iterator)localObject1).next()).getValue()).a(paramIALocation);
        }
      }
    }
    
    protected final void a(ax paramax)
    {
      Object localObject = az.this;
      ((az)localObject).i = paramax;
      if (!((az)localObject).l.isEmpty())
      {
        ((az)localObject).l.size();
        localObject = ((az)localObject).l.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          az.d locald = (az.d)((Map.Entry)((Iterator)localObject).next()).getValue();
          locald.a.post(new az.d.1(locald, paramax));
        }
      }
    }
    
    protected final void a(bp parambp)
    {
      az.a(az.this, parambp);
      az.a(az.this, parambp.b, parambp.c);
    }
    
    protected final void b(Bundle paramBundle)
    {
      if (paramBundle.containsKey("lastKnownLocation")) {
        az.a(az.this, (IALocation)paramBundle.getParcelable("lastKnownLocation"));
      }
      if (paramBundle.containsKey("currentVenue")) {
        az.a(az.this, (IARegion)paramBundle.getParcelable("currentVenue"));
      }
      if (paramBundle.containsKey("currentFloorPlan")) {
        az.b(az.this, (IARegion)paramBundle.getParcelable("currentFloorPlan"));
      }
      if (paramBundle.containsKey("lastGeofenceEvent")) {
        az.a(az.this, (ax)paramBundle.getParcelable("lastGeofenceEvent"));
      }
    }
    
    protected final void c(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 103: 
      default: 
        paramMessage = az.this;
        return;
      case 102: 
        Bundle localBundle = new Bundle(1);
        localBundle.putInt("quality", paramMessage.arg1);
        az.a(az.this, 11, localBundle);
        return;
      case 104: 
        paramMessage = (Object[])paramMessage.obj;
        az.this.a(((Long)paramMessage[0]).longValue(), ((Double)paramMessage[1]).doubleValue());
        return;
      }
      paramMessage = (Object[])paramMessage.obj;
      az.this.a(((Long)paramMessage[0]).longValue(), (double[])paramMessage[1]);
    }
  }
  
  final class c
    implements ServiceConnection
  {
    c() {}
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      az.this.c = az.a(paramIBinder);
      try
      {
        az.this.b.a(az.this.c, az.a(az.this));
        if (az.this.a) {
          az.this.d.unbindService(az.this.e);
        }
        return;
      }
      catch (RemoteException paramComponentName)
      {
        for (;;) {}
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      az.this.e = null;
      az.this.c = null;
    }
  }
  
  final class d
  {
    Handler a;
  }
  
  final class e
  {
    IALocationListener a;
    private IALocationRequest c;
    private Handler d;
    
    e(IALocationRequest paramIALocationRequest, IALocationListener paramIALocationListener, Looper paramLooper)
    {
      this.c = paramIALocationRequest;
      this.a = paramIALocationListener;
      if (paramLooper != null) {}
      for (this$1 = new Handler(paramLooper);; this$1 = new Handler())
      {
        this.d = az.this;
        return;
      }
    }
    
    final void a(int paramInt, Bundle paramBundle)
    {
      this.a.onStatusChanged("IndoorAtlas", paramInt, paramBundle);
    }
    
    final void a(final IALocation paramIALocation)
    {
      this.d.post(new Runnable()
      {
        public final void run()
        {
          az.e.this.a.onLocationChanged(paramIALocation);
        }
      });
    }
  }
  
  final class f
  {
    @NonNull
    final IARegion.Listener a;
    @Nullable
    IARegion b;
    @Nullable
    IARegion c;
    
    private f(@NonNull IARegion.Listener paramListener)
    {
      this.a = paramListener;
    }
    
    final void a(IARegion paramIARegion)
    {
      if (paramIARegion != null)
      {
        if (paramIARegion.getType() != 2) {
          break label59;
        }
        if (!paramIARegion.equals(this.b))
        {
          if (this.b != null) {
            this.a.onExitRegion(this.b);
          }
          this.a.onEnterRegion(paramIARegion);
        }
        this.b = paramIARegion;
      }
      label59:
      while (paramIARegion.getType() != 1) {
        return;
      }
      if (!paramIARegion.equals(this.c))
      {
        if (this.c != null) {
          this.a.onExitRegion(this.c);
        }
        this.a.onEnterRegion(paramIARegion);
      }
      this.c = paramIARegion;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject instanceof f)) {
        if (((f)paramObject).a != this.a) {}
      }
      do
      {
        return true;
        return false;
        if (!(paramObject instanceof IARegion.Listener)) {
          break;
        }
      } while (paramObject == this.a);
      return false;
      return false;
    }
    
    public final int hashCode()
    {
      return this.a.hashCode();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */