package com.baidu.navisdk.util.common;

public class SensorAlgoFilter {
    private float mBarrier = 2.0f;
    private float mOldV;

    public SensorAlgoFilter(float barrier) {
        this.mBarrier = barrier;
    }

    public float execute(float v) {
        this.mOldV = checkAndCalc(this.mOldV, v, this.mBarrier);
        return this.mOldV;
    }

    private float checkAndCalc(float oldV, float newV, float barrier) {
        float delta = oldV - newV;
        if (delta > 180.0f || delta < -180.0f) {
            return newV;
        }
        if (delta < (-barrier) || barrier < delta) {
            return (oldV + newV) / 2.0f;
        }
        return oldV;
    }
}
