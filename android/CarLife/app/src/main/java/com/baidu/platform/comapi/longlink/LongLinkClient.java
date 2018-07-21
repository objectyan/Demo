package com.baidu.platform.comapi.longlink;

import com.baidu.platform.comapi.a.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comjni.base.longlink.NALongLink;
import java.util.ArrayList;

public class LongLinkClient
{
  private int a;
  private int b;
  private int c;
  
  private LongLinkClient(int paramInt)
  {
    this.b = paramInt;
  }
  
  private LongLinkClient(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  public static LongLinkClient create()
    throws a
  {
    int i = NALongLink.create();
    if (i != 0) {
      return new LongLinkClient(i);
    }
    throw new a("LongLink Component created failed!");
  }
  
  public static LongLinkClient create(int paramInt)
    throws a
  {
    int i = NALongLink.create();
    if (i != 0) {
      return new LongLinkClient(i, paramInt);
    }
    throw new a("LongLink Component created failed!");
  }
  
  public int getRequestId()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean init(String paramString1, String paramString2)
    throws b
  {
    if (isValid()) {
      return NALongLink.init(this.b, paramString1, paramString2);
    }
    throw new b();
  }
  
  public boolean isValid()
  {
    return this.b != 0;
  }
  
  public boolean register(LongLinkDataCallback paramLongLinkDataCallback)
    throws b
  {
    try
    {
      if (isValid())
      {
        boolean bool = NALongLink.register(this.b, this.a, paramLongLinkDataCallback);
        return bool;
      }
      throw new b();
    }
    finally {}
  }
  
  public int release()
  {
    if ((isValid()) && (NALongLink.release(this.b) <= 0)) {
      this.b = 0;
    }
    return -1;
  }
  
  public ELongLinkStatus sendData(byte[] paramArrayOfByte)
    throws b
  {
    try
    {
      if (isValid())
      {
        this.c += 1;
        paramArrayOfByte = ELongLinkStatus.values()[NALongLink.sendData(this.b, this.a, this.c, paramArrayOfByte)];
        paramArrayOfByte.setRequestId(this.c);
        return paramArrayOfByte;
      }
      throw new b();
    }
    finally {}
  }
  
  public ELongLinkStatus sendFileData(String paramString, ArrayList<LongLinkFileData> paramArrayList)
    throws b
  {
    try
    {
      if (isValid())
      {
        this.c += 1;
        paramString = ELongLinkStatus.values()[NALongLink.sendFileData(this.b, this.a, this.c, paramString, paramArrayList)];
        paramString.setRequestId(this.c);
        return paramString;
      }
      throw new b();
    }
    finally {}
  }
  
  public void setModuleId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public boolean start()
    throws b
  {
    if (isValid()) {
      return NALongLink.start(this.b);
    }
    throw new b();
  }
  
  public void stop()
    throws b
  {
    if (isValid())
    {
      NALongLink.stop(this.b);
      return;
    }
    throw new b();
  }
  
  public boolean unRegister(LongLinkDataCallback paramLongLinkDataCallback)
    throws b
  {
    try
    {
      if (isValid())
      {
        boolean bool = NALongLink.unRegister(this.b, this.a, paramLongLinkDataCallback);
        return bool;
      }
      throw new b();
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/longlink/LongLinkClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */