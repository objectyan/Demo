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

public final class GeneralRecommend
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 1;
  public static final int COUNT_FIELD_NUMBER = 3;
  public static final int ERROR_FIELD_NUMBER = 4;
  public static final int INDUSTRY_FIELD_NUMBER = 2;
  public static final int LBS_FORWARD_FIELD_NUMBER = 6;
  public static final int MORE_FIELD_NUMBER = 5;
  private List<Content> a = Collections.emptyList();
  private boolean b;
  private String c = "";
  private boolean d;
  private int e = 0;
  private boolean f;
  private int g = 0;
  private boolean h;
  private int i = 0;
  private boolean j;
  private String k = "";
  private int l = -1;
  
  public static GeneralRecommend parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new GeneralRecommend().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static GeneralRecommend parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (GeneralRecommend)new GeneralRecommend().mergeFrom(paramArrayOfByte);
  }
  
  public GeneralRecommend addContent(Content paramContent)
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
  
  public final GeneralRecommend clear()
  {
    clearContent();
    clearIndustry();
    clearCount();
    clearError();
    clearMore();
    clearLbsForward();
    this.l = -1;
    return this;
  }
  
  public GeneralRecommend clearContent()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public GeneralRecommend clearCount()
  {
    this.d = false;
    this.e = 0;
    return this;
  }
  
  public GeneralRecommend clearError()
  {
    this.f = false;
    this.g = 0;
    return this;
  }
  
  public GeneralRecommend clearIndustry()
  {
    this.b = false;
    this.c = "";
    return this;
  }
  
  public GeneralRecommend clearLbsForward()
  {
    this.j = false;
    this.k = "";
    return this;
  }
  
  public GeneralRecommend clearMore()
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
  
  public int getCount()
  {
    return this.e;
  }
  
  public int getError()
  {
    return this.g;
  }
  
  public String getIndustry()
  {
    return this.c;
  }
  
  public String getLbsForward()
  {
    return this.k;
  }
  
  public int getMore()
  {
    return this.i;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getContentList().iterator();
    for (int n = 0; localIterator.hasNext(); n = CodedOutputStreamMicro.computeMessageSize(1, (Content)localIterator.next()) + n) {}
    int m = n;
    if (hasIndustry()) {
      m = n + CodedOutputStreamMicro.computeStringSize(2, getIndustry());
    }
    n = m;
    if (hasCount()) {
      n = m + CodedOutputStreamMicro.computeInt32Size(3, getCount());
    }
    m = n;
    if (hasError()) {
      m = n + CodedOutputStreamMicro.computeInt32Size(4, getError());
    }
    n = m;
    if (hasMore()) {
      n = m + CodedOutputStreamMicro.computeInt32Size(5, getMore());
    }
    m = n;
    if (hasLbsForward()) {
      m = n + CodedOutputStreamMicro.computeStringSize(6, getLbsForward());
    }
    this.l = m;
    return m;
  }
  
  public boolean hasCount()
  {
    return this.d;
  }
  
  public boolean hasError()
  {
    return this.f;
  }
  
  public boolean hasIndustry()
  {
    return this.b;
  }
  
  public boolean hasLbsForward()
  {
    return this.j;
  }
  
  public boolean hasMore()
  {
    return this.h;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public GeneralRecommend mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Content localContent = new Content();
        paramCodedInputStreamMicro.readMessage(localContent);
        addContent(localContent);
        break;
      case 18: 
        setIndustry(paramCodedInputStreamMicro.readString());
        break;
      case 24: 
        setCount(paramCodedInputStreamMicro.readInt32());
        break;
      case 32: 
        setError(paramCodedInputStreamMicro.readInt32());
        break;
      case 40: 
        setMore(paramCodedInputStreamMicro.readInt32());
        break;
      case 50: 
        setLbsForward(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public GeneralRecommend setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.a.set(paramInt, paramContent);
    return this;
  }
  
  public GeneralRecommend setCount(int paramInt)
  {
    this.d = true;
    this.e = paramInt;
    return this;
  }
  
  public GeneralRecommend setError(int paramInt)
  {
    this.f = true;
    this.g = paramInt;
    return this;
  }
  
  public GeneralRecommend setIndustry(String paramString)
  {
    this.b = true;
    this.c = paramString;
    return this;
  }
  
  public GeneralRecommend setLbsForward(String paramString)
  {
    this.j = true;
    this.k = paramString;
    return this;
  }
  
  public GeneralRecommend setMore(int paramInt)
  {
    this.h = true;
    this.i = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Content)localIterator.next());
    }
    if (hasIndustry()) {
      paramCodedOutputStreamMicro.writeString(2, getIndustry());
    }
    if (hasCount()) {
      paramCodedOutputStreamMicro.writeInt32(3, getCount());
    }
    if (hasError()) {
      paramCodedOutputStreamMicro.writeInt32(4, getError());
    }
    if (hasMore()) {
      paramCodedOutputStreamMicro.writeInt32(5, getMore());
    }
    if (hasLbsForward()) {
      paramCodedOutputStreamMicro.writeString(6, getLbsForward());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int ADDRESS_FIELD_NUMBER = 4;
    public static final int CITY_FIELD_NUMBER = 5;
    public static final int COMMENT_FIELD_NUMBER = 6;
    public static final int DESCRIPTION_FIELD_NUMBER = 18;
    public static final int DISTANCE_FIELD_NUMBER = 14;
    public static final int OVERALL_RATING_FIELD_NUMBER = 11;
    public static final int PIC_URL_FIELD_NUMBER = 2;
    public static final int POI_INDUSTRY_FIELD_NUMBER = 19;
    public static final int PRICE_FIELD_NUMBER = 10;
    public static final int PX_FIELD_NUMBER = 15;
    public static final int PY_FIELD_NUMBER = 16;
    public static final int REC_REASON_FIELD_NUMBER = 7;
    public static final int SCENE_FIELD_NUMBER = 20;
    public static final int SQ_FIELD_NUMBER = 17;
    public static final int STATE_FIELD_NUMBER = 13;
    public static final int STD_TAG_FIELD_NUMBER = 8;
    public static final int TELEPHONE_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int UID_FIELD_NUMBER = 12;
    public static final int WEIGHTED_TAG_FIELD_NUMBER = 9;
    private boolean A;
    private int B = 0;
    private boolean C;
    private String D = "";
    private boolean E;
    private String F = "";
    private boolean G;
    private String H = "";
    private boolean I;
    private String J = "";
    private boolean K;
    private String L = "";
    private boolean M;
    private String N = "";
    private int O = -1;
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
      clearTitle();
      clearPicUrl();
      clearTelephone();
      clearAddress();
      clearCity();
      clearComment();
      clearRecReason();
      clearStdTag();
      clearWeightedTag();
      clearPrice();
      clearOverallRating();
      clearUid();
      clearState();
      clearDistance();
      clearPx();
      clearPy();
      clearSq();
      clearDescription();
      clearPoiIndustry();
      clearScene();
      this.O = -1;
      return this;
    }
    
    public Content clearAddress()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Content clearCity()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Content clearComment()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Content clearDescription()
    {
      this.I = false;
      this.J = "";
      return this;
    }
    
    public Content clearDistance()
    {
      this.A = false;
      this.B = 0;
      return this;
    }
    
    public Content clearOverallRating()
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
      this.K = false;
      this.L = "";
      return this;
    }
    
    public Content clearPrice()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public Content clearPx()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public Content clearPy()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public Content clearRecReason()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Content clearScene()
    {
      this.M = false;
      this.N = "";
      return this;
    }
    
    public Content clearSq()
    {
      this.G = false;
      this.H = "";
      return this;
    }
    
    public Content clearState()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public Content clearStdTag()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public Content clearTelephone()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Content clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearUid()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public Content clearWeightedTag()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public String getAddress()
    {
      return this.h;
    }
    
    public int getCachedSize()
    {
      if (this.O < 0) {
        getSerializedSize();
      }
      return this.O;
    }
    
    public String getCity()
    {
      return this.j;
    }
    
    public String getComment()
    {
      return this.l;
    }
    
    public String getDescription()
    {
      return this.J;
    }
    
    public int getDistance()
    {
      return this.B;
    }
    
    public String getOverallRating()
    {
      return this.v;
    }
    
    public String getPicUrl()
    {
      return this.d;
    }
    
    public String getPoiIndustry()
    {
      return this.L;
    }
    
    public String getPrice()
    {
      return this.t;
    }
    
    public String getPx()
    {
      return this.D;
    }
    
    public String getPy()
    {
      return this.F;
    }
    
    public String getRecReason()
    {
      return this.n;
    }
    
    public String getScene()
    {
      return this.N;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasTitle()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      int i1 = i2;
      if (hasPicUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getPicUrl());
      }
      i2 = i1;
      if (hasTelephone()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getTelephone());
      }
      i1 = i2;
      if (hasAddress()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getAddress());
      }
      i2 = i1;
      if (hasCity()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getCity());
      }
      i1 = i2;
      if (hasComment()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getComment());
      }
      i2 = i1;
      if (hasRecReason()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getRecReason());
      }
      i1 = i2;
      if (hasStdTag()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getStdTag());
      }
      i2 = i1;
      if (hasWeightedTag()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getWeightedTag());
      }
      i1 = i2;
      if (hasPrice()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getPrice());
      }
      i2 = i1;
      if (hasOverallRating()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getOverallRating());
      }
      i1 = i2;
      if (hasUid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getUid());
      }
      i2 = i1;
      if (hasState()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getState());
      }
      i1 = i2;
      if (hasDistance()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(14, getDistance());
      }
      i2 = i1;
      if (hasPx()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getPx());
      }
      i1 = i2;
      if (hasPy()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getPy());
      }
      i2 = i1;
      if (hasSq()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getSq());
      }
      i1 = i2;
      if (hasDescription()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getDescription());
      }
      i2 = i1;
      if (hasPoiIndustry()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(19, getPoiIndustry());
      }
      i1 = i2;
      if (hasScene()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(20, getScene());
      }
      this.O = i1;
      return i1;
    }
    
    public String getSq()
    {
      return this.H;
    }
    
    public String getState()
    {
      return this.z;
    }
    
    public String getStdTag()
    {
      return this.p;
    }
    
    public String getTelephone()
    {
      return this.f;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public String getUid()
    {
      return this.x;
    }
    
    public String getWeightedTag()
    {
      return this.r;
    }
    
    public boolean hasAddress()
    {
      return this.g;
    }
    
    public boolean hasCity()
    {
      return this.i;
    }
    
    public boolean hasComment()
    {
      return this.k;
    }
    
    public boolean hasDescription()
    {
      return this.I;
    }
    
    public boolean hasDistance()
    {
      return this.A;
    }
    
    public boolean hasOverallRating()
    {
      return this.u;
    }
    
    public boolean hasPicUrl()
    {
      return this.c;
    }
    
    public boolean hasPoiIndustry()
    {
      return this.K;
    }
    
    public boolean hasPrice()
    {
      return this.s;
    }
    
    public boolean hasPx()
    {
      return this.C;
    }
    
    public boolean hasPy()
    {
      return this.E;
    }
    
    public boolean hasRecReason()
    {
      return this.m;
    }
    
    public boolean hasScene()
    {
      return this.M;
    }
    
    public boolean hasSq()
    {
      return this.G;
    }
    
    public boolean hasState()
    {
      return this.y;
    }
    
    public boolean hasStdTag()
    {
      return this.o;
    }
    
    public boolean hasTelephone()
    {
      return this.e;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public boolean hasUid()
    {
      return this.w;
    }
    
    public boolean hasWeightedTag()
    {
      return this.q;
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
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setPicUrl(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTelephone(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setAddress(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setCity(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setComment(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setRecReason(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setStdTag(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setWeightedTag(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setPrice(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setOverallRating(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setState(paramCodedInputStreamMicro.readString());
          break;
        case 112: 
          setDistance(paramCodedInputStreamMicro.readInt32());
          break;
        case 122: 
          setPx(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setPy(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          setSq(paramCodedInputStreamMicro.readString());
          break;
        case 146: 
          setDescription(paramCodedInputStreamMicro.readString());
          break;
        case 154: 
          setPoiIndustry(paramCodedInputStreamMicro.readString());
          break;
        case 162: 
          setScene(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Content setAddress(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Content setCity(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Content setComment(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Content setDescription(String paramString)
    {
      this.I = true;
      this.J = paramString;
      return this;
    }
    
    public Content setDistance(int paramInt)
    {
      this.A = true;
      this.B = paramInt;
      return this;
    }
    
    public Content setOverallRating(String paramString)
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
      this.K = true;
      this.L = paramString;
      return this;
    }
    
    public Content setPrice(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public Content setPx(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public Content setPy(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public Content setRecReason(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Content setScene(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }
    
    public Content setSq(String paramString)
    {
      this.G = true;
      this.H = paramString;
      return this;
    }
    
    public Content setState(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public Content setStdTag(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public Content setTelephone(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Content setTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setUid(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public Content setWeightedTag(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(1, getTitle());
      }
      if (hasPicUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getPicUrl());
      }
      if (hasTelephone()) {
        paramCodedOutputStreamMicro.writeString(3, getTelephone());
      }
      if (hasAddress()) {
        paramCodedOutputStreamMicro.writeString(4, getAddress());
      }
      if (hasCity()) {
        paramCodedOutputStreamMicro.writeString(5, getCity());
      }
      if (hasComment()) {
        paramCodedOutputStreamMicro.writeString(6, getComment());
      }
      if (hasRecReason()) {
        paramCodedOutputStreamMicro.writeString(7, getRecReason());
      }
      if (hasStdTag()) {
        paramCodedOutputStreamMicro.writeString(8, getStdTag());
      }
      if (hasWeightedTag()) {
        paramCodedOutputStreamMicro.writeString(9, getWeightedTag());
      }
      if (hasPrice()) {
        paramCodedOutputStreamMicro.writeString(10, getPrice());
      }
      if (hasOverallRating()) {
        paramCodedOutputStreamMicro.writeString(11, getOverallRating());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(12, getUid());
      }
      if (hasState()) {
        paramCodedOutputStreamMicro.writeString(13, getState());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeInt32(14, getDistance());
      }
      if (hasPx()) {
        paramCodedOutputStreamMicro.writeString(15, getPx());
      }
      if (hasPy()) {
        paramCodedOutputStreamMicro.writeString(16, getPy());
      }
      if (hasSq()) {
        paramCodedOutputStreamMicro.writeString(17, getSq());
      }
      if (hasDescription()) {
        paramCodedOutputStreamMicro.writeString(18, getDescription());
      }
      if (hasPoiIndustry()) {
        paramCodedOutputStreamMicro.writeString(19, getPoiIndustry());
      }
      if (hasScene()) {
        paramCodedOutputStreamMicro.writeString(20, getScene());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/GeneralRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */