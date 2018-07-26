package com.baidu.carlife.platform.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CLAlbum implements Parcelable {
    public static final Creator<CLAlbum> CREATOR = new C20071();
    public String albumId;
    public String albumName;
    public String artistId;
    public String artistName;
    public String coverUrl;
    public int songCount;

    /* renamed from: com.baidu.carlife.platform.model.CLAlbum$1 */
    static class C20071 implements Creator<CLAlbum> {
        C20071() {
        }

        public CLAlbum[] newArray(int size) {
            return new CLAlbum[size];
        }

        public CLAlbum createFromParcel(Parcel source) {
            return new CLAlbum(source);
        }
    }

    public CLAlbum(Parcel p) {
        this.albumId = p.readString();
        this.albumName = p.readString();
        this.artistId = p.readString();
        this.artistName = p.readString();
        this.coverUrl = p.readString();
        this.songCount = p.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.albumId);
        dest.writeString(this.albumName);
        dest.writeString(this.artistId);
        dest.writeString(this.artistName);
        dest.writeString(this.coverUrl);
        dest.writeInt(this.songCount);
    }
}
