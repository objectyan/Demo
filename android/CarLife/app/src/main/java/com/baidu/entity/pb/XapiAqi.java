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

public final class XapiAqi
  extends MessageMicro
{
  public static final int CONTENTS_FIELD_NUMBER = 1;
  private List<Contents> a = Collections.emptyList();
  private int b = -1;
  
  public static XapiAqi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new XapiAqi().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static XapiAqi parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (XapiAqi)new XapiAqi().mergeFrom(paramArrayOfByte);
  }
  
  public XapiAqi addContents(Contents paramContents)
  {
    if (paramContents == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramContents);
    return this;
  }
  
  public final XapiAqi clear()
  {
    clearContents();
    this.b = -1;
    return this;
  }
  
  public XapiAqi clearContents()
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
  
  public Contents getContents(int paramInt)
  {
    return (Contents)this.a.get(paramInt);
  }
  
  public int getContentsCount()
  {
    return this.a.size();
  }
  
  public List<Contents> getContentsList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getContentsList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Contents)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public XapiAqi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Contents localContents = new Contents();
        paramCodedInputStreamMicro.readMessage(localContents);
        addContents(localContents);
      }
    }
  }
  
  public XapiAqi setContents(int paramInt, Contents paramContents)
  {
    if (paramContents == null) {
      return this;
    }
    this.a.set(paramInt, paramContents);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getContentsList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Contents)localIterator.next());
    }
  }
  
  public static final class Contents
    extends MessageMicro
  {
    public static final int AQI_FIELD_NUMBER = 4;
    public static final int CID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int POINT_FIELD_NUMBER = 3;
    public static final int POI_LIST_FIELD_NUMBER = 6;
    public static final int UPDATE_TIME_FIELD_NUMBER = 5;
    private boolean a;
    private Point b = null;
    private List<PoiList> c = Collections.emptyList();
    private boolean d;
    private int e = 0;
    private boolean f;
    private String g = "";
    private boolean h;
    private int i = 0;
    private boolean j;
    private String k = "";
    private int l = -1;
    
    public static Contents parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Contents().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Contents parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Contents)new Contents().mergeFrom(paramArrayOfByte);
    }
    
    public Contents addPoiList(PoiList paramPoiList)
    {
      if (paramPoiList == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramPoiList);
      return this;
    }
    
    public final Contents clear()
    {
      clearPoint();
      clearPoiList();
      clearCid();
      clearName();
      clearAqi();
      clearUpdateTime();
      this.l = -1;
      return this;
    }
    
    public Contents clearAqi()
    {
      this.h = false;
      this.i = 0;
      return this;
    }
    
    public Contents clearCid()
    {
      this.d = false;
      this.e = 0;
      return this;
    }
    
    public Contents clearName()
    {
      this.f = false;
      this.g = "";
      return this;
    }
    
    public Contents clearPoiList()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public Contents clearPoint()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public Contents clearUpdateTime()
    {
      this.j = false;
      this.k = "";
      return this;
    }
    
    public int getAqi()
    {
      return this.i;
    }
    
    public int getCachedSize()
    {
      if (this.l < 0) {
        getSerializedSize();
      }
      return this.l;
    }
    
    public int getCid()
    {
      return this.e;
    }
    
    public String getName()
    {
      return this.g;
    }
    
    public PoiList getPoiList(int paramInt)
    {
      return (PoiList)this.c.get(paramInt);
    }
    
    public int getPoiListCount()
    {
      return this.c.size();
    }
    
    public List<PoiList> getPoiListList()
    {
      return this.c;
    }
    
    public Point getPoint()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasCid()) {
        n = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCid());
      }
      int m = n;
      if (hasName()) {
        m = n + CodedOutputStreamMicro.computeStringSize(2, getName());
      }
      n = m;
      if (hasPoint()) {
        n = m + CodedOutputStreamMicro.computeMessageSize(3, getPoint());
      }
      m = n;
      if (hasAqi()) {
        m = n + CodedOutputStreamMicro.computeInt32Size(4, getAqi());
      }
      n = m;
      if (hasUpdateTime()) {
        n = m + CodedOutputStreamMicro.computeStringSize(5, getUpdateTime());
      }
      Iterator localIterator = getPoiListList().iterator();
      while (localIterator.hasNext()) {
        n = CodedOutputStreamMicro.computeMessageSize(6, (PoiList)localIterator.next()) + n;
      }
      this.l = n;
      return n;
    }
    
    public String getUpdateTime()
    {
      return this.k;
    }
    
    public boolean hasAqi()
    {
      return this.h;
    }
    
    public boolean hasCid()
    {
      return this.d;
    }
    
    public boolean hasName()
    {
      return this.f;
    }
    
    public boolean hasPoint()
    {
      return this.a;
    }
    
    public boolean hasUpdateTime()
    {
      return this.j;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Contents mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int m = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (m)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setCid(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          localObject = new Point();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setPoint((Point)localObject);
          break;
        case 32: 
          setAqi(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setUpdateTime(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          localObject = new PoiList();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addPoiList((PoiList)localObject);
        }
      }
    }
    
    public Contents setAqi(int paramInt)
    {
      this.h = true;
      this.i = paramInt;
      return this;
    }
    
    public Contents setCid(int paramInt)
    {
      this.d = true;
      this.e = paramInt;
      return this;
    }
    
    public Contents setName(String paramString)
    {
      this.f = true;
      this.g = paramString;
      return this;
    }
    
    public Contents setPoiList(int paramInt, PoiList paramPoiList)
    {
      if (paramPoiList == null) {
        return this;
      }
      this.c.set(paramInt, paramPoiList);
      return this;
    }
    
    public Contents setPoint(Point paramPoint)
    {
      if (paramPoint == null) {
        return clearPoint();
      }
      this.a = true;
      this.b = paramPoint;
      return this;
    }
    
    public Contents setUpdateTime(String paramString)
    {
      this.j = true;
      this.k = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCid()) {
        paramCodedOutputStreamMicro.writeInt32(1, getCid());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(2, getName());
      }
      if (hasPoint()) {
        paramCodedOutputStreamMicro.writeMessage(3, getPoint());
      }
      if (hasAqi()) {
        paramCodedOutputStreamMicro.writeInt32(4, getAqi());
      }
      if (hasUpdateTime()) {
        paramCodedOutputStreamMicro.writeString(5, getUpdateTime());
      }
      Iterator localIterator = getPoiListList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(6, (PoiList)localIterator.next());
      }
    }
    
    public static final class PoiList
      extends MessageMicro
    {
      public static final int AQI_FIELD_NUMBER = 3;
      public static final int NAME_FIELD_NUMBER = 1;
      public static final int POINT_FIELD_NUMBER = 2;
      public static final int UPDATE_TIME_FIELD_NUMBER = 4;
      private boolean a;
      private Point b = null;
      private boolean c;
      private String d = "";
      private boolean e;
      private int f = 0;
      private boolean g;
      private String h = "";
      private int i = -1;
      
      public static PoiList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new PoiList().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static PoiList parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (PoiList)new PoiList().mergeFrom(paramArrayOfByte);
      }
      
      public final PoiList clear()
      {
        clearPoint();
        clearName();
        clearAqi();
        clearUpdateTime();
        this.i = -1;
        return this;
      }
      
      public PoiList clearAqi()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public PoiList clearName()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public PoiList clearPoint()
      {
        this.a = false;
        this.b = null;
        return this;
      }
      
      public PoiList clearUpdateTime()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public int getAqi()
      {
        return this.f;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public String getName()
      {
        return this.d;
      }
      
      public Point getPoint()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasName()) {
          k = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
        }
        int j = k;
        if (hasPoint()) {
          j = k + CodedOutputStreamMicro.computeMessageSize(2, getPoint());
        }
        k = j;
        if (hasAqi()) {
          k = j + CodedOutputStreamMicro.computeInt32Size(3, getAqi());
        }
        j = k;
        if (hasUpdateTime()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getUpdateTime());
        }
        this.i = j;
        return j;
      }
      
      public String getUpdateTime()
      {
        return this.h;
      }
      
      public boolean hasAqi()
      {
        return this.e;
      }
      
      public boolean hasName()
      {
        return this.c;
      }
      
      public boolean hasPoint()
      {
        return this.a;
      }
      
      public boolean hasUpdateTime()
      {
        return this.g;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public PoiList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            Point localPoint = new Point();
            paramCodedInputStreamMicro.readMessage(localPoint);
            setPoint(localPoint);
            break;
          case 24: 
            setAqi(paramCodedInputStreamMicro.readInt32());
            break;
          case 34: 
            setUpdateTime(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public PoiList setAqi(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public PoiList setName(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public PoiList setPoint(Point paramPoint)
      {
        if (paramPoint == null) {
          return clearPoint();
        }
        this.a = true;
        this.b = paramPoint;
        return this;
      }
      
      public PoiList setUpdateTime(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasName()) {
          paramCodedOutputStreamMicro.writeString(1, getName());
        }
        if (hasPoint()) {
          paramCodedOutputStreamMicro.writeMessage(2, getPoint());
        }
        if (hasAqi()) {
          paramCodedOutputStreamMicro.writeInt32(3, getAqi());
        }
        if (hasUpdateTime()) {
          paramCodedOutputStreamMicro.writeString(4, getUpdateTime());
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/XapiAqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */