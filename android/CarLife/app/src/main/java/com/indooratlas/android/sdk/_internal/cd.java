package com.indooratlas.android.sdk._internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class cd
  implements aw
{
  public static final Parcelable.Creator<cd> CREATOR = new Parcelable.Creator() {};
  @NonNull
  public final em a;
  private final String b;
  private final int c;
  private final JSONObject d;
  @Nullable
  private final Long e;
  @Nullable
  private final Long f;
  
  protected cd(Parcel paramParcel)
    throws IllegalArgumentException
  {
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = new double[2];
      paramParcel.readDoubleArray((double[])localObject);
      localArrayList.add(localObject);
      i += 1;
    }
    this.b = paramParcel.readString();
    try
    {
      this.d = new JSONObject(paramParcel.readString());
      localObject = (Integer)paramParcel.readValue(Integer.class.getClassLoader());
      this.e = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.f = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.c = paramParcel.readInt();
      this.a = new em(localArrayList, (Integer)localObject);
      return;
    }
    catch (JSONException paramParcel)
    {
      throw new IllegalArgumentException(paramParcel);
    }
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final boolean a(double paramDouble1, double paramDouble2, Integer paramInteger)
  {
    return this.a.a(new ep(paramDouble1, paramDouble2, paramInteger));
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final Long c()
  {
    return this.e;
  }
  
  public final boolean d()
  {
    return this.e != null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean e()
  {
    return this.f != null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (cd)paramObject;
      if (!this.a.equals(((cd)paramObject).a)) {
        return false;
      }
      if (!this.b.equals(((cd)paramObject).b)) {
        return false;
      }
      if (!this.d.toString().equals(((cd)paramObject).d.toString())) {
        return false;
      }
      if ((this.e != null) && (((cd)paramObject).e != null) && (!this.e.equals(((cd)paramObject).e))) {
        return false;
      }
      if ((this.e != null) && (((cd)paramObject).e == null)) {
        return false;
      }
      if ((this.e == null) && (((cd)paramObject).e != null)) {
        return false;
      }
      if ((this.f != null) && (((cd)paramObject).f != null) && (!this.f.equals(((cd)paramObject).f))) {
        return false;
      }
      if ((this.f != null) && (((cd)paramObject).f == null)) {
        return false;
      }
      if ((this.f == null) && (((cd)paramObject).f != null)) {
        return false;
      }
    } while (this.c == ((cd)paramObject).c);
    return false;
  }
  
  public final Long f()
  {
    return this.f;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int i = this.a.hashCode() + 37;
    char[] arrayOfChar = this.b.toCharArray();
    int m = arrayOfChar.length;
    int j = 0;
    while (j < m)
    {
      int n = arrayOfChar[j];
      j += 1;
      i = n + i * 37;
    }
    arrayOfChar = this.d.toString().toCharArray();
    m = arrayOfChar.length;
    j = 0;
    while (j < m)
    {
      i = i * 37 + arrayOfChar[j];
      j += 1;
    }
    if (this.e == null)
    {
      j = 0;
      if (this.f != null) {
        break label157;
      }
    }
    for (;;)
    {
      return ((j + i * 37) * 37 + k) * 37 + this.c;
      j = (int)(this.e.longValue() ^ this.e.longValue() >>> 32);
      break;
      label157:
      k = (int)(this.f.longValue() ^ this.f.longValue() >>> 32);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(105).append("IAGeofence{id=").append(this.b).append(",edges=").append(this.a.a.toString()).append(",transitionTypes=");
    if ((this.c & 0x1) > 0)
    {
      str = "ENTER ";
      localStringBuilder = localStringBuilder.append(str);
      if ((this.c & 0x10) <= 0) {
        break label215;
      }
      str = "EXIT ";
      label76:
      localStringBuilder = localStringBuilder.append(str);
      if ((this.c & 0x100) <= 0) {
        break label221;
      }
      str = "DWELL";
      label96:
      localStringBuilder = localStringBuilder.append(str).append(",payload=").append(this.d.toString()).append(",floor=");
      if (this.a.b == null) {
        break label227;
      }
      str = this.a.b.toString();
      label143:
      localStringBuilder = localStringBuilder.append(str).append(",loiteringDelay=");
      if (this.e == null) {
        break label233;
      }
      str = this.e.toString();
      label169:
      localStringBuilder = localStringBuilder.append(str).append(",expirationTime=");
      if (this.f == null) {
        break label239;
      }
    }
    label215:
    label221:
    label227:
    label233:
    label239:
    for (String str = this.f.toString();; str = "null")
    {
      return str + '}';
      str = "";
      break;
      str = "";
      break label76;
      str = "";
      break label96;
      str = "null";
      break label143;
      str = "null";
      break label169;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject = this.a.a;
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    while (paramInt < ((eq)localObject).a.size() - 1)
    {
      localArrayList.add(((eq)localObject).a.get(paramInt));
      paramInt += 1;
    }
    paramParcel.writeInt(localArrayList.size());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParcel.writeDoubleArray((double[])((Iterator)localObject).next());
    }
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.d.toString());
    paramParcel.writeValue(this.a.b);
    paramParcel.writeValue(this.e);
    paramParcel.writeValue(this.f);
    paramParcel.writeInt(this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */