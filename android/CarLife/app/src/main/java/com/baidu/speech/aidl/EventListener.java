package com.baidu.speech.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface EventListener
  extends IInterface
{
  public abstract void onEvent(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements EventListener
  {
    private static final String DESCRIPTOR = "com.baidu.speech.aidl.EventListener";
    static final int TRANSACTION_onEvent = 1;
    
    public Stub()
    {
      attachInterface(this, "com.baidu.speech.aidl.EventListener");
    }
    
    public static EventListener asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.speech.aidl.EventListener");
      if ((localIInterface != null) && ((localIInterface instanceof EventListener))) {
        return (EventListener)localIInterface;
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
        paramParcel2.writeString("com.baidu.speech.aidl.EventListener");
        return true;
      }
      paramParcel1.enforceInterface("com.baidu.speech.aidl.EventListener");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      byte[] arrayOfByte = paramParcel1.createByteArray();
      onEvent(str1, str2, arrayOfByte, paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(arrayOfByte);
      return true;
    }
    
    private static class Proxy
      implements EventListener
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
      
      public String getInterfaceDescriptor()
      {
        return "com.baidu.speech.aidl.EventListener";
      }
      
      public void onEvent(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.speech.aidl.EventListener");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          localParcel2.readByteArray(paramArrayOfByte);
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/aidl/EventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */