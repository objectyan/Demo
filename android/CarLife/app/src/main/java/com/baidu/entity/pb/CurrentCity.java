package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CurrentCity
  extends MessageMicro
{
  public static final int CODE_FIELD_NUMBER = 1;
  public static final int GEO_FIELD_NUMBER = 2;
  public static final int LEVEL_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 4;
  public static final int SGEO_FIELD_NUMBER = 8;
  public static final int SUP_LUKUANG_FIELD_NUMBER = 6;
  public static final int SUP_SUBWAY_FIELD_NUMBER = 5;
  public static final int UID_FIELD_NUMBER = 7;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private boolean e;
  private int f = 0;
  private boolean g;
  private String h = "";
  private boolean i;
  private boolean j = false;
  private boolean k;
  private boolean l = false;
  private boolean m;
  private String n = "";
  private List<Integer> o = Collections.emptyList();
  private int p = -1;
  
  public static CurrentCity parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new CurrentCity().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static CurrentCity parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (CurrentCity)new CurrentCity().mergeFrom(paramArrayOfByte);
  }
  
  public CurrentCity addSgeo(int paramInt)
  {
    if (this.o.isEmpty()) {
      this.o = new ArrayList();
    }
    this.o.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public final CurrentCity clear()
  {
    clearCode();
    clearGeo();
    clearLevel();
    clearName();
    clearSupSubway();
    clearSupLukuang();
    clearUid();
    clearSgeo();
    this.p = -1;
    return this;
  }
  
  public CurrentCity clearCode()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public CurrentCity clearGeo()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public CurrentCity clearLevel()
  {
    this.e = false;
    this.f = 0;
    return this;
  }
  
  public CurrentCity clearName()
  {
    this.g = false;
    this.h = "";
    return this;
  }
  
  public CurrentCity clearSgeo()
  {
    this.o = Collections.emptyList();
    return this;
  }
  
  public CurrentCity clearSupLukuang()
  {
    this.k = false;
    this.l = false;
    return this;
  }
  
  public CurrentCity clearSupSubway()
  {
    this.i = false;
    this.j = false;
    return this;
  }
  
  public CurrentCity clearUid()
  {
    this.m = false;
    this.n = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.p < 0) {
      getSerializedSize();
    }
    return this.p;
  }
  
  public int getCode()
  {
    return this.b;
  }
  
  public String getGeo()
  {
    return this.d;
  }
  
  public int getLevel()
  {
    return this.f;
  }
  
  public String getName()
  {
    return this.h;
  }
  
  public int getSerializedSize()
  {
    int i3 = 0;
    if (hasCode()) {}
    for (int i2 = CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0;; i2 = 0)
    {
      int i1 = i2;
      if (hasGeo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getGeo());
      }
      i2 = i1;
      if (hasLevel()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getLevel());
      }
      i1 = i2;
      if (hasName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getName());
      }
      i2 = i1;
      if (hasSupSubway()) {
        i2 = i1 + CodedOutputStreamMicro.computeBoolSize(5, getSupSubway());
      }
      i1 = i2;
      if (hasSupLukuang()) {
        i1 = i2 + CodedOutputStreamMicro.computeBoolSize(6, getSupLukuang());
      }
      if (hasUid()) {
        i1 += CodedOutputStreamMicro.computeStringSize(7, getUid());
      }
      for (;;)
      {
        Iterator localIterator = getSgeoList().iterator();
        i2 = i3;
        while (localIterator.hasNext()) {
          i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
        }
        i1 = i1 + i2 + getSgeoList().size() * 1;
        this.p = i1;
        return i1;
      }
    }
  }
  
  public int getSgeo(int paramInt)
  {
    return ((Integer)this.o.get(paramInt)).intValue();
  }
  
  public int getSgeoCount()
  {
    return this.o.size();
  }
  
  public List<Integer> getSgeoList()
  {
    return this.o;
  }
  
  public boolean getSupLukuang()
  {
    return this.l;
  }
  
  public boolean getSupSubway()
  {
    return this.j;
  }
  
  public String getUid()
  {
    return this.n;
  }
  
  public boolean hasCode()
  {
    return this.a;
  }
  
  public boolean hasGeo()
  {
    return this.c;
  }
  
  public boolean hasLevel()
  {
    return this.e;
  }
  
  public boolean hasName()
  {
    return this.g;
  }
  
  public boolean hasSupLukuang()
  {
    return this.k;
  }
  
  public boolean hasSupSubway()
  {
    return this.i;
  }
  
  public boolean hasUid()
  {
    return this.m;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public CurrentCity mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setGeo(paramCodedInputStreamMicro.readString());
        break;
      case 24: 
        setLevel(paramCodedInputStreamMicro.readInt32());
        break;
      case 34: 
        setName(paramCodedInputStreamMicro.readString());
        break;
      case 40: 
        setSupSubway(paramCodedInputStreamMicro.readBool());
        break;
      case 48: 
        setSupLukuang(paramCodedInputStreamMicro.readBool());
        break;
      case 58: 
        setUid(paramCodedInputStreamMicro.readString());
        break;
      case 64: 
        addSgeo(paramCodedInputStreamMicro.readSInt32());
      }
    }
  }
  
  public CurrentCity setCode(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public CurrentCity setGeo(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public CurrentCity setLevel(int paramInt)
  {
    this.e = true;
    this.f = paramInt;
    return this;
  }
  
  public CurrentCity setName(String paramString)
  {
    this.g = true;
    this.h = paramString;
    return this;
  }
  
  public CurrentCity setSgeo(int paramInt1, int paramInt2)
  {
    this.o.set(paramInt1, Integer.valueOf(paramInt2));
    return this;
  }
  
  public CurrentCity setSupLukuang(boolean paramBoolean)
  {
    this.k = true;
    this.l = paramBoolean;
    return this;
  }
  
  public CurrentCity setSupSubway(boolean paramBoolean)
  {
    this.i = true;
    this.j = paramBoolean;
    return this;
  }
  
  public CurrentCity setUid(String paramString)
  {
    this.m = true;
    this.n = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasCode()) {
      paramCodedOutputStreamMicro.writeInt32(1, getCode());
    }
    if (hasGeo()) {
      paramCodedOutputStreamMicro.writeString(2, getGeo());
    }
    if (hasLevel()) {
      paramCodedOutputStreamMicro.writeInt32(3, getLevel());
    }
    if (hasName()) {
      paramCodedOutputStreamMicro.writeString(4, getName());
    }
    if (hasSupSubway()) {
      paramCodedOutputStreamMicro.writeBool(5, getSupSubway());
    }
    if (hasSupLukuang()) {
      paramCodedOutputStreamMicro.writeBool(6, getSupLukuang());
    }
    if (hasUid()) {
      paramCodedOutputStreamMicro.writeString(7, getUid());
    }
    Iterator localIterator = getSgeoList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeSInt32(8, ((Integer)localIterator.next()).intValue());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/CurrentCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */