package com.baidu.platform.comapi.search.convert;

import com.google.protobuf.micro.MessageMicro;

public class ResultCache$Item {
    public Object entity;
    public MessageMicro messageLite;
    public int requestId;
    public int resultType;

    @Deprecated
    public ResultCache$Item(MessageMicro messageLite, Object entity) {
        this.messageLite = messageLite;
        this.entity = entity;
    }

    @Deprecated
    public ResultCache$Item(MessageMicro messageLite, Object entity, int resultType) {
        this.messageLite = messageLite;
        this.entity = entity;
        this.resultType = resultType;
    }

    public ResultCache$Item(MessageMicro messageLite, Object entity, int resultType, int requestId) {
        this.messageLite = messageLite;
        this.entity = entity;
        this.resultType = resultType;
        this.requestId = requestId;
    }
}
