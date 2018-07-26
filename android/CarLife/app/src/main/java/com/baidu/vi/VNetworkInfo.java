package com.baidu.vi;

import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class VNetworkInfo {
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    public int state;
    public int type;
    public String typename;

    /* renamed from: com.baidu.vi.VNetworkInfo$1 */
    static /* synthetic */ class C52391 {
        /* renamed from: a */
        static final /* synthetic */ int[] f21735a = new int[State.values().length];

        static {
            try {
                f21735a[State.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21735a[State.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21735a[State.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21735a[State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21735a[State.SUSPENDED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public VNetworkInfo(NetworkInfo info) {
        this.typename = info.getTypeName();
        this.type = info.getType();
        switch (C52391.f21735a[info.getState().ordinal()]) {
            case 1:
                this.state = 2;
                return;
            case 2:
                this.state = 1;
                return;
            default:
                this.state = 0;
                return;
        }
    }
}
