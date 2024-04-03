package org.example;

import protobuf.generated.GenerateNumberResponse;
import protobuf.generated.NumberGeneratorGrpc;
import protobuf.generated.NumberGeneratorRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class NumberGeneratorClient {
    private final ManagedChannel channel;
    private final NumberGeneratorGrpc.NumberGeneratorStub stub;
    private int lastReceivedNumber = 0;

    public NumberGeneratorClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        stub = NumberGeneratorGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void generateNumbers(int firstValue, int lastValue) {
        NumberGeneratorRequest request = NumberGeneratorRequest.newBuilder()
                .setFirstValue(firstValue)
                .setLastValue(lastValue)
                .build();


        stub.generateNumberStream(request, new StreamObserver<GenerateNumberResponse>() {
            @Override
            public void onNext(GenerateNumberResponse response) {
                lastReceivedNumber = response.getGeneratedNumber();
                System.out.println("Received number from server: " + lastReceivedNumber);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server completed sending numbers.");
            }
        });

        int currentValue = 0;
        while (currentValue <= 50) {
            System.out.println("currentValue: " + currentValue);
            currentValue += lastReceivedNumber + 1;
            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NumberGeneratorClient client = new NumberGeneratorClient("localhost", 8080);
        client.generateNumbers(0, 30);
        client.shutdown();
    }

}
