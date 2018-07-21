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

public final class Carddetail
  extends MessageMicro
{
  public static final int MEISHI_FIELD_NUMBER = 1;
  private boolean a;
  private Meishi b = null;
  private int c = -1;
  
  public static Carddetail parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Carddetail().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Carddetail parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Carddetail)new Carddetail().mergeFrom(paramArrayOfByte);
  }
  
  public final Carddetail clear()
  {
    clearMeishi();
    this.c = -1;
    return this;
  }
  
  public Carddetail clearMeishi()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.c < 0) {
      getSerializedSize();
    }
    return this.c;
  }
  
  public Meishi getMeishi()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasMeishi()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMeishi());
    }
    this.c = i;
    return i;
  }
  
  public boolean hasMeishi()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Carddetail mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Meishi localMeishi = new Meishi();
        paramCodedInputStreamMicro.readMessage(localMeishi);
        setMeishi(localMeishi);
      }
    }
  }
  
  public Carddetail setMeishi(Meishi paramMeishi)
  {
    if (paramMeishi == null) {
      return clearMeishi();
    }
    this.a = true;
    this.b = paramMeishi;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasMeishi()) {
      paramCodedOutputStreamMicro.writeMessage(1, getMeishi());
    }
  }
  
  public static final class Meishi
    extends MessageMicro
  {
    public static final int BUSINESS_SCOPE_FIELD_NUMBER = 2;
    public static final int BUSINESS_SCOPE_TYPE_FIELD_NUMBER = 1;
    private List<BusinessScope> a = Collections.emptyList();
    private boolean b;
    private String c = "";
    private int d = -1;
    
    public static Meishi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Meishi().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Meishi parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Meishi)new Meishi().mergeFrom(paramArrayOfByte);
    }
    
    public Meishi addBusinessScope(BusinessScope paramBusinessScope)
    {
      if (paramBusinessScope == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramBusinessScope);
      return this;
    }
    
    public final Meishi clear()
    {
      clearBusinessScope();
      clearBusinessScopeType();
      this.d = -1;
      return this;
    }
    
    public Meishi clearBusinessScope()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public Meishi clearBusinessScopeType()
    {
      this.b = false;
      this.c = "";
      return this;
    }
    
    public BusinessScope getBusinessScope(int paramInt)
    {
      return (BusinessScope)this.a.get(paramInt);
    }
    
    public int getBusinessScopeCount()
    {
      return this.a.size();
    }
    
    public List<BusinessScope> getBusinessScopeList()
    {
      return this.a;
    }
    
    public String getBusinessScopeType()
    {
      return this.c;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasBusinessScopeType()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getBusinessScopeType());
      }
      Iterator localIterator = getBusinessScopeList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (BusinessScope)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasBusinessScopeType()
    {
      return this.b;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Meishi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setBusinessScopeType(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          BusinessScope localBusinessScope = new BusinessScope();
          paramCodedInputStreamMicro.readMessage(localBusinessScope);
          addBusinessScope(localBusinessScope);
        }
      }
    }
    
    public Meishi setBusinessScope(int paramInt, BusinessScope paramBusinessScope)
    {
      if (paramBusinessScope == null) {
        return this;
      }
      this.a.set(paramInt, paramBusinessScope);
      return this;
    }
    
    public Meishi setBusinessScopeType(String paramString)
    {
      this.b = true;
      this.c = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasBusinessScopeType()) {
        paramCodedOutputStreamMicro.writeString(1, getBusinessScopeType());
      }
      Iterator localIterator = getBusinessScopeList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (BusinessScope)localIterator.next());
      }
    }
    
    public static final class BusinessScope
      extends MessageMicro
    {
      public static final int NAME_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private int c = -1;
      
      public static BusinessScope parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new BusinessScope().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static BusinessScope parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (BusinessScope)new BusinessScope().mergeFrom(paramArrayOfByte);
      }
      
      public final BusinessScope clear()
      {
        clearName();
        this.c = -1;
        return this;
      }
      
      public BusinessScope clearName()
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
      
      public String getName()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasName()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
        }
        this.c = i;
        return i;
      }
      
      public boolean hasName()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public BusinessScope mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setName(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public BusinessScope setName(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasName()) {
          paramCodedOutputStreamMicro.writeString(1, getName());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Carddetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */