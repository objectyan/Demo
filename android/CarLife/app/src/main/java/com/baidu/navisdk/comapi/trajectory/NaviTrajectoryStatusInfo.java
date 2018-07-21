package com.baidu.navisdk.comapi.trajectory;

public class NaviTrajectoryStatusInfo
{
  public int mBrakeCnt = 0;
  public int mCurveCnt = 0;
  public int mOverSpeedCnt = 0;
  public int mRapidAccCnt = 0;
  public boolean mShowFlag = false;
  
  public String toString()
  {
    return "mOverSpeedCnt:" + this.mOverSpeedCnt + ", mRapidAccCnt:" + this.mRapidAccCnt + ", mBrakeCnt:" + this.mBrakeCnt + ", mCurveCnt:" + this.mCurveCnt + ",mShowFlag:" + this.mShowFlag;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/trajectory/NaviTrajectoryStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */