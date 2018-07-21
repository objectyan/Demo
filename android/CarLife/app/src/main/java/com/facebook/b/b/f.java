package com.facebook.b.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.common.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public final class f
{
  private static final String a = f.class.getSimpleName();
  
  protected static Map<Integer, String> a(@Nullable SharedPreferences paramSharedPreferences, Set<String> paramSet)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        if (paramSharedPreferences == null) {
          return localHashMap;
        }
        Object localObject = paramSharedPreferences.getAll();
        paramSharedPreferences = paramSharedPreferences.edit();
        localObject = ((Map)localObject).entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label175;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (!(localEntry.getValue() instanceof String)) {
          break label164;
        }
        int i = Integer.parseInt((String)localEntry.getKey());
        if (paramSet.contains(localEntry.getValue()))
        {
          localHashMap.put(Integer.valueOf(i), (String)localEntry.getValue());
          continue;
        }
        paramSharedPreferences.remove(String.valueOf(localEntry.getKey()));
      }
      finally {}
      continue;
      label164:
      a.e(a, "SharedPreference doesn't store right data type");
      continue;
      label175:
      paramSharedPreferences.apply();
    }
  }
  
  protected static void a(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.clear();
    paramSharedPreferences.apply();
  }
  
  protected static void a(Integer paramInteger, SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.remove(String.valueOf(paramInteger));
    paramSharedPreferences.apply();
  }
  
  protected static void a(Integer paramInteger, String paramString, SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putString(String.valueOf(paramInteger), paramString);
    paramSharedPreferences.apply();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/b/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */