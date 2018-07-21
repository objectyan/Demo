package com.baidu.speech.audio;

import android.media.AudioRecord;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.speech.utils.LogUtil;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicrophoneServer
  implements Runnable
{
  public static String SOCKET_ADDRESS;
  public static final int S_DATA_LENGTH = 1920000;
  public static final int S_LENGTH = 640;
  public static final String TAG = MicrophoneServer.class.getSimpleName();
  private static HashMap<String, MicrophoneServer> sPorts = new HashMap();
  private static Random sRandom;
  private boolean firstStart = true;
  private int mAudioSource;
  private DataInputStream mIn = null;
  private String mInfile;
  private ArrayList<SocketWrap> mRemoteOutputStreams = new ArrayList();
  private final int mServerPort;
  private LocalServerSocket mServerSocket;
  private final byte[] sData = new byte[1920000];
  private final int sLen = 640;
  private long sLimit = 0L;
  
  static
  {
    SOCKET_ADDRESS = "com.baidu.speech";
    sRandom = new Random();
  }
  
  private MicrophoneServer(String paramString, int paramInt)
    throws IOException
  {
    this.mInfile = paramString;
    this.mAudioSource = paramInt;
    LogUtil.i(TAG, new String[] { " infile:" + paramString + "  audioSource:" + paramInt });
    if (TextUtils.isEmpty(paramString)) {
      this.mServerSocket = new LocalServerSocket(SOCKET_ADDRESS);
    }
    for (this.mServerPort = 0;; this.mServerPort = paramInt)
    {
      new Thread("MicrophoneServer")
      {
        public void run()
        {
          try
          {
            localObject3 = MicrophoneServer.this.mServerSocket.accept();
            LogUtil.i(MicrophoneServer.TAG, new String[] { "server accept socket" });
            synchronized (MicrophoneServer.this.mRemoteOutputStreams)
            {
              localObject3 = new MicrophoneServer.SocketWrap((LocalSocket)localObject3);
              MicrophoneServer.this.mRemoteOutputStreams.add(localObject3);
              LogUtil.i(MicrophoneServer.TAG, new String[] { "add wrap socket, mRemoteOutputStreams size = " + MicrophoneServer.this.mRemoteOutputStreams.size() + " firstStart = " + MicrophoneServer.this.firstStart });
              if ((MicrophoneServer.this.mRemoteOutputStreams.size() == 1) && (MicrophoneServer.this.firstStart))
              {
                MicrophoneServer.access$202(MicrophoneServer.this, false);
                localObject3 = MicrophoneServer.this.mIn;
                if (localObject3 == null) {}
              }
            }
          }
          catch (Exception localException1)
          {
            try
            {
              for (;;)
              {
                MicrophoneServer.this.mIn.close();
                MicrophoneServer.access$302(MicrophoneServer.this, null);
                Object localObject3 = MicrophoneServer.this.createInputStream(MicrophoneServer.this.mInfile, MicrophoneServer.this.mAudioSource);
                MicrophoneServer.access$302(MicrophoneServer.this, new DataInputStream((InputStream)localObject3));
                new Thread(MicrophoneServer.this).start();
              }
              localObject4 = finally;
              throw ((Throwable)localObject4);
              localException1 = localException1;
              LogUtil.i(MicrophoneServer.TAG, new String[] { " ports:" + MicrophoneServer.this.mServerPort + " mRemoteOutputStreams.size：" + MicrophoneServer.this.mRemoteOutputStreams.size() });
              MicrophoneServer.access$202(MicrophoneServer.this, true);
              synchronized (MicrophoneServer.this.mRemoteOutputStreams)
              {
                localObject5 = MicrophoneServer.this.mRemoteOutputStreams.iterator();
                for (;;)
                {
                  if (((Iterator)localObject5).hasNext())
                  {
                    LocalSocket localLocalSocket = (LocalSocket)((Iterator)localObject5).next();
                    try
                    {
                      localLocalSocket.getOutputStream().close();
                      localLocalSocket.close();
                    }
                    catch (IOException localIOException)
                    {
                      localIOException.printStackTrace();
                    }
                  }
                }
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                localException2.printStackTrace();
              }
              MicrophoneServer.this.mRemoteOutputStreams.clear();
              Object localObject5 = MicrophoneServer.this.mIn;
              if (localObject5 != null) {}
              try
              {
                MicrophoneServer.this.mIn.close();
                MicrophoneServer.access$302(MicrophoneServer.this, null);
              }
              catch (Exception localException3)
              {
                try
                {
                  MicrophoneServer.this.mServerSocket.close();
                }
                catch (Exception localException3)
                {
                  synchronized (MicrophoneServer.sPorts)
                  {
                    for (;;)
                    {
                      MicrophoneServer.sPorts.remove(MicrophoneServer.this.mInfile);
                      ((Exception)localObject1).printStackTrace();
                      return;
                      localException4 = localException4;
                      localException4.printStackTrace();
                    }
                    localException3 = localException3;
                    localException3.printStackTrace();
                  }
                }
              }
            }
          }
        }
      }.start();
      return;
      paramInt = sRandom.nextInt(1000) + 1;
      LogUtil.i(TAG, new String[] { "address=" + paramInt });
      this.mServerSocket = new LocalServerSocket(SOCKET_ADDRESS + "_" + paramInt);
    }
  }
  
  public static int create(String paramString, int paramInt)
    throws IOException
  {
    LogUtil.i(TAG, new String[] { "[create] infile:" + paramString + "  audioSource:" + paramInt });
    synchronized (sPorts)
    {
      MicrophoneServer localMicrophoneServer = (MicrophoneServer)sPorts.get(paramString);
      if (localMicrophoneServer == null) {}
      try
      {
        localMicrophoneServer = new MicrophoneServer(paramString, paramInt);
        sPorts.put(paramString, localMicrophoneServer);
        paramInt = ((MicrophoneServer)sPorts.get(paramString)).mServerPort;
        return paramInt;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return 0;
      }
    }
  }
  
  private InputStream createInputStream(String paramString, int paramInt)
    throws Exception
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      Object localObject;
      if (paramString.startsWith("#"))
      {
        localObject = Pattern.compile("^#(.*)[#.](.*?)\\(").matcher(paramString);
        if (((Matcher)localObject).find())
        {
          paramString = ((Matcher)localObject).group(1);
          localObject = ((Matcher)localObject).group(2);
          return (InputStream)Class.forName(paramString).getMethod((String)localObject, new Class[0]).invoke(null, new Object[0]);
        }
      }
      else
      {
        if (paramString.startsWith("res://"))
        {
          paramString = paramString.replaceFirst("res://", "").replaceFirst("/", "");
          return getClass().getResourceAsStream("/" + paramString);
        }
        if ((paramString.startsWith("asset://")) || (paramString.startsWith("assets://")))
        {
          localObject = paramString.replaceFirst("assets://", "").replaceFirst("/", "");
          if (paramString.startsWith("asset://")) {
            localObject = paramString.replaceFirst("asset://", "").replaceFirst("/", "");
          }
          return getClass().getResourceAsStream("/assets/" + (String)localObject);
        }
        if (paramString.startsWith("tcp://")) {
          return new Socket("localhost", Integer.parseInt(paramString.replaceFirst("tcp://", "").replaceFirst("/", ""))).getInputStream();
        }
        return new FileInputStream(paramString);
      }
    }
    else
    {
      return new MicInputStream(paramInt, 16000);
    }
    throw new IOException("can not create inputStream");
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 81	com/baidu/speech/audio/MicrophoneServer:sLimit	J
    //   6: lstore 6
    //   8: aload_0
    //   9: getfield 77	com/baidu/speech/audio/MicrophoneServer:sData	[B
    //   12: arraylength
    //   13: i2l
    //   14: lstore 8
    //   16: lload 6
    //   18: lload 8
    //   20: lrem
    //   21: l2i
    //   22: istore_1
    //   23: aload_0
    //   24: getfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   27: aload_0
    //   28: getfield 77	com/baidu/speech/audio/MicrophoneServer:sData	[B
    //   31: iload_1
    //   32: sipush 640
    //   35: invokevirtual 304	java/io/DataInputStream:readFully	([BII)V
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 81	com/baidu/speech/audio/MicrophoneServer:sLimit	J
    //   43: ldc2_w 305
    //   46: ladd
    //   47: putfield 81	com/baidu/speech/audio/MicrophoneServer:sLimit	J
    //   50: iload_1
    //   51: sipush 640
    //   54: iadd
    //   55: istore_3
    //   56: aload_0
    //   57: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   60: astore 10
    //   62: aload 10
    //   64: monitorenter
    //   65: iconst_0
    //   66: istore_1
    //   67: iload_1
    //   68: aload_0
    //   69: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   72: invokevirtual 310	java/util/ArrayList:size	()I
    //   75: if_icmpge +419 -> 494
    //   78: aload_0
    //   79: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   82: iload_1
    //   83: invokevirtual 313	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   86: checkcast 13	com/baidu/speech/audio/MicrophoneServer$SocketWrap
    //   89: astore 11
    //   91: aload 11
    //   93: aload_0
    //   94: getfield 81	com/baidu/speech/audio/MicrophoneServer:sLimit	J
    //   97: invokevirtual 317	com/baidu/speech/audio/MicrophoneServer$SocketWrap:getPosition	(J)J
    //   100: aload_0
    //   101: getfield 77	com/baidu/speech/audio/MicrophoneServer:sData	[B
    //   104: arraylength
    //   105: i2l
    //   106: lrem
    //   107: l2i
    //   108: istore 4
    //   110: aload 11
    //   112: invokevirtual 321	com/baidu/speech/audio/MicrophoneServer$SocketWrap:getOutputStream	()Ljava/io/OutputStream;
    //   115: astore 12
    //   117: iload_3
    //   118: iload 4
    //   120: isub
    //   121: istore 5
    //   123: iload 5
    //   125: iflt +178 -> 303
    //   128: aload 12
    //   130: aload_0
    //   131: getfield 77	com/baidu/speech/audio/MicrophoneServer:sData	[B
    //   134: iload 4
    //   136: iload 5
    //   138: invokevirtual 326	java/io/OutputStream:write	([BII)V
    //   141: aload 11
    //   143: aload_0
    //   144: getfield 81	com/baidu/speech/audio/MicrophoneServer:sLimit	J
    //   147: invokevirtual 330	com/baidu/speech/audio/MicrophoneServer$SocketWrap:setPosition	(J)V
    //   150: iload_1
    //   151: iconst_1
    //   152: iadd
    //   153: istore_1
    //   154: goto -87 -> 67
    //   157: astore 10
    //   159: aload 10
    //   161: invokevirtual 331	java/io/EOFException:printStackTrace	()V
    //   164: aload_0
    //   165: iconst_1
    //   166: putfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   169: aload_0
    //   170: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   173: astore 10
    //   175: aload 10
    //   177: monitorenter
    //   178: getstatic 54	com/baidu/speech/audio/MicrophoneServer:TAG	Ljava/lang/String;
    //   181: iconst_1
    //   182: anewarray 96	java/lang/String
    //   185: dup
    //   186: iconst_0
    //   187: new 98	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 333
    //   197: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_0
    //   201: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   204: invokevirtual 310	java/util/ArrayList:size	()I
    //   207: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: ldc_w 335
    //   213: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: getfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   220: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: aastore
    //   227: invokestatic 119	com/baidu/speech/utils/LogUtil:i	(Ljava/lang/String;[Ljava/lang/String;)V
    //   230: aload_0
    //   231: getfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   234: iconst_1
    //   235: if_icmpne +714 -> 949
    //   238: aload_0
    //   239: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   242: invokevirtual 342	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   245: astore 11
    //   247: aload 11
    //   249: invokeinterface 347 1 0
    //   254: ifeq +699 -> 953
    //   257: aload 11
    //   259: invokeinterface 351 1 0
    //   264: checkcast 353	android/net/LocalSocket
    //   267: astore 12
    //   269: aload 12
    //   271: invokevirtual 354	android/net/LocalSocket:getOutputStream	()Ljava/io/OutputStream;
    //   274: invokevirtual 357	java/io/OutputStream:close	()V
    //   277: aload 12
    //   279: invokevirtual 358	android/net/LocalSocket:close	()V
    //   282: goto -35 -> 247
    //   285: astore 12
    //   287: aload 12
    //   289: invokevirtual 359	java/io/IOException:printStackTrace	()V
    //   292: goto -45 -> 247
    //   295: astore 11
    //   297: aload 10
    //   299: monitorexit
    //   300: aload 11
    //   302: athrow
    //   303: aload 12
    //   305: aload_0
    //   306: getfield 77	com/baidu/speech/audio/MicrophoneServer:sData	[B
    //   309: iload 4
    //   311: aload_0
    //   312: getfield 77	com/baidu/speech/audio/MicrophoneServer:sData	[B
    //   315: arraylength
    //   316: iload 4
    //   318: isub
    //   319: invokevirtual 326	java/io/OutputStream:write	([BII)V
    //   322: aload 12
    //   324: aload_0
    //   325: getfield 77	com/baidu/speech/audio/MicrophoneServer:sData	[B
    //   328: iconst_0
    //   329: iload_3
    //   330: invokevirtual 326	java/io/OutputStream:write	([BII)V
    //   333: goto -192 -> 141
    //   336: astore 12
    //   338: aload 11
    //   340: invokevirtual 321	com/baidu/speech/audio/MicrophoneServer$SocketWrap:getOutputStream	()Ljava/io/OutputStream;
    //   343: invokevirtual 357	java/io/OutputStream:close	()V
    //   346: aload 11
    //   348: invokevirtual 360	com/baidu/speech/audio/MicrophoneServer$SocketWrap:close	()V
    //   351: aload_0
    //   352: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   355: aload 11
    //   357: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   360: pop
    //   361: goto -211 -> 150
    //   364: astore 11
    //   366: aload 10
    //   368: monitorexit
    //   369: aload 11
    //   371: athrow
    //   372: astore 10
    //   374: aload_0
    //   375: iconst_1
    //   376: putfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   379: aload_0
    //   380: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   383: astore 11
    //   385: aload 11
    //   387: monitorenter
    //   388: iload_2
    //   389: istore_1
    //   390: iload_1
    //   391: aload_0
    //   392: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   395: invokevirtual 310	java/util/ArrayList:size	()I
    //   398: if_icmpge +325 -> 723
    //   401: aload_0
    //   402: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   405: iload_1
    //   406: invokevirtual 313	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   409: checkcast 353	android/net/LocalSocket
    //   412: astore 10
    //   414: aload 10
    //   416: invokevirtual 354	android/net/LocalSocket:getOutputStream	()Ljava/io/OutputStream;
    //   419: astore 12
    //   421: aload_0
    //   422: getfield 92	com/baidu/speech/audio/MicrophoneServer:mInfile	Ljava/lang/String;
    //   425: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   428: ifeq +93 -> 521
    //   431: bipush 6
    //   433: newarray <illegal type>
    //   435: astore 10
    //   437: aload 10
    //   439: dup
    //   440: iconst_0
    //   441: ldc_w 364
    //   444: bastore
    //   445: dup
    //   446: iconst_1
    //   447: ldc_w 364
    //   450: bastore
    //   451: dup
    //   452: iconst_2
    //   453: ldc_w 364
    //   456: bastore
    //   457: dup
    //   458: iconst_3
    //   459: ldc_w 364
    //   462: bastore
    //   463: dup
    //   464: iconst_4
    //   465: ldc_w 364
    //   468: bastore
    //   469: dup
    //   470: iconst_5
    //   471: ldc_w 364
    //   474: bastore
    //   475: pop
    //   476: aload 12
    //   478: aload 10
    //   480: iconst_0
    //   481: aload 10
    //   483: arraylength
    //   484: invokevirtual 326	java/io/OutputStream:write	([BII)V
    //   487: iload_1
    //   488: iconst_1
    //   489: iadd
    //   490: istore_1
    //   491: goto -101 -> 390
    //   494: aload_0
    //   495: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   498: invokevirtual 310	java/util/ArrayList:size	()I
    //   501: ifgt +14 -> 515
    //   504: aload_0
    //   505: iconst_1
    //   506: putfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   509: aload 10
    //   511: monitorexit
    //   512: goto -343 -> 169
    //   515: aload 10
    //   517: monitorexit
    //   518: goto -516 -> 2
    //   521: bipush 6
    //   523: newarray <illegal type>
    //   525: astore 10
    //   527: aload 10
    //   529: dup
    //   530: iconst_0
    //   531: ldc_w 365
    //   534: bastore
    //   535: dup
    //   536: iconst_1
    //   537: ldc_w 364
    //   540: bastore
    //   541: dup
    //   542: iconst_2
    //   543: ldc_w 364
    //   546: bastore
    //   547: dup
    //   548: iconst_3
    //   549: ldc_w 364
    //   552: bastore
    //   553: dup
    //   554: iconst_4
    //   555: ldc_w 364
    //   558: bastore
    //   559: dup
    //   560: iconst_5
    //   561: ldc_w 364
    //   564: bastore
    //   565: pop
    //   566: goto -90 -> 476
    //   569: astore 10
    //   571: aload 10
    //   573: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   576: goto -89 -> 487
    //   579: astore 10
    //   581: aload 11
    //   583: monitorexit
    //   584: aload 10
    //   586: athrow
    //   587: astore 11
    //   589: aload_0
    //   590: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   593: astore 10
    //   595: aload 10
    //   597: monitorenter
    //   598: getstatic 54	com/baidu/speech/audio/MicrophoneServer:TAG	Ljava/lang/String;
    //   601: iconst_1
    //   602: anewarray 96	java/lang/String
    //   605: dup
    //   606: iconst_0
    //   607: new 98	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   614: ldc_w 333
    //   617: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload_0
    //   621: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   624: invokevirtual 310	java/util/ArrayList:size	()I
    //   627: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   630: ldc_w 335
    //   633: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_0
    //   637: getfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   640: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   643: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: aastore
    //   647: invokestatic 119	com/baidu/speech/utils/LogUtil:i	(Ljava/lang/String;[Ljava/lang/String;)V
    //   650: aload_0
    //   651: getfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   654: iconst_1
    //   655: if_icmpne +212 -> 867
    //   658: aload_0
    //   659: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   662: invokevirtual 342	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   665: astore 12
    //   667: aload 12
    //   669: invokeinterface 347 1 0
    //   674: ifeq +210 -> 884
    //   677: aload 12
    //   679: invokeinterface 351 1 0
    //   684: checkcast 353	android/net/LocalSocket
    //   687: astore 13
    //   689: aload 13
    //   691: invokevirtual 354	android/net/LocalSocket:getOutputStream	()Ljava/io/OutputStream;
    //   694: invokevirtual 357	java/io/OutputStream:close	()V
    //   697: aload 13
    //   699: invokevirtual 358	android/net/LocalSocket:close	()V
    //   702: goto -35 -> 667
    //   705: astore 13
    //   707: aload 13
    //   709: invokevirtual 359	java/io/IOException:printStackTrace	()V
    //   712: goto -45 -> 667
    //   715: astore 11
    //   717: aload 10
    //   719: monitorexit
    //   720: aload 11
    //   722: athrow
    //   723: aload 11
    //   725: monitorexit
    //   726: aload_0
    //   727: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   730: astore 10
    //   732: aload 10
    //   734: monitorenter
    //   735: getstatic 54	com/baidu/speech/audio/MicrophoneServer:TAG	Ljava/lang/String;
    //   738: iconst_1
    //   739: anewarray 96	java/lang/String
    //   742: dup
    //   743: iconst_0
    //   744: new 98	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 333
    //   754: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_0
    //   758: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   761: invokevirtual 310	java/util/ArrayList:size	()I
    //   764: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   767: ldc_w 335
    //   770: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: aload_0
    //   774: getfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   777: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   780: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: aastore
    //   784: invokestatic 119	com/baidu/speech/utils/LogUtil:i	(Ljava/lang/String;[Ljava/lang/String;)V
    //   787: aload_0
    //   788: getfield 90	com/baidu/speech/audio/MicrophoneServer:firstStart	Z
    //   791: iconst_1
    //   792: if_icmpne +88 -> 880
    //   795: aload_0
    //   796: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   799: invokevirtual 342	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   802: astore 11
    //   804: aload 11
    //   806: invokeinterface 347 1 0
    //   811: ifeq +102 -> 913
    //   814: aload 11
    //   816: invokeinterface 351 1 0
    //   821: checkcast 353	android/net/LocalSocket
    //   824: astore 12
    //   826: aload 12
    //   828: invokevirtual 354	android/net/LocalSocket:getOutputStream	()Ljava/io/OutputStream;
    //   831: invokevirtual 357	java/io/OutputStream:close	()V
    //   834: aload 12
    //   836: invokevirtual 358	android/net/LocalSocket:close	()V
    //   839: goto -35 -> 804
    //   842: astore 12
    //   844: aload 12
    //   846: invokevirtual 359	java/io/IOException:printStackTrace	()V
    //   849: goto -45 -> 804
    //   852: astore 11
    //   854: aload 10
    //   856: monitorexit
    //   857: aload 11
    //   859: athrow
    //   860: astore 12
    //   862: aload 12
    //   864: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   867: aload 10
    //   869: monitorexit
    //   870: aload 11
    //   872: athrow
    //   873: astore 11
    //   875: aload 11
    //   877: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   880: aload 10
    //   882: monitorexit
    //   883: return
    //   884: aload_0
    //   885: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   888: invokevirtual 368	java/util/ArrayList:clear	()V
    //   891: aload_0
    //   892: getfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   895: ifnull -28 -> 867
    //   898: aload_0
    //   899: getfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   902: invokevirtual 369	java/io/DataInputStream:close	()V
    //   905: aload_0
    //   906: aconst_null
    //   907: putfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   910: goto -43 -> 867
    //   913: aload_0
    //   914: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   917: invokevirtual 368	java/util/ArrayList:clear	()V
    //   920: aload_0
    //   921: getfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   924: ifnull -44 -> 880
    //   927: aload_0
    //   928: getfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   931: invokevirtual 369	java/io/DataInputStream:close	()V
    //   934: aload_0
    //   935: aconst_null
    //   936: putfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   939: goto -59 -> 880
    //   942: astore 11
    //   944: aload 11
    //   946: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   949: aload 10
    //   951: monitorexit
    //   952: return
    //   953: aload_0
    //   954: getfield 86	com/baidu/speech/audio/MicrophoneServer:mRemoteOutputStreams	Ljava/util/ArrayList;
    //   957: invokevirtual 368	java/util/ArrayList:clear	()V
    //   960: aload_0
    //   961: getfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   964: ifnull -15 -> 949
    //   967: aload_0
    //   968: getfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   971: invokevirtual 369	java/io/DataInputStream:close	()V
    //   974: aload_0
    //   975: aconst_null
    //   976: putfield 88	com/baidu/speech/audio/MicrophoneServer:mIn	Ljava/io/DataInputStream;
    //   979: goto -30 -> 949
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	982	0	this	MicrophoneServer
    //   22	469	1	i	int
    //   1	388	2	j	int
    //   55	275	3	k	int
    //   108	211	4	m	int
    //   121	16	5	n	int
    //   6	11	6	l1	long
    //   14	5	8	l2	long
    //   60	3	10	localArrayList1	ArrayList
    //   157	3	10	localEOFException	java.io.EOFException
    //   173	194	10	localArrayList2	ArrayList
    //   372	1	10	localException1	Exception
    //   412	116	10	localObject1	Object
    //   569	3	10	localException2	Exception
    //   579	6	10	localObject2	Object
    //   593	357	10	localArrayList3	ArrayList
    //   89	169	11	localObject3	Object
    //   295	61	11	localObject4	Object
    //   364	6	11	localObject5	Object
    //   383	199	11	localArrayList4	ArrayList
    //   587	1	11	localObject6	Object
    //   715	9	11	localObject7	Object
    //   802	13	11	localIterator	Iterator
    //   852	19	11	localObject8	Object
    //   873	3	11	localException3	Exception
    //   942	3	11	localException4	Exception
    //   115	163	12	localObject9	Object
    //   285	38	12	localIOException1	IOException
    //   336	1	12	localException5	Exception
    //   419	416	12	localObject10	Object
    //   842	3	12	localIOException2	IOException
    //   860	3	12	localException6	Exception
    //   687	11	13	localLocalSocket	LocalSocket
    //   705	3	13	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   23	38	157	java/io/EOFException
    //   269	282	285	java/io/IOException
    //   178	247	295	finally
    //   247	269	295	finally
    //   269	282	295	finally
    //   287	292	295	finally
    //   297	300	295	finally
    //   944	949	295	finally
    //   949	952	295	finally
    //   953	960	295	finally
    //   960	979	295	finally
    //   91	117	336	java/lang/Exception
    //   128	141	336	java/lang/Exception
    //   141	150	336	java/lang/Exception
    //   303	333	336	java/lang/Exception
    //   67	91	364	finally
    //   91	117	364	finally
    //   128	141	364	finally
    //   141	150	364	finally
    //   303	333	364	finally
    //   338	361	364	finally
    //   366	369	364	finally
    //   494	512	364	finally
    //   515	518	364	finally
    //   2	16	372	java/lang/Exception
    //   23	38	372	java/lang/Exception
    //   38	50	372	java/lang/Exception
    //   56	65	372	java/lang/Exception
    //   159	169	372	java/lang/Exception
    //   369	372	372	java/lang/Exception
    //   414	476	569	java/lang/Exception
    //   476	487	569	java/lang/Exception
    //   521	527	569	java/lang/Exception
    //   390	414	579	finally
    //   414	476	579	finally
    //   476	487	579	finally
    //   521	527	579	finally
    //   571	576	579	finally
    //   581	584	579	finally
    //   723	726	579	finally
    //   2	16	587	finally
    //   23	38	587	finally
    //   38	50	587	finally
    //   56	65	587	finally
    //   159	169	587	finally
    //   369	372	587	finally
    //   374	388	587	finally
    //   584	587	587	finally
    //   689	702	705	java/io/IOException
    //   598	667	715	finally
    //   667	689	715	finally
    //   689	702	715	finally
    //   707	712	715	finally
    //   717	720	715	finally
    //   862	867	715	finally
    //   867	870	715	finally
    //   884	891	715	finally
    //   891	910	715	finally
    //   826	839	842	java/io/IOException
    //   735	804	852	finally
    //   804	826	852	finally
    //   826	839	852	finally
    //   844	849	852	finally
    //   854	857	852	finally
    //   875	880	852	finally
    //   880	883	852	finally
    //   913	920	852	finally
    //   920	939	852	finally
    //   891	910	860	java/lang/Exception
    //   920	939	873	java/lang/Exception
    //   960	979	942	java/lang/Exception
  }
  
  public static class MicInputStream
    extends InputStream
  {
    private static final int DEFAULT_BUFFER_SIZE = 160000;
    private String TAG = MicInputStream.class.getSimpleName();
    private AudioRecord mAudioRecord;
    
    public MicInputStream(int paramInt1, int paramInt2)
    {
      for (;;)
      {
        try
        {
          this.mAudioRecord = new AudioRecord(paramInt1, paramInt2, 16, 2, 160000);
          LogUtil.w("audioSource : ", new String[] { paramInt1 + "" });
          LogUtil.d(this.TAG, new String[] { "startRecordingAndCheckStatus recorder status is " + this.mAudioRecord.getState() });
          this.mAudioRecord.startRecording();
          localObject1 = new byte[32];
          paramInt1 = 0;
          if (paramInt1 >= 10) {
            continue;
          }
          paramInt2 = this.mAudioRecord.read((byte[])localObject1, 0, localObject1.length);
          if (paramInt2 <= 0) {
            continue;
          }
          paramInt1 = 0 + paramInt2;
        }
        catch (Exception localException2)
        {
          Object localObject1;
          localException2.printStackTrace();
          if ((this.mAudioRecord != null) && (this.mAudioRecord.getRecordingState() != 3)) {
            continue;
          }
          paramInt1 = this.mAudioRecord.getState();
          AudioRecord localAudioRecord1 = this.mAudioRecord;
          if (paramInt1 != 0) {
            continue;
          }
          try
          {
            this.mAudioRecord.release();
            LogUtil.d(this.TAG, new String[] { "recorder start failed, RecordingState=" + this.mAudioRecord.getRecordingState() });
            return;
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            continue;
          }
        }
        finally
        {
          if ((this.mAudioRecord != null) && (this.mAudioRecord.getRecordingState() != 3)) {
            continue;
          }
          paramInt1 = this.mAudioRecord.getState();
          AudioRecord localAudioRecord2 = this.mAudioRecord;
          if (paramInt1 != 0) {
            continue;
          }
          try
          {
            this.mAudioRecord.release();
            LogUtil.d(this.TAG, new String[] { "recorder start failed, RecordingState=" + this.mAudioRecord.getRecordingState() });
            throw ((Throwable)localObject2);
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
            continue;
          }
          paramInt1 = 0;
          continue;
        }
        if (paramInt1 <= 0)
        {
          this.mAudioRecord.release();
          new Exception("bad recorder, read(byte[])");
        }
        if ((this.mAudioRecord == null) || (this.mAudioRecord.getRecordingState() == 3))
        {
          paramInt1 = this.mAudioRecord.getState();
          localObject1 = this.mAudioRecord;
          if (paramInt1 != 0) {
            continue;
          }
        }
        try
        {
          this.mAudioRecord.release();
          LogUtil.d(this.TAG, new String[] { "recorder start failed, RecordingState=" + this.mAudioRecord.getRecordingState() });
          return;
          paramInt1 += 1;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.mAudioRecord != null) {
        this.mAudioRecord.release();
      }
    }
    
    public int read()
      throws IOException
    {
      throw new IOException("read not support");
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.mAudioRecord == null) {
        throw new IOException("audio recorder is null");
      }
      int i = this.mAudioRecord.read(paramArrayOfByte, paramInt1, paramInt2);
      LogUtil.i(this.TAG, new String[] { " AudioRecord read: len:" + i + " byteOffset:" + paramInt1 + " byteCount:" + paramInt2 });
      if ((i < 0) || (i > paramInt2)) {
        throw new IOException("audio recdoder read error, len = " + i);
      }
      return i;
    }
  }
  
  private static class SocketWrap
    extends LocalSocket
  {
    byte[] data = new byte[8];
    private long mPosition = -1L;
    private final LocalSocket mSocket;
    
    public SocketWrap(LocalSocket paramLocalSocket)
    {
      this.mSocket = paramLocalSocket;
      try
      {
        this.mSocket.setSoTimeout(2000);
        return;
      }
      catch (Exception paramLocalSocket)
      {
        paramLocalSocket.printStackTrace();
      }
    }
    
    private long byteArrayToInt(byte[] paramArrayOfByte)
    {
      byte[] arrayOfByte = new byte[8];
      int j = arrayOfByte.length - 1;
      int i = 0;
      if (j >= 0)
      {
        if (i < paramArrayOfByte.length) {
          arrayOfByte[j] = paramArrayOfByte[i];
        }
        for (;;)
        {
          j -= 1;
          i += 1;
          break;
          arrayOfByte[j] = 0;
        }
      }
      return ((arrayOfByte[0] & 0xFF) << 56) + ((arrayOfByte[1] & 0xFF) << 48) + ((arrayOfByte[2] & 0xFF) << 40) + ((arrayOfByte[3] & 0xFF) << 32) + ((arrayOfByte[4] & 0xFF) << 24) + ((arrayOfByte[5] & 0xFF) << 16) + ((arrayOfByte[6] & 0xFF) << 8) + (arrayOfByte[7] & 0xFF);
    }
    
    public void close()
      throws IOException
    {
      try
      {
        this.mSocket.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public OutputStream getOutputStream()
      throws IOException
    {
      return this.mSocket.getOutputStream();
    }
    
    public long getPosition(long paramLong)
    {
      if (this.mPosition >= 0L) {
        return this.mPosition;
      }
      for (;;)
      {
        try
        {
          this.mSocket.getInputStream().read(this.data, 0, this.data.length);
          long l = byteArrayToInt(this.data);
          Log.i(MicrophoneServer.TAG, "audio mills is " + l);
          if (l <= 0L) {
            continue;
          }
          this.mPosition = (Math.min(Math.max(0L, System.currentTimeMillis() - l), paramLong / 32L) / 20L * 20L * 32L);
          this.mPosition = ((paramLong - this.mPosition + 1920000L) % 1920000L);
        }
        catch (Exception localException)
        {
          this.mPosition = ((paramLong - 640L + 1920000L) % 1920000L);
          localException.printStackTrace();
          continue;
        }
        return this.mPosition;
        this.mPosition = 640L;
      }
    }
    
    public void setPosition(long paramLong)
    {
      this.mPosition = paramLong;
    }
    
    public void shutdownOutput()
      throws IOException
    {
      this.mSocket.shutdownOutput();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/audio/MicrophoneServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */