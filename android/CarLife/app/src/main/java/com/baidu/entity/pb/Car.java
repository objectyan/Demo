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

public final class Car
  extends MessageMicro
{
  public static final int CURRENT_CITY_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 4;
  public static final int ROUTES_FIELD_NUMBER = 3;
  public static final int TAXI_FIELD_NUMBER = 1;
  public static final int TRAFFIC_FIELD_NUMBER = 5;
  private boolean a;
  private Taxi b = null;
  private boolean c;
  private CurrentCity d = null;
  private List<Routes> e = Collections.emptyList();
  private boolean f;
  private Option g = null;
  private boolean h;
  private Traffic i = null;
  private int j = -1;
  
  public static Car parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Car().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Car parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Car)new Car().mergeFrom(paramArrayOfByte);
  }
  
  public Car addRoutes(Routes paramRoutes)
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
  
  public final Car clear()
  {
    clearTaxi();
    clearCurrentCity();
    clearRoutes();
    clearOption();
    clearTraffic();
    this.j = -1;
    return this;
  }
  
  public Car clearCurrentCity()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Car clearOption()
  {
    this.f = false;
    this.g = null;
    return this;
  }
  
  public Car clearRoutes()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public Car clearTaxi()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public Car clearTraffic()
  {
    this.h = false;
    this.i = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.j < 0) {
      getSerializedSize();
    }
    return this.j;
  }
  
  public CurrentCity getCurrentCity()
  {
    return this.d;
  }
  
  public Option getOption()
  {
    return this.g;
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
    int k = 0;
    if (hasTaxi()) {
      k = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTaxi());
    }
    int m = k;
    if (hasCurrentCity()) {
      m = k + CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
    }
    Iterator localIterator = getRoutesList().iterator();
    while (localIterator.hasNext()) {
      m = CodedOutputStreamMicro.computeMessageSize(3, (Routes)localIterator.next()) + m;
    }
    k = m;
    if (hasOption()) {
      k = m + CodedOutputStreamMicro.computeMessageSize(4, getOption());
    }
    m = k;
    if (hasTraffic()) {
      m = k + CodedOutputStreamMicro.computeMessageSize(5, getTraffic());
    }
    this.j = m;
    return m;
  }
  
  public Taxi getTaxi()
  {
    return this.b;
  }
  
  public Traffic getTraffic()
  {
    return this.i;
  }
  
  public boolean hasCurrentCity()
  {
    return this.c;
  }
  
  public boolean hasOption()
  {
    return this.f;
  }
  
  public boolean hasTaxi()
  {
    return this.a;
  }
  
  public boolean hasTraffic()
  {
    return this.h;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Car mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int k = paramCodedInputStreamMicro.readTag();
      Object localObject;
      switch (k)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, k)) {}
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
        localObject = new Traffic();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setTraffic((Traffic)localObject);
      }
    }
  }
  
  public Car setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.c = true;
    this.d = paramCurrentCity;
    return this;
  }
  
  public Car setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.f = true;
    this.g = paramOption;
    return this;
  }
  
  public Car setRoutes(int paramInt, Routes paramRoutes)
  {
    if (paramRoutes == null) {
      return this;
    }
    this.e.set(paramInt, paramRoutes);
    return this;
  }
  
  public Car setTaxi(Taxi paramTaxi)
  {
    if (paramTaxi == null) {
      return clearTaxi();
    }
    this.a = true;
    this.b = paramTaxi;
    return this;
  }
  
  public Car setTraffic(Traffic paramTraffic)
  {
    if (paramTraffic == null) {
      return clearTraffic();
    }
    this.h = true;
    this.i = paramTraffic;
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
    if (hasTraffic()) {
      paramCodedOutputStreamMicro.writeMessage(5, getTraffic());
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int AVOID_JAM_FIELD_NUMBER = 6;
    public static final int END_CITY_FIELD_NUMBER = 8;
    public static final int END_FIELD_NUMBER = 5;
    public static final int EXPTIME_FIELD_NUMBER = 2;
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
    private boolean i;
    private End j = null;
    private boolean k;
    private int l = 0;
    private boolean m;
    private StartCity n = null;
    private boolean o;
    private EndCity p = null;
    private int q = -1;
    
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
      clearExptime();
      clearSy();
      clearStart();
      clearEnd();
      clearAvoidJam();
      clearStartCity();
      clearEndCity();
      this.q = -1;
      return this;
    }
    
    public Option clearAvoidJam()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public Option clearEnd()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public Option clearEndCity()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public Option clearExptime()
    {
      this.c = false;
      this.d = "";
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
      this.m = false;
      this.n = null;
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
      return this.l;
    }
    
    public int getCachedSize()
    {
      if (this.q < 0) {
        getSerializedSize();
      }
      return this.q;
    }
    
    public End getEnd()
    {
      return this.j;
    }
    
    public EndCity getEndCity()
    {
      return this.p;
    }
    
    public String getExptime()
    {
      return this.d;
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
      i2 = i1;
      if (hasEnd()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getEnd());
      }
      i1 = i2;
      if (hasAvoidJam()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getAvoidJam());
      }
      i2 = i1;
      if (hasStartCity()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
      }
      i1 = i2;
      if (hasEndCity()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getEndCity());
      }
      this.q = i1;
      return i1;
    }
    
    public Start getStart()
    {
      return this.h;
    }
    
    public StartCity getStartCity()
    {
      return this.n;
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
      return this.k;
    }
    
    public boolean hasEnd()
    {
      return this.i;
    }
    
    public boolean hasEndCity()
    {
      return this.o;
    }
    
    public boolean hasExptime()
    {
      return this.c;
    }
    
    public boolean hasStart()
    {
      return this.g;
    }
    
    public boolean hasStartCity()
    {
      return this.m;
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
          setEndCity((EndCity)localObject);
        }
      }
    }
    
    public Option setAvoidJam(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
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
    
    public Option setEndCity(EndCity paramEndCity)
    {
      if (paramEndCity == null) {
        return clearEndCity();
      }
      this.o = true;
      this.p = paramEndCity;
      return this;
    }
    
    public Option setExptime(String paramString)
    {
      this.c = true;
      this.d = paramString;
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
      this.m = true;
      this.n = paramStartCity;
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
      if (hasAvoidJam()) {
        paramCodedOutputStreamMicro.writeInt32(6, getAvoidJam());
      }
      if (hasStartCity()) {
        paramCodedOutputStreamMicro.writeMessage(7, getStartCity());
      }
      if (hasEndCity()) {
        paramCodedOutputStreamMicro.writeMessage(8, getEndCity());
      }
    }
    
    public static final class End
      extends MessageMicro
    {
      public static final int BUSSTOP_FIELD_NUMBER = 4;
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
      private int j = -1;
      
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
        clearBusstop();
        clearSpt();
        this.j = -1;
        return this;
      }
      
      public End clearBusstop()
      {
        this.g = false;
        this.h = false;
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
      
      public boolean getBusstop()
      {
        return this.h;
      }
      
      public int getCachedSize()
      {
        if (this.j < 0) {
          getSerializedSize();
        }
        return this.j;
      }
      
      public String getPt()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int n = 0;
        if (hasPt()) {}
        for (int m = CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0;; m = 0)
        {
          int k = m;
          if (hasWd()) {
            k = m + CodedOutputStreamMicro.computeStringSize(2, getWd());
          }
          m = k;
          if (hasUid()) {
            m = k + CodedOutputStreamMicro.computeStringSize(3, getUid());
          }
          if (hasBusstop()) {}
          for (k = m + CodedOutputStreamMicro.computeBoolSize(4, getBusstop());; k = m)
          {
            Iterator localIterator = getSptList().iterator();
            m = n;
            while (localIterator.hasNext()) {
              m += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            k = k + m + getSptList().size() * 1;
            this.j = k;
            return k;
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
      
      public boolean hasBusstop()
      {
        return this.g;
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
          int k = paramCodedInputStreamMicro.readTag();
          switch (k)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, k)) {}
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
            setBusstop(paramCodedInputStreamMicro.readBool());
            break;
          case 40: 
            addSpt(paramCodedInputStreamMicro.readSInt32());
          }
        }
      }
      
      public End setBusstop(boolean paramBoolean)
      {
        this.g = true;
        this.h = paramBoolean;
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
        if (hasBusstop()) {
          paramCodedOutputStreamMicro.writeBool(4, getBusstop());
        }
        Iterator localIterator = getSptList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(5, ((Integer)localIterator.next()).intValue());
        }
      }
    }
    
    public static final class EndCity
      extends MessageMicro
    {
      public static final int CODE_FIELD_NUMBER = 1;
      public static final int NAME_FIELD_NUMBER = 2;
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
        clearName();
        this.e = -1;
        return this;
      }
      
      public EndCity clearCode()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public EndCity clearName()
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
      
      public int getCode()
      {
        return this.b;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasCode()) {
          i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        int j = i;
        if (hasName()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        this.e = j;
        return j;
      }
      
      public boolean hasCode()
      {
        return this.a;
      }
      
      public boolean hasName()
      {
        return this.c;
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
            setName(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public EndCity setCode(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public EndCity setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
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
      }
    }
    
    public static final class Start
      extends MessageMicro
    {
      public static final int BUSSTOP_FIELD_NUMBER = 4;
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
      private int j = -1;
      
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
        clearBusstop();
        clearSpt();
        this.j = -1;
        return this;
      }
      
      public Start clearBusstop()
      {
        this.g = false;
        this.h = false;
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
      
      public boolean getBusstop()
      {
        return this.h;
      }
      
      public int getCachedSize()
      {
        if (this.j < 0) {
          getSerializedSize();
        }
        return this.j;
      }
      
      public String getPt()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int n = 0;
        if (hasPt()) {}
        for (int m = CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0;; m = 0)
        {
          int k = m;
          if (hasWd()) {
            k = m + CodedOutputStreamMicro.computeStringSize(2, getWd());
          }
          m = k;
          if (hasUid()) {
            m = k + CodedOutputStreamMicro.computeStringSize(3, getUid());
          }
          if (hasBusstop()) {}
          for (k = m + CodedOutputStreamMicro.computeBoolSize(4, getBusstop());; k = m)
          {
            Iterator localIterator = getSptList().iterator();
            m = n;
            while (localIterator.hasNext()) {
              m += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            k = k + m + getSptList().size() * 1;
            this.j = k;
            return k;
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
      
      public boolean hasBusstop()
      {
        return this.g;
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
          int k = paramCodedInputStreamMicro.readTag();
          switch (k)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, k)) {}
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
            setBusstop(paramCodedInputStreamMicro.readBool());
            break;
          case 40: 
            addSpt(paramCodedInputStreamMicro.readSInt32());
          }
        }
      }
      
      public Start setBusstop(boolean paramBoolean)
      {
        this.g = true;
        this.h = paramBoolean;
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
        if (hasBusstop()) {
          paramCodedOutputStreamMicro.writeBool(4, getBusstop());
        }
        Iterator localIterator = getSptList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(5, ((Integer)localIterator.next()).intValue());
        }
      }
    }
    
    public static final class StartCity
      extends MessageMicro
    {
      public static final int CODE_FIELD_NUMBER = 1;
      public static final int NAME_FIELD_NUMBER = 2;
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
        clearName();
        this.e = -1;
        return this;
      }
      
      public StartCity clearCode()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public StartCity clearName()
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
      
      public int getCode()
      {
        return this.b;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasCode()) {
          i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        int j = i;
        if (hasName()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        this.e = j;
        return j;
      }
      
      public boolean hasCode()
      {
        return this.a;
      }
      
      public boolean hasName()
      {
        return this.c;
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
            setName(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public StartCity setCode(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public StartCity setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
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
      public static final int DISTANCE_FIELD_NUMBER = 1;
      public static final int DURATION_FIELD_NUMBER = 2;
      public static final int END_LOCATION_FIELD_NUMBER = 3;
      public static final int SEND_LOCATION_FIELD_NUMBER = 6;
      public static final int SSTART_LOCATION_FIELD_NUMBER = 7;
      public static final int START_LOCATION_FIELD_NUMBER = 4;
      public static final int STEPS_FIELD_NUMBER = 5;
      private boolean a;
      private int b = 0;
      private boolean c;
      private int d = 0;
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private List<Steps> i = Collections.emptyList();
      private List<Integer> j = Collections.emptyList();
      private List<Integer> k = Collections.emptyList();
      private int l = -1;
      
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
      
      public Legs addSendLocation(int paramInt)
      {
        if (this.j.isEmpty()) {
          this.j = new ArrayList();
        }
        this.j.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Legs addSstartLocation(int paramInt)
      {
        if (this.k.isEmpty()) {
          this.k = new ArrayList();
        }
        this.k.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Legs addSteps(Steps paramSteps)
      {
        if (paramSteps == null) {
          return this;
        }
        if (this.i.isEmpty()) {
          this.i = new ArrayList();
        }
        this.i.add(paramSteps);
        return this;
      }
      
      public final Legs clear()
      {
        clearDistance();
        clearDuration();
        clearEndLocation();
        clearStartLocation();
        clearSteps();
        clearSendLocation();
        clearSstartLocation();
        this.l = -1;
        return this;
      }
      
      public Legs clearDistance()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public Legs clearDuration()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public Legs clearEndLocation()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Legs clearSendLocation()
      {
        this.j = Collections.emptyList();
        return this;
      }
      
      public Legs clearSstartLocation()
      {
        this.k = Collections.emptyList();
        return this;
      }
      
      public Legs clearStartLocation()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Legs clearSteps()
      {
        this.i = Collections.emptyList();
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.l < 0) {
          getSerializedSize();
        }
        return this.l;
      }
      
      public int getDistance()
      {
        return this.b;
      }
      
      public int getDuration()
      {
        return this.d;
      }
      
      public String getEndLocation()
      {
        return this.f;
      }
      
      public int getSendLocation(int paramInt)
      {
        return ((Integer)this.j.get(paramInt)).intValue();
      }
      
      public int getSendLocationCount()
      {
        return this.j.size();
      }
      
      public List<Integer> getSendLocationList()
      {
        return this.j;
      }
      
      public int getSerializedSize()
      {
        int i1 = 0;
        if (hasDistance()) {}
        for (int n = CodedOutputStreamMicro.computeInt32Size(1, getDistance()) + 0;; n = 0)
        {
          int m = n;
          if (hasDuration()) {
            m = n + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
          }
          n = m;
          if (hasEndLocation()) {
            n = m + CodedOutputStreamMicro.computeStringSize(3, getEndLocation());
          }
          m = n;
          if (hasStartLocation()) {
            m = n + CodedOutputStreamMicro.computeStringSize(4, getStartLocation());
          }
          Iterator localIterator = getStepsList().iterator();
          while (localIterator.hasNext()) {
            m = CodedOutputStreamMicro.computeMessageSize(5, (Steps)localIterator.next()) + m;
          }
          localIterator = getSendLocationList().iterator();
          for (n = 0; localIterator.hasNext(); n = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + n) {}
          int i2 = getSendLocationList().size();
          localIterator = getSstartLocationList().iterator();
          while (localIterator.hasNext()) {
            i1 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
          }
          m = i2 * 1 + (m + n) + i1 + getSstartLocationList().size() * 1;
          this.l = m;
          return m;
        }
      }
      
      public int getSstartLocation(int paramInt)
      {
        return ((Integer)this.k.get(paramInt)).intValue();
      }
      
      public int getSstartLocationCount()
      {
        return this.k.size();
      }
      
      public List<Integer> getSstartLocationList()
      {
        return this.k;
      }
      
      public String getStartLocation()
      {
        return this.h;
      }
      
      public Steps getSteps(int paramInt)
      {
        return (Steps)this.i.get(paramInt);
      }
      
      public int getStepsCount()
      {
        return this.i.size();
      }
      
      public List<Steps> getStepsList()
      {
        return this.i;
      }
      
      public boolean hasDistance()
      {
        return this.a;
      }
      
      public boolean hasDuration()
      {
        return this.c;
      }
      
      public boolean hasEndLocation()
      {
        return this.e;
      }
      
      public boolean hasStartLocation()
      {
        return this.g;
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
          int m = paramCodedInputStreamMicro.readTag();
          switch (m)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
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
            Steps localSteps = new Steps();
            paramCodedInputStreamMicro.readMessage(localSteps);
            addSteps(localSteps);
            break;
          case 48: 
            addSendLocation(paramCodedInputStreamMicro.readSInt32());
            break;
          case 56: 
            addSstartLocation(paramCodedInputStreamMicro.readSInt32());
          }
        }
      }
      
      public Legs setDistance(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public Legs setDuration(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public Legs setEndLocation(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Legs setSendLocation(int paramInt1, int paramInt2)
      {
        this.j.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Legs setSstartLocation(int paramInt1, int paramInt2)
      {
        this.k.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Legs setStartLocation(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Legs setSteps(int paramInt, Steps paramSteps)
      {
        if (paramSteps == null) {
          return this;
        }
        this.i.set(paramInt, paramSteps);
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
        Iterator localIterator = getStepsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(5, (Steps)localIterator.next());
        }
        localIterator = getSendLocationList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(6, ((Integer)localIterator.next()).intValue());
        }
        localIterator = getSstartLocationList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(7, ((Integer)localIterator.next()).intValue());
        }
      }
      
      public static final class Steps
        extends MessageMicro
      {
        public static final int DIRECTION_FIELD_NUMBER = 7;
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int END_INSTRUCTIONS_FIELD_NUMBER = 8;
        public static final int END_LOCATION_FIELD_NUMBER = 3;
        public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
        public static final int LEVEL_FIELD_NUMBER = 15;
        public static final int PATH_FIELD_NUMBER = 6;
        public static final int SEND_LOCATION_FIELD_NUMBER = 11;
        public static final int SPATH_FIELD_NUMBER = 13;
        public static final int SSTART_LOCATION_FIELD_NUMBER = 12;
        public static final int START_INSTRUCTIONS_FIELD_NUMBER = 9;
        public static final int START_LOCATION_FIELD_NUMBER = 4;
        public static final int STEPRCS_FIELD_NUMBER = 16;
        public static final int TURN_FIELD_NUMBER = 10;
        public static final int USROADNAME_FIELD_NUMBER = 14;
        private int A = 0;
        private List<Steprcs> B = Collections.emptyList();
        private int C = -1;
        private boolean a;
        private int b = 0;
        private boolean c;
        private int d = 0;
        private boolean e;
        private String f = "";
        private boolean g;
        private String h = "";
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
        private List<Integer> u = Collections.emptyList();
        private List<Integer> v = Collections.emptyList();
        private List<Integer> w = Collections.emptyList();
        private boolean x;
        private String y = "";
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
        
        public Steps addSendLocation(int paramInt)
        {
          if (this.u.isEmpty()) {
            this.u = new ArrayList();
          }
          this.u.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public Steps addSpath(int paramInt)
        {
          if (this.w.isEmpty()) {
            this.w = new ArrayList();
          }
          this.w.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public Steps addSstartLocation(int paramInt)
        {
          if (this.v.isEmpty()) {
            this.v = new ArrayList();
          }
          this.v.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public Steps addSteprcs(Steprcs paramSteprcs)
        {
          if (paramSteprcs == null) {
            return this;
          }
          if (this.B.isEmpty()) {
            this.B = new ArrayList();
          }
          this.B.add(paramSteprcs);
          return this;
        }
        
        public final Steps clear()
        {
          clearDistance();
          clearDuration();
          clearEndLocation();
          clearStartLocation();
          clearInstructions();
          clearPath();
          clearDirection();
          clearEndInstructions();
          clearStartInstructions();
          clearTurn();
          clearSendLocation();
          clearSstartLocation();
          clearSpath();
          clearUsroadname();
          clearLevel();
          clearSteprcs();
          this.C = -1;
          return this;
        }
        
        public Steps clearDirection()
        {
          this.m = false;
          this.n = 0;
          return this;
        }
        
        public Steps clearDistance()
        {
          this.a = false;
          this.b = 0;
          return this;
        }
        
        public Steps clearDuration()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public Steps clearEndInstructions()
        {
          this.o = false;
          this.p = "";
          return this;
        }
        
        public Steps clearEndLocation()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public Steps clearInstructions()
        {
          this.i = false;
          this.j = "";
          return this;
        }
        
        public Steps clearLevel()
        {
          this.z = false;
          this.A = 0;
          return this;
        }
        
        public Steps clearPath()
        {
          this.k = false;
          this.l = "";
          return this;
        }
        
        public Steps clearSendLocation()
        {
          this.u = Collections.emptyList();
          return this;
        }
        
        public Steps clearSpath()
        {
          this.w = Collections.emptyList();
          return this;
        }
        
        public Steps clearSstartLocation()
        {
          this.v = Collections.emptyList();
          return this;
        }
        
        public Steps clearStartInstructions()
        {
          this.q = false;
          this.r = "";
          return this;
        }
        
        public Steps clearStartLocation()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public Steps clearSteprcs()
        {
          this.B = Collections.emptyList();
          return this;
        }
        
        public Steps clearTurn()
        {
          this.s = false;
          this.t = 0;
          return this;
        }
        
        public Steps clearUsroadname()
        {
          this.x = false;
          this.y = "";
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.C < 0) {
            getSerializedSize();
          }
          return this.C;
        }
        
        public int getDirection()
        {
          return this.n;
        }
        
        public int getDistance()
        {
          return this.b;
        }
        
        public int getDuration()
        {
          return this.d;
        }
        
        public String getEndInstructions()
        {
          return this.p;
        }
        
        public String getEndLocation()
        {
          return this.f;
        }
        
        public String getInstructions()
        {
          return this.j;
        }
        
        public int getLevel()
        {
          return this.A;
        }
        
        public String getPath()
        {
          return this.l;
        }
        
        public int getSendLocation(int paramInt)
        {
          return ((Integer)this.u.get(paramInt)).intValue();
        }
        
        public int getSendLocationCount()
        {
          return this.u.size();
        }
        
        public List<Integer> getSendLocationList()
        {
          return this.u;
        }
        
        public int getSerializedSize()
        {
          int i4 = 0;
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
            if (hasDirection()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getDirection());
            }
            i1 = i2;
            if (hasEndInstructions()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getEndInstructions());
            }
            i2 = i1;
            if (hasStartInstructions()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getStartInstructions());
            }
            if (hasTurn()) {}
            for (i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getTurn());; i1 = i2)
            {
              Iterator localIterator = getSendLocationList().iterator();
              for (i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i2) {}
              int i5 = getSendLocationList().size();
              localIterator = getSstartLocationList().iterator();
              for (int i3 = 0; localIterator.hasNext(); i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i3) {}
              int i6 = getSstartLocationList().size();
              localIterator = getSpathList().iterator();
              while (localIterator.hasNext()) {
                i4 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
              }
              i2 = i6 * 1 + (i1 + i2 + i5 * 1 + i3) + i4 + getSpathList().size() * 1;
              i1 = i2;
              if (hasUsroadname()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getUsroadname());
              }
              i2 = i1;
              if (hasLevel()) {
                i2 = i1 + CodedOutputStreamMicro.computeInt32Size(15, getLevel());
              }
              localIterator = getSteprcsList().iterator();
              while (localIterator.hasNext()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(16, (Steprcs)localIterator.next()) + i2;
              }
              this.C = i2;
              return i2;
            }
          }
        }
        
        public int getSpath(int paramInt)
        {
          return ((Integer)this.w.get(paramInt)).intValue();
        }
        
        public int getSpathCount()
        {
          return this.w.size();
        }
        
        public List<Integer> getSpathList()
        {
          return this.w;
        }
        
        public int getSstartLocation(int paramInt)
        {
          return ((Integer)this.v.get(paramInt)).intValue();
        }
        
        public int getSstartLocationCount()
        {
          return this.v.size();
        }
        
        public List<Integer> getSstartLocationList()
        {
          return this.v;
        }
        
        public String getStartInstructions()
        {
          return this.r;
        }
        
        public String getStartLocation()
        {
          return this.h;
        }
        
        public Steprcs getSteprcs(int paramInt)
        {
          return (Steprcs)this.B.get(paramInt);
        }
        
        public int getSteprcsCount()
        {
          return this.B.size();
        }
        
        public List<Steprcs> getSteprcsList()
        {
          return this.B;
        }
        
        public int getTurn()
        {
          return this.t;
        }
        
        public String getUsroadname()
        {
          return this.y;
        }
        
        public boolean hasDirection()
        {
          return this.m;
        }
        
        public boolean hasDistance()
        {
          return this.a;
        }
        
        public boolean hasDuration()
        {
          return this.c;
        }
        
        public boolean hasEndInstructions()
        {
          return this.o;
        }
        
        public boolean hasEndLocation()
        {
          return this.e;
        }
        
        public boolean hasInstructions()
        {
          return this.i;
        }
        
        public boolean hasLevel()
        {
          return this.z;
        }
        
        public boolean hasPath()
        {
          return this.k;
        }
        
        public boolean hasStartInstructions()
        {
          return this.q;
        }
        
        public boolean hasStartLocation()
        {
          return this.g;
        }
        
        public boolean hasTurn()
        {
          return this.s;
        }
        
        public boolean hasUsroadname()
        {
          return this.x;
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
              setDirection(paramCodedInputStreamMicro.readInt32());
              break;
            case 66: 
              setEndInstructions(paramCodedInputStreamMicro.readString());
              break;
            case 74: 
              setStartInstructions(paramCodedInputStreamMicro.readString());
              break;
            case 80: 
              setTurn(paramCodedInputStreamMicro.readInt32());
              break;
            case 88: 
              addSendLocation(paramCodedInputStreamMicro.readSInt32());
              break;
            case 96: 
              addSstartLocation(paramCodedInputStreamMicro.readSInt32());
              break;
            case 104: 
              addSpath(paramCodedInputStreamMicro.readSInt32());
              break;
            case 114: 
              setUsroadname(paramCodedInputStreamMicro.readString());
              break;
            case 120: 
              setLevel(paramCodedInputStreamMicro.readInt32());
              break;
            case 130: 
              Steprcs localSteprcs = new Steprcs();
              paramCodedInputStreamMicro.readMessage(localSteprcs);
              addSteprcs(localSteprcs);
            }
          }
        }
        
        public Steps setDirection(int paramInt)
        {
          this.m = true;
          this.n = paramInt;
          return this;
        }
        
        public Steps setDistance(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public Steps setDuration(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public Steps setEndInstructions(String paramString)
        {
          this.o = true;
          this.p = paramString;
          return this;
        }
        
        public Steps setEndLocation(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public Steps setInstructions(String paramString)
        {
          this.i = true;
          this.j = paramString;
          return this;
        }
        
        public Steps setLevel(int paramInt)
        {
          this.z = true;
          this.A = paramInt;
          return this;
        }
        
        public Steps setPath(String paramString)
        {
          this.k = true;
          this.l = paramString;
          return this;
        }
        
        public Steps setSendLocation(int paramInt1, int paramInt2)
        {
          this.u.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public Steps setSpath(int paramInt1, int paramInt2)
        {
          this.w.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public Steps setSstartLocation(int paramInt1, int paramInt2)
        {
          this.v.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public Steps setStartInstructions(String paramString)
        {
          this.q = true;
          this.r = paramString;
          return this;
        }
        
        public Steps setStartLocation(String paramString)
        {
          this.g = true;
          this.h = paramString;
          return this;
        }
        
        public Steps setSteprcs(int paramInt, Steprcs paramSteprcs)
        {
          if (paramSteprcs == null) {
            return this;
          }
          this.B.set(paramInt, paramSteprcs);
          return this;
        }
        
        public Steps setTurn(int paramInt)
        {
          this.s = true;
          this.t = paramInt;
          return this;
        }
        
        public Steps setUsroadname(String paramString)
        {
          this.x = true;
          this.y = paramString;
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
          if (hasDirection()) {
            paramCodedOutputStreamMicro.writeInt32(7, getDirection());
          }
          if (hasEndInstructions()) {
            paramCodedOutputStreamMicro.writeString(8, getEndInstructions());
          }
          if (hasStartInstructions()) {
            paramCodedOutputStreamMicro.writeString(9, getStartInstructions());
          }
          if (hasTurn()) {
            paramCodedOutputStreamMicro.writeInt32(10, getTurn());
          }
          Iterator localIterator = getSendLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(11, ((Integer)localIterator.next()).intValue());
          }
          localIterator = getSstartLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(12, ((Integer)localIterator.next()).intValue());
          }
          localIterator = getSpathList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(13, ((Integer)localIterator.next()).intValue());
          }
          if (hasUsroadname()) {
            paramCodedOutputStreamMicro.writeString(14, getUsroadname());
          }
          if (hasLevel()) {
            paramCodedOutputStreamMicro.writeInt32(15, getLevel());
          }
          localIterator = getSteprcsList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(16, (Steprcs)localIterator.next());
          }
        }
        
        public static final class Steprcs
          extends MessageMicro
        {
          public static final int END_FIELD_NUMBER = 1;
          public static final int STATUS_FIELD_NUMBER = 2;
          private boolean a;
          private int b = 0;
          private boolean c;
          private int d = 0;
          private int e = -1;
          
          public static Steprcs parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Steprcs().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Steprcs parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Steprcs)new Steprcs().mergeFrom(paramArrayOfByte);
          }
          
          public final Steprcs clear()
          {
            clearEnd();
            clearStatus();
            this.e = -1;
            return this;
          }
          
          public Steprcs clearEnd()
          {
            this.a = false;
            this.b = 0;
            return this;
          }
          
          public Steprcs clearStatus()
          {
            this.c = false;
            this.d = 0;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.e < 0) {
              getSerializedSize();
            }
            return this.e;
          }
          
          public int getEnd()
          {
            return this.b;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasEnd()) {
              i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getEnd());
            }
            int j = i;
            if (hasStatus()) {
              j = i + CodedOutputStreamMicro.computeInt32Size(2, getStatus());
            }
            this.e = j;
            return j;
          }
          
          public int getStatus()
          {
            return this.d;
          }
          
          public boolean hasEnd()
          {
            return this.a;
          }
          
          public boolean hasStatus()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Steprcs mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setEnd(paramCodedInputStreamMicro.readInt32());
                break;
              case 16: 
                setStatus(paramCodedInputStreamMicro.readInt32());
              }
            }
          }
          
          public Steprcs setEnd(int paramInt)
          {
            this.a = true;
            this.b = paramInt;
            return this;
          }
          
          public Steprcs setStatus(int paramInt)
          {
            this.c = true;
            this.d = paramInt;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasEnd()) {
              paramCodedOutputStreamMicro.writeInt32(1, getEnd());
            }
            if (hasStatus()) {
              paramCodedOutputStreamMicro.writeInt32(2, getStatus());
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
  
  public static final class Traffic
    extends MessageMicro
  {
    public static final int ROUTES_FIELD_NUMBER = 1;
    private List<Routes> a = Collections.emptyList();
    private int b = -1;
    
    public static Traffic parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Traffic().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Traffic parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Traffic)new Traffic().mergeFrom(paramArrayOfByte);
    }
    
    public Traffic addRoutes(Routes paramRoutes)
    {
      if (paramRoutes == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramRoutes);
      return this;
    }
    
    public final Traffic clear()
    {
      clearRoutes();
      this.b = -1;
      return this;
    }
    
    public Traffic clearRoutes()
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
    
    public Routes getRoutes(int paramInt)
    {
      return (Routes)this.a.get(paramInt);
    }
    
    public int getRoutesCount()
    {
      return this.a.size();
    }
    
    public List<Routes> getRoutesList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getRoutesList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Routes)localIterator.next()) + i) {}
      this.b = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Traffic mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          Routes localRoutes = new Routes();
          paramCodedInputStreamMicro.readMessage(localRoutes);
          addRoutes(localRoutes);
        }
      }
    }
    
    public Traffic setRoutes(int paramInt, Routes paramRoutes)
    {
      if (paramRoutes == null) {
        return this;
      }
      this.a.set(paramInt, paramRoutes);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getRoutesList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Routes)localIterator.next());
      }
    }
    
    public static final class Routes
      extends MessageMicro
    {
      public static final int DIGES_FIELD_NUMBER = 1;
      public static final int LEGS_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private List<Legs> c = Collections.emptyList();
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
        if (this.c.isEmpty()) {
          this.c = new ArrayList();
        }
        this.c.add(paramLegs);
        return this;
      }
      
      public final Routes clear()
      {
        clearDiges();
        clearLegs();
        this.d = -1;
        return this;
      }
      
      public Routes clearDiges()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Routes clearLegs()
      {
        this.c = Collections.emptyList();
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.d < 0) {
          getSerializedSize();
        }
        return this.d;
      }
      
      public String getDiges()
      {
        return this.b;
      }
      
      public Legs getLegs(int paramInt)
      {
        return (Legs)this.c.get(paramInt);
      }
      
      public int getLegsCount()
      {
        return this.c.size();
      }
      
      public List<Legs> getLegsList()
      {
        return this.c;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasDiges()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDiges());
        }
        Iterator localIterator = getLegsList().iterator();
        while (localIterator.hasNext()) {
          i = CodedOutputStreamMicro.computeMessageSize(2, (Legs)localIterator.next()) + i;
        }
        this.d = i;
        return i;
      }
      
      public boolean hasDiges()
      {
        return this.a;
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
            setDiges(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            Legs localLegs = new Legs();
            paramCodedInputStreamMicro.readMessage(localLegs);
            addLegs(localLegs);
          }
        }
      }
      
      public Routes setDiges(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Routes setLegs(int paramInt, Legs paramLegs)
      {
        if (paramLegs == null) {
          return this;
        }
        this.c.set(paramInt, paramLegs);
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDiges()) {
          paramCodedOutputStreamMicro.writeString(1, getDiges());
        }
        Iterator localIterator = getLegsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(2, (Legs)localIterator.next());
        }
      }
      
      public static final class Legs
        extends MessageMicro
      {
        public static final int STEPS_FIELD_NUMBER = 1;
        private List<Steps> a = Collections.emptyList();
        private int b = -1;
        
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
          this.b = -1;
          return this;
        }
        
        public Legs clearSteps()
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
          Iterator localIterator = getStepsList().iterator();
          for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Steps)localIterator.next()) + i) {}
          this.b = i;
          return i;
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
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Legs mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              Steps localSteps = new Steps();
              paramCodedInputStreamMicro.readMessage(localSteps);
              addSteps(localSteps);
            }
          }
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
          Iterator localIterator = getStepsList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(1, (Steps)localIterator.next());
          }
        }
        
        public static final class Steps
          extends MessageMicro
        {
          public static final int END_FIELD_NUMBER = 1;
          public static final int STATUS_FIELD_NUMBER = 2;
          private List<Integer> a = Collections.emptyList();
          private List<Integer> b = Collections.emptyList();
          private int c = -1;
          
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
          
          public Steps addEnd(int paramInt)
          {
            if (this.a.isEmpty()) {
              this.a = new ArrayList();
            }
            this.a.add(Integer.valueOf(paramInt));
            return this;
          }
          
          public Steps addStatus(int paramInt)
          {
            if (this.b.isEmpty()) {
              this.b = new ArrayList();
            }
            this.b.add(Integer.valueOf(paramInt));
            return this;
          }
          
          public final Steps clear()
          {
            clearEnd();
            clearStatus();
            this.c = -1;
            return this;
          }
          
          public Steps clearEnd()
          {
            this.a = Collections.emptyList();
            return this;
          }
          
          public Steps clearStatus()
          {
            this.b = Collections.emptyList();
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.c < 0) {
              getSerializedSize();
            }
            return this.c;
          }
          
          public int getEnd(int paramInt)
          {
            return ((Integer)this.a.get(paramInt)).intValue();
          }
          
          public int getEndCount()
          {
            return this.a.size();
          }
          
          public List<Integer> getEndList()
          {
            return this.a;
          }
          
          public int getSerializedSize()
          {
            int j = 0;
            Iterator localIterator = getEndList().iterator();
            for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
            int k = getEndList().size();
            localIterator = getStatusList().iterator();
            while (localIterator.hasNext()) {
              j += CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            i = k * 1 + (0 + i) + j + getStatusList().size() * 1;
            this.c = i;
            return i;
          }
          
          public int getStatus(int paramInt)
          {
            return ((Integer)this.b.get(paramInt)).intValue();
          }
          
          public int getStatusCount()
          {
            return this.b.size();
          }
          
          public List<Integer> getStatusList()
          {
            return this.b;
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
              case 8: 
                addEnd(paramCodedInputStreamMicro.readInt32());
                break;
              case 16: 
                addStatus(paramCodedInputStreamMicro.readInt32());
              }
            }
          }
          
          public Steps setEnd(int paramInt1, int paramInt2)
          {
            this.a.set(paramInt1, Integer.valueOf(paramInt2));
            return this;
          }
          
          public Steps setStatus(int paramInt1, int paramInt2)
          {
            this.b.set(paramInt1, Integer.valueOf(paramInt2));
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            Iterator localIterator = getEndList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeInt32(1, ((Integer)localIterator.next()).intValue());
            }
            localIterator = getStatusList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeInt32(2, ((Integer)localIterator.next()).intValue());
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Car.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */