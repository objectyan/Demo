package com.baidu.carlife.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;

class BtManagerBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ BtManager f2643a;

    BtManagerBroadcastReceiver(BtManager this$0) {
        this.f2643a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        final BluetoothDevice device;
        if (BtUtils.f2830c.equals(action)) {
            device = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int type = intent.getIntExtra(BtUtils.f2828a, Integer.MIN_VALUE);
            String address = device.getAddress();
            switch (type) {
                case 0:
                    if (address != null) {
                        try {
                            if (address.equals(this.f2643a.f2769A)) {
                                this.f2643a.f2782w.postDelayed(new Runnable(this) {
                                    /* renamed from: b */
                                    final /* synthetic */ BtManagerBroadcastReceiver f2640b;

                                    public void run() {
                                        try {
                                            LogUtil.m4440c(BtManager.f2747a, "Input Pin code automatically,result=" + BtUtils.m3609a(device.getClass(), device, "0000"));
                                            BtUtils.m3620d(device.getClass(), device);
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
                            final /* synthetic */ BtManagerBroadcastReceiver f2642b;

                            public void run() {
                                try {
                                    LogUtil.d(BtManager.f2747a, "Confirm passkey pairing,result=" + BtUtils.m3610a(device.getClass(), device, true));
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
                    LogUtil.d(BtManager.f2747a, "Bluetooth Adapter is enabling...");
                    return;
                case 12:
                    if (!(this.f2643a.f2782w == null || this.f2643a.f2774F == null)) {
                        this.f2643a.f2782w.removeCallbacks(this.f2643a.f2774F);
                    }
                    LogUtil.d(BtManager.f2747a, "Bluetooth Adapter is enabled!!!!");
                    return;
                default:
                    return;
            }
        } else if (BtUtils.f2831d.equals(action)) {
            state = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
            addr = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
            if (addr.equals(this.f2643a.f2769A)) {
                switch (state) {
                    case 10:
                        LogUtil.d(BtManager.f2747a, "HU is not Bonded");
                        return;
                    case 11:
                        LogUtil.d(BtManager.f2747a, "HU is Bonding");
                        return;
                    case 12:
                        LogUtil.d(BtManager.f2747a, "HU is Bonded, Stop polling bond state");
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
            LogUtil.d(BtManager.f2747a, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED: remote addr = " + addr + "state = " + state);
            if (addr != null && addr.equals(this.f2643a.f2769A)) {
                switch (state) {
                    case 1:
                        return;
                    case 2:
                        LogUtil.d(BtManager.f2747a, "HU is connected, Stop any polling");
                        this.f2643a.m3507n();
                        if (BtUtils.m3619d()) {
                            this.f2643a.f2781v.sendEmptyMessageDelayed(CommonParams.fX, 9000);
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
