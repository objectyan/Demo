package com.baidu.navisdk.ui.download.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.download.view.BNOfflineDataMergeLoadingView;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.util.ArrayList;

public class BNOfflineDataVerticalListAdapter
  extends BNOfflineDataListAdapter
{
  private static final String DOWN_LOAD_LINKAGE_FLAG = "down.load.linkage.flag";
  public boolean hasClickDataDownLoad = false;
  public boolean hasClickDataUpdate = false;
  private BNDialog linkageDialog = null;
  private Activity mActivity;
  private Context mContext;
  private BNOfflineDataAdapterListener mDelegate;
  private long mDiskSpace = 0L;
  private ArrayList<OfflineDataInfo> mDownloadedItems;
  private Boolean mIsUndownload = Boolean.valueOf(true);
  private long mTotalDownloadSize = 0L;
  private ArrayList<OfflineDataInfo> mUnDownloadItems;
  
  public BNOfflineDataVerticalListAdapter(Activity paramActivity, BNOfflineDataAdapterListener paramBNOfflineDataAdapterListener)
  {
    this.mContext = paramActivity.getBaseContext();
    this.mDelegate = paramBNOfflineDataAdapterListener;
    this.mActivity = paramActivity;
    updateData();
  }
  
  private void hasShowLinkageDialog(Context paramContext)
  {
    PreferenceHelper.getInstance(paramContext).putBoolean("down.load.linkage.flag", true);
  }
  
  private void setVerticalListBackground(int paramInt, View paramView, ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    paramView.setBackgroundColor(JarUtils.getResources().getColor(1711800400));
    if (this.mIsUndownload.booleanValue())
    {
      if (paramInt < this.mUnDownloadItems.size())
      {
        paramView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407206));
        paramViewHolder.mListMargin.setVisibility(8);
      }
      for (;;)
      {
        paramView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407206));
        paramViewHolder.mTaskStatusIV.setVisibility(0);
        paramViewHolder.mListMargin.setVisibility(8);
        return;
        if (paramInt >= this.mUnDownloadItems.size())
        {
          paramView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407206));
          if (paramBoolean) {
            paramViewHolder.mListMargin.setVisibility(0);
          }
          paramViewHolder.mListDivider.setVisibility(8);
        }
      }
    }
    if (paramInt < this.mDownloadedItems.size())
    {
      paramView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407206));
      paramViewHolder.mListMargin.setVisibility(8);
    }
    for (;;)
    {
      paramViewHolder.mTaskStatusIV.setVisibility(8);
      return;
      if (paramInt >= this.mDownloadedItems.size())
      {
        paramView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407206));
        if (paramBoolean) {
          paramViewHolder.mListMargin.setVisibility(0);
        }
        paramViewHolder.mListDivider.setVisibility(8);
      }
    }
  }
  
  private boolean shouldShowLinkageDialog(Context paramContext, int paramInt)
  {
    return !BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt);
  }
  
  private void showLinkageDialog(Activity paramActivity, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    showLinkageDialog(paramActivity, paramBoolean1, paramInt, paramBoolean2, false);
  }
  
  private void showLinkageDialog(Activity paramActivity, final boolean paramBoolean1, final int paramInt, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    if (paramActivity == null) {
      return;
    }
    if (this.linkageDialog != null) {
      dimissLinkageDialog();
    }
    try
    {
      this.linkageDialog = new BNDialog(paramActivity).setTitleText(JarUtils.getResources().getString(1711669753)).setContentMessage(JarUtils.getResources().getString(1711669845)).setSecondBtnText(JarUtils.getResources().getString(1711669846)).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          if (paramBoolean3)
          {
            if (paramBoolean1)
            {
              BNOfflineDataManager.getInstance().downloadProvinceData(0);
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
              }
            }
            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt)) {
              BNOfflineDataManager.getInstance().startDownBaseMapData(paramInt);
            }
            BNOfflineDataManager.getInstance().downloadProvinceData(paramInt);
          }
          for (;;)
          {
            BNOfflineDataVerticalListAdapter.this.dimissLinkageDialog();
            return;
            if (paramBoolean2) {
              break;
            }
            BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
            if (paramBoolean1)
            {
              BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus2", null)new BNWorkerConfig
              {
                protected String execute()
                {
                  BNOfflineDataManager.getInstance().startDownloadRequest(0);
                  try
                  {
                    Thread.sleep(300L);
                    BNOfflineDataManager.getInstance().startDownloadRequest(BNOfflineDataVerticalListAdapter.11.this.val$provinceId);
                    return null;
                  }
                  catch (Exception localException)
                  {
                    for (;;) {}
                  }
                }
              }, new BNWorkerConfig(101, 0));
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
              }
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(paramInt);
              }
            }
            else
            {
              BNOfflineDataManager.getInstance().startDownloadRequest(paramInt);
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
              }
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(paramInt);
              }
            }
          }
          int k = 0;
          ArrayList localArrayList = BNOfflineDataManager.getInstance().getDownloadedList();
          int j = k;
          int i;
          if (localArrayList != null)
          {
            j = k;
            if (localArrayList.size() > 0) {
              i = 0;
            }
          }
          for (;;)
          {
            j = k;
            if (i < localArrayList.size())
            {
              if ((((OfflineDataInfo)localArrayList.get(i)).mTaskStatus == 10) && (((OfflineDataInfo)localArrayList.get(i)).mProvinceId == paramInt) && (((OfflineDataInfo)localArrayList.get(i)).isFakeUpdate))
              {
                ((OfflineDataInfo)localArrayList.get(i)).mTaskStatus = 12;
                BNOfflineDataManager.getInstance().sendUpdateSucessMsg(paramInt);
                j = 1;
              }
            }
            else
            {
              if (j == 0)
              {
                BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                BNOfflineDataManager.getInstance().updateProvinceData(paramInt);
              }
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
              }
              if (BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt)) {
                break;
              }
              BNOfflineDataManager.getInstance().startDownBaseMapData(paramInt);
              break;
            }
            i += 1;
          }
        }
      }).setFirstBtnText(JarUtils.getResources().getString(1711669755)).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          BNOfflineDataVerticalListAdapter.this.dimissLinkageDialog();
          BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 1);
          BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 0);
        }
      });
      hasShowLinkageDialog(paramActivity);
      this.linkageDialog.show();
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 1);
      BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 0);
    }
  }
  
  public void checkToStartDownloadRequest(OfflineDataInfo paramOfflineDataInfo, boolean paramBoolean)
  {
    int i = -1;
    if (paramOfflineDataInfo != null)
    {
      double d = paramOfflineDataInfo.mProgress / 100.0D;
      i = (int)(paramOfflineDataInfo.mSize * d);
      i = SDCardUtils.handleOfflinePathError(paramOfflineDataInfo.mSize - i, true);
    }
    if (i == 1) {}
    try
    {
      new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(1711669753)).setContentMessage(JarUtils.getResources().getString(1711669777)).setFirstBtnText(JarUtils.getResources().getString(1711669754)).show();
      return;
    }
    catch (Exception paramOfflineDataInfo) {}
    startCheckNetStatus(paramOfflineDataInfo.mProvinceId, paramBoolean);
    return;
  }
  
  public void chooseDownloadStrategy(final OfflineDataInfo paramOfflineDataInfo, final boolean paramBoolean)
  {
    int i = -1;
    if (paramOfflineDataInfo != null)
    {
      double d = paramOfflineDataInfo.mProgress / 100.0D;
      i = (int)(paramOfflineDataInfo.mSize * d);
      i = SDCardUtils.handleOfflinePathError(paramOfflineDataInfo.mSize - i, true);
    }
    if (i == 1) {}
    try
    {
      new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(1711669753)).setContentMessage(JarUtils.getResources().getString(1711669777)).setFirstBtnText(JarUtils.getResources().getString(1711669754)).show();
      return;
    }
    catch (Exception paramOfflineDataInfo) {}
    if (i != 0)
    {
      TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669776));
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.mContext))
    {
      TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669774));
      return;
    }
    if (NetworkUtils.isTypeNetworkAvailable(this.mContext, 1))
    {
      if ((paramOfflineDataInfo.mTaskStatus != 4) && (shouldShowLinkageDialog(this.mContext, paramOfflineDataInfo.mProvinceId)))
      {
        showLinkageDialog(this.mActivity, paramBoolean, paramOfflineDataInfo.mProvinceId, false, true);
        return;
      }
      if (paramBoolean)
      {
        BNOfflineDataManager.getInstance().downloadProvinceData(0);
        if ((paramOfflineDataInfo.mTaskStatus != 4) && (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0))) {
          BNOfflineDataManager.getInstance().startDownBaseMapData(0);
        }
      }
      BNOfflineDataManager.getInstance().downloadProvinceData(paramOfflineDataInfo.mProvinceId);
      return;
    }
    try
    {
      new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(1711669753)).setContentMessage(JarUtils.getResources().getString(1711669775)).setSecondBtnText(JarUtils.getResources().getString(1711669754)).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          if ((paramOfflineDataInfo.mTaskStatus != 4) && (BNOfflineDataVerticalListAdapter.this.shouldShowLinkageDialog(BNOfflineDataVerticalListAdapter.this.mContext, paramOfflineDataInfo.mProvinceId)))
          {
            BNOfflineDataVerticalListAdapter.this.showLinkageDialog(BNOfflineDataVerticalListAdapter.this.mActivity, paramBoolean, paramOfflineDataInfo.mProvinceId, false, true);
            return;
          }
          if (paramBoolean)
          {
            BNOfflineDataManager.getInstance().downloadProvinceData(0);
            if ((paramOfflineDataInfo.mTaskStatus != 4) && (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0))) {
              BNOfflineDataManager.getInstance().startDownBaseMapData(0);
            }
          }
          BNOfflineDataManager.getInstance().downloadProvinceData(paramOfflineDataInfo.mProvinceId);
        }
      }).setFirstBtnText(JarUtils.getResources().getString(1711669755)).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick() {}
      }).show();
      return;
    }
    catch (Exception paramOfflineDataInfo) {}
  }
  
  public void chooseUpdateStrategy(final OfflineDataInfo paramOfflineDataInfo)
  {
    int i = -1;
    if (paramOfflineDataInfo != null)
    {
      double d = paramOfflineDataInfo.mUpProgress / 100.0D;
      i = (int)(paramOfflineDataInfo.mUpSize * d);
      i = SDCardUtils.handleOfflinePathError(paramOfflineDataInfo.mUpSize - i, true);
    }
    if (i == 1) {}
    try
    {
      new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(1711669753)).setContentMessage(JarUtils.getResources().getString(1711669777)).setFirstBtnText(JarUtils.getResources().getString(1711669754)).show();
      BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 1);
      BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 0);
      do
      {
        return;
        if (i != 0)
        {
          TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669776));
          BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 1);
          BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 0);
          return;
        }
        if (!NetworkUtils.isNetworkAvailable(this.mContext))
        {
          TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669774));
          BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 1);
          BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 0);
          return;
        }
        if (!NetworkUtils.isTypeNetworkAvailable(this.mContext, 1)) {
          break;
        }
        if (shouldShowLinkageDialog(this.mContext, paramOfflineDataInfo.mProvinceId))
        {
          showLinkageDialog(this.mActivity, false, paramOfflineDataInfo.mProvinceId, true);
          return;
        }
        BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
        BNOfflineDataManager.getInstance().updateProvinceData(paramOfflineDataInfo.mProvinceId);
        if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
          BNOfflineDataManager.getInstance().startDownBaseMapData(0);
        }
      } while (BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramOfflineDataInfo.mProvinceId));
      BNOfflineDataManager.getInstance().startDownBaseMapData(paramOfflineDataInfo.mProvinceId);
      return;
      try
      {
        new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(1711669753)).setContentMessage(JarUtils.getResources().getString(1711669775)).setSecondBtnText(JarUtils.getResources().getString(1711669754)).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
        {
          public void onClick()
          {
            if (paramOfflineDataInfo.mProvinceId == 0)
            {
              BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
              BNOfflineDataManager.getInstance().updateProvinceData(paramOfflineDataInfo.mProvinceId);
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
              }
            }
            do
            {
              return;
              if (BNOfflineDataVerticalListAdapter.this.shouldShowLinkageDialog(BNOfflineDataVerticalListAdapter.this.mContext, paramOfflineDataInfo.mProvinceId))
              {
                BNOfflineDataVerticalListAdapter.this.showLinkageDialog(BNOfflineDataVerticalListAdapter.this.mActivity, false, paramOfflineDataInfo.mProvinceId, true);
                return;
              }
              BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
              BNOfflineDataManager.getInstance().updateProvinceData(paramOfflineDataInfo.mProvinceId);
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
              }
            } while (BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramOfflineDataInfo.mProvinceId));
            BNOfflineDataManager.getInstance().startDownBaseMapData(paramOfflineDataInfo.mProvinceId);
          }
        }).setFirstBtnText(JarUtils.getResources().getString(1711669755)).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
        {
          public void onClick()
          {
            BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 1);
            BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 0);
          }
        }).show();
        return;
      }
      catch (Exception localException1)
      {
        BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 1);
        BNOfflineDataManager.getInstance().memoryUserOper(paramOfflineDataInfo.mProvinceId, false, 0);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public void dimissLinkageDialog()
  {
    if (this.linkageDialog != null)
    {
      this.linkageDialog.dismiss();
      this.linkageDialog = null;
    }
  }
  
  public int getCount()
  {
    if (this.mIsUndownload.booleanValue()) {
      return this.mUnDownloadItems.size();
    }
    return this.mDownloadedItems.size();
  }
  
  public OfflineDataInfo getDownloadedListModelByPosition(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mUnDownloadItems != null)
    {
      localObject1 = localObject2;
      if (this.mDownloadedItems != null)
      {
        if (!this.mIsUndownload.booleanValue()) {
          break label63;
        }
        localObject1 = localObject2;
        if (paramInt >= 0)
        {
          localObject1 = localObject2;
          if (paramInt < this.mUnDownloadItems.size()) {
            localObject1 = (OfflineDataInfo)this.mUnDownloadItems.get(paramInt);
          }
        }
      }
    }
    label63:
    do
    {
      do
      {
        return (OfflineDataInfo)localObject1;
        localObject1 = localObject2;
      } while (paramInt < 0);
      localObject1 = localObject2;
    } while (paramInt >= this.mDownloadedItems.size());
    return (OfflineDataInfo)this.mDownloadedItems.get(paramInt);
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mUnDownloadItems != null)
    {
      localObject1 = localObject2;
      if (this.mDownloadedItems != null)
      {
        if (!this.mIsUndownload.booleanValue()) {
          break label63;
        }
        localObject1 = localObject2;
        if (paramInt >= 0)
        {
          localObject1 = localObject2;
          if (paramInt < this.mUnDownloadItems.size()) {
            localObject1 = (OfflineDataInfo)this.mUnDownloadItems.get(paramInt);
          }
        }
      }
    }
    label63:
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (paramInt < 0);
      localObject1 = localObject2;
    } while (paramInt >= this.mDownloadedItems.size());
    return (OfflineDataInfo)this.mDownloadedItems.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)getItem(paramInt);
    if ((paramView == null) || (localOfflineDataInfo == null))
    {
      paramView = JarUtils.inflate(this.mActivity, 1711472694, null);
      if (paramView == null) {
        try
        {
          if (this.mActivity != null)
          {
            paramView = new View(this.mActivity);
            return paramView;
          }
          return null;
        }
        catch (Exception paramView)
        {
          return null;
        }
      }
      paramViewGroup = new ViewHolder();
      paramViewGroup.mInfoLayout = ((RelativeLayout)paramView.findViewById(1711866353));
      paramViewGroup.mNameTV = ((TextView)paramView.findViewById(1711866355));
      paramViewGroup.mInfoTV = ((TextView)paramView.findViewById(1711866356));
      paramViewGroup.mProgressBarDownloading = ((ProgressBar)paramView.findViewById(1711866357));
      paramViewGroup.mProgressBarSuspend = ((ProgressBar)paramView.findViewById(1711866359));
      paramViewGroup.mProgressBarDownloadingNight = ((ProgressBar)paramView.findViewById(1711866358));
      paramViewGroup.mProgressBarSuspendNight = ((ProgressBar)paramView.findViewById(1711866360));
      paramViewGroup.mTaskStatusIV = ((ImageView)paramView.findViewById(1711866354));
      paramViewGroup.mListDivider = paramView.findViewById(1711866362);
      paramViewGroup.mListMargin = paramView.findViewById(1711866363);
      paramViewGroup.mMergeloadView = ((BNOfflineDataMergeLoadingView)paramView.findViewById(1711866361));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      if ((localOfflineDataInfo != null) && (paramViewGroup != null))
      {
        localOfflineDataInfo.formatStatusTips();
        LogUtil.e("OfflineData", "model.mName: " + localOfflineDataInfo.mName + "  model.mStatusTips: " + localOfflineDataInfo.mStatusTips + "  model.mTaskStatus111: " + localOfflineDataInfo.mTaskStatus + "  model.mDownloadRatio: " + localOfflineDataInfo.mDownloadRatio);
        paramViewGroup.mInfoLayout.setVisibility(0);
        paramViewGroup.mInfoTV.setVisibility(0);
        paramViewGroup.mNameTV.setText(localOfflineDataInfo.mName);
        paramViewGroup.mNameTV.setTextColor(-13421773);
        paramViewGroup.mInfoTV.setText(localOfflineDataInfo.mStatusTips);
        paramViewGroup.mInfoTV.setTextColor(localOfflineDataInfo.mStatusColor);
        paramViewGroup.mProgressBarDownloading.setVisibility(8);
        paramViewGroup.mProgressBarDownloadingNight.setVisibility(8);
        paramViewGroup.mProgressBarSuspend.setVisibility(8);
        paramViewGroup.mProgressBarSuspendNight.setVisibility(8);
        paramViewGroup.mMergeloadView.hideLoading();
        paramViewGroup.mTaskStatusIV.setTag(localOfflineDataInfo);
        paramViewGroup.mTaskStatusIV.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = (OfflineDataInfo)paramAnonymousView.getTag();
            if (paramAnonymousView == null) {
              return;
            }
            BNOfflineDataVerticalListAdapter.this.mDelegate.itemDeleteButtomClicked(paramAnonymousView);
          }
        });
        if ((localOfflineDataInfo.mTaskStatus != 5) && (localOfflineDataInfo.mTaskStatus != 1))
        {
          bool1 = bool2;
          if (localOfflineDataInfo.mTaskStatus != 10) {}
        }
        else
        {
          bool1 = false;
        }
        bool2 = bool1;
        switch (localOfflineDataInfo.mTaskStatus)
        {
        default: 
          bool2 = bool1;
        case 7: 
        case 14: 
        case 15: 
        case 18: 
          label580:
          if ((paramView != null) && (paramViewGroup != null)) {
            setVerticalListBackground(paramInt, paramView, paramViewGroup, bool2);
          }
          if ((paramViewGroup == null) || (paramViewGroup.mListDivider == null)) {
            break;
          }
        }
      }
      try
      {
        paramViewGroup.mListDivider.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407213));
        return paramView;
        paramViewGroup = (ViewHolder)paramView.getTag();
        continue;
        paramViewGroup.mListDivider.setVisibility(0);
        paramViewGroup.mTaskStatusIV.setImageDrawable(JarUtils.getResources().getDrawable(1711408076));
        bool2 = bool1;
        break label580;
        paramViewGroup.mTaskStatusIV.setImageDrawable(JarUtils.getResources().getDrawable(1711408078));
        if (1 != 0)
        {
          paramViewGroup.mProgressBarDownloading.setProgress(localOfflineDataInfo.mProgress);
          paramViewGroup.mProgressBarDownloading.setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.mListDivider.setVisibility(8);
          bool2 = bool1;
          break;
          paramViewGroup.mProgressBarDownloadingNight.setProgress(localOfflineDataInfo.mProgress);
          paramViewGroup.mProgressBarDownloadingNight.setVisibility(0);
        }
        paramViewGroup.mTaskStatusIV.setImageDrawable(JarUtils.getResources().getDrawable(1711408078));
        if (1 != 0)
        {
          paramViewGroup.mProgressBarDownloading.setProgress(localOfflineDataInfo.mProgress);
          paramViewGroup.mProgressBarDownloading.setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.mListDivider.setVisibility(8);
          bool2 = bool1;
          break;
          paramViewGroup.mProgressBarDownloadingNight.setProgress(localOfflineDataInfo.mProgress);
          paramViewGroup.mProgressBarDownloadingNight.setVisibility(0);
        }
        if (localOfflineDataInfo.mIsNewVer) {
          if (1 != 0)
          {
            paramViewGroup.mProgressBarSuspend.setProgress(localOfflineDataInfo.mUpProgress);
            paramViewGroup.mProgressBarSuspend.setVisibility(0);
          }
        }
        for (;;)
        {
          paramViewGroup.mListDivider.setVisibility(8);
          paramViewGroup.mTaskStatusIV.setImageDrawable(JarUtils.getResources().getDrawable(1711408074));
          bool2 = bool1;
          break;
          paramViewGroup.mProgressBarSuspendNight.setProgress(localOfflineDataInfo.mUpProgress);
          paramViewGroup.mProgressBarSuspendNight.setVisibility(0);
          continue;
          if (1 != 0)
          {
            paramViewGroup.mProgressBarSuspend.setProgress(localOfflineDataInfo.mProgress);
            paramViewGroup.mProgressBarSuspend.setVisibility(0);
          }
          else
          {
            paramViewGroup.mProgressBarSuspendNight.setProgress(localOfflineDataInfo.mProgress);
            paramViewGroup.mProgressBarSuspendNight.setVisibility(0);
          }
        }
        paramViewGroup.mListDivider.setVisibility(0);
        bool2 = bool1;
        break label580;
        if (1 != 0)
        {
          paramViewGroup.mProgressBarSuspend.setProgress(localOfflineDataInfo.mUpProgress);
          paramViewGroup.mProgressBarSuspend.setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.mListDivider.setVisibility(8);
          bool2 = bool1;
          break;
          paramViewGroup.mProgressBarSuspendNight.setProgress(localOfflineDataInfo.mUpProgress);
          paramViewGroup.mProgressBarSuspendNight.setVisibility(0);
        }
        if (1 != 0)
        {
          paramViewGroup.mProgressBarDownloading.setProgress(localOfflineDataInfo.mUpProgress);
          paramViewGroup.mProgressBarDownloading.setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.mListDivider.setVisibility(8);
          bool2 = bool1;
          break;
          paramViewGroup.mProgressBarDownloadingNight.setProgress(localOfflineDataInfo.mUpProgress);
          paramViewGroup.mProgressBarDownloadingNight.setVisibility(0);
        }
        paramViewGroup.mListDivider.setVisibility(0);
        bool2 = bool1;
        break label580;
        paramViewGroup.mMergeloadView.showLoading();
        bool2 = bool1;
        break label580;
        paramViewGroup.mListDivider.setVisibility(0);
        bool2 = bool1;
        break label580;
        paramViewGroup.mListDivider.setVisibility(0);
        bool2 = bool1;
        break label580;
        bool2 = bool1;
        if (paramViewGroup == null) {
          break label580;
        }
        paramViewGroup.mListDivider.setVisibility(8);
        paramViewGroup.mInfoLayout.setVisibility(8);
        paramViewGroup.mListMargin.setVisibility(8);
        bool2 = bool1;
      }
      catch (Exception paramViewGroup)
      {
        for (;;) {}
      }
    }
  }
  
  public long getmDiskSpace()
  {
    return this.mDiskSpace;
  }
  
  public Boolean getmIsUndownload()
  {
    return this.mIsUndownload;
  }
  
  public long getmTotalDownloadSize()
  {
    return this.mTotalDownloadSize;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  public void startCheckNetStatus(final int paramInt, final boolean paramBoolean)
  {
    if (!NetworkUtils.isNetworkAvailable(this.mContext))
    {
      TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669774));
      BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 1);
      BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 0);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!NetworkUtils.isTypeNetworkAvailable(this.mContext, 1)) {
            break label312;
          }
          if (paramInt != 0) {
            break;
          }
          BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus1", null)new BNWorkerConfig
          {
            protected String execute()
            {
              BNOfflineDataManager.getInstance().startDownloadRequest(0);
              try
              {
                Thread.sleep(300L);
                return null;
              }
              catch (Exception localException)
              {
                for (;;) {}
              }
            }
          }, new BNWorkerConfig(101, 0));
        } while (BNOfflineDataManager.getInstance().checkBaseMapDataExit(0));
        BNOfflineDataManager.getInstance().startDownBaseMapData(0);
        return;
        if (shouldShowLinkageDialog(this.mContext, paramInt))
        {
          showLinkageDialog(this.mActivity, paramBoolean, paramInt, false);
          return;
        }
        BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
        if (!paramBoolean) {
          break;
        }
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus2", null)new BNWorkerConfig
        {
          protected String execute()
          {
            BNOfflineDataManager.getInstance().startDownloadRequest(0);
            try
            {
              Thread.sleep(300L);
              BNOfflineDataManager.getInstance().startDownloadRequest(paramInt);
              return null;
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
          }
        }, new BNWorkerConfig(101, 0));
        if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
          BNOfflineDataManager.getInstance().startDownBaseMapData(0);
        }
      } while (BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt));
      BNOfflineDataManager.getInstance().startDownBaseMapData(paramInt);
      return;
      BNOfflineDataManager.getInstance().startDownloadRequest(paramInt);
      if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
        BNOfflineDataManager.getInstance().startDownBaseMapData(0);
      }
    } while (BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt));
    BNOfflineDataManager.getInstance().startDownBaseMapData(paramInt);
    return;
    try
    {
      label312:
      new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(1711669753)).setContentMessage(JarUtils.getResources().getString(1711669775)).setSecondBtnText(JarUtils.getResources().getString(1711669754)).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
          if (paramInt == 0)
          {
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus1", null)new BNWorkerConfig
            {
              protected String execute()
              {
                BNOfflineDataManager.getInstance().startDownloadRequest(0);
                try
                {
                  Thread.sleep(300L);
                  return null;
                }
                catch (Exception localException)
                {
                  for (;;) {}
                }
              }
            }, new BNWorkerConfig(101, 0));
            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
              BNOfflineDataManager.getInstance().startDownBaseMapData(0);
            }
          }
          do
          {
            do
            {
              return;
              if (BNOfflineDataVerticalListAdapter.this.shouldShowLinkageDialog(BNOfflineDataVerticalListAdapter.this.mContext, paramInt))
              {
                BNOfflineDataVerticalListAdapter.this.showLinkageDialog(BNOfflineDataVerticalListAdapter.this.mActivity, paramBoolean, paramInt, false);
                return;
              }
              BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
              if (!paramBoolean) {
                break;
              }
              BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus2", null)new BNWorkerConfig
              {
                protected String execute()
                {
                  BNOfflineDataManager.getInstance().startDownloadRequest(0);
                  try
                  {
                    Thread.sleep(300L);
                    BNOfflineDataManager.getInstance().startDownloadRequest(BNOfflineDataVerticalListAdapter.4.this.val$provinceId);
                    return null;
                  }
                  catch (Exception localException)
                  {
                    for (;;) {}
                  }
                }
              }, new BNWorkerConfig(101, 0));
              if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
              }
            } while (BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt));
            BNOfflineDataManager.getInstance().startDownBaseMapData(paramInt);
            return;
            BNOfflineDataManager.getInstance().startDownloadRequest(paramInt);
            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
              BNOfflineDataManager.getInstance().startDownBaseMapData(0);
            }
          } while (BNOfflineDataManager.getInstance().checkBaseMapDataExit(paramInt));
          BNOfflineDataManager.getInstance().startDownBaseMapData(paramInt);
        }
      }).setFirstBtnText(JarUtils.getResources().getString(1711669755)).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 1);
          BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 0);
        }
      }).show();
      return;
    }
    catch (Exception localException)
    {
      BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 1);
      BNOfflineDataManager.getInstance().memoryUserOper(paramInt, false, 0);
    }
  }
  
  public void updateData()
  {
    updateData(false);
  }
  
  public void updateData(boolean paramBoolean)
  {
    this.mUnDownloadItems = BNOfflineDataManager.getInstance().getUndowloadList();
    this.mDownloadedItems = BNOfflineDataManager.getInstance().getDownloadedList();
    long l1;
    int i;
    if (paramBoolean)
    {
      l1 = System.currentTimeMillis();
      if ((this.mDownloadedItems != null) && (this.mDownloadedItems.size() > 0)) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.mDownloadedItems.size())
      {
        if (((OfflineDataInfo)this.mDownloadedItems.get(i)).mTaskStatus != 10) {
          break label243;
        }
        if ((((OfflineDataInfo)this.mDownloadedItems.get(i)).mProvinceId == 0) && (((OfflineDataInfo)this.mDownloadedItems.get(i)).isFakeUpdate) && (BNOfflineDataManager.getInstance().checkBaseMapDataExit(((OfflineDataInfo)this.mDownloadedItems.get(i)).mProvinceId)))
        {
          ((OfflineDataInfo)this.mDownloadedItems.get(i)).mTaskStatus = 12;
          BNOfflineDataManager.getInstance().updateUpdateFinish(0, 100);
        }
      }
      long l2 = System.currentTimeMillis();
      LogUtil.e("testDelay:", "updateData coast:" + (l2 - l1));
      LogUtil.e("OfflineData", "updateData  mUnDownloadItems: " + this.mUnDownloadItems.size() + "  mDownloadedItems: " + this.mDownloadedItems.size());
      return;
      label243:
      LogUtil.e("DataOffLine:", "start check " + ((OfflineDataInfo)this.mDownloadedItems.get(i)).mProvinceId);
      if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(((OfflineDataInfo)this.mDownloadedItems.get(i)).mProvinceId))
      {
        ((OfflineDataInfo)this.mDownloadedItems.get(i)).mTaskStatus = 10;
        ((OfflineDataInfo)this.mDownloadedItems.get(i)).isFakeUpdate = true;
        ((OfflineDataInfo)this.mDownloadedItems.get(i)).mStrSize = "500";
        ((OfflineDataInfo)this.mDownloadedItems.get(i)).mIsNewVer = true;
      }
      i += 1;
    }
  }
  
  public void updateDiskSpace()
  {
    this.mTotalDownloadSize = 0L;
    this.mDiskSpace = 0L;
    int k = this.mDownloadedItems.size();
    int j = this.mUnDownloadItems.size();
    int i = 0;
    if (i < k) {}
    for (;;)
    {
      try
      {
        localOfflineDataInfo = (OfflineDataInfo)this.mDownloadedItems.get(i);
        int m = (int)(localOfflineDataInfo.mUpSize * (localOfflineDataInfo.mUpProgressBy10 / 1000.0D));
        this.mTotalDownloadSize += localOfflineDataInfo.mSize;
        this.mTotalDownloadSize += m;
        i += 1;
      }
      catch (Exception localException)
      {
        OfflineDataInfo localOfflineDataInfo;
        localException.printStackTrace();
        this.mDiskSpace = SDCardUtils.getSdcardSpace();
        LogUtil.e("OfflineData", "mDiskSpace: " + this.mDiskSpace + "  mTotalDownloadSize: " + this.mTotalDownloadSize);
        return;
      }
      if (i < j)
      {
        localOfflineDataInfo = (OfflineDataInfo)this.mUnDownloadItems.get(i);
        k = (int)(localOfflineDataInfo.mSize * (localOfflineDataInfo.mProgressBy10 / 1000.0D));
        this.mTotalDownloadSize += k;
        i += 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void updateUserClickStatus(Boolean paramBoolean)
  {
    this.mIsUndownload = paramBoolean;
  }
  
  public static class ViewHolder
  {
    RelativeLayout mInfoLayout;
    TextView mInfoTV;
    View mListDivider;
    View mListMargin;
    BNOfflineDataMergeLoadingView mMergeloadView;
    TextView mNameTV;
    ProgressBar mProgressBarDownloading;
    ProgressBar mProgressBarDownloadingNight;
    ProgressBar mProgressBarSuspend;
    ProgressBar mProgressBarSuspendNight;
    ImageView mTaskStatusIV;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/download/adapter/BNOfflineDataVerticalListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */