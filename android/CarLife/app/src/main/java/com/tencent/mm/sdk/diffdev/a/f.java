package com.tencent.mm.sdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Log;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import org.json.JSONObject;

final class f
  extends AsyncTask<Void, Void, a>
{
  private OAuthListener an;
  private String aq;
  private int aw;
  private String url;
  
  public f(String paramString, OAuthListener paramOAuthListener)
  {
    this.aq = paramString;
    this.an = paramOAuthListener;
    this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[] { paramString });
  }
  
  static final class a
  {
    public OAuthErrCode ap;
    public String ax;
    public int ay;
    
    public static a e(byte[] paramArrayOfByte)
    {
      a locala = new a();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
        locala.ap = OAuthErrCode.WechatAuth_Err_NetworkErr;
        return locala;
      }
      for (;;)
      {
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
          try
          {
            paramArrayOfByte = new JSONObject(paramArrayOfByte);
            locala.ay = paramArrayOfByte.getInt("wx_errcode");
            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(locala.ay) }));
            switch (locala.ay)
            {
            case 405: 
              locala.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
              return locala;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
            locala.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
            return locala;
          }
          locala.ap = OAuthErrCode.WechatAuth_Err_OK;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
          locala.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
          return locala;
        }
        locala.ax = paramArrayOfByte.getString("wx_code");
        return locala;
        locala.ap = OAuthErrCode.WechatAuth_Err_OK;
        return locala;
        locala.ap = OAuthErrCode.WechatAuth_Err_OK;
        return locala;
        locala.ap = OAuthErrCode.WechatAuth_Err_Timeout;
        return locala;
        locala.ap = OAuthErrCode.WechatAuth_Err_Cancel;
        return locala;
        locala.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
        return locala;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/diffdev/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */