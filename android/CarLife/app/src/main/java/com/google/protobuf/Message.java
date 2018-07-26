package com.google.protobuf;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface Message extends MessageLite {

    public interface Builder extends com.google.protobuf.MessageLite.Builder {
        Builder addRepeatedField(FieldDescriptor fieldDescriptor, Object obj);

        Message build();

        Message buildPartial();

        Builder clear();

        Builder clearField(FieldDescriptor fieldDescriptor);

        Builder clone();

        Map<FieldDescriptor, Object> getAllFields();

        Message getDefaultInstanceForType();

        Descriptor getDescriptorForType();

        Object getField(FieldDescriptor fieldDescriptor);

        Object getRepeatedField(FieldDescriptor fieldDescriptor, int i);

        int getRepeatedFieldCount(FieldDescriptor fieldDescriptor);

        UnknownFieldSet getUnknownFields();

        boolean hasField(FieldDescriptor fieldDescriptor);

        Builder mergeDelimitedFrom(InputStream inputStream) throws IOException;

        Builder mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream codedInputStream) throws IOException;

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(Message message);

        Builder mergeFrom(InputStream inputStream) throws IOException;

        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet);

        Builder newBuilderForField(FieldDescriptor fieldDescriptor);

        Builder setField(FieldDescriptor fieldDescriptor, Object obj);

        Builder setRepeatedField(FieldDescriptor fieldDescriptor, int i, Object obj);

        Builder setUnknownFields(UnknownFieldSet unknownFieldSet);
    }

    boolean equals(Object obj);

    Map<FieldDescriptor, Object> getAllFields();

    Message getDefaultInstanceForType();

    Descriptor getDescriptorForType();

    Object getField(FieldDescriptor fieldDescriptor);

    Object getRepeatedField(FieldDescriptor fieldDescriptor, int i);

    int getRepeatedFieldCount(FieldDescriptor fieldDescriptor);

    UnknownFieldSet getUnknownFields();

    boolean hasField(FieldDescriptor fieldDescriptor);

    int hashCode();

    Builder newBuilderForType();

    Builder toBuilder();

    String toString();
}
