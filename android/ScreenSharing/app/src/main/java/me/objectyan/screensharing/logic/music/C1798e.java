package com.baidu.carlife.logic.music;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import com.baidu.carlife.R;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.carlife.util.C2170a;
import com.baidu.carlife.util.C2186p;
import com.baidu.navi.utils.CharacterParser;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: LocalMusicDataManager */
/* renamed from: com.baidu.carlife.logic.music.e */
public class C1798e extends C1790b {
    /* renamed from: T */
    private static final String f5524T = "content://media/external/audio/albums";
    /* renamed from: U */
    private static final String[] f5525U = new String[]{"_data", "title", C2125n.f6756X, "album_id", "artist", "duration", "title_key", "_id"};
    /* renamed from: V */
    private static final int f5526V = 0;
    /* renamed from: W */
    private static final int f5527W = 1;
    /* renamed from: X */
    private static final int f5528X = 2;
    /* renamed from: Y */
    private static final int f5529Y = 3;
    /* renamed from: Z */
    private static final int f5530Z = 4;
    private static final int aa = 5;
    private static final int ab = 6;
    private static final int ac = 7;
    private static final String ad = "LocalMusicIndex";

    /* compiled from: LocalMusicDataManager */
    /* renamed from: com.baidu.carlife.logic.music.e$1 */
    class C17971 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1798e f5523a;

        C17971(C1798e this$0) {
            this.f5523a = this$0;
        }

        public void run() {
            this.f5523a.m6608a(this.f5523a.m6644n(), this.f5523a.m6674A());
            this.f5523a.m6627f(this.f5523a.m6671B());
            if (this.f5523a.mo1659g() == null || this.f5523a.mo1659g().isEmpty()) {
                this.f5523a.m6611b(3);
            } else {
                this.f5523a.m6611b(2);
            }
        }
    }

    public C1798e(Context context) {
        this.E = C1785a.f5429a[0];
        m6623e(this.E);
        m6606a(context.getResources().getString(R.string.music_local));
        this.C = context;
        this.F = 0;
        m6599a(1);
        new Thread(new C17971(this)).start();
    }

    /* renamed from: g */
    public List<MusicSongModel> mo1659g() {
        return m6625f(m6644n());
    }

    /* renamed from: z */
    public void mo1661z() {
        LogUtil.d("ouyang", "---setLocalMusicRecentIndex:" + this.B);
        C2186p.m8304a().m8317b(ad, this.B);
    }

    /* renamed from: k */
    public int m6683k(String name) {
        if (name == null || name.isEmpty()) {
            return -1;
        }
        int index = 0;
        List<MusicSongModel> list = mo1659g();
        if (list == null) {
            return -1;
        }
        for (MusicSongModel song : list) {
            if (song.f5910b.contains(name)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /* renamed from: l */
    public int m6684l(String singer) {
        if (singer == null || singer.isEmpty()) {
            return -1;
        }
        int index = 0;
        List<MusicSongModel> list = mo1659g();
        if (list == null) {
            return -1;
        }
        for (MusicSongModel song : list) {
            if (song.f5914f.contains(singer)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /* renamed from: a */
    public int m6676a(String singer, String name) {
        if (singer == null || singer.isEmpty()) {
            return -1;
        }
        int index = 0;
        List<MusicSongModel> list = mo1659g();
        if (list == null) {
            return -1;
        }
        for (MusicSongModel song : list) {
            if (song.f5914f.contains(singer) && song.f5910b.contains(name)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /* renamed from: d */
    public Bitmap mo1656d(String songId) {
        if (TextUtils.isEmpty(songId)) {
            return null;
        }
        MusicSongModel song = m6631h(songId);
        try {
            return C2170a.m8216a(this.C, Long.parseLong(song.f5909a), Long.parseLong(song.f5912d), true);
        } catch (NumberFormatException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    @Deprecated
    /* renamed from: d */
    public void mo1657d(int type) {
    }

    @Deprecated
    /* renamed from: e */
    public boolean mo1658e(int type) {
        return false;
    }

    @Deprecated
    /* renamed from: a */
    public int mo1654a(int albumType, String listId) {
        return 0;
    }

    @Deprecated
    /* renamed from: b */
    public void mo1655b(boolean isManual) {
    }

    @Deprecated
    /* renamed from: h */
    public void mo1660h() {
    }

    /* renamed from: A */
    protected List<MusicSongModel> m6674A() {
        ArrayList<MusicSongModel> musicList = new ArrayList();
        C1838q.f5700T.clear();
        if (this.C != null) {
            try {
                Cursor musicCursor = this.C.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, f5525U, null, null, " date_added DESC");
                if (musicCursor != null && musicCursor.getCount() > 0) {
                    musicCursor.moveToFirst();
                    while (!musicCursor.isAfterLast()) {
                        boolean isQQMusicDownloaded = false;
                        MusicSongModel musicModel = new MusicSongModel();
                        String musicPath = musicCursor.getString(0);
                        musicModel.f5921m = musicPath;
                        if (!TextUtils.isEmpty(musicPath) && new File(musicPath).exists()) {
                            String[] dirTmp = musicPath.split("/");
                            if (dirTmp.length > 1) {
                                String dir1 = dirTmp[dirTmp.length - 2];
                                String dir2 = "";
                                if (dirTmp.length > 2) {
                                    dir2 = dirTmp[dirTmp.length - 3];
                                }
                                if (!dir1.equals("BaiduCarlife")) {
                                    if (dir2.equals("qqmusic")) {
                                        isQQMusicDownloaded = true;
                                    } else {
                                        boolean shouldIgnore = false;
                                        for (int i = 0; i < dirTmp.length - 1; i++) {
                                            if (dirTmp[i].toLowerCase(Locale.getDefault()).contains("record")) {
                                                shouldIgnore = true;
                                                break;
                                            }
                                        }
                                        if (shouldIgnore) {
                                        }
                                    }
                                }
                            }
                            musicModel.f5910b = musicCursor.getString(1);
                            musicModel.f5911c = musicCursor.getString(2);
                            musicModel.f5912d = Integer.toString(musicCursor.getInt(3));
                            String musicArtist = musicCursor.getString(4);
                            musicModel.f5914f = musicArtist;
                            long musicDuration = musicCursor.getLong(5);
                            if (musicDuration == 0) {
                                MediaPlayer mediaPlayer = new MediaPlayer();
                                try {
                                    mediaPlayer.setDataSource(musicPath);
                                    mediaPlayer.setAudioStreamType(3);
                                    mediaPlayer.prepare();
                                    musicDuration = (long) mediaPlayer.getDuration();
                                    mediaPlayer.release();
                                } catch (IllegalArgumentException e) {
                                    e.printStackTrace();
                                } catch (SecurityException e2) {
                                    e2.printStackTrace();
                                } catch (IllegalStateException e3) {
                                    e3.printStackTrace();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (musicDuration >= 61000 && musicDuration <= 600000) {
                                musicModel.f5917i = String.valueOf(musicDuration);
                                musicModel.f5909a = String.valueOf(musicCursor.getLong(7));
                                musicModel.f5915g = musicModel.f5909a;
                                if (TextUtils.isEmpty(musicArtist)) {
                                    musicModel.f5924p = "Z";
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    CharacterParser.getAbbreviation(musicArtist.substring(0, 1), sb);
                                    musicModel.f5924p = new String(sb).toUpperCase();
                                }
                                musicList.add(musicModel);
                                if (isQQMusicDownloaded) {
                                    C1838q.f5700T.add(musicModel);
                                }
                            }
                        }
                        musicCursor.moveToNext();
                    }
                }
                if (musicCursor != null) {
                    musicCursor.close();
                }
            } catch (Exception e5) {
            }
        }
        return musicList;
    }

    /* renamed from: m */
    private Bitmap m6673m(String url) {
        IOException e;
        try {
            Cursor cur = this.C.getContentResolver().query(Uri.parse(url), new String[]{"album_art"}, null, null, null);
            if (cur == null) {
                return null;
            }
            String albumArt = null;
            if (cur.getCount() > 0 && cur.getColumnCount() > 0) {
                cur.moveToNext();
                albumArt = cur.getString(0);
            }
            cur.close();
            if (albumArt == null || albumArt.equals("")) {
                return null;
            }
            File file = new File(albumArt);
            int count = 0;
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fin = new FileInputStream(file);
                if (fin != null) {
                    try {
                        int readByte = fin.read();
                        while (readByte != 255 && readByte != RouteLineResConst.LINE_DARK_RED_FOCUS) {
                            count++;
                            readByte = fin.read();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream = fin;
                        e.printStackTrace();
                        if (fileInputStream == null) {
                            return null;
                        }
                        try {
                            return BitmapFactory.decodeStream(fileInputStream);
                        } catch (OutOfMemoryError e3) {
                            return null;
                        }
                    }
                }
                fin.close();
                fileInputStream = new FileInputStream(file);
                fileInputStream.skip((long) count);
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                if (fileInputStream == null) {
                    return BitmapFactory.decodeStream(fileInputStream);
                }
                return null;
            }
            if (fileInputStream == null) {
                return null;
            }
            return BitmapFactory.decodeStream(fileInputStream);
        } catch (IllegalStateException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* renamed from: B */
    private int m6671B() {
        List<MusicSongModel> list = mo1659g();
        int index = C2186p.m8304a().m8307a(ad, 0);
        LogUtil.d("ouyang", "---getLocalMusicRecentIndex:" + index);
        if (list == null || index >= list.size()) {
            return 0;
        }
        return new File(((MusicSongModel) list.get(index)).f5921m).exists() ? index : 0;
    }
}
