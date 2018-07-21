package com.baidu.baidunavis.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavDayNightController;
import com.baidu.baidunavis.control.NavDayNightController.OnDayNightChangedListener;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.ImportNaviMapDataListener;
import com.baidu.navisdk.ui.download.BNDownloadNotifyManager;
import com.baidu.navisdk.ui.download.BNDownloadUIManager;

public class BNDownloadPage
  extends ContentFragment
{
  public static final String KEY_FROM_CRUISER = "KEY_FROM_CRUISER";
  public static final String NAVIGATE_PAGE_NAME = "target_page_name";
  private static final String TAG = BNDownloadPage.class.getSimpleName();
  private boolean mIsFromCruiser = false;
  private NavDayNightController.OnDayNightChangedListener mOnDayNightChangedListener = new NavDayNightController.OnDayNightChangedListener()
  {
    public void onDayNightChanged(boolean paramAnonymousBoolean)
    {
      if (BNDownloadPage.this.mUIManager != null) {
        BNDownloadPage.this.mUIManager.updateStyle(paramAnonymousBoolean);
      }
    }
  };
  private BNDownloadUIManager mUIManager;
  
  private boolean initDownloadUIManager(final Activity paramActivity)
  {
    if ((this.mUIManager == null) || (!this.mUIManager.isViewCreated()))
    {
      this.mUIManager = BNDownloadUIManager.getInstance(paramActivity);
      if (this.mUIManager == null) {
        return false;
      }
      this.mUIManager.createView(paramActivity);
      this.mUIManager.setBackBtnOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDownloadPage.this.back();
        }
      });
      BNOfflineDataManager.getInstance().setImportNaviMapDataListener(new BNOfflineDataManager.ImportNaviMapDataListener()
      {
        @Deprecated
        public boolean checkDataExitByProvinceId(int paramAnonymousInt)
        {
          return false;
        }
        
        public void onImportNaviMapData()
        {
          Activity localActivity = paramActivity;
          if (localActivity != null) {
            localActivity.runOnUiThread(new Runnable()
            {
              public void run()
              {
                NavMapAdapter.getInstance().importMap();
              }
            });
          }
        }
        
        public void startDownLoadDataByProvinceId(int paramAnonymousInt) {}
      });
    }
    return true;
  }
  
  private void initNotification(Activity paramActivity)
  {
    paramActivity = getActivity();
    Intent localIntent = new Intent(paramActivity, CarlifeActivity.class);
    localIntent.putExtra("target_page_name", getClass().getName());
    RemoteViews localRemoteViews = new RemoteViews(paramActivity.getPackageName(), 2130969022);
    BNDownloadNotifyManager.getInstance().init(paramActivity, localIntent, 2130838698, localRemoteViews, 2131625346, 2131626083, 2131626086);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mUIManager != null) {
      this.mUIManager.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if ((paramBundle != null) && (paramBundle.containsKey("KEY_FROM_CRUISER"))) {
      this.mIsFromCruiser = paramBundle.getBoolean("KEY_FROM_CRUISER", false);
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((!BaiduNaviManager.sIsBaseEngineInitialized) || (!initDownloadUIManager(getActivity())))
    {
      NavTipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), 2131296660);
      back();
      paramLayoutInflater = null;
    }
    do
    {
      return paramLayoutInflater;
      if (this.mUIManager == null) {
        break;
      }
      this.mUIManager.remmoveParentView();
      paramViewGroup = this.mUIManager.getView();
      paramLayoutInflater = paramViewGroup;
    } while (paramViewGroup != null);
    back();
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    NavDayNightController.getInstance().unregisterDayNightListener(this.mOnDayNightChangedListener);
    if (this.mUIManager != null) {
      this.mUIManager.destroyView();
    }
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    getActivity().setRequestedOrientation(2);
  }
  
  public void onResume()
  {
    super.onResume();
    getActivity().setRequestedOrientation(1);
    initNotification(getActivity());
    this.mOnDayNightChangedListener.onDayNightChanged(NavDayNightController.getInstance().isDay());
    NavDayNightController.getInstance().registerDayNightListener(this.mOnDayNightChangedListener);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/BNDownloadPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */