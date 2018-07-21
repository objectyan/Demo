package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ShareModel
  implements Parcelable
{
  public static final Parcelable.Creator<ShareModel> CREATOR = new Parcelable.Creator()
  {
    public ShareModel a(Parcel paramAnonymousParcel)
    {
      return new ShareModel(paramAnonymousParcel);
    }
    
    public ShareModel[] a(int paramAnonymousInt)
    {
      return new ShareModel[paramAnonymousInt];
    }
  };
  private SapiAccount a;
  private List<SapiAccount> b = new ArrayList();
  private ShareEvent c;
  private String d;
  private LoginShareStrategy e;
  
  ShareModel() {}
  
  ShareModel(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  ShareModel(ShareEvent paramShareEvent)
  {
    this.c = paramShareEvent;
  }
  
  ShareModel(ShareEvent paramShareEvent, SapiAccount paramSapiAccount)
  {
    this(paramShareEvent);
    this.a = paramSapiAccount;
  }
  
  ShareModel(ShareEvent paramShareEvent, SapiAccount paramSapiAccount, List<SapiAccount> paramList)
  {
    this(paramShareEvent, paramSapiAccount);
  }
  
  private void a(Parcel paramParcel)
  {
    this.c = ((ShareEvent)paramParcel.readSerializable());
    paramParcel.readTypedList(this.b, SapiAccount.CREATOR);
    this.a = ((SapiAccount)paramParcel.readParcelable(SapiAccount.class.getClassLoader()));
    this.e = ((LoginShareStrategy)paramParcel.readSerializable());
    this.d = paramParcel.readString();
  }
  
  List<SapiAccount> a()
  {
    return this.b;
  }
  
  void a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(b.a(paramContext, (SapiAccount)localIterator.next()));
    }
    a(localArrayList);
    if (this.a != null) {
      this.a = b.a(paramContext, this.a);
    }
    if (!TextUtils.isEmpty(this.d)) {
      this.d = b.a(paramContext, this.d);
    }
  }
  
  void a(SapiAccount paramSapiAccount)
  {
    this.a = paramSapiAccount;
  }
  
  void a(ShareEvent paramShareEvent)
  {
    this.c = paramShareEvent;
  }
  
  void a(LoginShareStrategy paramLoginShareStrategy)
  {
    this.e = paramLoginShareStrategy;
  }
  
  void a(String paramString)
  {
    this.d = paramString;
  }
  
  void a(List<SapiAccount> paramList)
  {
    if (paramList != null) {
      this.b = paramList;
    }
  }
  
  ShareEvent b()
  {
    return this.c;
  }
  
  void b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(b.b(paramContext, (SapiAccount)localIterator.next()));
    }
    a(localArrayList);
    if (this.a != null) {
      this.a = b.b(paramContext, this.a);
    }
    if (!TextUtils.isEmpty(this.d)) {
      this.d = b.b(paramContext, this.d);
    }
  }
  
  String c()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ShareModel{currentAccount=" + this.a + ", shareAccounts=" + this.b + ", event=" + this.c + ", from='" + this.d + '\'' + ", senderStrategy=" + this.e + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.c);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeSerializable(this.e);
    paramParcel.writeString(this.d);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/share/ShareModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */