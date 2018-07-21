package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class SpecialResult
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 1;
  private boolean a;
  private Content b = null;
  private int c = -1;
  
  public static SpecialResult parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new SpecialResult().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static SpecialResult parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (SpecialResult)new SpecialResult().mergeFrom(paramArrayOfByte);
  }
  
  public final SpecialResult clear()
  {
    clearContent();
    this.c = -1;
    return this;
  }
  
  public SpecialResult clearContent()
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
  
  public Content getContent()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasContent()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getContent());
    }
    this.c = i;
    return i;
  }
  
  public boolean hasContent()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public SpecialResult mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setContent(localContent);
      }
    }
  }
  
  public SpecialResult setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.a = true;
    this.b = paramContent;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasContent()) {
      paramCodedOutputStreamMicro.writeMessage(1, getContent());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private int g = -1;
    
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
      clearX();
      clearY();
      clearLevel();
      this.g = -1;
      return this;
    }
    
    public Content clearLevel()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public Content clearX()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Content clearY()
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
    
    public int getLevel()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasX()) {
        j = 0 + CodedOutputStreamMicro.computeStringSize(1, getX());
      }
      int i = j;
      if (hasY()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getY());
      }
      j = i;
      if (hasLevel()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getLevel());
      }
      this.g = j;
      return j;
    }
    
    public String getX()
    {
      return this.b;
    }
    
    public String getY()
    {
      return this.d;
    }
    
    public boolean hasLevel()
    {
      return this.e;
    }
    
    public boolean hasX()
    {
      return this.a;
    }
    
    public boolean hasY()
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
          setX(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setY(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setLevel(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Content setLevel(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public Content setX(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Content setY(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasX()) {
        paramCodedOutputStreamMicro.writeString(1, getX());
      }
      if (hasY()) {
        paramCodedOutputStreamMicro.writeString(2, getY());
      }
      if (hasLevel()) {
        paramCodedOutputStreamMicro.writeInt32(3, getLevel());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/SpecialResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */