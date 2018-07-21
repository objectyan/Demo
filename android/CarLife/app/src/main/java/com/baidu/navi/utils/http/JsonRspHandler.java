package com.baidu.navi.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class JsonRspHandler
  extends BaseRspHandler
{
  private static final String CHARSET = "UTF-8";
  private String mCharset = "UTF-8";
  
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
        paramHttpResponse = EntityUtils.toString(paramHttpResponse.getEntity(), this.mCharset);
        localStatusLine = null;
      }
      catch (Exception paramHttpResponse)
      {
        try
        {
          paramHttpResponse = new JSONObject(paramHttpResponse);
          if (paramHttpResponse == null) {
            continue;
          }
          handleSuccessMessage(paramHttpResponse);
          return;
          paramHttpResponse = paramHttpResponse;
          handleFailureMessage(paramHttpResponse);
          paramHttpResponse = localStatusLine;
        }
        catch (Exception paramHttpResponse)
        {
          for (;;)
          {
            handleFailureMessage(paramHttpResponse);
            paramHttpResponse = localStatusLine;
          }
        }
      }
    }
  }
  
  public void setCharset(String paramString)
  {
    this.mCharset = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/http/JsonRspHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */