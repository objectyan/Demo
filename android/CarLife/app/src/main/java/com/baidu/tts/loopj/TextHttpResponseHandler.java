package com.baidu.tts.loopj;

import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

public abstract class TextHttpResponseHandler
  extends AsyncHttpResponseHandler
{
  private static final String LOG_TAG = "TextHttpRH";
  
  public TextHttpResponseHandler()
  {
    this("UTF-8");
  }
  
  public TextHttpResponseHandler(String paramString)
  {
    setCharset(paramString);
  }
  
  public static String getResponseString(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {}
    for (paramArrayOfByte = null; paramArrayOfByte != null; paramArrayOfByte = new String(paramArrayOfByte, paramString)) {
      try
      {
        if (!paramArrayOfByte.startsWith("﻿")) {
          break;
        }
        return paramArrayOfByte.substring(1);
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        AsyncHttpClient.log.e("TextHttpRH", "Encoding response into string failed", paramArrayOfByte);
        return null;
      }
    }
    return paramArrayOfByte;
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable);
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onFailure(paramInt, paramArrayOfHeader, getResponseString(paramArrayOfByte, getCharset()), paramThrowable);
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString);
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOfHeader, getResponseString(paramArrayOfByte, getCharset()));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/TextHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */