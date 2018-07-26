package com.baidu.navi.track.model;

public class CarNavi {
    private double avgSpeed = 0.0d;
    private int ctime = 0;
    private int distance = 0;
    private int duration = 0;
    private NaviPoint endPoint;
    private String guid = "";
    private boolean hasAvgSpeed;
    private boolean hasCtime;
    private boolean hasDistance;
    private boolean hasDuration;
    private boolean hasEndPoint;
    private boolean hasGuid;
    private boolean hasMaxSpeed;
    private boolean hasModifyTime;
    private boolean hasSid;
    private boolean hasSign;
    private boolean hasStartPoint;
    private boolean hasType;
    private double maxSpeed = 0.0d;
    private int modifyTime = 0;
    private String sid = "";
    private String sign = "";
    private NaviPoint startPoint;
    private String type = "";

    public boolean hasSid() {
        return this.hasSid;
    }

    public CarNavi setSid(String value) {
        this.hasSid = true;
        this.sid = value;
        return this;
    }

    public String getSid() {
        return this.sid;
    }

    public boolean hasGuid() {
        return this.hasGuid;
    }

    public CarNavi setGuid(String value) {
        this.hasGuid = true;
        this.guid = value;
        return this;
    }

    public String getGuid() {
        return this.guid;
    }

    public boolean hasCtime() {
        return this.hasCtime;
    }

    public CarNavi setCtime(int value) {
        this.hasCtime = true;
        this.ctime = value;
        return this;
    }

    public int getCtime() {
        return this.ctime;
    }

    public boolean hasDistance() {
        return this.hasDistance;
    }

    public CarNavi setDistance(int value) {
        this.hasDistance = true;
        this.distance = value;
        return this;
    }

    public int getDistance() {
        return this.distance;
    }

    public boolean hasDuration() {
        return this.hasDuration;
    }

    public CarNavi setDuration(int value) {
        this.hasDuration = true;
        this.duration = value;
        return this;
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean hasAvgSpeed() {
        return this.hasAvgSpeed;
    }

    public CarNavi setAvgSpeed(double value) {
        this.hasAvgSpeed = true;
        this.avgSpeed = value;
        return this;
    }

    public double getAvgSpeed() {
        return this.avgSpeed;
    }

    public boolean hasMaxSpeed() {
        return this.hasMaxSpeed;
    }

    public CarNavi setMaxSpeed(double value) {
        this.hasMaxSpeed = true;
        this.maxSpeed = value;
        return this;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    public boolean hasSign() {
        return this.hasSign;
    }

    public CarNavi setSign(String value) {
        this.hasSign = true;
        this.sign = value;
        return this;
    }

    public String getSign() {
        return this.sign;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public CarNavi setType(String value) {
        this.hasType = true;
        this.type = value;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public boolean hasModifyTtime() {
        return this.hasModifyTime;
    }

    public CarNavi setModifyTime(int value) {
        this.hasModifyTime = true;
        this.modifyTime = value;
        return this;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public boolean hasStartPoint() {
        return this.hasStartPoint;
    }

    public CarNavi setStartPoint(NaviPoint value) {
        this.hasStartPoint = true;
        this.startPoint = value;
        return this;
    }

    public NaviPoint getStartPoint() {
        return this.startPoint;
    }

    public CarNavi clearStartPoint() {
        this.hasStartPoint = false;
        this.startPoint = null;
        return this;
    }

    public boolean hasEndPoint() {
        return this.hasEndPoint;
    }

    public CarNavi setEndPoint(NaviPoint value) {
        this.hasEndPoint = true;
        this.endPoint = value;
        return this;
    }

    public NaviPoint getEndPoint() {
        return this.endPoint;
    }

    public CarNavi clearEndPoint() {
        this.hasEndPoint = false;
        this.endPoint = null;
        return this;
    }

    public String toString() {
        return "CarNavi [sid=" + this.sid + ", guid=" + this.guid + ", ctime=" + this.ctime + ", distance=" + this.distance + ", duration=" + this.duration + ", avgSpeed=" + this.avgSpeed + ", maxSpeed=" + this.maxSpeed + ", sign=" + this.sign + ",type =" + this.type + ", modifyTime=" + this.modifyTime + ", startPoint=" + this.startPoint + ", endPoint=" + this.endPoint + "]";
    }
}
