package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Bar
  extends MessageMicro
{
  public static final int BLOCKINFOS_FIELD_NUMBER = 2;
  public static final int POIINFOS_FIELD_NUMBER = 3;
  public static final int VERSION_FIELD_NUMBER = 1;
  private boolean a;
  private String b = "";
  private List<Blockinfo> c = Collections.emptyList();
  private List<Poiinfo> d = Collections.emptyList();
  private int e = -1;
  
  public static Bar parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Bar().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Bar parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Bar)new Bar().mergeFrom(paramArrayOfByte);
  }
  
  public Bar addBlockinfos(Blockinfo paramBlockinfo)
  {
    if (paramBlockinfo == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramBlockinfo);
    return this;
  }
  
  public Bar addPoiinfos(Poiinfo paramPoiinfo)
  {
    if (paramPoiinfo == null) {
      return this;
    }
    if (this.d.isEmpty()) {
      this.d = new ArrayList();
    }
    this.d.add(paramPoiinfo);
    return this;
  }
  
  public final Bar clear()
  {
    clearVersion();
    clearBlockinfos();
    clearPoiinfos();
    this.e = -1;
    return this;
  }
  
  public Bar clearBlockinfos()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public Bar clearPoiinfos()
  {
    this.d = Collections.emptyList();
    return this;
  }
  
  public Bar clearVersion()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public Blockinfo getBlockinfos(int paramInt)
  {
    return (Blockinfo)this.c.get(paramInt);
  }
  
  public int getBlockinfosCount()
  {
    return this.c.size();
  }
  
  public List<Blockinfo> getBlockinfosList()
  {
    return this.c;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public Poiinfo getPoiinfos(int paramInt)
  {
    return (Poiinfo)this.d.get(paramInt);
  }
  
  public int getPoiinfosCount()
  {
    return this.d.size();
  }
  
  public List<Poiinfo> getPoiinfosList()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasVersion()) {
      i = 0 + CodedOutputStreamMicro.computeStringSize(1, getVersion());
    }
    Iterator localIterator = getBlockinfosList().iterator();
    while (localIterator.hasNext()) {
      i = CodedOutputStreamMicro.computeMessageSize(2, (Blockinfo)localIterator.next()) + i;
    }
    localIterator = getPoiinfosList().iterator();
    while (localIterator.hasNext()) {
      i += CodedOutputStreamMicro.computeMessageSize(3, (Poiinfo)localIterator.next());
    }
    this.e = i;
    return i;
  }
  
  public String getVersion()
  {
    return this.b;
  }
  
  public boolean hasVersion()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Bar mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setVersion(paramCodedInputStreamMicro.readString());
        break;
      case 18: 
        localObject = new Blockinfo();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addBlockinfos((Blockinfo)localObject);
        break;
      case 26: 
        localObject = new Poiinfo();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addPoiinfos((Poiinfo)localObject);
      }
    }
  }
  
  public Bar setBlockinfos(int paramInt, Blockinfo paramBlockinfo)
  {
    if (paramBlockinfo == null) {
      return this;
    }
    this.c.set(paramInt, paramBlockinfo);
    return this;
  }
  
  public Bar setPoiinfos(int paramInt, Poiinfo paramPoiinfo)
  {
    if (paramPoiinfo == null) {
      return this;
    }
    this.d.set(paramInt, paramPoiinfo);
    return this;
  }
  
  public Bar setVersion(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasVersion()) {
      paramCodedOutputStreamMicro.writeString(1, getVersion());
    }
    Iterator localIterator = getBlockinfosList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (Blockinfo)localIterator.next());
    }
    localIterator = getPoiinfosList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (Poiinfo)localIterator.next());
    }
  }
  
  public static final class Blockinfo
    extends MessageMicro
  {
    public static final int BLOCK_ID_FIELD_NUMBER = 1;
    public static final int UIDS_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private List<String> c = Collections.emptyList();
    private int d = -1;
    
    public static Blockinfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Blockinfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Blockinfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Blockinfo)new Blockinfo().mergeFrom(paramArrayOfByte);
    }
    
    public Blockinfo addUids(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramString);
      return this;
    }
    
    public final Blockinfo clear()
    {
      clearBlockId();
      clearUids();
      this.d = -1;
      return this;
    }
    
    public Blockinfo clearBlockId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Blockinfo clearUids()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public String getBlockId()
    {
      return this.b;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasBlockId()) {}
      for (int i = CodedOutputStreamMicro.computeStringSize(1, getBlockId()) + 0;; i = 0)
      {
        Iterator localIterator = getUidsList().iterator();
        while (localIterator.hasNext()) {
          j += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
        }
        i = i + j + getUidsList().size() * 1;
        this.d = i;
        return i;
      }
    }
    
    public String getUids(int paramInt)
    {
      return (String)this.c.get(paramInt);
    }
    
    public int getUidsCount()
    {
      return this.c.size();
    }
    
    public List<String> getUidsList()
    {
      return this.c;
    }
    
    public boolean hasBlockId()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Blockinfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setBlockId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          addUids(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Blockinfo setBlockId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Blockinfo setUids(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.c.set(paramInt, paramString);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasBlockId()) {
        paramCodedOutputStreamMicro.writeString(1, getBlockId());
      }
      Iterator localIterator = getUidsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(2, (String)localIterator.next());
      }
    }
  }
  
  public static final class Poiinfo
    extends MessageMicro
  {
    public static final int LDOWN_FIELD_NUMBER = 5;
    public static final int LUP_FIELD_NUMBER = 4;
    public static final int POIBARINFO_FIELD_NUMBER = 6;
    public static final int PRIORITY_FIELD_NUMBER = 3;
    public static final int SEARCHBOUND_FIELD_NUMBER = 7;
    public static final int SURFACE_FIELD_NUMBER = 2;
    public static final int UID_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<Surface> c = Collections.emptyList();
    private boolean d;
    private int e = 0;
    private boolean f;
    private int g = 0;
    private boolean h;
    private int i = 0;
    private boolean j;
    private ByteStringMicro k = ByteStringMicro.EMPTY;
    private boolean l;
    private String m = "";
    private int n = -1;
    
    public static Poiinfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Poiinfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Poiinfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Poiinfo)new Poiinfo().mergeFrom(paramArrayOfByte);
    }
    
    public Poiinfo addSurface(Surface paramSurface)
    {
      if (paramSurface == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramSurface);
      return this;
    }
    
    public final Poiinfo clear()
    {
      clearUid();
      clearSurface();
      clearPriority();
      clearLup();
      clearLdown();
      clearPoibarinfo();
      clearSearchbound();
      this.n = -1;
      return this;
    }
    
    public Poiinfo clearLdown()
    {
      this.h = false;
      this.i = 0;
      return this;
    }
    
    public Poiinfo clearLup()
    {
      this.f = false;
      this.g = 0;
      return this;
    }
    
    public Poiinfo clearPoibarinfo()
    {
      this.j = false;
      this.k = ByteStringMicro.EMPTY;
      return this;
    }
    
    public Poiinfo clearPriority()
    {
      this.d = false;
      this.e = 0;
      return this;
    }
    
    public Poiinfo clearSearchbound()
    {
      this.l = false;
      this.m = "";
      return this;
    }
    
    public Poiinfo clearSurface()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public Poiinfo clearUid()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.n < 0) {
        getSerializedSize();
      }
      return this.n;
    }
    
    public int getLdown()
    {
      return this.i;
    }
    
    public int getLup()
    {
      return this.g;
    }
    
    public ByteStringMicro getPoibarinfo()
    {
      return this.k;
    }
    
    public int getPriority()
    {
      return this.e;
    }
    
    public String getSearchbound()
    {
      return this.m;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasUid()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
      }
      Iterator localIterator = getSurfaceList().iterator();
      for (int i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(2, (Surface)localIterator.next()) + i2) {}
      i1 = i2;
      if (hasPriority()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(3, getPriority());
      }
      i2 = i1;
      if (hasLup()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(4, getLup());
      }
      i1 = i2;
      if (hasLdown()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(5, getLdown());
      }
      i2 = i1;
      if (hasPoibarinfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeBytesSize(6, getPoibarinfo());
      }
      i1 = i2;
      if (hasSearchbound()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getSearchbound());
      }
      this.n = i1;
      return i1;
    }
    
    public Surface getSurface(int paramInt)
    {
      return (Surface)this.c.get(paramInt);
    }
    
    public int getSurfaceCount()
    {
      return this.c.size();
    }
    
    public List<Surface> getSurfaceList()
    {
      return this.c;
    }
    
    public String getUid()
    {
      return this.b;
    }
    
    public boolean hasLdown()
    {
      return this.h;
    }
    
    public boolean hasLup()
    {
      return this.f;
    }
    
    public boolean hasPoibarinfo()
    {
      return this.j;
    }
    
    public boolean hasPriority()
    {
      return this.d;
    }
    
    public boolean hasSearchbound()
    {
      return this.l;
    }
    
    public boolean hasUid()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Poiinfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          Surface localSurface = new Surface();
          paramCodedInputStreamMicro.readMessage(localSurface);
          addSurface(localSurface);
          break;
        case 24: 
          setPriority(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setLup(paramCodedInputStreamMicro.readInt32());
          break;
        case 40: 
          setLdown(paramCodedInputStreamMicro.readInt32());
          break;
        case 50: 
          setPoibarinfo(paramCodedInputStreamMicro.readBytes());
          break;
        case 58: 
          setSearchbound(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Poiinfo setLdown(int paramInt)
    {
      this.h = true;
      this.i = paramInt;
      return this;
    }
    
    public Poiinfo setLup(int paramInt)
    {
      this.f = true;
      this.g = paramInt;
      return this;
    }
    
    public Poiinfo setPoibarinfo(ByteStringMicro paramByteStringMicro)
    {
      this.j = true;
      this.k = paramByteStringMicro;
      return this;
    }
    
    public Poiinfo setPriority(int paramInt)
    {
      this.d = true;
      this.e = paramInt;
      return this;
    }
    
    public Poiinfo setSearchbound(String paramString)
    {
      this.l = true;
      this.m = paramString;
      return this;
    }
    
    public Poiinfo setSurface(int paramInt, Surface paramSurface)
    {
      if (paramSurface == null) {
        return this;
      }
      this.c.set(paramInt, paramSurface);
      return this;
    }
    
    public Poiinfo setUid(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(1, getUid());
      }
      Iterator localIterator = getSurfaceList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Surface)localIterator.next());
      }
      if (hasPriority()) {
        paramCodedOutputStreamMicro.writeInt32(3, getPriority());
      }
      if (hasLup()) {
        paramCodedOutputStreamMicro.writeInt32(4, getLup());
      }
      if (hasLdown()) {
        paramCodedOutputStreamMicro.writeInt32(5, getLdown());
      }
      if (hasPoibarinfo()) {
        paramCodedOutputStreamMicro.writeBytes(6, getPoibarinfo());
      }
      if (hasSearchbound()) {
        paramCodedOutputStreamMicro.writeString(7, getSearchbound());
      }
    }
    
    public static final class Surface
      extends MessageMicro
    {
      public static final int POINT_FIELD_NUMBER = 1;
      private List<Point> a = Collections.emptyList();
      private int b = -1;
      
      public static Surface parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Surface().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Surface parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Surface)new Surface().mergeFrom(paramArrayOfByte);
      }
      
      public Surface addPoint(Point paramPoint)
      {
        if (paramPoint == null) {
          return this;
        }
        if (this.a.isEmpty()) {
          this.a = new ArrayList();
        }
        this.a.add(paramPoint);
        return this;
      }
      
      public final Surface clear()
      {
        clearPoint();
        this.b = -1;
        return this;
      }
      
      public Surface clearPoint()
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
      
      public Point getPoint(int paramInt)
      {
        return (Point)this.a.get(paramInt);
      }
      
      public int getPointCount()
      {
        return this.a.size();
      }
      
      public List<Point> getPointList()
      {
        return this.a;
      }
      
      public int getSerializedSize()
      {
        Iterator localIterator = getPointList().iterator();
        for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Point)localIterator.next()) + i) {}
        this.b = i;
        return i;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Surface mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            Point localPoint = new Point();
            paramCodedInputStreamMicro.readMessage(localPoint);
            addPoint(localPoint);
          }
        }
      }
      
      public Surface setPoint(int paramInt, Point paramPoint)
      {
        if (paramPoint == null) {
          return this;
        }
        this.a.set(paramInt, paramPoint);
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        Iterator localIterator = getPointList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(1, (Point)localIterator.next());
        }
      }
      
      public static final class Point
        extends MessageMicro
      {
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private boolean a;
        private double b = 0.0D;
        private boolean c;
        private double d = 0.0D;
        private int e = -1;
        
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
          clearX();
          clearY();
          this.e = -1;
          return this;
        }
        
        public Point clearX()
        {
          this.a = false;
          this.b = 0.0D;
          return this;
        }
        
        public Point clearY()
        {
          this.c = false;
          this.d = 0.0D;
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
          if (hasX()) {
            i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
          }
          int j = i;
          if (hasY()) {
            j = i + CodedOutputStreamMicro.computeDoubleSize(2, getY());
          }
          this.e = j;
          return j;
        }
        
        public double getX()
        {
          return this.b;
        }
        
        public double getY()
        {
          return this.d;
        }
        
        public boolean hasX()
        {
          return this.a;
        }
        
        public boolean hasY()
        {
          return this.c;
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
            case 9: 
              setX(paramCodedInputStreamMicro.readDouble());
              break;
            case 17: 
              setY(paramCodedInputStreamMicro.readDouble());
            }
          }
        }
        
        public Point setX(double paramDouble)
        {
          this.a = true;
          this.b = paramDouble;
          return this;
        }
        
        public Point setY(double paramDouble)
        {
          this.c = true;
          this.d = paramDouble;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasX()) {
            paramCodedOutputStreamMicro.writeDouble(1, getX());
          }
          if (hasY()) {
            paramCodedOutputStreamMicro.writeDouble(2, getY());
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Bar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */