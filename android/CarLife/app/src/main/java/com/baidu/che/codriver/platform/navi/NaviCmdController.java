package com.baidu.che.codriver.platform.navi;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.che.codriver.h.d;
import com.baidu.che.codriver.platform.NaviCmdData;
import com.baidu.che.codriver.platform.NaviParse;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.e;
import com.baidu.che.codriver.util.f;
import com.baidu.che.codriver.util.h;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviCmdController
{
  private static final String COMMPANY_ADDRESS_FILE = "commpany_address_file";
  private static final String HOME_ADDRESS_FILE = "home_address_file";
  public static final String TAG = "NaviCmdController";
  private static NaviCmdController mInstance;
  private NaviAddressData mCommpanyAddress = null;
  private NaviState mCurrentState = new NaviState();
  private Gson mGson = new Gson();
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private NaviAddressData mHomeAddress = null;
  private boolean mIsNaviFront = false;
  private HashMap<String, String> mMapControlRequestMap = new HashMap();
  
  public static NaviCmdController getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new NaviCmdController();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void handleCruiseResponse(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = (String)this.mMapControlRequestMap.get(paramString1);
    if (paramString1 == null) {
      return;
    }
    localObject = null;
    for (;;)
    {
      try
      {
        str = new JSONObject(paramString1).getString("event");
        boolean bool = "open".equals(str);
        if (!bool) {
          continue;
        }
        if (paramInt != 0) {
          continue;
        }
        paramString1 = (String)localObject;
      }
      catch (JSONException paramString1)
      {
        String str;
        paramString1.printStackTrace();
        paramString1 = (String)localObject;
        continue;
      }
      if (paramString1 == null) {
        break;
      }
      d.a().a(paramString1);
      return;
      if (paramInt == 4)
      {
        paramString1 = paramString2;
      }
      else
      {
        paramString1 = c.a().getString(2131297700);
        continue;
        paramString1 = (String)localObject;
        if ("close".equals(str)) {
          if (paramInt == 0) {
            paramString1 = c.a().getString(2131297698);
          } else {
            paramString1 = c.a().getString(2131297699);
          }
        }
      }
    }
  }
  
  private void handleDialogCancel(String paramString)
  {
    this.mCurrentState.notifyCancelDialog(paramString);
  }
  
  private void handleDialogResponse(String paramString)
  {
    this.mCurrentState.handleDialogResponse(paramString);
  }
  
  private void handleDialogShow(String paramString)
  {
    this.mCurrentState.notifyShowDialog(paramString);
  }
  
  private void handleMapControlReceive(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = null;
    paramString1 = (String)this.mMapControlRequestMap.get(paramString1);
    int j = -1;
    int i = j;
    if (paramString1 != null) {}
    Resources localResources;
    try
    {
      i = new JSONObject(paramString1).optInt("order", -1);
      localResources = c.a().getResources();
      switch (i)
      {
      default: 
        paramString1 = (String)localObject;
        d.a().a(paramString1);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    for (;;)
                    {
                      paramString1.printStackTrace();
                      i = j;
                      continue;
                      if (paramInt == 0)
                      {
                        if (Log.isLoggable("CoDriverVoice", 3)) {}
                        for (paramString1 = localResources.getString(2131297725);; paramString1 = localResources.getString(2131297726)) {
                          break;
                        }
                      }
                      paramString1 = (String)localObject;
                      if (paramInt == 4)
                      {
                        paramString1 = paramString2;
                        continue;
                        if (paramInt == 0)
                        {
                          if (Log.isLoggable("CoDriverVoice", 3)) {}
                          for (paramString1 = localResources.getString(2131297727);; paramString1 = localResources.getString(2131297728)) {
                            break;
                          }
                        }
                        paramString1 = (String)localObject;
                        if (paramInt == 4)
                        {
                          paramString1 = paramString2;
                          continue;
                          if (paramInt == 0)
                          {
                            if (Log.isLoggable("CoDriverVoice", 3)) {}
                            for (paramString1 = localResources.getString(2131297723);; paramString1 = localResources.getString(2131297724)) {
                              break;
                            }
                          }
                          paramString1 = (String)localObject;
                          if (paramInt == 4)
                          {
                            paramString1 = paramString2;
                            continue;
                            if (paramInt == 0)
                            {
                              if (Log.isLoggable("CoDriverVoice", 3)) {}
                              for (paramString1 = localResources.getString(2131297721);; paramString1 = localResources.getString(2131297722)) {
                                break;
                              }
                            }
                            paramString1 = (String)localObject;
                            if (paramInt == 4)
                            {
                              paramString1 = paramString2;
                              continue;
                              if (paramInt == 0)
                              {
                                if (Log.isLoggable("CoDriverVoice", 3)) {}
                                for (paramString1 = localResources.getString(2131297716);; paramString1 = localResources.getString(2131297717)) {
                                  break;
                                }
                              }
                              paramString1 = (String)localObject;
                              if (paramInt == 4)
                              {
                                paramString1 = localResources.getString(2131297718);
                                continue;
                                if (paramInt == 0)
                                {
                                  if (Log.isLoggable("CoDriverVoice", 3)) {}
                                  for (paramString1 = localResources.getString(2131297695);; paramString1 = localResources.getString(2131297696)) {
                                    break;
                                  }
                                }
                                paramString1 = (String)localObject;
                                if (paramInt == 4) {
                                  paramString1 = localResources.getString(2131297697);
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    if (paramInt == 0)
                    {
                      if (Log.isLoggable("CoDriverVoice", 3)) {}
                      for (paramString1 = localResources.getString(2131297715);; paramString1 = localResources.getString(2131297713)) {
                        break;
                      }
                    }
                    paramString1 = (String)localObject;
                  } while (paramInt != 4);
                  if (Log.isLoggable("CoDriverVoice", 3)) {}
                  for (paramString1 = localResources.getString(2131297714);; paramString1 = localResources.getString(2131297694)) {
                    break;
                  }
                  if (paramInt == 0)
                  {
                    if (Log.isLoggable("CoDriverVoice", 3)) {}
                    for (paramString1 = localResources.getString(2131297706);; paramString1 = localResources.getString(2131297713)) {
                      break;
                    }
                  }
                  paramString1 = (String)localObject;
                } while (paramInt != 4);
                if (Log.isLoggable("CoDriverVoice", 3)) {}
                for (paramString1 = localResources.getString(2131297705);; paramString1 = localResources.getString(2131297694)) {
                  break;
                }
                if (paramInt == 0)
                {
                  if (Log.isLoggable("CoDriverVoice", 3)) {}
                  for (paramString1 = localResources.getString(2131297712);; paramString1 = localResources.getString(2131297713)) {
                    break;
                  }
                }
                paramString1 = (String)localObject;
              } while (paramInt != 4);
              if (Log.isLoggable("CoDriverVoice", 3)) {}
              for (paramString1 = localResources.getString(2131297711);; paramString1 = localResources.getString(2131297694)) {
                break;
              }
              if (paramInt == 0)
              {
                if (Log.isLoggable("CoDriverVoice", 3)) {}
                for (paramString1 = localResources.getString(2131297702);; paramString1 = localResources.getString(2131297713)) {
                  break;
                }
              }
              paramString1 = (String)localObject;
            } while (paramInt != 4);
            if (Log.isLoggable("CoDriverVoice", 3)) {}
            for (paramString1 = localResources.getString(2131297701);; paramString1 = localResources.getString(2131297694)) {
              break;
            }
            if (paramInt == 0)
            {
              if (Log.isLoggable("CoDriverVoice", 3)) {}
              for (paramString1 = localResources.getString(2131297710);; paramString1 = localResources.getString(2131297713)) {
                break;
              }
            }
            paramString1 = (String)localObject;
          } while (paramInt != 4);
          if (Log.isLoggable("CoDriverVoice", 3)) {}
          for (paramString1 = localResources.getString(2131297709);; paramString1 = localResources.getString(2131297694)) {
            break;
          }
          if (paramInt == 0)
          {
            if (Log.isLoggable("CoDriverVoice", 3)) {}
            for (paramString1 = localResources.getString(2131297704);; paramString1 = localResources.getString(2131297713)) {
              break;
            }
          }
          paramString1 = (String)localObject;
        } while (paramInt != 4);
        if (Log.isLoggable("CoDriverVoice", 3)) {}
        for (paramString1 = localResources.getString(2131297703);; paramString1 = localResources.getString(2131297694)) {
          break;
        }
        if (paramInt == 0)
        {
          if (Log.isLoggable("CoDriverVoice", 3)) {}
          for (paramString1 = localResources.getString(2131297720);; paramString1 = localResources.getString(2131297713)) {
            break;
          }
        }
        paramString1 = (String)localObject;
      } while (paramInt != 4);
      if (!Log.isLoggable("CoDriverVoice", 3)) {}
    }
    for (paramString1 = localResources.getString(2131297719);; paramString1 = localResources.getString(2131297694)) {
      break;
    }
  }
  
  private void handleNaviAppState(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("is_innavi"))
      {
        if (paramString.getString("is_innavi").equals("true")) {
          this.mCurrentState.enter(NaviState.NaviAppState.STATE_NAVI);
        }
      }
      else if ((paramString.has("is_incruise")) && (paramString.getString("is_incruise").equals("true")))
      {
        this.mCurrentState.enter(NaviState.NaviAppState.STATE_CRUISE);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void handleNaviLimitSpeed(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("limsp");
      paramString = c.a().getString(2131297707) + i;
      d.a().a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = c.a().getString(2131297708);
      }
    }
  }
  
  private void handleNaviSet(String paramString, int paramInt)
  {
    paramString = (String)this.mMapControlRequestMap.get(paramString);
    if (paramString != null) {
      try
      {
        if (new JSONObject(paramString).optString("order", "").equals("type_reset_navi_bypreference"))
        {
          if (paramInt == 0)
          {
            this.mHandler.postDelayed(new Runnable()
            {
              public void run()
              {
                String str = c.a().getString(2131297731);
                d.a().a(str);
              }
            }, 1500L);
            return;
          }
          if (paramInt == 4)
          {
            paramString = c.a().getString(2131297730);
            d.a().a(paramString);
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void handleRouteDetail(String paramString)
  {
    this.mCurrentState.notifyRouteDetail(paramString);
  }
  
  private void handleStatusSyncRequest(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("event");
      if ("navi_front".equals(paramString))
      {
        this.mIsNaviFront = true;
        return;
      }
      if ("navi_background".equals(paramString))
      {
        this.mIsNaviFront = false;
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    if ("navi_app_launch".equals(paramString))
    {
      requestSyncAddress();
      return;
    }
    if ("navi_app_exit".equals(paramString))
    {
      this.mIsNaviFront = false;
      return;
    }
    if ("navi_start".equals(paramString))
    {
      this.mCurrentState.enter(NaviState.NaviAppState.STATE_NAVI);
      return;
    }
    if ("navi_end".equals(paramString))
    {
      this.mCurrentState.enter(NaviState.NaviAppState.STATE_NORMAL);
      return;
    }
    if ("cruise_start".equals(paramString))
    {
      this.mCurrentState.enter(NaviState.NaviAppState.STATE_CRUISE);
      return;
    }
    if ("cruise_end".equals(paramString)) {
      this.mCurrentState.enter(NaviState.NaviAppState.STATE_NORMAL);
    }
  }
  
  public void addMapControlRequest(String paramString1, String paramString2)
  {
    this.mMapControlRequestMap.put(paramString1, paramString2);
  }
  
  public void executeCmd(String paramString)
  {
    h.b("NaviCmdController", "executeCmd() cmdType = " + paramString);
    PlatformManager.getInstance().sendNaviCommand(paramString, Boolean.valueOf(true));
  }
  
  public void executeCmd(String paramString, Boolean paramBoolean)
  {
    h.b("NaviCmdController", "executeCmd() cmdType = " + paramString);
    PlatformManager.getInstance().sendNaviCommand(paramString, paramBoolean);
  }
  
  public void handleNaviAppAddress(String paramString)
  {
    Object localObject;
    try
    {
      h.b("NaviCmdController", "navi address is " + paramString);
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = new JSONObject(paramString).getString("data");
      localObject = (NaviAddressData)this.mGson.fromJson((String)localObject, NaviAddressData.class);
      if (((NaviAddressData)localObject).getType() == null) {
        return;
      }
      if ((!TextUtils.isEmpty(((NaviAddressData)localObject).getName())) && (!TextUtils.isEmpty(((NaviAddressData)localObject).getAddress())) && (!"0".equals(((NaviAddressData)localObject).getLat())) && (!"0".equals(((NaviAddressData)localObject).getLng()))) {
        break label188;
      }
      if (((NaviAddressData)localObject).getType().equals("office"))
      {
        setCommpanyAddress(null);
        writeAddress("office", "");
        return;
      }
    }
    catch (Exception paramString)
    {
      h.e("NaviCmdController", "parse address error");
      paramString.printStackTrace();
      return;
    }
    if (((NaviAddressData)localObject).getType().equals("home"))
    {
      setHomeAddress(null);
      writeAddress("home", "");
      return;
      label188:
      if (((NaviAddressData)localObject).getType().equals("office"))
      {
        setCommpanyAddress((NaviAddressData)localObject);
        writeAddress("office", paramString);
        return;
      }
      if (((NaviAddressData)localObject).getType().equals("home"))
      {
        setHomeAddress((NaviAddressData)localObject);
        writeAddress("home", paramString);
      }
    }
  }
  
  public void handleResponse(int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final String paramString3)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if ("fun_navi_status_sync".equals(paramString2)) {
          NaviCmdController.this.handleStatusSyncRequest(paramString3);
        }
        for (;;)
        {
          NaviCmdController.this.mMapControlRequestMap.remove(paramString1);
          return;
          if ("fun_navi_map_control".equals(paramString2)) {
            NaviCmdController.this.handleMapControlReceive(paramString1, paramInt2, paramString3);
          } else if ("fun_navi_dialog_notify".equals(paramString2)) {
            NaviCmdController.this.handleDialogShow(paramString3);
          } else if ("fun_navi_dialog_cancel".equals(paramString2)) {
            NaviCmdController.this.handleDialogCancel(paramString3);
          } else if ("fun_navi_dialog_response".equals(paramString2)) {
            NaviCmdController.this.handleDialogResponse(paramString3);
          } else if ("fun_navi_route_plan".equals(paramString2)) {
            NaviCmdController.this.handleRouteDetail(paramString3);
          } else if ("fun_navi_navi_state".equals(paramString2)) {
            NaviCmdController.this.handleNaviAppState(paramString3);
          } else if ("fun_navi_cruise".equals(paramString2)) {
            NaviCmdController.this.handleCruiseResponse(paramString1, paramInt2, paramString3);
          } else if ("fun_navi_syn_address".equals(paramString2)) {
            NaviCmdController.this.handleNaviAppAddress(paramString3);
          } else if ("fun_navi_limit_speed".equals(paramString2)) {
            NaviCmdController.this.handleNaviLimitSpeed(paramString3);
          } else if ("fun_navi_navi_set".equals(paramString2)) {
            NaviCmdController.this.handleNaviSet(paramString1, paramInt2);
          }
        }
      }
    });
  }
  
  public boolean isNaviFront()
  {
    h.e("NaviCmdController", "isNaviFront = " + this.mIsNaviFront);
    return this.mIsNaviFront;
  }
  
  public boolean isSetCompanyAddress()
  {
    return this.mCommpanyAddress != null;
  }
  
  public boolean isSetHomeAddress()
  {
    return this.mHomeAddress != null;
  }
  
  public void readAddress()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          String str1 = f.a("home_address_file");
          String str2 = f.a("commpany_address_file");
          NaviCmdController.this.handleNaviAppAddress(str1);
          NaviCmdController.this.handleNaviAppAddress(str2);
          return;
        }
        catch (Exception localException)
        {
          h.b("NaviCmdController", "read address from file error");
          localException.printStackTrace();
        }
      }
    }).start();
  }
  
  public void requestSyncAddress()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        NaviCmdController.this.executeCmd("key_navi_query_home_address", Boolean.valueOf(false));
        NaviCmdController.this.executeCmd("key_navi_query_company_address", Boolean.valueOf(false));
      }
    });
  }
  
  public void setCommpanyAddress(NaviAddressData paramNaviAddressData)
  {
    this.mCommpanyAddress = paramNaviAddressData;
    NaviCmdData localNaviCmdData = NaviParse.getInstance().getNaviCmdData("key_navi_start_task_company");
    Object localObject;
    if (paramNaviAddressData != null)
    {
      localObject = NaviCmdData.createParamsPoi(paramNaviAddressData);
      localNaviCmdData.setParams((String)localObject);
      localObject = NaviParse.getInstance().getNaviCmdData("key_navi_set_company_address");
      if (paramNaviAddressData == null) {
        break label61;
      }
    }
    label61:
    for (paramNaviAddressData = NaviCmdData.createParamsAddress(paramNaviAddressData);; paramNaviAddressData = "")
    {
      ((NaviCmdData)localObject).setParams(paramNaviAddressData);
      return;
      localObject = "";
      break;
    }
  }
  
  public void setHomeAddress(NaviAddressData paramNaviAddressData)
  {
    this.mHomeAddress = paramNaviAddressData;
    NaviCmdData localNaviCmdData = NaviParse.getInstance().getNaviCmdData("key_navi_start_task_home");
    Object localObject;
    if (paramNaviAddressData != null)
    {
      localObject = NaviCmdData.createParamsPoi(paramNaviAddressData);
      localNaviCmdData.setParams((String)localObject);
      localObject = NaviParse.getInstance().getNaviCmdData("key_navi_set_home_address");
      if (paramNaviAddressData == null) {
        break label61;
      }
    }
    label61:
    for (paramNaviAddressData = NaviCmdData.createParamsAddress(paramNaviAddressData);; paramNaviAddressData = "")
    {
      ((NaviCmdData)localObject).setParams(paramNaviAddressData);
      return;
      localObject = "";
      break;
    }
  }
  
  public void writeAddress(final String paramString1, final String paramString2)
  {
    e.a().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if ("office".equals(paramString1))
          {
            f.a("commpany_address_file", paramString2);
            return;
          }
          if ("home".equals(paramString1))
          {
            f.a("home_address_file", paramString2);
            return;
          }
        }
        catch (Exception localException)
        {
          h.b("NaviCmdController", "write address to file error");
          localException.printStackTrace();
        }
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/platform/navi/NaviCmdController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */