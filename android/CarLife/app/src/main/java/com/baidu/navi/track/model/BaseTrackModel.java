package com.baidu.navi.track.model;

public class BaseTrackModel
{
  public int ctime;
  public String guid;
  public int modifyTime;
  public String sid;
  public int syncState;
  public String type;
  public String useId;
  
  public String toString()
  {
    return "BaseTrackModel [sid =" + this.sid + ", guid=" + this.guid + ", type=" + this.type + ", ctime=" + this.ctime + ", modifyTime=" + this.modifyTime + ", syncState=" + this.syncState + ", useId=" + this.useId + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/model/BaseTrackModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */