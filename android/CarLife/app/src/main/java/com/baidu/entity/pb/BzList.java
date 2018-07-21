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

public final class BzList
  extends MessageMicro
{
  public static final int CATER_FIELD_NUMBER = 3;
  public static final int CIRCLE_NAME_FIELD_NUMBER = 4;
  public static final int CIRCLE_NAME_RECOMMEND_FIELD_NUMBER = 5;
  public static final int CONTENT_FIELD_NUMBER = 1;
  public static final int C_FIELD_NUMBER = 2;
  public static final int ERROR_FIELD_NUMBER = 8;
  public static final int INDUSTRY_FIELD_NUMBER = 10;
  public static final int MORE_FIELD_NUMBER = 9;
  public static final int PX_FIELD_NUMBER = 6;
  public static final int PY_FIELD_NUMBER = 7;
  public static final int TOTAL_COUNT_FIELD_NUMBER = 12;
  private List<Content> a = Collections.emptyList();
  private boolean b;
  private String c = "";
  private boolean d;
  private String e = "";
  private boolean f;
  private String g = "";
  private boolean h;
  private String i = "";
  private boolean j;
  private String k = "";
  private boolean l;
  private String m = "";
  private boolean n;
  private int o = 0;
  private boolean p;
  private int q = 0;
  private boolean r;
  private String s = "";
  private boolean t;
  private int u = 0;
  private int v = -1;
  
  public static BzList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new BzList().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static BzList parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (BzList)new BzList().mergeFrom(paramArrayOfByte);
  }
  
  public BzList addContent(Content paramContent)
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
  
  public final BzList clear()
  {
    clearContent();
    clearC();
    clearCater();
    clearCircleName();
    clearCircleNameRecommend();
    clearPx();
    clearPy();
    clearError();
    clearMore();
    clearIndustry();
    clearTotalCount();
    this.v = -1;
    return this;
  }
  
  public BzList clearC()
  {
    this.b = false;
    this.c = "";
    return this;
  }
  
  public BzList clearCater()
  {
    this.d = false;
    this.e = "";
    return this;
  }
  
  public BzList clearCircleName()
  {
    this.f = false;
    this.g = "";
    return this;
  }
  
  public BzList clearCircleNameRecommend()
  {
    this.h = false;
    this.i = "";
    return this;
  }
  
  public BzList clearContent()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public BzList clearError()
  {
    this.n = false;
    this.o = 0;
    return this;
  }
  
  public BzList clearIndustry()
  {
    this.r = false;
    this.s = "";
    return this;
  }
  
  public BzList clearMore()
  {
    this.p = false;
    this.q = 0;
    return this;
  }
  
  public BzList clearPx()
  {
    this.j = false;
    this.k = "";
    return this;
  }
  
  public BzList clearPy()
  {
    this.l = false;
    this.m = "";
    return this;
  }
  
  public BzList clearTotalCount()
  {
    this.t = false;
    this.u = 0;
    return this;
  }
  
  public String getC()
  {
    return this.c;
  }
  
  public int getCachedSize()
  {
    if (this.v < 0) {
      getSerializedSize();
    }
    return this.v;
  }
  
  public String getCater()
  {
    return this.e;
  }
  
  public String getCircleName()
  {
    return this.g;
  }
  
  public String getCircleNameRecommend()
  {
    return this.i;
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
    return this.o;
  }
  
  public String getIndustry()
  {
    return this.s;
  }
  
  public int getMore()
  {
    return this.q;
  }
  
  public String getPx()
  {
    return this.k;
  }
  
  public String getPy()
  {
    return this.m;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getContentList().iterator();
    for (int i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(1, (Content)localIterator.next()) + i2) {}
    int i1 = i2;
    if (hasC()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getC());
    }
    i2 = i1;
    if (hasCater()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getCater());
    }
    i1 = i2;
    if (hasCircleName()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getCircleName());
    }
    i2 = i1;
    if (hasCircleNameRecommend()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getCircleNameRecommend());
    }
    i1 = i2;
    if (hasPx()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getPx());
    }
    i2 = i1;
    if (hasPy()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getPy());
    }
    i1 = i2;
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
    if (hasTotalCount()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(12, getTotalCount());
    }
    this.v = i2;
    return i2;
  }
  
  public int getTotalCount()
  {
    return this.u;
  }
  
  public boolean hasC()
  {
    return this.b;
  }
  
  public boolean hasCater()
  {
    return this.d;
  }
  
  public boolean hasCircleName()
  {
    return this.f;
  }
  
  public boolean hasCircleNameRecommend()
  {
    return this.h;
  }
  
  public boolean hasError()
  {
    return this.n;
  }
  
  public boolean hasIndustry()
  {
    return this.r;
  }
  
  public boolean hasMore()
  {
    return this.p;
  }
  
  public boolean hasPx()
  {
    return this.j;
  }
  
  public boolean hasPy()
  {
    return this.l;
  }
  
  public boolean hasTotalCount()
  {
    return this.t;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public BzList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 18: 
        setC(paramCodedInputStreamMicro.readString());
        break;
      case 26: 
        setCater(paramCodedInputStreamMicro.readString());
        break;
      case 34: 
        setCircleName(paramCodedInputStreamMicro.readString());
        break;
      case 42: 
        setCircleNameRecommend(paramCodedInputStreamMicro.readString());
        break;
      case 50: 
        setPx(paramCodedInputStreamMicro.readString());
        break;
      case 58: 
        setPy(paramCodedInputStreamMicro.readString());
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
      case 96: 
        setTotalCount(paramCodedInputStreamMicro.readInt32());
      }
    }
  }
  
  public BzList setC(String paramString)
  {
    this.b = true;
    this.c = paramString;
    return this;
  }
  
  public BzList setCater(String paramString)
  {
    this.d = true;
    this.e = paramString;
    return this;
  }
  
  public BzList setCircleName(String paramString)
  {
    this.f = true;
    this.g = paramString;
    return this;
  }
  
  public BzList setCircleNameRecommend(String paramString)
  {
    this.h = true;
    this.i = paramString;
    return this;
  }
  
  public BzList setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.a.set(paramInt, paramContent);
    return this;
  }
  
  public BzList setError(int paramInt)
  {
    this.n = true;
    this.o = paramInt;
    return this;
  }
  
  public BzList setIndustry(String paramString)
  {
    this.r = true;
    this.s = paramString;
    return this;
  }
  
  public BzList setMore(int paramInt)
  {
    this.p = true;
    this.q = paramInt;
    return this;
  }
  
  public BzList setPx(String paramString)
  {
    this.j = true;
    this.k = paramString;
    return this;
  }
  
  public BzList setPy(String paramString)
  {
    this.l = true;
    this.m = paramString;
    return this;
  }
  
  public BzList setTotalCount(int paramInt)
  {
    this.t = true;
    this.u = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Content)localIterator.next());
    }
    if (hasC()) {
      paramCodedOutputStreamMicro.writeString(2, getC());
    }
    if (hasCater()) {
      paramCodedOutputStreamMicro.writeString(3, getCater());
    }
    if (hasCircleName()) {
      paramCodedOutputStreamMicro.writeString(4, getCircleName());
    }
    if (hasCircleNameRecommend()) {
      paramCodedOutputStreamMicro.writeString(5, getCircleNameRecommend());
    }
    if (hasPx()) {
      paramCodedOutputStreamMicro.writeString(6, getPx());
    }
    if (hasPy()) {
      paramCodedOutputStreamMicro.writeString(7, getPy());
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
    if (hasTotalCount()) {
      paramCodedOutputStreamMicro.writeInt32(12, getTotalCount());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int CIRCLE_NAME_FIELD_NUMBER = 4;
    public static final int DIS_FIELD_NUMBER = 15;
    public static final int FLAG_ON_LEFT_FIELD_NUMBER = 16;
    public static final int ID_FIELD_NUMBER = 11;
    public static final int PIC_URL_FIELD_NUMBER = 5;
    public static final int POI_INDUSTRY_FIELD_NUMBER = 1;
    public static final int PRICE_FIELD_NUMBER = 8;
    public static final int PRICE_TEXT_FIELD_NUMBER = 17;
    public static final int PX_FIELD_NUMBER = 9;
    public static final int PY_FIELD_NUMBER = 10;
    public static final int REC_REASON_FIELD_NUMBER = 13;
    public static final int SCENE_FIELD_NUMBER = 14;
    public static final int SCORE_FIELD_NUMBER = 6;
    public static final int STATE_FIELD_NUMBER = 3;
    public static final int TAG_FIELD_NUMBER = 7;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int UID_FIELD_NUMBER = 12;
    private boolean A;
    private String B = "";
    private boolean C;
    private String D = "";
    private boolean E;
    private String F = "";
    private boolean G;
    private String H = "";
    private int I = -1;
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
    private boolean y;
    private String z = "";
    
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
      clearTitle();
      clearState();
      clearCircleName();
      clearPicUrl();
      clearScore();
      clearTag();
      clearPrice();
      clearPx();
      clearPy();
      clearId();
      clearUid();
      clearRecReason();
      clearScene();
      clearDis();
      clearFlagOnLeft();
      clearPriceText();
      this.I = -1;
      return this;
    }
    
    public Content clearCircleName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Content clearDis()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public Content clearFlagOnLeft()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public Content clearId()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public Content clearPicUrl()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Content clearPoiIndustry()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearPrice()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public Content clearPriceText()
    {
      this.G = false;
      this.H = "";
      return this;
    }
    
    public Content clearPx()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Content clearPy()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public Content clearRecReason()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public Content clearScene()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public Content clearScore()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Content clearState()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Content clearTag()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Content clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Content clearUid()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.I < 0) {
        getSerializedSize();
      }
      return this.I;
    }
    
    public String getCircleName()
    {
      return this.h;
    }
    
    public String getDis()
    {
      return this.D;
    }
    
    public String getFlagOnLeft()
    {
      return this.F;
    }
    
    public String getId()
    {
      return this.v;
    }
    
    public String getPicUrl()
    {
      return this.j;
    }
    
    public String getPoiIndustry()
    {
      return this.b;
    }
    
    public String getPrice()
    {
      return this.p;
    }
    
    public String getPriceText()
    {
      return this.H;
    }
    
    public String getPx()
    {
      return this.r;
    }
    
    public String getPy()
    {
      return this.t;
    }
    
    public String getRecReason()
    {
      return this.z;
    }
    
    public String getScene()
    {
      return this.B;
    }
    
    public String getScore()
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
      if (hasTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      i2 = i1;
      if (hasState()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getState());
      }
      i1 = i2;
      if (hasCircleName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getCircleName());
      }
      i2 = i1;
      if (hasPicUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getPicUrl());
      }
      i1 = i2;
      if (hasScore()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getScore());
      }
      i2 = i1;
      if (hasTag()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getTag());
      }
      i1 = i2;
      if (hasPrice()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getPrice());
      }
      i2 = i1;
      if (hasPx()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getPx());
      }
      i1 = i2;
      if (hasPy()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getPy());
      }
      i2 = i1;
      if (hasId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getId());
      }
      i1 = i2;
      if (hasUid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getUid());
      }
      i2 = i1;
      if (hasRecReason()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getRecReason());
      }
      i1 = i2;
      if (hasScene()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getScene());
      }
      i2 = i1;
      if (hasDis()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getDis());
      }
      i1 = i2;
      if (hasFlagOnLeft()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getFlagOnLeft());
      }
      i2 = i1;
      if (hasPriceText()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getPriceText());
      }
      this.I = i2;
      return i2;
    }
    
    public String getState()
    {
      return this.f;
    }
    
    public String getTag()
    {
      return this.n;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public String getUid()
    {
      return this.x;
    }
    
    public boolean hasCircleName()
    {
      return this.g;
    }
    
    public boolean hasDis()
    {
      return this.C;
    }
    
    public boolean hasFlagOnLeft()
    {
      return this.E;
    }
    
    public boolean hasId()
    {
      return this.u;
    }
    
    public boolean hasPicUrl()
    {
      return this.i;
    }
    
    public boolean hasPoiIndustry()
    {
      return this.a;
    }
    
    public boolean hasPrice()
    {
      return this.o;
    }
    
    public boolean hasPriceText()
    {
      return this.G;
    }
    
    public boolean hasPx()
    {
      return this.q;
    }
    
    public boolean hasPy()
    {
      return this.s;
    }
    
    public boolean hasRecReason()
    {
      return this.y;
    }
    
    public boolean hasScene()
    {
      return this.A;
    }
    
    public boolean hasScore()
    {
      return this.k;
    }
    
    public boolean hasState()
    {
      return this.e;
    }
    
    public boolean hasTag()
    {
      return this.m;
    }
    
    public boolean hasTitle()
    {
      return this.c;
    }
    
    public boolean hasUid()
    {
      return this.w;
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
        case 10: 
          setPoiIndustry(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setState(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setCircleName(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setPicUrl(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setScore(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setTag(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setPrice(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setPx(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setPy(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setId(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setRecReason(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setScene(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setDis(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setFlagOnLeft(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          setPriceText(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Content setCircleName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Content setDis(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public Content setFlagOnLeft(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public Content setId(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public Content setPicUrl(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Content setPoiIndustry(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setPrice(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public Content setPriceText(String paramString)
    {
      this.G = true;
      this.H = paramString;
      return this;
    }
    
    public Content setPx(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Content setPy(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public Content setRecReason(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public Content setScene(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public Content setScore(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Content setState(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Content setTag(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Content setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Content setUid(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPoiIndustry()) {
        paramCodedOutputStreamMicro.writeString(1, getPoiIndustry());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
      if (hasState()) {
        paramCodedOutputStreamMicro.writeString(3, getState());
      }
      if (hasCircleName()) {
        paramCodedOutputStreamMicro.writeString(4, getCircleName());
      }
      if (hasPicUrl()) {
        paramCodedOutputStreamMicro.writeString(5, getPicUrl());
      }
      if (hasScore()) {
        paramCodedOutputStreamMicro.writeString(6, getScore());
      }
      if (hasTag()) {
        paramCodedOutputStreamMicro.writeString(7, getTag());
      }
      if (hasPrice()) {
        paramCodedOutputStreamMicro.writeString(8, getPrice());
      }
      if (hasPx()) {
        paramCodedOutputStreamMicro.writeString(9, getPx());
      }
      if (hasPy()) {
        paramCodedOutputStreamMicro.writeString(10, getPy());
      }
      if (hasId()) {
        paramCodedOutputStreamMicro.writeString(11, getId());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(12, getUid());
      }
      if (hasRecReason()) {
        paramCodedOutputStreamMicro.writeString(13, getRecReason());
      }
      if (hasScene()) {
        paramCodedOutputStreamMicro.writeString(14, getScene());
      }
      if (hasDis()) {
        paramCodedOutputStreamMicro.writeString(15, getDis());
      }
      if (hasFlagOnLeft()) {
        paramCodedOutputStreamMicro.writeString(16, getFlagOnLeft());
      }
      if (hasPriceText()) {
        paramCodedOutputStreamMicro.writeString(17, getPriceText());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/BzList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */