package com.baidu.navisdk.ui.voice.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.util.EventDelayUtil;
import com.baidu.navisdk.ui.util.EventDelayUtil.EventDelayListener;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice.OnVoicePageJumpListener;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadController;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceSquareView
  extends VoiceBaseView
{
  private static final int ERRNO_SUCCESS = 0;
  private static final int ERRNO_SYSTEM_ERRO = 1;
  private static final int PAGE_TYPE_DETAIL = 2;
  private static final int PAGE_TYPE_SQUARE = 0;
  private static final int PAGE_TYPE_TOPIC = 1;
  private boolean isFromNavingPage;
  private String mActionParam = null;
  private boolean mBtnShareClicked;
  private View mClickableFalseLayout;
  private int mCurrentWebPage = 0;
  private EventDelayUtil.EventDelayListener mDelayListener = new EventDelayUtil.EventDelayListener()
  {
    public void onStart(int paramAnonymousInt, Object... paramAnonymousVarArgs)
    {
      boolean bool = true;
      LogUtil.e("BNVoice", "onStart key: " + paramAnonymousInt);
      Object localObject;
      if ((paramAnonymousInt == 1) || (paramAnonymousInt == 4) || (paramAnonymousInt == 8))
      {
        localObject = (String)paramAnonymousVarArgs[0];
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 8))
        {
          paramAnonymousInt = ((Integer)paramAnonymousVarArgs[1]).intValue();
          VoiceSquareView.access$2002(VoiceSquareView.this, VoiceSquareView.this.showDownloadingList((String)localObject, paramAnonymousInt));
          if ((VoiceSquareView.this.mUrlLoadingWebView == null) || (VoiceSquareView.this.mDownloadingStr == null) || (VoiceSquareView.this.mDownloadingStr.length() <= 0)) {}
        }
      }
      for (;;)
      {
        try
        {
          VoiceSquareView.this.mUrlLoadingWebView.loadUrl("javascript:showDownloadingList('" + VoiceSquareView.this.mDownloadingStr + "')");
          return;
        }
        catch (Exception paramAnonymousVarArgs) {}
        paramAnonymousInt = 100;
        break;
        if (paramAnonymousInt == 2)
        {
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[0];
          VoiceSquareView.access$2102(VoiceSquareView.this, VoiceSquareView.this.setPauseStatus(paramAnonymousVarArgs));
          if ((VoiceSquareView.this.mUrlLoadingWebView == null) || (VoiceSquareView.this.mPauseStatusStr == null) || (VoiceSquareView.this.mPauseStatusStr.length() <= 0)) {
            continue;
          }
          try
          {
            VoiceSquareView.this.mUrlLoadingWebView.loadUrl("javascript:setPauseStatus('" + VoiceSquareView.this.mPauseStatusStr + "')");
            return;
          }
          catch (Exception paramAnonymousVarArgs)
          {
            return;
          }
        }
        if (paramAnonymousInt == 3)
        {
          VoiceSquareView.this.showDownloadList();
          return;
        }
        if (paramAnonymousInt == 6)
        {
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = VoiceHelper.getInstance().getVoiceInfo(paramAnonymousVarArgs);
          localObject = new StringBuilder().append("realData is null?");
          if (paramAnonymousVarArgs == null) {}
          for (;;)
          {
            LogUtil.e("BNVoice", bool);
            if (paramAnonymousVarArgs == null) {
              break;
            }
            VoiceSquareView.this.showDownloadList();
            return;
            bool = false;
          }
        }
      }
    }
  };
  private String mDownloadingStr = null;
  private ArrayList<VoiceInfo> mDownsInfos = new ArrayList();
  private EventDelayUtil mEventDelayUtil = null;
  private ArrayList<VoiceInfo> mHasDownloadInfos = new ArrayList();
  private View mLoadingFailLayout;
  private View mLoadingSuccessLayout;
  private int mLocalVoiceSize = 0;
  boolean mMapMode = BNSettingManager.isUsingMapMode();
  private BNDialog mNetStatusDialog = null;
  private String mPauseStatusStr = null;
  private ProgressBar mProgressBar;
  private ArrayList<VoiceInfo> mRecommendInfos = new ArrayList();
  private ArrayList<VoiceInfo> mSharedInfos = new ArrayList();
  private String mStartStatusStr = null;
  private String mTaskId = null;
  private BNWorkerNormalTask<String, String> mTimeOutMonitorTask = new BNWorkerNormalTask("mTimeOutMonitorTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      if (VoiceSquareView.this.mWebView != null) {
        VoiceSquareView.this.mWebView.stopLoading();
      }
      VoiceSquareView.this.showLoadingFailView();
      return null;
    }
  };
  private BNCommonTitleBar mTitleBar;
  private String mTopicShareParam = null;
  private String mUrl = null;
  private WebView mUrlLoadingWebView;
  private ViewGroup mVoiceSquareView;
  private LinkedList<String> mWaitingInfos = new LinkedList();
  private BNCommonProgressDialog mWaitingLoading = null;
  private WebView mWebView;
  private String mYPID = null;
  
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
  
  @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
  private void findViews()
  {
    if (this.mVoiceSquareView == null) {
      return;
    }
    this.mLoadingSuccessLayout = ((RelativeLayout)this.mVoiceSquareView.findViewById(1711867313));
    this.mLoadingFailLayout = this.mVoiceSquareView.findViewById(1711867293);
    this.mClickableFalseLayout = ((RelativeLayout)this.mVoiceSquareView.findViewById(1711867316));
    this.mClickableFalseLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (NetworkUtils.isNetworkAvailable(VoiceSquareView.this.mActivity))
        {
          VoiceSquareView.this.setWebViewClickableTrue();
          return;
        }
        TipTool.onCreateToastDialog(VoiceSquareView.this.mActivity, JarUtils.getResources().getString(1711670130));
      }
    });
    hideLoadingFailView();
    this.mLoadingFailLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (NetworkUtils.isNetworkAvailable(VoiceSquareView.this.mActivity))
        {
          if (VoiceSquareView.this.mLoadingFailLayout.getVisibility() == 0) {
            if (VoiceSquareView.this.mWebView != null)
            {
              if (VoiceSquareView.this.mWebView.getUrl() != null) {
                break label122;
              }
              VoiceSquareView.this.mWebView.loadUrl(VoiceSquareView.this.mUrl);
            }
          }
          for (;;)
          {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("findViews-" + getClass().getSimpleName(), null)new BNWorkerConfig
            {
              protected String execute()
              {
                VoiceSquareView.this.hideLoadingFailView();
                return null;
              }
            }, new BNWorkerConfig(100, 0), 1000L);
            return;
            label122:
            VoiceSquareView.this.mWebView.reload();
          }
        }
        TipTool.onCreateToastDialog(VoiceSquareView.this.mActivity, JarUtils.getResources().getString(1711670130));
      }
    });
    this.mTitleBar = ((BNCommonTitleBar)this.mVoiceSquareView.findViewById(1711867312));
    this.mTitleBar.setMiddleTextSize(18.0F);
    this.mTitleBar.setLeftOnClickedListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (VoiceSquareView.this.mJumpListener != null) {
          VoiceSquareView.this.mJumpListener.onBack(null);
        }
      }
    });
    updateRightMenu();
    this.mProgressBar = ((ProgressBar)this.mVoiceSquareView.findViewById(1711867315));
    this.mWebView = ((WebView)this.mVoiceSquareView.findViewById(1711867314));
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.getSettings().setBuiltInZoomControls(true);
    this.mWebView.getSettings().setLoadWithOverviewMode(true);
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setCacheMode(-1);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setLoadsImagesAutomatically(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setUserAgentString("baidumap_ANDR");
    this.mWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (!NetworkUtils.isNetworkAvailable(VoiceSquareView.this.mActivity)) {
          VoiceSquareView.this.showLoadingFailView();
        }
        BNWorkerCenter.getInstance().cancelTask(VoiceSquareView.this.mTimeOutMonitorTask, false);
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        BNWorkerCenter.getInstance().cancelTask(VoiceSquareView.this.mTimeOutMonitorTask, false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(VoiceSquareView.this.mTimeOutMonitorTask, new BNWorkerConfig(4, 0), 15000L);
        VoiceSquareView.this.updateRightMenu();
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        BNWorkerCenter.getInstance().cancelTask(VoiceSquareView.this.mTimeOutMonitorTask, false);
        VoiceSquareView.this.showLoadingFailView();
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      }
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        VoiceSquareView.access$602(VoiceSquareView.this, paramAnonymousWebView);
        if ((paramAnonymousString != null) && (paramAnonymousString.contains("bdnavi://check"))) {
          VoiceSquareView.this.showDownloadList();
        }
        for (;;)
        {
          return true;
          if ((paramAnonymousString != null) && (paramAnonymousString.contains("bdnavi://start")))
          {
            VoiceSquareView.access$802(VoiceSquareView.this, VoiceSquareView.this.getURLParam(paramAnonymousString, "actionParam"));
            VoiceSquareView.access$1002(VoiceSquareView.this, VoiceSquareView.this.getActionParamID(VoiceSquareView.this.mActionParam));
            paramAnonymousWebView = new VoiceInfo();
            paramAnonymousWebView.taskId = VoiceSquareView.this.mTaskId;
            VoiceSquareView.access$1202(VoiceSquareView.this, VoiceDownloadController.getInstance().getDownloadVoiceTask());
            VoiceSquareView.this.downloadStatics(VoiceSquareView.this.mTaskId);
            if ((VoiceSquareView.this.mHasDownloadInfos != null) && (VoiceSquareView.this.mHasDownloadInfos.contains(paramAnonymousWebView))) {
              TipTool.onCreateToastDialog(VoiceSquareView.this.mActivity, "已经下载了");
            } else if (!VoiceDownloadStatus.getInstance().hasInTaskQueue(VoiceSquareView.this.mTaskId)) {
              if (VoiceDownloadController.getInstance().hasInSharedVoice(VoiceSquareView.this.mTaskId))
              {
                VoiceSquareView.this.startDownloadCheckNet(VoiceSquareView.this.mTaskId);
              }
              else
              {
                paramAnonymousWebView = VoiceHelper.getInstance().getVoiceInfo(VoiceSquareView.this.mTaskId);
                if (paramAnonymousWebView == null)
                {
                  VoiceSquareView.this.showWaitingLoading(JarUtils.getResources().getString(1711670125));
                }
                else
                {
                  VoiceDownloadController.getInstance().addSharedVoiceInfo(paramAnonymousWebView);
                  VoiceSquareView.this.startDownloadCheckNet(VoiceSquareView.this.mTaskId);
                }
              }
            }
          }
          else if ((paramAnonymousString != null) && (paramAnonymousString.contains("bdnavi://pause")))
          {
            VoiceSquareView.access$802(VoiceSquareView.this, VoiceSquareView.this.getURLParam(paramAnonymousString, "actionParam"));
            VoiceSquareView.access$1002(VoiceSquareView.this, VoiceSquareView.this.getActionParamID(VoiceSquareView.this.mActionParam));
            if (VoiceSquareView.this.mTaskId != null) {
              VoiceDownloadController.getInstance().pauseDownload(VoiceSquareView.this.mTaskId);
            }
          }
          else if ((paramAnonymousString != null) && (paramAnonymousString.contains("bdnavi://passTopicInfo")))
          {
            VoiceSquareView.access$1502(VoiceSquareView.this, VoiceSquareView.this.getURLParam(paramAnonymousString, "actionParam"));
          }
          else if ((paramAnonymousString != null) && (paramAnonymousString.contains("bdnavi://getdataerr")))
          {
            VoiceSquareView.this.showLoadingFailView();
          }
          else
          {
            if (VoiceSquareView.this.mUrlLoadingWebView != null) {
              VoiceSquareView.this.mUrlLoadingWebView.loadUrl(paramAnonymousString);
            }
            if ((paramAnonymousString != null) && (paramAnonymousString.contains("ypid")))
            {
              VoiceSquareView.access$1602(VoiceSquareView.this, 2);
              VoiceSquareView.access$1702(VoiceSquareView.this, VoiceSquareView.this.getURLParam(paramAnonymousString, "ypid"));
            }
          }
        }
      }
    });
    this.mWebView.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 100) {
          VoiceSquareView.this.mProgressBar.setVisibility(8);
        }
        for (;;)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          return;
          if (VoiceSquareView.this.mProgressBar.getVisibility() == 8) {
            VoiceSquareView.this.mProgressBar.setVisibility(0);
          }
          VoiceSquareView.this.mProgressBar.setProgress(paramAnonymousInt);
        }
      }
    });
  }
  
  private String getActionParamID(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      localObject1 = new JSONObject(paramString).get("id").toString();
      return (String)localObject1;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  private String getSquareVoiceInfo()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    JSONArray localJSONArray3 = new JSONArray();
    JSONArray localJSONArray4 = new JSONArray();
    this.mDownsInfos = VoiceDownloadController.getInstance().getDownloadVoiceTask();
    Iterator localIterator;
    Object localObject2;
    if ((this.mDownsInfos != null) && (this.mDownsInfos.size() > 0))
    {
      localIterator = this.mDownsInfos.iterator();
      while (localIterator.hasNext())
      {
        VoiceInfo localVoiceInfo1 = (VoiceInfo)localIterator.next();
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("id", localVoiceInfo1.taskId);
          localJSONArray1.put(localObject2);
        }
        catch (JSONException localJSONException3) {}
      }
    }
    label343:
    Object localObject1;
    try
    {
      this.mRecommendInfos = VoiceDownloadController.getInstance().getRecommendVoiceTask();
      if ((this.mRecommendInfos != null) && (this.mRecommendInfos.size() > 0))
      {
        localIterator = this.mRecommendInfos.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label343;
          }
          VoiceInfo localVoiceInfo2 = (VoiceInfo)localIterator.next();
          localObject2 = VoiceMainView.DownStats.getTaskDownStatus(localVoiceInfo2.taskId);
          if (((VoiceMainView.DownStats)localObject2).stats != 1) {
            break;
          }
          try
          {
            localJSONObject3 = new JSONObject();
            localJSONObject3.put("id", localVoiceInfo2.taskId);
            localJSONObject3.put("progress", ((VoiceMainView.DownStats)localObject2).progress);
            localJSONArray2.put(localJSONObject3);
          }
          catch (JSONException localJSONException4) {}
        }
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      JSONObject localJSONObject3;
      for (;;)
      {
        LogUtil.e("BNVoice", "getRecommendVoiceTask");
        continue;
        if (((VoiceMainView.DownStats)localObject2).stats == 2) {
          try
          {
            localJSONObject3 = new JSONObject();
            localJSONObject3.put("id", localJSONException4.taskId);
            localJSONObject3.put("progress", ((VoiceMainView.DownStats)localObject2).progress);
            localJSONArray3.put(localJSONObject3);
          }
          catch (JSONException localJSONException5) {}
        }
      }
      this.mSharedInfos = VoiceDownloadController.getInstance().getSharedVoiceInfos();
      if ((this.mSharedInfos != null) && (this.mSharedInfos.size() > 0))
      {
        localObject1 = this.mSharedInfos.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          VoiceInfo localVoiceInfo3 = (VoiceInfo)((Iterator)localObject1).next();
          localObject2 = VoiceMainView.DownStats.getTaskDownStatus(localVoiceInfo3.taskId);
          if ((((VoiceMainView.DownStats)localObject2).stats == 1) || (((VoiceMainView.DownStats)localObject2).stats == 3)) {
            try
            {
              localJSONObject3 = new JSONObject();
              localJSONObject3.put("id", localVoiceInfo3.taskId);
              localJSONObject3.put("progress", ((VoiceMainView.DownStats)localObject2).progress);
              localJSONArray2.put(localJSONObject3);
            }
            catch (JSONException localJSONException6) {}
          } else if (((VoiceMainView.DownStats)localObject2).stats == 2) {
            try
            {
              localJSONObject3 = new JSONObject();
              localJSONObject3.put("id", localJSONException6.taskId);
              localJSONObject3.put("progress", ((VoiceMainView.DownStats)localObject2).progress);
              localJSONArray3.put(localJSONObject3);
            }
            catch (JSONException localJSONException7) {}
          }
        }
      }
      this.mWaitingInfos = VoiceDownloadStatus.getInstance().getTaskQueue();
      localObject1 = this.mWaitingInfos.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("id", str);
          ((JSONObject)localObject2).put("progress", 0);
          localJSONArray2.put(localObject2);
        }
        catch (JSONException localJSONException8) {}
      }
      localObject1 = VoiceHelper.getInstance().getCurrentUsedTTSId();
      if (localObject1 == null) {}
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("id", localObject1);
      localJSONArray4.put(localJSONObject2);
      try
      {
        localJSONObject1.put("downloadedList", localJSONArray1);
        localJSONObject1.put("downloadingList", localJSONArray2);
        localJSONObject1.put("downloadPauseList", localJSONArray3);
        localJSONObject1.put("usingList", localJSONArray4);
        return localJSONObject1.toString();
      }
      catch (JSONException localJSONException1)
      {
        for (;;) {}
      }
    }
    catch (JSONException localJSONException2)
    {
      for (;;) {}
    }
  }
  
  private String getURLParam(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = URLDecoder.decode(paramString1, "UTF-8");
      String[] arrayOfString = new String[50];
      if (paramString1.indexOf(paramString2) != -1)
      {
        paramString1 = paramString1.substring(paramString1.indexOf(paramString2)).split("&")[0].split("=", 2);
        if ((paramString1 != null) && (paramString1.length >= 2))
        {
          paramString1 = paramString1[1];
          return paramString1;
        }
      }
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  private void hideLoadingFailView()
  {
    if (this.mLoadingFailLayout != null) {
      this.mLoadingFailLayout.setVisibility(8);
    }
    if (this.mLoadingSuccessLayout != null) {
      this.mLoadingSuccessLayout.setVisibility(0);
    }
  }
  
  private String setPauseStatus(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramString != null) && (paramString.length() > 0)) {}
    try
    {
      localJSONObject.put("errno", 0);
      localJSONObject.put("id", paramString);
      return localJSONObject.toString();
      try
      {
        localJSONObject.put("errno", 1);
        localJSONObject.put("id", paramString);
        return localJSONObject.toString();
      }
      catch (JSONException paramString)
      {
        for (;;) {}
      }
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
  
  private String setStartStatus(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((NetworkUtils.isNetworkAvailable(this.mActivity)) && (paramString != null) && (paramString.length() > 0)) {}
    try
    {
      localJSONObject.put("errno", 0);
      localJSONObject.put("id", paramString);
      return localJSONObject.toString();
      try
      {
        localJSONObject.put("errno", 1);
        localJSONObject.put("id", paramString);
        return localJSONObject.toString();
      }
      catch (JSONException paramString)
      {
        for (;;) {}
      }
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
  
  private void showDownloadList()
  {
    String str = getSquareVoiceInfo();
    LogUtil.e("BNVoice", "downloadListStr:" + str);
    if ((this.mUrlLoadingWebView != null) && (str != null) && (str.length() > 0)) {}
    try
    {
      LogUtil.e("BNVoice", "loadUrl");
      this.mUrlLoadingWebView.loadUrl("javascript:showDownloadList('" + str + "')");
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("BNVoice", "showDownloadList Exception:" + localException.getMessage());
    }
  }
  
  private void showLoadingFailView()
  {
    if (this.mLoadingFailLayout != null) {
      this.mLoadingFailLayout.setVisibility(0);
    }
    if (this.mLoadingSuccessLayout != null) {
      this.mLoadingSuccessLayout.setVisibility(8);
    }
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
          VoiceDownloadController.getInstance().startDownload(paramString);
        }
      });
      this.mNetStatusDialog.setFirstBtnText(JarUtils.getResources().getString(1711669755));
      this.mNetStatusDialog.setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          VoiceSquareView.this.mNetStatusDialog.dismiss();
          VoiceMainView.DownStats localDownStats = VoiceMainView.DownStats.getTaskDownStatus(paramString);
          if ((localDownStats.stats == 0) || ((localDownStats.stats == 2) && (localDownStats.progress == 0)))
          {
            VoiceDownloadController.getInstance().removeDownload(paramString);
            VoiceDownloadController.getInstance().removeSharedVoieInfo(paramString);
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
  
  private void stopWebVoice()
  {
    if (this.mUrlLoadingWebView != null) {
      this.mUrlLoadingWebView.loadUrl("javascript:stopListen()");
    }
  }
  
  private void updateRightMenu()
  {
    if (this.mTitleBar == null) {
      return;
    }
    if (this.isFromNavingPage)
    {
      this.mTitleBar.setRightIconVisible(false);
      this.mTitleBar.setRightTextVisible(false);
      return;
    }
    if ((this.mCurrentWebPage == 2) || (this.mCurrentWebPage == 1)) {
      if (BNaviModuleManager.isGooglePlayChannel())
      {
        this.mTitleBar.setRightIconVisible(false);
        this.mTitleBar.setRightTextVisible(false);
        if ((!BNaviModuleManager.isGooglePlayChannel()) || ((this.mCurrentWebPage != 2) && (this.mCurrentWebPage != 1))) {
          break label200;
        }
        this.mTitleBar.setRightTextVisible(false);
        this.mTitleBar.setRightIconVisible(false);
      }
    }
    for (;;)
    {
      if (((this.mCurrentWebPage != 2) && (this.mCurrentWebPage != 1)) || (BNaviModuleManager.isGooglePlayChannel())) {
        break label211;
      }
      this.mTitleBar.setRightOnClickedListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick()) {
            return;
          }
          if (VoiceSquareView.this.mJumpListener != null) {
            VoiceSquareView.this.mJumpListener.onVoiceUserBehaviour("voice_share");
          }
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410356", "410356");
          if (!NetworkUtils.isNetworkAvailable(VoiceSquareView.this.mActivity))
          {
            TipTool.onCreateToastDialog(VoiceSquareView.this.mActivity, JarUtils.getResources().getString(1711670130));
            return;
          }
          if ((VoiceSquareView.this.mCurrentWebPage == 2) && (VoiceSquareView.this.mYPID != null))
          {
            paramAnonymousView = VoiceHelper.getInstance().getVoiceInfo(VoiceSquareView.this.mYPID);
            if (paramAnonymousView != null)
            {
              VoiceHelper.getInstance().share(paramAnonymousView);
              return;
            }
            VoiceSquareView.access$2302(VoiceSquareView.this, true);
            VoiceSquareView.this.showWaitingLoading("正在获取分享信息...");
            return;
          }
          if ((VoiceSquareView.this.mCurrentWebPage == 1) && (VoiceSquareView.this.mTopicShareParam != null)) {
            try
            {
              VoiceHelper.getInstance().shareTopic(VoiceSquareView.this.mTopicShareParam);
              return;
            }
            catch (JSONException paramAnonymousView)
            {
              return;
            }
          }
          VoiceHelper.getInstance().shareFromSquare();
        }
      });
      return;
      this.mTitleBar.setRightIcon(JarUtils.getResources().getDrawable(1711408156));
      this.mTitleBar.setRightText(null);
      break;
      this.mTitleBar.setRightIcon(null);
      this.mTitleBar.setRightText(JarUtils.getResources().getString(1711670137));
      break;
      label200:
      this.mTitleBar.setRightIconVisible(true);
    }
    label211:
    this.mTitleBar.setRightOnClickedListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {}
        while (VoiceSquareView.this.mJumpListener == null) {
          return;
        }
        paramAnonymousView = new Bundle();
        VoiceSquareView.this.mJumpListener.onPageJump(5, 1, paramAnonymousView);
      }
    });
  }
  
  public void downloadStatics(String paramString)
  {
    if (this.mJumpListener != null) {
      this.mJumpListener.onVoiceUserBehaviour("voice_download");
    }
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410353", "410353");
  }
  
  public void handleSwitchVoiceData(boolean paramBoolean, String paramString)
  {
    LogUtil.e("BNVoice", "handleSwitchVoiceData success:" + paramBoolean);
    if ((paramBoolean) && (this.mEventDelayUtil != null)) {
      this.mEventDelayUtil.exec(6, 150, new Object[] { paramString });
    }
    dismissWaitingLoading();
  }
  
  public void initValues(Bundle paramBundle)
  {
    Object localObject4 = null;
    Object localObject1 = null;
    this.mStartStatusStr = null;
    this.mPauseStatusStr = null;
    this.mDownloadingStr = null;
    this.mActionParam = null;
    this.mTaskId = null;
    this.mBtnShareClicked = false;
    setWebViewClickableTrue();
    Object localObject2 = null;
    Bundle localBundle1 = BNVoice.getInstance().getCallBundle();
    paramBundle = null;
    Object localObject3 = paramBundle;
    String str;
    if (localBundle1 != null)
    {
      str = localBundle1.getString("entry");
      if (2 != localBundle1.getInt("root_page_type")) {
        break label556;
      }
      this.isFromNavingPage = true;
      Bundle localBundle2 = localBundle1.getBundle("VOICEINFO");
      localObject2 = str;
      localObject3 = paramBundle;
      if (localBundle2 != null)
      {
        localObject3 = VoiceInfo.getVoiceInfo(localBundle2);
        localObject2 = str;
      }
    }
    for (;;)
    {
      updateRightMenu();
      if (this.mUrl == null)
      {
        paramBundle = (Bundle)localObject4;
        if (localBundle1 != null)
        {
          paramBundle = (Bundle)localObject4;
          if (localBundle1.containsKey("downIds"))
          {
            paramBundle = localBundle1.getString("downIds");
            if (!TextUtils.isEmpty(paramBundle)) {
              localObject1 = "load=" + paramBundle;
            }
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {
              paramBundle = (String)localObject1 + "&";
            }
          }
        }
        if ((localObject3 == null) || (((VoiceInfo)localObject3).status != 4)) {
          break label570;
        }
        this.mUrl = (((VoiceInfo)localObject3).voiceUrl + "&from=in");
        label256:
        if ("1" != null) {
          this.mUrl = (this.mUrl + '&' + "sid=" + "1");
        }
        if ("10.1.0" != null) {
          this.mUrl = (this.mUrl + '&' + "app_version=" + "10.1.0");
        }
        if ("0" != null) {
          this.mUrl = (this.mUrl + '&' + "os=" + "0");
        }
        if (!this.isFromNavingPage) {
          break label755;
        }
        this.mUrl = (this.mUrl + '&' + "entry=" + "naving");
        label433:
        if ((this.mWebView != null) && (this.mUrl != null)) {
          LogUtil.e("BNVoice", "url = " + this.mUrl);
        }
      }
      try
      {
        this.mWebView.loadUrl(this.mUrl);
        showDownloadList();
        this.mLocalVoiceSize = 0;
        paramBundle = VoiceDownloadController.getInstance().getDownloadVoiceTask();
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          paramBundle = paramBundle.iterator();
          for (;;)
          {
            if (paramBundle.hasNext()) {
              if (((VoiceInfo)paramBundle.next()).status == 0)
              {
                this.mLocalVoiceSize += 1;
                continue;
                label556:
                this.isFromNavingPage = false;
                localObject2 = str;
                localObject3 = paramBundle;
                break;
                label570:
                if (paramBundle != null)
                {
                  LogUtil.e("BNVoice", "loadparams = " + paramBundle);
                  this.mUrl = (HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_VOICE_SQUARE) + "?" + paramBundle + "from=in");
                  break label256;
                }
                if (this.isFromNavingPage)
                {
                  localObject1 = new StringBuilder();
                  if (BNSettingManager.isUseHttpsOfflineURL()) {}
                  for (paramBundle = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_navingvoice/navingvoice/";; paramBundle = HttpURLManager.getInstance().getScheme() + "webpagenavi.baidu.com/static/webpage/voice_market_navingvoice/navingvoice/")
                  {
                    this.mUrl = (paramBundle + "?from=in");
                    break;
                  }
                }
                this.mUrl = (HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_VOICE_SQUARE) + "?from=in");
                break label256;
                label755:
                if (localObject2 != null)
                {
                  this.mUrl = (this.mUrl + '&' + "entry=" + (String)localObject2);
                  break label433;
                }
                this.mUrl = (this.mUrl + '&' + "entry=" + "navi");
                break label433;
              }
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        for (;;) {}
      }
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.mWebView != null) {
      try
      {
        int i = this.mWebView.copyBackForwardList().getCurrentIndex();
        LogUtil.e("BNVoice", "onBackPressed, BackForwardList index=" + i);
        if (i <= 1) {
          this.mCurrentWebPage = 0;
        }
        if ((i > 0) && (this.mWebView.canGoBack()))
        {
          this.mWebView.goBack();
          return false;
        }
      }
      catch (Exception localException)
      {
        LogUtil.e("BNVoice", "onBackPressed, error");
      }
    }
    return super.onBackPressed();
  }
  
  public void onDestory()
  {
    this.mEventDelayUtil.unRegistListner();
    this.mEventDelayUtil.clean();
    BNWorkerCenter.getInstance().cancelTask(this.mTimeOutMonitorTask, false);
    if (this.mWebView != null) {}
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      ViewGroup localViewGroup = (ViewGroup)this.mWebView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.mWebView);
      }
      this.mWebView.removeAllViews();
      this.mWebView.destroy();
      this.mWebView = null;
      this.mUrlLoadingWebView = null;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    super.onDestory();
  }
  
  protected View onInitView(Bundle paramBundle)
  {
    this.mVoiceSquareView = ((ViewGroup)JarUtils.oldInflate(this.mActivity, 1711472783, null));
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410352", "410352");
    findViews();
    if (this.mEventDelayUtil == null) {
      this.mEventDelayUtil = new EventDelayUtil();
    }
    this.mEventDelayUtil.registListner(this.mDelayListener);
    return this.mVoiceSquareView;
  }
  
  public void onPause()
  {
    stopWebVoice();
    BNWorkerCenter.getInstance().cancelTask(this.mTimeOutMonitorTask, false);
    if ((this.mWebView != null) && (this.mWebView.getVisibility() == 0)) {}
    try
    {
      this.mWebView.pauseTimers();
      this.mWebView.onPause();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onResume()
  {
    BNVoice.getInstance().setExternalCall(false, null);
    if ((this.mWebView != null) && (this.mWebView.getVisibility() == 0)) {}
    try
    {
      this.mWebView.onResume();
      this.mWebView.resumeTimers();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if ((this.mTitleBar != null) && (!BNSettingManager.isUsingMapMode())) {
      this.mTitleBar.setLeftContenVisible(false);
    }
    if (this.mProgressBar != null) {
      this.mProgressBar.setProgressDrawable(JarUtils.getResources().getDrawable(1711408058));
    }
  }
  
  public void setWebViewClickableFalse()
  {
    if (this.mClickableFalseLayout != null) {
      this.mClickableFalseLayout.setVisibility(0);
    }
  }
  
  public void setWebViewClickableTrue()
  {
    if (this.mClickableFalseLayout != null) {
      this.mClickableFalseLayout.setVisibility(8);
    }
  }
  
  public String showDownloadingList(String paramString, int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("id", paramString);
      localJSONObject2.put("progress", paramInt);
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("downloadingList", localJSONArray);
      return localJSONObject1.toString();
    }
    catch (JSONException paramString)
    {
      for (;;) {}
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
    if (paramInt1 == 3)
    {
      TipTool.onCreateToastDialog(this.mActivity, "下载错误");
      this.mEventDelayUtil.exec(paramInt1, 150, new Object[] { paramString });
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 5) {
          break;
        }
        this.mStartStatusStr = setStartStatus(paramString);
      } while ((this.mUrlLoadingWebView == null) || (this.mStartStatusStr == null) || (this.mStartStatusStr.length() <= 0));
      try
      {
        this.mUrlLoadingWebView.loadUrl("javascript:setStartStatus('" + this.mStartStatusStr + "')");
        return;
      }
      catch (Exception paramString)
      {
        return;
      }
      if (paramInt1 == 2)
      {
        this.mEventDelayUtil.exec(paramInt1, 150, new Object[] { paramString });
        TipTool.onCreateToastDialog(this.mActivity, "下载暂停");
        return;
      }
      if (paramInt1 == 1)
      {
        this.mEventDelayUtil.exec(paramInt1, 150, new Object[] { paramString, Integer.valueOf(paramInt2) });
        return;
      }
      if (paramInt1 == 4)
      {
        this.mEventDelayUtil.exec(paramInt1, 150, new Object[] { paramString });
        return;
      }
    } while (paramInt1 != 8);
    this.mEventDelayUtil.exec(paramInt1, 0, new Object[] { paramString, Integer.valueOf(paramInt2) });
  }
  
  public void updateSharedVoiceInfo(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      dismissWaitingLoading();
      TipTool.onCreateToastDialog(this.mActivity, "获取失败");
      return;
    }
    VoiceInfo localVoiceInfo;
    if (this.mCurrentWebPage == 2)
    {
      if (this.mYPID == null)
      {
        dismissWaitingLoading();
        return;
      }
      localVoiceInfo = VoiceHelper.getInstance().getVoiceInfo(this.mYPID);
      if (localVoiceInfo == null)
      {
        dismissWaitingLoading();
        return;
      }
      if (this.mBtnShareClicked)
      {
        this.mBtnShareClicked = false;
        VoiceHelper.getInstance().share(localVoiceInfo);
      }
    }
    for (;;)
    {
      dismissWaitingLoading();
      return;
      if (this.mUrlLoadingWebView != null)
      {
        VoiceDownloadController.getInstance().addSharedVoiceInfo(localVoiceInfo);
        startDownloadCheckNet(localVoiceInfo.taskId);
        continue;
        if (this.mTaskId != null)
        {
          localVoiceInfo = VoiceHelper.getInstance().getVoiceInfo(this.mTaskId);
          if ((localVoiceInfo != null) && (this.mUrlLoadingWebView != null))
          {
            VoiceDownloadController.getInstance().addSharedVoiceInfo(localVoiceInfo);
            startDownloadCheckNet(localVoiceInfo.taskId);
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/view/VoiceSquareView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */