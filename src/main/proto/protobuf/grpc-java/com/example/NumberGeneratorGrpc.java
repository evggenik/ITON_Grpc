package com.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: NumberGeneratorService.proto")
public final class NumberGeneratorGrpc {

  private NumberGeneratorGrpc() {}

  public static final String SERVICE_NAME = "NumberGenerator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.NumberGeneratorRequest,
      com.example.GenerateNumberResponse> getGenerateNumberStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateNumberStream",
      requestType = com.example.NumberGeneratorRequest.class,
      responseType = com.example.GenerateNumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.NumberGeneratorRequest,
      com.example.GenerateNumberResponse> getGenerateNumberStreamMethod() {
    io.grpc.MethodDescriptor<com.example.NumberGeneratorRequest, com.example.GenerateNumberResponse> getGenerateNumberStreamMethod;
    if ((getGenerateNumberStreamMethod = NumberGeneratorGrpc.getGenerateNumberStreamMethod) == null) {
      synchronized (NumberGeneratorGrpc.class) {
        if ((getGenerateNumberStreamMethod = NumberGeneratorGrpc.getGenerateNumberStreamMethod) == null) {
          NumberGeneratorGrpc.getGenerateNumberStreamMethod = getGenerateNumberStreamMethod =
              io.grpc.MethodDescriptor.<com.example.NumberGeneratorRequest, com.example.GenerateNumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateNumberStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.NumberGeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.GenerateNumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NumberGeneratorMethodDescriptorSupplier("GenerateNumberStream"))
              .build();
        }
      }
    }
    return getGenerateNumberStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NumberGeneratorStub newStub(io.grpc.Channel channel) {
    return new NumberGeneratorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NumberGeneratorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NumberGeneratorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NumberGeneratorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NumberGeneratorFutureStub(channel);
  }

  /**
   */
  public static abstract class NumberGeneratorImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateNumberStream(com.example.NumberGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.example.GenerateNumberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateNumberStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateNumberStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.NumberGeneratorRequest,
                com.example.GenerateNumberResponse>(
                  this, METHODID_GENERATE_NUMBER_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class NumberGeneratorStub extends io.grpc.stub.AbstractStub<NumberGeneratorStub> {
    private NumberGeneratorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NumberGeneratorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NumberGeneratorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NumberGeneratorStub(channel, callOptions);
    }

    /**
     */
    public void generateNumberStream(com.example.NumberGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.example.GenerateNumberResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGenerateNumberStreamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NumberGeneratorBlockingStub extends io.grpc.stub.AbstractStub<NumberGeneratorBlockingStub> {
    private NumberGeneratorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NumberGeneratorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NumberGeneratorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NumberGeneratorBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.GenerateNumberResponse> generateNumberStream(
        com.example.NumberGeneratorRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGenerateNumberStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NumberGeneratorFutureStub extends io.grpc.stub.AbstractStub<NumberGeneratorFutureStub> {
    private NumberGeneratorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NumberGeneratorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NumberGeneratorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NumberGeneratorFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GENERATE_NUMBER_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NumberGeneratorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NumberGeneratorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_NUMBER_STREAM:
          serviceImpl.generateNumberStream((com.example.NumberGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<com.example.GenerateNumberResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class NumberGeneratorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NumberGeneratorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.NumberGeneratorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NumberGenerator");
    }
  }

  private static final class NumberGeneratorFileDescriptorSupplier
      extends NumberGeneratorBaseDescriptorSupplier {
    NumberGeneratorFileDescriptorSupplier() {}
  }

  private static final class NumberGeneratorMethodDescriptorSupplier
      extends NumberGeneratorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NumberGeneratorMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NumberGeneratorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NumberGeneratorFileDescriptorSupplier())
              .addMethod(getGenerateNumberStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
