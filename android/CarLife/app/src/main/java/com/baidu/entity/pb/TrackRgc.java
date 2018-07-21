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

public final class TrackRgc
  extends MessageMicro
{
  public static final int LOC_INFO_FIELD_NUMBER = 1;
  private List<LocInfo> a = Collections.emptyList();
  private int b = -1;
  
  public static TrackRgc parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrackRgc().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrackRgc parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrackRgc)new TrackRgc().mergeFrom(paramArrayOfByte);
  }
  
  public TrackRgc addLocInfo(LocInfo paramLocInfo)
  {
    if (paramLocInfo == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramLocInfo);
    return this;
  }
  
  public final TrackRgc clear()
  {
    clearLocInfo();
    this.b = -1;
    return this;
  }
  
  public TrackRgc clearLocInfo()
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
  
  public LocInfo getLocInfo(int paramInt)
  {
    return (LocInfo)this.a.get(paramInt);
  }
  
  public int getLocInfoCount()
  {
    return this.a.size();
  }
  
  public List<LocInfo> getLocInfoList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getLocInfoList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (LocInfo)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrackRgc mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        LocInfo localLocInfo = new LocInfo();
        paramCodedInputStreamMicro.readMessage(localLocInfo);
        addLocInfo(localLocInfo);
      }
    }
  }
  
  public TrackRgc setLocInfo(int paramInt, LocInfo paramLocInfo)
  {
    if (paramLocInfo == null) {
      return this;
    }
    this.a.set(paramInt, paramLocInfo);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getLocInfoList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (LocInfo)localIterator.next());
    }
  }
  
  public static final class LocInfo
    extends MessageMicro
  {
    public static final int BUSINESS_FIELD_NUMBER = 7;
    public static final int CITY_FIELD_NUMBER = 3;
    public static final int DETAIL_FIELD_NUMBER = 9;
    public static final int DISTRICT_FIELD_NUMBER = 4;
    public static final int LAT_FIELD_NUMBER = 2;
    public static final int LNG_FIELD_NUMBER = 1;
    public static final int NEAR_POI_NAME_FIELD_NUMBER = 8;
    public static final int STREET_FIELD_NUMBER = 5;
    public static final int STREET_NUM_FIELD_NUMBER = 6;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
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
    private String r = "";
    private int s = -1;
    
    public static LocInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new LocInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static LocInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (LocInfo)new LocInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final LocInfo clear()
    {
      clearLng();
      clearLat();
      clearCity();
      clearDistrict();
      clearStreet();
      clearStreetNum();
      clearBusiness();
      clearNearPoiName();
      clearDetail();
      this.s = -1;
      return this;
    }
    
    public LocInfo clearBusiness()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public LocInfo clearCity()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public LocInfo clearDetail()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public LocInfo clearDistrict()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public LocInfo clearLat()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public LocInfo clearLng()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public LocInfo clearNearPoiName()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public LocInfo clearStreet()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public LocInfo clearStreetNum()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public String getBusiness()
    {
      return this.n;
    }
    
    public int getCachedSize()
    {
      if (this.s < 0) {
        getSerializedSize();
      }
      return this.s;
    }
    
    public String getCity()
    {
      return this.f;
    }
    
    public String getDetail()
    {
      return this.r;
    }
    
    public String getDistrict()
    {
      return this.h;
    }
    
    public String getLat()
    {
      return this.d;
    }
    
    public String getLng()
    {
      return this.b;
    }
    
    public String getNearPoiName()
    {
      return this.p;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasLng()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getLng());
      }
      int i1 = i2;
      if (hasLat()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getLat());
      }
      i2 = i1;
      if (hasCity()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getCity());
      }
      i1 = i2;
      if (hasDistrict()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getDistrict());
      }
      i2 = i1;
      if (hasStreet()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getStreet());
      }
      i1 = i2;
      if (hasStreetNum()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getStreetNum());
      }
      i2 = i1;
      if (hasBusiness()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getBusiness());
      }
      i1 = i2;
      if (hasNearPoiName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getNearPoiName());
      }
      i2 = i1;
      if (hasDetail()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getDetail());
      }
      this.s = i2;
      return i2;
    }
    
    public String getStreet()
    {
      return this.j;
    }
    
    public String getStreetNum()
    {
      return this.l;
    }
    
    public boolean hasBusiness()
    {
      return this.m;
    }
    
    public boolean hasCity()
    {
      return this.e;
    }
    
    public boolean hasDetail()
    {
      return this.q;
    }
    
    public boolean hasDistrict()
    {
      return this.g;
    }
    
    public boolean hasLat()
    {
      return this.c;
    }
    
    public boolean hasLng()
    {
      return this.a;
    }
    
    public boolean hasNearPoiName()
    {
      return this.o;
    }
    
    public boolean hasStreet()
    {
      return this.i;
    }
    
    public boolean hasStreetNum()
    {
      return this.k;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public LocInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setLng(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setLat(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setCity(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setDistrict(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setStreet(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setStreetNum(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setBusiness(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setNearPoiName(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setDetail(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public LocInfo setBusiness(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public LocInfo setCity(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public LocInfo setDetail(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public LocInfo setDistrict(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public LocInfo setLat(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public LocInfo setLng(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public LocInfo setNearPoiName(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public LocInfo setStreet(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public LocInfo setStreetNum(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasLng()) {
        paramCodedOutputStreamMicro.writeString(1, getLng());
      }
      if (hasLat()) {
        paramCodedOutputStreamMicro.writeString(2, getLat());
      }
      if (hasCity()) {
        paramCodedOutputStreamMicro.writeString(3, getCity());
      }
      if (hasDistrict()) {
        paramCodedOutputStreamMicro.writeString(4, getDistrict());
      }
      if (hasStreet()) {
        paramCodedOutputStreamMicro.writeString(5, getStreet());
      }
      if (hasStreetNum()) {
        paramCodedOutputStreamMicro.writeString(6, getStreetNum());
      }
      if (hasBusiness()) {
        paramCodedOutputStreamMicro.writeString(7, getBusiness());
      }
      if (hasNearPoiName()) {
        paramCodedOutputStreamMicro.writeString(8, getNearPoiName());
      }
      if (hasDetail()) {
        paramCodedOutputStreamMicro.writeString(9, getDetail());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrackRgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */