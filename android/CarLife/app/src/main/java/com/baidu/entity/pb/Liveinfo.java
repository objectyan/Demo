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

public final class Liveinfo
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 3;
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int MSG_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private boolean e;
  private Data f = null;
  private int g = -1;
  
  public static Liveinfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Liveinfo().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Liveinfo parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Liveinfo)new Liveinfo().mergeFrom(paramArrayOfByte);
  }
  
  public final Liveinfo clear()
  {
    clearError();
    clearMsg();
    clearData();
    this.g = -1;
    return this;
  }
  
  public Liveinfo clearData()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public Liveinfo clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public Liveinfo clearMsg()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.g < 0) {
      getSerializedSize();
    }
    return this.g;
  }
  
  public Data getData()
  {
    return this.f;
  }
  
  public int getError()
  {
    return this.b;
  }
  
  public String getMsg()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    if (hasError()) {
      j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
    }
    int i = j;
    if (hasMsg()) {
      i = j + CodedOutputStreamMicro.computeStringSize(2, getMsg());
    }
    j = i;
    if (hasData()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(3, getData());
    }
    this.g = j;
    return j;
  }
  
  public boolean hasData()
  {
    return this.e;
  }
  
  public boolean hasError()
  {
    return this.a;
  }
  
  public boolean hasMsg()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Liveinfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 18: 
        setMsg(paramCodedInputStreamMicro.readString());
        break;
      case 26: 
        Data localData = new Data();
        paramCodedInputStreamMicro.readMessage(localData);
        setData(localData);
      }
    }
  }
  
  public Liveinfo setData(Data paramData)
  {
    if (paramData == null) {
      return clearData();
    }
    this.e = true;
    this.f = paramData;
    return this;
  }
  
  public Liveinfo setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public Liveinfo setMsg(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasError()) {
      paramCodedOutputStreamMicro.writeInt32(1, getError());
    }
    if (hasMsg()) {
      paramCodedOutputStreamMicro.writeString(2, getMsg());
    }
    if (hasData()) {
      paramCodedOutputStreamMicro.writeMessage(3, getData());
    }
  }
  
  public static final class Data
    extends MessageMicro
  {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int HEADER_FIELD_NUMBER = 1;
    public static final int INTERVAL_FIELD_NUMBER = 5;
    public static final int NUM_FIELD_NUMBER = 4;
    public static final int STAMP_FIELD_NUMBER = 3;
    public static final int STICK_FIELD_NUMBER = 6;
    private boolean a;
    private Header b = null;
    private List<Content> c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private boolean f;
    private String g = "";
    private boolean h;
    private String i = "";
    private List<Content> j = Collections.emptyList();
    private int k = -1;
    
    public static Data parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Data().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Data parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Data)new Data().mergeFrom(paramArrayOfByte);
    }
    
    public Data addContent(Content paramContent)
    {
      if (paramContent == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramContent);
      return this;
    }
    
    public Data addStick(Content paramContent)
    {
      if (paramContent == null) {
        return this;
      }
      if (this.j.isEmpty()) {
        this.j = new ArrayList();
      }
      this.j.add(paramContent);
      return this;
    }
    
    public final Data clear()
    {
      clearHeader();
      clearContent();
      clearStamp();
      clearNum();
      clearInterval();
      clearStick();
      this.k = -1;
      return this;
    }
    
    public Data clearContent()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public Data clearHeader()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public Data clearInterval()
    {
      this.h = false;
      this.i = "";
      return this;
    }
    
    public Data clearNum()
    {
      this.f = false;
      this.g = "";
      return this;
    }
    
    public Data clearStamp()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public Data clearStick()
    {
      this.j = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public Content getContent(int paramInt)
    {
      return (Content)this.c.get(paramInt);
    }
    
    public int getContentCount()
    {
      return this.c.size();
    }
    
    public List<Content> getContentList()
    {
      return this.c;
    }
    
    public Header getHeader()
    {
      return this.b;
    }
    
    public String getInterval()
    {
      return this.i;
    }
    
    public String getNum()
    {
      return this.g;
    }
    
    public int getSerializedSize()
    {
      int m = 0;
      if (hasHeader()) {
        m = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHeader());
      }
      Iterator localIterator = getContentList().iterator();
      for (int n = m; localIterator.hasNext(); n = CodedOutputStreamMicro.computeMessageSize(2, (Content)localIterator.next()) + n) {}
      m = n;
      if (hasStamp()) {
        m = n + CodedOutputStreamMicro.computeStringSize(3, getStamp());
      }
      n = m;
      if (hasNum()) {
        n = m + CodedOutputStreamMicro.computeStringSize(4, getNum());
      }
      m = n;
      if (hasInterval()) {
        m = n + CodedOutputStreamMicro.computeStringSize(5, getInterval());
      }
      localIterator = getStickList().iterator();
      while (localIterator.hasNext()) {
        m += CodedOutputStreamMicro.computeMessageSize(6, (Content)localIterator.next());
      }
      this.k = m;
      return m;
    }
    
    public String getStamp()
    {
      return this.e;
    }
    
    public Content getStick(int paramInt)
    {
      return (Content)this.j.get(paramInt);
    }
    
    public int getStickCount()
    {
      return this.j.size();
    }
    
    public List<Content> getStickList()
    {
      return this.j;
    }
    
    public boolean hasHeader()
    {
      return this.a;
    }
    
    public boolean hasInterval()
    {
      return this.h;
    }
    
    public boolean hasNum()
    {
      return this.f;
    }
    
    public boolean hasStamp()
    {
      return this.d;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Data mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int m = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (m)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new Header();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setHeader((Header)localObject);
          break;
        case 18: 
          localObject = new Content();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addContent((Content)localObject);
          break;
        case 26: 
          setStamp(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setNum(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setInterval(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          localObject = new Content();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addStick((Content)localObject);
        }
      }
    }
    
    public Data setContent(int paramInt, Content paramContent)
    {
      if (paramContent == null) {
        return this;
      }
      this.c.set(paramInt, paramContent);
      return this;
    }
    
    public Data setHeader(Header paramHeader)
    {
      if (paramHeader == null) {
        return clearHeader();
      }
      this.a = true;
      this.b = paramHeader;
      return this;
    }
    
    public Data setInterval(String paramString)
    {
      this.h = true;
      this.i = paramString;
      return this;
    }
    
    public Data setNum(String paramString)
    {
      this.f = true;
      this.g = paramString;
      return this;
    }
    
    public Data setStamp(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public Data setStick(int paramInt, Content paramContent)
    {
      if (paramContent == null) {
        return this;
      }
      this.j.set(paramInt, paramContent);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasHeader()) {
        paramCodedOutputStreamMicro.writeMessage(1, getHeader());
      }
      Iterator localIterator = getContentList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Content)localIterator.next());
      }
      if (hasStamp()) {
        paramCodedOutputStreamMicro.writeString(3, getStamp());
      }
      if (hasNum()) {
        paramCodedOutputStreamMicro.writeString(4, getNum());
      }
      if (hasInterval()) {
        paramCodedOutputStreamMicro.writeString(5, getInterval());
      }
      localIterator = getStickList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(6, (Content)localIterator.next());
      }
    }
    
    public static final class Content
      extends MessageMicro
    {
      public static final int AUDIO_FIELD_NUMBER = 12;
      public static final int AUTHEN_FIELD_NUMBER = 14;
      public static final int DESC_FIELD_NUMBER = 7;
      public static final int ID_FIELD_NUMBER = 1;
      public static final int IMGS_FIELD_NUMBER = 8;
      public static final int LINK_FIELD_NUMBER = 9;
      public static final int LOC_FIELD_NUMBER = 10;
      public static final int LOGO_FIELD_NUMBER = 3;
      public static final int NAME_FIELD_NUMBER = 5;
      public static final int QUOTE_FIELD_NUMBER = 13;
      public static final int ROLE_FIELD_NUMBER = 4;
      public static final int TAG_FIELD_NUMBER = 11;
      public static final int TIME_FIELD_NUMBER = 6;
      public static final int UID_FIELD_NUMBER = 2;
      public static final int VIDEO_FIELD_NUMBER = 15;
      private boolean A;
      private Video B = null;
      private int C = -1;
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
      private List<Img> o = Collections.emptyList();
      private boolean p;
      private String q = "";
      private boolean r;
      private Location s = null;
      private boolean t;
      private String u = "";
      private boolean v;
      private Audio w = null;
      private List<Quote> x = Collections.emptyList();
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
      
      public Content addImgs(Img paramImg)
      {
        if (paramImg == null) {
          return this;
        }
        if (this.o.isEmpty()) {
          this.o = new ArrayList();
        }
        this.o.add(paramImg);
        return this;
      }
      
      public Content addQuote(Quote paramQuote)
      {
        if (paramQuote == null) {
          return this;
        }
        if (this.x.isEmpty()) {
          this.x = new ArrayList();
        }
        this.x.add(paramQuote);
        return this;
      }
      
      public final Content clear()
      {
        clearId();
        clearUid();
        clearLogo();
        clearRole();
        clearName();
        clearTime();
        clearDesc();
        clearImgs();
        clearLink();
        clearLoc();
        clearTag();
        clearAudio();
        clearQuote();
        clearAuthen();
        clearVideo();
        this.C = -1;
        return this;
      }
      
      public Content clearAudio()
      {
        this.v = false;
        this.w = null;
        return this;
      }
      
      public Content clearAuthen()
      {
        this.y = false;
        this.z = "";
        return this;
      }
      
      public Content clearDesc()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public Content clearId()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Content clearImgs()
      {
        this.o = Collections.emptyList();
        return this;
      }
      
      public Content clearLink()
      {
        this.p = false;
        this.q = "";
        return this;
      }
      
      public Content clearLoc()
      {
        this.r = false;
        this.s = null;
        return this;
      }
      
      public Content clearLogo()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Content clearName()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public Content clearQuote()
      {
        this.x = Collections.emptyList();
        return this;
      }
      
      public Content clearRole()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Content clearTag()
      {
        this.t = false;
        this.u = "";
        return this;
      }
      
      public Content clearTime()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public Content clearUid()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Content clearVideo()
      {
        this.A = false;
        this.B = null;
        return this;
      }
      
      public Audio getAudio()
      {
        return this.w;
      }
      
      public String getAuthen()
      {
        return this.z;
      }
      
      public int getCachedSize()
      {
        if (this.C < 0) {
          getSerializedSize();
        }
        return this.C;
      }
      
      public String getDesc()
      {
        return this.n;
      }
      
      public String getId()
      {
        return this.b;
      }
      
      public Img getImgs(int paramInt)
      {
        return (Img)this.o.get(paramInt);
      }
      
      public int getImgsCount()
      {
        return this.o.size();
      }
      
      public List<Img> getImgsList()
      {
        return this.o;
      }
      
      public String getLink()
      {
        return this.q;
      }
      
      public Location getLoc()
      {
        return this.s;
      }
      
      public String getLogo()
      {
        return this.f;
      }
      
      public String getName()
      {
        return this.j;
      }
      
      public Quote getQuote(int paramInt)
      {
        return (Quote)this.x.get(paramInt);
      }
      
      public int getQuoteCount()
      {
        return this.x.size();
      }
      
      public List<Quote> getQuoteList()
      {
        return this.x;
      }
      
      public String getRole()
      {
        return this.h;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasId()) {
          i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getId());
        }
        int i1 = i2;
        if (hasUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getUid());
        }
        i2 = i1;
        if (hasLogo()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getLogo());
        }
        i1 = i2;
        if (hasRole()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getRole());
        }
        i2 = i1;
        if (hasName()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getName());
        }
        i1 = i2;
        if (hasTime()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getTime());
        }
        i2 = i1;
        if (hasDesc()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getDesc());
        }
        Iterator localIterator = getImgsList().iterator();
        while (localIterator.hasNext()) {
          i2 = CodedOutputStreamMicro.computeMessageSize(8, (Img)localIterator.next()) + i2;
        }
        i1 = i2;
        if (hasLink()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(9, getLink());
        }
        i2 = i1;
        if (hasLoc()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(10, getLoc());
        }
        i1 = i2;
        if (hasTag()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(11, getTag());
        }
        i2 = i1;
        if (hasAudio()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(12, getAudio());
        }
        localIterator = getQuoteList().iterator();
        while (localIterator.hasNext()) {
          i2 += CodedOutputStreamMicro.computeMessageSize(13, (Quote)localIterator.next());
        }
        i1 = i2;
        if (hasAuthen()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getAuthen());
        }
        i2 = i1;
        if (hasVideo()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(15, getVideo());
        }
        this.C = i2;
        return i2;
      }
      
      public String getTag()
      {
        return this.u;
      }
      
      public String getTime()
      {
        return this.l;
      }
      
      public String getUid()
      {
        return this.d;
      }
      
      public Video getVideo()
      {
        return this.B;
      }
      
      public boolean hasAudio()
      {
        return this.v;
      }
      
      public boolean hasAuthen()
      {
        return this.y;
      }
      
      public boolean hasDesc()
      {
        return this.m;
      }
      
      public boolean hasId()
      {
        return this.a;
      }
      
      public boolean hasLink()
      {
        return this.p;
      }
      
      public boolean hasLoc()
      {
        return this.r;
      }
      
      public boolean hasLogo()
      {
        return this.e;
      }
      
      public boolean hasName()
      {
        return this.i;
      }
      
      public boolean hasRole()
      {
        return this.g;
      }
      
      public boolean hasTag()
      {
        return this.t;
      }
      
      public boolean hasTime()
      {
        return this.k;
      }
      
      public boolean hasUid()
      {
        return this.c;
      }
      
      public boolean hasVideo()
      {
        return this.A;
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
            setId(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setLogo(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setRole(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setTime(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setDesc(paramCodedInputStreamMicro.readString());
            break;
          case 66: 
            localObject = new Img();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addImgs((Img)localObject);
            break;
          case 74: 
            setLink(paramCodedInputStreamMicro.readString());
            break;
          case 82: 
            localObject = new Location();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setLoc((Location)localObject);
            break;
          case 90: 
            setTag(paramCodedInputStreamMicro.readString());
            break;
          case 98: 
            localObject = new Audio();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setAudio((Audio)localObject);
            break;
          case 106: 
            localObject = new Quote();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addQuote((Quote)localObject);
            break;
          case 114: 
            setAuthen(paramCodedInputStreamMicro.readString());
            break;
          case 122: 
            localObject = new Video();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setVideo((Video)localObject);
          }
        }
      }
      
      public Content setAudio(Audio paramAudio)
      {
        if (paramAudio == null) {
          return clearAudio();
        }
        this.v = true;
        this.w = paramAudio;
        return this;
      }
      
      public Content setAuthen(String paramString)
      {
        this.y = true;
        this.z = paramString;
        return this;
      }
      
      public Content setDesc(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public Content setId(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Content setImgs(int paramInt, Img paramImg)
      {
        if (paramImg == null) {
          return this;
        }
        this.o.set(paramInt, paramImg);
        return this;
      }
      
      public Content setLink(String paramString)
      {
        this.p = true;
        this.q = paramString;
        return this;
      }
      
      public Content setLoc(Location paramLocation)
      {
        if (paramLocation == null) {
          return clearLoc();
        }
        this.r = true;
        this.s = paramLocation;
        return this;
      }
      
      public Content setLogo(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Content setName(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public Content setQuote(int paramInt, Quote paramQuote)
      {
        if (paramQuote == null) {
          return this;
        }
        this.x.set(paramInt, paramQuote);
        return this;
      }
      
      public Content setRole(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Content setTag(String paramString)
      {
        this.t = true;
        this.u = paramString;
        return this;
      }
      
      public Content setTime(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public Content setUid(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Content setVideo(Video paramVideo)
      {
        if (paramVideo == null) {
          return clearVideo();
        }
        this.A = true;
        this.B = paramVideo;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasId()) {
          paramCodedOutputStreamMicro.writeString(1, getId());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(2, getUid());
        }
        if (hasLogo()) {
          paramCodedOutputStreamMicro.writeString(3, getLogo());
        }
        if (hasRole()) {
          paramCodedOutputStreamMicro.writeString(4, getRole());
        }
        if (hasName()) {
          paramCodedOutputStreamMicro.writeString(5, getName());
        }
        if (hasTime()) {
          paramCodedOutputStreamMicro.writeString(6, getTime());
        }
        if (hasDesc()) {
          paramCodedOutputStreamMicro.writeString(7, getDesc());
        }
        Iterator localIterator = getImgsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(8, (Img)localIterator.next());
        }
        if (hasLink()) {
          paramCodedOutputStreamMicro.writeString(9, getLink());
        }
        if (hasLoc()) {
          paramCodedOutputStreamMicro.writeMessage(10, getLoc());
        }
        if (hasTag()) {
          paramCodedOutputStreamMicro.writeString(11, getTag());
        }
        if (hasAudio()) {
          paramCodedOutputStreamMicro.writeMessage(12, getAudio());
        }
        localIterator = getQuoteList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(13, (Quote)localIterator.next());
        }
        if (hasAuthen()) {
          paramCodedOutputStreamMicro.writeString(14, getAuthen());
        }
        if (hasVideo()) {
          paramCodedOutputStreamMicro.writeMessage(15, getVideo());
        }
      }
      
      public static final class Audio
        extends MessageMicro
      {
        public static final int LENGTH_FIELD_NUMBER = 2;
        public static final int SRC_FIELD_NUMBER = 1;
        private boolean a;
        private String b = "";
        private boolean c;
        private int d = 0;
        private int e = -1;
        
        public static Audio parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Audio().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Audio parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Audio)new Audio().mergeFrom(paramArrayOfByte);
        }
        
        public final Audio clear()
        {
          clearSrc();
          clearLength();
          this.e = -1;
          return this;
        }
        
        public Audio clearLength()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public Audio clearSrc()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.e < 0) {
            getSerializedSize();
          }
          return this.e;
        }
        
        public int getLength()
        {
          return this.d;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasSrc()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrc());
          }
          int j = i;
          if (hasLength()) {
            j = i + CodedOutputStreamMicro.computeInt32Size(2, getLength());
          }
          this.e = j;
          return j;
        }
        
        public String getSrc()
        {
          return this.b;
        }
        
        public boolean hasLength()
        {
          return this.c;
        }
        
        public boolean hasSrc()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Audio mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setSrc(paramCodedInputStreamMicro.readString());
              break;
            case 16: 
              setLength(paramCodedInputStreamMicro.readInt32());
            }
          }
        }
        
        public Audio setLength(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public Audio setSrc(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasSrc()) {
            paramCodedOutputStreamMicro.writeString(1, getSrc());
          }
          if (hasLength()) {
            paramCodedOutputStreamMicro.writeInt32(2, getLength());
          }
        }
      }
      
      public static final class Img
        extends MessageMicro
      {
        public static final int RAW_FIELD_NUMBER = 2;
        public static final int RAW_HEIGHT_FIELD_NUMBER = 6;
        public static final int RAW_WIDTH_FIELD_NUMBER = 5;
        public static final int THUMB_FIELD_NUMBER = 1;
        public static final int THUMB_HEIGHT_FIELD_NUMBER = 4;
        public static final int THUMB_WIDTH_FIELD_NUMBER = 3;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private int f = 0;
        private boolean g;
        private int h = 0;
        private boolean i;
        private int j = 0;
        private boolean k;
        private int l = 0;
        private int m = -1;
        
        public static Img parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Img().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Img parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Img)new Img().mergeFrom(paramArrayOfByte);
        }
        
        public final Img clear()
        {
          clearThumb();
          clearRaw();
          clearThumbWidth();
          clearThumbHeight();
          clearRawWidth();
          clearRawHeight();
          this.m = -1;
          return this;
        }
        
        public Img clearRaw()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public Img clearRawHeight()
        {
          this.k = false;
          this.l = 0;
          return this;
        }
        
        public Img clearRawWidth()
        {
          this.i = false;
          this.j = 0;
          return this;
        }
        
        public Img clearThumb()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public Img clearThumbHeight()
        {
          this.g = false;
          this.h = 0;
          return this;
        }
        
        public Img clearThumbWidth()
        {
          this.e = false;
          this.f = 0;
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.m < 0) {
            getSerializedSize();
          }
          return this.m;
        }
        
        public String getRaw()
        {
          return this.d;
        }
        
        public int getRawHeight()
        {
          return this.l;
        }
        
        public int getRawWidth()
        {
          return this.j;
        }
        
        public int getSerializedSize()
        {
          int i1 = 0;
          if (hasThumb()) {
            i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getThumb());
          }
          int n = i1;
          if (hasRaw()) {
            n = i1 + CodedOutputStreamMicro.computeStringSize(2, getRaw());
          }
          i1 = n;
          if (hasThumbWidth()) {
            i1 = n + CodedOutputStreamMicro.computeInt32Size(3, getThumbWidth());
          }
          n = i1;
          if (hasThumbHeight()) {
            n = i1 + CodedOutputStreamMicro.computeInt32Size(4, getThumbHeight());
          }
          i1 = n;
          if (hasRawWidth()) {
            i1 = n + CodedOutputStreamMicro.computeInt32Size(5, getRawWidth());
          }
          n = i1;
          if (hasRawHeight()) {
            n = i1 + CodedOutputStreamMicro.computeInt32Size(6, getRawHeight());
          }
          this.m = n;
          return n;
        }
        
        public String getThumb()
        {
          return this.b;
        }
        
        public int getThumbHeight()
        {
          return this.h;
        }
        
        public int getThumbWidth()
        {
          return this.f;
        }
        
        public boolean hasRaw()
        {
          return this.c;
        }
        
        public boolean hasRawHeight()
        {
          return this.k;
        }
        
        public boolean hasRawWidth()
        {
          return this.i;
        }
        
        public boolean hasThumb()
        {
          return this.a;
        }
        
        public boolean hasThumbHeight()
        {
          return this.g;
        }
        
        public boolean hasThumbWidth()
        {
          return this.e;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Img mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          for (;;)
          {
            int n = paramCodedInputStreamMicro.readTag();
            switch (n)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
              break;
            case 0: 
              return this;
            case 10: 
              setThumb(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setRaw(paramCodedInputStreamMicro.readString());
              break;
            case 24: 
              setThumbWidth(paramCodedInputStreamMicro.readInt32());
              break;
            case 32: 
              setThumbHeight(paramCodedInputStreamMicro.readInt32());
              break;
            case 40: 
              setRawWidth(paramCodedInputStreamMicro.readInt32());
              break;
            case 48: 
              setRawHeight(paramCodedInputStreamMicro.readInt32());
            }
          }
        }
        
        public Img setRaw(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public Img setRawHeight(int paramInt)
        {
          this.k = true;
          this.l = paramInt;
          return this;
        }
        
        public Img setRawWidth(int paramInt)
        {
          this.i = true;
          this.j = paramInt;
          return this;
        }
        
        public Img setThumb(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public Img setThumbHeight(int paramInt)
        {
          this.g = true;
          this.h = paramInt;
          return this;
        }
        
        public Img setThumbWidth(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasThumb()) {
            paramCodedOutputStreamMicro.writeString(1, getThumb());
          }
          if (hasRaw()) {
            paramCodedOutputStreamMicro.writeString(2, getRaw());
          }
          if (hasThumbWidth()) {
            paramCodedOutputStreamMicro.writeInt32(3, getThumbWidth());
          }
          if (hasThumbHeight()) {
            paramCodedOutputStreamMicro.writeInt32(4, getThumbHeight());
          }
          if (hasRawWidth()) {
            paramCodedOutputStreamMicro.writeInt32(5, getRawWidth());
          }
          if (hasRawHeight()) {
            paramCodedOutputStreamMicro.writeInt32(6, getRawHeight());
          }
        }
      }
      
      public static final class Location
        extends MessageMicro
      {
        public static final int LAT_FIELD_NUMBER = 2;
        public static final int LNG_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 3;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private String f = "";
        private int g = -1;
        
        public static Location parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Location().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Location parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Location)new Location().mergeFrom(paramArrayOfByte);
        }
        
        public final Location clear()
        {
          clearLng();
          clearLat();
          clearName();
          this.g = -1;
          return this;
        }
        
        public Location clearLat()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public Location clearLng()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public Location clearName()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.g < 0) {
            getSerializedSize();
          }
          return this.g;
        }
        
        public String getLat()
        {
          return this.d;
        }
        
        public String getLng()
        {
          return this.b;
        }
        
        public String getName()
        {
          return this.f;
        }
        
        public int getSerializedSize()
        {
          int j = 0;
          if (hasLng()) {
            j = 0 + CodedOutputStreamMicro.computeStringSize(1, getLng());
          }
          int i = j;
          if (hasLat()) {
            i = j + CodedOutputStreamMicro.computeStringSize(2, getLat());
          }
          j = i;
          if (hasName()) {
            j = i + CodedOutputStreamMicro.computeStringSize(3, getName());
          }
          this.g = j;
          return j;
        }
        
        public boolean hasLat()
        {
          return this.c;
        }
        
        public boolean hasLng()
        {
          return this.a;
        }
        
        public boolean hasName()
        {
          return this.e;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Location mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setLng(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setLat(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              setName(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Location setLat(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public Location setLng(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public Location setName(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasLng()) {
            paramCodedOutputStreamMicro.writeString(1, getLng());
          }
          if (hasLat()) {
            paramCodedOutputStreamMicro.writeString(2, getLat());
          }
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(3, getName());
          }
        }
      }
      
      public static final class Quote
        extends MessageMicro
      {
        public static final int AUDIO_FIELD_NUMBER = 10;
        public static final int DESC_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int IMGS_FIELD_NUMBER = 6;
        public static final int LINK_FIELD_NUMBER = 7;
        public static final int LOC_FIELD_NUMBER = 8;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int ROLE_FIELD_NUMBER = 2;
        public static final int TAG_FIELD_NUMBER = 9;
        public static final int TIME_FIELD_NUMBER = 4;
        public static final int UID_FIELD_NUMBER = 11;
        public static final int VIDEO_FIELD_NUMBER = 12;
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
        private List<Liveinfo.Data.Content.Img> k = Collections.emptyList();
        private boolean l;
        private String m = "";
        private boolean n;
        private Liveinfo.Data.Content.Location o = null;
        private boolean p;
        private String q = "";
        private boolean r;
        private Liveinfo.Data.Content.Audio s = null;
        private boolean t;
        private String u = "";
        private boolean v;
        private Liveinfo.Data.Content.Video w = null;
        private int x = -1;
        
        public static Quote parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Quote().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Quote parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Quote)new Quote().mergeFrom(paramArrayOfByte);
        }
        
        public Quote addImgs(Liveinfo.Data.Content.Img paramImg)
        {
          if (paramImg == null) {
            return this;
          }
          if (this.k.isEmpty()) {
            this.k = new ArrayList();
          }
          this.k.add(paramImg);
          return this;
        }
        
        public final Quote clear()
        {
          clearId();
          clearRole();
          clearName();
          clearTime();
          clearDesc();
          clearImgs();
          clearLink();
          clearLoc();
          clearTag();
          clearAudio();
          clearUid();
          clearVideo();
          this.x = -1;
          return this;
        }
        
        public Quote clearAudio()
        {
          this.r = false;
          this.s = null;
          return this;
        }
        
        public Quote clearDesc()
        {
          this.i = false;
          this.j = "";
          return this;
        }
        
        public Quote clearId()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public Quote clearImgs()
        {
          this.k = Collections.emptyList();
          return this;
        }
        
        public Quote clearLink()
        {
          this.l = false;
          this.m = "";
          return this;
        }
        
        public Quote clearLoc()
        {
          this.n = false;
          this.o = null;
          return this;
        }
        
        public Quote clearName()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public Quote clearRole()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public Quote clearTag()
        {
          this.p = false;
          this.q = "";
          return this;
        }
        
        public Quote clearTime()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public Quote clearUid()
        {
          this.t = false;
          this.u = "";
          return this;
        }
        
        public Quote clearVideo()
        {
          this.v = false;
          this.w = null;
          return this;
        }
        
        public Liveinfo.Data.Content.Audio getAudio()
        {
          return this.s;
        }
        
        public int getCachedSize()
        {
          if (this.x < 0) {
            getSerializedSize();
          }
          return this.x;
        }
        
        public String getDesc()
        {
          return this.j;
        }
        
        public String getId()
        {
          return this.b;
        }
        
        public Liveinfo.Data.Content.Img getImgs(int paramInt)
        {
          return (Liveinfo.Data.Content.Img)this.k.get(paramInt);
        }
        
        public int getImgsCount()
        {
          return this.k.size();
        }
        
        public List<Liveinfo.Data.Content.Img> getImgsList()
        {
          return this.k;
        }
        
        public String getLink()
        {
          return this.m;
        }
        
        public Liveinfo.Data.Content.Location getLoc()
        {
          return this.o;
        }
        
        public String getName()
        {
          return this.f;
        }
        
        public String getRole()
        {
          return this.d;
        }
        
        public int getSerializedSize()
        {
          int i2 = 0;
          if (hasId()) {
            i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getId());
          }
          int i1 = i2;
          if (hasRole()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getRole());
          }
          i2 = i1;
          if (hasName()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getName());
          }
          i1 = i2;
          if (hasTime()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getTime());
          }
          i2 = i1;
          if (hasDesc()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getDesc());
          }
          Iterator localIterator = getImgsList().iterator();
          while (localIterator.hasNext()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(6, (Liveinfo.Data.Content.Img)localIterator.next()) + i2;
          }
          i1 = i2;
          if (hasLink()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getLink());
          }
          i2 = i1;
          if (hasLoc()) {
            i2 = i1 + CodedOutputStreamMicro.computeMessageSize(8, getLoc());
          }
          i1 = i2;
          if (hasTag()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(9, getTag());
          }
          i2 = i1;
          if (hasAudio()) {
            i2 = i1 + CodedOutputStreamMicro.computeMessageSize(10, getAudio());
          }
          i1 = i2;
          if (hasUid()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(11, getUid());
          }
          i2 = i1;
          if (hasVideo()) {
            i2 = i1 + CodedOutputStreamMicro.computeMessageSize(12, getVideo());
          }
          this.x = i2;
          return i2;
        }
        
        public String getTag()
        {
          return this.q;
        }
        
        public String getTime()
        {
          return this.h;
        }
        
        public String getUid()
        {
          return this.u;
        }
        
        public Liveinfo.Data.Content.Video getVideo()
        {
          return this.w;
        }
        
        public boolean hasAudio()
        {
          return this.r;
        }
        
        public boolean hasDesc()
        {
          return this.i;
        }
        
        public boolean hasId()
        {
          return this.a;
        }
        
        public boolean hasLink()
        {
          return this.l;
        }
        
        public boolean hasLoc()
        {
          return this.n;
        }
        
        public boolean hasName()
        {
          return this.e;
        }
        
        public boolean hasRole()
        {
          return this.c;
        }
        
        public boolean hasTag()
        {
          return this.p;
        }
        
        public boolean hasTime()
        {
          return this.g;
        }
        
        public boolean hasUid()
        {
          return this.t;
        }
        
        public boolean hasVideo()
        {
          return this.v;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Quote mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setId(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setRole(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              setName(paramCodedInputStreamMicro.readString());
              break;
            case 34: 
              setTime(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              setDesc(paramCodedInputStreamMicro.readString());
              break;
            case 50: 
              localObject = new Liveinfo.Data.Content.Img();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addImgs((Liveinfo.Data.Content.Img)localObject);
              break;
            case 58: 
              setLink(paramCodedInputStreamMicro.readString());
              break;
            case 66: 
              localObject = new Liveinfo.Data.Content.Location();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setLoc((Liveinfo.Data.Content.Location)localObject);
              break;
            case 74: 
              setTag(paramCodedInputStreamMicro.readString());
              break;
            case 82: 
              localObject = new Liveinfo.Data.Content.Audio();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setAudio((Liveinfo.Data.Content.Audio)localObject);
              break;
            case 90: 
              setUid(paramCodedInputStreamMicro.readString());
              break;
            case 98: 
              localObject = new Liveinfo.Data.Content.Video();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setVideo((Liveinfo.Data.Content.Video)localObject);
            }
          }
        }
        
        public Quote setAudio(Liveinfo.Data.Content.Audio paramAudio)
        {
          if (paramAudio == null) {
            return clearAudio();
          }
          this.r = true;
          this.s = paramAudio;
          return this;
        }
        
        public Quote setDesc(String paramString)
        {
          this.i = true;
          this.j = paramString;
          return this;
        }
        
        public Quote setId(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public Quote setImgs(int paramInt, Liveinfo.Data.Content.Img paramImg)
        {
          if (paramImg == null) {
            return this;
          }
          this.k.set(paramInt, paramImg);
          return this;
        }
        
        public Quote setLink(String paramString)
        {
          this.l = true;
          this.m = paramString;
          return this;
        }
        
        public Quote setLoc(Liveinfo.Data.Content.Location paramLocation)
        {
          if (paramLocation == null) {
            return clearLoc();
          }
          this.n = true;
          this.o = paramLocation;
          return this;
        }
        
        public Quote setName(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public Quote setRole(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public Quote setTag(String paramString)
        {
          this.p = true;
          this.q = paramString;
          return this;
        }
        
        public Quote setTime(String paramString)
        {
          this.g = true;
          this.h = paramString;
          return this;
        }
        
        public Quote setUid(String paramString)
        {
          this.t = true;
          this.u = paramString;
          return this;
        }
        
        public Quote setVideo(Liveinfo.Data.Content.Video paramVideo)
        {
          if (paramVideo == null) {
            return clearVideo();
          }
          this.v = true;
          this.w = paramVideo;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasId()) {
            paramCodedOutputStreamMicro.writeString(1, getId());
          }
          if (hasRole()) {
            paramCodedOutputStreamMicro.writeString(2, getRole());
          }
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(3, getName());
          }
          if (hasTime()) {
            paramCodedOutputStreamMicro.writeString(4, getTime());
          }
          if (hasDesc()) {
            paramCodedOutputStreamMicro.writeString(5, getDesc());
          }
          Iterator localIterator = getImgsList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(6, (Liveinfo.Data.Content.Img)localIterator.next());
          }
          if (hasLink()) {
            paramCodedOutputStreamMicro.writeString(7, getLink());
          }
          if (hasLoc()) {
            paramCodedOutputStreamMicro.writeMessage(8, getLoc());
          }
          if (hasTag()) {
            paramCodedOutputStreamMicro.writeString(9, getTag());
          }
          if (hasAudio()) {
            paramCodedOutputStreamMicro.writeMessage(10, getAudio());
          }
          if (hasUid()) {
            paramCodedOutputStreamMicro.writeString(11, getUid());
          }
          if (hasVideo()) {
            paramCodedOutputStreamMicro.writeMessage(12, getVideo());
          }
        }
      }
      
      public static final class Video
        extends MessageMicro
      {
        public static final int LENGTH_FIELD_NUMBER = 6;
        public static final int RAW_FIELD_NUMBER = 4;
        public static final int SIZE_FIELD_NUMBER = 5;
        public static final int THUMB_FIELD_NUMBER = 1;
        public static final int THUMB_HEIGHT_FIELD_NUMBER = 3;
        public static final int THUMB_WIDTH_FIELD_NUMBER = 2;
        private boolean a;
        private String b = "";
        private boolean c;
        private int d = 0;
        private boolean e;
        private int f = 0;
        private boolean g;
        private String h = "";
        private boolean i;
        private int j = 0;
        private boolean k;
        private int l = 0;
        private int m = -1;
        
        public static Video parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Video().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Video parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Video)new Video().mergeFrom(paramArrayOfByte);
        }
        
        public final Video clear()
        {
          clearThumb();
          clearThumbWidth();
          clearThumbHeight();
          clearRaw();
          clearSize();
          clearLength();
          this.m = -1;
          return this;
        }
        
        public Video clearLength()
        {
          this.k = false;
          this.l = 0;
          return this;
        }
        
        public Video clearRaw()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public Video clearSize()
        {
          this.i = false;
          this.j = 0;
          return this;
        }
        
        public Video clearThumb()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public Video clearThumbHeight()
        {
          this.e = false;
          this.f = 0;
          return this;
        }
        
        public Video clearThumbWidth()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.m < 0) {
            getSerializedSize();
          }
          return this.m;
        }
        
        public int getLength()
        {
          return this.l;
        }
        
        public String getRaw()
        {
          return this.h;
        }
        
        public int getSerializedSize()
        {
          int i1 = 0;
          if (hasThumb()) {
            i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getThumb());
          }
          int n = i1;
          if (hasThumbWidth()) {
            n = i1 + CodedOutputStreamMicro.computeInt32Size(2, getThumbWidth());
          }
          i1 = n;
          if (hasThumbHeight()) {
            i1 = n + CodedOutputStreamMicro.computeInt32Size(3, getThumbHeight());
          }
          n = i1;
          if (hasRaw()) {
            n = i1 + CodedOutputStreamMicro.computeStringSize(4, getRaw());
          }
          i1 = n;
          if (hasSize()) {
            i1 = n + CodedOutputStreamMicro.computeInt32Size(5, getSize());
          }
          n = i1;
          if (hasLength()) {
            n = i1 + CodedOutputStreamMicro.computeInt32Size(6, getLength());
          }
          this.m = n;
          return n;
        }
        
        public int getSize()
        {
          return this.j;
        }
        
        public String getThumb()
        {
          return this.b;
        }
        
        public int getThumbHeight()
        {
          return this.f;
        }
        
        public int getThumbWidth()
        {
          return this.d;
        }
        
        public boolean hasLength()
        {
          return this.k;
        }
        
        public boolean hasRaw()
        {
          return this.g;
        }
        
        public boolean hasSize()
        {
          return this.i;
        }
        
        public boolean hasThumb()
        {
          return this.a;
        }
        
        public boolean hasThumbHeight()
        {
          return this.e;
        }
        
        public boolean hasThumbWidth()
        {
          return this.c;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Video mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          for (;;)
          {
            int n = paramCodedInputStreamMicro.readTag();
            switch (n)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
              break;
            case 0: 
              return this;
            case 10: 
              setThumb(paramCodedInputStreamMicro.readString());
              break;
            case 16: 
              setThumbWidth(paramCodedInputStreamMicro.readInt32());
              break;
            case 24: 
              setThumbHeight(paramCodedInputStreamMicro.readInt32());
              break;
            case 34: 
              setRaw(paramCodedInputStreamMicro.readString());
              break;
            case 40: 
              setSize(paramCodedInputStreamMicro.readInt32());
              break;
            case 48: 
              setLength(paramCodedInputStreamMicro.readInt32());
            }
          }
        }
        
        public Video setLength(int paramInt)
        {
          this.k = true;
          this.l = paramInt;
          return this;
        }
        
        public Video setRaw(String paramString)
        {
          this.g = true;
          this.h = paramString;
          return this;
        }
        
        public Video setSize(int paramInt)
        {
          this.i = true;
          this.j = paramInt;
          return this;
        }
        
        public Video setThumb(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public Video setThumbHeight(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
          return this;
        }
        
        public Video setThumbWidth(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasThumb()) {
            paramCodedOutputStreamMicro.writeString(1, getThumb());
          }
          if (hasThumbWidth()) {
            paramCodedOutputStreamMicro.writeInt32(2, getThumbWidth());
          }
          if (hasThumbHeight()) {
            paramCodedOutputStreamMicro.writeInt32(3, getThumbHeight());
          }
          if (hasRaw()) {
            paramCodedOutputStreamMicro.writeString(4, getRaw());
          }
          if (hasSize()) {
            paramCodedOutputStreamMicro.writeInt32(5, getSize());
          }
          if (hasLength()) {
            paramCodedOutputStreamMicro.writeInt32(6, getLength());
          }
        }
      }
    }
    
    public static final class Header
      extends MessageMicro
    {
      public static final int ANONYMOUS_FIELD_NUMBER = 7;
      public static final int DEADLINE_FIELD_NUMBER = 4;
      public static final int EDITMODE_FIELD_NUMBER = 8;
      public static final int FORCAST_FIELD_NUMBER = 6;
      public static final int ISOPENVIDEO_FIELD_NUMBER = 9;
      public static final int PLANID_FIELD_NUMBER = 3;
      public static final int PRESENT_FIELD_NUMBER = 5;
      public static final int STATUS_FIELD_NUMBER = 1;
      public static final int TITLE_FIELD_NUMBER = 2;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private boolean e;
      private int f = 0;
      private boolean g;
      private int h = 0;
      private boolean i;
      private String j = "";
      private boolean k;
      private String l = "";
      private boolean m;
      private int n = 0;
      private boolean o;
      private int p = 0;
      private boolean q;
      private int r = 0;
      private int s = -1;
      
      public static Header parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Header().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Header parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Header)new Header().mergeFrom(paramArrayOfByte);
      }
      
      public final Header clear()
      {
        clearStatus();
        clearTitle();
        clearPlanid();
        clearDeadline();
        clearPresent();
        clearForcast();
        clearAnonymous();
        clearEditmode();
        clearIsopenvideo();
        this.s = -1;
        return this;
      }
      
      public Header clearAnonymous()
      {
        this.m = false;
        this.n = 0;
        return this;
      }
      
      public Header clearDeadline()
      {
        this.g = false;
        this.h = 0;
        return this;
      }
      
      public Header clearEditmode()
      {
        this.o = false;
        this.p = 0;
        return this;
      }
      
      public Header clearForcast()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public Header clearIsopenvideo()
      {
        this.q = false;
        this.r = 0;
        return this;
      }
      
      public Header clearPlanid()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public Header clearPresent()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public Header clearStatus()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public Header clearTitle()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public int getAnonymous()
      {
        return this.n;
      }
      
      public int getCachedSize()
      {
        if (this.s < 0) {
          getSerializedSize();
        }
        return this.s;
      }
      
      public int getDeadline()
      {
        return this.h;
      }
      
      public int getEditmode()
      {
        return this.p;
      }
      
      public String getForcast()
      {
        return this.l;
      }
      
      public int getIsopenvideo()
      {
        return this.r;
      }
      
      public int getPlanid()
      {
        return this.f;
      }
      
      public String getPresent()
      {
        return this.j;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasStatus()) {
          i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStatus());
        }
        int i1 = i2;
        if (hasTitle()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getTitle());
        }
        i2 = i1;
        if (hasPlanid()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getPlanid());
        }
        i1 = i2;
        if (hasDeadline()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getDeadline());
        }
        i2 = i1;
        if (hasPresent()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getPresent());
        }
        i1 = i2;
        if (hasForcast()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getForcast());
        }
        i2 = i1;
        if (hasAnonymous()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getAnonymous());
        }
        i1 = i2;
        if (hasEditmode()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getEditmode());
        }
        i2 = i1;
        if (hasIsopenvideo()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getIsopenvideo());
        }
        this.s = i2;
        return i2;
      }
      
      public int getStatus()
      {
        return this.b;
      }
      
      public String getTitle()
      {
        return this.d;
      }
      
      public boolean hasAnonymous()
      {
        return this.m;
      }
      
      public boolean hasDeadline()
      {
        return this.g;
      }
      
      public boolean hasEditmode()
      {
        return this.o;
      }
      
      public boolean hasForcast()
      {
        return this.k;
      }
      
      public boolean hasIsopenvideo()
      {
        return this.q;
      }
      
      public boolean hasPlanid()
      {
        return this.e;
      }
      
      public boolean hasPresent()
      {
        return this.i;
      }
      
      public boolean hasStatus()
      {
        return this.a;
      }
      
      public boolean hasTitle()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Header mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setStatus(paramCodedInputStreamMicro.readInt32());
            break;
          case 18: 
            setTitle(paramCodedInputStreamMicro.readString());
            break;
          case 24: 
            setPlanid(paramCodedInputStreamMicro.readInt32());
            break;
          case 32: 
            setDeadline(paramCodedInputStreamMicro.readInt32());
            break;
          case 42: 
            setPresent(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setForcast(paramCodedInputStreamMicro.readString());
            break;
          case 56: 
            setAnonymous(paramCodedInputStreamMicro.readInt32());
            break;
          case 64: 
            setEditmode(paramCodedInputStreamMicro.readInt32());
            break;
          case 72: 
            setIsopenvideo(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public Header setAnonymous(int paramInt)
      {
        this.m = true;
        this.n = paramInt;
        return this;
      }
      
      public Header setDeadline(int paramInt)
      {
        this.g = true;
        this.h = paramInt;
        return this;
      }
      
      public Header setEditmode(int paramInt)
      {
        this.o = true;
        this.p = paramInt;
        return this;
      }
      
      public Header setForcast(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public Header setIsopenvideo(int paramInt)
      {
        this.q = true;
        this.r = paramInt;
        return this;
      }
      
      public Header setPlanid(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public Header setPresent(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public Header setStatus(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public Header setTitle(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasStatus()) {
          paramCodedOutputStreamMicro.writeInt32(1, getStatus());
        }
        if (hasTitle()) {
          paramCodedOutputStreamMicro.writeString(2, getTitle());
        }
        if (hasPlanid()) {
          paramCodedOutputStreamMicro.writeInt32(3, getPlanid());
        }
        if (hasDeadline()) {
          paramCodedOutputStreamMicro.writeInt32(4, getDeadline());
        }
        if (hasPresent()) {
          paramCodedOutputStreamMicro.writeString(5, getPresent());
        }
        if (hasForcast()) {
          paramCodedOutputStreamMicro.writeString(6, getForcast());
        }
        if (hasAnonymous()) {
          paramCodedOutputStreamMicro.writeInt32(7, getAnonymous());
        }
        if (hasEditmode()) {
          paramCodedOutputStreamMicro.writeInt32(8, getEditmode());
        }
        if (hasIsopenvideo()) {
          paramCodedOutputStreamMicro.writeInt32(9, getIsopenvideo());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Liveinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */