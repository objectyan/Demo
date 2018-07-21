package com.baidu.carlife.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class CarlifeMediaInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeMediaInfoProto.access$2302(paramAnonymousFileDescriptor);
        CarlifeMediaInfoProto.access$002((Descriptors.Descriptor)CarlifeMediaInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeMediaInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeMediaInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfo_descriptor, new String[] { "Source", "Song", "Artist", "Album", "AlbumArt", "Duration", "PlaylistNum", "SongId", "Mode" }, CarlifeMediaInfoProto.CarlifeMediaInfo.class, CarlifeMediaInfoProto.CarlifeMediaInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\033CarlifeMediaInfoProto.proto\022\032com.baidu.carlife.protobuf\"¦\001\n\020CarlifeMediaInfo\022\016\n\006source\030\001 \002(\t\022\f\n\004song\030\002 \002(\t\022\016\n\006artist\030\003 \002(\t\022\r\n\005album\030\004 \002(\t\022\020\n\balbumArt\030\005 \002(\f\022\020\n\bduration\030\006 \002(\005\022\023\n\013playlistNum\030\007 \002(\005\022\016\n\006songId\030\b \002(\t\022\f\n\004mode\030\t \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeMediaInfo
    extends GeneratedMessage
  {
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
    private ByteString albumArt_ = ByteString.EMPTY;
    private String album_ = "";
    private String artist_ = "";
    private int duration_ = 0;
    private boolean hasAlbum;
    private boolean hasAlbumArt;
    private boolean hasArtist;
    private boolean hasDuration;
    private boolean hasMode;
    private boolean hasPlaylistNum;
    private boolean hasSong;
    private boolean hasSongId;
    private boolean hasSource;
    private int memoizedSerializedSize = -1;
    private int mode_ = 0;
    private int playlistNum_ = 0;
    private String songId_ = "";
    private String song_ = "";
    private String source_ = "";
    
    static
    {
      CarlifeMediaInfoProto.getDescriptor();
      CarlifeMediaInfoProto.internalForceInit();
    }
    
    public static CarlifeMediaInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeMediaInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeMediaInfo paramCarlifeMediaInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeMediaInfo);
    }
    
    public static CarlifeMediaInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMediaInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeMediaInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeMediaInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeMediaInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMediaInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeMediaInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAlbum()
    {
      return this.album_;
    }
    
    public ByteString getAlbumArt()
    {
      return this.albumArt_;
    }
    
    public String getArtist()
    {
      return this.artist_;
    }
    
    public CarlifeMediaInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getDuration()
    {
      return this.duration_;
    }
    
    public int getMode()
    {
      return this.mode_;
    }
    
    public int getPlaylistNum()
    {
      return this.playlistNum_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasSource()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getSource());
      }
      i = j;
      if (hasSong()) {
        i = j + CodedOutputStream.computeStringSize(2, getSong());
      }
      j = i;
      if (hasArtist()) {
        j = i + CodedOutputStream.computeStringSize(3, getArtist());
      }
      i = j;
      if (hasAlbum()) {
        i = j + CodedOutputStream.computeStringSize(4, getAlbum());
      }
      j = i;
      if (hasAlbumArt()) {
        j = i + CodedOutputStream.computeBytesSize(5, getAlbumArt());
      }
      i = j;
      if (hasDuration()) {
        i = j + CodedOutputStream.computeInt32Size(6, getDuration());
      }
      j = i;
      if (hasPlaylistNum()) {
        j = i + CodedOutputStream.computeInt32Size(7, getPlaylistNum());
      }
      i = j;
      if (hasSongId()) {
        i = j + CodedOutputStream.computeStringSize(8, getSongId());
      }
      j = i;
      if (hasMode()) {
        j = i + CodedOutputStream.computeInt32Size(9, getMode());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getSong()
    {
      return this.song_;
    }
    
    public String getSongId()
    {
      return this.songId_;
    }
    
    public String getSource()
    {
      return this.source_;
    }
    
    public boolean hasAlbum()
    {
      return this.hasAlbum;
    }
    
    public boolean hasAlbumArt()
    {
      return this.hasAlbumArt;
    }
    
    public boolean hasArtist()
    {
      return this.hasArtist;
    }
    
    public boolean hasDuration()
    {
      return this.hasDuration;
    }
    
    public boolean hasMode()
    {
      return this.hasMode;
    }
    
    public boolean hasPlaylistNum()
    {
      return this.hasPlaylistNum;
    }
    
    public boolean hasSong()
    {
      return this.hasSong;
    }
    
    public boolean hasSongId()
    {
      return this.hasSongId;
    }
    
    public boolean hasSource()
    {
      return this.hasSource;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeMediaInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasSource) {}
      while ((!this.hasSong) || (!this.hasArtist) || (!this.hasAlbum) || (!this.hasAlbumArt) || (!this.hasDuration) || (!this.hasPlaylistNum) || (!this.hasSongId) || (!this.hasMode)) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasSource()) {
        paramCodedOutputStream.writeString(1, getSource());
      }
      if (hasSong()) {
        paramCodedOutputStream.writeString(2, getSong());
      }
      if (hasArtist()) {
        paramCodedOutputStream.writeString(3, getArtist());
      }
      if (hasAlbum()) {
        paramCodedOutputStream.writeString(4, getAlbum());
      }
      if (hasAlbumArt()) {
        paramCodedOutputStream.writeBytes(5, getAlbumArt());
      }
      if (hasDuration()) {
        paramCodedOutputStream.writeInt32(6, getDuration());
      }
      if (hasPlaylistNum()) {
        paramCodedOutputStream.writeInt32(7, getPlaylistNum());
      }
      if (hasSongId()) {
        paramCodedOutputStream.writeString(8, getSongId());
      }
      if (hasMode()) {
        paramCodedOutputStream.writeInt32(9, getMode());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeMediaInfoProto.CarlifeMediaInfo result;
      
      private CarlifeMediaInfoProto.CarlifeMediaInfo buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new CarlifeMediaInfoProto.CarlifeMediaInfo(null);
        return localBuilder;
      }
      
      public CarlifeMediaInfoProto.CarlifeMediaInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeMediaInfoProto.CarlifeMediaInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeMediaInfoProto.CarlifeMediaInfo localCarlifeMediaInfo = this.result;
        this.result = null;
        return localCarlifeMediaInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeMediaInfoProto.CarlifeMediaInfo(null);
        return this;
      }
      
      public Builder clearAlbum()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1102(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1202(this.result, CarlifeMediaInfoProto.CarlifeMediaInfo.getDefaultInstance().getAlbum());
        return this;
      }
      
      public Builder clearAlbumArt()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1302(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1402(this.result, CarlifeMediaInfoProto.CarlifeMediaInfo.getDefaultInstance().getAlbumArt());
        return this;
      }
      
      public Builder clearArtist()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$902(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1002(this.result, CarlifeMediaInfoProto.CarlifeMediaInfo.getDefaultInstance().getArtist());
        return this;
      }
      
      public Builder clearDuration()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1502(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1602(this.result, 0);
        return this;
      }
      
      public Builder clearMode()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$2102(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$2202(this.result, 0);
        return this;
      }
      
      public Builder clearPlaylistNum()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1702(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1802(this.result, 0);
        return this;
      }
      
      public Builder clearSong()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$702(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$802(this.result, CarlifeMediaInfoProto.CarlifeMediaInfo.getDefaultInstance().getSong());
        return this;
      }
      
      public Builder clearSongId()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1902(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$2002(this.result, CarlifeMediaInfoProto.CarlifeMediaInfo.getDefaultInstance().getSongId());
        return this;
      }
      
      public Builder clearSource()
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$502(this.result, false);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$602(this.result, CarlifeMediaInfoProto.CarlifeMediaInfo.getDefaultInstance().getSource());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public String getAlbum()
      {
        return this.result.getAlbum();
      }
      
      public ByteString getAlbumArt()
      {
        return this.result.getAlbumArt();
      }
      
      public String getArtist()
      {
        return this.result.getArtist();
      }
      
      public CarlifeMediaInfoProto.CarlifeMediaInfo getDefaultInstanceForType()
      {
        return CarlifeMediaInfoProto.CarlifeMediaInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeMediaInfoProto.CarlifeMediaInfo.getDescriptor();
      }
      
      public int getDuration()
      {
        return this.result.getDuration();
      }
      
      public int getMode()
      {
        return this.result.getMode();
      }
      
      public int getPlaylistNum()
      {
        return this.result.getPlaylistNum();
      }
      
      public String getSong()
      {
        return this.result.getSong();
      }
      
      public String getSongId()
      {
        return this.result.getSongId();
      }
      
      public String getSource()
      {
        return this.result.getSource();
      }
      
      public boolean hasAlbum()
      {
        return this.result.hasAlbum();
      }
      
      public boolean hasAlbumArt()
      {
        return this.result.hasAlbumArt();
      }
      
      public boolean hasArtist()
      {
        return this.result.hasArtist();
      }
      
      public boolean hasDuration()
      {
        return this.result.hasDuration();
      }
      
      public boolean hasMode()
      {
        return this.result.hasMode();
      }
      
      public boolean hasPlaylistNum()
      {
        return this.result.hasPlaylistNum();
      }
      
      public boolean hasSong()
      {
        return this.result.hasSong();
      }
      
      public boolean hasSongId()
      {
        return this.result.hasSongId();
      }
      
      public boolean hasSource()
      {
        return this.result.hasSource();
      }
      
      protected CarlifeMediaInfoProto.CarlifeMediaInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeMediaInfoProto.CarlifeMediaInfo paramCarlifeMediaInfo)
      {
        if (paramCarlifeMediaInfo == CarlifeMediaInfoProto.CarlifeMediaInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeMediaInfo.hasSource()) {
          setSource(paramCarlifeMediaInfo.getSource());
        }
        if (paramCarlifeMediaInfo.hasSong()) {
          setSong(paramCarlifeMediaInfo.getSong());
        }
        if (paramCarlifeMediaInfo.hasArtist()) {
          setArtist(paramCarlifeMediaInfo.getArtist());
        }
        if (paramCarlifeMediaInfo.hasAlbum()) {
          setAlbum(paramCarlifeMediaInfo.getAlbum());
        }
        if (paramCarlifeMediaInfo.hasAlbumArt()) {
          setAlbumArt(paramCarlifeMediaInfo.getAlbumArt());
        }
        if (paramCarlifeMediaInfo.hasDuration()) {
          setDuration(paramCarlifeMediaInfo.getDuration());
        }
        if (paramCarlifeMediaInfo.hasPlaylistNum()) {
          setPlaylistNum(paramCarlifeMediaInfo.getPlaylistNum());
        }
        if (paramCarlifeMediaInfo.hasSongId()) {
          setSongId(paramCarlifeMediaInfo.getSongId());
        }
        if (paramCarlifeMediaInfo.hasMode()) {
          setMode(paramCarlifeMediaInfo.getMode());
        }
        mergeUnknownFields(paramCarlifeMediaInfo.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setSource(paramCodedInputStream.readString());
            break;
          case 18: 
            setSong(paramCodedInputStream.readString());
            break;
          case 26: 
            setArtist(paramCodedInputStream.readString());
            break;
          case 34: 
            setAlbum(paramCodedInputStream.readString());
            break;
          case 42: 
            setAlbumArt(paramCodedInputStream.readBytes());
            break;
          case 48: 
            setDuration(paramCodedInputStream.readInt32());
            break;
          case 56: 
            setPlaylistNum(paramCodedInputStream.readInt32());
            break;
          case 66: 
            setSongId(paramCodedInputStream.readString());
            break;
          case 72: 
            setMode(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeMediaInfoProto.CarlifeMediaInfo)) {
          return mergeFrom((CarlifeMediaInfoProto.CarlifeMediaInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAlbum(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1102(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1202(this.result, paramString);
        return this;
      }
      
      public Builder setAlbumArt(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1302(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1402(this.result, paramByteString);
        return this;
      }
      
      public Builder setArtist(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$902(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1002(this.result, paramString);
        return this;
      }
      
      public Builder setDuration(int paramInt)
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1502(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1602(this.result, paramInt);
        return this;
      }
      
      public Builder setMode(int paramInt)
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$2102(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$2202(this.result, paramInt);
        return this;
      }
      
      public Builder setPlaylistNum(int paramInt)
      {
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1702(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1802(this.result, paramInt);
        return this;
      }
      
      public Builder setSong(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$702(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$802(this.result, paramString);
        return this;
      }
      
      public Builder setSongId(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$1902(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$2002(this.result, paramString);
        return this;
      }
      
      public Builder setSource(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$502(this.result, true);
        CarlifeMediaInfoProto.CarlifeMediaInfo.access$602(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeMediaInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */