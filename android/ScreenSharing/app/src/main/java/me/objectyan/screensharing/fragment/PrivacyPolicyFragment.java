package com.baidu.carlife.fragment;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.baidu.carlife.R;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p078f.C1445i;
import com.baidu.navi.fragment.ContentFragment;

public class PrivacyPolicyFragment extends ContentFragment {
    /* renamed from: a */
    private static final int f4739a = 1;
    /* renamed from: b */
    private C1443g f4740b;
    /* renamed from: c */
    private C1445i f4741c;
    /* renamed from: d */
    private WebView f4742d;
    /* renamed from: e */
    private String f4743e;
    /* renamed from: f */
    private String f4744f;

    /* renamed from: com.baidu.carlife.fragment.PrivacyPolicyFragment$1 */
    class C15661 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PrivacyPolicyFragment f4737a;

        C15661(PrivacyPolicyFragment this$0) {
            this.f4737a = this$0;
        }

        public void onClick(View v) {
            this.f4737a.onBackPressed();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.PrivacyPolicyFragment$2 */
    class C15672 extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ PrivacyPolicyFragment f4738a;

        C15672(PrivacyPolicyFragment this$0) {
            this.f4738a = this$0;
        }

        public void onPageFinished(WebView view, String url) {
            this.f4738a.f4742d.loadUrl("javascript:" + "function addNewStyle(newStyle) {\n    var styleElement = document.getElementById('carlife_style');\n\n    if (!styleElement) {\n        styleElement = document.createElement('style');\n        styleElement.type = 'text/css';\n        styleElement.id = 'carlife_style';\n        document.getElementsByTagName('head')[0].appendChild(styleElement);\n    }\n\n    styleElement.appendChild(document.createTextNode(newStyle));\n}\n\naddNewStyle('\n                header,body,div,.baidu-attention {\n                    background: transparent !important;\n                    border-color:#111217 !important\n                }\n                body,div,header,.baidu-attention{\n                    color:white !important\n                }\n            ');");
        }
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4740b == null) {
                this.f4740b = new C1443g(this.mContentView.findViewById(R.id.title_bar), 2);
                this.f4740b.m5300d(this.mContentView.findViewById(R.id.ib_left));
            }
            if (this.f4741c == null) {
                this.f4741c = new C1445i(this.f4742d, 4);
            }
            C1440d.m5251a().m5256b(this.f4740b, this.f4741c);
            C1440d.m5251a().m5268h(this.f4740b);
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        setBottomBarStatus(false);
        this.mContentView = inflater.inflate(R.layout.frag_setting_service, null);
        if (this.mShowBundle != null) {
            this.f4743e = this.mShowBundle.getString(WebViewFragment.f4861a, "");
            this.f4744f = this.mShowBundle.getString(WebViewFragment.f4862b, "");
        }
        setCommonTitleBar(this.mContentView, this.f4743e);
        ImageButton btnBack = (ImageButton) this.mContentView.findViewById(R.id.ib_left);
        if (btnBack != null) {
            btnBack.setOnClickListener(new C15661(this));
        }
        m5775a();
        return this.mContentView;
    }

    /* renamed from: a */
    private void m5775a() {
        this.f4742d = (WebView) this.mContentView.findViewById(R.id.wv_service_terms);
        this.f4742d.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f4742d.removeJavascriptInterface("accessibility");
        this.f4742d.removeJavascriptInterface("accessibilityTraversal");
        this.f4742d.setBackgroundColor(0);
        this.f4742d.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        this.f4742d.getSettings().setSupportZoom(true);
        this.f4742d.getSettings().setBuiltInZoomControls(true);
        this.f4742d.getSettings().setLoadWithOverviewMode(true);
        this.f4742d.getSettings().setJavaScriptEnabled(true);
        this.f4742d.getSettings().setAppCacheEnabled(false);
        this.f4742d.setWebViewClient(new C15672(this));
        this.f4742d.loadUrl(this.f4744f);
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    protected void onInitView() {
    }

    public boolean onBackPressed() {
        m5776b();
        return true;
    }

    /* renamed from: b */
    private void m5776b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("firstEnter", true);
        bundle.putInt("index", 1);
        showFragment(516, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        m5777c();
        if (VERSION.SDK_INT <= 16) {
            removeAllFragmentByType(517);
        } else if (mActivity != null && !mActivity.isDestroyed()) {
            removeAllFragmentByType(517);
        }
    }

    /* renamed from: c */
    private void m5777c() {
        if (this.f4742d != null) {
            this.f4742d.removeAllViews();
            if (this.f4742d.getParent() != null) {
                ((ViewGroup) this.f4742d.getParent()).removeView(this.f4742d);
            }
            this.f4742d.setTag(null);
            this.f4742d.clearHistory();
            this.f4742d.setVisibility(8);
            this.f4742d.destroy();
            this.f4742d = null;
        }
    }
}
