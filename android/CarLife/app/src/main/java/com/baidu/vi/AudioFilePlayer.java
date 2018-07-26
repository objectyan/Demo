package com.baidu.vi;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import java.io.IOException;

public class AudioFilePlayer {
    private static final String TAG = "test";
    private int mHandle;
    private MediaPlayer mMplayer = new MediaPlayer();

    /* renamed from: com.baidu.vi.AudioFilePlayer$1 */
    class C52291 implements OnSeekCompleteListener {
        /* renamed from: a */
        final /* synthetic */ AudioFilePlayer f21724a;

        C52291(AudioFilePlayer this$0) {
            this.f21724a = this$0;
        }

        public void onSeekComplete(MediaPlayer mp) {
            mp.start();
        }
    }

    /* renamed from: com.baidu.vi.AudioFilePlayer$2 */
    class C52302 implements OnCompletionListener {
        /* renamed from: a */
        final /* synthetic */ AudioFilePlayer f21725a;

        C52302(AudioFilePlayer this$0) {
            this.f21725a = this$0;
        }

        public void onCompletion(MediaPlayer mp) {
            this.f21725a.onPlayCompleted(this.f21725a.mHandle);
        }
    }

    /* renamed from: com.baidu.vi.AudioFilePlayer$3 */
    class C52313 implements OnErrorListener {
        /* renamed from: a */
        final /* synthetic */ AudioFilePlayer f21726a;

        C52313(AudioFilePlayer this$0) {
            this.f21726a = this$0;
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            return this.f21726a.onErrorOccured(this.f21726a.mHandle, what);
        }
    }

    private native boolean onErrorOccured(int i, int i2);

    private native void onPlayCompleted(int i);

    private AudioFilePlayer() {
    }

    private void SetDataSource(String path) throws IllegalArgumentException, IllegalStateException, IOException {
        this.mMplayer.setDataSource(path);
        Prepare();
    }

    private void Prepare() throws IllegalStateException, IOException {
        this.mMplayer.prepare();
    }

    private void Start() throws IllegalStateException, IOException {
        this.mMplayer.start();
    }

    private void Pause() {
        this.mMplayer.pause();
    }

    private void Stop() {
        this.mMplayer.stop();
    }

    private void Release() {
        this.mMplayer.release();
    }

    private void Reset() {
        this.mMplayer.reset();
    }

    private boolean IsPlaying() {
        return this.mMplayer.isPlaying();
    }

    private int GetCurrentPosition() {
        return this.mMplayer.getCurrentPosition() / 1000;
    }

    private int GetDuration() {
        return this.mMplayer.getDuration() / 1000;
    }

    private void SeekTo(int sec) {
        this.mMplayer.setOnSeekCompleteListener(new C52291(this));
        if (sec <= GetDuration() && sec >= 0) {
            this.mMplayer.seekTo(sec * 1000);
        }
    }

    private static float GetVolume() {
        AudioManager am = (AudioManager) VIContext.getContext().getSystemService("audio");
        return ((float) am.getStreamVolume(3)) / ((float) GetMaxVolume(am));
    }

    private static int GetMaxVolume(AudioManager am) {
        return am.getStreamMaxVolume(3);
    }

    private static void SetVolume(float iVolume) {
        AudioManager am = (AudioManager) VIContext.getContext().getSystemService("audio");
        int max_volume = GetMaxVolume(am);
        if (iVolume >= 0.0f && iVolume <= 1.0f) {
            am.setStreamVolume(3, (int) (((float) max_volume) * iVolume), 0);
        }
    }

    private void SetOnPlayCompletedListener(int handle) {
        this.mMplayer.setOnCompletionListener(new C52302(this));
        this.mHandle = handle;
    }

    private void SetOnErrorListener(int handle) {
        this.mMplayer.setOnErrorListener(new C52313(this));
        this.mHandle = handle;
    }
}
