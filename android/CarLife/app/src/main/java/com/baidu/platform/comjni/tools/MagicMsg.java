package com.baidu.platform.comjni.tools;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public class MagicMsg
  extends MessageMicro
{
  public byte[] buffer;
  
  public int getCachedSize()
  {
    return 0;
  }
  
  public int getSerializedSize()
  {
    return 0;
  }
  
  public MessageMicro mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return null;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/tools/MagicMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */