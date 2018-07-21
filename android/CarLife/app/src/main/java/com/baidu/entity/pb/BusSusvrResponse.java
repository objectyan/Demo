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

public final class BusSusvrResponse
  extends MessageMicro
{
  public static final int POI_ARRAY_FIELD_NUMBER = 1;
  public static final int TYPE_FIELD_NUMBER = 2;
  private List<PoiElement> a = Collections.emptyList();
  private boolean b;
  private int c = 0;
  private int d = -1;
  
  public static BusSusvrResponse parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new BusSusvrResponse().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static BusSusvrResponse parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (BusSusvrResponse)new BusSusvrResponse().mergeFrom(paramArrayOfByte);
  }
  
  public BusSusvrResponse addPoiArray(PoiElement paramPoiElement)
  {
    if (paramPoiElement == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramPoiElement);
    return this;
  }
  
  public final BusSusvrResponse clear()
  {
    clearPoiArray();
    clearType();
    this.d = -1;
    return this;
  }
  
  public BusSusvrResponse clearPoiArray()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public BusSusvrResponse clearType()
  {
    this.b = false;
    this.c = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.d < 0) {
      getSerializedSize();
    }
    return this.d;
  }
  
  public PoiElement getPoiArray(int paramInt)
  {
    return (PoiElement)this.a.get(paramInt);
  }
  
  public int getPoiArrayCount()
  {
    return this.a.size();
  }
  
  public List<PoiElement> getPoiArrayList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getPoiArrayList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (PoiElement)localIterator.next()) + i) {}
    int j = i;
    if (hasType()) {
      j = i + CodedOutputStreamMicro.computeInt32Size(2, getType());
    }
    this.d = j;
    return j;
  }
  
  public int getType()
  {
    return this.c;
  }
  
  public boolean hasType()
  {
    return this.b;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public BusSusvrResponse mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        PoiElement localPoiElement = new PoiElement();
        paramCodedInputStreamMicro.readMessage(localPoiElement);
        addPoiArray(localPoiElement);
        break;
      case 16: 
        setType(paramCodedInputStreamMicro.readInt32());
      }
    }
  }
  
  public BusSusvrResponse setPoiArray(int paramInt, PoiElement paramPoiElement)
  {
    if (paramPoiElement == null) {
      return this;
    }
    this.a.set(paramInt, paramPoiElement);
    return this;
  }
  
  public BusSusvrResponse setType(int paramInt)
  {
    this.b = true;
    this.c = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getPoiArrayList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (PoiElement)localIterator.next());
    }
    if (hasType()) {
      paramCodedOutputStreamMicro.writeInt32(2, getType());
    }
  }
  
  public static final class PoiElement
    extends MessageMicro
  {
    public static final int CITYID_FIELD_NUMBER = 3;
    public static final int DISTANCE_FIELD_NUMBER = 4;
    public static final int POI_NAME_FIELD_NUMBER = 1;
    public static final int SUB_POI_ARRAY_FIELD_NUMBER = 6;
    public static final int SUB_POI_TYPE_FIELD_NUMBER = 5;
    public static final int SUB_TITLE_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UID_FIELD_NUMBER = 7;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private boolean g;
    private String h = "";
    private boolean i;
    private int j = 0;
    private List<SubPoi> k = Collections.emptyList();
    private boolean l;
    private String m = "";
    private boolean n;
    private int o = 0;
    private int p = -1;
    
    public static PoiElement parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new PoiElement().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static PoiElement parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (PoiElement)new PoiElement().mergeFrom(paramArrayOfByte);
    }
    
    public PoiElement addSubPoiArray(SubPoi paramSubPoi)
    {
      if (paramSubPoi == null) {
        return this;
      }
      if (this.k.isEmpty()) {
        this.k = new ArrayList();
      }
      this.k.add(paramSubPoi);
      return this;
    }
    
    public final PoiElement clear()
    {
      clearPoiName();
      clearSubTitle();
      clearCityid();
      clearDistance();
      clearSubPoiType();
      clearSubPoiArray();
      clearUid();
      clearType();
      this.p = -1;
      return this;
    }
    
    public PoiElement clearCityid()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public PoiElement clearDistance()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public PoiElement clearPoiName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public PoiElement clearSubPoiArray()
    {
      this.k = Collections.emptyList();
      return this;
    }
    
    public PoiElement clearSubPoiType()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public PoiElement clearSubTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public PoiElement clearType()
    {
      this.n = false;
      this.o = 0;
      return this;
    }
    
    public PoiElement clearUid()
    {
      this.l = false;
      this.m = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.p < 0) {
        getSerializedSize();
      }
      return this.p;
    }
    
    public int getCityid()
    {
      return this.f;
    }
    
    public String getDistance()
    {
      return this.h;
    }
    
    public String getPoiName()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasPoiName()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiName());
      }
      int i1 = i2;
      if (hasSubTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
      }
      i2 = i1;
      if (hasCityid()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getCityid());
      }
      i1 = i2;
      if (hasDistance()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getDistance());
      }
      i2 = i1;
      if (hasSubPoiType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getSubPoiType());
      }
      Iterator localIterator = getSubPoiArrayList().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(6, (SubPoi)localIterator.next()) + i2;
      }
      i1 = i2;
      if (hasUid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getUid());
      }
      i2 = i1;
      if (hasType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(8, getType());
      }
      this.p = i2;
      return i2;
    }
    
    public SubPoi getSubPoiArray(int paramInt)
    {
      return (SubPoi)this.k.get(paramInt);
    }
    
    public int getSubPoiArrayCount()
    {
      return this.k.size();
    }
    
    public List<SubPoi> getSubPoiArrayList()
    {
      return this.k;
    }
    
    public int getSubPoiType()
    {
      return this.j;
    }
    
    public String getSubTitle()
    {
      return this.d;
    }
    
    public int getType()
    {
      return this.o;
    }
    
    public String getUid()
    {
      return this.m;
    }
    
    public boolean hasCityid()
    {
      return this.e;
    }
    
    public boolean hasDistance()
    {
      return this.g;
    }
    
    public boolean hasPoiName()
    {
      return this.a;
    }
    
    public boolean hasSubPoiType()
    {
      return this.i;
    }
    
    public boolean hasSubTitle()
    {
      return this.c;
    }
    
    public boolean hasType()
    {
      return this.n;
    }
    
    public boolean hasUid()
    {
      return this.l;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public PoiElement mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setPoiName(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setSubTitle(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setCityid(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          setDistance(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setSubPoiType(paramCodedInputStreamMicro.readInt32());
          break;
        case 50: 
          SubPoi localSubPoi = new SubPoi();
          paramCodedInputStreamMicro.readMessage(localSubPoi);
          addSubPoiArray(localSubPoi);
          break;
        case 58: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 64: 
          setType(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public PoiElement setCityid(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public PoiElement setDistance(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public PoiElement setPoiName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public PoiElement setSubPoiArray(int paramInt, SubPoi paramSubPoi)
    {
      if (paramSubPoi == null) {
        return this;
      }
      this.k.set(paramInt, paramSubPoi);
      return this;
    }
    
    public PoiElement setSubPoiType(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public PoiElement setSubTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public PoiElement setType(int paramInt)
    {
      this.n = true;
      this.o = paramInt;
      return this;
    }
    
    public PoiElement setUid(String paramString)
    {
      this.l = true;
      this.m = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPoiName()) {
        paramCodedOutputStreamMicro.writeString(1, getPoiName());
      }
      if (hasSubTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getSubTitle());
      }
      if (hasCityid()) {
        paramCodedOutputStreamMicro.writeInt32(3, getCityid());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeString(4, getDistance());
      }
      if (hasSubPoiType()) {
        paramCodedOutputStreamMicro.writeInt32(5, getSubPoiType());
      }
      Iterator localIterator = getSubPoiArrayList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(6, (SubPoi)localIterator.next());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(7, getUid());
      }
      if (hasType()) {
        paramCodedOutputStreamMicro.writeInt32(8, getType());
      }
    }
    
    public static final class SubPoi
      extends MessageMicro
    {
      public static final int POI_NAME_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private int c = -1;
      
      public static SubPoi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new SubPoi().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static SubPoi parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (SubPoi)new SubPoi().mergeFrom(paramArrayOfByte);
      }
      
      public final SubPoi clear()
      {
        clearPoiName();
        this.c = -1;
        return this;
      }
      
      public SubPoi clearPoiName()
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
      
      public String getPoiName()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasPoiName()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiName());
        }
        this.c = i;
        return i;
      }
      
      public boolean hasPoiName()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public SubPoi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setPoiName(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public SubPoi setPoiName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasPoiName()) {
          paramCodedOutputStreamMicro.writeString(1, getPoiName());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/BusSusvrResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */