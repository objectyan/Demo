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

public final class Openmap
  extends MessageMicro
{
  public static final int INFO_FIELD_NUMBER = 1;
  public static final int TOTAL_FIELD_NUMBER = 2;
  private List<Info> a = Collections.emptyList();
  private boolean b;
  private int c = 0;
  private int d = -1;
  
  public static Openmap parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Openmap().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Openmap parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Openmap)new Openmap().mergeFrom(paramArrayOfByte);
  }
  
  public Openmap addInfo(Info paramInfo)
  {
    if (paramInfo == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramInfo);
    return this;
  }
  
  public final Openmap clear()
  {
    clearInfo();
    clearTotal();
    this.d = -1;
    return this;
  }
  
  public Openmap clearInfo()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public Openmap clearTotal()
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
  
  public Info getInfo(int paramInt)
  {
    return (Info)this.a.get(paramInt);
  }
  
  public int getInfoCount()
  {
    return this.a.size();
  }
  
  public List<Info> getInfoList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getInfoList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Info)localIterator.next()) + i) {}
    int j = i;
    if (hasTotal()) {
      j = i + CodedOutputStreamMicro.computeInt32Size(2, getTotal());
    }
    this.d = j;
    return j;
  }
  
  public int getTotal()
  {
    return this.c;
  }
  
  public boolean hasTotal()
  {
    return this.b;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Openmap mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Info localInfo = new Info();
        paramCodedInputStreamMicro.readMessage(localInfo);
        addInfo(localInfo);
        break;
      case 16: 
        setTotal(paramCodedInputStreamMicro.readInt32());
      }
    }
  }
  
  public Openmap setInfo(int paramInt, Info paramInfo)
  {
    if (paramInfo == null) {
      return this;
    }
    this.a.set(paramInt, paramInfo);
    return this;
  }
  
  public Openmap setTotal(int paramInt)
  {
    this.b = true;
    this.c = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getInfoList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Info)localIterator.next());
    }
    if (hasTotal()) {
      paramCodedOutputStreamMicro.writeInt32(2, getTotal());
    }
  }
  
  public static final class Info
    extends MessageMicro
  {
    public static final int BRAND_FIELD_NUMBER = 3;
    public static final int CATEGORY_ID_FIELD_NUMBER = 6;
    public static final int DEFAULT_GEOTABLE_ID_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INFOWINDOW_STYLE_FIELD_NUMBER = 7;
    public static final int LOGO_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int SRC_FIELD_NUMBER = 8;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
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
    private int q = -1;
    
    public static Info parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Info().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Info parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Info)new Info().mergeFrom(paramArrayOfByte);
    }
    
    public final Info clear()
    {
      clearId();
      clearName();
      clearBrand();
      clearLogo();
      clearDefaultGeotableId();
      clearCategoryId();
      clearInfowindowStyle();
      clearSrc();
      this.q = -1;
      return this;
    }
    
    public Info clearBrand()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Info clearCategoryId()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Info clearDefaultGeotableId()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Info clearId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Info clearInfowindowStyle()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Info clearLogo()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Info clearName()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Info clearSrc()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public String getBrand()
    {
      return this.f;
    }
    
    public int getCachedSize()
    {
      if (this.q < 0) {
        getSerializedSize();
      }
      return this.q;
    }
    
    public String getCategoryId()
    {
      return this.l;
    }
    
    public String getDefaultGeotableId()
    {
      return this.j;
    }
    
    public String getId()
    {
      return this.b;
    }
    
    public String getInfowindowStyle()
    {
      return this.n;
    }
    
    public String getLogo()
    {
      return this.h;
    }
    
    public String getName()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasId()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getId());
      }
      int i1 = i2;
      if (hasName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
      }
      i2 = i1;
      if (hasBrand()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getBrand());
      }
      i1 = i2;
      if (hasLogo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getLogo());
      }
      i2 = i1;
      if (hasDefaultGeotableId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getDefaultGeotableId());
      }
      i1 = i2;
      if (hasCategoryId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getCategoryId());
      }
      i2 = i1;
      if (hasInfowindowStyle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getInfowindowStyle());
      }
      i1 = i2;
      if (hasSrc()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getSrc());
      }
      this.q = i1;
      return i1;
    }
    
    public String getSrc()
    {
      return this.p;
    }
    
    public boolean hasBrand()
    {
      return this.e;
    }
    
    public boolean hasCategoryId()
    {
      return this.k;
    }
    
    public boolean hasDefaultGeotableId()
    {
      return this.i;
    }
    
    public boolean hasId()
    {
      return this.a;
    }
    
    public boolean hasInfowindowStyle()
    {
      return this.m;
    }
    
    public boolean hasLogo()
    {
      return this.g;
    }
    
    public boolean hasName()
    {
      return this.c;
    }
    
    public boolean hasSrc()
    {
      return this.o;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Info mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setBrand(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setLogo(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setDefaultGeotableId(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setCategoryId(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setInfowindowStyle(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setSrc(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Info setBrand(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Info setCategoryId(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Info setDefaultGeotableId(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Info setId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Info setInfowindowStyle(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Info setLogo(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Info setName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Info setSrc(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasId()) {
        paramCodedOutputStreamMicro.writeString(1, getId());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(2, getName());
      }
      if (hasBrand()) {
        paramCodedOutputStreamMicro.writeString(3, getBrand());
      }
      if (hasLogo()) {
        paramCodedOutputStreamMicro.writeString(4, getLogo());
      }
      if (hasDefaultGeotableId()) {
        paramCodedOutputStreamMicro.writeString(5, getDefaultGeotableId());
      }
      if (hasCategoryId()) {
        paramCodedOutputStreamMicro.writeString(6, getCategoryId());
      }
      if (hasInfowindowStyle()) {
        paramCodedOutputStreamMicro.writeString(7, getInfowindowStyle());
      }
      if (hasSrc()) {
        paramCodedOutputStreamMicro.writeString(8, getSrc());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Openmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */