package com.tencent.mm.sdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.io.File;
import org.json.JSONObject;

public final class d
  extends AsyncTask<Void, Void, a>
{
  private static final boolean ai;
  private static final String aj;
  private static String ak;
  private String al;
  private String am;
  private OAuthListener an;
  private f ao;
  private String appId;
  private String scope;
  private String signature;
  
  static
  {
    if ((Environment.getExternalStorageState().equals("mounted")) && (new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite())) {}
    for (boolean bool = true;; bool = false)
    {
      ai = bool;
      aj = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png";
      ak = null;
      ak = "http://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
      return;
    }
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    this.appId = paramString1;
    this.scope = paramString2;
    this.al = paramString3;
    this.am = paramString4;
    this.signature = paramString5;
    this.an = paramOAuthListener;
  }
  
  public final boolean q()
  {
    Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
    if (this.ao == null) {
      return cancel(true);
    }
    return this.ao.cancel(true);
  }
  
  static final class a
  {
    public OAuthErrCode ap;
    public String aq;
    public String ar;
    public String as;
    public int at;
    public String au;
    public byte[] av;
    
    /* Error */
    private static boolean a(String paramString, byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: new 30	java/io/FileOutputStream
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 33	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   8: astore_2
      //   9: aload_2
      //   10: astore_0
      //   11: aload_2
      //   12: aload_1
      //   13: invokevirtual 37	java/io/FileOutputStream:write	([B)V
      //   16: aload_2
      //   17: astore_0
      //   18: aload_2
      //   19: invokevirtual 40	java/io/FileOutputStream:flush	()V
      //   22: aload_2
      //   23: invokevirtual 43	java/io/FileOutputStream:close	()V
      //   26: ldc 45
      //   28: ldc 47
      //   30: invokestatic 53	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   33: pop
      //   34: iconst_1
      //   35: ireturn
      //   36: astore_0
      //   37: aload_0
      //   38: invokevirtual 56	java/io/IOException:printStackTrace	()V
      //   41: goto -15 -> 26
      //   44: astore_3
      //   45: aconst_null
      //   46: astore_1
      //   47: aload_1
      //   48: astore_0
      //   49: aload_3
      //   50: invokevirtual 57	java/lang/Exception:printStackTrace	()V
      //   53: aload_1
      //   54: astore_0
      //   55: ldc 45
      //   57: ldc 59
      //   59: invokestatic 62	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   62: pop
      //   63: aload_1
      //   64: ifnull +7 -> 71
      //   67: aload_1
      //   68: invokevirtual 43	java/io/FileOutputStream:close	()V
      //   71: iconst_0
      //   72: ireturn
      //   73: astore_0
      //   74: aload_0
      //   75: invokevirtual 56	java/io/IOException:printStackTrace	()V
      //   78: goto -7 -> 71
      //   81: astore_1
      //   82: aconst_null
      //   83: astore_0
      //   84: aload_0
      //   85: ifnull +7 -> 92
      //   88: aload_0
      //   89: invokevirtual 43	java/io/FileOutputStream:close	()V
      //   92: aload_1
      //   93: athrow
      //   94: astore_0
      //   95: aload_0
      //   96: invokevirtual 56	java/io/IOException:printStackTrace	()V
      //   99: goto -7 -> 92
      //   102: astore_1
      //   103: goto -19 -> 84
      //   106: astore_3
      //   107: aload_2
      //   108: astore_1
      //   109: goto -62 -> 47
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	paramString	String
      //   0	112	1	paramArrayOfByte	byte[]
      //   8	100	2	localFileOutputStream	java.io.FileOutputStream
      //   44	6	3	localException1	Exception
      //   106	1	3	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   22	26	36	java/io/IOException
      //   0	9	44	java/lang/Exception
      //   67	71	73	java/io/IOException
      //   0	9	81	finally
      //   88	92	94	java/io/IOException
      //   11	16	102	finally
      //   18	22	102	finally
      //   49	53	102	finally
      //   55	63	102	finally
      //   11	16	106	java/lang/Exception
      //   18	22	106	java/lang/Exception
    }
    
    public static a d(byte[] paramArrayOfByte)
    {
      a locala = new a();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
        locala.ap = OAuthErrCode.WechatAuth_Err_NetworkErr;
        return locala;
      }
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        try
        {
          paramArrayOfByte = new JSONObject(paramArrayOfByte);
          int i = paramArrayOfByte.getInt("errcode");
          if (i != 0)
          {
            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[] { Integer.valueOf(i) }));
            locala.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
            locala.at = i;
            locala.au = paramArrayOfByte.optString("errmsg");
            return locala;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
          locala.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
          return locala;
        }
        localObject = paramArrayOfByte.getJSONObject("qrcode").getString("qrcodebase64");
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
        locala.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
        return locala;
      }
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
        locala.ap = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
        return locala;
      }
      Object localObject = Base64.decode((String)localObject, 0);
      if ((localObject == null) || (localObject.length == 0))
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
        locala.ap = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
        return locala;
      }
      if (d.r())
      {
        File localFile = new File(d.s());
        localFile.mkdirs();
        if (localFile.exists()) {
          localFile.delete();
        }
        if (!a(d.s(), (byte[])localObject))
        {
          Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("writeToFile fail, qrcodeBuf length = %d", new Object[] { Integer.valueOf(localObject.length) }));
          locala.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
          return locala;
        }
        locala.ap = OAuthErrCode.WechatAuth_Err_OK;
        locala.as = d.s();
        locala.aq = paramArrayOfByte.getString("uuid");
        locala.ar = paramArrayOfByte.getString("appname");
        Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in external storage, uuid = %s, appname = %s, imgPath = %s", new Object[] { locala.aq, locala.ar, locala.as }));
        return locala;
      }
      locala.ap = OAuthErrCode.WechatAuth_Err_OK;
      locala.av = ((byte[])localObject);
      locala.aq = paramArrayOfByte.getString("uuid");
      locala.ar = paramArrayOfByte.getString("appname");
      Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[] { locala.aq, locala.ar, Integer.valueOf(locala.av.length) }));
      return locala;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/diffdev/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */