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

public final class ScopePlan
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Content d = null;
  private int e = -1;
  
  public static ScopePlan parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new ScopePlan().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static ScopePlan parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (ScopePlan)new ScopePlan().mergeFrom(paramArrayOfByte);
  }
  
  public final ScopePlan clear()
  {
    clearOption();
    clearContent();
    this.e = -1;
    return this;
  }
  
  public ScopePlan clearContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public ScopePlan clearOption()
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
  
  public ScopePlan mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
  
  public ScopePlan setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.c = true;
    this.d = paramContent;
    return this;
  }
  
  public ScopePlan setOption(Option paramOption)
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
    public static final int ROUTES_FIELD_NUMBER = 1;
    private List<Routes> a = Collections.emptyList();
    private int b = -1;
    
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
    
    public final Content clear()
    {
      clearRoutes();
      this.b = -1;
      return this;
    }
    
    public Content clearRoutes()
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
        case 10: 
          Routes localRoutes = new Routes();
          paramCodedInputStreamMicro.readMessage(localRoutes);
          addRoutes(localRoutes);
        }
      }
    }
    
    public Content setRoutes(int paramInt, Routes paramRoutes)
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
      public static final int LEGS_FIELD_NUMBER = 1;
      public static final int ROUTE_EXT_FIELD_NUMBER = 3;
      public static final int TAGS_FIELD_NUMBER = 2;
      private List<Legs> a = Collections.emptyList();
      private List<String> b = Collections.emptyList();
      private boolean c;
      private String d = "";
      private int e = -1;
      
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
      
      public Routes addTags(String paramString)
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
      
      public final Routes clear()
      {
        clearLegs();
        clearTags();
        clearRouteExt();
        this.e = -1;
        return this;
      }
      
      public Routes clearLegs()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public Routes clearRouteExt()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Routes clearTags()
      {
        this.b = Collections.emptyList();
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.e < 0) {
          getSerializedSize();
        }
        return this.e;
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
      
      public String getRouteExt()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        Iterator localIterator = getLegsList().iterator();
        for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Legs)localIterator.next()) + i) {}
        localIterator = getTagsList().iterator();
        while (localIterator.hasNext()) {
          j += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
        }
        j = i + j + getTagsList().size() * 1;
        i = j;
        if (hasRouteExt()) {
          i = j + CodedOutputStreamMicro.computeStringSize(3, getRouteExt());
        }
        this.e = i;
        return i;
      }
      
      public String getTags(int paramInt)
      {
        return (String)this.b.get(paramInt);
      }
      
      public int getTagsCount()
      {
        return this.b.size();
      }
      
      public List<String> getTagsList()
      {
        return this.b;
      }
      
      public boolean hasRouteExt()
      {
        return this.c;
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
            break;
          case 18: 
            addTags(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setRouteExt(paramCodedInputStreamMicro.readString());
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
      
      public Routes setRouteExt(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Routes setTags(int paramInt, String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.b.set(paramInt, paramString);
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getLegsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(1, (Legs)localIterator.next());
        }
        localIterator = getTagsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeString(2, (String)localIterator.next());
        }
        if (hasRouteExt()) {
          paramCodedOutputStreamMicro.writeString(3, getRouteExt());
        }
      }
      
      public static final class Legs
        extends MessageMicro
      {
        public static final int AUDIO_URL_FIELD_NUMBER = 12;
        public static final int COLOR_FIELD_NUMBER = 14;
        public static final int DESCRIPTION_FIELD_NUMBER = 9;
        public static final int DISTANCE_FIELD_NUMBER = 5;
        public static final int DURATION_FIELD_NUMBER = 6;
        public static final int END_LOCATION_FIELD_NUMBER = 2;
        public static final int END_NAME_FIELD_NUMBER = 4;
        public static final int PRIORITY_FIELD_NUMBER = 8;
        public static final int SCENE_EXT_FIELD_NUMBER = 15;
        public static final int SPATH_FIELD_NUMBER = 11;
        public static final int START_LOCATION_FIELD_NUMBER = 1;
        public static final int START_NAME_FIELD_NUMBER = 3;
        public static final int TEXT_FIELD_NUMBER = 13;
        public static final int TYPE_FIELD_NUMBER = 10;
        public static final int UID_FIELD_NUMBER = 7;
        private String A = "";
        private int B = -1;
        private List<Double> a = Collections.emptyList();
        private List<Double> b = Collections.emptyList();
        private boolean c;
        private String d = "";
        private boolean e;
        private String f = "";
        private boolean g;
        private int h = 0;
        private boolean i;
        private int j = 0;
        private boolean k;
        private String l = "";
        private boolean m;
        private int n = 0;
        private boolean o;
        private String p = "";
        private boolean q;
        private int r = 0;
        private List<Double> s = Collections.emptyList();
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
        
        public Legs addEndLocation(double paramDouble)
        {
          if (this.b.isEmpty()) {
            this.b = new ArrayList();
          }
          this.b.add(Double.valueOf(paramDouble));
          return this;
        }
        
        public Legs addSpath(double paramDouble)
        {
          if (this.s.isEmpty()) {
            this.s = new ArrayList();
          }
          this.s.add(Double.valueOf(paramDouble));
          return this;
        }
        
        public Legs addStartLocation(double paramDouble)
        {
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(Double.valueOf(paramDouble));
          return this;
        }
        
        public final Legs clear()
        {
          clearStartLocation();
          clearEndLocation();
          clearStartName();
          clearEndName();
          clearDistance();
          clearDuration();
          clearUid();
          clearPriority();
          clearDescription();
          clearType();
          clearSpath();
          clearAudioUrl();
          clearText();
          clearColor();
          clearSceneExt();
          this.B = -1;
          return this;
        }
        
        public Legs clearAudioUrl()
        {
          this.t = false;
          this.u = "";
          return this;
        }
        
        public Legs clearColor()
        {
          this.x = false;
          this.y = "";
          return this;
        }
        
        public Legs clearDescription()
        {
          this.o = false;
          this.p = "";
          return this;
        }
        
        public Legs clearDistance()
        {
          this.g = false;
          this.h = 0;
          return this;
        }
        
        public Legs clearDuration()
        {
          this.i = false;
          this.j = 0;
          return this;
        }
        
        public Legs clearEndLocation()
        {
          this.b = Collections.emptyList();
          return this;
        }
        
        public Legs clearEndName()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public Legs clearPriority()
        {
          this.m = false;
          this.n = 0;
          return this;
        }
        
        public Legs clearSceneExt()
        {
          this.z = false;
          this.A = "";
          return this;
        }
        
        public Legs clearSpath()
        {
          this.s = Collections.emptyList();
          return this;
        }
        
        public Legs clearStartLocation()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public Legs clearStartName()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public Legs clearText()
        {
          this.v = false;
          this.w = "";
          return this;
        }
        
        public Legs clearType()
        {
          this.q = false;
          this.r = 0;
          return this;
        }
        
        public Legs clearUid()
        {
          this.k = false;
          this.l = "";
          return this;
        }
        
        public String getAudioUrl()
        {
          return this.u;
        }
        
        public int getCachedSize()
        {
          if (this.B < 0) {
            getSerializedSize();
          }
          return this.B;
        }
        
        public String getColor()
        {
          return this.y;
        }
        
        public String getDescription()
        {
          return this.p;
        }
        
        public int getDistance()
        {
          return this.h;
        }
        
        public int getDuration()
        {
          return this.j;
        }
        
        public double getEndLocation(int paramInt)
        {
          return ((Double)this.b.get(paramInt)).doubleValue();
        }
        
        public int getEndLocationCount()
        {
          return this.b.size();
        }
        
        public List<Double> getEndLocationList()
        {
          return this.b;
        }
        
        public String getEndName()
        {
          return this.f;
        }
        
        public int getPriority()
        {
          return this.n;
        }
        
        public String getSceneExt()
        {
          return this.A;
        }
        
        public int getSerializedSize()
        {
          int i2 = 0 + getStartLocationList().size() * 8 + getStartLocationList().size() * 1 + getEndLocationList().size() * 8 + getEndLocationList().size() * 1;
          int i1 = i2;
          if (hasStartName()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(3, getStartName());
          }
          i2 = i1;
          if (hasEndName()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(4, getEndName());
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
          if (hasUid()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getUid());
          }
          i2 = i1;
          if (hasPriority()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(8, getPriority());
          }
          i1 = i2;
          if (hasDescription()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(9, getDescription());
          }
          i2 = i1;
          if (hasType()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(10, getType());
          }
          i2 = i2 + getSpathList().size() * 8 + getSpathList().size() * 1;
          i1 = i2;
          if (hasAudioUrl()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getAudioUrl());
          }
          i2 = i1;
          if (hasText()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getText());
          }
          i1 = i2;
          if (hasColor()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getColor());
          }
          i2 = i1;
          if (hasSceneExt()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getSceneExt());
          }
          this.B = i2;
          return i2;
        }
        
        public double getSpath(int paramInt)
        {
          return ((Double)this.s.get(paramInt)).doubleValue();
        }
        
        public int getSpathCount()
        {
          return this.s.size();
        }
        
        public List<Double> getSpathList()
        {
          return this.s;
        }
        
        public double getStartLocation(int paramInt)
        {
          return ((Double)this.a.get(paramInt)).doubleValue();
        }
        
        public int getStartLocationCount()
        {
          return this.a.size();
        }
        
        public List<Double> getStartLocationList()
        {
          return this.a;
        }
        
        public String getStartName()
        {
          return this.d;
        }
        
        public String getText()
        {
          return this.w;
        }
        
        public int getType()
        {
          return this.r;
        }
        
        public String getUid()
        {
          return this.l;
        }
        
        public boolean hasAudioUrl()
        {
          return this.t;
        }
        
        public boolean hasColor()
        {
          return this.x;
        }
        
        public boolean hasDescription()
        {
          return this.o;
        }
        
        public boolean hasDistance()
        {
          return this.g;
        }
        
        public boolean hasDuration()
        {
          return this.i;
        }
        
        public boolean hasEndName()
        {
          return this.e;
        }
        
        public boolean hasPriority()
        {
          return this.m;
        }
        
        public boolean hasSceneExt()
        {
          return this.z;
        }
        
        public boolean hasStartName()
        {
          return this.c;
        }
        
        public boolean hasText()
        {
          return this.v;
        }
        
        public boolean hasType()
        {
          return this.q;
        }
        
        public boolean hasUid()
        {
          return this.k;
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
            switch (i1)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
              break;
            case 0: 
              return this;
            case 9: 
              addStartLocation(paramCodedInputStreamMicro.readDouble());
              break;
            case 17: 
              addEndLocation(paramCodedInputStreamMicro.readDouble());
              break;
            case 26: 
              setStartName(paramCodedInputStreamMicro.readString());
              break;
            case 34: 
              setEndName(paramCodedInputStreamMicro.readString());
              break;
            case 40: 
              setDistance(paramCodedInputStreamMicro.readInt32());
              break;
            case 48: 
              setDuration(paramCodedInputStreamMicro.readInt32());
              break;
            case 58: 
              setUid(paramCodedInputStreamMicro.readString());
              break;
            case 64: 
              setPriority(paramCodedInputStreamMicro.readInt32());
              break;
            case 74: 
              setDescription(paramCodedInputStreamMicro.readString());
              break;
            case 80: 
              setType(paramCodedInputStreamMicro.readInt32());
              break;
            case 89: 
              addSpath(paramCodedInputStreamMicro.readDouble());
              break;
            case 98: 
              setAudioUrl(paramCodedInputStreamMicro.readString());
              break;
            case 106: 
              setText(paramCodedInputStreamMicro.readString());
              break;
            case 114: 
              setColor(paramCodedInputStreamMicro.readString());
              break;
            case 122: 
              setSceneExt(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Legs setAudioUrl(String paramString)
        {
          this.t = true;
          this.u = paramString;
          return this;
        }
        
        public Legs setColor(String paramString)
        {
          this.x = true;
          this.y = paramString;
          return this;
        }
        
        public Legs setDescription(String paramString)
        {
          this.o = true;
          this.p = paramString;
          return this;
        }
        
        public Legs setDistance(int paramInt)
        {
          this.g = true;
          this.h = paramInt;
          return this;
        }
        
        public Legs setDuration(int paramInt)
        {
          this.i = true;
          this.j = paramInt;
          return this;
        }
        
        public Legs setEndLocation(int paramInt, double paramDouble)
        {
          this.b.set(paramInt, Double.valueOf(paramDouble));
          return this;
        }
        
        public Legs setEndName(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public Legs setPriority(int paramInt)
        {
          this.m = true;
          this.n = paramInt;
          return this;
        }
        
        public Legs setSceneExt(String paramString)
        {
          this.z = true;
          this.A = paramString;
          return this;
        }
        
        public Legs setSpath(int paramInt, double paramDouble)
        {
          this.s.set(paramInt, Double.valueOf(paramDouble));
          return this;
        }
        
        public Legs setStartLocation(int paramInt, double paramDouble)
        {
          this.a.set(paramInt, Double.valueOf(paramDouble));
          return this;
        }
        
        public Legs setStartName(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public Legs setText(String paramString)
        {
          this.v = true;
          this.w = paramString;
          return this;
        }
        
        public Legs setType(int paramInt)
        {
          this.q = true;
          this.r = paramInt;
          return this;
        }
        
        public Legs setUid(String paramString)
        {
          this.k = true;
          this.l = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getStartLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeDouble(1, ((Double)localIterator.next()).doubleValue());
          }
          localIterator = getEndLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeDouble(2, ((Double)localIterator.next()).doubleValue());
          }
          if (hasStartName()) {
            paramCodedOutputStreamMicro.writeString(3, getStartName());
          }
          if (hasEndName()) {
            paramCodedOutputStreamMicro.writeString(4, getEndName());
          }
          if (hasDistance()) {
            paramCodedOutputStreamMicro.writeInt32(5, getDistance());
          }
          if (hasDuration()) {
            paramCodedOutputStreamMicro.writeInt32(6, getDuration());
          }
          if (hasUid()) {
            paramCodedOutputStreamMicro.writeString(7, getUid());
          }
          if (hasPriority()) {
            paramCodedOutputStreamMicro.writeInt32(8, getPriority());
          }
          if (hasDescription()) {
            paramCodedOutputStreamMicro.writeString(9, getDescription());
          }
          if (hasType()) {
            paramCodedOutputStreamMicro.writeInt32(10, getType());
          }
          localIterator = getSpathList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeDouble(11, ((Double)localIterator.next()).doubleValue());
          }
          if (hasAudioUrl()) {
            paramCodedOutputStreamMicro.writeString(12, getAudioUrl());
          }
          if (hasText()) {
            paramCodedOutputStreamMicro.writeString(13, getText());
          }
          if (hasColor()) {
            paramCodedOutputStreamMicro.writeString(14, getColor());
          }
          if (hasSceneExt()) {
            paramCodedOutputStreamMicro.writeString(15, getSceneExt());
          }
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int PN_FIELD_NUMBER = 3;
    public static final int RN_FIELD_NUMBER = 4;
    public static final int SY_FIELD_NUMBER = 5;
    public static final int TOTAL_FIELD_NUMBER = 2;
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
    private int k = -1;
    
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
      clearError();
      clearTotal();
      clearPn();
      clearRn();
      clearSy();
      this.k = -1;
      return this;
    }
    
    public Option clearError()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Option clearPn()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Option clearRn()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Option clearSy()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public Option clearTotal()
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
    
    public int getError()
    {
      return this.b;
    }
    
    public int getPn()
    {
      return this.f;
    }
    
    public int getRn()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasError()) {
        n = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
      }
      int m = n;
      if (hasTotal()) {
        m = n + CodedOutputStreamMicro.computeInt32Size(2, getTotal());
      }
      n = m;
      if (hasPn()) {
        n = m + CodedOutputStreamMicro.computeInt32Size(3, getPn());
      }
      m = n;
      if (hasRn()) {
        m = n + CodedOutputStreamMicro.computeInt32Size(4, getRn());
      }
      n = m;
      if (hasSy()) {
        n = m + CodedOutputStreamMicro.computeInt32Size(5, getSy());
      }
      this.k = n;
      return n;
    }
    
    public int getSy()
    {
      return this.j;
    }
    
    public int getTotal()
    {
      return this.d;
    }
    
    public boolean hasError()
    {
      return this.a;
    }
    
    public boolean hasPn()
    {
      return this.e;
    }
    
    public boolean hasRn()
    {
      return this.g;
    }
    
    public boolean hasSy()
    {
      return this.i;
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
        int m = paramCodedInputStreamMicro.readTag();
        switch (m)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setError(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setTotal(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setPn(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setRn(paramCodedInputStreamMicro.readInt32());
          break;
        case 40: 
          setSy(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setError(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Option setPn(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Option setRn(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Option setSy(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public Option setTotal(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasError()) {
        paramCodedOutputStreamMicro.writeInt32(1, getError());
      }
      if (hasTotal()) {
        paramCodedOutputStreamMicro.writeInt32(2, getTotal());
      }
      if (hasPn()) {
        paramCodedOutputStreamMicro.writeInt32(3, getPn());
      }
      if (hasRn()) {
        paramCodedOutputStreamMicro.writeInt32(4, getRn());
      }
      if (hasSy()) {
        paramCodedOutputStreamMicro.writeInt32(5, getSy());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/ScopePlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */