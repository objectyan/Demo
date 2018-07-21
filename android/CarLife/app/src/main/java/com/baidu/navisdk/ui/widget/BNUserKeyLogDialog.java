package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.debug.BNEyeSpyPaperModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.TimerUtil;
import com.baidu.navisdk.util.common.TimerUtil.TimerCallBack;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNUserKeyLogDialog
  extends Dialog
  implements View.OnClickListener, TimerUtil.TimerCallBack
{
  private static final String TAG = "BNUserKeyLogDialog";
  private ImageView mAddTestPlanCb;
  private View mCancleView;
  private EditText mDespEText;
  private View mIssueIdCopyBtn;
  private TextView mIssueIdTv;
  private ImageView mLogSwitchCb;
  private BNEyeSpyPaperModel mModel = null;
  private TimerUtil mTimerUtil = null;
  private Button mUploadBtn;
  
  public BNUserKeyLogDialog(Context paramContext)
  {
    super(paramContext);
    Resources.Theme localTheme = JarUtils.getResources().newTheme();
    localTheme.applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, localTheme);
    paramContext = JarUtils.inflate((Activity)paramContext, 1711472777, null);
    setContentView(paramContext);
    this.mCancleView = paramContext.findViewById(1711867274);
    this.mUploadBtn = ((Button)paramContext.findViewById(1711867275));
    this.mLogSwitchCb = ((ImageView)paramContext.findViewById(1711867271));
    this.mAddTestPlanCb = ((ImageView)paramContext.findViewById(1711867273));
    this.mDespEText = ((EditText)paramContext.findViewById(1711867269));
    this.mIssueIdTv = ((TextView)paramContext.findViewById(1711867250));
    this.mIssueIdCopyBtn = paramContext.findViewById(1711867251);
    this.mModel = BNEyeSpyPaperController.getInstance().getModel();
    initListener();
    initCheckBox();
  }
  
  private void initCheckBox()
  {
    this.mModel.addToTestPlaner();
    updateAddTestPlanCheckBox(this.mModel.isInTestPlaner());
    updateLogSwitchCheckBox(LogUtil.LOGWRITE);
    this.mIssueIdTv.setText(this.mModel.generateProblemId());
  }
  
  private void initListener()
  {
    this.mTimerUtil = new TimerUtil();
    this.mTimerUtil.addCallback(this);
    this.mLogSwitchCb.setOnClickListener(this);
    this.mAddTestPlanCb.setOnClickListener(this);
    this.mUploadBtn.setOnClickListener(this);
    this.mCancleView.setOnClickListener(this);
    this.mIssueIdCopyBtn.setOnClickListener(this);
    this.mDespEText.setOnClickListener(this);
    setOnShowListener(new DialogInterface.OnShowListener()
    {
      public void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        BNUserKeyLogDialog.this.mTimerUtil.start(10);
      }
    });
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        BNEyeSpyPaperController.getInstance().onUserKeyLogDialogDismiss();
        BNUserKeyLogDialog.this.mTimerUtil.cancle();
      }
    });
  }
  
  public void onClick(View paramView)
  {
    this.mTimerUtil.cancle();
    if (this.mUploadBtn != null) {
      this.mUploadBtn.setText("上报");
    }
    switch (paramView.getId())
    {
    default: 
    case 1711867251: 
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 11);
      ((ClipboardManager)paramView.getContext().getSystemService("clipboard")).setText(this.mIssueIdTv.getText());
      TipTool.onCreateToastDialog(paramView.getContext(), "复制成功");
      return;
    case 1711867274: 
      dismiss();
      return;
    case 1711867271: 
      if (LogUtil.LOGWRITE) {}
      for (LogUtil.LOGWRITE = false;; LogUtil.LOGWRITE = true)
      {
        updateLogSwitchCheckBox(LogUtil.LOGWRITE);
        return;
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "普通日志开关已打开,请复现问题后点击右侧按钮上传日志");
      }
    case 1711867273: 
      if (this.mModel.isInTestPlaner()) {
        BNEyeSpyPaperController.getInstance().addToTestPlaner(false);
      }
      for (;;)
      {
        updateAddTestPlanCheckBox(this.mModel.isInTestPlaner());
        return;
        BNEyeSpyPaperController.getInstance().addToTestPlaner(true);
      }
    }
    this.mModel.mDespText = this.mDespEText.getText().toString();
    if (BNavigator.getInstance().isNaviBegin()) {}
    for (this.mModel.mUploadSource = 2;; this.mModel.mUploadSource = 1)
    {
      BNEyeSpyPaperController.getInstance().uploadLog();
      dismiss();
      return;
    }
  }
  
  public void onTick(int paramInt)
  {
    if (paramInt == 0) {
      dismiss();
    }
    while (this.mUploadBtn == null) {
      return;
    }
    this.mUploadBtn.setText("上报(" + paramInt + "s)");
  }
  
  public void updateAddTestPlanCheckBox(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      this.mAddTestPlanCb.setImageDrawable(JarUtils.getResources().getDrawable(1711408040));
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("BNUserKeyLogDialog", "Exception updateLogCheckBoxDrawable:" + localException.getMessage());
    }
    this.mAddTestPlanCb.setImageDrawable(JarUtils.getResources().getDrawable(1711408041));
    return;
  }
  
  public void updateLogSwitchCheckBox(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.mLogSwitchCb.setImageDrawable(JarUtils.getResources().getDrawable(1711408040));
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("BNUserKeyLogDialog", "Exception updateLogCheckBoxDrawable:" + localException.getMessage());
    }
    this.mLogSwitchCb.setImageDrawable(JarUtils.getResources().getDrawable(1711408041));
    return;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNUserKeyLogDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */