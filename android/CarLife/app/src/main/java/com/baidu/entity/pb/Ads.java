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

public final class Ads
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private List<Content> c = Collections.emptyList();
  private int d = -1;
  
  public static Ads parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Ads().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Ads parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Ads)new Ads().mergeFrom(paramArrayOfByte);
  }
  
  public Ads addContent(Content paramContent)
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
  
  public final Ads clear()
  {
    clearOption();
    clearContent();
    this.d = -1;
    return this;
  }
  
  public Ads clearContent()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public Ads clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.d < 0) {
      getSerializedSize();
    }
    return this.d;
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
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      i = CodedOutputStreamMicro.computeMessageSize(2, (Content)localIterator.next()) + i;
    }
    this.d = i;
    return i;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Ads mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        addContent((Content)localObject);
      }
    }
  }
  
  public Ads setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.c.set(paramInt, paramContent);
    return this;
  }
  
  public Ads setOption(Option paramOption)
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
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (Content)localIterator.next());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int CTRL_MODE_FIELD_NUMBER = 9;
    public static final int DATA_FIELD_NUMBER = 2;
    public static final int DAY_TIMES_FIELD_NUMBER = 10;
    public static final int END_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 6;
    public static final int INTVAL_FIELD_NUMBER = 3;
    public static final int ORDER_FIELD_NUMBER = 8;
    public static final int START_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int UPDATETIME_FIELD_NUMBER = 7;
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
    private boolean m;
    private int n = 0;
    private boolean o;
    private int p = 0;
    private boolean q;
    private String r = "";
    private boolean s;
    private int t = 0;
    private int u = -1;
    
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
      clearType();
      clearData();
      clearIntval();
      clearStart();
      clearEnd();
      clearId();
      clearUpdatetime();
      clearOrder();
      clearCtrlMode();
      clearDayTimes();
      this.u = -1;
      return this;
    }
    
    public Content clearCtrlMode()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Content clearData()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Content clearDayTimes()
    {
      this.s = false;
      this.t = 0;
      return this;
    }
    
    public Content clearEnd()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public Content clearId()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public Content clearIntval()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Content clearOrder()
    {
      this.o = false;
      this.p = 0;
      return this;
    }
    
    public Content clearStart()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Content clearType()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearUpdatetime()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.u < 0) {
        getSerializedSize();
      }
      return this.u;
    }
    
    public String getCtrlMode()
    {
      return this.r;
    }
    
    public String getData()
    {
      return this.d;
    }
    
    public int getDayTimes()
    {
      return this.t;
    }
    
    public int getEnd()
    {
      return this.j;
    }
    
    public int getId()
    {
      return this.l;
    }
    
    public int getIntval()
    {
      return this.f;
    }
    
    public int getOrder()
    {
      return this.p;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasType()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getType());
      }
      int i1 = i2;
      if (hasData()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getData());
      }
      i2 = i1;
      if (hasIntval()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getIntval());
      }
      i1 = i2;
      if (hasStart()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getStart());
      }
      i2 = i1;
      if (hasEnd()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getEnd());
      }
      i1 = i2;
      if (hasId()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getId());
      }
      i2 = i1;
      if (hasUpdatetime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getUpdatetime());
      }
      i1 = i2;
      if (hasOrder()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getOrder());
      }
      i2 = i1;
      if (hasCtrlMode()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getCtrlMode());
      }
      i1 = i2;
      if (hasDayTimes()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getDayTimes());
      }
      this.u = i1;
      return i1;
    }
    
    public int getStart()
    {
      return this.h;
    }
    
    public String getType()
    {
      return this.b;
    }
    
    public int getUpdatetime()
    {
      return this.n;
    }
    
    public boolean hasCtrlMode()
    {
      return this.q;
    }
    
    public boolean hasData()
    {
      return this.c;
    }
    
    public boolean hasDayTimes()
    {
      return this.s;
    }
    
    public boolean hasEnd()
    {
      return this.i;
    }
    
    public boolean hasId()
    {
      return this.k;
    }
    
    public boolean hasIntval()
    {
      return this.e;
    }
    
    public boolean hasOrder()
    {
      return this.o;
    }
    
    public boolean hasStart()
    {
      return this.g;
    }
    
    public boolean hasType()
    {
      return this.a;
    }
    
    public boolean hasUpdatetime()
    {
      return this.m;
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
          setType(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setData(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setIntval(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setStart(paramCodedInputStreamMicro.readInt32());
          break;
        case 40: 
          setEnd(paramCodedInputStreamMicro.readInt32());
          break;
        case 48: 
          setId(paramCodedInputStreamMicro.readInt32());
          break;
        case 56: 
          setUpdatetime(paramCodedInputStreamMicro.readInt32());
          break;
        case 64: 
          setOrder(paramCodedInputStreamMicro.readInt32());
          break;
        case 74: 
          setCtrlMode(paramCodedInputStreamMicro.readString());
          break;
        case 80: 
          setDayTimes(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Content setCtrlMode(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Content setData(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Content setDayTimes(int paramInt)
    {
      this.s = true;
      this.t = paramInt;
      return this;
    }
    
    public Content setEnd(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public Content setId(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public Content setIntval(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Content setOrder(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public Content setStart(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Content setType(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setUpdatetime(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasType()) {
        paramCodedOutputStreamMicro.writeString(1, getType());
      }
      if (hasData()) {
        paramCodedOutputStreamMicro.writeString(2, getData());
      }
      if (hasIntval()) {
        paramCodedOutputStreamMicro.writeInt32(3, getIntval());
      }
      if (hasStart()) {
        paramCodedOutputStreamMicro.writeInt32(4, getStart());
      }
      if (hasEnd()) {
        paramCodedOutputStreamMicro.writeInt32(5, getEnd());
      }
      if (hasId()) {
        paramCodedOutputStreamMicro.writeInt32(6, getId());
      }
      if (hasUpdatetime()) {
        paramCodedOutputStreamMicro.writeInt32(7, getUpdatetime());
      }
      if (hasOrder()) {
        paramCodedOutputStreamMicro.writeInt32(8, getOrder());
      }
      if (hasCtrlMode()) {
        paramCodedOutputStreamMicro.writeString(9, getCtrlMode());
      }
      if (hasDayTimes()) {
        paramCodedOutputStreamMicro.writeInt32(10, getDayTimes());
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int CHECKCODE_FIELD_NUMBER = 2;
    public static final int LASTTIME_FIELD_NUMBER = 1;
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
      clearLasttime();
      clearCheckcode();
      this.e = -1;
      return this;
    }
    
    public Option clearCheckcode()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Option clearLasttime()
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
    
    public String getCheckcode()
    {
      return this.d;
    }
    
    public int getLasttime()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasLasttime()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getLasttime());
      }
      int j = i;
      if (hasCheckcode()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getCheckcode());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasCheckcode()
    {
      return this.c;
    }
    
    public boolean hasLasttime()
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
          setLasttime(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setCheckcode(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Option setCheckcode(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Option setLasttime(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasLasttime()) {
        paramCodedOutputStreamMicro.writeInt32(1, getLasttime());
      }
      if (hasCheckcode()) {
        paramCodedOutputStreamMicro.writeString(2, getCheckcode());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Ads.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */