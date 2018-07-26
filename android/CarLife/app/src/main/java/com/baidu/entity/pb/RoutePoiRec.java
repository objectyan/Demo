package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RoutePoiRec extends MessageMicro {
    public static final int RECOMMDATA_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<RouteItem> f14278a = Collections.emptyList();
    /* renamed from: b */
    private int f14279b = -1;

    public static RoutePoiRec parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new RoutePoiRec().mergeFrom(codedInputStreamMicro);
    }

    public static RoutePoiRec parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (RoutePoiRec) new RoutePoiRec().mergeFrom(bArr);
    }

    public RoutePoiRec addRecommdata(RouteItem routeItem) {
        if (routeItem != null) {
            if (this.f14278a.isEmpty()) {
                this.f14278a = new ArrayList();
            }
            this.f14278a.add(routeItem);
        }
        return this;
    }

    public final RoutePoiRec clear() {
        clearRecommdata();
        this.f14279b = -1;
        return this;
    }

    public RoutePoiRec clearRecommdata() {
        this.f14278a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f14279b < 0) {
            getSerializedSize();
        }
        return this.f14279b;
    }

    public RouteItem getRecommdata(int i) {
        return (RouteItem) this.f14278a.get(i);
    }

    public int getRecommdataCount() {
        return this.f14278a.size();
    }

    public List<RouteItem> getRecommdataList() {
        return this.f14278a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (RouteItem computeMessageSize : getRecommdataList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f14279b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public RoutePoiRec mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro routeItem = new RouteItem();
                    codedInputStreamMicro.readMessage(routeItem);
                    addRecommdata(routeItem);
                    continue;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public RoutePoiRec setRecommdata(int i, RouteItem routeItem) {
        if (routeItem != null) {
            this.f14278a.set(i, routeItem);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (RouteItem writeMessage : getRecommdataList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
