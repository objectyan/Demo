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

public final class Mrtl
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 1;
  private List<Content> a = Collections.emptyList();
  private int b = -1;
  
  public static Mrtl parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Mrtl().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Mrtl parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Mrtl)new Mrtl().mergeFrom(paramArrayOfByte);
  }
  
  public Mrtl addContent(Content paramContent)
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
  
  public final Mrtl clear()
  {
    clearContent();
    this.b = -1;
    return this;
  }
  
  public Mrtl clearContent()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.b < 0) {
      getSerializedSize();
    }
    return this.b;
  }
  
  public Content getContent(int paramInt)
  {
    return (Content)this.a.get(paramInt);
  }
  
  public int getContentCount()
  {
    return this.a.size();
  }
  
  public List<Content> getContentList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getContentList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Content)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Mrtl mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Content localContent = new Content();
        paramCodedInputStreamMicro.readMessage(localContent);
        addContent(localContent);
      }
    }
  }
  
  public Mrtl setContent(int paramInt, Content paramContent)
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
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Content)localIterator.next());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int LABEL_FIELD_NUMBER = 1;
    public static final int RET_CODE_FIELD_NUMBER = 2;
    public static final int ROUTE_FIELD_NUMBER = 3;
    public static final int TRAFFIC_FIELD_NUMBER = 4;
    private boolean a;
    private Route b = null;
    private boolean c;
    private Traffic d = null;
    private boolean e;
    private String f = "";
    private boolean g;
    private int h = 0;
    private int i = -1;
    
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
      clearRoute();
      clearTraffic();
      clearLabel();
      clearRetCode();
      this.i = -1;
      return this;
    }
    
    public Content clearLabel()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Content clearRetCode()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Content clearRoute()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public Content clearTraffic()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public String getLabel()
    {
      return this.f;
    }
    
    public int getRetCode()
    {
      return this.h;
    }
    
    public Route getRoute()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasLabel()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getLabel());
      }
      int j = k;
      if (hasRetCode()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(2, getRetCode());
      }
      k = j;
      if (hasRoute()) {
        k = j + CodedOutputStreamMicro.computeMessageSize(3, getRoute());
      }
      j = k;
      if (hasTraffic()) {
        j = k + CodedOutputStreamMicro.computeMessageSize(4, getTraffic());
      }
      this.i = j;
      return j;
    }
    
    public Traffic getTraffic()
    {
      return this.d;
    }
    
    public boolean hasLabel()
    {
      return this.e;
    }
    
    public boolean hasRetCode()
    {
      return this.g;
    }
    
    public boolean hasRoute()
    {
      return this.a;
    }
    
    public boolean hasTraffic()
    {
      return this.c;
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
        int j = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (j)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setLabel(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setRetCode(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          localObject = new Route();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setRoute((Route)localObject);
          break;
        case 34: 
          localObject = new Traffic();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTraffic((Traffic)localObject);
        }
      }
    }
    
    public Content setLabel(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Content setRetCode(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Content setRoute(Route paramRoute)
    {
      if (paramRoute == null) {
        return clearRoute();
      }
      this.a = true;
      this.b = paramRoute;
      return this;
    }
    
    public Content setTraffic(Traffic paramTraffic)
    {
      if (paramTraffic == null) {
        return clearTraffic();
      }
      this.c = true;
      this.d = paramTraffic;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasLabel()) {
        paramCodedOutputStreamMicro.writeString(1, getLabel());
      }
      if (hasRetCode()) {
        paramCodedOutputStreamMicro.writeInt32(2, getRetCode());
      }
      if (hasRoute()) {
        paramCodedOutputStreamMicro.writeMessage(3, getRoute());
      }
      if (hasTraffic()) {
        paramCodedOutputStreamMicro.writeMessage(4, getTraffic());
      }
    }
    
    public static final class Route
      extends MessageMicro
    {
      public static final int DISTANCE_FIELD_NUMBER = 1;
      public static final int DURATION_FIELD_NUMBER = 2;
      private boolean a;
      private int b = 0;
      private boolean c;
      private int d = 0;
      private int e = -1;
      
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
        clearDistance();
        clearDuration();
        this.e = -1;
        return this;
      }
      
      public Route clearDistance()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public Route clearDuration()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.e < 0) {
          getSerializedSize();
        }
        return this.e;
      }
      
      public int getDistance()
      {
        return this.b;
      }
      
      public int getDuration()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasDistance()) {
          i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
        }
        int j = i;
        if (hasDuration()) {
          j = i + CodedOutputStreamMicro.computeInt32Size(2, getDuration());
        }
        this.e = j;
        return j;
      }
      
      public boolean hasDistance()
      {
        return this.a;
      }
      
      public boolean hasDuration()
      {
        return this.c;
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
          int i = paramCodedInputStreamMicro.readTag();
          switch (i)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
            break;
          case 0: 
            return this;
          case 8: 
            setDistance(paramCodedInputStreamMicro.readInt32());
            break;
          case 16: 
            setDuration(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public Route setDistance(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public Route setDuration(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDistance()) {
          paramCodedOutputStreamMicro.writeInt32(1, getDistance());
        }
        if (hasDuration()) {
          paramCodedOutputStreamMicro.writeInt32(2, getDuration());
        }
      }
    }
    
    public static final class Traffic
      extends MessageMicro
    {
      public static final int LENGTH_FIELD_NUMBER = 1;
      public static final int STATUS_FIELD_NUMBER = 2;
      private List<Integer> a = Collections.emptyList();
      private List<Integer> b = Collections.emptyList();
      private int c = -1;
      
      public static Traffic parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Traffic().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Traffic parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Traffic)new Traffic().mergeFrom(paramArrayOfByte);
      }
      
      public Traffic addLength(int paramInt)
      {
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public Traffic addStatus(int paramInt)
      {
        if (this.b.isEmpty()) {
          this.b = new ArrayList();
        }
        this.b.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public final Traffic clear()
      {
        clearLength();
        clearStatus();
        this.c = -1;
        return this;
      }
      
      public Traffic clearLength()
      {
        this.a = Collections.emptyList();
        return this;
      }
      
      public Traffic clearStatus()
      {
        this.b = Collections.emptyList();
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.c < 0) {
          getSerializedSize();
        }
        return this.c;
      }
      
      public int getLength(int paramInt)
      {
        return ((Integer)this.a.get(paramInt)).intValue();
      }
      
      public int getLengthCount()
      {
        return this.a.size();
      }
      
      public List<Integer> getLengthList()
      {
        return this.a;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        Iterator localIterator = getLengthList().iterator();
        for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
        int k = getLengthList().size();
        localIterator = getStatusList().iterator();
        while (localIterator.hasNext()) {
          j += CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue());
        }
        i = k * 1 + (0 + i) + j + getStatusList().size() * 1;
        this.c = i;
        return i;
      }
      
      public int getStatus(int paramInt)
      {
        return ((Integer)this.b.get(paramInt)).intValue();
      }
      
      public int getStatusCount()
      {
        return this.b.size();
      }
      
      public List<Integer> getStatusList()
      {
        return this.b;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Traffic mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            addLength(paramCodedInputStreamMicro.readInt32());
            break;
          case 16: 
            addStatus(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public Traffic setLength(int paramInt1, int paramInt2)
      {
        this.a.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public Traffic setStatus(int paramInt1, int paramInt2)
      {
        this.b.set(paramInt1, Integer.valueOf(paramInt2));
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getLengthList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeInt32(1, ((Integer)localIterator.next()).intValue());
        }
        localIterator = getStatusList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeInt32(2, ((Integer)localIterator.next()).intValue());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Mrtl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */