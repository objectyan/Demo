package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNDrivingToolImageShowDialog
  extends Dialog
{
  private ImageView mImageView = null;
  
  public BNDrivingToolImageShowDialog(Context paramContext)
  {
    super(paramContext);
    Object localObject = JarUtils.getResources().newTheme();
    ((Resources.Theme)localObject).applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    paramContext = JarUtils.inflate((Activity)paramContext, 1711472673, null);
    setContentView(paramContext);
    this.mImageView = ((ImageView)paramContext.findViewById(1711866092));
    paramContext = getWindow();
    localObject = paramContext.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = (ScreenUtil.getInstance().getWidthPixels() / 2);
    ((WindowManager.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 2);
    paramContext.setAttributes((WindowManager.LayoutParams)localObject);
    paramContext.setGravity(17);
  }
  
  public void updateImage(Bitmap paramBitmap)
  {
    if (this.mImageView != null) {
      this.mImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/view/BNDrivingToolImageShowDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */