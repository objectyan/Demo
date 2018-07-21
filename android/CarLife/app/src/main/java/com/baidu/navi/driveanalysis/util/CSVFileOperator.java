package com.baidu.navi.driveanalysis.util;

import com.baidu.navi.driveanalysis.model.TrackModel;
import java.io.File;
import java.util.List;

public class CSVFileOperator
{
  private static final int MAX_COLUMN = 9;
  
  public static void write(List<TrackModel> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    CSVUtils.exportCsv(paramString, paramList);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/util/CSVFileOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */