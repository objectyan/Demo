package com.indooratlas.android.sdk;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk._internal.ee;

public class IALocation
  implements Parcelable
{
  public static final Parcelable.Creator<IALocation> CREATOR = new Parcelable.Creator() {};
  public static final String EXTRA_FLOOR_CERTAINTY = "com.indooratlas.android.sdk.extra.floorCertainty";
  public static final String EXTRA_FLOOR_LEVEL = "com.indooratlas.android.sdk.extra.floorLevel";
  public static final String EXTRA_REGION = "com.indooratlas.android.sdk.extra.region";
  @NonNull
  private final Location a;
  @Nullable
  private IARegion b;
  
  protected IALocation(Parcel paramParcel)
  {
    Location localLocation = (Location)paramParcel.readParcelable(Location.class.getClassLoader());
    if (localLocation != null) {}
    for (this.a = localLocation;; this.a = new Location(null))
    {
      this.b = ((IARegion)paramParcel.readParcelable(IARegion.class.getClassLoader()));
      return;
    }
  }
  
  private IALocation(Builder paramBuilder)
  {
    if (Builder.a(paramBuilder) != null)
    {
      localObject = Builder.a(paramBuilder);
      if (Builder.b(paramBuilder) == null) {
        break label315;
      }
      localObject = new Location(Builder.b(paramBuilder));
      label35:
      this.a = ((Location)localObject);
      if (Builder.c(paramBuilder) == null) {
        break label327;
      }
    }
    label315:
    label327:
    for (Object localObject = new Bundle(Builder.c(paramBuilder));; localObject = new Bundle())
    {
      if (this.a.getExtras() != null) {
        ((Bundle)localObject).putAll(this.a.getExtras());
      }
      if (Builder.d(paramBuilder) != null) {
        this.a.setLatitude(Builder.d(paramBuilder).doubleValue());
      }
      if (Builder.e(paramBuilder) != null) {
        this.a.setLongitude(Builder.e(paramBuilder).doubleValue());
      }
      if (Builder.f(paramBuilder) != null) {
        this.a.setAccuracy(Builder.f(paramBuilder).floatValue());
      }
      if (Builder.g(paramBuilder) != null) {
        this.a.setBearing(Builder.g(paramBuilder).floatValue());
      }
      if (Builder.h(paramBuilder) != null) {
        this.a.setTime(Builder.h(paramBuilder).longValue());
      }
      if (Builder.f(paramBuilder) != null) {
        this.a.setAccuracy(Builder.f(paramBuilder).floatValue());
      }
      if (Builder.i(paramBuilder) != null) {
        this.a.setAltitude(Builder.i(paramBuilder).doubleValue());
      }
      if (Builder.j(paramBuilder) != null) {
        ((Bundle)localObject).putInt("com.indooratlas.android.sdk.extra.floorLevel", Builder.j(paramBuilder).intValue());
      }
      if (Builder.k(paramBuilder) != null) {
        ((Bundle)localObject).putFloat("com.indooratlas.android.sdk.extra.floorCertainty", Builder.k(paramBuilder).floatValue());
      }
      if (Builder.l(paramBuilder) != null)
      {
        this.b = Builder.l(paramBuilder);
        ((Bundle)localObject).setClassLoader(IARegion.class.getClassLoader());
        ((Bundle)localObject).putParcelable("com.indooratlas.android.sdk.extra.region", this.b);
      }
      this.a.setExtras((Bundle)localObject);
      return;
      localObject = null;
      break;
      localObject = new Location((String)localObject);
      break label35;
    }
  }
  
  private boolean a(String paramString)
  {
    Bundle localBundle = this.a.getExtras();
    if (localBundle == null) {
      return false;
    }
    localBundle.setClassLoader(IARegion.class.getClassLoader());
    return localBundle.containsKey(paramString);
  }
  
  public static IALocation from(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      Object localObject = paramIntent.getByteArrayExtra("com.indooratlas.android.sdk.intent.extras.location");
      if (localObject == null) {
        return null;
      }
      paramIntent = Parcel.obtain();
      paramIntent.unmarshall((byte[])localObject, 0, localObject.length);
      paramIntent.setDataPosition(0);
      localObject = (IALocation)CREATOR.createFromParcel(paramIntent);
      paramIntent.recycle();
      return (IALocation)localObject;
    }
    catch (Exception paramIntent)
    {
      ee.a("IASDK", "IALocation in Intent corrupted", new Object[] { paramIntent });
    }
    return null;
  }
  
  public static IALocation from(Location paramLocation)
  {
    return new Builder().withLocation(paramLocation).build();
  }
  
  public static IALocation from(IARegion paramIARegion)
  {
    return new Builder().withRegion(paramIARegion).build();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (IALocation)paramObject;
      if (getLatitude() != ((IALocation)paramObject).getLatitude()) {
        return false;
      }
      if (getLongitude() != ((IALocation)paramObject).getLongitude()) {
        return false;
      }
      if (getAccuracy() != ((IALocation)paramObject).getAccuracy()) {
        return false;
      }
      if (getBearing() != ((IALocation)paramObject).getBearing()) {
        return false;
      }
      if (getTime() != ((IALocation)paramObject).getTime()) {
        return false;
      }
      if ((hasFloorLevel() != ((IALocation)paramObject).hasFloorLevel()) || (getFloorLevel() != ((IALocation)paramObject).getFloorLevel())) {
        return false;
      }
      if ((hasFloorCertainty() != ((IALocation)paramObject).hasFloorCertainty()) || (getFloorCertainty() != ((IALocation)paramObject).getFloorCertainty())) {
        return false;
      }
      if (this.b == null) {
        break;
      }
    } while (this.b.equals(((IALocation)paramObject).b));
    while (((IALocation)paramObject).b != null) {
      return false;
    }
    return true;
  }
  
  public float getAccuracy()
  {
    return this.a.getAccuracy();
  }
  
  public double getAltitude()
  {
    return this.a.getAltitude();
  }
  
  public float getBearing()
  {
    return this.a.getBearing();
  }
  
  public float getFloorCertainty()
  {
    Bundle localBundle = this.a.getExtras();
    if (localBundle == null) {
      return 0.0F;
    }
    localBundle.setClassLoader(IARegion.class.getClassLoader());
    return localBundle.getFloat("com.indooratlas.android.sdk.extra.floorCertainty", 0.0F);
  }
  
  public int getFloorLevel()
  {
    Bundle localBundle = this.a.getExtras();
    if (localBundle == null) {
      return 0;
    }
    localBundle.setClassLoader(IARegion.class.getClassLoader());
    return localBundle.getInt("com.indooratlas.android.sdk.extra.floorLevel", 0);
  }
  
  public double getLatitude()
  {
    return this.a.getLatitude();
  }
  
  public double getLongitude()
  {
    return this.a.getLongitude();
  }
  
  public IARegion getRegion()
  {
    return this.b;
  }
  
  public long getTime()
  {
    return this.a.getTime();
  }
  
  public boolean hasFloorCertainty()
  {
    return a("com.indooratlas.android.sdk.extra.floorCertainty");
  }
  
  public boolean hasFloorLevel()
  {
    return a("com.indooratlas.android.sdk.extra.floorLevel");
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0)
    {
      if (this.b != null) {
        j = this.b.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public Builder newBuilder()
  {
    return new Builder(this);
  }
  
  public Location toLocation()
  {
    return new Location(this.a);
  }
  
  public String toString()
  {
    return "IALocation{latitude=" + getLatitude() + ",longitude=" + getLongitude() + ",accuracy=" + getAccuracy() + ",bearing=" + getBearing() + ",floorLevel=" + getFloorLevel() + ",floorCertainty=" + getFloorCertainty() + ",time=" + getTime() + ",region=" + this.b + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
  }
  
  public static class Builder
  {
    private Location a;
    private Double b;
    private Double c;
    private Long d;
    private Float e;
    private Float f;
    private Integer g;
    private Float h;
    private IARegion i;
    private Double j;
    private Bundle k;
    @Nullable
    private final String l;
    
    public Builder()
    {
      this(null);
    }
    
    Builder(IALocation paramIALocation)
    {
      this.l = IALocation.a(paramIALocation).getProvider();
      this.a = IALocation.a(paramIALocation);
      this.i = IALocation.b(paramIALocation);
      if (paramIALocation.hasFloorLevel()) {
        this.g = Integer.valueOf(paramIALocation.getFloorLevel());
      }
      if (paramIALocation.hasFloorCertainty()) {
        this.h = Float.valueOf(paramIALocation.getFloorCertainty());
      }
    }
    
    public Builder(String paramString)
    {
      this.l = paramString;
    }
    
    public IALocation build()
    {
      return new IALocation(this, (byte)0);
    }
    
    public Builder withAccuracy(float paramFloat)
    {
      this.f = Float.valueOf(paramFloat);
      return this;
    }
    
    public Builder withAltitude(double paramDouble)
    {
      this.j = Double.valueOf(paramDouble);
      return this;
    }
    
    public Builder withBearing(float paramFloat)
    {
      this.e = Float.valueOf(paramFloat);
      return this;
    }
    
    public Builder withExtras(Bundle paramBundle)
    {
      this.k = paramBundle;
      return this;
    }
    
    public Builder withFloorCertainty(float paramFloat)
    {
      this.h = Float.valueOf(paramFloat);
      return this;
    }
    
    public Builder withFloorLevel(int paramInt)
    {
      this.g = Integer.valueOf(paramInt);
      return this;
    }
    
    public Builder withIntExtra(String paramString, int paramInt)
    {
      if (this.k == null) {
        this.k = new Bundle(1);
      }
      this.k.putInt(paramString, paramInt);
      return this;
    }
    
    public Builder withLatitude(double paramDouble)
    {
      this.b = Double.valueOf(paramDouble);
      return this;
    }
    
    public Builder withLocation(Location paramLocation)
    {
      this.a = paramLocation;
      return this;
    }
    
    public Builder withLongExtra(String paramString, long paramLong)
    {
      if (this.k == null) {
        this.k = new Bundle(1);
      }
      this.k.putLong(paramString, paramLong);
      return this;
    }
    
    public Builder withLongitude(double paramDouble)
    {
      this.c = Double.valueOf(paramDouble);
      return this;
    }
    
    public Builder withRegion(IARegion paramIARegion)
    {
      this.i = paramIARegion;
      return this;
    }
    
    public Builder withTime(long paramLong)
    {
      this.d = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/IALocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */