package com.baidu.navisdk.vi;

import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class VNetworkInfo {
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    public int state;
    public int type;
    public String typename;

    /* renamed from: com.baidu.navisdk.vi.VNetworkInfo$1 */
    static /* synthetic */ class C47371 {
        static final /* synthetic */ int[] $SwitchMap$android$net$NetworkInfo$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$android$net$NetworkInfo$State[State.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$net$NetworkInfo$State[State.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$net$NetworkInfo$State[State.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$net$NetworkInfo$State[State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$net$NetworkInfo$State[State.SUSPENDED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public VNetworkInfo(NetworkInfo info) {
        if (info == null) {
            this.state = 0;
            return;
        }
        this.typename = info.getTypeName();
        this.type = info.getType();
        switch (C47371.$SwitchMap$android$net$NetworkInfo$State[info.getState().ordinal()]) {
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
