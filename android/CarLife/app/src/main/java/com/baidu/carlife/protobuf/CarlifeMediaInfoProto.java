package com.baidu.carlife.protobuf;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class CarlifeMediaInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfo_descriptor */
    private static Descriptor f6629xbc894558;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfo_fieldAccessorTable */
    private static FieldAccessorTable f6630xb06993d6;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeMediaInfoProto$1 */
    static class C20691 implements InternalDescriptorAssigner {
        C20691() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeMediaInfoProto.descriptor = root;
            CarlifeMediaInfoProto.f6629xbc894558 = (Descriptor) CarlifeMediaInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeMediaInfoProto.f6630xb06993d6 = new FieldAccessorTable(CarlifeMediaInfoProto.f6629xbc894558, new String[]{"Source", "Song", "Artist", "Album", "AlbumArt", "Duration", "PlaylistNum", "SongId", JNISearchConst.JNI_MODE}, CarlifeMediaInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeMediaInfo extends GeneratedMessage {
        public static final int ALBUMART_FIELD_NUMBER = 5;
        public static final int ALBUM_FIELD_NUMBER = 4;
        public static final int ARTIST_FIELD_NUMBER = 3;
        public static final int DURATION_FIELD_NUMBER = 6;
        public static final int MODE_FIELD_NUMBER = 9;
        public static final int PLAYLISTNUM_FIELD_NUMBER = 7;
        public static final int SONGID_FIELD_NUMBER = 8;
        public static final int SONG_FIELD_NUMBER = 2;
        public static final int SOURCE_FIELD_NUMBER = 1;
        private static final CarlifeMediaInfo defaultInstance = new CarlifeMediaInfo();
        private ByteString albumArt_;
        private String album_;
        private String artist_;
        private int duration_;
        private boolean hasAlbum;
        private boolean hasAlbumArt;
        private boolean hasArtist;
        private boolean hasDuration;
        private boolean hasMode;
        private boolean hasPlaylistNum;
        private boolean hasSong;
        private boolean hasSongId;
        private boolean hasSource;
        private int memoizedSerializedSize;
        private int mode_;
        private int playlistNum_;
        private String songId_;
        private String song_;
        private String source_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeMediaInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeMediaInfo();
                return builder;
            }

            protected CarlifeMediaInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeMediaInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeMediaInfo.getDescriptor();
            }

            public CarlifeMediaInfo getDefaultInstanceForType() {
                return CarlifeMediaInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeMediaInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeMediaInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeMediaInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeMediaInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeMediaInfo) {
                    return mergeFrom((CarlifeMediaInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeMediaInfo other) {
                if (other != CarlifeMediaInfo.getDefaultInstance()) {
                    if (other.hasSource()) {
                        setSource(other.getSource());
                    }
                    if (other.hasSong()) {
                        setSong(other.getSong());
                    }
                    if (other.hasArtist()) {
                        setArtist(other.getArtist());
                    }
                    if (other.hasAlbum()) {
                        setAlbum(other.getAlbum());
                    }
                    if (other.hasAlbumArt()) {
                        setAlbumArt(other.getAlbumArt());
                    }
                    if (other.hasDuration()) {
                        setDuration(other.getDuration());
                    }
                    if (other.hasPlaylistNum()) {
                        setPlaylistNum(other.getPlaylistNum());
                    }
                    if (other.hasSongId()) {
                        setSongId(other.getSongId());
                    }
                    if (other.hasMode()) {
                        setMode(other.getMode());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            break;
                        case 10:
                            setSource(input.readString());
                            continue;
                        case 18:
                            setSong(input.readString());
                            continue;
                        case 26:
                            setArtist(input.readString());
                            continue;
                        case 34:
                            setAlbum(input.readString());
                            continue;
                        case 42:
                            setAlbumArt(input.readBytes());
                            continue;
                        case 48:
                            setDuration(input.readInt32());
                            continue;
                        case 56:
                            setPlaylistNum(input.readInt32());
                            continue;
                        case 66:
                            setSongId(input.readString());
                            continue;
                        case NavCarInfo.CarType_57L /*72*/:
                            setMode(input.readInt32());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasSource() {
                return this.result.hasSource();
            }

            public String getSource() {
                return this.result.getSource();
            }

            public Builder setSource(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasSource = true;
                this.result.source_ = value;
                return this;
            }

            public Builder clearSource() {
                this.result.hasSource = false;
                this.result.source_ = CarlifeMediaInfo.getDefaultInstance().getSource();
                return this;
            }

            public boolean hasSong() {
                return this.result.hasSong();
            }

            public String getSong() {
                return this.result.getSong();
            }

            public Builder setSong(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasSong = true;
                this.result.song_ = value;
                return this;
            }

            public Builder clearSong() {
                this.result.hasSong = false;
                this.result.song_ = CarlifeMediaInfo.getDefaultInstance().getSong();
                return this;
            }

            public boolean hasArtist() {
                return this.result.hasArtist();
            }

            public String getArtist() {
                return this.result.getArtist();
            }

            public Builder setArtist(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasArtist = true;
                this.result.artist_ = value;
                return this;
            }

            public Builder clearArtist() {
                this.result.hasArtist = false;
                this.result.artist_ = CarlifeMediaInfo.getDefaultInstance().getArtist();
                return this;
            }

            public boolean hasAlbum() {
                return this.result.hasAlbum();
            }

            public String getAlbum() {
                return this.result.getAlbum();
            }

            public Builder setAlbum(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasAlbum = true;
                this.result.album_ = value;
                return this;
            }

            public Builder clearAlbum() {
                this.result.hasAlbum = false;
                this.result.album_ = CarlifeMediaInfo.getDefaultInstance().getAlbum();
                return this;
            }

            public boolean hasAlbumArt() {
                return this.result.hasAlbumArt();
            }

            public ByteString getAlbumArt() {
                return this.result.getAlbumArt();
            }

            public Builder setAlbumArt(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasAlbumArt = true;
                this.result.albumArt_ = value;
                return this;
            }

            public Builder clearAlbumArt() {
                this.result.hasAlbumArt = false;
                this.result.albumArt_ = CarlifeMediaInfo.getDefaultInstance().getAlbumArt();
                return this;
            }

            public boolean hasDuration() {
                return this.result.hasDuration();
            }

            public int getDuration() {
                return this.result.getDuration();
            }

            public Builder setDuration(int value) {
                this.result.hasDuration = true;
                this.result.duration_ = value;
                return this;
            }

            public Builder clearDuration() {
                this.result.hasDuration = false;
                this.result.duration_ = 0;
                return this;
            }

            public boolean hasPlaylistNum() {
                return this.result.hasPlaylistNum();
            }

            public int getPlaylistNum() {
                return this.result.getPlaylistNum();
            }

            public Builder setPlaylistNum(int value) {
                this.result.hasPlaylistNum = true;
                this.result.playlistNum_ = value;
                return this;
            }

            public Builder clearPlaylistNum() {
                this.result.hasPlaylistNum = false;
                this.result.playlistNum_ = 0;
                return this;
            }

            public boolean hasSongId() {
                return this.result.hasSongId();
            }

            public String getSongId() {
                return this.result.getSongId();
            }

            public Builder setSongId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasSongId = true;
                this.result.songId_ = value;
                return this;
            }

            public Builder clearSongId() {
                this.result.hasSongId = false;
                this.result.songId_ = CarlifeMediaInfo.getDefaultInstance().getSongId();
                return this;
            }

            public boolean hasMode() {
                return this.result.hasMode();
            }

            public int getMode() {
                return this.result.getMode();
            }

            public Builder setMode(int value) {
                this.result.hasMode = true;
                this.result.mode_ = value;
                return this;
            }

            public Builder clearMode() {
                this.result.hasMode = false;
                this.result.mode_ = 0;
                return this;
            }
        }

        private CarlifeMediaInfo() {
            this.source_ = "";
            this.song_ = "";
            this.artist_ = "";
            this.album_ = "";
            this.albumArt_ = ByteString.EMPTY;
            this.duration_ = 0;
            this.playlistNum_ = 0;
            this.songId_ = "";
            this.mode_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeMediaInfoProto.getDescriptor();
            CarlifeMediaInfoProto.internalForceInit();
        }

        public static CarlifeMediaInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeMediaInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeMediaInfoProto.f6629xbc894558;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeMediaInfoProto.f6630xb06993d6;
        }

        public boolean hasSource() {
            return this.hasSource;
        }

        public String getSource() {
            return this.source_;
        }

        public boolean hasSong() {
            return this.hasSong;
        }

        public String getSong() {
            return this.song_;
        }

        public boolean hasArtist() {
            return this.hasArtist;
        }

        public String getArtist() {
            return this.artist_;
        }

        public boolean hasAlbum() {
            return this.hasAlbum;
        }

        public String getAlbum() {
            return this.album_;
        }

        public boolean hasAlbumArt() {
            return this.hasAlbumArt;
        }

        public ByteString getAlbumArt() {
            return this.albumArt_;
        }

        public boolean hasDuration() {
            return this.hasDuration;
        }

        public int getDuration() {
            return this.duration_;
        }

        public boolean hasPlaylistNum() {
            return this.hasPlaylistNum;
        }

        public int getPlaylistNum() {
            return this.playlistNum_;
        }

        public boolean hasSongId() {
            return this.hasSongId;
        }

        public String getSongId() {
            return this.songId_;
        }

        public boolean hasMode() {
            return this.hasMode;
        }

        public int getMode() {
            return this.mode_;
        }

        public final boolean isInitialized() {
            if (this.hasSource && this.hasSong && this.hasArtist && this.hasAlbum && this.hasAlbumArt && this.hasDuration && this.hasPlaylistNum && this.hasSongId && this.hasMode) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasSource()) {
                output.writeString(1, getSource());
            }
            if (hasSong()) {
                output.writeString(2, getSong());
            }
            if (hasArtist()) {
                output.writeString(3, getArtist());
            }
            if (hasAlbum()) {
                output.writeString(4, getAlbum());
            }
            if (hasAlbumArt()) {
                output.writeBytes(5, getAlbumArt());
            }
            if (hasDuration()) {
                output.writeInt32(6, getDuration());
            }
            if (hasPlaylistNum()) {
                output.writeInt32(7, getPlaylistNum());
            }
            if (hasSongId()) {
                output.writeString(8, getSongId());
            }
            if (hasMode()) {
                output.writeInt32(9, getMode());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasSource()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getSource());
            }
            if (hasSong()) {
                size += CodedOutputStream.computeStringSize(2, getSong());
            }
            if (hasArtist()) {
                size += CodedOutputStream.computeStringSize(3, getArtist());
            }
            if (hasAlbum()) {
                size += CodedOutputStream.computeStringSize(4, getAlbum());
            }
            if (hasAlbumArt()) {
                size += CodedOutputStream.computeBytesSize(5, getAlbumArt());
            }
            if (hasDuration()) {
                size += CodedOutputStream.computeInt32Size(6, getDuration());
            }
            if (hasPlaylistNum()) {
                size += CodedOutputStream.computeInt32Size(7, getPlaylistNum());
            }
            if (hasSongId()) {
                size += CodedOutputStream.computeStringSize(8, getSongId());
            }
            if (hasMode()) {
                size += CodedOutputStream.computeInt32Size(9, getMode());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeMediaInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeMediaInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeMediaInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeMediaInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeMediaInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeMediaInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeMediaInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeMediaInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bCarlifeMediaInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"¦\u0001\n\u0010CarlifeMediaInfo\u0012\u000e\n\u0006source\u0018\u0001 \u0002(\t\u0012\f\n\u0004song\u0018\u0002 \u0002(\t\u0012\u000e\n\u0006artist\u0018\u0003 \u0002(\t\u0012\r\n\u0005album\u0018\u0004 \u0002(\t\u0012\u0010\n\balbumArt\u0018\u0005 \u0002(\f\u0012\u0010\n\bduration\u0018\u0006 \u0002(\u0005\u0012\u0013\n\u000bplaylistNum\u0018\u0007 \u0002(\u0005\u0012\u000e\n\u0006songId\u0018\b \u0002(\t\u0012\f\n\u0004mode\u0018\t \u0002(\u0005"}, new FileDescriptor[0], new C20691());
    }

    public static void internalForceInit() {
    }
}
