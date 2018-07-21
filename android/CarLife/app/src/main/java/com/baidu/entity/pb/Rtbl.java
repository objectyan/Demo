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

public final class Rtbl
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int ERROR_FIELD_NUMBER = 3;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Content d = null;
  private boolean e;
  private int f = 0;
  private int g = -1;
  
  public static Rtbl parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Rtbl().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Rtbl parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Rtbl)new Rtbl().mergeFrom(paramArrayOfByte);
  }
  
  public final Rtbl clear()
  {
    clearOption();
    clearContent();
    clearError();
    this.g = -1;
    return this;
  }
  
  public Rtbl clearContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Rtbl clearError()
  {
    this.e = false;
    this.f = 0;
    return this;
  }
  
  public Rtbl clearOption()
  {
    this.a = false;
    this.b = null;
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
  
  public int getError()
  {
    return this.f;
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
    if (hasError()) {
      j = i + CodedOutputStreamMicro.computeInt32Size(3, getError());
    }
    this.g = j;
    return j;
  }
  
  public boolean hasContent()
  {
    return this.c;
  }
  
  public boolean hasError()
  {
    return this.e;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Rtbl mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 24: 
        setError(paramCodedInputStreamMicro.readInt32());
      }
    }
  }
  
  public Rtbl setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.c = true;
    this.d = paramContent;
    return this;
  }
  
  public Rtbl setError(int paramInt)
  {
    this.e = true;
    this.f = paramInt;
    return this;
  }
  
  public Rtbl setOption(Option paramOption)
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
    if (hasContent()) {
      paramCodedOutputStreamMicro.writeMessage(2, getContent());
    }
    if (hasError()) {
      paramCodedOutputStreamMicro.writeInt32(3, getError());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int LINES_FIELD_NUMBER = 1;
    public static final int RECOMMEND_LINES_FIELD_NUMBER = 4;
    public static final int RECOMMEND_UPDATE_INTERVAL_FIELD_NUMBER = 3;
    public static final int STATIONS_FIELD_NUMBER = 2;
    private List<Lines> a = Collections.emptyList();
    private List<Stations> b = Collections.emptyList();
    private boolean c;
    private int d = 0;
    private List<RecommendLines> e = Collections.emptyList();
    private int f = -1;
    
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
    
    public Content addLines(Lines paramLines)
    {
      if (paramLines == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramLines);
      return this;
    }
    
    public Content addRecommendLines(RecommendLines paramRecommendLines)
    {
      if (paramRecommendLines == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramRecommendLines);
      return this;
    }
    
    public Content addStations(Stations paramStations)
    {
      if (paramStations == null) {
        return this;
      }
      if (this.b.isEmpty()) {
        this.b = new ArrayList();
      }
      this.b.add(paramStations);
      return this;
    }
    
    public final Content clear()
    {
      clearLines();
      clearStations();
      clearRecommendUpdateInterval();
      clearRecommendLines();
      this.f = -1;
      return this;
    }
    
    public Content clearLines()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Content clearRecommendLines()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public Content clearRecommendUpdateInterval()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Content clearStations()
    {
      this.b = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.f < 0) {
        getSerializedSize();
      }
      return this.f;
    }
    
    public Lines getLines(int paramInt)
    {
      return (Lines)this.a.get(paramInt);
    }
    
    public int getLinesCount()
    {
      return this.a.size();
    }
    
    public List<Lines> getLinesList()
    {
      return this.a;
    }
    
    public RecommendLines getRecommendLines(int paramInt)
    {
      return (RecommendLines)this.e.get(paramInt);
    }
    
    public int getRecommendLinesCount()
    {
      return this.e.size();
    }
    
    public List<RecommendLines> getRecommendLinesList()
    {
      return this.e;
    }
    
    public int getRecommendUpdateInterval()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getLinesList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Lines)localIterator.next()) + i) {}
      localIterator = getStationsList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStreamMicro.computeMessageSize(2, (Stations)localIterator.next());
      }
      int j = i;
      if (hasRecommendUpdateInterval()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getRecommendUpdateInterval());
      }
      localIterator = getRecommendLinesList().iterator();
      while (localIterator.hasNext()) {
        j += CodedOutputStreamMicro.computeMessageSize(4, (RecommendLines)localIterator.next());
      }
      this.f = j;
      return j;
    }
    
    public Stations getStations(int paramInt)
    {
      return (Stations)this.b.get(paramInt);
    }
    
    public int getStationsCount()
    {
      return this.b.size();
    }
    
    public List<Stations> getStationsList()
    {
      return this.b;
    }
    
    public boolean hasRecommendUpdateInterval()
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
          localObject = new Lines();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addLines((Lines)localObject);
          break;
        case 18: 
          localObject = new Stations();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addStations((Stations)localObject);
          break;
        case 24: 
          setRecommendUpdateInterval(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          localObject = new RecommendLines();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addRecommendLines((RecommendLines)localObject);
        }
      }
    }
    
    public Content setLines(int paramInt, Lines paramLines)
    {
      if (paramLines == null) {
        return this;
      }
      this.a.set(paramInt, paramLines);
      return this;
    }
    
    public Content setRecommendLines(int paramInt, RecommendLines paramRecommendLines)
    {
      if (paramRecommendLines == null) {
        return this;
      }
      this.e.set(paramInt, paramRecommendLines);
      return this;
    }
    
    public Content setRecommendUpdateInterval(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Content setStations(int paramInt, Stations paramStations)
    {
      if (paramStations == null) {
        return this;
      }
      this.b.set(paramInt, paramStations);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getLinesList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Lines)localIterator.next());
      }
      localIterator = getStationsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Stations)localIterator.next());
      }
      if (hasRecommendUpdateInterval()) {
        paramCodedOutputStreamMicro.writeInt32(3, getRecommendUpdateInterval());
      }
      localIterator = getRecommendLinesList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(4, (RecommendLines)localIterator.next());
      }
    }
    
    public static final class Lines
      extends MessageMicro
    {
      public static final int DIRECTION_FIELD_NUMBER = 3;
      public static final int NAME_FIELD_NUMBER = 2;
      public static final int UID_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private List<Direction> e = Collections.emptyList();
      private int f = -1;
      
      public static Lines parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Lines().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Lines parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Lines)new Lines().mergeFrom(paramArrayOfByte);
      }
      
      public Lines addDirection(Direction paramDirection)
      {
        if (paramDirection == null) {
          return this;
        }
        if (this.e.isEmpty()) {
          this.e = new ArrayList();
        }
        this.e.add(paramDirection);
        return this;
      }
      
      public final Lines clear()
      {
        clearUid();
        clearName();
        clearDirection();
        this.f = -1;
        return this;
      }
      
      public Lines clearDirection()
      {
        this.e = Collections.emptyList();
        return this;
      }
      
      public Lines clearName()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Lines clearUid()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.f < 0) {
          getSerializedSize();
        }
        return this.f;
      }
      
      public Direction getDirection(int paramInt)
      {
        return (Direction)this.e.get(paramInt);
      }
      
      public int getDirectionCount()
      {
        return this.e.size();
      }
      
      public List<Direction> getDirectionList()
      {
        return this.e;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasUid()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
        }
        int j = i;
        if (hasName()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        Iterator localIterator = getDirectionList().iterator();
        while (localIterator.hasNext()) {
          j = CodedOutputStreamMicro.computeMessageSize(3, (Direction)localIterator.next()) + j;
        }
        this.f = j;
        return j;
      }
      
      public String getUid()
      {
        return this.b;
      }
      
      public boolean hasName()
      {
        return this.c;
      }
      
      public boolean hasUid()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Lines mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            Direction localDirection = new Direction();
            paramCodedInputStreamMicro.readMessage(localDirection);
            addDirection(localDirection);
          }
        }
      }
      
      public Lines setDirection(int paramInt, Direction paramDirection)
      {
        if (paramDirection == null) {
          return this;
        }
        this.e.set(paramInt, paramDirection);
        return this;
      }
      
      public Lines setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Lines setUid(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(1, getUid());
        }
        if (hasName()) {
          paramCodedOutputStreamMicro.writeString(2, getName());
        }
        Iterator localIterator = getDirectionList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(3, (Direction)localIterator.next());
        }
      }
      
      public static final class Direction
        extends MessageMicro
      {
        public static final int LINE_UID_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int REMAIN_STOPS_FIELD_NUMBER = 3;
        public static final int STATION_UID_FIELD_NUMBER = 4;
        public static final int TIP_RTBUS_FIELD_NUMBER = 5;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private int f = 0;
        private boolean g;
        private String h = "";
        private boolean i;
        private String j = "";
        private int k = -1;
        
        public static Direction parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Direction().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Direction parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Direction)new Direction().mergeFrom(paramArrayOfByte);
        }
        
        public final Direction clear()
        {
          clearName();
          clearLineUid();
          clearRemainStops();
          clearStationUid();
          clearTipRtbus();
          this.k = -1;
          return this;
        }
        
        public Direction clearLineUid()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public Direction clearName()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public Direction clearRemainStops()
        {
          this.e = false;
          this.f = 0;
          return this;
        }
        
        public Direction clearStationUid()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public Direction clearTipRtbus()
        {
          this.i = false;
          this.j = "";
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.k < 0) {
            getSerializedSize();
          }
          return this.k;
        }
        
        public String getLineUid()
        {
          return this.d;
        }
        
        public String getName()
        {
          return this.b;
        }
        
        public int getRemainStops()
        {
          return this.f;
        }
        
        public int getSerializedSize()
        {
          int n = 0;
          if (hasName()) {
            n = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
          }
          int m = n;
          if (hasLineUid()) {
            m = n + CodedOutputStreamMicro.computeStringSize(2, getLineUid());
          }
          n = m;
          if (hasRemainStops()) {
            n = m + CodedOutputStreamMicro.computeInt32Size(3, getRemainStops());
          }
          m = n;
          if (hasStationUid()) {
            m = n + CodedOutputStreamMicro.computeStringSize(4, getStationUid());
          }
          n = m;
          if (hasTipRtbus()) {
            n = m + CodedOutputStreamMicro.computeStringSize(5, getTipRtbus());
          }
          this.k = n;
          return n;
        }
        
        public String getStationUid()
        {
          return this.h;
        }
        
        public String getTipRtbus()
        {
          return this.j;
        }
        
        public boolean hasLineUid()
        {
          return this.c;
        }
        
        public boolean hasName()
        {
          return this.a;
        }
        
        public boolean hasRemainStops()
        {
          return this.e;
        }
        
        public boolean hasStationUid()
        {
          return this.g;
        }
        
        public boolean hasTipRtbus()
        {
          return this.i;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Direction mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            case 18: 
              setLineUid(paramCodedInputStreamMicro.readString());
              break;
            case 24: 
              setRemainStops(paramCodedInputStreamMicro.readInt32());
              break;
            case 34: 
              setStationUid(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              setTipRtbus(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Direction setLineUid(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public Direction setName(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public Direction setRemainStops(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
          return this;
        }
        
        public Direction setStationUid(String paramString)
        {
          this.g = true;
          this.h = paramString;
          return this;
        }
        
        public Direction setTipRtbus(String paramString)
        {
          this.i = true;
          this.j = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(1, getName());
          }
          if (hasLineUid()) {
            paramCodedOutputStreamMicro.writeString(2, getLineUid());
          }
          if (hasRemainStops()) {
            paramCodedOutputStreamMicro.writeInt32(3, getRemainStops());
          }
          if (hasStationUid()) {
            paramCodedOutputStreamMicro.writeString(4, getStationUid());
          }
          if (hasTipRtbus()) {
            paramCodedOutputStreamMicro.writeString(5, getTipRtbus());
          }
        }
      }
    }
    
    public static final class RecommendLines
      extends MessageMicro
    {
      public static final int LINE_DIRECTION_FIELD_NUMBER = 3;
      public static final int LINE_NAME_FIELD_NUMBER = 1;
      public static final int LINE_UID_FIELD_NUMBER = 2;
      public static final int STATION_NAME_FIELD_NUMBER = 4;
      public static final int TIP_RTBUS_FIELD_NUMBER = 5;
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
      
      public static RecommendLines parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new RecommendLines().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static RecommendLines parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (RecommendLines)new RecommendLines().mergeFrom(paramArrayOfByte);
      }
      
      public final RecommendLines clear()
      {
        clearLineName();
        clearLineUid();
        clearLineDirection();
        clearStationName();
        clearTipRtbus();
        this.k = -1;
        return this;
      }
      
      public RecommendLines clearLineDirection()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public RecommendLines clearLineName()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public RecommendLines clearLineUid()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public RecommendLines clearStationName()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public RecommendLines clearTipRtbus()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.k < 0) {
          getSerializedSize();
        }
        return this.k;
      }
      
      public String getLineDirection()
      {
        return this.f;
      }
      
      public String getLineName()
      {
        return this.b;
      }
      
      public String getLineUid()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int n = 0;
        if (hasLineName()) {
          n = 0 + CodedOutputStreamMicro.computeStringSize(1, getLineName());
        }
        int m = n;
        if (hasLineUid()) {
          m = n + CodedOutputStreamMicro.computeStringSize(2, getLineUid());
        }
        n = m;
        if (hasLineDirection()) {
          n = m + CodedOutputStreamMicro.computeStringSize(3, getLineDirection());
        }
        m = n;
        if (hasStationName()) {
          m = n + CodedOutputStreamMicro.computeStringSize(4, getStationName());
        }
        n = m;
        if (hasTipRtbus()) {
          n = m + CodedOutputStreamMicro.computeStringSize(5, getTipRtbus());
        }
        this.k = n;
        return n;
      }
      
      public String getStationName()
      {
        return this.h;
      }
      
      public String getTipRtbus()
      {
        return this.j;
      }
      
      public boolean hasLineDirection()
      {
        return this.e;
      }
      
      public boolean hasLineName()
      {
        return this.a;
      }
      
      public boolean hasLineUid()
      {
        return this.c;
      }
      
      public boolean hasStationName()
      {
        return this.g;
      }
      
      public boolean hasTipRtbus()
      {
        return this.i;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public RecommendLines mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setLineName(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setLineUid(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setLineDirection(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setStationName(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setTipRtbus(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public RecommendLines setLineDirection(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public RecommendLines setLineName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public RecommendLines setLineUid(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public RecommendLines setStationName(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public RecommendLines setTipRtbus(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasLineName()) {
          paramCodedOutputStreamMicro.writeString(1, getLineName());
        }
        if (hasLineUid()) {
          paramCodedOutputStreamMicro.writeString(2, getLineUid());
        }
        if (hasLineDirection()) {
          paramCodedOutputStreamMicro.writeString(3, getLineDirection());
        }
        if (hasStationName()) {
          paramCodedOutputStreamMicro.writeString(4, getStationName());
        }
        if (hasTipRtbus()) {
          paramCodedOutputStreamMicro.writeString(5, getTipRtbus());
        }
      }
    }
    
    public static final class Stations
      extends MessageMicro
    {
      public static final int DIS_FIELD_NUMBER = 2;
      public static final int LINES_FIELD_NUMBER = 3;
      public static final int NAME_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private int d = 0;
      private List<Rtbl.Content.Lines> e = Collections.emptyList();
      private int f = -1;
      
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
      
      public Stations addLines(Rtbl.Content.Lines paramLines)
      {
        if (paramLines == null) {
          return this;
        }
        if (this.e.isEmpty()) {
          this.e = new ArrayList();
        }
        this.e.add(paramLines);
        return this;
      }
      
      public final Stations clear()
      {
        clearName();
        clearDis();
        clearLines();
        this.f = -1;
        return this;
      }
      
      public Stations clearDis()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public Stations clearLines()
      {
        this.e = Collections.emptyList();
        return this;
      }
      
      public Stations clearName()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.f < 0) {
          getSerializedSize();
        }
        return this.f;
      }
      
      public int getDis()
      {
        return this.d;
      }
      
      public Rtbl.Content.Lines getLines(int paramInt)
      {
        return (Rtbl.Content.Lines)this.e.get(paramInt);
      }
      
      public int getLinesCount()
      {
        return this.e.size();
      }
      
      public List<Rtbl.Content.Lines> getLinesList()
      {
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
        if (hasDis()) {
          j = i + CodedOutputStreamMicro.computeInt32Size(2, getDis());
        }
        Iterator localIterator = getLinesList().iterator();
        while (localIterator.hasNext()) {
          j = CodedOutputStreamMicro.computeMessageSize(3, (Rtbl.Content.Lines)localIterator.next()) + j;
        }
        this.f = j;
        return j;
      }
      
      public boolean hasDis()
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
      
      public Stations mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          case 16: 
            setDis(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            Rtbl.Content.Lines localLines = new Rtbl.Content.Lines();
            paramCodedInputStreamMicro.readMessage(localLines);
            addLines(localLines);
          }
        }
      }
      
      public Stations setDis(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public Stations setLines(int paramInt, Rtbl.Content.Lines paramLines)
      {
        if (paramLines == null) {
          return this;
        }
        this.e.set(paramInt, paramLines);
        return this;
      }
      
      public Stations setName(String paramString)
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
        if (hasDis()) {
          paramCodedOutputStreamMicro.writeInt32(2, getDis());
        }
        Iterator localIterator = getLinesList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(3, (Rtbl.Content.Lines)localIterator.next());
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int RETURN_ALL_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private int e = -1;
    
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
      clearReturnAll();
      clearError();
      this.e = -1;
      return this;
    }
    
    public Option clearError()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Option clearReturnAll()
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
    
    public int getError()
    {
      return this.d;
    }
    
    public int getReturnAll()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasReturnAll()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getReturnAll());
      }
      int j = i;
      if (hasError()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(2, getError());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasError()
    {
      return this.c;
    }
    
    public boolean hasReturnAll()
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
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setReturnAll(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setError(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setError(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Option setReturnAll(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasReturnAll()) {
        paramCodedOutputStreamMicro.writeInt32(1, getReturnAll());
      }
      if (hasError()) {
        paramCodedOutputStreamMicro.writeInt32(2, getError());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Rtbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */