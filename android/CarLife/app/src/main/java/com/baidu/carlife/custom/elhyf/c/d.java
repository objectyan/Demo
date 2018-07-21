package com.baidu.carlife.custom.elhyf.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.l.a;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;

public class d
{
  private static final String b = d.class.getSimpleName();
  private static final int c = 30720;
  private static final int d = 30;
  private static int e = 0;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 3;
  private static d o;
  final Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      d.a locala = null;
      Object[] arrayOfObject = (Object[])paramAnonymousMessage.obj;
      if (arrayOfObject != null) {
        locala = (d.a)arrayOfObject[0];
      }
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (locala == null);
            locala.a();
            return;
          } while (locala == null);
          locala.b();
          return;
        } while (locala == null);
        locala.c();
        return;
      } while ((locala == null) || (arrayOfObject == null));
      locala.a(((Integer)arrayOfObject[1]).intValue());
    }
  };
  private Context j;
  private boolean k = true;
  private boolean l = false;
  private LinkedBlockingQueue<c> m = new LinkedBlockingQueue();
  private Thread n;
  private Runnable p = new Runnable()
  {
    public void run()
    {
      while (d.a(d.this))
      {
        Object localObject1 = null;
        int i1;
        try
        {
          localObject2 = (c)d.b(d.this).take();
          localObject1 = localObject2;
          i1 = d.b();
          localObject3 = ((c)localObject1).a();
          localDataType = ((c)localObject1).b();
          localObject2 = ((c)localObject1).c();
          localObject1 = ((c)localObject1).d();
          n = 0;
        }
        catch (InterruptedException localInterruptedException2)
        {
          try
          {
            Object localObject2;
            CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType localDataType;
            i = ((InputStream)localObject1).available();
            n = i;
            if (d.a(d.this, i1, localDataType, n, (String)localObject3) == -1)
            {
              i.b(d.c(), "start send file fail");
              d.a(d.this, (d.a)localObject2);
              continue;
              localInterruptedException2 = localInterruptedException2;
              localInterruptedException2.printStackTrace();
            }
          }
          catch (IOException localIOException2)
          {
            int n;
            for (;;)
            {
              localIOException2.printStackTrace();
            }
            d.b(d.this, localInterruptedException2);
            d.a(d.this, false);
            int i = 0;
            Object localObject3 = new byte['砀'];
            int k = i;
            int m = i;
            try
            {
              int i2 = ((InputStream)localObject1).read((byte[])localObject3);
              j = i;
              if (i2 != -1)
              {
                k = i;
                m = i;
                if (d.this.a(i1, (byte[])localObject3, i2) != -1) {
                  break label260;
                }
              }
              for (j = i;; j = i)
              {
                k = j;
                m = j;
                ((InputStream)localObject1).close();
                if (j != n) {
                  break label394;
                }
                if (d.b(d.this, i1) != -1) {
                  break label382;
                }
                d.a(d.this, i1);
                d.a(d.this, localInterruptedException2);
                break;
                label260:
                i += i2;
                j = (int)(i * 1.0D / n * 100.0D);
                k = i;
                m = i;
                d.a(d.this, localInterruptedException2, j);
                k = i;
                m = i;
                if (!d.c(d.this)) {
                  break label355;
                }
                k = i;
                m = i;
                d.a(d.this, i1);
                k = i;
                m = i;
                d.a(d.this, localInterruptedException2);
              }
            }
            catch (InterruptedException localInterruptedException1)
            {
              for (;;)
              {
                localInterruptedException1.printStackTrace();
                j = k;
              }
              k = i;
              m = i;
              Thread.sleep(30L);
            }
            catch (IOException localIOException1)
            {
              for (;;)
              {
                label355:
                localIOException1.printStackTrace();
                int j = m;
              }
              label382:
              d.c(d.this, localInterruptedException2);
            }
          }
        }
        continue;
        label394:
        d.a(d.this, i1);
        d.a(d.this, localInterruptedException2);
      }
    }
  };
  private j q = new j()
  {
    public void careAbout()
    {
      addMsg(458757);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      d.a(d.this, true);
    }
  };
  
  /* Error */
  private int a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 88	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   5: invokevirtual 92	com/baidu/carlife/l/a:N	()Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifne +9 -> 19
    //   13: iconst_m1
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: invokestatic 98	com/baidu/carlife/protobuf/CarlifeTransferDataFinishProto$CarlifeTransferDataFinish:newBuilder	()Lcom/baidu/carlife/protobuf/CarlifeTransferDataFinishProto$CarlifeTransferDataFinish$Builder;
    //   22: astore_3
    //   23: aload_3
    //   24: iload_1
    //   25: invokevirtual 104	com/baidu/carlife/protobuf/CarlifeTransferDataFinishProto$CarlifeTransferDataFinish$Builder:setFileId	(I)Lcom/baidu/carlife/protobuf/CarlifeTransferDataFinishProto$CarlifeTransferDataFinish$Builder;
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 108	com/baidu/carlife/protobuf/CarlifeTransferDataFinishProto$CarlifeTransferDataFinish$Builder:build	()Lcom/baidu/carlife/protobuf/CarlifeTransferDataFinishProto$CarlifeTransferDataFinish;
    //   33: astore_3
    //   34: new 110	com/baidu/carlife/core/connect/c
    //   37: dup
    //   38: iconst_1
    //   39: invokespecial 113	com/baidu/carlife/core/connect/c:<init>	(Z)V
    //   42: astore 4
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 117	com/baidu/carlife/protobuf/CarlifeTransferDataFinishProto$CarlifeTransferDataFinish:toByteArray	()[B
    //   50: invokevirtual 120	com/baidu/carlife/core/connect/c:b	([B)V
    //   53: aload 4
    //   55: aload_3
    //   56: invokevirtual 124	com/baidu/carlife/protobuf/CarlifeTransferDataFinishProto$CarlifeTransferDataFinish:getSerializedSize	()I
    //   59: invokevirtual 127	com/baidu/carlife/core/connect/c:d	(I)V
    //   62: aload 4
    //   64: ldc -128
    //   66: invokevirtual 130	com/baidu/carlife/core/connect/c:c	(I)V
    //   69: invokestatic 88	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   72: aload 4
    //   74: invokevirtual 133	com/baidu/carlife/l/a:a	(Lcom/baidu/carlife/core/connect/c;)I
    //   77: istore_1
    //   78: goto -63 -> 15
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	d
    //   0	86	1	paramInt	int
    //   8	2	2	bool	boolean
    //   22	34	3	localObject1	Object
    //   81	4	3	localObject2	Object
    //   42	31	4	localc	com.baidu.carlife.core.connect.c
    // Exception table:
    //   from	to	target	type
    //   2	9	81	finally
    //   19	78	81	finally
  }
  
  /* Error */
  private int a(int paramInt1, CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType paramDataType, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 88	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   5: invokevirtual 92	com/baidu/carlife/l/a:N	()Z
    //   8: istore 5
    //   10: iload 5
    //   12: ifne +9 -> 21
    //   15: iconst_m1
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: invokestatic 139	com/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart:newBuilder	()Lcom/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder;
    //   24: astore 6
    //   26: aload 6
    //   28: aload_2
    //   29: invokevirtual 145	com/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder:setDataType	(Lcom/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$DataType;)Lcom/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder;
    //   32: pop
    //   33: aload 6
    //   35: iload_3
    //   36: invokevirtual 149	com/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder:setDataLen	(I)Lcom/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder;
    //   39: pop
    //   40: aload 6
    //   42: aload 4
    //   44: invokevirtual 153	com/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder:setDataName	(Ljava/lang/String;)Lcom/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder;
    //   47: pop
    //   48: aload 6
    //   50: iload_1
    //   51: invokevirtual 155	com/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder:setFileId	(I)Lcom/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder;
    //   54: pop
    //   55: aload 6
    //   57: invokevirtual 158	com/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart$Builder:build	()Lcom/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart;
    //   60: astore_2
    //   61: new 110	com/baidu/carlife/core/connect/c
    //   64: dup
    //   65: iconst_1
    //   66: invokespecial 113	com/baidu/carlife/core/connect/c:<init>	(Z)V
    //   69: astore 4
    //   71: aload 4
    //   73: aload_2
    //   74: invokevirtual 159	com/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart:toByteArray	()[B
    //   77: invokevirtual 120	com/baidu/carlife/core/connect/c:b	([B)V
    //   80: aload 4
    //   82: aload_2
    //   83: invokevirtual 160	com/baidu/carlife/protobuf/CarlifeTransferDataStartProto$CarlifeTransferDataStart:getSerializedSize	()I
    //   86: invokevirtual 127	com/baidu/carlife/core/connect/c:d	(I)V
    //   89: aload 4
    //   91: ldc -95
    //   93: invokevirtual 130	com/baidu/carlife/core/connect/c:c	(I)V
    //   96: invokestatic 88	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   99: aload 4
    //   101: invokevirtual 133	com/baidu/carlife/l/a:a	(Lcom/baidu/carlife/core/connect/c;)I
    //   104: istore_1
    //   105: goto -88 -> 17
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	d
    //   0	113	1	paramInt1	int
    //   0	113	2	paramDataType	CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType
    //   0	113	3	paramInt2	int
    //   0	113	4	paramString	String
    //   8	3	5	bool	boolean
    //   24	32	6	localBuilder	com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.Builder
    // Exception table:
    //   from	to	target	type
    //   2	10	108	finally
    //   21	105	108	finally
  }
  
  private Message a(int paramInt, Object paramObject)
  {
    return Message.obtain(this.a, paramInt, paramObject);
  }
  
  public static d a()
  {
    if (o == null) {
      o = new d();
    }
    return o;
  }
  
  private void a(Message paramMessage)
  {
    this.a.sendMessage(paramMessage);
  }
  
  private void a(a parama)
  {
    a(a(0, new Object[] { parama }));
  }
  
  private void a(a parama, int paramInt)
  {
    a(a(3, new Object[] { parama, Integer.valueOf(paramInt) }));
  }
  
  /* Error */
  private int b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 88	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   5: invokevirtual 92	com/baidu/carlife/l/a:N	()Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifne +9 -> 19
    //   13: iconst_m1
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: invokestatic 210	com/baidu/carlife/protobuf/CarlifeTransferDataStopProto$CarlifeTransferDataStop:newBuilder	()Lcom/baidu/carlife/protobuf/CarlifeTransferDataStopProto$CarlifeTransferDataStop$Builder;
    //   22: astore_3
    //   23: aload_3
    //   24: iload_1
    //   25: invokevirtual 215	com/baidu/carlife/protobuf/CarlifeTransferDataStopProto$CarlifeTransferDataStop$Builder:setFileId	(I)Lcom/baidu/carlife/protobuf/CarlifeTransferDataStopProto$CarlifeTransferDataStop$Builder;
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 218	com/baidu/carlife/protobuf/CarlifeTransferDataStopProto$CarlifeTransferDataStop$Builder:build	()Lcom/baidu/carlife/protobuf/CarlifeTransferDataStopProto$CarlifeTransferDataStop;
    //   33: astore_3
    //   34: new 110	com/baidu/carlife/core/connect/c
    //   37: dup
    //   38: iconst_1
    //   39: invokespecial 113	com/baidu/carlife/core/connect/c:<init>	(Z)V
    //   42: astore 4
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 219	com/baidu/carlife/protobuf/CarlifeTransferDataStopProto$CarlifeTransferDataStop:toByteArray	()[B
    //   50: invokevirtual 120	com/baidu/carlife/core/connect/c:b	([B)V
    //   53: aload 4
    //   55: aload_3
    //   56: invokevirtual 220	com/baidu/carlife/protobuf/CarlifeTransferDataStopProto$CarlifeTransferDataStop:getSerializedSize	()I
    //   59: invokevirtual 127	com/baidu/carlife/core/connect/c:d	(I)V
    //   62: aload 4
    //   64: ldc -35
    //   66: invokevirtual 130	com/baidu/carlife/core/connect/c:c	(I)V
    //   69: invokestatic 88	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   72: aload 4
    //   74: invokevirtual 133	com/baidu/carlife/l/a:a	(Lcom/baidu/carlife/core/connect/c;)I
    //   77: istore_1
    //   78: goto -63 -> 15
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	d
    //   0	86	1	paramInt	int
    //   8	2	2	bool	boolean
    //   22	34	3	localObject1	Object
    //   81	4	3	localObject2	Object
    //   42	31	4	localc	com.baidu.carlife.core.connect.c
    // Exception table:
    //   from	to	target	type
    //   2	9	81	finally
    //   19	78	81	finally
  }
  
  private void b(a parama)
  {
    a(a(1, new Object[] { parama }));
  }
  
  private void c(a parama)
  {
    a(a(2, new Object[] { parama }));
  }
  
  /* Error */
  public int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 88	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   5: invokevirtual 92	com/baidu/carlife/l/a:N	()Z
    //   8: istore 4
    //   10: iload 4
    //   12: ifne +9 -> 21
    //   15: iconst_m1
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: invokestatic 234	com/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend:newBuilder	()Lcom/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend$Builder;
    //   24: astore 5
    //   26: aload 5
    //   28: iload_1
    //   29: invokevirtual 239	com/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend$Builder:setFileId	(I)Lcom/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend$Builder;
    //   32: pop
    //   33: aload 5
    //   35: iload_3
    //   36: invokevirtual 242	com/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend$Builder:setLen	(I)Lcom/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend$Builder;
    //   39: pop
    //   40: aload 5
    //   42: aload_2
    //   43: invokestatic 248	com/google/protobuf/ByteString:copyFrom	([B)Lcom/google/protobuf/ByteString;
    //   46: invokevirtual 252	com/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend$Builder:setBodyData	(Lcom/google/protobuf/ByteString;)Lcom/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend$Builder;
    //   49: pop
    //   50: aload 5
    //   52: invokevirtual 255	com/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend$Builder:build	()Lcom/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend;
    //   55: astore_2
    //   56: new 110	com/baidu/carlife/core/connect/c
    //   59: dup
    //   60: iconst_1
    //   61: invokespecial 113	com/baidu/carlife/core/connect/c:<init>	(Z)V
    //   64: astore 5
    //   66: aload 5
    //   68: aload_2
    //   69: invokevirtual 256	com/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend:toByteArray	()[B
    //   72: invokevirtual 120	com/baidu/carlife/core/connect/c:b	([B)V
    //   75: aload 5
    //   77: aload_2
    //   78: invokevirtual 257	com/baidu/carlife/protobuf/CarlifeTransferDataSendProto$CarlifeTransferDataSend:getSerializedSize	()I
    //   81: invokevirtual 127	com/baidu/carlife/core/connect/c:d	(I)V
    //   84: aload 5
    //   86: ldc_w 258
    //   89: invokevirtual 130	com/baidu/carlife/core/connect/c:c	(I)V
    //   92: invokestatic 88	com/baidu/carlife/l/a:a	()Lcom/baidu/carlife/l/a;
    //   95: aload 5
    //   97: invokevirtual 133	com/baidu/carlife/l/a:a	(Lcom/baidu/carlife/core/connect/c;)I
    //   100: istore_1
    //   101: goto -84 -> 17
    //   104: astore_2
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	d
    //   0	109	1	paramInt1	int
    //   0	109	2	paramArrayOfByte	byte[]
    //   0	109	3	paramInt2	int
    //   8	3	4	bool	boolean
    //   24	72	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	104	finally
    //   21	101	104	finally
  }
  
  public void a(Context paramContext)
  {
    this.j = paramContext;
    k.a(this.q);
    if (this.n == null)
    {
      this.n = new Thread(this.p);
      this.n.start();
    }
  }
  
  public void a(String paramString, CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType paramDataType, a parama)
  {
    if (!a.a().N()) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          FileInputStream localFileInputStream = new FileInputStream(paramString);
          c localc = new c();
          localc.a(paramString.getName());
          localc.a(paramDataType);
          localc.a(parama);
          localc.a(localFileInputStream);
          this.m.put(localc);
          return;
        }
      }
      catch (InterruptedException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString, CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType paramDataType, a parama)
  {
    if (!a.a().N()) {
      return;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    c localc = new c();
    localc.a(paramString);
    localc.a(paramDataType);
    localc.a(parama);
    localc.a(paramArrayOfByte);
    try
    {
      this.m.put(localc);
      return;
    }
    catch (InterruptedException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */