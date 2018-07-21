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

public final class Openlist
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 2;
  public static final int STYLE_FIELD_NUMBER = 1;
  private boolean a;
  private Style b = null;
  private boolean c;
  private Data d = null;
  private int e = -1;
  
  public static Openlist parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Openlist().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Openlist parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Openlist)new Openlist().mergeFrom(paramArrayOfByte);
  }
  
  public final Openlist clear()
  {
    clearStyle();
    clearData();
    this.e = -1;
    return this;
  }
  
  public Openlist clearData()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Openlist clearStyle()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public Data getData()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasStyle()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getStyle());
    }
    int j = i;
    if (hasData()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(2, getData());
    }
    this.e = j;
    return j;
  }
  
  public Style getStyle()
  {
    return this.b;
  }
  
  public boolean hasData()
  {
    return this.c;
  }
  
  public boolean hasStyle()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Openlist mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Style();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setStyle((Style)localObject);
        break;
      case 18: 
        localObject = new Data();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setData((Data)localObject);
      }
    }
  }
  
  public Openlist setData(Data paramData)
  {
    if (paramData == null) {
      return clearData();
    }
    this.c = true;
    this.d = paramData;
    return this;
  }
  
  public Openlist setStyle(Style paramStyle)
  {
    if (paramStyle == null) {
      return clearStyle();
    }
    this.a = true;
    this.b = paramStyle;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasStyle()) {
      paramCodedOutputStreamMicro.writeMessage(1, getStyle());
    }
    if (hasData()) {
      paramCodedOutputStreamMicro.writeMessage(2, getData());
    }
  }
  
  public static final class Data
    extends MessageMicro
  {
    public static final int CONTENTS_FIELD_NUMBER = 4;
    public static final int SIZE_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int TOTAL_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private List<String> g = Collections.emptyList();
    private int h = -1;
    
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
    
    public Data addContents(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.g.isEmpty()) {
        this.g = new ArrayList();
      }
      this.g.add(paramString);
      return this;
    }
    
    public final Data clear()
    {
      clearStatus();
      clearTotal();
      clearSize();
      clearContents();
      this.h = -1;
      return this;
    }
    
    public Data clearContents()
    {
      this.g = Collections.emptyList();
      return this;
    }
    
    public Data clearSize()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Data clearStatus()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Data clearTotal()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.h < 0) {
        getSerializedSize();
      }
      return this.h;
    }
    
    public String getContents(int paramInt)
    {
      return (String)this.g.get(paramInt);
    }
    
    public int getContentsCount()
    {
      return this.g.size();
    }
    
    public List<String> getContentsList()
    {
      return this.g;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasStatus()) {}
      for (int i = CodedOutputStreamMicro.computeInt32Size(1, getStatus()) + 0;; i = 0)
      {
        int j = i;
        if (hasTotal()) {
          j = i + CodedOutputStreamMicro.computeInt32Size(2, getTotal());
        }
        if (hasSize()) {}
        for (i = j + CodedOutputStreamMicro.computeInt32Size(3, getSize());; i = j)
        {
          Iterator localIterator = getContentsList().iterator();
          j = k;
          while (localIterator.hasNext()) {
            j += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
          }
          i = i + j + getContentsList().size() * 1;
          this.h = i;
          return i;
        }
      }
    }
    
    public int getSize()
    {
      return this.f;
    }
    
    public int getStatus()
    {
      return this.b;
    }
    
    public int getTotal()
    {
      return this.d;
    }
    
    public boolean hasSize()
    {
      return this.e;
    }
    
    public boolean hasStatus()
    {
      return this.a;
    }
    
    public boolean hasTotal()
    {
      return this.c;
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
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setStatus(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setTotal(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setSize(paramCodedInputStreamMicro.readInt32());
          break;
        case 34: 
          addContents(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Data setContents(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.g.set(paramInt, paramString);
      return this;
    }
    
    public Data setSize(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Data setStatus(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Data setTotal(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasStatus()) {
        paramCodedOutputStreamMicro.writeInt32(1, getStatus());
      }
      if (hasTotal()) {
        paramCodedOutputStreamMicro.writeInt32(2, getTotal());
      }
      if (hasSize()) {
        paramCodedOutputStreamMicro.writeInt32(3, getSize());
      }
      Iterator localIterator = getContentsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(4, (String)localIterator.next());
      }
    }
  }
  
  public static final class Style
    extends MessageMicro
  {
    public static final int CATEGORY_FIELD_NUMBER = 3;
    public static final int DEFAULT_GEOTABLE_ID_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 5;
    public static final int INFOWINDOW_STYLE_FIELD_NUMBER = 4;
    public static final int LOGO_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
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
    private int m = -1;
    
    public static Style parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Style().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Style parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Style)new Style().mergeFrom(paramArrayOfByte);
    }
    
    public final Style clear()
    {
      clearLogo();
      clearUrl();
      clearCategory();
      clearInfowindowStyle();
      clearId();
      clearDefaultGeotableId();
      this.m = -1;
      return this;
    }
    
    public Style clearCategory()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Style clearDefaultGeotableId()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Style clearId()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Style clearInfowindowStyle()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Style clearLogo()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Style clearUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public String getCategory()
    {
      return this.f;
    }
    
    public String getDefaultGeotableId()
    {
      return this.l;
    }
    
    public String getId()
    {
      return this.j;
    }
    
    public String getInfowindowStyle()
    {
      return this.h;
    }
    
    public String getLogo()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasLogo()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getLogo());
      }
      int n = i1;
      if (hasUrl()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getUrl());
      }
      i1 = n;
      if (hasCategory()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getCategory());
      }
      n = i1;
      if (hasInfowindowStyle()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getInfowindowStyle());
      }
      i1 = n;
      if (hasId()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getId());
      }
      n = i1;
      if (hasDefaultGeotableId()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getDefaultGeotableId());
      }
      this.m = n;
      return n;
    }
    
    public String getUrl()
    {
      return this.d;
    }
    
    public boolean hasCategory()
    {
      return this.e;
    }
    
    public boolean hasDefaultGeotableId()
    {
      return this.k;
    }
    
    public boolean hasId()
    {
      return this.i;
    }
    
    public boolean hasInfowindowStyle()
    {
      return this.g;
    }
    
    public boolean hasLogo()
    {
      return this.a;
    }
    
    public boolean hasUrl()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Style mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int n = paramCodedInputStreamMicro.readTag();
        switch (n)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setLogo(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setUrl(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setCategory(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setInfowindowStyle(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setId(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setDefaultGeotableId(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Style setCategory(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Style setDefaultGeotableId(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Style setId(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Style setInfowindowStyle(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Style setLogo(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Style setUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasLogo()) {
        paramCodedOutputStreamMicro.writeString(1, getLogo());
      }
      if (hasUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getUrl());
      }
      if (hasCategory()) {
        paramCodedOutputStreamMicro.writeString(3, getCategory());
      }
      if (hasInfowindowStyle()) {
        paramCodedOutputStreamMicro.writeString(4, getInfowindowStyle());
      }
      if (hasId()) {
        paramCodedOutputStreamMicro.writeString(5, getId());
      }
      if (hasDefaultGeotableId()) {
        paramCodedOutputStreamMicro.writeString(6, getDefaultGeotableId());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Openlist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */