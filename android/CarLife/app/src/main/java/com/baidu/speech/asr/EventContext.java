package com.baidu.speech.asr;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class EventContext
  extends ContextWrapper
{
  private static final String TAG = "EventContext";
  private static final Logger logger = Logger.getLogger("EventContext");
  
  public EventContext(Context paramContext)
  {
    super(paramContext);
  }
  
  public static short[] byteToShortArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return new short[0];
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
    localByteBuffer.clear();
    paramArrayOfByte = new short[paramInt2 / 2];
    localByteBuffer.asShortBuffer().get(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public static long computePower(short[] paramArrayOfShort, int paramInt)
  {
    if (paramArrayOfShort == null) {}
    int i;
    do
    {
      return 0L;
      System.currentTimeMillis();
      i = Math.min(paramInt / 2, 512);
    } while (i <= 0);
    long l = 0L;
    paramInt = 0;
    while (paramInt < i)
    {
      l += paramArrayOfShort[(paramInt * 2)] * paramArrayOfShort[(paramInt * 2)];
      paramInt += 1;
    }
    return Math.sqrt(l / i);
  }
  
  public long computePower(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt / 2];
    paramInt = 0;
    while (paramInt < arrayOfShort.length)
    {
      arrayOfShort[paramInt] = ((short)(paramArrayOfByte[(paramInt * 2 + 1)] << 8 | paramArrayOfByte[(paramInt * 2 + 0)] & 0xFF));
      paramInt += 1;
    }
    return computePower(arrayOfShort, arrayOfShort.length);
  }
  
  public SharedPreferences getSdkSharedPreferences()
  {
    return super.getSharedPreferences("bds", 0);
  }
  
  /* Error */
  public String httpRequest(String paramString, java.util.Map<String, String> paramMap, byte[] paramArrayOfByte, boolean paramBoolean)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 7
    //   8: astore 5
    //   10: ldc 13
    //   12: iconst_3
    //   13: invokestatic 105	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   16: ifne +19 -> 35
    //   19: aload 7
    //   21: astore 5
    //   23: getstatic 25	com/baidu/speech/asr/EventContext:logger	Ljava/util/logging/Logger;
    //   26: getstatic 111	java/util/logging/Level:ALL	Ljava/util/logging/Level;
    //   29: invokevirtual 114	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
    //   32: ifeq +47 -> 79
    //   35: aload 7
    //   37: astore 5
    //   39: getstatic 25	com/baidu/speech/asr/EventContext:logger	Ljava/util/logging/Logger;
    //   42: new 116	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   49: ldc 120
    //   51: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   57: ldc2_w 125
    //   60: lrem
    //   61: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: ldc -125
    //   66: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokevirtual 139	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   79: aload 7
    //   81: astore 5
    //   83: new 141	java/net/URL
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 143	java/net/URL:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   94: checkcast 149	java/net/HttpURLConnection
    //   97: astore_1
    //   98: aload_1
    //   99: sipush 8000
    //   102: invokevirtual 153	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   105: aload_1
    //   106: sipush 8000
    //   109: invokevirtual 156	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   112: aload_1
    //   113: iconst_0
    //   114: invokevirtual 160	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   117: aload_2
    //   118: invokeinterface 166 1 0
    //   123: invokeinterface 172 1 0
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface 178 1 0
    //   135: ifeq +103 -> 238
    //   138: aload_2
    //   139: invokeinterface 182 1 0
    //   144: checkcast 184	java/util/Map$Entry
    //   147: astore 5
    //   149: aload_1
    //   150: aload 5
    //   152: invokeinterface 187 1 0
    //   157: checkcast 189	java/lang/String
    //   160: aload 5
    //   162: invokeinterface 192 1 0
    //   167: checkcast 189	java/lang/String
    //   170: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: goto -44 -> 129
    //   176: astore_2
    //   177: aload_1
    //   178: astore 5
    //   180: ldc 13
    //   182: iconst_3
    //   183: invokestatic 105	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   186: ifne +18 -> 204
    //   189: aload_1
    //   190: astore 5
    //   192: getstatic 25	com/baidu/speech/asr/EventContext:logger	Ljava/util/logging/Logger;
    //   195: getstatic 111	java/util/logging/Level:ALL	Ljava/util/logging/Level;
    //   198: invokevirtual 114	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
    //   201: ifeq +18 -> 219
    //   204: aload_1
    //   205: astore 5
    //   207: getstatic 25	com/baidu/speech/asr/EventContext:logger	Ljava/util/logging/Logger;
    //   210: getstatic 199	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   213: ldc -55
    //   215: aload_2
    //   216: invokevirtual 205	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_1
    //   220: astore 5
    //   222: aload_2
    //   223: athrow
    //   224: astore_2
    //   225: aload 5
    //   227: astore_1
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   236: aload_2
    //   237: athrow
    //   238: aload_3
    //   239: ifnonnull +8 -> 247
    //   242: iload 4
    //   244: ifeq +9 -> 253
    //   247: aload_1
    //   248: ldc -46
    //   250: invokevirtual 213	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   253: aload_1
    //   254: invokevirtual 216	java/net/HttpURLConnection:connect	()V
    //   257: aload_3
    //   258: ifnull +11 -> 269
    //   261: aload_1
    //   262: invokevirtual 220	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   265: aload_3
    //   266: invokevirtual 226	java/io/OutputStream:write	([B)V
    //   269: new 228	java/util/Scanner
    //   272: dup
    //   273: aload_1
    //   274: invokevirtual 232	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   277: invokespecial 235	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   280: ldc -19
    //   282: invokevirtual 241	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   285: invokevirtual 243	java/util/Scanner:next	()Ljava/lang/String;
    //   288: astore_2
    //   289: ldc 13
    //   291: iconst_3
    //   292: invokestatic 105	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   295: ifne +15 -> 310
    //   298: getstatic 25	com/baidu/speech/asr/EventContext:logger	Ljava/util/logging/Logger;
    //   301: getstatic 111	java/util/logging/Level:ALL	Ljava/util/logging/Level;
    //   304: invokevirtual 114	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
    //   307: ifeq +28 -> 335
    //   310: getstatic 25	com/baidu/speech/asr/EventContext:logger	Ljava/util/logging/Logger;
    //   313: new 116	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   320: ldc -11
    //   322: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_2
    //   326: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 139	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   343: aload_2
    //   344: areturn
    //   345: astore_2
    //   346: goto -118 -> 228
    //   349: astore_2
    //   350: aload 6
    //   352: astore_1
    //   353: goto -176 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	EventContext
    //   0	356	1	paramString	String
    //   0	356	2	paramMap	java.util.Map<String, String>
    //   0	356	3	paramArrayOfByte	byte[]
    //   0	356	4	paramBoolean	boolean
    //   8	218	5	localObject1	Object
    //   4	347	6	localObject2	Object
    //   1	79	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   98	129	176	java/lang/Exception
    //   129	173	176	java/lang/Exception
    //   247	253	176	java/lang/Exception
    //   253	257	176	java/lang/Exception
    //   261	269	176	java/lang/Exception
    //   269	310	176	java/lang/Exception
    //   310	335	176	java/lang/Exception
    //   10	19	224	finally
    //   23	35	224	finally
    //   39	79	224	finally
    //   83	98	224	finally
    //   180	189	224	finally
    //   192	204	224	finally
    //   207	219	224	finally
    //   222	224	224	finally
    //   98	129	345	finally
    //   129	173	345	finally
    //   247	253	345	finally
    //   253	257	345	finally
    //   261	269	345	finally
    //   269	310	345	finally
    //   310	335	345	finally
    //   10	19	349	java/lang/Exception
    //   23	35	349	java/lang/Exception
    //   39	79	349	java/lang/Exception
    //   83	98	349	java/lang/Exception
  }
  
  public String join(List<String> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    int i = 1;
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(str);
        break;
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public byte[] loadBytesFromUri(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = null;
    ByteArrayOutputStream localByteArrayOutputStream = null;
    Object localObject1 = arrayOfByte;
    Object localObject2;
    String str;
    for (;;)
    {
      try
      {
        if (paramString.contains("://"))
        {
          localObject1 = arrayOfByte;
          localObject2 = Pattern.compile("(.*?)://(.*)").matcher(paramString);
          paramString = localByteArrayOutputStream;
          localObject1 = arrayOfByte;
          if (((Matcher)localObject2).find())
          {
            localObject1 = arrayOfByte;
            str = ((Matcher)localObject2).group(1);
            localObject1 = arrayOfByte;
            localObject2 = ((Matcher)localObject2).group(2);
            localObject1 = arrayOfByte;
            if (!str.equalsIgnoreCase("file")) {
              break;
            }
            localObject1 = arrayOfByte;
            paramString = new FileInputStream((String)localObject2);
          }
          if (paramString != null) {
            break label269;
          }
          localObject1 = paramString;
          throw new IOException("bad data source");
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((InputStream)localObject1).close();
        }
      }
      localObject1 = arrayOfByte;
      paramString = "file://" + paramString;
    }
    localObject1 = arrayOfByte;
    if (!str.equalsIgnoreCase("asset"))
    {
      localObject1 = arrayOfByte;
      if (!str.equalsIgnoreCase("assets")) {}
    }
    else
    {
      localObject1 = arrayOfByte;
      if (!((String)localObject2).startsWith("/")) {
        break label341;
      }
    }
    label269:
    label341:
    for (paramString = "";; paramString = "/")
    {
      localObject1 = arrayOfByte;
      paramString = getClass().getResourceAsStream("/assets" + paramString + (String)localObject2);
      break;
      paramString = localByteArrayOutputStream;
      localObject1 = arrayOfByte;
      if (!str.equalsIgnoreCase("res")) {
        break;
      }
      localObject1 = arrayOfByte;
      paramString = getClass().getResourceAsStream((String)localObject2);
      break;
      localObject1 = paramString;
      arrayOfByte = new byte['Ѐ'];
      localObject1 = paramString;
      localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        localObject1 = paramString;
        int i = paramString.read(arrayOfByte, 0, arrayOfByte.length);
        if (-1 == i) {
          break;
        }
        localObject1 = paramString;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localObject1 = paramString;
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      if (paramString != null) {
        paramString.close();
      }
      return arrayOfByte;
    }
  }
  
  public JSONObject loadJsonFromUri(String paramString)
  {
    return loadJsonFromUri(paramString, false, false);
  }
  
  public JSONObject loadJsonFromUri(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      paramString = loadJsonFromUriOrThrow(paramString, paramBoolean1, paramBoolean2);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public JSONObject loadJsonFromUriOrThrow(String paramString)
    throws IOException, JSONException
  {
    return loadJsonFromUriOrThrow(paramString, false, false);
  }
  
  public JSONObject loadJsonFromUriOrThrow(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, JSONException
  {
    String str = loadStringFromUri(paramString, paramBoolean1);
    paramString = str;
    if (paramBoolean2) {
      paramString = URLDecoder.decode(str, "UTF-8");
    }
    return new JSONObject(paramString);
  }
  
  public String loadStringFromUri(String paramString)
    throws IOException
  {
    return loadStringFromUri(paramString, false);
  }
  
  public String loadStringFromUri(String paramString, boolean paramBoolean)
    throws IOException
  {
    paramString = loadBytesFromUri(paramString);
    if (paramBoolean) {
      return new String(Base64.decode(paramString, 0), "UTF-8");
    }
    return new String(paramString, "UTF-8");
  }
  
  public <T> T loggerIt(Object paramObject, String... paramVarArgs)
  {
    return (T)SmartLogger.wrap(paramObject, paramVarArgs);
  }
  
  public Object searchItemFromJson(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (((String)localObject).equals(paramString)) {
        return paramJSONObject.get(paramString);
      }
      localObject = paramJSONObject.get((String)localObject);
      if ((localObject instanceof JSONObject))
      {
        localObject = searchItemFromJson((JSONObject)localObject, paramString);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private static class SmartLogger
  {
    private static final String TAG = "baidu_speech";
    private static final Logger logger = Logger.getLogger("baidu_speech");
    
    static
    {
      logger.setLevel(Level.OFF);
    }
    
    public static <T> T wrap(Object paramObject, String[] paramArrayOfString)
    {
      return (T)wrap("baidu_speech", paramObject, paramArrayOfString);
    }
    
    public static <T> T wrap(String paramString, Object paramObject, final String... paramVarArgs)
    {
      final boolean bool = Log.isLoggable("baidu_speech", 3);
      if (Log.isLoggable("baidu_speech", 3)) {
        logger.setLevel(Level.ALL);
      }
      ArrayList localArrayList = new ArrayList();
      paramString = paramObject.getClass();
      Class localClass;
      do
      {
        localArrayList.addAll(Arrays.asList(paramString.getInterfaces()));
        localClass = paramString.getSuperclass();
        paramString = localClass;
      } while (localClass != Object.class);
      (T)Proxy.newProxyInstance(paramObject.getClass().getClassLoader(), (Class[])localArrayList.toArray(new Class[0]), new InvocationHandler()
      {
        public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
          throws Throwable
        {
          Object localObject = paramAnonymousMethod.invoke(this.val$target, paramAnonymousArrayOfObject);
          StringBuffer localStringBuffer = new StringBuffer();
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          for (paramAnonymousObject = paramVarArgs[0];; paramAnonymousObject = this.val$target.getClass().getName())
          {
            localStringBuffer.append((String)paramAnonymousObject + "@" + Integer.toHexString(this.val$target.hashCode()));
            localStringBuffer.append("." + paramAnonymousMethod.getName() + "(");
            if (paramAnonymousArrayOfObject == null) {
              break;
            }
            int j = paramAnonymousArrayOfObject.length;
            int i = 0;
            while (i < j)
            {
              paramAnonymousObject = paramAnonymousArrayOfObject[i];
              paramAnonymousMethod = paramAnonymousObject + "";
              paramAnonymousObject = paramAnonymousMethod;
              if (!bool)
              {
                paramAnonymousObject = paramAnonymousMethod.replaceAll("[\r\n]]", "");
                paramAnonymousObject = ((String)paramAnonymousObject).substring(0, Math.min(50, ((String)paramAnonymousObject).length()));
              }
              localStringBuffer.append((String)paramAnonymousObject + ", ");
              i += 1;
            }
          }
          localStringBuffer.append(") : " + localObject);
          EventContext.SmartLogger.logger.info(localStringBuffer.toString());
          return localObject;
        }
      });
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/asr/EventContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */