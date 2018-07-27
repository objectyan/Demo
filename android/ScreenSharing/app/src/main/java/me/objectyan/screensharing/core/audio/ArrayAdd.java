package me.objectyan.screensharing.core.audio;


public class ArrayAdd {

    private static final int len = 20480;

    private byte[] mBytes = new byte[len];


    public void merge(byte[] array1, int len1, byte[] array2, int len2, Pair p) {
        if (this.mBytes.length < len1 + len2) {
            this.mBytes = new byte[(len1 + len2)];
        }
        System.arraycopy(array1, 0, this.mBytes, 0, len1);
        System.arraycopy(array2, 0, this.mBytes, len1, len2);
        p.setData(this.mBytes);
        p.setSize(len1 + len2);
    }
}
