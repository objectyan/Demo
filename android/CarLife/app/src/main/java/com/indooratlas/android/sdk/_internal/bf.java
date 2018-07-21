package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseArray;
import com.indooratlas.algorithm.ClientProcessingManager;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IAOrientationRequest;
import com.indooratlas.android.sdk.internal.DeviceWatchdog;
import com.indooratlas.android.sdk.internal.DeviceWatchdog.a;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public final class bf
{
  public b a;
  ClientProcessingManager b;
  bg c;
  bc d;
  cz e;
  @NonNull
  bi f;
  @NonNull
  co g;
  bm h;
  bn i;
  public bb j;
  bt k;
  bx l;
  ac m;
  bl n;
  public Context o;
  volatile boolean p;
  ca q;
  DeviceWatchdog r;
  public ConnectivityManager s;
  cj t;
  String u;
  public cr v;
  cf w;
  ce x;
  cc y;
  private bk z;
  
  private bf(a parama)
  {
    this.o = parama.a.getApplicationContext();
    this.f = parama.c;
    this.g = new co(this.f);
    Object localObject;
    if (parama.d != null) {
      localObject = parama.d;
    }
    for (;;)
    {
      this.z = ((bk)localObject);
      this.v = bk.b();
      if (parama.f != null)
      {
        localObject = parama.f;
        label74:
        this.y = ((cc)localObject);
      }
      try
      {
        this.c = parama.e.a();
        e();
        Log.d("IACore", f());
        this.t = bk.e(this);
        if (parama.b != null) {}
        for (this.a = new b(parama.b, (byte)0);; this.a = new b((byte)0))
        {
          av.c.c(this.a.b);
          return;
          localObject = new bk();
          break;
          localObject = new cc();
          break label74;
        }
        return;
      }
      catch (bc parama)
      {
        this.c = null;
        this.d = parama;
        a(bh.a(1002, parama, parama.getMessage(), new Object[0]));
      }
    }
  }
  
  static boolean d()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  private void e()
    throws bc
  {
    for (;;)
    {
      int i1;
      try
      {
        ct.a("", "");
        i1 = 0;
        if (i1 >= 4) {
          break;
        }
        String str = new String[] { "android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_WIFI_STATE" }[i1];
        if (this.o.checkCallingOrSelfPermission(str) != 0) {
          throw new bc("permission missing: " + str);
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        throw new bc(localIllegalStateException.toString());
      }
      i1 += 1;
    }
    ArrayList localArrayList = ct.a(this.o, new String[] { "android.hardware.wifi" });
    if (!localArrayList.isEmpty()) {
      throw new bc("missing mandatory feature: " + (String)localArrayList.get(0));
    }
    if ((d()) && (ct.b(this.o)) && (!ct.a(this.o))) {
      ee.a("IASDK", "Permissions for Bluetooth scan missing. Add BLUETOOTH, BLUETOOTH_ADMIN, and ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION permissions to enable BLE scanning", new Object[0]);
    }
  }
  
  private static String f()
  {
    PrintWriter localPrintWriter = new PrintWriter(new StringWriter());
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
      localSimpleDateFormat.setTimeZone(new SimpleTimeZone(2, "UTC"));
      localPrintWriter.println("IndoorAtlas Android SDK");
      localPrintWriter.println(" SDK    : 2.4.2-743");
      localPrintWriter.println(" Android: " + Build.VERSION.RELEASE + "-" + Build.VERSION.SDK_INT);
      localPrintWriter.println(" Date   : " + localSimpleDateFormat.format(new Date()));
      localPrintWriter.close();
      return localPrintWriter.toString();
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public final void a()
  {
    if (!c()) {
      return;
    }
    this.a.a(2).sendToTarget();
  }
  
  final void a(bh parambh)
  {
    ee.a("IASDK", "ERROR: " + parambh.a + ", " + parambh.b, new Object[0]);
    this.f.a(parambh);
  }
  
  public final void a(br parambr, boolean paramBoolean)
  {
    b localb;
    if (c())
    {
      localb = this.a;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i1 = 0;; i1 = 1)
    {
      localb.a(107, i1, -1, parambr);
      return;
    }
  }
  
  public final void b()
  {
    if (!c()) {
      return;
    }
    a();
    this.p = true;
    this.a.a(3).sendToTarget();
  }
  
  public final boolean c()
  {
    return (this.d == null) && (!this.p);
  }
  
  public static final class a
  {
    Context a;
    Looper b;
    bi c;
    bk d;
    public bg.a e;
    public cc f;
    
    public a(Context paramContext, bi parambi)
    {
      this.a = paramContext;
      this.c = ((bi)eg.a(parambi, "SdkEngineListener must be non empty", new Object[0]));
      this.e = new bg.a(paramContext);
    }
  }
  
  public final class b
    extends av
  {
    @Nullable
    IALocationRequest A;
    IAOrientationRequest B = new IAOrientationRequest(-1.0D, -1.0D);
    bt.a C = new bt.a()
    {
      public final void a()
      {
        bf.this.q.a("positioning.ssl-negotiated");
      }
      
      public final void a(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        bf.b localb;
        if (!bf.this.p)
        {
          localb = bf.b.this;
          if (!paramAnonymousBoolean) {
            break label42;
          }
        }
        label42:
        for (int i = 1;; i = 0)
        {
          localb.a(1003, paramAnonymousInt, i, paramAnonymousString).sendToTarget();
          return;
        }
      }
      
      public final void a(long paramAnonymousLong)
      {
        bf.b.this.b(1020);
      }
      
      public final void a(eu.c paramAnonymousc)
      {
        bf.b.this.b(1027, paramAnonymousc);
      }
      
      public final void a(ez.a paramAnonymousa)
      {
        bf.b.this.b(1012, paramAnonymousa);
      }
      
      public final void a(fa.a paramAnonymousa)
      {
        if (!bf.this.p) {
          bf.b.this.a(1008, paramAnonymousa).sendToTarget();
        }
      }
      
      public final void a(fc.c paramAnonymousc)
      {
        if (!bf.this.p) {
          bf.b.this.b(1022, paramAnonymousc);
        }
      }
      
      public final void b()
      {
        if (!bf.this.p)
        {
          bf.this.q.b("positioning.ssl-negotiated");
          bf.this.q.b("positioning.websocket.connected");
          bf.b.this.a(1002).sendToTarget();
        }
      }
    };
    bq D;
    t E = new t()
    {
      public final void a(double paramAnonymousDouble, int paramAnonymousInt)
      {
        bf.this.f.a(paramAnonymousInt);
      }
      
      public final void a(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          bf.this.a.b(2001);
          return;
        }
        bf.this.a.b(2000);
      }
      
      public final void a(int paramAnonymousInt, String paramAnonymousString)
      {
        new StringBuilder("onLogMessage(), logType: ").append(paramAnonymousInt).append(", message: ").append(paramAnonymousString);
      }
      
      public final void a(long paramAnonymousLong, double paramAnonymousDouble)
      {
        new StringBuilder("onHeadingChange(), clientTime = ").append(paramAnonymousLong).append(", heading = ").append(paramAnonymousDouble);
        bf.this.f.a(paramAnonymousLong, paramAnonymousDouble);
      }
      
      public final void a(long paramAnonymousLong, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3, double paramAnonymousDouble4)
      {
        Object localObject1 = bf.this.g;
        Object localObject2 = new ArrayList(1);
        co.a(((co)localObject1).d, ((co)localObject1).b, (Collection)localObject2, true);
        co.a(((co)localObject1).e, ((co)localObject1).c, (Collection)localObject2, false);
        Collections.sort((List)localObject2, co.g);
        Object localObject3;
        if (((ArrayList)localObject2).size() > 0)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (co.a)((Iterator)localObject2).next();
            if (((co.a)localObject3).a) {
              ((co)localObject1).d = ((co.a)localObject3).b;
            }
            for (;;)
            {
              ((co)localObject1).a(paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble3, paramAnonymousDouble4);
              break;
              ((co)localObject1).e = ((co.a)localObject3).b;
            }
          }
        }
        else
        {
          ((co)localObject1).a(paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble3, paramAnonymousDouble4);
        }
        localObject1 = bf.this.g.f;
        localObject1 = bf.this.y.a(paramAnonymousLong, (IALocation)localObject1);
        if (((ArrayList)localObject1).size() > 0)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ax)((Iterator)localObject1).next();
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).addAll(((ax)localObject2).b);
            if (((ArrayList)localObject3).size() > 0) {
              bf.this.f.a((ax)localObject2);
            }
          }
        }
      }
      
      public final void a(long paramAnonymousLong, double[] paramAnonymousArrayOfDouble)
      {
        new StringBuilder("onOrientationChange(), clientTime = ").append(paramAnonymousLong).append(", orientation = ").append(Arrays.toString(paramAnonymousArrayOfDouble));
        bf.this.f.a(paramAnonymousLong, paramAnonymousArrayOfDouble);
      }
      
      public final void a(boolean paramAnonymousBoolean)
      {
        bf.b localb = bf.this.a;
        Object localObject = bf.this.a;
        if (paramAnonymousBoolean) {}
        for (int i = 1014;; i = 1015)
        {
          localObject = ((bf.b)localObject).a(i);
          localb.b.sendMessage((Message)localObject);
          return;
        }
      }
      
      public final void a(byte[] paramAnonymousArrayOfByte)
      {
        bf.this.a.b(1026, paramAnonymousArrayOfByte);
      }
      
      public final void a(byte[] arg1, long paramAnonymousLong1, long paramAnonymousLong2, String arg6)
      {
        new StringBuilder("onLogPacket(), uuid: '").append(???).append("', firstIdx: ").append(paramAnonymousLong1).append(", lastIdx: ").append(paramAnonymousLong2).append(", data length: ").append(???.length);
        if (bf.b.this.D == null)
        {
          localObject1 = bf.b.this;
          Object localObject4 = new bq.a();
          ((bq.a)localObject4).a = bf.this.c.a;
          ((bq.a)localObject4).c = new gh();
          ((bq.a)localObject4).d = bf.this.j.c();
          ((bq.a)localObject4).b = new bq.b() {};
          localObject3 = new bq(((bq.a)localObject4).a, (byte)0);
          ((bq)localObject3).a = ((bq.a)localObject4).c;
          ((bq)localObject3).e = ((bq.a)localObject4).b;
          localObject4 = ((bq.a)localObject4).d;
          if ((localObject4 == null) || (!((String)localObject4).equals(((bq)localObject3).b))) {
            ((bq)localObject3).b();
          }
          ((bq)localObject3).b = ((String)localObject4);
          ((bf.b)localObject1).D = ((bq)localObject3);
        }
        Object localObject1 = bf.b.this.D;
        boolean bool = bf.this.r.g;
        if ((??? == null) || (???.length == 0) || (paramAnonymousLong1 < 0L) || (paramAnonymousLong2 < paramAnonymousLong1) || (??? == null)) {
          return;
        }
        if ((((bq)localObject1).f != null) && (((bq)localObject1).f.equals(???)))
        {
          new StringBuilder("log sending has failed for uuid ").append(???).append(", ignoring");
          return;
        }
        Object localObject3 = new bq.c((bq)localObject1, ???, paramAnonymousLong1, paramAnonymousLong2, ???);
        synchronized (((bq)localObject1).c)
        {
          ((bq)localObject1).c.add(localObject3);
          if (((bq)localObject1).c.size() != 400) {
            break label430;
          }
        }
        synchronized (((bq)localObject1).c)
        {
          if (!((bq)localObject1).c.isEmpty()) {
            ((bq)localObject1).f = ((bq.c)((bq)localObject1).c.get(0)).d;
          }
          ((bq)localObject1).b();
          return;
          ??? = finally;
          throw ???;
        }
        label430:
        if (bool) {
          ((bq)localObject2).a();
        }
        new StringBuilder("newCpaLogPacket added, eventRange: ").append(paramAnonymousLong1).append("-").append(paramAnonymousLong2).append(", uuid: ").append(???).append(", internet active: ").append(bool);
      }
      
      public final void b(byte[] paramAnonymousArrayOfByte)
      {
        bf.this.a.b(1017, paramAnonymousArrayOfByte);
      }
    };
    private boolean G;
    IALocation d;
    @Nullable
    IALocation[] e;
    IALocation f;
    boolean g;
    boolean h = true;
    j i = new a();
    j j = new m();
    j k = new h();
    j l = new c();
    j m = new n();
    j n = new b();
    j o = new i();
    j p = new l();
    j q = new k();
    j r = new g();
    j s = new f();
    j t = new d();
    j u = new e();
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    Boolean z;
    
    private b()
    {
      super();
      d();
    }
    
    private b(Looper paramLooper)
    {
      super(paramLooper);
      d();
    }
    
    private void d()
    {
      a(this.i);
      a(this.j);
      a(this.k);
      a(this.l, this.k);
      a(this.n, this.k);
      a(this.m, this.k);
      a(this.o, this.n);
      a(this.p, this.n);
      a(this.q, this.n);
      a(this.r, this.q);
      a(this.s, this.q);
      a(this.t, this.s);
      a(this.u, this.s);
      j localj = this.j;
      av.c.a(this.b, localj);
    }
    
    protected final void a()
    {
      bm localbm;
      if (bf.this.h != null)
      {
        localbm = bf.this.h;
        localbm.c.removeCallbacksAndMessages(null);
      }
      synchronized (localbm.a)
      {
        localbm.a.clear();
        if (bf.this.q != null)
        {
          ??? = bf.this.q;
          if (!((ca)???).f)
          {
            ((ca)???).g = new CountDownLatch(1);
            ((ca)???).f = true;
            if (((ca)???).e != null) {
              ((ca)???).e.interrupt();
            }
            ((ca)???).a = null;
          }
        }
      }
      try
      {
        ((ca)???).g.await();
        if (bf.this.r != null)
        {
          ??? = bf.this.r;
          ((DeviceWatchdog)???).j.o.unregisterReceiver(((DeviceWatchdog)???).a);
        }
        bf.this.t.close();
        return;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ee.a("IACore", localInterruptedException, "interrupted while waiting writer thread to close", new Object[0]);
        }
      }
    }
    
    final void a(IALocation paramIALocation)
    {
      eg.a(paramIALocation, "location must be non-null", new Object[0]);
      this.d = paramIALocation;
    }
    
    final void a(boolean paramBoolean)
    {
      if ((this.g) && (!paramBoolean)) {
        return;
      }
      bt localbt = bf.this.k;
      fd.a locala = new fd.a();
      locala.d = localbt.c;
      int i1 = localbt.d;
      localbt.d = (i1 + 1);
      locala.b = i1;
      localbt.a(1, locala);
      this.g = true;
    }
    
    final bx b()
    {
      String str;
      Object localObject;
      int i1;
      if ((bf.this.l == null) || (bf.this.l.c()))
      {
        str = bf.this.j.a();
        localObject = bf.this.c.d;
        i1 = bf.this.c.e;
      }
      try
      {
        bf.this.l = bk.a(bf.this, new URI(str), (String)localObject, i1);
        bf.this.k.a(bf.this.l);
        localObject = bf.this.l;
        return (bx)localObject;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        bf.a(bf.this, bh.a(1002, null, "bad positioning endpoint: %s", new Object[] { str }));
        bf.this.k.a(new bw());
        return bf.this.l;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          bf.a(bf.this, bh.a(1001, localIOException, "unexpected error while creating positioning client: %s", new Object[] { localIOException }));
        }
      }
    }
    
    final void c()
    {
      boolean bool2 = false;
      boolean bool1;
      double d2;
      if (this.A != null)
      {
        if (this.A.getFastestInterval() == -1L) {
          break label132;
        }
        bool1 = true;
        if (this.A.getSmallestDisplacement() != -1.0F) {
          bool2 = true;
        }
        d2 = this.A.getSmallestDisplacement();
        if (!bool1) {
          break label138;
        }
      }
      label132:
      label138:
      for (double d1 = this.A.getFastestInterval() / 1000.0D;; d1 = -1.0D)
      {
        if ((bool2) || (bool1)) {
          bf.this.b.configurePredictor(bool2, d2, bool1, d1);
        }
        bf.this.b.configurePredictorHeading(this.B.getHeadingSensitivity());
        bf.this.b.configurePredictorOrientation(this.B.getOrientationSensitivity());
        return;
        bool1 = false;
        break;
      }
    }
    
    final String d(int paramInt)
    {
      Field[] arrayOfField = getClass().getDeclaredFields();
      int i2 = arrayOfField.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = arrayOfField[i1];
        if (((Field)localObject).getGenericType() == Integer.TYPE) {
          try
          {
            if (((Field)localObject).getInt(this) == paramInt)
            {
              localObject = ((Field)localObject).getName();
              return (String)localObject;
            }
          }
          catch (IllegalAccessException localIllegalAccessException) {}
        }
        i1 += 1;
      }
      return "unknown message: " + paramInt;
    }
    
    final class a
      extends bf.b.j
    {
      a()
      {
        super(10);
      }
      
      public final void d()
      {
        Object localObject1 = bf.this;
        bf.this.j = bk.a(new JSONObject());
        bf.this.q = bk.d((bf)localObject1);
        bf.this.n = new bl(bf.this.o);
        bf.this.s = bk.b((bf)localObject1);
        bf.this.h = bk.a();
        bf.this.h.b = new bm.c()
        {
          public final void a(bp paramAnonymousbp)
          {
            bf.this.f.a(paramAnonymousbp);
          }
        };
        Object localObject2 = bf.this.n;
        Object localObject3 = bf.this.c.b;
        Object localObject4 = ((bl)localObject2).a.getString("api.key", null);
        ((bl)localObject2).b.putString("api.key", (String)localObject3);
        if ((localObject4 == null) || (!((String)localObject4).equals(localObject3))) {
          ((bl)localObject2).b.putString("idauuid", ct.a((String)localObject3, UUID.randomUUID().toString()));
        }
        ((bl)localObject2).b();
        bf.this.e = bk.a((bf)localObject1);
        cz.a("IASensor");
        bf.this.b = bk.a(bf.b.this.E);
        bf.this.c.g.getInt("com.indooratlas.android.sdk.intent.extras..cpa.log.level", 0);
        bf.this.m = bk.a(bf.this.c.a, bf.this.c.b, bf.this.c.c, ct.a());
        bf.this.k = bk.a((bf)localObject1, bf.b.this.C);
        bf.this.i = bk.c((bf)localObject1);
        localObject2 = bf.this.i;
        localObject3 = new ArrayList();
        localObject4 = new ArrayList();
        boolean bool3 = false;
        boolean bool4 = false;
        boolean bool1 = false;
        boolean bool5 = false;
        boolean bool2 = false;
        boolean bool8 = false;
        boolean bool9 = false;
        Object localObject5 = ((bn)localObject2).c.a(6);
        if (localObject5 != null)
        {
          ((ArrayList)localObject3).add(localObject5);
          localObject5 = new da.a();
          ((da.a)localObject5).c = 3;
          ((da.a)localObject5).a = ((bn)localObject2).b.a.b;
          ((ArrayList)localObject4).add(((da.a)localObject5).b());
          bool2 = true;
        }
        localObject5 = ((bn)localObject2).c.a(1);
        if (localObject5 != null)
        {
          ((ArrayList)localObject3).add(localObject5);
          localObject5 = new da.a();
          ((da.a)localObject5).c = 0;
          ((da.a)localObject5).a = ((bn)localObject2).b.a.b;
          ((ArrayList)localObject4).add(((da.a)localObject5).b());
          bool3 = true;
        }
        localObject5 = ((bn)localObject2).c.a(4);
        if (localObject5 != null)
        {
          ((ArrayList)localObject3).add(localObject5);
          localObject5 = new da.a();
          ((da.a)localObject5).c = 0;
          ((da.a)localObject5).a = ((bn)localObject2).b.a.b;
          ((ArrayList)localObject4).add(((da.a)localObject5).b());
          bool4 = true;
        }
        localObject5 = ((bn)localObject2).c.a(2);
        if (localObject5 != null)
        {
          ((ArrayList)localObject3).add(localObject5);
          localObject5 = new da.a();
          ((da.a)localObject5).c = 0;
          ((da.a)localObject5).a = ((bn)localObject2).b.a.b;
          ((ArrayList)localObject4).add(((da.a)localObject5).b());
          bool5 = true;
        }
        boolean bool6 = bool1;
        if (Build.VERSION.SDK_INT >= 18)
        {
          localObject5 = ((bn)localObject2).c.a(14);
          bool6 = bool1;
          if (localObject5 != null)
          {
            ((ArrayList)localObject3).add(localObject5);
            localObject5 = new da.a();
            ((da.a)localObject5).c = 0;
            ((da.a)localObject5).a = ((bn)localObject2).b.a.b;
            ((ArrayList)localObject4).add(((da.a)localObject5).b());
            bool6 = true;
          }
        }
        label877:
        boolean bool7;
        label881:
        label954:
        int j;
        label1125:
        int k;
        label1132:
        int i;
        if ((Build.VERSION.SDK_INT >= 23) && (ct.a(((bn)localObject2).b.o, "android.permission.ACCESS_COARSE_LOCATION")))
        {
          ((bn)localObject2).f = ((bn)localObject2).c.a(-100);
          localObject5 = (WifiManager)((bn)localObject2).b.o.getSystemService("wifi");
          if (localObject5 == null) {
            break label1528;
          }
          if ((((bn)localObject2).f == null) || (!cv.a((WifiManager)localObject5)) || (!((WifiManager)localObject5).isWifiEnabled())) {
            break label1522;
          }
          bool1 = true;
          bool7 = bool1;
          bool1 = bool8;
          if (bf.d())
          {
            bool1 = bool8;
            if (ct.a(((bn)localObject2).b.o))
            {
              bool1 = bool8;
              if (ct.b(((bn)localObject2).b.o))
              {
                ((bn)localObject2).g = ((bn)localObject2).c.a(65336);
                if (((bn)localObject2).g == null) {
                  break label1534;
                }
                bool1 = true;
              }
            }
          }
          bool8 = bool9;
          if (ct.a(((bn)localObject2).b.o, "android.permission.ACCESS_FINE_LOCATION"))
          {
            ((bn)localObject2).h = ((bn)localObject2).c.a(65234);
            bool8 = bool9;
            if (((bn)localObject2).h != null) {
              bool8 = true;
            }
          }
          be.a = new be.a(bool6, bool5, bool4, bool3, bool7, bool2, bool1, bool8);
          ((bn)localObject2).d = new cw[((ArrayList)localObject3).size()];
          ((bn)localObject2).d = ((cw[])((ArrayList)localObject3).toArray(((bn)localObject2).d));
          ((bn)localObject2).e = new da[((ArrayList)localObject4).size()];
          ((bn)localObject2).e = ((da[])((ArrayList)localObject4).toArray(((bn)localObject2).e));
          localObject3 = new du(((bn)localObject2).d);
          ((bn)localObject2).a.a((dc)localObject3);
          if (!bool3) {
            break label1540;
          }
          j = 1;
          if (!bool4) {
            break label1545;
          }
          k = 1;
          if ((!bool5) || (!bool6)) {
            break label1550;
          }
          i = 3;
        }
        for (;;)
        {
          label1144:
          if (bool2) {}
          for (int m = 1;; m = 0)
          {
            ((bn)localObject2).i.defineAvailableSensors(j, k, i, m);
            localObject2 = bf.this.i.a;
            bf.this.w = new cf(bf.this.b, bf.this.v);
            ((dd)localObject2).a(bf.this.w);
            ((dd)localObject2).a(new ch(bf.this)
            {
              protected final void a(ff.h paramAnonymoush)
              {
                if (!bf.this.p) {
                  bf.b.this.b(1018, paramAnonymoush);
                }
              }
            });
            if (be.a.i)
            {
              bf.this.x = new ce(bf.this)
              {
                protected final void a(ff.h paramAnonymoush)
                {
                  if (!bf.this.p) {
                    bf.b.this.b(1018, paramAnonymoush);
                  }
                }
              };
              ((dd)localObject2).a(bf.this.x);
            }
            if (be.a.j) {
              ((dd)localObject2).a(new cg(bf.this.v)
              {
                protected final void a(IALocation... paramAnonymousVarArgs)
                {
                  if (!bf.this.p) {
                    bf.b.this.b(1025, paramAnonymousVarArgs);
                  }
                }
              });
            }
            bf.this.r = bk.f((bf)localObject1);
            localObject1 = bf.this.r;
            ((DeviceWatchdog)localObject1).b = new DeviceWatchdog.a()
            {
              public final void a(DeviceWatchdog paramAnonymousDeviceWatchdog)
              {
                bf.this.h.a(paramAnonymousDeviceWatchdog.a(), 0L);
              }
            };
            ((DeviceWatchdog)localObject1).b.a(((DeviceWatchdog)localObject1).c);
            bf.b.this.v = true;
            if ((!be.a.f) && (bf.this.r.a() == 10)) {
              bf.this.h.a(10, 10000L);
            }
            bf.this.q.a("sdk.positioning-started");
            bf.b.this.a(bf.b.this.m);
            return;
            if (Build.VERSION.SDK_INT < 23)
            {
              ((bn)localObject2).f = ((bn)localObject2).c.a(-100);
              break;
            }
            ee.a("IASDK", "no permission to scan wifi", new Object[0]);
            ((bn)localObject2).f = null;
            break;
            label1522:
            bool1 = false;
            break label877;
            label1528:
            bool7 = false;
            break label881;
            label1534:
            bool1 = false;
            break label954;
            label1540:
            j = 0;
            break label1125;
            label1545:
            k = 0;
            break label1132;
            label1550:
            if (bool5)
            {
              i = 1;
              break label1144;
            }
            if (!bool6) {
              break label1576;
            }
            i = 2;
            break label1144;
          }
          label1576:
          i = 0;
        }
      }
    }
    
    final class b
      extends bf.b.j
    {
      b()
      {
        super(50);
      }
      
      final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
          return false;
        }
        int i = paramMessage.what;
        i = paramMessage.arg1;
        bf.b.this.a(bf.b.this.m);
        return true;
      }
      
      final void d()
      {
        bf.b.b(bf.b.this);
      }
      
      final void e()
      {
        bf.b.this.c(104);
        bf.b.a(bf.b.this);
      }
    }
    
    final class c
      extends bf.b.j
    {
      c()
      {
        super(35);
      }
      
      final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
          return false;
        }
        bf.b.c(bf.b.this);
        bf.b.this.a(bf.b.this.p);
        return false;
      }
    }
    
    final class d
      extends bf.b.j
    {
      d()
      {
        super(110);
      }
      
      final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
          return false;
        case 1021: 
          bf.b.this.a(bf.b.this.u);
          return true;
        case 2001: 
          bf.b.this.z = Boolean.valueOf(false);
          if (!bf.b.this.x) {
            bf.b.this.a(1021, 30000L);
          }
          for (;;)
          {
            return false;
            bf.b.this.a(bf.b.this.u);
          }
        case 1022: 
          if ((bf.b.this.z == Boolean.FALSE) && (cp.a((fc.c)paramMessage.obj)))
          {
            bf.b.this.c(1021);
            bf.b.this.a(bf.b.this.u);
          }
          return false;
        }
        paramMessage = Boolean.FALSE;
        bf.b.this.c(1021);
        return false;
      }
      
      final void d()
      {
        bf.b.this.h = false;
      }
    }
    
    final class e
      extends bf.b.j
    {
      e()
      {
        super(105);
      }
      
      final boolean b(Message paramMessage)
      {
        boolean bool = true;
        switch (paramMessage.what)
        {
        default: 
          bool = false;
        case 1017: 
          return bool;
        }
        bf.b.this.z = Boolean.valueOf(true);
        bf.b.this.a(bf.b.this.t);
        return true;
      }
      
      final void d()
      {
        bf.this.i.c();
        bn localbn = bf.this.i;
        cw localcw = localbn.c.a(1);
        cz localcz = localbn.c;
        dd localdd = localbn.a;
        da.a locala = new da.a();
        locala.c = 3;
        locala.a = localbn.b.a.b;
        localcz.a(localdd, localcw, locala.b());
        localcw.a();
        bf.b.this.c(108);
      }
      
      final void e()
      {
        bf.this.i.c();
        bf.this.i.a();
        bf.b.h(bf.b.this);
      }
    }
    
    final class f
      extends bf.b.j
    {
      f()
      {
        super(100);
      }
      
      final boolean b(Message paramMessage)
      {
        int j = 0;
        bt localbt;
        Object localObject;
        int i;
        switch (paramMessage.what)
        {
        default: 
          return false;
        case 6: 
          bf.this.k.a(3, new fe.a());
          bf.b.d(bf.b.this);
          bf.b.this.a(bf.b.this.r);
          return true;
        case 7: 
          bf.b.a(bf.b.this, paramMessage);
          bf.b.g(bf.b.this);
          return true;
        case 1025: 
          bf.this.k.a((IALocation[])paramMessage.obj);
          return true;
        case 1018: 
          localbt = bf.this.k;
          paramMessage = (ff.h)paramMessage.obj;
          localObject = localbt.e();
          ((fb.c)localObject).f = paramMessage;
          if (paramMessage.d != null)
          {
            i = paramMessage.d.b.length;
            if (paramMessage.e == null) {
              break label298;
            }
            i = paramMessage.e.b.length;
            if (paramMessage.g == null) {
              break label303;
            }
          }
          for (i = paramMessage.g.d.length;; i = 0)
          {
            i = j;
            if (paramMessage.g != null) {
              i = paramMessage.g.b.length;
            }
            localbt.a(2, (m)localObject);
            return true;
            i = 0;
            break;
            i = 0;
            break label249;
          }
        case 1026: 
          bf.b.this.a(false);
          localbt = bf.this.k;
          paramMessage = (byte[])paramMessage.obj;
          if ((bt.a) && (paramMessage != null))
          {
            localObject = bt.a(paramMessage);
            long l = ((fg.e)localObject).b;
            localbt.i.a();
            i = paramMessage.length;
            localbt.e = bt.a(localbt.e, ((fg.e)localObject).b);
            if (localbt.e < localbt.f) {
              ee.a("IAWire", "last track node time < track radio time; %d < %d", new Object[] { Long.valueOf(localbt.e), Long.valueOf(localbt.f) });
            }
          }
          localObject = localbt.e();
          fb.e locale = new fb.e();
          locale.d = new fb.f[] { new fb.f() };
          locale.d[0].d = paramMessage;
          locale.d[0].b = localbt.i.a();
          ((fb.c)localObject).e = locale;
          localbt.a(2, (m)localObject);
          return true;
        case 1023: 
          bf.this.i.a(true);
          bf.b.h(bf.b.this);
          return true;
        case 1024: 
          bf.this.i.a(false);
          bf.b.this.c(108);
          return true;
        case 1008: 
          paramMessage = (fa.a)paramMessage.obj;
          if ("setup_required".equals(paramMessage.b))
          {
            bf.b.this.a(true);
            return true;
          }
          ee.a("IACore", "error not handled: code %s, msg: %s", new Object[] { paramMessage.b, paramMessage.d });
          return false;
        case 108: 
          label249:
          label298:
          label303:
          bf.this.i.g();
          return true;
        }
        paramMessage = (eu.c)paramMessage.obj;
        if ((paramMessage != null) && (paramMessage.b != null))
        {
          i = paramMessage.b.d;
          bf.this.i.a(i * 1000);
          if (bf.this.x != null) {
            bf.this.x.a(paramMessage.b);
          }
          bf.b.h(bf.b.this);
        }
        return true;
      }
      
      final void d()
      {
        if (!bf.b.this.x) {
          bf.this.q.a("positioning.first-fix");
        }
        bf.b.this.a(false);
        bf.b localb = bf.b.this;
        if (bf.a(localb.F, "com.indooratlas.android.sdk.intent.extras.feature_platform_locations", true))
        {
          cw localcw1 = localb.F.e.a(65236);
          cw localcw2 = localb.F.e.a(65235);
          ArrayList localArrayList = new ArrayList();
          if (localcw1 != null) {
            localArrayList.addAll(localb.F.e.a(localcw1));
          }
          if (localcw2 != null) {
            localArrayList.addAll(localb.F.e.a(localcw2));
          }
          if (localArrayList.size() > 0)
          {
            localb.e = new IALocation[localArrayList.size()];
            int i = 0;
            while (i < localArrayList.size())
            {
              localb.e[i] = ct.a((cx)localArrayList.get(i)).newBuilder().withLongExtra("com.indooratlas.android.sdk.intent.extras.clientTime", localb.F.v.a()).build();
              i += 1;
            }
            Arrays.toString(localb.e);
          }
        }
        bf.b.g(bf.b.this);
        localb = bf.b.this;
        if (localb.e != null)
        {
          localb.F.k.a(localb.e);
          localb.e = null;
        }
      }
    }
    
    final class g
      extends bf.b.j
    {
      private float d;
      
      g()
      {
        super(90);
      }
      
      final boolean b(Message paramMessage)
      {
        boolean bool = true;
        switch (paramMessage.what)
        {
        default: 
          bool = false;
        case 1016: 
          return bool;
        case 5: 
          av.c.a(bf.b.this.b, paramMessage);
          bf.b.this.a(bf.b.this.t);
          return true;
        case 7: 
          bf.b.a(bf.b.this, paramMessage);
          return true;
        case 1010: 
          bf.b.this.a(bf.b.this.l);
          return true;
        }
        bf.b.f(bf.b.this);
        return false;
      }
      
      final void d()
      {
        this.d = 0.0F;
        if (bf.a(bf.this, "com.indooratlas.android.sdk.intent.extras.feature_enable_message_buffer", false)) {
          bf.this.k.a(false);
        }
        if (bf.this.j.b.optBoolean("positioningHibernateEnabled", true))
        {
          new StringBuilder("Hibernate enabled, timeout for closing sockets: ").append(bf.this.j.b());
          bf.b.this.a(1010, bf.this.j.b());
        }
        if (bf.b.this.h) {
          bf.b.e(bf.b.this);
        }
      }
      
      final void e()
      {
        bf.b.this.c(1010);
        bf.b.f(bf.b.this);
      }
    }
    
    final class h
      extends bf.b.j
    {
      h()
      {
        super(30);
      }
      
      final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
        case 1022: 
        case 2: 
        case 104: 
        case 7: 
        case 5: 
        case 6: 
        case 1012: 
        case 105: 
        case 106: 
        case 107: 
          for (;;)
          {
            return false;
            Object localObject1 = bf.b.this;
            Object localObject2 = (fc.c)paramMessage.obj;
            paramMessage = ((bf.b)localObject1).F.g;
            long l = System.currentTimeMillis();
            paramMessage.a = ((fc.c)localObject2);
            if ((localObject2 != null) && (((fc.c)localObject2).e != null))
            {
              if (((fc.c)localObject2).e.b != null) {
                paramMessage.b = cp.a(((fc.c)localObject2).e, l);
              }
            }
            else
            {
              if ((localObject2 != null) && (((fc.c)localObject2).d != null))
              {
                if (((fc.c)localObject2).d.b == null) {
                  break label550;
                }
                paramMessage.c = cp.a(((fc.c)localObject2).d, l);
              }
              if (cp.a((fc.c)localObject2))
              {
                if (((fc.c)localObject2).b.b.i.length != 0) {
                  break label558;
                }
                paramMessage = new double[4];
                Message tmp277_276 = paramMessage;
                tmp277_276[0] = 1.0D;
                Message tmp281_277 = tmp277_276;
                tmp281_277[1] = 0.0D;
                Message tmp285_281 = tmp281_277;
                tmp285_281[2] = 0.0D;
                Message tmp289_285 = tmp285_281;
                tmp289_285[3] = 0.0D;
                tmp289_285;
              }
            }
            for (;;)
            {
              double d1 = 0.0D;
              double d2 = 0.0D;
              boolean bool = false;
              if (((fc.c)tmp285_281).b.d != null)
              {
                d1 = ((fc.c)tmp285_281).b.d.b;
                d2 = ((fc.c)tmp285_281).b.d.d;
                bool = true;
              }
              ((bf.b)tmp281_277).F.b.addPosition(((fc.c)tmp285_281).b.b.h, ((fc.c)tmp285_281).b.b.b.b, ((fc.c)tmp285_281).b.b.b.d, ((fc.c)tmp285_281).b.b.k, ((fc.c)tmp285_281).b.b.e, ((fc.c)tmp285_281).b.b.j, paramMessage, d1, d2, bool);
              if (!((bf.b)tmp281_277).x)
              {
                ((bf.b)tmp281_277).F.q.b("positioning.first-fix");
                ((bf.b)tmp281_277).x = true;
                if (bf.a(((bf.b)tmp281_277).F, "com.indooratlas.android.sdk.intent.extras.feature_enable_message_buffer", false))
                {
                  paramMessage = ((bf.b)tmp281_277).F.k.b();
                  paramMessage.b = 10;
                  if ((paramMessage.b <= paramMessage.c.size()) && (!paramMessage.c.isEmpty())) {
                    paramMessage.a.a();
                  }
                  ((bf.b)tmp281_277).F.k.a(true);
                }
              }
              return true;
              paramMessage.b = null;
              break;
              paramMessage.c = null;
              break label249;
              paramMessage = ((fc.c)tmp285_281).b.b.i;
            }
            bf.b.this.a(bf.b.this.j);
            return true;
            bf.b.b(bf.b.this);
            return true;
            bf.b.this.a((IALocation)paramMessage.obj);
            return true;
            tmp281_277 = bf.b.this;
            ((bf.b)tmp281_277).A = ((IALocationRequest)paramMessage.obj);
            ((bf.b)tmp281_277).c();
            bf.b.c(bf.b.this);
            return true;
            bf.b.d(bf.b.this);
            return true;
            tmp281_277 = (ez.a)paramMessage.obj;
            if (((ez.a)tmp281_277).e != null)
            {
              paramMessage = bf.this.b;
              tmp281_277 = ((ez.a)tmp281_277).e;
              tmp285_281 = ByteBuffer.allocateDirect(tmp281_277.length);
              ((ByteBuffer)tmp285_281).put((byte[])tmp281_277);
              ((ByteBuffer)tmp285_281).flip();
              paramMessage.setParameters((ByteBuffer)tmp285_281);
              bf.b.this.c();
            }
            return true;
            paramMessage = (dc)paramMessage.obj;
            bf.this.i.a.a(paramMessage);
            continue;
            tmp285_281 = (dc)paramMessage.obj;
            tmp281_277 = bf.this.i.a;
            paramMessage = ((dd)tmp281_277).b;
            tmp285_281 = new ec.a(tmp285_281);
            int j;
            if (paramMessage != null)
            {
              j = paramMessage.length;
              i = 0;
              if (i < j) {
                if (((ec.b)tmp285_281).a(paramMessage[i])) {
                  if (i != -1) {
                    break label888;
                  }
                }
              }
            }
            for (;;)
            {
              paramMessage = (dc[])paramMessage;
              if (paramMessage.length == ((dd)tmp281_277).a) {
                break;
              }
              ((dd)tmp281_277).b = paramMessage;
              ((dd)tmp281_277).a -= 1;
              break;
              i += 1;
              break label807;
              i = -1;
              break label828;
              if (paramMessage != null) {}
              for (j = paramMessage.length; i >= j; j = 0) {
                throw new IndexOutOfBoundsException("index: " + i + ", length: " + j);
              }
              tmp285_281 = Array.newInstance(paramMessage.getClass().getComponentType(), j - 1);
              System.arraycopy(paramMessage, 0, tmp285_281, 0, i);
              if (i < j - 1) {
                System.arraycopy(paramMessage, i + 1, tmp285_281, i, j - i - 1);
              }
              paramMessage = (Object[])tmp285_281;
            }
            tmp281_277 = (br)paramMessage.obj;
            if (paramMessage.arg1 == 0) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label1083;
              }
              paramMessage = bf.this.k;
              if (paramMessage.k == null) {
                paramMessage.k = new br.a();
              }
              paramMessage.k.a((br)tmp281_277);
              break;
            }
            paramMessage = bf.this.k;
            if (paramMessage.l == null) {
              paramMessage.l = new br.a();
            }
            paramMessage.l.a((br)tmp281_277);
          }
        case 108: 
          bf.this.i.g();
          return true;
        case 8: 
          bf.b.this.B = ((IAOrientationRequest)paramMessage.obj);
          bf.b.this.c();
          return true;
        case 1025: 
          return false;
        case 109: 
          label249:
          label550:
          label558:
          label807:
          label828:
          label888:
          label1083:
          paramMessage = (ay)paramMessage.obj;
          bf.b.a(bf.b.this, paramMessage);
          return true;
        }
        paramMessage = (List)paramMessage.obj;
        bf.b.a(bf.b.this, paramMessage);
        return true;
      }
      
      final void d()
      {
        bf.b.this.x = false;
      }
      
      final void e()
      {
        bf.this.i.c();
        bf.b.this.c(104);
      }
    }
    
    final class i
      extends bf.b.j
    {
      private aa<JSONObject> d;
      private long e;
      
      i()
      {
        super(55);
      }
      
      private void f()
      {
        long l = this.e;
        if (l == 0L) {}
        for (l = 1000L;; l = Math.min(30000L, l * 2L))
        {
          this.e = l;
          l = this.e;
          bf.b.this.a(100, this.e);
          return;
        }
      }
      
      final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
        case 1004: 
          for (;;)
          {
            return false;
            this.e = 0L;
            bf.this.q.b("sdk.initialized");
            paramMessage = (JSONObject)paramMessage.obj;
            if (ct.a(paramMessage) == null)
            {
              bf.this.n.a();
              bf.this.j.a(paramMessage);
              bf.this.u = bf.this.j.c();
              bf.b.this.w = true;
              bf.this.f.a(paramMessage);
              bf.b.b(bf.b.this);
              bf.b.this.a(bf.b.this.p);
            }
            else
            {
              f();
            }
          }
        case 1005: 
          paramMessage = (ad)paramMessage.obj;
          ad.a locala = paramMessage.a;
          bf.this.q.d.remove("sdk.initialized");
          if (locala != ad.a.a)
          {
            if (locala != ad.a.b) {
              break label332;
            }
            switch (paramMessage.b.b())
            {
            }
          }
          for (;;)
          {
            bf.this.h.a(1, 5000L);
            f();
            break;
            bf.this.h.a(0, 0L);
            bf.this.a(bh.a(1001, null, "SDK initializing failed, unauthorized, please check your api keys", new Object[0]));
            bf.this.b();
            return true;
            label332:
            if (locala != ad.a.c) {
              paramMessage = ad.a.d;
            }
          }
        }
        bf.b.this.a(bf.b.this.m);
        return true;
      }
      
      final void d()
      {
        final boolean bool1 = true;
        bf.b.a(bf.b.this);
        bf.this.v.c();
        Object localObject = bf.this.k;
        ((bt)localObject).g = 0;
        ((bt)localObject).g = 0;
        ((bt)localObject).j = 0;
        ((bt)localObject).h = ((bt)localObject).i.a();
        ((bt)localObject).d = 0;
        ((bt)localObject).c = 0;
        boolean bool2 = bf.this.r.g;
        if (this.d != null) {
          this.d.a();
        }
        bf.this.q.a("sdk.initialized");
        final JSONObject localJSONObject = ct.a(cz.a(bf.this.o).a());
        int i;
        label238:
        ac localac;
        ai localai;
        Context localContext;
        String str;
        if (localJSONObject != null)
        {
          localObject = bf.this.n;
          System.currentTimeMillis();
          if ((((bl)localObject).a.getBoolean("sensorInfoFlag", false)) || (((bl)localObject).a.getLong("sensorInfoSent", 0L) == 0L) || (!bl.a(localJSONObject).equals(((bl)localObject).a.getString("sensorInfoSha", ""))))
          {
            i = 1;
            if (i == 0) {
              break label342;
            }
            localac = bf.this.m;
            localai = new ai();
            localContext = bf.this.o;
            str = bf.this.n.a();
            if (!bool1) {
              break label347;
            }
          }
        }
        label342:
        label347:
        for (localObject = localJSONObject;; localObject = null)
        {
          this.d = localac.a(localai, ct.a(localContext, str, (JSONObject)localObject));
          this.d.a(new ag()
          {
            public final void a(ad paramAnonymousad)
            {
              if (!bf.this.p) {
                bf.b.this.b(1005, paramAnonymousad);
              }
            }
            
            public final void a(ae<JSONObject> paramAnonymousae)
            {
              if (bool1)
              {
                bl localbl = bf.this.n;
                long l = System.currentTimeMillis();
                JSONObject localJSONObject = localJSONObject;
                localbl.b.putLong("sensorInfoSent", l);
                localbl.b.putString("sensorInfoSha", bl.a(localJSONObject));
                localbl.b.putBoolean("sensorInfoFlag", false);
                localbl.b();
              }
              bf.b.this.b(1004, paramAnonymousae.b);
            }
          });
          return;
          i = 0;
          break;
          bool1 = false;
          break label238;
        }
      }
      
      final void e()
      {
        if (this.d != null) {
          this.d.a();
        }
      }
    }
    
    abstract class j
      extends au
    {
      final int b;
      
      j(int paramInt)
      {
        this.b = paramInt;
      }
      
      public final void a()
      {
        new StringBuilder("==> enter: ").append(c());
        d();
        bf.this.f.a(c());
      }
      
      public final boolean a(Message paramMessage)
      {
        c();
        bf.b.this.d(paramMessage.what);
        int i = paramMessage.arg1;
        i = paramMessage.arg2;
        if (paramMessage.what == 3)
        {
          av.c.b(bf.b.this.b);
          return true;
        }
        return b(paramMessage);
      }
      
      public final void b()
      {
        new StringBuilder("<== exit: ").append(c());
        e();
        bf.this.f.b(c());
      }
      
      boolean b(Message paramMessage)
      {
        return false;
      }
      
      void d() {}
      
      void e() {}
      
      public String toString()
      {
        return c();
      }
    }
    
    final class k
      extends bf.b.j
    {
      k()
      {
        super(65);
      }
      
      public final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
          return false;
        case 1003: 
          int i = paramMessage.arg1;
          paramMessage = (String)paramMessage.obj;
          if (!bf.b.a(bf.b.this, i, paramMessage))
          {
            bf.this.h.a(1, 5000L);
            bf.b.this.a(bf.b.this.p);
          }
          return true;
        }
        paramMessage = (byte[])paramMessage.obj;
        bt localbt = bf.this.k;
        fb.c localc = localbt.e();
        fb.a locala = new fb.a();
        locala.d = paramMessage;
        locala.b = localbt.i.a();
        localc.i = new fb.a[] { locala };
        localbt.a(2, localc);
        return true;
      }
      
      final void e()
      {
        bf.b.a(bf.b.this);
      }
    }
    
    final class l
      extends bf.b.j
    {
      private long d;
      
      l()
      {
        super(60);
      }
      
      public final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
          return false;
        case 1002: 
          bf.this.h.a(bf.this.r.a(), 0L);
          this.d = 0L;
          if (bf.b.this.y) {
            bf.b.this.a(bf.b.this.t);
          }
          for (;;)
          {
            return true;
            bf.b.this.a(bf.b.this.r);
          }
        case 1003: 
          int i = paramMessage.arg1;
          paramMessage = (String)paramMessage.obj;
          boolean bool = bf.b.a(bf.b.this, i, paramMessage);
          if (!bool)
          {
            bf.this.h.a(1, 5000L);
            if (this.d != 0L) {
              break label214;
            }
          }
          label214:
          for (long l = 500L;; l = this.d * 2L)
          {
            this.d = Math.min(30000L, l);
            l = this.d;
            bf.b.this.a(100, this.d);
            if (!bool) {
              break;
            }
            return true;
          }
          return false;
        }
        bf.b.this.a(bf.b.this.m);
        return true;
      }
      
      final void d()
      {
        boolean bool = bf.this.r.g;
        bf.this.q.a("positioning.websocket.connected");
        bf.b.this.b().a();
      }
      
      final void e()
      {
        bf.b.this.c(100);
      }
    }
    
    final class m
      extends bf.b.j
    {
      m()
      {
        super(15);
      }
      
      public final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
          return false;
        }
        if (bf.b.this.v) {
          bf.b.this.a(bf.b.this.m);
        }
        for (;;)
        {
          return true;
          bf.b.this.a(bf.b.this.i);
        }
      }
    }
    
    final class n
      extends bf.b.j
    {
      n()
      {
        super(40);
      }
      
      private void f()
      {
        bm localbm = bf.this.h;
        localbm.c.removeMessages(1);
        synchronized (localbm.a)
        {
          localbm.a.remove(1);
          if (bf.b.this.w)
          {
            bf.b.this.a(bf.b.this.p);
            return;
          }
        }
        bf.b.this.a(bf.b.this.o);
      }
      
      public final boolean b(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          return false;
          f();
        }
      }
      
      final void d()
      {
        int i = 1;
        bf.this.h.a(1, 5000L);
        NetworkInfo localNetworkInfo = bf.this.s.getActiveNetworkInfo();
        if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting())) {}
        for (;;)
        {
          if (i != 0) {
            f();
          }
          return;
          i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */