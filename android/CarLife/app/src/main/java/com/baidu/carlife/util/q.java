package com.baidu.carlife.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;

public class q
{
  private static final String a = "SignatureVerification";
  private static final String b = "30820251308201baa0030201020204547e9ea6300d06092a864886f70d0101050500306c310b300906035504061302434e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e310e300c060355040a13054261696475310e300c060355040b13054261696475311630140603550403130d4261696475204361726c6966653020170d3134313230333035323435345a180f32323838303931363035323435345a306c310b300906035504061302434e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e310e300c060355040a13054261696475310e300c060355040b13054261696475311630140603550403130d4261696475204361726c69666530819f300d06092a864886f70d010101050003818d0030818902818100c3ca5a15c69288130d34ec248ff8dfa281137a671fdf07c8ee0303661b9e69971038606b142736d8b90d1aa339588b3658b7b2b00a4c8cebcbcc6d6dbb5df5879be8a7140e460187a5605a5937c93c96d98b82c5cc4e786c5d46799b2f039452bdae7383bae4a716731db42ec7cac58eb86dd56c49d84b546cb485f23fa35ff10203010001300d06092a864886f70d01010505000381810042a9fd57c40d2995a4437bd2944bc3d1fdf3719524c80e849b61b439c684c73315446ff6b8328eb11a53fecf7fdb96432ed5eb9a063c67e4a6d466c0f0d907335c1a09911c2d964ec5520d5d9223089c6c898e5b7160c9626600a17cf3da56dfa46b1dc13011d9c1029902fe3e2aa83586d7dc904384f2e043b18d5ef58c4e27";
  private static final String c = "com.baidu.carlife";
  
  private static String a(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = "";
    localContext = paramContext;
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 64).signatures;
      localContext = paramContext;
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        localContext = paramContext;
        if (i >= j) {
          break;
        }
        localPackageManager = paramString[i];
        localContext = paramContext;
        paramContext = paramContext + localPackageManager.toCharsString();
        i += 1;
      }
      return localContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static boolean a(Context paramContext)
  {
    return "30820251308201baa0030201020204547e9ea6300d06092a864886f70d0101050500306c310b300906035504061302434e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e310e300c060355040a13054261696475310e300c060355040b13054261696475311630140603550403130d4261696475204361726c6966653020170d3134313230333035323435345a180f32323838303931363035323435345a306c310b300906035504061302434e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e310e300c060355040a13054261696475310e300c060355040b13054261696475311630140603550403130d4261696475204361726c69666530819f300d06092a864886f70d010101050003818d0030818902818100c3ca5a15c69288130d34ec248ff8dfa281137a671fdf07c8ee0303661b9e69971038606b142736d8b90d1aa339588b3658b7b2b00a4c8cebcbcc6d6dbb5df5879be8a7140e460187a5605a5937c93c96d98b82c5cc4e786c5d46799b2f039452bdae7383bae4a716731db42ec7cac58eb86dd56c49d84b546cb485f23fa35ff10203010001300d06092a864886f70d01010505000381810042a9fd57c40d2995a4437bd2944bc3d1fdf3719524c80e849b61b439c684c73315446ff6b8328eb11a53fecf7fdb96432ed5eb9a063c67e4a6d466c0f0d907335c1a09911c2d964ec5520d5d9223089c6c898e5b7160c9626600a17cf3da56dfa46b1dc13011d9c1029902fe3e2aa83586d7dc904384f2e043b18d5ef58c4e27".equals(a(paramContext, "com.baidu.carlife"));
  }
  
  public static boolean a(Context paramContext, com.baidu.carlife.core.screen.e parame)
  {
    if (f.jx != f.a.m) {}
    while ((com.baidu.carlife.core.e.t()) || (a(paramContext))) {
      return true;
    }
    i.e("SignatureVerification", "package signature check fail");
    x.a(paramContext, parame);
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */