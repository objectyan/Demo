package com.baidu.carlife.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.logic.C1766h;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView$OnFinishCallback;
import com.baidu.sapi2.shell.listener.AuthorizationListener;

public class LoginFragment extends ContentFragment {
    /* renamed from: a */
    private SapiWebView f4545a;

    /* renamed from: com.baidu.carlife.fragment.LoginFragment$1 */
    class C15241 implements SapiWebView$OnFinishCallback {
        /* renamed from: a */
        final /* synthetic */ LoginFragment f4543a;

        C15241(LoginFragment this$0) {
            this.f4543a = this$0;
        }

        public void onFinish() {
            this.f4543a.back();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.LoginFragment$2 */
    class C15252 extends AuthorizationListener {
        /* renamed from: a */
        final /* synthetic */ LoginFragment f4544a;

        C15252(LoginFragment this$0) {
            this.f4544a = this$0;
        }

        public void onSuccess() {
            C2201w.m8372a(StyleManager.getString(C0965R.string.login_success));
            NaviAccountUtils.getInstance().onLoginResult(true);
            this.f4544a.back();
            NaviAccountUtils.getInstance().asyncGetUserInfo();
            C1766h.f5368b = true;
            StatisticManager.onEvent(StatisticConstants.HOME_MY_LOGIN, StatisticConstants.HOME_MY_LOGIN);
            StatisticManager.onEvent(StatisticConstants.HOME_MINE_0002);
        }

        public void onFailed(int errorNo, String errorMsg) {
            C2201w.m8372a(StyleManager.getString(C0965R.string.login_fail));
            NaviAccountUtils.getInstance().onLoginResult(false);
            this.f4544a.back();
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(C0965R.layout.frag_login, null);
        this.f4545a = (SapiWebView) contentView.findViewById(C0965R.id.sapi_webview);
        this.f4545a.setOnFinishCallback(new C15241(this));
        this.f4545a.setAuthorizationListener(new C15252(this));
        this.f4545a.loadSmsLogin();
        setBottomBarStatus(false);
        return contentView;
    }

    public void onDestroy() {
        super.onDestroy();
        setBottomBarStatus(true);
    }

    public void back() {
        if (this.mModuleFrom == 3) {
            super.back();
            showLatestNaviFragment();
            return;
        }
        super.back();
    }

    public boolean onBackPressed() {
        back();
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.f4545a.onAuthorizedResult(requestCode, resultCode, data);
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void driving() {
        C1260i.m4435b("yftech", "LoginFragment driving");
        back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
    }
}
