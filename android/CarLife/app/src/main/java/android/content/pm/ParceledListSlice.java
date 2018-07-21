package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import java.util.List;

public class ParceledListSlice<T extends Parcelable>
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<ParceledListSlice> CREATOR = new Parcelable.ClassLoaderCreator()
  {
    public ParceledListSlice createFromParcel(Parcel paramAnonymousParcel)
    {
      return null;
    }
    
    public ParceledListSlice createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return null;
    }
    
    public ParceledListSlice[] newArray(int paramAnonymousInt)
    {
      return null;
    }
  };
  
  private ParceledListSlice(Parcel paramParcel, ClassLoader paramClassLoader) {}
  
  public ParceledListSlice(List<T> paramList) {}
  
  private static void verifySameType(Class<?> paramClass1, Class<?> paramClass2) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<T> getList()
  {
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/content/pm/ParceledListSlice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */