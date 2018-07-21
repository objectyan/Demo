package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import com.baidu.carlife.core.a;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;

public class TrackModifyShop
{
  private static final String TAG = TrackModifyShop.class.getSimpleName();
  
  public void updateNotLoginTracksBduis(String paramString)
  {
    a locala = a.a();
    Intent localIntent = new Intent(locala, DataService.class);
    localIntent.putExtra("bduid", paramString);
    localIntent.setAction(DataService.Action.ACTION_UPDATE_NOT_LOGIN_TRAKS_BDUID.toString());
    locala.startService(localIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/TrackModifyShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */