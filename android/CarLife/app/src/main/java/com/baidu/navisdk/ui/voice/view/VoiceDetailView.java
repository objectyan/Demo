package com.baidu.navisdk.ui.voice.view;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice$VoiceUserAction;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.controller.VoicePlayController;
import com.baidu.navisdk.ui.voice.controller.VoicePlayController.PlayAllAudioEndListener;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.drawable.UrlDrawable;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.ArrayList;
import java.util.Map;

public class VoiceDetailView extends VoiceBaseView {
    private View mDivider;
    private TextView mEditText;
    private String mHeadUrl;
    private ImageView mHeadView;
    private ImageView mImageEarth;
    private ImageView mImageHeadView;
    private ImageView mImagePlay;
    private View mLoadingFailLayout;
    private RelativeLayout mLocalViewInfo;
    private RelativeLayout mLocalViewShow;
    private TextView mNameText;
    private RelativeLayout mNetViewInfo;
    private boolean mPlay;
    private ProgressBar mProgressBar;
    private Animation mRotateAnimation;
    private TextView mSizeText;
    private TextView mTagText;
    private BNWorkerNormalTask<String, String> mTimeOutMonitorTask = new BNWorkerNormalTask<String, String>("mTimeOutMonitorTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            if (VoiceDetailView.this.mWebView != null) {
                VoiceDetailView.this.mWebView.stopLoading();
            }
            if (VoiceDetailView.this.mLoadingFailLayout != null) {
                VoiceDetailView.this.mLoadingFailLayout.setVisibility(0);
            }
            return null;
        }
    };
    private BNCommonTitleBar mTitleBar;
    private WebView mUrlLoadingWebView;
    private ViewGroup mVoiceDetailView;
    private VoiceInfo mVoiceInfo;
    private Map<String, String> mVoicePaths;
    private BNCommonProgressDialog mWaitingLoading = null;
    private WebView mWebView;

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$1 */
    class C45341 implements PlayAllAudioEndListener {
        C45341() {
        }

        public void onPlayAllEnd() {
            VoiceDetailView.this.stopPlayAudio();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$2 */
    class C45352 implements OnClickListener {
        C45352() {
        }

        public void onClick(View v) {
            if (VoiceDetailView.this.mJumpListener != null) {
                VoiceDetailView.this.mJumpListener.onBack(null);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$3 */
    class C45363 implements OnClickListener {
        C45363() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "onclcik shared :" + VoiceDetailView.this.mVoiceInfo);
                if (VoiceDetailView.this.mJumpListener != null) {
                    VoiceDetailView.this.mJumpListener.onVoiceUserBehaviour(BNVoice$VoiceUserAction.voice_share);
                }
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_SHARING, NaviStatConstants.NAVI_VOICE_SHARING);
                if (!NetworkUtils.isNetworkAvailable(VoiceDetailView.this.mActivity)) {
                    TipTool.onCreateToastDialog(VoiceDetailView.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_net_work_unaiable));
                } else if (VoiceDetailView.this.mVoiceInfo != null && !VoiceHelper.getInstance().share(VoiceDetailView.this.mVoiceInfo)) {
                    TipTool.onCreateToastDialog(VoiceDetailView.this.mActivity, "上传失败");
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$4 */
    class C45374 implements OnClickListener {
        C45374() {
        }

        public void onClick(View v) {
            boolean enable = false;
            try {
                enable = ((Boolean) VoiceDetailView.this.mEditText.getTag()).booleanValue();
            } catch (Exception e) {
            }
            if (!enable) {
                TipTool.onCreateToastDialog(VoiceDetailView.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_using_noedit));
            } else if (VoiceDetailView.this.mJumpListener != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle(BNVoiceParams.BUNDLE_VOICEINFO, VoiceDetailView.this.mVoiceInfo.toBundle());
                VoiceDetailView.this.mJumpListener.onPageJump(4, 2, bundle);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$5 */
    class C45385 extends WebViewClient {
        C45385() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            VoiceDetailView.this.mUrlLoadingWebView = view;
            if (url == null || !url.contains(VoiceBaseView.URL_NET_LOSS)) {
                if (url == null || !url.startsWith("bdnavi://")) {
                    view.loadUrl(url);
                }
            } else if (VoiceDetailView.this.mLoadingFailLayout != null) {
                VoiceDetailView.this.mLoadingFailLayout.setVisibility(0);
            }
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BNWorkerCenter.getInstance().cancelTask(VoiceDetailView.this.mTimeOutMonitorTask, false);
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(VoiceDetailView.this.mTimeOutMonitorTask, new BNWorkerConfig(6, 0), 15000);
        }

        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BNWorkerCenter.getInstance().cancelTask(VoiceDetailView.this.mTimeOutMonitorTask, false);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$6 */
    class C45396 extends WebChromeClient {
        C45396() {
        }

        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                VoiceDetailView.this.mProgressBar.setVisibility(8);
            } else {
                if (VoiceDetailView.this.mProgressBar.getVisibility() == 8) {
                    VoiceDetailView.this.mProgressBar.setVisibility(0);
                }
                VoiceDetailView.this.mProgressBar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$7 */
    class C45407 implements OnClickListener {
        C45407() {
        }

        public void onClick(View v) {
            if (VoiceDetailView.this.mPlay) {
                VoiceDetailView.this.stopPlayAudio();
            } else {
                VoiceDetailView.this.startPlayAudio();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$8 */
    class C45418 implements OnClickListener {
        C45418() {
        }

        public void onClick(View v) {
            if (!NetworkUtils.isNetworkAvailable(VoiceDetailView.this.mActivity)) {
                TipTool.onCreateToastDialog(VoiceDetailView.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_net_work_unaiable));
            } else if (VoiceDetailView.this.mLoadingFailLayout.getVisibility() == 0) {
                if (!(VoiceDetailView.this.mWebView == null || VoiceDetailView.this.mWebView.getUrl() == null)) {
                    VoiceDetailView.this.mWebView.reload();
                }
                VoiceDetailView.this.mLoadingFailLayout.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceDetailView$9 */
    class C45429 implements OnGlobalLayoutListener {
        C45429() {
        }

        public void onGlobalLayout() {
            VoiceDetailView.this.mImageEarth.clearAnimation();
            VoiceDetailView.this.mRotateAnimation.reset();
            VoiceDetailView.this.mImageEarth.startAnimation(VoiceDetailView.this.mRotateAnimation);
            VoiceDetailView.this.mImageEarth.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    protected View onInitView(Bundle configBundle) {
        this.mVoiceDetailView = (ViewGroup) JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_voice_detail_layout, null);
        findViews();
        initAnimation();
        return this.mVoiceDetailView;
    }

    private void initAnimation() {
        this.mRotateAnimation = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(20000);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setFillBefore(true);
        this.mRotateAnimation.setFillAfter(true);
        this.mRotateAnimation.setFillEnabled(true);
    }

    public void onResume() {
        this.mHeadUrl = BNVoice.getInstance().getUserHeadUrl();
        updateVoiceInfo();
        if (this.mWebView != null && this.mWebView.getVisibility() == 0) {
            try {
                this.mWebView.onResume();
                this.mWebView.resumeTimers();
            } catch (Exception e) {
            }
        }
        if (this.mLocalViewShow != null && this.mLocalViewShow.getVisibility() == 0) {
            VoicePlayController.getInstance().initPlayAllVoice();
        }
    }

    public void onPause() {
        stopWebVoice(this.mUrlLoadingWebView);
        BNWorkerCenter.getInstance().cancelTask(this.mTimeOutMonitorTask, false);
        if (this.mWebView != null && this.mWebView.getVisibility() == 0) {
            try {
                this.mWebView.pauseTimers();
                this.mWebView.onPause();
            } catch (Exception e) {
            }
        }
        if (this.mImageEarth != null && this.mImageEarth.getVisibility() == 0) {
            stopPlayAudio();
            VoicePlayController.getInstance().releasePlayAllVoice();
            this.mImageEarth.clearAnimation();
        }
    }

    public void onDestory() {
        BNWorkerCenter.getInstance().cancelTask(this.mTimeOutMonitorTask, false);
        if (this.mWebView != null) {
            try {
                if (VERSION.SDK_INT >= 11) {
                    this.mWebView.removeJavascriptInterface("bdnavi");
                    this.mWebView.removeJavascriptInterface("accessibility");
                    this.mWebView.removeJavascriptInterface("accessibilityTraversal");
                }
                this.mWebView.destroy();
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
        if (this.mLocalViewInfo != null) {
            this.mLocalViewInfo.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_local_info_bg_color));
        }
        if (this.mNameText != null) {
            this.mNameText.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_main_text_name_color));
        }
        if (this.mTagText != null) {
            this.mTagText.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_main_text_size_color));
        }
        if (this.mSizeText != null) {
            this.mSizeText.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_main_text_size_color));
        }
        if (this.mDivider != null) {
            this.mDivider.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_main_text_size_color));
        }
        if (this.mLocalViewShow != null) {
            this.mLocalViewShow.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_local_info_show_bg_color));
        }
    }

    public void initValues(Bundle config) {
        if (config != null && config.containsKey(BNVoiceParams.BUNDLE_VOICEINFO)) {
            this.mVoiceInfo = VoiceInfo.getVoiceInfo(config.getBundle(BNVoiceParams.BUNDLE_VOICEINFO));
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "detailView initValue voiceInfo :" + this.mVoiceInfo.toString());
        }
    }

    private void updateVoiceInfo() {
        if (this.mVoiceInfo == null) {
            return;
        }
        String url;
        if (this.mVoiceInfo.status == 2) {
            url = this.mVoiceInfo.voiceUrl + "&isload=1";
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "url = " + url);
            ShowNetView(url);
        } else if (this.mVoiceInfo.status == 3) {
            url = this.mVoiceInfo.voiceUrl + "&isload=0";
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "url = " + url);
            ShowNetView(url);
        } else {
            showLocalView();
        }
    }

    private void showLocalView() {
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "showLocalView before" + this.mVoiceInfo.toString());
        if (this.mVoiceInfo.taskId != null) {
            this.mVoiceInfo = VoiceHelper.getInstance().getVoiceInfo(this.mVoiceInfo.taskId);
        }
        if (this.mVoiceInfo != null) {
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "showLocalView after" + this.mVoiceInfo.toString());
            this.mNetViewInfo.setVisibility(8);
            this.mLocalViewInfo.setVisibility(0);
            this.mLocalViewShow.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVoiceInfo.imageUrl) && !this.mVoiceInfo.imageUrl.trim().equals("url")) {
                this.mHeadView.setImageDrawable(UrlDrawable.getDrawable(this.mVoiceInfo.imageUrl.trim()));
                this.mImageHeadView.setImageDrawable(UrlDrawable.getDrawable(this.mVoiceInfo.imageUrl.trim()));
            } else if (this.mHeadUrl != null) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "detail view showLocalView headView use  " + this.mHeadUrl);
                this.mHeadView.setImageDrawable(UrlDrawable.getDrawable(this.mHeadUrl.trim()));
                this.mImageHeadView.setImageDrawable(UrlDrawable.getDrawable(this.mHeadUrl.trim()));
            } else {
                this.mHeadView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_common_head_view));
                this.mImageHeadView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_common_head_view));
            }
            this.mNameText.setText(this.mVoiceInfo.name);
            if (this.mVoiceInfo.taskId.equals(VoiceHelper.getInstance().getCurrentUsedTTSId())) {
                this.mEditText.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_local_edit_disable_color));
                this.mEditText.setCompoundDrawablesWithIntrinsicBounds(null, JarUtils.getResources().getDrawable(C4048R.drawable.voice_detail_edit_disable), null, null);
                this.mEditText.setTag(Boolean.valueOf(false));
            } else {
                this.mEditText.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_local_edit_enable_color));
                this.mEditText.setCompoundDrawablesWithIntrinsicBounds(null, JarUtils.getResources().getDrawable(C4048R.drawable.voice_detail_edit_enable), null, null);
                this.mEditText.setTag(Boolean.valueOf(true));
            }
            this.mVoicePaths = VoiceHelper.getInstance().getRecordVoiceDetailInfo(this.mVoiceInfo.taskId);
            int count = this.mVoicePaths.size();
            this.mTagText.setText(String.format(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_detail_cnt), new Object[]{Integer.valueOf(count)}));
            this.mSizeText.setText(VoiceHelper.getInstance().getVoiceShowSize(this.mVoiceInfo.size));
            VoicePlayController.getInstance().setPlayAllAudioEndListener(new C45341());
            if (this.mImageEarth != null && this.mImageEarth.getVisibility() == 0) {
                this.mImageEarth.clearAnimation();
                this.mRotateAnimation.reset();
                this.mImageEarth.startAnimation(this.mRotateAnimation);
            }
        }
    }

    private void ShowNetView(String url) {
        if (this.mNetViewInfo != null) {
            this.mNetViewInfo.setVisibility(0);
        }
        if (this.mLocalViewInfo != null) {
            this.mLocalViewInfo.setVisibility(8);
        }
        if (this.mLocalViewShow != null) {
            this.mLocalViewShow.setVisibility(8);
        }
        if (this.mWebView != null && url != null) {
            this.mWebView.loadUrl(url);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    private void findViews() {
        if (this.mVoiceDetailView != null) {
            this.mTitleBar = (BNCommonTitleBar) this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_title_bar);
            this.mLocalViewInfo = (RelativeLayout) this.mVoiceDetailView.findViewById(C4048R.id.local_voice_detail_info);
            this.mLocalViewShow = (RelativeLayout) this.mVoiceDetailView.findViewById(C4048R.id.local_voice_detail_info_show);
            this.mNetViewInfo = (RelativeLayout) this.mVoiceDetailView.findViewById(C4048R.id.net_voice_detail_info);
            this.mHeadView = (ImageView) this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_head_view);
            this.mNameText = (TextView) this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_name);
            this.mTagText = (TextView) this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_tag);
            this.mSizeText = (TextView) this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_size);
            this.mEditText = (TextView) this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_edit);
            this.mDivider = this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_divider);
            this.mImageEarth = (ImageView) this.mVoiceDetailView.findViewById(C4048R.id.local_voice_info_earth);
            this.mImageHeadView = (ImageView) this.mVoiceDetailView.findViewById(C4048R.id.local_voice_info_headview);
            this.mImagePlay = (ImageView) this.mVoiceDetailView.findViewById(C4048R.id.local_voice_info_play);
            this.mLoadingFailLayout = this.mVoiceDetailView.findViewById(C4048R.id.voice_square_loading_fail_layout);
            this.mProgressBar = (ProgressBar) this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_progress_bar);
            this.mWebView = (WebView) this.mVoiceDetailView.findViewById(C4048R.id.voice_detail_webview);
            this.mTitleBar.setMiddleTextSize(18.0f);
            this.mTitleBar.setRightIcon(JarUtils.getResources().getDrawable(C4048R.drawable.voice_navi_share_icon));
            if (BNaviModuleManager.isGooglePlayChannel()) {
                this.mTitleBar.setRightIconVisible(false);
                this.mTitleBar.setRightTextVisible(false);
            } else {
                this.mTitleBar.setRightIconVisible(true);
            }
            this.mTitleBar.setLeftOnClickedListener(new C45352());
            if (!BNaviModuleManager.isGooglePlayChannel()) {
                this.mTitleBar.setRightOnClickedListener(new C45363());
            }
            this.mEditText.setOnClickListener(new C45374());
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
            settings.setUserAgentString("baidumap_ANDR");
            settings.setSupportMultipleWindows(true);
            settings.setCacheMode(2);
            this.mWebView.addJavascriptInterface(new VoiceDetailView$JavaScriptInterface(this), "bdnavi");
            this.mWebView.setWebViewClient(new C45385());
            this.mWebView.setWebChromeClient(new C45396());
            this.mImagePlay.setOnClickListener(new C45407());
            this.mLoadingFailLayout.setVisibility(8);
            this.mLoadingFailLayout.setOnClickListener(new C45418());
        }
    }

    private void stopWebVoice(WebView wevView) {
        if (wevView != null) {
            wevView.loadUrl("javascript:stopListen()");
        }
    }

    private void stopPlayAudio() {
        if (this.mPlay) {
            this.mImagePlay.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_detail_play));
            if (!(this.mVoicePaths == null || this.mVoicePaths.isEmpty())) {
                VoicePlayController.getInstance().stopAllVoice();
            }
            this.mPlay = false;
        }
    }

    private void startPlayAudio() {
        if (!this.mPlay) {
            this.mImagePlay.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_detail_pause));
            if (!(this.mVoicePaths == null || this.mVoicePaths.isEmpty())) {
                ArrayList<String> paths = new ArrayList();
                for (int i = 0; i < BNVoiceParams.VOICE_RECORD_ORGWORD.length; i++) {
                    if (this.mVoicePaths.containsKey(BNVoiceParams.VOICE_RECORD_ORGWORD[i])) {
                        paths.add((String) this.mVoicePaths.get(BNVoiceParams.VOICE_RECORD_ORGWORD[i]));
                    }
                }
                VoicePlayController.getInstance().playAllVoice(paths);
            }
            this.mPlay = true;
        }
    }

    public void updateUserHeadUrl(String url) {
        this.mHeadUrl = url;
        if (this.mLocalViewInfo != null && this.mLocalViewInfo.getVisibility() == 0 && this.mVoiceInfo != null && this.mVoiceInfo.imageUrl != null) {
            if (!TextUtils.isEmpty(this.mVoiceInfo.imageUrl) && !this.mVoiceInfo.imageUrl.trim().equals("url")) {
                this.mHeadView.setImageDrawable(UrlDrawable.getDrawable(this.mVoiceInfo.imageUrl.trim()));
                this.mImageHeadView.setImageDrawable(UrlDrawable.getDrawable(this.mVoiceInfo.imageUrl.trim()));
            } else if (this.mHeadUrl != null) {
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "detail view updateUserHeadUrl " + url);
                this.mHeadView.setImageDrawable(UrlDrawable.getDrawable(this.mHeadUrl.trim()));
                this.mImageHeadView.setImageDrawable(UrlDrawable.getDrawable(this.mHeadUrl.trim()));
            } else {
                this.mHeadView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_common_head_view));
                this.mImageHeadView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_common_head_view));
            }
        }
    }

    private void handleCancelUpdateToServer() {
        if (this.mVoiceInfo.taskId != null) {
            VoiceHelper.getInstance().cancelUpdateToServer(this.mVoiceInfo.taskId);
        }
    }

    public void handleUpdateToServerState(int state) {
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "handle test2 update  = " + state);
        if (state == 0) {
            TipTool.onCreateToastDialog(this.mActivity, "上传语音包");
            showWaitingLoading();
        } else if (state == 2) {
            TipTool.onCreateToastDialog(this.mActivity, "上传成功");
            dismissWaitingLoading();
            String oldTaskId = this.mVoiceInfo.taskId;
            this.mVoiceInfo = VoiceHelper.getInstance().getVoiceInfo(this.mVoiceInfo.taskId);
            this.mVoicePaths = VoiceHelper.getInstance().getRecordVoiceDetailInfo(this.mVoiceInfo.taskId);
            if (oldTaskId.equals(VoiceHelper.getInstance().getCurrentUsedTTSId())) {
                BNSettingManager.setVoiceTaskId(this.mVoiceInfo.taskId);
            }
            VoiceHelper.getInstance().shareWithoutUpload(this.mVoiceInfo);
        } else if (state == 4) {
            TipTool.onCreateToastDialog(this.mActivity, "网络错误");
            dismissWaitingLoading();
        } else if (state == 5) {
            TipTool.onCreateToastDialog(this.mActivity, "上传失败");
            dismissWaitingLoading();
        }
    }

    public void onUpdateOrientation(int orientation) {
        if (this.mImageEarth != null && this.mImageEarth.getVisibility() == 0) {
            this.mImageEarth.getViewTreeObserver().addOnGlobalLayoutListener(new C45429());
        }
    }

    public boolean onBackPressed() {
        if (this.mNetViewInfo == null || this.mNetViewInfo.getVisibility() != 0) {
            if (this.mLocalViewShow != null && this.mLocalViewShow.getVisibility() == 0) {
                stopPlayAudio();
            }
        } else if (this.mWebView != null) {
            int index = this.mWebView.copyBackForwardList().getCurrentIndex();
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "onBackPressed, BackForwardList index=" + index);
            if (index > 0 && this.mWebView.canGoBack()) {
                this.mWebView.goBack();
                return false;
            }
        }
        return super.onBackPressed();
    }

    private void showWaitingLoading() {
        if (this.mActivity != null) {
            dismissWaitingLoading();
            try {
                if (this.mWaitingLoading == null && this.mActivity != null) {
                    this.mWaitingLoading = new BNCommonProgressDialog(this.mActivity);
                    this.mWaitingLoading.setOnCancelListener(new OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            VoiceDetailView.this.handleCancelUpdateToServer();
                        }
                    });
                }
                if (this.mWaitingLoading != null) {
                    this.mWaitingLoading.setMessage("上传中...");
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
}
