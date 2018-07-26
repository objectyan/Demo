package com.baidu.platform.comapi.map.gesture;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.gesture.detector.ClickDetector;
import com.baidu.platform.comapi.map.gesture.detector.ClickDetector.Listener;
import com.baidu.platform.comapi.map.gesture.detector.MoveDetector;
import com.baidu.platform.comapi.map.gesture.opt.OptSelector;

public class GestureController {
    private ClickDetector clickDetector;
    Listener clickListener = new C47871();
    private MapController controller;
    private MoveDetector moveDetector;

    /* renamed from: com.baidu.platform.comapi.map.gesture.GestureController$1 */
    class C47871 implements Listener {
        C47871() {
        }

        public boolean onTwoTouchClick(ClickDetector detector) {
            GestureController.this.controller.getGestureMonitor().handleTwoClick(GestureController.this.controller.getZoomLevel() - 1.0f);
            GestureController.this.controller.MapMsgProc(8193, 4, 0);
            if (GestureController.this.controller.isNaviMode() && GestureController.this.controller.getNaviMapViewListener() != null) {
                GestureController.this.controller.getNaviMapViewListener().onAction(521, null);
            }
            return true;
        }
    }

    public GestureController(MapController controller) {
        this.controller = controller;
        this.moveDetector = new MoveDetector(new OptSelector(controller));
        this.clickDetector = new ClickDetector(this.clickListener);
    }

    public void onTouchEvent(MotionEvent event) {
        this.moveDetector.onTouchEvent(event);
        this.clickDetector.onTouchEvent(event);
    }
}
