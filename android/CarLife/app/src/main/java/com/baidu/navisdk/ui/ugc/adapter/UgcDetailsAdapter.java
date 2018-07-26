package com.baidu.navisdk.ui.ugc.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel.Comment;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class UgcDetailsAdapter extends PtrrvBaseAdapter<ViewHolder> {
    private static final int MAX_VIEW_TYPE = 5;
    private static final String TAG = UgcDetailsAdapter.class.getSimpleName();
    private static final int VIEWS_BEFORE_COMMENT = 3;
    private static final int VIEW_TYPE_COMMENT = 3;
    private static final int VIEW_TYPE_COMMENTS_HEADER = 2;
    private static final int VIEW_TYPE_LOADING_STATE = 1;
    private static final int VIEW_TYPE_NO_MORE_DATA_FOOTER = 4;
    private static final int VIEW_TYPE_OUTLINE = 0;
    private CommentsLoadingState commentsLoadingState = CommentsLoadingState.INVALID;
    private ArrayList<Comment> contentList;
    private ImgDisplay imgDisplay;
    private int loadingStateHeight;
    private Context mContext;
    private View outlineView;
    private boolean showNoMoreCommentsFooter = false;

    /* renamed from: com.baidu.navisdk.ui.ugc.adapter.UgcDetailsAdapter$1 */
    class C44911 implements OnClickListener {
        C44911() {
        }

        public void onClick(View v) {
            String url = (String) v.getTag();
            if (UgcDetailsAdapter.this.imgDisplay != null) {
                UgcDetailsAdapter.this.imgDisplay.showZoomedOutImg(true, url);
            }
        }
    }

    public enum CommentsLoadingState {
        INVALID,
        LOADING,
        LOADED_NO_DATA,
        LOADED_HAS_DATA
    }

    public interface ImgDisplay {
        void showZoomedOutImg(boolean z, String str);
    }

    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        private ViewGroup commentsLoadingContainer;
        private ImageView ivThumbnail;
        private View noCommentsPrompt;
        private TextView tvDescription;
        private TextView tvLabel1;
        private TextView tvLabel2;
        private TextView tvReporter;
        private TextView tvTimeStamp;
        private View vLabelDivider;
        private View vLabels;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType) {
                case 1:
                    this.commentsLoadingContainer = (ViewGroup) itemView.findViewById(C4048R.id.comments_loading_container);
                    this.noCommentsPrompt = itemView.findViewById(C4048R.id.no_comments_prompt);
                    return;
                case 3:
                    this.tvReporter = (TextView) itemView.findViewById(C4048R.id.tv_reporter);
                    this.tvTimeStamp = (TextView) itemView.findViewById(C4048R.id.tv_time_stamp);
                    this.ivThumbnail = (ImageView) itemView.findViewById(C4048R.id.img_thumbnail);
                    this.vLabels = itemView.findViewById(C4048R.id.tv_event_sub_layout);
                    this.tvLabel1 = (TextView) itemView.findViewById(C4048R.id.tv_event_sub_type1);
                    this.tvLabel2 = (TextView) itemView.findViewById(C4048R.id.tv_event_sub_type2);
                    this.vLabelDivider = itemView.findViewById(C4048R.id.label_divider);
                    this.tvDescription = (TextView) itemView.findViewById(C4048R.id.tv_event_description);
                    return;
                default:
                    return;
            }
        }
    }

    public UgcDetailsAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    public void setData(ArrayList<Comment> ugcCommentList) {
        if (ugcCommentList != null) {
            this.contentList = ugcCommentList;
        }
    }

    public void setShowNoMoreCommentsFooter(boolean showNoMoreCommentsFooter) {
        this.showNoMoreCommentsFooter = showNoMoreCommentsFooter;
        LogUtil.m15791e(TAG, "setShowNoMoreCommentsFooter: showNoMoreCommentsFooter --> " + showNoMoreCommentsFooter);
    }

    public void setCommentsLoadingState(CommentsLoadingState commentsLoadingState) {
        this.commentsLoadingState = commentsLoadingState;
        LogUtil.m15791e(TAG, "setCommentsLoadingState: commentsLoadingState --> " + commentsLoadingState);
    }

    public void setImgDisplay(ImgDisplay imgDisplay) {
        this.imgDisplay = imgDisplay;
    }

    public void setOutlineView(View outlineView) {
        this.outlineView = outlineView;
    }

    public void setLoadingStateHeight(int loadingStateHeight) {
        this.loadingStateHeight = loadingStateHeight;
    }

    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        }
        if (position == 2) {
            return 2;
        }
        if (position == getItemCount() - 1) {
            return 4;
        }
        return 3;
    }

    public int getItemCount() {
        if (this.contentList == null) {
            return 4;
        }
        return (this.contentList.size() + 5) - 1;
    }

    public Comment getItem(int position) {
        if (this.contentList == null) {
            return null;
        }
        return (Comment) this.contentList.get(position);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new ViewHolder(this.outlineView, viewType);
            case 1:
                return new ViewHolder(JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_ugc_detail_loading_container, null), viewType);
            case 2:
                return new ViewHolder(JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_ugc_detail_comments_header, null), viewType);
            case 4:
                return new ViewHolder(JarUtils.inflate((Activity) this.mContext, C4048R.layout.ugc_comments_ptr_footer_no_more_data, null), viewType);
            default:
                return new ViewHolder(JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_ugc_detail_list_row_item, null), viewType);
        }
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 1:
                switch (this.commentsLoadingState) {
                    case LOADING:
                        int height = -2;
                        if (this.loadingStateHeight > 0) {
                            height = this.loadingStateHeight;
                        }
                        holder.itemView.setLayoutParams(new LayoutParams(-1, height));
                        holder.commentsLoadingContainer.setVisibility(0);
                        holder.noCommentsPrompt.setVisibility(8);
                        holder.commentsLoadingContainer.removeAllViews();
                        View loading = null;
                        if (BNRCEventDetailsViewController.getInstance().getLoadingProxy() != null) {
                            loading = BNRCEventDetailsViewController.getInstance().getLoadingProxy().getLoadingView();
                        }
                        if (loading != null) {
                            if (loading.getParent() != null && (loading.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) loading.getParent()).removeView(loading);
                            }
                            holder.commentsLoadingContainer.addView(loading, new LayoutParams(-1, -1));
                            return;
                        }
                        return;
                    case LOADED_NO_DATA:
                        int height1 = -2;
                        if (this.loadingStateHeight > 0) {
                            height1 = this.loadingStateHeight;
                        }
                        holder.itemView.setLayoutParams(new LayoutParams(-1, height1));
                        holder.commentsLoadingContainer.setVisibility(8);
                        holder.noCommentsPrompt.setVisibility(0);
                        return;
                    default:
                        holder.itemView.setLayoutParams(new LayoutParams(-1, -2));
                        holder.commentsLoadingContainer.setVisibility(8);
                        holder.noCommentsPrompt.setVisibility(8);
                        return;
                }
            case 2:
                if (this.commentsLoadingState == CommentsLoadingState.LOADED_HAS_DATA) {
                    holder.itemView.setLayoutParams(new LayoutParams(-1, -2));
                    holder.itemView.setVisibility(0);
                    return;
                }
                holder.itemView.setLayoutParams(new LayoutParams(-1, 1));
                holder.itemView.setVisibility(8);
                return;
            case 3:
                holder.itemView.setLayoutParams(new LayoutParams(-1, -2));
                Comment comment = getItem(position - 3);
                if (comment != null) {
                    holder.tvReporter.setText(comment.user == null ? "" : comment.user);
                    holder.tvTimeStamp.setText(comment.showTime == null ? "" : comment.showTime);
                    boolean labelsShow;
                    if (comment.labels == null || comment.labels.length == 0) {
                        labelsShow = false;
                        holder.vLabels.setVisibility(8);
                    } else {
                        labelsShow = true;
                        holder.vLabels.setVisibility(0);
                        if (comment.labels.length == 1) {
                            if (!(holder.tvLabel1 == null || holder.tvLabel2 == null)) {
                                holder.tvLabel1.setText(comment.labels[0]);
                                holder.tvLabel2.setVisibility(8);
                                holder.tvLabel1.setVisibility(0);
                            }
                        } else if (!(comment.labels.length != 2 || holder.tvLabel1 == null || holder.tvLabel2 == null)) {
                            holder.tvLabel1.setText(comment.labels[0]);
                            holder.tvLabel2.setText(comment.labels[1]);
                            holder.tvLabel2.setVisibility(0);
                            holder.tvLabel1.setVisibility(0);
                        }
                    }
                    if (TextUtils.isEmpty(comment.picUrl)) {
                        holder.ivThumbnail.setVisibility(8);
                    } else {
                        holder.ivThumbnail.setClickable(false);
                        showPic(comment, holder);
                        holder.ivThumbnail.setVisibility(0);
                        holder.ivThumbnail.setTag(comment.picUrl);
                        holder.ivThumbnail.setOnClickListener(new C44911());
                    }
                    holder.tvDescription.setText(comment.content == null ? "" : comment.content);
                    if (comment.content == null || !labelsShow) {
                        holder.vLabelDivider.setVisibility(8);
                        return;
                    } else {
                        holder.vLabelDivider.setVisibility(0);
                        return;
                    }
                }
                return;
            case 4:
                if (this.showNoMoreCommentsFooter) {
                    holder.itemView.setLayoutParams(new LayoutParams(-1, -2));
                    holder.itemView.findViewById(C4048R.id.no_more_comments_container).setVisibility(0);
                    holder.itemView.findViewById(C4048R.id.no_more_comments).setVisibility(0);
                    return;
                }
                holder.itemView.findViewById(C4048R.id.no_more_comments_container).setVisibility(8);
                holder.itemView.findViewById(C4048R.id.no_more_comments).setVisibility(8);
                return;
            default:
                return;
        }
    }

    private void showPic(Comment comment, final ViewHolder holder) {
        UrlDrawableContainIView.getDrawable(comment.picUrl, C4048R.drawable.nsdk_rc_img_default_bg, holder.ivThumbnail, new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 8192 && holder.ivThumbnail != null) {
                    if (msg.arg1 == 0) {
                        holder.ivThumbnail.setClickable(true);
                    } else {
                        holder.ivThumbnail.setClickable(false);
                    }
                }
            }
        });
    }
}
