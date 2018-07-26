package com.baidu.platform.comapi.util;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelItem implements Parcelable {
    public static final Creator<ParcelItem> CREATOR = new C47901();
    /* renamed from: a */
    private Bundle f19872a;

    /* renamed from: com.baidu.platform.comapi.util.ParcelItem$1 */
    static class C47901 implements Creator<ParcelItem> {
        C47901() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m15880a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m15881a(i);
        }

        /* renamed from: a */
        public ParcelItem m15880a(Parcel source) {
            ParcelItem person = new ParcelItem();
            person.m15883a(source.readBundle());
            return person;
        }

        /* renamed from: a */
        public ParcelItem[] m15881a(int size) {
            return new ParcelItem[size];
        }
    }

    /* renamed from: a */
    public Bundle m15882a() {
        return this.f19872a;
    }

    /* renamed from: a */
    public void m15883a(Bundle b) {
        this.f19872a = b;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(this.f19872a);
    }

    public int describeContents() {
        return 0;
    }
}
