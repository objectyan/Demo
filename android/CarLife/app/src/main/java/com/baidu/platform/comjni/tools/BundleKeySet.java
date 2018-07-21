package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

public class BundleKeySet
{
  public String[] getBundleKeys(Bundle paramBundle)
  {
    Object localObject = null;
    if (paramBundle == null) {}
    while (paramBundle.isEmpty()) {
      return (String[])localObject;
    }
    String[] arrayOfString = new String[paramBundle.size()];
    paramBundle = paramBundle.keySet();
    int i = 0;
    paramBundle = paramBundle.iterator();
    for (;;)
    {
      localObject = arrayOfString;
      if (!paramBundle.hasNext()) {
        break;
      }
      arrayOfString[i] = paramBundle.next().toString();
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/tools/BundleKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */