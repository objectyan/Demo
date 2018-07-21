package com.baidu.navisdk.ui.voice.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice.OnVoicePageJumpListener;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadController;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.drawable.UrlDrawable;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class VoiceMainView
  extends VoiceBaseView
{
  private boolean isExternalCall = false;
  private boolean isFromNavingPage;
  private BNCommonTitleBar mBNCommonTitleBar = null;
  private BNDialog mDeleteDialog = null;
  private View mEnterSquareBtn = null;
  private String mHeadUrl = null;
  boolean mMapMode = true;
  private MyVoiceAdapter mMyVoiceAdapter = null;
  private ArrayList<VoiceItemInfo> mMyVoiceInfos = new ArrayList();
  private ListView mMyVoiceListview = null;
  private BNDialog mNetStatusDialog = null;
  private ArrayList<VoiceItemInfo> mSharedInfos = new ArrayList();
  private VoiceItemInfo mSharedVoiceInfo = null;
  private String mUsedTaskId = null;
  private ViewGroup mVoiceMainView = null;
  private int mVoiceMode = 0;
  private BNCommonProgressDialog mWaitingLoading = null;
  private ArrayList<VoiceItemInfo> mhasDownInfos = new ArrayList();
  
  private void dismissWaitingLoading()
  {
    try
    {
      if ((this.mWaitingLoading != null) && (this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.mWaitingLoading.isShowing())) {
        this.mWaitingLoading.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      this.mWaitingLoading = null;
    }
  }
  
  private void downloadStatics(String paramString)
  {
    if (this.mJumpListener != null) {
      this.mJumpListener.onVoiceUserBehaviour("voice_download");
    }
    if ("9999".equals(paramString))
    {
      BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410350", "410350");
      return;
    }
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410351", "410351");
  }
  
  private void findViews()
  {
    if (this.mVoiceMainView == null) {
      return;
    }
    this.mBNCommonTitleBar = ((BNCommonTitleBar)this.mVoiceMainView.findViewById(1711867296));
    this.mMyVoiceListview = ((ListView)this.mVoiceMainView.findViewById(1711867297));
    this.mEnterSquareBtn = this.mVoiceMainView.findViewById(1711867298);
    if ((this.mBNCommonTitleBar == null) || (this.mMyVoiceListview == null) || (this.mEnterSquareBtn == null))
    {
      this.mVoiceMainView = null;
      return;
    }
    this.mBNCommonTitleBar.setMiddleTextSize(18.0F);
    this.mBNCommonTitleBar.setLeftOnClickedListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (VoiceMainView.this.mJumpListener != null) {
          VoiceMainView.this.mJumpListener.onBack(null);
        }
      }
    });
    this.mMyVoiceAdapter = new MyVoiceAdapter();
    this.mMyVoiceListview.setAdapter(this.mMyVoiceAdapter);
    this.mMyVoiceListview.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        LogUtil.e("BNVoice", "zyq onItemClick pos = " + paramAnonymousInt);
        if (VoiceMainView.this.isFromNavingPage) {}
        do
        {
          do
          {
            do
            {
              return;
            } while (VoiceMainView.this.mMyVoiceAdapter == null);
            paramAnonymousAdapterView = (VoiceMainView.VoiceItemInfo)VoiceMainView.this.mMyVoiceAdapter.getItem(paramAnonymousInt);
          } while ((paramAnonymousAdapterView == null) || ((paramAnonymousAdapterView.mType != 1) && (paramAnonymousAdapterView.mType != 2) && (paramAnonymousAdapterView.mType != 3)));
          if (((paramAnonymousAdapterView.mInfo.status == 2) || (paramAnonymousAdapterView.mInfo.status == 3)) && (!NetworkUtils.isNetworkAvailable(VoiceMainView.this.mActivity)))
          {
            TipTool.onCreateToastDialog(VoiceMainView.this.mActivity, JarUtils.getResources().getString(1711670130));
            return;
          }
        } while (VoiceMainView.this.mJumpListener == null);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putBundle("VOICEINFO", paramAnonymousAdapterView.mInfo.toBundle());
        VoiceMainView.this.mJumpListener.onPageJump(1, 4, paramAnonymousView);
      }
    });
    this.mMyVoiceListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        LogUtil.e("BNVoice", "zyq onItemLongClick pos = " + paramAnonymousInt);
        if (VoiceMainView.this.mMyVoiceAdapter != null)
        {
          paramAnonymousAdapterView = (VoiceMainView.VoiceItemInfo)VoiceMainView.this.mMyVoiceAdapter.getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView.mInfo != null) && (paramAnonymousAdapterView.mInfo.taskId != null))
          {
            if (paramAnonymousAdapterView.mType != 1) {
              break label114;
            }
            if (!paramAnonymousAdapterView.mInfo.taskId.equals(VoiceHelper.getInstance().getCurrentUsedTTSId())) {
              VoiceMainView.this.showDeleteDialog(JarUtils.getResources().getString(1711670103), paramAnonymousAdapterView.mInfo);
            }
          }
        }
        label114:
        do
        {
          do
          {
            return true;
          } while ((paramAnonymousAdapterView.mType != 2) && (paramAnonymousAdapterView.mType != 3));
          paramAnonymousView = VoiceMainView.DownStats.getTaskDownStatus(paramAnonymousAdapterView.mInfo.taskId);
        } while ((paramAnonymousView.stats != 1) && (paramAnonymousView.stats != 2) && (paramAnonymousView.stats != 0));
        VoiceMainView.this.showDeleteDialog(JarUtils.getResources().getString(1711670104), paramAnonymousAdapterView.mInfo);
        return true;
      }
    });
    this.mEnterSquareBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (VoiceMainView.this.mJumpListener != null)
        {
          if (VoiceMainView.this.isFromNavingPage)
          {
            paramAnonymousView = new Bundle();
            paramAnonymousView.putInt("root_page_type", 2);
            BNVoice.getInstance().setInternalCall(paramAnonymousView);
          }
          VoiceMainView.this.mJumpListener.onPageJump(1, 5, null);
        }
      }
    });
  }
  
  private ArrayList<VoiceItemInfo> getMyVoiceInfo()
  {
    Object localObject2;
    VoiceInfo localVoiceInfo;
    try
    {
      LogUtil.e("BNVoice", "getMyVoiceInfo");
      if (this.mhasDownInfos != null) {
        this.mhasDownInfos.clear();
      }
      if (this.mSharedInfos != null) {
        this.mSharedInfos.clear();
      }
      ArrayList localArrayList1 = VoiceDownloadController.getInstance().getDownloadVoiceTask();
      if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      {
        localObject2 = localArrayList1.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localVoiceInfo = (VoiceInfo)((Iterator)localObject2).next();
          if (!"2-201526".equals(localVoiceInfo.taskId)) {
            this.mhasDownInfos.add(new VoiceItemInfo(localVoiceInfo, 1));
          }
        }
      }
      localObject2 = VoiceDownloadController.getInstance().getSharedVoiceInfos();
    }
    finally {}
    if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localVoiceInfo = (VoiceInfo)((Iterator)localObject2).next();
        DownStats localDownStats = DownStats.getTaskDownStatus(localVoiceInfo.taskId);
        LogUtil.e("BNVoice", "getMySharedVoice info : " + localVoiceInfo.toString() + " status :" + localDownStats.stats + " progress :" + localDownStats.progress);
        if ((!((ArrayList)localObject1).contains(localVoiceInfo)) && (!localVoiceInfo.taskId.startsWith("3-")) && (!localVoiceInfo.taskId.startsWith("20-")) && (!"2-201526".equals(localVoiceInfo.taskId))) {
          if ((localDownStats.stats == 1) || (localDownStats.stats == 2) || (localDownStats.stats == 3))
          {
            localVoiceInfo.status = 3;
            this.mSharedInfos.add(new VoiceItemInfo(localVoiceInfo, 3, localDownStats.stats, localDownStats.progress));
          }
          else if (localDownStats.stats == 0)
          {
            localVoiceInfo.status = 3;
            this.mSharedInfos.add(new VoiceItemInfo(localVoiceInfo, 3, 2, localDownStats.progress));
          }
        }
      }
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(getNormalVoiceInfo());
    localArrayList2.addAll(this.mhasDownInfos);
    localArrayList2.addAll(this.mSharedInfos);
    localArrayList2.add(getSquareVoiceInfo());
    return localArrayList2;
  }
  
  private VoiceItemInfo getNormalVoiceInfo()
  {
    Object localObject = new VoiceInfo();
    ((VoiceInfo)localObject).name = JarUtils.getResources().getString(1711670105);
    ((VoiceInfo)localObject).taskId = "普通话";
    ((VoiceInfo)localObject).tag = "普通话";
    ((VoiceInfo)localObject).size = 22020096L;
    localObject = new VoiceItemInfo((VoiceInfo)localObject);
    ((VoiceItemInfo)localObject).mType = 0;
    return (VoiceItemInfo)localObject;
  }
  
  private VoiceItemInfo getSquareVoiceInfo()
  {
    Object localObject = new VoiceInfo();
    ((VoiceInfo)localObject).name = JarUtils.getResources().getString(1711670101);
    localObject = new VoiceItemInfo((VoiceInfo)localObject);
    ((VoiceItemInfo)localObject).mType = 5;
    return (VoiceItemInfo)localObject;
  }
  
  private int getUsedVoicePosition()
  {
    if ((this.mVoiceMode != 0) && (this.mUsedTaskId != null) && (this.mMyVoiceInfos != null))
    {
      int j = this.mMyVoiceInfos.size();
      int i = 0;
      while (i < j)
      {
        if (((VoiceItemInfo)this.mMyVoiceInfos.get(i)).equals(this.mUsedTaskId)) {
          return i;
        }
        i += 1;
      }
    }
    return 1;
  }
  
  private void onItemBtnClick(int paramInt)
  {
    LogUtil.e("BNVoice", "onItemBtnClick pos = " + paramInt);
    if (this.mMyVoiceAdapter == null) {}
    VoiceItemInfo localVoiceItemInfo;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localVoiceItemInfo = (VoiceItemInfo)this.mMyVoiceAdapter.getItem(paramInt);
            } while (localVoiceItemInfo == null);
            if (localVoiceItemInfo.mType != 0) {
              break;
            }
          } while (VoiceHelper.getInstance().getCurrentUsedTTSId() == null);
          switchVoiceData(null);
          return;
          if (localVoiceItemInfo.mType != 1) {
            break;
          }
          localObject = VoiceHelper.getInstance().getCurrentUsedTTSId();
        } while ((localVoiceItemInfo.mInfo.taskId == null) || (localVoiceItemInfo.mInfo.taskId.equals(localObject)));
        switchVoiceData(localVoiceItemInfo.mInfo.taskId);
        return;
      } while (((localVoiceItemInfo.mType != 2) && (localVoiceItemInfo.mType != 3)) || (localVoiceItemInfo.mInfo.taskId == null));
      localObject = DownStats.getTaskDownStatus(localVoiceItemInfo.mInfo.taskId);
      LogUtil.e("BNVoice", "onItemBtnClick download taskId = " + localVoiceItemInfo.mInfo.taskId + " status = " + ((DownStats)localObject).stats);
      if ((((DownStats)localObject).stats == 0) || (((DownStats)localObject).stats == 2))
      {
        if (this.mJumpListener != null) {
          this.mJumpListener.onVoiceUserBehaviour("voice_download");
        }
        if ("9999".equals(localVoiceItemInfo.mInfo.taskId)) {
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410350", "410350");
        }
        while (!NetworkUtils.isNetworkAvailable(this.mActivity))
        {
          TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(1711670130));
          return;
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410349", "410349");
        }
        startDownloadCheckNet(localVoiceItemInfo.mInfo.taskId);
        return;
      }
    } while (((DownStats)localObject).stats != 1);
    VoiceDownloadController.getInstance().pauseDownload(localVoiceItemInfo.mInfo.taskId);
  }
  
  private void onSquareClick()
  {
    LogUtil.e("BNVoice", "onSquareClick");
    if (!NetworkUtils.isNetworkAvailable(this.mActivity)) {
      TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(1711670130));
    }
    while (this.mJumpListener == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.mhasDownInfos != null) && (!this.mhasDownInfos.isEmpty()))
    {
      int j = this.mhasDownInfos.size();
      int i = 0;
      while (i < j)
      {
        if (((VoiceItemInfo)this.mhasDownInfos.get(i)).mInfo.taskId != null)
        {
          localStringBuilder.append(((VoiceItemInfo)this.mhasDownInfos.get(i)).mInfo.taskId);
          if (i + 1 != j) {
            localStringBuilder.append("|");
          }
        }
        i += 1;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("downIds", localStringBuilder.toString());
    BNVoice.getInstance().setInternalCall(localBundle);
    this.mJumpListener.onPageJump(1, 5, null);
  }
  
  private void showDeleteDialog(String paramString, final VoiceInfo paramVoiceInfo)
  {
    dismissDeleteDialog();
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {}
    do
    {
      return;
      if (this.mDeleteDialog == null) {
        this.mDeleteDialog = new BNDialog(this.mActivity);
      }
      this.mDeleteDialog.enableBackKey(true);
      this.mDeleteDialog.setContentMessage(paramString);
      this.mDeleteDialog.setSecondBtnText(JarUtils.getResources().getString(1711669611));
      this.mDeleteDialog.setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          if ((paramVoiceInfo.taskId != null) && (paramVoiceInfo.taskId.equals("2-129798"))) {
            BNSettingManager.setAutoDownloadJinShaTTS(false);
          }
          String str = VoiceHelper.getInstance().getCurrentUsedTTSId();
          if ((str != null) && (str.equals(paramVoiceInfo.taskId)))
          {
            TipTool.onCreateToastDialog(VoiceMainView.this.mActivity, "不能删除正在使用中的语音");
            return;
          }
          VoiceDownloadController.getInstance().removeDownload(paramVoiceInfo.taskId);
          VoiceDownloadController.getInstance().removeSharedVoieInfo(paramVoiceInfo.taskId);
          VoiceMainView.this.refreshData();
        }
      });
      this.mDeleteDialog.setFirstBtnText(JarUtils.getResources().getString(1711669612));
      this.mDeleteDialog.setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          VoiceMainView.this.dismissDeleteDialog();
        }
      });
    } while ((this.mDeleteDialog.isShowing()) || (this.mActivity == null) || (this.mActivity.isFinishing()));
    this.mDeleteDialog.show();
  }
  
  private void showWaitingLoading(String paramString)
  {
    if (this.mActivity == null) {}
    for (;;)
    {
      return;
      dismissWaitingLoading();
      try
      {
        if ((this.mWaitingLoading == null) && (this.mActivity != null)) {
          this.mWaitingLoading = new BNCommonProgressDialog(this.mActivity);
        }
        if (this.mWaitingLoading != null) {
          this.mWaitingLoading.setMessage(paramString);
        }
        if ((!this.mWaitingLoading.isShowing()) && (this.mActivity != null) && (!this.mActivity.isFinishing()))
        {
          this.mWaitingLoading.show();
          return;
        }
      }
      catch (Exception paramString) {}
    }
  }
  
  private void startDownloadCheckNet(final String paramString)
  {
    if ((!"9999".equals(paramString)) && (!"2-".equals(paramString.substring(0, 2))))
    {
      VoiceDownloadController.getInstance().startDownload(paramString);
      return;
    }
    if (NetworkUtils.isTypeNetworkAvailable(this.mActivity, 1))
    {
      VoiceDownloadController.getInstance().startDownload(paramString);
      return;
    }
    if (this.mActivity == null)
    {
      LogUtil.e("BNVoice", "startDownloadCheckNet mActivity is null");
      return;
    }
    if (this.mNetStatusDialog == null) {
      this.mNetStatusDialog = new BNDialog(this.mActivity);
    }
    while (!this.mNetStatusDialog.isShowing())
    {
      this.mNetStatusDialog.setTitleText(JarUtils.getResources().getString(1711669753));
      this.mNetStatusDialog.setContentMessage(JarUtils.getResources().getString(1711670139));
      this.mNetStatusDialog.setSecondBtnText(JarUtils.getResources().getString(1711669754));
      this.mNetStatusDialog.setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          if (!VoiceDownloadController.getInstance().startDownload(paramString)) {
            TipTool.onCreateToastDialog(VoiceMainView.this.mActivity, "已下载或正在下载");
          }
        }
      });
      this.mNetStatusDialog.setFirstBtnText(JarUtils.getResources().getString(1711669755));
      this.mNetStatusDialog.setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          VoiceMainView.DownStats localDownStats = VoiceMainView.DownStats.getTaskDownStatus(paramString);
          if ((localDownStats.stats == 0) || ((localDownStats.stats == 2) && (localDownStats.progress == 0)))
          {
            VoiceDownloadController.getInstance().removeDownload(paramString);
            VoiceDownloadController.getInstance().removeSharedVoieInfo(paramString);
            VoiceMainView.this.refreshData();
          }
        }
      });
      if ((this.mNetStatusDialog.isShowing()) || (this.mActivity == null) || (this.mActivity.isFinishing())) {
        break;
      }
      this.mNetStatusDialog.show();
      return;
    }
  }
  
  public void dismissDeleteDialog()
  {
    try
    {
      if ((this.mDeleteDialog != null) && (this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        if (this.mDeleteDialog.isShowing()) {
          this.mDeleteDialog.dismiss();
        }
        this.mDeleteDialog = null;
      }
      return;
    }
    catch (Exception localException)
    {
      this.mDeleteDialog = null;
    }
  }
  
  public void handleSwitchVoiceData(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      refreshData();
    }
    dismissWaitingLoading();
  }
  
  public void initValues(Bundle paramBundle)
  {
    Object localObject = null;
    Bundle localBundle = null;
    if (paramBundle != null)
    {
      localObject = localBundle;
      if (paramBundle.containsKey("TASK_ID")) {
        localObject = paramBundle.getString("TASK_ID");
      }
      if (2 == paramBundle.getInt("root_page_type")) {
        this.isFromNavingPage = true;
      }
    }
    else
    {
      if (this.mEnterSquareBtn != null)
      {
        if (!this.isFromNavingPage) {
          break label211;
        }
        this.mEnterSquareBtn.setVisibility(0);
      }
      label66:
      if (!BNVoice.getInstance().isExternalCall()) {
        break label223;
      }
      this.isExternalCall = true;
      localBundle = BNVoice.getInstance().getExternalCallBundle();
      paramBundle = (Bundle)localObject;
      if (localBundle != null)
      {
        paramBundle = (Bundle)localObject;
        if (!localBundle.containsKey("ypid")) {}
      }
    }
    for (paramBundle = localBundle.getString("ypid");; paramBundle = (Bundle)localObject)
    {
      LogUtil.e("BNVoice", "VoiceMainView downTaskId = " + paramBundle);
      if (paramBundle != null)
      {
        this.mSharedVoiceInfo = new VoiceItemInfo();
        this.mSharedVoiceInfo.mInfo.taskId = paramBundle;
        if ((this.mhasDownInfos == null) || (!this.mhasDownInfos.contains(this.mSharedVoiceInfo))) {
          break label233;
        }
        TipTool.onCreateToastDialog(this.mActivity, "已经下载了");
        this.mSharedVoiceInfo = null;
      }
      return;
      this.isFromNavingPage = false;
      break;
      label211:
      this.mEnterSquareBtn.setVisibility(8);
      break label66;
      label223:
      this.isExternalCall = false;
    }
    label233:
    if (VoiceDownloadStatus.getInstance().hasInTaskQueue(paramBundle))
    {
      TipTool.onCreateToastDialog(this.mActivity, "正在下载中");
      this.mSharedVoiceInfo = null;
      return;
    }
    if (VoiceDownloadController.getInstance().hasInSharedVoice(paramBundle))
    {
      downloadStatics(paramBundle);
      startDownloadCheckNet(paramBundle);
      this.mSharedVoiceInfo = null;
      return;
    }
    localObject = VoiceHelper.getInstance().getVoiceInfo(paramBundle);
    if (localObject == null)
    {
      showWaitingLoading(JarUtils.getResources().getString(1711670125));
      return;
    }
    VoiceDownloadController.getInstance().addSharedVoiceInfo((VoiceInfo)localObject);
    downloadStatics(paramBundle);
    startDownloadCheckNet(paramBundle);
    this.mSharedVoiceInfo = null;
  }
  
  public boolean onBackPressed()
  {
    if ((this.isExternalCall) && (this.mJumpListener != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("entry", "openapi");
      BNVoice.getInstance().setInternalCall(localBundle);
      this.mJumpListener.onPageJump(1, 5, null);
      if (this.mActivity != null)
      {
        this.mActivity.finish();
        return false;
      }
    }
    return super.onBackPressed();
  }
  
  protected View onInitView(Bundle paramBundle)
  {
    this.mVoiceMainView = ((ViewGroup)JarUtils.oldInflate(this.mActivity, 1711472780, null));
    if (this.mVoiceMainView == null) {
      return null;
    }
    findViews();
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410345", "410345");
    return this.mVoiceMainView;
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    BNVoice.getInstance().setExternalCall(false, null);
    this.mHeadUrl = BNVoice.getInstance().getUserHeadUrl();
    refreshData();
  }
  
  public void onSwitchVoiceNeedRestart(String paramString)
  {
    if (this.isFromNavingPage)
    {
      BNVoice.getInstance().showVoiceNextRestartWork();
      return;
    }
    BNVoice.getInstance().showVoiceReStartDialog();
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if (this.mVoiceMainView != null)
    {
      if (this.mMapMode) {
        this.mVoiceMainView.setBackgroundColor(JarUtils.getResources().getColor(1711800591));
      }
    }
    else
    {
      if ((this.mBNCommonTitleBar != null) && (!this.mMapMode)) {
        this.mBNCommonTitleBar.setLeftContenVisible(false);
      }
      if (this.mMyVoiceListview != null)
      {
        if (!this.mMapMode) {
          break label132;
        }
        this.mMyVoiceListview.setDivider(JarUtils.getResources().getDrawable(1711407213));
        this.mMyVoiceListview.setBackgroundColor(JarUtils.getResources().getColor(1711800591));
      }
    }
    for (;;)
    {
      if (this.mMyVoiceAdapter != null) {
        this.mMyVoiceAdapter.notifyDataSetChanged();
      }
      return;
      this.mVoiceMainView.setBackgroundColor(JarUtils.getResources().getColor(1711800636));
      break;
      label132:
      this.mMyVoiceListview.setDivider(new ColorDrawable(JarUtils.getResources().getColor(1711800646)));
      this.mMyVoiceListview.setDividerHeight(2);
    }
  }
  
  public void refreshData()
  {
    if ((this.mMyVoiceListview != null) && (this.mMyVoiceAdapter != null))
    {
      this.mMyVoiceAdapter.updateVoiceData();
      this.mMyVoiceAdapter.notifyDataSetChanged();
    }
  }
  
  public void switchVoiceData(String paramString)
  {
    if (this.mJumpListener != null) {
      this.mJumpListener.onVoiceUserBehaviour("voice_usage");
    }
    if (BNVoice.getInstance().switchVoice(paramString)) {
      showWaitingLoading("切换中...");
    }
  }
  
  public void updateItemView(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3) {
      TipTool.onCreateToastDialog(this.mActivity, "下载错误");
    }
    int j = -1;
    int k = j;
    int i;
    if (this.mMyVoiceInfos != null)
    {
      k = j;
      if (paramString != null)
      {
        i = 0;
        for (;;)
        {
          k = j;
          if (i >= this.mMyVoiceInfos.size()) {
            break;
          }
          if (((VoiceItemInfo)this.mMyVoiceInfos.get(i)).equals(paramString)) {
            j = i;
          }
          i += 1;
        }
      }
    }
    LogUtil.e("BNVoice", "updateItemView taskId = " + paramString + " status = " + paramInt1 + " value = " + paramInt2);
    if ((k != -1) && (this.mMyVoiceListview != null) && (this.mMyVoiceAdapter != null))
    {
      i = this.mMyVoiceListview.getFirstVisiblePosition();
      j = this.mMyVoiceListview.getLastVisiblePosition();
      LogUtil.e("BNVoice", "updateItemView111 pos = " + k + " fristVisbilePos = " + i + " lastVisiblePos = " + j);
      if ((k >= i) && (k <= j)) {
        break label236;
      }
    }
    label236:
    Object localObject;
    do
    {
      do
      {
        VoiceItemInfo localVoiceItemInfo;
        do
        {
          return;
          i = k - i;
          localObject = this.mMyVoiceListview.getChildAt(i);
          localVoiceItemInfo = (VoiceItemInfo)this.mMyVoiceAdapter.getItem(k);
          LogUtil.e("BNVoice", "updateItemView111 index = " + i + " taskId = " + localVoiceItemInfo.mInfo.taskId + " taskName = " + localVoiceItemInfo.mInfo.name);
        } while ((localVoiceItemInfo.mType != 2) && (localVoiceItemInfo.mType != 3));
        localObject = ((View)localObject).getTag();
      } while ((localObject == null) || (!(localObject instanceof MyVoiceViewHolder)));
      localObject = (MyVoiceViewHolder)localObject;
      if (paramInt1 == 2)
      {
        ((MyVoiceViewHolder)localObject).mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(1711408154));
        TipTool.onCreateToastDialog(this.mActivity, "下载暂停");
        return;
      }
      if ((paramInt1 == 1) || (paramInt1 == 8))
      {
        ((MyVoiceViewHolder)localObject).mProgressBar.setVisibility(0);
        ((MyVoiceViewHolder)localObject).mProgressBar.setProgress(paramInt2);
        ((MyVoiceViewHolder)localObject).mPercent.setVisibility(0);
        ((MyVoiceViewHolder)localObject).mPercent.setText("" + paramInt2 + "%");
        ((MyVoiceViewHolder)localObject).mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(1711408153));
        return;
      }
    } while (paramInt1 != 4);
    ((MyVoiceViewHolder)localObject).mDownCnt.setVisibility(8);
    ((MyVoiceViewHolder)localObject).mPercent.setVisibility(8);
    ((MyVoiceViewHolder)localObject).mDownBtn.setVisibility(8);
    ((MyVoiceViewHolder)localObject).mProgressBar.setVisibility(4);
    if ((this.mVoiceMode != 0) && (paramString == this.mUsedTaskId))
    {
      ((MyVoiceViewHolder)localObject).mUseBtn.setVisibility(8);
      ((MyVoiceViewHolder)localObject).mUsedText.setVisibility(0);
      return;
    }
    ((MyVoiceViewHolder)localObject).mUseBtn.setVisibility(0);
    ((MyVoiceViewHolder)localObject).mUsedText.setVisibility(8);
  }
  
  public void updateSharedVoiceInfo(boolean paramBoolean)
  {
    if (this.mSharedVoiceInfo != null)
    {
      if (!paramBoolean) {
        break label69;
      }
      VoiceInfo localVoiceInfo = VoiceHelper.getInstance().getVoiceInfo(this.mSharedVoiceInfo.mInfo.taskId);
      if (localVoiceInfo != null)
      {
        VoiceDownloadController.getInstance().addSharedVoiceInfo(localVoiceInfo);
        downloadStatics(localVoiceInfo.taskId);
        startDownloadCheckNet(localVoiceInfo.taskId);
      }
    }
    for (;;)
    {
      this.mSharedVoiceInfo = null;
      dismissWaitingLoading();
      refreshData();
      return;
      label69:
      TipTool.onCreateToastDialog(this.mActivity, "获取失败");
    }
  }
  
  public void updateUserHeadUrl(String paramString)
  {
    this.mHeadUrl = paramString;
    LogUtil.e("BNVoice", "voiceMainView updateUserHeadUrl " + paramString);
    refreshData();
  }
  
  static class DownStats
  {
    public static final int VOICE_DOWNLOAD_STATUS_DOWNING = 1;
    public static final int VOICE_DOWNLOAD_STATUS_END = 3;
    public static final int VOICE_DOWNLOAD_STATUS_PAUSE = 2;
    public static final int VOICE_DOWNLOAD_STATUS_UNSTART = 0;
    public int progress = 0;
    public int stats = 0;
    
    public static DownStats getTaskDownStatus(String paramString)
    {
      DownStats localDownStats = new DownStats();
      int j = VoiceDownloadStatus.getInstance().getDownTaskStatus(paramString);
      paramString = VoiceDownloadController.getInstance().getTaskDownStausFromEngine(paramString);
      int i = 0;
      if ((paramString.status == VoiceDataStatus.VOICE_DATA_DOWN_DOWNING) || (paramString.status == VoiceDataStatus.VOICE_DATA_DOWN_UNSTART))
      {
        int k = (int)paramString.unTotalSize;
        int m = (int)paramString.unDwonloadSize;
        if (k != 0) {
          i = (int)(m / k * 100.0D);
        }
        if (paramString.status != VoiceDataStatus.VOICE_DATA_DOWN_END) {
          break label118;
        }
        localDownStats.stats = 3;
        localDownStats.progress = 100;
      }
      label118:
      do
      {
        do
        {
          return localDownStats;
          if (paramString.status != VoiceDataStatus.VOICE_DATA_DOWN_END) {
            break;
          }
          i = 100;
          break;
        } while ((paramString.status != VoiceDataStatus.VOICE_DATA_DOWN_DOWNING) && (paramString.status != VoiceDataStatus.VOICE_DATA_DOWN_UNSTART));
        if (i == 100)
        {
          localDownStats.stats = 3;
          localDownStats.progress = 100;
          return localDownStats;
        }
        if (j == 1)
        {
          localDownStats.stats = 1;
          localDownStats.progress = i;
          return localDownStats;
        }
        if (j == 2)
        {
          localDownStats.stats = 2;
          localDownStats.progress = i;
          return localDownStats;
        }
      } while (i == 0);
      localDownStats.stats = 2;
      localDownStats.progress = i;
      return localDownStats;
    }
  }
  
  private class MyClickListener
    implements View.OnClickListener
  {
    private int mPosition;
    
    public MyClickListener(int paramInt)
    {
      this.mPosition = paramInt;
    }
    
    public void onClick(View paramView)
    {
      VoiceMainView.this.onItemBtnClick(this.mPosition);
    }
  }
  
  class MyVoiceAdapter
    extends BaseAdapter
  {
    public static final int ITEM_CATEGORY = 0;
    public static final int ITEM_DETAIL = 1;
    public static final int ITEM_MAX_COUNT = 3;
    public static final int ITEM_SQUARE = 2;
    private int mUsedPositon = 0;
    
    public MyVoiceAdapter()
    {
      updateVoiceData();
    }
    
    public int getCount()
    {
      if (VoiceMainView.this.mMyVoiceInfos != null) {
        return VoiceMainView.this.mMyVoiceInfos.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((VoiceMainView.this.mMyVoiceInfos != null) && (VoiceMainView.this.mMyVoiceInfos.size() > paramInt)) {
        return VoiceMainView.this.mMyVoiceInfos.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      VoiceMainView.VoiceItemInfo localVoiceItemInfo = (VoiceMainView.VoiceItemInfo)getItem(paramInt);
      if ((localVoiceItemInfo == null) || (localVoiceItemInfo.mType == 4)) {
        return 0;
      }
      if (localVoiceItemInfo.mType == 5) {
        return 2;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      VoiceMainView.VoiceItemInfo localVoiceItemInfo = (VoiceMainView.VoiceItemInfo)getItem(paramInt);
      if (localVoiceItemInfo == null) {
        return paramView;
      }
      int i = getItemViewType(paramInt);
      View localView2 = null;
      View localView1 = null;
      Object localObject3 = null;
      Object localObject4;
      Object localObject1;
      Object localObject2;
      if (paramView == null) {
        if (i == 0)
        {
          localView1 = JarUtils.inflate(VoiceMainView.this.mActivity, 1711472778, null);
          localObject4 = new VoiceMainView.MyVoiceCategoryHolder(VoiceMainView.this);
          paramViewGroup = (ViewGroup)localObject4;
          localObject1 = localObject3;
          localObject2 = localView2;
          paramView = localView1;
          if (localView1 != null)
          {
            ((VoiceMainView.MyVoiceCategoryHolder)localObject4).mTitle = ((TextView)localView1.findViewById(1711867276));
            localView1.setTag(localObject4);
            paramView = localView1;
            localObject2 = localView2;
            localObject1 = localObject3;
            paramViewGroup = (ViewGroup)localObject4;
          }
          if (i != 0) {
            break label684;
          }
          paramViewGroup.mTitle.setText(localVoiceItemInfo.mInfo.name);
          if (!VoiceMainView.this.mMapMode) {
            break label651;
          }
          paramViewGroup.mTitle.setTextColor(JarUtils.getResources().getColor(1711800602));
          paramViewGroup.mTitle.setBackgroundColor(JarUtils.getResources().getColor(1711800600));
        }
      }
      for (;;)
      {
        return paramView;
        if (i == 2)
        {
          localObject4 = JarUtils.inflate(VoiceMainView.this.mActivity, 1711472782, null);
          paramViewGroup = localView1;
          localObject1 = localObject3;
          localObject2 = localView2;
          paramView = (View)localObject4;
          if (localObject4 == null) {
            break;
          }
          localObject1 = new VoiceMainView.MyVoiceSquareHolder(VoiceMainView.this);
          ((VoiceMainView.MyVoiceSquareHolder)localObject1).mTitle = ((TextView)((View)localObject4).findViewById(1711867310));
          ((VoiceMainView.MyVoiceSquareHolder)localObject1).mDivider1 = ((View)localObject4).findViewById(1711867309);
          ((VoiceMainView.MyVoiceSquareHolder)localObject1).mDivider2 = ((View)localObject4).findViewById(1711867311);
          ((VoiceMainView.MyVoiceSquareHolder)localObject1).mTitle.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              VoiceMainView.this.onSquareClick();
            }
          });
          ((View)localObject4).setTag(localObject1);
          paramViewGroup = localView1;
          localObject2 = localView2;
          paramView = (View)localObject4;
          break;
        }
        localView2 = JarUtils.inflate(VoiceMainView.this.mActivity, 1711472781, null);
        localObject4 = new VoiceMainView.MyVoiceViewHolder(VoiceMainView.this);
        paramViewGroup = localView1;
        localObject1 = localObject3;
        localObject2 = localObject4;
        paramView = localView2;
        if (localView2 == null) {
          break;
        }
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mHeadView = ((ImageView)localView2.findViewById(1711867299));
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mTitle = ((TextView)localView2.findViewById(1711867301));
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mSize = ((TextView)localView2.findViewById(1711867303));
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mDownCnt = ((TextView)localView2.findViewById(1711867304));
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mProgressBar = ((ProgressBar)localView2.findViewById(1711867302));
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mUsedText = ((TextView)localView2.findViewById(1711867305));
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mUseBtn = ((Button)localView2.findViewById(1711867306));
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mDownBtn = ((ImageView)localView2.findViewById(1711867307));
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mPercent = ((TextView)localView2.findViewById(1711867308));
        paramView = new VoiceMainView.MyClickListener(VoiceMainView.this, paramInt);
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mUseBtn.setOnClickListener(paramView);
        ((VoiceMainView.MyVoiceViewHolder)localObject4).mDownBtn.setOnClickListener(paramView);
        localView2.setTag(localObject4);
        paramViewGroup = localView1;
        localObject1 = localObject3;
        localObject2 = localObject4;
        paramView = localView2;
        break;
        if (i == 0)
        {
          paramViewGroup = (VoiceMainView.MyVoiceCategoryHolder)paramView.getTag();
          localObject1 = localObject3;
          localObject2 = localView2;
          break;
        }
        if (i == 2)
        {
          localObject1 = (VoiceMainView.MyVoiceSquareHolder)paramView.getTag();
          paramViewGroup = localView1;
          localObject2 = localView2;
          break;
        }
        localObject2 = (VoiceMainView.MyVoiceViewHolder)paramView.getTag();
        paramViewGroup = new VoiceMainView.MyClickListener(VoiceMainView.this, paramInt);
        ((VoiceMainView.MyVoiceViewHolder)localObject2).mUseBtn.setOnClickListener(paramViewGroup);
        ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownBtn.setOnClickListener(paramViewGroup);
        paramViewGroup = localView1;
        localObject1 = localObject3;
        break;
        label651:
        paramViewGroup.mTitle.setTextColor(JarUtils.getResources().getColor(1711800641));
        paramViewGroup.mTitle.setBackgroundColor(JarUtils.getResources().getColor(1711800642));
        continue;
        label684:
        if (i == 2)
        {
          ((VoiceMainView.MyVoiceSquareHolder)localObject1).mTitle.setTextColor(JarUtils.getResources().getColor(1711800604));
          ((VoiceMainView.MyVoiceSquareHolder)localObject1).mTitle.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711408056));
          ((VoiceMainView.MyVoiceSquareHolder)localObject1).mDivider1.setBackgroundColor(JarUtils.getResources().getColor(1711800600));
          ((VoiceMainView.MyVoiceSquareHolder)localObject1).mDivider2.setBackgroundColor(JarUtils.getResources().getColor(1711800600));
        }
        else
        {
          if (localVoiceItemInfo.mType == 0)
          {
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mHeadView.setImageDrawable(JarUtils.getResources().getDrawable(1711408157));
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mTitle.setText(localVoiceItemInfo.mInfo.name);
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mSize.setText(JarUtils.getResources().getString(1711670127));
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownCnt.setVisibility(8);
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setVisibility(4);
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownBtn.setVisibility(8);
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mPercent.setVisibility(8);
            if ((VoiceMainView.this.mVoiceMode == 0) || ("2-201526".equals(VoiceMainView.this.mUsedTaskId)))
            {
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mUseBtn.setVisibility(8);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mUsedText.setVisibility(0);
            }
          }
          for (;;)
          {
            if (!VoiceMainView.this.mMapMode) {
              break label1600;
            }
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mTitle.setTextColor(JarUtils.getResources().getColor(1711800604));
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mSize.setTextColor(JarUtils.getResources().getColor(1711800606));
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownCnt.setTextColor(JarUtils.getResources().getColor(1711800602));
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setProgressDrawable(JarUtils.getResources().getDrawable(1711408055));
            paramView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711408056));
            break;
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mUseBtn.setVisibility(0);
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mUsedText.setVisibility(8);
            continue;
            if ((!TextUtils.isEmpty(localVoiceItemInfo.mInfo.imageUrl)) && (!localVoiceItemInfo.mInfo.imageUrl.trim().equals("url"))) {
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mHeadView.setImageDrawable(UrlDrawable.getDrawable(localVoiceItemInfo.mInfo.imageUrl.trim()));
            }
            for (;;)
            {
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mTitle.setText(localVoiceItemInfo.mInfo.name);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mSize.setText(VoiceHelper.getInstance().getVoiceShowSize(localVoiceItemInfo.mInfo.size));
              if (localVoiceItemInfo.mType != 1) {
                break label1267;
              }
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownCnt.setVisibility(8);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mPercent.setVisibility(8);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownBtn.setVisibility(8);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setVisibility(4);
              if ((VoiceMainView.this.mVoiceMode == 0) || (paramInt != this.mUsedPositon)) {
                break label1245;
              }
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mUseBtn.setVisibility(8);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mUsedText.setVisibility(0);
              break;
              if (VoiceMainView.this.mHeadUrl != null) {
                ((VoiceMainView.MyVoiceViewHolder)localObject2).mHeadView.setImageDrawable(UrlDrawable.getDrawable(VoiceMainView.this.mHeadUrl.trim()));
              } else {
                ((VoiceMainView.MyVoiceViewHolder)localObject2).mHeadView.setImageDrawable(JarUtils.getResources().getDrawable(1711408146));
              }
            }
            label1245:
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mUseBtn.setVisibility(0);
            ((VoiceMainView.MyVoiceViewHolder)localObject2).mUsedText.setVisibility(8);
            continue;
            label1267:
            if ((localVoiceItemInfo.mType == 2) || (localVoiceItemInfo.mType == 3))
            {
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownCnt.setVisibility(0);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownBtn.setVisibility(0);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mUseBtn.setVisibility(8);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mUsedText.setVisibility(8);
              ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownCnt.setText(VoiceHelper.getInstance().getVoiceShowDownCnt(localVoiceItemInfo.mInfo.downloadCnt));
              if (localVoiceItemInfo.mInfo.taskId != null) {
                if ((localVoiceItemInfo.mStatus == 1) || (localVoiceItemInfo.mStatus == 3))
                {
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setVisibility(0);
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setProgress(localVoiceItemInfo.mProgress);
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(1711408153));
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mPercent.setVisibility(0);
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mPercent.setText("" + localVoiceItemInfo.mProgress + "%");
                }
                else if (localVoiceItemInfo.mStatus == 2)
                {
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setVisibility(0);
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setProgress(localVoiceItemInfo.mProgress);
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(1711408154));
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mPercent.setVisibility(0);
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mPercent.setText("" + localVoiceItemInfo.mProgress + "%");
                }
                else
                {
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setVisibility(4);
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(1711408155));
                  ((VoiceMainView.MyVoiceViewHolder)localObject2).mPercent.setVisibility(8);
                }
              }
            }
          }
          label1600:
          ((VoiceMainView.MyVoiceViewHolder)localObject2).mTitle.setTextColor(JarUtils.getResources().getColor(1711800639));
          ((VoiceMainView.MyVoiceViewHolder)localObject2).mSize.setTextColor(JarUtils.getResources().getColor(1711800640));
          ((VoiceMainView.MyVoiceViewHolder)localObject2).mDownCnt.setTextColor(JarUtils.getResources().getColor(1711800640));
          ((VoiceMainView.MyVoiceViewHolder)localObject2).mUsedText.setTextColor(JarUtils.getResources().getColor(1711800643));
          ((VoiceMainView.MyVoiceViewHolder)localObject2).mProgressBar.setProgressDrawable(JarUtils.getResources().getDrawable(1711408055));
          paramView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407356));
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
    
    public void updateVoiceData()
    {
      VoiceMainView.access$302(VoiceMainView.this, BNSettingManager.getVoicePersonality());
      VoiceMainView.access$402(VoiceMainView.this, VoiceHelper.getInstance().getCurrentUsedTTSId());
      if (VoiceMainView.this.mMyVoiceInfos != null)
      {
        VoiceMainView.this.mMyVoiceInfos.clear();
        VoiceMainView.this.mMyVoiceInfos.addAll(VoiceMainView.this.getMyVoiceInfo());
      }
      for (;;)
      {
        this.mUsedPositon = VoiceMainView.this.getUsedVoicePosition();
        if ("2-201526".equals(VoiceMainView.this.mUsedTaskId)) {
          this.mUsedPositon = 0;
        }
        LogUtil.e("BNVoice", "getUsedVoice mVoiceMode = " + VoiceMainView.this.mVoiceMode + " mUsedTaskId = " + VoiceMainView.this.mUsedTaskId + " mUsedPositon = " + this.mUsedPositon);
        return;
        VoiceMainView.access$502(VoiceMainView.this, VoiceMainView.this.getMyVoiceInfo());
      }
    }
  }
  
  class MyVoiceCategoryHolder
  {
    TextView mTitle;
    
    MyVoiceCategoryHolder() {}
  }
  
  class MyVoiceSquareHolder
  {
    View mDivider1;
    View mDivider2;
    TextView mTitle;
    
    MyVoiceSquareHolder() {}
  }
  
  class MyVoiceViewHolder
  {
    ImageView mDownBtn;
    TextView mDownCnt;
    ImageView mHeadView;
    TextView mPercent;
    ProgressBar mProgressBar;
    TextView mSize;
    TextView mTitle;
    Button mUseBtn;
    TextView mUsedText;
    
    MyVoiceViewHolder() {}
  }
  
  private class VoiceItemInfo
  {
    public static final int VOICE_ITEM_TYPE_CATEGORY = 4;
    public static final int VOICE_ITEM_TYPE_DOWNLOAD = 1;
    public static final int VOICE_ITEM_TYPE_INVALID = -1;
    public static final int VOICE_ITEM_TYPE_NORMAL = 0;
    public static final int VOICE_ITEM_TYPE_RECOMMEND = 2;
    public static final int VOICE_ITEM_TYPE_SHARED = 3;
    public static final int VOICE_ITEM_TYPE_SQUARE = 5;
    VoiceInfo mInfo;
    int mProgress;
    int mStatus;
    int mType;
    
    VoiceItemInfo()
    {
      this.mInfo = new VoiceInfo();
      this.mType = -1;
      this.mProgress = 0;
      this.mStatus = 0;
    }
    
    VoiceItemInfo(VoiceInfo paramVoiceInfo)
    {
      this.mInfo = paramVoiceInfo;
      this.mType = -1;
      this.mProgress = 0;
      this.mStatus = 0;
    }
    
    VoiceItemInfo(VoiceInfo paramVoiceInfo, int paramInt)
    {
      this.mInfo = paramVoiceInfo;
      this.mType = paramInt;
      this.mProgress = 0;
      this.mStatus = 0;
    }
    
    VoiceItemInfo(VoiceInfo paramVoiceInfo, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mInfo = paramVoiceInfo;
      this.mType = paramInt1;
      this.mStatus = paramInt2;
      this.mProgress = paramInt3;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof VoiceInfo))) {
        return this.mInfo.equals((VoiceInfo)paramObject);
      }
      if ((paramObject != null) && ((paramObject instanceof VoiceItemInfo))) {
        return this.mInfo.equals(((VoiceItemInfo)paramObject).mInfo);
      }
      if ((paramObject != null) && ((paramObject instanceof String))) {
        return this.mInfo.equals((String)paramObject);
      }
      return super.equals(paramObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/view/VoiceMainView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */