package com.baidu.carlife.logic.music;

import android.text.TextUtils;
import com.baidu.carlife.model.MusicSongModel;
import java.util.List;

/* compiled from: MusicSearcher */
/* renamed from: com.baidu.carlife.logic.music.i */
public class C1819i {
    /* renamed from: a */
    private static int f5639a = -1;

    /* renamed from: a */
    public static int m6840a(List<MusicSongModel> srcList, List<MusicSongModel> destList) {
        destList.clear();
        int count = 0;
        for (MusicSongModel tmp : srcList) {
            destList.add(tmp);
            count++;
        }
        return count;
    }

    /* renamed from: a */
    public static int m6841a(List<MusicSongModel> srcList, List<MusicSongModel> destList, String singer) {
        if (srcList == null || srcList.isEmpty() || destList == null || TextUtils.isEmpty(singer)) {
            return -1;
        }
        destList.clear();
        int count = 0;
        for (MusicSongModel tmp : srcList) {
            if (singer.equals(tmp.f5914f)) {
                destList.add(tmp);
                count++;
            }
        }
        return count;
    }

    /* renamed from: b */
    public static int m6844b(List<MusicSongModel> srcList, List<MusicSongModel> destList, String songName) {
        if (srcList == null || srcList.isEmpty() || destList == null || TextUtils.isEmpty(songName)) {
            return -1;
        }
        destList.clear();
        int count = 0;
        for (MusicSongModel tmp : srcList) {
            if (tmp.f5910b != null && tmp.f5910b.contains(songName)) {
                destList.add(tmp);
                count++;
            }
        }
        return count;
    }

    /* renamed from: a */
    public static int m6842a(List<MusicSongModel> srcList, List<MusicSongModel> destList, String songName, String singer) {
        if (srcList == null || srcList.isEmpty() || destList == null || TextUtils.isEmpty(songName) || TextUtils.isEmpty(singer)) {
            return -1;
        }
        destList.clear();
        int count = 0;
        for (MusicSongModel tmp : srcList) {
            if (tmp.f5910b != null && tmp.f5910b.contains(songName) && singer.equals(tmp.f5914f)) {
                destList.add(tmp);
                count++;
            }
        }
        return count;
    }

    /* renamed from: a */
    public static void m6843a(int index) {
        f5639a = index;
    }

    /* renamed from: a */
    public static int m6839a(int strategy, int listLength, int index, boolean isNext, boolean isManual) {
        if (isNext) {
            switch (strategy) {
                case 0:
                    if (isManual) {
                        return C1819i.m6839a(2, listLength, index, isNext, isManual);
                    }
                    return index;
                case 1:
                    if (f5639a == -1 || f5639a >= listLength) {
                        return (int) (Math.random() * ((double) listLength));
                    }
                    int ret = f5639a;
                    f5639a = -1;
                    return ret;
                case 2:
                    if (index == listLength - 1) {
                        return 0;
                    }
                    return index + 1;
                default:
                    return index + 1;
            }
        }
        switch (strategy) {
            case 0:
                if (isManual) {
                    return C1819i.m6839a(2, listLength, index, isNext, isManual);
                }
                return index;
            case 1:
                return (int) (Math.random() * ((double) listLength));
            case 2:
                if (index == 0) {
                    return listLength - 1;
                }
                return index - 1;
            default:
                return index - 1;
        }
    }
}
