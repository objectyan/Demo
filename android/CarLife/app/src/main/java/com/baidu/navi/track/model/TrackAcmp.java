package com.baidu.navi.track.model;

public class TrackAcmp {
    private int carMaxDuration = 0;
    private int carNaviDistance = 0;
    private int carWeekMileage = 0;
    private boolean hasCarMaxDuration;
    private boolean hasCarNaviDistance;
    private boolean hasCarWeekMileage;

    public int getCarNintaviDistance() {
        return this.carNaviDistance;
    }

    public boolean hasCarNaviDistance() {
        return this.hasCarNaviDistance;
    }

    public TrackAcmp setCarNaviDistance(int var1) {
        this.hasCarNaviDistance = true;
        this.carNaviDistance = var1;
        return this;
    }

    public int getCarWeekMileage() {
        return this.carWeekMileage;
    }

    public TrackAcmp setCarWeekMileage(int var1) {
        this.hasCarWeekMileage = true;
        this.carWeekMileage = var1;
        return this;
    }

    public int getCarMaxDuration() {
        return this.carMaxDuration;
    }

    public TrackAcmp setCarMaxDuration(int var1) {
        this.hasCarMaxDuration = true;
        this.carMaxDuration = var1;
        return this;
    }

    public String toString() {
        return "TrackAcmp[carNaviDistance=" + this.carNaviDistance + ", carWeekMileage=" + this.carWeekMileage + ", carMaxDuration=" + this.carMaxDuration + "]";
    }
}
