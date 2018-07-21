package com.baidu.navi.fragment;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.view.dialog.m.a;
import com.baidu.carlife.view.dialog.o;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.adapter.DragSortListAdapter;
import com.baidu.navi.adapter.HistoryRouteAdapter;
import com.baidu.navi.controller.RouteCustomController;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.ListViewUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StatisticUtils;
import com.baidu.navi.view.DragSortListener;
import com.baidu.navi.view.draglistview.DragListView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider.OnRGSubStatusListener;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.PointSelectNode;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.RoutePlanTimeUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class RoutePlanFragment
  extends BrowseMapFragment
  implements View.OnClickListener
{
  public static final String KEY_FROM_POI_DETAIL = "from_poi_detail";
  public static final String KEY_FROM_ROUTE_GUIDE = "from_route_guide";
  public static final String KEY_SET_POI = "set_poi";
  public static final String KEY_SET_POI_TYPE = "set_poi_type";
  private static final String TAG = "RoutePlan";
  private boolean isNeedInitial = false;
  private View mAboveLayout;
  private Thread mAntiGeoThread;
  private ImageView mBtnBack;
  private ImageView mBtnOpenPreference;
  private View mCleanHistoryLayout;
  private TextView mCleanHistoryRouteBtn = null;
  private Button mClearRouteButton = null;
  private ImageView mDivider1;
  private ImageView mDivider2;
  private int mDividerHeight = 0;
  private long mDoubleClickTime = 0L;
  private DragListView mDragSortListView;
  private ViewGroup mGroupView;
  private HistoryRouteAdapter mHistoryDataAdapter;
  private TextView mHistoryRouteText;
  private LinearLayout mHistoryRouteTextLayout;
  private DragSortListener mHorizontalDragSortListener = new DragSortListener()
  {
    public void onDeleteNode(int paramAnonymousInt)
    {
      if (paramAnonymousInt < RoutePlanFragment.this.mSrcData.size())
      {
        if (RoutePlanFragment.this.mSrcData.size() <= 2) {
          break label48;
        }
        RoutePlanFragment.this.mSrcData.remove(paramAnonymousInt);
      }
      for (;;)
      {
        RoutePlanFragment.this.refreshDragListView();
        return;
        label48:
        if (RoutePlanFragment.this.mSrcData.size() == 2)
        {
          RoutePlanFragment.this.mSrcData.remove(paramAnonymousInt);
          RoutePlanFragment.this.mSrcData.insertElementAt(new RoutePlanNode(), paramAnonymousInt);
        }
      }
    }
    
    public void onDrop(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      LogUtil.e("RoutePlan", "onDrop from=" + paramAnonymousInt1 + ",to=" + paramAnonymousInt2);
      int i = paramAnonymousInt2;
      if (paramAnonymousInt2 == 0) {
        i = 1;
      }
      if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < RoutePlanFragment.this.mSrcData.size()) && (i >= 0) && (i < RoutePlanFragment.this.mSrcData.size())) {
        RoutePlanFragment.this.mSrcData.insertElementAt(RoutePlanFragment.this.mSrcData.remove(paramAnonymousInt1), i);
      }
    }
  };
  private int mHour;
  private boolean mIsBackHome = false;
  private boolean mIsFromPoiDetail = false;
  private boolean mIsFromRouteGuide = false;
  private AdapterView.OnItemClickListener mItemHorizontalClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (BaseFragment.mActivity == null) {
        return;
      }
      LogUtil.e("RoutePlan", "onItemClick position=" + paramAnonymousInt);
      RoutePlanFragment.this.goToRoutePlanNodePage(paramAnonymousInt);
    }
  };
  private AdapterView.OnItemClickListener mItemVerticalClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (BaseFragment.mActivity == null) {
        return;
      }
      LogUtil.e("RoutePlan", "onItemClick position=" + paramAnonymousInt);
      RoutePlanFragment.this.goToRoutePlanNodePage(paramAnonymousInt);
      if (paramAnonymousInt == 0)
      {
        StatisticManager.onEvent("410167", "410167");
        return;
      }
      if (paramAnonymousInt == RoutePlanFragment.this.mSrcData.size() - 1)
      {
        StatisticManager.onEvent("410169", "410169");
        return;
      }
      StatisticManager.onEvent("410168", "410168");
    }
  };
  private int mMinute;
  private BNRouteGuider.OnRGSubStatusListener mOnRGSubStatusListener = new BNRouteGuider.OnRGSubStatusListener()
  {
    public void onArriveDest(Message paramAnonymousMessage) {}
    
    public void onArriveDestNear(Message paramAnonymousMessage) {}
    
    public void onReRouteCarFree(Message paramAnonymousMessage) {}
    
    public void onReRouteComplete(Message paramAnonymousMessage) {}
    
    public void onRoutePlanYawing(Message paramAnonymousMessage)
    {
      if ((RoutePlanFragment.this.mIsFromRouteGuide) && (BaseFragment.mActivity != null) && (!BaseFragment.mActivity.isFinishing())) {
        RoutePlanFragment.this.back(null);
      }
    }
  };
  private TimePickerDialog.OnTimeSetListener mOnTimeSetListener = new TimePickerDialog.OnTimeSetListener()
  {
    public void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      RoutePlanFragment.access$402(RoutePlanFragment.this, paramAnonymousInt1);
      RoutePlanFragment.access$502(RoutePlanFragment.this, paramAnonymousInt2);
    }
  };
  private RelativeLayout mPreferenceLayout;
  private Handler mRPHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        do
        {
          return;
          LogUtil.e("RoutePlan", "onRoutePlanSuccess");
          if ((BaseFragment.mActivity != null) && (!BaseFragment.mActivity.isFinishing()))
          {
            RoutePlanFragment.this.removeAllFragmentByType(52);
            RoutePlanFragment.this.showFragment(52, null);
          }
          BNRoutePlaner.getInstance().removeRouteResultHandler(RoutePlanFragment.this.mRPHandler);
          return;
          LogUtil.e("RoutePlan", "onRoutePlanFail mIsFromRouteGuide=" + RoutePlanFragment.this.mIsFromRouteGuide);
          RoutePlanFragment.this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
          if (RoutePlanFragment.this.mIsFromRouteGuide) {
            RoutePlanFragment.access$902(RoutePlanFragment.this, true);
          }
          BNRoutePlaner.getInstance().removeRouteResultHandler(RoutePlanFragment.this.mRPHandler);
          return;
          LogUtil.e("RoutePlan", "onRoutePlanFail mIsFromRouteGuide=" + RoutePlanFragment.this.mIsFromRouteGuide);
          RoutePlanFragment.this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
        } while (!RoutePlanFragment.this.mIsFromRouteGuide);
        RoutePlanFragment.access$902(RoutePlanFragment.this, true);
        return;
        LogUtil.e("RoutePlan", "onRoutePlanCanceled");
        RoutePlanFragment.this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
        if (RoutePlanFragment.this.mIsFromRouteGuide) {
          RoutePlanFragment.access$902(RoutePlanFragment.this, true);
        }
        BNRoutePlaner.getInstance().removeRouteResultHandler(RoutePlanFragment.this.mRPHandler);
        return;
        LogUtil.e("RoutePlan", "onRoutePlanYawingFail mIsFromRouteGuide=" + RoutePlanFragment.this.mIsFromRouteGuide);
      } while (!RoutePlanFragment.this.mIsFromRouteGuide);
      RoutePlanFragment.access$902(RoutePlanFragment.this, true);
    }
  };
  private RoutePlanModel mRoutePlanModel = null;
  private Button mRouteplanButton = null;
  private ScrollView mScrollView;
  private Vector<RoutePlanNode> mSrcData = new Vector();
  private Handler mUIHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
      } while (paramAnonymousMessage.arg1 != 0);
      paramAnonymousMessage = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getAntiGeoPoi();
      RoutePlanFragment.this.fillAntiGeo(paramAnonymousMessage.mViewPoint, paramAnonymousMessage);
    }
  };
  private DragSortListAdapter mVerticalAdapter = null;
  private ImageView mVerticalAddNodeImageView = null;
  private DragSortListener mVerticalDragSortListener = new DragSortListener()
  {
    public void onDeleteNode(int paramAnonymousInt)
    {
      if (paramAnonymousInt < RoutePlanFragment.this.mSrcData.size())
      {
        if (RoutePlanFragment.this.mSrcData.size() <= 2) {
          break label74;
        }
        RoutePlanFragment.this.mSrcData.remove(paramAnonymousInt);
      }
      for (;;)
      {
        RoutePlanFragment.this.refreshDragListView();
        if (RoutePlanFragment.this.mVerticalAddNodeImageView.getVisibility() == 8) {
          RoutePlanFragment.this.mVerticalAddNodeImageView.setVisibility(0);
        }
        return;
        label74:
        if (RoutePlanFragment.this.mSrcData.size() == 2)
        {
          RoutePlanFragment.this.mSrcData.remove(paramAnonymousInt);
          RoutePlanFragment.this.mSrcData.insertElementAt(new RoutePlanNode(), paramAnonymousInt);
        }
      }
    }
    
    public void onDrop(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      LogUtil.e("RoutePlan", "onDrop from=" + paramAnonymousInt1 + ",to=" + paramAnonymousInt2);
      if ((paramAnonymousInt1 != paramAnonymousInt2) && (paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < RoutePlanFragment.this.mSrcData.size()) && (paramAnonymousInt2 >= 0) && (paramAnonymousInt2 < RoutePlanFragment.this.mSrcData.size())) {
        RoutePlanFragment.this.mSrcData.insertElementAt(RoutePlanFragment.this.mSrcData.remove(paramAnonymousInt1), paramAnonymousInt2);
      }
    }
  };
  private ListView mVerticalHistoryRouteList = null;
  
  private void addRoutePlanNode()
  {
    if (mActivity == null) {}
    for (;;)
    {
      return;
      int i = this.mSrcData.size();
      if (i < 5)
      {
        this.mSrcData.add(i - 1, new RoutePlanNode());
        refreshDragListView();
      }
      while (this.mSrcData.size() == 5)
      {
        this.mVerticalAddNodeImageView.setVisibility(8);
        return;
        this.mVerticalAddNodeImageView.setVisibility(8);
      }
    }
  }
  
  private void asynGetPoiByPoint(GeoPoint paramGeoPoint)
  {
    for (boolean bool = false; !bool; bool = BNPoiSearcher.getInstance().asynGetPoiByPoint(paramGeoPoint, 10000, this.mUIHandler)) {}
  }
  
  private void closePreferenceDialog()
  {
    if (this.mPreferenceLayout != null)
    {
      this.mPreferenceLayout.removeAllViews();
      this.mPreferenceLayout.setVisibility(8);
    }
  }
  
  private void endRecord()
  {
    LogUtil.e("RoutePlan", "endRecord()");
    if (BNSettingManager.isRecordTrackEnable()) {
      new Thread(getClass().getSimpleName() + "_QuitRouteGuide")
      {
        public void run()
        {
          RoutePlanNode localRoutePlanNode = BNLocationManagerProxy.getInstance().getCurLocationNode();
          if ((localRoutePlanNode != null) && (localRoutePlanNode.mName != null) && (localRoutePlanNode.mName.length() > 0)) {
            str = localRoutePlanNode.mName;
          }
          String str = JNITrajectoryControl.sInstance.getCurrentUUID();
          if ((localRoutePlanNode != null) && (localRoutePlanNode.mGeoPoint != null) && (str != null)) {}
        }
      }.start();
    }
  }
  
  private void fillAntiGeo(GeoPoint paramGeoPoint, SearchPoi paramSearchPoi)
  {
    if ((paramGeoPoint == null) || (paramSearchPoi == null)) {
      return;
    }
    int j = this.mSrcData.size();
    int i = 0;
    while (i < j)
    {
      RoutePlanNode localRoutePlanNode = (RoutePlanNode)this.mSrcData.get(i);
      if (localRoutePlanNode.mGeoPoint.equals(paramGeoPoint))
      {
        localRoutePlanNode.mName = paramSearchPoi.mName;
        localRoutePlanNode.mDescription = paramSearchPoi.mAddress;
      }
      i += 1;
    }
    refreshDragListView();
  }
  
  private void findViews()
  {
    this.mAboveLayout = this.mGroupView.findViewById(2131624433);
    this.mRouteplanButton = ((Button)this.mGroupView.findViewById(2131624431));
    this.mClearRouteButton = ((Button)this.mGroupView.findViewById(2131624430));
    this.mDragSortListView = ((DragListView)this.mGroupView.findViewById(2131624436));
    this.mVerticalAddNodeImageView = ((ImageView)this.mGroupView.findViewById(2131624435));
    this.mDivider1 = ((ImageView)this.mGroupView.findViewById(2131625159));
    this.mHistoryRouteTextLayout = ((LinearLayout)this.mGroupView.findViewById(2131625160));
    this.mHistoryRouteText = ((TextView)this.mGroupView.findViewById(2131625161));
    this.mVerticalHistoryRouteList = ((ListView)this.mGroupView.findViewById(2131624441));
    this.mCleanHistoryRouteBtn = ((TextView)this.mCleanHistoryLayout.findViewById(2131624297));
    this.mDivider2 = ((ImageView)this.mCleanHistoryLayout.findViewById(2131624298));
    this.mPreferenceLayout = ((RelativeLayout)this.mGroupView.findViewById(2131624442));
    this.mBtnBack = ((ImageView)this.mGroupView.findViewById(2131625157));
    this.mBtnOpenPreference = ((ImageView)this.mGroupView.findViewById(2131625158));
    this.mScrollView = ((ScrollView)this.mGroupView.findViewById(2131624432));
  }
  
  private String getRoutePlanNodeName(RoutePlanNode paramRoutePlanNode)
  {
    if ((paramRoutePlanNode == null) || (!paramRoutePlanNode.isNodeSettedData())) {
      return "";
    }
    switch (paramRoutePlanNode.mFrom)
    {
    case 2: 
    default: 
      if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {
        paramRoutePlanNode = StyleManager.getString(2131296304);
      }
      break;
    }
    for (;;)
    {
      return paramRoutePlanNode;
      String str = StyleManager.getString(2131296306);
      if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {}
      for (paramRoutePlanNode = str;; paramRoutePlanNode = str + "(" + paramRoutePlanNode.mName + ")") {
        break;
      }
      str = StyleManager.getString(2131296303);
      if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {}
      for (paramRoutePlanNode = str;; paramRoutePlanNode = str + "(" + paramRoutePlanNode.mName + ")") {
        break;
      }
      str = StyleManager.getString(2131296302);
      if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {}
      for (paramRoutePlanNode = str;; paramRoutePlanNode = str + "(" + paramRoutePlanNode.mName + ")") {
        break;
      }
      if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {
        StyleManager.getString(2131296305);
      }
      for (;;)
      {
        break;
        str = paramRoutePlanNode.mName;
      }
      paramRoutePlanNode = paramRoutePlanNode.mName;
    }
  }
  
  private void goToRoutePlanNodePage(int paramInt)
  {
    if ((ForbidDaulClickUtils.isFastDoubleClick()) || (mActivity == null)) {
      return;
    }
    Object localObject;
    int i;
    if (paramInt == 0)
    {
      localObject = StyleManager.getString(2131296904);
      i = 0;
    }
    for (;;)
    {
      this.mRoutePlanModel.setPointSelectNodeInfo(paramInt, (String)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("from_Fragment", 50);
      ((Bundle)localObject).putInt("select_point_action", 1);
      ((Bundle)localObject).putInt("set_poi_type", i);
      showFragment(51, (Bundle)localObject);
      return;
      if (paramInt == this.mSrcData.size() - 1)
      {
        localObject = StyleManager.getString(2131296898);
        i = 2;
      }
      else
      {
        localObject = StyleManager.getString(2131296898) + paramInt;
        i = 1;
      }
    }
  }
  
  private void handleArguments()
  {
    int i;
    if (this.mRoutePlanModel.isSelectNode())
    {
      LogUtil.e("RoutePlan", "isSelectNode Back");
      localObject = this.mRoutePlanModel.getPointSelectNode();
      if (((PointSelectNode)localObject).getRoutePlanNode().isNodeSettedData())
      {
        i = ((PointSelectNode)localObject).getPointIndex();
        if (i != this.mSrcData.size()) {
          break label122;
        }
        this.mSrcData.add(i - 1, ((PointSelectNode)localObject).getRoutePlanNode());
        refreshDragListView();
        LogUtil.e("RoutePlan", "~~~ add Via Node " + ((RoutePlanNode)this.mSrcData.get(i - 1)).toString());
      }
    }
    label121:
    label122:
    label284:
    label290:
    label320:
    RoutePlanNode localRoutePlanNode1;
    label519:
    do
    {
      do
      {
        int m;
        do
        {
          break label121;
          for (;;)
          {
            this.mRoutePlanModel.clearSelectNode();
            return;
            if ((i < 0) || (i >= this.mSrcData.size())) {
              break;
            }
            ((RoutePlanNode)this.mSrcData.get(i)).copy(((PointSelectNode)localObject).getRoutePlanNode());
          }
          if (this.mShowBundle != null)
          {
            this.mIsFromRouteGuide = this.mShowBundle.getBoolean("from_route_guide", false);
            this.mIsFromPoiDetail = this.mShowBundle.getBoolean("from_poi_detail", false);
          }
          if (!this.mIsFromRouteGuide) {
            break label519;
          }
          localObject = this.mRoutePlanModel.getRouteInput();
          m = ((ArrayList)localObject).size();
        } while (m < 2);
        this.mSrcData.clear();
        i = BNRoutePlaner.getInstance().getRemainedDests();
        LogUtil.e("RoutePlan", "pointCount: " + m + ", remainedDestsNum: " + i);
        if (i >= 0)
        {
          i = m - 1 - i;
          int k = 0;
          j = i;
          i = k;
          if (i < m)
          {
            if ((i <= 0) || (j <= 0)) {
              break label320;
            }
            j -= 1;
          }
        }
        for (;;)
        {
          i += 1;
          break label290;
          break label121;
          break;
          i = 0;
          break label284;
          localRoutePlanNode1 = new RoutePlanNode((RoutePlanNode)((ArrayList)localObject).get(i));
          LogUtil.e("RoutePlan", "Node[" + i + "]:" + localRoutePlanNode1.toString());
          if (3 == localRoutePlanNode1.mFrom)
          {
            RoutePlanNode localRoutePlanNode2 = BNSysLocationManager.getInstance().getCurLocationNode();
            if ((localRoutePlanNode2 != null) && (localRoutePlanNode2.isNodeSettedData()))
            {
              localRoutePlanNode1.copy(localRoutePlanNode2);
              LogUtil.e("RoutePlan", "SysLocation Node[" + i + "]:" + localRoutePlanNode1.toString());
            }
          }
          renameRoutePlanNode(localRoutePlanNode1, false);
          LogUtil.e("RoutePlan", "Last Node[" + i + "]:" + localRoutePlanNode1.toString());
          this.mSrcData.add(new RoutePlanNode(localRoutePlanNode1));
        }
      } while (!this.mIsFromPoiDetail);
      i = this.mShowBundle.getInt("set_poi_type", -1);
    } while (i == -1);
    Object localObject = this.mRoutePlanModel.getPointPoiDetail();
    int j = this.mSrcData.size();
    if (((RoutePlanNode)localObject).isNodeSettedData())
    {
      if (i != 0) {
        break label595;
      }
      ((RoutePlanNode)this.mSrcData.get(0)).copy((RoutePlanNode)localObject);
    }
    for (;;)
    {
      this.mRoutePlanModel.clearPointPoiDetail();
      return;
      label595:
      if (i == 2)
      {
        ((RoutePlanNode)this.mSrcData.get(j - 1)).copy((RoutePlanNode)localObject);
      }
      else if (i == 1)
      {
        localRoutePlanNode1 = new RoutePlanNode();
        localRoutePlanNode1.copy((RoutePlanNode)localObject);
        this.mSrcData.add(j - 1, localRoutePlanNode1);
      }
    }
  }
  
  private void initRoutePlanData(boolean paramBoolean)
  {
    this.mSrcData.clear();
    if (!paramBoolean)
    {
      RoutePlanNode localRoutePlanNode = new RoutePlanNode(BNLocationManagerProxy.getInstance().getLastValidLocation(), 3, null, null);
      this.mSrcData.add(localRoutePlanNode);
    }
    LogUtil.e("RoutePlan", "initRoutePlanData............enter, mSrcData.size() = " + this.mSrcData.size());
    while (this.mSrcData.size() < 2) {
      this.mSrcData.add(new RoutePlanNode());
    }
    if (this.mSrcData.size() < 2)
    {
      int j = this.mSrcData.size();
      int i = 0;
      while (i < 2 - j)
      {
        this.mSrcData.add(new RoutePlanNode());
        i += 1;
      }
    }
  }
  
  private void pickRoutePlanTime()
  {
    LogUtil.e("RoutePlan", "pickRoutePlanTime");
    Object localObject = RoutePlanTimeUtil.getInstance();
    int i;
    if ((this.mHour >= 0) && (this.mMinute >= 0)) {
      i = this.mHour;
    }
    for (int j = this.mMinute;; j = ((RoutePlanTimeUtil)localObject).getCurrerntMinite())
    {
      localObject = new TimePickerDialog(mActivity, this.mOnTimeSetListener, i, j, true);
      ((TimePickerDialog)localObject).setTitle(2131296906);
      ((TimePickerDialog)localObject).show();
      return;
      i = ((RoutePlanTimeUtil)localObject).getCurrerntHour();
    }
  }
  
  private void refreshDragListView()
  {
    this.mVerticalAdapter.notifyDataSetChanged();
    ListViewUtils.setListViewHeightBasedOnChildren(this.mDragSortListView);
  }
  
  private void renameRoutePlanNode(RoutePlanNode paramRoutePlanNode, boolean paramBoolean)
  {
    if ((paramRoutePlanNode == null) || (mActivity == null)) {}
    do
    {
      return;
      switch (paramRoutePlanNode.mFrom)
      {
      default: 
        return;
      }
    } while (!paramBoolean);
    paramRoutePlanNode.mName = StyleManager.getString(2131296670, new Object[] { paramRoutePlanNode.mName });
    return;
    paramRoutePlanNode.mName = StyleManager.getString(2131296669);
    return;
    paramRoutePlanNode.mName = StyleManager.getString(2131296668);
  }
  
  private void requestAntiGeo()
  {
    final Vector localVector = new Vector();
    Iterator localIterator = this.mSrcData.iterator();
    while (localIterator.hasNext()) {
      localVector.add(new RoutePlanNode((RoutePlanNode)localIterator.next()));
    }
    this.mAntiGeoThread = new Thread(getClass().getSimpleName())
    {
      public void run()
      {
        int j = localVector.size();
        int i = 0;
        if (i < j)
        {
          RoutePlanNode localRoutePlanNode = (RoutePlanNode)localVector.get(i);
          if (1 == localRoutePlanNode.mFrom) {
            if ((localRoutePlanNode.isNodeSettedData()) && ((TextUtils.isEmpty(localRoutePlanNode.mName)) || (StyleManager.getString(2131296305).equals(localRoutePlanNode.mName)))) {
              RoutePlanFragment.this.asynGetPoiByPoint(localRoutePlanNode.mGeoPoint);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if ((3 == localRoutePlanNode.mFrom) && (BaseFragment.mActivity != null) && ((TextUtils.isEmpty(localRoutePlanNode.mName)) || (StyleManager.getString(2131296903).equals(localRoutePlanNode.mName)))) {
              RoutePlanFragment.this.asynGetPoiByPoint(localRoutePlanNode.mGeoPoint);
            }
          }
        }
      }
    };
    this.mAntiGeoThread.start();
  }
  
  private void routePlan()
  {
    if (this.mSrcData.size() < 1)
    {
      TipTool.onCreateToastDialog(mActivity, 2131296909);
      return;
    }
    Object localObject1 = (RoutePlanNode)this.mSrcData.get(0);
    if ((localObject1 == null) || ((((RoutePlanNode)localObject1).getLatitudeE6() <= 0) && (((RoutePlanNode)localObject1).getLongitudeE6() <= 0)))
    {
      TipTool.onCreateToastDialog(mActivity, 2131296909);
      return;
    }
    Object localObject2;
    if ((3 == ((RoutePlanNode)localObject1).mFrom) && (!((RoutePlanNode)localObject1).isNodeSettedData()))
    {
      localObject2 = BNLocationManagerProxy.getInstance();
      if (((BNLocationManagerProxy)localObject2).isLocationValid()) {
        ((RoutePlanNode)this.mSrcData.get(0)).copy(((BNLocationManagerProxy)localObject2).getCurLocationNode());
      }
    }
    else
    {
      if (3 == ((RoutePlanNode)localObject1).mFrom)
      {
        localObject2 = BNLocationManagerProxy.getInstance().getCurLocation();
        if ((localObject2 != null) && (localObject1 != null) && (((LocData)localObject2).type == 61))
        {
          ((RoutePlanNode)localObject1).mGPSAccuracy = ((LocData)localObject2).accuracy;
          ((RoutePlanNode)localObject1).mGPSSpeed = ((LocData)localObject2).speed;
        }
      }
      localObject1 = (RoutePlanNode)this.mSrcData.get(0);
      if ((localObject1 != null) && (((RoutePlanNode)localObject1).isNodeSettedData())) {
        break label204;
      }
      TipTool.onCreateToastDialog(mActivity, 2131296909);
      return;
    }
    TipTool.onCreateToastDialog(mActivity, 2131296908);
    return;
    label204:
    localObject1 = new ArrayList();
    int j = this.mSrcData.size();
    int i = 0;
    while (i < j)
    {
      localObject2 = (RoutePlanNode)this.mSrcData.get(i);
      if ((this.mSrcData.size() > 2) && (i >= 1) && (i < this.mSrcData.size() - 1)) {
        ((RoutePlanNode)localObject2).clearSubPoiList();
      }
      if (((RoutePlanNode)localObject2).isNodeSettedData()) {
        ((ArrayList)localObject1).add(localObject2);
      }
      i += 1;
    }
    if (((ArrayList)localObject1).size() >= 2)
    {
      BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
      BNRoutePlaner.getInstance().setPointsToCalcRoute((ArrayList)localObject1);
      StatisticUtils.statSetDestFromRoutePlan();
      return;
    }
    TipTool.onCreateToastDialog(mActivity, 2131296909);
  }
  
  private void setListViewHeightBasedOnChildren(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int j = 0;
    int k = localListAdapter.getCount();
    int i = 0;
    while (i < k)
    {
      localObject = localListAdapter.getView(i, null, paramListView);
      ((View)localObject).measure(0, 0);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void setupDragListView()
  {
    if (this.mDragSortListView != null)
    {
      this.mDragSortListView.setVisibility(0);
      this.mDragSortListView.setOnItemClickListener(this.mItemVerticalClickListener);
      this.mDragSortListView.setAdapter(this.mVerticalAdapter);
    }
  }
  
  private void setupHistoryListView()
  {
    this.mHistoryDataAdapter.setListView(this.mVerticalHistoryRouteList);
    this.mHistoryDataAdapter.setCleanHistoryLayout(this.mCleanHistoryLayout);
    this.mVerticalHistoryRouteList.addFooterView(this.mCleanHistoryLayout);
    this.mVerticalHistoryRouteList.setAdapter(this.mHistoryDataAdapter);
    this.mVerticalHistoryRouteList.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {
          return;
        }
        if (RoutePlanFragment.this.mIsFromRouteGuide)
        {
          paramAnonymousAdapterView = new o(BaseFragment.mActivity).f(2131296275).j(2131296259).k(2131296264).m().d(new m.a()
          {
            public void onClick()
            {
              if (BaiduNaviSDKManager.getInstance().isNaviBegin())
              {
                RoutePlanFragment.this.endRecord();
                BaiduNaviSDKManager.getInstance().quitNavi();
              }
              RoutePlanFragment.this.removeAllFragmentByType(113);
              RoutePlanFragment.access$702(RoutePlanFragment.this, false);
              RoutePlanFragment.this.mShowBundle.putBoolean("from_route_guide", false);
              ArrayList localArrayList = RoutePlanFragment.this.mHistoryDataAdapter.getRoutePoiInfo(paramAnonymousInt);
              BNRoutePlaner.getInstance().addRouteResultHandler(RoutePlanFragment.this.mRPHandler);
              BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, 1);
            }
          });
          RoutePlanFragment.this.showDialog(paramAnonymousAdapterView);
        }
        for (;;)
        {
          StatisticUtils.statSetDestFromHistoryRoute();
          StatisticManager.onEvent("410173", "410173");
          return;
          paramAnonymousAdapterView = RoutePlanFragment.this.mHistoryDataAdapter.getRoutePoiInfo(paramAnonymousInt);
          BNRoutePlaner.getInstance().addRouteResultHandler(RoutePlanFragment.this.mRPHandler);
          BNRoutePlaner.getInstance().setPointsToCalcRoute(paramAnonymousAdapterView);
        }
      }
    });
    this.mVerticalHistoryRouteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {
          return false;
        }
        RoutePlanFragment.this.mHistoryDataAdapter.showDelHistoryItemDialog(paramAnonymousInt);
        return false;
      }
    });
  }
  
  private void setupPreferenceList() {}
  
  private void setupView()
  {
    LogUtil.e("RoutePlan", "setupView mOrientation=" + this.mOrientation);
    if (mActivity == null) {
      return;
    }
    findViews();
    if (this.mCleanHistoryRouteBtn != null) {
      this.mCleanHistoryRouteBtn.setVisibility(0);
    }
    this.mCleanHistoryLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RoutePlanFragment.this.mHistoryDataAdapter.showCleanAllHistoryDialog();
        StatisticManager.onEvent("410174", "410174");
      }
    });
    this.mBtnBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RoutePlanFragment.this.mIsBackHome) {
          if ((BaseFragment.mActivity != null) && (!BaseFragment.mActivity.isFinishing())) {
            RoutePlanFragment.this.backTo(531, null);
          }
        }
        for (;;)
        {
          StatisticManager.onEvent("410166", "410166");
          return;
          if ((BaseFragment.mActivity != null) && (!BaseFragment.mActivity.isFinishing())) {
            RoutePlanFragment.this.back(null);
          }
        }
      }
    });
    this.mBtnOpenPreference.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {
          return;
        }
        RoutePlanFragment.this.mPreferenceLayout.setVisibility(0);
        RoutePlanFragment.this.setupPreferenceList();
      }
    });
    this.mPreferenceLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    if (this.mClearRouteButton != null)
    {
      this.mClearRouteButton.setVisibility(0);
      this.mClearRouteButton.setOnClickListener(this);
    }
    if (this.mRouteplanButton != null)
    {
      this.mRouteplanButton.setVisibility(0);
      this.mRouteplanButton.setOnClickListener(this);
    }
    if (this.mVerticalAddNodeImageView != null)
    {
      this.mVerticalAddNodeImageView.setVisibility(0);
      this.mVerticalAddNodeImageView.setOnClickListener(this);
    }
    if (this.mVerticalHistoryRouteList != null)
    {
      this.mVerticalHistoryRouteList.setVisibility(0);
      setupHistoryListView();
    }
    setupDragListView();
    refreshDragListView();
    LogUtil.e("RoutePlan", "setupView()................leave");
  }
  
  public void jumpRouteCustomDetail(int paramInt)
  {
    ArrayList localArrayList = this.mHistoryDataAdapter.getRoutePoiInfo(paramInt);
    RouteCustomController.getInstance().calcExtendRouteResult(localArrayList, getNaviFragmentManager());
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mRoutePlanModel = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel"));
    this.mVerticalAdapter = new DragSortListAdapter(getContext(), this.mVerticalDragSortListener, this.mSrcData);
    this.mHistoryDataAdapter = new HistoryRouteAdapter(mActivity, this);
    super.onAttach(paramActivity);
  }
  
  public boolean onBackPressed()
  {
    if ((this.mPreferenceLayout != null) && (this.mPreferenceLayout.getVisibility() == 0))
    {
      closePreferenceDialog();
      return true;
    }
    if ((this.mIsBackHome) && (mActivity != null) && (!mActivity.isFinishing()))
    {
      backTo(17, null);
      return true;
    }
    return super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131624431) {
      if (!ForbidDaulClickUtils.isFastDoubleClick()) {}
    }
    do
    {
      do
      {
        return;
      } while (this.mDragSortListView.checkDragListIsOccpuy());
      if (this.mIsFromRouteGuide) {
        showDialog(new o(mActivity).f(2131296275).j(2131296259).k(2131296264).m().d(new m.a()
        {
          public void onClick()
          {
            if (BaiduNaviSDKManager.getInstance().isNaviBegin())
            {
              RoutePlanFragment.this.endRecord();
              BaiduNaviSDKManager.getInstance().quitNavi();
            }
            RoutePlanFragment.this.removeAllFragmentByType(113);
            RoutePlanFragment.access$702(RoutePlanFragment.this, false);
            RoutePlanFragment.this.mShowBundle.putBoolean("from_route_guide", false);
            RoutePlanFragment.this.routePlan();
          }
        }));
      }
      for (;;)
      {
        StatisticManager.onEvent("410172", "410172");
        return;
        routePlan();
      }
      if (i == 2131624430)
      {
        initRoutePlanData(true);
        this.mDragSortListView.stopDrag();
        refreshDragListView();
        this.mVerticalAddNodeImageView.setVisibility(0);
        StatisticManager.onEvent("410171", "410171");
        return;
      }
    } while (i != 2131624435);
    addRoutePlanNode();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mGroupView = ((ViewGroup)paramLayoutInflater.inflate(2130968802, null));
    this.mCleanHistoryLayout = paramLayoutInflater.inflate(2130968711, null);
    this.mOrientation = mActivity.getResources().getConfiguration().orientation;
    this.mDragSortListView = ((DragListView)this.mGroupView.findViewById(2131624436));
    this.mDividerHeight = ScreenUtil.getInstance().dip2px(1);
    setupView();
    return this.mGroupView;
  }
  
  public void onDestroyView()
  {
    this.isNeedInitial = true;
    if (this.mDragSortListView != null) {
      this.mDragSortListView.stopDrag();
    }
    BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onInitMap()
  {
    super.onInitMap();
  }
  
  protected void onInitView()
  {
    LogUtil.e("RoutePlan", "onInitView start");
    initRoutePlanData(false);
    LogUtil.e("RoutePlan", "onInitView end");
  }
  
  public void onPause()
  {
    if ((this.mAntiGeoThread != null) && (this.mAntiGeoThread.isAlive())) {
      this.mAntiGeoThread.interrupt();
    }
    this.mAntiGeoThread = null;
    BNPoiSearcher.getInstance().cancelQuery();
    BNRouteGuider.getInstance().removeRGSubStatusListener(this.mOnRGSubStatusListener);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    BNMapController.getInstance().onResume();
    BNRouteGuider.getInstance().addRGSubStatusListener(this.mOnRGSubStatusListener);
    handleArguments();
    requestAntiGeo();
    refreshDragListView();
    this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected void onUpdateOrientation(int paramInt)
  {
    LogUtil.e("RoutePlan", "onUpdateOrientation orientation=" + paramInt);
    if ((this.mGroupView == null) || (mActivity == null)) {
      return;
    }
    this.mOrientation = mActivity.getResources().getConfiguration().orientation;
    this.mVerticalAdapter.notifyDataSetChanged();
    setListViewHeightBasedOnChildren(this.mDragSortListView);
    this.mHistoryDataAdapter.setOrientation(paramInt);
    this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
  }
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    int i = StyleManager.getColor(2131559150);
    this.mScrollView.setBackgroundColor(i);
    this.mVerticalAddNodeImageView.setImageDrawable(StyleManager.getDrawable(2130837942));
    this.mVerticalHistoryRouteList.setDivider(StyleManager.getDrawable(2130838474));
    this.mDragSortListView.setDivider(StyleManager.getDrawable(2130838474));
    this.mVerticalHistoryRouteList.setDividerHeight(this.mDividerHeight);
    this.mDragSortListView.setDividerHeight(this.mDividerHeight);
    this.mDivider1.setBackgroundDrawable(StyleManager.getDrawable(2130838474));
    this.mDivider2.setBackgroundDrawable(StyleManager.getDrawable(2130838474));
    i = StyleManager.getColor(2131558817);
    this.mHistoryRouteText.setTextColor(i);
    this.mCleanHistoryRouteBtn.setTextColor(i);
    this.mCleanHistoryLayout.setBackgroundDrawable(StyleManager.getDrawable(2130838558));
    i = StyleManager.getColor(2131558815);
    this.mHistoryRouteTextLayout.setBackgroundColor(i);
    refreshDragListView();
    this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/RoutePlanFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */