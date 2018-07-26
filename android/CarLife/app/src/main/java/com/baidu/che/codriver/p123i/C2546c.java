package com.baidu.che.codriver.p123i;

import com.baidu.navi.util.StatisticConstants;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;

/* compiled from: VrParams */
/* renamed from: com.baidu.che.codriver.i.c */
public class C2546c {
    /* renamed from: A */
    public static final int f8405A = 3;
    /* renamed from: B */
    public static final int f8406B = 16000;
    /* renamed from: C */
    public static final int f8407C = 2;
    /* renamed from: D */
    public static final int f8408D = 0;
    /* renamed from: E */
    public static final float f8409E = 0.25f;
    /* renamed from: F */
    public static final int f8410F = 40;
    /* renamed from: G */
    public static final int f8411G = 490;
    /* renamed from: H */
    public static final int f8412H = 50;
    /* renamed from: I */
    public static final float f8413I = 0.15f;
    /* renamed from: J */
    public static final int f8414J = 6000;
    /* renamed from: K */
    public static final boolean f8415K = true;
    /* renamed from: L */
    public static final int f8416L = 0;
    /* renamed from: M */
    public static final int f8417M = 1;
    /* renamed from: N */
    public static final boolean f8418N = false;
    /* renamed from: O */
    public static final boolean f8419O = true;
    /* renamed from: P */
    public static final boolean f8420P = false;
    /* renamed from: Q */
    public static final int f8421Q = 0;
    /* renamed from: R */
    public static final int f8422R = 306;
    /* renamed from: S */
    public static final String f8423S = "WakeUp_Xiaodu.bin";
    /* renamed from: T */
    public static final String f8424T = "libbaidu_asr_licence_carlife.dat.so";
    /* renamed from: U */
    public static final String f8425U = "libbaidu_carlife_offline_cmd_grammar.bsg.so";
    /* renamed from: V */
    public static final String f8426V = "libbaidu_offline_cmd_grammar.bsg.so";
    /* renamed from: W */
    public static final String f8427W = "libbd_easr_s1_kws_codriver_20170913.dat.so";
    /* renamed from: X */
    public static final String f8428X = "esis_codriver_20180119.pkg";
    /* renamed from: Y */
    public static final String f8429Y = "libvad.dnn.so";
    /* renamed from: Z */
    public static final String f8430Z = "enable-all";
    /* renamed from: a */
    public static final int f8431a = 8888;
    public static final String aA = "audio.mills";
    public static final String aB = "decoder-server.ptc";
    public static final String aC = "kwd.volume";
    public static final String aD = "kwd.enable-all-keywords";
    public static final String aE = "kwd.enable-keyword";
    public static final String aF = "vad.max-wait-duration";
    public static final String aG = "vad.head-sil-duration";
    public static final String aH = "vad-mfe.params-9";
    public static final String aI = "decoder-server.agent.url";
    public static final String aJ = "decoder-server.auth";
    public static final String aK = "lm-res-file-path";
    public static final String aL = "name";
    public static final String aM = "song";
    public static final String aN = "singer";
    public static final String aO = "asr.ready";
    public static final String aP = "asr.sn";
    public static final String aQ = "asr.begin";
    public static final String aR = "asr.audio";
    public static final String aS = "asr.volume";
    public static final String aT = "asr.end";
    public static final String aU = "asr.partial";
    public static final String aV = "asr.final";
    public static final String aW = "asr.finish";
    public static final String aX = "asr.exit";
    public static final String aY = "asr.cancel";
    public static final String aZ = "asr.error";
    public static final String aa = "enable";
    public static final String ab = "disable";
    public static final String ac = "search";
    public static final String ad = "input";
    public static final String ae = "touch";
    public static final String af = "model-vad";
    public static final String ag = "dnn";
    public static final int ah = 1;
    public static final int ai = 0;
    public static final int aj = -1;
    public static final String ak = "asr";
    public static final String al = "slot";
    public static final String am = "wp";
    public static final String an = "kwd.config";
    public static final String ao = "slot.start";
    public static final String ap = "key";
    public static final String aq = "pid";
    public static final String ar = "url";
    public static final String as = "auth";
    public static final String at = "decoder-server.pdt";
    public static final String au = "license";
    public static final String av = "res-file";
    public static final String aw = "wp.mode";
    public static final String ax = "decoder-server.fix-app";
    public static final String ay = "basic.decoder";
    public static final String az = "decoder-server-fun.contact";
    /* renamed from: b */
    public static final int f8432b = 1;
    public static final String ba = "asr.loaded";
    public static final String bb = "asr.unloaded";
    public static final String bc = "asr.sn";
    public static final String bd = "asr.log";
    public static final String be = "wp.loaded";
    public static final String bf = "wp.unloaded";
    public static final String bg = "wp.enter";
    public static final String bh = "wp.ready";
    public static final String bi = "wp.stoped";
    public static final String bj = "wp.data";
    public static final String bk = "wp.exit";
    public static final String bl = "wp.error";
    public static final String bm = "";
    public static final String[] bn = new String[]{"白天模式", "黑夜模式", "跟随模式", "车头朝上", "正北模式", "查看全程", "关闭电子狗", "打开电子狗", "打开路况", "关闭路况", "放大地图", "缩小地图", FsmEvent.CONTINUE_NAVI, "关闭导航", "结束导航", "开始导航", "第一个", "第二个", "第三个", "取消", "确定"};
    public static final String[] bo = new String[]{"播放音乐", "暂停播放", StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PRE, "上一曲", StatisticConstants.HOME_MUSIC_STATUS_CHANGE_NEXT, "下一曲", "继续播放"};
    public static final String bp = "白天模式,黑夜模式,跟随模式,车头朝上,正北模式,查看全程,关闭电子狗,打开电子狗,打开路况,关闭路况,放大地图,缩小地图,继续导航,关闭导航,结束导航,开始导航,第一个,第二个,第三个,取消,确定,播放音乐,暂停播放,上一首,上一曲,下一首,下一曲,继续播放";
    /* renamed from: c */
    public static final int f8433c = 2;
    /* renamed from: d */
    public static final int f8434d = 3;
    /* renamed from: e */
    public static final String f8435e = "wake_up";
    /* renamed from: f */
    public static final String f8436f = "save_wake_up_rdata";
    /* renamed from: g */
    public static final String f8437g = "save_asr_rdata";
    /* renamed from: h */
    public static final String f8438h = "save_pcm_data_key";
    /* renamed from: i */
    public static final String f8439i = "scene_command_key";
    /* renamed from: j */
    public static final String f8440j = "wakeup_word";
    /* renamed from: k */
    public static final String f8441k = "support_aec";
    /* renamed from: l */
    public static final String f8442l = "support_full_bargin";
    /* renamed from: m */
    public static final String f8443m = "one_shot";
    /* renamed from: n */
    public static final int f8444n = 811;
    /* renamed from: o */
    public static final String f8445o = "com.baidu.che.codriver";
    /* renamed from: p */
    public static final String f8446p = "enable";
    /* renamed from: q */
    public static final String f8447q = "dnn";
    /* renamed from: r */
    public static final String f8448r = "com.baidu.carlife";
    /* renamed from: s */
    public static final String f8449s = "http://vse.baidu.com/v2";
    /* renamed from: t */
    public static final String f8450t = "http://vse.baidu.com/echo.fcgi";
    /* renamed from: u */
    public static final String f8451u = "小度小度";
    /* renamed from: v */
    public static final String f8452v = "你好现代";
    /* renamed from: w */
    public static final String f8453w = "你好起亚";
    /* renamed from: x */
    public static final String f8454x = "你好北京现代";
    /* renamed from: y */
    public static final String f8455y = ",";
    /* renamed from: z */
    public static final boolean f8456z = false;
}
