package com.baidu.navi.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SDCardUtils;
import java.util.ArrayList;

public class OfflineDataHorizontalListAdapter
  extends OfflineDataListAdapter
{
  private Activity mActivity;
  private Context mContext;
  private OfflineDataAdapterListener mDelegate;
  private long mDiskSpace = 0L;
  private ArrayList<OfflineDataInfo> mDownloadedItems;
  private long mTotalDownloadSize = 0L;
  private ArrayList<OfflineDataInfo> mUnDownloadItems;
  
  public OfflineDataHorizontalListAdapter(Activity paramActivity, OfflineDataAdapterListener paramOfflineDataAdapterListener)
  {
    this.mContext = paramActivity.getBaseContext();
    this.mDelegate = paramOfflineDataAdapterListener;
    this.mActivity = paramActivity;
    updateData();
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
      new BNDialog(this.mActivity).setTitleTextFromActivity(2131296736).setContentMessageFromActivity(2131296764).setFirstBtnTextFromActivity(2131296733).show();
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
      new BNDialog(this.mActivity).setTitleTextFromActivity(2131296736).setContentMessageFromActivity(2131296764).setFirstBtnTextFromActivity(2131296733).show();
      return;
    }
    if (i != 0)
    {
      TipTool.onCreateToastDialog(this.mContext, this.mActivity.getResources().getString(2131296763));
      return;
    }
    if (NetworkUtils.mConnectState == 0)
    {
      TipTool.onCreateToastDialog(this.mContext, this.mActivity.getResources().getString(2131296760));
      return;
    }
    if (NetworkUtils.mWifiState == 1)
    {
      if (paramBoolean) {
        BNOfflineDataManager.getInstance().downloadProvinceData(0);
      }
      BNOfflineDataManager.getInstance().downloadProvinceData(paramOfflineDataInfo.mProvinceId);
      return;
    }
    new BNDialog(this.mActivity).setTitleTextFromActivity(2131296736).setContentMessageFromActivity(2131296759).setSecondBtnTextFromActivity(2131296733).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
    {
      public void onClick()
      {
        if (paramBoolean) {
          BNOfflineDataManager.getInstance().downloadProvinceData(0);
        }
        BNOfflineDataManager.getInstance().downloadProvinceData(paramOfflineDataInfo.mProvinceId);
      }
    }).setFirstBtnTextFromActivity(2131296732).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
    {
      public void onClick() {}
    }).show();
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
      new BNDialog(this.mActivity).setTitleTextFromActivity(2131296736).setContentMessageFromActivity(2131296764).setFirstBtnTextFromActivity(2131296733).show();
      return;
    }
    if (i != 0)
    {
      TipTool.onCreateToastDialog(this.mContext, this.mActivity.getResources().getString(2131296763));
      return;
    }
    if (NetworkUtils.mConnectState == 0)
    {
      TipTool.onCreateToastDialog(this.mContext, this.mActivity.getResources().getString(2131296760));
      return;
    }
    if (NetworkUtils.mWifiState == 1)
    {
      BNOfflineDataManager.getInstance().updateProvinceData(paramOfflineDataInfo.mProvinceId);
      return;
    }
    new BNDialog(this.mActivity).setTitleTextFromActivity(2131296736).setContentMessageFromActivity(2131296759).setSecondBtnTextFromActivity(2131296733).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
    {
      public void onClick()
      {
        BNOfflineDataManager.getInstance().updateProvinceData(paramOfflineDataInfo.mProvinceId);
      }
    }).setFirstBtnTextFromActivity(2131296732).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
    {
      public void onClick() {}
    }).show();
  }
  
  public int getCount()
  {
    return this.mUnDownloadItems.size() + this.mDownloadedItems.size();
  }
  
  public OfflineDataInfo getDownloadedListModelByPosition(int paramInt)
  {
    if ((this.mDownloadedItems.size() > 0) && (paramInt < this.mDownloadedItems.size()) && (paramInt >= 0)) {
      return (OfflineDataInfo)this.mDownloadedItems.get(paramInt);
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.mDownloadedItems.size()) {
      return (OfflineDataInfo)this.mDownloadedItems.get(paramInt);
    }
    return (OfflineDataInfo)this.mUnDownloadItems.get(paramInt - this.mDownloadedItems.size());
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)getItem(paramInt);
    label175:
    TextView localTextView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2130968973, null);
      paramViewGroup = new ViewHolder();
      paramViewGroup.mInfoLayout = ((RelativeLayout)paramView.findViewById(2131624564));
      paramViewGroup.mNameTV = ((TextView)paramView.findViewById(2131624566));
      paramViewGroup.mInfoTV = ((TextView)paramView.findViewById(2131624567));
      paramViewGroup.mProgressBarDownloading = ((ProgressBar)paramView.findViewById(2131624568));
      paramViewGroup.mProgressBarSuspend = ((ProgressBar)paramView.findViewById(2131624570));
      paramViewGroup.mProgressBarDownloadingNight = ((ProgressBar)paramView.findViewById(2131624569));
      paramViewGroup.mProgressBarSuspendNight = ((ProgressBar)paramView.findViewById(2131624571));
      paramViewGroup.mBtnDeleteIV = ((ImageView)paramView.findViewById(2131624577));
      paramViewGroup.mDownloadIV = ((ImageView)paramView.findViewById(2131625949));
      paramViewGroup.mCardStatusTV = ((TextView)paramView.findViewById(2131625950));
      paramView.setTag(paramViewGroup);
      if (localOfflineDataInfo != null)
      {
        localOfflineDataInfo.formatStatusTips();
        paramViewGroup.mInfoLayout.setVisibility(0);
        paramViewGroup.mInfoTV.setVisibility(0);
        paramViewGroup.mNameTV.setText(localOfflineDataInfo.mName);
        localTextView = paramViewGroup.mNameTV;
        if (!StyleManager.getDayStyle()) {
          break label421;
        }
      }
    }
    boolean bool;
    label421:
    for (paramInt = -13421773;; paramInt = -4538943)
    {
      localTextView.setTextColor(paramInt);
      paramViewGroup.mInfoTV.setText(localOfflineDataInfo.mStatusTips);
      paramViewGroup.mInfoTV.setTextColor(localOfflineDataInfo.mStatusColor);
      paramViewGroup.mInfoLayout.setBackgroundDrawable(StyleManager.getDrawable(2130837746));
      paramViewGroup.mBtnDeleteIV.setTag(localOfflineDataInfo);
      paramViewGroup.mBtnDeleteIV.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = (OfflineDataInfo)paramAnonymousView.getTag();
          if ((ForbidDaulClickUtils.isFastDoubleClick()) || (paramAnonymousView == null)) {
            return;
          }
          OfflineDataHorizontalListAdapter.this.mDelegate.itemDeleteButtomClicked(paramAnonymousView);
        }
      });
      paramViewGroup.mProgressBarDownloading.setVisibility(8);
      paramViewGroup.mProgressBarDownloadingNight.setVisibility(8);
      paramViewGroup.mProgressBarSuspend.setVisibility(8);
      paramViewGroup.mProgressBarSuspendNight.setVisibility(8);
      bool = BNStyleManager.getDayStyle();
      switch (localOfflineDataInfo.mTaskStatus)
      {
      case 7: 
      default: 
        return paramView;
        paramViewGroup = (ViewHolder)paramView.getTag();
        break label175;
      }
    }
    if (bool)
    {
      paramViewGroup.mProgressBarDownloading.setProgress(localOfflineDataInfo.mProgress);
      paramViewGroup.mProgressBarDownloading.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.mDownloadIV.setVisibility(8);
      paramViewGroup.mCardStatusTV.setText(this.mActivity.getResources().getString(2131296762));
      paramViewGroup.mBtnDeleteIV.setVisibility(8);
      return paramView;
      paramViewGroup.mProgressBarDownloadingNight.setProgress(localOfflineDataInfo.mProgress);
      paramViewGroup.mProgressBarDownloadingNight.setVisibility(0);
    }
    if (bool)
    {
      paramViewGroup.mProgressBarDownloading.setProgress(localOfflineDataInfo.mProgress);
      paramViewGroup.mProgressBarDownloading.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.mDownloadIV.setVisibility(8);
      paramViewGroup.mCardStatusTV.setText(this.mActivity.getResources().getString(2131296762));
      paramViewGroup.mBtnDeleteIV.setVisibility(0);
      return paramView;
      paramViewGroup.mProgressBarDownloadingNight.setProgress(localOfflineDataInfo.mProgress);
      paramViewGroup.mProgressBarDownloadingNight.setVisibility(0);
    }
    if (localOfflineDataInfo.mIsNewVer)
    {
      if (bool)
      {
        paramViewGroup.mProgressBarSuspend.setProgress(localOfflineDataInfo.mUpProgress);
        paramViewGroup.mProgressBarSuspend.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.mDownloadIV.setVisibility(0);
        paramViewGroup.mCardStatusTV.setText(this.mActivity.getResources().getString(2131296761));
        paramViewGroup.mBtnDeleteIV.setVisibility(0);
        return paramView;
        paramViewGroup.mProgressBarSuspendNight.setProgress(localOfflineDataInfo.mUpProgress);
        paramViewGroup.mProgressBarSuspendNight.setVisibility(0);
      }
    }
    if (bool)
    {
      paramViewGroup.mProgressBarSuspend.setProgress(localOfflineDataInfo.mProgress);
      paramViewGroup.mProgressBarSuspend.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.mDownloadIV.setVisibility(8);
      paramViewGroup.mCardStatusTV.setText(this.mActivity.getResources().getString(2131296762));
      break;
      paramViewGroup.mProgressBarSuspendNight.setProgress(localOfflineDataInfo.mProgress);
      paramViewGroup.mProgressBarSuspendNight.setVisibility(0);
    }
    if (bool)
    {
      paramViewGroup.mProgressBarDownloading.setProgress(100);
      paramViewGroup.mProgressBarDownloading.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.mDownloadIV.setVisibility(0);
      paramViewGroup.mCardStatusTV.setText(this.mActivity.getResources().getString(2131296761));
      paramViewGroup.mBtnDeleteIV.setVisibility(8);
      return paramView;
      paramViewGroup.mProgressBarDownloadingNight.setProgress(100);
      paramViewGroup.mProgressBarDownloadingNight.setVisibility(0);
    }
    if (bool)
    {
      paramViewGroup.mProgressBarSuspend.setProgress(localOfflineDataInfo.mUpProgress);
      paramViewGroup.mProgressBarSuspend.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.mDownloadIV.setVisibility(0);
      paramViewGroup.mCardStatusTV.setText(this.mActivity.getResources().getString(2131296761));
      paramViewGroup.mBtnDeleteIV.setVisibility(0);
      return paramView;
      paramViewGroup.mProgressBarSuspendNight.setProgress(localOfflineDataInfo.mUpProgress);
      paramViewGroup.mProgressBarSuspendNight.setVisibility(0);
    }
    if (bool)
    {
      paramViewGroup.mProgressBarDownloading.setProgress(localOfflineDataInfo.mUpProgress);
      paramViewGroup.mProgressBarDownloading.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.mDownloadIV.setVisibility(0);
      paramViewGroup.mCardStatusTV.setText(this.mActivity.getResources().getString(2131296761));
      paramViewGroup.mBtnDeleteIV.setVisibility(0);
      return paramView;
      paramViewGroup.mProgressBarDownloadingNight.setProgress(localOfflineDataInfo.mUpProgress);
      paramViewGroup.mProgressBarDownloadingNight.setVisibility(0);
    }
    if (bool)
    {
      paramViewGroup.mProgressBarDownloading.setProgress(100);
      paramViewGroup.mProgressBarDownloading.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.mDownloadIV.setVisibility(0);
      paramViewGroup.mCardStatusTV.setText(this.mActivity.getResources().getString(2131296761));
      paramViewGroup.mBtnDeleteIV.setVisibility(8);
      return paramView;
      paramViewGroup.mProgressBarDownloadingNight.setProgress(100);
      paramViewGroup.mProgressBarDownloadingNight.setVisibility(0);
    }
  }
  
  public long getmDiskSpace()
  {
    return this.mDiskSpace;
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
    if (NetworkUtils.mConnectState == 0)
    {
      TipTool.onCreateToastDialog(this.mContext, 2131296760);
      return;
    }
    if (NetworkUtils.mWifiState == 1)
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
    new BNDialog(this.mActivity).setTitleTextFromActivity(2131296736).setContentMessageFromActivity(2131296759).setSecondBtnTextFromActivity(2131296733).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
    {
      public void onClick()
      {
        if (paramBoolean)
        {
          new Thread(getClass().getSimpleName() + "_checkNetStatus2")
          {
            public void run()
            {
              BNOfflineDataManager.getInstance().startDownloadRequest(0);
              try
              {
                sleep(300L);
                BNOfflineDataManager.getInstance().startDownloadRequest(OfflineDataHorizontalListAdapter.3.this.val$provinceId);
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
    }).setFirstBtnTextFromActivity(2131296732).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
    {
      public void onClick() {}
    }).show();
  }
  
  public void updateData()
  {
    this.mUnDownloadItems = BNOfflineDataManager.getInstance().getUndowloadList();
    this.mDownloadedItems = BNOfflineDataManager.getInstance().getDownloadedList();
  }
  
  public void updateDiskSpace()
  {
    this.mTotalDownloadSize = 0L;
    this.mDiskSpace = 0L;
    int k = this.mDownloadedItems.size();
    int j = this.mUnDownloadItems.size();
    int i = 0;
    OfflineDataInfo localOfflineDataInfo;
    while (i < k)
    {
      localOfflineDataInfo = (OfflineDataInfo)this.mDownloadedItems.get(i);
      int m = (int)(localOfflineDataInfo.mUpSize * (localOfflineDataInfo.mUpProgressBy10 / 1000.0D));
      this.mTotalDownloadSize += localOfflineDataInfo.mSize;
      this.mTotalDownloadSize += m;
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      localOfflineDataInfo = (OfflineDataInfo)this.mUnDownloadItems.get(i);
      k = (int)(localOfflineDataInfo.mSize * (localOfflineDataInfo.mProgressBy10 / 1000.0D));
      this.mTotalDownloadSize += k;
      i += 1;
    }
    this.mDiskSpace = SDCardUtils.getSdcardSpace();
    LogUtil.e("OfflineData", "mDiskSpace: " + this.mDiskSpace + "  mTotalDownloadSize: " + this.mTotalDownloadSize);
  }
  
  public static class ViewHolder
  {
    ImageView mBtnDeleteIV;
    TextView mCardStatusTV;
    ImageView mDownloadIV;
    RelativeLayout mInfoLayout;
    TextView mInfoTV;
    TextView mNameTV;
    ProgressBar mProgressBarDownloading;
    ProgressBar mProgressBarDownloadingNight;
    ProgressBar mProgressBarSuspend;
    ProgressBar mProgressBarSuspendNight;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/OfflineDataHorizontalListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */