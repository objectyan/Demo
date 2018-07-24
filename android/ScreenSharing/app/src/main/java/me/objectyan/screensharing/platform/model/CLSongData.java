package com.baidu.carlife.platform.model;

public class CLSongData {
    public static final int TAG_CONTENT = 1;
    public static final int TAG_END = 2;
    public static final int TAG_START = 0;
    public byte[] data;
    public int len;
    public long offset;
    public String songId;
    public int tag;
    public long totalSize;
}
