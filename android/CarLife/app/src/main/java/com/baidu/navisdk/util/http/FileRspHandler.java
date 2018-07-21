package com.baidu.navisdk.util.http;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public class FileRspHandler
  extends BaseRspHandler
{
  private static final int BUFFER_SIZE = 4096;
  private static final String TAG = "FileRspHandler";
  private static final String TEMP_SUFFIX = ".download";
  private boolean isStop = false;
  private long mDownloadSize;
  private File mFile;
  private long mNetworkSpeed;
  private long mPreviousFileSize;
  private long mPreviousTime;
  private File mTempFile;
  private long mTotalSize;
  private long mTotalTime;
  private String md5;
  
  public FileRspHandler(String paramString1, String paramString2)
  {
    this.mFile = new File(paramString1);
    this.mTempFile = new File(paramString2);
    if (this.mTempFile.exists()) {
      this.mPreviousFileSize = this.mTempFile.length();
    }
  }
  
  public FileRspHandler(String paramString1, String paramString2, long paramLong)
  {
    this.mFile = new File(paramString1);
    this.mTempFile = new File(paramString2);
    this.mTotalSize = paramLong;
    if (this.mTempFile.exists()) {
      this.mPreviousFileSize = this.mTempFile.length();
    }
  }
  
  public FileRspHandler(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.mFile = new File(paramString1);
    this.mTempFile = new File(paramString2);
    this.mTotalSize = paramLong;
    if (this.mTempFile.exists()) {
      this.mPreviousFileSize = this.mTempFile.length();
    }
    this.md5 = paramString3;
  }
  
  private boolean copyFile(File paramFile1, File paramFile2)
  {
    if ((paramFile1 != null) && (paramFile1.exists())) {
      paramFile1.delete();
    }
    boolean bool2 = paramFile2.renameTo(paramFile1);
    boolean bool1 = bool2;
    File localFile2;
    File localFile1;
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (!bool2)
    {
      localFile2 = null;
      localFile1 = null;
      localObject4 = null;
      localObject3 = null;
      localObject1 = localObject3;
      localObject2 = localObject4;
    }
    for (;;)
    {
      try
      {
        paramFile2 = new FileInputStream(paramFile2).getChannel();
        localObject1 = localObject3;
        localFile1 = paramFile2;
        localObject2 = localObject4;
        localFile2 = paramFile2;
        paramFile1 = new FileOutputStream(paramFile1).getChannel();
        localObject1 = paramFile1;
        localFile1 = paramFile2;
        localObject2 = paramFile1;
        localFile2 = paramFile2;
        paramFile1.transferFrom(paramFile2, 0L, paramFile2.size());
        bool2 = true;
      }
      catch (Exception paramFile1)
      {
        bool1 = false;
        if (localFile1 == null) {
          continue;
        }
        try
        {
          localFile1.close();
          if (localObject1 == null) {
            continue;
          }
          try
          {
            ((FileChannel)localObject1).close();
            return false;
          }
          catch (IOException paramFile1)
          {
            paramFile1.printStackTrace();
            return false;
          }
        }
        catch (IOException paramFile1)
        {
          paramFile1.printStackTrace();
          continue;
        }
      }
      finally
      {
        if (localFile2 == null) {
          break label205;
        }
      }
      try
      {
        paramFile2.close();
        bool1 = bool2;
        if (paramFile1 == null) {}
      }
      catch (IOException paramFile2)
      {
        try
        {
          paramFile1.close();
          bool1 = bool2;
          return bool1;
        }
        catch (IOException paramFile1)
        {
          paramFile1.printStackTrace();
          return true;
        }
        paramFile2 = paramFile2;
        paramFile2.printStackTrace();
      }
    }
    try
    {
      localFile2.close();
      label205:
      if (localObject2 == null) {}
    }
    catch (IOException paramFile2)
    {
      try
      {
        ((FileChannel)localObject2).close();
        throw paramFile1;
        paramFile2 = paramFile2;
        paramFile2.printStackTrace();
      }
      catch (IOException paramFile2)
      {
        for (;;)
        {
          paramFile2.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  private void copyStream(HttpEntity paramHttpEntity)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/baidu/navisdk/util/http/FileRspHandler:isStop	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokeinterface 131 1 0
    //   14: astore_1
    //   15: new 9	com/baidu/navisdk/util/http/FileRspHandler$ProgressReportingRandomAccessFile
    //   18: dup
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 49	com/baidu/navisdk/util/http/FileRspHandler:mTempFile	Ljava/io/File;
    //   24: ldc -123
    //   26: invokespecial 136	com/baidu/navisdk/util/http/FileRspHandler$ProgressReportingRandomAccessFile:<init>	(Lcom/baidu/navisdk/util/http/FileRspHandler;Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_3
    //   30: sipush 4096
    //   33: newarray <illegal type>
    //   35: astore 4
    //   37: aload_3
    //   38: aload_3
    //   39: invokevirtual 139	java/io/RandomAccessFile:length	()J
    //   42: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   45: aload_0
    //   46: invokestatic 148	java/lang/System:currentTimeMillis	()J
    //   49: putfield 75	com/baidu/navisdk/util/http/FileRspHandler:mPreviousTime	J
    //   52: aload_0
    //   53: getfield 40	com/baidu/navisdk/util/http/FileRspHandler:isStop	Z
    //   56: ifne +28 -> 84
    //   59: invokestatic 154	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   62: invokevirtual 157	java/lang/Thread:isInterrupted	()Z
    //   65: ifne +19 -> 84
    //   68: aload_1
    //   69: aload 4
    //   71: iconst_0
    //   72: aload 4
    //   74: arraylength
    //   75: invokevirtual 163	java/io/InputStream:read	([BII)I
    //   78: istore_2
    //   79: iload_2
    //   80: iconst_m1
    //   81: if_icmpne +61 -> 142
    //   84: aload_0
    //   85: getfield 40	com/baidu/navisdk/util/http/FileRspHandler:isStop	Z
    //   88: ifne +25 -> 113
    //   91: invokestatic 154	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   94: invokevirtual 157	java/lang/Thread:isInterrupted	()Z
    //   97: ifeq +16 -> 113
    //   100: aload_0
    //   101: new 165	java/lang/Throwable
    //   104: dup
    //   105: ldc -89
    //   107: invokespecial 168	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   110: invokevirtual 172	com/baidu/navisdk/util/http/FileRspHandler:handlePauseMessage	(Ljava/lang/Throwable;)V
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 173	java/io/RandomAccessFile:close	()V
    //   121: aload_1
    //   122: ifnull -115 -> 7
    //   125: new 6	com/baidu/navisdk/util/http/FileRspHandler$CloseTask
    //   128: dup
    //   129: aload_0
    //   130: aload_1
    //   131: invokespecial 176	com/baidu/navisdk/util/http/FileRspHandler$CloseTask:<init>	(Lcom/baidu/navisdk/util/http/FileRspHandler;Ljava/io/InputStream;)V
    //   134: invokevirtual 179	com/baidu/navisdk/util/http/FileRspHandler$CloseTask:start	()V
    //   137: aload_1
    //   138: invokevirtual 180	java/io/InputStream:close	()V
    //   141: return
    //   142: aload_3
    //   143: aload 4
    //   145: iconst_0
    //   146: iload_2
    //   147: invokevirtual 184	java/io/RandomAccessFile:write	([BII)V
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 63	com/baidu/navisdk/util/http/FileRspHandler:mTotalSize	J
    //   155: aload_0
    //   156: getfield 78	com/baidu/navisdk/util/http/FileRspHandler:mDownloadSize	J
    //   159: aload_0
    //   160: getfield 82	com/baidu/navisdk/util/http/FileRspHandler:mNetworkSpeed	J
    //   163: invokevirtual 188	com/baidu/navisdk/util/http/FileRspHandler:handleProgressMessage	(JJJ)V
    //   166: goto -114 -> 52
    //   169: astore 4
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 173	java/io/RandomAccessFile:close	()V
    //   179: aload_1
    //   180: ifnull +19 -> 199
    //   183: new 6	com/baidu/navisdk/util/http/FileRspHandler$CloseTask
    //   186: dup
    //   187: aload_0
    //   188: aload_1
    //   189: invokespecial 176	com/baidu/navisdk/util/http/FileRspHandler$CloseTask:<init>	(Lcom/baidu/navisdk/util/http/FileRspHandler;Ljava/io/InputStream;)V
    //   192: invokevirtual 179	com/baidu/navisdk/util/http/FileRspHandler$CloseTask:start	()V
    //   195: aload_1
    //   196: invokevirtual 180	java/io/InputStream:close	()V
    //   199: aload 4
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	FileRspHandler
    //   0	202	1	paramHttpEntity	HttpEntity
    //   78	69	2	i	int
    //   29	147	3	localProgressReportingRandomAccessFile	ProgressReportingRandomAccessFile
    //   35	109	4	arrayOfByte	byte[]
    //   169	31	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	79	169	finally
    //   84	113	169	finally
    //   142	166	169	finally
  }
  
  private void ensureFinishDownload()
  {
    if ((this.isStop) && (this.mTotalSize != this.mDownloadSize)) {}
    String str;
    do
    {
      return;
      if (this.mTotalSize != this.mDownloadSize)
      {
        handleFailureMessage(new Throwable("the download size not equal the given total size"));
        return;
      }
      if (!copyFile(this.mFile, this.mTempFile))
      {
        handleFailureMessage(new Throwable("can not copy the temp file to dst file"));
        return;
      }
      if (this.mTempFile.exists()) {
        this.mTempFile.delete();
      }
      if (TextUtils.isEmpty(this.md5)) {
        break;
      }
      str = FileUtils.getMd5ByFile(this.mFile.getAbsolutePath());
      if ((str == null) || (TextUtils.isEmpty(str)))
      {
        handleFailureMessage(new Throwable("can not calc the download file md5"));
        return;
      }
      if (str.equals(this.md5))
      {
        handleSuccessMessage(this.mFile.getAbsolutePath());
        LogUtil.e("FileRspHandler", "success");
        return;
      }
    } while (str.equals(this.md5));
    handleFailureMessage(new Throwable("the download file md5 is not equal the given md5 value"));
    return;
    handleSuccessMessage(this.mFile.getAbsolutePath());
  }
  
  private void getFileSize(HttpEntity paramHttpEntity)
    throws Exception
  {
    if (this.isStop) {
      return;
    }
    long l = paramHttpEntity.getContentLength();
    if (l <= 0L) {
      throw new IOException("can not get the file size!");
    }
    this.mTotalSize = (this.mPreviousFileSize + l);
  }
  
  public long getDownloadSize()
  {
    return this.mDownloadSize;
  }
  
  public double getDownloadSpeed()
  {
    return this.mNetworkSpeed;
  }
  
  public long getPreviousFileSize()
  {
    return this.mPreviousFileSize;
  }
  
  public File getTempFile()
  {
    return this.mTempFile;
  }
  
  public long getTotalSize()
  {
    return this.mTotalSize;
  }
  
  public long getTotalTime()
  {
    return this.mTotalTime;
  }
  
  public void handlePauseMessage(Throwable paramThrowable)
  {
    LogUtil.e("FileRspHandler", getClass().getName() + ":onPause");
    onPause(paramThrowable);
  }
  
  protected void handleResponse(HttpResponse paramHttpResponse)
  {
    if (this.isStop) {
      return;
    }
    Object localObject = paramHttpResponse.getStatusLine();
    int i = ((StatusLine)localObject).getStatusCode();
    if ((i != 200) && (i != 206))
    {
      handlePauseMessage(new HttpResponseException(((StatusLine)localObject).getStatusCode(), ((StatusLine)localObject).getReasonPhrase()));
      return;
    }
    localObject = paramHttpResponse.getEntity();
    paramHttpResponse = null;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        getFileSize((HttpEntity)localObject);
        LogUtil.e("FileRspHandler", "get file size end");
        copyStream((HttpEntity)localObject);
        LogUtil.e("FileRspHandler", "copy stream end");
        ensureFinishDownload();
        LogUtil.e("FileRspHandler", "ensureFinishDownload end");
        if (paramHttpResponse == null) {
          break;
        }
        handlePauseMessage(paramHttpResponse);
        return;
      }
      catch (Exception localException)
      {
        if (localException != null)
        {
          paramHttpResponse = localException;
          if (localException.getMessage() != null) {}
        }
        else
        {
          paramHttpResponse = new Exception("unknow error when handle get fiel");
        }
        continue;
      }
      paramHttpResponse = new NullPointerException("the http entity is null!");
    }
  }
  
  public void onPause(Throwable paramThrowable) {}
  
  public void stop()
  {
    handlePauseMessage(new Throwable("stop by call the stop method"));
    this.isStop = true;
  }
  
  class CloseTask
    extends Thread
  {
    InputStream inputStream = null;
    
    public CloseTask(InputStream paramInputStream)
    {
      this.inputStream = paramInputStream;
    }
    
    public void run()
    {
      if (this.inputStream != null) {}
      try
      {
        this.inputStream.close();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private class ProgressReportingRandomAccessFile
    extends RandomAccessFile
  {
    private int progress = 0;
    
    public ProgressReportingRandomAccessFile(File paramFile, String paramString)
      throws FileNotFoundException
    {
      super(paramString);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      this.progress += paramInt2;
      FileRspHandler.access$002(FileRspHandler.this, System.currentTimeMillis() - FileRspHandler.this.mPreviousTime);
      FileRspHandler.access$202(FileRspHandler.this, this.progress + FileRspHandler.this.mPreviousFileSize);
      if (FileRspHandler.this.mTotalTime > 0L) {
        FileRspHandler.access$402(FileRspHandler.this, (this.progress / FileRspHandler.this.mTotalTime / 1.024D));
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/FileRspHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */