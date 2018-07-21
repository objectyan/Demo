package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class End
  extends MessageMicro
{
  public static final int ADDR_FIELD_NUMBER = 5;
  public static final int CODE_FIELD_NUMBER = 1;
  public static final int DESCRIBE_FIELD_NUMBER = 13;
  public static final int DIRECTION_FIELD_NUMBER = 12;
  public static final int DIST_FIELD_NUMBER = 11;
  public static final int EXT_FIELD_NUMBER = 7;
  public static final int GEO_FIELD_NUMBER = 6;
  public static final int INDOOR_FLOOR_FIELD_NUMBER = 9;
  public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 10;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int NUM_FIELD_NUMBER = 3;
  public static final int POITYPE_FIELD_NUMBER = 8;
  public static final int UID_FIELD_NUMBER = 4;
  private int A = -1;
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
  private int p = 0;
  private boolean q;
  private String r = "";
  private boolean s;
  private String t = "";
  private boolean u;
  private int v = 0;
  private boolean w;
  private int x = 0;
  private boolean y;
  private String z = "";
  
  public static End parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new End().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static End parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (End)new End().mergeFrom(paramArrayOfByte);
  }
  
  public final End clear()
  {
    clearCode();
    clearName();
    clearNum();
    clearUid();
    clearAddr();
    clearGeo();
    clearExt();
    clearPoiType();
    clearIndoorFloor();
    clearIndoorParentUid();
    clearDist();
    clearDirection();
    clearDescribe();
    this.A = -1;
    return this;
  }
  
  public End clearAddr()
  {
    this.i = false;
    this.j = "";
    return this;
  }
  
  public End clearCode()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public End clearDescribe()
  {
    this.y = false;
    this.z = "";
    return this;
  }
  
  public End clearDirection()
  {
    this.w = false;
    this.x = 0;
    return this;
  }
  
  public End clearDist()
  {
    this.u = false;
    this.v = 0;
    return this;
  }
  
  public End clearExt()
  {
    this.m = false;
    this.n = "";
    return this;
  }
  
  public End clearGeo()
  {
    this.k = false;
    this.l = "";
    return this;
  }
  
  public End clearIndoorFloor()
  {
    this.q = false;
    this.r = "";
    return this;
  }
  
  public End clearIndoorParentUid()
  {
    this.s = false;
    this.t = "";
    return this;
  }
  
  public End clearName()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public End clearNum()
  {
    this.e = false;
    this.f = 0;
    return this;
  }
  
  public End clearPoiType()
  {
    this.o = false;
    this.p = 0;
    return this;
  }
  
  public End clearUid()
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
    if (this.A < 0) {
      getSerializedSize();
    }
    return this.A;
  }
  
  public int getCode()
  {
    return this.b;
  }
  
  public String getDescribe()
  {
    return this.z;
  }
  
  public int getDirection()
  {
    return this.x;
  }
  
  public int getDist()
  {
    return this.v;
  }
  
  public String getExt()
  {
    return this.n;
  }
  
  public String getGeo()
  {
    return this.l;
  }
  
  public String getIndoorFloor()
  {
    return this.r;
  }
  
  public String getIndoorParentUid()
  {
    return this.t;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public int getNum()
  {
    return this.f;
  }
  
  public int getPoiType()
  {
    return this.p;
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
    if (hasExt()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getExt());
    }
    i1 = i2;
    if (hasPoiType()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getPoiType());
    }
    i2 = i1;
    if (hasIndoorFloor()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getIndoorFloor());
    }
    i1 = i2;
    if (hasIndoorParentUid()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getIndoorParentUid());
    }
    i2 = i1;
    if (hasDist()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getDist());
    }
    i1 = i2;
    if (hasDirection()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getDirection());
    }
    i2 = i1;
    if (hasDescribe()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getDescribe());
    }
    this.A = i2;
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
    return this.y;
  }
  
  public boolean hasDirection()
  {
    return this.w;
  }
  
  public boolean hasDist()
  {
    return this.u;
  }
  
  public boolean hasExt()
  {
    return this.m;
  }
  
  public boolean hasGeo()
  {
    return this.k;
  }
  
  public boolean hasIndoorFloor()
  {
    return this.q;
  }
  
  public boolean hasIndoorParentUid()
  {
    return this.s;
  }
  
  public boolean hasName()
  {
    return this.c;
  }
  
  public boolean hasNum()
  {
    return this.e;
  }
  
  public boolean hasPoiType()
  {
    return this.o;
  }
  
  public boolean hasUid()
  {
    return this.g;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public End mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setExt(paramCodedInputStreamMicro.readString());
        break;
      case 64: 
        setPoiType(paramCodedInputStreamMicro.readInt32());
        break;
      case 74: 
        setIndoorFloor(paramCodedInputStreamMicro.readString());
        break;
      case 82: 
        setIndoorParentUid(paramCodedInputStreamMicro.readString());
        break;
      case 88: 
        setDist(paramCodedInputStreamMicro.readInt32());
        break;
      case 96: 
        setDirection(paramCodedInputStreamMicro.readInt32());
        break;
      case 106: 
        setDescribe(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public End setAddr(String paramString)
  {
    this.i = true;
    this.j = paramString;
    return this;
  }
  
  public End setCode(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public End setDescribe(String paramString)
  {
    this.y = true;
    this.z = paramString;
    return this;
  }
  
  public End setDirection(int paramInt)
  {
    this.w = true;
    this.x = paramInt;
    return this;
  }
  
  public End setDist(int paramInt)
  {
    this.u = true;
    this.v = paramInt;
    return this;
  }
  
  public End setExt(String paramString)
  {
    this.m = true;
    this.n = paramString;
    return this;
  }
  
  public End setGeo(String paramString)
  {
    this.k = true;
    this.l = paramString;
    return this;
  }
  
  public End setIndoorFloor(String paramString)
  {
    this.q = true;
    this.r = paramString;
    return this;
  }
  
  public End setIndoorParentUid(String paramString)
  {
    this.s = true;
    this.t = paramString;
    return this;
  }
  
  public End setName(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public End setNum(int paramInt)
  {
    this.e = true;
    this.f = paramInt;
    return this;
  }
  
  public End setPoiType(int paramInt)
  {
    this.o = true;
    this.p = paramInt;
    return this;
  }
  
  public End setUid(String paramString)
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
    if (hasExt()) {
      paramCodedOutputStreamMicro.writeString(7, getExt());
    }
    if (hasPoiType()) {
      paramCodedOutputStreamMicro.writeInt32(8, getPoiType());
    }
    if (hasIndoorFloor()) {
      paramCodedOutputStreamMicro.writeString(9, getIndoorFloor());
    }
    if (hasIndoorParentUid()) {
      paramCodedOutputStreamMicro.writeString(10, getIndoorParentUid());
    }
    if (hasDist()) {
      paramCodedOutputStreamMicro.writeInt32(11, getDist());
    }
    if (hasDirection()) {
      paramCodedOutputStreamMicro.writeInt32(12, getDirection());
    }
    if (hasDescribe()) {
      paramCodedOutputStreamMicro.writeString(13, getDescribe());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/End.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */