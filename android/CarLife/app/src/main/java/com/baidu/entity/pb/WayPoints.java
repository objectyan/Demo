package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class WayPoints
  extends MessageMicro
{
  public static final int ADDR_FIELD_NUMBER = 5;
  public static final int CODE_FIELD_NUMBER = 1;
  public static final int DESCRIBE_FIELD_NUMBER = 11;
  public static final int DIRECTION_FIELD_NUMBER = 10;
  public static final int DIST_FIELD_NUMBER = 9;
  public static final int GEO_FIELD_NUMBER = 6;
  public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
  public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int NUM_FIELD_NUMBER = 3;
  public static final int UID_FIELD_NUMBER = 4;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private boolean e;
  private int f = 0;
  private boolean g;
  private String h = "";
  private boolean i;
  private String j = "";
  private boolean k;
  private String l = "";
  private boolean m;
  private String n = "";
  private boolean o;
  private String p = "";
  private boolean q;
  private int r = 0;
  private boolean s;
  private int t = 0;
  private boolean u;
  private String v = "";
  private int w = -1;
  
  public static WayPoints parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new WayPoints().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static WayPoints parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (WayPoints)new WayPoints().mergeFrom(paramArrayOfByte);
  }
  
  public final WayPoints clear()
  {
    clearCode();
    clearName();
    clearNum();
    clearUid();
    clearAddr();
    clearGeo();
    clearIndoorFloor();
    clearIndoorParentUid();
    clearDist();
    clearDirection();
    clearDescribe();
    this.w = -1;
    return this;
  }
  
  public WayPoints clearAddr()
  {
    this.i = false;
    this.j = "";
    return this;
  }
  
  public WayPoints clearCode()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public WayPoints clearDescribe()
  {
    this.u = false;
    this.v = "";
    return this;
  }
  
  public WayPoints clearDirection()
  {
    this.s = false;
    this.t = 0;
    return this;
  }
  
  public WayPoints clearDist()
  {
    this.q = false;
    this.r = 0;
    return this;
  }
  
  public WayPoints clearGeo()
  {
    this.k = false;
    this.l = "";
    return this;
  }
  
  public WayPoints clearIndoorFloor()
  {
    this.m = false;
    this.n = "";
    return this;
  }
  
  public WayPoints clearIndoorParentUid()
  {
    this.o = false;
    this.p = "";
    return this;
  }
  
  public WayPoints clearName()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public WayPoints clearNum()
  {
    this.e = false;
    this.f = 0;
    return this;
  }
  
  public WayPoints clearUid()
  {
    this.g = false;
    this.h = "";
    return this;
  }
  
  public String getAddr()
  {
    return this.j;
  }
  
  public int getCachedSize()
  {
    if (this.w < 0) {
      getSerializedSize();
    }
    return this.w;
  }
  
  public int getCode()
  {
    return this.b;
  }
  
  public String getDescribe()
  {
    return this.v;
  }
  
  public int getDirection()
  {
    return this.t;
  }
  
  public int getDist()
  {
    return this.r;
  }
  
  public String getGeo()
  {
    return this.l;
  }
  
  public String getIndoorFloor()
  {
    return this.n;
  }
  
  public String getIndoorParentUid()
  {
    return this.p;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public int getNum()
  {
    return this.f;
  }
  
  public int getSerializedSize()
  {
    int i2 = 0;
    if (hasCode()) {
      i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
    }
    int i1 = i2;
    if (hasName()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
    }
    i2 = i1;
    if (hasNum()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getNum());
    }
    i1 = i2;
    if (hasUid()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getUid());
    }
    i2 = i1;
    if (hasAddr()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getAddr());
    }
    i1 = i2;
    if (hasGeo()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getGeo());
    }
    i2 = i1;
    if (hasIndoorFloor()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getIndoorFloor());
    }
    i1 = i2;
    if (hasIndoorParentUid()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getIndoorParentUid());
    }
    i2 = i1;
    if (hasDist()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getDist());
    }
    i1 = i2;
    if (hasDirection()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getDirection());
    }
    i2 = i1;
    if (hasDescribe()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getDescribe());
    }
    this.w = i2;
    return i2;
  }
  
  public String getUid()
  {
    return this.h;
  }
  
  public boolean hasAddr()
  {
    return this.i;
  }
  
  public boolean hasCode()
  {
    return this.a;
  }
  
  public boolean hasDescribe()
  {
    return this.u;
  }
  
  public boolean hasDirection()
  {
    return this.s;
  }
  
  public boolean hasDist()
  {
    return this.q;
  }
  
  public boolean hasGeo()
  {
    return this.k;
  }
  
  public boolean hasIndoorFloor()
  {
    return this.m;
  }
  
  public boolean hasIndoorParentUid()
  {
    return this.o;
  }
  
  public boolean hasName()
  {
    return this.c;
  }
  
  public boolean hasNum()
  {
    return this.e;
  }
  
  public boolean hasUid()
  {
    return this.g;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public WayPoints mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 8: 
        setCode(paramCodedInputStreamMicro.readInt32());
        break;
      case 18: 
        setName(paramCodedInputStreamMicro.readString());
        break;
      case 24: 
        setNum(paramCodedInputStreamMicro.readInt32());
        break;
      case 34: 
        setUid(paramCodedInputStreamMicro.readString());
        break;
      case 42: 
        setAddr(paramCodedInputStreamMicro.readString());
        break;
      case 50: 
        setGeo(paramCodedInputStreamMicro.readString());
        break;
      case 58: 
        setIndoorFloor(paramCodedInputStreamMicro.readString());
        break;
      case 66: 
        setIndoorParentUid(paramCodedInputStreamMicro.readString());
        break;
      case 72: 
        setDist(paramCodedInputStreamMicro.readInt32());
        break;
      case 80: 
        setDirection(paramCodedInputStreamMicro.readInt32());
        break;
      case 90: 
        setDescribe(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public WayPoints setAddr(String paramString)
  {
    this.i = true;
    this.j = paramString;
    return this;
  }
  
  public WayPoints setCode(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public WayPoints setDescribe(String paramString)
  {
    this.u = true;
    this.v = paramString;
    return this;
  }
  
  public WayPoints setDirection(int paramInt)
  {
    this.s = true;
    this.t = paramInt;
    return this;
  }
  
  public WayPoints setDist(int paramInt)
  {
    this.q = true;
    this.r = paramInt;
    return this;
  }
  
  public WayPoints setGeo(String paramString)
  {
    this.k = true;
    this.l = paramString;
    return this;
  }
  
  public WayPoints setIndoorFloor(String paramString)
  {
    this.m = true;
    this.n = paramString;
    return this;
  }
  
  public WayPoints setIndoorParentUid(String paramString)
  {
    this.o = true;
    this.p = paramString;
    return this;
  }
  
  public WayPoints setName(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public WayPoints setNum(int paramInt)
  {
    this.e = true;
    this.f = paramInt;
    return this;
  }
  
  public WayPoints setUid(String paramString)
  {
    this.g = true;
    this.h = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasCode()) {
      paramCodedOutputStreamMicro.writeInt32(1, getCode());
    }
    if (hasName()) {
      paramCodedOutputStreamMicro.writeString(2, getName());
    }
    if (hasNum()) {
      paramCodedOutputStreamMicro.writeInt32(3, getNum());
    }
    if (hasUid()) {
      paramCodedOutputStreamMicro.writeString(4, getUid());
    }
    if (hasAddr()) {
      paramCodedOutputStreamMicro.writeString(5, getAddr());
    }
    if (hasGeo()) {
      paramCodedOutputStreamMicro.writeString(6, getGeo());
    }
    if (hasIndoorFloor()) {
      paramCodedOutputStreamMicro.writeString(7, getIndoorFloor());
    }
    if (hasIndoorParentUid()) {
      paramCodedOutputStreamMicro.writeString(8, getIndoorParentUid());
    }
    if (hasDist()) {
      paramCodedOutputStreamMicro.writeInt32(9, getDist());
    }
    if (hasDirection()) {
      paramCodedOutputStreamMicro.writeInt32(10, getDirection());
    }
    if (hasDescribe()) {
      paramCodedOutputStreamMicro.writeString(11, getDescribe());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/WayPoints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */