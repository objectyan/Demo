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

public final class WalkPlan
  extends MessageMicro
{
  public static final int CURRENT_CITY_FIELD_NUMBER = 4;
  public static final int INDOOR_NAVIS_FIELD_NUMBER = 5;
  public static final int OPTION_FIELD_NUMBER = 3;
  public static final int ROUTES_FIELD_NUMBER = 1;
  public static final int TAXI_FIELD_NUMBER = 2;
  private boolean a;
  private Taxi b = null;
  private List<Routes> c = Collections.emptyList();
  private boolean d;
  private Option e = null;
  private boolean f;
  private CurrentCity g = null;
  private List<IndoorNavi> h = Collections.emptyList();
  private int i = -1;
  
  public static WalkPlan parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new WalkPlan().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static WalkPlan parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (WalkPlan)new WalkPlan().mergeFrom(paramArrayOfByte);
  }
  
  public WalkPlan addIndoorNavis(IndoorNavi paramIndoorNavi)
  {
    if (paramIndoorNavi == null) {
      return this;
    }
    if (this.h.isEmpty()) {
      this.h = new ArrayList();
    }
    this.h.add(paramIndoorNavi);
    return this;
  }
  
  public WalkPlan addRoutes(Routes paramRoutes)
  {
    if (paramRoutes == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramRoutes);
    return this;
  }
  
  public final WalkPlan clear()
  {
    clearTaxi();
    clearRoutes();
    clearOption();
    clearCurrentCity();
    clearIndoorNavis();
    this.i = -1;
    return this;
  }
  
  public WalkPlan clearCurrentCity()
  {
    this.f = false;
    this.g = null;
    return this;
  }
  
  public WalkPlan clearIndoorNavis()
  {
    this.h = Collections.emptyList();
    return this;
  }
  
  public WalkPlan clearOption()
  {
    this.d = false;
    this.e = null;
    return this;
  }
  
  public WalkPlan clearRoutes()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public WalkPlan clearTaxi()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.i < 0) {
      getSerializedSize();
    }
    return this.i;
  }
  
  public CurrentCity getCurrentCity()
  {
    return this.g;
  }
  
  public IndoorNavi getIndoorNavis(int paramInt)
  {
    return (IndoorNavi)this.h.get(paramInt);
  }
  
  public int getIndoorNavisCount()
  {
    return this.h.size();
  }
  
  public List<IndoorNavi> getIndoorNavisList()
  {
    return this.h;
  }
  
  public Option getOption()
  {
    return this.e;
  }
  
  public Routes getRoutes(int paramInt)
  {
    return (Routes)this.c.get(paramInt);
  }
  
  public int getRoutesCount()
  {
    return this.c.size();
  }
  
  public List<Routes> getRoutesList()
  {
    return this.c;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getRoutesList().iterator();
    for (int k = 0; localIterator.hasNext(); k = CodedOutputStreamMicro.computeMessageSize(1, (Routes)localIterator.next()) + k) {}
    int j = k;
    if (hasTaxi()) {
      j = k + CodedOutputStreamMicro.computeMessageSize(2, getTaxi());
    }
    k = j;
    if (hasOption()) {
      k = j + CodedOutputStreamMicro.computeMessageSize(3, getOption());
    }
    j = k;
    if (hasCurrentCity()) {
      j = k + CodedOutputStreamMicro.computeMessageSize(4, getCurrentCity());
    }
    localIterator = getIndoorNavisList().iterator();
    while (localIterator.hasNext()) {
      j += CodedOutputStreamMicro.computeMessageSize(5, (IndoorNavi)localIterator.next());
    }
    this.i = j;
    return j;
  }
  
  public Taxi getTaxi()
  {
    return this.b;
  }
  
  public boolean hasCurrentCity()
  {
    return this.f;
  }
  
  public boolean hasOption()
  {
    return this.d;
  }
  
  public boolean hasTaxi()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public WalkPlan mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int j = paramCodedInputStreamMicro.readTag();
      Object localObject;
      switch (j)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
        break;
      case 0: 
        return this;
      case 10: 
        localObject = new Routes();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addRoutes((Routes)localObject);
        break;
      case 18: 
        localObject = new Taxi();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setTaxi((Taxi)localObject);
        break;
      case 26: 
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 34: 
        localObject = new CurrentCity();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setCurrentCity((CurrentCity)localObject);
        break;
      case 42: 
        localObject = new IndoorNavi();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addIndoorNavis((IndoorNavi)localObject);
      }
    }
  }
  
  public WalkPlan setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.f = true;
    this.g = paramCurrentCity;
    return this;
  }
  
  public WalkPlan setIndoorNavis(int paramInt, IndoorNavi paramIndoorNavi)
  {
    if (paramIndoorNavi == null) {
      return this;
    }
    this.h.set(paramInt, paramIndoorNavi);
    return this;
  }
  
  public WalkPlan setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.d = true;
    this.e = paramOption;
    return this;
  }
  
  public WalkPlan setRoutes(int paramInt, Routes paramRoutes)
  {
    if (paramRoutes == null) {
      return this;
    }
    this.c.set(paramInt, paramRoutes);
    return this;
  }
  
  public WalkPlan setTaxi(Taxi paramTaxi)
  {
    if (paramTaxi == null) {
      return clearTaxi();
    }
    this.a = true;
    this.b = paramTaxi;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getRoutesList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Routes)localIterator.next());
    }
    if (hasTaxi()) {
      paramCodedOutputStreamMicro.writeMessage(2, getTaxi());
    }
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(3, getOption());
    }
    if (hasCurrentCity()) {
      paramCodedOutputStreamMicro.writeMessage(4, getCurrentCity());
    }
    localIterator = getIndoorNavisList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(5, (IndoorNavi)localIterator.next());
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int AVOID_JAM_FIELD_NUMBER = 6;
    public static final int DIS_SY_FIELD_NUMBER = 9;
    public static final int END_CITY_FIELD_NUMBER = 8;
    public static final int END_FIELD_NUMBER = 5;
    public static final int EXPTIME_FIELD_NUMBER = 2;
    public static final int REQ_TM_FIELD_NUMBER = 10;
    public static final int SPATH_TYPE_FIELD_NUMBER = 11;
    public static final int START_CITY_FIELD_NUMBER = 7;
    public static final int START_FIELD_NUMBER = 4;
    public static final int SY_FIELD_NUMBER = 3;
    public static final int TOTAL_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private boolean g;
    private Start h = null;
    private List<End> i = Collections.emptyList();
    private boolean j;
    private int k = 0;
    private boolean l;
    private StartCity m = null;
    private List<EndCity> n = Collections.emptyList();
    private boolean o;
    private int p = 0;
    private boolean q;
    private String r = "";
    private boolean s;
    private int t = 0;
    private int u = -1;
    
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
    
    public Option addEnd(End paramEnd)
    {
      if (paramEnd == null) {
        return this;
      }
      if (this.i.isEmpty()) {
        this.i = new ArrayList();
      }
      this.i.add(paramEnd);
      return this;
    }
    
    public Option addEndCity(EndCity paramEndCity)
    {
      if (paramEndCity == null) {
        return this;
      }
      if (this.n.isEmpty()) {
        this.n = new ArrayList();
      }
      this.n.add(paramEndCity);
      return this;
    }
    
    public final Option clear()
    {
      clearTotal();
      clearExptime();
      clearSy();
      clearStart();
      clearEnd();
      clearAvoidJam();
      clearStartCity();
      clearEndCity();
      clearDisSy();
      clearReqTm();
      clearSpathType();
      this.u = -1;
      return this;
    }
    
    public Option clearAvoidJam()
    {
      this.j = false;
      this.k = 0;
      return this;
    }
    
    public Option clearDisSy()
    {
      this.o = false;
      this.p = 0;
      return this;
    }
    
    public Option clearEnd()
    {
      this.i = Collections.emptyList();
      return this;
    }
    
    public Option clearEndCity()
    {
      this.n = Collections.emptyList();
      return this;
    }
    
    public Option clearExptime()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Option clearReqTm()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Option clearSpathType()
    {
      this.s = false;
      this.t = 0;
      return this;
    }
    
    public Option clearStart()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public Option clearStartCity()
    {
      this.l = false;
      this.m = null;
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
    
    public int getAvoidJam()
    {
      return this.k;
    }
    
    public int getCachedSize()
    {
      if (this.u < 0) {
        getSerializedSize();
      }
      return this.u;
    }
    
    public int getDisSy()
    {
      return this.p;
    }
    
    public End getEnd(int paramInt)
    {
      return (End)this.i.get(paramInt);
    }
    
    public EndCity getEndCity(int paramInt)
    {
      return (EndCity)this.n.get(paramInt);
    }
    
    public int getEndCityCount()
    {
      return this.n.size();
    }
    
    public List<EndCity> getEndCityList()
    {
      return this.n;
    }
    
    public int getEndCount()
    {
      return this.i.size();
    }
    
    public List<End> getEndList()
    {
      return this.i;
    }
    
    public String getExptime()
    {
      return this.d;
    }
    
    public String getReqTm()
    {
      return this.r;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasTotal()) {
        i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
      }
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
      Iterator localIterator = getEndList().iterator();
      for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(5, (End)localIterator.next()) + i2) {}
      i1 = i2;
      if (hasAvoidJam()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getAvoidJam());
      }
      i2 = i1;
      if (hasStartCity()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
      }
      localIterator = getEndCityList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(8, (EndCity)localIterator.next());
      }
      i1 = i2;
      if (hasDisSy()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(9, getDisSy());
      }
      i2 = i1;
      if (hasReqTm()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(10, getReqTm());
      }
      i1 = i2;
      if (hasSpathType()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(11, getSpathType());
      }
      this.u = i1;
      return i1;
    }
    
    public int getSpathType()
    {
      return this.t;
    }
    
    public Start getStart()
    {
      return this.h;
    }
    
    public StartCity getStartCity()
    {
      return this.m;
    }
    
    public int getSy()
    {
      return this.f;
    }
    
    public int getTotal()
    {
      return this.b;
    }
    
    public boolean hasAvoidJam()
    {
      return this.j;
    }
    
    public boolean hasDisSy()
    {
      return this.o;
    }
    
    public boolean hasExptime()
    {
      return this.c;
    }
    
    public boolean hasReqTm()
    {
      return this.q;
    }
    
    public boolean hasSpathType()
    {
      return this.s;
    }
    
    public boolean hasStart()
    {
      return this.g;
    }
    
    public boolean hasStartCity()
    {
      return this.l;
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
          addEnd((End)localObject);
          break;
        case 48: 
          setAvoidJam(paramCodedInputStreamMicro.readInt32());
          break;
        case 58: 
          localObject = new StartCity();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setStartCity((StartCity)localObject);
          break;
        case 66: 
          localObject = new EndCity();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addEndCity((EndCity)localObject);
          break;
        case 72: 
          setDisSy(paramCodedInputStreamMicro.readInt32());
          break;
        case 82: 
          setReqTm(paramCodedInputStreamMicro.readString());
          break;
        case 88: 
          setSpathType(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setAvoidJam(int paramInt)
    {
      this.j = true;
      this.k = paramInt;
      return this;
    }
    
    public Option setDisSy(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public Option setEnd(int paramInt, End paramEnd)
    {
      if (paramEnd == null) {
        return this;
      }
      this.i.set(paramInt, paramEnd);
      return this;
    }
    
    public Option setEndCity(int paramInt, EndCity paramEndCity)
    {
      if (paramEndCity == null) {
        return this;
      }
      this.n.set(paramInt, paramEndCity);
      return this;
    }
    
    public Option setExptime(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Option setReqTm(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Option setSpathType(int paramInt)
    {
      this.s = true;
      this.t = paramInt;
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
    
    public Option setStartCity(StartCity paramStartCity)
    {
      if (paramStartCity == null) {
        return clearStartCity();
      }
      this.l = true;
      this.m = paramStartCity;
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
      Iterator localIterator = getEndList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(5, (End)localIterator.next());
      }
      if (hasAvoidJam()) {
        paramCodedOutputStreamMicro.writeInt32(6, getAvoidJam());
      }
      if (hasStartCity()) {
        paramCodedOutputStreamMicro.writeMessage(7, getStartCity());
      }
      localIterator = getEndCityList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (EndCity)localIterator.next());
      }
      if (hasDisSy()) {
        paramCodedOutputStreamMicro.writeInt32(9, getDisSy());
      }
      if (hasReqTm()) {
        paramCodedOutputStreamMicro.writeString(10, getReqTm());
      }
      if (hasSpathType()) {
        paramCodedOutputStreamMicro.writeInt32(11, getSpathType());
      }
    }
    
    public static final class End
      extends MessageMicro
    {
      public static final int BUILDING_FIELD_NUMBER = 7;
      public static final int BUS_STOP_FIELD_NUMBER = 4;
      public static final int FLOOR_FIELD_NUMBER = 6;
      public static final int PT_FIELD_NUMBER = 1;
      public static final int SPT_FIELD_NUMBER = 5;
      public static final int UID_FIELD_NUMBER = 3;
      public static final int WD_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private boolean h = false;
      private List<Integer> i = Collections.emptyList();
      private boolean j;
      private String k = "";
      private boolean l;
      private String m = "";
      private int n = -1;
      
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
        if (this.i.isEmpty()) {
          this.i = new ArrayList();
        }
        this.i.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public final End clear()
      {
        clearPt();
        clearWd();
        clearUid();
        clearBusStop();
        clearSpt();
        clearFloor();
        clearBuilding();
        this.n = -1;
        return this;
      }
      
      public End clearBuilding()
      {
        this.l = false;
        this.m = "";
        return this;
      }
      
      public End clearBusStop()
      {
        this.g = false;
        this.h = false;
        return this;
      }
      
      public End clearFloor()
      {
        this.j = false;
        this.k = "";
        return this;
      }
      
      public End clearPt()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public End clearSpt()
      {
        this.i = Collections.emptyList();
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
      
      public String getBuilding()
      {
        return this.m;
      }
      
      public boolean getBusStop()
      {
        return this.h;
      }
      
      public int getCachedSize()
      {
        if (this.n < 0) {
          getSerializedSize();
        }
        return this.n;
      }
      
      public String getFloor()
      {
        return this.k;
      }
      
      public String getPt()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i3 = 0;
        if (hasPt()) {}
        for (int i2 = CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0;; i2 = 0)
        {
          int i1 = i2;
          if (hasWd()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getWd());
          }
          i2 = i1;
          if (hasUid()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getUid());
          }
          if (hasBusStop()) {}
          for (i1 = i2 + CodedOutputStreamMicro.computeBoolSize(4, getBusStop());; i1 = i2)
          {
            Iterator localIterator = getSptList().iterator();
            i2 = i3;
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            i2 = i1 + i2 + getSptList().size() * 1;
            i1 = i2;
            if (hasFloor()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getFloor());
            }
            i2 = i1;
            if (hasBuilding()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getBuilding());
            }
            this.n = i2;
            return i2;
          }
        }
      }
      
      public int getSpt(int paramInt)
      {
        return ((Integer)this.i.get(paramInt)).intValue();
      }
      
      public int getSptCount()
      {
        return this.i.size();
      }
      
      public List<Integer> getSptList()
      {
        return this.i;
      }
      
      public String getUid()
      {
        return this.f;
      }
      
      public String getWd()
      {
        return this.d;
      }
      
      public boolean hasBuilding()
      {
        return this.l;
      }
      
      public boolean hasBusStop()
      {
        return this.g;
      }
      
      public boolean hasFloor()
      {
        return this.j;
      }
      
      public boolean hasPt()
      {
        return this.a;
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
          int i1 = paramCodedInputStreamMicro.readTag();
          switch (i1)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
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
            setBusStop(paramCodedInputStreamMicro.readBool());
            break;
          case 40: 
            addSpt(paramCodedInputStreamMicro.readSInt32());
            break;
          case 50: 
            setFloor(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setBuilding(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public End setBuilding(String paramString)
      {
        this.l = true;
        this.m = paramString;
        return this;
      }
      
      public End setBusStop(boolean paramBoolean)
      {
        this.g = true;
        this.h = paramBoolean;
        return this;
      }
      
      public End setFloor(String paramString)
      {
        this.j = true;
        this.k = paramString;
        return this;
      }
      
      public End setPt(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public End setSpt(int paramInt1, int paramInt2)
      {
        this.i.set(paramInt1, Integer.valueOf(paramInt2));
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
        if (hasBusStop()) {
          paramCodedOutputStreamMicro.writeBool(4, getBusStop());
        }
        Iterator localIterator = getSptList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(5, ((Integer)localIterator.next()).intValue());
        }
        if (hasFloor()) {
          paramCodedOutputStreamMicro.writeString(6, getFloor());
        }
        if (hasBuilding()) {
          paramCodedOutputStreamMicro.writeString(7, getBuilding());
        }
      }
    }
    
    public static final class EndCity
      extends MessageMicro
    {
      public static final int CNAME_FIELD_NUMBER = 2;
      public static final int CODE_FIELD_NUMBER = 1;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static EndCity parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new EndCity().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static EndCity parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (EndCity)new EndCity().mergeFrom(paramArrayOfByte);
      }
      
      public final EndCity clear()
      {
        clearCode();
        clearCname();
        this.e = -1;
        return this;
      }
      
      public EndCity clearCname()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public EndCity clearCode()
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
      
      public String getCname()
      {
        return this.d;
      }
      
      public int getCode()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasCode()) {
          i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        int j = i;
        if (hasCname()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getCname());
        }
        this.e = j;
        return j;
      }
      
      public boolean hasCname()
      {
        return this.c;
      }
      
      public boolean hasCode()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public EndCity mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setCode(paramCodedInputStreamMicro.readInt32());
            break;
          case 18: 
            setCname(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public EndCity setCname(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public EndCity setCode(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasCode()) {
          paramCodedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (hasCname()) {
          paramCodedOutputStreamMicro.writeString(2, getCname());
        }
      }
    }
    
    public static final class Start
      extends MessageMicro
    {
      public static final int BUILDING_FIELD_NUMBER = 7;
      public static final int BUS_STOP_FIELD_NUMBER = 4;
      public static final int FLOOR_FIELD_NUMBER = 6;
      public static final int PT_FIELD_NUMBER = 1;
      public static final int SPT_FIELD_NUMBER = 5;
      public static final int UID_FIELD_NUMBER = 3;
      public static final int WD_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private boolean h = false;
      private List<Integer> i = Collections.emptyList();
      private boolean j;
      private String k = "";
      private boolean l;
      private String m = "";
      private int n = -1;
      
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
        if (this.i.isEmpty()) {
          this.i = new ArrayList();
        }
        this.i.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public final Start clear()
      {
        clearPt();
        clearWd();
        clearUid();
        clearBusStop();
        clearSpt();
        clearFloor();
        clearBuilding();
        this.n = -1;
        return this;
      }
      
      public Start clearBuilding()
      {
        this.l = false;
        this.m = "";
        return this;
      }
      
      public Start clearBusStop()
      {
        this.g = false;
        this.h = false;
        return this;
      }
      
      public Start clearFloor()
      {
        this.j = false;
        this.k = "";
        return this;
      }
      
      public Start clearPt()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Start clearSpt()
      {
        this.i = Collections.emptyList();
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
      
      public String getBuilding()
      {
        return this.m;
      }
      
      public boolean getBusStop()
      {
        return this.h;
      }
      
      public int getCachedSize()
      {
        if (this.n < 0) {
          getSerializedSize();
        }
        return this.n;
      }
      
      public String getFloor()
      {
        return this.k;
      }
      
      public String getPt()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i3 = 0;
        if (hasPt()) {}
        for (int i2 = CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0;; i2 = 0)
        {
          int i1 = i2;
          if (hasWd()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getWd());
          }
          i2 = i1;
          if (hasUid()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getUid());
          }
          if (hasBusStop()) {}
          for (i1 = i2 + CodedOutputStreamMicro.computeBoolSize(4, getBusStop());; i1 = i2)
          {
            Iterator localIterator = getSptList().iterator();
            i2 = i3;
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            i2 = i1 + i2 + getSptList().size() * 1;
            i1 = i2;
            if (hasFloor()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getFloor());
            }
            i2 = i1;
            if (hasBuilding()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getBuilding());
            }
            this.n = i2;
            return i2;
          }
        }
      }
      
      public int getSpt(int paramInt)
      {
        return ((Integer)this.i.get(paramInt)).intValue();
      }
      
      public int getSptCount()
      {
        return this.i.size();
      }
      
      public List<Integer> getSptList()
      {
        return this.i;
      }
      
      public String getUid()
      {
        return this.f;
      }
      
      public String getWd()
      {
        return this.d;
      }
      
      public boolean hasBuilding()
      {
        return this.l;
      }
      
      public boolean hasBusStop()
      {
        return this.g;
      }
      
      public boolean hasFloor()
      {
        return this.j;
      }
      
      public boolean hasPt()
      {
        return this.a;
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
          int i1 = paramCodedInputStreamMicro.readTag();
          switch (i1)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
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
            setBusStop(paramCodedInputStreamMicro.readBool());
            break;
          case 40: 
            addSpt(paramCodedInputStreamMicro.readSInt32());
            break;
          case 50: 
            setFloor(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setBuilding(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Start setBuilding(String paramString)
      {
        this.l = true;
        this.m = paramString;
        return this;
      }
      
      public Start setBusStop(boolean paramBoolean)
      {
        this.g = true;
        this.h = paramBoolean;
        return this;
      }
      
      public Start setFloor(String paramString)
      {
        this.j = true;
        this.k = paramString;
        return this;
      }
      
      public Start setPt(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Start setSpt(int paramInt1, int paramInt2)
      {
        this.i.set(paramInt1, Integer.valueOf(paramInt2));
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
        if (hasBusStop()) {
          paramCodedOutputStreamMicro.writeBool(4, getBusStop());
        }
        Iterator localIterator = getSptList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(5, ((Integer)localIterator.next()).intValue());
        }
        if (hasFloor()) {
          paramCodedOutputStreamMicro.writeString(6, getFloor());
        }
        if (hasBuilding()) {
          paramCodedOutputStreamMicro.writeString(7, getBuilding());
        }
      }
    }
    
    public static final class StartCity
      extends MessageMicro
    {
      public static final int CNAME_FIELD_NUMBER = 2;
      public static final int CODE_FIELD_NUMBER = 1;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static StartCity parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new StartCity().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static StartCity parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (StartCity)new StartCity().mergeFrom(paramArrayOfByte);
      }
      
      public final StartCity clear()
      {
        clearCode();
        clearCname();
        this.e = -1;
        return this;
      }
      
      public StartCity clearCname()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public StartCity clearCode()
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
      
      public String getCname()
      {
        return this.d;
      }
      
      public int getCode()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasCode()) {
          i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        int j = i;
        if (hasCname()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getCname());
        }
        this.e = j;
        return j;
      }
      
      public boolean hasCname()
      {
        return this.c;
      }
      
      public boolean hasCode()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public StartCity mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setCode(paramCodedInputStreamMicro.readInt32());
            break;
          case 18: 
            setCname(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public StartCity setCname(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public StartCity setCode(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasCode()) {
          paramCodedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (hasCname()) {
          paramCodedOutputStreamMicro.writeString(2, getCname());
        }
      }
    }
  }
  
  public static final class Routes
    extends MessageMicro
  {
    public static final int CLIMB_FIELD_NUMBER = 2;
    public static final int LEGS_FIELD_NUMBER = 1;
    private List<Legs> a = Collections.emptyList();
    private boolean b;
    private Climb c = null;
    private int d = -1;
    
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
      clearClimb();
      this.d = -1;
      return this;
    }
    
    public Routes clearClimb()
    {
      this.b = false;
      this.c = null;
      return this;
    }
    
    public Routes clearLegs()
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
    
    public Climb getClimb()
    {
      return this.c;
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
      int j = i;
      if (hasClimb()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getClimb());
      }
      this.d = j;
      return j;
    }
    
    public boolean hasClimb()
    {
      return this.b;
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
        Object localObject;
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Legs();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addLegs((Legs)localObject);
          break;
        case 18: 
          localObject = new Climb();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setClimb((Climb)localObject);
        }
      }
    }
    
    public Routes setClimb(Climb paramClimb)
    {
      if (paramClimb == null) {
        return clearClimb();
      }
      this.b = true;
      this.c = paramClimb;
      return this;
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
      if (hasClimb()) {
        paramCodedOutputStreamMicro.writeMessage(2, getClimb());
      }
    }
    
    public static final class Climb
      extends MessageMicro
    {
      public static final int CLIMB_HEIGHT_FIELD_NUMBER = 3;
      public static final int DOWN_DIS_FIELD_NUMBER = 2;
      public static final int UP_DIS_FIELD_NUMBER = 1;
      private boolean a;
      private int b = 0;
      private boolean c;
      private int d = 0;
      private boolean e;
      private int f = 0;
      private int g = -1;
      
      public static Climb parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Climb().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Climb parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Climb)new Climb().mergeFrom(paramArrayOfByte);
      }
      
      public final Climb clear()
      {
        clearUpDis();
        clearDownDis();
        clearClimbHeight();
        this.g = -1;
        return this;
      }
      
      public Climb clearClimbHeight()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public Climb clearDownDis()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public Climb clearUpDis()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.g < 0) {
          getSerializedSize();
        }
        return this.g;
      }
      
      public int getClimbHeight()
      {
        return this.f;
      }
      
      public int getDownDis()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        if (hasUpDis()) {
          j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getUpDis());
        }
        int i = j;
        if (hasDownDis()) {
          i = j + CodedOutputStreamMicro.computeInt32Size(2, getDownDis());
        }
        j = i;
        if (hasClimbHeight()) {
          j = i + CodedOutputStreamMicro.computeInt32Size(3, getClimbHeight());
        }
        this.g = j;
        return j;
      }
      
      public int getUpDis()
      {
        return this.b;
      }
      
      public boolean hasClimbHeight()
      {
        return this.e;
      }
      
      public boolean hasDownDis()
      {
        return this.c;
      }
      
      public boolean hasUpDis()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Climb mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setUpDis(paramCodedInputStreamMicro.readInt32());
            break;
          case 16: 
            setDownDis(paramCodedInputStreamMicro.readInt32());
            break;
          case 24: 
            setClimbHeight(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public Climb setClimbHeight(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public Climb setDownDis(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public Climb setUpDis(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasUpDis()) {
          paramCodedOutputStreamMicro.writeInt32(1, getUpDis());
        }
        if (hasDownDis()) {
          paramCodedOutputStreamMicro.writeInt32(2, getDownDis());
        }
        if (hasClimbHeight()) {
          paramCodedOutputStreamMicro.writeInt32(3, getClimbHeight());
        }
      }
    }
    
    public static final class Legs
      extends MessageMicro
    {
      public static final int CONNECTED_POIS_FIELD_NUMBER = 11;
      public static final int DISTANCE_FIELD_NUMBER = 5;
      public static final int DURATION_FIELD_NUMBER = 6;
      public static final int END_ADDRESS_FIELD_NUMBER = 4;
      public static final int END_DIST_FIELD_NUMBER = 9;
      public static final int LEG_LINKED_FIELD_NUMBER = 12;
      public static final int SEND_LOCATION_FIELD_NUMBER = 2;
      public static final int SIDE_FIELD_NUMBER = 7;
      public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
      public static final int START_ADDRESS_FIELD_NUMBER = 3;
      public static final int START_DIST_FIELD_NUMBER = 8;
      public static final int STEPS_FIELD_NUMBER = 10;
      private List<Steps> a = Collections.emptyList();
      private List<Integer> b = Collections.emptyList();
      private List<Integer> c = Collections.emptyList();
      private boolean d;
      private String e = "";
      private boolean f;
      private String g = "";
      private boolean h;
      private int i = 0;
      private boolean j;
      private int k = 0;
      private boolean l;
      private int m = 0;
      private boolean n;
      private int o = 0;
      private boolean p;
      private int q = 0;
      private List<ConnectedPois> r = Collections.emptyList();
      private boolean s;
      private LegLinked t = null;
      private int u = -1;
      
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
      
      public Legs addConnectedPois(ConnectedPois paramConnectedPois)
      {
        if (paramConnectedPois == null) {
          return this;
        }
        if (this.r.isEmpty()) {
          this.r = new ArrayList();
        }
        this.r.add(paramConnectedPois);
        return this;
      }
      
      public Legs addSendLocation(int paramInt)
      {
        if (this.c.isEmpty()) {
          this.c = new ArrayList();
        }
        this.c.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Legs addSstartLocation(int paramInt)
      {
        if (this.b.isEmpty()) {
          this.b = new ArrayList();
        }
        this.b.add(Integer.valueOf(paramInt));
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
        clearSstartLocation();
        clearSendLocation();
        clearStartAddress();
        clearEndAddress();
        clearDistance();
        clearDuration();
        clearSide();
        clearStartDist();
        clearEndDist();
        clearConnectedPois();
        clearLegLinked();
        this.u = -1;
        return this;
      }
      
      public Legs clearConnectedPois()
      {
        this.r = Collections.emptyList();
        return this;
      }
      
      public Legs clearDistance()
      {
        this.h = false;
        this.i = 0;
        return this;
      }
      
      public Legs clearDuration()
      {
        this.j = false;
        this.k = 0;
        return this;
      }
      
      public Legs clearEndAddress()
      {
        this.f = false;
        this.g = "";
        return this;
      }
      
      public Legs clearEndDist()
      {
        this.p = false;
        this.q = 0;
        return this;
      }
      
      public Legs clearLegLinked()
      {
        this.s = false;
        this.t = null;
        return this;
      }
      
      public Legs clearSendLocation()
      {
        this.c = Collections.emptyList();
        return this;
      }
      
      public Legs clearSide()
      {
        this.l = false;
        this.m = 0;
        return this;
      }
      
      public Legs clearSstartLocation()
      {
        this.b = Collections.emptyList();
        return this;
      }
      
      public Legs clearStartAddress()
      {
        this.d = false;
        this.e = "";
        return this;
      }
      
      public Legs clearStartDist()
      {
        this.n = false;
        this.o = 0;
        return this;
      }
      
      public Legs clearSteps()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.u < 0) {
          getSerializedSize();
        }
        return this.u;
      }
      
      public ConnectedPois getConnectedPois(int paramInt)
      {
        return (ConnectedPois)this.r.get(paramInt);
      }
      
      public int getConnectedPoisCount()
      {
        return this.r.size();
      }
      
      public List<ConnectedPois> getConnectedPoisList()
      {
        return this.r;
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
        return this.g;
      }
      
      public int getEndDist()
      {
        return this.q;
      }
      
      public LegLinked getLegLinked()
      {
        return this.t;
      }
      
      public int getSendLocation(int paramInt)
      {
        return ((Integer)this.c.get(paramInt)).intValue();
      }
      
      public int getSendLocationCount()
      {
        return this.c.size();
      }
      
      public List<Integer> getSendLocationList()
      {
        return this.c;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        Iterator localIterator = getSstartLocationList().iterator();
        for (int i1 = 0; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i1) {}
        int i3 = getSstartLocationList().size();
        localIterator = getSendLocationList().iterator();
        while (localIterator.hasNext()) {
          i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
        }
        i2 = i3 * 1 + (0 + i1) + i2 + getSendLocationList().size() * 1;
        i1 = i2;
        if (hasStartAddress()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(3, getStartAddress());
        }
        i2 = i1;
        if (hasEndAddress()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(4, getEndAddress());
        }
        i1 = i2;
        if (hasDistance()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(5, getDistance());
        }
        i2 = i1;
        if (hasDuration()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(6, getDuration());
        }
        i1 = i2;
        if (hasSide()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(7, getSide());
        }
        i2 = i1;
        if (hasStartDist()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(8, getStartDist());
        }
        i1 = i2;
        if (hasEndDist()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(9, getEndDist());
        }
        localIterator = getStepsList().iterator();
        while (localIterator.hasNext()) {
          i1 = CodedOutputStreamMicro.computeMessageSize(10, (Steps)localIterator.next()) + i1;
        }
        localIterator = getConnectedPoisList().iterator();
        while (localIterator.hasNext()) {
          i1 += CodedOutputStreamMicro.computeMessageSize(11, (ConnectedPois)localIterator.next());
        }
        i2 = i1;
        if (hasLegLinked()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(12, getLegLinked());
        }
        this.u = i2;
        return i2;
      }
      
      public int getSide()
      {
        return this.m;
      }
      
      public int getSstartLocation(int paramInt)
      {
        return ((Integer)this.b.get(paramInt)).intValue();
      }
      
      public int getSstartLocationCount()
      {
        return this.b.size();
      }
      
      public List<Integer> getSstartLocationList()
      {
        return this.b;
      }
      
      public String getStartAddress()
      {
        return this.e;
      }
      
      public int getStartDist()
      {
        return this.o;
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
        return this.f;
      }
      
      public boolean hasEndDist()
      {
        return this.p;
      }
      
      public boolean hasLegLinked()
      {
        return this.s;
      }
      
      public boolean hasSide()
      {
        return this.l;
      }
      
      public boolean hasStartAddress()
      {
        return this.d;
      }
      
      public boolean hasStartDist()
      {
        return this.n;
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
            addSstartLocation(paramCodedInputStreamMicro.readSInt32());
            break;
          case 16: 
            addSendLocation(paramCodedInputStreamMicro.readSInt32());
            break;
          case 26: 
            setStartAddress(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setEndAddress(paramCodedInputStreamMicro.readString());
            break;
          case 40: 
            setDistance(paramCodedInputStreamMicro.readInt32());
            break;
          case 48: 
            setDuration(paramCodedInputStreamMicro.readInt32());
            break;
          case 56: 
            setSide(paramCodedInputStreamMicro.readInt32());
            break;
          case 64: 
            setStartDist(paramCodedInputStreamMicro.readInt32());
            break;
          case 72: 
            setEndDist(paramCodedInputStreamMicro.readInt32());
            break;
          case 82: 
            localObject = new Steps();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addSteps((Steps)localObject);
            break;
          case 90: 
            localObject = new ConnectedPois();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addConnectedPois((ConnectedPois)localObject);
            break;
          case 98: 
            localObject = new LegLinked();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setLegLinked((LegLinked)localObject);
          }
        }
      }
      
      public Legs setConnectedPois(int paramInt, ConnectedPois paramConnectedPois)
      {
        if (paramConnectedPois == null) {
          return this;
        }
        this.r.set(paramInt, paramConnectedPois);
        return this;
      }
      
      public Legs setDistance(int paramInt)
      {
        this.h = true;
        this.i = paramInt;
        return this;
      }
      
      public Legs setDuration(int paramInt)
      {
        this.j = true;
        this.k = paramInt;
        return this;
      }
      
      public Legs setEndAddress(String paramString)
      {
        this.f = true;
        this.g = paramString;
        return this;
      }
      
      public Legs setEndDist(int paramInt)
      {
        this.p = true;
        this.q = paramInt;
        return this;
      }
      
      public Legs setLegLinked(LegLinked paramLegLinked)
      {
        if (paramLegLinked == null) {
          return clearLegLinked();
        }
        this.s = true;
        this.t = paramLegLinked;
        return this;
      }
      
      public Legs setSendLocation(int paramInt1, int paramInt2)
      {
        this.c.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Legs setSide(int paramInt)
      {
        this.l = true;
        this.m = paramInt;
        return this;
      }
      
      public Legs setSstartLocation(int paramInt1, int paramInt2)
      {
        this.b.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Legs setStartAddress(String paramString)
      {
        this.d = true;
        this.e = paramString;
        return this;
      }
      
      public Legs setStartDist(int paramInt)
      {
        this.n = true;
        this.o = paramInt;
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
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getSstartLocationList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(1, ((Integer)localIterator.next()).intValue());
        }
        localIterator = getSendLocationList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(2, ((Integer)localIterator.next()).intValue());
        }
        if (hasStartAddress()) {
          paramCodedOutputStreamMicro.writeString(3, getStartAddress());
        }
        if (hasEndAddress()) {
          paramCodedOutputStreamMicro.writeString(4, getEndAddress());
        }
        if (hasDistance()) {
          paramCodedOutputStreamMicro.writeInt32(5, getDistance());
        }
        if (hasDuration()) {
          paramCodedOutputStreamMicro.writeInt32(6, getDuration());
        }
        if (hasSide()) {
          paramCodedOutputStreamMicro.writeInt32(7, getSide());
        }
        if (hasStartDist()) {
          paramCodedOutputStreamMicro.writeInt32(8, getStartDist());
        }
        if (hasEndDist()) {
          paramCodedOutputStreamMicro.writeInt32(9, getEndDist());
        }
        localIterator = getStepsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(10, (Steps)localIterator.next());
        }
        localIterator = getConnectedPoisList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(11, (ConnectedPois)localIterator.next());
        }
        if (hasLegLinked()) {
          paramCodedOutputStreamMicro.writeMessage(12, getLegLinked());
        }
      }
      
      public static final class ConnectedPois
        extends MessageMicro
      {
        public static final int BUILDING_FIELD_NUMBER = 6;
        public static final int FLOOR_FIELD_NUMBER = 5;
        public static final int INFO_FIELD_NUMBER = 3;
        public static final int LOCATION_FIELD_NUMBER = 4;
        public static final int TYPE_DIR_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private boolean a;
        private int b = 0;
        private boolean c;
        private int d = 0;
        private boolean e;
        private String f = "";
        private List<Integer> g = Collections.emptyList();
        private boolean h;
        private String i = "";
        private boolean j;
        private String k = "";
        private int l = -1;
        
        public static ConnectedPois parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new ConnectedPois().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static ConnectedPois parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (ConnectedPois)new ConnectedPois().mergeFrom(paramArrayOfByte);
        }
        
        public ConnectedPois addLocation(int paramInt)
        {
          if (this.g.isEmpty()) {
            this.g = new ArrayList();
          }
          this.g.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public final ConnectedPois clear()
        {
          clearType();
          clearTypeDir();
          clearInfo();
          clearLocation();
          clearFloor();
          clearBuilding();
          this.l = -1;
          return this;
        }
        
        public ConnectedPois clearBuilding()
        {
          this.j = false;
          this.k = "";
          return this;
        }
        
        public ConnectedPois clearFloor()
        {
          this.h = false;
          this.i = "";
          return this;
        }
        
        public ConnectedPois clearInfo()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public ConnectedPois clearLocation()
        {
          this.g = Collections.emptyList();
          return this;
        }
        
        public ConnectedPois clearType()
        {
          this.a = false;
          this.b = 0;
          return this;
        }
        
        public ConnectedPois clearTypeDir()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public String getBuilding()
        {
          return this.k;
        }
        
        public int getCachedSize()
        {
          if (this.l < 0) {
            getSerializedSize();
          }
          return this.l;
        }
        
        public String getFloor()
        {
          return this.i;
        }
        
        public String getInfo()
        {
          return this.f;
        }
        
        public int getLocation(int paramInt)
        {
          return ((Integer)this.g.get(paramInt)).intValue();
        }
        
        public int getLocationCount()
        {
          return this.g.size();
        }
        
        public List<Integer> getLocationList()
        {
          return this.g;
        }
        
        public int getSerializedSize()
        {
          int i1 = 0;
          if (hasType()) {}
          for (int m = CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0;; m = 0)
          {
            int n = m;
            if (hasTypeDir()) {
              n = m + CodedOutputStreamMicro.computeInt32Size(2, getTypeDir());
            }
            if (hasInfo()) {}
            for (m = n + CodedOutputStreamMicro.computeStringSize(3, getInfo());; m = n)
            {
              Iterator localIterator = getLocationList().iterator();
              n = i1;
              while (localIterator.hasNext()) {
                n += CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue());
              }
              n = m + n + getLocationList().size() * 1;
              m = n;
              if (hasFloor()) {
                m = n + CodedOutputStreamMicro.computeStringSize(5, getFloor());
              }
              n = m;
              if (hasBuilding()) {
                n = m + CodedOutputStreamMicro.computeStringSize(6, getBuilding());
              }
              this.l = n;
              return n;
            }
          }
        }
        
        public int getType()
        {
          return this.b;
        }
        
        public int getTypeDir()
        {
          return this.d;
        }
        
        public boolean hasBuilding()
        {
          return this.j;
        }
        
        public boolean hasFloor()
        {
          return this.h;
        }
        
        public boolean hasInfo()
        {
          return this.e;
        }
        
        public boolean hasType()
        {
          return this.a;
        }
        
        public boolean hasTypeDir()
        {
          return this.c;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public ConnectedPois mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setType(paramCodedInputStreamMicro.readInt32());
              break;
            case 16: 
              setTypeDir(paramCodedInputStreamMicro.readInt32());
              break;
            case 26: 
              setInfo(paramCodedInputStreamMicro.readString());
              break;
            case 32: 
              addLocation(paramCodedInputStreamMicro.readInt32());
              break;
            case 42: 
              setFloor(paramCodedInputStreamMicro.readString());
              break;
            case 50: 
              setBuilding(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public ConnectedPois setBuilding(String paramString)
        {
          this.j = true;
          this.k = paramString;
          return this;
        }
        
        public ConnectedPois setFloor(String paramString)
        {
          this.h = true;
          this.i = paramString;
          return this;
        }
        
        public ConnectedPois setInfo(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public ConnectedPois setLocation(int paramInt1, int paramInt2)
        {
          this.g.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public ConnectedPois setType(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public ConnectedPois setTypeDir(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasType()) {
            paramCodedOutputStreamMicro.writeInt32(1, getType());
          }
          if (hasTypeDir()) {
            paramCodedOutputStreamMicro.writeInt32(2, getTypeDir());
          }
          if (hasInfo()) {
            paramCodedOutputStreamMicro.writeString(3, getInfo());
          }
          Iterator localIterator = getLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeInt32(4, ((Integer)localIterator.next()).intValue());
          }
          if (hasFloor()) {
            paramCodedOutputStreamMicro.writeString(5, getFloor());
          }
          if (hasBuilding()) {
            paramCodedOutputStreamMicro.writeString(6, getBuilding());
          }
        }
      }
      
      public static final class LegLinked
        extends MessageMicro
      {
        public static final int NEXT_FIELD_NUMBER = 2;
        public static final int PREV_FIELD_NUMBER = 1;
        private boolean a;
        private int b = 0;
        private boolean c;
        private int d = 0;
        private int e = -1;
        
        public static LegLinked parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new LegLinked().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static LegLinked parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (LegLinked)new LegLinked().mergeFrom(paramArrayOfByte);
        }
        
        public final LegLinked clear()
        {
          clearPrev();
          clearNext();
          this.e = -1;
          return this;
        }
        
        public LegLinked clearNext()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public LegLinked clearPrev()
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
        
        public int getNext()
        {
          return this.d;
        }
        
        public int getPrev()
        {
          return this.b;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasPrev()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getPrev());
          }
          int j = i;
          if (hasNext()) {
            j = i + CodedOutputStreamMicro.computeInt32Size(2, getNext());
          }
          this.e = j;
          return j;
        }
        
        public boolean hasNext()
        {
          return this.c;
        }
        
        public boolean hasPrev()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public LegLinked mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setPrev(paramCodedInputStreamMicro.readInt32());
              break;
            case 16: 
              setNext(paramCodedInputStreamMicro.readInt32());
            }
          }
        }
        
        public LegLinked setNext(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public LegLinked setPrev(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasPrev()) {
            paramCodedOutputStreamMicro.writeInt32(1, getPrev());
          }
          if (hasNext()) {
            paramCodedOutputStreamMicro.writeInt32(2, getNext());
          }
        }
      }
      
      public static final class Steps
        extends MessageMicro
      {
        public static final int CIRCLE_ROAD_FIELD_NUMBER = 9;
        public static final int DIRECTION_FIELD_NUMBER = 15;
        public static final int DISTANCE_FIELD_NUMBER = 11;
        public static final int DURATION_FIELD_NUMBER = 12;
        public static final int FIRST_LINK_END_INDEX_FIELD_NUMBER = 5;
        public static final int HAS_PANID_FIELD_NUMBER = 16;
        public static final int INSTRUCTIONS_FIELD_NUMBER = 2;
        public static final int LIGHT_FIELD_NUMBER = 8;
        public static final int LINKS_FIELD_NUMBER = 13;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int POIS_FIELD_NUMBER = 14;
        public static final int ROAD_WIDTH_FIELD_NUMBER = 10;
        public static final int SEND_LOCATION_FIELD_NUMBER = 18;
        public static final int SPATH_FIELD_NUMBER = 1;
        public static final int SSTART_LOCATION_FIELD_NUMBER = 17;
        public static final int STRAFFICMARK_LOC_FIELD_NUMBER = 19;
        public static final int TRAFFIC_TYPE_FIELD_NUMBER = 20;
        public static final int TURN_TYPE_FIELD_NUMBER = 6;
        public static final int TYPE_FIELD_NUMBER = 3;
        public static final int WALK_TYPE_FIELD_NUMBER = 7;
        private int A = 0;
        private boolean B;
        private int C = 0;
        private List<Integer> D = Collections.emptyList();
        private List<Integer> E = Collections.emptyList();
        private List<Integer> F = Collections.emptyList();
        private boolean G;
        private int H = 0;
        private int I = -1;
        private List<Links> a = Collections.emptyList();
        private List<Pois> b = Collections.emptyList();
        private List<Integer> c = Collections.emptyList();
        private boolean d;
        private String e = "";
        private boolean f;
        private int g = 0;
        private boolean h;
        private String i = "";
        private boolean j;
        private int k = 0;
        private boolean l;
        private int m = 0;
        private boolean n;
        private int o = 0;
        private boolean p;
        private int q = 0;
        private boolean r;
        private int s = 0;
        private boolean t;
        private int u = 0;
        private boolean v;
        private int w = 0;
        private boolean x;
        private int y = 0;
        private boolean z;
        
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
        
        public Steps addLinks(Links paramLinks)
        {
          if (paramLinks == null) {
            return this;
          }
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(paramLinks);
          return this;
        }
        
        public Steps addPois(Pois paramPois)
        {
          if (paramPois == null) {
            return this;
          }
          if (this.b.isEmpty()) {
            this.b = new ArrayList();
          }
          this.b.add(paramPois);
          return this;
        }
        
        public Steps addSendLocation(int paramInt)
        {
          if (this.E.isEmpty()) {
            this.E = new ArrayList();
          }
          this.E.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public Steps addSpath(int paramInt)
        {
          if (this.c.isEmpty()) {
            this.c = new ArrayList();
          }
          this.c.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public Steps addSstartLocation(int paramInt)
        {
          if (this.D.isEmpty()) {
            this.D = new ArrayList();
          }
          this.D.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public Steps addStrafficmarkLoc(int paramInt)
        {
          if (this.F.isEmpty()) {
            this.F = new ArrayList();
          }
          this.F.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public final Steps clear()
        {
          clearLinks();
          clearPois();
          clearSpath();
          clearInstructions();
          clearType();
          clearName();
          clearFirstLinkEndIndex();
          clearTurnType();
          clearWalkType();
          clearLight();
          clearCircleRoad();
          clearRoadWidth();
          clearDistance();
          clearDuration();
          clearDirection();
          clearHasPanid();
          clearSstartLocation();
          clearSendLocation();
          clearStrafficmarkLoc();
          clearTrafficType();
          this.I = -1;
          return this;
        }
        
        public Steps clearCircleRoad()
        {
          this.r = false;
          this.s = 0;
          return this;
        }
        
        public Steps clearDirection()
        {
          this.z = false;
          this.A = 0;
          return this;
        }
        
        public Steps clearDistance()
        {
          this.v = false;
          this.w = 0;
          return this;
        }
        
        public Steps clearDuration()
        {
          this.x = false;
          this.y = 0;
          return this;
        }
        
        public Steps clearFirstLinkEndIndex()
        {
          this.j = false;
          this.k = 0;
          return this;
        }
        
        public Steps clearHasPanid()
        {
          this.B = false;
          this.C = 0;
          return this;
        }
        
        public Steps clearInstructions()
        {
          this.d = false;
          this.e = "";
          return this;
        }
        
        public Steps clearLight()
        {
          this.p = false;
          this.q = 0;
          return this;
        }
        
        public Steps clearLinks()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public Steps clearName()
        {
          this.h = false;
          this.i = "";
          return this;
        }
        
        public Steps clearPois()
        {
          this.b = Collections.emptyList();
          return this;
        }
        
        public Steps clearRoadWidth()
        {
          this.t = false;
          this.u = 0;
          return this;
        }
        
        public Steps clearSendLocation()
        {
          this.E = Collections.emptyList();
          return this;
        }
        
        public Steps clearSpath()
        {
          this.c = Collections.emptyList();
          return this;
        }
        
        public Steps clearSstartLocation()
        {
          this.D = Collections.emptyList();
          return this;
        }
        
        public Steps clearStrafficmarkLoc()
        {
          this.F = Collections.emptyList();
          return this;
        }
        
        public Steps clearTrafficType()
        {
          this.G = false;
          this.H = 0;
          return this;
        }
        
        public Steps clearTurnType()
        {
          this.l = false;
          this.m = 0;
          return this;
        }
        
        public Steps clearType()
        {
          this.f = false;
          this.g = 0;
          return this;
        }
        
        public Steps clearWalkType()
        {
          this.n = false;
          this.o = 0;
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.I < 0) {
            getSerializedSize();
          }
          return this.I;
        }
        
        public int getCircleRoad()
        {
          return this.s;
        }
        
        public int getDirection()
        {
          return this.A;
        }
        
        public int getDistance()
        {
          return this.w;
        }
        
        public int getDuration()
        {
          return this.y;
        }
        
        public int getFirstLinkEndIndex()
        {
          return this.k;
        }
        
        public int getHasPanid()
        {
          return this.C;
        }
        
        public String getInstructions()
        {
          return this.e;
        }
        
        public int getLight()
        {
          return this.q;
        }
        
        public Links getLinks(int paramInt)
        {
          return (Links)this.a.get(paramInt);
        }
        
        public int getLinksCount()
        {
          return this.a.size();
        }
        
        public List<Links> getLinksList()
        {
          return this.a;
        }
        
        public String getName()
        {
          return this.i;
        }
        
        public Pois getPois(int paramInt)
        {
          return (Pois)this.b.get(paramInt);
        }
        
        public int getPoisCount()
        {
          return this.b.size();
        }
        
        public List<Pois> getPoisList()
        {
          return this.b;
        }
        
        public int getRoadWidth()
        {
          return this.u;
        }
        
        public int getSendLocation(int paramInt)
        {
          return ((Integer)this.E.get(paramInt)).intValue();
        }
        
        public int getSendLocationCount()
        {
          return this.E.size();
        }
        
        public List<Integer> getSendLocationList()
        {
          return this.E;
        }
        
        public int getSerializedSize()
        {
          int i4 = 0;
          Iterator localIterator = getSpathList().iterator();
          for (int i1 = 0; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i1) {}
          int i2 = 0 + i1 + getSpathList().size() * 1;
          i1 = i2;
          if (hasInstructions()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getInstructions());
          }
          i2 = i1;
          if (hasType()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getType());
          }
          i1 = i2;
          if (hasName()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getName());
          }
          i2 = i1;
          if (hasFirstLinkEndIndex()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getFirstLinkEndIndex());
          }
          i1 = i2;
          if (hasTurnType()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getTurnType());
          }
          i2 = i1;
          if (hasWalkType()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getWalkType());
          }
          i1 = i2;
          if (hasLight()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getLight());
          }
          i2 = i1;
          if (hasCircleRoad()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getCircleRoad());
          }
          i1 = i2;
          if (hasRoadWidth()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getRoadWidth());
          }
          i2 = i1;
          if (hasDistance()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getDistance());
          }
          i1 = i2;
          if (hasDuration()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getDuration());
          }
          localIterator = getLinksList().iterator();
          for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(13, (Links)localIterator.next()) + i2) {}
          localIterator = getPoisList().iterator();
          while (localIterator.hasNext()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(14, (Pois)localIterator.next());
          }
          i1 = i2;
          if (hasDirection()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(15, getDirection());
          }
          i2 = i1;
          if (hasHasPanid()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(16, getHasPanid());
          }
          localIterator = getSstartLocationList().iterator();
          for (i1 = 0; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i1) {}
          int i5 = getSstartLocationList().size();
          localIterator = getSendLocationList().iterator();
          for (int i3 = 0; localIterator.hasNext(); i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i3) {}
          int i6 = getSendLocationList().size();
          localIterator = getStrafficmarkLocList().iterator();
          while (localIterator.hasNext()) {
            i4 += CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue());
          }
          i2 = i6 * 2 + (i2 + i1 + i5 * 2 + i3) + i4 + getStrafficmarkLocList().size() * 2;
          i1 = i2;
          if (hasTrafficType()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(20, getTrafficType());
          }
          this.I = i1;
          return i1;
        }
        
        public int getSpath(int paramInt)
        {
          return ((Integer)this.c.get(paramInt)).intValue();
        }
        
        public int getSpathCount()
        {
          return this.c.size();
        }
        
        public List<Integer> getSpathList()
        {
          return this.c;
        }
        
        public int getSstartLocation(int paramInt)
        {
          return ((Integer)this.D.get(paramInt)).intValue();
        }
        
        public int getSstartLocationCount()
        {
          return this.D.size();
        }
        
        public List<Integer> getSstartLocationList()
        {
          return this.D;
        }
        
        public int getStrafficmarkLoc(int paramInt)
        {
          return ((Integer)this.F.get(paramInt)).intValue();
        }
        
        public int getStrafficmarkLocCount()
        {
          return this.F.size();
        }
        
        public List<Integer> getStrafficmarkLocList()
        {
          return this.F;
        }
        
        public int getTrafficType()
        {
          return this.H;
        }
        
        public int getTurnType()
        {
          return this.m;
        }
        
        public int getType()
        {
          return this.g;
        }
        
        public int getWalkType()
        {
          return this.o;
        }
        
        public boolean hasCircleRoad()
        {
          return this.r;
        }
        
        public boolean hasDirection()
        {
          return this.z;
        }
        
        public boolean hasDistance()
        {
          return this.v;
        }
        
        public boolean hasDuration()
        {
          return this.x;
        }
        
        public boolean hasFirstLinkEndIndex()
        {
          return this.j;
        }
        
        public boolean hasHasPanid()
        {
          return this.B;
        }
        
        public boolean hasInstructions()
        {
          return this.d;
        }
        
        public boolean hasLight()
        {
          return this.p;
        }
        
        public boolean hasName()
        {
          return this.h;
        }
        
        public boolean hasRoadWidth()
        {
          return this.t;
        }
        
        public boolean hasTrafficType()
        {
          return this.G;
        }
        
        public boolean hasTurnType()
        {
          return this.l;
        }
        
        public boolean hasType()
        {
          return this.f;
        }
        
        public boolean hasWalkType()
        {
          return this.n;
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
              addSpath(paramCodedInputStreamMicro.readSInt32());
              break;
            case 18: 
              setInstructions(paramCodedInputStreamMicro.readString());
              break;
            case 24: 
              setType(paramCodedInputStreamMicro.readInt32());
              break;
            case 34: 
              setName(paramCodedInputStreamMicro.readString());
              break;
            case 40: 
              setFirstLinkEndIndex(paramCodedInputStreamMicro.readInt32());
              break;
            case 48: 
              setTurnType(paramCodedInputStreamMicro.readInt32());
              break;
            case 56: 
              setWalkType(paramCodedInputStreamMicro.readInt32());
              break;
            case 64: 
              setLight(paramCodedInputStreamMicro.readInt32());
              break;
            case 72: 
              setCircleRoad(paramCodedInputStreamMicro.readInt32());
              break;
            case 80: 
              setRoadWidth(paramCodedInputStreamMicro.readInt32());
              break;
            case 88: 
              setDistance(paramCodedInputStreamMicro.readInt32());
              break;
            case 96: 
              setDuration(paramCodedInputStreamMicro.readInt32());
              break;
            case 106: 
              localObject = new Links();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addLinks((Links)localObject);
              break;
            case 114: 
              localObject = new Pois();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addPois((Pois)localObject);
              break;
            case 120: 
              setDirection(paramCodedInputStreamMicro.readInt32());
              break;
            case 128: 
              setHasPanid(paramCodedInputStreamMicro.readInt32());
              break;
            case 136: 
              addSstartLocation(paramCodedInputStreamMicro.readSInt32());
              break;
            case 144: 
              addSendLocation(paramCodedInputStreamMicro.readSInt32());
              break;
            case 152: 
              addStrafficmarkLoc(paramCodedInputStreamMicro.readInt32());
              break;
            case 160: 
              setTrafficType(paramCodedInputStreamMicro.readInt32());
            }
          }
        }
        
        public Steps setCircleRoad(int paramInt)
        {
          this.r = true;
          this.s = paramInt;
          return this;
        }
        
        public Steps setDirection(int paramInt)
        {
          this.z = true;
          this.A = paramInt;
          return this;
        }
        
        public Steps setDistance(int paramInt)
        {
          this.v = true;
          this.w = paramInt;
          return this;
        }
        
        public Steps setDuration(int paramInt)
        {
          this.x = true;
          this.y = paramInt;
          return this;
        }
        
        public Steps setFirstLinkEndIndex(int paramInt)
        {
          this.j = true;
          this.k = paramInt;
          return this;
        }
        
        public Steps setHasPanid(int paramInt)
        {
          this.B = true;
          this.C = paramInt;
          return this;
        }
        
        public Steps setInstructions(String paramString)
        {
          this.d = true;
          this.e = paramString;
          return this;
        }
        
        public Steps setLight(int paramInt)
        {
          this.p = true;
          this.q = paramInt;
          return this;
        }
        
        public Steps setLinks(int paramInt, Links paramLinks)
        {
          if (paramLinks == null) {
            return this;
          }
          this.a.set(paramInt, paramLinks);
          return this;
        }
        
        public Steps setName(String paramString)
        {
          this.h = true;
          this.i = paramString;
          return this;
        }
        
        public Steps setPois(int paramInt, Pois paramPois)
        {
          if (paramPois == null) {
            return this;
          }
          this.b.set(paramInt, paramPois);
          return this;
        }
        
        public Steps setRoadWidth(int paramInt)
        {
          this.t = true;
          this.u = paramInt;
          return this;
        }
        
        public Steps setSendLocation(int paramInt1, int paramInt2)
        {
          this.E.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public Steps setSpath(int paramInt1, int paramInt2)
        {
          this.c.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public Steps setSstartLocation(int paramInt1, int paramInt2)
        {
          this.D.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public Steps setStrafficmarkLoc(int paramInt1, int paramInt2)
        {
          this.F.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public Steps setTrafficType(int paramInt)
        {
          this.G = true;
          this.H = paramInt;
          return this;
        }
        
        public Steps setTurnType(int paramInt)
        {
          this.l = true;
          this.m = paramInt;
          return this;
        }
        
        public Steps setType(int paramInt)
        {
          this.f = true;
          this.g = paramInt;
          return this;
        }
        
        public Steps setWalkType(int paramInt)
        {
          this.n = true;
          this.o = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getSpathList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(1, ((Integer)localIterator.next()).intValue());
          }
          if (hasInstructions()) {
            paramCodedOutputStreamMicro.writeString(2, getInstructions());
          }
          if (hasType()) {
            paramCodedOutputStreamMicro.writeInt32(3, getType());
          }
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(4, getName());
          }
          if (hasFirstLinkEndIndex()) {
            paramCodedOutputStreamMicro.writeInt32(5, getFirstLinkEndIndex());
          }
          if (hasTurnType()) {
            paramCodedOutputStreamMicro.writeInt32(6, getTurnType());
          }
          if (hasWalkType()) {
            paramCodedOutputStreamMicro.writeInt32(7, getWalkType());
          }
          if (hasLight()) {
            paramCodedOutputStreamMicro.writeInt32(8, getLight());
          }
          if (hasCircleRoad()) {
            paramCodedOutputStreamMicro.writeInt32(9, getCircleRoad());
          }
          if (hasRoadWidth()) {
            paramCodedOutputStreamMicro.writeInt32(10, getRoadWidth());
          }
          if (hasDistance()) {
            paramCodedOutputStreamMicro.writeInt32(11, getDistance());
          }
          if (hasDuration()) {
            paramCodedOutputStreamMicro.writeInt32(12, getDuration());
          }
          localIterator = getLinksList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(13, (Links)localIterator.next());
          }
          localIterator = getPoisList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(14, (Pois)localIterator.next());
          }
          if (hasDirection()) {
            paramCodedOutputStreamMicro.writeInt32(15, getDirection());
          }
          if (hasHasPanid()) {
            paramCodedOutputStreamMicro.writeInt32(16, getHasPanid());
          }
          localIterator = getSstartLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(17, ((Integer)localIterator.next()).intValue());
          }
          localIterator = getSendLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(18, ((Integer)localIterator.next()).intValue());
          }
          localIterator = getStrafficmarkLocList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeInt32(19, ((Integer)localIterator.next()).intValue());
          }
          if (hasTrafficType()) {
            paramCodedOutputStreamMicro.writeInt32(20, getTrafficType());
          }
        }
        
        public static final class Links
          extends MessageMicro
        {
          public static final int HAS_PANID_FIELD_NUMBER = 4;
          public static final int IDX_FIELD_NUMBER = 2;
          public static final int ID_FIELD_NUMBER = 1;
          public static final int LENGTH_FIELD_NUMBER = 3;
          public static final int LINK_TYPE_FIELD_NUMBER = 5;
          private boolean a;
          private String b = "";
          private boolean c;
          private int d = 0;
          private boolean e;
          private int f = 0;
          private boolean g;
          private int h = 0;
          private boolean i;
          private int j = 0;
          private int k = -1;
          
          public static Links parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Links().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Links parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Links)new Links().mergeFrom(paramArrayOfByte);
          }
          
          public final Links clear()
          {
            clearId();
            clearIdx();
            clearLength();
            clearHasPanid();
            clearLinkType();
            this.k = -1;
            return this;
          }
          
          public Links clearHasPanid()
          {
            this.g = false;
            this.h = 0;
            return this;
          }
          
          public Links clearId()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Links clearIdx()
          {
            this.c = false;
            this.d = 0;
            return this;
          }
          
          public Links clearLength()
          {
            this.e = false;
            this.f = 0;
            return this;
          }
          
          public Links clearLinkType()
          {
            this.i = false;
            this.j = 0;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.k < 0) {
              getSerializedSize();
            }
            return this.k;
          }
          
          public int getHasPanid()
          {
            return this.h;
          }
          
          public String getId()
          {
            return this.b;
          }
          
          public int getIdx()
          {
            return this.d;
          }
          
          public int getLength()
          {
            return this.f;
          }
          
          public int getLinkType()
          {
            return this.j;
          }
          
          public int getSerializedSize()
          {
            int n = 0;
            if (hasId()) {
              n = 0 + CodedOutputStreamMicro.computeStringSize(1, getId());
            }
            int m = n;
            if (hasIdx()) {
              m = n + CodedOutputStreamMicro.computeInt32Size(2, getIdx());
            }
            n = m;
            if (hasLength()) {
              n = m + CodedOutputStreamMicro.computeInt32Size(3, getLength());
            }
            m = n;
            if (hasHasPanid()) {
              m = n + CodedOutputStreamMicro.computeInt32Size(4, getHasPanid());
            }
            n = m;
            if (hasLinkType()) {
              n = m + CodedOutputStreamMicro.computeInt32Size(5, getLinkType());
            }
            this.k = n;
            return n;
          }
          
          public boolean hasHasPanid()
          {
            return this.g;
          }
          
          public boolean hasId()
          {
            return this.a;
          }
          
          public boolean hasIdx()
          {
            return this.c;
          }
          
          public boolean hasLength()
          {
            return this.e;
          }
          
          public boolean hasLinkType()
          {
            return this.i;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Links mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setId(paramCodedInputStreamMicro.readString());
                break;
              case 16: 
                setIdx(paramCodedInputStreamMicro.readInt32());
                break;
              case 24: 
                setLength(paramCodedInputStreamMicro.readInt32());
                break;
              case 32: 
                setHasPanid(paramCodedInputStreamMicro.readInt32());
                break;
              case 40: 
                setLinkType(paramCodedInputStreamMicro.readInt32());
              }
            }
          }
          
          public Links setHasPanid(int paramInt)
          {
            this.g = true;
            this.h = paramInt;
            return this;
          }
          
          public Links setId(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Links setIdx(int paramInt)
          {
            this.c = true;
            this.d = paramInt;
            return this;
          }
          
          public Links setLength(int paramInt)
          {
            this.e = true;
            this.f = paramInt;
            return this;
          }
          
          public Links setLinkType(int paramInt)
          {
            this.i = true;
            this.j = paramInt;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasId()) {
              paramCodedOutputStreamMicro.writeString(1, getId());
            }
            if (hasIdx()) {
              paramCodedOutputStreamMicro.writeInt32(2, getIdx());
            }
            if (hasLength()) {
              paramCodedOutputStreamMicro.writeInt32(3, getLength());
            }
            if (hasHasPanid()) {
              paramCodedOutputStreamMicro.writeInt32(4, getHasPanid());
            }
            if (hasLinkType()) {
              paramCodedOutputStreamMicro.writeInt32(5, getLinkType());
            }
          }
        }
        
        public static final class Pois
          extends MessageMicro
        {
          public static final int HEADING_FIELD_NUMBER = 4;
          public static final int NAME_FIELD_NUMBER = 1;
          public static final int PANOID_FIELD_NUMBER = 6;
          public static final int PITCH_FIELD_NUMBER = 5;
          public static final int SIDE_FIELD_NUMBER = 3;
          public static final int SLOCATION_FIELD_NUMBER = 2;
          private boolean a;
          private String b = "";
          private List<Integer> c = Collections.emptyList();
          private boolean d;
          private int e = 0;
          private boolean f;
          private String g = "";
          private boolean h;
          private String i = "";
          private boolean j;
          private String k = "";
          private int l = -1;
          
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
            if (this.c.isEmpty()) {
              this.c = new ArrayList();
            }
            this.c.add(Integer.valueOf(paramInt));
            return this;
          }
          
          public final Pois clear()
          {
            clearName();
            clearSlocation();
            clearSide();
            clearHeading();
            clearPitch();
            clearPanoid();
            this.l = -1;
            return this;
          }
          
          public Pois clearHeading()
          {
            this.f = false;
            this.g = "";
            return this;
          }
          
          public Pois clearName()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Pois clearPanoid()
          {
            this.j = false;
            this.k = "";
            return this;
          }
          
          public Pois clearPitch()
          {
            this.h = false;
            this.i = "";
            return this;
          }
          
          public Pois clearSide()
          {
            this.d = false;
            this.e = 0;
            return this;
          }
          
          public Pois clearSlocation()
          {
            this.c = Collections.emptyList();
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.l < 0) {
              getSerializedSize();
            }
            return this.l;
          }
          
          public String getHeading()
          {
            return this.g;
          }
          
          public String getName()
          {
            return this.b;
          }
          
          public String getPanoid()
          {
            return this.k;
          }
          
          public String getPitch()
          {
            return this.i;
          }
          
          public int getSerializedSize()
          {
            int n = 0;
            if (hasName()) {}
            for (int m = CodedOutputStreamMicro.computeStringSize(1, getName()) + 0;; m = 0)
            {
              Iterator localIterator = getSlocationList().iterator();
              while (localIterator.hasNext()) {
                n += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
              }
              n = m + n + getSlocationList().size() * 1;
              m = n;
              if (hasSide()) {
                m = n + CodedOutputStreamMicro.computeInt32Size(3, getSide());
              }
              n = m;
              if (hasHeading()) {
                n = m + CodedOutputStreamMicro.computeStringSize(4, getHeading());
              }
              m = n;
              if (hasPitch()) {
                m = n + CodedOutputStreamMicro.computeStringSize(5, getPitch());
              }
              n = m;
              if (hasPanoid()) {
                n = m + CodedOutputStreamMicro.computeStringSize(6, getPanoid());
              }
              this.l = n;
              return n;
            }
          }
          
          public int getSide()
          {
            return this.e;
          }
          
          public int getSlocation(int paramInt)
          {
            return ((Integer)this.c.get(paramInt)).intValue();
          }
          
          public int getSlocationCount()
          {
            return this.c.size();
          }
          
          public List<Integer> getSlocationList()
          {
            return this.c;
          }
          
          public boolean hasHeading()
          {
            return this.f;
          }
          
          public boolean hasName()
          {
            return this.a;
          }
          
          public boolean hasPanoid()
          {
            return this.j;
          }
          
          public boolean hasPitch()
          {
            return this.h;
          }
          
          public boolean hasSide()
          {
            return this.d;
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
              int m = paramCodedInputStreamMicro.readTag();
              switch (m)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
                break;
              case 0: 
                return this;
              case 10: 
                setName(paramCodedInputStreamMicro.readString());
                break;
              case 16: 
                addSlocation(paramCodedInputStreamMicro.readSInt32());
                break;
              case 24: 
                setSide(paramCodedInputStreamMicro.readInt32());
                break;
              case 34: 
                setHeading(paramCodedInputStreamMicro.readString());
                break;
              case 42: 
                setPitch(paramCodedInputStreamMicro.readString());
                break;
              case 50: 
                setPanoid(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Pois setHeading(String paramString)
          {
            this.f = true;
            this.g = paramString;
            return this;
          }
          
          public Pois setName(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Pois setPanoid(String paramString)
          {
            this.j = true;
            this.k = paramString;
            return this;
          }
          
          public Pois setPitch(String paramString)
          {
            this.h = true;
            this.i = paramString;
            return this;
          }
          
          public Pois setSide(int paramInt)
          {
            this.d = true;
            this.e = paramInt;
            return this;
          }
          
          public Pois setSlocation(int paramInt1, int paramInt2)
          {
            this.c.set(paramInt1, Integer.valueOf(paramInt2));
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasName()) {
              paramCodedOutputStreamMicro.writeString(1, getName());
            }
            Iterator localIterator = getSlocationList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeSInt32(2, ((Integer)localIterator.next()).intValue());
            }
            if (hasSide()) {
              paramCodedOutputStreamMicro.writeInt32(3, getSide());
            }
            if (hasHeading()) {
              paramCodedOutputStreamMicro.writeString(4, getHeading());
            }
            if (hasPitch()) {
              paramCodedOutputStreamMicro.writeString(5, getPitch());
            }
            if (hasPanoid()) {
              paramCodedOutputStreamMicro.writeString(6, getPanoid());
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
    private String b = "";
    private boolean c;
    private String d = "";
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
      this.b = "";
      return this;
    }
    
    public Taxi clearDuration()
    {
      this.c = false;
      this.d = "";
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
    
    public String getDistance()
    {
      return this.b;
    }
    
    public String getDuration()
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
        j = 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance());
      }
      int i = j;
      if (hasDuration()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getDuration());
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
        case 10: 
          setDistance(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setDuration(paramCodedInputStreamMicro.readString());
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
    
    public Taxi setDistance(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Taxi setDuration(String paramString)
    {
      this.c = true;
      this.d = paramString;
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
        paramCodedOutputStreamMicro.writeString(1, getDistance());
      }
      if (hasDuration()) {
        paramCodedOutputStreamMicro.writeString(2, getDuration());
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
      public static final int DESC_FIELD_NUMBER = 4;
      public static final int KM_PRICE_FIELD_NUMBER = 1;
      public static final int START_PRICE_FIELD_NUMBER = 2;
      public static final int TOTAL_PRICE_FIELD_NUMBER = 3;
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
        clearKmPrice();
        clearStartPrice();
        clearTotalPrice();
        clearDesc();
        this.i = -1;
        return this;
      }
      
      public Detail clearDesc()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Detail clearKmPrice()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Detail clearStartPrice()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Detail clearTotalPrice()
      {
        this.e = false;
        this.f = "";
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
        return this.h;
      }
      
      public String getKmPrice()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasKmPrice()) {
          k = 0 + CodedOutputStreamMicro.computeStringSize(1, getKmPrice());
        }
        int j = k;
        if (hasStartPrice()) {
          j = k + CodedOutputStreamMicro.computeStringSize(2, getStartPrice());
        }
        k = j;
        if (hasTotalPrice()) {
          k = j + CodedOutputStreamMicro.computeStringSize(3, getTotalPrice());
        }
        j = k;
        if (hasDesc()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getDesc());
        }
        this.i = j;
        return j;
      }
      
      public String getStartPrice()
      {
        return this.d;
      }
      
      public String getTotalPrice()
      {
        return this.f;
      }
      
      public boolean hasDesc()
      {
        return this.g;
      }
      
      public boolean hasKmPrice()
      {
        return this.a;
      }
      
      public boolean hasStartPrice()
      {
        return this.c;
      }
      
      public boolean hasTotalPrice()
      {
        return this.e;
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
            setKmPrice(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setStartPrice(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setTotalPrice(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setDesc(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Detail setDesc(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Detail setKmPrice(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Detail setStartPrice(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Detail setTotalPrice(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasKmPrice()) {
          paramCodedOutputStreamMicro.writeString(1, getKmPrice());
        }
        if (hasStartPrice()) {
          paramCodedOutputStreamMicro.writeString(2, getStartPrice());
        }
        if (hasTotalPrice()) {
          paramCodedOutputStreamMicro.writeString(3, getTotalPrice());
        }
        if (hasDesc()) {
          paramCodedOutputStreamMicro.writeString(4, getDesc());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/WalkPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */