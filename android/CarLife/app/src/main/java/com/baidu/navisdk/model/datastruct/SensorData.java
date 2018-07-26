package com.baidu.navisdk.model.datastruct;

public class SensorData implements Cloneable {
    public double accx;
    public double accy;
    public double accz;
    public double heading;
    public double pitch;
    public double roll;

    public SensorData clone() {
        SensorData newSensorData = new SensorData();
        synchronized (this) {
            newSensorData.accx = this.accx;
            newSensorData.accy = this.accy;
            newSensorData.accz = this.accz;
            newSensorData.heading = this.heading;
            newSensorData.pitch = this.pitch;
            newSensorData.roll = this.roll;
        }
        return newSensorData;
    }

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", new Object[]{Double.valueOf(this.accx), Double.valueOf(this.accy), Double.valueOf(this.accz), Double.valueOf(this.heading), Double.valueOf(this.pitch), Double.valueOf(this.roll)});
    }
}
