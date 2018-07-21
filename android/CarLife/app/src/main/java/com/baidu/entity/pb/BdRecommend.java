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

public final class BdRecommend
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 1;
  public static final int ERROR_FIELD_NUMBER = 8;
  public static final int INDUSTRY_FIELD_NUMBER = 10;
  public static final int LBS_FORWARD_FIELD_NUMBER = 11;
  public static final int LDATA_FIELD_NUMBER = 13;
  public static final int MORE_FIELD_NUMBER = 9;
  public static final int QID_FIELD_NUMBER = 12;
  private List<Content> a = Collections.emptyList();
  private boolean b;
  private int c = 0;
  private boolean d;
  private int e = 0;
  private boolean f;
  private String g = "";
  private boolean h;
  private String i = "";
  private boolean j;
  private String k = "";
  private boolean l;
  private String m = "";
  private int n = -1;
  
  public static BdRecommend parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new BdRecommend().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static BdRecommend parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (BdRecommend)new BdRecommend().mergeFrom(paramArrayOfByte);
  }
  
  public BdRecommend addContent(Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramContent);
    return this;
  }
  
  public final BdRecommend clear()
  {
    clearContent();
    clearError();
    clearMore();
    clearIndustry();
    clearLbsForward();
    clearQid();
    clearLdata();
    this.n = -1;
    return this;
  }
  
  public BdRecommend clearContent()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public BdRecommend clearError()
  {
    this.b = false;
    this.c = 0;
    return this;
  }
  
  public BdRecommend clearIndustry()
  {
    this.f = false;
    this.g = "";
    return this;
  }
  
  public BdRecommend clearLbsForward()
  {
    this.h = false;
    this.i = "";
    return this;
  }
  
  public BdRecommend clearLdata()
  {
    this.l = false;
    this.m = "";
    return this;
  }
  
  public BdRecommend clearMore()
  {
    this.d = false;
    this.e = 0;
    return this;
  }
  
  public BdRecommend clearQid()
  {
    this.j = false;
    this.k = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.n < 0) {
      getSerializedSize();
    }
    return this.n;
  }
  
  public Content getContent(int paramInt)
  {
    return (Content)this.a.get(paramInt);
  }
  
  public int getContentCount()
  {
    return this.a.size();
  }
  
  public List<Content> getContentList()
  {
    return this.a;
  }
  
  public int getError()
  {
    return this.c;
  }
  
  public String getIndustry()
  {
    return this.g;
  }
  
  public String getLbsForward()
  {
    return this.i;
  }
  
  public String getLdata()
  {
    return this.m;
  }
  
  public int getMore()
  {
    return this.e;
  }
  
  public String getQid()
  {
    return this.k;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getContentList().iterator();
    for (int i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(1, (Content)localIterator.next()) + i2) {}
    int i1 = i2;
    if (hasError()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getError());
    }
    i2 = i1;
    if (hasMore()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getMore());
    }
    i1 = i2;
    if (hasIndustry()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getIndustry());
    }
    i2 = i1;
    if (hasLbsForward()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getLbsForward());
    }
    i1 = i2;
    if (hasQid()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getQid());
    }
    i2 = i1;
    if (hasLdata()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getLdata());
    }
    this.n = i2;
    return i2;
  }
  
  public boolean hasError()
  {
    return this.b;
  }
  
  public boolean hasIndustry()
  {
    return this.f;
  }
  
  public boolean hasLbsForward()
  {
    return this.h;
  }
  
  public boolean hasLdata()
  {
    return this.l;
  }
  
  public boolean hasMore()
  {
    return this.d;
  }
  
  public boolean hasQid()
  {
    return this.j;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public BdRecommend mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Content localContent = new Content();
        paramCodedInputStreamMicro.readMessage(localContent);
        addContent(localContent);
        break;
      case 64: 
        setError(paramCodedInputStreamMicro.readInt32());
        break;
      case 72: 
        setMore(paramCodedInputStreamMicro.readInt32());
        break;
      case 82: 
        setIndustry(paramCodedInputStreamMicro.readString());
        break;
      case 90: 
        setLbsForward(paramCodedInputStreamMicro.readString());
        break;
      case 98: 
        setQid(paramCodedInputStreamMicro.readString());
        break;
      case 106: 
        setLdata(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public BdRecommend setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.a.set(paramInt, paramContent);
    return this;
  }
  
  public BdRecommend setError(int paramInt)
  {
    this.b = true;
    this.c = paramInt;
    return this;
  }
  
  public BdRecommend setIndustry(String paramString)
  {
    this.f = true;
    this.g = paramString;
    return this;
  }
  
  public BdRecommend setLbsForward(String paramString)
  {
    this.h = true;
    this.i = paramString;
    return this;
  }
  
  public BdRecommend setLdata(String paramString)
  {
    this.l = true;
    this.m = paramString;
    return this;
  }
  
  public BdRecommend setMore(int paramInt)
  {
    this.d = true;
    this.e = paramInt;
    return this;
  }
  
  public BdRecommend setQid(String paramString)
  {
    this.j = true;
    this.k = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Content)localIterator.next());
    }
    if (hasError()) {
      paramCodedOutputStreamMicro.writeInt32(8, getError());
    }
    if (hasMore()) {
      paramCodedOutputStreamMicro.writeInt32(9, getMore());
    }
    if (hasIndustry()) {
      paramCodedOutputStreamMicro.writeString(10, getIndustry());
    }
    if (hasLbsForward()) {
      paramCodedOutputStreamMicro.writeString(11, getLbsForward());
    }
    if (hasQid()) {
      paramCodedOutputStreamMicro.writeString(12, getQid());
    }
    if (hasLdata()) {
      paramCodedOutputStreamMicro.writeString(13, getLdata());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int GROUPON_ID_FIELD_NUMBER = 9;
    public static final int LIKE_PARAM_FIELD_NUMBER = 7;
    public static final int ORIGINAL_PRICE_FIELD_NUMBER = 11;
    public static final int PIC_URL_FIELD_NUMBER = 2;
    public static final int POI_INDUSTRY_FIELD_NUMBER = 1;
    public static final int PX_FIELD_NUMBER = 4;
    public static final int PY_FIELD_NUMBER = 5;
    public static final int SCENE_FIELD_NUMBER = 6;
    public static final int TUAN_PRICE_FIELD_NUMBER = 10;
    public static final int UID_FIELD_NUMBER = 3;
    public static final int UI_DATA_FIELD_NUMBER = 8;
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
    private boolean k;
    private String l = "";
    private boolean m;
    private LikeParam n = null;
    private boolean o;
    private UiData p = null;
    private boolean q;
    private String r = "";
    private boolean s;
    private String t = "";
    private boolean u;
    private String v = "";
    private int w = -1;
    
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
      clearPoiIndustry();
      clearPicUrl();
      clearUid();
      clearPx();
      clearPy();
      clearScene();
      clearLikeParam();
      clearUiData();
      clearGrouponId();
      clearTuanPrice();
      clearOriginalPrice();
      this.w = -1;
      return this;
    }
    
    public Content clearGrouponId()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Content clearLikeParam()
    {
      this.m = false;
      this.n = null;
      return this;
    }
    
    public Content clearOriginalPrice()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public Content clearPicUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Content clearPoiIndustry()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearPx()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Content clearPy()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Content clearScene()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Content clearTuanPrice()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public Content clearUiData()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public Content clearUid()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.w < 0) {
        getSerializedSize();
      }
      return this.w;
    }
    
    public String getGrouponId()
    {
      return this.r;
    }
    
    public LikeParam getLikeParam()
    {
      return this.n;
    }
    
    public String getOriginalPrice()
    {
      return this.v;
    }
    
    public String getPicUrl()
    {
      return this.d;
    }
    
    public String getPoiIndustry()
    {
      return this.b;
    }
    
    public String getPx()
    {
      return this.h;
    }
    
    public String getPy()
    {
      return this.j;
    }
    
    public String getScene()
    {
      return this.l;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasPoiIndustry()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiIndustry());
      }
      int i1 = i2;
      if (hasPicUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getPicUrl());
      }
      i2 = i1;
      if (hasUid()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getUid());
      }
      i1 = i2;
      if (hasPx()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getPx());
      }
      i2 = i1;
      if (hasPy()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getPy());
      }
      i1 = i2;
      if (hasScene()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getScene());
      }
      i2 = i1;
      if (hasLikeParam()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getLikeParam());
      }
      i1 = i2;
      if (hasUiData()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getUiData());
      }
      i2 = i1;
      if (hasGrouponId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getGrouponId());
      }
      i1 = i2;
      if (hasTuanPrice()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getTuanPrice());
      }
      i2 = i1;
      if (hasOriginalPrice()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getOriginalPrice());
      }
      this.w = i2;
      return i2;
    }
    
    public String getTuanPrice()
    {
      return this.t;
    }
    
    public UiData getUiData()
    {
      return this.p;
    }
    
    public String getUid()
    {
      return this.f;
    }
    
    public boolean hasGrouponId()
    {
      return this.q;
    }
    
    public boolean hasLikeParam()
    {
      return this.m;
    }
    
    public boolean hasOriginalPrice()
    {
      return this.u;
    }
    
    public boolean hasPicUrl()
    {
      return this.c;
    }
    
    public boolean hasPoiIndustry()
    {
      return this.a;
    }
    
    public boolean hasPx()
    {
      return this.g;
    }
    
    public boolean hasPy()
    {
      return this.i;
    }
    
    public boolean hasScene()
    {
      return this.k;
    }
    
    public boolean hasTuanPrice()
    {
      return this.s;
    }
    
    public boolean hasUiData()
    {
      return this.o;
    }
    
    public boolean hasUid()
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
          setPoiIndustry(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setPicUrl(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setPx(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setPy(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setScene(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          localObject = new LikeParam();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setLikeParam((LikeParam)localObject);
          break;
        case 66: 
          localObject = new UiData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUiData((UiData)localObject);
          break;
        case 74: 
          setGrouponId(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setTuanPrice(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setOriginalPrice(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Content setGrouponId(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Content setLikeParam(LikeParam paramLikeParam)
    {
      if (paramLikeParam == null) {
        return clearLikeParam();
      }
      this.m = true;
      this.n = paramLikeParam;
      return this;
    }
    
    public Content setOriginalPrice(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public Content setPicUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Content setPoiIndustry(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setPx(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Content setPy(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Content setScene(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Content setTuanPrice(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public Content setUiData(UiData paramUiData)
    {
      if (paramUiData == null) {
        return clearUiData();
      }
      this.o = true;
      this.p = paramUiData;
      return this;
    }
    
    public Content setUid(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPoiIndustry()) {
        paramCodedOutputStreamMicro.writeString(1, getPoiIndustry());
      }
      if (hasPicUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getPicUrl());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(3, getUid());
      }
      if (hasPx()) {
        paramCodedOutputStreamMicro.writeString(4, getPx());
      }
      if (hasPy()) {
        paramCodedOutputStreamMicro.writeString(5, getPy());
      }
      if (hasScene()) {
        paramCodedOutputStreamMicro.writeString(6, getScene());
      }
      if (hasLikeParam()) {
        paramCodedOutputStreamMicro.writeMessage(7, getLikeParam());
      }
      if (hasUiData()) {
        paramCodedOutputStreamMicro.writeMessage(8, getUiData());
      }
      if (hasGrouponId()) {
        paramCodedOutputStreamMicro.writeString(9, getGrouponId());
      }
      if (hasTuanPrice()) {
        paramCodedOutputStreamMicro.writeString(10, getTuanPrice());
      }
      if (hasOriginalPrice()) {
        paramCodedOutputStreamMicro.writeString(11, getOriginalPrice());
      }
    }
    
    public static final class LikeParam
      extends MessageMicro
    {
      public static final int KEY_FIELD_NUMBER = 1;
      public static final int SUBKEY_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static LikeParam parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new LikeParam().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static LikeParam parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (LikeParam)new LikeParam().mergeFrom(paramArrayOfByte);
      }
      
      public final LikeParam clear()
      {
        clearKey();
        clearSubkey();
        this.e = -1;
        return this;
      }
      
      public LikeParam clearKey()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public LikeParam clearSubkey()
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
      
      public String getKey()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasKey()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getKey());
        }
        int j = i;
        if (hasSubkey()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getSubkey());
        }
        this.e = j;
        return j;
      }
      
      public String getSubkey()
      {
        return this.d;
      }
      
      public boolean hasKey()
      {
        return this.a;
      }
      
      public boolean hasSubkey()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public LikeParam mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setKey(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setSubkey(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public LikeParam setKey(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public LikeParam setSubkey(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasKey()) {
          paramCodedOutputStreamMicro.writeString(1, getKey());
        }
        if (hasSubkey()) {
          paramCodedOutputStreamMicro.writeString(2, getSubkey());
        }
      }
    }
    
    public static final class UiData
      extends MessageMicro
    {
      public static final int SECTION10_FIELD_NUMBER = 10;
      public static final int SECTION11_FIELD_NUMBER = 11;
      public static final int SECTION12_FIELD_NUMBER = 12;
      public static final int SECTION1_FIELD_NUMBER = 1;
      public static final int SECTION2_FIELD_NUMBER = 2;
      public static final int SECTION3_FIELD_NUMBER = 3;
      public static final int SECTION4_FIELD_NUMBER = 4;
      public static final int SECTION5_FIELD_NUMBER = 5;
      public static final int SECTION6_FIELD_NUMBER = 6;
      public static final int SECTION7_FIELD_NUMBER = 7;
      public static final int SECTION8_FIELD_NUMBER = 8;
      public static final int SECTION9_FIELD_NUMBER = 9;
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
      private boolean k;
      private String l = "";
      private boolean m;
      private String n = "";
      private boolean o;
      private String p = "";
      private boolean q;
      private String r = "";
      private boolean s;
      private String t = "";
      private boolean u;
      private String v = "";
      private boolean w;
      private String x = "";
      private int y = -1;
      
      public static UiData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new UiData().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static UiData parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (UiData)new UiData().mergeFrom(paramArrayOfByte);
      }
      
      public final UiData clear()
      {
        clearSection1();
        clearSection2();
        clearSection3();
        clearSection4();
        clearSection5();
        clearSection6();
        clearSection7();
        clearSection8();
        clearSection9();
        clearSection10();
        clearSection11();
        clearSection12();
        this.y = -1;
        return this;
      }
      
      public UiData clearSection1()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public UiData clearSection10()
      {
        this.s = false;
        this.t = "";
        return this;
      }
      
      public UiData clearSection11()
      {
        this.u = false;
        this.v = "";
        return this;
      }
      
      public UiData clearSection12()
      {
        this.w = false;
        this.x = "";
        return this;
      }
      
      public UiData clearSection2()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public UiData clearSection3()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public UiData clearSection4()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public UiData clearSection5()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public UiData clearSection6()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public UiData clearSection7()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public UiData clearSection8()
      {
        this.o = false;
        this.p = "";
        return this;
      }
      
      public UiData clearSection9()
      {
        this.q = false;
        this.r = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.y < 0) {
          getSerializedSize();
        }
        return this.y;
      }
      
      public String getSection1()
      {
        return this.b;
      }
      
      public String getSection10()
      {
        return this.t;
      }
      
      public String getSection11()
      {
        return this.v;
      }
      
      public String getSection12()
      {
        return this.x;
      }
      
      public String getSection2()
      {
        return this.d;
      }
      
      public String getSection3()
      {
        return this.f;
      }
      
      public String getSection4()
      {
        return this.h;
      }
      
      public String getSection5()
      {
        return this.j;
      }
      
      public String getSection6()
      {
        return this.l;
      }
      
      public String getSection7()
      {
        return this.n;
      }
      
      public String getSection8()
      {
        return this.p;
      }
      
      public String getSection9()
      {
        return this.r;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasSection1()) {
          i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getSection1());
        }
        int i1 = i2;
        if (hasSection2()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getSection2());
        }
        i2 = i1;
        if (hasSection3()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getSection3());
        }
        i1 = i2;
        if (hasSection4()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getSection4());
        }
        i2 = i1;
        if (hasSection5()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getSection5());
        }
        i1 = i2;
        if (hasSection6()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getSection6());
        }
        i2 = i1;
        if (hasSection7()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getSection7());
        }
        i1 = i2;
        if (hasSection8()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getSection8());
        }
        i2 = i1;
        if (hasSection9()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getSection9());
        }
        i1 = i2;
        if (hasSection10()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getSection10());
        }
        i2 = i1;
        if (hasSection11()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getSection11());
        }
        i1 = i2;
        if (hasSection12()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getSection12());
        }
        this.y = i1;
        return i1;
      }
      
      public boolean hasSection1()
      {
        return this.a;
      }
      
      public boolean hasSection10()
      {
        return this.s;
      }
      
      public boolean hasSection11()
      {
        return this.u;
      }
      
      public boolean hasSection12()
      {
        return this.w;
      }
      
      public boolean hasSection2()
      {
        return this.c;
      }
      
      public boolean hasSection3()
      {
        return this.e;
      }
      
      public boolean hasSection4()
      {
        return this.g;
      }
      
      public boolean hasSection5()
      {
        return this.i;
      }
      
      public boolean hasSection6()
      {
        return this.k;
      }
      
      public boolean hasSection7()
      {
        return this.m;
      }
      
      public boolean hasSection8()
      {
        return this.o;
      }
      
      public boolean hasSection9()
      {
        return this.q;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public UiData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setSection1(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setSection2(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setSection3(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setSection4(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setSection5(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setSection6(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setSection7(paramCodedInputStreamMicro.readString());
            break;
          case 66: 
            setSection8(paramCodedInputStreamMicro.readString());
            break;
          case 74: 
            setSection9(paramCodedInputStreamMicro.readString());
            break;
          case 82: 
            setSection10(paramCodedInputStreamMicro.readString());
            break;
          case 90: 
            setSection11(paramCodedInputStreamMicro.readString());
            break;
          case 98: 
            setSection12(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public UiData setSection1(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public UiData setSection10(String paramString)
      {
        this.s = true;
        this.t = paramString;
        return this;
      }
      
      public UiData setSection11(String paramString)
      {
        this.u = true;
        this.v = paramString;
        return this;
      }
      
      public UiData setSection12(String paramString)
      {
        this.w = true;
        this.x = paramString;
        return this;
      }
      
      public UiData setSection2(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public UiData setSection3(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public UiData setSection4(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public UiData setSection5(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public UiData setSection6(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public UiData setSection7(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public UiData setSection8(String paramString)
      {
        this.o = true;
        this.p = paramString;
        return this;
      }
      
      public UiData setSection9(String paramString)
      {
        this.q = true;
        this.r = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasSection1()) {
          paramCodedOutputStreamMicro.writeString(1, getSection1());
        }
        if (hasSection2()) {
          paramCodedOutputStreamMicro.writeString(2, getSection2());
        }
        if (hasSection3()) {
          paramCodedOutputStreamMicro.writeString(3, getSection3());
        }
        if (hasSection4()) {
          paramCodedOutputStreamMicro.writeString(4, getSection4());
        }
        if (hasSection5()) {
          paramCodedOutputStreamMicro.writeString(5, getSection5());
        }
        if (hasSection6()) {
          paramCodedOutputStreamMicro.writeString(6, getSection6());
        }
        if (hasSection7()) {
          paramCodedOutputStreamMicro.writeString(7, getSection7());
        }
        if (hasSection8()) {
          paramCodedOutputStreamMicro.writeString(8, getSection8());
        }
        if (hasSection9()) {
          paramCodedOutputStreamMicro.writeString(9, getSection9());
        }
        if (hasSection10()) {
          paramCodedOutputStreamMicro.writeString(10, getSection10());
        }
        if (hasSection11()) {
          paramCodedOutputStreamMicro.writeString(11, getSection11());
        }
        if (hasSection12()) {
          paramCodedOutputStreamMicro.writeString(12, getSection12());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/BdRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */