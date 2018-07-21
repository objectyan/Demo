package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class Cgroup
  extends ProcFile
{
  public static final Parcelable.Creator<Cgroup> CREATOR = new Parcelable.Creator()
  {
    public Cgroup a(Parcel paramAnonymousParcel)
    {
      return new Cgroup(paramAnonymousParcel, null);
    }
    
    public Cgroup[] a(int paramAnonymousInt)
    {
      return new Cgroup[paramAnonymousInt];
    }
  };
  public final ArrayList<ControlGroup> a;
  
  private Cgroup(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(ControlGroup.CREATOR);
  }
  
  private Cgroup(String paramString)
    throws IOException
  {
    super(paramString);
    paramString = this.b.split("\n");
    this.a = new ArrayList();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = paramString[i];
      }
      try
      {
        this.a.add(new ControlGroup(str));
        i += 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static Cgroup a(int paramInt)
    throws IOException
  {
    return new Cgroup(String.format("/proc/%d/cgroup", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public ControlGroup a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ControlGroup localControlGroup = (ControlGroup)localIterator.next();
      String[] arrayOfString = localControlGroup.b.split(",");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          return localControlGroup;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/models/Cgroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */