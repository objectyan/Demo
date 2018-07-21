package com.baidu.platform.comapi.util.b;

import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.map.config.Preferences;

public class b
{
  private Preferences a = Preferences.build(c.f(), "skin_save_config");
  private Preferences b = Preferences.build(c.f(), "skin_use_config");
  private Preferences c = Preferences.build(c.f(), "skin_force_change_config");
  
  public static b a()
  {
    return a.a;
  }
  
  public void a(int paramInt)
  {
    this.b.putInt("key_plugin_theme_id", paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.putBoolean("key_skin_red_node" + paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    this.c.putLong("force_skin_start_date", paramLong);
  }
  
  public void a(String paramString)
  {
    this.b.putString("key_plugin_path", paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1);
    b(paramString2);
    a(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.putBoolean("travel_map", paramBoolean);
  }
  
  public String b()
  {
    return this.b.getString("key_plugin_path", "");
  }
  
  public void b(int paramInt)
  {
    this.b.putInt("key_skin_version", paramInt);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    this.a.putBoolean(String.valueOf(paramInt), paramBoolean);
  }
  
  public void b(long paramLong)
  {
    this.c.putLong("force_skin_end_date", paramLong);
  }
  
  public void b(String paramString)
  {
    this.b.putString("key_plugin_pkg", paramString);
  }
  
  public void c()
  {
    this.b.clear();
  }
  
  public void c(int paramInt)
  {
    this.b.putInt("key_engine_mode_id", paramInt);
  }
  
  public void c(String paramString)
  {
    this.b.putString("key_engine_skin_url", paramString);
  }
  
  public int d()
  {
    return this.b.getInt("key_plugin_theme_id", 0);
  }
  
  public void d(int paramInt)
  {
    this.b.putInt("key_plugin_begindownload", paramInt);
  }
  
  public void d(String paramString)
  {
    this.a.putBoolean(paramString, true);
  }
  
  public int e()
  {
    return this.b.getInt("key_skin_version", 0);
  }
  
  public void e(int paramInt)
  {
    this.a.putInt("key_plugin_login", paramInt);
  }
  
  public boolean e(String paramString)
  {
    return this.a.getBoolean(paramString, false);
  }
  
  public int f()
  {
    return this.b.getInt("key_engine_mode_id", 1);
  }
  
  public void f(String paramString)
  {
    this.c.putString("force_skin_url", paramString);
  }
  
  public boolean f(int paramInt)
  {
    return this.a.getBoolean("key_skin_red_node" + paramInt, true);
  }
  
  public String g()
  {
    return this.b.getString("key_engine_skin_url", "");
  }
  
  public void g(String paramString)
  {
    this.c.putString("force_skin_path", paramString);
  }
  
  public boolean g(int paramInt)
  {
    return this.a.getBoolean(String.valueOf(paramInt), true);
  }
  
  public String h()
  {
    return this.b.getString("key_plugin_pkg", "");
  }
  
  public void h(int paramInt)
  {
    this.a.putInt("skin_level", paramInt);
  }
  
  public int i()
  {
    return this.b.getInt("key_plugin_begindownload", -1);
  }
  
  public void i(int paramInt)
  {
    this.c.putInt("force_skin_theme_id", paramInt);
  }
  
  public int j()
  {
    return this.a.getInt("key_plugin_login", -1);
  }
  
  public void j(int paramInt)
  {
    this.c.putInt("force_skin_mode_id", paramInt);
  }
  
  public void k(int paramInt)
  {
    this.c.putInt("force_skin_used", paramInt);
  }
  
  public boolean k()
  {
    return this.b.getBoolean("travel_map", false);
  }
  
  public int l()
  {
    return this.a.getInt("skin_level", 0);
  }
  
  public void l(int paramInt)
  {
    this.c.putInt("force_skin_not_used", paramInt);
  }
  
  public int m()
  {
    return this.c.getInt("force_skin_theme_id", 0);
  }
  
  public void m(int paramInt)
  {
    this.b.putInt("key_skin_effective", paramInt);
  }
  
  public String n()
  {
    return this.c.getString("force_skin_url", "");
  }
  
  public int o()
  {
    return this.c.getInt("force_skin_mode_id", 1);
  }
  
  public long p()
  {
    return this.c.getLong("force_skin_start_date", 0L).longValue();
  }
  
  public long q()
  {
    return this.c.getLong("force_skin_end_date", 0L).longValue();
  }
  
  public int r()
  {
    return this.c.getInt("force_skin_used", 0);
  }
  
  public int s()
  {
    return this.c.getInt("force_skin_not_used", -1);
  }
  
  public String t()
  {
    return this.c.getString("force_skin_path", "");
  }
  
  public void u()
  {
    this.c.clear();
  }
  
  public int v()
  {
    return this.b.getInt("key_skin_effective", -1);
  }
  
  private static class a
  {
    static final b a = new b(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */