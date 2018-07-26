package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.baidu.android.pushservice.p032k.C0582b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* renamed from: com.baidu.android.pushservice.d */
public class C0475d {
    /* renamed from: a */
    private static String f1572a = "NotificationBuilderManager";
    /* renamed from: b */
    private static String f1573b = "notification_builder_storage";
    /* renamed from: c */
    private static Object f1574c = new Object();
    /* renamed from: d */
    private static int f1575d = 0;

    /* renamed from: a */
    public static Notification m2051a(Context context, int i, int i2, String str, String str2, boolean z) {
        Notification construct;
        synchronized (f1574c) {
            PushNotificationBuilder a = C0475d.m2054a(context, i);
            a.setNotificationTitle(str);
            a.setNotificationText(str2);
            construct = a.construct(context);
            if ((i2 & 1) != 0) {
                construct.flags &= -33;
            } else {
                construct.flags |= 32;
            }
            if (z) {
                construct.defaults = 0;
            } else {
                construct.defaults = -1;
                if ((i2 & 4) != 0) {
                    construct.defaults |= 1;
                } else {
                    construct.defaults &= -2;
                }
                if ((i2 & 2) != 0) {
                    construct.defaults |= 2;
                } else {
                    construct.defaults &= -3;
                }
            }
        }
        return construct;
    }

    /* renamed from: a */
    public static Notification m2052a(Context context, int i, String str, String str2, boolean z) {
        Notification construct;
        synchronized (f1574c) {
            PushNotificationBuilder a = C0475d.m2054a(context, i);
            a.setNotificationTitle(str);
            a.setNotificationText(str2);
            construct = a.construct(context);
            if (z) {
                construct.defaults = -1;
            } else {
                construct.defaults = 0;
            }
        }
        return construct;
    }

    /* renamed from: a */
    private static PushNotificationBuilder m2053a(Context context) {
        PushNotificationBuilder basicPushNotificationBuilder = new BasicPushNotificationBuilder();
        basicPushNotificationBuilder.setNotificationFlags(16);
        basicPushNotificationBuilder.setNotificationDefaults(3);
        basicPushNotificationBuilder.setStatusbarIcon(context.getApplicationInfo().icon);
        return basicPushNotificationBuilder;
    }

    /* renamed from: a */
    private static PushNotificationBuilder m2054a(Context context, int i) {
        String string = context.getSharedPreferences(f1573b, 0).getString("" + i, null);
        if (string == null) {
            return C0475d.m2057b(context);
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(C0582b.m2630a(string.getBytes()));
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            PushNotificationBuilder pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
                return pushNotificationBuilder;
            } catch (Exception e) {
                return pushNotificationBuilder;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m2055a(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        synchronized (f1574c) {
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(pushNotificationBuilder);
                String a = C0582b.m2629a(byteArrayOutputStream.toByteArray(), "US-ASCII");
                Editor edit = context.getSharedPreferences(f1573b, 0).edit();
                edit.putString("" + i, a);
                edit.commit();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static void m2056a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        synchronized (f1574c) {
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(pushNotificationBuilder);
                String a = C0582b.m2629a(byteArrayOutputStream.toByteArray(), "US-ASCII");
                Editor edit = context.getSharedPreferences(f1573b, 0).edit();
                edit.putString("" + f1575d, a);
                edit.commit();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    private static PushNotificationBuilder m2057b(Context context) {
        String string = context.getSharedPreferences(f1573b, 0).getString("" + f1575d, null);
        if (string == null) {
            return C0475d.m2053a(context);
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(C0582b.m2630a(string.getBytes()));
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            PushNotificationBuilder pushNotificationBuilder = (PushNotificationBuilder) objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
                return pushNotificationBuilder;
            } catch (Exception e) {
                return pushNotificationBuilder;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: b */
    public static void m2058b(Context context, PushNotificationBuilder pushNotificationBuilder) {
        C0475d.m2055a(context, 8888, pushNotificationBuilder);
    }
}
