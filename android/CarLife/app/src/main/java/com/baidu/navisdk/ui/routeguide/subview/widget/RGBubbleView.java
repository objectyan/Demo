package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController;
import java.nio.ByteBuffer;

public class RGBubbleView implements OnClickListener {
    private static final int BTN_MARGIN = 70;
    private static final int BTN_WIDTH = 80;
    private static final int mIconWidth = 88;
    private LinearLayout mBody;
    private LayoutParams mBubbleLp = null;
    private GeoPoint mGeoPt = new GeoPoint();
    boolean mIsShow = false;
    private IBubbleClickListener mListener;
    private MapController mMapController;
    private View mRootView;
    private Point mScrPt = new Point(0, 0);
    private boolean mShowBtn = true;
    private TextView mTitle;

    public interface IBubbleClickListener {
        void onClickBody(View view);

        void onClickLeft(View view);

        void onClickRight(View view);
    }

    public GeoPoint getGeoPt() {
        return this.mGeoPt;
    }

    public Point getScrPt() {
        return this.mScrPt;
    }

    public RGBubbleView(Context context) {
        this.mRootView = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_rg_bubble_view, null);
        this.mBubbleLp = new LayoutParams(-2, -2);
        this.mBubbleLp.gravity = 51;
        if (this.mRootView != null) {
            this.mBody = (LinearLayout) this.mRootView.findViewById(C4048R.id.mainView);
            this.mTitle = (TextView) this.mRootView.findViewById(C4048R.id.titleTV);
            this.mBody.setOnClickListener(this);
            this.mRootView.setOnClickListener(this);
            this.mRootView.setVisibility(4);
        }
    }

    public void setBtnShow(boolean bBtnShow) {
        this.mShowBtn = bBtnShow;
    }

    public void setMapController(MapController mapCtrl) {
        this.mMapController = mapCtrl;
    }

    public void showBubble(GeoPoint geoPt, String title, String desc, int offSet, boolean bSingleLine, Bundle placeBundel) {
        if (geoPt != null) {
            setTitle(title, bSingleLine);
            setGeoPos(geoPt, offSet);
            setPlaceBundle(placeBundel);
            this.mIsShow = true;
            Bundle bundle = new Bundle();
            Bitmap bmp = getBubbleBmpCache(0);
            bundle.putInt("bshow", 1);
            bundle.putInt("x", geoPt.getLongitudeE6());
            bundle.putInt("y", geoPt.getLatitudeE6());
            bundle.putInt("imgW", bmp.getWidth());
            bundle.putInt("imgH", bmp.getHeight());
            bundle.putInt("showLR", this.mShowBtn ? 1 : 0);
            bundle.putInt("iconwidth", 88);
            bundle.putInt("popname", (this.mTitle.getText().toString() + "0" + "place").hashCode());
            int imgCnt = 4;
            if (!this.mShowBtn) {
                imgCnt = 2;
            }
            for (int i = 0; i < imgCnt; i++) {
                bundle.putByteArray("imgdata" + i, getPopupBmpCacheData(i));
            }
            this.mMapController.addPopupData(bundle);
            this.mMapController.showLayer(11, true);
            this.mMapController.updateLayer(11);
        }
    }

    private void setPlaceBundle(Bundle bundle) {
    }

    public void setGeoPos(GeoPoint pt, int offSet) {
        this.mGeoPt = pt;
        Point p = this.mMapController.getScreenPosByGeoPos(this.mGeoPt);
        if (p != null) {
            this.mScrPt = p;
            setScrPos(this.mScrPt.f19727x, this.mScrPt.f19728y);
        }
    }

    private void setScrPos(int x, int y) {
        int pw = ((View) this.mRootView.getParent()).getWidth();
        int maxWidth = pw - ScreenUtil.getInstance().dip2px(CommonHandlerThread.MSG_START_RECORD_TRAJECTORY);
        if (!this.mShowBtn) {
            maxWidth = pw - ScreenUtil.getInstance().dip2px(70);
        }
        this.mTitle.setMaxWidth(maxWidth);
        this.mRootView.measure(0, 0);
    }

    public void setClickListener(IBubbleClickListener listener) {
        this.mListener = listener;
    }

    public void setTitle(String title, boolean bSingleLine) {
        this.mTitle.setSingleLine(bSingleLine);
        this.mTitle.setText(Html.fromHtml(title));
    }

    public boolean isShow() {
        return this.mIsShow;
    }

    public void update() {
        Point p = this.mMapController.getScreenPosByGeoPos(this.mGeoPt);
        if (p != null) {
            this.mScrPt = p;
            setScrPos(this.mScrPt.f19727x, this.mScrPt.f19728y);
            this.mRootView.getParent().requestLayout();
        }
    }

    public void hide() {
        this.mIsShow = false;
        if (this.mMapController != null) {
            this.mMapController.clearLayer(11);
            this.mMapController.showLayer(11, false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public LayoutParams getLayoutParams() {
        return this.mBubbleLp;
    }

    public void onClick(View v) {
        if (this.mListener != null) {
            if (v == this.mBody) {
                this.mListener.onClickBody(v);
            } else if (v == this.mRootView) {
                this.mListener.onClickBody(v);
            }
        }
    }

    public Bitmap getBubbleBmpCache(int popupStatus) {
        if (popupStatus == 1) {
            this.mRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_popup_bg));
        } else {
            this.mRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_popup_bg));
        }
        this.mRootView.setDrawingCacheEnabled(true);
        this.mRootView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.mRootView.layout(0, 0, this.mRootView.getMeasuredWidth(), this.mRootView.getMeasuredHeight());
        this.mRootView.buildDrawingCache();
        Bitmap bmpTemp = this.mRootView.getDrawingCache();
        this.mRootView.setDrawingCacheEnabled(false);
        return bmpTemp;
    }

    public byte[] getPopupBmpCacheData(int popupStatus) {
        if (popupStatus == 1) {
            this.mRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_popup_bg));
        } else {
            this.mRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_popup_bg));
        }
        this.mRootView.setDrawingCacheEnabled(true);
        this.mRootView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.mRootView.layout(0, 0, this.mRootView.getMeasuredWidth(), this.mRootView.getMeasuredHeight());
        this.mRootView.buildDrawingCache();
        Bitmap bmpTemp = this.mRootView.getDrawingCache();
        if (bmpTemp == null) {
            this.mRootView.setDrawingCacheEnabled(false);
            return null;
        } else if (bmpTemp.getConfig() == Config.ARGB_8888) {
            ByteBuffer dstBuffer = ByteBuffer.allocate((bmpTemp.getWidth() * bmpTemp.getHeight()) * 4);
            bmpTemp.copyPixelsToBuffer(dstBuffer);
            this.mRootView.setDrawingCacheEnabled(false);
            return dstBuffer.array();
        } else {
            this.mRootView.setDrawingCacheEnabled(false);
            return null;
        }
    }
}
