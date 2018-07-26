package com.indooratlas.android.sdk;

import android.os.Bundle;

public interface IALocationListener {
    void onLocationChanged(IALocation iALocation);

    void onStatusChanged(String str, int i, Bundle bundle);
}
