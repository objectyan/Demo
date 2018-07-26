package com.baidu.che.codriver.protocol.data;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.JsonObject;

public class ChannelResult implements INoProguard {
    public JsonObject data;
    public String errmsg;
    public int errno;

    public String toString() {
        return "BaseResult{errno='" + this.errno + '\'' + ", errmsg='" + this.errmsg + '\'' + ", data='" + this.data + '\'' + '}';
    }
}
