// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: feedback.proto

package org.opennms.alec.datasource.opennms.proto;

public final class FeedbackModelProtos {
  private FeedbackModelProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AlarmFeedbacksOrBuilder extends
      // @@protoc_insertion_point(interface_extends:AlarmFeedbacks)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    java.util.List<OpennmsModelProtos.AlarmFeedback>
        getAlarmFeedbackList();
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    OpennmsModelProtos.AlarmFeedback getAlarmFeedback(int index);
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    int getAlarmFeedbackCount();
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    java.util.List<? extends OpennmsModelProtos.AlarmFeedbackOrBuilder>
        getAlarmFeedbackOrBuilderList();
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    OpennmsModelProtos.AlarmFeedbackOrBuilder getAlarmFeedbackOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code AlarmFeedbacks}
   */
  public  static final class AlarmFeedbacks extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:AlarmFeedbacks)
      AlarmFeedbacksOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AlarmFeedbacks.newBuilder() to construct.
    private AlarmFeedbacks(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AlarmFeedbacks() {
      alarmFeedback_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AlarmFeedbacks(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 82: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                alarmFeedback_ = new java.util.ArrayList<OpennmsModelProtos.AlarmFeedback>();
                mutable_bitField0_ |= 0x00000001;
              }
              alarmFeedback_.add(
                  input.readMessage(OpennmsModelProtos.AlarmFeedback.parser(), extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          alarmFeedback_ = java.util.Collections.unmodifiableList(alarmFeedback_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return FeedbackModelProtos.internal_static_AlarmFeedbacks_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return FeedbackModelProtos.internal_static_AlarmFeedbacks_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              FeedbackModelProtos.AlarmFeedbacks.class, FeedbackModelProtos.AlarmFeedbacks.Builder.class);
    }

    public static final int ALARM_FEEDBACK_FIELD_NUMBER = 10;
    private java.util.List<OpennmsModelProtos.AlarmFeedback> alarmFeedback_;
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    public java.util.List<OpennmsModelProtos.AlarmFeedback> getAlarmFeedbackList() {
      return alarmFeedback_;
    }
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    public java.util.List<? extends OpennmsModelProtos.AlarmFeedbackOrBuilder>
        getAlarmFeedbackOrBuilderList() {
      return alarmFeedback_;
    }
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    public int getAlarmFeedbackCount() {
      return alarmFeedback_.size();
    }
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    public OpennmsModelProtos.AlarmFeedback getAlarmFeedback(int index) {
      return alarmFeedback_.get(index);
    }
    /**
     * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
     */
    public OpennmsModelProtos.AlarmFeedbackOrBuilder getAlarmFeedbackOrBuilder(
        int index) {
      return alarmFeedback_.get(index);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      for (int i = 0; i < alarmFeedback_.size(); i++) {
        output.writeMessage(10, alarmFeedback_.get(i));
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < alarmFeedback_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(10, alarmFeedback_.get(i));
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof FeedbackModelProtos.AlarmFeedbacks)) {
        return super.equals(obj);
      }
      FeedbackModelProtos.AlarmFeedbacks other = (FeedbackModelProtos.AlarmFeedbacks) obj;

      boolean result = true;
      result = result && getAlarmFeedbackList()
          .equals(other.getAlarmFeedbackList());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (getAlarmFeedbackCount() > 0) {
        hash = (37 * hash) + ALARM_FEEDBACK_FIELD_NUMBER;
        hash = (53 * hash) + getAlarmFeedbackList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static FeedbackModelProtos.AlarmFeedbacks parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(FeedbackModelProtos.AlarmFeedbacks prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code AlarmFeedbacks}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:AlarmFeedbacks)
        FeedbackModelProtos.AlarmFeedbacksOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return FeedbackModelProtos.internal_static_AlarmFeedbacks_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return FeedbackModelProtos.internal_static_AlarmFeedbacks_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                FeedbackModelProtos.AlarmFeedbacks.class, FeedbackModelProtos.AlarmFeedbacks.Builder.class);
      }

      // Construct using FeedbackModelProtos.AlarmFeedbacks.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
          getAlarmFeedbackFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        if (alarmFeedbackBuilder_ == null) {
          alarmFeedback_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          alarmFeedbackBuilder_.clear();
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return FeedbackModelProtos.internal_static_AlarmFeedbacks_descriptor;
      }

      public FeedbackModelProtos.AlarmFeedbacks getDefaultInstanceForType() {
        return FeedbackModelProtos.AlarmFeedbacks.getDefaultInstance();
      }

      public FeedbackModelProtos.AlarmFeedbacks build() {
        FeedbackModelProtos.AlarmFeedbacks result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public FeedbackModelProtos.AlarmFeedbacks buildPartial() {
        FeedbackModelProtos.AlarmFeedbacks result = new FeedbackModelProtos.AlarmFeedbacks(this);
        int from_bitField0_ = bitField0_;
        if (alarmFeedbackBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            alarmFeedback_ = java.util.Collections.unmodifiableList(alarmFeedback_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.alarmFeedback_ = alarmFeedback_;
        } else {
          result.alarmFeedback_ = alarmFeedbackBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof FeedbackModelProtos.AlarmFeedbacks) {
          return mergeFrom((FeedbackModelProtos.AlarmFeedbacks)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(FeedbackModelProtos.AlarmFeedbacks other) {
        if (other == FeedbackModelProtos.AlarmFeedbacks.getDefaultInstance()) return this;
        if (alarmFeedbackBuilder_ == null) {
          if (!other.alarmFeedback_.isEmpty()) {
            if (alarmFeedback_.isEmpty()) {
              alarmFeedback_ = other.alarmFeedback_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureAlarmFeedbackIsMutable();
              alarmFeedback_.addAll(other.alarmFeedback_);
            }
            onChanged();
          }
        } else {
          if (!other.alarmFeedback_.isEmpty()) {
            if (alarmFeedbackBuilder_.isEmpty()) {
              alarmFeedbackBuilder_.dispose();
              alarmFeedbackBuilder_ = null;
              alarmFeedback_ = other.alarmFeedback_;
              bitField0_ = (bitField0_ & ~0x00000001);
              alarmFeedbackBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getAlarmFeedbackFieldBuilder() : null;
            } else {
              alarmFeedbackBuilder_.addAllMessages(other.alarmFeedback_);
            }
          }
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        FeedbackModelProtos.AlarmFeedbacks parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (FeedbackModelProtos.AlarmFeedbacks) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<OpennmsModelProtos.AlarmFeedback> alarmFeedback_ =
        java.util.Collections.emptyList();
      private void ensureAlarmFeedbackIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          alarmFeedback_ = new java.util.ArrayList<OpennmsModelProtos.AlarmFeedback>(alarmFeedback_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          OpennmsModelProtos.AlarmFeedback, OpennmsModelProtos.AlarmFeedback.Builder, OpennmsModelProtos.AlarmFeedbackOrBuilder> alarmFeedbackBuilder_;

      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public java.util.List<OpennmsModelProtos.AlarmFeedback> getAlarmFeedbackList() {
        if (alarmFeedbackBuilder_ == null) {
          return java.util.Collections.unmodifiableList(alarmFeedback_);
        } else {
          return alarmFeedbackBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public int getAlarmFeedbackCount() {
        if (alarmFeedbackBuilder_ == null) {
          return alarmFeedback_.size();
        } else {
          return alarmFeedbackBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public OpennmsModelProtos.AlarmFeedback getAlarmFeedback(int index) {
        if (alarmFeedbackBuilder_ == null) {
          return alarmFeedback_.get(index);
        } else {
          return alarmFeedbackBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder setAlarmFeedback(
          int index, OpennmsModelProtos.AlarmFeedback value) {
        if (alarmFeedbackBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAlarmFeedbackIsMutable();
          alarmFeedback_.set(index, value);
          onChanged();
        } else {
          alarmFeedbackBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder setAlarmFeedback(
          int index, OpennmsModelProtos.AlarmFeedback.Builder builderForValue) {
        if (alarmFeedbackBuilder_ == null) {
          ensureAlarmFeedbackIsMutable();
          alarmFeedback_.set(index, builderForValue.build());
          onChanged();
        } else {
          alarmFeedbackBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder addAlarmFeedback(OpennmsModelProtos.AlarmFeedback value) {
        if (alarmFeedbackBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAlarmFeedbackIsMutable();
          alarmFeedback_.add(value);
          onChanged();
        } else {
          alarmFeedbackBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder addAlarmFeedback(
          int index, OpennmsModelProtos.AlarmFeedback value) {
        if (alarmFeedbackBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAlarmFeedbackIsMutable();
          alarmFeedback_.add(index, value);
          onChanged();
        } else {
          alarmFeedbackBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder addAlarmFeedback(
          OpennmsModelProtos.AlarmFeedback.Builder builderForValue) {
        if (alarmFeedbackBuilder_ == null) {
          ensureAlarmFeedbackIsMutable();
          alarmFeedback_.add(builderForValue.build());
          onChanged();
        } else {
          alarmFeedbackBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder addAlarmFeedback(
          int index, OpennmsModelProtos.AlarmFeedback.Builder builderForValue) {
        if (alarmFeedbackBuilder_ == null) {
          ensureAlarmFeedbackIsMutable();
          alarmFeedback_.add(index, builderForValue.build());
          onChanged();
        } else {
          alarmFeedbackBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder addAllAlarmFeedback(
          java.lang.Iterable<? extends OpennmsModelProtos.AlarmFeedback> values) {
        if (alarmFeedbackBuilder_ == null) {
          ensureAlarmFeedbackIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, alarmFeedback_);
          onChanged();
        } else {
          alarmFeedbackBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder clearAlarmFeedback() {
        if (alarmFeedbackBuilder_ == null) {
          alarmFeedback_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          alarmFeedbackBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public Builder removeAlarmFeedback(int index) {
        if (alarmFeedbackBuilder_ == null) {
          ensureAlarmFeedbackIsMutable();
          alarmFeedback_.remove(index);
          onChanged();
        } else {
          alarmFeedbackBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public OpennmsModelProtos.AlarmFeedback.Builder getAlarmFeedbackBuilder(
          int index) {
        return getAlarmFeedbackFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public OpennmsModelProtos.AlarmFeedbackOrBuilder getAlarmFeedbackOrBuilder(
          int index) {
        if (alarmFeedbackBuilder_ == null) {
          return alarmFeedback_.get(index);  } else {
          return alarmFeedbackBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public java.util.List<? extends OpennmsModelProtos.AlarmFeedbackOrBuilder>
           getAlarmFeedbackOrBuilderList() {
        if (alarmFeedbackBuilder_ != null) {
          return alarmFeedbackBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(alarmFeedback_);
        }
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public OpennmsModelProtos.AlarmFeedback.Builder addAlarmFeedbackBuilder() {
        return getAlarmFeedbackFieldBuilder().addBuilder(
            OpennmsModelProtos.AlarmFeedback.getDefaultInstance());
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public OpennmsModelProtos.AlarmFeedback.Builder addAlarmFeedbackBuilder(
          int index) {
        return getAlarmFeedbackFieldBuilder().addBuilder(
            index, OpennmsModelProtos.AlarmFeedback.getDefaultInstance());
      }
      /**
       * <code>repeated .AlarmFeedback alarm_feedback = 10;</code>
       */
      public java.util.List<OpennmsModelProtos.AlarmFeedback.Builder>
           getAlarmFeedbackBuilderList() {
        return getAlarmFeedbackFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          OpennmsModelProtos.AlarmFeedback, OpennmsModelProtos.AlarmFeedback.Builder, OpennmsModelProtos.AlarmFeedbackOrBuilder>
          getAlarmFeedbackFieldBuilder() {
        if (alarmFeedbackBuilder_ == null) {
          alarmFeedbackBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              OpennmsModelProtos.AlarmFeedback, OpennmsModelProtos.AlarmFeedback.Builder, OpennmsModelProtos.AlarmFeedbackOrBuilder>(
                  alarmFeedback_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          alarmFeedback_ = null;
        }
        return alarmFeedbackBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:AlarmFeedbacks)
    }

    // @@protoc_insertion_point(class_scope:AlarmFeedbacks)
    private static final FeedbackModelProtos.AlarmFeedbacks DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new FeedbackModelProtos.AlarmFeedbacks();
    }

    public static FeedbackModelProtos.AlarmFeedbacks getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AlarmFeedbacks>
        PARSER = new com.google.protobuf.AbstractParser<AlarmFeedbacks>() {
      public AlarmFeedbacks parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AlarmFeedbacks(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AlarmFeedbacks> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AlarmFeedbacks> getParserForType() {
      return PARSER;
    }

    public FeedbackModelProtos.AlarmFeedbacks getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AlarmFeedbacks_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AlarmFeedbacks_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016feedback.proto\032\034opennms-kafka-producer" +
      ".proto\"8\n\016AlarmFeedbacks\022&\n\016alarm_feedba" +
      "ck\030\n \003(\0132\016.AlarmFeedbackB?\n(org.opennms." +
      "oce.datasource.opennms.protoB\023FeedbackMo" +
      "delProtosb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          OpennmsModelProtos.getDescriptor(),
        }, assigner);
    internal_static_AlarmFeedbacks_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AlarmFeedbacks_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AlarmFeedbacks_descriptor,
        new java.lang.String[] { "AlarmFeedback", });
    OpennmsModelProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}