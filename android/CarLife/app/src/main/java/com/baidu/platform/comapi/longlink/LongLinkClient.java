package com.baidu.platform.comapi.longlink;

import com.baidu.platform.comapi.p207a.C4754a;
import com.baidu.platform.comapi.p207a.C4755b;
import com.baidu.platform.comjni.base.longlink.NALongLink;
import java.util.ArrayList;

public class LongLinkClient {
    /* renamed from: a */
    private int f19845a;
    /* renamed from: b */
    private int f19846b;
    /* renamed from: c */
    private int f19847c;

    public static LongLinkClient create() throws C4754a {
        int addr = NALongLink.create();
        if (addr != 0) {
            return new LongLinkClient(addr);
        }
        throw new C4754a("LongLink Component created failed!");
    }

    public static LongLinkClient create(int moduleId) throws C4754a {
        int addr = NALongLink.create();
        if (addr != 0) {
            return new LongLinkClient(addr, moduleId);
        }
        throw new C4754a("LongLink Component created failed!");
    }

    public boolean init(String domain, String params) throws C4755b {
        if (isValid()) {
            return NALongLink.init(this.f19846b, domain, params);
        }
        throw new C4755b();
    }

    public int release() {
        if (isValid() && NALongLink.release(this.f19846b) <= 0) {
            this.f19846b = 0;
        }
        return -1;
    }

    private LongLinkClient(int nativeJniPtr, int longlinkModuleId) {
        this.f19846b = nativeJniPtr;
        this.f19845a = longlinkModuleId;
    }

    private LongLinkClient(int nativeJniPtr) {
        this.f19846b = nativeJniPtr;
    }

    public void setModuleId(int longlinkModuleId) {
        this.f19845a = longlinkModuleId;
    }

    public boolean isValid() {
        return this.f19846b != 0;
    }

    public synchronized int getRequestId() {
        return this.f19847c;
    }

    public synchronized boolean register(LongLinkDataCallback callback) throws C4755b {
        if (isValid()) {
        } else {
            throw new C4755b();
        }
        return NALongLink.register(this.f19846b, this.f19845a, callback);
    }

    public synchronized boolean unRegister(LongLinkDataCallback callback) throws C4755b {
        if (isValid()) {
        } else {
            throw new C4755b();
        }
        return NALongLink.unRegister(this.f19846b, this.f19845a, callback);
    }

    public synchronized ELongLinkStatus sendData(byte[] dataBuffer) throws C4755b {
        ELongLinkStatus status;
        if (isValid()) {
            this.f19847c++;
            status = ELongLinkStatus.values()[NALongLink.sendData(this.f19846b, this.f19845a, this.f19847c, dataBuffer)];
            status.setRequestId(this.f19847c);
        } else {
            throw new C4755b();
        }
        return status;
    }

    public synchronized ELongLinkStatus sendFileData(String fileParams, ArrayList<LongLinkFileData> fileData) throws C4755b {
        ELongLinkStatus status;
        if (isValid()) {
            this.f19847c++;
            status = ELongLinkStatus.values()[NALongLink.sendFileData(this.f19846b, this.f19845a, this.f19847c, fileParams, fileData)];
            status.setRequestId(this.f19847c);
        } else {
            throw new C4755b();
        }
        return status;
    }

    public boolean start() throws C4755b {
        if (isValid()) {
            return NALongLink.start(this.f19846b);
        }
        throw new C4755b();
    }

    public void stop() throws C4755b {
        if (isValid()) {
            NALongLink.stop(this.f19846b);
            return;
        }
        throw new C4755b();
    }
}
