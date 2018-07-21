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

public final class IctSchedule
  extends MessageMicro
{
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int LINE_INFO_LIST_FIELD_NUMBER = 2;
  public static final int TICKET_ORDER_INFO_FIELD_NUMBER = 3;
  private boolean a;
  private int b = 0;
  private List<LineInfoList> c = Collections.emptyList();
  private boolean d;
  private TicketOrderInfo e = null;
  private int f = -1;
  
  public static IctSchedule parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new IctSchedule().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static IctSchedule parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (IctSchedule)new IctSchedule().mergeFrom(paramArrayOfByte);
  }
  
  public IctSchedule addLineInfoList(LineInfoList paramLineInfoList)
  {
    if (paramLineInfoList == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramLineInfoList);
    return this;
  }
  
  public final IctSchedule clear()
  {
    clearError();
    clearLineInfoList();
    clearTicketOrderInfo();
    this.f = -1;
    return this;
  }
  
  public IctSchedule clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public IctSchedule clearLineInfoList()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public IctSchedule clearTicketOrderInfo()
  {
    this.d = false;
    this.e = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.f < 0) {
      getSerializedSize();
    }
    return this.f;
  }
  
  public int getError()
  {
    return this.b;
  }
  
  public LineInfoList getLineInfoList(int paramInt)
  {
    return (LineInfoList)this.c.get(paramInt);
  }
  
  public int getLineInfoListCount()
  {
    return this.c.size();
  }
  
  public List<LineInfoList> getLineInfoListList()
  {
    return this.c;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasError()) {
      i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
    }
    Iterator localIterator = getLineInfoListList().iterator();
    while (localIterator.hasNext()) {
      i = CodedOutputStreamMicro.computeMessageSize(2, (LineInfoList)localIterator.next()) + i;
    }
    int j = i;
    if (hasTicketOrderInfo()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(3, getTicketOrderInfo());
    }
    this.f = j;
    return j;
  }
  
  public TicketOrderInfo getTicketOrderInfo()
  {
    return this.e;
  }
  
  public boolean hasError()
  {
    return this.a;
  }
  
  public boolean hasTicketOrderInfo()
  {
    return this.d;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public IctSchedule mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 8: 
        setError(paramCodedInputStreamMicro.readInt32());
        break;
      case 18: 
        localObject = new LineInfoList();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addLineInfoList((LineInfoList)localObject);
        break;
      case 26: 
        localObject = new TicketOrderInfo();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setTicketOrderInfo((TicketOrderInfo)localObject);
      }
    }
  }
  
  public IctSchedule setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public IctSchedule setLineInfoList(int paramInt, LineInfoList paramLineInfoList)
  {
    if (paramLineInfoList == null) {
      return this;
    }
    this.c.set(paramInt, paramLineInfoList);
    return this;
  }
  
  public IctSchedule setTicketOrderInfo(TicketOrderInfo paramTicketOrderInfo)
  {
    if (paramTicketOrderInfo == null) {
      return clearTicketOrderInfo();
    }
    this.d = true;
    this.e = paramTicketOrderInfo;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasError()) {
      paramCodedOutputStreamMicro.writeInt32(1, getError());
    }
    Iterator localIterator = getLineInfoListList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (LineInfoList)localIterator.next());
    }
    if (hasTicketOrderInfo()) {
      paramCodedOutputStreamMicro.writeMessage(3, getTicketOrderInfo());
    }
  }
  
  public static final class LineInfoList
    extends MessageMicro
  {
    public static final int LINE_INFO_FIELD_NUMBER = 1;
    private boolean a;
    private LineInfo b = null;
    private int c = -1;
    
    public static LineInfoList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new LineInfoList().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static LineInfoList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (LineInfoList)new LineInfoList().mergeFrom(paramArrayOfByte);
    }
    
    public final LineInfoList clear()
    {
      clearLineInfo();
      this.c = -1;
      return this;
    }
    
    public LineInfoList clearLineInfo()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.c < 0) {
        getSerializedSize();
      }
      return this.c;
    }
    
    public LineInfo getLineInfo()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasLineInfo()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getLineInfo());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasLineInfo()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public LineInfoList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          LineInfo localLineInfo = new LineInfo();
          paramCodedInputStreamMicro.readMessage(localLineInfo);
          setLineInfo(localLineInfo);
        }
      }
    }
    
    public LineInfoList setLineInfo(LineInfo paramLineInfo)
    {
      if (paramLineInfo == null) {
        return clearLineInfo();
      }
      this.a = true;
      this.b = paramLineInfo;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasLineInfo()) {
        paramCodedOutputStreamMicro.writeMessage(1, getLineInfo());
      }
    }
    
    public static final class LineInfo
      extends MessageMicro
    {
      public static final int FROM_TIME_FIELD_NUMBER = 1;
      public static final int GEO_FIELD_NUMBER = 4;
      public static final int MILEAGE_FIELD_NUMBER = 3;
      public static final int PRICE_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private List<Double> c = Collections.emptyList();
      private boolean d;
      private int e = 0;
      private boolean f;
      private String g = "";
      private int h = -1;
      
      public static LineInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new LineInfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static LineInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (LineInfo)new LineInfo().mergeFrom(paramArrayOfByte);
      }
      
      public LineInfo addPrice(double paramDouble)
      {
        if (this.c.isEmpty()) {
          this.c = new ArrayList();
        }
        this.c.add(Double.valueOf(paramDouble));
        return this;
      }
      
      public final LineInfo clear()
      {
        clearFromTime();
        clearPrice();
        clearMileage();
        clearGeo();
        this.h = -1;
        return this;
      }
      
      public LineInfo clearFromTime()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public LineInfo clearGeo()
      {
        this.f = false;
        this.g = "";
        return this;
      }
      
      public LineInfo clearMileage()
      {
        this.d = false;
        this.e = 0;
        return this;
      }
      
      public LineInfo clearPrice()
      {
        this.c = Collections.emptyList();
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.h < 0) {
          getSerializedSize();
        }
        return this.h;
      }
      
      public String getFromTime()
      {
        return this.b;
      }
      
      public String getGeo()
      {
        return this.g;
      }
      
      public int getMileage()
      {
        return this.e;
      }
      
      public double getPrice(int paramInt)
      {
        return ((Double)this.c.get(paramInt)).doubleValue();
      }
      
      public int getPriceCount()
      {
        return this.c.size();
      }
      
      public List<Double> getPriceList()
      {
        return this.c;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasFromTime()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFromTime());
        }
        int j = i + getPriceList().size() * 8 + getPriceList().size() * 1;
        i = j;
        if (hasMileage()) {
          i = j + CodedOutputStreamMicro.computeInt32Size(3, getMileage());
        }
        j = i;
        if (hasGeo()) {
          j = i + CodedOutputStreamMicro.computeStringSize(4, getGeo());
        }
        this.h = j;
        return j;
      }
      
      public boolean hasFromTime()
      {
        return this.a;
      }
      
      public boolean hasGeo()
      {
        return this.f;
      }
      
      public boolean hasMileage()
      {
        return this.d;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public LineInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setFromTime(paramCodedInputStreamMicro.readString());
            break;
          case 17: 
            addPrice(paramCodedInputStreamMicro.readDouble());
            break;
          case 24: 
            setMileage(paramCodedInputStreamMicro.readInt32());
            break;
          case 34: 
            setGeo(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public LineInfo setFromTime(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public LineInfo setGeo(String paramString)
      {
        this.f = true;
        this.g = paramString;
        return this;
      }
      
      public LineInfo setMileage(int paramInt)
      {
        this.d = true;
        this.e = paramInt;
        return this;
      }
      
      public LineInfo setPrice(int paramInt, double paramDouble)
      {
        this.c.set(paramInt, Double.valueOf(paramDouble));
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasFromTime()) {
          paramCodedOutputStreamMicro.writeString(1, getFromTime());
        }
        Iterator localIterator = getPriceList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeDouble(2, ((Double)localIterator.next()).doubleValue());
        }
        if (hasMileage()) {
          paramCodedOutputStreamMicro.writeInt32(3, getMileage());
        }
        if (hasGeo()) {
          paramCodedOutputStreamMicro.writeString(4, getGeo());
        }
      }
    }
  }
  
  public static final class TicketOrderInfo
    extends MessageMicro
  {
    public static final int IS_SUPPORTED_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static TicketOrderInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TicketOrderInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TicketOrderInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TicketOrderInfo)new TicketOrderInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final TicketOrderInfo clear()
    {
      clearIsSupported();
      clearUrl();
      this.e = -1;
      return this;
    }
    
    public TicketOrderInfo clearIsSupported()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public TicketOrderInfo clearUrl()
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
    
    public int getIsSupported()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasIsSupported()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsSupported());
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
    
    public boolean hasIsSupported()
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
    
    public TicketOrderInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIsSupported(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setUrl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public TicketOrderInfo setIsSupported(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public TicketOrderInfo setUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsSupported()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIsSupported());
      }
      if (hasUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getUrl());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/IctSchedule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */