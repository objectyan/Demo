package com.indooratlas.android.sdk;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk.IARegion.Listener;
import com.indooratlas.android.sdk._internal.az.C5777a;

public abstract class IALocationManager {
    public static final int CALIBRATION_EXCELLENT = 2;
    public static final int CALIBRATION_GOOD = 1;
    public static final int CALIBRATION_POOR = 0;
    public static final String EXTRA_API_KEY = "com.indooratlas.android.sdk.intent.extras.apiKey";
    public static final String EXTRA_API_SECRET = "com.indooratlas.android.sdk.intent.extras.apiSecret";
    public static final String EXTRA_LOCATION = "com.indooratlas.android.sdk.intent.extras.location";
    public static final String EXTRA_PROXY_ADDRESS = "com.indooratlas.android.sdk.intent.extras.proxyAddress";
    public static final String EXTRA_PROXY_DISABLED = "com.indooratlas.android.sdk.intent.extras.proxyDisabled";
    public static final String EXTRA_PROXY_PORT = "com.indooratlas.android.sdk.intent.extras.proxyPort";
    public static final int STATUS_AVAILABLE = 2;
    public static final int STATUS_CALIBRATION_CHANGED = 11;
    public static final int STATUS_LIMITED = 10;
    public static final int STATUS_OUT_OF_SERVICE = 0;
    public static final int STATUS_TEMPORARILY_UNAVAILABLE = 1;

    public abstract void destroy();

    @NonNull
    public abstract IAExtraInfo getExtraInfo();

    public abstract boolean registerOrientationListener(@NonNull IAOrientationRequest iAOrientationRequest, @NonNull IAOrientationListener iAOrientationListener);

    public abstract boolean registerRegionListener(@NonNull Listener listener);

    public abstract void removeLocationUpdates(@NonNull PendingIntent pendingIntent);

    public abstract boolean removeLocationUpdates(@NonNull IALocationListener iALocationListener);

    public abstract void requestLocationUpdates(@NonNull IALocationRequest iALocationRequest, @NonNull PendingIntent pendingIntent);

    public abstract boolean requestLocationUpdates(@NonNull IALocationRequest iALocationRequest, @NonNull IALocationListener iALocationListener);

    public abstract boolean requestLocationUpdates(@NonNull IALocationRequest iALocationRequest, @NonNull IALocationListener iALocationListener, Looper looper);

    public abstract void setLocation(@NonNull IALocation iALocation);

    public abstract boolean unregisterOrientationListener(@NonNull IAOrientationListener iAOrientationListener);

    public abstract boolean unregisterRegionListener(@NonNull Listener listener);

    public static synchronized IALocationManager create(@NonNull Context context) {
        IALocationManager a;
        synchronized (IALocationManager.class) {
            a = new C5777a(context).a();
        }
        return a;
    }

    public static synchronized IALocationManager create(@NonNull Context context, @Nullable Bundle extras) {
        IALocationManager a;
        synchronized (IALocationManager.class) {
            C5777a c5777a = new C5777a(context);
            if (extras != null) {
                c5777a.f23031b = new Bundle(extras);
            } else {
                c5777a.f23031b = null;
            }
            a = c5777a.a();
        }
        return a;
    }

    @Deprecated
    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }
}
