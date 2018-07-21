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

public final class SubwaysCity
  extends MessageMicro
{
  public static final int CITIES_FIELD_NUMBER = 1;
  private List<Cities> a = Collections.emptyList();
  private int b = -1;
  
  public static SubwaysCity parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new SubwaysCity().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static SubwaysCity parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (SubwaysCity)new SubwaysCity().mergeFrom(paramArrayOfByte);
  }
  
  public SubwaysCity addCities(Cities paramCities)
  {
    if (paramCities == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramCities);
    return this;
  }
  
  public final SubwaysCity clear()
  {
    clearCities();
    this.b = -1;
    return this;
  }
  
  public SubwaysCity clearCities()
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
  
  public Cities getCities(int paramInt)
  {
    return (Cities)this.a.get(paramInt);
  }
  
  public int getCitiesCount()
  {
    return this.a.size();
  }
  
  public List<Cities> getCitiesList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getCitiesList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Cities)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public SubwaysCity mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Cities localCities = new Cities();
        paramCodedInputStreamMicro.readMessage(localCities);
        addCities(localCities);
      }
    }
  }
  
  public SubwaysCity setCities(int paramInt, Cities paramCities)
  {
    if (paramCities == null) {
      return this;
    }
    this.a.set(paramInt, paramCities);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getCitiesList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Cities)localIterator.next());
    }
  }
  
  public static final class Cities
    extends MessageMicro
  {
    public static final int CN_NAME_FIELD_NUMBER = 1;
    public static final int CODE_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static Cities parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Cities().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Cities parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Cities)new Cities().mergeFrom(paramArrayOfByte);
    }
    
    public final Cities clear()
    {
      clearCnName();
      clearCode();
      this.e = -1;
      return this;
    }
    
    public Cities clearCnName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Cities clearCode()
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
    
    public String getCnName()
    {
      return this.b;
    }
    
    public String getCode()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasCnName()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
      }
      int j = i;
      if (hasCode()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getCode());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasCnName()
    {
      return this.a;
    }
    
    public boolean hasCode()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Cities mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCnName(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setCode(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Cities setCnName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Cities setCode(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCnName()) {
        paramCodedOutputStreamMicro.writeString(1, getCnName());
      }
      if (hasCode()) {
        paramCodedOutputStreamMicro.writeString(2, getCode());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/SubwaysCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */