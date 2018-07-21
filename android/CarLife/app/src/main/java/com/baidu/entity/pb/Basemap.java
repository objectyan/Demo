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

public final class Basemap
  extends MessageMicro
{
  public static final int ELEMENTS_FIELD_NUMBER = 1;
  private List<Element> a = Collections.emptyList();
  private int b = -1;
  
  public static Basemap parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Basemap().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Basemap parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Basemap)new Basemap().mergeFrom(paramArrayOfByte);
  }
  
  public Basemap addElements(Element paramElement)
  {
    if (paramElement == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramElement);
    return this;
  }
  
  public final Basemap clear()
  {
    clearElements();
    this.b = -1;
    return this;
  }
  
  public Basemap clearElements()
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
  
  public Element getElements(int paramInt)
  {
    return (Element)this.a.get(paramInt);
  }
  
  public int getElementsCount()
  {
    return this.a.size();
  }
  
  public List<Element> getElementsList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getElementsList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Element)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Basemap mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Element localElement = new Element();
        paramCodedInputStreamMicro.readMessage(localElement);
        addElements(localElement);
      }
    }
  }
  
  public Basemap setElements(int paramInt, Element paramElement)
  {
    if (paramElement == null) {
      return this;
    }
    this.a.set(paramInt, paramElement);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getElementsList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Element)localIterator.next());
    }
  }
  
  public static final class Element
    extends MessageMicro
  {
    public static final int FSTYPE_FIELD_NUMBER = 3;
    public static final int INDEX_FIELD_NUMBER = 4;
    public static final int NSTYLE_FIELD_NUMBER = 2;
    public static final int POINTS_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private List<Point> i = Collections.emptyList();
    private int j = -1;
    
    public static Element parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Element().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Element parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Element)new Element().mergeFrom(paramArrayOfByte);
    }
    
    public Element addPoints(Point paramPoint)
    {
      if (paramPoint == null) {
        return this;
      }
      if (this.i.isEmpty()) {
        this.i = new ArrayList();
      }
      this.i.add(paramPoint);
      return this;
    }
    
    public final Element clear()
    {
      clearType();
      clearNstyle();
      clearFstype();
      clearIndex();
      clearPoints();
      this.j = -1;
      return this;
    }
    
    public Element clearFstype()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Element clearIndex()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Element clearNstyle()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Element clearPoints()
    {
      this.i = Collections.emptyList();
      return this;
    }
    
    public Element clearType()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.j < 0) {
        getSerializedSize();
      }
      return this.j;
    }
    
    public int getFstype()
    {
      return this.f;
    }
    
    public int getIndex()
    {
      return this.h;
    }
    
    public int getNstyle()
    {
      return this.d;
    }
    
    public Point getPoints(int paramInt)
    {
      return (Point)this.i.get(paramInt);
    }
    
    public int getPointsCount()
    {
      return this.i.size();
    }
    
    public List<Point> getPointsList()
    {
      return this.i;
    }
    
    public int getSerializedSize()
    {
      int m = 0;
      if (hasType()) {
        m = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
      }
      int k = m;
      if (hasNstyle()) {
        k = m + CodedOutputStreamMicro.computeInt32Size(2, getNstyle());
      }
      m = k;
      if (hasFstype()) {
        m = k + CodedOutputStreamMicro.computeInt32Size(3, getFstype());
      }
      k = m;
      if (hasIndex()) {
        k = m + CodedOutputStreamMicro.computeInt32Size(4, getIndex());
      }
      Iterator localIterator = getPointsList().iterator();
      while (localIterator.hasNext()) {
        k = CodedOutputStreamMicro.computeMessageSize(5, (Point)localIterator.next()) + k;
      }
      this.j = k;
      return k;
    }
    
    public int getType()
    {
      return this.b;
    }
    
    public boolean hasFstype()
    {
      return this.e;
    }
    
    public boolean hasIndex()
    {
      return this.g;
    }
    
    public boolean hasNstyle()
    {
      return this.c;
    }
    
    public boolean hasType()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Element mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int k = paramCodedInputStreamMicro.readTag();
        switch (k)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, k)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setType(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setNstyle(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setFstype(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setIndex(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          Point localPoint = new Point();
          paramCodedInputStreamMicro.readMessage(localPoint);
          addPoints(localPoint);
        }
      }
    }
    
    public Element setFstype(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Element setIndex(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Element setNstyle(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Element setPoints(int paramInt, Point paramPoint)
    {
      if (paramPoint == null) {
        return this;
      }
      this.i.set(paramInt, paramPoint);
      return this;
    }
    
    public Element setType(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasType()) {
        paramCodedOutputStreamMicro.writeInt32(1, getType());
      }
      if (hasNstyle()) {
        paramCodedOutputStreamMicro.writeInt32(2, getNstyle());
      }
      if (hasFstype()) {
        paramCodedOutputStreamMicro.writeInt32(3, getFstype());
      }
      if (hasIndex()) {
        paramCodedOutputStreamMicro.writeInt32(4, getIndex());
      }
      Iterator localIterator = getPointsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(5, (Point)localIterator.next());
      }
    }
    
    public static final class Point
      extends MessageMicro
    {
      public static final int X_FIELD_NUMBER = 1;
      public static final int Y_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
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
        this.b = "";
        return this;
      }
      
      public Point clearY()
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
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasX()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getX());
        }
        int j = i;
        if (hasY()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getY());
        }
        this.e = j;
        return j;
      }
      
      public String getX()
      {
        return this.b;
      }
      
      public String getY()
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
          case 10: 
            setX(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setY(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Point setX(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Point setY(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasX()) {
          paramCodedOutputStreamMicro.writeString(1, getX());
        }
        if (hasY()) {
          paramCodedOutputStreamMicro.writeString(2, getY());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Basemap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */