package com.baidu.navisdk.util.common;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.text.TextUtils;
import java.util.Timer;
import java.util.TimerTask;

public class MediaPlayerUtil {
    public static final String TAG = MediaPlayerUtil.class.getSimpleName();
    private static MediaPlayerUtil sInstance;
    private boolean isNeedReInit = true;
    private boolean isPlaying = false;
    private boolean isPreparing = false;
    private MediaPlayer mMediaPlayer = null;
    private Timer mTimer = null;
    private TimerTask mTimerTask = null;

    public interface PlayCallback {
        void responsePlayComplete();

        void responsePlayError();

        void responsePlayPos(int i);

        void startPlay();

        void startPlayFirstTime();

        void startPrepare();

        void stopPrepare();
    }

    public static MediaPlayerUtil getInstance() {
        if (sInstance == null) {
            synchronized (MediaPlayerUtil.class) {
                if (sInstance == null) {
                    sInstance = new MediaPlayerUtil();
                }
            }
        }
        return sInstance;
    }

    public void playAudio(String audioPath, final int startPos, final boolean isRecordPos, final PlayCallback callback) {
        LogUtil.m15791e(TAG, "playAudio");
        if (audioPath != null && !TextUtils.isEmpty(audioPath)) {
            try {
                if (this.mMediaPlayer == null) {
                    this.mMediaPlayer = new MediaPlayer();
                }
                LogUtil.m15791e(TAG, "isNeedReInit = " + this.isNeedReInit);
                if (this.isNeedReInit) {
                    this.mMediaPlayer.setOnPreparedListener(new OnPreparedListener() {
                        public void onPrepared(MediaPlayer mp) {
                            LogUtil.m15791e(MediaPlayerUtil.TAG, "onPrepared");
                            MediaPlayerUtil.this.isPreparing = false;
                            if (callback != null) {
                                callback.stopPrepare();
                            }
                            MediaPlayerUtil.this.mMediaPlayer.seekTo(startPos);
                        }
                    });
                    this.mMediaPlayer.setOnSeekCompleteListener(new OnSeekCompleteListener() {

                        /* renamed from: com.baidu.navisdk.util.common.MediaPlayerUtil$2$1 */
                        class C46191 extends TimerTask {
                            C46191() {
                            }

                            public void run() {
                                if (MediaPlayerUtil.this.mMediaPlayer != null && callback != null && MediaPlayerUtil.this.isPlaying) {
                                    callback.responsePlayPos(MediaPlayerUtil.this.mMediaPlayer.getCurrentPosition());
                                }
                            }
                        }

                        public void onSeekComplete(MediaPlayer mp) {
                            try {
                                if (isRecordPos) {
                                    if (MediaPlayerUtil.this.mTimer == null) {
                                        MediaPlayerUtil.this.mTimer = new Timer();
                                    }
                                    if (MediaPlayerUtil.this.mTimerTask == null) {
                                        MediaPlayerUtil.this.mTimerTask = new C46191();
                                    }
                                    MediaPlayerUtil.this.mTimer.schedule(MediaPlayerUtil.this.mTimerTask, 0, 1000);
                                }
                                MediaPlayerUtil.this.mMediaPlayer.start();
                                if (MediaPlayerUtil.this.mMediaPlayer.isPlaying()) {
                                    MediaPlayerUtil.this.isPlaying = true;
                                    MediaPlayerUtil.this.isNeedReInit = false;
                                    if (callback != null) {
                                        callback.startPlay();
                                        callback.startPlayFirstTime();
                                    }
                                }
                                LogUtil.m15791e(MediaPlayerUtil.TAG, "mMediaPlayer.start()");
                            } catch (Exception e) {
                                LogUtil.m15791e(MediaPlayerUtil.TAG, "playAudio catch onSeekComplete start");
                                if (LogUtil.LOGGABLE) {
                                    e.printStackTrace();
                                }
                                LogUtil.m15791e(MediaPlayerUtil.TAG, "playAudio catch onSeekComplete end");
                            }
                        }
                    });
                    this.mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            LogUtil.m15791e(MediaPlayerUtil.TAG, "onCompletion");
                            if (callback != null) {
                                callback.responsePlayComplete();
                            }
                        }
                    });
                    this.mMediaPlayer.setOnErrorListener(new OnErrorListener() {
                        public boolean onError(MediaPlayer mp, int what, int extra) {
                            LogUtil.m15791e(MediaPlayerUtil.TAG, "onError what = " + what + ", extra = " + extra);
                            if (callback != null) {
                                callback.responsePlayError();
                                callback.stopPrepare();
                            }
                            return true;
                        }
                    });
                    this.mMediaPlayer.reset();
                    this.mMediaPlayer.setDataSource(audioPath);
                    this.mMediaPlayer.prepareAsync();
                    this.isPreparing = true;
                    if (callback != null) {
                        callback.startPrepare();
                        return;
                    }
                    return;
                }
                if (isRecordPos) {
                    if (this.mTimer == null) {
                        this.mTimer = new Timer();
                    }
                    if (this.mTimerTask == null) {
                        this.mTimerTask = new TimerTask() {
                            public void run() {
                                if (MediaPlayerUtil.this.mMediaPlayer != null && callback != null && MediaPlayerUtil.this.isPlaying) {
                                    callback.responsePlayPos(MediaPlayerUtil.this.mMediaPlayer.getCurrentPosition());
                                }
                            }
                        };
                    }
                    this.mTimer.schedule(this.mTimerTask, 0, 1000);
                }
                this.mMediaPlayer.start();
                if (this.mMediaPlayer.isPlaying()) {
                    this.isPlaying = true;
                    if (callback != null) {
                        callback.startPlay();
                    }
                }
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "playAudio catch start");
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                LogUtil.m15791e(TAG, "playAudio catch end");
                if (callback != null) {
                    callback.stopPrepare();
                }
            }
        }
    }

    public void cancelPlayAudio(PlayCallback callback) {
        if (this.mMediaPlayer != null) {
            try {
                if (this.mTimerTask != null) {
                    this.mTimerTask.cancel();
                    this.mTimerTask = null;
                }
                if (this.mTimer != null) {
                    this.mTimer.cancel();
                    this.mTimer = null;
                }
                if (callback != null) {
                    callback.responsePlayPos(this.mMediaPlayer.getCurrentPosition());
                }
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.stop();
                }
                this.mMediaPlayer.release();
                this.mMediaPlayer = null;
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "cancelPlayAudio catch start");
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                LogUtil.m15791e(TAG, "cancelPlayAudio catch end");
            }
        }
        this.isNeedReInit = true;
        this.isPlaying = false;
        this.isPreparing = false;
        if (callback != null) {
            callback.stopPrepare();
        }
    }

    public void pauseAudio() {
        if (this.mMediaPlayer != null) {
            try {
                if (this.mTimerTask != null) {
                    this.mTimerTask.cancel();
                    this.mTimerTask = null;
                }
                if (this.mTimer != null) {
                    this.mTimer.cancel();
                    this.mTimer = null;
                }
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.pause();
                }
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "pauseAudio catch start");
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                LogUtil.m15791e(TAG, "pauseAudio catch end");
            }
        }
        this.isPlaying = false;
    }

    public MediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public boolean isPreparing() {
        return this.isPreparing;
    }

    public void setPreparing(boolean isPreparing) {
        this.isPreparing = isPreparing;
    }
}
