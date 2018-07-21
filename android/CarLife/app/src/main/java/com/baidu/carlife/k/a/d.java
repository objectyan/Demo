package com.baidu.carlife.k.a;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.util.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class d
{
  private static final String URL_AND = "&";
  private static final String URL_EQUAL = "=";
  private static final String URL_QUESTION = "?";
  protected ConcurrentHashMap<String, a> fileParams;
  private String signKey;
  private boolean signNeed;
  private String tag = "NetWorkRequest";
  protected List<NameValuePair> urlParams;
  
  public d()
  {
    init();
  }
  
  private static String calcUrlSign(List<NameValuePair> paramList)
  {
    StringBuffer localStringBuffer1 = new StringBuffer("navi");
    label108:
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramList = (NameValuePair)localIterator.next();
          StringBuffer localStringBuffer2 = localStringBuffer1.append(paramList.getName()).append("=");
          if (paramList.getValue() != null) {
            break label108;
          }
          paramList = "";
          localStringBuffer2.append(URLEncoder.encode(paramList, "UTF-8")).append("&");
        }
        paramList = paramList.getValue();
      }
      catch (UnsupportedEncodingException paramList)
      {
        localStringBuffer1.deleteCharAt(localStringBuffer1.length() - 1).append("bd44977f4225b957923ddefa781e8f93");
        return k.a(localStringBuffer1.toString());
      }
    }
  }
  
  public static String getUrlParamsString(d paramd, boolean paramBoolean, String paramString)
  {
    if ((paramd == null) || (paramd.urlParams.size() < 1)) {
      return "";
    }
    StringBuffer localStringBuffer1 = new StringBuffer("?");
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramd.urlParams.size())
        {
          Object localObject = (NameValuePair)paramd.urlParams.get(i);
          StringBuffer localStringBuffer2 = localStringBuffer1.append(((NameValuePair)localObject).getName()).append("=");
          if (((NameValuePair)localObject).getValue() == null)
          {
            localObject = "";
            localStringBuffer2.append(URLEncoder.encode((String)localObject, "UTF-8"));
            if (i >= paramd.urlParams.size() - 1) {
              continue;
            }
            localStringBuffer1.append("&");
            continue;
          }
          localObject = ((NameValuePair)localObject).getValue();
          continue;
        }
        if (paramBoolean) {
          localStringBuffer1.append(paramString).append("=").append(calcUrlSign(paramd.urlParams));
        }
      }
      catch (UnsupportedEncodingException paramd)
      {
        paramd.printStackTrace();
        continue;
        i += 1;
      }
      return localStringBuffer1.toString();
    }
  }
  
  private void init()
  {
    this.urlParams = new ArrayList();
    this.fileParams = new ConcurrentHashMap();
  }
  
  void closeInputSteams()
  {
    if (!this.fileParams.isEmpty())
    {
      Iterator localIterator = this.fileParams.entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if ((locala != null) && (locala.a != null)) {
          try
          {
            locala.a.close();
          }
          catch (IOException localIOException) {}
        }
      }
    }
  }
  
  public HttpEntity getEntity()
  {
    b localb = new b();
    Iterator localIterator;
    Object localObject;
    if (!this.urlParams.isEmpty())
    {
      localIterator = this.urlParams.iterator();
      while (localIterator.hasNext())
      {
        localObject = (NameValuePair)localIterator.next();
        if ((TextUtils.isEmpty(((NameValuePair)localObject).getName())) || (TextUtils.isEmpty(((NameValuePair)localObject).getValue()))) {
          localIterator.remove();
        } else {
          localb.a(((NameValuePair)localObject).getName(), ((NameValuePair)localObject).getValue());
        }
      }
      i.b(this.tag, "the post params is:" + this.urlParams.toString());
      if (this.signNeed) {
        localb.a(this.signKey, calcUrlSign(this.urlParams));
      }
    }
    if (!this.fileParams.isEmpty())
    {
      int i = 0;
      int j = this.fileParams.entrySet().size();
      localIterator = this.fileParams.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        a locala = (a)((Map.Entry)localObject).getValue();
        boolean bool;
        if (locala.a != null)
        {
          if (i != j - 1) {
            break label333;
          }
          bool = true;
          label257:
          if (locala.c == null) {
            break label338;
          }
          localb.a((String)((Map.Entry)localObject).getKey(), locala.a(), locala.a, locala.c, bool);
        }
        for (;;)
        {
          i.b(this.tag, "the post file is:" + locala.a());
          i += 1;
          break;
          label333:
          bool = false;
          break label257;
          label338:
          localb.a((String)((Map.Entry)localObject).getKey(), locala.a(), locala.a, bool);
        }
      }
    }
    return localb;
  }
  
  public List<NameValuePair> getUrlParams()
  {
    return this.urlParams;
  }
  
  public boolean isSignNeed()
  {
    return this.signNeed;
  }
  
  public void put(String paramString, File paramFile)
  {
    try
    {
      put(paramString, new FileInputStream(paramFile), paramFile.getName());
      return;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2)
  {
    put(paramString1, paramInputStream, paramString2, null);
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramInputStream != null)) {
      this.fileParams.put(paramString1, new a(paramInputStream, paramString2, paramString3));
    }
  }
  
  public void put(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = new BasicNameValuePair(paramString1, paramString2);
      this.urlParams.add(paramString1);
    }
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void sortParams()
  {
    if (this.urlParams != null) {
      Collections.sort(this.urlParams, new Comparator()
      {
        public int a(NameValuePair paramAnonymousNameValuePair1, NameValuePair paramAnonymousNameValuePair2)
        {
          return paramAnonymousNameValuePair1.getName().compareTo(paramAnonymousNameValuePair2.getName());
        }
      });
    }
  }
  
  public void toSign()
  {
    this.signKey = "sign";
    this.signNeed = true;
  }
  
  public void toSign(String paramString)
  {
    this.signKey = paramString;
    this.signNeed = true;
  }
  
  protected static class a
  {
    public InputStream a;
    public String b;
    public String c;
    
    public a(InputStream paramInputStream, String paramString1, String paramString2)
    {
      this.a = paramInputStream;
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public String a()
    {
      if (this.b != null) {
        return this.b;
      }
      return "nofilename";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */