package android.a.a;

import android.content.pm.ParceledListSlice;
import android.media.session.MediaSession.Token;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface b
  extends IInterface
{
  public abstract void a()
    throws RemoteException;
  
  public abstract void a(String paramString, ParceledListSlice paramParceledListSlice)
    throws RemoteException;
  
  public abstract void a(String paramString, MediaSession.Token paramToken, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements b
  {
    public static b a(IBinder paramIBinder)
    {
      return null;
    }
    
    public IBinder asBinder()
    {
      return null;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      return false;
    }
    
    private static class a
      implements b
    {
      a(IBinder paramIBinder) {}
      
      public void a()
        throws RemoteException
      {}
      
      public void a(String paramString, ParceledListSlice paramParceledListSlice)
        throws RemoteException
      {}
      
      public void a(String paramString, MediaSession.Token paramToken, Bundle paramBundle)
        throws RemoteException
      {}
      
      public IBinder asBinder()
      {
        return null;
      }
      
      public String b()
      {
        return null;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */