package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.adapter.HistoryDestinationAdapter;
import com.baidu.navi.controller.QuickFragmentListener;
import com.baidu.navi.controller.QuickRoutePlanController;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StatisticUtils;
import com.baidu.navi.view.CommonTitleBar;
import com.baidu.navi.view.TravelRefListener;
import com.baidu.navi.view.pulltorefresh.PullToRefreshListView;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.ArrayList;

public class CarModeHistoryDestFragment extends ContentFragment {
    private ImageView mBackImg;
    private View mCleanHistoryLayout;
    private TextView mCleanText;
    private C1443g mFocusAreaUp;
    private C1438c mFocusList;
    private QuickRoutePlanController mFragControl;
    private QuickFragmentListener mFragListener = new C38651();
    private HistoryDestinationAdapter mHistoryAdapter;
    private View mHistoryListLayout;
    private ListView mHistoryListView;
    private PullToRefreshListView mPullToRefeshListView;
    private CommonTitleBar mTitleBar;
    private TravelRefListener mTravelListener = new C38662();
    private ViewGroup mViewGroup;

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeHistoryDestFragment$1 */
    class C38651 implements QuickFragmentListener {
        C38651() {
        }

        public void showToast(int resId) {
        }

        public void showSetHomeAddrDialog() {
        }

        public void showSetCompAddrDialog() {
        }

        public void onRefreshHistoryList() {
            CarModeHistoryDestFragment.this.mHistoryAdapter.notifyHistoryDataSetChanged();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeHistoryDestFragment$2 */
    class C38662 implements TravelRefListener {
        C38662() {
        }

        public void onEnterTravelRefFragment(int position, boolean bIsFromQuickList) {
            RoutePlanNode startPoint = BNLocationManagerProxy.getInstance().getCurLocationNode();
            if (startPoint == null || !startPoint.isNodeSettedData()) {
                TipTool.onCreateToastDialog(CarModeHistoryDestFragment.this.getContext(), StyleManager.getString(C0965R.string.wait_for_loacte));
                return;
            }
            RoutePlanNode endPoint = CarModeHistoryDestFragment.this.mHistoryAdapter.getDate(position);
            ArrayList<RoutePlanNode> nodeList = new ArrayList();
            nodeList.add(startPoint);
            nodeList.add(endPoint);
            new Bundle().putInt(BundleKey.FROM_FRAGMENT, 49);
        }

        public void onAddOrDeleteSuccess() {
            if (CarModeHistoryDestFragment.this.mViewGroup != null) {
                CarModeHistoryDestFragment.this.initFocusChain(CarModeHistoryDestFragment.this.mViewGroup);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeHistoryDestFragment$3 */
    class C38673 implements OnClickListener {
        C38673() {
        }

        public void onClick(View v) {
            CarModeHistoryDestFragment.this.back(null);
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeHistoryDestFragment$4 */
    class C38684 implements OnClickListener {
        C38684() {
        }

        public void onClick(View arg0) {
            CarModeHistoryDestFragment.this.mHistoryAdapter.showCleanAllHistoryDialog();
            StatisticManager.onEvent(StatisticConstants.WILLINGGO_CLEARHISTORY, StatisticConstants.WILLINGGO_CLEARHISTORY);
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeHistoryDestFragment$5 */
    class C38695 implements OnItemClickListener {
        C38695() {
        }

        public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                if (arg1.findViewById(C0965R.id.btn_clear_history_desc) != null) {
                    CarModeHistoryDestFragment.this.mHistoryAdapter.showCleanAllHistoryDialog();
                    StatisticManager.onEvent(StatisticConstants.WILLINGGO_CLEARHISTORY, StatisticConstants.WILLINGGO_CLEARHISTORY);
                    return;
                }
                CarModeHistoryDestFragment.this.mFragControl.startRoutePlan(CarModeHistoryDestFragment.this.mHistoryAdapter.getDate(arg2 - 1));
                StatisticUtils.statSetDestFromHistory();
                StatisticManager.onEvent(StatisticConstants.WILLINGGO_HISTORY, StatisticConstants.WILLINGGO_HISTORY);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeHistoryDestFragment$6 */
    class C38706 implements OnItemLongClickListener {
        C38706() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
            if (ForbidDaulClickUtils.isFastDoubleClick()) {
                return false;
            }
            if (arg1.findViewById(C0965R.id.btn_clear_history_desc) != null) {
                return true;
            }
            RoutePlanNode node = CarModeHistoryDestFragment.this.mHistoryAdapter.getDate(arg2 - 1);
            CarModeHistoryDestFragment.this.mHistoryAdapter.showDelHistoryItemDialog(arg2 - 1);
            return false;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mFragControl = new QuickRoutePlanController(mActivity, this.mFragListener, getNaviFragmentManager(), this);
        this.mHistoryAdapter = new HistoryDestinationAdapter(mActivity, false, this.mTravelListener, this.mFragControl);
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.carmode_frag_history_dest, null);
        this.mCleanHistoryLayout = inflater.inflate(C0965R.layout.carmode_common_listview_footer, null);
        findViews();
        return this.mViewGroup;
    }

    public void findViews() {
        this.mTitleBar = (CommonTitleBar) this.mViewGroup.findViewById(C0965R.id.his_title_bar);
        setTitleBarLeftBack(mActivity.getLayoutInflater());
        this.mPullToRefeshListView = (PullToRefreshListView) this.mViewGroup.findViewById(C0965R.id.history_dest_list);
        this.mHistoryListView = (ListView) this.mPullToRefeshListView.getRefreshableView();
        this.mCleanText = (TextView) this.mCleanHistoryLayout.findViewById(C0965R.id.btn_clear_history_desc);
        this.mCleanText.setText(C0965R.string.route_plan_clear_history_dest);
    }

    private void setTitleBarLeftBack(LayoutInflater inflater) {
        LinearLayout layout = (LinearLayout) inflater.inflate(C0965R.layout.carmode_com_title_bar_back, null);
        this.mBackImg = (ImageView) layout.findViewById(C0965R.id.img_carmode_bar_back);
        this.mBackImg.setOnClickListener(getLeftOnClickListener());
        this.mTitleBar.findViewById(C0965R.id.left_content).setVisibility(0);
        this.mTitleBar.setRightContenVisible(false);
        this.mTitleBar.setLeftContent(layout);
    }

    private OnClickListener getLeftOnClickListener() {
        return new C38673();
    }

    public void setupViews() {
        this.mHistoryListView.addFooterView(this.mCleanHistoryLayout);
        this.mHistoryAdapter.setListView(this.mHistoryListView);
        this.mHistoryListView.setAdapter(this.mHistoryAdapter);
        this.mHistoryListView.setItemsCanFocus(true);
        this.mHistoryAdapter.setCleanHistoryLayout(this.mCleanHistoryLayout);
        this.mCleanHistoryLayout.setOnClickListener(new C38684());
        this.mHistoryListView.setOnItemClickListener(new C38695());
        this.mHistoryListView.setOnItemLongClickListener(new C38706());
    }

    protected void onInitView() {
        setupViews();
    }

    public void onResume() {
        super.onResume();
        this.mHistoryAdapter.setCarMode(true);
        this.mHistoryAdapter.notifyHistoryDataSetChanged();
        if (this.mViewGroup != null && getCurrentFragmentType() == 304) {
            initFocusChain(this.mViewGroup);
        }
    }

    public void onPause() {
        super.onPause();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
        initFocusChain(this.mViewGroup);
    }

    public void initFocusChain(View root) {
        if (this.mFocusAreaUp == null) {
            this.mFocusAreaUp = new C1443g(root.findViewById(C0965R.id.his_title_bar), 2);
            this.mFocusAreaUp.d(this.mBackImg);
        }
        if (this.mFocusList == null) {
            this.mFocusList = new C1438c(this.mHistoryListView, 6);
        }
        if (this.mHistoryAdapter == null || this.mHistoryAdapter.getCount() != 0) {
            C1440d.a().b(new C1436a[]{this.mFocusAreaUp, this.mFocusList});
            if (this.mHistoryListView != null) {
                this.mHistoryListView.requestFocus();
                return;
            }
            return;
        }
        C1440d.a().b(new C1436a[]{this.mFocusAreaUp});
        C1440d.a().h(this.mFocusAreaUp);
    }
}
