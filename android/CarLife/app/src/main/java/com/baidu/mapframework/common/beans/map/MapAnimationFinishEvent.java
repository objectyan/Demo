package com.baidu.mapframework.common.beans.map;

import com.baidu.mapframework.common.beans.BaseEvent;

public class MapAnimationFinishEvent extends BaseEvent {
    public boolean ontouch;

    public MapAnimationFinishEvent(boolean ontouch) {
        this.ontouch = ontouch;
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }
}
