package com.indooratlas.android.sdk.resources;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk._internal.ba;

public abstract class IAResourceManager {
    public abstract IATask<IAFloorPlan> fetchFloorPlanWithId(@NonNull String str);

    public static IAResourceManager create(@NonNull Context context) {
        return new ba(context, null);
    }

    public static IAResourceManager create(@NonNull Context context, @Nullable Bundle extras) {
        return new ba(context, extras);
    }
}
