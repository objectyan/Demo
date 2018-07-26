package com.baidu.mapframework.commonlib.utils;

import java.lang.reflect.Method;

public class VMRuntimeUtil {
    public static long getMinimumHeapSize() {
        try {
            Class clsVMRuntimeClass = Class.forName("dalvik.system.VMRuntime");
            Method getRuntimeMethod = clsVMRuntimeClass.getMethod("getRuntime", new Class[0]);
            new Class[1][0] = Long.TYPE;
            return ((Long) clsVMRuntimeClass.getMethod("getMinimumHeapSize", new Class[0]).invoke(getRuntimeMethod.invoke(null, new Object[0]), new Object[0])).longValue();
        } catch (Throwable th) {
            return 0;
        }
    }

    public static void setMinimumHeapSize(long size) {
        try {
            Class VMRuntimeClass = Class.forName("dalvik.system.VMRuntime");
            Method getRuntimeMethod = VMRuntimeClass.getMethod("getRuntime", new Class[0]);
            VMRuntimeClass.getMethod("setMinimumHeapSize", new Class[]{Long.TYPE}).invoke(getRuntimeMethod.invoke(null, new Object[0]), new Object[]{Long.valueOf(size)});
        } catch (Throwable th) {
        }
    }

    public static float getTargetHeapUtilization() {
        try {
            Class clsVMRuntimeClass = Class.forName("dalvik.system.VMRuntime");
            Method getRuntimeMethod = clsVMRuntimeClass.getMethod("getRuntime", new Class[0]);
            new Class[1][0] = Long.TYPE;
            return ((Float) clsVMRuntimeClass.getMethod("getTargetHeapUtilization", new Class[0]).invoke(getRuntimeMethod.invoke(null, new Object[0]), new Object[0])).floatValue();
        } catch (Throwable th) {
            return 0.0f;
        }
    }

    public static void setTargetHeapUtilization(float value) {
        try {
            Class clsVMRuntimeClass = Class.forName("dalvik.system.VMRuntime");
            Method getRuntimeMethod = clsVMRuntimeClass.getMethod("getRuntime", new Class[0]);
            clsVMRuntimeClass.getMethod("setTargetHeapUtilization", new Class[]{Float.TYPE}).invoke(getRuntimeMethod.invoke(null, new Object[0]), new Object[]{Float.valueOf(value)});
        } catch (Throwable th) {
        }
    }
}
