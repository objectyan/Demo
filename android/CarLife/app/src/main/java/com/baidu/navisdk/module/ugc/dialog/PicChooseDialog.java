package com.baidu.navisdk.module.ugc.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils.PicProcessResInfo;
import com.baidu.navisdk.module.ugc.utils.UgcMapsViewConstructor;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;

public class PicChooseDialog
  extends Dialog
  implements View.OnClickListener
{
  public static final String CAMERA_TEMP_FILE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_camera_temp.jpg";
  private static final int PHOTO_REQUEST_CAREMA = 1;
  private static final int PHOTO_REQUEST_GALLERY = 2;
  private PicProcessCallBack callBack = null;
  private TextView chooseAlbumBtn = null;
  private TextView chooseCameraBtn = null;
  private Context context;
  
  public PicChooseDialog(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    Resources.Theme localTheme = JarUtils.getResources().newTheme();
    localTheme.applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, localTheme);
    paramContext = JarUtils.inflate((Activity)paramContext, 1711472765, null);
    if (paramContext == null) {
      return;
    }
    this.chooseCameraBtn = ((TextView)paramContext.findViewById(1711867129));
    this.chooseAlbumBtn = ((TextView)paramContext.findViewById(1711867130));
    setContentView(paramContext);
    initListener();
  }
  
  private void initListener()
  {
    if (this.chooseCameraBtn != null) {
      this.chooseCameraBtn.setOnClickListener(this);
    }
    if (this.chooseAlbumBtn != null) {
      this.chooseAlbumBtn.setOnClickListener(this);
    }
  }
  
  public void gallery()
  {
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setType("image/*");
    ((Activity)this.context).startActivityForResult(localIntent, 2);
  }
  
  public void goToCapture()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", Uri.fromFile(new File(CAMERA_TEMP_FILE_PATH)));
    ((Activity)this.context).startActivityForResult(localIntent, 1);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ContentResolver localContentResolver;
    if (paramInt1 == 2) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getData();
        localContentResolver = ((Activity)this.context).getContentResolver();
      }
    }
    do
    {
      do
      {
        do
        {
          try
          {
            paramIntent = new PhotoProcessUtils().processAlbumPic(localContentResolver, paramIntent);
            if (this.callBack != null)
            {
              this.callBack.onSuccess(paramIntent);
              return;
            }
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
          }
        } while (this.callBack == null);
        this.callBack.onFail("异常");
        return;
      } while (paramInt1 != 1);
      if (paramInt2 == -1)
      {
        paramIntent = Uri.fromFile(new File(CAMERA_TEMP_FILE_PATH));
        localContentResolver = ((Activity)this.context).getContentResolver();
        try
        {
          paramIntent = new PhotoProcessUtils().processCameraPic(localContentResolver, paramIntent, CAMERA_TEMP_FILE_PATH);
          if (this.callBack != null)
          {
            this.callBack.onSuccess(paramIntent);
            return;
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
    } while (this.callBack == null);
    this.callBack.onFail("异常");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 1711867129) {
      if (!SystemAuth.checkAuth("android.permission.CAMERA", true, "没有照相机权限，请打开后重试")) {
        UgcMapsViewConstructor.requestPhotoCaptureAuth();
      }
    }
    while (paramView.getId() != 1711867130)
    {
      return;
      goToCapture();
      return;
    }
    gallery();
  }
  
  public void setListener(PicProcessCallBack paramPicProcessCallBack)
  {
    this.callBack = paramPicProcessCallBack;
  }
  
  public static abstract interface PicProcessCallBack
  {
    public abstract void onFail(String paramString);
    
    public abstract void onSuccess(PhotoProcessUtils.PicProcessResInfo paramPicProcessResInfo);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/dialog/PicChooseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */