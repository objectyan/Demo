package com.baidu.sapi2;

import com.baidu.sapi2.shell.response.SapiAccountResponse;

class SapiWebView$AuthorizedResponseInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20098a;

    /* renamed from: com.baidu.sapi2.SapiWebView$AuthorizedResponseInterpreter$1 */
    class C48611 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$AuthorizedResponseInterpreter f20094a;

        C48611(SapiWebView$AuthorizedResponseInterpreter sapiWebView$AuthorizedResponseInterpreter) {
            this.f20094a = sapiWebView$AuthorizedResponseInterpreter;
        }

        public void run() {
            SapiWebView.k(this.f20094a.f20098a).onFailed(-100, "登录失败");
        }
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$AuthorizedResponseInterpreter$2 */
    class C48622 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$AuthorizedResponseInterpreter f20095a;

        C48622(SapiWebView$AuthorizedResponseInterpreter sapiWebView$AuthorizedResponseInterpreter) {
            this.f20095a = sapiWebView$AuthorizedResponseInterpreter;
        }

        public void run() {
            SapiWebView.k(this.f20095a.f20098a).onFailed(-100, "登录失败");
        }
    }

    SapiWebView$AuthorizedResponseInterpreter(SapiWebView sapiWebView) {
        this.f20098a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        SapiAccountResponse response;
        int type = 0;
        String xml = (String) command.getActionParams().get(0);
        if (command.getActionParams().size() == 2) {
            type = Integer.parseInt((String) command.getActionParams().get(1));
        }
        if (type == 1) {
            response = SapiWebView.b(xml);
            if (response == null) {
                if (SapiWebView.k(this.f20098a) != null) {
                    this.f20098a.post(new C48611(this));
                }
            } else if (response.offlineNotice || response.bindGuide || response.errorCode == 21) {
                SapiWebView.b(this.f20098a, response);
            } else {
                SapiWebView.a(this.f20098a, response);
            }
        }
        if (type == 0) {
            response = SapiWebView.a(xml);
            if (response == null) {
                if (SapiWebView.k(this.f20098a) != null) {
                    this.f20098a.post(new C48622(this));
                }
            } else if (SapiWebView.C(this.f20098a) != null && response.newReg) {
                SapiWebView.b(this.f20098a, response);
                SapiWebView.c(this.f20098a, response);
            } else if (response.errorCode == 0 || response.errorCode == 110000) {
                SapiWebView.a(this.f20098a, response);
            } else if (SapiWebView.k(this.f20098a) != null) {
                this.f20098a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ SapiWebView$AuthorizedResponseInterpreter f20097b;

                    public void run() {
                        SapiWebView.k(this.f20097b.f20098a).onFailed(response.errorCode, response.errorMsg);
                    }
                });
            }
        }
        return null;
    }
}
