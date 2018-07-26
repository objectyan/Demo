package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiConfiguration.SmsLoginConfig;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.Switch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SapiConfiguration$Builder {
    /* renamed from: A */
    private boolean f12763A = false;
    /* renamed from: B */
    private String f12764B;
    /* renamed from: a */
    private Context f12765a;
    /* renamed from: b */
    private String f12766b;
    /* renamed from: c */
    private String f12767c;
    /* renamed from: d */
    private String f12768d;
    /* renamed from: e */
    private String f12769e;
    /* renamed from: f */
    private Domain f12770f;
    /* renamed from: g */
    private BindType f12771g;
    /* renamed from: h */
    private RegistMode f12772h;
    /* renamed from: i */
    private LoginShareStrategy f12773i;
    /* renamed from: j */
    private List<FastLoginFeature> f12774j;
    /* renamed from: k */
    private String f12775k;
    /* renamed from: l */
    private String f12776l;
    /* renamed from: m */
    private String f12777m;
    /* renamed from: n */
    private boolean f12778n = false;
    /* renamed from: o */
    private String f12779o;
    /* renamed from: p */
    private String f12780p;
    /* renamed from: q */
    private String f12781q;
    /* renamed from: r */
    private boolean f12782r = false;
    /* renamed from: s */
    private boolean f12783s = true;
    /* renamed from: t */
    private Switch f12784t = Switch.OFF;
    /* renamed from: u */
    private String f12785u;
    /* renamed from: v */
    private boolean f12786v = false;
    /* renamed from: w */
    private SmsLoginConfig f12787w;
    /* renamed from: x */
    private boolean f12788x = false;
    /* renamed from: y */
    private boolean f12789y = true;
    /* renamed from: z */
    private boolean f12790z = true;

    public SapiConfiguration$Builder(Context context) {
        this.f12765a = context.getApplicationContext();
    }

    public SapiConfiguration$Builder setProductLineInfo(String tpl, String appId, String appSignKey) {
        this.f12766b = tpl;
        this.f12767c = appId;
        this.f12768d = appSignKey;
        return this;
    }

    @Deprecated
    public SapiConfiguration$Builder setDeviceLoginSignKey(String deviceLoginSignKey) {
        this.f12769e = deviceLoginSignKey;
        return this;
    }

    public SapiConfiguration$Builder setRuntimeEnvironment(Domain domain) {
        this.f12770f = domain;
        return this;
    }

    public SapiConfiguration$Builder setSocialBindType(BindType bindType) {
        this.f12771g = bindType;
        return this;
    }

    public SapiConfiguration$Builder registMode(RegistMode registMode) {
        this.f12772h = registMode;
        return this;
    }

    public SapiConfiguration$Builder presetPhoneNumber(String presetPhoneNumber) {
        this.f12781q = presetPhoneNumber;
        return this;
    }

    public SapiConfiguration$Builder showRegLink(boolean showRegLink) {
        this.f12783s = showRegLink;
        return this;
    }

    public SapiConfiguration$Builder configurableViewLayout(Switch configurableViewLayout) {
        this.f12784t = configurableViewLayout;
        return this;
    }

    public SapiConfiguration$Builder fastRegTitleText(String fastRegTitleText) {
        this.f12785u = fastRegTitleText;
        return this;
    }

    public SapiConfiguration$Builder debug(boolean isDebug) {
        this.f12786v = isDebug;
        return this;
    }

    public SapiConfiguration$Builder syncCacheOnInit(boolean syncCacheOnInit) {
        this.f12789y = syncCacheOnInit;
        return this;
    }

    public SapiConfiguration$Builder silentShareOnUpgrade(boolean silentShareOnUpgrade) {
        this.f12790z = silentShareOnUpgrade;
        return this;
    }

    public SapiConfiguration$Builder initialShareStrategy(LoginShareStrategy strategy) {
        this.f12773i = strategy;
        return this;
    }

    public SapiConfiguration$Builder fastLoginSupport(FastLoginFeature... fastLoginFeatures) {
        this.f12774j = new ArrayList();
        if (fastLoginFeatures != null) {
            Collections.addAll(this.f12774j, fastLoginFeatures);
        }
        return this;
    }

    public SapiConfiguration$Builder wxAppID(String wxAppID) {
        this.f12775k = wxAppID;
        return this;
    }

    public SapiConfiguration$Builder hwAppID(String hwAppID) {
        this.f12776l = hwAppID;
        return this;
    }

    public SapiConfiguration$Builder qqAppID(String qqAppID) {
        this.f12777m = qqAppID;
        return this;
    }

    public SapiConfiguration$Builder fastRegConfirm(boolean fastRegConfirm) {
        this.f12778n = fastRegConfirm;
        return this;
    }

    public SapiConfiguration$Builder fastRegConfirmMsg(String fastRegConfirmMsg) {
        this.f12779o = fastRegConfirmMsg;
        return this;
    }

    public SapiConfiguration$Builder skin(String skin) {
        this.f12780p = skin;
        return this;
    }

    public SapiConfiguration$Builder customActionBar(boolean enabled) {
        this.f12782r = enabled;
        return this;
    }

    public SapiConfiguration$Builder enableQuickUser(boolean enabled) {
        this.f12763A = enabled;
        return this;
    }

    public SapiConfiguration$Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
        this.f12787w = smsLoginConfig;
        return this;
    }

    public SapiConfiguration$Builder uniteVerify(boolean uniteVerify) {
        this.f12788x = uniteVerify;
        return this;
    }

    public SapiConfiguration$Builder setFaceAppName(String faceAppName) {
        this.f12764B = faceAppName;
        return this;
    }

    public SapiConfiguration build() {
        if (TextUtils.isEmpty(this.f12766b) || TextUtils.isEmpty(this.f12767c) || TextUtils.isEmpty(this.f12768d)) {
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        }
        if (this.f12770f == null) {
            this.f12770f = Domain.DOMAIN_ONLINE;
        }
        if (this.f12771g == null) {
            this.f12771g = BindType.IMPLICIT;
        }
        if (this.f12772h == null) {
            this.f12772h = RegistMode.NORMAL;
        }
        if (this.f12773i == null) {
            this.f12773i = LoginShareStrategy.getDefault();
        }
        if (this.f12774j == null) {
            this.f12774j = new ArrayList();
        }
        if (this.f12787w == null) {
            this.f12787w = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
        }
        if (this.f12784t == null) {
            this.f12784t = Switch.OFF;
        }
        C4913L.enable(this.f12786v);
        return new SapiConfiguration(this, null);
    }
}
