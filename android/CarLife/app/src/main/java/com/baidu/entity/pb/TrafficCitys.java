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

public final class TrafficCitys
  extends MessageMicro
{
  public static final int CONTENTS_FIELD_NUMBER = 2;
  public static final int CURRENT_CITY_FIELD_NUMBER = 1;
  public static final int SUGGEST_QUERY_FIELD_NUMBER = 3;
  private boolean a;
  private CurrentCity b = null;
  private List<Contents> c = Collections.emptyList();
  private List<SuggestQuery> d = Collections.emptyList();
  private int e = -1;
  
  public static TrafficCitys parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrafficCitys().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrafficCitys parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrafficCitys)new TrafficCitys().mergeFrom(paramArrayOfByte);
  }
  
  public TrafficCitys addContents(Contents paramContents)
  {
    if (paramContents == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramContents);
    return this;
  }
  
  public TrafficCitys addSuggestQuery(SuggestQuery paramSuggestQuery)
  {
    if (paramSuggestQuery == null) {
      return this;
    }
    if (this.d.isEmpty()) {
      this.d = new ArrayList();
    }
    this.d.add(paramSuggestQuery);
    return this;
  }
  
  public final TrafficCitys clear()
  {
    clearCurrentCity();
    clearContents();
    clearSuggestQuery();
    this.e = -1;
    return this;
  }
  
  public TrafficCitys clearContents()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public TrafficCitys clearCurrentCity()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public TrafficCitys clearSuggestQuery()
  {
    this.d = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public Contents getContents(int paramInt)
  {
    return (Contents)this.c.get(paramInt);
  }
  
  public int getContentsCount()
  {
    return this.c.size();
  }
  
  public List<Contents> getContentsList()
  {
    return this.c;
  }
  
  public CurrentCity getCurrentCity()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasCurrentCity()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getCurrentCity());
    }
    Iterator localIterator = getContentsList().iterator();
    while (localIterator.hasNext()) {
      i = CodedOutputStreamMicro.computeMessageSize(2, (Contents)localIterator.next()) + i;
    }
    localIterator = getSuggestQueryList().iterator();
    while (localIterator.hasNext()) {
      i += CodedOutputStreamMicro.computeMessageSize(3, (SuggestQuery)localIterator.next());
    }
    this.e = i;
    return i;
  }
  
  public SuggestQuery getSuggestQuery(int paramInt)
  {
    return (SuggestQuery)this.d.get(paramInt);
  }
  
  public int getSuggestQueryCount()
  {
    return this.d.size();
  }
  
  public List<SuggestQuery> getSuggestQueryList()
  {
    return this.d;
  }
  
  public boolean hasCurrentCity()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrafficCitys mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new CurrentCity();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setCurrentCity((CurrentCity)localObject);
        break;
      case 18: 
        localObject = new Contents();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addContents((Contents)localObject);
        break;
      case 26: 
        localObject = new SuggestQuery();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addSuggestQuery((SuggestQuery)localObject);
      }
    }
  }
  
  public TrafficCitys setContents(int paramInt, Contents paramContents)
  {
    if (paramContents == null) {
      return this;
    }
    this.c.set(paramInt, paramContents);
    return this;
  }
  
  public TrafficCitys setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.a = true;
    this.b = paramCurrentCity;
    return this;
  }
  
  public TrafficCitys setSuggestQuery(int paramInt, SuggestQuery paramSuggestQuery)
  {
    if (paramSuggestQuery == null) {
      return this;
    }
    this.d.set(paramInt, paramSuggestQuery);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasCurrentCity()) {
      paramCodedOutputStreamMicro.writeMessage(1, getCurrentCity());
    }
    Iterator localIterator = getContentsList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (Contents)localIterator.next());
    }
    localIterator = getSuggestQueryList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (SuggestQuery)localIterator.next());
    }
  }
  
  public static final class Contents
    extends MessageMicro
  {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int EXT_INFO_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int NUM_FIELD_NUMBER = 2;
    public static final int POIS_FIELD_NUMBER = 8;
    public static final int POI_NUM_FIELD_NUMBER = 7;
    public static final int SEARCH_QUERY_FIELD_NUMBER = 9;
    public static final int TYPE_FIELD_NUMBER = 4;
    public static final int VIEW_NAME_FIELD_NUMBER = 5;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private String f = "";
    private boolean g;
    private int h = 0;
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private boolean m;
    private int n = 0;
    private List<Pois> o = Collections.emptyList();
    private boolean p;
    private String q = "";
    private int r = -1;
    
    public static Contents parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Contents().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Contents parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Contents)new Contents().mergeFrom(paramArrayOfByte);
    }
    
    public Contents addPois(Pois paramPois)
    {
      if (paramPois == null) {
        return this;
      }
      if (this.o.isEmpty()) {
        this.o = new ArrayList();
      }
      this.o.add(paramPois);
      return this;
    }
    
    public final Contents clear()
    {
      clearCode();
      clearNum();
      clearName();
      clearType();
      clearViewName();
      clearExtInfo();
      clearPoiNum();
      clearPois();
      clearSearchQuery();
      this.r = -1;
      return this;
    }
    
    public Contents clearCode()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Contents clearExtInfo()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Contents clearName()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Contents clearNum()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Contents clearPoiNum()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public Contents clearPois()
    {
      this.o = Collections.emptyList();
      return this;
    }
    
    public Contents clearSearchQuery()
    {
      this.p = false;
      this.q = "";
      return this;
    }
    
    public Contents clearType()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Contents clearViewName()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.r < 0) {
        getSerializedSize();
      }
      return this.r;
    }
    
    public int getCode()
    {
      return this.b;
    }
    
    public String getExtInfo()
    {
      return this.l;
    }
    
    public String getName()
    {
      return this.f;
    }
    
    public int getNum()
    {
      return this.d;
    }
    
    public int getPoiNum()
    {
      return this.n;
    }
    
    public Pois getPois(int paramInt)
    {
      return (Pois)this.o.get(paramInt);
    }
    
    public int getPoisCount()
    {
      return this.o.size();
    }
    
    public List<Pois> getPoisList()
    {
      return this.o;
    }
    
    public String getSearchQuery()
    {
      return this.q;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasCode()) {
        i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
      }
      int i1 = i2;
      if (hasNum()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getNum());
      }
      i2 = i1;
      if (hasName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getName());
      }
      i1 = i2;
      if (hasType()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getType());
      }
      i2 = i1;
      if (hasViewName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getViewName());
      }
      i1 = i2;
      if (hasExtInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getExtInfo());
      }
      i2 = i1;
      if (hasPoiNum()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getPoiNum());
      }
      Iterator localIterator = getPoisList().iterator();
      for (i1 = i2; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(8, (Pois)localIterator.next()) + i1) {}
      i2 = i1;
      if (hasSearchQuery()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getSearchQuery());
      }
      this.r = i2;
      return i2;
    }
    
    public int getType()
    {
      return this.h;
    }
    
    public String getViewName()
    {
      return this.j;
    }
    
    public boolean hasCode()
    {
      return this.a;
    }
    
    public boolean hasExtInfo()
    {
      return this.k;
    }
    
    public boolean hasName()
    {
      return this.e;
    }
    
    public boolean hasNum()
    {
      return this.c;
    }
    
    public boolean hasPoiNum()
    {
      return this.m;
    }
    
    public boolean hasSearchQuery()
    {
      return this.p;
    }
    
    public boolean hasType()
    {
      return this.g;
    }
    
    public boolean hasViewName()
    {
      return this.i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Contents mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        case 16: 
          setNum(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setType(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setViewName(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setExtInfo(paramCodedInputStreamMicro.readString());
          break;
        case 56: 
          setPoiNum(paramCodedInputStreamMicro.readInt32());
          break;
        case 66: 
          Pois localPois = new Pois();
          paramCodedInputStreamMicro.readMessage(localPois);
          addPois(localPois);
          break;
        case 74: 
          setSearchQuery(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Contents setCode(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Contents setExtInfo(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Contents setName(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Contents setNum(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Contents setPoiNum(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public Contents setPois(int paramInt, Pois paramPois)
    {
      if (paramPois == null) {
        return this;
      }
      this.o.set(paramInt, paramPois);
      return this;
    }
    
    public Contents setSearchQuery(String paramString)
    {
      this.p = true;
      this.q = paramString;
      return this;
    }
    
    public Contents setType(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Contents setViewName(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCode()) {
        paramCodedOutputStreamMicro.writeInt32(1, getCode());
      }
      if (hasNum()) {
        paramCodedOutputStreamMicro.writeInt32(2, getNum());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(3, getName());
      }
      if (hasType()) {
        paramCodedOutputStreamMicro.writeInt32(4, getType());
      }
      if (hasViewName()) {
        paramCodedOutputStreamMicro.writeString(5, getViewName());
      }
      if (hasExtInfo()) {
        paramCodedOutputStreamMicro.writeString(6, getExtInfo());
      }
      if (hasPoiNum()) {
        paramCodedOutputStreamMicro.writeInt32(7, getPoiNum());
      }
      Iterator localIterator = getPoisList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (Pois)localIterator.next());
      }
      if (hasSearchQuery()) {
        paramCodedOutputStreamMicro.writeString(9, getSearchQuery());
      }
    }
    
    public static final class Pois
      extends MessageMicro
    {
      public static final int ADDR_FIELD_NUMBER = 3;
      public static final int BID_FIELD_NUMBER = 1;
      public static final int NAME_FIELD_NUMBER = 2;
      public static final int POI_QUERY_FIELD_NUMBER = 5;
      public static final int STDTAG_FIELD_NUMBER = 4;
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
      private int k = -1;
      
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
      
      public final Pois clear()
      {
        clearBid();
        clearName();
        clearAddr();
        clearStdtag();
        clearPoiQuery();
        this.k = -1;
        return this;
      }
      
      public Pois clearAddr()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Pois clearBid()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Pois clearName()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Pois clearPoiQuery()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public Pois clearStdtag()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public String getAddr()
      {
        return this.f;
      }
      
      public String getBid()
      {
        return this.b;
      }
      
      public int getCachedSize()
      {
        if (this.k < 0) {
          getSerializedSize();
        }
        return this.k;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public String getPoiQuery()
      {
        return this.j;
      }
      
      public int getSerializedSize()
      {
        int n = 0;
        if (hasBid()) {
          n = 0 + CodedOutputStreamMicro.computeStringSize(1, getBid());
        }
        int m = n;
        if (hasName()) {
          m = n + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        n = m;
        if (hasAddr()) {
          n = m + CodedOutputStreamMicro.computeStringSize(3, getAddr());
        }
        m = n;
        if (hasStdtag()) {
          m = n + CodedOutputStreamMicro.computeStringSize(4, getStdtag());
        }
        n = m;
        if (hasPoiQuery()) {
          n = m + CodedOutputStreamMicro.computeStringSize(5, getPoiQuery());
        }
        this.k = n;
        return n;
      }
      
      public String getStdtag()
      {
        return this.h;
      }
      
      public boolean hasAddr()
      {
        return this.e;
      }
      
      public boolean hasBid()
      {
        return this.a;
      }
      
      public boolean hasName()
      {
        return this.c;
      }
      
      public boolean hasPoiQuery()
      {
        return this.i;
      }
      
      public boolean hasStdtag()
      {
        return this.g;
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
            setBid(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setAddr(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setStdtag(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setPoiQuery(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Pois setAddr(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Pois setBid(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Pois setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Pois setPoiQuery(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public Pois setStdtag(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasBid()) {
          paramCodedOutputStreamMicro.writeString(1, getBid());
        }
        if (hasName()) {
          paramCodedOutputStreamMicro.writeString(2, getName());
        }
        if (hasAddr()) {
          paramCodedOutputStreamMicro.writeString(3, getAddr());
        }
        if (hasStdtag()) {
          paramCodedOutputStreamMicro.writeString(4, getStdtag());
        }
        if (hasPoiQuery()) {
          paramCodedOutputStreamMicro.writeString(5, getPoiQuery());
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrafficCitys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */