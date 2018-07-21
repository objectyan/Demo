package com.baidu.carlife.wechat.a.b;

import android.text.TextUtils;
import android.util.Log;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Iterator;

public class b
{
  public static final char[] a;
  public static final byte[][] b;
  private static final String c = "HanziToPinyin";
  private static final boolean d = false;
  private static final String e = "阿";
  private static final String f = "鿿";
  private static final Collator g;
  private static b h;
  private final boolean i;
  
  protected b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  private a a(char paramChar)
  {
    a locala = new a();
    Object localObject = Character.toString(paramChar);
    locala.f = ((String)localObject);
    int j = -1;
    if (paramChar < 'Ā')
    {
      locala.e = 1;
      locala.g = ((String)localObject);
    }
    do
    {
      return locala;
      int k = g.compare((String)localObject, "阿");
      if (k < 0)
      {
        locala.e = 3;
        locala.g = ((String)localObject);
        return locala;
      }
      int n;
      int m;
      int i2;
      int i1;
      if (k == 0)
      {
        locala.e = 2;
        j = 0;
        locala.e = 2;
        n = k;
        m = j;
        if (j < 0)
        {
          i2 = 0;
          i1 = a.length - 1;
        }
      }
      for (;;)
      {
        n = k;
        m = j;
        if (i2 <= i1)
        {
          j = (i2 + i1) / 2;
          String str = Character.toString(a[j]);
          k = g.compare((String)localObject, str);
          if (k == 0)
          {
            m = j;
            n = k;
          }
        }
        else
        {
          j = m;
          if (n < 0) {
            j = m - 1;
          }
          localObject = new StringBuilder();
          k = 0;
          while ((k < b[j].length) && (b[j][k] != 0))
          {
            ((StringBuilder)localObject).append((char)b[j][k]);
            k += 1;
          }
          m = g.compare((String)localObject, "鿿");
          if (m > 0)
          {
            locala.e = 3;
            locala.g = ((String)localObject);
            return locala;
          }
          k = m;
          if (m != 0) {
            break;
          }
          locala.e = 2;
          j = a.length - 1;
          k = m;
          break;
        }
        if (k > 0) {
          i2 = j + 1;
        } else {
          i1 = j - 1;
        }
      }
      locala.g = ((StringBuilder)localObject).toString();
    } while (!TextUtils.isEmpty(locala.g));
    locala.e = 3;
    locala.g = locala.f;
    return locala;
  }
  
  public static b a()
  {
    try
    {
      if (h == null) {
        h = new b(true);
      }
      b localb = h;
      return localb;
    }
    finally {}
  }
  
  private void a(StringBuilder paramStringBuilder, ArrayList<a> paramArrayList, int paramInt)
  {
    String str = paramStringBuilder.toString();
    paramArrayList.add(new a(paramInt, str, str));
    paramStringBuilder.setLength(0);
  }
  
  private static boolean b()
  {
    char c1 = a[0];
    Object localObject = Character.toString(c1);
    char[] arrayOfChar = a;
    int k = arrayOfChar.length;
    int j = 0;
    if (j < k)
    {
      char c2 = arrayOfChar[j];
      if (c1 == c2) {}
      for (;;)
      {
        j += 1;
        break;
        String str = Character.toString(c2);
        if (g.compare((String)localObject, str) >= 0)
        {
          Log.e("HanziToPinyin", "Internal error in Unihan table. The last string \"" + (String)localObject + "\" is greater than current string \"" + str + "\".");
          return false;
        }
        localObject = str;
      }
    }
    return true;
  }
  
  public String a(String paramString)
  {
    Object localObject = b(paramString);
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
      return "";
    }
    paramString = new StringBuffer();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.append(((a)((Iterator)localObject).next()).g);
    }
    return paramString.toString().toLowerCase();
  }
  
  public ArrayList<a> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!this.i) || (TextUtils.isEmpty(paramString))) {}
    StringBuilder localStringBuilder;
    int m;
    do
    {
      return localArrayList;
      int n = paramString.length();
      localStringBuilder = new StringBuilder();
      m = 1;
      int k = 0;
      if (k < n)
      {
        char c1 = paramString.charAt(k);
        int j;
        if (c1 == ' ')
        {
          j = m;
          if (localStringBuilder.length() > 0)
          {
            a(localStringBuilder, localArrayList, m);
            j = m;
          }
        }
        for (;;)
        {
          k += 1;
          m = j;
          break;
          if (c1 < 'Ā')
          {
            if ((m != 1) && (localStringBuilder.length() > 0)) {
              a(localStringBuilder, localArrayList, m);
            }
            j = 1;
            localStringBuilder.append(c1);
          }
          else
          {
            a locala = a(c1);
            if (locala.e == 2)
            {
              if (localStringBuilder.length() > 0) {
                a(localStringBuilder, localArrayList, m);
              }
              localArrayList.add(locala);
              j = 2;
            }
            else
            {
              if ((m != locala.e) && (localStringBuilder.length() > 0)) {
                a(localStringBuilder, localArrayList, m);
              }
              j = locala.e;
              localStringBuilder.append(c1);
            }
          }
        }
      }
    } while (localStringBuilder.length() <= 0);
    a(localStringBuilder, localArrayList, m);
    return localArrayList;
  }
  
  public static class a
  {
    public static final String a = " ";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public int e;
    public String f;
    public String g;
    
    public a() {}
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.e = paramInt;
      this.f = paramString1;
      this.g = paramString2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */