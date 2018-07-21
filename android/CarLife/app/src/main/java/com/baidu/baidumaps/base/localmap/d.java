package com.baidu.baidumaps.base.localmap;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.navi.widget.MToast;
import com.baidu.platform.comapi.map.LocalMapResource;
import com.baidu.platform.comapi.util.NetworkUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class d
{
  public static Context a(boolean paramBoolean)
  {
    return c.a(paramBoolean);
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 1024L) {
      return "1K";
    }
    if (paramLong < 1048576L) {
      return String.format(Locale.getDefault(), "%dK", new Object[] { Long.valueOf(paramLong / 1024L) });
    }
    if (paramLong < 1073741824L) {
      return String.format(Locale.getDefault(), "%.1fM", new Object[] { Double.valueOf(paramLong / 1048576.0D) });
    }
    return String.format(Locale.getDefault(), "%.1fG", new Object[] { Double.valueOf(paramLong / 1.073741824E9D) });
  }
  
  public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    NetworkInfo localNetworkInfo = NetworkUtil.getActiveNetworkInfo(paramContext);
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting()))
    {
      if (localNetworkInfo.getType() == 1)
      {
        paramOnClickListener1.onClick(null, 0);
        f.a().j = false;
        return;
      }
      paramContext = new com.baidu.carlife.view.dialog.c(paramContext).c("提示").a(2131296730).d("取消").e("确定").r().a(new b()
      {
        public void onClick()
        {
          this.a.onClick(null, 1);
        }
      }).b(new b()
      {
        public void onClick()
        {
          this.a.onClick(null, 0);
        }
      });
      g.a().showDialog(paramContext);
      return;
    }
    MToast.show(paramContext, 2131296725);
  }
  
  public static void a(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static boolean a(LocalMapResource paramLocalMapResource)
  {
    return paramLocalMapResource.downloadStatus == 2;
  }
  
  public static boolean b(LocalMapResource paramLocalMapResource)
  {
    return (paramLocalMapResource.downloadStatus == 1) || (paramLocalMapResource.downloadStatus == 10);
  }
  
  public static boolean c(LocalMapResource paramLocalMapResource)
  {
    int i = paramLocalMapResource.downloadStatus;
    return (i == 3) || (i == 6) || (i == 8) || (i == 7) || (i == 5);
  }
  
  public static boolean d(LocalMapResource paramLocalMapResource)
  {
    return (paramLocalMapResource.downloadStatus == 4) || (paramLocalMapResource.downloadStatus == 9) || (paramLocalMapResource.updateStatus == 4);
  }
  
  public static boolean e(LocalMapResource paramLocalMapResource)
  {
    return (paramLocalMapResource.updateStatus == 4) || (paramLocalMapResource.downloadStatus == 9);
  }
  
  public static boolean f(LocalMapResource paramLocalMapResource)
  {
    return (!d(paramLocalMapResource)) && (paramLocalMapResource.needUpdate);
  }
  
  public static boolean g(LocalMapResource paramLocalMapResource)
  {
    if (!d(paramLocalMapResource)) {
      return false;
    }
    return paramLocalMapResource.needUpdate;
  }
  
  public static boolean h(LocalMapResource paramLocalMapResource)
  {
    if (f(paramLocalMapResource)) {
      return false;
    }
    switch (paramLocalMapResource.downloadStatus)
    {
    }
    return true;
  }
  
  public static boolean i(LocalMapResource paramLocalMapResource)
  {
    switch (paramLocalMapResource.type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean j(LocalMapResource paramLocalMapResource)
  {
    return paramLocalMapResource.mapsize + paramLocalMapResource.searchsize != paramLocalMapResource.mappatchsize + paramLocalMapResource.searchpatchsize;
  }
  
  public static void k(LocalMapResource paramLocalMapResource)
  {
    Object localObject = null;
    long l = 0L;
    int i = 0;
    int j = 0;
    int n = 0;
    int k = 0;
    int m = 0;
    LocalMapResource localLocalMapResource;
    if (paramLocalMapResource != null)
    {
      Iterator localIterator = paramLocalMapResource.children.iterator();
      for (;;)
      {
        i1 = i;
        if (!localIterator.hasNext()) {
          break label98;
        }
        localLocalMapResource = (LocalMapResource)localIterator.next();
        if (localLocalMapResource.type != 1) {
          break;
        }
        localObject = localLocalMapResource;
      }
      localLocalMapResource = f.a().h(localLocalMapResource.id);
      if (localLocalMapResource != null) {
        break label130;
      }
      int i1 = i + 1;
      label98:
      if (i1 <= 0) {
        break label235;
      }
      paramLocalMapResource.downloadStatus = 0;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((LocalMapResource)localObject).downloadStatus = paramLocalMapResource.downloadStatus;
        ((LocalMapResource)localObject).remainSize = l;
      }
      return;
      label130:
      if (a(localLocalMapResource)) {
        j += 1;
      }
      for (;;)
      {
        float f = localLocalMapResource.downloadProgress / 100.0F;
        l += ((float)(localLocalMapResource.mapsize + localLocalMapResource.searchsize) * (1.0F - f));
        break;
        if (b(localLocalMapResource)) {
          n += 1;
        } else if (c(localLocalMapResource)) {
          k += 1;
        } else if (d(localLocalMapResource)) {
          m += 1;
        } else {
          i += 1;
        }
      }
      label235:
      if ((j > 0) || (n > 0)) {
        paramLocalMapResource.downloadStatus = 1;
      } else if (k > 0) {
        paramLocalMapResource.downloadStatus = 3;
      } else if (m > 0) {
        paramLocalMapResource.downloadStatus = 4;
      } else {
        paramLocalMapResource.downloadStatus = 0;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/base/localmap/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */