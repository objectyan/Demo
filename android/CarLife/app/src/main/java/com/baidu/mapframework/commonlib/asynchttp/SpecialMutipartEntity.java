package com.baidu.mapframework.commonlib.asynchttp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SpecialMutipartEntity
  extends SimpleMultipartEntity
{
  public SpecialMutipartEntity(ResponseHandlerInterface paramResponseHandlerInterface)
  {
    super(paramResponseHandlerInterface);
  }
  
  public void addSpecialPart(String paramString, InputStream paramInputStream)
    throws IOException
  {
    this.out.write(this.boundaryLine);
    this.out.write(createContentDisposition(paramString));
    this.out.write(CR_LF);
    paramString = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(paramString);
      if (i == -1) {
        break;
      }
      this.out.write(paramString, 0, i);
    }
    this.out.write(CR_LF);
    this.out.flush();
    AsyncHttpClient.silentCloseOutputStream(this.out);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/SpecialMutipartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */