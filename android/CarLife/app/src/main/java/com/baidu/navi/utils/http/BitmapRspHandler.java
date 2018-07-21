package com.baidu.navi.utils.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

public abstract class BitmapRspHandler
  extends BaseRspHandler
{
  protected void handleResponse(HttpResponse paramHttpResponse)
  {
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    if (localStatusLine.getStatusCode() != 200) {
      handleFailureMessage(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()));
    }
    for (;;)
    {
      return;
      localStatusLine = null;
      try
      {
        paramHttpResponse = EntityUtils.toByteArray(paramHttpResponse.getEntity());
        if (paramHttpResponse == null) {
          continue;
        }
        handleSuccessMessage(BitmapFactory.decodeByteArray(paramHttpResponse, 0, paramHttpResponse.length));
        return;
      }
      catch (IOException paramHttpResponse)
      {
        for (;;)
        {
          handleFailureMessage(paramHttpResponse);
          paramHttpResponse = localStatusLine;
        }
      }
    }
  }
  
  public abstract void onRevBitmap(Bitmap paramBitmap);
  
  public void onSuccess(Object paramObject)
  {
    onRevBitmap((Bitmap)paramObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/http/BitmapRspHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */