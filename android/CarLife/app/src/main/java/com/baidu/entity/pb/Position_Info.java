package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Position_Info
  extends MessageMicro
{
  public static final int CITYID_FIELD_NUMBER = 4;
  public static final int CNAME_FIELD_NUMBER = 5;
  public static final int EXT_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 7;
  public static final int SHOWYX_FIELD_NUMBER = 6;
  public static final int UID_FIELD_NUMBER = 2;
  public static final int YX_FIELD_NUMBER = 1;
  private boolean a;
  private ByteStringMicro b = ByteStringMicro.EMPTY;
  private boolean c;
  private ByteStringMicro d = ByteStringMicro.EMPTY;
  private boolean e;
  private String f = "";
  private boolean g;
  private int h = 0;
  private boolean i;
  private String j = "";
  private boolean k;
  private ByteStringMicro l = ByteStringMicro.EMPTY;
  private boolean m;
  private ByteStringMicro n = ByteStringMicro.EMPTY;
  private int o = -1;
  
  public static Position_Info parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Position_Info().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Position_Info parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Position_Info)new Position_Info().mergeFrom(paramArrayOfByte);
  }
  
  public final Position_Info clear()
  {
    clearYx();
    clearUid();
    clearExt();
    clearCityid();
    clearCname();
    clearShowyx();
    clearName();
    this.o = -1;
    return this;
  }
  
  public Position_Info clearCityid()
  {
    this.g = false;
    this.h = 0;
    return this;
  }
  
  public Position_Info clearCname()
  {
    this.i = false;
    this.j = "";
    return this;
  }
  
  public Position_Info clearExt()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public Position_Info clearName()
  {
    this.m = false;
    this.n = ByteStringMicro.EMPTY;
    return this;
  }
  
  public Position_Info clearShowyx()
  {
    this.k = false;
    this.l = ByteStringMicro.EMPTY;
    return this;
  }
  
  public Position_Info clearUid()
  {
    this.c = false;
    this.d = ByteStringMicro.EMPTY;
    return this;
  }
  
  public Position_Info clearYx()
  {
    this.a = false;
    this.b = ByteStringMicro.EMPTY;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.o < 0) {
      getSerializedSize();
    }
    return this.o;
  }
  
  public int getCityid()
  {
    return this.h;
  }
  
  public String getCname()
  {
    return this.j;
  }
  
  public String getExt()
  {
    return this.f;
  }
  
  public ByteStringMicro getName()
  {
    return this.n;
  }
  
  public int getSerializedSize()
  {
    int i2 = 0;
    if (hasYx()) {
      i2 = 0 + CodedOutputStreamMicro.computeBytesSize(1, getYx());
    }
    int i1 = i2;
    if (hasUid()) {
      i1 = i2 + CodedOutputStreamMicro.computeBytesSize(2, getUid());
    }
    i2 = i1;
    if (hasExt()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getExt());
    }
    i1 = i2;
    if (hasCityid()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getCityid());
    }
    i2 = i1;
    if (hasCname()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getCname());
    }
    i1 = i2;
    if (hasShowyx()) {
      i1 = i2 + CodedOutputStreamMicro.computeBytesSize(6, getShowyx());
    }
    i2 = i1;
    if (hasName()) {
      i2 = i1 + CodedOutputStreamMicro.computeBytesSize(7, getName());
    }
    this.o = i2;
    return i2;
  }
  
  public ByteStringMicro getShowyx()
  {
    return this.l;
  }
  
  public ByteStringMicro getUid()
  {
    return this.d;
  }
  
  public ByteStringMicro getYx()
  {
    return this.b;
  }
  
  public boolean hasCityid()
  {
    return this.g;
  }
  
  public boolean hasCname()
  {
    return this.i;
  }
  
  public boolean hasExt()
  {
    return this.e;
  }
  
  public boolean hasName()
  {
    return this.m;
  }
  
  public boolean hasShowyx()
  {
    return this.k;
  }
  
  public boolean hasUid()
  {
    return this.c;
  }
  
  public boolean hasYx()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Position_Info mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i1 = paramCodedInputStreamMicro.readTag();
      switch (i1)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
        break;
      case 0: 
        return this;
      case 10: 
        setYx(paramCodedInputStreamMicro.readBytes());
        break;
      case 18: 
        setUid(paramCodedInputStreamMicro.readBytes());
        break;
      case 26: 
        setExt(paramCodedInputStreamMicro.readString());
        break;
      case 32: 
        setCityid(paramCodedInputStreamMicro.readInt32());
        break;
      case 42: 
        setCname(paramCodedInputStreamMicro.readString());
        break;
      case 50: 
        setShowyx(paramCodedInputStreamMicro.readBytes());
        break;
      case 58: 
        setName(paramCodedInputStreamMicro.readBytes());
      }
    }
  }
  
  public Position_Info setCityid(int paramInt)
  {
    this.g = true;
    this.h = paramInt;
    return this;
  }
  
  public Position_Info setCname(String paramString)
  {
    this.i = true;
    this.j = paramString;
    return this;
  }
  
  public Position_Info setExt(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public Position_Info setName(ByteStringMicro paramByteStringMicro)
  {
    this.m = true;
    this.n = paramByteStringMicro;
    return this;
  }
  
  public Position_Info setShowyx(ByteStringMicro paramByteStringMicro)
  {
    this.k = true;
    this.l = paramByteStringMicro;
    return this;
  }
  
  public Position_Info setUid(ByteStringMicro paramByteStringMicro)
  {
    this.c = true;
    this.d = paramByteStringMicro;
    return this;
  }
  
  public Position_Info setYx(ByteStringMicro paramByteStringMicro)
  {
    this.a = true;
    this.b = paramByteStringMicro;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasYx()) {
      paramCodedOutputStreamMicro.writeBytes(1, getYx());
    }
    if (hasUid()) {
      paramCodedOutputStreamMicro.writeBytes(2, getUid());
    }
    if (hasExt()) {
      paramCodedOutputStreamMicro.writeString(3, getExt());
    }
    if (hasCityid()) {
      paramCodedOutputStreamMicro.writeInt32(4, getCityid());
    }
    if (hasCname()) {
      paramCodedOutputStreamMicro.writeString(5, getCname());
    }
    if (hasShowyx()) {
      paramCodedOutputStreamMicro.writeBytes(6, getShowyx());
    }
    if (hasName()) {
      paramCodedOutputStreamMicro.writeBytes(7, getName());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Position_Info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */