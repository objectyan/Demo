package com.baidu.navisdk.comapi.geolocate;

import com.baidu.navisdk.model.datastruct.SensorData;

public interface ISensorDataChangeListener {
    void onSensorDataChange(SensorData sensorData);
}
