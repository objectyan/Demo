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

public final class WalkSearch
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 3;
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int OPTION_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private Option d = null;
  private List<Content> e = Collections.emptyList();
  private int f = -1;
  
  public static WalkSearch parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new WalkSearch().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static WalkSearch parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (WalkSearch)new WalkSearch().mergeFrom(paramArrayOfByte);
  }
  
  public WalkSearch addContent(Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(paramContent);
    return this;
  }
  
  public final WalkSearch clear()
  {
    clearError();
    clearOption();
    clearContent();
    this.f = -1;
    return this;
  }
  
  public WalkSearch clearContent()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public WalkSearch clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public WalkSearch clearOption()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.f < 0) {
      getSerializedSize();
    }
    return this.f;
  }
  
  public Content getContent(int paramInt)
  {
    return (Content)this.e.get(paramInt);
  }
  
  public int getContentCount()
  {
    return this.e.size();
  }
  
  public List<Content> getContentList()
  {
    return this.e;
  }
  
  public int getError()
  {
    return this.b;
  }
  
  public Option getOption()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasError()) {
      i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
    }
    int j = i;
    if (hasOption()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(2, getOption());
    }
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      j = CodedOutputStreamMicro.computeMessageSize(3, (Content)localIterator.next()) + j;
    }
    this.f = j;
    return j;
  }
  
  public boolean hasError()
  {
    return this.a;
  }
  
  public boolean hasOption()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public WalkSearch mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 26: 
        localObject = new Content();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addContent((Content)localObject);
      }
    }
  }
  
  public WalkSearch setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.e.set(paramInt, paramContent);
    return this;
  }
  
  public WalkSearch setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public WalkSearch setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.c = true;
    this.d = paramOption;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasError()) {
      paramCodedOutputStreamMicro.writeInt32(1, getError());
    }
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(2, getOption());
    }
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (Content)localIterator.next());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int ADDR_FIELD_NUMBER = 4;
    public static final int DIST2ROUTE_FIELD_NUMBER = 9;
    public static final int DIST2START_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int STREET_ID_FIELD_NUMBER = 5;
    public static final int TEL_FIELD_NUMBER = 6;
    public static final int UID_FIELD_NUMBER = 7;
    public static final int X_FIELD_NUMBER = 2;
    public static final int Y_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
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
    
    public final Content clear()
    {
      clearName();
      clearX();
      clearY();
      clearAddr();
      clearStreetId();
      clearTel();
      clearUid();
      clearDist2Start();
      clearDist2Route();
      this.s = -1;
      return this;
    }
    
    public Content clearAddr()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Content clearDist2Route()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Content clearDist2Start()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public Content clearName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearStreetId()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Content clearTel()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Content clearUid()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Content clearX()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Content clearY()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public String getAddr()
    {
      return this.h;
    }
    
    public int getCachedSize()
    {
      if (this.s < 0) {
        getSerializedSize();
      }
      return this.s;
    }
    
    public String getDist2Route()
    {
      return this.r;
    }
    
    public String getDist2Start()
    {
      return this.p;
    }
    
    public String getName()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasName()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
      }
      int i1 = i2;
      if (hasX()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getX());
      }
      i2 = i1;
      if (hasY()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getY());
      }
      i1 = i2;
      if (hasAddr()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getAddr());
      }
      i2 = i1;
      if (hasStreetId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getStreetId());
      }
      i1 = i2;
      if (hasTel()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getTel());
      }
      i2 = i1;
      if (hasUid()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getUid());
      }
      i1 = i2;
      if (hasDist2Start()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getDist2Start());
      }
      i2 = i1;
      if (hasDist2Route()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getDist2Route());
      }
      this.s = i2;
      return i2;
    }
    
    public String getStreetId()
    {
      return this.j;
    }
    
    public String getTel()
    {
      return this.l;
    }
    
    public String getUid()
    {
      return this.n;
    }
    
    public int getX()
    {
      return this.d;
    }
    
    public int getY()
    {
      return this.f;
    }
    
    public boolean hasAddr()
    {
      return this.g;
    }
    
    public boolean hasDist2Route()
    {
      return this.q;
    }
    
    public boolean hasDist2Start()
    {
      return this.o;
    }
    
    public boolean hasName()
    {
      return this.a;
    }
    
    public boolean hasStreetId()
    {
      return this.i;
    }
    
    public boolean hasTel()
    {
      return this.k;
    }
    
    public boolean hasUid()
    {
      return this.m;
    }
    
    public boolean hasX()
    {
      return this.c;
    }
    
    public boolean hasY()
    {
      return this.e;
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
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setX(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setY(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          setAddr(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setStreetId(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setTel(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setDist2Start(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setDist2Route(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Content setAddr(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Content setDist2Route(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Content setDist2Start(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public Content setName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setStreetId(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Content setTel(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Content setUid(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Content setX(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Content setY(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(1, getName());
      }
      if (hasX()) {
        paramCodedOutputStreamMicro.writeInt32(2, getX());
      }
      if (hasY()) {
        paramCodedOutputStreamMicro.writeInt32(3, getY());
      }
      if (hasAddr()) {
        paramCodedOutputStreamMicro.writeString(4, getAddr());
      }
      if (hasStreetId()) {
        paramCodedOutputStreamMicro.writeString(5, getStreetId());
      }
      if (hasTel()) {
        paramCodedOutputStreamMicro.writeString(6, getTel());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(7, getUid());
      }
      if (hasDist2Start()) {
        paramCodedOutputStreamMicro.writeString(8, getDist2Start());
      }
      if (hasDist2Route()) {
        paramCodedOutputStreamMicro.writeString(9, getDist2Route());
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int TOTAL_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private int c = -1;
    
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
      clearTotal();
      this.c = -1;
      return this;
    }
    
    public Option clearTotal()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.c < 0) {
        getSerializedSize();
      }
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasTotal()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
      }
      this.c = i;
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
          setTotal(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setTotal(int paramInt)
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
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/WalkSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */