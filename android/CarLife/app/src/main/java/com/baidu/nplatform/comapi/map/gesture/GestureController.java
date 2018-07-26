package com.baidu.nplatform.comapi.map.gesture;

import android.view.MotionEvent;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.gesture.detector.ClickDetector;
import com.baidu.nplatform.comapi.map.gesture.detector.ClickDetector.Listener;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;
import com.baidu.nplatform.comapi.map.gesture.opt.OptSelector;

public class GestureController {
    private ClickDetector clickDetector;
    Listener clickListener = new C47421();
    private MapController controller;
    private MoveDetector moveDetector;

    /* renamed from: com.baidu.nplatform.comapi.map.gesture.GestureController$1 */
    class C47421 implements Listener {
        C47421() {
        }

        public boolean onTwoTouchClick(ClickDetector detector) {
            LogUtil.m15791e("MapGesture", "onTwoTouchClick");
            BNStatisticsManager.getInstance().onMapScaleSet(Math.max((int) (GestureController.this.controller.getMapStatus()._Level - 1.0f), 3));
            BNStatisticsManager.getInstance().onGestureEvent("sd");
            GestureController.this.controller.MapMsgProc(8193, 4, 0);
            if (BNMapController.getInstance().getMapController() != null) {
                BNMapController.getInstance().getMapController().onDoubleFingerZoom();
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
