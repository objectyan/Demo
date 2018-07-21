package com.tencent.wxop.stat.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.wxop.stat.ag;
import com.tencent.wxop.stat.l;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

class f
{
  String a;
  String b = "2.0.3";
  DisplayMetrics c;
  int d = Build.VERSION.SDK_INT;
  String e = Build.MODEL;
  String f = Build.MANUFACTURER;
  String g = Locale.getDefault().getLanguage();
  String h;
  String i;
  String j;
  String k;
  int l = 0;
  String m = null;
  String n = null;
  Context o = null;
  private String p = null;
  private String q = null;
  private String r = null;
  private String s = null;
  
  private f(Context paramContext)
  {
    this.o = paramContext.getApplicationContext();
    this.c = m.d(this.o);
    this.a = m.j(this.o);
    this.h = com.tencent.wxop.stat.f.c(this.o);
    this.i = m.i(this.o);
    this.j = TimeZone.getDefault().getID();
    this.l = m.o(this.o);
    this.k = m.p(this.o);
    this.m = this.o.getPackageName();
    if (this.d >= 14) {
      this.p = m.v(this.o);
    }
    this.q = m.u(this.o).toString();
    this.r = m.t(this.o);
    this.s = m.d();
    this.n = m.C(this.o);
  }
  
  void a(JSONObject paramJSONObject, Thread paramThread)
  {
    if (paramThread == null)
    {
      if (this.c != null)
      {
        paramJSONObject.put("sr", this.c.widthPixels + "*" + this.c.heightPixels);
        paramJSONObject.put("dpi", this.c.xdpi + "*" + this.c.ydpi);
      }
      if (l.a(this.o).e())
      {
        paramThread = new JSONObject();
        s.a(paramThread, "bs", s.d(this.o));
        s.a(paramThread, "ss", s.e(this.o));
        if (paramThread.length() > 0) {
          s.a(paramJSONObject, "wf", paramThread.toString());
        }
      }
      paramThread = s.a(this.o, 10);
      if ((paramThread != null) && (paramThread.length() > 0)) {
        s.a(paramJSONObject, "wflist", paramThread.toString());
      }
      s.a(paramJSONObject, "sen", this.p);
    }
    for (;;)
    {
      s.a(paramJSONObject, "pcn", m.q(this.o));
      s.a(paramJSONObject, "osn", Build.VERSION.RELEASE);
      s.a(paramJSONObject, "av", this.a);
      s.a(paramJSONObject, "ch", this.h);
      s.a(paramJSONObject, "mf", this.f);
      s.a(paramJSONObject, "sv", this.b);
      s.a(paramJSONObject, "osd", Build.DISPLAY);
      s.a(paramJSONObject, "prod", Build.PRODUCT);
      s.a(paramJSONObject, "tags", Build.TAGS);
      s.a(paramJSONObject, "id", Build.ID);
      s.a(paramJSONObject, "fng", Build.FINGERPRINT);
      s.a(paramJSONObject, "lch", this.n);
      s.a(paramJSONObject, "ov", Integer.toString(this.d));
      paramJSONObject.put("os", 1);
      s.a(paramJSONObject, "op", this.i);
      s.a(paramJSONObject, "lg", this.g);
      s.a(paramJSONObject, "md", this.e);
      s.a(paramJSONObject, "tz", this.j);
      if (this.l != 0) {
        paramJSONObject.put("jb", this.l);
      }
      s.a(paramJSONObject, "sd", this.k);
      s.a(paramJSONObject, "apn", this.m);
      s.a(paramJSONObject, "cpu", this.q);
      s.a(paramJSONObject, "abi", Build.CPU_ABI);
      s.a(paramJSONObject, "abi2", Build.CPU_ABI2);
      s.a(paramJSONObject, "ram", this.r);
      s.a(paramJSONObject, "rom", this.s);
      return;
      s.a(paramJSONObject, "thn", paramThread.getName());
      s.a(paramJSONObject, "qq", com.tencent.wxop.stat.f.d(this.o));
      s.a(paramJSONObject, "cui", com.tencent.wxop.stat.f.e(this.o));
      if ((m.c(this.r)) && (this.r.split("/").length == 2)) {
        s.a(paramJSONObject, "fram", this.r.split("/")[0]);
      }
      if ((m.c(this.s)) && (this.s.split("/").length == 2)) {
        s.a(paramJSONObject, "from", this.s.split("/")[0]);
      }
      if (ag.a(this.o).b(this.o) != null) {
        paramJSONObject.put("ui", ag.a(this.o).b(this.o).b());
      }
      s.a(paramJSONObject, "mid", com.tencent.wxop.stat.f.g(this.o));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */