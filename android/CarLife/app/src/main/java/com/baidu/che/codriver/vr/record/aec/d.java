package com.baidu.che.codriver.vr.record.aec;

import android.media.AudioRecord;
import com.baidu.che.codriver.util.h;

public class d
  extends Thread
{
  private static final String a = "NewPcmRecorder";
  private static final int b = 16000;
  private static final int c = 5120;
  private static final int f = 65536;
  private volatile boolean d = false;
  private final Object e = new Object();
  private AudioRecord g;
  
  public d()
  {
    super("NewPcmRecorder");
    start();
    h.b("NewPcmRecorder", "----onCreate()------");
  }
  
  public void a()
  {
    h.e("NewPcmRecorder", "---startRecord------");
    if (this.d) {}
    do
    {
      return;
      this.d = true;
    } while (!this.d);
    synchronized (this.e)
    {
      if (this.d)
      {
        this.e.notify();
        return;
      }
    }
  }
  
  public void b()
  {
    h.e("NewPcmRecorder", "---pauseRecord start------");
    this.d = false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc 61
    //   4: invokestatic 44	com/baidu/che/codriver/util/h:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: bipush -19
    //   9: invokestatic 67	android/os/Process:setThreadPriority	(I)V
    //   12: sipush 5120
    //   15: newarray <illegal type>
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 28	com/baidu/che/codriver/vr/record/aec/d:d	Z
    //   22: ifne +38 -> 60
    //   25: aload_0
    //   26: getfield 34	com/baidu/che/codriver/vr/record/aec/d:e	Ljava/lang/Object;
    //   29: astore 4
    //   31: aload 4
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 28	com/baidu/che/codriver/vr/record/aec/d:d	Z
    //   38: istore_2
    //   39: iload_2
    //   40: ifne +17 -> 57
    //   43: ldc 8
    //   45: ldc 69
    //   47: invokestatic 49	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 34	com/baidu/che/codriver/vr/record/aec/d:e	Ljava/lang/Object;
    //   54: invokevirtual 72	java/lang/Object:wait	()V
    //   57: aload 4
    //   59: monitorexit
    //   60: aload_0
    //   61: new 74	android/media/AudioRecord
    //   64: dup
    //   65: iconst_1
    //   66: sipush 16000
    //   69: bipush 12
    //   71: iconst_2
    //   72: ldc 15
    //   74: invokespecial 77	android/media/AudioRecord:<init>	(IIIII)V
    //   77: putfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   80: aload_0
    //   81: getfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   84: invokevirtual 82	android/media/AudioRecord:startRecording	()V
    //   87: ldc 8
    //   89: new 84	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   96: ldc 87
    //   98: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 28	com/baidu/che/codriver/vr/record/aec/d:d	Z
    //   105: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   108: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 44	com/baidu/che/codriver/util/h:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 28	com/baidu/che/codriver/vr/record/aec/d:d	Z
    //   118: ifeq +28 -> 146
    //   121: aload_0
    //   122: getfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   125: aload_3
    //   126: iconst_0
    //   127: aload_3
    //   128: arraylength
    //   129: invokevirtual 102	android/media/AudioRecord:read	([BII)I
    //   132: istore_1
    //   133: iload_1
    //   134: bipush -3
    //   136: if_icmpne +75 -> 211
    //   139: ldc 8
    //   141: ldc 104
    //   143: invokestatic 49	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: ldc 8
    //   148: new 84	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   155: ldc 106
    //   157: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: getfield 28	com/baidu/che/codriver/vr/record/aec/d:d	Z
    //   164: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   167: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 44	com/baidu/che/codriver/util/h:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_0
    //   174: getfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   177: ifnull -159 -> 18
    //   180: aload_0
    //   181: getfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   184: invokevirtual 109	android/media/AudioRecord:release	()V
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   192: goto -174 -> 18
    //   195: astore 5
    //   197: aload 5
    //   199: invokevirtual 112	java/lang/InterruptedException:printStackTrace	()V
    //   202: goto -145 -> 57
    //   205: astore_3
    //   206: aload 4
    //   208: monitorexit
    //   209: aload_3
    //   210: athrow
    //   211: iload_1
    //   212: bipush -2
    //   214: if_icmpne +64 -> 278
    //   217: ldc 8
    //   219: ldc 114
    //   221: invokestatic 49	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: goto -78 -> 146
    //   227: astore 4
    //   229: ldc 8
    //   231: new 84	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   238: ldc 106
    //   240: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_0
    //   244: getfield 28	com/baidu/che/codriver/vr/record/aec/d:d	Z
    //   247: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   250: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 44	com/baidu/che/codriver/util/h:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload_0
    //   257: getfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   260: ifnull -242 -> 18
    //   263: aload_0
    //   264: getfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   267: invokevirtual 109	android/media/AudioRecord:release	()V
    //   270: aload_0
    //   271: aconst_null
    //   272: putfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   275: goto -257 -> 18
    //   278: iload_1
    //   279: aload_3
    //   280: arraylength
    //   281: if_icmpeq +27 -> 308
    //   284: ldc 8
    //   286: new 84	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   293: ldc 116
    //   295: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload_1
    //   299: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 49	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: iload_1
    //   309: ifle -195 -> 114
    //   312: aload_0
    //   313: getfield 28	com/baidu/che/codriver/vr/record/aec/d:d	Z
    //   316: ifeq -202 -> 114
    //   319: invokestatic 124	com/baidu/che/codriver/vr/o:a	()Lcom/baidu/che/codriver/vr/o;
    //   322: aload_3
    //   323: invokevirtual 127	com/baidu/che/codriver/vr/o:a	([B)V
    //   326: goto -212 -> 114
    //   329: astore_3
    //   330: ldc 8
    //   332: new 84	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   339: ldc 106
    //   341: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_0
    //   345: getfield 28	com/baidu/che/codriver/vr/record/aec/d:d	Z
    //   348: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   351: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 44	com/baidu/che/codriver/util/h:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_0
    //   358: getfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   361: ifnull +15 -> 376
    //   364: aload_0
    //   365: getfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   368: invokevirtual 109	android/media/AudioRecord:release	()V
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 79	com/baidu/che/codriver/vr/record/aec/d:g	Landroid/media/AudioRecord;
    //   376: aload_3
    //   377: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	this	d
    //   132	177	1	i	int
    //   38	2	2	bool	boolean
    //   17	111	3	arrayOfByte1	byte[]
    //   205	118	3	arrayOfByte2	byte[]
    //   329	48	3	localObject1	Object
    //   29	178	4	localObject2	Object
    //   227	1	4	localException	Exception
    //   195	3	5	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   43	57	195	java/lang/InterruptedException
    //   34	39	205	finally
    //   43	57	205	finally
    //   57	60	205	finally
    //   197	202	205	finally
    //   206	209	205	finally
    //   60	114	227	java/lang/Exception
    //   114	133	227	java/lang/Exception
    //   139	146	227	java/lang/Exception
    //   217	224	227	java/lang/Exception
    //   278	308	227	java/lang/Exception
    //   312	326	227	java/lang/Exception
    //   60	114	329	finally
    //   114	133	329	finally
    //   139	146	329	finally
    //   217	224	329	finally
    //   278	308	329	finally
    //   312	326	329	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/record/aec/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */