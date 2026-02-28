package org.example;

import jakarta.xml.ws.Endpoint;

public class MyFirstSOAPPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:7779/ws/first", new MyFirstWS());
        System.out.println("Usługa SOAP działa na: http://localhost:7779/ws/first?wsdl");
    }
}