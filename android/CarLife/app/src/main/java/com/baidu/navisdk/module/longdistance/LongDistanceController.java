package com.baidu.navisdk.module.longdistance;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.vi.VDeviceAPI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class LongDistanceController
{
  public static final int MSG_FETCH_WEATHER_RET = 291;
  private static final String TAG = LongDistanceController.class.getSimpleName();
  private FetchWeatherCallback mFetchWeatherCallback = null;
  private Handler mFetchWeatherHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage == null) {}
      while (paramAnonymousMessage.what != 291) {
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        LogUtil.e(LongDistanceController.TAG, "mFetchWeatherHandler: RET_OK --> ");
        if (LongDistanceController.this.mFetchWeatherCallback != null) {
          LongDistanceController.this.mFetchWeatherCallback.onGetData(LongDistanceController.this.mWeatherData);
        }
      }
      for (;;)
      {
        LongDistanceController.access$502(LongDistanceController.this, false);
        return;
        LogUtil.e(LongDistanceController.TAG, "mFetchWeatherHandler: RET_ERR --> " + paramAnonymousMessage.arg1);
        LongDistanceController.WeatherData localWeatherData = new LongDistanceController.WeatherData(LongDistanceController.this);
        localWeatherData.errno = paramAnonymousMessage.arg1;
        if (LongDistanceController.this.mFetchWeatherCallback != null) {
          LongDistanceController.this.mFetchWeatherCallback.onGetData(localWeatherData);
        }
      }
    }
  };
  private boolean mIsFetchingWeather = false;
  private WeatherData mWeatherData = null;
  
  public static LongDistanceController getInstance()
  {
    return LazyLoader.instance;
  }
  
  /* Error */
  private boolean parseFetchWeatherJson(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: aload_0
    //   9: monitorexit
    //   10: iload_3
    //   11: ireturn
    //   12: getstatic 43	com/baidu/navisdk/module/longdistance/LongDistanceController:TAG	Ljava/lang/String;
    //   15: new 88	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   22: ldc 91
    //   24: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 100	org/json/JSONObject:toString	()Ljava/lang/String;
    //   31: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 107	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: new 19	com/baidu/navisdk/module/longdistance/LongDistanceController$WeatherData
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 110	com/baidu/navisdk/module/longdistance/LongDistanceController$WeatherData:<init>	(Lcom/baidu/navisdk/module/longdistance/LongDistanceController;)V
    //   48: astore 4
    //   50: aload 4
    //   52: aload_1
    //   53: ldc 112
    //   55: invokevirtual 116	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   58: putfield 118	com/baidu/navisdk/module/longdistance/LongDistanceController$WeatherData:errno	I
    //   61: aload 4
    //   63: aload_1
    //   64: ldc 120
    //   66: invokevirtual 124	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: putfield 126	com/baidu/navisdk/module/longdistance/LongDistanceController$WeatherData:errmsg	Ljava/lang/String;
    //   72: aload_1
    //   73: ldc -128
    //   75: invokevirtual 132	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +228 -> 308
    //   83: aload_1
    //   84: ldc -122
    //   86: invokevirtual 138	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   89: ifeq +14 -> 103
    //   92: aload 4
    //   94: aload_1
    //   95: ldc -122
    //   97: invokevirtual 116	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   100: putfield 140	com/baidu/navisdk/module/longdistance/LongDistanceController$WeatherData:date	I
    //   103: aload_1
    //   104: ldc -114
    //   106: invokevirtual 138	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   109: ifeq +199 -> 308
    //   112: aload_1
    //   113: ldc -114
    //   115: invokevirtual 146	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   118: astore_1
    //   119: aload 4
    //   121: new 148	android/util/SparseArray
    //   124: dup
    //   125: invokespecial 149	android/util/SparseArray:<init>	()V
    //   128: putfield 153	com/baidu/navisdk/module/longdistance/LongDistanceController$WeatherData:weatherMap	Landroid/util/SparseArray;
    //   131: iconst_0
    //   132: istore_2
    //   133: iload_2
    //   134: aload_1
    //   135: invokevirtual 159	org/json/JSONArray:length	()I
    //   138: if_icmpge +170 -> 308
    //   141: aload_1
    //   142: iload_2
    //   143: invokevirtual 162	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   146: astore 5
    //   148: aload 5
    //   150: ifnull +105 -> 255
    //   153: new 10	com/baidu/navisdk/module/longdistance/LongDistanceController$CityWeather
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 163	com/baidu/navisdk/module/longdistance/LongDistanceController$CityWeather:<init>	(Lcom/baidu/navisdk/module/longdistance/LongDistanceController;)V
    //   161: astore 6
    //   163: aload 6
    //   165: aload 5
    //   167: ldc -91
    //   169: invokevirtual 116	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   172: putfield 168	com/baidu/navisdk/module/longdistance/LongDistanceController$CityWeather:cityId	I
    //   175: aload 5
    //   177: ldc -86
    //   179: invokevirtual 138	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   182: ifeq +15 -> 197
    //   185: aload 6
    //   187: aload 5
    //   189: ldc -86
    //   191: invokevirtual 124	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: putfield 173	com/baidu/navisdk/module/longdistance/LongDistanceController$CityWeather:cityName	Ljava/lang/String;
    //   197: aload 6
    //   199: aload 5
    //   201: ldc -81
    //   203: invokevirtual 124	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: putfield 177	com/baidu/navisdk/module/longdistance/LongDistanceController$CityWeather:weather	Ljava/lang/String;
    //   209: aload 6
    //   211: aload 5
    //   213: ldc -77
    //   215: invokevirtual 124	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   218: putfield 182	com/baidu/navisdk/module/longdistance/LongDistanceController$CityWeather:temperature	Ljava/lang/String;
    //   221: aload 5
    //   223: ldc -72
    //   225: invokevirtual 116	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   228: iconst_1
    //   229: if_icmpne +33 -> 262
    //   232: iconst_1
    //   233: istore_3
    //   234: aload 6
    //   236: iload_3
    //   237: putfield 187	com/baidu/navisdk/module/longdistance/LongDistanceController$CityWeather:alarm	Z
    //   240: aload 4
    //   242: getfield 153	com/baidu/navisdk/module/longdistance/LongDistanceController$WeatherData:weatherMap	Landroid/util/SparseArray;
    //   245: aload 6
    //   247: getfield 168	com/baidu/navisdk/module/longdistance/LongDistanceController$CityWeather:cityId	I
    //   250: aload 6
    //   252: invokevirtual 191	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   255: iload_2
    //   256: iconst_1
    //   257: iadd
    //   258: istore_2
    //   259: goto -126 -> 133
    //   262: iconst_0
    //   263: istore_3
    //   264: goto -30 -> 234
    //   267: astore_1
    //   268: getstatic 43	com/baidu/navisdk/module/longdistance/LongDistanceController:TAG	Ljava/lang/String;
    //   271: astore 5
    //   273: new 88	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   280: ldc -63
    //   282: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: astore 6
    //   287: aload_1
    //   288: ifnonnull +31 -> 319
    //   291: ldc -61
    //   293: astore_1
    //   294: aload 5
    //   296: aload 6
    //   298: aload_1
    //   299: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 107	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: aload 4
    //   311: putfield 51	com/baidu/navisdk/module/longdistance/LongDistanceController:mWeatherData	Lcom/baidu/navisdk/module/longdistance/LongDistanceController$WeatherData;
    //   314: iconst_1
    //   315: istore_3
    //   316: goto -308 -> 8
    //   319: aload_1
    //   320: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   323: astore_1
    //   324: goto -30 -> 294
    //   327: astore_1
    //   328: aload_0
    //   329: monitorexit
    //   330: aload_1
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	LongDistanceController
    //   0	332	1	paramJSONObject	JSONObject
    //   132	127	2	i	int
    //   1	315	3	bool	boolean
    //   48	262	4	localWeatherData	WeatherData
    //   146	149	5	localObject1	Object
    //   161	136	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   50	79	267	java/lang/Exception
    //   83	103	267	java/lang/Exception
    //   103	131	267	java/lang/Exception
    //   133	148	267	java/lang/Exception
    //   153	197	267	java/lang/Exception
    //   197	232	267	java/lang/Exception
    //   234	255	267	java/lang/Exception
    //   12	50	327	finally
    //   50	79	327	finally
    //   83	103	327	finally
    //   103	131	327	finally
    //   133	148	327	finally
    //   153	197	327	finally
    //   197	232	327	finally
    //   234	255	327	finally
    //   268	287	327	finally
    //   294	308	327	finally
    //   308	314	327	finally
    //   319	324	327	finally
  }
  
  /* Error */
  public void fetchWeather(final String paramString, FetchWeatherCallback paramFetchWeatherCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 43	com/baidu/navisdk/module/longdistance/LongDistanceController:TAG	Ljava/lang/String;
    //   5: new 88	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   12: ldc -54
    //   14: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 49	com/baidu/navisdk/module/longdistance/LongDistanceController:mIsFetchingWeather	Z
    //   21: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   24: ldc -49
    //   26: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 107	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 49	com/baidu/navisdk/module/longdistance/LongDistanceController:mIsFetchingWeather	Z
    //   43: ifne +12 -> 55
    //   46: aload_1
    //   47: invokestatic 213	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: istore_3
    //   51: iload_3
    //   52: ifeq +6 -> 58
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: iconst_1
    //   60: putfield 49	com/baidu/navisdk/module/longdistance/LongDistanceController:mIsFetchingWeather	Z
    //   63: aload_0
    //   64: aload_2
    //   65: putfield 53	com/baidu/navisdk/module/longdistance/LongDistanceController:mFetchWeatherCallback	Lcom/baidu/navisdk/module/longdistance/LongDistanceController$FetchWeatherCallback;
    //   68: new 215	com/baidu/navisdk/logic/ReqData
    //   71: dup
    //   72: ldc -39
    //   74: bipush 7
    //   76: aload_0
    //   77: getfield 64	com/baidu/navisdk/module/longdistance/LongDistanceController:mFetchWeatherHandler	Landroid/os/Handler;
    //   80: sipush 291
    //   83: sipush 3000
    //   86: invokespecial 220	com/baidu/navisdk/logic/ReqData:<init>	(Ljava/lang/String;ILandroid/os/Handler;II)V
    //   89: astore_2
    //   90: aload_2
    //   91: invokestatic 225	com/baidu/navisdk/module/BusinessActivityManager:getInstance	()Lcom/baidu/navisdk/module/BusinessActivityManager;
    //   94: invokevirtual 229	com/baidu/navisdk/module/BusinessActivityManager:getCookieStore	()Lorg/apache/http/client/CookieStore;
    //   97: putfield 233	com/baidu/navisdk/logic/ReqData:mCookieStore	Lorg/apache/http/client/CookieStore;
    //   100: aload_2
    //   101: new 8	com/baidu/navisdk/module/longdistance/LongDistanceController$2
    //   104: dup
    //   105: aload_0
    //   106: aload_1
    //   107: invokespecial 236	com/baidu/navisdk/module/longdistance/LongDistanceController$2:<init>	(Lcom/baidu/navisdk/module/longdistance/LongDistanceController;Ljava/lang/String;)V
    //   110: invokestatic 242	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestFunc:addFunc	(Lcom/baidu/navisdk/logic/ReqData;Lcom/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestFunc$Callback;)V
    //   113: invokestatic 247	com/baidu/navisdk/logic/CommandCenter:getInstance	()Lcom/baidu/navisdk/logic/CommandCenter;
    //   116: aload_2
    //   117: invokevirtual 251	com/baidu/navisdk/logic/CommandCenter:sendRequest	(Lcom/baidu/navisdk/logic/ReqData;)I
    //   120: pop
    //   121: goto -66 -> 55
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	LongDistanceController
    //   0	129	1	paramString	String
    //   0	129	2	paramFetchWeatherCallback	FetchWeatherCallback
    //   50	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	51	124	finally
    //   58	121	124	finally
  }
  
  public class CityWeather
  {
    public boolean alarm;
    public int cityId;
    public String cityName;
    public String temperature;
    public String weather;
    
    public CityWeather() {}
  }
  
  public static abstract interface FetchWeatherCallback
  {
    public abstract void onGetData(LongDistanceController.WeatherData paramWeatherData);
  }
  
  private static class LazyLoader
  {
    private static LongDistanceController instance = new LongDistanceController(null);
  }
  
  public class WeatherData
  {
    public int date = 0;
    public String errmsg = null;
    public int errno = Integer.MIN_VALUE;
    public SparseArray<LongDistanceController.CityWeather> weatherMap = null;
    
    public WeatherData() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/longdistance/LongDistanceController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */