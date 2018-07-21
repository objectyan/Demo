package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProcFile
  extends File
  implements Parcelable
{
  public static final Parcelable.Creator<ProcFile> CREATOR = new Parcelable.Creator()
  {
    public ProcFile a(Parcel paramAnonymousParcel)
    {
      return new ProcFile(paramAnonymousParcel);
    }
    
    public ProcFile[] a(int paramAnonymousInt)
    {
      return new ProcFile[paramAnonymousInt];
    }
  };
  public final String b;
  
  protected ProcFile(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.b = paramParcel.readString();
  }
  
  protected ProcFile(String paramString)
    throws IOException
  {
    super(paramString);
    this.b = b(paramString);
  }
  
  protected static String b(String paramString)
    throws IOException
  {
    Object localObject3 = null;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localBufferedReader = new BufferedReader(new FileReader(paramString));
      String str;
      if (paramString == null) {
        break label88;
      }
    }
    finally
    {
      try
      {
        paramString = localBufferedReader.readLine();
        str = "";
        while (paramString != null)
        {
          localStringBuilder.append(str).append(paramString);
          str = "\n";
          paramString = localBufferedReader.readLine();
        }
        paramString = localStringBuilder.toString();
        if (localBufferedReader != null) {
          localBufferedReader.close();
        }
        return paramString;
      }
      finally
      {
        for (;;)
        {
          BufferedReader localBufferedReader;
          paramString = localBufferedReader;
        }
      }
      localObject1 = finally;
      paramString = (String)localObject3;
    }
    paramString.close();
    label88:
    throw ((Throwable)localObject1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long length()
  {
    return this.b.length();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getAbsolutePath());
    paramParcel.writeString(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/processes/models/ProcFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */