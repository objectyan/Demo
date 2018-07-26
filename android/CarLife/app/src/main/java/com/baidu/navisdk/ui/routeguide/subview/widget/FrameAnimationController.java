package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.os.Handler;
import android.os.Message;

public class FrameAnimationController {
    public static final int ANIMATION_FRAME_DURATION = 16;
    private static final int MSG_ANIMATE = 1000;
    private static final Handler mHandler = new AnimationHandler();

    private static class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        public void handleMessage(Message m) {
            switch (m.what) {
                case 1000:
                    if (m.obj != null) {
                        ((Runnable) m.obj).run();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private FrameAnimationController() {
    }

    public static void requestAnimationFrame(Runnable runnable) {
        Message message = Message.obtain();
        message.what = 1000;
        message.obj = runnable;
        mHandler.sendMessageDelayed(message, 16);
    }

    public static void requestFrameDelay(Runnable runnable, long delay) {
        Message message = Message.obtain();
        message.what = 1000;
        message.obj = runnable;
        mHandler.sendMessageDelayed(message, delay);
    }
}
