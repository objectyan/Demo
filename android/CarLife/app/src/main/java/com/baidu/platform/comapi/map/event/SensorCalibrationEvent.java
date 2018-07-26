package com.baidu.platform.comapi.map.event;

public class SensorCalibrationEvent {
    private String from = null;
    private boolean ifNeed = false;

    public boolean isIfNeed() {
        return this.ifNeed;
    }

    public String getFrom() {
        return this.from;
    }

    public SensorCalibrationEvent(boolean ifNeed) {
        this.ifNeed = ifNeed;
    }

    public SensorCalibrationEvent(boolean ifNeed, String from) {
        this.ifNeed = ifNeed;
        this.from = from;
    }
}
