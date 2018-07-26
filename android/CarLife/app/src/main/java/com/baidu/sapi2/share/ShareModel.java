package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.List;

class ShareModel implements Parcelable {
    public static final Creator<ShareModel> CREATOR = new C48951();
    /* renamed from: a */
    private SapiAccount f20459a;
    /* renamed from: b */
    private List<SapiAccount> f20460b;
    /* renamed from: c */
    private ShareEvent f20461c;
    /* renamed from: d */
    private String f20462d;
    /* renamed from: e */
    private LoginShareStrategy f20463e;

    /* renamed from: com.baidu.sapi2.share.ShareModel$1 */
    static class C48951 implements Creator<ShareModel> {
        C48951() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m16321a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m16322a(x0);
        }

        /* renamed from: a */
        public ShareModel m16321a(Parcel source) {
            return new ShareModel(source);
        }

        /* renamed from: a */
        public ShareModel[] m16322a(int size) {
            return new ShareModel[size];
        }
    }

    ShareModel() {
        this.f20460b = new ArrayList();
    }

    ShareModel(Parcel parcel) {
        this.f20460b = new ArrayList();
        m16323a(parcel);
    }

    ShareModel(ShareEvent event) {
        this.f20460b = new ArrayList();
        this.f20461c = event;
    }

    ShareModel(ShareEvent event, SapiAccount currentAccount) {
        this(event);
        this.f20459a = currentAccount;
    }

    ShareModel(ShareEvent event, SapiAccount currentAccount, List<SapiAccount> shareAccounts) {
        this(event, currentAccount);
        this.f20460b = shareAccounts;
    }

    /* renamed from: a */
    List<SapiAccount> m16324a() {
        return this.f20460b;
    }

    /* renamed from: a */
    void m16330a(List<SapiAccount> shareAccounts) {
        if (shareAccounts != null) {
            this.f20460b = shareAccounts;
        }
    }

    /* renamed from: a */
    void m16328a(LoginShareStrategy senderStrategy) {
        this.f20463e = senderStrategy;
    }

    /* renamed from: a */
    void m16327a(ShareEvent event) {
        this.f20461c = event;
    }

    /* renamed from: b */
    ShareEvent m16331b() {
        return this.f20461c;
    }

    /* renamed from: a */
    void m16326a(SapiAccount currentAccount) {
        this.f20459a = currentAccount;
    }

    /* renamed from: c */
    String m16333c() {
        return this.f20462d;
    }

    /* renamed from: a */
    void m16329a(String from) {
        this.f20462d = from;
    }

    /* renamed from: a */
    private void m16323a(Parcel parcel) {
        this.f20461c = (ShareEvent) parcel.readSerializable();
        parcel.readTypedList(this.f20460b, SapiAccount.CREATOR);
        this.f20459a = (SapiAccount) parcel.readParcelable(SapiAccount.class.getClassLoader());
        this.f20463e = (LoginShareStrategy) parcel.readSerializable();
        this.f20462d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.f20461c);
        dest.writeTypedList(this.f20460b);
        dest.writeParcelable(this.f20459a, flags);
        dest.writeSerializable(this.f20463e);
        dest.writeString(this.f20462d);
    }

    /* renamed from: a */
    void m16325a(Context context) {
        List encryptedAccounts = new ArrayList();
        for (SapiAccount account : m16324a()) {
            encryptedAccounts.add(C4909b.m16352a(context, account));
        }
        m16330a(encryptedAccounts);
        if (this.f20459a != null) {
            this.f20459a = C4909b.m16352a(context, this.f20459a);
        }
        if (!TextUtils.isEmpty(this.f20462d)) {
            this.f20462d = C4909b.m16354a(context, this.f20462d);
        }
    }

    /* renamed from: b */
    void m16332b(Context context) {
        List decryptedAccounts = new ArrayList();
        for (SapiAccount account : m16324a()) {
            decryptedAccounts.add(C4909b.m16355b(context, account));
        }
        m16330a(decryptedAccounts);
        if (this.f20459a != null) {
            this.f20459a = C4909b.m16355b(context, this.f20459a);
        }
        if (!TextUtils.isEmpty(this.f20462d)) {
            this.f20462d = C4909b.m16356b(context, this.f20462d);
        }
    }

    public String toString() {
        return "ShareModel{currentAccount=" + this.f20459a + ", shareAccounts=" + this.f20460b + ", event=" + this.f20461c + ", from='" + this.f20462d + '\'' + ", senderStrategy=" + this.f20463e + '}';
    }
}
