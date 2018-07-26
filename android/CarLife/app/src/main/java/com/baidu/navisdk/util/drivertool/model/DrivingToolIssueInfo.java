package com.baidu.navisdk.util.drivertool.model;

public class DrivingToolIssueInfo extends IssueBasicInfo {
    public String mBduss = null;
    public String mExtendInfo = null;
    public String mIssueDescrption = null;
    public String mIssueID = null;
    public String mIssueLocation = null;
    public String mIssueStatus;
    public String mIssueTime = null;
    public String mIssueType = null;
    public String mPersonReliableID = null;
    public String mSessionID = null;
    public String mStoreType = null;

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("task_id= ");
        buf.append(this.mTaskID);
        buf.append(" route_id=");
        buf.append(this.mRouteID);
        buf.append(" problem_id=");
        buf.append(this.mIssueID);
        buf.append(" problem_describe=");
        buf.append(this.mIssueDescrption);
        buf.append(" problem_type=");
        buf.append(this.mIssueType);
        buf.append(" person_liable=");
        buf.append(this.mPersonReliableID);
        buf.append(" status=");
        buf.append(this.mIssueStatus);
        buf.append(" extends_info=");
        buf.append(this.mExtendInfo);
        buf.append(" problem_poi=");
        buf.append(this.mIssueLocation);
        buf.append(" problem_time=");
        buf.append(this.mIssueTime);
        buf.append(" bduss=");
        buf.append(this.mBduss);
        buf.append(" cuid=");
        buf.append(this.mCuid);
        buf.append(" session_id=");
        buf.append(this.mSessionID);
        return buf.toString();
    }
}
