package com.baidu.location.wifihistory;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ISManager
  extends IInterface
{
  public abstract WifiHistory getInfo2()
    throws RemoteException;
  
  public abstract String getShareString01()
    throws RemoteException;
  
  public abstract boolean setShareString01(String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ISManager
  {
    private static final String DESCRIPTOR = "com.baidu.location.wifihistory.ISManager";
    static final int TRANSACTION_getInfo2 = 3;
    static final int TRANSACTION_getShareString01 = 2;
    static final int TRANSACTION_setShareString01 = 1;
    
    public Stub()
    {
      attachInterface(this, "com.baidu.location.wifihistory.ISManager");
    }
    
    public static ISManager asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.location.wifihistory.ISManager");
      if ((localIInterface != null) && ((localIInterface instanceof ISManager))) {
        return (ISManager)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int i = 0;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.baidu.location.wifihistory.ISManager");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.baidu.location.wifihistory.ISManager");
        boolean bool = setShareString01(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.baidu.location.wifihistory.ISManager");
        paramParcel1 = getShareString01();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.baidu.location.wifihistory.ISManager");
      paramParcel1 = getInfo2();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    
    private static class a
      implements ISManager
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      /* Error */
      public WifiHistory getInfo2()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 33
        //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/baidu/location/wifihistory/ISManager$Stub$a:a	Landroid/os/IBinder;
        //   18: iconst_3
        //   19: aload_2
        //   20: aload_3
        //   21: iconst_0
        //   22: invokeinterface 43 5 0
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual 46	android/os/Parcel:readException	()V
        //   32: aload_3
        //   33: invokevirtual 50	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 56	com/baidu/location/wifihistory/WifiHistory:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 62 2 0
        //   48: checkcast 52	com/baidu/location/wifihistory/WifiHistory
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 65	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 65	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 65	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 65	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   51	13	1	localWifiHistory	WifiHistory
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      public String getShareString01()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.location.wifihistory.ISManager");
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public boolean setShareString01(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 5
        //   12: aload 4
        //   14: ldc 33
        //   16: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload 4
        //   21: aload_1
        //   22: invokevirtual 76	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_0
        //   26: getfield 18	com/baidu/location/wifihistory/ISManager$Stub$a:a	Landroid/os/IBinder;
        //   29: iconst_1
        //   30: aload 4
        //   32: aload 5
        //   34: iconst_0
        //   35: invokeinterface 43 5 0
        //   40: pop
        //   41: aload 5
        //   43: invokevirtual 46	android/os/Parcel:readException	()V
        //   46: aload 5
        //   48: invokevirtual 50	android/os/Parcel:readInt	()I
        //   51: istore_2
        //   52: iload_2
        //   53: ifeq +15 -> 68
        //   56: aload 5
        //   58: invokevirtual 65	android/os/Parcel:recycle	()V
        //   61: aload 4
        //   63: invokevirtual 65	android/os/Parcel:recycle	()V
        //   66: iload_3
        //   67: ireturn
        //   68: iconst_0
        //   69: istore_3
        //   70: goto -14 -> 56
        //   73: astore_1
        //   74: aload 5
        //   76: invokevirtual 65	android/os/Parcel:recycle	()V
        //   79: aload 4
        //   81: invokevirtual 65	android/os/Parcel:recycle	()V
        //   84: aload_1
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	a
        //   0	86	1	paramString	String
        //   51	2	2	i	int
        //   1	69	3	bool	boolean
        //   5	75	4	localParcel1	Parcel
        //   10	65	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   12	52	73	finally
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/wifihistory/ISManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */