package com.baidu.navisdk.ui.ugc.model;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONObject;

public class BNRCEventDetailsModel {
    public static final String BN_RC_KEY_AWAY_FROM = "away_from";
    public static final String BN_RC_KEY_BDUSS = "bduss";
    public static final String BN_RC_KEY_COMMENT_ID = "comment_id";
    public static final String BN_RC_KEY_CONTENT = "content";
    public static final String BN_RC_KEY_CUID = "cuid";
    public static final String BN_RC_KEY_EVENT_HELP = "event_help";
    public static final String BN_RC_KEY_EVENT_ID = "event_id";
    public static final String BN_RC_KEY_EVENT_PIC = "event_pic";
    public static final String BN_RC_KEY_EVENT_POSITION = "event_postion";
    public static final String BN_RC_KEY_E_ICON = "e_icon";
    public static final String BN_RC_KEY_E_TITLE = "e_title";
    public static final String BN_RC_KEY_E_TYPE = "e_type";
    public static final String BN_RC_KEY_LABEL = "label";
    public static final String BN_RC_KEY_MISC = "misc";
    public static final String BN_RC_KEY_OS = "os";
    public static final String BN_RC_KEY_OSV = "osv";
    public static final String BN_RC_KEY_POTAIT = "portrait";
    public static final String BN_RC_KEY_ROAD_NAME = "road_name";
    public static final String BN_RC_KEY_SHOW_TIME = "show_time";
    public static final String BN_RC_KEY_SID = "sid";
    public static final String BN_RC_KEY_SIGN = "sign";
    public static final String BN_RC_KEY_ST = "st";
    public static final String BN_RC_KEY_SV = "sv";
    public static final String BN_RC_KEY_TIME_INTERVAL = "time_interval";
    public static final String BN_RC_KEY_USEFUL = "useful";
    public static final String BN_RC_KEY_USELESS = "useless";
    public static final String BN_RC_KEY_USER = "user";
    public static final String BN_RC_KEY_USER_LEVEL = "user_level";
    public static final String BN_RC_KEY_USER_LINK = "user_link";
    public static final String BN_RC_KEY_USER_REPORT = "user_report";
    public static final String BN_RC_KEY_VOTED = "voted";
    public static final String BN_RC_KEY_VOTE_POINT = "point";
    public static final String BN_RC_KEY_VOTE_TYPE = "vote_type";
    private static final String TAG = BNRCEventDetailsModel.class.getSimpleName();
    public static final int VOTED_STATE_NON = 0;
    public static final int VOTED_STATE_USEFUL = 1;
    public static final int VOTED_STATE_USELESS = 2;
    private String awayFrom = null;
    private ArrayList<Comment> commentsList = null;
    private String content = null;
    private String eIcon = null;
    private String eTitle = null;
    private int eType = 0;
    private long eventIdPlainText = 0;
    private String eventPic = null;
    private String eventPosition = null;
    private String[] label = null;
    private long lastCommentId = 0;
    private CommentsDataBuild mCommentsDataBuild = null;
    private OutlineDataBuild mOutlineDataBuild = null;
    private String misc = null;
    private String roadName = null;
    private String showTime = null;
    private String timeInterval = null;
    private int useful = 0;
    private int useless = 0;
    private String user = null;
    private String userReport = null;
    private int voted = 0;

    public static class Comment {
        public String content;
        public long id;
        public String[] labels;
        public String picUrl;
        public String showTime;
        public String user;

        public String toString() {
            return "showTime: " + this.showTime + ", user: " + this.user + ", picUrl: " + this.picUrl + ", content: " + this.content + ", labels: " + this.labels + ", id: " + this.id;
        }
    }

    public static class CommentsDataBuild {
        private JSONObject mJsonObj = null;

        public void setMJsonObj(JSONObject mJsonObj) {
            this.mJsonObj = mJsonObj;
        }

        public JSONObject getMJsonObj() {
            return this.mJsonObj;
        }
    }

    public static class OutlineDataBuild {
        private boolean isShowZoomView = false;
        private JSONObject mJsonObj = null;
        private int votedIndex = 0;

        public void setMJsonObj(JSONObject mJsonObj) {
            this.mJsonObj = mJsonObj;
        }

        public void setIsShowZoomView(boolean isShowZoomView) {
            this.isShowZoomView = isShowZoomView;
        }

        public int getVotedIndex() {
            return this.votedIndex;
        }

        public void setVotedIndex(int index) {
            this.votedIndex = index;
        }

        public JSONObject getMJsonObj() {
            return this.mJsonObj;
        }

        public boolean getIsShowZoomView() {
            return this.isShowZoomView;
        }
    }

    public void clearData() {
        this.mOutlineDataBuild = null;
        this.eType = 0;
        this.eIcon = null;
        this.eTitle = null;
        this.showTime = null;
        this.eventPosition = null;
        this.eventPic = null;
        this.misc = null;
        this.user = null;
        this.useful = 0;
        this.useless = 0;
        this.voted = 0;
        this.userReport = null;
        this.eventIdPlainText = 0;
        this.mCommentsDataBuild = null;
        if (this.commentsList != null) {
            this.commentsList.clear();
            this.commentsList = null;
        }
        this.lastCommentId = 0;
    }

    public void addComments(ArrayList<Comment> comments) {
        if (comments != null && comments.size() != 0) {
            Object comment;
            if (this.commentsList == null) {
                this.commentsList = new ArrayList();
            }
            this.commentsList.addAll(comments);
            Comment last = (Comment) this.commentsList.get(this.commentsList.size() - 1);
            String str = TAG;
            StringBuilder append = new StringBuilder().append("addComments: last --> ");
            if (last != null) {
                comment = last.toString();
            } else {
                Comment comment2 = last;
            }
            LogUtil.m15791e(str, append.append(comment).toString());
            if (last != null) {
                this.lastCommentId = last.id;
            }
        }
    }

    public int getCommentsLength() {
        if (this.commentsList == null) {
            return 0;
        }
        return this.commentsList.size();
    }

    public boolean isFirstPageDataLoaded() {
        return this.lastCommentId == 0;
    }

    public ArrayList<Comment> getComments() {
        return this.commentsList;
    }

    public String getAwayFrom() {
        return this.awayFrom;
    }

    public void setAwayFrom(String awayFrom) {
        this.awayFrom = awayFrom;
    }

    public String getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String[] getLabel() {
        return this.label;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    public String getUserReport() {
        return this.userReport;
    }

    public void setUserReport(String userReport) {
        this.userReport = userReport;
    }

    public int geteType() {
        return this.eType;
    }

    public void seteType(int eType) {
        this.eType = eType;
    }

    public String geteIcon() {
        return this.eIcon;
    }

    public void seteIcon(String eIcon) {
        this.eIcon = eIcon;
    }

    public String geteTitle() {
        return this.eTitle;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle;
    }

    public String getShowTime() {
        return this.showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getEventPosition() {
        return this.eventPosition;
    }

    public void setEventPosition(String eventPosition) {
        this.eventPosition = eventPosition;
    }

    public String getEventPic() {
        return this.eventPic;
    }

    public void setEventPic(String eventPic) {
        this.eventPic = eventPic;
    }

    public String getMisc() {
        return this.misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getUseful() {
        return this.useful;
    }

    public void setUseful(int useful) {
        this.useful = useful;
    }

    public int getUseless() {
        return this.useless;
    }

    public void setUseless(int useless) {
        this.useless = useless;
    }

    public int getVoted() {
        return this.voted;
    }

    public void setVoted(int voted) {
        this.voted = voted;
    }

    public void setOutlineDataBuild(OutlineDataBuild mOutlineDataBuild) {
        this.mOutlineDataBuild = mOutlineDataBuild;
    }

    public OutlineDataBuild getOutlineDataBuild() {
        return this.mOutlineDataBuild;
    }

    public void setCommentsDataBuild(CommentsDataBuild commentsDataBuild) {
        this.mCommentsDataBuild = commentsDataBuild;
    }

    public CommentsDataBuild getCommentsDataBuild() {
        return this.mCommentsDataBuild;
    }

    public long getLastCommentId() {
        return this.lastCommentId;
    }

    public void setLastCommentId(long id) {
        this.lastCommentId = id;
    }

    public void setEventIdPlainText(long id) {
        this.eventIdPlainText = id;
    }

    public long getEventIdPlainText() {
        return this.eventIdPlainText;
    }
}
