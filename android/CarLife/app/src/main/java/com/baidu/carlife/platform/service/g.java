package com.baidu.carlife.platform.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface g
  extends IInterface
{
  public abstract int a(String paramString1, String paramString2, String paramString3, h paramh)
    throws RemoteException;
  
  public abstract String a(String paramString)
    throws RemoteException;
  
  public abstract void a(String paramString1, int paramInt, String paramString2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements g
  {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    private static final String d = "com.baidu.carlife.platform.service.IServiceBinder";
    
    public a()
    {
      attachInterface(this, "com.baidu.carlife.platform.service.IServiceBinder");
    }
    
    public static g a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.carlife.platform.service.IServiceBinder");
      if ((localIInterface != null) && ((localIInterface instanceof g))) {
        return (g)localIInterface;
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
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.baidu.carlife.platform.service.IServiceBinder");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        paramInt1 = a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), h.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        paramParcel1 = a(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements g
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      /* Error */
      public int a(String paramString1, String paramString2, String paramString3, h paramh)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 6
        //   19: aload_1
        //   20: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 6
        //   25: aload_2
        //   26: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload 6
        //   31: aload_3
        //   32: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload 4
        //   37: ifnull +58 -> 95
        //   40: aload 4
        //   42: invokeinterface 42 1 0
        //   47: astore_1
        //   48: aload 6
        //   50: aload_1
        //   51: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_0
        //   55: getfield 17	com/baidu/carlife/platform/service/g$a$a:a	Landroid/os/IBinder;
        //   58: iconst_1
        //   59: aload 6
        //   61: aload 7
        //   63: iconst_0
        //   64: invokeinterface 51 5 0
        //   69: pop
        //   70: aload 7
        //   72: invokevirtual 54	android/os/Parcel:readException	()V
        //   75: aload 7
        //   77: invokevirtual 58	android/os/Parcel:readInt	()I
        //   80: istore 5
        //   82: aload 7
        //   84: invokevirtual 61	android/os/Parcel:recycle	()V
        //   87: aload 6
        //   89: invokevirtual 61	android/os/Parcel:recycle	()V
        //   92: iload 5
        //   94: ireturn
        //   95: aconst_null
        //   96: astore_1
        //   97: goto -49 -> 48
        //   100: astore_1
        //   101: aload 7
        //   103: invokevirtual 61	android/os/Parcel:recycle	()V
        //   106: aload 6
        //   108: invokevirtual 61	android/os/Parcel:recycle	()V
        //   111: aload_1
        //   112: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	113	0	this	a
        //   0	113	1	paramString1	String
        //   0	113	2	paramString2	String
        //   0	113	3	paramString3	String
        //   0	113	4	paramh	h
        //   80	13	5	i	int
        //   3	104	6	localParcel1	Parcel
        //   8	94	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	35	100	finally
        //   40	48	100	finally
        //   48	82	100	finally
      }
      
      public String a()
      {
        return "com.baidu.carlife.platform.service.IServiceBinder";
      }
      
      public String a(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          localParcel1.writeString(paramString);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void a(String paramString1, int paramInt, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          localParcel1.writeString(paramString1);
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString2);
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/service/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */