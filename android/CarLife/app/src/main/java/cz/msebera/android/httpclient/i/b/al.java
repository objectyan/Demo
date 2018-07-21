package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
public class al
  extends w
{
  private static final String[] d = { "GET", "POST", "HEAD" };
  
  protected boolean b(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = d;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */