package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class TrackMemoAdd
  extends MessageMicro
{
  public static final int CONTENT_TEXT_FIELD_NUMBER = 3;
  public static final int DATE_FIELD_NUMBER = 2;
  public static final int STATUS_FIELD_NUMBER = 1;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private int g = -1;
  
  public static TrackMemoAdd parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrackMemoAdd().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrackMemoAdd parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrackMemoAdd)new TrackMemoAdd().mergeFrom(paramArrayOfByte);
  }
  
  public final TrackMemoAdd clear()
  {
    clearStatus();
    clearDate();
    clearContentText();
    this.g = -1;
    return this;
  }
  
  public TrackMemoAdd clearContentText()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public TrackMemoAdd clearDate()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public TrackMemoAdd clearStatus()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.g < 0) {
      getSerializedSize();
    }
    return this.g;
  }
  
  public String getContentText()
  {
    return this.f;
  }
  
  public String getDate()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    if (hasStatus()) {
      j = 0 + CodedOutputStreamMicro.computeStringSize(1, getStatus());
    }
    int i = j;
    if (hasDate()) {
      i = j + CodedOutputStreamMicro.computeStringSize(2, getDate());
    }
    j = i;
    if (hasContentText()) {
      j = i + CodedOutputStreamMicro.computeStringSize(3, getContentText());
    }
    this.g = j;
    return j;
  }
  
  public String getStatus()
  {
    return this.b;
  }
  
  public boolean hasContentText()
  {
    return this.e;
  }
  
  public boolean hasDate()
  {
    return this.c;
  }
  
  public boolean hasStatus()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrackMemoAdd mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setStatus(paramCodedInputStreamMicro.readString());
        break;
      case 18: 
        setDate(paramCodedInputStreamMicro.readString());
        break;
      case 26: 
        setContentText(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public TrackMemoAdd setContentText(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public TrackMemoAdd setDate(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public TrackMemoAdd setStatus(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasStatus()) {
      paramCodedOutputStreamMicro.writeString(1, getStatus());
    }
    if (hasDate()) {
      paramCodedOutputStreamMicro.writeString(2, getDate());
    }
    if (hasContentText()) {
      paramCodedOutputStreamMicro.writeString(3, getContentText());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrackMemoAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */