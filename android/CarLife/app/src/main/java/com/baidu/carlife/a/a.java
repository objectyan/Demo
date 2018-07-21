package com.baidu.carlife.a;

import android.os.Message;
import android.util.Base64;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.protobuf.CarlifeAuthenResponseProto.CarlifeAuthenResponse;
import com.baidu.carlife.protobuf.CarlifeAuthenResponseProto.CarlifeAuthenResponse.Builder;
import com.baidu.carlife.protobuf.CarlifeAuthenResultProto.CarlifeAuthenResult;
import com.baidu.carlife.protobuf.CarlifeAuthenResultProto.CarlifeAuthenResult.Builder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static a b;
  private static final String c = "_00.00.00";
  private static final String d = "RSA/ECB/PKCS1Padding";
  private static final String e = "0.0.0";
  private static final String f = "1.1.0";
  private static final String h = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALzoBR3Io5wxQH+IMy0ekUE50s9ZOEPOI/y3bSwXSZEqU0EgDGVRnFBYhr8MSEkv2THTn5HKsUM3gHd3rpQhRG2JrcaFY+iIEJs2iueXvfKd8UqTUFQOZrc7xCz1npg4KResY4VAEN+W19ez/DsKiCS5LaxmwE844xWibTgjspY9AgMBAAECgYA7C/cVcTKaztZPRr5gWw6iKbXYNBYfM58SDi+kuX64TleJor/dJ55JivJLY0ZxAfDM304gXw/7Z6zTKui5ypA9duYu1Pohk/e5UUMFr0+cEyWzTjCJp/XaA/gEhH8g311qeWcALSo6q55vYtTJpc/OUn98nlsrOMv4XLgaBI2fwQJBAPBw7TkR4Xuvue2tfxh2Fn2x2ONJSRjckS7EipfdLSsgZCbwdQ2XL/k6VX0lMfQaLQQ6YCF/vrALlgkXFBuzFpECQQDJIWJGcoM95ms546hHBzu7DONmEpEh9b9nMEqRmOkzkitxvGApv1VjvZaX6gMrSANADmoz4lSTGXFea4nviJLtAkEA29v3H4NZMveJxWsrV5vLjx5MG/FMdP5jh2dS7/DgN5pD2lNwRYAk7vnHaErVtccluMMEWj1siZ/ejutaiMWm8QJBAIMM+4nHZ3hXwJoRmj3dmq/AMBL8GhC0nShRMOU5awmtPh13jnjlMHAywgLt+W6kF2oPemegG1dVhqbtDw1CQekCQH3xugE28LS6e29233PUBdipwoyRcbDeth70WDS3l4bl7XlWbTXOWF/D28ZZ49NSr1dRhAQwM8VVC/gHdvNpcqA=";
  private PrivateKey g;
  
  private a()
  {
    try
    {
      this.g = d("MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALzoBR3Io5wxQH+IMy0ekUE50s9ZOEPOI/y3bSwXSZEqU0EgDGVRnFBYhr8MSEkv2THTn5HKsUM3gHd3rpQhRG2JrcaFY+iIEJs2iueXvfKd8UqTUFQOZrc7xCz1npg4KResY4VAEN+W19ez/DsKiCS5LaxmwE844xWibTgjspY9AgMBAAECgYA7C/cVcTKaztZPRr5gWw6iKbXYNBYfM58SDi+kuX64TleJor/dJ55JivJLY0ZxAfDM304gXw/7Z6zTKui5ypA9duYu1Pohk/e5UUMFr0+cEyWzTjCJp/XaA/gEhH8g311qeWcALSo6q55vYtTJpc/OUn98nlsrOMv4XLgaBI2fwQJBAPBw7TkR4Xuvue2tfxh2Fn2x2ONJSRjckS7EipfdLSsgZCbwdQ2XL/k6VX0lMfQaLQQ6YCF/vrALlgkXFBuzFpECQQDJIWJGcoM95ms546hHBzu7DONmEpEh9b9nMEqRmOkzkitxvGApv1VjvZaX6gMrSANADmoz4lSTGXFea4nviJLtAkEA29v3H4NZMveJxWsrV5vLjx5MG/FMdP5jh2dS7/DgN5pD2lNwRYAk7vnHaErVtccluMMEWj1siZ/ejutaiMWm8QJBAIMM+4nHZ3hXwJoRmj3dmq/AMBL8GhC0nShRMOU5awmtPh13jnjlMHAywgLt+W6kF2oPemegG1dVhqbtDw1CQekCQH3xugE28LS6e29233PUBdipwoyRcbDeth70WDS3l4bl7XlWbTXOWF/D28ZZ49NSr1dRhAQwM8VVC/gHdvNpcqA=");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static a a()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  private String a(Key paramKey)
    throws Exception
  {
    return Base64.encodeToString(paramKey.getEncoded(), 2);
  }
  
  private byte[] a(String paramString, byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
    throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
  {
    paramString = Cipher.getInstance(paramString);
    paramString.init(1, paramPrivateKey);
    paramString.update(paramArrayOfByte);
    return paramString.doFinal();
  }
  
  private String c(String paramString)
  {
    Object localObject2 = e.g();
    Object localObject1 = localObject2;
    if (((String)localObject2).equals("0.0.0")) {
      localObject1 = "1.1.0";
    }
    i.b(a, "currentAppVersion= " + (String)localObject1);
    localObject2 = ((String)localObject1).split("\\.");
    localObject1 = paramString.substring(paramString.indexOf("_"));
    String str2 = paramString.replace((CharSequence)localObject1, "");
    String[] arrayOfString = ((String)localObject1).replace("_", "").split("\\.");
    if (localObject2.length == arrayOfString.length)
    {
      int i = 0;
      for (;;)
      {
        localObject1 = paramString;
        if (i >= localObject2.length) {
          break;
        }
        try
        {
          if (Integer.parseInt(arrayOfString[i]) > Integer.parseInt(localObject2[i])) {
            return str2 + "_00.00.00";
          }
          int j = Integer.parseInt(arrayOfString[i]);
          int k = Integer.parseInt(localObject2[i]);
          localObject1 = paramString;
          if (j < k) {
            break;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        i += 1;
      }
    }
    String str1 = str2 + "_00.00.00";
    return str1;
  }
  
  private PrivateKey d(String paramString)
    throws Exception
  {
    paramString = new PKCS8EncodedKeySpec(Base64.decode(paramString, 2));
    return KeyFactory.getInstance("RSA").generatePrivate(paramString);
  }
  
  public void a(String paramString)
  {
    Object localObject = c(paramString);
    paramString = null;
    try
    {
      localObject = Base64.encodeToString(a("RSA/ECB/PKCS1Padding", ((String)localObject).getBytes("UTF-8"), this.g), 2);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        CarlifeAuthenResponseProto.CarlifeAuthenResponse.Builder localBuilder;
        localException.printStackTrace();
      }
    }
    localObject = new c(true);
    ((c)localObject).c(65609);
    localBuilder = CarlifeAuthenResponseProto.CarlifeAuthenResponse.newBuilder();
    localBuilder.setEncryptValue(paramString);
    paramString = localBuilder.build();
    ((c)localObject).b(paramString.toByteArray());
    ((c)localObject).d(paramString.getSerializedSize());
    paramString = Message.obtain(null, ((c)localObject).d(), 1001, 0, localObject);
    com.baidu.carlife.l.a.a().a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = new c(true);
    ((c)localObject1).c(65611);
    Object localObject2 = CarlifeAuthenResultProto.CarlifeAuthenResult.newBuilder();
    ((CarlifeAuthenResultProto.CarlifeAuthenResult.Builder)localObject2).setAuthenResult(paramBoolean);
    localObject2 = ((CarlifeAuthenResultProto.CarlifeAuthenResult.Builder)localObject2).build();
    ((c)localObject1).b(((CarlifeAuthenResultProto.CarlifeAuthenResult)localObject2).toByteArray());
    ((c)localObject1).d(((CarlifeAuthenResultProto.CarlifeAuthenResult)localObject2).getSerializedSize());
    localObject1 = Message.obtain(null, ((c)localObject1).d(), 1001, 0, localObject1);
    com.baidu.carlife.l.a.a().a((Message)localObject1);
  }
  
  public String b(String paramString)
  {
    paramString = c(paramString);
    try
    {
      paramString = Base64.encodeToString(a("RSA/ECB/PKCS1Padding", paramString.getBytes("UTF-8"), this.g), 2);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */