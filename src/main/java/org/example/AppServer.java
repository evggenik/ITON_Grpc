package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

// Класс запуска сервера
public class AppServer {
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new NumberGeneratorImpl())
                .build();
        server.start();

        System.out.println( "Server started" );
        server.awaitTermination();



    }
}
