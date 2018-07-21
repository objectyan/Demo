package com.baidu.baidumaps.base.localmap;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.util.MapDataUtil;
import com.baidu.navi.common.util.StorageInformation;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.platform.comapi.e.a;
import com.baidu.platform.comapi.map.LocalMapManager;
import com.baidu.platform.comapi.map.LocalMapResource;
import java.util.Iterator;
import java.util.List;

public class c
{
  static final long a = 3145728L;
  static final long b = 15728640L;
  public static boolean c = true;
  private static final long d = 2592000000L;
  private static final int e = 3;
  private static final String f = "您有%s个离线包存在更新";
  private static final String g = "您有%s个离线包超过60天未更新";
  private static final String h = "您有%s个离线包超过90天未更新";
  private static final String i = "您有%s个离线包已过期，无法使用，请您更新";
  private static boolean j = true;
  
  public static Context a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return NavMapAdapter.getInstance().getContainerActivity();
    }
    return com.baidu.platform.comapi.c.f();
  }
  
  public static String a()
  {
    int i1 = 1;
    int n = 1;
    int i5 = 0;
    int k = 0;
    int i6 = 0;
    int m = 0;
    List localList = LocalMapManager.getInstance().getUserResources();
    int i2 = i5;
    int i3 = i6;
    int i4 = i1;
    if (localList != null)
    {
      i2 = i5;
      i3 = i6;
      i4 = i1;
      if (localList.size() > 0)
      {
        i1 = 0;
        for (;;)
        {
          i2 = k;
          i3 = m;
          i4 = n;
          if (i1 >= localList.size()) {
            break;
          }
          i4 = k;
          i3 = m;
          i2 = n;
          if (localList.get(i1) != null)
          {
            i4 = k;
            i3 = m;
            i2 = n;
            if (((LocalMapResource)localList.get(i1)).updateStatus <= 4)
            {
              i4 = k;
              i3 = m;
              i2 = n;
              if (((LocalMapResource)localList.get(i1)).updateStatus >= n)
              {
                if (n != ((LocalMapResource)localList.get(i1)).updateStatus) {
                  k = 0;
                }
                i2 = ((LocalMapResource)localList.get(i1)).updateStatus;
                i4 = k + 1;
                i3 = m + 1;
              }
            }
          }
          i1 += 1;
          k = i4;
          m = i3;
          n = i2;
        }
      }
    }
    if (i3 >= 3) {
      return String.format("您有%s个离线包存在更新", new Object[] { Integer.valueOf(i3) });
    }
    if (i2 != 0)
    {
      switch (i4)
      {
      default: 
        return String.format("您有%s个离线包存在更新", new Object[] { Integer.valueOf(i2) });
      case 1: 
        return String.format("您有%s个离线包存在更新", new Object[] { Integer.valueOf(i2) });
      case 2: 
        return String.format("您有%s个离线包超过60天未更新", new Object[] { Integer.valueOf(i2) });
      case 3: 
        return String.format("您有%s个离线包超过90天未更新", new Object[] { Integer.valueOf(i2) });
      }
      return String.format("您有%s个离线包已过期，无法使用，请您更新", new Object[] { Integer.valueOf(i2) });
    }
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if ((!StorageSettings.getInstance().isExternalStorageEnabled()) || (!StorageSettings.getInstance().isHasExternalStoragePermission())) {}
    do
    {
      do
      {
        return;
        if (paramInt1 - paramInt2 > 0) {
          a.a().a("offlinemap_import_failnumber");
        }
        if (paramInt2 > 0) {
          break;
        }
        localObject = new MapDataUtil(a(false));
        if (((MapDataUtil)localObject).existsNotImportedData()) {
          ((MapDataUtil)localObject).showNotImportedDataTip();
        }
      } while (paramInt1 <= 0);
      Object localObject = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          b.a(c.a(false)).a();
        }
      };
      if (paramInt2 != 0)
      {
        Activity localActivity = (Activity)a(true);
        if ((j) && (localActivity != null) && (!localActivity.isFinishing()))
        {
          localObject = new com.baidu.carlife.view.dialog.c(localActivity).c("离线地图包导入提醒").b("恭喜！您已成功导入" + paramInt2 + "个城市的离线地图包。").d("立即查看").a(new com.baidu.carlife.core.screen.b()
          {
            public void onClick()
            {
              this.a.onClick(null, 0);
            }
          }).e("以后再说");
          g.a().showDialog((BaseDialog)localObject);
        }
      }
    } while (!c);
    b.a(a(false)).a(paramInt2, paramInt1, paramInt1 - paramInt2);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    j = paramBoolean1;
    c = paramBoolean2;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      return false;
      if ((StorageSettings.getInstance().isExternalStorageEnabled()) && (StorageSettings.getInstance().isHasExternalStoragePermission()))
      {
        List localList = LocalMapManager.getInstance().getUserResources();
        if ((localList != null) && (localList.size() > 0))
        {
          paramInt = 0;
          while (paramInt < localList.size())
          {
            if (a((LocalMapResource)localList.get(paramInt))) {
              return true;
            }
            paramInt += 1;
          }
        }
      }
    }
  }
  
  private static boolean a(LocalMapResource paramLocalMapResource)
  {
    return (paramLocalMapResource != null) && (paramLocalMapResource.updateStatus > 0) && (paramLocalMapResource.updateStatus <= 4);
  }
  
  public static void b()
  {
    f.a().j();
  }
  
  public static void b(int paramInt)
  {
    Object localObject = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GlobalConfig.getInstance().setIsAutoDownload(true);
        c.b();
      }
    };
    new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    };
    Activity localActivity = (Activity)a(true);
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      View localView = LinearLayout.inflate(localActivity, 2130968913, null);
      localObject = new com.baidu.carlife.view.dialog.c(localActivity).c("提示").a(localView).d("开启自动更新").e("以后再说").a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          this.a.onClick(null, 0);
        }
      });
      g.a().showDialog((BaseDialog)localObject);
    }
  }
  
  public static double c()
  {
    long l = 0L;
    Iterator localIterator = f.a().f().iterator();
    LocalMapResource localLocalMapResource;
    while (localIterator.hasNext())
    {
      localLocalMapResource = (LocalMapResource)localIterator.next();
      l += (localLocalMapResource.mapsize + localLocalMapResource.searchsize) / 100L * localLocalMapResource.downloadProgress;
    }
    localIterator = f.a().h().iterator();
    while (localIterator.hasNext())
    {
      localLocalMapResource = (LocalMapResource)localIterator.next();
      l = localLocalMapResource.mapsize + l + localLocalMapResource.searchsize;
    }
    return l;
  }
  
  public static void d()
  {
    j = true;
    c = true;
  }
  
  public static String e()
  {
    return GlobalConfig.getInstance().getLastLocationCityName();
  }
  
  public static long f()
  {
    return StorageSettings.getInstance().getCurrentStorage().getAvailableBytes();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/base/localmap/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */