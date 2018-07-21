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

public final class ShopList
  extends MessageMicro
{
  public static final int DISCOUNT_INFO_FIELD_NUMBER = 5;
  public static final int EXIST_ACTIVITY_FIELD_NUMBER = 7;
  public static final int FILTER_FIELD_NUMBER = 4;
  public static final int INVOICE_INFO_FIELD_NUMBER = 6;
  public static final int OPTION_FIELD_NUMBER = 1;
  public static final int SHOP_INFO_FIELD_NUMBER = 2;
  public static final int TOTAL_FIELD_NUMBER = 3;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Filter d = null;
  private boolean e;
  private DiscountInfo f = null;
  private boolean g;
  private InvoiceInfo h = null;
  private List<ShopInfo> i = Collections.emptyList();
  private boolean j;
  private int k = 0;
  private boolean l;
  private String m = "";
  private int n = -1;
  
  public static ShopList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new ShopList().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static ShopList parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (ShopList)new ShopList().mergeFrom(paramArrayOfByte);
  }
  
  public ShopList addShopInfo(ShopInfo paramShopInfo)
  {
    if (paramShopInfo == null) {
      return this;
    }
    if (this.i.isEmpty()) {
      this.i = new ArrayList();
    }
    this.i.add(paramShopInfo);
    return this;
  }
  
  public final ShopList clear()
  {
    clearOption();
    clearFilter();
    clearDiscountInfo();
    clearInvoiceInfo();
    clearShopInfo();
    clearTotal();
    clearExistActivity();
    this.n = -1;
    return this;
  }
  
  public ShopList clearDiscountInfo()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public ShopList clearExistActivity()
  {
    this.l = false;
    this.m = "";
    return this;
  }
  
  public ShopList clearFilter()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public ShopList clearInvoiceInfo()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public ShopList clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public ShopList clearShopInfo()
  {
    this.i = Collections.emptyList();
    return this;
  }
  
  public ShopList clearTotal()
  {
    this.j = false;
    this.k = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.n < 0) {
      getSerializedSize();
    }
    return this.n;
  }
  
  public DiscountInfo getDiscountInfo()
  {
    return this.f;
  }
  
  public String getExistActivity()
  {
    return this.m;
  }
  
  public Filter getFilter()
  {
    return this.d;
  }
  
  public InvoiceInfo getInvoiceInfo()
  {
    return this.h;
  }
  
  public Option getOption()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i1 = 0;
    if (hasOption()) {
      i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    Iterator localIterator = getShopInfoList().iterator();
    for (int i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(2, (ShopInfo)localIterator.next()) + i2) {}
    i1 = i2;
    if (hasTotal()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(3, getTotal());
    }
    i2 = i1;
    if (hasFilter()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(4, getFilter());
    }
    i1 = i2;
    if (hasDiscountInfo()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(5, getDiscountInfo());
    }
    i2 = i1;
    if (hasInvoiceInfo()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(6, getInvoiceInfo());
    }
    i1 = i2;
    if (hasExistActivity()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getExistActivity());
    }
    this.n = i1;
    return i1;
  }
  
  public ShopInfo getShopInfo(int paramInt)
  {
    return (ShopInfo)this.i.get(paramInt);
  }
  
  public int getShopInfoCount()
  {
    return this.i.size();
  }
  
  public List<ShopInfo> getShopInfoList()
  {
    return this.i;
  }
  
  public int getTotal()
  {
    return this.k;
  }
  
  public boolean hasDiscountInfo()
  {
    return this.e;
  }
  
  public boolean hasExistActivity()
  {
    return this.l;
  }
  
  public boolean hasFilter()
  {
    return this.c;
  }
  
  public boolean hasInvoiceInfo()
  {
    return this.g;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public boolean hasTotal()
  {
    return this.j;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public ShopList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 18: 
        localObject = new ShopInfo();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addShopInfo((ShopInfo)localObject);
        break;
      case 24: 
        setTotal(paramCodedInputStreamMicro.readInt32());
        break;
      case 34: 
        localObject = new Filter();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setFilter((Filter)localObject);
        break;
      case 42: 
        localObject = new DiscountInfo();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setDiscountInfo((DiscountInfo)localObject);
        break;
      case 50: 
        localObject = new InvoiceInfo();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setInvoiceInfo((InvoiceInfo)localObject);
        break;
      case 58: 
        setExistActivity(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public ShopList setDiscountInfo(DiscountInfo paramDiscountInfo)
  {
    if (paramDiscountInfo == null) {
      return clearDiscountInfo();
    }
    this.e = true;
    this.f = paramDiscountInfo;
    return this;
  }
  
  public ShopList setExistActivity(String paramString)
  {
    this.l = true;
    this.m = paramString;
    return this;
  }
  
  public ShopList setFilter(Filter paramFilter)
  {
    if (paramFilter == null) {
      return clearFilter();
    }
    this.c = true;
    this.d = paramFilter;
    return this;
  }
  
  public ShopList setInvoiceInfo(InvoiceInfo paramInvoiceInfo)
  {
    if (paramInvoiceInfo == null) {
      return clearInvoiceInfo();
    }
    this.g = true;
    this.h = paramInvoiceInfo;
    return this;
  }
  
  public ShopList setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.a = true;
    this.b = paramOption;
    return this;
  }
  
  public ShopList setShopInfo(int paramInt, ShopInfo paramShopInfo)
  {
    if (paramShopInfo == null) {
      return this;
    }
    this.i.set(paramInt, paramShopInfo);
    return this;
  }
  
  public ShopList setTotal(int paramInt)
  {
    this.j = true;
    this.k = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(1, getOption());
    }
    Iterator localIterator = getShopInfoList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (ShopInfo)localIterator.next());
    }
    if (hasTotal()) {
      paramCodedOutputStreamMicro.writeInt32(3, getTotal());
    }
    if (hasFilter()) {
      paramCodedOutputStreamMicro.writeMessage(4, getFilter());
    }
    if (hasDiscountInfo()) {
      paramCodedOutputStreamMicro.writeMessage(5, getDiscountInfo());
    }
    if (hasInvoiceInfo()) {
      paramCodedOutputStreamMicro.writeMessage(6, getInvoiceInfo());
    }
    if (hasExistActivity()) {
      paramCodedOutputStreamMicro.writeString(7, getExistActivity());
    }
  }
  
  public static final class DiscountInfo
    extends MessageMicro
  {
    public static final int DISCOUNT_FIRST_ORDER_SHOW_FIELD_NUMBER = 4;
    public static final int DISCOUNT_SEND_SHOW_FIELD_NUMBER = 3;
    public static final int IS_DISCOUNT_FIRST_ORDER_FIELD_NUMBER = 2;
    public static final int IS_DISCOUNT_SEND_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static DiscountInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new DiscountInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static DiscountInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (DiscountInfo)new DiscountInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final DiscountInfo clear()
    {
      clearIsDiscountSend();
      clearIsDiscountFirstOrder();
      clearDiscountSendShow();
      clearDiscountFirstOrderShow();
      this.i = -1;
      return this;
    }
    
    public DiscountInfo clearDiscountFirstOrderShow()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public DiscountInfo clearDiscountSendShow()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public DiscountInfo clearIsDiscountFirstOrder()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public DiscountInfo clearIsDiscountSend()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public String getDiscountFirstOrderShow()
    {
      return this.h;
    }
    
    public String getDiscountSendShow()
    {
      return this.f;
    }
    
    public int getIsDiscountFirstOrder()
    {
      return this.d;
    }
    
    public int getIsDiscountSend()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasIsDiscountSend()) {
        k = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsDiscountSend());
      }
      int j = k;
      if (hasIsDiscountFirstOrder()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(2, getIsDiscountFirstOrder());
      }
      k = j;
      if (hasDiscountSendShow()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getDiscountSendShow());
      }
      j = k;
      if (hasDiscountFirstOrderShow()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getDiscountFirstOrderShow());
      }
      this.i = j;
      return j;
    }
    
    public boolean hasDiscountFirstOrderShow()
    {
      return this.g;
    }
    
    public boolean hasDiscountSendShow()
    {
      return this.e;
    }
    
    public boolean hasIsDiscountFirstOrder()
    {
      return this.c;
    }
    
    public boolean hasIsDiscountSend()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public DiscountInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        case 8: 
          setIsDiscountSend(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setIsDiscountFirstOrder(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setDiscountSendShow(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setDiscountFirstOrderShow(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public DiscountInfo setDiscountFirstOrderShow(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public DiscountInfo setDiscountSendShow(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public DiscountInfo setIsDiscountFirstOrder(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public DiscountInfo setIsDiscountSend(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsDiscountSend()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIsDiscountSend());
      }
      if (hasIsDiscountFirstOrder()) {
        paramCodedOutputStreamMicro.writeInt32(2, getIsDiscountFirstOrder());
      }
      if (hasDiscountSendShow()) {
        paramCodedOutputStreamMicro.writeString(3, getDiscountSendShow());
      }
      if (hasDiscountFirstOrderShow()) {
        paramCodedOutputStreamMicro.writeString(4, getDiscountFirstOrderShow());
      }
    }
  }
  
  public static final class Filter
    extends MessageMicro
  {
    public static final int PROMOTION_FIELD_NUMBER = 3;
    public static final int SORTBY_FIELD_NUMBER = 1;
    public static final int TASTE_FIELD_NUMBER = 4;
    public static final int WD_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static Filter parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Filter().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Filter parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Filter)new Filter().mergeFrom(paramArrayOfByte);
    }
    
    public final Filter clear()
    {
      clearSortby();
      clearWd();
      clearPromotion();
      clearTaste();
      this.i = -1;
      return this;
    }
    
    public Filter clearPromotion()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Filter clearSortby()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Filter clearTaste()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Filter clearWd()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public String getPromotion()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasSortby()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getSortby());
      }
      int j = k;
      if (hasWd()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getWd());
      }
      k = j;
      if (hasPromotion()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getPromotion());
      }
      j = k;
      if (hasTaste()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getTaste());
      }
      this.i = j;
      return j;
    }
    
    public String getSortby()
    {
      return this.b;
    }
    
    public String getTaste()
    {
      return this.h;
    }
    
    public String getWd()
    {
      return this.d;
    }
    
    public boolean hasPromotion()
    {
      return this.e;
    }
    
    public boolean hasSortby()
    {
      return this.a;
    }
    
    public boolean hasTaste()
    {
      return this.g;
    }
    
    public boolean hasWd()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Filter mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setSortby(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setWd(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setPromotion(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setTaste(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Filter setPromotion(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Filter setSortby(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Filter setTaste(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Filter setWd(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasSortby()) {
        paramCodedOutputStreamMicro.writeString(1, getSortby());
      }
      if (hasWd()) {
        paramCodedOutputStreamMicro.writeString(2, getWd());
      }
      if (hasPromotion()) {
        paramCodedOutputStreamMicro.writeString(3, getPromotion());
      }
      if (hasTaste()) {
        paramCodedOutputStreamMicro.writeString(4, getTaste());
      }
    }
  }
  
  public static final class InvoiceInfo
    extends MessageMicro
  {
    public static final int IS_SUPPORT_INVOICE_FIELD_NUMBER = 1;
    public static final int SUPPORT_INVOICE_SHOW_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static InvoiceInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new InvoiceInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static InvoiceInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (InvoiceInfo)new InvoiceInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final InvoiceInfo clear()
    {
      clearIsSupportInvoice();
      clearSupportInvoiceShow();
      this.e = -1;
      return this;
    }
    
    public InvoiceInfo clearIsSupportInvoice()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public InvoiceInfo clearSupportInvoiceShow()
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
    
    public int getIsSupportInvoice()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasIsSupportInvoice()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsSupportInvoice());
      }
      int j = i;
      if (hasSupportInvoiceShow()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getSupportInvoiceShow());
      }
      this.e = j;
      return j;
    }
    
    public String getSupportInvoiceShow()
    {
      return this.d;
    }
    
    public boolean hasIsSupportInvoice()
    {
      return this.a;
    }
    
    public boolean hasSupportInvoiceShow()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public InvoiceInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIsSupportInvoice(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setSupportInvoiceShow(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public InvoiceInfo setIsSupportInvoice(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public InvoiceInfo setSupportInvoiceShow(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsSupportInvoice()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIsSupportInvoice());
      }
      if (hasSupportInvoiceShow()) {
        paramCodedOutputStreamMicro.writeString(2, getSupportInvoiceShow());
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
  
  public static final class ShopInfo
    extends MessageMicro
  {
    public static final int BUSSINESS_STATUS_FIELD_NUMBER = 7;
    public static final int COUPON_INFO_FIELD_NUMBER = 17;
    public static final int DELIVERY_REGIONS_FIELD_NUMBER = 15;
    public static final int DELIVERY_TIME_FIELD_NUMBER = 5;
    public static final int DISCOUNT_INFO_FIELD_NUMBER = 10;
    public static final int DISTANCE_FIELD_NUMBER = 13;
    public static final int END_TIME_FIELD_NUMBER = 11;
    public static final int INVOICE_INFO_FIELD_NUMBER = 16;
    public static final int IS_ONLINE_FIELD_NUMBER = 12;
    public static final int LOGO_URL_FIELD_NUMBER = 2;
    public static final int RELEASE_ID_FIELD_NUMBER = 8;
    public static final int SALED_FIELD_NUMBER = 9;
    public static final int SHOP_ID_FIELD_NUMBER = 14;
    public static final int SHOP_NAME_FIELD_NUMBER = 1;
    public static final int START_TIME_FIELD_NUMBER = 6;
    public static final int TAKEOUT_COST_FIELD_NUMBER = 4;
    public static final int TAKEOUT_PRICE_FIELD_NUMBER = 3;
    private boolean A;
    private int B = 0;
    private boolean C;
    private String D = "";
    private boolean E;
    private String F = "";
    private boolean G;
    private String H = "";
    private int I = -1;
    private boolean a;
    private DiscountInfo b = null;
    private boolean c;
    private InvoiceInfo d = null;
    private boolean e;
    private CouponInfo f = null;
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
    private int t = 0;
    private boolean u;
    private String v = "";
    private boolean w;
    private int x = 0;
    private boolean y;
    private String z = "";
    
    public static ShopInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ShopInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ShopInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ShopInfo)new ShopInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final ShopInfo clear()
    {
      clearDiscountInfo();
      clearInvoiceInfo();
      clearCouponInfo();
      clearShopName();
      clearLogoUrl();
      clearTakeoutPrice();
      clearTakeoutCost();
      clearDeliveryTime();
      clearStartTime();
      clearBussinessStatus();
      clearReleaseId();
      clearSaled();
      clearEndTime();
      clearIsOnline();
      clearDistance();
      clearShopId();
      clearDeliveryRegions();
      this.I = -1;
      return this;
    }
    
    public ShopInfo clearBussinessStatus()
    {
      this.s = false;
      this.t = 0;
      return this;
    }
    
    public ShopInfo clearCouponInfo()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public ShopInfo clearDeliveryRegions()
    {
      this.G = false;
      this.H = "";
      return this;
    }
    
    public ShopInfo clearDeliveryTime()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public ShopInfo clearDiscountInfo()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public ShopInfo clearDistance()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public ShopInfo clearEndTime()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public ShopInfo clearInvoiceInfo()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public ShopInfo clearIsOnline()
    {
      this.A = false;
      this.B = 0;
      return this;
    }
    
    public ShopInfo clearLogoUrl()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public ShopInfo clearReleaseId()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public ShopInfo clearSaled()
    {
      this.w = false;
      this.x = 0;
      return this;
    }
    
    public ShopInfo clearShopId()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public ShopInfo clearShopName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public ShopInfo clearStartTime()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public ShopInfo clearTakeoutCost()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public ShopInfo clearTakeoutPrice()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public int getBussinessStatus()
    {
      return this.t;
    }
    
    public int getCachedSize()
    {
      if (this.I < 0) {
        getSerializedSize();
      }
      return this.I;
    }
    
    public CouponInfo getCouponInfo()
    {
      return this.f;
    }
    
    public String getDeliveryRegions()
    {
      return this.H;
    }
    
    public String getDeliveryTime()
    {
      return this.p;
    }
    
    public DiscountInfo getDiscountInfo()
    {
      return this.b;
    }
    
    public String getDistance()
    {
      return this.D;
    }
    
    public String getEndTime()
    {
      return this.z;
    }
    
    public InvoiceInfo getInvoiceInfo()
    {
      return this.d;
    }
    
    public int getIsOnline()
    {
      return this.B;
    }
    
    public String getLogoUrl()
    {
      return this.j;
    }
    
    public String getReleaseId()
    {
      return this.v;
    }
    
    public int getSaled()
    {
      return this.x;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasShopName()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getShopName());
      }
      int i1 = i2;
      if (hasLogoUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getLogoUrl());
      }
      i2 = i1;
      if (hasTakeoutPrice()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getTakeoutPrice());
      }
      i1 = i2;
      if (hasTakeoutCost()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getTakeoutCost());
      }
      i2 = i1;
      if (hasDeliveryTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getDeliveryTime());
      }
      i1 = i2;
      if (hasStartTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getStartTime());
      }
      i2 = i1;
      if (hasBussinessStatus()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getBussinessStatus());
      }
      i1 = i2;
      if (hasReleaseId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getReleaseId());
      }
      i2 = i1;
      if (hasSaled()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getSaled());
      }
      i1 = i2;
      if (hasDiscountInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(10, getDiscountInfo());
      }
      i2 = i1;
      if (hasEndTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getEndTime());
      }
      i1 = i2;
      if (hasIsOnline()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getIsOnline());
      }
      i2 = i1;
      if (hasDistance()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getDistance());
      }
      i1 = i2;
      if (hasShopId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getShopId());
      }
      i2 = i1;
      if (hasDeliveryRegions()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getDeliveryRegions());
      }
      i1 = i2;
      if (hasInvoiceInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(16, getInvoiceInfo());
      }
      i2 = i1;
      if (hasCouponInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(17, getCouponInfo());
      }
      this.I = i2;
      return i2;
    }
    
    public String getShopId()
    {
      return this.F;
    }
    
    public String getShopName()
    {
      return this.h;
    }
    
    public String getStartTime()
    {
      return this.r;
    }
    
    public String getTakeoutCost()
    {
      return this.n;
    }
    
    public String getTakeoutPrice()
    {
      return this.l;
    }
    
    public boolean hasBussinessStatus()
    {
      return this.s;
    }
    
    public boolean hasCouponInfo()
    {
      return this.e;
    }
    
    public boolean hasDeliveryRegions()
    {
      return this.G;
    }
    
    public boolean hasDeliveryTime()
    {
      return this.o;
    }
    
    public boolean hasDiscountInfo()
    {
      return this.a;
    }
    
    public boolean hasDistance()
    {
      return this.C;
    }
    
    public boolean hasEndTime()
    {
      return this.y;
    }
    
    public boolean hasInvoiceInfo()
    {
      return this.c;
    }
    
    public boolean hasIsOnline()
    {
      return this.A;
    }
    
    public boolean hasLogoUrl()
    {
      return this.i;
    }
    
    public boolean hasReleaseId()
    {
      return this.u;
    }
    
    public boolean hasSaled()
    {
      return this.w;
    }
    
    public boolean hasShopId()
    {
      return this.E;
    }
    
    public boolean hasShopName()
    {
      return this.g;
    }
    
    public boolean hasStartTime()
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
    
    public ShopInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setShopName(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setLogoUrl(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTakeoutPrice(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setTakeoutCost(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setDeliveryTime(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setStartTime(paramCodedInputStreamMicro.readString());
          break;
        case 56: 
          setBussinessStatus(paramCodedInputStreamMicro.readInt32());
          break;
        case 66: 
          setReleaseId(paramCodedInputStreamMicro.readString());
          break;
        case 72: 
          setSaled(paramCodedInputStreamMicro.readInt32());
          break;
        case 82: 
          localObject = new DiscountInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setDiscountInfo((DiscountInfo)localObject);
          break;
        case 90: 
          setEndTime(paramCodedInputStreamMicro.readString());
          break;
        case 96: 
          setIsOnline(paramCodedInputStreamMicro.readInt32());
          break;
        case 106: 
          setDistance(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setShopId(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setDeliveryRegions(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          localObject = new InvoiceInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setInvoiceInfo((InvoiceInfo)localObject);
          break;
        case 138: 
          localObject = new CouponInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCouponInfo((CouponInfo)localObject);
        }
      }
    }
    
    public ShopInfo setBussinessStatus(int paramInt)
    {
      this.s = true;
      this.t = paramInt;
      return this;
    }
    
    public ShopInfo setCouponInfo(CouponInfo paramCouponInfo)
    {
      if (paramCouponInfo == null) {
        return clearCouponInfo();
      }
      this.e = true;
      this.f = paramCouponInfo;
      return this;
    }
    
    public ShopInfo setDeliveryRegions(String paramString)
    {
      this.G = true;
      this.H = paramString;
      return this;
    }
    
    public ShopInfo setDeliveryTime(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public ShopInfo setDiscountInfo(DiscountInfo paramDiscountInfo)
    {
      if (paramDiscountInfo == null) {
        return clearDiscountInfo();
      }
      this.a = true;
      this.b = paramDiscountInfo;
      return this;
    }
    
    public ShopInfo setDistance(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public ShopInfo setEndTime(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public ShopInfo setInvoiceInfo(InvoiceInfo paramInvoiceInfo)
    {
      if (paramInvoiceInfo == null) {
        return clearInvoiceInfo();
      }
      this.c = true;
      this.d = paramInvoiceInfo;
      return this;
    }
    
    public ShopInfo setIsOnline(int paramInt)
    {
      this.A = true;
      this.B = paramInt;
      return this;
    }
    
    public ShopInfo setLogoUrl(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public ShopInfo setReleaseId(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public ShopInfo setSaled(int paramInt)
    {
      this.w = true;
      this.x = paramInt;
      return this;
    }
    
    public ShopInfo setShopId(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public ShopInfo setShopName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public ShopInfo setStartTime(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public ShopInfo setTakeoutCost(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public ShopInfo setTakeoutPrice(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasShopName()) {
        paramCodedOutputStreamMicro.writeString(1, getShopName());
      }
      if (hasLogoUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getLogoUrl());
      }
      if (hasTakeoutPrice()) {
        paramCodedOutputStreamMicro.writeString(3, getTakeoutPrice());
      }
      if (hasTakeoutCost()) {
        paramCodedOutputStreamMicro.writeString(4, getTakeoutCost());
      }
      if (hasDeliveryTime()) {
        paramCodedOutputStreamMicro.writeString(5, getDeliveryTime());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeString(6, getStartTime());
      }
      if (hasBussinessStatus()) {
        paramCodedOutputStreamMicro.writeInt32(7, getBussinessStatus());
      }
      if (hasReleaseId()) {
        paramCodedOutputStreamMicro.writeString(8, getReleaseId());
      }
      if (hasSaled()) {
        paramCodedOutputStreamMicro.writeInt32(9, getSaled());
      }
      if (hasDiscountInfo()) {
        paramCodedOutputStreamMicro.writeMessage(10, getDiscountInfo());
      }
      if (hasEndTime()) {
        paramCodedOutputStreamMicro.writeString(11, getEndTime());
      }
      if (hasIsOnline()) {
        paramCodedOutputStreamMicro.writeInt32(12, getIsOnline());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeString(13, getDistance());
      }
      if (hasShopId()) {
        paramCodedOutputStreamMicro.writeString(14, getShopId());
      }
      if (hasDeliveryRegions()) {
        paramCodedOutputStreamMicro.writeString(15, getDeliveryRegions());
      }
      if (hasInvoiceInfo()) {
        paramCodedOutputStreamMicro.writeMessage(16, getInvoiceInfo());
      }
      if (hasCouponInfo()) {
        paramCodedOutputStreamMicro.writeMessage(17, getCouponInfo());
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
    
    public static final class DiscountInfo
      extends MessageMicro
    {
      public static final int DISCOUNT_FIRST_ORDER_SHOW_FIELD_NUMBER = 4;
      public static final int DISCOUNT_SEND_SHOW_FIELD_NUMBER = 3;
      public static final int IS_DISCOUNT_FIRST_ORDER_FIELD_NUMBER = 2;
      public static final int IS_DISCOUNT_SEND_FIELD_NUMBER = 1;
      private boolean a;
      private int b = 0;
      private boolean c;
      private int d = 0;
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private int i = -1;
      
      public static DiscountInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new DiscountInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static DiscountInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (DiscountInfo)new DiscountInfo().mergeFrom(paramArrayOfByte);
      }
      
      public final DiscountInfo clear()
      {
        clearIsDiscountSend();
        clearIsDiscountFirstOrder();
        clearDiscountSendShow();
        clearDiscountFirstOrderShow();
        this.i = -1;
        return this;
      }
      
      public DiscountInfo clearDiscountFirstOrderShow()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public DiscountInfo clearDiscountSendShow()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public DiscountInfo clearIsDiscountFirstOrder()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public DiscountInfo clearIsDiscountSend()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public String getDiscountFirstOrderShow()
      {
        return this.h;
      }
      
      public String getDiscountSendShow()
      {
        return this.f;
      }
      
      public int getIsDiscountFirstOrder()
      {
        return this.d;
      }
      
      public int getIsDiscountSend()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasIsDiscountSend()) {
          k = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsDiscountSend());
        }
        int j = k;
        if (hasIsDiscountFirstOrder()) {
          j = k + CodedOutputStreamMicro.computeInt32Size(2, getIsDiscountFirstOrder());
        }
        k = j;
        if (hasDiscountSendShow()) {
          k = j + CodedOutputStreamMicro.computeStringSize(3, getDiscountSendShow());
        }
        j = k;
        if (hasDiscountFirstOrderShow()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getDiscountFirstOrderShow());
        }
        this.i = j;
        return j;
      }
      
      public boolean hasDiscountFirstOrderShow()
      {
        return this.g;
      }
      
      public boolean hasDiscountSendShow()
      {
        return this.e;
      }
      
      public boolean hasIsDiscountFirstOrder()
      {
        return this.c;
      }
      
      public boolean hasIsDiscountSend()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public DiscountInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          case 8: 
            setIsDiscountSend(paramCodedInputStreamMicro.readInt32());
            break;
          case 16: 
            setIsDiscountFirstOrder(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            setDiscountSendShow(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setDiscountFirstOrderShow(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public DiscountInfo setDiscountFirstOrderShow(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public DiscountInfo setDiscountSendShow(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public DiscountInfo setIsDiscountFirstOrder(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public DiscountInfo setIsDiscountSend(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasIsDiscountSend()) {
          paramCodedOutputStreamMicro.writeInt32(1, getIsDiscountSend());
        }
        if (hasIsDiscountFirstOrder()) {
          paramCodedOutputStreamMicro.writeInt32(2, getIsDiscountFirstOrder());
        }
        if (hasDiscountSendShow()) {
          paramCodedOutputStreamMicro.writeString(3, getDiscountSendShow());
        }
        if (hasDiscountFirstOrderShow()) {
          paramCodedOutputStreamMicro.writeString(4, getDiscountFirstOrderShow());
        }
      }
    }
    
    public static final class InvoiceInfo
      extends MessageMicro
    {
      public static final int IS_SUPPORT_INVOICE_FIELD_NUMBER = 1;
      public static final int SUPPORT_INVOICE_SHOW_FIELD_NUMBER = 2;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static InvoiceInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new InvoiceInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static InvoiceInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (InvoiceInfo)new InvoiceInfo().mergeFrom(paramArrayOfByte);
      }
      
      public final InvoiceInfo clear()
      {
        clearIsSupportInvoice();
        clearSupportInvoiceShow();
        this.e = -1;
        return this;
      }
      
      public InvoiceInfo clearIsSupportInvoice()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public InvoiceInfo clearSupportInvoiceShow()
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
      
      public int getIsSupportInvoice()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasIsSupportInvoice()) {
          i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsSupportInvoice());
        }
        int j = i;
        if (hasSupportInvoiceShow()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getSupportInvoiceShow());
        }
        this.e = j;
        return j;
      }
      
      public String getSupportInvoiceShow()
      {
        return this.d;
      }
      
      public boolean hasIsSupportInvoice()
      {
        return this.a;
      }
      
      public boolean hasSupportInvoiceShow()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public InvoiceInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setIsSupportInvoice(paramCodedInputStreamMicro.readInt32());
            break;
          case 18: 
            setSupportInvoiceShow(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public InvoiceInfo setIsSupportInvoice(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public InvoiceInfo setSupportInvoiceShow(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasIsSupportInvoice()) {
          paramCodedOutputStreamMicro.writeInt32(1, getIsSupportInvoice());
        }
        if (hasSupportInvoiceShow()) {
          paramCodedOutputStreamMicro.writeString(2, getSupportInvoiceShow());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/ShopList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */