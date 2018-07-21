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

public final class FavoriteData
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 3;
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int MSG_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private List<Data> e = Collections.emptyList();
  private int f = -1;
  
  public static FavoriteData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new FavoriteData().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static FavoriteData parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (FavoriteData)new FavoriteData().mergeFrom(paramArrayOfByte);
  }
  
  public FavoriteData addData(Data paramData)
  {
    if (paramData == null) {
      return this;
    }
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(paramData);
    return this;
  }
  
  public final FavoriteData clear()
  {
    clearError();
    clearMsg();
    clearData();
    this.f = -1;
    return this;
  }
  
  public FavoriteData clearData()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public FavoriteData clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public FavoriteData clearMsg()
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
  
  public Data getData(int paramInt)
  {
    return (Data)this.e.get(paramInt);
  }
  
  public int getDataCount()
  {
    return this.e.size();
  }
  
  public List<Data> getDataList()
  {
    return this.e;
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
    int i = 0;
    if (hasError()) {
      i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
    }
    int j = i;
    if (hasMsg()) {
      j = i + CodedOutputStreamMicro.computeStringSize(2, getMsg());
    }
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      j = CodedOutputStreamMicro.computeMessageSize(3, (Data)localIterator.next()) + j;
    }
    this.f = j;
    return j;
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
  
  public FavoriteData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        addData(localData);
      }
    }
  }
  
  public FavoriteData setData(int paramInt, Data paramData)
  {
    if (paramData == null) {
      return this;
    }
    this.e.set(paramInt, paramData);
    return this;
  }
  
  public FavoriteData setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public FavoriteData setMsg(String paramString)
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
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (Data)localIterator.next());
    }
  }
  
  public static final class Data
    extends MessageMicro
  {
    public static final int DETAILS_FIELD_NUMBER = 2;
    public static final int SUBKEY_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<Details> c = Collections.emptyList();
    private int d = -1;
    
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
    
    public Data addDetails(Details paramDetails)
    {
      if (paramDetails == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramDetails);
      return this;
    }
    
    public final Data clear()
    {
      clearSubkey();
      clearDetails();
      this.d = -1;
      return this;
    }
    
    public Data clearDetails()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public Data clearSubkey()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public Details getDetails(int paramInt)
    {
      return (Details)this.c.get(paramInt);
    }
    
    public int getDetailsCount()
    {
      return this.c.size();
    }
    
    public List<Details> getDetailsList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasSubkey()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSubkey());
      }
      Iterator localIterator = getDetailsList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (Details)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public String getSubkey()
    {
      return this.b;
    }
    
    public boolean hasSubkey()
    {
      return this.a;
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
          setSubkey(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          Details localDetails = new Details();
          paramCodedInputStreamMicro.readMessage(localDetails);
          addDetails(localDetails);
        }
      }
    }
    
    public Data setDetails(int paramInt, Details paramDetails)
    {
      if (paramDetails == null) {
        return this;
      }
      this.c.set(paramInt, paramDetails);
      return this;
    }
    
    public Data setSubkey(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasSubkey()) {
        paramCodedOutputStreamMicro.writeString(1, getSubkey());
      }
      Iterator localIterator = getDetailsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Details)localIterator.next());
      }
    }
    
    public static final class Details
      extends MessageMicro
    {
      public static final int CTIME_FIELD_NUMBER = 4;
      public static final int DO_COUNT_FIELD_NUMBER = 3;
      public static final int IF_DO_FIELD_NUMBER = 2;
      public static final int THEME_ID_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private int i = -1;
      
      public static Details parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Details().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Details parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Details)new Details().mergeFrom(paramArrayOfByte);
      }
      
      public final Details clear()
      {
        clearThemeId();
        clearIfDo();
        clearDoCount();
        clearCtime();
        this.i = -1;
        return this;
      }
      
      public Details clearCtime()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Details clearDoCount()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Details clearIfDo()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Details clearThemeId()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public String getCtime()
      {
        return this.h;
      }
      
      public String getDoCount()
      {
        return this.f;
      }
      
      public String getIfDo()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasThemeId()) {
          k = 0 + CodedOutputStreamMicro.computeStringSize(1, getThemeId());
        }
        int j = k;
        if (hasIfDo()) {
          j = k + CodedOutputStreamMicro.computeStringSize(2, getIfDo());
        }
        k = j;
        if (hasDoCount()) {
          k = j + CodedOutputStreamMicro.computeStringSize(3, getDoCount());
        }
        j = k;
        if (hasCtime()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getCtime());
        }
        this.i = j;
        return j;
      }
      
      public String getThemeId()
      {
        return this.b;
      }
      
      public boolean hasCtime()
      {
        return this.g;
      }
      
      public boolean hasDoCount()
      {
        return this.e;
      }
      
      public boolean hasIfDo()
      {
        return this.c;
      }
      
      public boolean hasThemeId()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Details mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setThemeId(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setIfDo(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setDoCount(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setCtime(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Details setCtime(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Details setDoCount(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Details setIfDo(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Details setThemeId(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasThemeId()) {
          paramCodedOutputStreamMicro.writeString(1, getThemeId());
        }
        if (hasIfDo()) {
          paramCodedOutputStreamMicro.writeString(2, getIfDo());
        }
        if (hasDoCount()) {
          paramCodedOutputStreamMicro.writeString(3, getDoCount());
        }
        if (hasCtime()) {
          paramCodedOutputStreamMicro.writeString(4, getCtime());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/FavoriteData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */