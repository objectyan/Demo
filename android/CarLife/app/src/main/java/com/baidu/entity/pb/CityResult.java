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

public final class CityResult
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int CURRENT_CITY_FIELD_NUMBER = 1;
  public static final int PREVIOUS_CITY_FIELD_NUMBER = 3;
  private boolean a;
  private Content b = null;
  private boolean c;
  private CurrentCity d = null;
  private boolean e;
  private PreviousCity f = null;
  private int g = -1;
  
  public static CityResult parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new CityResult().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static CityResult parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (CityResult)new CityResult().mergeFrom(paramArrayOfByte);
  }
  
  public final CityResult clear()
  {
    clearContent();
    clearCurrentCity();
    clearPreviousCity();
    this.g = -1;
    return this;
  }
  
  public CityResult clearContent()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public CityResult clearCurrentCity()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public CityResult clearPreviousCity()
  {
    this.e = false;
    this.f = null;
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
    return this.b;
  }
  
  public CurrentCity getCurrentCity()
  {
    return this.d;
  }
  
  public PreviousCity getPreviousCity()
  {
    return this.f;
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    if (hasCurrentCity()) {
      j = 0 + CodedOutputStreamMicro.computeMessageSize(1, getCurrentCity());
    }
    int i = j;
    if (hasContent()) {
      i = j + CodedOutputStreamMicro.computeMessageSize(2, getContent());
    }
    j = i;
    if (hasPreviousCity()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(3, getPreviousCity());
    }
    this.g = j;
    return j;
  }
  
  public boolean hasContent()
  {
    return this.a;
  }
  
  public boolean hasCurrentCity()
  {
    return this.c;
  }
  
  public boolean hasPreviousCity()
  {
    return this.e;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public CityResult mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Content();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setContent((Content)localObject);
        break;
      case 26: 
        localObject = new PreviousCity();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setPreviousCity((PreviousCity)localObject);
      }
    }
  }
  
  public CityResult setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.a = true;
    this.b = paramContent;
    return this;
  }
  
  public CityResult setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.c = true;
    this.d = paramCurrentCity;
    return this;
  }
  
  public CityResult setPreviousCity(PreviousCity paramPreviousCity)
  {
    if (paramPreviousCity == null) {
      return clearPreviousCity();
    }
    this.e = true;
    this.f = paramPreviousCity;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasCurrentCity()) {
      paramCodedOutputStreamMicro.writeMessage(1, getCurrentCity());
    }
    if (hasContent()) {
      paramCodedOutputStreamMicro.writeMessage(2, getContent());
    }
    if (hasPreviousCity()) {
      paramCodedOutputStreamMicro.writeMessage(3, getPreviousCity());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int CITY_TYPE_FIELD_NUMBER = 1;
    public static final int CNAME_FIELD_NUMBER = 3;
    public static final int CODE_FIELD_NUMBER = 2;
    public static final int GEO_FIELD_NUMBER = 4;
    public static final int LEVEL_FIELD_NUMBER = 8;
    public static final int PCCODE_FIELD_NUMBER = 6;
    public static final int PCNAME_FIELD_NUMBER = 7;
    public static final int SGEO_FIELD_NUMBER = 10;
    public static final int SUP_LUKUANG_FIELD_NUMBER = 9;
    public static final int UID_FIELD_NUMBER = 5;
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
    private int l = 0;
    private boolean m;
    private String n = "";
    private boolean o;
    private int p = 0;
    private boolean q;
    private boolean r = false;
    private boolean s;
    private Sgeo t = null;
    private int u = -1;
    
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
    
    public final Content clear()
    {
      clearCityType();
      clearCode();
      clearCname();
      clearGeo();
      clearUid();
      clearPccode();
      clearPcname();
      clearLevel();
      clearSupLukuang();
      clearSgeo();
      this.u = -1;
      return this;
    }
    
    public Content clearCityType()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Content clearCname()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Content clearCode()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Content clearGeo()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Content clearLevel()
    {
      this.o = false;
      this.p = 0;
      return this;
    }
    
    public Content clearPccode()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public Content clearPcname()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Content clearSgeo()
    {
      this.s = false;
      this.t = null;
      return this;
    }
    
    public Content clearSupLukuang()
    {
      this.q = false;
      this.r = false;
      return this;
    }
    
    public Content clearUid()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.u < 0) {
        getSerializedSize();
      }
      return this.u;
    }
    
    public int getCityType()
    {
      return this.b;
    }
    
    public String getCname()
    {
      return this.f;
    }
    
    public int getCode()
    {
      return this.d;
    }
    
    public String getGeo()
    {
      return this.h;
    }
    
    public int getLevel()
    {
      return this.p;
    }
    
    public int getPccode()
    {
      return this.l;
    }
    
    public String getPcname()
    {
      return this.n;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasCityType()) {
        i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCityType());
      }
      int i1 = i2;
      if (hasCode()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getCode());
      }
      i2 = i1;
      if (hasCname()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getCname());
      }
      i1 = i2;
      if (hasGeo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getGeo());
      }
      i2 = i1;
      if (hasUid()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getUid());
      }
      i1 = i2;
      if (hasPccode()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getPccode());
      }
      i2 = i1;
      if (hasPcname()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getPcname());
      }
      i1 = i2;
      if (hasLevel()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getLevel());
      }
      i2 = i1;
      if (hasSupLukuang()) {
        i2 = i1 + CodedOutputStreamMicro.computeBoolSize(9, getSupLukuang());
      }
      i1 = i2;
      if (hasSgeo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(10, getSgeo());
      }
      this.u = i1;
      return i1;
    }
    
    public Sgeo getSgeo()
    {
      return this.t;
    }
    
    public boolean getSupLukuang()
    {
      return this.r;
    }
    
    public String getUid()
    {
      return this.j;
    }
    
    public boolean hasCityType()
    {
      return this.a;
    }
    
    public boolean hasCname()
    {
      return this.e;
    }
    
    public boolean hasCode()
    {
      return this.c;
    }
    
    public boolean hasGeo()
    {
      return this.g;
    }
    
    public boolean hasLevel()
    {
      return this.o;
    }
    
    public boolean hasPccode()
    {
      return this.k;
    }
    
    public boolean hasPcname()
    {
      return this.m;
    }
    
    public boolean hasSgeo()
    {
      return this.s;
    }
    
    public boolean hasSupLukuang()
    {
      return this.q;
    }
    
    public boolean hasUid()
    {
      return this.i;
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
        int i1 = paramCodedInputStreamMicro.readTag();
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setCityType(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setCode(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setCname(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setGeo(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 48: 
          setPccode(paramCodedInputStreamMicro.readInt32());
          break;
        case 58: 
          setPcname(paramCodedInputStreamMicro.readString());
          break;
        case 64: 
          setLevel(paramCodedInputStreamMicro.readInt32());
          break;
        case 72: 
          setSupLukuang(paramCodedInputStreamMicro.readBool());
          break;
        case 82: 
          Sgeo localSgeo = new Sgeo();
          paramCodedInputStreamMicro.readMessage(localSgeo);
          setSgeo(localSgeo);
        }
      }
    }
    
    public Content setCityType(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Content setCname(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Content setCode(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Content setGeo(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Content setLevel(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public Content setPccode(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public Content setPcname(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Content setSgeo(Sgeo paramSgeo)
    {
      if (paramSgeo == null) {
        return clearSgeo();
      }
      this.s = true;
      this.t = paramSgeo;
      return this;
    }
    
    public Content setSupLukuang(boolean paramBoolean)
    {
      this.q = true;
      this.r = paramBoolean;
      return this;
    }
    
    public Content setUid(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCityType()) {
        paramCodedOutputStreamMicro.writeInt32(1, getCityType());
      }
      if (hasCode()) {
        paramCodedOutputStreamMicro.writeInt32(2, getCode());
      }
      if (hasCname()) {
        paramCodedOutputStreamMicro.writeString(3, getCname());
      }
      if (hasGeo()) {
        paramCodedOutputStreamMicro.writeString(4, getGeo());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(5, getUid());
      }
      if (hasPccode()) {
        paramCodedOutputStreamMicro.writeInt32(6, getPccode());
      }
      if (hasPcname()) {
        paramCodedOutputStreamMicro.writeString(7, getPcname());
      }
      if (hasLevel()) {
        paramCodedOutputStreamMicro.writeInt32(8, getLevel());
      }
      if (hasSupLukuang()) {
        paramCodedOutputStreamMicro.writeBool(9, getSupLukuang());
      }
      if (hasSgeo()) {
        paramCodedOutputStreamMicro.writeMessage(10, getSgeo());
      }
    }
    
    public static final class Sgeo
      extends MessageMicro
    {
      public static final int BOUND_FIELD_NUMBER = 1;
      public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
      public static final int TYPE_FIELD_NUMBER = 2;
      private List<String> a = Collections.emptyList();
      private boolean b;
      private String c = "";
      private List<GeoElements> d = Collections.emptyList();
      private int e = -1;
      
      public static Sgeo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Sgeo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Sgeo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Sgeo)new Sgeo().mergeFrom(paramArrayOfByte);
      }
      
      public Sgeo addBound(String paramString)
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
      
      public Sgeo addGeoElements(GeoElements paramGeoElements)
      {
        if (paramGeoElements == null) {
          return this;
        }
        if (this.d.isEmpty()) {
          this.d = new ArrayList();
        }
        this.d.add(paramGeoElements);
        return this;
      }
      
      public final Sgeo clear()
      {
        clearBound();
        clearType();
        clearGeoElements();
        this.e = -1;
        return this;
      }
      
      public Sgeo clearBound()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public Sgeo clearGeoElements()
      {
        this.d = Collections.emptyList();
        return this;
      }
      
      public Sgeo clearType()
      {
        this.b = false;
        this.c = "";
        return this;
      }
      
      public String getBound(int paramInt)
      {
        return (String)this.a.get(paramInt);
      }
      
      public int getBoundCount()
      {
        return this.a.size();
      }
      
      public List<String> getBoundList()
      {
        return this.a;
      }
      
      public int getCachedSize()
      {
        if (this.e < 0) {
          getSerializedSize();
        }
        return this.e;
      }
      
      public GeoElements getGeoElements(int paramInt)
      {
        return (GeoElements)this.d.get(paramInt);
      }
      
      public int getGeoElementsCount()
      {
        return this.d.size();
      }
      
      public List<GeoElements> getGeoElementsList()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        Iterator localIterator = getBoundList().iterator();
        for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i) {}
        int j = 0 + i + getBoundList().size() * 1;
        i = j;
        if (hasType()) {
          i = j + CodedOutputStreamMicro.computeStringSize(2, getType());
        }
        localIterator = getGeoElementsList().iterator();
        while (localIterator.hasNext()) {
          i = CodedOutputStreamMicro.computeMessageSize(3, (GeoElements)localIterator.next()) + i;
        }
        this.e = i;
        return i;
      }
      
      public String getType()
      {
        return this.c;
      }
      
      public boolean hasType()
      {
        return this.b;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Sgeo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            addBound(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setType(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            GeoElements localGeoElements = new GeoElements();
            paramCodedInputStreamMicro.readMessage(localGeoElements);
            addGeoElements(localGeoElements);
          }
        }
      }
      
      public Sgeo setBound(int paramInt, String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a.set(paramInt, paramString);
        return this;
      }
      
      public Sgeo setGeoElements(int paramInt, GeoElements paramGeoElements)
      {
        if (paramGeoElements == null) {
          return this;
        }
        this.d.set(paramInt, paramGeoElements);
        return this;
      }
      
      public Sgeo setType(String paramString)
      {
        this.b = true;
        this.c = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getBoundList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeString(1, (String)localIterator.next());
        }
        if (hasType()) {
          paramCodedOutputStreamMicro.writeString(2, getType());
        }
        localIterator = getGeoElementsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(3, (GeoElements)localIterator.next());
        }
      }
      
      public static final class GeoElements
        extends MessageMicro
      {
        public static final int POINT_FIELD_NUMBER = 1;
        private List<String> a = Collections.emptyList();
        private int b = -1;
        
        public static GeoElements parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new GeoElements().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static GeoElements parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (GeoElements)new GeoElements().mergeFrom(paramArrayOfByte);
        }
        
        public GeoElements addPoint(String paramString)
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
        
        public final GeoElements clear()
        {
          clearPoint();
          this.b = -1;
          return this;
        }
        
        public GeoElements clearPoint()
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
        
        public String getPoint(int paramInt)
        {
          return (String)this.a.get(paramInt);
        }
        
        public int getPointCount()
        {
          return this.a.size();
        }
        
        public List<String> getPointList()
        {
          return this.a;
        }
        
        public int getSerializedSize()
        {
          Iterator localIterator = getPointList().iterator();
          for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i) {}
          i = 0 + i + getPointList().size() * 1;
          this.b = i;
          return i;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public GeoElements mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              addPoint(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public GeoElements setPoint(int paramInt, String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a.set(paramInt, paramString);
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getPointList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeString(1, (String)localIterator.next());
          }
        }
      }
    }
  }
  
  public static final class PreviousCity
    extends MessageMicro
  {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static PreviousCity parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new PreviousCity().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static PreviousCity parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (PreviousCity)new PreviousCity().mergeFrom(paramArrayOfByte);
    }
    
    public final PreviousCity clear()
    {
      clearCode();
      clearName();
      this.e = -1;
      return this;
    }
    
    public PreviousCity clearCode()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public PreviousCity clearName()
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
    
    public PreviousCity mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
    
    public PreviousCity setCode(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public PreviousCity setName(String paramString)
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/CityResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */