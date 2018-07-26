package com.baidu.navisdk.comapi.mapcontrol;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;

class BNMapController$OnMapGestureListener implements OnDoubleTapListener, OnGestureListener {
    final /* synthetic */ BNMapController this$0;

    private BNMapController$OnMapGestureListener(BNMapController bNMapController) {
        this.this$0 = bNMapController;
    }

    public boolean onDoubleTap(MotionEvent event) {
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent event) {
        handleDoubleTapEvent(event);
        return true;
    }

    public void handleDoubleTapEvent(MotionEvent event) {
        LogUtil.m15791e(ModuleName.MAP, "onDoubleTapEvent");
        BNMapController.access$102(this.this$0, true);
        if (BNMapController.access$000(this.this$0) != null) {
            BNMapController.access$000(this.this$0).handleDoubleTapEvent(event);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent event) {
        LogUtil.m15791e(ModuleName.MAP, "onSingleTapConfirmed");
        if (BNMapController.access$000(this.this$0) != null) {
            BNStatisticsManager.getInstance().onGestureEvent("dd");
            if (!BNMapController.access$000(this.this$0).handleTouchSingleClick(event)) {
                LogUtil.m15791e(ModuleName.MAP, "onSingleTapConfirmed");
                BNMapController.getInstance().notifyMapObservers(2, 514, event);
            }
        }
        return false;
    }

    public boolean onDown(MotionEvent arg0) {
        LogUtil.m15791e(ModuleName.MAP, "onDown");
        BNMapController.access$102(this.this$0, false);
        BNMapController.getInstance().notifyMapObservers(2, 515, null);
        return false;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        LogUtil.m15791e(ModuleName.MAP, "onFling");
        if (BNMapController.access$000(this.this$0) == null) {
            return false;
        }
        BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_FLIP);
        BNMapController.getInstance().notifyMapObservers(2, 516, null);
        return BNMapController.access$000(this.this$0).handleFling(e1, e2, velocityX, velocityY);
    }

    public void onLongPress(MotionEvent event) {
        LogUtil.m15791e(ModuleName.MAP, "onLongPress");
        if (!BNMapController.access$100(this.this$0)) {
            BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_LONGCLICK);
            BNMapController.getInstance().notifyMapObservers(2, 517, event);
        }
    }

    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        LogUtil.m15791e(ModuleName.MAP, "onScroll:\n arg0: " + arg0.toString() + "\narg1: " + arg1.toString() + "\n arg2: " + arg2 + ", arg3: " + arg3);
        BNMapController.getInstance().notifyMapObservers(2, 518, null);
        return false;
    }

    public void onShowPress(MotionEvent event) {
        LogUtil.m15791e(ModuleName.MAP, "onShowPress");
    }

    public boolean onSingleTapUp(MotionEvent event) {
        LogUtil.m15791e(ModuleName.MAP, "onSingleTapUp");
        return false;
    }
}
