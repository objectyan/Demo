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

public final class Orderlists
  extends MessageMicro
{
  public static final int CODE_FIELD_NUMBER = 1;
  public static final int DATA_FIELD_NUMBER = 4;
  public static final int LOGID_FIELD_NUMBER = 3;
  public static final int MSG_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private boolean g;
  private Data h = null;
  private int i = -1;
  
  public static Orderlists parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Orderlists().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Orderlists parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Orderlists)new Orderlists().mergeFrom(paramArrayOfByte);
  }
  
  public final Orderlists clear()
  {
    clearCode();
    clearMsg();
    clearLogid();
    clearData();
    this.i = -1;
    return this;
  }
  
  public Orderlists clearCode()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public Orderlists clearData()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public Orderlists clearLogid()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public Orderlists clearMsg()
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
  
  public int getCode()
  {
    return this.b;
  }
  
  public Data getData()
  {
    return this.h;
  }
  
  public String getLogid()
  {
    return this.f;
  }
  
  public String getMsg()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int k = 0;
    if (hasCode()) {
      k = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
    }
    int j = k;
    if (hasMsg()) {
      j = k + CodedOutputStreamMicro.computeStringSize(2, getMsg());
    }
    k = j;
    if (hasLogid()) {
      k = j + CodedOutputStreamMicro.computeStringSize(3, getLogid());
    }
    j = k;
    if (hasData()) {
      j = k + CodedOutputStreamMicro.computeMessageSize(4, getData());
    }
    this.i = j;
    return j;
  }
  
  public boolean hasCode()
  {
    return this.a;
  }
  
  public boolean hasData()
  {
    return this.g;
  }
  
  public boolean hasLogid()
  {
    return this.e;
  }
  
  public boolean hasMsg()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Orderlists mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setCode(paramCodedInputStreamMicro.readInt32());
        break;
      case 18: 
        setMsg(paramCodedInputStreamMicro.readString());
        break;
      case 26: 
        setLogid(paramCodedInputStreamMicro.readString());
        break;
      case 34: 
        Data localData = new Data();
        paramCodedInputStreamMicro.readMessage(localData);
        setData(localData);
      }
    }
  }
  
  public Orderlists setCode(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public Orderlists setData(Data paramData)
  {
    if (paramData == null) {
      return clearData();
    }
    this.g = true;
    this.h = paramData;
    return this;
  }
  
  public Orderlists setLogid(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public Orderlists setMsg(String paramString)
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
    if (hasMsg()) {
      paramCodedOutputStreamMicro.writeString(2, getMsg());
    }
    if (hasLogid()) {
      paramCodedOutputStreamMicro.writeString(3, getLogid());
    }
    if (hasData()) {
      paramCodedOutputStreamMicro.writeMessage(4, getData());
    }
  }
  
  public static final class Data
    extends MessageMicro
  {
    public static final int LISTS_FIELD_NUMBER = 2;
    public static final int TOTAL_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private List<Lists> c = Collections.emptyList();
    private int d = -1;
    
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
    
    public Data addLists(Lists paramLists)
    {
      if (paramLists == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramLists);
      return this;
    }
    
    public final Data clear()
    {
      clearTotal();
      clearLists();
      this.d = -1;
      return this;
    }
    
    public Data clearLists()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public Data clearTotal()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public Lists getLists(int paramInt)
    {
      return (Lists)this.c.get(paramInt);
    }
    
    public int getListsCount()
    {
      return this.c.size();
    }
    
    public List<Lists> getListsList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasTotal()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
      }
      Iterator localIterator = getListsList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (Lists)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public int getTotal()
    {
      return this.b;
    }
    
    public boolean hasTotal()
    {
      return this.a;
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
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setTotal(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          Lists localLists = new Lists();
          paramCodedInputStreamMicro.readMessage(localLists);
          addLists(localLists);
        }
      }
    }
    
    public Data setLists(int paramInt, Lists paramLists)
    {
      if (paramLists == null) {
        return this;
      }
      this.c.set(paramInt, paramLists);
      return this;
    }
    
    public Data setTotal(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTotal()) {
        paramCodedOutputStreamMicro.writeInt32(1, getTotal());
      }
      Iterator localIterator = getListsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Lists)localIterator.next());
      }
    }
    
    public static final class Lists
      extends MessageMicro
    {
      public static final int CAT_ID_FIELD_NUMBER = 17;
      public static final int COMPOSETEXT_FIELD_NUMBER = 25;
      public static final int CO_DETAIL_AMOUNT_FIELD_NUMBER = 15;
      public static final int CO_DETAIL_TYPE_FIELD_NUMBER = 16;
      public static final int CREATE_TIME_FIELD_NUMBER = 10;
      public static final int CUID_FIELD_NUMBER = 6;
      public static final int DEL_DESC_FIELD_NUMBER = 24;
      public static final int DEL_URL_FIELD_NUMBER = 23;
      public static final int DISCOUNT_AMOUNT_FIELD_NUMBER = 12;
      public static final int MERCHANT_URL_FIELD_NUMBER = 26;
      public static final int OPERATE_FIELD_NUMBER = 22;
      public static final int OP_ADDRESS_FIELD_NUMBER = 21;
      public static final int OP_MOBILE_FIELD_NUMBER = 8;
      public static final int OP_UID_FIELD_NUMBER = 7;
      public static final int ORDER_ADD_FIELD_NUMBER = 19;
      public static final int ORDER_NO_FIELD_NUMBER = 1;
      public static final int ORDER_SOURCE_URL_FIELD_NUMBER = 20;
      public static final int ORDER_TITLE_FIELD_NUMBER = 5;
      public static final int PAY_AMOUNT_FIELD_NUMBER = 13;
      public static final int PHOTO_URL_FIELD_NUMBER = 18;
      public static final int RETURN_AMOUNT_FIELD_NUMBER = 14;
      public static final int TOTAL_AMOUNT_FIELD_NUMBER = 11;
      public static final int TPL_FIELD_NUMBER = 2;
      public static final int TPL_ICON_FIELD_NUMBER = 4;
      public static final int TPL_STATUS_FIELD_NUMBER = 9;
      public static final int TPL_TITLE_FIELD_NUMBER = 3;
      private boolean A;
      private int B = 0;
      private boolean C;
      private int D = 0;
      private boolean E;
      private String F = "";
      private boolean G;
      private int H = 0;
      private boolean I;
      private String J = "";
      private boolean K;
      private Order_add L = null;
      private boolean M;
      private String N = "";
      private boolean O;
      private String P = "";
      private boolean Q;
      private Operate R = null;
      private boolean S;
      private String T = "";
      private boolean U;
      private String V = "";
      private boolean W;
      private String X = "";
      private boolean Y;
      private String Z = "";
      private boolean a;
      private int aa = -1;
      private String b = "";
      private boolean c;
      private int d = 0;
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
      private int t = 0;
      private boolean u;
      private int v = 0;
      private boolean w;
      private int x = 0;
      private boolean y;
      private int z = 0;
      
      public static Lists parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Lists().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Lists parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Lists)new Lists().mergeFrom(paramArrayOfByte);
      }
      
      public final Lists clear()
      {
        clearOrderNo();
        clearTpl();
        clearTplTitle();
        clearTplIcon();
        clearOrderTitle();
        clearCuid();
        clearOpUid();
        clearOpMobile();
        clearTplStatus();
        clearCreateTime();
        clearTotalAmount();
        clearDiscountAmount();
        clearPayAmount();
        clearReturnAmount();
        clearCoDetailAmount();
        clearCoDetailType();
        clearCatId();
        clearPhotoUrl();
        clearOrderAdd();
        clearOrderSourceUrl();
        clearOpAddress();
        clearOperate();
        clearDelUrl();
        clearDelDesc();
        clearComposeText();
        clearMerchantUrl();
        this.aa = -1;
        return this;
      }
      
      public Lists clearCatId()
      {
        this.G = false;
        this.H = 0;
        return this;
      }
      
      public Lists clearCoDetailAmount()
      {
        this.C = false;
        this.D = 0;
        return this;
      }
      
      public Lists clearCoDetailType()
      {
        this.E = false;
        this.F = "";
        return this;
      }
      
      public Lists clearComposeText()
      {
        this.W = false;
        this.X = "";
        return this;
      }
      
      public Lists clearCreateTime()
      {
        this.s = false;
        this.t = 0;
        return this;
      }
      
      public Lists clearCuid()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public Lists clearDelDesc()
      {
        this.U = false;
        this.V = "";
        return this;
      }
      
      public Lists clearDelUrl()
      {
        this.S = false;
        this.T = "";
        return this;
      }
      
      public Lists clearDiscountAmount()
      {
        this.w = false;
        this.x = 0;
        return this;
      }
      
      public Lists clearMerchantUrl()
      {
        this.Y = false;
        this.Z = "";
        return this;
      }
      
      public Lists clearOpAddress()
      {
        this.O = false;
        this.P = "";
        return this;
      }
      
      public Lists clearOpMobile()
      {
        this.o = false;
        this.p = 0;
        return this;
      }
      
      public Lists clearOpUid()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public Lists clearOperate()
      {
        this.Q = false;
        this.R = null;
        return this;
      }
      
      public Lists clearOrderAdd()
      {
        this.K = false;
        this.L = null;
        return this;
      }
      
      public Lists clearOrderNo()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Lists clearOrderSourceUrl()
      {
        this.M = false;
        this.N = "";
        return this;
      }
      
      public Lists clearOrderTitle()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public Lists clearPayAmount()
      {
        this.y = false;
        this.z = 0;
        return this;
      }
      
      public Lists clearPhotoUrl()
      {
        this.I = false;
        this.J = "";
        return this;
      }
      
      public Lists clearReturnAmount()
      {
        this.A = false;
        this.B = 0;
        return this;
      }
      
      public Lists clearTotalAmount()
      {
        this.u = false;
        this.v = 0;
        return this;
      }
      
      public Lists clearTpl()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public Lists clearTplIcon()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Lists clearTplStatus()
      {
        this.q = false;
        this.r = "";
        return this;
      }
      
      public Lists clearTplTitle()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.aa < 0) {
          getSerializedSize();
        }
        return this.aa;
      }
      
      public int getCatId()
      {
        return this.H;
      }
      
      public int getCoDetailAmount()
      {
        return this.D;
      }
      
      public String getCoDetailType()
      {
        return this.F;
      }
      
      public String getComposeText()
      {
        return this.X;
      }
      
      public int getCreateTime()
      {
        return this.t;
      }
      
      public String getCuid()
      {
        return this.l;
      }
      
      public String getDelDesc()
      {
        return this.V;
      }
      
      public String getDelUrl()
      {
        return this.T;
      }
      
      public int getDiscountAmount()
      {
        return this.x;
      }
      
      public String getMerchantUrl()
      {
        return this.Z;
      }
      
      public String getOpAddress()
      {
        return this.P;
      }
      
      public int getOpMobile()
      {
        return this.p;
      }
      
      public String getOpUid()
      {
        return this.n;
      }
      
      public Operate getOperate()
      {
        return this.R;
      }
      
      public Order_add getOrderAdd()
      {
        return this.L;
      }
      
      public String getOrderNo()
      {
        return this.b;
      }
      
      public String getOrderSourceUrl()
      {
        return this.N;
      }
      
      public String getOrderTitle()
      {
        return this.j;
      }
      
      public int getPayAmount()
      {
        return this.z;
      }
      
      public String getPhotoUrl()
      {
        return this.J;
      }
      
      public int getReturnAmount()
      {
        return this.B;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasOrderNo()) {
          i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getOrderNo());
        }
        int i1 = i2;
        if (hasTpl()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getTpl());
        }
        i2 = i1;
        if (hasTplTitle()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getTplTitle());
        }
        i1 = i2;
        if (hasTplIcon()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getTplIcon());
        }
        i2 = i1;
        if (hasOrderTitle()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getOrderTitle());
        }
        i1 = i2;
        if (hasCuid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getCuid());
        }
        i2 = i1;
        if (hasOpUid()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getOpUid());
        }
        i1 = i2;
        if (hasOpMobile()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getOpMobile());
        }
        i2 = i1;
        if (hasTplStatus()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getTplStatus());
        }
        i1 = i2;
        if (hasCreateTime()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getCreateTime());
        }
        i2 = i1;
        if (hasTotalAmount()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getTotalAmount());
        }
        i1 = i2;
        if (hasDiscountAmount()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getDiscountAmount());
        }
        i2 = i1;
        if (hasPayAmount()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(13, getPayAmount());
        }
        i1 = i2;
        if (hasReturnAmount()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(14, getReturnAmount());
        }
        i2 = i1;
        if (hasCoDetailAmount()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(15, getCoDetailAmount());
        }
        i1 = i2;
        if (hasCoDetailType()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getCoDetailType());
        }
        i2 = i1;
        if (hasCatId()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(17, getCatId());
        }
        i1 = i2;
        if (hasPhotoUrl()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getPhotoUrl());
        }
        i2 = i1;
        if (hasOrderAdd()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(19, getOrderAdd());
        }
        i1 = i2;
        if (hasOrderSourceUrl()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(20, getOrderSourceUrl());
        }
        i2 = i1;
        if (hasOpAddress()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(21, getOpAddress());
        }
        i1 = i2;
        if (hasOperate()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(22, getOperate());
        }
        i2 = i1;
        if (hasDelUrl()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(23, getDelUrl());
        }
        i1 = i2;
        if (hasDelDesc()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(24, getDelDesc());
        }
        i2 = i1;
        if (hasComposeText()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(25, getComposeText());
        }
        i1 = i2;
        if (hasMerchantUrl()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(26, getMerchantUrl());
        }
        this.aa = i1;
        return i1;
      }
      
      public int getTotalAmount()
      {
        return this.v;
      }
      
      public int getTpl()
      {
        return this.d;
      }
      
      public String getTplIcon()
      {
        return this.h;
      }
      
      public String getTplStatus()
      {
        return this.r;
      }
      
      public String getTplTitle()
      {
        return this.f;
      }
      
      public boolean hasCatId()
      {
        return this.G;
      }
      
      public boolean hasCoDetailAmount()
      {
        return this.C;
      }
      
      public boolean hasCoDetailType()
      {
        return this.E;
      }
      
      public boolean hasComposeText()
      {
        return this.W;
      }
      
      public boolean hasCreateTime()
      {
        return this.s;
      }
      
      public boolean hasCuid()
      {
        return this.k;
      }
      
      public boolean hasDelDesc()
      {
        return this.U;
      }
      
      public boolean hasDelUrl()
      {
        return this.S;
      }
      
      public boolean hasDiscountAmount()
      {
        return this.w;
      }
      
      public boolean hasMerchantUrl()
      {
        return this.Y;
      }
      
      public boolean hasOpAddress()
      {
        return this.O;
      }
      
      public boolean hasOpMobile()
      {
        return this.o;
      }
      
      public boolean hasOpUid()
      {
        return this.m;
      }
      
      public boolean hasOperate()
      {
        return this.Q;
      }
      
      public boolean hasOrderAdd()
      {
        return this.K;
      }
      
      public boolean hasOrderNo()
      {
        return this.a;
      }
      
      public boolean hasOrderSourceUrl()
      {
        return this.M;
      }
      
      public boolean hasOrderTitle()
      {
        return this.i;
      }
      
      public boolean hasPayAmount()
      {
        return this.y;
      }
      
      public boolean hasPhotoUrl()
      {
        return this.I;
      }
      
      public boolean hasReturnAmount()
      {
        return this.A;
      }
      
      public boolean hasTotalAmount()
      {
        return this.u;
      }
      
      public boolean hasTpl()
      {
        return this.c;
      }
      
      public boolean hasTplIcon()
      {
        return this.g;
      }
      
      public boolean hasTplStatus()
      {
        return this.q;
      }
      
      public boolean hasTplTitle()
      {
        return this.e;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Lists mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setOrderNo(paramCodedInputStreamMicro.readString());
            break;
          case 16: 
            setTpl(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            setTplTitle(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setTplIcon(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setOrderTitle(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setCuid(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setOpUid(paramCodedInputStreamMicro.readString());
            break;
          case 64: 
            setOpMobile(paramCodedInputStreamMicro.readInt32());
            break;
          case 74: 
            setTplStatus(paramCodedInputStreamMicro.readString());
            break;
          case 80: 
            setCreateTime(paramCodedInputStreamMicro.readInt32());
            break;
          case 88: 
            setTotalAmount(paramCodedInputStreamMicro.readInt32());
            break;
          case 96: 
            setDiscountAmount(paramCodedInputStreamMicro.readInt32());
            break;
          case 104: 
            setPayAmount(paramCodedInputStreamMicro.readInt32());
            break;
          case 112: 
            setReturnAmount(paramCodedInputStreamMicro.readInt32());
            break;
          case 120: 
            setCoDetailAmount(paramCodedInputStreamMicro.readInt32());
            break;
          case 130: 
            setCoDetailType(paramCodedInputStreamMicro.readString());
            break;
          case 136: 
            setCatId(paramCodedInputStreamMicro.readInt32());
            break;
          case 146: 
            setPhotoUrl(paramCodedInputStreamMicro.readString());
            break;
          case 154: 
            localObject = new Order_add();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setOrderAdd((Order_add)localObject);
            break;
          case 162: 
            setOrderSourceUrl(paramCodedInputStreamMicro.readString());
            break;
          case 170: 
            setOpAddress(paramCodedInputStreamMicro.readString());
            break;
          case 178: 
            localObject = new Operate();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setOperate((Operate)localObject);
            break;
          case 186: 
            setDelUrl(paramCodedInputStreamMicro.readString());
            break;
          case 194: 
            setDelDesc(paramCodedInputStreamMicro.readString());
            break;
          case 202: 
            setComposeText(paramCodedInputStreamMicro.readString());
            break;
          case 210: 
            setMerchantUrl(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Lists setCatId(int paramInt)
      {
        this.G = true;
        this.H = paramInt;
        return this;
      }
      
      public Lists setCoDetailAmount(int paramInt)
      {
        this.C = true;
        this.D = paramInt;
        return this;
      }
      
      public Lists setCoDetailType(String paramString)
      {
        this.E = true;
        this.F = paramString;
        return this;
      }
      
      public Lists setComposeText(String paramString)
      {
        this.W = true;
        this.X = paramString;
        return this;
      }
      
      public Lists setCreateTime(int paramInt)
      {
        this.s = true;
        this.t = paramInt;
        return this;
      }
      
      public Lists setCuid(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public Lists setDelDesc(String paramString)
      {
        this.U = true;
        this.V = paramString;
        return this;
      }
      
      public Lists setDelUrl(String paramString)
      {
        this.S = true;
        this.T = paramString;
        return this;
      }
      
      public Lists setDiscountAmount(int paramInt)
      {
        this.w = true;
        this.x = paramInt;
        return this;
      }
      
      public Lists setMerchantUrl(String paramString)
      {
        this.Y = true;
        this.Z = paramString;
        return this;
      }
      
      public Lists setOpAddress(String paramString)
      {
        this.O = true;
        this.P = paramString;
        return this;
      }
      
      public Lists setOpMobile(int paramInt)
      {
        this.o = true;
        this.p = paramInt;
        return this;
      }
      
      public Lists setOpUid(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public Lists setOperate(Operate paramOperate)
      {
        if (paramOperate == null) {
          return clearOperate();
        }
        this.Q = true;
        this.R = paramOperate;
        return this;
      }
      
      public Lists setOrderAdd(Order_add paramOrder_add)
      {
        if (paramOrder_add == null) {
          return clearOrderAdd();
        }
        this.K = true;
        this.L = paramOrder_add;
        return this;
      }
      
      public Lists setOrderNo(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Lists setOrderSourceUrl(String paramString)
      {
        this.M = true;
        this.N = paramString;
        return this;
      }
      
      public Lists setOrderTitle(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public Lists setPayAmount(int paramInt)
      {
        this.y = true;
        this.z = paramInt;
        return this;
      }
      
      public Lists setPhotoUrl(String paramString)
      {
        this.I = true;
        this.J = paramString;
        return this;
      }
      
      public Lists setReturnAmount(int paramInt)
      {
        this.A = true;
        this.B = paramInt;
        return this;
      }
      
      public Lists setTotalAmount(int paramInt)
      {
        this.u = true;
        this.v = paramInt;
        return this;
      }
      
      public Lists setTpl(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public Lists setTplIcon(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Lists setTplStatus(String paramString)
      {
        this.q = true;
        this.r = paramString;
        return this;
      }
      
      public Lists setTplTitle(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasOrderNo()) {
          paramCodedOutputStreamMicro.writeString(1, getOrderNo());
        }
        if (hasTpl()) {
          paramCodedOutputStreamMicro.writeInt32(2, getTpl());
        }
        if (hasTplTitle()) {
          paramCodedOutputStreamMicro.writeString(3, getTplTitle());
        }
        if (hasTplIcon()) {
          paramCodedOutputStreamMicro.writeString(4, getTplIcon());
        }
        if (hasOrderTitle()) {
          paramCodedOutputStreamMicro.writeString(5, getOrderTitle());
        }
        if (hasCuid()) {
          paramCodedOutputStreamMicro.writeString(6, getCuid());
        }
        if (hasOpUid()) {
          paramCodedOutputStreamMicro.writeString(7, getOpUid());
        }
        if (hasOpMobile()) {
          paramCodedOutputStreamMicro.writeInt32(8, getOpMobile());
        }
        if (hasTplStatus()) {
          paramCodedOutputStreamMicro.writeString(9, getTplStatus());
        }
        if (hasCreateTime()) {
          paramCodedOutputStreamMicro.writeInt32(10, getCreateTime());
        }
        if (hasTotalAmount()) {
          paramCodedOutputStreamMicro.writeInt32(11, getTotalAmount());
        }
        if (hasDiscountAmount()) {
          paramCodedOutputStreamMicro.writeInt32(12, getDiscountAmount());
        }
        if (hasPayAmount()) {
          paramCodedOutputStreamMicro.writeInt32(13, getPayAmount());
        }
        if (hasReturnAmount()) {
          paramCodedOutputStreamMicro.writeInt32(14, getReturnAmount());
        }
        if (hasCoDetailAmount()) {
          paramCodedOutputStreamMicro.writeInt32(15, getCoDetailAmount());
        }
        if (hasCoDetailType()) {
          paramCodedOutputStreamMicro.writeString(16, getCoDetailType());
        }
        if (hasCatId()) {
          paramCodedOutputStreamMicro.writeInt32(17, getCatId());
        }
        if (hasPhotoUrl()) {
          paramCodedOutputStreamMicro.writeString(18, getPhotoUrl());
        }
        if (hasOrderAdd()) {
          paramCodedOutputStreamMicro.writeMessage(19, getOrderAdd());
        }
        if (hasOrderSourceUrl()) {
          paramCodedOutputStreamMicro.writeString(20, getOrderSourceUrl());
        }
        if (hasOpAddress()) {
          paramCodedOutputStreamMicro.writeString(21, getOpAddress());
        }
        if (hasOperate()) {
          paramCodedOutputStreamMicro.writeMessage(22, getOperate());
        }
        if (hasDelUrl()) {
          paramCodedOutputStreamMicro.writeString(23, getDelUrl());
        }
        if (hasDelDesc()) {
          paramCodedOutputStreamMicro.writeString(24, getDelDesc());
        }
        if (hasComposeText()) {
          paramCodedOutputStreamMicro.writeString(25, getComposeText());
        }
        if (hasMerchantUrl()) {
          paramCodedOutputStreamMicro.writeString(26, getMerchantUrl());
        }
      }
      
      public static final class Operate
        extends MessageMicro
      {
        public static final int A_FIELD_NUMBER = 1;
        public static final int B_FIELD_NUMBER = 2;
        private boolean a;
        private Action b = null;
        private boolean c;
        private Action d = null;
        private int e = -1;
        
        public static Operate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Operate().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Operate parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Operate)new Operate().mergeFrom(paramArrayOfByte);
        }
        
        public final Operate clear()
        {
          clearA();
          clearB();
          this.e = -1;
          return this;
        }
        
        public Operate clearA()
        {
          this.a = false;
          this.b = null;
          return this;
        }
        
        public Operate clearB()
        {
          this.c = false;
          this.d = null;
          return this;
        }
        
        public Action getA()
        {
          return this.b;
        }
        
        public Action getB()
        {
          return this.d;
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
          if (hasA()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getA());
          }
          int j = i;
          if (hasB()) {
            j = i + CodedOutputStreamMicro.computeMessageSize(2, getB());
          }
          this.e = j;
          return j;
        }
        
        public boolean hasA()
        {
          return this.a;
        }
        
        public boolean hasB()
        {
          return this.c;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Operate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          for (;;)
          {
            int i = paramCodedInputStreamMicro.readTag();
            Action localAction;
            switch (i)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
              break;
            case 0: 
              return this;
            case 10: 
              localAction = new Action();
              paramCodedInputStreamMicro.readMessage(localAction);
              setA(localAction);
              break;
            case 18: 
              localAction = new Action();
              paramCodedInputStreamMicro.readMessage(localAction);
              setB(localAction);
            }
          }
        }
        
        public Operate setA(Action paramAction)
        {
          if (paramAction == null) {
            return clearA();
          }
          this.a = true;
          this.b = paramAction;
          return this;
        }
        
        public Operate setB(Action paramAction)
        {
          if (paramAction == null) {
            return clearB();
          }
          this.c = true;
          this.d = paramAction;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasA()) {
            paramCodedOutputStreamMicro.writeMessage(1, getA());
          }
          if (hasB()) {
            paramCodedOutputStreamMicro.writeMessage(2, getB());
          }
        }
        
        public static final class Action
          extends MessageMicro
        {
          public static final int TITLE_FIELD_NUMBER = 2;
          public static final int URL_FIELD_NUMBER = 1;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private int e = -1;
          
          public static Action parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Action().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Action parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Action)new Action().mergeFrom(paramArrayOfByte);
          }
          
          public final Action clear()
          {
            clearUrl();
            clearTitle();
            this.e = -1;
            return this;
          }
          
          public Action clearTitle()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public Action clearUrl()
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
            if (hasUrl()) {
              i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
            }
            int j = i;
            if (hasTitle()) {
              j = i + CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            this.e = j;
            return j;
          }
          
          public String getTitle()
          {
            return this.d;
          }
          
          public String getUrl()
          {
            return this.b;
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
          
          public Action mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setUrl(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setTitle(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Action setTitle(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public Action setUrl(String paramString)
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
          }
        }
      }
      
      public static final class Order_add
        extends MessageMicro
      {
        public static final int A_FIELD_NUMBER = 1;
        public static final int B_FIELD_NUMBER = 2;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private int e = -1;
        
        public static Order_add parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Order_add().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Order_add parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Order_add)new Order_add().mergeFrom(paramArrayOfByte);
        }
        
        public final Order_add clear()
        {
          clearA();
          clearB();
          this.e = -1;
          return this;
        }
        
        public Order_add clearA()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public Order_add clearB()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public String getA()
        {
          return this.b;
        }
        
        public String getB()
        {
          return this.d;
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
          if (hasA()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getA());
          }
          int j = i;
          if (hasB()) {
            j = i + CodedOutputStreamMicro.computeStringSize(2, getB());
          }
          this.e = j;
          return j;
        }
        
        public boolean hasA()
        {
          return this.a;
        }
        
        public boolean hasB()
        {
          return this.c;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Order_add mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setA(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setB(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Order_add setA(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public Order_add setB(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasA()) {
            paramCodedOutputStreamMicro.writeString(1, getA());
          }
          if (hasB()) {
            paramCodedOutputStreamMicro.writeString(2, getB());
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Orderlists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */