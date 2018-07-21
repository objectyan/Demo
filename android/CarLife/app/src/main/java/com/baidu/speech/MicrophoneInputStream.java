package com.baidu.speech;

import android.media.AudioRecord;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import com.baidu.speech.audio.MicrophoneServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class MicrophoneInputStream
  extends InputStream
{
  private static final String TAG = "MicrophoneInputStream";
  private final LocalSocket socket;
  private final InputStream source;
  
  public MicrophoneInputStream()
    throws IOException
  {
    this(1, 16000);
  }
  
  public MicrophoneInputStream(int paramInt)
    throws IOException
  {
    this(1, paramInt);
  }
  
  public MicrophoneInputStream(int paramInt1, int paramInt2)
    throws IOException
  {
    this(paramInt1, paramInt2, null);
  }
  
  public MicrophoneInputStream(int paramInt1, int paramInt2, InputStream paramInputStream)
    throws IOException
  {
    this(paramInt1, paramInt2, paramInputStream, null);
  }
  
  public MicrophoneInputStream(int paramInt1, int paramInt2, InputStream paramInputStream, AudioRecord paramAudioRecord)
    throws IOException
  {
    MicrophoneServer.create("", paramInt1);
    paramInputStream = Executors.newSingleThreadExecutor().submit(new Callable()
    {
      public LocalSocket call()
        throws Exception
      {
        LocalSocket localLocalSocket = new LocalSocket();
        localLocalSocket.connect(new LocalSocketAddress(MicrophoneServer.SOCKET_ADDRESS));
        return localLocalSocket;
      }
    });
    try
    {
      this.socket = ((LocalSocket)paramInputStream.get());
      this.source = this.socket.getInputStream();
      new Thread()
      {
        public void run()
        {
          byte[] arrayOfByte = new byte['ʀ'];
          try
          {
            MicrophoneInputStream.this.socket.getOutputStream().write(0);
            for (;;)
            {
              MicrophoneInputStream.this.socket.getInputStream().read(arrayOfByte);
            }
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }.start();
      return;
    }
    catch (Exception paramInputStream)
    {
      throw new IOException(paramInputStream);
    }
  }
  
  public MicrophoneInputStream(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    this(1, paramInt, paramInputStream);
  }
  
  public MicrophoneInputStream(AudioRecord paramAudioRecord)
    throws IOException
  {
    this(1, 16000, null, paramAudioRecord);
  }
  
  public void close()
    throws IOException
  {
    super.close();
    this.source.close();
    this.socket.close();
  }
  
  public long mills()
  {
    return 0L;
  }
  
  public void mills(long paramLong) {}
  
  public int read()
    throws IOException
  {
    return 0;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.source.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/MicrophoneInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */