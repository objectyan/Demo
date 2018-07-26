package com.baidu.nplatform.comapi.map.gesture.opt;

import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;

public abstract class Opt {
    protected MapController controller;

    public abstract void perform(MoveDetector moveDetector);

    public Opt(MapController controller) {
        this.controller = controller;
    }

    public void init(MoveDetector detector) {
    }

    public void finish(MoveDetector detector) {
    }
}
