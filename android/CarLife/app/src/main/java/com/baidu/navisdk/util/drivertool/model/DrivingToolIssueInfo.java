package com.baidu.navisdk.util.drivertool.model;

public class DrivingToolIssueInfo
  extends IssueBasicInfo
{
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
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("task_id= ");
    localStringBuffer.append(this.mTaskID);
    localStringBuffer.append(" route_id=");
    localStringBuffer.append(this.mRouteID);
    localStringBuffer.append(" problem_id=");
    localStringBuffer.append(this.mIssueID);
    localStringBuffer.append(" problem_describe=");
    localStringBuffer.append(this.mIssueDescrption);
    localStringBuffer.append(" problem_type=");
    localStringBuffer.append(this.mIssueType);
    localStringBuffer.append(" person_liable=");
    localStringBuffer.append(this.mPersonReliableID);
    localStringBuffer.append(" status=");
    localStringBuffer.append(this.mIssueStatus);
    localStringBuffer.append(" extends_info=");
    localStringBuffer.append(this.mExtendInfo);
    localStringBuffer.append(" problem_poi=");
    localStringBuffer.append(this.mIssueLocation);
    localStringBuffer.append(" problem_time=");
    localStringBuffer.append(this.mIssueTime);
    localStringBuffer.append(" bduss=");
    localStringBuffer.append(this.mBduss);
    localStringBuffer.append(" cuid=");
    localStringBuffer.append(this.mCuid);
    localStringBuffer.append(" session_id=");
    localStringBuffer.append(this.mSessionID);
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */