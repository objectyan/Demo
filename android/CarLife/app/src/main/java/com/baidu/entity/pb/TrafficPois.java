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

public final class TrafficPois
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 3;
  public static final int CURRENT_CITY_FIELD_NUMBER = 2;
  public static final int IMGE_SHOW_FIELD_NUMBER = 6;
  public static final int OPTION_FIELD_NUMBER = 1;
  public static final int SUGGEST_QUERY_FIELD_NUMBER = 4;
  public static final int SUGGEST_QUERY_FLAG_FIELD_NUMBER = 5;
  private boolean a;
  private Option b = null;
  private boolean c;
  private CurrentCity d = null;
  private boolean e;
  private Content f = null;
  private List<SuggestQuery> g = Collections.emptyList();
  private boolean h;
  private int i = 0;
  private boolean j;
  private ImageShow k = null;
  private int l = -1;
  
  public static TrafficPois parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrafficPois().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrafficPois parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrafficPois)new TrafficPois().mergeFrom(paramArrayOfByte);
  }
  
  public TrafficPois addSuggestQuery(SuggestQuery paramSuggestQuery)
  {
    if (paramSuggestQuery == null) {
      return this;
    }
    if (this.g.isEmpty()) {
      this.g = new ArrayList();
    }
    this.g.add(paramSuggestQuery);
    return this;
  }
  
  public final TrafficPois clear()
  {
    clearOption();
    clearCurrentCity();
    clearContent();
    clearSuggestQuery();
    clearSuggestQueryFlag();
    clearImgeShow();
    this.l = -1;
    return this;
  }
  
  public TrafficPois clearContent()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public TrafficPois clearCurrentCity()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public TrafficPois clearImgeShow()
  {
    this.j = false;
    this.k = null;
    return this;
  }
  
  public TrafficPois clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public TrafficPois clearSuggestQuery()
  {
    this.g = Collections.emptyList();
    return this;
  }
  
  public TrafficPois clearSuggestQueryFlag()
  {
    this.h = false;
    this.i = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.l < 0) {
      getSerializedSize();
    }
    return this.l;
  }
  
  public Content getContent()
  {
    return this.f;
  }
  
  public CurrentCity getCurrentCity()
  {
    return this.d;
  }
  
  public ImageShow getImgeShow()
  {
    return this.k;
  }
  
  public Option getOption()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int n = 0;
    if (hasOption()) {
      n = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    int m = n;
    if (hasCurrentCity()) {
      m = n + CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
    }
    n = m;
    if (hasContent()) {
      n = m + CodedOutputStreamMicro.computeMessageSize(3, getContent());
    }
    Iterator localIterator = getSuggestQueryList().iterator();
    while (localIterator.hasNext()) {
      n = CodedOutputStreamMicro.computeMessageSize(4, (SuggestQuery)localIterator.next()) + n;
    }
    m = n;
    if (hasSuggestQueryFlag()) {
      m = n + CodedOutputStreamMicro.computeInt32Size(5, getSuggestQueryFlag());
    }
    n = m;
    if (hasImgeShow()) {
      n = m + CodedOutputStreamMicro.computeMessageSize(6, getImgeShow());
    }
    this.l = n;
    return n;
  }
  
  public SuggestQuery getSuggestQuery(int paramInt)
  {
    return (SuggestQuery)this.g.get(paramInt);
  }
  
  public int getSuggestQueryCount()
  {
    return this.g.size();
  }
  
  public int getSuggestQueryFlag()
  {
    return this.i;
  }
  
  public List<SuggestQuery> getSuggestQueryList()
  {
    return this.g;
  }
  
  public boolean hasContent()
  {
    return this.e;
  }
  
  public boolean hasCurrentCity()
  {
    return this.c;
  }
  
  public boolean hasImgeShow()
  {
    return this.j;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public boolean hasSuggestQueryFlag()
  {
    return this.h;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrafficPois mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setContent((Content)localObject);
        break;
      case 34: 
        localObject = new SuggestQuery();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addSuggestQuery((SuggestQuery)localObject);
        break;
      case 40: 
        setSuggestQueryFlag(paramCodedInputStreamMicro.readInt32());
        break;
      case 50: 
        localObject = new ImageShow();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setImgeShow((ImageShow)localObject);
      }
    }
  }
  
  public TrafficPois setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.e = true;
    this.f = paramContent;
    return this;
  }
  
  public TrafficPois setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.c = true;
    this.d = paramCurrentCity;
    return this;
  }
  
  public TrafficPois setImgeShow(ImageShow paramImageShow)
  {
    if (paramImageShow == null) {
      return clearImgeShow();
    }
    this.j = true;
    this.k = paramImageShow;
    return this;
  }
  
  public TrafficPois setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.a = true;
    this.b = paramOption;
    return this;
  }
  
  public TrafficPois setSuggestQuery(int paramInt, SuggestQuery paramSuggestQuery)
  {
    if (paramSuggestQuery == null) {
      return this;
    }
    this.g.set(paramInt, paramSuggestQuery);
    return this;
  }
  
  public TrafficPois setSuggestQueryFlag(int paramInt)
  {
    this.h = true;
    this.i = paramInt;
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
    if (hasContent()) {
      paramCodedOutputStreamMicro.writeMessage(3, getContent());
    }
    Iterator localIterator = getSuggestQueryList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(4, (SuggestQuery)localIterator.next());
    }
    if (hasSuggestQueryFlag()) {
      paramCodedOutputStreamMicro.writeInt32(5, getSuggestQueryFlag());
    }
    if (hasImgeShow()) {
      paramCodedOutputStreamMicro.writeMessage(6, getImgeShow());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int END_FIELD_NUMBER = 2;
    public static final int MULTI_WAYPOINTS_FIELD_NUMBER = 4;
    public static final int START_FIELD_NUMBER = 1;
    public static final int WAY_POINTS_FIELD_NUMBER = 3;
    private List<Start> a = Collections.emptyList();
    private List<End> b = Collections.emptyList();
    private List<WayPoints> c = Collections.emptyList();
    private List<MultiWaypoints> d = Collections.emptyList();
    private int e = -1;
    
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
    
    public Content addEnd(End paramEnd)
    {
      if (paramEnd == null) {
        return this;
      }
      if (this.b.isEmpty()) {
        this.b = new ArrayList();
      }
      this.b.add(paramEnd);
      return this;
    }
    
    public Content addMultiWaypoints(MultiWaypoints paramMultiWaypoints)
    {
      if (paramMultiWaypoints == null) {
        return this;
      }
      if (this.d.isEmpty()) {
        this.d = new ArrayList();
      }
      this.d.add(paramMultiWaypoints);
      return this;
    }
    
    public Content addStart(Start paramStart)
    {
      if (paramStart == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramStart);
      return this;
    }
    
    public Content addWayPoints(WayPoints paramWayPoints)
    {
      if (paramWayPoints == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramWayPoints);
      return this;
    }
    
    public final Content clear()
    {
      clearStart();
      clearEnd();
      clearWayPoints();
      clearMultiWaypoints();
      this.e = -1;
      return this;
    }
    
    public Content clearEnd()
    {
      this.b = Collections.emptyList();
      return this;
    }
    
    public Content clearMultiWaypoints()
    {
      this.d = Collections.emptyList();
      return this;
    }
    
    public Content clearStart()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Content clearWayPoints()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public End getEnd(int paramInt)
    {
      return (End)this.b.get(paramInt);
    }
    
    public int getEndCount()
    {
      return this.b.size();
    }
    
    public List<End> getEndList()
    {
      return this.b;
    }
    
    public MultiWaypoints getMultiWaypoints(int paramInt)
    {
      return (MultiWaypoints)this.d.get(paramInt);
    }
    
    public int getMultiWaypointsCount()
    {
      return this.d.size();
    }
    
    public List<MultiWaypoints> getMultiWaypointsList()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getStartList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Start)localIterator.next()) + i) {}
      localIterator = getEndList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStreamMicro.computeMessageSize(2, (End)localIterator.next());
      }
      localIterator = getWayPointsList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStreamMicro.computeMessageSize(3, (WayPoints)localIterator.next());
      }
      localIterator = getMultiWaypointsList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStreamMicro.computeMessageSize(4, (MultiWaypoints)localIterator.next());
      }
      this.e = i;
      return i;
    }
    
    public Start getStart(int paramInt)
    {
      return (Start)this.a.get(paramInt);
    }
    
    public int getStartCount()
    {
      return this.a.size();
    }
    
    public List<Start> getStartList()
    {
      return this.a;
    }
    
    public WayPoints getWayPoints(int paramInt)
    {
      return (WayPoints)this.c.get(paramInt);
    }
    
    public int getWayPointsCount()
    {
      return this.c.size();
    }
    
    public List<WayPoints> getWayPointsList()
    {
      return this.c;
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
          localObject = new Start();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addStart((Start)localObject);
          break;
        case 18: 
          localObject = new End();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addEnd((End)localObject);
          break;
        case 26: 
          localObject = new WayPoints();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addWayPoints((WayPoints)localObject);
          break;
        case 34: 
          localObject = new MultiWaypoints();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addMultiWaypoints((MultiWaypoints)localObject);
        }
      }
    }
    
    public Content setEnd(int paramInt, End paramEnd)
    {
      if (paramEnd == null) {
        return this;
      }
      this.b.set(paramInt, paramEnd);
      return this;
    }
    
    public Content setMultiWaypoints(int paramInt, MultiWaypoints paramMultiWaypoints)
    {
      if (paramMultiWaypoints == null) {
        return this;
      }
      this.d.set(paramInt, paramMultiWaypoints);
      return this;
    }
    
    public Content setStart(int paramInt, Start paramStart)
    {
      if (paramStart == null) {
        return this;
      }
      this.a.set(paramInt, paramStart);
      return this;
    }
    
    public Content setWayPoints(int paramInt, WayPoints paramWayPoints)
    {
      if (paramWayPoints == null) {
        return this;
      }
      this.c.set(paramInt, paramWayPoints);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getStartList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Start)localIterator.next());
      }
      localIterator = getEndList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (End)localIterator.next());
      }
      localIterator = getWayPointsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (WayPoints)localIterator.next());
      }
      localIterator = getMultiWaypointsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(4, (MultiWaypoints)localIterator.next());
      }
    }
    
    public static final class End
      extends MessageMicro
    {
      public static final int ADDR_FIELD_NUMBER = 5;
      public static final int CODE_FIELD_NUMBER = 1;
      public static final int DESCRIBE_FIELD_NUMBER = 13;
      public static final int DIRECTION_FIELD_NUMBER = 12;
      public static final int DIST_FIELD_NUMBER = 11;
      public static final int EXT_FIELD_NUMBER = 7;
      public static final int GEO_FIELD_NUMBER = 6;
      public static final int INDOOR_FLOOR_FIELD_NUMBER = 9;
      public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 10;
      public static final int NAME_FIELD_NUMBER = 2;
      public static final int NUM_FIELD_NUMBER = 3;
      public static final int POITYPE_FIELD_NUMBER = 8;
      public static final int UID_FIELD_NUMBER = 4;
      private int A = -1;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private boolean e;
      private int f = 0;
      private boolean g;
      private String h = "";
      private boolean i;
      private String j = "";
      private boolean k;
      private String l = "";
      private boolean m;
      private String n = "";
      private boolean o;
      private int p = 0;
      private boolean q;
      private String r = "";
      private boolean s;
      private String t = "";
      private boolean u;
      private int v = 0;
      private boolean w;
      private int x = 0;
      private boolean y;
      private String z = "";
      
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
      
      public final End clear()
      {
        clearCode();
        clearName();
        clearNum();
        clearUid();
        clearAddr();
        clearGeo();
        clearExt();
        clearPoiType();
        clearIndoorFloor();
        clearIndoorParentUid();
        clearDist();
        clearDirection();
        clearDescribe();
        this.A = -1;
        return this;
      }
      
      public End clearAddr()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public End clearCode()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public End clearDescribe()
      {
        this.y = false;
        this.z = "";
        return this;
      }
      
      public End clearDirection()
      {
        this.w = false;
        this.x = 0;
        return this;
      }
      
      public End clearDist()
      {
        this.u = false;
        this.v = 0;
        return this;
      }
      
      public End clearExt()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public End clearGeo()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public End clearIndoorFloor()
      {
        this.q = false;
        this.r = "";
        return this;
      }
      
      public End clearIndoorParentUid()
      {
        this.s = false;
        this.t = "";
        return this;
      }
      
      public End clearName()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public End clearNum()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public End clearPoiType()
      {
        this.o = false;
        this.p = 0;
        return this;
      }
      
      public End clearUid()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public String getAddr()
      {
        return this.j;
      }
      
      public int getCachedSize()
      {
        if (this.A < 0) {
          getSerializedSize();
        }
        return this.A;
      }
      
      public int getCode()
      {
        return this.b;
      }
      
      public String getDescribe()
      {
        return this.z;
      }
      
      public int getDirection()
      {
        return this.x;
      }
      
      public int getDist()
      {
        return this.v;
      }
      
      public String getExt()
      {
        return this.n;
      }
      
      public String getGeo()
      {
        return this.l;
      }
      
      public String getIndoorFloor()
      {
        return this.r;
      }
      
      public String getIndoorParentUid()
      {
        return this.t;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public int getNum()
      {
        return this.f;
      }
      
      public int getPoiType()
      {
        return this.p;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasCode()) {
          i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        int i1 = i2;
        if (hasName()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        i2 = i1;
        if (hasNum()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getNum());
        }
        i1 = i2;
        if (hasUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getUid());
        }
        i2 = i1;
        if (hasAddr()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getAddr());
        }
        i1 = i2;
        if (hasGeo()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getGeo());
        }
        i2 = i1;
        if (hasExt()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getExt());
        }
        i1 = i2;
        if (hasPoiType()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getPoiType());
        }
        i2 = i1;
        if (hasIndoorFloor()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getIndoorFloor());
        }
        i1 = i2;
        if (hasIndoorParentUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getIndoorParentUid());
        }
        i2 = i1;
        if (hasDist()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getDist());
        }
        i1 = i2;
        if (hasDirection()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getDirection());
        }
        i2 = i1;
        if (hasDescribe()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getDescribe());
        }
        this.A = i2;
        return i2;
      }
      
      public String getUid()
      {
        return this.h;
      }
      
      public boolean hasAddr()
      {
        return this.i;
      }
      
      public boolean hasCode()
      {
        return this.a;
      }
      
      public boolean hasDescribe()
      {
        return this.y;
      }
      
      public boolean hasDirection()
      {
        return this.w;
      }
      
      public boolean hasDist()
      {
        return this.u;
      }
      
      public boolean hasExt()
      {
        return this.m;
      }
      
      public boolean hasGeo()
      {
        return this.k;
      }
      
      public boolean hasIndoorFloor()
      {
        return this.q;
      }
      
      public boolean hasIndoorParentUid()
      {
        return this.s;
      }
      
      public boolean hasName()
      {
        return this.c;
      }
      
      public boolean hasNum()
      {
        return this.e;
      }
      
      public boolean hasPoiType()
      {
        return this.o;
      }
      
      public boolean hasUid()
      {
        return this.g;
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
          case 8: 
            setCode(paramCodedInputStreamMicro.readInt32());
            break;
          case 18: 
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 24: 
            setNum(paramCodedInputStreamMicro.readInt32());
            break;
          case 34: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setAddr(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setGeo(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setExt(paramCodedInputStreamMicro.readString());
            break;
          case 64: 
            setPoiType(paramCodedInputStreamMicro.readInt32());
            break;
          case 74: 
            setIndoorFloor(paramCodedInputStreamMicro.readString());
            break;
          case 82: 
            setIndoorParentUid(paramCodedInputStreamMicro.readString());
            break;
          case 88: 
            setDist(paramCodedInputStreamMicro.readInt32());
            break;
          case 96: 
            setDirection(paramCodedInputStreamMicro.readInt32());
            break;
          case 106: 
            setDescribe(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public End setAddr(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public End setCode(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public End setDescribe(String paramString)
      {
        this.y = true;
        this.z = paramString;
        return this;
      }
      
      public End setDirection(int paramInt)
      {
        this.w = true;
        this.x = paramInt;
        return this;
      }
      
      public End setDist(int paramInt)
      {
        this.u = true;
        this.v = paramInt;
        return this;
      }
      
      public End setExt(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public End setGeo(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public End setIndoorFloor(String paramString)
      {
        this.q = true;
        this.r = paramString;
        return this;
      }
      
      public End setIndoorParentUid(String paramString)
      {
        this.s = true;
        this.t = paramString;
        return this;
      }
      
      public End setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public End setNum(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public End setPoiType(int paramInt)
      {
        this.o = true;
        this.p = paramInt;
        return this;
      }
      
      public End setUid(String paramString)
      {
        this.g = true;
        this.h = paramString;
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
        if (hasNum()) {
          paramCodedOutputStreamMicro.writeInt32(3, getNum());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(4, getUid());
        }
        if (hasAddr()) {
          paramCodedOutputStreamMicro.writeString(5, getAddr());
        }
        if (hasGeo()) {
          paramCodedOutputStreamMicro.writeString(6, getGeo());
        }
        if (hasExt()) {
          paramCodedOutputStreamMicro.writeString(7, getExt());
        }
        if (hasPoiType()) {
          paramCodedOutputStreamMicro.writeInt32(8, getPoiType());
        }
        if (hasIndoorFloor()) {
          paramCodedOutputStreamMicro.writeString(9, getIndoorFloor());
        }
        if (hasIndoorParentUid()) {
          paramCodedOutputStreamMicro.writeString(10, getIndoorParentUid());
        }
        if (hasDist()) {
          paramCodedOutputStreamMicro.writeInt32(11, getDist());
        }
        if (hasDirection()) {
          paramCodedOutputStreamMicro.writeInt32(12, getDirection());
        }
        if (hasDescribe()) {
          paramCodedOutputStreamMicro.writeString(13, getDescribe());
        }
      }
    }
    
    public static final class MultiWaypoints
      extends MessageMicro
    {
      public static final int WAY_POINTS_FIELD_NUMBER = 1;
      private List<WayPoints> a = Collections.emptyList();
      private int b = -1;
      
      public static MultiWaypoints parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new MultiWaypoints().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static MultiWaypoints parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (MultiWaypoints)new MultiWaypoints().mergeFrom(paramArrayOfByte);
      }
      
      public MultiWaypoints addWayPoints(WayPoints paramWayPoints)
      {
        if (paramWayPoints == null) {
          return this;
        }
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(paramWayPoints);
        return this;
      }
      
      public final MultiWaypoints clear()
      {
        clearWayPoints();
        this.b = -1;
        return this;
      }
      
      public MultiWaypoints clearWayPoints()
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
        Iterator localIterator = getWayPointsList().iterator();
        for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (WayPoints)localIterator.next()) + i) {}
        this.b = i;
        return i;
      }
      
      public WayPoints getWayPoints(int paramInt)
      {
        return (WayPoints)this.a.get(paramInt);
      }
      
      public int getWayPointsCount()
      {
        return this.a.size();
      }
      
      public List<WayPoints> getWayPointsList()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public MultiWaypoints mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            WayPoints localWayPoints = new WayPoints();
            paramCodedInputStreamMicro.readMessage(localWayPoints);
            addWayPoints(localWayPoints);
          }
        }
      }
      
      public MultiWaypoints setWayPoints(int paramInt, WayPoints paramWayPoints)
      {
        if (paramWayPoints == null) {
          return this;
        }
        this.a.set(paramInt, paramWayPoints);
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getWayPointsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(1, (WayPoints)localIterator.next());
        }
      }
      
      public static final class WayPoints
        extends MessageMicro
      {
        public static final int ADDR_FIELD_NUMBER = 5;
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int GEO_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NUM_FIELD_NUMBER = 3;
        public static final int UID_FIELD_NUMBER = 4;
        private boolean a;
        private int b = 0;
        private boolean c;
        private String d = "";
        private boolean e;
        private int f = 0;
        private boolean g;
        private String h = "";
        private boolean i;
        private String j = "";
        private boolean k;
        private String l = "";
        private int m = -1;
        
        public static WayPoints parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new WayPoints().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static WayPoints parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (WayPoints)new WayPoints().mergeFrom(paramArrayOfByte);
        }
        
        public final WayPoints clear()
        {
          clearCode();
          clearName();
          clearNum();
          clearUid();
          clearAddr();
          clearGeo();
          this.m = -1;
          return this;
        }
        
        public WayPoints clearAddr()
        {
          this.i = false;
          this.j = "";
          return this;
        }
        
        public WayPoints clearCode()
        {
          this.a = false;
          this.b = 0;
          return this;
        }
        
        public WayPoints clearGeo()
        {
          this.k = false;
          this.l = "";
          return this;
        }
        
        public WayPoints clearName()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public WayPoints clearNum()
        {
          this.e = false;
          this.f = 0;
          return this;
        }
        
        public WayPoints clearUid()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public String getAddr()
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
        
        public int getCode()
        {
          return this.b;
        }
        
        public String getGeo()
        {
          return this.l;
        }
        
        public String getName()
        {
          return this.d;
        }
        
        public int getNum()
        {
          return this.f;
        }
        
        public int getSerializedSize()
        {
          int i1 = 0;
          if (hasCode()) {
            i1 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
          }
          int n = i1;
          if (hasName()) {
            n = i1 + CodedOutputStreamMicro.computeStringSize(2, getName());
          }
          i1 = n;
          if (hasNum()) {
            i1 = n + CodedOutputStreamMicro.computeInt32Size(3, getNum());
          }
          n = i1;
          if (hasUid()) {
            n = i1 + CodedOutputStreamMicro.computeStringSize(4, getUid());
          }
          i1 = n;
          if (hasAddr()) {
            i1 = n + CodedOutputStreamMicro.computeStringSize(5, getAddr());
          }
          n = i1;
          if (hasGeo()) {
            n = i1 + CodedOutputStreamMicro.computeStringSize(6, getGeo());
          }
          this.m = n;
          return n;
        }
        
        public String getUid()
        {
          return this.h;
        }
        
        public boolean hasAddr()
        {
          return this.i;
        }
        
        public boolean hasCode()
        {
          return this.a;
        }
        
        public boolean hasGeo()
        {
          return this.k;
        }
        
        public boolean hasName()
        {
          return this.c;
        }
        
        public boolean hasNum()
        {
          return this.e;
        }
        
        public boolean hasUid()
        {
          return this.g;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public WayPoints mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setCode(paramCodedInputStreamMicro.readInt32());
              break;
            case 18: 
              setName(paramCodedInputStreamMicro.readString());
              break;
            case 24: 
              setNum(paramCodedInputStreamMicro.readInt32());
              break;
            case 34: 
              setUid(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              setAddr(paramCodedInputStreamMicro.readString());
              break;
            case 50: 
              setGeo(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public WayPoints setAddr(String paramString)
        {
          this.i = true;
          this.j = paramString;
          return this;
        }
        
        public WayPoints setCode(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public WayPoints setGeo(String paramString)
        {
          this.k = true;
          this.l = paramString;
          return this;
        }
        
        public WayPoints setName(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public WayPoints setNum(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
          return this;
        }
        
        public WayPoints setUid(String paramString)
        {
          this.g = true;
          this.h = paramString;
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
          if (hasNum()) {
            paramCodedOutputStreamMicro.writeInt32(3, getNum());
          }
          if (hasUid()) {
            paramCodedOutputStreamMicro.writeString(4, getUid());
          }
          if (hasAddr()) {
            paramCodedOutputStreamMicro.writeString(5, getAddr());
          }
          if (hasGeo()) {
            paramCodedOutputStreamMicro.writeString(6, getGeo());
          }
        }
      }
    }
    
    public static final class Start
      extends MessageMicro
    {
      public static final int ADDR_FIELD_NUMBER = 5;
      public static final int CODE_FIELD_NUMBER = 1;
      public static final int DESCRIBE_FIELD_NUMBER = 9;
      public static final int GEO_FIELD_NUMBER = 6;
      public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
      public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
      public static final int NAME_FIELD_NUMBER = 2;
      public static final int NUM_FIELD_NUMBER = 3;
      public static final int UID_FIELD_NUMBER = 4;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private boolean e;
      private int f = 0;
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
      
      public final Start clear()
      {
        clearCode();
        clearName();
        clearNum();
        clearUid();
        clearAddr();
        clearGeo();
        clearIndoorFloor();
        clearIndoorParentUid();
        clearDescribe();
        this.s = -1;
        return this;
      }
      
      public Start clearAddr()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public Start clearCode()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public Start clearDescribe()
      {
        this.q = false;
        this.r = "";
        return this;
      }
      
      public Start clearGeo()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public Start clearIndoorFloor()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public Start clearIndoorParentUid()
      {
        this.o = false;
        this.p = "";
        return this;
      }
      
      public Start clearName()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Start clearNum()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public Start clearUid()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public String getAddr()
      {
        return this.j;
      }
      
      public int getCachedSize()
      {
        if (this.s < 0) {
          getSerializedSize();
        }
        return this.s;
      }
      
      public int getCode()
      {
        return this.b;
      }
      
      public String getDescribe()
      {
        return this.r;
      }
      
      public String getGeo()
      {
        return this.l;
      }
      
      public String getIndoorFloor()
      {
        return this.n;
      }
      
      public String getIndoorParentUid()
      {
        return this.p;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public int getNum()
      {
        return this.f;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasCode()) {
          i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        int i1 = i2;
        if (hasName()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        i2 = i1;
        if (hasNum()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getNum());
        }
        i1 = i2;
        if (hasUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getUid());
        }
        i2 = i1;
        if (hasAddr()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getAddr());
        }
        i1 = i2;
        if (hasGeo()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getGeo());
        }
        i2 = i1;
        if (hasIndoorFloor()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getIndoorFloor());
        }
        i1 = i2;
        if (hasIndoorParentUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getIndoorParentUid());
        }
        i2 = i1;
        if (hasDescribe()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getDescribe());
        }
        this.s = i2;
        return i2;
      }
      
      public String getUid()
      {
        return this.h;
      }
      
      public boolean hasAddr()
      {
        return this.i;
      }
      
      public boolean hasCode()
      {
        return this.a;
      }
      
      public boolean hasDescribe()
      {
        return this.q;
      }
      
      public boolean hasGeo()
      {
        return this.k;
      }
      
      public boolean hasIndoorFloor()
      {
        return this.m;
      }
      
      public boolean hasIndoorParentUid()
      {
        return this.o;
      }
      
      public boolean hasName()
      {
        return this.c;
      }
      
      public boolean hasNum()
      {
        return this.e;
      }
      
      public boolean hasUid()
      {
        return this.g;
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
          case 8: 
            setCode(paramCodedInputStreamMicro.readInt32());
            break;
          case 18: 
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 24: 
            setNum(paramCodedInputStreamMicro.readInt32());
            break;
          case 34: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setAddr(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setGeo(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setIndoorFloor(paramCodedInputStreamMicro.readString());
            break;
          case 66: 
            setIndoorParentUid(paramCodedInputStreamMicro.readString());
            break;
          case 74: 
            setDescribe(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Start setAddr(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public Start setCode(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public Start setDescribe(String paramString)
      {
        this.q = true;
        this.r = paramString;
        return this;
      }
      
      public Start setGeo(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public Start setIndoorFloor(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public Start setIndoorParentUid(String paramString)
      {
        this.o = true;
        this.p = paramString;
        return this;
      }
      
      public Start setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Start setNum(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public Start setUid(String paramString)
      {
        this.g = true;
        this.h = paramString;
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
        if (hasNum()) {
          paramCodedOutputStreamMicro.writeInt32(3, getNum());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(4, getUid());
        }
        if (hasAddr()) {
          paramCodedOutputStreamMicro.writeString(5, getAddr());
        }
        if (hasGeo()) {
          paramCodedOutputStreamMicro.writeString(6, getGeo());
        }
        if (hasIndoorFloor()) {
          paramCodedOutputStreamMicro.writeString(7, getIndoorFloor());
        }
        if (hasIndoorParentUid()) {
          paramCodedOutputStreamMicro.writeString(8, getIndoorParentUid());
        }
        if (hasDescribe()) {
          paramCodedOutputStreamMicro.writeString(9, getDescribe());
        }
      }
    }
    
    public static final class WayPoints
      extends MessageMicro
    {
      public static final int ADDR_FIELD_NUMBER = 5;
      public static final int CODE_FIELD_NUMBER = 1;
      public static final int DESCRIBE_FIELD_NUMBER = 11;
      public static final int DIRECTION_FIELD_NUMBER = 10;
      public static final int DIST_FIELD_NUMBER = 9;
      public static final int GEO_FIELD_NUMBER = 6;
      public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
      public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
      public static final int NAME_FIELD_NUMBER = 2;
      public static final int NUM_FIELD_NUMBER = 3;
      public static final int UID_FIELD_NUMBER = 4;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private boolean e;
      private int f = 0;
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
      private int r = 0;
      private boolean s;
      private int t = 0;
      private boolean u;
      private String v = "";
      private int w = -1;
      
      public static WayPoints parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new WayPoints().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static WayPoints parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (WayPoints)new WayPoints().mergeFrom(paramArrayOfByte);
      }
      
      public final WayPoints clear()
      {
        clearCode();
        clearName();
        clearNum();
        clearUid();
        clearAddr();
        clearGeo();
        clearIndoorFloor();
        clearIndoorParentUid();
        clearDist();
        clearDirection();
        clearDescribe();
        this.w = -1;
        return this;
      }
      
      public WayPoints clearAddr()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public WayPoints clearCode()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public WayPoints clearDescribe()
      {
        this.u = false;
        this.v = "";
        return this;
      }
      
      public WayPoints clearDirection()
      {
        this.s = false;
        this.t = 0;
        return this;
      }
      
      public WayPoints clearDist()
      {
        this.q = false;
        this.r = 0;
        return this;
      }
      
      public WayPoints clearGeo()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public WayPoints clearIndoorFloor()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public WayPoints clearIndoorParentUid()
      {
        this.o = false;
        this.p = "";
        return this;
      }
      
      public WayPoints clearName()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public WayPoints clearNum()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public WayPoints clearUid()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public String getAddr()
      {
        return this.j;
      }
      
      public int getCachedSize()
      {
        if (this.w < 0) {
          getSerializedSize();
        }
        return this.w;
      }
      
      public int getCode()
      {
        return this.b;
      }
      
      public String getDescribe()
      {
        return this.v;
      }
      
      public int getDirection()
      {
        return this.t;
      }
      
      public int getDist()
      {
        return this.r;
      }
      
      public String getGeo()
      {
        return this.l;
      }
      
      public String getIndoorFloor()
      {
        return this.n;
      }
      
      public String getIndoorParentUid()
      {
        return this.p;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public int getNum()
      {
        return this.f;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasCode()) {
          i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        int i1 = i2;
        if (hasName()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        i2 = i1;
        if (hasNum()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getNum());
        }
        i1 = i2;
        if (hasUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getUid());
        }
        i2 = i1;
        if (hasAddr()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getAddr());
        }
        i1 = i2;
        if (hasGeo()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getGeo());
        }
        i2 = i1;
        if (hasIndoorFloor()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getIndoorFloor());
        }
        i1 = i2;
        if (hasIndoorParentUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getIndoorParentUid());
        }
        i2 = i1;
        if (hasDist()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getDist());
        }
        i1 = i2;
        if (hasDirection()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getDirection());
        }
        i2 = i1;
        if (hasDescribe()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getDescribe());
        }
        this.w = i2;
        return i2;
      }
      
      public String getUid()
      {
        return this.h;
      }
      
      public boolean hasAddr()
      {
        return this.i;
      }
      
      public boolean hasCode()
      {
        return this.a;
      }
      
      public boolean hasDescribe()
      {
        return this.u;
      }
      
      public boolean hasDirection()
      {
        return this.s;
      }
      
      public boolean hasDist()
      {
        return this.q;
      }
      
      public boolean hasGeo()
      {
        return this.k;
      }
      
      public boolean hasIndoorFloor()
      {
        return this.m;
      }
      
      public boolean hasIndoorParentUid()
      {
        return this.o;
      }
      
      public boolean hasName()
      {
        return this.c;
      }
      
      public boolean hasNum()
      {
        return this.e;
      }
      
      public boolean hasUid()
      {
        return this.g;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public WayPoints mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 24: 
            setNum(paramCodedInputStreamMicro.readInt32());
            break;
          case 34: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setAddr(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setGeo(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setIndoorFloor(paramCodedInputStreamMicro.readString());
            break;
          case 66: 
            setIndoorParentUid(paramCodedInputStreamMicro.readString());
            break;
          case 72: 
            setDist(paramCodedInputStreamMicro.readInt32());
            break;
          case 80: 
            setDirection(paramCodedInputStreamMicro.readInt32());
            break;
          case 90: 
            setDescribe(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public WayPoints setAddr(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public WayPoints setCode(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public WayPoints setDescribe(String paramString)
      {
        this.u = true;
        this.v = paramString;
        return this;
      }
      
      public WayPoints setDirection(int paramInt)
      {
        this.s = true;
        this.t = paramInt;
        return this;
      }
      
      public WayPoints setDist(int paramInt)
      {
        this.q = true;
        this.r = paramInt;
        return this;
      }
      
      public WayPoints setGeo(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public WayPoints setIndoorFloor(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public WayPoints setIndoorParentUid(String paramString)
      {
        this.o = true;
        this.p = paramString;
        return this;
      }
      
      public WayPoints setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public WayPoints setNum(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public WayPoints setUid(String paramString)
      {
        this.g = true;
        this.h = paramString;
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
        if (hasNum()) {
          paramCodedOutputStreamMicro.writeInt32(3, getNum());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(4, getUid());
        }
        if (hasAddr()) {
          paramCodedOutputStreamMicro.writeString(5, getAddr());
        }
        if (hasGeo()) {
          paramCodedOutputStreamMicro.writeString(6, getGeo());
        }
        if (hasIndoorFloor()) {
          paramCodedOutputStreamMicro.writeString(7, getIndoorFloor());
        }
        if (hasIndoorParentUid()) {
          paramCodedOutputStreamMicro.writeString(8, getIndoorParentUid());
        }
        if (hasDist()) {
          paramCodedOutputStreamMicro.writeInt32(9, getDist());
        }
        if (hasDirection()) {
          paramCodedOutputStreamMicro.writeInt32(10, getDirection());
        }
        if (hasDescribe()) {
          paramCodedOutputStreamMicro.writeString(11, getDescribe());
        }
      }
    }
  }
  
  public static final class ImageShow
    extends MessageMicro
  {
    public static final int IMAGE_EXT_FIELD_NUMBER = 1;
    public static final int RES_BOUND_FIELD_NUMBER = 2;
    private boolean a;
    private ByteStringMicro b = ByteStringMicro.EMPTY;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static ImageShow parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ImageShow().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ImageShow parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ImageShow)new ImageShow().mergeFrom(paramArrayOfByte);
    }
    
    public final ImageShow clear()
    {
      clearImageExt();
      clearResBound();
      this.e = -1;
      return this;
    }
    
    public ImageShow clearImageExt()
    {
      this.a = false;
      this.b = ByteStringMicro.EMPTY;
      return this;
    }
    
    public ImageShow clearResBound()
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
    
    public ByteStringMicro getImageExt()
    {
      return this.b;
    }
    
    public String getResBound()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasImageExt()) {
        i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getImageExt());
      }
      int j = i;
      if (hasResBound()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getResBound());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasImageExt()
    {
      return this.a;
    }
    
    public boolean hasResBound()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ImageShow mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setImageExt(paramCodedInputStreamMicro.readBytes());
          break;
        case 18: 
          setResBound(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ImageShow setImageExt(ByteStringMicro paramByteStringMicro)
    {
      this.a = true;
      this.b = paramByteStringMicro;
      return this;
    }
    
    public ImageShow setResBound(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasImageExt()) {
        paramCodedOutputStreamMicro.writeBytes(1, getImageExt());
      }
      if (hasResBound()) {
        paramCodedOutputStreamMicro.writeString(2, getResBound());
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int CITY_LIST_FIELD_NUMBER = 1;
    public static final int END_CITY_FIELD_NUMBER = 8;
    public static final int E_WD_FIELD_NUMBER = 5;
    public static final int IF_NAV_FIELD_NUMBER = 6;
    public static final int PRIO_FLAG_FIELD_NUMBER = 2;
    public static final int START_CITY_FIELD_NUMBER = 7;
    public static final int S_WD_FIELD_NUMBER = 4;
    public static final int WP_WD_FIELD_NUMBER = 3;
    private List<String> a = Collections.emptyList();
    private List<String> b = Collections.emptyList();
    private List<String> c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private List<String> f = Collections.emptyList();
    private boolean g;
    private boolean h = false;
    private boolean i;
    private StartCity j = null;
    private List<EndCity> k = Collections.emptyList();
    private int l = -1;
    
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
    
    public Option addCityList(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramString);
      return this;
    }
    
    public Option addEWd(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.f.isEmpty()) {
        this.f = new ArrayList();
      }
      this.f.add(paramString);
      return this;
    }
    
    public Option addEndCity(EndCity paramEndCity)
    {
      if (paramEndCity == null) {
        return this;
      }
      if (this.k.isEmpty()) {
        this.k = new ArrayList();
      }
      this.k.add(paramEndCity);
      return this;
    }
    
    public Option addPrioFlag(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.b.isEmpty()) {
        this.b = new ArrayList();
      }
      this.b.add(paramString);
      return this;
    }
    
    public Option addWpWd(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramString);
      return this;
    }
    
    public final Option clear()
    {
      clearCityList();
      clearPrioFlag();
      clearWpWd();
      clearSWd();
      clearEWd();
      clearIfNav();
      clearStartCity();
      clearEndCity();
      this.l = -1;
      return this;
    }
    
    public Option clearCityList()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Option clearEWd()
    {
      this.f = Collections.emptyList();
      return this;
    }
    
    public Option clearEndCity()
    {
      this.k = Collections.emptyList();
      return this;
    }
    
    public Option clearIfNav()
    {
      this.g = false;
      this.h = false;
      return this;
    }
    
    public Option clearPrioFlag()
    {
      this.b = Collections.emptyList();
      return this;
    }
    
    public Option clearSWd()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public Option clearStartCity()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public Option clearWpWd()
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
    
    public String getCityList(int paramInt)
    {
      return (String)this.a.get(paramInt);
    }
    
    public int getCityListCount()
    {
      return this.a.size();
    }
    
    public List<String> getCityListList()
    {
      return this.a;
    }
    
    public String getEWd(int paramInt)
    {
      return (String)this.f.get(paramInt);
    }
    
    public int getEWdCount()
    {
      return this.f.size();
    }
    
    public List<String> getEWdList()
    {
      return this.f;
    }
    
    public EndCity getEndCity(int paramInt)
    {
      return (EndCity)this.k.get(paramInt);
    }
    
    public int getEndCityCount()
    {
      return this.k.size();
    }
    
    public List<EndCity> getEndCityList()
    {
      return this.k;
    }
    
    public boolean getIfNav()
    {
      return this.h;
    }
    
    public String getPrioFlag(int paramInt)
    {
      return (String)this.b.get(paramInt);
    }
    
    public int getPrioFlagCount()
    {
      return this.b.size();
    }
    
    public List<String> getPrioFlagList()
    {
      return this.b;
    }
    
    public String getSWd()
    {
      return this.e;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      Iterator localIterator = getCityListList().iterator();
      for (int m = 0; localIterator.hasNext(); m = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + m) {}
      int i3 = getCityListList().size();
      localIterator = getPrioFlagList().iterator();
      for (int n = 0; localIterator.hasNext(); n = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + n) {}
      int i4 = getPrioFlagList().size();
      localIterator = getWpWdList().iterator();
      for (int i1 = 0; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i1) {}
      m = 0 + m + i3 * 1 + n + i4 * 1 + i1 + getWpWdList().size() * 1;
      if (hasSWd()) {
        m += CodedOutputStreamMicro.computeStringSize(4, getSWd());
      }
      for (;;)
      {
        localIterator = getEWdList().iterator();
        n = i2;
        while (localIterator.hasNext()) {
          n += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
        }
        n = m + n + getEWdList().size() * 1;
        m = n;
        if (hasIfNav()) {
          m = n + CodedOutputStreamMicro.computeBoolSize(6, getIfNav());
        }
        n = m;
        if (hasStartCity()) {
          n = m + CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
        }
        localIterator = getEndCityList().iterator();
        while (localIterator.hasNext()) {
          n = CodedOutputStreamMicro.computeMessageSize(8, (EndCity)localIterator.next()) + n;
        }
        this.l = n;
        return n;
      }
    }
    
    public StartCity getStartCity()
    {
      return this.j;
    }
    
    public String getWpWd(int paramInt)
    {
      return (String)this.c.get(paramInt);
    }
    
    public int getWpWdCount()
    {
      return this.c.size();
    }
    
    public List<String> getWpWdList()
    {
      return this.c;
    }
    
    public boolean hasIfNav()
    {
      return this.g;
    }
    
    public boolean hasSWd()
    {
      return this.d;
    }
    
    public boolean hasStartCity()
    {
      return this.i;
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
          addCityList(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          addPrioFlag(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          addWpWd(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setSWd(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          addEWd(paramCodedInputStreamMicro.readString());
          break;
        case 48: 
          setIfNav(paramCodedInputStreamMicro.readBool());
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
        }
      }
    }
    
    public Option setCityList(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.a.set(paramInt, paramString);
      return this;
    }
    
    public Option setEWd(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.f.set(paramInt, paramString);
      return this;
    }
    
    public Option setEndCity(int paramInt, EndCity paramEndCity)
    {
      if (paramEndCity == null) {
        return this;
      }
      this.k.set(paramInt, paramEndCity);
      return this;
    }
    
    public Option setIfNav(boolean paramBoolean)
    {
      this.g = true;
      this.h = paramBoolean;
      return this;
    }
    
    public Option setPrioFlag(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.b.set(paramInt, paramString);
      return this;
    }
    
    public Option setSWd(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public Option setStartCity(StartCity paramStartCity)
    {
      if (paramStartCity == null) {
        return clearStartCity();
      }
      this.i = true;
      this.j = paramStartCity;
      return this;
    }
    
    public Option setWpWd(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.c.set(paramInt, paramString);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getCityListList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(1, (String)localIterator.next());
      }
      localIterator = getPrioFlagList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(2, (String)localIterator.next());
      }
      localIterator = getWpWdList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(3, (String)localIterator.next());
      }
      if (hasSWd()) {
        paramCodedOutputStreamMicro.writeString(4, getSWd());
      }
      localIterator = getEWdList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(5, (String)localIterator.next());
      }
      if (hasIfNav()) {
        paramCodedOutputStreamMicro.writeBool(6, getIfNav());
      }
      if (hasStartCity()) {
        paramCodedOutputStreamMicro.writeMessage(7, getStartCity());
      }
      localIterator = getEndCityList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (EndCity)localIterator.next());
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
  
  public static final class SuggestQuery
    extends MessageMicro
  {
    public static final int QUERY_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private int c = -1;
    
    public static SuggestQuery parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SuggestQuery().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SuggestQuery parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SuggestQuery)new SuggestQuery().mergeFrom(paramArrayOfByte);
    }
    
    public final SuggestQuery clear()
    {
      clearQuery();
      this.c = -1;
      return this;
    }
    
    public SuggestQuery clearQuery()
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
    
    public String getQuery()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasQuery()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getQuery());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasQuery()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SuggestQuery mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setQuery(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public SuggestQuery setQuery(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasQuery()) {
        paramCodedOutputStreamMicro.writeString(1, getQuery());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrafficPois.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */