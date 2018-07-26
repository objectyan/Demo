package com.baidu.platform.comapi.map.gesture.opt;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.gesture.Base.Vector;
import com.baidu.platform.comapi.map.gesture.detector.MoveDetector;

public abstract class Opt {
    protected MapController controller;

    public abstract void perform(MoveDetector moveDetector);

    public Opt(MapController controller) {
        this.controller = controller;
    }

    public void init(MoveDetector detector) {
    }

    public void finish(MoveDetector detector, Pair<Vector, Vector> pair) {
    }
}
