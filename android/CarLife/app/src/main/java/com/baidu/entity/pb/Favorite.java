package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Favorite
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
  
  public static Favorite parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Favorite().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Favorite parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Favorite)new Favorite().mergeFrom(paramArrayOfByte);
  }
  
  public final Favorite clear()
  {
    clearError();
    clearMsg();
    clearData();
    this.g = -1;
    return this;
  }
  
  public Favorite clearData()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public Favorite clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public Favorite clearMsg()
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
  
  public Favorite mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
  
  public Favorite setData(Data paramData)
  {
    if (paramData == null) {
      return clearData();
    }
    this.e = true;
    this.f = paramData;
    return this;
  }
  
  public Favorite setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public Favorite setMsg(String paramString)
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
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int THEME_ID_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private int d = 0;
    private int e = -1;
    
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
    
    public final Data clear()
    {
      clearThemeId();
      clearStatus();
      this.e = -1;
      return this;
    }
    
    public Data clearStatus()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Data clearThemeId()
    {
      this.a = false;
      this.b = "";
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
      if (hasThemeId()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThemeId());
      }
      int j = i;
      if (hasStatus()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(2, getStatus());
      }
      this.e = j;
      return j;
    }
    
    public int getStatus()
    {
      return this.d;
    }
    
    public String getThemeId()
    {
      return this.b;
    }
    
    public boolean hasStatus()
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
          setThemeId(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setStatus(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Data setStatus(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Data setThemeId(String paramString)
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
      if (hasStatus()) {
        paramCodedOutputStreamMicro.writeInt32(2, getStatus());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Favorite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */