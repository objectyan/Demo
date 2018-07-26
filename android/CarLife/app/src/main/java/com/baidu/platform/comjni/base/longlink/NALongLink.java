package com.baidu.platform.comjni.base.longlink;

import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comjni.C2912a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NALongLink extends C2912a {
    /* renamed from: a */
    private static Map<Integer, LinkedList<Object>> f19997a = new ConcurrentHashMap();

    private static native int nativeCreate();

    private static native boolean nativeInit(int i, String str, String str2);

    private static native boolean nativeRegister(int i, int i2);

    private static native int nativeRelease(int i);

    private static native int nativeSendData(int i, int i2, int i3, byte[] bArr);

    private static native int nativeSendFileData(int i, int i2, int i3, String str, ArrayList<LongLinkFileData> arrayList);

    private static native boolean nativeStart(int i);

    private static native boolean nativeStop(int i);

    private static native boolean nativeUnRegister(int i, int i2);

    public static int create() {
        return nativeCreate();
    }

    public static int release(int addr) {
        return nativeRelease(addr);
    }

    public static boolean init(int addr, String domain, String params) {
        return nativeInit(addr, domain, params);
    }

    public static boolean register(int addr, int moduleId, Object callback) {
        LinkedList<Object> list = (LinkedList) f19997a.get(Integer.valueOf(moduleId));
        if (list == null) {
            list = new LinkedList();
            list.add(callback);
            f19997a.put(Integer.valueOf(moduleId), list);
            return nativeRegister(addr, moduleId);
        }
        if (!list.contains(callback)) {
            list.add(callback);
            f19997a.put(Integer.valueOf(moduleId), list);
        }
        return true;
    }

    public static boolean unRegister(int addr, int moduleId, Object callback) {
        LinkedList<Object> list = (LinkedList) f19997a.get(Integer.valueOf(moduleId));
        if (list == null) {
            return false;
        }
        if (callback != null) {
            list.remove(callback);
        }
        if (!list.isEmpty()) {
            return true;
        }
        f19997a.remove(Integer.valueOf(moduleId));
        return nativeUnRegister(addr, moduleId);
    }

    public static int sendData(int addr, int moduleId, int reqId, byte[] dataBuffer) {
        return nativeSendData(addr, moduleId, reqId, dataBuffer);
    }

    public static int sendFileData(int addr, int moduleId, int reqId, String fileNameParams, ArrayList<LongLinkFileData> fileData) {
        return nativeSendFileData(addr, moduleId, reqId, fileNameParams, fileData);
    }

    public static boolean start(int addr) {
        return nativeStart(addr);
    }

    public static boolean stop(int addr) {
        return nativeStop(addr);
    }

    public static boolean onJNILongLinkDataCallback(int moduleId, int status, int reqId, byte[] dataBuffer, boolean isPush) {
        C2911f.e("JNILongLink", "onJNILongLinkDataCallback:" + moduleId + " status:" + status + " reqId:" + reqId + " isPush:" + isPush);
        byte[] dataParam = dataBuffer;
        if (dataBuffer == null || dataBuffer.length <= 0) {
            dataParam = new byte[0];
        }
        LinkedList<Object> callbacks = (LinkedList) f19997a.get(Integer.valueOf(moduleId));
        if (callbacks != null) {
            Iterator it = new LinkedList(callbacks).iterator();
            while (it.hasNext()) {
                Object o = it.next();
                if (o instanceof LongLinkDataCallback) {
                    ELongLinkStatus retStatus = ELongLinkStatus.values()[status];
                    retStatus.setRequestId(reqId);
                    ((LongLinkDataCallback) o).onReceiveData(retStatus, reqId, dataParam, isPush);
                }
            }
        }
        return true;
    }
}
