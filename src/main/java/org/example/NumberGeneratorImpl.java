package org.example;

import com.example.GenerateNumberResponse;
import com.example.NumberGeneratorGrpc;
import com.example.NumberGeneratorRequest;
import io.grpc.stub.StreamObserver;

// Класс реализации сервера
public class NumberGeneratorImpl extends NumberGeneratorGrpc.NumberGeneratorImplBase {
    @Override
    public void generateNumberStream(NumberGeneratorRequest request, StreamObserver<GenerateNumberResponse> responseObserver) {
        int firstValue = request.getFirstValue();
        int lastValue = request.getLastValue();
        for (int i = firstValue + 1; i <= lastValue; i++) {
            GenerateNumberResponse response = GenerateNumberResponse.newBuilder().setGeneratedNumber(i).build();
            responseObserver.onNext(response);
            try {
                Thread.sleep(2000); // ждем 2 секунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }

}
