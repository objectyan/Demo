package com.baidu.sapi2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.carlife.C0965R;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.WebviewUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;

public class LoginActivity extends Activity {
    private static final String REDIRECT = "oob";
    private SapiWebView sapiWebView;

    /* renamed from: com.baidu.sapi2.LoginActivity$1 */
    class C48411 implements SapiWebView$OnFinishCallback {
        C48411() {
        }

        public void onFinish() {
            LoginActivity.this.finish();
        }
    }

    /* renamed from: com.baidu.sapi2.LoginActivity$2 */
    class C48422 extends AuthorizationListener {
        C48422() {
        }

        public void onSuccess() {
            TipTool.onCreateToastDialog(LoginActivity.this, LoginActivity.this.getString(C0965R.string.login_success));
            NaviAccountUtils.getInstance().onLoginResult(true);
            LoginActivity.this.dealWithPushByUser();
            LoginActivity.this.finish();
        }

        public void onFailed(int errorNo, String errorMsg) {
            TipTool.onCreateToastDialog(LoginActivity.this, LoginActivity.this.getString(C0965R.string.login_fail));
            NaviAccountUtils.getInstance().onLoginResult(false);
            LoginActivity.this.finish();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sapiWebView = new SapiWebView(this);
        setContentView(this.sapiWebView);
        setupViews();
    }

    protected void setupViews() {
        SapiWebViewUtil.addCustomView(this, this.sapiWebView);
        this.sapiWebView.setOnFinishCallback(new C48411());
        this.sapiWebView.setAuthorizationListener(new C48422());
        this.sapiWebView.loadLogin();
    }

    private void dealWithPushByUser() {
    }

    protected void onResume() {
        super.onResume();
        WebviewUtils.resumeWebview(this.sapiWebView);
    }

    protected void onPause() {
        super.onPause();
        WebviewUtils.pauseWebview(this.sapiWebView);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.sapiWebView.onAuthorizedResult(requestCode, resultCode, data);
    }
}
