package com.baidu.mapframework.commonlib.asynchttp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

public class PersistentCookieStore
  implements CookieStore
{
  private static final String a = "PersistentCookieStore";
  private static final String b = "CookiePrefsFile";
  private static final String c = "names";
  private static final String d = "cookie_";
  private final ConcurrentHashMap<String, Cookie> e;
  private final SharedPreferences f;
  private boolean g = false;
  
  public PersistentCookieStore(Context paramContext)
  {
    this.f = paramContext.getSharedPreferences("CookiePrefsFile", 0);
    this.e = new ConcurrentHashMap();
    paramContext = this.f.getString("names", null);
    if (paramContext != null)
    {
      paramContext = TextUtils.split(paramContext, ",");
      int j = paramContext.length;
      while (i < j)
      {
        String str = paramContext[i];
        Object localObject = this.f.getString("cookie_" + str, null);
        if (localObject != null)
        {
          localObject = decodeCookie((String)localObject);
          if (localObject != null) {
            this.e.put(str, localObject);
          }
        }
        i += 1;
      }
      clearExpired(new Date());
    }
  }
  
  public void addCookie(Cookie paramCookie)
  {
    if ((this.g) && (!paramCookie.isPersistent())) {
      return;
    }
    String str = paramCookie.getName() + paramCookie.getDomain();
    if (!paramCookie.isExpired(new Date())) {
      this.e.put(str, paramCookie);
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = this.f.edit();
      localEditor.putString("names", TextUtils.join(",", this.e.keySet()));
      localEditor.putString("cookie_" + str, encodeCookie(new SerializableCookie(paramCookie)));
      localEditor.commit();
      return;
      this.e.remove(str);
    }
  }
  
  protected String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      if (k < 16) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(Integer.toHexString(k));
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase(Locale.US);
  }
  
  public void clear()
  {
    SharedPreferences.Editor localEditor = this.f.edit();
    Iterator localIterator = this.e.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localEditor.remove("cookie_" + str);
    }
    localEditor.remove("names");
    localEditor.commit();
    this.e.clear();
  }
  
  public boolean clearExpired(Date paramDate)
  {
    boolean bool = false;
    SharedPreferences.Editor localEditor = this.f.edit();
    Iterator localIterator = this.e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Cookie)localEntry.getValue()).isExpired(paramDate))
      {
        this.e.remove(str);
        localEditor.remove("cookie_" + str);
        bool = true;
      }
    }
    if (bool) {
      localEditor.putString("names", TextUtils.join(",", this.e.keySet()));
    }
    localEditor.commit();
    return bool;
  }
  
  protected Cookie decodeCookie(String paramString)
  {
    paramString = new ByteArrayInputStream(hexStringToByteArray(paramString));
    try
    {
      paramString = ((SerializableCookie)new ObjectInputStream(paramString).readObject()).getCookie();
      return paramString;
    }
    catch (IOException paramString)
    {
      AsyncHttpClient.log.d("PersistentCookieStore", "IOException in decodeCookie", paramString);
      return null;
    }
    catch (ClassNotFoundException paramString)
    {
      AsyncHttpClient.log.d("PersistentCookieStore", "ClassNotFoundException in decodeCookie", paramString);
    }
    return null;
  }
  
  public void deleteCookie(Cookie paramCookie)
  {
    paramCookie = paramCookie.getName() + paramCookie.getDomain();
    this.e.remove(paramCookie);
    SharedPreferences.Editor localEditor = this.f.edit();
    localEditor.remove("cookie_" + paramCookie);
    localEditor.commit();
  }
  
  protected String encodeCookie(SerializableCookie paramSerializableCookie)
  {
    if (paramSerializableCookie == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramSerializableCookie);
      return byteArrayToHexString(localByteArrayOutputStream.toByteArray());
    }
    catch (IOException paramSerializableCookie)
    {
      AsyncHttpClient.log.d("PersistentCookieStore", "IOException in encodeCookie", paramSerializableCookie);
    }
    return null;
  }
  
  public List<Cookie> getCookies()
  {
    return new ArrayList(this.e.values());
  }
  
  protected byte[] hexStringToByteArray(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public void setOmitNonPersistentCookies(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/PersistentCookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */