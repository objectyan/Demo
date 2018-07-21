package com.baidu.carlife.connect;

import android.os.Build.VERSION;
import com.baidu.carlife.core.screen.presentation.a.f;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.util.p;
import com.baidu.carlife.view.dialog.FullScreenNoticeDialog;
import com.baidu.carlife.view.dialog.PushWebNoticeDialog;

public class a
{
  private static boolean a = false;
  
  public static void a()
  {
    if (d()) {
      p.a().c("lang_dong_updated", false);
    }
  }
  
  public static void b()
  {
    if ((d()) && (p.a().a("lang_dong_updated", true)) && (!a))
    {
      a = true;
      FullScreenNoticeDialog localFullScreenNoticeDialog = new FullScreenNoticeDialog(g.a().b().e());
      g.a().showDialog(localFullScreenNoticeDialog);
    }
  }
  
  public static void c()
  {
    PushWebNoticeDialog localPushWebNoticeDialog = new PushWebNoticeDialog(g.a().b().e());
    g.a().showDialog(localPushWebNoticeDialog);
  }
  
  private static boolean d()
  {
    return (Build.VERSION.SDK_INT >= 24) && (p.a().a("carlifevehicle_channel", "20022100").equals("20022102"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/connect/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */