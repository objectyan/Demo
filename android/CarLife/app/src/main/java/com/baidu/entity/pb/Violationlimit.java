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

public final class Violationlimit
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 3;
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int MSG_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private boolean e;
  private Data f = null;
  private int g = -1;
  
  public static Violationlimit parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Violationlimit().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Violationlimit parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Violationlimit)new Violationlimit().mergeFrom(paramArrayOfByte);
  }
  
  public final Violationlimit clear()
  {
    clearError();
    clearMsg();
    clearData();
    this.g = -1;
    return this;
  }
  
  public Violationlimit clearData()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public Violationlimit clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public Violationlimit clearMsg()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.g < 0) {
      getSerializedSize();
    }
    return this.g;
  }
  
  public Data getData()
  {
    return this.f;
  }
  
  public int getError()
  {
    return this.b;
  }
  
  public String getMsg()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    if (hasError()) {
      j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
    }
    int i = j;
    if (hasMsg()) {
      i = j + CodedOutputStreamMicro.computeStringSize(2, getMsg());
    }
    j = i;
    if (hasData()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(3, getData());
    }
    this.g = j;
    return j;
  }
  
  public boolean hasData()
  {
    return this.e;
  }
  
  public boolean hasError()
  {
    return this.a;
  }
  
  public boolean hasMsg()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Violationlimit mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setError(paramCodedInputStreamMicro.readInt32());
        break;
      case 18: 
        setMsg(paramCodedInputStreamMicro.readString());
        break;
      case 26: 
        Data localData = new Data();
        paramCodedInputStreamMicro.readMessage(localData);
        setData(localData);
      }
    }
  }
  
  public Violationlimit setData(Data paramData)
  {
    if (paramData == null) {
      return clearData();
    }
    this.e = true;
    this.f = paramData;
    return this;
  }
  
  public Violationlimit setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public Violationlimit setMsg(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasError()) {
      paramCodedOutputStreamMicro.writeInt32(1, getError());
    }
    if (hasMsg()) {
      paramCodedOutputStreamMicro.writeString(2, getMsg());
    }
    if (hasData()) {
      paramCodedOutputStreamMicro.writeMessage(3, getData());
    }
  }
  
  public static final class Data
    extends MessageMicro
  {
    public static final int LISTS_FIELD_NUMBER = 1;
    private List<Lists> a = Collections.emptyList();
    private int b = -1;
    
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
    
    public Data addLists(Lists paramLists)
    {
      if (paramLists == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramLists);
      return this;
    }
    
    public final Data clear()
    {
      clearLists();
      this.b = -1;
      return this;
    }
    
    public Data clearLists()
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
    
    public Lists getLists(int paramInt)
    {
      return (Lists)this.a.get(paramInt);
    }
    
    public int getListsCount()
    {
      return this.a.size();
    }
    
    public List<Lists> getListsList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getListsList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Lists)localIterator.next()) + i) {}
      this.b = i;
      return i;
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
        case 10: 
          Lists localLists = new Lists();
          paramCodedInputStreamMicro.readMessage(localLists);
          addLists(localLists);
        }
      }
    }
    
    public Data setLists(int paramInt, Lists paramLists)
    {
      if (paramLists == null) {
        return this;
      }
      this.a.set(paramInt, paramLists);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getListsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (Lists)localIterator.next());
      }
    }
    
    public static final class Lists
      extends MessageMicro
    {
      public static final int CITYID_FIELD_NUMBER = 1;
      public static final int EXT_FIELD_NUMBER = 3;
      public static final int LIMITNUM_FIELD_NUMBER = 2;
      private boolean a;
      private int b = 0;
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private int g = -1;
      
      public static Lists parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Lists().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Lists parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Lists)new Lists().mergeFrom(paramArrayOfByte);
      }
      
      public final Lists clear()
      {
        clearCityId();
        clearLimitNum();
        clearExt();
        this.g = -1;
        return this;
      }
      
      public Lists clearCityId()
      {
        this.a = false;
        this.b = 0;
        return this;
      }
      
      public Lists clearExt()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Lists clearLimitNum()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.g < 0) {
          getSerializedSize();
        }
        return this.g;
      }
      
      public int getCityId()
      {
        return this.b;
      }
      
      public String getExt()
      {
        return this.f;
      }
      
      public String getLimitNum()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        if (hasCityId()) {
          j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCityId());
        }
        int i = j;
        if (hasLimitNum()) {
          i = j + CodedOutputStreamMicro.computeStringSize(2, getLimitNum());
        }
        j = i;
        if (hasExt()) {
          j = i + CodedOutputStreamMicro.computeStringSize(3, getExt());
        }
        this.g = j;
        return j;
      }
      
      public boolean hasCityId()
      {
        return this.a;
      }
      
      public boolean hasExt()
      {
        return this.e;
      }
      
      public boolean hasLimitNum()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Lists mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setCityId(paramCodedInputStreamMicro.readInt32());
            break;
          case 18: 
            setLimitNum(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setExt(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Lists setCityId(int paramInt)
      {
        this.a = true;
        this.b = paramInt;
        return this;
      }
      
      public Lists setExt(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Lists setLimitNum(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasCityId()) {
          paramCodedOutputStreamMicro.writeInt32(1, getCityId());
        }
        if (hasLimitNum()) {
          paramCodedOutputStreamMicro.writeString(2, getLimitNum());
        }
        if (hasExt()) {
          paramCodedOutputStreamMicro.writeString(3, getExt());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Violationlimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */