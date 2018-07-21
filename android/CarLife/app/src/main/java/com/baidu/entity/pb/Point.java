package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Point
  extends MessageMicro
{
  public static final int X_FIELD_NUMBER = 1;
  public static final int Y_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private int d = 0;
  private int e = -1;
  
  public static Point parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Point().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Point parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Point)new Point().mergeFrom(paramArrayOfByte);
  }
  
  public final Point clear()
  {
    clearX();
    clearY();
    this.e = -1;
    return this;
  }
  
  public Point clearX()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public Point clearY()
  {
    this.c = false;
    this.d = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasX()) {
      i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getX());
    }
    int j = i;
    if (hasY()) {
      j = i + CodedOutputStreamMicro.computeInt32Size(2, getY());
    }
    this.e = j;
    return j;
  }
  
  public int getX()
  {
    return this.b;
  }
  
  public int getY()
  {
    return this.d;
  }
  
  public boolean hasX()
  {
    return this.a;
  }
  
  public boolean hasY()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Point mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 8: 
        setX(paramCodedInputStreamMicro.readInt32());
        break;
      case 16: 
        setY(paramCodedInputStreamMicro.readInt32());
      }
    }
  }
  
  public Point setX(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public Point setY(int paramInt)
  {
    this.c = true;
    this.d = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasX()) {
      paramCodedOutputStreamMicro.writeInt32(1, getX());
    }
    if (hasY()) {
      paramCodedOutputStreamMicro.writeInt32(2, getY());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */