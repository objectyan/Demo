package com.baidu.navi.fragment.carmode;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.util.r;
import com.baidu.navi.adapter.CarModeOfflineDataListAdapter;
import com.baidu.navi.adapter.OfflineDataAdapterListener;
import com.baidu.navi.adapter.OfflineDataHorizontalListAdapter;
import com.baidu.navi.adapter.OfflineDataListAdapter;
import com.baidu.navi.controller.SearchStrategyHelper;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.DownNotifManager;
import com.baidu.navi.view.HorizontalListView;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.common.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarModeOfflineDataFragment
  extends ContentFragment
{
  protected static final int DEFAULT_TITLE_HEIGHT = 30;
  protected static final int DEFAULT_TITLE_TEXT_SIZE = 14;
  protected static final int DEFAULT_TITLE_WIDTH = 60;
  public static final String KEY_COME_FROM_CONTINUEDOWNLOAD_DIALOG = "continue_download_dialog";
  public static final String KEY_PROVINCE_ID = "province_id";
  protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
  public static final int MSG_TYPE_CAL_DISK_SPACE = 5;
  public static final int MSG_TYPE_CAL_DISK_SPACE_DONE = 6;
  public static final int MSG_TYPE_CANCEL_UPDATE_DATA = 4;
  public static final int MSG_TYPE_CANCEL_UPDATE_DONE = 1;
  public static final int MSG_TYPE_DELETE_DATA = 2;
  public static final int MSG_TYPE_DELETE_DONE = 0;
  public static final String NEED_DELETE_DATA = "needDeleteOldMapData";
  private static final String TAG = "OffineData";
  private RelativeLayout bottom_status = null;
  private ImageView mBackImg = null;
  private CalDiskkSpaceThread mCalDiskkSpaceThread = null;
  private CancelUpdateThread mCancelUpdateThread = null;
  private OfflineDataAdapterListener mDelegate = new OfflineDataAdapterListener()
  {
    public void itemDeleteButtomClicked(OfflineDataInfo paramAnonymousOfflineDataInfo)
    {
      if ((CarModeOfflineDataFragment.this.mVerticalListAdapter != null) && (CarModeOfflineDataFragment.this.mVerticalListAdapter.getmIsUndownload().booleanValue()))
      {
        if ((ForbidDaulClickUtils.isFastDoubleClick()) || (paramAnonymousOfflineDataInfo == null)) {}
        do
        {
          return;
          i.e("UTEST", "Item clicked model status:" + paramAnonymousOfflineDataInfo.mTaskStatus);
          switch (paramAnonymousOfflineDataInfo.mTaskStatus)
          {
          case 5: 
          case 7: 
          default: 
            return;
          }
        } while (paramAnonymousOfflineDataInfo.mIsRequest);
        OfflineDataInfo localOfflineDataInfo;
        if ((!BNOfflineDataManager.getInstance().isCommonDataDownload()) && (paramAnonymousOfflineDataInfo.mProvinceId != 0))
        {
          localOfflineDataInfo = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
          if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 1))
          {
            CarModeOfflineDataFragment.this.mVerticalListAdapter.checkToStartDownloadRequest(paramAnonymousOfflineDataInfo, true);
            return;
          }
          CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseDownloadStrategy(paramAnonymousOfflineDataInfo, true);
          return;
        }
        CarModeOfflineDataFragment.this.mVerticalListAdapter.checkToStartDownloadRequest(paramAnonymousOfflineDataInfo, false);
        return;
        BNOfflineDataManager.getInstance().suspendDownloadProvinceData(paramAnonymousOfflineDataInfo.mProvinceId);
        return;
        BNOfflineDataManager.getInstance().suspendUpdateProvinceData(paramAnonymousOfflineDataInfo.mProvinceId);
        CarModeOfflineDataFragment.this.setNewDataStatus();
        return;
        if (paramAnonymousOfflineDataInfo.mIsNewVer)
        {
          i.e("UTEST", "chooseUpdateStrategy model status:" + paramAnonymousOfflineDataInfo.mTaskStatus);
          CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseUpdateStrategy(paramAnonymousOfflineDataInfo);
          CarModeOfflineDataFragment.this.setNewDataStatus();
          return;
        }
        i.e("UTEST", "chooseDownloadStrategy model status:" + paramAnonymousOfflineDataInfo.mTaskStatus);
        if ((!BNOfflineDataManager.getInstance().isCommonDataDownload()) && (paramAnonymousOfflineDataInfo.mProvinceId != 0))
        {
          localOfflineDataInfo = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
          if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 1))
          {
            CarModeOfflineDataFragment.this.mVerticalListAdapter.checkToStartDownloadRequest(paramAnonymousOfflineDataInfo, true);
            return;
          }
          CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseDownloadStrategy(paramAnonymousOfflineDataInfo, true);
          return;
        }
        CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseDownloadStrategy(paramAnonymousOfflineDataInfo, false);
        return;
        CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseUpdateStrategy(paramAnonymousOfflineDataInfo);
        CarModeOfflineDataFragment.this.setNewDataStatus();
        return;
      }
      int i = SDCardUtils.handleSdcardError(0L, true);
      if ((i == 2) || (i == 3))
      {
        TipTool.onCreateToastDialog(com.baidu.carlife.core.a.a(), 2131297122);
        return;
      }
      if ((!paramAnonymousOfflineDataInfo.mIsNewVer) && (paramAnonymousOfflineDataInfo.mProvinceId == 0) && (!BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()))
      {
        CarModeOfflineDataFragment.this.showDeleteCommonAlertDialog();
        return;
      }
      CarModeOfflineDataFragment.this.showDeleteAlertDialog(2131296309, paramAnonymousOfflineDataInfo.mIsNewVer, paramAnonymousOfflineDataInfo.mProvinceId);
    }
  };
  private com.baidu.carlife.view.dialog.c mDeleteAlertDlg = null;
  private com.baidu.carlife.view.dialog.c mDeleteCommonAlertDlg = null;
  private DeleteThread mDeleteThread = null;
  private TextView mDiskSpaceTextView = null;
  private TextView mDownload = null;
  private g mFocusArea;
  private com.baidu.carlife.f.c mFocusList;
  private OfflineHandler mHandler = new OfflineHandler(this);
  private OfflineDataHorizontalListAdapter mHorizontalListAdapter = null;
  private HorizontalListView mHorizontalListView = null;
  private int mLastOrientation = 0;
  private BNOfflineDataObserver mOfflineDataMsgObserver = new BNOfflineDataObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      switch (paramAnonymousInt1)
      {
      default: 
        return;
      case 1: 
        CarModeOfflineDataFragment.this.updateList();
        return;
      case 2: 
        paramAnonymousObject = (BNOfflineDataObserver.DownloadArg)paramAnonymousObject;
        switch (paramAnonymousInt2)
        {
        case 257: 
        case 270: 
        case 271: 
        case 272: 
        case 273: 
        case 274: 
        case 275: 
        case 276: 
        case 277: 
        case 278: 
        case 279: 
        case 280: 
        case 281: 
        case 282: 
        case 283: 
        case 284: 
        case 285: 
        case 286: 
        case 287: 
        default: 
          return;
        case 258: 
          StringUtils.showToastText(com.baidu.carlife.core.a.a(), StyleManager.getString(2131296451));
          return;
        case 259: 
          StringUtils.showToastText(com.baidu.carlife.core.a.a(), StyleManager.getString(2131296452));
          return;
        case 260: 
        case 261: 
          paramAnonymousBNSubject = StyleManager.getString(2131296453, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).updateDowningNotif(paramAnonymousBNSubject, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress + "%");
          return;
        case 262: 
          i.e("Alert", "Download finish alert ");
          SearchStrategyHelper.getInstance(com.baidu.carlife.core.a.a()).setIsNeedReloadSearchEngine(true);
          paramAnonymousBNSubject = StyleManager.getString(2131296450, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).showResultNotif(com.baidu.carlife.core.a.a(), paramAnonymousBNSubject);
          StringUtils.showToastText(com.baidu.carlife.core.a.a(), paramAnonymousBNSubject);
          StatisticManager.onEvent("1050", ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName);
          return;
        case 263: 
        case 264: 
          paramAnonymousBNSubject = StyleManager.getString(2131297161, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).updateSuspendingNotif(paramAnonymousBNSubject);
          return;
        case 265: 
        case 266: 
          UIModel.getInstance().setNewData(true);
          UIModel.getInstance().setIsAutoUpdateDataStatus(true);
          paramAnonymousBNSubject = StyleManager.getString(2131297191, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).updateDowningNotif(paramAnonymousBNSubject, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress + "%");
          return;
        case 268: 
          paramAnonymousBNSubject = StyleManager.getString(2131297189, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).updateSuspendingNotif(paramAnonymousBNSubject);
          return;
        case 267: 
          SearchStrategyHelper.getInstance(com.baidu.carlife.core.a.a()).setIsNeedReloadSearchEngine(true);
          UIModel.getInstance().setNewData(false);
          if ((((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount > 0) && (((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount > 0)) {
            paramAnonymousBNSubject = StyleManager.getString(2131297185, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName, Integer.valueOf(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount), Integer.valueOf(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount) });
          }
          for (;;)
          {
            DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).showUpdateFinshedNotif(com.baidu.carlife.core.a.a(), paramAnonymousBNSubject);
            StringUtils.showToastText(com.baidu.carlife.core.a.a(), paramAnonymousBNSubject);
            StatisticManager.onEvent("1050", "更新:" + ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName);
            return;
            if ((((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount <= 0) && (((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount > 0)) {
              paramAnonymousBNSubject = StyleManager.getString(2131297188, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName, Integer.valueOf(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount) });
            } else if ((((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount > 0) && (((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount <= 0)) {
              paramAnonymousBNSubject = StyleManager.getString(2131297187, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName, Integer.valueOf(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount) });
            } else {
              paramAnonymousBNSubject = StyleManager.getString(2131297186, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
            }
          }
        case 269: 
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).clearAllNotifs();
          return;
        case 288: 
          paramAnonymousBNSubject = "正在准备数据中:" + ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName + " 数据包";
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).showUpdateMergeNotif(com.baidu.carlife.core.a.a(), paramAnonymousBNSubject);
          return;
        case 289: 
          paramAnonymousBNSubject = "等待中:" + ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName + " 数据包";
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).showUpdateMergeNotif(com.baidu.carlife.core.a.a(), paramAnonymousBNSubject);
          return;
        case 290: 
          DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).clearAllNotifs();
          return;
        }
        paramAnonymousBNSubject = "数据更新失败:" + ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName + " 数据包";
        DownNotifManager.getInstance(com.baidu.carlife.core.a.a()).showUpdateMergeNotif(com.baidu.carlife.core.a.a(), paramAnonymousBNSubject);
        StringUtils.showToastText(com.baidu.carlife.core.a.a(), "数据更新失败");
        return;
      }
      switch (paramAnonymousInt2)
      {
      }
    }
  };
  private AdapterView.OnItemClickListener mOnItemClickListener = null;
  private AdapterView.OnItemLongClickListener mOnItemLongClickListener = null;
  private TextView mUnDownload = null;
  private LinearLayout mUpdateLogLayout;
  private TextView mUpdateLogTextView = null;
  private CarModeOfflineDataListAdapter mVerticalListAdapter = null;
  private ListView mVerticalListView = null;
  private ViewGroup mViewGroup = null;
  
  private void dismissAllDialog()
  {
    if ((this.mDeleteAlertDlg != null) && (this.mDeleteAlertDlg.isShown())) {
      this.mDeleteAlertDlg.d();
    }
    if ((this.mDeleteCommonAlertDlg != null) && (this.mDeleteCommonAlertDlg.isShown())) {
      this.mDeleteCommonAlertDlg.d();
    }
  }
  
  private View.OnClickListener getLeftOnClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeOfflineDataFragment.this.onBackPressed();
      }
    };
  }
  
  private void handleContinueDownload()
  {
    if ((this.mShowBundle != null) && (this.mShowBundle.containsKey("continue_download_dialog")) && (this.mShowBundle.getBoolean("continue_download_dialog", false)))
    {
      this.mShowBundle.remove("continue_download_dialog");
      if (NetworkUtils.isWifiConnected()) {
        break label57;
      }
      TipTool.onCreateToastDialog(mActivity, 2131296538);
    }
    label57:
    final List localList;
    do
    {
      return;
      localList = BNOfflineDataManager.getInstance().getSuspendDownloadDataInfo();
    } while (localList.size() <= 0);
    int j = ((Integer)localList.remove(0)).intValue();
    ArrayList localArrayList = BNOfflineDataManager.getInstance().getUndowloadList();
    final int i = 0;
    while (i < localArrayList.size())
    {
      if (j == ((OfflineDataInfo)localArrayList.get(i)).mProvinceId) {
        this.mVerticalListView.post(new Runnable()
        {
          public void run()
          {
            CarModeOfflineDataFragment.this.mVerticalListView.setSelection(i);
            new Thread("ContinueDownloadDataInfoInWifi")
            {
              public void run()
              {
                Iterator localIterator = CarModeOfflineDataFragment.1.this.val$ids.iterator();
                while (localIterator.hasNext())
                {
                  Integer localInteger = (Integer)localIterator.next();
                  BNOfflineDataManager.getInstance().downloadProvinceData(localInteger.intValue());
                  try
                  {
                    sleep(200L);
                  }
                  catch (InterruptedException localInterruptedException) {}
                }
              }
            }.start();
          }
        });
      }
      i += 1;
    }
    BNOfflineDataManager.getInstance().downloadProvinceData(j);
  }
  
  private void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 2: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.mDeleteThread != null) {
              this.mDeleteThread = null;
            }
            this.mDeleteThread = new DeleteThread(paramMessage.arg1, this.mHandler);
          } while ((this.mDeleteThread == null) || (this.mDeleteThread.isAlive()));
          this.mDeleteThread.start();
          return;
          if (this.mCancelUpdateThread != null) {
            this.mCancelUpdateThread = null;
          }
          this.mCancelUpdateThread = new CancelUpdateThread(paramMessage.arg1, this.mHandler);
        } while ((this.mCancelUpdateThread == null) || (this.mCancelUpdateThread.isAlive()));
        this.mCancelUpdateThread.start();
        return;
        if (this.mCalDiskkSpaceThread != null) {
          this.mCalDiskkSpaceThread = null;
        }
        this.mCalDiskkSpaceThread = new CalDiskkSpaceThread(this.mHandler);
      } while ((this.mCalDiskkSpaceThread == null) || (this.mCalDiskkSpaceThread.isAlive()));
      this.mCalDiskkSpaceThread.start();
      return;
    case 0: 
      e.a().c();
      if (this.mDeleteThread != null) {
        this.mDeleteThread = null;
      }
      updateList();
      setNewDataStatus();
      return;
    case 1: 
      e.a().c();
      if (this.mCancelUpdateThread != null) {
        this.mCancelUpdateThread = null;
      }
      updateList();
      setNewDataStatus();
      return;
    }
    if (this.mCalDiskkSpaceThread != null) {
      this.mCalDiskkSpaceThread = null;
    }
    updateDiskSpaceTV(paramMessage.getData().getLong("TotalDownloadSize"), paramMessage.getData().getLong("DiskSpace"));
  }
  
  private void initView(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater)
  {
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968611, null));
    this.mViewGroup.findViewById(2131624127).setOnClickListener(null);
    this.mViewGroup.findViewById(2131624128).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeOfflineDataFragment.this.onBackPressed();
      }
    });
    this.mVerticalListView = ((ListView)this.mViewGroup.findViewById(2131624121));
    this.mVerticalListView.setSelector(r.b(2130838223));
    this.mHorizontalListView = ((HorizontalListView)this.mViewGroup.findViewById(2131624122));
    this.mDiskSpaceTextView = ((TextView)this.mViewGroup.findViewById(2131624123));
    this.mUpdateLogLayout = ((LinearLayout)this.mViewGroup.findViewById(2131624125));
    this.mUpdateLogTextView = ((TextView)this.mViewGroup.findViewById(2131624126));
    this.mUpdateLogLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!FileUtils.isExistUpdateLogFile()) {
          TipTool.onCreateToastDialog(com.baidu.carlife.core.a.a(), 2131296722);
        }
      }
    });
    this.bottom_status = ((RelativeLayout)this.mViewGroup.findViewById(2131624117));
    this.bottom_status.setVisibility(8);
    this.mUnDownload = ((TextView)this.mViewGroup.findViewById(2131624119));
    this.mDownload = ((TextView)this.mViewGroup.findViewById(2131624120));
    this.mUnDownload.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeOfflineDataFragment.this.bottom_status.setVisibility(8);
        CarModeOfflineDataFragment.this.mUnDownload.setTextColor(StyleManager.getColor(2131558569));
        CarModeOfflineDataFragment.this.mDownload.setTextColor(StyleManager.getColor(2131558568));
        CarModeOfflineDataFragment.this.mUnDownload.setBackgroundResource(2130838153);
        CarModeOfflineDataFragment.this.mDownload.setBackgroundResource(2130838152);
        CarModeOfflineDataFragment.this.updateUserClickStatus(Boolean.valueOf(true));
      }
    });
    this.mDownload.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeOfflineDataFragment.this.bottom_status.setVisibility(0);
        CarModeOfflineDataFragment.this.mUnDownload.setTextColor(StyleManager.getColor(2131558568));
        CarModeOfflineDataFragment.this.mDownload.setTextColor(StyleManager.getColor(2131558569));
        CarModeOfflineDataFragment.this.mUnDownload.setBackgroundResource(2130838152);
        CarModeOfflineDataFragment.this.mDownload.setBackgroundResource(2130838153);
        CarModeOfflineDataFragment.this.updateUserClickStatus(Boolean.valueOf(false));
      }
    });
    this.mBackImg = ((ImageView)this.mViewGroup.findViewById(2131624118));
    this.mBackImg.setOnClickListener(getLeftOnClickListener());
  }
  
  private void setNewDataStatus()
  {
    new Thread(getClass().getSimpleName())
    {
      public void run()
      {
        boolean bool1 = BNOfflineDataManager.getInstance().isNewUpdateData();
        boolean bool2 = BNOfflineDataManager.getInstance().isNewDataUpdating();
        UIModel.getInstance().setNewData(bool1);
        UIModel.getInstance().setIsAutoUpdateDataStatus(bool2);
      }
    }.start();
  }
  
  private void setOnItemClickedListener()
  {
    this.mOnItemClickListener = new OnListItemClickListener(null);
    this.mOnItemLongClickListener = new OnListItemLongClickListener(null);
    if (this.mVerticalListView != null)
    {
      this.mVerticalListView.setOnItemClickListener(this.mOnItemClickListener);
      this.mVerticalListView.setOnItemLongClickListener(this.mOnItemLongClickListener);
    }
    if (this.mHorizontalListView != null)
    {
      this.mHorizontalListView.setOnItemClickListener(this.mOnItemClickListener);
      this.mHorizontalListView.setOnItemLongClickListener(this.mOnItemLongClickListener);
    }
  }
  
  private void showDeleteAlertDialog(int paramInt1, final boolean paramBoolean, final int paramInt2)
  {
    this.mDeleteAlertDlg = new com.baidu.carlife.view.dialog.c(com.baidu.carlife.core.a.a()).b(2131296284).a(paramInt1).c(2131296264).q().d(2131296259);
    this.mDeleteAlertDlg.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        e.a().b(StyleManager.getString(2131297229));
        if (paramBoolean) {}
        for (Message localMessage = Message.obtain(CarModeOfflineDataFragment.this.mHandler, 4, paramInt2, 0, null);; localMessage = Message.obtain(CarModeOfflineDataFragment.this.mHandler, 2, paramInt2, 0, null))
        {
          localMessage.sendToTarget();
          return;
        }
      }
    });
    showDialog(this.mDeleteAlertDlg);
  }
  
  private void showDeleteCommonAlertDialog()
  {
    if (this.mDeleteCommonAlertDlg == null) {
      this.mDeleteCommonAlertDlg = new com.baidu.carlife.view.dialog.c(com.baidu.carlife.core.a.a()).b(2131296284).a(2131296412).c(2131296279);
    }
    showDialog(this.mDeleteCommonAlertDlg);
  }
  
  private void updateDiskSpaceTV(long paramLong1, long paramLong2)
  {
    if (paramLong1 < 1.0E-7D) {}
    for (String str1 = "0M";; str1 = StringUtils.ByteSizeToStringForLong(Long.valueOf(paramLong1)))
    {
      String str2 = StringUtils.ByteSizeToStringForLong(Long.valueOf(paramLong2));
      i.e("OfflineData", "updateDiskSpaceTV totalDownloadSize:" + paramLong1 + "  diskSpace: " + paramLong2 + "tempTotalDownloadSize:" + str1 + "  tempDiskSpace: " + str2);
      this.mDiskSpaceTextView.setText(StyleManager.getString(2131296821, new Object[] { str1, str2 }));
      return;
    }
  }
  
  private void updateList()
  {
    if (this.mVerticalListAdapter != null)
    {
      this.mVerticalListAdapter.updateData();
      this.mVerticalListAdapter.notifyDataSetChanged();
    }
    if (this.mHorizontalListAdapter != null)
    {
      this.mHorizontalListAdapter.updateData();
      this.mHorizontalListAdapter.notifyDataSetChanged();
    }
    if ((this.mVerticalListAdapter != null) && (!this.mVerticalListAdapter.getmIsUndownload().booleanValue())) {
      Message.obtain(this.mHandler, 5, 0, 0, null).sendToTarget();
    }
  }
  
  private void updateUserClickStatus(Boolean paramBoolean)
  {
    if (this.mVerticalListAdapter != null) {
      this.mVerticalListAdapter.updateUserClickStatus(paramBoolean);
    }
    updateList();
  }
  
  private void updateViewWitchOrientation(int paramInt)
  {
    if (mActivity == null) {
      return;
    }
    this.mHorizontalListAdapter = null;
    this.mVerticalListView.setItemsCanFocus(true);
    this.mVerticalListAdapter = new CarModeOfflineDataListAdapter(mActivity, this.mDelegate, this);
    this.mVerticalListView.setAdapter(this.mVerticalListAdapter);
    this.mVerticalListView.setVisibility(0);
    this.mHorizontalListView.setVisibility(8);
    updateList();
  }
  
  public void driving()
  {
    i.b("yftech", "CarModeOfflineDataFragment driving");
    dismissAllDialog();
    if (com.baidu.carlife.custom.b.a().b())
    {
      back();
      back();
    }
    for (;;)
    {
      com.baidu.carlife.custom.a.a().d();
      return;
      backTo(17, null);
    }
  }
  
  public void initFocusChain(View paramView)
  {
    if (this.mFocusArea == null)
    {
      this.mFocusArea = new g(paramView, 2);
      this.mFocusArea.d(this.mBackImg).d(this.mUnDownload).d(this.mDownload);
      this.mFocusArea.b(this.mUnDownload);
    }
    if (this.mFocusList == null) {
      this.mFocusList = new com.baidu.carlife.f.c(this.mVerticalListView, 4);
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.mFocusArea, this.mFocusList });
    if ((this.mVerticalListView != null) && (this.mVerticalListView.getAdapter().getCount() > 0))
    {
      d.a().h(this.mFocusList);
      this.mFocusList.e();
      return;
    }
    d.a().h(this.mFocusArea);
  }
  
  public boolean onBackPressed()
  {
    pageBack(this.mModuleFrom);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mLastOrientation = getResources().getConfiguration().orientation;
    if (PreferenceHelper.getInstance(mActivity).getBoolean("SP_KEY_FIRST_INIT_FOR_LINKID", true))
    {
      PreferenceHelper.getInstance(mActivity).putBoolean("SP_KEY_FIRST_INIT_FOR_LINKID", false);
      BNOfflineDataManager.getInstance().initDownloadInfoForfirst();
    }
    initView(this.mViewGroup, paramLayoutInflater);
    this.mHorizontalListAdapter = null;
    this.mVerticalListView.setItemsCanFocus(true);
    this.mVerticalListView.setAdapter(this.mVerticalListAdapter);
    this.mVerticalListView.setVisibility(0);
    this.mHorizontalListView.setVisibility(8);
    updateViewWitchOrientation(this.mLastOrientation);
    setOnItemClickedListener();
    OfflineDataInfo localOfflineDataInfo1;
    if ((this.mShowBundle != null) && (this.mShowBundle.containsKey("KEY_PROVINCE_ID")))
    {
      int i = this.mShowBundle.getInt("KEY_PROVINCE_ID");
      paramLayoutInflater = null;
      if (this.mVerticalListAdapter != null) {
        paramLayoutInflater = this.mVerticalListAdapter;
      }
      if (this.mHorizontalListAdapter != null) {
        paramLayoutInflater = this.mHorizontalListAdapter;
      }
      localOfflineDataInfo1 = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(i);
      switch (localOfflineDataInfo1.mTaskStatus)
      {
      }
    }
    for (;;)
    {
      return this.mViewGroup;
      OfflineDataInfo localOfflineDataInfo2;
      if (!BNOfflineDataManager.getInstance().isCommonDataDownload())
      {
        localOfflineDataInfo2 = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
        if ((localOfflineDataInfo2 != null) && (localOfflineDataInfo2.mTaskStatus == 1)) {
          paramLayoutInflater.checkToStartDownloadRequest(localOfflineDataInfo1, true);
        } else {
          paramLayoutInflater.chooseDownloadStrategy(localOfflineDataInfo1, true);
        }
      }
      else
      {
        paramLayoutInflater.checkToStartDownloadRequest(localOfflineDataInfo1, false);
        continue;
        if (localOfflineDataInfo1.mIsNewVer)
        {
          i.e("UTEST", "chooseUpdateStrategy model status:" + localOfflineDataInfo1.mTaskStatus);
          paramLayoutInflater.chooseUpdateStrategy(localOfflineDataInfo1);
          setNewDataStatus();
        }
        else if (!BNOfflineDataManager.getInstance().isCommonDataDownload())
        {
          localOfflineDataInfo2 = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
          if ((localOfflineDataInfo2 != null) && (localOfflineDataInfo2.mTaskStatus == 1)) {
            paramLayoutInflater.checkToStartDownloadRequest(localOfflineDataInfo1, true);
          } else {
            paramLayoutInflater.chooseDownloadStrategy(localOfflineDataInfo1, true);
          }
        }
        else
        {
          paramLayoutInflater.chooseDownloadStrategy(localOfflineDataInfo1, false);
          continue;
          paramLayoutInflater.chooseUpdateStrategy(localOfflineDataInfo1);
          setNewDataStatus();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    BNOfflineDataManager.getInstance().deleteObserver(this.mOfflineDataMsgObserver);
    super.onDestroy();
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
    initFocusChain(this.mViewGroup);
  }
  
  protected void onInitView()
  {
    BNOfflineDataManager.getInstance().addObserver(this.mOfflineDataMsgObserver);
    handleContinueDownload();
  }
  
  protected void onUpdateOrientation(int paramInt)
  {
    if (paramInt != this.mLastOrientation)
    {
      this.mLastOrientation = paramInt;
      updateViewWitchOrientation(this.mLastOrientation);
    }
  }
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    updateViewWitchOrientation(this.mLastOrientation);
  }
  
  public void stopDriving() {}
  
  private class CalDiskkSpaceThread
    extends Thread
  {
    private Handler mUIHandler = null;
    
    public CalDiskkSpaceThread(Handler paramHandler)
    {
      this.mUIHandler = paramHandler;
    }
    
    public void run()
    {
      Object localObject = null;
      if (CarModeOfflineDataFragment.this.mVerticalListAdapter != null) {
        localObject = CarModeOfflineDataFragment.this.mVerticalListAdapter;
      }
      if (CarModeOfflineDataFragment.this.mHorizontalListAdapter != null) {
        localObject = CarModeOfflineDataFragment.this.mHorizontalListAdapter;
      }
      if (localObject != null)
      {
        ((OfflineDataListAdapter)localObject).updateDiskSpace();
        Bundle localBundle = new Bundle();
        localBundle.putLong("TotalDownloadSize", ((OfflineDataListAdapter)localObject).getmTotalDownloadSize());
        localBundle.putLong("DiskSpace", ((OfflineDataListAdapter)localObject).getmDiskSpace());
        localObject = Message.obtain(this.mUIHandler, 6, 0, 0, null);
        ((Message)localObject).setData(localBundle);
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private class CancelUpdateThread
    extends Thread
  {
    private int mProvinceId;
    private Handler mUIHandler = null;
    
    public CancelUpdateThread(int paramInt, Handler paramHandler)
    {
      this.mProvinceId = paramInt;
      this.mUIHandler = paramHandler;
    }
    
    public void run()
    {
      BNOfflineDataManager.getInstance().cancelUpdateData(this.mProvinceId);
      Message.obtain(this.mUIHandler, 1, 0, 0, null).sendToTarget();
    }
  }
  
  private class DeleteThread
    extends Thread
  {
    private int mProvinceId;
    private Handler mUIHandler = null;
    
    public DeleteThread(int paramInt, Handler paramHandler)
    {
      this.mProvinceId = paramInt;
      this.mUIHandler = paramHandler;
    }
    
    public void run()
    {
      BNOfflineDataManager.getInstance().removeProvinceData(this.mProvinceId);
      Message.obtain(this.mUIHandler, 0, 0, 0, null).sendToTarget();
    }
  }
  
  private static class OfflineHandler
    extends Handler
  {
    private final CarModeOfflineDataFragment mFragment;
    
    OfflineHandler(CarModeOfflineDataFragment paramCarModeOfflineDataFragment)
    {
      this.mFragment = paramCarModeOfflineDataFragment;
    }
    
    public void handleMessage(Message paramMessage)
    {
      this.mFragment.handleMessage(paramMessage);
    }
  }
  
  private class OnListItemClickListener
    implements AdapterView.OnItemClickListener
  {
    private OnListItemClickListener() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView = null;
      paramView = null;
      if (CarModeOfflineDataFragment.this.mHorizontalListAdapter != null)
      {
        paramAdapterView = CarModeOfflineDataFragment.this.mHorizontalListAdapter;
        paramView = (OfflineDataInfo)CarModeOfflineDataFragment.this.mHorizontalListAdapter.getItem((int)paramLong);
        if ((!ForbidDaulClickUtils.isFastDoubleClick(200L)) && (paramView != null)) {
          break label91;
        }
      }
      label91:
      do
      {
        return;
        if (CarModeOfflineDataFragment.this.mVerticalListAdapter == null) {
          break;
        }
        paramAdapterView = CarModeOfflineDataFragment.this.mVerticalListAdapter;
        paramView = (OfflineDataInfo)CarModeOfflineDataFragment.this.mVerticalListAdapter.getItem((int)paramLong);
        break;
        i.e("UTEST", "Item clicked model status:" + paramView.mTaskStatus);
        switch (paramView.mTaskStatus)
        {
        case 5: 
        case 7: 
        default: 
          return;
        }
      } while (paramView.mIsRequest);
      OfflineDataInfo localOfflineDataInfo;
      if ((!BNOfflineDataManager.getInstance().isCommonDataDownload()) && (paramView.mProvinceId != 0))
      {
        localOfflineDataInfo = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
        if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 1))
        {
          paramAdapterView.checkToStartDownloadRequest(paramView, true);
          return;
        }
        paramAdapterView.chooseDownloadStrategy(paramView, true);
        return;
      }
      paramAdapterView.checkToStartDownloadRequest(paramView, false);
      return;
      BNOfflineDataManager.getInstance().suspendDownloadProvinceData(paramView.mProvinceId);
      return;
      BNOfflineDataManager.getInstance().suspendUpdateProvinceData(paramView.mProvinceId);
      CarModeOfflineDataFragment.this.setNewDataStatus();
      return;
      if (paramView.mIsNewVer)
      {
        i.e("UTEST", "chooseUpdateStrategy model status:" + paramView.mTaskStatus);
        paramAdapterView.chooseUpdateStrategy(paramView);
        CarModeOfflineDataFragment.this.setNewDataStatus();
        return;
      }
      i.e("UTEST", "chooseDownloadStrategy model status:" + paramView.mTaskStatus);
      if ((!BNOfflineDataManager.getInstance().isCommonDataDownload()) && (paramView.mProvinceId != 0))
      {
        localOfflineDataInfo = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
        if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 1))
        {
          paramAdapterView.checkToStartDownloadRequest(paramView, true);
          return;
        }
        paramAdapterView.chooseDownloadStrategy(paramView, true);
        return;
      }
      paramAdapterView.chooseDownloadStrategy(paramView, false);
      return;
      paramAdapterView.chooseUpdateStrategy(paramView);
      CarModeOfflineDataFragment.this.setNewDataStatus();
    }
  }
  
  private class OnListItemLongClickListener
    implements AdapterView.OnItemLongClickListener
  {
    private OnListItemLongClickListener() {}
    
    public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView = null;
      if (CarModeOfflineDataFragment.this.mHorizontalListAdapter != null) {
        paramAdapterView = CarModeOfflineDataFragment.this.mHorizontalListAdapter.getDownloadedListModelByPosition((int)paramLong);
      }
      while ((ForbidDaulClickUtils.isFastDoubleClick()) || (paramAdapterView == null))
      {
        return false;
        if (CarModeOfflineDataFragment.this.mVerticalListAdapter != null) {
          paramAdapterView = CarModeOfflineDataFragment.this.mVerticalListAdapter.getDownloadedListModelByPosition((int)paramLong);
        }
      }
      if (paramAdapterView.mTaskStatus == 16)
      {
        TipTool.onCreateToastDialog(com.baidu.carlife.core.a.a(), 2131296405);
        return false;
      }
      int i = paramAdapterView.mProvinceId;
      boolean bool = paramAdapterView.mIsNewVer;
      paramInt = SDCardUtils.handleSdcardError(0L, true);
      if ((paramInt == 2) || (paramInt == 3))
      {
        TipTool.onCreateToastDialog(com.baidu.carlife.core.a.a(), 2131297122);
        return false;
      }
      if ((CarModeOfflineDataFragment.this.mVerticalListAdapter != null) && (CarModeOfflineDataFragment.this.mVerticalListAdapter.getmIsUndownload().booleanValue()))
      {
        if (paramAdapterView.mTaskStatus == 1) {
          return false;
        }
        if ((!paramAdapterView.mIsNewVer) && (paramAdapterView.mProvinceId == 0) && (!BNOfflineDataManager.getInstance().isDeleteCommonDataVailid())) {
          CarModeOfflineDataFragment.this.showDeleteCommonAlertDialog();
        }
      }
      for (;;)
      {
        return true;
        CarModeOfflineDataFragment.this.showDeleteAlertDialog(2131296309, bool, i);
        continue;
        if ((CarModeOfflineDataFragment.this.mVerticalListAdapter != null) && (!CarModeOfflineDataFragment.this.mVerticalListAdapter.getmIsUndownload().booleanValue()))
        {
          if ((paramAdapterView.mProvinceId == 0) && (!BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()))
          {
            CarModeOfflineDataFragment.this.showDeleteCommonAlertDialog();
          }
          else
          {
            if ((paramAdapterView.mTaskStatus == 11) || (paramAdapterView.mTaskStatus == 12) || (paramAdapterView.mTaskStatus == 13))
            {
              bool = true;
              label288:
              paramAdapterView = Boolean.valueOf(bool);
              paramView = CarModeOfflineDataFragment.this;
              if (!paramAdapterView.booleanValue()) {
                break label329;
              }
            }
            label329:
            for (paramInt = 2131296309;; paramInt = 2131296417)
            {
              paramView.showDeleteAlertDialog(paramInt, paramAdapterView.booleanValue(), i);
              break;
              bool = false;
              break label288;
            }
          }
        }
        else if ((paramAdapterView.mProvinceId == 0) && (!BNOfflineDataManager.getInstance().isDeleteCommonDataVailid())) {
          CarModeOfflineDataFragment.this.showDeleteCommonAlertDialog();
        } else {
          CarModeOfflineDataFragment.this.showDeleteAlertDialog(2131296417, false, i);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeOfflineDataFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */