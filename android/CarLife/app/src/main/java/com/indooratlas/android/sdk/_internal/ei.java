package com.indooratlas.android.sdk._internal;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;

public final class ei
{
  public static String a(String paramString, Object... paramVarArgs)
  {
    try
    {
      String str = String.format(Locale.US, paramString, paramVarArgs);
      return str;
    }
    catch (IllegalFormatException localIllegalFormatException) {}
    return paramString + " " + Arrays.toString(paramVarArgs);
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return true;
    }
    return paramCharSequence.toString().trim().equals("");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */