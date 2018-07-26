package com.baidu.mapframework.nirvana.schedule;

public class DataTaskType implements TaskType {
    /* renamed from: a */
    private final Purpose f19243a;

    private enum Purpose {
        UPDATE_DATA,
        DOWNLOAD,
        STATISTICS
    }

    private DataTaskType(Purpose purpose) {
        this.f19243a = purpose;
    }

    public static DataTaskType forUpdateData() {
        return new DataTaskType(Purpose.UPDATE_DATA);
    }

    public static DataTaskType forDownload() {
        return new DataTaskType(Purpose.DOWNLOAD);
    }

    public static DataTaskType forStatictics() {
        return new DataTaskType(Purpose.STATISTICS);
    }

    public String toString() {
        return "DataTaskType{purpose=" + this.f19243a + '}';
    }
}
