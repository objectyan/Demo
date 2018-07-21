package com.baidu.carlife.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import org.json.JSONObject;

public class e
  implements Serializable
{
  public static final int a = 0;
  public static final int b = 100;
  public static final int c = 101;
  public static final int d = 102;
  public static final int e = 103;
  public static final int f = 104;
  public static final int g = 200;
  public int A;
  public Double B = Double.valueOf(0.0D);
  public int C;
  public String D;
  public String E;
  public List<f> F;
  public String h;
  public String i;
  public String j;
  public int k;
  public String l;
  public int m;
  public Integer n = Integer.valueOf(0);
  public int o;
  public String p;
  public String q;
  public int r;
  public int s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public static int a(e parame)
  {
    if (parame.o < parame.n.intValue()) {
      return 102;
    }
    if (parame.k == 2) {
      return 100;
    }
    if (parame.k == 0) {
      return 0;
    }
    if ((parame.k == 3) || (parame.k == 4)) {
      return 103;
    }
    if ((parame.k >= 6) && (parame.k <= 9)) {
      return 104;
    }
    return 101;
  }
  
  public static e a(e parame, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return parame;
    }
    e locale = parame;
    if (parame == null) {
      locale = new e();
    }
    locale.h = paramJSONObject.optString("sid");
    locale.i = paramJSONObject.optString("name");
    locale.A = paramJSONObject.optInt("avg");
    locale.j = paramJSONObject.optString("logo");
    locale.k = paramJSONObject.optInt("state", -1);
    locale.l = paramJSONObject.optString("notice");
    locale.D = paramJSONObject.optString("qnotice");
    locale.o = paramJSONObject.optInt("limit");
    locale.E = paramJSONObject.optString("discount");
    locale.w = paramJSONObject.optString("addr");
    locale.y = paramJSONObject.optString("tel");
    locale.z = paramJSONObject.optString("open");
    if (!TextUtils.isEmpty(locale.y))
    {
      parame = TextUtils.split(locale.y, " ");
      if (parame.length > 0) {
        locale.y = parame[0];
      }
    }
    locale.F = f.b(paramJSONObject.optJSONArray("queues"));
    return locale;
  }
  
  public static e a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    e locale = new e();
    locale.h = paramJSONObject.optString("id");
    locale.i = paramJSONObject.optString("name");
    locale.j = paramJSONObject.optString("logo");
    locale.B = Double.valueOf(paramJSONObject.optDouble("score"));
    locale.A = paramJSONObject.optInt("avg");
    locale.x = paramJSONObject.optString("style");
    locale.n = Integer.valueOf(paramJSONObject.optInt("distant"));
    locale.m = paramJSONObject.optInt("total");
    locale.l = paramJSONObject.optString("notice");
    return locale;
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 1000)) {
      return paramInt + "m";
    }
    if (paramInt >= 1000) {
      return new DecimalFormat("0.0").format(paramInt / 1000.0D) + "km";
    }
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */