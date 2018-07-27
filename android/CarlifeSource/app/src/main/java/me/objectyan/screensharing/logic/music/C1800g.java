package com.baidu.carlife.logic.music;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.CommonParams.EnumVehicleChannel;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeMediaInfoProto.CarlifeMediaInfo;
import com.baidu.carlife.protobuf.CarlifeMediaInfoProto.CarlifeMediaInfo.Builder;
import com.baidu.carlife.protobuf.CarlifeMediaProgressBarProto.CarlifeMediaProgressBar;
import com.google.protobuf.ByteString;

/* compiled from: MusicInfoSender */
/* renamed from: com.baidu.carlife.logic.music.g */
public class C1800g {
    /* renamed from: a */
    private boolean f5563a;
    /* renamed from: b */
    private Context f5564b;

    protected C1800g(Context context) {
        this.f5564b = context;
    }

    /* renamed from: a */
    protected boolean m6689a() {
        return this.f5563a;
    }

    /* renamed from: b */
    protected void m6690b() {
        this.f5563a = false;
    }

    /* renamed from: a */
    protected void m6688a(MusicSongModel song, byte[] cover, int listLen, int strategy) {
        if (song != null && CarlifeCoreSDK.m5979a().m5993N()) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.m4201c(CommonParams.aC);
            Builder builder = CarlifeMediaInfo.newBuilder();
            if (song.f5911c == null) {
                builder.setAlbum("");
            } else {
                builder.setAlbum(song.f5911c);
            }
            if (song.f5914f == null) {
                builder.setArtist("");
            } else {
                builder.setArtist(song.f5914f);
            }
            try {
                if (m6686c()) {
                    builder.setDuration(Integer.parseInt(song.f5917i));
                } else {
                    builder.setDuration(Integer.parseInt(song.f5917i) / 1000);
                }
            } catch (NumberFormatException e) {
                builder.setDuration(100);
            }
            if (song.f5910b == null) {
                builder.setSong("");
            } else if (CarlifeCoreSDK.m5979a().m5990K()) {
                byte[] tmp = song.f5910b.getBytes();
                int length = tmp.length;
                String subStr = song.f5910b;
                if (length > 31) {
                    byte[] destBytes = new byte[32];
                    System.arraycopy(tmp, 0, destBytes, 0, 32);
                    subStr = new String(destBytes);
                }
                builder.setSong(subStr);
            } else {
                builder.setSong(song.f5910b);
            }
            builder.setMode(strategy);
            builder.setPlaylistNum(listLen);
            if (song.f5909a == null) {
                builder.setSongId("");
            } else {
                builder.setSongId(song.f5909a);
            }
            if (TextUtils.isEmpty(song.f5921m)) {
                builder.setSource("---Inavailable Source Path---");
            } else {
                builder.setSource(song.f5921m);
            }
            if (cover == null || cover.length == 0) {
                builder.setAlbumArt(ByteString.copyFrom(CarlifeUtil.m4358a().m4393a(BitmapFactory.decodeResource(this.f5564b.getResources(), R.drawable.iv_music_pic))));
            } else if (cover.length < 30720) {
                builder.setAlbumArt(ByteString.copyFrom(cover));
            } else {
                try {
                    Bitmap smallImage = Bitmap.createScaledBitmap(song.f5916h, 160, 160, true);
                    cover = CarlifeUtil.m4358a().m4393a(smallImage);
                    int tmp2 = 100;
                    while (cover.length >= 30720 && tmp2 >= 10) {
                        cover = CarlifeUtil.m4358a().m4394a(smallImage, tmp2);
                        tmp2 -= 10;
                    }
                    if (cover.length > 30720) {
                        cover = CarlifeUtil.m4358a().m4393a(BitmapFactory.decodeResource(this.f5564b.getResources(), R.drawable.iv_music_pic));
                    }
                    builder.setAlbumArt(ByteString.copyFrom(cover));
                } catch (Exception e2) {
                    return;
                }
            }
            CarlifeMediaInfo mediaInfo = builder.build();
            command.m4199b(mediaInfo.toByteArray());
            command.m4203d(mediaInfo.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
            this.f5563a = true;
        }
    }

    /* renamed from: a */
    protected void m6687a(int curTime) {
        if (CarlifeCoreSDK.m5979a().m5993N() || !this.f5563a) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.m4201c(CommonParams.aD);
            CarlifeMediaProgressBar.Builder builder = CarlifeMediaProgressBar.newBuilder();
            if (m6686c()) {
                builder.setProgressBar(curTime);
            } else {
                builder.setProgressBar(curTime * 1000);
            }
            CarlifeMediaProgressBar timeStampInfo = builder.build();
            command.m4199b(timeStampInfo.toByteArray());
            command.m4203d(timeStampInfo.getSerializedSize());
            CarlifeCoreSDK.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }

    /* renamed from: c */
    private boolean m6686c() {
        if (CommonParams.m4406a(EnumVehicleChannel.VEHICLE_CHANNEL_HYUNDAI_GRANDSANTEFE) || CommonParams.m4406a(EnumVehicleChannel.VEHICLE_CHANNEL_HYUNDAI) || CommonParams.m4406a(EnumVehicleChannel.VEHICLE_CHANNEL_KIA_KX5) || CommonParams.sVehicleChannel.getChannel().equals("20022107") || CommonParams.sVehicleChannel.getChannel().equals("20022108") || CommonParams.sVehicleChannel.getChannel().equals("20022109") || CommonParams.sVehicleChannel.getChannel().equals("20022110") || CommonParams.sVehicleChannel.getChannel().equals("20032103")) {
            return true;
        }
        return false;
    }
}
