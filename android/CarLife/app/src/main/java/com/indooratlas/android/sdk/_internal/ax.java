package com.indooratlas.android.sdk._internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.indooratlas.android.sdk.IALocation;
import java.util.ArrayList;
import java.util.Iterator;

public final class ax
  implements Parcelable
{
  public static final Parcelable.Creator<ax> CREATOR = new Parcelable.Creator() {};
  final int a;
  final ArrayList<aw> b;
  private final IALocation c;
  
  public ax(Parcel paramParcel)
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
    this.c = ((IALocation)paramParcel.readParcelable(IALocation.class.getClassLoader()));
  }
  
  public ax(ArrayList<aw> paramArrayList, int paramInt, IALocation paramIALocation)
  {
    this.b = new ArrayList(paramArrayList);
    this.c = paramIALocation;
    this.a = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(68);
    localStringBuilder.append("IAGeofenceEvent{transitionType=");
    switch (this.a)
    {
    }
    for (;;)
    {
      localStringBuilder.append(",geofences=");
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((aw)localIterator.next()).toString());
      }
      localStringBuilder.append("ENTER");
      continue;
      localStringBuilder.append("EXIT");
      continue;
      localStringBuilder.append("DWELL");
    }
    localStringBuilder.append(",triggeringLocation=").append(this.c).append('}');
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b.size());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((cd)localIterator.next(), paramInt);
    }
    paramParcel.writeInt(this.a);
    paramParcel.writeParcelable(this.c, paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */