package com.tencent.mm.sdk.a.a;

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
      com.tencent.mm.sdk.b.b.b("MicroMsg.SDK.MMessage", "send fail, invalid argument");
      return false;
    }
    if (h.h(parama.ab))
    {
      com.tencent.mm.sdk.b.b.b("MicroMsg.SDK.MMessage", "send fail, action is null");
      return false;
    }
    String str1 = null;
    if (!h.h(parama.aa)) {
      str1 = parama.aa + ".permission.MM_MESSAGE";
    }
    Intent localIntent = new Intent(parama.ab);
    if (parama.Z != null) {
      localIntent.putExtras(parama.Z);
    }
    String str2 = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 587268097);
    localIntent.putExtra("_mmessage_appPackage", str2);
    localIntent.putExtra("_mmessage_content", parama.Y);
    localIntent.putExtra("_mmessage_checksum", b.a(parama.Y, 587268097, str2));
    paramContext.sendBroadcast(localIntent, str1);
    com.tencent.mm.sdk.b.b.e("MicroMsg.SDK.MMessage", "send mm message, intent=" + localIntent + ", perm=" + str1);
    return true;
  }
  
  public static final class a
  {
    public String Y;
    public Bundle Z;
    public String aa;
    public String ab;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */