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

public final class Livehome
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
  
  public static Livehome parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Livehome().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Livehome parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Livehome)new Livehome().mergeFrom(paramArrayOfByte);
  }
  
  public Livehome addData(Data paramData)
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
  
  public final Livehome clear()
  {
    clearError();
    clearMsg();
    clearData();
    this.f = -1;
    return this;
  }
  
  public Livehome clearData()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public Livehome clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public Livehome clearMsg()
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
  
  public Livehome mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
  
  public Livehome setData(int paramInt, Data paramData)
  {
    if (paramData == null) {
      return this;
    }
    this.e.set(paramInt, paramData);
    return this;
  }
  
  public Livehome setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public Livehome setMsg(String paramString)
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
    public static final int DESC_FIELD_NUMBER = 2;
    public static final int LATEST_FIELD_NUMBER = 3;
    public static final int PLANID_FIELD_NUMBER = 6;
    public static final int PRESENT_FIELD_NUMBER = 4;
    public static final int STAMP_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private int m = -1;
    
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
      clearTitle();
      clearDesc();
      clearLatest();
      clearPresent();
      clearStamp();
      clearPlanid();
      this.m = -1;
      return this;
    }
    
    public Data clearDesc()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Data clearLatest()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Data clearPlanid()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Data clearPresent()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Data clearStamp()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Data clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public String getDesc()
    {
      return this.d;
    }
    
    public String getLatest()
    {
      return this.f;
    }
    
    public String getPlanid()
    {
      return this.l;
    }
    
    public String getPresent()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasTitle()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      int n = i1;
      if (hasDesc()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getDesc());
      }
      i1 = n;
      if (hasLatest()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getLatest());
      }
      n = i1;
      if (hasPresent()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getPresent());
      }
      i1 = n;
      if (hasStamp()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getStamp());
      }
      n = i1;
      if (hasPlanid()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getPlanid());
      }
      this.m = n;
      return n;
    }
    
    public String getStamp()
    {
      return this.j;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public boolean hasDesc()
    {
      return this.c;
    }
    
    public boolean hasLatest()
    {
      return this.e;
    }
    
    public boolean hasPlanid()
    {
      return this.k;
    }
    
    public boolean hasPresent()
    {
      return this.g;
    }
    
    public boolean hasStamp()
    {
      return this.i;
    }
    
    public boolean hasTitle()
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
        int n = paramCodedInputStreamMicro.readTag();
        switch (n)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setDesc(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setLatest(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setPresent(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setStamp(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setPlanid(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Data setDesc(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Data setLatest(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Data setPlanid(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Data setPresent(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Data setStamp(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Data setTitle(String paramString)
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
      if (hasDesc()) {
        paramCodedOutputStreamMicro.writeString(2, getDesc());
      }
      if (hasLatest()) {
        paramCodedOutputStreamMicro.writeString(3, getLatest());
      }
      if (hasPresent()) {
        paramCodedOutputStreamMicro.writeString(4, getPresent());
      }
      if (hasStamp()) {
        paramCodedOutputStreamMicro.writeString(5, getStamp());
      }
      if (hasPlanid()) {
        paramCodedOutputStreamMicro.writeString(6, getPlanid());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Livehome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */