package com.baidu.che.codriver.vr.record;

import android.content.Context;
import android.media.AudioTrack;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b
{
  private static final int a = 65536;
  private DataOutputStream b;
  private AudioTrack c = null;
  private Context d;
  
  public b(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public void a()
  {
    this.c = new AudioTrack(3, 16000, 4, 2, 327680, 1);
  }
  
  public void a(String paramString)
  {
    Object localObject = this.d.getExternalFilesDir("RecordData").getPath();
    d();
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
      paramString = new File((String)localObject + "/" + localSimpleDateFormat.format(new Date()) + paramString + ".pcm");
      localObject = paramString.getParentFile();
      if ((localObject != null) && (!((File)localObject).exists())) {
        ((File)localObject).mkdirs();
      }
      if (!paramString.exists()) {
        paramString.createNewFile();
      }
      paramString.setWritable(true);
      this.b = new DataOutputStream(new FileOutputStream(paramString, true));
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(short[] paramArrayOfShort)
  {
    this.c.write(paramArrayOfShort, 0, paramArrayOfShort.length);
  }
  
  public void b()
  {
    if (this.c.getPlayState() != 3) {
      this.c.play();
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.b != null)
        {
          this.b.write(paramArrayOfByte, 0, paramArrayOfByte.length);
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void b(short[] paramArrayOfShort)
  {
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length <= 0)) {
      return;
    }
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfShort[i];
      if (this.b != null) {}
      try
      {
        this.b.writeShort(k);
        i += 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void c()
  {
    this.c.pause();
  }
  
  public void d()
  {
    if (this.b != null) {}
    try
    {
      this.b.close();
      this.b = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/record/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */