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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drivertool.BNAttachmentManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolParams;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import com.baidu.navisdk.util.drivertool.model.DrivingToolIssueInfo;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BNDrivingToolIssueStoreDialog
  extends Dialog
{
  private Button mAddAttachBtn;
  private LinearLayout mAddAttachLl;
  private Button mCancelBtn;
  private Button mCreateIssueBtn;
  private EditText mIssueDespEt;
  private Spinner mIssueIDSp;
  private Spinner mIssueStateSp;
  private Spinner mIssueTypeSp;
  private Spinner mResponsiblePmSp;
  private TextView mSelectPicTx;
  private Button mStoreBtn;
  private int mType;
  
  public BNDrivingToolIssueStoreDialog(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mType = paramInt;
    Object localObject = JarUtils.getResources().newTheme();
    ((Resources.Theme)localObject).applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    paramContext = JarUtils.oldInflate((Activity)paramContext, 1711472674, null);
    setContentView(paramContext);
    this.mIssueIDSp = ((Spinner)paramContext.findViewById(1711866096));
    this.mIssueDespEt = ((EditText)paramContext.findViewById(1711866099));
    this.mIssueTypeSp = ((Spinner)paramContext.findViewById(1711866102));
    this.mResponsiblePmSp = ((Spinner)paramContext.findViewById(1711866105));
    this.mIssueStateSp = ((Spinner)paramContext.findViewById(1711866108));
    this.mCreateIssueBtn = ((Button)paramContext.findViewById(1711866093));
    this.mStoreBtn = ((Button)paramContext.findViewById(1711866113));
    this.mAddAttachBtn = ((Button)paramContext.findViewById(1711866110));
    this.mSelectPicTx = ((TextView)paramContext.findViewById(1711866111));
    this.mCancelBtn = ((Button)paramContext.findViewById(1711866112));
    this.mAddAttachLl = ((LinearLayout)paramContext.findViewById(1711866109));
    if (this.mType != 4) {
      this.mAddAttachLl.setVisibility(8);
    }
    paramContext = getWindow();
    localObject = paramContext.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = (ScreenUtil.getInstance().getWidthPixels() / 34 * 31);
    if (paramInt == 4) {}
    for (((WindowManager.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 45 * 27);; ((WindowManager.LayoutParams)localObject).height = (ScreenUtil.getInstance().getHeightPixels() / 40 * 21))
    {
      ((WindowManager.LayoutParams)localObject).gravity = 17;
      paramContext.setAttributes((WindowManager.LayoutParams)localObject);
      paramContext.setGravity(17);
      setStoreBtnState(false);
      initListener();
      initData();
      return;
    }
  }
  
  private void initData()
  {
    if ("0".equals(BNDrivingToolManager.getInstance().mRouteFlag))
    {
      BNDrivingToolManager.getInstance().mIssueFlag = "0";
      if (this.mType == 4) {
        BNDrivingToolManager.getInstance().mIssueFlag = "1";
      }
      BNDrivingToolManager.getInstance().asynPullIssueList();
      BNDrivingToolManager.getInstance().asynPullReliablePerson();
      localObject = BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime;
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        System.currentTimeMillis();
      }
      localObject = BNaviModuleManager.getNaviActivity();
      if (localObject != null) {
        break label103;
      }
    }
    label103:
    do
    {
      return;
      BNDrivingToolManager.getInstance().mIssueFlag = "0";
      BNDrivingToolManager.getInstance().mRouteFlag = "0";
      break;
      if (this.mIssueTypeSp != null)
      {
        ArrayAdapter localArrayAdapter = new ArrayAdapter((Context)localObject, 17367048, BNDrivingToolParams.ISSUE_TYPES);
        localArrayAdapter.setDropDownViewResource(17367049);
        this.mIssueTypeSp.setAdapter(localArrayAdapter);
      }
    } while (this.mIssueStateSp == null);
    Object localObject = new ArrayAdapter((Context)localObject, 17367048, BNDrivingToolParams.ISSUE_STATUS);
    ((ArrayAdapter)localObject).setDropDownViewResource(17367049);
    this.mIssueStateSp.setAdapter((SpinnerAdapter)localObject);
  }
  
  private void initListener()
  {
    if (this.mCreateIssueBtn != null) {
      this.mCreateIssueBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick(1500L)) {
            return;
          }
          BNDrivingToolManager.getInstance().mIssueFlag = "1";
          BNDrivingToolManager.getInstance().asynPullIssueList();
        }
      });
    }
    if (this.mIssueIDSp != null) {
      this.mIssueIDSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = BNDrivingToolManager.getInstance().getIssueInfo();
          paramAnonymousView = BNDrivingToolManager.getInstance().mIssueList;
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView.mIssueID = ((String)paramAnonymousView.get(paramAnonymousInt)).trim();
            if (BNDrivingToolManager.getInstance().isIssueNewCreate(paramAnonymousAdapterView.mIssueID)) {
              break label93;
            }
            BNDrivingToolIssueStoreDialog.this.setStoreViewEnable(false);
            if (!"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(paramAnonymousAdapterView.mIssueID)) {
              break label104;
            }
            BNDrivingToolManager.getInstance().isIssueRet = false;
          }
          for (;;)
          {
            if (!BNDrivingToolManager.getInstance().isIssueRet) {
              break label157;
            }
            BNDrivingToolIssueStoreDialog.this.setStoreBtnState(true);
            return;
            label93:
            BNDrivingToolIssueStoreDialog.this.setStoreViewEnable(true);
            break;
            label104:
            if (BNDrivingToolManager.getInstance().isNoDrivingTest)
            {
              if (BNAttachmentManager.getInstance().mFilePathList.size() <= 0) {
                BNDrivingToolManager.getInstance().isIssueRet = false;
              } else {
                BNDrivingToolManager.getInstance().isIssueRet = true;
              }
            }
            else {
              BNDrivingToolManager.getInstance().isIssueRet = true;
            }
          }
          label157:
          BNDrivingToolIssueStoreDialog.this.setStoreBtnState(false);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
    }
    if (this.mIssueDespEt != null) {
      BNDrivingToolManager.getInstance().getIssueInfo().mIssueDescrption = this.mIssueDespEt.getText().toString().trim();
    }
    if (this.mIssueTypeSp != null) {
      this.mIssueTypeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = BNDrivingToolManager.getInstance().getIssueInfo();
          if (BNDrivingToolParams.ISSUE_TYPES[paramAnonymousInt].equals("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -"))
          {
            paramAnonymousAdapterView.mIssueType = null;
            return;
          }
          paramAnonymousAdapterView.mIssueType = String.valueOf(paramAnonymousInt - 1);
          BNDrivingToolManager.getInstance().updateReliableList(paramAnonymousInt - 1);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
    }
    if (this.mResponsiblePmSp != null) {
      this.mResponsiblePmSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = BNDrivingToolManager.getInstance().getIssueInfo();
          paramAnonymousView = BNDrivingToolManager.getInstance().mReliablePersonList;
          if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
          {
            paramAnonymousView = (String)paramAnonymousView.get(paramAnonymousInt);
            if ((paramAnonymousView != null) && (paramAnonymousView.equals("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -"))) {
              paramAnonymousAdapterView.mPersonReliableID = null;
            }
          }
          else
          {
            return;
          }
          paramAnonymousAdapterView.mPersonReliableID = ((String)BNDrivingToolManager.getInstance().mReliablePersonMap.get(paramAnonymousView));
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
    }
    if (this.mIssueStateSp != null) {
      this.mIssueStateSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = BNDrivingToolManager.getInstance().getIssueInfo();
          if (BNDrivingToolParams.ISSUE_STATUS[paramAnonymousInt].equals("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -"))
          {
            paramAnonymousAdapterView.mIssueStatus = null;
            return;
          }
          paramAnonymousAdapterView.mIssueStatus = String.valueOf(paramAnonymousInt - 1);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
    }
    if (this.mAddAttachBtn != null) {
      this.mAddAttachBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNAttachmentManager.getInstance().startSelectPicture();
        }
      });
    }
    if (this.mStoreBtn != null) {
      this.mStoreBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask(getClass().getSimpleName(), null)new BNWorkerConfig
          {
            protected String execute()
            {
              int i = 1;
              if (BNDrivingToolIssueStoreDialog.this.mType == 3)
              {
                BNScreentShotManager.sIsInThread = true;
                BNScreentShotManager.getInstance().handleSave();
              }
              BNDrivingToolManager.getInstance().getIssueInfo().mIssueDescrption = BNDrivingToolIssueStoreDialog.this.mIssueDespEt.getText().toString().trim();
              if (!BNDrivingToolIssueStoreDialog.this.mResponsiblePmSp.isEnabled()) {}
              for (;;)
              {
                if (i != 0)
                {
                  DrivingToolIssueInfo localDrivingToolIssueInfo = BNDrivingToolManager.getInstance().getIssueInfo();
                  localDrivingToolIssueInfo.mIssueType = null;
                  localDrivingToolIssueInfo.mPersonReliableID = null;
                  localDrivingToolIssueInfo.mIssueStatus = null;
                }
                if (BNDrivingToolIssueStoreDialog.this.mType == 4)
                {
                  BNAttachmentManager.getInstance().storeAttachmentIndex(BNDrivingToolIssueStoreDialog.this.mType);
                  label126:
                  BNDrivingToolManager.getInstance().clearIssueInfo();
                  BNAttachmentManager.getInstance().mFilePathList.clear();
                  if (BNScreentShotManager.getInstance().mCachePath == null) {}
                }
                try
                {
                  FileUtils.del(BNScreentShotManager.getInstance().mCachePath);
                  if (BNDrivingToolIssueStoreDialog.this.mType == 3)
                  {
                    BNScreentShotManager.sIsInThread = false;
                    return null;
                    i = 0;
                    continue;
                    BNDrivingToolManager.getInstance().storeIndexFile(BNDrivingToolIssueStoreDialog.this.mType);
                    break label126;
                  }
                  BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitListener-" + getClass().getSimpleName(), null)new BNWorkerConfig
                  {
                    protected String execute()
                    {
                      BNDrivingToolIssueStoreDialog.this.dismiss();
                      BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
                      BNDrivingToolIssueStoreDialog.this.setStoreBtnState(false);
                      return null;
                    }
                  }, new BNWorkerConfig(100, 0));
                  return null;
                }
                catch (IOException localIOException)
                {
                  for (;;) {}
                }
              }
            }
          }, new BNWorkerConfig(100, 0));
          if (BNDrivingToolIssueStoreDialog.this.mType == 3)
          {
            BNDrivingToolIssueStoreDialog.this.dismiss();
            BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            BNDrivingToolIssueStoreDialog.this.setStoreBtnState(false);
          }
        }
      });
    }
    if (this.mCancelBtn != null) {
      this.mCancelBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDrivingToolIssueStoreDialog.this.dismiss();
        }
      });
    }
  }
  
  public void setStoreBtnState(boolean paramBoolean)
  {
    if (this.mStoreBtn == null) {
      return;
    }
    if (paramBoolean) {
      this.mStoreBtn.setBackgroundColor(-16711936);
    }
    for (;;)
    {
      this.mStoreBtn.setClickable(paramBoolean);
      return;
      this.mStoreBtn.setBackgroundColor(-7829368);
    }
  }
  
  public void setStoreViewEnable(boolean paramBoolean)
  {
    if (this.mIssueTypeSp != null) {
      this.mIssueTypeSp.setEnabled(paramBoolean);
    }
    if (this.mIssueStateSp != null) {
      this.mIssueStateSp.setEnabled(paramBoolean);
    }
    if (this.mResponsiblePmSp != null) {
      this.mResponsiblePmSp.setEnabled(paramBoolean);
    }
  }
  
  public void updateAttachNumber(int paramInt)
  {
    this.mSelectPicTx.setText("图片数：" + String.valueOf(paramInt));
  }
  
  public void updateIssueListView()
  {
    if (this.mIssueIDSp != null)
    {
      Object localObject = BNDrivingToolManager.getInstance().mIssueList;
      if (localObject != null)
      {
        localObject = new ArrayAdapter(BNaviModuleManager.getNaviActivity(), 17367048, (List)localObject);
        ((ArrayAdapter)localObject).setDropDownViewResource(17367049);
        this.mIssueIDSp.setAdapter((SpinnerAdapter)localObject);
        if ((BNDrivingToolManager.getInstance().mIssueList != null) && (BNDrivingToolManager.getInstance().mIssueList.size() > 0) && (BNDrivingToolManager.getInstance().mIssueFlag.equals("1")))
        {
          int i = BNDrivingToolManager.getInstance().mIssueList.size() - 1;
          this.mIssueIDSp.setSelection(i, true);
          LogUtil.e("drivingTool", "set new create issue selcetion " + (String)BNDrivingToolManager.getInstance().mIssueList.get(i));
        }
      }
    }
  }
  
  public void updateNewIssueDefaultAction()
  {
    if (this.mIssueStateSp != null) {
      this.mIssueStateSp.setSelection(1);
    }
  }
  
  public void updateReliablePersonView()
  {
    if (this.mResponsiblePmSp != null)
    {
      Object localObject = BNDrivingToolManager.getInstance().mReliablePersonList;
      if (localObject != null)
      {
        Activity localActivity = BNaviModuleManager.getNaviActivity();
        if (localActivity != null)
        {
          localObject = new ArrayAdapter(localActivity, 17367048, (List)localObject);
          ((ArrayAdapter)localObject).setDropDownViewResource(17367049);
          this.mResponsiblePmSp.setAdapter((SpinnerAdapter)localObject);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/view/BNDrivingToolIssueStoreDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */