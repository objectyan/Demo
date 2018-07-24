package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.R;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.C1710a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.fragment.ContentFragment;

public class AuthorizationRequestHelpFragment extends ContentFragment implements OnClickListener {
    /* renamed from: a */
    private C1443g f4232a;

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.frag_authorization_request_help, null);
        setCommonTitleBar(this.mContentView, getResources().getString(R.string.auth_title));
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
            case R.id.btn_check_version:
                C1710a.m6207a().m6255a(false);
                return;
            case R.id.btn_service_terms:
                showFragment(540, null);
                return;
            default:
                return;
        }
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4232a == null) {
                this.f4232a = new C1443g(this.mContentView.findViewById(R.id.title_bar), 2);
                this.f4232a.m5300d(this.mContentView.findViewById(R.id.ib_left));
            }
            C1440d focusManager = C1440d.m5251a();
            focusManager.m5256b(this.f4232a);
            focusManager.m5268h(this.f4232a);
        }
    }

    public void driving() {
        LogUtil.d("yftech", "CarModeOfflineDataFragment driving");
        if (C1343b.m4932a().m4935b()) {
            back();
            back();
            back();
        }
    }
}
