package com.baidu.carlife.util;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: PhoneUtil */
/* renamed from: com.baidu.carlife.util.o */
public class C2185o {
    /* renamed from: a */
    public static String f6985a = C2185o.class.getSimpleName();

    /* renamed from: a */
    public static void m8297a(Context context) {
        boolean result = false;
        try {
            Object telephonyObject = C2185o.m8301c(context);
            if (telephonyObject != null) {
                Method endCallMethod = telephonyObject.getClass().getMethod("endCall", new Class[0]);
                endCallMethod.setAccessible(true);
                endCallMethod.invoke(telephonyObject, new Object[0]);
                result = true;
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (!result) {
            C2201w.m8373a("请使用系统电话挂断!", 0);
        }
    }

    /* renamed from: c */
    private static Object m8301c(Context context) {
        Object telephonyObject = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method getITelephony = telephonyManager.getClass().getDeclaredMethod("getITelephony", new Class[0]);
            getITelephony.setAccessible(true);
            telephonyObject = getITelephony.invoke(telephonyManager, new Object[0]);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return telephonyObject;
    }

    /* renamed from: d */
    private static void m8302d(Context context) {
        try {
            Object telephonyObject = C2185o.m8301c(context);
            if (telephonyObject != null) {
                Method endCallMethod = telephonyObject.getClass().getMethod("answerRingingCall", new Class[0]);
                endCallMethod.setAccessible(true);
                endCallMethod.invoke(telephonyObject, new Object[0]);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* renamed from: e */
    private static void m8303e(Context context) {
        if (((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn()) {
            Intent meidaButtonIntent = new Intent("android.intent.action.MEDIA_BUTTON");
            meidaButtonIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
            context.sendOrderedBroadcast(meidaButtonIntent, null);
            return;
        }
        meidaButtonIntent = new Intent("android.intent.action.MEDIA_BUTTON");
        meidaButtonIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
        context.sendOrderedBroadcast(meidaButtonIntent, null);
    }

    /* renamed from: b */
    public static void m8299b(Context context) {
        if (VERSION.SDK_INT >= 9) {
            C2185o.m8303e(context);
        } else {
            C2185o.m8302d(context);
        }
    }

    /* renamed from: a */
    public static void m8298a(Context context, String phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            try {
                context.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + phoneNumber)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m8300b(Context context, String phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            try {
                context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + phoneNumber)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
