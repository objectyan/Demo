package com.tencent.p280a.p281a.p282a.p283a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* renamed from: com.tencent.a.a.a.a.b */
final class C6080b extends C6079f {
    C6080b(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected final void mo4973a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to InternalStorage");
            C6078a.m21639a(Environment.getExternalStorageDirectory() + "/" + C6085h.m21669c("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), C6085h.m21669c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(C6085h.m21669c("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
    }

    /* renamed from: a */
    protected final boolean mo4974a() {
        return C6085h.m21665a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: b */
    protected final String mo4975b() {
        String str;
        synchronized (this) {
            Log.i("MID", "read mid from InternalStorage");
            try {
                for (String str2 : C6078a.m21640a(new File(Environment.getExternalStorageDirectory(), C6085h.m21669c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(C6085h.m21669c("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        Log.i("MID", "read mid from InternalStorage:" + split[1]);
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (Throwable e) {
                Log.w("MID", e);
                str2 = null;
            }
        }
        return str2;
    }
}
