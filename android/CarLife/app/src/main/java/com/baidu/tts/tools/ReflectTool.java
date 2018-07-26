package com.baidu.tts.tools;

import java.lang.reflect.Method;

public class ReflectTool {
    public static Method getSupportedMethod(Class<?> cls, String name, Class<?>[] paramTypes) throws NoSuchMethodException {
        if (cls == null) {
            throw new NoSuchMethodException();
        }
        try {
            return cls.getDeclaredMethod(name, paramTypes);
        } catch (NoSuchMethodException e) {
            return getSupportedMethod(cls.getSuperclass(), name, paramTypes);
        }
    }
}
