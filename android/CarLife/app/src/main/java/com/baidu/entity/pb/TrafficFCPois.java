package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class TrafficFCPois
  extends MessageMicro
{
  public static final int FC_POI_INFO_FIELD_NUMBER = 1;
  private List<FCPoiInfo> a = Collections.emptyList();
  private int b = -1;
  
  public static TrafficFCPois parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrafficFCPois().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrafficFCPois parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrafficFCPois)new TrafficFCPois().mergeFrom(paramArrayOfByte);
  }
  
  public TrafficFCPois addFcPoiInfo(FCPoiInfo paramFCPoiInfo)
  {
    if (paramFCPoiInfo == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramFCPoiInfo);
    return this;
  }
  
  public final TrafficFCPois clear()
  {
    clearFcPoiInfo();
    this.b = -1;
    return this;
  }
  
  public TrafficFCPois clearFcPoiInfo()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.b < 0) {
      getSerializedSize();
    }
    return this.b;
  }
  
  public FCPoiInfo getFcPoiInfo(int paramInt)
  {
    return (FCPoiInfo)this.a.get(paramInt);
  }
  
  public int getFcPoiInfoCount()
  {
    return this.a.size();
  }
  
  public List<FCPoiInfo> getFcPoiInfoList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getFcPoiInfoList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (FCPoiInfo)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrafficFCPois mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        FCPoiInfo localFCPoiInfo = new FCPoiInfo();
        paramCodedInputStreamMicro.readMessage(localFCPoiInfo);
        addFcPoiInfo(localFCPoiInfo);
      }
    }
  }
  
  public TrafficFCPois setFcPoiInfo(int paramInt, FCPoiInfo paramFCPoiInfo)
  {
    if (paramFCPoiInfo == null) {
      return this;
    }
    this.a.set(paramInt, paramFCPoiInfo);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getFcPoiInfoList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (FCPoiInfo)localIterator.next());
    }
  }
  
  public static final class FCPoiInfo
    extends MessageMicro
  {
    public static final int CITY_LIST_FIELD_NUMBER = 2;
    public static final int C_POIS_FIELD_NUMBER = 6;
    public static final int C_POIS_GEO_FIELD_NUMBER = 7;
    public static final int F_POIS_FIELD_NUMBER = 4;
    public static final int F_POIS_GEO_FIELD_NUMBER = 5;
    public static final int KEY_WD_FIELD_NUMBER = 3;
    public static final int PRIO_FLAG_FIELD_NUMBER = 1;
    private boolean a;
    private boolean b = false;
    private boolean c;
    private boolean d = false;
    private boolean e;
    private ByteStringMicro f = ByteStringMicro.EMPTY;
    private List<FCPoi> g = Collections.emptyList();
    private boolean h;
    private ByteStringMicro i = ByteStringMicro.EMPTY;
    private List<FCPoi> j = Collections.emptyList();
    private boolean k;
    private ByteStringMicro l = ByteStringMicro.EMPTY;
    private int m = -1;
    
    public static FCPoiInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FCPoiInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FCPoiInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FCPoiInfo)new FCPoiInfo().mergeFrom(paramArrayOfByte);
    }
    
    public FCPoiInfo addCPois(FCPoi paramFCPoi)
    {
      if (paramFCPoi == null) {
        return this;
      }
      if (this.j.isEmpty()) {
        this.j = new ArrayList();
      }
      this.j.add(paramFCPoi);
      return this;
    }
    
    public FCPoiInfo addFPois(FCPoi paramFCPoi)
    {
      if (paramFCPoi == null) {
        return this;
      }
      if (this.g.isEmpty()) {
        this.g = new ArrayList();
      }
      this.g.add(paramFCPoi);
      return this;
    }
    
    public final FCPoiInfo clear()
    {
      clearPrioFlag();
      clearCityList();
      clearKeyWd();
      clearFPois();
      clearFPoisGeo();
      clearCPois();
      clearCPoisGeo();
      this.m = -1;
      return this;
    }
    
    public FCPoiInfo clearCPois()
    {
      this.j = Collections.emptyList();
      return this;
    }
    
    public FCPoiInfo clearCPoisGeo()
    {
      this.k = false;
      this.l = ByteStringMicro.EMPTY;
      return this;
    }
    
    public FCPoiInfo clearCityList()
    {
      this.c = false;
      this.d = false;
      return this;
    }
    
    public FCPoiInfo clearFPois()
    {
      this.g = Collections.emptyList();
      return this;
    }
    
    public FCPoiInfo clearFPoisGeo()
    {
      this.h = false;
      this.i = ByteStringMicro.EMPTY;
      return this;
    }
    
    public FCPoiInfo clearKeyWd()
    {
      this.e = false;
      this.f = ByteStringMicro.EMPTY;
      return this;
    }
    
    public FCPoiInfo clearPrioFlag()
    {
      this.a = false;
      this.b = false;
      return this;
    }
    
    public FCPoi getCPois(int paramInt)
    {
      return (FCPoi)this.j.get(paramInt);
    }
    
    public int getCPoisCount()
    {
      return this.j.size();
    }
    
    public ByteStringMicro getCPoisGeo()
    {
      return this.l;
    }
    
    public List<FCPoi> getCPoisList()
    {
      return this.j;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public boolean getCityList()
    {
      return this.d;
    }
    
    public FCPoi getFPois(int paramInt)
    {
      return (FCPoi)this.g.get(paramInt);
    }
    
    public int getFPoisCount()
    {
      return this.g.size();
    }
    
    public ByteStringMicro getFPoisGeo()
    {
      return this.i;
    }
    
    public List<FCPoi> getFPoisList()
    {
      return this.g;
    }
    
    public ByteStringMicro getKeyWd()
    {
      return this.f;
    }
    
    public boolean getPrioFlag()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasPrioFlag()) {
        i1 = 0 + CodedOutputStreamMicro.computeBoolSize(1, getPrioFlag());
      }
      int n = i1;
      if (hasCityList()) {
        n = i1 + CodedOutputStreamMicro.computeBoolSize(2, getCityList());
      }
      i1 = n;
      if (hasKeyWd()) {
        i1 = n + CodedOutputStreamMicro.computeBytesSize(3, getKeyWd());
      }
      Iterator localIterator = getFPoisList().iterator();
      for (n = i1; localIterator.hasNext(); n = CodedOutputStreamMicro.computeMessageSize(4, (FCPoi)localIterator.next()) + n) {}
      i1 = n;
      if (hasFPoisGeo()) {
        i1 = n + CodedOutputStreamMicro.computeBytesSize(5, getFPoisGeo());
      }
      localIterator = getCPoisList().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(6, (FCPoi)localIterator.next());
      }
      n = i1;
      if (hasCPoisGeo()) {
        n = i1 + CodedOutputStreamMicro.computeBytesSize(7, getCPoisGeo());
      }
      this.m = n;
      return n;
    }
    
    public boolean hasCPoisGeo()
    {
      return this.k;
    }
    
    public boolean hasCityList()
    {
      return this.c;
    }
    
    public boolean hasFPoisGeo()
    {
      return this.h;
    }
    
    public boolean hasKeyWd()
    {
      return this.e;
    }
    
    public boolean hasPrioFlag()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public FCPoiInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int n = paramCodedInputStreamMicro.readTag();
        FCPoi localFCPoi;
        switch (n)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setPrioFlag(paramCodedInputStreamMicro.readBool());
          break;
        case 16: 
          setCityList(paramCodedInputStreamMicro.readBool());
          break;
        case 26: 
          setKeyWd(paramCodedInputStreamMicro.readBytes());
          break;
        case 34: 
          localFCPoi = new FCPoi();
          paramCodedInputStreamMicro.readMessage(localFCPoi);
          addFPois(localFCPoi);
          break;
        case 42: 
          setFPoisGeo(paramCodedInputStreamMicro.readBytes());
          break;
        case 50: 
          localFCPoi = new FCPoi();
          paramCodedInputStreamMicro.readMessage(localFCPoi);
          addCPois(localFCPoi);
          break;
        case 58: 
          setCPoisGeo(paramCodedInputStreamMicro.readBytes());
        }
      }
    }
    
    public FCPoiInfo setCPois(int paramInt, FCPoi paramFCPoi)
    {
      if (paramFCPoi == null) {
        return this;
      }
      this.j.set(paramInt, paramFCPoi);
      return this;
    }
    
    public FCPoiInfo setCPoisGeo(ByteStringMicro paramByteStringMicro)
    {
      this.k = true;
      this.l = paramByteStringMicro;
      return this;
    }
    
    public FCPoiInfo setCityList(boolean paramBoolean)
    {
      this.c = true;
      this.d = paramBoolean;
      return this;
    }
    
    public FCPoiInfo setFPois(int paramInt, FCPoi paramFCPoi)
    {
      if (paramFCPoi == null) {
        return this;
      }
      this.g.set(paramInt, paramFCPoi);
      return this;
    }
    
    public FCPoiInfo setFPoisGeo(ByteStringMicro paramByteStringMicro)
    {
      this.h = true;
      this.i = paramByteStringMicro;
      return this;
    }
    
    public FCPoiInfo setKeyWd(ByteStringMicro paramByteStringMicro)
    {
      this.e = true;
      this.f = paramByteStringMicro;
      return this;
    }
    
    public FCPoiInfo setPrioFlag(boolean paramBoolean)
    {
      this.a = true;
      this.b = paramBoolean;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPrioFlag()) {
        paramCodedOutputStreamMicro.writeBool(1, getPrioFlag());
      }
      if (hasCityList()) {
        paramCodedOutputStreamMicro.writeBool(2, getCityList());
      }
      if (hasKeyWd()) {
        paramCodedOutputStreamMicro.writeBytes(3, getKeyWd());
      }
      Iterator localIterator = getFPoisList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(4, (FCPoi)localIterator.next());
      }
      if (hasFPoisGeo()) {
        paramCodedOutputStreamMicro.writeBytes(5, getFPoisGeo());
      }
      localIterator = getCPoisList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(6, (FCPoi)localIterator.next());
      }
      if (hasCPoisGeo()) {
        paramCodedOutputStreamMicro.writeBytes(7, getCPoisGeo());
      }
    }
    
    public static final class FCPoi
      extends MessageMicro
    {
      public static final int ADDR_FIELD_NUMBER = 3;
      public static final int ALIAS_NAME_FIELD_NUMBER = 4;
      public static final int CHILD_NUM_FIELD_NUMBER = 7;
      public static final int CODE_FIELD_NUMBER = 5;
      public static final int EXT_FIELD_NUMBER = 6;
      public static final int NAME_FIELD_NUMBER = 1;
      public static final int SHOW_TYPE_FIELD_NUMBER = 8;
      public static final int UID_FIELD_NUMBER = 2;
      private boolean a;
      private ByteStringMicro b = ByteStringMicro.EMPTY;
      private boolean c;
      private String d = "";
      private boolean e;
      private ByteStringMicro f = ByteStringMicro.EMPTY;
      private boolean g;
      private ByteStringMicro h = ByteStringMicro.EMPTY;
      private boolean i;
      private int j = 0;
      private boolean k;
      private String l = "";
      private boolean m;
      private int n = 0;
      private boolean o;
      private int p = 0;
      private int q = -1;
      
      public static FCPoi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new FCPoi().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static FCPoi parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (FCPoi)new FCPoi().mergeFrom(paramArrayOfByte);
      }
      
      public final FCPoi clear()
      {
        clearName();
        clearUid();
        clearAddr();
        clearAliasName();
        clearCode();
        clearExt();
        clearChildNum();
        clearShowType();
        this.q = -1;
        return this;
      }
      
      public FCPoi clearAddr()
      {
        this.e = false;
        this.f = ByteStringMicro.EMPTY;
        return this;
      }
      
      public FCPoi clearAliasName()
      {
        this.g = false;
        this.h = ByteStringMicro.EMPTY;
        return this;
      }
      
      public FCPoi clearChildNum()
      {
        this.m = false;
        this.n = 0;
        return this;
      }
      
      public FCPoi clearCode()
      {
        this.i = false;
        this.j = 0;
        return this;
      }
      
      public FCPoi clearExt()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public FCPoi clearName()
      {
        this.a = false;
        this.b = ByteStringMicro.EMPTY;
        return this;
      }
      
      public FCPoi clearShowType()
      {
        this.o = false;
        this.p = 0;
        return this;
      }
      
      public FCPoi clearUid()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public ByteStringMicro getAddr()
      {
        return this.f;
      }
      
      public ByteStringMicro getAliasName()
      {
        return this.h;
      }
      
      public int getCachedSize()
      {
        if (this.q < 0) {
          getSerializedSize();
        }
        return this.q;
      }
      
      public int getChildNum()
      {
        return this.n;
      }
      
      public int getCode()
      {
        return this.j;
      }
      
      public String getExt()
      {
        return this.l;
      }
      
      public ByteStringMicro getName()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasName()) {
          i2 = 0 + CodedOutputStreamMicro.computeBytesSize(1, getName());
        }
        int i1 = i2;
        if (hasUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getUid());
        }
        i2 = i1;
        if (hasAddr()) {
          i2 = i1 + CodedOutputStreamMicro.computeBytesSize(3, getAddr());
        }
        i1 = i2;
        if (hasAliasName()) {
          i1 = i2 + CodedOutputStreamMicro.computeBytesSize(4, getAliasName());
        }
        i2 = i1;
        if (hasCode()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getCode());
        }
        i1 = i2;
        if (hasExt()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getExt());
        }
        i2 = i1;
        if (hasChildNum()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getChildNum());
        }
        i1 = i2;
        if (hasShowType()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getShowType());
        }
        this.q = i1;
        return i1;
      }
      
      public int getShowType()
      {
        return this.p;
      }
      
      public String getUid()
      {
        return this.d;
      }
      
      public boolean hasAddr()
      {
        return this.e;
      }
      
      public boolean hasAliasName()
      {
        return this.g;
      }
      
      public boolean hasChildNum()
      {
        return this.m;
      }
      
      public boolean hasCode()
      {
        return this.i;
      }
      
      public boolean hasExt()
      {
        return this.k;
      }
      
      public boolean hasName()
      {
        return this.a;
      }
      
      public boolean hasShowType()
      {
        return this.o;
      }
      
      public boolean hasUid()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public FCPoi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setName(paramCodedInputStreamMicro.readBytes());
            break;
          case 18: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setAddr(paramCodedInputStreamMicro.readBytes());
            break;
          case 34: 
            setAliasName(paramCodedInputStreamMicro.readBytes());
            break;
          case 40: 
            setCode(paramCodedInputStreamMicro.readInt32());
            break;
          case 50: 
            setExt(paramCodedInputStreamMicro.readString());
            break;
          case 56: 
            setChildNum(paramCodedInputStreamMicro.readInt32());
            break;
          case 64: 
            setShowType(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public FCPoi setAddr(ByteStringMicro paramByteStringMicro)
      {
        this.e = true;
        this.f = paramByteStringMicro;
        return this;
      }
      
      public FCPoi setAliasName(ByteStringMicro paramByteStringMicro)
      {
        this.g = true;
        this.h = paramByteStringMicro;
        return this;
      }
      
      public FCPoi setChildNum(int paramInt)
      {
        this.m = true;
        this.n = paramInt;
        return this;
      }
      
      public FCPoi setCode(int paramInt)
      {
        this.i = true;
        this.j = paramInt;
        return this;
      }
      
      public FCPoi setExt(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public FCPoi setName(ByteStringMicro paramByteStringMicro)
      {
        this.a = true;
        this.b = paramByteStringMicro;
        return this;
      }
      
      public FCPoi setShowType(int paramInt)
      {
        this.o = true;
        this.p = paramInt;
        return this;
      }
      
      public FCPoi setUid(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasName()) {
          paramCodedOutputStreamMicro.writeBytes(1, getName());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(2, getUid());
        }
        if (hasAddr()) {
          paramCodedOutputStreamMicro.writeBytes(3, getAddr());
        }
        if (hasAliasName()) {
          paramCodedOutputStreamMicro.writeBytes(4, getAliasName());
        }
        if (hasCode()) {
          paramCodedOutputStreamMicro.writeInt32(5, getCode());
        }
        if (hasExt()) {
          paramCodedOutputStreamMicro.writeString(6, getExt());
        }
        if (hasChildNum()) {
          paramCodedOutputStreamMicro.writeInt32(7, getChildNum());
        }
        if (hasShowType()) {
          paramCodedOutputStreamMicro.writeInt32(8, getShowType());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrafficFCPois.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */