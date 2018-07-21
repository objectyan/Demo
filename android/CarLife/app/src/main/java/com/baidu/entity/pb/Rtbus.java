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

public final class Rtbus
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Content d = null;
  private int e = -1;
  
  public static Rtbus parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Rtbus().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Rtbus parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Rtbus)new Rtbus().mergeFrom(paramArrayOfByte);
  }
  
  public final Rtbus clear()
  {
    clearOption();
    clearContent();
    this.e = -1;
    return this;
  }
  
  public Rtbus clearContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Rtbus clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
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
    int i = 0;
    if (hasOption()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    int j = i;
    if (hasContent()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(2, getContent());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasContent()
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
  
  public Rtbus mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      }
    }
  }
  
  public Rtbus setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.c = true;
    this.d = paramContent;
    return this;
  }
  
  public Rtbus setOption(Option paramOption)
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
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int RTBUS_NU_FIELD_NUMBER = 1;
    public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 2;
    public static final int RTBUS_VERSION_FIELD_NUMBER = 3;
    public static final int STATIONS_FIELD_NUMBER = 4;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private List<Station> g = Collections.emptyList();
    private int h = -1;
    
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
    
    public Content addStations(Station paramStation)
    {
      if (paramStation == null) {
        return this;
      }
      if (this.g.isEmpty()) {
        this.g = new ArrayList();
      }
      this.g.add(paramStation);
      return this;
    }
    
    public final Content clear()
    {
      clearRtbusNu();
      clearRtbusUpdateTime();
      clearRtbusVersion();
      clearStations();
      this.h = -1;
      return this;
    }
    
    public Content clearRtbusNu()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Content clearRtbusUpdateTime()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Content clearRtbusVersion()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Content clearStations()
    {
      this.g = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.h < 0) {
        getSerializedSize();
      }
      return this.h;
    }
    
    public int getRtbusNu()
    {
      return this.b;
    }
    
    public int getRtbusUpdateTime()
    {
      return this.d;
    }
    
    public int getRtbusVersion()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasRtbusNu()) {
        j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getRtbusNu());
      }
      int i = j;
      if (hasRtbusUpdateTime()) {
        i = j + CodedOutputStreamMicro.computeInt32Size(2, getRtbusUpdateTime());
      }
      j = i;
      if (hasRtbusVersion()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getRtbusVersion());
      }
      Iterator localIterator = getStationsList().iterator();
      while (localIterator.hasNext()) {
        j = CodedOutputStreamMicro.computeMessageSize(4, (Station)localIterator.next()) + j;
      }
      this.h = j;
      return j;
    }
    
    public Station getStations(int paramInt)
    {
      return (Station)this.g.get(paramInt);
    }
    
    public int getStationsCount()
    {
      return this.g.size();
    }
    
    public List<Station> getStationsList()
    {
      return this.g;
    }
    
    public boolean hasRtbusNu()
    {
      return this.a;
    }
    
    public boolean hasRtbusUpdateTime()
    {
      return this.c;
    }
    
    public boolean hasRtbusVersion()
    {
      return this.e;
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
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setRtbusNu(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setRtbusUpdateTime(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setRtbusVersion(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          Station localStation = new Station();
          paramCodedInputStreamMicro.readMessage(localStation);
          addStations(localStation);
        }
      }
    }
    
    public Content setRtbusNu(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Content setRtbusUpdateTime(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Content setRtbusVersion(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Content setStations(int paramInt, Station paramStation)
    {
      if (paramStation == null) {
        return this;
      }
      this.g.set(paramInt, paramStation);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasRtbusNu()) {
        paramCodedOutputStreamMicro.writeInt32(1, getRtbusNu());
      }
      if (hasRtbusUpdateTime()) {
        paramCodedOutputStreamMicro.writeInt32(2, getRtbusUpdateTime());
      }
      if (hasRtbusVersion()) {
        paramCodedOutputStreamMicro.writeInt32(3, getRtbusVersion());
      }
      Iterator localIterator = getStationsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(4, (Station)localIterator.next());
      }
    }
    
    public static final class Station
      extends MessageMicro
    {
      public static final int IMAGE_TIP_RTBUS_FIELD_NUMBER = 6;
      public static final int LINE_FIELD_NUMBER = 4;
      public static final int NAME_FIELD_NUMBER = 2;
      public static final int NEXT_BUS_INFO_FIELD_NUMBER = 5;
      public static final int TIP_RTBUS_FIELD_NUMBER = 3;
      public static final int UID_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private Line h = null;
      private boolean i;
      private NextBusInfo j = null;
      private boolean k;
      private String l = "";
      private int m = -1;
      
      public static Station parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Station().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Station parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Station)new Station().mergeFrom(paramArrayOfByte);
      }
      
      public final Station clear()
      {
        clearUid();
        clearName();
        clearTipRtbus();
        clearLine();
        clearNextBusInfo();
        clearImageTipRtbus();
        this.m = -1;
        return this;
      }
      
      public Station clearImageTipRtbus()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public Station clearLine()
      {
        this.g = false;
        this.h = null;
        return this;
      }
      
      public Station clearName()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Station clearNextBusInfo()
      {
        this.i = false;
        this.j = null;
        return this;
      }
      
      public Station clearTipRtbus()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Station clearUid()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.m < 0) {
          getSerializedSize();
        }
        return this.m;
      }
      
      public String getImageTipRtbus()
      {
        return this.l;
      }
      
      public Line getLine()
      {
        return this.h;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public NextBusInfo getNextBusInfo()
      {
        return this.j;
      }
      
      public int getSerializedSize()
      {
        int i1 = 0;
        if (hasUid()) {
          i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
        }
        int n = i1;
        if (hasName()) {
          n = i1 + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        i1 = n;
        if (hasTipRtbus()) {
          i1 = n + CodedOutputStreamMicro.computeStringSize(3, getTipRtbus());
        }
        n = i1;
        if (hasLine()) {
          n = i1 + CodedOutputStreamMicro.computeMessageSize(4, getLine());
        }
        i1 = n;
        if (hasNextBusInfo()) {
          i1 = n + CodedOutputStreamMicro.computeMessageSize(5, getNextBusInfo());
        }
        n = i1;
        if (hasImageTipRtbus()) {
          n = i1 + CodedOutputStreamMicro.computeStringSize(6, getImageTipRtbus());
        }
        this.m = n;
        return n;
      }
      
      public String getTipRtbus()
      {
        return this.f;
      }
      
      public String getUid()
      {
        return this.b;
      }
      
      public boolean hasImageTipRtbus()
      {
        return this.k;
      }
      
      public boolean hasLine()
      {
        return this.g;
      }
      
      public boolean hasName()
      {
        return this.c;
      }
      
      public boolean hasNextBusInfo()
      {
        return this.i;
      }
      
      public boolean hasTipRtbus()
      {
        return this.e;
      }
      
      public boolean hasUid()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Station mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int n = paramCodedInputStreamMicro.readTag();
          Object localObject;
          switch (n)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
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
            setTipRtbus(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            localObject = new Line();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setLine((Line)localObject);
            break;
          case 42: 
            localObject = new NextBusInfo();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setNextBusInfo((NextBusInfo)localObject);
            break;
          case 50: 
            setImageTipRtbus(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Station setImageTipRtbus(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public Station setLine(Line paramLine)
      {
        if (paramLine == null) {
          return clearLine();
        }
        this.g = true;
        this.h = paramLine;
        return this;
      }
      
      public Station setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Station setNextBusInfo(NextBusInfo paramNextBusInfo)
      {
        if (paramNextBusInfo == null) {
          return clearNextBusInfo();
        }
        this.i = true;
        this.j = paramNextBusInfo;
        return this;
      }
      
      public Station setTipRtbus(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Station setUid(String paramString)
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
        if (hasTipRtbus()) {
          paramCodedOutputStreamMicro.writeString(3, getTipRtbus());
        }
        if (hasLine()) {
          paramCodedOutputStreamMicro.writeMessage(4, getLine());
        }
        if (hasNextBusInfo()) {
          paramCodedOutputStreamMicro.writeMessage(5, getNextBusInfo());
        }
        if (hasImageTipRtbus()) {
          paramCodedOutputStreamMicro.writeString(6, getImageTipRtbus());
        }
      }
      
      public static final class Line
        extends MessageMicro
      {
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int RAW_NAME_FIELD_NUMBER = 3;
        public static final int UID_FIELD_NUMBER = 1;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private String f = "";
        private int g = -1;
        
        public static Line parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Line().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Line parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Line)new Line().mergeFrom(paramArrayOfByte);
        }
        
        public final Line clear()
        {
          clearUid();
          clearName();
          clearRawName();
          this.g = -1;
          return this;
        }
        
        public Line clearName()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public Line clearRawName()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public Line clearUid()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.g < 0) {
            getSerializedSize();
          }
          return this.g;
        }
        
        public String getName()
        {
          return this.d;
        }
        
        public String getRawName()
        {
          return this.f;
        }
        
        public int getSerializedSize()
        {
          int j = 0;
          if (hasUid()) {
            j = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
          }
          int i = j;
          if (hasName()) {
            i = j + CodedOutputStreamMicro.computeStringSize(2, getName());
          }
          j = i;
          if (hasRawName()) {
            j = i + CodedOutputStreamMicro.computeStringSize(3, getRawName());
          }
          this.g = j;
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
        
        public boolean hasRawName()
        {
          return this.e;
        }
        
        public boolean hasUid()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Line mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setRawName(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Line setName(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public Line setRawName(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public Line setUid(String paramString)
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
          if (hasRawName()) {
            paramCodedOutputStreamMicro.writeString(3, getRawName());
          }
        }
      }
      
      public static final class NextBusInfo
        extends MessageMicro
      {
        public static final int REMAIN_DIST_FIELD_NUMBER = 1;
        public static final int REMAIN_STOPS_FIELD_NUMBER = 2;
        public static final int REMAIN_TIME_FIELD_NUMBER = 3;
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
          clearRemainDist();
          clearRemainStops();
          clearRemainTime();
          clearX();
          clearY();
          clearSpath();
          this.l = -1;
          return this;
        }
        
        public NextBusInfo clearRemainDist()
        {
          this.a = false;
          this.b = 0;
          return this;
        }
        
        public NextBusInfo clearRemainStops()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public NextBusInfo clearRemainTime()
        {
          this.e = false;
          this.f = 0;
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
        
        public int getRemainDist()
        {
          return this.b;
        }
        
        public int getRemainStops()
        {
          return this.d;
        }
        
        public int getRemainTime()
        {
          return this.f;
        }
        
        public int getSerializedSize()
        {
          int i1 = 0;
          if (hasRemainDist()) {}
          for (int n = CodedOutputStreamMicro.computeInt32Size(1, getRemainDist()) + 0;; n = 0)
          {
            int m = n;
            if (hasRemainStops()) {
              m = n + CodedOutputStreamMicro.computeInt32Size(2, getRemainStops());
            }
            n = m;
            if (hasRemainTime()) {
              n = m + CodedOutputStreamMicro.computeInt32Size(3, getRemainTime());
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
        
        public boolean hasRemainDist()
        {
          return this.a;
        }
        
        public boolean hasRemainStops()
        {
          return this.c;
        }
        
        public boolean hasRemainTime()
        {
          return this.e;
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
              setRemainDist(paramCodedInputStreamMicro.readInt32());
              break;
            case 16: 
              setRemainStops(paramCodedInputStreamMicro.readInt32());
              break;
            case 24: 
              setRemainTime(paramCodedInputStreamMicro.readInt32());
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
        
        public NextBusInfo setRemainDist(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public NextBusInfo setRemainStops(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public NextBusInfo setRemainTime(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
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
          if (hasRemainDist()) {
            paramCodedOutputStreamMicro.writeInt32(1, getRemainDist());
          }
          if (hasRemainStops()) {
            paramCodedOutputStreamMicro.writeInt32(2, getRemainStops());
          }
          if (hasRemainTime()) {
            paramCodedOutputStreamMicro.writeInt32(3, getRemainTime());
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
  
  public static final class Option
    extends MessageMicro
  {
    public static final int HAS_RTBUS_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private int c = -1;
    
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
      clearHasRtbus();
      this.c = -1;
      return this;
    }
    
    public Option clearHasRtbus()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.c < 0) {
        getSerializedSize();
      }
      return this.c;
    }
    
    public int getHasRtbus()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasHasRtbus()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getHasRtbus());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasHasRtbus()
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
          setHasRtbus(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setHasRtbus(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasHasRtbus()) {
        paramCodedOutputStreamMicro.writeInt32(1, getHasRtbus());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Rtbus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */