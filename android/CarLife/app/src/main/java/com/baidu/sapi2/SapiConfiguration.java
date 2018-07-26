package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.Switch;
import java.util.List;

public final class SapiConfiguration {
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CUSTOM = 3;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;
    /* renamed from: a */
    private final LoginShareStrategy f20038a;
    public final String appId;
    public final String appSignKey;
    public String clientId;
    public String clientIp;
    public final Switch configurableViewLayout;
    public final Context context;
    public final boolean customActionBarEnabled;
    public final boolean debug;
    public final String deviceLoginSignKey;
    public final Domain environment;
    public final String faceAppName;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public final boolean fastRegConfirm;
    public final String fastRegConfirmMsg;
    public final String fastRegTitleText;
    public final String hwAppId;
    public String presetPhoneNumber;
    public final String qqAppID;
    public final boolean quickUserEnabled;
    public final RegistMode registMode;
    public final boolean showRegLink;
    public final boolean silentShareOnUpgrade;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final boolean syncCacheOnInit;
    public final String tpl;
    public final boolean uniteVerify;
    public final String voicePid;
    public final String wxAppID;

    public static class SmsLoginConfig {
        public final Switch flagLoginBtnType;
        public final Switch flagShowFastRegLink;
        public final Switch flagShowLoginLink;
        public final Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch flagShowLoginLink, Switch flagShowSmsLoginLink, @Deprecated Switch flagLoginBtnType) {
            if (flagShowLoginLink == null) {
                flagShowLoginLink = Switch.OFF;
            }
            if (flagShowSmsLoginLink == null) {
                flagShowSmsLoginLink = Switch.OFF;
            }
            if (flagLoginBtnType == null) {
                flagLoginBtnType = Switch.OFF;
            }
            this.flagShowLoginLink = flagShowLoginLink;
            this.flagShowSmsLoginLink = flagShowSmsLoginLink;
            this.flagLoginBtnType = flagLoginBtnType;
            this.flagShowFastRegLink = Switch.OFF;
        }

        public SmsLoginConfig(Switch flagShowLoginLink, Switch flagShowSmsLoginLink, @Deprecated Switch flagLoginBtnType, Switch flagShowFastRegLink) {
            if (flagShowLoginLink == null) {
                flagShowLoginLink = Switch.OFF;
            }
            if (flagShowSmsLoginLink == null) {
                flagShowSmsLoginLink = Switch.OFF;
            }
            if (flagLoginBtnType == null) {
                flagLoginBtnType = Switch.OFF;
            }
            if (flagShowFastRegLink == null) {
                flagShowFastRegLink = Switch.OFF;
            }
            this.flagShowLoginLink = flagShowLoginLink;
            this.flagShowSmsLoginLink = flagShowSmsLoginLink;
            this.flagLoginBtnType = flagLoginBtnType;
            this.flagShowFastRegLink = flagShowFastRegLink;
        }
    }

    private SapiConfiguration(SapiConfiguration$Builder builder) {
        this.voicePid = "2048";
        this.context = SapiConfiguration$Builder.a(builder);
        this.tpl = SapiConfiguration$Builder.b(builder);
        this.appId = SapiConfiguration$Builder.c(builder);
        this.appSignKey = SapiConfiguration$Builder.d(builder);
        this.deviceLoginSignKey = SapiConfiguration$Builder.e(builder);
        this.environment = SapiConfiguration$Builder.f(builder);
        this.socialBindType = SapiConfiguration$Builder.g(builder);
        this.registMode = SapiConfiguration$Builder.h(builder);
        this.f20038a = SapiConfiguration$Builder.i(builder);
        this.fastLoginFeatureList = SapiConfiguration$Builder.j(builder);
        this.wxAppID = SapiConfiguration$Builder.k(builder);
        this.hwAppId = SapiConfiguration$Builder.l(builder);
        this.qqAppID = SapiConfiguration$Builder.m(builder);
        this.fastRegConfirm = SapiConfiguration$Builder.n(builder);
        this.fastRegConfirmMsg = SapiConfiguration$Builder.o(builder);
        this.skin = SapiConfiguration$Builder.p(builder);
        this.presetPhoneNumber = SapiConfiguration$Builder.q(builder);
        this.customActionBarEnabled = SapiConfiguration$Builder.r(builder);
        this.showRegLink = SapiConfiguration$Builder.s(builder);
        this.configurableViewLayout = SapiConfiguration$Builder.t(builder);
        this.fastRegTitleText = SapiConfiguration$Builder.u(builder);
        this.debug = SapiConfiguration$Builder.v(builder);
        this.smsLoginConfig = SapiConfiguration$Builder.w(builder);
        this.uniteVerify = SapiConfiguration$Builder.x(builder);
        this.syncCacheOnInit = SapiConfiguration$Builder.y(builder);
        this.silentShareOnUpgrade = SapiConfiguration$Builder.z(builder);
        this.quickUserEnabled = SapiConfiguration$Builder.A(builder);
        this.faceAppName = SapiConfiguration$Builder.B(builder);
    }

    public LoginShareStrategy loginShareStrategy() {
        if (this.quickUserEnabled) {
            return LoginShareStrategy.DISABLED;
        }
        C4894c options = C4891b.m16250a(this.context).m16288j();
        if (options.m16316c().containsKey(this.tpl) && options.m16316c().get(this.tpl) != null) {
            return (LoginShareStrategy) options.m16316c().get(this.tpl);
        }
        if (options.m16315b() != null) {
            return options.m16315b();
        }
        return this.f20038a;
    }
}
