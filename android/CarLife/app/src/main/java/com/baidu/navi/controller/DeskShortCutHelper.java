package com.baidu.navi.controller;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.net.Uri;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class DeskShortCutHelper
{
  private static final String TAG = "DeckShortCut";
  private Context mContext;
  
  public DeskShortCutHelper(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public boolean checkCompAdded()
  {
    boolean bool = false;
    if (PreferenceHelper.getInstance(this.mContext).getBoolean("comp_short_cut", false)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean checkHomeAdded()
  {
    boolean bool = false;
    if (PreferenceHelper.getInstance(this.mContext).getBoolean("home_short_cut", false)) {
      bool = true;
    }
    return bool;
  }
  
  public void createCompDeskShortCut()
  {
    if (PreferenceHelper.getInstance(this.mContext).getBoolean("comp_short_cut", false)) {
      return;
    }
    LogUtil.e("coder", "------createShortCut--------");
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getString(2131297172));
    localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.mContext, 2130837958));
    Intent localIntent2 = new Intent("com.baidu.navi.action.START");
    localIntent2.setData(Uri.parse("bdnavi://gocompanybyshortcut"));
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    this.mContext.sendBroadcast(localIntent1);
    PreferenceHelper.getInstance(this.mContext).putBoolean("comp_short_cut", true);
    LogUtil.e("DeckShortCut", "@移动统计 @设置-设置家公司-添加一键回公司");
  }
  
  public void createHomeDeskShortCut()
  {
    if (PreferenceHelper.getInstance(this.mContext).getBoolean("home_short_cut", false)) {
      return;
    }
    LogUtil.e("coder", "------createShortCut--------");
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getString(2131297173));
    localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.mContext, 2130837959));
    Intent localIntent2 = new Intent("com.baidu.navi.action.START");
    localIntent2.setData(Uri.parse("bdnavi://gohomebyshortcut"));
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    this.mContext.sendBroadcast(localIntent1);
    PreferenceHelper.getInstance(this.mContext).putBoolean("home_short_cut", true);
    LogUtil.e("DeckShortCut", "@移动统计 @设置-设置家公司-添加一键回家");
  }
  
  public void delCompDeskShortCut()
  {
    Intent localIntent1 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getString(2131297172));
    Intent localIntent2 = new Intent("com.baidu.navi.action.START");
    localIntent2.setData(Uri.parse("bdnavi://gocompanybyshortcut"));
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    this.mContext.sendBroadcast(localIntent1);
    PreferenceHelper.getInstance(this.mContext).putBoolean("comp_short_cut", false);
  }
  
  public void delHomeDeskShortCut()
  {
    Intent localIntent1 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getString(2131297173));
    Intent localIntent2 = new Intent("com.baidu.navi.action.START");
    localIntent2.setData(Uri.parse("bdnavi://gohomebyshortcut"));
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    this.mContext.sendBroadcast(localIntent1);
    PreferenceHelper.getInstance(this.mContext).putBoolean("home_short_cut", false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/DeskShortCutHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */