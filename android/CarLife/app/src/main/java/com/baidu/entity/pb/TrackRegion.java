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

public final class TrackRegion
  extends MessageMicro
{
  public static final int REGION_LIST_FIELD_NUMBER = 1;
  private List<Region> a = Collections.emptyList();
  private int b = -1;
  
  public static TrackRegion parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrackRegion().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrackRegion parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrackRegion)new TrackRegion().mergeFrom(paramArrayOfByte);
  }
  
  public TrackRegion addRegionList(Region paramRegion)
  {
    if (paramRegion == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramRegion);
    return this;
  }
  
  public final TrackRegion clear()
  {
    clearRegionList();
    this.b = -1;
    return this;
  }
  
  public TrackRegion clearRegionList()
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
  
  public Region getRegionList(int paramInt)
  {
    return (Region)this.a.get(paramInt);
  }
  
  public int getRegionListCount()
  {
    return this.a.size();
  }
  
  public List<Region> getRegionListList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getRegionListList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Region)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrackRegion mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Region localRegion = new Region();
        paramCodedInputStreamMicro.readMessage(localRegion);
        addRegionList(localRegion);
      }
    }
  }
  
  public TrackRegion setRegionList(int paramInt, Region paramRegion)
  {
    if (paramRegion == null) {
      return this;
    }
    this.a.set(paramInt, paramRegion);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getRegionListList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Region)localIterator.next());
    }
  }
  
  public static final class Point
    extends MessageMicro
  {
    public static final int DATA_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private int c = -1;
    
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
      clearData();
      this.c = -1;
      return this;
    }
    
    public Point clearData()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.c < 0) {
        getSerializedSize();
      }
      return this.c;
    }
    
    public String getData()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasData()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getData());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasData()
    {
      return this.a;
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
        case 10: 
          setData(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Point setData(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasData()) {
        paramCodedOutputStreamMicro.writeString(1, getData());
      }
    }
  }
  
  public static final class Region
    extends MessageMicro
  {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int REGION_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private List<TrackRegion.Point> e = Collections.emptyList();
    private int f = -1;
    
    public static Region parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Region().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Region parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Region)new Region().mergeFrom(paramArrayOfByte);
    }
    
    public Region addRegion(TrackRegion.Point paramPoint)
    {
      if (paramPoint == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramPoint);
      return this;
    }
    
    public final Region clear()
    {
      clearName();
      clearUid();
      clearRegion();
      this.f = -1;
      return this;
    }
    
    public Region clearName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Region clearRegion()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public Region clearUid()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.f < 0) {
        getSerializedSize();
      }
      return this.f;
    }
    
    public String getName()
    {
      return this.b;
    }
    
    public TrackRegion.Point getRegion(int paramInt)
    {
      return (TrackRegion.Point)this.e.get(paramInt);
    }
    
    public int getRegionCount()
    {
      return this.e.size();
    }
    
    public List<TrackRegion.Point> getRegionList()
    {
      return this.e;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasName()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
      }
      int j = i;
      if (hasUid()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getUid());
      }
      Iterator localIterator = getRegionList().iterator();
      while (localIterator.hasNext()) {
        j = CodedOutputStreamMicro.computeMessageSize(3, (TrackRegion.Point)localIterator.next()) + j;
      }
      this.f = j;
      return j;
    }
    
    public String getUid()
    {
      return this.d;
    }
    
    public boolean hasName()
    {
      return this.a;
    }
    
    public boolean hasUid()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Region mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          TrackRegion.Point localPoint = new TrackRegion.Point();
          paramCodedInputStreamMicro.readMessage(localPoint);
          addRegion(localPoint);
        }
      }
    }
    
    public Region setName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Region setRegion(int paramInt, TrackRegion.Point paramPoint)
    {
      if (paramPoint == null) {
        return this;
      }
      this.e.set(paramInt, paramPoint);
      return this;
    }
    
    public Region setUid(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(1, getName());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(2, getUid());
      }
      Iterator localIterator = getRegionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (TrackRegion.Point)localIterator.next());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrackRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */