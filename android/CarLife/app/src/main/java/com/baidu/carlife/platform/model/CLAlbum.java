package com.baidu.carlife.platform.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CLAlbum
  implements Parcelable
{
  public static final Parcelable.Creator<CLAlbum> CREATOR = new Parcelable.Creator()
  {
    public CLAlbum createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CLAlbum(paramAnonymousParcel);
    }
    
    public CLAlbum[] newArray(int paramAnonymousInt)
    {
      return new CLAlbum[paramAnonymousInt];
    }
  };
  public String albumId;
  public String albumName;
  public String artistId;
  public String artistName;
  public String coverUrl;
  public int songCount;
  
  public CLAlbum() {}
  
  public CLAlbum(Parcel paramParcel)
  {
    this.albumId = paramParcel.readString();
    this.albumName = paramParcel.readString();
    this.artistId = paramParcel.readString();
    this.artistName = paramParcel.readString();
    this.coverUrl = paramParcel.readString();
    this.songCount = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.albumId);
    paramParcel.writeString(this.albumName);
    paramParcel.writeString(this.artistId);
    paramParcel.writeString(this.artistName);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeInt(this.songCount);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/model/CLAlbum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */