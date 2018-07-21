package com.baidu.android.pushservice.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface a
  extends IInterface
{
  public abstract int a(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract String a()
    throws RemoteException;
  
  public abstract String a(String paramString)
    throws RemoteException;
  
  public abstract String a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, b paramb)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean, b paramb)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, b paramb)
    throws RemoteException;
  
  public abstract boolean a(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract boolean a(String paramString1, String paramString2, int paramInt)
    throws RemoteException;
  
  public abstract boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
    throws RemoteException;
  
  public abstract boolean a(String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract int b(String paramString)
    throws RemoteException;
  
  public abstract int b(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract String b()
    throws RemoteException;
  
  public abstract void b(String paramString1, String paramString2, b paramb)
    throws RemoteException;
  
  public abstract boolean b(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract int c()
    throws RemoteException;
  
  public abstract int c(String paramString)
    throws RemoteException;
  
  public abstract int c(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract int d(String paramString)
    throws RemoteException;
  
  public abstract boolean e(String paramString)
    throws RemoteException;
  
  public abstract String f(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.baidu.android.pushservice.aidl.IPushService");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      boolean bool = false;
      String str1;
      String str2;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.baidu.android.pushservice.aidl.IPushService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          bool = true;
        }
        a(str1, str2, bool, b.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        a(paramParcel1.readString(), paramParcel1.readString(), b.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        b(paramParcel1.readString(), paramParcel1.readString(), b.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramParcel1 = b();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramParcel1 = a(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        str1 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          paramParcel1 = a(str1, paramInt1, bool, paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          paramParcel2.writeString(paramParcel1);
          return true;
        }
      case 8: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramInt1 = a(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramInt1 = b(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramInt1 = b(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramInt1 = c(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramInt1 = c(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        bool = a(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        bool = a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        bool = a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        bool = b(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramInt1 = d(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        bool = e(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          bool = a(str1, bool);
          paramParcel2.writeNoException();
          paramInt1 = i1;
          if (bool) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 20: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        paramInt1 = c();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          a(str1, str2, bool, paramParcel1.readString(), b.a.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
      paramParcel1 = f(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */