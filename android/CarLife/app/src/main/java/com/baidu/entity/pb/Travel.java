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

public final class Travel
  extends MessageMicro
{
  public static final int CARD_FIELD_NUMBER = 2;
  public static final int FEEDLIST_FIELD_NUMBER = 8;
  public static final int HEADER_FIELD_NUMBER = 1;
  public static final int IMGURL_FIELD_NUMBER = 6;
  public static final int INFO_FIELD_NUMBER = 4;
  public static final int NONLOCAL_FIELD_NUMBER = 5;
  public static final int ROUTE_FIELD_NUMBER = 3;
  public static final int SHARE_FIELD_NUMBER = 7;
  private boolean a;
  private Header b = null;
  private List<Card> c = Collections.emptyList();
  private boolean d;
  private Route e = null;
  private boolean f;
  private Infomation g = null;
  private boolean h;
  private Nonlocal i = null;
  private boolean j;
  private String k = "";
  private boolean l;
  private Share m = null;
  private boolean n;
  private Feedlist o = null;
  private int p = -1;
  
  public static Travel parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Travel().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Travel parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Travel)new Travel().mergeFrom(paramArrayOfByte);
  }
  
  public Travel addCard(Card paramCard)
  {
    if (paramCard == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramCard);
    return this;
  }
  
  public final Travel clear()
  {
    clearHeader();
    clearCard();
    clearRoute();
    clearInfo();
    clearNonlocal();
    clearImgurl();
    clearShare();
    clearFeedlist();
    this.p = -1;
    return this;
  }
  
  public Travel clearCard()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public Travel clearFeedlist()
  {
    this.n = false;
    this.o = null;
    return this;
  }
  
  public Travel clearHeader()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public Travel clearImgurl()
  {
    this.j = false;
    this.k = "";
    return this;
  }
  
  public Travel clearInfo()
  {
    this.f = false;
    this.g = null;
    return this;
  }
  
  public Travel clearNonlocal()
  {
    this.h = false;
    this.i = null;
    return this;
  }
  
  public Travel clearRoute()
  {
    this.d = false;
    this.e = null;
    return this;
  }
  
  public Travel clearShare()
  {
    this.l = false;
    this.m = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.p < 0) {
      getSerializedSize();
    }
    return this.p;
  }
  
  public Card getCard(int paramInt)
  {
    return (Card)this.c.get(paramInt);
  }
  
  public int getCardCount()
  {
    return this.c.size();
  }
  
  public List<Card> getCardList()
  {
    return this.c;
  }
  
  public Feedlist getFeedlist()
  {
    return this.o;
  }
  
  public Header getHeader()
  {
    return this.b;
  }
  
  public String getImgurl()
  {
    return this.k;
  }
  
  public Infomation getInfo()
  {
    return this.g;
  }
  
  public Nonlocal getNonlocal()
  {
    return this.i;
  }
  
  public Route getRoute()
  {
    return this.e;
  }
  
  public int getSerializedSize()
  {
    int i1 = 0;
    if (hasHeader()) {
      i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHeader());
    }
    Iterator localIterator = getCardList().iterator();
    for (int i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(2, (Card)localIterator.next()) + i2) {}
    i1 = i2;
    if (hasRoute()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(3, getRoute());
    }
    i2 = i1;
    if (hasInfo()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(4, getInfo());
    }
    i1 = i2;
    if (hasNonlocal()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(5, getNonlocal());
    }
    i2 = i1;
    if (hasImgurl()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(6, getImgurl());
    }
    i1 = i2;
    if (hasShare()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(7, getShare());
    }
    i2 = i1;
    if (hasFeedlist()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(8, getFeedlist());
    }
    this.p = i2;
    return i2;
  }
  
  public Share getShare()
  {
    return this.m;
  }
  
  public boolean hasFeedlist()
  {
    return this.n;
  }
  
  public boolean hasHeader()
  {
    return this.a;
  }
  
  public boolean hasImgurl()
  {
    return this.j;
  }
  
  public boolean hasInfo()
  {
    return this.f;
  }
  
  public boolean hasNonlocal()
  {
    return this.h;
  }
  
  public boolean hasRoute()
  {
    return this.d;
  }
  
  public boolean hasShare()
  {
    return this.l;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Travel mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Header();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setHeader((Header)localObject);
        break;
      case 18: 
        localObject = new Card();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addCard((Card)localObject);
        break;
      case 26: 
        localObject = new Route();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setRoute((Route)localObject);
        break;
      case 34: 
        localObject = new Infomation();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setInfo((Infomation)localObject);
        break;
      case 42: 
        localObject = new Nonlocal();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setNonlocal((Nonlocal)localObject);
        break;
      case 50: 
        setImgurl(paramCodedInputStreamMicro.readString());
        break;
      case 58: 
        localObject = new Share();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setShare((Share)localObject);
        break;
      case 66: 
        localObject = new Feedlist();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setFeedlist((Feedlist)localObject);
      }
    }
  }
  
  public Travel setCard(int paramInt, Card paramCard)
  {
    if (paramCard == null) {
      return this;
    }
    this.c.set(paramInt, paramCard);
    return this;
  }
  
  public Travel setFeedlist(Feedlist paramFeedlist)
  {
    if (paramFeedlist == null) {
      return clearFeedlist();
    }
    this.n = true;
    this.o = paramFeedlist;
    return this;
  }
  
  public Travel setHeader(Header paramHeader)
  {
    if (paramHeader == null) {
      return clearHeader();
    }
    this.a = true;
    this.b = paramHeader;
    return this;
  }
  
  public Travel setImgurl(String paramString)
  {
    this.j = true;
    this.k = paramString;
    return this;
  }
  
  public Travel setInfo(Infomation paramInfomation)
  {
    if (paramInfomation == null) {
      return clearInfo();
    }
    this.f = true;
    this.g = paramInfomation;
    return this;
  }
  
  public Travel setNonlocal(Nonlocal paramNonlocal)
  {
    if (paramNonlocal == null) {
      return clearNonlocal();
    }
    this.h = true;
    this.i = paramNonlocal;
    return this;
  }
  
  public Travel setRoute(Route paramRoute)
  {
    if (paramRoute == null) {
      return clearRoute();
    }
    this.d = true;
    this.e = paramRoute;
    return this;
  }
  
  public Travel setShare(Share paramShare)
  {
    if (paramShare == null) {
      return clearShare();
    }
    this.l = true;
    this.m = paramShare;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasHeader()) {
      paramCodedOutputStreamMicro.writeMessage(1, getHeader());
    }
    Iterator localIterator = getCardList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (Card)localIterator.next());
    }
    if (hasRoute()) {
      paramCodedOutputStreamMicro.writeMessage(3, getRoute());
    }
    if (hasInfo()) {
      paramCodedOutputStreamMicro.writeMessage(4, getInfo());
    }
    if (hasNonlocal()) {
      paramCodedOutputStreamMicro.writeMessage(5, getNonlocal());
    }
    if (hasImgurl()) {
      paramCodedOutputStreamMicro.writeString(6, getImgurl());
    }
    if (hasShare()) {
      paramCodedOutputStreamMicro.writeMessage(7, getShare());
    }
    if (hasFeedlist()) {
      paramCodedOutputStreamMicro.writeMessage(8, getFeedlist());
    }
  }
  
  public static final class Card
    extends MessageMicro
  {
    public static final int DESC_FIELD_NUMBER = 3;
    public static final int ICONURL_FIELD_NUMBER = 5;
    public static final int LINK_FIELD_NUMBER = 4;
    public static final int SUMMARY_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 1;
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
    
    public static Card parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Card().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Card parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Card)new Card().mergeFrom(paramArrayOfByte);
    }
    
    public final Card clear()
    {
      clearTitle();
      clearSummary();
      clearDesc();
      clearLink();
      clearIconurl();
      this.k = -1;
      return this;
    }
    
    public Card clearDesc()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Card clearIconurl()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Card clearLink()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Card clearSummary()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Card clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public String getDesc()
    {
      return this.f;
    }
    
    public String getIconurl()
    {
      return this.j;
    }
    
    public String getLink()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasTitle()) {
        n = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      int m = n;
      if (hasSummary()) {
        m = n + CodedOutputStreamMicro.computeStringSize(2, getSummary());
      }
      n = m;
      if (hasDesc()) {
        n = m + CodedOutputStreamMicro.computeStringSize(3, getDesc());
      }
      m = n;
      if (hasLink()) {
        m = n + CodedOutputStreamMicro.computeStringSize(4, getLink());
      }
      n = m;
      if (hasIconurl()) {
        n = m + CodedOutputStreamMicro.computeStringSize(5, getIconurl());
      }
      this.k = n;
      return n;
    }
    
    public String getSummary()
    {
      return this.d;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public boolean hasDesc()
    {
      return this.e;
    }
    
    public boolean hasIconurl()
    {
      return this.i;
    }
    
    public boolean hasLink()
    {
      return this.g;
    }
    
    public boolean hasSummary()
    {
      return this.c;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Card mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setSummary(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setDesc(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setLink(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setIconurl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Card setDesc(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Card setIconurl(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Card setLink(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Card setSummary(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Card setTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(1, getTitle());
      }
      if (hasSummary()) {
        paramCodedOutputStreamMicro.writeString(2, getSummary());
      }
      if (hasDesc()) {
        paramCodedOutputStreamMicro.writeString(3, getDesc());
      }
      if (hasLink()) {
        paramCodedOutputStreamMicro.writeString(4, getLink());
      }
      if (hasIconurl()) {
        paramCodedOutputStreamMicro.writeString(5, getIconurl());
      }
    }
  }
  
  public static final class Feedlist
    extends MessageMicro
  {
    public static final int FEED_FIELD_NUMBER = 1;
    public static final int LOGID_FIELD_NUMBER = 2;
    public static final int MAXNUM_FIELD_NUMBER = 4;
    public static final int SSID_FIELD_NUMBER = 3;
    public static final int TITLEURL_FIELD_NUMBER = 5;
    private List<Feed> a = Collections.emptyList();
    private boolean b;
    private String c = "";
    private boolean d;
    private String e = "";
    private boolean f;
    private int g = 0;
    private boolean h;
    private String i = "";
    private int j = -1;
    
    public static Feedlist parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Feedlist().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Feedlist parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Feedlist)new Feedlist().mergeFrom(paramArrayOfByte);
    }
    
    public Feedlist addFeed(Feed paramFeed)
    {
      if (paramFeed == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramFeed);
      return this;
    }
    
    public final Feedlist clear()
    {
      clearFeed();
      clearLogid();
      clearSsid();
      clearMaxnum();
      clearTitleurl();
      this.j = -1;
      return this;
    }
    
    public Feedlist clearFeed()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Feedlist clearLogid()
    {
      this.b = false;
      this.c = "";
      return this;
    }
    
    public Feedlist clearMaxnum()
    {
      this.f = false;
      this.g = 0;
      return this;
    }
    
    public Feedlist clearSsid()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public Feedlist clearTitleurl()
    {
      this.h = false;
      this.i = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.j < 0) {
        getSerializedSize();
      }
      return this.j;
    }
    
    public Feed getFeed(int paramInt)
    {
      return (Feed)this.a.get(paramInt);
    }
    
    public int getFeedCount()
    {
      return this.a.size();
    }
    
    public List<Feed> getFeedList()
    {
      return this.a;
    }
    
    public String getLogid()
    {
      return this.c;
    }
    
    public int getMaxnum()
    {
      return this.g;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getFeedList().iterator();
      for (int m = 0; localIterator.hasNext(); m = CodedOutputStreamMicro.computeMessageSize(1, (Feed)localIterator.next()) + m) {}
      int k = m;
      if (hasLogid()) {
        k = m + CodedOutputStreamMicro.computeStringSize(2, getLogid());
      }
      m = k;
      if (hasSsid()) {
        m = k + CodedOutputStreamMicro.computeStringSize(3, getSsid());
      }
      k = m;
      if (hasMaxnum()) {
        k = m + CodedOutputStreamMicro.computeInt32Size(4, getMaxnum());
      }
      m = k;
      if (hasTitleurl()) {
        m = k + CodedOutputStreamMicro.computeStringSize(5, getTitleurl());
      }
      this.j = m;
      return m;
    }
    
    public String getSsid()
    {
      return this.e;
    }
    
    public String getTitleurl()
    {
      return this.i;
    }
    
    public boolean hasLogid()
    {
      return this.b;
    }
    
    public boolean hasMaxnum()
    {
      return this.f;
    }
    
    public boolean hasSsid()
    {
      return this.d;
    }
    
    public boolean hasTitleurl()
    {
      return this.h;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Feedlist mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int k = paramCodedInputStreamMicro.readTag();
        switch (k)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, k)) {}
          break;
        case 0: 
          return this;
        case 10: 
          Feed localFeed = new Feed();
          paramCodedInputStreamMicro.readMessage(localFeed);
          addFeed(localFeed);
          break;
        case 18: 
          setLogid(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setSsid(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setMaxnum(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setTitleurl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Feedlist setFeed(int paramInt, Feed paramFeed)
    {
      if (paramFeed == null) {
        return this;
      }
      this.a.set(paramInt, paramFeed);
      return this;
    }
    
    public Feedlist setLogid(String paramString)
    {
      this.b = true;
      this.c = paramString;
      return this;
    }
    
    public Feedlist setMaxnum(int paramInt)
    {
      this.f = true;
      this.g = paramInt;
      return this;
    }
    
    public Feedlist setSsid(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public Feedlist setTitleurl(String paramString)
    {
      this.h = true;
      this.i = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getFeedList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Feed)localIterator.next());
      }
      if (hasLogid()) {
        paramCodedOutputStreamMicro.writeString(2, getLogid());
      }
      if (hasSsid()) {
        paramCodedOutputStreamMicro.writeString(3, getSsid());
      }
      if (hasMaxnum()) {
        paramCodedOutputStreamMicro.writeInt32(4, getMaxnum());
      }
      if (hasTitleurl()) {
        paramCodedOutputStreamMicro.writeString(5, getTitleurl());
      }
    }
    
    public static final class Feed
      extends MessageMicro
    {
      public static final int CATE_FIELD_NUMBER = 6;
      public static final int EXT_FIELD_NUMBER = 12;
      public static final int FRM_FIELD_NUMBER = 10;
      public static final int IMGS_FIELD_NUMBER = 2;
      public static final int JURL_FIELD_NUMBER = 5;
      public static final int LOGEXTRA_FIELD_NUMBER = 9;
      public static final int MARK_FIELD_NUMBER = 13;
      public static final int NEWSATTENTION_FIELD_NUMBER = 14;
      public static final int NID_FIELD_NUMBER = 1;
      public static final int OPER_FIELD_NUMBER = 11;
      public static final int SRC_FIELD_NUMBER = 4;
      public static final int STYPE_FIELD_NUMBER = 8;
      public static final int TITLE_FIELD_NUMBER = 3;
      public static final int TS_FIELD_NUMBER = 7;
      private int A = -1;
      private boolean a;
      private String b = "";
      private List<String> c = Collections.emptyList();
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
      private String q = "";
      private boolean r;
      private int s = 0;
      private boolean t;
      private int u = 0;
      private boolean v;
      private String w = "";
      private boolean x;
      private String y = "";
      private List<String> z = Collections.emptyList();
      
      public static Feed parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Feed().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Feed parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Feed)new Feed().mergeFrom(paramArrayOfByte);
      }
      
      public Feed addImgs(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        if (this.c.isEmpty()) {
          this.c = new ArrayList();
        }
        this.c.add(paramString);
        return this;
      }
      
      public Feed addNewsAttention(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        if (this.z.isEmpty()) {
          this.z = new ArrayList();
        }
        this.z.add(paramString);
        return this;
      }
      
      public final Feed clear()
      {
        clearNid();
        clearImgs();
        clearTitle();
        clearSrc();
        clearJurl();
        clearCate();
        clearTs();
        clearStype();
        clearLogextra();
        clearFrm();
        clearOper();
        clearExt();
        clearMark();
        clearNewsAttention();
        this.A = -1;
        return this;
      }
      
      public Feed clearCate()
      {
        this.j = false;
        this.k = "";
        return this;
      }
      
      public Feed clearExt()
      {
        this.v = false;
        this.w = "";
        return this;
      }
      
      public Feed clearFrm()
      {
        this.r = false;
        this.s = 0;
        return this;
      }
      
      public Feed clearImgs()
      {
        this.c = Collections.emptyList();
        return this;
      }
      
      public Feed clearJurl()
      {
        this.h = false;
        this.i = "";
        return this;
      }
      
      public Feed clearLogextra()
      {
        this.p = false;
        this.q = "";
        return this;
      }
      
      public Feed clearMark()
      {
        this.x = false;
        this.y = "";
        return this;
      }
      
      public Feed clearNewsAttention()
      {
        this.z = Collections.emptyList();
        return this;
      }
      
      public Feed clearNid()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Feed clearOper()
      {
        this.t = false;
        this.u = 0;
        return this;
      }
      
      public Feed clearSrc()
      {
        this.f = false;
        this.g = "";
        return this;
      }
      
      public Feed clearStype()
      {
        this.n = false;
        this.o = 0;
        return this;
      }
      
      public Feed clearTitle()
      {
        this.d = false;
        this.e = "";
        return this;
      }
      
      public Feed clearTs()
      {
        this.l = false;
        this.m = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.A < 0) {
          getSerializedSize();
        }
        return this.A;
      }
      
      public String getCate()
      {
        return this.k;
      }
      
      public String getExt()
      {
        return this.w;
      }
      
      public int getFrm()
      {
        return this.s;
      }
      
      public String getImgs(int paramInt)
      {
        return (String)this.c.get(paramInt);
      }
      
      public int getImgsCount()
      {
        return this.c.size();
      }
      
      public List<String> getImgsList()
      {
        return this.c;
      }
      
      public String getJurl()
      {
        return this.i;
      }
      
      public String getLogextra()
      {
        return this.q;
      }
      
      public String getMark()
      {
        return this.y;
      }
      
      public String getNewsAttention(int paramInt)
      {
        return (String)this.z.get(paramInt);
      }
      
      public int getNewsAttentionCount()
      {
        return this.z.size();
      }
      
      public List<String> getNewsAttentionList()
      {
        return this.z;
      }
      
      public String getNid()
      {
        return this.b;
      }
      
      public int getOper()
      {
        return this.u;
      }
      
      public int getSerializedSize()
      {
        int i3 = 0;
        if (hasNid()) {}
        for (int i1 = CodedOutputStreamMicro.computeStringSize(1, getNid()) + 0;; i1 = 0)
        {
          Iterator localIterator = getImgsList().iterator();
          for (int i2 = 0; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i2) {}
          i2 = i1 + i2 + getImgsList().size() * 1;
          i1 = i2;
          if (hasTitle()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(3, getTitle());
          }
          i2 = i1;
          if (hasSrc()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(4, getSrc());
          }
          i1 = i2;
          if (hasJurl()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(5, getJurl());
          }
          i2 = i1;
          if (hasCate()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(6, getCate());
          }
          i1 = i2;
          if (hasTs()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getTs());
          }
          i2 = i1;
          if (hasStype()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(8, getStype());
          }
          i1 = i2;
          if (hasLogextra()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(9, getLogextra());
          }
          i2 = i1;
          if (hasFrm()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(10, getFrm());
          }
          i1 = i2;
          if (hasOper()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(11, getOper());
          }
          i2 = i1;
          if (hasExt()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(12, getExt());
          }
          if (hasMark()) {}
          for (i1 = i2 + CodedOutputStreamMicro.computeStringSize(13, getMark());; i1 = i2)
          {
            localIterator = getNewsAttentionList().iterator();
            i2 = i3;
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
            }
            i1 = i1 + i2 + getNewsAttentionList().size() * 1;
            this.A = i1;
            return i1;
          }
        }
      }
      
      public String getSrc()
      {
        return this.g;
      }
      
      public int getStype()
      {
        return this.o;
      }
      
      public String getTitle()
      {
        return this.e;
      }
      
      public String getTs()
      {
        return this.m;
      }
      
      public boolean hasCate()
      {
        return this.j;
      }
      
      public boolean hasExt()
      {
        return this.v;
      }
      
      public boolean hasFrm()
      {
        return this.r;
      }
      
      public boolean hasJurl()
      {
        return this.h;
      }
      
      public boolean hasLogextra()
      {
        return this.p;
      }
      
      public boolean hasMark()
      {
        return this.x;
      }
      
      public boolean hasNid()
      {
        return this.a;
      }
      
      public boolean hasOper()
      {
        return this.t;
      }
      
      public boolean hasSrc()
      {
        return this.f;
      }
      
      public boolean hasStype()
      {
        return this.n;
      }
      
      public boolean hasTitle()
      {
        return this.d;
      }
      
      public boolean hasTs()
      {
        return this.l;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Feed mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setNid(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            addImgs(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setTitle(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setSrc(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setJurl(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setCate(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setTs(paramCodedInputStreamMicro.readString());
            break;
          case 64: 
            setStype(paramCodedInputStreamMicro.readInt32());
            break;
          case 74: 
            setLogextra(paramCodedInputStreamMicro.readString());
            break;
          case 80: 
            setFrm(paramCodedInputStreamMicro.readInt32());
            break;
          case 88: 
            setOper(paramCodedInputStreamMicro.readInt32());
            break;
          case 98: 
            setExt(paramCodedInputStreamMicro.readString());
            break;
          case 106: 
            setMark(paramCodedInputStreamMicro.readString());
            break;
          case 114: 
            addNewsAttention(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Feed setCate(String paramString)
      {
        this.j = true;
        this.k = paramString;
        return this;
      }
      
      public Feed setExt(String paramString)
      {
        this.v = true;
        this.w = paramString;
        return this;
      }
      
      public Feed setFrm(int paramInt)
      {
        this.r = true;
        this.s = paramInt;
        return this;
      }
      
      public Feed setImgs(int paramInt, String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.c.set(paramInt, paramString);
        return this;
      }
      
      public Feed setJurl(String paramString)
      {
        this.h = true;
        this.i = paramString;
        return this;
      }
      
      public Feed setLogextra(String paramString)
      {
        this.p = true;
        this.q = paramString;
        return this;
      }
      
      public Feed setMark(String paramString)
      {
        this.x = true;
        this.y = paramString;
        return this;
      }
      
      public Feed setNewsAttention(int paramInt, String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.z.set(paramInt, paramString);
        return this;
      }
      
      public Feed setNid(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Feed setOper(int paramInt)
      {
        this.t = true;
        this.u = paramInt;
        return this;
      }
      
      public Feed setSrc(String paramString)
      {
        this.f = true;
        this.g = paramString;
        return this;
      }
      
      public Feed setStype(int paramInt)
      {
        this.n = true;
        this.o = paramInt;
        return this;
      }
      
      public Feed setTitle(String paramString)
      {
        this.d = true;
        this.e = paramString;
        return this;
      }
      
      public Feed setTs(String paramString)
      {
        this.l = true;
        this.m = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasNid()) {
          paramCodedOutputStreamMicro.writeString(1, getNid());
        }
        Iterator localIterator = getImgsList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeString(2, (String)localIterator.next());
        }
        if (hasTitle()) {
          paramCodedOutputStreamMicro.writeString(3, getTitle());
        }
        if (hasSrc()) {
          paramCodedOutputStreamMicro.writeString(4, getSrc());
        }
        if (hasJurl()) {
          paramCodedOutputStreamMicro.writeString(5, getJurl());
        }
        if (hasCate()) {
          paramCodedOutputStreamMicro.writeString(6, getCate());
        }
        if (hasTs()) {
          paramCodedOutputStreamMicro.writeString(7, getTs());
        }
        if (hasStype()) {
          paramCodedOutputStreamMicro.writeInt32(8, getStype());
        }
        if (hasLogextra()) {
          paramCodedOutputStreamMicro.writeString(9, getLogextra());
        }
        if (hasFrm()) {
          paramCodedOutputStreamMicro.writeInt32(10, getFrm());
        }
        if (hasOper()) {
          paramCodedOutputStreamMicro.writeInt32(11, getOper());
        }
        if (hasExt()) {
          paramCodedOutputStreamMicro.writeString(12, getExt());
        }
        if (hasMark()) {
          paramCodedOutputStreamMicro.writeString(13, getMark());
        }
        localIterator = getNewsAttentionList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeString(14, (String)localIterator.next());
        }
      }
    }
  }
  
  public static final class Header
    extends MessageMicro
  {
    public static final int TIME_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
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
      clearTitle();
      clearTime();
      this.e = -1;
      return this;
    }
    
    public Header clearTime()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Header clearTitle()
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
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasTitle()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      int j = i;
      if (hasTime()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getTime());
      }
      this.e = j;
      return j;
    }
    
    public String getTime()
    {
      return this.d;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public boolean hasTime()
    {
      return this.c;
    }
    
    public boolean hasTitle()
    {
      return this.a;
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
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTime(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Header setTime(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Header setTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(1, getTitle());
      }
      if (hasTime()) {
        paramCodedOutputStreamMicro.writeString(2, getTime());
      }
    }
  }
  
  public static final class Infomation
    extends MessageMicro
  {
    public static final int INFOS_FIELD_NUMBER = 1;
    public static final int TITLEURL_FIELD_NUMBER = 2;
    private List<Info> a = Collections.emptyList();
    private boolean b;
    private String c = "";
    private int d = -1;
    
    public static Infomation parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Infomation().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Infomation parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Infomation)new Infomation().mergeFrom(paramArrayOfByte);
    }
    
    public Infomation addInfos(Info paramInfo)
    {
      if (paramInfo == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramInfo);
      return this;
    }
    
    public final Infomation clear()
    {
      clearInfos();
      clearTitleurl();
      this.d = -1;
      return this;
    }
    
    public Infomation clearInfos()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Infomation clearTitleurl()
    {
      this.b = false;
      this.c = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public Info getInfos(int paramInt)
    {
      return (Info)this.a.get(paramInt);
    }
    
    public int getInfosCount()
    {
      return this.a.size();
    }
    
    public List<Info> getInfosList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getInfosList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Info)localIterator.next()) + i) {}
      int j = i;
      if (hasTitleurl()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getTitleurl());
      }
      this.d = j;
      return j;
    }
    
    public String getTitleurl()
    {
      return this.c;
    }
    
    public boolean hasTitleurl()
    {
      return this.b;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Infomation mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          Info localInfo = new Info();
          paramCodedInputStreamMicro.readMessage(localInfo);
          addInfos(localInfo);
          break;
        case 18: 
          setTitleurl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Infomation setInfos(int paramInt, Info paramInfo)
    {
      if (paramInfo == null) {
        return this;
      }
      this.a.set(paramInt, paramInfo);
      return this;
    }
    
    public Infomation setTitleurl(String paramString)
    {
      this.b = true;
      this.c = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getInfosList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Info)localIterator.next());
      }
      if (hasTitleurl()) {
        paramCodedOutputStreamMicro.writeString(2, getTitleurl());
      }
    }
    
    public static final class Info
      extends MessageMicro
    {
      public static final int DETAIL_FIELD_NUMBER = 3;
      public static final int TITLE_FIELD_NUMBER = 1;
      public static final int UPDATE_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private int g = -1;
      
      public static Info parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Info().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Info parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Info)new Info().mergeFrom(paramArrayOfByte);
      }
      
      public final Info clear()
      {
        clearTitle();
        clearUpdate();
        clearDetail();
        this.g = -1;
        return this;
      }
      
      public Info clearDetail()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Info clearTitle()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Info clearUpdate()
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
      
      public String getDetail()
      {
        return this.f;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        if (hasTitle()) {
          j = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
        }
        int i = j;
        if (hasUpdate()) {
          i = j + CodedOutputStreamMicro.computeStringSize(2, getUpdate());
        }
        j = i;
        if (hasDetail()) {
          j = i + CodedOutputStreamMicro.computeStringSize(3, getDetail());
        }
        this.g = j;
        return j;
      }
      
      public String getTitle()
      {
        return this.b;
      }
      
      public String getUpdate()
      {
        return this.d;
      }
      
      public boolean hasDetail()
      {
        return this.e;
      }
      
      public boolean hasTitle()
      {
        return this.a;
      }
      
      public boolean hasUpdate()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Info mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setTitle(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setUpdate(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setDetail(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Info setDetail(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Info setTitle(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Info setUpdate(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasTitle()) {
          paramCodedOutputStreamMicro.writeString(1, getTitle());
        }
        if (hasUpdate()) {
          paramCodedOutputStreamMicro.writeString(2, getUpdate());
        }
        if (hasDetail()) {
          paramCodedOutputStreamMicro.writeString(3, getDetail());
        }
      }
    }
  }
  
  public static final class Nonlocal
    extends MessageMicro
  {
    public static final int CITYID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static Nonlocal parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Nonlocal().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Nonlocal parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Nonlocal)new Nonlocal().mergeFrom(paramArrayOfByte);
    }
    
    public final Nonlocal clear()
    {
      clearCityid();
      clearName();
      this.e = -1;
      return this;
    }
    
    public Nonlocal clearCityid()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Nonlocal clearName()
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
    
    public int getCityid()
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
      if (hasCityid()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCityid());
      }
      int j = i;
      if (hasName()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getName());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasCityid()
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
    
    public Nonlocal mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCityid(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setName(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Nonlocal setCityid(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Nonlocal setName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCityid()) {
        paramCodedOutputStreamMicro.writeInt32(1, getCityid());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(2, getName());
      }
    }
  }
  
  public static final class Route
    extends MessageMicro
  {
    public static final int LINK_FIELD_NUMBER = 4;
    public static final int LOCATION_FIELD_NUMBER = 2;
    public static final int LOCTEXT_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int OBODETEXT_FIELD_NUMBER = 5;
    public static final int TAG_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private Location d = null;
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private int m = -1;
    
    public static Route parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Route().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Route parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Route)new Route().mergeFrom(paramArrayOfByte);
    }
    
    public final Route clear()
    {
      clearTag();
      clearLocation();
      clearName();
      clearLink();
      clearObodetext();
      clearLoctext();
      this.m = -1;
      return this;
    }
    
    public Route clearLink()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Route clearLocation()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public Route clearLoctext()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Route clearName()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Route clearObodetext()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Route clearTag()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public String getLink()
    {
      return this.h;
    }
    
    public Location getLocation()
    {
      return this.d;
    }
    
    public String getLoctext()
    {
      return this.l;
    }
    
    public String getName()
    {
      return this.f;
    }
    
    public String getObodetext()
    {
      return this.j;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasTag()) {
        i1 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTag());
      }
      int n = i1;
      if (hasLocation()) {
        n = i1 + CodedOutputStreamMicro.computeMessageSize(2, getLocation());
      }
      i1 = n;
      if (hasName()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getName());
      }
      n = i1;
      if (hasLink()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getLink());
      }
      i1 = n;
      if (hasObodetext()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getObodetext());
      }
      n = i1;
      if (hasLoctext()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getLoctext());
      }
      this.m = n;
      return n;
    }
    
    public int getTag()
    {
      return this.b;
    }
    
    public boolean hasLink()
    {
      return this.g;
    }
    
    public boolean hasLocation()
    {
      return this.c;
    }
    
    public boolean hasLoctext()
    {
      return this.k;
    }
    
    public boolean hasName()
    {
      return this.e;
    }
    
    public boolean hasObodetext()
    {
      return this.i;
    }
    
    public boolean hasTag()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Route mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        case 8: 
          setTag(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          Location localLocation = new Location();
          paramCodedInputStreamMicro.readMessage(localLocation);
          setLocation(localLocation);
          break;
        case 26: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setLink(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setObodetext(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setLoctext(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Route setLink(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Route setLocation(Location paramLocation)
    {
      if (paramLocation == null) {
        return clearLocation();
      }
      this.c = true;
      this.d = paramLocation;
      return this;
    }
    
    public Route setLoctext(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Route setName(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Route setObodetext(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Route setTag(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTag()) {
        paramCodedOutputStreamMicro.writeInt32(1, getTag());
      }
      if (hasLocation()) {
        paramCodedOutputStreamMicro.writeMessage(2, getLocation());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(3, getName());
      }
      if (hasLink()) {
        paramCodedOutputStreamMicro.writeString(4, getLink());
      }
      if (hasObodetext()) {
        paramCodedOutputStreamMicro.writeString(5, getObodetext());
      }
      if (hasLoctext()) {
        paramCodedOutputStreamMicro.writeString(6, getLoctext());
      }
    }
    
    public static final class Location
      extends MessageMicro
    {
      public static final int COMPANY_FIELD_NUMBER = 2;
      public static final int HOME_FIELD_NUMBER = 1;
      private boolean a;
      private Point b = null;
      private boolean c;
      private Point d = null;
      private int e = -1;
      
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
        clearHome();
        clearCompany();
        this.e = -1;
        return this;
      }
      
      public Location clearCompany()
      {
        this.c = false;
        this.d = null;
        return this;
      }
      
      public Location clearHome()
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
      
      public Point getCompany()
      {
        return this.d;
      }
      
      public Point getHome()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasHome()) {
          i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHome());
        }
        int j = i;
        if (hasCompany()) {
          j = i + CodedOutputStreamMicro.computeMessageSize(2, getCompany());
        }
        this.e = j;
        return j;
      }
      
      public boolean hasCompany()
      {
        return this.c;
      }
      
      public boolean hasHome()
      {
        return this.a;
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
          Point localPoint;
          switch (i)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
            break;
          case 0: 
            return this;
          case 10: 
            localPoint = new Point();
            paramCodedInputStreamMicro.readMessage(localPoint);
            setHome(localPoint);
            break;
          case 18: 
            localPoint = new Point();
            paramCodedInputStreamMicro.readMessage(localPoint);
            setCompany(localPoint);
          }
        }
      }
      
      public Location setCompany(Point paramPoint)
      {
        if (paramPoint == null) {
          return clearCompany();
        }
        this.c = true;
        this.d = paramPoint;
        return this;
      }
      
      public Location setHome(Point paramPoint)
      {
        if (paramPoint == null) {
          return clearHome();
        }
        this.a = true;
        this.b = paramPoint;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasHome()) {
          paramCodedOutputStreamMicro.writeMessage(1, getHome());
        }
        if (hasCompany()) {
          paramCodedOutputStreamMicro.writeMessage(2, getCompany());
        }
      }
      
      public static final class Point
        extends MessageMicro
      {
        public static final int LAT_FIELD_NUMBER = 1;
        public static final int LNG_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        private boolean a;
        private int b = 0;
        private boolean c;
        private int d = 0;
        private boolean e;
        private String f = "";
        private int g = -1;
        
        public static Point parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Point().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Point parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Point)new Point().mergeFrom(paramArrayOfByte);
        }
        
        public final Point clear()
        {
          clearLat();
          clearLng();
          clearName();
          this.g = -1;
          return this;
        }
        
        public Point clearLat()
        {
          this.a = false;
          this.b = 0;
          return this;
        }
        
        public Point clearLng()
        {
          this.c = false;
          this.d = 0;
          return this;
        }
        
        public Point clearName()
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
        
        public int getLat()
        {
          return this.b;
        }
        
        public int getLng()
        {
          return this.d;
        }
        
        public String getName()
        {
          return this.f;
        }
        
        public int getSerializedSize()
        {
          int j = 0;
          if (hasLat()) {
            j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getLat());
          }
          int i = j;
          if (hasLng()) {
            i = j + CodedOutputStreamMicro.computeInt32Size(2, getLng());
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
          return this.a;
        }
        
        public boolean hasLng()
        {
          return this.c;
        }
        
        public boolean hasName()
        {
          return this.e;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Point mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setLat(paramCodedInputStreamMicro.readInt32());
              break;
            case 16: 
              setLng(paramCodedInputStreamMicro.readInt32());
              break;
            case 26: 
              setName(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Point setLat(int paramInt)
        {
          this.a = true;
          this.b = paramInt;
          return this;
        }
        
        public Point setLng(int paramInt)
        {
          this.c = true;
          this.d = paramInt;
          return this;
        }
        
        public Point setName(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasLat()) {
            paramCodedOutputStreamMicro.writeInt32(1, getLat());
          }
          if (hasLng()) {
            paramCodedOutputStreamMicro.writeInt32(2, getLng());
          }
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(3, getName());
          }
        }
      }
    }
  }
  
  public static final class Share
    extends MessageMicro
  {
    public static final int BIGICON_FIELD_NUMBER = 6;
    public static final int LONGCONTENT_FIELD_NUMBER = 4;
    public static final int SHORTCONTENT_FIELD_NUMBER = 3;
    public static final int SMALLICON_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
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
    private int m = -1;
    
    public static Share parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Share().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Share parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Share)new Share().mergeFrom(paramArrayOfByte);
    }
    
    public final Share clear()
    {
      clearUrl();
      clearTitle();
      clearShortcontent();
      clearLongcontent();
      clearSmallicon();
      clearBigicon();
      this.m = -1;
      return this;
    }
    
    public Share clearBigicon()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Share clearLongcontent()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Share clearShortcontent()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Share clearSmallicon()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Share clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Share clearUrl()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public String getBigicon()
    {
      return this.l;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public String getLongcontent()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasUrl()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
      }
      int n = i1;
      if (hasTitle()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      i1 = n;
      if (hasShortcontent()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getShortcontent());
      }
      n = i1;
      if (hasLongcontent()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getLongcontent());
      }
      i1 = n;
      if (hasSmallicon()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getSmallicon());
      }
      n = i1;
      if (hasBigicon()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getBigicon());
      }
      this.m = n;
      return n;
    }
    
    public String getShortcontent()
    {
      return this.f;
    }
    
    public String getSmallicon()
    {
      return this.j;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public String getUrl()
    {
      return this.b;
    }
    
    public boolean hasBigicon()
    {
      return this.k;
    }
    
    public boolean hasLongcontent()
    {
      return this.g;
    }
    
    public boolean hasShortcontent()
    {
      return this.e;
    }
    
    public boolean hasSmallicon()
    {
      return this.i;
    }
    
    public boolean hasTitle()
    {
      return this.c;
    }
    
    public boolean hasUrl()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Share mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setUrl(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setShortcontent(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setLongcontent(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setSmallicon(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setBigicon(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Share setBigicon(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Share setLongcontent(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Share setShortcontent(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Share setSmallicon(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Share setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Share setUrl(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasUrl()) {
        paramCodedOutputStreamMicro.writeString(1, getUrl());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
      if (hasShortcontent()) {
        paramCodedOutputStreamMicro.writeString(3, getShortcontent());
      }
      if (hasLongcontent()) {
        paramCodedOutputStreamMicro.writeString(4, getLongcontent());
      }
      if (hasSmallicon()) {
        paramCodedOutputStreamMicro.writeString(5, getSmallicon());
      }
      if (hasBigicon()) {
        paramCodedOutputStreamMicro.writeString(6, getBigicon());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Travel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */