package com.baidu.carlife.logic.music;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.i;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class n
{
  public static Queue<String> a = new LinkedList();
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  private static int i = 0;
  private final String h = "PlayPCM";
  private volatile boolean j = true;
  private boolean k = false;
  private Thread l = null;
  private o m;
  private HandlerThread n = new HandlerThread("playpcm");
  private Handler o;
  private Object p = new Object();
  private a q;
  private String r = "";
  
  public n(o paramo)
  {
    this.m = paramo;
    this.q = new a();
    this.n.start();
    this.o = new Handler(this.n.getLooper())
    {
      public void dispatchMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          try
          {
            Thread.sleep(100L);
            return;
          }
          catch (InterruptedException paramAnonymousMessage)
          {
            paramAnonymousMessage.printStackTrace();
          }
          if ((n.a(n.this) == paramAnonymousMessage.obj) && (paramAnonymousMessage.arg1 > QPlayAutoJNI.PCMPackageIndex))
          {
            n.a(n.this, paramAnonymousMessage.obj.toString(), paramAnonymousMessage.arg1);
            continue;
            QPlayAutoJNI.SendCommand("{Request:DevicePlayPlay}\\r\\n", false);
            continue;
            QPlayAutoJNI.SendCommand("{Request:DevicePlayPause}\\r\\n", false);
          }
        }
      }
    };
    i();
  }
  
  public static void a(int paramInt)
  {
    i = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (!paramString.equals(this.r)) {
      return;
    }
    i.b("PlayPCM", "PPlayExit arg1=" + paramInt1 + ", error: arg2=" + paramInt2 + ", songId:" + paramString);
    this.q.e = 0;
    this.j = true;
    QPlayAutoJNI.PCMPackageIndex = -1;
    this.m.a(1, paramInt1, paramInt2, paramString);
  }
  
  private void a(a parama)
  {
    this.m.a(parama.b, parama.c, parama.d);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1;
    synchronized (this.p)
    {
      HashMap localHashMap = QPlayAutoJNI.GetPCMData(paramString, paramInt);
      localObject1 = localHashMap;
      if (localHashMap == null)
      {
        localHashMap = QPlayAutoJNI.GetPCMData(paramString, paramInt);
        localObject1 = localHashMap;
        if (localHashMap == null)
        {
          i.b("PlayPCM", "Play song " + paramString + " error: GetPCMData error");
          a(0, 0, paramString);
          return;
        }
      }
      localObject1 = ((HashMap)localObject1).get("error");
      if (localObject1 == null) {
        return;
      }
    }
    if (paramInt != 111) {
      a(0, paramInt, paramString);
    }
  }
  
  private boolean a(ConcurrentLinkedQueue<byte[]> paramConcurrentLinkedQueue)
  {
    if ((paramConcurrentLinkedQueue.size() < 100) && (paramConcurrentLinkedQueue.size() % 30 == 0))
    {
      paramConcurrentLinkedQueue = paramConcurrentLinkedQueue.toArray();
      if ((paramConcurrentLinkedQueue == null) || (paramConcurrentLinkedQueue.length == 0)) {
        return true;
      }
      int i1 = 0;
      while (i1 < paramConcurrentLinkedQueue.length)
      {
        if (((byte[])paramConcurrentLinkedQueue[i1]).length == 0) {
          return false;
        }
        i1 += 1;
      }
      return true;
    }
    return false;
  }
  
  private a b(String paramString)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      synchronized (this.p)
      {
        localObject2 = QPlayAutoJNI.GetMediaInfo(paramString);
        if ((localObject2 != null) && (((HashMap)localObject2).size() >= 2))
        {
          localObject1 = localObject2;
          if (((HashMap)localObject2).get("error") == null) {}
        }
        else
        {
          localObject2 = QPlayAutoJNI.GetMediaInfo(paramString);
          if ((localObject2 != null) && (((HashMap)localObject2).size() >= 2))
          {
            localObject1 = localObject2;
            if (((HashMap)localObject2).get("error") == null) {}
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder().append("Play song ").append(paramString).append(" error: GetMediaInfo:");
            if (localObject2 == null)
            {
              localObject1 = "null";
              i.d("PlayPCM", (String)localObject1);
              this.j = true;
              if (localObject2 == null) {
                break label177;
              }
              localObject1 = ((HashMap)localObject2).get("error");
              if (localObject1 == null) {
                break label177;
              }
            }
          }
        }
      }
      try
      {
        i1 = Integer.parseInt(((HashMap)localObject2).get("error").toString());
        a(0, i1, paramString);
        for (;;)
        {
          return null;
          localObject1 = ((HashMap)localObject2).toString();
          break;
          label177:
          a(0, 1, paramString);
        }
        paramString = finally;
        throw paramString;
        localObject2 = new a();
        QPlayAutoJNI.PrintHashMap("PlayPCM", (HashMap)localObject1, "GetMediaInfo");
        ((a)localObject2).a = paramString;
        try
        {
          ((a)localObject2).b = Integer.parseInt(((HashMap)localObject1).get("rate").toString());
          ((a)localObject2).d = Integer.parseInt(((HashMap)localObject1).get("bit").toString());
          ((a)localObject2).c = Integer.parseInt(((HashMap)localObject1).get("channel").toString());
          i1 = Integer.parseInt(((HashMap)localObject1).get("pcmdatalength").toString());
          ((a)localObject2).e = (i1 / (((a)localObject2).b * ((a)localObject2).c * ((a)localObject2).d / 8));
          if (((a)localObject2).d == 8)
          {
            ((a)localObject2).d = 3;
            if (((a)localObject2).c != 1) {
              break label361;
            }
            ((a)localObject2).c = 16;
            return (a)localObject2;
          }
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            i1 = 0;
            continue;
            ((a)localObject2).d = 2;
          }
          label361:
          ((a)localObject2).c = 12;
          return (a)localObject2;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i1 = 0;
        }
      }
    }
  }
  
  private void i()
  {
    this.l = new Thread(new Runnable()
    {
      byte[] a = null;
      int b = 0;
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   4: invokestatic 34	com/baidu/carlife/logic/music/n:b	(Lcom/baidu/carlife/logic/music/n;)Z
        //   7: ifne +584 -> 591
        //   10: getstatic 37	com/baidu/carlife/logic/music/n:a	Ljava/util/Queue;
        //   13: invokeinterface 43 1 0
        //   18: iconst_2
        //   19: if_icmpge +20 -> 39
        //   22: ldc2_w 44
        //   25: invokestatic 51	java/lang/Thread:sleep	(J)V
        //   28: goto -28 -> 0
        //   31: astore_1
        //   32: aload_1
        //   33: invokevirtual 54	java/lang/InterruptedException:printStackTrace	()V
        //   36: goto -36 -> 0
        //   39: getstatic 37	com/baidu/carlife/logic/music/n:a	Ljava/util/Queue;
        //   42: invokeinterface 43 1 0
        //   47: iconst_1
        //   48: if_icmple +15 -> 63
        //   51: getstatic 37	com/baidu/carlife/logic/music/n:a	Ljava/util/Queue;
        //   54: invokeinterface 58 1 0
        //   59: pop
        //   60: goto -21 -> 39
        //   63: ldc2_w 59
        //   66: invokestatic 51	java/lang/Thread:sleep	(J)V
        //   69: getstatic 37	com/baidu/carlife/logic/music/n:a	Ljava/util/Queue;
        //   72: invokeinterface 43 1 0
        //   77: iconst_1
        //   78: if_icmpgt -78 -> 0
        //   81: getstatic 37	com/baidu/carlife/logic/music/n:a	Ljava/util/Queue;
        //   84: invokeinterface 43 1 0
        //   89: anewarray 62	java/lang/String
        //   92: astore_1
        //   93: getstatic 37	com/baidu/carlife/logic/music/n:a	Ljava/util/Queue;
        //   96: aload_1
        //   97: invokeinterface 66 2 0
        //   102: pop
        //   103: aload_1
        //   104: ifnull -104 -> 0
        //   107: aload_1
        //   108: arraylength
        //   109: iconst_1
        //   110: if_icmplt -110 -> 0
        //   113: aload_0
        //   114: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   117: invokevirtual 69	com/baidu/carlife/logic/music/n:g	()V
        //   120: aload_0
        //   121: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   124: aload_1
        //   125: aload_1
        //   126: arraylength
        //   127: iconst_1
        //   128: isub
        //   129: aaload
        //   130: invokestatic 72	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;Ljava/lang/String;)Ljava/lang/String;
        //   133: pop
        //   134: ldc 74
        //   136: new 76	java/lang/StringBuilder
        //   139: dup
        //   140: invokespecial 77	java/lang/StringBuilder:<init>	()V
        //   143: ldc 79
        //   145: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: aload_0
        //   149: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   152: invokestatic 86	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;)Ljava/lang/String;
        //   155: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   161: invokestatic 95	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   164: aload_0
        //   165: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   168: iconst_0
        //   169: invokestatic 98	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;Z)Z
        //   172: pop
        //   173: ldc2_w 99
        //   176: invokestatic 51	java/lang/Thread:sleep	(J)V
        //   179: invokestatic 105	com/tencent/qplayauto/device/QPlayAutoJNI:InitPCMData	()V
        //   182: aload_0
        //   183: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   186: invokestatic 86	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;)Ljava/lang/String;
        //   189: invokestatic 109	com/tencent/qplayauto/device/QPlayAutoJNI:SetCurrentSongID	(Ljava/lang/String;)V
        //   192: aload_0
        //   193: iconst_0
        //   194: putfield 27	com/baidu/carlife/logic/music/n$2:b	I
        //   197: aload_0
        //   198: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   201: aload_0
        //   202: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   205: aload_0
        //   206: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   209: invokestatic 86	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;)Ljava/lang/String;
        //   212: invokestatic 112	com/baidu/carlife/logic/music/n:b	(Lcom/baidu/carlife/logic/music/n;Ljava/lang/String;)Lcom/baidu/carlife/logic/music/n$a;
        //   215: invokestatic 115	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;Lcom/baidu/carlife/logic/music/n$a;)Lcom/baidu/carlife/logic/music/n$a;
        //   218: pop
        //   219: ldc2_w 116
        //   222: invokestatic 51	java/lang/Thread:sleep	(J)V
        //   225: aload_0
        //   226: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   229: invokestatic 120	com/baidu/carlife/logic/music/n:c	(Lcom/baidu/carlife/logic/music/n;)Lcom/baidu/carlife/logic/music/n$a;
        //   232: ifnonnull +45 -> 277
        //   235: aload_0
        //   236: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   239: new 122	com/baidu/carlife/logic/music/n$a
        //   242: dup
        //   243: aload_0
        //   244: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   247: invokespecial 124	com/baidu/carlife/logic/music/n$a:<init>	(Lcom/baidu/carlife/logic/music/n;)V
        //   250: invokestatic 115	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;Lcom/baidu/carlife/logic/music/n$a;)Lcom/baidu/carlife/logic/music/n$a;
        //   253: pop
        //   254: goto -254 -> 0
        //   257: astore_1
        //   258: aload_1
        //   259: invokevirtual 54	java/lang/InterruptedException:printStackTrace	()V
        //   262: goto -193 -> 69
        //   265: astore_1
        //   266: goto -266 -> 0
        //   269: astore_1
        //   270: aload_1
        //   271: invokevirtual 54	java/lang/InterruptedException:printStackTrace	()V
        //   274: goto -49 -> 225
        //   277: aload_0
        //   278: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   281: aload_0
        //   282: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   285: invokestatic 120	com/baidu/carlife/logic/music/n:c	(Lcom/baidu/carlife/logic/music/n;)Lcom/baidu/carlife/logic/music/n$a;
        //   288: invokestatic 127	com/baidu/carlife/logic/music/n:b	(Lcom/baidu/carlife/logic/music/n;Lcom/baidu/carlife/logic/music/n$a;)V
        //   291: aload_0
        //   292: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   295: invokestatic 131	com/baidu/carlife/logic/music/n:d	(Lcom/baidu/carlife/logic/music/n;)Lcom/baidu/carlife/logic/music/o;
        //   298: iconst_1
        //   299: invokeinterface 136 2 0
        //   304: aload_0
        //   305: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   308: invokestatic 131	com/baidu/carlife/logic/music/n:d	(Lcom/baidu/carlife/logic/music/n;)Lcom/baidu/carlife/logic/music/o;
        //   311: aload_0
        //   312: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   315: invokestatic 120	com/baidu/carlife/logic/music/n:c	(Lcom/baidu/carlife/logic/music/n;)Lcom/baidu/carlife/logic/music/n$a;
        //   318: getfield 139	com/baidu/carlife/logic/music/n$a:e	I
        //   321: sipush 1000
        //   324: imul
        //   325: invokestatic 143	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   328: invokeinterface 145 2 0
        //   333: aload_0
        //   334: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   337: invokestatic 147	com/baidu/carlife/logic/music/n:e	(Lcom/baidu/carlife/logic/music/n;)Z
        //   340: ifne +15 -> 355
        //   343: getstatic 37	com/baidu/carlife/logic/music/n:a	Ljava/util/Queue;
        //   346: invokeinterface 43 1 0
        //   351: iconst_1
        //   352: if_icmple +41 -> 393
        //   355: ldc 74
        //   357: new 76	java/lang/StringBuilder
        //   360: dup
        //   361: invokespecial 77	java/lang/StringBuilder:<init>	()V
        //   364: ldc -107
        //   366: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   369: aload_0
        //   370: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   373: invokestatic 86	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;)Ljava/lang/String;
        //   376: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   379: ldc -105
        //   381: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   384: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   387: invokestatic 95	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   390: goto -390 -> 0
        //   393: invokestatic 154	com/baidu/carlife/logic/music/n:h	()I
        //   396: iconst_2
        //   397: if_icmpeq +32 -> 429
        //   400: ldc2_w 44
        //   403: invokestatic 51	java/lang/Thread:sleep	(J)V
        //   406: goto -73 -> 333
        //   409: astore_1
        //   410: aload_0
        //   411: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   414: iconst_1
        //   415: iconst_1
        //   416: aload_0
        //   417: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   420: invokestatic 86	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;)Ljava/lang/String;
        //   423: invokestatic 157	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;IILjava/lang/String;)V
        //   426: goto -71 -> 355
        //   429: aload_0
        //   430: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   433: getstatic 161	com/tencent/qplayauto/device/QPlayAutoJNI:PcmQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
        //   436: invokestatic 164	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;Ljava/util/concurrent/ConcurrentLinkedQueue;)Z
        //   439: ifeq +30 -> 469
        //   442: aload_0
        //   443: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   446: invokestatic 168	com/baidu/carlife/logic/music/n:f	(Lcom/baidu/carlife/logic/music/n;)Landroid/os/Handler;
        //   449: iconst_1
        //   450: getstatic 171	com/tencent/qplayauto/device/QPlayAutoJNI:PCMPackageIndex	I
        //   453: iconst_1
        //   454: iadd
        //   455: iconst_0
        //   456: aload_0
        //   457: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   460: invokestatic 86	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;)Ljava/lang/String;
        //   463: invokevirtual 177	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
        //   466: invokevirtual 182	android/os/Message:sendToTarget	()V
        //   469: aload_0
        //   470: getstatic 161	com/tencent/qplayauto/device/QPlayAutoJNI:PcmQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
        //   473: invokevirtual 185	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
        //   476: checkcast 186	[B
        //   479: putfield 25	com/baidu/carlife/logic/music/n$2:a	[B
        //   482: aload_0
        //   483: getfield 25	com/baidu/carlife/logic/music/n$2:a	[B
        //   486: ifnonnull +32 -> 518
        //   489: ldc2_w 187
        //   492: invokestatic 51	java/lang/Thread:sleep	(J)V
        //   495: goto -162 -> 333
        //   498: astore_1
        //   499: aload_0
        //   500: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   503: iconst_1
        //   504: iconst_1
        //   505: aload_0
        //   506: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   509: invokestatic 86	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;)Ljava/lang/String;
        //   512: invokestatic 157	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;IILjava/lang/String;)V
        //   515: goto -160 -> 355
        //   518: aload_0
        //   519: getfield 25	com/baidu/carlife/logic/music/n$2:a	[B
        //   522: arraylength
        //   523: ifne +22 -> 545
        //   526: aload_0
        //   527: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   530: iconst_1
        //   531: iconst_0
        //   532: aload_0
        //   533: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   536: invokestatic 86	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;)Ljava/lang/String;
        //   539: invokestatic 157	com/baidu/carlife/logic/music/n:a	(Lcom/baidu/carlife/logic/music/n;IILjava/lang/String;)V
        //   542: goto -187 -> 355
        //   545: aload_0
        //   546: getfield 27	com/baidu/carlife/logic/music/n$2:b	I
        //   549: bipush 10
        //   551: if_icmpge +16 -> 567
        //   554: aload_0
        //   555: aload_0
        //   556: getfield 27	com/baidu/carlife/logic/music/n$2:b	I
        //   559: iconst_1
        //   560: iadd
        //   561: putfield 27	com/baidu/carlife/logic/music/n$2:b	I
        //   564: goto -231 -> 333
        //   567: aload_0
        //   568: getfield 21	com/baidu/carlife/logic/music/n$2:c	Lcom/baidu/carlife/logic/music/n;
        //   571: invokestatic 131	com/baidu/carlife/logic/music/n:d	(Lcom/baidu/carlife/logic/music/n;)Lcom/baidu/carlife/logic/music/o;
        //   574: aload_0
        //   575: getfield 25	com/baidu/carlife/logic/music/n$2:a	[B
        //   578: aload_0
        //   579: getfield 25	com/baidu/carlife/logic/music/n$2:a	[B
        //   582: arraylength
        //   583: invokeinterface 191 3 0
        //   588: goto -255 -> 333
        //   591: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	592	0	this	2
        //   31	2	1	localInterruptedException1	InterruptedException
        //   92	34	1	arrayOfString	String[]
        //   257	2	1	localInterruptedException2	InterruptedException
        //   265	1	1	localInterruptedException3	InterruptedException
        //   269	2	1	localInterruptedException4	InterruptedException
        //   409	1	1	localInterruptedException5	InterruptedException
        //   498	1	1	localInterruptedException6	InterruptedException
        // Exception table:
        //   from	to	target	type
        //   22	28	31	java/lang/InterruptedException
        //   63	69	257	java/lang/InterruptedException
        //   173	179	265	java/lang/InterruptedException
        //   219	225	269	java/lang/InterruptedException
        //   400	406	409	java/lang/InterruptedException
        //   489	495	498	java/lang/InterruptedException
      }
    });
    this.l.start();
  }
  
  public int a()
  {
    return this.q.e;
  }
  
  public void a(String paramString)
  {
    this.o.obtainMessage(2).sendToTarget();
    if (a.size() < 1) {
      a.add(paramString);
    }
    a.add(paramString);
    i = 2;
  }
  
  public boolean b()
  {
    return !this.j;
  }
  
  public void c()
  {
    if (i != 1) {
      this.o.obtainMessage(3).sendToTarget();
    }
    i = 1;
    this.m.c();
  }
  
  public void d()
  {
    if (i != 2) {
      this.o.obtainMessage(2).sendToTarget();
    }
    this.m.b();
    i = 2;
  }
  
  public void e()
  {
    i = 0;
  }
  
  public void f()
  {
    this.k = true;
    g();
    if (this.l != null)
    {
      this.l.interrupt();
      this.l = null;
    }
  }
  
  public void g()
  {
    this.q.e = 0;
    this.j = true;
  }
  
  class a
  {
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    
    a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */