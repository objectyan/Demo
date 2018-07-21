package com.baidu.navisdk.util.common;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SDKDebugUtil
{
  private static final int RECORD_RP_ERROR_CODE = 1;
  private static SDKDebugUtil sInstance = null;
  private static final String sRpErrorCodeFileName = "error_code.txt";
  private Handler mHandler = null;
  private HandlerThread mThread = new HandlerThread("sdkDebug");
  
  private SDKDebugUtil()
  {
    if ((this.mThread != null) && (!this.mThread.isAlive())) {
      this.mThread.start();
    }
    this.mHandler = new Handler(this.mThread.getLooper())
    {
      /* Error */
      public void handleMessage(Message paramAnonymousMessage)
      {
        // Byte code:
        //   0: aload_1
        //   1: getfield 28	android/os/Message:what	I
        //   4: tableswitch	default:+20->24, 1:+21->25
        //   24: return
        //   25: aload_1
        //   26: getfield 31	android/os/Message:arg1	I
        //   29: istore_2
        //   30: aload_0
        //   31: getfield 14	com/baidu/navisdk/util/common/SDKDebugUtil$1:this$0	Lcom/baidu/navisdk/util/common/SDKDebugUtil;
        //   34: ldc 33
        //   36: invokestatic 37	com/baidu/navisdk/util/common/SDKDebugUtil:access$000	(Lcom/baidu/navisdk/util/common/SDKDebugUtil;Ljava/lang/String;)Ljava/io/File;
        //   39: astore_3
        //   40: aconst_null
        //   41: astore_1
        //   42: aconst_null
        //   43: astore 4
        //   45: new 39	java/io/BufferedWriter
        //   48: dup
        //   49: new 41	java/io/FileWriter
        //   52: dup
        //   53: aload_3
        //   54: iconst_1
        //   55: invokespecial 44	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
        //   58: invokespecial 47	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   61: astore_3
        //   62: aload_3
        //   63: aload_0
        //   64: getfield 14	com/baidu/navisdk/util/common/SDKDebugUtil$1:this$0	Lcom/baidu/navisdk/util/common/SDKDebugUtil;
        //   67: iload_2
        //   68: invokestatic 51	com/baidu/navisdk/util/common/SDKDebugUtil:access$100	(Lcom/baidu/navisdk/util/common/SDKDebugUtil;I)Ljava/lang/String;
        //   71: invokevirtual 55	java/io/BufferedWriter:write	(Ljava/lang/String;)V
        //   74: aload_3
        //   75: invokevirtual 58	java/io/BufferedWriter:newLine	()V
        //   78: aload_3
        //   79: invokevirtual 61	java/io/BufferedWriter:flush	()V
        //   82: aload_3
        //   83: ifnull +100 -> 183
        //   86: aload_3
        //   87: invokevirtual 64	java/io/BufferedWriter:close	()V
        //   90: return
        //   91: astore_1
        //   92: aload_1
        //   93: invokevirtual 67	java/io/IOException:printStackTrace	()V
        //   96: return
        //   97: astore_1
        //   98: aload 4
        //   100: astore_3
        //   101: aload_1
        //   102: astore 4
        //   104: aload_3
        //   105: astore_1
        //   106: ldc 69
        //   108: new 71	java/lang/StringBuilder
        //   111: dup
        //   112: invokespecial 72	java/lang/StringBuilder:<init>	()V
        //   115: ldc 74
        //   117: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   120: aload 4
        //   122: invokevirtual 82	java/io/IOException:getMessage	()Ljava/lang/String;
        //   125: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   128: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   131: invokestatic 91	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   134: aload_3
        //   135: ifnull -111 -> 24
        //   138: aload_3
        //   139: invokevirtual 64	java/io/BufferedWriter:close	()V
        //   142: return
        //   143: astore_1
        //   144: aload_1
        //   145: invokevirtual 67	java/io/IOException:printStackTrace	()V
        //   148: return
        //   149: astore_3
        //   150: aload_1
        //   151: ifnull +7 -> 158
        //   154: aload_1
        //   155: invokevirtual 64	java/io/BufferedWriter:close	()V
        //   158: aload_3
        //   159: athrow
        //   160: astore_1
        //   161: aload_1
        //   162: invokevirtual 67	java/io/IOException:printStackTrace	()V
        //   165: goto -7 -> 158
        //   168: astore 4
        //   170: aload_3
        //   171: astore_1
        //   172: aload 4
        //   174: astore_3
        //   175: goto -25 -> 150
        //   178: astore 4
        //   180: goto -76 -> 104
        //   183: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	184	0	this	1
        //   0	184	1	paramAnonymousMessage	Message
        //   29	39	2	i	int
        //   39	100	3	localObject1	Object
        //   149	22	3	localObject2	Object
        //   174	1	3	localObject3	Object
        //   43	78	4	localMessage	Message
        //   168	5	4	localObject4	Object
        //   178	1	4	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   86	90	91	java/io/IOException
        //   45	62	97	java/io/IOException
        //   138	142	143	java/io/IOException
        //   45	62	149	finally
        //   106	134	149	finally
        //   154	158	160	java/io/IOException
        //   62	82	168	finally
        //   62	82	178	java/io/IOException
      }
    };
  }
  
  private File getErrorCodeFile(String paramString)
  {
    paramString = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + paramString);
    if (paramString.exists()) {
      return paramString;
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return paramString;
  }
  
  private String getErrorCodeStr(int paramInt)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd_HH:mm:ss_");
    return localSimpleDateFormat.format(new Date()) + String.valueOf(paramInt);
  }
  
  public static SDKDebugUtil getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new SDKDebugUtil();
      }
      return sInstance;
    }
    finally {}
  }
  
  @SuppressLint({"NewApi"})
  public void destory()
  {
    if ((this.mThread != null) && (this.mThread.isAlive())) {
      this.mThread.quit();
    }
  }
  
  public void recordRPErrorCode(int paramInt)
  {
    if (this.mHandler != null)
    {
      Message localMessage = this.mHandler.obtainMessage(1);
      localMessage.arg1 = paramInt;
      localMessage.sendToTarget();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/SDKDebugUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */