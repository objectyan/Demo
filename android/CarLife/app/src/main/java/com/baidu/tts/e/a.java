package com.baidu.tts.e;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.h.b.b;
import com.baidu.tts.loopj.AsyncHttpResponseHandler;
import com.baidu.tts.loopj.SyncHttpClient;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  /* Error */
  private static org.apache.http.client.entity.UrlEncodedFormEntity a(String paramString)
  {
    // Byte code:
    //   0: new 12	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 16	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: new 18	org/apache/http/message/BasicNameValuePair
    //   12: dup
    //   13: ldc 20
    //   15: aload_0
    //   16: invokespecial 23	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: invokeinterface 29 2 0
    //   24: pop
    //   25: new 31	org/apache/http/client/entity/UrlEncodedFormEntity
    //   28: dup
    //   29: aload_1
    //   30: ldc 33
    //   32: invokespecial 36	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   35: astore_0
    //   36: aload_0
    //   37: ldc 38
    //   39: invokevirtual 42	org/apache/http/client/entity/UrlEncodedFormEntity:setContentType	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 45	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   51: aload_0
    //   52: areturn
    //   53: astore_1
    //   54: goto -7 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   7	23	1	localArrayList	ArrayList
    //   44	4	1	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   53	1	1	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   25	36	44	java/io/UnsupportedEncodingException
    //   36	42	53	java/io/UnsupportedEncodingException
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 53	com/baidu/tts/e/d:h	(Landroid/content/Context;)Z
    //   7: ifeq +124 -> 131
    //   10: aload_0
    //   11: invokestatic 56	com/baidu/tts/e/d:a	(Landroid/content/Context;)J
    //   14: lstore_2
    //   15: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   18: lstore 4
    //   20: new 64	java/util/Date
    //   23: dup
    //   24: lload_2
    //   25: invokespecial 67	java/util/Date:<init>	(J)V
    //   28: astore 7
    //   30: new 64	java/util/Date
    //   33: dup
    //   34: lload 4
    //   36: invokespecial 67	java/util/Date:<init>	(J)V
    //   39: astore 8
    //   41: lload 4
    //   43: lload_2
    //   44: lsub
    //   45: ldc2_w 68
    //   48: lcmp
    //   49: ifge +86 -> 135
    //   52: lload 4
    //   54: lload_2
    //   55: lsub
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +77 -> 135
    //   61: ldc 71
    //   63: new 73	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   70: ldc 76
    //   72: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: lload_2
    //   76: invokevirtual 83	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: ldc 85
    //   81: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   87: invokevirtual 83	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 94	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 71
    //   98: new 73	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   105: ldc 96
    //   107: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 7
    //   112: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: ldc 101
    //   117: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 8
    //   122: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 94	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc 2
    //   133: monitorexit
    //   134: return
    //   135: aload_0
    //   136: aload_1
    //   137: invokestatic 105	com/baidu/tts/e/a:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   140: istore 6
    //   142: ldc 71
    //   144: new 73	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   151: ldc 107
    //   153: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: iload 6
    //   158: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 94	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: goto -36 -> 131
    //   170: astore_0
    //   171: ldc 2
    //   173: monitorexit
    //   174: aload_0
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramContext	Context
    //   0	176	1	paramString	String
    //   14	62	2	l1	long
    //   18	35	4	l2	long
    //   140	17	6	bool	boolean
    //   28	83	7	localDate1	java.util.Date
    //   39	82	8	localDate2	java.util.Date
    // Exception table:
    //   from	to	target	type
    //   3	41	170	finally
    //   61	131	170	finally
    //   135	167	170	finally
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    paramContext = c(paramContext, paramString1);
    LoggerProxy.d("StatHelper", "statHelper url:" + paramContext);
    paramString1 = a(paramString2);
    new SyncHttpClient(true, 80, 443).post(null, paramContext, paramString1, null, new AsyncHttpResponseHandler()
    {
      public void onFailure(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        LoggerProxy.d("StatHelper", "statusCode: " + paramAnonymousInt + "responseBody: " + paramAnonymousArrayOfByte);
      }
      
      public void onSuccess(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, byte[] paramAnonymousArrayOfByte)
      {
        paramAnonymousArrayOfHeader = new String(paramAnonymousArrayOfByte);
        LoggerProxy.d("StatHelper", "response=" + new String(paramAnonymousArrayOfByte));
        if (!TextUtils.isEmpty(paramAnonymousArrayOfHeader)) {}
        try
        {
          if ("0".equals(new JSONObject(paramAnonymousArrayOfHeader).optString("errno")))
          {
            this.a[0] = true;
            LoggerProxy.d("StatHelper", "ret=" + this.a[0]);
          }
          return;
        }
        catch (JSONException paramAnonymousArrayOfHeader)
        {
          LoggerProxy.d("StatHelper", "parse:" + paramAnonymousArrayOfHeader.toString());
          return;
        }
        catch (Exception paramAnonymousArrayOfHeader)
        {
          LoggerProxy.d("StatHelper", "parse:" + paramAnonymousArrayOfHeader.toString());
        }
      }
    });
    return arrayOfBoolean[0];
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    boolean bool5 = false;
    boolean bool8 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool1 = false;
    boolean bool2 = bool5;
    boolean bool3 = bool6;
    boolean bool4 = bool7;
    for (;;)
    {
      try
      {
        c localc = c.a(paramContext);
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        int i = localc.a();
        bool2 = bool8;
        if (i >= 1)
        {
          bool2 = bool5;
          bool3 = bool6;
          bool4 = bool7;
          LoggerProxy.d("StatHelper", "cursor.getCount: " + i);
          if (i % 500 == 0)
          {
            bool2 = bool5;
            bool3 = bool6;
            bool4 = bool7;
            i /= 500;
            break label579;
            bool2 = bool1;
            if (j < i)
            {
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              Object localObject = new JSONObject();
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              Map localMap = localc.b();
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              ArrayList localArrayList = (ArrayList)localMap.get("listId");
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              ((JSONObject)localObject).put("recog_results", new JSONArray((ArrayList)localMap.get("list")));
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              LoggerProxy.d("StatHelper", "jsonObj all: " + ((JSONObject)localObject).toString());
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              localObject = d.a(((JSONObject)localObject).toString());
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              if (localObject.length >= 2)
              {
                localObject[0] = 117;
                localObject[1] = 123;
              }
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              localObject = d.a((byte[])localObject);
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              LoggerProxy.d("StatHelper", " postContent:" + (String)localObject);
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              bool5 = a(paramContext, paramString, (String)localObject);
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              d.a(paramContext, System.currentTimeMillis());
              if (!bool5) {
                break label576;
              }
              bool2 = bool1;
              bool3 = bool1;
              bool4 = bool1;
              localc.a(localArrayList);
              bool1 = true;
              break label584;
            }
          }
          else
          {
            bool2 = bool5;
            bool3 = bool6;
            bool4 = bool7;
            i /= 500;
            i += 1;
          }
        }
      }
      catch (SQLiteException paramContext)
      {
        LoggerProxy.d("StatHelper", "exception:" + paramContext.toString());
        return bool2;
      }
      catch (IllegalStateException paramContext)
      {
        LoggerProxy.d("StatHelper", "exception:" + paramContext.toString());
        return bool3;
      }
      catch (Exception paramContext)
      {
        LoggerProxy.d("StatHelper", "exception:" + paramContext.toString());
        return bool4;
      }
      label576:
      break label584;
      label579:
      int j = 0;
      continue;
      label584:
      j += 1;
    }
  }
  
  private static String c(Context paramContext, String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new BasicNameValuePair("wise_cuid", b.a().i()));
    localLinkedList.add(new BasicNameValuePair("sdk_version", d.a()));
    localLinkedList.add(new BasicNameValuePair("app_name", d.b(paramContext)));
    localLinkedList.add(new BasicNameValuePair("platform", d.c(paramContext)));
    localLinkedList.add(new BasicNameValuePair("os", d.b()));
    localLinkedList.add(new BasicNameValuePair("net_type", d.d(paramContext) + ""));
    localLinkedList.add(new BasicNameValuePair("appid", paramString));
    localLinkedList.add(new BasicNameValuePair("screen", d.e(paramContext)));
    localLinkedList.add(new BasicNameValuePair("sdk_name", d.c()));
    localLinkedList.add(new BasicNameValuePair("app_signature", d.f(paramContext)));
    paramContext = URLEncodedUtils.format(localLinkedList, "utf-8");
    return "https://upl.baidu.com/voice?osname=voiceopen&action=usereventflow&" + paramContext;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */