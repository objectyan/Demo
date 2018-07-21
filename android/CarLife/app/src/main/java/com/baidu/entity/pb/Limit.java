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

public final class Limit
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Content d = null;
  private int e = -1;
  
  public static Limit parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Limit().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Limit parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Limit)new Limit().mergeFrom(paramArrayOfByte);
  }
  
  public final Limit clear()
  {
    clearOption();
    clearContent();
    this.e = -1;
    return this;
  }
  
  public Limit clearContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Limit clearOption()
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
  
  public Content getContent()
  {
    return this.d;
  }
  
  public Option getOption()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasOption()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    int j = i;
    if (hasContent()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(2, getContent());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasContent()
  {
    return this.c;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Limit mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 18: 
        localObject = new Content();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setContent((Content)localObject);
      }
    }
  }
  
  public Limit setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.c = true;
    this.d = paramContent;
    return this;
  }
  
  public Limit setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.a = true;
    this.b = paramOption;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(1, getOption());
    }
    if (hasContent()) {
      paramCodedOutputStreamMicro.writeMessage(2, getContent());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int IS_LIMIT_FIELD_NUMBER = 1;
    public static final int NUM_FIELD_NUMBER = 2;
    private boolean a;
    private boolean b = false;
    private List<Integer> c = Collections.emptyList();
    private int d = -1;
    
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
    
    public Content addNum(int paramInt)
    {
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public final Content clear()
    {
      clearIsLimit();
      clearNum();
      this.d = -1;
      return this;
    }
    
    public Content clearIsLimit()
    {
      this.a = false;
      this.b = false;
      return this;
    }
    
    public Content clearNum()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public boolean getIsLimit()
    {
      return this.b;
    }
    
    public int getNum(int paramInt)
    {
      return ((Integer)this.c.get(paramInt)).intValue();
    }
    
    public int getNumCount()
    {
      return this.c.size();
    }
    
    public List<Integer> getNumList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasIsLimit()) {}
      for (int i = CodedOutputStreamMicro.computeBoolSize(1, getIsLimit()) + 0;; i = 0)
      {
        Iterator localIterator = getNumList().iterator();
        while (localIterator.hasNext()) {
          j += CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue());
        }
        i = i + j + getNumList().size() * 1;
        this.d = i;
        return i;
      }
    }
    
    public boolean hasIsLimit()
    {
      return this.a;
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
        case 8: 
          setIsLimit(paramCodedInputStreamMicro.readBool());
          break;
        case 16: 
          addNum(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Content setIsLimit(boolean paramBoolean)
    {
      this.a = true;
      this.b = paramBoolean;
      return this;
    }
    
    public Content setNum(int paramInt1, int paramInt2)
    {
      this.c.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsLimit()) {
        paramCodedOutputStreamMicro.writeBool(1, getIsLimit());
      }
      Iterator localIterator = getNumList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeInt32(2, ((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int ERR_MSG_FIELD_NUMBER = 2;
    public static final int ERR_NO_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static Option parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Option().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Option parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Option)new Option().mergeFrom(paramArrayOfByte);
    }
    
    public final Option clear()
    {
      clearErrNo();
      clearErrMsg();
      this.e = -1;
      return this;
    }
    
    public Option clearErrMsg()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Option clearErrNo()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public String getErrMsg()
    {
      return this.d;
    }
    
    public int getErrNo()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasErrNo()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getErrNo());
      }
      int j = i;
      if (hasErrMsg()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getErrMsg());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasErrMsg()
    {
      return this.c;
    }
    
    public boolean hasErrNo()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Option mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setErrNo(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setErrMsg(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Option setErrMsg(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Option setErrNo(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasErrNo()) {
        paramCodedOutputStreamMicro.writeInt32(1, getErrNo());
      }
      if (hasErrMsg()) {
        paramCodedOutputStreamMicro.writeString(2, getErrMsg());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Limit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */