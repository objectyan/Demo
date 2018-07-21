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

public final class Bsl
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 3;
  public static final int CURRENT_CITY_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private boolean c;
  private CurrentCity d = null;
  private List<Content> e = Collections.emptyList();
  private int f = -1;
  
  public static Bsl parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Bsl().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Bsl parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Bsl)new Bsl().mergeFrom(paramArrayOfByte);
  }
  
  public Bsl addContent(Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(paramContent);
    return this;
  }
  
  public final Bsl clear()
  {
    clearOption();
    clearCurrentCity();
    clearContent();
    this.f = -1;
    return this;
  }
  
  public Bsl clearContent()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public Bsl clearCurrentCity()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Bsl clearOption()
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
    return (Content)this.e.get(paramInt);
  }
  
  public int getContentCount()
  {
    return this.e.size();
  }
  
  public List<Content> getContentList()
  {
    return this.e;
  }
  
  public CurrentCity getCurrentCity()
  {
    return this.d;
  }
  
  public Option getOption()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasOption()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    int j = i;
    if (hasCurrentCity()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
    }
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      j = CodedOutputStreamMicro.computeMessageSize(3, (Content)localIterator.next()) + j;
    }
    this.f = j;
    return j;
  }
  
  public boolean hasCurrentCity()
  {
    return this.c;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Bsl mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 10: 
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 18: 
        localObject = new CurrentCity();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setCurrentCity((CurrentCity)localObject);
        break;
      case 26: 
        localObject = new Content();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addContent((Content)localObject);
      }
    }
  }
  
  public Bsl setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.e.set(paramInt, paramContent);
    return this;
  }
  
  public Bsl setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.c = true;
    this.d = paramCurrentCity;
    return this;
  }
  
  public Bsl setOption(Option paramOption)
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
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(1, getOption());
    }
    if (hasCurrentCity()) {
      paramCodedOutputStreamMicro.writeMessage(2, getCurrentCity());
    }
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (Content)localIterator.next());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int ENDTIME_FIELD_NUMBER = 9;
    public static final int GEO_FIELD_NUMBER = 2;
    public static final int HEADWAY_FIELD_NUMBER = 16;
    public static final int IMAGE_FIELD_NUMBER = 22;
    public static final int ISMONTICKET_FIELD_NUMBER = 3;
    public static final int IS_DISPLAY_FIELD_NUMBER = 4;
    public static final int KINDTYPE_FIELD_NUMBER = 6;
    public static final int LINE_DIRECTION_FIELD_NUMBER = 17;
    public static final int MAXPRICE_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NEAREST_STATION_IDX_FIELD_NUMBER = 13;
    public static final int PAIR_LINE_FIELD_NUMBER = 18;
    public static final int RTBUS_NU_FIELD_NUMBER = 14;
    public static final int RTBUS_UPDATE_INTERVAL_FIELD_NUMBER = 12;
    public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 11;
    public static final int RUN_STATE_FIELD_NUMBER = 23;
    public static final int STARTTIME_FIELD_NUMBER = 8;
    public static final int STATIONS_FIELD_NUMBER = 19;
    public static final int TICKETPRICE_FIELD_NUMBER = 10;
    public static final int TRI_RTBUS_TIP_FIELD_NUMBER = 15;
    public static final int UGCINFO_FIELD_NUMBER = 21;
    public static final int UID_FIELD_NUMBER = 20;
    public static final int WORKINGTIMEDESC_FIELD_NUMBER = 7;
    private int A = 0;
    private boolean B;
    private String C = "";
    private boolean D;
    private String E = "";
    private boolean F;
    private String G = "";
    private boolean H;
    private PairLine I = null;
    private List<Stations> J = Collections.emptyList();
    private boolean K;
    private String L = "";
    private List<UgcInfo> M = Collections.emptyList();
    private boolean N;
    private ByteStringMicro O = ByteStringMicro.EMPTY;
    private boolean P;
    private int Q = 0;
    private int R = -1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private boolean i;
    private int j = 0;
    private boolean k;
    private int l = 0;
    private List<String> m = Collections.emptyList();
    private boolean n;
    private String o = "";
    private boolean p;
    private String q = "";
    private boolean r;
    private int s = 0;
    private boolean t;
    private int u = 0;
    private boolean v;
    private int w = 0;
    private boolean x;
    private int y = 0;
    private boolean z;
    
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
    
    public Content addStations(Stations paramStations)
    {
      if (paramStations == null) {
        return this;
      }
      if (this.J.isEmpty()) {
        this.J = new ArrayList();
      }
      this.J.add(paramStations);
      return this;
    }
    
    public Content addUgcinfo(UgcInfo paramUgcInfo)
    {
      if (paramUgcInfo == null) {
        return this;
      }
      if (this.M.isEmpty()) {
        this.M = new ArrayList();
      }
      this.M.add(paramUgcInfo);
      return this;
    }
    
    public Content addWorkingTimeDesc(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.m.isEmpty()) {
        this.m = new ArrayList();
      }
      this.m.add(paramString);
      return this;
    }
    
    public final Content clear()
    {
      clearName();
      clearGeo();
      clearIsMonTicket();
      clearIsDisplay();
      clearMaxPrice();
      clearKindtype();
      clearWorkingTimeDesc();
      clearStartTime();
      clearEndTime();
      clearTicketPrice();
      clearRtbusUpdateTime();
      clearRtbusUpdateInterval();
      clearNearestStationIdx();
      clearRtbusNu();
      clearTriRtbusTip();
      clearHeadway();
      clearLineDirection();
      clearPairLine();
      clearStations();
      clearUid();
      clearUgcinfo();
      clearImage();
      clearRunState();
      this.R = -1;
      return this;
    }
    
    public Content clearEndTime()
    {
      this.p = false;
      this.q = "";
      return this;
    }
    
    public Content clearGeo()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Content clearHeadway()
    {
      this.D = false;
      this.E = "";
      return this;
    }
    
    public Content clearImage()
    {
      this.N = false;
      this.O = ByteStringMicro.EMPTY;
      return this;
    }
    
    public Content clearIsDisplay()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Content clearIsMonTicket()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Content clearKindtype()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public Content clearLineDirection()
    {
      this.F = false;
      this.G = "";
      return this;
    }
    
    public Content clearMaxPrice()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public Content clearName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearNearestStationIdx()
    {
      this.x = false;
      this.y = 0;
      return this;
    }
    
    public Content clearPairLine()
    {
      this.H = false;
      this.I = null;
      return this;
    }
    
    public Content clearRtbusNu()
    {
      this.z = false;
      this.A = 0;
      return this;
    }
    
    public Content clearRtbusUpdateInterval()
    {
      this.v = false;
      this.w = 0;
      return this;
    }
    
    public Content clearRtbusUpdateTime()
    {
      this.t = false;
      this.u = 0;
      return this;
    }
    
    public Content clearRunState()
    {
      this.P = false;
      this.Q = 0;
      return this;
    }
    
    public Content clearStartTime()
    {
      this.n = false;
      this.o = "";
      return this;
    }
    
    public Content clearStations()
    {
      this.J = Collections.emptyList();
      return this;
    }
    
    public Content clearTicketPrice()
    {
      this.r = false;
      this.s = 0;
      return this;
    }
    
    public Content clearTriRtbusTip()
    {
      this.B = false;
      this.C = "";
      return this;
    }
    
    public Content clearUgcinfo()
    {
      this.M = Collections.emptyList();
      return this;
    }
    
    public Content clearUid()
    {
      this.K = false;
      this.L = "";
      return this;
    }
    
    public Content clearWorkingTimeDesc()
    {
      this.m = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.R < 0) {
        getSerializedSize();
      }
      return this.R;
    }
    
    public String getEndTime()
    {
      return this.q;
    }
    
    public String getGeo()
    {
      return this.d;
    }
    
    public String getHeadway()
    {
      return this.E;
    }
    
    public ByteStringMicro getImage()
    {
      return this.O;
    }
    
    public int getIsDisplay()
    {
      return this.h;
    }
    
    public int getIsMonTicket()
    {
      return this.f;
    }
    
    public int getKindtype()
    {
      return this.l;
    }
    
    public String getLineDirection()
    {
      return this.G;
    }
    
    public int getMaxPrice()
    {
      return this.j;
    }
    
    public String getName()
    {
      return this.b;
    }
    
    public int getNearestStationIdx()
    {
      return this.y;
    }
    
    public PairLine getPairLine()
    {
      return this.I;
    }
    
    public int getRtbusNu()
    {
      return this.A;
    }
    
    public int getRtbusUpdateInterval()
    {
      return this.w;
    }
    
    public int getRtbusUpdateTime()
    {
      return this.u;
    }
    
    public int getRunState()
    {
      return this.Q;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasName()) {}
      for (int i2 = CodedOutputStreamMicro.computeStringSize(1, getName()) + 0;; i2 = 0)
      {
        int i1 = i2;
        if (hasGeo()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getGeo());
        }
        i2 = i1;
        if (hasIsMonTicket()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getIsMonTicket());
        }
        i1 = i2;
        if (hasIsDisplay()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getIsDisplay());
        }
        i2 = i1;
        if (hasMaxPrice()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getMaxPrice());
        }
        if (hasKindtype()) {}
        for (i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getKindtype());; i1 = i2)
        {
          Iterator localIterator = getWorkingTimeDescList().iterator();
          i2 = i3;
          while (localIterator.hasNext()) {
            i2 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
          }
          i2 = i1 + i2 + getWorkingTimeDescList().size() * 1;
          i1 = i2;
          if (hasStartTime()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getStartTime());
          }
          i2 = i1;
          if (hasEndTime()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getEndTime());
          }
          i1 = i2;
          if (hasTicketPrice()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getTicketPrice());
          }
          i2 = i1;
          if (hasRtbusUpdateTime()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getRtbusUpdateTime());
          }
          i1 = i2;
          if (hasRtbusUpdateInterval()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getRtbusUpdateInterval());
          }
          i2 = i1;
          if (hasNearestStationIdx()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(13, getNearestStationIdx());
          }
          i1 = i2;
          if (hasRtbusNu()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(14, getRtbusNu());
          }
          i2 = i1;
          if (hasTriRtbusTip()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getTriRtbusTip());
          }
          i1 = i2;
          if (hasHeadway()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getHeadway());
          }
          i2 = i1;
          if (hasLineDirection()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getLineDirection());
          }
          i1 = i2;
          if (hasPairLine()) {
            i1 = i2 + CodedOutputStreamMicro.computeMessageSize(18, getPairLine());
          }
          localIterator = getStationsList().iterator();
          while (localIterator.hasNext()) {
            i1 = CodedOutputStreamMicro.computeMessageSize(19, (Stations)localIterator.next()) + i1;
          }
          i2 = i1;
          if (hasUid()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(20, getUid());
          }
          localIterator = getUgcinfoList().iterator();
          while (localIterator.hasNext()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(21, (UgcInfo)localIterator.next());
          }
          i1 = i2;
          if (hasImage()) {
            i1 = i2 + CodedOutputStreamMicro.computeBytesSize(22, getImage());
          }
          i2 = i1;
          if (hasRunState()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(23, getRunState());
          }
          this.R = i2;
          return i2;
        }
      }
    }
    
    public String getStartTime()
    {
      return this.o;
    }
    
    public Stations getStations(int paramInt)
    {
      return (Stations)this.J.get(paramInt);
    }
    
    public int getStationsCount()
    {
      return this.J.size();
    }
    
    public List<Stations> getStationsList()
    {
      return this.J;
    }
    
    public int getTicketPrice()
    {
      return this.s;
    }
    
    public String getTriRtbusTip()
    {
      return this.C;
    }
    
    public UgcInfo getUgcinfo(int paramInt)
    {
      return (UgcInfo)this.M.get(paramInt);
    }
    
    public int getUgcinfoCount()
    {
      return this.M.size();
    }
    
    public List<UgcInfo> getUgcinfoList()
    {
      return this.M;
    }
    
    public String getUid()
    {
      return this.L;
    }
    
    public String getWorkingTimeDesc(int paramInt)
    {
      return (String)this.m.get(paramInt);
    }
    
    public int getWorkingTimeDescCount()
    {
      return this.m.size();
    }
    
    public List<String> getWorkingTimeDescList()
    {
      return this.m;
    }
    
    public boolean hasEndTime()
    {
      return this.p;
    }
    
    public boolean hasGeo()
    {
      return this.c;
    }
    
    public boolean hasHeadway()
    {
      return this.D;
    }
    
    public boolean hasImage()
    {
      return this.N;
    }
    
    public boolean hasIsDisplay()
    {
      return this.g;
    }
    
    public boolean hasIsMonTicket()
    {
      return this.e;
    }
    
    public boolean hasKindtype()
    {
      return this.k;
    }
    
    public boolean hasLineDirection()
    {
      return this.F;
    }
    
    public boolean hasMaxPrice()
    {
      return this.i;
    }
    
    public boolean hasName()
    {
      return this.a;
    }
    
    public boolean hasNearestStationIdx()
    {
      return this.x;
    }
    
    public boolean hasPairLine()
    {
      return this.H;
    }
    
    public boolean hasRtbusNu()
    {
      return this.z;
    }
    
    public boolean hasRtbusUpdateInterval()
    {
      return this.v;
    }
    
    public boolean hasRtbusUpdateTime()
    {
      return this.t;
    }
    
    public boolean hasRunState()
    {
      return this.P;
    }
    
    public boolean hasStartTime()
    {
      return this.n;
    }
    
    public boolean hasTicketPrice()
    {
      return this.r;
    }
    
    public boolean hasTriRtbusTip()
    {
      return this.B;
    }
    
    public boolean hasUid()
    {
      return this.K;
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
        Object localObject;
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
        case 18: 
          setGeo(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setIsMonTicket(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setIsDisplay(paramCodedInputStreamMicro.readInt32());
          break;
        case 40: 
          setMaxPrice(paramCodedInputStreamMicro.readInt32());
          break;
        case 48: 
          setKindtype(paramCodedInputStreamMicro.readInt32());
          break;
        case 58: 
          addWorkingTimeDesc(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setStartTime(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setEndTime(paramCodedInputStreamMicro.readString());
          break;
        case 80: 
          setTicketPrice(paramCodedInputStreamMicro.readInt32());
          break;
        case 88: 
          setRtbusUpdateTime(paramCodedInputStreamMicro.readInt32());
          break;
        case 96: 
          setRtbusUpdateInterval(paramCodedInputStreamMicro.readInt32());
          break;
        case 104: 
          setNearestStationIdx(paramCodedInputStreamMicro.readInt32());
          break;
        case 112: 
          setRtbusNu(paramCodedInputStreamMicro.readInt32());
          break;
        case 122: 
          setTriRtbusTip(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setHeadway(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          setLineDirection(paramCodedInputStreamMicro.readString());
          break;
        case 146: 
          localObject = new PairLine();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setPairLine((PairLine)localObject);
          break;
        case 154: 
          localObject = new Stations();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addStations((Stations)localObject);
          break;
        case 162: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 170: 
          localObject = new UgcInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addUgcinfo((UgcInfo)localObject);
          break;
        case 178: 
          setImage(paramCodedInputStreamMicro.readBytes());
          break;
        case 184: 
          setRunState(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Content setEndTime(String paramString)
    {
      this.p = true;
      this.q = paramString;
      return this;
    }
    
    public Content setGeo(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Content setHeadway(String paramString)
    {
      this.D = true;
      this.E = paramString;
      return this;
    }
    
    public Content setImage(ByteStringMicro paramByteStringMicro)
    {
      this.N = true;
      this.O = paramByteStringMicro;
      return this;
    }
    
    public Content setIsDisplay(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Content setIsMonTicket(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Content setKindtype(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public Content setLineDirection(String paramString)
    {
      this.F = true;
      this.G = paramString;
      return this;
    }
    
    public Content setMaxPrice(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public Content setName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setNearestStationIdx(int paramInt)
    {
      this.x = true;
      this.y = paramInt;
      return this;
    }
    
    public Content setPairLine(PairLine paramPairLine)
    {
      if (paramPairLine == null) {
        return clearPairLine();
      }
      this.H = true;
      this.I = paramPairLine;
      return this;
    }
    
    public Content setRtbusNu(int paramInt)
    {
      this.z = true;
      this.A = paramInt;
      return this;
    }
    
    public Content setRtbusUpdateInterval(int paramInt)
    {
      this.v = true;
      this.w = paramInt;
      return this;
    }
    
    public Content setRtbusUpdateTime(int paramInt)
    {
      this.t = true;
      this.u = paramInt;
      return this;
    }
    
    public Content setRunState(int paramInt)
    {
      this.P = true;
      this.Q = paramInt;
      return this;
    }
    
    public Content setStartTime(String paramString)
    {
      this.n = true;
      this.o = paramString;
      return this;
    }
    
    public Content setStations(int paramInt, Stations paramStations)
    {
      if (paramStations == null) {
        return this;
      }
      this.J.set(paramInt, paramStations);
      return this;
    }
    
    public Content setTicketPrice(int paramInt)
    {
      this.r = true;
      this.s = paramInt;
      return this;
    }
    
    public Content setTriRtbusTip(String paramString)
    {
      this.B = true;
      this.C = paramString;
      return this;
    }
    
    public Content setUgcinfo(int paramInt, UgcInfo paramUgcInfo)
    {
      if (paramUgcInfo == null) {
        return this;
      }
      this.M.set(paramInt, paramUgcInfo);
      return this;
    }
    
    public Content setUid(String paramString)
    {
      this.K = true;
      this.L = paramString;
      return this;
    }
    
    public Content setWorkingTimeDesc(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.m.set(paramInt, paramString);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(1, getName());
      }
      if (hasGeo()) {
        paramCodedOutputStreamMicro.writeString(2, getGeo());
      }
      if (hasIsMonTicket()) {
        paramCodedOutputStreamMicro.writeInt32(3, getIsMonTicket());
      }
      if (hasIsDisplay()) {
        paramCodedOutputStreamMicro.writeInt32(4, getIsDisplay());
      }
      if (hasMaxPrice()) {
        paramCodedOutputStreamMicro.writeInt32(5, getMaxPrice());
      }
      if (hasKindtype()) {
        paramCodedOutputStreamMicro.writeInt32(6, getKindtype());
      }
      Iterator localIterator = getWorkingTimeDescList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(7, (String)localIterator.next());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeString(8, getStartTime());
      }
      if (hasEndTime()) {
        paramCodedOutputStreamMicro.writeString(9, getEndTime());
      }
      if (hasTicketPrice()) {
        paramCodedOutputStreamMicro.writeInt32(10, getTicketPrice());
      }
      if (hasRtbusUpdateTime()) {
        paramCodedOutputStreamMicro.writeInt32(11, getRtbusUpdateTime());
      }
      if (hasRtbusUpdateInterval()) {
        paramCodedOutputStreamMicro.writeInt32(12, getRtbusUpdateInterval());
      }
      if (hasNearestStationIdx()) {
        paramCodedOutputStreamMicro.writeInt32(13, getNearestStationIdx());
      }
      if (hasRtbusNu()) {
        paramCodedOutputStreamMicro.writeInt32(14, getRtbusNu());
      }
      if (hasTriRtbusTip()) {
        paramCodedOutputStreamMicro.writeString(15, getTriRtbusTip());
      }
      if (hasHeadway()) {
        paramCodedOutputStreamMicro.writeString(16, getHeadway());
      }
      if (hasLineDirection()) {
        paramCodedOutputStreamMicro.writeString(17, getLineDirection());
      }
      if (hasPairLine()) {
        paramCodedOutputStreamMicro.writeMessage(18, getPairLine());
      }
      localIterator = getStationsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(19, (Stations)localIterator.next());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(20, getUid());
      }
      localIterator = getUgcinfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(21, (UgcInfo)localIterator.next());
      }
      if (hasImage()) {
        paramCodedOutputStreamMicro.writeBytes(22, getImage());
      }
      if (hasRunState()) {
        paramCodedOutputStreamMicro.writeInt32(23, getRunState());
      }
    }
    
    public static final class PairLine
      extends MessageMicro
    {
      public static final int DIRECTION_FIELD_NUMBER = 3;
      public static final int ENDTIME_FIELD_NUMBER = 5;
      public static final int KINDTYPE_FIELD_NUMBER = 6;
      public static final int NAME_FIELD_NUMBER = 1;
      public static final int STARTTIME_FIELD_NUMBER = 4;
      public static final int UID_FIELD_NUMBER = 2;
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
      private int l = 0;
      private int m = -1;
      
      public static PairLine parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new PairLine().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static PairLine parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (PairLine)new PairLine().mergeFrom(paramArrayOfByte);
      }
      
      public final PairLine clear()
      {
        clearName();
        clearUid();
        clearDirection();
        clearStartTime();
        clearEndTime();
        clearKindtype();
        this.m = -1;
        return this;
      }
      
      public PairLine clearDirection()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public PairLine clearEndTime()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public PairLine clearKindtype()
      {
        this.k = false;
        this.l = 0;
        return this;
      }
      
      public PairLine clearName()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public PairLine clearStartTime()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public PairLine clearUid()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.m < 0) {
          getSerializedSize();
        }
        return this.m;
      }
      
      public String getDirection()
      {
        return this.f;
      }
      
      public String getEndTime()
      {
        return this.j;
      }
      
      public int getKindtype()
      {
        return this.l;
      }
      
      public String getName()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i1 = 0;
        if (hasName()) {
          i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
        }
        int n = i1;
        if (hasUid()) {
          n = i1 + CodedOutputStreamMicro.computeStringSize(2, getUid());
        }
        i1 = n;
        if (hasDirection()) {
          i1 = n + CodedOutputStreamMicro.computeStringSize(3, getDirection());
        }
        n = i1;
        if (hasStartTime()) {
          n = i1 + CodedOutputStreamMicro.computeStringSize(4, getStartTime());
        }
        i1 = n;
        if (hasEndTime()) {
          i1 = n + CodedOutputStreamMicro.computeStringSize(5, getEndTime());
        }
        n = i1;
        if (hasKindtype()) {
          n = i1 + CodedOutputStreamMicro.computeInt32Size(6, getKindtype());
        }
        this.m = n;
        return n;
      }
      
      public String getStartTime()
      {
        return this.h;
      }
      
      public String getUid()
      {
        return this.d;
      }
      
      public boolean hasDirection()
      {
        return this.e;
      }
      
      public boolean hasEndTime()
      {
        return this.i;
      }
      
      public boolean hasKindtype()
      {
        return this.k;
      }
      
      public boolean hasName()
      {
        return this.a;
      }
      
      public boolean hasStartTime()
      {
        return this.g;
      }
      
      public boolean hasUid()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public PairLine mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int n = paramCodedInputStreamMicro.readTag();
          switch (n)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setDirection(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setStartTime(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setEndTime(paramCodedInputStreamMicro.readString());
            break;
          case 48: 
            setKindtype(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public PairLine setDirection(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public PairLine setEndTime(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public PairLine setKindtype(int paramInt)
      {
        this.k = true;
        this.l = paramInt;
        return this;
      }
      
      public PairLine setName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public PairLine setStartTime(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public PairLine setUid(String paramString)
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
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(2, getUid());
        }
        if (hasDirection()) {
          paramCodedOutputStreamMicro.writeString(3, getDirection());
        }
        if (hasStartTime()) {
          paramCodedOutputStreamMicro.writeString(4, getStartTime());
        }
        if (hasEndTime()) {
          paramCodedOutputStreamMicro.writeString(5, getEndTime());
        }
        if (hasKindtype()) {
          paramCodedOutputStreamMicro.writeInt32(6, getKindtype());
        }
      }
    }
    
    public static final class Stations
      extends MessageMicro
    {
      public static final int GEO_FIELD_NUMBER = 1;
      public static final int NAME_FIELD_NUMBER = 2;
      public static final int RT_INFO_FIELD_NUMBER = 5;
      public static final int SUBWAYS_FIELD_NUMBER = 4;
      public static final int TRI_RT_INFO_FIELD_NUMBER = 6;
      public static final int UID_FIELD_NUMBER = 3;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private List<Subways> g = Collections.emptyList();
      private boolean h;
      private RtInfo i = null;
      private boolean j;
      private TriRtInfo k = null;
      private int l = -1;
      
      public static Stations parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Stations().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Stations parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Stations)new Stations().mergeFrom(paramArrayOfByte);
      }
      
      public Stations addSubways(Subways paramSubways)
      {
        if (paramSubways == null) {
          return this;
        }
        if (this.g.isEmpty()) {
          this.g = new ArrayList();
        }
        this.g.add(paramSubways);
        return this;
      }
      
      public final Stations clear()
      {
        clearGeo();
        clearName();
        clearUid();
        clearSubways();
        clearRtInfo();
        clearTriRtInfo();
        this.l = -1;
        return this;
      }
      
      public Stations clearGeo()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Stations clearName()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Stations clearRtInfo()
      {
        this.h = false;
        this.i = null;
        return this;
      }
      
      public Stations clearSubways()
      {
        this.g = Collections.emptyList();
        return this;
      }
      
      public Stations clearTriRtInfo()
      {
        this.j = false;
        this.k = null;
        return this;
      }
      
      public Stations clearUid()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.l < 0) {
          getSerializedSize();
        }
        return this.l;
      }
      
      public String getGeo()
      {
        return this.b;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public RtInfo getRtInfo()
      {
        return this.i;
      }
      
      public int getSerializedSize()
      {
        int n = 0;
        if (hasGeo()) {
          n = 0 + CodedOutputStreamMicro.computeStringSize(1, getGeo());
        }
        int m = n;
        if (hasName()) {
          m = n + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        n = m;
        if (hasUid()) {
          n = m + CodedOutputStreamMicro.computeStringSize(3, getUid());
        }
        Iterator localIterator = getSubwaysList().iterator();
        while (localIterator.hasNext()) {
          n = CodedOutputStreamMicro.computeMessageSize(4, (Subways)localIterator.next()) + n;
        }
        m = n;
        if (hasRtInfo()) {
          m = n + CodedOutputStreamMicro.computeMessageSize(5, getRtInfo());
        }
        n = m;
        if (hasTriRtInfo()) {
          n = m + CodedOutputStreamMicro.computeMessageSize(6, getTriRtInfo());
        }
        this.l = n;
        return n;
      }
      
      public Subways getSubways(int paramInt)
      {
        return (Subways)this.g.get(paramInt);
      }
      
      public int getSubwaysCount()
      {
        return this.g.size();
      }
      
      public List<Subways> getSubwaysList()
      {
        return this.g;
      }
      
      public TriRtInfo getTriRtInfo()
      {
        return this.k;
      }
      
      public String getUid()
      {
        return this.f;
      }
      
      public boolean hasGeo()
      {
        return this.a;
      }
      
      public boolean hasName()
      {
        return this.c;
      }
      
      public boolean hasRtInfo()
      {
        return this.h;
      }
      
      public boolean hasTriRtInfo()
      {
        return this.j;
      }
      
      public boolean hasUid()
      {
        return this.e;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Stations mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int m = paramCodedInputStreamMicro.readTag();
          Object localObject;
          switch (m)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setGeo(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            localObject = new Subways();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addSubways((Subways)localObject);
            break;
          case 42: 
            localObject = new RtInfo();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setRtInfo((RtInfo)localObject);
            break;
          case 50: 
            localObject = new TriRtInfo();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setTriRtInfo((TriRtInfo)localObject);
          }
        }
      }
      
      public Stations setGeo(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Stations setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Stations setRtInfo(RtInfo paramRtInfo)
      {
        if (paramRtInfo == null) {
          return clearRtInfo();
        }
        this.h = true;
        this.i = paramRtInfo;
        return this;
      }
      
      public Stations setSubways(int paramInt, Subways paramSubways)
      {
        if (paramSubways == null) {
          return this;
        }
        this.g.set(paramInt, paramSubways);
        return this;
      }
      
      public Stations setTriRtInfo(TriRtInfo paramTriRtInfo)
      {
        if (paramTriRtInfo == null) {
          return clearTriRtInfo();
        }
        this.j = true;
        this.k = paramTriRtInfo;
        return this;
      }
      
      public Stations setUid(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasGeo()) {
          paramCodedOutputStreamMicro.writeString(1, getGeo());
        }
        if (hasName()) {
          paramCodedOutputStreamMicro.writeString(2, getName());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(3, getUid());
        }
        Iterator localIterator = getSubwaysList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(4, (Subways)localIterator.next());
        }
        if (hasRtInfo()) {
          paramCodedOutputStreamMicro.writeMessage(5, getRtInfo());
        }
        if (hasTriRtInfo()) {
          paramCodedOutputStreamMicro.writeMessage(6, getTriRtInfo());
        }
      }
      
      public static final class RtInfo
        extends MessageMicro
      {
        public static final int NEXT_VEHICLE_FIELD_NUMBER = 1;
        private boolean a;
        private NextVehicle b = null;
        private int c = -1;
        
        public static RtInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new RtInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static RtInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (RtInfo)new RtInfo().mergeFrom(paramArrayOfByte);
        }
        
        public final RtInfo clear()
        {
          clearNextVehicle();
          this.c = -1;
          return this;
        }
        
        public RtInfo clearNextVehicle()
        {
          this.a = false;
          this.b = null;
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.c < 0) {
            getSerializedSize();
          }
          return this.c;
        }
        
        public NextVehicle getNextVehicle()
        {
          return this.b;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasNextVehicle()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getNextVehicle());
          }
          this.c = i;
          return i;
        }
        
        public boolean hasNextVehicle()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public RtInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              NextVehicle localNextVehicle = new NextVehicle();
              paramCodedInputStreamMicro.readMessage(localNextVehicle);
              setNextVehicle(localNextVehicle);
            }
          }
        }
        
        public RtInfo setNextVehicle(NextVehicle paramNextVehicle)
        {
          if (paramNextVehicle == null) {
            return clearNextVehicle();
          }
          this.a = true;
          this.b = paramNextVehicle;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasNextVehicle()) {
            paramCodedOutputStreamMicro.writeMessage(1, getNextVehicle());
          }
        }
        
        public static final class NextVehicle
          extends MessageMicro
        {
          public static final int HAS_NEXT_VEHICLE_FIELD_NUMBER = 1;
          public static final int REMAIN_DIST_FIELD_NUMBER = 2;
          public static final int REMAIN_STOPS_FIELD_NUMBER = 3;
          public static final int REMAIN_TIME_FIELD_NUMBER = 4;
          public static final int TIMESTAMP_FIELD_NUMBER = 5;
          public static final int VEHICLE_X_FIELD_NUMBER = 6;
          public static final int VEHICLE_Y_FIELD_NUMBER = 7;
          private boolean a;
          private int b = 0;
          private boolean c;
          private int d = 0;
          private boolean e;
          private int f = 0;
          private boolean g;
          private int h = 0;
          private boolean i;
          private int j = 0;
          private boolean k;
          private double l = 0.0D;
          private boolean m;
          private double n = 0.0D;
          private int o = -1;
          
          public static NextVehicle parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new NextVehicle().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static NextVehicle parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (NextVehicle)new NextVehicle().mergeFrom(paramArrayOfByte);
          }
          
          public final NextVehicle clear()
          {
            clearHasNextVehicle();
            clearRemainDist();
            clearRemainStops();
            clearRemainTime();
            clearTimestamp();
            clearVehicleX();
            clearVehicleY();
            this.o = -1;
            return this;
          }
          
          public NextVehicle clearHasNextVehicle()
          {
            this.a = false;
            this.b = 0;
            return this;
          }
          
          public NextVehicle clearRemainDist()
          {
            this.c = false;
            this.d = 0;
            return this;
          }
          
          public NextVehicle clearRemainStops()
          {
            this.e = false;
            this.f = 0;
            return this;
          }
          
          public NextVehicle clearRemainTime()
          {
            this.g = false;
            this.h = 0;
            return this;
          }
          
          public NextVehicle clearTimestamp()
          {
            this.i = false;
            this.j = 0;
            return this;
          }
          
          public NextVehicle clearVehicleX()
          {
            this.k = false;
            this.l = 0.0D;
            return this;
          }
          
          public NextVehicle clearVehicleY()
          {
            this.m = false;
            this.n = 0.0D;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.o < 0) {
              getSerializedSize();
            }
            return this.o;
          }
          
          public int getHasNextVehicle()
          {
            return this.b;
          }
          
          public int getRemainDist()
          {
            return this.d;
          }
          
          public int getRemainStops()
          {
            return this.f;
          }
          
          public int getRemainTime()
          {
            return this.h;
          }
          
          public int getSerializedSize()
          {
            int i2 = 0;
            if (hasHasNextVehicle()) {
              i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getHasNextVehicle());
            }
            int i1 = i2;
            if (hasRemainDist()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getRemainDist());
            }
            i2 = i1;
            if (hasRemainStops()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getRemainStops());
            }
            i1 = i2;
            if (hasRemainTime()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getRemainTime());
            }
            i2 = i1;
            if (hasTimestamp()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getTimestamp());
            }
            i1 = i2;
            if (hasVehicleX()) {
              i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(6, getVehicleX());
            }
            i2 = i1;
            if (hasVehicleY()) {
              i2 = i1 + CodedOutputStreamMicro.computeDoubleSize(7, getVehicleY());
            }
            this.o = i2;
            return i2;
          }
          
          public int getTimestamp()
          {
            return this.j;
          }
          
          public double getVehicleX()
          {
            return this.l;
          }
          
          public double getVehicleY()
          {
            return this.n;
          }
          
          public boolean hasHasNextVehicle()
          {
            return this.a;
          }
          
          public boolean hasRemainDist()
          {
            return this.c;
          }
          
          public boolean hasRemainStops()
          {
            return this.e;
          }
          
          public boolean hasRemainTime()
          {
            return this.g;
          }
          
          public boolean hasTimestamp()
          {
            return this.i;
          }
          
          public boolean hasVehicleX()
          {
            return this.k;
          }
          
          public boolean hasVehicleY()
          {
            return this.m;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public NextVehicle mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setHasNextVehicle(paramCodedInputStreamMicro.readInt32());
                break;
              case 16: 
                setRemainDist(paramCodedInputStreamMicro.readInt32());
                break;
              case 24: 
                setRemainStops(paramCodedInputStreamMicro.readInt32());
                break;
              case 32: 
                setRemainTime(paramCodedInputStreamMicro.readInt32());
                break;
              case 40: 
                setTimestamp(paramCodedInputStreamMicro.readInt32());
                break;
              case 49: 
                setVehicleX(paramCodedInputStreamMicro.readDouble());
                break;
              case 57: 
                setVehicleY(paramCodedInputStreamMicro.readDouble());
              }
            }
          }
          
          public NextVehicle setHasNextVehicle(int paramInt)
          {
            this.a = true;
            this.b = paramInt;
            return this;
          }
          
          public NextVehicle setRemainDist(int paramInt)
          {
            this.c = true;
            this.d = paramInt;
            return this;
          }
          
          public NextVehicle setRemainStops(int paramInt)
          {
            this.e = true;
            this.f = paramInt;
            return this;
          }
          
          public NextVehicle setRemainTime(int paramInt)
          {
            this.g = true;
            this.h = paramInt;
            return this;
          }
          
          public NextVehicle setTimestamp(int paramInt)
          {
            this.i = true;
            this.j = paramInt;
            return this;
          }
          
          public NextVehicle setVehicleX(double paramDouble)
          {
            this.k = true;
            this.l = paramDouble;
            return this;
          }
          
          public NextVehicle setVehicleY(double paramDouble)
          {
            this.m = true;
            this.n = paramDouble;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasHasNextVehicle()) {
              paramCodedOutputStreamMicro.writeInt32(1, getHasNextVehicle());
            }
            if (hasRemainDist()) {
              paramCodedOutputStreamMicro.writeInt32(2, getRemainDist());
            }
            if (hasRemainStops()) {
              paramCodedOutputStreamMicro.writeInt32(3, getRemainStops());
            }
            if (hasRemainTime()) {
              paramCodedOutputStreamMicro.writeInt32(4, getRemainTime());
            }
            if (hasTimestamp()) {
              paramCodedOutputStreamMicro.writeInt32(5, getTimestamp());
            }
            if (hasVehicleX()) {
              paramCodedOutputStreamMicro.writeDouble(6, getVehicleX());
            }
            if (hasVehicleY()) {
              paramCodedOutputStreamMicro.writeDouble(7, getVehicleY());
            }
          }
        }
      }
      
      public static final class Subways
        extends MessageMicro
      {
        public static final int BACKGROUND_COLOR_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private int e = -1;
        
        public static Subways parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Subways().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Subways parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Subways)new Subways().mergeFrom(paramArrayOfByte);
        }
        
        public final Subways clear()
        {
          clearName();
          clearBackgroundColor();
          this.e = -1;
          return this;
        }
        
        public Subways clearBackgroundColor()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public Subways clearName()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public String getBackgroundColor()
        {
          return this.d;
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
          if (hasBackgroundColor()) {
            j = i + CodedOutputStreamMicro.computeStringSize(2, getBackgroundColor());
          }
          this.e = j;
          return j;
        }
        
        public boolean hasBackgroundColor()
        {
          return this.c;
        }
        
        public boolean hasName()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Subways mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setBackgroundColor(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Subways setBackgroundColor(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public Subways setName(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(1, getName());
          }
          if (hasBackgroundColor()) {
            paramCodedOutputStreamMicro.writeString(2, getBackgroundColor());
          }
        }
      }
      
      public static final class TriRtInfo
        extends MessageMicro
      {
        public static final int VEHICLE_INFO_FIELD_NUMBER = 1;
        private List<VehicleInfo> a = Collections.emptyList();
        private int b = -1;
        
        public static TriRtInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new TriRtInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static TriRtInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (TriRtInfo)new TriRtInfo().mergeFrom(paramArrayOfByte);
        }
        
        public TriRtInfo addVehicleInfo(VehicleInfo paramVehicleInfo)
        {
          if (paramVehicleInfo == null) {
            return this;
          }
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(paramVehicleInfo);
          return this;
        }
        
        public final TriRtInfo clear()
        {
          clearVehicleInfo();
          this.b = -1;
          return this;
        }
        
        public TriRtInfo clearVehicleInfo()
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
        
        public int getSerializedSize()
        {
          Iterator localIterator = getVehicleInfoList().iterator();
          for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (VehicleInfo)localIterator.next()) + i) {}
          this.b = i;
          return i;
        }
        
        public VehicleInfo getVehicleInfo(int paramInt)
        {
          return (VehicleInfo)this.a.get(paramInt);
        }
        
        public int getVehicleInfoCount()
        {
          return this.a.size();
        }
        
        public List<VehicleInfo> getVehicleInfoList()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public TriRtInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              VehicleInfo localVehicleInfo = new VehicleInfo();
              paramCodedInputStreamMicro.readMessage(localVehicleInfo);
              addVehicleInfo(localVehicleInfo);
            }
          }
        }
        
        public TriRtInfo setVehicleInfo(int paramInt, VehicleInfo paramVehicleInfo)
        {
          if (paramVehicleInfo == null) {
            return this;
          }
          this.a.set(paramInt, paramVehicleInfo);
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getVehicleInfoList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(1, (VehicleInfo)localIterator.next());
          }
        }
        
        public static final class VehicleInfo
          extends MessageMicro
        {
          public static final int REMAIN_DISTANCE_FIELD_NUMBER = 3;
          public static final int REMAIN_STOP_FIELD_NUMBER = 4;
          public static final int REMAIN_TIME_FIELD_NUMBER = 2;
          public static final int REMAIN_TIP_FIELD_NUMBER = 1;
          public static final int VEHICLE_X_FIELD_NUMBER = 5;
          public static final int VEHICLE_Y_FIELD_NUMBER = 6;
          private boolean a;
          private String b = "";
          private boolean c;
          private int d = 0;
          private boolean e;
          private int f = 0;
          private boolean g;
          private int h = 0;
          private boolean i;
          private double j = 0.0D;
          private boolean k;
          private double l = 0.0D;
          private int m = -1;
          
          public static VehicleInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new VehicleInfo().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static VehicleInfo parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (VehicleInfo)new VehicleInfo().mergeFrom(paramArrayOfByte);
          }
          
          public final VehicleInfo clear()
          {
            clearRemainTip();
            clearRemainTime();
            clearRemainDistance();
            clearRemainStop();
            clearVehicleX();
            clearVehicleY();
            this.m = -1;
            return this;
          }
          
          public VehicleInfo clearRemainDistance()
          {
            this.e = false;
            this.f = 0;
            return this;
          }
          
          public VehicleInfo clearRemainStop()
          {
            this.g = false;
            this.h = 0;
            return this;
          }
          
          public VehicleInfo clearRemainTime()
          {
            this.c = false;
            this.d = 0;
            return this;
          }
          
          public VehicleInfo clearRemainTip()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public VehicleInfo clearVehicleX()
          {
            this.i = false;
            this.j = 0.0D;
            return this;
          }
          
          public VehicleInfo clearVehicleY()
          {
            this.k = false;
            this.l = 0.0D;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.m < 0) {
              getSerializedSize();
            }
            return this.m;
          }
          
          public int getRemainDistance()
          {
            return this.f;
          }
          
          public int getRemainStop()
          {
            return this.h;
          }
          
          public int getRemainTime()
          {
            return this.d;
          }
          
          public String getRemainTip()
          {
            return this.b;
          }
          
          public int getSerializedSize()
          {
            int i1 = 0;
            if (hasRemainTip()) {
              i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getRemainTip());
            }
            int n = i1;
            if (hasRemainTime()) {
              n = i1 + CodedOutputStreamMicro.computeInt32Size(2, getRemainTime());
            }
            i1 = n;
            if (hasRemainDistance()) {
              i1 = n + CodedOutputStreamMicro.computeInt32Size(3, getRemainDistance());
            }
            n = i1;
            if (hasRemainStop()) {
              n = i1 + CodedOutputStreamMicro.computeInt32Size(4, getRemainStop());
            }
            i1 = n;
            if (hasVehicleX()) {
              i1 = n + CodedOutputStreamMicro.computeDoubleSize(5, getVehicleX());
            }
            n = i1;
            if (hasVehicleY()) {
              n = i1 + CodedOutputStreamMicro.computeDoubleSize(6, getVehicleY());
            }
            this.m = n;
            return n;
          }
          
          public double getVehicleX()
          {
            return this.j;
          }
          
          public double getVehicleY()
          {
            return this.l;
          }
          
          public boolean hasRemainDistance()
          {
            return this.e;
          }
          
          public boolean hasRemainStop()
          {
            return this.g;
          }
          
          public boolean hasRemainTime()
          {
            return this.c;
          }
          
          public boolean hasRemainTip()
          {
            return this.a;
          }
          
          public boolean hasVehicleX()
          {
            return this.i;
          }
          
          public boolean hasVehicleY()
          {
            return this.k;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public VehicleInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int n = paramCodedInputStreamMicro.readTag();
              switch (n)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
                break;
              case 0: 
                return this;
              case 10: 
                setRemainTip(paramCodedInputStreamMicro.readString());
                break;
              case 16: 
                setRemainTime(paramCodedInputStreamMicro.readInt32());
                break;
              case 24: 
                setRemainDistance(paramCodedInputStreamMicro.readInt32());
                break;
              case 32: 
                setRemainStop(paramCodedInputStreamMicro.readInt32());
                break;
              case 41: 
                setVehicleX(paramCodedInputStreamMicro.readDouble());
                break;
              case 49: 
                setVehicleY(paramCodedInputStreamMicro.readDouble());
              }
            }
          }
          
          public VehicleInfo setRemainDistance(int paramInt)
          {
            this.e = true;
            this.f = paramInt;
            return this;
          }
          
          public VehicleInfo setRemainStop(int paramInt)
          {
            this.g = true;
            this.h = paramInt;
            return this;
          }
          
          public VehicleInfo setRemainTime(int paramInt)
          {
            this.c = true;
            this.d = paramInt;
            return this;
          }
          
          public VehicleInfo setRemainTip(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public VehicleInfo setVehicleX(double paramDouble)
          {
            this.i = true;
            this.j = paramDouble;
            return this;
          }
          
          public VehicleInfo setVehicleY(double paramDouble)
          {
            this.k = true;
            this.l = paramDouble;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasRemainTip()) {
              paramCodedOutputStreamMicro.writeString(1, getRemainTip());
            }
            if (hasRemainTime()) {
              paramCodedOutputStreamMicro.writeInt32(2, getRemainTime());
            }
            if (hasRemainDistance()) {
              paramCodedOutputStreamMicro.writeInt32(3, getRemainDistance());
            }
            if (hasRemainStop()) {
              paramCodedOutputStreamMicro.writeInt32(4, getRemainStop());
            }
            if (hasVehicleX()) {
              paramCodedOutputStreamMicro.writeDouble(5, getVehicleX());
            }
            if (hasVehicleY()) {
              paramCodedOutputStreamMicro.writeDouble(6, getVehicleY());
            }
          }
        }
      }
    }
    
    public static final class UgcInfo
      extends MessageMicro
    {
      public static final int TIME_FIELD_NUMBER = 1;
      public static final int TYPE_FIELD_NUMBER = 2;
      public static final int USER_FIELD_NUMBER = 3;
      private boolean a;
      private String b = "";
      private boolean c;
      private int d = 0;
      private boolean e;
      private String f = "";
      private int g = -1;
      
      public static UgcInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new UgcInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static UgcInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (UgcInfo)new UgcInfo().mergeFrom(paramArrayOfByte);
      }
      
      public final UgcInfo clear()
      {
        clearTime();
        clearType();
        clearUser();
        this.g = -1;
        return this;
      }
      
      public UgcInfo clearTime()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public UgcInfo clearType()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public UgcInfo clearUser()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.g < 0) {
          getSerializedSize();
        }
        return this.g;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        if (hasTime()) {
          j = 0 + CodedOutputStreamMicro.computeStringSize(1, getTime());
        }
        int i = j;
        if (hasType()) {
          i = j + CodedOutputStreamMicro.computeInt32Size(2, getType());
        }
        j = i;
        if (hasUser()) {
          j = i + CodedOutputStreamMicro.computeStringSize(3, getUser());
        }
        this.g = j;
        return j;
      }
      
      public String getTime()
      {
        return this.b;
      }
      
      public int getType()
      {
        return this.d;
      }
      
      public String getUser()
      {
        return this.f;
      }
      
      public boolean hasTime()
      {
        return this.a;
      }
      
      public boolean hasType()
      {
        return this.c;
      }
      
      public boolean hasUser()
      {
        return this.e;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public UgcInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setTime(paramCodedInputStreamMicro.readString());
            break;
          case 16: 
            setType(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            setUser(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public UgcInfo setTime(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public UgcInfo setType(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public UgcInfo setUser(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasTime()) {
          paramCodedOutputStreamMicro.writeString(1, getTime());
        }
        if (hasType()) {
          paramCodedOutputStreamMicro.writeInt32(2, getType());
        }
        if (hasUser()) {
          paramCodedOutputStreamMicro.writeString(3, getUser());
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int COUNT_FIELD_NUMBER = 2;
    public static final int HAS_RTBUS_FIELD_NUMBER = 4;
    public static final int LINETYPE_FIELD_NUMBER = 5;
    public static final int RTINFO_SY_FIELD_NUMBER = 3;
    public static final int TIME_FIELD_NUMBER = 6;
    public static final int TOTAL_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private boolean i;
    private int j = 0;
    private boolean k;
    private int l = 0;
    private int m = -1;
    
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
      clearRtinfoSy();
      clearHasRtbus();
      clearLinetype();
      clearTime();
      this.m = -1;
      return this;
    }
    
    public Option clearCount()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Option clearHasRtbus()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Option clearLinetype()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public Option clearRtinfoSy()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Option clearTime()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public Option clearTotal()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public int getCount()
    {
      return this.d;
    }
    
    public int getHasRtbus()
    {
      return this.h;
    }
    
    public int getLinetype()
    {
      return this.j;
    }
    
    public int getRtinfoSy()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasTotal()) {
        i1 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
      }
      int n = i1;
      if (hasCount()) {
        n = i1 + CodedOutputStreamMicro.computeInt32Size(2, getCount());
      }
      i1 = n;
      if (hasRtinfoSy()) {
        i1 = n + CodedOutputStreamMicro.computeInt32Size(3, getRtinfoSy());
      }
      n = i1;
      if (hasHasRtbus()) {
        n = i1 + CodedOutputStreamMicro.computeInt32Size(4, getHasRtbus());
      }
      i1 = n;
      if (hasLinetype()) {
        i1 = n + CodedOutputStreamMicro.computeInt32Size(5, getLinetype());
      }
      n = i1;
      if (hasTime()) {
        n = i1 + CodedOutputStreamMicro.computeInt32Size(6, getTime());
      }
      this.m = n;
      return n;
    }
    
    public int getTime()
    {
      return this.l;
    }
    
    public int getTotal()
    {
      return this.b;
    }
    
    public boolean hasCount()
    {
      return this.c;
    }
    
    public boolean hasHasRtbus()
    {
      return this.g;
    }
    
    public boolean hasLinetype()
    {
      return this.i;
    }
    
    public boolean hasRtinfoSy()
    {
      return this.e;
    }
    
    public boolean hasTime()
    {
      return this.k;
    }
    
    public boolean hasTotal()
    {
      return this.a;
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
        int n = paramCodedInputStreamMicro.readTag();
        switch (n)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
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
          setRtinfoSy(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setHasRtbus(paramCodedInputStreamMicro.readInt32());
          break;
        case 40: 
          setLinetype(paramCodedInputStreamMicro.readInt32());
          break;
        case 48: 
          setTime(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setCount(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Option setHasRtbus(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Option setLinetype(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public Option setRtinfoSy(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Option setTime(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public Option setTotal(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
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
      if (hasRtinfoSy()) {
        paramCodedOutputStreamMicro.writeInt32(3, getRtinfoSy());
      }
      if (hasHasRtbus()) {
        paramCodedOutputStreamMicro.writeInt32(4, getHasRtbus());
      }
      if (hasLinetype()) {
        paramCodedOutputStreamMicro.writeInt32(5, getLinetype());
      }
      if (hasTime()) {
        paramCodedOutputStreamMicro.writeInt32(6, getTime());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Bsl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */