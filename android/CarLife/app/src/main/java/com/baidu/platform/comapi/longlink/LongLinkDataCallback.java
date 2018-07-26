package com.baidu.platform.comapi.longlink;

public interface LongLinkDataCallback {
    boolean onReceiveData(ELongLinkStatus eLongLinkStatus, int i, byte[] bArr, boolean z);
}
