package com.baidu.carlife.k.a;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.i;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e
{
  public static final int RESPONSE_DATA_ERROR = -4;
  public static final int RESPONSE_DATA_NULL = -3;
  public static final int RESPONSE_DELETE_NOT_HAVE_RECORD_ERROR = 56;
  public static final int RESPONSE_ERROR = -1;
  public static final int RESPONSE_ERROR_NONETWORK = -2;
  public static final int RESPONSE_GET_ALL_RECORD_ERROR = 53;
  public static final int RESPONSE_REPEAT_ADD_ERROR = 54;
  public static final int RESPONSE_SERVER_LINE_ERROR = 51;
  public static final int RESPONSE_SUCCESS = 0;
  private static ImageLoader mImageLoader;
  private static RequestQueue mQueue;
  private final String filterTag = "NetWork#";
  private String mErrMsg;
  private int mErrNo = -1;
  private a mListener;
  private d mPostParams;
  private c mRequest;
  private long mRequestId;
  private boolean shouldCache = false;
  private String signKey = "sign";
  protected String tag = e.class.getSimpleName();
  private boolean urlSignNeed;
  
  public e()
  {
    this(BaiduNaviApplication.getInstance(), null, false);
  }
  
  public e(Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public e(Context paramContext, String paramString)
  {
    this(paramContext, paramString, true);
  }
  
  private e(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (mQueue == null) {
      mQueue = Volley.newRequestQueue(paramContext);
    }
    this.signKey = paramString;
    this.urlSignNeed = paramBoolean;
  }
  
  private void closeInputSteams()
  {
    if (this.mPostParams != null) {
      this.mPostParams.closeInputSteams();
    }
  }
  
  private String generateUrl()
  {
    return getUrl() + d.getUrlParamsString(getUrlParams(), this.urlSignNeed, this.signKey);
  }
  
  public static ImageLoader getImageLoader()
  {
    if (mQueue == null) {
      return null;
    }
    if (mImageLoader == null) {
      mImageLoader = new ImageLoader(mQueue, new a());
    }
    return mImageLoader;
  }
  
  private int parseError(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("code"))
    {
      this.mErrNo = paramJSONObject.getInt("code");
      if (!paramJSONObject.has("errmsg")) {
        break label129;
      }
      this.mErrMsg = paramJSONObject.getString("errmsg");
    }
    for (;;)
    {
      return this.mErrNo;
      if (paramJSONObject.has("errno"))
      {
        this.mErrNo = paramJSONObject.getInt("errno");
        break;
      }
      if (paramJSONObject.has("status"))
      {
        this.mErrNo = paramJSONObject.getInt("status");
        break;
      }
      if (!paramJSONObject.has("result")) {
        break;
      }
      JSONObject localJSONObject = paramJSONObject.optJSONObject("result");
      if ((localJSONObject == null) || (!localJSONObject.has("error"))) {
        break;
      }
      this.mErrNo = localJSONObject.getInt("error");
      break;
      label129:
      if (paramJSONObject.has("message")) {
        this.mErrMsg = paramJSONObject.getString("message");
      }
    }
  }
  
  private void parseResponse(String paramString)
  {
    reponseNoJsonCallBack(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      responseErrorCallBack(-1);
      notifyResponseListener(-1);
      return;
    }
    int i;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject(paramString);
        i = parseError(localJSONObject);
        if (i != 0) {
          break;
        }
        if (localJSONObject.has("data"))
        {
          i = responseSuccessCallBack(localJSONObject.getString("data"));
          notifyResponseListener(i);
          return;
        }
      }
      catch (JSONException paramString)
      {
        i.e("NetWork#" + this.tag, "The Response throw JSONException");
        responseErrorCallBack(-1);
        notifyResponseListener(-1);
        return;
      }
      if (localJSONObject.has("sync")) {
        i = responseSuccessCallBack(localJSONObject.getJSONObject("sync").toString());
      } else {
        i = responseSuccessCallBack(paramString);
      }
    }
    for (;;)
    {
      notifyResponseListener(responseSuccessCallBack(paramString));
      return;
      do
      {
        responseErrorCallBack(-1);
        notifyResponseListener(-1);
        return;
        if ((i == 53) || (i == 56) || (i == 54)) {
          break;
        }
      } while (i != 51);
    }
  }
  
  public void cancel()
  {
    if (this.mRequest != null) {
      this.mRequest.cancel();
    }
  }
  
  public String getErrMsg()
  {
    return this.mErrMsg;
  }
  
  public int getErrNo()
  {
    return this.mErrNo;
  }
  
  protected d getPostRequestParams()
  {
    return null;
  }
  
  protected abstract String getUrl();
  
  protected d getUrlParams()
  {
    return null;
  }
  
  public boolean isThisRequest()
  {
    return this.mRequestId == this.mRequest.a();
  }
  
  public void notifyResponseListener(int paramInt)
  {
    if (this.mListener != null) {
      this.mListener.onNetWorkResponse(paramInt);
    }
  }
  
  public void registerResponseListener(a parama)
  {
    this.mListener = parama;
  }
  
  public void reponseNoJsonCallBack(String paramString) {}
  
  protected void responseErrorCallBack(int paramInt) {}
  
  protected abstract int responseSuccessCallBack(String paramString)
    throws JSONException;
  
  public void setShouldCache(boolean paramBoolean)
  {
    this.shouldCache = paramBoolean;
  }
  
  public void toGetRequest()
  {
    toRequest(0);
  }
  
  public void toPostRequest()
  {
    toRequest(1);
  }
  
  public void toRequest(int paramInt)
  {
    this.mPostParams = getPostRequestParams();
    this.mRequest = new c(paramInt, generateUrl(), this.mPostParams, new c(null), new b(null), this.shouldCache, "NetWork#" + this.tag);
    this.mRequestId = this.mRequest.a();
    mQueue.add(this.mRequest);
  }
  
  public static abstract interface a
  {
    public abstract void onNetWorkResponse(int paramInt);
  }
  
  private class b
    implements Response.ErrorListener
  {
    private b() {}
    
    public void onErrorResponse(VolleyError paramVolleyError)
    {
      e.this.closeInputSteams();
      if (com.baidu.carlife.core.e.a().r())
      {
        e.this.reponseNoJsonCallBack(null);
        e.this.responseErrorCallBack(-1);
        e.this.notifyResponseListener(-1);
        return;
      }
      e.this.responseErrorCallBack(-2);
      e.this.notifyResponseListener(-2);
    }
  }
  
  private class c
    implements Response.Listener<String>
  {
    private c() {}
    
    public void a(String paramString)
    {
      i.b("NetWork#" + e.this.tag, "The Response is:" + paramString);
      e.this.closeInputSteams();
      e.this.parseResponse(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */