package me.objectyan.screensharing.core.audio;


public class Pair {

    private byte[] mData;

    private int mSize;

    Pair() {
    }

    Pair(byte[] data, int size) {
        this.mData = data;
        this.mSize = size;
    }


    public void setData(byte[] data) {
        this.mData = data;
    }


    public byte[] getData() {
        return this.mData;
    }


    public void setSize(int size) {
        this.mSize = size;
    }


    public int getSize() {
        return this.mSize;
    }

}
