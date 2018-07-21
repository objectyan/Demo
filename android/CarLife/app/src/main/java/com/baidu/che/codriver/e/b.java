package com.baidu.che.codriver.e;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.e;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static final String a = "PhoneManager";
  private static final Object b = new Object();
  private static b c;
  private static final String[] g = { "display_name", "data1", "data2" };
  private static final int h = 0;
  private static final int i = 1;
  private static final int j = 2;
  private Context d;
  private List<a> e = new ArrayList();
  private a f = a.b;
  
  public static b a()
  {
    if (c == null) {}
    synchronized (b)
    {
      if (c == null) {
        c = new b();
      }
      return c;
    }
  }
  
  private void a(final List<a> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    e.a().execute(new Runnable()
    {
      public void run()
      {
        int i = 0;
        new StringBuilder();
        JSONArray localJSONArray = new JSONArray();
        Object localObject1 = new HashSet();
        Object localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Set)localObject1).add(((a)((Iterator)localObject2).next()).a());
        }
        localObject1 = ((Set)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            i += 1;
            if (i <= 400) {}
          }
          else
          {
            h.b("PhoneManager", "all-contact:" + localJSONArray.toString() + "jarr size:" + localJSONArray.length());
            o.a().a(localJSONArray);
            return;
          }
          localJSONArray.put(localObject2);
        }
      }
    });
  }
  
  private String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.replaceAll("CH", "C").replaceAll("SH", "S").replaceAll("ZH", "Z").replaceAll("F", "H").replaceAll("R", "N").replaceAll("L", "N").replace(" ", "");
  }
  
  private void e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("display_name");
      localObject = ((JSONObject)localObject).getJSONArray("phone_number");
      int k = 0;
      while (k < paramString.length())
      {
        String str1 = paramString.getString(k);
        String str2 = ((JSONArray)localObject).getString(k).replaceAll("[-() ]+", "");
        a locala = new a();
        locala.a(str1);
        locala.b(str2);
        localArrayList.add(locala);
        k += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (localArrayList == null) {
        return;
      }
      e();
      this.e.addAll(localArrayList);
    }
  }
  
  private void f()
  {
    new b(null).execute(new Void[0]);
  }
  
  private List<a> g()
  {
    Object localObject2 = this.d.getContentResolver();
    localObject1 = null;
    try
    {
      localObject2 = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, g, null, null, "sort_key");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.e("PhoneManager", "queryContact Exception:" + localException.toString());
      }
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        String str1 = (((Cursor)localObject1).getString(1) + "").replaceAll("[-() ]+", "");
        String str2 = ((Cursor)localObject1).getString(0) + "";
        a locala = new a();
        locala.a(str2);
        locala.b(str1);
        localArrayList.add(locala);
      }
      ((Cursor)localObject1).close();
      return localArrayList;
    }
    if (localObject1 == null) {
      return null;
    }
  }
  
  public List<a> a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.e == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String str1 = d(c.f(paramString));
    paramString = null;
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.a().equals(paramString))
      {
        String str2 = d(c.f(locala.a()));
        if ((!TextUtils.isEmpty(str2)) && (str2.contains(str1)))
        {
          localArrayList.add(locala);
          paramString = locala.a();
        }
      }
    }
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(a paramAnonymousa1, a paramAnonymousa2)
      {
        return paramAnonymousa1.a().length() - paramAnonymousa2.a().length();
      }
    });
    return localArrayList;
  }
  
  public void a(Context paramContext)
  {
    this.d = paramContext;
    f();
  }
  
  public void a(a parama)
  {
    h.b("PhoneManager", "----onConnectedStatusChange------" + parama);
    this.f = parama;
  }
  
  public List<a> b(String paramString)
  {
    Object localObject1;
    if ((TextUtils.isEmpty(paramString)) || (this.e == null)) {
      localObject1 = null;
    }
    ArrayList localArrayList;
    do
    {
      return (List<a>)localObject1;
      localArrayList = new ArrayList();
      localObject1 = this.e.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((a)localObject2).a())) && (((a)localObject2).a().equals(paramString))) {
          localArrayList.add(localObject2);
        }
      }
      localObject1 = localArrayList;
    } while (localArrayList.size() > 0);
    paramString = d(c.f(paramString));
    Object localObject2 = this.e.iterator();
    for (;;)
    {
      localObject1 = localArrayList;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
      String str = d(c.f(((a)localObject1).a()));
      if ((!TextUtils.isEmpty(str)) && (str.contains(paramString))) {
        localArrayList.add(localObject1);
      }
    }
  }
  
  public void b()
  {
    f();
  }
  
  public int c()
  {
    return this.e.size();
  }
  
  public void c(String paramString)
  {
    e(paramString);
  }
  
  public a d()
  {
    return this.f;
  }
  
  public void e()
  {
    if (this.e != null) {
      this.e.clear();
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  private class b
    extends AsyncTask<Void, Void, List<a>>
  {
    private b() {}
    
    protected List<a> a(Void... paramVarArgs)
    {
      return b.a(b.this);
    }
    
    protected void a(List<a> paramList)
    {
      if (paramList == null) {
        return;
      }
      b.this.e();
      b.b(b.this).addAll(paramList);
      h.e("PhoneManager", "ContactTask-resultSize:" + paramList.size() + "");
      b.a(b.this, paramList);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */