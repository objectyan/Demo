package com.baidu.carlife.core.audio;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class j
  extends l
{
  private static final String a = "audioM3U8decoder";
  private static final int e = 7;
  private byte[] b = new byte[' '];
  private FileInputStream c = null;
  private List<String> d = new ArrayList();
  
  private int a(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      j = i;
      if (i >= paramInt) {
        break label45;
      }
      j = this.c.read(paramArrayOfByte, 0, paramInt);
      if (j <= 0) {
        break;
      }
      i += j;
    }
    i.e("audioM3U8decoder", "read data from aac stream fail");
    int j = -1;
    label45:
    return j;
  }
  
  private boolean d(int paramInt)
  {
    return (paramInt <= 0) && (this.d.size() > 0);
  }
  
  private void n()
  {
    if (this.c != null) {}
    try
    {
      this.c.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.c = null;
    }
  }
  
  private int o()
  {
    try
    {
      int i = p();
      return i;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      i.e("audioM3U8decoder", "read pcm io exception");
    }
    return -1;
  }
  
  private int p()
    throws IOException
  {
    int i = 0;
    while (d(i)) {
      if (t()) {
        i = q();
      }
    }
    if (i < 0) {
      i.e("audioM3U8decoder", "parse until pcm frame read fail");
    }
    return i;
  }
  
  private int q()
    throws IOException
  {
    int i = a(this.b, 7);
    if (i < 0)
    {
      i.b("audioM3U8decoder", "read header fail");
      s();
      return i;
    }
    if (r() < 7)
    {
      i.e("audioM3U8decoder", "frame is too short");
      s();
      return -1;
    }
    i = a(this.b, r() - 7);
    if (i < 0)
    {
      i.e("audioM3U8decoder", "read frame data fail");
      s();
    }
    return i;
  }
  
  private int r()
  {
    return ((this.b[3] & 0x3) << 11) + ((this.b[4] & 0xFF) << 3) + ((this.b[5] & 0xE0) >> 5);
  }
  
  private void s()
    throws IOException
  {
    this.c.close();
    this.c = null;
    File localFile = new File((String)this.d.get(0));
    this.d.remove(0);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  private boolean t()
  {
    if (this.c == null) {}
    try
    {
      File localFile = new File((String)this.d.get(0));
      if (!localFile.exists())
      {
        i.e("audioM3U8decoder", "aac file not exist");
        this.d.remove(0);
        return false;
      }
      this.c = new FileInputStream(localFile);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      i.e("audioM3U8decoder", "aac file not found");
      this.c = null;
      this.d.remove(0);
    }
    return false;
  }
  
  private boolean u()
  {
    return this.d.size() < 2;
  }
  
  public int a(p paramp, int paramInt)
  {
    try
    {
      paramInt = b(paramp, paramInt);
      return paramInt;
    }
    finally
    {
      paramp = finally;
      throw paramp;
    }
  }
  
  public int a(String paramString, ArrayList paramArrayList)
  {
    this.d = paramArrayList;
    n();
    return super.a(paramString);
  }
  
  public int b(p paramp, int paramInt)
  {
    label552:
    for (;;)
    {
      try
      {
        if (e() == null)
        {
          i.e("audioM3U8decoder", "codec is null");
          paramInt = -1;
          return paramInt;
        }
        if (u())
        {
          i.e("audioM3U8decoder", "aac file not enough");
          paramInt = -1;
        }
        else
        {
          int m = o();
          if (m < 0)
          {
            i.e("audioM3U8decoder", "pcm frame parse fail");
            paramInt = -1;
          }
          else
          {
            int k = 0;
            int j = 0;
            paramp.a(m());
            paramp.a(0);
            int i;
            try
            {
              n = e().dequeueInputBuffer(d());
              if ((n >= 0) && (!i()))
              {
                if (Build.VERSION.SDK_INT >= 21)
                {
                  localByteBuffer = e().getInputBuffer(n);
                  localByteBuffer.put(this.b, 0, m);
                  MediaCodec localMediaCodec = e();
                  if (!i()) {
                    break label552;
                  }
                  i = 4;
                  localMediaCodec.queueInputBuffer(n, 0, m, 0L, i);
                  localByteBuffer.clear();
                }
              }
              else
              {
                m = e().dequeueOutputBuffer(g(), d());
                if (m < 0) {
                  continue;
                }
                if (Build.VERSION.SDK_INT < 21) {
                  continue;
                }
                localByteBuffer = e().getOutputBuffer(m);
                i = g().size;
                if (m().length < i + paramInt)
                {
                  a(new byte[i + paramInt]);
                  paramp.a(m());
                }
                localByteBuffer.get(m(), paramInt, i);
                localByteBuffer.clear();
                paramInt = k;
                if (i > 0)
                {
                  paramp.a(i);
                  paramInt = i;
                }
                e().releaseOutputBuffer(m, false);
                if ((g().flags & 0x4) == 0) {
                  continue;
                }
                a(true);
              }
            }
            catch (IllegalStateException paramp)
            {
              int n;
              paramp.printStackTrace();
              i.e("audioM3U8decoder", "IllegalStateException");
              a(404);
              paramInt = -1;
              continue;
              ByteBuffer localByteBuffer = j()[n];
              continue;
              localByteBuffer = k()[m];
              continue;
              a(false);
            }
            catch (IllegalArgumentException paramp)
            {
              i.e("audioM3U8decoder", "IllegalArgumentException");
              paramp.printStackTrace();
              a(404);
              paramInt = -1;
              continue;
              if (Build.VERSION.SDK_INT >= 21) {
                continue;
              }
              paramInt = j;
              if (m != -3) {
                continue;
              }
              b(e().getOutputBuffers());
              paramInt = j;
            }
            catch (MediaCodec.CryptoException paramp)
            {
              i.e("audioM3U8decoder", "MediaCodec.CryptoException");
              paramp.printStackTrace();
              a(404);
              paramInt = -1;
            }
            continue;
            paramInt = j;
            if (m == -2)
            {
              paramp = e().getOutputFormat();
              b(paramp.getInteger("sample-rate"));
              c(paramp.getInteger("channel-count"));
              i.e("audioM3U8decoder", "output format changed new sample rate is " + a() + " and new new channel count is " + b());
              k.b(425);
              paramInt = j;
              continue;
              i = 0;
            }
          }
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */