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

public final class ShopMenu
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Content d = null;
  private int e = -1;
  
  public static ShopMenu parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new ShopMenu().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static ShopMenu parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (ShopMenu)new ShopMenu().mergeFrom(paramArrayOfByte);
  }
  
  public final ShopMenu clear()
  {
    clearOption();
    clearContent();
    this.e = -1;
    return this;
  }
  
  public ShopMenu clearContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public ShopMenu clearOption()
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
  
  public ShopMenu mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
  
  public ShopMenu setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.c = true;
    this.d = paramContent;
    return this;
  }
  
  public ShopMenu setOption(Option paramOption)
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
    public static final int AVERAGE_TIME_FIELD_NUMBER = 7;
    public static final int BUSSINESS_HOURS_FIELD_NUMBER = 4;
    public static final int BUSSINESS_STATUS_FIELD_NUMBER = 3;
    public static final int COUPON_INFO_FIELD_NUMBER = 9;
    public static final int RELEASE_ID_FIELD_NUMBER = 1;
    public static final int SHOP_NAME_FIELD_NUMBER = 2;
    public static final int SOURCE_INFO_FIELD_NUMBER = 10;
    public static final int TAKEOUT_COST_FIELD_NUMBER = 6;
    public static final int TAKEOUT_MENU_FIELD_NUMBER = 8;
    public static final int TAKEOUT_PRICE_FIELD_NUMBER = 5;
    private List<BussinessHours> a = Collections.emptyList();
    private List<TakeoutMenu> b = Collections.emptyList();
    private boolean c;
    private CouponInfo d = null;
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private int j = 0;
    private boolean k;
    private String l = "";
    private boolean m;
    private String n = "";
    private boolean o;
    private String p = "";
    private boolean q;
    private SourceInfo r = null;
    private int s = -1;
    
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
    
    public Content addBussinessHours(BussinessHours paramBussinessHours)
    {
      if (paramBussinessHours == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramBussinessHours);
      return this;
    }
    
    public Content addTakeoutMenu(TakeoutMenu paramTakeoutMenu)
    {
      if (paramTakeoutMenu == null) {
        return this;
      }
      if (this.b.isEmpty()) {
        this.b = new ArrayList();
      }
      this.b.add(paramTakeoutMenu);
      return this;
    }
    
    public final Content clear()
    {
      clearBussinessHours();
      clearTakeoutMenu();
      clearCouponInfo();
      clearReleaseId();
      clearShopName();
      clearBussinessStatus();
      clearTakeoutPrice();
      clearTakeoutCost();
      clearAverageTime();
      clearSourceInfo();
      this.s = -1;
      return this;
    }
    
    public Content clearAverageTime()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public Content clearBussinessHours()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Content clearBussinessStatus()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public Content clearCouponInfo()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public Content clearReleaseId()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Content clearShopName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Content clearSourceInfo()
    {
      this.q = false;
      this.r = null;
      return this;
    }
    
    public Content clearTakeoutCost()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Content clearTakeoutMenu()
    {
      this.b = Collections.emptyList();
      return this;
    }
    
    public Content clearTakeoutPrice()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public String getAverageTime()
    {
      return this.p;
    }
    
    public BussinessHours getBussinessHours(int paramInt)
    {
      return (BussinessHours)this.a.get(paramInt);
    }
    
    public int getBussinessHoursCount()
    {
      return this.a.size();
    }
    
    public List<BussinessHours> getBussinessHoursList()
    {
      return this.a;
    }
    
    public int getBussinessStatus()
    {
      return this.j;
    }
    
    public int getCachedSize()
    {
      if (this.s < 0) {
        getSerializedSize();
      }
      return this.s;
    }
    
    public CouponInfo getCouponInfo()
    {
      return this.d;
    }
    
    public String getReleaseId()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasReleaseId()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getReleaseId());
      }
      int i1 = i2;
      if (hasShopName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getShopName());
      }
      i2 = i1;
      if (hasBussinessStatus()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getBussinessStatus());
      }
      Iterator localIterator = getBussinessHoursList().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(4, (BussinessHours)localIterator.next()) + i2;
      }
      i1 = i2;
      if (hasTakeoutPrice()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(5, getTakeoutPrice());
      }
      i2 = i1;
      if (hasTakeoutCost()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(6, getTakeoutCost());
      }
      i1 = i2;
      if (hasAverageTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getAverageTime());
      }
      localIterator = getTakeoutMenuList().iterator();
      i2 = i1;
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(8, (TakeoutMenu)localIterator.next());
      }
      i1 = i2;
      if (hasCouponInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(9, getCouponInfo());
      }
      i2 = i1;
      if (hasSourceInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(10, getSourceInfo());
      }
      this.s = i2;
      return i2;
    }
    
    public String getShopName()
    {
      return this.h;
    }
    
    public SourceInfo getSourceInfo()
    {
      return this.r;
    }
    
    public String getTakeoutCost()
    {
      return this.n;
    }
    
    public TakeoutMenu getTakeoutMenu(int paramInt)
    {
      return (TakeoutMenu)this.b.get(paramInt);
    }
    
    public int getTakeoutMenuCount()
    {
      return this.b.size();
    }
    
    public List<TakeoutMenu> getTakeoutMenuList()
    {
      return this.b;
    }
    
    public String getTakeoutPrice()
    {
      return this.l;
    }
    
    public boolean hasAverageTime()
    {
      return this.o;
    }
    
    public boolean hasBussinessStatus()
    {
      return this.i;
    }
    
    public boolean hasCouponInfo()
    {
      return this.c;
    }
    
    public boolean hasReleaseId()
    {
      return this.e;
    }
    
    public boolean hasShopName()
    {
      return this.g;
    }
    
    public boolean hasSourceInfo()
    {
      return this.q;
    }
    
    public boolean hasTakeoutCost()
    {
      return this.m;
    }
    
    public boolean hasTakeoutPrice()
    {
      return this.k;
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
          setReleaseId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setShopName(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setBussinessStatus(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          localObject = new BussinessHours();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addBussinessHours((BussinessHours)localObject);
          break;
        case 42: 
          setTakeoutPrice(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setTakeoutCost(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setAverageTime(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          localObject = new TakeoutMenu();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTakeoutMenu((TakeoutMenu)localObject);
          break;
        case 74: 
          localObject = new CouponInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCouponInfo((CouponInfo)localObject);
          break;
        case 82: 
          localObject = new SourceInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setSourceInfo((SourceInfo)localObject);
        }
      }
    }
    
    public Content setAverageTime(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public Content setBussinessHours(int paramInt, BussinessHours paramBussinessHours)
    {
      if (paramBussinessHours == null) {
        return this;
      }
      this.a.set(paramInt, paramBussinessHours);
      return this;
    }
    
    public Content setBussinessStatus(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public Content setCouponInfo(CouponInfo paramCouponInfo)
    {
      if (paramCouponInfo == null) {
        return clearCouponInfo();
      }
      this.c = true;
      this.d = paramCouponInfo;
      return this;
    }
    
    public Content setReleaseId(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Content setShopName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Content setSourceInfo(SourceInfo paramSourceInfo)
    {
      if (paramSourceInfo == null) {
        return clearSourceInfo();
      }
      this.q = true;
      this.r = paramSourceInfo;
      return this;
    }
    
    public Content setTakeoutCost(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Content setTakeoutMenu(int paramInt, TakeoutMenu paramTakeoutMenu)
    {
      if (paramTakeoutMenu == null) {
        return this;
      }
      this.b.set(paramInt, paramTakeoutMenu);
      return this;
    }
    
    public Content setTakeoutPrice(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasReleaseId()) {
        paramCodedOutputStreamMicro.writeString(1, getReleaseId());
      }
      if (hasShopName()) {
        paramCodedOutputStreamMicro.writeString(2, getShopName());
      }
      if (hasBussinessStatus()) {
        paramCodedOutputStreamMicro.writeInt32(3, getBussinessStatus());
      }
      Iterator localIterator = getBussinessHoursList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(4, (BussinessHours)localIterator.next());
      }
      if (hasTakeoutPrice()) {
        paramCodedOutputStreamMicro.writeString(5, getTakeoutPrice());
      }
      if (hasTakeoutCost()) {
        paramCodedOutputStreamMicro.writeString(6, getTakeoutCost());
      }
      if (hasAverageTime()) {
        paramCodedOutputStreamMicro.writeString(7, getAverageTime());
      }
      localIterator = getTakeoutMenuList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (TakeoutMenu)localIterator.next());
      }
      if (hasCouponInfo()) {
        paramCodedOutputStreamMicro.writeMessage(9, getCouponInfo());
      }
      if (hasSourceInfo()) {
        paramCodedOutputStreamMicro.writeMessage(10, getSourceInfo());
      }
    }
    
    public static final class BussinessHours
      extends MessageMicro
    {
      public static final int END_FIELD_NUMBER = 2;
      public static final int START_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static BussinessHours parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new BussinessHours().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static BussinessHours parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (BussinessHours)new BussinessHours().mergeFrom(paramArrayOfByte);
      }
      
      public final BussinessHours clear()
      {
        clearStart();
        clearEnd();
        this.e = -1;
        return this;
      }
      
      public BussinessHours clearEnd()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public BussinessHours clearStart()
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
      
      public String getEnd()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasStart()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStart());
        }
        int j = i;
        if (hasEnd()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getEnd());
        }
        this.e = j;
        return j;
      }
      
      public String getStart()
      {
        return this.b;
      }
      
      public boolean hasEnd()
      {
        return this.c;
      }
      
      public boolean hasStart()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public BussinessHours mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setStart(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setEnd(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public BussinessHours setEnd(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public BussinessHours setStart(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasStart()) {
          paramCodedOutputStreamMicro.writeString(1, getStart());
        }
        if (hasEnd()) {
          paramCodedOutputStreamMicro.writeString(2, getEnd());
        }
      }
    }
    
    public static final class CouponInfo
      extends MessageMicro
    {
      public static final int COUPON_MSG_FIELD_NUMBER = 2;
      public static final int SUPPORT_COUPON_FIELD_NUMBER = 1;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static CouponInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new CouponInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static CouponInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (CouponInfo)new CouponInfo().mergeFrom(paramArrayOfByte);
      }
      
      public final CouponInfo clear()
      {
        clearSupportCoupon();
        clearCouponMsg();
        this.e = -1;
        return this;
      }
      
      public CouponInfo clearCouponMsg()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public CouponInfo clearSupportCoupon()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.e < 0) {
          getSerializedSize();
        }
        return this.e;
      }
      
      public String getCouponMsg()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasSupportCoupon()) {
          i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getSupportCoupon());
        }
        int j = i;
        if (hasCouponMsg()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getCouponMsg());
        }
        this.e = j;
        return j;
      }
      
      public int getSupportCoupon()
      {
        return this.b;
      }
      
      public boolean hasCouponMsg()
      {
        return this.c;
      }
      
      public boolean hasSupportCoupon()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public CouponInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setSupportCoupon(paramCodedInputStreamMicro.readInt32());
            break;
          case 18: 
            setCouponMsg(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public CouponInfo setCouponMsg(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public CouponInfo setSupportCoupon(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasSupportCoupon()) {
          paramCodedOutputStreamMicro.writeInt32(1, getSupportCoupon());
        }
        if (hasCouponMsg()) {
          paramCodedOutputStreamMicro.writeString(2, getCouponMsg());
        }
      }
    }
    
    public static final class SourceInfo
      extends MessageMicro
    {
      public static final int SOURCE_LOGO_URL_FIELD_NUMBER = 2;
      public static final int SOURCE_NAME_FIELD_NUMBER = 1;
      public static final int SOURCE_URL_FIELD_NUMBER = 3;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private int g = -1;
      
      public static SourceInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new SourceInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static SourceInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (SourceInfo)new SourceInfo().mergeFrom(paramArrayOfByte);
      }
      
      public final SourceInfo clear()
      {
        clearSourceName();
        clearSourceLogoUrl();
        clearSourceUrl();
        this.g = -1;
        return this;
      }
      
      public SourceInfo clearSourceLogoUrl()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public SourceInfo clearSourceName()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public SourceInfo clearSourceUrl()
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
      
      public int getSerializedSize()
      {
        int j = 0;
        if (hasSourceName()) {
          j = 0 + CodedOutputStreamMicro.computeStringSize(1, getSourceName());
        }
        int i = j;
        if (hasSourceLogoUrl()) {
          i = j + CodedOutputStreamMicro.computeStringSize(2, getSourceLogoUrl());
        }
        j = i;
        if (hasSourceUrl()) {
          j = i + CodedOutputStreamMicro.computeStringSize(3, getSourceUrl());
        }
        this.g = j;
        return j;
      }
      
      public String getSourceLogoUrl()
      {
        return this.d;
      }
      
      public String getSourceName()
      {
        return this.b;
      }
      
      public String getSourceUrl()
      {
        return this.f;
      }
      
      public boolean hasSourceLogoUrl()
      {
        return this.c;
      }
      
      public boolean hasSourceName()
      {
        return this.a;
      }
      
      public boolean hasSourceUrl()
      {
        return this.e;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public SourceInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setSourceName(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setSourceLogoUrl(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setSourceUrl(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public SourceInfo setSourceLogoUrl(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public SourceInfo setSourceName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public SourceInfo setSourceUrl(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasSourceName()) {
          paramCodedOutputStreamMicro.writeString(1, getSourceName());
        }
        if (hasSourceLogoUrl()) {
          paramCodedOutputStreamMicro.writeString(2, getSourceLogoUrl());
        }
        if (hasSourceUrl()) {
          paramCodedOutputStreamMicro.writeString(3, getSourceUrl());
        }
      }
    }
    
    public static final class TakeoutMenu
      extends MessageMicro
    {
      public static final int CATALOG_FIELD_NUMBER = 2;
      public static final int DATA_FIELD_NUMBER = 1;
      private List<Data> a = Collections.emptyList();
      private boolean b;
      private String c = "";
      private int d = -1;
      
      public static TakeoutMenu parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new TakeoutMenu().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static TakeoutMenu parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (TakeoutMenu)new TakeoutMenu().mergeFrom(paramArrayOfByte);
      }
      
      public TakeoutMenu addData(Data paramData)
      {
        if (paramData == null) {
          return this;
        }
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(paramData);
        return this;
      }
      
      public final TakeoutMenu clear()
      {
        clearData();
        clearCatalog();
        this.d = -1;
        return this;
      }
      
      public TakeoutMenu clearCatalog()
      {
        this.b = false;
        this.c = "";
        return this;
      }
      
      public TakeoutMenu clearData()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.d < 0) {
          getSerializedSize();
        }
        return this.d;
      }
      
      public String getCatalog()
      {
        return this.c;
      }
      
      public Data getData(int paramInt)
      {
        return (Data)this.a.get(paramInt);
      }
      
      public int getDataCount()
      {
        return this.a.size();
      }
      
      public List<Data> getDataList()
      {
        return this.a;
      }
      
      public int getSerializedSize()
      {
        Iterator localIterator = getDataList().iterator();
        for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Data)localIterator.next()) + i) {}
        int j = i;
        if (hasCatalog()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getCatalog());
        }
        this.d = j;
        return j;
      }
      
      public boolean hasCatalog()
      {
        return this.b;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public TakeoutMenu mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            Data localData = new Data();
            paramCodedInputStreamMicro.readMessage(localData);
            addData(localData);
            break;
          case 18: 
            setCatalog(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public TakeoutMenu setCatalog(String paramString)
      {
        this.b = true;
        this.c = paramString;
        return this;
      }
      
      public TakeoutMenu setData(int paramInt, Data paramData)
      {
        if (paramData == null) {
          return this;
        }
        this.a.set(paramInt, paramData);
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getDataList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(1, (Data)localIterator.next());
        }
        if (hasCatalog()) {
          paramCodedOutputStreamMicro.writeString(2, getCatalog());
        }
      }
      
      public static final class Data
        extends MessageMicro
      {
        public static final int AVAILABLE_TIMES_FIELD_NUMBER = 13;
        public static final int CURRENT_PRICE_FIELD_NUMBER = 3;
        public static final int DESCRIPTION_FIELD_NUMBER = 10;
        public static final int ITEM_ID_FIELD_NUMBER = 1;
        public static final int LEFT_NUM_FIELD_NUMBER = 11;
        public static final int MIN_ORDER_NUMBER_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int ON_SALE_FIELD_NUMBER = 12;
        public static final int PACKGE_BOX_NUM_FIELD_NUMBER = 6;
        public static final int PACKGE_BOX_PRICE_FIELD_NUMBER = 5;
        public static final int SALED_FIELD_NUMBER = 8;
        public static final int SALED_OUT_FIELD_NUMBER = 7;
        public static final int URL_FIELD_NUMBER = 9;
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
        private int p = 0;
        private boolean q;
        private String r = "";
        private boolean s;
        private String t = "";
        private boolean u;
        private int v = 0;
        private boolean w;
        private int x = 0;
        private List<AvailableTimes> y = Collections.emptyList();
        private int z = -1;
        
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
        
        public Data addAvailableTimes(AvailableTimes paramAvailableTimes)
        {
          if (paramAvailableTimes == null) {
            return this;
          }
          if (this.y.isEmpty()) {
            this.y = new ArrayList();
          }
          this.y.add(paramAvailableTimes);
          return this;
        }
        
        public final Data clear()
        {
          clearItemId();
          clearName();
          clearCurrentPrice();
          clearMinOrderNumber();
          clearPackgeBoxPrice();
          clearPackgeBoxNum();
          clearSaledOut();
          clearSaled();
          clearUrl();
          clearDescription();
          clearLeftNum();
          clearOnSale();
          clearAvailableTimes();
          this.z = -1;
          return this;
        }
        
        public Data clearAvailableTimes()
        {
          this.y = Collections.emptyList();
          return this;
        }
        
        public Data clearCurrentPrice()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public Data clearDescription()
        {
          this.s = false;
          this.t = "";
          return this;
        }
        
        public Data clearItemId()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public Data clearLeftNum()
        {
          this.u = false;
          this.v = 0;
          return this;
        }
        
        public Data clearMinOrderNumber()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public Data clearName()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public Data clearOnSale()
        {
          this.w = false;
          this.x = 0;
          return this;
        }
        
        public Data clearPackgeBoxNum()
        {
          this.k = false;
          this.l = "";
          return this;
        }
        
        public Data clearPackgeBoxPrice()
        {
          this.i = false;
          this.j = "";
          return this;
        }
        
        public Data clearSaled()
        {
          this.o = false;
          this.p = 0;
          return this;
        }
        
        public Data clearSaledOut()
        {
          this.m = false;
          this.n = "";
          return this;
        }
        
        public Data clearUrl()
        {
          this.q = false;
          this.r = "";
          return this;
        }
        
        public AvailableTimes getAvailableTimes(int paramInt)
        {
          return (AvailableTimes)this.y.get(paramInt);
        }
        
        public int getAvailableTimesCount()
        {
          return this.y.size();
        }
        
        public List<AvailableTimes> getAvailableTimesList()
        {
          return this.y;
        }
        
        public int getCachedSize()
        {
          if (this.z < 0) {
            getSerializedSize();
          }
          return this.z;
        }
        
        public String getCurrentPrice()
        {
          return this.f;
        }
        
        public String getDescription()
        {
          return this.t;
        }
        
        public String getItemId()
        {
          return this.b;
        }
        
        public int getLeftNum()
        {
          return this.v;
        }
        
        public String getMinOrderNumber()
        {
          return this.h;
        }
        
        public String getName()
        {
          return this.d;
        }
        
        public int getOnSale()
        {
          return this.x;
        }
        
        public String getPackgeBoxNum()
        {
          return this.l;
        }
        
        public String getPackgeBoxPrice()
        {
          return this.j;
        }
        
        public int getSaled()
        {
          return this.p;
        }
        
        public String getSaledOut()
        {
          return this.n;
        }
        
        public int getSerializedSize()
        {
          int i2 = 0;
          if (hasItemId()) {
            i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getItemId());
          }
          int i1 = i2;
          if (hasName()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
          }
          i2 = i1;
          if (hasCurrentPrice()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getCurrentPrice());
          }
          i1 = i2;
          if (hasMinOrderNumber()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getMinOrderNumber());
          }
          i2 = i1;
          if (hasPackgeBoxPrice()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getPackgeBoxPrice());
          }
          i1 = i2;
          if (hasPackgeBoxNum()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getPackgeBoxNum());
          }
          i2 = i1;
          if (hasSaledOut()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getSaledOut());
          }
          i1 = i2;
          if (hasSaled()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getSaled());
          }
          i2 = i1;
          if (hasUrl()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getUrl());
          }
          i1 = i2;
          if (hasDescription()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getDescription());
          }
          i2 = i1;
          if (hasLeftNum()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getLeftNum());
          }
          i1 = i2;
          if (hasOnSale()) {
            i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getOnSale());
          }
          Iterator localIterator = getAvailableTimesList().iterator();
          while (localIterator.hasNext()) {
            i1 = CodedOutputStreamMicro.computeMessageSize(13, (AvailableTimes)localIterator.next()) + i1;
          }
          this.z = i1;
          return i1;
        }
        
        public String getUrl()
        {
          return this.r;
        }
        
        public boolean hasCurrentPrice()
        {
          return this.e;
        }
        
        public boolean hasDescription()
        {
          return this.s;
        }
        
        public boolean hasItemId()
        {
          return this.a;
        }
        
        public boolean hasLeftNum()
        {
          return this.u;
        }
        
        public boolean hasMinOrderNumber()
        {
          return this.g;
        }
        
        public boolean hasName()
        {
          return this.c;
        }
        
        public boolean hasOnSale()
        {
          return this.w;
        }
        
        public boolean hasPackgeBoxNum()
        {
          return this.k;
        }
        
        public boolean hasPackgeBoxPrice()
        {
          return this.i;
        }
        
        public boolean hasSaled()
        {
          return this.o;
        }
        
        public boolean hasSaledOut()
        {
          return this.m;
        }
        
        public boolean hasUrl()
        {
          return this.q;
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
            int i1 = paramCodedInputStreamMicro.readTag();
            switch (i1)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
              break;
            case 0: 
              return this;
            case 10: 
              setItemId(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setName(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              setCurrentPrice(paramCodedInputStreamMicro.readString());
              break;
            case 34: 
              setMinOrderNumber(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              setPackgeBoxPrice(paramCodedInputStreamMicro.readString());
              break;
            case 50: 
              setPackgeBoxNum(paramCodedInputStreamMicro.readString());
              break;
            case 58: 
              setSaledOut(paramCodedInputStreamMicro.readString());
              break;
            case 64: 
              setSaled(paramCodedInputStreamMicro.readInt32());
              break;
            case 74: 
              setUrl(paramCodedInputStreamMicro.readString());
              break;
            case 82: 
              setDescription(paramCodedInputStreamMicro.readString());
              break;
            case 88: 
              setLeftNum(paramCodedInputStreamMicro.readInt32());
              break;
            case 96: 
              setOnSale(paramCodedInputStreamMicro.readInt32());
              break;
            case 106: 
              AvailableTimes localAvailableTimes = new AvailableTimes();
              paramCodedInputStreamMicro.readMessage(localAvailableTimes);
              addAvailableTimes(localAvailableTimes);
            }
          }
        }
        
        public Data setAvailableTimes(int paramInt, AvailableTimes paramAvailableTimes)
        {
          if (paramAvailableTimes == null) {
            return this;
          }
          this.y.set(paramInt, paramAvailableTimes);
          return this;
        }
        
        public Data setCurrentPrice(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public Data setDescription(String paramString)
        {
          this.s = true;
          this.t = paramString;
          return this;
        }
        
        public Data setItemId(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public Data setLeftNum(int paramInt)
        {
          this.u = true;
          this.v = paramInt;
          return this;
        }
        
        public Data setMinOrderNumber(String paramString)
        {
          this.g = true;
          this.h = paramString;
          return this;
        }
        
        public Data setName(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public Data setOnSale(int paramInt)
        {
          this.w = true;
          this.x = paramInt;
          return this;
        }
        
        public Data setPackgeBoxNum(String paramString)
        {
          this.k = true;
          this.l = paramString;
          return this;
        }
        
        public Data setPackgeBoxPrice(String paramString)
        {
          this.i = true;
          this.j = paramString;
          return this;
        }
        
        public Data setSaled(int paramInt)
        {
          this.o = true;
          this.p = paramInt;
          return this;
        }
        
        public Data setSaledOut(String paramString)
        {
          this.m = true;
          this.n = paramString;
          return this;
        }
        
        public Data setUrl(String paramString)
        {
          this.q = true;
          this.r = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasItemId()) {
            paramCodedOutputStreamMicro.writeString(1, getItemId());
          }
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(2, getName());
          }
          if (hasCurrentPrice()) {
            paramCodedOutputStreamMicro.writeString(3, getCurrentPrice());
          }
          if (hasMinOrderNumber()) {
            paramCodedOutputStreamMicro.writeString(4, getMinOrderNumber());
          }
          if (hasPackgeBoxPrice()) {
            paramCodedOutputStreamMicro.writeString(5, getPackgeBoxPrice());
          }
          if (hasPackgeBoxNum()) {
            paramCodedOutputStreamMicro.writeString(6, getPackgeBoxNum());
          }
          if (hasSaledOut()) {
            paramCodedOutputStreamMicro.writeString(7, getSaledOut());
          }
          if (hasSaled()) {
            paramCodedOutputStreamMicro.writeInt32(8, getSaled());
          }
          if (hasUrl()) {
            paramCodedOutputStreamMicro.writeString(9, getUrl());
          }
          if (hasDescription()) {
            paramCodedOutputStreamMicro.writeString(10, getDescription());
          }
          if (hasLeftNum()) {
            paramCodedOutputStreamMicro.writeInt32(11, getLeftNum());
          }
          if (hasOnSale()) {
            paramCodedOutputStreamMicro.writeInt32(12, getOnSale());
          }
          Iterator localIterator = getAvailableTimesList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(13, (AvailableTimes)localIterator.next());
          }
        }
        
        public static final class AvailableTimes
          extends MessageMicro
        {
          public static final int INDEX_FIELD_NUMBER = 1;
          public static final int TIMES_FIELD_NUMBER = 2;
          private boolean a;
          private String b = "";
          private List<Times> c = Collections.emptyList();
          private int d = -1;
          
          public static AvailableTimes parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new AvailableTimes().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static AvailableTimes parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (AvailableTimes)new AvailableTimes().mergeFrom(paramArrayOfByte);
          }
          
          public AvailableTimes addTimes(Times paramTimes)
          {
            if (paramTimes == null) {
              return this;
            }
            if (this.c.isEmpty()) {
              this.c = new ArrayList();
            }
            this.c.add(paramTimes);
            return this;
          }
          
          public final AvailableTimes clear()
          {
            clearIndex();
            clearTimes();
            this.d = -1;
            return this;
          }
          
          public AvailableTimes clearIndex()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public AvailableTimes clearTimes()
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
          
          public String getIndex()
          {
            return this.b;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasIndex()) {
              i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIndex());
            }
            Iterator localIterator = getTimesList().iterator();
            while (localIterator.hasNext()) {
              i = CodedOutputStreamMicro.computeMessageSize(2, (Times)localIterator.next()) + i;
            }
            this.d = i;
            return i;
          }
          
          public Times getTimes(int paramInt)
          {
            return (Times)this.c.get(paramInt);
          }
          
          public int getTimesCount()
          {
            return this.c.size();
          }
          
          public List<Times> getTimesList()
          {
            return this.c;
          }
          
          public boolean hasIndex()
          {
            return this.a;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public AvailableTimes mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setIndex(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                Times localTimes = new Times();
                paramCodedInputStreamMicro.readMessage(localTimes);
                addTimes(localTimes);
              }
            }
          }
          
          public AvailableTimes setIndex(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public AvailableTimes setTimes(int paramInt, Times paramTimes)
          {
            if (paramTimes == null) {
              return this;
            }
            this.c.set(paramInt, paramTimes);
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasIndex()) {
              paramCodedOutputStreamMicro.writeString(1, getIndex());
            }
            Iterator localIterator = getTimesList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeMessage(2, (Times)localIterator.next());
            }
          }
          
          public static final class Times
            extends MessageMicro
          {
            public static final int END_TIME_FIELD_NUMBER = 2;
            public static final int START_TIME_FIELD_NUMBER = 1;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
            private int e = -1;
            
            public static Times parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Times().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Times parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Times)new Times().mergeFrom(paramArrayOfByte);
            }
            
            public final Times clear()
            {
              clearStartTime();
              clearEndTime();
              this.e = -1;
              return this;
            }
            
            public Times clearEndTime()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public Times clearStartTime()
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
            
            public String getEndTime()
            {
              return this.d;
            }
            
            public int getSerializedSize()
            {
              int i = 0;
              if (hasStartTime()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStartTime());
              }
              int j = i;
              if (hasEndTime()) {
                j = i + CodedOutputStreamMicro.computeStringSize(2, getEndTime());
              }
              this.e = j;
              return j;
            }
            
            public String getStartTime()
            {
              return this.b;
            }
            
            public boolean hasEndTime()
            {
              return this.c;
            }
            
            public boolean hasStartTime()
            {
              return this.a;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Times mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  setStartTime(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setEndTime(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public Times setEndTime(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public Times setStartTime(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasStartTime()) {
                paramCodedOutputStreamMicro.writeString(1, getStartTime());
              }
              if (hasEndTime()) {
                paramCodedOutputStreamMicro.writeString(2, getEndTime());
              }
            }
          }
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int ERROR_MSG_FIELD_NUMBER = 2;
    public static final int ERROR_NO_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
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
      clearErrorNo();
      clearErrorMsg();
      this.e = -1;
      return this;
    }
    
    public Option clearErrorMsg()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Option clearErrorNo()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public String getErrorMsg()
    {
      return this.d;
    }
    
    public int getErrorNo()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasErrorNo()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getErrorNo());
      }
      int j = i;
      if (hasErrorMsg()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getErrorMsg());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasErrorMsg()
    {
      return this.c;
    }
    
    public boolean hasErrorNo()
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
          setErrorNo(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setErrorMsg(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Option setErrorMsg(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Option setErrorNo(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasErrorNo()) {
        paramCodedOutputStreamMicro.writeInt32(1, getErrorNo());
      }
      if (hasErrorMsg()) {
        paramCodedOutputStreamMicro.writeString(2, getErrorMsg());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/ShopMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */