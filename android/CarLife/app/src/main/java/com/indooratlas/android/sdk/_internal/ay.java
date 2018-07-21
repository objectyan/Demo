package com.indooratlas.android.sdk._internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ay
  implements Parcelable
{
  public static final Parcelable.Creator<ay> CREATOR = new Parcelable.Creator() {};
  final int a;
  private final List<aw> b;
  
  protected ay(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add((aw)paramParcel.readParcelable(cd.class.getClassLoader()));
      i += 1;
    }
    this.b = localArrayList;
    this.a = paramParcel.readInt();
  }
  
  public final List<aw> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.b);
    return localArrayList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (ay)paramObject;
    if (this.a != ((ay)paramObject).a) {
      return false;
    }
    if (this.b.size() != ((ay)paramObject).b.size()) {
      return false;
    }
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      if (!((aw)this.b.get(i)).equals(((ay)paramObject).b.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = this.b.iterator();
    for (int i = 1; localIterator.hasNext(); i = ((aw)localIterator.next()).hashCode() + i * 37) {}
    return i * 37 + this.a;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b.size());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((cd)localIterator.next(), paramInt);
    }
    paramParcel.writeInt(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */