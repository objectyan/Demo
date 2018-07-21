package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class BzInfo
  extends MessageMicro
{
  public static final int CIRCLE_FIELD_NUMBER = 2;
  public static final int ERRNO_FIELD_NUMBER = 1;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private int e = -1;
  
  public static BzInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new BzInfo().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static BzInfo parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (BzInfo)new BzInfo().mergeFrom(paramArrayOfByte);
  }
  
  public final BzInfo clear()
  {
    clearErrno();
    clearCircle();
    this.e = -1;
    return this;
  }
  
  public BzInfo clearCircle()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public BzInfo clearErrno()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public String getCircle()
  {
    return this.d;
  }
  
  public String getErrno()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasErrno()) {
      i = 0 + CodedOutputStreamMicro.computeStringSize(1, getErrno());
    }
    int j = i;
    if (hasCircle()) {
      j = i + CodedOutputStreamMicro.computeStringSize(2, getCircle());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasCircle()
  {
    return this.c;
  }
  
  public boolean hasErrno()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public BzInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i = paramCodedInputStreamMicro.readTag();
      switch (i)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        setErrno(paramCodedInputStreamMicro.readString());
        break;
      case 18: 
        setCircle(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public BzInfo setCircle(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public BzInfo setErrno(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasErrno()) {
      paramCodedOutputStreamMicro.writeString(1, getErrno());
    }
    if (hasCircle()) {
      paramCodedOutputStreamMicro.writeString(2, getCircle());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/BzInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */