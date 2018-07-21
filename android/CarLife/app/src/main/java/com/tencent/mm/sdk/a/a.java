package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.h;

public final class a
{
  public static boolean a(Context paramContext, a parama)
  {
    if (paramContext == null)
    {
      com.tencent.mm.sdk.b.b.b("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      return false;
    }
    if (h.h(parama.W))
    {
      com.tencent.mm.sdk.b.b.b("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + parama.W);
      return false;
    }
    if (h.h(parama.X)) {
      parama.X = (parama.W + ".wxapi.WXEntryActivity");
    }
    com.tencent.mm.sdk.b.b.e("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + parama.W + ", targetClassName = " + parama.X);
    Intent localIntent = new Intent();
    localIntent.setClassName(parama.W, parama.X);
    if (parama.Z != null) {
      localIntent.putExtras(parama.Z);
    }
    String str = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 587268097);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", parama.Y);
    localIntent.putExtra("_mmessage_checksum", com.tencent.mm.sdk.a.a.b.a(parama.Y, 587268097, str));
    if (parama.flags == -1) {
      localIntent.addFlags(268435456).addFlags(134217728);
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        com.tencent.mm.sdk.b.b.e("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        com.tencent.mm.sdk.b.b.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", new Object[] { paramContext.getMessage() });
      }
      localIntent.setFlags(parama.flags);
    }
    return false;
  }
  
  public static final class a
  {
    public String W;
    public String X;
    public String Y;
    public Bundle Z;
    public int flags = -1;
    
    public final String toString()
    {
      return "targetPkgName:" + this.W + ", targetClassName:" + this.X + ", content:" + this.Y + ", flags:" + this.flags + ", bundle:" + this.Z;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */