package com.baidu.carlife.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.CommonParams.EnumVehicleChannel;
import com.baidu.carlife.core.LogUtil;
import com.baidu.mobstat.Config;
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

/* compiled from: BtUtils */
/* renamed from: com.baidu.carlife.bluetooth.i */
public class BtUtils {
    /* renamed from: a */
    public static final String f2828a = "android.bluetooth.device.extra.PAIRING_VARIANT";
    /* renamed from: b */
    public static final String f2829b = "android.bluetooth.device.extra.PAIRING_KEY";
    /* renamed from: c */
    public static final String f2830c = "android.bluetooth.device.action.PAIRING_REQUEST";
    /* renamed from: d */
    public static final String f2831d = "android.bluetooth.device.action.BOND_STATE_CHANGED";
    /* renamed from: e */
    public static final String f2832e = "android.bluetooth.device.action.PAIRING_CANCEL";
    /* renamed from: f */
    public static final int f2833f = 0;
    /* renamed from: g */
    public static final int f2834g = 1;
    /* renamed from: h */
    public static final int f2835h = 2;
    /* renamed from: i */
    private static final String f2836i = "BluetoothDevice";

    /* renamed from: a */
    public static String m3605a() {
        String btaddr = "";
        if (VERSION.SDK_INT >= 23) {
            btaddr = Secure.getString(BaiduNaviApplication.getInstance().getApplicationContext().getContentResolver(), "bluetooth_address");
        } else {
            BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
            if (btAdapter != null) {
                btaddr = btAdapter.getAddress();
            }
        }
        if (btaddr == null || Config.DEF_MAC_ID.equals(btaddr)) {
            btaddr = BtUtils.m3621e();
        }
        if (BluetoothAdapter.checkBluetoothAddress(btaddr)) {
            return btaddr.toLowerCase();
        }
        return "";
    }

    /* renamed from: e */
    private static String m3621e() {
        try {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            Field field = bluetoothAdapter.getClass().getDeclaredField("mService");
            field.setAccessible(true);
            Object bluetoothManagerService = field.get(bluetoothAdapter);
            if (bluetoothManagerService == null) {
                return null;
            }
            Object address = bluetoothManagerService.getClass().getMethod("getAddress", new Class[0]).invoke(bluetoothManagerService, new Object[0]);
            return (address == null || !(address instanceof String)) ? null : (String) address;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m3606a(InputStream crunchifyStream) throws IOException {
        if (crunchifyStream == null) {
            return "No Contents";
        }
        Writer crunchifyWriter = new StringWriter();
        char[] crunchifyBuffer = new char[2048];
        try {
            Reader crunchifyReader = new BufferedReader(new InputStreamReader(crunchifyStream, "UTF-8"));
            while (true) {
                int counter = crunchifyReader.read(crunchifyBuffer);
                if (counter == -1) {
                    break;
                }
                crunchifyWriter.write(crunchifyBuffer, 0, counter);
            }
            return crunchifyWriter.toString();
        } finally {
            crunchifyStream.close();
        }
    }

    /* renamed from: b */
    public static String m3613b() {
        String btName = "";
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter != null) {
            return btAdapter.getName();
        }
        return btName;
    }

    /* renamed from: a */
    public static boolean m3608a(Class<?> btClass, BluetoothDevice btDevice) throws Exception {
        if (VERSION.SDK_INT >= 19) {
            return btDevice.createBond();
        }
        LogUtil.m4440c(f2836i, "createBond");
        return ((Boolean) btClass.getDeclaredMethod("createBond", new Class[0]).invoke(btDevice, new Object[0])).booleanValue();
    }

    /* renamed from: b */
    public static boolean m3614b(Class<?> btClass, BluetoothDevice btDevice) throws Exception {
        LogUtil.m4440c(f2836i, "cancelBondProcess");
        return ((Boolean) btClass.getDeclaredMethod("cancelBondProcess", new Class[0]).invoke(btDevice, new Object[0])).booleanValue();
    }

    /* renamed from: c */
    public static boolean m3617c(Class<?> btClass, BluetoothDevice btDevice) throws Exception {
        LogUtil.m4440c(f2836i, "removeBond");
        return ((Boolean) btClass.getMethod("removeBond", new Class[0]).invoke(btDevice, new Object[0])).booleanValue();
    }

    /* renamed from: a */
    public static boolean m3609a(Class<?> btClass, BluetoothDevice btDevice, String pin) throws Exception {
        try {
            if (VERSION.SDK_INT >= 19) {
                return btDevice.setPin(BtUtils.m3612a(pin));
            }
            return ((Boolean) btClass.getDeclaredMethod("setPin", new Class[]{byte[].class}).invoke(btDevice, new Object[]{BtUtils.m3612a(pin)})).booleanValue();
        } catch (SecurityException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m3610a(Class<?> btClass, BluetoothDevice btDevice, boolean confirm) throws Exception {
        if (VERSION.SDK_INT >= 19) {
            return btDevice.setPairingConfirmation(confirm);
        }
        return ((Boolean) btClass.getDeclaredMethod("setPairingConfirmation", new Class[]{Boolean.TYPE}).invoke(btDevice, new Object[]{Boolean.valueOf(confirm)})).booleanValue();
    }

    /* renamed from: d */
    public static boolean m3620d(Class<?> btClass, BluetoothDevice btDevice) throws Exception {
        return ((Boolean) btClass.getDeclaredMethod("cancelPairingUserInput", new Class[0]).invoke(btDevice, new Object[0])).booleanValue();
    }

    /* renamed from: a */
    public static boolean m3611a(Class<?> btClass, BluetoothProfile proxy, BluetoothDevice btDevice) throws Exception {
        Method connectMethod = btClass.getDeclaredMethod("connect", new Class[]{BluetoothDevice.class});
        connectMethod.setAccessible(true);
        return ((Boolean) connectMethod.invoke(proxy, new Object[]{btDevice})).booleanValue();
    }

    /* renamed from: b */
    public static boolean m3615b(Class<?> btClass, BluetoothProfile proxy, BluetoothDevice btDevice) throws Exception {
        Method disconnectMethod = btClass.getDeclaredMethod("disconnect", new Class[]{BluetoothDevice.class});
        disconnectMethod.setAccessible(true);
        return ((Boolean) disconnectMethod.invoke(proxy, new Object[]{btDevice})).booleanValue();
    }

    /* renamed from: a */
    public static void m3607a(int timeout) {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        try {
            Method setDiscoverableTimeout = BluetoothAdapter.class.getMethod("setDiscoverableTimeout", new Class[]{Integer.TYPE});
            setDiscoverableTimeout.setAccessible(true);
            Method setScanMode = BluetoothAdapter.class.getMethod("setScanMode", new Class[]{Integer.TYPE, Integer.TYPE});
            setScanMode.setAccessible(true);
            setDiscoverableTimeout.invoke(adapter, new Object[]{Integer.valueOf(timeout)});
            setScanMode.invoke(adapter, new Object[]{Integer.valueOf(23), Integer.valueOf(timeout)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m3616c() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        try {
            Method setDiscoverableTimeout = BluetoothAdapter.class.getMethod("setDiscoverableTimeout", new Class[]{Integer.TYPE});
            setDiscoverableTimeout.setAccessible(true);
            Method setScanMode = BluetoothAdapter.class.getMethod("setScanMode", new Class[]{Integer.TYPE, Integer.TYPE});
            setScanMode.setAccessible(true);
            setDiscoverableTimeout.invoke(adapter, new Object[]{Integer.valueOf(1)});
            setScanMode.invoke(adapter, new Object[]{Integer.valueOf(21), Integer.valueOf(1)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static boolean m3618c(Class<?> btClass, BluetoothProfile proxy, BluetoothDevice btDevice) throws Exception {
        Method disconnectMethod = btClass.getDeclaredMethod("disconnect", new Class[]{BluetoothDevice.class});
        disconnectMethod.setAccessible(true);
        return ((Boolean) disconnectMethod.invoke(proxy, new Object[]{btDevice})).booleanValue();
    }

    /* renamed from: a */
    public static byte[] m3612a(String pin) {
        if (pin == null) {
            return null;
        }
        try {
            byte[] pinBytes = pin.getBytes("UTF-8");
            if (pinBytes.length <= 0 || pinBytes.length > 16) {
                return null;
            }
            return pinBytes;
        } catch (UnsupportedEncodingException e) {
            LogUtil.m4445e(f2836i, "UTF-8 not supported?!?");
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m3619d() {
        LogUtil.d(f2836i, "channel ID = " + CommonParams.sVehicleChannel);
        if (CommonParams.sVehicleChannel.equals(EnumVehicleChannel.VEHICLE_CHANNEL_AUDI_DUAL_AUDIO)) {
            return true;
        }
        return false;
    }
}
