package com.baidu.speech.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface EventManagerFactory
  extends IInterface
{
  public abstract EventManager create(String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements EventManagerFactory
  {
    private static final String DESCRIPTOR = "com.baidu.speech.aidl.EventManagerFactory";
    static final int TRANSACTION_create = 1;
    
    public Stub()
    {
      attachInterface(this, "com.baidu.speech.aidl.EventManagerFactory");
    }
    
    public static EventManagerFactory asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.speech.aidl.EventManagerFactory");
      if ((localIInterface != null) && ((localIInterface instanceof EventManagerFactory))) {
        return (EventManagerFactory)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.baidu.speech.aidl.EventManagerFactory");
        return true;
      }
      paramParcel1.enforceInterface("com.baidu.speech.aidl.EventManagerFactory");
      paramParcel1 = create(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    
    private static class Proxy
      implements EventManagerFactory
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public EventManager create(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.speech.aidl.EventManagerFactory");
          localParcel1.writeString(paramString);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = EventManager.Stub.asInterface(localParcel2.readStrongBinder());
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.baidu.speech.aidl.EventManagerFactory";
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/aidl/EventManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */