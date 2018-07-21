package com.baidu.carlife.n;

import android.content.Context;
import android.widget.TextView;
import com.baidu.carlife.core.i;

public class c
  extends com.baidu.carlife.view.dialog.c
{
  protected static final String e = "FirmwareUpdateDialog";
  public static final int f = 0;
  public static final int g = 1001;
  public static final int h = 1002;
  public static final int i = 1003;
  public static final int j = 1004;
  public static final int k = 1005;
  public static final int l = 1006;
  public static final int m = 1007;
  private TextView q;
  private TextView r;
  private int s = 0;
  private int t = 0;
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.s = paramInt;
  }
  
  protected void b()
  {
    super.b();
    this.q = ((TextView)findViewById(2131624270));
    this.r = ((TextView)findViewById(2131624271));
  }
  
  public int getDialogType()
  {
    return this.s;
  }
  
  public void i()
  {
    if (1001 == this.s)
    {
      i.b("FirmwareUpdateDialog", "Dialog set: " + this.s);
      j();
    }
    do
    {
      return;
      if (1002 == this.s)
      {
        k();
        return;
      }
      if (1003 == this.s)
      {
        l();
        return;
      }
      if (1004 == this.s)
      {
        m();
        return;
      }
      if (1005 == this.s)
      {
        n();
        return;
      }
      if (1006 == this.s)
      {
        o();
        return;
      }
    } while (1007 != this.s);
    p();
  }
  
  public void j()
  {
    b(2131296373);
    c(2131297335);
    b("当前以为最新固件，无需下载更新");
    if (this.r != null) {
      this.r.setVisibility(8);
    }
  }
  
  public void k()
  {
    b(2131296373);
    c(2131296264);
    d(2131296259);
    long l1 = this.t;
    long l2 = l1 % 1048576L;
    i.b("FirmwareUpdateDialog", "get firmware size: " + l1 + " | " + l2);
    b("检测到最新固件为(" + l1 / 1048576L + "." + (l2 / 1024L + 99L) / 100L + "M),请确认使用流量下载!");
    if (this.r != null) {
      this.r.setVisibility(0);
    }
  }
  
  public void l()
  {
    b(2131296373);
    c(2131296264);
    d(2131296259);
    long l1 = this.t;
    long l2 = l1 % 1048576L;
    i.b("FirmwareUpdateDialog", "get firmware size: " + l1 + " | " + l2);
    b("检测到最新固件大小为(" + l1 / 1048576L + "." + (l2 / 1024L + 99L) / 100L + "M)请确认是否立即下载!");
    if (this.r != null) {
      this.r.setVisibility(0);
    }
  }
  
  public void m()
  {
    b(2131296373);
    c(2131296264);
    d(2131296259);
    b("下载失败请重新下载");
    if (this.r != null) {
      this.r.setVisibility(8);
    }
  }
  
  public void n()
  {
    b(2131296373);
    c(2131296264);
    d(2131296259);
    b("已成功下载固件，是否立即推送到车机端进行安装，在固件升级过程中，请不要断开连接，请靠边停车后进行安装.");
    if (this.r != null) {
      this.r.setVisibility(0);
    }
  }
  
  public void o()
  {
    b(2131296373);
    c(2131296264);
    b("安装失败，请确认重新安装!");
    if (this.r != null) {
      this.r.setVisibility(8);
    }
  }
  
  public void p()
  {
    b(2131296373);
    c(2131296264);
    d(2131296259);
    b("已升级成功.");
    if (this.r != null) {
      this.r.setVisibility(8);
    }
  }
  
  public void setDialogType(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setNewAppSize(int paramInt)
  {
    this.t = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/n/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */