package com.baidu.carlife.logic.music;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

/* compiled from: MusicSourceSwitchListener */
/* renamed from: com.baidu.carlife.logic.music.j */
public class C1820j implements OnItemClickListener {
    /* renamed from: a */
    public static final String f5640a = "LeftBarIndex";
    /* renamed from: c */
    private static int f5641c = 0;
    /* renamed from: b */
    private Context f5642b;
    /* renamed from: d */
    private C1531a f5643d;

    /* compiled from: MusicSourceSwitchListener */
    /* renamed from: com.baidu.carlife.logic.music.j$a */
    public interface C1531a {
        /* renamed from: a */
        void mo1582a();
    }

    public C1820j(Context context) {
        this.f5642b = context;
    }

    /* renamed from: a */
    public static void m6845a(int index) {
        f5641c = index;
    }

    /* renamed from: a */
    public void m6847a(C1531a callBack) {
        this.f5643d = callBack;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        if (f5641c == pos) {
            if (this.f5643d != null) {
                this.f5643d.mo1582a();
            }
        } else if (C1772k.m6480a().m6489c() != 0) {
            C2201w.m8371a((int) C0965R.string.phone_status_busy_music, 1);
        } else {
            C1818h.m6730b().m6801d(pos);
            NaviFragmentManager fragManager = C1328h.m4757a().getNaviFragmentManager();
            C1790b dataManager = C1818h.m6730b().m6830r();
            Bundle arg = new Bundle();
            arg.putBoolean(C1790b.f5466i, true);
            ContentFragment curFrag = fragManager.getCurrentFragment();
            if (curFrag != null) {
                if (dataManager.m6652v() == 1) {
                    if (curFrag.getType() == NaviFragmentManager.TYPE_MUSIC_PLAYER) {
                        curFrag.getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                        curFrag.onStart();
                    } else {
                        ContentFragment frag = fragManager.getLatestFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER);
                        if (frag != null && frag.isHidden()) {
                            frag.getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                            frag.onStart();
                        }
                        fragManager.showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, arg);
                    }
                } else if (dataManager.m6652v() == 0) {
                    if (curFrag.getType() == NaviFragmentManager.TYPE_MUSIC_ALBUMLIST) {
                        curFrag.getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                        curFrag.onStart();
                    } else {
                        fragManager.showFragment(NaviFragmentManager.TYPE_MUSIC_ALBUMLIST, arg);
                    }
                }
                m6846b(pos);
                C1820j.m6845a(pos);
                if (this.f5643d != null) {
                    this.f5643d.mo1582a();
                }
            }
        }
    }

    /* renamed from: b */
    private void m6846b(int pos) {
        switch (pos) {
            case 1:
                StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0001);
                return;
            case 2:
                StatisticManager.onEvent(StatisticConstants.MUSIC_NETEASE_0001);
                return;
            case 3:
                StatisticManager.onEvent(StatisticConstants.MUSIC_XMLY_0001);
                return;
            case 4:
                StatisticManager.onEvent(StatisticConstants.MUSIC_KAOLA_0001);
                return;
            case 5:
                StatisticManager.onEvent(StatisticConstants.MUSIC_CYB_0001);
                return;
            default:
                return;
        }
    }
}
