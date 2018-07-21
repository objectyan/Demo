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

public final class TrackExplore
  extends MessageMicro
{
  public static final int ACROSS_NORTH_TO_SOUTH_FIELD_NUMBER = 7;
  public static final int ACROSS_WEST_TO_EAST_FIELD_NUMBER = 6;
  public static final int ARRIVED_CITY_LIST_FIELD_NUMBER = 5;
  public static final int CITY_NUM_FIELD_NUMBER = 3;
  public static final int DISTANCE_FIELD_NUMBER = 2;
  public static final int HOMECITY_DISTRICT_LIST_FIELD_NUMBER = 11;
  public static final int HOMECITY_DISTRICT_NUM_FIELD_NUMBER = 10;
  public static final int HOMECITY_FIELD_NUMBER = 8;
  public static final int POINT_NUM_FIELD_NUMBER = 1;
  public static final int POINT_PERCENT_AT_HOMECITY_FIELD_NUMBER = 9;
  public static final int POINT_PERCENT_AT_TRADEAREA_FIELD_NUMBER = 13;
  public static final int PROVINCE_NUM_FIELD_NUMBER = 4;
  public static final int TRADEAREA_FIELD_NUMBER = 12;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private boolean e;
  private int f = 0;
  private boolean g;
  private int h = 0;
  private List<ArrivedCity> i = Collections.emptyList();
  private boolean j;
  private AcrossWestToEast k = null;
  private boolean l;
  private AcrossNorthToSouth m = null;
  private boolean n;
  private String o = "";
  private boolean p;
  private int q = 0;
  private boolean r;
  private int s = 0;
  private List<HomecityDirstrict> t = Collections.emptyList();
  private boolean u;
  private String v = "";
  private boolean w;
  private String x = "";
  private int y = -1;
  
  public static TrackExplore parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrackExplore().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrackExplore parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrackExplore)new TrackExplore().mergeFrom(paramArrayOfByte);
  }
  
  public TrackExplore addArrivedCityList(ArrivedCity paramArrivedCity)
  {
    if (paramArrivedCity == null) {
      return this;
    }
    if (this.i.isEmpty()) {
      this.i = new ArrayList();
    }
    this.i.add(paramArrivedCity);
    return this;
  }
  
  public TrackExplore addHomecityDistrictList(HomecityDirstrict paramHomecityDirstrict)
  {
    if (paramHomecityDirstrict == null) {
      return this;
    }
    if (this.t.isEmpty()) {
      this.t = new ArrayList();
    }
    this.t.add(paramHomecityDirstrict);
    return this;
  }
  
  public final TrackExplore clear()
  {
    clearPointNum();
    clearDistance();
    clearCityNum();
    clearProvinceNum();
    clearArrivedCityList();
    clearAcrossWestToEast();
    clearAcrossNorthToSouth();
    clearHomecity();
    clearPointPercentAtHomecity();
    clearHomecityDistrictNum();
    clearHomecityDistrictList();
    clearTradearea();
    clearPointPercentAtTradearea();
    this.y = -1;
    return this;
  }
  
  public TrackExplore clearAcrossNorthToSouth()
  {
    this.l = false;
    this.m = null;
    return this;
  }
  
  public TrackExplore clearAcrossWestToEast()
  {
    this.j = false;
    this.k = null;
    return this;
  }
  
  public TrackExplore clearArrivedCityList()
  {
    this.i = Collections.emptyList();
    return this;
  }
  
  public TrackExplore clearCityNum()
  {
    this.e = false;
    this.f = 0;
    return this;
  }
  
  public TrackExplore clearDistance()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public TrackExplore clearHomecity()
  {
    this.n = false;
    this.o = "";
    return this;
  }
  
  public TrackExplore clearHomecityDistrictList()
  {
    this.t = Collections.emptyList();
    return this;
  }
  
  public TrackExplore clearHomecityDistrictNum()
  {
    this.r = false;
    this.s = 0;
    return this;
  }
  
  public TrackExplore clearPointNum()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public TrackExplore clearPointPercentAtHomecity()
  {
    this.p = false;
    this.q = 0;
    return this;
  }
  
  public TrackExplore clearPointPercentAtTradearea()
  {
    this.w = false;
    this.x = "";
    return this;
  }
  
  public TrackExplore clearProvinceNum()
  {
    this.g = false;
    this.h = 0;
    return this;
  }
  
  public TrackExplore clearTradearea()
  {
    this.u = false;
    this.v = "";
    return this;
  }
  
  public AcrossNorthToSouth getAcrossNorthToSouth()
  {
    return this.m;
  }
  
  public AcrossWestToEast getAcrossWestToEast()
  {
    return this.k;
  }
  
  public ArrivedCity getArrivedCityList(int paramInt)
  {
    return (ArrivedCity)this.i.get(paramInt);
  }
  
  public int getArrivedCityListCount()
  {
    return this.i.size();
  }
  
  public List<ArrivedCity> getArrivedCityListList()
  {
    return this.i;
  }
  
  public int getCachedSize()
  {
    if (this.y < 0) {
      getSerializedSize();
    }
    return this.y;
  }
  
  public int getCityNum()
  {
    return this.f;
  }
  
  public String getDistance()
  {
    return this.d;
  }
  
  public String getHomecity()
  {
    return this.o;
  }
  
  public HomecityDirstrict getHomecityDistrictList(int paramInt)
  {
    return (HomecityDirstrict)this.t.get(paramInt);
  }
  
  public int getHomecityDistrictListCount()
  {
    return this.t.size();
  }
  
  public List<HomecityDirstrict> getHomecityDistrictListList()
  {
    return this.t;
  }
  
  public int getHomecityDistrictNum()
  {
    return this.s;
  }
  
  public int getPointNum()
  {
    return this.b;
  }
  
  public int getPointPercentAtHomecity()
  {
    return this.q;
  }
  
  public String getPointPercentAtTradearea()
  {
    return this.x;
  }
  
  public int getProvinceNum()
  {
    return this.h;
  }
  
  public int getSerializedSize()
  {
    int i2 = 0;
    if (hasPointNum()) {
      i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getPointNum());
    }
    int i1 = i2;
    if (hasDistance()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getDistance());
    }
    i2 = i1;
    if (hasCityNum()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getCityNum());
    }
    i1 = i2;
    if (hasProvinceNum()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getProvinceNum());
    }
    Iterator localIterator = getArrivedCityListList().iterator();
    for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(5, (ArrivedCity)localIterator.next()) + i2) {}
    i1 = i2;
    if (hasAcrossWestToEast()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getAcrossWestToEast());
    }
    i2 = i1;
    if (hasAcrossNorthToSouth()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getAcrossNorthToSouth());
    }
    i1 = i2;
    if (hasHomecity()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getHomecity());
    }
    i2 = i1;
    if (hasPointPercentAtHomecity()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getPointPercentAtHomecity());
    }
    i1 = i2;
    if (hasHomecityDistrictNum()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getHomecityDistrictNum());
    }
    localIterator = getHomecityDistrictListList().iterator();
    i2 = i1;
    while (localIterator.hasNext()) {
      i2 += CodedOutputStreamMicro.computeMessageSize(11, (HomecityDirstrict)localIterator.next());
    }
    i1 = i2;
    if (hasTradearea()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getTradearea());
    }
    i2 = i1;
    if (hasPointPercentAtTradearea()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getPointPercentAtTradearea());
    }
    this.y = i2;
    return i2;
  }
  
  public String getTradearea()
  {
    return this.v;
  }
  
  public boolean hasAcrossNorthToSouth()
  {
    return this.l;
  }
  
  public boolean hasAcrossWestToEast()
  {
    return this.j;
  }
  
  public boolean hasCityNum()
  {
    return this.e;
  }
  
  public boolean hasDistance()
  {
    return this.c;
  }
  
  public boolean hasHomecity()
  {
    return this.n;
  }
  
  public boolean hasHomecityDistrictNum()
  {
    return this.r;
  }
  
  public boolean hasPointNum()
  {
    return this.a;
  }
  
  public boolean hasPointPercentAtHomecity()
  {
    return this.p;
  }
  
  public boolean hasPointPercentAtTradearea()
  {
    return this.w;
  }
  
  public boolean hasProvinceNum()
  {
    return this.g;
  }
  
  public boolean hasTradearea()
  {
    return this.u;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrackExplore mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i1 = paramCodedInputStreamMicro.readTag();
      Object localObject;
      switch (i1)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
        break;
      case 0: 
        return this;
      case 8: 
        setPointNum(paramCodedInputStreamMicro.readInt32());
        break;
      case 18: 
        setDistance(paramCodedInputStreamMicro.readString());
        break;
      case 24: 
        setCityNum(paramCodedInputStreamMicro.readInt32());
        break;
      case 32: 
        setProvinceNum(paramCodedInputStreamMicro.readInt32());
        break;
      case 42: 
        localObject = new ArrivedCity();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addArrivedCityList((ArrivedCity)localObject);
        break;
      case 50: 
        localObject = new AcrossWestToEast();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setAcrossWestToEast((AcrossWestToEast)localObject);
        break;
      case 58: 
        localObject = new AcrossNorthToSouth();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setAcrossNorthToSouth((AcrossNorthToSouth)localObject);
        break;
      case 66: 
        setHomecity(paramCodedInputStreamMicro.readString());
        break;
      case 72: 
        setPointPercentAtHomecity(paramCodedInputStreamMicro.readInt32());
        break;
      case 80: 
        setHomecityDistrictNum(paramCodedInputStreamMicro.readInt32());
        break;
      case 90: 
        localObject = new HomecityDirstrict();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addHomecityDistrictList((HomecityDirstrict)localObject);
        break;
      case 98: 
        setTradearea(paramCodedInputStreamMicro.readString());
        break;
      case 106: 
        setPointPercentAtTradearea(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public TrackExplore setAcrossNorthToSouth(AcrossNorthToSouth paramAcrossNorthToSouth)
  {
    if (paramAcrossNorthToSouth == null) {
      return clearAcrossNorthToSouth();
    }
    this.l = true;
    this.m = paramAcrossNorthToSouth;
    return this;
  }
  
  public TrackExplore setAcrossWestToEast(AcrossWestToEast paramAcrossWestToEast)
  {
    if (paramAcrossWestToEast == null) {
      return clearAcrossWestToEast();
    }
    this.j = true;
    this.k = paramAcrossWestToEast;
    return this;
  }
  
  public TrackExplore setArrivedCityList(int paramInt, ArrivedCity paramArrivedCity)
  {
    if (paramArrivedCity == null) {
      return this;
    }
    this.i.set(paramInt, paramArrivedCity);
    return this;
  }
  
  public TrackExplore setCityNum(int paramInt)
  {
    this.e = true;
    this.f = paramInt;
    return this;
  }
  
  public TrackExplore setDistance(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public TrackExplore setHomecity(String paramString)
  {
    this.n = true;
    this.o = paramString;
    return this;
  }
  
  public TrackExplore setHomecityDistrictList(int paramInt, HomecityDirstrict paramHomecityDirstrict)
  {
    if (paramHomecityDirstrict == null) {
      return this;
    }
    this.t.set(paramInt, paramHomecityDirstrict);
    return this;
  }
  
  public TrackExplore setHomecityDistrictNum(int paramInt)
  {
    this.r = true;
    this.s = paramInt;
    return this;
  }
  
  public TrackExplore setPointNum(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public TrackExplore setPointPercentAtHomecity(int paramInt)
  {
    this.p = true;
    this.q = paramInt;
    return this;
  }
  
  public TrackExplore setPointPercentAtTradearea(String paramString)
  {
    this.w = true;
    this.x = paramString;
    return this;
  }
  
  public TrackExplore setProvinceNum(int paramInt)
  {
    this.g = true;
    this.h = paramInt;
    return this;
  }
  
  public TrackExplore setTradearea(String paramString)
  {
    this.u = true;
    this.v = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasPointNum()) {
      paramCodedOutputStreamMicro.writeInt32(1, getPointNum());
    }
    if (hasDistance()) {
      paramCodedOutputStreamMicro.writeString(2, getDistance());
    }
    if (hasCityNum()) {
      paramCodedOutputStreamMicro.writeInt32(3, getCityNum());
    }
    if (hasProvinceNum()) {
      paramCodedOutputStreamMicro.writeInt32(4, getProvinceNum());
    }
    Iterator localIterator = getArrivedCityListList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(5, (ArrivedCity)localIterator.next());
    }
    if (hasAcrossWestToEast()) {
      paramCodedOutputStreamMicro.writeMessage(6, getAcrossWestToEast());
    }
    if (hasAcrossNorthToSouth()) {
      paramCodedOutputStreamMicro.writeMessage(7, getAcrossNorthToSouth());
    }
    if (hasHomecity()) {
      paramCodedOutputStreamMicro.writeString(8, getHomecity());
    }
    if (hasPointPercentAtHomecity()) {
      paramCodedOutputStreamMicro.writeInt32(9, getPointPercentAtHomecity());
    }
    if (hasHomecityDistrictNum()) {
      paramCodedOutputStreamMicro.writeInt32(10, getHomecityDistrictNum());
    }
    localIterator = getHomecityDistrictListList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(11, (HomecityDirstrict)localIterator.next());
    }
    if (hasTradearea()) {
      paramCodedOutputStreamMicro.writeString(12, getTradearea());
    }
    if (hasPointPercentAtTradearea()) {
      paramCodedOutputStreamMicro.writeString(13, getPointPercentAtTradearea());
    }
  }
  
  public static final class AcrossNorthToSouth
    extends MessageMicro
  {
    public static final int AMOUNT_DESC_FIELD_NUMBER = 4;
    public static final int DISTANCE_FIELD_NUMBER = 3;
    public static final int NORTH_CITY_FIELD_NUMBER = 1;
    public static final int SOUTH_CITY_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static AcrossNorthToSouth parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new AcrossNorthToSouth().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static AcrossNorthToSouth parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (AcrossNorthToSouth)new AcrossNorthToSouth().mergeFrom(paramArrayOfByte);
    }
    
    public final AcrossNorthToSouth clear()
    {
      clearNorthCity();
      clearSouthCity();
      clearDistance();
      clearAmountDesc();
      this.i = -1;
      return this;
    }
    
    public AcrossNorthToSouth clearAmountDesc()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public AcrossNorthToSouth clearDistance()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public AcrossNorthToSouth clearNorthCity()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public AcrossNorthToSouth clearSouthCity()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public String getAmountDesc()
    {
      return this.h;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public String getDistance()
    {
      return this.f;
    }
    
    public String getNorthCity()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasNorthCity()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getNorthCity());
      }
      int j = k;
      if (hasSouthCity()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getSouthCity());
      }
      k = j;
      if (hasDistance()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getDistance());
      }
      j = k;
      if (hasAmountDesc()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getAmountDesc());
      }
      this.i = j;
      return j;
    }
    
    public String getSouthCity()
    {
      return this.d;
    }
    
    public boolean hasAmountDesc()
    {
      return this.g;
    }
    
    public boolean hasDistance()
    {
      return this.e;
    }
    
    public boolean hasNorthCity()
    {
      return this.a;
    }
    
    public boolean hasSouthCity()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public AcrossNorthToSouth mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int j = paramCodedInputStreamMicro.readTag();
        switch (j)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setNorthCity(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setSouthCity(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setDistance(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setAmountDesc(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public AcrossNorthToSouth setAmountDesc(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public AcrossNorthToSouth setDistance(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public AcrossNorthToSouth setNorthCity(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public AcrossNorthToSouth setSouthCity(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasNorthCity()) {
        paramCodedOutputStreamMicro.writeString(1, getNorthCity());
      }
      if (hasSouthCity()) {
        paramCodedOutputStreamMicro.writeString(2, getSouthCity());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeString(3, getDistance());
      }
      if (hasAmountDesc()) {
        paramCodedOutputStreamMicro.writeString(4, getAmountDesc());
      }
    }
  }
  
  public static final class AcrossWestToEast
    extends MessageMicro
  {
    public static final int AMOUNT_DESC_FIELD_NUMBER = 4;
    public static final int DISTANCE_FIELD_NUMBER = 3;
    public static final int EAST_CITY_FIELD_NUMBER = 2;
    public static final int WEST_CITY_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static AcrossWestToEast parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new AcrossWestToEast().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static AcrossWestToEast parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (AcrossWestToEast)new AcrossWestToEast().mergeFrom(paramArrayOfByte);
    }
    
    public final AcrossWestToEast clear()
    {
      clearWestCity();
      clearEastCity();
      clearDistance();
      clearAmountDesc();
      this.i = -1;
      return this;
    }
    
    public AcrossWestToEast clearAmountDesc()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public AcrossWestToEast clearDistance()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public AcrossWestToEast clearEastCity()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public AcrossWestToEast clearWestCity()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public String getAmountDesc()
    {
      return this.h;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public String getDistance()
    {
      return this.f;
    }
    
    public String getEastCity()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasWestCity()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getWestCity());
      }
      int j = k;
      if (hasEastCity()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getEastCity());
      }
      k = j;
      if (hasDistance()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getDistance());
      }
      j = k;
      if (hasAmountDesc()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getAmountDesc());
      }
      this.i = j;
      return j;
    }
    
    public String getWestCity()
    {
      return this.b;
    }
    
    public boolean hasAmountDesc()
    {
      return this.g;
    }
    
    public boolean hasDistance()
    {
      return this.e;
    }
    
    public boolean hasEastCity()
    {
      return this.c;
    }
    
    public boolean hasWestCity()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public AcrossWestToEast mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int j = paramCodedInputStreamMicro.readTag();
        switch (j)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setWestCity(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setEastCity(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setDistance(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setAmountDesc(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public AcrossWestToEast setAmountDesc(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public AcrossWestToEast setDistance(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public AcrossWestToEast setEastCity(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public AcrossWestToEast setWestCity(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasWestCity()) {
        paramCodedOutputStreamMicro.writeString(1, getWestCity());
      }
      if (hasEastCity()) {
        paramCodedOutputStreamMicro.writeString(2, getEastCity());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeString(3, getDistance());
      }
      if (hasAmountDesc()) {
        paramCodedOutputStreamMicro.writeString(4, getAmountDesc());
      }
    }
  }
  
  public static final class ArrivedCity
    extends MessageMicro
  {
    public static final int CITY_NAME_FIELD_NUMBER = 1;
    public static final int DATE_FIELD_NUMBER = 2;
    public static final int IS_HOMECITY_FIELD_NUMBER = 4;
    public static final int TIMES_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private int i = -1;
    
    public static ArrivedCity parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ArrivedCity().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ArrivedCity parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ArrivedCity)new ArrivedCity().mergeFrom(paramArrayOfByte);
    }
    
    public final ArrivedCity clear()
    {
      clearCityName();
      clearDate();
      clearTimes();
      clearIsHomecity();
      this.i = -1;
      return this;
    }
    
    public ArrivedCity clearCityName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public ArrivedCity clearDate()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public ArrivedCity clearIsHomecity()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public ArrivedCity clearTimes()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public String getCityName()
    {
      return this.b;
    }
    
    public int getDate()
    {
      return this.d;
    }
    
    public int getIsHomecity()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasCityName()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getCityName());
      }
      int j = k;
      if (hasDate()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(2, getDate());
      }
      k = j;
      if (hasTimes()) {
        k = j + CodedOutputStreamMicro.computeInt32Size(3, getTimes());
      }
      j = k;
      if (hasIsHomecity()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(4, getIsHomecity());
      }
      this.i = j;
      return j;
    }
    
    public int getTimes()
    {
      return this.f;
    }
    
    public boolean hasCityName()
    {
      return this.a;
    }
    
    public boolean hasDate()
    {
      return this.c;
    }
    
    public boolean hasIsHomecity()
    {
      return this.g;
    }
    
    public boolean hasTimes()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ArrivedCity mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int j = paramCodedInputStreamMicro.readTag();
        switch (j)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setCityName(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setDate(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setTimes(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setIsHomecity(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public ArrivedCity setCityName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public ArrivedCity setDate(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public ArrivedCity setIsHomecity(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public ArrivedCity setTimes(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCityName()) {
        paramCodedOutputStreamMicro.writeString(1, getCityName());
      }
      if (hasDate()) {
        paramCodedOutputStreamMicro.writeInt32(2, getDate());
      }
      if (hasTimes()) {
        paramCodedOutputStreamMicro.writeInt32(3, getTimes());
      }
      if (hasIsHomecity()) {
        paramCodedOutputStreamMicro.writeInt32(4, getIsHomecity());
      }
    }
  }
  
  public static final class HomecityDirstrict
    extends MessageMicro
  {
    public static final int DATE_FIELD_NUMBER = 2;
    public static final int DISTRICT_NAME_FIELD_NUMBER = 1;
    public static final int TIMES_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private int g = -1;
    
    public static HomecityDirstrict parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new HomecityDirstrict().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static HomecityDirstrict parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (HomecityDirstrict)new HomecityDirstrict().mergeFrom(paramArrayOfByte);
    }
    
    public final HomecityDirstrict clear()
    {
      clearDistrictName();
      clearDate();
      clearTimes();
      this.g = -1;
      return this;
    }
    
    public HomecityDirstrict clearDate()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public HomecityDirstrict clearDistrictName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public HomecityDirstrict clearTimes()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public int getDate()
    {
      return this.d;
    }
    
    public String getDistrictName()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasDistrictName()) {
        j = 0 + CodedOutputStreamMicro.computeStringSize(1, getDistrictName());
      }
      int i = j;
      if (hasDate()) {
        i = j + CodedOutputStreamMicro.computeInt32Size(2, getDate());
      }
      j = i;
      if (hasTimes()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getTimes());
      }
      this.g = j;
      return j;
    }
    
    public int getTimes()
    {
      return this.f;
    }
    
    public boolean hasDate()
    {
      return this.c;
    }
    
    public boolean hasDistrictName()
    {
      return this.a;
    }
    
    public boolean hasTimes()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public HomecityDirstrict mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setDistrictName(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setDate(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setTimes(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public HomecityDirstrict setDate(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public HomecityDirstrict setDistrictName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public HomecityDirstrict setTimes(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasDistrictName()) {
        paramCodedOutputStreamMicro.writeString(1, getDistrictName());
      }
      if (hasDate()) {
        paramCodedOutputStreamMicro.writeInt32(2, getDate());
      }
      if (hasTimes()) {
        paramCodedOutputStreamMicro.writeInt32(3, getTimes());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrackExplore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */