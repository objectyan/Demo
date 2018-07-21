package cz.msebera.android.httpclient.o;

public final class k
{
  public static boolean a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while (paramCharSequence.length() == 0) {
      return true;
    }
    return false;
  }
  
  public static boolean b(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (;;)
    {
      return true;
      int i = 0;
      while (i < paramCharSequence.length())
      {
        if (!Character.isWhitespace(paramCharSequence.charAt(i))) {
          return false;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */