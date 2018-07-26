package com.baidu.sapi2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.carlife.C0965R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.WebviewUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;

public class RegisterActivity extends Activity {
    private SapiWebView sapiWebView;

    /* renamed from: com.baidu.sapi2.RegisterActivity$1 */
    class C48431 implements SapiWebView$OnFinishCallback {
        C48431() {
        }

        public void onFinish() {
            RegisterActivity.this.finish();
        }
    }

    /* renamed from: com.baidu.sapi2.RegisterActivity$2 */
    class C48442 extends AuthorizationListener {
        C48442() {
        }

        public void onSuccess() {
            TipTool.onCreateToastDialog(RegisterActivity.this, RegisterActivity.this.getString(C0965R.string.login_success));
            RegisterActivity.this.finish();
        }

        public void onFailed(int errorNo, String errorMsg) {
            TipTool.onCreateToastDialog(RegisterActivity.this, RegisterActivity.this.getString(C0965R.string.login_fail));
            RegisterActivity.this.finish();
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
        this.sapiWebView.setOnFinishCallback(new C48431());
        this.sapiWebView.setAuthorizationListener(new C48442());
        this.sapiWebView.loadRegist();
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
