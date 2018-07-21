package com.baidu.carlife.wechat.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.carlife.core.a;
import com.baidu.carlife.wechat.b.c;
import com.baidu.carlife.wechat.b.i;
import java.util.HashSet;
import java.util.Set;

public final class b
{
  private static final String a = "wechathelper_prefs";
  private static final String b = "setting_mute";
  private static final String c = "setting_close_room_msg";
  private static final String d = "setting_auto_play";
  private static final String e = "blacklist_names_";
  private static SharedPreferences f = a.a().getSharedPreferences("wechathelper_prefs", 0);
  private static SharedPreferences.Editor g = f.edit();
  
  public static void a(Set<String> paramSet)
  {
    String str = c.a().f().a();
    g.putStringSet("blacklist_names_" + str, paramSet).commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    g.putBoolean("setting_mute", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    return f.getBoolean("setting_mute", false);
  }
  
  public static void b(boolean paramBoolean)
  {
    g.putBoolean("setting_close_room_msg", paramBoolean).commit();
  }
  
  public static boolean b()
  {
    return f.getBoolean("setting_close_room_msg", true);
  }
  
  public static void c(boolean paramBoolean)
  {
    g.putBoolean("setting_auto_play", paramBoolean).commit();
  }
  
  public static boolean c()
  {
    return f.getBoolean("setting_auto_play", true);
  }
  
  public static Set<String> d()
  {
    String str = c.a().f().a();
    return f.getStringSet("blacklist_names_" + str, new HashSet());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */