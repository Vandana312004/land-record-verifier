package com.mysql.demo;

import javax.xml.ws.Endpoint;

public class Publisher {

    public static void main(String[] args) {

        Endpoint.publish(
                "http://localhost:9091/landservice",
                new LandService());

        System.out.println(
                "SOAP Service Published Successfully");
    }
}