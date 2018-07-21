package com.baidu.mapframework.common.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.widget.BMAlertDialog.Builder;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class MapDataUtil
{
  public static String previousVersion;
  private Context mContext;
  private String sdPath;
  
  public MapDataUtil(Context paramContext)
  {
    this.mContext = paramContext;
    this.sdPath = (StorageSettings.getInstance().getCurrentStorage().getRootPath() + "/BaiduMap/");
  }
  
  public boolean delSDFile(String paramString)
  {
    int i = 0;
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while (!paramString.exists());
    if (paramString.isFile())
    {
      paramString.delete();
      return true;
    }
    File[] arrayOfFile = paramString.listFiles();
    int j = arrayOfFile.length;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.isFile()) {
        localFile.delete();
      }
      for (;;)
      {
        i += 1;
        break;
        delSDFile(localFile.getPath());
      }
    }
    paramString.delete();
    return true;
  }
  
  protected void deleteNotImportedData()
  {
    ConcurrentManager.executeTask(Module.BASE_MAPVIEW_MODULE, new ConcurrentTask()
    {
      public void run()
      {
        MapDataUtil.this.delSDFile(MapDataUtil.this.sdPath + "Mapdata");
      }
    }, ScheduleConfig.forData());
  }
  
  public boolean existsImportedData()
  {
    Object localObject = new File(this.sdPath + "data");
    if (!((File)localObject).isDirectory()) {}
    for (;;)
    {
      return false;
      localObject = ((File)localObject).listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return paramAnonymousFile.isDirectory();
        }
      });
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = localObject.length - 1;
        while (i >= 0)
        {
          String[] arrayOfString = localObject[i].list(new FilenameFilter()
          {
            public boolean accept(File paramAnonymousFile, String paramAnonymousString)
            {
              return paramAnonymousString.endsWith(".dat");
            }
          });
          if ((arrayOfString != null) && (arrayOfString.length >= 0)) {
            return true;
          }
          i -= 1;
        }
      }
    }
  }
  
  public boolean existsNotImportedData()
  {
    Object localObject = new File(this.sdPath + "Mapdata");
    if (!((File)localObject).isDirectory()) {}
    do
    {
      return false;
      localObject = ((File)localObject).list(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.endsWith(".cfg");
        }
      });
    } while ((localObject == null) || (localObject.length <= 0));
    return true;
  }
  
  public void showNotImportedDataTip()
  {
    new BMAlertDialog.Builder(this.mContext).setTitle("离线地图包导入提醒").setMessage(2131296820).setPositiveButton("我知道了", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MapDataUtil.this.deleteNotImportedData();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        MapDataUtil.this.deleteNotImportedData();
      }
    }).show();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/util/MapDataUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */