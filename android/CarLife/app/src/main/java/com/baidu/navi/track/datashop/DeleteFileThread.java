package com.baidu.navi.track.datashop;

import com.baidu.navi.track.util.TrackNaviCsvFileUtil;
import java.util.List;

public class DeleteFileThread
  extends Thread
{
  private List<String> listGuid;
  
  public DeleteFileThread(List<String> paramList)
  {
    this.listGuid = paramList;
  }
  
  public void run()
  {
    if (this.listGuid == null) {}
    for (;;)
    {
      return;
      int j = this.listGuid.size();
      int i = 0;
      while (i < j)
      {
        TrackNaviCsvFileUtil.deleteGuidsFile((String)this.listGuid.get(i));
        TrackNaviCsvFileUtil.deleteGuidsFile((String)this.listGuid.get(i) + "_rp");
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/DeleteFileThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */