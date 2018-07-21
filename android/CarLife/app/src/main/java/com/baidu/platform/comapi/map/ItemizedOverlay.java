package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ItemizedOverlay<Item extends OverlayItem>
  extends Overlay
  implements Comparator<Integer>
{
  private OverlayItem focusItem;
  private Drawable focusMarker;
  private boolean isNeedUpdate;
  private ArrayList<Integer> mItemIndex;
  private ArrayList<OverlayItem> mItems;
  protected MapGLSurfaceView mMapView;
  private Drawable mMarker;
  private int updateType = 0;
  
  public ItemizedOverlay(Drawable paramDrawable, MapGLSurfaceView paramMapGLSurfaceView)
  {
    this.mType = 27;
    this.mMarker = paramDrawable;
    this.mItems = new ArrayList();
    this.mItemIndex = new ArrayList();
    this.mMapView = paramMapGLSurfaceView;
    this.mLayerID = 0;
  }
  
  private void addItem(List<OverlayItem> paramList, boolean paramBoolean)
  {
    if (this.mLayerID == 0)
    {
      if ((!paramBoolean) && (this.mItems != null) && (paramList != null)) {
        this.mItems.addAll(paramList);
      }
      return;
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.clear();
    ArrayList localArrayList = new ArrayList();
    localBundle1.putInt("itemaddr", this.mLayerID);
    localBundle1.putInt("bshow", 1);
    if (paramBoolean) {
      localBundle1.putString("extparam", "update");
    }
    int i = 0;
    while (i < paramList.size())
    {
      OverlayItem localOverlayItem = (OverlayItem)paramList.get(i);
      if (localOverlayItem.getMarker() == null) {
        localOverlayItem.setMarker(this.mMarker);
      }
      long l = System.currentTimeMillis();
      if (!paramBoolean) {
        localOverlayItem.setId("" + l + "_" + i);
      }
      ParcelItem localParcelItem = new ParcelItem();
      Object localObject = (BitmapDrawable)localOverlayItem.getMarker();
      if (localObject == null)
      {
        i += 1;
      }
      else
      {
        Bitmap localBitmap = ((BitmapDrawable)localObject).getBitmap();
        Bundle localBundle2 = new Bundle();
        if (localOverlayItem.getCoordType() == OverlayItem.CoordType.CoordType_BD09LL)
        {
          localObject = MapUtils.ll2mc(localOverlayItem.getPoint());
          label239:
          localBundle2.putInt("x", (int)((GeoPoint)localObject).getLongitude());
          localBundle2.putInt("y", (int)((GeoPoint)localObject).getLatitude());
          localBundle2.putInt("imgW", localBitmap.getWidth());
          localBundle2.putInt("imgH", localBitmap.getHeight());
          localBundle2.putInt("showLR", 1);
          localBundle2.putInt("iconwidth", 0);
          localBundle2.putInt("iconlayer", 1);
          localBundle2.putFloat("ax", localOverlayItem.getAnchorX());
          localBundle2.putFloat("ay", localOverlayItem.getAnchorY());
          localBundle2.putInt("bound", localOverlayItem.getBound());
          localBundle2.putInt("level", localOverlayItem.getLevel());
          localBundle2.putInt("mask", localOverlayItem.getMask());
          localBundle2.putString("popname", "" + localOverlayItem.getId());
          localBundle2.putInt("imgindex", localOverlayItem.getResId());
          if ((paramBoolean) || (!isSameImagAdded(localOverlayItem))) {
            break label521;
          }
          localBundle2.putByteArray("imgdata", null);
        }
        for (;;)
        {
          localObject = convertParcelItemToString(localOverlayItem.getClickRect());
          if ((localObject != null) && (localObject.length > 0)) {
            localBundle2.putStringArray("clickrect", (String[])localObject);
          }
          localBundle2.putBundle("animate", localOverlayItem.getAnimate());
          localParcelItem.setBundle(localBundle2);
          localArrayList.add(localParcelItem);
          if (paramBoolean) {
            break;
          }
          this.mItems.add(localOverlayItem);
          break;
          localObject = localOverlayItem.getPoint();
          break label239;
          label521:
          localObject = ByteBuffer.allocate(localBitmap.getWidth() * localBitmap.getHeight() * 4);
          localBitmap.copyPixelsToBuffer((Buffer)localObject);
          localBundle2.putByteArray("imgdata", ((ByteBuffer)localObject).array());
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      paramList = new ParcelItem[localArrayList.size()];
      i = 0;
      while (i < localArrayList.size())
      {
        paramList[i] = ((ParcelItem)localArrayList.get(i));
        i += 1;
      }
      localBundle1.putParcelableArray("itemdatas", paramList);
      this.mMapView.getController().getBaseMap().AddItemData(localBundle1);
    }
    this.isNeedUpdate = true;
  }
  
  protected static void boundCenter(OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem == null) {
      return;
    }
    paramOverlayItem.setBound(2);
  }
  
  protected static void boundCenterBottom(OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem == null) {
      return;
    }
    paramOverlayItem.setBound(1);
  }
  
  private String[] convertParcelItemToString(ArrayList<Bundle> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int j = paramArrayList.size();
      String[] arrayOfString = new String[j];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfString;
        if (i >= j) {
          break;
        }
        localObject = new JSONObject();
        Bundle localBundle = (Bundle)paramArrayList.get(i);
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            ((JSONObject)localObject).put(str, localBundle.get(str));
          }
          catch (JSONException localJSONException) {}
        }
        arrayOfString[i] = ((JSONObject)localObject).toString();
        i += 1;
      }
    }
    Object localObject = null;
    return (String[])localObject;
  }
  
  private int getSpanE6(boolean paramBoolean)
  {
    if (this.mItems == null) {}
    while (this.mItems.size() == 0) {
      return 0;
    }
    int k = Integer.MIN_VALUE;
    int j = Integer.MAX_VALUE;
    Iterator localIterator = this.mItems.iterator();
    if (!localIterator.hasNext()) {
      return k - j;
    }
    GeoPoint localGeoPoint = ((OverlayItem)localIterator.next()).getPoint();
    if (paramBoolean) {}
    for (int i = (int)localGeoPoint.getLatitude();; i = (int)localGeoPoint.getLongitude())
    {
      int m = k;
      if (i > k) {
        m = i;
      }
      k = m;
      if (i >= j) {
        break;
      }
      k = m;
      j = i;
      break;
    }
  }
  
  private boolean isSameImagAdded(OverlayItem paramOverlayItem)
  {
    Iterator localIterator = this.mItems.iterator();
    OverlayItem localOverlayItem;
    do
    {
      if (localIterator.hasNext())
      {
        localOverlayItem = (OverlayItem)localIterator.next();
        if (paramOverlayItem.getResId() != -1) {}
      }
      else
      {
        return false;
      }
    } while ((localOverlayItem.getResId() == -1) || (paramOverlayItem.getResId() != localOverlayItem.getResId()));
    return true;
  }
  
  public void addItem(OverlayItem paramOverlayItem)
  {
    if ((this.mItems != null) && (paramOverlayItem != null))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramOverlayItem);
      addItem(localArrayList);
    }
  }
  
  public void addItem(List<OverlayItem> paramList)
  {
    addItem(paramList, false);
  }
  
  public int compare(Integer paramInteger1, Integer paramInteger2)
  {
    int i = 1;
    paramInteger1 = ((OverlayItem)this.mItems.get(paramInteger1.intValue())).getPoint();
    paramInteger2 = ((OverlayItem)this.mItems.get(paramInteger2.intValue())).getPoint();
    if (paramInteger1.getLatitude() > paramInteger2.getLatitude()) {
      i = -1;
    }
    while (paramInteger1.getLatitude() < paramInteger2.getLatitude()) {
      return i;
    }
    if (paramInteger1.getLongitude() < paramInteger2.getLongitude()) {
      return -1;
    }
    if (paramInteger1.getLongitude() == paramInteger2.getLongitude()) {}
    for (i = 0;; i = 1) {
      return i;
    }
  }
  
  protected Item createItem(int paramInt)
  {
    return null;
  }
  
  public ArrayList<OverlayItem> getAllItem()
  {
    return this.mItems;
  }
  
  public GeoPoint getCenter()
  {
    int i = getIndexToDraw(0);
    if (i == -1) {
      return null;
    }
    return getItem(i).getPoint();
  }
  
  protected int getIndexToDraw(int paramInt)
  {
    if ((this.mItems == null) || (this.mItems.size() == 0)) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public final OverlayItem getItem(int paramInt)
  {
    if ((this.mItems != null) && (this.mItems.size() > paramInt) && (paramInt >= 0)) {
      return (OverlayItem)this.mItems.get(paramInt);
    }
    return null;
  }
  
  public int getLatSpanE6()
  {
    return getSpanE6(true);
  }
  
  int getLayerid()
  {
    return this.mLayerID;
  }
  
  public int getLonSpanE6()
  {
    return getSpanE6(false);
  }
  
  boolean getUpdateInfo()
  {
    return this.isNeedUpdate;
  }
  
  public int getUpdateType()
  {
    return this.updateType;
  }
  
  protected boolean hitTest(OverlayItem paramOverlayItem, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable == null) {
      return false;
    }
    paramOverlayItem = paramDrawable.getBounds();
    paramOverlayItem.left -= 10;
    paramOverlayItem.right += 10;
    paramOverlayItem.bottom += 10;
    paramOverlayItem.top -= 10;
    boolean bool = paramOverlayItem.contains(paramInt1, paramInt2);
    paramOverlayItem.left += 10;
    paramOverlayItem.right -= 10;
    paramOverlayItem.bottom -= 10;
    paramOverlayItem.top += 10;
    return bool;
  }
  
  void initItems(ArrayList<OverlayItem> paramArrayList)
  {
    int j = paramArrayList.size();
    if (this.mItemIndex != null)
    {
      this.mItemIndex.clear();
      this.mItemIndex = null;
    }
    if (this.mItems != null)
    {
      this.mItems.clear();
      this.mItems = null;
    }
    this.mItems = new ArrayList(j);
    this.mItemIndex = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.mItemIndex.add(i, Integer.valueOf(i));
      OverlayItem localOverlayItem = (OverlayItem)paramArrayList.get(i);
      if (localOverlayItem.getMarker() == null) {
        localOverlayItem.setMarker(this.mMarker);
      }
      this.mItems.add(i, localOverlayItem);
      i += 1;
    }
    Collections.sort(this.mItemIndex, this);
  }
  
  public void initLayer()
  {
    this.mLayerID = this.mMapView.getController().getBaseMap().AddLayer(0, 0, "item");
    if (this.mLayerID == 0) {
      throw new RuntimeException("can not add new layer");
    }
  }
  
  public boolean onTap(int paramInt)
  {
    return false;
  }
  
  public boolean onTap(int paramInt1, int paramInt2, GeoPoint paramGeoPoint)
  {
    return false;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapGLSurfaceView paramMapGLSurfaceView)
  {
    return false;
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
    if (this.mItems.isEmpty()) {
      return false;
    }
    if ((this.mMapView.getController() != null) && (this.mMapView.getController().getBaseMap() != null)) {
      this.mMapView.getController().getBaseMap().ClearLayer(this.mLayerID);
    }
    this.mItems.clear();
    this.isNeedUpdate = true;
    return true;
  }
  
  public boolean removeItem(OverlayItem paramOverlayItem)
  {
    if (this.mLayerID == 0) {}
    Bundle localBundle;
    do
    {
      do
      {
        return false;
        localBundle = new Bundle();
        localBundle.putInt("itemaddr", this.mLayerID);
      } while (paramOverlayItem.getId().equals(""));
      localBundle.putString("id", paramOverlayItem.getId());
    } while (!this.mMapView.getController().getBaseMap().RemoveItemData(localBundle));
    this.mItems.remove(paramOverlayItem);
    this.isNeedUpdate = true;
    return true;
  }
  
  public void setFocus(int paramInt, boolean paramBoolean)
  {
    if (this.focusItem == null) {}
    for (;;)
    {
      return;
      OverlayItem localOverlayItem = getItem(paramInt);
      if (localOverlayItem != null)
      {
        if (paramBoolean)
        {
          this.focusItem.setGeoPoint(new GeoPoint(localOverlayItem.getPoint().getLatitude(), localOverlayItem.getPoint().getLongitude()));
          if (this.mItems.contains(this.focusItem)) {
            updateItem(this.focusItem);
          }
        }
        while (this.mMapView != null)
        {
          this.mMapView.refresh(this);
          return;
          addItem(this.focusItem);
          continue;
          removeItem(this.focusItem);
        }
      }
    }
  }
  
  public void setFocusMarker(Drawable paramDrawable)
  {
    this.focusMarker = paramDrawable;
    if (this.focusItem == null) {
      this.focusItem = new OverlayItem(null, "", "");
    }
    this.focusItem.setMarker(this.focusMarker);
  }
  
  public void setFocusMarker(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    this.focusMarker = paramDrawable;
    if (this.focusItem == null)
    {
      this.focusItem = new OverlayItem(null, "", "");
      this.focusItem.setAnchor(paramFloat1, paramFloat2);
    }
    this.focusItem.setMarker(this.focusMarker);
  }
  
  void setUpdateInfo(boolean paramBoolean)
  {
    this.isNeedUpdate = paramBoolean;
  }
  
  public void setUpdateType(int paramInt)
  {
    this.updateType = paramInt;
  }
  
  public void setmMarker(Drawable paramDrawable)
  {
    this.mMarker = paramDrawable;
  }
  
  public int size()
  {
    if (this.mItems == null) {
      return 0;
    }
    return this.mItems.size();
  }
  
  public boolean updateItem(OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (paramOverlayItem.getId().equals(""));
      int j = 0;
      localObject = this.mItems.iterator();
      OverlayItem localOverlayItem;
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localOverlayItem = (OverlayItem)((Iterator)localObject).next();
      } while (!paramOverlayItem.getId().equals(localOverlayItem.getId()));
      i = 1;
    } while (i == 0);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramOverlayItem);
    addItem((List)localObject, true);
    return true;
  }
  
  public boolean updateItem(List<OverlayItem> paramList)
  {
    if (paramList == null) {
      return false;
    }
    addItem(paramList, true);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/ItemizedOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */