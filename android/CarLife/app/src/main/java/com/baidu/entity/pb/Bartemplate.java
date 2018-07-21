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

public final class Bartemplate
  extends MessageMicro
{
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int MIDDLE_FIELD_NUMBER = 2;
  public static final int TAIL_FIELD_NUMBER = 3;
  private boolean a;
  private Head b = null;
  private boolean c;
  private Middle d = null;
  private boolean e;
  private Tail f = null;
  private int g = -1;
  
  public static Bartemplate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Bartemplate().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Bartemplate parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Bartemplate)new Bartemplate().mergeFrom(paramArrayOfByte);
  }
  
  public final Bartemplate clear()
  {
    clearHead();
    clearMiddle();
    clearTail();
    this.g = -1;
    return this;
  }
  
  public Bartemplate clearHead()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public Bartemplate clearMiddle()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Bartemplate clearTail()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.g < 0) {
      getSerializedSize();
    }
    return this.g;
  }
  
  public Head getHead()
  {
    return this.b;
  }
  
  public Middle getMiddle()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    if (hasHead()) {
      j = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHead());
    }
    int i = j;
    if (hasMiddle()) {
      i = j + CodedOutputStreamMicro.computeMessageSize(2, getMiddle());
    }
    j = i;
    if (hasTail()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(3, getTail());
    }
    this.g = j;
    return j;
  }
  
  public Tail getTail()
  {
    return this.f;
  }
  
  public boolean hasHead()
  {
    return this.a;
  }
  
  public boolean hasMiddle()
  {
    return this.c;
  }
  
  public boolean hasTail()
  {
    return this.e;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Bartemplate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Head();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setHead((Head)localObject);
        break;
      case 18: 
        localObject = new Middle();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setMiddle((Middle)localObject);
        break;
      case 26: 
        localObject = new Tail();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setTail((Tail)localObject);
      }
    }
  }
  
  public Bartemplate setHead(Head paramHead)
  {
    if (paramHead == null) {
      return clearHead();
    }
    this.a = true;
    this.b = paramHead;
    return this;
  }
  
  public Bartemplate setMiddle(Middle paramMiddle)
  {
    if (paramMiddle == null) {
      return clearMiddle();
    }
    this.c = true;
    this.d = paramMiddle;
    return this;
  }
  
  public Bartemplate setTail(Tail paramTail)
  {
    if (paramTail == null) {
      return clearTail();
    }
    this.e = true;
    this.f = paramTail;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasHead()) {
      paramCodedOutputStreamMicro.writeMessage(1, getHead());
    }
    if (hasMiddle()) {
      paramCodedOutputStreamMicro.writeMessage(2, getMiddle());
    }
    if (hasTail()) {
      paramCodedOutputStreamMicro.writeMessage(3, getTail());
    }
  }
  
  public static final class Head
    extends MessageMicro
  {
    public static final int LABEL_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static Head parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Head().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Head parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Head)new Head().mergeFrom(paramArrayOfByte);
    }
    
    public final Head clear()
    {
      clearTitle();
      clearLabel();
      this.e = -1;
      return this;
    }
    
    public Head clearLabel()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Head clearTitle()
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
    
    public String getLabel()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasTitle()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      int j = i;
      if (hasLabel()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getLabel());
      }
      this.e = j;
      return j;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public boolean hasLabel()
    {
      return this.c;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Head mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setLabel(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Head setLabel(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Head setTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(1, getTitle());
      }
      if (hasLabel()) {
        paramCodedOutputStreamMicro.writeString(2, getLabel());
      }
    }
  }
  
  public static final class Middle
    extends MessageMicro
  {
    public static final int DESC_FIELD_NUMBER = 2;
    public static final int RATE_FIELD_NUMBER = 1;
    public static final int TEXT_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private int g = -1;
    
    public static Middle parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Middle().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Middle parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Middle)new Middle().mergeFrom(paramArrayOfByte);
    }
    
    public final Middle clear()
    {
      clearRate();
      clearDesc();
      clearText();
      this.g = -1;
      return this;
    }
    
    public Middle clearDesc()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Middle clearRate()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Middle clearText()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public String getDesc()
    {
      return this.d;
    }
    
    public String getRate()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasRate()) {
        j = 0 + CodedOutputStreamMicro.computeStringSize(1, getRate());
      }
      int i = j;
      if (hasDesc()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getDesc());
      }
      j = i;
      if (hasText()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getText());
      }
      this.g = j;
      return j;
    }
    
    public String getText()
    {
      return this.f;
    }
    
    public boolean hasDesc()
    {
      return this.c;
    }
    
    public boolean hasRate()
    {
      return this.a;
    }
    
    public boolean hasText()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Middle mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setRate(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setDesc(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setText(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Middle setDesc(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Middle setRate(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Middle setText(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasRate()) {
        paramCodedOutputStreamMicro.writeString(1, getRate());
      }
      if (hasDesc()) {
        paramCodedOutputStreamMicro.writeString(2, getDesc());
      }
      if (hasText()) {
        paramCodedOutputStreamMicro.writeString(3, getText());
      }
    }
  }
  
  public static final class Tail
    extends MessageMicro
  {
    public static final int DESC_FIELD_NUMBER = 2;
    public static final int ICON_ID_FIELD_NUMBER = 1;
    private List<Integer> a = Collections.emptyList();
    private boolean b;
    private String c = "";
    private int d = -1;
    
    public static Tail parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Tail().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Tail parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Tail)new Tail().mergeFrom(paramArrayOfByte);
    }
    
    public Tail addIconId(int paramInt)
    {
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public final Tail clear()
    {
      clearIconId();
      clearDesc();
      this.d = -1;
      return this;
    }
    
    public Tail clearDesc()
    {
      this.b = false;
      this.c = "";
      return this;
    }
    
    public Tail clearIconId()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public String getDesc()
    {
      return this.c;
    }
    
    public int getIconId(int paramInt)
    {
      return ((Integer)this.a.get(paramInt)).intValue();
    }
    
    public int getIconIdCount()
    {
      return this.a.size();
    }
    
    public List<Integer> getIconIdList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getIconIdList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
      int j = 0 + i + getIconIdList().size() * 1;
      i = j;
      if (hasDesc()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getDesc());
      }
      this.d = i;
      return i;
    }
    
    public boolean hasDesc()
    {
      return this.b;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Tail mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          addIconId(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setDesc(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Tail setDesc(String paramString)
    {
      this.b = true;
      this.c = paramString;
      return this;
    }
    
    public Tail setIconId(int paramInt1, int paramInt2)
    {
      this.a.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getIconIdList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeInt32(1, ((Integer)localIterator.next()).intValue());
      }
      if (hasDesc()) {
        paramCodedOutputStreamMicro.writeString(2, getDesc());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Bartemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */