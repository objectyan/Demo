package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RouteGuideFSM
{
  public static final String TAG = RouteGuideFSM.class.getSimpleName();
  private static volatile RouteGuideFSM mInstance = null;
  private static String mLastestGlassState = null;
  private static String mLastestMap2DOr3DState = null;
  private List<String> mBackStates = new ArrayList();
  private String mCurrentEvent;
  private IFSMDestStateListener mIFSMDestStateListener = null;
  private boolean mInited = false;
  private RouteGuideFSMListener mRGMListener;
  
  private RouteGuideFSM()
  {
    setInitialState("SimpleGuide");
    RGFSMTable.initTransition();
  }
  
  private boolean backToState(String paramString)
  {
    int j = getIndexInBackStates(paramString);
    if (j < 0) {
      return false;
    }
    int i = this.mBackStates.size() - 1;
    while (i > j)
    {
      this.mBackStates.remove(i);
      i -= 1;
    }
    return true;
  }
  
  public static void destory()
  {
    if (mInstance != null) {}
    try
    {
      if (mInstance != null) {
        mInstance.dispose();
      }
      mInstance = null;
      return;
    }
    finally {}
  }
  
  private void dispose()
  {
    this.mInited = false;
    RGFSMTable.destory();
  }
  
  private void dumpBackStates()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.mBackStates.size())
    {
      localStringBuffer.append("[");
      localStringBuffer.append((String)this.mBackStates.get(i));
      localStringBuffer.append("] -> ");
      i += 1;
    }
    LogUtil.e(TAG, localStringBuffer.toString());
  }
  
  private void filterInvalidState()
  {
    int i = this.mBackStates.size() - 1;
    if (i >= 1)
    {
      if (("Highway".equals(this.mBackStates.get(i))) && (!RGHighwayModel.getInstance().isExists())) {
        this.mBackStates.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        if (("EnlargeRoadmap".equals(this.mBackStates.get(i))) && (!RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing())) {
          this.mBackStates.remove(i);
        }
      }
    }
  }
  
  public static RouteGuideFSM getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new RouteGuideFSM();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void logStateTransition(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = "FSM Transition:(" + paramString1 + ")";
    paramString1 = paramString1 + "   -----  " + paramString2 + "  ----->   ";
    LogUtil.e("RouteGuide", paramString1 + "(" + paramString3 + ")");
  }
  
  private String popState()
  {
    if (this.mBackStates.size() == 1) {
      return null;
    }
    String str = (String)this.mBackStates.remove(this.mBackStates.size() - 1);
    filterInvalidState();
    return str;
  }
  
  private void stateReflection(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(RGState.PACKAGE_NAME + "." + RGState.CLASS_PREFIX + paramString1);
      Object localObject = paramString1.newInstance();
      paramString1.getMethod(paramString2, new Class[0]).invoke(localObject, new Object[0]);
      return;
    }
    catch (Exception paramString1)
    {
      LogUtil.e("RouteGuide", paramString1.toString());
    }
  }
  
  private void stateReflection(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      stateReflection(paramString1, paramString2);
      return;
    }
    try
    {
      paramString1 = Class.forName(RGState.PACKAGE_NAME + "." + RGState.CLASS_PREFIX + paramString1);
      Object localObject = paramString1.newInstance();
      paramString1.getMethod(paramString2, new Class[] { Bundle.class }).invoke(localObject, new Object[] { paramBundle });
      return;
    }
    catch (Exception paramString1)
    {
      LogUtil.e("RouteGuide", paramString1.toString());
    }
  }
  
  public void cacheBackMapState(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      mLastestGlassState = paramString;
      if ("North2D".equals(paramString))
      {
        mLastestMap2DOr3DState = "North2D";
        return;
      }
    } while (!"Car3D".equals(paramString));
    mLastestMap2DOr3DState = "Car3D";
  }
  
  public String getCurrentEvent()
  {
    return this.mCurrentEvent;
  }
  
  public String getCurrentState()
  {
    return getTopState();
  }
  
  public String getEventToLastestMapState()
  {
    if ((mLastestMap2DOr3DState == null) || (mLastestMap2DOr3DState.length() == 0)) {}
    do
    {
      return null;
      if (mLastestMap2DOr3DState.equals("North2D")) {
        return "[3D车头向上]按钮点击";
      }
    } while (!mLastestMap2DOr3DState.equals("Car3D"));
    return "[2D正北]按钮点击";
  }
  
  public int getIndexInBackStates(String paramString)
  {
    int j;
    if ((paramString == null) || (paramString.length() == 0))
    {
      j = -1;
      return j;
    }
    int i = this.mBackStates.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label57;
      }
      j = i;
      if (paramString.equals(this.mBackStates.get(i))) {
        break;
      }
      i -= 1;
    }
    label57:
    return -1;
  }
  
  public String getLastestGlassState()
  {
    return mLastestGlassState;
  }
  
  public String getLastestMap2DOr3DState()
  {
    return mLastestMap2DOr3DState;
  }
  
  public String getSecondState()
  {
    if (this.mBackStates.size() > 1) {
      return (String)this.mBackStates.get(this.mBackStates.size() - 2);
    }
    return null;
  }
  
  public String getTopState()
  {
    if (this.mBackStates.size() > 0) {
      return (String)this.mBackStates.get(this.mBackStates.size() - 1);
    }
    return null;
  }
  
  public boolean isBaseState()
  {
    return (getTopState() != null) && (("SimpleGuide".equals(getTopState())) || ("Highway".equals(getTopState())));
  }
  
  public boolean isLastestGlassState3DOr2D()
  {
    if ((mLastestGlassState == null) || (mLastestGlassState.length() == 0)) {}
    while ((!mLastestGlassState.equals("North2D")) && (!mLastestGlassState.equals("Car3D"))) {
      return false;
    }
    return true;
  }
  
  public boolean isTopState(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(getTopState())) {
      return false;
    }
    return true;
  }
  
  public void pushState(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((getTopState() != null) && (getTopState().equals(paramString))) {
      return;
    }
    this.mBackStates.add(paramString);
  }
  
  public void run(String paramString)
  {
    run(paramString, null);
  }
  
  public void run(String paramString, Bundle paramBundle)
  {
    for (;;)
    {
      boolean bool;
      Object localObject1;
      String str;
      Object localObject2;
      try
      {
        LogUtil.e(TAG, "run: mInited --> " + this.mInited);
        bool = this.mInited;
        if (!bool) {
          return;
        }
        LogUtil.e("RouteGuide", "run START");
        if (this.mRGMListener != null) {
          this.mRGMListener.run(paramString);
        }
        localObject1 = paramString;
        if (paramString.equals("[HUD]按钮点击"))
        {
          localObject1 = paramString;
          if (BNSettingManager.getHudMirroShow()) {
            localObject1 = "从HUD去HUD镜像页";
          }
        }
        str = getTopState();
        localObject2 = localObject1;
        paramString = (String)localObject2;
        if (localObject2 == null) {
          break label891;
        }
        paramString = (String)localObject2;
        if (!"[回车位]按钮点击".equals(localObject2)) {
          break label891;
        }
        paramString = getEventToLastestMapState();
      }
      finally {}
      if ((str.equals("HUDMirror")) && (((String)localObject2).equals("[返回]按钮点击")))
      {
        BNSettingManager.setHudMirroShow(true);
        localObject1 = str;
        if (getSecondState() != null)
        {
          localObject1 = str;
          if (getSecondState().equals("HUD"))
          {
            if (popState() == null) {
              continue;
            }
            localObject1 = getTopState();
          }
        }
        str = RGFSMTable.queryDestState((String)localObject1, (String)localObject2);
        if (((String)localObject2).equals("从HUD镜像页回到HUD"))
        {
          paramString = str;
          if (getSecondState() != null)
          {
            paramString = str;
            if (getSecondState().equals("HUD")) {
              paramString = "BACK";
            }
          }
          LogUtil.e(TAG, "RouteGuideFSM.run() srcState=" + (String)localObject1 + ", event=" + (String)localObject2 + ", destState=" + paramString);
          if (paramString != null)
          {
            this.mCurrentEvent = ((String)localObject2);
            str = getLastestMap2DOr3DState();
            if (!"BACK".equals(paramString)) {
              break label616;
            }
            if (popState() == null) {
              continue;
            }
            if ((localObject2 == null) || (!"收到collada隐藏消息".equals(localObject2)) || (!RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing())) {
              break label608;
            }
            paramString = "EnlargeRoadmap";
            LogUtil.e(TAG, "RouteGuideFSM.run() srcState=" + (String)localObject1 + ", event=" + (String)localObject2 + ", destState=" + paramString + ", glassState=" + str);
            bool = RGControlPanelModel.getInstance().getFullviewState();
            if (!RGFSMTable.isGlassState(paramString)) {
              break label625;
            }
            stateReflection(paramString, "enter", paramBundle);
            stateReflection(paramString, "excute", paramBundle);
            logStateTransition((String)localObject1, (String)localObject2, paramString);
            cacheBackMapState(paramString);
          }
          dumpBackStates();
          LogUtil.e("RouteGuide", "run END");
        }
      }
      else
      {
        localObject1 = str;
        if (!str.equals("HUD")) {
          continue;
        }
        localObject1 = str;
        if (!((String)localObject2).equals("[返回]按钮点击")) {
          continue;
        }
        BNSettingManager.setHudMirroShow(false);
        localObject1 = str;
        if (getSecondState() == null) {
          continue;
        }
        localObject1 = str;
        if (!getSecondState().equals("HUDMirror")) {
          continue;
        }
        if (popState() == null) {
          continue;
        }
        localObject1 = getTopState();
        continue;
      }
      paramString = str;
      if (((String)localObject2).equals("从HUD去HUD镜像页"))
      {
        paramString = str;
        if (getSecondState() != null)
        {
          paramString = str;
          if (getSecondState().equals("HUDMirror"))
          {
            paramString = "BACK";
            continue;
            label608:
            paramString = getTopState();
            continue;
            label616:
            backToState(paramString);
            continue;
            label625:
            if (paramString != null)
            {
              if (("EnlargeRoadmap".equals(paramString)) || ("Colladamap".equals(paramString))) {
                RGControlPanelModel.getInstance().setmIsFullviewBeforeEnlargeMap(bool);
              }
              stateReflection((String)localObject1, "exit");
              stateReflection(paramString, "enter", paramBundle);
              stateReflection(paramString, "excute", paramBundle);
              pushState(paramString);
              if ((str != null) && (str.length() > 0))
              {
                if ((!"SimpleGuide".equals(paramString)) && (!"Highway".equals(paramString))) {
                  break label843;
                }
                if (!bool) {
                  break label773;
                }
                stateReflection("Fullview", "enter", paramBundle);
                stateReflection("Fullview", "excute", paramBundle);
              }
              for (;;)
              {
                logStateTransition((String)localObject1, (String)localObject2, paramString);
                if (this.mIFSMDestStateListener == null) {
                  break;
                }
                this.mIFSMDestStateListener.onDestState(paramString);
                break;
                label773:
                if (RGControlPanelModel.getInstance().ismIsFullviewBeforeEnlargeMap())
                {
                  stateReflection("Fullview", "enter", paramBundle);
                  stateReflection("Fullview", "excute", paramBundle);
                  RGControlPanelModel.getInstance().setmIsFullviewBeforeEnlargeMap(false);
                }
                else
                {
                  stateReflection(str, "enter", paramBundle);
                  stateReflection(str, "excute", paramBundle);
                  cacheBackMapState(str);
                  continue;
                  label843:
                  if (("EnlargeRoadmap".equals(paramString)) || ("Colladamap".equals(paramString)))
                  {
                    stateReflection(str, "enter", paramBundle);
                    stateReflection(str, "excute", paramBundle);
                    cacheBackMapState(str);
                  }
                }
              }
              label891:
              localObject2 = paramString;
              if (paramString == null) {
                localObject2 = localObject1;
              }
            }
          }
        }
      }
    }
  }
  
  public void runFirstFullViewSate()
  {
    try
    {
      stateReflection("SimpleGuide", "enter");
      stateReflection("SimpleGuide", "excute");
      run("[一键全览]按钮点击");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void runInitialState(Bundle paramBundle)
  {
    try
    {
      stateReflection(getTopState(), "enter");
      stateReflection(getTopState(), "excute");
      run("[回车位]按钮点击", paramBundle);
      return;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public void setDestStateListener(IFSMDestStateListener paramIFSMDestStateListener)
  {
    this.mIFSMDestStateListener = paramIFSMDestStateListener;
  }
  
  /* Error */
  public void setInitialState(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/baidu/navisdk/ui/routeguide/fsm/RouteGuideFSM:mBackStates	Ljava/util/List;
    //   6: invokeinterface 350 1 0
    //   11: invokestatic 353	com/baidu/navisdk/comapi/setting/BNSettingManager:getMapMode	()I
    //   14: iconst_1
    //   15: if_icmpne +23 -> 38
    //   18: ldc -47
    //   20: astore_2
    //   21: aload_2
    //   22: putstatic 37	com/baidu/navisdk/ui/routeguide/fsm/RouteGuideFSM:mLastestMap2DOr3DState	Ljava/lang/String;
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 331	com/baidu/navisdk/ui/routeguide/fsm/RouteGuideFSM:pushState	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 45	com/baidu/navisdk/ui/routeguide/fsm/RouteGuideFSM:mInited	Z
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: ldc -49
    //   40: astore_2
    //   41: goto -20 -> 21
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	RouteGuideFSM
    //   0	49	1	paramString	String
    //   20	21	2	str	String
    // Exception table:
    //   from	to	target	type
    //   2	18	44	finally
    //   21	35	44	finally
  }
  
  public void setRGMListener(RouteGuideFSMListener paramRouteGuideFSMListener)
  {
    this.mRGMListener = paramRouteGuideFSMListener;
  }
  
  public static abstract interface IFSMDestStateListener
  {
    public abstract void onDestState(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RouteGuideFSM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */