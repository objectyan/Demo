package com.baidu.navisdk.module.ugc.ui.inmap.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository.UgcBaseDataModel;
import com.baidu.navisdk.module.ugc.ui.inmap.main.UgcReportMapMainContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.inmap.main.UgcReportMapMainContract.View;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.util.ArrayList;
import java.util.List;

public class UgcReportMapMainView implements OnClickListener, View {
    private static final int SUBTIME_ADDRESS_TYPE = 1;
    private static final int SUBTIME_ROAD_TYPE = 2;
    private TextView checkDetailTv = null;
    private ImageView errPositionIV = null;
    private ImageView errPositionIVBg = null;
    private LinearLayout errPositionLayout = null;
    private TextView errPositionTV = null;
    private ArrayList<UgcBaseDataModel> feedBackList = new ArrayList();
    private TextView hasHelpTv = null;
    private ArrayList listItem = new ArrayList();
    private Context mContext = null;
    private Presenter mPresenter = null;
    private android.view.View mRootView = null;
    private android.view.View mSubItemFrame = null;
    private ListView mSubItemLv = null;
    private ImageView moreFeedbackIV = null;
    private ImageView moreFeedbackIVBg = null;
    private LinearLayout moreFeedbackLayout = null;
    private TextView moreFeedbackTV = null;
    private ImageView newPositionIV = null;
    private ImageView newPositionIVBg = null;
    private LinearLayout newPositionLayout = null;
    private TextView newPositionTV = null;
    private GridView parentItemsGv = null;
    private SubItemAdapter subItemAdapter = null;
    private ViewGroup titleBar = null;
    private android.view.View userInfoLayout = null;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.main.UgcReportMapMainView$1 */
    class C42071 implements OnItemClickListener {
        C42071() {
        }

        public void onItemClick(AdapterView<?> adapterView, android.view.View view, int position, long id) {
            if (UgcReportMapMainView.this.mPresenter != null && position >= 0) {
                MyViewHolder holder = (MyViewHolder) view.getTag();
                if (VERSION.SDK_INT >= 15) {
                    holder.mTxtView.callOnClick();
                }
                UgcBaseDataModel dataModel = holder.data;
                UgcReportMapMainView.this.mPresenter.gotoUgcMapH5Page(dataModel.iconUrl);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_4_1, "1", UgcReportMapMainView.this.subItemAdapter.itemType + "", dataModel.type + "");
            }
        }
    }

    class MapMainGvAdapter extends BaseAdapter implements OnClickListener {
        private int leftSpacing = 0;
        private Activity mContext;
        private Presenter mPresenter;
        OnTouchListener onTouchListener = new C42081();
        private int rightSpacing = 0;

        /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.main.UgcReportMapMainView$MapMainGvAdapter$1 */
        class C42081 implements OnTouchListener {
            C42081() {
            }

            public boolean onTouch(android.view.View v, MotionEvent event) {
                ImageView imgView = ((ViewHolder) v.getTag()).mChildIView;
                if (imgView != null) {
                    Drawable drawable;
                    if (event.getAction() == 0) {
                        drawable = imgView.getBackground();
                        if (drawable != null) {
                            drawable.setColorFilter(-7829368, Mode.MULTIPLY);
                        }
                    } else if (event.getAction() == 1 || event.getAction() == 3) {
                        drawable = imgView.getBackground();
                        if (drawable != null) {
                            drawable.clearColorFilter();
                        }
                    }
                }
                return false;
            }
        }

        class ViewHolder {
            public ImageView mChildIView;
            public ImageView mChildIViewBg;
            public TextView mChildName;
            public int position;

            ViewHolder() {
            }
        }

        public int getLeftSpacing() {
            return this.leftSpacing;
        }

        public int getRightSpacing() {
            return this.rightSpacing;
        }

        public MapMainGvAdapter(Presenter mPresenter, Activity mContext) {
            this.mContext = mContext;
            this.mPresenter = mPresenter;
        }

        public int getCount() {
            if (this.mPresenter == null) {
                return 0;
            }
            return this.mPresenter.parentItemsGvSize();
        }

        public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = JarUtils.inflate(this.mContext, C4048R.layout.nsdk_layout_ugc_report_child_gride_item_main, null);
                if (convertView == null) {
                    return null;
                }
                holder = new ViewHolder();
                holder.mChildIViewBg = (ImageView) convertView.findViewById(C4048R.id.ugc_report_child_iview_bg);
                holder.mChildIView = (ImageView) convertView.findViewById(C4048R.id.ugc_report_child_iview);
                holder.mChildName = (TextView) convertView.findViewById(C4048R.id.ugc_report_child_tview);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.position = position;
            if (convertView != null) {
                convertView.setOnTouchListener(this.onTouchListener);
            }
            convertView.setOnClickListener(this);
            this.mPresenter.parentItemsGvImageLoader(position, holder.mChildIView);
            holder.mChildName.setText(this.mPresenter.getParentItemsGvTextTile(position));
            return convertView;
        }

        public void onClick(android.view.View v) {
            try {
                ViewHolder mViewHolder = (ViewHolder) v.getTag();
                if (this.mPresenter != null) {
                    this.mPresenter.gotoMapSubDetailView(mViewHolder.position);
                }
            } catch (Exception e) {
            }
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }
    }

    private class SubItemAdapter<T> extends ArrayAdapter<T> {
        public int itemType = 1;

        class MyViewHolder {
            public UgcBaseDataModel data;
            public android.view.View itemView;
            public TextView mTxtView;

            MyViewHolder() {
            }
        }

        SubItemAdapter(Context context, List<T> list) {
            super(context, -1, -1, list);
        }

        public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {
            if (getContext() == null || ((LayoutInflater) getContext().getSystemService("layout_inflater")) == null) {
                return null;
            }
            MyViewHolder holder = new MyViewHolder();
            android.view.View itemView = JarUtils.inflate((Activity) UgcReportMapMainView.this.mContext, C4048R.layout.nsdk_layout_ugc_report_map_subitem_vw, null);
            TextView itemTextView = (TextView) itemView.findViewById(C4048R.id.text_content);
            UgcBaseDataModel text = (UgcBaseDataModel) getItem(position);
            itemTextView.setText(text.title);
            holder.itemView = itemView;
            holder.mTxtView = itemTextView;
            holder.data = text;
            itemView.setTag(holder);
            return itemView;
        }

        public void setItemType(int type) {
            this.itemType = type;
        }
    }

    public UgcReportMapMainView(Context mContext) {
        initVariable(mContext);
        initView();
        initListener();
    }

    private void initListener() {
        if (this.checkDetailTv != null) {
            this.checkDetailTv.setOnClickListener(this);
        }
        if (this.newPositionIV != null) {
            this.newPositionIV.setOnClickListener(this);
        }
        if (this.errPositionIV != null) {
            this.errPositionIV.setOnClickListener(this);
        }
        if (this.moreFeedbackIV != null) {
            this.moreFeedbackIV.setOnClickListener(this);
        }
        if (this.moreFeedbackIVBg != null) {
            this.moreFeedbackIVBg.setOnClickListener(this);
        }
        if (this.newPositionIVBg != null) {
            this.newPositionIVBg.setOnClickListener(this);
        }
        if (this.errPositionIVBg != null) {
            this.errPositionIVBg.setOnClickListener(this);
        }
    }

    public ViewGroup getTitleContainer() {
        return this.titleBar;
    }

    private void initVariable(Context mContext) {
        this.mContext = mContext;
    }

    public void initPresenterView() {
        if (this.parentItemsGv != null) {
            this.parentItemsGv.setAdapter(new MapMainGvAdapter(this.mPresenter, (Activity) this.mContext));
        }
        setUserInfoLayoutvisibile(false);
        if (this.mPresenter != null) {
            this.mPresenter.initUserInfo(this.hasHelpTv);
        }
        if (this.newPositionLayout != null && this.errPositionLayout != null && this.moreFeedbackLayout != null && this.newPositionTV != null && this.errPositionTV != null && this.moreFeedbackTV != null) {
            this.feedBackList = UgcDataRepository.getInstance().obtainMapFeedBackDataList();
            if (this.feedBackList == null || this.feedBackList.size() <= 0) {
                this.newPositionLayout.setVisibility(8);
                this.errPositionLayout.setVisibility(8);
                this.moreFeedbackLayout.setVisibility(8);
            } else if (this.feedBackList.size() == 1) {
                this.errPositionLayout.setVisibility(8);
                this.moreFeedbackLayout.setVisibility(8);
                this.newPositionTV.setText(((UgcBaseDataModel) this.feedBackList.get(0)).title);
                this.mPresenter.setOnlineImageLoader(getLocalType(((UgcBaseDataModel) this.feedBackList.get(0)).type), this.newPositionIV, ((UgcBaseDataModel) this.feedBackList.get(0)).iconUrl);
                this.newPositionLayout.setGravity(1);
            } else if (this.feedBackList.size() == 2) {
                this.moreFeedbackLayout.setVisibility(8);
                this.newPositionTV.setText(((UgcBaseDataModel) this.feedBackList.get(0)).title);
                this.errPositionTV.setText(((UgcBaseDataModel) this.feedBackList.get(1)).title);
                this.mPresenter.setOnlineImageLoader(getLocalType(((UgcBaseDataModel) this.feedBackList.get(0)).type), this.newPositionIV, ((UgcBaseDataModel) this.feedBackList.get(0)).iconUrl);
                this.mPresenter.setOnlineImageLoader(getLocalType(((UgcBaseDataModel) this.feedBackList.get(1)).type), this.errPositionIV, ((UgcBaseDataModel) this.feedBackList.get(1)).iconUrl);
                this.newPositionLayout.setGravity(1);
                this.errPositionLayout.setGravity(1);
            } else if (this.feedBackList.size() == 3) {
                this.newPositionTV.setText(((UgcBaseDataModel) this.feedBackList.get(0)).title);
                this.errPositionTV.setText(((UgcBaseDataModel) this.feedBackList.get(1)).title);
                this.moreFeedbackTV.setText(((UgcBaseDataModel) this.feedBackList.get(2)).title);
                this.mPresenter.setOnlineImageLoader(getLocalType(((UgcBaseDataModel) this.feedBackList.get(0)).type), this.newPositionIV, ((UgcBaseDataModel) this.feedBackList.get(0)).iconUrl);
                this.mPresenter.setOnlineImageLoader(getLocalType(((UgcBaseDataModel) this.feedBackList.get(1)).type), this.errPositionIV, ((UgcBaseDataModel) this.feedBackList.get(1)).iconUrl);
                this.mPresenter.setOnlineImageLoader(getLocalType(((UgcBaseDataModel) this.feedBackList.get(2)).type), this.moreFeedbackIV, ((UgcBaseDataModel) this.feedBackList.get(2)).iconUrl);
                this.moreFeedbackIV.setTag(this.feedBackList.get(2));
                this.moreFeedbackIVBg.setTag(this.feedBackList.get(2));
                this.newPositionLayout.setGravity(3);
                this.errPositionLayout.setGravity(1);
                this.moreFeedbackLayout.setGravity(5);
            }
        }
    }

    private int getLocalType(int type) {
        return 61440 + type;
    }

    public void setUserInfoLayoutvisibile(boolean show) {
        if (this.userInfoLayout != null) {
            if (show) {
                this.userInfoLayout.setVisibility(0);
            } else {
                this.userInfoLayout.setVisibility(8);
            }
        }
    }

    private void initView() {
        if (this.mContext != null) {
            this.mRootView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_ugc_report_map_main_view, null);
            if (this.mRootView != null) {
                this.parentItemsGv = (GridView) this.mRootView.findViewById(C4048R.id.ugc_map_main_allitems_gv);
                this.titleBar = (ViewGroup) this.mRootView.findViewById(C4048R.id.ugc_map_main_title_common_bar);
                this.checkDetailTv = (TextView) this.mRootView.findViewById(C4048R.id.ugc_map_main_check_detail_tv);
                this.hasHelpTv = (TextView) this.mRootView.findViewById(C4048R.id.ugc_map_main_has_help_tv);
                this.userInfoLayout = this.mRootView.findViewById(C4048R.id.ugc_map_main_user_info_layout);
                this.newPositionLayout = (LinearLayout) this.mRootView.findViewById(C4048R.id.ugc_map_main_new_position_layout);
                this.errPositionLayout = (LinearLayout) this.mRootView.findViewById(C4048R.id.ugc_map_main_err_position_layout);
                this.moreFeedbackLayout = (LinearLayout) this.mRootView.findViewById(C4048R.id.ugc_map_main_more_feedback_layout);
                this.newPositionIV = (ImageView) this.mRootView.findViewById(C4048R.id.ugc_map_main_new_position_iv);
                this.errPositionIV = (ImageView) this.mRootView.findViewById(C4048R.id.ugc_map_main_err_position_iv);
                this.moreFeedbackIV = (ImageView) this.mRootView.findViewById(C4048R.id.ugc_map_main_more_feedback_iv);
                this.moreFeedbackIVBg = (ImageView) this.mRootView.findViewById(C4048R.id.ugc_map_main_more_feedback_iv_bg);
                this.newPositionIVBg = (ImageView) this.mRootView.findViewById(C4048R.id.ugc_map_main_new_position_iv_bg);
                this.errPositionIVBg = (ImageView) this.mRootView.findViewById(C4048R.id.ugc_map_main_err_position_iv_bg);
                this.newPositionTV = (TextView) this.mRootView.findViewById(C4048R.id.ugc_map_main_new_position_tv);
                this.errPositionTV = (TextView) this.mRootView.findViewById(C4048R.id.ugc_map_main_err_position_tv);
                this.moreFeedbackTV = (TextView) this.mRootView.findViewById(C4048R.id.ugc_map_main_more_feedback_tv);
                this.mSubItemFrame = this.mRootView.findViewById(C4048R.id.ugc_map_main_subitem_frame);
                this.mSubItemFrame.setOnClickListener(this);
                this.mSubItemLv = (ListView) this.mRootView.findViewById(C4048R.id.ugc_map_main_subitem_listview);
                ((TextView) this.mRootView.findViewById(C4048R.id.subitem_cancel)).setOnClickListener(this);
                this.mSubItemLv.setDivider(null);
                this.mSubItemLv.setDividerHeight(0);
                this.subItemAdapter = new SubItemAdapter(this.mContext, createSubItemString(1));
                this.mSubItemLv.setAdapter(this.subItemAdapter);
                this.mSubItemLv.setOnItemClickListener(new C42071());
            }
        }
    }

    private ArrayList<UgcBaseDataModel> createSubItemString(int type) {
        if (this.feedBackList != null && this.feedBackList.size() > 0) {
            this.listItem.clear();
            switch (type) {
                case 1:
                    this.listItem.addAll(((UgcBaseDataModel) this.feedBackList.get(0)).ugcSubDataSec);
                    break;
                case 2:
                    this.listItem.addAll(((UgcBaseDataModel) this.feedBackList.get(1)).ugcSubDataSec);
                    break;
            }
        }
        return this.listItem;
    }

    public android.view.View getParentView() {
        return this.mRootView;
    }

    public void reMeasureLayout() {
    }

    public void setPresenter(Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void onClick(android.view.View v) {
        if (this.mPresenter != null) {
            int type;
            switch (v.getId()) {
                case C4048R.id.ugc_map_main_new_position_iv /*1711867104*/:
                case C4048R.id.ugc_map_main_new_position_iv_bg /*1711867105*/:
                    if (this.mSubItemFrame != null) {
                        type = getFeedBackType(0);
                        createSubItemString(type);
                        this.subItemAdapter.setItemType(type);
                        this.subItemAdapter.notifyDataSetChanged();
                        this.mSubItemFrame.setVisibility(0);
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_4_1, "1", type + "", null);
                        return;
                    }
                    return;
                case C4048R.id.ugc_map_main_err_position_iv /*1711867108*/:
                case C4048R.id.ugc_map_main_err_position_iv_bg /*1711867109*/:
                    if (this.mSubItemFrame != null) {
                        type = getFeedBackType(1);
                        createSubItemString(type);
                        this.subItemAdapter.setItemType(type);
                        this.subItemAdapter.notifyDataSetChanged();
                        this.mSubItemFrame.setVisibility(0);
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_4_1, "1", type + "", null);
                        return;
                    }
                    return;
                case C4048R.id.ugc_map_main_more_feedback_iv /*1711867112*/:
                case C4048R.id.ugc_map_main_more_feedback_iv_bg /*1711867113*/:
                    UgcBaseDataModel dataModel = (UgcBaseDataModel) v.getTag();
                    if (dataModel != null) {
                        this.mPresenter.gotoUgcMapApi(dataModel.link);
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_4_1, "1", getFeedBackType(2) + "", null);
                        return;
                    }
                    return;
                case C4048R.id.ugc_map_main_check_detail_tv /*1711867116*/:
                    if (this.mPresenter == null) {
                        return;
                    }
                    if (this.hasHelpTv.getVisibility() == 0) {
                        this.mPresenter.performCheckDetailBtn();
                        return;
                    } else {
                        this.mPresenter.informUserToRegister();
                        return;
                    }
                case C4048R.id.ugc_map_main_subitem_frame /*1711867118*/:
                case C4048R.id.subitem_cancel /*1711867121*/:
                    if (this.mSubItemFrame != null) {
                        this.mSubItemFrame.setVisibility(8);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private int getFeedBackType(int pos) {
        if (this.feedBackList == null || pos >= this.feedBackList.size()) {
            return -1;
        }
        return ((UgcBaseDataModel) this.feedBackList.get(pos)).type;
    }

    public boolean onBackPress() {
        return false;
    }

    public void onDestroy() {
    }

    public void showUserUploadCounts(int count) {
        setUserInfoLayoutvisibile(true);
        if (this.checkDetailTv != null && this.hasHelpTv != null) {
            this.hasHelpTv.setVisibility(0);
            this.checkDetailTv.setVisibility(0);
            this.checkDetailTv.setText("点击查看详情>");
            this.hasHelpTv.setText(Html.fromHtml("您已上报<font color=\"#3385ff\"> " + count + " </font>次"));
        }
    }

    public void showUserUnRegister() {
        setUserInfoLayoutvisibile(true);
        if (this.checkDetailTv != null) {
            this.checkDetailTv.setVisibility(0);
            this.checkDetailTv.setText("登录查看上报");
        }
        if (this.hasHelpTv != null) {
            this.hasHelpTv.setVisibility(8);
        }
    }
}
