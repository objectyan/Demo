package com.baidu.navisdk.model.datastruct;

public class RoutePlanTime {
    public int hour;
    public int minute;
    public boolean valid;

    public RoutePlanTime(int hour, int minute, boolean b) {
        this.hour = hour;
        this.minute = minute;
        this.valid = b;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setValid(boolean b) {
        this.valid = b;
    }
}
