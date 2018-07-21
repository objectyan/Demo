package com.baidu.carlife.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class i
{
  public static final String a = "android.bluetooth.device.extra.PAIRING_VARIANT";
  public static final String b = "android.bluetooth.device.extra.PAIRING_KEY";
  public static final String c = "android.bluetooth.device.action.PAIRING_REQUEST";
  public static final String d = "android.bluetooth.device.action.BOND_STATE_CHANGED";
  public static final String e = "android.bluetooth.device.action.PAIRING_CANCEL";
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  private static final String i = "BluetoothDevice";
  
  public static String a()
  {
    String str = "";
    if (Build.VERSION.SDK_INT >= 23) {
      str = Settings.Secure.getString(BaiduNaviApplication.getInstance().getApplicationContext().getContentResolver(), "bluetooth_address");
    }
    Object localObject;
    for (;;)
    {
      if (str != null)
      {
        localObject = str;
        if (!"02:00:00:00:00:00".equals(str)) {}
      }
      else
      {
        localObject = e();
      }
      if (BluetoothAdapter.checkBluetoothAddress((String)localObject)) {
        break;
      }
      return "";
      localObject = BluetoothAdapter.getDefaultAdapter();
      if (localObject != null) {
        str = ((BluetoothAdapter)localObject).getAddress();
      }
    }
    return ((String)localObject).toLowerCase();
  }
  
  private static String a(InputStream paramInputStream)
    throws IOException
  {
    if (paramInputStream != null)
    {
      StringWriter localStringWriter = new StringWriter();
      char[] arrayOfChar = new char['ࠀ'];
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
        for (;;)
        {
          int j = localBufferedReader.read(arrayOfChar);
          if (j == -1) {
            break;
          }
          localStringWriter.write(arrayOfChar, 0, j);
        }
      }
      finally
      {
        paramInputStream.close();
      }
      return localObject.toString();
    }
    return "No Contents";
  }
  
  public static void a(int paramInt)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    try
    {
      Method localMethod1 = BluetoothAdapter.class.getMethod("setDiscoverableTimeout", new Class[] { Integer.TYPE });
      localMethod1.setAccessible(true);
      Method localMethod2 = BluetoothAdapter.class.getMethod("setScanMode", new Class[] { Integer.TYPE, Integer.TYPE });
      localMethod2.setAccessible(true);
      localMethod1.invoke(localBluetoothAdapter, new Object[] { Integer.valueOf(paramInt) });
      localMethod2.invoke(localBluetoothAdapter, new Object[] { Integer.valueOf(23), Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a(Class<?> paramClass, BluetoothDevice paramBluetoothDevice)
    throws Exception
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBluetoothDevice.createBond();
    }
    com.baidu.carlife.core.i.c("BluetoothDevice", "createBond");
    return ((Boolean)paramClass.getDeclaredMethod("createBond", new Class[0]).invoke(paramBluetoothDevice, new Object[0])).booleanValue();
  }
  
  public static boolean a(Class<?> paramClass, BluetoothDevice paramBluetoothDevice, String paramString)
    throws Exception
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 19) {
        return paramBluetoothDevice.setPin(a(paramString));
      }
      boolean bool = ((Boolean)paramClass.getDeclaredMethod("setPin", new Class[] { byte[].class }).invoke(paramBluetoothDevice, new Object[] { a(paramString) })).booleanValue();
      return bool;
    }
    catch (SecurityException paramClass)
    {
      paramClass.printStackTrace();
      return false;
    }
    catch (IllegalArgumentException paramClass)
    {
      paramClass.printStackTrace();
      return false;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Class<?> paramClass, BluetoothDevice paramBluetoothDevice, boolean paramBoolean)
    throws Exception
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBluetoothDevice.setPairingConfirmation(paramBoolean);
    }
    return ((Boolean)paramClass.getDeclaredMethod("setPairingConfirmation", new Class[] { Boolean.TYPE }).invoke(paramBluetoothDevice, new Object[] { Boolean.valueOf(paramBoolean) })).booleanValue();
  }
  
  public static boolean a(Class<?> paramClass, BluetoothProfile paramBluetoothProfile, BluetoothDevice paramBluetoothDevice)
    throws Exception
  {
    paramClass = paramClass.getDeclaredMethod("connect", new Class[] { BluetoothDevice.class });
    paramClass.setAccessible(true);
    return ((Boolean)paramClass.invoke(paramBluetoothProfile, new Object[] { paramBluetoothDevice })).booleanValue();
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        byte[] arrayOfByte = paramString.getBytes("UTF-8");
        if (arrayOfByte.length > 0)
        {
          paramString = arrayOfByte;
          if (arrayOfByte.length <= 16) {}
        }
        else
        {
          return null;
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        com.baidu.carlife.core.i.e("BluetoothDevice", "UTF-8 not supported?!?");
      }
    }
    return null;
  }
  
  public static String b()
  {
    String str = "";
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter != null) {
      str = localBluetoothAdapter.getName();
    }
    return str;
  }
  
  public static boolean b(Class<?> paramClass, BluetoothDevice paramBluetoothDevice)
    throws Exception
  {
    com.baidu.carlife.core.i.c("BluetoothDevice", "cancelBondProcess");
    return ((Boolean)paramClass.getDeclaredMethod("cancelBondProcess", new Class[0]).invoke(paramBluetoothDevice, new Object[0])).booleanValue();
  }
  
  public static boolean b(Class<?> paramClass, BluetoothProfile paramBluetoothProfile, BluetoothDevice paramBluetoothDevice)
    throws Exception
  {
    paramClass = paramClass.getDeclaredMethod("disconnect", new Class[] { BluetoothDevice.class });
    paramClass.setAccessible(true);
    return ((Boolean)paramClass.invoke(paramBluetoothProfile, new Object[] { paramBluetoothDevice })).booleanValue();
  }
  
  public static void c()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    try
    {
      Method localMethod1 = BluetoothAdapter.class.getMethod("setDiscoverableTimeout", new Class[] { Integer.TYPE });
      localMethod1.setAccessible(true);
      Method localMethod2 = BluetoothAdapter.class.getMethod("setScanMode", new Class[] { Integer.TYPE, Integer.TYPE });
      localMethod2.setAccessible(true);
      localMethod1.invoke(localBluetoothAdapter, new Object[] { Integer.valueOf(1) });
      localMethod2.invoke(localBluetoothAdapter, new Object[] { Integer.valueOf(21), Integer.valueOf(1) });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean c(Class<?> paramClass, BluetoothDevice paramBluetoothDevice)
    throws Exception
  {
    com.baidu.carlife.core.i.c("BluetoothDevice", "removeBond");
    return ((Boolean)paramClass.getMethod("removeBond", new Class[0]).invoke(paramBluetoothDevice, new Object[0])).booleanValue();
  }
  
  public static boolean c(Class<?> paramClass, BluetoothProfile paramBluetoothProfile, BluetoothDevice paramBluetoothDevice)
    throws Exception
  {
    paramClass = paramClass.getDeclaredMethod("disconnect", new Class[] { BluetoothDevice.class });
    paramClass.setAccessible(true);
    return ((Boolean)paramClass.invoke(paramBluetoothProfile, new Object[] { paramBluetoothDevice })).booleanValue();
  }
  
  public static boolean d()
  {
    com.baidu.carlife.core.i.b("BluetoothDevice", "channel ID = " + f.jx);
    return f.jx.equals(f.a.l);
  }
  
  public static boolean d(Class<?> paramClass, BluetoothDevice paramBluetoothDevice)
    throws Exception
  {
    return ((Boolean)paramClass.getDeclaredMethod("cancelPairingUserInput", new Class[0]).invoke(paramBluetoothDevice, new Object[0])).booleanValue();
  }
  
  private static String e()
  {
    try
    {
      Object localObject = BluetoothAdapter.getDefaultAdapter();
      Field localField = localObject.getClass().getDeclaredField("mService");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      if (localObject == null) {
        return null;
      }
      localObject = localObject.getClass().getMethod("getAddress", new Class[0]).invoke(localObject, new Object[0]);
      if ((localObject != null) && ((localObject instanceof String)))
      {
        localObject = (String)localObject;
        return (String)localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */