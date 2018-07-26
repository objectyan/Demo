package com.baidu.che.codriver.vr;

import com.baidu.che.codriver.util.C2725h;
import com.baidu.mobstat.Config;

/* compiled from: VrStateMachine */
/* renamed from: com.baidu.che.codriver.vr.q */
public class C2851q {
    /* renamed from: a */
    private static final String f9336a = "VrStateMachine";
    /* renamed from: b */
    private C2850a f9337b = C2850a.VRSTATE_IDLE;
    /* renamed from: c */
    private C2850a f9338c = C2850a.VRSTATE_BUSY_WAITING;
    /* renamed from: d */
    private C2850a f9339d = C2850a.VRSTATE_IDLE;
    /* renamed from: e */
    private boolean f9340e = false;
    /* renamed from: f */
    private C2847o f9341f = null;

    /* compiled from: VrStateMachine */
    /* renamed from: com.baidu.che.codriver.vr.q$a */
    public enum C2850a {
        VRSTATE_IDLE,
        VRSTATE_BUSY_WAKEUP,
        VRSTATE_BUSY_ASR_WAKEUP,
        VRSTATE_BUSY_WAITING,
        VRSTATE_BUSY_ASR,
        VRSTATE_BUSY_WAKEUP_SCENE_NAVI,
        VRSTATE_BUSY_WAKEUP_SCENE_MUSIC,
        VRSTATE_BUSY_WAKEUP_SCENE_ALL
    }

    protected C2851q(C2847o vrManager) {
        this.f9341f = vrManager;
    }

    /* renamed from: a */
    protected synchronized C2850a m10802a() {
        return this.f9337b;
    }

    /* renamed from: b */
    protected int m10803b() {
        C2725h.m10207b(f9336a, "--onWakeUpExit- mCurState = " + this.f9337b + " , mNextState = " + this.f9338c);
        if (this.f9341f.m10768j()) {
            switch (this.f9337b) {
                case VRSTATE_BUSY_WAITING:
                    if (this.f9338c == C2850a.VRSTATE_IDLE) {
                        m10799j();
                        if (this.f9340e) {
                            m10800k();
                        }
                        return 0;
                    } else if (this.f9338c == C2850a.VRSTATE_BUSY_WAKEUP_SCENE_ALL) {
                        if (this.f9341f.m10726a(3) == -1) {
                            return -1;
                        }
                        this.f9337b = C2850a.VRSTATE_BUSY_WAKEUP_SCENE_ALL;
                        this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                        return 0;
                    }
                    break;
                case VRSTATE_BUSY_WAKEUP:
                case VRSTATE_BUSY_WAKEUP_SCENE_ALL:
                case VRSTATE_BUSY_WAKEUP_SCENE_NAVI:
                case VRSTATE_BUSY_WAKEUP_SCENE_MUSIC:
                    this.f9337b = C2850a.VRSTATE_IDLE;
                    this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                    if (this.f9340e) {
                        m10800k();
                    }
                    C2725h.m10207b(f9336a, "onWakeUpExit exception, to state VRSTATE_IDLE.");
                    return -1;
                case VRSTATE_IDLE:
                    if (this.f9340e) {
                        m10800k();
                    }
                    return 0;
                case VRSTATE_BUSY_ASR_WAKEUP:
                    this.f9337b = C2850a.VRSTATE_BUSY_ASR;
                    this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                    C2725h.m10207b(f9336a, "onWakeUpExit exception , to state VRSTATE_BUSY_ASR.");
                    return -1;
            }
            C2725h.m10214e(f9336a, "onWakeUpExit state error.");
            return -1;
        }
        C2725h.m10214e(f9336a, "onWakeUpExit not inited.");
        return -1;
    }

    /* renamed from: c */
    protected int m10804c() {
        C2725h.m10207b(f9336a, "--onAsrExit- mCurState = " + this.f9337b + " , mNextState = " + this.f9338c);
        if (this.f9341f.m10768j()) {
            switch (this.f9337b) {
                case VRSTATE_BUSY_WAITING:
                    switch (this.f9338c) {
                        case VRSTATE_BUSY_WAKEUP:
                            m10799j();
                            return 0;
                        case VRSTATE_BUSY_WAKEUP_SCENE_ALL:
                            if (this.f9341f.m10741b(3) == -1) {
                                C2725h.m10214e(f9336a, "onAsrExit openSceneCmd fail.");
                                return -1;
                            }
                            m10799j();
                            return 0;
                        case VRSTATE_BUSY_WAKEUP_SCENE_NAVI:
                            if (this.f9341f.m10741b(1) == 0) {
                                C2725h.m10214e(f9336a, "onAsrExit openSceneCmd fail.");
                                return -1;
                            }
                            m10799j();
                            return 0;
                        case VRSTATE_BUSY_WAKEUP_SCENE_MUSIC:
                            if (this.f9341f.m10741b(2) == 0) {
                                m10799j();
                                return 0;
                            }
                            break;
                        case VRSTATE_IDLE:
                            this.f9341f.m10765i();
                            m10799j();
                            if (!C2847o.m10687a().m10777q()) {
                                this.f9340e = false;
                            }
                            return 0;
                        case VRSTATE_BUSY_ASR_WAKEUP:
                        case VRSTATE_BUSY_ASR:
                            if (this.f9341f.m10755e() == -1) {
                                return -1;
                            }
                            this.f9337b = this.f9338c;
                            this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                            return 0;
                        default:
                            break;
                    }
                case VRSTATE_BUSY_WAKEUP:
                case VRSTATE_IDLE:
                    return 0;
                case VRSTATE_BUSY_ASR_WAKEUP:
                    this.f9337b = C2850a.VRSTATE_BUSY_WAKEUP;
                    this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                    C2725h.m10207b(f9336a, "onAsrExit, to state VRSTATE_BUSY_WAKEUP.");
                    return 0;
                case VRSTATE_BUSY_ASR:
                    this.f9337b = C2850a.VRSTATE_IDLE;
                    this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                    C2725h.m10207b(f9336a, "onAsrExit, to state VRSTATE_IDLE.");
                    return 0;
            }
            C2725h.m10214e(f9336a, "onAsrExit exception.");
            return -1;
        }
        C2725h.m10214e(f9336a, "onAsrExit not inited.");
        return -1;
    }

    /* renamed from: j */
    private void m10799j() {
        this.f9337b = this.f9338c;
        this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
    }

    /* renamed from: d */
    protected synchronized int m10805d() {
        int i = -1;
        synchronized (this) {
            C2725h.m10207b(f9336a, "--enterIdleMode- mCurState = " + this.f9337b + " , mNextState = " + this.f9338c);
            if (!this.f9340e) {
                if (this.f9341f.m10768j()) {
                    switch (this.f9337b) {
                        case VRSTATE_BUSY_WAKEUP:
                        case VRSTATE_BUSY_WAKEUP_SCENE_ALL:
                        case VRSTATE_BUSY_WAKEUP_SCENE_NAVI:
                        case VRSTATE_BUSY_WAKEUP_SCENE_MUSIC:
                            this.f9341f.m10765i();
                            this.f9337b = C2850a.VRSTATE_BUSY_WAITING;
                            this.f9338c = C2850a.VRSTATE_IDLE;
                            i = 0;
                            break;
                        case VRSTATE_IDLE:
                            this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                            i = 0;
                            break;
                        case VRSTATE_BUSY_ASR_WAKEUP:
                        case VRSTATE_BUSY_ASR:
                            this.f9341f.m10759f();
                            this.f9337b = C2850a.VRSTATE_BUSY_WAITING;
                            this.f9338c = C2850a.VRSTATE_IDLE;
                            i = 0;
                            break;
                        default:
                            C2725h.m10214e(f9336a, "enterIdleMode exception.");
                            break;
                    }
                }
                C2725h.m10214e(f9336a, "enterIdleMode not inited.");
            } else {
                C2725h.m10214e(f9336a, "in restarting mode");
            }
        }
        return i;
    }

    /* renamed from: e */
    protected synchronized int m10806e() {
        int i = -1;
        synchronized (this) {
            C2725h.m10207b(f9336a, "--enterWakeupMode- mCurState = " + this.f9337b + " , mNextState = " + this.f9338c);
            if (!this.f9340e) {
                if (this.f9341f.m10768j()) {
                    switch (this.f9337b) {
                        case VRSTATE_BUSY_WAKEUP:
                            this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                            i = 0;
                            break;
                        case VRSTATE_BUSY_WAKEUP_SCENE_ALL:
                        case VRSTATE_BUSY_WAKEUP_SCENE_NAVI:
                        case VRSTATE_BUSY_WAKEUP_SCENE_MUSIC:
                            this.f9341f.m10761g();
                            this.f9337b = C2850a.VRSTATE_BUSY_WAKEUP;
                            this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                            i = 0;
                            break;
                        case VRSTATE_IDLE:
                            if (this.f9341f.m10763h() != -1) {
                                this.f9337b = C2850a.VRSTATE_BUSY_WAKEUP;
                                this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                                i = 0;
                                break;
                            }
                            break;
                        case VRSTATE_BUSY_ASR_WAKEUP:
                            this.f9341f.m10759f();
                            this.f9337b = C2850a.VRSTATE_BUSY_WAITING;
                            this.f9338c = C2850a.VRSTATE_BUSY_WAKEUP;
                            i = 0;
                            break;
                        default:
                            C2725h.m10214e(f9336a, "enterWakeupMode exception.");
                            break;
                    }
                }
                C2725h.m10214e(f9336a, "enterWakeupMode not inited.");
            } else {
                C2725h.m10214e(f9336a, "in restarting mode");
            }
        }
        return i;
    }

    /* renamed from: f */
    protected synchronized int m10807f() {
        int i = -1;
        synchronized (this) {
            C2725h.m10207b(f9336a, "--enterAsrWakeupMode- mCurState = " + this.f9337b + " , mNextState = " + this.f9338c);
            if (!this.f9340e) {
                if (this.f9341f.m10768j()) {
                    switch (this.f9337b) {
                        case VRSTATE_BUSY_WAKEUP:
                            if (this.f9341f.m10755e() != -1) {
                                this.f9337b = C2850a.VRSTATE_BUSY_ASR_WAKEUP;
                                this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                                i = 0;
                                break;
                            }
                            break;
                        case VRSTATE_BUSY_WAKEUP_SCENE_ALL:
                        case VRSTATE_BUSY_WAKEUP_SCENE_NAVI:
                        case VRSTATE_BUSY_WAKEUP_SCENE_MUSIC:
                            this.f9341f.m10761g();
                            if (this.f9341f.m10755e() != -1) {
                                this.f9337b = C2850a.VRSTATE_BUSY_ASR_WAKEUP;
                                this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                                i = 0;
                                break;
                            }
                            break;
                        case VRSTATE_IDLE:
                            if (this.f9341f.m10755e() != -1) {
                                this.f9337b = C2850a.VRSTATE_BUSY_ASR;
                                this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
                                i = 0;
                                break;
                            }
                            break;
                        case VRSTATE_BUSY_ASR_WAKEUP:
                        case VRSTATE_BUSY_ASR:
                            this.f9341f.m10759f();
                            this.f9338c = this.f9337b;
                            this.f9337b = C2850a.VRSTATE_BUSY_WAITING;
                            i = 0;
                            break;
                        default:
                            C2725h.m10214e(f9336a, "enterAsrWakeupMode exception.");
                            break;
                    }
                }
                C2725h.m10214e(f9336a, "enterAsrWakeupMode not inited.");
            } else {
                C2725h.m10214e(f9336a, "in restarting mode");
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    protected synchronized int m10801a(int r7) {
        /*
        r6 = this;
        r2 = 0;
        r1 = -1;
        monitor-enter(r6);
        r3 = "VrStateMachine";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0070 }
        r4.<init>();	 Catch:{ all -> 0x0070 }
        r5 = "--enterWakeupSceneMode (";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0070 }
        r4 = r4.append(r7);	 Catch:{ all -> 0x0070 }
        r5 = ") - mCurState = ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0070 }
        r5 = r6.f9337b;	 Catch:{ all -> 0x0070 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0070 }
        r5 = " , mNextState = ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0070 }
        r5 = r6.f9338c;	 Catch:{ all -> 0x0070 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0070 }
        r4 = r4.toString();	 Catch:{ all -> 0x0070 }
        com.baidu.che.codriver.util.C2725h.m10207b(r3, r4);	 Catch:{ all -> 0x0070 }
        r3 = r6.f9340e;	 Catch:{ all -> 0x0070 }
        if (r3 == 0) goto L_0x0046;
    L_0x003b:
        r2 = "VrStateMachine";
        r3 = "in restarting mode";
        com.baidu.che.codriver.util.C2725h.m10214e(r2, r3);	 Catch:{ all -> 0x0070 }
    L_0x0044:
        monitor-exit(r6);
        return r1;
    L_0x0046:
        r3 = r6.f9341f;	 Catch:{ all -> 0x0070 }
        r3 = r3.m10768j();	 Catch:{ all -> 0x0070 }
        if (r3 != 0) goto L_0x0073;
    L_0x004e:
        r2 = "VrStateMachine";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0070 }
        r3.<init>();	 Catch:{ all -> 0x0070 }
        r4 = "--enterWakeupSceneMode (";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0070 }
        r3 = r3.append(r7);	 Catch:{ all -> 0x0070 }
        r4 = ") not inited.";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0070 }
        r3 = r3.toString();	 Catch:{ all -> 0x0070 }
        com.baidu.che.codriver.util.C2725h.m10214e(r2, r3);	 Catch:{ all -> 0x0070 }
        goto L_0x0044;
    L_0x0070:
        r1 = move-exception;
        monitor-exit(r6);
        throw r1;
    L_0x0073:
        r0 = 0;
        switch(r7) {
            case 1: goto L_0x00a5;
            case 2: goto L_0x00a8;
            case 3: goto L_0x0099;
            default: goto L_0x0077;
        };
    L_0x0077:
        r2 = "VrStateMachine";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0070 }
        r3.<init>();	 Catch:{ all -> 0x0070 }
        r4 = "--enterWakeupSceneMode (";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0070 }
        r3 = r3.append(r7);	 Catch:{ all -> 0x0070 }
        r4 = ") scenetype illegal.";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0070 }
        r3 = r3.toString();	 Catch:{ all -> 0x0070 }
        com.baidu.che.codriver.util.C2725h.m10214e(r2, r3);	 Catch:{ all -> 0x0070 }
        goto L_0x0044;
    L_0x0099:
        r0 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_BUSY_WAKEUP_SCENE_ALL;	 Catch:{ all -> 0x0070 }
    L_0x009b:
        r3 = r6.f9337b;	 Catch:{ all -> 0x0070 }
        if (r3 != r0) goto L_0x00ab;
    L_0x009f:
        r1 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_BUSY_WAITING;	 Catch:{ all -> 0x0070 }
        r6.f9338c = r1;	 Catch:{ all -> 0x0070 }
        r1 = r2;
        goto L_0x0044;
    L_0x00a5:
        r0 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_BUSY_WAKEUP_SCENE_NAVI;	 Catch:{ all -> 0x0070 }
        goto L_0x009b;
    L_0x00a8:
        r0 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_BUSY_WAKEUP_SCENE_MUSIC;	 Catch:{ all -> 0x0070 }
        goto L_0x009b;
    L_0x00ab:
        r3 = com.baidu.che.codriver.vr.C2851q.C28491.f9326a;	 Catch:{ all -> 0x0070 }
        r4 = r6.f9337b;	 Catch:{ all -> 0x0070 }
        r4 = r4.ordinal();	 Catch:{ all -> 0x0070 }
        r3 = r3[r4];	 Catch:{ all -> 0x0070 }
        switch(r3) {
            case 1: goto L_0x010b;
            case 2: goto L_0x00e9;
            case 3: goto L_0x00e9;
            case 4: goto L_0x00e9;
            case 5: goto L_0x00e9;
            case 6: goto L_0x00fa;
            case 7: goto L_0x00db;
            case 8: goto L_0x00db;
            default: goto L_0x00b8;
        };	 Catch:{ all -> 0x0070 }
    L_0x00b8:
        r2 = "VrStateMachine";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0070 }
        r3.<init>();	 Catch:{ all -> 0x0070 }
        r4 = "--enterWakeupSceneMode (";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0070 }
        r3 = r3.append(r7);	 Catch:{ all -> 0x0070 }
        r4 = ") exception.";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0070 }
        r3 = r3.toString();	 Catch:{ all -> 0x0070 }
        com.baidu.che.codriver.util.C2725h.m10214e(r2, r3);	 Catch:{ all -> 0x0070 }
        goto L_0x0044;
    L_0x00db:
        r1 = r6.f9341f;	 Catch:{ all -> 0x0070 }
        r1.m10759f();	 Catch:{ all -> 0x0070 }
        r1 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_BUSY_WAITING;	 Catch:{ all -> 0x0070 }
        r6.f9337b = r1;	 Catch:{ all -> 0x0070 }
        r6.f9338c = r0;	 Catch:{ all -> 0x0070 }
        r1 = r2;
        goto L_0x0044;
    L_0x00e9:
        r3 = r6.f9341f;	 Catch:{ all -> 0x0070 }
        r3 = r3.m10741b(r7);	 Catch:{ all -> 0x0070 }
        if (r3 == r1) goto L_0x0044;
    L_0x00f1:
        r6.f9337b = r0;	 Catch:{ all -> 0x0070 }
        r1 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_BUSY_WAITING;	 Catch:{ all -> 0x0070 }
        r6.f9338c = r1;	 Catch:{ all -> 0x0070 }
        r1 = r2;
        goto L_0x0044;
    L_0x00fa:
        r3 = r6.f9341f;	 Catch:{ all -> 0x0070 }
        r3 = r3.m10726a(r7);	 Catch:{ all -> 0x0070 }
        if (r3 == r1) goto L_0x0044;
    L_0x0102:
        r6.f9337b = r0;	 Catch:{ all -> 0x0070 }
        r1 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_BUSY_WAITING;	 Catch:{ all -> 0x0070 }
        r6.f9338c = r1;	 Catch:{ all -> 0x0070 }
        r1 = r2;
        goto L_0x0044;
    L_0x010b:
        r3 = r6.f9338c;	 Catch:{ all -> 0x0070 }
        r4 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_IDLE;	 Catch:{ all -> 0x0070 }
        if (r3 != r4) goto L_0x00b8;
    L_0x0111:
        r1 = com.baidu.che.codriver.vr.C2851q.C2850a.VRSTATE_BUSY_WAKEUP_SCENE_ALL;	 Catch:{ all -> 0x0070 }
        r6.f9338c = r1;	 Catch:{ all -> 0x0070 }
        r1 = r2;
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.che.codriver.vr.q.a(int):int");
    }

    /* renamed from: g */
    protected synchronized int m10808g() {
        int i = -1;
        synchronized (this) {
            C2725h.m10207b(f9336a, "--restartStateMachine- mCurState = " + this.f9337b + " , mNextState = " + this.f9338c);
            if (this.f9340e) {
                C2725h.m10214e(f9336a, "in restarting mode");
            } else if (this.f9341f.m10768j()) {
                switch (this.f9337b) {
                    case VRSTATE_BUSY_WAITING:
                        this.f9339d = this.f9338c;
                        break;
                    case VRSTATE_BUSY_WAKEUP:
                    case VRSTATE_BUSY_WAKEUP_SCENE_ALL:
                    case VRSTATE_BUSY_WAKEUP_SCENE_NAVI:
                    case VRSTATE_BUSY_WAKEUP_SCENE_MUSIC:
                        this.f9339d = this.f9337b;
                        break;
                    case VRSTATE_IDLE:
                        i = 0;
                        break;
                    case VRSTATE_BUSY_ASR_WAKEUP:
                        this.f9339d = C2850a.VRSTATE_BUSY_WAKEUP_SCENE_ALL;
                        break;
                    case VRSTATE_BUSY_ASR:
                        this.f9339d = C2850a.VRSTATE_BUSY_WAKEUP;
                        break;
                    default:
                        break;
                }
                m10805d();
                this.f9340e = true;
                i = 0;
            } else {
                C2725h.m10214e(f9336a, "restartStateMachine not inited.");
            }
        }
        return i;
    }

    /* renamed from: a */
    private int m10797a(C2850a mState) {
        switch (mState) {
            case VRSTATE_BUSY_WAKEUP:
                return m10806e();
            case VRSTATE_BUSY_WAKEUP_SCENE_ALL:
                return m10801a(3);
            case VRSTATE_BUSY_WAKEUP_SCENE_NAVI:
                return m10801a(1);
            case VRSTATE_BUSY_WAKEUP_SCENE_MUSIC:
                return m10801a(2);
            case VRSTATE_IDLE:
                return m10805d();
            default:
                return -1;
        }
    }

    /* renamed from: k */
    private void m10800k() {
        if (this.f9339d != C2850a.VRSTATE_IDLE) {
            C2725h.m10207b(f9336a, "restartMode to " + this.f9339d);
            this.f9340e = false;
            m10797a(this.f9339d);
            this.f9339d = C2850a.VRSTATE_IDLE;
        }
    }

    /* renamed from: h */
    protected void m10809h() {
        C2725h.m10207b(f9336a, "new handleWakeupError mCurState = " + this.f9337b + ";mNextState = " + this.f9338c + ";mRestartState = " + this.f9339d);
        if (this.f9340e) {
            this.f9340e = false;
            this.f9337b = C2850a.VRSTATE_IDLE;
            this.f9339d = C2850a.VRSTATE_IDLE;
            this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
            return;
        }
        this.f9339d = C2850a.VRSTATE_IDLE;
        this.f9337b = C2850a.VRSTATE_IDLE;
        this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
    }

    /* renamed from: i */
    protected void m10810i() {
        C2725h.m10207b(f9336a, "handleAsrError mCurState = " + this.f9337b + ";mNextState = " + this.f9338c + ";mRestartState = " + this.f9339d);
        if (this.f9340e) {
            this.f9340e = false;
        }
        this.f9339d = C2850a.VRSTATE_IDLE;
        this.f9337b = C2850a.VRSTATE_IDLE;
        this.f9338c = C2850a.VRSTATE_BUSY_WAITING;
    }

    /* renamed from: a */
    private void m10798a(String functionName) {
        RuntimeException stack = new RuntimeException("stack");
        stack.fillInStackTrace();
        C2725h.m10215e(f9336a, functionName + Config.TRACE_TODAY_VISIT_SPLIT, stack);
    }
}
