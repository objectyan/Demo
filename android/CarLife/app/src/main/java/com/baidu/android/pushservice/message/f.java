package com.baidu.android.pushservice.message;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.pushservice.j;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.k.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public class f
  extends d
{
  private com.baidu.android.pushservice.j.h b;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  private byte[] a(long paramLong, g paramg)
  {
    // Byte code:
    //   0: new 19	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 22	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: new 24	com/baidu/android/pushservice/j/i
    //   12: dup
    //   13: aload 5
    //   15: invokespecial 27	com/baidu/android/pushservice/j/i:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 4
    //   20: aload 4
    //   22: lload_1
    //   23: invokevirtual 30	com/baidu/android/pushservice/j/i:a	(J)V
    //   26: aload 4
    //   28: aload_3
    //   29: invokevirtual 35	com/baidu/android/pushservice/message/g:a	()I
    //   32: invokevirtual 38	com/baidu/android/pushservice/j/i:b	(I)V
    //   35: aload 4
    //   37: iconst_0
    //   38: invokevirtual 38	com/baidu/android/pushservice/j/i:b	(I)V
    //   41: aload_3
    //   42: invokevirtual 41	com/baidu/android/pushservice/message/g:b	()[B
    //   45: ifnull +12 -> 57
    //   48: aload 4
    //   50: aload_3
    //   51: invokevirtual 41	com/baidu/android/pushservice/message/g:b	()[B
    //   54: invokevirtual 44	com/baidu/android/pushservice/j/i:a	([B)V
    //   57: aload 5
    //   59: invokevirtual 47	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   62: astore_3
    //   63: aload 5
    //   65: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   68: aload 4
    //   70: invokevirtual 52	com/baidu/android/pushservice/j/i:a	()V
    //   73: aload_3
    //   74: areturn
    //   75: astore_3
    //   76: aload 5
    //   78: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   81: aload 4
    //   83: invokevirtual 52	com/baidu/android/pushservice/j/i:a	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_3
    //   89: aload 5
    //   91: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   94: aload 4
    //   96: invokevirtual 52	com/baidu/android/pushservice/j/i:a	()V
    //   99: aload_3
    //   100: athrow
    //   101: astore 5
    //   103: goto -35 -> 68
    //   106: astore 4
    //   108: aload_3
    //   109: areturn
    //   110: astore_3
    //   111: goto -30 -> 81
    //   114: astore_3
    //   115: goto -29 -> 86
    //   118: astore 5
    //   120: goto -26 -> 94
    //   123: astore 4
    //   125: goto -26 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	f
    //   0	128	1	paramLong	long
    //   0	128	3	paramg	g
    //   18	77	4	locali	com.baidu.android.pushservice.j.i
    //   106	1	4	localIOException1	IOException
    //   123	1	4	localIOException2	IOException
    //   7	83	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   101	1	5	localIOException3	IOException
    //   118	1	5	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   20	57	75	java/lang/Exception
    //   57	63	75	java/lang/Exception
    //   20	57	88	finally
    //   57	63	88	finally
    //   63	68	101	java/io/IOException
    //   68	73	106	java/io/IOException
    //   76	81	110	java/io/IOException
    //   81	86	114	java/io/IOException
    //   89	94	118	java/io/IOException
    //   94	99	123	java/io/IOException
  }
  
  private byte[] a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    if (paramString != null)
    {
      paramString = paramString.getBytes();
      System.arraycopy(paramString, 0, arrayOfByte, 0, Math.min(arrayOfByte.length, paramString.length));
    }
    return arrayOfByte;
  }
  
  /* Error */
  private byte[] a(short paramShort, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 19	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 22	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: new 24	com/baidu/android/pushservice/j/i
    //   12: dup
    //   13: aload 5
    //   15: invokespecial 27	com/baidu/android/pushservice/j/i:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 6
    //   20: aload_2
    //   21: ifnull +194 -> 215
    //   24: aload_2
    //   25: arraylength
    //   26: istore_3
    //   27: aload 6
    //   29: iload_1
    //   30: invokevirtual 73	com/baidu/android/pushservice/j/i:a	(I)V
    //   33: iload_1
    //   34: getstatic 79	com/baidu/android/pushservice/message/h:f	Lcom/baidu/android/pushservice/message/h;
    //   37: invokevirtual 82	com/baidu/android/pushservice/message/h:a	()S
    //   40: if_icmpeq +90 -> 130
    //   43: iload_1
    //   44: getstatic 85	com/baidu/android/pushservice/message/h:g	Lcom/baidu/android/pushservice/message/h;
    //   47: invokevirtual 82	com/baidu/android/pushservice/message/h:a	()S
    //   50: if_icmpeq +80 -> 130
    //   53: aload 6
    //   55: invokestatic 88	com/baidu/android/pushservice/a:a	()S
    //   58: invokevirtual 73	com/baidu/android/pushservice/j/i:a	(I)V
    //   61: aload 6
    //   63: iconst_0
    //   64: invokevirtual 38	com/baidu/android/pushservice/j/i:b	(I)V
    //   67: aload_0
    //   68: getfield 91	com/baidu/android/pushservice/message/f:a	Landroid/content/Context;
    //   71: aload_0
    //   72: getfield 91	com/baidu/android/pushservice/message/f:a	Landroid/content/Context;
    //   75: invokevirtual 97	android/content/Context:getPackageName	()Ljava/lang/String;
    //   78: invokestatic 103	com/baidu/android/pushservice/j/p:e	(Landroid/content/Context;Ljava/lang/String;)Z
    //   81: ifeq +74 -> 155
    //   84: ldc 105
    //   86: astore 4
    //   88: aload 6
    //   90: aload_0
    //   91: aload 4
    //   93: bipush 16
    //   95: invokespecial 107	com/baidu/android/pushservice/message/f:a	(Ljava/lang/String;I)[B
    //   98: invokevirtual 44	com/baidu/android/pushservice/j/i:a	([B)V
    //   101: aload 6
    //   103: ldc 108
    //   105: invokevirtual 38	com/baidu/android/pushservice/j/i:b	(I)V
    //   108: aload 6
    //   110: iconst_1
    //   111: invokevirtual 38	com/baidu/android/pushservice/j/i:b	(I)V
    //   114: aload 6
    //   116: iload_3
    //   117: invokevirtual 38	com/baidu/android/pushservice/j/i:b	(I)V
    //   120: aload_2
    //   121: ifnull +9 -> 130
    //   124: aload 6
    //   126: aload_2
    //   127: invokevirtual 44	com/baidu/android/pushservice/j/i:a	([B)V
    //   130: aload 5
    //   132: invokevirtual 47	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   135: astore_2
    //   136: iconst_1
    //   137: anewarray 110	java/io/Closeable
    //   140: dup
    //   141: iconst_0
    //   142: aload 5
    //   144: aastore
    //   145: invokestatic 115	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   148: aload 6
    //   150: invokevirtual 52	com/baidu/android/pushservice/j/i:a	()V
    //   153: aload_2
    //   154: areturn
    //   155: ldc 117
    //   157: astore 4
    //   159: goto -71 -> 88
    //   162: astore_2
    //   163: iconst_1
    //   164: anewarray 110	java/io/Closeable
    //   167: dup
    //   168: iconst_0
    //   169: aload 5
    //   171: aastore
    //   172: invokestatic 115	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   175: aload 6
    //   177: invokevirtual 52	com/baidu/android/pushservice/j/i:a	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_2
    //   183: iconst_1
    //   184: anewarray 110	java/io/Closeable
    //   187: dup
    //   188: iconst_0
    //   189: aload 5
    //   191: aastore
    //   192: invokestatic 115	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   195: aload 6
    //   197: invokevirtual 52	com/baidu/android/pushservice/j/i:a	()V
    //   200: aload_2
    //   201: athrow
    //   202: astore 4
    //   204: aload_2
    //   205: areturn
    //   206: astore_2
    //   207: goto -27 -> 180
    //   210: astore 4
    //   212: goto -12 -> 200
    //   215: iconst_0
    //   216: istore_3
    //   217: goto -190 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	f
    //   0	220	1	paramShort	short
    //   0	220	2	paramArrayOfByte	byte[]
    //   26	191	3	i	int
    //   86	72	4	str	String
    //   202	1	4	localException1	Exception
    //   210	1	4	localException2	Exception
    //   7	183	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   18	178	6	locali	com.baidu.android.pushservice.j.i
    // Exception table:
    //   from	to	target	type
    //   27	84	162	java/lang/Exception
    //   88	120	162	java/lang/Exception
    //   124	130	162	java/lang/Exception
    //   130	136	162	java/lang/Exception
    //   27	84	182	finally
    //   88	120	182	finally
    //   124	130	182	finally
    //   130	136	182	finally
    //   148	153	202	java/lang/Exception
    //   175	180	206	java/lang/Exception
    //   195	200	210	java/lang/Exception
  }
  
  private String d()
  {
    try
    {
      switch (p.t(this.a))
      {
      case 4: 
        return "4g";
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
    return "wifi";
    return "2g";
    return "3g";
  }
  
  private String e()
  {
    try
    {
      Object localObject = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
      int i = ((Display)localObject).getWidth();
      int j = ((Display)localObject).getHeight();
      localObject = j + "_" + i;
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String f()
  {
    try
    {
      String str = ((TelephonyManager)this.a.getSystemService("phone")).getSimOperator();
      if (str != null)
      {
        if ((str.equals("46000")) || (str.equals("46002")) || (str.equals("46007"))) {
          break label77;
        }
        if (str.equals("46001")) {
          return "uni";
        }
        if (str.equals("46003")) {
          return "ct";
        }
      }
    }
    catch (Exception localException) {}
    return null;
    label77:
    return "cm";
  }
  
  private String g()
  {
    try
    {
      if (p.u(this.a, "android.permission.READ_PHONE_STATE"))
      {
        String str = ((TelephonyManager)this.a.getSystemService("phone")).getSubscriberId();
        return str;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
  
  private String h()
  {
    try
    {
      String str = ((WifiManager)this.a.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public e a(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    paramInt = 20480;
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    this.b = new com.baidu.android.pushservice.j.h(localByteArrayInputStream);
    short s = this.b.c();
    e locale = new e(s);
    if ((s == h.g.a()) || (s == h.f.a()))
    {
      if (localByteArrayInputStream != null) {
        localByteArrayInputStream.close();
      }
      if (this.b != null) {
        this.b.a();
      }
      return locale;
    }
    this.b.c();
    this.b.b();
    paramArrayOfByte = new byte[16];
    this.b.a(paramArrayOfByte);
    this.b.b();
    this.b.b();
    int i = this.b.b();
    if (i > 0) {
      if (i > 20480)
      {
        paramArrayOfByte = new byte[paramInt];
        this.b.a(paramArrayOfByte);
      }
    }
    for (;;)
    {
      locale.c = paramArrayOfByte;
      localByteArrayInputStream.close();
      if (this.b != null) {
        this.b.a();
      }
      return locale;
      paramInt = i;
      break;
      paramArrayOfByte = null;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = new JSONObject();
    localObject1 = null;
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("channel_token", j.a(this.a).b());
        ((JSONObject)localObject2).put("channel_id", j.a(this.a).a());
        ((JSONObject)localObject2).put("sa_mode", com.baidu.android.pushservice.c.d.a(this.a).b());
        ((JSONObject)localObject2).put("highest_version", com.baidu.android.pushservice.c.d.a(this.a).d());
        ((JSONObject)localObject2).put("period", 1800);
        ((JSONObject)localObject2).put("channel_type", 3);
        ((JSONObject)localObject2).put("tinyheart", 1);
        if (!p.F(this.a)) {
          continue;
        }
        ((JSONObject)localObject2).put("connect_version", 3);
        Object localObject3 = Build.MANUFACTURER;
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).length() <= 128)) {
          ((JSONObject)localObject2).put("manufacture", localObject3);
        }
        ((JSONObject)localObject2).put("tiny_msghead", 1);
        ((JSONObject)localObject2).put("alarm_function", 1);
        localObject3 = new JSONObject();
        String str = Build.MODEL;
        if ((str != null) && (str != "")) {
          ((JSONObject)localObject3).put("model", str);
        }
        str = f();
        if ((str != null) && (str != "")) {
          ((JSONObject)localObject3).put("carrier", str);
        }
        str = e();
        if ((str != null) && (str != "")) {
          ((JSONObject)localObject3).put("resolution", str);
        }
        str = d();
        if ((str != null) && (str != "")) {
          ((JSONObject)localObject3).put("network", str);
        }
        str = h();
        if ((str != null) && (str != "")) {
          ((JSONObject)localObject3).put("mac", str);
        }
        str = com.baidu.android.pushservice.k.e.a(this.a);
        if ((str != null) && (str != "")) {
          ((JSONObject)localObject3).put("cuid", str);
        }
        str = g();
        if ((str != null) && (str != "")) {
          ((JSONObject)localObject3).put("imsi", str);
        }
        paramInt = ((JSONObject)localObject3).toString().length();
        ((JSONObject)localObject2).put("devinfo", b.a(BaiduAppSSOJni.encryptAES(((JSONObject)localObject3).toString(), 1), "utf-8"));
        ((JSONObject)localObject2).put("devinfolength", paramInt);
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        continue;
        localObject1 = a(h.b.a(), ((String)localObject1).getBytes());
        e locale = new e(h.b.a());
        locale.c = ((byte[])localObject1);
        locale.d = true;
        locale.a(false);
        a(locale);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        continue;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        continue;
      }
      return;
      ((JSONObject)localObject2).put("connect_version", 2);
    }
  }
  
  public void b() {}
  
  public void b(e parame)
    throws Exception
  {
    if (parame == null) {}
    h localh;
    g localg;
    do
    {
      do
      {
        return;
        localObject = new a(this.a);
        localh = h.a(parame.a);
        localObject = ((a)localObject).a(localh);
      } while (localObject == null);
      localg = ((c)localObject).a(parame);
    } while (!parame.e);
    Object localObject = new e(parame.a);
    if (localh == h.e) {
      parame = a(parame.d().g(), localg);
    }
    for (((e)localObject).c = a(h.e.a(), parame);; ((e)localObject).c = a(parame.a, null)) {
      do
      {
        a((e)localObject);
        return;
      } while ((localh != h.g) && (localh != h.c));
    }
  }
  
  public void c()
  {
    byte[] arrayOfByte = a(h.f.a(), null);
    e locale = new e(h.f.a());
    locale.c = arrayOfByte;
    locale.d = true;
    locale.a(true);
    a(locale);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */