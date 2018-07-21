package com.baidu.tts.b.a.b;

import com.baidu.tts.a.a.a;
import com.baidu.tts.a.a.b;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.d;
import com.baidu.tts.f.n;
import com.baidu.tts.h.a.c;
import com.baidu.tts.tools.CommonUtility;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends g
{
  private a<byte[], byte[]> a;
  private f.b b;
  private com.baidu.tts.m.h c;
  
  public h(com.baidu.tts.m.h paramh)
  {
    this.c = paramh;
    this.a = new a();
    paramh = new b();
    this.a.a(paramh);
    this.a.a();
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt(com.baidu.tts.f.g.u.a());
      LoggerProxy.d("TtsResponseHandler", "parseJSON errNo=" + i);
      this.c.a(i);
      if (i != 0)
      {
        paramString = paramString.getString(com.baidu.tts.f.g.v.a());
        paramString = c.a().a(n.g, i, paramString);
        this.c.a(paramString);
        return;
      }
      String str = paramString.optString(com.baidu.tts.f.g.V.a());
      this.c.a(str);
      i = paramString.optInt(com.baidu.tts.f.g.W.a());
      this.c.b(i);
      i = paramString.optInt(com.baidu.tts.f.g.y.b());
      this.c.d(i);
      return;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(HttpEntity paramHttpEntity)
  {
    byte[] arrayOfByte2 = null;
    Object localObject = "--" + "--BD**TTS++LIB";
    for (;;)
    {
      int j;
      byte[] arrayOfByte1;
      int i;
      try
      {
        localObject = ((String)localObject).getBytes("utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        try
        {
          paramHttpEntity = EntityUtils.toByteArray(paramHttpEntity);
          j = CommonUtility.indexOf(paramHttpEntity, (byte[])localObject, 0);
          if (j < 0)
          {
            paramHttpEntity = c.a().b(n.l);
            this.c.a(paramHttpEntity);
            return;
            localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
            localUnsupportedEncodingException1.printStackTrace();
            arrayOfByte1 = null;
            continue;
          }
        }
        catch (IOException paramHttpEntity)
        {
          paramHttpEntity.printStackTrace();
          paramHttpEntity = arrayOfByte2;
          continue;
          i = CommonUtility.indexOf(paramHttpEntity, arrayOfByte1, arrayOfByte1.length + j);
          if (i < 0)
          {
            paramHttpEntity = c.a().b(n.l);
            this.c.a(paramHttpEntity);
            return;
          }
          arrayOfByte2 = CommonUtility.copyBytesOfRange(paramHttpEntity, j + arrayOfByte1.length, i);
        }
      }
      try
      {
        a(new String(arrayOfByte2, "utf-8"));
        j = CommonUtility.indexOf(paramHttpEntity, arrayOfByte1, arrayOfByte1.length + i);
        if (j < 0) {
          continue;
        }
        paramHttpEntity = CommonUtility.copyBytesOfRange(paramHttpEntity, arrayOfByte1.length + i, j);
        this.c.a(paramHttpEntity);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          localUnsupportedEncodingException2.printStackTrace();
        }
      }
    }
  }
  
  private void c(HttpEntity paramHttpEntity)
  {
    Object localObject = null;
    try
    {
      paramHttpEntity = EntityUtils.toString(paramHttpEntity, d.c.a());
      a(paramHttpEntity);
      return;
    }
    catch (ParseException paramHttpEntity)
    {
      for (;;)
      {
        paramHttpEntity.printStackTrace();
        paramHttpEntity = (HttpEntity)localObject;
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        paramHttpEntity.printStackTrace();
        paramHttpEntity = (HttpEntity)localObject;
      }
    }
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString, HttpEntity paramHttpEntity)
  {
    if ("application/json".equals(paramString))
    {
      c(paramHttpEntity);
      return;
    }
    b(paramHttpEntity);
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString, HttpEntity paramHttpEntity, Throwable paramThrowable)
  {
    LoggerProxy.d("TtsResponseHandler", "onFailure error = " + paramThrowable.getMessage());
    paramArrayOfHeader = c.a().a(n.b, paramInt, null, paramThrowable);
    this.c.a(paramArrayOfHeader);
  }
  
  public void a(f.b paramb)
  {
    this.b = paramb;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/b/a/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */