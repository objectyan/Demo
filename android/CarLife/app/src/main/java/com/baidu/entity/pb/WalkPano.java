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

public final class WalkPano
  extends MessageMicro
{
  public static final int JPEG_FIELD_NUMBER = 2;
  public static final int LINKS_FIELD_NUMBER = 1;
  public static final int OPTION_FIELD_NUMBER = 3;
  private List<Links> a = Collections.emptyList();
  private boolean b;
  private Option c = null;
  private boolean d;
  private String e = "";
  private int f = -1;
  
  public static WalkPano parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new WalkPano().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static WalkPano parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (WalkPano)new WalkPano().mergeFrom(paramArrayOfByte);
  }
  
  public WalkPano addLinks(Links paramLinks)
  {
    if (paramLinks == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramLinks);
    return this;
  }
  
  public final WalkPano clear()
  {
    clearLinks();
    clearOption();
    clearJpeg();
    this.f = -1;
    return this;
  }
  
  public WalkPano clearJpeg()
  {
    this.d = false;
    this.e = "";
    return this;
  }
  
  public WalkPano clearLinks()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public WalkPano clearOption()
  {
    this.b = false;
    this.c = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.f < 0) {
      getSerializedSize();
    }
    return this.f;
  }
  
  public String getJpeg()
  {
    return this.e;
  }
  
  public Links getLinks(int paramInt)
  {
    return (Links)this.a.get(paramInt);
  }
  
  public int getLinksCount()
  {
    return this.a.size();
  }
  
  public List<Links> getLinksList()
  {
    return this.a;
  }
  
  public Option getOption()
  {
    return this.c;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getLinksList().iterator();
    for (int j = 0; localIterator.hasNext(); j = CodedOutputStreamMicro.computeMessageSize(1, (Links)localIterator.next()) + j) {}
    int i = j;
    if (hasJpeg()) {
      i = j + CodedOutputStreamMicro.computeStringSize(2, getJpeg());
    }
    j = i;
    if (hasOption()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(3, getOption());
    }
    this.f = j;
    return j;
  }
  
  public boolean hasJpeg()
  {
    return this.d;
  }
  
  public boolean hasOption()
  {
    return this.b;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public WalkPano mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Links();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addLinks((Links)localObject);
        break;
      case 18: 
        setJpeg(paramCodedInputStreamMicro.readString());
        break;
      case 26: 
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
      }
    }
  }
  
  public WalkPano setJpeg(String paramString)
  {
    this.d = true;
    this.e = paramString;
    return this;
  }
  
  public WalkPano setLinks(int paramInt, Links paramLinks)
  {
    if (paramLinks == null) {
      return this;
    }
    this.a.set(paramInt, paramLinks);
    return this;
  }
  
  public WalkPano setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.b = true;
    this.c = paramOption;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getLinksList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Links)localIterator.next());
    }
    if (hasJpeg()) {
      paramCodedOutputStreamMicro.writeString(2, getJpeg());
    }
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(3, getOption());
    }
  }
  
  public static final class Links
    extends MessageMicro
  {
    public static final int LINK_FIELD_NUMBER = 1;
    public static final int LINK_ID_FIELD_NUMBER = 2;
    private List<Link> a = Collections.emptyList();
    private boolean b;
    private String c = "";
    private int d = -1;
    
    public static Links parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Links().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Links parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Links)new Links().mergeFrom(paramArrayOfByte);
    }
    
    public Links addLink(Link paramLink)
    {
      if (paramLink == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramLink);
      return this;
    }
    
    public final Links clear()
    {
      clearLink();
      clearLinkId();
      this.d = -1;
      return this;
    }
    
    public Links clearLink()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Links clearLinkId()
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
    
    public Link getLink(int paramInt)
    {
      return (Link)this.a.get(paramInt);
    }
    
    public int getLinkCount()
    {
      return this.a.size();
    }
    
    public String getLinkId()
    {
      return this.c;
    }
    
    public List<Link> getLinkList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getLinkList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Link)localIterator.next()) + i) {}
      int j = i;
      if (hasLinkId()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getLinkId());
      }
      this.d = j;
      return j;
    }
    
    public boolean hasLinkId()
    {
      return this.b;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Links mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          Link localLink = new Link();
          paramCodedInputStreamMicro.readMessage(localLink);
          addLink(localLink);
          break;
        case 18: 
          setLinkId(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Links setLink(int paramInt, Link paramLink)
    {
      if (paramLink == null) {
        return this;
      }
      this.a.set(paramInt, paramLink);
      return this;
    }
    
    public Links setLinkId(String paramString)
    {
      this.b = true;
      this.c = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getLinkList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Link)localIterator.next());
      }
      if (hasLinkId()) {
        paramCodedOutputStreamMicro.writeString(2, getLinkId());
      }
    }
    
    public static final class Link
      extends MessageMicro
    {
      public static final int PID_FIELD_NUMBER = 1;
      public static final int RX_FIELD_NUMBER = 2;
      public static final int RY_FIELD_NUMBER = 3;
      public static final int X_FIELD_NUMBER = 4;
      public static final int Y_FIELD_NUMBER = 5;
      private boolean a;
      private String b = "";
      private boolean c;
      private int d = 0;
      private boolean e;
      private int f = 0;
      private boolean g;
      private int h = 0;
      private boolean i;
      private int j = 0;
      private int k = -1;
      
      public static Link parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Link().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Link parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Link)new Link().mergeFrom(paramArrayOfByte);
      }
      
      public final Link clear()
      {
        clearPid();
        clearRx();
        clearRy();
        clearX();
        clearY();
        this.k = -1;
        return this;
      }
      
      public Link clearPid()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Link clearRx()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public Link clearRy()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public Link clearX()
      {
        this.g = false;
        this.h = 0;
        return this;
      }
      
      public Link clearY()
      {
        this.i = false;
        this.j = 0;
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.k < 0) {
          getSerializedSize();
        }
        return this.k;
      }
      
      public String getPid()
      {
        return this.b;
      }
      
      public int getRx()
      {
        return this.d;
      }
      
      public int getRy()
      {
        return this.f;
      }
      
      public int getSerializedSize()
      {
        int n = 0;
        if (hasPid()) {
          n = 0 + CodedOutputStreamMicro.computeStringSize(1, getPid());
        }
        int m = n;
        if (hasRx()) {
          m = n + CodedOutputStreamMicro.computeInt32Size(2, getRx());
        }
        n = m;
        if (hasRy()) {
          n = m + CodedOutputStreamMicro.computeInt32Size(3, getRy());
        }
        m = n;
        if (hasX()) {
          m = n + CodedOutputStreamMicro.computeInt32Size(4, getX());
        }
        n = m;
        if (hasY()) {
          n = m + CodedOutputStreamMicro.computeInt32Size(5, getY());
        }
        this.k = n;
        return n;
      }
      
      public int getX()
      {
        return this.h;
      }
      
      public int getY()
      {
        return this.j;
      }
      
      public boolean hasPid()
      {
        return this.a;
      }
      
      public boolean hasRx()
      {
        return this.c;
      }
      
      public boolean hasRy()
      {
        return this.e;
      }
      
      public boolean hasX()
      {
        return this.g;
      }
      
      public boolean hasY()
      {
        return this.i;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Link mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setPid(paramCodedInputStreamMicro.readString());
            break;
          case 16: 
            setRx(paramCodedInputStreamMicro.readInt32());
            break;
          case 24: 
            setRy(paramCodedInputStreamMicro.readInt32());
            break;
          case 32: 
            setX(paramCodedInputStreamMicro.readInt32());
            break;
          case 40: 
            setY(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public Link setPid(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Link setRx(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public Link setRy(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public Link setX(int paramInt)
      {
        this.g = true;
        this.h = paramInt;
        return this;
      }
      
      public Link setY(int paramInt)
      {
        this.i = true;
        this.j = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasPid()) {
          paramCodedOutputStreamMicro.writeString(1, getPid());
        }
        if (hasRx()) {
          paramCodedOutputStreamMicro.writeInt32(2, getRx());
        }
        if (hasRy()) {
          paramCodedOutputStreamMicro.writeInt32(3, getRy());
        }
        if (hasX()) {
          paramCodedOutputStreamMicro.writeInt32(4, getX());
        }
        if (hasY()) {
          paramCodedOutputStreamMicro.writeInt32(5, getY());
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int HAS_PANO_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 3;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private int g = -1;
    
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
      clearError();
      clearHasPano();
      clearType();
      this.g = -1;
      return this;
    }
    
    public Option clearError()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Option clearHasPano()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Option clearType()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public int getError()
    {
      return this.b;
    }
    
    public int getHasPano()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasError()) {
        j = 0 + CodedOutputStreamMicro.computeSInt32Size(1, getError());
      }
      int i = j;
      if (hasHasPano()) {
        i = j + CodedOutputStreamMicro.computeInt32Size(2, getHasPano());
      }
      j = i;
      if (hasType()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getType());
      }
      this.g = j;
      return j;
    }
    
    public int getType()
    {
      return this.f;
    }
    
    public boolean hasError()
    {
      return this.a;
    }
    
    public boolean hasHasPano()
    {
      return this.c;
    }
    
    public boolean hasType()
    {
      return this.e;
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
          setError(paramCodedInputStreamMicro.readSInt32());
          break;
        case 16: 
          setHasPano(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setType(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setError(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Option setHasPano(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Option setType(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasError()) {
        paramCodedOutputStreamMicro.writeSInt32(1, getError());
      }
      if (hasHasPano()) {
        paramCodedOutputStreamMicro.writeInt32(2, getHasPano());
      }
      if (hasType()) {
        paramCodedOutputStreamMicro.writeInt32(3, getType());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/WalkPano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */