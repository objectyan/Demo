package com.baidu.platform.comapi.map;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController.MapControlMode;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SimpleGestureAdapter extends SimpleOnGestureListener {
    private Object lock = new Object();
    private MapController mMapController;
    private OnLongPressListener mOnLongPressListener;
    private volatile Set<SimpleOnGestureListener> mUserListeners = new CopyOnWriteArraySet();

    public void setMapController(MapController mapController) {
        this.mMapController = mapController;
    }

    OnLongPressListener getOnLongPressListener() {
        return this.mOnLongPressListener;
    }

    void setOnLongPressListener(OnLongPressListener mOnLongPressListener) {
        this.mOnLongPressListener = mOnLongPressListener;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (this.mMapController == null) {
            return false;
        }
        if (this.mMapController.getMapControlMode() == MapControlMode.STREET) {
            this.mMapController.handleTouchUp(e2);
        }
        return this.mMapController.handleFling(e1, e2, velocityX, velocityY);
    }

    public void addSimpleOnGestureListener(SimpleOnGestureListener listener) {
        synchronized (this.lock) {
            this.mUserListeners.add(listener);
        }
    }

    public void removeSimpleOnGestureListener(SimpleOnGestureListener listener) {
        synchronized (this.lock) {
            this.mUserListeners.remove(listener);
        }
    }

    public boolean onSingleTapUp(MotionEvent e) {
        synchronized (this.lock) {
            Set<SimpleOnGestureListener> listeners = this.mUserListeners;
            if (listeners != null) {
                for (SimpleOnGestureListener listener : listeners) {
                    listener.onSingleTapUp(e);
                }
            }
        }
        return super.onSingleTapUp(e);
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        synchronized (this.lock) {
            Set<SimpleOnGestureListener> listeners = this.mUserListeners;
            if (listeners != null) {
                for (SimpleOnGestureListener listener : listeners) {
                    listener.onScroll(e1, e2, distanceX, distanceY);
                }
            }
        }
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    public void onShowPress(MotionEvent e) {
        synchronized (this.lock) {
            Set<SimpleOnGestureListener> listeners = this.mUserListeners;
            if (listeners != null) {
                for (SimpleOnGestureListener listener : listeners) {
                    listener.onShowPress(e);
                }
            }
        }
        super.onShowPress(e);
    }

    public boolean onDown(MotionEvent e) {
        synchronized (this.lock) {
            Set<SimpleOnGestureListener> listeners = this.mUserListeners;
            if (listeners != null) {
                for (SimpleOnGestureListener listener : listeners) {
                    listener.onDown(e);
                }
            }
        }
        return super.onDown(e);
    }

    public boolean onDoubleTapEvent(MotionEvent e) {
        synchronized (this.lock) {
            Set<SimpleOnGestureListener> listeners = this.mUserListeners;
            if (listeners != null) {
                for (SimpleOnGestureListener listener : listeners) {
                    listener.onDoubleTapEvent(e);
                }
            }
        }
        if (e.getAction() == 1 && this.mMapController != null) {
            this.mMapController.handleDoubleTouch(e);
        }
        return super.onDoubleTapEvent(e);
    }

    public boolean onSingleTapConfirmed(MotionEvent event) {
        synchronized (this.lock) {
            Set<SimpleOnGestureListener> listeners = this.mUserListeners;
            if (listeners != null) {
                for (SimpleOnGestureListener listener : listeners) {
                    listener.onSingleTapConfirmed(event);
                }
            }
        }
        return this.mMapController != null && this.mMapController.handleTouchSingleClick(event);
    }

    public boolean onDoubleTap(MotionEvent e) {
        synchronized (this.lock) {
            Set<SimpleOnGestureListener> listeners = this.mUserListeners;
            if (listeners != null) {
                for (SimpleOnGestureListener listener : listeners) {
                    listener.onDoubleTap(e);
                }
            }
        }
        if (this.mMapController != null) {
            this.mMapController.handleDoubleDownClick(e);
        }
        return true;
    }

    public void onLongPress(MotionEvent e) {
        synchronized (this.lock) {
            Set<SimpleOnGestureListener> listeners = this.mUserListeners;
            if (listeners != null) {
                for (SimpleOnGestureListener listener : listeners) {
                    listener.onLongPress(e);
                }
            }
        }
        if (this.mMapController != null && !this.mMapController.isEnableDMoveZoom() && !this.mMapController.isNaviMode() && this.mOnLongPressListener != null) {
            this.mOnLongPressListener.onLongPress(e);
        }
    }
}
