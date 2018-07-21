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

public final class BdIcon
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 1;
  private List<Content> a = Collections.emptyList();
  private int b = -1;
  
  public static BdIcon parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new BdIcon().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static BdIcon parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (BdIcon)new BdIcon().mergeFrom(paramArrayOfByte);
  }
  
  public BdIcon addContent(Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramContent);
    return this;
  }
  
  public final BdIcon clear()
  {
    clearContent();
    this.b = -1;
    return this;
  }
  
  public BdIcon clearContent()
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
  
  public Content getContent(int paramInt)
  {
    return (Content)this.a.get(paramInt);
  }
  
  public int getContentCount()
  {
    return this.a.size();
  }
  
  public List<Content> getContentList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getContentList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Content)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public BdIcon mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Content localContent = new Content();
        paramCodedInputStreamMicro.readMessage(localContent);
        addContent(localContent);
      }
    }
  }
  
  public BdIcon setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.a.set(paramInt, paramContent);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Content)localIterator.next());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int DATA_TYPE_FIELD_NUMBER = 1;
    public static final int FLAG_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static Content parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Content().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Content parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Content)new Content().mergeFrom(paramArrayOfByte);
    }
    
    public final Content clear()
    {
      clearDataType();
      clearFlag();
      this.e = -1;
      return this;
    }
    
    public Content clearDataType()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearFlag()
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
    
    public String getDataType()
    {
      return this.b;
    }
    
    public String getFlag()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasDataType()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDataType());
      }
      int j = i;
      if (hasFlag()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getFlag());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasDataType()
    {
      return this.a;
    }
    
    public boolean hasFlag()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Content mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setDataType(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setFlag(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Content setDataType(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setFlag(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasDataType()) {
        paramCodedOutputStreamMicro.writeString(1, getDataType());
      }
      if (hasFlag()) {
        paramCodedOutputStreamMicro.writeString(2, getFlag());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/BdIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */