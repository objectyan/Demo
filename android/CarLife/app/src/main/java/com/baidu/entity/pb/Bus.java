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

public final class Bus
  extends MessageMicro
{
  public static final int CURRENT_CITY_FIELD_NUMBER = 2;
  public static final int CYCLE_FIELD_NUMBER = 9;
  public static final int EMERGENCY_TIP_FIELD_NUMBER = 6;
  public static final int OPTION_FIELD_NUMBER = 4;
  public static final int REDIS_KEY_FIELD_NUMBER = 7;
  public static final int ROUTES_FIELD_NUMBER = 3;
  public static final int TAXI_FIELD_NUMBER = 1;
  public static final int WALK_FIELD_NUMBER = 8;
  public static final int ZHUANCHE_FIELD_NUMBER = 5;
  private boolean a;
  private Taxi b = null;
  private boolean c;
  private CurrentCity d = null;
  private List<Routes> e = Collections.emptyList();
  private boolean f;
  private Option g = null;
  private boolean h;
  private Zhuanche i = null;
  private boolean j;
  private String k = "";
  private boolean l;
  private String m = "";
  private boolean n;
  private Walk o = null;
  private boolean p;
  private Cycle q = null;
  private int r = -1;
  
  public static Bus parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Bus().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Bus parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Bus)new Bus().mergeFrom(paramArrayOfByte);
  }
  
  public Bus addRoutes(Routes paramRoutes)
  {
    if (paramRoutes == null) {
      return this;
    }
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(paramRoutes);
    return this;
  }
  
  public final Bus clear()
  {
    clearTaxi();
    clearCurrentCity();
    clearRoutes();
    clearOption();
    clearZhuanche();
    clearEmergencyTip();
    clearRedisKey();
    clearWalk();
    clearCycle();
    this.r = -1;
    return this;
  }
  
  public Bus clearCurrentCity()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Bus clearCycle()
  {
    this.p = false;
    this.q = null;
    return this;
  }
  
  public Bus clearEmergencyTip()
  {
    this.j = false;
    this.k = "";
    return this;
  }
  
  public Bus clearOption()
  {
    this.f = false;
    this.g = null;
    return this;
  }
  
  public Bus clearRedisKey()
  {
    this.l = false;
    this.m = "";
    return this;
  }
  
  public Bus clearRoutes()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public Bus clearTaxi()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public Bus clearWalk()
  {
    this.n = false;
    this.o = null;
    return this;
  }
  
  public Bus clearZhuanche()
  {
    this.h = false;
    this.i = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.r < 0) {
      getSerializedSize();
    }
    return this.r;
  }
  
  public CurrentCity getCurrentCity()
  {
    return this.d;
  }
  
  public Cycle getCycle()
  {
    return this.q;
  }
  
  public String getEmergencyTip()
  {
    return this.k;
  }
  
  public Option getOption()
  {
    return this.g;
  }
  
  public String getRedisKey()
  {
    return this.m;
  }
  
  public Routes getRoutes(int paramInt)
  {
    return (Routes)this.e.get(paramInt);
  }
  
  public int getRoutesCount()
  {
    return this.e.size();
  }
  
  public List<Routes> getRoutesList()
  {
    return this.e;
  }
  
  public int getSerializedSize()
  {
    int i1 = 0;
    if (hasTaxi()) {
      i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTaxi());
    }
    int i2 = i1;
    if (hasCurrentCity()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
    }
    Iterator localIterator = getRoutesList().iterator();
    while (localIterator.hasNext()) {
      i2 = CodedOutputStreamMicro.computeMessageSize(3, (Routes)localIterator.next()) + i2;
    }
    i1 = i2;
    if (hasOption()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getOption());
    }
    i2 = i1;
    if (hasZhuanche()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getZhuanche());
    }
    i1 = i2;
    if (hasEmergencyTip()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getEmergencyTip());
    }
    i2 = i1;
    if (hasRedisKey()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getRedisKey());
    }
    i1 = i2;
    if (hasWalk()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getWalk());
    }
    i2 = i1;
    if (hasCycle()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(9, getCycle());
    }
    this.r = i2;
    return i2;
  }
  
  public Taxi getTaxi()
  {
    return this.b;
  }
  
  public Walk getWalk()
  {
    return this.o;
  }
  
  public Zhuanche getZhuanche()
  {
    return this.i;
  }
  
  public boolean hasCurrentCity()
  {
    return this.c;
  }
  
  public boolean hasCycle()
  {
    return this.p;
  }
  
  public boolean hasEmergencyTip()
  {
    return this.j;
  }
  
  public boolean hasOption()
  {
    return this.f;
  }
  
  public boolean hasRedisKey()
  {
    return this.l;
  }
  
  public boolean hasTaxi()
  {
    return this.a;
  }
  
  public boolean hasWalk()
  {
    return this.n;
  }
  
  public boolean hasZhuanche()
  {
    return this.h;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Bus mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Taxi();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setTaxi((Taxi)localObject);
        break;
      case 18: 
        localObject = new CurrentCity();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setCurrentCity((CurrentCity)localObject);
        break;
      case 26: 
        localObject = new Routes();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addRoutes((Routes)localObject);
        break;
      case 34: 
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 42: 
        localObject = new Zhuanche();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setZhuanche((Zhuanche)localObject);
        break;
      case 50: 
        setEmergencyTip(paramCodedInputStreamMicro.readString());
        break;
      case 58: 
        setRedisKey(paramCodedInputStreamMicro.readString());
        break;
      case 66: 
        localObject = new Walk();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setWalk((Walk)localObject);
        break;
      case 74: 
        localObject = new Cycle();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setCycle((Cycle)localObject);
      }
    }
  }
  
  public Bus setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.c = true;
    this.d = paramCurrentCity;
    return this;
  }
  
  public Bus setCycle(Cycle paramCycle)
  {
    if (paramCycle == null) {
      return clearCycle();
    }
    this.p = true;
    this.q = paramCycle;
    return this;
  }
  
  public Bus setEmergencyTip(String paramString)
  {
    this.j = true;
    this.k = paramString;
    return this;
  }
  
  public Bus setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.f = true;
    this.g = paramOption;
    return this;
  }
  
  public Bus setRedisKey(String paramString)
  {
    this.l = true;
    this.m = paramString;
    return this;
  }
  
  public Bus setRoutes(int paramInt, Routes paramRoutes)
  {
    if (paramRoutes == null) {
      return this;
    }
    this.e.set(paramInt, paramRoutes);
    return this;
  }
  
  public Bus setTaxi(Taxi paramTaxi)
  {
    if (paramTaxi == null) {
      return clearTaxi();
    }
    this.a = true;
    this.b = paramTaxi;
    return this;
  }
  
  public Bus setWalk(Walk paramWalk)
  {
    if (paramWalk == null) {
      return clearWalk();
    }
    this.n = true;
    this.o = paramWalk;
    return this;
  }
  
  public Bus setZhuanche(Zhuanche paramZhuanche)
  {
    if (paramZhuanche == null) {
      return clearZhuanche();
    }
    this.h = true;
    this.i = paramZhuanche;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasTaxi()) {
      paramCodedOutputStreamMicro.writeMessage(1, getTaxi());
    }
    if (hasCurrentCity()) {
      paramCodedOutputStreamMicro.writeMessage(2, getCurrentCity());
    }
    Iterator localIterator = getRoutesList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (Routes)localIterator.next());
    }
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(4, getOption());
    }
    if (hasZhuanche()) {
      paramCodedOutputStreamMicro.writeMessage(5, getZhuanche());
    }
    if (hasEmergencyTip()) {
      paramCodedOutputStreamMicro.writeString(6, getEmergencyTip());
    }
    if (hasRedisKey()) {
      paramCodedOutputStreamMicro.writeString(7, getRedisKey());
    }
    if (hasWalk()) {
      paramCodedOutputStreamMicro.writeMessage(8, getWalk());
    }
    if (hasCycle()) {
      paramCodedOutputStreamMicro.writeMessage(9, getCycle());
    }
  }
  
  public static final class Cycle
    extends MessageMicro
  {
    public static final int DISTANCE_FIELD_NUMBER = 3;
    public static final int IS_BETTER_FIELD_NUMBER = 1;
    public static final int TIME_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private int g = -1;
    
    public static Cycle parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Cycle().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Cycle parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Cycle)new Cycle().mergeFrom(paramArrayOfByte);
    }
    
    public final Cycle clear()
    {
      clearIsBetter();
      clearTime();
      clearDistance();
      this.g = -1;
      return this;
    }
    
    public Cycle clearDistance()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Cycle clearIsBetter()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Cycle clearTime()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public String getDistance()
    {
      return this.f;
    }
    
    public int getIsBetter()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasIsBetter()) {
        j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsBetter());
      }
      int i = j;
      if (hasTime()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getTime());
      }
      j = i;
      if (hasDistance()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getDistance());
      }
      this.g = j;
      return j;
    }
    
    public String getTime()
    {
      return this.d;
    }
    
    public boolean hasDistance()
    {
      return this.e;
    }
    
    public boolean hasIsBetter()
    {
      return this.a;
    }
    
    public boolean hasTime()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Cycle mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIsBetter(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setTime(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setDistance(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Cycle setDistance(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Cycle setIsBetter(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Cycle setTime(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsBetter()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIsBetter());
      }
      if (hasTime()) {
        paramCodedOutputStreamMicro.writeString(2, getTime());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeString(3, getDistance());
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int CITY_INFO_FIELD_NUMBER = 17;
    public static final int CSY_FIELD_NUMBER = 6;
    public static final int CTY_FIELD_NUMBER = 7;
    public static final int DATA_PROVIDER_FIELD_NUMBER = 14;
    public static final int END_FIELD_NUMBER = 5;
    public static final int EXPTIME_FIELD_NUMBER = 2;
    public static final int FY_FIELD_NUMBER = 11;
    public static final int IC_START_FIELD_NUMBER = 13;
    public static final int INTER_CITY_FIELD_NUMBER = 8;
    public static final int PN_FIELD_NUMBER = 9;
    public static final int RN_FIELD_NUMBER = 10;
    public static final int RTBUS_UPDATE_INTERVAL_FIELD_NUMBER = 16;
    public static final int SESSION_IN_FIELD_NUMBER = 15;
    public static final int START_FIELD_NUMBER = 4;
    public static final int START_TIMES_FIELD_NUMBER = 12;
    public static final int SY_FIELD_NUMBER = 3;
    public static final int TOTAL_FIELD_NUMBER = 1;
    private boolean A;
    private String B = "";
    private boolean C;
    private int D = 0;
    private boolean E;
    private CityInfo F = null;
    private int G = -1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private boolean g;
    private Start h = null;
    private boolean i;
    private End j = null;
    private boolean k;
    private int l = 0;
    private boolean m;
    private int n = 0;
    private boolean o;
    private int p = 0;
    private boolean q;
    private int r = 0;
    private boolean s;
    private int t = 0;
    private boolean u;
    private int v = 0;
    private List<String> w = Collections.emptyList();
    private boolean x;
    private String y = "";
    private List<DataProvider> z = Collections.emptyList();
    
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
    
    public Option addDataProvider(DataProvider paramDataProvider)
    {
      if (paramDataProvider == null) {
        return this;
      }
      if (this.z.isEmpty()) {
        this.z = new ArrayList();
      }
      this.z.add(paramDataProvider);
      return this;
    }
    
    public Option addStartTimes(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.w.isEmpty()) {
        this.w = new ArrayList();
      }
      this.w.add(paramString);
      return this;
    }
    
    public final Option clear()
    {
      clearTotal();
      clearExptime();
      clearSy();
      clearStart();
      clearEnd();
      clearCsy();
      clearCty();
      clearInterCity();
      clearPn();
      clearRn();
      clearFy();
      clearStartTimes();
      clearIcStart();
      clearDataProvider();
      clearSessionIn();
      clearRtbusUpdateInterval();
      clearCityInfo();
      this.G = -1;
      return this;
    }
    
    public Option clearCityInfo()
    {
      this.E = false;
      this.F = null;
      return this;
    }
    
    public Option clearCsy()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public Option clearCty()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public Option clearDataProvider()
    {
      this.z = Collections.emptyList();
      return this;
    }
    
    public Option clearEnd()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public Option clearExptime()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Option clearFy()
    {
      this.u = false;
      this.v = 0;
      return this;
    }
    
    public Option clearIcStart()
    {
      this.x = false;
      this.y = "";
      return this;
    }
    
    public Option clearInterCity()
    {
      this.o = false;
      this.p = 0;
      return this;
    }
    
    public Option clearPn()
    {
      this.q = false;
      this.r = 0;
      return this;
    }
    
    public Option clearRn()
    {
      this.s = false;
      this.t = 0;
      return this;
    }
    
    public Option clearRtbusUpdateInterval()
    {
      this.C = false;
      this.D = 0;
      return this;
    }
    
    public Option clearSessionIn()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public Option clearStart()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public Option clearStartTimes()
    {
      this.w = Collections.emptyList();
      return this;
    }
    
    public Option clearSy()
    {
      this.e = false;
      this.f = 0;
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
      if (this.G < 0) {
        getSerializedSize();
      }
      return this.G;
    }
    
    public CityInfo getCityInfo()
    {
      return this.F;
    }
    
    public int getCsy()
    {
      return this.l;
    }
    
    public int getCty()
    {
      return this.n;
    }
    
    public DataProvider getDataProvider(int paramInt)
    {
      return (DataProvider)this.z.get(paramInt);
    }
    
    public int getDataProviderCount()
    {
      return this.z.size();
    }
    
    public List<DataProvider> getDataProviderList()
    {
      return this.z;
    }
    
    public End getEnd()
    {
      return this.j;
    }
    
    public String getExptime()
    {
      return this.d;
    }
    
    public int getFy()
    {
      return this.v;
    }
    
    public String getIcStart()
    {
      return this.y;
    }
    
    public int getInterCity()
    {
      return this.p;
    }
    
    public int getPn()
    {
      return this.r;
    }
    
    public int getRn()
    {
      return this.t;
    }
    
    public int getRtbusUpdateInterval()
    {
      return this.D;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasTotal()) {}
      for (int i2 = CodedOutputStreamMicro.computeInt32Size(1, getTotal()) + 0;; i2 = 0)
      {
        int i1 = i2;
        if (hasExptime()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getExptime());
        }
        i2 = i1;
        if (hasSy()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getSy());
        }
        i1 = i2;
        if (hasStart()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getStart());
        }
        i2 = i1;
        if (hasEnd()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getEnd());
        }
        i1 = i2;
        if (hasCsy()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getCsy());
        }
        i2 = i1;
        if (hasCty()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getCty());
        }
        i1 = i2;
        if (hasInterCity()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getInterCity());
        }
        i2 = i1;
        if (hasPn()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getPn());
        }
        i1 = i2;
        if (hasRn()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getRn());
        }
        if (hasFy()) {
          i1 += CodedOutputStreamMicro.computeInt32Size(11, getFy());
        }
        for (;;)
        {
          Iterator localIterator = getStartTimesList().iterator();
          i2 = i3;
          while (localIterator.hasNext()) {
            i2 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
          }
          i2 = i1 + i2 + getStartTimesList().size() * 1;
          i1 = i2;
          if (hasIcStart()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(13, getIcStart());
          }
          localIterator = getDataProviderList().iterator();
          for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(14, (DataProvider)localIterator.next()) + i2) {}
          i1 = i2;
          if (hasSessionIn()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(15, getSessionIn());
          }
          i2 = i1;
          if (hasRtbusUpdateInterval()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(16, getRtbusUpdateInterval());
          }
          i1 = i2;
          if (hasCityInfo()) {
            i1 = i2 + CodedOutputStreamMicro.computeMessageSize(17, getCityInfo());
          }
          this.G = i1;
          return i1;
        }
      }
    }
    
    public String getSessionIn()
    {
      return this.B;
    }
    
    public Start getStart()
    {
      return this.h;
    }
    
    public String getStartTimes(int paramInt)
    {
      return (String)this.w.get(paramInt);
    }
    
    public int getStartTimesCount()
    {
      return this.w.size();
    }
    
    public List<String> getStartTimesList()
    {
      return this.w;
    }
    
    public int getSy()
    {
      return this.f;
    }
    
    public int getTotal()
    {
      return this.b;
    }
    
    public boolean hasCityInfo()
    {
      return this.E;
    }
    
    public boolean hasCsy()
    {
      return this.k;
    }
    
    public boolean hasCty()
    {
      return this.m;
    }
    
    public boolean hasEnd()
    {
      return this.i;
    }
    
    public boolean hasExptime()
    {
      return this.c;
    }
    
    public boolean hasFy()
    {
      return this.u;
    }
    
    public boolean hasIcStart()
    {
      return this.x;
    }
    
    public boolean hasInterCity()
    {
      return this.o;
    }
    
    public boolean hasPn()
    {
      return this.q;
    }
    
    public boolean hasRn()
    {
      return this.s;
    }
    
    public boolean hasRtbusUpdateInterval()
    {
      return this.C;
    }
    
    public boolean hasSessionIn()
    {
      return this.A;
    }
    
    public boolean hasStart()
    {
      return this.g;
    }
    
    public boolean hasSy()
    {
      return this.e;
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
          setTotal(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setExptime(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setSy(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          localObject = new Start();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setStart((Start)localObject);
          break;
        case 42: 
          localObject = new End();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setEnd((End)localObject);
          break;
        case 48: 
          setCsy(paramCodedInputStreamMicro.readInt32());
          break;
        case 56: 
          setCty(paramCodedInputStreamMicro.readInt32());
          break;
        case 64: 
          setInterCity(paramCodedInputStreamMicro.readInt32());
          break;
        case 72: 
          setPn(paramCodedInputStreamMicro.readInt32());
          break;
        case 80: 
          setRn(paramCodedInputStreamMicro.readInt32());
          break;
        case 88: 
          setFy(paramCodedInputStreamMicro.readInt32());
          break;
        case 98: 
          addStartTimes(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setIcStart(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          localObject = new DataProvider();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addDataProvider((DataProvider)localObject);
          break;
        case 122: 
          setSessionIn(paramCodedInputStreamMicro.readString());
          break;
        case 128: 
          setRtbusUpdateInterval(paramCodedInputStreamMicro.readInt32());
          break;
        case 138: 
          localObject = new CityInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCityInfo((CityInfo)localObject);
        }
      }
    }
    
    public Option setCityInfo(CityInfo paramCityInfo)
    {
      if (paramCityInfo == null) {
        return clearCityInfo();
      }
      this.E = true;
      this.F = paramCityInfo;
      return this;
    }
    
    public Option setCsy(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public Option setCty(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public Option setDataProvider(int paramInt, DataProvider paramDataProvider)
    {
      if (paramDataProvider == null) {
        return this;
      }
      this.z.set(paramInt, paramDataProvider);
      return this;
    }
    
    public Option setEnd(End paramEnd)
    {
      if (paramEnd == null) {
        return clearEnd();
      }
      this.i = true;
      this.j = paramEnd;
      return this;
    }
    
    public Option setExptime(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Option setFy(int paramInt)
    {
      this.u = true;
      this.v = paramInt;
      return this;
    }
    
    public Option setIcStart(String paramString)
    {
      this.x = true;
      this.y = paramString;
      return this;
    }
    
    public Option setInterCity(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public Option setPn(int paramInt)
    {
      this.q = true;
      this.r = paramInt;
      return this;
    }
    
    public Option setRn(int paramInt)
    {
      this.s = true;
      this.t = paramInt;
      return this;
    }
    
    public Option setRtbusUpdateInterval(int paramInt)
    {
      this.C = true;
      this.D = paramInt;
      return this;
    }
    
    public Option setSessionIn(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public Option setStart(Start paramStart)
    {
      if (paramStart == null) {
        return clearStart();
      }
      this.g = true;
      this.h = paramStart;
      return this;
    }
    
    public Option setStartTimes(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.w.set(paramInt, paramString);
      return this;
    }
    
    public Option setSy(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
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
      if (hasExptime()) {
        paramCodedOutputStreamMicro.writeString(2, getExptime());
      }
      if (hasSy()) {
        paramCodedOutputStreamMicro.writeInt32(3, getSy());
      }
      if (hasStart()) {
        paramCodedOutputStreamMicro.writeMessage(4, getStart());
      }
      if (hasEnd()) {
        paramCodedOutputStreamMicro.writeMessage(5, getEnd());
      }
      if (hasCsy()) {
        paramCodedOutputStreamMicro.writeInt32(6, getCsy());
      }
      if (hasCty()) {
        paramCodedOutputStreamMicro.writeInt32(7, getCty());
      }
      if (hasInterCity()) {
        paramCodedOutputStreamMicro.writeInt32(8, getInterCity());
      }
      if (hasPn()) {
        paramCodedOutputStreamMicro.writeInt32(9, getPn());
      }
      if (hasRn()) {
        paramCodedOutputStreamMicro.writeInt32(10, getRn());
      }
      if (hasFy()) {
        paramCodedOutputStreamMicro.writeInt32(11, getFy());
      }
      Iterator localIterator = getStartTimesList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(12, (String)localIterator.next());
      }
      if (hasIcStart()) {
        paramCodedOutputStreamMicro.writeString(13, getIcStart());
      }
      localIterator = getDataProviderList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(14, (DataProvider)localIterator.next());
      }
      if (hasSessionIn()) {
        paramCodedOutputStreamMicro.writeString(15, getSessionIn());
      }
      if (hasRtbusUpdateInterval()) {
        paramCodedOutputStreamMicro.writeInt32(16, getRtbusUpdateInterval());
      }
      if (hasCityInfo()) {
        paramCodedOutputStreamMicro.writeMessage(17, getCityInfo());
      }
    }
    
    public static final class CityInfo
      extends MessageMicro
    {
      public static final int CITY_ID_FIELD_NUMBER = 1;
      public static final int SUP_CYCLE_FIELD_NUMBER = 4;
      public static final int SUP_RTBUS_FIELD_NUMBER = 3;
      public static final int SUP_SUBWAY_FIELD_NUMBER = 2;
      private boolean a;
      private int b = 0;
      private boolean c;
      private int d = 0;
      private boolean e;
      private int f = 0;
      private boolean g;
      private int h = 0;
      private int i = -1;
      
      public static CityInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new CityInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static CityInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (CityInfo)new CityInfo().mergeFrom(paramArrayOfByte);
      }
      
      public final CityInfo clear()
      {
        clearCityId();
        clearSupSubway();
        clearSupRtbus();
        clearSupCycle();
        this.i = -1;
        return this;
      }
      
      public CityInfo clearCityId()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public CityInfo clearSupCycle()
      {
        this.g = false;
        this.h = 0;
        return this;
      }
      
      public CityInfo clearSupRtbus()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public CityInfo clearSupSubway()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public int getCityId()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasCityId()) {
          k = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCityId());
        }
        int j = k;
        if (hasSupSubway()) {
          j = k + CodedOutputStreamMicro.computeInt32Size(2, getSupSubway());
        }
        k = j;
        if (hasSupRtbus()) {
          k = j + CodedOutputStreamMicro.computeInt32Size(3, getSupRtbus());
        }
        j = k;
        if (hasSupCycle()) {
          j = k + CodedOutputStreamMicro.computeInt32Size(4, getSupCycle());
        }
        this.i = j;
        return j;
      }
      
      public int getSupCycle()
      {
        return this.h;
      }
      
      public int getSupRtbus()
      {
        return this.f;
      }
      
      public int getSupSubway()
      {
        return this.d;
      }
      
      public boolean hasCityId()
      {
        return this.a;
      }
      
      public boolean hasSupCycle()
      {
        return this.g;
      }
      
      public boolean hasSupRtbus()
      {
        return this.e;
      }
      
      public boolean hasSupSubway()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public CityInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setCityId(paramCodedInputStreamMicro.readInt32());
            break;
          case 16: 
            setSupSubway(paramCodedInputStreamMicro.readInt32());
            break;
          case 24: 
            setSupRtbus(paramCodedInputStreamMicro.readInt32());
            break;
          case 32: 
            setSupCycle(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public CityInfo setCityId(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public CityInfo setSupCycle(int paramInt)
      {
        this.g = true;
        this.h = paramInt;
        return this;
      }
      
      public CityInfo setSupRtbus(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public CityInfo setSupSubway(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasCityId()) {
          paramCodedOutputStreamMicro.writeInt32(1, getCityId());
        }
        if (hasSupSubway()) {
          paramCodedOutputStreamMicro.writeInt32(2, getSupSubway());
        }
        if (hasSupRtbus()) {
          paramCodedOutputStreamMicro.writeInt32(3, getSupRtbus());
        }
        if (hasSupCycle()) {
          paramCodedOutputStreamMicro.writeInt32(4, getSupCycle());
        }
      }
    }
    
    public static final class DataProvider
      extends MessageMicro
    {
      public static final int NAME_FIELD_NUMBER = 1;
      public static final int TEL_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static DataProvider parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new DataProvider().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static DataProvider parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (DataProvider)new DataProvider().mergeFrom(paramArrayOfByte);
      }
      
      public final DataProvider clear()
      {
        clearName();
        clearTel();
        this.e = -1;
        return this;
      }
      
      public DataProvider clearName()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public DataProvider clearTel()
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
        if (hasTel()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getTel());
        }
        this.e = j;
        return j;
      }
      
      public String getTel()
      {
        return this.d;
      }
      
      public boolean hasName()
      {
        return this.a;
      }
      
      public boolean hasTel()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public DataProvider mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setTel(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public DataProvider setName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public DataProvider setTel(String paramString)
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
        if (hasTel()) {
          paramCodedOutputStreamMicro.writeString(2, getTel());
        }
      }
    }
    
    public static final class End
      extends MessageMicro
    {
      public static final int COUNTY_ID_FIELD_NUMBER = 6;
      public static final int PT_FIELD_NUMBER = 1;
      public static final int RGC_NAME_FIELD_NUMBER = 5;
      public static final int SPT_FIELD_NUMBER = 4;
      public static final int UID_FIELD_NUMBER = 3;
      public static final int WD_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private List<Integer> g = Collections.emptyList();
      private boolean h;
      private String i = "";
      private boolean j;
      private int k = 0;
      private int l = -1;
      
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
      
      public End addSpt(int paramInt)
      {
        if (this.g.isEmpty()) {
          this.g = new ArrayList();
        }
        this.g.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public final End clear()
      {
        clearPt();
        clearWd();
        clearUid();
        clearSpt();
        clearRgcName();
        clearCountyId();
        this.l = -1;
        return this;
      }
      
      public End clearCountyId()
      {
        this.j = false;
        this.k = 0;
        return this;
      }
      
      public End clearPt()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public End clearRgcName()
      {
        this.h = false;
        this.i = "";
        return this;
      }
      
      public End clearSpt()
      {
        this.g = Collections.emptyList();
        return this;
      }
      
      public End clearUid()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public End clearWd()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.l < 0) {
          getSerializedSize();
        }
        return this.l;
      }
      
      public int getCountyId()
      {
        return this.k;
      }
      
      public String getPt()
      {
        return this.b;
      }
      
      public String getRgcName()
      {
        return this.i;
      }
      
      public int getSerializedSize()
      {
        int i1 = 0;
        if (hasPt()) {}
        for (int m = CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0;; m = 0)
        {
          int n = m;
          if (hasWd()) {
            n = m + CodedOutputStreamMicro.computeStringSize(2, getWd());
          }
          if (hasUid()) {}
          for (m = n + CodedOutputStreamMicro.computeStringSize(3, getUid());; m = n)
          {
            Iterator localIterator = getSptList().iterator();
            n = i1;
            while (localIterator.hasNext()) {
              n += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            n = m + n + getSptList().size() * 1;
            m = n;
            if (hasRgcName()) {
              m = n + CodedOutputStreamMicro.computeStringSize(5, getRgcName());
            }
            n = m;
            if (hasCountyId()) {
              n = m + CodedOutputStreamMicro.computeInt32Size(6, getCountyId());
            }
            this.l = n;
            return n;
          }
        }
      }
      
      public int getSpt(int paramInt)
      {
        return ((Integer)this.g.get(paramInt)).intValue();
      }
      
      public int getSptCount()
      {
        return this.g.size();
      }
      
      public List<Integer> getSptList()
      {
        return this.g;
      }
      
      public String getUid()
      {
        return this.f;
      }
      
      public String getWd()
      {
        return this.d;
      }
      
      public boolean hasCountyId()
      {
        return this.j;
      }
      
      public boolean hasPt()
      {
        return this.a;
      }
      
      public boolean hasRgcName()
      {
        return this.h;
      }
      
      public boolean hasUid()
      {
        return this.e;
      }
      
      public boolean hasWd()
      {
        return this.c;
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
          int m = paramCodedInputStreamMicro.readTag();
          switch (m)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setPt(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setWd(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 32: 
            addSpt(paramCodedInputStreamMicro.readSInt32());
            break;
          case 42: 
            setRgcName(paramCodedInputStreamMicro.readString());
            break;
          case 48: 
            setCountyId(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public End setCountyId(int paramInt)
      {
        this.j = true;
        this.k = paramInt;
        return this;
      }
      
      public End setPt(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public End setRgcName(String paramString)
      {
        this.h = true;
        this.i = paramString;
        return this;
      }
      
      public End setSpt(int paramInt1, int paramInt2)
      {
        this.g.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public End setUid(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public End setWd(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasPt()) {
          paramCodedOutputStreamMicro.writeString(1, getPt());
        }
        if (hasWd()) {
          paramCodedOutputStreamMicro.writeString(2, getWd());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(3, getUid());
        }
        Iterator localIterator = getSptList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(4, ((Integer)localIterator.next()).intValue());
        }
        if (hasRgcName()) {
          paramCodedOutputStreamMicro.writeString(5, getRgcName());
        }
        if (hasCountyId()) {
          paramCodedOutputStreamMicro.writeInt32(6, getCountyId());
        }
      }
    }
    
    public static final class Start
      extends MessageMicro
    {
      public static final int PT_FIELD_NUMBER = 1;
      public static final int RGC_NAME_FIELD_NUMBER = 5;
      public static final int SPT_FIELD_NUMBER = 4;
      public static final int STATION_LIST_FIELD_NUMBER = 6;
      public static final int UID_FIELD_NUMBER = 3;
      public static final int WD_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private List<Integer> g = Collections.emptyList();
      private boolean h;
      private String i = "";
      private List<StationList> j = Collections.emptyList();
      private int k = -1;
      
      public static Start parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Start().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Start parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Start)new Start().mergeFrom(paramArrayOfByte);
      }
      
      public Start addSpt(int paramInt)
      {
        if (this.g.isEmpty()) {
          this.g = new ArrayList();
        }
        this.g.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Start addStationList(StationList paramStationList)
      {
        if (paramStationList == null) {
          return this;
        }
        if (this.j.isEmpty()) {
          this.j = new ArrayList();
        }
        this.j.add(paramStationList);
        return this;
      }
      
      public final Start clear()
      {
        clearPt();
        clearWd();
        clearUid();
        clearSpt();
        clearRgcName();
        clearStationList();
        this.k = -1;
        return this;
      }
      
      public Start clearPt()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Start clearRgcName()
      {
        this.h = false;
        this.i = "";
        return this;
      }
      
      public Start clearSpt()
      {
        this.g = Collections.emptyList();
        return this;
      }
      
      public Start clearStationList()
      {
        this.j = Collections.emptyList();
        return this;
      }
      
      public Start clearUid()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Start clearWd()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.k < 0) {
          getSerializedSize();
        }
        return this.k;
      }
      
      public String getPt()
      {
        return this.b;
      }
      
      public String getRgcName()
      {
        return this.i;
      }
      
      public int getSerializedSize()
      {
        int i1 = 0;
        if (hasPt()) {}
        for (int m = CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0;; m = 0)
        {
          int n = m;
          if (hasWd()) {
            n = m + CodedOutputStreamMicro.computeStringSize(2, getWd());
          }
          if (hasUid()) {}
          for (m = n + CodedOutputStreamMicro.computeStringSize(3, getUid());; m = n)
          {
            Iterator localIterator = getSptList().iterator();
            n = i1;
            while (localIterator.hasNext()) {
              n += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            n = m + n + getSptList().size() * 1;
            m = n;
            if (hasRgcName()) {
              m = n + CodedOutputStreamMicro.computeStringSize(5, getRgcName());
            }
            localIterator = getStationListList().iterator();
            while (localIterator.hasNext()) {
              m = CodedOutputStreamMicro.computeMessageSize(6, (StationList)localIterator.next()) + m;
            }
            this.k = m;
            return m;
          }
        }
      }
      
      public int getSpt(int paramInt)
      {
        return ((Integer)this.g.get(paramInt)).intValue();
      }
      
      public int getSptCount()
      {
        return this.g.size();
      }
      
      public List<Integer> getSptList()
      {
        return this.g;
      }
      
      public StationList getStationList(int paramInt)
      {
        return (StationList)this.j.get(paramInt);
      }
      
      public int getStationListCount()
      {
        return this.j.size();
      }
      
      public List<StationList> getStationListList()
      {
        return this.j;
      }
      
      public String getUid()
      {
        return this.f;
      }
      
      public String getWd()
      {
        return this.d;
      }
      
      public boolean hasPt()
      {
        return this.a;
      }
      
      public boolean hasRgcName()
      {
        return this.h;
      }
      
      public boolean hasUid()
      {
        return this.e;
      }
      
      public boolean hasWd()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Start mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int m = paramCodedInputStreamMicro.readTag();
          switch (m)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setPt(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setWd(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 32: 
            addSpt(paramCodedInputStreamMicro.readSInt32());
            break;
          case 42: 
            setRgcName(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            StationList localStationList = new StationList();
            paramCodedInputStreamMicro.readMessage(localStationList);
            addStationList(localStationList);
          }
        }
      }
      
      public Start setPt(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Start setRgcName(String paramString)
      {
        this.h = true;
        this.i = paramString;
        return this;
      }
      
      public Start setSpt(int paramInt1, int paramInt2)
      {
        this.g.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Start setStationList(int paramInt, StationList paramStationList)
      {
        if (paramStationList == null) {
          return this;
        }
        this.j.set(paramInt, paramStationList);
        return this;
      }
      
      public Start setUid(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Start setWd(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasPt()) {
          paramCodedOutputStreamMicro.writeString(1, getPt());
        }
        if (hasWd()) {
          paramCodedOutputStreamMicro.writeString(2, getWd());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(3, getUid());
        }
        Iterator localIterator = getSptList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(4, ((Integer)localIterator.next()).intValue());
        }
        if (hasRgcName()) {
          paramCodedOutputStreamMicro.writeString(5, getRgcName());
        }
        localIterator = getStationListList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(6, (StationList)localIterator.next());
        }
      }
      
      public static final class StationList
        extends MessageMicro
      {
        public static final int STATION_NAME_FIELD_NUMBER = 1;
        public static final int STATION_UID_FIELD_NUMBER = 2;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private int e = -1;
        
        public static StationList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new StationList().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static StationList parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (StationList)new StationList().mergeFrom(paramArrayOfByte);
        }
        
        public final StationList clear()
        {
          clearStationName();
          clearStationUid();
          this.e = -1;
          return this;
        }
        
        public StationList clearStationName()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public StationList clearStationUid()
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
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasStationName()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStationName());
          }
          int j = i;
          if (hasStationUid()) {
            j = i + CodedOutputStreamMicro.computeStringSize(2, getStationUid());
          }
          this.e = j;
          return j;
        }
        
        public String getStationName()
        {
          return this.b;
        }
        
        public String getStationUid()
        {
          return this.d;
        }
        
        public boolean hasStationName()
        {
          return this.a;
        }
        
        public boolean hasStationUid()
        {
          return this.c;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public StationList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setStationName(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setStationUid(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public StationList setStationName(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public StationList setStationUid(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasStationName()) {
            paramCodedOutputStreamMicro.writeString(1, getStationName());
          }
          if (hasStationUid()) {
            paramCodedOutputStreamMicro.writeString(2, getStationUid());
          }
        }
      }
    }
  }
  
  public static final class Routes
    extends MessageMicro
  {
    public static final int LEGS_FIELD_NUMBER = 1;
    private List<Legs> a = Collections.emptyList();
    private int b = -1;
    
    public static Routes parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Routes().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Routes parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Routes)new Routes().mergeFrom(paramArrayOfByte);
    }
    
    public Routes addLegs(Legs paramLegs)
    {
      if (paramLegs == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramLegs);
      return this;
    }
    
    public final Routes clear()
    {
      clearLegs();
      this.b = -1;
      return this;
    }
    
    public Routes clearLegs()
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
    
    public Legs getLegs(int paramInt)
    {
      return (Legs)this.a.get(paramInt);
    }
    
    public int getLegsCount()
    {
      return this.a.size();
    }
    
    public List<Legs> getLegsList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getLegsList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Legs)localIterator.next()) + i) {}
      this.b = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Routes mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          Legs localLegs = new Legs();
          paramCodedInputStreamMicro.readMessage(localLegs);
          addLegs(localLegs);
        }
      }
    }
    
    public Routes setLegs(int paramInt, Legs paramLegs)
    {
      if (paramLegs == null) {
        return this;
      }
      this.a.set(paramInt, paramLegs);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getLegsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Legs)localIterator.next());
      }
    }
    
    public static final class Legs
      extends MessageMicro
    {
      public static final int ARRIVE_TIME_FIELD_NUMBER = 8;
      public static final int COMFORT_FIELD_NUMBER = 29;
      public static final int DISCOUNT_FIELD_NUMBER = 17;
      public static final int DISTANCE_FIELD_NUMBER = 1;
      public static final int DURATION_FIELD_NUMBER = 2;
      public static final int END_ADDRESS_FIELD_NUMBER = 13;
      public static final int END_LOCATION_FIELD_NUMBER = 3;
      public static final int END_PANO_FIELD_NUMBER = 27;
      public static final int END_TIME_FIELD_NUMBER = 15;
      public static final int INSTRUCTIONS_FIELD_NUMBER = 18;
      public static final int LINE_PRICE_FIELD_NUMBER = 28;
      public static final int PLAN_STATUS_FIELD_NUMBER = 30;
      public static final int PLAN_TYPE_FIELD_NUMBER = 31;
      public static final int PRICE_FIELD_NUMBER = 16;
      public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 24;
      public static final int SEND_LOCATION_FIELD_NUMBER = 19;
      public static final int SSTART_LOCATION_FIELD_NUMBER = 20;
      public static final int START_ADDRESS_FIELD_NUMBER = 12;
      public static final int START_LOCATION_FIELD_NUMBER = 4;
      public static final int START_PANO_FIELD_NUMBER = 26;
      public static final int START_TIME_FIELD_NUMBER = 14;
      public static final int STEPS_FIELD_NUMBER = 11;
      public static final int TIP_BACKGROUND_FIELD_NUMBER = 7;
      public static final int TIP_FIELD_NUMBER = 5;
      public static final int TIP_LABEL_BACKGROUND_FIELD_NUMBER = 22;
      public static final int TIP_LABEL_FIELD_NUMBER = 21;
      public static final int TIP_LABEL_TEXT_FIELD_NUMBER = 32;
      public static final int TIP_RTBUS_FIELD_NUMBER = 23;
      public static final int TIP_TEXT_FIELD_NUMBER = 6;
      public static final int TRAFFIC_TYPE_FIELD_NUMBER = 25;
      private String A = "";
      private boolean B;
      private String C = "";
      private boolean D;
      private String E = "";
      private List<Integer> F = Collections.emptyList();
      private List<Integer> G = Collections.emptyList();
      private boolean H;
      private String I = "";
      private boolean J;
      private String K = "";
      private boolean L;
      private String M = "";
      private boolean N;
      private int O = 0;
      private boolean P;
      private int Q = 0;
      private boolean R;
      private StartPano S = null;
      private boolean T;
      private EndPano U = null;
      private List<LinePrice> V = Collections.emptyList();
      private boolean W;
      private String X = "";
      private boolean Y;
      private int Z = 0;
      private List<Steps> a = Collections.emptyList();
      private boolean aa;
      private int ab = 0;
      private boolean ac;
      private String ad = "";
      private int ae = -1;
      private boolean b;
      private int c = 0;
      private boolean d;
      private int e = 0;
      private boolean f;
      private String g = "";
      private boolean h;
      private String i = "";
      private boolean j;
      private int k = 0;
      private boolean l;
      private String m = "";
      private boolean n;
      private String o = "";
      private boolean p;
      private String q = "";
      private boolean r;
      private String s = "";
      private boolean t;
      private String u = "";
      private boolean v;
      private String w = "";
      private boolean x;
      private String y = "";
      private boolean z;
      
      public static Legs parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Legs().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Legs parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Legs)new Legs().mergeFrom(paramArrayOfByte);
      }
      
      public Legs addLinePrice(LinePrice paramLinePrice)
      {
        if (paramLinePrice == null) {
          return this;
        }
        if (this.V.isEmpty()) {
          this.V = new ArrayList();
        }
        this.V.add(paramLinePrice);
        return this;
      }
      
      public Legs addSendLocation(int paramInt)
      {
        if (this.F.isEmpty()) {
          this.F = new ArrayList();
        }
        this.F.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Legs addSstartLocation(int paramInt)
      {
        if (this.G.isEmpty()) {
          this.G = new ArrayList();
        }
        this.G.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Legs addSteps(Steps paramSteps)
      {
        if (paramSteps == null) {
          return this;
        }
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(paramSteps);
        return this;
      }
      
      public final Legs clear()
      {
        clearSteps();
        clearDistance();
        clearDuration();
        clearEndLocation();
        clearStartLocation();
        clearTip();
        clearTipText();
        clearTipBackground();
        clearArriveTime();
        clearStartAddress();
        clearEndAddress();
        clearStartTime();
        clearEndTime();
        clearPrice();
        clearDiscount();
        clearInstructions();
        clearSendLocation();
        clearSstartLocation();
        clearTipLabel();
        clearTipLabelBackground();
        clearTipRtbus();
        clearRtbusUpdateTime();
        clearTrafficType();
        clearStartPano();
        clearEndPano();
        clearLinePrice();
        clearComfort();
        clearPlanStatus();
        clearPlanType();
        clearTipLabelText();
        this.ae = -1;
        return this;
      }
      
      public Legs clearArriveTime()
      {
        this.p = false;
        this.q = "";
        return this;
      }
      
      public Legs clearComfort()
      {
        this.W = false;
        this.X = "";
        return this;
      }
      
      public Legs clearDiscount()
      {
        this.B = false;
        this.C = "";
        return this;
      }
      
      public Legs clearDistance()
      {
        this.b = false;
        this.c = 0;
        return this;
      }
      
      public Legs clearDuration()
      {
        this.d = false;
        this.e = 0;
        return this;
      }
      
      public Legs clearEndAddress()
      {
        this.t = false;
        this.u = "";
        return this;
      }
      
      public Legs clearEndLocation()
      {
        this.f = false;
        this.g = "";
        return this;
      }
      
      public Legs clearEndPano()
      {
        this.T = false;
        this.U = null;
        return this;
      }
      
      public Legs clearEndTime()
      {
        this.x = false;
        this.y = "";
        return this;
      }
      
      public Legs clearInstructions()
      {
        this.D = false;
        this.E = "";
        return this;
      }
      
      public Legs clearLinePrice()
      {
        this.V = Collections.emptyList();
        return this;
      }
      
      public Legs clearPlanStatus()
      {
        this.Y = false;
        this.Z = 0;
        return this;
      }
      
      public Legs clearPlanType()
      {
        this.aa = false;
        this.ab = 0;
        return this;
      }
      
      public Legs clearPrice()
      {
        this.z = false;
        this.A = "";
        return this;
      }
      
      public Legs clearRtbusUpdateTime()
      {
        this.N = false;
        this.O = 0;
        return this;
      }
      
      public Legs clearSendLocation()
      {
        this.F = Collections.emptyList();
        return this;
      }
      
      public Legs clearSstartLocation()
      {
        this.G = Collections.emptyList();
        return this;
      }
      
      public Legs clearStartAddress()
      {
        this.r = false;
        this.s = "";
        return this;
      }
      
      public Legs clearStartLocation()
      {
        this.h = false;
        this.i = "";
        return this;
      }
      
      public Legs clearStartPano()
      {
        this.R = false;
        this.S = null;
        return this;
      }
      
      public Legs clearStartTime()
      {
        this.v = false;
        this.w = "";
        return this;
      }
      
      public Legs clearSteps()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public Legs clearTip()
      {
        this.j = false;
        this.k = 0;
        return this;
      }
      
      public Legs clearTipBackground()
      {
        this.n = false;
        this.o = "";
        return this;
      }
      
      public Legs clearTipLabel()
      {
        this.H = false;
        this.I = "";
        return this;
      }
      
      public Legs clearTipLabelBackground()
      {
        this.J = false;
        this.K = "";
        return this;
      }
      
      public Legs clearTipLabelText()
      {
        this.ac = false;
        this.ad = "";
        return this;
      }
      
      public Legs clearTipRtbus()
      {
        this.L = false;
        this.M = "";
        return this;
      }
      
      public Legs clearTipText()
      {
        this.l = false;
        this.m = "";
        return this;
      }
      
      public Legs clearTrafficType()
      {
        this.P = false;
        this.Q = 0;
        return this;
      }
      
      public String getArriveTime()
      {
        return this.q;
      }
      
      public int getCachedSize()
      {
        if (this.ae < 0) {
          getSerializedSize();
        }
        return this.ae;
      }
      
      public String getComfort()
      {
        return this.X;
      }
      
      public String getDiscount()
      {
        return this.C;
      }
      
      public int getDistance()
      {
        return this.c;
      }
      
      public int getDuration()
      {
        return this.e;
      }
      
      public String getEndAddress()
      {
        return this.u;
      }
      
      public String getEndLocation()
      {
        return this.g;
      }
      
      public EndPano getEndPano()
      {
        return this.U;
      }
      
      public String getEndTime()
      {
        return this.y;
      }
      
      public String getInstructions()
      {
        return this.E;
      }
      
      public LinePrice getLinePrice(int paramInt)
      {
        return (LinePrice)this.V.get(paramInt);
      }
      
      public int getLinePriceCount()
      {
        return this.V.size();
      }
      
      public List<LinePrice> getLinePriceList()
      {
        return this.V;
      }
      
      public int getPlanStatus()
      {
        return this.Z;
      }
      
      public int getPlanType()
      {
        return this.ab;
      }
      
      public String getPrice()
      {
        return this.A;
      }
      
      public int getRtbusUpdateTime()
      {
        return this.O;
      }
      
      public int getSendLocation(int paramInt)
      {
        return ((Integer)this.F.get(paramInt)).intValue();
      }
      
      public int getSendLocationCount()
      {
        return this.F.size();
      }
      
      public List<Integer> getSendLocationList()
      {
        return this.F;
      }
      
      public int getSerializedSize()
      {
        int i3 = 0;
        if (hasDistance()) {}
        for (int i2 = CodedOutputStreamMicro.computeInt32Size(1, getDistance()) + 0;; i2 = 0)
        {
          int i1 = i2;
          if (hasDuration()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
          }
          i2 = i1;
          if (hasEndLocation()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getEndLocation());
          }
          i1 = i2;
          if (hasStartLocation()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getStartLocation());
          }
          i2 = i1;
          if (hasTip()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getTip());
          }
          i1 = i2;
          if (hasTipText()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getTipText());
          }
          i2 = i1;
          if (hasTipBackground()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getTipBackground());
          }
          i1 = i2;
          if (hasArriveTime()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getArriveTime());
          }
          Iterator localIterator = getStepsList().iterator();
          for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(11, (Steps)localIterator.next()) + i2) {}
          i1 = i2;
          if (hasStartAddress()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getStartAddress());
          }
          i2 = i1;
          if (hasEndAddress()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getEndAddress());
          }
          i1 = i2;
          if (hasStartTime()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getStartTime());
          }
          i2 = i1;
          if (hasEndTime()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getEndTime());
          }
          i1 = i2;
          if (hasPrice()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getPrice());
          }
          i2 = i1;
          if (hasDiscount()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getDiscount());
          }
          i1 = i2;
          if (hasInstructions()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getInstructions());
          }
          localIterator = getSendLocationList().iterator();
          for (i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i2) {}
          int i4 = getSendLocationList().size();
          localIterator = getSstartLocationList().iterator();
          while (localIterator.hasNext()) {
            i3 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
          }
          i2 = i4 * 2 + (i1 + i2) + i3 + getSstartLocationList().size() * 2;
          i1 = i2;
          if (hasTipLabel()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(21, getTipLabel());
          }
          i2 = i1;
          if (hasTipLabelBackground()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(22, getTipLabelBackground());
          }
          i1 = i2;
          if (hasTipRtbus()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(23, getTipRtbus());
          }
          i2 = i1;
          if (hasRtbusUpdateTime()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(24, getRtbusUpdateTime());
          }
          i1 = i2;
          if (hasTrafficType()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(25, getTrafficType());
          }
          i2 = i1;
          if (hasStartPano()) {
            i2 = i1 + CodedOutputStreamMicro.computeMessageSize(26, getStartPano());
          }
          i1 = i2;
          if (hasEndPano()) {
            i1 = i2 + CodedOutputStreamMicro.computeMessageSize(27, getEndPano());
          }
          localIterator = getLinePriceList().iterator();
          for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(28, (LinePrice)localIterator.next()) + i2) {}
          i1 = i2;
          if (hasComfort()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(29, getComfort());
          }
          i2 = i1;
          if (hasPlanStatus()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(30, getPlanStatus());
          }
          i1 = i2;
          if (hasPlanType()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(31, getPlanType());
          }
          i2 = i1;
          if (hasTipLabelText()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(32, getTipLabelText());
          }
          this.ae = i2;
          return i2;
        }
      }
      
      public int getSstartLocation(int paramInt)
      {
        return ((Integer)this.G.get(paramInt)).intValue();
      }
      
      public int getSstartLocationCount()
      {
        return this.G.size();
      }
      
      public List<Integer> getSstartLocationList()
      {
        return this.G;
      }
      
      public String getStartAddress()
      {
        return this.s;
      }
      
      public String getStartLocation()
      {
        return this.i;
      }
      
      public StartPano getStartPano()
      {
        return this.S;
      }
      
      public String getStartTime()
      {
        return this.w;
      }
      
      public Steps getSteps(int paramInt)
      {
        return (Steps)this.a.get(paramInt);
      }
      
      public int getStepsCount()
      {
        return this.a.size();
      }
      
      public List<Steps> getStepsList()
      {
        return this.a;
      }
      
      public int getTip()
      {
        return this.k;
      }
      
      public String getTipBackground()
      {
        return this.o;
      }
      
      public String getTipLabel()
      {
        return this.I;
      }
      
      public String getTipLabelBackground()
      {
        return this.K;
      }
      
      public String getTipLabelText()
      {
        return this.ad;
      }
      
      public String getTipRtbus()
      {
        return this.M;
      }
      
      public String getTipText()
      {
        return this.m;
      }
      
      public int getTrafficType()
      {
        return this.Q;
      }
      
      public boolean hasArriveTime()
      {
        return this.p;
      }
      
      public boolean hasComfort()
      {
        return this.W;
      }
      
      public boolean hasDiscount()
      {
        return this.B;
      }
      
      public boolean hasDistance()
      {
        return this.b;
      }
      
      public boolean hasDuration()
      {
        return this.d;
      }
      
      public boolean hasEndAddress()
      {
        return this.t;
      }
      
      public boolean hasEndLocation()
      {
        return this.f;
      }
      
      public boolean hasEndPano()
      {
        return this.T;
      }
      
      public boolean hasEndTime()
      {
        return this.x;
      }
      
      public boolean hasInstructions()
      {
        return this.D;
      }
      
      public boolean hasPlanStatus()
      {
        return this.Y;
      }
      
      public boolean hasPlanType()
      {
        return this.aa;
      }
      
      public boolean hasPrice()
      {
        return this.z;
      }
      
      public boolean hasRtbusUpdateTime()
      {
        return this.N;
      }
      
      public boolean hasStartAddress()
      {
        return this.r;
      }
      
      public boolean hasStartLocation()
      {
        return this.h;
      }
      
      public boolean hasStartPano()
      {
        return this.R;
      }
      
      public boolean hasStartTime()
      {
        return this.v;
      }
      
      public boolean hasTip()
      {
        return this.j;
      }
      
      public boolean hasTipBackground()
      {
        return this.n;
      }
      
      public boolean hasTipLabel()
      {
        return this.H;
      }
      
      public boolean hasTipLabelBackground()
      {
        return this.J;
      }
      
      public boolean hasTipLabelText()
      {
        return this.ac;
      }
      
      public boolean hasTipRtbus()
      {
        return this.L;
      }
      
      public boolean hasTipText()
      {
        return this.l;
      }
      
      public boolean hasTrafficType()
      {
        return this.P;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Legs mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setDistance(paramCodedInputStreamMicro.readInt32());
            break;
          case 16: 
            setDuration(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            setEndLocation(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setStartLocation(paramCodedInputStreamMicro.readString());
            break;
          case 40: 
            setTip(paramCodedInputStreamMicro.readInt32());
            break;
          case 50: 
            setTipText(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setTipBackground(paramCodedInputStreamMicro.readString());
            break;
          case 66: 
            setArriveTime(paramCodedInputStreamMicro.readString());
            break;
          case 90: 
            localObject = new Steps();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addSteps((Steps)localObject);
            break;
          case 98: 
            setStartAddress(paramCodedInputStreamMicro.readString());
            break;
          case 106: 
            setEndAddress(paramCodedInputStreamMicro.readString());
            break;
          case 114: 
            setStartTime(paramCodedInputStreamMicro.readString());
            break;
          case 122: 
            setEndTime(paramCodedInputStreamMicro.readString());
            break;
          case 130: 
            setPrice(paramCodedInputStreamMicro.readString());
            break;
          case 138: 
            setDiscount(paramCodedInputStreamMicro.readString());
            break;
          case 146: 
            setInstructions(paramCodedInputStreamMicro.readString());
            break;
          case 152: 
            addSendLocation(paramCodedInputStreamMicro.readSInt32());
            break;
          case 160: 
            addSstartLocation(paramCodedInputStreamMicro.readSInt32());
            break;
          case 170: 
            setTipLabel(paramCodedInputStreamMicro.readString());
            break;
          case 178: 
            setTipLabelBackground(paramCodedInputStreamMicro.readString());
            break;
          case 186: 
            setTipRtbus(paramCodedInputStreamMicro.readString());
            break;
          case 192: 
            setRtbusUpdateTime(paramCodedInputStreamMicro.readInt32());
            break;
          case 200: 
            setTrafficType(paramCodedInputStreamMicro.readInt32());
            break;
          case 210: 
            localObject = new StartPano();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setStartPano((StartPano)localObject);
            break;
          case 218: 
            localObject = new EndPano();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setEndPano((EndPano)localObject);
            break;
          case 226: 
            localObject = new LinePrice();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addLinePrice((LinePrice)localObject);
            break;
          case 234: 
            setComfort(paramCodedInputStreamMicro.readString());
            break;
          case 240: 
            setPlanStatus(paramCodedInputStreamMicro.readInt32());
            break;
          case 248: 
            setPlanType(paramCodedInputStreamMicro.readInt32());
            break;
          case 258: 
            setTipLabelText(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Legs setArriveTime(String paramString)
      {
        this.p = true;
        this.q = paramString;
        return this;
      }
      
      public Legs setComfort(String paramString)
      {
        this.W = true;
        this.X = paramString;
        return this;
      }
      
      public Legs setDiscount(String paramString)
      {
        this.B = true;
        this.C = paramString;
        return this;
      }
      
      public Legs setDistance(int paramInt)
      {
        this.b = true;
        this.c = paramInt;
        return this;
      }
      
      public Legs setDuration(int paramInt)
      {
        this.d = true;
        this.e = paramInt;
        return this;
      }
      
      public Legs setEndAddress(String paramString)
      {
        this.t = true;
        this.u = paramString;
        return this;
      }
      
      public Legs setEndLocation(String paramString)
      {
        this.f = true;
        this.g = paramString;
        return this;
      }
      
      public Legs setEndPano(EndPano paramEndPano)
      {
        if (paramEndPano == null) {
          return clearEndPano();
        }
        this.T = true;
        this.U = paramEndPano;
        return this;
      }
      
      public Legs setEndTime(String paramString)
      {
        this.x = true;
        this.y = paramString;
        return this;
      }
      
      public Legs setInstructions(String paramString)
      {
        this.D = true;
        this.E = paramString;
        return this;
      }
      
      public Legs setLinePrice(int paramInt, LinePrice paramLinePrice)
      {
        if (paramLinePrice == null) {
          return this;
        }
        this.V.set(paramInt, paramLinePrice);
        return this;
      }
      
      public Legs setPlanStatus(int paramInt)
      {
        this.Y = true;
        this.Z = paramInt;
        return this;
      }
      
      public Legs setPlanType(int paramInt)
      {
        this.aa = true;
        this.ab = paramInt;
        return this;
      }
      
      public Legs setPrice(String paramString)
      {
        this.z = true;
        this.A = paramString;
        return this;
      }
      
      public Legs setRtbusUpdateTime(int paramInt)
      {
        this.N = true;
        this.O = paramInt;
        return this;
      }
      
      public Legs setSendLocation(int paramInt1, int paramInt2)
      {
        this.F.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Legs setSstartLocation(int paramInt1, int paramInt2)
      {
        this.G.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Legs setStartAddress(String paramString)
      {
        this.r = true;
        this.s = paramString;
        return this;
      }
      
      public Legs setStartLocation(String paramString)
      {
        this.h = true;
        this.i = paramString;
        return this;
      }
      
      public Legs setStartPano(StartPano paramStartPano)
      {
        if (paramStartPano == null) {
          return clearStartPano();
        }
        this.R = true;
        this.S = paramStartPano;
        return this;
      }
      
      public Legs setStartTime(String paramString)
      {
        this.v = true;
        this.w = paramString;
        return this;
      }
      
      public Legs setSteps(int paramInt, Steps paramSteps)
      {
        if (paramSteps == null) {
          return this;
        }
        this.a.set(paramInt, paramSteps);
        return this;
      }
      
      public Legs setTip(int paramInt)
      {
        this.j = true;
        this.k = paramInt;
        return this;
      }
      
      public Legs setTipBackground(String paramString)
      {
        this.n = true;
        this.o = paramString;
        return this;
      }
      
      public Legs setTipLabel(String paramString)
      {
        this.H = true;
        this.I = paramString;
        return this;
      }
      
      public Legs setTipLabelBackground(String paramString)
      {
        this.J = true;
        this.K = paramString;
        return this;
      }
      
      public Legs setTipLabelText(String paramString)
      {
        this.ac = true;
        this.ad = paramString;
        return this;
      }
      
      public Legs setTipRtbus(String paramString)
      {
        this.L = true;
        this.M = paramString;
        return this;
      }
      
      public Legs setTipText(String paramString)
      {
        this.l = true;
        this.m = paramString;
        return this;
      }
      
      public Legs setTrafficType(int paramInt)
      {
        this.P = true;
        this.Q = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDistance()) {
          paramCodedOutputStreamMicro.writeInt32(1, getDistance());
        }
        if (hasDuration()) {
          paramCodedOutputStreamMicro.writeInt32(2, getDuration());
        }
        if (hasEndLocation()) {
          paramCodedOutputStreamMicro.writeString(3, getEndLocation());
        }
        if (hasStartLocation()) {
          paramCodedOutputStreamMicro.writeString(4, getStartLocation());
        }
        if (hasTip()) {
          paramCodedOutputStreamMicro.writeInt32(5, getTip());
        }
        if (hasTipText()) {
          paramCodedOutputStreamMicro.writeString(6, getTipText());
        }
        if (hasTipBackground()) {
          paramCodedOutputStreamMicro.writeString(7, getTipBackground());
        }
        if (hasArriveTime()) {
          paramCodedOutputStreamMicro.writeString(8, getArriveTime());
        }
        Iterator localIterator = getStepsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(11, (Steps)localIterator.next());
        }
        if (hasStartAddress()) {
          paramCodedOutputStreamMicro.writeString(12, getStartAddress());
        }
        if (hasEndAddress()) {
          paramCodedOutputStreamMicro.writeString(13, getEndAddress());
        }
        if (hasStartTime()) {
          paramCodedOutputStreamMicro.writeString(14, getStartTime());
        }
        if (hasEndTime()) {
          paramCodedOutputStreamMicro.writeString(15, getEndTime());
        }
        if (hasPrice()) {
          paramCodedOutputStreamMicro.writeString(16, getPrice());
        }
        if (hasDiscount()) {
          paramCodedOutputStreamMicro.writeString(17, getDiscount());
        }
        if (hasInstructions()) {
          paramCodedOutputStreamMicro.writeString(18, getInstructions());
        }
        localIterator = getSendLocationList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(19, ((Integer)localIterator.next()).intValue());
        }
        localIterator = getSstartLocationList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(20, ((Integer)localIterator.next()).intValue());
        }
        if (hasTipLabel()) {
          paramCodedOutputStreamMicro.writeString(21, getTipLabel());
        }
        if (hasTipLabelBackground()) {
          paramCodedOutputStreamMicro.writeString(22, getTipLabelBackground());
        }
        if (hasTipRtbus()) {
          paramCodedOutputStreamMicro.writeString(23, getTipRtbus());
        }
        if (hasRtbusUpdateTime()) {
          paramCodedOutputStreamMicro.writeInt32(24, getRtbusUpdateTime());
        }
        if (hasTrafficType()) {
          paramCodedOutputStreamMicro.writeInt32(25, getTrafficType());
        }
        if (hasStartPano()) {
          paramCodedOutputStreamMicro.writeMessage(26, getStartPano());
        }
        if (hasEndPano()) {
          paramCodedOutputStreamMicro.writeMessage(27, getEndPano());
        }
        localIterator = getLinePriceList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(28, (LinePrice)localIterator.next());
        }
        if (hasComfort()) {
          paramCodedOutputStreamMicro.writeString(29, getComfort());
        }
        if (hasPlanStatus()) {
          paramCodedOutputStreamMicro.writeInt32(30, getPlanStatus());
        }
        if (hasPlanType()) {
          paramCodedOutputStreamMicro.writeInt32(31, getPlanType());
        }
        if (hasTipLabelText()) {
          paramCodedOutputStreamMicro.writeString(32, getTipLabelText());
        }
      }
      
      public static final class EndPano
        extends MessageMicro
      {
        public static final int PANO_ID_FIELD_NUMBER = 2;
        public static final int PANO_LOCATION_FIELD_NUMBER = 1;
        private List<Integer> a = Collections.emptyList();
        private boolean b;
        private String c = "";
        private int d = -1;
        
        public static EndPano parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new EndPano().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static EndPano parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (EndPano)new EndPano().mergeFrom(paramArrayOfByte);
        }
        
        public EndPano addPanoLocation(int paramInt)
        {
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public final EndPano clear()
        {
          clearPanoLocation();
          clearPanoId();
          this.d = -1;
          return this;
        }
        
        public EndPano clearPanoId()
        {
          this.b = false;
          this.c = "";
          return this;
        }
        
        public EndPano clearPanoLocation()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.d < 0) {
            getSerializedSize();
          }
          return this.d;
        }
        
        public String getPanoId()
        {
          return this.c;
        }
        
        public int getPanoLocation(int paramInt)
        {
          return ((Integer)this.a.get(paramInt)).intValue();
        }
        
        public int getPanoLocationCount()
        {
          return this.a.size();
        }
        
        public List<Integer> getPanoLocationList()
        {
          return this.a;
        }
        
        public int getSerializedSize()
        {
          Iterator localIterator = getPanoLocationList().iterator();
          for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
          int j = 0 + i + getPanoLocationList().size() * 1;
          i = j;
          if (hasPanoId()) {
            i = j + CodedOutputStreamMicro.computeStringSize(2, getPanoId());
          }
          this.d = i;
          return i;
        }
        
        public boolean hasPanoId()
        {
          return this.b;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public EndPano mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              addPanoLocation(paramCodedInputStreamMicro.readSInt32());
              break;
            case 18: 
              setPanoId(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public EndPano setPanoId(String paramString)
        {
          this.b = true;
          this.c = paramString;
          return this;
        }
        
        public EndPano setPanoLocation(int paramInt1, int paramInt2)
        {
          this.a.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getPanoLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(1, ((Integer)localIterator.next()).intValue());
          }
          if (hasPanoId()) {
            paramCodedOutputStreamMicro.writeString(2, getPanoId());
          }
        }
      }
      
      public static final class LinePrice
        extends MessageMicro
      {
        public static final int LINE_PRICE_FIELD_NUMBER = 2;
        public static final int LINE_TYPE_FIELD_NUMBER = 1;
        private boolean a;
        private int b = 0;
        private boolean c;
        private double d = 0.0D;
        private int e = -1;
        
        public static LinePrice parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new LinePrice().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static LinePrice parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (LinePrice)new LinePrice().mergeFrom(paramArrayOfByte);
        }
        
        public final LinePrice clear()
        {
          clearLineType();
          clearLinePrice();
          this.e = -1;
          return this;
        }
        
        public LinePrice clearLinePrice()
        {
          this.c = false;
          this.d = 0.0D;
          return this;
        }
        
        public LinePrice clearLineType()
        {
          this.a = false;
          this.b = 0;
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.e < 0) {
            getSerializedSize();
          }
          return this.e;
        }
        
        public double getLinePrice()
        {
          return this.d;
        }
        
        public int getLineType()
        {
          return this.b;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasLineType()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getLineType());
          }
          int j = i;
          if (hasLinePrice()) {
            j = i + CodedOutputStreamMicro.computeDoubleSize(2, getLinePrice());
          }
          this.e = j;
          return j;
        }
        
        public boolean hasLinePrice()
        {
          return this.c;
        }
        
        public boolean hasLineType()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public LinePrice mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setLineType(paramCodedInputStreamMicro.readInt32());
              break;
            case 17: 
              setLinePrice(paramCodedInputStreamMicro.readDouble());
            }
          }
        }
        
        public LinePrice setLinePrice(double paramDouble)
        {
          this.c = true;
          this.d = paramDouble;
          return this;
        }
        
        public LinePrice setLineType(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasLineType()) {
            paramCodedOutputStreamMicro.writeInt32(1, getLineType());
          }
          if (hasLinePrice()) {
            paramCodedOutputStreamMicro.writeDouble(2, getLinePrice());
          }
        }
      }
      
      public static final class StartPano
        extends MessageMicro
      {
        public static final int PANO_ID_FIELD_NUMBER = 2;
        public static final int PANO_LOCATION_FIELD_NUMBER = 1;
        private List<Integer> a = Collections.emptyList();
        private boolean b;
        private String c = "";
        private int d = -1;
        
        public static StartPano parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new StartPano().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static StartPano parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (StartPano)new StartPano().mergeFrom(paramArrayOfByte);
        }
        
        public StartPano addPanoLocation(int paramInt)
        {
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public final StartPano clear()
        {
          clearPanoLocation();
          clearPanoId();
          this.d = -1;
          return this;
        }
        
        public StartPano clearPanoId()
        {
          this.b = false;
          this.c = "";
          return this;
        }
        
        public StartPano clearPanoLocation()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.d < 0) {
            getSerializedSize();
          }
          return this.d;
        }
        
        public String getPanoId()
        {
          return this.c;
        }
        
        public int getPanoLocation(int paramInt)
        {
          return ((Integer)this.a.get(paramInt)).intValue();
        }
        
        public int getPanoLocationCount()
        {
          return this.a.size();
        }
        
        public List<Integer> getPanoLocationList()
        {
          return this.a;
        }
        
        public int getSerializedSize()
        {
          Iterator localIterator = getPanoLocationList().iterator();
          for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
          int j = 0 + i + getPanoLocationList().size() * 1;
          i = j;
          if (hasPanoId()) {
            i = j + CodedOutputStreamMicro.computeStringSize(2, getPanoId());
          }
          this.d = i;
          return i;
        }
        
        public boolean hasPanoId()
        {
          return this.b;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public StartPano mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              addPanoLocation(paramCodedInputStreamMicro.readSInt32());
              break;
            case 18: 
              setPanoId(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public StartPano setPanoId(String paramString)
        {
          this.b = true;
          this.c = paramString;
          return this;
        }
        
        public StartPano setPanoLocation(int paramInt1, int paramInt2)
        {
          this.a.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getPanoLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(1, ((Integer)localIterator.next()).intValue());
          }
          if (hasPanoId()) {
            paramCodedOutputStreamMicro.writeString(2, getPanoId());
          }
        }
      }
      
      public static final class Steps
        extends MessageMicro
      {
        public static final int STEP_FIELD_NUMBER = 1;
        private List<Step> a = Collections.emptyList();
        private int b = -1;
        
        public static Steps parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Steps().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Steps parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Steps)new Steps().mergeFrom(paramArrayOfByte);
        }
        
        public Steps addStep(Step paramStep)
        {
          if (paramStep == null) {
            return this;
          }
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(paramStep);
          return this;
        }
        
        public final Steps clear()
        {
          clearStep();
          this.b = -1;
          return this;
        }
        
        public Steps clearStep()
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
          Iterator localIterator = getStepList().iterator();
          for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Step)localIterator.next()) + i) {}
          this.b = i;
          return i;
        }
        
        public Step getStep(int paramInt)
        {
          return (Step)this.a.get(paramInt);
        }
        
        public int getStepCount()
        {
          return this.a.size();
        }
        
        public List<Step> getStepList()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Steps mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              Step localStep = new Step();
              paramCodedInputStreamMicro.readMessage(localStep);
              addStep(localStep);
            }
          }
        }
        
        public Steps setStep(int paramInt, Step paramStep)
        {
          if (paramStep == null) {
            return this;
          }
          this.a.set(paramInt, paramStep);
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getStepList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(1, (Step)localIterator.next());
          }
        }
        
        public static final class Step
          extends MessageMicro
        {
          public static final int CAN_RIDE_FIELD_NUMBER = 35;
          public static final int COMFORT_FIELD_NUMBER = 27;
          public static final int DICT_INSTRUCTION_FIELD_NUMBER = 23;
          public static final int DISTANCE_FIELD_NUMBER = 1;
          public static final int DURATION_FIELD_NUMBER = 2;
          public static final int END_ADDRESS_FIELD_NUMBER = 18;
          public static final int END_ADDRESS_SHORT_FIELD_NUMBER = 32;
          public static final int END_INSTRUCTIONS_FIELD_NUMBER = 15;
          public static final int END_LOCATION_FIELD_NUMBER = 3;
          public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
          public static final int IS_DEPOT_FIELD_NUMBER = 33;
          public static final int LINE_STOPS_FIELD_NUMBER = 22;
          public static final int LINK_COLOR_FIELD_NUMBER = 24;
          public static final int LOWER_STEPS_FIELD_NUMBER = 13;
          public static final int ORDER_URL_FIELD_NUMBER = 11;
          public static final int PATH_FIELD_NUMBER = 6;
          public static final int POIS_FIELD_NUMBER = 16;
          public static final int PRICE_FIELD_NUMBER = 28;
          public static final int REMAIN_FIELD_NUMBER = 29;
          public static final int SEND_LOCATION_FIELD_NUMBER = 19;
          public static final int SPATH_FIELD_NUMBER = 21;
          public static final int SSTART_LOCATION_FIELD_NUMBER = 20;
          public static final int START_ADDRESS_FIELD_NUMBER = 17;
          public static final int START_ADDRESS_SHORT_FIELD_NUMBER = 31;
          public static final int START_INSTRUCTIONS_FIELD_NUMBER = 14;
          public static final int START_LOCATION_FIELD_NUMBER = 4;
          public static final int STEP_PANO_FIELD_NUMBER = 25;
          public static final int STOPS_POS_FIELD_NUMBER = 26;
          public static final int TICKET_FIELD_NUMBER = 30;
          public static final int TIP_BACKGROUND_FIELD_NUMBER = 10;
          public static final int TIP_FIELD_NUMBER = 8;
          public static final int TIP_TEXT_FIELD_NUMBER = 9;
          public static final int TRANSFER_DICT_FIELD_NUMBER = 34;
          public static final int TYPE_FIELD_NUMBER = 7;
          public static final int VEHICLE_FIELD_NUMBER = 12;
          private String A = "";
          private boolean B;
          private String C = "";
          private boolean D;
          private String E = "";
          private boolean F;
          private String G = "";
          private boolean H;
          private String I = "";
          private boolean J;
          private String K = "";
          private List<Integer> L = Collections.emptyList();
          private List<Integer> M = Collections.emptyList();
          private List<Integer> N = Collections.emptyList();
          private List<String> O = Collections.emptyList();
          private boolean P;
          private StepPano Q = null;
          private List<StopsPos> R = Collections.emptyList();
          private boolean S;
          private String T = "";
          private boolean U;
          private double V = 0.0D;
          private boolean W;
          private int X = 0;
          private boolean Y;
          private Ticket Z = null;
          private boolean a;
          private boolean aa;
          private String ab = "";
          private boolean ac;
          private String ad = "";
          private boolean ae;
          private int af = 0;
          private boolean ag;
          private TransferDict ah = null;
          private boolean ai;
          private int aj = 0;
          private int ak = -1;
          private DictInstruction b = null;
          private boolean c;
          private Vehicle d = null;
          private List<LowerSteps> e = Collections.emptyList();
          private List<Pois> f = Collections.emptyList();
          private List<LinkColor> g = Collections.emptyList();
          private boolean h;
          private int i = 0;
          private boolean j;
          private int k = 0;
          private boolean l;
          private String m = "";
          private boolean n;
          private String o = "";
          private boolean p;
          private String q = "";
          private boolean r;
          private String s = "";
          private boolean t;
          private int u = 0;
          private boolean v;
          private int w = 0;
          private boolean x;
          private String y = "";
          private boolean z;
          
          public static Step parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Step().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Step parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Step)new Step().mergeFrom(paramArrayOfByte);
          }
          
          public Step addLineStops(String paramString)
          {
            if (paramString == null) {
              throw new NullPointerException();
            }
            if (this.O.isEmpty()) {
              this.O = new ArrayList();
            }
            this.O.add(paramString);
            return this;
          }
          
          public Step addLinkColor(LinkColor paramLinkColor)
          {
            if (paramLinkColor == null) {
              return this;
            }
            if (this.g.isEmpty()) {
              this.g = new ArrayList();
            }
            this.g.add(paramLinkColor);
            return this;
          }
          
          public Step addLowerSteps(LowerSteps paramLowerSteps)
          {
            if (paramLowerSteps == null) {
              return this;
            }
            if (this.e.isEmpty()) {
              this.e = new ArrayList();
            }
            this.e.add(paramLowerSteps);
            return this;
          }
          
          public Step addPois(Pois paramPois)
          {
            if (paramPois == null) {
              return this;
            }
            if (this.f.isEmpty()) {
              this.f = new ArrayList();
            }
            this.f.add(paramPois);
            return this;
          }
          
          public Step addSendLocation(int paramInt)
          {
            if (this.L.isEmpty()) {
              this.L = new ArrayList();
            }
            this.L.add(Integer.valueOf(paramInt));
            return this;
          }
          
          public Step addSpath(int paramInt)
          {
            if (this.N.isEmpty()) {
              this.N = new ArrayList();
            }
            this.N.add(Integer.valueOf(paramInt));
            return this;
          }
          
          public Step addSstartLocation(int paramInt)
          {
            if (this.M.isEmpty()) {
              this.M = new ArrayList();
            }
            this.M.add(Integer.valueOf(paramInt));
            return this;
          }
          
          public Step addStopsPos(StopsPos paramStopsPos)
          {
            if (paramStopsPos == null) {
              return this;
            }
            if (this.R.isEmpty()) {
              this.R = new ArrayList();
            }
            this.R.add(paramStopsPos);
            return this;
          }
          
          public final Step clear()
          {
            clearDictInstruction();
            clearVehicle();
            clearLowerSteps();
            clearPois();
            clearLinkColor();
            clearDistance();
            clearDuration();
            clearEndLocation();
            clearStartLocation();
            clearInstructions();
            clearPath();
            clearType();
            clearTip();
            clearTipText();
            clearTipBackground();
            clearOrderUrl();
            clearStartInstructions();
            clearEndInstructions();
            clearStartAddress();
            clearEndAddress();
            clearSendLocation();
            clearSstartLocation();
            clearSpath();
            clearLineStops();
            clearStepPano();
            clearStopsPos();
            clearComfort();
            clearPrice();
            clearRemain();
            clearTicket();
            clearStartAddressShort();
            clearEndAddressShort();
            clearIsDepot();
            clearTransferDict();
            clearCanRide();
            this.ak = -1;
            return this;
          }
          
          public Step clearCanRide()
          {
            this.ai = false;
            this.aj = 0;
            return this;
          }
          
          public Step clearComfort()
          {
            this.S = false;
            this.T = "";
            return this;
          }
          
          public Step clearDictInstruction()
          {
            this.a = false;
            this.b = null;
            return this;
          }
          
          public Step clearDistance()
          {
            this.h = false;
            this.i = 0;
            return this;
          }
          
          public Step clearDuration()
          {
            this.j = false;
            this.k = 0;
            return this;
          }
          
          public Step clearEndAddress()
          {
            this.J = false;
            this.K = "";
            return this;
          }
          
          public Step clearEndAddressShort()
          {
            this.ac = false;
            this.ad = "";
            return this;
          }
          
          public Step clearEndInstructions()
          {
            this.F = false;
            this.G = "";
            return this;
          }
          
          public Step clearEndLocation()
          {
            this.l = false;
            this.m = "";
            return this;
          }
          
          public Step clearInstructions()
          {
            this.p = false;
            this.q = "";
            return this;
          }
          
          public Step clearIsDepot()
          {
            this.ae = false;
            this.af = 0;
            return this;
          }
          
          public Step clearLineStops()
          {
            this.O = Collections.emptyList();
            return this;
          }
          
          public Step clearLinkColor()
          {
            this.g = Collections.emptyList();
            return this;
          }
          
          public Step clearLowerSteps()
          {
            this.e = Collections.emptyList();
            return this;
          }
          
          public Step clearOrderUrl()
          {
            this.B = false;
            this.C = "";
            return this;
          }
          
          public Step clearPath()
          {
            this.r = false;
            this.s = "";
            return this;
          }
          
          public Step clearPois()
          {
            this.f = Collections.emptyList();
            return this;
          }
          
          public Step clearPrice()
          {
            this.U = false;
            this.V = 0.0D;
            return this;
          }
          
          public Step clearRemain()
          {
            this.W = false;
            this.X = 0;
            return this;
          }
          
          public Step clearSendLocation()
          {
            this.L = Collections.emptyList();
            return this;
          }
          
          public Step clearSpath()
          {
            this.N = Collections.emptyList();
            return this;
          }
          
          public Step clearSstartLocation()
          {
            this.M = Collections.emptyList();
            return this;
          }
          
          public Step clearStartAddress()
          {
            this.H = false;
            this.I = "";
            return this;
          }
          
          public Step clearStartAddressShort()
          {
            this.aa = false;
            this.ab = "";
            return this;
          }
          
          public Step clearStartInstructions()
          {
            this.D = false;
            this.E = "";
            return this;
          }
          
          public Step clearStartLocation()
          {
            this.n = false;
            this.o = "";
            return this;
          }
          
          public Step clearStepPano()
          {
            this.P = false;
            this.Q = null;
            return this;
          }
          
          public Step clearStopsPos()
          {
            this.R = Collections.emptyList();
            return this;
          }
          
          public Step clearTicket()
          {
            this.Y = false;
            this.Z = null;
            return this;
          }
          
          public Step clearTip()
          {
            this.v = false;
            this.w = 0;
            return this;
          }
          
          public Step clearTipBackground()
          {
            this.z = false;
            this.A = "";
            return this;
          }
          
          public Step clearTipText()
          {
            this.x = false;
            this.y = "";
            return this;
          }
          
          public Step clearTransferDict()
          {
            this.ag = false;
            this.ah = null;
            return this;
          }
          
          public Step clearType()
          {
            this.t = false;
            this.u = 0;
            return this;
          }
          
          public Step clearVehicle()
          {
            this.c = false;
            this.d = null;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.ak < 0) {
              getSerializedSize();
            }
            return this.ak;
          }
          
          public int getCanRide()
          {
            return this.aj;
          }
          
          public String getComfort()
          {
            return this.T;
          }
          
          public DictInstruction getDictInstruction()
          {
            return this.b;
          }
          
          public int getDistance()
          {
            return this.i;
          }
          
          public int getDuration()
          {
            return this.k;
          }
          
          public String getEndAddress()
          {
            return this.K;
          }
          
          public String getEndAddressShort()
          {
            return this.ad;
          }
          
          public String getEndInstructions()
          {
            return this.G;
          }
          
          public String getEndLocation()
          {
            return this.m;
          }
          
          public String getInstructions()
          {
            return this.q;
          }
          
          public int getIsDepot()
          {
            return this.af;
          }
          
          public String getLineStops(int paramInt)
          {
            return (String)this.O.get(paramInt);
          }
          
          public int getLineStopsCount()
          {
            return this.O.size();
          }
          
          public List<String> getLineStopsList()
          {
            return this.O;
          }
          
          public LinkColor getLinkColor(int paramInt)
          {
            return (LinkColor)this.g.get(paramInt);
          }
          
          public int getLinkColorCount()
          {
            return this.g.size();
          }
          
          public List<LinkColor> getLinkColorList()
          {
            return this.g;
          }
          
          public LowerSteps getLowerSteps(int paramInt)
          {
            return (LowerSteps)this.e.get(paramInt);
          }
          
          public int getLowerStepsCount()
          {
            return this.e.size();
          }
          
          public List<LowerSteps> getLowerStepsList()
          {
            return this.e;
          }
          
          public String getOrderUrl()
          {
            return this.C;
          }
          
          public String getPath()
          {
            return this.s;
          }
          
          public Pois getPois(int paramInt)
          {
            return (Pois)this.f.get(paramInt);
          }
          
          public int getPoisCount()
          {
            return this.f.size();
          }
          
          public List<Pois> getPoisList()
          {
            return this.f;
          }
          
          public double getPrice()
          {
            return this.V;
          }
          
          public int getRemain()
          {
            return this.X;
          }
          
          public int getSendLocation(int paramInt)
          {
            return ((Integer)this.L.get(paramInt)).intValue();
          }
          
          public int getSendLocationCount()
          {
            return this.L.size();
          }
          
          public List<Integer> getSendLocationList()
          {
            return this.L;
          }
          
          public int getSerializedSize()
          {
            int i5 = 0;
            if (hasDistance()) {}
            for (int i2 = CodedOutputStreamMicro.computeInt32Size(1, getDistance()) + 0;; i2 = 0)
            {
              int i1 = i2;
              if (hasDuration()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
              }
              i2 = i1;
              if (hasEndLocation()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getEndLocation());
              }
              i1 = i2;
              if (hasStartLocation()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getStartLocation());
              }
              i2 = i1;
              if (hasInstructions()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getInstructions());
              }
              i1 = i2;
              if (hasPath()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getPath());
              }
              i2 = i1;
              if (hasType()) {
                i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getType());
              }
              i1 = i2;
              if (hasTip()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getTip());
              }
              i2 = i1;
              if (hasTipText()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getTipText());
              }
              i1 = i2;
              if (hasTipBackground()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getTipBackground());
              }
              i2 = i1;
              if (hasOrderUrl()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getOrderUrl());
              }
              i1 = i2;
              if (hasVehicle()) {
                i1 = i2 + CodedOutputStreamMicro.computeMessageSize(12, getVehicle());
              }
              Iterator localIterator = getLowerStepsList().iterator();
              for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(13, (LowerSteps)localIterator.next()) + i2) {}
              i1 = i2;
              if (hasStartInstructions()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getStartInstructions());
              }
              i2 = i1;
              if (hasEndInstructions()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getEndInstructions());
              }
              localIterator = getPoisList().iterator();
              while (localIterator.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(16, (Pois)localIterator.next());
              }
              i1 = i2;
              if (hasStartAddress()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(17, getStartAddress());
              }
              i2 = i1;
              if (hasEndAddress()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(18, getEndAddress());
              }
              localIterator = getSendLocationList().iterator();
              for (i1 = 0; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i1) {}
              int i6 = getSendLocationList().size();
              localIterator = getSstartLocationList().iterator();
              for (int i3 = 0; localIterator.hasNext(); i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i3) {}
              int i7 = getSstartLocationList().size();
              localIterator = getSpathList().iterator();
              for (int i4 = 0; localIterator.hasNext(); i4 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i4) {}
              int i8 = getSpathList().size();
              localIterator = getLineStopsList().iterator();
              while (localIterator.hasNext()) {
                i5 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
              }
              i2 = i8 * 2 + (i2 + i1 + i6 * 2 + i3 + i7 * 2 + i4) + i5 + getLineStopsList().size() * 2;
              i1 = i2;
              if (hasDictInstruction()) {
                i1 = i2 + CodedOutputStreamMicro.computeMessageSize(23, getDictInstruction());
              }
              localIterator = getLinkColorList().iterator();
              while (localIterator.hasNext()) {
                i1 = CodedOutputStreamMicro.computeMessageSize(24, (LinkColor)localIterator.next()) + i1;
              }
              i2 = i1;
              if (hasStepPano()) {
                i2 = i1 + CodedOutputStreamMicro.computeMessageSize(25, getStepPano());
              }
              localIterator = getStopsPosList().iterator();
              while (localIterator.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(26, (StopsPos)localIterator.next());
              }
              i1 = i2;
              if (hasComfort()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(27, getComfort());
              }
              i2 = i1;
              if (hasPrice()) {
                i2 = i1 + CodedOutputStreamMicro.computeDoubleSize(28, getPrice());
              }
              i1 = i2;
              if (hasRemain()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(29, getRemain());
              }
              i2 = i1;
              if (hasTicket()) {
                i2 = i1 + CodedOutputStreamMicro.computeMessageSize(30, getTicket());
              }
              i1 = i2;
              if (hasStartAddressShort()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(31, getStartAddressShort());
              }
              i2 = i1;
              if (hasEndAddressShort()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(32, getEndAddressShort());
              }
              i1 = i2;
              if (hasIsDepot()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(33, getIsDepot());
              }
              i2 = i1;
              if (hasTransferDict()) {
                i2 = i1 + CodedOutputStreamMicro.computeMessageSize(34, getTransferDict());
              }
              i1 = i2;
              if (hasCanRide()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(35, getCanRide());
              }
              this.ak = i1;
              return i1;
            }
          }
          
          public int getSpath(int paramInt)
          {
            return ((Integer)this.N.get(paramInt)).intValue();
          }
          
          public int getSpathCount()
          {
            return this.N.size();
          }
          
          public List<Integer> getSpathList()
          {
            return this.N;
          }
          
          public int getSstartLocation(int paramInt)
          {
            return ((Integer)this.M.get(paramInt)).intValue();
          }
          
          public int getSstartLocationCount()
          {
            return this.M.size();
          }
          
          public List<Integer> getSstartLocationList()
          {
            return this.M;
          }
          
          public String getStartAddress()
          {
            return this.I;
          }
          
          public String getStartAddressShort()
          {
            return this.ab;
          }
          
          public String getStartInstructions()
          {
            return this.E;
          }
          
          public String getStartLocation()
          {
            return this.o;
          }
          
          public StepPano getStepPano()
          {
            return this.Q;
          }
          
          public StopsPos getStopsPos(int paramInt)
          {
            return (StopsPos)this.R.get(paramInt);
          }
          
          public int getStopsPosCount()
          {
            return this.R.size();
          }
          
          public List<StopsPos> getStopsPosList()
          {
            return this.R;
          }
          
          public Ticket getTicket()
          {
            return this.Z;
          }
          
          public int getTip()
          {
            return this.w;
          }
          
          public String getTipBackground()
          {
            return this.A;
          }
          
          public String getTipText()
          {
            return this.y;
          }
          
          public TransferDict getTransferDict()
          {
            return this.ah;
          }
          
          public int getType()
          {
            return this.u;
          }
          
          public Vehicle getVehicle()
          {
            return this.d;
          }
          
          public boolean hasCanRide()
          {
            return this.ai;
          }
          
          public boolean hasComfort()
          {
            return this.S;
          }
          
          public boolean hasDictInstruction()
          {
            return this.a;
          }
          
          public boolean hasDistance()
          {
            return this.h;
          }
          
          public boolean hasDuration()
          {
            return this.j;
          }
          
          public boolean hasEndAddress()
          {
            return this.J;
          }
          
          public boolean hasEndAddressShort()
          {
            return this.ac;
          }
          
          public boolean hasEndInstructions()
          {
            return this.F;
          }
          
          public boolean hasEndLocation()
          {
            return this.l;
          }
          
          public boolean hasInstructions()
          {
            return this.p;
          }
          
          public boolean hasIsDepot()
          {
            return this.ae;
          }
          
          public boolean hasOrderUrl()
          {
            return this.B;
          }
          
          public boolean hasPath()
          {
            return this.r;
          }
          
          public boolean hasPrice()
          {
            return this.U;
          }
          
          public boolean hasRemain()
          {
            return this.W;
          }
          
          public boolean hasStartAddress()
          {
            return this.H;
          }
          
          public boolean hasStartAddressShort()
          {
            return this.aa;
          }
          
          public boolean hasStartInstructions()
          {
            return this.D;
          }
          
          public boolean hasStartLocation()
          {
            return this.n;
          }
          
          public boolean hasStepPano()
          {
            return this.P;
          }
          
          public boolean hasTicket()
          {
            return this.Y;
          }
          
          public boolean hasTip()
          {
            return this.v;
          }
          
          public boolean hasTipBackground()
          {
            return this.z;
          }
          
          public boolean hasTipText()
          {
            return this.x;
          }
          
          public boolean hasTransferDict()
          {
            return this.ag;
          }
          
          public boolean hasType()
          {
            return this.t;
          }
          
          public boolean hasVehicle()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Step mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setDistance(paramCodedInputStreamMicro.readInt32());
                break;
              case 16: 
                setDuration(paramCodedInputStreamMicro.readInt32());
                break;
              case 26: 
                setEndLocation(paramCodedInputStreamMicro.readString());
                break;
              case 34: 
                setStartLocation(paramCodedInputStreamMicro.readString());
                break;
              case 42: 
                setInstructions(paramCodedInputStreamMicro.readString());
                break;
              case 50: 
                setPath(paramCodedInputStreamMicro.readString());
                break;
              case 56: 
                setType(paramCodedInputStreamMicro.readInt32());
                break;
              case 64: 
                setTip(paramCodedInputStreamMicro.readInt32());
                break;
              case 74: 
                setTipText(paramCodedInputStreamMicro.readString());
                break;
              case 82: 
                setTipBackground(paramCodedInputStreamMicro.readString());
                break;
              case 90: 
                setOrderUrl(paramCodedInputStreamMicro.readString());
                break;
              case 98: 
                localObject = new Vehicle();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                setVehicle((Vehicle)localObject);
                break;
              case 106: 
                localObject = new LowerSteps();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                addLowerSteps((LowerSteps)localObject);
                break;
              case 114: 
                setStartInstructions(paramCodedInputStreamMicro.readString());
                break;
              case 122: 
                setEndInstructions(paramCodedInputStreamMicro.readString());
                break;
              case 130: 
                localObject = new Pois();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                addPois((Pois)localObject);
                break;
              case 138: 
                setStartAddress(paramCodedInputStreamMicro.readString());
                break;
              case 146: 
                setEndAddress(paramCodedInputStreamMicro.readString());
                break;
              case 152: 
                addSendLocation(paramCodedInputStreamMicro.readSInt32());
                break;
              case 160: 
                addSstartLocation(paramCodedInputStreamMicro.readSInt32());
                break;
              case 168: 
                addSpath(paramCodedInputStreamMicro.readSInt32());
                break;
              case 178: 
                addLineStops(paramCodedInputStreamMicro.readString());
                break;
              case 186: 
                localObject = new DictInstruction();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                setDictInstruction((DictInstruction)localObject);
                break;
              case 194: 
                localObject = new LinkColor();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                addLinkColor((LinkColor)localObject);
                break;
              case 202: 
                localObject = new StepPano();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                setStepPano((StepPano)localObject);
                break;
              case 210: 
                localObject = new StopsPos();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                addStopsPos((StopsPos)localObject);
                break;
              case 218: 
                setComfort(paramCodedInputStreamMicro.readString());
                break;
              case 225: 
                setPrice(paramCodedInputStreamMicro.readDouble());
                break;
              case 232: 
                setRemain(paramCodedInputStreamMicro.readInt32());
                break;
              case 242: 
                localObject = new Ticket();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                setTicket((Ticket)localObject);
                break;
              case 250: 
                setStartAddressShort(paramCodedInputStreamMicro.readString());
                break;
              case 258: 
                setEndAddressShort(paramCodedInputStreamMicro.readString());
                break;
              case 264: 
                setIsDepot(paramCodedInputStreamMicro.readInt32());
                break;
              case 274: 
                localObject = new TransferDict();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                setTransferDict((TransferDict)localObject);
                break;
              case 280: 
                setCanRide(paramCodedInputStreamMicro.readInt32());
              }
            }
          }
          
          public Step setCanRide(int paramInt)
          {
            this.ai = true;
            this.aj = paramInt;
            return this;
          }
          
          public Step setComfort(String paramString)
          {
            this.S = true;
            this.T = paramString;
            return this;
          }
          
          public Step setDictInstruction(DictInstruction paramDictInstruction)
          {
            if (paramDictInstruction == null) {
              return clearDictInstruction();
            }
            this.a = true;
            this.b = paramDictInstruction;
            return this;
          }
          
          public Step setDistance(int paramInt)
          {
            this.h = true;
            this.i = paramInt;
            return this;
          }
          
          public Step setDuration(int paramInt)
          {
            this.j = true;
            this.k = paramInt;
            return this;
          }
          
          public Step setEndAddress(String paramString)
          {
            this.J = true;
            this.K = paramString;
            return this;
          }
          
          public Step setEndAddressShort(String paramString)
          {
            this.ac = true;
            this.ad = paramString;
            return this;
          }
          
          public Step setEndInstructions(String paramString)
          {
            this.F = true;
            this.G = paramString;
            return this;
          }
          
          public Step setEndLocation(String paramString)
          {
            this.l = true;
            this.m = paramString;
            return this;
          }
          
          public Step setInstructions(String paramString)
          {
            this.p = true;
            this.q = paramString;
            return this;
          }
          
          public Step setIsDepot(int paramInt)
          {
            this.ae = true;
            this.af = paramInt;
            return this;
          }
          
          public Step setLineStops(int paramInt, String paramString)
          {
            if (paramString == null) {
              throw new NullPointerException();
            }
            this.O.set(paramInt, paramString);
            return this;
          }
          
          public Step setLinkColor(int paramInt, LinkColor paramLinkColor)
          {
            if (paramLinkColor == null) {
              return this;
            }
            this.g.set(paramInt, paramLinkColor);
            return this;
          }
          
          public Step setLowerSteps(int paramInt, LowerSteps paramLowerSteps)
          {
            if (paramLowerSteps == null) {
              return this;
            }
            this.e.set(paramInt, paramLowerSteps);
            return this;
          }
          
          public Step setOrderUrl(String paramString)
          {
            this.B = true;
            this.C = paramString;
            return this;
          }
          
          public Step setPath(String paramString)
          {
            this.r = true;
            this.s = paramString;
            return this;
          }
          
          public Step setPois(int paramInt, Pois paramPois)
          {
            if (paramPois == null) {
              return this;
            }
            this.f.set(paramInt, paramPois);
            return this;
          }
          
          public Step setPrice(double paramDouble)
          {
            this.U = true;
            this.V = paramDouble;
            return this;
          }
          
          public Step setRemain(int paramInt)
          {
            this.W = true;
            this.X = paramInt;
            return this;
          }
          
          public Step setSendLocation(int paramInt1, int paramInt2)
          {
            this.L.set(paramInt1, Integer.valueOf(paramInt2));
            return this;
          }
          
          public Step setSpath(int paramInt1, int paramInt2)
          {
            this.N.set(paramInt1, Integer.valueOf(paramInt2));
            return this;
          }
          
          public Step setSstartLocation(int paramInt1, int paramInt2)
          {
            this.M.set(paramInt1, Integer.valueOf(paramInt2));
            return this;
          }
          
          public Step setStartAddress(String paramString)
          {
            this.H = true;
            this.I = paramString;
            return this;
          }
          
          public Step setStartAddressShort(String paramString)
          {
            this.aa = true;
            this.ab = paramString;
            return this;
          }
          
          public Step setStartInstructions(String paramString)
          {
            this.D = true;
            this.E = paramString;
            return this;
          }
          
          public Step setStartLocation(String paramString)
          {
            this.n = true;
            this.o = paramString;
            return this;
          }
          
          public Step setStepPano(StepPano paramStepPano)
          {
            if (paramStepPano == null) {
              return clearStepPano();
            }
            this.P = true;
            this.Q = paramStepPano;
            return this;
          }
          
          public Step setStopsPos(int paramInt, StopsPos paramStopsPos)
          {
            if (paramStopsPos == null) {
              return this;
            }
            this.R.set(paramInt, paramStopsPos);
            return this;
          }
          
          public Step setTicket(Ticket paramTicket)
          {
            if (paramTicket == null) {
              return clearTicket();
            }
            this.Y = true;
            this.Z = paramTicket;
            return this;
          }
          
          public Step setTip(int paramInt)
          {
            this.v = true;
            this.w = paramInt;
            return this;
          }
          
          public Step setTipBackground(String paramString)
          {
            this.z = true;
            this.A = paramString;
            return this;
          }
          
          public Step setTipText(String paramString)
          {
            this.x = true;
            this.y = paramString;
            return this;
          }
          
          public Step setTransferDict(TransferDict paramTransferDict)
          {
            if (paramTransferDict == null) {
              return clearTransferDict();
            }
            this.ag = true;
            this.ah = paramTransferDict;
            return this;
          }
          
          public Step setType(int paramInt)
          {
            this.t = true;
            this.u = paramInt;
            return this;
          }
          
          public Step setVehicle(Vehicle paramVehicle)
          {
            if (paramVehicle == null) {
              return clearVehicle();
            }
            this.c = true;
            this.d = paramVehicle;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasDistance()) {
              paramCodedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
              paramCodedOutputStreamMicro.writeInt32(2, getDuration());
            }
            if (hasEndLocation()) {
              paramCodedOutputStreamMicro.writeString(3, getEndLocation());
            }
            if (hasStartLocation()) {
              paramCodedOutputStreamMicro.writeString(4, getStartLocation());
            }
            if (hasInstructions()) {
              paramCodedOutputStreamMicro.writeString(5, getInstructions());
            }
            if (hasPath()) {
              paramCodedOutputStreamMicro.writeString(6, getPath());
            }
            if (hasType()) {
              paramCodedOutputStreamMicro.writeInt32(7, getType());
            }
            if (hasTip()) {
              paramCodedOutputStreamMicro.writeInt32(8, getTip());
            }
            if (hasTipText()) {
              paramCodedOutputStreamMicro.writeString(9, getTipText());
            }
            if (hasTipBackground()) {
              paramCodedOutputStreamMicro.writeString(10, getTipBackground());
            }
            if (hasOrderUrl()) {
              paramCodedOutputStreamMicro.writeString(11, getOrderUrl());
            }
            if (hasVehicle()) {
              paramCodedOutputStreamMicro.writeMessage(12, getVehicle());
            }
            Iterator localIterator = getLowerStepsList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeMessage(13, (LowerSteps)localIterator.next());
            }
            if (hasStartInstructions()) {
              paramCodedOutputStreamMicro.writeString(14, getStartInstructions());
            }
            if (hasEndInstructions()) {
              paramCodedOutputStreamMicro.writeString(15, getEndInstructions());
            }
            localIterator = getPoisList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeMessage(16, (Pois)localIterator.next());
            }
            if (hasStartAddress()) {
              paramCodedOutputStreamMicro.writeString(17, getStartAddress());
            }
            if (hasEndAddress()) {
              paramCodedOutputStreamMicro.writeString(18, getEndAddress());
            }
            localIterator = getSendLocationList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeSInt32(19, ((Integer)localIterator.next()).intValue());
            }
            localIterator = getSstartLocationList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeSInt32(20, ((Integer)localIterator.next()).intValue());
            }
            localIterator = getSpathList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeSInt32(21, ((Integer)localIterator.next()).intValue());
            }
            localIterator = getLineStopsList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeString(22, (String)localIterator.next());
            }
            if (hasDictInstruction()) {
              paramCodedOutputStreamMicro.writeMessage(23, getDictInstruction());
            }
            localIterator = getLinkColorList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeMessage(24, (LinkColor)localIterator.next());
            }
            if (hasStepPano()) {
              paramCodedOutputStreamMicro.writeMessage(25, getStepPano());
            }
            localIterator = getStopsPosList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeMessage(26, (StopsPos)localIterator.next());
            }
            if (hasComfort()) {
              paramCodedOutputStreamMicro.writeString(27, getComfort());
            }
            if (hasPrice()) {
              paramCodedOutputStreamMicro.writeDouble(28, getPrice());
            }
            if (hasRemain()) {
              paramCodedOutputStreamMicro.writeInt32(29, getRemain());
            }
            if (hasTicket()) {
              paramCodedOutputStreamMicro.writeMessage(30, getTicket());
            }
            if (hasStartAddressShort()) {
              paramCodedOutputStreamMicro.writeString(31, getStartAddressShort());
            }
            if (hasEndAddressShort()) {
              paramCodedOutputStreamMicro.writeString(32, getEndAddressShort());
            }
            if (hasIsDepot()) {
              paramCodedOutputStreamMicro.writeInt32(33, getIsDepot());
            }
            if (hasTransferDict()) {
              paramCodedOutputStreamMicro.writeMessage(34, getTransferDict());
            }
            if (hasCanRide()) {
              paramCodedOutputStreamMicro.writeInt32(35, getCanRide());
            }
          }
          
          public static final class DictInstruction
            extends MessageMicro
          {
            public static final int CYCLE_TEXT_FIELD_NUMBER = 8;
            public static final int DIRECT_TEXT_FIELD_NUMBER = 4;
            public static final int END_TEXT_FIELD_NUMBER = 2;
            public static final int OTHER_LINES_FIELD_NUMBER = 6;
            public static final int RTBUS_TEXT_FIELD_NUMBER = 3;
            public static final int RTBUS_TEXT_IMAGE_FIELD_NUMBER = 7;
            public static final int START_TEXT_FIELD_NUMBER = 1;
            public static final int WALK_TEXT_FIELD_NUMBER = 5;
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
            private int q = -1;
            
            public static DictInstruction parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new DictInstruction().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static DictInstruction parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (DictInstruction)new DictInstruction().mergeFrom(paramArrayOfByte);
            }
            
            public final DictInstruction clear()
            {
              clearStartText();
              clearEndText();
              clearRtbusText();
              clearDirectText();
              clearWalkText();
              clearOtherLines();
              clearRtbusTextImage();
              clearCycleText();
              this.q = -1;
              return this;
            }
            
            public DictInstruction clearCycleText()
            {
              this.o = false;
              this.p = "";
              return this;
            }
            
            public DictInstruction clearDirectText()
            {
              this.g = false;
              this.h = "";
              return this;
            }
            
            public DictInstruction clearEndText()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public DictInstruction clearOtherLines()
            {
              this.k = false;
              this.l = "";
              return this;
            }
            
            public DictInstruction clearRtbusText()
            {
              this.e = false;
              this.f = "";
              return this;
            }
            
            public DictInstruction clearRtbusTextImage()
            {
              this.m = false;
              this.n = "";
              return this;
            }
            
            public DictInstruction clearStartText()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public DictInstruction clearWalkText()
            {
              this.i = false;
              this.j = "";
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.q < 0) {
                getSerializedSize();
              }
              return this.q;
            }
            
            public String getCycleText()
            {
              return this.p;
            }
            
            public String getDirectText()
            {
              return this.h;
            }
            
            public String getEndText()
            {
              return this.d;
            }
            
            public String getOtherLines()
            {
              return this.l;
            }
            
            public String getRtbusText()
            {
              return this.f;
            }
            
            public String getRtbusTextImage()
            {
              return this.n;
            }
            
            public int getSerializedSize()
            {
              int i2 = 0;
              if (hasStartText()) {
                i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getStartText());
              }
              int i1 = i2;
              if (hasEndText()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getEndText());
              }
              i2 = i1;
              if (hasRtbusText()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getRtbusText());
              }
              i1 = i2;
              if (hasDirectText()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getDirectText());
              }
              i2 = i1;
              if (hasWalkText()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getWalkText());
              }
              i1 = i2;
              if (hasOtherLines()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getOtherLines());
              }
              i2 = i1;
              if (hasRtbusTextImage()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getRtbusTextImage());
              }
              i1 = i2;
              if (hasCycleText()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getCycleText());
              }
              this.q = i1;
              return i1;
            }
            
            public String getStartText()
            {
              return this.b;
            }
            
            public String getWalkText()
            {
              return this.j;
            }
            
            public boolean hasCycleText()
            {
              return this.o;
            }
            
            public boolean hasDirectText()
            {
              return this.g;
            }
            
            public boolean hasEndText()
            {
              return this.c;
            }
            
            public boolean hasOtherLines()
            {
              return this.k;
            }
            
            public boolean hasRtbusText()
            {
              return this.e;
            }
            
            public boolean hasRtbusTextImage()
            {
              return this.m;
            }
            
            public boolean hasStartText()
            {
              return this.a;
            }
            
            public boolean hasWalkText()
            {
              return this.i;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public DictInstruction mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  setStartText(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setEndText(paramCodedInputStreamMicro.readString());
                  break;
                case 26: 
                  setRtbusText(paramCodedInputStreamMicro.readString());
                  break;
                case 34: 
                  setDirectText(paramCodedInputStreamMicro.readString());
                  break;
                case 42: 
                  setWalkText(paramCodedInputStreamMicro.readString());
                  break;
                case 50: 
                  setOtherLines(paramCodedInputStreamMicro.readString());
                  break;
                case 58: 
                  setRtbusTextImage(paramCodedInputStreamMicro.readString());
                  break;
                case 66: 
                  setCycleText(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public DictInstruction setCycleText(String paramString)
            {
              this.o = true;
              this.p = paramString;
              return this;
            }
            
            public DictInstruction setDirectText(String paramString)
            {
              this.g = true;
              this.h = paramString;
              return this;
            }
            
            public DictInstruction setEndText(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public DictInstruction setOtherLines(String paramString)
            {
              this.k = true;
              this.l = paramString;
              return this;
            }
            
            public DictInstruction setRtbusText(String paramString)
            {
              this.e = true;
              this.f = paramString;
              return this;
            }
            
            public DictInstruction setRtbusTextImage(String paramString)
            {
              this.m = true;
              this.n = paramString;
              return this;
            }
            
            public DictInstruction setStartText(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public DictInstruction setWalkText(String paramString)
            {
              this.i = true;
              this.j = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasStartText()) {
                paramCodedOutputStreamMicro.writeString(1, getStartText());
              }
              if (hasEndText()) {
                paramCodedOutputStreamMicro.writeString(2, getEndText());
              }
              if (hasRtbusText()) {
                paramCodedOutputStreamMicro.writeString(3, getRtbusText());
              }
              if (hasDirectText()) {
                paramCodedOutputStreamMicro.writeString(4, getDirectText());
              }
              if (hasWalkText()) {
                paramCodedOutputStreamMicro.writeString(5, getWalkText());
              }
              if (hasOtherLines()) {
                paramCodedOutputStreamMicro.writeString(6, getOtherLines());
              }
              if (hasRtbusTextImage()) {
                paramCodedOutputStreamMicro.writeString(7, getRtbusTextImage());
              }
              if (hasCycleText()) {
                paramCodedOutputStreamMicro.writeString(8, getCycleText());
              }
            }
          }
          
          public static final class LinkColor
            extends MessageMicro
          {
            public static final int GEO_CNT_FIELD_NUMBER = 2;
            public static final int STATUS_FIELD_NUMBER = 1;
            private boolean a;
            private int b = 0;
            private boolean c;
            private int d = 0;
            private int e = -1;
            
            public static LinkColor parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new LinkColor().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static LinkColor parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (LinkColor)new LinkColor().mergeFrom(paramArrayOfByte);
            }
            
            public final LinkColor clear()
            {
              clearStatus();
              clearGeoCnt();
              this.e = -1;
              return this;
            }
            
            public LinkColor clearGeoCnt()
            {
              this.c = false;
              this.d = 0;
              return this;
            }
            
            public LinkColor clearStatus()
            {
              this.a = false;
              this.b = 0;
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.e < 0) {
                getSerializedSize();
              }
              return this.e;
            }
            
            public int getGeoCnt()
            {
              return this.d;
            }
            
            public int getSerializedSize()
            {
              int i = 0;
              if (hasStatus()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStatus());
              }
              int j = i;
              if (hasGeoCnt()) {
                j = i + CodedOutputStreamMicro.computeInt32Size(2, getGeoCnt());
              }
              this.e = j;
              return j;
            }
            
            public int getStatus()
            {
              return this.b;
            }
            
            public boolean hasGeoCnt()
            {
              return this.c;
            }
            
            public boolean hasStatus()
            {
              return this.a;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public LinkColor mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  setStatus(paramCodedInputStreamMicro.readInt32());
                  break;
                case 16: 
                  setGeoCnt(paramCodedInputStreamMicro.readInt32());
                }
              }
            }
            
            public LinkColor setGeoCnt(int paramInt)
            {
              this.c = true;
              this.d = paramInt;
              return this;
            }
            
            public LinkColor setStatus(int paramInt)
            {
              this.a = true;
              this.b = paramInt;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasStatus()) {
                paramCodedOutputStreamMicro.writeInt32(1, getStatus());
              }
              if (hasGeoCnt()) {
                paramCodedOutputStreamMicro.writeInt32(2, getGeoCnt());
              }
            }
          }
          
          public static final class LowerSteps
            extends MessageMicro
          {
            public static final int LOWER_STEP_FIELD_NUMBER = 1;
            private List<LowerStep> a = Collections.emptyList();
            private int b = -1;
            
            public static LowerSteps parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new LowerSteps().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static LowerSteps parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (LowerSteps)new LowerSteps().mergeFrom(paramArrayOfByte);
            }
            
            public LowerSteps addLowerStep(LowerStep paramLowerStep)
            {
              if (paramLowerStep == null) {
                return this;
              }
              if (this.a.isEmpty()) {
                this.a = new ArrayList();
              }
              this.a.add(paramLowerStep);
              return this;
            }
            
            public final LowerSteps clear()
            {
              clearLowerStep();
              this.b = -1;
              return this;
            }
            
            public LowerSteps clearLowerStep()
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
            
            public LowerStep getLowerStep(int paramInt)
            {
              return (LowerStep)this.a.get(paramInt);
            }
            
            public int getLowerStepCount()
            {
              return this.a.size();
            }
            
            public List<LowerStep> getLowerStepList()
            {
              return this.a;
            }
            
            public int getSerializedSize()
            {
              Iterator localIterator = getLowerStepList().iterator();
              for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (LowerStep)localIterator.next()) + i) {}
              this.b = i;
              return i;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public LowerSteps mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  LowerStep localLowerStep = new LowerStep();
                  paramCodedInputStreamMicro.readMessage(localLowerStep);
                  addLowerStep(localLowerStep);
                }
              }
            }
            
            public LowerSteps setLowerStep(int paramInt, LowerStep paramLowerStep)
            {
              if (paramLowerStep == null) {
                return this;
              }
              this.a.set(paramInt, paramLowerStep);
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              Iterator localIterator = getLowerStepList().iterator();
              while (localIterator.hasNext()) {
                paramCodedOutputStreamMicro.writeMessage(1, (LowerStep)localIterator.next());
              }
            }
            
            public static final class LowerStep
              extends MessageMicro
            {
              public static final int ARRIVE_TIME_FIELD_NUMBER = 14;
              public static final int DICT_INSTRUCTION_FIELD_NUMBER = 21;
              public static final int DIRECTION_FIELD_NUMBER = 15;
              public static final int DISTANCE_FIELD_NUMBER = 8;
              public static final int DURATION_FIELD_NUMBER = 9;
              public static final int END_INSTRUCTIONS_FIELD_NUMBER = 5;
              public static final int END_LOCATION_FIELD_NUMBER = 7;
              public static final int INSTRUCTIONS_FIELD_NUMBER = 3;
              public static final int LINE_STOPS_FIELD_NUMBER = 20;
              public static final int PATH_FIELD_NUMBER = 1;
              public static final int POIS_FIELD_NUMBER = 16;
              public static final int SEND_LOCATION_FIELD_NUMBER = 18;
              public static final int SPATH_FIELD_NUMBER = 19;
              public static final int SSTART_LOCATION_FIELD_NUMBER = 17;
              public static final int START_INSTRUCTIONS_FIELD_NUMBER = 4;
              public static final int START_LOCATION_FIELD_NUMBER = 6;
              public static final int STEP_PANO_FIELD_NUMBER = 22;
              public static final int TIP_BACKGROUND_FIELD_NUMBER = 13;
              public static final int TIP_FIELD_NUMBER = 11;
              public static final int TIP_TEXT_FIELD_NUMBER = 12;
              public static final int TYPE_FIELD_NUMBER = 2;
              public static final int VEHICLE_FIELD_NUMBER = 10;
              private String A = "";
              private boolean B;
              private String C = "";
              private boolean D;
              private String E = "";
              private boolean F;
              private int G = 0;
              private List<Integer> H = Collections.emptyList();
              private List<Integer> I = Collections.emptyList();
              private List<Integer> J = Collections.emptyList();
              private List<String> K = Collections.emptyList();
              private boolean L;
              private StepPano M = null;
              private int N = -1;
              private boolean a;
              private DictInstruction b = null;
              private boolean c;
              private Vehicle d = null;
              private List<Pois> e = Collections.emptyList();
              private boolean f;
              private String g = "";
              private boolean h;
              private int i = 0;
              private boolean j;
              private String k = "";
              private boolean l;
              private String m = "";
              private boolean n;
              private String o = "";
              private boolean p;
              private String q = "";
              private boolean r;
              private String s = "";
              private boolean t;
              private int u = 0;
              private boolean v;
              private int w = 0;
              private boolean x;
              private int y = 0;
              private boolean z;
              
              public static LowerStep parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                throws IOException
              {
                return new LowerStep().mergeFrom(paramCodedInputStreamMicro);
              }
              
              public static LowerStep parseFrom(byte[] paramArrayOfByte)
                throws InvalidProtocolBufferMicroException
              {
                return (LowerStep)new LowerStep().mergeFrom(paramArrayOfByte);
              }
              
              public LowerStep addLineStops(String paramString)
              {
                if (paramString == null) {
                  throw new NullPointerException();
                }
                if (this.K.isEmpty()) {
                  this.K = new ArrayList();
                }
                this.K.add(paramString);
                return this;
              }
              
              public LowerStep addPois(Pois paramPois)
              {
                if (paramPois == null) {
                  return this;
                }
                if (this.e.isEmpty()) {
                  this.e = new ArrayList();
                }
                this.e.add(paramPois);
                return this;
              }
              
              public LowerStep addSendLocation(int paramInt)
              {
                if (this.I.isEmpty()) {
                  this.I = new ArrayList();
                }
                this.I.add(Integer.valueOf(paramInt));
                return this;
              }
              
              public LowerStep addSpath(int paramInt)
              {
                if (this.J.isEmpty()) {
                  this.J = new ArrayList();
                }
                this.J.add(Integer.valueOf(paramInt));
                return this;
              }
              
              public LowerStep addSstartLocation(int paramInt)
              {
                if (this.H.isEmpty()) {
                  this.H = new ArrayList();
                }
                this.H.add(Integer.valueOf(paramInt));
                return this;
              }
              
              public final LowerStep clear()
              {
                clearDictInstruction();
                clearVehicle();
                clearPois();
                clearPath();
                clearType();
                clearInstructions();
                clearStartInstructions();
                clearEndInstructions();
                clearStartLocation();
                clearEndLocation();
                clearDistance();
                clearDuration();
                clearTip();
                clearTipText();
                clearTipBackground();
                clearArriveTime();
                clearDirection();
                clearSstartLocation();
                clearSendLocation();
                clearSpath();
                clearLineStops();
                clearStepPano();
                this.N = -1;
                return this;
              }
              
              public LowerStep clearArriveTime()
              {
                this.D = false;
                this.E = "";
                return this;
              }
              
              public LowerStep clearDictInstruction()
              {
                this.a = false;
                this.b = null;
                return this;
              }
              
              public LowerStep clearDirection()
              {
                this.F = false;
                this.G = 0;
                return this;
              }
              
              public LowerStep clearDistance()
              {
                this.t = false;
                this.u = 0;
                return this;
              }
              
              public LowerStep clearDuration()
              {
                this.v = false;
                this.w = 0;
                return this;
              }
              
              public LowerStep clearEndInstructions()
              {
                this.n = false;
                this.o = "";
                return this;
              }
              
              public LowerStep clearEndLocation()
              {
                this.r = false;
                this.s = "";
                return this;
              }
              
              public LowerStep clearInstructions()
              {
                this.j = false;
                this.k = "";
                return this;
              }
              
              public LowerStep clearLineStops()
              {
                this.K = Collections.emptyList();
                return this;
              }
              
              public LowerStep clearPath()
              {
                this.f = false;
                this.g = "";
                return this;
              }
              
              public LowerStep clearPois()
              {
                this.e = Collections.emptyList();
                return this;
              }
              
              public LowerStep clearSendLocation()
              {
                this.I = Collections.emptyList();
                return this;
              }
              
              public LowerStep clearSpath()
              {
                this.J = Collections.emptyList();
                return this;
              }
              
              public LowerStep clearSstartLocation()
              {
                this.H = Collections.emptyList();
                return this;
              }
              
              public LowerStep clearStartInstructions()
              {
                this.l = false;
                this.m = "";
                return this;
              }
              
              public LowerStep clearStartLocation()
              {
                this.p = false;
                this.q = "";
                return this;
              }
              
              public LowerStep clearStepPano()
              {
                this.L = false;
                this.M = null;
                return this;
              }
              
              public LowerStep clearTip()
              {
                this.x = false;
                this.y = 0;
                return this;
              }
              
              public LowerStep clearTipBackground()
              {
                this.B = false;
                this.C = "";
                return this;
              }
              
              public LowerStep clearTipText()
              {
                this.z = false;
                this.A = "";
                return this;
              }
              
              public LowerStep clearType()
              {
                this.h = false;
                this.i = 0;
                return this;
              }
              
              public LowerStep clearVehicle()
              {
                this.c = false;
                this.d = null;
                return this;
              }
              
              public String getArriveTime()
              {
                return this.E;
              }
              
              public int getCachedSize()
              {
                if (this.N < 0) {
                  getSerializedSize();
                }
                return this.N;
              }
              
              public DictInstruction getDictInstruction()
              {
                return this.b;
              }
              
              public int getDirection()
              {
                return this.G;
              }
              
              public int getDistance()
              {
                return this.u;
              }
              
              public int getDuration()
              {
                return this.w;
              }
              
              public String getEndInstructions()
              {
                return this.o;
              }
              
              public String getEndLocation()
              {
                return this.s;
              }
              
              public String getInstructions()
              {
                return this.k;
              }
              
              public String getLineStops(int paramInt)
              {
                return (String)this.K.get(paramInt);
              }
              
              public int getLineStopsCount()
              {
                return this.K.size();
              }
              
              public List<String> getLineStopsList()
              {
                return this.K;
              }
              
              public String getPath()
              {
                return this.g;
              }
              
              public Pois getPois(int paramInt)
              {
                return (Pois)this.e.get(paramInt);
              }
              
              public int getPoisCount()
              {
                return this.e.size();
              }
              
              public List<Pois> getPoisList()
              {
                return this.e;
              }
              
              public int getSendLocation(int paramInt)
              {
                return ((Integer)this.I.get(paramInt)).intValue();
              }
              
              public int getSendLocationCount()
              {
                return this.I.size();
              }
              
              public List<Integer> getSendLocationList()
              {
                return this.I;
              }
              
              public int getSerializedSize()
              {
                int i5 = 0;
                if (hasPath()) {}
                for (int i2 = CodedOutputStreamMicro.computeStringSize(1, getPath()) + 0;; i2 = 0)
                {
                  int i1 = i2;
                  if (hasType()) {
                    i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getType());
                  }
                  i2 = i1;
                  if (hasInstructions()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getInstructions());
                  }
                  i1 = i2;
                  if (hasStartInstructions()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getStartInstructions());
                  }
                  i2 = i1;
                  if (hasEndInstructions()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getEndInstructions());
                  }
                  i1 = i2;
                  if (hasStartLocation()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getStartLocation());
                  }
                  i2 = i1;
                  if (hasEndLocation()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getEndLocation());
                  }
                  i1 = i2;
                  if (hasDistance()) {
                    i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getDistance());
                  }
                  i2 = i1;
                  if (hasDuration()) {
                    i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getDuration());
                  }
                  i1 = i2;
                  if (hasVehicle()) {
                    i1 = i2 + CodedOutputStreamMicro.computeMessageSize(10, getVehicle());
                  }
                  i2 = i1;
                  if (hasTip()) {
                    i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getTip());
                  }
                  i1 = i2;
                  if (hasTipText()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getTipText());
                  }
                  i2 = i1;
                  if (hasTipBackground()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getTipBackground());
                  }
                  i1 = i2;
                  if (hasArriveTime()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getArriveTime());
                  }
                  i2 = i1;
                  if (hasDirection()) {
                    i2 = i1 + CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                  }
                  Iterator localIterator = getPoisList().iterator();
                  for (i1 = i2; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(16, (Pois)localIterator.next()) + i1) {}
                  localIterator = getSstartLocationList().iterator();
                  for (i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i2) {}
                  int i6 = getSstartLocationList().size();
                  localIterator = getSendLocationList().iterator();
                  for (int i3 = 0; localIterator.hasNext(); i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i3) {}
                  int i7 = getSendLocationList().size();
                  localIterator = getSpathList().iterator();
                  for (int i4 = 0; localIterator.hasNext(); i4 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i4) {}
                  int i8 = getSpathList().size();
                  localIterator = getLineStopsList().iterator();
                  while (localIterator.hasNext()) {
                    i5 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
                  }
                  i2 = i8 * 2 + (i1 + i2 + i6 * 2 + i3 + i7 * 2 + i4) + i5 + getLineStopsList().size() * 2;
                  i1 = i2;
                  if (hasDictInstruction()) {
                    i1 = i2 + CodedOutputStreamMicro.computeMessageSize(21, getDictInstruction());
                  }
                  i2 = i1;
                  if (hasStepPano()) {
                    i2 = i1 + CodedOutputStreamMicro.computeMessageSize(22, getStepPano());
                  }
                  this.N = i2;
                  return i2;
                }
              }
              
              public int getSpath(int paramInt)
              {
                return ((Integer)this.J.get(paramInt)).intValue();
              }
              
              public int getSpathCount()
              {
                return this.J.size();
              }
              
              public List<Integer> getSpathList()
              {
                return this.J;
              }
              
              public int getSstartLocation(int paramInt)
              {
                return ((Integer)this.H.get(paramInt)).intValue();
              }
              
              public int getSstartLocationCount()
              {
                return this.H.size();
              }
              
              public List<Integer> getSstartLocationList()
              {
                return this.H;
              }
              
              public String getStartInstructions()
              {
                return this.m;
              }
              
              public String getStartLocation()
              {
                return this.q;
              }
              
              public StepPano getStepPano()
              {
                return this.M;
              }
              
              public int getTip()
              {
                return this.y;
              }
              
              public String getTipBackground()
              {
                return this.C;
              }
              
              public String getTipText()
              {
                return this.A;
              }
              
              public int getType()
              {
                return this.i;
              }
              
              public Vehicle getVehicle()
              {
                return this.d;
              }
              
              public boolean hasArriveTime()
              {
                return this.D;
              }
              
              public boolean hasDictInstruction()
              {
                return this.a;
              }
              
              public boolean hasDirection()
              {
                return this.F;
              }
              
              public boolean hasDistance()
              {
                return this.t;
              }
              
              public boolean hasDuration()
              {
                return this.v;
              }
              
              public boolean hasEndInstructions()
              {
                return this.n;
              }
              
              public boolean hasEndLocation()
              {
                return this.r;
              }
              
              public boolean hasInstructions()
              {
                return this.j;
              }
              
              public boolean hasPath()
              {
                return this.f;
              }
              
              public boolean hasStartInstructions()
              {
                return this.l;
              }
              
              public boolean hasStartLocation()
              {
                return this.p;
              }
              
              public boolean hasStepPano()
              {
                return this.L;
              }
              
              public boolean hasTip()
              {
                return this.x;
              }
              
              public boolean hasTipBackground()
              {
                return this.B;
              }
              
              public boolean hasTipText()
              {
                return this.z;
              }
              
              public boolean hasType()
              {
                return this.h;
              }
              
              public boolean hasVehicle()
              {
                return this.c;
              }
              
              public final boolean isInitialized()
              {
                return true;
              }
              
              public LowerStep mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                    setPath(paramCodedInputStreamMicro.readString());
                    break;
                  case 16: 
                    setType(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 26: 
                    setInstructions(paramCodedInputStreamMicro.readString());
                    break;
                  case 34: 
                    setStartInstructions(paramCodedInputStreamMicro.readString());
                    break;
                  case 42: 
                    setEndInstructions(paramCodedInputStreamMicro.readString());
                    break;
                  case 50: 
                    setStartLocation(paramCodedInputStreamMicro.readString());
                    break;
                  case 58: 
                    setEndLocation(paramCodedInputStreamMicro.readString());
                    break;
                  case 64: 
                    setDistance(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 72: 
                    setDuration(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 82: 
                    localObject = new Vehicle();
                    paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                    setVehicle((Vehicle)localObject);
                    break;
                  case 88: 
                    setTip(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 98: 
                    setTipText(paramCodedInputStreamMicro.readString());
                    break;
                  case 106: 
                    setTipBackground(paramCodedInputStreamMicro.readString());
                    break;
                  case 114: 
                    setArriveTime(paramCodedInputStreamMicro.readString());
                    break;
                  case 120: 
                    setDirection(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 130: 
                    localObject = new Pois();
                    paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                    addPois((Pois)localObject);
                    break;
                  case 136: 
                    addSstartLocation(paramCodedInputStreamMicro.readSInt32());
                    break;
                  case 144: 
                    addSendLocation(paramCodedInputStreamMicro.readSInt32());
                    break;
                  case 152: 
                    addSpath(paramCodedInputStreamMicro.readSInt32());
                    break;
                  case 162: 
                    addLineStops(paramCodedInputStreamMicro.readString());
                    break;
                  case 170: 
                    localObject = new DictInstruction();
                    paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                    setDictInstruction((DictInstruction)localObject);
                    break;
                  case 178: 
                    localObject = new StepPano();
                    paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                    setStepPano((StepPano)localObject);
                  }
                }
              }
              
              public LowerStep setArriveTime(String paramString)
              {
                this.D = true;
                this.E = paramString;
                return this;
              }
              
              public LowerStep setDictInstruction(DictInstruction paramDictInstruction)
              {
                if (paramDictInstruction == null) {
                  return clearDictInstruction();
                }
                this.a = true;
                this.b = paramDictInstruction;
                return this;
              }
              
              public LowerStep setDirection(int paramInt)
              {
                this.F = true;
                this.G = paramInt;
                return this;
              }
              
              public LowerStep setDistance(int paramInt)
              {
                this.t = true;
                this.u = paramInt;
                return this;
              }
              
              public LowerStep setDuration(int paramInt)
              {
                this.v = true;
                this.w = paramInt;
                return this;
              }
              
              public LowerStep setEndInstructions(String paramString)
              {
                this.n = true;
                this.o = paramString;
                return this;
              }
              
              public LowerStep setEndLocation(String paramString)
              {
                this.r = true;
                this.s = paramString;
                return this;
              }
              
              public LowerStep setInstructions(String paramString)
              {
                this.j = true;
                this.k = paramString;
                return this;
              }
              
              public LowerStep setLineStops(int paramInt, String paramString)
              {
                if (paramString == null) {
                  throw new NullPointerException();
                }
                this.K.set(paramInt, paramString);
                return this;
              }
              
              public LowerStep setPath(String paramString)
              {
                this.f = true;
                this.g = paramString;
                return this;
              }
              
              public LowerStep setPois(int paramInt, Pois paramPois)
              {
                if (paramPois == null) {
                  return this;
                }
                this.e.set(paramInt, paramPois);
                return this;
              }
              
              public LowerStep setSendLocation(int paramInt1, int paramInt2)
              {
                this.I.set(paramInt1, Integer.valueOf(paramInt2));
                return this;
              }
              
              public LowerStep setSpath(int paramInt1, int paramInt2)
              {
                this.J.set(paramInt1, Integer.valueOf(paramInt2));
                return this;
              }
              
              public LowerStep setSstartLocation(int paramInt1, int paramInt2)
              {
                this.H.set(paramInt1, Integer.valueOf(paramInt2));
                return this;
              }
              
              public LowerStep setStartInstructions(String paramString)
              {
                this.l = true;
                this.m = paramString;
                return this;
              }
              
              public LowerStep setStartLocation(String paramString)
              {
                this.p = true;
                this.q = paramString;
                return this;
              }
              
              public LowerStep setStepPano(StepPano paramStepPano)
              {
                if (paramStepPano == null) {
                  return clearStepPano();
                }
                this.L = true;
                this.M = paramStepPano;
                return this;
              }
              
              public LowerStep setTip(int paramInt)
              {
                this.x = true;
                this.y = paramInt;
                return this;
              }
              
              public LowerStep setTipBackground(String paramString)
              {
                this.B = true;
                this.C = paramString;
                return this;
              }
              
              public LowerStep setTipText(String paramString)
              {
                this.z = true;
                this.A = paramString;
                return this;
              }
              
              public LowerStep setType(int paramInt)
              {
                this.h = true;
                this.i = paramInt;
                return this;
              }
              
              public LowerStep setVehicle(Vehicle paramVehicle)
              {
                if (paramVehicle == null) {
                  return clearVehicle();
                }
                this.c = true;
                this.d = paramVehicle;
                return this;
              }
              
              public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
                throws IOException
              {
                if (hasPath()) {
                  paramCodedOutputStreamMicro.writeString(1, getPath());
                }
                if (hasType()) {
                  paramCodedOutputStreamMicro.writeInt32(2, getType());
                }
                if (hasInstructions()) {
                  paramCodedOutputStreamMicro.writeString(3, getInstructions());
                }
                if (hasStartInstructions()) {
                  paramCodedOutputStreamMicro.writeString(4, getStartInstructions());
                }
                if (hasEndInstructions()) {
                  paramCodedOutputStreamMicro.writeString(5, getEndInstructions());
                }
                if (hasStartLocation()) {
                  paramCodedOutputStreamMicro.writeString(6, getStartLocation());
                }
                if (hasEndLocation()) {
                  paramCodedOutputStreamMicro.writeString(7, getEndLocation());
                }
                if (hasDistance()) {
                  paramCodedOutputStreamMicro.writeInt32(8, getDistance());
                }
                if (hasDuration()) {
                  paramCodedOutputStreamMicro.writeInt32(9, getDuration());
                }
                if (hasVehicle()) {
                  paramCodedOutputStreamMicro.writeMessage(10, getVehicle());
                }
                if (hasTip()) {
                  paramCodedOutputStreamMicro.writeInt32(11, getTip());
                }
                if (hasTipText()) {
                  paramCodedOutputStreamMicro.writeString(12, getTipText());
                }
                if (hasTipBackground()) {
                  paramCodedOutputStreamMicro.writeString(13, getTipBackground());
                }
                if (hasArriveTime()) {
                  paramCodedOutputStreamMicro.writeString(14, getArriveTime());
                }
                if (hasDirection()) {
                  paramCodedOutputStreamMicro.writeInt32(15, getDirection());
                }
                Iterator localIterator = getPoisList().iterator();
                while (localIterator.hasNext()) {
                  paramCodedOutputStreamMicro.writeMessage(16, (Pois)localIterator.next());
                }
                localIterator = getSstartLocationList().iterator();
                while (localIterator.hasNext()) {
                  paramCodedOutputStreamMicro.writeSInt32(17, ((Integer)localIterator.next()).intValue());
                }
                localIterator = getSendLocationList().iterator();
                while (localIterator.hasNext()) {
                  paramCodedOutputStreamMicro.writeSInt32(18, ((Integer)localIterator.next()).intValue());
                }
                localIterator = getSpathList().iterator();
                while (localIterator.hasNext()) {
                  paramCodedOutputStreamMicro.writeSInt32(19, ((Integer)localIterator.next()).intValue());
                }
                localIterator = getLineStopsList().iterator();
                while (localIterator.hasNext()) {
                  paramCodedOutputStreamMicro.writeString(20, (String)localIterator.next());
                }
                if (hasDictInstruction()) {
                  paramCodedOutputStreamMicro.writeMessage(21, getDictInstruction());
                }
                if (hasStepPano()) {
                  paramCodedOutputStreamMicro.writeMessage(22, getStepPano());
                }
              }
              
              public static final class DictInstruction
                extends MessageMicro
              {
                public static final int CYCLE_TEXT_FIELD_NUMBER = 8;
                public static final int DIRECT_TEXT_FIELD_NUMBER = 4;
                public static final int END_TEXT_FIELD_NUMBER = 2;
                public static final int OTHER_LINES_FIELD_NUMBER = 6;
                public static final int RTBUS_TEXT_FIELD_NUMBER = 3;
                public static final int RTBUS_TEXT_IMAGE_FIELD_NUMBER = 7;
                public static final int START_TEXT_FIELD_NUMBER = 1;
                public static final int WALK_TEXT_FIELD_NUMBER = 5;
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
                private int q = -1;
                
                public static DictInstruction parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                  throws IOException
                {
                  return new DictInstruction().mergeFrom(paramCodedInputStreamMicro);
                }
                
                public static DictInstruction parseFrom(byte[] paramArrayOfByte)
                  throws InvalidProtocolBufferMicroException
                {
                  return (DictInstruction)new DictInstruction().mergeFrom(paramArrayOfByte);
                }
                
                public final DictInstruction clear()
                {
                  clearStartText();
                  clearEndText();
                  clearRtbusText();
                  clearDirectText();
                  clearWalkText();
                  clearOtherLines();
                  clearRtbusTextImage();
                  clearCycleText();
                  this.q = -1;
                  return this;
                }
                
                public DictInstruction clearCycleText()
                {
                  this.o = false;
                  this.p = "";
                  return this;
                }
                
                public DictInstruction clearDirectText()
                {
                  this.g = false;
                  this.h = "";
                  return this;
                }
                
                public DictInstruction clearEndText()
                {
                  this.c = false;
                  this.d = "";
                  return this;
                }
                
                public DictInstruction clearOtherLines()
                {
                  this.k = false;
                  this.l = "";
                  return this;
                }
                
                public DictInstruction clearRtbusText()
                {
                  this.e = false;
                  this.f = "";
                  return this;
                }
                
                public DictInstruction clearRtbusTextImage()
                {
                  this.m = false;
                  this.n = "";
                  return this;
                }
                
                public DictInstruction clearStartText()
                {
                  this.a = false;
                  this.b = "";
                  return this;
                }
                
                public DictInstruction clearWalkText()
                {
                  this.i = false;
                  this.j = "";
                  return this;
                }
                
                public int getCachedSize()
                {
                  if (this.q < 0) {
                    getSerializedSize();
                  }
                  return this.q;
                }
                
                public String getCycleText()
                {
                  return this.p;
                }
                
                public String getDirectText()
                {
                  return this.h;
                }
                
                public String getEndText()
                {
                  return this.d;
                }
                
                public String getOtherLines()
                {
                  return this.l;
                }
                
                public String getRtbusText()
                {
                  return this.f;
                }
                
                public String getRtbusTextImage()
                {
                  return this.n;
                }
                
                public int getSerializedSize()
                {
                  int i2 = 0;
                  if (hasStartText()) {
                    i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getStartText());
                  }
                  int i1 = i2;
                  if (hasEndText()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getEndText());
                  }
                  i2 = i1;
                  if (hasRtbusText()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getRtbusText());
                  }
                  i1 = i2;
                  if (hasDirectText()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getDirectText());
                  }
                  i2 = i1;
                  if (hasWalkText()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getWalkText());
                  }
                  i1 = i2;
                  if (hasOtherLines()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getOtherLines());
                  }
                  i2 = i1;
                  if (hasRtbusTextImage()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getRtbusTextImage());
                  }
                  i1 = i2;
                  if (hasCycleText()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getCycleText());
                  }
                  this.q = i1;
                  return i1;
                }
                
                public String getStartText()
                {
                  return this.b;
                }
                
                public String getWalkText()
                {
                  return this.j;
                }
                
                public boolean hasCycleText()
                {
                  return this.o;
                }
                
                public boolean hasDirectText()
                {
                  return this.g;
                }
                
                public boolean hasEndText()
                {
                  return this.c;
                }
                
                public boolean hasOtherLines()
                {
                  return this.k;
                }
                
                public boolean hasRtbusText()
                {
                  return this.e;
                }
                
                public boolean hasRtbusTextImage()
                {
                  return this.m;
                }
                
                public boolean hasStartText()
                {
                  return this.a;
                }
                
                public boolean hasWalkText()
                {
                  return this.i;
                }
                
                public final boolean isInitialized()
                {
                  return true;
                }
                
                public DictInstruction mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                      setStartText(paramCodedInputStreamMicro.readString());
                      break;
                    case 18: 
                      setEndText(paramCodedInputStreamMicro.readString());
                      break;
                    case 26: 
                      setRtbusText(paramCodedInputStreamMicro.readString());
                      break;
                    case 34: 
                      setDirectText(paramCodedInputStreamMicro.readString());
                      break;
                    case 42: 
                      setWalkText(paramCodedInputStreamMicro.readString());
                      break;
                    case 50: 
                      setOtherLines(paramCodedInputStreamMicro.readString());
                      break;
                    case 58: 
                      setRtbusTextImage(paramCodedInputStreamMicro.readString());
                      break;
                    case 66: 
                      setCycleText(paramCodedInputStreamMicro.readString());
                    }
                  }
                }
                
                public DictInstruction setCycleText(String paramString)
                {
                  this.o = true;
                  this.p = paramString;
                  return this;
                }
                
                public DictInstruction setDirectText(String paramString)
                {
                  this.g = true;
                  this.h = paramString;
                  return this;
                }
                
                public DictInstruction setEndText(String paramString)
                {
                  this.c = true;
                  this.d = paramString;
                  return this;
                }
                
                public DictInstruction setOtherLines(String paramString)
                {
                  this.k = true;
                  this.l = paramString;
                  return this;
                }
                
                public DictInstruction setRtbusText(String paramString)
                {
                  this.e = true;
                  this.f = paramString;
                  return this;
                }
                
                public DictInstruction setRtbusTextImage(String paramString)
                {
                  this.m = true;
                  this.n = paramString;
                  return this;
                }
                
                public DictInstruction setStartText(String paramString)
                {
                  this.a = true;
                  this.b = paramString;
                  return this;
                }
                
                public DictInstruction setWalkText(String paramString)
                {
                  this.i = true;
                  this.j = paramString;
                  return this;
                }
                
                public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
                  throws IOException
                {
                  if (hasStartText()) {
                    paramCodedOutputStreamMicro.writeString(1, getStartText());
                  }
                  if (hasEndText()) {
                    paramCodedOutputStreamMicro.writeString(2, getEndText());
                  }
                  if (hasRtbusText()) {
                    paramCodedOutputStreamMicro.writeString(3, getRtbusText());
                  }
                  if (hasDirectText()) {
                    paramCodedOutputStreamMicro.writeString(4, getDirectText());
                  }
                  if (hasWalkText()) {
                    paramCodedOutputStreamMicro.writeString(5, getWalkText());
                  }
                  if (hasOtherLines()) {
                    paramCodedOutputStreamMicro.writeString(6, getOtherLines());
                  }
                  if (hasRtbusTextImage()) {
                    paramCodedOutputStreamMicro.writeString(7, getRtbusTextImage());
                  }
                  if (hasCycleText()) {
                    paramCodedOutputStreamMicro.writeString(8, getCycleText());
                  }
                }
              }
              
              public static final class Pois
                extends MessageMicro
              {
                public static final int DETAIL_FIELD_NUMBER = 4;
                public static final int LOCATION_FIELD_NUMBER = 2;
                public static final int NAME_FIELD_NUMBER = 1;
                public static final int SLOCATION_FIELD_NUMBER = 5;
                public static final int TYPE_FIELD_NUMBER = 3;
                private boolean a;
                private String b = "";
                private boolean c;
                private String d = "";
                private boolean e;
                private int f = 0;
                private boolean g;
                private String h = "";
                private List<Integer> i = Collections.emptyList();
                private int j = -1;
                
                public static Pois parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                  throws IOException
                {
                  return new Pois().mergeFrom(paramCodedInputStreamMicro);
                }
                
                public static Pois parseFrom(byte[] paramArrayOfByte)
                  throws InvalidProtocolBufferMicroException
                {
                  return (Pois)new Pois().mergeFrom(paramArrayOfByte);
                }
                
                public Pois addSlocation(int paramInt)
                {
                  if (this.i.isEmpty()) {
                    this.i = new ArrayList();
                  }
                  this.i.add(Integer.valueOf(paramInt));
                  return this;
                }
                
                public final Pois clear()
                {
                  clearName();
                  clearLocation();
                  clearType();
                  clearDetail();
                  clearSlocation();
                  this.j = -1;
                  return this;
                }
                
                public Pois clearDetail()
                {
                  this.g = false;
                  this.h = "";
                  return this;
                }
                
                public Pois clearLocation()
                {
                  this.c = false;
                  this.d = "";
                  return this;
                }
                
                public Pois clearName()
                {
                  this.a = false;
                  this.b = "";
                  return this;
                }
                
                public Pois clearSlocation()
                {
                  this.i = Collections.emptyList();
                  return this;
                }
                
                public Pois clearType()
                {
                  this.e = false;
                  this.f = 0;
                  return this;
                }
                
                public int getCachedSize()
                {
                  if (this.j < 0) {
                    getSerializedSize();
                  }
                  return this.j;
                }
                
                public String getDetail()
                {
                  return this.h;
                }
                
                public String getLocation()
                {
                  return this.d;
                }
                
                public String getName()
                {
                  return this.b;
                }
                
                public int getSerializedSize()
                {
                  int n = 0;
                  if (hasName()) {}
                  for (int m = CodedOutputStreamMicro.computeStringSize(1, getName()) + 0;; m = 0)
                  {
                    int k = m;
                    if (hasLocation()) {
                      k = m + CodedOutputStreamMicro.computeStringSize(2, getLocation());
                    }
                    m = k;
                    if (hasType()) {
                      m = k + CodedOutputStreamMicro.computeInt32Size(3, getType());
                    }
                    if (hasDetail()) {}
                    for (k = m + CodedOutputStreamMicro.computeStringSize(4, getDetail());; k = m)
                    {
                      Iterator localIterator = getSlocationList().iterator();
                      m = n;
                      while (localIterator.hasNext()) {
                        m += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
                      }
                      k = k + m + getSlocationList().size() * 1;
                      this.j = k;
                      return k;
                    }
                  }
                }
                
                public int getSlocation(int paramInt)
                {
                  return ((Integer)this.i.get(paramInt)).intValue();
                }
                
                public int getSlocationCount()
                {
                  return this.i.size();
                }
                
                public List<Integer> getSlocationList()
                {
                  return this.i;
                }
                
                public int getType()
                {
                  return this.f;
                }
                
                public boolean hasDetail()
                {
                  return this.g;
                }
                
                public boolean hasLocation()
                {
                  return this.c;
                }
                
                public boolean hasName()
                {
                  return this.a;
                }
                
                public boolean hasType()
                {
                  return this.e;
                }
                
                public final boolean isInitialized()
                {
                  return true;
                }
                
                public Pois mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                  throws IOException
                {
                  for (;;)
                  {
                    int k = paramCodedInputStreamMicro.readTag();
                    switch (k)
                    {
                    default: 
                      if (parseUnknownField(paramCodedInputStreamMicro, k)) {}
                      break;
                    case 0: 
                      return this;
                    case 10: 
                      setName(paramCodedInputStreamMicro.readString());
                      break;
                    case 18: 
                      setLocation(paramCodedInputStreamMicro.readString());
                      break;
                    case 24: 
                      setType(paramCodedInputStreamMicro.readInt32());
                      break;
                    case 34: 
                      setDetail(paramCodedInputStreamMicro.readString());
                      break;
                    case 40: 
                      addSlocation(paramCodedInputStreamMicro.readSInt32());
                    }
                  }
                }
                
                public Pois setDetail(String paramString)
                {
                  this.g = true;
                  this.h = paramString;
                  return this;
                }
                
                public Pois setLocation(String paramString)
                {
                  this.c = true;
                  this.d = paramString;
                  return this;
                }
                
                public Pois setName(String paramString)
                {
                  this.a = true;
                  this.b = paramString;
                  return this;
                }
                
                public Pois setSlocation(int paramInt1, int paramInt2)
                {
                  this.i.set(paramInt1, Integer.valueOf(paramInt2));
                  return this;
                }
                
                public Pois setType(int paramInt)
                {
                  this.e = true;
                  this.f = paramInt;
                  return this;
                }
                
                public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
                  throws IOException
                {
                  if (hasName()) {
                    paramCodedOutputStreamMicro.writeString(1, getName());
                  }
                  if (hasLocation()) {
                    paramCodedOutputStreamMicro.writeString(2, getLocation());
                  }
                  if (hasType()) {
                    paramCodedOutputStreamMicro.writeInt32(3, getType());
                  }
                  if (hasDetail()) {
                    paramCodedOutputStreamMicro.writeString(4, getDetail());
                  }
                  Iterator localIterator = getSlocationList().iterator();
                  while (localIterator.hasNext()) {
                    paramCodedOutputStreamMicro.writeSInt32(5, ((Integer)localIterator.next()).intValue());
                  }
                }
              }
              
              public static final class StepPano
                extends MessageMicro
              {
                public static final int PANO_ID_FIELD_NUMBER = 2;
                public static final int PANO_LOCATION_FIELD_NUMBER = 1;
                private List<Integer> a = Collections.emptyList();
                private boolean b;
                private String c = "";
                private int d = -1;
                
                public static StepPano parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                  throws IOException
                {
                  return new StepPano().mergeFrom(paramCodedInputStreamMicro);
                }
                
                public static StepPano parseFrom(byte[] paramArrayOfByte)
                  throws InvalidProtocolBufferMicroException
                {
                  return (StepPano)new StepPano().mergeFrom(paramArrayOfByte);
                }
                
                public StepPano addPanoLocation(int paramInt)
                {
                  if (this.a.isEmpty()) {
                    this.a = new ArrayList();
                  }
                  this.a.add(Integer.valueOf(paramInt));
                  return this;
                }
                
                public final StepPano clear()
                {
                  clearPanoLocation();
                  clearPanoId();
                  this.d = -1;
                  return this;
                }
                
                public StepPano clearPanoId()
                {
                  this.b = false;
                  this.c = "";
                  return this;
                }
                
                public StepPano clearPanoLocation()
                {
                  this.a = Collections.emptyList();
                  return this;
                }
                
                public int getCachedSize()
                {
                  if (this.d < 0) {
                    getSerializedSize();
                  }
                  return this.d;
                }
                
                public String getPanoId()
                {
                  return this.c;
                }
                
                public int getPanoLocation(int paramInt)
                {
                  return ((Integer)this.a.get(paramInt)).intValue();
                }
                
                public int getPanoLocationCount()
                {
                  return this.a.size();
                }
                
                public List<Integer> getPanoLocationList()
                {
                  return this.a;
                }
                
                public int getSerializedSize()
                {
                  Iterator localIterator = getPanoLocationList().iterator();
                  for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
                  int j = 0 + i + getPanoLocationList().size() * 1;
                  i = j;
                  if (hasPanoId()) {
                    i = j + CodedOutputStreamMicro.computeStringSize(2, getPanoId());
                  }
                  this.d = i;
                  return i;
                }
                
                public boolean hasPanoId()
                {
                  return this.b;
                }
                
                public final boolean isInitialized()
                {
                  return true;
                }
                
                public StepPano mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                      addPanoLocation(paramCodedInputStreamMicro.readSInt32());
                      break;
                    case 18: 
                      setPanoId(paramCodedInputStreamMicro.readString());
                    }
                  }
                }
                
                public StepPano setPanoId(String paramString)
                {
                  this.b = true;
                  this.c = paramString;
                  return this;
                }
                
                public StepPano setPanoLocation(int paramInt1, int paramInt2)
                {
                  this.a.set(paramInt1, Integer.valueOf(paramInt2));
                  return this;
                }
                
                public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
                  throws IOException
                {
                  Iterator localIterator = getPanoLocationList().iterator();
                  while (localIterator.hasNext()) {
                    paramCodedOutputStreamMicro.writeSInt32(1, ((Integer)localIterator.next()).intValue());
                  }
                  if (hasPanoId()) {
                    paramCodedOutputStreamMicro.writeString(2, getPanoId());
                  }
                }
              }
              
              public static final class Vehicle
                extends MessageMicro
              {
                public static final int AREALINES_FIELD_NUMBER = 12;
                public static final int CP_FIELD_NUMBER = 16;
                public static final int DATE_FIELD_NUMBER = 13;
                public static final int DISCOUNT_FIELD_NUMBER = 14;
                public static final int END_CITY_UID_FIELD_NUMBER = 19;
                public static final int END_NAME_FIELD_NUMBER = 7;
                public static final int END_TIME_FIELD_NUMBER = 5;
                public static final int LINESTATIONS_FIELD_NUMBER = 20;
                public static final int LINE_TYPE_FIELD_NUMBER = 17;
                public static final int NAME_FIELD_NUMBER = 1;
                public static final int NEXT_BUS_INFO_FIELD_NUMBER = 11;
                public static final int ORDER_URL_FIELD_NUMBER = 22;
                public static final int PRICE_FIELD_NUMBER = 15;
                public static final int START_NAME_FIELD_NUMBER = 23;
                public static final int START_TIME_FIELD_NUMBER = 4;
                public static final int START_UID_FIELD_NUMBER = 6;
                public static final int START_WD_FIELD_NUMBER = 18;
                public static final int STOP_NUM_FIELD_NUMBER = 8;
                public static final int TELNUM_FIELD_NUMBER = 21;
                public static final int TOTAL_PRICE_FIELD_NUMBER = 9;
                public static final int TYPE_FIELD_NUMBER = 2;
                public static final int UID_FIELD_NUMBER = 3;
                public static final int ZONE_PRICE_FIELD_NUMBER = 10;
                private String A = "";
                private boolean B;
                private String C = "";
                private boolean D;
                private String E = "";
                private boolean F;
                private String G = "";
                private boolean H;
                private int I = 0;
                private boolean J;
                private String K = "";
                private boolean L;
                private String M = "";
                private boolean N;
                private String O = "";
                private boolean P;
                private String Q = "";
                private boolean R;
                private String S = "";
                private int T = -1;
                private boolean a;
                private NextBusInfo b = null;
                private List<Linestations> c = Collections.emptyList();
                private boolean d;
                private String e = "";
                private boolean f;
                private int g = 0;
                private boolean h;
                private String i = "";
                private boolean j;
                private String k = "";
                private boolean l;
                private String m = "";
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
                private String y = "";
                private boolean z;
                
                public static Vehicle parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                  throws IOException
                {
                  return new Vehicle().mergeFrom(paramCodedInputStreamMicro);
                }
                
                public static Vehicle parseFrom(byte[] paramArrayOfByte)
                  throws InvalidProtocolBufferMicroException
                {
                  return (Vehicle)new Vehicle().mergeFrom(paramArrayOfByte);
                }
                
                public Vehicle addLinestations(Linestations paramLinestations)
                {
                  if (paramLinestations == null) {
                    return this;
                  }
                  if (this.c.isEmpty()) {
                    this.c = new ArrayList();
                  }
                  this.c.add(paramLinestations);
                  return this;
                }
                
                public final Vehicle clear()
                {
                  clearNextBusInfo();
                  clearLinestations();
                  clearName();
                  clearType();
                  clearUid();
                  clearStartTime();
                  clearEndTime();
                  clearStartUid();
                  clearEndName();
                  clearStopNum();
                  clearTotalPrice();
                  clearZonePrice();
                  clearArealines();
                  clearDate();
                  clearDiscount();
                  clearPrice();
                  clearCp();
                  clearLineType();
                  clearStartWd();
                  clearEndCityUid();
                  clearTelnum();
                  clearOrderUrl();
                  clearStartName();
                  this.T = -1;
                  return this;
                }
                
                public Vehicle clearArealines()
                {
                  this.x = false;
                  this.y = "";
                  return this;
                }
                
                public Vehicle clearCp()
                {
                  this.F = false;
                  this.G = "";
                  return this;
                }
                
                public Vehicle clearDate()
                {
                  this.z = false;
                  this.A = "";
                  return this;
                }
                
                public Vehicle clearDiscount()
                {
                  this.B = false;
                  this.C = "";
                  return this;
                }
                
                public Vehicle clearEndCityUid()
                {
                  this.L = false;
                  this.M = "";
                  return this;
                }
                
                public Vehicle clearEndName()
                {
                  this.p = false;
                  this.q = "";
                  return this;
                }
                
                public Vehicle clearEndTime()
                {
                  this.l = false;
                  this.m = "";
                  return this;
                }
                
                public Vehicle clearLineType()
                {
                  this.H = false;
                  this.I = 0;
                  return this;
                }
                
                public Vehicle clearLinestations()
                {
                  this.c = Collections.emptyList();
                  return this;
                }
                
                public Vehicle clearName()
                {
                  this.d = false;
                  this.e = "";
                  return this;
                }
                
                public Vehicle clearNextBusInfo()
                {
                  this.a = false;
                  this.b = null;
                  return this;
                }
                
                public Vehicle clearOrderUrl()
                {
                  this.P = false;
                  this.Q = "";
                  return this;
                }
                
                public Vehicle clearPrice()
                {
                  this.D = false;
                  this.E = "";
                  return this;
                }
                
                public Vehicle clearStartName()
                {
                  this.R = false;
                  this.S = "";
                  return this;
                }
                
                public Vehicle clearStartTime()
                {
                  this.j = false;
                  this.k = "";
                  return this;
                }
                
                public Vehicle clearStartUid()
                {
                  this.n = false;
                  this.o = "";
                  return this;
                }
                
                public Vehicle clearStartWd()
                {
                  this.J = false;
                  this.K = "";
                  return this;
                }
                
                public Vehicle clearStopNum()
                {
                  this.r = false;
                  this.s = 0;
                  return this;
                }
                
                public Vehicle clearTelnum()
                {
                  this.N = false;
                  this.O = "";
                  return this;
                }
                
                public Vehicle clearTotalPrice()
                {
                  this.t = false;
                  this.u = 0;
                  return this;
                }
                
                public Vehicle clearType()
                {
                  this.f = false;
                  this.g = 0;
                  return this;
                }
                
                public Vehicle clearUid()
                {
                  this.h = false;
                  this.i = "";
                  return this;
                }
                
                public Vehicle clearZonePrice()
                {
                  this.v = false;
                  this.w = 0;
                  return this;
                }
                
                public String getArealines()
                {
                  return this.y;
                }
                
                public int getCachedSize()
                {
                  if (this.T < 0) {
                    getSerializedSize();
                  }
                  return this.T;
                }
                
                public String getCp()
                {
                  return this.G;
                }
                
                public String getDate()
                {
                  return this.A;
                }
                
                public String getDiscount()
                {
                  return this.C;
                }
                
                public String getEndCityUid()
                {
                  return this.M;
                }
                
                public String getEndName()
                {
                  return this.q;
                }
                
                public String getEndTime()
                {
                  return this.m;
                }
                
                public int getLineType()
                {
                  return this.I;
                }
                
                public Linestations getLinestations(int paramInt)
                {
                  return (Linestations)this.c.get(paramInt);
                }
                
                public int getLinestationsCount()
                {
                  return this.c.size();
                }
                
                public List<Linestations> getLinestationsList()
                {
                  return this.c;
                }
                
                public String getName()
                {
                  return this.e;
                }
                
                public NextBusInfo getNextBusInfo()
                {
                  return this.b;
                }
                
                public String getOrderUrl()
                {
                  return this.Q;
                }
                
                public String getPrice()
                {
                  return this.E;
                }
                
                public int getSerializedSize()
                {
                  int i2 = 0;
                  if (hasName()) {
                    i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                  }
                  int i1 = i2;
                  if (hasType()) {
                    i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getType());
                  }
                  i2 = i1;
                  if (hasUid()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getUid());
                  }
                  i1 = i2;
                  if (hasStartTime()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getStartTime());
                  }
                  i2 = i1;
                  if (hasEndTime()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getEndTime());
                  }
                  i1 = i2;
                  if (hasStartUid()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getStartUid());
                  }
                  i2 = i1;
                  if (hasEndName()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getEndName());
                  }
                  i1 = i2;
                  if (hasStopNum()) {
                    i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getStopNum());
                  }
                  i2 = i1;
                  if (hasTotalPrice()) {
                    i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getTotalPrice());
                  }
                  i1 = i2;
                  if (hasZonePrice()) {
                    i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getZonePrice());
                  }
                  i2 = i1;
                  if (hasNextBusInfo()) {
                    i2 = i1 + CodedOutputStreamMicro.computeMessageSize(11, getNextBusInfo());
                  }
                  i1 = i2;
                  if (hasArealines()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getArealines());
                  }
                  i2 = i1;
                  if (hasDate()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getDate());
                  }
                  i1 = i2;
                  if (hasDiscount()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getDiscount());
                  }
                  i2 = i1;
                  if (hasPrice()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getPrice());
                  }
                  i1 = i2;
                  if (hasCp()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getCp());
                  }
                  i2 = i1;
                  if (hasLineType()) {
                    i2 = i1 + CodedOutputStreamMicro.computeInt32Size(17, getLineType());
                  }
                  i1 = i2;
                  if (hasStartWd()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getStartWd());
                  }
                  i2 = i1;
                  if (hasEndCityUid()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(19, getEndCityUid());
                  }
                  Iterator localIterator = getLinestationsList().iterator();
                  while (localIterator.hasNext()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(20, (Linestations)localIterator.next()) + i2;
                  }
                  i1 = i2;
                  if (hasTelnum()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(21, getTelnum());
                  }
                  i2 = i1;
                  if (hasOrderUrl()) {
                    i2 = i1 + CodedOutputStreamMicro.computeStringSize(22, getOrderUrl());
                  }
                  i1 = i2;
                  if (hasStartName()) {
                    i1 = i2 + CodedOutputStreamMicro.computeStringSize(23, getStartName());
                  }
                  this.T = i1;
                  return i1;
                }
                
                public String getStartName()
                {
                  return this.S;
                }
                
                public String getStartTime()
                {
                  return this.k;
                }
                
                public String getStartUid()
                {
                  return this.o;
                }
                
                public String getStartWd()
                {
                  return this.K;
                }
                
                public int getStopNum()
                {
                  return this.s;
                }
                
                public String getTelnum()
                {
                  return this.O;
                }
                
                public int getTotalPrice()
                {
                  return this.u;
                }
                
                public int getType()
                {
                  return this.g;
                }
                
                public String getUid()
                {
                  return this.i;
                }
                
                public int getZonePrice()
                {
                  return this.w;
                }
                
                public boolean hasArealines()
                {
                  return this.x;
                }
                
                public boolean hasCp()
                {
                  return this.F;
                }
                
                public boolean hasDate()
                {
                  return this.z;
                }
                
                public boolean hasDiscount()
                {
                  return this.B;
                }
                
                public boolean hasEndCityUid()
                {
                  return this.L;
                }
                
                public boolean hasEndName()
                {
                  return this.p;
                }
                
                public boolean hasEndTime()
                {
                  return this.l;
                }
                
                public boolean hasLineType()
                {
                  return this.H;
                }
                
                public boolean hasName()
                {
                  return this.d;
                }
                
                public boolean hasNextBusInfo()
                {
                  return this.a;
                }
                
                public boolean hasOrderUrl()
                {
                  return this.P;
                }
                
                public boolean hasPrice()
                {
                  return this.D;
                }
                
                public boolean hasStartName()
                {
                  return this.R;
                }
                
                public boolean hasStartTime()
                {
                  return this.j;
                }
                
                public boolean hasStartUid()
                {
                  return this.n;
                }
                
                public boolean hasStartWd()
                {
                  return this.J;
                }
                
                public boolean hasStopNum()
                {
                  return this.r;
                }
                
                public boolean hasTelnum()
                {
                  return this.N;
                }
                
                public boolean hasTotalPrice()
                {
                  return this.t;
                }
                
                public boolean hasType()
                {
                  return this.f;
                }
                
                public boolean hasUid()
                {
                  return this.h;
                }
                
                public boolean hasZonePrice()
                {
                  return this.v;
                }
                
                public final boolean isInitialized()
                {
                  return true;
                }
                
                public Vehicle mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                    case 16: 
                      setType(paramCodedInputStreamMicro.readInt32());
                      break;
                    case 26: 
                      setUid(paramCodedInputStreamMicro.readString());
                      break;
                    case 34: 
                      setStartTime(paramCodedInputStreamMicro.readString());
                      break;
                    case 42: 
                      setEndTime(paramCodedInputStreamMicro.readString());
                      break;
                    case 50: 
                      setStartUid(paramCodedInputStreamMicro.readString());
                      break;
                    case 58: 
                      setEndName(paramCodedInputStreamMicro.readString());
                      break;
                    case 64: 
                      setStopNum(paramCodedInputStreamMicro.readInt32());
                      break;
                    case 72: 
                      setTotalPrice(paramCodedInputStreamMicro.readInt32());
                      break;
                    case 80: 
                      setZonePrice(paramCodedInputStreamMicro.readInt32());
                      break;
                    case 90: 
                      localObject = new NextBusInfo();
                      paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                      setNextBusInfo((NextBusInfo)localObject);
                      break;
                    case 98: 
                      setArealines(paramCodedInputStreamMicro.readString());
                      break;
                    case 106: 
                      setDate(paramCodedInputStreamMicro.readString());
                      break;
                    case 114: 
                      setDiscount(paramCodedInputStreamMicro.readString());
                      break;
                    case 122: 
                      setPrice(paramCodedInputStreamMicro.readString());
                      break;
                    case 130: 
                      setCp(paramCodedInputStreamMicro.readString());
                      break;
                    case 136: 
                      setLineType(paramCodedInputStreamMicro.readInt32());
                      break;
                    case 146: 
                      setStartWd(paramCodedInputStreamMicro.readString());
                      break;
                    case 154: 
                      setEndCityUid(paramCodedInputStreamMicro.readString());
                      break;
                    case 162: 
                      localObject = new Linestations();
                      paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                      addLinestations((Linestations)localObject);
                      break;
                    case 170: 
                      setTelnum(paramCodedInputStreamMicro.readString());
                      break;
                    case 178: 
                      setOrderUrl(paramCodedInputStreamMicro.readString());
                      break;
                    case 186: 
                      setStartName(paramCodedInputStreamMicro.readString());
                    }
                  }
                }
                
                public Vehicle setArealines(String paramString)
                {
                  this.x = true;
                  this.y = paramString;
                  return this;
                }
                
                public Vehicle setCp(String paramString)
                {
                  this.F = true;
                  this.G = paramString;
                  return this;
                }
                
                public Vehicle setDate(String paramString)
                {
                  this.z = true;
                  this.A = paramString;
                  return this;
                }
                
                public Vehicle setDiscount(String paramString)
                {
                  this.B = true;
                  this.C = paramString;
                  return this;
                }
                
                public Vehicle setEndCityUid(String paramString)
                {
                  this.L = true;
                  this.M = paramString;
                  return this;
                }
                
                public Vehicle setEndName(String paramString)
                {
                  this.p = true;
                  this.q = paramString;
                  return this;
                }
                
                public Vehicle setEndTime(String paramString)
                {
                  this.l = true;
                  this.m = paramString;
                  return this;
                }
                
                public Vehicle setLineType(int paramInt)
                {
                  this.H = true;
                  this.I = paramInt;
                  return this;
                }
                
                public Vehicle setLinestations(int paramInt, Linestations paramLinestations)
                {
                  if (paramLinestations == null) {
                    return this;
                  }
                  this.c.set(paramInt, paramLinestations);
                  return this;
                }
                
                public Vehicle setName(String paramString)
                {
                  this.d = true;
                  this.e = paramString;
                  return this;
                }
                
                public Vehicle setNextBusInfo(NextBusInfo paramNextBusInfo)
                {
                  if (paramNextBusInfo == null) {
                    return clearNextBusInfo();
                  }
                  this.a = true;
                  this.b = paramNextBusInfo;
                  return this;
                }
                
                public Vehicle setOrderUrl(String paramString)
                {
                  this.P = true;
                  this.Q = paramString;
                  return this;
                }
                
                public Vehicle setPrice(String paramString)
                {
                  this.D = true;
                  this.E = paramString;
                  return this;
                }
                
                public Vehicle setStartName(String paramString)
                {
                  this.R = true;
                  this.S = paramString;
                  return this;
                }
                
                public Vehicle setStartTime(String paramString)
                {
                  this.j = true;
                  this.k = paramString;
                  return this;
                }
                
                public Vehicle setStartUid(String paramString)
                {
                  this.n = true;
                  this.o = paramString;
                  return this;
                }
                
                public Vehicle setStartWd(String paramString)
                {
                  this.J = true;
                  this.K = paramString;
                  return this;
                }
                
                public Vehicle setStopNum(int paramInt)
                {
                  this.r = true;
                  this.s = paramInt;
                  return this;
                }
                
                public Vehicle setTelnum(String paramString)
                {
                  this.N = true;
                  this.O = paramString;
                  return this;
                }
                
                public Vehicle setTotalPrice(int paramInt)
                {
                  this.t = true;
                  this.u = paramInt;
                  return this;
                }
                
                public Vehicle setType(int paramInt)
                {
                  this.f = true;
                  this.g = paramInt;
                  return this;
                }
                
                public Vehicle setUid(String paramString)
                {
                  this.h = true;
                  this.i = paramString;
                  return this;
                }
                
                public Vehicle setZonePrice(int paramInt)
                {
                  this.v = true;
                  this.w = paramInt;
                  return this;
                }
                
                public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
                  throws IOException
                {
                  if (hasName()) {
                    paramCodedOutputStreamMicro.writeString(1, getName());
                  }
                  if (hasType()) {
                    paramCodedOutputStreamMicro.writeInt32(2, getType());
                  }
                  if (hasUid()) {
                    paramCodedOutputStreamMicro.writeString(3, getUid());
                  }
                  if (hasStartTime()) {
                    paramCodedOutputStreamMicro.writeString(4, getStartTime());
                  }
                  if (hasEndTime()) {
                    paramCodedOutputStreamMicro.writeString(5, getEndTime());
                  }
                  if (hasStartUid()) {
                    paramCodedOutputStreamMicro.writeString(6, getStartUid());
                  }
                  if (hasEndName()) {
                    paramCodedOutputStreamMicro.writeString(7, getEndName());
                  }
                  if (hasStopNum()) {
                    paramCodedOutputStreamMicro.writeInt32(8, getStopNum());
                  }
                  if (hasTotalPrice()) {
                    paramCodedOutputStreamMicro.writeInt32(9, getTotalPrice());
                  }
                  if (hasZonePrice()) {
                    paramCodedOutputStreamMicro.writeInt32(10, getZonePrice());
                  }
                  if (hasNextBusInfo()) {
                    paramCodedOutputStreamMicro.writeMessage(11, getNextBusInfo());
                  }
                  if (hasArealines()) {
                    paramCodedOutputStreamMicro.writeString(12, getArealines());
                  }
                  if (hasDate()) {
                    paramCodedOutputStreamMicro.writeString(13, getDate());
                  }
                  if (hasDiscount()) {
                    paramCodedOutputStreamMicro.writeString(14, getDiscount());
                  }
                  if (hasPrice()) {
                    paramCodedOutputStreamMicro.writeString(15, getPrice());
                  }
                  if (hasCp()) {
                    paramCodedOutputStreamMicro.writeString(16, getCp());
                  }
                  if (hasLineType()) {
                    paramCodedOutputStreamMicro.writeInt32(17, getLineType());
                  }
                  if (hasStartWd()) {
                    paramCodedOutputStreamMicro.writeString(18, getStartWd());
                  }
                  if (hasEndCityUid()) {
                    paramCodedOutputStreamMicro.writeString(19, getEndCityUid());
                  }
                  Iterator localIterator = getLinestationsList().iterator();
                  while (localIterator.hasNext()) {
                    paramCodedOutputStreamMicro.writeMessage(20, (Linestations)localIterator.next());
                  }
                  if (hasTelnum()) {
                    paramCodedOutputStreamMicro.writeString(21, getTelnum());
                  }
                  if (hasOrderUrl()) {
                    paramCodedOutputStreamMicro.writeString(22, getOrderUrl());
                  }
                  if (hasStartName()) {
                    paramCodedOutputStreamMicro.writeString(23, getStartName());
                  }
                }
                
                public static final class Linestations
                  extends MessageMicro
                {
                  public static final int GEO_FIELD_NUMBER = 3;
                  public static final int NAME_FIELD_NUMBER = 1;
                  public static final int SGEO_FIELD_NUMBER = 4;
                  public static final int START_TIME_FIELD_NUMBER = 2;
                  private boolean a;
                  private String b = "";
                  private boolean c;
                  private String d = "";
                  private boolean e;
                  private String f = "";
                  private List<Integer> g = Collections.emptyList();
                  private int h = -1;
                  
                  public static Linestations parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                    throws IOException
                  {
                    return new Linestations().mergeFrom(paramCodedInputStreamMicro);
                  }
                  
                  public static Linestations parseFrom(byte[] paramArrayOfByte)
                    throws InvalidProtocolBufferMicroException
                  {
                    return (Linestations)new Linestations().mergeFrom(paramArrayOfByte);
                  }
                  
                  public Linestations addSgeo(int paramInt)
                  {
                    if (this.g.isEmpty()) {
                      this.g = new ArrayList();
                    }
                    this.g.add(Integer.valueOf(paramInt));
                    return this;
                  }
                  
                  public final Linestations clear()
                  {
                    clearName();
                    clearStartTime();
                    clearGeo();
                    clearSgeo();
                    this.h = -1;
                    return this;
                  }
                  
                  public Linestations clearGeo()
                  {
                    this.e = false;
                    this.f = "";
                    return this;
                  }
                  
                  public Linestations clearName()
                  {
                    this.a = false;
                    this.b = "";
                    return this;
                  }
                  
                  public Linestations clearSgeo()
                  {
                    this.g = Collections.emptyList();
                    return this;
                  }
                  
                  public Linestations clearStartTime()
                  {
                    this.c = false;
                    this.d = "";
                    return this;
                  }
                  
                  public int getCachedSize()
                  {
                    if (this.h < 0) {
                      getSerializedSize();
                    }
                    return this.h;
                  }
                  
                  public String getGeo()
                  {
                    return this.f;
                  }
                  
                  public String getName()
                  {
                    return this.b;
                  }
                  
                  public int getSerializedSize()
                  {
                    int k = 0;
                    if (hasName()) {}
                    for (int i = CodedOutputStreamMicro.computeStringSize(1, getName()) + 0;; i = 0)
                    {
                      int j = i;
                      if (hasStartTime()) {
                        j = i + CodedOutputStreamMicro.computeStringSize(2, getStartTime());
                      }
                      if (hasGeo()) {}
                      for (i = j + CodedOutputStreamMicro.computeStringSize(3, getGeo());; i = j)
                      {
                        Iterator localIterator = getSgeoList().iterator();
                        j = k;
                        while (localIterator.hasNext()) {
                          j += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
                        }
                        i = i + j + getSgeoList().size() * 1;
                        this.h = i;
                        return i;
                      }
                    }
                  }
                  
                  public int getSgeo(int paramInt)
                  {
                    return ((Integer)this.g.get(paramInt)).intValue();
                  }
                  
                  public int getSgeoCount()
                  {
                    return this.g.size();
                  }
                  
                  public List<Integer> getSgeoList()
                  {
                    return this.g;
                  }
                  
                  public String getStartTime()
                  {
                    return this.d;
                  }
                  
                  public boolean hasGeo()
                  {
                    return this.e;
                  }
                  
                  public boolean hasName()
                  {
                    return this.a;
                  }
                  
                  public boolean hasStartTime()
                  {
                    return this.c;
                  }
                  
                  public final boolean isInitialized()
                  {
                    return true;
                  }
                  
                  public Linestations mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                        setStartTime(paramCodedInputStreamMicro.readString());
                        break;
                      case 26: 
                        setGeo(paramCodedInputStreamMicro.readString());
                        break;
                      case 32: 
                        addSgeo(paramCodedInputStreamMicro.readSInt32());
                      }
                    }
                  }
                  
                  public Linestations setGeo(String paramString)
                  {
                    this.e = true;
                    this.f = paramString;
                    return this;
                  }
                  
                  public Linestations setName(String paramString)
                  {
                    this.a = true;
                    this.b = paramString;
                    return this;
                  }
                  
                  public Linestations setSgeo(int paramInt1, int paramInt2)
                  {
                    this.g.set(paramInt1, Integer.valueOf(paramInt2));
                    return this;
                  }
                  
                  public Linestations setStartTime(String paramString)
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
                    if (hasStartTime()) {
                      paramCodedOutputStreamMicro.writeString(2, getStartTime());
                    }
                    if (hasGeo()) {
                      paramCodedOutputStreamMicro.writeString(3, getGeo());
                    }
                    Iterator localIterator = getSgeoList().iterator();
                    while (localIterator.hasNext()) {
                      paramCodedOutputStreamMicro.writeSInt32(4, ((Integer)localIterator.next()).intValue());
                    }
                  }
                }
                
                public static final class NextBusInfo
                  extends MessageMicro
                {
                  public static final int REMAIN_DIS_FIELD_NUMBER = 2;
                  public static final int REMAIN_STOPS_FIELD_NUMBER = 3;
                  public static final int REMAIN_TIME_FIELD_NUMBER = 1;
                  public static final int SPATH_FIELD_NUMBER = 6;
                  public static final int X_FIELD_NUMBER = 4;
                  public static final int Y_FIELD_NUMBER = 5;
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
                  private List<Integer> k = Collections.emptyList();
                  private int l = -1;
                  
                  public static NextBusInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                    throws IOException
                  {
                    return new NextBusInfo().mergeFrom(paramCodedInputStreamMicro);
                  }
                  
                  public static NextBusInfo parseFrom(byte[] paramArrayOfByte)
                    throws InvalidProtocolBufferMicroException
                  {
                    return (NextBusInfo)new NextBusInfo().mergeFrom(paramArrayOfByte);
                  }
                  
                  public NextBusInfo addSpath(int paramInt)
                  {
                    if (this.k.isEmpty()) {
                      this.k = new ArrayList();
                    }
                    this.k.add(Integer.valueOf(paramInt));
                    return this;
                  }
                  
                  public final NextBusInfo clear()
                  {
                    clearRemainTime();
                    clearRemainDis();
                    clearRemainStops();
                    clearX();
                    clearY();
                    clearSpath();
                    this.l = -1;
                    return this;
                  }
                  
                  public NextBusInfo clearRemainDis()
                  {
                    this.c = false;
                    this.d = 0;
                    return this;
                  }
                  
                  public NextBusInfo clearRemainStops()
                  {
                    this.e = false;
                    this.f = 0;
                    return this;
                  }
                  
                  public NextBusInfo clearRemainTime()
                  {
                    this.a = false;
                    this.b = 0;
                    return this;
                  }
                  
                  public NextBusInfo clearSpath()
                  {
                    this.k = Collections.emptyList();
                    return this;
                  }
                  
                  public NextBusInfo clearX()
                  {
                    this.g = false;
                    this.h = 0;
                    return this;
                  }
                  
                  public NextBusInfo clearY()
                  {
                    this.i = false;
                    this.j = 0;
                    return this;
                  }
                  
                  public int getCachedSize()
                  {
                    if (this.l < 0) {
                      getSerializedSize();
                    }
                    return this.l;
                  }
                  
                  public int getRemainDis()
                  {
                    return this.d;
                  }
                  
                  public int getRemainStops()
                  {
                    return this.f;
                  }
                  
                  public int getRemainTime()
                  {
                    return this.b;
                  }
                  
                  public int getSerializedSize()
                  {
                    int i1 = 0;
                    if (hasRemainTime()) {}
                    for (int n = CodedOutputStreamMicro.computeInt32Size(1, getRemainTime()) + 0;; n = 0)
                    {
                      int m = n;
                      if (hasRemainDis()) {
                        m = n + CodedOutputStreamMicro.computeInt32Size(2, getRemainDis());
                      }
                      n = m;
                      if (hasRemainStops()) {
                        n = m + CodedOutputStreamMicro.computeInt32Size(3, getRemainStops());
                      }
                      m = n;
                      if (hasX()) {
                        m = n + CodedOutputStreamMicro.computeSInt32Size(4, getX());
                      }
                      if (hasY()) {
                        m += CodedOutputStreamMicro.computeSInt32Size(5, getY());
                      }
                      for (;;)
                      {
                        Iterator localIterator = getSpathList().iterator();
                        n = i1;
                        while (localIterator.hasNext()) {
                          n += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
                        }
                        m = m + n + getSpathList().size() * 1;
                        this.l = m;
                        return m;
                      }
                    }
                  }
                  
                  public int getSpath(int paramInt)
                  {
                    return ((Integer)this.k.get(paramInt)).intValue();
                  }
                  
                  public int getSpathCount()
                  {
                    return this.k.size();
                  }
                  
                  public List<Integer> getSpathList()
                  {
                    return this.k;
                  }
                  
                  public int getX()
                  {
                    return this.h;
                  }
                  
                  public int getY()
                  {
                    return this.j;
                  }
                  
                  public boolean hasRemainDis()
                  {
                    return this.c;
                  }
                  
                  public boolean hasRemainStops()
                  {
                    return this.e;
                  }
                  
                  public boolean hasRemainTime()
                  {
                    return this.a;
                  }
                  
                  public boolean hasX()
                  {
                    return this.g;
                  }
                  
                  public boolean hasY()
                  {
                    return this.i;
                  }
                  
                  public final boolean isInitialized()
                  {
                    return true;
                  }
                  
                  public NextBusInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                    throws IOException
                  {
                    for (;;)
                    {
                      int m = paramCodedInputStreamMicro.readTag();
                      switch (m)
                      {
                      default: 
                        if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
                        break;
                      case 0: 
                        return this;
                      case 8: 
                        setRemainTime(paramCodedInputStreamMicro.readInt32());
                        break;
                      case 16: 
                        setRemainDis(paramCodedInputStreamMicro.readInt32());
                        break;
                      case 24: 
                        setRemainStops(paramCodedInputStreamMicro.readInt32());
                        break;
                      case 32: 
                        setX(paramCodedInputStreamMicro.readSInt32());
                        break;
                      case 40: 
                        setY(paramCodedInputStreamMicro.readSInt32());
                        break;
                      case 48: 
                        addSpath(paramCodedInputStreamMicro.readSInt32());
                      }
                    }
                  }
                  
                  public NextBusInfo setRemainDis(int paramInt)
                  {
                    this.c = true;
                    this.d = paramInt;
                    return this;
                  }
                  
                  public NextBusInfo setRemainStops(int paramInt)
                  {
                    this.e = true;
                    this.f = paramInt;
                    return this;
                  }
                  
                  public NextBusInfo setRemainTime(int paramInt)
                  {
                    this.a = true;
                    this.b = paramInt;
                    return this;
                  }
                  
                  public NextBusInfo setSpath(int paramInt1, int paramInt2)
                  {
                    this.k.set(paramInt1, Integer.valueOf(paramInt2));
                    return this;
                  }
                  
                  public NextBusInfo setX(int paramInt)
                  {
                    this.g = true;
                    this.h = paramInt;
                    return this;
                  }
                  
                  public NextBusInfo setY(int paramInt)
                  {
                    this.i = true;
                    this.j = paramInt;
                    return this;
                  }
                  
                  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
                    throws IOException
                  {
                    if (hasRemainTime()) {
                      paramCodedOutputStreamMicro.writeInt32(1, getRemainTime());
                    }
                    if (hasRemainDis()) {
                      paramCodedOutputStreamMicro.writeInt32(2, getRemainDis());
                    }
                    if (hasRemainStops()) {
                      paramCodedOutputStreamMicro.writeInt32(3, getRemainStops());
                    }
                    if (hasX()) {
                      paramCodedOutputStreamMicro.writeSInt32(4, getX());
                    }
                    if (hasY()) {
                      paramCodedOutputStreamMicro.writeSInt32(5, getY());
                    }
                    Iterator localIterator = getSpathList().iterator();
                    while (localIterator.hasNext()) {
                      paramCodedOutputStreamMicro.writeSInt32(6, ((Integer)localIterator.next()).intValue());
                    }
                  }
                }
              }
            }
          }
          
          public static final class Pois
            extends MessageMicro
          {
            public static final int DETAIL_FIELD_NUMBER = 4;
            public static final int LOCATION_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int SLOCATION_FIELD_NUMBER = 5;
            public static final int TYPE_FIELD_NUMBER = 3;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
            private boolean e;
            private int f = 0;
            private boolean g;
            private String h = "";
            private List<Integer> i = Collections.emptyList();
            private int j = -1;
            
            public static Pois parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Pois().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Pois parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Pois)new Pois().mergeFrom(paramArrayOfByte);
            }
            
            public Pois addSlocation(int paramInt)
            {
              if (this.i.isEmpty()) {
                this.i = new ArrayList();
              }
              this.i.add(Integer.valueOf(paramInt));
              return this;
            }
            
            public final Pois clear()
            {
              clearName();
              clearLocation();
              clearType();
              clearDetail();
              clearSlocation();
              this.j = -1;
              return this;
            }
            
            public Pois clearDetail()
            {
              this.g = false;
              this.h = "";
              return this;
            }
            
            public Pois clearLocation()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public Pois clearName()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public Pois clearSlocation()
            {
              this.i = Collections.emptyList();
              return this;
            }
            
            public Pois clearType()
            {
              this.e = false;
              this.f = 0;
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.j < 0) {
                getSerializedSize();
              }
              return this.j;
            }
            
            public String getDetail()
            {
              return this.h;
            }
            
            public String getLocation()
            {
              return this.d;
            }
            
            public String getName()
            {
              return this.b;
            }
            
            public int getSerializedSize()
            {
              int n = 0;
              if (hasName()) {}
              for (int m = CodedOutputStreamMicro.computeStringSize(1, getName()) + 0;; m = 0)
              {
                int k = m;
                if (hasLocation()) {
                  k = m + CodedOutputStreamMicro.computeStringSize(2, getLocation());
                }
                m = k;
                if (hasType()) {
                  m = k + CodedOutputStreamMicro.computeInt32Size(3, getType());
                }
                if (hasDetail()) {}
                for (k = m + CodedOutputStreamMicro.computeStringSize(4, getDetail());; k = m)
                {
                  Iterator localIterator = getSlocationList().iterator();
                  m = n;
                  while (localIterator.hasNext()) {
                    m += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
                  }
                  k = k + m + getSlocationList().size() * 1;
                  this.j = k;
                  return k;
                }
              }
            }
            
            public int getSlocation(int paramInt)
            {
              return ((Integer)this.i.get(paramInt)).intValue();
            }
            
            public int getSlocationCount()
            {
              return this.i.size();
            }
            
            public List<Integer> getSlocationList()
            {
              return this.i;
            }
            
            public int getType()
            {
              return this.f;
            }
            
            public boolean hasDetail()
            {
              return this.g;
            }
            
            public boolean hasLocation()
            {
              return this.c;
            }
            
            public boolean hasName()
            {
              return this.a;
            }
            
            public boolean hasType()
            {
              return this.e;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Pois mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              for (;;)
              {
                int k = paramCodedInputStreamMicro.readTag();
                switch (k)
                {
                default: 
                  if (parseUnknownField(paramCodedInputStreamMicro, k)) {}
                  break;
                case 0: 
                  return this;
                case 10: 
                  setName(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setLocation(paramCodedInputStreamMicro.readString());
                  break;
                case 24: 
                  setType(paramCodedInputStreamMicro.readInt32());
                  break;
                case 34: 
                  setDetail(paramCodedInputStreamMicro.readString());
                  break;
                case 40: 
                  addSlocation(paramCodedInputStreamMicro.readSInt32());
                }
              }
            }
            
            public Pois setDetail(String paramString)
            {
              this.g = true;
              this.h = paramString;
              return this;
            }
            
            public Pois setLocation(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public Pois setName(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public Pois setSlocation(int paramInt1, int paramInt2)
            {
              this.i.set(paramInt1, Integer.valueOf(paramInt2));
              return this;
            }
            
            public Pois setType(int paramInt)
            {
              this.e = true;
              this.f = paramInt;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasName()) {
                paramCodedOutputStreamMicro.writeString(1, getName());
              }
              if (hasLocation()) {
                paramCodedOutputStreamMicro.writeString(2, getLocation());
              }
              if (hasType()) {
                paramCodedOutputStreamMicro.writeInt32(3, getType());
              }
              if (hasDetail()) {
                paramCodedOutputStreamMicro.writeString(4, getDetail());
              }
              Iterator localIterator = getSlocationList().iterator();
              while (localIterator.hasNext()) {
                paramCodedOutputStreamMicro.writeSInt32(5, ((Integer)localIterator.next()).intValue());
              }
            }
          }
          
          public static final class StepPano
            extends MessageMicro
          {
            public static final int PANO_ID_FIELD_NUMBER = 2;
            public static final int PANO_LOCATION_FIELD_NUMBER = 1;
            private List<Integer> a = Collections.emptyList();
            private boolean b;
            private String c = "";
            private int d = -1;
            
            public static StepPano parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new StepPano().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static StepPano parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (StepPano)new StepPano().mergeFrom(paramArrayOfByte);
            }
            
            public StepPano addPanoLocation(int paramInt)
            {
              if (this.a.isEmpty()) {
                this.a = new ArrayList();
              }
              this.a.add(Integer.valueOf(paramInt));
              return this;
            }
            
            public final StepPano clear()
            {
              clearPanoLocation();
              clearPanoId();
              this.d = -1;
              return this;
            }
            
            public StepPano clearPanoId()
            {
              this.b = false;
              this.c = "";
              return this;
            }
            
            public StepPano clearPanoLocation()
            {
              this.a = Collections.emptyList();
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.d < 0) {
                getSerializedSize();
              }
              return this.d;
            }
            
            public String getPanoId()
            {
              return this.c;
            }
            
            public int getPanoLocation(int paramInt)
            {
              return ((Integer)this.a.get(paramInt)).intValue();
            }
            
            public int getPanoLocationCount()
            {
              return this.a.size();
            }
            
            public List<Integer> getPanoLocationList()
            {
              return this.a;
            }
            
            public int getSerializedSize()
            {
              Iterator localIterator = getPanoLocationList().iterator();
              for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
              int j = 0 + i + getPanoLocationList().size() * 1;
              i = j;
              if (hasPanoId()) {
                i = j + CodedOutputStreamMicro.computeStringSize(2, getPanoId());
              }
              this.d = i;
              return i;
            }
            
            public boolean hasPanoId()
            {
              return this.b;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public StepPano mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  addPanoLocation(paramCodedInputStreamMicro.readSInt32());
                  break;
                case 18: 
                  setPanoId(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public StepPano setPanoId(String paramString)
            {
              this.b = true;
              this.c = paramString;
              return this;
            }
            
            public StepPano setPanoLocation(int paramInt1, int paramInt2)
            {
              this.a.set(paramInt1, Integer.valueOf(paramInt2));
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              Iterator localIterator = getPanoLocationList().iterator();
              while (localIterator.hasNext()) {
                paramCodedOutputStreamMicro.writeSInt32(1, ((Integer)localIterator.next()).intValue());
              }
              if (hasPanoId()) {
                paramCodedOutputStreamMicro.writeString(2, getPanoId());
              }
            }
          }
          
          public static final class StopsPos
            extends MessageMicro
          {
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            private boolean a;
            private double b = 0.0D;
            private boolean c;
            private double d = 0.0D;
            private int e = -1;
            
            public static StopsPos parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new StopsPos().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static StopsPos parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (StopsPos)new StopsPos().mergeFrom(paramArrayOfByte);
            }
            
            public final StopsPos clear()
            {
              clearX();
              clearY();
              this.e = -1;
              return this;
            }
            
            public StopsPos clearX()
            {
              this.a = false;
              this.b = 0.0D;
              return this;
            }
            
            public StopsPos clearY()
            {
              this.c = false;
              this.d = 0.0D;
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
                i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
              }
              int j = i;
              if (hasY()) {
                j = i + CodedOutputStreamMicro.computeDoubleSize(2, getY());
              }
              this.e = j;
              return j;
            }
            
            public double getX()
            {
              return this.b;
            }
            
            public double getY()
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
            
            public StopsPos mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                case 9: 
                  setX(paramCodedInputStreamMicro.readDouble());
                  break;
                case 17: 
                  setY(paramCodedInputStreamMicro.readDouble());
                }
              }
            }
            
            public StopsPos setX(double paramDouble)
            {
              this.a = true;
              this.b = paramDouble;
              return this;
            }
            
            public StopsPos setY(double paramDouble)
            {
              this.c = true;
              this.d = paramDouble;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasX()) {
                paramCodedOutputStreamMicro.writeDouble(1, getX());
              }
              if (hasY()) {
                paramCodedOutputStreamMicro.writeDouble(2, getY());
              }
            }
          }
          
          public static final class Ticket
            extends MessageMicro
          {
            public static final int BUY_STATUS_FIELD_NUMBER = 2;
            public static final int SEATS_FIELD_NUMBER = 3;
            public static final int URL_FIELD_NUMBER = 1;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
            private List<Seats> e = Collections.emptyList();
            private int f = -1;
            
            public static Ticket parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Ticket().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Ticket parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Ticket)new Ticket().mergeFrom(paramArrayOfByte);
            }
            
            public Ticket addSeats(Seats paramSeats)
            {
              if (paramSeats == null) {
                return this;
              }
              if (this.e.isEmpty()) {
                this.e = new ArrayList();
              }
              this.e.add(paramSeats);
              return this;
            }
            
            public final Ticket clear()
            {
              clearUrl();
              clearBuyStatus();
              clearSeats();
              this.f = -1;
              return this;
            }
            
            public Ticket clearBuyStatus()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public Ticket clearSeats()
            {
              this.e = Collections.emptyList();
              return this;
            }
            
            public Ticket clearUrl()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public String getBuyStatus()
            {
              return this.d;
            }
            
            public int getCachedSize()
            {
              if (this.f < 0) {
                getSerializedSize();
              }
              return this.f;
            }
            
            public Seats getSeats(int paramInt)
            {
              return (Seats)this.e.get(paramInt);
            }
            
            public int getSeatsCount()
            {
              return this.e.size();
            }
            
            public List<Seats> getSeatsList()
            {
              return this.e;
            }
            
            public int getSerializedSize()
            {
              int i = 0;
              if (hasUrl()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
              }
              int j = i;
              if (hasBuyStatus()) {
                j = i + CodedOutputStreamMicro.computeStringSize(2, getBuyStatus());
              }
              Iterator localIterator = getSeatsList().iterator();
              while (localIterator.hasNext()) {
                j = CodedOutputStreamMicro.computeMessageSize(3, (Seats)localIterator.next()) + j;
              }
              this.f = j;
              return j;
            }
            
            public String getUrl()
            {
              return this.b;
            }
            
            public boolean hasBuyStatus()
            {
              return this.c;
            }
            
            public boolean hasUrl()
            {
              return this.a;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Ticket mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  setUrl(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setBuyStatus(paramCodedInputStreamMicro.readString());
                  break;
                case 26: 
                  Seats localSeats = new Seats();
                  paramCodedInputStreamMicro.readMessage(localSeats);
                  addSeats(localSeats);
                }
              }
            }
            
            public Ticket setBuyStatus(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public Ticket setSeats(int paramInt, Seats paramSeats)
            {
              if (paramSeats == null) {
                return this;
              }
              this.e.set(paramInt, paramSeats);
              return this;
            }
            
            public Ticket setUrl(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasUrl()) {
                paramCodedOutputStreamMicro.writeString(1, getUrl());
              }
              if (hasBuyStatus()) {
                paramCodedOutputStreamMicro.writeString(2, getBuyStatus());
              }
              Iterator localIterator = getSeatsList().iterator();
              while (localIterator.hasNext()) {
                paramCodedOutputStreamMicro.writeMessage(3, (Seats)localIterator.next());
              }
            }
            
            public static final class Seats
              extends MessageMicro
            {
              public static final int NAME_FIELD_NUMBER = 1;
              public static final int PRICE_FIELD_NUMBER = 2;
              public static final int REMAIN_FIELD_NUMBER = 3;
              public static final int URL_FIELD_NUMBER = 4;
              private boolean a;
              private String b = "";
              private boolean c;
              private double d = 0.0D;
              private boolean e;
              private int f = 0;
              private boolean g;
              private String h = "";
              private int i = -1;
              
              public static Seats parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                throws IOException
              {
                return new Seats().mergeFrom(paramCodedInputStreamMicro);
              }
              
              public static Seats parseFrom(byte[] paramArrayOfByte)
                throws InvalidProtocolBufferMicroException
              {
                return (Seats)new Seats().mergeFrom(paramArrayOfByte);
              }
              
              public final Seats clear()
              {
                clearName();
                clearPrice();
                clearRemain();
                clearUrl();
                this.i = -1;
                return this;
              }
              
              public Seats clearName()
              {
                this.a = false;
                this.b = "";
                return this;
              }
              
              public Seats clearPrice()
              {
                this.c = false;
                this.d = 0.0D;
                return this;
              }
              
              public Seats clearRemain()
              {
                this.e = false;
                this.f = 0;
                return this;
              }
              
              public Seats clearUrl()
              {
                this.g = false;
                this.h = "";
                return this;
              }
              
              public int getCachedSize()
              {
                if (this.i < 0) {
                  getSerializedSize();
                }
                return this.i;
              }
              
              public String getName()
              {
                return this.b;
              }
              
              public double getPrice()
              {
                return this.d;
              }
              
              public int getRemain()
              {
                return this.f;
              }
              
              public int getSerializedSize()
              {
                int k = 0;
                if (hasName()) {
                  k = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                }
                int j = k;
                if (hasPrice()) {
                  j = k + CodedOutputStreamMicro.computeDoubleSize(2, getPrice());
                }
                k = j;
                if (hasRemain()) {
                  k = j + CodedOutputStreamMicro.computeInt32Size(3, getRemain());
                }
                j = k;
                if (hasUrl()) {
                  j = k + CodedOutputStreamMicro.computeStringSize(4, getUrl());
                }
                this.i = j;
                return j;
              }
              
              public String getUrl()
              {
                return this.h;
              }
              
              public boolean hasName()
              {
                return this.a;
              }
              
              public boolean hasPrice()
              {
                return this.c;
              }
              
              public boolean hasRemain()
              {
                return this.e;
              }
              
              public boolean hasUrl()
              {
                return this.g;
              }
              
              public final boolean isInitialized()
              {
                return true;
              }
              
              public Seats mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                    setName(paramCodedInputStreamMicro.readString());
                    break;
                  case 17: 
                    setPrice(paramCodedInputStreamMicro.readDouble());
                    break;
                  case 24: 
                    setRemain(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 34: 
                    setUrl(paramCodedInputStreamMicro.readString());
                  }
                }
              }
              
              public Seats setName(String paramString)
              {
                this.a = true;
                this.b = paramString;
                return this;
              }
              
              public Seats setPrice(double paramDouble)
              {
                this.c = true;
                this.d = paramDouble;
                return this;
              }
              
              public Seats setRemain(int paramInt)
              {
                this.e = true;
                this.f = paramInt;
                return this;
              }
              
              public Seats setUrl(String paramString)
              {
                this.g = true;
                this.h = paramString;
                return this;
              }
              
              public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
                throws IOException
              {
                if (hasName()) {
                  paramCodedOutputStreamMicro.writeString(1, getName());
                }
                if (hasPrice()) {
                  paramCodedOutputStreamMicro.writeDouble(2, getPrice());
                }
                if (hasRemain()) {
                  paramCodedOutputStreamMicro.writeInt32(3, getRemain());
                }
                if (hasUrl()) {
                  paramCodedOutputStreamMicro.writeString(4, getUrl());
                }
              }
            }
          }
          
          public static final class TransferDict
            extends MessageMicro
          {
            public static final int DATE_FIELD_NUMBER = 5;
            public static final int END_ADDRESS_FIELD_NUMBER = 4;
            public static final int PROVIDER_FIELD_NUMBER = 1;
            public static final int START_ADDRESS_FIELD_NUMBER = 3;
            public static final int TYPE_FIELD_NUMBER = 2;
            private boolean a;
            private String b = "";
            private boolean c;
            private int d = 0;
            private boolean e;
            private String f = "";
            private boolean g;
            private String h = "";
            private boolean i;
            private String j = "";
            private int k = -1;
            
            public static TransferDict parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new TransferDict().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static TransferDict parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (TransferDict)new TransferDict().mergeFrom(paramArrayOfByte);
            }
            
            public final TransferDict clear()
            {
              clearProvider();
              clearType();
              clearStartAddress();
              clearEndAddress();
              clearDate();
              this.k = -1;
              return this;
            }
            
            public TransferDict clearDate()
            {
              this.i = false;
              this.j = "";
              return this;
            }
            
            public TransferDict clearEndAddress()
            {
              this.g = false;
              this.h = "";
              return this;
            }
            
            public TransferDict clearProvider()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public TransferDict clearStartAddress()
            {
              this.e = false;
              this.f = "";
              return this;
            }
            
            public TransferDict clearType()
            {
              this.c = false;
              this.d = 0;
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.k < 0) {
                getSerializedSize();
              }
              return this.k;
            }
            
            public String getDate()
            {
              return this.j;
            }
            
            public String getEndAddress()
            {
              return this.h;
            }
            
            public String getProvider()
            {
              return this.b;
            }
            
            public int getSerializedSize()
            {
              int n = 0;
              if (hasProvider()) {
                n = 0 + CodedOutputStreamMicro.computeStringSize(1, getProvider());
              }
              int m = n;
              if (hasType()) {
                m = n + CodedOutputStreamMicro.computeInt32Size(2, getType());
              }
              n = m;
              if (hasStartAddress()) {
                n = m + CodedOutputStreamMicro.computeStringSize(3, getStartAddress());
              }
              m = n;
              if (hasEndAddress()) {
                m = n + CodedOutputStreamMicro.computeStringSize(4, getEndAddress());
              }
              n = m;
              if (hasDate()) {
                n = m + CodedOutputStreamMicro.computeStringSize(5, getDate());
              }
              this.k = n;
              return n;
            }
            
            public String getStartAddress()
            {
              return this.f;
            }
            
            public int getType()
            {
              return this.d;
            }
            
            public boolean hasDate()
            {
              return this.i;
            }
            
            public boolean hasEndAddress()
            {
              return this.g;
            }
            
            public boolean hasProvider()
            {
              return this.a;
            }
            
            public boolean hasStartAddress()
            {
              return this.e;
            }
            
            public boolean hasType()
            {
              return this.c;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public TransferDict mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              for (;;)
              {
                int m = paramCodedInputStreamMicro.readTag();
                switch (m)
                {
                default: 
                  if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
                  break;
                case 0: 
                  return this;
                case 10: 
                  setProvider(paramCodedInputStreamMicro.readString());
                  break;
                case 16: 
                  setType(paramCodedInputStreamMicro.readInt32());
                  break;
                case 26: 
                  setStartAddress(paramCodedInputStreamMicro.readString());
                  break;
                case 34: 
                  setEndAddress(paramCodedInputStreamMicro.readString());
                  break;
                case 42: 
                  setDate(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public TransferDict setDate(String paramString)
            {
              this.i = true;
              this.j = paramString;
              return this;
            }
            
            public TransferDict setEndAddress(String paramString)
            {
              this.g = true;
              this.h = paramString;
              return this;
            }
            
            public TransferDict setProvider(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public TransferDict setStartAddress(String paramString)
            {
              this.e = true;
              this.f = paramString;
              return this;
            }
            
            public TransferDict setType(int paramInt)
            {
              this.c = true;
              this.d = paramInt;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasProvider()) {
                paramCodedOutputStreamMicro.writeString(1, getProvider());
              }
              if (hasType()) {
                paramCodedOutputStreamMicro.writeInt32(2, getType());
              }
              if (hasStartAddress()) {
                paramCodedOutputStreamMicro.writeString(3, getStartAddress());
              }
              if (hasEndAddress()) {
                paramCodedOutputStreamMicro.writeString(4, getEndAddress());
              }
              if (hasDate()) {
                paramCodedOutputStreamMicro.writeString(5, getDate());
              }
            }
          }
          
          public static final class Vehicle
            extends MessageMicro
          {
            public static final int AREALINES_FIELD_NUMBER = 12;
            public static final int CP_FIELD_NUMBER = 16;
            public static final int DATE_FIELD_NUMBER = 13;
            public static final int DISCOUNT_FIELD_NUMBER = 14;
            public static final int END_CITY_NAME_FIELD_NUMBER = 35;
            public static final int END_CITY_UID_FIELD_NUMBER = 19;
            public static final int END_NAME_FIELD_NUMBER = 7;
            public static final int END_STATION_TYPE_FIELD_NUMBER = 25;
            public static final int END_TIME_FIELD_NUMBER = 5;
            public static final int END_UID_FIELD_NUMBER = 24;
            public static final int HEADWAY_FIELD_NUMBER = 33;
            public static final int IS_RTBUS_FIELD_NUMBER = 34;
            public static final int IS_SUPPORT_TICKET_FIELD_NUMBER = 29;
            public static final int LINESTATIONS_FIELD_NUMBER = 20;
            public static final int LINE_COLOR_FIELD_NUMBER = 32;
            public static final int LINE_TYPE_FIELD_NUMBER = 17;
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int NEXT_BUS_INFO_FIELD_NUMBER = 11;
            public static final int ORDER_URL_FIELD_NUMBER = 22;
            public static final int PRICE_FIELD_NUMBER = 15;
            public static final int PROVIDER_NAME_FIELD_NUMBER = 26;
            public static final int PROVIDER_URL_FIELD_NUMBER = 27;
            public static final int START_CITY_NAME_FIELD_NUMBER = 28;
            public static final int START_NAME_FIELD_NUMBER = 23;
            public static final int START_TIME_FIELD_NUMBER = 4;
            public static final int START_UID_FIELD_NUMBER = 6;
            public static final int START_WD_FIELD_NUMBER = 18;
            public static final int STOP_NUM_FIELD_NUMBER = 8;
            public static final int TELNUM_FIELD_NUMBER = 21;
            public static final int TICKET_URL_FIELD_NUMBER = 31;
            public static final int TOTAL_PRICE_FIELD_NUMBER = 9;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int ZONE_PRICE_FIELD_NUMBER = 10;
            private String A = "";
            private boolean B;
            private String C = "";
            private boolean D;
            private String E = "";
            private boolean F;
            private String G = "";
            private boolean H;
            private int I = 0;
            private boolean J;
            private String K = "";
            private boolean L;
            private String M = "";
            private boolean N;
            private String O = "";
            private boolean P;
            private String Q = "";
            private boolean R;
            private String S = "";
            private boolean T;
            private String U = "";
            private boolean V;
            private int W = 0;
            private boolean X;
            private String Y = "";
            private boolean Z;
            private boolean a;
            private String aa = "";
            private boolean ab;
            private String ac = "";
            private boolean ad;
            private int ae = 0;
            private boolean af;
            private String ag = "";
            private boolean ah;
            private String ai = "";
            private boolean aj;
            private String ak = "";
            private boolean al;
            private int am = 0;
            private boolean an;
            private String ao = "";
            private int ap = -1;
            private NextBusInfo b = null;
            private List<Linestations> c = Collections.emptyList();
            private boolean d;
            private String e = "";
            private boolean f;
            private int g = 0;
            private boolean h;
            private String i = "";
            private boolean j;
            private String k = "";
            private boolean l;
            private String m = "";
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
            private String y = "";
            private boolean z;
            
            public static Vehicle parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Vehicle().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Vehicle parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Vehicle)new Vehicle().mergeFrom(paramArrayOfByte);
            }
            
            public Vehicle addLinestations(Linestations paramLinestations)
            {
              if (paramLinestations == null) {
                return this;
              }
              if (this.c.isEmpty()) {
                this.c = new ArrayList();
              }
              this.c.add(paramLinestations);
              return this;
            }
            
            public final Vehicle clear()
            {
              clearNextBusInfo();
              clearLinestations();
              clearName();
              clearType();
              clearUid();
              clearStartTime();
              clearEndTime();
              clearStartUid();
              clearEndName();
              clearStopNum();
              clearTotalPrice();
              clearZonePrice();
              clearArealines();
              clearDate();
              clearDiscount();
              clearPrice();
              clearCp();
              clearLineType();
              clearStartWd();
              clearEndCityUid();
              clearTelnum();
              clearOrderUrl();
              clearStartName();
              clearEndUid();
              clearEndStationType();
              clearProviderName();
              clearProviderUrl();
              clearStartCityName();
              clearIsSupportTicket();
              clearTicketUrl();
              clearLineColor();
              clearHeadway();
              clearIsRtbus();
              clearEndCityName();
              this.ap = -1;
              return this;
            }
            
            public Vehicle clearArealines()
            {
              this.x = false;
              this.y = "";
              return this;
            }
            
            public Vehicle clearCp()
            {
              this.F = false;
              this.G = "";
              return this;
            }
            
            public Vehicle clearDate()
            {
              this.z = false;
              this.A = "";
              return this;
            }
            
            public Vehicle clearDiscount()
            {
              this.B = false;
              this.C = "";
              return this;
            }
            
            public Vehicle clearEndCityName()
            {
              this.an = false;
              this.ao = "";
              return this;
            }
            
            public Vehicle clearEndCityUid()
            {
              this.L = false;
              this.M = "";
              return this;
            }
            
            public Vehicle clearEndName()
            {
              this.p = false;
              this.q = "";
              return this;
            }
            
            public Vehicle clearEndStationType()
            {
              this.V = false;
              this.W = 0;
              return this;
            }
            
            public Vehicle clearEndTime()
            {
              this.l = false;
              this.m = "";
              return this;
            }
            
            public Vehicle clearEndUid()
            {
              this.T = false;
              this.U = "";
              return this;
            }
            
            public Vehicle clearHeadway()
            {
              this.aj = false;
              this.ak = "";
              return this;
            }
            
            public Vehicle clearIsRtbus()
            {
              this.al = false;
              this.am = 0;
              return this;
            }
            
            public Vehicle clearIsSupportTicket()
            {
              this.ad = false;
              this.ae = 0;
              return this;
            }
            
            public Vehicle clearLineColor()
            {
              this.ah = false;
              this.ai = "";
              return this;
            }
            
            public Vehicle clearLineType()
            {
              this.H = false;
              this.I = 0;
              return this;
            }
            
            public Vehicle clearLinestations()
            {
              this.c = Collections.emptyList();
              return this;
            }
            
            public Vehicle clearName()
            {
              this.d = false;
              this.e = "";
              return this;
            }
            
            public Vehicle clearNextBusInfo()
            {
              this.a = false;
              this.b = null;
              return this;
            }
            
            public Vehicle clearOrderUrl()
            {
              this.P = false;
              this.Q = "";
              return this;
            }
            
            public Vehicle clearPrice()
            {
              this.D = false;
              this.E = "";
              return this;
            }
            
            public Vehicle clearProviderName()
            {
              this.X = false;
              this.Y = "";
              return this;
            }
            
            public Vehicle clearProviderUrl()
            {
              this.Z = false;
              this.aa = "";
              return this;
            }
            
            public Vehicle clearStartCityName()
            {
              this.ab = false;
              this.ac = "";
              return this;
            }
            
            public Vehicle clearStartName()
            {
              this.R = false;
              this.S = "";
              return this;
            }
            
            public Vehicle clearStartTime()
            {
              this.j = false;
              this.k = "";
              return this;
            }
            
            public Vehicle clearStartUid()
            {
              this.n = false;
              this.o = "";
              return this;
            }
            
            public Vehicle clearStartWd()
            {
              this.J = false;
              this.K = "";
              return this;
            }
            
            public Vehicle clearStopNum()
            {
              this.r = false;
              this.s = 0;
              return this;
            }
            
            public Vehicle clearTelnum()
            {
              this.N = false;
              this.O = "";
              return this;
            }
            
            public Vehicle clearTicketUrl()
            {
              this.af = false;
              this.ag = "";
              return this;
            }
            
            public Vehicle clearTotalPrice()
            {
              this.t = false;
              this.u = 0;
              return this;
            }
            
            public Vehicle clearType()
            {
              this.f = false;
              this.g = 0;
              return this;
            }
            
            public Vehicle clearUid()
            {
              this.h = false;
              this.i = "";
              return this;
            }
            
            public Vehicle clearZonePrice()
            {
              this.v = false;
              this.w = 0;
              return this;
            }
            
            public String getArealines()
            {
              return this.y;
            }
            
            public int getCachedSize()
            {
              if (this.ap < 0) {
                getSerializedSize();
              }
              return this.ap;
            }
            
            public String getCp()
            {
              return this.G;
            }
            
            public String getDate()
            {
              return this.A;
            }
            
            public String getDiscount()
            {
              return this.C;
            }
            
            public String getEndCityName()
            {
              return this.ao;
            }
            
            public String getEndCityUid()
            {
              return this.M;
            }
            
            public String getEndName()
            {
              return this.q;
            }
            
            public int getEndStationType()
            {
              return this.W;
            }
            
            public String getEndTime()
            {
              return this.m;
            }
            
            public String getEndUid()
            {
              return this.U;
            }
            
            public String getHeadway()
            {
              return this.ak;
            }
            
            public int getIsRtbus()
            {
              return this.am;
            }
            
            public int getIsSupportTicket()
            {
              return this.ae;
            }
            
            public String getLineColor()
            {
              return this.ai;
            }
            
            public int getLineType()
            {
              return this.I;
            }
            
            public Linestations getLinestations(int paramInt)
            {
              return (Linestations)this.c.get(paramInt);
            }
            
            public int getLinestationsCount()
            {
              return this.c.size();
            }
            
            public List<Linestations> getLinestationsList()
            {
              return this.c;
            }
            
            public String getName()
            {
              return this.e;
            }
            
            public NextBusInfo getNextBusInfo()
            {
              return this.b;
            }
            
            public String getOrderUrl()
            {
              return this.Q;
            }
            
            public String getPrice()
            {
              return this.E;
            }
            
            public String getProviderName()
            {
              return this.Y;
            }
            
            public String getProviderUrl()
            {
              return this.aa;
            }
            
            public int getSerializedSize()
            {
              int i2 = 0;
              if (hasName()) {
                i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
              }
              int i1 = i2;
              if (hasType()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getType());
              }
              i2 = i1;
              if (hasUid()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getUid());
              }
              i1 = i2;
              if (hasStartTime()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getStartTime());
              }
              i2 = i1;
              if (hasEndTime()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getEndTime());
              }
              i1 = i2;
              if (hasStartUid()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getStartUid());
              }
              i2 = i1;
              if (hasEndName()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getEndName());
              }
              i1 = i2;
              if (hasStopNum()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getStopNum());
              }
              i2 = i1;
              if (hasTotalPrice()) {
                i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getTotalPrice());
              }
              i1 = i2;
              if (hasZonePrice()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getZonePrice());
              }
              i2 = i1;
              if (hasNextBusInfo()) {
                i2 = i1 + CodedOutputStreamMicro.computeMessageSize(11, getNextBusInfo());
              }
              i1 = i2;
              if (hasArealines()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getArealines());
              }
              i2 = i1;
              if (hasDate()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getDate());
              }
              i1 = i2;
              if (hasDiscount()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getDiscount());
              }
              i2 = i1;
              if (hasPrice()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getPrice());
              }
              i1 = i2;
              if (hasCp()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getCp());
              }
              i2 = i1;
              if (hasLineType()) {
                i2 = i1 + CodedOutputStreamMicro.computeInt32Size(17, getLineType());
              }
              i1 = i2;
              if (hasStartWd()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getStartWd());
              }
              i2 = i1;
              if (hasEndCityUid()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(19, getEndCityUid());
              }
              Iterator localIterator = getLinestationsList().iterator();
              while (localIterator.hasNext()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(20, (Linestations)localIterator.next()) + i2;
              }
              i1 = i2;
              if (hasTelnum()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(21, getTelnum());
              }
              i2 = i1;
              if (hasOrderUrl()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(22, getOrderUrl());
              }
              i1 = i2;
              if (hasStartName()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(23, getStartName());
              }
              i2 = i1;
              if (hasEndUid()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(24, getEndUid());
              }
              i1 = i2;
              if (hasEndStationType()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(25, getEndStationType());
              }
              i2 = i1;
              if (hasProviderName()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(26, getProviderName());
              }
              i1 = i2;
              if (hasProviderUrl()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(27, getProviderUrl());
              }
              i2 = i1;
              if (hasStartCityName()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(28, getStartCityName());
              }
              i1 = i2;
              if (hasIsSupportTicket()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(29, getIsSupportTicket());
              }
              i2 = i1;
              if (hasTicketUrl()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(31, getTicketUrl());
              }
              i1 = i2;
              if (hasLineColor()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(32, getLineColor());
              }
              i2 = i1;
              if (hasHeadway()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(33, getHeadway());
              }
              i1 = i2;
              if (hasIsRtbus()) {
                i1 = i2 + CodedOutputStreamMicro.computeInt32Size(34, getIsRtbus());
              }
              i2 = i1;
              if (hasEndCityName()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(35, getEndCityName());
              }
              this.ap = i2;
              return i2;
            }
            
            public String getStartCityName()
            {
              return this.ac;
            }
            
            public String getStartName()
            {
              return this.S;
            }
            
            public String getStartTime()
            {
              return this.k;
            }
            
            public String getStartUid()
            {
              return this.o;
            }
            
            public String getStartWd()
            {
              return this.K;
            }
            
            public int getStopNum()
            {
              return this.s;
            }
            
            public String getTelnum()
            {
              return this.O;
            }
            
            public String getTicketUrl()
            {
              return this.ag;
            }
            
            public int getTotalPrice()
            {
              return this.u;
            }
            
            public int getType()
            {
              return this.g;
            }
            
            public String getUid()
            {
              return this.i;
            }
            
            public int getZonePrice()
            {
              return this.w;
            }
            
            public boolean hasArealines()
            {
              return this.x;
            }
            
            public boolean hasCp()
            {
              return this.F;
            }
            
            public boolean hasDate()
            {
              return this.z;
            }
            
            public boolean hasDiscount()
            {
              return this.B;
            }
            
            public boolean hasEndCityName()
            {
              return this.an;
            }
            
            public boolean hasEndCityUid()
            {
              return this.L;
            }
            
            public boolean hasEndName()
            {
              return this.p;
            }
            
            public boolean hasEndStationType()
            {
              return this.V;
            }
            
            public boolean hasEndTime()
            {
              return this.l;
            }
            
            public boolean hasEndUid()
            {
              return this.T;
            }
            
            public boolean hasHeadway()
            {
              return this.aj;
            }
            
            public boolean hasIsRtbus()
            {
              return this.al;
            }
            
            public boolean hasIsSupportTicket()
            {
              return this.ad;
            }
            
            public boolean hasLineColor()
            {
              return this.ah;
            }
            
            public boolean hasLineType()
            {
              return this.H;
            }
            
            public boolean hasName()
            {
              return this.d;
            }
            
            public boolean hasNextBusInfo()
            {
              return this.a;
            }
            
            public boolean hasOrderUrl()
            {
              return this.P;
            }
            
            public boolean hasPrice()
            {
              return this.D;
            }
            
            public boolean hasProviderName()
            {
              return this.X;
            }
            
            public boolean hasProviderUrl()
            {
              return this.Z;
            }
            
            public boolean hasStartCityName()
            {
              return this.ab;
            }
            
            public boolean hasStartName()
            {
              return this.R;
            }
            
            public boolean hasStartTime()
            {
              return this.j;
            }
            
            public boolean hasStartUid()
            {
              return this.n;
            }
            
            public boolean hasStartWd()
            {
              return this.J;
            }
            
            public boolean hasStopNum()
            {
              return this.r;
            }
            
            public boolean hasTelnum()
            {
              return this.N;
            }
            
            public boolean hasTicketUrl()
            {
              return this.af;
            }
            
            public boolean hasTotalPrice()
            {
              return this.t;
            }
            
            public boolean hasType()
            {
              return this.f;
            }
            
            public boolean hasUid()
            {
              return this.h;
            }
            
            public boolean hasZonePrice()
            {
              return this.v;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Vehicle mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                case 16: 
                  setType(paramCodedInputStreamMicro.readInt32());
                  break;
                case 26: 
                  setUid(paramCodedInputStreamMicro.readString());
                  break;
                case 34: 
                  setStartTime(paramCodedInputStreamMicro.readString());
                  break;
                case 42: 
                  setEndTime(paramCodedInputStreamMicro.readString());
                  break;
                case 50: 
                  setStartUid(paramCodedInputStreamMicro.readString());
                  break;
                case 58: 
                  setEndName(paramCodedInputStreamMicro.readString());
                  break;
                case 64: 
                  setStopNum(paramCodedInputStreamMicro.readInt32());
                  break;
                case 72: 
                  setTotalPrice(paramCodedInputStreamMicro.readInt32());
                  break;
                case 80: 
                  setZonePrice(paramCodedInputStreamMicro.readInt32());
                  break;
                case 90: 
                  localObject = new NextBusInfo();
                  paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                  setNextBusInfo((NextBusInfo)localObject);
                  break;
                case 98: 
                  setArealines(paramCodedInputStreamMicro.readString());
                  break;
                case 106: 
                  setDate(paramCodedInputStreamMicro.readString());
                  break;
                case 114: 
                  setDiscount(paramCodedInputStreamMicro.readString());
                  break;
                case 122: 
                  setPrice(paramCodedInputStreamMicro.readString());
                  break;
                case 130: 
                  setCp(paramCodedInputStreamMicro.readString());
                  break;
                case 136: 
                  setLineType(paramCodedInputStreamMicro.readInt32());
                  break;
                case 146: 
                  setStartWd(paramCodedInputStreamMicro.readString());
                  break;
                case 154: 
                  setEndCityUid(paramCodedInputStreamMicro.readString());
                  break;
                case 162: 
                  localObject = new Linestations();
                  paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                  addLinestations((Linestations)localObject);
                  break;
                case 170: 
                  setTelnum(paramCodedInputStreamMicro.readString());
                  break;
                case 178: 
                  setOrderUrl(paramCodedInputStreamMicro.readString());
                  break;
                case 186: 
                  setStartName(paramCodedInputStreamMicro.readString());
                  break;
                case 194: 
                  setEndUid(paramCodedInputStreamMicro.readString());
                  break;
                case 200: 
                  setEndStationType(paramCodedInputStreamMicro.readInt32());
                  break;
                case 210: 
                  setProviderName(paramCodedInputStreamMicro.readString());
                  break;
                case 218: 
                  setProviderUrl(paramCodedInputStreamMicro.readString());
                  break;
                case 226: 
                  setStartCityName(paramCodedInputStreamMicro.readString());
                  break;
                case 232: 
                  setIsSupportTicket(paramCodedInputStreamMicro.readInt32());
                  break;
                case 250: 
                  setTicketUrl(paramCodedInputStreamMicro.readString());
                  break;
                case 258: 
                  setLineColor(paramCodedInputStreamMicro.readString());
                  break;
                case 266: 
                  setHeadway(paramCodedInputStreamMicro.readString());
                  break;
                case 272: 
                  setIsRtbus(paramCodedInputStreamMicro.readInt32());
                  break;
                case 282: 
                  setEndCityName(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public Vehicle setArealines(String paramString)
            {
              this.x = true;
              this.y = paramString;
              return this;
            }
            
            public Vehicle setCp(String paramString)
            {
              this.F = true;
              this.G = paramString;
              return this;
            }
            
            public Vehicle setDate(String paramString)
            {
              this.z = true;
              this.A = paramString;
              return this;
            }
            
            public Vehicle setDiscount(String paramString)
            {
              this.B = true;
              this.C = paramString;
              return this;
            }
            
            public Vehicle setEndCityName(String paramString)
            {
              this.an = true;
              this.ao = paramString;
              return this;
            }
            
            public Vehicle setEndCityUid(String paramString)
            {
              this.L = true;
              this.M = paramString;
              return this;
            }
            
            public Vehicle setEndName(String paramString)
            {
              this.p = true;
              this.q = paramString;
              return this;
            }
            
            public Vehicle setEndStationType(int paramInt)
            {
              this.V = true;
              this.W = paramInt;
              return this;
            }
            
            public Vehicle setEndTime(String paramString)
            {
              this.l = true;
              this.m = paramString;
              return this;
            }
            
            public Vehicle setEndUid(String paramString)
            {
              this.T = true;
              this.U = paramString;
              return this;
            }
            
            public Vehicle setHeadway(String paramString)
            {
              this.aj = true;
              this.ak = paramString;
              return this;
            }
            
            public Vehicle setIsRtbus(int paramInt)
            {
              this.al = true;
              this.am = paramInt;
              return this;
            }
            
            public Vehicle setIsSupportTicket(int paramInt)
            {
              this.ad = true;
              this.ae = paramInt;
              return this;
            }
            
            public Vehicle setLineColor(String paramString)
            {
              this.ah = true;
              this.ai = paramString;
              return this;
            }
            
            public Vehicle setLineType(int paramInt)
            {
              this.H = true;
              this.I = paramInt;
              return this;
            }
            
            public Vehicle setLinestations(int paramInt, Linestations paramLinestations)
            {
              if (paramLinestations == null) {
                return this;
              }
              this.c.set(paramInt, paramLinestations);
              return this;
            }
            
            public Vehicle setName(String paramString)
            {
              this.d = true;
              this.e = paramString;
              return this;
            }
            
            public Vehicle setNextBusInfo(NextBusInfo paramNextBusInfo)
            {
              if (paramNextBusInfo == null) {
                return clearNextBusInfo();
              }
              this.a = true;
              this.b = paramNextBusInfo;
              return this;
            }
            
            public Vehicle setOrderUrl(String paramString)
            {
              this.P = true;
              this.Q = paramString;
              return this;
            }
            
            public Vehicle setPrice(String paramString)
            {
              this.D = true;
              this.E = paramString;
              return this;
            }
            
            public Vehicle setProviderName(String paramString)
            {
              this.X = true;
              this.Y = paramString;
              return this;
            }
            
            public Vehicle setProviderUrl(String paramString)
            {
              this.Z = true;
              this.aa = paramString;
              return this;
            }
            
            public Vehicle setStartCityName(String paramString)
            {
              this.ab = true;
              this.ac = paramString;
              return this;
            }
            
            public Vehicle setStartName(String paramString)
            {
              this.R = true;
              this.S = paramString;
              return this;
            }
            
            public Vehicle setStartTime(String paramString)
            {
              this.j = true;
              this.k = paramString;
              return this;
            }
            
            public Vehicle setStartUid(String paramString)
            {
              this.n = true;
              this.o = paramString;
              return this;
            }
            
            public Vehicle setStartWd(String paramString)
            {
              this.J = true;
              this.K = paramString;
              return this;
            }
            
            public Vehicle setStopNum(int paramInt)
            {
              this.r = true;
              this.s = paramInt;
              return this;
            }
            
            public Vehicle setTelnum(String paramString)
            {
              this.N = true;
              this.O = paramString;
              return this;
            }
            
            public Vehicle setTicketUrl(String paramString)
            {
              this.af = true;
              this.ag = paramString;
              return this;
            }
            
            public Vehicle setTotalPrice(int paramInt)
            {
              this.t = true;
              this.u = paramInt;
              return this;
            }
            
            public Vehicle setType(int paramInt)
            {
              this.f = true;
              this.g = paramInt;
              return this;
            }
            
            public Vehicle setUid(String paramString)
            {
              this.h = true;
              this.i = paramString;
              return this;
            }
            
            public Vehicle setZonePrice(int paramInt)
            {
              this.v = true;
              this.w = paramInt;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasName()) {
                paramCodedOutputStreamMicro.writeString(1, getName());
              }
              if (hasType()) {
                paramCodedOutputStreamMicro.writeInt32(2, getType());
              }
              if (hasUid()) {
                paramCodedOutputStreamMicro.writeString(3, getUid());
              }
              if (hasStartTime()) {
                paramCodedOutputStreamMicro.writeString(4, getStartTime());
              }
              if (hasEndTime()) {
                paramCodedOutputStreamMicro.writeString(5, getEndTime());
              }
              if (hasStartUid()) {
                paramCodedOutputStreamMicro.writeString(6, getStartUid());
              }
              if (hasEndName()) {
                paramCodedOutputStreamMicro.writeString(7, getEndName());
              }
              if (hasStopNum()) {
                paramCodedOutputStreamMicro.writeInt32(8, getStopNum());
              }
              if (hasTotalPrice()) {
                paramCodedOutputStreamMicro.writeInt32(9, getTotalPrice());
              }
              if (hasZonePrice()) {
                paramCodedOutputStreamMicro.writeInt32(10, getZonePrice());
              }
              if (hasNextBusInfo()) {
                paramCodedOutputStreamMicro.writeMessage(11, getNextBusInfo());
              }
              if (hasArealines()) {
                paramCodedOutputStreamMicro.writeString(12, getArealines());
              }
              if (hasDate()) {
                paramCodedOutputStreamMicro.writeString(13, getDate());
              }
              if (hasDiscount()) {
                paramCodedOutputStreamMicro.writeString(14, getDiscount());
              }
              if (hasPrice()) {
                paramCodedOutputStreamMicro.writeString(15, getPrice());
              }
              if (hasCp()) {
                paramCodedOutputStreamMicro.writeString(16, getCp());
              }
              if (hasLineType()) {
                paramCodedOutputStreamMicro.writeInt32(17, getLineType());
              }
              if (hasStartWd()) {
                paramCodedOutputStreamMicro.writeString(18, getStartWd());
              }
              if (hasEndCityUid()) {
                paramCodedOutputStreamMicro.writeString(19, getEndCityUid());
              }
              Iterator localIterator = getLinestationsList().iterator();
              while (localIterator.hasNext()) {
                paramCodedOutputStreamMicro.writeMessage(20, (Linestations)localIterator.next());
              }
              if (hasTelnum()) {
                paramCodedOutputStreamMicro.writeString(21, getTelnum());
              }
              if (hasOrderUrl()) {
                paramCodedOutputStreamMicro.writeString(22, getOrderUrl());
              }
              if (hasStartName()) {
                paramCodedOutputStreamMicro.writeString(23, getStartName());
              }
              if (hasEndUid()) {
                paramCodedOutputStreamMicro.writeString(24, getEndUid());
              }
              if (hasEndStationType()) {
                paramCodedOutputStreamMicro.writeInt32(25, getEndStationType());
              }
              if (hasProviderName()) {
                paramCodedOutputStreamMicro.writeString(26, getProviderName());
              }
              if (hasProviderUrl()) {
                paramCodedOutputStreamMicro.writeString(27, getProviderUrl());
              }
              if (hasStartCityName()) {
                paramCodedOutputStreamMicro.writeString(28, getStartCityName());
              }
              if (hasIsSupportTicket()) {
                paramCodedOutputStreamMicro.writeInt32(29, getIsSupportTicket());
              }
              if (hasTicketUrl()) {
                paramCodedOutputStreamMicro.writeString(31, getTicketUrl());
              }
              if (hasLineColor()) {
                paramCodedOutputStreamMicro.writeString(32, getLineColor());
              }
              if (hasHeadway()) {
                paramCodedOutputStreamMicro.writeString(33, getHeadway());
              }
              if (hasIsRtbus()) {
                paramCodedOutputStreamMicro.writeInt32(34, getIsRtbus());
              }
              if (hasEndCityName()) {
                paramCodedOutputStreamMicro.writeString(35, getEndCityName());
              }
            }
            
            public static final class Linestations
              extends MessageMicro
            {
              public static final int GEO_FIELD_NUMBER = 3;
              public static final int NAME_FIELD_NUMBER = 1;
              public static final int SGEO_FIELD_NUMBER = 4;
              public static final int START_TIME_FIELD_NUMBER = 2;
              private boolean a;
              private String b = "";
              private boolean c;
              private String d = "";
              private boolean e;
              private String f = "";
              private List<Integer> g = Collections.emptyList();
              private int h = -1;
              
              public static Linestations parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                throws IOException
              {
                return new Linestations().mergeFrom(paramCodedInputStreamMicro);
              }
              
              public static Linestations parseFrom(byte[] paramArrayOfByte)
                throws InvalidProtocolBufferMicroException
              {
                return (Linestations)new Linestations().mergeFrom(paramArrayOfByte);
              }
              
              public Linestations addSgeo(int paramInt)
              {
                if (this.g.isEmpty()) {
                  this.g = new ArrayList();
                }
                this.g.add(Integer.valueOf(paramInt));
                return this;
              }
              
              public final Linestations clear()
              {
                clearName();
                clearStartTime();
                clearGeo();
                clearSgeo();
                this.h = -1;
                return this;
              }
              
              public Linestations clearGeo()
              {
                this.e = false;
                this.f = "";
                return this;
              }
              
              public Linestations clearName()
              {
                this.a = false;
                this.b = "";
                return this;
              }
              
              public Linestations clearSgeo()
              {
                this.g = Collections.emptyList();
                return this;
              }
              
              public Linestations clearStartTime()
              {
                this.c = false;
                this.d = "";
                return this;
              }
              
              public int getCachedSize()
              {
                if (this.h < 0) {
                  getSerializedSize();
                }
                return this.h;
              }
              
              public String getGeo()
              {
                return this.f;
              }
              
              public String getName()
              {
                return this.b;
              }
              
              public int getSerializedSize()
              {
                int k = 0;
                if (hasName()) {}
                for (int i = CodedOutputStreamMicro.computeStringSize(1, getName()) + 0;; i = 0)
                {
                  int j = i;
                  if (hasStartTime()) {
                    j = i + CodedOutputStreamMicro.computeStringSize(2, getStartTime());
                  }
                  if (hasGeo()) {}
                  for (i = j + CodedOutputStreamMicro.computeStringSize(3, getGeo());; i = j)
                  {
                    Iterator localIterator = getSgeoList().iterator();
                    j = k;
                    while (localIterator.hasNext()) {
                      j += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
                    }
                    i = i + j + getSgeoList().size() * 1;
                    this.h = i;
                    return i;
                  }
                }
              }
              
              public int getSgeo(int paramInt)
              {
                return ((Integer)this.g.get(paramInt)).intValue();
              }
              
              public int getSgeoCount()
              {
                return this.g.size();
              }
              
              public List<Integer> getSgeoList()
              {
                return this.g;
              }
              
              public String getStartTime()
              {
                return this.d;
              }
              
              public boolean hasGeo()
              {
                return this.e;
              }
              
              public boolean hasName()
              {
                return this.a;
              }
              
              public boolean hasStartTime()
              {
                return this.c;
              }
              
              public final boolean isInitialized()
              {
                return true;
              }
              
              public Linestations mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                    setStartTime(paramCodedInputStreamMicro.readString());
                    break;
                  case 26: 
                    setGeo(paramCodedInputStreamMicro.readString());
                    break;
                  case 32: 
                    addSgeo(paramCodedInputStreamMicro.readSInt32());
                  }
                }
              }
              
              public Linestations setGeo(String paramString)
              {
                this.e = true;
                this.f = paramString;
                return this;
              }
              
              public Linestations setName(String paramString)
              {
                this.a = true;
                this.b = paramString;
                return this;
              }
              
              public Linestations setSgeo(int paramInt1, int paramInt2)
              {
                this.g.set(paramInt1, Integer.valueOf(paramInt2));
                return this;
              }
              
              public Linestations setStartTime(String paramString)
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
                if (hasStartTime()) {
                  paramCodedOutputStreamMicro.writeString(2, getStartTime());
                }
                if (hasGeo()) {
                  paramCodedOutputStreamMicro.writeString(3, getGeo());
                }
                Iterator localIterator = getSgeoList().iterator();
                while (localIterator.hasNext()) {
                  paramCodedOutputStreamMicro.writeSInt32(4, ((Integer)localIterator.next()).intValue());
                }
              }
            }
            
            public static final class NextBusInfo
              extends MessageMicro
            {
              public static final int REMAIN_DIS_FIELD_NUMBER = 2;
              public static final int REMAIN_STOPS_FIELD_NUMBER = 3;
              public static final int REMAIN_TIME_FIELD_NUMBER = 1;
              public static final int SPATH_FIELD_NUMBER = 6;
              public static final int X_FIELD_NUMBER = 4;
              public static final int Y_FIELD_NUMBER = 5;
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
              private List<Integer> k = Collections.emptyList();
              private int l = -1;
              
              public static NextBusInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                throws IOException
              {
                return new NextBusInfo().mergeFrom(paramCodedInputStreamMicro);
              }
              
              public static NextBusInfo parseFrom(byte[] paramArrayOfByte)
                throws InvalidProtocolBufferMicroException
              {
                return (NextBusInfo)new NextBusInfo().mergeFrom(paramArrayOfByte);
              }
              
              public NextBusInfo addSpath(int paramInt)
              {
                if (this.k.isEmpty()) {
                  this.k = new ArrayList();
                }
                this.k.add(Integer.valueOf(paramInt));
                return this;
              }
              
              public final NextBusInfo clear()
              {
                clearRemainTime();
                clearRemainDis();
                clearRemainStops();
                clearX();
                clearY();
                clearSpath();
                this.l = -1;
                return this;
              }
              
              public NextBusInfo clearRemainDis()
              {
                this.c = false;
                this.d = 0;
                return this;
              }
              
              public NextBusInfo clearRemainStops()
              {
                this.e = false;
                this.f = 0;
                return this;
              }
              
              public NextBusInfo clearRemainTime()
              {
                this.a = false;
                this.b = 0;
                return this;
              }
              
              public NextBusInfo clearSpath()
              {
                this.k = Collections.emptyList();
                return this;
              }
              
              public NextBusInfo clearX()
              {
                this.g = false;
                this.h = 0;
                return this;
              }
              
              public NextBusInfo clearY()
              {
                this.i = false;
                this.j = 0;
                return this;
              }
              
              public int getCachedSize()
              {
                if (this.l < 0) {
                  getSerializedSize();
                }
                return this.l;
              }
              
              public int getRemainDis()
              {
                return this.d;
              }
              
              public int getRemainStops()
              {
                return this.f;
              }
              
              public int getRemainTime()
              {
                return this.b;
              }
              
              public int getSerializedSize()
              {
                int i1 = 0;
                if (hasRemainTime()) {}
                for (int n = CodedOutputStreamMicro.computeInt32Size(1, getRemainTime()) + 0;; n = 0)
                {
                  int m = n;
                  if (hasRemainDis()) {
                    m = n + CodedOutputStreamMicro.computeInt32Size(2, getRemainDis());
                  }
                  n = m;
                  if (hasRemainStops()) {
                    n = m + CodedOutputStreamMicro.computeInt32Size(3, getRemainStops());
                  }
                  m = n;
                  if (hasX()) {
                    m = n + CodedOutputStreamMicro.computeSInt32Size(4, getX());
                  }
                  if (hasY()) {
                    m += CodedOutputStreamMicro.computeSInt32Size(5, getY());
                  }
                  for (;;)
                  {
                    Iterator localIterator = getSpathList().iterator();
                    n = i1;
                    while (localIterator.hasNext()) {
                      n += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
                    }
                    m = m + n + getSpathList().size() * 1;
                    this.l = m;
                    return m;
                  }
                }
              }
              
              public int getSpath(int paramInt)
              {
                return ((Integer)this.k.get(paramInt)).intValue();
              }
              
              public int getSpathCount()
              {
                return this.k.size();
              }
              
              public List<Integer> getSpathList()
              {
                return this.k;
              }
              
              public int getX()
              {
                return this.h;
              }
              
              public int getY()
              {
                return this.j;
              }
              
              public boolean hasRemainDis()
              {
                return this.c;
              }
              
              public boolean hasRemainStops()
              {
                return this.e;
              }
              
              public boolean hasRemainTime()
              {
                return this.a;
              }
              
              public boolean hasX()
              {
                return this.g;
              }
              
              public boolean hasY()
              {
                return this.i;
              }
              
              public final boolean isInitialized()
              {
                return true;
              }
              
              public NextBusInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
                throws IOException
              {
                for (;;)
                {
                  int m = paramCodedInputStreamMicro.readTag();
                  switch (m)
                  {
                  default: 
                    if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
                    break;
                  case 0: 
                    return this;
                  case 8: 
                    setRemainTime(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 16: 
                    setRemainDis(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 24: 
                    setRemainStops(paramCodedInputStreamMicro.readInt32());
                    break;
                  case 32: 
                    setX(paramCodedInputStreamMicro.readSInt32());
                    break;
                  case 40: 
                    setY(paramCodedInputStreamMicro.readSInt32());
                    break;
                  case 48: 
                    addSpath(paramCodedInputStreamMicro.readSInt32());
                  }
                }
              }
              
              public NextBusInfo setRemainDis(int paramInt)
              {
                this.c = true;
                this.d = paramInt;
                return this;
              }
              
              public NextBusInfo setRemainStops(int paramInt)
              {
                this.e = true;
                this.f = paramInt;
                return this;
              }
              
              public NextBusInfo setRemainTime(int paramInt)
              {
                this.a = true;
                this.b = paramInt;
                return this;
              }
              
              public NextBusInfo setSpath(int paramInt1, int paramInt2)
              {
                this.k.set(paramInt1, Integer.valueOf(paramInt2));
                return this;
              }
              
              public NextBusInfo setX(int paramInt)
              {
                this.g = true;
                this.h = paramInt;
                return this;
              }
              
              public NextBusInfo setY(int paramInt)
              {
                this.i = true;
                this.j = paramInt;
                return this;
              }
              
              public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
                throws IOException
              {
                if (hasRemainTime()) {
                  paramCodedOutputStreamMicro.writeInt32(1, getRemainTime());
                }
                if (hasRemainDis()) {
                  paramCodedOutputStreamMicro.writeInt32(2, getRemainDis());
                }
                if (hasRemainStops()) {
                  paramCodedOutputStreamMicro.writeInt32(3, getRemainStops());
                }
                if (hasX()) {
                  paramCodedOutputStreamMicro.writeSInt32(4, getX());
                }
                if (hasY()) {
                  paramCodedOutputStreamMicro.writeSInt32(5, getY());
                }
                Iterator localIterator = getSpathList().iterator();
                while (localIterator.hasNext()) {
                  paramCodedOutputStreamMicro.writeSInt32(6, ((Integer)localIterator.next()).intValue());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static final class Taxi
    extends MessageMicro
  {
    public static final int DETAIL_FIELD_NUMBER = 4;
    public static final int DISTANCE_FIELD_NUMBER = 1;
    public static final int DURATION_FIELD_NUMBER = 2;
    public static final int REMARK_FIELD_NUMBER = 3;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private String f = "";
    private List<Detail> g = Collections.emptyList();
    private int h = -1;
    
    public static Taxi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Taxi().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Taxi parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Taxi)new Taxi().mergeFrom(paramArrayOfByte);
    }
    
    public Taxi addDetail(Detail paramDetail)
    {
      if (paramDetail == null) {
        return this;
      }
      if (this.g.isEmpty()) {
        this.g = new ArrayList();
      }
      this.g.add(paramDetail);
      return this;
    }
    
    public final Taxi clear()
    {
      clearDistance();
      clearDuration();
      clearRemark();
      clearDetail();
      this.h = -1;
      return this;
    }
    
    public Taxi clearDetail()
    {
      this.g = Collections.emptyList();
      return this;
    }
    
    public Taxi clearDistance()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Taxi clearDuration()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Taxi clearRemark()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.h < 0) {
        getSerializedSize();
      }
      return this.h;
    }
    
    public Detail getDetail(int paramInt)
    {
      return (Detail)this.g.get(paramInt);
    }
    
    public int getDetailCount()
    {
      return this.g.size();
    }
    
    public List<Detail> getDetailList()
    {
      return this.g;
    }
    
    public int getDistance()
    {
      return this.b;
    }
    
    public int getDuration()
    {
      return this.d;
    }
    
    public String getRemark()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasDistance()) {
        j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
      }
      int i = j;
      if (hasDuration()) {
        i = j + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
      }
      j = i;
      if (hasRemark()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getRemark());
      }
      Iterator localIterator = getDetailList().iterator();
      while (localIterator.hasNext()) {
        j = CodedOutputStreamMicro.computeMessageSize(4, (Detail)localIterator.next()) + j;
      }
      this.h = j;
      return j;
    }
    
    public boolean hasDistance()
    {
      return this.a;
    }
    
    public boolean hasDuration()
    {
      return this.c;
    }
    
    public boolean hasRemark()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Taxi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setDistance(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setDuration(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setRemark(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          Detail localDetail = new Detail();
          paramCodedInputStreamMicro.readMessage(localDetail);
          addDetail(localDetail);
        }
      }
    }
    
    public Taxi setDetail(int paramInt, Detail paramDetail)
    {
      if (paramDetail == null) {
        return this;
      }
      this.g.set(paramInt, paramDetail);
      return this;
    }
    
    public Taxi setDistance(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Taxi setDuration(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Taxi setRemark(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeInt32(1, getDistance());
      }
      if (hasDuration()) {
        paramCodedOutputStreamMicro.writeInt32(2, getDuration());
      }
      if (hasRemark()) {
        paramCodedOutputStreamMicro.writeString(3, getRemark());
      }
      Iterator localIterator = getDetailList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(4, (Detail)localIterator.next());
      }
    }
    
    public static final class Detail
      extends MessageMicro
    {
      public static final int DESC_FIELD_NUMBER = 1;
      public static final int KM_PRICE_FIELD_NUMBER = 2;
      public static final int START_PRICE_FIELD_NUMBER = 3;
      public static final int TOTAL_PRICE_FIELD_NUMBER = 4;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private int i = -1;
      
      public static Detail parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Detail().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Detail parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Detail)new Detail().mergeFrom(paramArrayOfByte);
      }
      
      public final Detail clear()
      {
        clearDesc();
        clearKmPrice();
        clearStartPrice();
        clearTotalPrice();
        this.i = -1;
        return this;
      }
      
      public Detail clearDesc()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Detail clearKmPrice()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Detail clearStartPrice()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Detail clearTotalPrice()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public String getDesc()
      {
        return this.b;
      }
      
      public String getKmPrice()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasDesc()) {
          k = 0 + CodedOutputStreamMicro.computeStringSize(1, getDesc());
        }
        int j = k;
        if (hasKmPrice()) {
          j = k + CodedOutputStreamMicro.computeStringSize(2, getKmPrice());
        }
        k = j;
        if (hasStartPrice()) {
          k = j + CodedOutputStreamMicro.computeStringSize(3, getStartPrice());
        }
        j = k;
        if (hasTotalPrice()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getTotalPrice());
        }
        this.i = j;
        return j;
      }
      
      public String getStartPrice()
      {
        return this.f;
      }
      
      public String getTotalPrice()
      {
        return this.h;
      }
      
      public boolean hasDesc()
      {
        return this.a;
      }
      
      public boolean hasKmPrice()
      {
        return this.c;
      }
      
      public boolean hasStartPrice()
      {
        return this.e;
      }
      
      public boolean hasTotalPrice()
      {
        return this.g;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Detail mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setDesc(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setKmPrice(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setStartPrice(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setTotalPrice(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Detail setDesc(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Detail setKmPrice(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Detail setStartPrice(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Detail setTotalPrice(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDesc()) {
          paramCodedOutputStreamMicro.writeString(1, getDesc());
        }
        if (hasKmPrice()) {
          paramCodedOutputStreamMicro.writeString(2, getKmPrice());
        }
        if (hasStartPrice()) {
          paramCodedOutputStreamMicro.writeString(3, getStartPrice());
        }
        if (hasTotalPrice()) {
          paramCodedOutputStreamMicro.writeString(4, getTotalPrice());
        }
      }
    }
  }
  
  public static final class Walk
    extends MessageMicro
  {
    public static final int DISTANCE_FIELD_NUMBER = 3;
    public static final int IS_BETTER_FIELD_NUMBER = 1;
    public static final int TIME_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private int g = -1;
    
    public static Walk parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Walk().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Walk parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Walk)new Walk().mergeFrom(paramArrayOfByte);
    }
    
    public final Walk clear()
    {
      clearIsBetter();
      clearTime();
      clearDistance();
      this.g = -1;
      return this;
    }
    
    public Walk clearDistance()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Walk clearIsBetter()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Walk clearTime()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public String getDistance()
    {
      return this.f;
    }
    
    public int getIsBetter()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasIsBetter()) {
        j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsBetter());
      }
      int i = j;
      if (hasTime()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getTime());
      }
      j = i;
      if (hasDistance()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getDistance());
      }
      this.g = j;
      return j;
    }
    
    public String getTime()
    {
      return this.d;
    }
    
    public boolean hasDistance()
    {
      return this.e;
    }
    
    public boolean hasIsBetter()
    {
      return this.a;
    }
    
    public boolean hasTime()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Walk mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIsBetter(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setTime(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setDistance(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Walk setDistance(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Walk setIsBetter(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Walk setTime(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsBetter()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIsBetter());
      }
      if (hasTime()) {
        paramCodedOutputStreamMicro.writeString(2, getTime());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeString(3, getDistance());
      }
    }
  }
  
  public static final class Zhuanche
    extends MessageMicro
  {
    public static final int BUTTON_FIELD_NUMBER = 2;
    public static final int FEE_DESC_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private Button d = null;
    private int e = -1;
    
    public static Zhuanche parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Zhuanche().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Zhuanche parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Zhuanche)new Zhuanche().mergeFrom(paramArrayOfByte);
    }
    
    public final Zhuanche clear()
    {
      clearFeeDesc();
      clearButton();
      this.e = -1;
      return this;
    }
    
    public Zhuanche clearButton()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public Zhuanche clearFeeDesc()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Button getButton()
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
    
    public String getFeeDesc()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasFeeDesc()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFeeDesc());
      }
      int j = i;
      if (hasButton()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getButton());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasButton()
    {
      return this.c;
    }
    
    public boolean hasFeeDesc()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Zhuanche mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setFeeDesc(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          Button localButton = new Button();
          paramCodedInputStreamMicro.readMessage(localButton);
          setButton(localButton);
        }
      }
    }
    
    public Zhuanche setButton(Button paramButton)
    {
      if (paramButton == null) {
        return clearButton();
      }
      this.c = true;
      this.d = paramButton;
      return this;
    }
    
    public Zhuanche setFeeDesc(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasFeeDesc()) {
        paramCodedOutputStreamMicro.writeString(1, getFeeDesc());
      }
      if (hasButton()) {
        paramCodedOutputStreamMicro.writeMessage(2, getButton());
      }
    }
    
    public static final class Button
      extends MessageMicro
    {
      public static final int PARAMS_FIELD_NUMBER = 2;
      public static final int TEXT_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static Button parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Button().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Button parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Button)new Button().mergeFrom(paramArrayOfByte);
      }
      
      public final Button clear()
      {
        clearText();
        clearParams();
        this.e = -1;
        return this;
      }
      
      public Button clearParams()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Button clearText()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.e < 0) {
          getSerializedSize();
        }
        return this.e;
      }
      
      public String getParams()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasText()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getText());
        }
        int j = i;
        if (hasParams()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getParams());
        }
        this.e = j;
        return j;
      }
      
      public String getText()
      {
        return this.b;
      }
      
      public boolean hasParams()
      {
        return this.c;
      }
      
      public boolean hasText()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Button mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setText(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setParams(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Button setParams(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Button setText(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasText()) {
          paramCodedOutputStreamMicro.writeString(1, getText());
        }
        if (hasParams()) {
          paramCodedOutputStreamMicro.writeString(2, getParams());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Bus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */