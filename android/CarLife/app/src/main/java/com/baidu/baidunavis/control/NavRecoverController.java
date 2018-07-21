package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper.LastNaviStatusListener;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.platform.comapi.c;
import java.util.ArrayList;

public class NavRecoverController
{
  private static final String NAVI_FLAG_PREF = "pref_navi_flag";
  private static final String NAVI_KILL_TIME_PREF = "navi_kill_time_pref";
  private static final String TAG = "NavRecoverController";
  private static NavRecoverController sInstance = null;
  private ArrayList<RoutePlanNode> mLastRoutePlanNodes = new ArrayList();
  
  private void checkLastNaviStatusInner(final Handler paramHandler)
  {
    BNRecoverNaviHelper.getInstance().checkLastNaviStatus(new BNRecoverNaviHelper.LastNaviStatusListener()
    {
      public void onGetNodeList(ArrayList<RoutePlanNode> paramAnonymousArrayList)
      {
        int i = 0;
        NavRecoverController.this.mLastRoutePlanNodes.clear();
        if ((paramAnonymousArrayList != null) && (!paramAnonymousArrayList.isEmpty())) {
          NavRecoverController.this.mLastRoutePlanNodes.addAll(paramAnonymousArrayList);
        }
        if (paramHandler != null)
        {
          paramAnonymousArrayList = paramHandler.obtainMessage(0);
          if (!NavRecoverController.this.mLastRoutePlanNodes.isEmpty()) {
            break label101;
          }
        }
        for (;;)
        {
          paramAnonymousArrayList.arg1 = i;
          NavLogUtils.e("NavRecoverController", "checkLastNaviStatusInner result : " + paramAnonymousArrayList.arg1);
          paramAnonymousArrayList.sendToTarget();
          return;
          label101:
          i = 1;
        }
      }
    });
  }
  
  public static NavRecoverController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavRecoverController();
    }
    return sInstance;
  }
  
  public boolean checkLastNaviStatus(final Handler paramHandler)
  {
    NavLogUtils.e("NavRecoverController", "checkLastnaviStatus() ");
    BaiduNaviManager.getInstance();
    if (!BaiduNaviManager.isNaviSoLoadSuccess()) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = NavCommonFuncModel.getInstance().getActivity();
      if ((localActivity != null) && (!NavMapAdapter.getInstance().isExternalStorageEnabled()))
      {
        NavTipTool.onCreateToastDialog(localActivity, 2131296667);
        return false;
      }
      if (BaiduNaviManager.sIsBaseEngineInitialized) {
        break;
      }
    } while (localActivity == null);
    BaiduNaviManager.getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
    {
      public void engineInitFail()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("RecoverEngFail-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().showMToast(c.f(), 2131296656);
            NavMapAdapter.getInstance().dismissMProgressDialog();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitStart()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("RecoverEngStart-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitSuccess()
      {
        LogUtil.e("SDKHelper", "engineInitSuccess");
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("RecoverEngSuc-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().dismissMProgressDialog();
            NavRecoverController.this.checkLastNaviStatusInner(NavRecoverController.1.this.val$handler);
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
    });
    for (;;)
    {
      return true;
      checkLastNaviStatusInner(paramHandler);
    }
  }
  
  public boolean clearLastNaviRoutelnfo()
  {
    BaiduNaviManager.getInstance();
    if (!BaiduNaviManager.isNaviSoLoadSuccess()) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = NavCommonFuncModel.getInstance().getActivity();
      if ((localActivity != null) && (!NavMapAdapter.getInstance().isExternalStorageEnabled()))
      {
        NavTipTool.onCreateToastDialog(localActivity, 2131296667);
        return false;
      }
      if (BaiduNaviManager.sIsBaseEngineInitialized) {
        break;
      }
    } while (localActivity == null);
    BaiduNaviManager.getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
    {
      public void engineInitFail()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBaseEngFail-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().showMToast(c.f(), 2131296656);
            NavMapAdapter.getInstance().dismissMProgressDialog();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitStart()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBaseEngStart-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitSuccess()
      {
        LogUtil.e("SDKHelper", "engineInitSuccess");
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBaseEngSuc-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().dismissMProgressDialog();
            NavLogUtils.e(TAG, "clearLastNaviRoutelnfo");
            NavRecoverController.this.mLastRoutePlanNodes.clear();
            BNRecoverNaviHelper.getInstance().clearLastNaviInfo();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
    });
    for (;;)
    {
      return true;
      NavLogUtils.e("NavRecoverController", "clearLastNaviRoutelnfo");
      this.mLastRoutePlanNodes.clear();
      BNRecoverNaviHelper.getInstance().clearLastNaviInfo();
      BNRecoverNaviHelper.getInstance().setNaviFlag(localActivity.getApplicationContext(), false);
    }
  }
  
  public boolean continueLastNavi()
  {
    if (!BaiduNaviManager.isNaviSoLoadSuccess()) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = NavCommonFuncModel.getInstance().getActivity();
      if ((localActivity != null) && (!NavMapAdapter.getInstance().isExternalStorageEnabled()))
      {
        NavTipTool.onCreateToastDialog(localActivity, 2131296667);
        return false;
      }
      if (BaiduNaviManager.sIsBaseEngineInitialized) {
        break;
      }
    } while (localActivity == null);
    BaiduNaviManager.getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
    {
      public void engineInitFail()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBEFail-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().showMToast(c.f(), 2131296656);
            NavMapAdapter.getInstance().dismissMProgressDialog();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitStart()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBEStart-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitSuccess()
      {
        LogUtil.e("SDKHelper", "engineInitSuccess");
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBESuc-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().dismissMProgressDialog();
            NavRoutePlanController.getInstance().continueLastNavi(NavRecoverController.this.mLastRoutePlanNodes);
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
    });
    for (;;)
    {
      return true;
      NavLogUtils.e("NavRecoverController", "continueLastNavi nodes size : " + this.mLastRoutePlanNodes.size());
      if ((NavLogUtils.LOGGABLE) && (this.mLastRoutePlanNodes.size() > 0))
      {
        int i = 0;
        while (i < this.mLastRoutePlanNodes.size())
        {
          NavLogUtils.e("NavRecoverController", " node " + i + " is : " + ((RoutePlanNode)this.mLastRoutePlanNodes.get(i)).toString());
          i += 1;
        }
      }
      NavRoutePlanController.getInstance().continueLastNavi(this.mLastRoutePlanNodes);
    }
  }
  
  public long getKilledTime(Context paramContext)
  {
    if (paramContext == null) {
      return 0L;
    }
    return paramContext.getSharedPreferences("navi", 0).getLong("navi_kill_time_pref", 0L);
  }
  
  public ArrayList<RoutePlanNode> getLastRoutePlanNoes()
  {
    return this.mLastRoutePlanNodes;
  }
  
  public boolean isLastNaviUnfinished(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    boolean bool = paramContext.getSharedPreferences("navi", 0).getBoolean("pref_navi_flag", false);
    NavLogUtils.e("NavRecoverController", "isLastNaviUnfinished state : " + bool);
    return bool;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavRecoverController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */