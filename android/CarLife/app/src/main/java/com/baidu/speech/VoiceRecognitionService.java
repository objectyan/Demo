package com.baidu.speech;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.speech.RecognitionService;
import android.speech.RecognitionService.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class VoiceRecognitionService
  extends RecognitionService
{
  public static final int EVENT_ENGINE_SWITCH = 12;
  private static final int EVENT_ERROR = 11;
  private static final int EVENT_THIRD_DATA = 12;
  public static final String TAG = "VoiceRecognitionService";
  public static final String VERSION_NAME = "3.4.0.100";
  private static final Logger logger = Logger.getLogger("VoiceRecognitionService");
  private boolean internal;
  private EventManager mEventManagerAsr;
  private Bundle mFinalBundle;
  private boolean mLongSpeech;
  private MyListener mUsingListener;
  
  private JSONObject convertIntentToJson(Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    paramIntent.getStringExtra("a");
    paramIntent = paramIntent.getExtras();
    Iterator localIterator = paramIntent.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramIntent.get((String)localObject1);
      if ((((String)localObject1).equals("args")) && ((localObject2 instanceof String)))
      {
        localObject1 = ((String)localObject2).split("--");
        int m = localObject1.length;
        int j = 0;
        while (j < m)
        {
          localObject2 = localObject1[j];
          int k = ((String)localObject2).trim().indexOf(" ");
          int i = k;
          if (k < 0) {
            i = ((String)localObject2).indexOf("\t");
          }
          k = i;
          if (i < 0) {
            k = ((String)localObject2).indexOf("=");
          }
          if (k > 0) {
            localHashMap.put(((String)localObject2).substring(0, k).trim(), ((String)localObject2).substring(k + 1).trim());
          }
          j += 1;
        }
      }
      else
      {
        localHashMap.put(localObject1, localObject2);
      }
    }
    return new JSONObject(localHashMap);
  }
  
  public static Bundle fromJson(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      JSONArray localJSONArray = paramJSONObject.optJSONArray(str);
      Object localObject = paramJSONObject.optString(str);
      if ((localJSONArray != null) && (localJSONArray.length() <= 0))
      {
        localBundle.putStringArray(str, new String[0]);
      }
      else
      {
        int i;
        if ((localJSONArray != null) && (localJSONArray.optString(0) != null))
        {
          localObject = new ArrayList();
          i = 0;
          while (i < localJSONArray.length())
          {
            ((ArrayList)localObject).add(localJSONArray.optString(i));
            i += 1;
          }
          localBundle.putStringArrayList(str, (ArrayList)localObject);
        }
        else if ((localJSONArray != null) && (!Double.isNaN(localJSONArray.optDouble(0))))
        {
          localObject = new double[localJSONArray.length()];
          i = 0;
          while (i < localJSONArray.length())
          {
            localObject[i] = localJSONArray.optDouble(i);
            i += 1;
          }
          localBundle.putDoubleArray(str, (double[])localObject);
        }
        else if (localObject != null)
        {
          localBundle.putString(str, (String)localObject);
        }
      }
    }
    return localBundle;
  }
  
  public static String getSdkVersion()
  {
    return "3.4.0.100";
  }
  
  protected void onCancel(RecognitionService.Callback paramCallback)
  {
    this.mEventManagerAsr.send("asr.cancel", "{}", null, 0, 0);
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 219	android/speech/RecognitionService:onCreate	()V
    //   4: ldc 2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 202	com/baidu/speech/VoiceRecognitionService:mEventManagerAsr	Lcom/baidu/speech/EventManager;
    //   11: ifnonnull +45 -> 56
    //   14: aload_0
    //   15: aload_0
    //   16: invokevirtual 223	com/baidu/speech/VoiceRecognitionService:getApplicationContext	()Landroid/content/Context;
    //   19: ldc -31
    //   21: invokestatic 231	com/baidu/speech/EventManagerFactory:create	(Landroid/content/Context;Ljava/lang/String;)Lcom/baidu/speech/EventManager;
    //   24: putfield 202	com/baidu/speech/VoiceRecognitionService:mEventManagerAsr	Lcom/baidu/speech/EventManager;
    //   27: aload_0
    //   28: new 6	com/baidu/speech/VoiceRecognitionService$MyListener
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 234	com/baidu/speech/VoiceRecognitionService$MyListener:<init>	(Lcom/baidu/speech/VoiceRecognitionService;)V
    //   36: putfield 236	com/baidu/speech/VoiceRecognitionService:mUsingListener	Lcom/baidu/speech/VoiceRecognitionService$MyListener;
    //   39: aload_0
    //   40: getfield 202	com/baidu/speech/VoiceRecognitionService:mEventManagerAsr	Lcom/baidu/speech/EventManager;
    //   43: aload_0
    //   44: getfield 236	com/baidu/speech/VoiceRecognitionService:mUsingListener	Lcom/baidu/speech/VoiceRecognitionService$MyListener;
    //   47: invokeinterface 240 2 0
    //   52: iconst_0
    //   53: putstatic 245	com/baidu/speech/asr/SpeechConstant:PUBLIC_DECODER	Z
    //   56: ldc 2
    //   58: monitorexit
    //   59: getstatic 41	com/baidu/speech/VoiceRecognitionService:logger	Ljava/util/logging/Logger;
    //   62: ldc -9
    //   64: iconst_1
    //   65: anewarray 249	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_0
    //   71: invokevirtual 252	java/lang/Object:hashCode	()I
    //   74: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 262	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   81: invokevirtual 266	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   84: ldc_w 268
    //   87: invokestatic 274	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   90: pop
    //   91: aload_0
    //   92: iconst_1
    //   93: putfield 276	com/baidu/speech/VoiceRecognitionService:internal	Z
    //   96: getstatic 41	com/baidu/speech/VoiceRecognitionService:logger	Ljava/util/logging/Logger;
    //   99: new 278	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 281
    //   109: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 276	com/baidu/speech/VoiceRecognitionService:internal	Z
    //   116: invokevirtual 288	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   119: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 266	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   125: aload_0
    //   126: invokevirtual 295	com/baidu/speech/VoiceRecognitionService:getPackageManager	()Landroid/content/pm/PackageManager;
    //   129: new 297	android/content/ComponentName
    //   132: dup
    //   133: aload_0
    //   134: invokevirtual 300	com/baidu/speech/VoiceRecognitionService:getPackageName	()Ljava/lang/String;
    //   137: aload_0
    //   138: invokevirtual 304	java/lang/Object:getClass	()Ljava/lang/Class;
    //   141: invokevirtual 307	java/lang/Class:getName	()Ljava/lang/String;
    //   144: invokespecial 309	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: sipush 128
    //   150: invokevirtual 315	android/content/pm/PackageManager:getServiceInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;
    //   153: getfield 320	android/content/pm/ServiceInfo:exported	Z
    //   156: ifeq +42 -> 198
    //   159: new 322	android/util/AndroidRuntimeException
    //   162: dup
    //   163: new 278	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   170: aload_0
    //   171: invokevirtual 304	java/lang/Object:getClass	()Ljava/lang/Class;
    //   174: invokevirtual 307	java/lang/Class:getName	()Ljava/lang/String;
    //   177: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 324
    //   183: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokespecial 326	android/util/AndroidRuntimeException:<init>	(Ljava/lang/String;)V
    //   192: athrow
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 329	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   198: return
    //   199: astore_1
    //   200: ldc 2
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: goto -110 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	VoiceRecognitionService
    //   193	2	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   199	5	1	localObject	Object
    //   205	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   125	193	193	android/content/pm/PackageManager$NameNotFoundException
    //   7	56	199	finally
    //   56	59	199	finally
    //   200	203	199	finally
    //   84	96	205	java/lang/Exception
  }
  
  public void onDestroy()
  {
    this.mEventManagerAsr.send("asr.kws.unload", "{}", null, 0, 0);
    super.onDestroy();
  }
  
  protected void onStartListening(Intent paramIntent, RecognitionService.Callback paramCallback)
  {
    boolean bool = false;
    if (!paramIntent.hasExtra("audio.mills")) {
      paramIntent.putExtra("audio.mills", System.currentTimeMillis());
    }
    if (paramIntent.getIntExtra("vad.endpoint-timeout", -1) == 0) {
      bool = true;
    }
    this.mLongSpeech = bool;
    JSONObject localJSONObject = convertIntentToJson(paramIntent);
    try
    {
      this.mUsingListener.setCallbackListener(paramCallback);
      if (paramIntent.getIntExtra("decoder", 0) != 0) {
        this.mEventManagerAsr.send("asr.kws.load", localJSONObject.toString(4), null, 0, 0);
      }
      this.mEventManagerAsr.send("asr.start", localJSONObject.toString(4), null, 0, 0);
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  protected void onStopListening(RecognitionService.Callback paramCallback)
  {
    this.mEventManagerAsr.send("asr.stop", "{}", null, 0, 0);
  }
  
  class MyListener
    implements EventListener
  {
    RecognitionService.Callback mListener;
    
    MyListener() {}
    
    private final void callbackOnEvent(RecognitionService.Callback paramCallback, int paramInt, Bundle paramBundle)
    {
      try
      {
        Field localField = paramCallback.getClass().getDeclaredField("mListener");
        localField.setAccessible(true);
        Class.forName("android.speech.IRecognitionListener").getMethod("onEvent", new Class[] { Integer.TYPE, Bundle.class }).invoke(localField.get(paramCallback), new Object[] { Integer.valueOf(paramInt), paramBundle });
        return;
      }
      catch (Exception paramCallback)
      {
        paramCallback.printStackTrace();
        VoiceRecognitionService.logger.log(Level.WARNING, "", paramCallback);
      }
    }
    
    public void onEvent(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      RecognitionService.Callback localCallback = this.mListener;
      if (localCallback == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              try
              {
                if ("asr.ready".equals(paramString1))
                {
                  localCallback.readyForSpeech(new Bundle());
                  return;
                }
              }
              catch (RemoteException paramString1)
              {
                paramString1.printStackTrace();
                return;
                if ("asr.begin".equals(paramString1))
                {
                  localCallback.beginningOfSpeech();
                  return;
                }
              }
              catch (JSONException paramString1)
              {
                paramString1.printStackTrace();
                return;
              }
              if ("asr.audio".equals(paramString1))
              {
                localCallback.bufferReceived(paramArrayOfByte);
                return;
              }
              if ("asr.volume".equals(paramString1))
              {
                localCallback.rmsChanged((float)new JSONObject(paramString2).optDouble("volume"));
                return;
              }
              if ("asr.end".equals(paramString1))
              {
                localCallback.endOfSpeech();
                return;
              }
              if (!"asr.partial".equals(paramString1)) {
                break;
              }
              paramString2 = new JSONObject(paramString2);
              paramString1 = paramString2.optString("result_type");
              paramString2 = VoiceRecognitionService.fromJson(paramString2);
            } while ((paramString1 == null) || (paramString1 == ""));
            if (paramString1.equals("partial_result"))
            {
              localCallback.partialResults(paramString2);
              return;
            }
            if (paramString1.equals("final_result"))
            {
              VoiceRecognitionService.access$002(VoiceRecognitionService.this, paramString2);
              return;
            }
          } while (!paramString1.equals("third_result"));
          paramString1 = new Bundle();
          paramString1.putByteArray("third_data", paramArrayOfByte);
          callbackOnEvent(localCallback, 12, paramString1);
          return;
          if (!"asr.finish".equals(paramString1)) {
            break;
          }
          paramString1 = new JSONObject(paramString2);
          paramInt1 = paramString1.getInt("error");
          if (paramInt1 != 0)
          {
            localCallback.error(paramInt1);
            paramString2 = new Bundle();
            paramString2.putInt("error", paramString1.getInt("sub_error"));
            paramString2.putString("reason", paramString1.getString("desc"));
            callbackOnEvent(localCallback, 11, paramString2);
            return;
          }
        } while (VoiceRecognitionService.this.mLongSpeech);
        localCallback.results(VoiceRecognitionService.this.mFinalBundle);
        VoiceRecognitionService.access$002(VoiceRecognitionService.this, null);
        return;
      } while (!"asr.long-speech.finish".equals(paramString1));
      localCallback.results(VoiceRecognitionService.this.mFinalBundle);
      VoiceRecognitionService.access$002(VoiceRecognitionService.this, null);
    }
    
    public void setCallbackListener(RecognitionService.Callback paramCallback)
    {
      this.mListener = paramCallback;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/VoiceRecognitionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */