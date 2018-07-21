package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.IOException;

public final class Stat
  extends ProcFile
{
  public static final Parcelable.Creator<Stat> CREATOR = new Parcelable.Creator()
  {
    public Stat a(Parcel paramAnonymousParcel)
    {
      return new Stat(paramAnonymousParcel, null);
    }
    
    public Stat[] a(int paramAnonymousInt)
    {
      return new Stat[paramAnonymousInt];
    }
  };
  private final String[] a;
  
  private Stat(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createStringArray();
  }
  
  private Stat(String paramString)
    throws IOException
  {
    super(paramString);
    this.a = this.b.split("\\s+");
  }
  
  public static Stat a(int paramInt)
    throws IOException
  {
    return new Stat(String.format("/proc/%d/stat", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public long A()
  {
    return Long.parseLong(this.a[26]);
  }
  
  public long B()
  {
    return Long.parseLong(this.a[27]);
  }
  
  public long C()
  {
    return Long.parseLong(this.a[28]);
  }
  
  public long D()
  {
    return Long.parseLong(this.a[29]);
  }
  
  public long E()
  {
    return Long.parseLong(this.a[30]);
  }
  
  public long F()
  {
    return Long.parseLong(this.a[31]);
  }
  
  public long G()
  {
    return Long.parseLong(this.a[32]);
  }
  
  public long H()
  {
    return Long.parseLong(this.a[33]);
  }
  
  public long I()
  {
    return Long.parseLong(this.a[34]);
  }
  
  public long J()
  {
    return Long.parseLong(this.a[35]);
  }
  
  public long K()
  {
    return Long.parseLong(this.a[36]);
  }
  
  public int L()
  {
    return Integer.parseInt(this.a[37]);
  }
  
  public int M()
  {
    return Integer.parseInt(this.a[38]);
  }
  
  public int N()
  {
    return Integer.parseInt(this.a[39]);
  }
  
  public int O()
  {
    return Integer.parseInt(this.a[40]);
  }
  
  public long P()
  {
    return Long.parseLong(this.a[41]);
  }
  
  public long Q()
  {
    return Long.parseLong(this.a[42]);
  }
  
  public long R()
  {
    return Long.parseLong(this.a[43]);
  }
  
  public long S()
  {
    return Long.parseLong(this.a[44]);
  }
  
  public long T()
  {
    return Long.parseLong(this.a[45]);
  }
  
  public long U()
  {
    return Long.parseLong(this.a[46]);
  }
  
  public long V()
  {
    return Long.parseLong(this.a[47]);
  }
  
  public long W()
  {
    return Long.parseLong(this.a[48]);
  }
  
  public long X()
  {
    return Long.parseLong(this.a[49]);
  }
  
  public long Y()
  {
    return Long.parseLong(this.a[50]);
  }
  
  public int Z()
  {
    return Integer.parseInt(this.a[51]);
  }
  
  public int a()
  {
    return Integer.parseInt(this.a[0]);
  }
  
  public String b()
  {
    return this.a[1].replace("(", "").replace(")", "");
  }
  
  public char c()
  {
    return this.a[2].charAt(0);
  }
  
  public int d()
  {
    return Integer.parseInt(this.a[3]);
  }
  
  public int e()
  {
    return Integer.parseInt(this.a[4]);
  }
  
  public int f()
  {
    return Integer.parseInt(this.a[5]);
  }
  
  public int g()
  {
    return Integer.parseInt(this.a[6]);
  }
  
  public int h()
  {
    return Integer.parseInt(this.a[7]);
  }
  
  public int i()
  {
    return Integer.parseInt(this.a[8]);
  }
  
  public long j()
  {
    return Long.parseLong(this.a[9]);
  }
  
  public long k()
  {
    return Long.parseLong(this.a[10]);
  }
  
  public long l()
  {
    return Long.parseLong(this.a[11]);
  }
  
  public long m()
  {
    return Long.parseLong(this.a[12]);
  }
  
  public long n()
  {
    return Long.parseLong(this.a[13]);
  }
  
  public long o()
  {
    return Long.parseLong(this.a[14]);
  }
  
  public long p()
  {
    return Long.parseLong(this.a[15]);
  }
  
  public long q()
  {
    return Long.parseLong(this.a[16]);
  }
  
  public long r()
  {
    return Long.parseLong(this.a[17]);
  }
  
  public int s()
  {
    return Integer.parseInt(this.a[18]);
  }
  
  public long t()
  {
    return Long.parseLong(this.a[19]);
  }
  
  public long u()
  {
    return Long.parseLong(this.a[20]);
  }
  
  public long v()
  {
    return Long.parseLong(this.a[21]);
  }
  
  public long w()
  {
    return Long.parseLong(this.a[22]);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeStringArray(this.a);
  }
  
  public long x()
  {
    return Long.parseLong(this.a[23]);
  }
  
  public long y()
  {
    return Long.parseLong(this.a[24]);
  }
  
  public long z()
  {
    return Long.parseLong(this.a[25]);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/models/Stat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */