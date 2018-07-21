package com.baidu.navisdk.ui.download.view;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.download.BNDownloadNotifyManager;
import com.baidu.navisdk.ui.download.adapter.BNOfflineDataAdapterListener;
import com.baidu.navisdk.ui.download.adapter.BNOfflineDataListAdapter;
import com.baidu.navisdk.ui.download.adapter.BNOfflineDataVerticalListAdapter;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class BNDownloadTabView
{
  protected static final int DEFAULT_TITLE_HEIGHT = 30;
  protected static final int DEFAULT_TITLE_TEXT_SIZE = 14;
  protected static final int DEFAULT_TITLE_WIDTH = 60;
  private static final int INDEX_RP_NETMODE = 0;
  private static final int INDEX_WIFI_UPDATE = 1;
  public static final String KEY_PROVINCE_ID = "province_id";
  protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
  public static final int MSG_TYPE_CAL_DISK_SPACE = 5;
  public static final int MSG_TYPE_CAL_DISK_SPACE_DONE = 6;
  public static final int MSG_TYPE_CANCEL_UPDATE_DATA = 4;
  public static final int MSG_TYPE_CANCEL_UPDATE_DONE = 1;
  public static final int MSG_TYPE_DELETE_COMMON_DATA = 3;
  public static final int MSG_TYPE_DELETE_DATA = 2;
  public static final int MSG_TYPE_DELETE_DONE = 0;
  public static final int MSG_TYPE_MD5_ERROR = 7;
  public static final int MSG_TYPE_MD5_ERROR_DONE = 8;
  private static final int OPTION_SIZE = 2;
  private static final String TAG = "!#BNDownloadTabView";
  private RelativeLayout bottom_status = null;
  private Activity mActivity;
  private CalDiskkSpaceThread mCalDiskkSpaceThread = null;
  private CancelUpdateThread mCancelUpdateThread = null;
  ImageView[] mCheckboxs = new ImageView[2];
  private BNOfflineDataAdapterListener mDelegate = new BNOfflineDataAdapterListener()
  {
    public void itemDeleteButtomClicked(final OfflineDataInfo paramAnonymousOfflineDataInfo)
    {
      if ((BNDownloadTabView.this.mVerticalListAdapter != null) && (BNDownloadTabView.this.mVerticalListAdapter.getmIsUndownload().booleanValue())) {
        if (paramAnonymousOfflineDataInfo != null) {}
      }
      for (;;)
      {
        return;
        LogUtil.e("UTEST", "Item clicked model status:" + paramAnonymousOfflineDataInfo.mTaskStatus);
        OfflineDataInfo localOfflineDataInfo;
        switch (paramAnonymousOfflineDataInfo.mTaskStatus)
        {
        case 5: 
        case 7: 
        default: 
          
        case 1: 
          if (!paramAnonymousOfflineDataInfo.mIsRequest)
          {
            BNOfflineDataManager.getInstance().memoryUserOper(paramAnonymousOfflineDataInfo.mProvinceId, true, 0);
            if ((!BNOfflineDataManager.getInstance().isCommonDataDownload()) && (paramAnonymousOfflineDataInfo.mProvinceId != 0))
            {
              localOfflineDataInfo = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
              if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 1))
              {
                BNDownloadTabView.this.mVerticalListAdapter.checkToStartDownloadRequest(paramAnonymousOfflineDataInfo, true);
                return;
              }
              BNDownloadTabView.this.mVerticalListAdapter.chooseDownloadStrategy(paramAnonymousOfflineDataInfo, true);
              return;
            }
            BNDownloadTabView.this.mVerticalListAdapter.checkToStartDownloadRequest(paramAnonymousOfflineDataInfo, false);
            return;
          }
          break;
        case 2: 
        case 3: 
          BNOfflineDataManager.getInstance().suspendDownloadProvinceData(paramAnonymousOfflineDataInfo.mProvinceId);
          return;
        case 11: 
        case 12: 
          BNOfflineDataManager.getInstance().suspendUpdateProvinceData(paramAnonymousOfflineDataInfo.mProvinceId);
          return;
        case 4: 
        case 6: 
        case 8: 
        case 9: 
        case 13: 
          if (paramAnonymousOfflineDataInfo.mIsNewVer)
          {
            BNOfflineDataManager.getInstance().memoryUserOper(paramAnonymousOfflineDataInfo.mProvinceId, true, 1);
            LogUtil.e("UTEST", "chooseUpdateStrategy model status:" + paramAnonymousOfflineDataInfo.mTaskStatus);
            BNDownloadTabView.this.mVerticalListAdapter.chooseUpdateStrategy(paramAnonymousOfflineDataInfo);
            return;
          }
          LogUtil.e("UTEST", "chooseDownloadStrategy model status:" + paramAnonymousOfflineDataInfo.mTaskStatus);
          BNOfflineDataManager.getInstance().memoryUserOper(paramAnonymousOfflineDataInfo.mProvinceId, true, 0);
          if ((!BNOfflineDataManager.getInstance().isCommonDataDownload()) && (paramAnonymousOfflineDataInfo.mProvinceId != 0))
          {
            localOfflineDataInfo = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
            if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 1))
            {
              BNDownloadTabView.this.mVerticalListAdapter.checkToStartDownloadRequest(paramAnonymousOfflineDataInfo, true);
              return;
            }
            BNDownloadTabView.this.mVerticalListAdapter.chooseDownloadStrategy(paramAnonymousOfflineDataInfo, true);
            return;
          }
          BNDownloadTabView.this.mVerticalListAdapter.chooseDownloadStrategy(paramAnonymousOfflineDataInfo, false);
          return;
        case 10: 
          BNOfflineDataManager.getInstance().memoryUserOper(paramAnonymousOfflineDataInfo.mProvinceId, true, 1);
          BNDownloadTabView.this.mVerticalListAdapter.chooseUpdateStrategy(paramAnonymousOfflineDataInfo);
          return;
          int i = SDCardUtils.handleOfflinePathError(0L, true);
          if ((i == 2) || (i == 3))
          {
            TipTool.onCreateToastDialog(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(1711669656));
            return;
          }
          if ((!paramAnonymousOfflineDataInfo.mIsNewVer) && (paramAnonymousOfflineDataInfo.mProvinceId == 0) && (!BNOfflineDataManager.getInstance().isDeleteCommonDataVailid())) {
            try
            {
              if ((BNDownloadTabView.this.mDeleteCommonAlertDlg == null) && (BNDownloadTabView.this.mActivity != null)) {
                BNDownloadTabView.access$1302(BNDownloadTabView.this, new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681)).setMessage(JarUtils.getResources().getString(1711669670)).setFirstBtnText(JarUtils.getResources().getString(1711669685)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
                {
                  public void onClick()
                  {
                    Message.obtain(BNDownloadTabView.this.mHandler, 3, 0, 0, null).sendToTarget();
                  }
                }));
              }
              if ((BNDownloadTabView.this.mDeleteCommonAlertDlg == null) || (BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing()) || (BNDownloadTabView.this.mActivity == null) || (BNDownloadTabView.this.mActivity.isFinishing())) {
                continue;
              }
              BNDownloadTabView.this.mDeleteCommonAlertDlg.show();
              return;
            }
            catch (Exception paramAnonymousOfflineDataInfo) {}
          } else {
            try
            {
              if ((BNDownloadTabView.this.mDeleteAlertDlg == null) && (BNDownloadTabView.this.mActivity != null)) {
                BNDownloadTabView.access$1502(BNDownloadTabView.this, new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681)).setMessage(JarUtils.getResources().getString(1711669654)).setSecondBtnText(JarUtils.getResources().getString(1711669682)).setOnSecondBtnClickListener(new BNBaseDialog.OnNaviClickListener()
                {
                  public void onClick()
                  {
                    if (BNDownloadTabView.this.mWaitProgress == null) {
                      BNDownloadTabView.access$1602(BNDownloadTabView.this, new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(1711669661)));
                    }
                    if ((BNDownloadTabView.this.mWaitProgress != null) && (!BNDownloadTabView.this.mWaitProgress.isShowing())) {
                      BNDownloadTabView.this.mWaitProgress.show();
                    }
                    if (paramAnonymousOfflineDataInfo.mIsNewVer) {}
                    for (Message localMessage = Message.obtain(BNDownloadTabView.this.mHandler, 4, paramAnonymousOfflineDataInfo.mProvinceId, 0, null);; localMessage = Message.obtain(BNDownloadTabView.this.mHandler, 2, paramAnonymousOfflineDataInfo.mProvinceId, 0, null))
                    {
                      localMessage.sendToTarget();
                      if (BNDownloadTabView.this.mDeleteAlertDlg != null)
                      {
                        BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                        BNDownloadTabView.access$1502(BNDownloadTabView.this, null);
                      }
                      return;
                    }
                  }
                }).setFirstBtnText(JarUtils.getResources().getString(1711669683)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
                {
                  public void onClick()
                  {
                    if (BNDownloadTabView.this.mDeleteAlertDlg != null)
                    {
                      BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                      BNDownloadTabView.access$1502(BNDownloadTabView.this, null);
                    }
                  }
                }));
              }
              if ((BNDownloadTabView.this.mDeleteAlertDlg != null) && (!BNDownloadTabView.this.mDeleteAlertDlg.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing()))
              {
                BNDownloadTabView.this.mDeleteAlertDlg.show();
                return;
              }
            }
            catch (Exception paramAnonymousOfflineDataInfo) {}
          }
          break;
        }
      }
    }
  };
  private BNMessageDialog mDeleteAlertDlg = null;
  private BNMessageDialog mDeleteCommonAlertDlg = null;
  private DeleteThread mDeleteThread = null;
  private TextView mDiskSpaceTextView = null;
  private RadioButton mDownload = null;
  private HandleMd5ErrorThread mHandleMd5ErrorThread = null;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      try
      {
        switch (paramAnonymousMessage.what)
        {
        case 3: 
          if ((BNDownloadTabView.this.mDeleteCommonAlertDlg != null) && (BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing()))
          {
            BNDownloadTabView.this.mDeleteCommonAlertDlg.dismiss();
            return;
          }
          break;
        case 2: 
          if (BNDownloadTabView.this.mDeleteThread != null) {
            BNDownloadTabView.access$1702(BNDownloadTabView.this, null);
          }
          BNDownloadTabView.access$1702(BNDownloadTabView.this, new BNDownloadTabView.DeleteThread(BNDownloadTabView.this, paramAnonymousMessage.arg1, BNDownloadTabView.this.mHandler));
          if ((BNDownloadTabView.this.mDeleteThread != null) && (!BNDownloadTabView.this.mDeleteThread.isAlive()))
          {
            BNDownloadTabView.this.mDeleteThread.start();
            return;
          }
          break;
        case 4: 
          if (BNDownloadTabView.this.mCancelUpdateThread != null) {
            BNDownloadTabView.access$1802(BNDownloadTabView.this, null);
          }
          BNDownloadTabView.access$1802(BNDownloadTabView.this, new BNDownloadTabView.CancelUpdateThread(BNDownloadTabView.this, paramAnonymousMessage.arg1, BNDownloadTabView.this.mHandler));
          if ((BNDownloadTabView.this.mCancelUpdateThread != null) && (!BNDownloadTabView.this.mCancelUpdateThread.isAlive()))
          {
            BNDownloadTabView.this.mCancelUpdateThread.start();
            return;
          }
          break;
        case 5: 
          if (BNDownloadTabView.this.mCalDiskkSpaceThread != null) {
            BNDownloadTabView.access$1902(BNDownloadTabView.this, null);
          }
          BNDownloadTabView.access$1902(BNDownloadTabView.this, new BNDownloadTabView.CalDiskkSpaceThread(BNDownloadTabView.this, BNDownloadTabView.this.mHandler));
          if ((BNDownloadTabView.this.mCalDiskkSpaceThread != null) && (!BNDownloadTabView.this.mCalDiskkSpaceThread.isAlive()))
          {
            BNDownloadTabView.this.mCalDiskkSpaceThread.start();
            return;
          }
          break;
        case 0: 
          if ((BNDownloadTabView.this.mWaitProgress != null) && (BNDownloadTabView.this.mWaitProgress.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing())) {
            BNDownloadTabView.this.mWaitProgress.dismiss();
          }
          if (BNDownloadTabView.this.mDeleteThread != null) {
            BNDownloadTabView.access$1702(BNDownloadTabView.this, null);
          }
          BNDownloadTabView.this.updateList();
          return;
        case 1: 
          if ((BNDownloadTabView.this.mWaitProgress != null) && (BNDownloadTabView.this.mWaitProgress.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing())) {
            BNDownloadTabView.this.mWaitProgress.dismiss();
          }
          if (BNDownloadTabView.this.mCancelUpdateThread != null) {
            BNDownloadTabView.access$1802(BNDownloadTabView.this, null);
          }
          BNDownloadTabView.this.updateList();
          return;
        case 6: 
          if ((BNDownloadTabView.this.mWaitProgress != null) && (BNDownloadTabView.this.mWaitProgress.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing())) {
            BNDownloadTabView.this.mWaitProgress.dismiss();
          }
          if (BNDownloadTabView.this.mCalDiskkSpaceThread != null) {
            BNDownloadTabView.access$1902(BNDownloadTabView.this, null);
          }
          BNDownloadTabView.this.updateDiskSpaceTV(paramAnonymousMessage.getData().getLong("TotalDownloadSize"), paramAnonymousMessage.getData().getLong("DiskSpace"));
          return;
        case 7: 
          LogUtil.e("Alert", "MSG_TYPE_MD5_ERROR  princeId ");
          if (BNDownloadTabView.this.mHandleMd5ErrorThread != null) {
            BNDownloadTabView.access$2102(BNDownloadTabView.this, null);
          }
          BNDownloadTabView.access$2102(BNDownloadTabView.this, new BNDownloadTabView.HandleMd5ErrorThread(BNDownloadTabView.this, BNDownloadTabView.this.mHandler));
          if ((BNDownloadTabView.this.mHandleMd5ErrorThread != null) && (!BNDownloadTabView.this.mHandleMd5ErrorThread.isAlive()))
          {
            BNDownloadTabView.this.mHandleMd5ErrorThread.start();
            return;
          }
          break;
        case 8: 
          if ((BNDownloadTabView.this.mWaitProgress != null) && (BNDownloadTabView.this.mWaitProgress.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing())) {
            BNDownloadTabView.this.mWaitProgress.dismiss();
          }
          if (BNDownloadTabView.this.mHandleMd5ErrorThread != null)
          {
            BNDownloadTabView.access$2102(BNDownloadTabView.this, null);
            return;
          }
          break;
        }
        return;
      }
      catch (Throwable paramAnonymousMessage) {}
    }
  };
  private boolean mIsShowDownloadedPage = false;
  private ListItem[] mItems = new ListItem[2];
  private int mLastOrientation = 0;
  private BNMessageDialog mMd5AlertDlg = null;
  private View mNetModeView;
  private BNOfflineDataObserver mOfflineDataMsgObserver = new BNOfflineDataObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      switch (paramAnonymousInt1)
      {
      }
      for (;;)
      {
        return;
        BNDownloadTabView.this.updateList();
        return;
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
          StringUtils.showToastText(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(1711669662));
          return;
        case 259: 
          StringUtils.showToastText(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(1711669663));
          return;
        case 260: 
        case 261: 
          paramAnonymousBNSubject = JarUtils.getResources().getString(1711669658, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress);
          return;
        case 262: 
          LogUtil.e("Alert", "Download finish alert ");
          paramAnonymousBNSubject = JarUtils.getResources().getString(1711669660, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress);
          BNDownloadNotifyManager.getInstance().clearNotification();
          StringUtils.showToastText(BNDownloadTabView.this.mActivity, paramAnonymousBNSubject);
          return;
        case 263: 
        case 264: 
          paramAnonymousBNSubject = JarUtils.getResources().getString(1711669659, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress);
          return;
        case 265: 
        case 266: 
          paramAnonymousBNSubject = JarUtils.getResources().getString(1711669664, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress);
          return;
        case 268: 
          paramAnonymousBNSubject = JarUtils.getResources().getString(1711669665, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress);
          return;
        case 267: 
          LogUtil.e("", " update  downloadArg.mUpdatePoiCount " + ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount + "   downloadArg.mUpdateRouteCount " + ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount);
          if ((((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount > 0) && (((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount > 0))
          {
            paramAnonymousBNSubject = JarUtils.getResources().getString(1711669666, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName, Integer.valueOf(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount), Integer.valueOf(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount) });
            if (!BNOfflineDataManager.getInstance().mIsUpdateFinishNotProgress) {
              break label701;
            }
            BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, -1);
          }
          for (;;)
          {
            BNOfflineDataManager.getInstance().mIsUpdateFinishNotProgress = false;
            BNDownloadNotifyManager.getInstance().clearNotification();
            StringUtils.showToastText(BNDownloadTabView.this.mActivity, paramAnonymousBNSubject);
            return;
            if ((((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount <= 0) && (((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount > 0))
            {
              paramAnonymousBNSubject = JarUtils.getResources().getString(1711669667, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName, Integer.valueOf(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount) });
              break;
            }
            if ((((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount > 0) && (((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdateRouteCount <= 0))
            {
              paramAnonymousBNSubject = JarUtils.getResources().getString(1711669668, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName, Integer.valueOf(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mUpdatePoiCount) });
              break;
            }
            paramAnonymousBNSubject = JarUtils.getResources().getString(1711669669, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
            break;
            BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress);
          }
        case 269: 
          BNDownloadNotifyManager.getInstance().clearNotification();
          return;
        case 288: 
          paramAnonymousBNSubject = JarUtils.getResources().getString(1711669677, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, -1);
          return;
        case 289: 
          paramAnonymousBNSubject = JarUtils.getResources().getString(1711669678, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
          BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, -1);
          return;
        case 290: 
          label701:
          BNDownloadNotifyManager.getInstance().clearNotification();
          return;
        }
        paramAnonymousBNSubject = JarUtils.getResources().getString(1711669679, new Object[] { ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName });
        BNDownloadNotifyManager.getInstance().updateNotification(paramAnonymousBNSubject, -1);
        StringUtils.showToastText(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(1711669680));
        return;
        switch (paramAnonymousInt2)
        {
        case 270: 
        case 271: 
        default: 
          return;
        }
        LogUtil.e("Alert", "EVENT_ERROR_MD5  princeId ");
        try
        {
          if ((BNDownloadTabView.this.mMd5AlertDlg == null) && (BNDownloadTabView.this.mActivity != null)) {
            BNDownloadTabView.access$2202(BNDownloadTabView.this, new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681)).setMessage(JarUtils.getResources().getString(1711669675)).setFirstBtnText(JarUtils.getResources().getString(1711669676)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
            {
              public void onClick()
              {
                try
                {
                  if ((BNDownloadTabView.this.mWaitProgress == null) && (BNDownloadTabView.this.mActivity != null)) {
                    BNDownloadTabView.access$1602(BNDownloadTabView.this, new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(1711669661)));
                  }
                  if ((BNDownloadTabView.this.mWaitProgress != null) && (!BNDownloadTabView.this.mWaitProgress.isShowing())) {
                    BNDownloadTabView.this.mWaitProgress.show();
                  }
                  Message.obtain(BNDownloadTabView.this.mHandler, 7, 0, 0, null).sendToTarget();
                  if (BNDownloadTabView.this.mMd5AlertDlg != null)
                  {
                    BNDownloadTabView.this.mMd5AlertDlg.dismiss();
                    BNDownloadTabView.access$2202(BNDownloadTabView.this, null);
                  }
                  return;
                }
                catch (Exception localException) {}
              }
            }));
          }
          if ((BNDownloadTabView.this.mMd5AlertDlg != null) && (!BNDownloadTabView.this.mMd5AlertDlg.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing()))
          {
            BNDownloadTabView.this.mMd5AlertDlg.show();
            return;
          }
        }
        catch (Exception paramAnonymousBNSubject) {}
      }
    }
  };
  private View mOfflineDataSettingView;
  private RelativeLayout mOfflinecontentview = null;
  private View.OnClickListener mOnBackBtnClickListener;
  private AdapterView.OnItemClickListener mOnItemClickListener = null;
  private AdapterView.OnItemLongClickListener mOnItemLongClickListener = null;
  private View mRootView;
  private BNMessageDialog mSDCardAlertDlg = null;
  protected Bundle mShowBundle;
  private BNCommonTitleBar mTitleBar = null;
  private RadioButton mUnDownload = null;
  private TextView mUpdateLogTextView = null;
  private BNOfflineDataVerticalListAdapter mVerticalListAdapter = null;
  private ListView mVerticalListView = null;
  private View mWIFIUpdateView;
  private BNCommonProgressDialog mWaitProgress = null;
  private View middleTitleView = null;
  
  public BNDownloadTabView(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    BNOfflineDataManager.getInstance().addObserver(this.mOfflineDataMsgObserver);
    initUserConfig();
    initView(paramActivity, null);
  }
  
  private boolean getRPNetMode()
  {
    return BNSettingManager.getPrefRoutPlanMode() == 2;
  }
  
  private void initUserConfig()
  {
    ListItem localListItem = new ListItem(null);
    localListItem.mHasCheckBox = true;
    localListItem.mIsCheck = getRPNetMode();
    this.mItems[0] = localListItem;
    localListItem = new ListItem(null);
    localListItem.mHasCheckBox = true;
    localListItem.mIsCheck = BNSettingManager.isAutoUpdateNewData();
    this.mItems[1] = localListItem;
  }
  
  private void initView(Activity paramActivity, Bundle paramBundle)
  {
    LogUtil.e("!#BNDownloadTabView", "JarUtils asJar=" + JarUtils.getAsJar());
    if (paramActivity == null) {}
    do
    {
      do
      {
        return;
        this.mLastOrientation = 1;
        initView(this.mRootView);
      } while (this.mVerticalListView == null);
      this.mVerticalListView.setAdapter(this.mVerticalListAdapter);
      this.mVerticalListView.setVisibility(0);
      updateOrientation(this.mLastOrientation);
      updateStyle(BNStyleManager.getDayStyle());
      setOnItemClickedListener();
    } while ((this.mShowBundle == null) || (!this.mShowBundle.containsKey("KEY_PROVINCE_ID")));
    int i = this.mShowBundle.getInt("KEY_PROVINCE_ID");
    paramActivity = null;
    if (this.mVerticalListAdapter != null) {
      paramActivity = this.mVerticalListAdapter;
    }
    paramBundle = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(i);
    OfflineDataInfo localOfflineDataInfo;
    switch (paramBundle.mTaskStatus)
    {
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    case 11: 
    case 12: 
    default: 
      return;
    case 1: 
      if (!BNOfflineDataManager.getInstance().isCommonDataDownload())
      {
        localOfflineDataInfo = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
        if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 1))
        {
          paramActivity.checkToStartDownloadRequest(paramBundle, true);
          return;
        }
        paramActivity.chooseDownloadStrategy(paramBundle, true);
        return;
      }
      paramActivity.checkToStartDownloadRequest(paramBundle, false);
      return;
    case 4: 
    case 6: 
    case 8: 
    case 9: 
    case 13: 
      if (paramBundle.mIsNewVer)
      {
        LogUtil.e("UTEST", "chooseUpdateStrategy model status:" + paramBundle.mTaskStatus);
        paramActivity.chooseUpdateStrategy(paramBundle);
        return;
      }
      if (!BNOfflineDataManager.getInstance().isCommonDataDownload())
      {
        localOfflineDataInfo = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
        if ((localOfflineDataInfo != null) && (localOfflineDataInfo.mTaskStatus == 1))
        {
          paramActivity.checkToStartDownloadRequest(paramBundle, true);
          return;
        }
        paramActivity.chooseDownloadStrategy(paramBundle, true);
        return;
      }
      paramActivity.chooseDownloadStrategy(paramBundle, false);
      return;
    }
    paramActivity.chooseUpdateStrategy(paramBundle);
  }
  
  private void initView(View paramView)
  {
    try
    {
      this.mRootView = JarUtils.inflate(this.mActivity, 1711472691, null);
      if (this.mRootView == null) {
        return;
      }
      LogUtil.e("zzt", "mRootView  " + this.mRootView);
      this.mOfflinecontentview = ((RelativeLayout)this.mRootView.findViewById(1711866333));
      this.mVerticalListView = ((ListView)this.mRootView.findViewById(1711866344));
      this.mTitleBar = ((BNCommonTitleBar)this.mRootView.findViewById(1711865893));
      this.mDiskSpaceTextView = ((TextView)this.mRootView.findViewById(1711866345));
      this.mUpdateLogTextView = ((TextView)this.mRootView.findViewById(1711866347));
      this.bottom_status = ((RelativeLayout)this.mRootView.findViewById(1711866334));
      this.mUpdateLogTextView.setVisibility(4);
      this.bottom_status.setVisibility(8);
      this.mUpdateLogTextView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      this.middleTitleView = JarUtils.inflate(this.mActivity, 1711472693, null);
      LogUtil.e("zzt", "mRootView1111  " + this.mRootView);
      if (this.middleTitleView != null) {
        this.mTitleBar.setMiddleContent(this.middleTitleView);
      }
      this.mOfflineDataSettingView = this.mRootView.findViewById(1711866335);
      this.mUnDownload = ((RadioButton)this.middleTitleView.findViewById(1711866350));
      this.mDownload = ((RadioButton)this.middleTitleView.findViewById(1711866351));
      this.mUnDownload.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDownloadTabView.access$002(BNDownloadTabView.this, false);
          BNDownloadTabView.this.bottom_status.setVisibility(8);
          BNDownloadTabView.this.mOfflineDataSettingView.setVisibility(8);
          BNDownloadTabView.this.mUnDownload.setChecked(true);
          BNDownloadTabView.this.mDownload.setChecked(false);
          BNDownloadTabView.this.updateUserClickStatus(Boolean.valueOf(true));
        }
      });
      this.mDownload.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDownloadTabView.access$002(BNDownloadTabView.this, true);
          BNDownloadTabView.this.bottom_status.setVisibility(0);
          paramAnonymousView = BNOfflineDataManager.getInstance().getDownloadedList();
          if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0)) {
            BNDownloadTabView.this.mOfflineDataSettingView.setVisibility(0);
          }
          for (;;)
          {
            BNDownloadTabView.this.mUnDownload.setChecked(false);
            BNDownloadTabView.this.mDownload.setChecked(true);
            BNDownloadTabView.this.updateUserClickStatus(Boolean.valueOf(false));
            return;
            BNDownloadTabView.this.mOfflineDataSettingView.setVisibility(8);
          }
        }
      });
      setupTitleBar();
      this.mNetModeView = this.mRootView.findViewById(1711866336);
      this.mCheckboxs[0] = ((ImageView)this.mRootView.findViewById(1711866339));
      this.mWIFIUpdateView = this.mRootView.findViewById(1711866340);
      this.mCheckboxs[1] = ((ImageView)this.mRootView.findViewById(1711866343));
      this.mNetModeView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDownloadTabView.this.reverseItemCheck(0);
          BNDownloadTabView.this.onSettingsChange(0);
        }
      });
      this.mWIFIUpdateView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDownloadTabView.this.reverseItemCheck(1);
          BNDownloadTabView.this.onSettingsChange(1);
        }
      });
      int i = 0;
      while (i < 2)
      {
        updateView(i);
        i += 1;
      }
      return;
    }
    catch (Exception paramView) {}
  }
  
  private void onSettingsChange(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        updateView(paramInt);
        return;
      }
      catch (Throwable localThrowable) {}
      if (this.mItems[paramInt] != null)
      {
        setRPNetMode(this.mItems[paramInt].mIsCheck);
        continue;
        if (this.mItems[paramInt] != null) {
          BNSettingManager.setAutoUpdateNewData(this.mItems[paramInt].mIsCheck);
        }
      }
    }
  }
  
  private void reverseItemCheck(int paramInt)
  {
    if (this.mItems[paramInt] == null) {
      return;
    }
    ListItem localListItem = this.mItems[paramInt];
    if (!this.mItems[paramInt].mIsCheck) {}
    for (boolean bool = true;; bool = false)
    {
      localListItem.mIsCheck = bool;
      return;
    }
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
  }
  
  private void setRPNetMode(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      BNSettingManager.setPrefRoutePlanMode(i);
      return;
    }
  }
  
  private void setupTitleBar()
  {
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    };
    this.mTitleBar.setRightContenVisible(false);
    this.mTitleBar.setRightOnClickedListener(local6);
  }
  
  private void updateCheckDrawable(int paramInt)
  {
    if (this.mItems[paramInt].mIsCheck)
    {
      this.mCheckboxs[paramInt].setImageDrawable(JarUtils.getResources().getDrawable(1711408040));
      return;
    }
    this.mCheckboxs[paramInt].setImageDrawable(JarUtils.getResources().getDrawable(1711408041));
  }
  
  private void updateDiskSpaceTV(long paramLong1, long paramLong2)
  {
    if (paramLong1 < 1.0E-7D) {}
    for (String str1 = "0M";; str1 = StringUtils.ByteSizeToStringForLong(Long.valueOf(paramLong1)))
    {
      String str2 = StringUtils.ByteSizeToStringForLong(Long.valueOf(paramLong2));
      LogUtil.e("OfflineData", "updateDiskSpaceTV totalDownloadSize:" + paramLong1 + "  diskSpace: " + paramLong2 + "tempTotalDownloadSize:" + str1 + "  tempDiskSpace: " + str2);
      this.mDiskSpaceTextView.setText(JarUtils.getResources().getString(1711669673, new Object[] { str1, str2 }));
      return;
    }
  }
  
  private void updateUserClickStatus(Boolean paramBoolean)
  {
    if (this.mVerticalListAdapter != null) {
      this.mVerticalListAdapter.updateUserClickStatus(paramBoolean);
    }
    if (!paramBoolean.booleanValue())
    {
      BNOfflineDataManager.getInstance().updateMapDataStutas();
      if (this.mVerticalListAdapter != null) {
        this.mVerticalListAdapter.updateData(true);
      }
    }
    updateList();
  }
  
  private void updateView(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      updateCheckDrawable(paramInt);
      return;
    }
    updateCheckDrawable(paramInt);
  }
  
  public void destroy()
  {
    if (this.mVerticalListAdapter != null) {
      this.mVerticalListAdapter.dimissLinkageDialog();
    }
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public void setBackBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnBackBtnClickListener = paramOnClickListener;
    if ((this.mTitleBar != null) && (paramOnClickListener != null)) {
      this.mTitleBar.setLeftOnClickedListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNDownloadTabView.this.mOnBackBtnClickListener != null) {
            BNDownloadTabView.this.mOnBackBtnClickListener.onClick(paramAnonymousView);
          }
        }
      });
    }
  }
  
  public void setShowBundle(Bundle paramBundle)
  {
    this.mShowBundle = paramBundle;
  }
  
  public void updateList()
  {
    if (this.mVerticalListAdapter != null)
    {
      this.mVerticalListAdapter.updateData();
      this.mVerticalListAdapter.notifyDataSetChanged();
    }
    if ((this.mIsShowDownloadedPage) && (this.mOfflineDataSettingView != null))
    {
      ArrayList localArrayList = BNOfflineDataManager.getInstance().getDownloadedList();
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break label96;
      }
      this.mOfflineDataSettingView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.mVerticalListAdapter != null) && (!this.mVerticalListAdapter.getmIsUndownload().booleanValue())) {
        Message.obtain(this.mHandler, 5, 0, 0, null).sendToTarget();
      }
      return;
      label96:
      this.mOfflineDataSettingView.setVisibility(8);
    }
  }
  
  public void updateOrientation(int paramInt)
  {
    this.mVerticalListAdapter = new BNOfflineDataVerticalListAdapter(this.mActivity, this.mDelegate);
    this.mVerticalListView.setAdapter(this.mVerticalListAdapter);
    this.mVerticalListView.setVisibility(0);
    this.middleTitleView.setVisibility(0);
    this.mTitleBar.setMiddleTextVisible(false);
    updateList();
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    try
    {
      if (this.mOfflinecontentview != null) {
        this.mOfflinecontentview.setBackgroundColor(JarUtils.getResources().getColor(1711800420));
      }
      if (this.mVerticalListView != null) {
        this.mVerticalListView.setBackgroundColor(JarUtils.getResources().getColor(1711800434));
      }
      if (this.mVerticalListAdapter != null)
      {
        if (!this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
          break label129;
        }
        this.mUnDownload.setChecked(true);
        this.mDownload.setChecked(false);
      }
      for (;;)
      {
        if (this.bottom_status != null) {
          this.bottom_status.setBackgroundColor(JarUtils.getResources().getColor(1711800430));
        }
        if (this.mDiskSpaceTextView == null) {
          break;
        }
        this.mDiskSpaceTextView.setTextColor(JarUtils.getResources().getColor(1711800432));
        return;
        label129:
        this.mUnDownload.setChecked(false);
        this.mDownload.setChecked(true);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
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
      if (BNDownloadTabView.this.mVerticalListAdapter != null) {
        localObject = BNDownloadTabView.this.mVerticalListAdapter;
      }
      if (localObject != null)
      {
        ((BNOfflineDataListAdapter)localObject).updateDiskSpace();
        Bundle localBundle = new Bundle();
        localBundle.putLong("TotalDownloadSize", ((BNOfflineDataListAdapter)localObject).getmTotalDownloadSize());
        localBundle.putLong("DiskSpace", ((BNOfflineDataListAdapter)localObject).getmDiskSpace());
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
  
  private class HandleMd5ErrorThread
    extends Thread
  {
    private Handler mUIHandler = null;
    
    public HandleMd5ErrorThread(Handler paramHandler)
    {
      this.mUIHandler = paramHandler;
    }
    
    public void run()
    {
      BNOfflineDataManager.getInstance().handleMd5ToRedownload();
      Message.obtain(this.mUIHandler, 8, 0, 0, null).sendToTarget();
    }
  }
  
  private class ListItem
  {
    boolean mHasCheckBox;
    boolean mIsCheck;
    
    private ListItem() {}
  }
  
  private class OnListItemClickListener
    implements AdapterView.OnItemClickListener
  {
    private OnListItemClickListener() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView = null;
      paramView = null;
      if (BNDownloadTabView.this.mVerticalListAdapter != null)
      {
        paramAdapterView = BNDownloadTabView.this.mVerticalListAdapter;
        paramView = (OfflineDataInfo)BNDownloadTabView.this.mVerticalListAdapter.getItem((int)paramLong);
      }
      if (paramView == null) {}
      do
      {
        return;
        LogUtil.e("UTEST", "Item clicked model status:" + paramView.mTaskStatus);
        switch (paramView.mTaskStatus)
        {
        case 5: 
        case 7: 
        default: 
          return;
        }
      } while (paramView.mIsRequest);
      try
      {
        BNOfflineDataManager.getInstance().memoryUserOper(paramView.mProvinceId, true, 0);
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
        return;
        if (paramView.mIsNewVer)
        {
          BNOfflineDataManager.getInstance().memoryUserOper(paramView.mProvinceId, true, 1);
          LogUtil.e("UTEST", "chooseUpdateStrategy model status:" + paramView.mTaskStatus);
          paramAdapterView.chooseUpdateStrategy(paramView);
          return;
        }
        LogUtil.e("UTEST", "chooseDownloadStrategy model status:" + paramView.mTaskStatus);
        BNOfflineDataManager.getInstance().memoryUserOper(paramView.mProvinceId, true, 0);
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
        try
        {
          BNOfflineDataManager.getInstance().memoryUserOper(paramView.mProvinceId, true, 1);
          paramAdapterView.chooseUpdateStrategy(paramView);
          return;
        }
        catch (Throwable localThrowable1)
        {
          for (;;) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
    }
  }
  
  private class OnListItemLongClickListener
    implements AdapterView.OnItemLongClickListener
  {
    private OnListItemLongClickListener() {}
    
    public boolean onItemLongClick(final AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      boolean bool1 = false;
      paramAdapterView = null;
      if (BNDownloadTabView.this.mVerticalListAdapter != null) {
        paramAdapterView = BNDownloadTabView.this.mVerticalListAdapter.getDownloadedListModelByPosition((int)paramLong);
      }
      if (paramAdapterView == null) {}
      final int i;
      final boolean bool2;
      do
      {
        return false;
        if (paramAdapterView.mTaskStatus == 16)
        {
          TipTool.onCreateToastDialog(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(1711669806));
          return false;
        }
        i = paramAdapterView.mProvinceId;
        bool2 = paramAdapterView.mIsNewVer;
        paramInt = SDCardUtils.handleOfflinePathError(0L, true);
        if ((paramInt == 2) || (paramInt == 3))
        {
          TipTool.onCreateToastDialog(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(1711669656));
          return false;
        }
        if ((BNDownloadTabView.this.mVerticalListAdapter == null) || (!BNDownloadTabView.this.mVerticalListAdapter.getmIsUndownload().booleanValue())) {
          break;
        }
      } while (paramAdapterView.mTaskStatus == 1);
      if ((!paramAdapterView.mIsNewVer) && (paramAdapterView.mProvinceId == 0) && (!BNOfflineDataManager.getInstance().isDeleteCommonDataVailid())) {}
      for (;;)
      {
        try
        {
          if ((BNDownloadTabView.this.mDeleteCommonAlertDlg == null) && (BNDownloadTabView.this.mActivity != null)) {
            BNDownloadTabView.access$1302(BNDownloadTabView.this, new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681)).setMessage(JarUtils.getResources().getString(1711669670)).setFirstBtnText(JarUtils.getResources().getString(1711669685)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
            {
              public void onClick()
              {
                Message.obtain(BNDownloadTabView.this.mHandler, 3, 0, 0, null).sendToTarget();
              }
            }));
          }
          if ((BNDownloadTabView.this.mDeleteCommonAlertDlg != null) && (!BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing())) {
            BNDownloadTabView.this.mDeleteCommonAlertDlg.show();
          }
        }
        catch (Exception paramAdapterView)
        {
          continue;
        }
        return true;
        try
        {
          if ((BNDownloadTabView.this.mDeleteAlertDlg == null) && (BNDownloadTabView.this.mActivity != null)) {
            BNDownloadTabView.access$1502(BNDownloadTabView.this, new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681)).setMessage(JarUtils.getResources().getString(1711669654)).setSecondBtnText(JarUtils.getResources().getString(1711669682)).setOnSecondBtnClickListener(new BNBaseDialog.OnNaviClickListener()
            {
              public void onClick()
              {
                try
                {
                  if (BNDownloadTabView.this.mWaitProgress == null) {
                    BNDownloadTabView.access$1602(BNDownloadTabView.this, new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(1711669661)));
                  }
                  if ((BNDownloadTabView.this.mWaitProgress != null) && (!BNDownloadTabView.this.mWaitProgress.isShowing())) {
                    BNDownloadTabView.this.mWaitProgress.show();
                  }
                }
                catch (Exception localException)
                {
                  Message localMessage;
                  for (;;) {}
                }
                if (bool2) {}
                for (localMessage = Message.obtain(BNDownloadTabView.this.mHandler, 4, i, 0, null);; localMessage = Message.obtain(BNDownloadTabView.this.mHandler, 2, i, 0, null))
                {
                  localMessage.sendToTarget();
                  if (BNDownloadTabView.this.mDeleteAlertDlg != null)
                  {
                    BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                    BNDownloadTabView.access$1502(BNDownloadTabView.this, null);
                  }
                  return;
                }
              }
            }).setFirstBtnText(JarUtils.getResources().getString(1711669683)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
            {
              public void onClick()
              {
                if (BNDownloadTabView.this.mDeleteAlertDlg != null)
                {
                  BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                  BNDownloadTabView.access$1502(BNDownloadTabView.this, null);
                }
              }
            }));
          }
          if ((BNDownloadTabView.this.mDeleteAlertDlg == null) || (BNDownloadTabView.this.mDeleteAlertDlg.isShowing()) || (BNDownloadTabView.this.mActivity == null) || (BNDownloadTabView.this.mActivity.isFinishing())) {
            continue;
          }
          BNDownloadTabView.this.mDeleteAlertDlg.show();
        }
        catch (Exception paramAdapterView) {}
        continue;
        if ((BNDownloadTabView.this.mVerticalListAdapter != null) && (!BNDownloadTabView.this.mVerticalListAdapter.getmIsUndownload().booleanValue()))
        {
          if ((paramAdapterView.mProvinceId == 0) && (!BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()))
          {
            try
            {
              if ((BNDownloadTabView.this.mDeleteCommonAlertDlg == null) && (BNDownloadTabView.this.mActivity != null)) {
                BNDownloadTabView.access$1302(BNDownloadTabView.this, new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681)).setMessage(JarUtils.getResources().getString(1711669670)).setFirstBtnText(JarUtils.getResources().getString(1711669685)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
                {
                  public void onClick()
                  {
                    Message.obtain(BNDownloadTabView.this.mHandler, 3, 0, 0, null).sendToTarget();
                  }
                }));
              }
              if ((BNDownloadTabView.this.mDeleteCommonAlertDlg == null) || (BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing()) || (BNDownloadTabView.this.mActivity == null) || (BNDownloadTabView.this.mActivity.isFinishing())) {
                continue;
              }
              BNDownloadTabView.this.mDeleteCommonAlertDlg.show();
            }
            catch (Exception paramAdapterView) {}
          }
          else
          {
            if ((paramAdapterView.mTaskStatus == 11) || (paramAdapterView.mTaskStatus == 12) || (paramAdapterView.mTaskStatus == 13)) {
              bool1 = true;
            }
            paramAdapterView = Boolean.valueOf(bool1);
            try
            {
              if ((BNDownloadTabView.this.mDeleteAlertDlg == null) && (BNDownloadTabView.this.mActivity != null))
              {
                paramView = BNDownloadTabView.this;
                BNMessageDialog localBNMessageDialog = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681));
                Resources localResources = JarUtils.getResources();
                if (!paramAdapterView.booleanValue()) {
                  continue;
                }
                paramInt = 1711669654;
                BNDownloadTabView.access$1502(paramView, localBNMessageDialog.setMessage(localResources.getString(paramInt)).setSecondBtnText(JarUtils.getResources().getString(1711669682)).setOnSecondBtnClickListener(new BNBaseDialog.OnNaviClickListener()
                {
                  public void onClick()
                  {
                    try
                    {
                      if (BNDownloadTabView.this.mWaitProgress == null) {
                        BNDownloadTabView.access$1602(BNDownloadTabView.this, new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(1711669661)));
                      }
                      if ((BNDownloadTabView.this.mWaitProgress != null) && (!BNDownloadTabView.this.mWaitProgress.isShowing())) {
                        BNDownloadTabView.this.mWaitProgress.show();
                      }
                    }
                    catch (Exception localException)
                    {
                      Message localMessage;
                      for (;;) {}
                    }
                    if (paramAdapterView.booleanValue()) {}
                    for (localMessage = Message.obtain(BNDownloadTabView.this.mHandler, 4, i, 0, null);; localMessage = Message.obtain(BNDownloadTabView.this.mHandler, 2, i, 0, null))
                    {
                      localMessage.sendToTarget();
                      if (BNDownloadTabView.this.mDeleteAlertDlg != null)
                      {
                        BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                        BNDownloadTabView.access$1502(BNDownloadTabView.this, null);
                      }
                      return;
                    }
                  }
                }).setFirstBtnText(JarUtils.getResources().getString(1711669683)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
                {
                  public void onClick()
                  {
                    if (BNDownloadTabView.this.mDeleteAlertDlg != null)
                    {
                      BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                      BNDownloadTabView.access$1502(BNDownloadTabView.this, null);
                    }
                  }
                }));
              }
              if ((BNDownloadTabView.this.mDeleteAlertDlg == null) || (BNDownloadTabView.this.mDeleteAlertDlg.isShowing()) || (BNDownloadTabView.this.mActivity == null) || (BNDownloadTabView.this.mActivity.isFinishing())) {
                continue;
              }
              BNDownloadTabView.this.mDeleteAlertDlg.show();
            }
            catch (Exception paramAdapterView) {}
            continue;
            paramInt = 1711669657;
          }
        }
        else if ((paramAdapterView.mProvinceId == 0) && (!BNOfflineDataManager.getInstance().isDeleteCommonDataVailid())) {
          try
          {
            if ((BNDownloadTabView.this.mDeleteCommonAlertDlg == null) && (BNDownloadTabView.this.mActivity != null)) {
              BNDownloadTabView.access$1302(BNDownloadTabView.this, new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681)).setMessage(JarUtils.getResources().getString(1711669670)).setFirstBtnText(JarUtils.getResources().getString(1711669685)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
              {
                public void onClick()
                {
                  Message.obtain(BNDownloadTabView.this.mHandler, 3, 0, 0, null).sendToTarget();
                }
              }));
            }
            if ((BNDownloadTabView.this.mDeleteCommonAlertDlg == null) || (BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing()) || (BNDownloadTabView.this.mActivity == null) || (BNDownloadTabView.this.mActivity.isFinishing())) {
              continue;
            }
            BNDownloadTabView.this.mDeleteCommonAlertDlg.show();
          }
          catch (Exception paramAdapterView) {}
        } else {
          try
          {
            if ((BNDownloadTabView.this.mDeleteAlertDlg == null) && (BNDownloadTabView.this.mActivity != null)) {
              BNDownloadTabView.access$1502(BNDownloadTabView.this, new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(1711669681)).setMessage(JarUtils.getResources().getString(1711669657)).setSecondBtnText(JarUtils.getResources().getString(1711669682)).setOnSecondBtnClickListener(new BNBaseDialog.OnNaviClickListener()
              {
                public void onClick()
                {
                  if (BNDownloadTabView.this.mWaitProgress == null) {
                    BNDownloadTabView.access$1602(BNDownloadTabView.this, new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(1711669661)));
                  }
                  if (!BNDownloadTabView.this.mWaitProgress.isShowing()) {
                    BNDownloadTabView.this.mWaitProgress.show();
                  }
                  Message.obtain(BNDownloadTabView.this.mHandler, 2, i, 0, null).sendToTarget();
                  if (BNDownloadTabView.this.mDeleteAlertDlg != null)
                  {
                    BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                    BNDownloadTabView.access$1502(BNDownloadTabView.this, null);
                  }
                }
              }).setFirstBtnText(JarUtils.getResources().getString(1711669683)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
              {
                public void onClick()
                {
                  if (BNDownloadTabView.this.mDeleteAlertDlg != null)
                  {
                    BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                    BNDownloadTabView.access$1502(BNDownloadTabView.this, null);
                  }
                }
              }));
            }
            if ((BNDownloadTabView.this.mDeleteAlertDlg != null) && (!BNDownloadTabView.this.mDeleteAlertDlg.isShowing()) && (BNDownloadTabView.this.mActivity != null) && (!BNDownloadTabView.this.mActivity.isFinishing())) {
              BNDownloadTabView.this.mDeleteAlertDlg.show();
            }
          }
          catch (Exception paramAdapterView) {}
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/download/view/BNDownloadTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */