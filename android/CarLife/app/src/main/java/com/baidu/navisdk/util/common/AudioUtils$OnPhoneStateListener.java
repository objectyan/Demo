package com.baidu.navisdk.util.common;

import android.telephony.PhoneStateListener;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.util.listener.BlueToothListener;

class AudioUtils$OnPhoneStateListener extends PhoneStateListener {
    final /* synthetic */ AudioUtils this$0;

    AudioUtils$OnPhoneStateListener(AudioUtils this$0) {
        this.this$0 = this$0;
    }

    public void onCallStateChanged(int state, String incomingNumber) {
        switch (state) {
            case 0:
                LogUtil.m15791e(AudioUtils.TAG, "CALL_STATE_IDLE");
                AudioUtils.sIsPhoneUsing = false;
                if (AudioUtils.access$000(this.this$0) != null) {
                    AudioUtils.access$000(this.this$0).removeMessages(1001);
                    if (AudioUtils.sIsBTCloseFromPhone) {
                        AudioUtils.sIsBTCloseFromPhone = false;
                        AudioUtils.access$000(this.this$0).sendEmptyMessageDelayed(1001, BNOffScreenParams.MIN_ENTER_INTERVAL);
                        break;
                    }
                }
                break;
            case 1:
                LogUtil.m15791e(AudioUtils.TAG, "CALL_STATE_RINGING");
                AudioUtils.sIsPhoneUsing = true;
                if (AudioUtils.access$000(this.this$0) != null && BlueToothListener.sIsOpenBTChannel) {
                    AudioUtils.access$000(this.this$0).removeMessages(1001);
                    AudioUtils.access$000(this.this$0).removeMessages(1002);
                    if (!(AudioUtils.access$100(this.this$0) == null || AudioUtils.access$200(this.this$0) == null || !this.this$0.isSCOConnect())) {
                        AudioUtils.sIsBTCloseFromPhone = true;
                    }
                    AudioUtils.access$000(this.this$0).sendEmptyMessage(1002);
                    break;
                }
            case 2:
                LogUtil.m15791e(AudioUtils.TAG, "CALL_STATE_OFFHOOK");
                AudioUtils.sIsPhoneUsing = true;
                if (AudioUtils.access$000(this.this$0) != null && BlueToothListener.sIsOpenBTChannel) {
                    AudioUtils.access$000(this.this$0).removeMessages(1001);
                    AudioUtils.access$000(this.this$0).removeMessages(1002);
                    if (!(AudioUtils.access$100(this.this$0) == null || AudioUtils.access$200(this.this$0) == null || !this.this$0.isSCOConnect())) {
                        AudioUtils.sIsBTCloseFromPhone = true;
                    }
                    AudioUtils.access$000(this.this$0).sendEmptyMessageDelayed(1002, 2000);
                    break;
                }
        }
        super.onCallStateChanged(state, incomingNumber);
    }
}
