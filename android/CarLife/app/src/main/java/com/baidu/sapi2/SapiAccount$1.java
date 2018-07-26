package com.baidu.sapi2;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SapiAccount$1 implements Creator<SapiAccount> {
    SapiAccount$1() {
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m16057a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m16058a(x0);
    }

    /* renamed from: a */
    public SapiAccount m16057a(Parcel source) {
        return new SapiAccount(source);
    }

    /* renamed from: a */
    public SapiAccount[] m16058a(int size) {
        return new SapiAccount[size];
    }
}
