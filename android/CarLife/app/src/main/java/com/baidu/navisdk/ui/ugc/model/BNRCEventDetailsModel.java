package com.baidu.navisdk.ui.ugc.model;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONObject;

public class BNRCEventDetailsModel
{
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
  private long eventIdPlainText = 0L;
  private String eventPic = null;
  private String eventPosition = null;
  private String[] label = null;
  private long lastCommentId = 0L;
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
  
  public void addComments(ArrayList<Comment> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    if (this.commentsList == null) {
      this.commentsList = new ArrayList();
    }
    this.commentsList.addAll(paramArrayList);
    Comment localComment = (Comment)this.commentsList.get(this.commentsList.size() - 1);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("addComments: last --> ");
    if (localComment != null) {}
    for (paramArrayList = localComment.toString();; paramArrayList = localComment)
    {
      LogUtil.e(str, paramArrayList);
      if (localComment == null) {
        break;
      }
      this.lastCommentId = localComment.id;
      return;
    }
  }
  
  public void clearData()
  {
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
    this.eventIdPlainText = 0L;
    this.mCommentsDataBuild = null;
    if (this.commentsList != null)
    {
      this.commentsList.clear();
      this.commentsList = null;
    }
    this.lastCommentId = 0L;
  }
  
  public String getAwayFrom()
  {
    return this.awayFrom;
  }
  
  public ArrayList<Comment> getComments()
  {
    return this.commentsList;
  }
  
  public CommentsDataBuild getCommentsDataBuild()
  {
    return this.mCommentsDataBuild;
  }
  
  public int getCommentsLength()
  {
    if (this.commentsList == null) {
      return 0;
    }
    return this.commentsList.size();
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public long getEventIdPlainText()
  {
    return this.eventIdPlainText;
  }
  
  public String getEventPic()
  {
    return this.eventPic;
  }
  
  public String getEventPosition()
  {
    return this.eventPosition;
  }
  
  public String[] getLabel()
  {
    return this.label;
  }
  
  public long getLastCommentId()
  {
    return this.lastCommentId;
  }
  
  public String getMisc()
  {
    return this.misc;
  }
  
  public OutlineDataBuild getOutlineDataBuild()
  {
    return this.mOutlineDataBuild;
  }
  
  public String getRoadName()
  {
    return this.roadName;
  }
  
  public String getShowTime()
  {
    return this.showTime;
  }
  
  public String getTimeInterval()
  {
    return this.timeInterval;
  }
  
  public int getUseful()
  {
    return this.useful;
  }
  
  public int getUseless()
  {
    return this.useless;
  }
  
  public String getUser()
  {
    return this.user;
  }
  
  public String getUserReport()
  {
    return this.userReport;
  }
  
  public int getVoted()
  {
    return this.voted;
  }
  
  public String geteIcon()
  {
    return this.eIcon;
  }
  
  public String geteTitle()
  {
    return this.eTitle;
  }
  
  public int geteType()
  {
    return this.eType;
  }
  
  public boolean isFirstPageDataLoaded()
  {
    return this.lastCommentId == 0L;
  }
  
  public void setAwayFrom(String paramString)
  {
    this.awayFrom = paramString;
  }
  
  public void setCommentsDataBuild(CommentsDataBuild paramCommentsDataBuild)
  {
    this.mCommentsDataBuild = paramCommentsDataBuild;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setEventIdPlainText(long paramLong)
  {
    this.eventIdPlainText = paramLong;
  }
  
  public void setEventPic(String paramString)
  {
    this.eventPic = paramString;
  }
  
  public void setEventPosition(String paramString)
  {
    this.eventPosition = paramString;
  }
  
  public void setLabel(String[] paramArrayOfString)
  {
    this.label = paramArrayOfString;
  }
  
  public void setLastCommentId(long paramLong)
  {
    this.lastCommentId = paramLong;
  }
  
  public void setMisc(String paramString)
  {
    this.misc = paramString;
  }
  
  public void setOutlineDataBuild(OutlineDataBuild paramOutlineDataBuild)
  {
    this.mOutlineDataBuild = paramOutlineDataBuild;
  }
  
  public void setRoadName(String paramString)
  {
    this.roadName = paramString;
  }
  
  public void setShowTime(String paramString)
  {
    this.showTime = paramString;
  }
  
  public void setTimeInterval(String paramString)
  {
    this.timeInterval = paramString;
  }
  
  public void setUseful(int paramInt)
  {
    this.useful = paramInt;
  }
  
  public void setUseless(int paramInt)
  {
    this.useless = paramInt;
  }
  
  public void setUser(String paramString)
  {
    this.user = paramString;
  }
  
  public void setUserReport(String paramString)
  {
    this.userReport = paramString;
  }
  
  public void setVoted(int paramInt)
  {
    this.voted = paramInt;
  }
  
  public void seteIcon(String paramString)
  {
    this.eIcon = paramString;
  }
  
  public void seteTitle(String paramString)
  {
    this.eTitle = paramString;
  }
  
  public void seteType(int paramInt)
  {
    this.eType = paramInt;
  }
  
  public static class Comment
  {
    public String content;
    public long id;
    public String[] labels;
    public String picUrl;
    public String showTime;
    public String user;
    
    public String toString()
    {
      return "showTime: " + this.showTime + ", user: " + this.user + ", picUrl: " + this.picUrl + ", content: " + this.content + ", labels: " + this.labels + ", id: " + this.id;
    }
  }
  
  public static class CommentsDataBuild
  {
    private JSONObject mJsonObj = null;
    
    public JSONObject getMJsonObj()
    {
      return this.mJsonObj;
    }
    
    public void setMJsonObj(JSONObject paramJSONObject)
    {
      this.mJsonObj = paramJSONObject;
    }
  }
  
  public static class OutlineDataBuild
  {
    private boolean isShowZoomView = false;
    private JSONObject mJsonObj = null;
    private int votedIndex = 0;
    
    public boolean getIsShowZoomView()
    {
      return this.isShowZoomView;
    }
    
    public JSONObject getMJsonObj()
    {
      return this.mJsonObj;
    }
    
    public int getVotedIndex()
    {
      return this.votedIndex;
    }
    
    public void setIsShowZoomView(boolean paramBoolean)
    {
      this.isShowZoomView = paramBoolean;
    }
    
    public void setMJsonObj(JSONObject paramJSONObject)
    {
      this.mJsonObj = paramJSONObject;
    }
    
    public void setVotedIndex(int paramInt)
    {
      this.votedIndex = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/ugc/model/BNRCEventDetailsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */