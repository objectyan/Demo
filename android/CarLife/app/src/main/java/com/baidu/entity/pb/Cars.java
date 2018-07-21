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

public final class Cars
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  public static final int TEST_FIELD_NUMBER = 3;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Content d = null;
  private boolean e;
  private String f = "";
  private int g = -1;
  
  public static Cars parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Cars().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Cars parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Cars)new Cars().mergeFrom(paramArrayOfByte);
  }
  
  public final Cars clear()
  {
    clearOption();
    clearContent();
    clearTest();
    this.g = -1;
    return this;
  }
  
  public Cars clearContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Cars clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public Cars clearTest()
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
  
  public Content getContent()
  {
    return this.d;
  }
  
  public Option getOption()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    if (hasOption()) {
      j = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    int i = j;
    if (hasContent()) {
      i = j + CodedOutputStreamMicro.computeMessageSize(2, getContent());
    }
    j = i;
    if (hasTest()) {
      j = i + CodedOutputStreamMicro.computeStringSize(3, getTest());
    }
    this.g = j;
    return j;
  }
  
  public String getTest()
  {
    return this.f;
  }
  
  public boolean hasContent()
  {
    return this.c;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public boolean hasTest()
  {
    return this.e;
  }
  
  public final boolean isInitialized()
  {
    return (!hasContent()) || (getContent().isInitialized());
  }
  
  public Cars mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Content();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setContent((Content)localObject);
        break;
      case 26: 
        setTest(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public Cars setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.c = true;
    this.d = paramContent;
    return this;
  }
  
  public Cars setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.a = true;
    this.b = paramOption;
    return this;
  }
  
  public Cars setTest(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(1, getOption());
    }
    if (hasContent()) {
      paramCodedOutputStreamMicro.writeMessage(2, getContent());
    }
    if (hasTest()) {
      paramCodedOutputStreamMicro.writeString(3, getTest());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int ACCI_INFOS_FIELD_NUMBER = 6;
    public static final int LOCAL_INFO_TIPS_FIELD_NUMBER = 8;
    public static final int LONG_DISTANCE_INFO_FIELD_NUMBER = 11;
    public static final int ROUTEALL = 1;
    public static final int ROUTEPART = 2;
    public static final int ROUTESTATUS_FIELD_NUMBER = 7;
    public static final int ROUTES_FIELD_NUMBER = 1;
    public static final int SESSIONID_FIELD_NUMBER = 9;
    public static final int STEPS_FIELD_NUMBER = 2;
    public static final int STEPTS_FIELD_NUMBER = 3;
    public static final int TAXIS_FIELD_NUMBER = 4;
    public static final int TRAFFICS_FIELD_NUMBER = 5;
    public static final int WALKINF_FIELD_NUMBER = 10;
    public static final int YELLOW_TIPS_LIST_FIELD_NUMBER = 12;
    private List<Routes> a = Collections.emptyList();
    private List<Steps> b = Collections.emptyList();
    private List<Stepts> c = Collections.emptyList();
    private List<Taxis> d = Collections.emptyList();
    private List<Traffics> e = Collections.emptyList();
    private List<AcciInfos> f = Collections.emptyList();
    private boolean g;
    private int h = 1;
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private boolean m;
    private WalkInfoT n = null;
    private List<LongDistanceInfo> o = Collections.emptyList();
    private List<YellowTipsList> p = Collections.emptyList();
    private int q = -1;
    
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
    
    public Content addAcciInfos(AcciInfos paramAcciInfos)
    {
      if (paramAcciInfos == null) {
        return this;
      }
      if (this.f.isEmpty()) {
        this.f = new ArrayList();
      }
      this.f.add(paramAcciInfos);
      return this;
    }
    
    public Content addLongDistanceInfo(LongDistanceInfo paramLongDistanceInfo)
    {
      if (paramLongDistanceInfo == null) {
        return this;
      }
      if (this.o.isEmpty()) {
        this.o = new ArrayList();
      }
      this.o.add(paramLongDistanceInfo);
      return this;
    }
    
    public Content addRoutes(Routes paramRoutes)
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
    
    public Content addSteps(Steps paramSteps)
    {
      if (paramSteps == null) {
        return this;
      }
      if (this.b.isEmpty()) {
        this.b = new ArrayList();
      }
      this.b.add(paramSteps);
      return this;
    }
    
    public Content addStepts(Stepts paramStepts)
    {
      if (paramStepts == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramStepts);
      return this;
    }
    
    public Content addTaxis(Taxis paramTaxis)
    {
      if (paramTaxis == null) {
        return this;
      }
      if (this.d.isEmpty()) {
        this.d = new ArrayList();
      }
      this.d.add(paramTaxis);
      return this;
    }
    
    public Content addTraffics(Traffics paramTraffics)
    {
      if (paramTraffics == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramTraffics);
      return this;
    }
    
    public Content addYellowTipsList(YellowTipsList paramYellowTipsList)
    {
      if (paramYellowTipsList == null) {
        return this;
      }
      if (this.p.isEmpty()) {
        this.p = new ArrayList();
      }
      this.p.add(paramYellowTipsList);
      return this;
    }
    
    public final Content clear()
    {
      clearRoutes();
      clearSteps();
      clearStepts();
      clearTaxis();
      clearTraffics();
      clearAcciInfos();
      clearRouteStatus();
      clearLocalInfoTips();
      clearSessionid();
      clearWalkinf();
      clearLongDistanceInfo();
      clearYellowTipsList();
      this.q = -1;
      return this;
    }
    
    public Content clearAcciInfos()
    {
      this.f = Collections.emptyList();
      return this;
    }
    
    public Content clearLocalInfoTips()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Content clearLongDistanceInfo()
    {
      this.o = Collections.emptyList();
      return this;
    }
    
    public Content clearRouteStatus()
    {
      this.g = false;
      this.h = 1;
      return this;
    }
    
    public Content clearRoutes()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Content clearSessionid()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Content clearSteps()
    {
      this.b = Collections.emptyList();
      return this;
    }
    
    public Content clearStepts()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public Content clearTaxis()
    {
      this.d = Collections.emptyList();
      return this;
    }
    
    public Content clearTraffics()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public Content clearWalkinf()
    {
      this.m = false;
      this.n = null;
      return this;
    }
    
    public Content clearYellowTipsList()
    {
      this.p = Collections.emptyList();
      return this;
    }
    
    public AcciInfos getAcciInfos(int paramInt)
    {
      return (AcciInfos)this.f.get(paramInt);
    }
    
    public int getAcciInfosCount()
    {
      return this.f.size();
    }
    
    public List<AcciInfos> getAcciInfosList()
    {
      return this.f;
    }
    
    public int getCachedSize()
    {
      if (this.q < 0) {
        getSerializedSize();
      }
      return this.q;
    }
    
    public String getLocalInfoTips()
    {
      return this.j;
    }
    
    public LongDistanceInfo getLongDistanceInfo(int paramInt)
    {
      return (LongDistanceInfo)this.o.get(paramInt);
    }
    
    public int getLongDistanceInfoCount()
    {
      return this.o.size();
    }
    
    public List<LongDistanceInfo> getLongDistanceInfoList()
    {
      return this.o;
    }
    
    public int getRouteStatus()
    {
      return this.h;
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
      for (int i1 = 0; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(1, (Routes)localIterator.next()) + i1) {}
      localIterator = getStepsList().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(2, (Steps)localIterator.next());
      }
      localIterator = getSteptsList().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(3, (Stepts)localIterator.next());
      }
      localIterator = getTaxisList().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(4, (Taxis)localIterator.next());
      }
      localIterator = getTrafficsList().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(5, (Traffics)localIterator.next());
      }
      localIterator = getAcciInfosList().iterator();
      int i2 = i1;
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(6, (AcciInfos)localIterator.next());
      }
      i1 = i2;
      if (hasRouteStatus()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(7, getRouteStatus());
      }
      i2 = i1;
      if (hasLocalInfoTips()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(8, getLocalInfoTips());
      }
      i1 = i2;
      if (hasSessionid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(9, getSessionid());
      }
      i2 = i1;
      if (hasWalkinf()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(10, getWalkinf());
      }
      localIterator = getLongDistanceInfoList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(11, (LongDistanceInfo)localIterator.next());
      }
      localIterator = getYellowTipsListList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(12, (YellowTipsList)localIterator.next());
      }
      this.q = i2;
      return i2;
    }
    
    public String getSessionid()
    {
      return this.l;
    }
    
    public Steps getSteps(int paramInt)
    {
      return (Steps)this.b.get(paramInt);
    }
    
    public int getStepsCount()
    {
      return this.b.size();
    }
    
    public List<Steps> getStepsList()
    {
      return this.b;
    }
    
    public Stepts getStepts(int paramInt)
    {
      return (Stepts)this.c.get(paramInt);
    }
    
    public int getSteptsCount()
    {
      return this.c.size();
    }
    
    public List<Stepts> getSteptsList()
    {
      return this.c;
    }
    
    public Taxis getTaxis(int paramInt)
    {
      return (Taxis)this.d.get(paramInt);
    }
    
    public int getTaxisCount()
    {
      return this.d.size();
    }
    
    public List<Taxis> getTaxisList()
    {
      return this.d;
    }
    
    public Traffics getTraffics(int paramInt)
    {
      return (Traffics)this.e.get(paramInt);
    }
    
    public int getTrafficsCount()
    {
      return this.e.size();
    }
    
    public List<Traffics> getTrafficsList()
    {
      return this.e;
    }
    
    public WalkInfoT getWalkinf()
    {
      return this.n;
    }
    
    public YellowTipsList getYellowTipsList(int paramInt)
    {
      return (YellowTipsList)this.p.get(paramInt);
    }
    
    public int getYellowTipsListCount()
    {
      return this.p.size();
    }
    
    public List<YellowTipsList> getYellowTipsListList()
    {
      return this.p;
    }
    
    public boolean hasLocalInfoTips()
    {
      return this.i;
    }
    
    public boolean hasRouteStatus()
    {
      return this.g;
    }
    
    public boolean hasSessionid()
    {
      return this.k;
    }
    
    public boolean hasWalkinf()
    {
      return this.m;
    }
    
    public final boolean isInitialized()
    {
      if ((hasWalkinf()) && (!getWalkinf().isInitialized())) {
        return false;
      }
      Iterator localIterator = getLongDistanceInfoList().iterator();
      while (localIterator.hasNext()) {
        if (!((LongDistanceInfo)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      localIterator = getYellowTipsListList().iterator();
      while (localIterator.hasNext()) {
        if (!((YellowTipsList)localIterator.next()).isInitialized()) {
          return false;
        }
      }
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
          localObject = new Routes();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addRoutes((Routes)localObject);
          break;
        case 18: 
          localObject = new Steps();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addSteps((Steps)localObject);
          break;
        case 26: 
          localObject = new Stepts();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addStepts((Stepts)localObject);
          break;
        case 34: 
          localObject = new Taxis();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTaxis((Taxis)localObject);
          break;
        case 42: 
          localObject = new Traffics();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTraffics((Traffics)localObject);
          break;
        case 50: 
          localObject = new AcciInfos();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addAcciInfos((AcciInfos)localObject);
          break;
        case 56: 
          setRouteStatus(paramCodedInputStreamMicro.readInt32());
          break;
        case 66: 
          setLocalInfoTips(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setSessionid(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          localObject = new WalkInfoT();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setWalkinf((WalkInfoT)localObject);
          break;
        case 90: 
          localObject = new LongDistanceInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addLongDistanceInfo((LongDistanceInfo)localObject);
          break;
        case 98: 
          localObject = new YellowTipsList();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addYellowTipsList((YellowTipsList)localObject);
        }
      }
    }
    
    public Content setAcciInfos(int paramInt, AcciInfos paramAcciInfos)
    {
      if (paramAcciInfos == null) {
        return this;
      }
      this.f.set(paramInt, paramAcciInfos);
      return this;
    }
    
    public Content setLocalInfoTips(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Content setLongDistanceInfo(int paramInt, LongDistanceInfo paramLongDistanceInfo)
    {
      if (paramLongDistanceInfo == null) {
        return this;
      }
      this.o.set(paramInt, paramLongDistanceInfo);
      return this;
    }
    
    public Content setRouteStatus(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Content setRoutes(int paramInt, Routes paramRoutes)
    {
      if (paramRoutes == null) {
        return this;
      }
      this.a.set(paramInt, paramRoutes);
      return this;
    }
    
    public Content setSessionid(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Content setSteps(int paramInt, Steps paramSteps)
    {
      if (paramSteps == null) {
        return this;
      }
      this.b.set(paramInt, paramSteps);
      return this;
    }
    
    public Content setStepts(int paramInt, Stepts paramStepts)
    {
      if (paramStepts == null) {
        return this;
      }
      this.c.set(paramInt, paramStepts);
      return this;
    }
    
    public Content setTaxis(int paramInt, Taxis paramTaxis)
    {
      if (paramTaxis == null) {
        return this;
      }
      this.d.set(paramInt, paramTaxis);
      return this;
    }
    
    public Content setTraffics(int paramInt, Traffics paramTraffics)
    {
      if (paramTraffics == null) {
        return this;
      }
      this.e.set(paramInt, paramTraffics);
      return this;
    }
    
    public Content setWalkinf(WalkInfoT paramWalkInfoT)
    {
      if (paramWalkInfoT == null) {
        return clearWalkinf();
      }
      this.m = true;
      this.n = paramWalkInfoT;
      return this;
    }
    
    public Content setYellowTipsList(int paramInt, YellowTipsList paramYellowTipsList)
    {
      if (paramYellowTipsList == null) {
        return this;
      }
      this.p.set(paramInt, paramYellowTipsList);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getRoutesList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Routes)localIterator.next());
      }
      localIterator = getStepsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Steps)localIterator.next());
      }
      localIterator = getSteptsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (Stepts)localIterator.next());
      }
      localIterator = getTaxisList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(4, (Taxis)localIterator.next());
      }
      localIterator = getTrafficsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(5, (Traffics)localIterator.next());
      }
      localIterator = getAcciInfosList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(6, (AcciInfos)localIterator.next());
      }
      if (hasRouteStatus()) {
        paramCodedOutputStreamMicro.writeInt32(7, getRouteStatus());
      }
      if (hasLocalInfoTips()) {
        paramCodedOutputStreamMicro.writeString(8, getLocalInfoTips());
      }
      if (hasSessionid()) {
        paramCodedOutputStreamMicro.writeString(9, getSessionid());
      }
      if (hasWalkinf()) {
        paramCodedOutputStreamMicro.writeMessage(10, getWalkinf());
      }
      localIterator = getLongDistanceInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(11, (LongDistanceInfo)localIterator.next());
      }
      localIterator = getYellowTipsListList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(12, (YellowTipsList)localIterator.next());
      }
    }
    
    public static final class AcciInfos
      extends MessageMicro
    {
      public static final int PATH_FIELD_NUMBER = 2;
      public static final int TIPS_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static AcciInfos parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new AcciInfos().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static AcciInfos parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (AcciInfos)new AcciInfos().mergeFrom(paramArrayOfByte);
      }
      
      public final AcciInfos clear()
      {
        clearTips();
        clearPath();
        this.e = -1;
        return this;
      }
      
      public AcciInfos clearPath()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public AcciInfos clearTips()
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
      
      public String getPath()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasTips()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTips());
        }
        int j = i;
        if (hasPath()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getPath());
        }
        this.e = j;
        return j;
      }
      
      public String getTips()
      {
        return this.b;
      }
      
      public boolean hasPath()
      {
        return this.c;
      }
      
      public boolean hasTips()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public AcciInfos mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setTips(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setPath(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public AcciInfos setPath(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public AcciInfos setTips(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasTips()) {
          paramCodedOutputStreamMicro.writeString(1, getTips());
        }
        if (hasPath()) {
          paramCodedOutputStreamMicro.writeString(2, getPath());
        }
      }
    }
    
    public static final class LongDistanceInfo
      extends MessageMicro
    {
      public static final int VIA_CITY_INFO_FIELD_NUMBER = 1;
      public static final int VIA_MAIN_ROAD_FIELD_NUMBER = 2;
      public static final int VIA_SERVICE_FIELD_NUMBER = 3;
      private List<ViaCityInfo> a = Collections.emptyList();
      private List<ViaMainRoad> b = Collections.emptyList();
      private List<ViaService> c = Collections.emptyList();
      private int d = -1;
      
      public static LongDistanceInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new LongDistanceInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static LongDistanceInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (LongDistanceInfo)new LongDistanceInfo().mergeFrom(paramArrayOfByte);
      }
      
      public LongDistanceInfo addViaCityInfo(ViaCityInfo paramViaCityInfo)
      {
        if (paramViaCityInfo == null) {
          return this;
        }
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(paramViaCityInfo);
        return this;
      }
      
      public LongDistanceInfo addViaMainRoad(ViaMainRoad paramViaMainRoad)
      {
        if (paramViaMainRoad == null) {
          return this;
        }
        if (this.b.isEmpty()) {
          this.b = new ArrayList();
        }
        this.b.add(paramViaMainRoad);
        return this;
      }
      
      public LongDistanceInfo addViaService(ViaService paramViaService)
      {
        if (paramViaService == null) {
          return this;
        }
        if (this.c.isEmpty()) {
          this.c = new ArrayList();
        }
        this.c.add(paramViaService);
        return this;
      }
      
      public final LongDistanceInfo clear()
      {
        clearViaCityInfo();
        clearViaMainRoad();
        clearViaService();
        this.d = -1;
        return this;
      }
      
      public LongDistanceInfo clearViaCityInfo()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public LongDistanceInfo clearViaMainRoad()
      {
        this.b = Collections.emptyList();
        return this;
      }
      
      public LongDistanceInfo clearViaService()
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
      
      public int getSerializedSize()
      {
        Iterator localIterator = getViaCityInfoList().iterator();
        for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (ViaCityInfo)localIterator.next()) + i) {}
        localIterator = getViaMainRoadList().iterator();
        while (localIterator.hasNext()) {
          i += CodedOutputStreamMicro.computeMessageSize(2, (ViaMainRoad)localIterator.next());
        }
        localIterator = getViaServiceList().iterator();
        while (localIterator.hasNext()) {
          i += CodedOutputStreamMicro.computeMessageSize(3, (ViaService)localIterator.next());
        }
        this.d = i;
        return i;
      }
      
      public ViaCityInfo getViaCityInfo(int paramInt)
      {
        return (ViaCityInfo)this.a.get(paramInt);
      }
      
      public int getViaCityInfoCount()
      {
        return this.a.size();
      }
      
      public List<ViaCityInfo> getViaCityInfoList()
      {
        return this.a;
      }
      
      public ViaMainRoad getViaMainRoad(int paramInt)
      {
        return (ViaMainRoad)this.b.get(paramInt);
      }
      
      public int getViaMainRoadCount()
      {
        return this.b.size();
      }
      
      public List<ViaMainRoad> getViaMainRoadList()
      {
        return this.b;
      }
      
      public ViaService getViaService(int paramInt)
      {
        return (ViaService)this.c.get(paramInt);
      }
      
      public int getViaServiceCount()
      {
        return this.c.size();
      }
      
      public List<ViaService> getViaServiceList()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        Iterator localIterator = getViaCityInfoList().iterator();
        while (localIterator.hasNext()) {
          if (!((ViaCityInfo)localIterator.next()).isInitialized()) {
            return false;
          }
        }
        localIterator = getViaMainRoadList().iterator();
        while (localIterator.hasNext()) {
          if (!((ViaMainRoad)localIterator.next()).isInitialized()) {
            return false;
          }
        }
        localIterator = getViaServiceList().iterator();
        while (localIterator.hasNext()) {
          if (!((ViaService)localIterator.next()).isInitialized()) {
            return false;
          }
        }
        return true;
      }
      
      public LongDistanceInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            localObject = new ViaCityInfo();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addViaCityInfo((ViaCityInfo)localObject);
            break;
          case 18: 
            localObject = new ViaMainRoad();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addViaMainRoad((ViaMainRoad)localObject);
            break;
          case 26: 
            localObject = new ViaService();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addViaService((ViaService)localObject);
          }
        }
      }
      
      public LongDistanceInfo setViaCityInfo(int paramInt, ViaCityInfo paramViaCityInfo)
      {
        if (paramViaCityInfo == null) {
          return this;
        }
        this.a.set(paramInt, paramViaCityInfo);
        return this;
      }
      
      public LongDistanceInfo setViaMainRoad(int paramInt, ViaMainRoad paramViaMainRoad)
      {
        if (paramViaMainRoad == null) {
          return this;
        }
        this.b.set(paramInt, paramViaMainRoad);
        return this;
      }
      
      public LongDistanceInfo setViaService(int paramInt, ViaService paramViaService)
      {
        if (paramViaService == null) {
          return this;
        }
        this.c.set(paramInt, paramViaService);
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getViaCityInfoList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(1, (ViaCityInfo)localIterator.next());
        }
        localIterator = getViaMainRoadList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(2, (ViaMainRoad)localIterator.next());
        }
        localIterator = getViaServiceList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(3, (ViaService)localIterator.next());
        }
      }
      
      public static final class Point
        extends MessageMicro
      {
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private boolean a;
        private double b = 0.0D;
        private boolean c;
        private double d = 0.0D;
        private int e = -1;
        
        public static Point parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Point().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Point parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Point)new Point().mergeFrom(paramArrayOfByte);
        }
        
        public final Point clear()
        {
          clearX();
          clearY();
          this.e = -1;
          return this;
        }
        
        public Point clearX()
        {
          this.a = false;
          this.b = 0.0D;
          return this;
        }
        
        public Point clearY()
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
          if (!this.a) {}
          while (!this.c) {
            return false;
          }
          return true;
        }
        
        public Point mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        
        public Point setX(double paramDouble)
        {
          this.a = true;
          this.b = paramDouble;
          return this;
        }
        
        public Point setY(double paramDouble)
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
      
      public static final class ViaCityInfo
        extends MessageMicro
      {
        public static final int CITY_DISTANCE_FROM_START_FIELD_NUMBER = 3;
        public static final int CITY_ID_FIELD_NUMBER = 2;
        public static final int CITY_NAME_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 4;
        public static final int POINT_FIELD_NUMBER = 6;
        public static final int PRIORITY_FIELD_NUMBER = 5;
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
        private boolean k;
        private Cars.Content.LongDistanceInfo.Point l = null;
        private int m = -1;
        
        public static ViaCityInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new ViaCityInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static ViaCityInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (ViaCityInfo)new ViaCityInfo().mergeFrom(paramArrayOfByte);
        }
        
        public final ViaCityInfo clear()
        {
          clearCityName();
          clearCityId();
          clearCityDistanceFromStart();
          clearDuration();
          clearPriority();
          clearPoint();
          this.m = -1;
          return this;
        }
        
        public ViaCityInfo clearCityDistanceFromStart()
        {
          this.e = false;
          this.f = 0;
          return this;
        }
        
        public ViaCityInfo clearCityId()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public ViaCityInfo clearCityName()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public ViaCityInfo clearDuration()
        {
          this.g = false;
          this.h = 0;
          return this;
        }
        
        public ViaCityInfo clearPoint()
        {
          this.k = false;
          this.l = null;
          return this;
        }
        
        public ViaCityInfo clearPriority()
        {
          this.i = false;
          this.j = 0;
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.m < 0) {
            getSerializedSize();
          }
          return this.m;
        }
        
        public int getCityDistanceFromStart()
        {
          return this.f;
        }
        
        public int getCityId()
        {
          return this.d;
        }
        
        public String getCityName()
        {
          return this.b;
        }
        
        public int getDuration()
        {
          return this.h;
        }
        
        public Cars.Content.LongDistanceInfo.Point getPoint()
        {
          return this.l;
        }
        
        public int getPriority()
        {
          return this.j;
        }
        
        public int getSerializedSize()
        {
          int i1 = 0;
          if (hasCityName()) {
            i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCityName());
          }
          int n = i1;
          if (hasCityId()) {
            n = i1 + CodedOutputStreamMicro.computeInt32Size(2, getCityId());
          }
          i1 = n;
          if (hasCityDistanceFromStart()) {
            i1 = n + CodedOutputStreamMicro.computeInt32Size(3, getCityDistanceFromStart());
          }
          n = i1;
          if (hasDuration()) {
            n = i1 + CodedOutputStreamMicro.computeInt32Size(4, getDuration());
          }
          i1 = n;
          if (hasPriority()) {
            i1 = n + CodedOutputStreamMicro.computeInt32Size(5, getPriority());
          }
          n = i1;
          if (hasPoint()) {
            n = i1 + CodedOutputStreamMicro.computeMessageSize(6, getPoint());
          }
          this.m = n;
          return n;
        }
        
        public boolean hasCityDistanceFromStart()
        {
          return this.e;
        }
        
        public boolean hasCityId()
        {
          return this.c;
        }
        
        public boolean hasCityName()
        {
          return this.a;
        }
        
        public boolean hasDuration()
        {
          return this.g;
        }
        
        public boolean hasPoint()
        {
          return this.k;
        }
        
        public boolean hasPriority()
        {
          return this.i;
        }
        
        public final boolean isInitialized()
        {
          if (!this.a) {}
          while ((!this.c) || (!this.e) || (!this.g) || (!this.k) || (!getPoint().isInitialized())) {
            return false;
          }
          return true;
        }
        
        public ViaCityInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setCityName(paramCodedInputStreamMicro.readString());
              break;
            case 16: 
              setCityId(paramCodedInputStreamMicro.readInt32());
              break;
            case 24: 
              setCityDistanceFromStart(paramCodedInputStreamMicro.readInt32());
              break;
            case 32: 
              setDuration(paramCodedInputStreamMicro.readInt32());
              break;
            case 40: 
              setPriority(paramCodedInputStreamMicro.readInt32());
              break;
            case 50: 
              Cars.Content.LongDistanceInfo.Point localPoint = new Cars.Content.LongDistanceInfo.Point();
              paramCodedInputStreamMicro.readMessage(localPoint);
              setPoint(localPoint);
            }
          }
        }
        
        public ViaCityInfo setCityDistanceFromStart(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
          return this;
        }
        
        public ViaCityInfo setCityId(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public ViaCityInfo setCityName(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public ViaCityInfo setDuration(int paramInt)
        {
          this.g = true;
          this.h = paramInt;
          return this;
        }
        
        public ViaCityInfo setPoint(Cars.Content.LongDistanceInfo.Point paramPoint)
        {
          if (paramPoint == null) {
            return clearPoint();
          }
          this.k = true;
          this.l = paramPoint;
          return this;
        }
        
        public ViaCityInfo setPriority(int paramInt)
        {
          this.i = true;
          this.j = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasCityName()) {
            paramCodedOutputStreamMicro.writeString(1, getCityName());
          }
          if (hasCityId()) {
            paramCodedOutputStreamMicro.writeInt32(2, getCityId());
          }
          if (hasCityDistanceFromStart()) {
            paramCodedOutputStreamMicro.writeInt32(3, getCityDistanceFromStart());
          }
          if (hasDuration()) {
            paramCodedOutputStreamMicro.writeInt32(4, getDuration());
          }
          if (hasPriority()) {
            paramCodedOutputStreamMicro.writeInt32(5, getPriority());
          }
          if (hasPoint()) {
            paramCodedOutputStreamMicro.writeMessage(6, getPoint());
          }
        }
      }
      
      public static final class ViaMainRoad
        extends MessageMicro
      {
        public static final int DISTANCE_FIELD_NUMBER = 5;
        public static final int END_FIELD_NUMBER = 8;
        public static final int LABEL_POINT_FIELD_NUMBER = 6;
        public static final int LANE_COUNT_FIELD_NUMBER = 3;
        public static final int MAIN_ROAD_NAME_FIELD_NUMBER = 1;
        public static final int MAIN_ROAD_TYPE_FIELD_NUMBER = 2;
        public static final int SPEED_LIMIT_FIELD_NUMBER = 4;
        public static final int START_FIELD_NUMBER = 7;
        private boolean a;
        private String b = "";
        private boolean c;
        private int d = 0;
        private boolean e;
        private String f = "";
        private boolean g;
        private String h = "";
        private boolean i;
        private int j = 0;
        private boolean k;
        private Cars.Content.LongDistanceInfo.Point l = null;
        private boolean m;
        private Cars.Content.LongDistanceInfo.Point n = null;
        private boolean o;
        private Cars.Content.LongDistanceInfo.Point p = null;
        private int q = -1;
        
        public static ViaMainRoad parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new ViaMainRoad().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static ViaMainRoad parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (ViaMainRoad)new ViaMainRoad().mergeFrom(paramArrayOfByte);
        }
        
        public final ViaMainRoad clear()
        {
          clearMainRoadName();
          clearMainRoadType();
          clearLaneCount();
          clearSpeedLimit();
          clearDistance();
          clearLabelPoint();
          clearStart();
          clearEnd();
          this.q = -1;
          return this;
        }
        
        public ViaMainRoad clearDistance()
        {
          this.i = false;
          this.j = 0;
          return this;
        }
        
        public ViaMainRoad clearEnd()
        {
          this.o = false;
          this.p = null;
          return this;
        }
        
        public ViaMainRoad clearLabelPoint()
        {
          this.k = false;
          this.l = null;
          return this;
        }
        
        public ViaMainRoad clearLaneCount()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public ViaMainRoad clearMainRoadName()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public ViaMainRoad clearMainRoadType()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public ViaMainRoad clearSpeedLimit()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public ViaMainRoad clearStart()
        {
          this.m = false;
          this.n = null;
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.q < 0) {
            getSerializedSize();
          }
          return this.q;
        }
        
        public int getDistance()
        {
          return this.j;
        }
        
        public Cars.Content.LongDistanceInfo.Point getEnd()
        {
          return this.p;
        }
        
        public Cars.Content.LongDistanceInfo.Point getLabelPoint()
        {
          return this.l;
        }
        
        public String getLaneCount()
        {
          return this.f;
        }
        
        public String getMainRoadName()
        {
          return this.b;
        }
        
        public int getMainRoadType()
        {
          return this.d;
        }
        
        public int getSerializedSize()
        {
          int i2 = 0;
          if (hasMainRoadName()) {
            i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getMainRoadName());
          }
          int i1 = i2;
          if (hasMainRoadType()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getMainRoadType());
          }
          i2 = i1;
          if (hasLaneCount()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getLaneCount());
          }
          i1 = i2;
          if (hasSpeedLimit()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getSpeedLimit());
          }
          i2 = i1;
          if (hasDistance()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getDistance());
          }
          i1 = i2;
          if (hasLabelPoint()) {
            i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getLabelPoint());
          }
          i2 = i1;
          if (hasStart()) {
            i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getStart());
          }
          i1 = i2;
          if (hasEnd()) {
            i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getEnd());
          }
          this.q = i1;
          return i1;
        }
        
        public String getSpeedLimit()
        {
          return this.h;
        }
        
        public Cars.Content.LongDistanceInfo.Point getStart()
        {
          return this.n;
        }
        
        public boolean hasDistance()
        {
          return this.i;
        }
        
        public boolean hasEnd()
        {
          return this.o;
        }
        
        public boolean hasLabelPoint()
        {
          return this.k;
        }
        
        public boolean hasLaneCount()
        {
          return this.e;
        }
        
        public boolean hasMainRoadName()
        {
          return this.a;
        }
        
        public boolean hasMainRoadType()
        {
          return this.c;
        }
        
        public boolean hasSpeedLimit()
        {
          return this.g;
        }
        
        public boolean hasStart()
        {
          return this.m;
        }
        
        public final boolean isInitialized()
        {
          if (!this.a) {}
          while ((!this.c) || (!this.i) || (!this.k) || (!this.m) || (!this.o) || (!getLabelPoint().isInitialized()) || (!getStart().isInitialized()) || (!getEnd().isInitialized())) {
            return false;
          }
          return true;
        }
        
        public ViaMainRoad mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          for (;;)
          {
            int i1 = paramCodedInputStreamMicro.readTag();
            Cars.Content.LongDistanceInfo.Point localPoint;
            switch (i1)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
              break;
            case 0: 
              return this;
            case 10: 
              setMainRoadName(paramCodedInputStreamMicro.readString());
              break;
            case 16: 
              setMainRoadType(paramCodedInputStreamMicro.readInt32());
              break;
            case 26: 
              setLaneCount(paramCodedInputStreamMicro.readString());
              break;
            case 34: 
              setSpeedLimit(paramCodedInputStreamMicro.readString());
              break;
            case 40: 
              setDistance(paramCodedInputStreamMicro.readInt32());
              break;
            case 50: 
              localPoint = new Cars.Content.LongDistanceInfo.Point();
              paramCodedInputStreamMicro.readMessage(localPoint);
              setLabelPoint(localPoint);
              break;
            case 58: 
              localPoint = new Cars.Content.LongDistanceInfo.Point();
              paramCodedInputStreamMicro.readMessage(localPoint);
              setStart(localPoint);
              break;
            case 66: 
              localPoint = new Cars.Content.LongDistanceInfo.Point();
              paramCodedInputStreamMicro.readMessage(localPoint);
              setEnd(localPoint);
            }
          }
        }
        
        public ViaMainRoad setDistance(int paramInt)
        {
          this.i = true;
          this.j = paramInt;
          return this;
        }
        
        public ViaMainRoad setEnd(Cars.Content.LongDistanceInfo.Point paramPoint)
        {
          if (paramPoint == null) {
            return clearEnd();
          }
          this.o = true;
          this.p = paramPoint;
          return this;
        }
        
        public ViaMainRoad setLabelPoint(Cars.Content.LongDistanceInfo.Point paramPoint)
        {
          if (paramPoint == null) {
            return clearLabelPoint();
          }
          this.k = true;
          this.l = paramPoint;
          return this;
        }
        
        public ViaMainRoad setLaneCount(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public ViaMainRoad setMainRoadName(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public ViaMainRoad setMainRoadType(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public ViaMainRoad setSpeedLimit(String paramString)
        {
          this.g = true;
          this.h = paramString;
          return this;
        }
        
        public ViaMainRoad setStart(Cars.Content.LongDistanceInfo.Point paramPoint)
        {
          if (paramPoint == null) {
            return clearStart();
          }
          this.m = true;
          this.n = paramPoint;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasMainRoadName()) {
            paramCodedOutputStreamMicro.writeString(1, getMainRoadName());
          }
          if (hasMainRoadType()) {
            paramCodedOutputStreamMicro.writeInt32(2, getMainRoadType());
          }
          if (hasLaneCount()) {
            paramCodedOutputStreamMicro.writeString(3, getLaneCount());
          }
          if (hasSpeedLimit()) {
            paramCodedOutputStreamMicro.writeString(4, getSpeedLimit());
          }
          if (hasDistance()) {
            paramCodedOutputStreamMicro.writeInt32(5, getDistance());
          }
          if (hasLabelPoint()) {
            paramCodedOutputStreamMicro.writeMessage(6, getLabelPoint());
          }
          if (hasStart()) {
            paramCodedOutputStreamMicro.writeMessage(7, getStart());
          }
          if (hasEnd()) {
            paramCodedOutputStreamMicro.writeMessage(8, getEnd());
          }
        }
      }
      
      public static final class ViaService
        extends MessageMicro
      {
        public static final int CAN_BE_VIA_NODE_FIELD_NUMBER = 5;
        public static final int DURATION_FIELD_NUMBER = 3;
        public static final int LABEL_POINT_FIELD_NUMBER = 4;
        public static final int SERVICE_DISTANCE_FROM_START_FIELD_NUMBER = 2;
        public static final int SERVICE_NAME_FIELD_NUMBER = 1;
        private boolean a;
        private String b = "";
        private boolean c;
        private int d = 0;
        private boolean e;
        private int f = 0;
        private boolean g;
        private Cars.Content.LongDistanceInfo.Point h = null;
        private boolean i;
        private int j = 0;
        private int k = -1;
        
        public static ViaService parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new ViaService().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static ViaService parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (ViaService)new ViaService().mergeFrom(paramArrayOfByte);
        }
        
        public final ViaService clear()
        {
          clearServiceName();
          clearServiceDistanceFromStart();
          clearDuration();
          clearLabelPoint();
          clearCanBeViaNode();
          this.k = -1;
          return this;
        }
        
        public ViaService clearCanBeViaNode()
        {
          this.i = false;
          this.j = 0;
          return this;
        }
        
        public ViaService clearDuration()
        {
          this.e = false;
          this.f = 0;
          return this;
        }
        
        public ViaService clearLabelPoint()
        {
          this.g = false;
          this.h = null;
          return this;
        }
        
        public ViaService clearServiceDistanceFromStart()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public ViaService clearServiceName()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.k < 0) {
            getSerializedSize();
          }
          return this.k;
        }
        
        public int getCanBeViaNode()
        {
          return this.j;
        }
        
        public int getDuration()
        {
          return this.f;
        }
        
        public Cars.Content.LongDistanceInfo.Point getLabelPoint()
        {
          return this.h;
        }
        
        public int getSerializedSize()
        {
          int n = 0;
          if (hasServiceName()) {
            n = 0 + CodedOutputStreamMicro.computeStringSize(1, getServiceName());
          }
          int m = n;
          if (hasServiceDistanceFromStart()) {
            m = n + CodedOutputStreamMicro.computeInt32Size(2, getServiceDistanceFromStart());
          }
          n = m;
          if (hasDuration()) {
            n = m + CodedOutputStreamMicro.computeInt32Size(3, getDuration());
          }
          m = n;
          if (hasLabelPoint()) {
            m = n + CodedOutputStreamMicro.computeMessageSize(4, getLabelPoint());
          }
          n = m;
          if (hasCanBeViaNode()) {
            n = m + CodedOutputStreamMicro.computeInt32Size(5, getCanBeViaNode());
          }
          this.k = n;
          return n;
        }
        
        public int getServiceDistanceFromStart()
        {
          return this.d;
        }
        
        public String getServiceName()
        {
          return this.b;
        }
        
        public boolean hasCanBeViaNode()
        {
          return this.i;
        }
        
        public boolean hasDuration()
        {
          return this.e;
        }
        
        public boolean hasLabelPoint()
        {
          return this.g;
        }
        
        public boolean hasServiceDistanceFromStart()
        {
          return this.c;
        }
        
        public boolean hasServiceName()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          if (!this.a) {}
          while ((!this.c) || (!this.e) || (!this.g) || (!this.i) || (!getLabelPoint().isInitialized())) {
            return false;
          }
          return true;
        }
        
        public ViaService mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setServiceName(paramCodedInputStreamMicro.readString());
              break;
            case 16: 
              setServiceDistanceFromStart(paramCodedInputStreamMicro.readInt32());
              break;
            case 24: 
              setDuration(paramCodedInputStreamMicro.readInt32());
              break;
            case 34: 
              Cars.Content.LongDistanceInfo.Point localPoint = new Cars.Content.LongDistanceInfo.Point();
              paramCodedInputStreamMicro.readMessage(localPoint);
              setLabelPoint(localPoint);
              break;
            case 40: 
              setCanBeViaNode(paramCodedInputStreamMicro.readInt32());
            }
          }
        }
        
        public ViaService setCanBeViaNode(int paramInt)
        {
          this.i = true;
          this.j = paramInt;
          return this;
        }
        
        public ViaService setDuration(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
          return this;
        }
        
        public ViaService setLabelPoint(Cars.Content.LongDistanceInfo.Point paramPoint)
        {
          if (paramPoint == null) {
            return clearLabelPoint();
          }
          this.g = true;
          this.h = paramPoint;
          return this;
        }
        
        public ViaService setServiceDistanceFromStart(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public ViaService setServiceName(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasServiceName()) {
            paramCodedOutputStreamMicro.writeString(1, getServiceName());
          }
          if (hasServiceDistanceFromStart()) {
            paramCodedOutputStreamMicro.writeInt32(2, getServiceDistanceFromStart());
          }
          if (hasDuration()) {
            paramCodedOutputStreamMicro.writeInt32(3, getDuration());
          }
          if (hasLabelPoint()) {
            paramCodedOutputStreamMicro.writeMessage(4, getLabelPoint());
          }
          if (hasCanBeViaNode()) {
            paramCodedOutputStreamMicro.writeInt32(5, getCanBeViaNode());
          }
        }
      }
    }
    
    public static final class Routes
      extends MessageMicro
    {
      public static final int CARROUTEPLANPREFERAVOIDJAM = 16;
      public static final int CARROUTEPLANPREFERCARNUM = 32;
      public static final int CARROUTEPLANPREFERDEFAULT = 1;
      public static final int CARROUTEPLANPREFERHIGHWAY = 2;
      public static final int CARROUTEPLANPREFERINVALID = 0;
      public static final int CARROUTEPLANPREFERNOHIGHWAY = 4;
      public static final int CARROUTEPLANPREFERNOTOLL = 8;
      public static final int CAR_PREFER_ARRAY_FIELD_NUMBER = 12;
      public static final int CONGESTION_LENGTH_FIELD_NUMBER = 9;
      public static final int DESC_FIELD_NUMBER = 1;
      public static final int LEGS_FIELD_NUMBER = 3;
      public static final int LIGHT_NUM_FIELD_NUMBER = 7;
      public static final int MAIN_ROADS_FIELD_NUMBER = 5;
      public static final int MRSL_FIELD_NUMBER = 2;
      public static final int ROUTE_DESC_FIELD_NUMBER = 16;
      public static final int ROUTE_LABEL_NAME_FIELD_NUMBER = 13;
      public static final int ROUTE_LABEL_TIPS_FIELD_NUMBER = 14;
      public static final int TAB_FIELD_NUMBER = 10;
      public static final int TOLL_FIELD_NUMBER = 6;
      public static final int TRAFFIC_CONDITION_FIELD_NUMBER = 4;
      public static final int UGC_TIPS_FIELD_NUMBER = 15;
      public static final int WAITING_TIME_FIELD_NUMBER = 8;
      public static final int WHOLE_CONDITION_FIELD_NUMBER = 11;
      private String A = "";
      private boolean B;
      private String C = "";
      private boolean D;
      private String E = "";
      private int F = -1;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private List<Legs> e = Collections.emptyList();
      private boolean f;
      private int g = 0;
      private boolean h;
      private String i = "";
      private boolean j;
      private int k = 0;
      private boolean l;
      private int m = 0;
      private boolean n;
      private String o = "";
      private boolean p;
      private int q = 0;
      private boolean r;
      private String s = "";
      private boolean t;
      private WholeCondition u = null;
      private boolean v;
      private CarPreferInfoArray w = null;
      private boolean x;
      private String y = "";
      private boolean z;
      
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
        if (this.e.isEmpty()) {
          this.e = new ArrayList();
        }
        this.e.add(paramLegs);
        return this;
      }
      
      public final Routes clear()
      {
        clearDesc();
        clearMrsl();
        clearLegs();
        clearTrafficCondition();
        clearMainRoads();
        clearToll();
        clearLightNum();
        clearWaitingTime();
        clearCongestionLength();
        clearTab();
        clearWholeCondition();
        clearCarPreferArray();
        clearRouteLabelName();
        clearRouteLabelTips();
        clearUgcTips();
        clearRouteDesc();
        this.F = -1;
        return this;
      }
      
      public Routes clearCarPreferArray()
      {
        this.v = false;
        this.w = null;
        return this;
      }
      
      public Routes clearCongestionLength()
      {
        this.p = false;
        this.q = 0;
        return this;
      }
      
      public Routes clearDesc()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Routes clearLegs()
      {
        this.e = Collections.emptyList();
        return this;
      }
      
      public Routes clearLightNum()
      {
        this.l = false;
        this.m = 0;
        return this;
      }
      
      public Routes clearMainRoads()
      {
        this.h = false;
        this.i = "";
        return this;
      }
      
      public Routes clearMrsl()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Routes clearRouteDesc()
      {
        this.D = false;
        this.E = "";
        return this;
      }
      
      public Routes clearRouteLabelName()
      {
        this.x = false;
        this.y = "";
        return this;
      }
      
      public Routes clearRouteLabelTips()
      {
        this.z = false;
        this.A = "";
        return this;
      }
      
      public Routes clearTab()
      {
        this.r = false;
        this.s = "";
        return this;
      }
      
      public Routes clearToll()
      {
        this.j = false;
        this.k = 0;
        return this;
      }
      
      public Routes clearTrafficCondition()
      {
        this.f = false;
        this.g = 0;
        return this;
      }
      
      public Routes clearUgcTips()
      {
        this.B = false;
        this.C = "";
        return this;
      }
      
      public Routes clearWaitingTime()
      {
        this.n = false;
        this.o = "";
        return this;
      }
      
      public Routes clearWholeCondition()
      {
        this.t = false;
        this.u = null;
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.F < 0) {
          getSerializedSize();
        }
        return this.F;
      }
      
      public CarPreferInfoArray getCarPreferArray()
      {
        return this.w;
      }
      
      public int getCongestionLength()
      {
        return this.q;
      }
      
      public String getDesc()
      {
        return this.b;
      }
      
      public Legs getLegs(int paramInt)
      {
        return (Legs)this.e.get(paramInt);
      }
      
      public int getLegsCount()
      {
        return this.e.size();
      }
      
      public List<Legs> getLegsList()
      {
        return this.e;
      }
      
      public int getLightNum()
      {
        return this.m;
      }
      
      public String getMainRoads()
      {
        return this.i;
      }
      
      public String getMrsl()
      {
        return this.d;
      }
      
      public String getRouteDesc()
      {
        return this.E;
      }
      
      public String getRouteLabelName()
      {
        return this.y;
      }
      
      public String getRouteLabelTips()
      {
        return this.A;
      }
      
      public int getSerializedSize()
      {
        int i1 = 0;
        if (hasDesc()) {
          i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getDesc());
        }
        int i2 = i1;
        if (hasMrsl()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(2, getMrsl());
        }
        Iterator localIterator = getLegsList().iterator();
        while (localIterator.hasNext()) {
          i2 = CodedOutputStreamMicro.computeMessageSize(3, (Legs)localIterator.next()) + i2;
        }
        i1 = i2;
        if (hasTrafficCondition()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getTrafficCondition());
        }
        i2 = i1;
        if (hasMainRoads()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getMainRoads());
        }
        i1 = i2;
        if (hasToll()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getToll());
        }
        i2 = i1;
        if (hasLightNum()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getLightNum());
        }
        i1 = i2;
        if (hasWaitingTime()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getWaitingTime());
        }
        i2 = i1;
        if (hasCongestionLength()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getCongestionLength());
        }
        i1 = i2;
        if (hasTab()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getTab());
        }
        i2 = i1;
        if (hasWholeCondition()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(11, getWholeCondition());
        }
        i1 = i2;
        if (hasCarPreferArray()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(12, getCarPreferArray());
        }
        i2 = i1;
        if (hasRouteLabelName()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getRouteLabelName());
        }
        i1 = i2;
        if (hasRouteLabelTips()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getRouteLabelTips());
        }
        i2 = i1;
        if (hasUgcTips()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getUgcTips());
        }
        i1 = i2;
        if (hasRouteDesc()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getRouteDesc());
        }
        this.F = i1;
        return i1;
      }
      
      public String getTab()
      {
        return this.s;
      }
      
      public int getToll()
      {
        return this.k;
      }
      
      public int getTrafficCondition()
      {
        return this.g;
      }
      
      public String getUgcTips()
      {
        return this.C;
      }
      
      public String getWaitingTime()
      {
        return this.o;
      }
      
      public WholeCondition getWholeCondition()
      {
        return this.u;
      }
      
      public boolean hasCarPreferArray()
      {
        return this.v;
      }
      
      public boolean hasCongestionLength()
      {
        return this.p;
      }
      
      public boolean hasDesc()
      {
        return this.a;
      }
      
      public boolean hasLightNum()
      {
        return this.l;
      }
      
      public boolean hasMainRoads()
      {
        return this.h;
      }
      
      public boolean hasMrsl()
      {
        return this.c;
      }
      
      public boolean hasRouteDesc()
      {
        return this.D;
      }
      
      public boolean hasRouteLabelName()
      {
        return this.x;
      }
      
      public boolean hasRouteLabelTips()
      {
        return this.z;
      }
      
      public boolean hasTab()
      {
        return this.r;
      }
      
      public boolean hasToll()
      {
        return this.j;
      }
      
      public boolean hasTrafficCondition()
      {
        return this.f;
      }
      
      public boolean hasUgcTips()
      {
        return this.B;
      }
      
      public boolean hasWaitingTime()
      {
        return this.n;
      }
      
      public boolean hasWholeCondition()
      {
        return this.t;
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
            setDesc(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setMrsl(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            localObject = new Legs();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addLegs((Legs)localObject);
            break;
          case 32: 
            setTrafficCondition(paramCodedInputStreamMicro.readInt32());
            break;
          case 42: 
            setMainRoads(paramCodedInputStreamMicro.readString());
            break;
          case 48: 
            setToll(paramCodedInputStreamMicro.readInt32());
            break;
          case 56: 
            setLightNum(paramCodedInputStreamMicro.readInt32());
            break;
          case 66: 
            setWaitingTime(paramCodedInputStreamMicro.readString());
            break;
          case 72: 
            setCongestionLength(paramCodedInputStreamMicro.readInt32());
            break;
          case 82: 
            setTab(paramCodedInputStreamMicro.readString());
            break;
          case 90: 
            localObject = new WholeCondition();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setWholeCondition((WholeCondition)localObject);
            break;
          case 98: 
            localObject = new CarPreferInfoArray();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setCarPreferArray((CarPreferInfoArray)localObject);
            break;
          case 106: 
            setRouteLabelName(paramCodedInputStreamMicro.readString());
            break;
          case 114: 
            setRouteLabelTips(paramCodedInputStreamMicro.readString());
            break;
          case 122: 
            setUgcTips(paramCodedInputStreamMicro.readString());
            break;
          case 130: 
            setRouteDesc(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Routes setCarPreferArray(CarPreferInfoArray paramCarPreferInfoArray)
      {
        if (paramCarPreferInfoArray == null) {
          return clearCarPreferArray();
        }
        this.v = true;
        this.w = paramCarPreferInfoArray;
        return this;
      }
      
      public Routes setCongestionLength(int paramInt)
      {
        this.p = true;
        this.q = paramInt;
        return this;
      }
      
      public Routes setDesc(String paramString)
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
        this.e.set(paramInt, paramLegs);
        return this;
      }
      
      public Routes setLightNum(int paramInt)
      {
        this.l = true;
        this.m = paramInt;
        return this;
      }
      
      public Routes setMainRoads(String paramString)
      {
        this.h = true;
        this.i = paramString;
        return this;
      }
      
      public Routes setMrsl(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Routes setRouteDesc(String paramString)
      {
        this.D = true;
        this.E = paramString;
        return this;
      }
      
      public Routes setRouteLabelName(String paramString)
      {
        this.x = true;
        this.y = paramString;
        return this;
      }
      
      public Routes setRouteLabelTips(String paramString)
      {
        this.z = true;
        this.A = paramString;
        return this;
      }
      
      public Routes setTab(String paramString)
      {
        this.r = true;
        this.s = paramString;
        return this;
      }
      
      public Routes setToll(int paramInt)
      {
        this.j = true;
        this.k = paramInt;
        return this;
      }
      
      public Routes setTrafficCondition(int paramInt)
      {
        this.f = true;
        this.g = paramInt;
        return this;
      }
      
      public Routes setUgcTips(String paramString)
      {
        this.B = true;
        this.C = paramString;
        return this;
      }
      
      public Routes setWaitingTime(String paramString)
      {
        this.n = true;
        this.o = paramString;
        return this;
      }
      
      public Routes setWholeCondition(WholeCondition paramWholeCondition)
      {
        if (paramWholeCondition == null) {
          return clearWholeCondition();
        }
        this.t = true;
        this.u = paramWholeCondition;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDesc()) {
          paramCodedOutputStreamMicro.writeString(1, getDesc());
        }
        if (hasMrsl()) {
          paramCodedOutputStreamMicro.writeString(2, getMrsl());
        }
        Iterator localIterator = getLegsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(3, (Legs)localIterator.next());
        }
        if (hasTrafficCondition()) {
          paramCodedOutputStreamMicro.writeInt32(4, getTrafficCondition());
        }
        if (hasMainRoads()) {
          paramCodedOutputStreamMicro.writeString(5, getMainRoads());
        }
        if (hasToll()) {
          paramCodedOutputStreamMicro.writeInt32(6, getToll());
        }
        if (hasLightNum()) {
          paramCodedOutputStreamMicro.writeInt32(7, getLightNum());
        }
        if (hasWaitingTime()) {
          paramCodedOutputStreamMicro.writeString(8, getWaitingTime());
        }
        if (hasCongestionLength()) {
          paramCodedOutputStreamMicro.writeInt32(9, getCongestionLength());
        }
        if (hasTab()) {
          paramCodedOutputStreamMicro.writeString(10, getTab());
        }
        if (hasWholeCondition()) {
          paramCodedOutputStreamMicro.writeMessage(11, getWholeCondition());
        }
        if (hasCarPreferArray()) {
          paramCodedOutputStreamMicro.writeMessage(12, getCarPreferArray());
        }
        if (hasRouteLabelName()) {
          paramCodedOutputStreamMicro.writeString(13, getRouteLabelName());
        }
        if (hasRouteLabelTips()) {
          paramCodedOutputStreamMicro.writeString(14, getRouteLabelTips());
        }
        if (hasUgcTips()) {
          paramCodedOutputStreamMicro.writeString(15, getUgcTips());
        }
        if (hasRouteDesc()) {
          paramCodedOutputStreamMicro.writeString(16, getRouteDesc());
        }
      }
      
      public static final class CarPreferInfo
        extends MessageMicro
      {
        public static final int CAR_PREFER_TAB_FIELD_NUMBER = 2;
        public static final int CAR_PREFER_VAL_FIELD_NUMBER = 1;
        private boolean a;
        private int b = 0;
        private boolean c;
        private ByteStringMicro d = ByteStringMicro.EMPTY;
        private int e = -1;
        
        public static CarPreferInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new CarPreferInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static CarPreferInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (CarPreferInfo)new CarPreferInfo().mergeFrom(paramArrayOfByte);
        }
        
        public final CarPreferInfo clear()
        {
          clearCarPreferVal();
          clearCarPreferTab();
          this.e = -1;
          return this;
        }
        
        public CarPreferInfo clearCarPreferTab()
        {
          this.c = false;
          this.d = ByteStringMicro.EMPTY;
          return this;
        }
        
        public CarPreferInfo clearCarPreferVal()
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
        
        public ByteStringMicro getCarPreferTab()
        {
          return this.d;
        }
        
        public int getCarPreferVal()
        {
          return this.b;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasCarPreferVal()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCarPreferVal());
          }
          int j = i;
          if (hasCarPreferTab()) {
            j = i + CodedOutputStreamMicro.computeBytesSize(2, getCarPreferTab());
          }
          this.e = j;
          return j;
        }
        
        public boolean hasCarPreferTab()
        {
          return this.c;
        }
        
        public boolean hasCarPreferVal()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public CarPreferInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setCarPreferVal(paramCodedInputStreamMicro.readInt32());
              break;
            case 18: 
              setCarPreferTab(paramCodedInputStreamMicro.readBytes());
            }
          }
        }
        
        public CarPreferInfo setCarPreferTab(ByteStringMicro paramByteStringMicro)
        {
          this.c = true;
          this.d = paramByteStringMicro;
          return this;
        }
        
        public CarPreferInfo setCarPreferVal(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasCarPreferVal()) {
            paramCodedOutputStreamMicro.writeInt32(1, getCarPreferVal());
          }
          if (hasCarPreferTab()) {
            paramCodedOutputStreamMicro.writeBytes(2, getCarPreferTab());
          }
        }
      }
      
      public static final class CarPreferInfoArray
        extends MessageMicro
      {
        public static final int CAR_CITY_CODE_FIELD_NUMBER = 2;
        public static final int CAR_INFO_ARRAY_FIELD_NUMBER = 1;
        public static final int LOCAL_ENABLE_TIPS_FIELD_NUMBER = 3;
        private List<Cars.Content.Routes.CarPreferInfo> a = Collections.emptyList();
        private boolean b;
        private int c = -1;
        private boolean d;
        private ByteStringMicro e = ByteStringMicro.EMPTY;
        private int f = -1;
        
        public static CarPreferInfoArray parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new CarPreferInfoArray().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static CarPreferInfoArray parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (CarPreferInfoArray)new CarPreferInfoArray().mergeFrom(paramArrayOfByte);
        }
        
        public CarPreferInfoArray addCarInfoArray(Cars.Content.Routes.CarPreferInfo paramCarPreferInfo)
        {
          if (paramCarPreferInfo == null) {
            return this;
          }
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(paramCarPreferInfo);
          return this;
        }
        
        public final CarPreferInfoArray clear()
        {
          clearCarInfoArray();
          clearCarCityCode();
          clearLocalEnableTips();
          this.f = -1;
          return this;
        }
        
        public CarPreferInfoArray clearCarCityCode()
        {
          this.b = false;
          this.c = -1;
          return this;
        }
        
        public CarPreferInfoArray clearCarInfoArray()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public CarPreferInfoArray clearLocalEnableTips()
        {
          this.d = false;
          this.e = ByteStringMicro.EMPTY;
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.f < 0) {
            getSerializedSize();
          }
          return this.f;
        }
        
        public int getCarCityCode()
        {
          return this.c;
        }
        
        public Cars.Content.Routes.CarPreferInfo getCarInfoArray(int paramInt)
        {
          return (Cars.Content.Routes.CarPreferInfo)this.a.get(paramInt);
        }
        
        public int getCarInfoArrayCount()
        {
          return this.a.size();
        }
        
        public List<Cars.Content.Routes.CarPreferInfo> getCarInfoArrayList()
        {
          return this.a;
        }
        
        public ByteStringMicro getLocalEnableTips()
        {
          return this.e;
        }
        
        public int getSerializedSize()
        {
          Iterator localIterator = getCarInfoArrayList().iterator();
          for (int j = 0; localIterator.hasNext(); j = CodedOutputStreamMicro.computeMessageSize(1, (Cars.Content.Routes.CarPreferInfo)localIterator.next()) + j) {}
          int i = j;
          if (hasCarCityCode()) {
            i = j + CodedOutputStreamMicro.computeInt32Size(2, getCarCityCode());
          }
          j = i;
          if (hasLocalEnableTips()) {
            j = i + CodedOutputStreamMicro.computeBytesSize(3, getLocalEnableTips());
          }
          this.f = j;
          return j;
        }
        
        public boolean hasCarCityCode()
        {
          return this.b;
        }
        
        public boolean hasLocalEnableTips()
        {
          return this.d;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public CarPreferInfoArray mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              Cars.Content.Routes.CarPreferInfo localCarPreferInfo = new Cars.Content.Routes.CarPreferInfo();
              paramCodedInputStreamMicro.readMessage(localCarPreferInfo);
              addCarInfoArray(localCarPreferInfo);
              break;
            case 16: 
              setCarCityCode(paramCodedInputStreamMicro.readInt32());
              break;
            case 26: 
              setLocalEnableTips(paramCodedInputStreamMicro.readBytes());
            }
          }
        }
        
        public CarPreferInfoArray setCarCityCode(int paramInt)
        {
          this.b = true;
          this.c = paramInt;
          return this;
        }
        
        public CarPreferInfoArray setCarInfoArray(int paramInt, Cars.Content.Routes.CarPreferInfo paramCarPreferInfo)
        {
          if (paramCarPreferInfo == null) {
            return this;
          }
          this.a.set(paramInt, paramCarPreferInfo);
          return this;
        }
        
        public CarPreferInfoArray setLocalEnableTips(ByteStringMicro paramByteStringMicro)
        {
          this.d = true;
          this.e = paramByteStringMicro;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getCarInfoArrayList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(1, (Cars.Content.Routes.CarPreferInfo)localIterator.next());
          }
          if (hasCarCityCode()) {
            paramCodedOutputStreamMicro.writeInt32(2, getCarCityCode());
          }
          if (hasLocalEnableTips()) {
            paramCodedOutputStreamMicro.writeBytes(3, getLocalEnableTips());
          }
        }
      }
      
      public static final class Legs
        extends MessageMicro
      {
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int DURATION_INFO_FIELD_NUMBER = 5;
        public static final int DURATION_WHOLEDAY_FIELD_NUMBER = 6;
        public static final int MRSL_FIELD_NUMBER = 4;
        public static final int STEPIS_FIELD_NUMBER = 3;
        private boolean a;
        private int b = 0;
        private boolean c;
        private int d = 0;
        private List<Stepis> e = Collections.emptyList();
        private boolean f;
        private String g = "";
        private boolean h;
        private DurationInfo i = null;
        private boolean j;
        private DurationWholeday k = null;
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
        
        public Legs addStepis(Stepis paramStepis)
        {
          if (paramStepis == null) {
            return this;
          }
          if (this.e.isEmpty()) {
            this.e = new ArrayList();
          }
          this.e.add(paramStepis);
          return this;
        }
        
        public final Legs clear()
        {
          clearDistance();
          clearDuration();
          clearStepis();
          clearMrsl();
          clearDurationInfo();
          clearDurationWholeday();
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
        
        public Legs clearDurationInfo()
        {
          this.h = false;
          this.i = null;
          return this;
        }
        
        public Legs clearDurationWholeday()
        {
          this.j = false;
          this.k = null;
          return this;
        }
        
        public Legs clearMrsl()
        {
          this.f = false;
          this.g = "";
          return this;
        }
        
        public Legs clearStepis()
        {
          this.e = Collections.emptyList();
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
        
        public DurationInfo getDurationInfo()
        {
          return this.i;
        }
        
        public DurationWholeday getDurationWholeday()
        {
          return this.k;
        }
        
        public String getMrsl()
        {
          return this.g;
        }
        
        public int getSerializedSize()
        {
          int m = 0;
          if (hasDistance()) {
            m = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
          }
          int n = m;
          if (hasDuration()) {
            n = m + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
          }
          Iterator localIterator = getStepisList().iterator();
          while (localIterator.hasNext()) {
            n = CodedOutputStreamMicro.computeMessageSize(3, (Stepis)localIterator.next()) + n;
          }
          m = n;
          if (hasMrsl()) {
            m = n + CodedOutputStreamMicro.computeStringSize(4, getMrsl());
          }
          n = m;
          if (hasDurationInfo()) {
            n = m + CodedOutputStreamMicro.computeMessageSize(5, getDurationInfo());
          }
          m = n;
          if (hasDurationWholeday()) {
            m = n + CodedOutputStreamMicro.computeMessageSize(6, getDurationWholeday());
          }
          this.l = m;
          return m;
        }
        
        public Stepis getStepis(int paramInt)
        {
          return (Stepis)this.e.get(paramInt);
        }
        
        public int getStepisCount()
        {
          return this.e.size();
        }
        
        public List<Stepis> getStepisList()
        {
          return this.e;
        }
        
        public boolean hasDistance()
        {
          return this.a;
        }
        
        public boolean hasDuration()
        {
          return this.c;
        }
        
        public boolean hasDurationInfo()
        {
          return this.h;
        }
        
        public boolean hasDurationWholeday()
        {
          return this.j;
        }
        
        public boolean hasMrsl()
        {
          return this.f;
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
            Object localObject;
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
              localObject = new Stepis();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addStepis((Stepis)localObject);
              break;
            case 34: 
              setMrsl(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              localObject = new DurationInfo();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setDurationInfo((DurationInfo)localObject);
              break;
            case 50: 
              localObject = new DurationWholeday();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setDurationWholeday((DurationWholeday)localObject);
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
        
        public Legs setDurationInfo(DurationInfo paramDurationInfo)
        {
          if (paramDurationInfo == null) {
            return clearDurationInfo();
          }
          this.h = true;
          this.i = paramDurationInfo;
          return this;
        }
        
        public Legs setDurationWholeday(DurationWholeday paramDurationWholeday)
        {
          if (paramDurationWholeday == null) {
            return clearDurationWholeday();
          }
          this.j = true;
          this.k = paramDurationWholeday;
          return this;
        }
        
        public Legs setMrsl(String paramString)
        {
          this.f = true;
          this.g = paramString;
          return this;
        }
        
        public Legs setStepis(int paramInt, Stepis paramStepis)
        {
          if (paramStepis == null) {
            return this;
          }
          this.e.set(paramInt, paramStepis);
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
          Iterator localIterator = getStepisList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(3, (Stepis)localIterator.next());
          }
          if (hasMrsl()) {
            paramCodedOutputStreamMicro.writeString(4, getMrsl());
          }
          if (hasDurationInfo()) {
            paramCodedOutputStreamMicro.writeMessage(5, getDurationInfo());
          }
          if (hasDurationWholeday()) {
            paramCodedOutputStreamMicro.writeMessage(6, getDurationWholeday());
          }
        }
        
        public static final class DurationInfo
          extends MessageMicro
        {
          public static final int INFOS_FIELD_NUMBER = 3;
          public static final int INTERVAL_FIELD_NUMBER = 1;
          public static final int TIMESTAMP_FIELD_NUMBER = 2;
          private List<Infos> a = Collections.emptyList();
          private boolean b;
          private int c = 0;
          private boolean d;
          private String e = "";
          private int f = -1;
          
          public static DurationInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new DurationInfo().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static DurationInfo parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (DurationInfo)new DurationInfo().mergeFrom(paramArrayOfByte);
          }
          
          public DurationInfo addInfos(Infos paramInfos)
          {
            if (paramInfos == null) {
              return this;
            }
            if (this.a.isEmpty()) {
              this.a = new ArrayList();
            }
            this.a.add(paramInfos);
            return this;
          }
          
          public final DurationInfo clear()
          {
            clearInfos();
            clearInterval();
            clearTimestamp();
            this.f = -1;
            return this;
          }
          
          public DurationInfo clearInfos()
          {
            this.a = Collections.emptyList();
            return this;
          }
          
          public DurationInfo clearInterval()
          {
            this.b = false;
            this.c = 0;
            return this;
          }
          
          public DurationInfo clearTimestamp()
          {
            this.d = false;
            this.e = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.f < 0) {
              getSerializedSize();
            }
            return this.f;
          }
          
          public Infos getInfos(int paramInt)
          {
            return (Infos)this.a.get(paramInt);
          }
          
          public int getInfosCount()
          {
            return this.a.size();
          }
          
          public List<Infos> getInfosList()
          {
            return this.a;
          }
          
          public int getInterval()
          {
            return this.c;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasInterval()) {
              i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getInterval());
            }
            int j = i;
            if (hasTimestamp()) {
              j = i + CodedOutputStreamMicro.computeStringSize(2, getTimestamp());
            }
            Iterator localIterator = getInfosList().iterator();
            while (localIterator.hasNext()) {
              j = CodedOutputStreamMicro.computeMessageSize(3, (Infos)localIterator.next()) + j;
            }
            this.f = j;
            return j;
          }
          
          public String getTimestamp()
          {
            return this.e;
          }
          
          public boolean hasInterval()
          {
            return this.b;
          }
          
          public boolean hasTimestamp()
          {
            return this.d;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public DurationInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setInterval(paramCodedInputStreamMicro.readInt32());
                break;
              case 18: 
                setTimestamp(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                Infos localInfos = new Infos();
                paramCodedInputStreamMicro.readMessage(localInfos);
                addInfos(localInfos);
              }
            }
          }
          
          public DurationInfo setInfos(int paramInt, Infos paramInfos)
          {
            if (paramInfos == null) {
              return this;
            }
            this.a.set(paramInt, paramInfos);
            return this;
          }
          
          public DurationInfo setInterval(int paramInt)
          {
            this.b = true;
            this.c = paramInt;
            return this;
          }
          
          public DurationInfo setTimestamp(String paramString)
          {
            this.d = true;
            this.e = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasInterval()) {
              paramCodedOutputStreamMicro.writeInt32(1, getInterval());
            }
            if (hasTimestamp()) {
              paramCodedOutputStreamMicro.writeString(2, getTimestamp());
            }
            Iterator localIterator = getInfosList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeMessage(3, (Infos)localIterator.next());
            }
          }
          
          public static final class Infos
            extends MessageMicro
          {
            public static final int DURATION_FIELD_NUMBER = 2;
            public static final int INDEX_FIELD_NUMBER = 1;
            private boolean a;
            private int b = 0;
            private boolean c;
            private int d = 0;
            private int e = -1;
            
            public static Infos parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Infos().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Infos parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Infos)new Infos().mergeFrom(paramArrayOfByte);
            }
            
            public final Infos clear()
            {
              clearIndex();
              clearDuration();
              this.e = -1;
              return this;
            }
            
            public Infos clearDuration()
            {
              this.c = false;
              this.d = 0;
              return this;
            }
            
            public Infos clearIndex()
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
            
            public int getDuration()
            {
              return this.d;
            }
            
            public int getIndex()
            {
              return this.b;
            }
            
            public int getSerializedSize()
            {
              int i = 0;
              if (hasIndex()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIndex());
              }
              int j = i;
              if (hasDuration()) {
                j = i + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
              }
              this.e = j;
              return j;
            }
            
            public boolean hasDuration()
            {
              return this.c;
            }
            
            public boolean hasIndex()
            {
              return this.a;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Infos mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  setIndex(paramCodedInputStreamMicro.readInt32());
                  break;
                case 16: 
                  setDuration(paramCodedInputStreamMicro.readInt32());
                }
              }
            }
            
            public Infos setDuration(int paramInt)
            {
              this.c = true;
              this.d = paramInt;
              return this;
            }
            
            public Infos setIndex(int paramInt)
            {
              this.a = true;
              this.b = paramInt;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasIndex()) {
                paramCodedOutputStreamMicro.writeInt32(1, getIndex());
              }
              if (hasDuration()) {
                paramCodedOutputStreamMicro.writeInt32(2, getDuration());
              }
            }
          }
        }
        
        public static final class DurationWholeday
          extends MessageMicro
        {
          public static final int INFOS_FIELD_NUMBER = 3;
          public static final int INTERVAL_FIELD_NUMBER = 1;
          public static final int TIMESTAMP_FIELD_NUMBER = 2;
          private List<Infos> a = Collections.emptyList();
          private boolean b;
          private int c = 0;
          private boolean d;
          private String e = "";
          private int f = -1;
          
          public static DurationWholeday parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new DurationWholeday().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static DurationWholeday parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (DurationWholeday)new DurationWholeday().mergeFrom(paramArrayOfByte);
          }
          
          public DurationWholeday addInfos(Infos paramInfos)
          {
            if (paramInfos == null) {
              return this;
            }
            if (this.a.isEmpty()) {
              this.a = new ArrayList();
            }
            this.a.add(paramInfos);
            return this;
          }
          
          public final DurationWholeday clear()
          {
            clearInfos();
            clearInterval();
            clearTimestamp();
            this.f = -1;
            return this;
          }
          
          public DurationWholeday clearInfos()
          {
            this.a = Collections.emptyList();
            return this;
          }
          
          public DurationWholeday clearInterval()
          {
            this.b = false;
            this.c = 0;
            return this;
          }
          
          public DurationWholeday clearTimestamp()
          {
            this.d = false;
            this.e = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.f < 0) {
              getSerializedSize();
            }
            return this.f;
          }
          
          public Infos getInfos(int paramInt)
          {
            return (Infos)this.a.get(paramInt);
          }
          
          public int getInfosCount()
          {
            return this.a.size();
          }
          
          public List<Infos> getInfosList()
          {
            return this.a;
          }
          
          public int getInterval()
          {
            return this.c;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasInterval()) {
              i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getInterval());
            }
            int j = i;
            if (hasTimestamp()) {
              j = i + CodedOutputStreamMicro.computeStringSize(2, getTimestamp());
            }
            Iterator localIterator = getInfosList().iterator();
            while (localIterator.hasNext()) {
              j = CodedOutputStreamMicro.computeMessageSize(3, (Infos)localIterator.next()) + j;
            }
            this.f = j;
            return j;
          }
          
          public String getTimestamp()
          {
            return this.e;
          }
          
          public boolean hasInterval()
          {
            return this.b;
          }
          
          public boolean hasTimestamp()
          {
            return this.d;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public DurationWholeday mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setInterval(paramCodedInputStreamMicro.readInt32());
                break;
              case 18: 
                setTimestamp(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                Infos localInfos = new Infos();
                paramCodedInputStreamMicro.readMessage(localInfos);
                addInfos(localInfos);
              }
            }
          }
          
          public DurationWholeday setInfos(int paramInt, Infos paramInfos)
          {
            if (paramInfos == null) {
              return this;
            }
            this.a.set(paramInt, paramInfos);
            return this;
          }
          
          public DurationWholeday setInterval(int paramInt)
          {
            this.b = true;
            this.c = paramInt;
            return this;
          }
          
          public DurationWholeday setTimestamp(String paramString)
          {
            this.d = true;
            this.e = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasInterval()) {
              paramCodedOutputStreamMicro.writeInt32(1, getInterval());
            }
            if (hasTimestamp()) {
              paramCodedOutputStreamMicro.writeString(2, getTimestamp());
            }
            Iterator localIterator = getInfosList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeMessage(3, (Infos)localIterator.next());
            }
          }
          
          public static final class Infos
            extends MessageMicro
          {
            public static final int DURATION_FIELD_NUMBER = 2;
            public static final int INDEX_FIELD_NUMBER = 1;
            private boolean a;
            private int b = 0;
            private boolean c;
            private int d = 0;
            private int e = -1;
            
            public static Infos parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Infos().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Infos parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Infos)new Infos().mergeFrom(paramArrayOfByte);
            }
            
            public final Infos clear()
            {
              clearIndex();
              clearDuration();
              this.e = -1;
              return this;
            }
            
            public Infos clearDuration()
            {
              this.c = false;
              this.d = 0;
              return this;
            }
            
            public Infos clearIndex()
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
            
            public int getDuration()
            {
              return this.d;
            }
            
            public int getIndex()
            {
              return this.b;
            }
            
            public int getSerializedSize()
            {
              int i = 0;
              if (hasIndex()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIndex());
              }
              int j = i;
              if (hasDuration()) {
                j = i + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
              }
              this.e = j;
              return j;
            }
            
            public boolean hasDuration()
            {
              return this.c;
            }
            
            public boolean hasIndex()
            {
              return this.a;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Infos mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  setIndex(paramCodedInputStreamMicro.readInt32());
                  break;
                case 16: 
                  setDuration(paramCodedInputStreamMicro.readInt32());
                }
              }
            }
            
            public Infos setDuration(int paramInt)
            {
              this.c = true;
              this.d = paramInt;
              return this;
            }
            
            public Infos setIndex(int paramInt)
            {
              this.a = true;
              this.b = paramInt;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasIndex()) {
                paramCodedOutputStreamMicro.writeInt32(1, getIndex());
              }
              if (hasDuration()) {
                paramCodedOutputStreamMicro.writeInt32(2, getDuration());
              }
            }
          }
        }
        
        public static final class Stepis
          extends MessageMicro
        {
          public static final int N_FIELD_NUMBER = 1;
          public static final int S_FIELD_NUMBER = 2;
          private boolean a;
          private int b = 0;
          private boolean c;
          private int d = 0;
          private int e = -1;
          
          public static Stepis parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Stepis().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Stepis parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Stepis)new Stepis().mergeFrom(paramArrayOfByte);
          }
          
          public final Stepis clear()
          {
            clearN();
            clearS();
            this.e = -1;
            return this;
          }
          
          public Stepis clearN()
          {
            this.a = false;
            this.b = 0;
            return this;
          }
          
          public Stepis clearS()
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
          
          public int getN()
          {
            return this.b;
          }
          
          public int getS()
          {
            return this.d;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasN()) {
              i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getN());
            }
            int j = i;
            if (hasS()) {
              j = i + CodedOutputStreamMicro.computeInt32Size(2, getS());
            }
            this.e = j;
            return j;
          }
          
          public boolean hasN()
          {
            return this.a;
          }
          
          public boolean hasS()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Stepis mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setN(paramCodedInputStreamMicro.readInt32());
                break;
              case 16: 
                setS(paramCodedInputStreamMicro.readInt32());
              }
            }
          }
          
          public Stepis setN(int paramInt)
          {
            this.a = true;
            this.b = paramInt;
            return this;
          }
          
          public Stepis setS(int paramInt)
          {
            this.c = true;
            this.d = paramInt;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasN()) {
              paramCodedOutputStreamMicro.writeInt32(1, getN());
            }
            if (hasS()) {
              paramCodedOutputStreamMicro.writeInt32(2, getS());
            }
          }
        }
      }
      
      public static final class WholeCondition
        extends MessageMicro
      {
        public static final int LENGTH_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private boolean a;
        private int b = 0;
        private boolean c;
        private int d = 0;
        private int e = -1;
        
        public static WholeCondition parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new WholeCondition().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static WholeCondition parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (WholeCondition)new WholeCondition().mergeFrom(paramArrayOfByte);
        }
        
        public final WholeCondition clear()
        {
          clearType();
          clearLength();
          this.e = -1;
          return this;
        }
        
        public WholeCondition clearLength()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public WholeCondition clearType()
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
        
        public int getLength()
        {
          return this.d;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasType()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
          }
          int j = i;
          if (hasLength()) {
            j = i + CodedOutputStreamMicro.computeInt32Size(2, getLength());
          }
          this.e = j;
          return j;
        }
        
        public int getType()
        {
          return this.b;
        }
        
        public boolean hasLength()
        {
          return this.c;
        }
        
        public boolean hasType()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public WholeCondition mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setType(paramCodedInputStreamMicro.readInt32());
              break;
            case 16: 
              setLength(paramCodedInputStreamMicro.readInt32());
            }
          }
        }
        
        public WholeCondition setLength(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public WholeCondition setType(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasType()) {
            paramCodedOutputStreamMicro.writeInt32(1, getType());
          }
          if (hasLength()) {
            paramCodedOutputStreamMicro.writeInt32(2, getLength());
          }
        }
      }
    }
    
    public static final class Steps
      extends MessageMicro
    {
      public static final int DIRECTION_FIELD_NUMBER = 1;
      public static final int DISTANCE_FIELD_NUMBER = 2;
      public static final int END_INSTRUCTIONS_FIELD_NUMBER = 7;
      public static final int INSTRUCTIONS_FIELD_NUMBER = 3;
      public static final int LEVEL_FIELD_NUMBER = 10;
      public static final int PATH_FIELD_NUMBER = 4;
      public static final int ROAD_TYPE_FIELD_NUMBER = 12;
      public static final int SPATH_FIELD_NUMBER = 8;
      public static final int START_INSTRUCTIONS_FIELD_NUMBER = 6;
      public static final int STEPRCS_FIELD_NUMBER = 11;
      public static final int TURN_FIELD_NUMBER = 5;
      public static final int USROADNAME_FIELD_NUMBER = 9;
      private boolean a;
      private int b = 0;
      private boolean c;
      private int d = 0;
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private boolean i;
      private int j = 0;
      private boolean k;
      private String l = "";
      private boolean m;
      private String n = "";
      private List<Integer> o = Collections.emptyList();
      private boolean p;
      private String q = "";
      private boolean r;
      private int s = 0;
      private List<Steprcs> t = Collections.emptyList();
      private boolean u;
      private int v = 0;
      private int w = -1;
      
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
      
      public Steps addSpath(int paramInt)
      {
        if (this.o.isEmpty()) {
          this.o = new ArrayList();
        }
        this.o.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Steps addSteprcs(Steprcs paramSteprcs)
      {
        if (paramSteprcs == null) {
          return this;
        }
        if (this.t.isEmpty()) {
          this.t = new ArrayList();
        }
        this.t.add(paramSteprcs);
        return this;
      }
      
      public final Steps clear()
      {
        clearDirection();
        clearDistance();
        clearInstructions();
        clearPath();
        clearTurn();
        clearStartInstructions();
        clearEndInstructions();
        clearSpath();
        clearUsroadname();
        clearLevel();
        clearSteprcs();
        clearRoadType();
        this.w = -1;
        return this;
      }
      
      public Steps clearDirection()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public Steps clearDistance()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public Steps clearEndInstructions()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public Steps clearInstructions()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Steps clearLevel()
      {
        this.r = false;
        this.s = 0;
        return this;
      }
      
      public Steps clearPath()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Steps clearRoadType()
      {
        this.u = false;
        this.v = 0;
        return this;
      }
      
      public Steps clearSpath()
      {
        this.o = Collections.emptyList();
        return this;
      }
      
      public Steps clearStartInstructions()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public Steps clearSteprcs()
      {
        this.t = Collections.emptyList();
        return this;
      }
      
      public Steps clearTurn()
      {
        this.i = false;
        this.j = 0;
        return this;
      }
      
      public Steps clearUsroadname()
      {
        this.p = false;
        this.q = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.w < 0) {
          getSerializedSize();
        }
        return this.w;
      }
      
      public int getDirection()
      {
        return this.b;
      }
      
      public int getDistance()
      {
        return this.d;
      }
      
      public String getEndInstructions()
      {
        return this.n;
      }
      
      public String getInstructions()
      {
        return this.f;
      }
      
      public int getLevel()
      {
        return this.s;
      }
      
      public String getPath()
      {
        return this.h;
      }
      
      public int getRoadType()
      {
        return this.v;
      }
      
      public int getSerializedSize()
      {
        int i3 = 0;
        if (hasDirection()) {}
        for (int i2 = CodedOutputStreamMicro.computeInt32Size(1, getDirection()) + 0;; i2 = 0)
        {
          int i1 = i2;
          if (hasDistance()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getDistance());
          }
          i2 = i1;
          if (hasInstructions()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getInstructions());
          }
          i1 = i2;
          if (hasPath()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getPath());
          }
          i2 = i1;
          if (hasTurn()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getTurn());
          }
          i1 = i2;
          if (hasStartInstructions()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getStartInstructions());
          }
          if (hasEndInstructions()) {
            i1 += CodedOutputStreamMicro.computeStringSize(7, getEndInstructions());
          }
          for (;;)
          {
            Iterator localIterator = getSpathList().iterator();
            i2 = i3;
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            i2 = i1 + i2 + getSpathList().size() * 1;
            i1 = i2;
            if (hasUsroadname()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(9, getUsroadname());
            }
            i2 = i1;
            if (hasLevel()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(10, getLevel());
            }
            localIterator = getSteprcsList().iterator();
            for (i1 = i2; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(11, (Steprcs)localIterator.next()) + i1) {}
            i2 = i1;
            if (hasRoadType()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(12, getRoadType());
            }
            this.w = i2;
            return i2;
          }
        }
      }
      
      public int getSpath(int paramInt)
      {
        return ((Integer)this.o.get(paramInt)).intValue();
      }
      
      public int getSpathCount()
      {
        return this.o.size();
      }
      
      public List<Integer> getSpathList()
      {
        return this.o;
      }
      
      public String getStartInstructions()
      {
        return this.l;
      }
      
      public Steprcs getSteprcs(int paramInt)
      {
        return (Steprcs)this.t.get(paramInt);
      }
      
      public int getSteprcsCount()
      {
        return this.t.size();
      }
      
      public List<Steprcs> getSteprcsList()
      {
        return this.t;
      }
      
      public int getTurn()
      {
        return this.j;
      }
      
      public String getUsroadname()
      {
        return this.q;
      }
      
      public boolean hasDirection()
      {
        return this.a;
      }
      
      public boolean hasDistance()
      {
        return this.c;
      }
      
      public boolean hasEndInstructions()
      {
        return this.m;
      }
      
      public boolean hasInstructions()
      {
        return this.e;
      }
      
      public boolean hasLevel()
      {
        return this.r;
      }
      
      public boolean hasPath()
      {
        return this.g;
      }
      
      public boolean hasRoadType()
      {
        return this.u;
      }
      
      public boolean hasStartInstructions()
      {
        return this.k;
      }
      
      public boolean hasTurn()
      {
        return this.i;
      }
      
      public boolean hasUsroadname()
      {
        return this.p;
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
            setDirection(paramCodedInputStreamMicro.readInt32());
            break;
          case 16: 
            setDistance(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            setInstructions(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setPath(paramCodedInputStreamMicro.readString());
            break;
          case 40: 
            setTurn(paramCodedInputStreamMicro.readInt32());
            break;
          case 50: 
            setStartInstructions(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setEndInstructions(paramCodedInputStreamMicro.readString());
            break;
          case 64: 
            addSpath(paramCodedInputStreamMicro.readSInt32());
            break;
          case 74: 
            setUsroadname(paramCodedInputStreamMicro.readString());
            break;
          case 80: 
            setLevel(paramCodedInputStreamMicro.readInt32());
            break;
          case 90: 
            Steprcs localSteprcs = new Steprcs();
            paramCodedInputStreamMicro.readMessage(localSteprcs);
            addSteprcs(localSteprcs);
            break;
          case 96: 
            setRoadType(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public Steps setDirection(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public Steps setDistance(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public Steps setEndInstructions(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public Steps setInstructions(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Steps setLevel(int paramInt)
      {
        this.r = true;
        this.s = paramInt;
        return this;
      }
      
      public Steps setPath(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Steps setRoadType(int paramInt)
      {
        this.u = true;
        this.v = paramInt;
        return this;
      }
      
      public Steps setSpath(int paramInt1, int paramInt2)
      {
        this.o.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Steps setStartInstructions(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public Steps setSteprcs(int paramInt, Steprcs paramSteprcs)
      {
        if (paramSteprcs == null) {
          return this;
        }
        this.t.set(paramInt, paramSteprcs);
        return this;
      }
      
      public Steps setTurn(int paramInt)
      {
        this.i = true;
        this.j = paramInt;
        return this;
      }
      
      public Steps setUsroadname(String paramString)
      {
        this.p = true;
        this.q = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDirection()) {
          paramCodedOutputStreamMicro.writeInt32(1, getDirection());
        }
        if (hasDistance()) {
          paramCodedOutputStreamMicro.writeInt32(2, getDistance());
        }
        if (hasInstructions()) {
          paramCodedOutputStreamMicro.writeString(3, getInstructions());
        }
        if (hasPath()) {
          paramCodedOutputStreamMicro.writeString(4, getPath());
        }
        if (hasTurn()) {
          paramCodedOutputStreamMicro.writeInt32(5, getTurn());
        }
        if (hasStartInstructions()) {
          paramCodedOutputStreamMicro.writeString(6, getStartInstructions());
        }
        if (hasEndInstructions()) {
          paramCodedOutputStreamMicro.writeString(7, getEndInstructions());
        }
        Iterator localIterator = getSpathList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(8, ((Integer)localIterator.next()).intValue());
        }
        if (hasUsroadname()) {
          paramCodedOutputStreamMicro.writeString(9, getUsroadname());
        }
        if (hasLevel()) {
          paramCodedOutputStreamMicro.writeInt32(10, getLevel());
        }
        localIterator = getSteprcsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(11, (Steprcs)localIterator.next());
        }
        if (hasRoadType()) {
          paramCodedOutputStreamMicro.writeInt32(12, getRoadType());
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
    
    public static final class Stepts
      extends MessageMicro
    {
      public static final int END_FIELD_NUMBER = 1;
      public static final int STATUS_FIELD_NUMBER = 2;
      private List<Integer> a = Collections.emptyList();
      private List<Integer> b = Collections.emptyList();
      private int c = -1;
      
      public static Stepts parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Stepts().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Stepts parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Stepts)new Stepts().mergeFrom(paramArrayOfByte);
      }
      
      public Stepts addEnd(int paramInt)
      {
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Stepts addStatus(int paramInt)
      {
        if (this.b.isEmpty()) {
          this.b = new ArrayList();
        }
        this.b.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public final Stepts clear()
      {
        clearEnd();
        clearStatus();
        this.c = -1;
        return this;
      }
      
      public Stepts clearEnd()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public Stepts clearStatus()
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
      
      public Stepts mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      
      public Stepts setEnd(int paramInt1, int paramInt2)
      {
        this.a.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Stepts setStatus(int paramInt1, int paramInt2)
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
    
    public static final class Taxis
      extends MessageMicro
    {
      public static final int TOTAL_PRICE_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private int c = -1;
      
      public static Taxis parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Taxis().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Taxis parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Taxis)new Taxis().mergeFrom(paramArrayOfByte);
      }
      
      public final Taxis clear()
      {
        clearTotalPrice();
        this.c = -1;
        return this;
      }
      
      public Taxis clearTotalPrice()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.c < 0) {
          getSerializedSize();
        }
        return this.c;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasTotalPrice()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTotalPrice());
        }
        this.c = i;
        return i;
      }
      
      public String getTotalPrice()
      {
        return this.b;
      }
      
      public boolean hasTotalPrice()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Taxis mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setTotalPrice(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Taxis setTotalPrice(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasTotalPrice()) {
          paramCodedOutputStreamMicro.writeString(1, getTotalPrice());
        }
      }
    }
    
    public static final class Traffics
      extends MessageMicro
    {
      public static final int CONGESTION_LENGTH_FIELD_NUMBER = 3;
      public static final int DIGEST_FIELD_NUMBER = 1;
      public static final int LEGS_FIELD_NUMBER = 2;
      public static final int UGC_TIPS_FIELD_NUMBER = 4;
      private boolean a;
      private String b = "";
      private List<Legs> c = Collections.emptyList();
      private boolean d;
      private int e = 0;
      private boolean f;
      private String g = "";
      private int h = -1;
      
      public static Traffics parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Traffics().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Traffics parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Traffics)new Traffics().mergeFrom(paramArrayOfByte);
      }
      
      public Traffics addLegs(Legs paramLegs)
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
      
      public final Traffics clear()
      {
        clearDigest();
        clearLegs();
        clearCongestionLength();
        clearUgcTips();
        this.h = -1;
        return this;
      }
      
      public Traffics clearCongestionLength()
      {
        this.d = false;
        this.e = 0;
        return this;
      }
      
      public Traffics clearDigest()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Traffics clearLegs()
      {
        this.c = Collections.emptyList();
        return this;
      }
      
      public Traffics clearUgcTips()
      {
        this.f = false;
        this.g = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.h < 0) {
          getSerializedSize();
        }
        return this.h;
      }
      
      public int getCongestionLength()
      {
        return this.e;
      }
      
      public String getDigest()
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
        if (hasDigest()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDigest());
        }
        Iterator localIterator = getLegsList().iterator();
        for (int j = i; localIterator.hasNext(); j = CodedOutputStreamMicro.computeMessageSize(2, (Legs)localIterator.next()) + j) {}
        i = j;
        if (hasCongestionLength()) {
          i = j + CodedOutputStreamMicro.computeInt32Size(3, getCongestionLength());
        }
        j = i;
        if (hasUgcTips()) {
          j = i + CodedOutputStreamMicro.computeStringSize(4, getUgcTips());
        }
        this.h = j;
        return j;
      }
      
      public String getUgcTips()
      {
        return this.g;
      }
      
      public boolean hasCongestionLength()
      {
        return this.d;
      }
      
      public boolean hasDigest()
      {
        return this.a;
      }
      
      public boolean hasUgcTips()
      {
        return this.f;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Traffics mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setDigest(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            Legs localLegs = new Legs();
            paramCodedInputStreamMicro.readMessage(localLegs);
            addLegs(localLegs);
            break;
          case 24: 
            setCongestionLength(paramCodedInputStreamMicro.readInt32());
            break;
          case 34: 
            setUgcTips(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Traffics setCongestionLength(int paramInt)
      {
        this.d = true;
        this.e = paramInt;
        return this;
      }
      
      public Traffics setDigest(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Traffics setLegs(int paramInt, Legs paramLegs)
      {
        if (paramLegs == null) {
          return this;
        }
        this.c.set(paramInt, paramLegs);
        return this;
      }
      
      public Traffics setUgcTips(String paramString)
      {
        this.f = true;
        this.g = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDigest()) {
          paramCodedOutputStreamMicro.writeString(1, getDigest());
        }
        Iterator localIterator = getLegsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(2, (Legs)localIterator.next());
        }
        if (hasCongestionLength()) {
          paramCodedOutputStreamMicro.writeInt32(3, getCongestionLength());
        }
        if (hasUgcTips()) {
          paramCodedOutputStreamMicro.writeString(4, getUgcTips());
        }
      }
      
      public static final class Legs
        extends MessageMicro
      {
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int MRSL_FIELD_NUMBER = 4;
        public static final int STEPTIS_FIELD_NUMBER = 3;
        private boolean a;
        private int b = 0;
        private boolean c;
        private int d = 0;
        private List<Steptis> e = Collections.emptyList();
        private boolean f;
        private String g = "";
        private int h = -1;
        
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
        
        public Legs addSteptis(Steptis paramSteptis)
        {
          if (paramSteptis == null) {
            return this;
          }
          if (this.e.isEmpty()) {
            this.e = new ArrayList();
          }
          this.e.add(paramSteptis);
          return this;
        }
        
        public final Legs clear()
        {
          clearDistance();
          clearDuration();
          clearSteptis();
          clearMrsl();
          this.h = -1;
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
        
        public Legs clearMrsl()
        {
          this.f = false;
          this.g = "";
          return this;
        }
        
        public Legs clearSteptis()
        {
          this.e = Collections.emptyList();
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.h < 0) {
            getSerializedSize();
          }
          return this.h;
        }
        
        public int getDistance()
        {
          return this.b;
        }
        
        public int getDuration()
        {
          return this.d;
        }
        
        public String getMrsl()
        {
          return this.g;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasDistance()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
          }
          int j = i;
          if (hasDuration()) {
            j = i + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
          }
          Iterator localIterator = getSteptisList().iterator();
          for (i = j; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(3, (Steptis)localIterator.next()) + i) {}
          j = i;
          if (hasMrsl()) {
            j = i + CodedOutputStreamMicro.computeStringSize(4, getMrsl());
          }
          this.h = j;
          return j;
        }
        
        public Steptis getSteptis(int paramInt)
        {
          return (Steptis)this.e.get(paramInt);
        }
        
        public int getSteptisCount()
        {
          return this.e.size();
        }
        
        public List<Steptis> getSteptisList()
        {
          return this.e;
        }
        
        public boolean hasDistance()
        {
          return this.a;
        }
        
        public boolean hasDuration()
        {
          return this.c;
        }
        
        public boolean hasMrsl()
        {
          return this.f;
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
            case 8: 
              setDistance(paramCodedInputStreamMicro.readInt32());
              break;
            case 16: 
              setDuration(paramCodedInputStreamMicro.readInt32());
              break;
            case 26: 
              Steptis localSteptis = new Steptis();
              paramCodedInputStreamMicro.readMessage(localSteptis);
              addSteptis(localSteptis);
              break;
            case 34: 
              setMrsl(paramCodedInputStreamMicro.readString());
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
        
        public Legs setMrsl(String paramString)
        {
          this.f = true;
          this.g = paramString;
          return this;
        }
        
        public Legs setSteptis(int paramInt, Steptis paramSteptis)
        {
          if (paramSteptis == null) {
            return this;
          }
          this.e.set(paramInt, paramSteptis);
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
          Iterator localIterator = getSteptisList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(3, (Steptis)localIterator.next());
          }
          if (hasMrsl()) {
            paramCodedOutputStreamMicro.writeString(4, getMrsl());
          }
        }
        
        public static final class Steptis
          extends MessageMicro
        {
          public static final int N_FIELD_NUMBER = 1;
          public static final int S_FIELD_NUMBER = 2;
          private boolean a;
          private int b = 0;
          private boolean c;
          private int d = 0;
          private int e = -1;
          
          public static Steptis parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Steptis().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Steptis parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Steptis)new Steptis().mergeFrom(paramArrayOfByte);
          }
          
          public final Steptis clear()
          {
            clearN();
            clearS();
            this.e = -1;
            return this;
          }
          
          public Steptis clearN()
          {
            this.a = false;
            this.b = 0;
            return this;
          }
          
          public Steptis clearS()
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
          
          public int getN()
          {
            return this.b;
          }
          
          public int getS()
          {
            return this.d;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasN()) {
              i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getN());
            }
            int j = i;
            if (hasS()) {
              j = i + CodedOutputStreamMicro.computeInt32Size(2, getS());
            }
            this.e = j;
            return j;
          }
          
          public boolean hasN()
          {
            return this.a;
          }
          
          public boolean hasS()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Steptis mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setN(paramCodedInputStreamMicro.readInt32());
                break;
              case 16: 
                setS(paramCodedInputStreamMicro.readInt32());
              }
            }
          }
          
          public Steptis setN(int paramInt)
          {
            this.a = true;
            this.b = paramInt;
            return this;
          }
          
          public Steptis setS(int paramInt)
          {
            this.c = true;
            this.d = paramInt;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasN()) {
              paramCodedOutputStreamMicro.writeInt32(1, getN());
            }
            if (hasS()) {
              paramCodedOutputStreamMicro.writeInt32(2, getS());
            }
          }
        }
      }
    }
    
    public static final class WalkInfoT
      extends MessageMicro
    {
      public static final int DIST_FIELD_NUMBER = 1;
      public static final int PT_FIELD_NUMBER = 2;
      private boolean a;
      private int b = 0;
      private List<Integer> c = Collections.emptyList();
      private int d = -1;
      
      public static WalkInfoT parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new WalkInfoT().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static WalkInfoT parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (WalkInfoT)new WalkInfoT().mergeFrom(paramArrayOfByte);
      }
      
      public WalkInfoT addPt(int paramInt)
      {
        if (this.c.isEmpty()) {
          this.c = new ArrayList();
        }
        this.c.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public final WalkInfoT clear()
      {
        clearDist();
        clearPt();
        this.d = -1;
        return this;
      }
      
      public WalkInfoT clearDist()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public WalkInfoT clearPt()
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
      
      public int getDist()
      {
        return this.b;
      }
      
      public int getPt(int paramInt)
      {
        return ((Integer)this.c.get(paramInt)).intValue();
      }
      
      public int getPtCount()
      {
        return this.c.size();
      }
      
      public List<Integer> getPtList()
      {
        return this.c;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        if (hasDist()) {}
        for (int i = CodedOutputStreamMicro.computeInt32Size(1, getDist()) + 0;; i = 0)
        {
          Iterator localIterator = getPtList().iterator();
          while (localIterator.hasNext()) {
            j += CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue());
          }
          i = i + j + getPtList().size() * 1;
          this.d = i;
          return i;
        }
      }
      
      public boolean hasDist()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return this.a;
      }
      
      public WalkInfoT mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setDist(paramCodedInputStreamMicro.readInt32());
            break;
          case 16: 
            addPt(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public WalkInfoT setDist(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public WalkInfoT setPt(int paramInt1, int paramInt2)
      {
        this.c.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDist()) {
          paramCodedOutputStreamMicro.writeInt32(1, getDist());
        }
        Iterator localIterator = getPtList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeInt32(2, ((Integer)localIterator.next()).intValue());
        }
      }
    }
    
    public static final class YellowTipsList
      extends MessageMicro
    {
      public static final int MRSL_FIELD_NUMBER = 2;
      public static final int YELLOW_TIPS_INFO_FIELD_NUMBER = 1;
      private List<YellowTipsInfo> a = Collections.emptyList();
      private boolean b;
      private String c = "";
      private int d = -1;
      
      public static YellowTipsList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new YellowTipsList().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static YellowTipsList parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (YellowTipsList)new YellowTipsList().mergeFrom(paramArrayOfByte);
      }
      
      public YellowTipsList addYellowTipsInfo(YellowTipsInfo paramYellowTipsInfo)
      {
        if (paramYellowTipsInfo == null) {
          return this;
        }
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(paramYellowTipsInfo);
        return this;
      }
      
      public final YellowTipsList clear()
      {
        clearYellowTipsInfo();
        clearMrsl();
        this.d = -1;
        return this;
      }
      
      public YellowTipsList clearMrsl()
      {
        this.b = false;
        this.c = "";
        return this;
      }
      
      public YellowTipsList clearYellowTipsInfo()
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
      
      public String getMrsl()
      {
        return this.c;
      }
      
      public int getSerializedSize()
      {
        Iterator localIterator = getYellowTipsInfoList().iterator();
        for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (YellowTipsInfo)localIterator.next()) + i) {}
        int j = i;
        if (hasMrsl()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getMrsl());
        }
        this.d = j;
        return j;
      }
      
      public YellowTipsInfo getYellowTipsInfo(int paramInt)
      {
        return (YellowTipsInfo)this.a.get(paramInt);
      }
      
      public int getYellowTipsInfoCount()
      {
        return this.a.size();
      }
      
      public List<YellowTipsInfo> getYellowTipsInfoList()
      {
        return this.a;
      }
      
      public boolean hasMrsl()
      {
        return this.b;
      }
      
      public final boolean isInitialized()
      {
        Iterator localIterator = getYellowTipsInfoList().iterator();
        while (localIterator.hasNext()) {
          if (!((YellowTipsInfo)localIterator.next()).isInitialized()) {
            return false;
          }
        }
        return true;
      }
      
      public YellowTipsList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            YellowTipsInfo localYellowTipsInfo = new YellowTipsInfo();
            paramCodedInputStreamMicro.readMessage(localYellowTipsInfo);
            addYellowTipsInfo(localYellowTipsInfo);
            break;
          case 18: 
            setMrsl(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public YellowTipsList setMrsl(String paramString)
      {
        this.b = true;
        this.c = paramString;
        return this;
      }
      
      public YellowTipsList setYellowTipsInfo(int paramInt, YellowTipsInfo paramYellowTipsInfo)
      {
        if (paramYellowTipsInfo == null) {
          return this;
        }
        this.a.set(paramInt, paramYellowTipsInfo);
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getYellowTipsInfoList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(1, (YellowTipsInfo)localIterator.next());
        }
        if (hasMrsl()) {
          paramCodedOutputStreamMicro.writeString(2, getMrsl());
        }
      }
      
      public static final class YellowTipsInfo
        extends MessageMicro
      {
        public static final int ASSIST_INFO_FIELD_NUMBER = 3;
        public static final int BACK_COLOR_ID_FIELD_NUMBER = 6;
        public static final int ICON_ID_FIELD_NUMBER = 5;
        public static final int SUB_TITLE_FIELD_NUMBER = 2;
        public static final int TIP_ID_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 1;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private String f = "";
        private boolean g;
        private int h = 0;
        private boolean i;
        private int j = 0;
        private boolean k;
        private int l = 0;
        private int m = -1;
        
        public static YellowTipsInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new YellowTipsInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static YellowTipsInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (YellowTipsInfo)new YellowTipsInfo().mergeFrom(paramArrayOfByte);
        }
        
        public final YellowTipsInfo clear()
        {
          clearTitle();
          clearSubTitle();
          clearAssistInfo();
          clearTipId();
          clearIconId();
          clearBackColorId();
          this.m = -1;
          return this;
        }
        
        public YellowTipsInfo clearAssistInfo()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public YellowTipsInfo clearBackColorId()
        {
          this.k = false;
          this.l = 0;
          return this;
        }
        
        public YellowTipsInfo clearIconId()
        {
          this.i = false;
          this.j = 0;
          return this;
        }
        
        public YellowTipsInfo clearSubTitle()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public YellowTipsInfo clearTipId()
        {
          this.g = false;
          this.h = 0;
          return this;
        }
        
        public YellowTipsInfo clearTitle()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public String getAssistInfo()
        {
          return this.f;
        }
        
        public int getBackColorId()
        {
          return this.l;
        }
        
        public int getCachedSize()
        {
          if (this.m < 0) {
            getSerializedSize();
          }
          return this.m;
        }
        
        public int getIconId()
        {
          return this.j;
        }
        
        public int getSerializedSize()
        {
          int i1 = 0;
          if (hasTitle()) {
            i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
          }
          int n = i1;
          if (hasSubTitle()) {
            n = i1 + CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
          }
          i1 = n;
          if (hasAssistInfo()) {
            i1 = n + CodedOutputStreamMicro.computeStringSize(3, getAssistInfo());
          }
          n = i1;
          if (hasTipId()) {
            n = i1 + CodedOutputStreamMicro.computeInt32Size(4, getTipId());
          }
          i1 = n;
          if (hasIconId()) {
            i1 = n + CodedOutputStreamMicro.computeInt32Size(5, getIconId());
          }
          n = i1;
          if (hasBackColorId()) {
            n = i1 + CodedOutputStreamMicro.computeInt32Size(6, getBackColorId());
          }
          this.m = n;
          return n;
        }
        
        public String getSubTitle()
        {
          return this.d;
        }
        
        public int getTipId()
        {
          return this.h;
        }
        
        public String getTitle()
        {
          return this.b;
        }
        
        public boolean hasAssistInfo()
        {
          return this.e;
        }
        
        public boolean hasBackColorId()
        {
          return this.k;
        }
        
        public boolean hasIconId()
        {
          return this.i;
        }
        
        public boolean hasSubTitle()
        {
          return this.c;
        }
        
        public boolean hasTipId()
        {
          return this.g;
        }
        
        public boolean hasTitle()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          if (!this.a) {}
          while (!this.g) {
            return false;
          }
          return true;
        }
        
        public YellowTipsInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setTitle(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setSubTitle(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              setAssistInfo(paramCodedInputStreamMicro.readString());
              break;
            case 32: 
              setTipId(paramCodedInputStreamMicro.readInt32());
              break;
            case 40: 
              setIconId(paramCodedInputStreamMicro.readInt32());
              break;
            case 48: 
              setBackColorId(paramCodedInputStreamMicro.readInt32());
            }
          }
        }
        
        public YellowTipsInfo setAssistInfo(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public YellowTipsInfo setBackColorId(int paramInt)
        {
          this.k = true;
          this.l = paramInt;
          return this;
        }
        
        public YellowTipsInfo setIconId(int paramInt)
        {
          this.i = true;
          this.j = paramInt;
          return this;
        }
        
        public YellowTipsInfo setSubTitle(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public YellowTipsInfo setTipId(int paramInt)
        {
          this.g = true;
          this.h = paramInt;
          return this;
        }
        
        public YellowTipsInfo setTitle(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasTitle()) {
            paramCodedOutputStreamMicro.writeString(1, getTitle());
          }
          if (hasSubTitle()) {
            paramCodedOutputStreamMicro.writeString(2, getSubTitle());
          }
          if (hasAssistInfo()) {
            paramCodedOutputStreamMicro.writeString(3, getAssistInfo());
          }
          if (hasTipId()) {
            paramCodedOutputStreamMicro.writeInt32(4, getTipId());
          }
          if (hasIconId()) {
            paramCodedOutputStreamMicro.writeInt32(5, getIconId());
          }
          if (hasBackColorId()) {
            paramCodedOutputStreamMicro.writeInt32(6, getBackColorId());
          }
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int AVOID_JAM_FIELD_NUMBER = 1;
    public static final int END_BID_FIELD_NUMBER = 15;
    public static final int END_FIELD_NUMBER = 6;
    public static final int END_NAME_FIELD_NUMBER = 4;
    public static final int IS_LONG_DISTANCE_FIELD_NUMBER = 12;
    public static final int LOCAL_INFO_URL_FIELD_NUMBER = 11;
    public static final int NAVI_TYPE_FIELD_NUMBER = 13;
    public static final int PREFER_FIELD_NUMBER = 8;
    public static final int ROUTE_PLAN_NET_MODE_FIELD_NUMBER = 10;
    public static final int Route_Plan_Net_Mode_Offline = 1;
    public static final int Route_Plan_Net_Mode_Offline2Online = 3;
    public static final int Route_Plan_Net_Mode_Online = 0;
    public static final int Route_Plan_Net_Mode_Online2Offline = 2;
    public static final int START_BID_FIELD_NUMBER = 14;
    public static final int START_FIELD_NUMBER = 5;
    public static final int START_NAME_FIELD_NUMBER = 3;
    public static final int SY_FIELD_NUMBER = 7;
    public static final int TOTAL_FIELD_NUMBER = 2;
    public static final int VIA_NAME_FIELD_NUMBER = 9;
    private List<String> A = Collections.emptyList();
    private int B = -1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private Start j = null;
    private List<End> k = Collections.emptyList();
    private boolean l;
    private int m = 0;
    private boolean n;
    private int o = 0;
    private List<String> p = Collections.emptyList();
    private boolean q;
    private int r = 0;
    private boolean s;
    private LocalInfoUrl t = null;
    private boolean u;
    private int v = 0;
    private boolean w;
    private int x = 0;
    private boolean y;
    private String z = "";
    
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
      if (this.k.isEmpty()) {
        this.k = new ArrayList();
      }
      this.k.add(paramEnd);
      return this;
    }
    
    public Option addEndBid(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.A.isEmpty()) {
        this.A = new ArrayList();
      }
      this.A.add(paramString);
      return this;
    }
    
    public Option addViaName(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.p.isEmpty()) {
        this.p = new ArrayList();
      }
      this.p.add(paramString);
      return this;
    }
    
    public final Option clear()
    {
      clearAvoidJam();
      clearTotal();
      clearStartName();
      clearEndName();
      clearStart();
      clearEnd();
      clearSy();
      clearPrefer();
      clearViaName();
      clearRoutePlanNetMode();
      clearLocalInfoUrl();
      clearIsLongDistance();
      clearNaviType();
      clearStartBid();
      clearEndBid();
      this.B = -1;
      return this;
    }
    
    public Option clearAvoidJam()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Option clearEnd()
    {
      this.k = Collections.emptyList();
      return this;
    }
    
    public Option clearEndBid()
    {
      this.A = Collections.emptyList();
      return this;
    }
    
    public Option clearEndName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Option clearIsLongDistance()
    {
      this.u = false;
      this.v = 0;
      return this;
    }
    
    public Option clearLocalInfoUrl()
    {
      this.s = false;
      this.t = null;
      return this;
    }
    
    public Option clearNaviType()
    {
      this.w = false;
      this.x = 0;
      return this;
    }
    
    public Option clearPrefer()
    {
      this.n = false;
      this.o = 0;
      return this;
    }
    
    public Option clearRoutePlanNetMode()
    {
      this.q = false;
      this.r = 0;
      return this;
    }
    
    public Option clearStart()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public Option clearStartBid()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public Option clearStartName()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Option clearSy()
    {
      this.l = false;
      this.m = 0;
      return this;
    }
    
    public Option clearTotal()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Option clearViaName()
    {
      this.p = Collections.emptyList();
      return this;
    }
    
    public int getAvoidJam()
    {
      return this.b;
    }
    
    public int getCachedSize()
    {
      if (this.B < 0) {
        getSerializedSize();
      }
      return this.B;
    }
    
    public End getEnd(int paramInt)
    {
      return (End)this.k.get(paramInt);
    }
    
    public String getEndBid(int paramInt)
    {
      return (String)this.A.get(paramInt);
    }
    
    public int getEndBidCount()
    {
      return this.A.size();
    }
    
    public List<String> getEndBidList()
    {
      return this.A;
    }
    
    public int getEndCount()
    {
      return this.k.size();
    }
    
    public List<End> getEndList()
    {
      return this.k;
    }
    
    public String getEndName()
    {
      return this.h;
    }
    
    public int getIsLongDistance()
    {
      return this.v;
    }
    
    public LocalInfoUrl getLocalInfoUrl()
    {
      return this.t;
    }
    
    public int getNaviType()
    {
      return this.x;
    }
    
    public int getPrefer()
    {
      return this.o;
    }
    
    public int getRoutePlanNetMode()
    {
      return this.r;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasAvoidJam()) {}
      for (int i2 = CodedOutputStreamMicro.computeInt32Size(1, getAvoidJam()) + 0;; i2 = 0)
      {
        int i1 = i2;
        if (hasTotal()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getTotal());
        }
        i2 = i1;
        if (hasStartName()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getStartName());
        }
        i1 = i2;
        if (hasEndName()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getEndName());
        }
        i2 = i1;
        if (hasStart()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getStart());
        }
        Iterator localIterator = getEndList().iterator();
        while (localIterator.hasNext()) {
          i2 = CodedOutputStreamMicro.computeMessageSize(6, (End)localIterator.next()) + i2;
        }
        i1 = i2;
        if (hasSy()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(7, getSy());
        }
        i2 = i1;
        if (hasPrefer()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(8, getPrefer());
        }
        localIterator = getViaNameList().iterator();
        for (i1 = 0; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i1) {}
        i2 = i2 + i1 + getViaNameList().size() * 1;
        i1 = i2;
        if (hasRoutePlanNetMode()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getRoutePlanNetMode());
        }
        i2 = i1;
        if (hasLocalInfoUrl()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(11, getLocalInfoUrl());
        }
        i1 = i2;
        if (hasIsLongDistance()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getIsLongDistance());
        }
        i2 = i1;
        if (hasNaviType()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(13, getNaviType());
        }
        if (hasStartBid()) {}
        for (i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getStartBid());; i1 = i2)
        {
          localIterator = getEndBidList().iterator();
          i2 = i3;
          while (localIterator.hasNext()) {
            i2 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
          }
          i1 = i1 + i2 + getEndBidList().size() * 1;
          this.B = i1;
          return i1;
        }
      }
    }
    
    public Start getStart()
    {
      return this.j;
    }
    
    public String getStartBid()
    {
      return this.z;
    }
    
    public String getStartName()
    {
      return this.f;
    }
    
    public int getSy()
    {
      return this.m;
    }
    
    public int getTotal()
    {
      return this.d;
    }
    
    public String getViaName(int paramInt)
    {
      return (String)this.p.get(paramInt);
    }
    
    public int getViaNameCount()
    {
      return this.p.size();
    }
    
    public List<String> getViaNameList()
    {
      return this.p;
    }
    
    public boolean hasAvoidJam()
    {
      return this.a;
    }
    
    public boolean hasEndName()
    {
      return this.g;
    }
    
    public boolean hasIsLongDistance()
    {
      return this.u;
    }
    
    public boolean hasLocalInfoUrl()
    {
      return this.s;
    }
    
    public boolean hasNaviType()
    {
      return this.w;
    }
    
    public boolean hasPrefer()
    {
      return this.n;
    }
    
    public boolean hasRoutePlanNetMode()
    {
      return this.q;
    }
    
    public boolean hasStart()
    {
      return this.i;
    }
    
    public boolean hasStartBid()
    {
      return this.y;
    }
    
    public boolean hasStartName()
    {
      return this.e;
    }
    
    public boolean hasSy()
    {
      return this.l;
    }
    
    public boolean hasTotal()
    {
      return this.c;
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
          setAvoidJam(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setTotal(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setStartName(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setEndName(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          localObject = new Start();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setStart((Start)localObject);
          break;
        case 50: 
          localObject = new End();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addEnd((End)localObject);
          break;
        case 56: 
          setSy(paramCodedInputStreamMicro.readInt32());
          break;
        case 64: 
          setPrefer(paramCodedInputStreamMicro.readInt32());
          break;
        case 74: 
          addViaName(paramCodedInputStreamMicro.readString());
          break;
        case 80: 
          setRoutePlanNetMode(paramCodedInputStreamMicro.readInt32());
          break;
        case 90: 
          localObject = new LocalInfoUrl();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setLocalInfoUrl((LocalInfoUrl)localObject);
          break;
        case 96: 
          setIsLongDistance(paramCodedInputStreamMicro.readInt32());
          break;
        case 104: 
          setNaviType(paramCodedInputStreamMicro.readInt32());
          break;
        case 114: 
          setStartBid(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          addEndBid(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Option setAvoidJam(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Option setEnd(int paramInt, End paramEnd)
    {
      if (paramEnd == null) {
        return this;
      }
      this.k.set(paramInt, paramEnd);
      return this;
    }
    
    public Option setEndBid(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.A.set(paramInt, paramString);
      return this;
    }
    
    public Option setEndName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Option setIsLongDistance(int paramInt)
    {
      this.u = true;
      this.v = paramInt;
      return this;
    }
    
    public Option setLocalInfoUrl(LocalInfoUrl paramLocalInfoUrl)
    {
      if (paramLocalInfoUrl == null) {
        return clearLocalInfoUrl();
      }
      this.s = true;
      this.t = paramLocalInfoUrl;
      return this;
    }
    
    public Option setNaviType(int paramInt)
    {
      this.w = true;
      this.x = paramInt;
      return this;
    }
    
    public Option setPrefer(int paramInt)
    {
      this.n = true;
      this.o = paramInt;
      return this;
    }
    
    public Option setRoutePlanNetMode(int paramInt)
    {
      this.q = true;
      this.r = paramInt;
      return this;
    }
    
    public Option setStart(Start paramStart)
    {
      if (paramStart == null) {
        return clearStart();
      }
      this.i = true;
      this.j = paramStart;
      return this;
    }
    
    public Option setStartBid(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public Option setStartName(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Option setSy(int paramInt)
    {
      this.l = true;
      this.m = paramInt;
      return this;
    }
    
    public Option setTotal(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Option setViaName(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.p.set(paramInt, paramString);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAvoidJam()) {
        paramCodedOutputStreamMicro.writeInt32(1, getAvoidJam());
      }
      if (hasTotal()) {
        paramCodedOutputStreamMicro.writeInt32(2, getTotal());
      }
      if (hasStartName()) {
        paramCodedOutputStreamMicro.writeString(3, getStartName());
      }
      if (hasEndName()) {
        paramCodedOutputStreamMicro.writeString(4, getEndName());
      }
      if (hasStart()) {
        paramCodedOutputStreamMicro.writeMessage(5, getStart());
      }
      Iterator localIterator = getEndList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(6, (End)localIterator.next());
      }
      if (hasSy()) {
        paramCodedOutputStreamMicro.writeInt32(7, getSy());
      }
      if (hasPrefer()) {
        paramCodedOutputStreamMicro.writeInt32(8, getPrefer());
      }
      localIterator = getViaNameList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(9, (String)localIterator.next());
      }
      if (hasRoutePlanNetMode()) {
        paramCodedOutputStreamMicro.writeInt32(10, getRoutePlanNetMode());
      }
      if (hasLocalInfoUrl()) {
        paramCodedOutputStreamMicro.writeMessage(11, getLocalInfoUrl());
      }
      if (hasIsLongDistance()) {
        paramCodedOutputStreamMicro.writeInt32(12, getIsLongDistance());
      }
      if (hasNaviType()) {
        paramCodedOutputStreamMicro.writeInt32(13, getNaviType());
      }
      if (hasStartBid()) {
        paramCodedOutputStreamMicro.writeString(14, getStartBid());
      }
      localIterator = getEndBidList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(15, (String)localIterator.next());
      }
    }
    
    public static final class End
      extends MessageMicro
    {
      public static final int BUS_STOP_FIELD_NUMBER = 4;
      public static final int BWANDA_FIELD_NUMBER = 6;
      public static final int CITYID_FIELD_NUMBER = 7;
      public static final int CITYNAME_FIELD_NUMBER = 8;
      public static final int PT_FIELD_NUMBER = 1;
      public static final int SPT_FIELD_NUMBER = 5;
      public static final int UID_FIELD_NUMBER = 2;
      public static final int WD_FIELD_NUMBER = 3;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private int h = 0;
      private List<Integer> i = Collections.emptyList();
      private boolean j;
      private int k = 0;
      private boolean l;
      private int m = 0;
      private boolean n;
      private String o = "";
      private int p = -1;
      
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
        clearUid();
        clearWd();
        clearBusStop();
        clearSpt();
        clearBwanda();
        clearCityid();
        clearCityname();
        this.p = -1;
        return this;
      }
      
      public End clearBusStop()
      {
        this.g = false;
        this.h = 0;
        return this;
      }
      
      public End clearBwanda()
      {
        this.j = false;
        this.k = 0;
        return this;
      }
      
      public End clearCityid()
      {
        this.l = false;
        this.m = 0;
        return this;
      }
      
      public End clearCityname()
      {
        this.n = false;
        this.o = "";
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
        this.c = false;
        this.d = "";
        return this;
      }
      
      public End clearWd()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public int getBusStop()
      {
        return this.h;
      }
      
      public int getBwanda()
      {
        return this.k;
      }
      
      public int getCachedSize()
      {
        if (this.p < 0) {
          getSerializedSize();
        }
        return this.p;
      }
      
      public int getCityid()
      {
        return this.m;
      }
      
      public String getCityname()
      {
        return this.o;
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
          if (hasUid()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getUid());
          }
          i2 = i1;
          if (hasWd()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getWd());
          }
          if (hasBusStop()) {}
          for (i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getBusStop());; i1 = i2)
          {
            Iterator localIterator = getSptList().iterator();
            i2 = i3;
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            i2 = i1 + i2 + getSptList().size() * 1;
            i1 = i2;
            if (hasBwanda()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getBwanda());
            }
            i2 = i1;
            if (hasCityid()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getCityid());
            }
            i1 = i2;
            if (hasCityname()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getCityname());
            }
            this.p = i1;
            return i1;
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
        return this.d;
      }
      
      public String getWd()
      {
        return this.f;
      }
      
      public boolean hasBusStop()
      {
        return this.g;
      }
      
      public boolean hasBwanda()
      {
        return this.j;
      }
      
      public boolean hasCityid()
      {
        return this.l;
      }
      
      public boolean hasCityname()
      {
        return this.n;
      }
      
      public boolean hasPt()
      {
        return this.a;
      }
      
      public boolean hasUid()
      {
        return this.c;
      }
      
      public boolean hasWd()
      {
        return this.e;
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
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setWd(paramCodedInputStreamMicro.readString());
            break;
          case 32: 
            setBusStop(paramCodedInputStreamMicro.readInt32());
            break;
          case 40: 
            addSpt(paramCodedInputStreamMicro.readSInt32());
            break;
          case 48: 
            setBwanda(paramCodedInputStreamMicro.readInt32());
            break;
          case 56: 
            setCityid(paramCodedInputStreamMicro.readInt32());
            break;
          case 66: 
            setCityname(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public End setBusStop(int paramInt)
      {
        this.g = true;
        this.h = paramInt;
        return this;
      }
      
      public End setBwanda(int paramInt)
      {
        this.j = true;
        this.k = paramInt;
        return this;
      }
      
      public End setCityid(int paramInt)
      {
        this.l = true;
        this.m = paramInt;
        return this;
      }
      
      public End setCityname(String paramString)
      {
        this.n = true;
        this.o = paramString;
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
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public End setWd(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasPt()) {
          paramCodedOutputStreamMicro.writeString(1, getPt());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(2, getUid());
        }
        if (hasWd()) {
          paramCodedOutputStreamMicro.writeString(3, getWd());
        }
        if (hasBusStop()) {
          paramCodedOutputStreamMicro.writeInt32(4, getBusStop());
        }
        Iterator localIterator = getSptList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(5, ((Integer)localIterator.next()).intValue());
        }
        if (hasBwanda()) {
          paramCodedOutputStreamMicro.writeInt32(6, getBwanda());
        }
        if (hasCityid()) {
          paramCodedOutputStreamMicro.writeInt32(7, getCityid());
        }
        if (hasCityname()) {
          paramCodedOutputStreamMicro.writeString(8, getCityname());
        }
      }
    }
    
    public static final class LocalInfoUrl
      extends MessageMicro
    {
      public static final int URL_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private int c = -1;
      
      public static LocalInfoUrl parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new LocalInfoUrl().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static LocalInfoUrl parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (LocalInfoUrl)new LocalInfoUrl().mergeFrom(paramArrayOfByte);
      }
      
      public final LocalInfoUrl clear()
      {
        clearUrl();
        this.c = -1;
        return this;
      }
      
      public LocalInfoUrl clearUrl()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.c < 0) {
          getSerializedSize();
        }
        return this.c;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasUrl()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
        }
        this.c = i;
        return i;
      }
      
      public String getUrl()
      {
        return this.b;
      }
      
      public boolean hasUrl()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public LocalInfoUrl mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          }
        }
      }
      
      public LocalInfoUrl setUrl(String paramString)
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
      }
    }
    
    public static final class Start
      extends MessageMicro
    {
      public static final int BUS_STOP_FIELD_NUMBER = 4;
      public static final int CITYID_FIELD_NUMBER = 6;
      public static final int CITYNAME_FIELD_NUMBER = 7;
      public static final int PT_FIELD_NUMBER = 1;
      public static final int SPT_FIELD_NUMBER = 5;
      public static final int UID_FIELD_NUMBER = 2;
      public static final int WD_FIELD_NUMBER = 3;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private int h = 0;
      private List<Integer> i = Collections.emptyList();
      private boolean j;
      private int k = 0;
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
        clearUid();
        clearWd();
        clearBusStop();
        clearSpt();
        clearCityid();
        clearCityname();
        this.n = -1;
        return this;
      }
      
      public Start clearBusStop()
      {
        this.g = false;
        this.h = 0;
        return this;
      }
      
      public Start clearCityid()
      {
        this.j = false;
        this.k = 0;
        return this;
      }
      
      public Start clearCityname()
      {
        this.l = false;
        this.m = "";
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
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Start clearWd()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public int getBusStop()
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
      
      public int getCityid()
      {
        return this.k;
      }
      
      public String getCityname()
      {
        return this.m;
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
          if (hasUid()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getUid());
          }
          i2 = i1;
          if (hasWd()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getWd());
          }
          if (hasBusStop()) {}
          for (i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getBusStop());; i1 = i2)
          {
            Iterator localIterator = getSptList().iterator();
            i2 = i3;
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
            }
            i2 = i1 + i2 + getSptList().size() * 1;
            i1 = i2;
            if (hasCityid()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getCityid());
            }
            i2 = i1;
            if (hasCityname()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getCityname());
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
        return this.d;
      }
      
      public String getWd()
      {
        return this.f;
      }
      
      public boolean hasBusStop()
      {
        return this.g;
      }
      
      public boolean hasCityid()
      {
        return this.j;
      }
      
      public boolean hasCityname()
      {
        return this.l;
      }
      
      public boolean hasPt()
      {
        return this.a;
      }
      
      public boolean hasUid()
      {
        return this.c;
      }
      
      public boolean hasWd()
      {
        return this.e;
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
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setWd(paramCodedInputStreamMicro.readString());
            break;
          case 32: 
            setBusStop(paramCodedInputStreamMicro.readInt32());
            break;
          case 40: 
            addSpt(paramCodedInputStreamMicro.readSInt32());
            break;
          case 48: 
            setCityid(paramCodedInputStreamMicro.readInt32());
            break;
          case 58: 
            setCityname(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Start setBusStop(int paramInt)
      {
        this.g = true;
        this.h = paramInt;
        return this;
      }
      
      public Start setCityid(int paramInt)
      {
        this.j = true;
        this.k = paramInt;
        return this;
      }
      
      public Start setCityname(String paramString)
      {
        this.l = true;
        this.m = paramString;
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
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Start setWd(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasPt()) {
          paramCodedOutputStreamMicro.writeString(1, getPt());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(2, getUid());
        }
        if (hasWd()) {
          paramCodedOutputStreamMicro.writeString(3, getWd());
        }
        if (hasBusStop()) {
          paramCodedOutputStreamMicro.writeInt32(4, getBusStop());
        }
        Iterator localIterator = getSptList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeSInt32(5, ((Integer)localIterator.next()).intValue());
        }
        if (hasCityid()) {
          paramCodedOutputStreamMicro.writeInt32(6, getCityid());
        }
        if (hasCityname()) {
          paramCodedOutputStreamMicro.writeString(7, getCityname());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Cars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */