package com.baidu.navi.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.view.OfflineDataMergeLoadingView;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SDCardUtils;
import java.util.ArrayList;

public class CarModeOfflineDataListAdapter
  extends OfflineDataListAdapter
{
  private Activity mActivity;
  private Context mContext;
  private OfflineDataAdapterListener mDelegate;
  private long mDiskSpace = 0L;
  private ArrayList<OfflineDataInfo> mDownloadedItems;
  private Boolean mIsUndownload = Boolean.valueOf(true);
  private e mOnDialogListener;
  private long mTotalDownloadSize = 0L;
  private ArrayList<OfflineDataInfo> mUnDownloadItems;
  
  public CarModeOfflineDataListAdapter(Activity paramActivity, OfflineDataAdapterListener paramOfflineDataAdapterListener, e parame)
  {
    this.mContext = paramActivity.getBaseContext();
    this.mDelegate = paramOfflineDataAdapterListener;
    this.mActivity = paramActivity;
    this.mOnDialogListener = parame;
    updateData();
  }
  
  private void setVerticalListBackground(int paramInt, View paramView, ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (this.mIsUndownload.booleanValue())
    {
      if (paramInt < this.mUnDownloadItems.size()) {
        paramViewHolder.mListMargin.setVisibility(8);
      }
      for (;;)
      {
        paramViewHolder.mTaskStatusIV.setVisibility(0);
        paramViewHolder.mListMargin.setVisibility(8);
        return;
        if (paramInt >= this.mUnDownloadItems.size())
        {
          if (paramBoolean) {
            paramViewHolder.mListMargin.setVisibility(0);
          }
          paramViewHolder.mListDivider.setVisibility(8);
        }
      }
    }
    if (paramInt < this.mDownloadedItems.size()) {
      paramViewHolder.mListMargin.setVisibility(8);
    }
    for (;;)
    {
      paramViewHolder.mTaskStatusIV.setVisibility(8);
      return;
      if (paramInt >= this.mDownloadedItems.size())
      {
        if (paramBoolean) {
          paramViewHolder.mListMargin.setVisibility(0);
        }
        paramViewHolder.mListDivider.setVisibility(8);
      }
    }
  }
  
  public void checkToStartDownloadRequest(OfflineDataInfo paramOfflineDataInfo, boolean paramBoolean)
  {
    int i = -1;
    if (paramOfflineDataInfo != null)
    {
      double d = paramOfflineDataInfo.mProgress / 100.0D;
      i = (int)(paramOfflineDataInfo.mSize * d);
      i = SDCardUtils.handleSdcardError(paramOfflineDataInfo.mSize - i, true);
    }
    if (i == 1)
    {
      paramOfflineDataInfo = new c(this.mActivity).b(2131296736).a(2131296764).c(2131296733);
      this.mOnDialogListener.showDialog(paramOfflineDataInfo);
      return;
    }
    startCheckNetStatus(paramOfflineDataInfo.mProvinceId, paramBoolean);
  }
  
  public void chooseDownloadStrategy(final OfflineDataInfo paramOfflineDataInfo, final boolean paramBoolean)
  {
    int i = -1;
    if (paramOfflineDataInfo != null)
    {
      double d = paramOfflineDataInfo.mProgress / 100.0D;
      i = (int)(paramOfflineDataInfo.mSize * d);
      i = SDCardUtils.handleSdcardError(paramOfflineDataInfo.mSize - i, true);
    }
    if (i == 1)
    {
      paramOfflineDataInfo = new c(this.mActivity).b(2131296736).a(2131296764).c(2131296733);
      this.mOnDialogListener.showDialog(paramOfflineDataInfo);
      return;
    }
    if (i != 0)
    {
      TipTool.onCreateToastDialog(this.mContext, 2131296763);
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.mContext))
    {
      TipTool.onCreateToastDialog(this.mContext, 2131296760);
      return;
    }
    if (NetworkUtils.isTypeNetworkAvailable(this.mContext, 1))
    {
      if (paramBoolean) {
        BNOfflineDataManager.getInstance().downloadProvinceData(0);
      }
      BNOfflineDataManager.getInstance().downloadProvinceData(paramOfflineDataInfo.mProvinceId);
      return;
    }
    paramOfflineDataInfo = new c(this.mActivity).b(2131296736).a(2131296759).d(2131296733).b(new b()
    {
      public void onClick()
      {
        BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
        if (paramBoolean) {
          BNOfflineDataManager.getInstance().downloadProvinceData(0);
        }
        BNOfflineDataManager.getInstance().downloadProvinceData(paramOfflineDataInfo.mProvinceId);
      }
    }).c(2131296732).a(new b()
    {
      public void onClick() {}
    });
    this.mOnDialogListener.showDialog(paramOfflineDataInfo);
  }
  
  public void chooseUpdateStrategy(final OfflineDataInfo paramOfflineDataInfo)
  {
    int i = -1;
    if (paramOfflineDataInfo != null)
    {
      double d = paramOfflineDataInfo.mUpProgress / 100.0D;
      i = (int)(paramOfflineDataInfo.mUpSize * d);
      i = SDCardUtils.handleSdcardError(paramOfflineDataInfo.mUpSize - i, true);
    }
    if (i == 1)
    {
      paramOfflineDataInfo = new c(this.mActivity).b(2131296736).a(2131296764).c(2131296733);
      this.mOnDialogListener.showDialog(paramOfflineDataInfo);
      return;
    }
    if (i != 0)
    {
      TipTool.onCreateToastDialog(this.mContext, 2131296763);
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.mContext))
    {
      TipTool.onCreateToastDialog(this.mContext, 2131296760);
      return;
    }
    if (NetworkUtils.isTypeNetworkAvailable(this.mContext, 1))
    {
      BNOfflineDataManager.getInstance().updateProvinceData(paramOfflineDataInfo.mProvinceId);
      return;
    }
    paramOfflineDataInfo = new c(this.mActivity).b(2131296736).a(2131296759).d(2131296733).b(new b()
    {
      public void onClick()
      {
        BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
        BNOfflineDataManager.getInstance().updateProvinceData(paramOfflineDataInfo.mProvinceId);
      }
    }).c(2131296732).a(new b()
    {
      public void onClick() {}
    });
    this.mOnDialogListener.showDialog(paramOfflineDataInfo);
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
          break label70;
        }
        if (this.mUnDownloadItems == null) {
          return null;
        }
        if ((paramInt < 0) || (paramInt >= this.mUnDownloadItems.size())) {
          return null;
        }
      }
    }
    for (localObject1 = (OfflineDataInfo)this.mUnDownloadItems.get(paramInt);; localObject1 = (OfflineDataInfo)this.mDownloadedItems.get(paramInt))
    {
      return (OfflineDataInfo)localObject1;
      label70:
      if (this.mDownloadedItems == null) {
        return null;
      }
      if ((paramInt < 0) || (paramInt >= this.mDownloadedItems.size())) {
        return null;
      }
    }
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
          break label70;
        }
        if (this.mUnDownloadItems == null) {
          return null;
        }
        if ((paramInt < 0) || (paramInt >= this.mUnDownloadItems.size())) {
          return null;
        }
      }
    }
    for (localObject1 = (OfflineDataInfo)this.mUnDownloadItems.get(paramInt);; localObject1 = (OfflineDataInfo)this.mDownloadedItems.get(paramInt))
    {
      return localObject1;
      label70:
      if (this.mDownloadedItems == null) {
        return null;
      }
      if ((paramInt < 0) || (paramInt >= this.mDownloadedItems.size())) {
        return null;
      }
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)getItem(paramInt);
    boolean bool2;
    boolean bool1;
    if ((paramView == null) || (localOfflineDataInfo == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2130968679, null);
      paramViewGroup = new ViewHolder();
      paramViewGroup.mInfoLayout = ((RelativeLayout)paramView.findViewById(2131624564));
      paramViewGroup.mNameTV = ((TextView)paramView.findViewById(2131624566));
      paramViewGroup.mInfoTV = ((TextView)paramView.findViewById(2131624567));
      paramViewGroup.mProgressBarDownloading = ((ProgressBar)paramView.findViewById(2131624568));
      paramViewGroup.mProgressBarSuspend = ((ProgressBar)paramView.findViewById(2131624570));
      paramViewGroup.mProgressBarDownloadingNight = ((ProgressBar)paramView.findViewById(2131624569));
      paramViewGroup.mProgressBarSuspendNight = ((ProgressBar)paramView.findViewById(2131624571));
      paramViewGroup.mTaskStatusIV = ((ImageView)paramView.findViewById(2131624565));
      paramViewGroup.mListDivider = paramView.findViewById(2131624532);
      paramViewGroup.mListMargin = paramView.findViewById(2131624573);
      paramViewGroup.mMergeloadView = ((OfflineDataMergeLoadingView)paramView.findViewById(2131624572));
      paramView.setTag(paramViewGroup);
      bool2 = true;
      bool1 = true;
      if (localOfflineDataInfo == null) {
        break label1070;
      }
      localOfflineDataInfo.formatStatusTips();
      LogUtil.e("OfflineData", "model.mName: " + localOfflineDataInfo.mName + "  model.mStatusTips: " + localOfflineDataInfo.mStatusTips + "  model.mTaskStatus111: " + localOfflineDataInfo.mTaskStatus + "  model.mDownloadRatio: " + localOfflineDataInfo.mDownloadRatio);
      paramViewGroup.mInfoLayout.setVisibility(0);
      paramViewGroup.mInfoTV.setVisibility(0);
      paramViewGroup.mNameTV.setText(localOfflineDataInfo.mName);
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
          if ((ForbidDaulClickUtils.isFastDoubleClick()) || (paramAnonymousView == null)) {
            return;
          }
          CarModeOfflineDataListAdapter.this.mDelegate.itemDeleteButtomClicked(paramAnonymousView);
        }
      });
      if ((localOfflineDataInfo.mTaskStatus == 5) || (localOfflineDataInfo.mTaskStatus == 1) || (localOfflineDataInfo.mTaskStatus == 10)) {
        bool1 = false;
      }
      bool2 = bool1;
      switch (localOfflineDataInfo.mTaskStatus)
      {
      default: 
        bool2 = bool1;
      }
    }
    for (;;)
    {
      setVerticalListBackground(paramInt, paramView, paramViewGroup, bool2);
      paramViewGroup.mListDivider.setBackgroundResource(2131558553);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
      paramViewGroup.mListDivider.setVisibility(0);
      paramViewGroup.mTaskStatusIV.setImageResource(2130838150);
      bool2 = bool1;
      continue;
      paramViewGroup.mTaskStatusIV.setImageResource(2130838151);
      if (0 != 0)
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
      paramViewGroup.mTaskStatusIV.setImageResource(2130838151);
      if (0 != 0)
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
        if (0 != 0)
        {
          paramViewGroup.mProgressBarSuspend.setProgress(localOfflineDataInfo.mUpProgress);
          paramViewGroup.mProgressBarSuspend.setVisibility(0);
        }
      }
      for (;;)
      {
        paramViewGroup.mListDivider.setVisibility(8);
        paramViewGroup.mTaskStatusIV.setImageResource(2130838149);
        bool2 = bool1;
        break;
        paramViewGroup.mProgressBarSuspendNight.setProgress(localOfflineDataInfo.mUpProgress);
        paramViewGroup.mProgressBarSuspendNight.setVisibility(0);
        continue;
        if (0 != 0)
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
      continue;
      if (0 != 0)
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
      if (0 != 0)
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
      continue;
      paramViewGroup.mMergeloadView.showLoading();
      bool2 = bool1;
      continue;
      paramViewGroup.mListDivider.setVisibility(0);
      bool2 = bool1;
      continue;
      paramViewGroup.mListDivider.setVisibility(0);
      bool2 = bool1;
      continue;
      label1070:
      paramViewGroup.mListDivider.setVisibility(8);
      paramViewGroup.mInfoLayout.setVisibility(8);
      paramViewGroup.mListMargin.setVisibility(8);
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
      TipTool.onCreateToastDialog(this.mContext, 2131296760);
      return;
    }
    if (NetworkUtils.isTypeNetworkAvailable(this.mContext, 1))
    {
      if (paramBoolean)
      {
        new Thread(getClass().getSimpleName() + "_startCheckNetStatus1")
        {
          public void run()
          {
            BNOfflineDataManager.getInstance().startDownloadRequest(0);
            try
            {
              sleep(300L);
              BNOfflineDataManager.getInstance().startDownloadRequest(paramInt);
              return;
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
          }
        }.start();
        return;
      }
      BNOfflineDataManager.getInstance().startDownloadRequest(paramInt);
      return;
    }
    c localc = new c(this.mActivity).b(2131296736).a(2131296759).d(2131296733).b(new b()
    {
      public void onClick()
      {
        BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
        if (paramBoolean)
        {
          new Thread(getClass().getSimpleName() + "_startCheckNetStatus2")
          {
            public void run()
            {
              BNOfflineDataManager.getInstance().startDownloadRequest(0);
              try
              {
                sleep(300L);
                BNOfflineDataManager.getInstance().startDownloadRequest(CarModeOfflineDataListAdapter.3.this.val$provinceId);
                return;
              }
              catch (Exception localException)
              {
                for (;;) {}
              }
            }
          }.start();
          return;
        }
        BNOfflineDataManager.getInstance().startDownloadRequest(paramInt);
      }
    }).c(2131296732).a(new b()
    {
      public void onClick() {}
    });
    this.mOnDialogListener.showDialog(localc);
  }
  
  public void updateData()
  {
    this.mUnDownloadItems = BNOfflineDataManager.getInstance().getUndowloadList();
    this.mDownloadedItems = BNOfflineDataManager.getInstance().getDownloadedList();
    LogUtil.e("OfflineData", "updateData  mUnDownloadItems: " + this.mUnDownloadItems.size() + "  mDownloadedItems: " + this.mDownloadedItems.size());
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
    OfflineDataMergeLoadingView mMergeloadView;
    TextView mNameTV;
    ProgressBar mProgressBarDownloading;
    ProgressBar mProgressBarDownloadingNight;
    ProgressBar mProgressBarSuspend;
    ProgressBar mProgressBarSuspendNight;
    ImageView mTaskStatusIV;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/CarModeOfflineDataListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */