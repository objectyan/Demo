package com.indooratlas.android.sdk.resources;

import android.os.Looper;
import android.support.annotation.Nullable;

public interface IATask<R> {
    void cancel();

    IAResult<R> get();

    boolean isCancelled();

    void setCallback(IAResultCallback<R> iAResultCallback, @Nullable Looper looper);
}
