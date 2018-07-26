package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.telephony.SmsMessage;
import com.baidu.sapi2.utils.C4913L;

final class SapiWebView$SMSReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private Handler f20140a;

    public SapiWebView$SMSReceiver(Handler handler) {
        this.f20140a = handler;
    }

    @TargetApi(4)
    public void onReceive(Context context, Intent intent) {
        try {
            Object[] messages = (Object[]) intent.getExtras().get("pdus");
            SmsMessage[] smsMessage = new SmsMessage[messages.length];
            for (int n = 0; n < messages.length; n++) {
                smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
                String code = m16121a(smsMessage[n].getMessageBody());
                if (this.f20140a != null) {
                    Message message = this.f20140a.obtainMessage();
                    message.obj = code;
                    this.f20140a.sendMessage(message);
                }
            }
        } catch (Throwable e) {
            C4913L.m16375e(e, e.getMessage(), new Object[0]);
        }
    }

    /* renamed from: a */
    private String m16121a(String par) {
        for (String d : par.replaceAll("[^0-9]*([0-9]*)[^0-9]*", "$1-").split("-")) {
            if (d.length() == 6) {
                return d;
            }
        }
        return "";
    }
}
