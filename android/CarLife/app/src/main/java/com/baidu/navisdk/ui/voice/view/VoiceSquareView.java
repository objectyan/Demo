package com.baidu.navisdk.ui.voice.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Key;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.util.EventDelayUtil;
import com.baidu.navisdk.ui.util.EventDelayUtil.EventDelayListener;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice$VoiceUserAction;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.BNVoiceParams.VoiceEntry;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadController;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceSquareView extends VoiceBaseView {
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
    private EventDelayListener mDelayListener = new C45586();
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
    private BNWorkerNormalTask<String, String> mTimeOutMonitorTask = new BNWorkerNormalTask<String, String>("mTimeOutMonitorTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
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

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceSquareView$1 */
    class C45521 implements OnClickListener {
        C45521() {
        }

        public void onClick(View v) {
            if (NetworkUtils.isNetworkAvailable(VoiceSquareView.this.mActivity)) {
                VoiceSquareView.this.setWebViewClickableTrue();
            } else {
                TipTool.onCreateToastDialog(VoiceSquareView.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_net_work_unaiable));
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceSquareView$2 */
    class C45542 implements OnClickListener {
        C45542() {
        }

        public void onClick(View v) {
            if (!NetworkUtils.isNetworkAvailable(VoiceSquareView.this.mActivity)) {
                TipTool.onCreateToastDialog(VoiceSquareView.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_net_work_unaiable));
            } else if (VoiceSquareView.this.mLoadingFailLayout.getVisibility() == 0) {
                if (VoiceSquareView.this.mWebView != null) {
                    if (VoiceSquareView.this.mWebView.getUrl() == null) {
                        VoiceSquareView.this.mWebView.loadUrl(VoiceSquareView.this.mUrl);
                    } else {
                        VoiceSquareView.this.mWebView.reload();
                    }
                }
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("findViews-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        VoiceSquareView.this.hideLoadingFailView();
                        return null;
                    }
                }, new BNWorkerConfig(100, 0), 1000);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceSquareView$3 */
    class C45553 implements OnClickListener {
        C45553() {
        }

        public void onClick(View v) {
            if (VoiceSquareView.this.mJumpListener != null) {
                VoiceSquareView.this.mJumpListener.onBack(null);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceSquareView$4 */
    class C45564 extends WebViewClient {
        C45564() {
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            BNWorkerCenter.getInstance().cancelTask(VoiceSquareView.this.mTimeOutMonitorTask, false);
            VoiceSquareView.this.showLoadingFailView();
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            VoiceSquareView.this.mUrlLoadingWebView = view;
            if (url != null && url.contains(VoiceBaseView.URL_CHECK)) {
                VoiceSquareView.this.showDownloadList();
            } else if (url != null && url.contains(VoiceBaseView.URL_START)) {
                VoiceSquareView.this.mActionParam = VoiceSquareView.this.getURLParam(url, VoiceBaseView.ACTION_PARAM);
                VoiceSquareView.this.mTaskId = VoiceSquareView.this.getActionParamID(VoiceSquareView.this.mActionParam);
                VoiceInfo voiceInfo = new VoiceInfo();
                voiceInfo.taskId = VoiceSquareView.this.mTaskId;
                VoiceSquareView.this.mHasDownloadInfos = VoiceDownloadController.getInstance().getDownloadVoiceTask();
                VoiceSquareView.this.downloadStatics(VoiceSquareView.this.mTaskId);
                if (VoiceSquareView.this.mHasDownloadInfos != null && VoiceSquareView.this.mHasDownloadInfos.contains(voiceInfo)) {
                    TipTool.onCreateToastDialog(VoiceSquareView.this.mActivity, "已经下载了");
                } else if (!VoiceDownloadStatus.getInstance().hasInTaskQueue(VoiceSquareView.this.mTaskId)) {
                    if (VoiceDownloadController.getInstance().hasInSharedVoice(VoiceSquareView.this.mTaskId)) {
                        VoiceSquareView.this.startDownloadCheckNet(VoiceSquareView.this.mTaskId);
                    } else {
                        VoiceInfo realData = VoiceHelper.getInstance().getVoiceInfo(VoiceSquareView.this.mTaskId);
                        if (realData == null) {
                            VoiceSquareView.this.showWaitingLoading(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_main_waiting));
                        } else {
                            VoiceDownloadController.getInstance().addSharedVoiceInfo(realData);
                            VoiceSquareView.this.startDownloadCheckNet(VoiceSquareView.this.mTaskId);
                        }
                    }
                }
            } else if (url != null && url.contains(VoiceBaseView.URL_PAUSE)) {
                VoiceSquareView.this.mActionParam = VoiceSquareView.this.getURLParam(url, VoiceBaseView.ACTION_PARAM);
                VoiceSquareView.this.mTaskId = VoiceSquareView.this.getActionParamID(VoiceSquareView.this.mActionParam);
                if (VoiceSquareView.this.mTaskId != null) {
                    VoiceDownloadController.getInstance().pauseDownload(VoiceSquareView.this.mTaskId);
                }
            } else if (url != null && url.contains(VoiceBaseView.URL_PASS_TOPIC_INFO)) {
                VoiceSquareView.this.mTopicShareParam = VoiceSquareView.this.getURLParam(url, VoiceBaseView.ACTION_PARAM);
            } else if (url == null || !url.contains(VoiceBaseView.URL_NET_LOSS)) {
                if (VoiceSquareView.this.mUrlLoadingWebView != null) {
                    VoiceSquareView.this.mUrlLoadingWebView.loadUrl(url);
                }
                if (url != null && url.contains("ypid")) {
                    VoiceSquareView.this.mCurrentWebPage = 2;
                    VoiceSquareView.this.mYPID = VoiceSquareView.this.getURLParam(url, "ypid");
                }
            } else {
                VoiceSquareView.this.showLoadingFailView();
            }
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            BNWorkerCenter.getInstance().cancelTask(VoiceSquareView.this.mTimeOutMonitorTask, false);
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(VoiceSquareView.this.mTimeOutMonitorTask, new BNWorkerConfig(4, 0), 15000);
            VoiceSquareView.this.updateRightMenu();
            super.onPageStarted(view, url, favicon);
        }

        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
        }

        public void onPageFinished(WebView view, String url) {
            if (!NetworkUtils.isNetworkAvailable(VoiceSquareView.this.mActivity)) {
                VoiceSquareView.this.showLoadingFailView();
            }
            BNWorkerCenter.getInstance().cancelTask(VoiceSquareView.this.mTimeOutMonitorTask, false);
            super.onPageFinished(view, url);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceSquareView$5 */
    class C45575 extends WebChromeClient {
        C45575() {
        }

        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                VoiceSquareView.this.mProgressBar.setVisibility(8);
            } else {
                if (VoiceSquareView.this.mProgressBar.getVisibility() == 8) {
                    VoiceSquareView.this.mProgressBar.setVisibility(0);
                }
                VoiceSquareView.this.mProgressBar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceSquareView$6 */
    class C45586 implements EventDelayListener {
        C45586() {
        }

        public void onStart(int key, Object... objects) {
            boolean z = true;
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "onStart key: " + key);
            if (key == 1 || key == 4 || key == 8) {
                int value;
                String ttsId = objects[0];
                if (key == 1 || key == 8) {
                    value = ((Integer) objects[1]).intValue();
                } else {
                    value = 100;
                }
                VoiceSquareView.this.mDownloadingStr = VoiceSquareView.this.showDownloadingList(ttsId, value);
                if (VoiceSquareView.this.mUrlLoadingWebView != null && VoiceSquareView.this.mDownloadingStr != null && VoiceSquareView.this.mDownloadingStr.length() > 0) {
                    try {
                        VoiceSquareView.this.mUrlLoadingWebView.loadUrl("javascript:showDownloadingList('" + VoiceSquareView.this.mDownloadingStr + "')");
                    } catch (Exception e) {
                    }
                }
            } else if (key == 2) {
                VoiceSquareView.this.mPauseStatusStr = VoiceSquareView.this.setPauseStatus((String) objects[0]);
                if (VoiceSquareView.this.mUrlLoadingWebView != null && VoiceSquareView.this.mPauseStatusStr != null && VoiceSquareView.this.mPauseStatusStr.length() > 0) {
                    try {
                        VoiceSquareView.this.mUrlLoadingWebView.loadUrl("javascript:setPauseStatus('" + VoiceSquareView.this.mPauseStatusStr + "')");
                    } catch (Exception e2) {
                    }
                }
            } else if (key == 3) {
                VoiceSquareView.this.showDownloadList();
            } else if (key == 6) {
                VoiceInfo realData = VoiceHelper.getInstance().getVoiceInfo((String) objects[0]);
                String str = BNVoiceParams.MODULE_TAG;
                StringBuilder append = new StringBuilder().append("realData is null?");
                if (realData != null) {
                    z = false;
                }
                LogUtil.m15791e(str, append.append(z).toString());
                if (realData != null) {
                    VoiceSquareView.this.showDownloadList();
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceSquareView$7 */
    class C45597 implements OnClickListener {
        C45597() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                if (VoiceSquareView.this.mJumpListener != null) {
                    VoiceSquareView.this.mJumpListener.onVoiceUserBehaviour(BNVoice$VoiceUserAction.voice_share);
                }
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_SHARING, NaviStatConstants.NAVI_VOICE_SHARING);
                if (!NetworkUtils.isNetworkAvailable(VoiceSquareView.this.mActivity)) {
                    TipTool.onCreateToastDialog(VoiceSquareView.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_net_work_unaiable));
                } else if (VoiceSquareView.this.mCurrentWebPage == 2 && VoiceSquareView.this.mYPID != null) {
                    VoiceInfo vi = VoiceHelper.getInstance().getVoiceInfo(VoiceSquareView.this.mYPID);
                    if (vi != null) {
                        VoiceHelper.getInstance().share(vi);
                        return;
                    }
                    VoiceSquareView.this.mBtnShareClicked = true;
                    VoiceSquareView.this.showWaitingLoading("正在获取分享信息...");
                } else if (VoiceSquareView.this.mCurrentWebPage != 1 || VoiceSquareView.this.mTopicShareParam == null) {
                    VoiceHelper.getInstance().shareFromSquare();
                } else {
                    try {
                        VoiceHelper.getInstance().shareTopic(VoiceSquareView.this.mTopicShareParam);
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceSquareView$8 */
    class C45608 implements OnClickListener {
        C45608() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick() && VoiceSquareView.this.mJumpListener != null) {
                VoiceSquareView.this.mJumpListener.onPageJump(5, 1, new Bundle());
            }
        }
    }

    protected View onInitView(Bundle configBundle) {
        this.mVoiceSquareView = (ViewGroup) JarUtils.oldInflate(this.mActivity, C4048R.layout.nsdk_layout_voice_square_view, null);
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_PIAZZA_ACCESS, NaviStatConstants.NAVI_VOICE_PIAZZA_ACCESS);
        findViews();
        if (this.mEventDelayUtil == null) {
            this.mEventDelayUtil = new EventDelayUtil();
        }
        this.mEventDelayUtil.registListner(this.mDelayListener);
        return this.mVoiceSquareView;
    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    private void findViews() {
        if (this.mVoiceSquareView != null) {
            this.mLoadingSuccessLayout = (RelativeLayout) this.mVoiceSquareView.findViewById(C4048R.id.voice_square_loading_success_layout);
            this.mLoadingFailLayout = this.mVoiceSquareView.findViewById(C4048R.id.voice_square_loading_fail_layout);
            this.mClickableFalseLayout = (RelativeLayout) this.mVoiceSquareView.findViewById(C4048R.id.voice_square_clickable_false_layout);
            this.mClickableFalseLayout.setOnClickListener(new C45521());
            hideLoadingFailView();
            this.mLoadingFailLayout.setOnClickListener(new C45542());
            this.mTitleBar = (BNCommonTitleBar) this.mVoiceSquareView.findViewById(C4048R.id.voice_square_title_bar);
            this.mTitleBar.setMiddleTextSize(18.0f);
            this.mTitleBar.setLeftOnClickedListener(new C45553());
            updateRightMenu();
            this.mProgressBar = (ProgressBar) this.mVoiceSquareView.findViewById(C4048R.id.voice_square_progress_bar);
            this.mWebView = (WebView) this.mVoiceSquareView.findViewById(C4048R.id.voice_square_webview);
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.getSettings().setLoadWithOverviewMode(true);
            WebSettings settings = this.mWebView.getSettings();
            settings.setCacheMode(-1);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setSupportZoom(false);
            settings.setUseWideViewPort(true);
            settings.setSupportMultipleWindows(true);
            settings.setUserAgentString("baidumap_ANDR");
            this.mWebView.setWebViewClient(new C45564());
            this.mWebView.setWebChromeClient(new C45575());
        }
    }

    private String getURLParam(String urlorigin, String paramName) {
        try {
            String url = URLDecoder.decode(urlorigin, "UTF-8");
            String[] a = new String[50];
            if (url.indexOf(paramName) != -1) {
                String[] strs = url.substring(url.indexOf(paramName)).split("&")[0].split("=", 2);
                if (strs != null && strs.length >= 2) {
                    return strs[1];
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void initValues(Bundle bundle) {
        String loadParams = null;
        this.mStartStatusStr = null;
        this.mPauseStatusStr = null;
        this.mDownloadingStr = null;
        this.mActionParam = null;
        this.mTaskId = null;
        this.mBtnShareClicked = false;
        setWebViewClickableTrue();
        String entry = null;
        Bundle extBundle = BNVoice.getInstance().getCallBundle();
        VoiceInfo voiceInfo = null;
        if (extBundle != null) {
            entry = extBundle.getString("entry");
            if (2 == extBundle.getInt(Key.BUNDLE_ROOT_PAGE_TYPE)) {
                this.isFromNavingPage = true;
                Bundle voiceInfoBd = extBundle.getBundle(BNVoiceParams.BUNDLE_VOICEINFO);
                if (voiceInfoBd != null) {
                    voiceInfo = VoiceInfo.getVoiceInfo(voiceInfoBd);
                }
            } else {
                this.isFromNavingPage = false;
            }
        }
        updateRightMenu();
        if (this.mUrl == null) {
            if (extBundle != null && extBundle.containsKey("downIds")) {
                String ids = extBundle.getString("downIds");
                if (!TextUtils.isEmpty(ids)) {
                    loadParams = "load=" + ids;
                }
                if (loadParams != null) {
                    loadParams = loadParams + "&";
                }
            }
            if (voiceInfo != null && voiceInfo.status == 4) {
                this.mUrl = voiceInfo.voiceUrl + "&from=in";
            } else if (loadParams != null) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "loadparams = " + loadParams);
                this.mUrl = HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_VOICE_SQUARE) + "?" + loadParams + "from=in";
            } else if (this.isFromNavingPage) {
                String str;
                StringBuilder stringBuilder = new StringBuilder();
                if (BNSettingManager.isUseHttpsOfflineURL()) {
                    str = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_navingvoice/navingvoice/";
                } else {
                    str = HttpURLManager.getInstance().getScheme() + "webpagenavi.baidu.com/static/webpage/voice_market_navingvoice/navingvoice/";
                }
                this.mUrl = stringBuilder.append(str).append("?from=in").toString();
            } else {
                this.mUrl = HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_VOICE_SQUARE) + "?from=in";
            }
            if ("1" != null) {
                this.mUrl += '&' + "sid=" + "1";
            }
            String appVersionStr = "10.1.0";
            if (appVersionStr != null) {
                this.mUrl += '&' + "app_version=" + appVersionStr;
            }
            if ("0" != null) {
                this.mUrl += '&' + "os=" + "0";
            }
            if (this.isFromNavingPage) {
                this.mUrl += '&' + "entry=" + VoiceEntry.NAVING;
            } else if (entry != null) {
                this.mUrl += '&' + "entry=" + entry;
            } else {
                this.mUrl += '&' + "entry=" + "navi";
            }
            if (!(this.mWebView == null || this.mUrl == null)) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "url = " + this.mUrl);
                try {
                    this.mWebView.loadUrl(this.mUrl);
                } catch (Exception e) {
                }
            }
        }
        showDownloadList();
        this.mLocalVoiceSize = 0;
        ArrayList<VoiceInfo> downsInfos = VoiceDownloadController.getInstance().getDownloadVoiceTask();
        if (downsInfos != null && downsInfos.size() > 0) {
            Iterator it = downsInfos.iterator();
            while (it.hasNext()) {
                if (((VoiceInfo) it.next()).status == 0) {
                    this.mLocalVoiceSize++;
                }
            }
        }
    }

    public void onResume() {
        BNVoice.getInstance().setExternalCall(false, null);
        if (this.mWebView != null && this.mWebView.getVisibility() == 0) {
            try {
                this.mWebView.onResume();
                this.mWebView.resumeTimers();
            } catch (Exception e) {
            }
        }
    }

    private void stopWebVoice() {
        if (this.mUrlLoadingWebView != null) {
            this.mUrlLoadingWebView.loadUrl("javascript:stopListen()");
        }
    }

    public void onPause() {
        stopWebVoice();
        BNWorkerCenter.getInstance().cancelTask(this.mTimeOutMonitorTask, false);
        if (this.mWebView != null && this.mWebView.getVisibility() == 0) {
            try {
                this.mWebView.pauseTimers();
                this.mWebView.onPause();
            } catch (Exception e) {
            }
        }
    }

    public void onDestory() {
        this.mEventDelayUtil.unRegistListner();
        this.mEventDelayUtil.clean();
        BNWorkerCenter.getInstance().cancelTask(this.mTimeOutMonitorTask, false);
        if (this.mWebView != null) {
            try {
                if (VERSION.SDK_INT >= 11) {
                    this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
                }
                ViewGroup viewGroup = (ViewGroup) this.mWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mWebView);
                }
                this.mWebView.removeAllViews();
                this.mWebView.destroy();
                this.mWebView = null;
                this.mUrlLoadingWebView = null;
            } catch (Exception e) {
            }
        }
        super.onDestory();
    }

    public void onUpdateStyle(boolean day) {
        if (!(this.mTitleBar == null || BNSettingManager.isUsingMapMode())) {
            this.mTitleBar.setLeftContenVisible(false);
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setProgressDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_voice_webview_progressbar));
        }
    }

    public boolean onBackPressed() {
        if (this.mWebView != null) {
            try {
                int index = this.mWebView.copyBackForwardList().getCurrentIndex();
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "onBackPressed, BackForwardList index=" + index);
                if (index <= 1) {
                    this.mCurrentWebPage = 0;
                }
                if (index > 0 && this.mWebView.canGoBack()) {
                    this.mWebView.goBack();
                    return false;
                }
            } catch (Exception e) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "onBackPressed, error");
            }
        }
        return super.onBackPressed();
    }

    public void downloadStatics(String taskId) {
        if (this.mJumpListener != null) {
            this.mJumpListener.onVoiceUserBehaviour(BNVoice$VoiceUserAction.voice_download);
        }
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_PIAZZA_DOWNLOAD_CLICK, NaviStatConstants.NAVI_VOICE_PIAZZA_DOWNLOAD_CLICK);
    }

    public void updateSharedVoiceInfo(boolean success) {
        if (success) {
            VoiceInfo realData;
            if (this.mCurrentWebPage == 2) {
                if (this.mYPID == null) {
                    dismissWaitingLoading();
                    return;
                }
                realData = VoiceHelper.getInstance().getVoiceInfo(this.mYPID);
                if (realData == null) {
                    dismissWaitingLoading();
                    return;
                } else if (this.mBtnShareClicked) {
                    this.mBtnShareClicked = false;
                    VoiceHelper.getInstance().share(realData);
                } else if (this.mUrlLoadingWebView != null) {
                    VoiceDownloadController.getInstance().addSharedVoiceInfo(realData);
                    startDownloadCheckNet(realData.taskId);
                }
            } else if (this.mTaskId != null) {
                realData = VoiceHelper.getInstance().getVoiceInfo(this.mTaskId);
                if (!(realData == null || this.mUrlLoadingWebView == null)) {
                    VoiceDownloadController.getInstance().addSharedVoiceInfo(realData);
                    startDownloadCheckNet(realData.taskId);
                }
            }
            dismissWaitingLoading();
            return;
        }
        dismissWaitingLoading();
        TipTool.onCreateToastDialog(this.mActivity, "获取失败");
    }

    private void showWaitingLoading(String strTip) {
        if (this.mActivity != null) {
            dismissWaitingLoading();
            try {
                if (this.mWaitingLoading == null && this.mActivity != null) {
                    this.mWaitingLoading = new BNCommonProgressDialog(this.mActivity);
                }
                if (this.mWaitingLoading != null) {
                    this.mWaitingLoading.setMessage(strTip);
                }
                if (!this.mWaitingLoading.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                    this.mWaitingLoading.show();
                }
            } catch (Exception e) {
            }
        }
    }

    private void dismissWaitingLoading() {
        try {
            if (this.mWaitingLoading != null && this.mActivity != null && !this.mActivity.isFinishing() && this.mWaitingLoading.isShowing()) {
                this.mWaitingLoading.dismiss();
            }
        } catch (Exception e) {
            this.mWaitingLoading = null;
        }
    }

    private String getActionParamID(String jsonStr) {
        String idStr = null;
        if (jsonStr != null && jsonStr.length() > 0) {
            try {
                idStr = new JSONObject(jsonStr).get("id").toString();
            } catch (JSONException e) {
            }
        }
        return idStr;
    }

    private void showDownloadList() {
        String downloadListStr = getSquareVoiceInfo();
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "downloadListStr:" + downloadListStr);
        if (this.mUrlLoadingWebView != null && downloadListStr != null && downloadListStr.length() > 0) {
            try {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "loadUrl");
                this.mUrlLoadingWebView.loadUrl("javascript:showDownloadList('" + downloadListStr + "')");
            } catch (Exception e) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "showDownloadList Exception:" + e.getMessage());
            }
        }
    }

    private String setStartStatus(String taskId) {
        JSONObject jsonObj = new JSONObject();
        if (!NetworkUtils.isNetworkAvailable(this.mActivity) || taskId == null || taskId.length() <= 0) {
            try {
                jsonObj.put(C2125n.f6745M, 1);
                jsonObj.put("id", taskId);
            } catch (JSONException e) {
            }
            return jsonObj.toString();
        }
        try {
            jsonObj.put(C2125n.f6745M, 0);
            jsonObj.put("id", taskId);
        } catch (JSONException e2) {
        }
        return jsonObj.toString();
    }

    private String setPauseStatus(String taskId) {
        JSONObject jsonObj = new JSONObject();
        if (taskId == null || taskId.length() <= 0) {
            try {
                jsonObj.put(C2125n.f6745M, 1);
                jsonObj.put("id", taskId);
            } catch (JSONException e) {
            }
            return jsonObj.toString();
        }
        try {
            jsonObj.put(C2125n.f6745M, 0);
            jsonObj.put("id", taskId);
        } catch (JSONException e2) {
        }
        return jsonObj.toString();
    }

    private String getSquareVoiceInfo() {
        Iterator it;
        VoiceInfo info;
        DownStats downstats;
        JSONObject squareVoiceInfoJsonObj = new JSONObject();
        JSONArray downloadedJsonArr = new JSONArray();
        JSONArray downloadingJsonArr = new JSONArray();
        JSONArray downloadPauseJsonArr = new JSONArray();
        JSONArray usingJsonArr = new JSONArray();
        this.mDownsInfos = VoiceDownloadController.getInstance().getDownloadVoiceTask();
        if (this.mDownsInfos != null && this.mDownsInfos.size() > 0) {
            it = this.mDownsInfos.iterator();
            while (it.hasNext()) {
                info = (VoiceInfo) it.next();
                try {
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("id", info.taskId);
                    downloadedJsonArr.put(jsonObj);
                } catch (JSONException e) {
                }
            }
        }
        try {
            this.mRecommendInfos = VoiceDownloadController.getInstance().getRecommendVoiceTask();
        } catch (UnsatisfiedLinkError e2) {
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "getRecommendVoiceTask");
        }
        if (this.mRecommendInfos != null && this.mRecommendInfos.size() > 0) {
            it = this.mRecommendInfos.iterator();
            while (it.hasNext()) {
                info = (VoiceInfo) it.next();
                downstats = DownStats.getTaskDownStatus(info.taskId);
                if (downstats.stats == 1) {
                    try {
                        jsonObj = new JSONObject();
                        jsonObj.put("id", info.taskId);
                        jsonObj.put("progress", downstats.progress);
                        downloadingJsonArr.put(jsonObj);
                    } catch (JSONException e3) {
                    }
                } else if (downstats.stats == 2) {
                    try {
                        jsonObj = new JSONObject();
                        jsonObj.put("id", info.taskId);
                        jsonObj.put("progress", downstats.progress);
                        downloadPauseJsonArr.put(jsonObj);
                    } catch (JSONException e4) {
                    }
                }
            }
        }
        this.mSharedInfos = VoiceDownloadController.getInstance().getSharedVoiceInfos();
        if (this.mSharedInfos != null && this.mSharedInfos.size() > 0) {
            it = this.mSharedInfos.iterator();
            while (it.hasNext()) {
                info = (VoiceInfo) it.next();
                downstats = DownStats.getTaskDownStatus(info.taskId);
                if (downstats.stats == 1 || downstats.stats == 3) {
                    try {
                        jsonObj = new JSONObject();
                        jsonObj.put("id", info.taskId);
                        jsonObj.put("progress", downstats.progress);
                        downloadingJsonArr.put(jsonObj);
                    } catch (JSONException e5) {
                    }
                } else if (downstats.stats == 2) {
                    try {
                        jsonObj = new JSONObject();
                        jsonObj.put("id", info.taskId);
                        jsonObj.put("progress", downstats.progress);
                        downloadPauseJsonArr.put(jsonObj);
                    } catch (JSONException e6) {
                    }
                }
            }
        }
        this.mWaitingInfos = VoiceDownloadStatus.getInstance().getTaskQueue();
        it = this.mWaitingInfos.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                jsonObj = new JSONObject();
                jsonObj.put("id", str);
                jsonObj.put("progress", 0);
                downloadingJsonArr.put(jsonObj);
            } catch (JSONException e7) {
            }
        }
        String usingTaskId = VoiceHelper.getInstance().getCurrentUsedTTSId();
        if (usingTaskId != null) {
            try {
                jsonObj = new JSONObject();
                jsonObj.put("id", usingTaskId);
                usingJsonArr.put(jsonObj);
            } catch (JSONException e8) {
            }
        }
        try {
            squareVoiceInfoJsonObj.put("downloadedList", downloadedJsonArr);
            squareVoiceInfoJsonObj.put("downloadingList", downloadingJsonArr);
            squareVoiceInfoJsonObj.put("downloadPauseList", downloadPauseJsonArr);
            squareVoiceInfoJsonObj.put("usingList", usingJsonArr);
        } catch (JSONException e9) {
        }
        return squareVoiceInfoJsonObj.toString();
    }

    public String showDownloadingList(String taskId, int progress) {
        JSONObject downloadingJsonObj = new JSONObject();
        JSONArray downloadingJsonArr = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", taskId);
            jsonObj.put("progress", progress);
            downloadingJsonArr.put(jsonObj);
            downloadingJsonObj.put("downloadingList", downloadingJsonArr);
        } catch (JSONException e) {
        }
        return downloadingJsonObj.toString();
    }

    public void updateItemView(String taskId, int status, int value) {
        if (status == 3) {
            TipTool.onCreateToastDialog(this.mActivity, "下载错误");
            this.mEventDelayUtil.exec(status, CommonHandlerThread.MSG_START_RECORD_TRAJECTORY, taskId);
        } else if (status == 5) {
            this.mStartStatusStr = setStartStatus(taskId);
            if (this.mUrlLoadingWebView != null && this.mStartStatusStr != null && this.mStartStatusStr.length() > 0) {
                try {
                    this.mUrlLoadingWebView.loadUrl("javascript:setStartStatus('" + this.mStartStatusStr + "')");
                } catch (Exception e) {
                }
            }
        } else if (status == 2) {
            this.mEventDelayUtil.exec(status, CommonHandlerThread.MSG_START_RECORD_TRAJECTORY, taskId);
            TipTool.onCreateToastDialog(this.mActivity, C1253f.gr);
        } else if (status == 1) {
            this.mEventDelayUtil.exec(status, CommonHandlerThread.MSG_START_RECORD_TRAJECTORY, taskId, Integer.valueOf(value));
        } else if (status == 4) {
            this.mEventDelayUtil.exec(status, CommonHandlerThread.MSG_START_RECORD_TRAJECTORY, taskId);
        } else if (status == 8) {
            this.mEventDelayUtil.exec(status, 0, taskId, Integer.valueOf(value));
        }
    }

    public void switchVoiceData(String taskId) {
        if (this.mJumpListener != null) {
            this.mJumpListener.onVoiceUserBehaviour(BNVoice$VoiceUserAction.voice_usage);
        }
        if (BNVoice.getInstance().switchVoice(taskId)) {
            showWaitingLoading("切换中...");
        }
    }

    public void handleSwitchVoiceData(boolean success, String taskId) {
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "handleSwitchVoiceData success:" + success);
        if (success && this.mEventDelayUtil != null) {
            this.mEventDelayUtil.exec(6, CommonHandlerThread.MSG_START_RECORD_TRAJECTORY, taskId);
        }
        dismissWaitingLoading();
    }

    public void setWebViewClickableFalse() {
        if (this.mClickableFalseLayout != null) {
            this.mClickableFalseLayout.setVisibility(0);
        }
    }

    public void setWebViewClickableTrue() {
        if (this.mClickableFalseLayout != null) {
            this.mClickableFalseLayout.setVisibility(8);
        }
    }

    private void updateRightMenu() {
        if (this.mTitleBar != null) {
            if (this.isFromNavingPage) {
                this.mTitleBar.setRightIconVisible(false);
                this.mTitleBar.setRightTextVisible(false);
                return;
            }
            if (this.mCurrentWebPage != 2 && this.mCurrentWebPage != 1) {
                this.mTitleBar.setRightIcon(null);
                this.mTitleBar.setRightText(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_square_titlebar_right_text));
            } else if (BNaviModuleManager.isGooglePlayChannel()) {
                this.mTitleBar.setRightIconVisible(false);
                this.mTitleBar.setRightTextVisible(false);
            } else {
                this.mTitleBar.setRightIcon(JarUtils.getResources().getDrawable(C4048R.drawable.voice_navi_share_icon));
                this.mTitleBar.setRightText(null);
            }
            if (BNaviModuleManager.isGooglePlayChannel() && (this.mCurrentWebPage == 2 || this.mCurrentWebPage == 1)) {
                this.mTitleBar.setRightTextVisible(false);
                this.mTitleBar.setRightIconVisible(false);
            } else {
                this.mTitleBar.setRightIconVisible(true);
            }
            if ((this.mCurrentWebPage == 2 || this.mCurrentWebPage == 1) && !BNaviModuleManager.isGooglePlayChannel()) {
                this.mTitleBar.setRightOnClickedListener(new C45597());
            } else {
                this.mTitleBar.setRightOnClickedListener(new C45608());
            }
        }
    }

    private void startDownloadCheckNet(String mTaskId) {
        final String taskId = mTaskId;
        if (!"9999".equals(taskId) && !"2-".equals(taskId.substring(0, 2))) {
            VoiceDownloadController.getInstance().startDownload(taskId);
        } else if (NetworkUtils.isTypeNetworkAvailable(this.mActivity, 1)) {
            VoiceDownloadController.getInstance().startDownload(taskId);
        } else if (this.mActivity == null) {
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "startDownloadCheckNet mActivity is null");
        } else {
            if (this.mNetStatusDialog == null) {
                this.mNetStatusDialog = new BNDialog(this.mActivity);
            } else if (this.mNetStatusDialog.isShowing()) {
                return;
            }
            this.mNetStatusDialog.setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification));
            this.mNetStatusDialog.setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_not_wifi_notification));
            this.mNetStatusDialog.setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_confirm));
            this.mNetStatusDialog.setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    VoiceDownloadController.getInstance().startDownload(taskId);
                }
            });
            this.mNetStatusDialog.setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_cancel));
            this.mNetStatusDialog.setOnFirstBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    VoiceSquareView.this.mNetStatusDialog.dismiss();
                    DownStats downstatus = DownStats.getTaskDownStatus(taskId);
                    if (downstatus.stats == 0 || (downstatus.stats == 2 && downstatus.progress == 0)) {
                        VoiceDownloadController.getInstance().removeDownload(taskId);
                        VoiceDownloadController.getInstance().removeSharedVoieInfo(taskId);
                    }
                }
            });
            if (!this.mNetStatusDialog.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mNetStatusDialog.show();
            }
        }
    }

    private void showLoadingFailView() {
        if (this.mLoadingFailLayout != null) {
            this.mLoadingFailLayout.setVisibility(0);
        }
        if (this.mLoadingSuccessLayout != null) {
            this.mLoadingSuccessLayout.setVisibility(8);
        }
    }

    private void hideLoadingFailView() {
        if (this.mLoadingFailLayout != null) {
            this.mLoadingFailLayout.setVisibility(8);
        }
        if (this.mLoadingSuccessLayout != null) {
            this.mLoadingSuccessLayout.setVisibility(0);
        }
    }
}
