package com.baidu.carlife.p100n;

import android.content.Context;
import android.os.AsyncTask;
import android.os.HandlerThread;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.connect.ConnectManager;
import com.baidu.carlife.protobuf.CarLifeUpdateSuccessProtos.CarLifeUpdateSuccess;
import com.baidu.carlife.protobuf.CarlifeTransferEndProtos.CarlifeTransferEnd;
import com.baidu.carlife.protobuf.CarlifeTransferSendProtos.CarlifeTransferSend;
import com.baidu.carlife.protobuf.CarlifeTransferStartProtos.CarlifeTransferStart;
import com.baidu.carlife.protobuf.CarlifeTransferStartProtos.CarlifeTransferStart.Builder;
import com.baidu.carlife.util.C2201w;
import com.baidu.navisdk.ui.util.DialogReplaceToastUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: FirmwareTransfer */
/* renamed from: com.baidu.carlife.n.b */
public class C1952b {
    /* renamed from: a */
    public static final int f6193a = 8192;
    /* renamed from: b */
    private static final String f6194b = "FirmwareUpdateTool";
    /* renamed from: c */
    private C1951e f6195c;
    /* renamed from: d */
    private C1947a f6196d;
    /* renamed from: e */
    private int f6197e;
    /* renamed from: f */
    private byte[] f6198f;
    /* renamed from: g */
    private int f6199g;
    /* renamed from: h */
    private FileOutputStream f6200h;
    /* renamed from: i */
    private File f6201i;
    /* renamed from: j */
    private Context f6202j;
    /* renamed from: k */
    private HandlerThread f6203k;
    /* renamed from: l */
    private int f6204l;
    /* renamed from: m */
    private String f6205m;
    /* renamed from: n */
    private int f6206n;
    /* renamed from: o */
    private C1962d f6207o;

    /* compiled from: FirmwareTransfer */
    /* renamed from: com.baidu.carlife.n.b$a */
    public interface C1947a {
        /* renamed from: a */
        void mo1724a(long j, int i);

        /* renamed from: a */
        void mo1725a(C1950d c1950d, C1949c c1949c);
    }

    /* compiled from: FirmwareTransfer */
    /* renamed from: com.baidu.carlife.n.b$b */
    private static final class C1948b {
        /* renamed from: a */
        private static final C1952b f6179a = new C1952b();

        private C1948b() {
        }
    }

    /* compiled from: FirmwareTransfer */
    /* renamed from: com.baidu.carlife.n.b$c */
    public enum C1949c {
        NO_ERROR,
        ERROR_FILE,
        ERROR_TRANSFER,
        ERROR_INSTALL
    }

    /* compiled from: FirmwareTransfer */
    /* renamed from: com.baidu.carlife.n.b$d */
    public enum C1950d {
        START,
        TRANSFERING,
        INSTALL,
        CANCEL,
        SUCESS,
        ERROR
    }

    /* compiled from: FirmwareTransfer */
    /* renamed from: com.baidu.carlife.n.b$e */
    private class C1951e extends AsyncTask<Void, Void, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1952b f6192a;

        private C1951e(C1952b c1952b) {
            this.f6192a = c1952b;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7410a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m7411a((Boolean) obj);
        }

        /* renamed from: a */
        protected Boolean m7410a(Void... params) {
            return Boolean.valueOf(this.f6192a.m7421d());
        }

        /* renamed from: a */
        protected void m7411a(Boolean result) {
            super.onPostExecute(result);
            LogUtil.d(C1952b.f6194b, "OnPostExecute: " + result);
            if (result.booleanValue()) {
                C1947a b = this.f6192a.f6196d;
                C1950d c1950d = C1950d.SUCESS;
                b.mo1725a(C1950d.SUCESS, C1949c.NO_ERROR);
                return;
            }
            this.f6192a.f6196d.mo1725a(C1950d.ERROR, C1949c.ERROR_FILE);
        }
    }

    private C1952b() {
        this.f6197e = 3719354;
        this.f6204l = 0;
        this.f6205m = null;
        this.f6206n = -1;
    }

    /* renamed from: a */
    public static C1952b m7413a() {
        return C1948b.f6179a;
    }

    /* renamed from: a */
    public void m7423a(Context context, C1947a callBack) {
        this.f6202j = context;
        this.f6196d = callBack;
    }

    /* renamed from: a */
    public void m7425a(C1947a callBack) {
        this.f6196d = callBack;
    }

    /* renamed from: a */
    public void m7426a(String strServerUrl, String strVersion) {
        this.f6207o.m7480a(strServerUrl, strVersion);
    }

    /* renamed from: a */
    public static long m7412a(File file) throws Exception {
        if (file == null) {
            return 0;
        }
        if (!file.exists()) {
            return 0;
        }
        FileInputStream fis = new FileInputStream(file);
        long size = (long) fis.available();
        fis.close();
        return size;
    }

    /* renamed from: a */
    public void m7422a(int nSize) {
        Builder builder = CarlifeTransferStart.newBuilder();
        builder.setUpdateSize(nSize);
        CarlifeTransferStart transferStart = builder.build();
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.m4201c(CommonParams.bP);
        command.m4199b(transferStart.toByteArray());
        command.m4203d(transferStart.getSerializedSize());
        LogUtil.d(f6194b, "Start transfer data");
        ConnectManager.m4228a().m4241b(command);
    }

    /* renamed from: a */
    private boolean m7416a(byte[] buffer, int len) {
        CarlifeTransferSend.Builder builder = CarlifeTransferSend.newBuilder();
        builder.setBodyData(ByteString.copyFrom(buffer, 0, len));
        builder.setPacketSize(len);
        CarlifeTransferSend transferSend = builder.build();
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.m4201c(CommonParams.bQ);
        command.m4199b(transferSend.toByteArray());
        command.m4203d(transferSend.getSerializedSize());
        if (ConnectManager.m4228a().m4241b(command) != -1) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void m7427b(int newversioncode) {
        CarlifeTransferEnd.Builder builder = CarlifeTransferEnd.newBuilder();
        builder.setNewFirmwareVersionCode(newversioncode);
        CarlifeTransferEnd endmsg = builder.build();
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.m4201c(CommonParams.bR);
        command.m4199b(endmsg.toByteArray());
        command.m4203d(endmsg.getSerializedSize());
        LogUtil.d(f6194b, "Start transfer data");
        ConnectManager.m4228a().m4241b(command);
    }

    /* renamed from: a */
    public void m7424a(CarlifeCmdMessage msg) {
        C2201w.m8369a();
        C2201w.m8373a("传输完成，车机端开始安装更新!", (int) DialogReplaceToastUtils.LONG_TIME);
    }

    /* renamed from: b */
    public boolean m7428b() {
        if (CarlifeUtil.m4358a().m4401r()) {
            m7426a(null, null);
            return true;
        }
        LogUtil.d(f6194b, "NetworkAvailable Error");
        return false;
    }

    /* renamed from: c */
    public void m7429c(int verCode) {
        this.f6206n = verCode;
        String strFile = C1962d.m7476f();
        LogUtil.d(f6194b, "startTransferData: " + strFile);
        try {
            LogUtil.d(f6194b, "### size: " + C1952b.m7412a(new File(strFile)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        m7422a(this.f6204l);
        this.f6195c = new C1951e();
        this.f6195c.execute(new Void[0]);
    }

    /* renamed from: b */
    private void m7418b(CarlifeCmdMessage msg) {
        try {
            String strMsg = "车机端安装完成! 版本号：" + CarLifeUpdateSuccess.parseFrom(msg.m4205f()).getVersionCode();
            C2201w.m8369a();
            C2201w.m8373a(strMsg, (int) DialogReplaceToastUtils.LONG_TIME);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private CarlifeTransferSend m7419c(CarlifeCmdMessage msg) {
        try {
            return CarlifeTransferSend.parseFrom(msg.m4205f());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private void m7420c() {
        if (this.f6201i != null && this.f6201i.exists()) {
            this.f6201i.delete();
        }
    }

    /* renamed from: a */
    private void m7414a(long total, int nPercent) {
        if (this.f6196d != null) {
            this.f6196d.mo1724a(total, nPercent);
        }
    }

    /* renamed from: d */
    private boolean m7421d() {
        boolean bTransferResult = true;
        try {
            File file = new File(C1962d.m7476f());
            long fileSize = file.length();
            if (fileSize > 2147483647L) {
                LogUtil.m4445e(f6194b, "file too big...");
                return false;
            }
            LogUtil.d(f6194b, "transfer data start: " + fileSize);
            FileInputStream fi = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int nIndex = 0;
            int sumRead = 0;
            while (((long) sumRead) < fileSize) {
                int numRead = fi.read(buffer);
                if (!m7416a(buffer, numRead)) {
                    bTransferResult = false;
                    break;
                }
                sumRead += numRead;
                nIndex++;
                m7414a(fileSize, (int) (((((double) sumRead) + 0.0d) / ((double) fileSize)) * 100.0d));
                LogUtil.m4445e(f6194b, "transferData : [" + nIndex + " : " + sumRead);
            }
            m7427b(this.f6206n);
            if (((long) sumRead) < fileSize) {
                LogUtil.m4445e(f6194b, "Could not completely read file: " + sumRead);
                bTransferResult = false;
            }
            fi.close();
            LogUtil.d(f6194b, "transfer end: " + sumRead);
            return bTransferResult;
        } catch (IOException ex) {
            LogUtil.m4445e(f6194b, "transfer data error!!!");
            ex.printStackTrace();
        }
    }
}
