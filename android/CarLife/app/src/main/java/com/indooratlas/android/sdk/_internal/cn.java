package com.indooratlas.android.sdk._internal;

import org.json.JSONArray;
import org.json.JSONException;

public final class cn
{
  public static double[] a(JSONArray paramJSONArray)
    throws JSONException
  {
    int j = paramJSONArray.length();
    double[] arrayOfDouble = new double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = paramJSONArray.getDouble(i);
      i += 1;
    }
    return arrayOfDouble;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */