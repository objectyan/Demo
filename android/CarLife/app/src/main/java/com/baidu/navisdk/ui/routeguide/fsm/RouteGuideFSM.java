package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class RouteGuideFSM {
    public static final String TAG = RouteGuideFSM.class.getSimpleName();
    private static volatile RouteGuideFSM mInstance = null;
    private static String mLastestGlassState = null;
    private static String mLastestMap2DOr3DState = null;
    private List<String> mBackStates = new ArrayList();
    private String mCurrentEvent;
    private IFSMDestStateListener mIFSMDestStateListener = null;
    private boolean mInited = false;
    private RouteGuideFSMListener mRGMListener;

    public interface IFSMDestStateListener {
        void onDestState(String str);
    }

    public void setRGMListener(RouteGuideFSMListener mRGMListener) {
        this.mRGMListener = mRGMListener;
    }

    private RouteGuideFSM() {
        setInitialState(FsmState.SimpleGuide);
        RGFSMTable.initTransition();
    }

    public void setDestStateListener(IFSMDestStateListener listener) {
        this.mIFSMDestStateListener = listener;
    }

    public static RouteGuideFSM getInstance() {
        if (mInstance == null) {
            synchronized (RouteGuideFSM.class) {
                if (mInstance == null) {
                    mInstance = new RouteGuideFSM();
                }
            }
        }
        return mInstance;
    }

    public static void destory() {
        if (mInstance != null) {
            synchronized (RouteGuideFSM.class) {
                if (mInstance != null) {
                    mInstance.dispose();
                }
            }
        }
        mInstance = null;
    }

    private void dispose() {
        this.mInited = false;
        RGFSMTable.destory();
    }

    public synchronized void setInitialState(String initialState) {
        this.mBackStates.clear();
        mLastestMap2DOr3DState = BNSettingManager.getMapMode() == 1 ? FsmState.Car3D : FsmState.North2D;
        pushState(initialState);
        this.mInited = true;
    }

    public synchronized void runInitialState(Bundle bundle) {
        stateReflection(getTopState(), RGState.METHOD_NAME_ENTER);
        stateReflection(getTopState(), RGState.METHOD_NAME_EXCUTE);
        run(FsmEvent.BTN_CLICK_LOC_CAR, bundle);
    }

    public synchronized void runFirstFullViewSate() {
        stateReflection(FsmState.SimpleGuide, RGState.METHOD_NAME_ENTER);
        stateReflection(FsmState.SimpleGuide, RGState.METHOD_NAME_EXCUTE);
        run(FsmEvent.BTN_CLICK_FULL_VIEW);
    }

    public boolean isBaseState() {
        if (getTopState() == null || (!FsmState.SimpleGuide.equals(getTopState()) && !"Highway".equals(getTopState()))) {
            return false;
        }
        return true;
    }

    public void run(String srcEvent) {
        run(srcEvent, null);
    }

    public synchronized void run(String srcEvent, Bundle enterParams) {
        LogUtil.m15791e(TAG, "run: mInited --> " + this.mInited);
        if (this.mInited) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "run START");
            if (this.mRGMListener != null) {
                this.mRGMListener.run(srcEvent);
            }
            if (srcEvent.equals(FsmEvent.BTN_CLICK_HUD_ENTER) && BNSettingManager.getHudMirroShow()) {
                srcEvent = FsmEvent.MSG_HUD_GOTO_MIRROR;
            }
            String sourceState = getTopState();
            String event = srcEvent;
            if (event != null && FsmEvent.BTN_CLICK_LOC_CAR.equals(event)) {
                event = getEventToLastestMapState();
            }
            if (event == null) {
                event = srcEvent;
            }
            if (sourceState.equals(FsmState.HUDMirror) && event.equals(FsmEvent.BTN_CLICK_BACK)) {
                BNSettingManager.setHudMirroShow(true);
                if (getSecondState() != null && getSecondState().equals("HUD")) {
                    if (popState() != null) {
                        sourceState = getTopState();
                    }
                }
            } else if (sourceState.equals("HUD") && event.equals(FsmEvent.BTN_CLICK_BACK)) {
                BNSettingManager.setHudMirroShow(false);
                if (getSecondState() != null && getSecondState().equals(FsmState.HUDMirror)) {
                    if (popState() != null) {
                        sourceState = getTopState();
                    }
                }
            }
            String destState = RGFSMTable.queryDestState(sourceState, event);
            if (event.equals(FsmEvent.MSG_MIRROR_GOTO_HUD)) {
                if (getSecondState() != null && getSecondState().equals("HUD")) {
                    destState = FsmState.BACK;
                }
            } else if (event.equals(FsmEvent.MSG_HUD_GOTO_MIRROR) && getSecondState() != null && getSecondState().equals(FsmState.HUDMirror)) {
                destState = FsmState.BACK;
            }
            LogUtil.m15791e(TAG, "RouteGuideFSM.run() srcState=" + sourceState + ", event=" + event + ", destState=" + destState);
            if (destState != null) {
                this.mCurrentEvent = event;
                String glassState = getLastestMap2DOr3DState();
                if (!FsmState.BACK.equals(destState)) {
                    backToState(destState);
                } else if (popState() != null) {
                    if (event != null && FsmEvent.MSG_COLLADA_HIDE.equals(event) && RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()) {
                        destState = FsmState.EnlargeRoadmap;
                    } else {
                        destState = getTopState();
                    }
                }
                LogUtil.m15791e(TAG, "RouteGuideFSM.run() srcState=" + sourceState + ", event=" + event + ", destState=" + destState + ", glassState=" + glassState);
                boolean fullView = RGControlPanelModel.getInstance().getFullviewState();
                if (RGFSMTable.isGlassState(destState)) {
                    stateReflection(destState, RGState.METHOD_NAME_ENTER, enterParams);
                    stateReflection(destState, RGState.METHOD_NAME_EXCUTE, enterParams);
                    logStateTransition(sourceState, event, destState);
                    cacheBackMapState(destState);
                } else if (destState != null) {
                    if (FsmState.EnlargeRoadmap.equals(destState) || FsmState.Colladamap.equals(destState)) {
                        RGControlPanelModel.getInstance().setmIsFullviewBeforeEnlargeMap(fullView);
                    }
                    stateReflection(sourceState, RGState.METHOD_NAME_EXIT);
                    stateReflection(destState, RGState.METHOD_NAME_ENTER, enterParams);
                    stateReflection(destState, RGState.METHOD_NAME_EXCUTE, enterParams);
                    pushState(destState);
                    if (glassState != null && glassState.length() > 0) {
                        if (FsmState.SimpleGuide.equals(destState) || "Highway".equals(destState)) {
                            if (fullView) {
                                stateReflection(FsmState.Fullview, RGState.METHOD_NAME_ENTER, enterParams);
                                stateReflection(FsmState.Fullview, RGState.METHOD_NAME_EXCUTE, enterParams);
                            } else if (RGControlPanelModel.getInstance().ismIsFullviewBeforeEnlargeMap()) {
                                stateReflection(FsmState.Fullview, RGState.METHOD_NAME_ENTER, enterParams);
                                stateReflection(FsmState.Fullview, RGState.METHOD_NAME_EXCUTE, enterParams);
                                RGControlPanelModel.getInstance().setmIsFullviewBeforeEnlargeMap(false);
                            } else {
                                stateReflection(glassState, RGState.METHOD_NAME_ENTER, enterParams);
                                stateReflection(glassState, RGState.METHOD_NAME_EXCUTE, enterParams);
                                cacheBackMapState(glassState);
                            }
                        } else if (FsmState.EnlargeRoadmap.equals(destState) || FsmState.Colladamap.equals(destState)) {
                            stateReflection(glassState, RGState.METHOD_NAME_ENTER, enterParams);
                            stateReflection(glassState, RGState.METHOD_NAME_EXCUTE, enterParams);
                            cacheBackMapState(glassState);
                        }
                    }
                    logStateTransition(sourceState, event, destState);
                    if (this.mIFSMDestStateListener != null) {
                        this.mIFSMDestStateListener.onDestState(destState);
                    }
                }
            }
            dumpBackStates();
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "run END");
        }
    }

    public String getCurrentState() {
        return getTopState();
    }

    public String getCurrentEvent() {
        return this.mCurrentEvent;
    }

    private void stateReflection(String strStateName, String strStateMethod) {
        try {
            Class<?> stateCls = Class.forName(RGState.PACKAGE_NAME + "." + RGState.CLASS_PREFIX + strStateName);
            stateCls.getMethod(strStateMethod, new Class[0]).invoke(stateCls.newInstance(), new Object[0]);
        } catch (Exception e) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, e.toString());
        }
    }

    private void stateReflection(String strStateName, String strStateMethod, Bundle data) {
        if (data == null) {
            stateReflection(strStateName, strStateMethod);
            return;
        }
        try {
            Class<?> stateCls = Class.forName(RGState.PACKAGE_NAME + "." + RGState.CLASS_PREFIX + strStateName);
            Object stateObj = stateCls.newInstance();
            stateCls.getMethod(strStateMethod, new Class[]{Bundle.class}).invoke(stateObj, new Object[]{data});
        } catch (Exception e) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, e.toString());
        }
    }

    private void logStateTransition(String srcState, String event, String destState) {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, (("FSM Transition:(" + srcState + ")") + "   -----  " + event + "  ----->   ") + "(" + destState + ")");
    }

    public void pushState(String backState) {
        if (backState != null && backState.length() != 0) {
            if (getTopState() == null || !getTopState().equals(backState)) {
                this.mBackStates.add(backState);
            }
        }
    }

    private String popState() {
        if (this.mBackStates.size() == 1) {
            return null;
        }
        String tmpState = (String) this.mBackStates.remove(this.mBackStates.size() - 1);
        filterInvalidState();
        return tmpState;
    }

    private void filterInvalidState() {
        for (int i = this.mBackStates.size() - 1; i >= 1; i--) {
            if ("Highway".equals(this.mBackStates.get(i)) && !RGHighwayModel.getInstance().isExists()) {
                this.mBackStates.remove(i);
            } else if (FsmState.EnlargeRoadmap.equals(this.mBackStates.get(i)) && !RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()) {
                this.mBackStates.remove(i);
            }
        }
    }

    public String getTopState() {
        if (this.mBackStates.size() > 0) {
            return (String) this.mBackStates.get(this.mBackStates.size() - 1);
        }
        return null;
    }

    public String getSecondState() {
        if (this.mBackStates.size() > 1) {
            return (String) this.mBackStates.get(this.mBackStates.size() - 2);
        }
        return null;
    }

    public boolean isTopState(String state) {
        if (state == null || state.length() == 0 || !state.equals(getTopState())) {
            return false;
        }
        return true;
    }

    public int getIndexInBackStates(String state) {
        if (state == null || state.length() == 0) {
            return -1;
        }
        for (int i = this.mBackStates.size() - 1; i >= 0; i--) {
            if (state.equals(this.mBackStates.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private boolean backToState(String state) {
        int targetIndex = getIndexInBackStates(state);
        if (targetIndex < 0) {
            return false;
        }
        for (int i = this.mBackStates.size() - 1; i > targetIndex; i--) {
            this.mBackStates.remove(i);
        }
        return true;
    }

    public void cacheBackMapState(String destState) {
        if (destState != null && destState.length() != 0) {
            mLastestGlassState = destState;
            if (FsmState.North2D.equals(destState)) {
                mLastestMap2DOr3DState = FsmState.North2D;
            } else if (FsmState.Car3D.equals(destState)) {
                mLastestMap2DOr3DState = FsmState.Car3D;
            }
        }
    }

    public boolean isLastestGlassState3DOr2D() {
        if (mLastestGlassState == null || mLastestGlassState.length() == 0) {
            return false;
        }
        if (mLastestGlassState.equals(FsmState.North2D) || mLastestGlassState.equals(FsmState.Car3D)) {
            return true;
        }
        return false;
    }

    public String getLastestGlassState() {
        return mLastestGlassState;
    }

    public String getLastestMap2DOr3DState() {
        return mLastestMap2DOr3DState;
    }

    public String getEventToLastestMapState() {
        if (mLastestMap2DOr3DState == null || mLastestMap2DOr3DState.length() == 0) {
            return null;
        }
        if (mLastestMap2DOr3DState.equals(FsmState.North2D)) {
            return FsmEvent.BTN_CLICK_CAR_3D;
        }
        if (mLastestMap2DOr3DState.equals(FsmState.Car3D)) {
            return FsmEvent.BTN_CLICK_NORTH_2D;
        }
        return null;
    }

    private void dumpBackStates() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.mBackStates.size(); i++) {
            sb.append("[");
            sb.append((String) this.mBackStates.get(i));
            sb.append("] -> ");
        }
        LogUtil.m15791e(TAG, sb.toString());
    }
}
