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

public final class RepHead
  extends MessageMicro
{
  public static final int MD5_FIELD_NUMBER = 1;
  public static final int MESSAGE_HEAD_FIELD_NUMBER = 3;
  public static final int RANGE_FIELD_NUMBER = 2;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private List<MessageHead> e = Collections.emptyList();
  private int f = -1;
  
  public static RepHead parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new RepHead().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static RepHead parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (RepHead)new RepHead().mergeFrom(paramArrayOfByte);
  }
  
  public RepHead addMessageHead(MessageHead paramMessageHead)
  {
    if (paramMessageHead == null) {
      return this;
    }
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(paramMessageHead);
    return this;
  }
  
  public final RepHead clear()
  {
    clearMd5();
    clearRange();
    clearMessageHead();
    this.f = -1;
    return this;
  }
  
  public RepHead clearMd5()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public RepHead clearMessageHead()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public RepHead clearRange()
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
  
  public String getMd5()
  {
    return this.b;
  }
  
  public MessageHead getMessageHead(int paramInt)
  {
    return (MessageHead)this.e.get(paramInt);
  }
  
  public int getMessageHeadCount()
  {
    return this.e.size();
  }
  
  public List<MessageHead> getMessageHeadList()
  {
    return this.e;
  }
  
  public String getRange()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasMd5()) {
      i = 0 + CodedOutputStreamMicro.computeStringSize(1, getMd5());
    }
    int j = i;
    if (hasRange()) {
      j = i + CodedOutputStreamMicro.computeStringSize(2, getRange());
    }
    Iterator localIterator = getMessageHeadList().iterator();
    while (localIterator.hasNext()) {
      j = CodedOutputStreamMicro.computeMessageSize(3, (MessageHead)localIterator.next()) + j;
    }
    this.f = j;
    return j;
  }
  
  public boolean hasMd5()
  {
    return this.a;
  }
  
  public boolean hasRange()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public RepHead mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setMd5(paramCodedInputStreamMicro.readString());
        break;
      case 18: 
        setRange(paramCodedInputStreamMicro.readString());
        break;
      case 26: 
        MessageHead localMessageHead = new MessageHead();
        paramCodedInputStreamMicro.readMessage(localMessageHead);
        addMessageHead(localMessageHead);
      }
    }
  }
  
  public RepHead setMd5(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public RepHead setMessageHead(int paramInt, MessageHead paramMessageHead)
  {
    if (paramMessageHead == null) {
      return this;
    }
    this.e.set(paramInt, paramMessageHead);
    return this;
  }
  
  public RepHead setRange(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasMd5()) {
      paramCodedOutputStreamMicro.writeString(1, getMd5());
    }
    if (hasRange()) {
      paramCodedOutputStreamMicro.writeString(2, getRange());
    }
    Iterator localIterator = getMessageHeadList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (MessageHead)localIterator.next());
    }
  }
  
  public static final class MessageHead
    extends MessageMicro
  {
    public static final int LENGTH_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int OFFSET_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private String f = "";
    private int g = -1;
    
    public static MessageHead parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MessageHead().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MessageHead parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MessageHead)new MessageHead().mergeFrom(paramArrayOfByte);
    }
    
    public final MessageHead clear()
    {
      clearOffset();
      clearLength();
      clearName();
      this.g = -1;
      return this;
    }
    
    public MessageHead clearLength()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public MessageHead clearName()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MessageHead clearOffset()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public int getLength()
    {
      return this.d;
    }
    
    public String getName()
    {
      return this.f;
    }
    
    public int getOffset()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasOffset()) {
        j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getOffset());
      }
      int i = j;
      if (hasLength()) {
        i = j + CodedOutputStreamMicro.computeInt32Size(2, getLength());
      }
      j = i;
      if (hasName()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getName());
      }
      this.g = j;
      return j;
    }
    
    public boolean hasLength()
    {
      return this.c;
    }
    
    public boolean hasName()
    {
      return this.e;
    }
    
    public boolean hasOffset()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MessageHead mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setOffset(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setLength(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setName(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MessageHead setLength(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public MessageHead setName(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MessageHead setOffset(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasOffset()) {
        paramCodedOutputStreamMicro.writeInt32(1, getOffset());
      }
      if (hasLength()) {
        paramCodedOutputStreamMicro.writeInt32(2, getLength());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(3, getName());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/RepHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */