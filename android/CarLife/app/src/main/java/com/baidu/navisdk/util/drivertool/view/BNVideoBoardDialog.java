package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drivertool.BNVideoRecordManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNVideoBoardDialog
  extends Dialog
{
  private SurfaceView mSurfaceView;
  private TextView mTimeTx;
  private Button mVideoBtn;
  
  public BNVideoBoardDialog(Context paramContext)
  {
    super(paramContext);
    Object localObject = JarUtils.getResources().newTheme();
    ((Resources.Theme)localObject).applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    setContentView(JarUtils.inflate((Activity)paramContext, 1711472678, null));
    this.mSurfaceView = ((SurfaceView)findViewById(1711866127));
    this.mVideoBtn = ((Button)findViewById(1711866128));
    this.mTimeTx = ((TextView)findViewById(1711866129));
    paramContext = getWindow();
    localObject = paramContext.getAttributes();
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = ScreenUtil.getInstance().getWidthPixels();
    ((WindowManager.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 3);
    paramContext.setAttributes((WindowManager.LayoutParams)localObject);
    paramContext.setGravity(48);
    initListener();
  }
  
  private void initListener()
  {
    if (this.mVideoBtn != null) {
      this.mVideoBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNaviModuleManager.getNaviActivity() != null) {
            BNVideoRecordManager.getInstance().stopRecordVideo();
          }
        }
      });
    }
  }
  
  public SurfaceView getVideoPanel()
  {
    return this.mSurfaceView;
  }
  
  public void setVideoButtonClickbale(boolean paramBoolean)
  {
    if (this.mVideoBtn != null) {
      this.mVideoBtn.setClickable(paramBoolean);
    }
  }
  
  public void updateTimeText(int paramInt)
  {
    if (this.mTimeTx != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("00:0");
      localStringBuffer.append(String.valueOf(paramInt));
      this.mTimeTx.setText(localStringBuffer.toString());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/view/BNVideoBoardDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */