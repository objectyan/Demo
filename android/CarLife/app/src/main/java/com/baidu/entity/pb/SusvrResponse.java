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

public final class SusvrResponse
  extends MessageMicro
{
  public static final int DISPLAY_STYLES_FIELD_NUMBER = 4;
  public static final int OFFLINE_FIELD_NUMBER = 3;
  public static final int POI_ARRAY_FIELD_NUMBER = 1;
  public static final int SE_ID_FIELD_NUMBER = 5;
  public static final int TYPE_FIELD_NUMBER = 2;
  private List<PoiElement> a = Collections.emptyList();
  private boolean b;
  private int c = 0;
  private boolean d;
  private int e = 0;
  private List<String> f = Collections.emptyList();
  private boolean g;
  private long h = 0L;
  private int i = -1;
  
  public static SusvrResponse parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new SusvrResponse().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static SusvrResponse parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (SusvrResponse)new SusvrResponse().mergeFrom(paramArrayOfByte);
  }
  
  public SusvrResponse addDisplayStyles(String paramString)
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
  
  public SusvrResponse addPoiArray(PoiElement paramPoiElement)
  {
    if (paramPoiElement == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramPoiElement);
    return this;
  }
  
  public final SusvrResponse clear()
  {
    clearPoiArray();
    clearType();
    clearOffline();
    clearDisplayStyles();
    clearSeId();
    this.i = -1;
    return this;
  }
  
  public SusvrResponse clearDisplayStyles()
  {
    this.f = Collections.emptyList();
    return this;
  }
  
  public SusvrResponse clearOffline()
  {
    this.d = false;
    this.e = 0;
    return this;
  }
  
  public SusvrResponse clearPoiArray()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public SusvrResponse clearSeId()
  {
    this.g = false;
    this.h = 0L;
    return this;
  }
  
  public SusvrResponse clearType()
  {
    this.b = false;
    this.c = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.i < 0) {
      getSerializedSize();
    }
    return this.i;
  }
  
  public String getDisplayStyles(int paramInt)
  {
    return (String)this.f.get(paramInt);
  }
  
  public int getDisplayStylesCount()
  {
    return this.f.size();
  }
  
  public List<String> getDisplayStylesList()
  {
    return this.f;
  }
  
  public int getOffline()
  {
    return this.e;
  }
  
  public PoiElement getPoiArray(int paramInt)
  {
    return (PoiElement)this.a.get(paramInt);
  }
  
  public int getPoiArrayCount()
  {
    return this.a.size();
  }
  
  public List<PoiElement> getPoiArrayList()
  {
    return this.a;
  }
  
  public long getSeId()
  {
    return this.h;
  }
  
  public int getSerializedSize()
  {
    int m = 0;
    Iterator localIterator = getPoiArrayList().iterator();
    for (int k = 0; localIterator.hasNext(); k = CodedOutputStreamMicro.computeMessageSize(1, (PoiElement)localIterator.next()) + k) {}
    int j = k;
    if (hasType()) {
      j = k + CodedOutputStreamMicro.computeInt32Size(2, getType());
    }
    k = j;
    if (hasOffline()) {
      k = j + CodedOutputStreamMicro.computeInt32Size(3, getOffline());
    }
    localIterator = getDisplayStylesList().iterator();
    j = m;
    while (localIterator.hasNext()) {
      j += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
    }
    k = k + j + getDisplayStylesList().size() * 1;
    j = k;
    if (hasSeId()) {
      j = k + CodedOutputStreamMicro.computeUInt64Size(5, getSeId());
    }
    this.i = j;
    return j;
  }
  
  public int getType()
  {
    return this.c;
  }
  
  public boolean hasOffline()
  {
    return this.d;
  }
  
  public boolean hasSeId()
  {
    return this.g;
  }
  
  public boolean hasType()
  {
    return this.b;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public SusvrResponse mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        PoiElement localPoiElement = new PoiElement();
        paramCodedInputStreamMicro.readMessage(localPoiElement);
        addPoiArray(localPoiElement);
        break;
      case 16: 
        setType(paramCodedInputStreamMicro.readInt32());
        break;
      case 24: 
        setOffline(paramCodedInputStreamMicro.readInt32());
        break;
      case 34: 
        addDisplayStyles(paramCodedInputStreamMicro.readString());
        break;
      case 40: 
        setSeId(paramCodedInputStreamMicro.readUInt64());
      }
    }
  }
  
  public SusvrResponse setDisplayStyles(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.f.set(paramInt, paramString);
    return this;
  }
  
  public SusvrResponse setOffline(int paramInt)
  {
    this.d = true;
    this.e = paramInt;
    return this;
  }
  
  public SusvrResponse setPoiArray(int paramInt, PoiElement paramPoiElement)
  {
    if (paramPoiElement == null) {
      return this;
    }
    this.a.set(paramInt, paramPoiElement);
    return this;
  }
  
  public SusvrResponse setSeId(long paramLong)
  {
    this.g = true;
    this.h = paramLong;
    return this;
  }
  
  public SusvrResponse setType(int paramInt)
  {
    this.b = true;
    this.c = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getPoiArrayList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (PoiElement)localIterator.next());
    }
    if (hasType()) {
      paramCodedOutputStreamMicro.writeInt32(2, getType());
    }
    if (hasOffline()) {
      paramCodedOutputStreamMicro.writeInt32(3, getOffline());
    }
    localIterator = getDisplayStylesList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeString(4, (String)localIterator.next());
    }
    if (hasSeId()) {
      paramCodedOutputStreamMicro.writeUInt64(5, getSeId());
    }
  }
  
  public static final class PoiElement
    extends MessageMicro
  {
    public static final int CATALOG_ID_FIELD_NUMBER = 19;
    public static final int CITYID_FIELD_NUMBER = 3;
    public static final int DISPLAY_QUERY_FIELD_NUMBER = 11;
    public static final int DISTANCE_FIELD_NUMBER = 4;
    public static final int JUMP_FIELD_NUMBER = 12;
    public static final int LINE1_COLUMN1_FIELD_NUMBER = 13;
    public static final int LINE1_COLUMN2_FIELD_NUMBER = 14;
    public static final int LINE1_COLUMN3_FIELD_NUMBER = 15;
    public static final int LINE2_COLUMN1_FIELD_NUMBER = 16;
    public static final int LINE2_COLUMN2_FIELD_NUMBER = 17;
    public static final int LINE2_COLUMN3_FIELD_NUMBER = 18;
    public static final int POI_NAME_FIELD_NUMBER = 1;
    public static final int POI_X_FIELD_NUMBER = 7;
    public static final int POI_Y_FIELD_NUMBER = 8;
    public static final int SUB_POI_ARRAY_FIELD_NUMBER = 6;
    public static final int SUB_POI_TYPE_FIELD_NUMBER = 5;
    public static final int SUB_TITLE_FIELD_NUMBER = 2;
    public static final int TAG_INFO_FIELD_NUMBER = 9;
    public static final int UID_FIELD_NUMBER = 10;
    private String A = "";
    private boolean B;
    private String C = "";
    private boolean D;
    private String E = "";
    private boolean F;
    private String G = "";
    private boolean H;
    private String I = "";
    private boolean J;
    private int K = 0;
    private int L = -1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private boolean g;
    private String h = "";
    private boolean i;
    private int j = 0;
    private List<SubPoi> k = Collections.emptyList();
    private boolean l;
    private double m = 0.0D;
    private boolean n;
    private double o = 0.0D;
    private boolean p;
    private TagInfo q = null;
    private boolean r;
    private String s = "";
    private boolean t;
    private String u = "";
    private boolean v;
    private Jump w = null;
    private boolean x;
    private String y = "";
    private boolean z;
    
    public static PoiElement parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new PoiElement().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static PoiElement parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (PoiElement)new PoiElement().mergeFrom(paramArrayOfByte);
    }
    
    public PoiElement addSubPoiArray(SubPoi paramSubPoi)
    {
      if (paramSubPoi == null) {
        return this;
      }
      if (this.k.isEmpty()) {
        this.k = new ArrayList();
      }
      this.k.add(paramSubPoi);
      return this;
    }
    
    public final PoiElement clear()
    {
      clearPoiName();
      clearSubTitle();
      clearCityid();
      clearDistance();
      clearSubPoiType();
      clearSubPoiArray();
      clearPoiX();
      clearPoiY();
      clearTagInfo();
      clearUid();
      clearDisplayQuery();
      clearJump();
      clearLine1Column1();
      clearLine1Column2();
      clearLine1Column3();
      clearLine2Column1();
      clearLine2Column2();
      clearLine2Column3();
      clearCatalogId();
      this.L = -1;
      return this;
    }
    
    public PoiElement clearCatalogId()
    {
      this.J = false;
      this.K = 0;
      return this;
    }
    
    public PoiElement clearCityid()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public PoiElement clearDisplayQuery()
    {
      this.t = false;
      this.u = "";
      return this;
    }
    
    public PoiElement clearDistance()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public PoiElement clearJump()
    {
      this.v = false;
      this.w = null;
      return this;
    }
    
    public PoiElement clearLine1Column1()
    {
      this.x = false;
      this.y = "";
      return this;
    }
    
    public PoiElement clearLine1Column2()
    {
      this.z = false;
      this.A = "";
      return this;
    }
    
    public PoiElement clearLine1Column3()
    {
      this.B = false;
      this.C = "";
      return this;
    }
    
    public PoiElement clearLine2Column1()
    {
      this.D = false;
      this.E = "";
      return this;
    }
    
    public PoiElement clearLine2Column2()
    {
      this.F = false;
      this.G = "";
      return this;
    }
    
    public PoiElement clearLine2Column3()
    {
      this.H = false;
      this.I = "";
      return this;
    }
    
    public PoiElement clearPoiName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public PoiElement clearPoiX()
    {
      this.l = false;
      this.m = 0.0D;
      return this;
    }
    
    public PoiElement clearPoiY()
    {
      this.n = false;
      this.o = 0.0D;
      return this;
    }
    
    public PoiElement clearSubPoiArray()
    {
      this.k = Collections.emptyList();
      return this;
    }
    
    public PoiElement clearSubPoiType()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public PoiElement clearSubTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public PoiElement clearTagInfo()
    {
      this.p = false;
      this.q = null;
      return this;
    }
    
    public PoiElement clearUid()
    {
      this.r = false;
      this.s = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.L < 0) {
        getSerializedSize();
      }
      return this.L;
    }
    
    public int getCatalogId()
    {
      return this.K;
    }
    
    public int getCityid()
    {
      return this.f;
    }
    
    public String getDisplayQuery()
    {
      return this.u;
    }
    
    public String getDistance()
    {
      return this.h;
    }
    
    public Jump getJump()
    {
      return this.w;
    }
    
    public String getLine1Column1()
    {
      return this.y;
    }
    
    public String getLine1Column2()
    {
      return this.A;
    }
    
    public String getLine1Column3()
    {
      return this.C;
    }
    
    public String getLine2Column1()
    {
      return this.E;
    }
    
    public String getLine2Column2()
    {
      return this.G;
    }
    
    public String getLine2Column3()
    {
      return this.I;
    }
    
    public String getPoiName()
    {
      return this.b;
    }
    
    public double getPoiX()
    {
      return this.m;
    }
    
    public double getPoiY()
    {
      return this.o;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasPoiName()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiName());
      }
      int i1 = i2;
      if (hasSubTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
      }
      i2 = i1;
      if (hasCityid()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getCityid());
      }
      i1 = i2;
      if (hasDistance()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getDistance());
      }
      i2 = i1;
      if (hasSubPoiType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getSubPoiType());
      }
      Iterator localIterator = getSubPoiArrayList().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(6, (SubPoi)localIterator.next()) + i2;
      }
      i1 = i2;
      if (hasPoiX()) {
        i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(7, getPoiX());
      }
      i2 = i1;
      if (hasPoiY()) {
        i2 = i1 + CodedOutputStreamMicro.computeDoubleSize(8, getPoiY());
      }
      i1 = i2;
      if (hasTagInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(9, getTagInfo());
      }
      i2 = i1;
      if (hasUid()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(10, getUid());
      }
      i1 = i2;
      if (hasDisplayQuery()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(11, getDisplayQuery());
      }
      i2 = i1;
      if (hasJump()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(12, getJump());
      }
      i1 = i2;
      if (hasLine1Column1()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(13, getLine1Column1());
      }
      i2 = i1;
      if (hasLine1Column2()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(14, getLine1Column2());
      }
      i1 = i2;
      if (hasLine1Column3()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(15, getLine1Column3());
      }
      i2 = i1;
      if (hasLine2Column1()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(16, getLine2Column1());
      }
      i1 = i2;
      if (hasLine2Column2()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(17, getLine2Column2());
      }
      i2 = i1;
      if (hasLine2Column3()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(18, getLine2Column3());
      }
      i1 = i2;
      if (hasCatalogId()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(19, getCatalogId());
      }
      this.L = i1;
      return i1;
    }
    
    public SubPoi getSubPoiArray(int paramInt)
    {
      return (SubPoi)this.k.get(paramInt);
    }
    
    public int getSubPoiArrayCount()
    {
      return this.k.size();
    }
    
    public List<SubPoi> getSubPoiArrayList()
    {
      return this.k;
    }
    
    public int getSubPoiType()
    {
      return this.j;
    }
    
    public String getSubTitle()
    {
      return this.d;
    }
    
    public TagInfo getTagInfo()
    {
      return this.q;
    }
    
    public String getUid()
    {
      return this.s;
    }
    
    public boolean hasCatalogId()
    {
      return this.J;
    }
    
    public boolean hasCityid()
    {
      return this.e;
    }
    
    public boolean hasDisplayQuery()
    {
      return this.t;
    }
    
    public boolean hasDistance()
    {
      return this.g;
    }
    
    public boolean hasJump()
    {
      return this.v;
    }
    
    public boolean hasLine1Column1()
    {
      return this.x;
    }
    
    public boolean hasLine1Column2()
    {
      return this.z;
    }
    
    public boolean hasLine1Column3()
    {
      return this.B;
    }
    
    public boolean hasLine2Column1()
    {
      return this.D;
    }
    
    public boolean hasLine2Column2()
    {
      return this.F;
    }
    
    public boolean hasLine2Column3()
    {
      return this.H;
    }
    
    public boolean hasPoiName()
    {
      return this.a;
    }
    
    public boolean hasPoiX()
    {
      return this.l;
    }
    
    public boolean hasPoiY()
    {
      return this.n;
    }
    
    public boolean hasSubPoiType()
    {
      return this.i;
    }
    
    public boolean hasSubTitle()
    {
      return this.c;
    }
    
    public boolean hasTagInfo()
    {
      return this.p;
    }
    
    public boolean hasUid()
    {
      return this.r;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public PoiElement mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setPoiName(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setSubTitle(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setCityid(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          setDistance(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setSubPoiType(paramCodedInputStreamMicro.readInt32());
          break;
        case 50: 
          localObject = new SubPoi();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addSubPoiArray((SubPoi)localObject);
          break;
        case 57: 
          setPoiX(paramCodedInputStreamMicro.readDouble());
          break;
        case 65: 
          setPoiY(paramCodedInputStreamMicro.readDouble());
          break;
        case 74: 
          localObject = new TagInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTagInfo((TagInfo)localObject);
          break;
        case 82: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setDisplayQuery(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          localObject = new Jump();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setJump((Jump)localObject);
          break;
        case 106: 
          setLine1Column1(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setLine1Column2(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setLine1Column3(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setLine2Column1(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          setLine2Column2(paramCodedInputStreamMicro.readString());
          break;
        case 146: 
          setLine2Column3(paramCodedInputStreamMicro.readString());
          break;
        case 152: 
          setCatalogId(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public PoiElement setCatalogId(int paramInt)
    {
      this.J = true;
      this.K = paramInt;
      return this;
    }
    
    public PoiElement setCityid(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public PoiElement setDisplayQuery(String paramString)
    {
      this.t = true;
      this.u = paramString;
      return this;
    }
    
    public PoiElement setDistance(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public PoiElement setJump(Jump paramJump)
    {
      if (paramJump == null) {
        return clearJump();
      }
      this.v = true;
      this.w = paramJump;
      return this;
    }
    
    public PoiElement setLine1Column1(String paramString)
    {
      this.x = true;
      this.y = paramString;
      return this;
    }
    
    public PoiElement setLine1Column2(String paramString)
    {
      this.z = true;
      this.A = paramString;
      return this;
    }
    
    public PoiElement setLine1Column3(String paramString)
    {
      this.B = true;
      this.C = paramString;
      return this;
    }
    
    public PoiElement setLine2Column1(String paramString)
    {
      this.D = true;
      this.E = paramString;
      return this;
    }
    
    public PoiElement setLine2Column2(String paramString)
    {
      this.F = true;
      this.G = paramString;
      return this;
    }
    
    public PoiElement setLine2Column3(String paramString)
    {
      this.H = true;
      this.I = paramString;
      return this;
    }
    
    public PoiElement setPoiName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public PoiElement setPoiX(double paramDouble)
    {
      this.l = true;
      this.m = paramDouble;
      return this;
    }
    
    public PoiElement setPoiY(double paramDouble)
    {
      this.n = true;
      this.o = paramDouble;
      return this;
    }
    
    public PoiElement setSubPoiArray(int paramInt, SubPoi paramSubPoi)
    {
      if (paramSubPoi == null) {
        return this;
      }
      this.k.set(paramInt, paramSubPoi);
      return this;
    }
    
    public PoiElement setSubPoiType(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public PoiElement setSubTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public PoiElement setTagInfo(TagInfo paramTagInfo)
    {
      if (paramTagInfo == null) {
        return clearTagInfo();
      }
      this.p = true;
      this.q = paramTagInfo;
      return this;
    }
    
    public PoiElement setUid(String paramString)
    {
      this.r = true;
      this.s = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPoiName()) {
        paramCodedOutputStreamMicro.writeString(1, getPoiName());
      }
      if (hasSubTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getSubTitle());
      }
      if (hasCityid()) {
        paramCodedOutputStreamMicro.writeInt32(3, getCityid());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeString(4, getDistance());
      }
      if (hasSubPoiType()) {
        paramCodedOutputStreamMicro.writeInt32(5, getSubPoiType());
      }
      Iterator localIterator = getSubPoiArrayList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(6, (SubPoi)localIterator.next());
      }
      if (hasPoiX()) {
        paramCodedOutputStreamMicro.writeDouble(7, getPoiX());
      }
      if (hasPoiY()) {
        paramCodedOutputStreamMicro.writeDouble(8, getPoiY());
      }
      if (hasTagInfo()) {
        paramCodedOutputStreamMicro.writeMessage(9, getTagInfo());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(10, getUid());
      }
      if (hasDisplayQuery()) {
        paramCodedOutputStreamMicro.writeString(11, getDisplayQuery());
      }
      if (hasJump()) {
        paramCodedOutputStreamMicro.writeMessage(12, getJump());
      }
      if (hasLine1Column1()) {
        paramCodedOutputStreamMicro.writeString(13, getLine1Column1());
      }
      if (hasLine1Column2()) {
        paramCodedOutputStreamMicro.writeString(14, getLine1Column2());
      }
      if (hasLine1Column3()) {
        paramCodedOutputStreamMicro.writeString(15, getLine1Column3());
      }
      if (hasLine2Column1()) {
        paramCodedOutputStreamMicro.writeString(16, getLine2Column1());
      }
      if (hasLine2Column2()) {
        paramCodedOutputStreamMicro.writeString(17, getLine2Column2());
      }
      if (hasLine2Column3()) {
        paramCodedOutputStreamMicro.writeString(18, getLine2Column3());
      }
      if (hasCatalogId()) {
        paramCodedOutputStreamMicro.writeInt32(19, getCatalogId());
      }
    }
    
    public static final class Jump
      extends MessageMicro
    {
      public static final int JUMP_TYPE_FIELD_NUMBER = 1;
      public static final int URL_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static Jump parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Jump().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Jump parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Jump)new Jump().mergeFrom(paramArrayOfByte);
      }
      
      public final Jump clear()
      {
        clearJumpType();
        clearUrl();
        this.e = -1;
        return this;
      }
      
      public Jump clearJumpType()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Jump clearUrl()
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
      
      public String getJumpType()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasJumpType()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getJumpType());
        }
        int j = i;
        if (hasUrl()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getUrl());
        }
        this.e = j;
        return j;
      }
      
      public String getUrl()
      {
        return this.d;
      }
      
      public boolean hasJumpType()
      {
        return this.a;
      }
      
      public boolean hasUrl()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Jump mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setJumpType(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setUrl(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Jump setJumpType(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Jump setUrl(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasJumpType()) {
          paramCodedOutputStreamMicro.writeString(1, getJumpType());
        }
        if (hasUrl()) {
          paramCodedOutputStreamMicro.writeString(2, getUrl());
        }
      }
    }
    
    public static final class SubPoi
      extends MessageMicro
    {
      public static final int GRID_FIELD_NUMBER = 3;
      public static final int JUMP_FIELD_NUMBER = 5;
      public static final int KNOWLEDGE_INFO_FIELD_NUMBER = 7;
      public static final int POI_NAME_FIELD_NUMBER = 1;
      public static final int SEARCH_QUERY_FIELD_NUMBER = 4;
      public static final int TAG_INFO_FIELD_NUMBER = 6;
      public static final int UID_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private int f = 0;
      private boolean g;
      private String h = "";
      private boolean i;
      private SusvrResponse.PoiElement.Jump j = null;
      private boolean k;
      private SusvrResponse.PoiElement.TagInfo l = null;
      private boolean m;
      private String n = "";
      private int o = -1;
      
      public static SubPoi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new SubPoi().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static SubPoi parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (SubPoi)new SubPoi().mergeFrom(paramArrayOfByte);
      }
      
      public final SubPoi clear()
      {
        clearPoiName();
        clearUid();
        clearGrid();
        clearSearchQuery();
        clearJump();
        clearTagInfo();
        clearKnowledgeInfo();
        this.o = -1;
        return this;
      }
      
      public SubPoi clearGrid()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public SubPoi clearJump()
      {
        this.i = false;
        this.j = null;
        return this;
      }
      
      public SubPoi clearKnowledgeInfo()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public SubPoi clearPoiName()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public SubPoi clearSearchQuery()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public SubPoi clearTagInfo()
      {
        this.k = false;
        this.l = null;
        return this;
      }
      
      public SubPoi clearUid()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.o < 0) {
          getSerializedSize();
        }
        return this.o;
      }
      
      public int getGrid()
      {
        return this.f;
      }
      
      public SusvrResponse.PoiElement.Jump getJump()
      {
        return this.j;
      }
      
      public String getKnowledgeInfo()
      {
        return this.n;
      }
      
      public String getPoiName()
      {
        return this.b;
      }
      
      public String getSearchQuery()
      {
        return this.h;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasPoiName()) {
          i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiName());
        }
        int i1 = i2;
        if (hasUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getUid());
        }
        i2 = i1;
        if (hasGrid()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getGrid());
        }
        i1 = i2;
        if (hasSearchQuery()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getSearchQuery());
        }
        i2 = i1;
        if (hasJump()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getJump());
        }
        i1 = i2;
        if (hasTagInfo()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getTagInfo());
        }
        i2 = i1;
        if (hasKnowledgeInfo()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getKnowledgeInfo());
        }
        this.o = i2;
        return i2;
      }
      
      public SusvrResponse.PoiElement.TagInfo getTagInfo()
      {
        return this.l;
      }
      
      public String getUid()
      {
        return this.d;
      }
      
      public boolean hasGrid()
      {
        return this.e;
      }
      
      public boolean hasJump()
      {
        return this.i;
      }
      
      public boolean hasKnowledgeInfo()
      {
        return this.m;
      }
      
      public boolean hasPoiName()
      {
        return this.a;
      }
      
      public boolean hasSearchQuery()
      {
        return this.g;
      }
      
      public boolean hasTagInfo()
      {
        return this.k;
      }
      
      public boolean hasUid()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public SubPoi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setPoiName(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 24: 
            setGrid(paramCodedInputStreamMicro.readInt32());
            break;
          case 34: 
            setSearchQuery(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            localObject = new SusvrResponse.PoiElement.Jump();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setJump((SusvrResponse.PoiElement.Jump)localObject);
            break;
          case 50: 
            localObject = new SusvrResponse.PoiElement.TagInfo();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setTagInfo((SusvrResponse.PoiElement.TagInfo)localObject);
            break;
          case 58: 
            setKnowledgeInfo(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public SubPoi setGrid(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public SubPoi setJump(SusvrResponse.PoiElement.Jump paramJump)
      {
        if (paramJump == null) {
          return clearJump();
        }
        this.i = true;
        this.j = paramJump;
        return this;
      }
      
      public SubPoi setKnowledgeInfo(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public SubPoi setPoiName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public SubPoi setSearchQuery(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public SubPoi setTagInfo(SusvrResponse.PoiElement.TagInfo paramTagInfo)
      {
        if (paramTagInfo == null) {
          return clearTagInfo();
        }
        this.k = true;
        this.l = paramTagInfo;
        return this;
      }
      
      public SubPoi setUid(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasPoiName()) {
          paramCodedOutputStreamMicro.writeString(1, getPoiName());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(2, getUid());
        }
        if (hasGrid()) {
          paramCodedOutputStreamMicro.writeInt32(3, getGrid());
        }
        if (hasSearchQuery()) {
          paramCodedOutputStreamMicro.writeString(4, getSearchQuery());
        }
        if (hasJump()) {
          paramCodedOutputStreamMicro.writeMessage(5, getJump());
        }
        if (hasTagInfo()) {
          paramCodedOutputStreamMicro.writeMessage(6, getTagInfo());
        }
        if (hasKnowledgeInfo()) {
          paramCodedOutputStreamMicro.writeString(7, getKnowledgeInfo());
        }
      }
    }
    
    public static final class TagInfo
      extends MessageMicro
    {
      public static final int BKG_COLOR_FIELD_NUMBER = 4;
      public static final int FONT_SIZE_FIELD_NUMBER = 2;
      public static final int NAME_COLOR_FIELD_NUMBER = 3;
      public static final int SHOW_NAME_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private int d = 0;
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private int i = -1;
      
      public static TagInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new TagInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static TagInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (TagInfo)new TagInfo().mergeFrom(paramArrayOfByte);
      }
      
      public final TagInfo clear()
      {
        clearShowName();
        clearFontSize();
        clearNameColor();
        clearBkgColor();
        this.i = -1;
        return this;
      }
      
      public TagInfo clearBkgColor()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public TagInfo clearFontSize()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public TagInfo clearNameColor()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public TagInfo clearShowName()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public String getBkgColor()
      {
        return this.h;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public int getFontSize()
      {
        return this.d;
      }
      
      public String getNameColor()
      {
        return this.f;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasShowName()) {
          k = 0 + CodedOutputStreamMicro.computeStringSize(1, getShowName());
        }
        int j = k;
        if (hasFontSize()) {
          j = k + CodedOutputStreamMicro.computeInt32Size(2, getFontSize());
        }
        k = j;
        if (hasNameColor()) {
          k = j + CodedOutputStreamMicro.computeStringSize(3, getNameColor());
        }
        j = k;
        if (hasBkgColor()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getBkgColor());
        }
        this.i = j;
        return j;
      }
      
      public String getShowName()
      {
        return this.b;
      }
      
      public boolean hasBkgColor()
      {
        return this.g;
      }
      
      public boolean hasFontSize()
      {
        return this.c;
      }
      
      public boolean hasNameColor()
      {
        return this.e;
      }
      
      public boolean hasShowName()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public TagInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setShowName(paramCodedInputStreamMicro.readString());
            break;
          case 16: 
            setFontSize(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            setNameColor(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setBkgColor(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public TagInfo setBkgColor(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public TagInfo setFontSize(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public TagInfo setNameColor(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public TagInfo setShowName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasShowName()) {
          paramCodedOutputStreamMicro.writeString(1, getShowName());
        }
        if (hasFontSize()) {
          paramCodedOutputStreamMicro.writeInt32(2, getFontSize());
        }
        if (hasNameColor()) {
          paramCodedOutputStreamMicro.writeString(3, getNameColor());
        }
        if (hasBkgColor()) {
          paramCodedOutputStreamMicro.writeString(4, getBkgColor());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/SusvrResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */