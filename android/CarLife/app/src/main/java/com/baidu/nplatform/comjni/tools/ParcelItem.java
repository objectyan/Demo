package com.baidu.nplatform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelItem implements Parcelable {
    public static final Creator<ParcelItem> CREATOR = new C47431();
    private Bundle mBundle;

    /* renamed from: com.baidu.nplatform.comjni.tools.ParcelItem$1 */
    static class C47431 implements Creator<ParcelItem> {
        C47431() {
        }

        public ParcelItem createFromParcel(Parcel source) {
            ParcelItem person = new ParcelItem();
            person.setBundle(source.readBundle());
            return person;
        }

        public ParcelItem[] newArray(int size) {
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
