package com.tencent.mm.sdk.diffdev.a;

import android.util.Log;
import com.tencent.mm.sdk.b.d;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b
  implements OAuthListener
{
  b(a parama) {}
  
  public final void onAuthFinish(OAuthErrCode paramOAuthErrCode, String paramString)
  {
    Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[] { paramOAuthErrCode.toString(), paramString }));
    a.c(this.ag);
    Object localObject = new ArrayList();
    ((List)localObject).addAll(a.a(this.ag));
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onAuthFinish(paramOAuthErrCode, paramString);
    }
  }
  
  public final void onAuthGotQrcode(String paramString, byte[] paramArrayOfByte)
  {
    Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + paramString);
    Object localObject = new ArrayList();
    ((List)localObject).addAll(a.a(this.ag));
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onAuthGotQrcode(paramString, paramArrayOfByte);
    }
  }
  
  public final void onQrcodeScanned()
  {
    Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
    if (a.b(this.ag) != null) {
      a.b(this.ag).post(new c(this));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/diffdev/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */