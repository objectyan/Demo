package com.baidu.carlife.logic;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.bluetooth.b;
import com.baidu.carlife.bluetooth.b.a;
import com.baidu.carlife.bluetooth.d;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.n;
import com.baidu.carlife.util.w;
import com.baidu.carlife.util.x;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.CharacterParser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class q
{
  private static final String b = q.class.getSimpleName();
  private static final SimpleDateFormat c = new SimpleDateFormat("HH:mm");
  private static final SimpleDateFormat d = new SimpleDateFormat("yy/MM/dd");
  private static final int e = 1;
  private static final String[] f = { "display_name", "data1", "data2" };
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final String[] j = { "name", "number", "type", "date" };
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static q o;
  private boolean A;
  private boolean B;
  private List<a> C;
  private boolean D;
  private boolean E;
  private boolean F = false;
  private Handler G = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
      } while (q.a(q.this) == null);
      i.b(q.n(), "onloadedCallLog");
      q.a(q.this).b();
    }
  };
  private b.a H = new b.a()
  {
    public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      q.a(q.this, false);
      if (paramAnonymousInt2 == 0) {}
      for (;;)
      {
        return;
        Iterator localIterator;
        switch (paramAnonymousInt1)
        {
        case 4: 
        default: 
          return;
        case 3: 
          if (q.c(q.this) != null)
          {
            localIterator = q.c(q.this).iterator();
            while (localIterator.hasNext()) {
              ((q.a)localIterator.next()).a();
            }
          }
          break;
        case 5: 
          if (q.c(q.this) != null)
          {
            localIterator = q.c(q.this).iterator();
            while (localIterator.hasNext()) {
              ((q.a)localIterator.next()).a(paramAnonymousInt3);
            }
          }
          break;
        case 6: 
          if (q.c(q.this) != null)
          {
            localIterator = q.c(q.this).iterator();
            while (localIterator.hasNext())
            {
              ((q.a)localIterator.next()).b();
              q.b(q.this, true);
            }
          }
          break;
        case 7: 
          if (q.c(q.this) != null)
          {
            localIterator = q.c(q.this).iterator();
            while (localIterator.hasNext())
            {
              ((q.a)localIterator.next()).c();
              q.b(q.this, false);
            }
          }
          break;
        }
      }
    }
  };
  private d I = new d()
  {
    public void a() {}
    
    public void a(boolean paramAnonymousBoolean)
    {
      if (q.d(q.this) != paramAnonymousBoolean) {
        q.a(q.this, q.this.c(), paramAnonymousBoolean);
      }
      q.c(q.this, paramAnonymousBoolean);
      i.b("Bt", "isBTConnected = " + q.d(q.this));
    }
    
    public void b() {}
    
    public void c()
    {
      if ((q.e(q.this) == null) || (q.e(q.this).isEmpty())) {
        return;
      }
      if (q.f(q.this))
      {
        localIterator = q.e(q.this).iterator();
        while (localIterator.hasNext()) {
          ((q.g)localIterator.next()).d(false);
        }
      }
      Iterator localIterator = q.e(q.this).iterator();
      while (localIterator.hasNext()) {
        ((q.g)localIterator.next()).a();
      }
      q.d(q.this, false);
    }
    
    public void d() {}
    
    public void e()
    {
      if ((q.e(q.this) == null) || (q.e(q.this).isEmpty())) {
        return;
      }
      Iterator localIterator = q.e(q.this).iterator();
      while (localIterator.hasNext()) {
        ((q.g)localIterator.next()).d(true);
      }
      q.d(q.this, true);
    }
  };
  f a = null;
  private TelephonyManager p;
  private boolean q;
  private List<g> r;
  private Map<String, String> s;
  private d t;
  private List<n> u;
  private List<com.baidu.carlife.model.m> v;
  private b w;
  private volatile boolean x;
  private String y;
  private b z;
  
  public static String a(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return d.format(paramDate);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.r == null) || (this.r.isEmpty())) {}
    for (;;)
    {
      return;
      switch (paramInt)
      {
      default: 
        localIterator = this.r.iterator();
        while (localIterator.hasNext()) {
          ((g)localIterator.next()).a(paramBoolean);
        }
      case 1: 
        localIterator = this.r.iterator();
        while (localIterator.hasNext()) {
          ((g)localIterator.next()).b(paramBoolean);
        }
      }
      Iterator localIterator = this.r.iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).c(paramBoolean);
      }
    }
  }
  
  private void a(Cursor paramCursor, com.baidu.carlife.model.m paramm)
  {
    paramm.a = paramCursor.getString(0);
    if (TextUtils.isEmpty(paramm.a)) {
      paramm.a = c(paramm.b);
    }
    paramm.c = 1;
    this.v.add(paramm);
  }
  
  private void a(List<n> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        Collections.sort(paramList, new Comparator()
        {
          public int a(n paramAnonymousn1, n paramAnonymousn2)
          {
            if ((TextUtils.isEmpty(paramAnonymousn1.c)) || (TextUtils.isEmpty(paramAnonymousn2.c))) {
              return 0;
            }
            if (paramAnonymousn1.c.equals(paramAnonymousn2.c)) {
              return paramAnonymousn1.a.compareTo(paramAnonymousn2.a);
            }
            return paramAnonymousn1.c.compareTo(paramAnonymousn2.c);
          }
        });
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          n localn1 = (n)paramList.next();
          if (!this.u.isEmpty())
          {
            n localn2 = (n)this.u.get(this.u.size() - 1);
            if ((!TextUtils.isEmpty(localn2.a)) && (localn2.a.equals(localn1.a)))
            {
              localn2.g = true;
              localn1.f = true;
            }
          }
          this.u.add(localn1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i.a(localException);
        }
      }
    }
  }
  
  private Object b(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Method localMethod = paramContext.getClass().getDeclaredMethod("getITelephony", new Class[0]);
      localMethod.setAccessible(true);
      paramContext = localMethod.invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296833);
    case 2: 
      return BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296832);
    case 1: 
      return BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296831);
    }
    return BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296830);
  }
  
  public static String b(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return c.format(paramDate);
  }
  
  private String b(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)paramList.get(0));
    int i1 = 1;
    while (i1 < paramList.size())
    {
      localStringBuilder.append(",").append((String)paramList.get(i1));
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void b(Context paramContext, String paramString)
  {
    Uri localUri = Uri.parse("tel:" + paramString);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.CALL");
    localIntent.setData(localUri);
    localIntent.setFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      this.y = c(paramString);
      StatisticManager.onEvent("PHONE_0002");
      return;
    }
    catch (SecurityException paramContext)
    {
      i.b(b, paramContext.toString());
      w.a(2131296643, 0);
      return;
    }
    catch (Exception paramContext)
    {
      i.b(b, paramContext.toString());
      w.a(2131296642, 0);
    }
  }
  
  private String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.replaceAll("CH", "C").replaceAll("SH", "S").replaceAll("ZH", "Z").replace(" ", "");
  }
  
  public static q f()
  {
    if (o == null) {
      o = new q();
    }
    return o;
  }
  
  private void o()
  {
    this.p = ((TelephonyManager)BaiduNaviApplication.getInstance().getSystemService("phone"));
    this.a = new f(null);
    this.p.listen(this.a, 32);
    if (b.a().A) {
      this.F = true;
    }
    this.z = b.a();
    this.z.a(this.I);
    this.z.a(this.H);
  }
  
  private void p()
  {
    k.a().a(1, 0);
    if (!com.baidu.carlife.l.a.a().N()) {
      return;
    }
    Object localObject = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject).c(65558);
    localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
    com.baidu.carlife.l.a.a().a((Message)localObject);
  }
  
  private void q()
  {
    BaiduNaviApplication.getInstance().getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, true, new c(null));
  }
  
  private List<String> r()
  {
    Object localObject2 = BaiduNaviApplication.getInstance().getContentResolver();
    localObject1 = null;
    com.baidu.carlife.core.k.a(4027, 400);
    try
    {
      localObject2 = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, f, null, null, null);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i.e(b, "queryPhoneContacts Exception:" + localException.toString());
      }
      this.s = new HashMap();
      this.u = new ArrayList();
      SparseArray localSparseArray = new SparseArray();
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        Object localObject3 = ((Cursor)localObject1).getString(1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = ((String)localObject3).replaceAll("[-() ]+", "");
          Object localObject4 = ((Cursor)localObject1).getString(0);
          if ((!this.s.containsKey(localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
            this.s.put(localObject3, localObject4);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            localArrayList.add(localObject4);
          }
          String str = e.f((String)localObject4);
          char c1 = '\000';
          if (!TextUtils.isEmpty(str)) {
            c1 = str.charAt(0);
          }
          char c2;
          if (c1 >= 'A')
          {
            c2 = c1;
            if (c1 <= 'Z') {}
          }
          else
          {
            c2 = '#';
          }
          n localn = new n();
          localn.a = ((String)localObject4);
          localn.b = ((String)localObject3);
          localn.c = str;
          localn.d = c2;
          localObject4 = (List)localSparseArray.get(c2);
          localObject3 = localObject4;
          if (localObject4 == null)
          {
            localObject3 = new ArrayList();
            localSparseArray.put(c2, localObject3);
          }
          ((List)localObject3).add(localn);
        }
      }
      ((Cursor)localObject1).close();
      int i1 = 65;
      while (i1 <= 90)
      {
        a((List)localSparseArray.get(i1));
        i1 += 1;
      }
      a((List)localSparseArray.get(35));
      return localArrayList;
    }
    com.baidu.carlife.core.k.a(4027);
    com.baidu.carlife.core.k.b(4028);
    if (localObject1 == null) {
      return null;
    }
  }
  
  /* Error */
  private void s()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 593	com/baidu/carlife/logic/q:x	Z
    //   7: new 595	java/util/Date
    //   10: dup
    //   11: invokespecial 596	java/util/Date:<init>	()V
    //   14: astore 5
    //   16: invokestatic 601	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   19: astore 4
    //   21: aload 4
    //   23: aload 5
    //   25: invokevirtual 605	java/util/Calendar:setTime	(Ljava/util/Date;)V
    //   28: aload 4
    //   30: iconst_5
    //   31: aload 4
    //   33: iconst_5
    //   34: invokevirtual 608	java/util/Calendar:get	(I)I
    //   37: iconst_1
    //   38: isub
    //   39: invokevirtual 611	java/util/Calendar:set	(II)V
    //   42: aload 5
    //   44: invokestatic 613	com/baidu/carlife/logic/q:a	(Ljava/util/Date;)Ljava/lang/String;
    //   47: astore 6
    //   49: aload 4
    //   51: invokevirtual 617	java/util/Calendar:getTime	()Ljava/util/Date;
    //   54: invokestatic 613	com/baidu/carlife/logic/q:a	(Ljava/util/Date;)Ljava/lang/String;
    //   57: astore 7
    //   59: invokestatic 330	com/baidu/carlife/BaiduNaviApplication:getInstance	()Lcom/baidu/carlife/BaiduNaviApplication;
    //   62: invokevirtual 334	com/baidu/carlife/BaiduNaviApplication:getApplicationContext	()Landroid/content/Context;
    //   65: ldc_w 618
    //   68: invokevirtual 336	android/content/Context:getString	(I)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 4
    //   75: iconst_2
    //   76: aload 4
    //   78: iconst_2
    //   79: invokevirtual 608	java/util/Calendar:get	(I)I
    //   82: iconst_1
    //   83: isub
    //   84: invokevirtual 611	java/util/Calendar:set	(II)V
    //   87: aload 4
    //   89: invokevirtual 617	java/util/Calendar:getTime	()Ljava/util/Date;
    //   92: invokevirtual 621	java/util/Date:getTime	()J
    //   95: lstore_2
    //   96: invokestatic 330	com/baidu/carlife/BaiduNaviApplication:getInstance	()Lcom/baidu/carlife/BaiduNaviApplication;
    //   99: invokevirtual 509	com/baidu/carlife/BaiduNaviApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   102: astore 9
    //   104: aconst_null
    //   105: astore 4
    //   107: sipush 4027
    //   110: sipush 400
    //   113: invokestatic 527	com/baidu/carlife/core/k:a	(II)V
    //   116: aload 9
    //   118: getstatic 515	android/provider/CallLog$Calls:CONTENT_URI	Landroid/net/Uri;
    //   121: getstatic 135	com/baidu/carlife/logic/q:j	[Ljava/lang/String;
    //   124: ldc_w 623
    //   127: iconst_1
    //   128: anewarray 117	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: lload_2
    //   134: invokestatic 627	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   137: aastore
    //   138: ldc_w 629
    //   141: invokevirtual 534	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   144: astore 5
    //   146: aload 5
    //   148: astore 4
    //   150: sipush 4027
    //   153: invokestatic 536	com/baidu/carlife/core/k:a	(I)V
    //   156: sipush 4028
    //   159: invokestatic 538	com/baidu/carlife/core/k:b	(I)V
    //   162: aload 4
    //   164: astore 5
    //   166: aload 4
    //   168: ifnull +38 -> 206
    //   171: aload 4
    //   173: invokeinterface 632 1 0
    //   178: istore_1
    //   179: aload 4
    //   181: astore 5
    //   183: iload_1
    //   184: iconst_1
    //   185: if_icmpge +21 -> 206
    //   188: aload 9
    //   190: getstatic 515	android/provider/CallLog$Calls:CONTENT_URI	Landroid/net/Uri;
    //   193: getstatic 135	com/baidu/carlife/logic/q:j	[Ljava/lang/String;
    //   196: aconst_null
    //   197: aconst_null
    //   198: ldc_w 634
    //   201: invokevirtual 534	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   204: astore 5
    //   206: aload 5
    //   208: ifnonnull +15 -> 223
    //   211: aload_0
    //   212: getfield 153	com/baidu/carlife/logic/q:G	Landroid/os/Handler;
    //   215: iconst_1
    //   216: invokevirtual 640	android/os/Handler:sendEmptyMessage	(I)Z
    //   219: pop
    //   220: aload_0
    //   221: monitorexit
    //   222: return
    //   223: aload_0
    //   224: new 642	java/util/LinkedList
    //   227: dup
    //   228: invokespecial 643	java/util/LinkedList:<init>	()V
    //   231: putfield 226	com/baidu/carlife/logic/q:v	Ljava/util/List;
    //   234: aload 5
    //   236: invokeinterface 556 1 0
    //   241: ifeq +266 -> 507
    //   244: new 211	com/baidu/carlife/model/m
    //   247: dup
    //   248: invokespecial 644	com/baidu/carlife/model/m:<init>	()V
    //   251: astore 4
    //   253: aload 4
    //   255: aload 5
    //   257: iconst_1
    //   258: invokeinterface 209 2 0
    //   263: putfield 219	com/baidu/carlife/model/m:b	Ljava/lang/String;
    //   266: aload 4
    //   268: aload 5
    //   270: iconst_2
    //   271: invokeinterface 647 2 0
    //   276: putfield 649	com/baidu/carlife/model/m:d	I
    //   279: aload 4
    //   281: new 595	java/util/Date
    //   284: dup
    //   285: aload 5
    //   287: iconst_3
    //   288: invokeinterface 653 2 0
    //   293: invokespecial 656	java/util/Date:<init>	(J)V
    //   296: putfield 659	com/baidu/carlife/model/m:e	Ljava/util/Date;
    //   299: aload 4
    //   301: getfield 659	com/baidu/carlife/model/m:e	Ljava/util/Date;
    //   304: invokestatic 613	com/baidu/carlife/logic/q:a	(Ljava/util/Date;)Ljava/lang/String;
    //   307: astore 9
    //   309: aload 6
    //   311: aload 9
    //   313: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +46 -> 362
    //   319: aload 4
    //   321: aload 4
    //   323: getfield 659	com/baidu/carlife/model/m:e	Ljava/util/Date;
    //   326: invokestatic 661	com/baidu/carlife/logic/q:b	(Ljava/util/Date;)Ljava/lang/String;
    //   329: putfield 663	com/baidu/carlife/model/m:f	Ljava/lang/String;
    //   332: aload_0
    //   333: getfield 226	com/baidu/carlife/logic/q:v	Ljava/util/List;
    //   336: invokeinterface 182 1 0
    //   341: ifeq +51 -> 392
    //   344: aload_0
    //   345: aload 5
    //   347: aload 4
    //   349: invokespecial 665	com/baidu/carlife/logic/q:a	(Landroid/database/Cursor;Lcom/baidu/carlife/model/m;)V
    //   352: goto -118 -> 234
    //   355: astore 4
    //   357: aload_0
    //   358: monitorexit
    //   359: aload 4
    //   361: athrow
    //   362: aload 7
    //   364: aload 9
    //   366: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   369: ifeq +13 -> 382
    //   372: aload 4
    //   374: aload 8
    //   376: putfield 663	com/baidu/carlife/model/m:f	Ljava/lang/String;
    //   379: goto -47 -> 332
    //   382: aload 4
    //   384: aload 9
    //   386: putfield 663	com/baidu/carlife/model/m:f	Ljava/lang/String;
    //   389: goto -57 -> 332
    //   392: aload_0
    //   393: getfield 226	com/baidu/carlife/logic/q:v	Ljava/util/List;
    //   396: aload_0
    //   397: getfield 226	com/baidu/carlife/logic/q:v	Ljava/util/List;
    //   400: invokeinterface 255 1 0
    //   405: iconst_1
    //   406: isub
    //   407: invokeinterface 259 2 0
    //   412: checkcast 211	com/baidu/carlife/model/m
    //   415: astore 10
    //   417: aload 10
    //   419: getfield 219	com/baidu/carlife/model/m:b	Ljava/lang/String;
    //   422: invokestatic 218	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   425: ifne +71 -> 496
    //   428: aload 10
    //   430: getfield 219	com/baidu/carlife/model/m:b	Ljava/lang/String;
    //   433: aload 4
    //   435: getfield 219	com/baidu/carlife/model/m:b	Ljava/lang/String;
    //   438: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +55 -> 496
    //   444: aload 10
    //   446: getfield 649	com/baidu/carlife/model/m:d	I
    //   449: aload 4
    //   451: getfield 649	com/baidu/carlife/model/m:d	I
    //   454: if_icmpne +42 -> 496
    //   457: aload 10
    //   459: getfield 659	com/baidu/carlife/model/m:e	Ljava/util/Date;
    //   462: invokestatic 613	com/baidu/carlife/logic/q:a	(Ljava/util/Date;)Ljava/lang/String;
    //   465: aload 9
    //   467: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   470: ifeq +26 -> 496
    //   473: aload 4
    //   475: getfield 649	com/baidu/carlife/model/m:d	I
    //   478: ifeq +18 -> 496
    //   481: aload 10
    //   483: aload 10
    //   485: getfield 224	com/baidu/carlife/model/m:c	I
    //   488: iconst_1
    //   489: iadd
    //   490: putfield 224	com/baidu/carlife/model/m:c	I
    //   493: goto -259 -> 234
    //   496: aload_0
    //   497: aload 5
    //   499: aload 4
    //   501: invokespecial 665	com/baidu/carlife/logic/q:a	(Landroid/database/Cursor;Lcom/baidu/carlife/model/m;)V
    //   504: goto -270 -> 234
    //   507: aload 5
    //   509: invokeinterface 588 1 0
    //   514: aload_0
    //   515: iconst_0
    //   516: putfield 593	com/baidu/carlife/logic/q:x	Z
    //   519: aload_0
    //   520: getfield 153	com/baidu/carlife/logic/q:G	Landroid/os/Handler;
    //   523: iconst_1
    //   524: invokevirtual 640	android/os/Handler:sendEmptyMessage	(I)Z
    //   527: pop
    //   528: goto -308 -> 220
    //   531: astore 5
    //   533: aload 4
    //   535: astore 5
    //   537: goto -331 -> 206
    //   540: astore 5
    //   542: goto -392 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	q
    //   178	8	1	i1	int
    //   95	39	2	l1	long
    //   19	329	4	localObject1	Object
    //   355	179	4	localm1	com.baidu.carlife.model.m
    //   14	494	5	localObject2	Object
    //   531	1	5	localException1	Exception
    //   535	1	5	localObject3	Object
    //   540	1	5	localException2	Exception
    //   47	263	6	str1	String
    //   57	306	7	str2	String
    //   71	304	8	str3	String
    //   102	364	9	localObject4	Object
    //   415	69	10	localm2	com.baidu.carlife.model.m
    // Exception table:
    //   from	to	target	type
    //   2	104	355	finally
    //   107	116	355	finally
    //   116	146	355	finally
    //   150	162	355	finally
    //   171	179	355	finally
    //   188	206	355	finally
    //   211	220	355	finally
    //   223	234	355	finally
    //   234	332	355	finally
    //   332	352	355	finally
    //   362	379	355	finally
    //   382	389	355	finally
    //   392	493	355	finally
    //   496	504	355	finally
    //   507	528	355	finally
    //   188	206	531	java/lang/Exception
    //   116	146	540	java/lang/Exception
  }
  
  public String a()
  {
    i.b(b, "getCurrentName() : mCurrentName = " + this.y);
    if (TextUtils.isEmpty(this.y)) {
      return BaiduNaviApplication.getInstance().getApplicationContext().getString(2131296838);
    }
    return this.y;
  }
  
  public List<n> a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.u == null))
    {
      paramString = null;
      return paramString;
    }
    String str1 = e(CharacterParser.getSelling(paramString).toUpperCase());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.u.iterator();
    for (;;)
    {
      paramString = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (n)localIterator.next();
      String str2 = e(paramString.c);
      if ((!TextUtils.isEmpty(str2)) && (str2.contains(str1))) {
        localArrayList.add(paramString);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.z != null) && (!this.B))
    {
      this.B = true;
      this.z.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.a != null) {
      this.a.onCallStateChanged(paramInt, paramString);
    }
  }
  
  public void a(Context paramContext)
  {
    int i2 = 1;
    try
    {
      paramContext = b(paramContext);
      i1 = i2;
      if (paramContext != null)
      {
        Method localMethod = paramContext.getClass().getMethod("endCall", new Class[0]);
        localMethod.setAccessible(true);
        localMethod.invoke(paramContext, new Object[0]);
        i1 = i2;
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        i1 = 0;
        paramContext.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        i1 = 0;
        paramContext.printStackTrace();
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        i1 = 0;
        paramContext.printStackTrace();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        i1 = 0;
        paramContext.printStackTrace();
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        int i1 = 0;
        paramContext.printStackTrace();
      }
      StatisticManager.onEvent("PHONE_0003");
    }
    if (i1 == 0)
    {
      w.a("请使用系统电话挂断!");
      return;
    }
  }
  
  public void a(final Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.p.getCallState() != 0)
    {
      w.a(2131296641, 0);
      return;
    }
    final String str = paramString;
    if (paramString.length() > 40) {
      str = paramString.substring(0, 40);
    }
    if ((com.baidu.carlife.l.a.a().N()) && (!b()) && (com.baidu.carlife.bluetooth.a.a().w))
    {
      w.a(2131296826, 0);
      new Thread()
      {
        public void run()
        {
          com.baidu.carlife.core.k.a(4027, 400);
          q.a(q.this, paramContext, str);
          com.baidu.carlife.core.k.a(4027);
          com.baidu.carlife.core.k.b(4028);
        }
      }.start();
      return;
    }
    new Thread()
    {
      public void run()
      {
        com.baidu.carlife.core.k.a(4027, 400);
        q.a(q.this, paramContext, str);
        com.baidu.carlife.core.k.a(4027);
        com.baidu.carlife.core.k.b(4028);
      }
    }.start();
  }
  
  public void a(a parama)
  {
    if (this.C == null) {
      this.C = new ArrayList();
    }
    if ((!this.C.contains(parama)) && (parama != null)) {
      this.C.add(parama);
    }
  }
  
  public void a(b paramb)
  {
    this.w = paramb;
  }
  
  public void a(d paramd)
  {
    this.t = paramd;
  }
  
  public void a(g paramg)
  {
    if (this.r == null) {
      this.r = new ArrayList();
    }
    if ((!this.r.contains(paramg)) && (paramg != null)) {
      this.r.add(paramg);
    }
  }
  
  public List<n> b(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.u == null))
    {
      localObject = null;
      return (List<n>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.u.iterator();
    for (;;)
    {
      localObject = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (n)localIterator.next();
      if ((!TextUtils.isEmpty(((n)localObject).b)) && (((n)localObject).b.contains(paramString))) {
        localArrayList.add(localObject);
      }
    }
  }
  
  public void b(a parama)
  {
    if ((this.C == null) || (parama == null)) {
      return;
    }
    this.C.remove(parama);
  }
  
  public void b(g paramg)
  {
    if ((this.r == null) || (paramg == null)) {
      return;
    }
    this.r.remove(paramg);
  }
  
  public boolean b()
  {
    return this.A;
  }
  
  public int c()
  {
    if (this.p != null) {
      return this.p.getCallState();
    }
    return 0;
  }
  
  public String c(String paramString)
  {
    String str = null;
    if ((this.s != null) && (this.s.containsKey(paramString))) {
      str = (String)this.s.get(paramString);
    }
    while (TextUtils.isEmpty(paramString)) {
      return str;
    }
    return paramString;
  }
  
  public List<n> d()
  {
    return this.u;
  }
  
  public void d(String paramString)
  {
    k.a().a(1, 1);
    if (!com.baidu.carlife.l.a.a().N()) {
      return;
    }
    com.baidu.carlife.core.connect.c localc = new com.baidu.carlife.core.connect.c(true);
    localc.c(65556);
    if (!TextUtils.isEmpty(paramString))
    {
      localc.b(paramString.getBytes());
      localc.d(paramString.length());
    }
    paramString = Message.obtain(null, localc.d(), 1001, 0, localc);
    com.baidu.carlife.l.a.a().a(paramString);
  }
  
  public List<com.baidu.carlife.model.m> e()
  {
    return this.v;
  }
  
  public void g()
  {
    h();
    q();
    o();
  }
  
  public void h()
  {
    new e(null).execute(new Void[0]);
  }
  
  public void i()
  {
    if (!this.x) {
      new Thread(new Runnable()
      {
        public void run()
        {
          q.b(q.this);
        }
      }).start();
    }
  }
  
  public boolean j()
  {
    return this.q;
  }
  
  public void k()
  {
    k.a().a(1, 2);
    if (!com.baidu.carlife.l.a.a().N()) {
      return;
    }
    Object localObject = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject).c(65557);
    localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
    com.baidu.carlife.l.a.a().a((Message)localObject);
  }
  
  public void l()
  {
    if (x.b()) {
      w.a(2131296837, 0);
    }
    while ((this.z == null) || (this.B)) {
      return;
    }
    this.B = true;
    if (this.D)
    {
      this.z.i();
      return;
    }
    this.z.h();
  }
  
  public void m()
  {
    if ((this.z != null) && (!this.B))
    {
      this.B = true;
      this.z.e();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void b();
    
    public abstract void c();
  }
  
  public static abstract interface b
  {
    public abstract void b();
  }
  
  private class c
    extends ContentObserver
  {
    public c(Handler paramHandler)
    {
      super();
    }
    
    public void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      i.b(q.n(), "CallLogContentObserver onChange:" + paramBoolean);
      q.this.i();
    }
  }
  
  public static abstract interface d
  {
    public abstract void c();
  }
  
  private class e
    extends AsyncTask<Void, Void, List<String>>
  {
    private e() {}
    
    protected List<String> a(Void... paramVarArgs)
    {
      return q.i(q.this);
    }
    
    protected void a(List<String> paramList)
    {
      super.onPostExecute(paramList);
      if (q.j(q.this) != null) {
        q.j(q.this).c();
      }
    }
  }
  
  private class f
    extends PhoneStateListener
  {
    private f() {}
    
    public void onCallStateChanged(int paramInt, String paramString)
    {
      super.onCallStateChanged(paramInt, paramString);
      switch (paramInt)
      {
      }
      for (;;)
      {
        q.a(q.this, paramInt, q.d(q.this));
        return;
        i.b(q.n(), "CALL_STATE_IDLE:" + paramString);
        com.baidu.carlife.core.k.b(2009);
        q.g(q.this);
        com.baidu.carlife.bluetooth.c.a();
        q.e(q.this, false);
        q.d(q.this, false);
        q.a(q.this, null);
        continue;
        i.b(q.n(), "CALL_STATE_RINGING:" + paramString);
        com.baidu.carlife.logic.voice.m.a().b();
        com.baidu.carlife.core.k.b(2004);
        q.this.d(paramString);
        if (!TextUtils.isEmpty(paramString)) {
          q.a(q.this, q.this.c(paramString));
        }
        q.e(q.this, true);
        continue;
        i.b(q.n(), "CALL_STATE_OFFHOOK:" + paramString);
        if (!TextUtils.isEmpty(paramString)) {
          q.a(q.this, q.this.c(paramString));
        }
        com.baidu.carlife.core.k.b(2002);
        if (q.h(q.this)) {
          q.f(q.this, false);
        } else {
          q.this.k();
        }
      }
    }
  }
  
  public static abstract interface g
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b(boolean paramBoolean);
    
    public abstract void c(boolean paramBoolean);
    
    public abstract void d(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */