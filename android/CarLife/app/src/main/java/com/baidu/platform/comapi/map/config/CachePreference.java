package com.baidu.platform.comapi.map.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.basic.BMExecutorsManager;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comapi.util.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class CachePreference
{
  private static final ExecutorService WORKER = BMExecutorsManager.newSingleThreadExecutor(new h("cache_preference_worker", true));
  private final Map<String, Object> memoryCache = new ConcurrentHashMap(64);
  private final Map<String, JSONObject> memoryCacheJSON = new ConcurrentHashMap();
  private final SharedPreferences preferences;
  
  public CachePreference(Context paramContext, String paramString)
  {
    this.preferences = paramContext.getSharedPreferences(paramString, 0);
  }
  
  private void asyncPut(String paramString, Object paramObject)
  {
    WORKER.execute(new PutRunnable(paramString, paramObject));
  }
  
  public void clear()
  {
    ConcurrentManager.executeTask(Module.BASE_FRAMEWORK_MODULE, new ConcurrentTask()
    {
      public void run()
      {
        CachePreference.this.memoryCache.clear();
        CachePreference.this.preferences.edit().clear().apply();
      }
    }, ScheduleConfig.forData());
  }
  
  public boolean contains(String paramString)
  {
    return (this.memoryCache.containsKey(paramString)) || (this.preferences.contains(paramString));
  }
  
  public Map<String, ?> getAll()
  {
    return this.preferences.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    Object localObject = this.memoryCache.get(paramString);
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    if (this.preferences.contains(paramString))
    {
      paramBoolean = this.preferences.getBoolean(paramString, paramBoolean);
      this.memoryCache.put(paramString, Boolean.valueOf(paramBoolean));
      return paramBoolean;
    }
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    Object localObject = this.memoryCache.get(paramString);
    if ((localObject instanceof Float)) {
      return ((Float)localObject).floatValue();
    }
    if (this.preferences.contains(paramString))
    {
      paramFloat = this.preferences.getFloat(paramString, paramFloat);
      this.memoryCache.put(paramString, Float.valueOf(paramFloat));
      return paramFloat;
    }
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    Object localObject = this.memoryCache.get(paramString);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if (this.preferences.contains(paramString))
    {
      paramInt = this.preferences.getInt(paramString, paramInt);
      this.memoryCache.put(paramString, Integer.valueOf(paramInt));
      return paramInt;
    }
    return paramInt;
  }
  
  public JSONObject getJSON(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return null;
      if (this.memoryCacheJSON.containsKey(paramString)) {
        return (JSONObject)this.memoryCacheJSON.get(paramString);
      }
      localObject = getString(paramString, "");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    try
    {
      localObject = new JSONObject((String)localObject);
      this.memoryCacheJSON.put(paramString, localObject);
      return (JSONObject)localObject;
    }
    catch (JSONException paramString)
    {
      f.a("CachePreference", "exception", paramString);
    }
    return null;
  }
  
  public Long getLong(String paramString, long paramLong)
  {
    Object localObject = this.memoryCache.get(paramString);
    if ((localObject instanceof Long)) {
      return (Long)localObject;
    }
    if (this.preferences.contains(paramString))
    {
      paramLong = this.preferences.getLong(paramString, paramLong);
      this.memoryCache.put(paramString, Long.valueOf(paramLong));
      return Long.valueOf(paramLong);
    }
    return Long.valueOf(paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    Object localObject = this.memoryCache.get(paramString1);
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    if (this.preferences.contains(paramString1))
    {
      paramString2 = this.preferences.getString(paramString1, paramString2);
      this.memoryCache.put(paramString1, paramString2);
      return paramString2;
    }
    return paramString2;
  }
  
  public boolean putBoolean(String paramString, boolean paramBoolean)
  {
    this.memoryCache.put(paramString, Boolean.valueOf(paramBoolean));
    asyncPut(paramString, Boolean.valueOf(paramBoolean));
    return true;
  }
  
  public boolean putFloat(String paramString, float paramFloat)
  {
    this.memoryCache.put(paramString, Float.valueOf(paramFloat));
    asyncPut(paramString, Float.valueOf(paramFloat));
    return false;
  }
  
  public boolean putInt(String paramString, int paramInt)
  {
    this.memoryCache.put(paramString, Integer.valueOf(paramInt));
    asyncPut(paramString, Integer.valueOf(paramInt));
    return false;
  }
  
  public void putJSON(String paramString, JSONObject paramJSONObject)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null)) {
      return;
    }
    this.memoryCacheJSON.put(paramString, paramJSONObject);
    asyncPut(paramString, paramJSONObject.toString());
  }
  
  public boolean putLong(String paramString, long paramLong)
  {
    this.memoryCache.put(paramString, Long.valueOf(paramLong));
    asyncPut(paramString, Long.valueOf(paramLong));
    return false;
  }
  
  public boolean putString(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.memoryCache.put(paramString1, paramString2);
      asyncPut(paramString1, paramString2);
    }
    return false;
  }
  
  public boolean removeKey(String paramString)
  {
    this.memoryCache.remove(paramString);
    return this.preferences.edit().remove(paramString).commit();
  }
  
  private class PutRunnable
    implements Runnable
  {
    private String key;
    private Object value;
    
    public PutRunnable(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.value = paramObject;
    }
    
    public void run()
    {
      SharedPreferences.Editor localEditor = CachePreference.this.preferences.edit();
      if ((this.value instanceof String)) {
        localEditor.putString(this.key, (String)this.value);
      }
      for (;;)
      {
        localEditor.commit();
        return;
        if ((this.value instanceof Long)) {
          localEditor.putLong(this.key, ((Long)this.value).longValue());
        } else if ((this.value instanceof Integer)) {
          localEditor.putInt(this.key, ((Integer)this.value).intValue());
        } else if ((this.value instanceof Boolean)) {
          localEditor.putBoolean(this.key, ((Boolean)this.value).booleanValue());
        } else if ((this.value instanceof Float)) {
          localEditor.putFloat(this.key, ((Float)this.value).floatValue());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/config/CachePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */