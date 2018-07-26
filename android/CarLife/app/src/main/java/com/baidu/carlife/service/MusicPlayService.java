package com.baidu.carlife.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.logic.music.C1795c;
import com.baidu.carlife.logic.music.C1802m;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1829n;
import com.baidu.carlife.logic.music.C1830o;
import com.baidu.carlife.logic.p088a.C1702j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p087l.C1663a;
import java.io.IOException;
import java.util.ArrayList;

public class MusicPlayService extends Service {
    /* renamed from: b */
    private static final String f6897b = "MusicPlayService";
    /* renamed from: a */
    public C1830o f6898a = new C21631(this);
    /* renamed from: c */
    private C1663a f6899c;
    /* renamed from: d */
    private int f6900d = -1;
    /* renamed from: e */
    private MusicSongModel f6901e;
    /* renamed from: f */
    private C1802m f6902f;
    /* renamed from: g */
    private C1829n f6903g;

    /* renamed from: com.baidu.carlife.service.MusicPlayService$1 */
    class C21631 implements C1830o {
        /* renamed from: a */
        final /* synthetic */ MusicPlayService f6895a;

        C21631(MusicPlayService this$0) {
            this.f6895a = this$0;
        }

        /* renamed from: a */
        public void mo1789a(boolean isManual) {
            this.f6895a.f6902f.mo1669a(isManual);
        }

        /* renamed from: a */
        public void mo1785a() {
            this.f6895a.f6902f.mo1670b();
        }

        /* renamed from: a */
        public void mo1788a(String duration) {
            this.f6895a.f6901e.f5917i = duration;
            this.f6895a.f6902f.mo1667a();
        }

        /* renamed from: a */
        public void mo1786a(int sampleRate, int channels, int bitsPerSample) {
            this.f6895a.f6899c.m6005a(sampleRate, channels, bitsPerSample);
        }

        /* renamed from: a */
        public void mo1790a(byte[] buffer, int size) {
            this.f6895a.f6899c.m6016a(buffer, size);
        }

        /* renamed from: b */
        public void mo1791b() {
            this.f6895a.f6899c.m6059z();
        }

        /* renamed from: c */
        public void mo1792c() {
            this.f6895a.f6899c.m5980A();
        }

        /* renamed from: d */
        public void mo1793d() {
            this.f6895a.f6899c.m6058y();
        }

        /* renamed from: a */
        public void mo1787a(int errorType, int errorCode1, int errorCode2, Object errorObj) {
            this.f6895a.f6902f.mo1668a(errorType, errorCode1, errorCode2, errorObj);
        }
    }

    /* renamed from: com.baidu.carlife.service.MusicPlayService$a */
    public class C2164a extends Binder {
        /* renamed from: a */
        final /* synthetic */ MusicPlayService f6896a;

        public C2164a(MusicPlayService this$0) {
            this.f6896a = this$0;
        }

        /* renamed from: a */
        public void m8188a(C1802m listener) {
            this.f6896a.f6902f = listener;
        }

        /* renamed from: a */
        public void m8184a() {
            this.f6896a.m8193a();
        }

        /* renamed from: a */
        public void m8185a(int type) {
            this.f6896a.m8194a(type);
        }

        /* renamed from: a */
        public void m8186a(int type, MusicSongModel song) {
            m8187a(type, song, null);
        }

        /* renamed from: a */
        public void m8187a(int type, MusicSongModel song, ArrayList<String> fileList) {
            this.f6896a.m8195a(type, song, fileList);
        }

        /* renamed from: b */
        public void m8189b() {
            this.f6896a.m8201c();
        }

        /* renamed from: c */
        public void m8190c() {
            this.f6896a.m8203d();
        }

        /* renamed from: d */
        public void m8191d() {
            this.f6896a.m8199b();
        }
    }

    public void onCreate() {
        super.onCreate();
        this.f6899c = C1663a.m5979a();
        this.f6903g = new C1829n(this.f6898a);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return 2;
    }

    public IBinder onBind(Intent arg0) {
        return new C2164a(this);
    }

    public void onDestroy() {
        C1260i.m4435b(f6897b, "-----MusicPlayService--onDestroy----");
        this.f6899c.m6056w();
        super.onDestroy();
    }

    /* renamed from: a */
    private void m8193a() {
        if (this.f6900d != 1) {
            this.f6899c.m6054u();
        } else if (this.f6901e.f5921m != null) {
            this.f6899c.m6054u();
        } else {
            this.f6903g.m6908c();
        }
    }

    /* renamed from: a */
    private void m8194a(int type) {
        if (type == 0 || type == 2 || type >= 3) {
            this.f6899c.m6055v();
        } else if (type != 1) {
        } else {
            if (this.f6901e.f5921m != null) {
                this.f6899c.m6055v();
            } else {
                this.f6903g.m6909d();
            }
        }
    }

    /* renamed from: a */
    private void m8195a(int type, MusicSongModel song, ArrayList<String> fileList) {
        if (song != null && C1818h.m6745i(type)) {
            this.f6900d = type;
            this.f6901e = song;
            if (type == 1 && this.f6901e.f5921m == null) {
                this.f6903g.m6906a(this.f6901e.f5909a);
                return;
            }
            String path = this.f6901e.f5921m;
            if (fileList != null) {
                path = (String) fileList.get(0);
                this.f6899c.m6014a(path, (ArrayList) fileList);
            } else {
                this.f6899c.m6013a(path);
            }
            C1260i.m4435b(f6897b, "---startPlay----path:" + path);
            MediaPlayer mediaPlayer;
            int i;
            if (this.f6900d == 0) {
                if (this.f6901e.f5917i == null) {
                    mediaPlayer = new MediaPlayer();
                    i = 0;
                    try {
                        mediaPlayer.setDataSource(path);
                        mediaPlayer.setAudioStreamType(3);
                        mediaPlayer.prepare();
                        i = mediaPlayer.getDuration();
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
                    this.f6901e.f5917i = String.valueOf(i);
                }
            } else if (this.f6900d == 101) {
                C1795c.m6660a().m6666a(1, C1702j.m6181a().m6188c());
                if (C1702j.m6181a().m6192g()) {
                    this.f6901e.m7365h("7200000");
                } else if (this.f6901e.f5922n >= this.f6901e.f5923o) {
                    mediaPlayer = new MediaPlayer();
                    i = 0;
                    try {
                        mediaPlayer.setDataSource(path);
                        mediaPlayer.setAudioStreamType(3);
                        mediaPlayer.prepare();
                        i = mediaPlayer.getDuration();
                        mediaPlayer.release();
                    } catch (IllegalArgumentException e5) {
                        e5.printStackTrace();
                    } catch (SecurityException e22) {
                        e22.printStackTrace();
                    } catch (IllegalStateException e32) {
                        e32.printStackTrace();
                    } catch (IOException e42) {
                        e42.printStackTrace();
                    }
                    this.f6901e.f5917i = String.valueOf(i);
                } else {
                    this.f6901e.f5917i = "600000";
                }
            }
            if (this.f6902f != null) {
                this.f6902f.mo1667a();
            }
        }
    }

    /* renamed from: b */
    private void m8199b() {
        this.f6899c.m6057x();
    }

    /* renamed from: c */
    private void m8201c() {
        this.f6899c.m5986G();
    }

    /* renamed from: d */
    private void m8203d() {
        this.f6899c.m5987H();
    }
}
