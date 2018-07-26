package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.OverlayItem.CoordType;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ItemizedOverlay<Item extends OverlayItem> extends Overlay implements Comparator<Integer> {
    private OverlayItem focusItem;
    private Drawable focusMarker;
    private boolean isNeedUpdate;
    private ArrayList<Integer> mItemIndex;
    private ArrayList<OverlayItem> mItems;
    protected MapGLSurfaceView mMapView;
    private Drawable mMarker;
    private int updateType;

    public ItemizedOverlay(Drawable defaultMarker, MapGLSurfaceView mapView) {
        this.updateType = 0;
        this.mType = 27;
        this.mMarker = defaultMarker;
        this.mItems = new ArrayList();
        this.mItemIndex = new ArrayList();
        this.mMapView = mapView;
        this.mLayerID = 0;
    }

    public void setmMarker(Drawable mMarker) {
        this.mMarker = mMarker;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int updateType) {
        this.updateType = updateType;
    }

    public void initLayer() {
        this.mLayerID = this.mMapView.getController().getBaseMap().AddLayer(0, 0, "item");
        if (this.mLayerID == 0) {
            throw new RuntimeException("can not add new layer");
        }
    }

    public void addItem(OverlayItem item) {
        if (this.mItems != null && item != null) {
            List items = new ArrayList(1);
            items.add(item);
            addItem(items);
        }
    }

    public void setFocusMarker(Drawable focusMarker) {
        this.focusMarker = focusMarker;
        if (this.focusItem == null) {
            this.focusItem = new OverlayItem(null, "", "");
        }
        this.focusItem.setMarker(this.focusMarker);
    }

    public void setFocusMarker(Drawable focusMarker, float anchorX, float anchorY) {
        this.focusMarker = focusMarker;
        if (this.focusItem == null) {
            this.focusItem = new OverlayItem(null, "", "");
            this.focusItem.setAnchor(anchorX, anchorY);
        }
        this.focusItem.setMarker(this.focusMarker);
    }

    public void setFocus(int index, boolean bFocus) {
        if (this.focusItem != null) {
            OverlayItem needFocus = getItem(index);
            if (needFocus != null) {
                if (bFocus) {
                    this.focusItem.setGeoPoint(new GeoPoint(needFocus.getPoint().getLatitude(), needFocus.getPoint().getLongitude()));
                    if (this.mItems.contains(this.focusItem)) {
                        updateItem(this.focusItem);
                    } else {
                        addItem(this.focusItem);
                    }
                } else {
                    removeItem(this.focusItem);
                }
                if (this.mMapView != null) {
                    this.mMapView.refresh(this);
                }
            }
        }
    }

    public void addItem(List<OverlayItem> items) {
        addItem(items, false);
    }

    private void addItem(List<OverlayItem> items, boolean isUpdateMode) {
        if (this.mLayerID != 0) {
            Bundle bundle = new Bundle();
            bundle.clear();
            ArrayList<ParcelItem> parcle = new ArrayList();
            bundle.putInt("itemaddr", this.mLayerID);
            bundle.putInt("bshow", 1);
            if (isUpdateMode) {
                bundle.putString("extparam", "update");
            }
            for (int i = 0; i < items.size(); i++) {
                OverlayItem subItem = (OverlayItem) items.get(i);
                if (subItem.getMarker() == null) {
                    subItem.setMarker(this.mMarker);
                }
                long id = System.currentTimeMillis();
                if (!isUpdateMode) {
                    subItem.setId("" + id + JNISearchConst.LAYER_ID_DIVIDER + i);
                }
                ParcelItem subParacel = new ParcelItem();
                BitmapDrawable bd = (BitmapDrawable) subItem.getMarker();
                if (bd != null) {
                    GeoPoint subpt;
                    Bitmap bmp = bd.getBitmap();
                    Bundle subBunle = new Bundle();
                    if (subItem.getCoordType() == CoordType.CoordType_BD09LL) {
                        subpt = MapUtils.ll2mc(subItem.getPoint());
                    } else {
                        subpt = subItem.getPoint();
                    }
                    subBunle.putInt("x", (int) subpt.getLongitude());
                    subBunle.putInt("y", (int) subpt.getLatitude());
                    subBunle.putInt("imgW", bmp.getWidth());
                    subBunle.putInt("imgH", bmp.getHeight());
                    subBunle.putInt("showLR", 1);
                    subBunle.putInt("iconwidth", 0);
                    subBunle.putInt("iconlayer", 1);
                    subBunle.putFloat("ax", subItem.getAnchorX());
                    subBunle.putFloat("ay", subItem.getAnchorY());
                    subBunle.putInt(OVERLAY_KEY.SGEO_BOUND, subItem.getBound());
                    subBunle.putInt("level", subItem.getLevel());
                    subBunle.putInt("mask", subItem.getMask());
                    subBunle.putString("popname", "" + subItem.getId());
                    subBunle.putInt("imgindex", subItem.getResId());
                    if (isUpdateMode || !isSameImagAdded(subItem)) {
                        ByteBuffer dstBuffer = ByteBuffer.allocate((bmp.getWidth() * bmp.getHeight()) * 4);
                        bmp.copyPixelsToBuffer(dstBuffer);
                        subBunle.putByteArray("imgdata", dstBuffer.array());
                    } else {
                        subBunle.putByteArray("imgdata", null);
                    }
                    String[] clickRectArray = convertParcelItemToString(subItem.getClickRect());
                    if (clickRectArray != null && clickRectArray.length > 0) {
                        subBunle.putStringArray("clickrect", clickRectArray);
                    }
                    subBunle.putBundle("animate", subItem.getAnimate());
                    subParacel.setBundle(subBunle);
                    parcle.add(subParacel);
                    if (!isUpdateMode) {
                        this.mItems.add(subItem);
                    }
                }
            }
            if (parcle.size() > 0) {
                ParcelItem[] midpar = new ParcelItem[parcle.size()];
                for (int j = 0; j < parcle.size(); j++) {
                    midpar[j] = (ParcelItem) parcle.get(j);
                }
                bundle.putParcelableArray("itemdatas", midpar);
                this.mMapView.getController().getBaseMap().AddItemData(bundle);
            }
            this.isNeedUpdate = true;
        } else if (!isUpdateMode && this.mItems != null && items != null) {
            this.mItems.addAll(items);
        }
    }

    private String[] convertParcelItemToString(ArrayList<Bundle> clickRectList) {
        if (clickRectList == null || clickRectList.size() <= 0) {
            return null;
        }
        int len = clickRectList.size();
        String[] strArr = new String[len];
        for (int i = 0; i < len; i++) {
            JSONObject itemObj = new JSONObject();
            Bundle itemBundle = (Bundle) clickRectList.get(i);
            for (String key : itemBundle.keySet()) {
                try {
                    itemObj.put(key, itemBundle.get(key));
                } catch (JSONException e) {
                }
            }
            strArr[i] = itemObj.toString();
        }
        return strArr;
    }

    protected static void boundCenterBottom(OverlayItem item) {
        if (item != null) {
            item.setBound(1);
        }
    }

    protected static void boundCenter(OverlayItem item) {
        if (item != null) {
            item.setBound(2);
        }
    }

    public ArrayList<OverlayItem> getAllItem() {
        return this.mItems;
    }

    public final OverlayItem getItem(int position) {
        if (this.mItems == null || this.mItems.size() <= position || position < 0) {
            return null;
        }
        return (OverlayItem) this.mItems.get(position);
    }

    public int getLatSpanE6() {
        return getSpanE6(true);
    }

    public int getLonSpanE6() {
        return getSpanE6(false);
    }

    public GeoPoint getCenter() {
        int i = getIndexToDraw(0);
        if (i == -1) {
            return null;
        }
        return getItem(i).getPoint();
    }

    private int getSpanE6(boolean latSpan) {
        if (this.mItems == null || this.mItems.size() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Iterator<OverlayItem> iterator = this.mItems.iterator();
        while (iterator.hasNext()) {
            GeoPoint geopoint = ((OverlayItem) iterator.next()).getPoint();
            int k = latSpan ? (int) geopoint.getLatitude() : (int) geopoint.getLongitude();
            if (k > max) {
                max = k;
            }
            if (k < min) {
                min = k;
            }
        }
        return max - min;
    }

    protected int getIndexToDraw(int drawingOrder) {
        if (this.mItems == null || this.mItems.size() == 0) {
            return -1;
        }
        return drawingOrder;
    }

    protected boolean hitTest(OverlayItem item, Drawable marker, int hitX, int hitY) {
        if (marker == null) {
            return false;
        }
        Rect rc = marker.getBounds();
        rc.left -= 10;
        rc.right += 10;
        rc.bottom += 10;
        rc.top -= 10;
        boolean flag = rc.contains(hitX, hitY);
        rc.left += 10;
        rc.right -= 10;
        rc.bottom -= 10;
        rc.top += 10;
        return flag;
    }

    public boolean onTap(int index) {
        return false;
    }

    public boolean onTap(GeoPoint p, MapGLSurfaceView mapView) {
        return false;
    }

    public boolean onTap(int index, int clickIndex, GeoPoint p) {
        return false;
    }

    void initItems(ArrayList<OverlayItem> items) {
        int size = items.size();
        if (this.mItemIndex != null) {
            this.mItemIndex.clear();
            this.mItemIndex = null;
        }
        if (this.mItems != null) {
            this.mItems.clear();
            this.mItems = null;
        }
        this.mItems = new ArrayList(size);
        this.mItemIndex = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.mItemIndex.add(i, Integer.valueOf(i));
            OverlayItem item = (OverlayItem) items.get(i);
            if (item.getMarker() == null) {
                item.setMarker(this.mMarker);
            }
            this.mItems.add(i, item);
        }
        Collections.sort(this.mItemIndex, this);
    }

    public int compare(Integer object1, Integer object2) {
        GeoPoint pt1 = ((OverlayItem) this.mItems.get(object1.intValue())).getPoint();
        GeoPoint pt2 = ((OverlayItem) this.mItems.get(object2.intValue())).getPoint();
        if (pt1.getLatitude() > pt2.getLatitude()) {
            return -1;
        }
        if (pt1.getLatitude() < pt2.getLatitude()) {
            return 1;
        }
        if (pt1.getLongitude() < pt2.getLongitude()) {
            return -1;
        }
        return pt1.getLongitude() == pt2.getLongitude() ? 0 : 1;
    }

    public boolean updateItem(OverlayItem item) {
        if (item == null || item.getId().equals("")) {
            return false;
        }
        boolean isItemAdded = false;
        Iterator it = this.mItems.iterator();
        while (it.hasNext()) {
            if (item.getId().equals(((OverlayItem) it.next()).getId())) {
                isItemAdded = true;
                break;
            }
        }
        if (!isItemAdded) {
            return false;
        }
        ArrayList<OverlayItem> items = new ArrayList();
        items.add(item);
        addItem(items, true);
        return true;
    }

    public boolean updateItem(List<OverlayItem> items) {
        if (items == null) {
            return false;
        }
        addItem(items, true);
        return true;
    }

    public boolean removeItem(OverlayItem item) {
        if (this.mLayerID == 0) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("itemaddr", this.mLayerID);
        if (item.getId().equals("")) {
            return false;
        }
        bundle.putString("id", item.getId());
        if (!this.mMapView.getController().getBaseMap().RemoveItemData(bundle)) {
            return false;
        }
        this.mItems.remove(item);
        this.isNeedUpdate = true;
        return true;
    }

    public boolean removeAll() {
        if (this.mItems.isEmpty()) {
            return false;
        }
        if (!(this.mMapView.getController() == null || this.mMapView.getController().getBaseMap() == null)) {
            this.mMapView.getController().getBaseMap().ClearLayer(this.mLayerID);
        }
        this.mItems.clear();
        this.isNeedUpdate = true;
        return true;
    }

    void reAddAll() {
        List tmp = new ArrayList();
        tmp.addAll(this.mItems);
        removeAll();
        addItem(tmp);
    }

    void setUpdateInfo(boolean isNeedUpdate) {
        this.isNeedUpdate = isNeedUpdate;
    }

    boolean getUpdateInfo() {
        return this.isNeedUpdate;
    }

    protected Item createItem(int i) {
        return null;
    }

    public int size() {
        return this.mItems == null ? 0 : this.mItems.size();
    }

    int getLayerid() {
        return this.mLayerID;
    }

    private boolean isSameImagAdded(OverlayItem Item) {
        Iterator it = this.mItems.iterator();
        while (it.hasNext()) {
            OverlayItem overlayItem = (OverlayItem) it.next();
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
