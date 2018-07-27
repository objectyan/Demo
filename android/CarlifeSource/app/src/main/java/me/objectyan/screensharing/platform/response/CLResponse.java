package com.baidu.carlife.platform.response;

public abstract class CLResponse {
    public static final int ERROR_NETWORK_FAILED = 1;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_SERVER_FAILED = 2;
    public static final int ERROR_UNKNOWN = 3;
    public static final int RESPONSE_GET_ALBUM_LIST = 1;
    public static final int RESPONSE_GET_SONG_DATA = 3;
    public static final int RESPONSE_GET_SONG_LIST = 2;
    public static final int RESPONSE_UNSUPPORT_API = 0;
    public String errorMsg;
    public int errorNo;
    public long requestId;

    public abstract int getResponseType();
}
