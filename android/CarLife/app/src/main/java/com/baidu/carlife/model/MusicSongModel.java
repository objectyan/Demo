package com.baidu.carlife.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.carlife.platform.model.CLSong;

public class MusicSongModel
  implements Parcelable
{
  public static final Parcelable.Creator<MusicSongModel> CREATOR = new Parcelable.Creator()
  {
    public MusicSongModel a(Parcel paramAnonymousParcel)
    {
      return new MusicSongModel(paramAnonymousParcel);
    }
    
    public MusicSongModel[] a(int paramAnonymousInt)
    {
      return new MusicSongModel[paramAnonymousInt];
    }
  };
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public Bitmap h;
  public String i;
  public int j = 0;
  public boolean k;
  public boolean l;
  public String m;
  public long n;
  public long o;
  public String p;
  public int q = -1;
  public int r;
  public int s;
  
  public MusicSongModel() {}
  
  public MusicSongModel(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      this.k = true;
      if (paramParcel.readInt() != 1) {
        break label153;
      }
    }
    label153:
    for (this.l = true;; this.l = false)
    {
      this.m = paramParcel.readString();
      this.n = paramParcel.readLong();
      this.o = paramParcel.readLong();
      this.p = paramParcel.readString();
      return;
      this.k = false;
      break;
    }
  }
  
  public MusicSongModel(CLSong paramCLSong)
  {
    if (paramCLSong != null)
    {
      this.e = paramCLSong.albumArtistId;
      this.f = paramCLSong.albumArtistName;
      this.d = paramCLSong.albumId;
      this.c = paramCLSong.albumName;
      this.g = paramCLSong.coverUrl;
      this.i = paramCLSong.duration;
      this.a = paramCLSong.id;
      this.m = paramCLSong.mediaUrl;
      this.b = paramCLSong.name;
      this.o = paramCLSong.totalSize;
      if (TextUtils.isEmpty(this.c)) {
        this.c = "unknow";
      }
      if (TextUtils.isEmpty(this.f)) {
        this.f = "unknow";
      }
      if (TextUtils.isEmpty(this.b)) {
        this.b = "unknow";
      }
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.n = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.o = paramLong;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MusicSongModel)) {
        break;
      }
      paramObject = (MusicSongModel)paramObject;
    } while ((!TextUtils.isEmpty(((MusicSongModel)paramObject).a)) && (((MusicSongModel)paramObject).a.equals(this.a)));
    return false;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
  
  public String h()
  {
    return this.i;
  }
  
  public void h(String paramString)
  {
    this.i = paramString;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public void i(String paramString)
  {
    this.m = paramString;
  }
  
  public void j(String paramString)
  {
    this.p = paramString;
  }
  
  public boolean j()
  {
    return this.k;
  }
  
  public boolean k()
  {
    return this.l;
  }
  
  public String l()
  {
    return this.m;
  }
  
  public long m()
  {
    return this.n;
  }
  
  public long n()
  {
    return this.o;
  }
  
  public String o()
  {
    return this.p;
  }
  
  public int p()
  {
    return this.r;
  }
  
  public int q()
  {
    return this.s;
  }
  
  public int r()
  {
    return this.q;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.j);
    if (this.k == true)
    {
      paramParcel.writeInt(1);
      if (this.l != true) {
        break label139;
      }
      paramParcel.writeInt(1);
    }
    for (;;)
    {
      paramParcel.writeString(this.m);
      paramParcel.writeLong(this.n);
      paramParcel.writeLong(this.o);
      paramParcel.writeString(this.p);
      return;
      paramParcel.writeInt(0);
      break;
      label139:
      paramParcel.writeInt(0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/MusicSongModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */