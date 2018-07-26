package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p078f.C1445i;
import com.baidu.navi.fragment.ContentFragment;

public class SettingServiceFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private ImageButton f4813a;
    /* renamed from: b */
    private WebView f4814b;
    /* renamed from: c */
    private TextView f4815c;
    /* renamed from: d */
    private C1443g f4816d;
    /* renamed from: e */
    private C1445i f4817e;

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(C0965R.layout.frag_setting_service, null);
        setCommonTitleBar(this.mContentView, getString(C0965R.string.service_terms_title));
        this.f4814b = (WebView) this.mContentView.findViewById(C0965R.id.wv_service_terms);
        this.f4814b.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f4814b.removeJavascriptInterface("accessibility");
        this.f4814b.removeJavascriptInterface("accessibilityTraversal");
        this.f4814b.setBackgroundColor(0);
        this.f4814b.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        this.f4814b.getSettings().setSupportZoom(true);
        this.f4814b.getSettings().setBuiltInZoomControls(true);
        this.f4814b.getSettings().setLoadWithOverviewMode(true);
        this.f4814b.getSettings().setJavaScriptEnabled(true);
        this.f4814b.getSettings().setAppCacheEnabled(false);
        this.f4814b.loadUrl("file:///android_asset/carlifeDisclaimer.html");
        return this.mContentView;
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.ib_left:
                back(null);
                return;
            default:
                return;
        }
    }

    public void driving() {
        C1260i.m4435b("yftech", "SettingServiceFragment driving");
        getNaviFragmentManager().back();
        getNaviFragmentManager().back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4816d == null) {
                this.f4816d = new C1443g(this.mContentView.findViewById(C0965R.id.title_bar), 2);
                this.f4816d.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
            }
            if (this.f4817e == null) {
                this.f4817e = new C1445i(this.f4814b, 4);
            }
            C1440d.m5251a().m5256b(this.f4816d, this.f4817e);
            C1440d.m5251a().m5268h(this.f4816d);
        }
    }
}
