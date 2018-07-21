package cz.msebera.android.httpclient.o;

public class b
{
  public static void a(CharSequence paramCharSequence, String paramString)
  {
    if (k.a(paramCharSequence)) {
      throw new IllegalStateException(paramString + " is empty");
    }
  }
  
  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalStateException(paramString + " is null");
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void b(CharSequence paramCharSequence, String paramString)
  {
    if (k.b(paramCharSequence)) {
      throw new IllegalStateException(paramString + " is blank");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */