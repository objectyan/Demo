package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class LiveShare
  extends MessageMicro
{
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int MSG_FIELD_NUMBER = 2;
  public static final int SHARE_FIELD_NUMBER = 3;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private boolean e;
  private Share f = null;
  private int g = -1;
  
  public static LiveShare parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new LiveShare().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static LiveShare parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (LiveShare)new LiveShare().mergeFrom(paramArrayOfByte);
  }
  
  public final LiveShare clear()
  {
    clearError();
    clearMsg();
    clearShare();
    this.g = -1;
    return this;
  }
  
  public LiveShare clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public LiveShare clearMsg()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public LiveShare clearShare()
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
    if (hasShare()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(3, getShare());
    }
    this.g = j;
    return j;
  }
  
  public Share getShare()
  {
    return this.f;
  }
  
  public boolean hasError()
  {
    return this.a;
  }
  
  public boolean hasMsg()
  {
    return this.c;
  }
  
  public boolean hasShare()
  {
    return this.e;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public LiveShare mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        Share localShare = new Share();
        paramCodedInputStreamMicro.readMessage(localShare);
        setShare(localShare);
      }
    }
  }
  
  public LiveShare setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public LiveShare setMsg(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public LiveShare setShare(Share paramShare)
  {
    if (paramShare == null) {
      return clearShare();
    }
    this.e = true;
    this.f = paramShare;
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
    if (hasShare()) {
      paramCodedOutputStreamMicro.writeMessage(3, getShare());
    }
  }
  
  public static final class Share
    extends MessageMicro
  {
    public static final int BIGICON_FIELD_NUMBER = 6;
    public static final int LONGCONTENT_FIELD_NUMBER = 4;
    public static final int SHORTCONTENT_FIELD_NUMBER = 3;
    public static final int SMALLICON_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
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
    
    public static Share parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Share().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Share parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Share)new Share().mergeFrom(paramArrayOfByte);
    }
    
    public final Share clear()
    {
      clearUrl();
      clearTitle();
      clearShortcontent();
      clearLongcontent();
      clearSmallicon();
      clearBigicon();
      this.m = -1;
      return this;
    }
    
    public Share clearBigicon()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Share clearLongcontent()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Share clearShortcontent()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Share clearSmallicon()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Share clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Share clearUrl()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public String getBigicon()
    {
      return this.l;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public String getLongcontent()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasUrl()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
      }
      int n = i1;
      if (hasTitle()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      i1 = n;
      if (hasShortcontent()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getShortcontent());
      }
      n = i1;
      if (hasLongcontent()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getLongcontent());
      }
      i1 = n;
      if (hasSmallicon()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getSmallicon());
      }
      n = i1;
      if (hasBigicon()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getBigicon());
      }
      this.m = n;
      return n;
    }
    
    public String getShortcontent()
    {
      return this.f;
    }
    
    public String getSmallicon()
    {
      return this.j;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public String getUrl()
    {
      return this.b;
    }
    
    public boolean hasBigicon()
    {
      return this.k;
    }
    
    public boolean hasLongcontent()
    {
      return this.g;
    }
    
    public boolean hasShortcontent()
    {
      return this.e;
    }
    
    public boolean hasSmallicon()
    {
      return this.i;
    }
    
    public boolean hasTitle()
    {
      return this.c;
    }
    
    public boolean hasUrl()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Share mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setUrl(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setShortcontent(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setLongcontent(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setSmallicon(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setBigicon(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Share setBigicon(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Share setLongcontent(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Share setShortcontent(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Share setSmallicon(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Share setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Share setUrl(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasUrl()) {
        paramCodedOutputStreamMicro.writeString(1, getUrl());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
      if (hasShortcontent()) {
        paramCodedOutputStreamMicro.writeString(3, getShortcontent());
      }
      if (hasLongcontent()) {
        paramCodedOutputStreamMicro.writeString(4, getLongcontent());
      }
      if (hasSmallicon()) {
        paramCodedOutputStreamMicro.writeString(5, getSmallicon());
      }
      if (hasBigicon()) {
        paramCodedOutputStreamMicro.writeString(6, getBigicon());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/LiveShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */