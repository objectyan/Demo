package com.baidu.navisdk.comapi.routeguide;

import android.os.Message;

class IRGInfoAdapter implements OnRGInfoListener {
    private IRGInfoListener mRGInfoListener = null;

    public IRGInfoAdapter(IRGInfoListener lis) {
        this.mRGInfoListener = lis;
    }

    public void onSimpleGuideInfoShow(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onSimpleGuideInfoShow(msg);
        }
    }

    public void onSimpleGuideInfoUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onSimpleGuideInfoUpdate(msg);
        }
    }

    public void onSimpleGuideInfoHide(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onSimpleGuideInfoHide(msg);
        }
    }

    public void onTotalRemainDistTimeUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onRemainDistTimeUpdate(msg);
        }
    }

    public void onAssistInfoShow(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onAssistInfoShow(msg);
        }
    }

    public void onAssistInfoUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onAssistInfoUpdate(msg);
        }
    }

    public void onAssistInfoHide(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onAssistInfoHide(msg);
        }
    }

    public void onRasterExpandMapShow(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onRasterExpandMapShow(msg);
        }
    }

    public void onRasterExpandMapUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onRasterExpandMapUpdate(msg);
        }
    }

    public void onRasterExpandMapHide(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onRasterExpandMapHide(msg);
        }
    }

    public void onDirectBoardShow(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onDirectBoardShow(msg);
        }
    }

    public void onDirectBoardUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onDirectBoardUpdate(msg);
        }
    }

    public void onDirectBoardHide(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onDirectBoardHide(msg);
        }
    }

    public void onVectorExpandMapShow(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onVectorExpandMapShow(msg);
        }
    }

    public void onVectorExpandMapUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onVectorExpandMapUpdate(msg);
        }
    }

    public void onVectorExpandMapHide(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onVectorExpandMapHide(msg);
        }
    }

    public void onCurRoadNameUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onCurRoadNameUpdate(msg);
        }
    }

    public void onHUDUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onHUDUpdate(msg);
        }
    }

    public void onRGSyncOperation(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onRGSyncOperation(msg);
        }
    }

    public void onHighwayInfoShow(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onHighwayInfoShow(msg);
        }
    }

    public void onHighwayInfoUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onHighwayInfoUpdate(msg);
        }
    }

    public void onHighwayInfoHide(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onHighwayInfoHide(msg);
        }
    }

    public void onOtherRGInfo(Message msg) {
    }

    public void onDestStreetViewShow(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onDestStreetViewShow(msg);
        }
    }

    public void onDestStreetViewUpdate(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onDestStreetViewUpdate(msg);
        }
    }

    public void onDestStreetViewHide(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onDestStreetViewHide(msg);
        }
    }

    public void onDestStreetViewStartDownload(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onDestStreetViewStartDownload(msg);
        }
    }

    public void onDestStreetViewDownloadSuccess(Message msg) {
        if (this.mRGInfoListener != null) {
            this.mRGInfoListener.onDestStreetViewDownloadSuccess(msg);
        }
    }

    public void onSimpleBoardShow(Message msg) {
    }

    public void onSimpleBoardHide(Message msg) {
    }

    public void onSimpleBoardUpdate(Message msg) {
    }

    public void onUGCEventTipsShow() {
    }

    public void onUGCEventTipsHide() {
    }

    public void onGPSWeak(Message msg) {
    }
}
