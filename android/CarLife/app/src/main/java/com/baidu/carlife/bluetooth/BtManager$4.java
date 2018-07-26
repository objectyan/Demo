package com.baidu.carlife.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;

class BtManager$4 extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ C1058f f2643a;

    BtManager$4(C1058f this$0) {
        this.f2643a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        final BluetoothDevice device;
        if (C1079i.f2830c.equals(action)) {
            device = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int type = intent.getIntExtra(C1079i.f2828a, Integer.MIN_VALUE);
            String address = device.getAddress();
            switch (type) {
                case 0:
                    if (address != null) {
                        try {
                            if (address.equals(this.f2643a.f2769A)) {
                                this.f2643a.f2782w.postDelayed(new Runnable(this) {
                                    /* renamed from: b */
                                    final /* synthetic */ BtManager$4 f2640b;

                                    public void run() {
                                        try {
                                            C1260i.m4440c(C1058f.f2747a, "Input Pin code automatically,result=" + C1079i.m3609a(device.getClass(), device, "0000"));
                                            C1079i.m3620d(device.getClass(), device);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }, 1000);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 2:
                    if (address != null && address.equals(this.f2643a.f2769A)) {
                        this.f2643a.f2782w.postDelayed(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ BtManager$4 f2642b;

                            public void run() {
                                try {
                                    C1260i.m4435b(C1058f.f2747a, "Confirm passkey pairing,result=" + C1079i.m3610a(device.getClass(), device, true));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 500);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10)) {
                case 10:
                case 13:
                    return;
                case 11:
                    C1260i.m4435b(C1058f.f2747a, "Bluetooth Adapter is enabling...");
                    return;
                case 12:
                    if (!(this.f2643a.f2782w == null || this.f2643a.f2774F == null)) {
                        this.f2643a.f2782w.removeCallbacks(this.f2643a.f2774F);
                    }
                    C1260i.m4435b(C1058f.f2747a, "Bluetooth Adapter is enabled!!!!");
                    return;
                default:
                    return;
            }
        } else if (C1079i.f2831d.equals(action)) {
            state = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
            addr = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
            if (addr.equals(this.f2643a.f2769A)) {
                switch (state) {
                    case 10:
                        C1260i.m4435b(C1058f.f2747a, "HU is not Bonded");
                        return;
                    case 11:
                        C1260i.m4435b(C1058f.f2747a, "HU is Bonding");
                        return;
                    case 12:
                        C1260i.m4435b(C1058f.f2747a, "HU is Bonded, Stop polling bond state");
                        if (this.f2643a.f2782w != null) {
                            this.f2643a.f2782w.removeMessages(23);
                            this.f2643a.f2782w.removeMessages(41);
                        }
                        if (this.f2643a.m3524c() == 0) {
                            this.f2643a.m3485d(addr);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
            device = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            state = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            addr = device.getAddress();
            C1260i.m4435b(C1058f.f2747a, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED: remote addr = " + addr + "state = " + state);
            if (addr != null && addr.equals(this.f2643a.f2769A)) {
                switch (state) {
                    case 1:
                        return;
                    case 2:
                        C1260i.m4435b(C1058f.f2747a, "HU is connected, Stop any polling");
                        this.f2643a.m3507n();
                        if (C1079i.m3619d()) {
                            this.f2643a.f2781v.sendEmptyMessageDelayed(C1253f.fX, 9000);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
