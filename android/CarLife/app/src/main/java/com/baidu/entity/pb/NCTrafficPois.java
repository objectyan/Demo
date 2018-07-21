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

public final class NCTrafficPois
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
  private ImgeShow k = null;
  private int l = -1;
  
  public static NCTrafficPois parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new NCTrafficPois().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static NCTrafficPois parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (NCTrafficPois)new NCTrafficPois().mergeFrom(paramArrayOfByte);
  }
  
  public NCTrafficPois addSuggestQuery(SuggestQuery paramSuggestQuery)
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
  
  public final NCTrafficPois clear()
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
  
  public NCTrafficPois clearContent()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public NCTrafficPois clearCurrentCity()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public NCTrafficPois clearImgeShow()
  {
    this.j = false;
    this.k = null;
    return this;
  }
  
  public NCTrafficPois clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public NCTrafficPois clearSuggestQuery()
  {
    this.g = Collections.emptyList();
    return this;
  }
  
  public NCTrafficPois clearSuggestQueryFlag()
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
  
  public ImgeShow getImgeShow()
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
  
  public NCTrafficPois mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new ImgeShow();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setImgeShow((ImgeShow)localObject);
      }
    }
  }
  
  public NCTrafficPois setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.e = true;
    this.f = paramContent;
    return this;
  }
  
  public NCTrafficPois setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.c = true;
    this.d = paramCurrentCity;
    return this;
  }
  
  public NCTrafficPois setImgeShow(ImgeShow paramImgeShow)
  {
    if (paramImgeShow == null) {
      return clearImgeShow();
    }
    this.j = true;
    this.k = paramImgeShow;
    return this;
  }
  
  public NCTrafficPois setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.a = true;
    this.b = paramOption;
    return this;
  }
  
  public NCTrafficPois setSuggestQuery(int paramInt, SuggestQuery paramSuggestQuery)
  {
    if (paramSuggestQuery == null) {
      return this;
    }
    this.g.set(paramInt, paramSuggestQuery);
    return this;
  }
  
  public NCTrafficPois setSuggestQueryFlag(int paramInt)
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
    public static final int START_FIELD_NUMBER = 1;
    public static final int WAY_POINTS_FIELD_NUMBER = 3;
    private List<Start> a = Collections.emptyList();
    private List<End> b = Collections.emptyList();
    private List<WayPoints> c = Collections.emptyList();
    private int d = -1;
    
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
      this.d = -1;
      return this;
    }
    
    public Content clearEnd()
    {
      this.b = Collections.emptyList();
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
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
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
      this.d = i;
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
    }
  }
  
  public static final class CurrentCity
    extends MessageMicro
  {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int GEO_FIELD_NUMBER = 2;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int SGEO_FIELD_NUMBER = 8;
    public static final int SUP_LUKUANG_FIELD_NUMBER = 6;
    public static final int SUP_SUBWAY_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 7;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private boolean g;
    private String h = "";
    private boolean i;
    private boolean j = false;
    private boolean k;
    private boolean l = false;
    private boolean m;
    private String n = "";
    private List<Integer> o = Collections.emptyList();
    private int p = -1;
    
    public static CurrentCity parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CurrentCity().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CurrentCity parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CurrentCity)new CurrentCity().mergeFrom(paramArrayOfByte);
    }
    
    public CurrentCity addSgeo(int paramInt)
    {
      if (this.o.isEmpty()) {
        this.o = new ArrayList();
      }
      this.o.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public final CurrentCity clear()
    {
      clearCode();
      clearGeo();
      clearLevel();
      clearName();
      clearSupSubway();
      clearSupLukuang();
      clearUid();
      clearSgeo();
      this.p = -1;
      return this;
    }
    
    public CurrentCity clearCode()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public CurrentCity clearGeo()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public CurrentCity clearLevel()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public CurrentCity clearName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public CurrentCity clearSgeo()
    {
      this.o = Collections.emptyList();
      return this;
    }
    
    public CurrentCity clearSupLukuang()
    {
      this.k = false;
      this.l = false;
      return this;
    }
    
    public CurrentCity clearSupSubway()
    {
      this.i = false;
      this.j = false;
      return this;
    }
    
    public CurrentCity clearUid()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.p < 0) {
        getSerializedSize();
      }
      return this.p;
    }
    
    public int getCode()
    {
      return this.b;
    }
    
    public String getGeo()
    {
      return this.d;
    }
    
    public int getLevel()
    {
      return this.f;
    }
    
    public String getName()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasCode()) {}
      for (int i2 = CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0;; i2 = 0)
      {
        int i1 = i2;
        if (hasGeo()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getGeo());
        }
        i2 = i1;
        if (hasLevel()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        i1 = i2;
        if (hasName()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getName());
        }
        i2 = i1;
        if (hasSupSubway()) {
          i2 = i1 + CodedOutputStreamMicro.computeBoolSize(5, getSupSubway());
        }
        i1 = i2;
        if (hasSupLukuang()) {
          i1 = i2 + CodedOutputStreamMicro.computeBoolSize(6, getSupLukuang());
        }
        if (hasUid()) {
          i1 += CodedOutputStreamMicro.computeStringSize(7, getUid());
        }
        for (;;)
        {
          Iterator localIterator = getSgeoList().iterator();
          i2 = i3;
          while (localIterator.hasNext()) {
            i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
          }
          i1 = i1 + i2 + getSgeoList().size() * 1;
          this.p = i1;
          return i1;
        }
      }
    }
    
    public int getSgeo(int paramInt)
    {
      return ((Integer)this.o.get(paramInt)).intValue();
    }
    
    public int getSgeoCount()
    {
      return this.o.size();
    }
    
    public List<Integer> getSgeoList()
    {
      return this.o;
    }
    
    public boolean getSupLukuang()
    {
      return this.l;
    }
    
    public boolean getSupSubway()
    {
      return this.j;
    }
    
    public String getUid()
    {
      return this.n;
    }
    
    public boolean hasCode()
    {
      return this.a;
    }
    
    public boolean hasGeo()
    {
      return this.c;
    }
    
    public boolean hasLevel()
    {
      return this.e;
    }
    
    public boolean hasName()
    {
      return this.g;
    }
    
    public boolean hasSupLukuang()
    {
      return this.k;
    }
    
    public boolean hasSupSubway()
    {
      return this.i;
    }
    
    public boolean hasUid()
    {
      return this.m;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public CurrentCity mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setGeo(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setLevel(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setSupSubway(paramCodedInputStreamMicro.readBool());
          break;
        case 48: 
          setSupLukuang(paramCodedInputStreamMicro.readBool());
          break;
        case 58: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 64: 
          addSgeo(paramCodedInputStreamMicro.readSInt32());
        }
      }
    }
    
    public CurrentCity setCode(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public CurrentCity setGeo(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public CurrentCity setLevel(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public CurrentCity setName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public CurrentCity setSgeo(int paramInt1, int paramInt2)
    {
      this.o.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    
    public CurrentCity setSupLukuang(boolean paramBoolean)
    {
      this.k = true;
      this.l = paramBoolean;
      return this;
    }
    
    public CurrentCity setSupSubway(boolean paramBoolean)
    {
      this.i = true;
      this.j = paramBoolean;
      return this;
    }
    
    public CurrentCity setUid(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCode()) {
        paramCodedOutputStreamMicro.writeInt32(1, getCode());
      }
      if (hasGeo()) {
        paramCodedOutputStreamMicro.writeString(2, getGeo());
      }
      if (hasLevel()) {
        paramCodedOutputStreamMicro.writeInt32(3, getLevel());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(4, getName());
      }
      if (hasSupSubway()) {
        paramCodedOutputStreamMicro.writeBool(5, getSupSubway());
      }
      if (hasSupLukuang()) {
        paramCodedOutputStreamMicro.writeBool(6, getSupLukuang());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(7, getUid());
      }
      Iterator localIterator = getSgeoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeSInt32(8, ((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public static final class ImgeShow
    extends MessageMicro
  {
    public static final int IMGE_EXT_FIELD_NUMBER = 1;
    public static final int RES_BOUND_FIELD_NUMBER = 2;
    private boolean a;
    private ByteStringMicro b = ByteStringMicro.EMPTY;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static ImgeShow parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ImgeShow().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ImgeShow parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ImgeShow)new ImgeShow().mergeFrom(paramArrayOfByte);
    }
    
    public final ImgeShow clear()
    {
      clearImgeExt();
      clearResBound();
      this.e = -1;
      return this;
    }
    
    public ImgeShow clearImgeExt()
    {
      this.a = false;
      this.b = ByteStringMicro.EMPTY;
      return this;
    }
    
    public ImgeShow clearResBound()
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
    
    public ByteStringMicro getImgeExt()
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
      if (hasImgeExt()) {
        i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getImgeExt());
      }
      int j = i;
      if (hasResBound()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getResBound());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasImgeExt()
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
    
    public ImgeShow mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setImgeExt(paramCodedInputStreamMicro.readBytes());
          break;
        case 18: 
          setResBound(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ImgeShow setImgeExt(ByteStringMicro paramByteStringMicro)
    {
      this.a = true;
      this.b = paramByteStringMicro;
      return this;
    }
    
    public ImgeShow setResBound(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasImgeExt()) {
        paramCodedOutputStreamMicro.writeBytes(1, getImgeExt());
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
    public static final int VIA_CITY_FIELD_NUMBER = 10;
    public static final int V_WD_FIELD_NUMBER = 9;
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
    private List<String> l = Collections.emptyList();
    private List<ViaCity> m = Collections.emptyList();
    private int n = -1;
    
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
    
    public Option addVWd(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.l.isEmpty()) {
        this.l = new ArrayList();
      }
      this.l.add(paramString);
      return this;
    }
    
    public Option addViaCity(ViaCity paramViaCity)
    {
      if (paramViaCity == null) {
        return this;
      }
      if (this.m.isEmpty()) {
        this.m = new ArrayList();
      }
      this.m.add(paramViaCity);
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
      clearVWd();
      clearViaCity();
      this.n = -1;
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
    
    public Option clearVWd()
    {
      this.l = Collections.emptyList();
      return this;
    }
    
    public Option clearViaCity()
    {
      this.m = Collections.emptyList();
      return this;
    }
    
    public Option clearWpWd()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.n < 0) {
        getSerializedSize();
      }
      return this.n;
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
      int i4 = 0;
      Iterator localIterator = getCityListList().iterator();
      for (int i1 = 0; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i1) {}
      int i5 = getCityListList().size();
      localIterator = getPrioFlagList().iterator();
      for (int i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i2) {}
      int i6 = getPrioFlagList().size();
      localIterator = getWpWdList().iterator();
      for (int i3 = 0; localIterator.hasNext(); i3 = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i3) {}
      i1 = 0 + i1 + i5 * 1 + i2 + i6 * 1 + i3 + getWpWdList().size() * 1;
      if (hasSWd()) {
        i1 += CodedOutputStreamMicro.computeStringSize(4, getSWd());
      }
      for (;;)
      {
        localIterator = getEWdList().iterator();
        for (i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i2) {}
        i2 = i1 + i2 + getEWdList().size() * 1;
        i1 = i2;
        if (hasIfNav()) {
          i1 = i2 + CodedOutputStreamMicro.computeBoolSize(6, getIfNav());
        }
        i2 = i1;
        if (hasStartCity()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
        }
        localIterator = getEndCityList().iterator();
        for (i1 = i2; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(8, (EndCity)localIterator.next()) + i1) {}
        localIterator = getVWdList().iterator();
        i2 = i4;
        while (localIterator.hasNext()) {
          i2 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
        }
        i3 = getVWdList().size();
        localIterator = getViaCityList().iterator();
        for (i1 = i1 + i2 + i3 * 1; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(10, (ViaCity)localIterator.next()) + i1) {}
        this.n = i1;
        return i1;
      }
    }
    
    public StartCity getStartCity()
    {
      return this.j;
    }
    
    public String getVWd(int paramInt)
    {
      return (String)this.l.get(paramInt);
    }
    
    public int getVWdCount()
    {
      return this.l.size();
    }
    
    public List<String> getVWdList()
    {
      return this.l;
    }
    
    public ViaCity getViaCity(int paramInt)
    {
      return (ViaCity)this.m.get(paramInt);
    }
    
    public int getViaCityCount()
    {
      return this.m.size();
    }
    
    public List<ViaCity> getViaCityList()
    {
      return this.m;
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
          break;
        case 74: 
          addVWd(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          localObject = new ViaCity();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addViaCity((ViaCity)localObject);
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
    
    public Option setVWd(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.l.set(paramInt, paramString);
      return this;
    }
    
    public Option setViaCity(int paramInt, ViaCity paramViaCity)
    {
      if (paramViaCity == null) {
        return this;
      }
      this.m.set(paramInt, paramViaCity);
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
      localIterator = getVWdList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(9, (String)localIterator.next());
      }
      localIterator = getViaCityList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(10, (ViaCity)localIterator.next());
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
    
    public static final class ViaCity
      extends MessageMicro
    {
      public static final int CNAME_FIELD_NUMBER = 2;
      public static final int CODE_FIELD_NUMBER = 1;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static ViaCity parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new ViaCity().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static ViaCity parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (ViaCity)new ViaCity().mergeFrom(paramArrayOfByte);
      }
      
      public final ViaCity clear()
      {
        clearCode();
        clearCname();
        this.e = -1;
        return this;
      }
      
      public ViaCity clearCname()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public ViaCity clearCode()
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
      
      public ViaCity mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      
      public ViaCity setCname(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public ViaCity setCode(int paramInt)
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/NCTrafficPois.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */