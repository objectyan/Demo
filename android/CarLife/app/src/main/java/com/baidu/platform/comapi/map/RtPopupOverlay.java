package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RtPopupOverlay<Item extends RtPopupOverlayItem>
  extends Overlay
{
  private static final int BGRESID = 131;
  private static final int TIME = 500;
  private Drawable mDefaultMarker;
  private ArrayList<Integer> mItemIndex = new ArrayList();
  private ArrayList<RtPopupOverlayItem> mItems = new ArrayList();
  protected MapGLSurfaceView mMapView;
  
  public RtPopupOverlay(Drawable paramDrawable, MapGLSurfaceView paramMapGLSurfaceView)
  {
    this.mType = 27;
    this.mDefaultMarker = paramDrawable;
    this.mMapView = paramMapGLSurfaceView;
    this.mLayerID = 0;
  }
  
  private void addItem(List<RtPopupOverlayItem> paramList, boolean paramBoolean)
  {
    if (this.mLayerID == 0) {
      if (!paramBoolean) {
        this.mItems.addAll(paramList);
      }
    }
    Bundle localBundle1;
    ArrayList localArrayList;
    do
    {
      return;
      localBundle1 = new Bundle();
      localBundle1.clear();
      localArrayList = new ArrayList();
      localBundle1.putInt("rtpopaddr", this.mLayerID);
      i = 0;
      if (i < paramList.size())
      {
        RtPopupOverlayItem localRtPopupOverlayItem = (RtPopupOverlayItem)paramList.get(i);
        if (localRtPopupOverlayItem.imgdata == null) {
          localRtPopupOverlayItem.imgdata = this.mDefaultMarker;
        }
        long l = System.currentTimeMillis();
        if (!paramBoolean) {
          localRtPopupOverlayItem.id = ("" + l + "_" + i);
        }
        ParcelItem localParcelItem = new ParcelItem();
        Bitmap localBitmap = ((BitmapDrawable)localRtPopupOverlayItem.imgdata).getBitmap();
        Bundle localBundle2 = new Bundle();
        localBundle2.putInt("x", localRtPopupOverlayItem.x);
        localBundle2.putInt("y", localRtPopupOverlayItem.y);
        localBundle2.putInt("w", localBitmap.getWidth());
        localBundle2.putInt("h", localBitmap.getHeight());
        localBundle2.putInt("imgindex", localRtPopupOverlayItem.getResId());
        localBundle2.putInt("bgresid", localRtPopupOverlayItem.bgresid);
        localBundle2.putInt("maxl", localRtPopupOverlayItem.showLevelMax);
        localBundle2.putInt("minl", localRtPopupOverlayItem.showLevelMin);
        if ((!paramBoolean) && (isSameImagAdded(localRtPopupOverlayItem))) {
          localBundle2.putByteArray("imgdata", null);
        }
        for (;;)
        {
          localParcelItem.setBundle(localBundle2);
          localArrayList.add(localParcelItem);
          if (!paramBoolean) {
            this.mItems.add(localRtPopupOverlayItem);
          }
          i += 1;
          break;
          ByteBuffer localByteBuffer = ByteBuffer.allocate(localBitmap.getWidth() * localBitmap.getHeight() * 4);
          localBitmap.copyPixelsToBuffer(localByteBuffer);
          localBundle2.putByteArray("imgdata", localByteBuffer.array());
        }
      }
    } while (localArrayList.size() <= 0);
    paramList = new ParcelItem[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      paramList[i] = ((ParcelItem)localArrayList.get(i));
      i += 1;
    }
    localBundle1.putParcelableArray("rtpopdatas", paramList);
    this.mMapView.getController().getBaseMap().AddRtPopData(localBundle1);
    this.mMapView.getController().getBaseMap().UpdateLayers(this.mLayerID);
  }
  
  private boolean isSameImagAdded(RtPopupOverlayItem paramRtPopupOverlayItem)
  {
    Iterator localIterator = this.mItems.iterator();
    RtPopupOverlayItem localRtPopupOverlayItem;
    do
    {
      if (localIterator.hasNext())
      {
        localRtPopupOverlayItem = (RtPopupOverlayItem)localIterator.next();
        if (paramRtPopupOverlayItem.getResId() != -1) {}
      }
      else
      {
        return false;
      }
    } while ((localRtPopupOverlayItem.getResId() == -1) || (paramRtPopupOverlayItem.getResId() != localRtPopupOverlayItem.getResId()));
    return true;
  }
  
  public void addItem(RtPopupOverlayItem paramRtPopupOverlayItem)
  {
    if ((this.mItems != null) && (paramRtPopupOverlayItem != null))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramRtPopupOverlayItem);
      addItem(localArrayList);
    }
  }
  
  public void addItem(List<RtPopupOverlayItem> paramList)
  {
    addItem(paramList, false);
  }
  
  void initLayer()
  {
    this.mLayerID = this.mMapView.getController().getBaseMap().AddLayer(4, 500, "rtpopup");
    if (this.mLayerID == 0) {}
  }
  
  void reAddAll()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.mItems);
    removeAll();
    addItem(localArrayList);
  }
  
  public boolean removeAll()
  {
    if (this.mMapView.getController().getBaseMap() != null) {
      this.mMapView.getController().getBaseMap().ClearLayer(this.mLayerID);
    }
    this.mItems.clear();
    new Bundle().putInt("rtpopaddr", this.mLayerID);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/RtPopupOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */