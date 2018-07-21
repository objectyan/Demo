package com.loopj.android.http;

import cz.msebera.android.httpclient.f;
import java.io.UnsupportedEncodingException;

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
    for (paramArrayOfByte = null;; paramArrayOfByte = new String(paramArrayOfByte, paramString))
    {
      paramString = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        break;
      }
      paramString = paramArrayOfByte;
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
        paramString = null;
      }
    }
    return paramString;
  }
  
  public abstract void onFailure(int paramInt, f[] paramArrayOff, String paramString, Throwable paramThrowable);
  
  public void onFailure(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onFailure(paramInt, paramArrayOff, getResponseString(paramArrayOfByte, getCharset()), paramThrowable);
  }
  
  public abstract void onSuccess(int paramInt, f[] paramArrayOff, String paramString);
  
  public void onSuccess(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOff, getResponseString(paramArrayOfByte, getCharset()));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/TextHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */