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

public final class LiveList
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
  
  public static LiveList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new LiveList().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static LiveList parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (LiveList)new LiveList().mergeFrom(paramArrayOfByte);
  }
  
  public final LiveList clear()
  {
    clearError();
    clearMsg();
    clearData();
    this.g = -1;
    return this;
  }
  
  public LiveList clearData()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public LiveList clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public LiveList clearMsg()
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
  
  public LiveList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
  
  public LiveList setData(Data paramData)
  {
    if (paramData == null) {
      return clearData();
    }
    this.e = true;
    this.f = paramData;
    return this;
  }
  
  public LiveList setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public LiveList setMsg(String paramString)
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
    public static final int PLAINS_FIELD_NUMBER = 2;
    public static final int SPECIALS_FIELD_NUMBER = 1;
    private List<Content> a = Collections.emptyList();
    private List<Content> b = Collections.emptyList();
    private int c = -1;
    
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
    
    public Data addPlains(Content paramContent)
    {
      if (paramContent == null) {
        return this;
      }
      if (this.b.isEmpty()) {
        this.b = new ArrayList();
      }
      this.b.add(paramContent);
      return this;
    }
    
    public Data addSpecials(Content paramContent)
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
    
    public final Data clear()
    {
      clearSpecials();
      clearPlains();
      this.c = -1;
      return this;
    }
    
    public Data clearPlains()
    {
      this.b = Collections.emptyList();
      return this;
    }
    
    public Data clearSpecials()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.c < 0) {
        getSerializedSize();
      }
      return this.c;
    }
    
    public Content getPlains(int paramInt)
    {
      return (Content)this.b.get(paramInt);
    }
    
    public int getPlainsCount()
    {
      return this.b.size();
    }
    
    public List<Content> getPlainsList()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getSpecialsList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Content)localIterator.next()) + i) {}
      localIterator = getPlainsList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStreamMicro.computeMessageSize(2, (Content)localIterator.next());
      }
      this.c = i;
      return i;
    }
    
    public Content getSpecials(int paramInt)
    {
      return (Content)this.a.get(paramInt);
    }
    
    public int getSpecialsCount()
    {
      return this.a.size();
    }
    
    public List<Content> getSpecialsList()
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
        Content localContent;
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localContent = new Content();
          paramCodedInputStreamMicro.readMessage(localContent);
          addSpecials(localContent);
          break;
        case 18: 
          localContent = new Content();
          paramCodedInputStreamMicro.readMessage(localContent);
          addPlains(localContent);
        }
      }
    }
    
    public Data setPlains(int paramInt, Content paramContent)
    {
      if (paramContent == null) {
        return this;
      }
      this.b.set(paramInt, paramContent);
      return this;
    }
    
    public Data setSpecials(int paramInt, Content paramContent)
    {
      if (paramContent == null) {
        return this;
      }
      this.a.set(paramInt, paramContent);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getSpecialsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Content)localIterator.next());
      }
      localIterator = getPlainsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Content)localIterator.next());
      }
    }
    
    public static final class Content
      extends MessageMicro
    {
      public static final int BIMG_FIELD_NUMBER = 7;
      public static final int DEADLINE_FIELD_NUMBER = 9;
      public static final int DESP_FIELD_NUMBER = 2;
      public static final int IFTHIRD_FIELD_NUMBER = 10;
      public static final int PLANID_FIELD_NUMBER = 4;
      public static final int PRESENT_FIELD_NUMBER = 3;
      public static final int SIMG_FIELD_NUMBER = 8;
      public static final int STATE_FIELD_NUMBER = 6;
      public static final int STATUS_FIELD_NUMBER = 5;
      public static final int THIRDNAME_FIELD_NUMBER = 12;
      public static final int THIRDURL_FIELD_NUMBER = 11;
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
      private int j = 0;
      private boolean k;
      private String l = "";
      private boolean m;
      private String n = "";
      private boolean o;
      private String p = "";
      private boolean q;
      private int r = 0;
      private boolean s;
      private int t = 0;
      private boolean u;
      private String v = "";
      private boolean w;
      private String x = "";
      private int y = -1;
      
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
        clearDesp();
        clearPresent();
        clearPlanid();
        clearStatus();
        clearState();
        clearBimg();
        clearSimg();
        clearDeadline();
        clearIfthird();
        clearThirdurl();
        clearThirdname();
        this.y = -1;
        return this;
      }
      
      public Content clearBimg()
      {
        this.m = false;
        this.n = "";
        return this;
      }
      
      public Content clearDeadline()
      {
        this.q = false;
        this.r = 0;
        return this;
      }
      
      public Content clearDesp()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Content clearIfthird()
      {
        this.s = false;
        this.t = 0;
        return this;
      }
      
      public Content clearPlanid()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Content clearPresent()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Content clearSimg()
      {
        this.o = false;
        this.p = "";
        return this;
      }
      
      public Content clearState()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public Content clearStatus()
      {
        this.i = false;
        this.j = 0;
        return this;
      }
      
      public Content clearThirdname()
      {
        this.w = false;
        this.x = "";
        return this;
      }
      
      public Content clearThirdurl()
      {
        this.u = false;
        this.v = "";
        return this;
      }
      
      public Content clearTitle()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public String getBimg()
      {
        return this.n;
      }
      
      public int getCachedSize()
      {
        if (this.y < 0) {
          getSerializedSize();
        }
        return this.y;
      }
      
      public int getDeadline()
      {
        return this.r;
      }
      
      public String getDesp()
      {
        return this.d;
      }
      
      public int getIfthird()
      {
        return this.t;
      }
      
      public String getPlanid()
      {
        return this.h;
      }
      
      public String getPresent()
      {
        return this.f;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasTitle()) {
          i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
        }
        int i1 = i2;
        if (hasDesp()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getDesp());
        }
        i2 = i1;
        if (hasPresent()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getPresent());
        }
        i1 = i2;
        if (hasPlanid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getPlanid());
        }
        i2 = i1;
        if (hasStatus()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getStatus());
        }
        i1 = i2;
        if (hasState()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getState());
        }
        i2 = i1;
        if (hasBimg()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getBimg());
        }
        i1 = i2;
        if (hasSimg()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getSimg());
        }
        i2 = i1;
        if (hasDeadline()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getDeadline());
        }
        i1 = i2;
        if (hasIfthird()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getIfthird());
        }
        i2 = i1;
        if (hasThirdurl()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getThirdurl());
        }
        i1 = i2;
        if (hasThirdname()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getThirdname());
        }
        this.y = i1;
        return i1;
      }
      
      public String getSimg()
      {
        return this.p;
      }
      
      public String getState()
      {
        return this.l;
      }
      
      public int getStatus()
      {
        return this.j;
      }
      
      public String getThirdname()
      {
        return this.x;
      }
      
      public String getThirdurl()
      {
        return this.v;
      }
      
      public String getTitle()
      {
        return this.b;
      }
      
      public boolean hasBimg()
      {
        return this.m;
      }
      
      public boolean hasDeadline()
      {
        return this.q;
      }
      
      public boolean hasDesp()
      {
        return this.c;
      }
      
      public boolean hasIfthird()
      {
        return this.s;
      }
      
      public boolean hasPlanid()
      {
        return this.g;
      }
      
      public boolean hasPresent()
      {
        return this.e;
      }
      
      public boolean hasSimg()
      {
        return this.o;
      }
      
      public boolean hasState()
      {
        return this.k;
      }
      
      public boolean hasStatus()
      {
        return this.i;
      }
      
      public boolean hasThirdname()
      {
        return this.w;
      }
      
      public boolean hasThirdurl()
      {
        return this.u;
      }
      
      public boolean hasTitle()
      {
        return this.a;
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
            setDesp(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setPresent(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setPlanid(paramCodedInputStreamMicro.readString());
            break;
          case 40: 
            setStatus(paramCodedInputStreamMicro.readInt32());
            break;
          case 50: 
            setState(paramCodedInputStreamMicro.readString());
            break;
          case 58: 
            setBimg(paramCodedInputStreamMicro.readString());
            break;
          case 66: 
            setSimg(paramCodedInputStreamMicro.readString());
            break;
          case 72: 
            setDeadline(paramCodedInputStreamMicro.readInt32());
            break;
          case 80: 
            setIfthird(paramCodedInputStreamMicro.readInt32());
            break;
          case 90: 
            setThirdurl(paramCodedInputStreamMicro.readString());
            break;
          case 98: 
            setThirdname(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Content setBimg(String paramString)
      {
        this.m = true;
        this.n = paramString;
        return this;
      }
      
      public Content setDeadline(int paramInt)
      {
        this.q = true;
        this.r = paramInt;
        return this;
      }
      
      public Content setDesp(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Content setIfthird(int paramInt)
      {
        this.s = true;
        this.t = paramInt;
        return this;
      }
      
      public Content setPlanid(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Content setPresent(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Content setSimg(String paramString)
      {
        this.o = true;
        this.p = paramString;
        return this;
      }
      
      public Content setState(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public Content setStatus(int paramInt)
      {
        this.i = true;
        this.j = paramInt;
        return this;
      }
      
      public Content setThirdname(String paramString)
      {
        this.w = true;
        this.x = paramString;
        return this;
      }
      
      public Content setThirdurl(String paramString)
      {
        this.u = true;
        this.v = paramString;
        return this;
      }
      
      public Content setTitle(String paramString)
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
        if (hasDesp()) {
          paramCodedOutputStreamMicro.writeString(2, getDesp());
        }
        if (hasPresent()) {
          paramCodedOutputStreamMicro.writeString(3, getPresent());
        }
        if (hasPlanid()) {
          paramCodedOutputStreamMicro.writeString(4, getPlanid());
        }
        if (hasStatus()) {
          paramCodedOutputStreamMicro.writeInt32(5, getStatus());
        }
        if (hasState()) {
          paramCodedOutputStreamMicro.writeString(6, getState());
        }
        if (hasBimg()) {
          paramCodedOutputStreamMicro.writeString(7, getBimg());
        }
        if (hasSimg()) {
          paramCodedOutputStreamMicro.writeString(8, getSimg());
        }
        if (hasDeadline()) {
          paramCodedOutputStreamMicro.writeInt32(9, getDeadline());
        }
        if (hasIfthird()) {
          paramCodedOutputStreamMicro.writeInt32(10, getIfthird());
        }
        if (hasThirdurl()) {
          paramCodedOutputStreamMicro.writeString(11, getThirdurl());
        }
        if (hasThirdname()) {
          paramCodedOutputStreamMicro.writeString(12, getThirdname());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/LiveList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */