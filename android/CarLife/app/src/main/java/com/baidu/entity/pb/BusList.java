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

public final class BusList
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 3;
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int OPTION_FIELD_NUMBER = 2;
  private boolean a;
  private Option b = null;
  private List<Content> c = Collections.emptyList();
  private boolean d;
  private int e = 0;
  private int f = -1;
  
  public static BusList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new BusList().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static BusList parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (BusList)new BusList().mergeFrom(paramArrayOfByte);
  }
  
  public BusList addContent(Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramContent);
    return this;
  }
  
  public final BusList clear()
  {
    clearOption();
    clearContent();
    clearError();
    this.f = -1;
    return this;
  }
  
  public BusList clearContent()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public BusList clearError()
  {
    this.d = false;
    this.e = 0;
    return this;
  }
  
  public BusList clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.f < 0) {
      getSerializedSize();
    }
    return this.f;
  }
  
  public Content getContent(int paramInt)
  {
    return (Content)this.c.get(paramInt);
  }
  
  public int getContentCount()
  {
    return this.c.size();
  }
  
  public List<Content> getContentList()
  {
    return this.c;
  }
  
  public int getError()
  {
    return this.e;
  }
  
  public Option getOption()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasError()) {
      i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
    }
    int j = i;
    if (hasOption()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(2, getOption());
    }
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      j = CodedOutputStreamMicro.computeMessageSize(3, (Content)localIterator.next()) + j;
    }
    this.f = j;
    return j;
  }
  
  public boolean hasError()
  {
    return this.d;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public BusList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i = paramCodedInputStreamMicro.readTag();
      Object localObject;
      switch (i)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        setError(paramCodedInputStreamMicro.readInt32());
        break;
      case 18: 
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 26: 
        localObject = new Content();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addContent((Content)localObject);
      }
    }
  }
  
  public BusList setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.c.set(paramInt, paramContent);
    return this;
  }
  
  public BusList setError(int paramInt)
  {
    this.d = true;
    this.e = paramInt;
    return this;
  }
  
  public BusList setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.a = true;
    this.b = paramOption;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasError()) {
      paramCodedOutputStreamMicro.writeInt32(1, getError());
    }
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(2, getOption());
    }
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (Content)localIterator.next());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int ENDTIME_FIELD_NUMBER = 6;
    public static final int HAS_RTBUS_FIELD_NUMBER = 10;
    public static final int HEADWAY_FIELD_NUMBER = 13;
    public static final int ISMONTICKET_FIELD_NUMBER = 2;
    public static final int KINDTYPE_FIELD_NUMBER = 4;
    public static final int MAXPRICE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NEAREST_STATION_FIELD_NUMBER = 12;
    public static final int PRIMARY_UID_FIELD_NUMBER = 9;
    public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 11;
    public static final int STARTTIME_FIELD_NUMBER = 5;
    public static final int TICKETPRICE_FIELD_NUMBER = 7;
    public static final int UID_FIELD_NUMBER = 8;
    private int A = -1;
    private boolean a;
    private String b = "";
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private boolean m;
    private int n = 0;
    private boolean o;
    private String p = "";
    private boolean q;
    private String r = "";
    private boolean s;
    private int t = 0;
    private boolean u;
    private int v = 0;
    private boolean w;
    private NearestStation x = null;
    private boolean y;
    private String z = "";
    
    public static Content parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Content().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Content parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Content)new Content().mergeFrom(paramArrayOfByte);
    }
    
    public final Content clear()
    {
      clearName();
      clearIsMonTicket();
      clearMaxPrice();
      clearKindtype();
      clearStartTime();
      clearEndTime();
      clearTicketPrice();
      clearUid();
      clearPrimaryUid();
      clearHasRtbus();
      clearRtbusUpdateTime();
      clearNearestStation();
      clearHeadway();
      this.A = -1;
      return this;
    }
    
    public Content clearEndTime()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Content clearHasRtbus()
    {
      this.s = false;
      this.t = 0;
      return this;
    }
    
    public Content clearHeadway()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public Content clearIsMonTicket()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Content clearKindtype()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Content clearMaxPrice()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Content clearName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearNearestStation()
    {
      this.w = false;
      this.x = null;
      return this;
    }
    
    public Content clearPrimaryUid()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Content clearRtbusUpdateTime()
    {
      this.u = false;
      this.v = 0;
      return this;
    }
    
    public Content clearStartTime()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Content clearTicketPrice()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public Content clearUid()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.A < 0) {
        getSerializedSize();
      }
      return this.A;
    }
    
    public String getEndTime()
    {
      return this.l;
    }
    
    public int getHasRtbus()
    {
      return this.t;
    }
    
    public String getHeadway()
    {
      return this.z;
    }
    
    public int getIsMonTicket()
    {
      return this.d;
    }
    
    public int getKindtype()
    {
      return this.h;
    }
    
    public int getMaxPrice()
    {
      return this.f;
    }
    
    public String getName()
    {
      return this.b;
    }
    
    public NearestStation getNearestStation()
    {
      return this.x;
    }
    
    public String getPrimaryUid()
    {
      return this.r;
    }
    
    public int getRtbusUpdateTime()
    {
      return this.v;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasName()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
      }
      int i1 = i2;
      if (hasIsMonTicket()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getIsMonTicket());
      }
      i2 = i1;
      if (hasMaxPrice()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getMaxPrice());
      }
      i1 = i2;
      if (hasKindtype()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getKindtype());
      }
      i2 = i1;
      if (hasStartTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getStartTime());
      }
      i1 = i2;
      if (hasEndTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getEndTime());
      }
      i2 = i1;
      if (hasTicketPrice()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getTicketPrice());
      }
      i1 = i2;
      if (hasUid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getUid());
      }
      i2 = i1;
      if (hasPrimaryUid()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getPrimaryUid());
      }
      i1 = i2;
      if (hasHasRtbus()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getHasRtbus());
      }
      i2 = i1;
      if (hasRtbusUpdateTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getRtbusUpdateTime());
      }
      i1 = i2;
      if (hasNearestStation()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(12, getNearestStation());
      }
      i2 = i1;
      if (hasHeadway()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getHeadway());
      }
      this.A = i2;
      return i2;
    }
    
    public String getStartTime()
    {
      return this.j;
    }
    
    public int getTicketPrice()
    {
      return this.n;
    }
    
    public String getUid()
    {
      return this.p;
    }
    
    public boolean hasEndTime()
    {
      return this.k;
    }
    
    public boolean hasHasRtbus()
    {
      return this.s;
    }
    
    public boolean hasHeadway()
    {
      return this.y;
    }
    
    public boolean hasIsMonTicket()
    {
      return this.c;
    }
    
    public boolean hasKindtype()
    {
      return this.g;
    }
    
    public boolean hasMaxPrice()
    {
      return this.e;
    }
    
    public boolean hasName()
    {
      return this.a;
    }
    
    public boolean hasNearestStation()
    {
      return this.w;
    }
    
    public boolean hasPrimaryUid()
    {
      return this.q;
    }
    
    public boolean hasRtbusUpdateTime()
    {
      return this.u;
    }
    
    public boolean hasStartTime()
    {
      return this.i;
    }
    
    public boolean hasTicketPrice()
    {
      return this.m;
    }
    
    public boolean hasUid()
    {
      return this.o;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Content mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setIsMonTicket(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setMaxPrice(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setKindtype(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setStartTime(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setEndTime(paramCodedInputStreamMicro.readString());
          break;
        case 56: 
          setTicketPrice(paramCodedInputStreamMicro.readInt32());
          break;
        case 66: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setPrimaryUid(paramCodedInputStreamMicro.readString());
          break;
        case 80: 
          setHasRtbus(paramCodedInputStreamMicro.readInt32());
          break;
        case 88: 
          setRtbusUpdateTime(paramCodedInputStreamMicro.readInt32());
          break;
        case 98: 
          NearestStation localNearestStation = new NearestStation();
          paramCodedInputStreamMicro.readMessage(localNearestStation);
          setNearestStation(localNearestStation);
          break;
        case 106: 
          setHeadway(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Content setEndTime(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Content setHasRtbus(int paramInt)
    {
      this.s = true;
      this.t = paramInt;
      return this;
    }
    
    public Content setHeadway(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public Content setIsMonTicket(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Content setKindtype(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Content setMaxPrice(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Content setName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setNearestStation(NearestStation paramNearestStation)
    {
      if (paramNearestStation == null) {
        return clearNearestStation();
      }
      this.w = true;
      this.x = paramNearestStation;
      return this;
    }
    
    public Content setPrimaryUid(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Content setRtbusUpdateTime(int paramInt)
    {
      this.u = true;
      this.v = paramInt;
      return this;
    }
    
    public Content setStartTime(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Content setTicketPrice(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public Content setUid(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(1, getName());
      }
      if (hasIsMonTicket()) {
        paramCodedOutputStreamMicro.writeInt32(2, getIsMonTicket());
      }
      if (hasMaxPrice()) {
        paramCodedOutputStreamMicro.writeInt32(3, getMaxPrice());
      }
      if (hasKindtype()) {
        paramCodedOutputStreamMicro.writeInt32(4, getKindtype());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeString(5, getStartTime());
      }
      if (hasEndTime()) {
        paramCodedOutputStreamMicro.writeString(6, getEndTime());
      }
      if (hasTicketPrice()) {
        paramCodedOutputStreamMicro.writeInt32(7, getTicketPrice());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(8, getUid());
      }
      if (hasPrimaryUid()) {
        paramCodedOutputStreamMicro.writeString(9, getPrimaryUid());
      }
      if (hasHasRtbus()) {
        paramCodedOutputStreamMicro.writeInt32(10, getHasRtbus());
      }
      if (hasRtbusUpdateTime()) {
        paramCodedOutputStreamMicro.writeInt32(11, getRtbusUpdateTime());
      }
      if (hasNearestStation()) {
        paramCodedOutputStreamMicro.writeMessage(12, getNearestStation());
      }
      if (hasHeadway()) {
        paramCodedOutputStreamMicro.writeString(13, getHeadway());
      }
    }
    
    public static final class NearestStation
      extends MessageMicro
    {
      public static final int NAME_FIELD_NUMBER = 1;
      public static final int TIP_RTBUS_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static NearestStation parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new NearestStation().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static NearestStation parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (NearestStation)new NearestStation().mergeFrom(paramArrayOfByte);
      }
      
      public final NearestStation clear()
      {
        clearName();
        clearTipRtbus();
        this.e = -1;
        return this;
      }
      
      public NearestStation clearName()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public NearestStation clearTipRtbus()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.e < 0) {
          getSerializedSize();
        }
        return this.e;
      }
      
      public String getName()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasName()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
        }
        int j = i;
        if (hasTipRtbus()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getTipRtbus());
        }
        this.e = j;
        return j;
      }
      
      public String getTipRtbus()
      {
        return this.d;
      }
      
      public boolean hasName()
      {
        return this.a;
      }
      
      public boolean hasTipRtbus()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public NearestStation mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setTipRtbus(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public NearestStation setName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public NearestStation setTipRtbus(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasName()) {
          paramCodedOutputStreamMicro.writeString(1, getName());
        }
        if (hasTipRtbus()) {
          paramCodedOutputStreamMicro.writeString(2, getTipRtbus());
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int AREAID_FIELD_NUMBER = 4;
    public static final int COUNT_FIELD_NUMBER = 2;
    public static final int TOTAL_BUSLINE_NUM_FIELD_NUMBER = 3;
    public static final int TOTAL_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private int i = -1;
    
    public static Option parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Option().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Option parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Option)new Option().mergeFrom(paramArrayOfByte);
    }
    
    public final Option clear()
    {
      clearTotal();
      clearCount();
      clearTotalBuslineNum();
      clearAreaID();
      this.i = -1;
      return this;
    }
    
    public Option clearAreaID()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Option clearCount()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Option clearTotal()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Option clearTotalBuslineNum()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public int getAreaID()
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
    
    public int getCount()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasTotal()) {
        k = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
      }
      int j = k;
      if (hasCount()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(2, getCount());
      }
      k = j;
      if (hasTotalBuslineNum()) {
        k = j + CodedOutputStreamMicro.computeInt32Size(3, getTotalBuslineNum());
      }
      j = k;
      if (hasAreaID()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(4, getAreaID());
      }
      this.i = j;
      return j;
    }
    
    public int getTotal()
    {
      return this.b;
    }
    
    public int getTotalBuslineNum()
    {
      return this.f;
    }
    
    public boolean hasAreaID()
    {
      return this.g;
    }
    
    public boolean hasCount()
    {
      return this.c;
    }
    
    public boolean hasTotal()
    {
      return this.a;
    }
    
    public boolean hasTotalBuslineNum()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Option mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        case 8: 
          setTotal(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setCount(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setTotalBuslineNum(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setAreaID(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setAreaID(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Option setCount(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Option setTotal(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Option setTotalBuslineNum(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTotal()) {
        paramCodedOutputStreamMicro.writeInt32(1, getTotal());
      }
      if (hasCount()) {
        paramCodedOutputStreamMicro.writeInt32(2, getCount());
      }
      if (hasTotalBuslineNum()) {
        paramCodedOutputStreamMicro.writeInt32(3, getTotalBuslineNum());
      }
      if (hasAreaID()) {
        paramCodedOutputStreamMicro.writeInt32(4, getAreaID());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/BusList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */