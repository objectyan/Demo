package com.baidu.navisdk.model.datastruct;

public class SensorData
  implements Cloneable
{
  public double accx;
  public double accy;
  public double accz;
  public double heading;
  public double pitch;
  public double roll;
  
  public SensorData clone()
  {
    SensorData localSensorData = new SensorData();
    try
    {
      localSensorData.accx = this.accx;
      localSensorData.accy = this.accy;
      localSensorData.accz = this.accz;
      localSensorData.heading = this.heading;
      localSensorData.pitch = this.pitch;
      localSensorData.roll = this.roll;
      return localSensorData;
    }
    finally {}
  }
  
  public String toString()
  {
    return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", new Object[] { Double.valueOf(this.accx), Double.valueOf(this.accy), Double.valueOf(this.accz), Double.valueOf(this.heading), Double.valueOf(this.pitch), Double.valueOf(this.roll) });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/SensorData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */