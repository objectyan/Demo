package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;

abstract class x
  implements Closeable
{
  private af a;
  
  public x(String paramString1, String paramString2)
  {
    ae localae = new ae();
    this.a = new af(localae, paramString1);
    if (localae.getDatabasePath(".confd") != null) {
      a(paramString2);
    }
  }
  
  private void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  protected long a(ContentValues paramContentValues)
  {
    return this.a.a(null, paramContentValues);
  }
  
  public abstract long a(String paramString1, String paramString2);
  
  protected Cursor a(String paramString, int paramInt1, int paramInt2)
  {
    return this.a.a(null, null, null, null, null, paramString + " desc", paramInt2 + ", " + paramInt1);
  }
  
  protected Cursor a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString1 = paramString1 + "=? ";
    af localaf = this.a;
    paramString3 = paramString3 + " desc";
    String str = paramInt + "";
    return localaf.a(null, paramString1, new String[] { paramString2 }, null, null, paramString3, str);
  }
  
  public abstract ArrayList<w> a(int paramInt1, int paramInt2);
  
  public boolean a()
  {
    try
    {
      bool = this.a.a();
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bd.b(localException);
        boolean bool = false;
      }
    }
    finally {}
  }
  
  protected boolean a(long paramLong)
  {
    String str = paramLong + "";
    return this.a.a("_id=? ", new String[] { str }) > 0;
  }
  
  protected int b()
  {
    return this.a.b();
  }
  
  public abstract boolean b(long paramLong);
  
  public void close()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bd.b(localException);
      }
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */