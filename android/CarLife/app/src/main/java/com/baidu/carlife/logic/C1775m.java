package com.baidu.carlife.logic;

import android.os.Bundle;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;

/* compiled from: NaviVoiceCommandDispatch */
/* renamed from: com.baidu.carlife.logic.m */
public class C1775m {
    /* renamed from: a */
    private static C1775m f5411a = null;
    /* renamed from: b */
    private static Object f5412b = new Object();

    /* renamed from: a */
    public static C1775m m6511a() {
        if (f5411a == null) {
            synchronized (f5412b) {
                if (f5411a == null) {
                    f5411a = new C1775m();
                }
            }
        }
        return f5411a;
    }

    /* renamed from: a */
    public void m6515a(int cmd, String arg) {
        Bundle bd = new Bundle();
        bd.putString("poiname", arg);
        BNVoiceCommandController.getInstance().handleVoiceCommandMsg(m6512b(cmd), m6513c(cmd), 0, bd);
    }

    /* renamed from: a */
    public void m6514a(int cmd) {
        BNVoiceCommandController.getInstance().handleVoiceCommandMsg(m6512b(cmd), m6513c(cmd), 0, null);
    }

    /* renamed from: b */
    private int m6512b(int cmd) {
        return 5;
    }

    /* renamed from: c */
    private int m6513c(int cmd) {
        switch (cmd) {
            case 4152:
                return 5;
            case 4153:
                return 6;
            case 4154:
                return 3;
            case 4155:
                return 4;
            default:
                return 0;
        }
    }
}
