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

public final class IndoorNavi
  extends MessageMicro
{
  public static final int OPTION_FIELD_NUMBER = 1;
  public static final int ROUTES_FIELD_NUMBER = 2;
  private boolean a;
  private Option b = null;
  private List<Routes> c = Collections.emptyList();
  private int d = -1;
  
  public static IndoorNavi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new IndoorNavi().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static IndoorNavi parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (IndoorNavi)new IndoorNavi().mergeFrom(paramArrayOfByte);
  }
  
  public IndoorNavi addRoutes(Routes paramRoutes)
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
  
  public final IndoorNavi clear()
  {
    clearOption();
    clearRoutes();
    this.d = -1;
    return this;
  }
  
  public IndoorNavi clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public IndoorNavi clearRoutes()
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
  
  public Option getOption()
  {
    return this.b;
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
    int i = 0;
    if (hasOption()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    Iterator localIterator = getRoutesList().iterator();
    while (localIterator.hasNext()) {
      i = CodedOutputStreamMicro.computeMessageSize(2, (Routes)localIterator.next()) + i;
    }
    this.d = i;
    return i;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public IndoorNavi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Routes();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addRoutes((Routes)localObject);
      }
    }
  }
  
  public IndoorNavi setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.a = true;
    this.b = paramOption;
    return this;
  }
  
  public IndoorNavi setRoutes(int paramInt, Routes paramRoutes)
  {
    if (paramRoutes == null) {
      return this;
    }
    this.c.set(paramInt, paramRoutes);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(1, getOption());
    }
    Iterator localIterator = getRoutesList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (Routes)localIterator.next());
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int TOTAL_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 3;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private int g = -1;
    
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
      clearType();
      this.g = -1;
      return this;
    }
    
    public Option clearError()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Option clearTotal()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Option clearType()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public int getError()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasError()) {
        j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
      }
      int i = j;
      if (hasTotal()) {
        i = j + CodedOutputStreamMicro.computeInt32Size(2, getTotal());
      }
      j = i;
      if (hasType()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getType());
      }
      this.g = j;
      return j;
    }
    
    public int getTotal()
    {
      return this.d;
    }
    
    public int getType()
    {
      return this.f;
    }
    
    public boolean hasError()
    {
      return this.a;
    }
    
    public boolean hasTotal()
    {
      return this.c;
    }
    
    public boolean hasType()
    {
      return this.e;
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
          setError(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setTotal(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setType(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setError(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Option setTotal(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Option setType(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
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
      if (hasType()) {
        paramCodedOutputStreamMicro.writeInt32(3, getType());
      }
    }
  }
  
  public static final class Routes
    extends MessageMicro
  {
    public static final int DISTANCE_FIELD_NUMBER = 1;
    public static final int DURATION_FIELD_NUMBER = 2;
    public static final int LEGS_FIELD_NUMBER = 3;
    public static final int LOC_LEVEL_FIELD_NUMBER = 4;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private List<Legs> e = Collections.emptyList();
    private boolean f;
    private int g = 0;
    private int h = -1;
    
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
      clearDistance();
      clearDuration();
      clearLegs();
      clearLocLevel();
      this.h = -1;
      return this;
    }
    
    public Routes clearDistance()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Routes clearDuration()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Routes clearLegs()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public Routes clearLocLevel()
    {
      this.f = false;
      this.g = 0;
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
    
    public int getLocLevel()
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
      Iterator localIterator = getLegsList().iterator();
      for (i = j; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(3, (Legs)localIterator.next()) + i) {}
      j = i;
      if (hasLocLevel()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(4, getLocLevel());
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
    
    public boolean hasLocLevel()
    {
      return this.f;
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
        case 8: 
          setDistance(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setDuration(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          Legs localLegs = new Legs();
          paramCodedInputStreamMicro.readMessage(localLegs);
          addLegs(localLegs);
          break;
        case 32: 
          setLocLevel(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Routes setDistance(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Routes setDuration(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
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
    
    public Routes setLocLevel(int paramInt)
    {
      this.f = true;
      this.g = paramInt;
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
      Iterator localIterator = getLegsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (Legs)localIterator.next());
      }
      if (hasLocLevel()) {
        paramCodedOutputStreamMicro.writeInt32(4, getLocLevel());
      }
    }
    
    public static final class Legs
      extends MessageMicro
    {
      public static final int DISTANCE_FIELD_NUMBER = 3;
      public static final int DURATION_FIELD_NUMBER = 4;
      public static final int SEND_LOCATION_FIELD_NUMBER = 2;
      public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
      public static final int STEPS_FIELD_NUMBER = 5;
      private List<Double> a = Collections.emptyList();
      private List<Double> b = Collections.emptyList();
      private boolean c;
      private int d = 0;
      private boolean e;
      private int f = 0;
      private List<Steps> g = Collections.emptyList();
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
      
      public Legs addSendLocation(double paramDouble)
      {
        if (this.b.isEmpty()) {
          this.b = new ArrayList();
        }
        this.b.add(Double.valueOf(paramDouble));
        return this;
      }
      
      public Legs addSstartLocation(double paramDouble)
      {
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(Double.valueOf(paramDouble));
        return this;
      }
      
      public Legs addSteps(Steps paramSteps)
      {
        if (paramSteps == null) {
          return this;
        }
        if (this.g.isEmpty()) {
          this.g = new ArrayList();
        }
        this.g.add(paramSteps);
        return this;
      }
      
      public final Legs clear()
      {
        clearSstartLocation();
        clearSendLocation();
        clearDistance();
        clearDuration();
        clearSteps();
        this.h = -1;
        return this;
      }
      
      public Legs clearDistance()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public Legs clearDuration()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public Legs clearSendLocation()
      {
        this.b = Collections.emptyList();
        return this;
      }
      
      public Legs clearSstartLocation()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public Legs clearSteps()
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
      
      public int getDistance()
      {
        return this.d;
      }
      
      public int getDuration()
      {
        return this.f;
      }
      
      public double getSendLocation(int paramInt)
      {
        return ((Double)this.b.get(paramInt)).doubleValue();
      }
      
      public int getSendLocationCount()
      {
        return this.b.size();
      }
      
      public List<Double> getSendLocationList()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int j = 0 + getSstartLocationList().size() * 8 + getSstartLocationList().size() * 1 + getSendLocationList().size() * 8 + getSendLocationList().size() * 1;
        int i = j;
        if (hasDistance()) {
          i = j + CodedOutputStreamMicro.computeInt32Size(3, getDistance());
        }
        j = i;
        if (hasDuration()) {
          j = i + CodedOutputStreamMicro.computeInt32Size(4, getDuration());
        }
        Iterator localIterator = getStepsList().iterator();
        while (localIterator.hasNext()) {
          j = CodedOutputStreamMicro.computeMessageSize(5, (Steps)localIterator.next()) + j;
        }
        this.h = j;
        return j;
      }
      
      public double getSstartLocation(int paramInt)
      {
        return ((Double)this.a.get(paramInt)).doubleValue();
      }
      
      public int getSstartLocationCount()
      {
        return this.a.size();
      }
      
      public List<Double> getSstartLocationList()
      {
        return this.a;
      }
      
      public Steps getSteps(int paramInt)
      {
        return (Steps)this.g.get(paramInt);
      }
      
      public int getStepsCount()
      {
        return this.g.size();
      }
      
      public List<Steps> getStepsList()
      {
        return this.g;
      }
      
      public boolean hasDistance()
      {
        return this.c;
      }
      
      public boolean hasDuration()
      {
        return this.e;
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
          case 9: 
            addSstartLocation(paramCodedInputStreamMicro.readDouble());
            break;
          case 17: 
            addSendLocation(paramCodedInputStreamMicro.readDouble());
            break;
          case 24: 
            setDistance(paramCodedInputStreamMicro.readInt32());
            break;
          case 32: 
            setDuration(paramCodedInputStreamMicro.readInt32());
            break;
          case 42: 
            Steps localSteps = new Steps();
            paramCodedInputStreamMicro.readMessage(localSteps);
            addSteps(localSteps);
          }
        }
      }
      
      public Legs setDistance(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public Legs setDuration(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public Legs setSendLocation(int paramInt, double paramDouble)
      {
        this.b.set(paramInt, Double.valueOf(paramDouble));
        return this;
      }
      
      public Legs setSstartLocation(int paramInt, double paramDouble)
      {
        this.a.set(paramInt, Double.valueOf(paramDouble));
        return this;
      }
      
      public Legs setSteps(int paramInt, Steps paramSteps)
      {
        if (paramSteps == null) {
          return this;
        }
        this.g.set(paramInt, paramSteps);
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getSstartLocationList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeDouble(1, ((Double)localIterator.next()).doubleValue());
        }
        localIterator = getSendLocationList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeDouble(2, ((Double)localIterator.next()).doubleValue());
        }
        if (hasDistance()) {
          paramCodedOutputStreamMicro.writeInt32(3, getDistance());
        }
        if (hasDuration()) {
          paramCodedOutputStreamMicro.writeInt32(4, getDuration());
        }
        localIterator = getStepsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(5, (Steps)localIterator.next());
        }
      }
      
      public static final class Steps
        extends MessageMicro
      {
        public static final int BUILDINGID_FIELD_NUMBER = 10;
        public static final int DISTANCE_FIELD_NUMBER = 3;
        public static final int DURATION_FIELD_NUMBER = 4;
        public static final int FLOORID_FIELD_NUMBER = 7;
        public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
        public static final int POIS_FIELD_NUMBER = 9;
        public static final int SEND_LOCATION_FIELD_NUMBER = 2;
        public static final int SPATH_FIELD_NUMBER = 8;
        public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 6;
        private List<Double> a = Collections.emptyList();
        private List<Double> b = Collections.emptyList();
        private boolean c;
        private int d = 0;
        private boolean e;
        private int f = 0;
        private boolean g;
        private String h = "";
        private boolean i;
        private int j = 0;
        private boolean k;
        private String l = "";
        private List<Double> m = Collections.emptyList();
        private List<Pois> n = Collections.emptyList();
        private boolean o;
        private String p = "";
        private int q = -1;
        
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
        
        public Steps addPois(Pois paramPois)
        {
          if (paramPois == null) {
            return this;
          }
          if (this.n.isEmpty()) {
            this.n = new ArrayList();
          }
          this.n.add(paramPois);
          return this;
        }
        
        public Steps addSendLocation(double paramDouble)
        {
          if (this.b.isEmpty()) {
            this.b = new ArrayList();
          }
          this.b.add(Double.valueOf(paramDouble));
          return this;
        }
        
        public Steps addSpath(double paramDouble)
        {
          if (this.m.isEmpty()) {
            this.m = new ArrayList();
          }
          this.m.add(Double.valueOf(paramDouble));
          return this;
        }
        
        public Steps addSstartLocation(double paramDouble)
        {
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(Double.valueOf(paramDouble));
          return this;
        }
        
        public final Steps clear()
        {
          clearSstartLocation();
          clearSendLocation();
          clearDistance();
          clearDuration();
          clearInstructions();
          clearType();
          clearFloorid();
          clearSpath();
          clearPois();
          clearBuildingid();
          this.q = -1;
          return this;
        }
        
        public Steps clearBuildingid()
        {
          this.o = false;
          this.p = "";
          return this;
        }
        
        public Steps clearDistance()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public Steps clearDuration()
        {
          this.e = false;
          this.f = 0;
          return this;
        }
        
        public Steps clearFloorid()
        {
          this.k = false;
          this.l = "";
          return this;
        }
        
        public Steps clearInstructions()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public Steps clearPois()
        {
          this.n = Collections.emptyList();
          return this;
        }
        
        public Steps clearSendLocation()
        {
          this.b = Collections.emptyList();
          return this;
        }
        
        public Steps clearSpath()
        {
          this.m = Collections.emptyList();
          return this;
        }
        
        public Steps clearSstartLocation()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public Steps clearType()
        {
          this.i = false;
          this.j = 0;
          return this;
        }
        
        public String getBuildingid()
        {
          return this.p;
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
          return this.d;
        }
        
        public int getDuration()
        {
          return this.f;
        }
        
        public String getFloorid()
        {
          return this.l;
        }
        
        public String getInstructions()
        {
          return this.h;
        }
        
        public Pois getPois(int paramInt)
        {
          return (Pois)this.n.get(paramInt);
        }
        
        public int getPoisCount()
        {
          return this.n.size();
        }
        
        public List<Pois> getPoisList()
        {
          return this.n;
        }
        
        public double getSendLocation(int paramInt)
        {
          return ((Double)this.b.get(paramInt)).doubleValue();
        }
        
        public int getSendLocationCount()
        {
          return this.b.size();
        }
        
        public List<Double> getSendLocationList()
        {
          return this.b;
        }
        
        public int getSerializedSize()
        {
          int i2 = 0 + getSstartLocationList().size() * 8 + getSstartLocationList().size() * 1 + getSendLocationList().size() * 8 + getSendLocationList().size() * 1;
          int i1 = i2;
          if (hasDistance()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(3, getDistance());
          }
          i2 = i1;
          if (hasDuration()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(4, getDuration());
          }
          i1 = i2;
          if (hasInstructions()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(5, getInstructions());
          }
          i2 = i1;
          if (hasType()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(6, getType());
          }
          i1 = i2;
          if (hasFloorid()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getFloorid());
          }
          i2 = getSpathList().size();
          int i3 = getSpathList().size();
          Iterator localIterator = getPoisList().iterator();
          for (i1 = i1 + i2 * 8 + i3 * 1; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(9, (Pois)localIterator.next()) + i1) {}
          i2 = i1;
          if (hasBuildingid()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(10, getBuildingid());
          }
          this.q = i2;
          return i2;
        }
        
        public double getSpath(int paramInt)
        {
          return ((Double)this.m.get(paramInt)).doubleValue();
        }
        
        public int getSpathCount()
        {
          return this.m.size();
        }
        
        public List<Double> getSpathList()
        {
          return this.m;
        }
        
        public double getSstartLocation(int paramInt)
        {
          return ((Double)this.a.get(paramInt)).doubleValue();
        }
        
        public int getSstartLocationCount()
        {
          return this.a.size();
        }
        
        public List<Double> getSstartLocationList()
        {
          return this.a;
        }
        
        public int getType()
        {
          return this.j;
        }
        
        public boolean hasBuildingid()
        {
          return this.o;
        }
        
        public boolean hasDistance()
        {
          return this.c;
        }
        
        public boolean hasDuration()
        {
          return this.e;
        }
        
        public boolean hasFloorid()
        {
          return this.k;
        }
        
        public boolean hasInstructions()
        {
          return this.g;
        }
        
        public boolean hasType()
        {
          return this.i;
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
            case 9: 
              addSstartLocation(paramCodedInputStreamMicro.readDouble());
              break;
            case 17: 
              addSendLocation(paramCodedInputStreamMicro.readDouble());
              break;
            case 24: 
              setDistance(paramCodedInputStreamMicro.readInt32());
              break;
            case 32: 
              setDuration(paramCodedInputStreamMicro.readInt32());
              break;
            case 42: 
              setInstructions(paramCodedInputStreamMicro.readString());
              break;
            case 48: 
              setType(paramCodedInputStreamMicro.readInt32());
              break;
            case 58: 
              setFloorid(paramCodedInputStreamMicro.readString());
              break;
            case 65: 
              addSpath(paramCodedInputStreamMicro.readDouble());
              break;
            case 74: 
              Pois localPois = new Pois();
              paramCodedInputStreamMicro.readMessage(localPois);
              addPois(localPois);
              break;
            case 82: 
              setBuildingid(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Steps setBuildingid(String paramString)
        {
          this.o = true;
          this.p = paramString;
          return this;
        }
        
        public Steps setDistance(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public Steps setDuration(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
          return this;
        }
        
        public Steps setFloorid(String paramString)
        {
          this.k = true;
          this.l = paramString;
          return this;
        }
        
        public Steps setInstructions(String paramString)
        {
          this.g = true;
          this.h = paramString;
          return this;
        }
        
        public Steps setPois(int paramInt, Pois paramPois)
        {
          if (paramPois == null) {
            return this;
          }
          this.n.set(paramInt, paramPois);
          return this;
        }
        
        public Steps setSendLocation(int paramInt, double paramDouble)
        {
          this.b.set(paramInt, Double.valueOf(paramDouble));
          return this;
        }
        
        public Steps setSpath(int paramInt, double paramDouble)
        {
          this.m.set(paramInt, Double.valueOf(paramDouble));
          return this;
        }
        
        public Steps setSstartLocation(int paramInt, double paramDouble)
        {
          this.a.set(paramInt, Double.valueOf(paramDouble));
          return this;
        }
        
        public Steps setType(int paramInt)
        {
          this.i = true;
          this.j = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getSstartLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeDouble(1, ((Double)localIterator.next()).doubleValue());
          }
          localIterator = getSendLocationList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeDouble(2, ((Double)localIterator.next()).doubleValue());
          }
          if (hasDistance()) {
            paramCodedOutputStreamMicro.writeInt32(3, getDistance());
          }
          if (hasDuration()) {
            paramCodedOutputStreamMicro.writeInt32(4, getDuration());
          }
          if (hasInstructions()) {
            paramCodedOutputStreamMicro.writeString(5, getInstructions());
          }
          if (hasType()) {
            paramCodedOutputStreamMicro.writeInt32(6, getType());
          }
          if (hasFloorid()) {
            paramCodedOutputStreamMicro.writeString(7, getFloorid());
          }
          localIterator = getSpathList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeDouble(8, ((Double)localIterator.next()).doubleValue());
          }
          localIterator = getPoisList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(9, (Pois)localIterator.next());
          }
          if (hasBuildingid()) {
            paramCodedOutputStreamMicro.writeString(10, getBuildingid());
          }
        }
        
        public static final class Pois
          extends MessageMicro
        {
          public static final int DETAIL_FIELD_NUMBER = 4;
          public static final int LOCATION_FIELD_NUMBER = 3;
          public static final int NAME_FIELD_NUMBER = 1;
          public static final int TYPE_FIELD_NUMBER = 2;
          private boolean a;
          private String b = "";
          private boolean c;
          private int d = 0;
          private List<Double> e = Collections.emptyList();
          private boolean f;
          private String g = "";
          private int h = -1;
          
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
          
          public Pois addLocation(double paramDouble)
          {
            if (this.e.isEmpty()) {
              this.e = new ArrayList();
            }
            this.e.add(Double.valueOf(paramDouble));
            return this;
          }
          
          public final Pois clear()
          {
            clearName();
            clearType();
            clearLocation();
            clearDetail();
            this.h = -1;
            return this;
          }
          
          public Pois clearDetail()
          {
            this.f = false;
            this.g = "";
            return this;
          }
          
          public Pois clearLocation()
          {
            this.e = Collections.emptyList();
            return this;
          }
          
          public Pois clearName()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Pois clearType()
          {
            this.c = false;
            this.d = 0;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.h < 0) {
              getSerializedSize();
            }
            return this.h;
          }
          
          public String getDetail()
          {
            return this.g;
          }
          
          public double getLocation(int paramInt)
          {
            return ((Double)this.e.get(paramInt)).doubleValue();
          }
          
          public int getLocationCount()
          {
            return this.e.size();
          }
          
          public List<Double> getLocationList()
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
            if (hasType()) {
              j = i + CodedOutputStreamMicro.computeInt32Size(2, getType());
            }
            j = j + getLocationList().size() * 8 + getLocationList().size() * 1;
            i = j;
            if (hasDetail()) {
              i = j + CodedOutputStreamMicro.computeStringSize(4, getDetail());
            }
            this.h = i;
            return i;
          }
          
          public int getType()
          {
            return this.d;
          }
          
          public boolean hasDetail()
          {
            return this.f;
          }
          
          public boolean hasName()
          {
            return this.a;
          }
          
          public boolean hasType()
          {
            return this.c;
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
                setType(paramCodedInputStreamMicro.readInt32());
                break;
              case 25: 
                addLocation(paramCodedInputStreamMicro.readDouble());
                break;
              case 34: 
                setDetail(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Pois setDetail(String paramString)
          {
            this.f = true;
            this.g = paramString;
            return this;
          }
          
          public Pois setLocation(int paramInt, double paramDouble)
          {
            this.e.set(paramInt, Double.valueOf(paramDouble));
            return this;
          }
          
          public Pois setName(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Pois setType(int paramInt)
          {
            this.c = true;
            this.d = paramInt;
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
            Iterator localIterator = getLocationList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeDouble(3, ((Double)localIterator.next()).doubleValue());
            }
            if (hasDetail()) {
              paramCodedOutputStreamMicro.writeString(4, getDetail());
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/IndoorNavi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */