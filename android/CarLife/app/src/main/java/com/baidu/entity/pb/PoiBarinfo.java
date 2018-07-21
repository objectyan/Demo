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

public final class PoiBarinfo
  extends MessageMicro
{
  public static final int BARINFO_FETTER_FIELD_NUMBER = 2;
  public static final int BARINFO_FREE_FIELD_NUMBER = 1;
  public static final int BARINFO_OTHER_FIELD_NUMBER = 3;
  public static final int EXT_FIELD_NUMBER = 5;
  public static final int TYPE_FIELD_NUMBER = 4;
  private List<Barinfo> a = Collections.emptyList();
  private List<Barinfo> b = Collections.emptyList();
  private List<Barinfo> c = Collections.emptyList();
  private boolean d;
  private String e = "";
  private boolean f;
  private String g = "";
  private int h = -1;
  
  public static PoiBarinfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new PoiBarinfo().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static PoiBarinfo parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (PoiBarinfo)new PoiBarinfo().mergeFrom(paramArrayOfByte);
  }
  
  public PoiBarinfo addBarinfoFetter(Barinfo paramBarinfo)
  {
    if (paramBarinfo == null) {
      return this;
    }
    if (this.b.isEmpty()) {
      this.b = new ArrayList();
    }
    this.b.add(paramBarinfo);
    return this;
  }
  
  public PoiBarinfo addBarinfoFree(Barinfo paramBarinfo)
  {
    if (paramBarinfo == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramBarinfo);
    return this;
  }
  
  public PoiBarinfo addBarinfoOther(Barinfo paramBarinfo)
  {
    if (paramBarinfo == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramBarinfo);
    return this;
  }
  
  public final PoiBarinfo clear()
  {
    clearBarinfoFree();
    clearBarinfoFetter();
    clearBarinfoOther();
    clearType();
    clearExt();
    this.h = -1;
    return this;
  }
  
  public PoiBarinfo clearBarinfoFetter()
  {
    this.b = Collections.emptyList();
    return this;
  }
  
  public PoiBarinfo clearBarinfoFree()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public PoiBarinfo clearBarinfoOther()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public PoiBarinfo clearExt()
  {
    this.f = false;
    this.g = "";
    return this;
  }
  
  public PoiBarinfo clearType()
  {
    this.d = false;
    this.e = "";
    return this;
  }
  
  public Barinfo getBarinfoFetter(int paramInt)
  {
    return (Barinfo)this.b.get(paramInt);
  }
  
  public int getBarinfoFetterCount()
  {
    return this.b.size();
  }
  
  public List<Barinfo> getBarinfoFetterList()
  {
    return this.b;
  }
  
  public Barinfo getBarinfoFree(int paramInt)
  {
    return (Barinfo)this.a.get(paramInt);
  }
  
  public int getBarinfoFreeCount()
  {
    return this.a.size();
  }
  
  public List<Barinfo> getBarinfoFreeList()
  {
    return this.a;
  }
  
  public Barinfo getBarinfoOther(int paramInt)
  {
    return (Barinfo)this.c.get(paramInt);
  }
  
  public int getBarinfoOtherCount()
  {
    return this.c.size();
  }
  
  public List<Barinfo> getBarinfoOtherList()
  {
    return this.c;
  }
  
  public int getCachedSize()
  {
    if (this.h < 0) {
      getSerializedSize();
    }
    return this.h;
  }
  
  public String getExt()
  {
    return this.g;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getBarinfoFreeList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Barinfo)localIterator.next()) + i) {}
    localIterator = getBarinfoFetterList().iterator();
    while (localIterator.hasNext()) {
      i += CodedOutputStreamMicro.computeMessageSize(2, (Barinfo)localIterator.next());
    }
    localIterator = getBarinfoOtherList().iterator();
    int j = i;
    while (localIterator.hasNext()) {
      j += CodedOutputStreamMicro.computeMessageSize(3, (Barinfo)localIterator.next());
    }
    i = j;
    if (hasType()) {
      i = j + CodedOutputStreamMicro.computeStringSize(4, getType());
    }
    j = i;
    if (hasExt()) {
      j = i + CodedOutputStreamMicro.computeStringSize(5, getExt());
    }
    this.h = j;
    return j;
  }
  
  public String getType()
  {
    return this.e;
  }
  
  public boolean hasExt()
  {
    return this.f;
  }
  
  public boolean hasType()
  {
    return this.d;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public PoiBarinfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i = paramCodedInputStreamMicro.readTag();
      Barinfo localBarinfo;
      switch (i)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        localBarinfo = new Barinfo();
        paramCodedInputStreamMicro.readMessage(localBarinfo);
        addBarinfoFree(localBarinfo);
        break;
      case 18: 
        localBarinfo = new Barinfo();
        paramCodedInputStreamMicro.readMessage(localBarinfo);
        addBarinfoFetter(localBarinfo);
        break;
      case 26: 
        localBarinfo = new Barinfo();
        paramCodedInputStreamMicro.readMessage(localBarinfo);
        addBarinfoOther(localBarinfo);
        break;
      case 34: 
        setType(paramCodedInputStreamMicro.readString());
        break;
      case 42: 
        setExt(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public PoiBarinfo setBarinfoFetter(int paramInt, Barinfo paramBarinfo)
  {
    if (paramBarinfo == null) {
      return this;
    }
    this.b.set(paramInt, paramBarinfo);
    return this;
  }
  
  public PoiBarinfo setBarinfoFree(int paramInt, Barinfo paramBarinfo)
  {
    if (paramBarinfo == null) {
      return this;
    }
    this.a.set(paramInt, paramBarinfo);
    return this;
  }
  
  public PoiBarinfo setBarinfoOther(int paramInt, Barinfo paramBarinfo)
  {
    if (paramBarinfo == null) {
      return this;
    }
    this.c.set(paramInt, paramBarinfo);
    return this;
  }
  
  public PoiBarinfo setExt(String paramString)
  {
    this.f = true;
    this.g = paramString;
    return this;
  }
  
  public PoiBarinfo setType(String paramString)
  {
    this.d = true;
    this.e = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getBarinfoFreeList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Barinfo)localIterator.next());
    }
    localIterator = getBarinfoFetterList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (Barinfo)localIterator.next());
    }
    localIterator = getBarinfoOtherList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (Barinfo)localIterator.next());
    }
    if (hasType()) {
      paramCodedOutputStreamMicro.writeString(4, getType());
    }
    if (hasExt()) {
      paramCodedOutputStreamMicro.writeString(5, getExt());
    }
  }
  
  public static final class Barinfo
    extends MessageMicro
  {
    public static final int ACTION_FIELD_NUMBER = 6;
    public static final int ACTION_TYPE_FIELD_NUMBER = 5;
    public static final int DEFAULT_SELECT_FIELD_NUMBER = 7;
    public static final int FROMSV_FIELD_NUMBER = 8;
    public static final int ICON_ID_FIELD_NUMBER = 1;
    public static final int ICON_URL_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int OPERATION_ICON_URL_FIELD_NUMBER = 3;
    public static final int TOSV_FIELD_NUMBER = 9;
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
    private int n = 0;
    private boolean o;
    private String p = "";
    private boolean q;
    private String r = "";
    private int s = -1;
    
    public static Barinfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Barinfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Barinfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Barinfo)new Barinfo().mergeFrom(paramArrayOfByte);
    }
    
    public final Barinfo clear()
    {
      clearIconId();
      clearIconUrl();
      clearOperationIconUrl();
      clearName();
      clearActionType();
      clearAction();
      clearDefaultSelect();
      clearFromsv();
      clearTosv();
      this.s = -1;
      return this;
    }
    
    public Barinfo clearAction()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Barinfo clearActionType()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Barinfo clearDefaultSelect()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public Barinfo clearFromsv()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public Barinfo clearIconId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Barinfo clearIconUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Barinfo clearName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Barinfo clearOperationIconUrl()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Barinfo clearTosv()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public String getAction()
    {
      return this.l;
    }
    
    public String getActionType()
    {
      return this.j;
    }
    
    public int getCachedSize()
    {
      if (this.s < 0) {
        getSerializedSize();
      }
      return this.s;
    }
    
    public int getDefaultSelect()
    {
      return this.n;
    }
    
    public String getFromsv()
    {
      return this.p;
    }
    
    public String getIconId()
    {
      return this.b;
    }
    
    public String getIconUrl()
    {
      return this.d;
    }
    
    public String getName()
    {
      return this.h;
    }
    
    public String getOperationIconUrl()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasIconId()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getIconId());
      }
      int i1 = i2;
      if (hasIconUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getIconUrl());
      }
      i2 = i1;
      if (hasOperationIconUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getOperationIconUrl());
      }
      i1 = i2;
      if (hasName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getName());
      }
      i2 = i1;
      if (hasActionType()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getActionType());
      }
      i1 = i2;
      if (hasAction()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getAction());
      }
      i2 = i1;
      if (hasDefaultSelect()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getDefaultSelect());
      }
      i1 = i2;
      if (hasFromsv()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getFromsv());
      }
      i2 = i1;
      if (hasTosv()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getTosv());
      }
      this.s = i2;
      return i2;
    }
    
    public String getTosv()
    {
      return this.r;
    }
    
    public boolean hasAction()
    {
      return this.k;
    }
    
    public boolean hasActionType()
    {
      return this.i;
    }
    
    public boolean hasDefaultSelect()
    {
      return this.m;
    }
    
    public boolean hasFromsv()
    {
      return this.o;
    }
    
    public boolean hasIconId()
    {
      return this.a;
    }
    
    public boolean hasIconUrl()
    {
      return this.c;
    }
    
    public boolean hasName()
    {
      return this.g;
    }
    
    public boolean hasOperationIconUrl()
    {
      return this.e;
    }
    
    public boolean hasTosv()
    {
      return this.q;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Barinfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIconId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setOperationIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setActionType(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setAction(paramCodedInputStreamMicro.readString());
          break;
        case 56: 
          setDefaultSelect(paramCodedInputStreamMicro.readInt32());
          break;
        case 66: 
          setFromsv(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setTosv(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Barinfo setAction(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Barinfo setActionType(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Barinfo setDefaultSelect(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public Barinfo setFromsv(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public Barinfo setIconId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Barinfo setIconUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Barinfo setName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Barinfo setOperationIconUrl(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Barinfo setTosv(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIconId()) {
        paramCodedOutputStreamMicro.writeString(1, getIconId());
      }
      if (hasIconUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getIconUrl());
      }
      if (hasOperationIconUrl()) {
        paramCodedOutputStreamMicro.writeString(3, getOperationIconUrl());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(4, getName());
      }
      if (hasActionType()) {
        paramCodedOutputStreamMicro.writeString(5, getActionType());
      }
      if (hasAction()) {
        paramCodedOutputStreamMicro.writeString(6, getAction());
      }
      if (hasDefaultSelect()) {
        paramCodedOutputStreamMicro.writeInt32(7, getDefaultSelect());
      }
      if (hasFromsv()) {
        paramCodedOutputStreamMicro.writeString(8, getFromsv());
      }
      if (hasTosv()) {
        paramCodedOutputStreamMicro.writeString(9, getTosv());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/PoiBarinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */