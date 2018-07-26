package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelItem implements Parcelable {
    public static final Creator<ParcelItem> CREATOR = new C48371();
    private Bundle mBundle;

    /* renamed from: com.baidu.platform.comjni.tools.ParcelItem$1 */
    static class C48371 implements Creator<ParcelItem> {
        C48371() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16043a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16044a(i);
        }

        /* renamed from: a */
        public ParcelItem m16043a(Parcel source) {
            ParcelItem person = new ParcelItem();
            person.setBundle(source.readBundle());
            return person;
        }

        /* renamed from: a */
        public ParcelItem[] m16044a(int size) {
            return new ParcelItem[size];
        }
    }

    public void setBundle(Bundle b) {
        this.mBundle = b;
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(this.mBundle);
    }

    public int describeContents() {
        return 0;
    }
}
