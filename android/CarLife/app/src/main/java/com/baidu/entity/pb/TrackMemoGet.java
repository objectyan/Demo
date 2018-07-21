package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class TrackMemoGet
  extends MessageMicro
{
  public static final int CONTENT_TEXT_FIELD_NUMBER = 1;
  public static final int DATE_FIELD_NUMBER = 2;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private int e = -1;
  
  public static TrackMemoGet parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrackMemoGet().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrackMemoGet parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrackMemoGet)new TrackMemoGet().mergeFrom(paramArrayOfByte);
  }
  
  public final TrackMemoGet clear()
  {
    clearContentText();
    clearDate();
    this.e = -1;
    return this;
  }
  
  public TrackMemoGet clearContentText()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public TrackMemoGet clearDate()
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
  
  public String getContentText()
  {
    return this.b;
  }
  
  public String getDate()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasContentText()) {
      i = 0 + CodedOutputStreamMicro.computeStringSize(1, getContentText());
    }
    int j = i;
    if (hasDate()) {
      j = i + CodedOutputStreamMicro.computeStringSize(2, getDate());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasContentText()
  {
    return this.a;
  }
  
  public boolean hasDate()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrackMemoGet mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setContentText(paramCodedInputStreamMicro.readString());
        break;
      case 18: 
        setDate(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public TrackMemoGet setContentText(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public TrackMemoGet setDate(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasContentText()) {
      paramCodedOutputStreamMicro.writeString(1, getContentText());
    }
    if (hasDate()) {
      paramCodedOutputStreamMicro.writeString(2, getDate());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrackMemoGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */