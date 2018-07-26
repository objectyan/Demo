package com.samsung.android.sdk.motion;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.motion.MRListener;
import android.hardware.scontext.SContextManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;

public class Smotion implements SsdkInterface {
    public static final int TYPE_ACTIVITY = 3;
    public static final int TYPE_ACTIVITY_NOTIFICATION = 4;
    public static final int TYPE_CALL = 0;
    public static final int TYPE_PEDOMETER = 1;
    public static final int TYPE_PEDOMETER_WITH_UPDOWN_STEP = 2;
    /* renamed from: b */
    static boolean f24652b = false;
    /* renamed from: c */
    static boolean f24653c = false;
    /* renamed from: a */
    boolean f24654a = false;
    /* renamed from: d */
    Context f24655d;
    /* renamed from: e */
    private boolean f24656e = false;
    /* renamed from: f */
    private boolean f24657f = false;
    /* renamed from: g */
    private boolean f24658g = false;
    /* renamed from: h */
    private boolean f24659h = false;
    /* renamed from: i */
    private boolean f24660i = false;
    /* renamed from: j */
    private boolean f24661j = false;

    /* renamed from: a */
    private static boolean m21597a() {
        try {
            Class cls = Class.forName("com.samsung.android.feature.FloatingFeature");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            return ((Boolean) cls.getMethod("getEnableStatus", new Class[]{String.class}).invoke(invoke, new Object[]{"SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE"})).booleanValue();
        } catch (RuntimeException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    final void m21598a(Context context, String str) {
        if (m21597a()) {
            try {
                if (context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
                    throw new SecurityException();
                }
                Parcelable contentValues = new ContentValues();
                String name = getClass().getPackage().getName();
                String str2 = context.getPackageName() + "#" + getVersionCode();
                contentValues.put("app_id", name);
                contentValues.put("feature", str2);
                if (!str.equals("initialize()")) {
                    contentValues.put("extra", str);
                }
                Intent intent = new Intent();
                intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
                intent.putExtra("data", contentValues);
                intent.setPackage("com.samsung.android.providers.context");
                context.sendBroadcast(intent);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("Smotion : Context is wrong. ");
            }
        }
    }

    public int getVersionCode() {
        return 9;
    }

    public String getVersionName() {
        return "2.2.1";
    }

    public void initialize(Context context) throws SsdkUnsupportedException {
        if (this.f24654a) {
            throw new IllegalStateException("Smotion : initialize() is already called. ");
        }
        this.f24654a = false;
        if (context == null) {
            throw new IllegalArgumentException("Smotion : Context is null. ");
        }
        try {
            m21598a(context, "initialize()");
            if (SsdkVendorCheck.isSamsungDevice()) {
                this.f24655d = context;
                try {
                    if (this.f24655d == null) {
                        throw new NullPointerException("Smotion : Context is null. ");
                    }
                    if (!this.f24656e) {
                        PackageManager packageManager = this.f24655d.getPackageManager();
                        if (packageManager != null) {
                            try {
                                if (Class.forName("android.hardware.scontext.SContextManager").getMethod("getFeatureLevel", new Class[]{Integer.TYPE}) != null && (packageManager.hasSystemFeature("com.sec.feature.sensorhub") || packageManager.hasSystemFeature("com.sec.feature.scontext_lite"))) {
                                    SContextManager sContextManager = (SContextManager) this.f24655d.getSystemService("scontext");
                                    if (sContextManager != null) {
                                        if (sContextManager.getFeatureLevel(2) > 0) {
                                            this.f24657f = true;
                                            if (packageManager.hasSystemFeature("android.hardware.sensor.barometer")) {
                                                this.f24658g = true;
                                            }
                                        }
                                        if (sContextManager.getFeatureLevel(25) > 0) {
                                            this.f24660i = true;
                                            if (sContextManager.isAvailableService(26)) {
                                                if ((packageManager.getSystemFeatureLevel("com.sec.feature.sensorhub") == 7 || packageManager.getSystemFeatureLevel("com.sec.feature.sensorhub") == 9) && VERSION.SDK_INT <= 19) {
                                                    f24652b = false;
                                                } else {
                                                    f24652b = true;
                                                }
                                            }
                                        }
                                        if (sContextManager.getFeatureLevel(27) > 0) {
                                            this.f24661j = true;
                                        }
                                        if (this.f24660i && this.f24661j) {
                                            f24653c = true;
                                        }
                                    }
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            try {
                                if (Class.forName("android.hardware.motion.MotionRecognitionManager").getMethod("registerListenerEvent", new Class[]{MRListener.class, Integer.TYPE, Integer.TYPE, Handler.class}) != null) {
                                    boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.sensor.accelerometer");
                                    boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.sensor.gyroscope");
                                    boolean hasSystemFeature3 = packageManager.hasSystemFeature("android.hardware.sensor.proximity");
                                    if (hasSystemFeature && hasSystemFeature2 && hasSystemFeature3) {
                                        this.f24659h = true;
                                    }
                                    this.f24656e = true;
                                }
                            } catch (ClassNotFoundException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    this.f24654a = true;
                    if (!isFeatureEnabled(0) && !isFeatureEnabled(1) && !isFeatureEnabled(3) && !isFeatureEnabled(4)) {
                        this.f24654a = false;
                        throw new SsdkUnsupportedException("Smotion : This Device is not supported.", 1);
                    }
                } catch (NullPointerException e3) {
                    throw new IllegalArgumentException("Smotion : Context is wrong. ");
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                }
            } else {
                throw new SsdkUnsupportedException(Build.BRAND + " is not supported.", 0);
            }
        } catch (SecurityException e5) {
            throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
        }
    }

    public boolean isFeatureEnabled(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("Smotion : Type value is wrong. ");
        } else if (this.f24655d == null) {
            throw new IllegalStateException("Smotion : initialize() is not called. ");
        } else if (this.f24654a) {
            switch (i) {
                case 0:
                    return this.f24659h;
                case 1:
                    return this.f24657f;
                case 2:
                    return this.f24658g;
                case 3:
                    return this.f24660i;
                case 4:
                    return this.f24661j;
                default:
                    return false;
            }
        } else {
            throw new IllegalStateException("Smotion : initialize() is not successful. ");
        }
    }
}
