package com.baidu.carlife.custom.elhyf.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.protobuf.CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason;
import com.baidu.carlife.protobuf.CarlifeTransferDataFinishProto.CarlifeTransferDataFinish;
import com.baidu.carlife.protobuf.CarlifeTransferDataSendProto.CarlifeTransferDataSend;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import com.baidu.carlife.protobuf.CarlifeTransferDataStopProto.CarlifeTransferDataStop;
import com.baidu.carlife.util.w;
import com.google.protobuf.ByteString;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  public static String a = b.class.getSimpleName();
  public static final String b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeFile/Unknown";
  public static final String c = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeFile/Photo";
  public static final String d = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeFile/Video";
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 3;
  private static b o;
  ArrayList<a> e = new ArrayList();
  final Handler f = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object[] arrayOfObject = (Object[])paramAnonymousMessage.obj;
      ArrayList localArrayList = new ArrayList(b.this.e);
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return;
        if (arrayOfObject != null)
        {
          int i = 0;
          while (i < localArrayList.size())
          {
            ((b.a)localArrayList.get(i)).a((a)arrayOfObject[0]);
            i += 1;
          }
          continue;
          if (arrayOfObject != null)
          {
            i = 0;
            while (i < localArrayList.size())
            {
              ((b.a)localArrayList.get(i)).b((a)arrayOfObject[0]);
              i += 1;
            }
            continue;
            if (arrayOfObject != null)
            {
              i = 0;
              while (i < localArrayList.size())
              {
                ((b.a)localArrayList.get(i)).c((a)arrayOfObject[0]);
                i += 1;
              }
              continue;
              if (arrayOfObject != null)
              {
                i = 0;
                while (i < localArrayList.size())
                {
                  ((b.a)localArrayList.get(i)).a((a)arrayOfObject[0], ((Integer)arrayOfObject[1]).intValue());
                  i += 1;
                }
              }
            }
          }
        }
      }
    }
  };
  private Context k;
  private Map<Integer, a> l = new HashMap();
  private HandlerThread m;
  private j n;
  
  /* Error */
  private int a(int paramInt, CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason paramReason)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 108	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   5: invokevirtual 112	com/baidu/carlife/l/a:N	()Z
    //   8: istore_3
    //   9: iload_3
    //   10: ifne +9 -> 19
    //   13: iconst_m1
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 92	com/baidu/carlife/custom/elhyf/c/b:l	Ljava/util/Map;
    //   23: iload_1
    //   24: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokeinterface 124 2 0
    //   32: ifeq +23 -> 55
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 92	com/baidu/carlife/custom/elhyf/c/b:l	Ljava/util/Map;
    //   40: iload_1
    //   41: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 128 2 0
    //   49: checkcast 130	com/baidu/carlife/custom/elhyf/c/a
    //   52: invokespecial 133	com/baidu/carlife/custom/elhyf/c/b:a	(Lcom/baidu/carlife/custom/elhyf/c/a;)V
    //   55: invokestatic 139	com/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData:newBuilder	()Lcom/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Builder;
    //   58: astore 4
    //   60: aload 4
    //   62: iload_1
    //   63: invokevirtual 145	com/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Builder:setFileId	(I)Lcom/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Builder;
    //   66: pop
    //   67: aload 4
    //   69: aload_2
    //   70: invokevirtual 149	com/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Builder:setReason	(Lcom/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Reason;)Lcom/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Builder;
    //   73: pop
    //   74: aload 4
    //   76: invokevirtual 153	com/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Builder:build	()Lcom/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData;
    //   79: astore_2
    //   80: new 155	com/baidu/carlife/core/connect/c
    //   83: dup
    //   84: iconst_1
    //   85: invokespecial 158	com/baidu/carlife/core/connect/c:<init>	(Z)V
    //   88: astore 4
    //   90: aload 4
    //   92: aload_2
    //   93: invokevirtual 162	com/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData:toByteArray	()[B
    //   96: invokevirtual 165	com/baidu/carlife/core/connect/c:b	([B)V
    //   99: aload 4
    //   101: aload_2
    //   102: invokevirtual 169	com/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData:getSerializedSize	()I
    //   105: invokevirtual 172	com/baidu/carlife/core/connect/c:d	(I)V
    //   108: aload 4
    //   110: ldc -83
    //   112: invokevirtual 175	com/baidu/carlife/core/connect/c:c	(I)V
    //   115: invokestatic 108	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   118: aload 4
    //   120: invokevirtual 178	com/baidu/carlife/l/a:a	(Lcom/baidu/carlife/core/connect/c;)I
    //   123: istore_1
    //   124: goto -109 -> 15
    //   127: astore_2
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_2
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	b
    //   0	132	1	paramInt	int
    //   0	132	2	paramReason	CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason
    //   8	2	3	bool	boolean
    //   58	61	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	127	finally
    //   19	55	127	finally
    //   55	124	127	finally
  }
  
  private Message a(int paramInt, Object paramObject)
  {
    return Message.obtain(this.f, paramInt, paramObject);
  }
  
  public static b a()
  {
    if (o == null) {
      o = new b();
    }
    return o;
  }
  
  private String a(CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType paramDataType)
  {
    if (paramDataType == CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.Photo) {
      return c;
    }
    if (paramDataType == CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.Video) {
      return d;
    }
    return b;
  }
  
  private void a(int paramInt)
  {
    Iterator localIterator = this.l.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((Integer)((Map.Entry)localIterator.next()).getKey()).intValue() == paramInt) {
        localIterator.remove();
      }
    }
  }
  
  /* Error */
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 241	com/baidu/vi/VDeviceAPI:getSdcardFreeSpace	()J
    //   3: l2f
    //   4: iload_3
    //   5: i2f
    //   6: ldc -14
    //   8: fdiv
    //   9: fcmpg
    //   10: ifge +26 -> 36
    //   13: aload_0
    //   14: iload_1
    //   15: getstatic 248	com/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Reason:NoSpace	Lcom/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Reason;
    //   18: invokespecial 250	com/baidu/carlife/custom/elhyf/c/b:a	(ILcom/baidu/carlife/protobuf/CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Reason;)I
    //   21: pop
    //   22: aload_0
    //   23: getfield 252	com/baidu/carlife/custom/elhyf/c/b:k	Landroid/content/Context;
    //   26: ldc -3
    //   28: invokevirtual 259	android/content/Context:getString	(I)Ljava/lang/String;
    //   31: iconst_1
    //   32: invokestatic 264	com/baidu/carlife/util/w:a	(Ljava/lang/String;I)V
    //   35: return
    //   36: invokestatic 108	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   39: invokevirtual 112	com/baidu/carlife/l/a:N	()Z
    //   42: ifeq -7 -> 35
    //   45: aload_0
    //   46: getfield 92	com/baidu/carlife/custom/elhyf/c/b:l	Ljava/util/Map;
    //   49: iload_1
    //   50: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: invokeinterface 128 2 0
    //   58: checkcast 130	com/baidu/carlife/custom/elhyf/c/a
    //   61: invokevirtual 266	com/baidu/carlife/custom/elhyf/c/a:e	()Ljava/io/File;
    //   64: astore 11
    //   66: aconst_null
    //   67: astore 6
    //   69: aconst_null
    //   70: astore 8
    //   72: aconst_null
    //   73: astore 9
    //   75: aconst_null
    //   76: astore 7
    //   78: aconst_null
    //   79: astore 10
    //   81: new 268	java/io/FileOutputStream
    //   84: dup
    //   85: aload 11
    //   87: iconst_1
    //   88: invokespecial 271	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   91: astore 5
    //   93: new 273	java/io/BufferedOutputStream
    //   96: dup
    //   97: aload 5
    //   99: invokespecial 276	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   102: astore 6
    //   104: aload 6
    //   106: aload_2
    //   107: invokevirtual 279	java/io/BufferedOutputStream:write	([B)V
    //   110: aload 6
    //   112: ifnull +8 -> 120
    //   115: aload 6
    //   117: invokevirtual 282	java/io/BufferedOutputStream:close	()V
    //   120: aload 5
    //   122: ifnull +239 -> 361
    //   125: aload 5
    //   127: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   130: iconst_0
    //   131: istore_3
    //   132: aload_0
    //   133: getfield 92	com/baidu/carlife/custom/elhyf/c/b:l	Ljava/util/Map;
    //   136: iload_1
    //   137: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: invokeinterface 128 2 0
    //   145: checkcast 130	com/baidu/carlife/custom/elhyf/c/a
    //   148: invokevirtual 285	com/baidu/carlife/custom/elhyf/c/a:d	()I
    //   151: istore 4
    //   153: iload 4
    //   155: ifeq +21 -> 176
    //   158: aload 11
    //   160: invokevirtual 288	java/io/File:length	()J
    //   163: l2d
    //   164: dconst_1
    //   165: dmul
    //   166: iload 4
    //   168: i2d
    //   169: ddiv
    //   170: ldc2_w 289
    //   173: dmul
    //   174: d2i
    //   175: istore_3
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 92	com/baidu/carlife/custom/elhyf/c/b:l	Ljava/util/Map;
    //   181: iload_1
    //   182: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: invokeinterface 128 2 0
    //   190: checkcast 130	com/baidu/carlife/custom/elhyf/c/a
    //   193: iload_3
    //   194: invokespecial 293	com/baidu/carlife/custom/elhyf/c/b:a	(Lcom/baidu/carlife/custom/elhyf/c/a;I)V
    //   197: return
    //   198: astore_2
    //   199: aload_2
    //   200: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   203: goto -83 -> 120
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   211: goto -81 -> 130
    //   214: astore 8
    //   216: aload 10
    //   218: astore_2
    //   219: aload 9
    //   221: astore 5
    //   223: aload 5
    //   225: astore 6
    //   227: aload_2
    //   228: astore 7
    //   230: aload 8
    //   232: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   235: aload 5
    //   237: ifnull +8 -> 245
    //   240: aload 5
    //   242: invokevirtual 282	java/io/BufferedOutputStream:close	()V
    //   245: aload_2
    //   246: ifnull -116 -> 130
    //   249: aload_2
    //   250: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   253: goto -123 -> 130
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   261: goto -131 -> 130
    //   264: astore 5
    //   266: aload 5
    //   268: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   271: goto -26 -> 245
    //   274: astore_2
    //   275: aload 6
    //   277: ifnull +8 -> 285
    //   280: aload 6
    //   282: invokevirtual 282	java/io/BufferedOutputStream:close	()V
    //   285: aload 7
    //   287: ifnull +8 -> 295
    //   290: aload 7
    //   292: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   295: aload_2
    //   296: athrow
    //   297: astore 5
    //   299: aload 5
    //   301: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   304: goto -19 -> 285
    //   307: astore 5
    //   309: aload 5
    //   311: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   314: goto -19 -> 295
    //   317: astore_2
    //   318: aload 8
    //   320: astore 6
    //   322: aload 5
    //   324: astore 7
    //   326: goto -51 -> 275
    //   329: astore_2
    //   330: aload 5
    //   332: astore 7
    //   334: goto -59 -> 275
    //   337: astore 8
    //   339: aload 5
    //   341: astore_2
    //   342: aload 9
    //   344: astore 5
    //   346: goto -123 -> 223
    //   349: astore 8
    //   351: aload 5
    //   353: astore_2
    //   354: aload 6
    //   356: astore 5
    //   358: goto -135 -> 223
    //   361: goto -231 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	b
    //   0	364	1	paramInt1	int
    //   0	364	2	paramArrayOfByte	byte[]
    //   0	364	3	paramInt2	int
    //   151	16	4	i1	int
    //   91	150	5	localObject1	Object
    //   264	3	5	localIOException1	java.io.IOException
    //   297	3	5	localIOException2	java.io.IOException
    //   307	33	5	localIOException3	java.io.IOException
    //   344	13	5	localObject2	Object
    //   67	288	6	localObject3	Object
    //   76	257	7	localObject4	Object
    //   70	1	8	localObject5	Object
    //   214	105	8	localException1	Exception
    //   337	1	8	localException2	Exception
    //   349	1	8	localException3	Exception
    //   73	270	9	localObject6	Object
    //   79	138	10	localObject7	Object
    //   64	95	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   115	120	198	java/io/IOException
    //   125	130	206	java/io/IOException
    //   81	93	214	java/lang/Exception
    //   249	253	256	java/io/IOException
    //   240	245	264	java/io/IOException
    //   81	93	274	finally
    //   230	235	274	finally
    //   280	285	297	java/io/IOException
    //   290	295	307	java/io/IOException
    //   93	104	317	finally
    //   104	110	329	finally
    //   93	104	337	java/lang/Exception
    //   104	110	349	java/lang/Exception
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (c)paramMessage.obj;
    try
    {
      Object localObject = CarlifeTransferDataStartProto.CarlifeTransferDataStart.parseFrom(paramMessage.f());
      int i1 = ((CarlifeTransferDataStartProto.CarlifeTransferDataStart)localObject).getFileId();
      paramMessage = ((CarlifeTransferDataStartProto.CarlifeTransferDataStart)localObject).getDataType();
      String str = ((CarlifeTransferDataStartProto.CarlifeTransferDataStart)localObject).getDataName();
      int i2 = ((CarlifeTransferDataStartProto.CarlifeTransferDataStart)localObject).getDataLen();
      localObject = a(paramMessage) + "/" + str;
      if (a((String)localObject))
      {
        a(i1, CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason.FileExisted);
        w.a(this.k.getString(2131298853), 1);
        return;
      }
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramMessage = new a(i1, paramMessage, str, i2, (File)localObject);
      this.l.put(Integer.valueOf(i1), paramMessage);
      b(paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void a(a parama)
  {
    if (parama == null) {}
    File localFile;
    do
    {
      return;
      localFile = parama.e();
    } while (!localFile.exists());
    localFile.delete();
    d(parama);
    a(parama.a());
  }
  
  private void a(a parama, int paramInt)
  {
    e(a(3, new Object[] { parama, Integer.valueOf(paramInt) }));
  }
  
  private boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  private void b(Message paramMessage)
  {
    paramMessage = (c)paramMessage.obj;
    try
    {
      int i1 = CarlifeTransferDataStopProto.CarlifeTransferDataStop.parseFrom(paramMessage.f()).getFileId();
      if (!this.l.containsKey(Integer.valueOf(i1))) {
        return;
      }
      a((a)this.l.get(Integer.valueOf(i1)));
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void b(a parama)
  {
    e(a(0, new Object[] { parama }));
  }
  
  private void c(Message paramMessage)
  {
    paramMessage = (c)paramMessage.obj;
    try
    {
      int i1 = CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.parseFrom(paramMessage.f()).getFileId();
      if (!this.l.containsKey(Integer.valueOf(i1))) {
        return;
      }
      c((a)this.l.get(Integer.valueOf(i1)));
      a(this.k, ((a)this.l.get(Integer.valueOf(i1))).e().getAbsolutePath());
      a(i1);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void c(a parama)
  {
    e(a(1, new Object[] { parama }));
  }
  
  private void d(Message paramMessage)
  {
    paramMessage = (c)paramMessage.obj;
    try
    {
      paramMessage = CarlifeTransferDataSendProto.CarlifeTransferDataSend.parseFrom(paramMessage.f());
      int i1 = paramMessage.getFileId();
      int i2 = paramMessage.getLen();
      paramMessage = paramMessage.getBodyData().toByteArray();
      if (!this.l.containsKey(Integer.valueOf(i1))) {
        return;
      }
      a(i1, paramMessage, i2);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void d(a parama)
  {
    e(a(2, new Object[] { parama }));
  }
  
  private void e(Message paramMessage)
  {
    this.f.sendMessage(paramMessage);
  }
  
  public void a(Context paramContext)
  {
    this.k = paramContext;
    paramContext = new File(b);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    paramContext = new File(c);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    paramContext = new File(d);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.m = new HandlerThread("ReceiveDataManager");
    this.m.start();
    this.n = new b(this.m.getLooper());
    k.a(this.n);
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.fromFile(new File(paramString)));
    paramContext.sendBroadcast(localIntent);
  }
  
  public void a(a parama)
  {
    if (!this.e.contains(parama)) {
      this.e.add(parama);
    }
  }
  
  public void b(a parama)
  {
    this.e.remove(parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void a(a parama, int paramInt);
    
    public abstract void b(a parama);
    
    public abstract void c(a parama);
  }
  
  private class b
    extends j
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(458753);
      addMsg(458755);
      addMsg(458756);
      addMsg(458754);
      addMsg(1002);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 458753: 
        i.b(b.a, "---------MSG_SEND_START---------");
        b.a(b.this, paramMessage);
        return;
      case 458756: 
        i.b(b.a, "---------MSG_SEND_STOP---------");
        b.b(b.this, paramMessage);
        return;
      case 458755: 
        i.b(b.a, "---------MSG_SEND_FINISH---------");
        b.c(b.this, paramMessage);
        return;
      case 458754: 
        i.b(b.a, "---------MSG_SENDING_DATA---------");
        b.d(b.this, paramMessage);
        return;
      }
      if (b.a(b.this).size() != 0)
      {
        paramMessage = b.a(b.this).entrySet().iterator();
        while (paramMessage.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMessage.next();
          b.a(b.this, (a)localEntry.getValue());
        }
      }
      b.a(b.this).clear();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */