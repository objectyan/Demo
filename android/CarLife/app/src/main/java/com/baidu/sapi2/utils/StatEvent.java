package com.baidu.sapi2.utils;

public enum StatEvent {
    PV_LOGIN("pv_login", C4923f.f20596a),
    OP_LOGIN("num_login_va", C4923f.f20596a),
    PV_SMS_LOGIN("pv_slogin", C4923f.f20616u),
    OP_SMS_LOGIN("num_slogin_va", C4923f.f20616u),
    PV_REG("pv_reg", C4923f.f20603h),
    OP_REG("num_reg_va", C4923f.f20603h),
    PV_QUICK_USER_REG("pv_qreg", C4923f.f20605j),
    OP_QUICK_USER_REG("num_qreg_va", C4923f.f20605j);
    
    /* renamed from: a */
    String f20527a;
    /* renamed from: b */
    String f20528b;

    private StatEvent(String name, String diSituation) {
        this.f20527a = name;
        this.f20528b = diSituation;
    }
}
