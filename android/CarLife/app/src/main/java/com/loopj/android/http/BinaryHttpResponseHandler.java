package com.loopj.android.http;

import android.os.Looper;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.b.l;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class BinaryHttpResponseHandler
  extends AsyncHttpResponseHandler
{
  private static final String LOG_TAG = "BinaryHttpRH";
  private String[] mAllowedContentTypes = { "application/octet-stream", "image/jpeg", "image/png", "image/gif" };
  
  public BinaryHttpResponseHandler() {}
  
  public BinaryHttpResponseHandler(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.mAllowedContentTypes = paramArrayOfString;
      return;
    }
    AsyncHttpClient.log.e("BinaryHttpRH", "Constructor passed allowedContentTypes was null !");
  }
  
  public BinaryHttpResponseHandler(String[] paramArrayOfString, Looper paramLooper)
  {
    super(paramLooper);
    if (paramArrayOfString != null)
    {
      this.mAllowedContentTypes = paramArrayOfString;
      return;
    }
    AsyncHttpClient.log.e("BinaryHttpRH", "Constructor passed allowedContentTypes was null !");
  }
  
  public String[] getAllowedContentTypes()
  {
    return this.mAllowedContentTypes;
  }
  
  public abstract void onFailure(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public abstract void onSuccess(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte);
  
  public final void sendResponseMessage(x paramx)
    throws IOException
  {
    int i = 0;
    an localan = paramx.a();
    Object localObject = paramx.getHeaders("Content-Type");
    if (localObject.length != 1)
    {
      sendFailureMessage(localan.b(), paramx.getAllHeaders(), null, new l(localan.b(), "None, or more than one, Content-Type Header found!"));
      return;
    }
    localObject = localObject[0];
    int j = 0;
    String[] arrayOfString = getAllowedContentTypes();
    int k = arrayOfString.length;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      try
      {
        boolean bool = Pattern.matches(str, ((f)localObject).d());
        if (bool) {
          j = 1;
        }
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        for (;;)
        {
          AsyncHttpClient.log.e("BinaryHttpRH", "Given pattern is not valid: " + str, localPatternSyntaxException);
        }
      }
      i += 1;
    }
    if (j == 0)
    {
      sendFailureMessage(localan.b(), paramx.getAllHeaders(), null, new l(localan.b(), "Content-Type (" + ((f)localObject).d() + ") not allowed!"));
      return;
    }
    super.sendResponseMessage(paramx);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/BinaryHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */