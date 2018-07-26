package com.baidu.platform.comjni.tools;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public class MagicMsg extends MessageMicro {
    public byte[] buffer;

    public int getCachedSize() {
        return 0;
    }

    public int getSerializedSize() {
        return 0;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
    }

    public MessageMicro mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return null;
    }
}
