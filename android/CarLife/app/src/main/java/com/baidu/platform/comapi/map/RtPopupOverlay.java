package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RtPopupOverlay<Item extends RtPopupOverlayItem> extends Overlay {
    private static final int BGRESID = 131;
    private static final int TIME = 500;
    private Drawable mDefaultMarker;
    private ArrayList<Integer> mItemIndex;
    private ArrayList<RtPopupOverlayItem> mItems;
    protected MapGLSurfaceView mMapView;

    public RtPopupOverlay(Drawable defaultMarker, MapGLSurfaceView mapView) {
        this.mType = 27;
        this.mItems = new ArrayList();
        this.mItemIndex = new ArrayList();
        this.mDefaultMarker = defaultMarker;
        this.mMapView = mapView;
        this.mLayerID = 0;
    }

    void initLayer() {
        this.mLayerID = this.mMapView.getController().getBaseMap().AddLayer(4, 500, "rtpopup");
        if (this.mLayerID != 0) {
        }
    }

    public boolean removeAll() {
        if (this.mMapView.getController().getBaseMap() != null) {
            this.mMapView.getController().getBaseMap().ClearLayer(this.mLayerID);
        }
        this.mItems.clear();
        new Bundle().putInt("rtpopaddr", this.mLayerID);
        return true;
    }

    void reAddAll() {
        List tmp = new ArrayList();
        tmp.addAll(this.mItems);
        removeAll();
        addItem(tmp);
    }

    public void addItem(RtPopupOverlayItem item) {
        if (this.mItems != null && item != null) {
            List items = new ArrayList(1);
            items.add(item);
            addItem(items);
        }
    }

    public void addItem(List<RtPopupOverlayItem> items) {
        addItem(items, false);
    }

    private void addItem(List<RtPopupOverlayItem> items, boolean isUpdateMode) {
        if (this.mLayerID != 0) {
            Bundle bundle = new Bundle();
            bundle.clear();
            ArrayList<ParcelItem> parcle = new ArrayList();
            bundle.putInt("rtpopaddr", this.mLayerID);
            for (int i = 0; i < items.size(); i++) {
                RtPopupOverlayItem subItem = (RtPopupOverlayItem) items.get(i);
                if (subItem.imgdata == null) {
                    subItem.imgdata = this.mDefaultMarker;
                }
                long id = System.currentTimeMillis();
                if (!isUpdateMode) {
                    subItem.id = "" + id + JNISearchConst.LAYER_ID_DIVIDER + i;
                }
                ParcelItem subParacel = new ParcelItem();
                Bitmap bmp = subItem.imgdata.getBitmap();
                Bundle subBunle = new Bundle();
                subBunle.putInt("x", subItem.f19854x);
                subBunle.putInt("y", subItem.f19855y);
                subBunle.putInt(Config.DEVICE_WIDTH, bmp.getWidth());
                subBunle.putInt("h", bmp.getHeight());
                subBunle.putInt("imgindex", subItem.getResId());
                subBunle.putInt("bgresid", subItem.bgresid);
                subBunle.putInt("maxl", subItem.showLevelMax);
                subBunle.putInt("minl", subItem.showLevelMin);
                if (isUpdateMode || !isSameImagAdded(subItem)) {
                    ByteBuffer dstBuffer = ByteBuffer.allocate((bmp.getWidth() * bmp.getHeight()) * 4);
                    bmp.copyPixelsToBuffer(dstBuffer);
                    subBunle.putByteArray("imgdata", dstBuffer.array());
                } else {
                    subBunle.putByteArray("imgdata", null);
                }
                subParacel.setBundle(subBunle);
                parcle.add(subParacel);
                if (!isUpdateMode) {
                    this.mItems.add(subItem);
                }
            }
            if (parcle.size() > 0) {
                ParcelItem[] midpar = new ParcelItem[parcle.size()];
                for (int j = 0; j < parcle.size(); j++) {
                    midpar[j] = (ParcelItem) parcle.get(j);
                }
                bundle.putParcelableArray("rtpopdatas", midpar);
                this.mMapView.getController().getBaseMap().AddRtPopData(bundle);
                this.mMapView.getController().getBaseMap().UpdateLayers(this.mLayerID);
            }
        } else if (!isUpdateMode) {
            this.mItems.addAll(items);
        }
    }

    private boolean isSameImagAdded(RtPopupOverlayItem Item) {
        Iterator it = this.mItems.iterator();
        while (it.hasNext()) {
            RtPopupOverlayItem overlayItem = (RtPopupOverlayItem) it.next();
            if (Item.getResId() == -1) {
                return false;
            }
            if (overlayItem.getResId() != -1 && Item.getResId() == overlayItem.getResId()) {
                return true;
            }
        }
        return false;
    }
}
