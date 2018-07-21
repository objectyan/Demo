package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNDrivingToolUploadDialog
  extends Dialog
{
  private Button mContinueBtn;
  private TextView mResultTx;
  private TextView mSuccesstx;
  
  public BNDrivingToolUploadDialog(Context paramContext)
  {
    super(paramContext);
    Object localObject = JarUtils.getResources().newTheme();
    ((Resources.Theme)localObject).applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    paramContext = JarUtils.inflate((Activity)paramContext, 1711472677, null);
    setContentView(paramContext);
    this.mResultTx = ((TextView)paramContext.findViewById(1711866123));
    this.mContinueBtn = ((Button)paramContext.findViewById(1711866126));
    if (this.mContinueBtn != null) {
      this.mContinueBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
    }
    this.mSuccesstx = ((TextView)paramContext.findViewById(1711866125));
    paramContext = getWindow();
    localObject = paramContext.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = (ScreenUtil.getInstance().getWidthPixels() / 3 * 2);
    ((WindowManager.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 3);
    paramContext.setAttributes((WindowManager.LayoutParams)localObject);
    paramContext.setGravity(17);
  }
  
  public void updateUploadFailView(String paramString)
  {
    if (this.mResultTx != null) {
      this.mResultTx.setText(paramString);
    }
  }
  
  public void updateUploadSuccessView(String paramString)
  {
    if (this.mSuccesstx != null) {
      this.mSuccesstx.setText(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/view/BNDrivingToolUploadDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */