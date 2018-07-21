package com.baidu.carlife.platform.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public abstract interface i
  extends IInterface, e, g
{
  public abstract int a(String paramString1, String paramString2, String paramString3, h paramh)
    throws RemoteException;
  
  public abstract String a(String paramString)
    throws RemoteException;
  
  public abstract List<String> a()
    throws RemoteException;
  
  public abstract void a(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract void a(String paramString1, int paramInt, String paramString2)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, long paramLong)
    throws RemoteException;
  
  public abstract boolean a(f paramf)
    throws RemoteException;
  
  public abstract void b(String paramString)
    throws RemoteException;
  
  public abstract void c(String paramString)
    throws RemoteException;
  
  public abstract void d(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements i
  {
    private static final String a = "com.baidu.carlife.platform.service.IServiceBinder";
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    static final int e = 4;
    static final int f = 5;
    static final int g = 6;
    static final int h = 7;
    static final int i = 8;
    static final int j = 9;
    static final int k = 10;
    static final int l = 11;
    
    public a()
    {
      attachInterface(this, "com.baidu.carlife.platform.service.IServiceBinder");
    }
    
    public static i a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.carlife.platform.service.IServiceBinder");
      if ((localIInterface != null) && ((localIInterface instanceof i))) {
        return (i)localIInterface;
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
      case 3: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        boolean bool = a(f.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        a(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        b(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
        c(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.baidu.carlife.platform.service.IServiceBinder");
      d(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements i
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
        //   55: getfield 17	com/baidu/carlife/platform/service/i$a$a:a	Landroid/os/IBinder;
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
      
      public List<String> a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ArrayList localArrayList = localParcel2.createStringArrayList();
          return localArrayList;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void a(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.a.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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
      
      public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void a(String paramString1, String paramString2, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeLong(paramLong);
          this.a.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public boolean a(f paramf)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 5
        //   12: aload 4
        //   14: ldc 29
        //   16: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +61 -> 81
        //   23: aload_1
        //   24: invokeinterface 90 1 0
        //   29: astore_1
        //   30: aload 4
        //   32: aload_1
        //   33: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_0
        //   37: getfield 17	com/baidu/carlife/platform/service/i$a$a:a	Landroid/os/IBinder;
        //   40: iconst_4
        //   41: aload 4
        //   43: aload 5
        //   45: iconst_0
        //   46: invokeinterface 51 5 0
        //   51: pop
        //   52: aload 5
        //   54: invokevirtual 54	android/os/Parcel:readException	()V
        //   57: aload 5
        //   59: invokevirtual 58	android/os/Parcel:readInt	()I
        //   62: istore_2
        //   63: iload_2
        //   64: ifeq +5 -> 69
        //   67: iconst_1
        //   68: istore_3
        //   69: aload 5
        //   71: invokevirtual 61	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: invokevirtual 61	android/os/Parcel:recycle	()V
        //   79: iload_3
        //   80: ireturn
        //   81: aconst_null
        //   82: astore_1
        //   83: goto -53 -> 30
        //   86: astore_1
        //   87: aload 5
        //   89: invokevirtual 61	android/os/Parcel:recycle	()V
        //   92: aload 4
        //   94: invokevirtual 61	android/os/Parcel:recycle	()V
        //   97: aload_1
        //   98: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	99	0	this	a
        //   0	99	1	paramf	f
        //   62	2	2	i	int
        //   1	79	3	bool	boolean
        //   5	88	4	localParcel1	Parcel
        //   10	78	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   12	19	86	finally
        //   23	30	86	finally
        //   30	63	86	finally
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public String b()
      {
        return "com.baidu.carlife.platform.service.IServiceBinder";
      }
      
      public void b(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          localParcel1.writeString(paramString);
          this.a.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void c(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          localParcel1.writeString(paramString);
          this.a.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void d(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.carlife.platform.service.IServiceBinder");
          localParcel1.writeString(paramString);
          this.a.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/service/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */