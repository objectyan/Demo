package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNDrivingToolSettingDialog
  extends Dialog
{
  private ToggleButton mToggleBtn;
  private Button mUploadBtn;
  
  public BNDrivingToolSettingDialog(Context paramContext)
  {
    super(paramContext);
    Object localObject = JarUtils.getResources().newTheme();
    ((Resources.Theme)localObject).applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    paramContext = JarUtils.inflate((Activity)paramContext, 1711472676, null);
    setContentView(paramContext);
    this.mToggleBtn = ((ToggleButton)paramContext.findViewById(1711866120));
    this.mToggleBtn.setChecked(BNSettingManager.isRecordingHighDefinition());
    this.mUploadBtn = ((Button)paramContext.findViewById(1711866122));
    paramContext = getWindow();
    localObject = paramContext.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = (ScreenUtil.getInstance().getWidthPixels() / 3 * 2);
    ((WindowManager.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 4);
    ((WindowManager.LayoutParams)localObject).gravity = 17;
    paramContext.setAttributes((WindowManager.LayoutParams)localObject);
    paramContext.setGravity(17);
    initListener();
  }
  
  private void initListener()
  {
    if (this.mToggleBtn != null) {
      this.mToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            BNSettingManager.setRecordingHighDefinition(true);
            return;
          }
          BNSettingManager.setRecordingHighDefinition(false);
        }
      });
    }
    if (this.mUploadBtn != null) {
      this.mUploadBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(final View paramAnonymousView)
        {
          if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(1711670296));
          }
          boolean bool;
          do
          {
            return;
            BNDrivingToolSettingDialog.this.dismiss();
            BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
            bool = NetworkUtils.isWifiConnected();
            paramAnonymousView = BNaviModuleManager.getNaviActivity();
          } while (paramAnonymousView == null);
          if (bool)
          {
            BNDrivingToolManager.getInstance().uploadLocalMaterial(paramAnonymousView);
            return;
          }
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramAnonymousView);
          localBuilder.setMessage(JarUtils.getResources().getString(1711670297));
          localBuilder.setTitle("提示");
          localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              BNDrivingToolManager.getInstance().uploadLocalMaterial(paramAnonymousView);
            }
          });
          localBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            }
          });
          localBuilder.setOnDismissListener(new DialogInterface.OnDismissListener()
          {
            public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
            {
              BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            }
          });
          localBuilder.create().show();
        }
      });
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/view/BNDrivingToolSettingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */