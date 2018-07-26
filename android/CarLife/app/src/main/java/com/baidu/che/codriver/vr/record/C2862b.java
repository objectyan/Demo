package com.baidu.che.codriver.vr.record;

import android.content.Context;
import android.media.AudioTrack;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: RecordDataStorager */
/* renamed from: com.baidu.che.codriver.vr.record.b */
public class C2862b {
    /* renamed from: a */
    private static final int f9370a = 65536;
    /* renamed from: b */
    private DataOutputStream f9371b;
    /* renamed from: c */
    private AudioTrack f9372c = null;
    /* renamed from: d */
    private Context f9373d;

    public C2862b(Context context) {
        this.f9373d = context;
    }

    /* renamed from: a */
    public void m10829a() {
        this.f9372c = new AudioTrack(3, 16000, 4, 2, 327680, 1);
    }

    /* renamed from: a */
    public void m10832a(short[] audioData) {
        this.f9372c.write(audioData, 0, audioData.length);
    }

    /* renamed from: a */
    public void m10831a(byte[] audioData) {
        this.f9372c.write(audioData, 0, audioData.length);
    }

    /* renamed from: b */
    public void m10833b() {
        if (this.f9372c.getPlayState() != 3) {
            this.f9372c.play();
        }
    }

    /* renamed from: c */
    public void m10836c() {
        this.f9372c.pause();
    }

    /* renamed from: a */
    public void m10830a(String type) {
        String savePath = this.f9373d.getExternalFilesDir("RecordData").getPath();
        m10837d();
        try {
            File audioFile = new File(savePath + "/" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + type + ".pcm");
            File parent = audioFile.getParentFile();
            if (!(parent == null || parent.exists())) {
                parent.mkdirs();
            }
            if (!audioFile.exists()) {
                audioFile.createNewFile();
            }
            audioFile.setWritable(true);
            this.f9371b = new DataOutputStream(new FileOutputStream(audioFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m10835b(short[] audioData) {
        if (audioData != null && audioData.length > 0) {
            for (short data : audioData) {
                if (this.f9371b != null) {
                    try {
                        this.f9371b.writeShort(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m10834b(byte[] audioData) {
        if (audioData != null && audioData.length > 0) {
            try {
                if (this.f9371b != null) {
                    this.f9371b.write(audioData, 0, audioData.length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public void m10837d() {
        if (this.f9371b != null) {
            try {
                this.f9371b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f9371b = null;
    }
}
