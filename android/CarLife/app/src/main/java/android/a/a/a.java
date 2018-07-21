package android.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;

public abstract interface a
  extends IInterface
{
  public abstract void addSubscription(String paramString, b paramb)
    throws RemoteException;
  
  public abstract void connect(String paramString, Bundle paramBundle, b paramb)
    throws RemoteException;
  
  public abstract void disconnect(b paramb)
    throws RemoteException;
  
  public abstract void getMediaItem(String paramString, ResultReceiver paramResultReceiver)
    throws RemoteException;
  
  public abstract void removeSubscription(String paramString, b paramb)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a asInterface(IBinder paramIBinder)
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
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */